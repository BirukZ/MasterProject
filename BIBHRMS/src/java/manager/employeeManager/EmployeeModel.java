/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

/**
 *
 * @author mekete
 */
public class EmployeeModel {

    String employeeId;
    String title;
    String gender;
    String firstName;
    String middleName;
    String lastName;
    String birthDate;
    String departmentId;
    String jobTitleId;
    String recruitmentDate;
    String pensionNumber;
    String tinNumber;
    String permanentOrContract;
    String shiftOrNormal;
    String martialStatus;
    String salary;
    String rank;
    String payGrade;
    String nationality;
    String nation;
    String religion;
    String employmentStatus;
    String userName;
    String timeStamp;
    String status;
    String databaseStatus;
    ////////////
    String fullName;
    String referencingTableId;
    String departmentName;
    String jobTitleName;

    public EmployeeModel() {
    }

    public EmployeeModel(String employeeId, String fullName, String departmentName, String jobTitleName, String status) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.departmentName = departmentName;
        this.jobTitleName = jobTitleName;
        this.status = status;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
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

    public String getReferencingTableId() {
        return referencingTableId;
    }

    public void setReferencingTableId(String referencingTableId) {
        this.referencingTableId = referencingTableId;
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

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJobTitleId() {
        return jobTitleId;
    }

    public void setJobTitleId(String jobTitleId) {
        this.jobTitleId = jobTitleId;
    }

    public String getJobTitleName() {
        return jobTitleName;
    }

    public void setJobTitleName(String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPayGrade() {
        return payGrade;
    }

    public void setPayGrade(String payGrade) {
        this.payGrade = payGrade;
    }

    public String getPensionNumber() {
        return pensionNumber;
    }

    public void setPensionNumber(String pensionNumber) {
        this.pensionNumber = pensionNumber;
    }

    public String getPermanentOrContract() {
        return permanentOrContract;
    }

    public void setPermanentOrContract(String permanentOrContract) {
        this.permanentOrContract = permanentOrContract;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(String recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getShiftOrNormal() {
        return shiftOrNormal;
    }

    public void setShiftOrNormal(String shiftOrNormal) {
        this.shiftOrNormal = shiftOrNormal;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
