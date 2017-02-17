/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import com.sun.webui.jsf.model.Option;
import entity.trainingEntity.TrainingNeedAssessementApproveEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.authorizationManager.DescisionModel;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author mekete
 */
public class TrainingNeedAssessementApproveManager {

    public static final String DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String DECISION_NONE = "-1";
    EmployeeManage employeeManager = new EmployeeManage();
    TrainingNeedAssessementApproveEntity trainingNeedAssessementApproveEntity = new TrainingNeedAssessementApproveEntity();
    public static final String PROCESS_TRAINING_NEED_ASSESSEMENT = AuthorizationManager.PROCESS_TRAINING_NEED_ASSESSEMENT;//"8"
    public static final String PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT = AuthorizationManager.PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT;//"8"
    public static final String FINAL_STATE_TRAINING_NEED_ASSESSEMENT = AuthorizationManager.readFinalState(PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT);
    public static final String INITIAL_STATE_TRAINING_NEED_ASSESSEMENT = AuthorizationManager.readInitialState(PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT);
    String userName = "";
    String loggedInEmployeeId;

    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
        try {
            ResultSet _rs = trainingNeedAssessementApproveEntity.selectProcessedOverTimeRequest(requestId);
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


    public ArrayList<RequestHistoryModel> getPreviousTrainings(String employeeId) {
        try {
            ResultSet _rs = trainingNeedAssessementApproveEntity.selectPreviousTrainings(employeeId);
            ArrayList<RequestHistoryModel> requestHistoryList = new ArrayList<RequestHistoryModel>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String EmployeeId = _rs.getString("EMP_ID");
                String trainingCourseName = _rs.getString("TRAININGORCOURSE_NAME");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String paymentBy = _rs.getString("PAYMENT_PAYE_BY");
                requestHistoryList.add(new RequestHistoryModel(counter, EmployeeId, trainingCourseName, startDate, endDate, paymentBy));
            }
            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<RequestHistoryModel> getPreviousTrainingsOnApprove(ArrayList<TrainingParticipantModel> participantList) {
        try {
           
            ArrayList<RequestHistoryModel> requestHistoryList = new ArrayList<RequestHistoryModel>();
            int counter = 0;
            for(TrainingParticipantModel obj:participantList){
                 ResultSet _rs = trainingNeedAssessementApproveEntity.selectPreviousTrainings(obj.getEmployeeId());
            while (_rs.next()) {
                counter++;
                String EmployeeId = _rs.getString("EMP_ID");
                String trainingCourseName = _rs.getString("TRAININGORCOURSE_NAME");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String paymentBy = _rs.getString("PAYMENT_PAYE_BY");
                requestHistoryList.add(new RequestHistoryModel(counter, EmployeeId, trainingCourseName, startDate, endDate, paymentBy));
            }
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
            ResultSet _rs = trainingNeedAssessementApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                String itemId = _rs.getString("NEED_ASSESSEMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS");
                String itemName = _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE");
                SelectItem currentRequest = new SelectItem(itemId, itemName);
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

    public String getLoginId(int needAssessmentRequestId) {
        String LoginId = null;
        try {
            ResultSet _rs = trainingNeedAssessementApproveEntity.selectLoginId(needAssessmentRequestId);
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

    public ArrayList<SelectItem> getMyDecisionsOnRequests() {
        ArrayList<SelectItem> pendingRequests = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = trainingNeedAssessementApproveEntity.selectMyDecisionsOnRequest(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("NEED_ASSESSEMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
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
//PROCESS_TRAINING_NEED_ASSESSEMENT
    public boolean saveDecision(int requestId, String processedBy, String decision, String currentState, String commentGiven, ArrayList<TrainingParticipantModel> participantLists, String startDate, String endDate, String noOfDays, String award, String trainerName, String trainerProfession) {
        String nextState = AuthorizationManager.readNextState(currentState, PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            DescisionModel descisionModel = new DescisionModel(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime);
            if (trainingNeedAssessementApproveEntity.insertDecision(descisionModel,startDate,endDate,noOfDays,award,trainerName, trainerProfession)) {//if successful
                trainingNeedAssessementApproveEntity.updateSelectedEmployeeStatus(participantLists);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
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

    public TrainingNeedAssessementApproveEntity getTrainingNeedAssessementApproveEntity() {
        return trainingNeedAssessementApproveEntity;
    }

    public void setTrainingNeedAssessementApproveEntity(TrainingNeedAssessementApproveEntity trainingNeedAssessementApproveEntity) {
        this.trainingNeedAssessementApproveEntity = trainingNeedAssessementApproveEntity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
