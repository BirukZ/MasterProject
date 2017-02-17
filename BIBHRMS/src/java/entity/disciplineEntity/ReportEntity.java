/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.disciplineEntity;

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
 * @author Biruk
 */
public class ReportEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;
    Connection _con2 = null;
    //  ReportCriteraManager criteraManager=new ReportCriteraManager();

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

    public OracleCachedRowSet readAllDiscipline() throws SQLException {

        String _selectquery = "SELECT  dis.offence_date," +
                " dis.reported_date," +
                " dil.offence_name," +
                " dis.description_of_offence," +
                " dis.requested_measure_to_be_taken," +
                " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                " nvl(dis.witness_type,'. ') as witness_type," +
                " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                " dis.requested_measure_to_be_taken, " +
                " dip.forwarded_to_committee," +
                " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                " nvl( dip.approved_penality,'.') AS approved_penality, " +
                " nvl( dip.approved_duration,'.') AS approved_duration, " +
                " dip.approved_deduct, " +
                " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                " epf.EMP_ID AS Offender_ID," +
                " epf.FIRST_NAME AS OffenderFirst_Name, " +
                " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                " epf.LAST_NAME AS OffenderLast_Name, " +
                " epf.department_name AS Offender_Department, " +
                " epf.JOB_NAME AS Offender_JobTitle," +
                "  BK.EMP_ID                   AS Requester_ID, " +
                "  bk.FIRST_NAME               AS Requester_First_Name, " +
                "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                "  bk.LAST_NAME                AS Requester_Last_Name, " +
                "  bk.DEPT_NAME                AS Requester_Department, " +
                "  bk.JOB_NAME                 AS Requester_Job_Position " +
                " FROM HR_DISCIPLINE_ISSUE dis" +
                " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                " on dis.discipline_problem_id=accd.request_id " +
                " INNER JOIN vw_employee_by_department_list epf " +
                " ON epf.EMP_ID =dis.OFFENDER_ID " +
                " INNER JOIN vw_employee_by_department_bku bk " +
                " ON bk.EMP_ID =dis.REQUESTER_ID " +
                " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                " INNER JOIN hr_disciplined_type_repitition dir " +
                " ON dis.offence_type =dir.descipline_type " +
                " INNER JOIN hr_lu_penalty_type plt " +
                " ON dir.penalty =plt.penalty_type_id " +
                " INNER JOIN hr_lu_discipline_type dil " +
                " ON dis.offence_type =dil.descipline_type_id " +
                "  WHERE dis.status  like 'APP%'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectquery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    // return null;
    }

