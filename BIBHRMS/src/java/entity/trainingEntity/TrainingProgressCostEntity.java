/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.trainingEntity;

import connectionProvider.ConnectionManager;
import fphrms.Training.TrainingProgressCost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.educationManager.EducationCostModel;
import manager.trainingManager.TrainingParticipantModel;
import manager.trainingManager.TrainingProgressCostManger;
import manager.trainingManager.TrainingProgressModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class TrainingProgressCostEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
//     PreparedStatement _ss = null;
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

    public boolean insertTrainingCosts(ArrayList<EducationCostModel> trainingCost) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_TRAIN_PROGRESS_COSTS " +
                " ( TRAINING_PROGRESS_COST_ID, TRAININIG_PROGRESS_ID, BUDJET_YEAR," +
                "  COST_CATEGORY_ID, COST_NAME,UNIT_COST ,TOTAL, BATCH_CODE, FACTOR,DOC_REF_NUMBER, USER_NAME, TIME_STAMP )" +
                " VALUES(HR_TRAIN_PROGRESS_COST_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EducationCostModel currentCost : trainingCost) {
                _ps.setInt(1, currentCost.getTrainingId());
                _ps.setString(2, currentCost.getBudjetYear());
                _ps.setString(3, currentCost.getCostTypeCategory());
                _ps.setString(4, currentCost.getCostTypeName());
                _ps.setDouble(5, currentCost.getUnitCost());
                _ps.setDouble(6, currentCost.getTotalCost());
                _ps.setString(7, currentCost.getBatchCode());
                _ps.setInt(8, currentCost.getQuantityOrAmount());
                _ps.setString(9, currentCost.getDocumentReferenceNumber());
                _ps.setString(10, currentCost.getUserName());
                _ps.setString(11, currentCost.getTimeStamp());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainingCosts(ArrayList<EducationCostModel> trainingCost) throws SQLException {
        String _updateQuery = "UPDATE  HR_TRAIN_PROGRESS_COSTS SET " +
                "  TRAININIG_PROGRESS_ID = ? , BUDJET_YEAR= ? , " +
                "  COST_CATEGORY_ID= ? , COST_NAME = ? , UNIT_COST= ? , FACTOR= ? , DOC_REF_NUMBER = ? ,USER_NAME = ? , TIME_STAMP = ? " +
                "  WHERE TRAINING_PROGRESS_COST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (EducationCostModel currentCost : trainingCost) {
                _ps.setInt(1, currentCost.getTrainingId());
                _ps.setString(2, currentCost.getBudjetYear());
                _ps.setString(3, currentCost.getCostTypeCategory());
                _ps.setString(4, currentCost.getCostTypeName());
                _ps.setDouble(5, currentCost.getUnitCost());
                _ps.setInt(6, currentCost.getQuantityOrAmount());
                _ps.setString(7, currentCost.getDocumentReferenceNumber());
                _ps.setString(8, currentCost.getUserName());
                _ps.setString(9, currentCost.getTimeStamp());
                _ps.setString(10, currentCost.getCostTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteTrainingCosts(ArrayList<EducationCostModel> trainingCost) throws SQLException {
        String _updateQuery = "DELETE  HR_TRAIN_PROGRESS_COSTS " +
                "  WHERE TRAINING_PROGRESS_COST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (EducationCostModel currentCost : trainingCost) {
                _ps.setString(1, currentCost.getCostTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTrainingCosts(String budjetYear, int trainingId, String batchCode) throws SQLException {
        String _selectQuery = "SELECT HR_TRAIN_PROGRESS_COSTS.* " +
                "FROM HR_TRAIN_PROGRESS_COSTS " +
                "WHERE HR_TRAIN_PROGRESS_COSTS.BATCH_CODE = ? " +
                "AND TRAININIG_PROGRESS_ID = ? AND BUDJET_YEAR = ?" ;
//                "  (SELECT TRAININIG_PROGRESS_ID " +
//                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
//                "  WHERE HR_TRAIN_NEED_ASSESSEMENT_REQ.BUDJET_YEAR        = ? " +
//                "  AND HR_TRAIN_NEED_ASSESSEMENT_REQ.TRAINING_ID = ? " +
//                "  )";
//                "SELECT HR_TRAIN_PROGRESS_COSTS.* " +
//                "FROM HR_TRAIN_PROGRESS_COSTS " +
//                "WHERE HR_TRAIN_PROGRESS_COSTS.BATCH_CODE = ? " +
//                "AND TRAININIG_PROGRESS_ID                         IN " +
//                "  (SELECT TRAININIG_PROGRESS_ID " +
//                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
//                "  WHERE HR_TRAIN_NEED_ASSESSEMENT_REQ.BUDJET_YEAR        = ? " +
//                "  AND HR_TRAIN_NEED_ASSESSEMENT_REQ.TRAINING_ID = ? " +
//                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setString(1, batchCode);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, trainingId);
            _ps.setString(1, batchCode);
            _ps.setInt(2, trainingId);
            _ps.setString(3, budjetYear);
//            _ps.setString(3, budjetYear);
//            _ps.setInt(4, trainingId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectStationaryCosts() throws SQLException
    {
        String _selectQuery = "SELECT DESCRIPTION, " +
                "  (SELECT fms.FUN_WEIGHTED_AVERAGE(MAT.MATERIAL_CODE,'001') FROM dual " +
                "  ) PRICE " +
                "FROM MMS.MMS_MATERIAL MAT " +
                "WHERE MAT.CATAGORY='STATIONERY'";
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

public ResultSet selectTrainingProgressCostAttributes(String budjetYear, int trainingId, String batchCode) throws SQLException {
        String _selectQuery = "SELECT HR_TRAIN_TRAINING_PROGRESS.* " +
                "FROM HR_TRAIN_TRAINING_PROGRESS " +
                "WHERE HR_TRAIN_TRAINING_PROGRESS.BATCH_CODE = ? " +
                "AND TRAINING_REQUEST_ID                         IN " +
                "  (SELECT TRAININIG_PROGRESS_ID " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "  WHERE HR_TRAIN_NEED_ASSESSEMENT_REQ.BUDJET_YEAR        = ? " +
                "  AND HR_TRAIN_NEED_ASSESSEMENT_REQ.TRAINING_ID = ? " +
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
    public ResultSet selectTrainingCost(String budjetYear, int institutionId, int trainingId) throws SQLException {
        String _selectQuery = "SELECT HR_TRAIN_PROGRESS_COSTS.* " +
                "FROM HR_TRAIN_PROGRESS_COSTS " +
                "WHERE HR_TRAIN_PROGRESS_COSTS.TRAININIG_PROGRESS_ID = ? " +
                "AND TRAININIG_PROGRESS_ID                         IN " +
                "  (SELECT TRAININIG_PROGRESS_ID " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "  WHERE HR_TRAIN_NEED_ASSESSEMENT_REQ.BUDJET_YEAR        = ? " +
                "  AND HR_TRAIN_NEED_ASSESSEMENT_REQ.ASSIGNED_INSTITUTION = ? " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, trainingId);
            _ps.setString(2, budjetYear);
            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean insertTrainingCostPerPerson(ArrayList<TrainingParticipantModel> participants, String trainingType, String startDate, String endDate, double costPerPerson, String startMonth, String startYear, String assignedInstitutionId) throws SQLException{
        String _insertQuery = "INSERT INTO  HR_EMP_TRAINING " +
                " ( ID, EMP_ID, INSTITUTION, PAYMENT_PAYE_BY, TRAININGORCOURSE_NAME, START_DATE, END_DATE," +
                "  PAYMENT_FOR_TRAINING, START_MONTH, START_YEAR )" +
                " VALUES(HR_EMP_TRAINING_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (TrainingParticipantModel participant : participants) {
                _ps.setString(1, participant.getEmployeeId());
                _ps.setString(2, assignedInstitutionId);
                _ps.setString(3, "BIB");
                _ps.setString(4, trainingType);
                _ps.setString(5, startDate);
                _ps.setString(6, endDate);
                _ps.setDouble(7, costPerPerson);
                _ps.setString(8, startMonth);
                _ps.setString(9, startYear);
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    
    public boolean insertDetailTrainingCostPerPerson(ArrayList<TrainingParticipantModel> participants,String trainingType,double trainingFee,double intertainmentFee,double transportFee,double feeForTrainer,double allowanceFee,double stationaryFeeFee,double otherFee,double costPerPerson, String startDate, String endDate, String budjetYear) throws SQLException{
        String _insertQuery = "INSERT INTO  HR_LU_TRAINING_COST_DETAIL " +
                " ( HR_LU_TRAINING_COST_DETAIL_ID, EMP_ID, TRAINING_NAME, TRAINING_FEE, INTERTAINMENT_FEE, TRANSPORT_FEE, FEE_FOR_TRAINER, ALLOWANCE_FEE, STATIONARY_FEE, OTHER_FEES, COSTPERPERSON, " +
                "  START_DATE, END_DATE, BUDJET_YEAR)" +
                " VALUES(HR_LU_TRAINING_COST_DETAIL_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";

//        String _insertCosts = "INSERT INTO  HR_LU_TRAINING_COST_DETAIL " +
//                " ( TRAINING_FEE, INTERTAINMENT_FEE, TRANSPORT_FEE, FEE_FOR_TRAINER, ALLOWANCE_FEE, STATIONARY_FEE, " +
//                "  OTHER_FEES )" +
//                " VALUES(?,?,?,?,?,?,?)";
        try {
//            ArrayList<TrainingProgressCost> cost = new ArrayList<TrainingProgressCost>();
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
//            _ss = _con.prepareStatement(_insertCosts);
            for (TrainingParticipantModel participant : participants) {
                _ps.setString(1, participant.getEmployeeId());
                _ps.setString(2, trainingType);
                _ps.setDouble(3, trainingFee);
                _ps.setDouble(4, intertainmentFee);
                _ps.setDouble(5, transportFee);
                _ps.setDouble(6, feeForTrainer);
                _ps.setDouble(7, allowanceFee);
                _ps.setDouble(8, stationaryFeeFee);
                _ps.setDouble(9, otherFee);
                _ps.setDouble(10, costPerPerson);
                _ps.setString(11, startDate);
                _ps.setString(12, endDate);
                _ps.setString(13, budjetYear);
               _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainingCostPerPerson(ArrayList<TrainingProgressModel> participants, String trainingType, String startDate, String endDate, double costPerPerson, String startMonth, String startYear) throws SQLException{
        String _insertQuery = "UPDATE  HR_EMP_TRAINING  SET " +
                " TRAININGORCOURSE_NAME=?, START_DATE=?, END_DATE=?," +
                " PAYMENT_FOR_TRAINING=?, START_MONTH=?, START_YEAR=?" +
                " WHERE ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (TrainingProgressModel participant : participants) {
                _ps.setString(1, trainingType);
                _ps.setString(2, startDate);
                _ps.setString(3, endDate);
                _ps.setDouble(4, costPerPerson);
                _ps.setString(5, startMonth);
                _ps.setString(6, startYear);
                _ps.setInt(7, participant.getId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

     public boolean updateDetailTrainingCostPerPerson(ArrayList<TrainingProgressCostManger> participants,String trainingType,double trainingFee,double intertainmentFee,double transportFee,double feeForTrainer,double allowanceFee,double stationaryFee,double otherFee,double costPerPerson,String startDate, String endDate, String budjetYear) throws SQLException{
        String _insertQuery = "UPDATE  HR_LU_TRAINING_COST_DETAIL  SET " +
                " TRAINING_NAME=?, TRAINING_FEE=?,INTERTAINMENT_FEE=?,TRANSPORT_FEE=?,FEE_FOR_TRAINER=?,ALLOWANCE_FEE=?,STATIONARY_FEE=?,OTHER_FEES=?, COSTPERPERSON=?, START_DATE=?, END_DATE=?, BUDJET_YEAR=?" +
                " WHERE HR_LU_TRAINING_COST_DETAIL_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (TrainingProgressCostManger participant : participants) {
                _ps.setString(1, trainingType);
                _ps.setDouble(2, trainingFee);
                _ps.setDouble(3, intertainmentFee);
                _ps.setDouble(4, transportFee);
                _ps.setDouble(5, feeForTrainer);
                _ps.setDouble(6, allowanceFee);
                _ps.setDouble(7, stationaryFee);
                _ps.setDouble(8, otherFee);
                _ps.setDouble(9, costPerPerson);
                _ps.setString(10, startDate);
                _ps.setString(11, endDate);
                _ps.setString(12, budjetYear);
                _ps.setDouble(13, participant.getTrainingCostId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet checkTrainingCostPerPerson(String trainingType, String startDate, String endDate) throws SQLException{
        String _selectQuery = "SELECT HR_EMP_TRAINING.* " +
                "FROM HR_EMP_TRAINING " +
                "WHERE TRAININGORCOURSE_NAME = ? AND START_DATE = ? AND END_DATE = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, trainingType);
            _ps.setString(2, startDate);
            _ps.setString(3, endDate);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet checkDetailedTrainingCostPerPerson(String trainingType, String startDate, String endDate) throws SQLException{
        String _selectQuery = "SELECT HR_LU_TRAINING_COST_DETAIL.* " +
                "FROM HR_LU_TRAINING_COST_DETAIL " +
                "WHERE TRAINING_NAME = ? AND START_DATE = ? AND END_DATE = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, trainingType);
            _ps.setString(2, startDate);
            _ps.setString(3, endDate);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean checkSaved(String trainingType, String startDate, String endDate){
        return true;
    }

    public ResultSet selectTrainingCategoryName(String costCategoryId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_TRAIN_ADMIN_COST_TYPES " +
                " WHERE ADMIN_COST_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, costCategoryId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllowance(String employeeId) throws SQLException {
        String _selectQuery = "SELECT RANK_ID, " +
                "SALARY " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE EMP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            for (TrainingParticipantModel currentParticipant : employeeId) {
                _ps.setString(1, employeeId);
//                _ps.addBatch();
//            }
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectRate() throws SQLException {
        String _selectQuery = "SELECT BEGINING_SALARY, " +
                "END_SALARY, " +
                "RATE " +
                "FROM HR_LU_ALLOWANCE_RATE ";
                
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            for (TrainingParticipantModel currentParticipant : employeeId) {
//                _ps.setString(1, employeeId);
//                _ps.addBatch();
//            }
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectRateByRank(String rankId) throws SQLException 
    {
        String _selectQuery = " SELECT RATE " +
                " FROMHR_LU_RANK_ALLOWANCE_RATE " +
                " WHERE RANK_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            for (TrainingParticipantModel currentParticipant : employeeId) {
                _ps.setString(1, rankId);
//                _ps.addBatch();
//            }
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
