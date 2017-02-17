/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import entity.recruitmentEntity.RecruitmentApproveEntity;
import com.sun.webui.jsf.model.Option;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import javax.servlet.http.HttpServletRequest;
import manager.globalUseManager.ErrorLogWriter;
import javax.faces.context.FacesContext;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author kibrom
 */
public class RecruitmentApproveManager {

    public static final String RECRUITMENT_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String RECRUITMENT_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String RECRUITMENT_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String RECRUITMENT_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String RECRUITMENT_DECISION_NONE = "-1";
    EmployeeManage employeeManager = new EmployeeManage();
    public static final String PROCESS_RECRUITMENT = AuthorizationManager.PROCESS_RECRUITMENT;//"8"
    public static final String FINAL_STATE_RECRUITMENT = AuthorizationManager.readFinalState(PROCESS_RECRUITMENT);
    public static final String INITIAL_STATE_RECRUITMENT = AuthorizationManager.readInitialState(PROCESS_RECRUITMENT);
    String userName = "";
    String loggedInEmployeeId;

    /////////////////////////////////
    RecruitmentApproveEntity recruitmentApproveEntity = new RecruitmentApproveEntity();
    RecruitmentDecisionModel recruitmentDecisionModel = new RecruitmentDecisionModel();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public ArrayList<Option> getRequestsToBeProcessed() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = recruitmentApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("RECRUIT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("RECRUIT_BATCH_CODE")+"--"+_rs.getString("RECRUIT_REQUEST_REF_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getMyDecisionsOnRequests() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = recruitmentApproveEntity.selectMyDecisionsOnRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("RECRUIT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("RECRUIT_BATCH_CODE")+"--"+_rs.getString("RECRUIT_REQUEST_REF_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveRecruitmentDecision(int requestId, String processedBy, String decision, String currentState, String commentGiven) {
        String nextState = AuthorizationManager.readNextState(currentState, PROCESS_RECRUITMENT, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            recruitmentDecisionModel = new RecruitmentDecisionModel(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime);
            recruitmentApproveEntity.insertRecruitmentTimeDecision(recruitmentDecisionModel);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public static class RecruitmentDecisionModel {

        private int overTimeProcessedId;//@Column(name = "OVER_TIME_PROCESS_PROCESSED_ID")
        private int recruitmentRequestId; //@Column(name = "OVER_TIME_REQUEST_ID")
        private String processedBy;//@Column(name = "PROCEESED_BY")
        String decision;
        private String nextState;//   @Column(name = "NEXT_STATE")
        private String commentGiven;// @Column(name = "COMMENT_GIVEN")
        private String recordedBy;//  @Column(name = "RECORDED_BY")//  String userName;
        private String recorededDateAndTime;//  @Column(name = "TIME_STAMP")

        public RecruitmentDecisionModel() {
        }

        public RecruitmentDecisionModel(int recruitmentRequestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
            this.recruitmentRequestId = recruitmentRequestId;
            this.processedBy = processedBy;
            this.decision = decision;
            this.nextState = nextState;
            this.commentGiven = commentGiven;
            this.recordedBy = recordedBy;
            this.recorededDateAndTime = recorededDateAndTime;
        }

        public RecruitmentDecisionModel(int overTimeProcessedId, int recruitmentRequestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
            this(recruitmentRequestId, processedBy, decision, nextState, commentGiven, recordedBy, recorededDateAndTime);
            this.overTimeProcessedId = overTimeProcessedId;
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

        public int getOverTimeProcessedId() {
            return overTimeProcessedId;
        }

        public int getrecruitmentRequestId() {
            return recruitmentRequestId;
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
    }

    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
        try {
            ResultSet _rs = recruitmentApproveEntity.selectProcessedRecruitmentRequest(requestId);
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
}
