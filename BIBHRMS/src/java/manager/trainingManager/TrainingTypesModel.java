/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

/**
 *
 * @author Mugher
 */
public class TrainingTypesModel {

    
    int trainingTypeId;
    String trainingCategory;
    String durationCategory;
    String trainingName;
    String description;
    String expectedOutput;
    String databaseStatus;
    String username;
    String timeStamp;

    public TrainingTypesModel() {
    }

    public TrainingTypesModel(int trainingTypeId, String trainingCategory, String durationCategory, String trainingName, String description, String expectedOutput) {
        this.trainingTypeId = trainingTypeId;
        this.trainingCategory = trainingCategory;
        this.durationCategory = durationCategory;
        this.trainingName = trainingName;
        this.description = description;
        this.expectedOutput = expectedOutput;
        
    }

    public TrainingTypesModel(int trainingTypeId, String trainingName, String description, String trainingCategory, String durationCategory, String expectedOutput, String status) {
        this.trainingTypeId = trainingTypeId;
        this.trainingCategory = trainingCategory;
        this.durationCategory = durationCategory;
        this.trainingName = trainingName;
        this.description = description;
        this.expectedOutput = expectedOutput;
        this.databaseStatus = status;

    }

    public TrainingTypesModel(int trainingTypeId, String trainingCategory, String durationCategory, String trainingName, String description, String expectedOutput, String username, String timeStamp) {
        this(trainingTypeId, trainingCategory, durationCategory, trainingName, description, expectedOutput);
        this.username = username;
        this.timeStamp = timeStamp;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTrainingCategory() {
        return trainingCategory;
    }

    public void setTrainingCategory(String trainingCategory) {
        this.trainingCategory = trainingCategory;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDurationCategory() {
        return durationCategory;
    }

    public void setDurationCategory(String durationCategory) {
        this.durationCategory = durationCategory;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public int getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(int trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
