/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.trainingEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.authorizationManager.DescisionModel;
import manager.trainingManager.TrainingNeedAssessementApproveManager;
import manager.trainingManager.TrainingParticipantModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class TrainingNeedAssessementApproveEntity extends ConnectionManager {

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
                " in  ( select PROCESS_STATE_ID from mugher.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + TrainingNeedAssessementApproveManager.PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT + "'))";
        String _selectQuery = "SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ WHERE REQUEST_STATUS  IN (" + _innerSelectQuery + ") ORDER BY REQUESTER_ID ASC";

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

    public ResultSet selectLoginId(int needAssessmentRequestId) throws SQLException {

        //select process's possible states for that user in the process Power deligation
        String _selectQuery = "select LOGIN_PERSON_ID from HR_TRAIN_NEED_ASSESSEMENT_REQ where NEED_ASSESSEMENT_REQUEST_ID ='" + needAssessmentRequestId+ "'";
                

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
        String _selectQuery =
                "SELECT * " +
                "FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "WHERE NEED_ASSESSEMENT_REQUEST_ID IN " +
                "  (SELECT REQUEST_ID " +
                "  FROM HR_TRAIN_NEED_ASSESS_PROCESSED " +
                "  WHERE RECORDED_BY ='" + userName + "' " +
                "  AND (HR_TRAIN_NEED_ASSESSEMENT_REQ.REQUEST_STATUS LIKE 'App%') " +
                "  ) ORDER BY REQUESTER_ID ASC";

//                "SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ WHERE NEED_ASSESSEMENT_REQUEST_ID  IN " +
//                "( SELECT REQUEST_ID FROM HR_TRAIN_NEED_ASSESS_PROCESSED WHERE RECORDED_BY =?)";
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

    public boolean insertDecision(DescisionModel decision, String startDate, String endDate, String noOfDays, String award, String trainerName, String trainerProfession) throws SQLException {
        String _insertQuery = "INSERT INTO HR_TRAIN_NEED_ASSESS_PROCESSED " +
                " (TRAIN_NEED_ASSESS_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (TRAIN_NEED_ASSESS_PROCESS_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_TRAIN_NEED_ASSESSEMENT_REQ SET REQUEST_STATUS = ? , TENTATIVE_START_DATE = ?, TENTATIVE_END_DATE = ?, NO_OF_DAYS = ?, AWARD = ?, TRAINER_NAME = ?, TRAINER_PROFESSION = ? WHERE NEED_ASSESSEMENT_REQUEST_ID=?";
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, decision.getRequestId());
            _ps.setString(2, decision.getProcessedBy());
            _ps.setString(3, decision.getDecision());
            _ps.setString(4, decision.getCommentGiven());
            _ps.setString(5, decision.getRecordedBy());
            _ps.setString(6, decision.getRecorededDateAndTime());
            _ps.executeUpdate();
//            Savepoint firstSavePoint = _con.setSavepoint();
//            _con.setAutoCommit(false);
//            try {
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, decision.getNextState());
            _ps.setString(2, startDate);
            _ps.setString(3, endDate);
            _ps.setString(4, noOfDays);
            _ps.setString(5, award);
            _ps.setString(6, trainerName);
            _ps.setString(7, trainerProfession);
            _ps.setInt(8, decision.getRequestId());
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
                "FROM HR_TRAIN_NEED_ASSESS_PROCESSED , " +
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

    public ResultSet selectLoginPersonInfo(String requestId) throws SQLException {
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
                "FROM HR_TRAIN_NEED_ASSESS_PROCESSED , " +
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

    public ResultSet selectPreviousTrainings(String employeeId) throws SQLException {
        String _selectQuery = "SELECT EMP_ID, " +
                "  TRAININGORCOURSE_NAME, " +
                "  START_DATE, " +
                "  END_DATE, " +
                " PAYMENT_PAYE_BY " +
                "FROM HR_EMP_TRAINING " +
                "WHERE EMP_ID = '" + employeeId + "'";

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

//    public ResultSet selectPreviousTrainings(String employeeId) throws SQLException {
//        String _selectQuery = "SELECT EMP_ID, " +
//                "  TRAININGORCOURSE_NAME, " +
//                "  START_DATE, " +
//                "  END_DATE, " +
//                " PAYMENT_PAYE_BY " +
//                "FROM HR_EMP_TRAINING " +
//                "WHERE EMP_ID = ?";
//
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//
//            _ps.setString(1, employeeId);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
//    }


    public int updateSelectedEmployeeStatus(ArrayList<TrainingParticipantModel> employeeList) throws SQLException {
        String _updateQuery = "UPDATE HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                " SET SELECTED_OR_NOT = ? " +
                " WHERE TRAIN_NEED_ASSESS_EMP_LIST_ID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (TrainingParticipantModel currentEmployee : employeeList) {
                _ps.setString(1, currentEmployee.isSelected() ? "YES" : "NO");
                _ps.setInt(2, currentEmployee.getTrainingParticipantId());
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
}
