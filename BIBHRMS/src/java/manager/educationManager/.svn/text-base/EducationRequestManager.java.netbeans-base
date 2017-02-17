/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

import com.sun.webui.jsf.model.Option;
import entity.educationEntity.EducationRequestEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.LookUpManager;

/**
 *
 * @author mekete
 */
public class EducationRequestManager {

    String userName;
    String loggedInEmployeeId;
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationRequestEntity educationRequestEntity = new EducationRequestEntity();

    public ArrayList<SelectItem> getEducationShift() {
        ArrayList<SelectItem> shiftLists = new ArrayList<SelectItem>();
        try {
            shiftLists.add(new SelectItem(null, "--Select Shift--"));
            shiftLists.add(new SelectItem("SPR", "On spare time"));
            shiftLists.add(new SelectItem("REG", "Regular"));
            shiftLists.add(new SelectItem("SUM", "Summer"));
            shiftLists.add(new SelectItem("DIS", "Distance"));
            return shiftLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getEducationTypeCatagories() {
        return (new LookUpManager()).readAllEducationCatagories();
    }

    public ArrayList<SelectItem> getEducationLevels() {
        try {
            return (new LookUpManager()).readEducationLevel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<SelectItem> getPendingRequests() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationRequestEntity.selectPendingEducationRequests(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
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

    public ArrayList<SelectItem> getNAmeOfInstitution() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();

        try {
            ResultSet _rs = educationRequestEntity.selectNameOfInstitution();

            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                requestLists.add(currentRequest);
            }
            requestLists.add(0, new Option(null, "--Select Name Of Institution--"));
            _rs.close();

            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

//    public ArrayList<SelectItem> getprogramName(String categoryID) {
//        ArrayList<SelectItem> programtLists = new ArrayList<SelectItem>();
//        try {
//            ResultSet _rs = educationRequestEntity.selectProgramName(categoryID);
//
//            while (_rs.next()) {
//                SelectItem currentRequest = new SelectItem(_rs.getString("EDU_TYPE_NAME"));
//                programtLists.add(currentRequest);
//            }
//            programtLists.add(0, new Option(null, "--Select Progarme Name--"));
//            _rs.close();
//
//            return programtLists;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }
    public ArrayList<SelectItem> getprogramCategory() {
        ArrayList<SelectItem> programtLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationRequestEntity.selectProgramCAtagory();

            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUC_CATAGORY_ID") + "-" + _rs.getString("CATAGORY_NAME"), _rs.getString("CATAGORY_NAME"));
                programtLists.add(currentRequest);
            }
            programtLists.add(0, new Option(null, "--Select Progarme Category Name--"));
            _rs.close();

            return programtLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getInstituAdress(String institiId) {
        String adress = null;

        try {
            ResultSet _rs = educationRequestEntity.selectInstitutionAdress(institiId);
            while (_rs.next()) {
                adress = ("Contact Person-" + _rs.getString("CONTACT_PERSON") + ", Phone No-" + _rs.getString("PHONE_NUMBER") + ", email Add-" + _rs.getString("EMAIL_ADDRESS") + ", Fax Num-" + _rs.getString("FAX_NUMBER"));


            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return adress;

    }

    public String getTypeOFAccredated(String institiId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = educationRequestEntity.selectTypeOFAccredated(institiId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("ACCREDITED_OR_NOT");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return typeOFAccredated;

    }

    public String getTypeOFInstName(String institiId) {
        String instName = null;

        try {
            ResultSet _rs = educationRequestEntity.selectTypeOFAccredated(institiId);
            while (_rs.next()) {
                instName = _rs.getString("INSTITUTION_NAME");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return instName;

    }

    public String getDateOfBirth(String empId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = educationRequestEntity.selectDateoFbirth(empId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("DATE_OF_BIRTH");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return typeOFAccredated;

    }

    public HashMap getEducationDuty(String employeeId) {
        try {
            return educationRequestEntity.selectEducationDuty(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getEducationalStatus(String educationRequest) {
        String typeOFAccredated = null;
        try {
            ResultSet _rs = educationRequestEntity.selectEducaStatu(educationRequest);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("EDUCATIONAL_STATUS");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return typeOFAccredated;
    }

    public String getEducationalChangeInst(String educationRequest) {
        String typeOFAccredated = null;
        try {
            ResultSet _rs = educationRequestEntity.selectEducaChageInst(educationRequest);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("CHANGE_INSTITUTION");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return typeOFAccredated;
    }

    public String getHIREDATE(String empId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = educationRequestEntity.selectHireDate(empId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("HIRE_DATE");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return typeOFAccredated;

    }

    public String getInsideOutside(String institiId) {
        String insideOutSide = null;

        try {
            ResultSet _rs = educationRequestEntity.selectTypeOFAccredated(institiId);
            while (_rs.next()) {
                insideOutSide = _rs.getString("LOCATION_CATEGORY");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return insideOutSide;

    }

    public ArrayList<SelectItem> getEducationalStatus() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationRequestEntity.selectEducationalStatus();

            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUCATIONAL_STATUS"));
                requestLists.add(currentRequest);
            }
            requestLists.add(0, new Option(null, "--Select Educational Status --"));
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
            ResultSet _rs = educationRequestEntity.selectEducationRequestHistory(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("EDUCATION_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
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

    public EducationRequestModel getEducationRequest(int requestId) {
        educationRequestModel = new EducationRequestModel();
        try {
            ResultSet _rs = educationRequestEntity.selectEducationRequest(requestId);
            if (_rs.next()) {

                educationRequestModel.setEducationRequestId(requestId);
                educationRequestModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                educationRequestModel.setEducationProgramName(_rs.getString("EDUCATION_PROGRAM_NAME"));
                educationRequestModel.setEducationLevelCategory(_rs.getString("EDUCATION_LEVEL_CATEGORY"));
                educationRequestModel.setEducationShiftCategory(_rs.getString("EDUCATION_SHIFT_CATEGORY"));
                educationRequestModel.setStartDate(_rs.getString("START_DATE"));
                educationRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                educationRequestModel.setDurationInYear(_rs.getDouble("DURATION_IN_YEAR"));
                educationRequestModel.setReasonDescription(_rs.getString("REASON_DESCRIPTION"));
                educationRequestModel.setInstitutionName(_rs.getString("INSTITUTION_NAME"));
                educationRequestModel.setCostPerCreditHour(_rs.getDouble("COST_PER_CREDIT_HOUR"));
                educationRequestModel.setNumberOfCreditHours(_rs.getInt("NUMBER_OF_CREDIT_HOURS"));
                educationRequestModel.setTotalAdminstrationCosts(_rs.getDouble("TOTAL_ADMIN_COSTS"));
                educationRequestModel.setDocumentReferenceNumber(_rs.getString("DOCUMENT_REFERENCE_NUMBER"));
                educationRequestModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));
                educationRequestModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                educationRequestModel.setUserName(_rs.getString("USER_NAME"));
                educationRequestModel.setEndDate(_rs.getString("END_DATE"));
                educationRequestModel.setEducatinalStatus(_rs.getString("EDUCATIONAL_STATUS"));
                educationRequestModel.setLevelID(_rs.getString("EDU_LEVEL_ID"));
                educationRequestModel.setAllOrSecifyProgram(_rs.getString("ALL_SEPECIFY_PROGRAM"));
                educationRequestModel.setChangeInstStatus(_rs.getString("CHANGE_INSTITUTION"));


            } else {
                educationRequestModel.setEducationRequestId(-1);
            }
            _rs.close();
            return educationRequestModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
///================================================================

    public EducationRequestModel getEducationChangInsRequest(String requesterId) {
        educationRequestModel = new EducationRequestModel();
        try {
            ResultSet _rs = educationRequestEntity.selectEducationChangeInsRequest(requesterId);
            if (_rs.next()) {

                educationRequestModel.setRequesterId(requesterId);
                educationRequestModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                // educationRequestModel.setEducationTypeCategory(_rs.getString("EDUCATION_TYPE_CATEGORY"));
                educationRequestModel.setEducationProgramName(_rs.getString("EDUCATION_PROGRAM_NAME"));
                educationRequestModel.setEducationLevelCategory(_rs.getString("EDUCATION_LEVEL_CATEGORY"));
                educationRequestModel.setEducationShiftCategory(_rs.getString("EDUCATION_SHIFT_CATEGORY"));
                educationRequestModel.setStartDate(_rs.getString("START_DATE"));
                educationRequestModel.setEndDate(_rs.getString("END_DATE"));
                educationRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                educationRequestModel.setDurationInYear(_rs.getDouble("DURATION_IN_YEAR"));
                educationRequestModel.setReasonDescription(_rs.getString("REASON_DESCRIPTION"));
                educationRequestModel.setInstitutionName(_rs.getString("INSTITUTION_NAME"));
                // educationRequestModel.setInstitutionAccredited(_rs.getString("INSTITUTION_ACCREDITED"));
                // educationRequestModel.setEthiopianInstitution(_rs.getString("ETHIOPIAN_INSTITUTION"));
                // educationRequestModel.setInstitutionAddress(_rs.getString("INSTITUTION_ADDRESS"));
                educationRequestModel.setCostPerCreditHour(_rs.getDouble("COST_PER_CREDIT_HOUR"));
                educationRequestModel.setNumberOfCreditHours(_rs.getInt("NUMBER_OF_CREDIT_HOURS"));
                educationRequestModel.setTotalAdminstrationCosts(_rs.getDouble("TOTAL_ADMIN_COSTS"));

                educationRequestModel.setDocumentReferenceNumber(_rs.getString("DOCUMENT_REFERENCE_NUMBER"));
                educationRequestModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));
                educationRequestModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                educationRequestModel.setUserName(_rs.getString("USER_NAME"));
                educationRequestModel.setEducatinalStatus(_rs.getString("EDUCATIONAL_STATUS"));
                educationRequestModel.setDateOfStatusUpdate(_rs.getString("DATE_UPDATE_EDU_STATUS"));
                educationRequestModel.setEducationRequestId(_rs.getInt("EDUCATION_REQUEST_ID"));

            } else {
                educationRequestModel.setEducationRequestId(-1);
            }
            _rs.close();
            return educationRequestModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    //============================================

    public boolean saveEducationRequest(String requesterId, String educationProgramName, String institutionName, String ethiopianInstitution, String institutionAccredited, String institutionAddress, String startDate, String appliedDate, String educationShiftCategory, String educationLevelCategory, double costPerCreditHour, int numberOfCreditHours, double totalAdminstrationCosts, double durationInYear, String reasonDescription, String documentReferenceNumber, String requestStatus, String dateofEducatn, String educationStatus, String enddate, String levelID, String allOrSecifyProgram) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();

        educationRequestModel = new EducationRequestModel(requesterId, educationProgramName, institutionName, ethiopianInstitution, institutionAccredited, institutionAddress, startDate, appliedDate, educationShiftCategory, educationLevelCategory, costPerCreditHour, numberOfCreditHours, totalAdminstrationCosts, durationInYear, reasonDescription, documentReferenceNumber, EducationApproveManager.INITIAL_STATE_EDUCATION, timeStamp, userName, educationStatus, dateofEducatn, enddate, levelID, allOrSecifyProgram);

        try {
            educationRequestEntity.insertEducationRequest(educationRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateEducationRequest(int educationRequestId, String requesterId, String educationProgramName, String institutionName, String ethiopianInstitution, String institutionAccredited, String institutionAddress, String startDate, String applieddate, String educationShiftCategory, String educationLevelCategory, double costPerCreditHour, int numberOfCreditHours, double totalAdminstrationCosts, double durationInYear, String reasonDescription, String documentReferenceNumber, String requestStatus, String endDate, String levelID, String allOrSecifyProgram) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        educationRequestModel = new EducationRequestModel(educationRequestId, requesterId, educationProgramName, institutionName, ethiopianInstitution, institutionAccredited, institutionAddress, startDate, applieddate, educationShiftCategory, educationLevelCategory, costPerCreditHour, numberOfCreditHours, totalAdminstrationCosts, durationInYear, reasonDescription, documentReferenceNumber, EducationApproveManager.INITIAL_STATE_EDUCATION, timeStamp, userName, endDate, levelID, allOrSecifyProgram);
        try {
            educationRequestEntity.updateEducationRequest(educationRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateEducationStatus(String reasonOfChang, int educationRequestId, String requesterId, String educatinalStatus, String dateOfStatusUpdate, String requestStatus) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        educationRequestModel = new EducationRequestModel(reasonOfChang, educationRequestId, requesterId, educatinalStatus, dateOfStatusUpdate, EducationApproveManager.INITIAL_STATE_EDUCATION, timeStamp, userName);
        try {
            educationRequestEntity.updateEducationStatus(educationRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean deleteEducationRequest(int educationRequestId) {
        try {
            educationRequestEntity.deleteEducationRequest(educationRequestId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
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

    public ArrayList<SelectItem> readEducationLevel(int rank) {
        try {
            ArrayList<EducationRequestEntity> eduLevelList = educationRequestEntity.readEducationLevel(rank);
            ArrayList<SelectItem> educationOpt = new ArrayList<SelectItem>();//("Select Education Level");
            if (eduLevelList.size() > 0) {
                for (int i = 0; i <
                        eduLevelList.size(); i++) {
                    educationRequestEntity = eduLevelList.get(i);
                    educationOpt.add(new Option(String.valueOf(educationRequestEntity.getTitleDescription())));
                }

                educationOpt.add(0, new Option(null, "Select Education Level"));
            } else {
                educationOpt.add(0, new Option(null, "Not Available Education Level"));
            }

            return educationOpt;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> readDrivingSkill(int rank) {
        try {
            ArrayList<EducationRequestEntity> eduLevelList = educationRequestEntity.readDrivingLevel(rank);
            ArrayList<SelectItem> educationOpt = new ArrayList<SelectItem>();//("Select Education Level");
            if (eduLevelList.size() > 0) {
                for (int i = 0; i <
                        eduLevelList.size(); i++) {
                    educationRequestEntity = eduLevelList.get(i);
                    educationOpt.add(new Option(String.valueOf(educationRequestEntity.getTitleDescription())));
                }

                educationOpt.add(0, new Option(null, "Select Education Level"));
            } else {
                educationOpt.add(0, new Option(null, "Not Available Education Level"));
            }

            return educationOpt;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> readHigherEducationLevel(int rank) {
        try {
            ArrayList<EducationRequestEntity> eduLevelList = educationRequestEntity.readHigherEducationLevel(rank);
            ArrayList<SelectItem> educationOpt = new ArrayList<SelectItem>();//("Select Education Level");
            if (eduLevelList.size() > 0) {
                for (int i = 0; i <
                        eduLevelList.size(); i++) {
                    educationRequestEntity = eduLevelList.get(i);
                    educationOpt.add(new Option(String.valueOf((String.valueOf(educationRequestEntity.getTitleDescription())))));
                }

                educationOpt.add(0, new Option(null, "Select Education Level"));
            } else {
                educationOpt.add(0, new Option(null, "Not Available Education Level"));
            }

            return educationOpt;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> getEducationTypesByCategory(int deptId) {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {

            ResultSet _rs = educationRequestEntity.selectEducationTypeByCategory(deptId);
            committeeList.add(new SelectItem(null, "--Select Type--"));
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getString("description")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllEducationTypesByCategory() {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {

            ResultSet _rs = educationRequestEntity.selectAllEducationTypeByCategory();
            committeeList.add(new SelectItem(null, "--Select Type--"));
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getString("description")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readEmployeeBasicInfo(String employeeId) {
        try {
            return educationRequestEntity.readEmployeeBasicInfoFromId(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
