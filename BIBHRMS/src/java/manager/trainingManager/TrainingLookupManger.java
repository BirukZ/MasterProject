/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import entity.trainingEntity.TrainingLookupEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class TrainingLookupManger {

    TrainingLookupEntity trainingLookupEntity = new TrainingLookupEntity();

    public ArrayList<SelectItem> getAllDurationCategories() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingLookupEntity.selectAllDurationCategories();
            categoryList.add(new SelectItem("-1", "--SELECT DURATION--"));
            while (_rs.next()) {
                categoryList.add(new SelectItem(_rs.getString("CATEGORY_ID"), _rs.getString("CATEGORY_NAME")));
            }
            _rs.close();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    @Deprecated
    public ArrayList<SelectItem> getMemberStatus() {
        return (new CommitteeRegistrationManager()).getCommitteeStatus();
    }

    public ArrayList<SelectItem> getPlannedOrUnplannedList() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        categoryList.add(new SelectItem("-1", "--SELECT --"));
        categoryList.add(new SelectItem("PL", "Fot request"));
        categoryList.add(new SelectItem("UN", "For "));
        return categoryList;
    }

    public ArrayList<SelectItem> getDurationCategoryList() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        categoryList.add(new SelectItem("-1", "--SELECT --"));
        categoryList.add(new SelectItem("LN", "Long (Greater than 1 month)"));
        categoryList.add(new SelectItem("MD", "Medium  (Between 15 days and 3 month)"));
        categoryList.add(new SelectItem("SH", "Short (Lessthan or equal to 15 days) "));
        return categoryList;
    }

    public ArrayList<SelectItem> getAllPriorityCategories() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingLookupEntity.selectAllPriorityCategories();
            categoryList.add(new SelectItem("-1", "--SELECT PRIORITY--"));
            while (_rs.next()) {
                categoryList.add(new SelectItem(_rs.getString("CATEGORY_ID"), _rs.getString("CATEGORY_NAME")));
            }
            _rs.close();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllTrainerCategories() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            categoryList.add(new SelectItem("-1", "--SELECT TRAINER--"));
            categoryList.add(new SelectItem("BIB", "Inside BIB"));
            categoryList.add(new SelectItem("IN", "Inside Ethiopia"));
            categoryList.add(new SelectItem("OUT", "Outside Ethiopia"));

            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getOnorOffWork() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            categoryList.add(new SelectItem("-1", "-SELECT ON/OFF WORK--"));
            categoryList.add(new SelectItem("ON", "On Work"));
            categoryList.add(new SelectItem("OFF", "Off Work"));
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllTrainingLevels() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            categoryList.add(new SelectItem("-1", "--SELECT LEVEL--"));
            categoryList.add(new SelectItem("BG", " Beggner"));
            categoryList.add(new SelectItem("NR", " Normal"));
            categoryList.add(new SelectItem("AD", " Advanced"));

            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllTrainingNames() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingLookupEntity.selectAllTrainingNames();
            categoryList.add(new SelectItem("-1", "--SELECT TRAINING TITLE--"));
            while (_rs.next()) {
                categoryList.add(new SelectItem(_rs.getString("TRAINING_TYPE_ID") + "--" + _rs.getString("TRAININIG_NAME"), _rs.getString("TRAININIG_NAME")));
            }
            _rs.close();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

//    public ArrayList<SelectItem> getAllTrainingNamesEmployeeTaken(String participantId) {
//        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
//        try {
//            ResultSet _rs = trainingLookupEntity.selectAllTrainingNamesEmployeeTaken(participantId);
//            categoryList.add(new SelectItem("-1", "--SELECT CATEGORY--"));
//            while (_rs.next()) {
//                categoryList.add(new SelectItem(_rs.getString("TRAINING_TYPE_ID") + "--" + _rs.getString("TRAININIG_NAME"), _rs.getString("TRAININIG_NAME")));
//            }
//            _rs.close();
//            return categoryList;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }
        public ArrayList<SelectItem> getAllTrainingNames(String trainingCategory) {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingLookupEntity.selectAllTrainingNames(trainingCategory);
            categoryList.add(new SelectItem("-1", "--SELECT TRAINING TITLE--"));
            while (_rs.next()) {
                categoryList.add(new SelectItem(_rs.getString("TRAINING_TYPE_ID") + "--" + _rs.getString("TRAININIG_NAME"), _rs.getString("TRAININIG_NAME")));
            }
            _rs.close();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllTrainingCategories() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingLookupEntity.selectAllTrainingCategories();
            categoryList.add(new SelectItem("-1", "--SELECT CATEGORY--"));
            while (_rs.next()) {
                categoryList.add(new SelectItem(_rs.getString("CATEGORY_ID"), _rs.getString("CATEGORY_NAME")));
            }
            _rs.close();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllTrainingNeedSourceTypes() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingLookupEntity.selectAllTrainingNeedSourceTypes();
            categoryList.add(new SelectItem("-1", "--SELECT TRAINING REASON--"));
            while (_rs.next()) {
                categoryList.add(new SelectItem(_rs.getString("TRAINING_REASON_ID")+"-"+_rs.getString("TRAINING_REASON"), _rs.getString("TRAINING_REASON")));
            }
            _rs.close();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllCostTypes() {
        ArrayList<SelectItem> categoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingLookupEntity.selectAllTrainingCostTypes();
            categoryList.add(new SelectItem("-1", "--SELECT TYPE--"));
            while (_rs.next()) {
               // categoryList.add(new SelectItem(_rs.getString("ADMIN_COST_TYPE_ID"), _rs.getString("COST_TYPE_NAME")));
                categoryList.add(new SelectItem(_rs.getString("ADMIN_COST_TYPE_ID"), _rs.getString("COST_TYPE_NAME")));

            }
            _rs.close();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllBudgetYears() {
        ArrayList<SelectItem> budjetYearList = new ArrayList<SelectItem>();
        try {
            budjetYearList.add(new SelectItem("-1", "--SELECT YEAR--"));
            for (int budjetYear = 2000; budjetYear < 2080; budjetYear++) {
                budjetYearList.add(new SelectItem(Integer.toString(budjetYear), Integer.toString(budjetYear)));
            }
            return budjetYearList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
