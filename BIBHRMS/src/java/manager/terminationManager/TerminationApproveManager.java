/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import com.sun.webui.jsf.model.Option;
import entity.terminationEntity.TerminationApproveEntity;
import entity.terminationEntity.TerminationRequestEntity;
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
public class TerminationApproveManager {

    public static final String TERMINATION_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String TERMINATION_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String TERMINATION_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String TERMINATION_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String TERMINATION_DECISION_NONE = "-1";
    TerminationRequestEntity terminationRequestEntity = new TerminationRequestEntity();
    TerminationApproveEntity terminationApproveEntity = new TerminationApproveEntity();
    TerminationDecisionModel terminationDecisionModel = new TerminationDecisionModel();
    EmployeeManage employeeManager = new EmployeeManage();
    public static final String PROCESS_TERMINATION = AuthorizationManager.PROCESS_TERMINATION;//"8"
    public static final String FINAL_STATE_TERMINATION = AuthorizationManager.readFinalState(PROCESS_TERMINATION);
    public static final String INITIAL_STATE_TERMINATION = AuthorizationManager.readInitialState(PROCESS_TERMINATION);
    String userName = "";

    public ArrayList<SelectItem> getApprovedTermination() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = terminationApproveEntity.selectApprovedRequest(userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("TERMINATION_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("REQUEST_STATUS");
                    String requesterName = _rs.getString("FNAME");
                    String optionId = Integer.toString(terminationRequestId);
                    Option data = new Option(optionId, requesterName + " ON " + appliedDate);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    /**
     *
     */
    public boolean saveTerminationDecision(int requestId,
            String processedBy,
            String decision,
            String currentState,
            String commentGiven,
            String terminator,
            String terminationType,
            String terminationCatagory,
            String terminationDate
            ,double penality,
            String hasSuccsior) {
        String nextState = AuthorizationManager.readNextState(currentState, AuthorizationManager.PROCESS_TERMINATION, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            terminationDecisionModel = new TerminationDecisionModel(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime, terminator, terminationType, terminationCatagory, terminationDate,penality,hasSuccsior);
            if (terminationApproveEntity.insertTerminationDecision(terminationDecisionModel)) {//if successful
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
public boolean changeEmployeeList(String requesterId) {
        try {
            return terminationApproveEntity.changeEmployeeList(requesterId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }
public boolean changeEmployeeListRetirment(String requesterId) {
        try {
            return terminationApproveEntity.changeEmployeeListRetirment(requesterId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }
public boolean changeEmployeeListResign(String requesterId) {
        try {
            return terminationApproveEntity.changeEmployeeListResign(requesterId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }
    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
        try {
            ResultSet _rs = terminationApproveEntity.selectProcessedTerminationRequest(requestId);
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
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = terminationApproveEntity.selectApprovableRequest(userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("TERMINATION_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("REQUEST_STATUS");
                    String terminatorID = _rs.getString("TREMINATOR_ID");
                    String terminattionType = _rs.getString("TERMINATION_TYPE");
                    String terminationCatego= _rs.getString("TERMINATION_CATAGORY");
                    String terminationDate= _rs.getString("TERMINATION_DATE");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + appliedDate + "--" + status + "--" + terminatorID + "--" + terminationCatego+ "--" + terminattionType+ "--" + terminationDate;
                    String OptionDesc = requesterId + " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public ArrayList<SelectItem> getMyTerminationDecisionHistory() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = terminationApproveEntity.selectMyDecisionsOnRequest(userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("TERMINATION_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("REQUEST_STATUS");
                    String terminatorID = _rs.getString("TREMINATOR_ID");
                     String terminattionType = _rs.getString("TERMINATION_TYPE");
                    String terminationCatego= _rs.getString("TERMINATION_CATAGORY");
                    String terminationDate= _rs.getString("TERMINATION_DATE");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + appliedDate + "--" + status + "--" + terminatorID + "--" + terminationCatego+ "--" + terminattionType+ "--" + terminationDate;
                    String OptionDesc = requesterId + " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    //<editor-fold >
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    //</editor-fold >

    public static class TerminationDecisionModel {

        private int terminationProcessedId;//@Column(name = "OVER_TIME_PROCESS_PROCESSED_ID")
        private int terminationRequestId; //@Column(name = "OVER_TIME_REQUEST_ID")
        private String processedBy;//@Column(name = "PROCEESED_BY")
        String decision;
        private String nextState;//   @Column(name = "NEXT_STATE")
        private String commentGiven;// @Column(name = "COMMENT_GIVEN")
        private String recordedBy;//  @Column(name = "RECORDED_BY")//  String userName;
        private String recorededDateAndTime;//  @Column(name = "TIME_STAMP")
        private String terminationCatagory;// @Column(name = "TERMINATION_CATAGORY")
        private String terminationType;
        private String terminator;
        private String terminationDate;
        private double penalityPay;
        private String hasSuccesioser;
        public TerminationDecisionModel() {
        }

        public TerminationDecisionModel(int terminationRequestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
            this.terminationRequestId = terminationRequestId;
            this.processedBy = processedBy;
            this.decision = decision;
            this.nextState = nextState;
            this.commentGiven = commentGiven;
            this.recordedBy = recordedBy;
            this.recorededDateAndTime = recorededDateAndTime;
        }

//        public TerminationDecisionModel(int terminationProcessedId, int terminationRequestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime,String terminator, String terminationType, String terminationCatagory, String terminationDate) {
//            this(terminationRequestId, processedBy, decision, nextState, commentGiven, recordedBy, recorededDateAndTime);
//            this.terminationProcessedId = terminationProcessedId;
//            this.terminator=terminator;
//            this.terminationCatagory=terminationCatagory;
//            this.terminationDate=terminationDate;
//            this.terminationType=terminationType;
//        }
        public TerminationDecisionModel( int terminationRequestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime, String terminator, String terminationType, String terminationCatagory, String terminationDate,double penalityPay,String hasSuccsior) {
            this.terminationRequestId = terminationRequestId;
            this.processedBy = processedBy;
            this.decision = decision;
            this.nextState = nextState;
            this.commentGiven = commentGiven;
            this.recordedBy = recordedBy;
            this.recorededDateAndTime = recorededDateAndTime;
            //this.terminationProcessedId = terminationProcessedId;
            this.terminator = terminator;
            this.terminationCatagory = terminationCatagory;
            this.terminationDate = terminationDate;
            this.terminationType = terminationType;
            this.penalityPay=penalityPay;
            this.hasSuccesioser=hasSuccsior;


        }

        public void setCommentGiven(String commentGiven) {
            this.commentGiven = commentGiven;
        }

        public String getTerminationCatagory() {
            return terminationCatagory;
        }

        public void setTerminationCatagory(String terminationCatagory) {
            this.terminationCatagory = terminationCatagory;
        }

        public String getTerminationDate() {
            return terminationDate;
        }

        public void setTerminationDate(String terminationDate) {
            this.terminationDate = terminationDate;
        }

        public String getHasSuccesioser() {
            return hasSuccesioser;
        }

        public void setHasSuccesioser(String hasSuccesioser) {
            this.hasSuccesioser = hasSuccesioser;
        }

        public double getPenalityPay() {
            return penalityPay;
        }

        public void setPenalityPay(double penalityPay) {
            this.penalityPay = penalityPay;
        }

        public String getTerminationType() {
            return terminationType;
        }

        public void setTerminationType(String terminationType) {
            this.terminationType = terminationType;
        }

        public String getTerminator() {
            return terminator;
        }

        public void setTerminator(String terminator) {
            this.terminator = terminator;
        }

        public void setDecision(String decision) {
            this.decision = decision;
        }

        public void setNextState(String nextState) {
            this.nextState = nextState;
        }

        public void setProcessedBy(String processedBy) {
            this.processedBy = processedBy;
        }

        public void setRecordedBy(String recordedBy) {
            this.recordedBy = recordedBy;
        }

        public void setRecorededDateAndTime(String recorededDateAndTime) {
            this.recorededDateAndTime = recorededDateAndTime;
        }

        public void setTerminationProcessedId(int terminationProcessedId) {
            this.terminationProcessedId = terminationProcessedId;
        }

        public void setTerminationRequestId(int terminationRequestId) {
            this.terminationRequestId = terminationRequestId;
        }

        public String getCommentGiven() {
            return commentGiven;
        }

        public String getDecision() {
            return decision;
        }

        public String getNextState() {
            return nextState;
        }

        public String getProcessedBy() {
            return processedBy;
        }

        public String getRecordedBy() {
            return recordedBy;
        }

        public String getRecorededDateAndTime() {
            return recorededDateAndTime;
        }

        public int getTerminationProcessedId() {
            return terminationProcessedId;
        }

        public int getTerminationRequestId() {
            return terminationRequestId;
        }
    }
}
