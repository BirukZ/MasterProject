/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

/**
 *
 * @author Admin
 */
public class ReportModel {

    private int educationPaymentId;
    private int educationRequestId;
    private int numberOfCourses;
    private int numberOfCreditHours;
    private double costPerCreditHour;
    private double adminstrativeCost;
    private double totalCost;
    private String paymentPreOrPost;
    private String academicYear;
    private String semesterOrTerm;
    private String appliedDate;
    private String issueDate;
    private String remark;
    private String documentReferenceNumber;
    private String receiptNumber;
    private String requestStatus;
    private String timeStamp;
    private String userName;
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
    String gradept;
    int courseId;
    String hireDate;
    String result;
   private String requesterName;
    int age;
    String sex;
    String jobPostion;
    String dpartement;
    String team;
    String location;
    String currentEducation;
    String requestedEducation;
    String requestedEuctionrank;
    String institutionName;
    String ethiopianInstitution;//inside or outside ethiopia
    String institutionAccredited;//
    String institutionAddress;
    String educationShiftCategory;//
    String currentEducationrank;
    String endDate;
    String reasonOfRejection;
    double totalCostAll;
    public ReportModel() {
    }

    public ReportModel(String requesterId, String requesterName, int age, String sex, String hireDate, String jobPostion, String dpartement, String team, String location, String currentEducation, String currentEducationrank, String result, String requestedEducation, String requestedEuctionrank, String institutionName, String institutionAccredited, String reasonOfRejection) {
         this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.age = age;
        this.sex = sex;
        this.hireDate = hireDate;
        this.jobPostion = jobPostion;
        this.dpartement = dpartement;
        this.team = team;
        this.location = location;
        this.currentEducation = currentEducation;
        this.currentEducationrank = currentEducationrank;
        this.result = result;
        this.requestedEducation = requestedEducation;
        this.requestedEuctionrank = requestedEuctionrank;
        this.institutionName = institutionName;
               this.institutionAccredited = institutionAccredited;
        this.reasonOfRejection = reasonOfRejection;
    }

    public ReportModel(String requesterId, String requesterName, int age, String sex, String hireDate, String jobPostion, String dpartement, String team, String location, String currentEducation, String currentEducationrank, String result, String requestedEducation, String requestedEuctionrank, String institutionName, String appliedDate, String institutionAccredited, String educationShiftCategory) {
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.age = age;
        this.sex = sex;
        this.hireDate = hireDate;
        this.jobPostion = jobPostion;
        this.dpartement = dpartement;
        this.team = team;
        this.location = location;
        this.currentEducation = currentEducation;
        this.currentEducationrank = currentEducationrank;
        this.result = result;
        this.requestedEducation = requestedEducation;
        this.requestedEuctionrank = requestedEuctionrank;
        this.institutionName = institutionName;
        this.appliedDate = appliedDate;
        this.institutionAccredited = institutionAccredited;
        this.educationShiftCategory = educationShiftCategory;
    }

    public ReportModel(String requesterId, String requesterName, int age, String sex, String hireDate, String jobPostion, String dpartement, String team, String location, String currentEducation, String currentEducationrank, String result, String requestedEducation, String requestedEuctionrank, String institutionName, String appliedDate, String institutionAccredited, String educationShiftCategory, String acadamicYear, String startDate, String endDate, double totalCost,String docRefeNum) {
          this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.age = age;
        this.sex = sex;
        this.hireDate = hireDate;
        this.jobPostion = jobPostion;
        this.dpartement = dpartement;
        this.team = team;
        this.location = location;
        this.currentEducation = currentEducation;
        this.currentEducationrank = currentEducationrank;
        this.result = result;
        this.requestedEducation = requestedEducation;
        this.requestedEuctionrank = requestedEuctionrank;
        this.institutionName = institutionName;
        this.appliedDate = appliedDate;
        this.institutionAccredited = institutionAccredited;
        this.educationShiftCategory = educationShiftCategory;
        this.totalCost=totalCost;
        this.issueDate=startDate;
        this.academicYear=acadamicYear;
        this.endDate=endDate;
        this.documentReferenceNumber=docRefeNum;
        //this.totalCostAll=totalCostAll;

    }

    public String getReasonOfRejection() {
        return reasonOfRejection;
    }

    public void setReasonOfRejection(String reasonOfRejection) {
        this.reasonOfRejection = reasonOfRejection;
    }

    public String getInstName() {
        return InstName;
    }

    public String getCurrentEducationrank() {
        return currentEducationrank;
    }

    public void setCurrentEducationrank(String currentEducationrank) {
        this.currentEducationrank = currentEducationrank;
    }

    public int getAge() {
        return age;
    }

    public double getTotalCostAll() {
        return totalCostAll;
    }

    public void setTotalCostAll(double totalCostAll) {
        this.totalCostAll = totalCostAll;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrentEducation() {
        return currentEducation;
    }

    public void setCurrentEducation(String currentEducation) {
        this.currentEducation = currentEducation;
    }

    public String getDpartement() {
        return dpartement;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDpartement(String dpartement) {
        this.dpartement = dpartement;
    }

    public String getEducationShiftCategory() {
        return educationShiftCategory;
    }

    public void setEducationShiftCategory(String educationShiftCategory) {
        this.educationShiftCategory = educationShiftCategory;
    }

    public String getEthiopianInstitution() {
        return ethiopianInstitution;
    }

    public void setEthiopianInstitution(String ethiopianInstitution) {
        this.ethiopianInstitution = ethiopianInstitution;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getInstitutionAccredited() {
        return institutionAccredited;
    }

    public void setInstitutionAccredited(String institutionAccredited) {
        this.institutionAccredited = institutionAccredited;
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

    public String getJobPostion() {
        return jobPostion;
    }

    public void setJobPostion(String jobPostion) {
        this.jobPostion = jobPostion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRequestedEducation() {
        return requestedEducation;
    }

    public void setRequestedEducation(String requestedEducation) {
        this.requestedEducation = requestedEducation;
    }

    public String getRequestedEuctionrank() {
        return requestedEuctionrank;
    }

    public void setRequestedEuctionrank(String requestedEuctionrank) {
        this.requestedEuctionrank = requestedEuctionrank;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setInstName(String InstName) {
        this.InstName = InstName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public int getAdminstratId() {
        return adminstratId;
    }

    public void setAdminstratId(int adminstratId) {
        this.adminstratId = adminstratId;
    }

    public String getAdminstraticeCostType() {
        return adminstraticeCostType;
    }

    public void setAdminstraticeCostType(String adminstraticeCostType) {
        this.adminstraticeCostType = adminstraticeCostType;
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

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public double getCostPerCreditHour() {
        return costPerCreditHour;
    }

    public void setCostPerCreditHour(double costPerCreditHour) {
        this.costPerCreditHour = costPerCreditHour;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCreditHr() {
        return creditHr;
    }

    public void setCreditHr(String creditHr) {
        this.creditHr = creditHr;
    }

    public float getCumlativeGPA() {
        return cumlativeGPA;
    }

    public void setCumlativeGPA(float cumlativeGPA) {
        this.cumlativeGPA = cumlativeGPA;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
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

    public String getGradept() {
        return gradept;
    }

    public void setGradept(String gradept) {
        this.gradept = gradept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public boolean isSelectForApprove() {
        return selectForApprove;
    }

    public void setSelectForApprove(boolean selectForApprove) {
        this.selectForApprove = selectForApprove;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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

    public double getTutationFee() {
        return tutationFee;
    }

    public void setTutationFee(double tutationFee) {
        this.tutationFee = tutationFee;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
