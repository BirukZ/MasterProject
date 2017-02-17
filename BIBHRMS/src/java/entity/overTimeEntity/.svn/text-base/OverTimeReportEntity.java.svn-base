/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.overTimeEntity;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import manager.educationManager.EducationCostModel;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Mugher
 */
public class OverTimeReportEntity extends ConnectionManager{

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

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
    //String budjetYear, int institutionId, int trainingId
public ResultSet selectOverTimeRequests() throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path AS REQUESTER_DEPT_PATH, " +
"  vw.job_description As REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description As EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id" +
"WHERE otreq.status NOT LIKE 'App-%'";


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
                //"vw.department_path,vw.job_description,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeRequestsByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path AS REQUESTER_DEPT_PATH, " +
"  vw.job_description As REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description As EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"WHERE otreq.status NOT LIKE 'App-%' AND otEmp.START_DATE LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeRequestsByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

            String startDay="";
            String endDay="";
            String year;
            if(Integer.parseInt(list.get("quarterType").toString())==1){
              year=list.get("year").toString();
              startDay=""+year+"-01-01";
              endDay= ""+year+"-03-31";
            }
            else if(Integer.parseInt(list.get("quarterType").toString())==2){
              year=list.get("year").toString();
              startDay=""+year+"-04-01";
              endDay= ""+year+"-06-30";

            }
            else if(Integer.parseInt(list.get("quarterType").toString())==3){
              year=list.get("year").toString();
              startDay=""+year+"-07-01";
              endDay= ""+year+"-09-30";
            }
            else if(Integer.parseInt(list.get("quarterType").toString())==4){
              year=list.get("year").toString();
              startDay=""+year+"-10-01";
              endDay= ""+year+"-12-31";
            }

String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path AS REQUESTER_DEPT_PATH, " +
"  vw.job_description As REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description As EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"WHERE otreq.status NOT LIKE 'App-%' AND   to_date(subStr(otEmp.START_DATE,1,10),'YYYY-MM-DD')" +
" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
" AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeRequestsByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path AS REQUESTER_DEPT_PATH, " +
"  vw.job_description As REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description As EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"WHERE otreq.status NOT LIKE 'App-%' AND   to_date(subStr(otEmp.START_DATE,1,10),'YYYY-MM-DD')" +
" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
" AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeRequestsBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

