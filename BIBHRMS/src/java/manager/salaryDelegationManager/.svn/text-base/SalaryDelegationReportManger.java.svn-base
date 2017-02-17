/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.salaryDelegationManager;

import entity.salaryDelegationEntity.SalaryDelegationReportEntity;
import java.util.ArrayList;
import java.util.HashMap;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Biruk
 */
public class SalaryDelegationReportManger {

SalaryDelegationReportEntity  salaryDelegationEntity =new SalaryDelegationReportEntity();

    public ArrayList<HashMap> getSalaryReportList() {
       try {
            ArrayList<HashMap> SalaryDelegationApproveReportList = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = salaryDelegationEntity.readAllSalaryDelegation();
             while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("start_date", ocrs.getString("start_date"));
                resultInfo.put("end_date", ocrs.getString("end_date"));
                resultInfo.put("DelegationReaouns", ocrs.getString("DelegationReaouns"));
                resultInfo.put("delegated_items", ocrs.getString("delegated_items"));
                resultInfo.put("DelegatorID", ocrs.getString("DelegatorID"));
                resultInfo.put("DelegatorFirst_Name", ocrs.getString("DelegatorFirst_Name"));
                resultInfo.put("Delegator_MiddleName", ocrs.getString("Delegator_MiddleName"));
                resultInfo.put("Delegator_LastName", ocrs.getString("Delegator_LastName"));
                resultInfo.put("Delegator_Department", ocrs.getString("Delegator_Department"));
                resultInfo.put("Delegator_JobTitle", ocrs.getString("Delegator_JobTitle"));
                resultInfo.put("DelegateID", ocrs.getString("DelegateID"));
                resultInfo.put("Delegate_First_Name", ocrs.getString("Delegate_First_Name"));
                resultInfo.put("Delegate_Middle_Name", ocrs.getString("Delegate_Middle_Name"));
                resultInfo.put("Delegate_Last_Name", ocrs.getString("Delegate_Last_Name"));
                resultInfo.put("Delegate_Department", ocrs.getString("Delegate_Department"));
                resultInfo.put("Delegate_Job_Position", ocrs.getString("Delegate_Job_Position"));
                resultInfo.put("DelegateRank", ocrs.getString("DelegateRank"));
                SalaryDelegationApproveReportList.add(resultInfo);
            }
            return SalaryDelegationApproveReportList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }
    
