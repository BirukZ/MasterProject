/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author DAVEPRO
 */
public class ReportEntity extends ConnectionManager {

    /**
     * <p>Select payroll codes</>
     * @param department
     * @param top
     * @return list of payroll code(OracleCachedRowSet)
     */
    public OracleCachedRowSet selectPayrollCode(String department, int top) {
        String qry = "SELECT PAYROLL_CODE,DATE_CREATED,APPROVED_STATUS" +
                "     FROM ( SELECT PAYROLL_CODE,DATE_CREATED,APPROVED_STATUS, RANK() " +
                "     OVER (ORDER BY DATE_CREATED DESC) SELECTHR_PAYROLL" +
                "           FROM HR_PAYROLL ) " +
                "           WHERE  SUBSTR(PAYROLL_CODE,23)='" + department + "' AND SELECTHR_PAYROLL <= '" + top + "' AND APPROVED_STATUS='1'";
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            Connection con = getConnection();
            _ps = con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public OracleCachedRowSet readDepartmentPathDescription(String departmentName, String departnementId, String employeeId) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String qry = null;
        if (departmentName.equalsIgnoreCase("maindepartment")) {
            qry = "SELECT DEP_DESCRIPTION  FROM  TBL_DEPARTMENT where TBL_DEPARTMENT.DEPT_ID='" + departnementId + "'";
        } else if (departmentName.equalsIgnoreCase("directorate")) {
            qry = "select md.dep_description as MAINDEPARTMENT," +
                    "     dr.dep_description AS DIRECTORATE " +
                    "     from tbl_department md ,tbl_department dr where md.dept_id=" +
                    "     (select distinct department_id from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.directorate='" + departnementId + "') and dr.dept_id='" + departnementId + "'";
        } else if (departmentName.equalsIgnoreCase("division")) {
            qry = "select md.dep_description as MAINDEPARTMENT," +
                    "     dr.dep_description AS DIRECTORATE," +
                    "     di.dep_description AS DIVISION" +
                    "     from tbl_department md ,tbl_department dr,tbl_department di where md.dept_id=" +
                    "     (select distinct department_id from hr_employee_info emp where emp.directorate=" +
                    "     (select distinct directorate from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.division='" + departnementId + "')) and dr.dept_id=" +
                    "     (select distinct directorate from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.division='" + departnementId + "')" +
                    "     and di.dept_id='" + departnementId + "'";
        } else if (departmentName.equalsIgnoreCase("COOPERATIVE")) {
            qry = "select md.dep_description as MAINDEPARTMENT," +
                    "       dr.dep_description AS DIRECTORATE," +
                    "       di.dep_description AS DIVISION," +
                    "       ms.dep_description AS MASTEBABRIYA" +
                    " from tbl_department md ,tbl_department dr,tbl_department di,tbl_department ms where md.dept_id=" +
                    "(select distinct department_id from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.directorate=" +
                    "(select distinct directorate from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.division=" +
                    "(select distinct division from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.mastebabriya='" + departnementId + "'))) " +
                    "and dr.dept_id=(select distinct directorate from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.division=" +
                    "(select distinct division from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.mastebabriya='" + departnementId + "'))" +
                    "and di.dept_id=(select distinct division from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.mastebabriya='" + departnementId + "')" +
                    "and ms.dept_id='" + departnementId + "'";
        } else if (departmentName.equalsIgnoreCase("team")) {
            qry = "select md.dep_description as MAINDEPARTMENT," +
                    "       dr.dep_description AS DIRECTORATE," +
                    "       di.dep_description AS DIVISION," +
                    "       ms.dep_description AS MASTEBABRIYA," +
                    "       tm.dep_description AS TEAM" +
                    " from tbl_department md ,tbl_department dr,tbl_department di,tbl_department ms,tbl_department tm where " +
                    "md.dept_id=" +
                    "(select distinct department_id from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.directorate=" +
                    "(select distinct directorate from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.division=" +
                    "                    (select distinct division from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.mastebabriya=" +
                    "(select distinct mastebabriya from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.team='" + departnementId + "'))))" +
                    "and" +
                    " dr.dept_id=" +
                    " (select distinct directorate from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.division=" +
                    "(select distinct division from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and emp.mastebabriya=" +
                    "(select distinct mastebabriya from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.team='" + departnementId + "')))" +
                    "and" +
                    " di.dept_id=" +
                    " (select distinct division from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.mastebabriya=" +
                    "(select distinct mastebabriya from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.team='" + departnementId + "'))" +
                    "and " +
                    "ms.dept_id=" +
                    "(select distinct mastebabriya from hr_employee_info emp where EMP.EMP_ID='" + employeeId + "' and  emp.team='" + departnementId + "')" +
                    "and " +
                    "tm.dept_id='" + departnementId + "'";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet orcs = new OracleCachedRowSet();
            orcs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return orcs;
        } catch (Exception e) {
            return null;
        }
    }

