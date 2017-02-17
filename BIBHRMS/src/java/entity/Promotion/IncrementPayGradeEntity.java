/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.Promotion;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Up
 */
public class IncrementPayGradeEntity extends ConnectionManager {

    private String empId;
    private String empName;
    private String deptId;
    private String deptDesc;
    private String hiredDate;
    private String lastIncrementDate;
    private String currentPayGrade;
    private String currentSalary;
    private String nextPayGrade;
    private String nextSalary;
    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs = null;

    public IncrementPayGradeEntity(String empId, String empName, String deptId, String deptDesc, String hiredDate, String lastIncrementDate, String currentPayGrade, String currentSalary, String nextPayGrade, String nextSalary) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.deptDesc = deptDesc;
        this.hiredDate = hiredDate;
        this.lastIncrementDate = lastIncrementDate;
        this.currentPayGrade = currentPayGrade;
        this.currentSalary = currentSalary;
        this.nextPayGrade = nextPayGrade;
        this.nextSalary = nextSalary;
    }

    public IncrementPayGradeEntity() {
    }

    /**
     * Quers all employees who must have paygrade incrementation
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<HashMap> getEmployeesForPayGradeInc() throws SQLException {

        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT E.EMP_ID, E.FIRST_NAME, E.MIDDLE_NAME, E.LAST_NAME, E.HIRE_DATE, E.DEPARTMENT_ID, " +
                "D.DEP_DESCRIPTION, '' as PROMOTION_DATE, E.PAY_GRADE AS CURRENTPAYGRADE, E.SALARY,     " +
                "(E.PAY_GRADE +1) AS NEXTPAYGRADE, P.SALARY AS NEXTSALARY, MONTHS_BETWEEN(TO_DATE('2012-07-28', 'YYYY-MM-DD'), TO_DATE(E.HIRE_DATE, 'yyyy-mm-dd')) AS MNTHDIF     " +
                "FROM HR_EMPLOYEE_INFO E, HR_LU_PAY_GRAD P, TBL_DEPARTMENT D, HR_LU_RANK R   " +
                "WHERE P.STEP_NO = (E.PAY_GRADE +1) AND P.RANK_ID = R.RANK_ID AND R.RANK_ID = E.RANK_ID AND D.DEPT_ID = E.DEPARTMENT_ID ";
//                "MONTHS_BETWEEN(TO_DATE('2012-07-28', 'YYYY-MM-DD'), TO_DATE(E.HIRE_DATE, 'yyyy-mm-dd')) > 13 ";

        String select2 = "SELECT DISTINCT E.EMP_ID, E.FIRST_NAME, E.MIDDLE_NAME, E.LAST_NAME, E.HIRE_DATE, E.DEPARTMENT_ID, " +
                "D.DEP_DESCRIPTION, '' as PROMOTION_DATE, E.PAY_GRADE AS CURRENTPAYGRADE, E.SALARY,    " +
                "(E.PAY_GRADE +1) AS NEXTPAYGRADE, P.SALARY AS NEXTSALARY, MONTHS_BETWEEN(TO_DATE('2012-07-28', 'YYYY-MM-DD'), TO_DATE(E.HIRE_DATE, 'yyyy-mm-dd')) AS MNTHDIF    " +
                "FROM HR_EMPLOYEE_INFO E, HR_LU_PAY_GRAD P, HR_LU_DEPARTMENT D, HR_LU_RANK R  " +
                "WHERE P.STEP_NO = (E.PAY_GRADE +1) AND P.RANK_ID = R.RANK_ID AND R.RANK_ID = E.RANK_ID AND D.DEPT_ID = E.DEPARTMENT_ID ";

        quesList = buildList(select);
        quesList.addAll(buildList(select2));
        return quesList;
    }

    public ArrayList<HashMap> getEmployeesForPayGradeIncm() throws SQLException {

        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String sql = "SELECT EMP_ID, " +
                "  FIRST_NAME " +
                "  ||' ' " +
                "  ||MIDDLE_NAME " +
                "  ||' ' " +
                "  ||LAST_NAME AS FULLNAME, " +
                "  HIRE_DATE, " +
                "  SALARY, " +
                "  RANK_ID, " +
                "  PAY_GRADE " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE emp_status IN ('01','02','07') " +
                //"  and EMP_ID='BA/00123' " +
                " order by FULLNAME";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("HIRE_DATE", rs.getString("HIRE_DATE"));
                hm.put("SALARY", rs.getString("SALARY"));
                hm.put("RANK_ID", rs.getString("RANK_ID"));
                hm.put("PAY_GRADE", rs.getString("PAY_GRADE"));
                quesList.add(hm);

            }
            return quesList;
        } finally {
        }


    }

    /**
     * Quers all employees who must have paygrade incrementation
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<HashMap> getEmployeesForPayGradeIncREport() throws SQLException {

        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT E.EMP_ID, E.FIRST_NAME, E.MIDDLE_NAME, E.LAST_NAME, E.HIRE_DATE, E.DEPARTMENT_ID, " +
                "D.DEP_DESCRIPTION, '' as PROMOTION_DATE, E.PAY_GRADE AS CURRENTPAYGRADE, E.SALARY,     " +
                "(E.PAY_GRADE +1) AS NEXTPAYGRADE, P.SALARY AS NEXTSALARY, MONTHS_BETWEEN(TO_DATE('2012-07-28', 'YYYY-MM-DD'), TO_DATE(E.HIRE_DATE, 'yyyy-mm-dd')) AS MNTHDIF     " +
                "FROM HR_EMPLOYEE_INFO E, HR_LU_PAY_GRAD P, TBL_DEPARTMENT D, HR_LU_RANK R   " +
                "WHERE P.STEP_NO = (E.PAY_GRADE +1) AND P.RANK_ID = R.RANK_ID AND R.RANK_ID = E.RANK_ID AND D.DEPT_ID = E.DEPARTMENT_ID ";
//                "MONTHS_BETWEEN(TO_DATE('2012-07-28', 'YYYY-MM-DD'), TO_DATE(E.HIRE_DATE, 'yyyy-mm-dd')) > 13 ";

        String select2 = "SELECT DISTINCT E.EMP_ID, E.FIRST_NAME, E.MIDDLE_NAME, E.LAST_NAME, E.HIRE_DATE, E.DEPARTMENT_ID, " +
                "D.DEP_DESCRIPTION, '' as PROMOTION_DATE, E.PAY_GRADE AS CURRENTPAYGRADE, E.SALARY,    " +
                "(E.PAY_GRADE +1) AS NEXTPAYGRADE, P.SALARY AS NEXTSALARY, MONTHS_BETWEEN(TO_DATE('2012-07-28', 'YYYY-MM-DD'), TO_DATE(E.HIRE_DATE, 'yyyy-mm-dd')) AS MNTHDIF    " +
                "FROM HR_EMPLOYEE_INFO E, HR_LU_PAY_GRAD P, HR_LU_DEPARTMENT D, HR_LU_RANK R  " +
                "WHERE P.STEP_NO = (E.PAY_GRADE +1) AND P.RANK_ID = R.RANK_ID AND R.RANK_ID = E.RANK_ID AND D.DEPT_ID = E.DEPARTMENT_ID ";

        quesList = buildList(select);
        quesList.addAll(buildList(select2));
        return quesList;
    }

    public ArrayList<HashMap> buildList(String select) {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
//            rs.close();
//            ps.close();


            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("empId", ocrs.getString("EMP_ID"));
                hm.put("empName", ocrs.getString("FIRST_NAME") + " " + ocrs.getString("MIDDLE_NAME") + " " + ocrs.getString("LAST_NAME"));
                hm.put("deptId", ocrs.getString("DEPARTMENT_ID"));
                hm.put("deptDesc", ocrs.getString("DEP_DESCRIPTION"));
                hm.put("hiredDate", ocrs.getString("HIRE_DATE"));
                hm.put("lastIncreamentDate", ocrs.getString("PROMOTION_DATE"));
                hm.put("currentPayGrade", ocrs.getString("CURRENTPAYGRADE"));
                hm.put("currentSalary", ocrs.getString("SALARY"));
                hm.put("nextPayGrade", ocrs.getString("NEXTPAYGRADE"));
                hm.put("nextSalary", ocrs.getString("NEXTSALARY"));
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public boolean saveUpdatePayGradeInc(String incDate, String incDesc, IncrementPayGradeEntity incrementPayGradeEntity) {
        boolean checkSave = false;
        Connection con = null;
        PreparedStatement ps = null;
        String insert = "INSERT INTO HR_PROMOTION_HISTORY ( " +
                "    PROMOTION_HISTORY_ID, EMPLOYEE_ID, " +
                "    REQUESTER_DEPARTMENT, PROMOTION_TYPE, " +
                "    REASON, PREV_JOB_POSITION, PREV_RANK, " +
                "    PREV_SALARY, NEW_JOB_POSITION, " +
                "    NEW_RANK, NEW_SALARY, ADV_NUMBER, " +
                "    PROMOTION_DATE, COMPLETED_DATE, " +
                "    PROM_LETTER_NUMBER, TIME_STAMP, " +
                "    USER_NAME, REQUEST_LETTER_NUMBER, " +
                "    REQUEST_DATE, PREV_PAYGRADE, NEW_PAYGRADE ) " +
                "    VALUES (HR_PROMOTION_HISTORY_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
        try {
            con = getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(1, incrementPayGradeEntity.getEmpId());
            ps.setString(2, incrementPayGradeEntity.getDeptId());
            ps.setString(3, "IP");
            ps.setString(4, incDesc);
            ps.setString(5, "");
            ps.setString(6, "");
            ps.setString(7, incrementPayGradeEntity.getCurrentSalary());
            ps.setString(8, "");
            ps.setString(9, "");
            ps.setString(10, incrementPayGradeEntity.getNextSalary());
            ps.setString(11, "");
            ps.setString(12, incDate);
            ps.setString(13, incDate);
            ps.setString(14, "");
            ps.setString(15, incDate);
            ps.setString(16, "");
            ps.setString(17, "");
            ps.setString(18, "");
            ps.setString(19, incrementPayGradeEntity.getCurrentPayGrade());
            ps.setString(20, incrementPayGradeEntity.getNextPayGrade());

            if (ps.executeUpdate() > 0 && updateEmployeesPayGrade(incrementPayGradeEntity.getEmpId(),
                    incrementPayGradeEntity.getNextPayGrade(), incrementPayGradeEntity.getNextSalary().trim())) {
                checkSave = true;
            }
            ps.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;
    }

    private boolean updateEmployeesPayGrade(String empId, String nextPayGrade, String nextSalary) {
        boolean checkSave = false;
        Connection con = null;
        PreparedStatement ps = null;
        String insert = "UPDATE HR_EMPLOYEE_INFO SET PAY_GRADE = ?, SALARY = ? " +
                "WHERE EMP_ID = ?";

        try {
            con = getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(1, nextPayGrade);
            ps.setString(2, nextSalary.trim());
            ps.setString(3, empId);
            if (ps.executeUpdate() > 0) {
                checkSave = true;
            }
            ps.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;
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
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the deptId
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the deptDesc
     */
    public String getDeptDesc() {
        return deptDesc;
    }

    /**
     * @param deptDesc the deptDesc to set
     */
    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    /**
     * @return the hiredDate
     */
    public String getHiredDate() {
        return hiredDate;
    }

    /**
     * @param hiredDate the hiredDate to set
     */
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * @return the lastIncrementDate
     */
    public String getLastIncrementDate() {
        return lastIncrementDate;
    }

    /**
     * @param lastIncrementDate the lastIncrementDate to set
     */
    public void setLastIncrementDate(String lastIncrementDate) {
        this.lastIncrementDate = lastIncrementDate;
    }

    /**
     * @return the currentPayGrade
     */
    public String getCurrentPayGrade() {
        return currentPayGrade;
    }

    /**
     * @param currentPayGrade the currentPayGrade to set
     */
    public void setCurrentPayGrade(String currentPayGrade) {
        this.currentPayGrade = currentPayGrade;
    }

    /**
     * @return the currentSalary
     */
    public String getCurrentSalary() {
        return currentSalary;
    }

    /**
     * @param currentSalary the currentSalary to set
     */
    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }

    /**
     * @return the nextPayGrade
     */
    public String getNextPayGrade() {
        return nextPayGrade;
    }

    /**
     * @param nextPayGrade the nextPayGrade to set
     */
    public void setNextPayGrade(String nextPayGrade) {
        this.nextPayGrade = nextPayGrade;
    }

    /**
     * @return the nextSalary
     */
    public String getNextSalary() {
        return nextSalary;
    }

    /**
     * @param nextSalary the nextSalary to set
     */
    public void setNextSalary(String nextSalary) {
        this.nextSalary = nextSalary;
    }
}
