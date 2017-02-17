/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.Promotion;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author thecode
 */
public class PromoteReportEntity extends ConnectionManager {

    private Connection _con = null;
    private PreparedStatement _ps = null;
    private ResultSet _rs = null;
    private String bachCode;
    private String advertismentID;

    public String getAdvertismentID() {
        return advertismentID;
    }

    public void setAdvertismentID(String advertismentID) {
        this.advertismentID = advertismentID;
    }

    public String getBachCode() {
        return bachCode;
    }

    public void setBachCode(String bachCode) {
        this.bachCode = bachCode;
    }

    public PromoteReportEntity() {
    }

    public PromoteReportEntity(String advertismentID, String bachCode) {
        this.bachCode = bachCode;
        this.advertismentID = advertismentID;
    }

    public ArrayList<PromoteReportEntity> promotionBachCodeList() {

        String _select1 = "SELECT AD.RECRUIT_REQUEST_ID, " +
                "  AD.ADVERT_ID, " +
                "  AD.ADVERT_DATE_FROM, " +
                "  AD.ADVERT_DATE_TO, " +
                "  RQ.RECRUIT_BATCH_CODE " +
                " FROM HR_ADVERTISEMENT AD, " +
                "  HR_RECRUITMENT_REQUEST RQ " +
                " WHERE ADVERTISEMENT_TYPE = 'Inside' " +
                " AND AD.RECRUIT_REQUEST_ID=RQ.RECRUIT_REQUEST_ID";
        ArrayList<PromoteReportEntity> requests = new ArrayList<PromoteReportEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                PromoteReportEntity read = new PromoteReportEntity(
                        ocrs.getString("ADVERT_ID"),
                        ocrs.getString("RECRUIT_BATCH_CODE"));
//                + "dereje" + "--" +
//                        ocrs.getString("ADVERT_DATE_FROM") + "--" +
//                        ocrs.getString("ADVERT_DATE_TO")
                requests.add(read);
            }

            return requests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<HashMap> promotionGroupReport(String promotionDate, String promotionEndDate, String employeeGender, String employee_type, String department) {

        String select = " SELECT CONCAT (CONCAT(hr_employee_info.first_Name || ' ' , hr_employee_info.middle_Name ||' '), hr_employee_info.last_Name) AS hr_employee_info_Full_Name," +
                "  NVL(hr_emp_promotion.promotion_Date,'not register') AS promotion_Date, " +
                "  NVL(hr_emp_promotion.promotion_Type,'not register') AS promotion_Type, " +
                "  NVL(hr_emp_promotion.rank_From,'not register')      AS rank_From, " +
                "  NVL(HR_EMP_PROMOTION.EMP_ID ,'not register')        AS EMP_ID, " +
                "  NVL(hr_emp_promotion.rank_To ,'not register')       AS rank_To, " +
                "  NVL(hr_emp_promotion.step_From,'not register')      AS step_From, " +
                "  NVL(hr_emp_promotion.step_To ,'not register')       AS step_To, " +
                "  NVL(hr_emp_promotion.salary_From ,0)   AS salary_From, " +
                "  NVL(hr_emp_promotion.salary_To ,0)     AS salary_To, " +
                "  NVL(hr_emp_promotion.titlefrom ,'not register')     AS titlefrom, " +
                "  NVL(hr_emp_promotion.titleto ,'not register')       AS titleto " +
                " FROM hr_employee_info INNER JOIN hr_emp_promotion hr_emp_promotion ON hr_employee_info.emp_Id = hr_emp_promotion.emp_Id" +
                " WHERE hr_emp_promotion.promotion_Date Between '" + promotionDate + "' AND '" + promotionEndDate + "' " + employeeGender + " " + department + " " + employee_type + "";

        ArrayList<HashMap> readPromotionInfiormation = new ArrayList<HashMap>();
        ResultSet rs;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = ps.executeQuery();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("fullName", ocrs.getString("hr_employee_info_Full_Name"));
                hm.put("employeeId", ocrs.getString("EMP_ID"));
                hm.put("promotion_Date", ocrs.getString("promotion_Date"));
                hm.put("rank_From", ocrs.getString("rank_From"));
                hm.put("rank_To", ocrs.getString("rank_To"));
                hm.put("step_From", ocrs.getString("step_From"));
                hm.put("step_To", ocrs.getString("step_To"));
                hm.put("salary_From", ocrs.getString("salary_From"));
                hm.put("salary_To", ocrs.getString("salary_To"));
                readPromotionInfiormation.add(hm);
            }


