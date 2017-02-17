/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

import entity.educationEntity.InstitutionRegistrationEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class InstitutionRegistrationManager {

    String userName;
    String loggedInEmployeeId;
    InstitutionModel institutionModel;
    InstitutionRegistrationEntity institutionRegistrationEntity = new InstitutionRegistrationEntity();

    public boolean saveInstitution(String institutionName, String institutionDescription, String educationOrTraining, String accreditedOrNot, String tinNumber, String locationCategory, String locationDescription, String contactPerson, String phoneNomber, String emailAddress, String faxNumber, String webSite, String remark, String status) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        institutionModel = new InstitutionModel(institutionName, institutionDescription, educationOrTraining, accreditedOrNot, tinNumber, locationCategory, locationDescription, contactPerson, phoneNomber, emailAddress, faxNumber, webSite, remark, status, userName, timeStamp);
        try {
            institutionRegistrationEntity.insertInstitution(institutionModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateInstitution(int institutionId, String institutionName, String institutionDescription, String educationOrTraining, String accreditedOrNot, String tinNumber, String locationCategory, String locationDescription, String contactPerson, String phoneNomber, String emailAddress, String faxNumber, String webSite, String remark, String status) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        institutionModel = new InstitutionModel(institutionId, institutionName, institutionDescription, educationOrTraining, accreditedOrNot, tinNumber, locationCategory, locationDescription, contactPerson, phoneNomber, emailAddress, faxNumber, webSite, remark, status, userName, timeStamp);
        try {
            institutionRegistrationEntity.updateInstitution(institutionModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean deleteEducationRequest(int institutionId) {
        try {
            institutionRegistrationEntity.deleteInstitution(institutionId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public InstitutionModel getInstitution(int institutionId) {
        institutionModel = new InstitutionModel();
        try {
            ResultSet _rs = institutionRegistrationEntity.selectInstitution(institutionId);
            if (_rs.next()) {
                institutionModel.setInstitutionId(institutionId);
                institutionModel.setInstitutionName(_rs.getString("INSTITUTION_NAME"));
                institutionModel.setInstitutionDescription(_rs.getString("INSTITUTION_DESCRIPTION"));
                institutionModel.setEducationOrTraining(_rs.getString("EDUCATION_OR_TRAINING"));
                institutionModel.setAccreditedOrNot(_rs.getString("ACCREDITED_OR_NOT"));
                institutionModel.setTinNumber(_rs.getString("TIN_NUMBER"));
                institutionModel.setLocationCategory(_rs.getString("LOCATION_CATEGORY"));
                institutionModel.setLocationDescription(_rs.getString("LOCATION_DESCRIPTION"));
                institutionModel.setContactPerson(_rs.getString("CONTACT_PERSON"));
                institutionModel.setPhoneNomber(_rs.getString("PHONE_NUMBER"));
                institutionModel.setFaxNumber(_rs.getString("FAX_NUMBER"));
                institutionModel.setEmailAddress(_rs.getString("EMAIL_ADDRESS"));
                institutionModel.setWebSite(_rs.getString("WEB_SITE"));
                institutionModel.setRemark(_rs.getString("REMARK"));
                institutionModel.setStatus(_rs.getString("STATUS"));
                institutionModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                institutionModel.setUserName(_rs.getString("USER_NAME"));
            } else {
                institutionModel.setInstitutionId(-1);
            }
            _rs.close();
            return institutionModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllInstitutions() {
        ArrayList<SelectItem> institutionList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = institutionRegistrationEntity.selectInstitution();
            while (_rs.next()) {
                SelectItem currentInstitution = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                institutionList.add(currentInstitution);
            }
            _rs.close();
            return institutionList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getActiveTrainingInstitutions() {
        ArrayList<SelectItem> institutionList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = institutionRegistrationEntity.selectActiveTrainingInstitution();
            institutionList.add(new SelectItem("-1", "--SELECT INSTITUTIONS--"));
            while (_rs.next()) {
                SelectItem currentInstitution = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                institutionList.add(currentInstitution);
            }
            _rs.close();
            return institutionList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getOutsideTrainingInstitutions() {
        ArrayList<SelectItem> institutionList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = institutionRegistrationEntity.selectOutsideTrainingInstitution();
            institutionList.add(new SelectItem("-1", "--SELECT INSTITUTION--"));
            while (_rs.next()) {
                SelectItem currentInstitution = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                institutionList.add(currentInstitution);
            }
            _rs.close();
            return institutionList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllEducationInstitutions() {
        ArrayList<SelectItem> institutionList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = institutionRegistrationEntity.selectEducationInstitution();
            while (_rs.next()) {
                SelectItem currentInstitution = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                institutionList.add(currentInstitution);
            }
            _rs.close();
            return institutionList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllTrainingInstitutions() {
        ArrayList<SelectItem> institutionList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = institutionRegistrationEntity.selectTrainingInstitution();
            institutionList.add(new SelectItem("-1", "--SELECT INSTITUTION--"));
            while (_rs.next()) {
                SelectItem currentInstitution = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                institutionList.add(currentInstitution);
            }
            _rs.close();
            return institutionList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getStatusList() {
        ArrayList<SelectItem> statusList = new ArrayList<SelectItem>();
        try {
            statusList.add(new SelectItem("-1", "--SELECT--"));
            statusList.add(new SelectItem("AC", "Inactive"));
            statusList.add(new SelectItem("IN", "Active"));
            return statusList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAccreditionList() {
        ArrayList<SelectItem> statusList = new ArrayList<SelectItem>();
        try {
            statusList.add(new SelectItem("-1", "--SELECT--"));
            statusList.add(new SelectItem("AC", "Accredirted"));
            statusList.add(new SelectItem("IN", "Not Accredited"));
            statusList.add(new SelectItem("UN", "Unknown"));
            return statusList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getLocationCategoryList() {
        ArrayList<SelectItem> statusList = new ArrayList<SelectItem>();
        try {
            statusList.add(new SelectItem("-1", "--SELECT--"));
            statusList.add(new SelectItem("IN", "In Ethiopia"));
            statusList.add(new SelectItem("OUT", "Outside EThiopia"));
            statusList.add(new SelectItem("MCE", "Inside MCE"));
            return statusList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getEducationOrTrainingList() {
        ArrayList<SelectItem> statusList = new ArrayList<SelectItem>();
        try {
            statusList.add(new SelectItem("-1", "--SELECT--"));
            statusList.add(new SelectItem("TRAI", "Training Only"));
            statusList.add(new SelectItem("EDUC", "Education Only"));
            statusList.add(new SelectItem("BOTH", "Both Training and Education"));
            return statusList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllInstitutionDropDown() {
        ArrayList<SelectItem> institutionList = new ArrayList<SelectItem>();
        try {
            institutionList.add(new SelectItem("-1", "--SELECT--"));
            ResultSet _rs = institutionRegistrationEntity.selectInstitution();
            while (_rs.next()) {
                SelectItem currentInstitution = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                institutionList.add(currentInstitution);
            }
            _rs.close();
            return institutionList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
