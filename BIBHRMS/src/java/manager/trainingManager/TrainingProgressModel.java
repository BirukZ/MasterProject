/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

/**
 *
 * @author Mugher
 */
public class TrainingProgressModel {

    int progressId;
    String budjetYear;
    int trainingRequestId;
    String batchCode;
    String progressStatus;
    String startDate;
    String endDate;
    String timeStamp;
    String userName;
    String trainingType;
    int id;
    String paymentForTraining;

    public TrainingProgressModel() {
    }
    public TrainingProgressModel(int id, String trainingType, String startDate, String endDate, String paymentForTraining) {
        this.trainingType = trainingType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
        this.paymentForTraining = paymentForTraining;
    }


    public TrainingProgressModel(String budjetYear, int trainingRequestId, String batchCode, String progrssStatus, String startDate, String endDate) {
        this.budjetYear = budjetYear;
        this.trainingRequestId = trainingRequestId;
        this.batchCode = batchCode;
        this.progressStatus = progrssStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TrainingProgressModel(int progressId, String budjetYear, int trainingRequestId, String batchCode, String progrssStatus, String startDate, String endDate) {
        this.progressId = progressId;
        this.budjetYear = budjetYear;
        this.trainingRequestId = trainingRequestId;
        this.batchCode = batchCode;
        this.progressStatus = progrssStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TrainingProgressModel(int progressId, String budjetYear, int trainingRequestId, String batchCode, String progrssStatus, String startDate, String endDate, String timeStamp, String userName) {
        this.progressId = progressId;
        this.budjetYear = budjetYear;
        this.trainingRequestId = trainingRequestId;
        this.batchCode = batchCode;
        this.progressStatus = progrssStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeStamp = timeStamp;
        this.userName = userName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(String budjetYear) {
        this.budjetYear = budjetYear;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }



    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getTrainingRequestId() {
        return trainingRequestId;
    }

    public void setTrainingRequestId(int trainingRequestId) {
        this.trainingRequestId = trainingRequestId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentForTraining() {
        return paymentForTraining;
    }

    public void setPaymentForTraining(String paymentForTraining) {
        this.paymentForTraining = paymentForTraining;
    }
    



}
