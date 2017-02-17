/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import com.sun.webui.jsf.model.Option;
import entity.disciplineEntity.DisciplineApproveEntity;
import entity.disciplineEntity.DisciplineRequestEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import manager.authorizationManager.AuthorizationManager;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;

/**
 *
 * @author mekete VS BravoZulu
 */
public class DisciplineRequestManager {
    //===========================================================================================

    public static final String REQUERSTER_TYPE_IMMEDIATEBOSS = "IB";
    public static final String REQUERSTER_TYPE_ANOTHEREMPLOYEE = "ME";
    public static final String REQUERSTER_TYPE_NOTEMPLOYEE = "NE";
    public static final String EYEWITNESS_TYPE_WORKER = "WO";
    public static final String EYEWITNESS_TYPE_OTHER = "OT";
    //===========================================================================================
    public static final String DEFAULT_PENALTY_FAIR = "FAIR";
    public static final String DEFAULT_PENALTY_EXAGURATED = "EXAGURATED";
    public static final String DEFAULT_PENALTY_TOOSMALL = "TOOSMALL";
    //===========================================================================================
    DisciplineRequestEntity disciplineRequestEntity = new DisciplineRequestEntity();
    DisciplineApproveEntity disciplineApproveEntity = new DisciplineApproveEntity();
    DisciplineRequestModel disciplineRequestModel = new DisciplineRequestModel();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String nextState;
    String userName;
    String loggedinEmployeeId;
    boolean condition = false;




