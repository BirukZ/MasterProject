/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.powerDeligationEntity;

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
public class PowerDeligationApproveReportEntity extends  ConnectionManager  {
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


//=========================================ReportApprovedCondition================================================================

    public OracleCachedRowSet readAllPowerDelegationApprovedMontly(HashMap Daylist) throws SQLException {

         String _selectquery=null;

           if(ReportCriteraManager.allEmployee){
           _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%'AND RECORDED_DATE LIKE '" + Daylist.get("year") + "-%" + Daylist.get("month") + "-%'" ;
               }
           else if(!ReportCriteraManager.allEmployee){

           _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%'AND RECORDED_DATE LIKE '" + Daylist.get("year") + "-%" + Daylist.get("month") + "-%' and lst.emp_id ='"+ReportCriteraManager.getEmployeeId()+"'";

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

    /////////////////////////////////////////////Quarterly==========================================================

    public OracleCachedRowSet readAllPowerDelegationApprovedQuarterly(HashMap Daylist) throws SQLException {

       
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
            if(ReportCriteraManager.allEmployee)
                     {
                
             _selectquery="SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%' AND  to_date(RECORDED_DATE,'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
                     }
            else if(!ReportCriteraManager.allEmployee)
                    {
           
            _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%'AND  to_date(RECORDED_DATE,'YYYY-MM-DD')" +
                "  BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') and  lst.emp_id ='"+ReportCriteraManager.getEmployeeId()+"'";
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


    //====================================Simmannual======================================================

    public OracleCachedRowSet readAllPowerDelegationApprovedSimannualy(HashMap Daylist) throws SQLException {
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
            if(ReportCriteraManager.allEmployee){
          _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%'AND to_date(RECORDED_DATE,'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD')";
            }
            else if(!ReportCriteraManager.allEmployee){

             _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%'AND to_date(RECORDED_DATE,'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') and lst.emp_id ='"+ReportCriteraManager.getEmployeeId()+"'";


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
    //=====================================Annulay==========================================================
    
    public OracleCachedRowSet readAllPowerDelegationApprovedAnnulay(HashMap Daylist) throws SQLException {
             String _selectquery=null;
           

           if(ReportCriteraManager.allEmployee)
                      {
          _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%' AND RECORDED_DATE LIKE '" + Daylist.get("year") + "-%-%'" ;
                                  }
              else if(!ReportCriteraManager.allEmployee)
                          {
              _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%' AND RECORDED_DATE LIKE '" + Daylist.get("year") + "-%-%' and lst.emp_id ='"+ ReportCriteraManager.getEmployeeId() +"'";
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
    //===============================================================================================================

    public OracleCachedRowSet readAllPowerDelegationApprovedDaily(HashMap Daylist) throws SQLException {
            String _selectquery=null;
            if(ReportCriteraManager.allEmployee){
         _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%' AND to_date(RECORDED_DATE,'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD')";
            }
            else if(!ReportCriteraManager.allEmployee){

             _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%' AND to_date(RECORDED_DATE,'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') and lst.emp_id ='"+ ReportCriteraManager.getEmployeeId()+"'";


            }
       try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectquery);
            _ps.setString(1,Daylist.get("StartDay").toString());
            _ps.setString(2, Daylist.get("endDate").toString());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }
    //================================================================================================================
     public OracleCachedRowSet readAllPowerDelegationApproved() throws SQLException {
         String _selectquery=" SELECT pdr.start_date, " +
                 " nvl(pdr.end_date,'.') AS end_date, " +
                 " pdr.deligation_reason, " +
                 " PDP.RECORDED_DATE AS APPROVEDDATE, " +
                 " DECODE(epf.EMP_ID,NULL,' ',epf.EMP_ID) AS DelegatorID, " +
                 " DECODE(epf.FIRST_NAME,NULL,' ',epf.FIRST_NAME) AS DelegatorFirst_Name, " +
                 " DECODE(epf.MIDDLE_NAME,NULL,' ',epf.MIDDLE_NAME) AS Delegator_Middle_Name," +
                 " DECODE(epf.LAST_NAME,NULL,' ',epf.LAST_NAME)     AS Delegator_last_Name, " +
                 " DECODE(epf.rank_id,NULL,' ',epf.rank_id)         AS DelegatorRank, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS DELEGATEDPOSITION, " +
                 " DECODE(EPF.DEPARTMENT_NAME,NULL,PDR.HR_NEWDEPARTMET_NAME,EPF.DEPARTMENT_NAME)      AS DELEGATOR_DEPARTMENT, " +
                 " DECODE(epf.job_description,NULL,PDR.HR_NEWDEPARTMENT_POSITION,epf.job_description) AS Delegator_JobTitle, " +
                 " lst.emp_id  AS delegateID, " +
                 " lst.first_name  AS Delegate_First_Name, " +
                 " lst.middle_name  AS Delegate_Middle_Name, " +
                 " lst.last_name AS Delegate_Last_Name, " +
                 " lst.rank_id  AS delegateRank," +
                 " lst.department_name   AS delegete_Department, " +
                 " lst.job_description as delegete_position," +
                 " bku.emp_id as requester_ID, " +
                 " bku.first_name as requester_first_name, " +
                 " bku.middle_name as requester_midleName," +
                 " bku.last_name as requester_last_name, " +
                 " bku.job_description as requester_job," +
                 " bku.department_name as requester_department_Name, " +
                 " bku.rank_id as requester_rank," +
                 " prb.emp_id  AS ApproverID," +
                 " prb.first_name AS approverFirstName, " +
                 " prb.middle_name  AS approverMiddleName, " +
                 " prb.last_name  AS approverLastName, " +
                 " prb.job_description AS approverJobPosition, " +
                 " prb.department_name   AS departmentName, " +
                 " pdp.recorded_date " +
                 " FROM HR_POWER_DELIGATION_REQUEST pdr " +
                 " LEFT JOIN vw_employee_by_department_bi epf " +
                 " ON EPF.EMP_ID =PDR.DELIGATOR_ID" +
                 " INNER JOIN HR_POWER_DELIGATION_PROCESSED pdp " +
                 " ON pdp.pow_del_req_id =pdr.pow_del_req_id " +
                 " inner join VW_EMPLOYEE_BY_DEPARTMENT_BI bku " +
                 " on bku.emp_id=pdr.requester_id " +
                 " INNER JOIN VIEW_DEPTNAME prb " +
                 " ON prb.EMP_ID =pdp.processed_by " +
                 " INNER JOIN vw_employee_by_department_list lst " +
                 " ON lst.EMP_ID =pdr.delegatee_id " +
                 " WHERE pdr.deligation_status LIKE'App%' ";
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
    //==================================================================================================================

}
