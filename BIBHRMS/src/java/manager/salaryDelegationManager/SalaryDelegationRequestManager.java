/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.salaryDelegationManager;

import entity.salaryDelegationEntity.SalaryDelegationRequestEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class SalaryDelegationRequestManager {

    SalaryDelegationRequestEntity delegationRequestEntity = new SalaryDelegationRequestEntity();
    SalaryDelegationRequestModel delegationRequestModel = new SalaryDelegationRequestModel();
    String userName;
    String loggedInEmployeeId;
    String loggedInDepartmentId;

    public boolean deleteSalaryDelegationRequest(int salaryDelegationRequestId) {
        try {
            delegationRequestEntity.deleteSalaryDelegationRequest(salaryDelegationRequestId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<SelectItem> getPendingRequests() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
       
        try {
            ResultSet _rs = delegationRequestEntity.selectPendingRequests(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("SALARY_DELEGATION_REQUEST_ID") + "--" + _rs.getString("DELEGATOR_ID") + "--" + _rs.getString("DELEGATEE_ID") + "--" + _rs.getString("STATUS"), _rs.getString("DELEGATOR_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getMyRequestsHistory() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = delegationRequestEntity.selectMyRequestsHistory(loggedInEmployeeId, userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("SALARY_DELEGATION_REQUEST_ID") + "--" + _rs.getString("DELEGATOR_ID") + "--" + _rs.getString("DELEGATEE_ID") + "--" + _rs.getString("STATUS"), _rs.getString("DELEGATOR_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public SalaryDelegationRequestModel getRequestParameters(int requestId) {
        delegationRequestModel = new SalaryDelegationRequestModel();
        try {
            ResultSet _rs = delegationRequestEntity.selectSalaryDelegationRequest(requestId);
            if (_rs.next()) {
                delegationRequestModel.setSalaryDelegationRequestId(requestId);
                delegationRequestModel.setSalaryDelegationRequestId(_rs.getInt("SALARY_DELEGATION_REQUEST_ID"));
                delegationRequestModel.setDelegatorId(_rs.getString("DELEGATOR_ID"));
                delegationRequestModel.setDelegateeId(_rs.getString("DELEGATEE_ID"));
                delegationRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                delegationRequestModel.setStartDate(_rs.getString("START_DATE"));
                delegationRequestModel.setEndDate(_rs.getString("END_DATE"));
                delegationRequestModel.setDelegaredItems(_rs.getString("DELEGATED_ITEMS"));
                delegationRequestModel.setReason(_rs.getString("REASON"));
                delegationRequestModel.setDocReferenceNumber(_rs.getString("DOC_REFERENCE_NUMBER"));
                delegationRequestModel.setStatus(_rs.getString("STATUS"));
                delegationRequestModel.setDocReferenceNumber(_rs.getString("TIME_STAMP"));
                delegationRequestModel.setDocReferenceNumber(_rs.getString("USER_NAME"));
            } else {
                delegationRequestModel.setSalaryDelegationRequestId(-1);
            }
            _rs.close();
            return delegationRequestModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveSalaryDelegationRequest(String delegatorId, String delegateeId, String startDate, String endDate, String appliedDate, String delegaredItems, String reason, String docReferenceNumber) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        delegationRequestModel = new SalaryDelegationRequestModel(delegatorId, delegateeId, startDate, endDate, appliedDate, delegaredItems, reason, docReferenceNumber, SalaryDelegationApproveManager.INITIAL_STATE_SALARY_DELEGATION, recorededDateAndTime, userName);
        try {
            delegationRequestEntity.insertSalaryDelegationRequest(delegationRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateSalaryDelegationRequest(int salaryDelegationRequestId, String delegatorId, String delegateeId, String startDate, String endDate, String appliedDate, String delegaredItems, String reason, String docReferenceNumber) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        delegationRequestModel = new SalaryDelegationRequestModel(salaryDelegationRequestId, delegatorId, delegateeId, startDate, endDate, appliedDate, delegaredItems, reason, docReferenceNumber, SalaryDelegationApproveManager.INITIAL_STATE_SALARY_DELEGATION, recorededDateAndTime, userName);
        try {
            delegationRequestEntity.updateSalaryDelegationRequestAttributes(delegationRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }


    // <editor-fold defaultstate="collapsed" desc="OverTimeRequestModel">
    public static class SalaryDelegationRequestModel {

        int salaryDelegationRequestId;//       OVER_TIME_REQUEST_ID
        String delegatorId;//REQUESTER_ID
        String delegateeId;//START_DATE
        String startDate;//END_DATE
        String endDate;//END_TIME
        String appliedDate;//APPLIED_DATE
        String delegaredItems;
        String reason;//REASON
        String docReferenceNumber;//
        String status;//STATUS
        String timeStamp;//TIME_STAMP
        String userName;//USER_NAME       
        String databaseStatus;

        public SalaryDelegationRequestModel() {
        }

        public SalaryDelegationRequestModel(int salaryDelegationRequestId, String delegatorId, String delegateeId, String startDate, String endDate, String appliedDate, String delegaredItems, String reason, String docReferenceNumber, String status, String timeStamp, String userName) {
            this(delegatorId, delegateeId, startDate, endDate, appliedDate, delegaredItems, reason, docReferenceNumber, status, timeStamp, userName);
            this.salaryDelegationRequestId = salaryDelegationRequestId;
        }

        public SalaryDelegationRequestModel(String delegatorId, String delegateeId, String startDate, String endDate, String appliedDate, String delegaredItems, String reason, String docReferenceNumber, String status, String timeStamp, String userName) {
            this.delegatorId = delegatorId;
            this.delegateeId = delegateeId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.appliedDate = appliedDate;
            this.delegaredItems = delegaredItems;
            this.reason = reason;
            this.docReferenceNumber = docReferenceNumber;
            this.status = status;
            this.timeStamp = timeStamp;
            this.userName = userName;
        }

        public String getAppliedDate() {
            return appliedDate;
        }

        public void setAppliedDate(String appliedDate) {
            this.appliedDate = appliedDate;
        }

        public String getDatabaseStatus() {
            return databaseStatus;
        }

        public void setDatabaseStatus(String databaseStatus) {
            this.databaseStatus = databaseStatus;
        }

        public String getDelegateeId() {
            return delegateeId;
        }

        public void setDelegateeId(String delegateeId) {
            this.delegateeId = delegateeId;
        }

        public String getDelegatorId() {
            return delegatorId;
        }

        public void setDelegatorId(String delegatorId) {
            this.delegatorId = delegatorId;
        }

        public String getDocReferenceNumber() {
            return docReferenceNumber;
        }

        public void setDocReferenceNumber(String docReferenceNumber) {
            this.docReferenceNumber = docReferenceNumber;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public int getSalaryDelegationRequestId() {
            return salaryDelegationRequestId;
        }

        public void setSalaryDelegationRequestId(int salaryDelegationRequestId) {
            this.salaryDelegationRequestId = salaryDelegationRequestId;
        }

        public String getReason() {
            return reason;
        }

        public String getDelegaredItems() {
            return delegaredItems;
        }

        public void setDelegaredItems(String delegaredItems) {
            this.delegaredItems = delegaredItems;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    } // </editor-fold>

    public SalaryDelegationRequestEntity getDelegationRequestEntity() {
        return delegationRequestEntity;
    }

    public void setDelegationRequestEntity(SalaryDelegationRequestEntity delegationRequestEntity) {
        this.delegationRequestEntity = delegationRequestEntity;
    }

    public SalaryDelegationRequestModel getDelegationRequestModel() {
        return delegationRequestModel;
    }

    public void setDelegationRequestModel(SalaryDelegationRequestModel delegationRequestModel) {
        this.delegationRequestModel = delegationRequestModel;
    }

    public String getLoggedInDepartmentId() {
        return loggedInDepartmentId;
    }

    public void setLoggedInDepartmentId(String loggedInDepartmentId) {
        this.loggedInDepartmentId = loggedInDepartmentId;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
