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
import manager.educationManager.changeInstituApproveManager;
import manager.educationManager.changeInstitutionRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class ChangeInstituApproveEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    Connection _con1 = null;
    PreparedStatement _ps1 = null;
    ResultSet _rs1 = null;
    Connection _con2 = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;
    changeInstitutionRequestModel ChangeInstitutionRequestModel = new changeInstitutionRequestModel();

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

    public boolean insertChangeInsDecision(changeInstitutionRequestModel decisionModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_CHANGE_INST_PROCESSED " +
                " (CHANGEINS_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_CHANEGINS_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_CHANGE_INST_REQUEST SET REQUEST_STATUS=? WHERE CHANGEINS_REQU_ID=?";
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, decisionModel.getChangeInstId());
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
            _ps.setInt(2, decisionModel.getChangeInstId());
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

    public ResultSet selectApprovableRequest(String userName) throws SQLException {
        //select process's possible states for that user in the process Power deligation
        String _innerSelectQuery = "select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from mugher.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from MUGHER.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from mugher.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + changeInstituApproveManager.PROCESS_CHANGEINSTITUTION + "'))";
        String _selectQuery = "SELECT * FROM HR_CHANGE_INST_REQUEST WHERE REQUEST_STATUS  IN (" + _innerSelectQuery + ")";

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
        String _selectQuery = "SELECT * FROM HR_CHANGE_INST_REQUEST WHERE CHANGEINS_REQU_ID IN " +
                "( SELECT REQUEST_ID FROM HR_CHANGE_INST_PROCESSED WHERE RECORDED_BY =?)order by APPLIED_DATE desc";
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

    public boolean updateEducationRequest(changeInstitutionRequestModel changeInsModel) throws SQLException {
        String _updateQuery = "UPDATE HR_EDUCATION_REQUEST " +
                " SET " +
                " EDUCATION_SHIFT_CATEGORY = ?," +
                " START_DATE = ?,  APPLIED_DATE = ?,DURATION_IN_YEAR = ?,REASON_DESCRIPTION = ?," +
                " INSTITUTION_NAME = ?," +
                " COST_PER_CREDIT_HOUR = ?,NUMBER_OF_CREDIT_HOURS = ?,TOTAL_ADMIN_COSTS = ?," +
                " DOCUMENT_REFERENCE_NUMBER = ?,TIME_STAMP = ?,USER_NAME =?,END_DATE=?, CHANGE_INSTITUTION='Yes' " +
                " WHERE REQUESTER_ID = ? and EDUCATION_REQUEST_ID = ?";
        
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, changeInsModel.getEducationShiftCategoryNew());
            _ps.setString(2, changeInsModel.getStartDateNew());
            _ps.setString(3, changeInsModel.getAppliedDateNew());
            _ps.setDouble(4, changeInsModel.getDurationInYearNew());
            _ps.setString(5, changeInsModel.getReasonDescriptionNew());
            _ps.setString(6, changeInsModel.getInstitutionNamenew());
                      _ps.setDouble(7, changeInsModel.getCostPerCreditHourNew());
            _ps.setInt(8, changeInsModel.getNumberOfCreditHoursNew());
            _ps.setDouble(9, changeInsModel.getTotalAdminstrationCostsNew());
            _ps.setString(10, changeInsModel.getDocumentReferenceNumberNew());
            _ps.setString(11, changeInsModel.getTimeStamp());
            _ps.setString(12, changeInsModel.getUserName());
            _ps.setString(13, changeInsModel.getEndDateNew());
            _ps.setString(14, changeInsModel.getRequesterId());
            _ps.setInt(15, changeInsModel.getEducationRequestId());

            _ps.executeUpdate();

           
            return true;

        } finally {
            releaseResources();
        }
    }

    public boolean updateEducationPostRequest(changeInstitutionRequestModel changeInsModel) throws SQLException {


        String _updateQueryEducPostPay = "UPDATE HR_EDUC_POST_PAY_REQUEST " +
                " SET " +
                " CHANGE_INSTITUTION = ?" +
                " WHERE REQUESTER_ID = ? and EDUCATION_REQUEST_ID = ?";
        try {


            _con2 = getConnection();
            _ps2 = _con2.prepareStatement(_updateQueryEducPostPay);
            _ps2.setString(1, "Yes");
            _ps2.setString(2, changeInsModel.getRequesterId());
            _ps2.setInt(3, changeInsModel.getEducationRequestId());
            return true;

        } finally {
            releaseResources();
        }
    }

    public boolean updateEducationPaymentRequest(changeInstitutionRequestModel changeInsModel) throws SQLException {

        String _updateQueryEducPayment = "UPDATE HR_EDUC_PAYMENT_REQUEST " +
                " SET " +
                " CHANGE_INSTITUTION = 'Yes'" +
                " WHERE REQUESTER_ID = ? and EDUCATION_REQUEST_ID = ?";

        try {


            _con1 = getConnection();
            _ps1 = _con1.prepareStatement(_updateQueryEducPayment);
            // _ps1.setString(1, "Yes");
            _ps1.setString(1, changeInsModel.getRequesterId());
            _ps1.setInt(2, changeInsModel.getEducationRequestId());
            _ps1.executeUpdate();

            return true;

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
                "FROM HR_CHANGE_INST_PROCESSED, " +
                "  HR_EMPLOYEE_INFO , " +
                "  mugher.TBL_PERMISSION , " +
                "  mugher.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
                " AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                " AND mugher.TBL_USERS.user_name=RECORDED_BY " +
                " AND mugher.TBL_PERMISSION.CODE=DECISION " +
                " ORDER BY TIME_STAMP desc";
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

    public ResultSet selectEducationRequest(int requestId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_CHANGE_INST_REQUEST " +
                " WHERE CHANGEINS_REQU_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
