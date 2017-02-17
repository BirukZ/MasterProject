/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import entity.trainingEntity.TrainingProgressEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.educationManager.EducationCostModel;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class TrainingProgressManager {

    TrainingProgressEntity trainingProgressEntity = new TrainingProgressEntity();

    public TrainingProgressModel getProgressDetail(int progressId) {
        TrainingProgressModel trainingProgress = new TrainingProgressModel();
        try {
            ResultSet _rs = trainingProgressEntity.selectProgress(progressId);
            if (_rs.next()) {
                trainingProgress.setProgressId(progressId);
                trainingProgress.setBudjetYear(_rs.getString("BUGJET_YEAR"));
                trainingProgress.setStartDate(_rs.getString("START_DATE"));
                trainingProgress.setEndDate(_rs.getString("END_DATE"));
                trainingProgress.setBatchCode(_rs.getString("BATCH_CODE"));
                trainingProgress.setProgressStatus(_rs.getString("PROGRESS_STATUS"));
            } else {
                trainingProgress.setProgressId(-1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return trainingProgress;
    }

    public boolean saveProgressChanges(TrainingProgressModel trainingProgress, ArrayList<SelectItem> assignedEmployeesList, ArrayList<SelectItem> notAssignedEmployeesList) {
        try {
            if (trainingProgressEntity.insertTrainingProgress(trainingProgress)) {
                return trainingProgressEntity.updateAssignedAndNotAssignedEmployees(trainingProgress, assignedEmployeesList, notAssignedEmployeesList);
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateProgressChanges(TrainingProgressModel trainingProgress, ArrayList<SelectItem> assignedEmployeesList, ArrayList<SelectItem> notAssignedEmployeesList) {
        try {
            if (trainingProgressEntity.updateTrainingProgress(trainingProgress)) {
                return trainingProgressEntity.updateAssignedAndNotAssignedEmployees(trainingProgress, assignedEmployeesList, notAssignedEmployeesList);
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveTrainningCosts(ArrayList<EducationCostModel> committeeList) {
        ArrayList<EducationCostModel> toBeInserted = new ArrayList<EducationCostModel>();
        ArrayList<EducationCostModel> toBeUpdated = new ArrayList<EducationCostModel>();
        ArrayList<EducationCostModel> toBeDeleted = new ArrayList<EducationCostModel>();
        try {
            for (EducationCostModel currentCommittee : committeeList) {
                if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentCommittee);
                } else if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(currentCommittee);
                } else if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentCommittee);
                }
                trainingProgressEntity.insertTrainingCosts(toBeInserted);
                trainingProgressEntity.updateTrainingCosts(toBeUpdated);
                trainingProgressEntity.deleteTrainingCosts(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<SelectItem> getTrainnedEmployees(String budjetYear, int trainingId, String batchCode) {
        ArrayList<SelectItem> trainnedEmployeesList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingProgressEntity.selectTrainnedEmployees(budjetYear, trainingId, batchCode);
            while (_rs.next()) {
                trainnedEmployeesList.add(new SelectItem(_rs.getString("TRAIN_NEED_ASSESS_EMP_LIST_ID"), _rs.getString("FIRST_NAME") + "" + _rs.getString("MIDDLE_NAME") + "" + _rs.getString("LAST_NAME")));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            ErrorLogWriter.writeError(sqle);
        }
        return trainnedEmployeesList;
    }

    public ArrayList<SelectItem> getNotTrainnedEmployees(String budjetYear, int trainingId) {
        ArrayList<SelectItem> notTrainnedEmployeesList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingProgressEntity.selectNotTrainnedEmployees(budjetYear, trainingId);
            while (_rs.next()) {
                notTrainnedEmployeesList.add(new SelectItem(_rs.getString("TRAIN_NEED_ASSESS_EMP_LIST_ID"), _rs.getString("FIRST_NAME") + "" + _rs.getString("MIDDLE_NAME") + "" + _rs.getString("LAST_NAME")));
//               notTrainnedEmployeesList.add(new SelectItem(_rs.getString("EMP_ID"), _rs.getString("FIRST_NAME") + "" + _rs.getString("MIDDLE_NAME") + "" + _rs.getString("LAST_NAME")));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            ErrorLogWriter.writeError(sqle);
        }
        return notTrainnedEmployeesList;
    }

    public ArrayList<SelectItem> getNotTrainnedEmployeesDropDown(String budjetYear, int trainingId) {
        ArrayList<SelectItem> trainnedEmployeesList = new ArrayList<SelectItem>();
        trainnedEmployeesList.add(new SelectItem("-1", "--SELECT EMPLOYEE--"));
        try {
            ResultSet _rs = trainingProgressEntity.selectNotTrainnedEmployees(budjetYear, trainingId);
            while (_rs.next()) {
                trainnedEmployeesList.add(new SelectItem(_rs.getString("EMPLOYEE_ID"), _rs.getString("FIRST_NAME") + "" + _rs.getString("MIDDLE_NAME") + "" + _rs.getString("LAST_NAME")));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            ErrorLogWriter.writeError(sqle);
        }
        return trainnedEmployeesList;
    }

    public int getProgressStatus(String budjetYear, int trainingId, String batchCode) {
        try {
            ResultSet _rs = trainingProgressEntity.selectProgressStatus(budjetYear, trainingId, batchCode);
            if (_rs.next()) {
                return _rs.getInt("PROGRESS_ID");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            ErrorLogWriter.writeError(sqle);
        }
        return -1;
    }

    public ArrayList<SelectItem> getBatchLists() {
        ArrayList<SelectItem> batchList = new ArrayList<SelectItem>();
        batchList.add(new SelectItem("-1", "--SELECT BATCH--"));
        for (int counter = 1; counter < 20; counter++) {
            batchList.add(new SelectItem(counter, "Batch - " + counter));
        }
        return batchList;
    }

    public ArrayList<SelectItem> getProgressTypes() {
        ArrayList<SelectItem> progressTypesList = new ArrayList<SelectItem>();
        progressTypesList.add(new SelectItem("-1", "--SELECT PROGRESS--"));
        progressTypesList.add(new SelectItem("RQ", "Requested"));
        progressTypesList.add(new SelectItem("WA", "On pending for approval"));
        progressTypesList.add(new SelectItem("PR", "On pregress"));
        progressTypesList.add(new SelectItem("CT", "Completed"));
        progressTypesList.add(new SelectItem("QT", "Quited"));

        return progressTypesList;
    }
}
