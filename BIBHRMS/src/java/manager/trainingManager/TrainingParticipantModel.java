/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

/**
 *
 * @author mekete
 */
public class TrainingParticipantModel {

    int trainingParticipantId;
    int trainingNeedRequestId;
    String employeeId;
    String fullName;
    String referencingTableId;
    String departmentName;
    String jobTitleName;
    String databaseStatus;
    String batchCode;
    private boolean selected;
    String status;
    String userName;
    String timeStamp;
   int selectedRowsss;

    public TrainingParticipantModel() {
    }

    public TrainingParticipantModel(int trainingParticipantId, int trainingNeedRequestId, String employeeId, String fullName, String jobTitleName, String databaseStatus, String batchCode, boolean selected) {
        this.trainingParticipantId = trainingParticipantId;
        this.trainingNeedRequestId = trainingNeedRequestId;
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.jobTitleName = jobTitleName;
        this.databaseStatus = databaseStatus;
        this.batchCode = batchCode;
        this.selected = selected;
    }
        public TrainingParticipantModel(int trainingParticipantId, int trainingNeedRequestId,String employeeId, String fullName, String departmentName, String jobTitleName, String databaseStatus) {
        this.trainingParticipantId = trainingParticipantId;
        this.trainingNeedRequestId=trainingNeedRequestId;
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.departmentName = departmentName;
        this.jobTitleName = jobTitleName;
        this.databaseStatus = databaseStatus;
    }

    public TrainingParticipantModel(int trainingParticipantId, String employeeId, String fullName, String departmentName, String jobTitleName, String databaseStatus) {
        this.trainingParticipantId = trainingParticipantId;
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.departmentName = departmentName;
        this.jobTitleName = jobTitleName;
        this.databaseStatus = databaseStatus;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobTitleName() {
        return jobTitleName;
    }

    public void setJobTitleName(String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }

    public int getSelectedRowsss() {
        return selectedRowsss;
    }

    public void setSelectedRowsss(int selectedRowsss) {
        this.selectedRowsss = selectedRowsss;
    }

    public String getReferencingTableId() {
        return referencingTableId;
    }

    public void setReferencingTableId(String referencingTableId) {
        this.referencingTableId = referencingTableId;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public boolean isSelected() {
        return selected;
    }

//    public int getSelectedRow() {
//        return selectedRow;
//    }
//
//    public void setSelectedRow(int selectedRow) {
//        this.selectedRow = selectedRow;
//    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTrainingNeedRequestId() {
        return trainingNeedRequestId;
    }

    public void setTrainingNeedRequestId(int trainingNeedRequestId) {
        this.trainingNeedRequestId = trainingNeedRequestId;
    }

    public int getTrainingParticipantId() {
        return trainingParticipantId;
    }

    public void setTrainingParticipantId(int trainingParticipantId) {
        this.trainingParticipantId = trainingParticipantId;
    }
  public static class TrainigReaoun{

       String description;
       String trainigResoun;
       int trainirReaounID;

     public TrainigReaoun( String description, String TrainigReasoun){
            this.description=description;
            this.trainigResoun=TrainigReasoun;
        }

 public int getTrainirReaounID() {
            return trainirReaounID;
        }

        public void setTrainirReaounID(int trainirReaounID) {
            this.trainirReaounID = trainirReaounID;
        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrainigResoun() {
        return trainigResoun;
    }

    public void setTrainigResoun(String trainigResoun) {
        this.trainigResoun = trainigResoun;
    }

        public TrainigReaoun(String description, String trainigResoun, int trainirReaounID ) {
            this.description = description;
            this.trainigResoun = trainigResoun;
            this.trainirReaounID=trainirReaounID;
     }
        public TrainigReaoun() {

      }

    }

}
