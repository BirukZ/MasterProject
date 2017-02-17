/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

import com.sun.webui.jsf.model.Option;
import entity.educationEntity.EducationRequestEntity;
import entity.educationEntity.EducationApproveEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.authorizationManager.DescisionModel;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;
import entity.educationEntity.ChangeInstituApproveEntity;
import java.sql.ResultSet;

/**
 *
 * @author mekete
 */
public class changeInstituApproveManager {

    String userName;
    String loggedInEmployeeId;
    DescisionModel descisionModel = new DescisionModel();
    EducationRequestEntity educationRequestEntity = new EducationRequestEntity();
    EducationApproveEntity educationApproveEntity = new EducationApproveEntity();
    ChangeInstituApproveEntity changeInstituApproveEntity = new ChangeInstituApproveEntity();
    changeInstitutionRequestModel ChangeInstitutionRequestModel = new changeInstitutionRequestModel();
    public static final String CHANGEINS_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String CHANGEINS_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String CHANGEINS_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String CHANGEINS_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String CHANGEINS_DECISION_NONE = "-1";
    public static final String PROCESS_CHANGEINSTITUTION = AuthorizationManager.PROCESS_CHANGEINSTITUTION;//"5"
    public static final String FINAL_STATE_CHANGEINS = AuthorizationManager.readFinalState(PROCESS_CHANGEINSTITUTION);
    public static final String INITIAL_STATE_CHANGEINS = AuthorizationManager.readInitialState(PROCESS_CHANGEINSTITUTION);

//    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
//        return (new AuthorizationManager()).getRequestHistory("CHANGEINS_REQU_ID", requestId);
//    }
    public ArrayList<SelectItem> getAvailableDecisionsToMake(String processState) {
        ArrayList<SelectItem> decisionLists = new ArrayList<SelectItem>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisionsToMake(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public boolean saveDecision(int requestId, String processedBy, String decision,String currentState,String commnetGiven ) {
        String nextState = (decision.contains("$$")) ? currentState : AuthorizationManager.readNextState(currentState, PROCESS_CHANGEINSTITUTION, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        ChangeInstitutionRequestModel = new changeInstitutionRequestModel(requestId, processedBy, decision, nextState, commnetGiven, userName, recorededDateAndTime);
        try {
            changeInstituApproveEntity.insertChangeInsDecision(ChangeInstitutionRequestModel);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<Option> getRequestsToBeProcessed() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = changeInstituApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("CHANGEINS_REQU_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("EDU_REQ_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
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
            ResultSet _rs = changeInstituApproveEntity.selectMyDecisionsOnRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("CHANGEINS_REQU_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("EDU_REQ_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean UpadtechangeInstitutionRequest(int educRequestID, String requesterId, String educationProgramName, String institutionName, String ethiopianInstitution, String institutionAccredited, String institutionAddress, String startDate, String endDate, String appliedDate, String educationShiftCategory, String educationTypeCategory, String educationLevelCategory, double costPerCreditHour, int numberOfCreditHours, double totalAdminstrationCosts, double durationInYear, String reasonDescription, String documentReferenceNumber) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        ChangeInstitutionRequestModel = new changeInstitutionRequestModel(educRequestID, requesterId, educationProgramName, institutionName, ethiopianInstitution, institutionAccredited, institutionAddress, startDate,endDate, appliedDate, educationShiftCategory, educationTypeCategory, educationLevelCategory, costPerCreditHour, numberOfCreditHours, totalAdminstrationCosts, durationInYear, reasonDescription, documentReferenceNumber, EducationApproveManager.FINAL_STATE_EDUCATION, timeStamp, userName);
        try {
            changeInstituApproveEntity.updateEducationRequest(ChangeInstitutionRequestModel);
        return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        
    }
 public boolean InsertchangeInstitutionRequest(int educRequestID, String requesterId, String educationProgramName, String institutionName, String ethiopianInstitution, String institutionAccredited, String institutionAddress, String startDate,String endDate, String appliedDate, String educationShiftCategory, String educationTypeCategory, String educationLevelCategory, double costPerCreditHour, int numberOfCreditHours, double totalAdminstrationCosts, double durationInYear, String reasonDescription, String documentReferenceNumber) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        ChangeInstitutionRequestModel = new changeInstitutionRequestModel(educRequestID, requesterId, educationProgramName, institutionName, ethiopianInstitution, institutionAccredited, institutionAddress, startDate, endDate,appliedDate, educationShiftCategory, educationTypeCategory, educationLevelCategory, costPerCreditHour, numberOfCreditHours, totalAdminstrationCosts, durationInYear, reasonDescription, documentReferenceNumber, EducationApproveManager.FINAL_STATE_EDUCATION, timeStamp, userName);
        try {
            changeInstituApproveEntity.updateEducationRequest(ChangeInstitutionRequestModel);
        return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }
  public boolean UpadteEducationPretPay(int educRequestID, String requesterId) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        ChangeInstitutionRequestModel = new changeInstitutionRequestModel(educRequestID, requesterId);
        try {
            changeInstituApproveEntity.updateEducationPaymentRequest(ChangeInstitutionRequestModel);
        return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }
  public boolean UpadteEducationPostPay(int educRequestID, String requesterId) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        ChangeInstitutionRequestModel = new changeInstitutionRequestModel(educRequestID, requesterId);
        try {
            changeInstituApproveEntity.updateEducationPostRequest(ChangeInstitutionRequestModel);
        return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
        try {

            ResultSet _rs =  changeInstituApproveEntity.selectProcessedOverTimeRequest(requestId);
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

    public changeInstitutionRequestModel getEducationRequest(int requestId) {
        ChangeInstitutionRequestModel = new changeInstitutionRequestModel();
        try {
            ResultSet _rs = changeInstituApproveEntity.selectEducationRequest(requestId);
            if (_rs.next()) {

                ChangeInstitutionRequestModel.setEducationRequestId(requestId);
                ChangeInstitutionRequestModel.setRequesterId(_rs.getString("REQUESTER_ID"));

                ChangeInstitutionRequestModel.setChangeInstId(_rs.getInt("CHANGEINS_REQU_ID"));
                ChangeInstitutionRequestModel.setEducationProgramName(_rs.getString("EDUCATION_PROGRAM_NAME"));
                ChangeInstitutionRequestModel.setEducationLevelCategory(_rs.getString("EDUCATION_LEVEL_CATEGORY"));
                ChangeInstitutionRequestModel.setEducationShiftCategory(_rs.getString("EDUCATION_SHIFT_CATEGORY"));
                ChangeInstitutionRequestModel.setStartDate(_rs.getString("START_DATE"));
                  ChangeInstitutionRequestModel.setEndDate(_rs.getString("END_DATE"));
                ChangeInstitutionRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                ChangeInstitutionRequestModel.setDurationInYear(_rs.getDouble("DURATION_IN_YEAR"));

                ChangeInstitutionRequestModel.setReasonDescription(_rs.getString("REASON_DESCRIPTION"));
                ChangeInstitutionRequestModel.setInstitutionName(_rs.getString("INSTITUTION_NAME"));

                ChangeInstitutionRequestModel.setCostPerCreditHour(_rs.getDouble("COST_PER_CREDIT_HOUR"));
                ChangeInstitutionRequestModel.setNumberOfCreditHours(_rs.getInt("NUMBER_OF_CREDIT_HOURS"));
                ChangeInstitutionRequestModel.setTotalAdminstrationCosts(_rs.getDouble("TOTAL_ADMIN_COSTS"));

                ChangeInstitutionRequestModel.setDocumentReferenceNumber(_rs.getString("DOCUMENT_REFERENCE_NUMBER"));
                ChangeInstitutionRequestModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));
                ChangeInstitutionRequestModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                ChangeInstitutionRequestModel.setUserName(_rs.getString("USER_NAME"));


            } else {
                ChangeInstitutionRequestModel.setEducationRequestId(-1);
            }
            _rs.close();
            return ChangeInstitutionRequestModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
///================================================================
}
