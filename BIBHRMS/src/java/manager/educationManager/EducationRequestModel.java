/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

/**
 *
 * @author mekete
 */
public class EducationRequestModel {

    int educationRequestId;
    int changeInstId;
    String requesterId;
    String requesterName;//
    String educationProgramName;
    String institutionName;
    int instId;
    String ethiopianInstitution;//inside or outside ethiopia
    String institutionAccredited;//
    String institutionAddress;
    String startDate;
    String appliedDate;
    String educationShiftCategory;//
    String educationTypeCategory;//
    String educationLevelCategory;//
    double costPerCreditHour;
    int numberOfCreditHours;
    double totalAdminstrationCosts;
    double durationInYear;
    String reasonDescription;
    String documentReferenceNumber;
    String requestStatus;
    String timeStamp;
    String userName;
    String educatinalStatus;
    String dateOfStatusUpdate;
    String endDate;
    int requestId;//REQUEST_ID
    String processedBy;//PROCESSED_BY
    String commnetGiven;//COMMENT_GIVEN
    String decision;//DECISION
    String recordedBy;//RECORDED_BY
    String status;//
    String nextState;
    String forwardedToCommittee;
    String recorededDateAndTime;
    String levelID;
    String reasonOfChang;
    String decisionS;
    String nextStates;
    String allOrSecifyProgram;
    String changeInstStatus;
    byte minute[];
    private String fileType;
    private int fileId;
    private String fileName;
    private String remark;
    private byte[] file;
    private String employeeId;
    private boolean selected;
    private String fileExtension;
    private int processID;

    public EducationRequestModel() {
    }

    public EducationRequestModel(int educationRequestId,String fileExtenstion, byte[] employeeFile) {
        this.minute=employeeFile;
       this.fileExtension=fileExtenstion;
       this.educationRequestId=educationRequestId;
    }

    public EducationRequestModel(int prosessId , int requestId, byte []employeeFile,  String fileExtention,String fileName) {
       this.processID=prosessId;
       this.educationRequestId=requestId;
       this.minute=employeeFile;
       this.fileExtension=fileExtention;
       this.fileName=fileName;
    }

    public EducationRequestModel(String requesterId, String educationProgramName, String institutionName, String ethiopianInstitution, String institutionAccredited, String institutionAddress, String startDate, String appliedDate, String educationShiftCategory, String educationLevelCategory, double costPerCreditHour, int numberOfCreditHours, double totalAdminstrationCosts, double durationInYear, String reasonDescription, String documentReferenceNumber, String requestStatus, String timeStamp, String userName, String educationStatus, String dateofEducn, String endDate, String levelID, String allOrSecifyProgram) {
        this.requesterId = requesterId;
        this.educationProgramName = educationProgramName;
        this.institutionName = institutionName;
        this.ethiopianInstitution = ethiopianInstitution;
        this.institutionAccredited = institutionAccredited;
        this.institutionAddress = institutionAddress;
        this.startDate = startDate;
        this.appliedDate = appliedDate;
        this.educationShiftCategory = educationShiftCategory;
        // this.educationTypeCategory = educationTypeCategory;
        this.educationLevelCategory = educationLevelCategory;
        this.costPerCreditHour = costPerCreditHour;
        this.numberOfCreditHours = numberOfCreditHours;
        this.totalAdminstrationCosts = totalAdminstrationCosts;
        this.durationInYear = durationInYear;
        this.reasonDescription = reasonDescription;
        this.documentReferenceNumber = documentReferenceNumber;
        this.requestStatus = requestStatus;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.educatinalStatus = educationStatus;
        this.dateOfStatusUpdate = dateofEducn;
        this.endDate = endDate;
        this.levelID = levelID;
        this.allOrSecifyProgram = allOrSecifyProgram;
    }

    public EducationRequestModel(int educationRequestId, String requesterId, String educationProgramName, String institutionName, String ethiopianInstitution, String institutionAccredited, String institutionAddress, String startDate, String appliedDate, String educationShiftCategory, String educationLevelCategory, double costPerCreditHour, int numberOfCreditHours, double totalAdminstrationCosts, double durationInYear, String reasonDescription, String documentReferenceNumber, String requestStatus, String timeStamp, String userName, String endDate, String levelID, String allOrSecifyProgram) {
        this.educationRequestId = educationRequestId;
        this.requesterId = requesterId;
        this.educationProgramName = educationProgramName;
        this.institutionName = institutionName;
        this.ethiopianInstitution = ethiopianInstitution;
        this.institutionAccredited = institutionAccredited;
        this.institutionAddress = institutionAddress;
        this.startDate = startDate;
        this.appliedDate = appliedDate;
        this.educationShiftCategory = educationShiftCategory;
        // this.educationTypeCategory = educationTypeCategory;
        this.educationLevelCategory = educationLevelCategory;
        this.costPerCreditHour = costPerCreditHour;
        this.numberOfCreditHours = numberOfCreditHours;
        this.totalAdminstrationCosts = totalAdminstrationCosts;
        this.durationInYear = durationInYear;
        this.reasonDescription = reasonDescription;
        this.documentReferenceNumber = documentReferenceNumber;
        this.requestStatus = requestStatus;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.endDate = endDate;
        this.levelID = levelID;
        this.allOrSecifyProgram = allOrSecifyProgram;

    }

    EducationRequestModel(int educRequestID, String requesterId) {
        this.educationRequestId = educRequestID;
        this.requesterId = requesterId;
    }

//    EducationRequestModel(int educationRequestId, String fileExtension, byte [] minute) {
//        this.educationRequestId=educationRequestId;
//        this.fileExtension=fileExtension;
//        this.minute=minute;
//    }