    public boolean saveDisciplineRequest(String dateOfOffence, String requesterType, String requesterId, String offenderId, String reportedDate,
        String offenceType, int repititionOfOffence, String descriptionOfOffence, String requestedMeasureToBeTaken, String isDocumentAttached,String reporterId,String reporterFullName,String reporterDepartment,String reporterPosition,String empStatus ,String canBeApproved) {
        String status = DisciplineApproveManager.INITIAL_STATE_DISCIPLINE;
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
        disciplineRequestModel = new DisciplineRequestModel(requesterType, requesterId, offenderId, dateOfOffence, reportedDate, offenceType, repititionOfOffence, descriptionOfOffence, requestedMeasureToBeTaken, status, isDocumentAttached, userName, currentDateAndTime,reporterId,reporterFullName,reporterDepartment,reporterPosition,empStatus,canBeApproved);
        try {
            disciplineRequestEntity.insertDisciplineRequest(disciplineRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean UPdateDisciplineRequest(String dateOfOffence, String requesterType, String requesterId, String offenderId, String reportedDate,
            String offenceType, int repititionOfOffence, String descriptionOfOffence, String requestedMeasureToBeTaken, String isDocumentAttached, int disciplineproblemId,String reporterId,String reporterFullName,String reporterDepartment,String reporterPosition) {
        String status = DisciplineApproveManager.INITIAL_STATE_DISCIPLINE;
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
        int disciplinePrblemId = disciplineproblemId;
        disciplineRequestModel = new DisciplineRequestModel(requesterType, requesterId, offenderId, dateOfOffence, reportedDate, offenceType, repititionOfOffence, descriptionOfOffence, requestedMeasureToBeTaken, status, isDocumentAttached, userName, currentDateAndTime, disciplineproblemId,reporterId,reporterFullName,reporterDepartment,reporterPosition);
        try {
            disciplineRequestEntity.UPdateDisciplineRequest(disciplineRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }
//selectDisciplineRequestFromId(int requestId)

    public double getEmployeeSalary(String offenderId) {
        double employeeSalry = 0;
        try {

            ResultSet _rs = disciplineApproveEntity.getEmployeeSalary(offenderId);

            if (_rs.next()) {
                employeeSalry = _rs.getDouble("SALARY");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return employeeSalry;
    }
    //==============================================checking penalityThat can be Approved========================================
        public boolean IsPenalityCanBeApproved(int disciplineID, int reputation) {
            boolean returnCondition=false;
            int penalizedDate=0;
         try {
           ResultSet _rs= disciplineApproveEntity.IsPenalityCanBeApproved(disciplineID,reputation);
           while(_rs.next()){
            penalizedDate=_rs.getInt("MONETARY_PENALTY_DAYS");
           }
           if(penalizedDate<=15){
               returnCondition=true;
           }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return returnCondition;
    }
    //===========================================================================================================================

    public boolean deleteApprovedRequest(int disciplineProcessedId) {
        try {
            disciplineApproveEntity.deleteApprovedRequestList(disciplineProcessedId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }
    //========================================================DisciplineIssueForManager=================================================================
     public DisciplineRequestModel getDisciplineIssuedForManager(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdForManager(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));

                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //==================================================================================================================================================

    public DisciplineRequestModel getDisciplineIssued(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromId(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));

                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //=======================================================================================================================
    //=============================================DisciplineIssueForManagerForSecondReputaion==========================================
     public DisciplineRequestModel getDisciplineIssuedSecondReoutaionForManager(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdSecondReputaionForManager(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
     //==================================================================================================================================

    public DisciplineRequestModel getDisciplineIssuedSecondReoutaion(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdSecondReputaion(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //=======================================================================================================================
    //====================================================ThiredReputationForManager=========================================
     public DisciplineRequestModel getDisciplineIssuedThiredReputaionForManager(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdThiredReputaion(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    //=======================================================================================================================

    public DisciplineRequestModel getDisciplineIssuedThiredReputaion(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdThiredReputaion(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                  disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //=======================================================================================================================
    //========================================================FourtReputaionForManager=======================================
     public DisciplineRequestModel getDisciplineIssuedForthReputaionForManager(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdForthReputaion(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setReporterPosition(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //========================================================================================================================

    public DisciplineRequestModel getDisciplineIssuedForthReputaion(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdForthReputaion(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                  disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                  disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //=======================================================================================================================
    //===================================================FivithReputaionForManager===========================================
     public DisciplineRequestModel getDisciplineIssuedFivesReputaionForManager(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdFivesReputaion(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    //========================================================================================================================

    public DisciplineRequestModel getDisciplineIssuedFivesReputaion(String offenceType, int disciplineProblemId) {
        try {
            DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineRequestFromIdFivesReputaion(offenceType, disciplineProblemId);
            if (_rs.next()) {

                disciplineModel.setDisciplineProblemId(disciplineProblemId);
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setExpectedPenalityToBeGiven(_rs.getString("PENALTY_NAME"));
                disciplineModel.setPenalizedDays(_rs.getString("MONETARY_PENALTY_DAYS"));
                disciplineModel.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setReportedDate(_rs.getString("REPORTED_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_TYPE"));
                disciplineModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                disciplineModel.setDocumentReferenceNumber(_rs.getString("IS_DOCUMENT_ATTACHED"));
                disciplineModel.setRecordedBy(_rs.getString("RECOREDED_BY"));
                disciplineModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                disciplineModel.setSuspennedPromotion(_rs.getString("PROCESS_NAME"));
                disciplineModel.setPromotionSuspendedDuration(_rs.getString("DURATION"));
                disciplineModel.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                disciplineModel.setTransferSupendedDuration(_rs.getString("DURATION_TRANSFER"));
                disciplineModel.setReporterID(_rs.getString("REPORTER_ID"));
                disciplineModel.setReporterFullName(_rs.getString("REPORTER_FULLNAME"));
                disciplineModel.setReporterDepartment(_rs.getString("REPORTER_DEPARTMENT"));
                disciplineModel.setReporterPosition(_rs.getString("REPORTER_POSITION"));
                disciplineModel.setEmployeeStatus(_rs.getString("EMPLOYEE_STATUS"));
                disciplineModel.setCatagory(_rs.getString("DESCIPLINE_CATAGORY"));
                disciplineModel.setSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));
                _rs.close();
                return disciplineModel;
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //=======================================================================================================================

    public int getCurrentRequestId() {
        int count = 0;
        try {
            ResultSet _rs = disciplineRequestEntity.selectCurrentRequestId();
            if (_rs.next()) {
                count = _rs.getInt("CURRENT_REQUEST_ID");
            }
            _rs.close();
            return count;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }

    }

    public int getPrevieousOffenceCommited(int disciplineType, String employeeId, int phaseOutTime) {
        int count = 0;
        try {
            Calendar todayCal = new GregorianCalendar();
            todayCal.add(Calendar.MONTH, phaseOutTime * (-1));   //subtract number of month phaseOutTime from current date
            String referenceDate = dateFormat.format(todayCal.getTime());
            ResultSet _rs = disciplineRequestEntity.selectPreviousCommiteedOffenceByEmployee(disciplineType, employeeId, referenceDate);
            if (_rs.next()) {
                count = _rs.getInt("NUMBER_OF_OFFENCES");
            }
            _rs.close();
            return count;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    public ArrayList<Option> getDisciplineTypes() {
        try {
            ArrayList<Option> disciplineTypesList = new ArrayList<Option>();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineTypes();
            while (_rs.next()) {
//                String optionId = Integer.toString(_rs.getInt("DESCIPLINE_TYPE_ID"));

                // String optionId = Integer.toString(_rs.getInt("DESCIPLINE_TYPE_ID"));
                // String optionId= _rs.getString("DESCIPLINE_TYPE_ID");
                
                String optionId = _rs.getString("DESCIPLINE_TYPE_ID") + "--" + _rs.getString("PHASEOUT_PERIOD");
                disciplineTypesList.add(new Option(optionId, _rs.getString("OFFENCE_NAME")));
            }
            if (disciplineTypesList.size() == 0) {
                disciplineTypesList.add(new Option("-1--0", "NO DISCIPLINE TYPE"));
            } else {
                disciplineTypesList.add(0, new Option("-1--0", "" +
                        "SELECT DISCIPLINE TYPE"));
            }
            _rs.close();
            return disciplineTypesList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    //=================================================================This is discipline tyep for manager============================================
     public ArrayList<Option> getDisciplineTypesForManager() {
        try {
            ArrayList<Option> disciplineTypesList = new ArrayList<Option>();
            ResultSet _rs = disciplineRequestEntity.selectDisciplineTypesForManager();
            while (_rs.next()) {
//                String optionId = Integer.toString(_rs.getInt("DESCIPLINE_TYPE_ID"));

                // String optionId = Integer.toString(_rs.getInt("DESCIPLINE_TYPE_ID"));
                // String optionId= _rs.getString("DESCIPLINE_TYPE_ID");

                String optionId = _rs.getString("DESCIPLINE_TYPE_ID");
                disciplineTypesList.add(new Option(optionId, _rs.getString("OFFENCE_NAME")));
            }
            if (disciplineTypesList.size() == 0) {
                disciplineTypesList.add(new Option("-1--0", "NO DISCIPLINE TYPE"));
            } else {
                disciplineTypesList.add(0, new Option("-1--0", "" +
                        "SELECT DISCIPLINE TYPE"));
            }
            _rs.close();
            return disciplineTypesList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    //================================================================================================================================================

    public ArrayList<Option> getPendingRequestsForCommittee() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = disciplineRequestEntity.selectRequestsByStatus(DisciplineApproveManager.INITIAL_STATE_DISCIPLINE);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID") + " =>" + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getPendingRequestsCanBeApprovrd() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = disciplineRequestEntity.selectRequestsByStatusCanBeApprovedHere(DisciplineApproveManager.INITIAL_STATE_DISCIPLINE);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("OFFENCE_TYPE")+"--"+_rs.getString("EMPLOYEE_STATUS"), _rs.getString("REQUESTER_ID") + " =>" + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();

            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    //================================================================================================================================

     public ArrayList<Option> getPendingRequests() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = disciplineRequestEntity.selectRequestsByStatus(DisciplineApproveManager.INITIAL_STATE_DISCIPLINE);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("OFFENCE_TYPE")+"--"+_rs.getString("EMPLOYEE_STATUS"), _rs.getString("REQUESTER_ID") + " =>" + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();

            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    //=================================================================================================================================

    public ArrayList<Option> getRequestsByRequester() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = disciplineRequestEntity.selectProcessedRequestsByRequester(loggedinEmployeeId, userName);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("OFFENCE_TYPE"), _rs.getString("REQUESTER_ID") + " =>" + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getPendingRequestsByAccused(String accusedEmployeeId) {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = disciplineRequestEntity.selectRequestsByAccusedAndStatus(accusedEmployeeId, userName, DisciplineApproveManager.INITIAL_STATE_DISCIPLINE);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("OFFENCE_TYPE") + "--" + _rs.getString("EMPLOYEE_STATUS")+ "--" + _rs.getString("DESCRIPTION_OF_OFFENCE"), _rs.getString("REQUESTER_ID") + " =>" + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<DisciplineRequestModel> getComittedOffencesOfEmployee(String employeeId) {
        ArrayList<DisciplineRequestModel> committedOffences = new ArrayList<DisciplineRequestModel>();
        try {
            ResultSet _rs = disciplineRequestEntity.selectOffencesCommittedByEmployee(employeeId);
            while (_rs.next()) {
                DisciplineRequestModel disciplineModel = new DisciplineRequestModel();
                disciplineModel.setDisciplineProblemId(_rs.getInt("DISCIPLINE_PROBLEM_ID"));
                disciplineModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                disciplineModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineModel.setOffenderId(employeeId);
                disciplineModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
                disciplineModel.setOffenceType(_rs.getString("OFFENCE_NAME"));
                disciplineModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineModel.setRequestedMeasureToBeTaken(_rs.getString("REQUESTED_MEASURE_TO_BE_TAKEN"));
                disciplineModel.setStatus(_rs.getString("STATUS"));
                committedOffences.add(disciplineModel);
            }
            _rs.close();
            return committedOffences;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    /* int disciplineProblemId;// DISCIPLINE_PROBLEM_ID
    String requesterType;//REQUESTER_TYPE
    String requesterId;//REQUESTER_ID
    String offenderId;//OFFENDER_ID always employee
    String dateOfOffence;//DATE_OF_OFFENCE//when does it happen
    String reportedDate;//REPORTED_DATE//reported to the hrms e
    String offenceType;// OFFENCE_TYPE,//if it is registerd in the table HR_DISCIPLINE_TYPE, ELSE "Other"
    int repititionOfOffence;//REPITITION_OF_OFFENCE//how many times does it occured before the phase out time
    String descriptionOfOffence;//DESCRIPTION_OF_OFFENCE//details
    String requestedMeasureToBeTaken;//REQUESTED_MEASURE_TO_BE_TAKEN by requester+
    String status;//STATUS
    String documentReferenceNumber;//IS_DOCUMENT_ATTACHED
    String recordedBy;//RECOREDE_BY
    String timeStamp;//TIME_STAMP
    String expectedPenalityToBeGiven;
    String deciderType;
    //=======================================
    String offenderDepartment;
    String requesterFullName;
    String offenderFullName;*/

    public ArrayList<DisciplineRequestModel> getDisciplineReport(
            String requesterId, String offenderId, String offenderDepartment, String disciplineFromDate, String disciplineToDate,
            String offenceType, String penaltyType, String statusList) {
        String possibleStatus = AuthorizationManager.getProcessStates(statusList, AuthorizationManager.PROCESS_DISCIPLINE);
        disciplineRequestModel = new DisciplineRequestModel(requesterId, offenderId, offenderDepartment,
                disciplineFromDate, disciplineToDate,
                offenceType, penaltyType, -1, possibleStatus);

        ArrayList<DisciplineRequestModel> requestLists = new ArrayList<DisciplineRequestModel>();
        try {
            ResultSet _rs = disciplineRequestEntity.selectDisciplineReport(disciplineRequestModel);
            int counter = 0;
            while (_rs.next()) {
                disciplineRequestModel = new DisciplineRequestModel();
                disciplineRequestModel.setDisciplineProblemId(_rs.getInt("DISCIPLINE_PROBLEM_ID"));
                disciplineRequestModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                disciplineRequestModel.setOffenderId(_rs.getString("OFFENDER_ID"));
                disciplineRequestModel.setOffenderFullName(_rs.getString("ACCUSEED_FIRST_NAME") + " " + _rs.getString("ACCUSEED_MIDDLE_NAME") + " " + _rs.getString("ACCUSEED_LAST_NAME"));
                disciplineRequestModel.setRequesterFullName(_rs.getString("REQUESTER_FIRST_NAME") + " " + _rs.getString("REQUESTER_MIDDLE_NAME") + " " + _rs.getString("REQUESTER_LAST_NAME"));
                disciplineRequestModel.setDateOfOffence(_rs.getString("OFFENCE_DATE"));
//                disciplineRequestModel.setRepititionOfOffence(_rs.getInt("REPITITION_OF_OFFENCE"));
                disciplineRequestModel.setOffenceType(_rs.getString("OFFENCE_NAME"));
                disciplineRequestModel.setPenalty(_rs.getString("PENALTY_NAME"));
                disciplineRequestModel.setDescriptionOfOffence(_rs.getString("DESCRIPTION_OF_OFFENCE"));
                disciplineRequestModel.setStatus(Integer.toString(++counter));
                requestLists.add(disciplineRequestModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean ChackPreviousPenality(String accusedEmployeeID, int reputaionCondition, int offenceType) {

        try {

            ResultSet _rs = disciplineRequestEntity.CheakPreviousPenality(accusedEmployeeID, reputaionCondition);
            while (_rs.next()) {
                int reputation = _rs.getInt("REPITITION_OF_OFFENCE");
                int ProblemType = _rs.getInt("OFFENCE_TYPE");

                if ((reputaionCondition == reputation) && (ProblemType == offenceType)) {

                    condition = true;
                } else {

                    condition = false;
                }
            }
            return condition;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    // return false;
    }
    //====================================================NewlyAdded=========================================================================

     public boolean ChackPreviousPenalityNewly(String accusedEmployeeID, int reputaionCondition, int offenceType, String currentDate) {

        try {

            ResultSet _rs = disciplineRequestEntity.CheakPreviousPenalityNewlyAdded(accusedEmployeeID, reputaionCondition, offenceType, reputaionCondition );
            while (_rs.next()) {
                int reputation = _rs.getInt("REPITITION_OF_OFFENCE");
                int ProblemType = _rs.getInt("OFFENCE_TYPE");
                String approvedDate=_rs.getString("approvedate");
                               
                int calculatedYear= GregorianCalendarManipulation.calaculateYearDifference(currentDate,approvedDate);
              
                if ((reputaionCondition == reputation) && (ProblemType == offenceType)&&(calculatedYear<1)) {

                    condition = true;
                } else {

                    condition = false;
                }
            }
            return condition;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    // return false;
    }
    //=======================================================================================================================================


//<editor-fold defaultstate="collapsed" desc=" inner class DisciplineRequestModel">
    public static class DisciplineRequestModel {

        int disciplineProblemId;// DISCIPLINE_PROBLEM_ID
        String requesterType;//REQUESTER_TYPE
        String requesterId;//REQUESTER_ID
        String offenderId;//OFFENDER_ID always employee
        String dateOfOffence;//DATE_OF_OFFENCE//when does it happen
        String reportedDate;//REPORTED_DATE//reported to the hrms e
        String offenceType;// OFFENCE_TYPE,//if it is registerd in the table HR_DISCIPLINE_TYPE, ELSE "Other"
        int repititionOfOffence;//REPITITION_OF_OFFENCE//how many times does it occured before the phase out time
        String descriptionOfOffence;//DESCRIPTION_OF_OFFENCE//details
        String requestedMeasureToBeTaken;//REQUESTED_MEASURE_TO_BE_TAKEN by requester+
        String status;//STATUS
        String documentReferenceNumber;//IS_DOCUMENT_ATTACHED
        String recordedBy;//RECOREDE_BY
        String timeStamp;//TIME_STAMP
        String expectedPenalityToBeGiven;
        String penalizedDays;
        int deductionDuration;
        double deductAmount;
        String deciderType;
        String agreeOnDefaultPenalty;
        String suggetedPenality;
        String approvedPenality;
        String suggetedDuration;
        String approvedDuration;
        String lastApprovercomments;
        double suggestedDeduction;
        double approveddeduction;
        String suspennedPromotion;
        String promotionSuspendedDuration;
        String suspendedTransfer;
        String transferSupendedDuration;
        String employeeStatus;
        String catagory;
        String subCatagory;
        //=======================================
        String offenderDepartment;
        String requesterFullName;
        String offenderFullName;
        String disciplineFromDate;
        String disciplineToDate;
        String penalty;
        //==============================================
        String approvedHere;
        //==============================================
        String reporterID;
        String reporterFullName;
        String reporterDepartment;
        String reporterPosition;
        //==============================================

        public DisciplineRequestModel() {
        }

        public DisciplineRequestModel(String requesterId, String offenderId, String offenderDepartment,
                String disciplineFromDate, String disciplineToDate,
                String offenceType, String penalty, int repititionOfOffence, String status) {
            this.requesterId = requesterId;
            this.offenderId = offenderId;
            this.offenderDepartment = offenderDepartment;
            this.disciplineFromDate = disciplineFromDate;
            this.disciplineToDate = disciplineToDate;
            this.repititionOfOffence = repititionOfOffence;
            this.disciplineFromDate = disciplineFromDate;
            this.offenceType = offenceType;
            this.penalty = penalty;
            this.repititionOfOffence = repititionOfOffence;
            this.status = status;

        }

        public DisciplineRequestModel(String requesterType, String requesterId, String offenderId, String dateOfOffence,
                String reportedDate, String offenceType, int repititionOfOffence, String descriptionOfOffence, String requestedMeasureToBeTaken, String status, String isDocumentAttached, String recordedBy, String timeStamp ,String reporterID,String reporterFullName,String reporterDepratment,String reporterPosition,String empStatus,String canBeApproved) {

            this.requesterType = requesterType;
            this.requesterId = requesterId;
            this.offenderId = offenderId;
            this.dateOfOffence = dateOfOffence;
            this.reportedDate = reportedDate;
            this.offenceType = offenceType;
            this.repititionOfOffence = repititionOfOffence;
            this.descriptionOfOffence = descriptionOfOffence;
            this.requestedMeasureToBeTaken = requestedMeasureToBeTaken;
            this.status = status;
            this.documentReferenceNumber = isDocumentAttached;
            this.recordedBy = recordedBy;
            this.timeStamp = timeStamp;
            this.reporterID=reporterID;
            this.reporterFullName=reporterFullName;
            this.reporterDepartment=reporterDepratment;
            this.reporterPosition=reporterPosition;
            this.employeeStatus=empStatus;
            this.approvedHere=canBeApproved;

        }

        /**
         * for updating selecting this constructor is used
         */
//        public DisciplineRequestModel(int disciplineProblemId, String requesterType, String requesterId, String offenderId, String dateOfOffence, String reportedDate, String offenceType, int repititionOfOffence, String descriptionOfOffence, String requestedMeasureToBeTaken, String status, String isDocumentAttached, String recordedBy, String timeStamp,String reporterID,String reporterFullName,String reporterDepratment,String reporterPosition) {
//            this(dateOfOffence, requesterType, requesterId, offenderId, reportedDate, offenceType, repititionOfOffence, descriptionOfOffence, requestedMeasureToBeTaken, status, isDocumentAttached, recordedBy, timeStamp);
//            this.disciplineProblemId = disciplineProblemId;
//            this.reporterID=reporterID;
//            this.reporterFullName=reporterFullName;
//            this.reporterDepartment=reporterDepratment;
//            this.reporterPosition=reporterPosition;
//
//        }

        private DisciplineRequestModel(String requesterType, String requesterId, String offenderId, String dateOfOffence, String reportedDate, String offenceType, int repititionOfOffence, String descriptionOfOffence, String requestedMeasureToBeTaken, String status, String documentAttached, String userName, String currentDateAndTime, int disciplineproblemId,String reporterID,String reporterFullName,String reporterDepartment,String reporterPosition) {
            this.requesterType = requesterType;
            this.requesterId = requesterId;
            this.offenderId = offenderId;
            this.dateOfOffence = dateOfOffence;
            this.reportedDate = reportedDate;
            this.offenceType = offenceType;
            this.repititionOfOffence = repititionOfOffence;
            this.descriptionOfOffence = descriptionOfOffence;
            this.requestedMeasureToBeTaken = requestedMeasureToBeTaken;
            this.status = status;
            this.documentReferenceNumber = documentAttached;
            this.recordedBy = userName;
            this.timeStamp = currentDateAndTime;
            this.disciplineProblemId = disciplineproblemId;
            this.reporterID=reporterID;
            this.reporterFullName=reporterFullName;
            this.reporterDepartment=reporterDepartment;
            this.reporterPosition=reporterPosition;
        }

        public String getCatagory() {
            return catagory;
        }

        public void setCatagory(String catagory) {
            this.catagory = catagory;
        }

        public String getSubCatagory() {
            return subCatagory;
        }

        public void setSubCatagory(String subCatagory) {
            this.subCatagory = subCatagory;
        }

        public String getApprovedHere() {
            return approvedHere;
        }

        public void setApprovedHere(String approvedHere) {
            this.approvedHere = approvedHere;
        }

    public String getEmployeeStatus() {
            return employeeStatus;
        }

        public void setEmployeeStatus(String employeeStatus) {
            this.employeeStatus = employeeStatus;
        }

        public String getReporterDepartment() {
            return reporterDepartment;
        }

        public void setReporterDepartment(String reporterDepartment) {
            this.reporterDepartment = reporterDepartment;
        }

        public String getReporterFullName() {
            return reporterFullName;
        }

        public void setReporterFullName(String reporterFullName) {
            this.reporterFullName = reporterFullName;
        }

        public String getReporterID() {
            return reporterID;
        }

        public void setReporterID(String reporterID) {
            this.reporterID = reporterID;
        }

        public String getReporterPosition() {
            return reporterPosition;
        }

        public void setReporterPosition(String reporterPosition) {
            this.reporterPosition = reporterPosition;
        }

        public String getPromotionSuspendedDuration() {
            return promotionSuspendedDuration;
        }

        public void setPromotionSuspendedDuration(String promotionSuspendedDuration) {
            this.promotionSuspendedDuration = promotionSuspendedDuration;
        }

        public String getSuspendedTransfer() {
            return suspendedTransfer;
        }

        public void setSuspendedTransfer(String suspendedTransfer) {
            this.suspendedTransfer = suspendedTransfer;
        }

        public String getSuspennedPromotion() {
            return suspennedPromotion;
        }

        public void setSuspennedPromotion(String suspennedPromotion) {
            this.suspennedPromotion = suspennedPromotion;
        }

        public String getTransferSupendedDuration() {
            return transferSupendedDuration;
        }

        public void setTransferSupendedDuration(String transferSupendedDuration) {
            this.transferSupendedDuration = transferSupendedDuration;
        }

        public String getApprovedDuration() {
            return approvedDuration;
        }

        public void setApprovedDuration(String approvedDuration) {
            this.approvedDuration = approvedDuration;
        }

        public String getApprovedPenality() {
            return approvedPenality;
        }

        public void setApprovedPenality(String approvedPenality) {
            this.approvedPenality = approvedPenality;
        }

        public double getApproveddeduction() {
            return approveddeduction;
        }

        public void setApproveddeduction(double approveddeduction) {
            this.approveddeduction = approveddeduction;
        }

        public String getLastApprovercomments() {
            return lastApprovercomments;
        }

        public void setLastApprovercomments(String lastApprovercomments) {
            this.lastApprovercomments = lastApprovercomments;
        }

        public double getSuggestedDeduction() {
            return suggestedDeduction;
        }

        public void setSuggestedDeduction(double suggestedDeduction) {
            this.suggestedDeduction = suggestedDeduction;
        }

        public String getSuggetedDuration() {
            return suggetedDuration;
        }

        public void setSuggetedDuration(String suggetedDuration) {
            this.suggetedDuration = suggetedDuration;
        }

        public String getSuggetedPenality() {
            return suggetedPenality;
        }

        public void setSuggetedPenality(String suggetedPenality) {
            this.suggetedPenality = suggetedPenality;
        }

        public String getAgreeOnDefaultPenalty() {
            return agreeOnDefaultPenalty;
        }

        public void setAgreeOnDefaultPenalty(String agreeOnDefaultPenalty) {
            this.agreeOnDefaultPenalty = agreeOnDefaultPenalty;
        }

        public double getDeductAmount() {
            return deductAmount;
        }

        public void setDeductAmount(double deductAmount) {
            this.deductAmount = deductAmount;
        }

        public int getDeductionDuration() {
            return deductionDuration;
        }

        public void setDeductionDuration(int deductionDuration) {
            this.deductionDuration = deductionDuration;
        }

        public String getPenalizedDays() {
            return penalizedDays;
        }

        public void setPenalizedDays(String penalizedDays) {
            this.penalizedDays = penalizedDays;
        }

        public String getDateOfOffence() {
            return dateOfOffence;
        }

        public void setDateOfOffence(String dateOfOffence) {
            this.dateOfOffence = dateOfOffence;
        }

        public String getDescriptionOfOffence() {
            return descriptionOfOffence;
        }

        public void setDescriptionOfOffence(String descriptionOfOffence) {
            this.descriptionOfOffence = descriptionOfOffence;
        }

        public int getDisciplineProblemId() {
            return disciplineProblemId;
        }

        public void setDisciplineProblemId(int disciplineProblemId) {
            this.disciplineProblemId = disciplineProblemId;
        }

        public String getOffenderFullName() {
            return offenderFullName;
        }

        public void setOffenderFullName(String offenderFullName) {
            this.offenderFullName = offenderFullName;
        }

        public String getRequesterFullName() {
            return requesterFullName;
        }

        public String getDisciplineFromDate() {
            return disciplineFromDate;
        }

        public void setDisciplineFromDate(String disciplineFromDate) {
            this.disciplineFromDate = disciplineFromDate;
        }

        public String getDisciplineToDate() {
            return disciplineToDate;
        }

        public void setDisciplineToDate(String disciplineToDate) {
            this.disciplineToDate = disciplineToDate;
        }

        public String getOffenderDepartment() {
            return offenderDepartment;
        }

        public void setOffenderDepartment(String offenderDepartment) {
            this.offenderDepartment = offenderDepartment;
        }

        public void setRequesterFullName(String requesterFullName) {
            this.requesterFullName = requesterFullName;
        }

        public String getDocumentReferenceNumber() {
            return documentReferenceNumber;
        }

        public void setDocumentReferenceNumber(String documentReferenceNumber) {
            this.documentReferenceNumber = documentReferenceNumber;
        }

        public String getOffenceType() {
            return offenceType;
        }

        public String getPenalty() {
            return penalty;
        }

        public void setPenalty(String penalty) {
            this.penalty = penalty;
        }

        public void setOffenceType(String offenceType) {
            this.offenceType = offenceType;
        }

        public String getOffenderId() {
            return offenderId;
        }

        public void setOffenderId(String offenderId) {
            this.offenderId = offenderId;
        }

        public String getRecordedBy() {
            return recordedBy;
        }

        public void setRecordedBy(String recordedBy) {
            this.recordedBy = recordedBy;
        }

        public int getRepititionOfOffence() {
            return repititionOfOffence;
        }

        public void setRepititionOfOffence(int repititionOfOffence) {
            this.repititionOfOffence = repititionOfOffence;
        }

        public String getReportedDate() {
            return reportedDate;
        }

        public void setReportedDate(String reportedDate) {
            this.reportedDate = reportedDate;
        }

        public String getRequestedMeasureToBeTaken() {
            return requestedMeasureToBeTaken;
        }

        public void setRequestedMeasureToBeTaken(String requestedMeasureToBeTaken) {
            this.requestedMeasureToBeTaken = requestedMeasureToBeTaken;
        }

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

        public String getDeciderType() {
            return deciderType;
        }

        public void setDeciderType(String deciderType) {
            this.deciderType = deciderType;
        }

        public String getExpectedPenalityToBeGiven() {
            return expectedPenalityToBeGiven;
        }

        public void setExpectedPenalityToBeGiven(String expectedPenalityToBeGiven) {
            this.expectedPenalityToBeGiven = expectedPenalityToBeGiven;
        }

        public String getRequesterType() {
            return requesterType;
        }

        public void setRequesterType(String requesterType) {
            this.requesterType = requesterType;
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
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="All Getters And Setters">

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DisciplineRequestEntity getDisciplineRequestEntity() {
        return disciplineRequestEntity;
    }

    public void setDisciplineRequestEntity(DisciplineRequestEntity disciplineRequestEntity) {
        this.disciplineRequestEntity = disciplineRequestEntity;
    }

    public DisciplineRequestModel getDisciplineRequestModel() {
        return disciplineRequestModel;
    }

    public void setDisciplineRequestModel(DisciplineRequestModel disciplineRequestModel) {
        this.disciplineRequestModel = disciplineRequestModel;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getDEFAULT_PENALTY_EXAGURATED() {
        return DEFAULT_PENALTY_EXAGURATED;
    }

    public static String getDEFAULT_PENALTY_FAIR() {
        return DEFAULT_PENALTY_FAIR;
    }

    public static String getDEFAULT_PENALTY_TOOSMALL() {
        return DEFAULT_PENALTY_TOOSMALL;
    }

    public static String getREQUERSTER_TYPE_ANOTHEREMPLOYEE() {
        return REQUERSTER_TYPE_ANOTHEREMPLOYEE;
    }

    public static String getREQUERSTER_TYPE_IMMEDIATEBOSS() {
        return REQUERSTER_TYPE_IMMEDIATEBOSS;
    }

    public static String getREQUERSTER_TYPE_NOTEMPLOYEE() {
        return REQUERSTER_TYPE_NOTEMPLOYEE;
    }

    public DisciplineApproveEntity getDisciplineApproveEntity() {
        return disciplineApproveEntity;
    }

    public void setDisciplineApproveEntity(DisciplineApproveEntity disciplineApproveEntity) {
        this.disciplineApproveEntity = disciplineApproveEntity;
    }

    public String getLoggedinEmployeeId() {
        return loggedinEmployeeId;
    }

    public void setLoggedinEmployeeId(String loggedinEmployeeId) {
        this.loggedinEmployeeId = loggedinEmployeeId;
    }
    //</editor-fold>
}
