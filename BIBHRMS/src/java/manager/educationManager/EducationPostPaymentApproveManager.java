/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

import com.sun.webui.jsf.model.Option;
import entity.educationEntity.EducationPostPaymentApproveEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.authorizationManager.DescisionModel;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class EducationPostPaymentApproveManager {

    String userName;
    String loggedInEmployeeId;
    DescisionModel descisionModel = new DescisionModel();
    EducationPaymentModel educationPaymentModel = new EducationPaymentModel();
    EducationPostPaymentApproveEntity educationPosPaymentApproveEntity = new EducationPostPaymentApproveEntity();
    public static final String EDUCATION_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String EDUCATION_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String EDUCATION_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String EDUCATION_DECISION_NONE = "-1";
    public static final String PROCESS_EDUCATION_POST_PAYMENT = AuthorizationManager.PROCESS_EDUCATION_POST_PAYMENT;//"5"
    public static final String FINAL_STATE_EDUCATION_POST_PAYMENT = AuthorizationManager.readFinalState(PROCESS_EDUCATION_POST_PAYMENT);
    public static final String INITIAL_STATE_EDUCATION_POST_PAYMENT = AuthorizationManager.readInitialState(PROCESS_EDUCATION_POST_PAYMENT);

//    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
//        return (new AuthorizationManager()).getRequestHistory("HR_EDUCATION_PROCESSED", requestId);
//    }
    public ArrayList<SelectItem> getAvailableDecisionsToMake(String processState) {
        ArrayList<SelectItem> decisionLists = new ArrayList<SelectItem>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisionsToMake(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public boolean saveDecision(int requestId, String processedBy, String decision,String currentState,String commnetGiven ) {
        String nextState = (decision.contains("$$")) ? currentState : AuthorizationManager.readNextState(currentState, AuthorizationManager.PROCESS_EDUCATION_POST_PAYMENT, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        educationPaymentModel = new EducationPaymentModel(requestId, processedBy, decision, nextState, commnetGiven, userName, recorededDateAndTime);

        try {
            educationPosPaymentApproveEntity.insertEducationPaymentDecision(educationPaymentModel);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

     public ArrayList<HashMap> getTableInfo(int reqestID,String date) {
        try {
            ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = educationPosPaymentApproveEntity.readAllTableInfo(reqestID,date);
            while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("AMINSTRATIVE_COST_TYPE", ocrs.getString("AMINSTRATIVE_COST_TYPE"));
                resultInfo.put("UNIT_COST", ocrs.getString("UNIT_COST"));
                // resultInfo.put("QUANTITY", ocrs.getString("QUANTITY"));
                resultInfo.put("TOTAL_COST", ocrs.getString("TOTAL_COST"));
                resultInfo.put("REQUESTER_ID", ocrs.getString("REQUESTER_ID"));
                resultInfo.put("ID", ocrs.getString("ID"));
                resultInfo.put("APPROVEDORNOT", ocrs.getString("APPROVEDORNOT"));
//                resultInfo.put("CGPA", ocrs.getString("CGPA"));
                IntSuccLists.add(resultInfo);
            }
            return IntSuccLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }

    public ArrayList<Option> getRequestsToBeProcessed() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            java.sql.ResultSet _rs = educationPosPaymentApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("EDUC_POS_PAYMENT_REQ_ID") + "--" + _rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS")+ "--"+_rs.getString("APPLIED_DATE"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
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
            ResultSet _rs =  educationPosPaymentApproveEntity.selectProcessedOverTimeRequest(requestId);
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
            java.sql.ResultSet _rs = educationPosPaymentApproveEntity.selectMyDecisionsOnRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("EDUC_POS_PAYMENT_REQ_ID") + "--" + _rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS")+"--"+_rs.getString("APPLIED_DATE"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean UpadtechangeInstitutionRequest(int adminstratId, boolean selected) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        educationPaymentModel = new EducationPaymentModel(adminstratId, selected);
        try {
            educationPosPaymentApproveEntity.updateEducationRequest(educationPaymentModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public ArrayList<HashMap> getCourseInfo(int reqestID,String date) {
        try {
            ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = educationPosPaymentApproveEntity.readAllCourse(reqestID,date);
            while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
//                resultInfo.put("AMINSTRATIVE_COST_TYPE", ocrs.getString("AMINSTRATIVE_COST_TYPE"));
                resultInfo.put("ID", ocrs.getString("ID"));
                resultInfo.put("EDUC_REQ_ID", ocrs.getString("EDUC_REQ_ID"));
                resultInfo.put("REQUESTER_ID", ocrs.getString("REQUESTER_ID"));
                resultInfo.put("COURSE_CODE", ocrs.getString("COURSE_CODE"));
                resultInfo.put("SEMISTER", ocrs.getString("SEMISTER"));
                resultInfo.put("CREDIT_HOUR", ocrs.getString("CREDIT_HOUR"));
                resultInfo.put("CGPA", ocrs.getString("CGPA"));
                resultInfo.put("GRADE_PT", ocrs.getString("GRADE_PT"));
                resultInfo.put("ACADAMIC_YEAR", ocrs.getString("ACADAMIC_YEAR"));
                IntSuccLists.add(resultInfo);
            }
            return IntSuccLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }


    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
//     public EducationPaymentModel getEducationRequest(int requestId) {
//        educationPaymentModel = new EducationPaymentModel();
//        try {
//            ResultSet _rs = educationPaymentApproveEntity.selectEducationRequest(requestId);
//            if (_rs.next()) {
//
//                educationPaymentModel.setEducationRequestId(requestId);
//                educationPaymentModel.setRequesterId(_rs.getString("REQUESTER_ID"));
//
//                educationRequestModel.setChangeInstId(_rs.getInt("CHANGEINS_REQU_ID"));
//                educationRequestModel.setEducationProgramName(_rs.getString("EDUCATION_PROGRAM_NAME"));
//                educationRequestModel.setEducationLevelCategory(_rs.getString("EDUCATION_LEVEL_CATEGORY"));
//                educationRequestModel.setEducationShiftCategory(_rs.getString("EDUCATION_SHIFT_CATEGORY"));
//                educationRequestModel.setStartDate(_rs.getString("START_DATE"));
//                educationRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
//                educationRequestModel.setDurationInYear(_rs.getDouble("DURATION_IN_YEAR"));
//
//                educationRequestModel.setReasonDescription(_rs.getString("REASON_DESCRIPTION"));
//                educationPaymentModel.setInstitutionName(_rs.getString("INSTITUTION_NAME"));
//                educationRequestModel.setInstitutionAccredited(_rs.getString("INSTITUTION_ACCREDITED"));
//                educationRequestModel.setEthiopianInstitution(_rs.getString("ETHIOPIAN_INSTITUTION"));
//                educationRequestModel.setInstitutionAddress(_rs.getString("INSTITUTION_ADDRESS"));
//
//                educationRequestModel.setCostPerCreditHour(_rs.getDouble("COST_PER_CREDIT_HOUR"));
//                educationRequestModel.setNumberOfCreditHours(_rs.getInt("NUMBER_OF_CREDIT_HOURS"));
//                educationRequestModel.setTotalAdminstrationCosts(_rs.getDouble("TOTAL_ADMIN_COSTS"));
//
//                educationRequestModel.setDocumentReferenceNumber(_rs.getString("DOCUMENT_REFERENCE_NUMBER"));
//                educationRequestModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));
//                educationRequestModel.setTimeStamp(_rs.getString("TIME_STAMP"));
//                educationRequestModel.setUserName(_rs.getString("USER_NAME"));
//
//            } else {
//                educationRequestModel.setEducationRequestId(-1);
//            }
//            _rs.close();
//            return educationRequestModel;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
}
