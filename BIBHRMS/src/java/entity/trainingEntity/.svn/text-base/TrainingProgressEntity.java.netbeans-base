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
import javax.faces.model.SelectItem;
import manager.educationManager.EducationCostModel;
import manager.trainingManager.TrainingProgressModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class TrainingProgressEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
//====================================================================================================================

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
//====================================================================================================================

    public boolean insertTrainingCosts(ArrayList<EducationCostModel> costTypeList) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_COMMITTEE " +
                " ( COMMITTEE_ID,COMMITTEE_NAME,COMMITTEE_TYPE,DESCRIPTION," +
                "NUMBER_OF_MEMBERS,ESTABLISHED_DATE,STATUS,RESPONSIBLITY,PARENT_ID )" +
                " VALUES(HR_COMMITTEE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EducationCostModel currentCost : costTypeList) {
                _ps.setString(1, currentCost.getDatabaseStatus());

                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectProgress(int progressId) throws SQLException {

        String _selectQuery = "SELECT * " +
                "FROM HR_TRAIN_PROGRESS" +
                " WHERE PROGRESS_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, progressId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }

    }
//====================================================================================================================

    public boolean updateTrainingCosts(ArrayList<EducationCostModel> costTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_COMMITTEE " +
                " ( COMMITTEE_ID,COMMITTEE_NAME,COMMITTEE_TYPE,DESCRIPTION," +
                "NUMBER_OF_MEMBERS,ESTABLISHED_DATE,STATUS,RESPONSIBLITY,PARENT_ID )" +
                " VALUES(HR_COMMITTEE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (EducationCostModel currentCost : costTypeList) {
                _ps.setString(1, currentCost.getDatabaseStatus());

                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
//====================================================================================================================

    public boolean deleteTrainingCosts(ArrayList<EducationCostModel> costTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_COMMITTEE " +
                " ( COMMITTEE_ID,COMMITTEE_NAME,COMMITTEE_TYPE,DESCRIPTION," +
                "NUMBER_OF_MEMBERS,ESTABLISHED_DATE,STATUS,RESPONSIBLITY,PARENT_ID )" +
                " VALUES(HR_COMMITTEE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (EducationCostModel currentCost : costTypeList) {
                _ps.setString(1, currentCost.getDatabaseStatus());

                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
//====================================================================================================================

    public boolean insertTrainingProgress(TrainingProgressModel trainingProgress) throws SQLException {
        String _insertQuery = "INSERT INTO HR_TRAIN_PROGRESS " +
                " ( PROGRESS_ID,BATCH_CODE,TRAINING_ID," +
                " BUGJET_YEAR,START_DATE,END_DATE,PROGRESS_STATUS )" +
                " VALUES(HR_TRAIN_PROGRESS_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, trainingProgress.getBatchCode());
            _ps.setInt(2, trainingProgress.getTrainingRequestId());
            _ps.setString(3, trainingProgress.getBudjetYear());
            _ps.setString(4, trainingProgress.getStartDate());
            _ps.setString(5, trainingProgress.getEndDate());
            _ps.setString(6, trainingProgress.getProgressStatus());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }


    //====================================================================================================================

    public boolean updateTrainingProgress(TrainingProgressModel trainingProgress) throws SQLException {
        String _insertQuery = "UPDATE  HR_TRAIN_PROGRESS " +
                " SET BATCH_CODE = ? ,TRAINING_ID = ? ," +
                " BUGJET_YEAR = ? ,START_DATE = ? ,END_DATE = ? ,PROGRESS_STATUS = ? " +
                " WHERE  PROGRESS_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, trainingProgress.getBatchCode());
            _ps.setInt(2, trainingProgress.getTrainingRequestId());
            _ps.setString(3, trainingProgress.getBudjetYear());
            _ps.setString(4, trainingProgress.getStartDate());
            _ps.setString(5, trainingProgress.getEndDate());
            _ps.setString(6, trainingProgress.getProgressStatus());
            _ps.setInt(7, trainingProgress.getProgressId());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }
    //====================================================================================================================

    public boolean updateAssignedAndNotAssignedEmployees(TrainingProgressModel trainingProgress, ArrayList<SelectItem> trainnedList, ArrayList<SelectItem> notTrainnedList) throws SQLException {
        String _updateAssignedEmployeesQuery = "UPDATE HR_TRAIN_NEED_ASSMT_EMP_LIST SET " +
                " BATCH = ? " +
                " WHERE TRAIN_NEED_ASSESS_EMP_LIST_ID = ? ";

        String _updateNotAssignedEmployeesQuery = "UPDATE HR_TRAIN_NEED_ASSMT_EMP_LIST SET " +
                " BATCH = '-1' " +
                " WHERE TRAIN_NEED_ASSESS_EMP_LIST_ID = ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateAssignedEmployeesQuery);
            for (SelectItem currentRequest : trainnedList) {
                _ps.setString(1, trainingProgress.getBatchCode());
                _ps.setString(2, currentRequest.getValue().toString());
                _ps.addBatch();
            }
            _ps.executeBatch();
            //====================================
            _ps = _con.prepareStatement(_updateNotAssignedEmployeesQuery);
            for (SelectItem currentRequest : notTrainnedList) {
                _ps.setString(1, currentRequest.getValue().toString());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainnedAndNotTrainnedEmployees(String budgetYear, int institutionId, ArrayList<SelectItem> trainnedList, ArrayList<SelectItem> notTrainnedList) throws SQLException {
        String _updateTrainnedQuery = "UPDATE HR_TRAIN_NEED_ASSESSEMENT_REQ SET " +
                " ASSIGNED_INSTITUTION = ? " +
                " WHERE BUDJET_YEAR = ? " +
                " AND TRAINING_ID = ? ";

        String _updateNotTrainnedQuery = "UPDATE HR_TRAIN_NEED_ASSESSEMENT_REQ SET " +
                " ASSIGNED_INSTITUTION = '-1' " +
                " WHERE BUDJET_YEAR = ? " +
                " AND TRAINING_ID = ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateTrainnedQuery);
            for (SelectItem currentRequest : trainnedList) {
                _ps.setInt(1, institutionId);
                _ps.setString(2, budgetYear);
                _ps.setString(3, currentRequest.getValue().toString());
                _ps.addBatch();
            }
            _ps.executeBatch();
            //====================================
            _ps = _con.prepareStatement(_updateNotTrainnedQuery);
            for (SelectItem currentRequest : notTrainnedList) {
                _ps.setString(1, budgetYear);
                _ps.setString(2, currentRequest.getValue().toString());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
//====================================================================================================================

    public ResultSet selectTrainnedEmployees(String budjetYear, int trainingId, String batchCode) throws SQLException {

        String _selectQuery = "SELECT * " +
                "FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST, " +
                "  HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                "WHERE VW_EMPLOYEE_BY_DEPARTMENT_LIST.EMP_ID  =HR_TRAIN_NEED_ASSMT_EMP_LIST.EMPLOYEE_ID " +
                "AND  HR_TRAIN_NEED_ASSMT_EMP_LIST.BATCH                                  = ? " +
                "AND HR_TRAIN_NEED_ASSMT_EMP_LIST.REQUEST_ID IN " +
                "  (SELECT NEED_ASSESSEMENT_REQUEST_ID " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "  WHERE BUDJET_YEAR = ? " +
                "  AND TRAINING_ID   = ? " +
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
//====================================================================================================================

    public ResultSet selectNotTrainnedEmployees(String budjetYear, int trainingId) throws SQLException {
       
        String _selectQuery = "SELECT * " +
                "FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST, " +
                "  HR_TRAIN_NEED_ASSMT_EMP_LIST " +
                "WHERE VW_EMPLOYEE_BY_DEPARTMENT_LIST.EMP_ID  =HR_TRAIN_NEED_ASSMT_EMP_LIST.EMPLOYEE_ID " +
                "AND ( BATCH                                  = '-1' " +
                "OR BATCH                                    IS NULL ) " +
                "AND HR_TRAIN_NEED_ASSMT_EMP_LIST.SELECTED_OR_NOT = 'YES' " +
                "AND HR_TRAIN_NEED_ASSMT_EMP_LIST.REQUEST_ID IN " +
                "  (SELECT NEED_ASSESSEMENT_REQUEST_ID " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "  WHERE BUDJET_YEAR=? " +
                "  AND TRAINING_ID  =? " +
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
//====================================================================================================================

    public ResultSet selectProgressStatus(String budjetYear, int trainingId, String batchCode) throws SQLException {
        String _selectQuery = "SELECT PROGRESS_ID " +
                "FROM HR_TRAIN_PROGRESS " +
                "WHERE BATCH_CODE=? " +
                "AND TRAINING_ID =? " +
                "AND BUGJET_YEAR =? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, batchCode);
            _ps.setInt(2, trainingId);
            _ps.setString(3, budjetYear);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //====================================================================================================================
    int progressId;
    String budjetYear;
    int trainingId;
    String batchCode;
    String progressStatus;
    String startDate;
    String endDate;
    String timeStamp;
    String userName;

    /*  public boolean insertTrainingProgress(TrainingProgressModel trainingProgress) throws SQLException {
    String _insertQuery = "INSERT INTO  HR_TRAIN_TRAINING_PROGRESS " +
    " (  PROGRESS_ID,TRAINING_REQUEST_ID, BUGJET_YEAR,BATCH_CODE," +
    " START_DATE,END_DATE, PROGRESS_STATUS,USER_NAME ,TIME_STAMP  )" +
    " VALUES(HR_TRAIN_TRAINING_PROGRESS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
    try {
    _con = getConnection();
    _ps = _con.prepareStatement(_insertQuery);
    _ps.setInt(1, trainingProgress.getTrainingRequestId());
    _ps.setString(2, trainingProgress.getBudjetYear());
    _ps.setString(3, trainingProgress.getBatchCode());
    _ps.setString(4, trainingProgress.getStartDate());
    _ps.setString(5, trainingProgress.getEndDate());
    _ps.setString(6, trainingProgress.getProgressStatus());
    _ps.setString(7, trainingProgress.getUserName());
    _ps.setString(8, trainingProgress.getTimeStamp());
    _ps.executeUpdate();
    return true;
    } finally {
    releaseResources();
    }
    }

    public boolean updateTrainingProgress(TrainingProgressModel trainingProgress) throws SQLException {
    String _insertQuery = "UPDATE  HR_TRAIN_TRAINING_PROGRESS " +
    " SET  TRAINING_REQUEST_ID = ? ,BUGJET_YEAR,BATCH_CODE = ? ," +
    " START_DATE = ? ,END_DATE = ? ,PROGRESS_STATUS = ? ,USER_NAME = ? ,TIME_STAMP = ? " +
    " WHERE PROGRESS_ID = ? ";
    try {
    _con = getConnection();
    _ps = _con.prepareStatement(_insertQuery);
    _ps.setInt(1, trainingProgress.getTrainingRequestId());
    _ps.setString(2, trainingProgress.getBudjetYear());
    _ps.setString(3, trainingProgress.getBatchCode());
    _ps.setString(4, trainingProgress.getStartDate());
    _ps.setString(5, trainingProgress.getEndDate());
    _ps.setString(6, trainingProgress.getProgressStatus());
    _ps.setString(7, trainingProgress.getUserName());
    _ps.setString(8, trainingProgress.getTimeStamp());
    _ps.executeUpdate();
    return true;
    } finally {
    releaseResources();
    }
    }*/
    //====================================================================================================================
}
