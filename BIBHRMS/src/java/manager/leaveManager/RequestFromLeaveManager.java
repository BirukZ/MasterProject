/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.leaveEntity.RequestFromLeaveEntity;
import entity.leaveEntity.RequesttoReturnFromAnnualLeaveEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager;
import manager.globalUseManager.JodanTimeCalender;

/**
 *
 * @author PROJECT
 */
public class RequestFromLeaveManager {

    private String requestId;
    private String empId;
    private String returnDate;
    private String reason;
    private String requestStatus;
    private String requestedBy;
    private String requestDate;
    private String leaveRequestId;
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private RequestFromLeaveEntity requestFromLeaveEntity = new RequestFromLeaveEntity();
    public static final String PROCESS_RETURN_FROM_LEAVE = AuthorizationManager.REQUEST_RETURN_FROM_LEAVE;//"1"
    public static final String FINAL_STATE_RETURN_FROM_LEAVE = AuthorizationManager.readFinalState(PROCESS_RETURN_FROM_LEAVE);
    public static final String INITIAL_STATE_RETURN_FROM_LEAVE = AuthorizationManager.readInitialState(PROCESS_RETURN_FROM_LEAVE);
    /**
     * Return Leave Payment variables
     */
    public static final String PROCESS_LEAVE_PAYMENT = AuthorizationManager.REQUEST_RETURN_FROM_LEAVE_PAYMENT;//"17"
    public static final String FINAL_STATE_LEAVE_PAYMENT = AuthorizationManager.readFinalState(PROCESS_LEAVE_PAYMENT);
    public static final String INITIAL_STATE_LEAVE_PAYMENT = AuthorizationManager.readInitialState(PROCESS_RETURN_FROM_LEAVE);

    public RequestFromLeaveManager() {
    }

    public RequestFromLeaveManager(String requestId, String empId, String returnDate, String reason, String requestedBy) {
        this.requestId = requestId;
        this.empId = empId;
        this.returnDate = returnDate;
        this.reason = reason;
        this.requestedBy = requestedBy;
    }

    public RequestFromLeaveManager(
            String empId,
            String returnDate,
            String reason,
            String requestedBy,
            String leaveRequestId,
            boolean req) {
        this.empId = empId;
        this.returnDate = returnDate;
        this.reason = reason;
        this.requestedBy = requestedBy;
        this.leaveRequestId=leaveRequestId;
    }

    public HashMap readEmployeeLeaveWithProfile(String employeeId) {
        return requestFromLeaveEntity.readEmployeeLeaveWithProfile(employeeId);
    }

    public boolean saveRequestPaymentInformation(RequestFromLeaveManager requestFromLeaveManager) {
        RequestFromLeaveEntity requestFromLeave = new RequestFromLeaveEntity(
                requestFromLeaveManager.getEmpId(),
                requestFromLeaveManager.getReturnDate(),
                requestFromLeaveManager.getReason(),
                RequestFromLeaveManager.INITIAL_STATE_LEAVE_PAYMENT,
                requestFromLeaveManager.getRequestedBy(),
                 requestFromLeaveManager.getLeaveRequestId());
        return requestFromLeaveEntity.saveRequestPaymentRequest(requestFromLeave);
    }

    public boolean saveRequestInformation(RequestFromLeaveManager requestFromLeaveManager) {
        RequestFromLeaveEntity requestFromLeave = new RequestFromLeaveEntity(
                requestFromLeaveManager.getEmpId(),
                requestFromLeaveManager.getReturnDate(),
                requestFromLeaveManager.getReason(),
                RequestFromLeaveManager.INITIAL_STATE_RETURN_FROM_LEAVE,
                requestFromLeaveManager.getRequestedBy(),
                requestFromLeaveManager.getLeaveRequestId()
                );
        return requestFromLeaveEntity.saveRequestInformation(requestFromLeave);
    }

    public boolean updateRequestInformation(RequestFromLeaveManager requestFromLeaveManager) {
        RequestFromLeaveEntity requestFromLeave = new RequestFromLeaveEntity(
                requestFromLeaveManager.getRequestId(),
                requestFromLeaveManager.getEmpId(),
                requestFromLeaveManager.getReturnDate(),
                requestFromLeaveManager.getReason(),
                RequestFromLeaveManager.INITIAL_STATE_RETURN_FROM_LEAVE,
                requestFromLeaveManager.getRequestedBy(),
                requestFromLeaveManager.getRequestDate());
        return requestFromLeaveEntity.updateRequestInformation(requestFromLeave);
    }

    public ArrayList<SelectItem> readEmployeeRequesteToReturnFromLeave() {
        try {
            ArrayList<HashMap> listOfEmployee = requestFromLeaveEntity.readEmployeeRequesteToReturnFromLeave();
            ArrayList<SelectItem> returnList = new ArrayList<SelectItem>();
            if (listOfEmployee != null) {
                returnList.add(new SelectItem(null, "--Select Employee ID--"));
                for (HashMap hm : listOfEmployee) {
                    returnList.add(new SelectItem(
                            hm.get("EMP_ID").toString() + "=" +
                            hm.get("STATUS").toString() + "=" +
                            hm.get("REQUESTED_DATE").toString() + "=" +
                            hm.get("leaverequestid").toString(),
                            hm.get("EMP_ID").toString()));
                }
                return returnList;
            } else {
                returnList.add(new SelectItem(null, "--No One Requested to Return--"));
                return returnList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<SelectItem> readRequesteToReturnFromLeaveEmployeeAndReturn() {
        try {
            ArrayList<HashMap> listOfEmployee = requestFromLeaveEntity.readRequesteToReturnFromLeaveEmployeeAndReturn();
            ArrayList<SelectItem> returnList = new ArrayList<SelectItem>();
            if (listOfEmployee != null) {
                returnList.add(new SelectItem(null, "--Select Employee ID--"));
                for (HashMap hm : listOfEmployee) {
                    returnList.add(new SelectItem(
                            hm.get("EMP_ID").toString() + "=" +
                            hm.get("STATUS").toString() + "=" +
                            hm.get("REQUESTED_DATE").toString() + "=" + 
                            hm.get("PAYMENT_STATUS").toString()+"="+
                            hm.get("REQUEST_ID").toString(),
                            hm.get("EMP_ID").toString()));
                }
                return returnList;
            } else {
                returnList.add(new SelectItem(null, "--No One Requested to Return--"));
                return returnList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(String leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

}
