/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.terminationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Admin
 */
public class ClearanceReport extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;
    Connection _con2 = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
            _rs = null;
        }
        if (_ps != null) {
            _ps.close();
            _ps = null;
        }
        if (_con != null) {
            _con.close();
            closePooledConnections(_con);
        }
    }

    public OracleCachedRowSet readAllClearnce() throws SQLException {
        String select = null;
        select = "SELECT distinct emp.emp_id, " +
                "  emp.first_name " +
                "  ||'' " +
                "  || emp.middle_name " +
                "  ||' ' " +
                "  || EMP.LAST_NAME AS ClerName, " +
                "  emp.sex, " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                "  emp.salary, " +
                "  rank.rank_description, " +
                "  lst.department_name, " +
                "  lst.job_name, " +
                "  edu.description, " +
                "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                "  C.CLEARED_DATE, " +
                "  term.clearance_type AS clearance_reason , " +
                "  term.final_cleared_date, " +
                "  term.clearance_status " +
                "FROM HR_TERMINATION_CLEARED C " +
                "INNER JOIN hr_employee_info emp " +
                "ON emp.emp_id=c.emp_id " +
                "INNER JOIN hr_lu_rank rank " +
                "ON rank.rank_id= emp.rank_id " +
                "INNER JOIN vw_employee_edu_award edu " +
                "ON edu.emp_id =c.emp_id " +
                "INNER JOIN vw_employee_edu_detail edutype " +
                "ON edutype.emp_id=c.emp_id " +
                "INNER JOIN vw_employee_by_department_list lst " +
                "ON lst.emp_id=c.emp_id " +
                "INNER JOIN hr_termination_clearance term " +
                "ON term.emp_id=c.emp_id " +
                "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                "ON C.CLEARED_ID =H.CLEARED_ID";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public OracleCachedRowSet readAllClearnceMOnthly(HashMap list) throws SQLException {
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  term.date_terminated LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                    " AND c.emp_id          ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY emp.emp_id ";
        } else {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  term.date_terminated LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                    " ORDER BY emp.emp_id  desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public OracleCachedRowSet readAllClearnceDays(HashMap Daylist) throws SQLException {
        String select = null;

        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  to_date(subStr(term.date_terminated,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND c.emp_id          ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY emp.emp_id ";

        } else {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  to_date(subStr(term.date_terminated,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " ORDER BY emp.emp_id  desc";
        }
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, Daylist.get("StartDay").toString());
            _ps.setString(2, Daylist.get("endDate").toString());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public OracleCachedRowSet readAllClearnceQuarterly(HashMap Daylist) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(Daylist.get("quarterType").toString()) == 1) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(Daylist.get("quarterType").toString()) == 2) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(Daylist.get("quarterType").toString()) == 3) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(Daylist.get("quarterType").toString()) == 4) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }
        String select = null;

        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  to_date(subStr(term.date_terminated,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND c.emp_id          ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY emp.emp_id ";
        } else {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  to_date(subStr(term.date_terminated,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " ORDER BY emp.emp_id  desc";

        }
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public OracleCachedRowSet readAllClearnceSemiAnnually(HashMap Daylist) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year = Daylist.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(Daylist.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(Daylist.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  to_date(subStr(term.date_terminated,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND c.emp_id          ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY emp.emp_id ";
        } else {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  to_date(subStr(term.date_terminated,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " ORDER BY emp.emp_id  desc";
        }
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public OracleCachedRowSet readAllClearnceAnnually(HashMap Daylist) throws SQLException {
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  term.date_terminated LIKE '" + Daylist.get("year") + "-%-%'" +
                    " AND emp.emp_id          ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY emp.emp_id ";
        } else {
            select = "SELECT distinct emp.emp_id, " +
                    "  emp.first_name " +
                    "  ||'' " +
                    "  || emp.middle_name " +
                    "  ||' ' " +
                    "  || EMP.LAST_NAME AS ClerName, " +
                    "  emp.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
                    "  emp.salary, " +
                    "  rank.rank_description, " +
                    "  lst.department_name, " +
                    "  lst.job_name, " +
                    "  edu.description, " +
                    "  SUBSTR(term.date_terminated,1,10) AS reqDate, " +
                    "  C.CLEARED_DATE, " +
                    "  term.clearance_type AS clearance_reason , " +
                    "  term.final_cleared_date, " +
                    "  term.clearance_status " +
                    "FROM HR_TERMINATION_CLEARED C " +
                    "INNER JOIN hr_employee_info emp " +
                    "ON emp.emp_id=c.emp_id " +
                    "INNER JOIN hr_lu_rank rank " +
                    "ON rank.rank_id= emp.rank_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =c.emp_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=c.emp_id " +
                    "INNER JOIN vw_employee_by_department_list lst " +
                    "ON lst.emp_id=c.emp_id " +
                    "INNER JOIN hr_termination_clearance term " +
                    "ON term.emp_id=c.emp_id " +
                    "INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
                    "ON C.CLEARED_ID =H.CLEARED_ID " +
                    "WHERE  term.date_terminated LIKE '" + Daylist.get("year") + "-%-%'" +
                    " ORDER BY emp.emp_id  desc";
        }
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }
}
