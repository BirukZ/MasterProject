/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.salaryDelegationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.salaryDelegationManager.SalaryDelegationApproveManager;
import manager.salaryDelegationManager.SalaryDelegationApproveManager.SalaryDelegationDecisionModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class SalaryDelegationApproveEntity extends ConnectionManager {

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

    public boolean insertSalaryDelegationDecision(SalaryDelegationDecisionModel salaryDelegationDecisionModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_SALARY_DELEGATION_PROCESSED " +
                " (SALARY_DELEGATION_PROCESSED_ID,REQUEST_ID,PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_SALARY_DEL_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_SALARY_DELEGATION_REQUEST SET STATUS=? WHERE SALARY_DELEGATION_REQUEST_ID=?";
               
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, salaryDelegationDecisionModel.getSalaryDelegationRequestId());
            _ps.setString(2, salaryDelegationDecisionModel.getProcessedBy());
            _ps.setString(3, salaryDelegationDecisionModel.getDecision());
            _ps.setString(4, salaryDelegationDecisionModel.getCommentGiven());
            _ps.setString(5, salaryDelegationDecisionModel.getProcessedBy());
            _ps.setString(6, salaryDelegationDecisionModel.getRecorededDateAndTime());
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, salaryDelegationDecisionModel.getNextState());
            _ps.setInt(2, salaryDelegationDecisionModel.getSalaryDelegationRequestId());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     * Retrives Salary requests which can be processes by the user.
     * An employee has to see only requests which can be processes with his/her priviledge
     * @param  userName user name of the employee who logged in to the sysytem
     * processId =1 for the porcess leave
     * @throws  SQLException
     */
    public ResultSet selectApprovableRequest(String userName) throws SQLException {
        String _innerSelectQuery = "select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from mugher.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  mugher.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from mugher.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + SalaryDelegationApproveManager.PROCESS_SALARY_DELEGATION + "'))";

        String _selectQuery = "SELECT * FROM HR_SALARY_DELEGATION_REQUEST " +
                "WHERE STATUS  IN (" + _innerSelectQuery + ") ORDER BY SALARY_DELEGATION_REQUEST_ID DESC";

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
    //selectDicisionsMadeByEmployee

    public ResultSet selectDicisionsMadeByEmployee(String userName) throws SQLException {
//        String _selectQuery = "SELECT HR_SALARY_DELEGATION_PROCESSED.*, " +
//                "   DELEGATOR_ID, DELEGATEE_ID, " +
//                "   HR_SALARY_DELEGATION_REQUEST.STATUS, " +
//                "   HR_SALARY_DELEGATION_REQUEST.SALARY_DELEGATION_REQUEST_ID " +
//                " FROM HR_SALARY_DELEGATION_REQUEST, " +
//                "   HR_SALARY_DELEGATION_PROCESSED " +
//                " WHERE SALARY_DELEGATION_REQUEST_ID=REQUEST_ID " +
//                "  AND HR_SALARY_DELEGATION_PROCESSED.RECORDED_BY      =? " +
//                "  OR  HR_SALARY_DELEGATION_PROCESSED.PROCESSED_BY      =? ";

        String _selectQuery = "SELECT HR_SALARY_DELEGATION_PROCESSED.*, " +
                "  HR_SALARY_DELEGATION_REQUEST.SALARY_DELEGATION_REQUEST_ID, " +
                "  HR_SALARY_DELEGATION_REQUEST.STATUS, " +
                "  HR_SALARY_DELEGATION_REQUEST.DELEGATOR_ID, " +
                "  HR_SALARY_DELEGATION_REQUEST.DELEGATEE_ID, " +
                "  HR_SALARY_DELEGATION_REQUEST.APPLIED_DATE " +
                "FROM HR_SALARY_DELEGATION_REQUEST, " +
                "  HR_SALARY_DELEGATION_PROCESSED " +
                "WHERE (SALARY_DELEGATION_REQUEST_ID =REQUEST_ID " +
                "AND HR_SALARY_DELEGATION_REQUEST.STATUS LIKE 'App-%') " +
                "AND (HR_SALARY_DELEGATION_PROCESSED.RECORDED_BY = ? " +
                "OR HR_SALARY_DELEGATION_PROCESSED.PROCESSED_BY  = ?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, userName);
            _ps.setString(2, userName);
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
    public ResultSet selectProcessedSalaryDelegationRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT REQUEST_ID, " +
                "  mugher.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
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
                "FROM HR_SALARY_DELEGATION_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  mugher.TBL_PERMISSION , " +
                "  mugher.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND mugher.TBL_USERS.user_name=RECORDED_BY " +
                "AND mugher.TBL_PERMISSION.CODE=DECISION " +
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
}
