/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.benefitEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.benefitManager.BenefitREquestApproveManager;
import manager.benefitManager.BenefitREquestApproveManager.SubSidyDecisionModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class BenefitRequestApproveEntity
        extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    Connection _con2 = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;

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

    public BenefitRequestApproveEntity() {
    }

    public boolean insertTerminationDecision(SubSidyDecisionModel terminationDecisionModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_MILK_SUBSIDY_PROCESSED " +
                " (MILK_SUBSIDY_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_MILK_SUBSIDY_PRO.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_MILK_SUBSIDY_REQUEST SET REQUEST_STATUS=? WHERE REQUEST_ID=?";

        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, terminationDecisionModel.getSubsidyId());
            _ps.setString(2, terminationDecisionModel.getProcessedBy());
            _ps.setString(3, terminationDecisionModel.getDecision());
            _ps.setString(4, terminationDecisionModel.getCommentGiven());
            _ps.setString(5, terminationDecisionModel.getRecordedBy());
            _ps.setString(6, terminationDecisionModel.getRecorededDateAndTime());

            _ps.executeUpdate();
//            Savepoint firstSavePoint = _con.setSavepoint();
//            _con.setAutoCommit(false);
//            try {
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, terminationDecisionModel.getNextState());
            _ps.setInt(2, terminationDecisionModel.getSubsidyId());
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
                "               where  PROCESS_ID='" + BenefitREquestApproveManager.PROCESS_MILK_SUBSIDY + "'))";

        String _selectQuery = "SELECT * FROM HR_MILK_SUBSIDY_REQUEST WHERE REQUEST_STATUS  IN (" + _innerSelectQuery + ") order by APPLIED_DATE desc";
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

    public ResultSet selectApprovedRequest(String userName) throws SQLException {
        String _selectQuery = "SELECT TR.*, (E.FIRST_NAME || ' ' || E.MIDDLE_NAME || ' ' || E.LAST_NAME) AS FNAME " +
                "FROM HR_MILK_SUBSIDY_REQUEST TR, HR_EMPLOYEE_INFO E " +
                "WHERE TR.REQUESTER_ID = E.EMP_ID AND REQUEST_STATUS like 'app%'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setString(1, userName);
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
    public ResultSet selectProcessedTerminationRequest(int requestId) throws SQLException {
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
                "FROM HR_MILK_SUBSIDY_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  BIB.TBL_PERMISSION , " +
                "  BIB.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
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

    public ResultSet selectMyDecisionsOnRequest(String userName) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_MILK_SUBSIDY_REQUEST WHERE REQUEST_ID IN " +
                "(SELECT REQUEST_ID FROM HR_MILK_SUBSIDY_PROCESSED WHERE RECORDED_BY =?)";
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

    public boolean changeEmployeeList(String requestId) throws SQLException {
        String _deleteQuery = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='09'  WHERE EMP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setString(1, requestId);
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean changeEmployeeListRetirment(String requestId) throws SQLException {
        String _deleteQuery = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='05' WHERE EMP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setString(1, requestId);
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean changeEmployeeListResign(String requestId) throws SQLException {
        String _deleteQuery = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='03' WHERE EMP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setString(1, requestId);
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     * UPDATES status of employee<br>
     * Note: use updateEmployeeStatus(String emplyeeId, String status) of EmployeeManage class<br>
     * to
     * @param  the status of the request
     * @throws  SQLException
     */
    public boolean updateEmployeeStatusFromRequestId(String requestId, String status) throws SQLException {
        String _selectQuery = " UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='" + status + "' WHERE EMP_ID=(SELECT REQUESTER_ID FROM HR_TERMINATION_REQUEST WHERE TERMINATION_REQUEST_ID='" + requestId + "')";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }
}
