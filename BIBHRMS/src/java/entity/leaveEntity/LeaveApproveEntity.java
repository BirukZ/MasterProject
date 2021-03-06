/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import manager.leaveManager.LeaveApproveManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author user
 */
public class LeaveApproveEntity
        extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            closePooledConnections(_con);
        }
    }
    int leaveProcessedId;//LEAVE_PROCESSED_ID
    int requestId;//REQUEST_ID
    String processedBy;//PROCESSED_BY
    String commentGiven;//COMMENT_GIVEN
    String decision;//DECISION
    String recordedBy;//RECORDED_BY
    String timeStamp;//TIME_STAMP
    //===========================
    String nextState = "";

    public LeaveApproveEntity(int requestId, String processedBy, String commentGiven, String decision, String recordedBy, String timeStamp) {
        this.requestId = requestId;
        this.processedBy = processedBy;
        this.commentGiven = commentGiven;
        this.decision = decision;
        this.recordedBy = recordedBy;
        this.timeStamp = timeStamp;
    }

    public LeaveApproveEntity(int requestId, String processedBy, String commentGiven, String decision, String nextState, String recordedBy, String timeStamp) {
        this(requestId, processedBy, commentGiven, decision, recordedBy, timeStamp);
        this.nextState = nextState;

    }

    public LeaveApproveEntity(int leaveProcessedId, int requestId, String processedBy, String commentGiven, String decision, String recordedBy, String timeStamp) {
        this(requestId, processedBy, commentGiven, decision, recordedBy, timeStamp);
        this.leaveProcessedId = leaveProcessedId;
    }

    public LeaveApproveEntity(int leaveProcessedId) {
        this.leaveProcessedId = leaveProcessedId;
    }

    public LeaveApproveEntity() {
    }

    /**
     * Inserts leaveDecision attribute to the database.<br>
     * The constructor with full argument, must be called before calling this method
     */
    public boolean insertLeaveDecision(
            ArrayList<HashMap> listOfDestionMaked,
            String decision,
            String currentState,
            String commentGiven, String userId,
            String recorededDateAndTime) {
        boolean checkSave = false;
        PreparedStatement ps = null;
        PreparedStatement psUpdate = null;
        PreparedStatement psUpdateEmpStatus = null;
        String _insertQuery = "INSERT " +
                "INTO HR_LEAVE_PROCESSED " +
                "  ( " +
                "    LEAVE_PROCESSED_ID, " +
                "    REQUEST_ID, " +
                "    PROCESSED_BY, " +
                "    DECISION, " +
                "    COMMENT_GIVEN, " +
                "    RECORDED_BY, " +
                "    TIME_STAMP " +
                "  ) " +
                "   VALUES (HR_LEAVE_PROCESSED_SEQ.NEXTVAL, ?,?,?,?,?,?)  ";
        String _updateQuery = "UPDATE HR_EMP_LEAVE SET STATUS=? WHERE LEAVE_ID=?";
        String _updateEmployeeQuery = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='02' WHERE EMP_ID=?";
        try {
            for (HashMap hm : listOfDestionMaked) {
                checkBetweenTwoDateAvileblLeave(null, null, null);
            }
            _con = getConnection();
            _con.setAutoCommit(false);
            Savepoint firstSavePoint = _con.setSavepoint();
            for (HashMap hm : listOfDestionMaked) {
                ps = _con.prepareStatement(_insertQuery);
                ps.setString(1, hm.get("leaveRequestId").toString());
                ps.setString(2, hm.get("processedBy").toString());
                ps.setString(3, decision);//decision inserted to HR_LEAVE_PROCESSED table
                ps.setString(4, commentGiven);
                ps.setString(5, userId);
                ps.setString(6, recorededDateAndTime);
                if (ps.executeUpdate() > 0)
                {
                    psUpdate = _con.prepareStatement(_updateQuery);
                    psUpdate.setString(1, currentState); //status inserted to HR_LEAVE_REQUEST table
                    psUpdate.setString(2, hm.get("leaveRequestId").toString());
                    if (psUpdate.executeUpdate() > 0) {
                        String state[] = currentState.split("-");
                        if (state[0].equals("App")) {
                            psUpdateEmpStatus = _con.prepareStatement(_updateEmployeeQuery);
                            psUpdateEmpStatus.setString(1, hm.get("requesterId").toString());
                            if (psUpdateEmpStatus.executeUpdate() > 0) {
                                _con.commit();
                                return true;
                            } else {
                                _con.rollback(firstSavePoint);
                                return false;
                            }

                        } else {
                            _con.commit();
                            return true;
                        }

                    } else {
                        _con.rollback(firstSavePoint);
                        return false;
                    }

                } else {
                    _con.rollback(firstSavePoint);
                    return false;
                }
            }
            if (checkSave) {
                //  _con.commit();
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Retrives leave requests which can be processes by the user.
     * An employee has to see only requests which can be processes with his/her priviledge
     * @param  userName user name of the employee who logged in to the sysytem
     * processId =1 for the porcess leave
     * @throws  SQLException
     */
    public ResultSet selectApprovableRequest(String userName, String bossId) throws SQLException {
        String _innerSelectQuery = " SELECT PROCESS_STATE_ID " +
                "FROM BIB.TBL_PROCESS_STATE " +
                "WHERE PROCESS_STATE_ID IN " +
                "  (SELECT PROCESS_STATE_ID " +
                "  FROM BIB.tbl_authorization " +
                "  WHERE ROLE_NAME IN " +
                "    (SELECT ROLE_ID " +
                "    FROM BIB.tbl_role_user " +
                "    WHERE USER_ID= " +
                "      ( SELECT USER_ID FROM BIB.tbl_users WHERE USER_NAME='" + userName + "' " +
                "      ) " +
                "    ) " +
                "  AND PROCESS_STATE_ID IN " +
                "    (SELECT PROCESS_STATE_ID " +
                "    FROM BIB.TBL_PROCESS_STATE " +
                "    WHERE PROCESS_ID='" + LeaveApproveManager.PROCESS_LEAVE + "' " +
                "    ) " +
                "  )";
        String _selectQuery = " SELECT  le.EMP_ID," +
                "      REQUESTED_DATE," +
                "      LEAVE_ID," +
                "      STATUS," +
                " ei.first_name ||' '||" +
                " ei.middle_name||' '||" +
                " ei.last_name as fullname" +
                " FROM HR_EMP_LEAVE le INNER JOIN  " +
                " hr_employee_info ei " +
                " ON le.EMP_ID  =ei.EMP_ID " +
                " WHERE STATUS  IN (" + _innerSelectQuery + ")    " +
                " AND le.Emp_Id IN " +
                "(SELECT distinct EMP_ID " +
                "FROM HR_EMP_IMMEDIATE_BOSS " +
                " START WITH Bossid      ='" + bossId + "' " +
                " CONNECT BY nocycle prior EMP_ID=BOSSID ) " +
                "GROUP BY le.EMP_ID, " +
                "  REQUESTED_DATE, " +
                "  LEAVE_ID, " +
                "  STATUS, " +
                "  ei.first_name " +
                "  ||' ' " +
                "  || ei.middle_name " +
                "  ||' ' " +
                "  || ei.last_name " +
                "ORDER BY REQUESTED_DATE DESC";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of processed leave requests with their current status<br>
     * Basically intended to show the history of a  given leave request.
     * @param  the status of the request
     * @throws  SQLException
     */
    public ResultSet selectProcessedLeaveRequest(int requestId) throws SQLException {
        String _selectQuery = " SELECT HR_LEAVE_PROCESSED.*, " +
                " BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID," +
                " FIRST_NAME, MIDDLE_NAME, LAST_NAME ,PERMISSION_NAME" +
                " FROM HR_LEAVE_PROCESSED ,HR_EMPLOYEE_INFO ,BIB.TBL_PERMISSION ,BIB.TBL_PERMISSION,BIB.TBL_USERS " +
                " WHERE REQUEST_ID=" + requestId +
                " AND HR_EMPLOYEE_INFO.EMP_ID=HR_LEAVE_PROCESSED.PROCESSED_BY " +
                " AND BIB.TBL_USERS.user_name=RECORDED_BY " +
                " AND BIB.TBL_PERMISSION.CODE=DECISION" +
                " ORDER BY HR_LEAVE_PROCESSED.TIME_STAMP";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     *
     * @param requestId
     * @return
     */
    public ArrayList<HashMap> readEmployeeLeaveRequest(String employeeId,
            String leaveRequestStatus,
            String requesedDate) {
        String select = "SELECT * " +
                " FROM VW_LEAVE_REQUEST " +
                " WHERE EMP_ID ='" + employeeId + "' AND " +
                " STATUS ='" + leaveRequestStatus + "' AND " +
                " REQUESTED_DATE ='" + requesedDate + "'";

        PreparedStatement ps = null;
        _con = null;
        ArrayList<HashMap> leaveRequest = new ArrayList<HashMap>();
        ResultSet rs = null;
        try {
            _con = getConnection();
            ps = _con.prepareStatement(select);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", ocrs.getString("EMP_ID"));
                hm.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                hm.put("REQUESTED_FROM_DATE", ocrs.getString("REQUESTED_FROM_DATE"));
                hm.put("REQUESTED_TO_DATE", ocrs.getString("REQUESTED_TO_DATE"));
                hm.put("REQUESTING_REASON", ocrs.getString("REQUESTING_REASON"));
                hm.put("LEAVE_DAYS", ocrs.getString("LEAVE_DAYS"));
                hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("SEX", ocrs.getString("SEX"));
                hm.put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                hm.put("DEP_DESCRIPTION", ocrs.getString("DEP_DESCRIPTION"));
                hm.put("PHYSICALYEAR", ocrs.getString("PHYSICALYEAR"));
                hm.put("RETURNDATE", ocrs.getString("RETURNDATE"));
                hm.put("LEAVE_TYPE", ocrs.getString("LEAVE_TYPE"));
                hm.put("PHOTO", ocrs.getBlob("PHOTO"));
                leaveRequest.add(hm);
            }

            rs.close();
            ps.close();
            closePooledConnections(_con);
            return leaveRequest;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

//    /**
//     * UPDATES status of employee<br>
//     * Note: use updateEmployeeStatus(String emplyeeId, String status) of EmployeeManage class<br>
//     * to
//     * @param  the status of the request
//     * @throws  SQLException
//     */
//    public boolean updateEmployeeStatusFromRequestId(String requestId, String status) throws SQLException {
//        String _selectQuery = " UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='" + status + "' WHERE EMP_ID=(SELECT REQUESTER_ID FROM HR_LEAVE_REQUEST WHERE LEAVE_REQUEST_ID='" + requestId + "')";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//            _ps.executeUpdate();
//            return true;
//        } finally {
//            releaseResources();
//        }
//    }
    public boolean checkBetweenTwoDateAvileblLeave(String startDate, String endDate, String emp_id) {
        try {
            String selectQuerey = "SELECT * " +
                    "FROM Hr_Emp_Leave " +
                    "WHERE (REQUESTED_TO_DATE BETWEEN '" + startDate + "' AND '" + endDate + "') " +
                    "AND EMP_ID            ='" + emp_id + "' " +
                    "AND SUBSTR(STATUS,1,3)='App'";
            _con = getConnection();
            _ps = _con.prepareStatement(selectQuerey);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            _con.close();
            if (ocrs.size() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public String getLeaveType(String leaveRequestId) {
        String selectQuerey = "SELECT LEAVE_TYPE FROM HR_EMP_LEAVE WHERE LEAVE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectQuerey);
            _ps.setString(1, leaveRequestId);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getString("LEAVE_TYPE");

            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

 
}
