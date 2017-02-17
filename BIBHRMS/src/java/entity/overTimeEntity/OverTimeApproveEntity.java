/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.overTimeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.overTimeManager.OverTimeApproveManager;
import manager.overTimeManager.OverTimeApproveManager.OverTimeDecisionModel;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 * @author mekete
 */
public class OverTimeApproveEntity extends ConnectionManager {

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

    public ResultSet selectApprovedOverTimeRequests(String employeeId) throws SQLException {
        String _selectQuery = " SELECT * " +
                " FROM HR_OVER_TIME_REQUEST " +
                " WHERE STATUS LIKE 'App%' AND ATTENDANCE_TAKEN ='null' " +
                " ORDER BY OVER_TIME_REQUEST_ID desc ";
        //    " AND STATUS= 'Selected'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
           //_ps.setString(1,"");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectApprovedOverTimeRequestsAttendance(String employeeId) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_OVER_TIME_REQUEST, " +
                "  hr_over_time_attendance,HR_OVER_TIME_ATTEND_EMPLOYEE " +
                "WHERE HR_OVER_TIME_REQUEST.STATUS LIKE 'App%' " +
                "AND HR_OVER_TIME_REQUEST.OVER_TIME_REQUEST_ID= hr_over_time_attendance.request_id " +
                "AND HR_OVER_TIME_REQUEST.REQUESTER_ID='"+employeeId+"'" +
                "AND HR_OVER_TIME_ATTEND_EMPLOYEE.OT_APPROVED='NO'" +
                "ORDER BY OVER_TIME_REQUEST_ID DESC";
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
    public ResultSet selectApprovedOverTimeRequestsAttendanceApproved(String employeeId) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_OVER_TIME_REQUEST, " +
                "  hr_over_time_attendance,HR_OVER_TIME_ATTEND_EMPLOYEE " +
                "WHERE HR_OVER_TIME_REQUEST.STATUS LIKE 'App%' " +
                "AND HR_OVER_TIME_REQUEST.OVER_TIME_REQUEST_ID= hr_over_time_attendance.request_id " +
                "AND HR_OVER_TIME_REQUEST.REQUESTER_ID='"+employeeId+"'" +
                "AND HR_OVER_TIME_ATTEND_EMPLOYEE.OT_APPROVED='YES'" +
                "ORDER BY OVER_TIME_REQUEST_ID DESC";
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

    public ResultSet selectApprovedEmployeeAndOverTimeList(int requestId) throws SQLException {
        String _selectQuery = " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME,OVER_TIME_FACTOR, STATUS," +
                " FIRST_NAME,MIDDLE_NAME,LAST_NAME " +
                " FROM HR_OVER_TIME_EMPLOYEE  , HR_EMPLOYEE_INFO " +
                " WHERE   EMPLOYEE_ID=EMP_ID " +
                " AND REQUEST_ID= " + requestId + "" +
                " AND STATUS= 'YES'";
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

    public ResultSet selectSmallestStartTime(int requestId) throws SQLException {
        String _selectQuery = " SELECT START_TIME " +
                
                " FROM HR_OVER_TIME_EMPLOYEE " +
                " WHERE " +
                " REQUEST_ID= " + requestId + "" +
                " AND STATUS= 'YES'";
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

    public ResultSet selectBigestEndTime(int requestId) throws SQLException {
        String _selectQuery = " SELECT END_TIME " +

                " FROM HR_OVER_TIME_EMPLOYEE " +
                " WHERE " +
                " REQUEST_ID= " + requestId + "" +
                " AND STATUS= 'YES'";
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

    public int updateSelectedEmployeeStatus(ArrayList<OverTimeRequestModel> employeeAndTimeList) throws SQLException {
        String _updateQuery = "UPDATE HR_OVER_TIME_EMPLOYEE " +
                " SET STATUS = ? " +
                " WHERE OVER_TIME_EMPLOYEE_ID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            int lengthOfList = employeeAndTimeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, employeeAndTimeList.get(counter).isSelected() ? "YES" : "NO");
                _ps.setInt(2, employeeAndTimeList.get(counter).getOverTimeEmployeeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            _ps.clearBatch();
            _ps.close();
            return 1;

        } finally {
            releaseResources();
        }
    }

    public boolean insertOverTimeDecision(OverTimeDecisionModel overTimeDecisionModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_OVER_TIME_PROCESSED " +
                " (OVER_TIME_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_OVER_TIME_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_OVER_TIME_REQUEST SET STATUS=? WHERE OVER_TIME_REQUEST_ID=?";
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, overTimeDecisionModel.getOverTimeRequestId());
            _ps.setString(2, overTimeDecisionModel.getProcessedBy());
            _ps.setString(3, overTimeDecisionModel.getDecision());
            _ps.setString(4, overTimeDecisionModel.getCommentGiven());
            _ps.setString(5, overTimeDecisionModel.getRecordedBy());
            _ps.setString(6, overTimeDecisionModel.getRecorededDateAndTime());
            _ps.executeUpdate();
//            Savepoint firstSavePoint = _con.setSavepoint();
//            _con.setAutoCommit(false);
//            try {
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, overTimeDecisionModel.getNextState());
            _ps.setInt(2, overTimeDecisionModel.getOverTimeRequestId());
            _ps.executeUpdate();
//                _con.setAutoCommit(true);
//            } catch (SQLException ex) {
//                _con.rollback(firstSavePoint);
//            }
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     * Retrives termination requests which can be processes by the user.
     * An employee has to see only requests which can be processes with his/her priviledge
     * @param  userName user name of the employee who logged in to the sysytem
     * processId =8 for the porcess termination
     * @throws  SQLException
     */
    public ResultSet selectApprovableRequest(String userName) throws SQLException {
        //select process's possible states for that user in the process Power deligation
        String _innerSelectQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + OverTimeApproveManager.PROCESS_OVERTIME + "'))";
        String _selectQuery = "SELECT * FROM HR_OVER_TIME_REQUEST WHERE STATUS  IN (" + _innerSelectQuery + ")";
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

    public ResultSet selectMyDecisionsOnRequest(String userName) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_OVER_TIME_REQUEST WHERE OVER_TIME_REQUEST_ID  IN " +
                "( SELECT REQUEST_ID FROM HR_OVER_TIME_PROCESSED WHERE RECORDED_BY =?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, userName);
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
     * @throws  SQLException*/
    public ResultSet selectProcessedOverTimeRequest(int requestId) throws SQLException {        
        String _selectQuery = "SELECT REQUEST_ID, " +
                "  BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                //   "  NEXT_STATE AS DECISION, " +
                "  DECISION, " +
                "  TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_OVER_TIME_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  BIB.TBL_PERMISSION , " +
                "  BIB.TBL_USERS " +
                "WHERE REQUEST_ID =" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND BIB.TBL_USERS.user_name=RECORDED_BY " +
                "AND BIB.TBL_PERMISSION.CODE=DECISION " +
                "ORDER BY TIME_STAMP";
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

    public ResultSet selectLoginId(int overTimeRequestId) throws SQLException {

        //select process's possible states for that user in the process Power deligation
        String _selectQuery = "select LOGIN_PERSON_ID from HR_OVER_TIME_REQUEST where OVER_TIME_REQUEST_ID ='" + overTimeRequestId+ "'";


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
}
