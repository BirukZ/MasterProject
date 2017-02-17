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
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import manager.trainingManager.TrainingNeedAssessementApproveManager;
import manager.trainingManager.TrainingNeedAssessementModel;
import manager.trainingManager.TrainingNeedAssessementRequestManager;
import manager.trainingManager.TrainingParticipantModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class TrainingNeedAssessementRequestEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    String trainingReason = null;
    String trainingDescription = null;
    String institution = null;
    String institutionDescription = null;
    String locationCategory = null;
    String educOrTrain = null;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInstitutionDescription() {
        return institutionDescription;
    }

    public void setInstitutionDescription(String institutionDescription) {
        this.institutionDescription = institutionDescription;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }

    public String getTrainingReason() {
        return trainingReason;
    }

    public void setTrainingReason(String trainingReason) {
        this.trainingReason = trainingReason;
    }

    public String getEducOrTrain() {
        return educOrTrain;
    }

    public void setEducOrTrain(String educOrTrain) {
        this.educOrTrain = educOrTrain;
    }

    public String getLocationCategory() {
        return locationCategory;
    }

    public void setLocationCategory(String locationCategory) {
        this.locationCategory = locationCategory;
    }

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

    public boolean deleteTrainingCommonAttributes(TrainingNeedAssessementModel currentRequest) throws SQLException {
        String _insertQuery = "DELETE  HR_NEED_ASSESSEMENT_REQUEST  " +
                " WHERE NEED_ASSESSEMENT_REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, currentRequest.getTrainingNeedRequestId());
            _ps.executeQuery();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertNewTrainingsNeedRequest(TrainingNeedAssessementModel trainingAttributes, ArrayList<TrainingParticipantModel> participantList, String loginId) throws SQLException {

        String _insertAttributesQuery = "INSERT " +
                "INTO HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "  ( " +
                "    NEED_ASSESSEMENT_REQUEST_ID, " +
                "    REQUESTER_ID, " +
                "    APPLIED_DATE, " +
                "    TRAINING_CATEGORY, " +
                "    TRAINING_ID, " +
                "    TRAINING_NAME, " +
                "    PRIORITY, " +
                "    DURATION_CATEGORY, " +
                "    TENTATIVE_START_DATE, " +
                "    TENTATIVE_END_DATE, " +
                "    TRAINER_TYPE, " +
                "    PROPOSED_INSTITUTION_OR_PLACE, " +
                "    ASSIGNED_INSTITUTION, " +
                "    COST_PER_PERSON, " +
                "    OTHER_ESTIMATED_COSTS, " +
                "    NEED_SOURCE, " +
                "    GENERAL_COMMENT, " +
                "    BUDJET_YEAR, " +
                "    PLANNED_OR_UNPLANNED, " +
                "    REQUEST_STATUS, " +
                "    TIME_STAMP, " +
                "    USER_NAME, " +
                "    NUMBER_OF_EMPLOYEES, " +
                "    LOGIN_PERSON_ID " +
                "  )" +
                " VALUES( TRAIN_NEED_ASSESSEMENT_REQ_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";

        String _insertParticipantsListQuery = "INSERT INTO HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                "  ( " +
                "    TRAIN_NEED_ASSESS_EMP_LIST_ID, " +
                "    REQUEST_ID, " +
                "    EMPLOYEE_ID, " +
                "    SELECTED_OR_NOT, " +
                "    USER_NAME, " +
                "    TIME_STAMP " +
                "  ) " +
                "  VALUES " +
                "  ( TRAIN_NEED_ASSMT_EMP_LIST_SEQ.NEXTVAL, TRAIN_NEED_ASSESSEMENT_REQ_SEQ.CURRVAL, ?, ?, ?, ?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertAttributesQuery);
            _ps.setString(1, trainingAttributes.getRequesterId());
            _ps.setString(2, trainingAttributes.getAppliedDate());
            _ps.setString(3, trainingAttributes.getTrainingCategory());
            _ps.setString(4, trainingAttributes.getTrainingId());
            _ps.setString(5, trainingAttributes.getTrainingName());
            _ps.setString(6, trainingAttributes.getPriorityCategory());
            _ps.setString(7, trainingAttributes.getDurationCategory());
            _ps.setString(8, trainingAttributes.getTentativeStartDate());
            _ps.setString(9, trainingAttributes.getTentativeEndDate());
            _ps.setString(10, trainingAttributes.getTrainerType());
            _ps.setString(11, trainingAttributes.getInstitutionOrPlace());
            _ps.setString(12, trainingAttributes.getAssignedInstitutionOrEmployees());
            _ps.setDouble(13, trainingAttributes.getCostPerPerson());
            _ps.setDouble(14, trainingAttributes.getOtherEstimatedCosts());
            _ps.setString(15, trainingAttributes.getNeedSource());
            _ps.setString(16, trainingAttributes.getGeneralComment());
            _ps.setString(17, trainingAttributes.getBudjetYear());
            _ps.setString(18, trainingAttributes.getPlanedOrUnplanned());
            _ps.setString(19, trainingAttributes.getRequestStatus());
            _ps.setString(20, trainingAttributes.getRecordedDateAndTime());
            _ps.setString(21, trainingAttributes.getUserName());
            _ps.setInt(22, trainingAttributes.getNumberOfEmployees());
            _ps.setString(23, loginId);
            _ps.executeQuery();
            //============
            _ps = _con.prepareStatement(_insertParticipantsListQuery);
            for (TrainingParticipantModel currentRequest : participantList) {
                _ps.setString(1, currentRequest.getEmployeeId());
                _ps.setString(2, "YES");
                _ps.setString(3, trainingAttributes.getUserName());
                _ps.setString(4, trainingAttributes.getRecordedDateAndTime());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainingAttributes(TrainingNeedAssessementModel trainingAttributes) throws SQLException {
        String _updateQuery = " UPDATE  HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                " SET  " +
                "    REQUESTER_ID = ? , " +
                "    APPLIED_DATE = ? , " +
                "    TRAINING_CATEGORY = ? , " +
                "    TRAINING_ID = ? , " +
                "    TRAINING_NAME = ? , " +
                "    PRIORITY = ? , " +
                "    DURATION_CATEGORY = ? , " +
                "    TENTATIVE_START_DATE = ? , " +
                "    TENTATIVE_END_DATE = ? , " +
                "    TRAINER_TYPE = ? , " +
                "    PROPOSED_INSTITUTION_OR_PLACE = ? , " +
                "    ASSIGNED_INSTITUTION = ? , " +
                //                "    COST_PER_PERSON = ? , " +
                //                "    OTHER_ESTIMATED_COSTS = ? , " +
                "    NEED_SOURCE = ? , " +
                "    GENERAL_COMMENT = ? , " +
                "    BUDJET_YEAR = ? , " +
                "    PLANNED_OR_UNPLANNED = ? , " +
                "    REQUEST_STATUS = ? , " +
                "    TIME_STAMP = ? , " +
                "    USER_NAME = ? , " +
                "    NUMBER_OF_EMPLOYEES = ? " +
                " WHERE NEED_ASSESSEMENT_REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, trainingAttributes.getRequesterId());
            _ps.setString(2, trainingAttributes.getAppliedDate());
            _ps.setString(3, trainingAttributes.getTrainingCategory());
            _ps.setString(4, trainingAttributes.getTrainingId());
            _ps.setString(5, trainingAttributes.getTrainingName());
            _ps.setString(6, trainingAttributes.getPriorityCategory());
            _ps.setString(7, trainingAttributes.getDurationCategory());
            _ps.setString(8, trainingAttributes.getTentativeStartDate());
            _ps.setString(9, trainingAttributes.getTentativeEndDate());
            _ps.setString(10, trainingAttributes.getTrainerType());
            _ps.setString(11, trainingAttributes.getInstitutionOrPlace());
            _ps.setString(12, trainingAttributes.getAssignedInstitutionOrEmployees());
//            _ps.setDouble(13, trainingAttributes.getCostPerPerson());
//            _ps.setDouble(14, trainingAttributes.getOtherEstimatedCosts());
            _ps.setString(13, trainingAttributes.getNeedSource());
            _ps.setString(14, trainingAttributes.getGeneralComment());
            _ps.setString(15, trainingAttributes.getBudjetYear());
            _ps.setString(16, trainingAttributes.getPlanedOrUnplanned());
            _ps.setString(17, trainingAttributes.getRequestStatus());
            _ps.setString(18, trainingAttributes.getRecordedDateAndTime());
            _ps.setString(19, trainingAttributes.getUserName());
            _ps.setInt(20, trainingAttributes.getNumberOfEmployees());
            _ps.setInt(21, trainingAttributes.getTrainingNeedRequestId());


            _ps.executeUpdate();

            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertTrainingParticipantsList(ArrayList<TrainingParticipantModel> participantsList, TrainingNeedAssessementModel trainingAttributes) throws SQLException {
        String _insertTrainingListQuery = "INSERT INTO  HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                " ( TRAIN_NEED_ASSESS_EMP_LIST_ID, REQUEST_ID, " +
                " EMPLOYEE_ID, SELECTED_OR_NOT, USER_NAME, TIME_STAMP ) " +
                " VALUES( TRAIN_NEED_ASSMT_EMP_LIST_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertTrainingListQuery);
            for (TrainingParticipantModel currentParticipant : participantsList) {
                _ps.setInt(1, currentParticipant.getTrainingNeedRequestId());
                _ps.setString(2, currentParticipant.getEmployeeId());
                _ps.setString(3, "YES");//_ps.setString(3, currentParticipant.isSelected() ? "YES" : "NO");
                _ps.setString(4, trainingAttributes.getUserName());
                _ps.setString(5, trainingAttributes.getRecordedDateAndTime());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertTrainingReasonList(ArrayList<TrainingNeedAssessementRequestManager> trainingReasonList) throws SQLException {
        String _insertTrainingListQuery = "INSERT INTO  HR_LU_TRAIN_TRAINING_REASON " +
                " ( TRAINING_REASON_ID, TRAINING_REASON, " +
                " DESCRIPTION ) " +
                " VALUES( HR_EMP_TRAINING_REASON.NEXTVAL,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertTrainingListQuery);
            for (TrainingNeedAssessementRequestManager currentTrainingReason : trainingReasonList) {
                _ps.setString(1, currentTrainingReason.getTrainingReason());
                _ps.setString(2, currentTrainingReason.getTrainingDescription());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertInstitutionList(ArrayList<TrainingNeedAssessementRequestManager> institutionList, String trainer, String institutionType) throws SQLException {
        String _insertTrainingListQuery = "INSERT INTO  HR_EDUC_INSTITUTION " +
                " ( INSTITUTION_ID, INSTITUTION_NAME, " +
                " INSTITUTION_DESCRIPTION, LOCATION_CATEGORY, EDUCATION_OR_TRAINING) " +
                " VALUES( HR_EDUC_INSTITUTION_SEQ.NEXTVAL,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertTrainingListQuery);
            for (TrainingNeedAssessementRequestManager currentTrainingReason : institutionList) {
                _ps.setString(1, currentTrainingReason.getInstitution());
                _ps.setString(2, currentTrainingReason.getInstitutionDescription());
                _ps.setString(3, trainer);
                _ps.setString(4, institutionType);
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainingParticipantsList(ArrayList<TrainingParticipantModel> participantList) throws SQLException {
        String _insertDisciplineProblemQuery = "UPADTE  HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                " SET EMPLOYEE_ID = ? , SELECTED_OR_NOT = ? , USER_NAME = ?, TIME_STAMP =? " +
                " WHERE  TRAIN_NEED_ASSESS_EMP_LIST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (TrainingParticipantModel currentParticipant : participantList) {
                _ps.setString(1, currentParticipant.getEmployeeId());
                _ps.setString(2, currentParticipant.isSelected() ? "YES" : "NO");
                _ps.setString(3, currentParticipant.getUserName());
                _ps.setString(4, currentParticipant.getTimeStamp());
                _ps.setInt(5, currentParticipant.getTrainingParticipantId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainingReasonList(ArrayList<TrainingNeedAssessementRequestManager> trainingReasonList) throws SQLException {
        String _insertDisciplineProblemQuery = "UPADTE  HR_LU_TRAIN_TRAINING_REASON " +
                " SET TRAINING_REASON = ? , DESCRIPTION = ? " +
                " WHERE  TRAINING_REASON_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (TrainingNeedAssessementRequestManager currentTrainingReason : trainingReasonList) {
                _ps.setString(1, currentTrainingReason.getTrainingReason());
                _ps.setString(2, currentTrainingReason.getTrainingDescription());
                _ps.setString(3, currentTrainingReason.getTrainingreasonId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteTrainingParticipantsList(ArrayList<TrainingParticipantModel> participantList) throws SQLException {
        String _insertDisciplineProblemQuery = "DELETE HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                " WHERE TRAIN_NEED_ASSESS_EMP_LIST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (TrainingParticipantModel currentParticipant : participantList) {
                _ps.setInt(1, currentParticipant.getTrainingParticipantId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteTrainingReasonList(ArrayList<TrainingNeedAssessementRequestManager> trainingReasonList) throws SQLException {
        String _insertDisciplineProblemQuery = "DELETE HR_LU_TRAIN_TRAINING_REASON " +
                " WHERE TRAINING_REASON_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (TrainingNeedAssessementRequestManager currentTrainingReason : trainingReasonList) {
                _ps.setString(1, currentTrainingReason.getTrainingreasonId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteInstitutionList(ArrayList<TrainingNeedAssessementRequestManager> trainingReasonList) throws SQLException {
        String _insertDisciplineProblemQuery = "DELETE HR_EDUC_INSTITUTION " +
                " WHERE INSTITUTION_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (TrainingNeedAssessementRequestManager currentTrainingReason : trainingReasonList) {
                _ps.setInt(1, currentTrainingReason.getInstitutionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectPendingRequests(String requesterId) throws SQLException {



        String _selectQuery = " SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                " WHERE  (REQUESTER_ID = ? " +
                " OR USER_NAME IN (select USER_NAME from BIB.tbl_users where EMPLOYEE_ID=? ))" +
                " AND  REQUEST_STATUS = ? " +
                " ORDER BY REQUESTER_ID ASC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, requesterId);
            _ps.setString(3, TrainingNeedAssessementApproveManager.INITIAL_STATE_TRAINING_NEED_ASSESSEMENT);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectPendingRequestsList(String userName) throws SQLException {

        String _innerSelectQuery = "SELECT PROCESS_STATE_ID " +
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
                "    WHERE PROCESS_ID='" + TrainingNeedAssessementApproveManager.INITIAL_STATE_TRAINING_NEED_ASSESSEMENT + "' " +
                "    ) " +
                "  )";

        String _selectQuery = " SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                " WHERE  " +
                "   REQUEST_STATUS =  IN (" + _innerSelectQuery + ") " +
                " ORDER BY REQUESTER_ID ASC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            //   _ps.setString(1, requesterId);
            // _ps.setString(2, requesterId);
            //_ps.setString(3, TrainingNeedAssessementApproveManager.INITIAL_STATE_TRAINING_NEED_ASSESSEMENT);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectApprovedNeedRequests(String budjetYear) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                " WHERE  REQUEST_STATUS LIKE 'App-' " +
                " AND BUDJER_YEAR = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, budjetYear);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectMyRequestsHistory(String userName) throws SQLException {//requesterId
        String _selectQuery =
                "SELECT * " +
                "FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "WHERE NEED_ASSESSEMENT_REQUEST_ID IN " +
                "  (SELECT REQUEST_ID " +
                "  FROM HR_TRAIN_NEED_ASSESS_PROCESSED " +
                "  WHERE RECORDED_BY ='" + userName + "' " +
                "  AND ((HR_TRAIN_NEED_ASSESSEMENT_REQ.REQUEST_STATUS LIKE 'App%') OR (HR_TRAIN_NEED_ASSESSEMENT_REQ.REQUEST_STATUS LIKE 'Res%') OR (HR_TRAIN_NEED_ASSESSEMENT_REQ.REQUEST_STATUS LIKE 'Rej%'))  " +
                "  ) ORDER BY REQUESTER_ID ASC";
//                "SELECT * " +
//                "FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
//                "WHERE ( REQUESTER_ID LIKE ? " +
//                "OR USER_NAME IN " +
//                "  (SELECT USER_NAME FROM BIB.tbl_users WHERE EMPLOYEE_ID LIKE ? " +
//                "  ) ) " +
//                "AND REQUEST_STATUS NOT LIKE " + TrainingNeedAssessementApproveManager.INITIAL_STATE_TRAINING_NEED_ASSESSEMENT +
//                "ORDER BY NEED_ASSESSEMENT_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setString(1, requesterId);
//            _ps.setString(2, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTrainingsCommonAttributes(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ" +
                " WHERE REQUEST_ID = ? ";
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

    public ResultSet selectTrainingsLists(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ" +
                " WHERE NEED_ASSESSEMENT_REQUEST_ID = ? ";
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

    public ResultSet selectTrainingReasonName(String trainingReasonId) throws SQLException {
        String _selectQuery = "SELECT TRAINING_REASON FROM HR_LU_TRAIN_TRAINING_REASON" +
                " WHERE TRAINING_REASON_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, trainingReasonId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTrainingParticipantsList(int requestId) throws SQLException {
        String _selectQuery = "SELECT HR_TRAIN_NEED_ASSMT_EMP_LIST.*, " +
                " EMP_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME,JOB_NAME , DEPARTMENT_NAME" +
                " FROM HR_TRAIN_NEED_ASSMT_EMP_LIST,VW_EMPLOYEE_BY_DEPARTMENT_LIST " +
                " WHERE " +
                " VW_EMPLOYEE_BY_DEPARTMENT_LIST.EMP_ID=HR_TRAIN_NEED_ASSMT_EMP_LIST.EMPLOYEE_ID" +
                " AND REQUEST_ID = ? ";
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

    public ResultSet selectTrainingParticipantsListByTraining(int trainingId) throws SQLException {
        String _selectQuery = "SELECT HR_TRAIN_NEED_ASSMT_EMP_LIST.*, " +
                " EMP_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME,JOB_NAME " +
                " FROM HR_TRAIN_NEED_ASSMT_EMP_LIST,VW_EMPLOYEE_BY_DEPARTMENT_LIST " +
                " WHERE " +
                " VW_EMPLOYEE_BY_DEPARTMENT_LIST.EMP_ID=HR_TRAIN_NEED_ASSMT_EMP_LIST.EMPLOYEE_ID" +
                " AND REQUEST_ID IN(" +
                " SELECT NEED_ASSESSEMENT_REQUEST_ID FROM HR_TRAIN_NEED_ASSESSEMENT_REQ  WHERE  TRAINING_ID = ?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, trainingId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAssignedInstitutionsForTrainings(String budjetYear) throws SQLException {
        String _selectQuery = "SELECT INSTITUTION_ID, " +
                "  INSTITUTION_NAME, " +
                "  INSTITUTION_DESCRIPTION " +
                "FROM HR_EDUC_INSTITUTION " +
                "WHERE INSTITUTION_ID IN " +
                "  (SELECT ASSIGNED_INSTITUTION " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "  WHERE BUDJET_YEAR =? " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, budjetYear);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectApprovedParticipantsOfTrainings(String budjetYear, int trainingId) throws SQLException {
        String _selectQuery = "SELECT EMP_ID, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME, " +
                "  DEPARTMENT_ID, " +
                "  JOB_NAME, " +
                "  DEPARTMENT_NAME " +
                "FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST " +
                "WHERE emp_id IN " +
                "  (SELECT EMPLOYEE_ID " +
                "  FROM HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                "  WHERE SELECTED_OR_NOT='YES' " +
                "  AND REQUEST_ID      IN " +
                "    (SELECT NEED_ASSESSEMENT_REQUEST_ID " +
                "    FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "    WHERE BUDJET_YEAR=? " +
                "    AND TRAINING_ID  =? " +
                "    AND REQUEST_STATUS  LIKE 'App%' " +
                "    ) " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, budjetYear);
            _ps.setInt(2, trainingId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectOnOrOffWork(String budjetYear, int trainingId, int institutionId) throws SQLException {
        String _selectQuery =
                "SELECT ON_OFF_WORK " +
                "    FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "    WHERE BUDJET_YEAR=? " +
                "    AND TRAINING_ID  =? " +
                "    AND ASSIGNED_INSTITUTION  =? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, budjetYear);
            _ps.setInt(2, trainingId);
            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectStartDate(String budjetYear, int trainingId, int institutionId) throws SQLException {
        String _selectQuery =
                "SELECT TENTATIVE_START_DATE " +
                "    FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "    WHERE BUDJET_YEAR=? " +
                "    AND TRAINING_ID  =? " +
                "    AND ASSIGNED_INSTITUTION  =? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, budjetYear);
            _ps.setInt(2, trainingId);
            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEndDate(String budjetYear, int trainingId, int institutionId) throws SQLException {
        String _selectQuery =
                "SELECT TENTATIVE_END_DATE " +
                "    FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "    WHERE BUDJET_YEAR=? " +
                "    AND TRAINING_ID  =? " +
                "    AND ASSIGNED_INSTITUTION  =? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, budjetYear);
            _ps.setInt(2, trainingId);
            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectApprovedParticipantsOfTrainings(String budjetYear, int trainingId, String batchCode) throws SQLException {
        String _selectQuery = "SELECT EMP_ID, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME, " +
                "  DEPARTMENT_ID, " +
                "  JOB_NAME, " +
                "  DEPARTMENT_NAME " +
                "FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST " +
                "WHERE emp_id IN " +
                "  (SELECT EMPLOYEE_ID " +
                "  FROM HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                "  WHERE SELECTED_OR_NOT='YES' " +
                "  AND BATCH = ? " +
                "  AND REQUEST_ID      IN " +
                "    (SELECT NEED_ASSESSEMENT_REQUEST_ID " +
                "    FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "    WHERE BUDJET_YEAR=? " +
                "    AND TRAINING_ID  =? " +
                "    ) " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, batchCode);
            _ps.setString(2, budjetYear);
            _ps.setInt(3, trainingId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getAssignedInstitutionId(String budjetYear, int trainingId) throws SQLException {
        String _selectQuery = "SELECT ASSIGNED_INSTITUTION " +
                "    FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "    WHERE BUDJET_YEAR= ? " +
                "    AND TRAINING_ID  =? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, budjetYear);
            _ps.setInt(2, trainingId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingTaken(String empId) throws SQLException {
//        ResultSet rs = null;
        String selectTrainingTaken = "SELECT TRAININGORCOURSE_NAME FROM HR_EMP_TRAINING WHERE EMP_ID = '" + empId + "'";
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(selectTrainingTaken);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }




    }

    public int countTrainingReason() {
        HashMap[] list = null;
        int rownum;
        String str = "SELECT Max(rownum) as num FROM HR_LU_TRAIN_TRAINING_REASON ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                rownum = _rs.getInt("num");
                return rownum;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int countInstitution() {
        HashMap[] list = null;
        int rownum;
        String str = "SELECT Max(rownum) as num FROM HR_EDUC_INSTITUTION ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                rownum = _rs.getInt("num");
                return rownum;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public HashMap[] readTrainingReason() {
        HashMap[] list = null;
        int i = 0;
        String str = "SELECT  * FROM  HR_LU_TRAIN_TRAINING_REASON " +
                " ORDER BY TRAINING_REASON_ID ";
        try {
            list = new HashMap[this.countTrainingReason()];
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("TRAINING_REASON_ID", _rs.getString("TRAINING_REASON_ID"));
                list[i].put("TRAINING_REASON", _rs.getString("TRAINING_REASON"));
                list[i].put("DESCRIPTION", _rs.getString("DESCRIPTION"));

                i++;
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<HashMap> readInstitution() {
        //HashMap[] list = null;
        int i = 0;
        String str = "SELECT INSTITUTION_ID, " +
                "  INSTITUTION_NAME, " +
                "  INSTITUTION_DESCRIPTION " +
                "FROM HR_EDUC_INSTITUTION " +
                "ORDER BY INSTITUTION_ID";
        try {
            ArrayList<HashMap> list = new ArrayList<HashMap>();
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("INSTITUTION_ID", _rs.getString("INSTITUTION_ID"));
                hm.put("INSTITUTION_NAME", _rs.getString("INSTITUTION_NAME"));
                hm.put("DESCRIPTION", _rs.getString("INSTITUTION_DESCRIPTION"));
                list.add(hm);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int addNewTrainingReason(String trainingReason, String description) {
        this.setTrainingReason(trainingReason);
        this.setTrainingDescription(description);

        return this.insertNewTrainingReason();
    }

    public int addNewInstitution(String institution, String description, String trainer, String institutionType) {
        this.setInstitution(institution);
        this.setInstitutionDescription(description);
        this.setLocationCategory(trainer);
        this.setEducOrTrain(institutionType);
        return this.insertNewInstitution();
    }

    private int insertNewTrainingReason() {
        int check;
        String insEvaCrt = "INSERT INTO HR_LU_TRAIN_TRAINING_REASON (TRAINING_REASON_ID,TRAINING_REASON,DESCRIPTION) VALUES (HR_EMP_TRAINING_REASON.NEXTVAL,?, ?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insEvaCrt);
            _ps.setString(1, this.getTrainingReason());
            _ps.setString(2, this.getTrainingDescription());
            check = _ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private int insertNewInstitution() {
        int check;
        String insEvaCrt = "INSERT INTO HR_EDUC_INSTITUTION (INSTITUTION_ID,INSTITUTION_NAME,INSTITUTION_DESCRIPTION,LOCATION_CATEGORY,EDUCATION_OR_TRAINING) VALUES (HR_EDUC_INSTITUTION_SEQ.NEXTVAL,?, ?, ?, ?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insEvaCrt);
            _ps.setString(1, this.getInstitution());
            _ps.setString(2, this.getInstitutionDescription());
            _ps.setString(3, this.getLocationCategory());
            _ps.setString(4, this.getEducOrTrain());
            check = _ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet selectLoginId(int needAssessmentRequestId) throws SQLException {

        //select process's possible states for that user in the process Power deligation
        String _selectQuery = "select LOGIN_PERSON_ID from HR_TRAIN_NEED_ASSESSEMENT_REQ where NEED_ASSESSEMENT_REQUEST_ID ='" + needAssessmentRequestId + "'";


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