     public ArrayList<HashMap> getAllSalaryReportList() {
       ArrayList<HashMap> SalaryDelegationApproveReportList = new ArrayList<HashMap>();
       
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
            
       try {
            
            OracleCachedRowSet ocrs = salaryDelegationEntity.readAllSalaryDelegationMonthly(ReportCriteraManager.getParametrsForDay());
             while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("start_date", ocrs.getString("start_date"));
                resultInfo.put("end_date", ocrs.getString("end_date"));
                resultInfo.put("DelegationReaouns", ocrs.getString("DelegationReaouns"));
                resultInfo.put("delegated_items", ocrs.getString("delegated_items"));
                resultInfo.put("DelegatorID", ocrs.getString("DelegatorID"));
                resultInfo.put("DelegatorFirst_Name", ocrs.getString("DelegatorFirst_Name"));
                resultInfo.put("Delegator_MiddleName", ocrs.getString("Delegator_MiddleName"));
                resultInfo.put("Delegator_LastName", ocrs.getString("Delegator_LastName"));
                resultInfo.put("Delegator_Department", ocrs.getString("Delegator_Department"));
                resultInfo.put("Delegator_JobTitle", ocrs.getString("Delegator_JobTitle"));
                resultInfo.put("DelegateID", ocrs.getString("DelegateID"));
                resultInfo.put("Delegate_First_Name", ocrs.getString("Delegate_First_Name"));
                resultInfo.put("Delegate_Middle_Name", ocrs.getString("Delegate_Middle_Name"));
                resultInfo.put("Delegate_Last_Name", ocrs.getString("Delegate_Last_Name"));
                resultInfo.put("Delegate_Department", ocrs.getString("Delegate_Department"));
                resultInfo.put("Delegate_Job_Position", ocrs.getString("Delegate_Job_Position"));
                resultInfo.put("DelegateRank", ocrs.getString("DelegateRank"));
                SalaryDelegationApproveReportList.add(resultInfo);
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }   else if(ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly")){
                   try {
            
            OracleCachedRowSet ocrs = salaryDelegationEntity.readAllSalaryDelegationQuartrely(ReportCriteraManager.getParametrsForDay());
             while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("start_date", ocrs.getString("start_date"));
                resultInfo.put("end_date", ocrs.getString("end_date"));
                resultInfo.put("DelegationReaouns", ocrs.getString("DelegationReaouns"));
                resultInfo.put("delegated_items", ocrs.getString("delegated_items"));
                resultInfo.put("DelegatorID", ocrs.getString("DelegatorID"));
                resultInfo.put("DelegatorFirst_Name", ocrs.getString("DelegatorFirst_Name"));
                resultInfo.put("Delegator_MiddleName", ocrs.getString("Delegator_MiddleName"));
                resultInfo.put("Delegator_LastName", ocrs.getString("Delegator_LastName"));
                resultInfo.put("Delegator_Department", ocrs.getString("Delegator_Department"));
                resultInfo.put("Delegator_JobTitle", ocrs.getString("Delegator_JobTitle"));
                resultInfo.put("DelegateID", ocrs.getString("DelegateID"));
                resultInfo.put("Delegate_First_Name", ocrs.getString("Delegate_First_Name"));
                resultInfo.put("Delegate_Middle_Name", ocrs.getString("Delegate_Middle_Name"));
                resultInfo.put("Delegate_Last_Name", ocrs.getString("Delegate_Last_Name"));
                resultInfo.put("Delegate_Department", ocrs.getString("Delegate_Department"));
                resultInfo.put("Delegate_Job_Position", ocrs.getString("Delegate_Job_Position"));
                resultInfo.put("DelegateRank", ocrs.getString("DelegateRank"));
                SalaryDelegationApproveReportList.add(resultInfo);
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }else if(ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually")){
         try {
            
            OracleCachedRowSet ocrs = salaryDelegationEntity.readAllSalaryDelegationSimmannulay(ReportCriteraManager.getParametrsForDay());
             while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("start_date", ocrs.getString("start_date"));
                resultInfo.put("end_date", ocrs.getString("end_date"));
                resultInfo.put("DelegationReaouns", ocrs.getString("DelegationReaouns"));
                resultInfo.put("delegated_items", ocrs.getString("delegated_items"));
                resultInfo.put("DelegatorID", ocrs.getString("DelegatorID"));
                resultInfo.put("DelegatorFirst_Name", ocrs.getString("DelegatorFirst_Name"));
                resultInfo.put("Delegator_MiddleName", ocrs.getString("Delegator_MiddleName"));
                resultInfo.put("Delegator_LastName", ocrs.getString("Delegator_LastName"));
                resultInfo.put("Delegator_Department", ocrs.getString("Delegator_Department"));
                resultInfo.put("Delegator_JobTitle", ocrs.getString("Delegator_JobTitle"));
                resultInfo.put("DelegateID", ocrs.getString("DelegateID"));
                resultInfo.put("Delegate_First_Name", ocrs.getString("Delegate_First_Name"));
                resultInfo.put("Delegate_Middle_Name", ocrs.getString("Delegate_Middle_Name"));
                resultInfo.put("Delegate_Last_Name", ocrs.getString("Delegate_Last_Name"));
                resultInfo.put("Delegate_Department", ocrs.getString("Delegate_Department"));
                resultInfo.put("Delegate_Job_Position", ocrs.getString("Delegate_Job_Position"));
                resultInfo.put("DelegateRank", ocrs.getString("DelegateRank"));
                SalaryDelegationApproveReportList.add(resultInfo);
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }else if(ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually")){
     try {
            
            OracleCachedRowSet ocrs = salaryDelegationEntity.readAllSalaryDelegationAnnulay(ReportCriteraManager.getParametrsForDay());
             while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("start_date", ocrs.getString("start_date"));
                resultInfo.put("end_date", ocrs.getString("end_date"));
                resultInfo.put("DelegationReaouns", ocrs.getString("DelegationReaouns"));
                resultInfo.put("delegated_items", ocrs.getString("delegated_items"));
                resultInfo.put("DelegatorID", ocrs.getString("DelegatorID"));
                resultInfo.put("DelegatorFirst_Name", ocrs.getString("DelegatorFirst_Name"));
                resultInfo.put("Delegator_MiddleName", ocrs.getString("Delegator_MiddleName"));
                resultInfo.put("Delegator_LastName", ocrs.getString("Delegator_LastName"));
                resultInfo.put("Delegator_Department", ocrs.getString("Delegator_Department"));
                resultInfo.put("Delegator_JobTitle", ocrs.getString("Delegator_JobTitle"));
                resultInfo.put("DelegateID", ocrs.getString("DelegateID"));
                resultInfo.put("Delegate_First_Name", ocrs.getString("Delegate_First_Name"));
                resultInfo.put("Delegate_Middle_Name", ocrs.getString("Delegate_Middle_Name"));
                resultInfo.put("Delegate_Last_Name", ocrs.getString("Delegate_Last_Name"));
                resultInfo.put("Delegate_Department", ocrs.getString("Delegate_Department"));
                resultInfo.put("Delegate_Job_Position", ocrs.getString("Delegate_Job_Position"));
                resultInfo.put("DelegateRank", ocrs.getString("DelegateRank"));
                SalaryDelegationApproveReportList.add(resultInfo);
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }else if(ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily")){
     try {
            
            OracleCachedRowSet ocrs = salaryDelegationEntity.readAllSalaryDelegationDaily(ReportCriteraManager.getParametrsForDay());
             while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("start_date", ocrs.getString("start_date"));
                resultInfo.put("end_date", ocrs.getString("end_date"));
                resultInfo.put("DelegationReaouns", ocrs.getString("DelegationReaouns"));
                resultInfo.put("delegated_items", ocrs.getString("delegated_items"));
                resultInfo.put("DelegatorID", ocrs.getString("DelegatorID"));
                resultInfo.put("DelegatorFirst_Name", ocrs.getString("DelegatorFirst_Name"));
                resultInfo.put("Delegator_MiddleName", ocrs.getString("Delegator_MiddleName"));
                resultInfo.put("Delegator_LastName", ocrs.getString("Delegator_LastName"));
                resultInfo.put("Delegator_Department", ocrs.getString("Delegator_Department"));
                resultInfo.put("Delegator_JobTitle", ocrs.getString("Delegator_JobTitle"));
                resultInfo.put("DelegateID", ocrs.getString("DelegateID"));
                resultInfo.put("Delegate_First_Name", ocrs.getString("Delegate_First_Name"));
                resultInfo.put("Delegate_Middle_Name", ocrs.getString("Delegate_Middle_Name"));
                resultInfo.put("Delegate_Last_Name", ocrs.getString("Delegate_Last_Name"));
                resultInfo.put("Delegate_Department", ocrs.getString("Delegate_Department"));
                resultInfo.put("Delegate_Job_Position", ocrs.getString("Delegate_Job_Position"));
                resultInfo.put("DelegateRank", ocrs.getString("DelegateRank"));
                SalaryDelegationApproveReportList.add(resultInfo);
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }
   return SalaryDelegationApproveReportList;
}

}
