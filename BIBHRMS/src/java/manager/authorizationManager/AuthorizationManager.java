/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.authorizationManager;

import com.sun.webui.jsf.model.Option;
import entity.authorizationEntity.AuthorizationEntity;
import entity.authorizationEntity.ProcessStateEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author mekete
 */
public class AuthorizationManager {

    AuthorizationEntity authorizationEntity = new AuthorizationEntity();
    ProcessStateEntity processStateEntity = new ProcessStateEntity();
    public static final String PROCESS_LEAVE = "1";
    public static final String PROCESS_ATTENDANCE = "2";
    public static final String PROCESS_DOCUMENTREQUEST = "3";
    public static final String PROCESS_OVERTIME = "4";
    public static final String PROCESS_POWERDELIGATION = "5";
    public static final String PROCESS_RECRUITMENT = "6";
    public static final String PROCESS_SALARYDELIGATION = "7";
    public static final String PROCESS_TERMINATION = "8";
    //  public static final String PROCESS_TRAINING = "9";
    public static final String PROCESS_TRANSFER = "10";
    public static final String PROCESS_OTHER_POWERDELIGATION = "25";
    public static final String PROCESS_DISCIPLINE = "11";
    public static final String PROCESS_TRAINING_NEED_ASSESSEMENT = "21";
    public static final String PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT = "12";
    public static final String PROCESS_EDUCATION = "13";
    public static final String PROCESS_EDUCATION_PAYMENT = "71";
    public static final String PROCESS_EDUCATION_ASSISTANCE = "72";
    public static final String PROCESS_UNPLANNED_TRAINING = "14";
    public static final String PROCESS_LEAVE_TRANSFER = "15";
    public static final String PROCESS_CHANGEINSTITUTION = "70";
    public static final String PROCESS_EDUCATION_POST_PAYMENT = "73";
    public static final String REQUEST_RETURN_FROM_LEAVE = "16";
    public static final String REQUEST_RETURN_FROM_LEAVE_PAYMENT = "17";
    public static final String PROCESS_SUBSIDY = "55";
    public static final String REQUEST_TRANSPORT_PAYMENT = "99";
    public static final String PROCESS_MILK_SUBSIDY = "56";

    public static ArrayList<SelectItem> readProcessTypes() {
        ArrayList<SelectItem> processLists = new ArrayList<SelectItem>();
        processLists.add(new SelectItem("-1", "--SELECT PROCESS--"));
        processLists.add(new SelectItem(PROCESS_ATTENDANCE, "ATTENDANCE"));
        processLists.add(new SelectItem(PROCESS_LEAVE, "LEAVE"));
        processLists.add(new SelectItem(PROCESS_DOCUMENTREQUEST, "DOCUMENT REQUEST"));
        processLists.add(new SelectItem(PROCESS_OVERTIME, "OVERTIME"));
         processLists.add(new SelectItem(PROCESS_DISCIPLINE, "DISCIPLINE"));
        processLists.add(new SelectItem(PROCESS_POWERDELIGATION, "POWER DELIGATION"));
        processLists.add(new SelectItem(PROCESS_SALARYDELIGATION, "SALARY DELIGATION"));
        processLists.add(new SelectItem(PROCESS_TERMINATION, "TERMINATION"));
        processLists.add(new SelectItem(PROCESS_EDUCATION, "EDUCATION"));
        processLists.add(new SelectItem(PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT, "TRAINING NEED ASSESEMENT"));
        processLists.add(new SelectItem(PROCESS_EDUCATION_ASSISTANCE, "EDUCATION ASSISTANCE"));
        processLists.add(new SelectItem(PROCESS_UNPLANNED_TRAINING, "UNPLANNED TRAINING"));
        processLists.add(new SelectItem(PROCESS_EDUCATION_PAYMENT, "EDUCATION PAYMENT"));
        processLists.add(new SelectItem(PROCESS_LEAVE_TRANSFER, "PROCESS LEAVE TRANSFER"));
        processLists.add(new SelectItem(PROCESS_CHANGEINSTITUTION, "CHANGE INSTITUTION"));
        processLists.add(new SelectItem(PROCESS_EDUCATION_POST_PAYMENT, "EDUCATION POST PAYMENT"));
        processLists.add(new SelectItem(REQUEST_RETURN_FROM_LEAVE, "REQUEST EMPLOYEE FROM ANNUAL LEAVE"));
        processLists.add(new SelectItem(REQUEST_RETURN_FROM_LEAVE_PAYMENT, "REQUEST LEAVE PAYMENT"));
        processLists.add(new SelectItem(PROCESS_SUBSIDY, "REQUEST SUBSIDY"));
        processLists.add(new SelectItem(REQUEST_TRANSPORT_PAYMENT, "REQUEST TRANSPORT PAYMENT"));
        processLists.add(new SelectItem(PROCESS_MILK_SUBSIDY, "REQUEST MILK AND SUBSIDY"));
        processLists.add(new SelectItem(PROCESS_RECRUITMENT, "RECRUITMENT WORKFLOW"));



        return processLists;
    }

