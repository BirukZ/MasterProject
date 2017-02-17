/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.leaveEntity.ApproveRequestFromLeaveEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sun.webui.jsf.model.Option;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.JodanTimeCalender;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author PROJECT
 */
public class ApproveReturnFromLeaveManager {

    public static final String RETURN_FROM_LEAVE_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String RETURN_FROM_LEAVE_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String RETURN_FROM_LEAVEDECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String RETURN_FROM_LEAVE_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String RETURN_FROM_LEAVE_DECISION_NONE = "-1";
    private String userName = "";
    private String loggedInEmployeeId;
    public static final String PROCESS_RETURN_FROM_LEAVE = AuthorizationManager.REQUEST_RETURN_FROM_LEAVE;//"1"
    public static final String FINAL_STATE_RETURN_FROM_LEAVE = AuthorizationManager.readFinalState(PROCESS_RETURN_FROM_LEAVE);
    public static final String INITIAL_STATE_RETURN_FROM_LEAVE = AuthorizationManager.readInitialState(PROCESS_RETURN_FROM_LEAVE);
    private ApproveRequestFromLeaveEntity approveRequestFromLeaveEntity = new ApproveRequestFromLeaveEntity();
    /**
     * Return Leave Payment variables
     */
    public static final String PROCESS_LEAVE_PAYMENT = AuthorizationManager.REQUEST_RETURN_FROM_LEAVE_PAYMENT;//"17"
    public static final String FINAL_STATE_LEAVE_PAYMENT = AuthorizationManager.readFinalState(PROCESS_LEAVE_PAYMENT);
    public static final String INITIAL_STATE_LEAVE_PAYMENT = AuthorizationManager.readInitialState(PROCESS_RETURN_FROM_LEAVE);
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private String leaveProcessedId;
    private String requestId;
    private String processedBy;
    private String commentGiven;
    private String decision;
    private String recordedBy;
    private String currentState;

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

