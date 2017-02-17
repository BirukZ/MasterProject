/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.benefitEntity;

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
 * @author 
 */
public class benefitReport extends ConnectionManager {

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

    public OracleCachedRowSet readAllBenefit() throws SQLException {


        String select ="SELECT DISTINCT typs.benefit_name, " +
"  typs.benefit_value,typs.saftey_device, " +
"  benpos.monetary, " +
"  benpos.amount_of_birr, " +
"  typs.description, " +
"  typs.benefit_duration, " +
"  tbl.dep_description, " +
"  jobs.job_description, " +
"  typs.benefit_value AS type, " +
"  benpos.quantity " +
"FROM hr_lu_benefit_position benpos " +
"INNER JOIN hr_lu_benefit_types typs " +
"ON typs.benefit_type_id = benpos.benefit_type_id " +
"INNER JOIN hr_lu_job_type jobs " +
"ON jobs.job_code=BENPOS.POSITION_ID " +
"INNER JOIN hr_dept_job dept " +
"ON dept.job_code=jobs.job_code " +
"INNER JOIN vw_department_summary tbl " +
"ON tbl.dept_id=dept.dept_id";


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

    public OracleCachedRowSet readAllBenefitMonthly(HashMap list) throws SQLException {
        String select = "SELECT DISTINCT typs.benefit_name, " +
                "  typs.benefit_value, " +
                "  typs.monetary , " +
                "  typs.description, " +
                "  typs.benefit_duration, " +
                "  tbl.dep_description, " +
                "  jobs.job_description, " +
                "  typs.benefit_value AS type, " +
                "  benpos.quantity " +
                "FROM hr_lu_benefit_position benpos " +
                "INNER JOIN hr_lu_benefit_types typs " +
                "ON typs.benefit_type_id = benpos.benefit_type_id " +
                "INNER JOIN hr_lu_job_type jobs " +
                "ON jobs.job_code=BENPOS.POSITION_ID " +
                "INNER JOIN hr_dept_job dept " +
                "ON dept.job_code=jobs.job_code " +
                "INNER JOIN tbl_department tbl " +
                "ON tbl.dept_id=dept.dept_id" ;
               // " where benpos.TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";

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

    public OracleCachedRowSet readAllBenefitDaily(HashMap Daylist) throws SQLException {
        String select = "SELECT DISTINCT typs.benefit_name, " +
                "  typs.benefit_value, " +
                "  typs.monetary , " +
                "  typs.description, " +
                "  typs.benefit_duration, " +
                "  tbl.dep_description, " +
                "  jobs.job_description, " +
                "  typs.benefit_value AS type, " +
                "  benpos.quantity " +
                "FROM hr_lu_benefit_position benpos " +
                "INNER JOIN hr_lu_benefit_types typs " +
                "ON typs.benefit_type_id = benpos.benefit_type_id " +
                "INNER JOIN hr_lu_job_type jobs " +
                "ON jobs.job_code=BENPOS.POSITION_ID " +
                "INNER JOIN hr_dept_job dept " +
                "ON dept.job_code=jobs.job_code " +
                "INNER JOIN vw_department_summary tbl " +
                "ON tbl.dept_id=dept.dept_id " ;
                //"where  to_date(subStr(benpos.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                //" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
               // " AND TO_DATE(? ,'YYYY-MM-DD') ";
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

    public OracleCachedRowSet readAllBenefitQuarterly(HashMap Daylist) throws SQLException {

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

        String select = "SELECT DISTINCT typs.benefit_name, " +
                "  typs.benefit_value, " +
                "  typs.monetary , " +
                "  typs.description, " +
                "  typs.benefit_duration, " +
                "  tbl.dep_description, " +
                "  jobs.job_description, " +
                "  typs.benefit_value AS type, " +
                "  benpos.quantity " +
                "FROM hr_lu_benefit_position benpos " +
                "INNER JOIN hr_lu_benefit_types typs " +
                "ON typs.benefit_type_id = benpos.benefit_type_id " +
                "INNER JOIN hr_lu_job_type jobs " +
                "ON jobs.job_code=BENPOS.POSITION_ID " +
                "INNER JOIN hr_dept_job dept " +
                "ON dept.job_code=jobs.job_code " +
                "INNER JOIN vw_department_summary tbl " +
                "ON tbl.dept_id=dept.dept_id " ;
               // "where  to_date(subStr(benpos.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                //" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                //" AND TO_DATE(? ,'YYYY-MM-DD') ";
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

    public OracleCachedRowSet readAllBenefitSemiAnnually(HashMap Daylist) throws SQLException {
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

        String select = "SELECT DISTINCT typs.benefit_name, " +
                "  typs.benefit_value, " +
                "  typs.monetary , " +
                "  typs.description, " +
                "  typs.benefit_duration, " +
                "  tbl.dep_description, " +
                "  jobs.job_description, " +
                "  typs.benefit_value AS type, " +
                "  benpos.quantity " +
                "FROM hr_lu_benefit_position benpos " +
                "INNER JOIN hr_lu_benefit_types typs " +
                "ON typs.benefit_type_id = benpos.benefit_type_id " +
                "INNER JOIN hr_lu_job_type jobs " +
                "ON jobs.job_code=BENPOS.POSITION_ID " +
                "INNER JOIN hr_dept_job dept " +
                "ON dept.job_code=jobs.job_code " +
                "INNER JOIN vw_department_summary tbl " +
                "ON tbl.dept_id=dept.dept_id " ;
                //"where  to_date(subStr(benpos.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                //" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
               // " AND TO_DATE(? ,'YYYY-MM-DD') ";
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

    public OracleCachedRowSet readAllBenefitAnnually(HashMap Daylist) throws SQLException {

        String select = "SELECT DISTINCT typs.benefit_name, " +
                "  typs.benefit_value, " +
                "  typs.monetary , " +
                "  typs.description, " +
                "  typs.benefit_duration, " +
                "  tbl.dep_description, " +
                "  jobs.job_description, " +
                "  typs.benefit_value AS type, " +
                "  benpos.quantity " +
                "FROM hr_lu_benefit_position benpos " +
                "INNER JOIN hr_lu_benefit_types typs " +
                "ON typs.benefit_type_id = benpos.benefit_type_id " +
                "INNER JOIN hr_lu_job_type jobs " +
                "ON jobs.job_code=BENPOS.POSITION_ID " +
                "INNER JOIN hr_dept_job dept " +
                "ON dept.job_code=jobs.job_code " +
                "INNER JOIN vw_department_summary tbl " +
                "ON tbl.dept_id=dept.dept_id " ;
                //"where  benpos.TIME_STAMP LIKE '" + Daylist.get("year") + "-%-%'";
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