            return readPromotionInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }

    public ArrayList<HashMap> promotionExapResultReport(String bachCode) {
        try {
            String selectStatment = "SELECT DISTINCT HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE, " +
                    "  HR_PROMOTION_REQUEST.DISCIPLINERESULT, " +
                    "  HR_PROMOTION_REQUEST.PERFORMANCEVALUE, " +
                    "  hr_lu_job_type.job_Code, " +
                    "  HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, " +
                    "  HR_ADVERTISEMENT.ADVERT_ID, " +
                    "  hr_lu_job_type.JOB_DESCRIPTION, " +
                    "  HR_ADVERTISEMENT.RECRUIT_BATCH_CODE, " +
                    "  PA.INTERVIEW_EXAM_RESULT, " +
                    "  PA.WRITTEN_EXAM_RESULT, " +
                    "  PA.PRESENTATION_EXAM_RESULT, " +
                    "  PA.OTHER_RESULT , " +
                    "  HR_PROMOTION_REQUEST.EXAMPERCENTAGE , " +
                    " HR_PROMOTION_REQUEST.TOALEXAMRESULT," +
                    " HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE, " +
                    "  TO_NUMBER(PA.INTERVIEW_EXAM_RESULT) + TO_NUMBER(PA.WRITTEN_EXAM_RESULT)+ TO_NUMBER(PA.PRESENTATION_EXAM_RESULT)+ TO_NUMBER(PA.OTHER_RESULT) AS TOTAL, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || EMP.FIRST_NAME " +
                    "  ||' ' " +
                    "  || EMP.MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME                                                                                                                                                                                                                                                                                                   AS FULLNAME, " +
                    "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                                                                                                                                                                                                                  AS EXAMEPERCENTAGERESULT, " +
                    "                                        + ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                                                                                                                                                                  AS DISCIPLINEPERCENTAGERESULT, " +
                    "                                        + ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                                                                                                                                                                 AS PERFORMANCEPERCENTAGERESULT, " +
                    "                                        + ((HR_PROMOTION_REQUEST.TOALEXAMRESULT * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100) + ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100) + ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100) AS EMPLOYEETOTALRESULT " +
                    "FROM hr_recruitment_request , " +
                    "  hr_lu_job_type, " +
                    "  HR_ADVERTISEMENT, " +
                    "  HR_PROMOTION_REQUEST, " +
                    "  HR_PROMOTION_ASSESSMENT PA, " +
                    "  HR_EMPLOYEE_INFO EMP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_PROMOTION_ASS_PERCENTAGE ASP " +
                    "WHERE hr_recruitment_request.job_Code         = hr_lu_job_type.job_Code " +
                    "AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                    "AND HR_PROMOTION_REQUEST.ADVERT_ID            = HR_ADVERTISEMENT.ADVERT_ID " +
                    "AND PA.PROMOTION_REQUEST_ID                   =HR_PROMOTION_REQUEST.ID " +
                    "AND HR_PROMOTION_REQUEST.REQUESTER_ID         =EMP.EMP_ID " +
                    "AND TI.TITLE_ID                               =EMP.TITLE " +
                    "AND HR_ADVERTISEMENT.RECRUIT_BATCH_CODE       ='" + bachCode + "' " +
                    "AND ASP.BATCH_CODE                            =HR_ADVERTISEMENT.RECRUIT_BATCH_CODE";
            ArrayList<HashMap> promotionExamReportList = new ArrayList<HashMap>();
            _con = getConnection();
            _ps = _con.prepareStatement(selectStatment);
            _rs = _ps.executeQuery();
            //OracleCachedRowSet ocrs = new OracleCachedRowSet();
            //ocrs.populate(_rs);
            //_rs.close();

            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("employeeFullName", _rs.getString("FULLNAME"));
                hm.put("disciplinePercentage", _rs.getString("DISCIPLINEPERCENTAGE"));
                hm.put("disciplineresult", _rs.getString("DISCIPLINERESULT"));
                hm.put("performancevalue", _rs.getString("PERFORMANCEVALUE"));
                hm.put("performancePercentage", _rs.getString("PERFORMANCEPERCENTAGE"));
                hm.put("totalExamresult", _rs.getString("TOALEXAMRESULT"));
                hm.put("jobDescription", _rs.getString("JOB_DESCRIPTION"));
                hm.put("examPercentage", _rs.getString("EXAMPERCENTAGE"));
                hm.put("totalResult", _rs.getString("EMPLOYEETOTALRESULT"));
                promotionExamReportList.add(hm);
            }
            return promotionExamReportList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> promotedEmployeeExamResultReport(String bachCode) {
        try {
            String selectStatment = "SELECT DISTINCT HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE, " +
                    "  HR_PROMOTION_REQUEST.DISCIPLINERESULT, " +
                    "  HR_PROMOTION_REQUEST.PERFORMANCEVALUE, " +
                    "  hr_lu_job_type.job_Code, " +
                    "  HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, " +
                    "  HR_ADVERTISEMENT.ADVERT_ID, " +
                    "  hr_lu_job_type.JOB_DESCRIPTION, " +
                    "  HR_ADVERTISEMENT.RECRUIT_BATCH_CODE, " +
                    "  PA.INTERVIEW_EXAM_RESULT, " +
                    "  PA.WRITTEN_EXAM_RESULT, " +
                    "  PA.PRESENTATION_EXAM_RESULT, " +
                    "  PA.OTHER_RESULT , " +
                    "  HR_PROMOTION_REQUEST.EXAMPERCENTAGE , " +
                    "  HR_PROMOTION_REQUEST.TOALEXAMRESULT, " +
                    "  HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE, " +
                    "  TO_NUMBER(PA.INTERVIEW_EXAM_RESULT) + TO_NUMBER(PA.WRITTEN_EXAM_RESULT)+ TO_NUMBER(PA.PRESENTATION_EXAM_RESULT)+ TO_NUMBER(PA.OTHER_RESULT) AS TOTAL, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || EMP.FIRST_NAME " +
                    "  ||' ' " +
                    "  || EMP.MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME                                                                                                                                                                                                                                                                                                   AS FULLNAME, " +
                    "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                                                                                                                                                                                                                  AS EXAMEPERCENTAGERESULT, " +
                    "                                        + ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                                                                                                                                                                  AS DISCIPLINEPERCENTAGERESULT, " +
                    "                                        + ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                                                                                                                                                                 AS PERFORMANCEPERCENTAGERESULT, " +
                    "                                        + ((HR_PROMOTION_REQUEST.TOALEXAMRESULT * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100) + ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100) + ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100) AS EMPLOYEETOTALRESULT " +
                    "FROM hr_recruitment_request , " +
                    "  hr_lu_job_type, " +
                    "  HR_ADVERTISEMENT, " +
                    "  HR_PROMOTION_REQUEST, " +
                    "  HR_PROMOTION_ASSESSMENT PA, " +
                    "  HR_EMPLOYEE_INFO EMP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_PROMOTION_ASS_PERCENTAGE ASP , " +
                    "  HR_EMP_PROMOTION " +
                    "WHERE hr_recruitment_request.job_Code         = hr_lu_job_type.job_Code " +
                    "AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                    "AND HR_PROMOTION_REQUEST.ADVERT_ID            = HR_ADVERTISEMENT.ADVERT_ID " +
                    "AND PA.PROMOTION_REQUEST_ID                   =HR_PROMOTION_REQUEST.ID " +
                    "AND HR_PROMOTION_REQUEST.REQUESTER_ID         =EMP.EMP_ID " +
                    "AND TI.TITLE_ID                               =EMP.TITLE " +
                    "AND HR_ADVERTISEMENT.RECRUIT_BATCH_CODE       ='Bac-123' " +
                    "AND HR_EMP_PROMOTION.EMP_ID                   =HR_PROMOTION_REQUEST.REQUESTER_ID " +
                    "AND ASP.BATCH_CODE                            =HR_ADVERTISEMENT.RECRUIT_BATCH_CODE";



            ArrayList<HashMap> promotionExamReportList = new ArrayList<HashMap>();
            _con = getConnection();
            _ps = _con.prepareStatement(selectStatment);
            _rs = _ps.executeQuery();
            //OracleCachedRowSet ocrs = new OracleCachedRowSet();
            //ocrs.populate(_rs);
            //_rs.close();

            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("employeeFullName", _rs.getString("FULLNAME"));
                hm.put("disciplinePercentage", _rs.getString("DISCIPLINEPERCENTAGE"));
                hm.put("disciplineresult", _rs.getString("DISCIPLINERESULT"));
                hm.put("performancevalue", _rs.getString("PERFORMANCEVALUE"));
                hm.put("performancePercentage", _rs.getString("PERFORMANCEPERCENTAGE"));
                hm.put("totalExamresult", _rs.getString("TOALEXAMRESULT"));
                hm.put("jobDescription", _rs.getString("JOB_DESCRIPTION"));
                hm.put("examPercentage", _rs.getString("EXAMPERCENTAGE"));
                hm.put("totalResult", _rs.getString("EMPLOYEETOTALRESULT"));
                promotionExamReportList.add(hm);
            }
            return promotionExamReportList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> promotionReportByDate(String promotionDate, String promotionEndDate) {

        String select = "SELECT CONCAT (CONCAT(hr_employee_info.first_Name " +
                "  || ' ' , hr_employee_info.middle_Name " +
                "  ||' '), hr_employee_info.last_Name)                 AS hr_employee_info_Full_Name, " +
                "  NVL(hr_emp_promotion.promotion_Date,'not register') AS promotion_Date, " +
                "  NVL(hr_emp_promotion.promotion_Type,'not register') AS promotion_Type, " +
                "  NVL(hr_emp_promotion.rank_From,'not register')      AS rank_From, " +
                "  NVL(HR_EMP_PROMOTION.EMP_ID ,'not register')        AS EMP_ID, " +
                "  NVL(hr_emp_promotion.rank_To ,'not register')       AS rank_To, " +
                "  NVL(hr_emp_promotion.step_From,'not register')      AS step_From, " +
                "  NVL(hr_emp_promotion.step_To ,'not register')       AS step_To, " +
                "  NVL(hr_emp_promotion.salary_From ,0)                AS salary_From, " +
                "  NVL(hr_emp_promotion.salary_To ,0)                  AS salary_To " +
                "FROM hr_employee_info " +
                "INNER JOIN hr_emp_promotion hr_emp_promotion " +
                "ON hr_employee_info.emp_Id = hr_emp_promotion.emp_Id " +
                "WHERE hr_emp_promotion.promotion_Date BETWEEN '" + promotionDate + "' AND '" + promotionEndDate + "'  ";

        ArrayList<HashMap> readPromotionInfiormation = new ArrayList<HashMap>();
        ResultSet rs;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = ps.executeQuery();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("fullName", ocrs.getString("hr_employee_info_Full_Name"));
                hm.put("employeeId", ocrs.getString("EMP_ID"));
                hm.put("promotion_Date", ocrs.getString("promotion_Date"));
                hm.put("rank_From", ocrs.getString("rank_From"));
                hm.put("rank_To", ocrs.getString("rank_To"));
                hm.put("step_From", ocrs.getString("step_From"));
                hm.put("step_To", ocrs.getString("step_To"));
                hm.put("salary_From", ocrs.getString("salary_From"));
                hm.put("salary_To", ocrs.getString("salary_To"));
            
                readPromotionInfiormation.add(hm);
            }


            return readPromotionInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }

    public ArrayList<HashMap> promotionReportByDate(String bachCode) {

        String select = "SELECT CONCAT (CONCAT(hr_employee_info.first_Name " +
                "  || ' ' , hr_employee_info.middle_Name " +
                "  ||' '), hr_employee_info.last_Name)                 AS hr_employee_info_Full_Name, " +
                "  NVL(hr_emp_promotion.promotion_Date,'not register') AS promotion_Date, " +
                "  NVL(hr_emp_promotion.promotion_Type,'not register') AS promotion_Type, " +
                "  NVL(hr_emp_promotion.rank_From,'not register')      AS rank_From, " +
                "  NVL(HR_EMP_PROMOTION.EMP_ID ,'not register')        AS EMP_ID, " +
                "  NVL(hr_emp_promotion.rank_To ,'not register')       AS rank_To, " +
                "  NVL(hr_emp_promotion.step_From,'not register')      AS step_From, " +
                "  NVL(hr_emp_promotion.step_To ,'not register')       AS step_To, " +
                "  NVL(hr_emp_promotion.salary_From ,0)                AS salary_From, " +
                "  NVL(hr_emp_promotion.salary_To ,0)                  AS salary_To " +
                "FROM hr_employee_info " +
                "INNER JOIN hr_emp_promotion " +
                "ON hr_employee_info.emp_Id = hr_emp_promotion.emp_Id " +
                "JOIN HR_ADVERTISEMENT " +
                "ON HR_ADVERTISEMENT.ADVERT_ID            =hr_emp_promotion.ADVERT_ID " +
                "WHERE HR_ADVERTISEMENT.RECRUIT_BATCH_CODE='"+bachCode+"'";

        ArrayList<HashMap> readPromotionInfiormation = new ArrayList<HashMap>();
        ResultSet rs;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = ps.executeQuery();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("fullName", ocrs.getString("hr_employee_info_Full_Name"));
                hm.put("employeeId", ocrs.getString("EMP_ID"));
                hm.put("promotion_Date", ocrs.getString("promotion_Date"));
                hm.put("rank_From", ocrs.getString("rank_From"));
                hm.put("rank_To", ocrs.getString("rank_To"));
                hm.put("step_From", ocrs.getString("step_From"));
                hm.put("step_To", ocrs.getString("step_To"));
                hm.put("salary_From", ocrs.getString("salary_From"));
                hm.put("salary_To", ocrs.getString("salary_To"));             
                readPromotionInfiormation.add(hm);
            }
            return readPromotionInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }
}
