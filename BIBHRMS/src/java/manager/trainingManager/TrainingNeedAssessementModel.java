/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

/**
 *
 * @author mekete
 */
public class TrainingNeedAssessementModel {

    int trainingNeedAttributesId;
    int trainingNeedRequestId;
    String requesterId;
    String appliedDate;
    String budjetYear;
    String planedOrUnplanned;
    String needSource;
    String trainingCategory;
    String trainingId;
    String trainingName;
    String generalComment;
    String trainerType;
    String institutionOrPlace;
    String assignedInstitutionOrEmployees;
    String durationCategory;
    String tentativeStartDate;
    String tentativeEndDate;
    String priorityCategory;
    String requestPurpose;
    double costPerPerson;
    double otherEstimatedCosts;
    String recordedDateAndTime;
    String userName;
    String requestStatus;
    String  databaseStatus;
    int numberOfEmployees;
    String noOfDays;
    String award;
    String trainerName;
    String trainerProfession;

    public TrainingNeedAssessementModel() {
    }

    public TrainingNeedAssessementModel(String requesterId, String appliedDate, String budjetYear, String planedOrUnplanned, String needSource, String trainingCategory, String trainingId, String trainingName, String generalComment, String trainerType, String institutionOrPlace, String durationCategory, String tentativeStartDate, String tentativeEndDate, String priorityCategory, double costPerPerson, double otherEstimatedCosts) {
        this.requesterId = requesterId;
        this.appliedDate = appliedDate;
        this.budjetYear = budjetYear;
        this.planedOrUnplanned = planedOrUnplanned;
        this.needSource = needSource;
        this.trainingCategory = trainingCategory;
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.generalComment = generalComment;
        this.trainerType = trainerType;
        this.institutionOrPlace = institutionOrPlace;
        this.durationCategory = durationCategory;
        this.tentativeStartDate = tentativeStartDate;
        this.tentativeEndDate = tentativeEndDate;
        this.priorityCategory = priorityCategory;
        this.costPerPerson = costPerPerson;
        this.otherEstimatedCosts = otherEstimatedCosts;
    }

    public TrainingNeedAssessementModel(String requesterId, String appliedDate, String budjetYear, String planedOrUnplanned, String needSource, String trainingCategory, String trainingId, String trainingName, String generalComment, String trainerType, String institutionOrPlace, String durationCategory, String tentativeStartDate, String tentativeEndDate, String priorityCategory, int numberOfEmployee) {
        this.requesterId = requesterId;
        this.appliedDate = appliedDate;
        this.budjetYear = budjetYear;
        this.planedOrUnplanned = planedOrUnplanned;
        this.needSource = needSource;
        this.trainingCategory = trainingCategory;
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.generalComment = generalComment;
        this.trainerType = trainerType;
        this.institutionOrPlace = institutionOrPlace;
        this.durationCategory = durationCategory;
        this.tentativeStartDate = tentativeStartDate;
        this.tentativeEndDate = tentativeEndDate;
        this.priorityCategory = priorityCategory;
        this.numberOfEmployees = numberOfEmployee;
    }


    public TrainingNeedAssessementModel(int trainingNeedRequestId, String requesterId, String appliedDate, String budjetYear, String planedOrUnplanned, String needSource, String trainingCategory, String trainingId, String trainingName, String generalComment, String trainerType, String institutionOrPlace, String durationCategory, String tentativeStartDate, String tentativeEndDate, String priorityCategory, int numberOfEmployee) {
        this(requesterId, appliedDate, budjetYear, planedOrUnplanned, needSource, trainingCategory, trainingId, trainingName, generalComment, trainerType, institutionOrPlace, durationCategory, tentativeStartDate, tentativeEndDate, priorityCategory, numberOfEmployee);
        this.trainingNeedRequestId = trainingNeedRequestId;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }


    public String getGeneralComment() {
        return generalComment;
    }

    public void setGeneralComment(String generalComment) {
        this.generalComment = generalComment;
    }

    public String getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(String budjetYear) {
        this.budjetYear = budjetYear;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getRequestPurpose() {
        return requestPurpose;
    }

    public void setRequestPurpose(String requestPurpose) {
        this.requestPurpose = requestPurpose;
    }

    public String getPriorityCategory() {
        return priorityCategory;
    }

    public String getPlanedOrUnplanned() {
        return planedOrUnplanned;
    }

    public void setPlanedOrUnplanned(String planedOrUnplanned) {
        this.planedOrUnplanned = planedOrUnplanned;
    }

    public void setPriorityCategory(String priorityCategory) {
        this.priorityCategory = priorityCategory;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getAssignedInstitutionOrEmployees() {
        return assignedInstitutionOrEmployees;
    }

    public void setAssignedInstitutionOrEmployees(String assignedInstitutionOrEmployees) {
        this.assignedInstitutionOrEmployees = assignedInstitutionOrEmployees;
    }

    public double getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(double costPerPerson) {
        this.costPerPerson = costPerPerson;
    }

    public String getDurationCategory() {
        return durationCategory;
    }

    public void setDurationCategory(String durationCategory) {
        this.durationCategory = durationCategory;
    }

    public String getInstitutionOrPlace() {
        return institutionOrPlace;
    }

    public void setInstitutionOrPlace(String institutionOrPlace) {
        this.institutionOrPlace = institutionOrPlace;
    }

    public String getNeedSource() {
        return needSource;
    }

    public void setNeedSource(String needSource) {
        this.needSource = needSource;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getRecordedDateAndTime() {
        return recordedDateAndTime;
    }

    public void setRecordedDateAndTime(String recordedDateAndTime) {
        this.recordedDateAndTime = recordedDateAndTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getOtherEstimatedCosts() {
        return otherEstimatedCosts;
    }

    public void setOtherEstimatedCosts(double otherEstimatedCosts) {
        this.otherEstimatedCosts = otherEstimatedCosts;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getTentativeEndDate() {
        return tentativeEndDate;
    }

    public void setTentativeEndDate(String tentativeEndDate) {
        this.tentativeEndDate = tentativeEndDate;
    }

    public String getTentativeStartDate() {
        return tentativeStartDate;
    }

    public void setTentativeStartDate(String tentativeStartDate) {
        this.tentativeStartDate = tentativeStartDate;
    }

    public String getTrainerType() {
        return trainerType;
    }

    public void setTrainerType(String trainerType) {
        this.trainerType = trainerType;
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

    public int getTrainingNeedAttributesId() {
        return trainingNeedAttributesId;
    }

    public void setTrainingNeedAttributesId(int trainingNeedAttributesId) {
        this.trainingNeedAttributesId = trainingNeedAttributesId;
    }

    public int getTrainingNeedRequestId() {
        return trainingNeedRequestId;
    }

    public void setTrainingNeedRequestId(int trainingNeedRequestId) {
        this.trainingNeedRequestId = trainingNeedRequestId;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerProfession() {
        return trainerProfession;
    }

    public void setTrainerProfession(String trainerProfession) {
        this.trainerProfession = trainerProfession;
    }
    
    
}
