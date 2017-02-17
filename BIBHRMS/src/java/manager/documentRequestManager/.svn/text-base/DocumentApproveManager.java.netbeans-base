/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.documentRequestManager;

import com.sun.webui.jsf.model.Option;
import entity.documentEntity.DocumentApproveEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
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
public class DocumentApproveManager {

    DocumentApproveEntity documentApproveEntity = new DocumentApproveEntity();
    public static final String DOCUMENT_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String DOCUMENT_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String DOCUMENT_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String DOCUMENT_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String DOCUMENT_DECISION_NONE = "-1";
    EmployeeManage employeeManager = new EmployeeManage();
    public static final String PROCESS_DOCUMENT = AuthorizationManager.PROCESS_DOCUMENTREQUEST;//"1"
    public static final String FINAL_STATE_DOCUMENTREQUEST = AuthorizationManager.readFinalState(PROCESS_DOCUMENT);
    public static final String INITIAL_STATE_DOCUMENTREQUEST = AuthorizationManager.readInitialState(PROCESS_DOCUMENT);
    String userName = "";

    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
        try {
            ResultSet _rs = documentApproveEntity.selectProcessedDocumentRequest(requestId);
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
                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 9);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "" : _rs.getString("COMMENT_GIVEN");
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

    public ArrayList<Option> getRequestsToBeProcessed() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = documentApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("DOCUMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("REASON"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getProcessedRequestsHistory() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = documentApproveEntity.selectProcessedRequestsHistory(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("DOCUMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("REASON"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveLeaveDecision(int requestId, String processedBy, String decision, String currentState, String commentGiven) {
        String nextState = AuthorizationManager.readNextState(currentState, PROCESS_DOCUMENT, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        DecisionMadeModel decisionMadeModel = new DecisionMadeModel(requestId, processedBy, commentGiven, decision, nextState, userName, recorededDateAndTime);
        try {
            if (documentApproveEntity.insertDocumentDecision(decisionMadeModel)) {//if successful
                if (decision.equals(DOCUMENT_DECISION_APPROVE)) {//makt elligible
                    //leaveApproveEntity.updateEmployeeStatusFromRequestId(decision, EmployeeManage.EMPLOYEE_STATUS_LEAVEWAITING);
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean updateDocReturnStatus(String docReturn, int docReqId) {
        try {
            return documentApproveEntity.updateDocReturnStatus(docReturn, docReqId);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public class DecisionMadeModel implements Serializable {

        int processedId;
        int requestId;
        String processedBy;
        String commentGiven;
        String decision;
        String recordedBy;
        String timeStamp;
        String nextState;

        public DecisionMadeModel() {
        }

        public DecisionMadeModel(int requestId, String processedBy, String commentGiven, String decision, String recordedBy, String timeStamp) {
            this.requestId = requestId;
            this.processedBy = processedBy;
            this.commentGiven = commentGiven;
            this.decision = decision;
            this.recordedBy = recordedBy;
            this.timeStamp = timeStamp;
        }

        public DecisionMadeModel(int requestId, String processedBy, String commentGiven, String decision, String nextState, String recordedBy, String timeStamp) {
            this(requestId, processedBy, commentGiven, decision, recordedBy, timeStamp);
            this.nextState = nextState;
        }

        public DecisionMadeModel(int processedId, int requestId, String processedBy, String commentGiven, String decision, String recordedBy, String timeStamp) {
            this(requestId, processedBy, commentGiven, decision, recordedBy, timeStamp);
            this.processedId = processedId;
        }

        public DecisionMadeModel(int processedId, int requestId, String processedBy, String commentGiven, String decision, String nextState, String recordedBy, String timeStamp) {
            this(processedId, requestId, processedBy, commentGiven, decision, recordedBy, timeStamp);
            this.nextState = nextState;
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

        public String getProcessedBy() {
            return processedBy;
        }

        public void setNextState(String nextState) {
            this.nextState = nextState;
        }

        public void setProcessedBy(String processedBy) {
            this.processedBy = processedBy;
        }

        public String getNextState() {
            return nextState;
        }

        public int getProcessedId() {
            return processedId;
        }

        public void setProcessedId(int processedId) {
            this.processedId = processedId;
        }

        public String getRecordedBy() {
            return recordedBy;
        }

        public void setRecordedBy(String recordedBy) {
            this.recordedBy = recordedBy;
        }

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }
    }

    public ArrayList<EmployeeExperienceHistroyModel> getEmpExperienceHistory(String empId) {
        try {
            ResultSet _rs = documentApproveEntity.selectEmployeeExperience(empId);
            ArrayList<EmployeeExperienceHistroyModel> empExpHistroy = new ArrayList<EmployeeExperienceHistroyModel>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String empName = empId;
                String serviceYr = "";
                String jobCode = _rs.getString("PREV_JOB_POSITION");
                String jobDesc = _rs.getString("OLDJOBDESC");
                String rank = _rs.getString("PREV_RANK");
                String salary = _rs.getString("PREV_SALARY");
                String endDate = _rs.getString("PROMOTION_DATE");
                String startDate = "";
                int i = _rs.getRow();
                _rs.absolute(i - 1);
                startDate = _rs.getString("PROMOTION_DATE");
                empExpHistroy.add(new EmployeeExperienceHistroyModel(counter, empId, empName, serviceYr, jobCode, jobDesc, rank, salary, startDate, endDate));
                _rs.absolute(i);
            }
//                _rs.absolute(1);
//                counter++;
//                String empName = empId;
//                String serviceYr = "";
//                String jobCode = _rs.getString("newJob");
//                String jobDesc = _rs.getString("newJobDesc");
//                String rank = _rs.getString("newRank");
//                String salary = _rs.getString("newSalary");
//                //current date
//                String endDate = _rs.getString("PROMOTION_DATE");
//                String startDate = "";
//                startDate = _rs.getString("PROMOTION_DATE");
//                empExpHistroy.add(new EmployeeExperienceHistroyModel(counter, empId, empName, serviceYr, jobCode, jobDesc, rank, salary, startDate, endDate));

            return empExpHistroy;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static class EmployeeExperienceHistroyModel implements Serializable {

        private int counter;
        private String empId;
        private String empName;
        private String serviceYr;
        private String jobCode;
        private String jobDesc;
        private String rank;
        private String salary;
        private String startDate;
        private String endDate;

        /**
         * @return the empId
         */
        public String getEmpId() {
            return empId;
        }

        /**
         * @param empId the empId to set
         */
        public void setEmpId(String empId) {
            this.empId = empId;
        }

        /**
         * @return the empName
         */
        public String getEmpName() {
            return empName;
        }

        /**
         * @param empName the empName to set
         */
        public void setEmpName(String empName) {
            this.empName = empName;
        }

        /**
         * @return the serviceYr
         */
        public String getServiceYr() {
            return serviceYr;
        }

        /**
         * @param serviceYr the serviceYr to set
         */
        public void setServiceYr(String serviceYr) {
            this.serviceYr = serviceYr;
        }

        /**
         * @return the jobCode
         */
        public String getJobCode() {
            return jobCode;
        }

        /**
         * @param jobCode the jobCode to set
         */
        public void setJobCode(String jobCode) {
            this.jobCode = jobCode;
        }

        /**
         * @return the jobDesc
         */
        public String getJobDesc() {
            return jobDesc;
        }

        /**
         * @param jobDesc the jobDesc to set
         */
        public void setJobDesc(String jobDesc) {
            this.jobDesc = jobDesc;
        }

        /**
         * @return the rank
         */
        public String getRank() {
            return rank;
        }

        /**
         * @param rank the rank to set
         */
        public void setRank(String rank) {
            this.rank = rank;
        }

        /**
         * @return the salary
         */
        public String getSalary() {
            return salary;
        }

        /**
         * @param salary the salary to set
         */
        public void setSalary(String salary) {
            this.salary = salary;
        }

        /**
         * @return the startDate
         */
        public String getStartDate() {
            return startDate;
        }

        /**
         * @param startDate the startDate to set
         */
        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        /**
         * @return the endDate
         */
        public String getEndDate() {
            return endDate;
        }

        /**
         * @param endDate the endDate to set
         */
        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        /**
         * @return the counter
         */
        public int getCounter() {
            return counter;
        }

        /**
         * @param counter the counter to set
         */
        public void setCounter(int counter) {
            this.counter = counter;
        }

        public EmployeeExperienceHistroyModel(int counter, String empId,
                String empName, String serviceYr, String jobCode, String jobDesc,
                String rank, String salary, String startDate, String endDate) {
            this.counter = counter;
            this.empId = empId;
            this.empName = empName;
            this.serviceYr = serviceYr;
            this.jobCode = jobCode;
            this.jobDesc = jobDesc;
            this.rank = rank;
            this.salary = salary;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}
