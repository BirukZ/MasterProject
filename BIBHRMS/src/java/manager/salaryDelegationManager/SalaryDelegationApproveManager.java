/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.salaryDelegationManager;

import com.sun.webui.jsf.model.Option;
import entity.salaryDelegationEntity.SalaryDelegationApproveEntity;
import entity.salaryDelegationEntity.SalaryDelegationRequestEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author mekete
 */
public class SalaryDelegationApproveManager {

    //==============================================================================================================================================
    public static final String SALARY_DELEGATION_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String SALARY_DELEGATION_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String SALARY_DELEGATION_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String SALARY_DELEGATION_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String SALARY_DELEGATION_DECISION_NONE = "-1";
    EmployeeManage employeeManager = new EmployeeManage();
    public static final String PROCESS_SALARY_DELEGATION = AuthorizationManager.PROCESS_SALARYDELIGATION;//"7"
    public static final String FINAL_STATE_SALARY_DELEGATION = AuthorizationManager.readFinalState(PROCESS_SALARY_DELEGATION);
    public static final String INITIAL_STATE_SALARY_DELEGATION = AuthorizationManager.readInitialState(PROCESS_SALARY_DELEGATION);
    String userName = "";
    String loggedInEmployeeId;
    //==============================================================================================================================================
    SalaryDelegationRequestManager delegationRequestManager = new SalaryDelegationRequestManager();
    SalaryDelegationDecisionModel delegationDecisionModel = new SalaryDelegationDecisionModel();
    SalaryDelegationRequestEntity delegationRequestEntity = new SalaryDelegationRequestEntity();
    SalaryDelegationApproveEntity delegationApproveEntity = new SalaryDelegationApproveEntity();
    //==============================================================================================================================================

    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();


     decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<SelectItem> getPendingRequests() {
        ArrayList<SelectItem> pendingRequests = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = delegationApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("SALARY_DELEGATION_REQUEST_ID") + "--" + _rs.getString("DELEGATOR_ID") + "--" + _rs.getString("DELEGATEE_ID") + "--" + _rs.getString("STATUS"), _rs.getString("DELEGATOR_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                pendingRequests.add(currentRequest);
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveDecision(int requestId, String processedBy,  String decision, String currentState,String commnetGiven) {
       
        String nextState = (decision.contains("$$")) ? currentState : AuthorizationManager.readNextState(currentState, PROCESS_SALARY_DELEGATION, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        delegationDecisionModel = new SalaryDelegationDecisionModel(requestId, processedBy, decision,commnetGiven, userName, recorededDateAndTime,nextState );
        
        try {
            delegationApproveEntity.insertSalaryDelegationDecision(delegationDecisionModel);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<SelectItem> getDecisionMadeByEmployee() {
        try {
            ArrayList<SelectItem> pendingRequests = new ArrayList<SelectItem>();
            ResultSet _rs = delegationApproveEntity.selectDicisionsMadeByEmployee(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(
                        _rs.getString("SALARY_DELEGATION_REQUEST_ID") + "--" +
                        _rs.getString("DELEGATOR_ID") + "--" +
                        _rs.getString("DELEGATEE_ID") + "--" +
                        _rs.getString("STATUS"),
                        _rs.getString("DELEGATOR_ID") + " ON " +
                        _rs.getString("APPLIED_DATE"));
                pendingRequests.add(currentRequest);
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
        try {
            ResultSet _rs = delegationApproveEntity.selectProcessedSalaryDelegationRequest(requestId);
            ArrayList<RequestHistoryModel> requestHistoryList = new ArrayList<RequestHistoryModel>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String deciderEmployeeId = _rs.getString("PROCESSED_BY");
                String recorderEmployeeId = _rs.getString("RECORDED_BY_ID");
                String deciderFullName = _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME");
                if (!deciderEmployeeId.equals(recorderEmployeeId)) {//
                    deciderFullName = deciderFullName + " (Rec. by " + recorderEmployeeId + ")";
                }
                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 10);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "No comment given." : _rs.getString("COMMENT_GIVEN");

                String givenDecision = _rs.getString("PERMISSION_NAME");
                requestHistoryList.add(new RequestHistoryModel(counter, deciderEmployeeId, deciderFullName, givenDecision, timeStamp, commentGiven));
            }
            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<SelectItem> getRequestsToBeProcessed() {
        ArrayList<SelectItem> pendingRequests = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = delegationApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("SALARY_DELEGATION_REQUEST_ID") + "--" + _rs.getString("DELEGATOR_ID") + "--" + _rs.getString("DELEGATEE_ID") + "--" + _rs.getString("STATUS"), _rs.getString("DELEGATEE_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                pendingRequests.add(currentRequest);
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static class SalaryDelegationDecisionModel {

        private int salaryDelegationProcessedId;//@Column(name = "OVER_TIME_PROCESS_PROCESSED_ID")
        private int salaryDelegationRequestId; //@Column(name = "OVER_TIME_REQUEST_ID")
        private String processedBy;//@Column(name = "PROCEESED_BY")
        String decision;
        private String nextState;//   @Column(name = "NEXT_STATE")
        private String commentGiven;// @Column(name = "COMMENT_GIVEN")
        private String recordedBy;//  @Column(name = "RECORDED_BY")//  String userName;
        private String recorededDateAndTime;//  @Column(name = "TIME_STAMP")

        public SalaryDelegationDecisionModel() {
        }

        private SalaryDelegationDecisionModel(int requestId, String processedBy, String decision, String commnetGiven, String userName, String recorededDateAndTime, String nextState) {
            this.salaryDelegationRequestId=requestId;
            this.processedBy=processedBy;
            this.decision=decision;
            this.commentGiven=commnetGiven;
            this.recordedBy=userName;
            this.recorededDateAndTime=recorededDateAndTime;
            this.nextState=nextState;
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

        public String getNextState() {
            return nextState;
        }

        public void setNextState(String nextState) {
            this.nextState = nextState;
        }

        public int getSalaryDelegationProcessedId() {
            return salaryDelegationProcessedId;
        }

        public void setSalaryDelegationProcessedId(int salaryDelegationProcessedId) {
            this.salaryDelegationProcessedId = salaryDelegationProcessedId;
        }

        public int getSalaryDelegationRequestId() {
            return salaryDelegationRequestId;
        }

        public void setSalaryDelegationRequestId(int salaryDelegationRequestId) {
            this.salaryDelegationRequestId = salaryDelegationRequestId;
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

        public String getRecorededDateAndTime() {
            return recorededDateAndTime;
        }

        public void setRecorededDateAndTime(String recorededDateAndTime) {
            this.recorededDateAndTime = recorededDateAndTime;
        }
    }

    public SalaryDelegationApproveEntity getDelegationApproveEntity() {
        return delegationApproveEntity;
    }

    public void setDelegationApproveEntity(SalaryDelegationApproveEntity delegationApproveEntity) {
        this.delegationApproveEntity = delegationApproveEntity;
    }

    public SalaryDelegationDecisionModel getDelegationDecisionModel() {
        return delegationDecisionModel;
    }

    public void setDelegationDecisionModel(SalaryDelegationDecisionModel delegationDecisionModel) {
        this.delegationDecisionModel = delegationDecisionModel;
    }

    public SalaryDelegationRequestEntity getDelegationRequestEntity() {
        return delegationRequestEntity;
    }

    public void setDelegationRequestEntity(SalaryDelegationRequestEntity delegationRequestEntity) {
        this.delegationRequestEntity = delegationRequestEntity;
    }

    public SalaryDelegationRequestManager getDelegationRequestManager() {
        return delegationRequestManager;
    }

    public void setDelegationRequestManager(SalaryDelegationRequestManager delegationRequestManager) {
        this.delegationRequestManager = delegationRequestManager;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
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