    EducationRequestModel(String reasonOfChang, int educationRequestId, String requesterId, String educatinalStatus, String dateOfStatusUpdate, String requestStatus, String timeStamp, String userName) {
        this.educationRequestId = educationRequestId;
        this.requesterId = requesterId;
        this.educatinalStatus = educatinalStatus;
        this.dateOfStatusUpdate = dateOfStatusUpdate;
        this.requestStatus = requestStatus;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.reasonOfChang = reasonOfChang;
    }

    public EducationRequestModel(int requestId, String processedBy, String decision, String nextState, String commnetGiven, String userName, String recorededDateAndTime, String forwardedToCommittee, byte minute[],String fileExtenstion) {

        this.requestId = requestId;
        this.processedBy = processedBy;
        this.decision = decision;
        this.status = nextState;
        this.commnetGiven = commnetGiven;
        this.recordedBy = userName;
        this.recorededDateAndTime = recorededDateAndTime;
        this.forwardedToCommittee = forwardedToCommittee;
        this.minute = minute;
        this.fileExtension=fileExtenstion;
   


    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public double getDurationInYear() {
        return durationInYear;
    }

    public String getNextStates() {
        return nextStates;
    }

    public void setNextStates(String nextStates) {
        this.nextStates = nextStates;
    }

    public String getCommnetGiven() {
        return commnetGiven;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getDecisionS() {
        return decisionS;
    }

    public int getInstId() {
        return instId;
    }

    public byte[] getMinute() {
        return minute;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public void setMinute(byte[] minute) {
        this.minute = minute;
    }

    public String getChangeInstStatus() {
        return changeInstStatus;
    }

    public void setChangeInstStatus(String changeInstStatus) {
        this.changeInstStatus = changeInstStatus;
    }

    public void setInstId(int instId) {
        this.instId = instId;
    }

    public void setDecisionS(String decisionS) {
        this.decisionS = decisionS;
    }

    public String getAllOrSecifyProgram() {
        return allOrSecifyProgram;
    }

    public void setAllOrSecifyProgram(String allOrSecifyProgram) {
        this.allOrSecifyProgram = allOrSecifyProgram;
    }

    public void setCommnetGiven(String commnetGiven) {
        this.commnetGiven = commnetGiven;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getReasonOfChang() {
        return reasonOfChang;
    }

    public void setReasonOfChang(String reasonOfChang) {
        this.reasonOfChang = reasonOfChang;
    }

    public String getForwardedToCommittee() {
        return forwardedToCommittee;
    }

    public void setForwardedToCommittee(String forwardedToCommittee) {
        this.forwardedToCommittee = forwardedToCommittee;
    }

    public String getNextState() {
        return nextState;
    }

    public String getLevelID() {
        return levelID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getRecorededDateAndTime() {
        return recorededDateAndTime;
    }

    public void setRecorededDateAndTime(String recorededDateAndTime) {
        this.recorededDateAndTime = recorededDateAndTime;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDurationInYear(double durationInYear) {
        this.durationInYear = durationInYear;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public String getDateOfStatusUpdate() {
        return dateOfStatusUpdate;
    }

    public void setDateOfStatusUpdate(String dateOfStatusUpdate) {
        this.dateOfStatusUpdate = dateOfStatusUpdate;
    }

    public String getEducatinalStatus() {
        return educatinalStatus;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setEducatinalStatus(String educatinalStatus) {
        this.educatinalStatus = educatinalStatus;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getChangeInstId() {
        return changeInstId;
    }

    public void setChangeInstId(int changeInstId) {
        this.changeInstId = changeInstId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getEducationRequestId() {
        return educationRequestId;
    }

    public void setEducationRequestId(int educationRequestId) {
        this.educationRequestId = educationRequestId;
    }

    public String getEducationLevelCategory() {
        return educationLevelCategory;
    }

    public void setEducationLevelCategory(String educationLevelCategory) {
        this.educationLevelCategory = educationLevelCategory;
    }

    public String getEducationProgramName() {
        return educationProgramName;
    }

    public void setEducationProgramName(String educationProgramName) {
        this.educationProgramName = educationProgramName;
    }

    public String getEducationShiftCategory() {
        return educationShiftCategory;
    }

    public void setEducationShiftCategory(String educationShiftCategory) {
        this.educationShiftCategory = educationShiftCategory;
    }

    public String getEducationTypeCategory() {
        return educationTypeCategory;
    }

    public void setEducationTypeCategory(String educationTypeCategory) {
        this.educationTypeCategory = educationTypeCategory;
    }

    public double getCostPerCreditHour() {
        return costPerCreditHour;
    }

    public void setCostPerCreditHour(double costPerCreditHour) {
        this.costPerCreditHour = costPerCreditHour;
    }

    public int getNumberOfCreditHours() {
        return numberOfCreditHours;
    }

    public void setNumberOfCreditHours(int numberOfCreditHours) {
        this.numberOfCreditHours = numberOfCreditHours;
    }

    public double getTotalAdminstrationCosts() {
        return totalAdminstrationCosts;
    }

    public void setTotalAdminstrationCosts(double totalAdminstrationCosts) {
        this.totalAdminstrationCosts = totalAdminstrationCosts;
    }

    public String getInstitutionAccredited() {
        return institutionAccredited;
    }

    public void setInstitutionAccredited(String institutionAccredited) {
        this.institutionAccredited = institutionAccredited;
    }

    public String getEthiopianInstitution() {
        return ethiopianInstitution;
    }

    public void setEthiopianInstitution(String ethiopianInstitution) {
        this.ethiopianInstitution = ethiopianInstitution;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

   
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
   
}
