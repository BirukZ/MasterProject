/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeBonesEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Administrator
 */
public class RequestYearBonesEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    PreparedStatement ps = null;
    ResultSet _rs = null;

    public ArrayList<HashMap> listOfEmployee(String location, String endOfBugerYear) throws SQLException {
        String query = null;
        if (location.equals("MUGHER")) {
            query = "SELECT EI.EMP_ID, " +
                    "  EI.FIRST_NAME " +
                    "  || ' ' " +
                    "  || EI.MIDDLE_NAME " +
                    "  || ' ' " +
                    "  || EI.LAST_NAME AS FULLNAME, " +
                    "  DE.DEPT_NAME , " +
                    "  CAL.EXPRIANCE, " +
                    "  NVL(PR.SALARY_FROM,EI.salary) AS CURRENT_SALARY " +
                    "FROM HR_EMPLOYEE_INFO EI, " +
                    "  TBL_DEPARTMENT DE , " +
                    "  (SELECT TRUNC(months_between(to_date('2012-7-7','YYYY-MM-DD') ,HIREDATE)/12) " +
                    "    ||' YEAR & ' " +
                    "    || TRUNC(mod(months_between(to_date('2012-7-7','YYYY-MM-DD'),HIREDATE),12)) " +
                    "    ||' MONTH & ' " +
                    "    || TRUNC(to_date('2012-7-7','YYYY-MM-DD')-add_months(HIREDATE,TRUNC(months_between(to_date('2012-7-7','YYYY-MM-DD'),HIREDATE)/12)*12+TRUNC(mod(months_between(to_date('2012-7-7','YYYY-MM-DD'),HIREDATE),12)))) " +
                    "    ||' DAY' EXPRIANCE, " +
                    "    EMP_ID " +
                    "  FROM " +
                    "    (SELECT to_date(HIRE_DATE,'YYYY-MM-DD') HIREDATE, " +
                    "      EMP_ID " +
                    "    FROM HR_EMPLOYEE_INFO " +
                    "    ) " +
                    "  )CAL, " +
                    "  (SELECT EMP_ID, " +
                    "    PROMOTION_DATE, " +
                    "    NVL(SALARY_FROM, '0') AS SALARY_FROM, " +
                    "    SALARY_TO, " +
                    "    REFERENCE_DATE " +
                    "  FROM HR_EMP_PROMOTION " +
                    "  WHERE TO_DATE(REFERENCE_DATE,'YYYY-MM-DD') > TO_DATE('2012-7-7','YYYY-MM-DD') " +
                    "  )PR " +
                    "WHERE EI.DEPARTMENT_ID=DE.DEPT_ID " +
                    "AND EI.EMP_ID         =CAL.EMP_ID " +
                    "AND EI.EMP_ID         =PR.EMP_ID(+) " +
                    "AND (DE.DEPT_NAME LIKE '%Mugher%' " +
                    "OR DE.DEPT_NAME LIKE '%ሙገር%' )";
        } else {
            query = "SELECT EI.EMP_ID, " +
                    "  EI.FIRST_NAME " +
                    "  || ' ' " +
                    "  || EI.MIDDLE_NAME " +
                    "  || ' ' " +
                    "  || EI.LAST_NAME AS FULLNAME, " +
                    "  DE.DEPT_NAME , " +
                    "  CAL.EXPRIANCE, " +
                    "  NVL(PR.SALARY_FROM,EI.salary) AS CURRENT_SALARY " +
                    "FROM HR_EMPLOYEE_INFO EI, " +
                    "  TBL_DEPARTMENT DE , " +
                    "  (SELECT TRUNC(months_between(to_date('2012-7-7','YYYY-MM-DD') ,HIREDATE)/12) " +
                    "    ||' YEAR & ' " +
                    "    || TRUNC(mod(months_between(to_date('2012-7-7','YYYY-MM-DD'),HIREDATE),12)) " +
                    "    ||' MONTH & ' " +
                    "    || TRUNC(to_date('2012-7-7','YYYY-MM-DD')-add_months(HIREDATE,TRUNC(months_between(to_date('2012-7-7','YYYY-MM-DD'),HIREDATE)/12)*12+TRUNC(mod(months_between(to_date('2012-7-7','YYYY-MM-DD'),HIREDATE),12)))) " +
                    "    ||' DAY' EXPRIANCE, " +
                    "    EMP_ID " +
                    "  FROM " +
                    "    (SELECT to_date(HIRE_DATE,'YYYY-MM-DD') HIREDATE, " +
                    "      EMP_ID " +
                    "    FROM HR_EMPLOYEE_INFO " +
                    "    ) " +
                    "  )CAL, " +
                    "  (SELECT EMP_ID, " +
                    "    PROMOTION_DATE, " +
                    "    NVL(SALARY_FROM, '0') AS SALARY_FROM, " +
                    "    SALARY_TO, " +
                    "    REFERENCE_DATE " +
                    "  FROM HR_EMP_PROMOTION " +
                    "  WHERE TO_DATE(REFERENCE_DATE,'YYYY-MM-DD') > TO_DATE('2012-7-7','YYYY-MM-DD') " +
                    "  )PR " +
                    "WHERE EI.DEPARTMENT_ID=DE.DEPT_ID " +
                    "AND EI.EMP_ID         =CAL.EMP_ID " +
                    "AND EI.EMP_ID         =PR.EMP_ID(+) " +
                    "AND EI.EMP_ID NOT    IN " +
                    "  (SELECT EMP_ID " +
                    "  FROM HR_EMPLOYEE_INFO, " +
                    "    TBL_DEPARTMENT " +
                    "  WHERE HR_EMPLOYEE_INFO.DEPARTMENT_ID=TBL_DEPARTMENT.DEPT_ID " +
                    "  AND (DE.DEPT_NAME LIKE '%Mugher%' " +
                    "  OR DE.DEPT_NAME LIKE '%ሙገር%' ) " +
                    "  )";
        }
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", _rs.getString("EMP_ID").toString());
                hm.put("FULLNAME", _rs.getString("FULLNAME").toString());
                hm.put("DEPT_NAME", _rs.getString("DEPT_NAME").toString());
                hm.put("EXPRIANCE", _rs.getString("EXPRIANCE").toString());
                hm.put("CURRENT_SALARY", _rs.getString("CURRENT_SALARY").toString());

                list.add(hm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return null;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> listOfEmployeeBonesCalculation(String location,
            String evaluationStart,
            String evaluationEnd,
            String bonusYear) throws SQLException {
        String query = null;
        if (location.equals("MUGHER")) {
            query = "SELECT EI.EMP_ID, " +
                    "  EI.FIRST_NAME " +
                    "  || ' ' " +
                    "  || EI.MIDDLE_NAME " +
                    "  || ' ' " +
                    "  || EI.LAST_NAME AS FULLNAME, " +
                    "  DE.DEPT_NAME , " +
                    "  CAL.EXPRIANCE, " +
                    "  NVL(PR.SALARY_FROM,EI.salary) AS CURRENT_SALARY, " +
                    "  NVL(EVA.AVERAGE,0)            AS EVALUATIONRESULT " +
                    "FROM HR_EMPLOYEE_INFO EI, " +
                    "  TBL_DEPARTMENT DE , " +
                    "  (SELECT TRUNC(months_between(to_date('"+bonusYear+"','YYYY-MM-DD') ,HIREDATE)/12) " +
                    "    ||' YEAR & ' " +
                    "    || TRUNC(mod(months_between(to_date('"+bonusYear+"','YYYY-MM-DD'),HIREDATE),12)) " +
                    "    ||' MONTH & ' " +
                    "    || TRUNC(to_date('"+bonusYear+"','YYYY-MM-DD')-add_months(HIREDATE,TRUNC(months_between(to_date('"+bonusYear+"','YYYY-MM-DD'),HIREDATE)/12)*12+TRUNC(mod(months_between(to_date('"+bonusYear+"','YYYY-MM-DD'),HIREDATE),12)))) " +
                    "    ||' DAY' EXPRIANCE, " +
                    "    EMP_ID " +
                    "  FROM " +
                    "    (SELECT to_date(HIRE_DATE,'YYYY-MM-DD') HIREDATE, " +
                    "      EMP_ID " +
                    "    FROM HR_EMPLOYEE_INFO " +
                    "    ) " +
                    "  )CAL, " +
                    "  (SELECT EMP_ID, " +
                    "    PROMOTION_DATE, " +
                    "    NVL(SALARY_FROM, '0') AS SALARY_FROM, " +
                    "    SALARY_TO, " +
                    "    REFERENCE_DATE " +
                    "  FROM HR_EMP_PROMOTION " +
                    "  WHERE TO_DATE(REFERENCE_DATE,'YYYY-MM-DD') > TO_DATE('"+bonusYear+"','YYYY-MM-DD') " +
                    "  )PR, " +
                    "  (SELECT AVG(RESULT) AS AVERAGE, " +
                    "    EMP_ID " +
                    "  FROM HR_EMP_EVALUATION " +
                    "  WHERE EXTRACT( YEAR FROM TO_DATE(EVALUATIONDATE,'YYYY-MM-DD')) =EXTRACT( YEAR FROM TO_DATE('2012-12-12','YYYY-MM-DD')) " +
                    "  GROUP BY EMP_ID " +
                    "  )EVA " +
                    "WHERE EI.DEPARTMENT_ID=DE.DEPT_ID " +
                    "AND EI.EMP_ID         =CAL.EMP_ID " +
                    "AND EI.EMP_ID         =PR.EMP_ID(+) " +
                    "AND EI.EMP_ID         =EVA.EMP_ID(+) " +
                    "AND (DE.DEPT_NAME LIKE '%Mugher%' " +
                    "OR DE.DEPT_NAME LIKE '%ሙገር%' )";

        } else {

            query = "SELECT EI.EMP_ID, " +
                    "  EI.FIRST_NAME " +
                    "  || ' ' " +
                    "  || EI.MIDDLE_NAME " +
                    "  || ' ' " +
                    "  || EI.LAST_NAME AS FULLNAME, " +
                    "  DE.DEPT_NAME , " +
                    "  CAL.EXPRIANCE, " +
                    "  NVL(PR.SALARY_FROM,EI.salary) AS CURRENT_SALARY, " +
                    "  NVL(EVA.AVERAGE,0)            AS EVALUATIONRESULT " +
                    "FROM HR_EMPLOYEE_INFO EI, " +
                    "  TBL_DEPARTMENT DE , " +
                    "  (SELECT TRUNC(months_between(to_date('"+bonusYear+"','YYYY-MM-DD') ,HIREDATE)/12) " +
                    "    ||' YEAR & ' " +
                    "    || TRUNC(mod(months_between(to_date('"+bonusYear+"','YYYY-MM-DD'),HIREDATE),12)) " +
                    "    ||' MONTH & ' " +
                    "    || TRUNC(to_date('"+bonusYear+"','YYYY-MM-DD')-add_months(HIREDATE,TRUNC(months_between(to_date('"+bonusYear+"','YYYY-MM-DD'),HIREDATE)/12)*12+TRUNC(mod(months_between(to_date('"+bonusYear+"','YYYY-MM-DD'),HIREDATE),12)))) " +
                    "    ||' DAY' EXPRIANCE, " +
                    "    EMP_ID " +
                    "  FROM " +
                    "    (SELECT to_date(HIRE_DATE,'YYYY-MM-DD') HIREDATE, " +
                    "      EMP_ID " +
                    "    FROM HR_EMPLOYEE_INFO " +
                    "    ) " +
                    "  )CAL, " +
                    "  (SELECT EMP_ID, " +
                    "    PROMOTION_DATE, " +
                    "    NVL(SALARY_FROM, '0') AS SALARY_FROM, " +
                    "    SALARY_TO, " +
                    "    REFERENCE_DATE " +
                    "  FROM HR_EMP_PROMOTION " +
                    "  WHERE TO_DATE(REFERENCE_DATE,'YYYY-MM-DD') > TO_DATE('"+bonusYear+"','YYYY-MM-DD') " +
                    "  )PR, " +
                    "  (SELECT AVG(RESULT) AS AVERAGE, " +
                    "    EMP_ID " +
                    "  FROM HR_EMP_EVALUATION " +
                    "  WHERE TO_DATE(EVALUATIONFROM,'YYYY-MM-DD') >= TO_DATE('"+evaluationStart+"','YYYY-MM-DD') " +
                    "  AND TO_DATE(EVALUATIONTO,'YYYY-MM-DD')     <= TO_DATE('"+evaluationEnd+"','YYYY-MM-DD') " +
                    "  GROUP BY EMP_ID " +
                    "  ORDER BY emp_id " +
                    "  )EVA " +
                    "WHERE EI.DEPARTMENT_ID=DE.DEPT_ID " +
                    "AND EI.EMP_ID         =CAL.EMP_ID " +
                    "AND EI.EMP_ID         =PR.EMP_ID(+) " +
                    "AND EI.EMP_ID         =EVA.EMP_ID " ;
                   // "AND (DE.DEPT_NAME LIKE '%Addis%' " +
                   // "OR DE.DEPT_NAME LIKE '%አዲስአበባ%' )";
        }
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", _rs.getString("EMP_ID"));
                hm.put("FULLNAME", _rs.getString("FULLNAME"));              
                hm.put("EXPRIANCE", _rs.getString("EXPRIANCE"));
                hm.put("CURRENT_SALARY", _rs.getString("CURRENT_SALARY"));
                hm.put("EVALUATIONRESULT", _rs.getString("EVALUATIONRESULT"));

                list.add(hm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return null;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> listOfCalculation() throws SQLException {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        try {
            String evaRes[] = null;
            String query = "SELECT EVALUATIONRESULT, PERCENTAGE, REMARK FROM HR_LU_BONES_CALCULATION ";
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                evaRes = _rs.getString("EVALUATIONRESULT").split("-");
                hm.put("start", evaRes[0]);
                hm.put("end", evaRes[1]);
                hm.put("PERCENTAGE", _rs.getString("PERCENTAGE"));
                list.add(hm);
            }
            return list;
        } finally {
            releaseResources();
        }
    }

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            closePooledConnections(_con);
        }
    }

    public boolean saveBonesRequest(HashMap listOfRequest, ArrayList<HashMap> listOfEmployee) throws Exception {
        boolean checkStatus = false;
        String query = "INSERT " +
                "INTO HR_BONES_REQUEST " +
                "  ( BONESID," +
                "    GRANTBONUS, " +
                "    REQUSTERID, " +
                "    STATUS, " +
                "    REQUSTDATE, " +
                "    EFFECTIVEDATE, " +
                "    PREPAREFOR, " +
                "    YEAR " +
                "  ) " +
                "  VALUES " +
                "  ( ?," +
                "    ?, " +
                "    ?, " +
                "    'Req', " +
                "    CURRENT_TIMESTAMP, " +
                "    ?, " +
                "    ?," +
                "   ?  " +
                "  )";

        String insertQuery = "INSERT " +
                "INTO HR_EMP_YEARLY_BONES " +
                "  ( " +
                "    EMP_ID, " +
                "    EVALUATIONRESULT, " +
                "    ACQUIREPERCENTAGE, " +
                "    AMOUNTINBIRR, " +
                "    STATUS, " +
                "    EXPRIANCE, " +
                "    SALARY, " +
                "    BONESID " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    'Req', " +
                "    ?, " +
                "    ?, " +
                "    ? " +
                "  )";
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            ps = _con.prepareStatement(query);
            String bonesId = listOfRequest.get("prepareIn").toString() +
                    listOfRequest.get("bonusYear").toString();
            ps.setString(1, bonesId);
            ps.setString(2, listOfRequest.get("bonesAmount").toString());
            ps.setString(3, listOfRequest.get("requester").toString());
            ps.setString(4, listOfRequest.get("bugetEndDate").toString());
            ps.setString(5, listOfRequest.get("prepareIn").toString());
            ps.setString(6, listOfRequest.get("bonusYear").toString());
            if (ps.executeUpdate() > 0) {
                _ps = _con.prepareStatement(insertQuery);
                for (HashMap hm : listOfEmployee) {

                    _ps.setString(1, hm.get("empId").toString());
                    _ps.setString(2, hm.get("evaluationResult").toString());
                    _ps.setString(3, hm.get("acquireMonth").toString());
                    _ps.setString(4, hm.get("bonesAmount").toString());
                    _ps.setString(5, hm.get("exprience").toString());
                    _ps.setString(6, hm.get("salary").toString());
                    _ps.setString(7, listOfRequest.get("prepareIn").toString() +
                            listOfRequest.get("bonusYear").toString());
                    if (_ps.executeUpdate() < 0) {
                        return false;
                    }
                    checkStatus = true;
                }
            } else {
                return false;
            }
            _con.commit();

            return checkStatus;



        } finally {
            releaseResources();
        }


    }

    public HashMap listOfRequest() {
        HashMap hm = new HashMap();
        hm.put("prepareIn", "prepareIn");
        hm.put("bonusYear", "bonusYear");
        hm.put("bugetEndDate", "bugetEndDate");
        hm.put("bonesAmount", "bonesAmount");
        hm.put("requester", "requester");
        return hm;
    }

 
}
