/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import com.sun.webui.jsf.model.Option;
import entity.recruitmentEntity.AdvertisementEntity;
import entity.recruitmentEntity.RecruitmentEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author Administrator
 */
public class AdvertisementManager {
   private float totalPercentValue;
   private String performanceSessionID;
   private String evaluatorEmp_ID;
   private String evaluatedEmp_ID;
   private String totalAvarege_Percent;
   private String perfor_EvaluationDate;
    private String recRequestID;
    private String advertID;
    private boolean selected;
    private boolean requestPromotion;
    private String mediaCode;
    private String realMediaCode;
    private String advertType;
    private String recruitmentType;
    private String requiredNo;
    private String experience;
    private float employeeDisciplineResult;
    private String qualification;
    private String educLevel;
    private String educLevelDesc;
    private String educTypeDesc;
    private String jobCode;
    private String fullName;
    private String empID;
    private double percenteducLevel;
    private double percentExperience;
    private double percentPerformance;
    private double percentTraining;
    private float percentTotal;
    private String advertismentType;
    private boolean selectPromotionRequester;
    private String promotionRequestId;
    private String jobDescription;
    private float interviewResult;
    private float writtenResult;
    private float presentationResult;
    private float other;
    private float toalExamResult;
    private float performanceValue;
    private float interviewPercentage;
    private float writtenPercentage;
    private float presentationPercentage;
    private float otherPercentage;
    private String hire_date;
    private float examPercentage;
    private float promotionPercentage;
    private float disciplinePercentage;
    private float promotionPercentageValue;
    private float disciplinePercentageValue;
    public static int INTITAL_PERCENTAGE = 1;
    private String mediaName;
    private int mediID;
    private int educLevelId;
    private int relatExp;
    private int rank;