    public static ArrayList<Option> getProcessTypes() {
        ArrayList<Option> processLists = new ArrayList<Option>();
        processLists.add(new Option("-1", "--SELECT PROCESS--"));
        processLists.add(new Option(PROCESS_ATTENDANCE, "ATTENDANCE"));
        processLists.add(new Option(PROCESS_LEAVE, "LEAVE"));
        processLists.add(new Option(PROCESS_DOCUMENTREQUEST, "DOCUMENT REQUEST"));
        processLists.add(new Option(PROCESS_OVERTIME, "OVERTIME"));
        processLists.add(new Option(PROCESS_DISCIPLINE, "DISCIPLINE"));
        processLists.add(new Option(PROCESS_POWERDELIGATION, "POWER DELIGATION"));
        processLists.add(new Option(PROCESS_SALARYDELIGATION, "SALARY DELIGATION"));
        processLists.add(new Option(PROCESS_TERMINATION, "TERMINATION"));
        processLists.add(new Option(PROCESS_EDUCATION, "EDUCATION"));
        processLists.add(new Option(PROCESS_TRAINING_AND_EDUCATION_NEED_ASSESEMENT, "TRAINING NEED ASSESEMENT"));
        processLists.add(new Option(PROCESS_EDUCATION_ASSISTANCE, "EDUCATION ASSISTANCE"));
        processLists.add(new Option(PROCESS_UNPLANNED_TRAINING, "UNPLANNED TRAINING"));
        processLists.add(new Option(PROCESS_EDUCATION_PAYMENT, "EDUCATION PAYMENT"));
        processLists.add(new Option(PROCESS_LEAVE_TRANSFER, "PROCESS LEAVE TRANSFER"));
        processLists.add(new Option(PROCESS_CHANGEINSTITUTION, "CHANGE INSTITUTION"));
        processLists.add(new Option(PROCESS_EDUCATION_POST_PAYMENT, "EDUCATION POST PAYMENT"));
        processLists.add(new Option(REQUEST_RETURN_FROM_LEAVE, "REQUEST EMPLOYEE FROM ANNUAL LEAVE"));
        processLists.add(new Option(REQUEST_RETURN_FROM_LEAVE_PAYMENT, "REQUEST LEAVE PAYMENT"));
        processLists.add(new Option(PROCESS_SUBSIDY, "REQUEST SUBSIDY"));
        processLists.add(new Option(REQUEST_TRANSPORT_PAYMENT, "REQUEST TRANSPORT PAYMENT"));
        processLists.add(new Option(PROCESS_MILK_SUBSIDY, "REQUEST MILK AND SUBSIDY"));
        processLists.add(new Option(PROCESS_RECRUITMENT, "RECRUITMENT WORKFLOW"));
        processLists.add(0, new Option(-1, " SELECT PROCESS "));
        return processLists;
    }

