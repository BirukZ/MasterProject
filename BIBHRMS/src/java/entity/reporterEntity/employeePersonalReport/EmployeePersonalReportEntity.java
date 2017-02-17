/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.reporterEntity.employeePersonalReport;

import java.sql.ResultSet;

/**
 *
 * @author jone
 */
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

public class EmployeePersonalReportEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;
    Connection _con2 = null;

    public OracleCachedRowSet loadEmployeeInfoForReport() {

        String selectStatment = null;
        String _selectqueryByID = null;

        if (ReportCriteraManager.allEmployee) {
            selectStatment = "SELECT DISTINCT EP.EMP_ID, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || FIRST_NAME " +
                    "  ||' ' " +
                    "  || MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || LAST_NAME AS FULLNAME, " +
                    "  EP.HIRE_DATE, " +
                    "  EP.DATE_OF_BIRTH, " +
                    "  EP.SALARY, " +
                    "  EP.NATION_CODE, " +
                    "  EP.MARITAL_STATUS, " +
                    "  EP.SEX, " +
                    "  EP.RANK_ID, " +
                    "  EP.PAY_GRADE, " +
                    "  EP.JOB_CODE, " +
                    "  EP.RETIREMENT_NO, " +
                    "  EP.EMP_STATUS, " +
                    "  EP.DEPARTMENT_ID, " +
                    "  NVL(EP.TIN_NUMBER,'Not Registered') AS TIN_NUMBER, " +
                    "  EP.OFFICE_OR_SHIFT, " +
                    "  EP.EMPLOYMENTTYPE, " +
                    "  NVL(EP.RELIGION,'NotRegistered') AS RELIGION, " +
                    "  NA.DESCRIPTION                   AS NATIONALITY, " +
                    "  JT.JOB_DESCRIPTION, " +
                    "  JT.JOB_NAME, " +
                    "  DEP.DEP_DESCRIPTION , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)AS AGE, " +
                    "  NVL(ET.DESCRIPTION,'not register')                     AS EDUCATIONTYPE, " +
                    "  NVL(EL.DESCRIPTION,'not register')                     AS EDUCATIONLEAVE , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.HIRE_DATE,1,4)    AS INSIDEeXPRIANCE " +
                    " FROM HR_EMPLOYEE_INFO EP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_LU_NATION NA, " +
                    "  TBL_DEPT_BUNNA DEP, " +
                    "  HR_LU_JOB_TYPE JT , " +
                    "  HR_EMP_EDUCATION ED, " +
                    "  HR_LU_EDUC_TYPE ET, " +
                    "  HR_LU_EDUC_LEVEL EL " +
                    "WHERE EP.TITLE        =TI.TITLE_ID " +
                    "AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    "AND EP.NATION_CODE    =NA.NATION_CODE " +
                    "AND EP.JOB_CODE       =JT.JOB_CODE " +
                    "AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    "AND EP.EMP_ID         =ED.EMP_ID(+) " +
                    "AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                    "AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+)";


        } else if (!ReportCriteraManager.allEmployee) {
            selectStatment = "SELECT DISTINCT EP.EMP_ID, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || FIRST_NAME " +
                    "  ||' ' " +
                    "  || MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || LAST_NAME AS FULLNAME, " +
                    "  EP.HIRE_DATE, " +
                    "  EP.DATE_OF_BIRTH, " +
                    "  EP.SALARY, " +
                    "  EP.NATION_CODE, " +
                    "  EP.MARITAL_STATUS, " +
                    "  EP.SEX, " +
                    "  EP.RANK_ID, " +
                    "  EP.PAY_GRADE, " +
                    "  EP.JOB_CODE, " +
                    "  EP.RETIREMENT_NO, " +
                    "  EP.EMP_STATUS, " +
                    "  EP.DEPARTMENT_ID, " +
                    "  NVL(EP.TIN_NUMBER,'Not Registered') AS TIN_NUMBER, " +
                    "  EP.OFFICE_OR_SHIFT, " +
                    "  EP.EMPLOYMENTTYPE, " +
                    "  NVL(EP.RELIGION,'NotRegistered') AS RELIGION, " +
                    "  NA.DESCRIPTION                   AS NATIONALITY, " +
                    "  JT.JOB_DESCRIPTION, " +
                    "  JT.JOB_NAME, " +
                    "  DEP.DEP_DESCRIPTION , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)AS AGE, " +
                    "  NVL(ET.DESCRIPTION,'not register')                     AS EDUCATIONTYPE, " +
                    "  NVL(EL.DESCRIPTION,'not register')                     AS EDUCATIONLEAVE , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.HIRE_DATE,1,4)    AS INSIDEeXPRIANCE " +
                    " FROM HR_EMPLOYEE_INFO EP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_LU_NATION NA, " +
                    "  TBL_DEPT_BUNNA DEP, " +
                    "  HR_LU_JOB_TYPE JT , " +
                    "  HR_EMP_EDUCATION ED, " +
                    "  HR_LU_EDUC_TYPE ET, " +
                    "  HR_LU_EDUC_LEVEL EL " +
                    "WHERE EP.TITLE        =TI.TITLE_ID " +
                    "AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    "AND EP.NATION_CODE    =NA.NATION_CODE " +
                    "AND EP.JOB_CODE       =JT.JOB_CODE " +
                    "AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    "AND EP.EMP_ID         =ED.EMP_ID(+) " +
                    "AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                    "AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+)" +
                    "and EP.emp_id='" + ReportCriteraManager.getEmployeeId() + "'";


        }
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectStatment);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public OracleCachedRowSet loadProbationEmployeeInfoForReport() {

        String selectStatment = null;
        String _selectqueryByID = null;

        if (ReportCriteraManager.allEmployee)
        {
            selectStatment = " SELECT DISTINCT EP.EMP_ID, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || FIRST_NAME " +
                    "  ||' ' " +
                    "  || MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || LAST_NAME AS FULLNAME, " +
                    "  EP.HIRE_DATE, " +
                    "  EP.SALARY, " +
                    "  EP.MARITAL_STATUS, " +
                    "  EP.SEX, " +
                    "  EP.RANK_ID, " +
                    "  EP.PAY_GRADE, " +
                    "  EP.JOB_CODE, " +
                    "  EP.RETIREMENT_NO, " +
                    "  EP.EMP_STATUS, " +
                    "  EP.DEPARTMENT_ID, " +
                    "  EP.OFFICE_OR_SHIFT, " +
                    "  EP.EMPLOYMENTTYPE, " +
                    "  JT.JOB_NAME, " +
                    "  DEP.DEP_DESCRIPTION , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)  AS AGE, " + 
                    "  ROUND ((sysdate) - to_date(EP.HIRE_DATE,'YYYY-MM-DD'),0) AS INSIDEeXPRIANCE " +
                    " FROM HR_EMPLOYEE_INFO EP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_LU_NATION NA, " +
                    "  TBL_DEPT_BUNNA DEP, " +
                    "  HR_LU_JOB_TYPE JT , " +
                    "  HR_EMP_EDUCATION ED, " +
                    "  HR_LU_EDUC_TYPE ET, " +
                    "  HR_LU_EDUC_LEVEL EL " +
                    " WHERE EP.TITLE        =TI.TITLE_ID " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.NATION_CODE    =NA.NATION_CODE " +
                    " AND EP.JOB_CODE       =JT.JOB_CODE " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.EMP_ID         =ED.EMP_ID(+) " +
                    " AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                    " AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+) ";


        } else if (!ReportCriteraManager.allEmployee) {
            selectStatment = " SELECT DISTINCT EP.EMP_ID, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || FIRST_NAME " +
                    "  ||' ' " +
                    "  || MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || LAST_NAME AS FULLNAME, " +
                    "  EP.HIRE_DATE, " +
                    "  EP.SALARY, " +
                    "  EP.MARITAL_STATUS, " +
                    "  EP.SEX, " +
                    "  EP.RANK_ID, " +
                    "  EP.PAY_GRADE, " +
                    "  EP.JOB_CODE, " +
                    "  EP.RETIREMENT_NO, " +
                    "  EP.EMP_STATUS, " +
                    "  EP.DEPARTMENT_ID, " +
                    "  EP.OFFICE_OR_SHIFT, " +
                    "  EP.EMPLOYMENTTYPE, " +
                    "  JT.JOB_NAME, " +
                    "  DEP.DEP_DESCRIPTION , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)  AS AGE, " +
                    "  ROUND ((sysdate) - to_date(EP.HIRE_DATE,'YYYY-MM-DD'),0) AS INSIDEeXPRIANCE " +
                    " FROM HR_EMPLOYEE_INFO EP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_LU_NATION NA, " +
                    "  TBL_DEPT_BUNNA DEP, " +
                    "  HR_LU_JOB_TYPE JT , " +
                    "  HR_EMP_EDUCATION ED, " +
                    "  HR_LU_EDUC_TYPE ET, " +
                    "  HR_LU_EDUC_LEVEL EL " +
                    " WHERE EP.TITLE        =TI.TITLE_ID " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.NATION_CODE    =NA.NATION_CODE " +
                    " AND EP.JOB_CODE       =JT.JOB_CODE " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.EMP_ID         =ED.EMP_ID(+) " +
                    " AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                    " AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+)" +
                    " and EP.emp_id='" + ReportCriteraManager.getEmployeeId() + "'";

        }
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectStatment);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public OracleCachedRowSet loadProbationEmployeeForManagementInfoForReport() {

        String selectStatment = null;
        String _selectqueryByID = null;

        if (ReportCriteraManager.allEmployee)
        {
            selectStatment = " SELECT DISTINCT EP.EMP_ID, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || FIRST_NAME " +
                    "  ||' ' " +
                    "  || MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || LAST_NAME AS FULLNAME, " +
                    "  EP.HIRE_DATE, " +
                    "  EP.SALARY, " +
                    "  EP.MARITAL_STATUS, " +
                    "  EP.SEX, " +
                    "  EP.RANK_ID, " +
                    "  EP.PAY_GRADE, " +
                    "  EP.JOB_CODE, " +
                    "  EP.RETIREMENT_NO, " +
                    "  EP.EMP_STATUS, " +
                    "  EP.DEPARTMENT_ID, " +
                    "  EP.OFFICE_OR_SHIFT, " +
                    "  EP.EMPLOYMENTTYPE, " +
                    "  JT.JOB_NAME, " +
                    "  JT.JOB_LEVEL, " +
                    "  DEP.DEP_DESCRIPTION , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)  AS AGE, " + 
                    "  ROUND ((sysdate) - to_date(EP.HIRE_DATE,'YYYY-MM-DD'),0) AS INSIDEeXPRIANCE " +
                    " FROM HR_EMPLOYEE_INFO EP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_LU_NATION NA, " +
                    "  TBL_DEPT_BUNNA DEP, " +
                    "  HR_LU_JOB_TYPE JT , " +
                    "  HR_EMP_EDUCATION ED, " +
                    "  HR_LU_EDUC_TYPE ET, " +
                    "  HR_LU_EDUC_LEVEL EL " +
                    " WHERE EP.TITLE        =TI.TITLE_ID " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.NATION_CODE    =NA.NATION_CODE " +
                    " AND EP.JOB_CODE       =JT.JOB_CODE " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.EMP_ID         =ED.EMP_ID(+) " +
                    " AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                    " AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+) ";


        } else if (!ReportCriteraManager.allEmployee) {
            selectStatment = " SELECT DISTINCT EP.EMP_ID, " +
                    "  TI.TITLE_DESCRIPTION " +
                    "  ||' ' " +
                    "  || FIRST_NAME " +
                    "  ||' ' " +
                    "  || MIDDLE_NAME " +
                    "  ||' ' " +
                    "  || LAST_NAME AS FULLNAME, " +
                    "  EP.HIRE_DATE, " +
                    "  EP.SALARY, " +
                    "  EP.MARITAL_STATUS, " +
                    "  EP.SEX, " +
                    "  EP.RANK_ID, " +
                    "  EP.PAY_GRADE, " +
                    "  EP.JOB_CODE, " +
                    "  EP.RETIREMENT_NO, " +
                    "  EP.EMP_STATUS, " +
                    "  EP.DEPARTMENT_ID, " +
                    "  EP.OFFICE_OR_SHIFT, " +
                    "  EP.EMPLOYMENTTYPE, " +
                    "  JT.JOB_NAME, " +
                    "  JT.JOB_LEVEL, " +
                    "  DEP.DEP_DESCRIPTION , " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)  AS AGE, " +
                    "  ROUND ((sysdate) - to_date(EP.HIRE_DATE,'YYYY-MM-DD'),0) AS INSIDEeXPRIANCE " +
                    " FROM HR_EMPLOYEE_INFO EP, " +
                    "  HR_LU_TITLE TI, " +
                    "  HR_LU_NATION NA, " +
                    "  TBL_DEPT_BUNNA DEP, " +
                    "  HR_LU_JOB_TYPE JT , " +
                    "  HR_EMP_EDUCATION ED, " +
                    "  HR_LU_EDUC_TYPE ET, " +
                    "  HR_LU_EDUC_LEVEL EL " +
                    " WHERE EP.TITLE        =TI.TITLE_ID " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.NATION_CODE    =NA.NATION_CODE " +
                    " AND EP.JOB_CODE       =JT.JOB_CODE " +
                    " AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                    " AND EP.EMP_ID         =ED.EMP_ID(+) " +
                    " AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                    " AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+)" +
                    " and EP.emp_id='" + ReportCriteraManager.getEmployeeId() + "'";

        }
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectStatment);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


     




}
