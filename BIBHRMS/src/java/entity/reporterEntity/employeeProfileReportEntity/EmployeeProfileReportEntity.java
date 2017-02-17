/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.reporterEntity.employeeProfileReportEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author PROJECT
 */
public class EmployeeProfileReportEntity extends ConnectionManager {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;

    public ArrayList<HashMap> selectEmployeeProfile() {
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        String selectStatment =
                "SELECT EP.EMP_ID, " +
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
                "  DEP.DEP_DESCRIPTION , " +
                "  NVL(LUL.DESCRIPTION,'not registred')                   AS LANGUAGEDESCRIPTION , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)AS AGE , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.HIRE_DATE,1,4)    AS INSIDEeXPRIANCE " +
                "FROM HR_EMPLOYEE_INFO EP, " +
                "  HR_LU_TITLE TI, " +
                "  HR_LU_NATION NA, " +
                "  TBL_DEPARTMENT DEP, " +
                "  HR_LU_JOB_TYPE JT , " +
                "  HR_EMP_LANGUAGE LA, " +
                "  HR_LU_LANGUAGE LUL " +
                "WHERE EP.TITLE      =TI.TITLE_ID " +
                "AND EP.NATION_CODE  =NA.NATION_CODE " +
                "AND EP.JOB_CODE     =JT.JOB_CODE " +
                "AND EP.DEPARTMENT_ID=DEP.DEPT_ID " +
                "AND EP.EMP_ID       =LA.EMP_ID(+) " +
                "AND LA.LANGUAGE_CODE=LUL.LANGUAGE_CODE(+) " +
                "ORDER BY EP.EMP_ID";







//                "SELECT EP.EMP_ID, " +
//                "  TI.TITLE_DESCRIPTION " +
//                "  ||' ' " +
//                "  || FIRST_NAME " +
//                "  ||' ' " +
//                "  || MIDDLE_NAME " +
//                "  ||' ' " +
//                "  || LAST_NAME AS FULLNAME, " +
//                "  EP.HIRE_DATE, " +
//                "  EP.DATE_OF_BIRTH, " +
//                "  EP.SALARY, " +
//                "  EP.NATION_CODE, " +
//                "  EP.MARITAL_STATUS, " +
//                "  EP.SEX, " +
//                "  EP.RANK_ID, " +
//                "  EP.PAY_GRADE, " +
//                "  EP.JOB_CODE, " +
//                "  EP.RETIREMENT_NO, " +
//                "  EP.EMP_STATUS, " +
//                "  EP.DEPARTMENT_ID, " +
//                "  NVL(EP.TIN_NUMBER,'Not Registered') AS TIN_NUMBER, " +
//                "  EP.OFFICE_OR_SHIFT, " +
//                "  EP.EMPLOYMENTTYPE, " +
//                "  NVL(EP.RELIGION,'NotRegistered') AS RELIGION, " +
//                "  NA.DESCRIPTION                   AS NATIONALITY, " +
//                "  JT.JOB_DESCRIPTION, " +
//                "  DEP.DEP_DESCRIPTION , " +
//                "  NVL(LUL.DESCRIPTION,'not registred')                   AS LANGUAGEDESCRIPTION , " +
//                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)AS AGE " +
//                "FROM HR_EMPLOYEE_INFO EP, " +
//                "  HR_LU_TITLE TI, " +
//                "  HR_LU_NATION NA, " +
//                "  TBL_DEPARTMENT DEP, " +
//                "  HR_LU_JOB_TYPE JT , " +
//                "  HR_EMP_LANGUAGE LA, " +
//                "  HR_LU_LANGUAGE LUL " +
//                "WHERE EP.TITLE      =TI.TITLE_ID " +
//                "AND EP.NATION_CODE  =NA.NATION_CODE " +
//                "AND EP.JOB_CODE     =JT.JOB_CODE " +
//                "AND EP.DEPARTMENT_ID=DEP.DEPT_ID " +
//                "AND EP.EMP_ID       =LA.EMP_ID(+) " +
//                "AND LA.LANGUAGE_CODE=LUL.LANGUAGE_CODE(+) " +
//                "AND EP.EMP_ID       ='AA/00001' " +
//                "ORDER BY EP.EMP_ID";

//                "SELECT EP.EMP_ID, " +
//                "  TI.TITLE_DESCRIPTION " +
//                "  ||' ' " +
//                "  || FIRST_NAME " +
//                "  ||' ' " +
//                "  || MIDDLE_NAME " +
//                "  ||' ' " +
//                "  || LAST_NAME AS FULLNAME, " +
//                "  EP.HIRE_DATE, " +
//                "  EP.DATE_OF_BIRTH, " +
//                "  EP.SALARY, " +
//                "  EP.NATION_CODE, " +
//                "  EP.MARITAL_STATUS, " +
//                "  EP.SEX, " +
//                "  EP.RANK_ID, " +
//                "  EP.PAY_GRADE, " +
//                "  EP.JOB_CODE, " +
//                "  EP.RETIREMENT_NO, " +
//                "  EP.EMP_STATUS, " +
//                "  EP.DEPARTMENT_ID, " +
//                "  NVL(EP.TIN_NUMBER,'Not Registered') AS TIN_NUMBER, " +
//                "  EP.OFFICE_OR_SHIFT, " +
//                "  EP.EMPLOYMENTTYPE, " +
//                "  NVL(EP.RELIGION,'NotRegistered') AS RELIGION, " +
//                "  NA.DESCRIPTION                   AS NATIONALITY, " +
//                "  JT.JOB_DESCRIPTION, " +
//                "  DEP.DEP_DESCRIPTION , " +
//                "  NVL(LUL.DESCRIPTION,'not registred') AS LANGUAGEDESCRIPTION " +
//                "FROM HR_EMPLOYEE_INFO EP, " +
//                "  HR_LU_TITLE TI, " +
//                "  HR_LU_NATION NA, " +
//                "  TBL_DEPARTMENT DEP, " +
//                "  HR_LU_JOB_TYPE JT , " +
//                "  HR_EMP_LANGUAGE LA, " +
//                "  HR_LU_LANGUAGE LUL " +
//                "WHERE EP.TITLE      =TI.TITLE_ID " +
//                "AND EP.NATION_CODE  =NA.NATION_CODE " +
//                "AND EP.JOB_CODE     =JT.JOB_CODE " +
//                "AND EP.DEPARTMENT_ID=DEP.DEPT_ID " +
//                "AND EP.EMP_ID       =LA.EMP_ID(+) " +
//                "AND LA.LANGUAGE_CODE=LUL.LANGUAGE_CODE(+) " +
//                "AND EP.EMP_ID       ='AA/00001' " +
//                "ORDER BY EP.EMP_ID";



//                "SELECT EP.EMP_ID, " +
//                "  TI.TITLE_DESCRIPTION " +
//                "  ||' ' " +
//                "  || FIRST_NAME " +
//                "  ||' ' " +
//                "  || MIDDLE_NAME " +
//                "  ||' ' " +
//                "  || LAST_NAME AS FULLNAME, " +
//                "  EP.HIRE_DATE, " +
//                "  EP.DATE_OF_BIRTH, " +
//                "  EP.SALARY, " +
//                "  EP.NATION_CODE, " +
//                "  EP.MARITAL_STATUS, " +
//                "  EP.SEX, " +
//                "  EP.RANK_ID, " +
//                "  EP.PAY_GRADE, " +
//                "  EP.JOB_CODE, " +
//                "  EP.RETIREMENT_NO, " +
//                "  EP.EMP_STATUS, " +
//                "  EP.DEPARTMENT_ID, " +
//                "  NVL(EP.TIN_NUMBER,'Not Registered') AS TIN_NUMBER, " +
//                "  EP.OFFICE_OR_SHIFT, " +
//                "  EP.EMPLOYMENTTYPE, " +
//                "  nvl(EP.RELIGION,'NotRegistered') AS RELIGION, " +
//                "  NA.DESCRIPTION AS NATIONALITY, " +
//                "  JT.JOB_DESCRIPTION, " +
//                "  DEP.DEP_DESCRIPTION " +
//                "FROM HR_EMPLOYEE_INFO EP, " +
//                "  HR_LU_TITLE TI, " +
//                "  HR_LU_NATION NA, " +
//                "  TBL_DEPARTMENT DEP, " +
//                "  HR_LU_JOB_TYPE JT " +
//                "WHERE EP.TITLE      =TI.TITLE_ID " +
//                "AND EP.NATION_CODE  =NA.NATION_CODE " +
//                "AND EP.JOB_CODE     =JT.JOB_CODE " +
//                "AND EP.DEPARTMENT_ID=DEP.DEPT_ID ";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("HIRE_DATE", rs.getString("HIRE_DATE"));
                hm.put("DATE_OF_BIRTH", rs.getString("DATE_OF_BIRTH"));
                hm.put("SALARY", rs.getString("SALARY"));
                hm.put("NATION_CODE", rs.getString("NATION_CODE"));
                hm.put("MARITAL_STATUS", rs.getString("MARITAL_STATUS"));
                hm.put("SEX", rs.getString("SEX"));
                hm.put("RANK_ID", rs.getString("RANK_ID"));
                hm.put("PAY_GRADE", rs.getString("PAY_GRADE"));
                hm.put("JOB_CODE", rs.getString("JOB_CODE"));
                hm.put("RETIREMENT_NO", rs.getString("RETIREMENT_NO"));
                hm.put("NATIONALITY", rs.getString("NATIONALITY"));
                hm.put("EMP_STATUS", rs.getString("EMP_STATUS"));
                hm.put("DEPARTMENT_ID", rs.getString("DEPARTMENT_ID"));
                hm.put("TIN_NUMBER", rs.getString("TIN_NUMBER"));
                hm.put("OFFICE_OR_SHIFT", rs.getString("OFFICE_OR_SHIFT"));
                hm.put("EMPLOYMENTTYPE", rs.getString("EMPLOYMENTTYPE"));
                hm.put("JOB_DESCRIPTION", rs.getString("JOB_DESCRIPTION"));
                hm.put("DEP_DESCRIPTION", rs.getString("DEP_DESCRIPTION"));
                hm.put("LANGUAGEDESCRIPTION", rs.getString("LANGUAGEDESCRIPTION"));
                hm.put("AGE", rs.getString("AGE"));
                hm.put("INSIDEEXPRIANCE", rs.getString("INSIDEeXPRIANCE"));






                if (rs.getString("RELIGION").toString().equals("CR_OR")) {
                    hm.put("RELIGION", "Orthodox");
                } else if (rs.getString("RELIGION").toString().equals("CR_PR")) {
                    hm.put("RELIGION", "Protestant");
                } else if (rs.getString("RELIGION").toString().equals("CR_CT")) {
                    hm.put("RELIGION", "Catholic");
                } else if (rs.getString("RELIGION").toString().equals("CR_JH")) {
                    hm.put("RELIGION", "Jhovah");
                } else if (rs.getString("RELIGION").toString().equals("MS_MS")) {
                    hm.put("RELIGION", "Muslim");
                } else if (rs.getString("RELIGION").toString().equals("XX_XX")) {
                    hm.put("RELIGION", "Other");
                } else {
                    hm.put("RELIGION", rs.getString("RELIGION"));
                }



                listOfEmployee.add(hm);
            }

