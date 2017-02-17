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
import entity.educationEntity.AgreementDutyEntity;
import java.util.HashMap;

/**
 *
 * @author mekete
 */
public class AgreementDutyManager {

    String userName;
    String loggedInEmployeeId;
    InstitutionModel institutionModel;
    AgreementAndDutyModel agreementAndDutyModel;
    InstitutionRegistrationEntity institutionRegistrationEntity = new InstitutionRegistrationEntity();
    AgreementDutyEntity agreementDutyEntity=new AgreementDutyEntity();

    public AgreementAndDutyModel getAgreementAndDutyModel() {
        return agreementAndDutyModel;
    }

    public void setAgreementAndDutyModel(AgreementAndDutyModel agreementAndDutyModel) {
        this.agreementAndDutyModel = agreementAndDutyModel;
    }

    public AgreementDutyEntity getAgreementDutyEntity() {
        return agreementDutyEntity;
    }

    public void setAgreementDutyEntity(AgreementDutyEntity agreementDutyEntity) {
        this.agreementDutyEntity = agreementDutyEntity;
    }

    public InstitutionModel getInstitutionModel() {
        return institutionModel;
    }

    public void setInstitutionModel(InstitutionModel institutionModel) {
        this.institutionModel = institutionModel;
    }

    public InstitutionRegistrationEntity getInstitutionRegistrationEntity() {
        return institutionRegistrationEntity;
    }

    public void setInstitutionRegistrationEntity(InstitutionRegistrationEntity institutionRegistrationEntity) {
        this.institutionRegistrationEntity = institutionRegistrationEntity;
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

   
    public boolean saveInstitution(String requesterId, int educationRequestId, int serviceYear, String deneyOrApprove, String reasonDescription, String garduationDate, String appliedDate) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        agreementAndDutyModel = new AgreementAndDutyModel(requesterId, educationRequestId, serviceYear, deneyOrApprove, reasonDescription, garduationDate,  appliedDate, userName, timeStamp);
        try {
            agreementDutyEntity.insertInstitution(agreementAndDutyModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean updateInstitution(int dutyId, String requesterId, int educationRequestId, int serviceYear, String deneyOrApprove, String reasonDescription, String garduationDate, String appliedDate) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        agreementAndDutyModel = new AgreementAndDutyModel(dutyId,requesterId, educationRequestId, serviceYear, deneyOrApprove, reasonDescription, garduationDate,  appliedDate, userName, timeStamp);
        try {
            agreementDutyEntity.updateInstitution(agreementAndDutyModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean deleteEducationRequest(int dutyId) {
        try {
            agreementDutyEntity.deleteInstitution(dutyId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

     public ArrayList<SelectItem> getMyRequestsHistory() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = agreementDutyEntity.selectEducationRequestHistory(userName);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("DUTY_ID")+ "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("EDUC_REQU_ID"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("CURRENT_DATE"));
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
 public HashMap readEmployeeBasicInfo(String employeeId) {
        try {
            return agreementDutyEntity.readEmployeeBasicInfoFromId(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
      public AgreementAndDutyModel getEducationRequest(int requestId) {
        agreementAndDutyModel = new AgreementAndDutyModel();
        try {
            ResultSet _rs = agreementDutyEntity.selectEducationRequest(requestId);
            if (_rs.next()) {

                agreementAndDutyModel.setDutyId(requestId);
                agreementAndDutyModel.setRequesterId(_rs.getString("REQUESTER_ID"));

              
                agreementAndDutyModel.setEducRequestId(_rs.getInt("EDUC_REQU_ID"));
                agreementAndDutyModel.setServiceYear(_rs.getInt("DUTY_SERVICE_YR"));
                agreementAndDutyModel.setGarduationDate(_rs.getString("GRADUATION_DATE"));
                agreementAndDutyModel.setApplideDate(_rs.getString("CURRENT_DATE"));
                agreementAndDutyModel.setDeneyOrApprove(_rs.getString("APPROVE_DENY"));
                agreementAndDutyModel.setRemark(_rs.getString("REMARK"));                        
                agreementAndDutyModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                agreementAndDutyModel.setUserName(_rs.getString("USER_NAME"));
                


            } else {
                agreementAndDutyModel.setDutyId(-1);
            }
            _rs.close();
            return agreementAndDutyModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
