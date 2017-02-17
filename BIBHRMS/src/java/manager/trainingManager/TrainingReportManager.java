/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.trainingManager;

import entity.trainingEntity.TrainingReportEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import manager.ReportCritera.ReportCriteraManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author tomgenial
 */
//budjetYear, institutionId, trainingId
//String budjetYear, int institutionId, int trainingId
public class TrainingReportManager {
    TrainingReportEntity trainingRequestEntity = new TrainingReportEntity();

    public ArrayList<TrainingReportModel> getTrainingRequests() {
        ArrayList<TrainingReportModel> trainingRequestLists = new ArrayList<TrainingReportModel>();
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRequestByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRequestByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRequestBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRequestByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRequestByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }

        return trainingRequestLists;
    }


    public ArrayList<TrainingReportModel> getTrainingRejects() {
        ArrayList<TrainingReportModel> trainingRequestLists = new ArrayList<TrainingReportModel>();
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRejectByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRejectByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRejectBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRejectByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingRejectByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                int numberOfEmployee = _rs.getInt("NUMBER_OF_EMPLOYEES");
                String description = _rs.getString("EDUCATION_LEVEL");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                TrainingReportModel trainingRequestModel = new TrainingReportModel(employeeId,fullName, sex, departmentPath, jobDescription, categoryName, trainingName, numberOfEmployee, description, institutionName, appliedDate, startDate, endDate);
                trainingRequestLists.add(trainingRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }

        return trainingRequestLists;
    }


     public ArrayList<TrainingReportModel> getTrainingApproved() {
        ArrayList<TrainingReportModel> trainingApprovedLists = new ArrayList<TrainingReportModel>();
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingApprovedByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");

                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                String noOfDays = _rs.getString("NO_OF_DAYS");
                String award = _rs.getString("AWARD");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String trainerName = _rs.getString("TRAINER_NAME");
                TrainingReportModel trainingApproveModel = new TrainingReportModel(employeeId, fullName, departmentPath, jobDescription, categoryName, trainingName, appliedDate, startDate, endDate, noOfDays, award, institutionName, trainerName);
                trainingApprovedLists.add(trainingApproveModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingApprovedByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");

                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                String noOfDays = _rs.getString("NO_OF_DAYS");
                String award = _rs.getString("AWARD");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String trainerName = _rs.getString("TRAINER_NAME");
                TrainingReportModel trainingApproveModel = new TrainingReportModel(employeeId, fullName, departmentPath, jobDescription, categoryName, trainingName, appliedDate, startDate, endDate, noOfDays, award, institutionName, trainerName);
                trainingApprovedLists.add(trainingApproveModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingApprovedBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");

                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                String noOfDays = _rs.getString("NO_OF_DAYS");
                String award = _rs.getString("AWARD");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String trainerName = _rs.getString("TRAINER_NAME");
                TrainingReportModel trainingApproveModel = new TrainingReportModel(employeeId, fullName, departmentPath, jobDescription, categoryName, trainingName, appliedDate, startDate, endDate, noOfDays, award, institutionName, trainerName);
                trainingApprovedLists.add(trainingApproveModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingApprovedByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");

                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                String noOfDays = _rs.getString("NO_OF_DAYS");
                String award = _rs.getString("AWARD");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String trainerName = _rs.getString("TRAINER_NAME");
                TrainingReportModel trainingApproveModel = new TrainingReportModel(employeeId, fullName, departmentPath, jobDescription, categoryName, trainingName, appliedDate, startDate, endDate, noOfDays, award, institutionName, trainerName);
                trainingApprovedLists.add(trainingApproveModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingApprovedByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");

                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String categoryName = _rs.getString("CATEGORY_NAME");
                String trainingName = _rs.getString("TRAINING_NAME");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("TENTATIVE_START_DATE");
                String endDate = _rs.getString("TENTATIVE_END_DATE");
                String noOfDays = _rs.getString("NO_OF_DAYS");
                String award = _rs.getString("AWARD");
                String institutionName = _rs.getString("INSTITUTION_NAME");
                String trainerName = _rs.getString("TRAINER_NAME");
                TrainingReportModel trainingApproveModel = new TrainingReportModel(employeeId, fullName, departmentPath, jobDescription, categoryName, trainingName, appliedDate, startDate, endDate, noOfDays, award, institutionName, trainerName);
                trainingApprovedLists.add(trainingApproveModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }
        return trainingApprovedLists;
    }

        public ArrayList<TrainingReportModel> getTrainingCosts() {

        ArrayList<TrainingReportModel> trainingCostLists = new ArrayList<TrainingReportModel>();
        boolean firstTime = true;
        double total = 0;

                double trainingFeeT = 0.0;
                double intertainmentFeeT = 0.0;
                double transportFeeT = 0.0;
                double feeForTrainerT = 0.0;
                double allowanceFeeT = 0.0;
                double statioanryFeeT = 0.0;
                double otherFeeT = 0.0;
                double costPerPersonT = 0.0;
                double individualCostPlanT = 0.0;

        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingCostsByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("emp_id");
                String fullName = _rs.getString("FULL_NAME");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String trainingName = _rs.getString("TRAINING_NAME");
                String trainingCategoyName = _rs.getString("CATEGORY_NAME");
                double individualCostPlan = _rs.getDouble("Individual_cost_plan");
                double trainingFee = _rs.getInt("training_fee");
                double intertainmentFee = _rs.getDouble("intertainment_fee");
                double transportFee = _rs.getDouble("transport_fee");
                double feeForTrainer = _rs.getDouble("fee_for_trainer");
                double allowanceFee = _rs.getDouble("allowance_fee");
                double statioanryFee = _rs.getDouble("stationary_fee");
                double otherFee = _rs.getDouble("other_fees");
                double costPerPerson = _rs.getDouble("costperperson");
                 trainingFeeT = trainingFeeT + trainingFee;
                 intertainmentFeeT = intertainmentFeeT + intertainmentFee;
                 transportFeeT = transportFeeT + transportFee;
                 feeForTrainerT = feeForTrainerT + feeForTrainer;
                 allowanceFeeT = allowanceFeeT + allowanceFee;
                 statioanryFeeT = statioanryFeeT + statioanryFee;
                 otherFeeT = otherFeeT + otherFee;
                 costPerPersonT = costPerPersonT + costPerPerson;
                 individualCostPlanT = individualCostPlanT + individualCostPlan;
                TrainingReportModel trainingCostModel = new TrainingReportModel(employeeId,fullName, departmentPath, jobDescription, trainingCategoyName, trainingName, individualCostPlan, trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, statioanryFee, otherFee, costPerPerson);
                trainingCostLists.add(trainingCostModel);
            }
                TrainingReportModel trainingCostModel = new TrainingReportModel("","", "", "", "", "", individualCostPlanT, trainingFeeT, intertainmentFeeT, transportFeeT, feeForTrainerT, allowanceFeeT, statioanryFeeT, otherFeeT, costPerPersonT);
                trainingCostLists.add(trainingCostModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingCostsByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("emp_id");
                String fullName = _rs.getString("FULL_NAME");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String trainingName = _rs.getString("TRAINING_NAME");
                String trainingCategoyName = _rs.getString("CATEGORY_NAME");
                double individualCostPlan = _rs.getDouble("Individual_cost_plan");
                double trainingFee = _rs.getInt("training_fee");
                double intertainmentFee = _rs.getDouble("intertainment_fee");
                double transportFee = _rs.getDouble("transport_fee");
                double feeForTrainer = _rs.getDouble("fee_for_trainer");
                double allowanceFee = _rs.getDouble("allowance_fee");
                double statioanryFee = _rs.getDouble("stationary_fee");
                double otherFee = _rs.getDouble("other_fees");
                double costPerPerson = _rs.getDouble("costperperson");
                 trainingFeeT = trainingFeeT + trainingFee;
                 intertainmentFeeT = intertainmentFeeT + intertainmentFee;
                 transportFeeT = transportFeeT + transportFee;
                 feeForTrainerT = feeForTrainerT + feeForTrainer;
                 allowanceFeeT = allowanceFeeT + allowanceFee;
                 statioanryFeeT = statioanryFeeT + statioanryFee;
                 otherFeeT = otherFeeT + otherFee;
                 costPerPersonT = costPerPersonT + costPerPerson;
                 individualCostPlanT = individualCostPlanT + individualCostPlan;
                TrainingReportModel trainingCostModel = new TrainingReportModel(employeeId,fullName, departmentPath, jobDescription, trainingCategoyName, trainingName, individualCostPlan, trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, statioanryFee, otherFee, costPerPerson);
                trainingCostLists.add(trainingCostModel);
            }
                TrainingReportModel trainingCostModel = new TrainingReportModel("","", "", "", "", "", individualCostPlanT, trainingFeeT, intertainmentFeeT, transportFeeT, feeForTrainerT, allowanceFeeT, statioanryFeeT, otherFeeT, costPerPersonT);
                trainingCostLists.add(trainingCostModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingCostsBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("emp_id");
                String fullName = _rs.getString("FULL_NAME");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String trainingName = _rs.getString("TRAINING_NAME");
                String trainingCategoyName = _rs.getString("CATEGORY_NAME");
                double individualCostPlan = _rs.getDouble("Individual_cost_plan");
                double trainingFee = _rs.getInt("training_fee");
                double intertainmentFee = _rs.getDouble("intertainment_fee");
                double transportFee = _rs.getDouble("transport_fee");
                double feeForTrainer = _rs.getDouble("fee_for_trainer");
                double allowanceFee = _rs.getDouble("allowance_fee");
                double statioanryFee = _rs.getDouble("stationary_fee");
                double otherFee = _rs.getDouble("other_fees");
                double costPerPerson = _rs.getDouble("costperperson");
                 trainingFeeT = trainingFeeT + trainingFee;
                 intertainmentFeeT = intertainmentFeeT + intertainmentFee;
                 transportFeeT = transportFeeT + transportFee;
                 feeForTrainerT = feeForTrainerT + feeForTrainer;
                 allowanceFeeT = allowanceFeeT + allowanceFee;
                 statioanryFeeT = statioanryFeeT + statioanryFee;
                 otherFeeT = otherFeeT + otherFee;
                 costPerPersonT = costPerPersonT + costPerPerson;
                 individualCostPlanT = individualCostPlanT + individualCostPlan;
                TrainingReportModel trainingCostModel = new TrainingReportModel(employeeId,fullName, departmentPath, jobDescription, trainingCategoyName, trainingName, individualCostPlan, trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, statioanryFee, otherFee, costPerPerson);
                trainingCostLists.add(trainingCostModel);
            }
                TrainingReportModel trainingCostModel = new TrainingReportModel("","", "", "", "", "", individualCostPlanT, trainingFeeT, intertainmentFeeT, transportFeeT, feeForTrainerT, allowanceFeeT, statioanryFeeT, otherFeeT, costPerPersonT);
                trainingCostLists.add(trainingCostModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingCostsByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
//                if (firstTime) {
//
//                    total = Double.valueOf(_rs.getString("Total_amount"));
//                    if (total > 0) {
//                        firstTime = false;
//                    }
//                }
              
                String employeeId = _rs.getString("emp_id");
                String fullName = _rs.getString("FULL_NAME");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String trainingName = _rs.getString("TRAINING_NAME");
                String trainingCategoyName = _rs.getString("CATEGORY_NAME");
                double individualCostPlan = _rs.getDouble("Individual_cost_plan");
                double trainingFee = _rs.getInt("training_fee");
                double intertainmentFee = _rs.getDouble("intertainment_fee");
                double transportFee = _rs.getDouble("transport_fee");
                double feeForTrainer = _rs.getDouble("fee_for_trainer");
                double allowanceFee = _rs.getDouble("allowance_fee");
                double statioanryFee = _rs.getDouble("stationary_fee");
                double otherFee = _rs.getDouble("other_fees");
                double costPerPerson = _rs.getDouble("costperperson");
                 trainingFeeT = trainingFeeT + trainingFee;
                 intertainmentFeeT = intertainmentFeeT + intertainmentFee;
                 transportFeeT = transportFeeT + transportFee;
                 feeForTrainerT = feeForTrainerT + feeForTrainer;
                 allowanceFeeT = allowanceFeeT + allowanceFee;
                 statioanryFeeT = statioanryFeeT + statioanryFee;
                 otherFeeT = otherFeeT + otherFee;
                 costPerPersonT = costPerPersonT + costPerPerson;
                 individualCostPlanT = individualCostPlanT + individualCostPlan;
                TrainingReportModel trainingCostModel = new TrainingReportModel(employeeId,fullName, departmentPath, jobDescription, trainingCategoyName, trainingName, individualCostPlan, trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, statioanryFee, otherFee, costPerPerson);
                trainingCostLists.add(trainingCostModel);
            }
                TrainingReportModel trainingCostModel = new TrainingReportModel("","", "", "", "", "", individualCostPlanT, trainingFeeT, intertainmentFeeT, transportFeeT, feeForTrainerT, allowanceFeeT, statioanryFeeT, otherFeeT, costPerPersonT);
                trainingCostLists.add(trainingCostModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingCostsByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("emp_id");
                String fullName = _rs.getString("FULL_NAME");
                String departmentPath = _rs.getString("department_name");
                String jobDescription = _rs.getString("job_name");
                String trainingName = _rs.getString("TRAINING_NAME");
                String trainingCategoyName = _rs.getString("CATEGORY_NAME");
                double individualCostPlan = _rs.getDouble("Individual_cost_plan");
                double trainingFee = _rs.getInt("training_fee");
                double intertainmentFee = _rs.getDouble("intertainment_fee");
                double transportFee = _rs.getDouble("transport_fee");
                double feeForTrainer = _rs.getDouble("fee_for_trainer");
                double allowanceFee = _rs.getDouble("allowance_fee");
                double statioanryFee = _rs.getDouble("stationary_fee");
                double otherFee = _rs.getDouble("other_fees");
                double costPerPerson = _rs.getDouble("costperperson");
                 trainingFeeT = trainingFeeT + trainingFee;
                 intertainmentFeeT = intertainmentFeeT + intertainmentFee;
                 transportFeeT = transportFeeT + transportFee;
                 feeForTrainerT = feeForTrainerT + feeForTrainer;
                 allowanceFeeT = allowanceFeeT + allowanceFee;
                 statioanryFeeT = statioanryFeeT + statioanryFee;
                 otherFeeT = otherFeeT + otherFee;
                 costPerPersonT = costPerPersonT + costPerPerson;
                 individualCostPlanT = individualCostPlanT + individualCostPlan;
                TrainingReportModel trainingCostModel = new TrainingReportModel(employeeId,fullName, departmentPath, jobDescription, trainingCategoyName, trainingName, individualCostPlan, trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, statioanryFee, otherFee, costPerPerson);
                trainingCostLists.add(trainingCostModel);
            }
                TrainingReportModel trainingCostModel = new TrainingReportModel("","", "", "", "", "", individualCostPlanT, trainingFeeT, intertainmentFeeT, transportFeeT, feeForTrainerT, allowanceFeeT, statioanryFeeT, otherFeeT, costPerPersonT);
                trainingCostLists.add(trainingCostModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }
        return trainingCostLists;
    }

        public ArrayList<TrainingReportModel> getTrainingStatistics() {
        ArrayList<TrainingReportModel> trainingStatisticsLists = new ArrayList<TrainingReportModel>();
        double sum = 0.0;
        int trainerBefor = 0;
        int trainerNow = 0;
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingStatisticsByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String courseName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeBefore = _rs.getInt("NUMBER_OF_TRAINEE_BEFORE");
                int numberOfTrainee = _rs.getInt("NUMBER_OF_TRAINEE");
                double totalCost = _rs.getDouble("TOTAL_COST");
                sum = sum + totalCost;
                trainerBefor = trainerBefor + numberOfTraineeBefore;
                trainerNow = trainerNow + numberOfTrainee;
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel(courseName,numberOfTraineeBefore,numberOfTrainee, totalCost);
                trainingStatisticsLists.add(trainingStatisticsModel);
            }
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel("",trainerBefor,trainerNow, sum);
                trainingStatisticsLists.add(trainingStatisticsModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingStatisticsByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String courseName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeBefore = _rs.getInt("NUMBER_OF_TRAINEE_BEFORE");
                int numberOfTrainee = _rs.getInt("NUMBER_OF_TRAINEE");
                double totalCost = _rs.getDouble("TOTAL_COST");
                sum = sum + totalCost;
                trainerBefor = trainerBefor + numberOfTraineeBefore;
                trainerNow = trainerNow + numberOfTrainee;
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel(courseName,numberOfTraineeBefore,numberOfTrainee, totalCost);
                trainingStatisticsLists.add(trainingStatisticsModel);
            }
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel("",trainerBefor,trainerNow, sum);
                trainingStatisticsLists.add(trainingStatisticsModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingStatisticsBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String courseName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeBefore = _rs.getInt("NUMBER_OF_TRAINEE_BEFORE");
                int numberOfTrainee = _rs.getInt("NUMBER_OF_TRAINEE");
                double totalCost = _rs.getDouble("TOTAL_COST");
                sum = sum + totalCost;
                trainerBefor = trainerBefor + numberOfTraineeBefore;
                trainerNow = trainerNow + numberOfTrainee;
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel(courseName,numberOfTraineeBefore,numberOfTrainee, totalCost);
                trainingStatisticsLists.add(trainingStatisticsModel);
            }
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel("",trainerBefor,trainerNow, sum);
                trainingStatisticsLists.add(trainingStatisticsModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingStatisticsByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {

                String courseName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeBefore = _rs.getInt("NUMBER_OF_TRAINEE_BEFORE");
                int numberOfTrainee = _rs.getInt("NUMBER_OF_TRAINEE");
                double totalCost = _rs.getDouble("TOTAL_COST");
                sum = sum + totalCost;
                trainerBefor = trainerBefor + numberOfTraineeBefore;
                trainerNow = trainerNow + numberOfTrainee;
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel(courseName,numberOfTraineeBefore,numberOfTrainee, totalCost);
                trainingStatisticsLists.add(trainingStatisticsModel);
            }
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel("",trainerBefor,trainerNow, sum);
                trainingStatisticsLists.add(trainingStatisticsModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingStatisticsByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String courseName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeBefore = _rs.getInt("NUMBER_OF_TRAINEE_BEFORE");
                int numberOfTrainee = _rs.getInt("NUMBER_OF_TRAINEE");
                double totalCost = _rs.getDouble("TOTAL_COST");
                sum = sum + totalCost;
                trainerBefor = trainerBefor + numberOfTraineeBefore;
                trainerNow = trainerNow + numberOfTrainee;
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel(courseName,numberOfTraineeBefore,numberOfTrainee, totalCost);
                trainingStatisticsLists.add(trainingStatisticsModel);
            }
                TrainingReportModel trainingStatisticsModel = new TrainingReportModel("",trainerBefor,trainerNow, sum);
                trainingStatisticsLists.add(trainingStatisticsModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }
        return trainingStatisticsLists;
    }

        public ArrayList<TrainingReportModel> getTrainingPlanComparison() {
        ArrayList<TrainingReportModel> trainingPlanComparisonLists = new ArrayList<TrainingReportModel>();
        int traineeForTheYear = 0;
        int traineeStillNow = 0;
        double totalCost = 0.0;
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingPlanComparisonByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String trainingName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeForYear = _rs.getInt("PLAN_FOR_THE_YEAR");
                int numberOfTraineeStillNow = _rs.getInt("NUMBER_OF_TRAINEE_STILL_NOW");
                double planFulfilled = _rs.getDouble("PLAN_FULFILLED_BY_PERCENT");
                double totalCostStillNow = _rs.getDouble("TOTAL_COST_STILL_NOW");
                traineeForTheYear = traineeForTheYear + numberOfTraineeForYear;
                traineeStillNow = traineeStillNow + numberOfTraineeStillNow;
                totalCost = totalCost + totalCostStillNow;
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel(trainingName,numberOfTraineeForYear,numberOfTraineeStillNow,planFulfilled, totalCostStillNow);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            }
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel("",traineeForTheYear,traineeStillNow,0.0, totalCost);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingPlanComparisonByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String trainingName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeForYear = _rs.getInt("PLAN_FOR_THE_YEAR");
                int numberOfTraineeStillNow = _rs.getInt("NUMBER_OF_TRAINEE_STILL_NOW");
                double planFulfilled = _rs.getDouble("PLAN_FULFILLED_BY_PERCENT");
                double totalCostStillNow = _rs.getDouble("TOTAL_COST_STILL_NOW");
                traineeForTheYear = traineeForTheYear + numberOfTraineeForYear;
                traineeStillNow = traineeStillNow + numberOfTraineeStillNow;
                totalCost = totalCost + totalCostStillNow;
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel(trainingName,numberOfTraineeForYear,numberOfTraineeStillNow,planFulfilled, totalCostStillNow);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            }
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel("",traineeForTheYear,traineeStillNow,0.0, totalCost);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingPlanComparisonBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String trainingName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeForYear = _rs.getInt("PLAN_FOR_THE_YEAR");
                int numberOfTraineeStillNow = _rs.getInt("NUMBER_OF_TRAINEE_STILL_NOW");
                double planFulfilled = _rs.getDouble("PLAN_FULFILLED_BY_PERCENT");
                double totalCostStillNow = _rs.getDouble("TOTAL_COST_STILL_NOW");
                traineeForTheYear = traineeForTheYear + numberOfTraineeForYear;
                traineeStillNow = traineeStillNow + numberOfTraineeStillNow;
                totalCost = totalCost + totalCostStillNow;
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel(trainingName,numberOfTraineeForYear,numberOfTraineeStillNow,planFulfilled, totalCostStillNow);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            }
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel("",traineeForTheYear,traineeStillNow,0.0, totalCost);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingPlanComparisonByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String trainingName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeForYear = _rs.getInt("PLAN_FOR_THE_YEAR");
                int numberOfTraineeStillNow = _rs.getInt("NUMBER_OF_TRAINEE_STILL_NOW");
                double planFulfilled = _rs.getDouble("PLAN_FULFILLED_BY_PERCENT");
                double totalCostStillNow = _rs.getDouble("TOTAL_COST_STILL_NOW");
                traineeForTheYear = traineeForTheYear + numberOfTraineeForYear;
                traineeStillNow = traineeStillNow + numberOfTraineeStillNow;
                totalCost = totalCost + totalCostStillNow;
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel(trainingName,numberOfTraineeForYear,numberOfTraineeStillNow,planFulfilled, totalCostStillNow);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            }
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel("",traineeForTheYear,traineeStillNow,0.0, totalCost);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = trainingRequestEntity.readAllTrainingPlanComparisonByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String trainingName = _rs.getString("TRAININGORCOURSE_NAME");
                int numberOfTraineeForYear = _rs.getInt("PLAN_FOR_THE_YEAR");
                int numberOfTraineeStillNow = _rs.getInt("NUMBER_OF_TRAINEE_STILL_NOW");
                double planFulfilled = _rs.getDouble("PLAN_FULFILLED_BY_PERCENT");
                double totalCostStillNow = _rs.getDouble("TOTAL_COST_STILL_NOW");
                traineeForTheYear = traineeForTheYear + numberOfTraineeForYear;
                traineeStillNow = traineeStillNow + numberOfTraineeStillNow;
                totalCost = totalCost + totalCostStillNow;
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel(trainingName,numberOfTraineeForYear,numberOfTraineeStillNow,planFulfilled, totalCostStillNow);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            }
                TrainingReportModel trainingPlanComparisonModel = new TrainingReportModel("",traineeForTheYear,traineeStillNow,0.0, totalCost);
                trainingPlanComparisonLists.add(trainingPlanComparisonModel);
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }
        return trainingPlanComparisonLists;
    }



}