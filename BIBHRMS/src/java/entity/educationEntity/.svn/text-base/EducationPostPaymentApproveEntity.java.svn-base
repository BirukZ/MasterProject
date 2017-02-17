/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.educationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import manager.authorizationManager.DescisionModel;
import manager.educationManager.EducationPostPaymentApproveManager;
import oracle.jdbc.rowset.OracleCachedRowSet;
import manager.educationManager.EducationPaymentModel;

/**
 *
 * @author mekete
 */
public class EducationPostPaymentApproveEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
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

    public boolean insertEducationPaymentDecision(EducationPaymentModel decisionModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_EDUC_POST_PAY_PROCESSED " +
                " (REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_EDUC_POST_PAY_REQUEST SET REQUEST_STATUS=? WHERE EDUC_POS_PAYMENT_REQ_ID=?";
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, decisionModel.getEducationPaymentId());
            _ps.setString(2, decisionModel.getProcessedBy());
            _ps.setString(3, decisionModel.getDecision());
            _ps.setString(4, decisionModel.getCommentGiven());
            _ps.setString(5, decisionModel.getRecordedBy());
            _ps.setString(6, decisionModel.getRecorededDateAndTime());

            _ps.executeUpdate();
//            Savepoint firstSavePoint = _con.setSavepoint();
//            _con.setAutoCommit(false);
//            try {
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, decisionModel.getNextState());
            _ps.setInt(2, decisionModel.getEducationPaymentId());
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
        String _innerSelectQuery = "select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from mugher.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from MUGHER.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from mugher.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + EducationPostPaymentApproveManager.PROCESS_EDUCATION_POST_PAYMENT + "'))";
        String _selectQuery = "SELECT * FROM HR_EDUC_POST_PAY_REQUEST WHERE REQUEST_STATUS  IN (" + _innerSelectQuery + ") order by APPLIED_DATE desc";
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
        String _selectQuery = "SELECT * FROM HR_EDUC_POST_PAY_REQUEST WHERE EDUC_POS_PAYMENT_REQ_ID  IN " +
                "(SELECT REQUEST_ID FROM HR_EDUC_POST_PAY_PROCESSED WHERE RECORDED_BY =?)";
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

//     public ResultSet readAllTableInfo(String requestID) throws SQLException {
//
//        String _selectQuery = "select * from HR_ADMINSTRATIVE_COST where requester_id=?";
//        String select="select * from HR_COURSE_PERSEMISTER where requester_id=?";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setString(1, requestID);
//            _rs = _ps.executeQuery();
////            _ps2 = _con.prepareStatement(select);
////            _ps2.setString(1, requestID);
////            _rs2 = _ps2.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
////              ocrs.populate(_rs2);
//            return ocrs;
//        } finally {
//            releaseResources();
//        }
//
//    }
    /**
     * returns ResultSet object of processed leave requests with their current status<br>
     * Basically intended to show the history of a  given leave request.
     * @param  the status of the request
     * @throws  SQLException*/
    public ResultSet selectProcessedOverTimeRequest(int requestId) throws SQLException {
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
                "FROM HR_EDUC_POST_PAY_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  mugher.TBL_PERMISSION , " +
                "  mugher.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND mugher.TBL_USERS.user_name=RECORDED_BY " +
                "AND mugher.TBL_PERMISSION.CODE=DECISION " +
                "ORDER BY TIME_STAMP desc";
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

    public int updateEducationRequest(EducationPaymentModel educationPaymentModel) throws SQLException {
        String _updateQuery = "UPDATE HR_ADMINSTRATIVE_COST " +
                " SET " +
                " APPROVEDORNOT = ?" +
                " WHERE ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            int selected = (Boolean.valueOf(educationPaymentModel.isSelected())) ? 1 : 0;
            _ps.setInt(1, selected);
            _ps.setInt(2, educationPaymentModel.getAdminstratId());


            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

   public OracleCachedRowSet readAllTableInfo(int requestID,String date) throws SQLException {

        String _selectQuery = "select * from HR_ADMINSTRATIVE_COST where EDUC_REQ_ID=? and APPLIDE_DATE=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestID);
             _ps.setString(2, date);
            _rs = _ps.executeQuery();
//
            OracleCachedRowSet ocrs = new OracleCachedRowSet();

            ocrs.populate(_rs);
//
            return ocrs;
        } finally {
            releaseResources();
        }

    }

   public OracleCachedRowSet readAllCourse(int requestID, String date) throws SQLException {


        String select = "select * from HR_COURSE_PERSEMISTER where EDUC_REQ_ID=? and APPLIDE_DATE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, requestID);
              _ps.setString(2, date);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }


}
