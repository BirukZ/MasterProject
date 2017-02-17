/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.educationEntity;

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
public class ReportEntity extends ConnectionManager {

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

    public OracleCachedRowSet readAllCourse() throws SQLException {
        String select = "SELECT empinfo.emp_id, " +
                "  vw.title_description " +
                "  ||' ' " +
                "  || empinfo.first_name " +
                "  ||' ' " +
                "  || empinfo.middle_name " +
                "  || ' ' " +
                "  ||empinfo.last_name AS FullName, " +
                "  empinfo.sex, " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                "  empinfo.hire_date, " +
                "  vw.job_description, " +
                "  vw.department_path, " +
                "  edutype.description AS EducationProgram, " +
                "  edu.description, " +
                "  Req.education_program_name, " +
                "  Req.education_level_category, " +
                "  inst.institution_name, " +
                "  req.applied_date, " +
                "  inst.accredited_or_not, " +
                "  REQ.EDUCATION_SHIFT_CATEGORY " +
                "FROM hr_employee_info empinfo " +
                "INNER JOIN hr_education_request Req " +
                "ON empinfo.emp_id=Req.requester_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=Req.requester_id " +
                "INNER JOIN vw_employee_edu_award edu " +
                "ON edu.emp_id =Req.requester_id " +
                "INNER JOIN vw_employee_edu_detail edutype " +
                "ON edutype.emp_id=req.requester_id " +
                "INNER JOIN hr_educ_institution inst " +
                "ON inst.institution_id=req.institution_name";

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
//==================================================Monthly===========================================================================

    public OracleCachedRowSet readAllCourseByMonth(HashMap list) throws SQLException {
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where Req.TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                    " AND req.requester_id         ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY req.requester_id";

        } else if (ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where Req.TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                    " ORDER BY Req.requester_id desc";
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
//==================================================Dayily===========================================================================

    public OracleCachedRowSet readAllCourseByDays(HashMap Daylist) throws SQLException {
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where to_date(subStr(Req.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND req.requester_id         ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY req.requester_id";



        } else if (ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where to_date(subStr(Req.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " ORDER BY Req.requester_id desc";
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
//==================================Quarterly===========================================================

    public OracleCachedRowSet readAllCourseByQuarterly(HashMap Daylist) throws SQLException {
        String select = null;
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

        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where to_date(subStr(Req.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND req.requester_id         ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY req.requester_id";
        } else if (ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where to_date(subStr(Req.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " ORDER BY Req.requester_id desc";
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
    //============================================Simiannualy=========================================================

    public OracleCachedRowSet readAllCourseBySemiAnnuly(HashMap Daylist) throws SQLException {
        String select = null;
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

        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where to_date(subStr(Req.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND req.requester_id         ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY req.requester_id";
        } else if (ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where to_date(subStr(Req.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') " +
                    " ORDER BY Req.requester_id desc";
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
    //========================================Annulay============================================================

    public OracleCachedRowSet readAllCourseByAnnuly(HashMap Daylist) throws SQLException {
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    " where Req.TIME_STAMP LIKE '" + Daylist.get("year") + "-%-%'" +
                    " AND req.requester_id         ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY req.requester_id";
        } else if (ReportCriteraManager.allEmployee) {

            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  ||' ' " +
                    "  || empinfo.first_name " +
                    "  ||' ' " +
                    "  || empinfo.middle_name " +
                    "  || ' ' " +
                    "  ||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS AGE, " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edu.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  inst.institution_name, " +
                    "  req.applied_date, " +
                    "  inst.accredited_or_not, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_edu_award edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN vw_employee_edu_detail edutype " +
                    "ON edutype.emp_id=req.requester_id " +
                    "INNER JOIN hr_educ_institution inst " +
                    "ON inst.institution_id=req.institution_name " +
                    "where Req.TIME_STAMP LIKE '" + Daylist.get("year") + "-%-%'" +
                    " ORDER BY Req.requester_id desc";
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

    public OracleCachedRowSet readRejectedRequest() throws SQLException {
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description, " +
                    "  empinfo.first_name, " +
                    "  empinfo.middle_name, " +
                    "  empinfo.last_name, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS \"AGE\", " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edulev.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  Req.institution_name, " +
                    "  req.institution_accredited, " +
                    "  edupro.comment_given " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN hr_emp_education edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN HR_LU_EDUC_LEVEL edulev " +
                    "ON edulev.educ_level_code=edu.educ_level_code " +
                    "INNER JOIN HR_LU_EDUC_TYPE edutype " +
                    "ON edutype.educ_type_code=edu.education_type " +
                    "INNER JOIN hr_education_processed edupro " +
                    "ON edupro.request_id=req.education_request_id " +
                    "WHERE req.request_status LIKE 'Rej-%'" +
                    " AND req.requester_id         ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY req.requester_id";
        } else if (ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description, " +
                    "  empinfo.first_name, " +
                    "  empinfo.middle_name, " +
                    "  empinfo.last_name, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS \"AGE\", " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edulev.description, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  Req.institution_name, " +
                    "  req.institution_accredited, " +
                    "  edupro.comment_given " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN hr_emp_education edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN HR_LU_EDUC_LEVEL edulev " +
                    "ON edulev.educ_level_code=edu.educ_level_code " +
                    "INNER JOIN HR_LU_EDUC_TYPE edutype " +
                    "ON edutype.educ_type_code=edu.education_type " +
                    "INNER JOIN hr_education_processed edupro " +
                    "ON edupro.request_id=req.education_request_id " +
                    "WHERE req.request_status LIKE 'Rej-%'" +
                    " ORDER BY Req.requester_id desc";
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
//==========================================================ForREjected=====================

    //========================================================================================================
    public OracleCachedRowSet readApprovedEduc() throws SQLException {
        String select = null;
        if (!ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  || ' '||empinfo.first_name " +
                    "  ||' '|| empinfo.middle_name " +
                    "  || ' '||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS \"AGE\", " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edulev.description, " +
                    "  edu.award, " +
                    "  edu.result, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  req.document_reference_number, " +
                    "  req.applied_date, " +
                    "  Req.institution_name, " +
                    "  REQ.INSTITUTION_ACCREDITED, " +
                    "  req.start_date, " +
                    "  req.end_date, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY, " +
                    "  req.total_admin_costs " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN hr_emp_education edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN HR_LU_EDUC_LEVEL edulev " +
                    "ON edulev.educ_level_code=edu.educ_level_code " +
                    "INNER JOIN HR_LU_EDUC_TYPE edutype " +
                    "ON edutype.educ_type_code=edu.education_type " +
                    "WHERE req.request_status LIKE 'App-%'" +
                    " AND req.requester_id         ='" + ReportCriteraManager.getEmployeeId() + "'" +
                    " ORDER BY req.requester_id";
        } else if (ReportCriteraManager.allEmployee) {
            select = "SELECT empinfo.emp_id, " +
                    "  vw.title_description " +
                    "  || ' '||empinfo.first_name " +
                    "  ||' '|| empinfo.middle_name " +
                    "  || ' '||empinfo.last_name AS FullName, " +
                    "  empinfo.sex, " +
                    "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(empinfo.date_of_birth,1,4)AS \"AGE\", " +
                    "  empinfo.hire_date, " +
                    "  vw.job_description, " +
                    "  vw.department_path, " +
                    "  edutype.description AS EducationProgram, " +
                    "  edulev.description, " +
                    "  edu.award, " +
                    "  edu.result, " +
                    "  Req.education_program_name, " +
                    "  Req.education_level_category, " +
                    "  req.document_reference_number, " +
                    "  req.applied_date, " +
                    "  Req.institution_name, " +
                    "  REQ.INSTITUTION_ACCREDITED, " +
                    "  req.start_date, " +
                    "  req.end_date, " +
                    "  REQ.EDUCATION_SHIFT_CATEGORY, " +
                    "  req.total_admin_costs " +
                    "FROM hr_employee_info empinfo " +
                    "INNER JOIN hr_education_request Req " +
                    "ON empinfo.emp_id=Req.requester_id " +
                    "INNER JOIN vw_employee_by_department_list vw " +
                    "ON vw.emp_id=Req.requester_id " +
                    "INNER JOIN hr_emp_education edu " +
                    "ON edu.emp_id =Req.requester_id " +
                    "INNER JOIN HR_LU_EDUC_LEVEL edulev " +
                    "ON edulev.educ_level_code=edu.educ_level_code " +
                    "INNER JOIN HR_LU_EDUC_TYPE edutype " +
                    "ON edutype.educ_type_code=edu.education_type " +
                    "WHERE req.request_status LIKE 'App-%'" +
                    " ORDER BY Req.requester_id desc";
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
    //=================================================Monthly================================================
}
