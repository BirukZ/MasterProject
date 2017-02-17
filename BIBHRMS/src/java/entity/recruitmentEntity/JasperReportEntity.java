/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import entity.recruitmentEntity.JasperReportEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import manager.ReportCritera.ReportCriteraManager;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import manager.globalUseManager.GregorianCalendarManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class JasperReportEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public ArrayList<HashMap> loadCandidateInformationForReport(HashMap parametrsForCandidate) throws SQLException {

        String newTest = "SELECT M.canID, " +
                "  M.unversity, " +
                "  M.point, " +
                "  M.study, " +
                "  M.leaveOFEducation, " +
                "  M.yearofgra, " +
                "  M.startDate, " +
                "  M.endDate, " +
                "  M.jobTitle, " +
                "  M.workplace, " +
                "  M.relation, " +
                "  M.salary, " +
                "  M.expyear, " +
                "  M.expmonht, " +
                "  M.expday, " +
                "  K.totalYears, " +
                "  K.totalMonth, " +
                "  K.totalDays, " +
                "  K.candidateID, " +
                "  J.FULLNAME, " +
                "  J.Age, " +
                "  J.ADDRESS, " +
                "  J.sex, " +
                "  J.batchCode, " +
                "  J.numberOFEmp, " +
                "  J.advertsimentDate " +
                "FROM " +
                "  (SELECT * " +
                "  FROM " +
                "    (SELECT (a.candidate_id)AS canID, " +
                "      a.instution           AS unversity, " +
                "      a.cgpa                AS point, " +
                "      a.filed_of_study      AS study, " +
                "      a.FILED_OF_CATAGORY   AS leaveOFEducation, " +
                "      a.graduation_year     AS yearofgra, " +
                "      b.start_date          AS startDate, " +
                "      b.end_date            AS endDate, " +
                "      b.job_title           AS jobTitle, " +
                "      b.INSTITUION          AS workplace, " +
                "      b.EXP_RELATION_TYPE   AS relation, " +
                "      b.salary              AS salary, " +
                "      b.expdetail           AS expyear, " +
                "      b.exp_month           AS expmonht, " +
                "      b.exp_day             AS expday " +
                "    FROM " +
                "      (SELECT * " +
                "      FROM hr_candidate_education " +
                "      WHERE CANDIDATE_ID ='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "      AND GRADUATION_YEAR= " +
                "        (SELECT MAX(GRADUATION_YEAR) " +
                "        FROM hr_candidate_education " +
                "        WHERE CANDIDATE_ID='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "        ) " +
                "      )a , " +
                "      (SELECT * " +
                "      FROM hr_candidate_experience " +
                "      WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "      AND start_date    = " +
                "        (SELECT MAX(start_date) " +
                "        FROM HR_CANDIDATE_EXPERIENCE " +
                "        WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "        ) " +
                "      )b " +
                "    WHERE a.CANDIDATE_ID=b.CANDIDATE_ID " +
                "    UNION " +
                "    SELECT (D.candidate_id)AS id, " +
                "      D.instution, " +
                "      D.cgpa, " +
                "      D.filed_of_study, " +
                "      D.FILED_OF_CATAGORY, " +
                "      D.graduation_year, " +
                "      ('.') AS id2, " +
                "      ('.') AS X2, " +
                "      ('.') AS Y2, " +
                "      ('.') AS Z2, " +
                "      ('.') AS W, " +
                "      ('.') AS R, " +
                "      ('.') AS U , " +
                "      ('.') AS gg , " +
                "      ('.') AS kk " +
                "    FROM " +
                "      (SELECT * " +
                "      FROM hr_candidate_education " +
                "      WHERE CANDIDATE_ID  ='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "      AND GRADUATION_YEAR < " +
                "        (SELECT MAX(GRADUATION_YEAR) " +
                "        FROM hr_candidate_education " +
                "        WHERE CANDIDATE_ID='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "        ) " +
                "      )D " +
                "    ) " +
                "  UNION " +
                "  SELECT ('.')AS id, " +
                "    ('.')     AS X, " +
                "    ('.')     AS Y, " +
                "    ('.')     AS Z, " +
                "    ('.')     AS W, " +
                "    ('.')     AS XX, " +
                "    C.start_date, " +
                "    C.end_date, " +
                "    C.job_title, " +
                "    c.INSTITUION, " +
                "    C.EXP_RELATION_TYPE, " +
                "    C.salary, " +
                "    C.expdetail, " +
                "    C.exp_month, " +
                "    C.exp_day " +
                "  FROM " +
                "    (SELECT * " +
                "    FROM hr_candidate_experience " +
                "    WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "    AND start_date    < " +
                "      (SELECT MAX(start_date) " +
                "      FROM HR_CANDIDATE_EXPERIENCE " +
                "      WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "      ) " +
                "    )C " +
                "  )M, " +
                "  (SELECT SUM(expYears) AS totalYears , " +
                "    SUM(expMonth)       AS totalMonth, " +
                "    SUM(expDays)        AS totalDays, " +
                "    SUM(Idntification)  AS candidateID " +
                "  FROM " +
                "    (SELECT SUM(expyear) AS expYears , " +
                "      SUM( expmonht)     AS expMonth, " +
                "      SUM(expday)        AS expDays, " +
                "      canID              AS Idntification " +
                "    FROM " +
                "      (SELECT * " +
                "      FROM " +
                "        (SELECT (a.candidate_id)AS canID, " +
                "          a.instution           AS unversity, " +
                "          a.cgpa                AS point, " +
                "          a.filed_of_study      AS study, " +
                "          a.FILED_OF_CATAGORY   AS leaveOFEducation, " +
                "          a.graduation_year     AS yearofgra, " +
                "          b.start_date          AS startDate, " +
                "          b.end_date            AS endDate, " +
                "          b.job_title           AS jobTitle, " +
                "          b.INSTITUION          AS workplace, " +
                "          b.EXP_RELATION_TYPE   AS relation, " +
                "          b.salary              AS salary, " +
                "          b.expdetail           AS expyear, " +
                "          b.exp_month           AS expmonht, " +
                "          b.exp_day             AS expday " +
                "        FROM " +
                "          (SELECT * " +
                "          FROM hr_candidate_education " +
                "          WHERE CANDIDATE_ID ='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "          AND GRADUATION_YEAR= " +
                "            (SELECT MAX(GRADUATION_YEAR) " +
                "            FROM hr_candidate_education " +
                "            WHERE CANDIDATE_ID='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "            ) " +
                "          )a , " +
                "          (SELECT * " +
                "          FROM hr_candidate_experience " +
                "          WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "          AND start_date    = " +
                "            (SELECT MAX(start_date) " +
                "            FROM HR_CANDIDATE_EXPERIENCE " +
                "            WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "            ) " +
                "          )b " +
                "        WHERE a.CANDIDATE_ID=b.CANDIDATE_ID " +
                "        UNION " +
                "        SELECT (D.candidate_id)AS id, " +
                "          D.instution, " +
                "          D.cgpa, " +
                "          D.filed_of_study, " +
                "          D.FILED_OF_CATAGORY, " +
                "          D.graduation_year, " +
                "          ('') AS id2, " +
                "          ('') AS X2, " +
                "          ('') AS Y2, " +
                "          ('') AS Z2, " +
                "          ('') AS W, " +
                "          ('') AS R, " +
                "          ('') AS U , " +
                "          ('') AS gg , " +
                "          ('') AS kk " +
                "        FROM " +
                "          (SELECT * " +
                "          FROM hr_candidate_education " +
                "          WHERE CANDIDATE_ID  ='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "          AND GRADUATION_YEAR < " +
                "            (SELECT MAX(GRADUATION_YEAR) " +
                "            FROM hr_candidate_education " +
                "            WHERE CANDIDATE_ID='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "            ) " +
                "          )D " +
                "        ) " +
                "      UNION " +
                "      SELECT ('')AS id, " +
                "        ('')     AS X, " +
                "        ('')     AS Y, " +
                "        ('')     AS Z, " +
                "        ('')     AS W, " +
                "        ('')     AS XX, " +
                "        C.start_date, " +
                "        C.end_date, " +
                "        C.job_title, " +
                "        c.INSTITUION, " +
                "        C.EXP_RELATION_TYPE, " +
                "        C.salary, " +
                "        C.expdetail, " +
                "        C.exp_month, " +
                "        C.exp_day " +
                "      FROM " +
                "        (SELECT * " +
                "        FROM hr_candidate_experience " +
                "        WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "        AND start_date    < " +
                "          (SELECT MAX(start_date) " +
                "          FROM HR_CANDIDATE_EXPERIENCE " +
                "          WHERE candidate_id='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "          ) " +
                "        )C " +
                "      ) " +
                "    GROUP BY canID " +
                "    ) " +
                "  )K, " +
                "  ( SELECT DISTINCT KK.candidate_id, " +
                "    KK.candidate_f_name " +
                "    || KK.CANDIDATE_M_NAME " +
                "    ||KK.CANDIDATE_L_NAME                                 AS FULLNAME, " +
                "    TO_CHAR(sysdate, 'YYYY') - SUBSTR(KK.DATEOFBIRTH,1,4) AS Age, " +
                "    KK.OFFICETELEPHONE " +
                "    ||'/' " +
                "    || KK.telephone_mobile AS ADDRESS, " +
                "    KK.GENDER              AS sex, " +
                "    KK.RECRUIT_BATCH_CODE  AS batchCode, " +
                "    req.num_of_emps        AS numberOFEmp, " +
                "    AD.ADVERT_DATE_FROM " +
                "    ||' ' " +
                "    ||'To' " +
                "    ||' ' " +
                "    ||AD.ADVERT_DATE_TO AS advertsimentDate " +
                "  FROM HR_CANDIDATE KK " +
                "  INNER JOIN HR_ADVERTISEMENT AD " +
                "  ON AD.RECRUIT_BATCH_CODE=KK.RECRUIT_BATCH_CODE " +
                "  INNER JOIN HR_CANDIDATE_EXPERIENCE CE " +
                "  ON ce.candidate_id=KK.CANDIDATE_ID " +
                "  INNER JOIN hr_recruitment_request req " +
                "  ON req.recruit_batch_code=KK.recruit_batch_code " +
                "  WHERE KK.CANDIDATE_ID='"+ parametrsForCandidate.get("candidateID").toString() + "' " +
                "  )J";


        ResultSet rsName;

        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement psCanName = _conn.prepareStatement(newTest);

            ArrayList<HashMap> readCandidateInfo = new ArrayList<HashMap>();

            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            rsName = psCanName.executeQuery();
            ocrs1.populate(rsName);
            // JOptionPane.showMessageDialog(null, ocrs1.size());
            while ((ocrs1.next())) {
                String test;
                HashMap hm = new HashMap();
                HashMap hm1 = new HashMap();
                hm.put("CANDIDATNAME", (ocrs1.getString("FULLNAME")));
                hm.put("AGE", (ocrs1.getString("Age")));
                hm.put("ADDRESS", (ocrs1.getString("ADDRESS")));
                hm.put("GENDER", (ocrs1.getString("sex")));
                hm.put("RECRUIT_BATCH_CODE", (ocrs1.getString("batchCode")));
                hm.put("num_of_emps", (ocrs1.getString("numberOFEmp")));
                hm.put("jobNew", (ocrs1.getString("jobTitle")));
                hm.put("advertsimentDate", (ocrs1.getString("advertsimentDate")));
                hm.put("EXP_DAY", (ocrs1.getString("expday")));
                hm.put("EXP_MONTH", (ocrs1.getString("expmonht")));
                hm.put("EXPDETAIL", (ocrs1.getString("expyear")));
                hm.put("workingorg", (ocrs1.getString("workplace")));
                hm.put("JOB_TITLE", (ocrs1.getString("jobTitle")));
                hm.put("SALARY", (ocrs1.getString("salary")));
                hm.put("START_DATE", (ocrs1.getString("startDate")));
                hm.put("END_DATE", (ocrs1.getString("endDate")));
                hm.put("equvalent", (ocrs1.getString("relation")));
                hm.put("CGPA", (ocrs1.getString("point")));
                hm.put("GRADUATEDBY", (ocrs1.getString("study")));
                hm.put("yearofgraduation", (ocrs1.getString("yearofgra")));
                hm.put("university", (ocrs1.getString("unversity")));
                hm.put("levelofEducation", (ocrs1.getString("leaveOFEducation")));
                hm.put("expYears", (ocrs1.getString("totalYears")));
                hm.put("expMonth", (ocrs1.getString("totalMonth")));
                hm.put("expDays", (ocrs1.getString("totalDays")));
                readCandidateInfo.add(hm);
            // readCandidateInfo.add(hm1);
            // readCandidateInfo.
            }

            closePooledConnections(_conn);
            return readCandidateInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Collection loadEmployeeInformationForReport(String empID) {
         String newTest ="SELECT hr_employee_info.RANK_ID, " +
                "  hr_employee_info.PAY_GRADE, " +
                "  hr_employee_info.NATIONALITY, " +
                "  hr_employee_info.department_id, " +
                "  hr_employee_info.NATION_CODE, " +
                "  hr_employee_info.TITLE, " +
                "  hr_employee_info.first_Name, " +
                "  hr_employee_info.emp_id, " +
                "  hr_employee_info.middle_Name, " +
                "  hr_employee_info.last_Name, " +
                "  hr_employee_info.hire_Date, " +
                "  hr_employee_info.salary, " +
                "  hr_employee_info.OFFICE_OR_SHIFT, " +
                "  hr_employee_info.EMPLOYMENTTYPE, " +
                "  hr_employee_info.Date_Of_Birth, " +
                "  hr_employee_info.marital_Status, " +
                "  hr_employee_info.PHOTO, " +
                "  hr_employee_info.sex, " +
                "  hr_employee_info.retirement_no, " +
                "  hr_employee_info.emp_Status, " +
                "  hr_employee_info.job_Code, " +
                "  hr_employee_info.RELIGION, " +
                "  hr_lu_job_type.JOB_DESCRIPTION, " +
                "  hr_lu_job_type.JOB_NAME, " +
                "  hr_lu_rank.RANK_DESCRIPTION, " +
                "  hr_lu_title.title_description, " +
                "  hr_lu_title.TYPE, " +
                "  hr_lu_nationality.nationalitydescription, " +
                "  hr_lu_nation.description , " +
                "  hr_employee_info.LEAVESTARTFROM, " +
                "  hr_employee_info.TIN_NUMBER, " +
                "  Hr_Employee_Info.Location, " +
                "  de.dep_description " +
                " FROM hr_employee_info, " +
                "  hr_lu_job_type, " +
                "  hr_lu_rank, " +
                "  hr_lu_title, " +
                "  hr_lu_nationality, " +
                "  Hr_Lu_Nation , " +
                " TBL_DEPT_BUNNA de " +
                " WHERE hr_lu_job_type.job_code      = hr_employee_info.job_Code " +
                " AND hr_lu_rank.rank_id             =hr_employee_info.rank_id " +
                 "AND hr_lu_title.title_id           =hr_employee_info.title " +
                " AND Hr_Lu_Nationality.Nationalityid=Hr_Employee_Info.Nationality " +
                " AND Hr_Lu_Nation.Nation_Code       =Hr_Employee_Info.Nation_Code " +
                " AND hr_employee_info.department_id = de.dept_id   and " +
                "  hr_employee_info.emp_Id='"+empID+"'";


        ResultSet rsName;

        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement psCanName = _conn.prepareStatement(newTest);
            ArrayList<HashMap> readEmployeeInfo = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            rsName = psCanName.executeQuery();
            ocrs1.populate(rsName);
            // JOptionPane.showMessageDialog(null, ocrs1.size());
            while ((ocrs1.next())) {
                String test;
                HashMap hm = new HashMap();
                HashMap hm1 = new HashMap();
                hm.put("TITLE", (ocrs1.getString("title_description")));
                hm.put("empid", (ocrs1.getString("emp_id")));
                hm.put("FULLNAME", (ocrs1.getString("first_Name")+" "+ocrs1.getString("middle_Name"))+" "+ocrs1.getString("last_Name"));
               // hm.put("ADDRESS", (ocrs1.getString("ADDRESS")));
                hm.put("GENDER", (ocrs1.getString("sex")));
                hm.put("DATEOFBIRTH", (ocrs1.getString("Date_Of_Birth")));
                hm.put("MARITALSTATUS", (ocrs1.getString("marital_Status")));
                hm.put("PENSIONNO", (ocrs1.getString("TIN_NUMBER")));
                hm.put("RELIGION", (ocrs1.getString("RELIGION")));
                hm.put("NATIONALITY", (ocrs1.getString("nationalitydescription")));
                hm.put("NATION", (ocrs1.getString("description")));
                hm.put("HIREDATE", (ocrs1.getString("hire_Date")));
                hm.put("DEPARTMENT", (ocrs1.getString("dep_description")));
                hm.put("JOBTITLE", (ocrs1.getString("JOB_NAME")));
                hm.put("SALARY", (ocrs1.getString("salary")));
                hm.put("RANKID", (ocrs1.getString("RANK_ID")));
                hm.put("PAYGRADE", (ocrs1.getString("PAY_GRADE")));
                hm.put("TINNUMBER", (ocrs1.getString("TIN_NUMBER")));
                hm.put("LOCATION", (ocrs1.getString("Location")));
                readEmployeeInfo.add(hm);
            // readCandidateInfo.add(hm1);
            // readCandidateInfo.
            }

            closePooledConnections(_conn);
            return readEmployeeInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        public Collection loadEmployeeEducationInformationForReport(String empID) {
         String newTest = "SELECT HR_EMP_EDUCATION.EMP_ID , " +
                "  HR_EMP_EDUCATION.INSTITUTION, " +
                "  HR_EMP_EDUCATION.EDUC_LEVEL_CODE , " +
                "  HR_EMP_EDUCATION.EDUCATION_TYPE , " +
                "  HR_EMP_EDUCATION.STARTING_DATE , " +
                "  HR_EMP_EDUCATION.COMPLETION_DATE , " +
                "  HR_EMP_EDUCATION.AWARD , " +
                "  HR_EMP_EDUCATION.RESULT , " +
                "  HR_EMP_EDUCATION.PAYMENT_PAYE_BY , " +
                "  HR_EMP_EDUCATION.ID , " +
                "  HR_EMP_EDUCATION.GRADING_SYSTEM, " +
                "  hr_lu_educ_level.DESCRIPTION AS educ_level, " +
                "  HR_LU_EDUC_TYPE.DESCRIPTION  AS EDUC_TYPE " +
                " FROM HR_LU_EDUC_TYPE " +
                " INNER JOIN (hr_lu_educ_level " +
                " INNER JOIN HR_EMP_EDUCATION " +
                " ON hr_lu_educ_level.EDUC_LEVEL_CODE=HR_EMP_EDUCATION.EDUC_LEVEL_CODE) " +
                " ON HR_LU_EDUC_TYPE.EDUC_TYPE_CODE  =HR_EMP_EDUCATION.EDUCATION_TYPE   WHERE emp_Id='"+empID+"'";


        ResultSet rsName;

        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement psCanName = _conn.prepareStatement(newTest);
            ArrayList<HashMap> readEmployeeInfo = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            rsName = psCanName.executeQuery();
            ocrs1.populate(rsName);
            // JOptionPane.showMessageDialog(null, ocrs1.size());
            while ((ocrs1.next())) {
                String test;
                HashMap hm = new HashMap();
                HashMap hm1 = new HashMap();
                hm.put("INSTITUTION", (ocrs1.getString("INSTITUTION")));
                hm.put("EDUCATIONTYPE", (ocrs1.getString("EDUCATION_TYPE")));
                hm.put("STARTINGDATE", (ocrs1.getString("STARTING_DATE")));
                hm.put("COMPLETIONDATE", (ocrs1.getString("COMPLETION_DATE")));
                hm.put("AWARD", (ocrs1.getString("AWARD")));
                hm.put("RESULT", (ocrs1.getString("RESULT")));
                hm.put("EDUCATIONLEVEL", (ocrs1.getString("educ_level")));
                hm.put("EDUCATIONTYPE", (ocrs1.getString("EDUC_TYPE")));
         
                readEmployeeInfo.add(hm);
            // readCandidateInfo.add(hm1);
            // readCandidateInfo.
            }

            closePooledConnections(_conn);
            return readEmployeeInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


        public Collection loadEmployeeExpiranceReport(String empID) {
         String newTest ="SELECT EX.EMP_ID, " +
                "  EX.INSTITUION, " +
                "  EX.START_DATE, " +
                "  EX.END_DATE, " +
                "  EX.JOB_TITLE, " +
                "  NVL(EX.RESPONSIBILITY,'not register') AS RESPONSIBILITY , " +
                "  EX.SALARY, " +
                "  NVL(EX.REASON_FOR_TERMINATION ,'not register') AS REASON_FOR_TERMINATION, " +
                "  EX.RANK, " +
                "  EX.ID, " +
                "  NVL(EX.PRIVATE_OR_GVTAL ,'not register')          AS PRIVATE_OR_GVTAL, " +
                "  NVL(EX.PERMANENT_OR_CONTRACT ,'not register')     AS PERMANENT_OR_CONTRACT, " +
                "  NVL(EX.USETHISEXPERIENCEFORLEAVE ,'not register') AS USETHISEXPERIENCEFORLEAVE, " +
                "  NVL(EX.PROFESSIONINMUGHER ,'not register')        AS PROFESSIONINMUGHER , " +
                "  NVL(JT.JOB_NAME ,'not register')           AS JOB_NAME " +
                "FROM HR_EMP_EXPERIENCE EX, " +
                "  HR_LU_JOB_TYPE JT " +
                "WHERE EX.EMP_ID='"+empID+"' " +
                "AND EX.PROFESSIONINMUGHER=JT.JOB_CODE(+)";


        ResultSet rsName;

        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement psCanName = _conn.prepareStatement(newTest);
            ArrayList<HashMap> readEmployeeInfo = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            rsName = psCanName.executeQuery();
            ocrs1.populate(rsName);
            // JOptionPane.showMessageDialog(null, ocrs1.size());
            while ((ocrs1.next())) {
                String test;
                HashMap hm = new HashMap();
                HashMap hm1 = new HashMap();
                hm.put("INSTITUION", (ocrs1.getString("INSTITUION")));
                hm.put("STARTDATE", (ocrs1.getString("START_DATE")));
                hm.put("ENDDATE", (ocrs1.getString("END_DATE")));
                hm.put("JOBTITLE", (ocrs1.getString("JOB_TITLE")));
                hm.put("SALARY", (ocrs1.getString("SALARY")));
                hm.put("RANK", (ocrs1.getString("RANK")));
                hm.put("PRIGOV", (ocrs1.getString("PRIVATE_OR_GVTAL")));
                hm.put("PERTEM", (ocrs1.getString("PERMANENT_OR_CONTRACT")));
                 hm.put("REASOUN", (ocrs1.getString("REASON_FOR_TERMINATION")));

                readEmployeeInfo.add(hm);
            // readCandidateInfo.add(hm1);
            // readCandidateInfo.
            }

            closePooledConnections(_conn);
            return readEmployeeInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         public Collection loadEmployeeTrainingReport(String empID) {
             
         String newTest ="SELECT   NVL(HR_EMP_TRAINING.TRAININGORCOURSE_NAME,'Not Register') AS TRAININGORCOURSE_NAME, " +
                "  NVL(HR_EMP_TRAINING.START_DATE,'Not Register') AS START_DATE, " +
                "  NVL(HR_EMP_TRAINING.END_DATE,'Not Register')   AS END_DATE, " +
                "  HR_EMP_TRAINING.EMP_ID, " +
                "  HR_EMP_TRAINING.ID, " +
                "  NVL(HR_EMP_TRAINING.PAYMENT_PAYE_BY,'Not Register') AS PAYMENT_PAYE_BY, " +
                "  HR_EMP_TRAINING.INSTITUTION, " +
                "  NVL(HR_LU_EDUC_INSTITUTION.INSTITUTION_NAME,'Not Register') AS INSTITUTION_NAME, " +
                "  nvl(DURATION,'not register') as DURATION   " +
                "FROM HR_EMP_TRAINING " +
                "LEFT JOIN HR_LU_EDUC_INSTITUTION " +
                "ON HR_LU_EDUC_INSTITUTION.INSTITUTION_ID = HR_EMP_TRAINING.INSTITUTION " +
                "WHERE EMP_ID='"+ empID +"'" ;


        ResultSet rsName;

        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement psCanName = _conn.prepareStatement(newTest);
            ArrayList<HashMap> readEmployeeInfo = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            rsName = psCanName.executeQuery();
            ocrs1.populate(rsName);
            // JOptionPane.showMessageDialog(null, ocrs1.size());
            while ((ocrs1.next())) {
                String test;
                HashMap hm = new HashMap();
                HashMap hm1 = new HashMap();
                hm.put("TRANINGCOURSNAME", (ocrs1.getString("TRAININGORCOURSE_NAME")));
                hm.put("STARTDATE", (ocrs1.getString("START_DATE")));
                hm.put("ENDDATE", (ocrs1.getString("END_DATE")));
                hm.put("INSTIUTATIONNAME", (ocrs1.getString("INSTITUTION_NAME")));
                hm.put("DURATION", (ocrs1.getString("DURATION")));
                hm.put("SPONSER", (ocrs1.getString("PAYMENT_PAYE_BY")));
              
                readEmployeeInfo.add(hm);
            // readCandidateInfo.add(hm1);
            // readCandidateInfo.
            }

            closePooledConnections(_conn);
            return readEmployeeInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
