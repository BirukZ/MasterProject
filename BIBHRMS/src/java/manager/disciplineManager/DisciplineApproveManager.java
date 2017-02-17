/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import com.sun.webui.jsf.model.Option;
import entity.disciplineEntity.DisciplineApproveEntity;
import entity.disciplineEntity.DisciplineRequestEntity;
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
import manager.committeeManager.CommitteeMemberModel.ChairManCommentes;
import manager.committeeManager.CommitteeMemberModel.RejectedPenalityComeentes;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author mekete VS BravoZulu
 */
public class DisciplineApproveManager {

    DisciplineRequestEntity disciplineRequestEntity = new DisciplineRequestEntity();
    DisciplineApproveEntity disciplineApproveEntity = new DisciplineApproveEntity();
    DisciplineProcessedModel disciplineProcessedModel = new DisciplineProcessedModel();
    DisciplineProcessedModel disciplineProcessedModelRequestApprove = new DisciplineProcessedModel();
    ChairManCommentes chairman = new ChairManCommentes();
    RejectedPenalityComeentes rejectPenality = new RejectedPenalityComeentes();
    public static final String PROCESS_DISCIPLINE = AuthorizationManager.PROCESS_DISCIPLINE;
    public static final String INITIAL_STATE_DISCIPLINE = AuthorizationManager.readInitialState(PROCESS_DISCIPLINE);
    public static final String ULTIMATE_FINAL_STATE_DISCIPLINE = AuthorizationManager.readFinalState(PROCESS_DISCIPLINE);
    public static final String DISCIPLINE_DECISION_APPROVE = "6";//SiteSecurityManager.Permission_Approve;
    public static final String DISCIPLINE_DECISION_FORWARD = "12";// SiteSecurityManager.Permission_Forward;
    public static final String DISCIPLINE_DECISION_RESUBMIT = "10";//SiteSecurityManager.Permission_Resubmit;
    public static final String DISCIPLINE_DECISION_REJECT = "11";//SiteSecurityManager.Permission_Reject;
    public static final String DISCIPLINE_DECISION_NONE = "-1";
    String userName;
    String loggedInEmployeeId;
    String discipline_problem_id;
    ////////////////////////////////////////////////////////////////
    String employeeStatus;
    String requester_id;
    String offence_type;
    String offender_id;
    String status;
    String description_of_offence;
    String reported_date;
    String repitition_of_offence;
    String reporterId;
    String reporterFullName;
    String reporterDepartment;
    String reporterPosition;
    private boolean selected;
    private boolean supportInfo;

    public DisciplineApproveManager() {
    }

    public DisciplineApproveManager(
            String discipline_problem_id,
            String offence_type,
            String offender_id,
            String status,
            String description_of_offence,
            String reported_date,
            String repitition_of_offence,
            String requester_id,
            String employee_Status,
            boolean supportInfo)
        {
        this.discipline_problem_id = discipline_problem_id;
        this.offence_type = offence_type;
        this.status = status;
        this.description_of_offence = description_of_offence;
        this.reported_date = reported_date;
        this.repitition_of_offence = repitition_of_offence;
        this.requester_id = requester_id;
        this.offender_id = offender_id;
        this.supportInfo = supportInfo;
        this.employeeStatus=employee_Status;
    }

    public ArrayList<Option> getAvailableDecisionToMake() {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        // decisionLists.add(new Option(DISCIPLINE_DECISION_FORWARD,"FORWARD"));
        decisionLists.add(new Option(DISCIPLINE_DECISION_APPROVE, "APPROVE"));
        decisionLists.add(new Option(DISCIPLINE_DECISION_RESUBMIT, "RESUBMIT"));
        decisionLists.add(new Option(DISCIPLINE_DECISION_REJECT, "REJECT"));
        decisionLists.add(0, new Option(DISCIPLINE_DECISION_NONE, "--SELECT --"));
        return decisionLists;
    }

//    public ArrayList<SelectItem> getActiveDesciplineCommittees() {
//        ArrayList<SelectItem> committeeList = (new CommitteeRegistrationManager()).getAllCommittees("Discipline", "Active");
//        committeeList.add(0, new SelectItem("-1", "--SELECT COMMITTEE--"));
//        // return (new CommitteeRegistrationManager()).getAllCommittees("Discipline", "Active");
//        return committeeList;
//    }


     public ArrayList<SelectItem> getActiveDesciplineCommittees() {
        ArrayList<SelectItem> committeeList = (new CommitteeRegistrationManager()).getAllCommitteesTypeForLu();
        committeeList.add(0, new SelectItem("-1", "--SELECT COMMITTEE--"));
        // return (new CommitteeRegistrationManager()).getAllCommittees("Discipline", "Active");
        return committeeList;
    }



    
    