            return listOfEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> selectEmployeeEducationList() {
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        String selectStatment = "SELECT EP.EMP_ID, " +
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
                "  DEP.DEP_DESCRIPTION , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)AS AGE, " +
                "  NVL(ET.DESCRIPTION,'not register')                                         AS EDUCATIONTYPE, " +
                "  NVL(EL.DESCRIPTION,'not register')                                         AS EDUCATIONLEAVE " +
                "FROM HR_EMPLOYEE_INFO EP, " +
                "  HR_LU_TITLE TI, " +
                "  HR_LU_NATION NA, " +
                "  TBL_DEPARTMENT DEP, " +
                "  HR_LU_JOB_TYPE JT , " +
                "  HR_EMP_EDUCATION ED, " +
                "  HR_LU_EDUC_TYPE ET, " +
                "  HR_LU_EDUC_LEVEL EL " +
                "WHERE EP.TITLE        =TI.TITLE_ID " +
                "AND EP.NATION_CODE    =NA.NATION_CODE " +
                "AND EP.JOB_CODE       =JT.JOB_CODE " +
                "AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                "AND EP.EMP_ID         =ED.EMP_ID(+) " +
                "AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                "AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+) " +
                "AND EP.EMP_ID         ='AA/00001' " +
                "ORDER BY EP.EMP_ID";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("HIRE_DATE", rs.getString("HIRE_DATE"));
                hm.put("DATE_OF_BIRTH", rs.getString("DATE_OF_BIRTH"));
                hm.put("SALARY", rs.getString("SALARY"));
                hm.put("NATION_CODE", rs.getString("NATION_CODE"));
                hm.put("MARITAL_STATUS", rs.getString("MARITAL_STATUS"));
                hm.put("SEX", rs.getString("SEX"));
                hm.put("RANK_ID", rs.getString("RANK_ID"));
                hm.put("PAY_GRADE", rs.getString("PAY_GRADE"));
                hm.put("JOB_CODE", rs.getString("JOB_CODE"));
                hm.put("RETIREMENT_NO", rs.getString("RETIREMENT_NO"));
                hm.put("NATIONALITY", rs.getString("NATIONALITY"));
                hm.put("EMP_STATUS", rs.getString("EMP_STATUS"));
                hm.put("DEPARTMENT_ID", rs.getString("DEPARTMENT_ID"));
                hm.put("TIN_NUMBER", rs.getString("TIN_NUMBER"));
                hm.put("OFFICE_OR_SHIFT", rs.getString("OFFICE_OR_SHIFT"));
                hm.put("EMPLOYMENTTYPE", rs.getString("EMPLOYMENTTYPE"));
                hm.put("JOB_DESCRIPTION", rs.getString("JOB_DESCRIPTION"));
                hm.put("DEP_DESCRIPTION", rs.getString("DEP_DESCRIPTION"));
                hm.put("EDUCATIONTYPE", rs.getString("EDUCATIONTYPE"));
                hm.put("EDUCATIONLEAVE", rs.getString("EDUCATIONLEAVE"));
                hm.put("AGE", rs.getString("AGE"));





