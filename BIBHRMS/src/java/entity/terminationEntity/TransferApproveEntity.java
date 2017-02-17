/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.terminationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import manager.terminationManager.TransferApproveManager;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author BravoZulu
 */
public class TransferApproveEntity extends ConnectionManager {

    Connection _con = null;
    String stm, stm1, stm2;
    ResultSet _rs;
    PreparedStatement _ps;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            _con.close();
        }
    }
    private int terminationProcessedId;// @Column(name = "TERMINATION_PROCESSED_ID")
    private int requestId;//@Column(name = "REQUEST_ID")
    private String processedBy;//    @Column(name = "PROCESSED_BY")
    private String decision;//@Column(name = "DECISION")
    private String commentGiven;//@Column(name = "COMMENT_GIVEN")
    private String recordedBy;//@Column(name = "RECORDED_BY")
    private String timeStamp;//@Column(name = "RECORDED_DATE_AND_TIME")
    private String rankId;
    private String payGrade;
    private String jobCode;
    private String salary;
    private String departmentID;
    private String empID;

    /////////////////
    private String nextState = "1";//the next state whendecision is given

    public TransferApproveEntity(int requestId, String processedBy, String commentGiven, String decision, String recordedBy, String timeStamp) {
        this.requestId = requestId;
        this.processedBy = processedBy;
        this.commentGiven = commentGiven;
        this.decision = decision;
        this.recordedBy = recordedBy;
        this.timeStamp = timeStamp;
    }

    public TransferApproveEntity(int requestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
        this(requestId, processedBy, commentGiven, decision, recordedBy, recorededDateAndTime);
        this.nextState = nextState;

    }

    public TransferApproveEntity(int terminationProcessedId, int requestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
        this(requestId, processedBy, decision, nextState, commentGiven, recordedBy, recorededDateAndTime);
        this.terminationProcessedId = terminationProcessedId;
    }

    public TransferApproveEntity() {
    }

    public boolean insertTransferDecision() throws SQLException {

        String _insertQuery = "INSERT INTO HR_TRANSFER_PROCESSED " +
                " (TRANSFER_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                " COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_TRANSFER_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_TRANSFER_REQUESTS SET STATUS=? WHERE TRANSFER_ID=?";
        // String _updateEmployeeProfileQuery = "UPDATE HR_EMPLOYEE_INFO SET RANK_ID=?,PAY_GRADE=?,JOB_CODE=?,SALARY=? WHERE EMP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            //(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime)
            _ps.setInt(1, requestId);
            _ps.setString(2, processedBy);
            _ps.setString(3, decision);//decision inserted to HR_LEAVE_PROCESSED table
            _ps.setString(4, commentGiven);
            _ps.setString(5, recordedBy);
            _ps.setString(6, timeStamp);
            _ps.executeUpdate();
            try {

                _ps = _con.prepareStatement(_updateQuery);
                _ps.setString(1, nextState); //status inserted to HR_LEAVE_REQUEST table
                _ps.setInt(2, requestId);
                _ps.executeUpdate();
                _con.setAutoCommit(true);
            } catch (SQLException ex) {
            }

            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean TakeBackUpOfTransfere(int requestID, String requesterID, String approvedID, String backUpTakenDateAndTime, String prevPos, String toPosition, String prevSalary, String toSalary, String prevDeptID, String dpid) {
        int backUpReturn;
        String _insertQuery = "INSERT INTO HR_TRANSFER_HISTORY " +
                " (RECOURD_ID,REQUEST_ID, TRANSFERE_ID,APPROVER_ID, " +
                " APPROVED_TIME, PREV_POSITION, CURRENT_POSITION,PREV_DEPT,CURRENT_DEPT,PREV_SALARY,CURRENT_SALARY)" +
                " VALUES (HR_SEQ_TRAN_HISTORY.NEXTVAL,?,?,?,?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, requestID);
            _ps.setString(2, requesterID);
            _ps.setString(3, approvedID);//decision inserted to HR_LEAVE_PROCESSED table
            _ps.setString(4, backUpTakenDateAndTime);
            _ps.setString(5, prevPos);
            _ps.setString(6, toPosition);
            _ps.setString(7, prevDeptID);
            _ps.setString(8, dpid);
            _ps.setString(9, prevSalary);
            _ps.setString(10, toSalary);
            backUpReturn = _ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean UpdateEmployeeInfo(String toPosition, String toRank, String toSalary, String requesterID, String payGrade, String deptID, String positionName, String effectiveFrom) {
        try {
            boolean result = false;
            boolean expResult = false;
            String _updateEmployeeProfileQuery = "UPDATE HR_EMPLOYEE_INFO SET RANK_ID=?,PAY_GRADE=?,JOB_CODE=?,SALARY=?,DEPARTMENT_ID=? WHERE EMP_ID=?";

          
            _con = getConnection();
            _ps = _con.prepareStatement(_updateEmployeeProfileQuery);
            _ps.setString(1, toRank);
            _ps.setString(2, payGrade);
            _ps.setString(3, toPosition);
            _ps.setString(4, toSalary);//decision inserted to HR_LEAVE_PROCESSED table
            _ps.setString(5, deptID);
            _ps.setString(6, requesterID);
            result = _ps.execute();
           
            return expResult;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }


    }


    public boolean UpdateEmployeeInfoAndStatus(String toPosition, String toRank, String toSalary, String requester_id, String payGrade, String id, String updatedPosition, String effectiveDate)

                    {
              try {
            boolean result = false;
            boolean expResult = false;
            int empExpUpdate=0;
            PreparedStatement _psEmpValue;
     
            String _updateEmployeeProfileQuery = "UPDATE HR_EMPLOYEE_INFO SET RANK_ID=?,PAY_GRADE=?,JOB_CODE=?,SALARY=?,DEPARTMENT_ID=? WHERE EMP_ID=?";

            String _insertExpirance = "INSERT " +
                    "INTO hr_emp_experience " +
                    "  ( " +
                    "    emp_Id, " +
                    "    INSTITUION, " +
                    "    START_DATE, " +
                    "    END_DATE, " +
                    "    SALARY, " +
                    "    JOB_TITLE, " +
                    "    RANK, " +
                    "    REASON_FOR_TERMINATION, " +
                    "    PERMANENT_OR_CONTRACT, " +
                    "    PRIVATE_OR_GVTAL, " +
                    "    PROFESSIONINMUGHER, " +
                    "    USETHISEXPERIENCEFORLEAVE " +
                    "  )" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            _con = getConnection();
            _ps = _con.prepareStatement(_updateEmployeeProfileQuery);
            _ps.setString(1, toRank);
            _ps.setString(2, payGrade);
            _ps.setString(3, toPosition);
            _ps.setString(4, toSalary);//decision inserted to HR_LEAVE_PROCESSED table
            _ps.setString(5, id);
            _ps.setString(6, requester_id);
            int  returnValue = _ps.executeUpdate();
    
            if (returnValue==1)
                  {
                _psEmpValue = _con.prepareStatement(_insertExpirance);
                _psEmpValue.setString(1, requester_id);
                _psEmpValue.setString(2, "Bunna International Bank S.c");
                _psEmpValue.setString(3, effectiveDate);
                _psEmpValue.setString(4, "UpToDate");//decision inserted to HR_LEAVE_PROCESSED table
                _psEmpValue.setString(5, toSalary);
                _psEmpValue.setString(6, updatedPosition);
                _psEmpValue.setString(7, "Unkown");
                _psEmpValue.setString(8, "Promotion");
                _psEmpValue.setString(9, "Perm");
                _psEmpValue.setString(10, "Pvt");
                _psEmpValue.setString(11, "");
                _psEmpValue.setString(12, "NO");
                empExpUpdate = _psEmpValue.executeUpdate();
                        }
            if(empExpUpdate==1)
            {
            return true;

            }
            else
            {
            return false;
            }


        } catch (SQLException ex)
        {
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
    public ResultSet selectApprovableRequest(String userName) throws SQLException {

        String _innerSelectQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  BIB.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + TransferApproveManager.PROCESS_TRANSFER + "'))";

        String _selectQuery = "SELECT * FROM HR_TRANSFER_REQUESTS WHERE STATUS  IN (" + _innerSelectQuery + ")";

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

    public OracleCachedRowSet selectDocument(
            int documentId) {
        String _select = "SELECT * FROM HR_TRANSFER_ATTACHMENT WHERE DOCUMENT_ID='" + documentId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            //closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public OracleSerialBlob select_Document(int documentId) {

        String qry = null;

        qry = " SELECT DOCUMENT_PATH FROM HR_TRANSFER_ATTACHMENT WHERE DOCUMENT_ID ='" + documentId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {

                return (OracleSerialBlob) ocrs.getBlob("DOCUMENT_PATH");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet getPositionName(String toPosition) {

        String qry = null;
        qry = "SELECT job_name FROM hr_lu_job_type WHERE job_code='" + toPosition + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {
                return _rs;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }




    }

    /**
     * returns ResultSet object of processed leave requests with their current status<br>
     * Basically intended to show the history of a  given leave request.
     * @param  the status of the request
     * @throws  SQLException
     */
    public ResultSet selectProcessedLeaveRequest(int requestId) throws SQLException {
        String _selectQuery = " SELECT REQUEST_ID, PROCESSED_BY ,RECORDED_BY, DECISION, TIME_STAMP, COMMENT_GIVEN, " +
                " FIRST_NAME, MIDDLE_NAME, LAST_NAME ,PERMISSION_NAME" +
                " FROM HR_TRANSFER_PROCESSED ,HR_EMPLOYEE_INFO ,BIB.TBL_PERMISSION " +
                " WHERE REQUEST_ID=" + requestId +
                " AND HR_EMPLOYEE_INFO.EMP_ID=PROCESSED_BY " +
                " AND BIB.TBL_PERMISSION.CODE=DECISION" +
                " ORDER BY TIME_STAMP";
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

    public ArrayList<String> readApproveableLists(String states) {


        ArrayList<String> myReturn = new ArrayList<String>();

        String stm = "SELECT " +
                "       RE.TRANSFER_ID," +
                "       RT.TRANSFER_TYPE" +
                "       FROM HR_TRANSFER_REQUESTS RE" +
                "       INNER JOIN HR_TRANSFER_TYPES RT ON RT.TRANSFER_TYPE_ID=RE.TRANSFER_TYPE WHERE STATUS='" + states + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(stm);
            _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                int i = 0;
                while (_rs.next()) {
                    i++;
                    String returnValue = "";
                    returnValue = _rs.getString("TRANSFER_ID") + "#" + _rs.getString("TRANSFER_TYPE");
                    myReturn.add(returnValue);
                }
            }

        } catch (SQLException ex) {
        }

        return myReturn;
    }

    public int updateEmployeeStatus(String employeeId, String employeeStatus) {
        String _update = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='" + employeeStatus + "' WHERE EMP_ID='" + employeeId + "'";

        int rowAffect = 0;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            rowAffect = _ps.executeUpdate();
            _ps.close();
            closePooledConnections(_con);
            return rowAffect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int insertToClearance(String employeeId, String reasonForTransfer, int type, String recorededDateAndTime) {
        String inserIntoClearance = "INSERT INTO HR_TERMINATION_CLEARANCE(EMP_ID,CLEARANCE_REASON,CLEARANCE_TYPE,CLEARANCE_STATUS,DATE_TERMINATED) " +
                "VALUES('" + employeeId.trim() + "','" + reasonForTransfer + "','" + type + "','0','" + recorededDateAndTime + "')";

        int rowAffect = 0;

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(inserIntoClearance);
            rowAffect = _ps.executeUpdate();
            return rowAffect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }
}
