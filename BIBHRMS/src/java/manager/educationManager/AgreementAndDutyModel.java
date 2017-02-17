/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

/**
 *
 * @author mekete
 */
public class AgreementAndDutyModel {

    int institutionId;
    String institutionName;
    String institutionDescription;
    String educationOrTraining;
    String accreditedOrNot;
    String tinNumber;
    String locationCategory;
    String locationDescription;
    String contactPerson;
    String phoneNomber;
    String emailAddress;
    String faxNumber;
    String webSite;
    String remark;
    String status;
    String userName;
    String timeStamp;
    String deneyOrApprove;
    int serviceYear;
    String garduationDate;
    String requesterId;
    int educRequestId;
    String applideDate;
int dutyId;
    public AgreementAndDutyModel() {
    }

    public AgreementAndDutyModel(String institutionName, String institutionDescription, String educationOrTraining, String accreditedOrNot, String tinNumber, String locationCategory, String locationDescription, String contactPerson, String phoneNomber, String emailAddress, String faxNumber, String webSite, String remark) {
        this.institutionName = institutionName;
        this.institutionDescription = institutionDescription;
        this.educationOrTraining = educationOrTraining;
        this.accreditedOrNot = accreditedOrNot;
        this.tinNumber = tinNumber;
        this.locationCategory = locationCategory;
        this.locationDescription = locationDescription;
        this.contactPerson = contactPerson;
        this.phoneNomber = phoneNomber;
        this.emailAddress = emailAddress;
        this.faxNumber = faxNumber;
        this.webSite = webSite;
        this.remark = remark;
    }

    public AgreementAndDutyModel(int institutionId, String institutionName, String institutionDescription, String educationOrTraining, String accreditedOrNot, String tinNumber, String locationCategory, String locationDescription, String contactPerson, String phoneNomber, String emailAddress, String faxNumber, String webSite, String remark) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionDescription = institutionDescription;
        this.educationOrTraining = educationOrTraining;
        this.accreditedOrNot = accreditedOrNot;
        this.tinNumber = tinNumber;
        this.locationCategory = locationCategory;
        this.locationDescription = locationDescription;
        this.contactPerson = contactPerson;
        this.phoneNomber = phoneNomber;
        this.emailAddress = emailAddress;
        this.faxNumber = faxNumber;
        this.webSite = webSite;
        this.remark = remark;
    }

public AgreementAndDutyModel(  String institutionName, String institutionDescription, String educationOrTraining, String accreditedOrNot, String tinNumber, String locationCategory, String locationDescription, String contactPerson, String phoneNomber, String emailAddress, String faxNumber, String webSite, String remark, String status, String userName, String timeStamp) {

        this.institutionName = institutionName;
        this.institutionDescription = institutionDescription;
        this.educationOrTraining = educationOrTraining;
        this.accreditedOrNot = accreditedOrNot;
        this.tinNumber = tinNumber;
        this.locationCategory = locationCategory;
        this.locationDescription = locationDescription;
        this.contactPerson = contactPerson;
        this.phoneNomber = phoneNomber;
        this.emailAddress = emailAddress;
        this.faxNumber = faxNumber;
        this.webSite = webSite;
        this.remark = remark;
        this.status = status;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    public AgreementAndDutyModel(int institutionId, String institutionName, String institutionDescription, String educationOrTraining, String accreditedOrNot, String tinNumber, String locationCategory, String locationDescription, String contactPerson, String phoneNomber, String emailAddress, String faxNumber, String webSite, String remark, String status, String userName, String timeStamp) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionDescription = institutionDescription;
        this.educationOrTraining = educationOrTraining;
        this.accreditedOrNot = accreditedOrNot;
        this.tinNumber = tinNumber;
        this.locationCategory = locationCategory;
        this.locationDescription = locationDescription;
        this.contactPerson = contactPerson;
        this.phoneNomber = phoneNomber;
        this.emailAddress = emailAddress;
        this.faxNumber = faxNumber;
        this.webSite = webSite;
        this.remark = remark;
        this.status = status;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    AgreementAndDutyModel(String requesterId, int educationRequestId, int serviceYear, String deneyOrApprove, String reasonDescription, String garduationDate, String appliedDate, String userName, String timeStamp) {
        this.requesterId=requesterId;
        this.educRequestId=educationRequestId;
        this.serviceYear=serviceYear;
        this.deneyOrApprove=deneyOrApprove;
        this.remark=reasonDescription;
        this.garduationDate=garduationDate;
        this.applideDate=appliedDate;
        this.userName=userName;
        this.timeStamp=timeStamp;
    }

    AgreementAndDutyModel(int dutyId, String requesterId, int educationRequestId, int serviceYear, String deneyOrApprove, String reasonDescription, String garduationDate, String appliedDate, String userName, String timeStamp) {
        this.dutyId=dutyId;
        this.requesterId=requesterId;
        this.educRequestId=educationRequestId;
        this.serviceYear=serviceYear;
        this.deneyOrApprove=deneyOrApprove;
        this.remark=reasonDescription;
        this.garduationDate=garduationDate;
        this.applideDate=appliedDate;
        this.userName=userName;
        this.timeStamp=timeStamp;
    }
    public String getAccreditedOrNot() {
        return accreditedOrNot;
    }
    public void setAccreditedOrNot(String accreditedOrNot) {
        this.accreditedOrNot = accreditedOrNot;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getLocationCategory() {
        return locationCategory;
    }

    public String getApplideDate() {
        return applideDate;
    }

    public void setApplideDate(String applideDate) {
        this.applideDate = applideDate;
    }

    public int getEducRequestId() {
        return educRequestId;
    }

    public void setEducRequestId(int educRequestId) {
        this.educRequestId = educRequestId;
    }

    public void setLocationCategory(String locationCategory) {
        this.locationCategory = locationCategory;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public int getDutyId() {
        return dutyId;
    }

    public void setDutyId(int dutyId) {
        this.dutyId = dutyId;
    }

    public String getDeneyOrApprove() {
        return deneyOrApprove;
    }

    public void setDeneyOrApprove(String deneyOrApprove) {
        this.deneyOrApprove = deneyOrApprove;
    }

    public String getGarduationDate() {
        return garduationDate;
    }



    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public void setGarduationDate(String garduationDate) {
        this.garduationDate = garduationDate;
    }

    public int getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(int serviceYear) {
        this.serviceYear = serviceYear;
    }

   

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEducationOrTraining() {
        return educationOrTraining;
    }

    public void setEducationOrTraining(String educationOrTraining) {
        this.educationOrTraining = educationOrTraining;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionDescription() {
        return institutionDescription;
    }

    public void setInstitutionDescription(String institutionDescription) {
        this.institutionDescription = institutionDescription;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getPhoneNomber() {
        return phoneNomber;
    }

    public void setPhoneNomber(String phoneNomber) {
        this.phoneNomber = phoneNomber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