    public String loadSalaryDelegatedInfo(String employeeId, String date) {
        String _select = "SELECT DLI.DELEGATEE_FNAME,DLI.DELEGATEE_MNAME,DLI.DELEGATEE_LNAME" +
                "      FROM HR_SALARY_DELEGATION DL INNER JOIN HR_SALARY_DELEGATEE_INFO DLI ON" +
                "                                DL.DELEGATEE_ID=DLI.DELEGATEE_ID" +
                "                 WHERE ('" + date + "'||'%'   BETWEEN  SUBSTR(DL.DATE_DELEGATED,1,7)||'%' AND  " +
                "                 SUBSTR(DL.DATE_END,1,7)||'%'" +
                "                 OR '" + date + "'||'%' = SUBSTR(DL.DATE_DELEGATED,1,7)||'%' " +
                "                 OR '" + date + "'||'%' = SUBSTR(DL.DATE_END,1,7)||'%' )" +
                "                 AND DELEGATOR_ID='" + employeeId + "' AND DELEGATION_SATUS='1'";

        Connection _con = null;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            if (ocrs.next()) {
                return ocrs.getString("DELEGATEE_FNAME") + " " + ocrs.getString("DELEGATEE_MNAME") + " " + ocrs.getString("DELEGATEE_LNAME");
            } else {

                return "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet LoadPayroll(String payrollCode, String currentDate) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT" +
                "         P.PAYROLL_CODE AS PAYROLL_CODE," +
                "         EM.EMP_ID AS EMP_ID," +
                "         EM.FIRST_NAME AS FIRST_NAME," +
                "         EM.MIDDLE_NAME AS MIDDLE_NAME," +
                "         EM.LAST_NAME AS LAST_NAME," +
                "         NVL(EM.SALARY,'0.00') AS SALARY," +
                "         T.TITLE_DESCRIPTION AS TITLE_DESCRIPTION," +
                "         EM.CIVIL_TYPE AS CIVIL_TYPE, " +
                "         NVL(A.DIRECTOR,'0.00') AS DIRECTOR, " +
                "         NVL(A.PROFFESSION,'0.00') AS PROFFESSION, " +
                "         NVL(A.PENSION,'0.00') AS P_G_ACCRUAL," +
                "         NVL(A.FOOD,'0.00') AS FOOD," +
                "         NVL(A.LOCATION,'0.00') AS LOCATION, " +
                "         NVL(A.HOUSE,'0.00') AS HOUSE, 	" +
                "         NVL(A.TRANSPORT,'0.00') AS TRANSPORT," +
                "         NVL(A.OTHER,'0.00') AS SALARYOTHER," +
                "         NVL(A.PROFFESION_OTHER,'0.00') AS PROFFESION_OTHER," +
                "         NVL(A.ACCRUAL_TOTAL,'0.00') AS ACCRUAL_TOTAL, " +
                "         NVL(A.CORRECT_SUM,'0.00') AS  AT," +
                "         NVL(PD.PENSION,'0.00') AS P_P_DEDUCTION," +
                "         NVL(PD.CONSTANT_VALUE,'0.00') AS CONSTANT_VALUE," +
                "         NVL(PD.SALARY_COLLECTED,'0.00') AS SALARY_COLLECTED," +
                "         NVL(PD.PROFESSION_COLLECTED,'0.00') AS PROFESSION_COLLECTED," +
                "         NVL(PD.TAX,'0.00') AS TAX," +
                "         NVL(PD.DEDUCTION_TOTAL,'0.00') AS PDEDUCTIONTOTAL," +
                "         NVL((to_number(A.CORRECT_SUM)-to_number(EM.SALARY)) + PD.CORRECT_SUM,'0.00') AS PDT," +
                "         NVL(GD.FINE,'0.00') AS FINE," +
                "         NVL(GD.WEAPONS,'0.00') AS WEAPONS," +
                "         NVL(GD.UNIFORM,'0.00') AS UNIFORM," +
                "         NVL(GD.CAR_COLLISION,'0.00')  AS CAR_COLLISION," +
                "         NVL(GD.TELEPHONE,'0.00') AS TELEPHONE," +
                "         NVL(GD.ELECTRIC,'0.00') AS ELECTRIC," +
                "         NVL(GD.OTHER,'0.00') AS GOTHER," +
                "         NVL(GD.DEDUACTION_TOTAL,'0.00') AS GDEDUCTIONTOTAL," +
                "         NVL(GD.CORRECT_SUM,'0.00') AS GDT," +
                "         NVL(PR.FAMILLY,'0.00')  AS FAMILLY," +
                "         NVL(PR.SAVING,'0.00') AS SAVING, " +
                "         NVL(PR.SPORT,'0.00') AS SPORT," +
                "         NVL(PR.CLUB,'0.00') AS CLUB," +
                "         NVL(PR.HOSPITAL,'0.00') AS HOSPITAL," +
                "         NVL(PR.NEWS_PAPER,'0.00') AS NEWS_PAPER," +
                "         NVL(PR.DEVELOPMENT_FUND,'0.00') AS DEVELOPMENT_FUND," +
                "         NVL(PR.LOAN,'0.00') AS LOAN," +
                "         NVL(GD.GLOAN,'0.00') AS OTHER_LOAN," +
                "         NVL(PR.SAVING_LOAN,'0.00') AS SAVING_LOAN," +
                "         NVL(PR.SAVING_HOLLYDAY_LOAN,'0.00') AS SAVING_HOLLYDAY_LOAN," +
                "         NVL(PR.SAVING_INTREST,'0.00') AS SAVING_INTREST," +
                "         NVL(PR.PR_DEDUCTION_TOTAL,'0.00') AS PR_DEDUCTION_TOTAL," +
                "         NVL(PR.CORRECT_SUM,'0.00') AS PRDT" +
                "         FROM((((((HR_EMPLOYEE_INFO  EM" +
                "         LEFT OUTER JOIN HR_PAYROLL_ACCRUALS A  ON A.EMP_ID = EM.EMP_ID)" +
                "         LEFT OUTER JOIN HR_PAYROLL_DEDUCTIONS PD ON PD.EMP_ID =  EM.EMP_ID)  " +
                "         LEFT OUTER JOIN HR_PAYROLL_GOV_DEDUCTIONS GD ON GD.EMP_ID=PD.EMP_ID )" +
                "         LEFT OUTER JOIN HR_PAYROLL_PR_DEDUCTIONS PR ON PR.EMP_ID = EM.EMP_ID)" +
                "         LEFT OUTER JOIN HR_LU_TITLE T ON T.TITLE_ID=EM.TITLE)" +
                "         LEFT OUTER JOIN HR_PAYROLL  P ON  P.PAYROLL_CODE=A.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=PD.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=GD.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=PR.FOR_PAYROLL_CODE) " +
                "                                       WHERE P.PAYROLL_CODE='" + payrollCode + "' ORDER BY SALARY DESC";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet LoadPayroll2(String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT" +
                "         P.PAYROLL_CODE AS PAYROLL_CODE," +
                "         EM.EMP_ID AS EMP_ID," +
                "         EM.FIRST_NAME AS FIRST_NAME," +
                "         EM.MIDDLE_NAME AS MIDDLE_NAME," +
                "         EM.LAST_NAME AS LAST_NAME," +
                "         NVL(EM.SALARY,'0.00') AS SALARY," +
                "         T.TITLE_DESCRIPTION AS TITLE_DESCRIPTION," +
                "         EM.CIVIL_TYPE AS CIVIL_TYPE, " +
                "         NVL(A.DIRECTOR,'0.00') AS DIRECTOR, " +
                "         NVL(A.PROFFESSION,'0.00') AS PROFFESSION, " +
                "         NVL(A.PENSION,'0.00') AS P_G_ACCRUAL," +
                "         NVL(A.FOOD,'0.00') AS FOOD," +
                "         NVL(A.LOCATION,'0.00') AS LOCATION, " +
                "         NVL(A.HOUSE,'0.00') AS HOUSE, 	" +
                "         NVL(A.TRANSPORT,'0.00') AS TRANSPORT," +
                "         NVL(A.OTHER,'0.00') AS SALARYOTHER," +
                "         NVL(A.PROFFESION_OTHER,'0.00') AS PROFFESION_OTHER," +
                "         NVL(A.ACCRUAL_TOTAL,'0.00') AS ACCRUAL_TOTAL, " +
                "         NVL(A.CORRECT_SUM,'0.00') AS  AT," +
                "         NVL(PD.PENSION,'0.00') AS P_P_DEDUCTION," +
                "         NVL(PD.TAX,'0.00') AS TAX," +
                "         NVL(PD.DEDUCTION_TOTAL,'0.00') AS PDEDUCTIONTOTAL," +
                "         NVL((to_number(A.CORRECT_SUM)-to_number(EM.SALARY)) + PD.CORRECT_SUM,'0.00') AS PDT," +
                "         NVL(GD.FINE,'0.00') AS FINE," +
                "         NVL(GD.WEAPONS,'0.00') AS WEAPONS," +
                "         NVL(GD.UNIFORM,'0.00') AS UNIFORM," +
                "         NVL(GD.CAR_COLLISION,'0.00')  AS CAR_COLLISION," +
                "         NVL(GD.TELEPHONE,'0.00') AS TELEPHONE," +
                "         NVL(GD.ELECTRIC,'0.00') AS ELECTRIC," +
                "         NVL(GD.OTHER,'0.00') AS GOTHER," +
                "         NVL(GD.DEDUACTION_TOTAL,'0.00') AS GDEDUCTIONTOTAL," +
                "         NVL(GD.CORRECT_SUM,'0.00') AS GDT," +
                "         NVL(PR.FAMILLY,'0.00')  AS FAMILLY," +
                "         NVL(PR.SAVING,'0.00') AS SAVING, " +
                "         NVL(PR.SPORT,'0.00') AS SPORT," +
                "         NVL(PR.CLUB,'0.00') AS CLUB," +
                "         NVL(PR.HOSPITAL,'0.00') AS HOSPITAL," +
                "         NVL(PR.NEWS_PAPER,'0.00') AS NEWS_PAPER," +
                "         NVL(PR.DEVELOPMENT_FUND,'0.00') AS DEVELOPMENT_FUND," +
                "         NVL(PR.LOAN,'0.00') AS LOAN," +
                "         NVL(GD.GLOAN,'0.00') AS OTHER_LOAN," +
                "         NVL(PR.SAVING_LOAN,'0.00') AS SAVING_LOAN," +
                "         NVL(PR.SAVING_HOLLYDAY_LOAN,'0.00') AS SAVING_HOLLYDAY_LOAN," +
                "         NVL(PR.SAVING_INTREST,'0.00') AS SAVING_INTREST," +
                "         NVL(PR.PR_DEDUCTION_TOTAL,'0.00') AS PR_DEDUCTION_TOTAL," +
                "         NVL(PR.CORRECT_SUM,'0.00') AS PRDT" +
                "         FROM((((((HR_EMPLOYEE_INFO  EM" +
                "         LEFT OUTER JOIN HR_PAYROLL_ACCRUALS A  ON A.EMP_ID = EM.EMP_ID)" +
                "         LEFT OUTER JOIN HR_PAYROLL_DEDUCTIONS PD ON PD.EMP_ID =  EM.EMP_ID)  " +
                "         LEFT OUTER JOIN HR_PAYROLL_GOV_DEDUCTIONS GD ON GD.EMP_ID=PD.EMP_ID )" +
                "         LEFT OUTER JOIN HR_PAYROLL_PR_DEDUCTIONS PR ON PR.EMP_ID = EM.EMP_ID)" +
                "         LEFT OUTER JOIN HR_LU_TITLE T ON T.TITLE_ID=EM.TITLE)" +
                "         LEFT OUTER JOIN HR_PAYROLL  P ON  P.PAYROLL_CODE=A.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=PD.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=GD.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=PR.FOR_PAYROLL_CODE) " +
                "                                       WHERE P.PAYROLL_CODE='" + payrollCode + "' ORDER BY SALARY DESC";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet LoadPayroll3(String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT" +
                "         P.PAYROLL_CODE AS PAYROLL_CODE," +
                "         EM.EMP_ID AS EMP_ID," +
                "         EM.FIRST_NAME AS FIRST_NAME," +
                "         EM.MIDDLE_NAME AS MIDDLE_NAME," +
                "         EM.LAST_NAME AS LAST_NAME," +
                "         NVL(EM.SALARY,'0.00') AS SALARY," +
                "         T.TITLE_DESCRIPTION AS TITLE_DESCRIPTION," +
                "         EM.CIVIL_TYPE AS CIVIL_TYPE, " +
                "         NVL(A.DIRECTOR,'0.00') AS DIRECTOR, " +
                "         NVL(A.PROFFESSION,'0.00') AS PROFFESSION, " +
                "         NVL(A.PENSION,'0.00') AS P_G_ACCRUAL," +
                "         NVL(A.FOOD,'0.00') AS FOOD," +
                "         NVL(A.LOCATION,'0.00') AS LOCATION, " +
                "         NVL(A.HOUSE,'0.00') AS HOUSE, 	" +
                "         NVL(A.TRANSPORT,'0.00') AS TRANSPORT," +
                "         NVL(A.OTHER,'0.00') AS SALARYOTHER," +
                "         NVL(A.PROFFESION_OTHER,'0.00') AS PROFFESION_OTHER," +
                "         NVL(A.ACCRUAL_TOTAL,'0.00') AS ACCRUAL_TOTAL, " +
                "         NVL(A.CORRECT_SUM,'0.00') AS  AT," +
                "         NVL(PD.PENSION,'0.00') AS P_P_DEDUCTION," +
                "         NVL(PD.TAX,'0.00') AS TAX," +
                "         NVL(PD.DEDUCTION_TOTAL,'0.00') AS PDEDUCTIONTOTAL," +
                "         NVL((to_number(A.CORRECT_SUM)-to_number(EM.SALARY)) + PD.CORRECT_SUM,'0.00') AS PDT," +
                "         NVL(GD.FINE,'0.00') AS FINE," +
                "         NVL(GD.WEAPONS,'0.00') AS WEAPONS," +
                "         NVL(GD.UNIFORM,'0.00') AS UNIFORM," +
                "         NVL(GD.CAR_COLLISION,'0.00')  AS CAR_COLLISION," +
                "         NVL(GD.TELEPHONE,'0.00') AS TELEPHONE," +
                "         NVL(GD.ELECTRIC,'0.00') AS ELECTRIC," +
                "         NVL(GD.OTHER,'0.00') AS GOTHER," +
                "         NVL(GD.DEDUACTION_TOTAL,'0.00') AS GDEDUCTIONTOTAL," +
                "         NVL(GD.CORRECT_SUM,'0.00') AS GDT," +
                "         NVL(PR.FAMILLY,'0.00')  AS FAMILLY," +
                "         NVL(PR.SAVING,'0.00') AS SAVING, " +
                "         NVL(PR.SPORT,'0.00') AS SPORT," +
                "         NVL(PR.CLUB,'0.00') AS CLUB," +
                "         NVL(PR.HOSPITAL,'0.00') AS HOSPITAL," +
                "         NVL(PR.NEWS_PAPER,'0.00') AS NEWS_PAPER," +
                "         NVL(PR.DEVELOPMENT_FUND,'0.00') AS DEVELOPMENT_FUND," +
                "         NVL(PR.LOAN,'0.00') AS LOAN," +
                "         NVL(GD.GLOAN,'0.00') AS OTHER_LOAN," +
                "         NVL(PR.SAVING_LOAN,'0.00') AS SAVING_LOAN," +
                "         NVL(PR.SAVING_HOLLYDAY_LOAN,'0.00') AS SAVING_HOLLYDAY_LOAN," +
                "         NVL(PR.SAVING_INTREST,'0.00') AS SAVING_INTREST," +
                "         NVL(PR.PR_DEDUCTION_TOTAL,'0.00') AS PR_DEDUCTION_TOTAL," +
                "         NVL(PR.CORRECT_SUM,'0.00') AS PRDT" +
                "         FROM((((((HR_EMPLOYEE_INFO  EM" +
                "         LEFT OUTER JOIN HR_PAYROLL_ACCRUALS A  ON A.EMP_ID = EM.EMP_ID)" +
                "         LEFT OUTER JOIN HR_PAYROLL_DEDUCTIONS PD ON PD.EMP_ID =  EM.EMP_ID)  " +
                "         LEFT OUTER JOIN HR_PAYROLL_GOV_DEDUCTIONS GD ON GD.EMP_ID=PD.EMP_ID )" +
                "         LEFT OUTER JOIN HR_PAYROLL_PR_DEDUCTIONS PR ON PR.EMP_ID = EM.EMP_ID)" +
                "         LEFT OUTER JOIN HR_LU_TITLE T ON T.TITLE_ID=EM.TITLE)" +
                "         LEFT OUTER JOIN HR_PAYROLL  P ON  P.PAYROLL_CODE=A.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=PD.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=GD.FOR_PAYROLL_CODE" +
                "                                       AND P.PAYROLL_CODE=PR.FOR_PAYROLL_CODE) " +
                "                                       WHERE P.PAYROLL_CODE='" + payrollCode + "' ORDER BY SALARY DESC";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet LoadPayrollSummeryReportCode(String date) {
        String _select = "SELECT   " +
                "             PAYROLL_CODE, " +
                "             ASSIGNED_EMPLOYEE" +
                "             FROM  HR_PAYROLL WHERE  SUBSTR(PAYROLL_CODE,1,7)  LIKE '" + date + "'";

        ResultSet _rs = null;
        Connection _con = null;
        try {
            _con = getConnection();
            PreparedStatement _ps = _con.prepareStatement(_select);
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet LoadPayrollSummeryReportSingle(String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT" +
                "                        P2.PAYROLL_CODE AS PAYROLL_CODE," +
                "                        EM.EMP_ID AS EMP_ID," +
                "                        EM.FIRST_NAME AS FIRST_NAME," +
                "                        EM.MIDDLE_NAME AS MIDDLE_NAME," +
                "                        EM.LAST_NAME AS LAST_NAME," +
                "                        T.TITLE_DESCRIPTION AS TITLE_DESCRIPTION,   " +
                "                        NVL(EM1.SALARY,'0.00') AS GROSSSALARY," +
                "                        NVL(A.DIRECTOR,'0.00')AS DIRECTOR, " +
                "                        NVL(A.PROFFESSION,'0.00')AS PROFFESSION, " +
                "                        NVL(A.PENSION,'0.00') AS GEVERNMENTPENSIONACCRUAL," +
                "                        NVL(A.FOOD,'0.00') AS FOOD," +
                "                        NVL(A.LOCATION,'0.00') AS LOCATION, " +
                "                        NVL(A.HOUSE,'0.00') AS HOUSE,     " +
                "                        NVL(A.TRANSPORT,'0.00') AS TRANSPORT," +
                "                        NVL(A.OTHER,'0.00') AS SALARYOTHER," +
                "                        NVL(A.PROFFESION_OTHER,'0.00') AS PROFFESION_OTHER, " +
                "                        NVL(A.ACCRUAL_TOTAL,'0.00') AS ACCRUALTOTAL,    " +
                "                        NVL(PD.PENSION,'0.00') AS PENSIONDEDUCTION," +
                "                        NVL(PD.TAX,'0.00') AS TAX,                       " +
                "                        NVL(PD.CONSTANT_VALUE,'0.00') AS CONSTANT_VALUE," +
                "                        NVL(PD.SALARY_COLLECTED,'0.00') AS SALARY_COLLECTED," +
                "                        NVL(PD.PROFESSION_COLLECTED,'0.00') AS PROFESSION_COLLECTED," +
                "                        NVL(PD.DEDUCTION_TOTAL,'0.00') AS DEDUCTIONTOTAL,  " +
                "                        NVL(GD.DEDUACTION_TOTAL,'0.00') AS GOVERNMENTDEDUCTION," +
                "                        NVL(PR.PR_DEDUCTION_TOTAL,'0.00') AS PRIVATEDEDUCTION      " +
                "                               FROM((((((((HR_PAYROLL P " +
                "                         LEFT OUTER JOIN HR_EMPLOYEE_INFO EM ON EM.EMP_ID=P.ASSIGNED_EMPLOYEE)" +
                "                         LEFT OUTER JOIN HR_PAYROLL_ACCRUALS A  ON A.FOR_PAYROLL_CODE = P.PAYROLL_CODE)" +
                "                         LEFT OUTER JOIN HR_PAYROLL_DEDUCTIONS PD ON PD.FOR_PAYROLL_CODE = P.PAYROLL_CODE) " +
                "                         LEFT OUTER JOIN HR_PAYROLL_GOV_DEDUCTIONS GD ON GD.FOR_PAYROLL_CODE=P.PAYROLL_CODE )" +
                "                         LEFT OUTER JOIN HR_PAYROLL_PR_DEDUCTIONS PR ON PR.FOR_PAYROLL_CODE = P.PAYROLL_CODE)   " +
                "                         RIGHT OUTER JOIN HR_EMPLOYEE_INFO EM1  ON A.EMP_ID = EM1.EMP_ID AND PD.EMP_ID=EM1.EMP_ID AND GD.EMP_ID=EM1.EMP_ID AND  PR.EMP_ID = EM1.EMP_ID)" +
                "                         LEFT OUTER JOIN HR_LU_TITLE T ON T.TITLE_ID=EM.TITLE)" +
                "                         LEFT OUTER JOIN HR_PAYROLL  P2 ON  P2.PAYROLL_CODE=A.FOR_PAYROLL_CODE" +
                "                                                       AND P2.PAYROLL_CODE=PD.FOR_PAYROLL_CODE" +
                "                                                       AND P2.PAYROLL_CODE=GD.FOR_PAYROLL_CODE" +
                "                                                       AND P2.PAYROLL_CODE=PR.FOR_PAYROLL_CODE) " +
                "                                                       WHERE P2.PAYROLL_CODE='" + payrollCode + "' ORDER BY  P2.PAYROLL_CODE";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet LoadPayrollSummeryReportALL(String date, String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT" +
                "                        P2.PAYROLL_CODE AS PAYROLL_CODE," +
                "                        EM.EMP_ID AS EMP_ID," +
                "                        EM.FIRST_NAME AS FIRST_NAME," +
                "                        EM.MIDDLE_NAME AS MIDDLE_NAME," +
                "                        EM.LAST_NAME AS LAST_NAME," +
                "                        T.TITLE_DESCRIPTION AS TITLE_DESCRIPTION,   " +
                "                        NVL(EM1.SALARY,'0.00') AS GROSSSALARY," +
                "                        NVL(A.DIRECTOR,'0.00')AS DIRECTOR, " +
                "                        NVL(A.PROFFESSION,'0.00')AS PROFFESSION, " +
                "                        NVL(A.PENSION,'0.00') AS GEVERNMENTPENSIONACCRUAL," +
                "                        NVL(A.FOOD,'0.00') AS FOOD," +
                "                        NVL(A.LOCATION,'0.00') AS LOCATION, " +
                "                        NVL(A.HOUSE,'0.00') AS HOUSE,     " +
                "                        NVL(A.TRANSPORT,'0.00') AS TRANSPORT," +
                "                        NVL(A.OTHER,'0.00') AS SALARYOTHER," +
                "                        NVL(A.PROFFESION_OTHER,'0.00') AS PROFFESION_OTHER, " +
                "                        NVL(A.ACCRUAL_TOTAL,'0.00') AS ACCRUALTOTAL,    " +
                "                        NVL(PD.PENSION,'0.00') AS PENSIONDEDUCTION," +
                "                        NVL(PD.TAX,'0.00') AS TAX,                       " +
                "                       NVL(PD.CONSTANT_VALUE,'0.00') AS CONSTANT_VALUE," +
                "                        NVL(PD.SALARY_COLLECTED,'0.00') AS SALARY_COLLECTED," +
                "                        NVL(PD.PROFESSION_COLLECTED,'0.00') AS PROFESSION_COLLECTED," +
                "                        NVL(PD.DEDUCTION_TOTAL,'0.00') AS DEDUCTIONTOTAL,  " +
                "                        NVL(GD.DEDUACTION_TOTAL,'0.00') AS GOVERNMENTDEDUCTION," +
                "                        NVL(PR.PR_DEDUCTION_TOTAL,'0.00') AS PRIVATEDEDUCTION      " +
                "                               FROM((((((((HR_PAYROLL P " +
                "                         LEFT OUTER JOIN HR_EMPLOYEE_INFO EM ON EM.EMP_ID=P.ASSIGNED_EMPLOYEE)" +
                "                         LEFT OUTER JOIN HR_PAYROLL_ACCRUALS A  ON A.FOR_PAYROLL_CODE = P.PAYROLL_CODE)" +
                "                         LEFT OUTER JOIN HR_PAYROLL_DEDUCTIONS PD ON PD.FOR_PAYROLL_CODE = P.PAYROLL_CODE) " +
                "                         LEFT OUTER JOIN HR_PAYROLL_GOV_DEDUCTIONS GD ON GD.FOR_PAYROLL_CODE=P.PAYROLL_CODE )" +
                "                         LEFT OUTER JOIN HR_PAYROLL_PR_DEDUCTIONS PR ON PR.FOR_PAYROLL_CODE = P.PAYROLL_CODE)   " +
                "                         RIGHT OUTER JOIN HR_EMPLOYEE_INFO EM1  ON A.EMP_ID = EM1.EMP_ID AND PD.EMP_ID=EM1.EMP_ID AND GD.EMP_ID=EM1.EMP_ID AND  PR.EMP_ID = EM1.EMP_ID)" +
                "                         LEFT OUTER JOIN HR_LU_TITLE T ON T.TITLE_ID=EM.TITLE)" +
                "                         LEFT OUTER JOIN HR_PAYROLL  P2 ON  P2.PAYROLL_CODE=A.FOR_PAYROLL_CODE" +
                "                                                       AND P2.PAYROLL_CODE=PD.FOR_PAYROLL_CODE" +
                "                                                       AND P2.PAYROLL_CODE=GD.FOR_PAYROLL_CODE" +
                "                                                       AND P2.PAYROLL_CODE=PR.FOR_PAYROLL_CODE) " +
                "                                                       WHERE SUBSTR(P2.PAYROLL_CODE,1,7) LIKE '" + date + "' AND P2.PAYROLL_CODE='" + payrollCode + "' ORDER BY  P2.PAYROLL_CODE";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet loadFamilyReort(String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT MD.EMPLOYEE_ID," +
                "                EMPT.TITLE_DESCRIPTION ||' '|| EMP.FIRST_NAME ||' '|| EMP.MIDDLE_NAME ||' '|| EMP.LAST_NAME AS EMPLOYEE_FULL_NAME," +
                "                FM.FAMILY_ID," +
                "                FM.FAMILY_FULL_NAME," +
                "                MD.FROM_DATE," +
                "                MD.MONTH," +
                "                MD.AMOUNT," +
                "                MD.DEDUCTION_TYPE" +
                "        FROM  (((HR_PAYROLL_FAMILLY_INFO FM INNER JOIN " +
                "        HR_PAYROLL_MONTHLY_DEDUCTIONS MD ON MD.DEDUCTION_ID=FM.MONTHLY_DEDUCTION_ID)" +
                "        INNER JOIN HR_EMPLOYEE_INFO EMP ON EMP.EMP_ID=MD.EMPLOYEE_ID)" +
                "        INNER JOIN HR_LU_TITLE EMPT ON EMPT.TITLE_ID=EMP.TITLE)" +
                "        WHERE  SUBSTR('" + payrollCode + "',0,7)  BETWEEN  SUBSTR(MD.FROM_DATE,0,7) AND  SUBSTR(MD.MONTH,0,7)";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet loadFundReport(String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT MD.EMPLOYEE_ID," +
                "        EMPT.TITLE_DESCRIPTION ||' '|| EMP.FIRST_NAME ||' '|| EMP.MIDDLE_NAME ||' '|| EMP.LAST_NAME AS EMPLOYEE_FULL_NAME," +
                "        FD.ASSOCIATION_ID, " +
                "        MD.AMOUNT," +
                "        MD.DEDUCTION_TYPE" +
                " FROM  ((( HR_PAYROLL_FUND_INFO FD INNER JOIN " +
                "          HR_PAYROLL_MONTHLY_DEDUCTIONS MD ON MD.DEDUCTION_ID=FD.MONTHLY_DEDUCTION_ID)" +
                "          INNER JOIN HR_EMPLOYEE_INFO EMP ON EMP.EMP_ID=MD.EMPLOYEE_ID)" +
                "          INNER JOIN HR_LU_TITLE EMPT ON EMPT.TITLE_ID=EMP.TITLE)" +
                "          WHERE  SUBSTR('" + payrollCode + "',0,7)  BETWEEN  SUBSTR(MD.FROM_DATE,0,7) AND  SUBSTR(MD.MONTH,0,7)";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public OracleCachedRowSet loadFundReportSummery(String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT   FD.ASSOCIATION_ID," +
                "        SUM(MD.AMOUNT)AS TOTAL" +
                " FROM  ((( HR_PAYROLL_FUND_INFO FD INNER JOIN " +
                "          HR_PAYROLL_MONTHLY_DEDUCTIONS MD ON MD.DEDUCTION_ID=FD.MONTHLY_DEDUCTION_ID)" +
                "          INNER JOIN HR_EMPLOYEE_INFO EMP ON EMP.EMP_ID=MD.EMPLOYEE_ID)" +
                "          INNER JOIN HR_LU_TITLE EMPT ON EMPT.TITLE_ID=EMP.TITLE)" +
                "          WHERE  SUBSTR('" + payrollCode + "',0,7)  BETWEEN  SUBSTR(MD.FROM_DATE,0,7) AND  SUBSTR(MD.MONTH,0,7) " +
                "          GROUP BY FD.ASSOCIATION_ID";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadEmployeesFundSummery(String payrollCode) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = "SELECT  MD.EMPLOYEE_ID," +
                "        EMPT.TITLE_DESCRIPTION ||' '|| EMP.FIRST_NAME ||' '|| EMP.MIDDLE_NAME ||' '|| EMP.LAST_NAME AS EMPLOYEE_FULL_NAME," +
                "        SUM(MD.AMOUNT)AS TOTAL" +
                " FROM  ((( HR_PAYROLL_FUND_INFO FD INNER JOIN " +
                "          HR_PAYROLL_MONTHLY_DEDUCTIONS MD ON MD.DEDUCTION_ID=FD.MONTHLY_DEDUCTION_ID)" +
                "          INNER JOIN HR_EMPLOYEE_INFO EMP ON EMP.EMP_ID=MD.EMPLOYEE_ID)" +
                "          INNER JOIN HR_LU_TITLE EMPT ON EMPT.TITLE_ID=EMP.TITLE)" +
                "          WHERE  SUBSTR('" + payrollCode + "',0,7)  BETWEEN  SUBSTR(MD.FROM_DATE,0,7) AND  SUBSTR(MD.MONTH,0,7) " +
                "          GROUP BY MD.EMPLOYEE_ID, EMPT.TITLE_DESCRIPTION ||' '|| EMP.FIRST_NAME ||' '|| EMP.MIDDLE_NAME ||' '|| EMP.LAST_NAME ";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadMPMemberDetail(String MPID) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = " SELECT * " +
                " FROM HR_MP_INFORMATION, HR_LU_TITLE, HR_LU_NATION " +
                " WHERE " +
                " HR_MP_INFORMATION.TITLE = HR_LU_TITLE.TITLE_ID " +
                " AND " +
                " HR_MP_INFORMATION.NATION_CODE = HR_LU_NATION.NATION_CODE " +
                " AND" +
                " HR_MP_INFORMATION.EMP_ID = '" + MPID + "'";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadMPMemberFamDetail(String MPID) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = " SELECT * " +
                " FROM HR_MP_FAMILY " +
                " WHERE " +
                " HR_MP_FAMILY.EMP_ID = '" + MPID + "'";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadMPMemberAddressDetail(String MPID) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = " SELECT * " +
                " FROM HR_MP_ADDRESS " +
                " WHERE " +
                " HR_MP_ADDRESS.EMP_ID = '" + MPID + "'";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadMPMemberEducationDetail(String MPID) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = " SELECT " +
                " HR_MP_EDUCATION.EMP_ID, HR_MP_EDUCATION.INSTITUTION, HR_MP_EDUCATION.STARTING_DATE," +
                " HR_MP_EDUCATION.COMPLETION_DATE, HR_MP_EDUCATION.AWARD, HR_MP_EDUCATION.RESULT," +
                " HR_LU_EDUC_LEVEL.DESCRIPTION AS ELDESC, HR_LU_EDUC_TYPE.DESCRIPTION AS ETDESC" +
                " FROM " +
                " HR_MP_EDUCATION, HR_LU_EDUC_LEVEL, HR_LU_EDUC_TYPE " +
                " WHERE " +
                " HR_MP_EDUCATION.EMP_ID = '" + MPID + "'" +
                " AND " +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE = HR_MP_EDUCATION.EDUC_LEVEL_CODE" +
                " AND " +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE = HR_MP_EDUCATION.EDUCATION_TYPE ";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadMPMemberLanguageDetail(String MPID) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = " SELECT * " +
                " FROM HR_MP_LANGUAGE " +
                " WHERE " +
                " HR_MP_LANGUAGE.EMP_ID = '" + MPID + "'";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadMPMemberExperienceDetail(String MPID) {
        ResultSet _rs = null;
        Connection _con = null;
        String _select = " SELECT * " +
                " FROM HR_MP_EXPERIENCE " +
                " WHERE " +
                " HR_MP_EXPERIENCE.EMP_ID = '" + MPID + "'";
        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public OracleCachedRowSet loadMPMassReport(String query) {
        ResultSet _rs = null;
        Connection _con = null;
        String nationality = "2";
        String _select = "";

        if (query.equals("")) {
            _select = " SELECT * " +
                    " FROM HR_MP_INFORMATION, HR_LU_TITLE, DESCRIPTION ";
        } else {
            _select = " SELECT * " +
                    " FROM HR_MP_INFORMATION, HR_LU_TITLE, HR_LU_NATION " +
                    " WHERE " +
                    " HR_MP_INFORMATION.TITLE = HR_LU_TITLE.TITLE_ID " +
                    " AND " +
                    " HR_MP_INFORMATION.NATION_CODE = HR_LU_NATION.NATION_CODE " +
                    " AND " +
                    " " + query + " ";
        }


        try {
            _con = getConnection();
            PreparedStatement _ps = null;
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    public String str_date,  end_date;

    public ResultSet getRECURITMENTResultset(String strDate, String endDate) throws SQLException, SQLException {
        String sql = "SELECT emp.first_name " +
                "  ||' ' " +
                "  || emp.middle_name " +
                "  ||' ' " +
                "  || emp.last_name      AS Employee_name, " +
                "  llevel.description    AS education_level , " +
                "  dept. DEP_DESCRIPTION AS work_unit, " +
                "  jobtype. JOB_DESCRIPTION " +
                "  ||' ' " +
                "  ||emp.rank_id AS Jobdiscription , " +
                "  emp. HIRE_DATE, " +
                "  rank. BEGINNING_SALARY AS salary, " +
                "  emp. EMPLOYMENTTYPE " +
                "FROM HR_EMPLOYEE_INFO emp, " +
                "  HR_EMP_EDUCATION , " +
                "  TBL_DEPARTMENT dept, " +
                "  HR_LU_JOB_TYPE jobtype, " +
                "  HR_LU_RANK rank, " +
                "  HR_LU_EDUC_LEVEL llevel " +
                "WHERE emp. EMP_ID                    = HR_EMP_EDUCATION. EMP_ID " +
                "AND HR_EMP_EDUCATION. EDUC_LEVEL_CODE=llevel. EDUC_LEVEL_CODE " +
                "AND emp. DEPARTMENT_ID               =dept. DEPT_ID " +
                "AND emp. RANK_ID                     =rank. RANK_ID " +
                "AND emp.job_code                     = jobtype.job_code " +
                "AND emp. HIRE_DATE BETWEEN ? AND ? ";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        _con = getConnection();
        _ps = _con.prepareStatement(sql);

        _ps.setString(1, strDate);
        _ps.setString(2, endDate);
        str_date = strDate;
        end_date = endDate;
        return _ps.executeQuery();
    }

    public static HashMap getRECURITMENTParameters() {

        HashMap parameters = new HashMap();
        try {
//            Blob blb = ReportManagement.getReportFile(16);
//            byte[] bb = blb.getBytes((long) 1, (int) blb.length());
//            ImageIcon companyLogo = new ImageIcon((byte[]) bb);
            //parameters.put("ReportTitle", "Recuritment Report");
//            parameters.put("EMPLOYEE_NAME", "Employee_name");
//            parameters.put("EDUCATION_LEVEL", "education_level");
//            parameters.put("JOBDESCRIPTION", "Jobdiscription");
//            parameters.put("HIRE_DATE", "HIRE_DATE");
//            parameters.put("SALARY", "salary");
//            parameters.put("EMPLOYMENTTYPE", "EMPLOYMENTTYPE");
//            parameters.put("company_logo", companyLogo.getImage());

//
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return parameters;
    }
    public static HashMap getDESCIPLINEParameters() {

        HashMap parameters = new HashMap();
        try {
//            Blob blb = ReportManagement.getReportFile(16);
//            byte[] bb = blb.getBytes((long) 1, (int) blb.length());
//            ImageIcon companyLogo = new ImageIcon((byte[]) bb);
            //parameters.put("ReportTitle", "Recuritment Report");
//            parameters.put("EMPLOYEE_NAME", "Employee_name");
//            parameters.put("EDUCATION_LEVEL", "education_level");
//            parameters.put("JOBDESCRIPTION", "Jobdiscription");
//            parameters.put("HIRE_DATE", "HIRE_DATE");
//            parameters.put("SALARY", "salary");
//            parameters.put("EMPLOYMENTTYPE", "EMPLOYMENTTYPE");
//            parameters.put("company_logo", companyLogo.getImage());

//
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return parameters;
    }

    public ResultSet getDESCIPLINEesultset(String strDate, String endDate) throws SQLException, SQLException {
        String sql = "SELECT emp.first_name " +
                "  ||' ' " +
                "  || emp.middle_name " +
                "  ||' ' " +
                "  || emp.last_name      AS Employee_name, " +
                "  dept. DEP_DESCRIPTION AS work_unit, " +
                "  issue.DESCRIPTION_OF_OFFENCE, " +
                "  penality.PENALTY_NAME AS penality_Type " +
                "FROM HR_EMPLOYEE_INFO emp, " +
                "  Tbl_department dept, " +
                "  HR_Discipline_issue issue, " +
                "  HR_DISCIPLINE_PROCESSED PROCESSED, " +
                "  HR_LU_PENALTY_TYPE penality " +
                "WHERE issue.offender_id           =emp.emp_id " +
                "AND emp.department_id             =dept.dept_id " +
                "AND issue.discipline_problem_id   =PROCESSED.REQUEST_ID " +
                "AND PROCESSED.NEW_PENALTY_PROPOSED=PENALITY.PENALTY_TYPE_ID " +
                "AND PROCESSED.DECISION            ='6' " +
                "AND SUBSTR(PROCESSED.TIME_STAMP,1,10) BETWEEN ?AND ?";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        _con = getConnection();
        _ps = _con.prepareStatement(sql);

        _ps.setString(1, strDate);
        _ps.setString(2, endDate);
        str_date = strDate;
        end_date = endDate;
        return _ps.executeQuery();
    }
}
