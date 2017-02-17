/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

/**
 *
 * @author mekete
 */
public class EducationPaymentModel {

    int educationPaymentId;
    int educationRequestId;
    int numberOfCourses;
    int numberOfCreditHours;
    double costPerCreditHour;
    double adminstrativeCost;
    double totalCost;
    String paymentPreOrPost;
    String academicYear;
    String courseName;
    String semesterOrTerm;
    String appliedDate;
    String issueDate;
    String remark;
    String documentReferenceNumber;
    String receiptNumber;
    String requestStatus;
    String timeStamp;
    String userName;
    double tutationFee;
    double unitCost;
    double quantity;
    String requesterId;
    String databaseStatus;
    int id;
    String resultBasic;
    double score;
    String adminstraticeCostType;
    String courseCode;
    String creditHr;
    float cumlativeGPA;
    boolean selectForApprove;
    int adminstratId;
    boolean selected;
    String InstName;
    String institutionName;
    String gradept;
    int courseId;
    private int decisiopId;//@Column(name = "_PROCESSED_ID")
    private int requestId; //@Column(name = "OVER_TIME_REQUEST_ID")
    private String processedBy;//@Column(name = "PROCEESED_BY")
    private String decision;//@Column(name = "DECISION_BY")
    private String nextState;//   @Column(name = "NEXT_STATE")
    private String commentGiven;// @Column(name = "COMMENT_GIVEN")
    private String recordedBy;//  @Column(name = "RECORDED_BY")//  String userName;
    private String recorededDateAndTime;//  @Column(name = "TIME_STAMP")
    String gradeBasic;
    String result;

