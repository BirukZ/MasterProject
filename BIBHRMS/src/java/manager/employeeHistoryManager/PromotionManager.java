/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeHistoryManager;

import entity.employeeHistoryEntity.PromotionEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sun.webui.jsf.model.Option;
import entity.employeeEntity.EmployeeEntity;
import entity.globalUseEntity.Rank;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.LookUpManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author miki
 */
public class PromotionManager {

    private int promotionId;
    private String empFullName;
    private String empId;
    private String promotionDate;
    private String promotionType;
    private String rankFrom;
    private String rankTo;
    private String stepFrom;
    private String stepTo;
    private String salaryFrom;
    private String salaryTo;
    private String refNo;
    private String refDate;
    private String reason;
    private String promoterID;
    private String jobCodeFrom;
    private String jobCodeTo;
    private int advertID;
    private String department = null;
    private int proRequestId = 0;
    private String departmentFrom;
    private String departmentTo;
    private PromotionEntity promotionEntity = new PromotionEntity();
    private LookUpManager lookUpManager = new LookUpManager();
    private EmployeeEntity employeeEntity = new EmployeeEntity();
    private Rank rank = new Rank();

   

    public String getDepartmentFrom() {
        return departmentFrom;
    }

    public int saveExper(String requester_ID, int proRequestId, double year) throws SQLException {
      return  promotionEntity.saveExper(requester_ID,proRequestId,year);
    }


      public void setDepartmentFrom(String departmentFrom) {
        this.departmentFrom = departmentFrom;
    }

    public String getDepartmentTo() {
        return departmentTo;
    }

    public void setDepartmentTo(String departmentTo) {
        this.departmentTo = departmentTo;
    }

    /**
     * @return the advertID
     */
    public int getAdvertID() {
        return advertID;
    }

    public String getDirectorate() {
        return department;
    }

    public void setDirectorate(String directorate) {
        this.department = directorate;
    }

    /**
     * @param advertID the advertID to set
     */
    public void setAdvertID(int advertID) {
        this.advertID = advertID;
    }

    /**
     * @return the jobCodeFrom
     */
    public String getJobCodeFrom() {
        return jobCodeFrom;
    }

    /**
     * @param jobCodeFrom the jobCodeFrom to set
     */
    public void setJobCodeFrom(String jobCodeFrom) {
        this.jobCodeFrom = jobCodeFrom;
    }

    /**
     * @return the jobCodeTo
     */
    public String getJobCodeTo() {
        return jobCodeTo;
    }

    /**
     * @param jobCodeTo the jobCodeTo to set
     */
    public void setJobCodeTo(String jobCodeTo) {
        this.jobCodeTo = jobCodeTo;
    }

    /**
     * @return the promoterID
     */
    public String getPromoterID() {
        return promoterID;
    }

    /**
     * @param promoterID the promoterID to set
     */
    public void setPromoterID(String promoterID) {
        this.promoterID = promoterID;
    }

    /**
     * @return the promotionId
     */
    public int getPromotionId() {
        return promotionId;
    }

    /**
     * @param promotionId the promotionId to set
     */
    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * @return the empFullName
     */
    public String getEmpFullName() {
        return empFullName;
    }

    /**
     * @param empFullName the empFullName to set
     */
    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the promotionDate
     */
    public String getPromotionDate() {
        return promotionDate;
    }

    /**
     * @param promotionDate the promotionDate to set
     */
    public void setPromotionDate(String promotionDate) {
        this.promotionDate = promotionDate;
    }

    /**
     * @return the promotionType
     */
    public String getPromotionType() {
        return promotionType;
    }

    /**
     * @param promotionType the promotionType to set
     */
    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    /**
     * @return the rankFrom
     */
    public String getRankFrom() {
        return rankFrom;
    }

    /**
     * @param rankFrom the rankFrom to set
     */
    public void setRankFrom(String rankFrom) {
        this.rankFrom = rankFrom;
    }

    /**
     * @return the rankTo
     */
    public String getRankTo() {
        return rankTo;
    }

    /**
     * @param rankTo the rankTo to set
     */
    public void setRankTo(String rankTo) {
        this.rankTo = rankTo;
    }

