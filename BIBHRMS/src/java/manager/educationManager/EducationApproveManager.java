/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

import com.sun.webui.jsf.model.Option;
import entity.educationEntity.EducationRequestEntity;
import entity.educationEntity.EducationApproveEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.CommeeteeCommentsGiven;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.authorizationManager.DescisionModel;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author mekete
 */
public class EducationApproveManager {

    String userName;
    String loggedInEmployeeId;
    DescisionModel descisionModel = new DescisionModel();
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationRequestEntity educationRequestEntity = new EducationRequestEntity();
    EducationApproveEntity educationApproveEntity = new EducationApproveEntity();
    public static final String EDUCATION_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String EDUCATION_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String EDUCATION_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String EDUCATION_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String EDUCATION_DECISION_NONE = "-1";
    public static final String PROCESS_EDUCATION = AuthorizationManager.PROCESS_EDUCATION;//"5"
    public static final String FINAL_STATE_EDUCATION = AuthorizationManager.readFinalState(PROCESS_EDUCATION);
    public static final String INITIAL_STATE_EDUCATION = AuthorizationManager.readInitialState(PROCESS_EDUCATION);

//    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
//        return (new AuthorizationManager()).getRequestHistory("HR_EDUCATION_PROCESSED", requestId);
//    }
    public ArrayList<SelectItem> getAvailableDecisionsToMake(String processState) {
        ArrayList<SelectItem> decisionLists = new ArrayList<SelectItem>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisionsToMake(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public boolean saveDecision(int requestId, String processedBy, String commnetGiven, String decision, String currentState, byte minute[], String fileExtenstion) {
        String nextState = (decision.contains("$$")) ? currentState : AuthorizationManager.readNextState(currentState, PROCESS_EDUCATION, decision);
        //String status=   AuthorizationManager.readNextState(currentState, PROCESS_EDUCATION, decisionS);
        String forwardedToCommittee = (decision.contains("$$")) ? "YES" : "NO";
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        educationRequestModel = new EducationRequestModel(requestId, processedBy, decision, nextState, commnetGiven, userName, recorededDateAndTime, forwardedToCommittee, minute, fileExtenstion);

        try {
            educationApproveEntity.insertEducationDecision(educationRequestModel);
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
            java.sql.ResultSet _rs = educationApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
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
            ResultSet _rs = (ResultSet) educationApproveEntity.selectProcessedOverTimeRequest(requestId);
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
            java.sql.ResultSet _rs = educationApproveEntity.selectMyDecisionsOnRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
            }
            _rs.close();
            return pendingRequests;
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

    public int getForwardedToCommittee(int requestId, String status) {
        int committeeId = -1;
        try {
            ResultSet _rs = educationApproveEntity.selectForwardedToCommittee(requestId, status);
            if (_rs.next()) {
                committeeId = extractCommitteeId(_rs.getString("DECISION"));

            }
            _rs.close();
            return committeeId;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return committeeId;
        }
    }

    private int extractCommitteeId(String decision) {
        decision = decision.trim();
        int committeeId = -1;
        for (int currentChar = 0; currentChar < decision.length(); currentChar++) {
            if (!Character.isDigit(decision.charAt(currentChar))) {
                committeeId = Integer.parseInt(decision.substring(0, currentChar));
                return committeeId;
            }
        }

        return committeeId;
    }
    CommitteeRegistrationManager committeeRegistrationManager = new CommitteeRegistrationManager();

    public ArrayList<SelectItem> getActiveDesciplineCommittees() {
        ArrayList<SelectItem> committeeList = getAllActiveCommitteesSelectItem();
        committeeList.add(0, new SelectItem("-1", "--SELECT COMMITTEE--"));
        // return (new CommitteeRegistrationManager()).getAllCommittees("Discipline", "Active");
        return committeeList;
    }

    public ArrayList<SelectItem> getAllActiveCommitteesSelectItem() {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationApproveEntity.selectActiveCommittees();
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getInt("COMMITTEE_TYPE_CODE"), _rs.getString("COMMITEE_NAME")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean NewSaveCommitteeComeentes(String memberEmployeeId, String memberFullName, String memberResponsiblity, String memberComentes, int educationRequestIds, String memberUserName, String memberPassWord, String status, String savedStatus) {

        try {
            if (educationApproveEntity.NewSaveCommitteeComenets(memberEmployeeId, memberFullName, memberResponsiblity, memberComentes, educationRequestIds, memberUserName, memberPassWord, status, savedStatus)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EducationApproveEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public boolean NewSaveCommitteeComeentes(String memberEmployeeId, String memberFullName, String memberResponsiblity, String memberComentes, int diciplineProblemId, String memberUserName, String memberPassWord, String status, String savedStatus) {
//
//        try {
//            if (educationApproveEntity.NewSaveCommitteeComenets(memberEmployeeId, memberFullName, memberResponsiblity, memberComentes, diciplineProblemId, memberUserName, memberPassWord, status, savedStatus)) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(EducationApproveEntity.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
    public int getAllForwardSize() {
        int sizeofmembers;
        int counter = 0;
        ResultSet _rs = null;
        try {
            _rs = educationApproveEntity.getAllEduacCommitee();

            while (_rs.next()) {
                counter++;

            }
            sizeofmembers = counter;
            return sizeofmembers;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public ArrayList<CommeeteeCommentsGiven> getCommiteeComentes(int educReqId) {
        try {
            ResultSet _rs = educationApproveEntity.selectCommeetessComments(educReqId);
            ArrayList<CommeeteeCommentsGiven> commeetesCommeentes = new ArrayList<CommeeteeCommentsGiven>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String employeeID = _rs.getString("EMPLOYEE_ID");
                String membersFullName = _rs.getString("EMPLOYEE_NAME");
                String responsiblity = _rs.getString("RESPONSIBILITY");
                String commeentesGiven = _rs.getString("COMMENT_GIVEN");
                String savedStatus = _rs.getString("SAVED_STATUS");

                commeetesCommeentes.add(new CommeeteeCommentsGiven(employeeID,
                        membersFullName,
                        responsiblity,
                        commeentesGiven,
                        counter,
                        savedStatus));
            }

            return commeetesCommeentes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<CommeeteeCommentsGiven> getCommiteeComentes(int educReqId, String memberUserName) {
        try {
            ResultSet _rs = educationApproveEntity.selectCommeetessComments(educReqId, memberUserName);
            ArrayList<CommeeteeCommentsGiven> commeetesCommeentes = new ArrayList<CommeeteeCommentsGiven>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String employeeID = _rs.getString("EMPLOYEE_ID");
                String membersFullName = _rs.getString("EMPLOYEE_NAME");
                String responsiblity = _rs.getString("RESPONSIBILITY");
                String commeentesGiven = _rs.getString("COMMENT_GIVEN");

                commeetesCommeentes.add(new CommeeteeCommentsGiven(employeeID, membersFullName, responsiblity, commeentesGiven, counter));
            }

            return commeetesCommeentes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public boolean deleteApprovedRequest(int educProcessedId) {
        try {
            educationApproveEntity.deleteApprovedRequestList(educProcessedId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public ArrayList<Option> getCommeeteforwardListByApprover() {
        try {
            ArrayList<Option> commeetePendingLists = new ArrayList<Option>();
            ResultSet _rs = educationApproveEntity.selectForwardToCommitee();
            while (_rs.next()) {

                commeetePendingLists.add(new Option(_rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS") + "--" + _rs.getString("EDUCATION_PROCESSED_ID"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE")));
            }
            _rs.close();
            return commeetePendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int isForwardedToCommitee(int educationRequestId) {
        int forwardedOrNot = 0;
        String forwardedToCommittee = null;
        try {
            ResultSet _rs = educationApproveEntity.isForwardedToCommitee(educationRequestId);
            if (_rs.next()) {
                forwardedToCommittee = _rs.getString("FORWARDED_TO_COMMITTEE");
                if (forwardedToCommittee.equalsIgnoreCase("YES")) {
                    forwardedOrNot = 1;
                }

            }
            _rs.close();
            return forwardedOrNot;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return forwardedOrNot;
        }
    }

    public ArrayList<HashMap> readEmployeeFile(int requestId) {
        return educationApproveEntity.readEmployeeFile(requestId);
    }

    public CommitteeRegistrationManager getCommitteeRegistrationManager() {
        return committeeRegistrationManager;
    }

    public void setCommitteeRegistrationManager(CommitteeRegistrationManager committeeRegistrationManager) {
        this.committeeRegistrationManager = committeeRegistrationManager;
    }

    public DescisionModel getDescisionModel() {
        return descisionModel;
    }

    public void setDescisionModel(DescisionModel descisionModel) {
        this.descisionModel = descisionModel;
    }

    public EducationApproveEntity getEducationApproveEntity() {
        return educationApproveEntity;
    }

    public void setEducationApproveEntity(EducationApproveEntity educationApproveEntity) {
        this.educationApproveEntity = educationApproveEntity;
    }

    public EducationRequestEntity getEducationRequestEntity() {
        return educationRequestEntity;
    }

    public void setEducationRequestEntity(EducationRequestEntity educationRequestEntity) {
        this.educationRequestEntity = educationRequestEntity;
    }

    public EducationRequestModel getEducationRequestModel() {
        return educationRequestModel;
    }

    public void setEducationRequestModel(EducationRequestModel educationRequestModel) {
        this.educationRequestModel = educationRequestModel;
    }

    public byte[] singleSelect(int documentId) {
        try {
            byte[] bytePicture = null;
            OracleSerialBlob blo = educationApproveEntity.select_Document(documentId);
            if (blo != null) {
                bytePicture = blo.getBytes(0, (int) blo.length());
            } else {
            }
            return bytePicture;


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static class FileUpLoad {

        int fileID;
        String fileName;
        String fileType;
        int requestID;
        byte[] attachedFile;
        String extention;

        public int getFileID() {
            return fileID;
        }

        public void setFileID(int fileID) {
            this.fileID = fileID;
        }

        public byte[] getAttachedFile() {
            return attachedFile;
        }

        public void setAttachedFile(byte[] attachedFile) {
            this.attachedFile = attachedFile;
        }

        public String getExtention() {
            return extention;
        }

        public void setExtention(String extention) {
            this.extention = extention;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public int getRequestID() {
            return requestID;
        }

        public void setRequestID(int requestID) {
            this.requestID = requestID;
        }

        public FileUpLoad() {
        }
    }

    public FileUpLoad setValues(int eduRequestId) {
        FileUpLoad fileUpLoad = new FileUpLoad();
        try {
            ResultSet _rs = educationApproveEntity.selectDocumentAttrbutie(eduRequestId);
            if (_rs.next()) {


                fileUpLoad.setFileID(_rs.getInt("FILE_ID"));
                fileUpLoad.setFileName(_rs.getString("FILE_NAME"));
                fileUpLoad.setFileType(_rs.getString("FILE_TYPE"));
                fileUpLoad.setExtention(_rs.getString("FILE_EXTENSTION"));
                fileUpLoad.setRequestID(_rs.getInt("REQUEST_ID"));
                fileUpLoad.setAttachedFile(_rs.getBytes("ATTACHED_FILE"));
                return fileUpLoad;
            }
            _rs.close();
            return fileUpLoad;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public boolean saveFile(ArrayList<SelectItem> minuteAttachedList, String fileExtension, byte[] minute) {
        //String timeStamp = new Timestamp((new Date()).getTime()).toString();
        //educationRequestModel = new EducationRequestModel(minuteAttachedList, fileExtension, minute);
        try {
            return educationApproveEntity.insertFile(minuteAttachedList, fileExtension, minute);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

  public int CheckIDFoundInRequestHistory(int checkId) {
        try {
            return educationApproveEntity.CheckIDFoundInRequestHistory(checkId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    public boolean UpdateFile(int educationRequestId, String fileExtension, byte[] minute) {
        // String timeStamp = new Timestamp((new Date()).getTime()).toString();
        educationRequestModel = new EducationRequestModel(educationRequestId, fileExtension, minute);

        try {
            educationApproveEntity.UodateFile(educationRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public ArrayList<EducationRequestModel> selectAllForwardedRequest() {
        ArrayList<EducationRequestModel> CourseLists = new ArrayList<EducationRequestModel>();
        try {
            ResultSet _rs = educationApproveEntity.selectAllForwardedRequest();
            while (_rs.next()) {
                EducationRequestModel benefitTypeModel = new EducationRequestModel();
                benefitTypeModel.setEducationRequestId(_rs.getInt("education_request_id"));
                benefitTypeModel.setRequesterName(_rs.getString("fullName"));
                CourseLists.add(benefitTypeModel);
            }
            _rs.close();
            return CourseLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllForwardedRequest() {
        ArrayList<SelectItem> notTrainnedEmployeesList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationApproveEntity.selectAllForwardedRequest();
            while (_rs.next()) {
                notTrainnedEmployeesList.add(new SelectItem(_rs.getInt("education_request_id"), _rs.getString("fullName")));
//               notTrainnedEmployeesList.add(new SelectItem(_rs.getString("EMP_ID"), _rs.getString("FIRST_NAME") + "" + _rs.getString("MIDDLE_NAME") + "" + _rs.getString("LAST_NAME")));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            ErrorLogWriter.writeError(sqle);
        }
        return notTrainnedEmployeesList;
    }
}
