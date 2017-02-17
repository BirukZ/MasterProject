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
import manager.trainingManager.TrainingTypesModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Mugher
 */
public class TrainingTypesRegistrationEntity extends ConnectionManager {

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

    public boolean insertTraining(TrainingTypesModel currentTraining) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_LU_TRAIN_TRAINING_TYPES " +
                " ( TRAINING_TYPE_ID, TRAININIG_NAME, DESCRIPTION, TRAINING_CATEGORY, DURATION_CATEGORY , EXPECTED_OUTCOME )" +
                " VALUES(HR_LU_TRAIN_TRAINING_TYPES_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, currentTraining.getTrainingName());
            _ps.setString(2, currentTraining.getDescription());
            _ps.setString(3, currentTraining.getTrainingCategory());
            _ps.setString(4, currentTraining.getDurationCategory());
            _ps.setString(5, currentTraining.getExpectedOutput());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTraining(TrainingTypesModel currentTraining) throws SQLException {
        String _updateQuery = "UPDATE  HR_LU_TRAIN_TRAINING_TYPES " +
                " SET   TRAININIG_NAME = ? ,  DESCRIPTION = ? ,  TRAINING_CATEGORY = ? ,  DURATION_CATEGORY  = ? ,  EXPECTED_OUTCOME = ? " +
                " WHERE TRAINING_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, currentTraining.getTrainingName());
            _ps.setString(2, currentTraining.getDescription());
            _ps.setString(3, currentTraining.getTrainingCategory());
            _ps.setString(4, currentTraining.getDurationCategory());
            _ps.setString(5, currentTraining.getExpectedOutput());
            _ps.setInt(6, currentTraining.getTrainingTypeId());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteTraining(int trainingTypeId) throws SQLException {
        String _deleteQuery = "DELETE  HR_LU_TRAIN_TRAINING_TYPES " +
                " WHERE TRAINING_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, trainingTypeId);
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertTrainings(ArrayList<TrainingTypesModel> trainingList) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_LU_TRAIN_TRAINING_TYPES " +
                " ( TRAINING_TYPE_ID, TRAININIG_NAME, DESCRIPTION, TRAINING_CATEGORY, DURATION_CATEGORY , EXPECTED_OUTCOME )" +
                " VALUES(HR_LU_TRAIN_TRAINING_TYPES_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (TrainingTypesModel currentTraining : trainingList) {
                _ps.setString(1, currentTraining.getTrainingName());
                _ps.setString(2, currentTraining.getDescription());
                _ps.setString(3, currentTraining.getTrainingCategory());
                _ps.setString(4, currentTraining.getDurationCategory());
                _ps.setString(5, currentTraining.getExpectedOutput());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainings(ArrayList<TrainingTypesModel> trainingList) throws SQLException {
        String _updateQuery = "UPDATE  HR_LU_TRAIN_TRAINING_TYPES " +
                " SET   TRAININIG_NAME = ? ,  DESCRIPTION = ? ,  TRAINING_CATEGORY = ? ,  DURATION_CATEGORY  = ? ,  EXPECTED_OUTCOME = ? " +
                " WHERE TRAINING_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (TrainingTypesModel currentTraining : trainingList) {
                _ps.setString(1, currentTraining.getTrainingName());
                _ps.setString(2, currentTraining.getDescription());
                _ps.setString(3, currentTraining.getTrainingCategory());
                _ps.setString(4, currentTraining.getDurationCategory());
                _ps.setString(5, currentTraining.getExpectedOutput());
                _ps.setInt(6, currentTraining.getTrainingTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteTrainings(ArrayList<TrainingTypesModel> trainingList) throws SQLException {
        String _deleteQuery = "DELETE  HR_LU_TRAIN_TRAINING_TYPES " +
                " WHERE TRAINING_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            for (TrainingTypesModel currentTraining : trainingList) {
                _ps.setInt(1, currentTraining.getTrainingTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllTrainings() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_TRAIN_TRAINING_TYPES ";
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

    public ResultSet selectTraining(int trainingTypeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_TRAIN_TRAINING_TYPES " +
                " WHERE TRAINING_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, trainingTypeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
