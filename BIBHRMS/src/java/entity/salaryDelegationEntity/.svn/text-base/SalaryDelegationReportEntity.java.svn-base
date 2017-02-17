/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.salaryDelegationEntity;

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
public class SalaryDelegationReportEntity extends ConnectionManager {
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

    public OracleCachedRowSet readAllSalaryDelegation() throws SQLException {
        String _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%'";

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
    }
    //===================================Monthly==================================================================
     public OracleCachedRowSet readAllSalaryDelegationMonthly(HashMap Daylist) throws SQLException {
         String _selectquery=null;
               if(ReportCriteraManager.allEmployee)
                       {
         _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%'AND TIME_STAMP LIKE '" + Daylist.get("year") + "-%" + Daylist.get("month") + "-%'";
           }
         else if(!ReportCriteraManager.allEmployee)
             {
         _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%'AND TIME_STAMP LIKE '" + Daylist.get("year") + "-%" + Daylist.get("month") + "-%' and epf.EMP_ID ='"+ReportCriteraManager.getEmployeeId()+"'";

         }
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
    }

    //=================================Quarterly==================================================================

      public OracleCachedRowSet readAllSalaryDelegationQuartrely(HashMap Daylist) throws SQLException {
             String _selectquery=null;
             String startDay="";
            String endDay="";
            String year;
            if(Integer.parseInt(Daylist.get("quarterType").toString())==1){
              year=Daylist.get("year").toString();
              startDay=""+year+"-01-01";
              endDay= ""+year+"-03-31";
            }
            else if(Integer.parseInt(Daylist.get("quarterType").toString())==2){
              year=Daylist.get("year").toString();
              startDay=""+year+"-04-01";
              endDay= ""+year+"-06-30";

            }
            else if(Integer.parseInt(Daylist.get("quarterType").toString())==3){
              year=Daylist.get("year").toString();
              startDay=""+year+"-07-01";
              endDay= ""+year+"-09-30";
            }
            else if(Integer.parseInt(Daylist.get("quarterType").toString())==4){
              year=Daylist.get("year").toString();
              startDay=""+year+"-10-01";
              endDay= ""+year+"-12-31";
            }
               if(ReportCriteraManager.allEmployee){
            _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%' AND   to_date(subStr(sdp.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
               }
               else if(!ReportCriteraManager.allEmployee){

                _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%' AND   to_date(subStr(sdp.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD')  and  epf.EMP_ID ='"+ReportCriteraManager.getEmployeeId()+"'";

               }
       try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectquery);
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
   //==================================Simmannually================================================================

       public OracleCachedRowSet readAllSalaryDelegationSimmannulay(HashMap Daylist) throws SQLException {
            String _selectquery=null;
            String startDay="";
            String endDay="";
            String year=Daylist.get("year").toString();
            String[] FinalYear=year.split("_");
            String currentBudjuetYear=FinalYear[0];
            String nextBudjuetYear=FinalYear[1];
            if(Integer.parseInt(Daylist.get("simiannualType").toString())==1){
              year=currentBudjuetYear;
              startDay=""+year+"-07-01";
              endDay= ""+year+"-12-31";
            }
            else if(Integer.parseInt(Daylist.get("simiannualType").toString())==2){
              year=nextBudjuetYear;
              startDay=""+year+"-01-01";
              endDay= ""+year+"-06-30";

            }
            if(ReportCriteraManager.allEmployee)
                   {
         _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items, " +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate," +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%' AND   to_date(subStr(sdp.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
            }
            else if(!ReportCriteraManager.allEmployee){

            _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items, " +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate," +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%' AND   to_date(subStr(sdp.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') and epf.EMP_ID ='"+ReportCriteraManager.getEmployeeId()+"'";

            }


       try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectquery);
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
  //=============================================Annulay====================================================

        public OracleCachedRowSet readAllSalaryDelegationAnnulay(HashMap Daylist) throws SQLException {
        String _selectquery=null;
            if(ReportCriteraManager.allEmployee)
                   {
           _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%'AND TIME_STAMP LIKE '" + Daylist.get("year") + "-%-%'";
            }
            else if(!ReportCriteraManager.allEmployee){

            _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%'AND TIME_STAMP LIKE '" + Daylist.get("year") + "-%-%' and epf.EMP_ID ='"+ ReportCriteraManager.getEmployeeId() +"'";

            }

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
    }
 //=====================================Daily========================================================

         public OracleCachedRowSet readAllSalaryDelegationDaily(HashMap Daylist) throws SQLException {
           String _selectquery=null;
           if(ReportCriteraManager.allEmployee){
         _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%' AND   to_date(subStr(sdp.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
           }
           else if(!ReportCriteraManager.allEmployee){

            _selectquery= " SELECT sdr.start_date," +
                " sdr.end_date,  " +
                " sdr.reason AS DelegationReaouns, " +
                " sdr.delegated_items," +
                " subStr(sdp.TIME_STAMP,1,10) AS approvedDate, " +
                " epf.EMP_ID AS DelegatorID, " +
                " epf.FIRST_NAME AS DelegatorFirst_Name, " +
                " epf.MIDDLE_NAME AS Delegator_MiddleName,  " +
                " epf.LAST_NAME AS Delegator_LastName," +
                " epf.department_name AS Delegator_Department, " +
                " epf.job_description AS Delegator_JobTitle," +
                " lst.emp_id As DelegateID," +
                " lst.first_name AS Delegate_First_Name," +
                " lst.middle_name     AS Delegate_Middle_Name," +
                " lst.last_name       AS Delegate_Last_Name," +
                " epf.department_name AS Delegate_Department, " +
                " epf.job_description AS Delegate_Job_Position, " +
                " epf.rank_id As DelegateRank " +
                " FROM hr_salary_delegation_request  sdr " +
                " INNER JOIN vw_employee_by_department_bi epf" +
                " ON epf.EMP_ID =sdr.delegator_id " +
                " INNER JOIN vw_employee_by_department_list lst" +
                " ON lst.EMP_ID=sdr.delegatee_id " +
                " inner Join HR_SALARY_DELEGATION_PROCESSED sdp " +
                " on sdp.request_id=sdr.salary_delegation_request_id " +
                " WHERE sdr.status like 'App-%' AND   to_date(subStr(sdp.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') and epf.EMP_ID ='"+ ReportCriteraManager.getEmployeeId()+"'";

           }

       try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectquery);
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
//==================================================================================================
    

}