            String startDay="";
            String endDay="";
            String year=list.get("year").toString();
            String[] FinalYear=year.split("_");
            String currentBudjuetYear=FinalYear[0];
            String nextBudjuetYear=FinalYear[1];
            if(Integer.parseInt(list.get("simiannualType").toString())==1){
              year=currentBudjuetYear;
              startDay=""+year+"-07-01";
              endDay= ""+year+"-12-31";
            }
            else if(Integer.parseInt(list.get("simiannualType").toString())==2){
              year=nextBudjuetYear;
              startDay=""+year+"-01-01";
              endDay= ""+year+"-06-30";

            }

String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path AS REQUESTER_DEPT_PATH, " +
"  vw.job_description As REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description As EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"WHERE otreq.status NOT LIKE 'App-%' AND   to_date(subStr(otEmp.START_DATE,1,10),'YYYY-MM-DD')" +
" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
" AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

//public ResultSet readAllOverTimeRequestsByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
//        String _selectQuery = "SELECT otreq.requester_id, " +
//"  infoReq.FIRST_NAME " +
//"  ||infoReq.MIDDLE_NAME " +
//"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
//"  vw.department_path AS REQUESTER_DEPT_PATH, " +
//"  vw.job_description As REQUESTER_JOB_DESC, " +
//"  otreq.applied_date, " +
//"  otemp.start_date, " +
//"  otemp.end_date, " +
//"  otemp.start_time, " +
//"  otemp.end_time, " +
//"  otreq.reason, " +
//"  otemp.employee_id, " +
//"  infoEmp.FIRST_NAME " +
//"  ||infoEmp.MIDDLE_NAME " +
//"  ||infoEmp.LAST_NAME AS EMPLOYEE_FULL_NAME, " +
//"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
//"  vvww.job_description As EMPLOYEE_JOB_DESC, " +
//"  infoemp.office_or_shift " +
//"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
//"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
//"ON otEmp.request_id = otReq.over_time_request_id " +
//"INNER JOIN hr_employee_info infoReq " +
//"ON infoReq.emp_id=otReq.requester_id " +
//"INNER JOIN hr_employee_info infoEmp " +
//"ON infoEmp.emp_id=otEmp.employee_id " +
//"INNER JOIN vw_employee_by_department_list vw " +
//"ON vw.emp_id=otReq.requester_id " +
//"INNER JOIN vw_employee_by_department_list vvww " +
//"ON vvww.emp_id=otEmp.employee_id " +
//"WHERE otreq.status NOT LIKE 'App-%' AND otreq.TIME_STAMP LIKE '" + list.get("year") + "-%-%'";
//        if (!selectCriteria) {
//             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
//                    " ORDER BY otreq.requester_id";
//        } else {
//             _selectQuery += " ORDER BY otreq.requester_id desc";
//        }
//
//
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
// }

public ResultSet readAllOverTimeRequestsByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path AS REQUESTER_DEPT_PATH, " +
"  vw.job_description As REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description As EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"WHERE otreq.status NOT LIKE 'App-%' AND otEmp.START_DATE LIKE '" + list.get("year") + "-%-%'";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }


public ResultSet selectOverTimeApproved() throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path  AS REQUESTER_DEPT_PATH, " +
"  vw.job_description  AS REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME  AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description AS EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift, " +
"  proc.processed_by, " +
"  infoProc.FIRST_NAME " +
"  ||infoProc.MIDDLE_NAME " +
"  ||infoProc.LAST_NAME   AS DECIDER_FULL_NAME, " +
"  vvvwww.department_path AS DECIDER_DEPT_PATH, " +
"  vvvwww.job_description AS DECIDER_JOB_DESC, " +
"  proc.time_stamp " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"INNER JOIN hr_over_time_processed PROC " +
"ON proc.request_id=otEmp.request_id " +
"INNER JOIN hr_employee_info infoProc " +
"ON infoProc.emp_id=proc.processed_by " +
"INNER JOIN vw_employee_by_department_list vvvwww " +
"ON vvvwww.emp_id=proc.processed_by " +
"WHERE otreq.status LIKE 'App-%'";


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
                //"vw.department_path,vw.job_description,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeApprovedByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path  AS REQUESTER_DEPT_PATH, " +
"  vw.job_description  AS REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME  AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description AS EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift, " +
"  proc.processed_by, " +
"  infoProc.FIRST_NAME " +
"  ||infoProc.MIDDLE_NAME " +
"  ||infoProc.LAST_NAME   AS DECIDER_FULL_NAME, " +
"  vvvwww.department_path AS DECIDER_DEPT_PATH, " +
"  vvvwww.job_description AS DECIDER_JOB_DESC, " +
"  proc.time_stamp " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"INNER JOIN hr_over_time_processed PROC " +
"ON proc.request_id=otEmp.request_id " +
"INNER JOIN hr_employee_info infoProc " +
"ON infoProc.emp_id=proc.processed_by " +
"INNER JOIN vw_employee_by_department_list vvvwww " +
"ON vvvwww.emp_id=proc.processed_by " +
"WHERE otreq.status LIKE 'App-%' AND otEmp.START_DATE LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeApprovedByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

            String startDay="";
            String endDay="";
            String year;
            if(Integer.parseInt(list.get("quarterType").toString())==1){
              year=list.get("year").toString();
              startDay=""+year+"-01-01";
              endDay= ""+year+"-03-31";
            }
            else if(Integer.parseInt(list.get("quarterType").toString())==2){
              year=list.get("year").toString();
              startDay=""+year+"-04-01";
              endDay= ""+year+"-06-30";

            }
            else if(Integer.parseInt(list.get("quarterType").toString())==3){
              year=list.get("year").toString();
              startDay=""+year+"-07-01";
              endDay= ""+year+"-09-30";
            }
            else if(Integer.parseInt(list.get("quarterType").toString())==4){
              year=list.get("year").toString();
              startDay=""+year+"-10-01";
              endDay= ""+year+"-12-31";
            }

String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path  AS REQUESTER_DEPT_PATH, " +
"  vw.job_description  AS REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME  AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description AS EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift, " +
"  proc.processed_by, " +
"  infoProc.FIRST_NAME " +
"  ||infoProc.MIDDLE_NAME " +
"  ||infoProc.LAST_NAME   AS DECIDER_FULL_NAME, " +
"  vvvwww.department_path AS DECIDER_DEPT_PATH, " +
"  vvvwww.job_description AS DECIDER_JOB_DESC, " +
"  proc.time_stamp " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"INNER JOIN hr_over_time_processed PROC " +
"ON proc.request_id=otEmp.request_id " +
"INNER JOIN hr_employee_info infoProc " +
"ON infoProc.emp_id=proc.processed_by " +
"INNER JOIN vw_employee_by_department_list vvvwww " +
"ON vvvwww.emp_id=proc.processed_by " +
"WHERE otreq.status LIKE 'App-%' AND   to_date(subStr(otEmp.START_DATE,1,10),'YYYY-MM-DD')" +
" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
" AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeApprovedByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path  AS REQUESTER_DEPT_PATH, " +
"  vw.job_description  AS REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME  AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description AS EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift, " +
"  proc.processed_by, " +
"  infoProc.FIRST_NAME " +
"  ||infoProc.MIDDLE_NAME " +
"  ||infoProc.LAST_NAME   AS DECIDER_FULL_NAME, " +
"  vvvwww.department_path AS DECIDER_DEPT_PATH, " +
"  vvvwww.job_description AS DECIDER_JOB_DESC, " +
"  proc.time_stamp " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"INNER JOIN hr_over_time_processed PROC " +
"ON proc.request_id=otEmp.request_id " +
"INNER JOIN hr_employee_info infoProc " +
"ON infoProc.emp_id=proc.processed_by " +
"INNER JOIN vw_employee_by_department_list vvvwww " +
"ON vvvwww.emp_id=proc.processed_by " +
"WHERE otreq.status LIKE 'App-%' AND   to_date(subStr(otEmp.START_DATE,1,10),'YYYY-MM-DD')" +
" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
" AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeApprovedBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