    public EducationPaymentModel() {
    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, int educationRequestId, String academicYear) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        //this.InstName=institutionName;
        this.educationRequestId = educationRequestId;
        this.academicYear = academicYear;
    }

    public EducationPaymentModel(int COursyabID,String instName, String requesterId, String courseCode, String creditHr, String semesterOrTerm, int educationRequestId, String academicYear) {
        this.courseId = COursyabID;
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.institutionName=instName;
        this.educationRequestId = educationRequestId;
        this.academicYear = academicYear;
    }

    public EducationPaymentModel(String requesterId, double unitCost, double totalCost, String adminstrativeCostType, int educationRequestId, int adminstratId, boolean selected) {
        this.requesterId = requesterId;
        this.educationRequestId = educationRequestId;
        this.unitCost = unitCost;
        this.totalCost = totalCost;
        this.adminstraticeCostType = adminstrativeCostType;
        this.adminstratId = adminstratId;
        this.selected = selected;
    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, int educReqId, String acadmicYear, String institutionName) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.InstName = institutionName;
        this.educationRequestId = educReqId;
        this.academicYear = acadmicYear;
    }

    public EducationPaymentModel(String requesterId, double unitCost, double totalCost, String adminstraticeCostType, int educReqId) {
        this.requesterId = requesterId;
        this.educationRequestId = educReqId;
        this.unitCost = unitCost;
//        this.quantity = quantity;
        this.totalCost = totalCost;
        this.adminstraticeCostType = adminstraticeCostType;

    }

    public EducationPaymentModel(String requesterId, double unitCost, double quantity, double totalCost, String adminstraticeCostType, int educReqId, int id) {
        this.requesterId = requesterId;
        this.educationRequestId = educReqId;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.adminstraticeCostType = adminstraticeCostType;
        this.id = id;
    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, int educationRequestId, String academicYear, int courseID) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.educationRequestId = educationRequestId;
        // this.gradept = gradept;
        this.academicYear = academicYear;
        this.courseId = courseID;

    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, int educationRequestId, String gradept, String academicYear, int courseID) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.educationRequestId = educationRequestId;
        this.gradept = gradept;
        this.academicYear = academicYear;
        this.courseId = courseID;

    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, float cGPA, int educationRequestId, String gradePt, String acadamicYear, int coursId, String databaseStatus) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.cumlativeGPA = cGPA;
        this.educationRequestId = educationRequestId;
        this.gradept = gradePt;
        this.academicYear = acadamicYear;
        this.databaseStatus = databaseStatus;
        this.courseId = coursId;

    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, float cGPA, int educationRequestId, String gradePt, String acadamicYear, int coursId) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.cumlativeGPA = cGPA;
        this.educationRequestId = educationRequestId;
        this.gradept = gradePt;
        this.academicYear = acadamicYear;
    ///this.databaseStatus=databaseStatus;

    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, float cGPA, int educationRequestId, String gradePt, String acadamicYear, int coursId, String databaseStatus, String instName, String appliedDate) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.cumlativeGPA = cGPA;
        this.educationRequestId = educationRequestId;
        this.gradept = gradePt;
        this.academicYear = acadamicYear;
        this.databaseStatus = databaseStatus;
        this.InstName = instName;
        this.appliedDate = appliedDate;

    }

    public EducationPaymentModel(String requesterId, String courseCode, String creditHr, String semesterOrTerm, float cGPA, int educationRequestId, String gradePt, String acadamicYear, int coursId, String databaseStatus, String instName) {
        this.requesterId = requesterId;
        this.courseCode = courseCode;
        this.creditHr = creditHr;
        this.semesterOrTerm = semesterOrTerm;
        this.cumlativeGPA = cGPA;
        this.educationRequestId = educationRequestId;
        this.gradept = gradePt;
        this.academicYear = acadamicYear;
        this.databaseStatus = databaseStatus;
        this.InstName = instName;


    }

    public EducationPaymentModel(int educationRequestId, int numberOfCourses, int numberOfCreditHours, double costPerCreditHour, double adminstrativeCost, double totalCost, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String issueDate, String remark, String documentReferenceNumber, String receiptNumber, String requestStatus, String timeStamp, String userName) {
        this.educationRequestId = educationRequestId;
        this.numberOfCourses = numberOfCourses;
        this.numberOfCreditHours = numberOfCreditHours;
        this.costPerCreditHour = costPerCreditHour;
        this.adminstrativeCost = adminstrativeCost;
        this.totalCost = totalCost;
        this.paymentPreOrPost = paymentPreOrPost;
        this.academicYear = academicYear;
        this.semesterOrTerm = semesterOrTerm;
        this.appliedDate = appliedDate;
        this.issueDate = issueDate;
        this.remark = remark;
        this.documentReferenceNumber = documentReferenceNumber;
        this.receiptNumber = receiptNumber;
        this.requestStatus = requestStatus;
        this.timeStamp = timeStamp;
        this.userName = userName;
    }

    public EducationPaymentModel(int educationPaymentId, int educationRequestId, int numberOfCourses, int numberOfCreditHours, double costPerCreditHour, double adminstrativeCost, double totalCost, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String issueDate, String remark, String documentReferenceNumber, String receiptNumber, String requestStatus, String timeStamp, String userName) {
        this(educationRequestId, numberOfCourses, numberOfCreditHours, costPerCreditHour, adminstrativeCost, totalCost, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, requestStatus, timeStamp, userName);
        this.educationPaymentId = educationPaymentId;
    }

    EducationPaymentModel(int adminstratIdID, boolean selected) {
        this.adminstratId = adminstratIdID;
        this.selected = selected;
    }

    EducationPaymentModel(String requesterId, int eduReqId, String grade, String appliedDate) {
        this.requesterId = requesterId;
        this.educationRequestId = eduReqId;
        this.gradeBasic = grade;

        this.appliedDate = appliedDate;
    }

    EducationPaymentModel(String requesterId, int eduReqId, String grade, String resultBasic, double score, String appliedDate) {
        this.requesterId = requesterId;
        this.educationRequestId = eduReqId;
        this.gradeBasic = grade;
        this.resultBasic = resultBasic;
        this.score = score;
        this.appliedDate = appliedDate;
    }

    EducationPaymentModel(int requestId, String processedBy, String decision, String nextState, String commnetGiven, String userName, String recorededDateAndTime) {
        this.educationPaymentId = requestId;
        this.processedBy = processedBy;
        this.decision = decision;
        this.nextState = nextState;
        this.commentGiven = commnetGiven;
        this.recordedBy = userName;
        this.recorededDateAndTime = recorededDateAndTime;
    }

    EducationPaymentModel(int educationPaymentRequestId, int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String sueDate, String remark, String documentReferenceNumber, String receiptNumber, double totalCost, String requestStatus, String timeStamp, String userName) {
        this.educationRequestId = educationRequestId;
        this.paymentPreOrPost = paymentPreOrPost;
        this.academicYear = academicYear;
        this.semesterOrTerm = semesterOrTerm;
        this.appliedDate = appliedDate;
        this.issueDate = sueDate;
        this.remark = remark;
        this.documentReferenceNumber = documentReferenceNumber;
        this.receiptNumber = receiptNumber;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.totalCost = totalCost;
        this.requestStatus = requestStatus;
        this.educationPaymentId = educationPaymentRequestId;
    }

