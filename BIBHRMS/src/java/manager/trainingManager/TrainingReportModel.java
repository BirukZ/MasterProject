/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.trainingManager;

/**
 *
 * @author tomgenial
 */
public class TrainingReportModel {


    String employeeId = null;
    String fullName = null;
    String sex = null;
    String trainingName = null;
    int numberOfEmployees = 0;
    String departmentPath = null;
    String jobDescription = null;
    String categoryName = null;
    String description = null;
    String institutionName = null;
    String appliedDate = null;
    String startDate = null;
    String endDate = null;
//    double trainingCostId = 0.0;
    double trainingFee = 0.0;
    double intertainmentFee = 0.0;
    double transportFee = 0.0;
    double feeForTrainer = 0.0;
    double allowanceFee = 0.0;
    double stationaryFee = 0.0;
    double otherFee = 0.0;
    double costPerPerson = 0.0;
    String trainingType = null;

    String noOfDays = null;
    String award = null;
    String trainerName = null;
    String individualCostPlan = null;

    String courseName = null;
    int noOfTrainee = 0;
    int noOfTraineeBefore = 0;
    double totalexpense = 0.0;

    int numberOfTraineeForYear = 0;
    int numberOfTraineeStillNow = 0;
    double planFulfilled = 0.0;
    double totalCostStillNow = 0.0;
    double individualCostPlanned = 0.0;
    double total = 0.0;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDepartmentPath() {
        return departmentPath;
    }