    public ArrayList<AdvertisementManager> getAllOerformanceResult(String requesterIDforDiscipline) {
        ArrayList<AdvertisementManager> perforamcneValue = new ArrayList<AdvertisementManager>();
        try {
            ResultSet _rs = advertisementEntity.selectPerformanceValueByEmployee(requesterIDforDiscipline);
            while (_rs.next()) {
                AdvertisementManager perforamcneValueModel = new AdvertisementManager();
                perforamcneValueModel.setPerformanceSessionID(_rs.getString("SESSION_ID"));
                perforamcneValueModel.setEvaluatorEmp_ID(_rs.getString("EVALUATOR_EMP_ID"));
                perforamcneValueModel.setEvaluatedEmp_ID(_rs.getString("EVALUTED_EMP_ID"));
                perforamcneValueModel.setTotalPercentValue(_rs.getFloat("PERCENT_VALUE"));
                perforamcneValueModel.setTotalAvarege_Percent(_rs.getString("AVERAGE_VALUE"));
                perforamcneValueModel.setPerfor_EvaluationDate(_rs.getString("RESULT_SAVED_DATE"));
               // perforamcneValueModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                //perforamcneValueModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                //perforamcneValueModel.setStatus(_rs.getString("STATUS"));
                perforamcneValue.add(perforamcneValueModel);
            }
            _rs.close();
            return perforamcneValue;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public String getEvaluatedEmp_ID() {
        return evaluatedEmp_ID;
    }

    public void setEvaluatedEmp_ID(String evaluatedEmp_ID) {
        this.evaluatedEmp_ID = evaluatedEmp_ID;
    }

    public String getEvaluatorEmp_ID() {
        return evaluatorEmp_ID;
    }

    public void setEvaluatorEmp_ID(String evaluatorEmp_ID) {
        this.evaluatorEmp_ID = evaluatorEmp_ID;
    }

    public String getPerfor_EvaluationDate() {
        return perfor_EvaluationDate;
    }

    public void setPerfor_EvaluationDate(String perfor_EvaluationDate) {
        this.perfor_EvaluationDate = perfor_EvaluationDate;
    }

    public String getPerformanceSessionID() {
        return performanceSessionID;
    }

    public void setPerformanceSessionID(String performanceSessionID) {
        this.performanceSessionID = performanceSessionID;
    }

    public String getTotalAvarege_Percent() {
        return totalAvarege_Percent;
    }

    public void setTotalAvarege_Percent(String totalAvarege_Percent) {
        this.totalAvarege_Percent = totalAvarege_Percent;
    }

    public float getTotalPercentValue() {
        return totalPercentValue;
    }

    public void setTotalPercentValue(float totalPercentValue) {
        this.totalPercentValue = totalPercentValue;
    }

    public int getRelatExp() {
        return relatExp;
    }

    public void setRelatExp(int relatExp) {
        this.relatExp = relatExp;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getEducLevelId() {
        return educLevelId;
    }

    public void setEducLevelId(int educLevelId) {
        this.educLevelId = educLevelId;
    }

    public int getMediID() {
        return mediID;
    }

    public void setMediID(int mediID) {
        this.mediID = mediID;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public float getDisciplinePercentageValue() {
        return disciplinePercentageValue;
    }

    public void setDisciplinePercentageValue(float disciplinePercentageValue) {
        this.disciplinePercentageValue = disciplinePercentageValue;
    }

    public float getPromotionPercentageValue() {
        return promotionPercentageValue;
    }

    public void setPromotionPercentageValue(float promotionPercentageValue) {
        this.promotionPercentageValue = promotionPercentageValue;
    }

    public float getDisciplinePercentage() {
        return disciplinePercentage;
    }

    public void setDisciplinePercentage(float disciplinePercentage) {
        this.disciplinePercentage = disciplinePercentage;
    }

    public float getPromotionPercentage() {
        return promotionPercentage;
    }

    public void setPromotionPercentage(float promotionPercentage) {
        this.promotionPercentage = promotionPercentage;
    }
    private ArrayList<AdvertisementEntity> requestersForPromotion = new ArrayList<AdvertisementEntity>();

    public ArrayList<AdvertisementEntity> getRequestersForPromotion() {
        return requestersForPromotion;
    }

    public void setRequestersForPromotion(ArrayList<AdvertisementEntity> requestersForPromotion) {
        this.requestersForPromotion = requestersForPromotion;
    }

    public float getExamPercentage() {
        return examPercentage;
    }

    public void setExamPercentage(float examPercentage) {
        this.examPercentage = examPercentage;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public float getInterviewPercentage() {
        return interviewPercentage;
    }

    public void setInterviewPercentage(float interviewPercentage) {
        this.interviewPercentage = interviewPercentage;
    }

    public float getOtherPercentage() {
        return otherPercentage;
    }

    public void setOtherPercentage(float otherPercentage) {
        this.otherPercentage = otherPercentage;
    }

    public float getPresentationPercentage() {
        return presentationPercentage;
    }

    public void setPresentationPercentage(float presentationPercentage) {
        this.presentationPercentage = presentationPercentage;
    }

    public float getWrittenPercentage() {
        return writtenPercentage;
    }

    public void setWrittenPercentage(float writtenPercentage) {
        this.writtenPercentage = writtenPercentage;
    }

    public float getPerformanceValue() {
        return performanceValue;
    }

    public void setPerformanceValue(float performanceValue) {
        this.performanceValue = performanceValue;
    }

    public float getEmployeeDisciplineResult() {
        return employeeDisciplineResult;
    }

    public void setEmployeeDisciplineResult(float employeeDisciplineResult) {
        this.employeeDisciplineResult = employeeDisciplineResult;
    }

    public float getToalExamResult() {
        return toalExamResult;
    }

    public void setToalExamResult(float toalExamResult) {
        this.toalExamResult = toalExamResult;
    }

    public float getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(float interviewResult) {
        this.interviewResult = interviewResult;
    }

    public float getOther() {
        return other;
    }

    public void setOther(float other) {
        this.other = other;
    }

    public float getPresentationResult() {
        return presentationResult;
    }

    public void setPresentationResult(float presentationResult) {
        this.presentationResult = presentationResult;
    }

    public float getWrittenResult() {
        return writtenResult;
    }

    public void setWrittenResult(float writtenResult) {
        this.writtenResult = writtenResult;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getPromotionRequestId() {
        return promotionRequestId;
    }

    public void setPromotionRequestId(String promotionRequestId) {
        this.promotionRequestId = promotionRequestId;
    }

    public boolean isSelectPromotionRequester() {
        return selectPromotionRequester;
    }

    public void setSelectPromotionRequester(boolean selectPromotionRequester) {
        this.selectPromotionRequester = selectPromotionRequester;
    }

    public String getAdvertismentType() {
        return advertismentType;
    }

    public void setAdvertismentType(String advertismentType) {
        this.advertismentType = advertismentType;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public float getPercentTotal() {
        return percentTotal;
    }

    public void setPercentTotal(float percentTotal) {
        this.percentTotal = percentTotal;
    }

    public double getPercenteducLevel() {
        return percenteducLevel;
    }

    public void setPercenteducLevel(double percenteducLevel) {
        this.percenteducLevel = percenteducLevel;
    }

    public double getPercentExperience() {
        return percentExperience;
    }

    public void setPercentExperience(double percentExperience) {
        this.percentExperience = percentExperience;
    }

    public double getPercentPerformance() {
        return percentPerformance;
    }

    public void setPercentPerformance(double percentPerformance) {
        this.percentPerformance = percentPerformance;
    }

    public double getPercentTraining() {
        return percentTraining;
    }

    public void setPercentTraining(double percentTraining) {
        this.percentTraining = percentTraining;
    }

    public String getEducTypeDesc() {
        return educTypeDesc;
    }

    public void setEducTypeDesc(String educTypeDesc) {
        this.educTypeDesc = educTypeDesc;
    }

    public String getEducLevelDesc() {
        return educLevelDesc;
    }

    public void setEducLevelDesc(String educLevelDesc) {
        this.educLevelDesc = educLevelDesc;
    }

    public String getRecRequestID() {
        return recRequestID;
    }

    public void setRecRequestID(String recRequestID) {
        this.recRequestID = recRequestID;
    }

    public String getAdvertID() {
        return advertID;
    }

    public void setAdvertID(String advertID) {
        this.advertID = advertID;
    }

    public boolean isRequestPromotion() {
        return requestPromotion;
    }

    public void setRequestPromotion(boolean requestPromotion) {
        this.requestPromotion = requestPromotion;
    }

    public String getMediaCode() {
        return mediaCode;
    }

    public void setMediaCode(String mediaCode) {
        this.mediaCode = mediaCode;
    }

    public String getRealMediaCode() {
        return realMediaCode;
    }

    public void setRealMediaCode(String realMediaCode) {
        this.realMediaCode = realMediaCode;
    }

    public String getAdvertType() {
        return advertType;
    }

    public void setAdvertType(String advertType) {
        this.advertType = advertType;
    }

    public String getRecruitmentType() {
        return recruitmentType;
    }

    public void setRecruitmentType(String recruitmentType) {
        this.recruitmentType = recruitmentType;
    }

    public String getRequiredNo() {
        return requiredNo;
    }

    public void setRequiredNo(String requiredNo) {
        this.requiredNo = requiredNo;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public RecruitmentEntity getRecruitmentEntity() {
        return recruitmentEntity;
    }

    public void setRecruitmentEntity(RecruitmentEntity recruitmentEntity) {
        this.recruitmentEntity = recruitmentEntity;
    }

    public AdvertisementEntity getAdvertisementEntity() {
        return advertisementEntity;
    }

    public void setAdvertisementEntity(AdvertisementEntity advertisementEntity) {
        this.advertisementEntity = advertisementEntity;
    }

    public AdvertisementManager() {
    }

    public AdvertisementManager(int numberofrequest,
            String job_description,
            String jobType,
            String employeeName,
            String recruitRequestId,
            String batchCode,
            String preparedBy,
            String preparedDate,
            String advrtId,
            String recruitment_Type,
            String advertisementDateTo,
            String advertisementDateFrom,
            String advertismentType,
            String no_employees,
            boolean jobAdvertisment) {
        this.numberofrequest = numberofrequest;
        this.advertisementDateFrom = advertisementDateFrom;
        this.jobType = jobType;
        this.preparedDate = preparedDate;
        this.advertisementDateTo = advertisementDateTo;
        this.preparedBy = preparedBy;
        this.batchCode = batchCode;
        this.job_description = job_description;
        this.employeeName = employeeName;
        this.recruitRequestId = recruitRequestId;
        this.advrtId = advrtId;
        this.jobAdvertisment = jobAdvertisment;
        this.advertismentType = advertismentType;
        this.recruitment_Type = recruitment_Type;
        this.num_Of_Emps = no_employees;

    }

    public AdvertisementManager(String advertisementDateFrom, String advertisementDateTo, String recruitmentBatchCode, String jobType) {
        this.advertisementDateFrom = advertisementDateFrom;
        this.advertisementDateTo = advertisementDateTo;
        this.recruitmentBatchCode = recruitmentBatchCode;
        this.jobType = jobType;
    }

    public AdvertisementManager(String advertisementDateFrom, String advertisementDateTo, String recruitmentBatchCode, String jobType,
            String requestID, String recruitmentType, String requiredNum, String experience, String advertID, String qualification,
            String educLevel, String jobCode, int x, int y, String rank) {
        this.advertisementDateFrom = advertisementDateFrom;
        this.advertisementDateTo = advertisementDateTo;
        this.recruitmentBatchCode = recruitmentBatchCode;
        this.jobType = jobType;
        this.recRequestID = requestID;
        this.recruitmentType = recruitmentType;
        this.requiredNo = requiredNum;
        this.experience = experience;
        this.advertID = advertID;
        this.qualification = qualification;
        this.educLevel = educLevel;
        this.jobCode = jobCode;
    }

    public AdvertisementManager(String preparedDate, String advertisementDateFrom, String advertisementDateTo, String preparedBy, String status, String recruitmentBatchCode) {
        this.preparedDate = preparedDate;
        this.advertisementDateFrom = advertisementDateFrom;
        this.advertisementDateTo = advertisementDateTo;
        this.preparedBy = preparedBy;
        this.status = status;
        this.recruitmentBatchCode = recruitmentBatchCode;
    }

    /**
     *
     * @param approvedBY
     * @param batchCode
     * @param job_description
     * @param recruit_Request_Date
     * @param employeeName
     * @param recruitment_Type
     * @param num_Of_Emps
     * @param approved_Date
     * @param departmentID
     * @param directorate
     * @param division
     * @param mastebabriya
     * @param team
     * @param recruitRequestId
     * @param recruitRequestDate
     * @param requesterName
     * @param requesterID
     * @param numberofrequest
     */
    public AdvertisementManager(String approvedBY, String batchCode, String job_description,
            String recruit_Request_Date, String employeeName, String recruitment_Type, String num_Of_Emps,
            String approved_Date, String departmentID, String directorate, String division,
            String mastebabriya, String team, String recruitRequestId, String recruitRequestDate,
            String requesterName, String requesterID, int numberofrequest, boolean jobAdvertisment, String insideORoutSide) {
        this.approvedBY = approvedBY;
        this.batchCode = batchCode;
        this.job_description = job_description;
        this.recruit_Request_Date = recruit_Request_Date;
        this.employeeName = employeeName;
        this.recruitment_Type = recruitment_Type;
        this.num_Of_Emps = num_Of_Emps;
        this.approved_Date = approved_Date;
        this.departmentID = departmentID;
        this.directorate = directorate;
        this.division = division;
        this.mastebabriya = mastebabriya;
        this.team = team;
        this.recruitRequestId = recruitRequestId;
        this.recruitRequestDate = recruitRequestDate;
        this.requesterName = requesterName;
        this.requesterID = requesterID;
        this.numberofrequest = numberofrequest;
        this.advertismentType = insideORoutSide;

        this.jobAdvertisment = jobAdvertisment;
    }
    private RecruitmentEntity recruitmentEntity = new RecruitmentEntity();
    private AdvertisementEntity advertisementEntity = new AdvertisementEntity();
    String jobType;
    String preparedDate;
    String advertisementDateFrom;
    String advertisementDateTo;
    String preparedBy;
    String status;
    String recruitmentBatchCode;
    String occuranceDesc;
    String mediaTypeDesc;
    String occurrence;
    String mediaType;
    Option[] number;
    Option[] mediaTypeOpt;
    String approvedBY;
    String batchCode;
    String job_description;
    String recruit_Request_Date;
    String employeeName;
    String recruitment_Type;
    String num_Of_Emps;
    String approved_Date;
    String departmentID;
    String directorate;
    String division;
    String mastebabriya;
    String team;
    String recruitRequestId;
    String recruitRequestDate;
    String requesterName;
    String requesterID;
    int numberofrequest;
    boolean selectedMedi;
    String advrtId;
    int mediaID;
    boolean jobAdvertisment;

    public String isInsideORoutSide() {
        return advertismentType;
    }

    public void setInsideORoutSide(String insideORoutSide) {
        this.advertismentType = insideORoutSide;
    }

    public boolean isJobAdvertisment() {
        return jobAdvertisment;
    }

    public void setJobAdvertisment(boolean jobAdvertisment) {
        this.jobAdvertisment = jobAdvertisment;
    }

    public int getMediaID() {
        return mediaID;
    }

    public void setMediaID(int mediaID) {
        this.mediaID = mediaID;
    }

    public String getAdvrtId() {
        return advrtId;
    }

    public void setAdvrtId(String advrtId) {
        this.advrtId = advrtId;
    }

    public boolean isSelectedMedi() {
        return selectedMedi;
    }

    public void setSelectedMedi(boolean selectedMedi) {
        this.selectedMedi = selectedMedi;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getApprovedBY() {
        return approvedBY;
    }

    public void setApprovedBY(String approvedBY) {
        this.approvedBY = approvedBY;
    }

    public String getApproved_Date() {
        return approved_Date;
    }

    public void setApproved_Date(String approved_Date) {
        this.approved_Date = approved_Date;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDirectorate() {
        return directorate;
    }

    public void setDirectorate(String directorate) {
        this.directorate = directorate;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getMastebabriya() {
        return mastebabriya;
    }

    public void setMastebabriya(String mastebabriya) {
        this.mastebabriya = mastebabriya;
    }

    public String getNum_Of_Emps() {
        return num_Of_Emps;
    }

    public void setNum_Of_Emps(String num_Of_Emps) {
        this.num_Of_Emps = num_Of_Emps;
    }

    public int getNumberofrequest() {
        return numberofrequest;
    }

    public void setNumberofrequest(int numberofrequest) {
        this.numberofrequest = numberofrequest;
    }

    public String getRecruitRequestDate() {
        return recruitRequestDate;
    }

    public void setRecruitRequestDate(String recruitRequestDate) {
        this.recruitRequestDate = recruitRequestDate;
    }

    public String getRecruitRequestId() {
        return recruitRequestId;
    }

    public void setRecruitRequestId(String recruitRequestId) {
        this.recruitRequestId = recruitRequestId;
    }

    public String getRecruit_Request_Date() {
        return recruit_Request_Date;
    }

    public void setRecruit_Request_Date(String recruit_Request_Date) {
        this.recruit_Request_Date = recruit_Request_Date;
    }

    public String getRecruitment_Type() {
        return recruitment_Type;
    }

    public void setRecruitment_Type(String recruitment_Type) {
        this.recruitment_Type = recruitment_Type;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public int addAdvertisementInfo(AdvertisementManager saveAdvertisement) {
        AdvertisementEntity saveAdvertisment = new AdvertisementEntity(saveAdvertisement.getAdvertisementDateFrom(), saveAdvertisement.getPreparedDate(),
                saveAdvertisement.getAdvertisementDateTo(), saveAdvertisement.getPreparedBy(), saveAdvertisement.getStatus(), saveAdvertisement.getRecruitmentBatchCode());

        return 0;//advertisementEntity.insertAdvertisementInfo(saveAdvertisment);
    }

    public AdvertisementManager(String occurrence, String mediaType, String occuranceDesc, String mediaTypeDesc, int mediaID, String mediaName) {
        this.occurrence = occurrence;
        this.mediaType = mediaType;
        this.mediaTypeDesc = mediaTypeDesc;
        this.occuranceDesc = occuranceDesc;
        this.mediaID = mediaID;
        this.mediaName = mediaName;
    }

    private int compareTwoYears(String year) {
        String currDate = StringDateManipulation.toDayInEc();
        int dateDiffrence = StringDateManipulation.calculateYearDifferenceBetweenTwoDates(year, currDate);

        return dateDiffrence;
    }

    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

    public AdvertisementManager(
            String empID,
            String fullName,
            String educLevel,
            String jobDescription,
            String experience,
            String advertID,
            String status,
            float interviewResult,
            float writtenResult,
            float presentationResult,
            float other,
            float interviewPercentage,
            float writtenPercentage,
            float presentationPercentage,
            float otherPercentage,
            String promotionRequestId,
            float employeeDisciplineResult,
            float performanceValue,
            float examPercentage,
            float disciplinePercentage,
            float promotionPercentage,
            boolean checkPercentageAvilebel,
            int relatExp, String rank_id) {
        float totalRequesterExamResult = 0.0f;
        int exp = GregorianCalendarManipulation.calaculateYearDifference(experience);
        DecimalFormat dec = new DecimalFormat("###.##");
        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.hire_date = experience;
        this.jobDescription = jobDescription;
        this.educLevel = educLevel;
        this.advertID = advertID;
        this.status = status;
        this.promotionRequestId = promotionRequestId;
        this.employeeDisciplineResult = employeeDisciplineResult;
        this.performanceValue = performanceValue;
        this.interviewPercentage = interviewPercentage;
        this.writtenPercentage = writtenPercentage;
        this.presentationPercentage = presentationPercentage;
        this.otherPercentage = otherPercentage;
        this.examPercentage = examPercentage;
        this.promotionPercentage = promotionPercentage;
        this.disciplinePercentage = disciplinePercentage;

        if (getPromotionPercentage() > 0) {
            this.promotionPercentageValue = ((this.getPerformanceValue() * getPromotionPercentage()) / 100);

            this.disciplinePercentageValue = ((this.getEmployeeDisciplineResult() * this.getDisciplinePercentage()) / 100);
        } else {
            this.promotionPercentageValue = this.getPerformanceValue();
            this.disciplinePercentageValue = this.getEmployeeDisciplineResult();
        }

        if (Integer.parseInt(rank_id) <= 12) {
            
            this.relatExp = relatExp * 15 / 100;
        } else if (Integer.parseInt(rank_id) > 12) {
            
            this.relatExp = relatExp * 15 / 100;
        }
        if (Integer.parseInt(rank_id) <= 7) {
            
            int x = exp * 10 / 100;
            this.experience = String.valueOf(x);
        } else if (Integer.parseInt(rank_id) > 7) {
            
            int x = exp * 5 / 100;
            this.experience = String.valueOf(x);
        }
        if (Integer.parseInt(rank_id) <= 7) {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;
            this.presentationResult = presentationResult;
            this.other = other;
            this.toalExamResult = (interviewResult + writtenResult + presentationResult + other) * 25 / 100;
        } else if (Integer.parseInt(rank_id) > 12) {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;
            this.presentationResult = presentationResult;
            this.other = other;
            this.toalExamResult = (interviewResult + writtenResult + presentationResult + other) * 20 / 100;
        }

        promotionPercentageValue = other;
        this.percentTotal = toalExamResult + other + disciplinePercentageValue + educLevelId + this.relatExp + Integer.parseInt(this.experience);



//        this.percentTotal = this.toalExamResult + this.relatExp + Integer.parseInt(this.experience) + this.getDisciplinePercentageValue();
//            this.percentTotal = this.getDisciplinePercentageValue() + getToalExamResult() + getPromotionPercentageValue();//   disciplinePercentageValue +
//            dec.format(getPercentTotal());



    }

    public AdvertisementManager(
            int educLevelId,
            String empID,
            String fullName,
            String educLevel,
            String jobDescription,
            String experience,
            String advertID,
            String status,
            float interviewResult,
            float writtenResult,
            float presentationResult,
            float other,
            float interviewPercentage,
            float writtenPercentage,
            float presentationPercentage,
            float otherPercentage,
            String promotionRequestId,
            float employeeDisciplineResult,
            float performanceValue,
            float examPercentage,
            float disciplinePercentage,
            float promotionPercentage) {

        float totalRequesterExamResult = 0.0f;
        int exp = GregorianCalendarManipulation.calaculateYearDifference(experience);
        DecimalFormat dec = new DecimalFormat("###.##");
        this.educLevelId = educLevelId;
        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.hire_date = experience;
        this.jobDescription = jobDescription;
        this.educLevel = educLevel;
        this.advertID = advertID;
        this.status = status;
        this.promotionRequestId = promotionRequestId;
        this.employeeDisciplineResult = employeeDisciplineResult;
        this.performanceValue = performanceValue;
        this.interviewPercentage = interviewPercentage;
        this.writtenPercentage = writtenPercentage;
        this.presentationPercentage = presentationPercentage;
        this.otherPercentage = otherPercentage;
        this.examPercentage = examPercentage;
        this.promotionPercentage = promotionPercentage;
        this.disciplinePercentage = disciplinePercentage;

        if (getPromotionPercentage() > 0) {
            this.promotionPercentageValue = ((this.getPerformanceValue() * getPromotionPercentage()) / 100);

            this.disciplinePercentageValue = ((this.getEmployeeDisciplineResult() * this.getDisciplinePercentage()) / 100);
        } else {
            this.promotionPercentageValue = this.getPerformanceValue();
            this.disciplinePercentageValue = this.getEmployeeDisciplineResult();
        }


        if (true) {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;//(writtenResult * writtenPercentage) / 100;
            this.presentationResult = presentationResult;// (presentationResult * presentationPercentage) / 100;
            this.other = other;//(other * otherPercentage) / 100;
            totalRequesterExamResult = ((getInterviewResult() * interviewPercentage) / 100) +
                    ((getWrittenResult() * writtenPercentage) / 100) +
                    ((getPresentationResult() * presentationPercentage) / 100) +
                    ((getOther() * otherPercentage) / 100);
            if (examPercentage != 0) {
                this.toalExamResult = ((totalRequesterExamResult * examPercentage) / 100);
            } else {
                this.toalExamResult = totalRequesterExamResult;
            }
            this.percentTotal = this.getDisciplinePercentageValue() + getToalExamResult() + getPromotionPercentageValue();
        //this.percentTotal = getToalExamResult() + getPerformanceValue() + getEmployeeDisciplineResult();
        //  this.percentTotal = GlobalUseFunction.Round(getPercentTotal(), 2);
        } else {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;
            this.presentationResult = presentationResult;
            this.other = other;
            this.toalExamResult = interviewResult + writtenResult + presentationResult + other;
            if (examPercentage != 0) {
                this.toalExamResult = ((toalExamResult * examPercentage) / 100);

            }
//            this.percentTotal = getToalExamResult() + getPerformanceValue() + getEmployeeDisciplineResult();
            promotionPercentageValue = performanceValue;
            this.percentTotal = this.getDisciplinePercentageValue() + getToalExamResult() + getPromotionPercentageValue() + performanceValue;//   disciplinePercentageValue +
            dec.format(getPercentTotal());
        }

    }

    public AdvertisementManager(
            int educLevelId,
            String empID,
            String relatExp,
            String fullName,
            String educLevel,
            String jobDescription,
            String experience,
            String advertID,
            String status,
            float interviewResult,
            float writtenResult,
            float presentationResult,
            float other,
            float interviewPercentage,
            float writtenPercentage,
            float presentationPercentage,
            float otherPercentage,
            String promotionRequestId,
            float employeeDisciplineResult,
            float performanceValue,
            float examPercentage,
            float disciplinePercentage,
            float promotionPercentage,
            boolean checkPercentageAvilebel) {
//slect
        float totalRequesterExamResult = 0.0f;
        int exp = GregorianCalendarManipulation.calaculateYearDifference(experience);
        DecimalFormat dec = new DecimalFormat("###.##");
        this.educLevelId = educLevelId;
        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.hire_date = experience;
        this.jobDescription = jobDescription;
        this.educLevel = educLevel;
        this.advertID = advertID;
        this.status = status;
        this.promotionRequestId = promotionRequestId;
        this.employeeDisciplineResult = employeeDisciplineResult;
        this.performanceValue = performanceValue;
        this.interviewPercentage = interviewPercentage;
        this.writtenPercentage = writtenPercentage;
        this.presentationPercentage = presentationPercentage;
        this.otherPercentage = otherPercentage;
        this.examPercentage = examPercentage;
        this.promotionPercentage = promotionPercentage;
        this.disciplinePercentage = disciplinePercentage;
        this.relatExp = Integer.parseInt(relatExp);
        this.departmentID = status;
        

        if (getPromotionPercentage() > 0) {
            this.promotionPercentageValue = ((this.getPerformanceValue() * getPromotionPercentage()) / 100);
            
            this.disciplinePercentageValue = ((this.getEmployeeDisciplineResult() * this.getDisciplinePercentage()) / 100);
        } else {
            this.promotionPercentageValue = this.getPerformanceValue();
            this.disciplinePercentageValue = this.getEmployeeDisciplineResult();
        }
        if (checkPercentageAvilebel) {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;//(writtenResult * writtenPercentage) / 100;
            this.presentationResult = presentationResult;// (presentationResult * presentationPercentage) / 100;
            this.other = other;//(other * otherPercentage) / 100;
            totalRequesterExamResult = ((getInterviewResult() * interviewPercentage) / 100) +
                    ((getWrittenResult() * writtenPercentage) / 100) +
                    ((getPresentationResult() * presentationPercentage) / 100);
            if (examPercentage != 0) {
                this.toalExamResult = ((totalRequesterExamResult * examPercentage) / 100);
            } else {
                this.toalExamResult = totalRequesterExamResult;
            }
            this.percentTotal = this.getDisciplinePercentageValue() + getToalExamResult() + getPromotionPercentageValue();
        } else {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;
            this.presentationResult = presentationResult;
            this.other = other;
            this.toalExamResult = interviewResult + writtenResult + presentationResult + other;
            if (examPercentage != 0) {
                this.toalExamResult = ((toalExamResult * examPercentage) / 100);

            }
//
//            if (rank <= 12) {
//                this.relatExp = exp * 15 / 100;
//            } else if (rank > 12) {
//                this.relatExp = Integer.parseInt(relatExp) * 15 / 100;
//            }
//            if (rank <= 7) {
//                int x = exp * 10 / 100;
//                this.experience = String.valueOf(x);
//            } else if (rank > 7) {
//                int x = exp * 5 / 100;
//                this.experience = String.valueOf(x);
//            }
            if (rank <= 7) {
                this.interviewResult = interviewResult;
                this.writtenResult = writtenResult;
                this.presentationResult = presentationResult;
                this.other = other;
                this.toalExamResult = ((interviewResult + writtenResult + presentationResult) / 3);
               //  this.toalExamResult = ((interviewResult + writtenResult + presentationResult) / 3) * 25 / 100;
            } else if (rank > 12) {
                this.interviewResult = interviewResult;
                this.writtenResult = writtenResult;
                this.presentationResult = presentationResult;
                this.other = other;
                this.toalExamResult = ((interviewResult + writtenResult + presentationResult) / 3);
               //  this.toalExamResult = ((interviewResult + writtenResult + presentationResult) / 3) * 20 / 100;
            }
            promotionPercentageValue = other;
            this.percentTotal = toalExamResult + other + disciplinePercentageValue + educLevelId + this.relatExp + Integer.parseInt(this.experience);
//            this.percentTotal = this.getDisciplinePercentageValue() + getToalExamResult() + getPromotionPercentageValue();//   disciplinePercentageValue +

        }

    }

    public AdvertisementManager(
            int educLevelId,
            String empID,
            String relatExp,
            String fullName,
            String educLevel,
            String jobDescription,
            String experience,
            String advertID,
            String depId,
            float interviewResult,
            float writtenResult,
            float presentationResult,
            float other,
            String promotionRequestId,
            float employeeDisciplineResult,
            float performanceValue) {

        int exp = GregorianCalendarManipulation.calaculateYearDifference(experience);
        DecimalFormat dec = new DecimalFormat("###.##");
        this.educLevelId = educLevelId;
        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.hire_date = experience;
        this.jobDescription = jobDescription;
        this.educLevel = educLevel;
        this.advertID = advertID;
        this.promotionRequestId = promotionRequestId;
        this.employeeDisciplineResult = employeeDisciplineResult;
        this.performanceValue = performanceValue;
        this.relatExp = Integer.parseInt(relatExp);
        this.departmentID = depId;

        if (rank <= 7) {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;
            this.presentationResult = presentationResult;
            this.other = other;
            this.toalExamResult = ((interviewResult + writtenResult + presentationResult) / 3) * 25 / 100;
        } else if (rank > 12) {
            this.interviewResult = interviewResult;
            this.writtenResult = writtenResult;
            this.presentationResult = presentationResult;
            this.other = other;
            this.toalExamResult = ((interviewResult + writtenResult + presentationResult) / 3) * 20 / 100;
        }
        this.promotionPercentageValue = other;
        this.percentTotal = toalExamResult + other + disciplinePercentageValue + educLevelId + this.relatExp + Integer.parseInt(this.experience);


    }

    public AdvertisementManager(String empID, String fullName, String educLevel, String qualification,
            String experience, String educLevelDesc, String educTypeDesc, int x, int y) {
        int exp = this.compareTwoYears(experience);
        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.qualification = qualification;
        this.educLevel = educLevel;
        this.educLevelDesc = educLevelDesc;
        this.educTypeDesc = educTypeDesc;
        if (y > 0) {
            this.percentExperience = (((exp) * 100) / y);
            this.percentTotal = (float) this.percentExperience;
        } else {
            this.percentExperience = 0.0;
        }

    }

    public AdvertisementManager(
            int relatExp,
            String advertID,
            String empID,
            String fullName,
            String jobDescription,
            float examPercentage,
            float disciplinePercentage,
            float promotionPercentage,
            String experience,
            float interviewResult,
            float other,
            float writtenResult,
            float toalExamResult,
            float disciplinePercentageValue,
            float promotionPercentageValue,
            float percentTotal,
            String promotionRequestID) {
        int exp = GregorianCalendarManipulation.calaculateYearDifference(experience);
        this.experience = String.valueOf(exp);
        this.empID = empID;
        this.fullName = fullName;
        this.disciplinePercentage = disciplinePercentage;
        this.examPercentage = examPercentage;
        this.promotionPercentage = promotionPercentage;
        this.interviewResult = interviewResult;
        this.other = other;
        this.writtenResult = writtenResult;
        this.promotionPercentageValue = promotionPercentageValue;
        this.toalExamResult = toalExamResult;
        this.disciplinePercentageValue = disciplinePercentageValue;
        this.percentTotal = percentTotal;
        this.advertID = advertID;
        this.jobDescription = jobDescription;
        this.promotionRequestId = promotionRequestID;


    }

    public AdvertisementManager(
            int educLevelId, String relatExp,
            String advertID,
            String empID,
            String fullName,
            String jobDescription,
            float examPercentage,
            float disciplinePercentage,
            float promotionPercentage,
            String experience,
            float interviewResult,
            float other,
            float writtenResult,
            float toalExamResult,
            float disciplinePercentageValue,
            float promotionPercentageValue,
            float percentTotal,
            String promotionRequestID) {
        this.educLevelId = educLevelId;
        int exp = GregorianCalendarManipulation.calaculateYearDifference(experience);
        this.experience = String.valueOf(exp);
        this.empID = empID;
        this.fullName = fullName;
        this.disciplinePercentage = disciplinePercentage;
        this.examPercentage = examPercentage;
        this.promotionPercentage = promotionPercentage;
        this.interviewResult = interviewResult;
        this.other = other;
        this.writtenResult = writtenResult;
        this.promotionPercentageValue = promotionPercentageValue;
        this.toalExamResult = toalExamResult;
        this.disciplinePercentageValue = disciplinePercentageValue;
        this.percentTotal = percentTotal;
        this.advertID = advertID;
        this.relatExp = Integer.parseInt(relatExp);
        this.jobDescription = jobDescription;
        this.promotionRequestId = promotionRequestID;


    }

    public AdvertisementManager(
            String advertID,
            String empID,
            String fullName,
            String jobDescription,
            float examPercentage,
            float disciplinePercentage,
            float promotionPercentage,
            String experience,
            float interviewResult,
            float other,
            float writtenResult,
            float toalExamResult,
            float disciplinePercentageValue,
            float promotionPercentageValue,
            float percentTotal,
            String departmentId,
            String recruitRequestId) {
//kb
        int exp = GregorianCalendarManipulation.calaculateYearDifference(experience);
        this.experience = String.valueOf(exp);
        this.empID = empID;
        this.fullName = fullName;
        this.disciplinePercentage = disciplinePercentage;
        this.examPercentage = examPercentage;
        this.promotionPercentage = promotionPercentage;
        this.interviewResult = interviewResult;
        this.other = other;
        this.writtenResult = writtenResult;
        this.promotionPercentageValue = promotionPercentageValue;
        this.toalExamResult = toalExamResult;
        this.disciplinePercentageValue = disciplinePercentageValue;
        this.percentTotal = percentTotal;
        this.advertID = advertID;
        this.jobDescription = jobDescription;
        this.departmentID = departmentId;
        this.recruitRequestId = recruitRequestId;


    }

    public AdvertisementManager(String empID, String fullName, String educLevel, String qualification,
            String experience, String educLevelDesc, String educTypeDesc, double x, double y, double z, String result) {
        int exp = this.compareTwoYears(experience);
        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.qualification = qualification;
        this.educLevel = educLevel;
        this.educLevelDesc = educLevelDesc;
        this.educTypeDesc = educTypeDesc;
        this.percentPerformance = roundTwoDecimals((z * 100) / x);
        this.percentTotal = (float) this.percentPerformance;
    }

    public AdvertisementManager(String empID, String fullName, String educLevel, String qualification,
            String experience, String educLevelDesc, String educTypeDesc, int x, int y, int z, double percent1, double percent2) {
        int exp = this.compareTwoYears(experience);

        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.qualification = qualification;
        this.educLevel = educLevel;
        this.educLevelDesc = educLevelDesc;
        this.educTypeDesc = educTypeDesc;

        this.percenteducLevel = roundTwoDecimals((x * percent2) / y);
        this.percentExperience = roundTwoDecimals(((exp) * percent1) / z);
        this.percentTotal = (float) (this.percenteducLevel + this.percentExperience);

    }

    public AdvertisementManager(String empID, String fullName, String educLevel, String qualification,
            String experience, String educLevelDesc, String educTypeDesc, double x, double y, double z,
            String result, double percent1, double percent2, int identify) {
        int exp = this.compareTwoYears(experience);

        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.qualification = qualification;
        this.educLevel = educLevel;
        this.educLevelDesc = educLevelDesc;
        this.educTypeDesc = educTypeDesc;

        if (identify == 0) {
            this.percentPerformance = roundTwoDecimals((z * percent2) / x);
            this.percenteducLevel = roundTwoDecimals((Integer.valueOf(result) * percent1) / y);
            this.percentTotal = (float) roundTwoDecimals(this.percentPerformance + this.percenteducLevel);
        } else if (identify == 1) {
            this.percentPerformance = roundTwoDecimals((z * percent2) / x);
            this.percentExperience = roundTwoDecimals(((exp) * percent1) / y);
            this.percentTotal = (float) roundTwoDecimals(this.percentExperience + percentPerformance);
        }

    }

    public AdvertisementManager(String empID, String fullName, String educLevel, String qualification,
            String experience, String educLevelDesc, String educTypeDesc,
            double x, double y, double z, String result, int tResult,
            double percent1, double percent2, double percent3, int identify) {
        int exp = this.compareTwoYears(experience);

        this.empID = empID;
        this.fullName = fullName;
        this.experience = String.valueOf(exp);
        this.qualification = qualification;
        this.educLevel = educLevel;
        this.educLevelDesc = educLevelDesc;
        this.educTypeDesc = educTypeDesc;

        if (identify == 0) {
            this.percentExperience = roundTwoDecimals(((exp) * percent1) / y);
            this.percentPerformance = roundTwoDecimals((z * percent3) / x);
            this.percenteducLevel = roundTwoDecimals((Integer.valueOf(result) * percent2) / tResult);
            this.percentTotal = (float) roundTwoDecimals(this.percentPerformance + this.percenteducLevel + this.percentExperience);
        } else if (identify == 1) {
        }


    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    static String searchCode;

    public static String getSearchCode() {
        return searchCode;
    }

    public static void setSearchCode(String searchCode) {
        AdvertisementManager.searchCode = searchCode;
    }

    public String getAdvertisementDateFrom() {
        return advertisementDateFrom;
    }

    public void setAdvertisementDateFrom(String advertisementDateFrom) {
        this.advertisementDateFrom = advertisementDateFrom;
    }

    public String getAdvertisementDateTo() {
        return advertisementDateTo;
    }

    public void setAdvertisementDateTo(String advertisementDateTo) {
        this.advertisementDateTo = advertisementDateTo;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(String preparedDate) {
        this.preparedDate = preparedDate;
    }

    public String getRecruitmentBatchCode() {
        return recruitmentBatchCode;
    }

    public void setRecruitmentBatchCode(String recruitmentBatchCode) {
        this.recruitmentBatchCode = recruitmentBatchCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMediaTypeDesc() {
        return mediaTypeDesc;
    }

    public void setMediaTypeDesc(String mediaTypeDesc) {
        this.mediaTypeDesc = mediaTypeDesc;
    }

    public String getOccuranceDesc() {
        return occuranceDesc;
    }

    public void setOccuranceDesc(String occuranceDesc) {
        this.occuranceDesc = occuranceDesc;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
    }

    public Option[] getMediaTypeOpt() {
        return mediaTypeOpt;
    }

    public void setMediaTypeOpt(Option[] mediaTypeOpt) {
        this.mediaTypeOpt = mediaTypeOpt;
    }

    public int addMediaType(AdvertisementManager mediaTypeObj) {
        AdvertisementEntity saveMedia = new AdvertisementEntity(mediaTypeObj.getOccurrence(), mediaTypeObj.getMediaType());
        return 0;//advertisementEntity.insertMediaType(saveMedia);
    }

//    public Option[] getAdvertismentType() {
//        advertismentType = new Option[3];
//        Option first = new Option("0", "Selcet Advertisment Type");
//        Option second = new Option("Inside", "Inside");
//        Option third = new Option("Outside", "Outside");
//        advertismentType[0] = first;
//        advertismentType[1] = second;
//        advertismentType[2] = third;
//        return advertismentType;
//    }
    public int updateMediaType(AdvertisementManager mediaTypeObj) {
        AdvertisementEntity updateMedia = new AdvertisementEntity(mediaTypeObj.getOccurrence(), mediaTypeObj.getMediaType(), mediaTypeObj.getAdvrtId());
        return getAdvertisementEntity().updateMediaType(updateMedia);
    }

    public int updateAdvertisementInfo(AdvertisementManager updateAdvertisement) {//getAdvertisementID

        AdvertisementEntity updateAdvertisment = new AdvertisementEntity(updateAdvertisement.getOccurrence(), updateAdvertisement.getMediaType(), Integer.toString(updateAdvertisement.getMediaID()));

        return getAdvertisementEntity().updateMediaType(updateAdvertisment);
    }

    public Option[] getNumber() {
        number = new Option[31];
        Option first = new Option("Occurrence", "Selcet Occurrence Day");
        number[0] = first;
        for (int i = 1; i <
                31; i++) {
            Option num = new Option(i, i + "    Day");
            number[i] = num;
        }

        return number;
    }

    public void setNumber(Option[] number) {
        this.number = number;
    }

    public Option[] mediaType() {

        ArrayList<AdvertisementEntity> arrayListMediaTypeObj = getAdvertisementEntity().readMeadiaType();
        mediaTypeOpt =
                new Option[arrayListMediaTypeObj.size() + 1];
        mediaTypeOpt[0] = new Option("Select Media Type");
        for (int i = 0; i <
                arrayListMediaTypeObj.size(); i++) {
            setAdvertisementEntity(arrayListMediaTypeObj.get(i));
            Option optMediaTypeValues = new Option(String.valueOf(getAdvertisementEntity().getMediaType()), getAdvertisementEntity().getDescrption());
            mediaTypeOpt[i + 1] = optMediaTypeValues;
        }

        return mediaTypeOpt;
    }

    public ArrayList<String> lodeRecruitment() {
        return getAdvertisementEntity().reedRecruitment(this.getSearchCode());

    }

    public ArrayList<String> readRequesterName(String name) {
        return getAdvertisementEntity().readRequesterName(name);
    }

    public ArrayList<String> readApprovedBy(String empId) {
        return getAdvertisementEntity().readRequesterName(empId);
    }

    public ArrayList<String> readAdvertisementInfo(String name) {
        return getAdvertisementEntity().readAdvertisementInfo(name);
    }

    public Option[] recruitmentBatchCodeApp() {
        Option recruitmentBatchCodeSearchOpt[] = null;
        ArrayList<AdvertisementEntity> arrayListBatchSearchObj = getAdvertisementEntity().newRequitmentAppovedBatchCode();
        recruitmentBatchCodeSearchOpt = new Option[arrayListBatchSearchObj.size() + 1];
        Option optrecBatchCodeSearchValue = new Option(null, "Select Job Type");
        recruitmentBatchCodeSearchOpt[0] = optrecBatchCodeSearchValue;
        for (int i = 0; i < arrayListBatchSearchObj.size(); i++) {
            setAdvertisementEntity(arrayListBatchSearchObj.get(i));
            Option optrecBatchCodeSearchValues = new Option(getAdvertisementEntity().getOccurrence(), getAdvertisementEntity().getMediaTypes());
            recruitmentBatchCodeSearchOpt[i + 1] = optrecBatchCodeSearchValues;
        }

        return recruitmentBatchCodeSearchOpt;
    }
      public Option[] recruitmentBatchCodeAppForCandiate() {
        Option recruitmentBatchCodeSearchOpt[] = null;
        ArrayList<AdvertisementEntity> arrayListBatchSearchObj = getAdvertisementEntity().newRequitmentAppovedBatchCode();
        recruitmentBatchCodeSearchOpt = new Option[arrayListBatchSearchObj.size() + 1];
        Option optrecBatchCodeSearchValue = new Option(null, "Select Job Type");
        recruitmentBatchCodeSearchOpt[0] = optrecBatchCodeSearchValue;
        for (int i = 0; i < arrayListBatchSearchObj.size(); i++) {
            setAdvertisementEntity(arrayListBatchSearchObj.get(i));
            Option optrecBatchCodeSearchValues = new Option(getAdvertisementEntity().getOccurrence(), getAdvertisementEntity().getMediaTypes());
            recruitmentBatchCodeSearchOpt[i + 1] = optrecBatchCodeSearchValues;
        }

        return recruitmentBatchCodeSearchOpt;
    }

    public Option[] previouesAdvertisment() {
        Option recruitmentBatchCodeSearchOpt[] = null;
        ArrayList<AdvertisementEntity> arrayListBatchSearchObj = getAdvertisementEntity().previousRequitmentAppoved();
        recruitmentBatchCodeSearchOpt =
                new Option[arrayListBatchSearchObj.size() + 1];
        Option optrecBatchCodeSearchValue = new Option(null, "Select Bach Code");
        recruitmentBatchCodeSearchOpt[0] = optrecBatchCodeSearchValue;
        for (int i = 0; i <
                arrayListBatchSearchObj.size(); i++) {
            setAdvertisementEntity(arrayListBatchSearchObj.get(i));
            Option optrecBatchCodeSearchValues = new Option(getAdvertisementEntity().getOccurrence(), getAdvertisementEntity().getMediaTypes());
            recruitmentBatchCodeSearchOpt[i + 1] = optrecBatchCodeSearchValues;
        }

        return recruitmentBatchCodeSearchOpt;
    }

//    public ArrayList<String> readApprovedRequests(String bactchCode) {
//        return advertisementEntity.readApprovedRecruitments(bactchCode);
//
//    }
    public HashMap[] readApprovedRequests(String bactchCode) {
        return getAdvertisementEntity().readApprovedRecruitments(bactchCode);

    }

    public HashMap[] readAdvertisementInformantion(String bactchCode) {
        return getAdvertisementEntity().readAdvertisementInformantion(bactchCode);
    }

    public ArrayList<HashMap> readPreviousAdvertisement(String bachCode) {
        return advertisementEntity.readPreviousAdvertisement(bachCode);
    }

    public HashMap[] readVacancyList() {
        return getAdvertisementEntity().readVacancy();
    }

    public int countVacancyList() {
        return getAdvertisementEntity().countVacancy();
    }
     public String selectRequesterID(String advertId) {
         ResultSet _rs=null;
         String reqID=null;

                _rs= getAdvertisementEntity().selectRequesterID(advertId);
        try {
            while (_rs.next()) {
                reqID = _rs.getString("REQUESTER_ID");
            }
         } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
         return reqID;
    }


    public HashMap readAdvertisment(
            String bachCode) {
        return getAdvertisementEntity().readAdvertisement(bachCode);
    }

    public HashMap[] readAdvertizmentMediaInformantion(String advertizemntID) {
        return getAdvertisementEntity().readAdvertizmentMediaInformantion(advertizemntID);
    }

    public int countRequest() {
        return getAdvertisementEntity().getCountRequest();
    }

    public boolean registerVacancy(ArrayList<HashMap> vacancyInformation, ArrayList<HashMap> mediInformantion, ArrayList<HashMap> recruitemntInfo) {
        return getAdvertisementEntity().registerVacancyInformation(vacancyInformation, mediInformantion, recruitemntInfo);

    }

    public boolean updateVacancy(ArrayList<HashMap> vacancyInformation, ArrayList<HashMap> mediInformantion, ArrayList<HashMap> recruitemntInfo, HashMap advertAndBatch) {
        return advertisementEntity.updateVacancyInformation(vacancyInformation, mediInformantion, recruitemntInfo, advertAndBatch);
    }

    public boolean saveMediyaInformation(ArrayList<HashMap> mediInformantion, String advertisementID) {
        return getAdvertisementEntity().insertMediyaInfo(mediInformantion, advertisementID);
    }

    public boolean deleteMediyaInformation(String mediyaID) {
        return getAdvertisementEntity().deleteRecruitmentRequest(mediyaID);

    }

    public boolean deleteAdvertismdntInformation(String advert_ID, ArrayList<HashMap> recruit_requestID) {
        return advertisementEntity.deleteAdvertismentRequest(advert_ID, recruit_requestID);
    }

    public int updateAdvertismdntInfor(HashMap advertismentInf) {
        return advertisementEntity.updateAdvertisementInfo(advertismentInf);
    }

    public String[] readRequesterJobCode(String requesterID) {
        return getAdvertisementEntity().readRequesterJobCode(requesterID);
    }

    public HashMap[] readVacancyForValidation(String jobCode) {
        return getAdvertisementEntity().readVacancyForValidation(jobCode);
    }

    public HashMap[] readPersonEducHist(String requesterID) {
        return getAdvertisementEntity().readPersonEducHist(requesterID);
    }

    public HashMap[] readVacancyPromoRequesterTotalServiceYear(String advertID) {
        return advertisementEntity.readVacancyPromoRequesterTotalServiceYear(advertID);
    }

    public HashMap[] readVacancyPromoRequesterEducationLevel(String advertID) {
        return advertisementEntity.readVacancyPromoRequesterEducationLevel(advertID);
    }

    public HashMap[] readVacancyPromoRequest(String advertID) {
        return advertisementEntity.readVacancyPromoRequest(advertID);
    }
    public HashMap[] readVacancyPromoRequesterFirst(String advertID) {
        return advertisementEntity.readVacancyPromoRequester(advertID);
    }

    public HashMap[] readVacancyPromoRequester(String advertID) {
        return advertisementEntity.readVacancyPromoRequesterFinalPromotion(advertID);
    }
     public HashMap[] readVacancyPromoRequesterJustFinalForPromotion(String advertID) {
        return advertisementEntity.readVacancyPromoRequesterFinalPromotionJustForPromotion(advertID);
    }

    public HashMap[] readPromotionRequestsForApprovement(String advertID) {
        return advertisementEntity.readPromotionRequestsList(advertID);
    }

    public HashMap[] readPromotionRequestsList(String advertID) {
        return advertisementEntity.readPromotionRequestsList(advertID);
    }

    public HashMap[] readPromotionRequestsStat(String advertID) {
        return advertisementEntity.readPromotionRequestsStat(advertID);
    }

    public HashMap[] readVacancyPromoRequesterBasedOnPerformance(String advertID) {
        return advertisementEntity.readVacancyPromoRequesterBasedOnPerformance(advertID);
    }

    public HashMap[] readVacancyPromoRequesterTotalServiceYearEducationLevel(String advertID) {
        return advertisementEntity.readVacancyPromoRequesterTotalServiceYearEducationLevel(advertID);
    }

    public int addPromotionRequest(String adverID, String empID, String experience, String edulLevel, String educType,
            double expP, double perP, double educLP, double traiP) {
        return advertisementEntity.addPromotionRequest(adverID, empID, experience, edulLevel, educType, expP, perP, educLP, traiP);
    }

    public boolean addPromotionRequester(ArrayList<HashMap> listOfRequester, int committeeId) {
        try {
            return advertisementEntity.addPromotionRequest(listOfRequester, committeeId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public int approvePromotionRequest(String adverID, String empID) {
        return advertisementEntity.approvePromotionRequest(adverID, empID);
    }

    public int rejectPromotionRequest(String adverID, String empID) {
        return advertisementEntity.rejectPromotionRequest(adverID, empID);
    }

    public HashMap readPersonalInfoForPromotion(String empID, String departmentId) {
        return advertisementEntity.readPersonalInfoForPromotion(empID, departmentId);
    }

    public int addAInsidedvertisementInfo(String preparedDate, String advertisementDateFrom, String advertisementDateTo, String preparedBy, String recruitmentBatchCode, String advertType, String requestID) {
        return advertisementEntity.insertInsideAdvertisementInfo(preparedDate, advertisementDateFrom, advertisementDateTo, preparedBy, recruitmentBatchCode, advertType, requestID);
    }

    public HashMap[] readEvaSessionRenderd(String batchCode) {
        return null;// recruitmentEntity.readRecRequestForAdvert(batchCode);
    }

    public HashMap[] readJobDetailReadvert(String batchCode) {
        return null;//recruitmentEntity.readRecRequestForReAdvert(batchCode);
    }

    public AdvertisementManager(String preparedDate,
            String advertisementDateFrom,
            String advertisementDateTo,
            String preparedBy,
            String recruitmentBatchCode,
            String occurrence,
            String mediaType,
            int mediID,
            String mediaName) {
        this.preparedDate = preparedDate;
        this.advertisementDateFrom = advertisementDateFrom;
        this.advertisementDateTo = advertisementDateTo;
        this.preparedBy = preparedBy;
        this.recruitmentBatchCode = recruitmentBatchCode;
        this.occurrence = occurrence;
        this.mediaType = mediaType;
        this.mediID = mediID;
        this.mediaName = mediaName;
    }

    public AdvertisementManager(String preparedDate, String advertisementDateFrom, String advertisementDateTo, String preparedBy, String recruitmentBatchCode, String occurrence, String mediaType, String advertID, String mediaID, int x) {
        this.preparedDate = preparedDate;
        this.advertisementDateFrom = advertisementDateFrom;
        this.advertisementDateTo = advertisementDateTo;
        this.preparedBy = preparedBy;
        this.recruitmentBatchCode = recruitmentBatchCode;
        this.occurrence = occurrence;
        this.mediaType = mediaType;
        this.mediaCode = mediaID;
        this.advertID = advertID;
    }

    public HashMap[] readEvaSessionRenderdPreviouslyAdvert(String batchCode) {
        return null;// recruitmentEntity.readRecRequestForAdvertPreviouslyAdvert(batchCode);
    }

    public HashMap[] readAdverisementMediaDetail(String recruitmentID, String advertType) {
        return advertisementEntity.readAdverisementMediaDetail(recruitmentID, advertType);
    }

    public int UpdateAdvertisementInfo(AdvertisementManager saveAdvertisement, String mediaID, String advertID) {
        AdvertisementEntity saveAdvertisment = new AdvertisementEntity(
                saveAdvertisement.getAdvertisementDateFrom(),
                saveAdvertisement.getPreparedDate(),
                saveAdvertisement.getAdvertisementDateTo(),
                saveAdvertisement.getPreparedBy(),
                saveAdvertisement.getRecruitmentBatchCode(),
                saveAdvertisement.getOccurrence(),
                saveAdvertisement.getMediaType(),
                saveAdvertisement.getRecruitmentBatchCode());

        return advertisementEntity.UpdateAdvertisementInfo(saveAdvertisment, mediaID, advertID);
    }

    public AdvertisementManager(
            String occurrence,
            String mediaType,
            String adverID,
            String mediaCode,
            String realMediaCode,
            int x) {
        this.occurrence = occurrence;
        this.mediaType = mediaType;
        this.advertID = adverID;
        this.mediaCode = mediaCode;
        this.realMediaCode = realMediaCode;
    }

    public boolean checkRequestFPromotion(String advertID, String requesterID) {
        return advertisementEntity.checkRequestFPromotion(advertID, requesterID);
    }

    public boolean checkPromotedEmp(String advertID, String empID) {
        return advertisementEntity.checkPromotedEmp(advertID, empID);
    }

    private void dispaly() {
    }

    public int readEducLevel(String emp_Id) {
        return advertisementEntity.educLevelEmp(emp_Id);
    }

    public int readEducLevelresult(int educLevelId, String rank_id) {
        return advertisementEntity.educLevelEducLevelresult(rank_id, educLevelId);
    }
}