/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

/**
 *
 * @author mekete
 */
public class ActionPlanModel {

    int institutionTrainingId;  //TRAIN_ASSIGNED_INSTITUTIONS_ID
    String budjetYear;//BUDJET_YEAR
    int institutionId;// INSTITUTION_ID
    String assignedTrainingsList;//         ASSIGNED_TRAINING_LISTS

    public String getAssignedTrainingsList() {
        return assignedTrainingsList;
    }

    public void setAssignedTrainingsList(String assignedTrainingsList) {
        this.assignedTrainingsList = assignedTrainingsList;
    }


    public String getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(String budjetYear) {
        this.budjetYear = budjetYear;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public int getInstitutionTrainingId() {
        return institutionTrainingId;
    }

    public void setInstitutionTrainingId(int institutionTrainingId) {
        this.institutionTrainingId = institutionTrainingId;
    }



}
