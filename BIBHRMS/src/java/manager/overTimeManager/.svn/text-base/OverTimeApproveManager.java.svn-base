/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.overTimeManager;

import com.sun.webui.jsf.model.Option;
import entity.overTimeEntity.OverTimeApproveEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author mekete
 */
public class OverTimeApproveManager {

    //==============================================================================================================================================
    public static final String OVERTIME_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String OVERTIME_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String OVERTIME_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String OVERTIME_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String OVERTIME_DECISION_NONE = "-1";
    EmployeeManage employeeManager = new EmployeeManage();
    public static final String PROCESS_OVERTIME = AuthorizationManager.PROCESS_OVERTIME;//"8"
    public static final String FINAL_STATE_OVERTIME = AuthorizationManager.readFinalState(PROCESS_OVERTIME);
    public static final String INITIAL_STATE_OVERTIME = AuthorizationManager.readInitialState(PROCESS_OVERTIME);
    String userName = "";
    String loggedInEmployeeId;
    //==============================================================================================================================================
    OverTimeApproveEntity overTimeApproveEntity = new OverTimeApproveEntity();
    OverTimeRequestManager overTimeRequestManager = new OverTimeRequestManager();
    OverTimeDecisionModel overTimeDecisionModel = new OverTimeDecisionModel();
    OverTimeRequestModel overTimeRequestAttributes = new OverTimeRequestModel();
    //==============================================================================================================================================