    public ArrayList<Option> getRequestsToBeProcessed() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = approveRequestFromLeaveEntity.selectApprovableRequest(
                    userName,
                    ApproveReturnFromLeaveManager.PROCESS_RETURN_FROM_LEAVE);
            while (_rs.next()) {
                pendingRequests.add(new Option(
                        _rs.getString("EMP_ID") + "--" +
                        _rs.getString("STATUS") + "--" + _rs.getString("REQUESTED_DATE") + "--" + _rs.getString("REQUEST_ID"),
                        _rs.getString("EMP_ID") + " IN " + _rs.getString("REQUESTED_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getToBeProcessedLeavePayment() {
        ArrayList<SelectItem> pendingRequests = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = approveRequestFromLeaveEntity.selectApprovableLeavePayment(
                    userName,
                    ApproveReturnFromLeaveManager.PROCESS_RETURN_FROM_LEAVE);
            while (_rs.next()) {
                pendingRequests.add(new SelectItem(
                        _rs.getString("EMP_ID") + "--" +
                        _rs.getString("STATUS") + "--" +
                        _rs.getString("PAYMENT_REQUESTED_DATE") + "--" +
                        _rs.getString("REQUEST_ID"),
                        _rs.getString("EMP_ID") + " IN " + _rs.getString("PAYMENT_REQUESTED_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ApproveReturnFromLeaveManager() {
    }

    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public HashMap readEmployeeLeaveRequest(String employeeId,
            String reserveLeaveStatus,
            String requesedDate) {
        try {
            return approveRequestFromLeaveEntity.readEmployeeRetrunFromLeaveRequest(employeeId,
                    reserveLeaveStatus,
                    requesedDate);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public HashMap loadEmployeePaymentRequestData(String employeeId,
            String reserveLeaveStatus,
            String requesedDate) {
        try {
            return approveRequestFromLeaveEntity.loadEmployeePaymentRequestData(employeeId,
                    reserveLeaveStatus,
                    requesedDate);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getCommentGiven() {
        return commentGiven;
    }

    public void setCommentGiven(String commentGiven) {
        this.commentGiven = commentGiven;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getLeaveProcessedId() {
        return leaveProcessedId;
    }

    public void setLeaveProcessedId(String leaveProcessedId) {
        this.leaveProcessedId = leaveProcessedId;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public ApproveReturnFromLeaveManager(
            String leaveProcessedId,
            String requestId,
            String processedBy,
            String commentGiven,
            String decision,
            String recordedBy,
            String currentState) {
        this.leaveProcessedId = leaveProcessedId;
        this.requestId = requestId;
        this.processedBy = processedBy;
        this.commentGiven = commentGiven;
        this.decision = decision;
        this.recordedBy = recordedBy;
        this.currentState = currentState;
    }

    public boolean saveleaveDecision(ApproveReturnFromLeaveManager approveReturnFromLeaveManager) {
        String nextState = AuthorizationManager.readNextState(
                approveReturnFromLeaveManager.getCurrentState(),
                PROCESS_RETURN_FROM_LEAVE,
                approveReturnFromLeaveManager.getDecision());

        try {
            ApproveRequestFromLeaveEntity approveRequestFromLeaveInfo = new ApproveRequestFromLeaveEntity(
                    approveReturnFromLeaveManager.getLeaveProcessedId(),
                    approveReturnFromLeaveManager.getRequestId(),
                    approveReturnFromLeaveManager.getProcessedBy(),
                    approveReturnFromLeaveManager.getCommentGiven(),
                    approveReturnFromLeaveManager.getDecision(),
                    approveReturnFromLeaveManager.getRecordedBy(),
                    jodanTimeCalender.currentForeignersDateFinder(),
                    nextState);
            if (approveRequestFromLeaveEntity.insertReturnFromLeaveDecision(
                    approveRequestFromLeaveInfo)) {

                return true;
            } else {
                return false;
            }



        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveleavePaymentDecision(ApproveReturnFromLeaveManager approveReturnFromLeaveManager) {
        String nextState = AuthorizationManager.readNextState(
                approveReturnFromLeaveManager.getCurrentState(),
                PROCESS_LEAVE_PAYMENT,
                approveReturnFromLeaveManager.getDecision());

        try {
            ApproveRequestFromLeaveEntity approveRequestFromLeaveInfo = new ApproveRequestFromLeaveEntity(
                    approveReturnFromLeaveManager.getLeaveProcessedId(),
                    approveReturnFromLeaveManager.getRequestId(),
                    approveReturnFromLeaveManager.getProcessedBy(),
                    approveReturnFromLeaveManager.getCommentGiven(),
                    approveReturnFromLeaveManager.getDecision(),
                    approveReturnFromLeaveManager.getRecordedBy(),
                    jodanTimeCalender.currentForeignersDateFinder(),
                    nextState);
            if (approveRequestFromLeaveEntity.insertReturnFromLeavePaymentDecision(
                    approveRequestFromLeaveInfo)) {

                return true;
            } else {
                return false;
            }



        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<HashMap> getLeaveRequestHistory(int requestId) {
        try {
            ResultSet _rs = approveRequestFromLeaveEntity.selectProcessedLeaveRequest(requestId);
            ArrayList<HashMap> requestHistoryList = new ArrayList<HashMap>();

            while (_rs.next()) {

                HashMap hm = new HashMap();
                String deciderEmployeeId = _rs.getString("PROCESSED_BY");
                String recorderEmployeeId = _rs.getString("RECORDED_BY_ID");
                String deciderFullName = _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME");
                if (!deciderEmployeeId.equals(recorderEmployeeId)) {//
                    deciderFullName = deciderFullName + " (Rec. by " + recorderEmployeeId + ")";
                }
                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 10);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "No comment given." : _rs.getString("COMMENT_GIVEN");

                String givenDecision = _rs.getString("PERMISSION_NAME");

                hm.put("deciderEmployeeId", deciderEmployeeId);
                hm.put("deciderFullName", deciderFullName);
                hm.put("givenDecision", givenDecision);
                hm.put("timeStamp", timeStamp);
                hm.put("commentGiven", commentGiven);
                requestHistoryList.add(hm);
            }
            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<HashMap> getLeavePaymentRequestHistory(int requestId) {
        try {
            ResultSet _rs = approveRequestFromLeaveEntity.selectProcessedLeavePaymentRequest(requestId);
            ArrayList<HashMap> requestHistoryList = new ArrayList<HashMap>();

            while (_rs.next()) {

                HashMap hm = new HashMap();
                String deciderEmployeeId = _rs.getString("PROCESSED_BY");
                String recorderEmployeeId = _rs.getString("RECORDED_BY_ID");
                String deciderFullName = _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME");
                if (!deciderEmployeeId.equals(recorderEmployeeId)) {//
                    deciderFullName = deciderFullName + " (Rec. by " + recorderEmployeeId + ")";
                }
                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 10);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "No comment given." : _rs.getString("COMMENT_GIVEN");
                String givenDecision = _rs.getString("PERMISSION_NAME");
                hm.put("deciderEmployeeId", deciderEmployeeId);
                hm.put("deciderFullName", deciderFullName);
                hm.put("givenDecision", givenDecision);
                hm.put("timeStamp", timeStamp);
                hm.put("commentGiven", commentGiven);
                requestHistoryList.add(hm);
            }
            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public boolean modifyAnualLeave(HashMap listOfData) {
        HashMap updateList = new HashMap();
        HashMap newList = new HashMap();
        try {
            LeaveRequestManager leaveRequestManager =new LeaveRequestManager();
            String returnDate = "";
            String newReturnDate = "";
            String lastDate = leaveRequestManager.calculateLeaveIncludeHolidays(
                    listOfData.get("startFrom").toString(),
                    listOfData.get("numberOfDays").toString());
            if (listOfData.get("employeementType").equals("Office") && listOfData.get("workIn").equals("AddisAbeba")) {
                returnDate = leaveRequestManager.nextAddisWorkingDay(lastDate);
            } else if (listOfData.get("employeementType").equals("Shift")) {
                returnDate = leaveRequestManager.nextShiftWorkingDay(lastDate);
            } else if (listOfData.get("employeementType").equals("Office") && listOfData.get("workIn").equals("Mugher")) {
                returnDate = leaveRequestManager.nextMugherWorkingDay(lastDate);
            }
            newList.put("employeeId", listOfData.get("employeeId"));
            newList.put("leaveType", listOfData.get("employeeId"));
            newList.put("fromDate", listOfData.get("startFrom"));
            newList.put("toDate", returnDate);
            newList.put("reason", "");
            newList.put("currentDate", listOfData.get("currentDater"));
            newList.put("leaveDays", listOfData.get("numberOfDays"));
            int numberOfWorkingDays = LeaveRequestManager.countWorkingDateIncluDingSaturday(
                    listOfData.get("anualLeaveStartDate").toString(),
                    listOfData.get("startFrom").toString());
            int remaingDays = numberOfWorkingDays - Integer.parseInt(listOfData.get("leaveDays").toString());
            if (listOfData.get("employeementType").equals("Office") && listOfData.get("workIn").equals("AddisAbeba")) {
                leaveRequestManager.calculatLeaveDateForAddisOfficeWorker(
                        returnDate,
                        Integer.toString(remaingDays));


                newReturnDate = leaveRequestManager.nextAddisWorkingDay(lastDate);
            } else if (listOfData.get("employeementType").equals("Shift")) {
                String endDate = leaveRequestManager.calculatLeaveDateForShifteWorker(
                        returnDate,
                        Integer.toString(remaingDays));
                newReturnDate = leaveRequestManager.nextShiftWorkingDay(endDate);
            } else if (listOfData.get("employeementType").equals("Office") && listOfData.get("workIn").equals("Mugher")) {
                String endDate = leaveRequestManager.calculatLeaveDateForBIBOfficeWorker(
                        returnDate,
                        Integer.toString(remaingDays));
                newReturnDate = leaveRequestManager.nextMugherWorkingDay(endDate);
            }



            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

  
}
