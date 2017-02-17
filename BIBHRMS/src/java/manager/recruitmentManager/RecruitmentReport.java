/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import entity.recruitmentEntity.RecruitmentReportEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import manager.ReportCritera.ReportCriteraManager;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author HRMS
 */
public class RecruitmentReport {

    RecruitmentReportEntity recruitmentRequestEntity = new RecruitmentReportEntity();
    private ArrayList<RecruitmentReportEntity> incrementPayGradeManagerList = new ArrayList<RecruitmentReportEntity>();
    private String jobType;
    private String jobCode;
    private String salary;
    private String deptId;
    private String minExp;
    private String req_date;
    private String educLevel;
    private String workingPla;
    private String educType;
    private String addSkill;
    private String minQual;
    private String rank;
    private String numberRequiredEmployee;
    private String requirementType;
    private String advertDateFrom;
    private String advertDateTo;
    private String approvDate;
    private String chief;
    private String directorate;
    private String process;
    private String writenExam;
    private String interviewExam;
    private float totalResult;
    private String practicalExam;
    private String cgpa;
    private int age;
    private String experience;
    private int mugerexperien;
    private String sex;
    private String candidate_ID;
    private String approverComm;
    private String refNo;
    private String candidateJobposi;
    private String candidateRank;
    private String fullName;
    private String empID;
    private String toReasult;
    private String perforamcneValue;
    private String promotionReasoun;

//    public RecruitmentReport(String jobType, String rank, String salary, String directorate, String empID, String sex, int age, String rank_id, String jobTypee, String toReasult, String interviewExam, String perforamcneValue, String educLevel, String educType, String experience, String advertDateFrom, String advertDateTo, String refNo, String promotionReasoun, String fullName, String approvDate) {
//        this.jobType=jobType;
//        this.rank=rank;
//        this.salary=salary;
//        this.directorate=directorate;
//        this.empID=empID;
//        this.sex=sex;
//        this.age=age;
//        this.rank=rank_id;
//        this.jobType=jobTypee;
//        this.toReasult=toReasult;
//        this.interviewExam=interviewExam;
//        this.perforamcneValue=perforamcneValue;
//        this.educLevel=educLevel;
//        this.educType=educType;
//        this.experience=experience;
//        this.advertDateFrom=advertDateFrom;
//        this.advertDateTo=advertDateTo;
//        this.refNo=refNo;
//        this.promotionReasoun=promotionReasoun;
//        this.fullName=fullName;
//        this.approvDate=approvDate;
//    }
    public RecruitmentReport(String jobName, String rankID, String salary, String deptName, String empID, String sex, int age, String rank_ID, String job_Name, String totalResult, String interviewResult, String performanceValue, String educationLevel, String educationType, String insideExpirance, String advert_dateFrom,String advert_dateTo,  String request_letter_number, String reasoun, String fullName, String completedDate) {
        this.jobType=jobName;
        this.rank=rankID;
        this.salary=salary;
        this.directorate=deptName;
        this.empID=empID;
        this.sex=sex;
        this.age=age;
        this.rank=rank_ID;
        this.jobType=job_Name;
        this.toReasult=totalResult;
        this.interviewExam=interviewResult;
        this.perforamcneValue=performanceValue;
        this.educLevel=educationLevel;
        this.educType=educationType;
        this.experience=insideExpirance;
        this.advertDateFrom=advert_dateFrom;
        this.advertDateTo=advert_dateTo;
        this.refNo=request_letter_number;
        this.promotionReasoun=reasoun;
        this.fullName=fullName;
        this.approvDate=completedDate;
    }
    public ArrayList<RecruitmentReport> recruitmentApproved() {
        ArrayList<RecruitmentReport> recReport = new ArrayList<RecruitmentReport>();
        try {
            ArrayList<HashMap> recApproved = recruitmentRequestEntity.recApprove();

            for (HashMap hm : recApproved) {

                recReport.add(new RecruitmentReport(
                        hm.get("JOB_NAME").toString(),
                        hm.get("RANK_ID").toString(),
                        hm.get("SALARY").toString(),
                        hm.get("Chief").toString(),
                        hm.get("Directorate").toString(),
                        hm.get("Process").toString(),
                        hm.get("EDUCATION_LEVEL").toString(),
                        hm.get("MIN_EXPERIENCE").toString(),
                        hm.get("ADDITIONALSKILL").toString(),
                        hm.get("NUM_OF_EMPS").toString(),
                        hm.get("RECRUIT_REQUEST_REF_DATE").toString(),
                        hm.get("DESCRIPTION").toString(),
                        hm.get("address_code").toString(),
                        hm.get("RECRUIT_APPROVED_DATE").toString()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return recReport;
    }

    public ArrayList<RecruitmentReport> advertisment() {
//
        ArrayList<RecruitmentReport> recReport = new ArrayList<RecruitmentReport>();
//
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
            try {
                ArrayList<HashMap> recApproved =recruitmentRequestEntity.advertismentByMonth(ReportCriteraManager.getParametrsForDay());
                for (HashMap hm : recApproved) {
                    recReport.add(new RecruitmentReport(
                            hm.get("JOB_NAME").toString(),
                            hm.get("RANK_ID").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("Chief").toString(),
                            hm.get("Directorate").toString(),
                            hm.get("Process").toString(),
                            hm.get("EDUCATION_LEVEL").toString(),
                            hm.get("MIN_EXPERIENCE").toString(),
                            hm.get("ADDITIONALSKILL").toString(),
                            hm.get("NUM_OF_EMPS").toString(),
                            "",
                            hm.get("DESCRIPTION").toString(),
                            hm.get("ADDRESS_CODE").toString(),
                            hm.get("ADVERT_DATE_FROM").toString(),
                            hm.get("ADVERT_DATE_TO").toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
            return recReport;
        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly")) {
            try {
                ArrayList<HashMap> recApproved = recruitmentRequestEntity.advertismentByQuarter(ReportCriteraManager.getParametrsForDay());

                for (HashMap hm : recApproved) {

                    recReport.add(new RecruitmentReport(
                            hm.get("JOB_NAME").toString(),
                            hm.get("RANK_ID").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("Chief").toString(),
                            hm.get("Directorate").toString(),
                            hm.get("Process").toString(),
                            hm.get("EDUCATION_LEVEL").toString(),
                            hm.get("MIN_EXPERIENCE").toString(),
                            hm.get("ADDITIONALSKILL").toString(),
                            hm.get("NUM_OF_EMPS").toString(),
                            "",
                            hm.get("DESCRIPTION").toString(),
                            hm.get("ADDRESS_CODE").toString(),
                            hm.get("ADVERT_DATE_FROM").toString(),
                            hm.get("ADVERT_DATE_TO").toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
            return recReport;
        }


         else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually")) {
            try {
                ArrayList<HashMap> recApproved = recruitmentRequestEntity.advertismentBySimiannual(ReportCriteraManager.getParametrsForDay());

                for (HashMap hm : recApproved) {

                    recReport.add(new RecruitmentReport(
                            hm.get("JOB_NAME").toString(),
                            hm.get("RANK_ID").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("Chief").toString(),
                            hm.get("Directorate").toString(),
                            hm.get("Process").toString(),
                            hm.get("EDUCATION_LEVEL").toString(),
                            hm.get("MIN_EXPERIENCE").toString(),
                            hm.get("ADDITIONALSKILL").toString(),
                            hm.get("NUM_OF_EMPS").toString(),
                            "",
                            hm.get("DESCRIPTION").toString(),
                            hm.get("ADDRESS_CODE").toString(),
                            hm.get("ADVERT_DATE_FROM").toString(),
                            hm.get("ADVERT_DATE_TO").toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
            return recReport;
        }

 else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually")) {
            try {
                ArrayList<HashMap> recApproved = recruitmentRequestEntity.advertismentByAnnual(ReportCriteraManager.getParametrsForDay());

                for (HashMap hm : recApproved) {

                    recReport.add(new RecruitmentReport(
                            hm.get("JOB_NAME").toString(),
                            hm.get("RANK_ID").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("Chief").toString(),
                            hm.get("Directorate").toString(),
                            hm.get("Process").toString(),
                            hm.get("EDUCATION_LEVEL").toString(),
                            hm.get("MIN_EXPERIENCE").toString(),
                            hm.get("ADDITIONALSKILL").toString(),
                            hm.get("NUM_OF_EMPS").toString(),
                            "",
                            hm.get("DESCRIPTION").toString(),
                            hm.get("ADDRESS_CODE").toString(),
                            hm.get("ADVERT_DATE_FROM").toString(),
                            hm.get("ADVERT_DATE_TO").toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
            return recReport;
        }

else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily")) {
            try {
                ArrayList<HashMap> recApproved = recruitmentRequestEntity.advertismentByDays(ReportCriteraManager.getParametrsForDay());

                for (HashMap hm : recApproved) {

                    recReport.add(new RecruitmentReport(
                            hm.get("JOB_NAME").toString(),
                            hm.get("RANK_ID").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("Chief").toString(),
                            hm.get("Directorate").toString(),
                            hm.get("Process").toString(),
                            hm.get("EDUCATION_LEVEL").toString(),
                            hm.get("MIN_EXPERIENCE").toString(),
                            hm.get("ADDITIONALSKILL").toString(),
                            hm.get("NUM_OF_EMPS").toString(),
                            "",
                            hm.get("DESCRIPTION").toString(),
                            hm.get("ADDRESS_CODE").toString(),
                            hm.get("ADVERT_DATE_FROM").toString(),
                            hm.get("ADVERT_DATE_TO").toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
            return recReport;
        }

else  {
            try {
                ArrayList<HashMap> recApproved = recruitmentRequestEntity.advertisment();

                for (HashMap hm : recApproved) {

                    recReport.add(new RecruitmentReport(
                            hm.get("JOB_NAME").toString(),
                            hm.get("RANK_ID").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("Chief").toString(),
                            hm.get("Directorate").toString(),
                            hm.get("Process").toString(),
                            hm.get("EDUCATION_LEVEL").toString(),
                            hm.get("MIN_EXPERIENCE").toString(),
                            hm.get("ADDITIONALSKILL").toString(),
                            hm.get("NUM_OF_EMPS").toString(),
                            "",
                            hm.get("DESCRIPTION").toString(),
                            hm.get("ADDRESS_CODE").toString(),
                            hm.get("ADVERT_DATE_FROM").toString(),
                            hm.get("ADVERT_DATE_TO").toString()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
            return recReport;
        }


    }

    public ArrayList<RecruitmentReport> internalVaccancy() {
        ArrayList<RecruitmentReport> recReport = new ArrayList<RecruitmentReport>();
        try {
            ArrayList<HashMap> recApproved = recruitmentRequestEntity.internalVaccancy();

            for (HashMap hm : recApproved) {

                recReport.add(new RecruitmentReport(
                        hm.get("JOB_NAME").toString(),
                        hm.get("RANK_ID").toString(),
                        hm.get("SALARY").toString(),
                        hm.get("Chief").toString(),
                        hm.get("Directorate").toString(),
                        hm.get("Process").toString(),
                        hm.get("EDUCATION_LEVEL").toString(),
                        hm.get("MIN_EXPERIENCE").toString(),
                        hm.get("ADDITIONALSKILL").toString(),
                        hm.get("NUM_OF_EMPS").toString(),
                        "",
                        hm.get("DESCRIPTION").toString(),
                        hm.get("ADDRESS_CODE").toString(),
                        hm.get("ADVERT_DATE_FROM").toString(),
                        hm.get("ADVERT_DATE_TO").toString()));
            }




        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return recReport;
    }

    public ArrayList<RecruitmentReport> recruitmentRequest() {
        ArrayList<RecruitmentReport> incrementPaygrade = new ArrayList<RecruitmentReport>();
        try {
            ArrayList<HashMap> recApproved = recruitmentRequestEntity.recRepuest();

            for (HashMap hm : recApproved) {

                incrementPaygrade.add(new RecruitmentReport(
                        hm.get("JOB_NAME").toString(),
                        hm.get("RANK_ID").toString(),
                        hm.get("SALARY").toString(),
                        hm.get("Chief").toString(),
                        hm.get("Directorate").toString(),
                        hm.get("Process").toString(),
                        hm.get("EDUCATION_LEVEL").toString(),
                        hm.get("MIN_EXPERIENCE").toString(),
                        hm.get("ADDITIONALSKILL").toString(),
                        hm.get("NUM_OF_EMPS").toString(),
                        hm.get("RECRUIT_REQUEST_REF_DATE").toString(),
                        hm.get("DESCRIPTION").toString(), hm.get("DESCRIPTION").toString()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return incrementPaygrade;
    }

    public ArrayList<RecruitmentReport> filterCandidate() {
        ArrayList<RecruitmentReport> incrementPaygrade = new ArrayList<RecruitmentReport>();

        float writenExam1 = 1;
        float interviewExam1 = 1;
        float totalResult1 = 0;
        float practicalExam1 = 1;
        float cgpa1 = 1;
        try {
            ArrayList<HashMap> candidates = recruitmentRequestEntity.filtercandidate();

            for (HashMap hm : candidates) {
                writenExam1 = Float.parseFloat(hm.get("WRITTEN_EXAM_RESULT").toString());
                interviewExam1 = Float.parseFloat(hm.get("INTERVIEW_EXAM_RESULT").toString());
                practicalExam1 = Float.parseFloat(hm.get("PRACTICAL_EXAM_RESULT").toString());
                totalResult1 = writenExam1 + interviewExam1 + practicalExam1;
                incrementPaygrade.add(new RecruitmentReport(
                        hm.get("JOB_NAME").toString(),
                        Float.toString(writenExam1),
                        Float.toString(interviewExam1),
                        Float.toString(practicalExam1),
                        totalResult1,
                        Float.toString(cgpa1),
                        hm.get("experience").toString(),
                        hm.get("CANDIDATE_ID").toString(),
                        hm.get("GENDER").toString(),
                        hm.get("RANK_ID").toString(),
                        GregorianCalendarManipulation.calaculateYearDifference(hm.get("DATEOFBIRTH").toString())));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return incrementPaygrade;
    }

    public ArrayList<HashMap> promotionFilterCandidate()
    {
        ArrayList<RecruitmentReport> promotion = new ArrayList<RecruitmentReport>();

        try {

            ArrayList<HashMap> promotionReportList = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = recruitmentRequestEntity.promotionFilterCandidateNewBiruk();
          
            while (ocrs.next())
            {
                HashMap resultInfo = new HashMap();

                resultInfo.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                resultInfo.put("RANK_ID", ocrs.getString("RANK_ID"));
                resultInfo.put("SALARY", ocrs.getString("SALARY"));
                resultInfo.put("dept_name", ocrs.getString("dept_name"));
                resultInfo.put("EMP_ID", ocrs.getString("EMP_ID"));
                resultInfo.put("SEX", ocrs.getString("SEX"));
                resultInfo.put("AGE", ocrs.getString("AGE"));
                resultInfo.put("RANK_ID", ocrs.getString("RANK_ID"));
                resultInfo.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                resultInfo.put("TOTALRESULT", ocrs.getString("TOTALRESULT"));
                resultInfo.put("EXAMPERCENTAGE", ocrs.getString("EXAMPERCENTAGE"));
                resultInfo.put("performancevalue", ocrs.getString("performancevalue"));
                resultInfo.put("EDUCATIONLEAVE", ocrs.getString("EDUCATIONLEAVE"));
                resultInfo.put("EDUCATIONTYPE", ocrs.getString("EDUCATIONTYPE"));
                resultInfo.put("INSIDEeXPRIANCE", ocrs.getString("INSIDEeXPRIANCE"));
                resultInfo.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                resultInfo.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                resultInfo.put("request_letter_number", ocrs.getString("request_letter_number"));
                resultInfo.put("reason", ocrs.getString("reason"));
                resultInfo.put("FULLNAME", ocrs.getString("FULLNAME"));
                resultInfo.put("completed_date", ocrs.getString("completed_date"));
                promotionReportList.add(resultInfo);
            }
            return promotionReportList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }

    }



    public ArrayList<RecruitmentReport> promotionFilter() {
        ArrayList<RecruitmentReport> incrementPaygrade = new ArrayList<RecruitmentReport>();

        float writenExam1 = 1;
        float interviewExam1 = 1;
        float totalResult1 = 0;
        float practicalExam1 = 1;

        float cgpa1 = 1;
        try {
            ArrayList<HashMap> candidates = recruitmentRequestEntity.promotionFilter();

            for (HashMap hm : candidates) {
//                writenExam1 = //Float.parseFloat(hm.get("WRITTEN_EXAM_RESULT").toString());
//                interviewExam1 = Float.parseFloat(hm.get("WRITTEN_EXAM_RESULT").toString());
//                practicalExam1 = Float.parseFloat(hm.get("WRITTEN_EXAM_RESULT").toString());
//                totalResult1 = writenExam1+ interviewExam1 + practicalExam1;

                incrementPaygrade.add(new RecruitmentReport(
                        hm.get("JOB_NAME").toString(),
                        Float.toString(writenExam1),
                        Float.toString(interviewExam1),
                        Float.toString(practicalExam1),
                        totalResult1,
                        Float.toString(cgpa1),
                        hm.get("FULLNAME").toString(),
                        " ",
                        " ",
                        hm.get("RANK_ID").toString(),
                        1, 0));
            }
//

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return incrementPaygrade;
    }

    public int loadEmployeeExprianceForReport(String empId) {
        List<HashMap> results = null;
        int expriance = 0;
        results = new ArrayList<HashMap>();
        try {

            ArrayList<HashMap> data = recruitmentRequestEntity.loadEmployeeExprianceReport(empId);
            for (HashMap hm : data) {
                HashMap list = new HashMap();
                expriance += GregorianCalendarManipulation.calaculateYearDifference(hm.get("START_DATE").toString(), hm.get("END_DATE").toString());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return expriance;

    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private RecruitmentReport(String jobType, String writenExam, String interviewExam, String practicalExam,
            float totalResult, String cgpa, String experience, String candidate_ID, String sex, String rank, int age) {
        this.jobType = jobType;
        this.writenExam = writenExam;
        this.interviewExam = interviewExam;
        this.practicalExam = practicalExam;
        this.totalResult = totalResult;
        this.cgpa = cgpa;
        this.experience = experience;
        this.candidate_ID = candidate_ID;
        this.sex = sex;
        this.rank = rank;
        this.age = age;

    }

    private RecruitmentReport(String jobType, String writenExam, String interviewExam, String practicalExam,
            float totalResult, String cgpa, String experience, String candidate_ID, String sex, String rank, int age, int age1) {
        this.jobType = jobType;
        this.writenExam = writenExam;
        this.interviewExam = interviewExam;
        this.practicalExam = practicalExam;
        this.totalResult = totalResult;
        this.cgpa = cgpa;
        this.experience = experience;
        this.candidate_ID = candidate_ID;
        this.sex = sex;
        this.rank = rank;
        this.age = age;

    }

    private RecruitmentReport(String jobType, String rank, String salary, String chief, String directorate, String process, String workingPlace,
            String candidateId, String sex,
            int age, String candidateRank, String candidateJobposi, String writenExam, String interview, String practical, float total,
            String educLevel, String educType, String cgpa, int mugerexperien,
            String educTY, String additionalSkill,
            String advertFrom, String advertTo, String refNo, String fullName, String approverdDate) {
        this.jobType = jobType;
        this.rank = rank;
        this.salary = salary;
        this.chief = chief;
        this.directorate = directorate;
        this.process = process;
        this.workingPla = workingPlace;
        this.candidate_ID = candidateId;
        this.sex = sex;
        this.age = age;
        this.candidateRank = candidateRank;
        this.candidateJobposi = candidateJobposi;
        this.writenExam = writenExam;
        this.interviewExam = interview;
        this.practicalExam = practical;
        this.totalResult = total;
        this.educLevel = educLevel;
        this.educType = educType;
        this.cgpa = cgpa;
        this.mugerexperien = mugerexperien;
        this.addSkill = additionalSkill;
        this.advertDateFrom = advertFrom;
        this.advertDateTo = advertTo;
        this.refNo = refNo;
        this.fullName = fullName;
        this.approvDate = approverdDate;

    }

    public RecruitmentReport() {
    }

    private RecruitmentReport(String jobType, String rank, String salary,
            String chief, String directorate, String process,
            String educLevel, String minExp, String addSkill,
            String numberRequiredEmployee, String req_date, String educType, String workingPla, String approvDate) {

        this.jobType = jobType;
        this.rank = rank;
        this.salary = salary;
        this.chief = chief;
        this.directorate = directorate;
        this.process = process;
        this.educLevel = educLevel;
        this.minExp = minExp;
        this.addSkill = addSkill;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.req_date = req_date;
        this.educType = educType;
        this.workingPla = workingPla;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.approvDate = approvDate;
    }

    private RecruitmentReport(String jobType, String rank, String salary,
            String chief, String directorate, String process,
            String educLevel, String minExp, String addSkill,
            String numberRequiredEmployee, String req_date, String educType,
            String workingPla, String advertDateFrom, String advertDateTo) {

        this.jobType = jobType;
        this.rank = rank;
        this.salary = salary;
        this.chief = chief;
        this.directorate = directorate;
        this.process = process;
        this.educLevel = educLevel;
        this.minExp = minExp;
        this.addSkill = addSkill;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.req_date = req_date;
        this.educType = educType;
        this.workingPla = workingPla;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.advertDateFrom = advertDateFrom;
        this.advertDateTo = advertDateTo;
    }

    private RecruitmentReport(String jobType, String rank, String salary,
            String chief, String directorate, String process,
            String educLevel, String minExp, String addSkill,
            String numberRequiredEmployee, String req_date, String educType, String workingPla) {

        this.jobType = jobType;
        this.rank = rank;
        this.salary = salary;
        this.chief = chief;
        this.directorate = directorate;
        this.process = process;
        this.educLevel = educLevel;
        this.minExp = minExp;
        this.addSkill = addSkill;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.req_date = req_date;
        this.educType = educType;
        this.workingPla = workingPla;
        this.numberRequiredEmployee = numberRequiredEmployee;
    }

    public int getMugerexperien() {
        return mugerexperien;
    }

    public void setMugerexperien(int mugerexperien) {
        this.mugerexperien = mugerexperien;
    }

    public String getApproverComm() {
        return approverComm;
    }

    public void setApproverComm(String approverComm) {
        this.approverComm = approverComm;
    }

    public String getCandidateJobposi() {
        return candidateJobposi;
    }

    public void setCandidateJobposi(String candidateJobposi) {
        this.candidateJobposi = candidateJobposi;
    }

    public String getCandidateRank() {
        return candidateRank;
    }

    public void setCandidateRank(String candidateRank) {
        this.candidateRank = candidateRank;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getAddSkill() {
        return addSkill;
    }

    public void setAddSkill(String addSkill) {
        this.addSkill = addSkill;
    }

    public String getAdvertDateFrom() {
        return advertDateFrom;
    }

    public void setAdvertDateFrom(String advertDateFrom) {
        this.advertDateFrom = advertDateFrom;
    }

    public String getAdvertDateTo() {
        return advertDateTo;
    }

    public void setAdvertDateTo(String advertDateTo) {
        this.advertDateTo = advertDateTo;
    }

    public String getApprovDate() {
        return approvDate;
    }

    public void setApprovDate(String approvDate) {
        this.approvDate = approvDate;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getToReasult() {
        return toReasult;
    }

    public void setToReasult(String toReasult) {
        this.toReasult = toReasult;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDirectorate() {
        return directorate;
    }

    public void setDirectorate(String directorate) {
        this.directorate = directorate;
    }

    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getEducType() {
        return educType;
    }

    public void setEducType(String educType) {
        this.educType = educType;
    }

    public ArrayList<RecruitmentReportEntity> getIncrementPayGradeManagerList() {
        return incrementPayGradeManagerList;
    }

    public void setIncrementPayGradeManagerList(ArrayList<RecruitmentReportEntity> incrementPayGradeManagerList) {
        this.incrementPayGradeManagerList = incrementPayGradeManagerList;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getMinExp() {
        return minExp;
    }

    public void setMinExp(String minExp) {
        this.minExp = minExp;
    }

    public String getMinQual() {
        return minQual;
    }

    public void setMinQual(String minQual) {
        this.minQual = minQual;
    }

    public String getNumberRequiredEmployee() {
        return numberRequiredEmployee;
    }

    public void setNumberRequiredEmployee(String numberRequiredEmployee) {
        this.numberRequiredEmployee = numberRequiredEmployee;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public RecruitmentReportEntity getRecruitmentRequestEntity() {
        return recruitmentRequestEntity;
    }

    public void setRecruitmentRequestEntity(RecruitmentReportEntity recruitmentRequestEntity) {
        this.recruitmentRequestEntity = recruitmentRequestEntity;
    }

    public String getReq_date() {
        return req_date;
    }

    public void setReq_date(String req_date) {
        this.req_date = req_date;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWorkingPla() {
        return workingPla;
    }

    public void setWorkingPla(String workingPla) {
        this.workingPla = workingPla;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPromotionReasoun() {
        return promotionReasoun;
    }

    public void setPromotionReasoun(String promotionReasoun) {
        this.promotionReasoun = promotionReasoun;
    }

    public String getCandidate_ID() {
        return candidate_ID;
    }

    public void setCandidate_ID(String candidate_ID) {
        this.candidate_ID = candidate_ID;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getInterviewExam() {
        return interviewExam;
    }

    public void setInterviewExam(String interviewExam) {
        this.interviewExam = interviewExam;
    }

    public String getPracticalExam() {
        return practicalExam;
    }

    public void setPracticalExam(String practicalExam) {
        this.practicalExam = practicalExam;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPerforamcneValue() {
        return perforamcneValue;
    }

    public void setPerforamcneValue(String perforamcneValue) {
        this.perforamcneValue = perforamcneValue;
    }

    public float getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(float totalResult) {
        this.totalResult = totalResult;
    }

    public String getWritenExam() {
        return writenExam;
    }

    public void setWritenExam(String writenExam) {
        this.writenExam = writenExam;
    }
    // </editor-fold>
}