            String startDay="";
            String endDay="";
            String year=list.get("year").toString();
            String[] FinalYear=year.split("_");
            String currentBudjuetYear=FinalYear[0];
            String nextBudjuetYear=FinalYear[1];
            if(Integer.parseInt(list.get("simiannualType").toString())==1){
              year=currentBudjuetYear;
              startDay=""+year+"-07-01";
              endDay= ""+year+"-12-31";
            }
            else if(Integer.parseInt(list.get("simiannualType").toString())==2){
              year=nextBudjuetYear;
              startDay=""+year+"-01-01";
              endDay= ""+year+"-06-30";

            }

String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path  AS REQUESTER_DEPT_PATH, " +
"  vw.job_description  AS REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME  AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description AS EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift, " +
"  proc.processed_by, " +
"  infoProc.FIRST_NAME " +
"  ||infoProc.MIDDLE_NAME " +
"  ||infoProc.LAST_NAME   AS DECIDER_FULL_NAME, " +
"  vvvwww.department_path AS DECIDER_DEPT_PATH, " +
"  vvvwww.job_description AS DECIDER_JOB_DESC, " +
"  proc.time_stamp " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"INNER JOIN hr_over_time_processed PROC " +
"ON proc.request_id=otEmp.request_id " +
"INNER JOIN hr_employee_info infoProc " +
"ON infoProc.emp_id=proc.processed_by " +
"INNER JOIN vw_employee_by_department_list vvvwww " +
"ON vvvwww.emp_id=proc.processed_by " +
"WHERE otreq.status LIKE 'App-%' AND   to_date(subStr(otEmp.START_DATE,1,10),'YYYY-MM-DD')" +
" BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
" AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

public ResultSet readAllOverTimeApprovedByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT otreq.requester_id, " +
"  infoReq.FIRST_NAME " +
"  ||infoReq.MIDDLE_NAME " +
"  ||infoReq.LAST_NAME AS REQUESTER_FULL_NAME, " +
"  vw.department_path  AS REQUESTER_DEPT_PATH, " +
"  vw.job_description  AS REQUESTER_JOB_DESC, " +
"  otreq.applied_date, " +
"  otemp.start_date, " +
"  otemp.end_date, " +
"  otemp.start_time, " +
"  otemp.end_time, " +
"  otreq.reason, " +
"  otemp.employee_id, " +
"  infoEmp.FIRST_NAME " +
"  ||infoEmp.MIDDLE_NAME " +
"  ||infoEmp.LAST_NAME  AS EMPLOYEE_FULL_NAME, " +
"  vvww.department_path AS EMPLOYEE_DEPT_PATH, " +
"  vvww.job_description AS EMPLOYEE_JOB_DESC, " +
"  infoemp.office_or_shift, " +
"  proc.processed_by, " +
"  infoProc.FIRST_NAME " +
"  ||infoProc.MIDDLE_NAME " +
"  ||infoProc.LAST_NAME   AS DECIDER_FULL_NAME, " +
"  vvvwww.department_path AS DECIDER_DEPT_PATH, " +
"  vvvwww.job_description AS DECIDER_JOB_DESC, " +
"  proc.time_stamp " +
"FROM HR_OVER_TIME_EMPLOYEE otEmp " +
"INNER JOIN HR_OVER_TIME_REQUEST otReq " +
"ON otEmp.request_id = otReq.over_time_request_id " +
"INNER JOIN hr_employee_info infoReq " +
"ON infoReq.emp_id=otReq.requester_id " +
"INNER JOIN hr_employee_info infoEmp " +
"ON infoEmp.emp_id=otEmp.employee_id " +
"INNER JOIN vw_employee_by_department_list vw " +
"ON vw.emp_id=otReq.requester_id " +
"INNER JOIN vw_employee_by_department_list vvww " +
"ON vvww.emp_id=otEmp.employee_id " +
"INNER JOIN hr_over_time_processed PROC " +
"ON proc.request_id=otEmp.request_id " +
"INNER JOIN hr_employee_info infoProc " +
"ON infoProc.emp_id=proc.processed_by " +
"INNER JOIN vw_employee_by_department_list vvvwww " +
"ON vvvwww.emp_id=proc.processed_by " +
"WHERE otreq.status LIKE 'App-%' AND otEmp.START_DATE LIKE '" + list.get("year") + "-%-%'";
        if (!selectCriteria) {
             _selectQuery += " AND otreq.requester_id         ='" + employeeId + "' " +
                    " ORDER BY otreq.requester_id";
        } else {
             _selectQuery += " ORDER BY otreq.requester_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
 }

//public ResultSet selectTrainingApproved() throws SQLException, SQLException {
//        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
//"  info.FIRST_NAME " +
//"  ||info.MIDDLE_NAME " +
//"  ||info.LAST_NAME AS FULL_NAME, " +
//"  vw.department_path, " +
//"  vw.job_description, " +
//"  catego.CATEGORY_NAME, " +
//"  lists.TRAINING_NAME, " +
//"  lists.APPLIED_DATE, " +
//"  lists.tentative_start_date, " +
//"  lists.tentative_end_date, " +
//"  lists.no_of_days, " +
//"  lists.award, " +
//"  inst.INSTITUTION_NAME, " +
//"  lists.trainer_name " +
//"FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
//"INNER JOIN hr_employee_info info " +
//"ON info.emp_id=req.employee_id " +
//"INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
//"ON req.request_id=lists.need_assessement_request_id " +
//"INNER JOIN vw_employee_by_department_list vw " +
//"ON vw.emp_id=req.employee_id " +
//"INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
//"ON catego.category_id=lists.training_category " +
//"LEFT JOIN HR_EMP_EDUCATION educ " +
//"ON educ.emp_id=req.employee_id " +
//"INNER JOIN HR_EDUC_INSTITUTION inst " +
//"ON inst.institution_id=lists.proposed_institution_or_place " +
//"INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bku " +
//"ON bku.emp_id=req.employee_id " +
//"LEFT JOIN HR_LU_EDUC_LEVEL levl " +
//"ON levl.educ_level_code=educ.educ_level_code " +
//"WHERE lists.REQUEST_STATUS='App-201'";
//
//
//        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
//                //"vw.department_path,vw.job_description,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
////            _ps.setInt(1, trainingId);
////            _ps.setString(2, budjetYear);
////            _ps.setInt(3, institutionId);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
// }
//
//public ResultSet selectTrainingCosts() throws SQLException, SQLException {
//        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
//"  info.FIRST_NAME " +
//"  || info.MIDDLE_NAME " +
//"  || info.LAST_NAME AS FULL_NAME, " +
//"  vw.department_path, " +
//"  vw.job_description, " +
//"  catego.CATEGORY_NAME, " +
//"  lists.TRAINING_NAME, " +
//"  costdetail.training_fee, " +
//"  costdetail.intertainment_fee, " +
//"  costdetail.transport_fee, " +
//"  costdetail.fee_for_trainer, " +
//"  costdetail.allowance_fee, " +
//"  costdetail.stationary_fee, " +
//"  costdetail.other_fees, " +
//"  costdetail.costperperson " +
//"FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
//"INNER JOIN hr_employee_info info " +
//"ON info.emp_id=req.employee_id " +
//"INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
//"ON req.request_id=lists.need_assessement_request_id " +
//"INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
//"ON catego.category_id=lists.training_category " +
//"INNER JOIN vw_employee_by_department_list vw " +
//"ON vw.emp_id=req.employee_id " +
//"INNER JOIN hr_lu_training_cost_detail costdetail " +
//"ON costdetail.emp_id=req.employee_id";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
////            _ps.setInt(1, trainingId);
////            _ps.setString(2, budjetYear);
////            _ps.setInt(3, institutionId);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
// }


}