    /**
     *
     */
    public boolean saveOverTimeDecision(int requestId, String processedBy, String decision, String currentState, String commentGiven, ArrayList<OverTimeRequestModel> selectedEmployeeList) {
        String nextState = AuthorizationManager.readNextState(currentState, PROCESS_OVERTIME, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            overTimeDecisionModel = new OverTimeDecisionModel(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime);
            if (overTimeApproveEntity.insertOverTimeDecision(overTimeDecisionModel)) {//if successful
                overTimeApproveEntity.updateSelectedEmployeeStatus(selectedEmployeeList);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<OverTimeRequestModel> getApprovedEmployeeAndOverTimeList(int overTimeRequestId) {
        ArrayList<OverTimeRequestModel> requestLists = new ArrayList<OverTimeRequestModel>();
        try {
            ResultSet _rs = overTimeApproveEntity.selectApprovedEmployeeAndOverTimeList(overTimeRequestId);
            while (_rs.next()) {
                overTimeRequestAttributes = new OverTimeRequestModel();
                overTimeRequestAttributes.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeFullName(_rs.getString("FIRST_NAME")+" "+_rs.getString("MIDDLE_NAME")+" "+_rs.getString("LAST_NAME"));
                overTimeRequestAttributes.setStartDate(_rs.getString("START_DATE"));
                overTimeRequestAttributes.setStartTime(_rs.getString("START_TIME"));
                overTimeRequestAttributes.setEndDate(_rs.getString("END_DATE"));
                overTimeRequestAttributes.setEndTime(_rs.getString("END_TIME"));
                overTimeRequestAttributes.setOverTimeFactor(_rs.getDouble("OVER_TIME_FACTOR"));
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                overTimeRequestAttributes.setAttendanceDate(dateFormat.format(new Date()));
                overTimeRequestAttributes.setAttendanceDate(_rs.getString("START_DATE"));
                overTimeRequestAttributes.setDisplayedOverTimeFactor(_rs.getString("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setSelected(true);
                requestLists.add(overTimeRequestAttributes);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int getSmallestStartTime(int overTimeRequestId) {
        String startTime = null;
        String startHour = null;
        String startMin = null;
        int totalMinInHour = 0;
        int totalMinInMin = 0;
        int totalMin = 0;
        int startTimeInMinute =1500;
        try {
            ResultSet _rs = overTimeApproveEntity.selectSmallestStartTime(overTimeRequestId);
            while (_rs.next()) {

                startTime = _rs.getString("START_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                totalMinInHour = Integer.parseInt(startHour) * 60;
                totalMinInMin = Integer.parseInt(startMin);
                totalMin = totalMinInHour + totalMinInMin;
                if(startTimeInMinute > totalMin){
                   startTimeInMinute = totalMin;
                }


            }
            return startTimeInMinute;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int getBiggestEndTime(int overTimeRequestId) {
        String startTime = null;
        String startHour = null;
        String endMin = null;
        int totalMinInHour = 0;
        int totalMinInMin = 0;
        int totalMin = 0;
        int endTimeInMinute =0;
        try {
            ResultSet _rs = overTimeApproveEntity.selectBigestEndTime(overTimeRequestId);
            while (_rs.next()) {

                startTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                endMin = startTime.substring(3,5);
                totalMinInHour = Integer.parseInt(startHour) * 60;
                totalMinInMin = Integer.parseInt(endMin);
                totalMin = totalMinInHour + totalMinInMin;
                if(endTimeInMinute < totalMin){
                   endTimeInMinute = totalMin;
                }


            }
            return endTimeInMinute;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public ArrayList<OverTimeRequestModel> getEmployeeAtrendanceOverTimeList(int overTimeRequestId) {
        ArrayList<OverTimeRequestModel> requestLists = new ArrayList<OverTimeRequestModel>();
        try {
            ResultSet _rs = overTimeApproveEntity.selectApprovedEmployeeAndOverTimeList(overTimeRequestId);
            while (_rs.next()) {
                overTimeRequestAttributes = new OverTimeRequestModel();
                overTimeRequestAttributes.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeFullName(_rs.getString("FIRST_NAME")+" "+_rs.getString("MIDDLE_NAME")+" "+_rs.getString("LAST_NAME"));
                overTimeRequestAttributes.setStartDate(_rs.getString("START_DATE"));
                overTimeRequestAttributes.setStartTime(_rs.getString("START_TIME"));
                overTimeRequestAttributes.setEndDate(_rs.getString("END_DATE"));
                overTimeRequestAttributes.setEndTime(_rs.getString("END_TIME"));
                overTimeRequestAttributes.setOverTimeFactor(_rs.getDouble("OVER_TIME_FACTOR"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                overTimeRequestAttributes.setAttendanceDate(dateFormat.format(new Date()));
                overTimeRequestAttributes.setDisplayedOverTimeFactor(_rs.getString("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setSelected(false);
                requestLists.add(overTimeRequestAttributes);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getEmployeesListToTakeAttendance(int overTimeRequestId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeApproveEntity.selectApprovedEmployeeAndOverTimeList(overTimeRequestId);
            while (_rs.next()) {
                SelectItem currentItem = new SelectItem(_rs.getString("OVER_REQUEST_ID"), _rs.getString("REQUESTER_ID"));
                requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedOverTimeRequests() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeApproveEntity.selectApprovedOverTimeRequests(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID") + " on " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
 public ArrayList<SelectItem> getApprovedOverTimeAttendance() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs =null; //overTimeApproveEntity.selectApprovedOverTimeRequestsAttendance(loggedInEmployeeId);
            while (_rs.next()) {
                 SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("ATTENDANCE_DATE") + "--" + _rs.getString("HR_OVER_TIME_ATTENDANCE_ID"), _rs.getString("REQUESTER_ID") + " on " + _rs.getString("ATTENDANCE_DATE"));
                requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
  public ArrayList<SelectItem> getApprovedOverTimeAttendanceApproved() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs =null;// overTimeApproveEntity.selectApprovedOverTimeRequestsAttendanceApproved(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID"));
                requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<Option> getRequestsToBeProcessed() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = overTimeApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
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
            ResultSet _rs = overTimeApproveEntity.selectProcessedOverTimeRequest(requestId);
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

    public ArrayList<Option> getMyDecisionsOnRequests() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = overTimeApproveEntity.selectMyDecisionsOnRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getLoginId(int overTimeRequestId) {
        String LoginId = null;
        try {
            ResultSet _rs = overTimeApproveEntity.selectLoginId(overTimeRequestId);
            while (_rs.next()) {
                LoginId = _rs.getString("LOGIN_PERSON_ID");



            }
            _rs.close();
            return LoginId;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
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

    public static class OverTimeDecisionModel {

        private int overTimeProcessedId;//@Column(name = "OVER_TIME_PROCESS_PROCESSED_ID")
        private int overTimeRequestId; //@Column(name = "OVER_TIME_REQUEST_ID")
        private String processedBy;//@Column(name = "PROCEESED_BY")
        String decision;
        private String nextState;//   @Column(name = "NEXT_STATE")
        private String commentGiven;// @Column(name = "COMMENT_GIVEN")
        private String recordedBy;//  @Column(name = "RECORDED_BY")//  String userName;
        private String recorededDateAndTime;//  @Column(name = "TIME_STAMP")

        public OverTimeDecisionModel() {
        }

        public OverTimeDecisionModel(int overTimeRequestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
            this.overTimeRequestId = overTimeRequestId;
            this.processedBy = processedBy;
            this.decision = decision;
            this.nextState = nextState;
            this.commentGiven = commentGiven;
            this.recordedBy = recordedBy;
            this.recorededDateAndTime = recorededDateAndTime;
        }

        public OverTimeDecisionModel(int overTimeProcessedId, int overTimeRequestId, String processedBy, String decision, String nextState, String commentGiven, String recordedBy, String recorededDateAndTime) {
            this(overTimeRequestId, processedBy, decision, nextState, commentGiven, recordedBy, recorededDateAndTime);
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

        public int getOverTimeRequestId() {
            return overTimeRequestId;
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
}