                if (rs.getString("RELIGION").toString().equals("CR_OR")) {
                    hm.put("RELIGION", "Orthodox");
                } else if (rs.getString("RELIGION").toString().equals("CR_PR")) {
                    hm.put("RELIGION", "Protestant");
                } else if (rs.getString("RELIGION").toString().equals("CR_CT")) {
                    hm.put("RELIGION", "Catholic");
                } else if (rs.getString("RELIGION").toString().equals("CR_JH")) {
                    hm.put("RELIGION", "Jhovah");
                } else if (rs.getString("RELIGION").toString().equals("MS_MS")) {
                    hm.put("RELIGION", "Muslim");
                } else if (rs.getString("RELIGION").toString().equals("XX_XX")) {
                    hm.put("RELIGION", "Other");
                } else {
                    hm.put("RELIGION", rs.getString("RELIGION"));
                }



                listOfEmployee.add(hm);
            }

            return listOfEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet loadEmployeeInfoForReport(String departmentID, String employeeType, String employeeGender, String sortBY) {

        String selectStatment = "SELECT EP.EMP_ID, " +
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
                "  DEP.DEP_DESCRIPTION , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)AS AGE, " +
                "  NVL(ET.DESCRIPTION,'not register')                                         AS EDUCATIONTYPE, " +
                "  NVL(EL.DESCRIPTION,'not register')                                         AS EDUCATIONLEAVE , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.HIRE_DATE,1,4)    AS INSIDEeXPRIANCE " +
                "  FROM HR_EMPLOYEE_INFO EP, " +
                "  HR_LU_TITLE TI, " +
                "  HR_LU_NATION NA, " +
                "  TBL_DEPARTMENT DEP, " +
                "  HR_LU_JOB_TYPE JT , " +
                "  HR_EMP_EDUCATION ED, " +
                "  HR_LU_EDUC_TYPE ET, " +
                "  HR_LU_EDUC_LEVEL EL " +
                "WHERE EP.TITLE        =TI.TITLE_ID " +
                "AND EP.NATION_CODE    =NA.NATION_CODE " +
                "AND EP.JOB_CODE       =JT.JOB_CODE " +
                "AND EP.DEPARTMENT_ID  =DEP.DEPT_ID " +
                "AND EP.EMP_ID         =ED.EMP_ID(+) " +
                "AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                "AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+) " +
                "" + employeeType + employeeGender + sortBY + " ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            return rs;




        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> selectEmployeeTraining() {
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        String selectStatment = "SELECT EP.EMP_ID, " +
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
                "  DEP.DEP_DESCRIPTION , " +
                "  NVL(ET.TRAININGORCOURSE_NAME,'Not Trained')            AS TRAININGORCOURSE_NAME , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.DATE_OF_BIRTH,1,4)AS AGE , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EP.HIRE_DATE,1,4)    AS INSIDEeXPRIANCE " +
                "FROM HR_EMPLOYEE_INFO EP, " +
                "  HR_LU_TITLE TI, " +
                "  HR_LU_NATION NA, " +
                "  TBL_DEPARTMENT DEP, " +
                "  HR_LU_JOB_TYPE JT , " +
                "  HR_EMP_TRAINING ET " +
                "WHERE EP.TITLE      =TI.TITLE_ID " +
                "AND EP.NATION_CODE  =NA.NATION_CODE " +
                "AND EP.JOB_CODE     =JT.JOB_CODE " +
                "AND EP.DEPARTMENT_ID=DEP.DEPT_ID " +
                "AND EP.EMP_ID       =ET.EMP_ID(+) " +
                "ORDER BY EP.EMP_ID";



        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("HIRE_DATE", rs.getString("HIRE_DATE"));
                hm.put("DATE_OF_BIRTH", rs.getString("DATE_OF_BIRTH"));
                hm.put("SALARY", rs.getString("SALARY"));
                hm.put("NATION_CODE", rs.getString("NATION_CODE"));
                hm.put("MARITAL_STATUS", rs.getString("MARITAL_STATUS"));
                hm.put("SEX", rs.getString("SEX"));
                hm.put("RANK_ID", rs.getString("RANK_ID"));
                hm.put("PAY_GRADE", rs.getString("PAY_GRADE"));
                hm.put("JOB_CODE", rs.getString("JOB_CODE"));
                hm.put("RETIREMENT_NO", rs.getString("RETIREMENT_NO"));
                hm.put("NATIONALITY", rs.getString("NATIONALITY"));
                hm.put("EMP_STATUS", rs.getString("EMP_STATUS"));
                hm.put("DEPARTMENT_ID", rs.getString("DEPARTMENT_ID"));
                hm.put("TIN_NUMBER", rs.getString("TIN_NUMBER"));
                hm.put("OFFICE_OR_SHIFT", rs.getString("OFFICE_OR_SHIFT"));
                hm.put("EMPLOYMENTTYPE", rs.getString("EMPLOYMENTTYPE"));
                hm.put("JOB_DESCRIPTION", rs.getString("JOB_DESCRIPTION"));
                hm.put("DEP_DESCRIPTION", rs.getString("DEP_DESCRIPTION"));
                hm.put("TRAININGORCOURSE_NAME", rs.getString("TRAININGORCOURSE_NAME"));
                hm.put("AGE", rs.getString("AGE"));
                hm.put("INSIDEEXPRIANCE", rs.getString("INSIDEeXPRIANCE"));






                if (rs.getString("RELIGION").toString().equals("CR_OR")) {
                    hm.put("RELIGION", "Orthodox");
                } else if (rs.getString("RELIGION").toString().equals("CR_PR")) {
                    hm.put("RELIGION", "Protestant");
                } else if (rs.getString("RELIGION").toString().equals("CR_CT")) {
                    hm.put("RELIGION", "Catholic");
                } else if (rs.getString("RELIGION").toString().equals("CR_JH")) {
                    hm.put("RELIGION", "Jhovah");
                } else if (rs.getString("RELIGION").toString().equals("MS_MS")) {
                    hm.put("RELIGION", "Muslim");
                } else if (rs.getString("RELIGION").toString().equals("XX_XX")) {
                    hm.put("RELIGION", "Other");
                } else {
                    hm.put("RELIGION", rs.getString("RELIGION"));
                }



                listOfEmployee.add(hm);
            }

            return listOfEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> selectEmployeeFamily(String employeeId) {
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        String selectStatment = "SELECT EP.EMP_ID, " +
                "  EP.FIRST_NAME " +
                "  ||' ' " +
                "  || EP.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EP.LAST_NAME AS EMPLOYEEFULLNAME, " +
                "  EF.FIRST_NAME " +
                "  ||' ' " +
                "  || EF.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EF.LAST_NAME AS FAMILYFULLNAME, " +
                "  EF.RELATION_TYPE, " +
                "  EF.SEX, " +
                "  nvl(EF.DATE_OF_BIRTH,'Unknown') AS DATE_OF_BIRTH, " +
                "  EF.ALIVE_OR_DIED " +
                "FROM HR_EMPLOYEE_INFO EP " +
                "INNER JOIN HR_EMP_FAMILY EF " +
                "ON EP.EMP_ID    =EF.EMP_ID " +
                "WHERE EP.EMP_ID ='" + employeeId + "'";



        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("EMPLOYEEFULLNAME"));
                hm.put("FAMILYFULLNAME", rs.getString("FAMILYFULLNAME"));
                hm.put("RELATION_TYPE", rs.getString("RELATION_TYPE"));
                hm.put("SEX", rs.getString("SEX"));
                hm.put("DATE_OF_BIRTH", rs.getString("DATE_OF_BIRTH"));
                if (rs.getString("ALIVE_OR_DIED").toString().equals("YES")) {
                    hm.put("ALIVE_OR_DIED", "YES");
                } else {
                    hm.put("ALIVE_OR_DIED", "NO");
                }



                listOfEmployee.add(hm);
            }

            return listOfEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void readaAlocatedJobForDep() {


        String stm = "SELECT DISTINCT bk.JOB_DESCRIPTION, " +
                "  rank.rank_description, " +
                "  bk.department_path, " +
                "  bk.DEPARTMENT_NAME, " +
                "  jobs.NUMBER_OF_EMPLOYEE, " +
                "  bk.department_id, " +
                "  bk.job_code " +
                "FROM vw_employee_by_department_bk bk " +
                "INNER JOIN hr_dept_job jobs " +
                "ON bk.department_id=jobs.DEPT_ID " +
                "AND bk.JOB_CODE    =jobs.JOB_CODE " +
                "INNER JOIN hr_lu_rank rank " +
                "ON rank.rank_id=bk.rank_id";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(stm);
            rs = ps.executeQuery();
            if (rs == null) {
            } else {
                while (rs.next()) {
                    String n = rs.getString("department_path").substring(2);
                    String depPath[] = n.split(">>");
                    int index = depPath.length;
//                    OrganizationReportManager initiateManager = new OrganizationReportManager();
//                    initiateManager.setDepartmentId(_rs.getString("department_id"));
//                    initiateManager.setDepartmentName(_rs.getString("DEPARTMENT_NAME"));
//                    initiateManager.setJobId(_rs.getString("job_code"));
//                    initiateManager.setJobName(_rs.getString("JOB_DESCRIPTION"));
//                    initiateManager.setRequiredNumber(_rs.getInt("NUMBER_OF_EMPLOYEE"));
//                    initiateManager.setSeraAsfetsami(depPath[1]);
//                    initiateManager.setDept(depPath[1]);
//                    if (depPath.length > 2) {
//                    }
//                    if (index > 2) {
//                    }else if(index == 2){
//                    }
                    if (index < 2) {
                    }
//                    initiateManager.setTeam(depPath[1]);
//                    initiateManager.setLoaction(depPath[1]);
//                    initiateManager.setRank(_rs.getString("rank_description"));
//                    myReturn.add(initiateManager);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    public ArrayList<HashMap> loadEmployeeExprianceReport() {
        ArrayList<HashMap> listOfEmployeeExpr = new ArrayList<HashMap>();
        String selectStatment = "SELECT EP.EMP_ID, " +
                "  EP.FIRST_NAME " +
                "  ||' ' " +
                "  || EP.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EP.LAST_NAME AS FULLNAME, " +
                "  EX.START_DATE, " +
                "  EX.END_DATE, " +
                "  EX.PERMANENT_OR_CONTRACT, " +
                "  EX.PRIVATE_OR_GVTAL, " +
                "  EX.INSTITUION " +
                "FROM HR_EMPLOYEE_INFO EP, " +
                "  HR_EMP_EXPERIENCE EX " +
                "WHERE EP.EMP_ID=EX.EMP_ID " +
                "AND EP.EMP_ID  ='AA/00001' " +
                "ORDER BY EP.EMP_ID, " +
                "  EX.PRIVATE_OR_GVTAL, " +
                "  EX.PERMANENT_OR_CONTRACT";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("START_DATE", rs.getString("START_DATE"));
                hm.put("END_DATE", rs.getString("END_DATE"));
                hm.put("PER_OR_CON", rs.getString("PERMANENT_OR_CONTRACT"));
                hm.put("PRI_OR_GV", rs.getString("PRIVATE_OR_GVTAL"));
                hm.put("INSTITUION", rs.getString("INSTITUION"));
                listOfEmployeeExpr.add(hm);
            }
            return listOfEmployeeExpr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> selectEmployeeEducationDetileList(String employeeId, boolean selectCriteria) {
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        String selectStatment = "SELECT EP.EMP_ID, " +
                "  TI.TITLE_DESCRIPTION " +
                "  ||' ' " +
                "  || FIRST_NAME " +
                "  ||' ' " +
                "  || MIDDLE_NAME " +
                "  ||' ' " +
                "  || LAST_NAME AS FULLNAME, " +
                "  NVL(ET.DESCRIPTION,'not register')                     AS EDUCATIONTYPE, " +
                "  NVL(EL.DESCRIPTION,'not register')                     AS EDUCATIONLEAVE, " +
                "  ED.INSTITUTION, " +
                "  ED.COMPLETION_DATE, " +
                "  ED.RESULT " +
                "FROM HR_EMPLOYEE_INFO EP, " +
                "  HR_LU_TITLE TI, " +
                "  HR_EMP_EDUCATION ED, " +
                "  HR_LU_EDUC_TYPE ET, " +
                "  HR_LU_EDUC_LEVEL EL " +
                "WHERE TI.TITLE_ID     =EP.TITLE " +
                "AND EP.EMP_ID         =ED.EMP_ID " +
                "AND ED.EDUCATION_TYPE =ET.EDUC_TYPE_CODE(+) " +
                "AND ED.EDUC_LEVEL_CODE=EL.EDUC_LEVEL_CODE(+) ";
        if (!selectCriteria) {
            selectStatment += " AND EP.EMP_ID         ='" + employeeId + "' " +
                    " ORDER BY EP.EMP_ID";
        } else {
            selectStatment += " ORDER BY EP.EMP_ID";
        }
        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("EDUCATIONTYPE", rs.getString("EDUCATIONTYPE"));
                hm.put("EDUCATIONLEAVE", rs.getString("EDUCATIONLEAVE"));

                hm.put("INSTITUTION", rs.getString("INSTITUTION"));
                hm.put("COMPLETION_DATE", rs.getString("COMPLETION_DATE"));
                hm.put("RESULT", rs.getString("RESULT"));
                listOfEmployee.add(hm);
            }

            return listOfEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> readFamilyForReport(String employeeID) {
        String select = "SELECT * FROM hr_emp_family WHERE emp_Id=?";
        ArrayList<HashMap> readFamilyInfiormation = new ArrayList<HashMap>();
        ResultSet rsFamily;
        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeID);
            rsFamily = ps.executeQuery();
            ocrs.populate(rsFamily);
            rsFamily.close();
            ps.close();


            while (ocrs.next()) {
                HashMap hm = new HashMap();

                hm.put("fullName", ocrs.getString("FIRST_NAME") + "  " + ocrs.getString("MIDDLE_NAME") + " " + ocrs.getString("LAST_NAME"));
                hm.put("relative", ocrs.getString("RELATION_TYPE"));
                hm.put("sex", ocrs.getString("SEX"));

                hm.put("EMERGENCEY", ocrs.getString("EMERGENCEY_CONTACT"));
                if (ocrs.getString("DATE_OF_BIRTH") != null) {
                    hm.put("DATE_OF_BIRTH", ocrs.getString("DATE_OF_BIRTH"));
                } else {
                    hm.put("DATE_OF_BIRTH", "Not Registered");
                }
                if (ocrs.getString("EMERGENCEY_CONTACT").equals("YES")) {
                    hm.put("emergencyContact", "ነው");
                } else {
                    hm.put("emergencyContact", "አይደለም");
                }
                if (ocrs.getString("HEIR").equals("YES")) {
                    hm.put("HEIR", "ነው");
                } else {
                    hm.put("HEIR", "አይደለም");
                }
                readFamilyInfiormation.add(hm);
            }
            closePooledConnections(_conn);
            return readFamilyInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readEducationForReport(String employeeID) {
        String select = "SELECT HR_EMP_EDUCATION.INSTITUTION, " +
                "               HR_EMP_EDUCATION.STARTING_DATE, " +
                "               HR_EMP_EDUCATION.COMPLETION_DATE, " +
                "               HR_EMP_EDUCATION.AWARD, " +
                "               HR_EMP_EDUCATION.RESULT,        " +
                "               hr_lu_educ_level.DESCRIPTION as EDUCATION_LEVEL, " +
                "               HR_LU_EDUC_TYPE.DESCRIPTION as EDUC_TYPE " +
                "       FROM HR_LU_EDUC_TYPE INNER JOIN (hr_lu_educ_level INNER JOIN HR_EMP_EDUCATION " +
                "               ON hr_lu_educ_level.EDUC_LEVEL_CODE=HR_EMP_EDUCATION.EDUC_LEVEL_CODE) ON " +
                "               HR_LU_EDUC_TYPE.EDUC_TYPE_CODE=HR_EMP_EDUCATION.EDUCATION_TYPE " +
                "      WHERE emp_Id=?";
        ArrayList<HashMap> readEducationInfiormation = new ArrayList<HashMap>();
        ResultSet rsEducation;
        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeID);
            rsEducation = ps.executeQuery();
            ocrs.populate(rsEducation);
            rsEducation.close();
            ps.close();


            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("INSTITUTION", ocrs.getString("INSTITUTION"));
                hm.put("STARTING_DATE", ocrs.getString("STARTING_DATE"));
                hm.put("COMPLETION_DATE", ocrs.getString("COMPLETION_DATE"));
                hm.put("AWARD", ocrs.getString("AWARD"));
                hm.put("RESULT", ocrs.getString("RESULT"));
                hm.put("AWARD", ocrs.getString("AWARD"));
                hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                hm.put("EDUC_TYPE", ocrs.getString("EDUC_TYPE"));
                readEducationInfiormation.add(hm);

            }

            closePooledConnections(_conn);
            return readEducationInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readAddressForReport(String employeeID) {
//        String select = "SELECT distinct  HR_EMP_ADDRESS.ID ," +
//                "                         HR_EMP_ADDRESS.TELEPHONE_RESIDENCE, " +
//                "                         HR_EMP_ADDRESS.TELEPHONE_OFFICE," +
//                "                         HR_EMP_ADDRESS.MOBILE," +
//                "                         HR_EMP_ADDRESS.KEBELE," +
//                "                         HR_EMP_ADDRESS.EMAIL," +
//                "                         HR_EMP_ADDRESS.ADDRESSTYPE," +
//                "                         HR_EMP_ADDRESS.HOUSE_NUMBER," +
//                "                         HR_EMP_ADDRESS.REGION_ID," +
//                "                         HR_EMP_ADDRESS.EMAIL," +
//                "                         HR_LU_REGION.REGION_NAME, " +
//                "                         HR_LU_WOREDA_OR_SUB_CITY.WOREDA_OR_SUBCITY_NAME, " +
//                "                         HR_LU_ZONE_OR_CITY.ZONE_OR_CITY_NAME" +
//                "      FROM         HR_LU_ZONE_OR_CITY INNER JOIN (HR_LU_WOREDA_OR_SUB_CITY INNER JOIN (HR_LU_REGION INNER JOIN HR_EMP_ADDRESS " +
//                "                  ON HR_LU_REGION.REGION_ID = HR_EMP_ADDRESS.REGION_ID) ON " +
//                "                  HR_LU_WOREDA_OR_SUB_CITY.WOREDA_OR_SUBCITY_ID = HR_EMP_ADDRESS.WOREDA_OR_SUBCITY_ID)" +
//                "                  ON HR_LU_ZONE_OR_CITY.ZONE_OR_CITY_ID = HR_EMP_ADDRESS.WOREDA_OR_SUBCITY " +
//                "     WHERE     emp_id=?";
        String select = "  select distinct " +
                "                HR_EMP_ADDRESS.ID ," +
                "                HR_EMP_ADDRESS.TELEPHONE_RESIDENCE," +
                "                HR_EMP_ADDRESS.TELEPHONE_OFFICE," +
                "                HR_EMP_ADDRESS.MOBILE," +
                "                HR_EMP_ADDRESS.KEBELE," +
                "                HR_EMP_ADDRESS.EMAIL," +
                "                HR_EMP_ADDRESS.ADDRESSTYPE," +
                "                HR_EMP_ADDRESS.HOUSE_NUMBER," +
                "                HR_EMP_ADDRESS.REGION_ID," +
                "                HR_EMP_ADDRESS.EMAIL," +
                "                HR_LU_REGION.REGION_NAME, " +
                "                hr_lu_woreda_or_sub_city.woreda_or_subcity_name, " +
                "                hr_lu_zone_or_city.zone_or_city_name," +
                "                hr_lu_kebelle.kebelle_name" +
                "     FROM           hr_lu_region," +
                "                hr_emp_address," +
                "                hr_lu_woreda_or_sub_city ," +
                "                hr_lu_zone_or_city," +
                "                hr_lu_kebelle" +
                "     WHERE           hr_lu_region.region_id = hr_emp_address.region_id and" +
                "                hr_lu_woreda_or_sub_city.woreda_or_subcity_id = hr_emp_address.woreda_or_subcity_id and" +
                "                hr_lu_zone_or_city.zone_or_city_id = hr_emp_address.woreda_or_subcity and" +
                "                HR_EMP_ADDRESS.KEBELE=hr_lu_kebelle.kebelle_id and" +
                "                HR_EMP_ADDRESS.emp_id=? ";

        ArrayList<HashMap> readAddressInfiormation = new ArrayList<HashMap>();
        ResultSet rsAddress;
        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeID);
            rsAddress = ps.executeQuery();
            ocrs.populate(rsAddress);
            rsAddress.close();
            ps.close();


            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("TELEPHONE_RESIDENCE", ocrs.getString("TELEPHONE_RESIDENCE"));
                hm.put("TELEPHONE_OFFICE", ocrs.getString("TELEPHONE_OFFICE"));
                hm.put("MOBILE", ocrs.getString("MOBILE"));
                hm.put("EMAIL", ocrs.getString("EMAIL"));
                hm.put("ADDRESSTYPE", ocrs.getString("ADDRESSTYPE"));
                hm.put("HOUSE_NUMBER", ocrs.getString("HOUSE_NUMBER"));
                hm.put("WOREDA_OR_SUBCITY_NAME", ocrs.getString("WOREDA_OR_SUBCITY_NAME"));
                hm.put("ZONE_OR_CITY_NAME", ocrs.getString("ZONE_OR_CITY_NAME"));
                hm.put("KEBELE", ocrs.getString("kebelle_name"));
                hm.put("REGION_ID", ocrs.getString("REGION_ID"));
                readAddressInfiormation.add(hm);

            }

            closePooledConnections(_conn);
            return readAddressInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readLanguageForReport(String employeeID) {
        String select = "SELECT     hr_emp_language.READING, " +
                "                   hr_emp_language.WRITING," +
                "                   HR_EMP_LANGUAGE.SPEAKING," +
                "                   HR_EMP_LANGUAGE.LISTENING,           " +
                "                   hr_lu_language.description as LANGUAGE" +
                "       FROM      hr_emp_language " +
                "       JOIN       hr_lu_language on hr_lu_language.language_code  = hr_emp_language.language_code " +
                "       WHERE      emp_id=?";
        ArrayList<HashMap> readLanguageInfiormation = new ArrayList<HashMap>();

        ResultSet rsLanguage;

        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeID);
            rsLanguage = ps.executeQuery();
            ocrs.populate(rsLanguage);
            rsLanguage.close();
            ps.close();


            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("READING", ocrs.getString("READING"));
                hm.put("WRITING", ocrs.getString("WRITING"));
                hm.put("SPEAKING", ocrs.getString("SPEAKING"));
                hm.put("LISTENING", ocrs.getString("LISTENING"));
                hm.put("LANGUAGE", ocrs.getString("LANGUAGE"));
                readLanguageInfiormation.add(hm);

            }

            closePooledConnections(_conn);
            return readLanguageInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readExperianceForReport(String employeeID) {
        String select = "SELECT     HR_EMP_EXPERIENCE.INSTITUION," +
                "                   HR_EMP_EXPERIENCE.JOB_TITLE," +
                "                   HR_EMP_EXPERIENCE.SALARY," +
                "                   HR_EMP_EXPERIENCE.RANK," +
                "                   HR_EMP_EXPERIENCE.START_DATE," +
                "                   HR_EMP_EXPERIENCE.END_DATE," +
                "                   HR_EMP_EXPERIENCE.REASON_FOR_TERMINATION" +
                "       FROM hr_emp_experience WHERE emp_Id=?";
        ArrayList<HashMap> readExperianceInfiormation = new ArrayList<HashMap>();

        ResultSet rsExperiance = null;

        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeID);
            rsExperiance = ps.executeQuery();
            ocrs.populate(rsExperiance);
            rsExperiance.close();
            ps.close();


            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("INSTITUION", ocrs.getString("INSTITUION"));
                hm.put("JOB_TITLE", ocrs.getString("JOB_TITLE"));
                hm.put("SALARY", ocrs.getString("SALARY"));
                hm.put("RANK", ocrs.getString("RANK"));
                hm.put("START_DATE", ocrs.getString("START_DATE"));
                hm.put("END_DATE", ocrs.getString("END_DATE"));
                hm.put("REASON_FOR_TERMINATION", ocrs.getString("REASON_FOR_TERMINATION"));
                readExperianceInfiormation.add(hm);

            }

            closePooledConnections(_conn);
            return readExperianceInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readTrainingeForReport(String employeeID) {
        String select = "SELECT ETR.EMP_ID, " +
                "  ETR.INSTITUTION, " +
                "  ETR.TRAININGORCOURSE_NAME, " +
                "  ETR.START_DATE, " +
                "  ETR.END_DATE, " +
                "  ETR.PAYMENT_FOR_TRAINING, " +
                "  ETR.PAYMENT_PAYE_BY, " +
                "  INS.INSTITUTION_NAME " +
                "FROM HR_EMP_TRAINING ETR, " +
                "  HR_LU_EDUC_INSTITUTION INS " +
                "WHERE ETR.INSTITUTION=INS.INSTITUTION_ID(+) " +
                "AND EMP_ID           =?";
        ArrayList<HashMap> readEmployeeTraining = new ArrayList<HashMap>();
        ResultSet rsExperiance = null;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeID);
            rsExperiance = ps.executeQuery();
            ocrs.populate(rsExperiance);
            rsExperiance.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("INSTITUTION", ocrs.getString("INSTITUTION_NAME"));
                hm.put("TRAININGORCOURSE_NAME", ocrs.getString("TRAININGORCOURSE_NAME"));
                hm.put("START_DATE", ocrs.getString("START_DATE"));
                hm.put("END_DATE", ocrs.getString("END_DATE"));
                hm.put("PAYMENT_FOR_TRAINING", ocrs.getString("PAYMENT_PAYE_BY"));
                readEmployeeTraining.add(hm);
            }
            closePooledConnections(_conn);
            return readEmployeeTraining;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readGnderForReport() {
        String select = "SELECT COUNT(SEX) AS COUNTS, " +
                "  SEX , " +
                "  EMP.TOTAL " +
                "FROM HR_EMPLOYEE_INFO, " +
                "  (SELECT COUNT(EMP_ID) AS TOTAL FROM HR_EMPLOYEE_INFO " +
                " WHERE ( EMP_STATUS='01' " +
                " OR EMP_STATUS     ='02' " +
                " OR EMP_STATUS     ='07' ) " +
                "  )EMP " +
                "WHERE ( EMP_STATUS='01' " +
                "OR EMP_STATUS     ='02' " +
                "OR EMP_STATUS     ='07' ) " +
                "GROUP BY SEX, " +
                "  EMP.TOTAL ";

        ResultSet rsExperiance = null;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rsExperiance = ps.executeQuery();
            ocrs.populate(rsExperiance);
            rsExperiance.close();
            ps.close();
            ArrayList<HashMap> list = new ArrayList<HashMap>();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("COUNTS", ocrs.getString("COUNTS"));
                hm.put("SEX", ocrs.getString("SEX"));
                hm.put("TOTAL", ocrs.getString("TOTAL"));
                closePooledConnections(_conn);
                list.add(hm);

            }
            return list;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readEmployeeLeaveScedule() {
        String select = "SELECT TI.TITLE_DESCRIPTION " +
                "  ||' ' " +
                "  || EI.FIRST_NAME " +
                "  ||' ' " +
                "  || EI.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EI.LAST_NAME AS FULLNAME, " +
                "  LS.SCGEDULE_ID, " +
                "  LS.MONTH, " +
                "  LS.EMP_ID, " +
                "  NVL(LS.REMARK,'NOT REGISTER') AS REMARK, " +
                "  LS.SCHEDULEDATE " +
                "FROM HR_LEAVE_EMP_SCHEDULE LS, " +
                "  HR_EMPLOYEE_INFO EI, " +
                "  HR_LU_TITLE TI " +
                "WHERE EI.EMP_ID   =LS.EMP_ID " +
                "AND EI.TITLE      =TI.TITLE_ID " +
                "AND (EI.EMP_STATUS='01' " +
                "OR EI.EMP_STATUS  ='02' " +
                "OR EI.EMP_STATUS  ='07')";

        ResultSet rsExperiance = null;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rsExperiance = ps.executeQuery();
            ocrs.populate(rsExperiance);
            rsExperiance.close();
            ps.close();
            ArrayList<HashMap> list = new ArrayList<HashMap>();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("SCGEDULE_ID", ocrs.getString("SCGEDULE_ID"));
                hm.put("MONTH", ocrs.getString("MONTH"));
                hm.put("EMP_ID", ocrs.getString("EMP_ID"));
                hm.put("REMARK", ocrs.getString("REMARK"));
                hm.put("SCHEDULEDATE", ocrs.getString("SCHEDULEDATE"));
                closePooledConnections(_conn);
                list.add(hm);

            }
            return list;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public OracleCachedRowSet getPromoteList() {
        String select = "SELECT Emp_Id AS EMPLOYEEID, " +
                "  FULLNAME    AS EMPFULLNAME, " +
                "  HIRE_DATE, " +
                "  Salary, " +
                "  Description        AS Educationlevel, " +
                "  Educ_Type          AS Educationtype, " +
                "  Prev_Job_Position  AS Prevjobposition, " +
                "  PREVPROMOTION_DATE AS PREVPROMOTIONDATE " +
                "FROM View_New_Promotion ";

        ResultSet rsExperiance = null;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rsExperiance = ps.executeQuery();
            ocrs.populate(rsExperiance);

            return ocrs;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
