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
import manager.educationManager.EducationCostModel;
import manager.trainingManager.TrainingParticipantModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class ActionPlanCostEntity extends ConnectionManager {

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

    public boolean insertTrainingCosts(ArrayList<EducationCostModel> trainingCost) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_TRAIN_TRAINING_COSTS " +
                " (TRAININIG_ID, BUDJET_YEAR," +
                "  COST_CATEGORY_ID, COST_NAME, UNIT_COST , FACTOR, TOTAL, DOC_REF_NUMBER, USER_NAME, TIME_STAMP )" +
                " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EducationCostModel currentCost : trainingCost) {
                _ps.setInt(1, currentCost.getTrainingId());
                _ps.setString(2, currentCost.getBudjetYear());
                _ps.setString(3, currentCost.getCostTypeCategory());
                _ps.setString(4, currentCost.getCostTypeName());
                _ps.setDouble(5, currentCost.getUnitCost());
                _ps.setInt(6, currentCost.getQuantityOrAmount());
                _ps.setDouble(7, currentCost.getTotalCost());
                _ps.setString(8, currentCost.getDocumentReferenceNumber());
                _ps.setString(9, currentCost.getUserName());
                _ps.setString(10, currentCost.getTimeStamp());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainingCosts(ArrayList<EducationCostModel> trainingCost) throws SQLException {
        String _updateQuery = "UPDATE  HR_TRAIN_TRAINING_COSTS SET " +
                "  TRAININIG_ID = ? , BUDJET_YEAR= ? , " +
                "  COST_CATEGORY_ID= ? , COST_NAME = ? , UNIT_COST= ? , FACTOR= ? , DOC_REF_NUMBER = ? ,USER_NAME = ? , TIME_STAMP = ? " +
                "  WHERE TRAINING_COST_ID = ? ";
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
        String _updateQuery = "DELETE  HR_TRAIN_TRAINING_COSTS " +
                "  WHERE TRAINING_COST_ID = ? ";
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

    public ResultSet selectTrainingCostPlans(String budjetYear, int institutionId, int trainingId) throws SQLException {
        String _selectQuery = "SELECT HR_TRAIN_TRAINING_COSTS.* " +
                "FROM HR_TRAIN_TRAINING_COSTS " +
                "WHERE HR_TRAIN_TRAINING_COSTS.TRAININIG_ID=? " +
                "AND TRAININIG_ID                         IN " +
                "  (SELECT TRAININIG_ID " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ " +
                "  WHERE HR_TRAIN_NEED_ASSESSEMENT_REQ.BUDJET_YEAR       =? " +
                "  AND HR_TRAIN_NEED_ASSESSEMENT_REQ.ASSIGNED_INSTITUTION=? " +
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

    public ResultSet selectStationaryCosts() throws SQLException {
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
//        String _selectQuery = "SELECT BEGIN_SALARY, " +
//                "END_SALARY, " +
//                "RATE " +
//                "FROM FMS.FMS_ALLOWANCE_RATE ";
       String _selectQuery = " SELECT BEGINING_SALARY, " +
                " END_SALARY, " +
                " RATE " +
                " FROM HR_LU_ALLOWANCE_RATE ";

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

    public ResultSet selectRateByRank(String rankId) throws SQLException {
        String _selectQuery = "SELECT RATE " +
                "FROM HR_LU_RANK_ALLOWANCE_RATE " +
                "WHERE RANK_ID=?";

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