//    EducationPaymentModel(String requesterID, int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String sueDate, String remark, String documentReferenceNumber, String receiptNumber, String requestStatus, String timeStamp, String userName, double totalCost) {
//        this.educationRequestId = educationRequestId;
//        this.paymentPreOrPost = paymentPreOrPost;
//        this.academicYear = academicYear;
//        this.semesterOrTerm = semesterOrTerm;
//        this.appliedDate = appliedDate;
//        this.issueDate = sueDate;
//        this.remark = remark;
//        this.documentReferenceNumber = documentReferenceNumber;
//        this.receiptNumber = receiptNumber;
//        this.timeStamp = timeStamp;
//        this.userName = userName;
//        this.totalCost = totalCost;
//        this.requestStatus = requestStatus;
//        requesterId = requesterID;
//    }
    EducationPaymentModel(String requesterID, int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String sueDate, String remark, String documentReferenceNumber, String receiptNumber, String requestStatus, String timeStamp, String userName, double totalCost) {
        this.educationRequestId = educationRequestId;
        this.paymentPreOrPost = paymentPreOrPost;
        this.academicYear = academicYear;
        this.semesterOrTerm = semesterOrTerm;
        this.appliedDate = appliedDate;
        this.issueDate = sueDate;
        this.remark = remark;
        this.documentReferenceNumber = documentReferenceNumber;
        this.receiptNumber = receiptNumber;
        //this.cumlativeGPA=cGPA;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.totalCost = totalCost;
        this.requestStatus = requestStatus;
        requesterId = requesterID;
    }

    EducationPaymentModel(int educationPaymentRequestId, int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String sueDate, String remark, String documentReferenceNumber, String receiptNumber, double totalCost, float cGPA, String requstSatus, String timeStamp, String userName) {
        this.educationRequestId = educationRequestId;
        this.educationPaymentId = educationPaymentRequestId;
        this.paymentPreOrPost = paymentPreOrPost;
        this.academicYear = academicYear;
        this.semesterOrTerm = semesterOrTerm;
        this.appliedDate = appliedDate;
        this.issueDate = sueDate;
        this.remark = remark;
        this.documentReferenceNumber = documentReferenceNumber;
        this.receiptNumber = receiptNumber;
        this.requestStatus = requstSatus;
        this.totalCost = totalCost;
        this.cumlativeGPA = cGPA;
        this.timeStamp = timeStamp;
        this.userName = userName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public double getAdminstrativeCost() {
        return adminstrativeCost;
    }

    public void setAdminstrativeCost(double adminstrativeCost) {
        this.adminstrativeCost = adminstrativeCost;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public float getCumlativeGPA() {
        return cumlativeGPA;
    }

    public void setCumlativeGPA(float cumlativeGPA) {
        this.cumlativeGPA = cumlativeGPA;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getGradeBasic() {
        return gradeBasic;
    }

    public void setGradeBasic(String gradeBasic) {
        this.gradeBasic = gradeBasic;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCreditHr() {
        return creditHr;
    }

    public void setCreditHr(String creditHr) {
        this.creditHr = creditHr;
    }

    public int getAdminstratId() {
        return adminstratId;
    }

    public void setAdminstratId(int adminstratId) {
        this.adminstratId = adminstratId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public double getTutationFee() {
        return tutationFee;
    }

    public void setTutationFee(double tutationFee) {
        this.tutationFee = tutationFee;
    }

    public boolean isSelectForApprove() {
        return selectForApprove;
    }

    public void setSelectForApprove(boolean selectForApprove) {
        this.selectForApprove = selectForApprove;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getAdminstraticeCostType() {
        return adminstraticeCostType;
    }

    public void setAdminstraticeCostType(String adminstraticeCostType) {
        this.adminstraticeCostType = adminstraticeCostType;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public double getCostPerCreditHour() {
        return costPerCreditHour;
    }

    public void setCostPerCreditHour(double costPerCreditHour) {
        this.costPerCreditHour = costPerCreditHour;
    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public int getEducationPaymentId() {
        return educationPaymentId;
    }

    public void setEducationPaymentId(int educationPaymentId) {
        this.educationPaymentId = educationPaymentId;
    }

    public int getEducationRequestId() {
        return educationRequestId;
    }

    public void setEducationRequestId(int educationRequestId) {
        this.educationRequestId = educationRequestId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public String getInstName() {
        return InstName;
    }

    public void setInstName(String InstName) {
        this.InstName = InstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public int getNumberOfCreditHours() {
        return numberOfCreditHours;
    }

    public void setNumberOfCreditHours(int numberOfCreditHours) {
        this.numberOfCreditHours = numberOfCreditHours;
    }

    public String getPaymentPreOrPost() {
        return paymentPreOrPost;
    }

    public void setPaymentPreOrPost(String paymentPreOrPost) {
        this.paymentPreOrPost = paymentPreOrPost;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getSemesterOrTerm() {
        return semesterOrTerm;
    }

    public void setSemesterOrTerm(String semesterOrTerm) {
        this.semesterOrTerm = semesterOrTerm;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getUserName() {
        return userName;
    }

    public String getGradept() {
        return gradept;
    }

    public void setGradept(String gradept) {
        this.gradept = gradept;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentGiven() {
        return commentGiven;
    }

    public void setCommentGiven(String commentGiven) {
        this.commentGiven = commentGiven;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public int getDecisiopId() {
        return decisiopId;
    }

    public void setDecisiopId(int decisiopId) {
        this.decisiopId = decisiopId;
    }

    public String getNextState() {
        return nextState;
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

    public String getResultBasic() {
        return resultBasic;
    }

    public void setResultBasic(String resultBasic) {
        this.resultBasic = resultBasic;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
