/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import java.io.Serializable;

/**
 *
 * @author mekete
 */
public class InternalTrainnersModel implements Serializable {

    int trainnerGroupId;
    int trainnerMemberId;
    String trainnerGroupName;
    String trainnerGroupStatus;
    String trainnerMmemberStatus;
    String description;
    String trainingCategory;
    //=========================
    String employeeId;
    String assignedDate;
    String memberStatus;
    String employeeFullName;
    String employeeResponsibility;
    //=================
    String userName;
    String timeStamp;
    boolean selected;
    String databaseStatus;
    String saveOrUpdateLabel;
    String deleteOrremoveLabel;

    public InternalTrainnersModel() {
    }

    public InternalTrainnersModel(int trainnerGroupId) {
        this.trainnerGroupId = trainnerGroupId;
    }

    public InternalTrainnersModel(int trainnerGroupId, String trainnerGroupName, String trainnerGroupStatus, String description, String trainingCategory) {
        this.trainnerGroupId = trainnerGroupId;
        this.trainnerGroupName = trainnerGroupName;
        this.trainnerGroupStatus = trainnerGroupStatus;
        this.description = description;
        this.trainingCategory = trainingCategory;
    }

    public InternalTrainnersModel(int trainnerGroupId, int trainnerMemberId, String trainnerMmemberStatus, String employeeId, String employeeFullName, String employeeResponsibility, String databaseStatus) {
        this.trainnerGroupId = trainnerGroupId;
        this.trainnerMemberId = trainnerMemberId;
        this.trainnerMmemberStatus = trainnerMmemberStatus;
        this.employeeId = employeeId;
        this.employeeFullName = employeeFullName;
        this.employeeResponsibility = employeeResponsibility;
        this.databaseStatus = databaseStatus;
    }

    public InternalTrainnersModel(int trainnerGroupId, int trainnerMemberId, String employeeId, String assignedDate, String memberStatus, String employeeFullName, String employeeResponsibility, String databaseStatus) {
        this.trainnerGroupId = trainnerGroupId;
        this.trainnerMemberId = trainnerMemberId;
        this.employeeId = employeeId;
        this.assignedDate = assignedDate;
        this.memberStatus = memberStatus;
        this.employeeFullName = employeeFullName;
        this.employeeResponsibility = employeeResponsibility;
        this.databaseStatus = databaseStatus;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getDeleteOrremoveLabel() {
        return deleteOrremoveLabel;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public void setDeleteOrremoveLabel(String deleteOrremoveLabel) {
        this.deleteOrremoveLabel = deleteOrremoveLabel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeResponsibility() {
        return employeeResponsibility;
    }

    public void setEmployeeResponsibility(String employeeResponsibility) {
        this.employeeResponsibility = employeeResponsibility;
    }

    public String getSaveOrUpdateLabel() {
        return saveOrUpdateLabel;
    }

    public void setSaveOrUpdateLabel(String saveOrUpdateLabel) {
        this.saveOrUpdateLabel = saveOrUpdateLabel;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getTrainnerGroupId() {
        return trainnerGroupId;
    }

    public String getTrainnerGroupName() {
        return trainnerGroupName;
    }



    public String getTrainingCategory() {
        return trainingCategory;
    }

    public void setTrainingCategory(String trainingCategory) {
        this.trainingCategory = trainingCategory;
    }

    public void setTrainnerGroupName(String trainnerGroupName) {
        this.trainnerGroupName = trainnerGroupName;
    }

    public void setTrainnerGroupId(int trainnerGroupId) {
        this.trainnerGroupId = trainnerGroupId;
    }

    public String getTrainnerGroupStatus() {
        return trainnerGroupStatus;
    }

    public void setTrainnerGroupStatus(String trainnerGroupStatus) {
        this.trainnerGroupStatus = trainnerGroupStatus;
    }

    public int getTrainnerMemberId() {
        return trainnerMemberId;
    }

    public void setTrainnerMemberId(int trainnerMemberId) {
        this.trainnerMemberId = trainnerMemberId;
    }

    public String getTrainnerMmemberStatus() {
        return trainnerMmemberStatus;
    }

    public void setTrainnerMmemberStatus(String trainnerMmemberStatus) {
        this.trainnerMmemberStatus = trainnerMmemberStatus;
    }
}
