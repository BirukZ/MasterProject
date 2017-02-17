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
import manager.authorizationManager.DescisionModel;
import manager.educationManager.EducationPaymentApproveManager;
import oracle.jdbc.rowset.OracleCachedRowSet;
import manager.educationManager.EducationPaymentModel;

/**
 *
 * @author mekete
 */
public class EducationPaymentApproveEntity extends ConnectionManager {

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
        String _insertQuery = "INSERT INTO HR_EDUC_PAYMENT_PROCESSED " +
                " (EDUC_PAYMENT_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_EDUC_PAYMENT_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_EDUC_PAYMENT_REQUEST SET REQUEST_STATUS= ? WHERE EDUC_PAYMENT_REQUEST_ID=?";
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, decisionModel.getEducationPaymentId());
            _ps.setString(2, decisionModel.getProcessedBy());
            _ps.setString(3, decisionModel.getDecision());
            _ps.setString(4, decisionModel.getCommentGiven());
            _ps.setString(5, decisionModel.getRecordedBy());
            _ps.setString(6, decisionModel.getRecorededDateAndTime());
//
            _ps.executeUpdate();
//
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, decisionModel.getNextState());
            _ps.setInt(2, decisionModel.getEducationPaymentId());
            _ps.executeUpdate();
//
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
                "               where  PROCESS_ID='" + EducationPaymentApproveManager.PROCESS_EDUCATION_PAYMENT + "'))";
        String _selectQuery = "SELECT * FROM HR_EDUC_PAYMENT_REQUEST WHERE REQUEST_STATUS  IN (" + _innerSelectQuery + ") order by APPLIED_DATE desc";

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
        String _selectQuery = "SELECT * FROM HR_EDUC_PAYMENT_REQUEST WHERE EDUC_PAYMENT_REQUEST_ID  IN " +
                "(SELECT REQUEST_ID FROM HR_EDUC_PAYMENT_PROCESSED WHERE RECORDED_BY =?)";
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
                "  DECISION, " +
                "  TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_EDUC_PAYMENT_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  mugher.TBL_PERMISSION , " +
                "  mugher.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
                " AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                " AND mugher.TBL_USERS.user_name=RECORDED_BY " +
                " AND mugher.TBL_PERMISSION.CODE=DECISION " +
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

    public OracleCachedRowSet readAllTableInfo(int requestID) throws SQLException {

        String _selectQuery = "select * from HR_ADMINSTRATIVE_COST where EDUC_REQ_ID= ?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestID);
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

    public OracleCachedRowSet readAllCourse(int requestID) throws SQLException {


        String select = "select * from HR_COURSE_PERSEMISTER where EDUC_REQ_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, requestID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }
//public ResultSet selectEducationRequest(int requestId) throws SQLException {
//        String _selectQuery = " SELECT * FROM HR_EDUCATION_REQUEST " +
//                " WHERE EDUCATION_REQUEST_ID = ?";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, requestId);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
//    }


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

   public int updateReceiptNumber(int educPaymentrequestId, String docRefNumber, String receiptNumber) throws SQLException {
        String _updateQuery = "UPDATE HR_EDUC_PAYMENT_REQUEST " +
                " SET " +
                " DOC_REFERENCE_NUMBER = ?," +
                " RECEIPT_NUMBER = ?" +
                " WHERE EDUC_PAYMENT_REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, docRefNumber);
            _ps.setString(2, receiptNumber);
            _ps.setInt(3, educPaymentrequestId);

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }
}
