/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import entity.trainingEntity.TrainingTypesRegistrationEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Mugher
 */
public class TrainingTypesRegistrationManger {

    TrainingTypesRegistrationEntity trainingTypesRegistrationEntity = new TrainingTypesRegistrationEntity();

    public boolean saveTraining(TrainingTypesModel training) {
        try {
            trainingTypesRegistrationEntity.insertTraining(training);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateTraining(TrainingTypesModel training) {
        try {
            trainingTypesRegistrationEntity.updateTraining(training);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean deleteTraining(int trainingid) {
        try {
            trainingTypesRegistrationEntity.deleteTraining(trainingid);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public TrainingTypesModel getTraining(int trainingTypeId) {
        TrainingTypesModel currentTraining = new TrainingTypesModel();
        try {
            ResultSet _rs = trainingTypesRegistrationEntity.selectTraining(trainingTypeId);
            if (_rs.next()) {
                currentTraining.setTrainingTypeId(trainingTypeId);//
                currentTraining.setTrainingName(_rs.getString("TRAININIG_NAME"));
                currentTraining.setDescription(_rs.getString("DESCRIPTION"));//
                currentTraining.setTrainingCategory(_rs.getString("TRAINING_CATEGORY"));//
                currentTraining.setDurationCategory(_rs.getString("DURATION_CATEGORY"));//
                currentTraining.setExpectedOutput(_rs.getString("EXPECTED_OUTCOME"));
            }
            _rs.close();
            return currentTraining;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveTrainings(ArrayList<TrainingTypesModel> trainingTypesList) {
        ArrayList<TrainingTypesModel> toBeInserted = new ArrayList<TrainingTypesModel>();
        ArrayList<TrainingTypesModel> toBeUpdated = new ArrayList<TrainingTypesModel>();
        ArrayList<TrainingTypesModel> toBeDeleted = new ArrayList<TrainingTypesModel>();
        try {
            for (TrainingTypesModel currentTraining : trainingTypesList) {
                if (currentTraining.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentTraining);
                } else if (currentTraining.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(currentTraining);
                } else if (currentTraining.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentTraining);
                }
                trainingTypesRegistrationEntity.insertTrainings(toBeInserted);
                trainingTypesRegistrationEntity.updateTrainings(toBeUpdated);
                trainingTypesRegistrationEntity.deleteTrainings(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<TrainingTypesModel> getAllTrainings22() {
        ArrayList<TrainingTypesModel> trainingList = new ArrayList<TrainingTypesModel>();
        try {
            ResultSet _rs = trainingTypesRegistrationEntity.selectAllTrainings();
            while (_rs.next()) {
                TrainingTypesModel currentTraining = new TrainingTypesModel();
                currentTraining.setTrainingTypeId(_rs.getInt("TRAINING_TYPE_ID"));//
                currentTraining.setTrainingName(_rs.getString("TRAININIG_NAME"));
                currentTraining.setDescription(_rs.getString("DESCRIPTION"));//
                currentTraining.setTrainingCategory(_rs.getString("TRAINING_CATEGORY"));//
                currentTraining.setDurationCategory(_rs.getString("DURATION_CATEGORY"));//                
                currentTraining.setExpectedOutput(_rs.getString("EXPECTED_OUTCOME"));
                currentTraining.setDatabaseStatus("Old");  //
                trainingList.add(currentTraining);
            }
            _rs.close();
            return trainingList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllTrainings() {
        ArrayList<SelectItem> trainingList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingTypesRegistrationEntity.selectAllTrainings();
            // trainingList.add(new SelectItem("-1", "--SELECT TRAINING--"));
            while (_rs.next()) {
                trainingList.add(new SelectItem(_rs.getInt("TRAINING_TYPE_ID"), _rs.getString("TRAININIG_NAME")));
            }
            _rs.close();
            return trainingList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
