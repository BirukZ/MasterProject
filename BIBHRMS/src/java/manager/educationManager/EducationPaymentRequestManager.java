/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

import com.sun.webui.jsf.model.Option;
import entity.educationEntity.EducationPaymentRequestEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class EducationPaymentRequestManager {

    String userName;
    String loggedInEmployeeId;
    EducationPaymentModel educationPaymentModel = new EducationPaymentModel();
    EducationPaymentRequestEntity educationPaymentRequestEntity = new EducationPaymentRequestEntity();

    public ArrayList<SelectItem> getPendingRequests() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectPendingEducationPaymentRequests(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUC_PAYMENT_REQUEST_ID") + "--" + _rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS") + "--" + _rs.getString("APPLIED_DATE"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getPendingpOSRequests() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectPendingEducationpOSPaymentRequests(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUC_PAYMENT_REQUEST_ID") + "--" + _rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getMyRequestsHistory() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectEducationPaymentRequestHistory(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUC_PAYMENT_REQUEST_ID") + "--" + _rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS") + "--" + _rs.getString("APPLIED_DATE"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getMyPossRequestsHistory() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectEducationPosPaymentRequestHistory(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUC_PAYMENT_REQUEST_ID") + "--" + _rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public EducationPaymentModel getEducationPaymentRequest(int requestId) {
        educationPaymentModel = new EducationPaymentModel();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectEducationPaymentRequest(requestId);
            if (_rs.next()) {

                educationPaymentModel.setEducationRequestId(requestId);
                educationPaymentModel.setPaymentPreOrPost(_rs.getString("PAYMENT_PRE_OR_POST"));
                educationPaymentModel.setAcademicYear(_rs.getString("ACADEMIC_YEAR"));
                educationPaymentModel.setSemesterOrTerm(_rs.getString("SEMESTER_OR_TERM"));
                educationPaymentModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                educationPaymentModel.setIssueDate(_rs.getString("ISSUE_DATE"));
                educationPaymentModel.setRemark(_rs.getString("REMARK"));
                educationPaymentModel.setDocumentReferenceNumber(_rs.getString("DOC_REFERENCE_NUMBER"));
                educationPaymentModel.setReceiptNumber(_rs.getString("RECEIPT_NUMBER"));
                educationPaymentModel.setTotalCost(_rs.getDouble("TOTAL_COST"));
                // educationPaymentModel.setCumlativeGPA(_rs.getInt("CGPA"));
                educationPaymentModel.setUserName(_rs.getString("USER_NAME"));
                educationPaymentModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                educationPaymentModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));


            } else {
                educationPaymentModel.setEducationRequestId(-1);
            }
            _rs.close();
            return educationPaymentModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public EducationPaymentModel getEducationpOSPaymentRequest(int requestId) {
        educationPaymentModel = new EducationPaymentModel();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectEducationpOSPaymentRequest(requestId);
            if (_rs.next()) {

                educationPaymentModel.setEducationRequestId(requestId);
                educationPaymentModel.setPaymentPreOrPost(_rs.getString("PAYMENT_PRE_OR_POST"));
                educationPaymentModel.setAcademicYear(_rs.getString("ACADEMIC_YEAR"));
                educationPaymentModel.setSemesterOrTerm(_rs.getString("SEMESTER_OR_TERM"));
                educationPaymentModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                educationPaymentModel.setIssueDate(_rs.getString("ISSUE_DATE"));
                educationPaymentModel.setRemark(_rs.getString("REMARK"));
                educationPaymentModel.setDocumentReferenceNumber(_rs.getString("DOC_REFERENCE_NUMBER"));
                educationPaymentModel.setReceiptNumber(_rs.getString("RECEIPT_NUMBER"));
                educationPaymentModel.setTotalCost(_rs.getDouble("TOTAL_COST"));
                educationPaymentModel.setCumlativeGPA(_rs.getInt("CGPA"));
                educationPaymentModel.setUserName(_rs.getString("USER_NAME"));
                educationPaymentModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                educationPaymentModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));


            } else {
                educationPaymentModel.setEducationRequestId(-1);
            }
            _rs.close();
            return educationPaymentModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readEducationInfo(String employeeId) {
        try {
            return educationPaymentRequestEntity.readEducationInfo(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
public HashMap readAgremment(String employeeId) {
        try {
            return educationPaymentRequestEntity.readAgreement(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public boolean saveEducationAdinstratice(ArrayList<EducationPaymentModel> educationPaymentModel, String appliedDate) {
        ArrayList<EducationPaymentModel> Insereted = new ArrayList<EducationPaymentModel>();
        //educationPaymentModel = new EducationPaymentModel(requesterId, unitCost, quantity, totalCost, adminstrativeCostType);
        try {
            for (EducationPaymentModel educationPaymentModell : educationPaymentModel) {

                Insereted.add(educationPaymentModell);
            }
            educationPaymentRequestEntity.insertEducationAdminstrat(Insereted, appliedDate);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean UpdateEducationAdinstratice(ArrayList<EducationPaymentModel> educationPaymentModel, int adminId) {
        ArrayList<EducationPaymentModel> Insereted = new ArrayList<EducationPaymentModel>();
        //educationPaymentModel = new EducationPaymentModel(requesterId, unitCost, quantity, totalCost, adminstrativeCostType);
        try {
            for (EducationPaymentModel educationPaymentModell : educationPaymentModel) {

                Insereted.add(educationPaymentModell);
            }
            educationPaymentRequestEntity.UpdteEducationAdminstrat(Insereted, adminId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveCourseTaking(ArrayList<EducationPaymentModel> courseTakingList, String applideDate) {
        ArrayList<EducationPaymentModel> Insereted = new ArrayList<EducationPaymentModel>();
        //educationPaymentModel = new EducationPaymentModel(requesterId, unitCost, quantity, totalCost, adminstrativeCostType);
        try {
            for (int counter = 0; counter < courseTakingList.size(); counter++) {

               Insereted.add(courseTakingList.get(counter));
            }
            educationPaymentRequestEntity.insertCourseTakingList(Insereted, applideDate);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveCourseTakingBasicLevl(String requesterId, int eduReqId, String grade, String appliedDate) {
        //ArrayList<EducationPaymentModel> Insereted = new ArrayList<EducationPaymentModel>();
        educationPaymentModel = new EducationPaymentModel(requesterId, eduReqId, grade, appliedDate);
        try {

            educationPaymentRequestEntity.insertBasic(educationPaymentModel);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean UpdaeteCourseTaking(ArrayList<EducationPaymentModel> courseTakingList, int courseID) {
        ArrayList<EducationPaymentModel> Insereted = new ArrayList<EducationPaymentModel>();
        //educationPaymentModel = new EducationPaymentModel(requesterId, unitCost, quantity, totalCost, adminstrativeCostType);
        try {
            for (EducationPaymentModel educationCourse : courseTakingList) {

                Insereted.add(educationCourse);
            }
            educationPaymentRequestEntity.UpadetCourseTakingList(Insereted, courseID);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveEducationRequest(String requesterID,
            int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String issueDate, String remark, String documentReferenceNumber, String receiptNumber, String requestStatus, double totalCost) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        educationPaymentModel = new EducationPaymentModel(requesterID, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, EducationPaymentApproveManager.INITIAL_STATE_EDUCATION_PAYMENT, timeStamp, userName, totalCost);

        try {
            educationPaymentRequestEntity.insertEducationPaymentRequest(educationPaymentModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean saveEducationPosRequest(String requesterID,
            int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String issueDate, String remark, String documentReferenceNumber, String receiptNumber, String requestStatus, double totalCost) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        educationPaymentModel = new EducationPaymentModel(requesterID, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, EducationPaymentApproveManager.INITIAL_STATE_EDUCATION_PAYMENT, timeStamp, userName, totalCost);

        try {
            educationPaymentRequestEntity.insertEducationPaymentRequest(educationPaymentModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateEducationRequest(int educationPaymentRequestId, int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String issueDate, String remark, String documentReferenceNumber, String receiptNumber, double totalCost, String requestStatus) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        educationPaymentModel = new EducationPaymentModel(educationPaymentRequestId, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, totalCost, EducationPaymentApproveManager.INITIAL_STATE_EDUCATION_PAYMENT, timeStamp, userName);
        try {
            educationPaymentRequestEntity.updateEducationPaymentRequest(educationPaymentModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateEducationPosRequest(int educationPaymentRequestId, int educationRequestId, String paymentPreOrPost, String academicYear, String semesterOrTerm, String appliedDate, String issueDate, String remark, String documentReferenceNumber, String receiptNumber, double totalCost, float cGPA, String requestStatus) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        educationPaymentModel = new EducationPaymentModel(educationPaymentRequestId, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, totalCost, cGPA, EducationPaymentApproveManager.INITIAL_STATE_EDUCATION_PAYMENT, timeStamp, userName);
        try {
            educationPaymentRequestEntity.updateEducationPaymentRequest(educationPaymentModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateAdminsrequest(String requesterId, double unitCost, double totalCost, String adminstrativeCostType, int educReqID) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        educationPaymentModel = new EducationPaymentModel(requesterId, unitCost, totalCost, adminstrativeCostType, educReqID);
        try {
            educationPaymentRequestEntity.updateEducationAdminstrativecost(educationPaymentModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean deleteEducationRequest(int educationRequestId) {
        try {
            educationPaymentRequestEntity.deleteEducationPaymentRequest(educationRequestId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean deleteAdminstrativeCostRequest(int educationRequestId) {
        try {
            educationPaymentRequestEntity.deleteAdminstrativeCostRequest(educationRequestId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean deleteBasicLevelRequest(int educationRequestId) {
        try {
            educationPaymentRequestEntity.deleteCourseBasicLevel(educationRequestId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean deleteCourseRequest(int educationRequestId) {
        try {
            educationPaymentRequestEntity.deleteCourseRequest(educationRequestId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
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

    public ArrayList<SelectItem> getAdminstrativeCost() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectAdminstrativeCost();

            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("ADMINSTRATIVE_COST_ID") + "-" + _rs.getString("ADMINSTRATIVE_COST_TYPE"), _rs.getString("ADMINSTRATIVE_COST_TYPE"));
                requestLists.add(currentRequest);
            }
            requestLists.add(0, new Option(null, "Select Adminstrative Cost Type"));
            _rs.close();

            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getprogramName(String categoryID) {
        ArrayList<SelectItem> programtLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectProgramName(categoryID);

            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDU_TYPE_NAME"));
                programtLists.add(currentRequest);
            }
            programtLists.add(0, new Option(null, "--Select Progarme Name--"));
            _rs.close();

            return programtLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readEmployeeCourseInfo(String employeeId, String courseCode, String instName) {
        try {
            return educationPaymentRequestEntity.readEmployeeCourseInfo(employeeId, courseCode, instName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> getTableInfo(int reqestID, String date) {
        try {
            ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = educationPaymentRequestEntity.readAllTableInfo(reqestID, date);
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

    public ArrayList<HashMap> getCourseInfo(int reqestID, String date) {
        try {
            ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = educationPaymentRequestEntity.readAllCourse(reqestID, date);
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

    public ArrayList<HashMap> checkPrePaid(String requesterId, String programName) {
        try {
            ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = educationPaymentRequestEntity.checkPrePaid(requesterId, programName);
            while (ocrs.next()) {
                HashMap resultInfo = new HashMap();

                resultInfo.put("ACADEMIC_YEAR", ocrs.getString("ACADEMIC_YEAR"));
                resultInfo.put("SEMESTER_OR_TERM", ocrs.getString("SEMESTER_OR_TERM"));
                resultInfo.put("APPLIED_DATE", ocrs.getString("APPLIED_DATE"));
//                resultInfo.put("COURSE_CODE", ocrs.getString("COURSE_CODE"));
//                resultInfo.put("SEMISTER", ocrs.getString("SEMISTER"));
//                resultInfo.put("CREDIT_HOUR", ocrs.getString("CREDIT_HOUR"));
//                resultInfo.put("ACADAMIC_YEAR", ocrs.getString("ACADAMIC_YEAR"));
//                resultInfo.put("CGPA", ocrs.getString("CGPA"));
//                resultInfo.put("GRADE_PT", ocrs.getString("GRADE_PT"));
                //resultInfo.put("STATUS", ocrs.getString("STATUS"));
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

    public String checkEnrolled(String requesterId, String programName) {
        try {
            String enrolledOrNot = null;
//            ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = educationPaymentRequestEntity.checkEnrolled(requesterId, programName);
            while (ocrs.next()) {
//                HashMap resultInfo = new HashMap();
                enrolledOrNot = ocrs.getString("EDUCATIONAL_STATUS");
//                resultInfo.put("EDUCATIONAL_STATUS", ocrs.getString("EDUCATIONAL_STATUS"));
//                resultInfo.put("COURSE_CODE", ocrs.getString("COURSE_CODE"));
//                resultInfo.put("SEMISTER", ocrs.getString("SEMISTER"));
//                resultInfo.put("CREDIT_HOUR", ocrs.getString("CREDIT_HOUR"));
//                resultInfo.put("ACADAMIC_YEAR", ocrs.getString("ACADAMIC_YEAR"));
//                resultInfo.put("CGPA", ocrs.getString("CGPA"));
//                resultInfo.put("GRADE_PT", ocrs.getString("GRADE_PT"));
            //resultInfo.put("STATUS", ocrs.getString("STATUS"));
//                IntSuccLists.add(resultInfo);
            }
            return enrolledOrNot;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }

    public ArrayList<EducationPaymentModel> getAllCourseList(String requesterId) {
        ArrayList<EducationPaymentModel> CourseLists = new ArrayList<EducationPaymentModel>();
        try {
            ResultSet _rs = educationPaymentRequestEntity.selectAllBenefitTypes(requesterId);
            while (_rs.next()) {
                EducationPaymentModel benefitTypeModel = new EducationPaymentModel();
                //benefitTypeModel.setEducationRequestId(_rs.getInt("EDUC_REQ_ID"));
                benefitTypeModel.setEducationPaymentId(_rs.getInt("ID"));
                benefitTypeModel.setInstitutionName(_rs.getString("INSTITUTION_NAME"));
                benefitTypeModel.setCourseCode(_rs.getString("COURSE_CODE"));
                benefitTypeModel.setGradept(_rs.getString("GRADE_PT"));
                benefitTypeModel.setCreditHr(_rs.getString("CREDIT_HOUR"));
                benefitTypeModel.setAcademicYear(_rs.getString("ACADAMIC_YEAR"));
                //benefitTypeModel.setCourseName(_rs.getString("COURSE_NAME"));
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
}