    public void setDepartmentPath(String departmentPath) {
        this.departmentPath = departmentPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public double getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(double costPerPerson) {
        this.costPerPerson = costPerPerson;
    }

    public double getFeeForTrainer() {
        return feeForTrainer;
    }

    public void setFeeForTrainer(double feeForTrainer) {
        this.feeForTrainer = feeForTrainer;
    }

    public double getIntertainmentFee() {
        return intertainmentFee;
    }

    public void setIntertainmentFee(double intertainmentFee) {
        this.intertainmentFee = intertainmentFee;
    }

    public double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(double otherFee) {
        this.otherFee = otherFee;
    }

    public double getStationaryFee() {
        return stationaryFee;
    }

    public void setStationaryFee(double stationaryFee) {
        this.stationaryFee = stationaryFee;
    }

    public double getTrainingFee() {
        return trainingFee;
    }

    public void setTrainingFee(double trainingFee) {
        this.trainingFee = trainingFee;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public double getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(double transportFee) {
        this.transportFee = transportFee;
    }

    public double getAllowanceFee() {
        return allowanceFee;
    }

    public void setAllowanceFee(double allowanceFee) {
        this.allowanceFee = allowanceFee;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getTotalexpense() {
        return totalexpense;
    }

    public void setTotalexpense(double totalexpense) {
        this.totalexpense = totalexpense;
    }

    public int getNoOfTrainee() {
        return noOfTrainee;
    }

    public void setNoOfTrainee(int noOfTrainee) {
        this.noOfTrainee = noOfTrainee;
    }

    public int getNoOfTraineeBefore() {
        return noOfTraineeBefore;
    }

    public void setNoOfTraineeBefore(int noOfTraineeBefore) {
        this.noOfTraineeBefore = noOfTraineeBefore;
    }

    public String getIndividualCostPlan() {
        return individualCostPlan;
    }

    public void setIndividualCostPlan(String individualCostPlan) {
        this.individualCostPlan = individualCostPlan;
    }

    public double getIndividualCostPlanned() {
        return individualCostPlanned;
    }

    public void setIndividualCostPlanned(double individualCostPlanned) {
        this.individualCostPlanned = individualCostPlanned;
    }



    public double getPlanFulfilled() {
        return planFulfilled;
    }

    public void setPlanFulfilled(double planFulfilled) {
        this.planFulfilled = planFulfilled;
    }

    public double getTotalCostStillNow() {
        return totalCostStillNow;
    }

    public void setTotalCostStillNow(double totalCostStillNow) {
        this.totalCostStillNow = totalCostStillNow;
    }

    public int getNumberOfTraineeForYear() {
        return numberOfTraineeForYear;
    }

    public void setNumberOfTraineeForYear(int numberOfTraineeForYear) {
        this.numberOfTraineeForYear = numberOfTraineeForYear;
    }

    public int getNumberOfTraineeStillNow() {
        return numberOfTraineeStillNow;
    }

    public void setNumberOfTraineeStillNow(int numberOfTraineeStillNow) {
        this.numberOfTraineeStillNow = numberOfTraineeStillNow;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

        

    public TrainingReportModel(){
        
    }

    public TrainingReportModel(String employeeId,String fullName, String departmentPath,
            String jobDescription, String categoryName,String trainingName,String appliedDate,String startDate,String endDate,String noOfDays,String award,String institutionName,String trainerName){
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.trainingName = trainingName;
        this.departmentPath = departmentPath;
        this.jobDescription = jobDescription;
        this.categoryName = categoryName;
        this.institutionName = institutionName;
        this.appliedDate = appliedDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfDays = noOfDays;
        this.award = award;
        this.trainerName = trainerName;
    }

    public TrainingReportModel(String employeeId,String fullName,String sex, String departmentPath,
            String jobDescription, String categoryName,String trainingName,int numberOfEmployee, String description, String institutionName, String appliedDate, String startDate,String endDate){
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.sex = sex;
        this.trainingName = trainingName;
        this.numberOfEmployees = numberOfEmployee;
        this.departmentPath = departmentPath;
        this.jobDescription = jobDescription;
        this.categoryName = categoryName;
        this.description = description;
        this.institutionName = institutionName;
        this.appliedDate = appliedDate;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public TrainingReportModel(String employeeId,String fullName, String departmentPath,
            String jobDescription, String categoryName, String trainingName, double trainingFee, double intertainmentFee, double transportFee, double feeForTrainer, double alowanceFee, double stationaryFee, double otherFee, double costPerPerson){
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.categoryName = categoryName;
        this.trainingName = trainingName;
        this.departmentPath = departmentPath;
        this.jobDescription = jobDescription;
        this.trainingFee = trainingFee;
        this.intertainmentFee = intertainmentFee;
        this.transportFee = transportFee;
        this.feeForTrainer = feeForTrainer;
        this.allowanceFee = alowanceFee;
        this.stationaryFee = stationaryFee;
        this.otherFee = otherFee;
        this.costPerPerson = costPerPerson;

    }

    public TrainingReportModel(String employeeId,String fullName, String departmentPath,
            String jobDescription, String categoryName, String trainingName, String individualCostPlan, double trainingFee, double intertainmentFee, double transportFee, double feeForTrainer, double alowanceFee, double stationaryFee, double otherFee, double costPerPerson){
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.categoryName = categoryName;
        this.trainingName = trainingName;
        this.departmentPath = departmentPath;
        this.jobDescription = jobDescription;
        this.trainingFee = trainingFee;
        this.intertainmentFee = intertainmentFee;
        this.transportFee = transportFee;
        this.feeForTrainer = feeForTrainer;
        this.allowanceFee = alowanceFee;
        this.stationaryFee = stationaryFee;
        this.otherFee = otherFee;
        this.costPerPerson = costPerPerson;
        this.individualCostPlan = individualCostPlan;

    }

    public TrainingReportModel(String employeeId,String fullName, String departmentPath,
            String jobDescription, String categoryName, String trainingName, double individualCostPlanned, double trainingFee, double intertainmentFee, double transportFee, double feeForTrainer, double alowanceFee, double stationaryFee, double otherFee, double costPerPerson){
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.categoryName = categoryName;
        this.trainingName = trainingName;
        this.departmentPath = departmentPath;
        this.jobDescription = jobDescription;
        this.trainingFee = trainingFee;
        this.intertainmentFee = intertainmentFee;
        this.transportFee = transportFee;
        this.feeForTrainer = feeForTrainer;
        this.allowanceFee = alowanceFee;
        this.stationaryFee = stationaryFee;
        this.otherFee = otherFee;
        this.costPerPerson = costPerPerson;
        this.individualCostPlanned = individualCostPlanned;

    }

    
//public TrainingReportModel(String courseName, int noOfTrainee, double totalexpense){
//    this.courseName = courseName;
//    this.noOfTrainee = noOfTrainee;
//    this.totalexpense = totalexpense;
//}

public TrainingReportModel(String courseName, int noOfTraineeBefore, int noOfTrainee, double totalexpense){
    this.courseName = courseName;
    this.noOfTrainee = noOfTrainee;
    this.totalexpense = totalexpense;
    this.noOfTraineeBefore = noOfTraineeBefore;
}

//public TrainingReportModel(String courseName, int noOfTraineeBefore, int noOfTrainee, double totalexpense){
//    this.courseName = courseName;
//    this.noOfTrainee = noOfTrainee;
//    this.totalexpense = totalexpense;
//    this.noOfTraineeBefore = noOfTraineeBefore;
//}

public TrainingReportModel(String trainingName, int  numberOfTraineeForYear, int noOfTraineeStillNow, double planFulfilled, double totalcostStillNow){
    this.trainingName = trainingName;
    this.numberOfTraineeForYear = numberOfTraineeForYear;
    this.planFulfilled = planFulfilled;
    this.totalCostStillNow = totalcostStillNow;
    this.numberOfTraineeStillNow = noOfTraineeStillNow;
}
    

}
