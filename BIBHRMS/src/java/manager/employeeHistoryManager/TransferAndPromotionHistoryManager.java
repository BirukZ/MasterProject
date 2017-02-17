/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeHistoryManager;

import entity.employeeHistoryEntity.TransferAndPromotionHistoryEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.LookUpManager;
import manager.organizationManager.JobTypeManager;

/**
 *
 * @author Mugher
 */
public class TransferAndPromotionHistoryManager {

    LookUpManager lookUpManager = new LookUpManager();
    DepartmentManage departmentManager = new DepartmentManage();
    JobTypeManager jobTypeManager = new JobTypeManager();
    TransferAndPromotionHistoryEntity transferAndPromotionHistoryEntity = new TransferAndPromotionHistoryEntity();

    public boolean saveTransferAndPromotionHistory(ArrayList<TransferAndPromotionHistoryModel> committeeList) {
        ArrayList<TransferAndPromotionHistoryModel> toBeInserted = new ArrayList<TransferAndPromotionHistoryModel>();
        ArrayList<TransferAndPromotionHistoryModel> toBeUpdated = new ArrayList<TransferAndPromotionHistoryModel>();
        ArrayList<TransferAndPromotionHistoryModel> toBeDeleted = new ArrayList<TransferAndPromotionHistoryModel>();
        try {
            for (TransferAndPromotionHistoryModel currentCommitteeMember : committeeList) {
                if (currentCommitteeMember.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentCommitteeMember);
                } else if (currentCommitteeMember.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(currentCommitteeMember);
                } else if (currentCommitteeMember.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentCommitteeMember);
                }
            }
            transferAndPromotionHistoryEntity.insertTransferAndPromotionHistory(toBeInserted);
            transferAndPromotionHistoryEntity.updateTransferAndPromotionHistory(toBeUpdated);
            transferAndPromotionHistoryEntity.deleteTransferAndPromotionHistory(toBeDeleted);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<TransferAndPromotionHistoryModel> getTransferAndPromotionHistory(String employeeId) {
        ArrayList<TransferAndPromotionHistoryModel> transferAndPromotioHistoryList = new ArrayList<TransferAndPromotionHistoryModel>();
        try {
            ResultSet _rs = transferAndPromotionHistoryEntity.selectTransferAndPromotionHistory(employeeId);
            while (_rs.next()) {
                TransferAndPromotionHistoryModel currentHistory = new TransferAndPromotionHistoryModel();
                currentHistory.setTransferAndPromotionId(_rs.getInt("PROMOTION_HISTORY_ID"));
                currentHistory.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                currentHistory.setRequesterDepartment(_rs.getString("REQUESTER_DEPARTMENT"));
                currentHistory.setPromotionType(_rs.getString("PROMOTION_TYPE"));
                currentHistory.setReason(_rs.getString("REASON"));
                currentHistory.setPreviousJobPosition(jobTypeManager.readJobIDAndDescription(_rs.getString("PREV_JOB_POSITION")));
                currentHistory.setPreviousRank(_rs.getString("PREV_RANK"));
                currentHistory.setPreviousSalary(_rs.getString("PREV_SALARY"));
                currentHistory.setNewJobPosition( jobTypeManager.readJobIDAndDescription(_rs.getString("NEW_JOB_POSITION"))); 
                currentHistory.setNewRank(_rs.getString("NEW_RANK"));
                currentHistory.setNewSalary(_rs.getString("NEW_SALARY"));
                currentHistory.setAdvertisenmentNumber(_rs.getString("ADV_NUMBER"));
                currentHistory.setPromotionDate(_rs.getString("PROMOTION_DATE"));
                currentHistory.setPromotionRequestDate(_rs.getString("REQUEST_DATE"));
                currentHistory.setCompletedDate(_rs.getString("COMPLETED_DATE"));
                currentHistory.setPromotionRequestLetterNumber(_rs.getString("REQUEST_LETTER_NUMBER"));
                currentHistory.setPromotionLetterNumber(_rs.getString("PROM_LETTER_NUMBER"));
                currentHistory.setTimeStamp(_rs.getString("TIME_STAMP"));
                currentHistory.setUserName(_rs.getString("USER_NAME"));
                currentHistory.setDatabaseStatus("Old");  //
                transferAndPromotioHistoryList.add(currentHistory);
            }
            _rs.close();
            return transferAndPromotioHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getTransferAndPromotionTypes() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = transferAndPromotionHistoryEntity.selectTransferAndPromotionTypes();
            while (_rs.next()) {
                jobsList.add(new SelectItem(_rs.getString("PROMOTION_TRANSFER_TYPE_ID"), _rs.getString("NAME")));
            }
            _rs.close();
            return jobsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllRanks() {
        try {
            return lookUpManager.assignJobRank();//new ArrayList<SelectItem>();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    @Deprecated
    public ArrayList<SelectItem> getAllDepartments() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        jobsList.add(0, new SelectItem("-1", "--SELECT DEPARTMENT--"));
        try {
            ResultSet _rs = transferAndPromotionHistoryEntity.selectAllDepartments();
            while (_rs.next()) {
                jobsList.add(new SelectItem(_rs.getString("DEPT_ID"), _rs.getString("DEPT_NAME")));
            }
            _rs.close();
            return jobsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllJobTypes() {
        try {
            ArrayList<SelectItem> jobTypeList = jobTypeManager.getAllJobTypesSelectItem();
            return jobTypeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
        public ArrayList<SelectItem> getAllJobTypesForPromotion() {
        try {
            ArrayList<SelectItem> jobTypeList = jobTypeManager.getAllJobTypesForPromotion();
            return jobTypeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }




}