    public static ArrayList<Option> getProcessStates(String processId) {
        ArrayList<Option> processLists = new ArrayList<Option>();
        try {
            AuthorizationEntity authorizationEntity = new AuthorizationEntity();
            ResultSet _rs = authorizationEntity.selectProcessStates(processId);
            while (_rs.next()) {
                processLists.add(new Option(_rs.getString("process_state_id"), _rs.getString("state_name")));
            }
            if (processLists.size() > 0) {
                processLists.add(0, new Option(-1, "--SELECT STATE--"));
            } else {
                processLists.add(0, new Option(-1, "NO STATE AVAILABLE"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return processLists;
    }

    public static String getProcessStates(String decisions, String processId) {
        String[] decision = decisions.split("--");
        String processStates = "";
        try {
            AuthorizationEntity authorizationEntity = new AuthorizationEntity();
            ResultSet _rs = authorizationEntity.selectProcessStates(processId);
            while (_rs.next()) {
                for (int count = 0; count < decision.length; count++) {
                    String prefix = decision[count].contains("Onp") ? "" : decision[count] + "-";
                    processStates += "'" + prefix + _rs.getString("process_state_id") + "', ";
                }
            }
            processStates += "'EndNotUseful'";//to identify the last comma
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return processStates;
    }

    public static String readNextState(String currentState, String processId, String decision) {
        String nextState = "";//getNextState(currentStatus, decision);
        if (decision.equals(SiteSecurityManager.Permission_Resubmit)) {
            nextState = "Res-" + currentState;
        } else if (decision.equals(SiteSecurityManager.Permission_Reject)) {
            nextState = "Rej-" + currentState;
        } else if (decision.equals(SiteSecurityManager.Permission_Approve)) {
            nextState = "App-" + currentState;
        } else if (decision.equals(SiteSecurityManager.Permission_Forward)) {
            nextState = (String) (new AuthorizationEntity()).readNextState(currentState, processId);
        }
        return nextState;
    }

    public static String readInitialState(String processId) {
        String myReturn = new String();
        myReturn = (String) (new AuthorizationEntity()).readInitialState(processId);
        return myReturn;
    }

    public boolean saveState(String processId, String processStateName, String processStateDescription, boolean cabBeFinal) {
        return processStateEntity.saveState(processId, processStateName, Boolean.toString(cabBeFinal));
    }

    public boolean saveAuthorizations(ArrayList<AuthorizationModel> authorizations) {
        if (authorizationEntity.deleteAuthorizations(authorizations)) {
            return authorizationEntity.saveAuthorizations(authorizations);
        }
        return false;

    }

    /**     public AuthorizationModel(int counter, String processId, String stateId, String roleid, String processName, String satateName, String roleName) {
    this.counter = counter;
    this.processId = processId;
    this.stateId = stateId;
    this.roleid = roleid;
    this.processName = processName;
    this.satateName = satateName;
    this.roleName = roleName;
    }*/
    public ArrayList<AuthorizationModel> getAuthorizedStates(String processId) {
        ArrayList<AuthorizationModel> authorizedStates = new ArrayList<AuthorizationModel>();
        try {
            ResultSet _rs = authorizationEntity.selectAuthorizedStates(processId);
            int sequenceNumber = -1;
            while (_rs.next()) {
                if (sequenceNumber != _rs.getInt("SEQUENCE_NUMBER")) {
                    sequenceNumber = _rs.getInt("SEQUENCE_NUMBER");
                    AuthorizationModel authorizationModel = new AuthorizationModel(
                            sequenceNumber,
                            _rs.getString("PROCESS_ID"),
                            _rs.getString("PROCESS_STATE_ID"),
                            _rs.getString("ROLE_NAME"),
                            _rs.getString("PROCESS_NAME"),
                            _rs.getString("STATE_NAME"),
                            _rs.getString("ROLE_NAME"));


//                    authorizationModel.setProcessId(_rs.getString("PROCESS_ID"));
//                    authorizationModel.setRoleName(_rs.getString("ROLE_NAME"));
//                    authorizationModel.setSatateName(_rs.getString("STATE_NAME"));
//                    authorizationModel.setProcessName(_rs.getString("PROCESS_NAME"));
//                    authorizationModel.setRoleName(_rs.getString("ROLE_NAME"));
                    authorizedStates.add(authorizationModel);
                }
            }
            _rs.close();
            return authorizedStates;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String readFinalState(String processId) {
        String myReturn = new String();
        myReturn = (String) (new AuthorizationEntity()).readFinalState(processId);
        return myReturn;
    }

    public static class AuthorizationModel {

        int counter;
        String processId;
        String stateId;
        String roleid;
        String authorizationId;
        String processName;
        String satateName;
        String roleName;

        public AuthorizationModel() {
        }

        public AuthorizationModel(int counter, String processId, String stateId, String roleid, String processName, String satateName, String roleName) {
            this.counter = counter;
            this.processId = processId;
            this.stateId = stateId;
            this.roleid = roleid;
            this.processName = processName;
            this.satateName = satateName;
            this.roleName = roleName;
        }

        public AuthorizationModel(int counter, String processId, String stateId, String roleid, String authorizationId, String processName, String satateName, String roleName) {
            this(counter, processId, stateId, roleid, processName, satateName, roleName);
            this.authorizationId = authorizationId;
        }

        public String getAuthorizationId() {
            return authorizationId;
        }

        public void setAuthorizationId(String authorizationId) {
            this.authorizationId = authorizationId;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public String getProcessId() {
            return processId;
        }

        public void setProcessId(String processId) {
            this.processId = processId;
        }

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleid() {
            return roleid;
        }

        public void setRoleid(String roleid) {
            this.roleid = roleid;
        }

        public String getSatateName() {
            return satateName;
        }

        public void setSatateName(String satateName) {
            this.satateName = satateName;
        }

        public String getStateId() {
            return stateId;
        }

        public void setStateId(String stateId) {
            this.stateId = stateId;
        }
    }

    public ArrayList<RequestHistoryModel> getRequestHistory(String tableName, int requestId) {
        try {
            ResultSet _rs = authorizationEntity.selectProcessedHistoryOfRequest(tableName, requestId);

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

    public static class CommeeteeCommentsGiven implements Serializable {

        String committeeMembersFullName;
        String employeeId;
        String responsiblity;
        String commeentesGiven;
        String commentesGivenDay;
        String suggestedPenality;
        int disciplineProblemId;
        int counter;
        String savedStatus;

        public CommeeteeCommentsGiven() {
        }

        public CommeeteeCommentsGiven(String employeeID, String membersFullName, String responsiblity, String commeentesGiven, int counter) {
            this.employeeId = employeeID;
            this.committeeMembersFullName = membersFullName;
            this.responsiblity = responsiblity;
            this.commeentesGiven = commeentesGiven;
            this.counter = counter;
        }
 public CommeeteeCommentsGiven(String employeeID, String membersFullName, String responsiblity, String commeentesGiven, int counter,String savedStatus) {
            this.employeeId = employeeID;
            this.committeeMembersFullName = membersFullName;
            this.responsiblity = responsiblity;
            this.commeentesGiven = commeentesGiven;
            this.counter = counter;
            this.savedStatus=savedStatus;
        }
        public CommeeteeCommentsGiven(String employeeID, String membersFullName, String responsiblity, String commeentesGiven, int counter, String commentsGivenDay, String suggetesdPenality) {
            this.employeeId = employeeID;
            this.committeeMembersFullName = membersFullName;
            this.responsiblity = responsiblity;
            this.commeentesGiven = commeentesGiven;
            this.counter = counter;
            this.commentesGivenDay = commentsGivenDay;
            this.suggestedPenality = suggetesdPenality;

        }

        public CommeeteeCommentsGiven(String committeeMembersFullName, String employeeId, String responsiblity, String commeentesGiven, int disciplineProblemId, int counter) {
            this.committeeMembersFullName = committeeMembersFullName;
            this.employeeId = employeeId;
            this.responsiblity = responsiblity;
            this.commeentesGiven = commeentesGiven;
            this.disciplineProblemId = disciplineProblemId;
            this.counter = counter;
        }

        public String getSuggestedPenality() {
            return suggestedPenality;
        }

        public void setSuggestedPenality(String suggestedPenality) {
            this.suggestedPenality = suggestedPenality;
        }

        public String getCommentesGivenDay() {
            return commentesGivenDay;
        }

        public String getSavedStatus() {
            return savedStatus;
        }

        public void setSavedStatus(String savedStatus) {
            this.savedStatus = savedStatus;
        }

        public void setCommentesGivenDay(String commentesGivenDay) {
            this.commentesGivenDay = commentesGivenDay;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public String getCommeentesGiven() {
            return commeentesGiven;
        }

        public void setCommeentesGiven(String commeentesGiven) {
            this.commeentesGiven = commeentesGiven;
        }

        public String getCommitteeMembersFullName() {
            return committeeMembersFullName;
        }

        public void setCommitteeMembersFullName(String committeeMembersFullName) {
            this.committeeMembersFullName = committeeMembersFullName;
        }

        public int getDisciplineProblemId() {
            return disciplineProblemId;
        }

        public void setDisciplineProblemId(int disciplineProblemId) {
            this.disciplineProblemId = disciplineProblemId;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getResponsiblity() {
            return responsiblity;
        }

        public void setResponsiblity(String responsiblity) {
            this.responsiblity = responsiblity;
        }
    }

    public static class RequestHistoryModel implements Serializable {

        int counter;
        String deciderEmployeeId;
        String deciderFullName;
        String givenDecision;
        String decidedDateAndTIme;
        String commentGiven;
        double deductionAmount;
        String duration;
        String approvedPenality;
        String suggetedPenality;
        String approvedDuration;
        String suggestedDuration;
        String lastCommeentes;
        String promotionSuspends;
        String transferSuspends;
        String promotionDuration;
        String transferDuration;
        double approvedDeduction;
        double suggestedDeduction;

        public RequestHistoryModel() {
        }

        public RequestHistoryModel(
                int counter,
                String deciderEmployeeId,
                String deciderFullName,
                String givenDecision,
                String decidedDateAndTIme,
                String commentGiven) {
            this(deciderEmployeeId, deciderFullName, givenDecision, decidedDateAndTIme, commentGiven);
            this.counter = counter;
        }

        public RequestHistoryModel(int counter, String deciderEmployeeId, String deciderFullName, String givenDecision, String decidedDateAndTIme, String commentGiven, double deductionAmount, String duration, String approvedPenality,
                String suggetedPenality, String approvedDuration, String suggtedDuration, String lastCommeents, double suggtestedDeduction, double approvedDeduction, String suspendedpromotion, String suspendTransfer, String promotionDuration, String transferDuration) {

            this.deductionAmount = deductionAmount;
            this.approvedPenality = approvedPenality;
            this.approvedDuration = approvedDuration;
            this.suggetedPenality = suggetedPenality;
            this.approvedDeduction = approvedDeduction;
            this.suggestedDuration = suggtedDuration;
            this.duration = duration;
            this.lastCommeentes = lastCommeents;
            this.suggestedDeduction = suggtestedDeduction;
            this.promotionSuspends = suspendedpromotion;
            this.promotionDuration = promotionDuration;
            this.transferSuspends = suspendTransfer;
            this.transferDuration = transferDuration;
            this.counter = counter;
            this.deciderEmployeeId = deciderEmployeeId;
            this.deciderFullName = deciderFullName;
            this.givenDecision = givenDecision;
            this.decidedDateAndTIme = decidedDateAndTIme;
            this.commentGiven = commentGiven;

        }

        public RequestHistoryModel(int counter, String deciderEmployeeId, String deciderFullName, String givenDecision, String decidedDateAndTIme, String commentGiven, double deductionAmount, String duration) {

            this(deciderEmployeeId, deciderFullName, givenDecision, decidedDateAndTIme, commentGiven);
            this.counter = counter;
            this.deductionAmount = deductionAmount;
            this.duration = duration;
        //  this.suggetedPenality = suggetedPenality;
//            this.suggestedDeduction=suggtestedDeduction;
//            this.suggestedDuration=suggtedDuration;
        //  this.approvedPenality = approvedPenality;
        //  this.approvedDeduction = approvedDeduction;
        //  this.approvedDuration = approvedDuration;
//            this.lastCommeentes=lastCommeents;
        // this.promotionSuspends=suspendedpromotion;
        // this.transferSuspends=suspendTransfer;
        // this.promotionDuration=promotionDuration;
        // this.transferDuration=transferDuration;

        }

        public RequestHistoryModel(String deciderEmployeeId, String deciderFullName, String givenDecision, String decidedDateAndTIme, String commentGiven) {
            this.deciderEmployeeId = deciderEmployeeId;
            this.deciderFullName = deciderFullName;
            this.givenDecision = givenDecision;
            this.decidedDateAndTIme = decidedDateAndTIme;
            this.commentGiven = commentGiven;
        }

        public String getPromotionDuration() {
            return promotionDuration;
        }

        public void setPromotionDuration(String promotionDuration) {
            this.promotionDuration = promotionDuration;
        }

        public String getPromotionSuspends() {
            return promotionSuspends;
        }

        public void setPromotionSuspends(String promotionSuspends) {
            this.promotionSuspends = promotionSuspends;
        }

        public String getTransferDuration() {
            return transferDuration;
        }

        public void setTransferDuration(String transferDuration) {
            this.transferDuration = transferDuration;
        }

        public String getTransferSuspends() {
            return transferSuspends;
        }

        public void setTransferSuspends(String transferSuspends) {
            this.transferSuspends = transferSuspends;
        }

        public String getApprovedPenality() {
            return approvedPenality;
        }

        public void setApprovedPenality(String approvedPenality) {
            this.approvedPenality = approvedPenality;
        }

        public double getApprovedDeduction() {
            return approvedDeduction;
        }

        public void setApprovedDeduction(double approvedDeduction) {
            this.approvedDeduction = approvedDeduction;
        }

        public String getApprovedDuration() {
            return approvedDuration;
        }

        public void setApprovedDuration(String approvedDuration) {
            this.approvedDuration = approvedDuration;
        }

        public String getLastCommeentes() {
            return lastCommeentes;
        }

        public void setLastCommeentes(String lastCommeentes) {
            this.lastCommeentes = lastCommeentes;
        }

        public double getSuggestedDeduction() {
            return suggestedDeduction;
        }

        public void setSuggestedDeduction(double suggestedDeduction) {
            this.suggestedDeduction = suggestedDeduction;
        }

        public String getSuggestedDuration() {
            return suggestedDuration;
        }

        public void setSuggestedDuration(String suggestedDuration) {
            this.suggestedDuration = suggestedDuration;
        }

        public String getSuggetedPenality() {
            return suggetedPenality;
        }

        public void setSuggetedPenality(String suggetedPenality) {
            this.suggetedPenality = suggetedPenality;
        }

        public double getDeductionAmount() {
            return deductionAmount;
        }

        public void setDeductionAmount(double deductionAmount) {
            this.deductionAmount = deductionAmount;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getCommentGiven() {
            return commentGiven;
        }

        public void setCommentGiven(String commentGiven) {
            this.commentGiven = commentGiven;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public String getDeciderEmployeeId() {
            return deciderEmployeeId;
        }

        public void setDeciderEmployeeId(String deciderEmployeeId) {
            this.deciderEmployeeId = deciderEmployeeId;
        }

        public String getDeciderFullName() {
            return deciderFullName;
        }

        public void setDeciderFullName(String deciderFullName) {
            this.deciderFullName = deciderFullName;
        }

        public String getGivenDecision() {
            return givenDecision;
        }

        public void setGivenDecision(String givenDecision) {
            this.givenDecision = givenDecision;
        }

        public String getDecidedDateAndTIme() {
            return decidedDateAndTIme;
        }

        public void setDecidedDateAndTIme(String decidedDateAndTIme) {
            this.decidedDateAndTIme = decidedDateAndTIme;
        }
    }

    public static class BenefitePakage {

        String benefiteName;
        String benefiteDuration;
        String benefiteValue;
        String monetary;
        String inpercent;
        double monetaryValue;
        String percent;

        public BenefitePakage() {
        }

        public String getBenefiteDuration() {
            return benefiteDuration;
        }

        public void setBenefiteDuration(String benefiteDuration) {
            this.benefiteDuration = benefiteDuration;
        }

        public String getBenefiteName() {
            return benefiteName;
        }

        public void setBenefiteName(String benefiteName) {
            this.benefiteName = benefiteName;
        }

        public String getBenefiteValue() {
            return benefiteValue;
        }

        public void setBenefiteValue(String benefiteValue) {
            this.benefiteValue = benefiteValue;
        }

        public String getInpercent() {
            return inpercent;
        }

        public void setInpercent(String inpercent) {
            this.inpercent = inpercent;
        }

        public String getMonetary() {
            return monetary;
        }

        public void setMonetary(String monetary) {
            this.monetary = monetary;
        }

        public double getMonetaryValue() {
            return monetaryValue;
        }

        public void setMonetaryValue(double monetaryValue) {
            this.monetaryValue = monetaryValue;
        }

        public String getPercent() {
            return percent;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }
    }
}