//     public ResultSet SelecteMonth(String selectedMonth, String employee_ID) {
//        return null;
//    }
    //==================================================Monthly===========================================================================
    public OracleCachedRowSet readAllDisciplineByMonth(HashMap list) throws SQLException {
        String _selectquery = null;
        String _selectqueryByID = null;


        if (ReportCriteraManager.allEmployee) {
            _selectquery = "SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle, " +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";
        } else if (!ReportCriteraManager.allEmployee) {
            _selectquery = "SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle, " +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'and  epf.EMP_ID='" + ReportCriteraManager.getEmployeeId() + "'";
        }
        _con = getConnection();
        _ps = _con.prepareStatement(_selectquery);
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return ocrs;

    //releaseResources();

    // return null;
    }

    //=======================================Daily============================================================
    public OracleCachedRowSet readAllDisciplineByDays(HashMap Daylist) throws SQLException {
        String _selectquery = null;

        if (ReportCriteraManager.allEmployee) {
            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.job_name AS Offender_JobTitle, " +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND   to_date(subStr(dip.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') ";
        } else if (!ReportCriteraManager.allEmployee) {
            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle," +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND   to_date(subStr(dip.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') and epf.EMP_ID='" + ReportCriteraManager.getEmployeeId() + "'";
        }

        _con = getConnection();
        _ps = _con.prepareStatement(_selectquery);
        _ps.setString(1, Daylist.get("StartDay").toString());
        _ps.setString(2, Daylist.get("endDate").toString());
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return ocrs;

    //releaseResources();

    // return null;
    }
    //==================================Quarterly===========================================================

    public OracleCachedRowSet readAllDisciplineByQuarter(HashMap Daylist) throws SQLException {
        String _selectquery = null;
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
        if (ReportCriteraManager.allEmployee) {
            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle, " +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND   to_date(subStr(dip.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') ";
        } else if (ReportCriteraManager.allEmployee) {

            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle," +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND   to_date(subStr(dip.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') and epf.EMP_ID='" + ReportCriteraManager.getEmployeeId() + "'";
        }

        _con = getConnection();
        _ps = _con.prepareStatement(_selectquery);
        _ps.setString(1, startDay);
        _ps.setString(2, endDay);
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return ocrs;

    }
    //============================================Simiannualy=========================================================

    public OracleCachedRowSet readAllDisciplineBySimiannual(HashMap Daylist) throws SQLException {
        String _selectquery = null;
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
        if (ReportCriteraManager.allEmployee) {
            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle," +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND   to_date(subStr(dip.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') ";
        } else if (!ReportCriteraManager.allEmployee) {
            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " dip.forwarded_to_committee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle," +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND   to_date(subStr(dip.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                    " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                    " AND TO_DATE(? ,'YYYY-MM-DD') and epf.EMP_ID='" + ReportCriteraManager.getEmployeeId() + "'";

        }
        _con = getConnection();
        _ps = _con.prepareStatement(_selectquery);
        _ps.setString(1, startDay);
        _ps.setString(2, endDay);
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return ocrs;

    }
    //========================================Annulay============================================================

    public OracleCachedRowSet readAllDisciplineByAnnual(HashMap Daylist) throws SQLException {

        String _selectquery = null;

        if (ReportCriteraManager.allEmployee) {
            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " NVL(dip.forwarded_to_committee,'.') As ForwardToCommittee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle," +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND TIME_STAMP LIKE '" + Daylist.get("year") + "-%-%'";
        } else if (!ReportCriteraManager.allEmployee) {

            _selectquery = " SELECT  dis.offence_date," +
                    " dis.reported_date," +
                    " dil.offence_name," +
                    " dis.description_of_offence," +
                    " dis.requested_measure_to_be_taken," +
                    " nvl( accd.description_on_accusation,'.') As OffenderInterst, " +
                    " nvl(dis.witness_type,'. ') as witness_type," +
                    " nvl(dis.witness_type_other,'.') as witness_type_other, " +
                    " dis.requested_measure_to_be_taken, " +
                    " NVL(dip.forwarded_to_committee,'.') As ForwardToCommittee," +
                    " nvl(chirman.commeentes_given,'.') AS CommentesGiven, " +
                    " nvl( dip.approved_penality,'.') AS approved_penality, " +
                    " nvl( dip.approved_duration,'.') AS approved_duration, " +
                    " dip.approved_deduct, " +
                    " subStr(dip.TIME_STAMP,1,10) AS approvedDate," +
                    " epf.EMP_ID AS Offender_ID," +
                    " epf.FIRST_NAME AS OffenderFirst_Name, " +
                    " epf.MIDDLE_NAME AS OffenderMiddle_Name, " +
                    " epf.LAST_NAME AS OffenderLast_Name, " +
                    " epf.department_name AS Offender_Department, " +
                    " epf.JOB_NAME AS Offender_JobTitle," +
                    "  BK.EMP_ID                   AS Requester_ID, " +
                    "  bk.FIRST_NAME               AS Requester_First_Name, " +
                    "  bk.MIDDLE_NAME              AS Requester_Middle_Name, " +
                    "  bk.LAST_NAME                AS Requester_Last_Name, " +
                    "  bk.DEPT_NAME                AS Requester_Department, " +
                    "  bk.JOB_NAME                 AS Requester_Job_Position " +
                    " FROM HR_DISCIPLINE_ISSUE dis" +
                    " Left JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
                    " on dis.discipline_problem_id=chirman.discipline_problem_id" +
                    " Left JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
                    " on dis.discipline_problem_id=accd.request_id " +
                    " INNER JOIN vw_employee_by_department_list epf " +
                    " ON epf.EMP_ID =dis.OFFENDER_ID " +
                    " INNER JOIN vw_employee_by_department_bku bk " +
                    " ON bk.EMP_ID =dis.REQUESTER_ID " +
                    " INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
                    " ON dis.discipline_problem_id =dip.REQUEST_ID " +
                    " INNER JOIN hr_disciplined_type_repitition dir " +
                    " ON dis.offence_type =dir.descipline_type " +
                    " INNER JOIN hr_lu_penalty_type plt " +
                    " ON dir.penalty =plt.penalty_type_id " +
                    " INNER JOIN hr_lu_discipline_type dil " +
                    " ON dis.offence_type =dil.descipline_type_id " +
                    " WHERE dis.status  like 'APP%' AND TIME_STAMP LIKE '" + Daylist.get("year") + "-%-%' and epf.EMP_ID='" + ReportCriteraManager.getEmployeeId() + "'";

        }
        _con = getConnection();
        _ps = _con.prepareStatement(_selectquery);
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return ocrs;

    //releaseResources();

    // return null;
    }

    //================================================================================================================
}