     public ArrayList<Option> getAvailableDecisionsToMake(String userName){
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName);
        return decisionLists;
    }

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////
     public ArrayList<Option> getAvailableDecisionsToMakeNow(String userName){
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
       // decisionLists = new SiteSecurityManager().getAvailableDecisionsNow(request.getRequestURI(), userName);
        return decisionLists;
    }
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////





    public void clearOnPending(int disciplineProblemId) {
//        try {
//            disciplineApproveEntity.clearfromPending(disciplineProblemId);
//        } catch (SQLException ex) {
//            Logger.getLogger(DisciplineApproveManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public boolean SaveChairManCommeents(int disciplineProblemId, String commentes, String suggetedPenality, double dedctionAmount, String duration, String savedStatus, String commeentsGivenDay) {

        try {
            disciplineApproveEntity.saveChairManCommentes(disciplineProblemId, commentes, suggetedPenality, dedctionAmount, duration, savedStatus, commeentsGivenDay);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }
       public ArrayList<CommeeteeCommentsGiven> getCommiteeComentes(int disRequID, String memberUserName) {
        try {
            ResultSet _rs = disciplineApproveEntity.selectCommeetessComments(disRequID, memberUserName);
            ArrayList<CommeeteeCommentsGiven> commeetesCommeentes = new ArrayList<CommeeteeCommentsGiven>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String employeeID = _rs.getString("EMPLOYEE_ID");
                String membersFullName = _rs.getString("EMPLOYEE_NAME");
                String responsiblity = _rs.getString("RESPONSIBLITY");
                String commeentesGiven = _rs.getString("COMMEENTES_GIVEN");

                commeetesCommeentes.add(new CommeeteeCommentsGiven(employeeID, membersFullName, responsiblity, commeentesGiven, counter));
            }

            return commeetesCommeentes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public boolean SaveRevocPenality(int disciplineProblemId, String commentes, String courtDecision, String commeentsGivenday, String documentRefrance, String savedStaus) {
        try {
            disciplineApproveEntity.saveRevocPenltiy(disciplineProblemId, commentes, courtDecision, commeentsGivenday, documentRefrance, savedStaus);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ChairManCommentes getChairManCommeentes(int disciplineProblemId) {
        try {
            ResultSet _rs = disciplineApproveEntity.getChairManCommentes(disciplineProblemId);
            while (_rs.next()) {
                chairman.setDisciplineProblemId(_rs.getInt("DISCIPLINE_PROBLEM_ID"));
                chairman.setCommentesGiven(_rs.getString("COMMEENTES_GIVEN"));
                chairman.setSuggetedsPenality(_rs.getString("SUGGESTED_PENALITY"));
                chairman.setDeductionAmount(_rs.getDouble("DEDUCTION_AMOUNT"));
                chairman.setCommentesGivenDay(_rs.getString("COMMEENT_GIVEN_DAY"));
                chairman.setDuration(_rs.getString("DURATION"));
            }
            return chairman;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public RejectedPenalityComeentes getRetectPenality(int disciplineProblemId) {
        try {
            ResultSet _rs = disciplineApproveEntity.getRejectPenality(disciplineProblemId);
            while (_rs.next()) {
                rejectPenality.setDisciplineProblemId(_rs.getInt("DISCIPLINE_PRROBLEM_ID"));
                rejectPenality.setCommentesGiven(_rs.getString("APPROVER_COMMEENTES"));
                rejectPenality.setCourtDecision(_rs.getString("COURT_DECISION"));
                rejectPenality.setDocumentReferanceDay(_rs.getString("DOCUMENT_REFERANCE"));
                rejectPenality.setApprovedDate(_rs.getString("APPROVED_DATE"));
            }
            return rejectPenality;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean isRequestApprovableByUser(int requestId) {
        //use user name, logged ibn dept id
        return true;
    }

    public ArrayList<Option> getAvailableDecisionsToMake(int requestId, String processState) {
        ArrayList<Option> decisionLists = getAvailableDecisionsToMake(processState);
        if (!isRequestApprovableByUser(requestId)) {//if it cant approve, remove the approve option
            for (int counter = 0; counter < decisionLists.size(); counter++) {
                if (decisionLists.get(counter).getValue().toString().equalsIgnoreCase(DISCIPLINE_DECISION_APPROVE)) {
                    decisionLists.remove(decisionLists.get(counter));
                    return decisionLists;
                }
            }
        }
        return decisionLists;
    }

    public boolean saveDecision(int requestId, String processedBy, String commnetGiven, String decision, String forwardToCom, String newPenaltyType, String currentState, String agreeOnDefaultPenalty, double deductionAmount, String duration, String suggetedPenality, double suggetedPenalityDeduct, String suggestedPenalityDuration, String approvedPenality, double approvedPenaltyDeduct, String approvedPenalityDuration, String lastApproverCommentes, String prmotionSuspend, String PromotionDuration, String transferSuspend, String transferDuration) {
        String nextState = (decision.contains("$$")) ? currentState : AuthorizationManager.readNextState(currentState, PROCESS_DISCIPLINE, decision);
        String forwardedToCommittee = (decision.contains("$$")) ? "YES" : "NO";
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        disciplineProcessedModel = new DisciplineProcessedModel(requestId, processedBy, commnetGiven, decision, forwardToCom, newPenaltyType, userName, recorededDateAndTime, nextState, agreeOnDefaultPenalty, forwardedToCommittee, deductionAmount, duration, suggetedPenality, suggetedPenalityDeduct, suggestedPenalityDuration, approvedPenality, approvedPenaltyDeduct, approvedPenalityDuration, lastApproverCommentes, prmotionSuspend, PromotionDuration, transferSuspend, transferDuration);

        try {
            disciplineApproveEntity.insertDecisionMadeOnDiscipline(disciplineProcessedModel);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveDecisionBackup(int requestId, String processedBy, String commnetGiven, String decision, String currentStatus) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        String nextStatus;
        if (decision.equals(DISCIPLINE_DECISION_APPROVE)) {
            nextStatus = "Approved";
        } else if (decision.equals(DISCIPLINE_DECISION_RESUBMIT)) {
            nextStatus = "ToBeResubmit";
        } else {
            nextStatus = "Rejected";
        }
        disciplineProcessedModel = new DisciplineProcessedModel(requestId, processedBy, commnetGiven, decision, userName, recorededDateAndTime, nextStatus);
        try {
            disciplineApproveEntity.insertDecisionMadeOnDiscipline(disciplineProcessedModel);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }


    }

    public String getCommeentsGivenDay(int diciplineId) {

        String currentDay = null;

        try {
            ResultSet _rs = disciplineApproveEntity.getcommentesGivenday(diciplineId);
            while (_rs.next()) {
                currentDay = _rs.getString("REPORTED_DATE");
            }

            return currentDay;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getCommeentsForWardDay(int diciplineId) {

        String currentDay = null;

        try {
            ResultSet _rs = disciplineApproveEntity.getForwadToCommiteeday(diciplineId);
            while (_rs.next()) {
                currentDay = _rs.getString("TIME_STAMP");
            }

            return currentDay;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String cheakRejectStatus(int disciplineProblemId) {
        String savedStatus = null;
        try {
            ResultSet _rs = disciplineApproveEntity.cheakPenalityStatus(disciplineProblemId);
            while (_rs.next()) {
                savedStatus = _rs.getString("SAVED_STATUS");
            }
            return savedStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getCommeeteforwardListByApprover() {
        try {
            ArrayList<Option> commeetePendingLists = new ArrayList<Option>();
            ResultSet _rs = disciplineApproveEntity.selectRequestForwardToCommeete();
            while (_rs.next()) {
                // String decidedDate = _rs.getString("TIME_STAMP").substring(0, 10);
                //String decisionMadeId = _rs.getString("DISCIPLINE_PROCESSED_ID") + "--" + _rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("COMMENT_GIVEN") + "--" + _rs.getString("DECISION") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("REQUEST_ID")+ "--" + _rs.getString("OFFENCE_TYPE")+ "--" + _rs.getString("OFFENDER_ID");
                commeetePendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("OFFENCE_TYPE") + "--" + _rs.getString("OFFENDER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("COMMENT_GIVEN") + "--" + _rs.getString("DISCIPLINE_PROCESSED_ID") + "--" + _rs.getString("NEW_PENALTY_PROPOSED") + "--" + _rs.getString("AGREE_ON_DEFAULT_PENALTY") + "--" + _rs.getString("SUGGESTED_DEDUCT") + "--" + _rs.getString("SUGGESTED_DURATION") + "--" + _rs.getString("REPITITION_OF_OFFENCE")+ "--" + _rs.getString("EMPLOYEE_STATUS"), _rs.getString("REQUESTER_ID") + " => " + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();
            return commeetePendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getDecisionMadeByEmployee() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = disciplineApproveEntity.selectDicisionsMadeByEmployee(userName);
            while (_rs.next()) {
                String decidedDate = _rs.getString("TIME_STAMP").substring(0, 10);
                String decisionMadeId = _rs.getString("DISCIPLINE_PROCESSED_ID") + "--" + _rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("COMMENT_GIVEN") + "--" + _rs.getString("DECISION") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("REQUEST_ID") + "--" + _rs.getString("OFFENCE_TYPE") + "--" + _rs.getString("OFFENDER_ID") + "--" + _rs.getString("NEW_PENALTY_PROPOSED") + "--" + _rs.getString("SUGGESTED_DEDUCT") + "--" + _rs.getString("SUGGESTED_DURATION") + "--" + _rs.getString("APPROVED_PENALITY") + "--" + _rs.getString("APPROVED_DEDUCT") + "--" + _rs.getString("APPROVED_DURATION") + "--" + _rs.getString("LAST_COMMENTES") + "--" + _rs.getString("REPITITION_OF_OFFENCE") + "--" + _rs.getString("FORWARDED_TO_COMMITTEE")+ "--" + _rs.getString("EMPLOYEE_STATUS");
                pendingLists.add(new Option(decisionMadeId, decidedDate + " => " + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int getNewPenaltyProposedOnRequest(int requestId) {
        try {
            int newPenalty = -1;
            ResultSet _rs = disciplineApproveEntity.selectLatestDecisionOnRequestee(requestId);
            if (_rs.next()) {
                newPenalty = _rs.getInt("NEW_PENALTY_PROPOSED");
            }
            _rs.close();
            return newPenalty;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }
    }

    public ArrayList<Option> getRequestsToBeProcessed() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
           
            ResultSet _rs = disciplineApproveEntity.selectApprovableRequest(userName);
           
            while (_rs.next()) {
                pendingLists.add(new Option(
                        _rs.getString("DISCIPLINE_PROBLEM_ID") + "--" +
                        _rs.getString("REQUESTER_ID") + "--" +
                        _rs.getString("OFFENCE_TYPE") + "--" +
                        _rs.getString("OFFENDER_ID") + "--" +
                        _rs.getString("STATUS") + "--" +
                        _rs.getString("DESCRIPTION_OF_OFFENCE") + "--" +
                        _rs.getString("REPORTED_DATE") + "--" +
                        _rs.getString("REPORTER_ID") + "--" +
                        _rs.getString("REPORTER_FULLNAME") + "--" +
                        _rs.getString("REPORTER_DEPARTMENT") + "--" +
                        _rs.getString("REPORTER_POSITION") + "--" +
                        _rs.getString("REPITITION_OF_OFFENCE"),
                        _rs.getString("EMPLOYEE_STATUS"),
                        _rs.getString("REQUESTER_ID") + " =>" +
                        _rs.getString("OFFENDER_ID")));



            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<HashMap> getRequestsToBeProcessedHash() {
        ArrayList<HashMap> pendingList = new ArrayList<HashMap>();
        try {
            ResultSet _rs = disciplineApproveEntity.selectApprovableRequest(userName);
             
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("DISCIPLINE_PROBLEM_ID", _rs.getString("DISCIPLINE_PROBLEM_ID"));
                hm.put("REQUESTER_ID", _rs.getString("REQUESTER_ID"));
                hm.put("OFFENCE_TYPE", _rs.getString("OFFENCE_TYPE"));
                hm.put("OFFENDER_ID", _rs.getString("OFFENDER_ID"));
                hm.put("STATUS", _rs.getString("STATUS"));
                hm.put("DESCRIPTION_OF_OFFENCE", _rs.getString("DESCRIPTION_OF_OFFENCE"));
                hm.put("REPORTED_DATE", _rs.getString("REPORTED_DATE"));
                hm.put("REPITITION_OF_OFFENCE", _rs.getString("REPITITION_OF_OFFENCE"));
                hm.put("REPORTER_ID", _rs.getString("REPORTER_ID"));
                hm.put("REPORTER_FULLNAME", _rs.getString("REPORTER_FULLNAME"));
                hm.put("REPORTER_DEPARTMENT", _rs.getString("REPORTER_DEPARTMENT"));
                hm.put("REPORTER_POSITION", _rs.getString("REPORTER_POSITION"));
                hm.put("EMPLOYEE_STATUS", _rs.getString("EMPLOYEE_STATUS"));
                pendingList.add(hm);
            }
            return pendingList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

      public boolean saveFile(CommitteeMinuteFileUpLoad fileUpLoad) {
        try {
            disciplineApproveEntity.insertFile(fileUpLoad);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }



    /**
     * @deprecated
     * used as decision.split("$")[0] failed.
     * not solved yet
     */
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

    public boolean NewSaveCommitteeComeentes(String memberEmployeeId, String memberFullName, String memberResponsiblity, String memberComentes, int diciplineProblemId, String memberUserName, String memberPassWord, String status, String savedStatus, String commentsGivenDay, String suggestedPenality) {

        try {
            if (disciplineApproveEntity.NewSaveCommitteeComenets(memberEmployeeId, memberFullName, memberResponsiblity, memberComentes, diciplineProblemId, memberUserName, memberPassWord, status, savedStatus, commentsGivenDay, suggestedPenality)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplineApproveManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getForwardedToCommittee(int requestId, String status) {
        int committeeId = -1;
        try {
            ResultSet _rs = disciplineApproveEntity.selectForwardedToCommittee(requestId, status);
            if (_rs.next()) {

                //committeeId = Integer.parseInt(_rs.getString("DECISION").split("$$")[0]);

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

    public ArrayList<CommeeteeCommentsGiven> getCommiteeComentes(int diciplineId) {
        try {
            ResultSet _rs = disciplineApproveEntity.selectCommeetessComments(diciplineId);
            ArrayList<CommeeteeCommentsGiven> commeetesCommeentes = new ArrayList<CommeeteeCommentsGiven>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String employeeID = _rs.getString("EMPLOYEE_ID");
                String membersFullName = _rs.getString("EMPLOYEE_NAME");
                String responsiblity = _rs.getString("RESPONSIBLITY");
                String commeentesGiven = _rs.getString("COMMEENTES_GIVEN");
                String commentesGivenDay = _rs.getString("COMMEENTS_GIVEN_DAY");
                String suggestedPenality = _rs.getString("SUGGESTED_PENALTY");
                commeetesCommeentes.add(new CommeeteeCommentsGiven(employeeID, membersFullName, responsiblity, commeentesGiven, counter, commentesGivenDay, suggestedPenality));
            }

            return commeetesCommeentes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }



    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public CommitteeMinuteFileUpLoad setValues(int disciplineProblemId) {
        CommitteeMinuteFileUpLoad fileUpLoad = new CommitteeMinuteFileUpLoad();
        try {
            ResultSet _rs = disciplineApproveEntity.selectDocumentAttrbutie(disciplineProblemId);
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      public byte[] singleSelect(int documentId) {
        try {
            byte[] bytePicture = null;
             OracleSerialBlob blo = disciplineApproveEntity.select_Document(documentId);
//            ResultSet rs = accusedDefenceEntity.selectDocument(documentId);

           // if (rs.next()) {
                bytePicture = blo.getBytes(0, (int) blo.length());

                      //  rs.getBlob("ATTACHED_FILE").getBytes(1, (int) rs.getBlob("ATTACHED_FILE").length());
                return bytePicture;
            //}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {

        try {
            ResultSet _rs = disciplineApproveEntity.selectProcessedDisciplineRequest(requestId);
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
                String commentGiven = _rs.getString("LAST_COMMENTES") == null ? "" : _rs.getString("LAST_COMMENTES");
                String givenDecision = _rs.getString("DECISION");
                double deductionAmount = Double.parseDouble(_rs.getString("DEDUCTION_AMOUNT"));
                String duration = _rs.getString("DURATION");
                String suggetedPenality = _rs.getString("NEW_PENALTY_PROPOSED");
                String approvedPenality = _rs.getString("APPROVED_PENALITY");
                String suggtedsDuration = _rs.getString("SUGGESTED_DURATION");
                String approvedDuraration = _rs.getString("APPROVED_DURATION");
                String lastCommeentes = _rs.getString("LAST_COMMENTES");
                String promotionSuspend = _rs.getString("SUSPENDED_FROM_PROM");
                String transferSuspend = _rs.getString("SUSPENDED_FROM_TRAN");
                String promotionDuration = _rs.getString("PROMOTION_DURATION");
                String transferDuration = _rs.getString("TRANSFER_DURATION");
                double suggestedDeduction = Double.parseDouble(_rs.getString("SUGGESTED_DEDUCT"));
                double approvedDeduction = Double.parseDouble(_rs.getString("APPROVED_DEDUCT"));

                requestHistoryList.add(new RequestHistoryModel(counter, deciderEmployeeId, deciderFullName, givenDecision, timeStamp, commentGiven, deductionAmount, duration, suggetedPenality, approvedPenality, suggtedsDuration, approvedDuraration, lastCommeentes, suggestedDeduction, approvedDeduction, promotionSuspend, transferSuspend, promotionDuration, transferDuration));
            }
            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

     public boolean saveDecisionOnRequestPage(int disciplineProblemId, String loggedInEmployeeId, String currentState, String lastApproverCommentes, String decision, String userName, String currentDateAndTime, String agreeOnDefaultPenalty, String forwareToCommeete, String newPenalty, double deductionAmount, String deductionDuration, double suggestedPenalityDeduct, String suggestedPenalityDuration, String approvedPenality, double approvedPenltyDeduct, String approvedPenltyDuration, String lastApproverCommentes0, String suggetedFromPromotion, String suggetedFromTransfer, String promotionDuration, String transferDuration) {

         String nextState = (decision.contains("$$")) ? currentState : AuthorizationManager.readNextState(currentState, PROCESS_DISCIPLINE, decision);

         disciplineProcessedModelRequestApprove = new DisciplineProcessedModel(disciplineProblemId, loggedInEmployeeId, lastApproverCommentes, decision, userName,currentDateAndTime,agreeOnDefaultPenalty, forwareToCommeete, newPenalty, deductionAmount, deductionDuration, suggestedPenalityDeduct, suggestedPenalityDuration, approvedPenality, approvedPenltyDeduct, approvedPenltyDuration, lastApproverCommentes, suggetedFromPromotion,suggetedFromTransfer, promotionDuration,transferDuration);

         try {
            disciplineApproveEntity.insertDecisionMadeOnDisciplineFromRequest(disciplineProcessedModelRequestApprove);
        
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
         return true;
    }
     ///////////////////////////////////////////////////FileAttachement/////////////////////////////////////////////////////////////////////

      public static byte[] extractByteArray(File file) {
        FileInputStream fileInputStream = null;
        byte[] byteFile = null;
        try {
            int len = 0;
            fileInputStream = new FileInputStream(file);
            InputStream inputStream = fileInputStream;
            len = inputStream.available();
            byteFile = new byte[len];
            inputStream.read(byteFile, 0, len);
        } catch (Exception ex) {
//Logger.getLogger(EimsUtility.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
//Logger.getLogger(EimsUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return byteFile;
    }



     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//    public ArrayList<Option> getDecisionHistory(int requestId) {
//        try {
//            ArrayList<Option> pendingLists = new ArrayList<Option>();
//            ResultSet _rs = disciplineRequestEntity.selectRequestsByStatus("Pending", userName);
//            while (_rs.next()) {
//                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID"), _rs.getString("REQUESTER_ID") + " => " + _rs.getString("OFFENDER_ID")));
//            }
//            _rs.close();
//            return pendingLists;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public DisciplineApproveEntity getDisciplineApproveEntity() {
        return disciplineApproveEntity;
    }

    public void setDisciplineApproveEntity(DisciplineApproveEntity disciplineApproveEntity) {
        this.disciplineApproveEntity = disciplineApproveEntity;
    }

    public DisciplineProcessedModel getDisciplineProcessedModel() {
        return disciplineProcessedModel;
    }

    public void setDisciplineProcessedModel(DisciplineProcessedModel disciplineProcessedModel) {
        this.disciplineProcessedModel = disciplineProcessedModel;
    }

    public DisciplineRequestEntity getDisciplineRequestEntity() {
        return disciplineRequestEntity;
    }

    public void setDisciplineRequestEntity(DisciplineRequestEntity disciplineRequestEntity) {
        this.disciplineRequestEntity = disciplineRequestEntity;
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

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="DisciplineCommitteeDecisionModel">
    public static class DisciplineCommitteeDecisionModel {

        int committeeDecisionId;
        int displineProblemId;//DISCIPLINE_PROCESSED_ID
        int committeeId;
        String employeeId;
        String fullName;
        String userName;
        String password;
        String decision;
        String status;
        String commnetGiven;//COMMENT_GIVEN
        String processedBy;//PROCESSED_BY
        String recordedBy;//RECORDED_BY
        String timeStamp;//TIME_STAMP

        public DisciplineCommitteeDecisionModel() {
        }

        public DisciplineCommitteeDecisionModel(int displineProblemId, int committeeId, String employeeId, String fullName, String userName, String password, String decision) {
            this.displineProblemId = displineProblemId;
            this.committeeId = committeeId;
            this.employeeId = employeeId;
            this.fullName = fullName;
            this.userName = userName;
            this.password = password;
            this.decision = decision;
        }

        public DisciplineCommitteeDecisionModel(int committeeDecisionId, int displineProblemId, int committeeId, String employeeId, String fullName, String userName, String password, String decision) {
            this(displineProblemId, committeeId, employeeId, fullName, userName, password, decision);
            this.committeeDecisionId = committeeDecisionId;
        }

        public int getCommitteeDecisionId() {
            return committeeDecisionId;
        }

        public void setCommitteeDecisionId(int committeeDecisionId) {
            this.committeeDecisionId = committeeDecisionId;
        }

        public int getCommitteeId() {
            return committeeId;
        }

        public void setCommitteeId(int committeeId) {
            this.committeeId = committeeId;
        }

        public String getCommnetGiven() {
            return commnetGiven;
        }

        public void setCommnetGiven(String commnetGiven) {
            this.commnetGiven = commnetGiven;
        }

        public String getDecision() {
            return decision;
        }

        public void setDecision(String decision) {
            this.decision = decision;
        }

        public int getDisplineProblemId() {
            return displineProblemId;
        }

        public void setDisplineProblemId(int displineProblemId) {
            this.displineProblemId = displineProblemId;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="DisciplineProcessedModel">

    public static class DisciplineProcessedModel {

        int displinePrcessedId;//DISCIPLINE_PROCESSED_ID
        int requestId;//REQUEST_ID
        String processedBy;//PROCESSED_BY
        String commnetGiven;//COMMENT_GIVEN
        String approverCommentsForFier;//this is the comments that the approver give for the fier approver condition
        String decision;//DECISION
        String recordedBy;//RECORDED_BY
        String timeStamp;//TIME_STAMP
        String status;//
        String agreeOnDefaultPenalty;
        String forwardedToCommittee;
        String newPenaltyType;
        double deductionAmout;
        String duration;
        String suggestedPenality;
        String suggestedPenalityDuration;
        String approvedPenality;
        String approvedPenalityDuration;
        String lastApproverCommentes;
        String promotionSuspend;
        String promotionDuration;
        String transferSuspend;
        String transferDuration;
        String forWared;
        double suggestedPenaltyDeduction;
        double approvedPenalityDeduction;

        public DisciplineProcessedModel() {
        }

        public DisciplineProcessedModel(int requestId, String processedBy, String commnetGiven, String decision, String recordedBy, String timeStamp, String status) {
            this.requestId = requestId;
            this.processedBy = processedBy;
            this.commnetGiven = commnetGiven;
            this.decision = decision;
            this.recordedBy = recordedBy;
            this.timeStamp = timeStamp;
            this.status = status;
        }

        public DisciplineProcessedModel(int requestId, String processedBy, String commnetGiven, String decision, String recordedBy, String timeStamp, String status, String agreeOnDefaultPenalty) {
            this(requestId, processedBy, commnetGiven, decision, recordedBy, timeStamp, status);
            this.agreeOnDefaultPenalty = agreeOnDefaultPenalty;
        }

        public DisciplineProcessedModel(int requestId, String processedBy, String commnetGiven, String decision, String recordedBy, String timeStamp, String status, String agreeOnDefaultPenalty, String forwardedToCommittee) {
            this(requestId, processedBy, commnetGiven, decision, recordedBy, timeStamp, status);
            this.agreeOnDefaultPenalty = agreeOnDefaultPenalty;
            this.forwardedToCommittee = forwardedToCommittee;
        }

        public DisciplineProcessedModel(int requestId, String processedBy, String commnetGiven, String decision, String forwared, String newPenaltyType, String recordedBy, String timeStamp, String status, String agreeOnDefaultPenalty, String forwardedToCommittee, double deductionAmount, String duration, String suggetedPenality, double suggetedPenalityDeduct, String suggestedPenalityDuration, String approvedPenality, double approvedPenaltyDeduct, String approvedPenalityDuration, String lastApproverCommentes, String promotionSuspend, String promotionDuration, String transferSusupend, String transferDuration) {
            this(requestId, processedBy, commnetGiven, decision, recordedBy, timeStamp, status);
            this.commnetGiven = commnetGiven;
            this.agreeOnDefaultPenalty = agreeOnDefaultPenalty;
            this.forwardedToCommittee = forwardedToCommittee;
            this.newPenaltyType = newPenaltyType;
            this.deductionAmout = deductionAmount;
            this.duration = duration;
            this.suggestedPenality = suggetedPenality;
            this.suggestedPenalityDuration = suggestedPenalityDuration;
            this.suggestedPenaltyDeduction = suggetedPenalityDeduct;
            this.approvedPenality = approvedPenality;
            this.approvedPenalityDeduction = approvedPenaltyDeduct;
            this.approvedPenalityDuration = approvedPenalityDuration;
            this.lastApproverCommentes = lastApproverCommentes;
            this.promotionSuspend = promotionSuspend;
            this.promotionDuration = promotionDuration;
            this.transferSuspend = transferSusupend;
            this.transferDuration = transferDuration;
            this.forWared = forwared;
        //this.approverCommentsForFier=approverCommentesForFier;

        }
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

         private DisciplineProcessedModel(int disciplineProblemId, String loggedInEmployeeId, String ApproverCommentes, String decision, String userName, String currentDateAndTime, String agreeOnDefaultPenalty, String forwareToCommeete, String newPenalty, double deductionAmount, String deductionDuration, double suggestedPenalityDeduct, String suggestedPenalityDuration, String approvedPenality, double approvedPenltyDeduct, String approvedPenltyDuration, String lastApproverCommentes, String suggetedFromPromotion, String suggetedFromTransfer, String promotionDuration, String transferDuration) {
            this.requestId=disciplineProblemId;
            this.processedBy=loggedInEmployeeId;
            this.commnetGiven=ApproverCommentes;
            this.status=decision;
            this.recordedBy=userName;
            this.timeStamp=currentDateAndTime;
            this.agreeOnDefaultPenalty=agreeOnDefaultPenalty;
            this.forwardedToCommittee=forwareToCommeete;
            this.newPenaltyType=newPenalty;
            this.deductionAmout=deductionAmount;
            this.duration=deductionDuration;
            this.suggestedPenaltyDeduction=suggestedPenalityDeduct;
            this.suggestedPenalityDuration=suggestedPenalityDuration;
            this.approvedPenality=approvedPenality;
            this.approvedPenalityDeduction=approvedPenltyDeduct;
            this.approvedPenalityDuration=approvedPenltyDuration;
            this.lastApproverCommentes=lastApproverCommentes;
            this.promotionSuspend=suggetedFromPromotion;
            this.transferSuspend=suggetedFromTransfer;
             this.promotionDuration = promotionDuration;
             this.transferDuration=transferDuration;

        }






        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


        public DisciplineProcessedModel(
                int displinePrcessedId,
                int requestId,
                String processedBy,
                String commnetGiven,
                String decision, String recordedBy, String timeStamp, String status) {
            this(requestId, processedBy, commnetGiven, decision, recordedBy, timeStamp, status);
            this.displinePrcessedId = displinePrcessedId;
        }



        public String getForWared() {
            return forWared;
        }

        public void setForWared(String forWared) {
            this.forWared = forWared;
        }

        public String getApproverCommentsForFier() {
            return approverCommentsForFier;
        }

        public void setApproverCommentsForFier(String approverCommentsForFier) {
            this.approverCommentsForFier = approverCommentsForFier;
        }

        public String getPromotionDuration() {
            return promotionDuration;
        }

        public void setPromotionDuration(String promotionDuration) {
            this.promotionDuration = promotionDuration;
        }

        public String getPromotionSuspend() {
            return promotionSuspend;
        }

        public void setPromotionSuspend(String promotionSuspend) {
            this.promotionSuspend = promotionSuspend;
        }

        public String getTransferDuration() {
            return transferDuration;
        }

        public void setTransferDuration(String transferDuration) {
            this.transferDuration = transferDuration;
        }

        public String getTransferSuspend() {
            return transferSuspend;
        }

        public void setTransferSuspend(String transferSuspend) {
            this.transferSuspend = transferSuspend;
        }

        public String getLastApproverCommentes() {
            return lastApproverCommentes;
        }

        public void setLastApproverCommentes(String lastApproverCommentes) {
            this.lastApproverCommentes = lastApproverCommentes;
        }

        public String getApprovedPenalityDuration() {
            return approvedPenalityDuration;
        }

        public void setApprovedPenalityDuration(String approvedPenalityDuration) {
            this.approvedPenalityDuration = approvedPenalityDuration;
        }

        public String getApprovedPenality() {
            return approvedPenality;
        }

        public void setApprovedPenality(String approvedPenality) {
            this.approvedPenality = approvedPenality;
        }

        public double getApprovedPenalityDeduction() {
            return approvedPenalityDeduction;
        }

        public void setApprovedPenalityDeduction(double approvedPenalityDeduction) {
            this.approvedPenalityDeduction = approvedPenalityDeduction;
        }

        public String getSuggestedPenality() {
            return suggestedPenality;
        }

        public void setSuggestedPenality(String suggestedPenality) {
            this.suggestedPenality = suggestedPenality;
        }

        public String getSuggestedPenalityDuration() {
            return suggestedPenalityDuration;
        }

        public void setSuggestedPenalityDuration(String suggestedPenalityDuration) {
            this.suggestedPenalityDuration = suggestedPenalityDuration;
        }

        public double getSuggestedPenaltyDeduction() {
            return suggestedPenaltyDeduction;
        }

        public void setSuggestedPenaltyDeduction(double suggestedPenaltyDeduction) {
            this.suggestedPenaltyDeduction = suggestedPenaltyDeduction;
        }

        public double getDeductionAmout() {
            return deductionAmout;
        }

        public void setDeductionAmout(double deductionAmout) {
            this.deductionAmout = deductionAmout;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getForwardedToCommittee() {
            return forwardedToCommittee;
        }

        public void setForwardedToCommittee(String forwardedToCommittee) {
            this.forwardedToCommittee = forwardedToCommittee;
        }

        public String getCommnetGiven() {
            return commnetGiven;
        }

        public void setCommnetGiven(String commnetGiven) {
            this.commnetGiven = commnetGiven;
        }

        public String getDecision() {
            return decision;
        }

        public String getNewPenaltyType() {
            return newPenaltyType;
        }

        public void setNewPenaltyType(String newPenaltyType) {
            this.newPenaltyType = newPenaltyType;
        }

        public String getAgreeOnDefaultPenalty() {
            return agreeOnDefaultPenalty;
        }

        public void setAgreeOnDefaultPenalty(String agreeOnDefaultPenalty) {
            this.agreeOnDefaultPenalty = agreeOnDefaultPenalty;
        }

        public void setDecision(String decision) {
            this.decision = decision;
        }

        public int getDisplinePrcessedId() {
            return displinePrcessedId;
        }

        public void setDisplinePrcessedId(int displinePrcessedId) {
            this.displinePrcessedId = displinePrcessedId;
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

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }
    }

    public String getDescription_of_offence() {
        return description_of_offence;
    }

    public void setDescription_of_offence(String description_of_offence) {
        this.description_of_offence = description_of_offence;
    }

    public String getDiscipline_problem_id() {
        return discipline_problem_id;
    }

    public void setDiscipline_problem_id(String discipline_problem_id) {
        this.discipline_problem_id = discipline_problem_id;
    }

    public String getOffence_type() {
        return offence_type;
    }

    public void setOffence_type(String offence_type) {
        this.offence_type = offence_type;
    }

    public String getOffender_id() {
        return offender_id;
    }

    public void setOffender_id(String offender_id) {
        this.offender_id = offender_id;
    }

    public String getRepitition_of_offence() {
        return repitition_of_offence;
    }

    public void setRepitition_of_offence(String repitition_of_offence) {
        this.repitition_of_offence = repitition_of_offence;
    }

    public String getReported_date() {
        return reported_date;
    }

    public void setReported_date(String reported_date) {
        this.reported_date = reported_date;
    }

    public String getRequester_id() {
        return requester_id;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void setRequester_id(String requester_id) {
        this.requester_id = requester_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSupportInfo() {
        return supportInfo;
    }

    public void setSupportInfo(boolean supportInfo) {
        this.supportInfo = supportInfo;
    }

    //</editor-fold>
       public static class CommitteeMinuteFileUpLoad {

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

        public CommitteeMinuteFileUpLoad() {
        }


    }
}