    /**
     * @return the stepFrom
     */
    public String getStepFrom() {
        return stepFrom;
    }

    /**
     * @param stepFrom the stepFrom to set
     */
    public void setStepFrom(String stepFrom) {
        this.stepFrom = stepFrom;
    }

    /**
     * @return the stepTo
     */
    public String getStepTo() {
        return stepTo;
    }

    /**
     * @param stepTo the stepTo to set
     */
    public void setStepTo(String stepTo) {
        this.stepTo = stepTo;
    }

    /**
     * @return the salaryFrom
     */
    public String getSalaryFrom() {
        return salaryFrom;
    }

    /**
     * @param salaryFrom the salaryFrom to set
     */
    public void setSalaryFrom(String salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    /**
     * @return the salaryTo
     */
    public String getSalaryTo() {
        return salaryTo;
    }

    /**
     * @param salaryTo the salaryTo to set
     */
    public void setSalaryTo(String salaryTo) {
        this.salaryTo = salaryTo;
    }

    /**
     * @return the refNo
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * @param refNo the refNo to set
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    /**
     * @return the refDate
     */
    public String getRefDate() {
        return refDate;
    }

    /**
     * @param refDate the refDate to set
     */
    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    public PromotionManager() {
    }

    public PromotionManager(
            int promotionId,
            String empId,
            String promotionDate,
            String promotionType,
            String rankFrom,
            String rankTo,
            String stepFrom,
            String stepTo,
            String salaryFrom,
            String salaryTo,
            String refNo,
            String refDate,
            String reason) {
        this.promotionId = promotionId;
        this.empId = empId;
        this.promotionDate = promotionDate;
        this.promotionType = promotionType;
        this.rankFrom = rankFrom;
        this.rankTo = rankTo;
        this.stepFrom = stepFrom;
        this.stepTo = stepTo;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.refNo = refNo;
        this.refDate = refDate;
        this.reason = reason;
    }

    public PromotionManager(
            String empID,
            String promoterID,
            String jobCodeFrom,
            String jobCodeTo,
            String refrenceDate,
            String referenceNo,
            String salaryFrom,
            String salaryTo,
            String stepFrom,
            String stepTo,
            String rankFrom,
            String rankTo,
            String promotionDate,
            int advertID,
            String departmentFrom,
            String departmentTo) {

        this.promoterID = promoterID;
        this.empId = empID;
        this.jobCodeFrom = jobCodeFrom;
        this.jobCodeTo = jobCodeTo;
        this.promotionDate = promotionDate;
        this.rankFrom = rankFrom;
        this.rankTo = rankTo;
        this.stepFrom = stepFrom;
        this.stepTo = stepTo;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.refNo = referenceNo;
        this.refDate = refrenceDate;
        this.advertID = advertID;
        this.departmentFrom = departmentFrom;
        this.departmentTo = departmentTo;
    }

    public PromotionManager(String empID, String promoterID, String jobCodeFrom, String jobCodeTo, String refrenceDate, String referenceNo,
            String salaryFrom, String salaryTo, String stepFrom, String stepTo, String rankFrom,
            String rankTo, String promotionDate, int advertID, String zerf, String directorate,
            String division, String mastebaberia, String team, int promotionID) {

        this.promotionId = promotionID;
        this.promoterID = promoterID;
        this.empId = empID;
        this.jobCodeFrom = jobCodeFrom;
        this.jobCodeTo = jobCodeTo;
        this.promotionDate = promotionDate;
        this.rankFrom = rankFrom;
        this.rankTo = rankTo;
        this.stepFrom = stepFrom;
        this.stepTo = stepTo;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.refNo = referenceNo;
        this.refDate = refrenceDate;
        this.advertID = advertID;
        this.department = directorate;





    }

    public int insertPromotion(PromotionManager PM) {
        PromotionEntity promoEntity = new PromotionEntity(
                PM.empId,
                PM.promoterID,
                PM.jobCodeFrom,
                PM.jobCodeTo,
                PM.refDate,
                PM.refNo,
                PM.salaryFrom,
                PM.salaryTo,
                PM.stepFrom,
                PM.stepTo,
                PM.rankFrom,
                PM.rankTo,
                PM.promotionDate,
                PM.advertID,
                PM.getDirectorate(),
                PM.getDepartmentFrom(),
                PM.getDepartmentTo());


        return promotionEntity.insertPromotion(promoEntity);

    }

    public int updatePromotion(PromotionManager PM) {
        PromotionEntity promoEntity = new PromotionEntity(
                PM.empId,
                PM.promoterID,
                PM.jobCodeFrom,
                PM.jobCodeTo,
                PM.refDate,
                PM.refNo,
                PM.salaryFrom,
                PM.salaryTo,
                PM.stepFrom,
                PM.stepTo,
                PM.rankFrom,
                PM.rankTo,
                PM.promotionDate,
                PM.advertID,
                PM.getDirectorate(),
                PM.getPromotionId());

        return promotionEntity.updatePromotion(promoEntity);
    }

    public HashMap readPromotionIndividualDetail(String promotionID) {
        return promotionEntity.readPromotionIndividualDetail(promotionID);
    }

    public HashMap readPromotionHistory(String promotionID) {
        return promotionEntity.readPromotionHistory(promotionID);
    }

    public HashMap readPromotionRequestInformation(String promotionRequestId, String employeeId) {
        try {
            int sum = 0;
            HashMap listOfNewJob = new HashMap();
           
            HashMap promotionRequestInformation = promotionEntity.readPromotionRequestInformation(promotionRequestId);
            HashMap employeeInformation = employeeEntity.readEmployeeBasicInfoFrom(employeeId);

            if (promotionRequestInformation != null && employeeInformation != null) {
                listOfNewJob.put("JOB_CODE", promotionRequestInformation.get("JOB_CODE"));
                listOfNewJob.put("RECRUIT_REQUEST_ID", promotionRequestInformation.get("RECRUIT_REQUEST_ID"));
                listOfNewJob.put("DEPARTMENT_ID", promotionRequestInformation.get("DEPARTMENT_ID"));
                listOfNewJob.put("ADVERT_ID", promotionRequestInformation.get("ADVERT_ID"));
                listOfNewJob.put("JOB_NAME", promotionRequestInformation.get("JOB_NAME"));


                if (Integer.parseInt(employeeInformation.get("employeRank").toString()) <
                        Integer.parseInt(promotionRequestInformation.get("RANK_ID").toString())) {
                  
                    if (Double.valueOf(employeeInformation.get("EMPSALARY").toString()) <
                            Double.valueOf(promotionRequestInformation.get("SALARY").toString())) {
                        listOfNewJob.put("RANK_ID", promotionRequestInformation.get("RANK_ID"));
                        listOfNewJob.put("SALARY", promotionRequestInformation.get("SALARY"));
                        listOfNewJob.put("PAYGRADE", "1");
                    } else if (Integer.parseInt(employeeInformation.get("EMPSALARY").toString()) ==
                            Integer.parseInt(promotionRequestInformation.get("SALARY").toString())) {
                        HashMap hm = rank.readRank("2", promotionRequestInformation.get("RANK_ID").toString());
                        listOfNewJob.put("RANK_ID", hm.get("RANK_ID"));
                        listOfNewJob.put("SALARY", hm.get("SALARY"));
                        listOfNewJob.put("PAYGRADE", hm.get("payGrade"));
                    } else {

                        HashMap hm = rank.readRank(
                                Integer.toString(+1),
                                employeeInformation.get("employeRank").toString());
                        listOfNewJob.put("SALARY", hm.get("SALARY"));
                        listOfNewJob.put("PAYGRADE", hm.get("payGrade"));
                        listOfNewJob.put("RANK_ID", hm.get("RANK_ID"));
                    }
                } else if (Integer.parseInt(employeeInformation.get("employeRank").toString()) ==
                        Integer.parseInt(promotionRequestInformation.get("RANK_ID").toString())) {
                    sum = Integer.parseInt(employeeInformation.get("payGrade").toString());
                    sum += 1;
                    HashMap hm = rank.readRank(Integer.toString(sum), employeeInformation.get("employeRank").toString());
                    if (hm != null) {
                        listOfNewJob.put("RANK_ID", promotionRequestInformation.get("RANK_ID").toString());
                        listOfNewJob.put("SALARY", hm.get("SALARY"));
                        listOfNewJob.put("PAYGRADE", hm.get("payGrade"));
                    }

                }
                return listOfNewJob;
            } else {
                return null;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
  public boolean  saveExp(ArrayList<HashMap> exper, double  year) {
        return promotionEntity.saveExp(exper,year);
    }

    public Option[] readPromotedEmployees(String advertID) {
        try {
            ArrayList<PromotionEntity> readPromoEmps = promotionEntity.readPromotedEmployees(advertID);
            Option[] promEmp = new Option[readPromoEmps.size() + 1];

            Option assign = new Option("00", "Promoted Employees");
            promEmp[0] = assign;

            if (readPromoEmps.size() > 0) {
                for (int i = 0; i < readPromoEmps.size(); i++) {
                    promotionEntity = readPromoEmps.get(i);
                    assign = new Option(
                            promotionEntity.getPromotionId() + "---" +
                            promotionEntity.getEmpFullName(),
                            promotionEntity.getEmpFullName());
                    promEmp[i + 1] = assign;

                }
            }
            return promEmp;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public ArrayList<SelectItem> employeePromoteList(String employeeId) {

        try {
            ArrayList<PromotionEntity> bachCodeList = promotionEntity.employeePromoteList(employeeId);
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (bachCodeList.size() > 0) {
                for (int i = 0; i < bachCodeList.size(); i++) {
                    promotionEntity = bachCodeList.get(i);
                    questionlist.add(new Option(String.valueOf(promotionEntity.getPromotionId()),
                            String.valueOf(promotionEntity.getEmpFullName())));
                }
                questionlist.add(0, new Option(null, "Select Promotion Date"));
            } else {
                questionlist.add(0, new Option(null, " Promotion History not available "));
            }

            return questionlist;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<SelectItem> listOfPromotionSegestion() {

        try {
            ArrayList<PromotionEntity> bachCodeList = promotionEntity.listOfPromotionSegestion();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (bachCodeList.size() > 0) {
                for (int i = 0; i < bachCodeList.size(); i++) {
                    promotionEntity = bachCodeList.get(i);
                    questionlist.add(new Option(String.valueOf(promotionEntity.getPromotionId()),
                            String.valueOf(promotionEntity.getEmpFullName())));
                }
                questionlist.add(0, new Option(null, "Select Promotion Date"));
            } else {
                questionlist.add(0, new Option(null, " Promotion History not available "));
            }

            return questionlist;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean saveWithoutAdvertismentPromotion(HashMap promotionInformation) {
        return promotionEntity.saveWithoutAdvertismentPromotion(promotionInformation);
    }

    public boolean updateWithoutAdvertismentPromotion(HashMap promotionInformation) {
        return promotionEntity.updateWithoutAdvertismentPromotion(promotionInformation);
    }

    public ArrayList<SelectItem> SelectionCriteriaForMPromo() {
        try {
            ArrayList<SelectItem> promoCriterialist = new ArrayList<SelectItem>();
            promoCriterialist.add(0, new Option("0---0", "--Select Criteria--"));
            promoCriterialist.add(1, new Option("0---2", "First Step Promotion"));
            promoCriterialist.add(2, new Option("1---2", "Second Step Promotion"));
            promoCriterialist.add(3, new Option("2---2", "Third Step Promotion"));
            promoCriterialist.add(4, new Option("3---2", "Fourth Step Promotion"));

            return promoCriterialist;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Option[] qulifiedIndividualsForPromo(String num, String identifier) {
        try {
            ArrayList<PromotionEntity> readRecruitmentRequests = promotionEntity.qulifiedIndividualsForPromo(num, identifier);
            if (readRecruitmentRequests != null) {
                Option[] requritment = new Option[readRecruitmentRequests.size() + 1];
                Option assign = new Option("00", "Select Employee to Promote");
                requritment[0] = assign;

                if (readRecruitmentRequests.size() > 0) {
                    for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                        promotionEntity = readRecruitmentRequests.get(i);
                        assign = new Option(promotionEntity.getEmpId(), promotionEntity.getEmpId());
                        requritment[i + 1] = assign;

                    }
                }
                return requritment;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Option[] qulifiedIndividualsForPromo(String val1, String val2, String val3, String identifier) {
        try {
            ArrayList<PromotionEntity> readRecruitmentRequests = promotionEntity.qulifiedIndividualsForPromo(val1, val2, val3, identifier);
            if (readRecruitmentRequests != null) {
                Option[] requritment = new Option[readRecruitmentRequests.size() + 1];
                Option assign = new Option("00", "Select Employee to Promote");
                requritment[0] = assign;

                if (readRecruitmentRequests.size() > 0) {
                    for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                        promotionEntity = readRecruitmentRequests.get(i);
                        assign = new Option(promotionEntity.getEmpId(), promotionEntity.getEmpId());
                        requritment[i + 1] = assign;

                    }
                }
                return requritment;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Option[] qulifiedIndividualsForPromo(String val1, String val2, String val3, String val4, String identifier) {
        try {
            ArrayList<PromotionEntity> readRecruitmentRequests = promotionEntity.qulifiedIndividualsForPromo(val1, val2, val3, val4, identifier);
            if (readRecruitmentRequests != null) {
                Option[] requritment = new Option[readRecruitmentRequests.size() + 1];
                Option assign = new Option("00", "Select Employee to Promote");
                requritment[0] = assign;

                if (readRecruitmentRequests.size() > 0) {
                    for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                        promotionEntity = readRecruitmentRequests.get(i);
                        assign = new Option(promotionEntity.getEmpId(), promotionEntity.getEmpId());
                        requritment[i + 1] = assign;

                    }
                }
                return requritment;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Option[] qulifiedIndividualsForPromo(String val1, String val2, String val3, String val4, String val5, String identifier) {
        try {
            ArrayList<PromotionEntity> readRecruitmentRequests = promotionEntity.qulifiedIndividualsForPromo(val1, val2, val3, val4, val5, identifier);
            if (readRecruitmentRequests != null) {
                Option[] requritment = new Option[readRecruitmentRequests.size() + 1];
                Option assign = new Option("00", "Select Employee to Promote");
                requritment[0] = assign;

                if (readRecruitmentRequests.size() > 0) {
                    for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                        promotionEntity = readRecruitmentRequests.get(i);
                        assign = new Option(promotionEntity.getEmpId(), promotionEntity.getEmpId());
                        requritment[i + 1] = assign;

                    }
                }
                return requritment;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Option[] qulifiedIndividualsForPromo(String val1, String val2, String val3, String val4, String val5, String val6, String identifier) {
        try {
            ArrayList<PromotionEntity> readRecruitmentRequests = promotionEntity.qulifiedIndividualsForPromo(val1, val2, val3, val4, val5, val6, identifier);
            if (readRecruitmentRequests != null) {
                Option[] requritment = new Option[readRecruitmentRequests.size() + 1];
                Option assign = new Option("00", "Select Employee to Promote");
                requritment[0] = assign;

                if (readRecruitmentRequests.size() > 0) {
                    for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                        promotionEntity = readRecruitmentRequests.get(i);
                        assign = new Option(promotionEntity.getEmpId(), promotionEntity.getEmpId());
                        requritment[i + 1] = assign;

                    }
                }
                return requritment;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int readPromotionStatus(String employeeId) {
        return promotionEntity.readPromotionStatus(employeeId);
    }

    public Collection promotionReport(String promotionId) {
        try {
            EmployeeManage employeeManage = new EmployeeManage();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = promotionEntity.promotionReport(promotionId);
            List<HashMap> resignedList = new ArrayList<HashMap>();
            if (ocrs.next()) {
                HashMap hm = new HashMap();
                employeeManage = new EmployeeManage();
                employeeManage.loadEmpoyeeProfile(ocrs.getString("EMP_ID").toString());
                hm.put("EMPLOYEEFULLNAME", employeeManage.getTitleDes() + " " + employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
                hm.put("EMPLOYEEDEPARTMENT", employeeManage.getDepartment());
                //
                if (employeeManage.getSex().equalsIgnoreCase("Male")) {
                    hm.put("MALE", "X");
                    hm.put("lblPromotionDate", "ያደገበት ቀን");
                } else {
                    hm.put("FEMALE", "X");
                    hm.put("lblPromotionDate", "ያደገችበት ቀን");
                }
                hm.put("Profession", employeeManage.getJobDescription());
                hm.put("fromTitle", lookUpManager.readTitle(ocrs.getString("TITLEFROM")));
                hm.put("toTitle", lookUpManager.readTitle(ocrs.getString("TITLETO")));//
                if (employeeManage.getOfficeOrshift().equals("Shift")) {
                    hm.put("fromGrade", lookUpManager.readTitle(ocrs.getString("RANK_FROM")));
                    hm.put("toGrade", lookUpManager.readTitle(ocrs.getString("RANK_TO")));
                } else {
                    hm.put("fromGrade", ocrs.getString("RANK_FROM"));
                    hm.put("toGrade", ocrs.getString("RANK_TO"));
                }
                hm.put("fromPayGrade", ocrs.getString("STEP_FROM"));
                hm.put("REQUESTER_ID", ocrs.getString("EMP_ID"));
                hm.put("toPayGrade", ocrs.getString("STEP_TO"));
                hm.put("SALARY", ocrs.getString("SALARY_FROM"));
                hm.put("toSalary", ocrs.getString("SALARY_TO"));
//
                hm.put("txtPromotionDate", ocrs.getString("PROMOTION_DATE"));

                resignedList.add(hm);
                return resignedList;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> loadEmployeePromotionForReport(String employeeId) {
        return promotionEntity.readPromotionForReport(employeeId);
    }

    public ArrayList<HashMap> employeeGroupPromotionReport(String searchCrayteriay) {
        try {
            return promotionEntity.promotionGroupReport(searchCrayteriay);

        } catch (Exception e) {
            return null;
        }

    }

    public boolean insertPromotionAssessmentPrecentage(HashMap promotionAssessmentPercentage) {
        return promotionEntity.insertPromotionAssessmentPrecentage(promotionAssessmentPercentage);
    }

    public boolean updatePromotionAssessmentPrecentage(HashMap promotionAssessmentPercentage) {
        return promotionEntity.updatePromotionAssessmentPrecentage(promotionAssessmentPercentage);
    }

    public boolean deletePromotionAssessmentPrecentage(String batchCode) {
        return promotionEntity.deletePromotionAssessmentPrecentage(batchCode);
    }

    public HashMap selectPromotionAssessmentPrecentage(String batchCode) {
        return promotionEntity.selectPromotionAssessmentPrecentage(batchCode);
    }

    public boolean insertPromotionAssessmentResult(int proRequestId, HashMap assessmentResult) {
        return promotionEntity.insertPromotionAssessmentResult(proRequestId, assessmentResult);
    }

    public boolean updatePromotionAssessmentResult(int promotionAssessmentId, HashMap assessmentResult) {
        return promotionEntity.updatePromotionAssessmentResult(promotionAssessmentId, assessmentResult);
    }

    public HashMap readPromotionAssessmentResultForUpdate(int proRequestId) {
        return promotionEntity.readPromotionAssessmentResultForUpdate(proRequestId);
    }

    public int countDisciplineCase(String employeeId) {
        try {
            String date = GregorianCalendarManipulation.subtractGregorianYear(2);
            return promotionEntity.countDisciplineCase(employeeId, date);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public float employeePerformanceResult(String employeeId) {
        try {
            String date = GregorianCalendarManipulation.subtractGregorianYear(1);
           
          
            return promotionEntity.evaluationResult(employeeId, date);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
     public boolean UPdatePromotedEmployeeStatus(String requesterIDforDiscipline) {
            try {
        promotionEntity.upDateEmployeeStatus(requesterIDforDiscipline);
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
            return true;
    }

    public boolean checkLastTimeExamResult(String employeeId) {
        try {

            String date = GregorianCalendarManipulation.subtractGregorianMonth(6);
            
            String examResult = promotionEntity.checkLastTimeExamResult(employeeId, date);
            if (examResult != null) {
                if (Float.parseFloat(examResult) > 50) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
