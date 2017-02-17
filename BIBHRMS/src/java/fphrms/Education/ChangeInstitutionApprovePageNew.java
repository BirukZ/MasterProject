/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Education;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;

import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.educationManager.EducationApproveManager;
import manager.educationManager.EducationRequestManager;
import manager.educationManager.EducationRequestModel;
import manager.educationManager.ChangeInstitManager;
import manager.educationManager.changeInstituApproveManager;
import manager.educationManager.changeInstitutionRequestModel;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ChangeInstitutionApprovePageNew extends AbstractPageBean {

    private String catID;
    private String takenStartDate;
    private String requesterID;
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        //loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        userName = getSessionBean1().getUserName();
        populateApproverTextComponents(loggedInEmployeeId);
        changeInstitManager.setUserName(userName);
        ChangeInstituApproveManager.setUserName(userName);
        ChangeInstituApproveManager.setLoggedInEmployeeId(loggedInEmployeeId);
        requestListsToBeApproved = ChangeInstituApproveManager.getRequestsToBeProcessed();
        requestHistoryList = ChangeInstituApproveManager.getMyDecisionsOnRequests();
        availableDecisionsToMakeList = ChangeInstituApproveManager.getAvailableDecisionsToMake(requestStatus);
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();
    private DefaultSelectedData selectBooleanCheckbox4Bean = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationShift = new DefaultSelectedData();

    public DefaultSelectedData getSelectObjectOfEducationShift() {
        return selectObjectOfEducationShift;
    }

    public void setSelectObjectOfEducationShift(DefaultSelectedData selectObjectOfEducationShift) {
        this.selectObjectOfEducationShift = selectObjectOfEducationShift;
    }

    public DefaultSelectedData getSelectObjectOfEducationLevelCatagory() {
        return selectObjectOfEducationLevelCatagory;
    }

    public void setSelectObjectOfEducationLevelCatagory(DefaultSelectedData selectObjectOfEducationLevelCatagory) {
        this.selectObjectOfEducationLevelCatagory = selectObjectOfEducationLevelCatagory;
    }

    public DefaultSelectedData getSelectObjectOfEducationShiftCatagory() {
        return selectObjectOfEducationShiftCatagory;
    }

    public void setSelectObjectOfEducationShiftCatagory(DefaultSelectedData selectObjectOfEducationShiftCatagory) {
        this.selectObjectOfEducationShiftCatagory = selectObjectOfEducationShiftCatagory;
    }

    public DefaultSelectedData getSelectObjectOfEducationTypeCatagory() {
        return selectObjectOfEducationTypeCatagory;
    }

    public void setSelectObjectOfEducationTypeCatagory(DefaultSelectedData selectObjectOfEducationTypeCatagory) {
        this.selectObjectOfEducationTypeCatagory = selectObjectOfEducationTypeCatagory;
    }

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public HtmlOutputText getOutputTextConfirmDelete() {
        return outputTextConfirmDelete;
    }

    public ChangeInstitManager getChangeInstitManager() {
        return changeInstitManager;
    }

    public void setChangeInstitManager(ChangeInstitManager changeInstitManager) {
        this.changeInstitManager = changeInstitManager;
    }

    public ArrayList<SelectItem> getEducationLevelCatagoryListprev() {
        return educationLevelCatagoryListprev;
    }

    public void setEducationLevelCatagoryListprev(ArrayList<SelectItem> educationLevelCatagoryListprev) {
        this.educationLevelCatagoryListprev = educationLevelCatagoryListprev;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public void setOutputTextConfirmDelete(HtmlOutputText outputTextConfirmDelete) {
        this.outputTextConfirmDelete = outputTextConfirmDelete;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData selectBooleanCheckbox1Bean) {
        this.selectBooleanCheckbox1Bean = selectBooleanCheckbox1Bean;
    }

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData selectBooleanCheckbox2Bean) {
        this.selectBooleanCheckbox2Bean = selectBooleanCheckbox2Bean;
    }

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData selectBooleanCheckbox3Bean) {
        this.selectBooleanCheckbox3Bean = selectBooleanCheckbox3Bean;
    }

    public DefaultSelectedData getSelectBooleanCheckbox4Bean() {
        return selectBooleanCheckbox4Bean;
    }

    public void setSelectBooleanCheckbox4Bean(DefaultSelectedData selectBooleanCheckbox4Bean) {
        this.selectBooleanCheckbox4Bean = selectBooleanCheckbox4Bean;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems2 = dsi;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }
    private HtmlInputText txtRequesterDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment() {
        return txtRequesterDepartment;
    }

    public void setTxtRequesterDepartment(HtmlInputText hit) {
        this.txtRequesterDepartment = hit;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calDate = new SelectInputDate();
    private SelectInputDate calAppliedDateNew = new SelectInputDate();
    private SelectInputDate calStartDateNEw = new SelectInputDate();

    public SelectInputDate getCalDate() {
        return calDate;
    }

    public SelectInputDate getCalAppliedDateNew() {
        return calAppliedDateNew;
    }

    public void setCalAppliedDateNew(SelectInputDate calAppliedDateNew) {
        this.calAppliedDateNew = calAppliedDateNew;
    }

    public SelectInputDate getCalStartDateNEw() {
        return calStartDateNEw;
    }

    public void setCalStartDateNEw(SelectInputDate calStartDateNEw) {
        this.calStartDateNEw = calStartDateNEw;
    }

    public void setCalDate(SelectInputDate calDate) {
        this.calDate = calDate;
    }

//    public ArrayList<SelectItem> getProgramName() {
//        return programName;
//    }
//
//    public void setProgramName(ArrayList<SelectItem> programName) {
//        this.programName = programName;
//    }
    private HtmlInputTextarea txtaInstitutionName = new HtmlInputTextarea();
    private HtmlCommandButton btnSaveOrUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveOrUpdate() {
        return btnSaveOrUpdate;
    }

    public void setBtnSaveOrUpdate(HtmlCommandButton hcb) {
        this.btnSaveOrUpdate = hcb;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }

    public double getCostPerCreditHour() {
        return costPerCreditHour;
    }

    public void setCostPerCreditHour(double costPerCreditHour) {
        this.costPerCreditHour = costPerCreditHour;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequestList() {
        return decisionsMadeOnRequestList;
    }

    public void setDecisionsMadeOnRequestList(ArrayList<RequestHistoryModel> decisionsMadeOnRequestList) {
        this.decisionsMadeOnRequestList = decisionsMadeOnRequestList;
    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public double getDurationInYear() {
        return durationInYear;
    }

    public void setDurationInYear(double durationInYear) {
        this.durationInYear = durationInYear;
    }

    public String getEducationLevelCategory() {
        return educationLevelCategory;
    }

    public void setEducationLevelCategory(String educationLevelCategory) {
        this.educationLevelCategory = educationLevelCategory;
    }

    public String getEducationProgramName() {
        return educationProgramName;
    }

    public void setEducationProgramName(String educationProgramName) {
        this.educationProgramName = educationProgramName;
    }

    public int getEducationRequestId() {
        return educationRequestId;
    }

    public void setEducationRequestId(int educationRequestId) {
        this.educationRequestId = educationRequestId;
    }

    public EducationRequestManager getEducationRequestManager() {
        return educationRequestManager;
    }

    public void setEducationRequestManager(EducationRequestManager educationRequestManager) {
        this.educationRequestManager = educationRequestManager;
    }

    public EducationRequestModel getEducationRequestModel() {
        return educationRequestModel;
    }

    public void setEducationRequestModel(EducationRequestModel educationRequestModel) {
        this.educationRequestModel = educationRequestModel;
    }

    public String getEducationShiftCategory() {
        return educationShiftCategory;
    }

    public void setEducationShiftCategory(String educationShiftCategory) {
        this.educationShiftCategory = educationShiftCategory;
    }

    public String getEducationTypeCategory() {
        return educationTypeCategory;
    }

    public void setEducationTypeCategory(String educationTypeCategory) {
        this.educationTypeCategory = educationTypeCategory;
    }

    public String getEthiopianInstitution() {
        return ethiopianInstitution;
    }

    public void setEthiopianInstitution(String ethiopianInstitution) {
        this.ethiopianInstitution = ethiopianInstitution;
    }

    public String getInstitutionAccredited() {
        return institutionAccredited;
    }

    public void setInstitutionAccredited(String institutionAccredited) {
        this.institutionAccredited = institutionAccredited;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getNumberOfCreditHours() {
        return numberOfCreditHours;
    }

    public void setNumberOfCreditHours(int numberOfCreditHours) {
        this.numberOfCreditHours = numberOfCreditHours;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public HtmlInputTextarea getTxtaInstitutionName() {
        return txtaInstitutionName;
    }

    public void setTxtaInstitutionName(HtmlInputTextarea txtaInstitutionName) {
        this.txtaInstitutionName = txtaInstitutionName;
    }

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getTotalAdminstrationCosts() {
        return totalAdminstrationCosts;
    }

    public void setTotalAdminstrationCosts(double totalAdminstrationCosts) {
        this.totalAdminstrationCosts = totalAdminstrationCosts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems3 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems3 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private HtmlCommandLink btnClosePopupEducationalStatus = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupEducationalStatus() {
        return btnClosePopupEducationalStatus;
    }

    public void setBtnClosePopupEducationalStatus(HtmlCommandLink hcl) {
        this.btnClosePopupEducationalStatus = hcl;
    }
    private PanelPopup pnlPopupEduactionaStatus = new PanelPopup();

    public PanelPopup getPnlPopupEduactionaStatus() {
        return pnlPopupEduactionaStatus;
    }

    public void setPnlPopupEduactionaStatus(PanelPopup pp) {
        this.pnlPopupEduactionaStatus = pp;
    }
    private SelectInputDate calTakenRevokedStartDate = new SelectInputDate();

    public SelectInputDate getCalTakenRevokedStartDate() {
        return calTakenRevokedStartDate;
    }

    public void setCalTakenRevokedStartDate(SelectInputDate sid) {
        this.calTakenRevokedStartDate = sid;
    }
    private HtmlInputText txtdate = new HtmlInputText();

    public HtmlInputText getTxtdate() {
        return txtdate;
    }

    public void setTxtdate(HtmlInputText hit) {
        this.txtdate = hit;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems6 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems6 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems7 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private HtmlSelectOneMenu drlEducationRegisStatus = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationRegisStatus() {
        return drlEducationRegisStatus;
    }

    public void setDrlEducationRegisStatus(HtmlSelectOneMenu hsom) {
        this.drlEducationRegisStatus = hsom;
    }
    private HtmlOutputLabel lblEduRequestId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblEduRequestId() {
        return lblEduRequestId;
    }

    public void setLblEduRequestId(HtmlOutputLabel hol) {
        this.lblEduRequestId = hol;
    }
    private HtmlOutputLabel lblRequesterID = new HtmlOutputLabel();

    public HtmlOutputLabel getLblRequesterID() {
        return lblRequesterID;
    }

    public void setLblRequesterID(HtmlOutputLabel hol) {
        this.lblRequesterID = hol;
    }
    private HtmlInputText txtAccredNEw = new HtmlInputText();

    public HtmlInputText getTxtAccredNEw() {
        return txtAccredNEw;
    }

    public void setTxtAccredNEw(HtmlInputText hit) {
        this.txtAccredNEw = hit;
    }
    private HtmlInputText txtInsideOutNEw = new HtmlInputText();

    public HtmlInputText getTxtInsideOutNEw() {
        return txtInsideOutNEw;
    }

    public void setTxtInsideOutNEw(HtmlInputText hit) {
        this.txtInsideOutNEw = hit;
    }
    private HtmlInputText txtStartDateNEw = new HtmlInputText();

    public HtmlInputText getTxtStartDateNEw() {
        return txtStartDateNEw;
    }

    public void setTxtStartDateNEw(HtmlInputText hit) {
        this.txtStartDateNEw = hit;
    }
    private HtmlInputText txtTotalAdminstrativeCostNew = new HtmlInputText();

    public HtmlInputText getTxtTotalAdminstrativeCostNew() {
        return txtTotalAdminstrativeCostNew;
    }

    public void setTxtTotalAdminstrativeCostNew(HtmlInputText hit) {
        this.txtTotalAdminstrativeCostNew = hit;
    }
    private HtmlInputText txtNumberOfCreditHoursNew = new HtmlInputText();

    public HtmlInputText getTxtNumberOfCreditHoursNew() {
        return txtNumberOfCreditHoursNew;
    }

    public void setTxtNumberOfCreditHoursNew(HtmlInputText hit) {
        this.txtNumberOfCreditHoursNew = hit;
    }
    private HtmlInputText txtDocumentReferenceNumberNew = new HtmlInputText();

    public HtmlInputText getTxtDocumentReferenceNumberNew() {
        return txtDocumentReferenceNumberNew;
    }

    public void setTxtDocumentReferenceNumberNew(HtmlInputText hit) {
        this.txtDocumentReferenceNumberNew = hit;
    }
    private HtmlInputTextarea txtaInstitutionAddressNew = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaInstitutionAddressNew() {
        return txtaInstitutionAddressNew;
    }

    public void setTxtaInstitutionAddressNew(HtmlInputTextarea hit) {
        this.txtaInstitutionAddressNew = hit;
    }
    private HtmlInputText txtAppliedDateNew = new HtmlInputText();

    public HtmlInputText getTxtAppliedDateNew() {
        return txtAppliedDateNew;
    }

    public void setTxtAppliedDateNew(HtmlInputText hit) {
        this.txtAppliedDateNew = hit;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems9 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems9 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems10 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems10() {
        return selectOneMenu1DefaultItems10;
    }

    public void setSelectOneMenu1DefaultItems10(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems10 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems11 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems11() {
        return selectOneMenu1DefaultItems11;
    }

    public void setSelectOneMenu1DefaultItems11(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems11 = dsia;
    }
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlInputText txtDurationInYearNEw = new HtmlInputText();

    public HtmlInputText getTxtDurationInYearNEw() {
        return txtDurationInYearNEw;
    }

    public void setTxtDurationInYearNEw(HtmlInputText hit) {
        this.txtDurationInYearNEw = hit;
    }
    private HtmlInputText txtCostPerCreditHourNew = new HtmlInputText();

    public HtmlInputText getTxtCostPerCreditHourNew() {
        return txtCostPerCreditHourNew;
    }

    public void setTxtCostPerCreditHourNew(HtmlInputText hit) {
        this.txtCostPerCreditHourNew = hit;
    }
    private HtmlInputTextarea txtRemarkNEw = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemarkNEw() {
        return txtRemarkNEw;
    }

    public void setTxtRemarkNEw(HtmlInputTextarea hit) {
        this.txtRemarkNEw = hit;
    }
    private HtmlInputText txtLevelNew = new HtmlInputText();

    public HtmlInputText getTxtLevelNew() {
        return txtLevelNew;
    }

    public void setTxtLevelNew(HtmlInputText hit) {
        this.txtLevelNew = hit;
    }
    private HtmlInputText txtProgramTypeNew = new HtmlInputText();

    public HtmlInputText getTxtProgramTypeNew() {
        return txtProgramTypeNew;
    }

    public void setTxtProgramTypeNew(HtmlInputText hit) {
        this.txtProgramTypeNew = hit;
    }
    private HtmlInputText txtShiftNew = new HtmlInputText();

    public HtmlInputText getTxtShiftNew() {
        return txtShiftNew;
    }

    public void setTxtShiftNew(HtmlInputText hit) {
        this.txtShiftNew = hit;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlInputText txtDeciderPosition = new HtmlInputText();

    public HtmlInputText getTxtDeciderPosition() {
        return txtDeciderPosition;
    }

    public void setTxtDeciderPosition(HtmlInputText hit) {
        this.txtDeciderPosition = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputText txtRequesterFullName = new HtmlInputText();

    public HtmlInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(HtmlInputText hit) {
        this.txtRequesterFullName = hit;
    }
    private HtmlCommandLink lnkEducationRequest = new HtmlCommandLink();

    public HtmlCommandLink getLnkEducationRequest() {
        return lnkEducationRequest;
    }

    public void setLnkEducationRequest(HtmlCommandLink hcl) {
        this.lnkEducationRequest = hcl;
    }
    private HtmlCommandLink lnkEducationPaymentRequest = new HtmlCommandLink();

    public HtmlCommandLink getLnkEducationPaymentRequest() {
        return lnkEducationPaymentRequest;
    }

    public void setLnkEducationPaymentRequest(HtmlCommandLink hcl) {
        this.lnkEducationPaymentRequest = hcl;
    }
    private HtmlCommandLink lnkEducationApprove = new HtmlCommandLink();

    public HtmlCommandLink getLnkEducationApprove() {
        return lnkEducationApprove;
    }

    public void setLnkEducationApprove(HtmlCommandLink hcl) {
        this.lnkEducationApprove = hcl;
    }
    private HtmlCommandLink lnkEducationPaymentApprove = new HtmlCommandLink();

    public HtmlCommandLink getLnkEducationPaymentApprove() {
        return lnkEducationPaymentApprove;
    }

    public void setLnkEducationPaymentApprove(HtmlCommandLink hcl) {
        this.lnkEducationPaymentApprove = hcl;
    }
    private HtmlCommandLink lnkChangeInstituRequest = new HtmlCommandLink();

    public HtmlCommandLink getLnkChangeInstituRequest() {
        return lnkChangeInstituRequest;
    }

    public void setLnkChangeInstituRequest(HtmlCommandLink hcl) {
        this.lnkChangeInstituRequest = hcl;
    }
    private HtmlCommandLink lnkChangeInstApprove = new HtmlCommandLink();

    public HtmlCommandLink getLnkChangeInstApprove() {
        return lnkChangeInstApprove;
    }

    public void setLnkChangeInstApprove(HtmlCommandLink hcl) {
        this.lnkChangeInstApprove = hcl;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private PanelLayout pnlLayputInstitution2 = new PanelLayout();

    public PanelLayout getPnlLayputInstitution2() {
        return pnlLayputInstitution2;
    }

    public void setPnlLayputInstitution2(PanelLayout pl) {
        this.pnlLayputInstitution2 = pl;
    }
    private HtmlInputText txInstNAme = new HtmlInputText();

    public HtmlInputText getTxInstNAme() {
        return txInstNAme;
    }

    public void setTxInstNAme(HtmlInputText hit) {
        this.txInstNAme = hit;
    }
    private HtmlInputText txtInstNAmePrev = new HtmlInputText();

    public HtmlInputText getTxtInstNAmePrev() {
        return txtInstNAmePrev;
    }

    public void setTxtInstNAmePrev(HtmlInputText hit) {
        this.txtInstNAmePrev = hit;
    }
    private HtmlInputText txtLevelPrev = new HtmlInputText();

    public HtmlInputText getTxtLevelPrev() {
        return txtLevelPrev;
    }

    public void setTxtLevelPrev(HtmlInputText hit) {
        this.txtLevelPrev = hit;
    }
    private HtmlInputText txtProgramNamePrev = new HtmlInputText();

    public HtmlInputText getTxtProgramNamePrev() {
        return txtProgramNamePrev;
    }

    public void setTxtProgramNamePrev(HtmlInputText hit) {
        this.txtProgramNamePrev = hit;
    }
    private HtmlInputText txtShiftPrev = new HtmlInputText();

    public HtmlInputText getTxtShiftPrev() {
        return txtShiftPrev;
    }

    public void setTxtShiftPrev(HtmlInputText hit) {
        this.txtShiftPrev = hit;
    }
    private HtmlInputText txtAppliedDatePrev = new HtmlInputText();

    public HtmlInputText getTxtAppliedDatePrev() {
        return txtAppliedDatePrev;
    }

    public void setTxtAppliedDatePrev(HtmlInputText hit) {
        this.txtAppliedDatePrev = hit;
    }
    private HtmlInputText txtStartDatePrev = new HtmlInputText();

    public HtmlInputText getTxtStartDatePrev() {
        return txtStartDatePrev;
    }

    public void setTxtStartDatePrev(HtmlInputText hit) {
        this.txtStartDatePrev = hit;
    }
    private HtmlInputText txtTotalAdminsPrev = new HtmlInputText();

    public HtmlInputText getTxtTotalAdminsPrev() {
        return txtTotalAdminsPrev;
    }

    public void setTxtTotalAdminsPrev(HtmlInputText hit) {
        this.txtTotalAdminsPrev = hit;
    }
    private HtmlInputText txtDurationInYearPrev = new HtmlInputText();

    public HtmlInputText getTxtDurationInYearPrev() {
        return txtDurationInYearPrev;
    }

    public void setTxtDurationInYearPrev(HtmlInputText hit) {
        this.txtDurationInYearPrev = hit;
    }
    private HtmlInputText txtCostPerCreditHourPrev = new HtmlInputText();

    public HtmlInputText getTxtCostPerCreditHourPrev() {
        return txtCostPerCreditHourPrev;
    }

    public void setTxtCostPerCreditHourPrev(HtmlInputText hit) {
        this.txtCostPerCreditHourPrev = hit;
    }
    private HtmlInputText txtNumberOfCreditHoursPrev = new HtmlInputText();

    public HtmlInputText getTxtNumberOfCreditHoursPrev() {
        return txtNumberOfCreditHoursPrev;
    }

    public void setTxtNumberOfCreditHoursPrev(HtmlInputText hit) {
        this.txtNumberOfCreditHoursPrev = hit;
    }
    private HtmlInputText txtDocumentReferenceNumberPrev = new HtmlInputText();

    public HtmlInputText getTxtDocumentReferenceNumberPrev() {
        return txtDocumentReferenceNumberPrev;
    }

    public void setTxtDocumentReferenceNumberPrev(HtmlInputText hit) {
        this.txtDocumentReferenceNumberPrev = hit;
    }
    private HtmlInputTextarea txtRemarkPrev = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemarkPrev() {
        return txtRemarkPrev;
    }

    public void setTxtRemarkPrev(HtmlInputTextarea hit) {
        this.txtRemarkPrev = hit;
    }
    private HtmlInputText txtlblRequesterEdLevel = new HtmlInputText();

    public HtmlInputText getTxtlblRequesterEdLevel() {
        return txtlblRequesterEdLevel;
    }

    public void setTxtlblRequesterEdLevel(HtmlInputText hit) {
        this.txtlblRequesterEdLevel = hit;
    }
    private HtmlInputText txtlblRequesterProgramName = new HtmlInputText();

    public HtmlInputText getTxtlblRequesterProgramName() {
        return txtlblRequesterProgramName;
    }

    public void setTxtlblRequesterProgramName(HtmlInputText hit) {
        this.txtlblRequesterProgramName = hit;
    }
    private HtmlOutputLabel lblPrev = new HtmlOutputLabel();

    public HtmlOutputLabel getLblPrev() {
        return lblPrev;
    }

    public void setLblPrev(HtmlOutputLabel hol) {
        this.lblPrev = hol;
    }
    private HtmlOutputLabel lblNew = new HtmlOutputLabel();

    public HtmlOutputLabel getLblNew() {
        return lblNew;
    }

    public void setLblNew(HtmlOutputLabel hol) {
        this.lblNew = hol;
    }
    private HtmlOutputLabel lblInstId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblInstId() {
        return lblInstId;
    }

    public void setLblInstId(HtmlOutputLabel hol) {
        this.lblInstId = hol;
    }
    private HtmlOutputLabel lblInstitutionID = new HtmlOutputLabel();

    public HtmlOutputLabel getLblInstitutionID() {
        return lblInstitutionID;
    }

    public void setLblInstitutionID(HtmlOutputLabel hol) {
        this.lblInstitutionID = hol;
    }
    private HtmlInputText txtendDate = new HtmlInputText();

    public HtmlInputText getTxtendDate() {
        return txtendDate;
    }

    public void setTxtendDate(HtmlInputText hit) {
        this.txtendDate = hit;
    }
    private HtmlInputText txtendDateNew = new HtmlInputText();

    public HtmlInputText getTxtendDateNew() {
        return txtendDateNew;
    }

    public void setTxtendDateNew(HtmlInputText hit) {
        this.txtendDateNew = hit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ChangeInstitutionApprovePageNew() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     *
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String lnkConfirm_action() {
        return null;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
    }

    public ArrayList<SelectItem> getNameOfInstitutionPrev() {
        return nameOfInstitutionPrev;
    }

    public void setNameOfInstitutionPrev(ArrayList<SelectItem> nameOfInstitutionPrev) {
        this.nameOfInstitutionPrev = nameOfInstitutionPrev;
    }

    public ArrayList<Option> getRequestHistoryList() {
        return requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<Option> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public ArrayList<SelectItem> getEducationLevelCatagoryList() {
        return educationLevelCatagoryList;
    }

//    public ArrayList<SelectItem> getEducationTypeCatagoryListPrev() {
//        return educationTypeCatagoryListPrev;
//    }
//
//    public void setEducationTypeCatagoryListPrev(ArrayList<SelectItem> educationTypeCatagoryListPrev) {
//        this.educationTypeCatagoryListPrev = educationTypeCatagoryListPrev;
//    }
    public void setEducationLevelCatagoryList(ArrayList<SelectItem> educationLevelCatagoryList) {
        this.educationLevelCatagoryList = educationLevelCatagoryList;
    }

    public ArrayList<SelectItem> getEducationTypeCatagoryList() {
        return educationTypeCatagoryList;
    }

    public void setEducationTypeCatagoryList(ArrayList<SelectItem> educationTypeCatagoryList) {
        this.educationTypeCatagoryList = educationTypeCatagoryList;
    }

    public ArrayList<SelectItem> getEducationShiftList() {
        return educationShiftList;
    }

    public ArrayList<SelectItem> getNameOfInstitution() {
        return nameOfInstitution;
    }

    public void setNameOfInstitution(ArrayList<SelectItem> nameOfInstitution) {
        this.nameOfInstitution = nameOfInstitution;
    }

    public void setEducationShiftList(ArrayList<SelectItem> educationShiftList) {
        this.educationShiftList = educationShiftList;
    }

    public String getTakenStartDate() {
        return takenStartDate;
    }

    public ArrayList<SelectItem> getEducationShiftListPrev() {
        return educationShiftListPrev;
    }

    public void setEducationShiftListPrev(ArrayList<SelectItem> educationShiftListPrev) {
        this.educationShiftListPrev = educationShiftListPrev;
    }

    public void setTakenStartDate(String takenStartDate) {
        this.takenStartDate = takenStartDate;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromMyRequestList() {
        return selectedRequestFromMyRequestList;
    }

    public void setSelectedRequestFromMyRequestList(DefaultSelectedData selectedRequestFromMyRequestList) {
        this.selectedRequestFromMyRequestList = selectedRequestFromMyRequestList;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public EducationApproveManager getEducationApproveManager() {
        return educationApproveManager;
    }

    public void setEducationApproveManager(EducationApproveManager educationApproveManager) {
        this.educationApproveManager = educationApproveManager;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public ArrayList<SelectItem> getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(ArrayList<SelectItem> educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public String getDateOfStatusUpdate() {
        return dateOfStatusUpdate;
    }

    public void setDateOfStatusUpdate(String dateOfStatusUpdate) {
        this.dateOfStatusUpdate = dateOfStatusUpdate;
    }

    public String getEducatinalStatus() {
        return educatinalStatus;
    }

    public ArrayList<SelectItem> getProgramNamePrev() {
        return programNamePrev;
    }

    public void setProgramNamePrev(ArrayList<SelectItem> programNamePrev) {
        this.programNamePrev = programNamePrev;
    }

    public void setEducatinalStatus(String educatinalStatus) {
        this.educatinalStatus = educatinalStatus;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getAppliedDateNew() {
        return appliedDateNew;
    }

    public void setAppliedDateNew(String appliedDateNew) {
        this.appliedDateNew = appliedDateNew;
    }

    public double getCostPerCreditHourNew() {
        return costPerCreditHourNew;
    }

    public void setCostPerCreditHourNew(double costPerCreditHourNew) {
        this.costPerCreditHourNew = costPerCreditHourNew;
    }

    public String getDocumentReferenceNumberNew() {
        return documentReferenceNumberNew;
    }

    public void setDocumentReferenceNumberNew(String documentReferenceNumberNew) {
        this.documentReferenceNumberNew = documentReferenceNumberNew;
    }

    public double getDurationInYearNew() {
        return durationInYearNew;
    }

    public void setDurationInYearNew(double durationInYearNew) {
        this.durationInYearNew = durationInYearNew;
    }

    public String getEducationLevelCategoryNew() {
        return educationLevelCategoryNew;
    }

    public void setEducationLevelCategoryNew(String educationLevelCategoryNew) {
        this.educationLevelCategoryNew = educationLevelCategoryNew;
    }

    public String getEducationProgramNameNew() {
        return educationProgramNameNew;
    }

    public void setEducationProgramNameNew(String educationProgramNameNew) {
        this.educationProgramNameNew = educationProgramNameNew;
    }

    public String getEducationShiftCategoryNew() {
        return educationShiftCategoryNew;
    }

    public void setEducationShiftCategoryNew(String educationShiftCategoryNew) {
        this.educationShiftCategoryNew = educationShiftCategoryNew;
    }

    public String getEducationTypeCategoryNew() {
        return educationTypeCategoryNew;
    }

    public void setEducationTypeCategoryNew(String educationTypeCategoryNew) {
        this.educationTypeCategoryNew = educationTypeCategoryNew;
    }

    public String getEthiopianInstitutionNew() {
        return ethiopianInstitutionNew;
    }

    public void setEthiopianInstitutionNew(String ethiopianInstitutionNew) {
        this.ethiopianInstitutionNew = ethiopianInstitutionNew;
    }

    public String getInstitutionAccreditedNew() {
        return institutionAccreditedNew;
    }

    public void setInstitutionAccreditedNew(String institutionAccreditedNew) {
        this.institutionAccreditedNew = institutionAccreditedNew;
    }

    public String getInstitutionAddressNew() {
        return institutionAddressNew;
    }

    public void setInstitutionAddressNew(String institutionAddressNew) {
        this.institutionAddressNew = institutionAddressNew;
    }

    public String getInstitutionNameNew() {
        return institutionNameNew;
    }

    public void setInstitutionNameNew(String institutionNameNew) {
        this.institutionNameNew = institutionNameNew;
    }

    public int getNumberOfCreditHoursNew() {
        return numberOfCreditHoursNew;
    }

    public void setNumberOfCreditHoursNew(int numberOfCreditHoursNew) {
        this.numberOfCreditHoursNew = numberOfCreditHoursNew;
    }

    public String getReasonDescriptionNew() {
        return reasonDescriptionNew;
    }

    public void setReasonDescriptionNew(String reasonDescriptionNew) {
        this.reasonDescriptionNew = reasonDescriptionNew;
    }

    public String getStartDateNew() {
        return startDateNew;
    }

    public void setStartDateNew(String startDateNew) {
        this.startDateNew = startDateNew;
    }

    public double getTotalAdminstrationCostsNew() {
        return totalAdminstrationCostsNew;
    }

    public void setTotalAdminstrationCostsNew(double totalAdminstrationCostsNew) {
        this.totalAdminstrationCostsNew = totalAdminstrationCostsNew;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public String getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(String institutionID) {
        this.institutionID = institutionID;
    }

    public changeInstituApproveManager getChangeInstituApproveManager() {
        return ChangeInstituApproveManager;
    }

    public void setChangeInstituApproveManager(changeInstituApproveManager ChangeInstituApproveManager) {
        this.ChangeInstituApproveManager = ChangeInstituApproveManager;
    }

    public int getChangeInstID() {
        return changeInstID;
    }

    public void setChangeInstID(int changeInstID) {
        this.changeInstID = changeInstID;
    }

    public ArrayList<SelectItem> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<SelectItem> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public changeInstitutionRequestModel getChangeInsModel() {
        return changeInsModel;
    }

    public void setChangeInsModel(changeInstitutionRequestModel changeInsModel) {
        this.changeInsModel = changeInsModel;
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<Option> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pnlPopupConfirmDelete) {
        this.pnlPopupConfirmDelete = pnlPopupConfirmDelete;
    }
    //=========================================================================================================================

//    public String btnCalendarAppliedDate_action() {
//        calAppliedDate.setRendered(true);
//        return null;
//    }
//
//    public String btnCalendarSatartDate_action() {
//        calStartDate.setRendered(true);
//        return null;
//    }

//    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
//        txtAppliedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
//        calAppliedDate.setRendered(false);
//    }
//
//    public void calStartDate_processValueChange(ValueChangeEvent vce) {
//        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
//        calStartDate.setRendered(false);
//    }
    //=========================================================================================================================
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
    //=========================================================================================================================
    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);

        return null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
            requesterId = txtRequesterId.getValue().toString();
            // requesterID=txtRequesterId.getValue().toString();
            this.setEducationLevelCatagoryListprev(changeInstitManager.getEducationLevel(requesterId));
            // this.setEducationTypeCatagoryListPrev(changeInstitManager.getprogramCategory(requesterId));
            this.setNameOfInstitutionPrev(changeInstitManager.getNAmeOfInstitution(requesterId));
            this.setProgramNamePrev(changeInstitManager.getprogramName(requesterId));
            this.setEducationShiftListPrev(changeInstitManager.getEducationShift(requesterId));
            if ((populateRequesterTextComponents(requesterId)) && (populateRequestChangInstTextComponents(requesterId))) {
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtRequesterId.getValue().toString());
                requesterId = null;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
        return null;
    }
    //=========================================================================================================================

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        HashMap empEduHashMap = educationRequestManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                requesterId = null;
                return false;
            } else {
                requesterId = employeeId;
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(requesterId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                txtlblRequesterEdLevel.setValue(empEduHashMap.get("levels"));
                txtlblRequesterProgramName.setValue(empEduHashMap.get("description"));
                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }
    //=========================================================================================================================

    private boolean populateRequestTextComponents(int requestId) {

        changeInsModel = ChangeInstituApproveManager.getEducationRequest(requestId);
        if (changeInsModel != null) {
            if (changeInsModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {
                txtProgramTypeNew.setValue(changeInsModel.getEducationProgramName());
                txtNumberOfCreditHoursNew.setValue(changeInsModel.getNumberOfCreditHours());
                txtAppliedDateNew.setValue(changeInsModel.getAppliedDate());
                txtCostPerCreditHourNew.setValue(changeInsModel.getCostPerCreditHour());
                txtDocumentReferenceNumberNew.setValue(changeInsModel.getDocumentReferenceNumber());
                txtDurationInYearNEw.setValue(changeInsModel.getDurationInYear());
                txInstNAme.setValue(changeInsModel.getInstitutionName());
                txtRemarkNEw.setValue(changeInsModel.getReasonDescription());
                txtStartDateNEw.setValue(changeInsModel.getStartDate());
                txtendDateNew.setValue(changeInsModel.getEndDate());
                txtTotalAdminstrativeCostNew.setValue(changeInsModel.getTotalAdminstrationCosts());
                txtLevelNew.setValue(changeInsModel.getEducationLevelCategory());
                txtShiftNew.setValue(changeInsModel.getEducationShiftCategory());
                lblEduRequestId.setValue(changeInsModel.getEducationRequestId());
                lblRequesterID.setValue(changeInsModel.getRequesterId());
                //lblchangeInstituId.setValue(educationRequestModel.getChangeInstId());
                lblInstId.setValue(changeInsModel.getInstitutionName());


                institutionID = lblInstId.getValue().toString();
                institutionName = educationRequestManager.getTypeOFInstName(institutionID);
                txInstNAme.setValue(institutionName);
                institutionAddress = educationRequestManager.getInstituAdress(institutionID);
                txtaInstitutionAddressNew.setValue(institutionAddress);
                ethiopianInstitution = educationRequestManager.getInsideOutside(institutionID);
                 if (ethiopianInstitution != null) {
                    if (ethiopianInstitution.equalsIgnoreCase("IN")) {
                        txtInsideOutNEw.setValue("Inside Ethiopia");
                    }

                    if (ethiopianInstitution.equalsIgnoreCase("OUT")) {
                        txtInsideOutNEw.setValue("Outside Ethiopia");
                    }
                } else {
                    txtInsideOutNEw.setValue("-------");
                }
                institutionAccredited = educationRequestManager.getTypeOFAccredated(institutionID);
                 if (institutionAccredited != null) {
                if (institutionAccredited.equalsIgnoreCase("AC")) {
                    txtAccredNEw.setValue("Accredited ");
                }

                if (institutionAccredited.equalsIgnoreCase("IN")) {
                    txtAccredNEw.setValue("Not Accredited ");
                }
                 } else {
                txtAccredNEw.setValue("-----");

            }
                return true;
            }
        } else {
            educationRequestId = -1;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

//=================================================================================================================
    private boolean populateRequestChangInstTextComponents(String requesterId) {

        educationRequestModel = educationRequestManager.getEducationChangInsRequest(requesterId);
        if (educationRequestModel != null) {
            if (educationRequestModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requesterId);
                return false;
            } else {
                txtProgramNamePrev.setValue(educationRequestModel.getEducationProgramName());
                lblInstitutionID.setValue(educationRequestModel.getInstitutionName());
                
                institutionID=lblInstitutionID.getValue().toString();
                institutionName=educationRequestManager.getTypeOFInstName(institutionID);
                txtInstNAmePrev.setValue(institutionName);
                txtAppliedDatePrev.setValue(educationRequestModel.getAppliedDate());
                txtCostPerCreditHourPrev.setValue(educationRequestModel.getCostPerCreditHour());
                txtDocumentReferenceNumberPrev.setValue(educationRequestModel.getDocumentReferenceNumber());
                txtDurationInYearPrev.setValue(educationRequestModel.getDurationInYear());
                txtShiftPrev.setValue(educationRequestModel.getEducationShiftCategory());
                txtLevelPrev.setValue(educationRequestModel.getEducationLevelCategory());
                txtStartDatePrev.setValue(educationRequestModel.getStartDate());
                 txtendDate.setValue(educationRequestModel.getEndDate());
                txtTotalAdminsPrev.setValue(educationRequestModel.getTotalAdminstrationCosts());
                lblEduRequestId.setValue(educationRequestModel.getEducationRequestId());
                lblRequesterID.setValue(educationRequestModel.getRequesterId());
                txtNumberOfCreditHoursPrev.setValue(educationRequestModel.getNumberOfCreditHours());
                txtRemarkPrev.setValue(educationRequestModel.getReasonDescription());
//                
                return true;
            }
        } else {
            educationRequestId = -1;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }
  
    //=========================================================================================================================
    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        txtTotalAdminstrativeCostNew.setValue(null);
        txtAccredNEw.resetValue();
        txtAppliedDateNew.resetValue();
        txtCostPerCreditHourNew.resetValue();
        txtShiftNew.resetValue();
        txtAppliedDateNew.resetValue();
        txtDocumentReferenceNumberNew.resetValue();
        txtStartDateNEw.resetValue();
        txtDurationInYearNEw.resetValue();
        txtProgramTypeNew.resetValue();
        txtInsideOutNEw.resetValue();
//        txtDeciderDepartment.resetValue();
//        txtDeciderFullName.resetValue();
//        txtDeciderId.resetValue();
//        txtDeciderPosition.resetValue();
        txtDocumentReferenceNumberNew.resetValue();
        txtDurationInYearNEw.resetValue();
        drlDecision.setValue("0");
        txtNumberOfCreditHoursNew.resetValue();
        txInstNAme.resetValue();
        txtRemarkNEw.resetValue();
        txtRequesterDepartment.resetValue();
        //txtAccredNEw.resetValue();
        txtRequesterId.resetValue();
        txtlblRequesterEdLevel.setValue(null);
        txtlblRequesterProgramName.setValue(null);
    }

    private void clearAllComponents() {
        clearRequestComponents();
        clearRequesterTextComponents();
        clearDropDownItems();
        makePageReadyForUpdate();
    }

    private void clearDropDownItems() {
        selectedRequestFromMyRequestList = new DefaultSelectedData();
        selectedRequestFromHistoryList.setSelectedObject(null);
        selectObjectOfEducationTypeCatagory.setSelectedObject(null);
        selectObjectOfEducationLevelCatagory.setSelectedObject(null);
        selectObjectOfEducationShiftCatagory.setSelectedObject(null);
    }

    public void enableComponents() {
        txtProgramTypeNew.setDisabled(false);
        txtNumberOfCreditHoursNew.setDisabled(false);
        txtAppliedDateNew.setDisabled(false);
        txtCostPerCreditHourNew.setDisabled(false);
        txtDocumentReferenceNumberNew.setDisabled(false);
        txtDurationInYearNEw.setDisabled(false);
        txtaInstitutionName.setDisabled(false);
        txtRemarkNEw.setDisabled(false);
        txtStartDateNEw.setDisabled(false);
        txtAccredNEw.setDisabled(false);
        txtInsideOutNEw.setDisabled(false);
        txtLevelNew.setDisabled(false);
//        drlEducationShift.setDisabled(false);
//        drlEducationTypeCatagory.setDisabled(false);
//        ckbInstitutionAccredited.setDisabled(false);

    }

    public void disableComponents() {
        txtProgramTypeNew.setDisabled(false);
        txtNumberOfCreditHoursNew.setDisabled(true);
        txtAppliedDateNew.setDisabled(true);
        txtCostPerCreditHourNew.setDisabled(true);
        txtDocumentReferenceNumberNew.setDisabled(true);
        txtDurationInYearNEw.setDisabled(true);
        txtaInstitutionName.setDisabled(true);
        txtRemarkNEw.setDisabled(true);
        txtStartDateNEw.setDisabled(true);
        txtAccredNEw.setDisabled(true);
        txtInsideOutNEw.setDisabled(true);
        txtLevelNew.setDisabled(true);
    }

    public void clearRequestComponents() {
        txtProgramTypeNew.setValue(null);
        txtProgramTypeNew.setValue(null);
        txtNumberOfCreditHoursNew.setValue(null);
        txtNumberOfCreditHoursPrev.setValue(null);
        txtAppliedDateNew.setValue(null);
        txtAppliedDatePrev.setValue(null);
        txtCostPerCreditHourNew.setValue(null);
        txtCostPerCreditHourPrev.setValue(null);
        txtDocumentReferenceNumberNew.setValue(null);
        txtDocumentReferenceNumberPrev.setValue(null);
        txtDurationInYearNEw.setValue(null);
        txtDurationInYearPrev.setValue(null);
        txtInstNAmePrev.setValue(null);
        txInstNAme.setValue(null);
        txtRemarkNEw.setValue(null);
        txtRemarkPrev.setValue(null);
        txtStartDateNEw.setValue(null);
        txtStartDatePrev.setValue(null);
        txtTotalAdminstrativeCostNew.setValue(null);
        txtTotalAdminsPrev.setValue(null);
        txtaInstitutionAddressNew.setValue(null);
        txtLevelNew.setValue(null);
        txtLevelPrev.setValue(null);
        txtShiftNew.setValue(null);
        txtShiftPrev.setValue(null);
        txtProgramNamePrev.setValue(null);

    }
    //=========================================================================================================================

    private void makePageReadyForSave() {
        clearAllComponents();
        newOrEditOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(false);
    }

    private void makePageReadyForUpdate() {
        enableComponents();
        newOrEditOrUpdateLabel = "Update";
        // btnDelete.setDisabled(false);
        btnSaveOrUpdate.setDisabled(false);
    // lnkViewPrevieousDecisions.setRendered(false);
    }

    private void makePageReadyForView() {
        disableComponents();
        newOrEditOrUpdateLabel = "Save";
        //btnDelete.setDisabled(true);
        btnSaveOrUpdate.setDisabled(true);
    // lnkViewPrevieousDecisions.setRendered(true);
    }

    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
    //=========================================================================================================================
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setAutoCentre(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
    //=========================================================================================================================

    private void populateDecisionHistory(int overTimeRequestId) {
        decisionsMadeOnRequestList = ChangeInstituApproveManager.getRequestHistory(overTimeRequestId);

    }
    //=========================================================================================================================

    // </editor-fold>
    // </editor-fold >
    // </editor-fold >
    EmployeeManage employeeManager = new EmployeeManage();
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationRequestManager educationRequestManager = new EducationRequestManager();
    EducationApproveManager educationApproveManager = new EducationApproveManager();
    ChangeInstitManager changeInstitManager = new ChangeInstitManager();
    changeInstitutionRequestModel changeInsModel = new changeInstitutionRequestModel();
    changeInstituApproveManager ChangeInstituApproveManager = new changeInstituApproveManager();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    //ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationTypeCatagoryList = educationRequestManager.getprogramCategory();
    // ArrayList<SelectItem> educationTypeCatagoryListPrev = changeInstitManager.getprogramCategory(requesterID);
    ArrayList<SelectItem> educationLevelCatagoryList = educationRequestManager.getEducationLevels();
    ArrayList<SelectItem> educationLevelCatagoryListprev = changeInstitManager.getEducationLevel(requesterID);
    ArrayList<SelectItem> educationShiftList = educationRequestManager.getEducationShift();
    ArrayList<SelectItem> educationShiftListPrev = changeInstitManager.getEducationShift(requesterID);
    ArrayList<SelectItem> nameOfInstitution = educationRequestManager.getNAmeOfInstitution();
    ArrayList<SelectItem> nameOfInstitutionPrev = changeInstitManager.getNAmeOfInstitution(requesterID);
    //  ArrayList<SelectItem> programName = educationRequestManager.getprogramName(catID);
    ArrayList<SelectItem> programNamePrev = changeInstitManager.getprogramName(requesterID);
    ArrayList<SelectItem> educationalStatus = educationRequestManager.getEducationalStatus();
    ArrayList<Option> requestHistoryList = new ArrayList<Option>();
    ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    ArrayList<SelectItem> availableDecisionsToMakeList = new ArrayList<SelectItem>();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationTypeCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationLevelCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationShiftCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String loggedInEmployeeId;
    String userName;
    //=====================================================================================
    int changeInstID;
    int educationRequestId;
    String requesterId;//
    String educationProgramName;
    String educationProgramNameNew;
    String institutionName;
    String institutionNameNew;
    String ethiopianInstitution;//inside or outside ethiopia
    String ethiopianInstitutionNew;
    String institutionAccredited;//
    String institutionAccreditedNew;
    String institutionAddress;
    String institutionAddressNew;
    String institutionID;
    String startDate;
    String startDateNew;
    String appliedDate;
    String appliedDateNew;
    String educationShiftCategory;//
    String educationShiftCategoryNew;
    String educationTypeCategory;//
    String educationTypeCategoryNew;
    String educationLevelCategory;
    String educationLevelCategoryNew;//
    double costPerCreditHour;
    double costPerCreditHourNew;
    int numberOfCreditHours;
    int numberOfCreditHoursNew;
    double totalAdminstrationCosts;
    double totalAdminstrationCostsNew;
    double durationInYear;
    double durationInYearNew;
    String reasonDescription;
    String reasonDescriptionNew;
    String documentReferenceNumber;
    String documentReferenceNumberNew;
    String requestStatus;
    String timeStamp;
    String educatinalStatus;
    String dateOfStatusUpdate;
    String endDate;
     String endDateNew;
    // int changeInstId;
    //=========================================================================================================================

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        educationRequestId = Integer.parseInt(requestAttributes[2]);
        changeInstID = Integer.parseInt(requestAttributes[0]);
        requesterId = requestAttributes[1];
        requestStatus = requestAttributes[3];
        populateRequesterTextComponents(requesterId);
        populateRequestTextComponents(changeInstID);
        availableDecisionsToMakeList = ChangeInstituApproveManager.getAvailableDecisionsToMake(requestStatus);
        populateRequestChangInstTextComponents(requesterId);
        makePageReadyForUpdate();
        drlDecision.setDisabled(false);
        lblPrev.setValue("Previous");
        lblNew.setValue("New");
         }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
    
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        educationRequestId = Integer.parseInt(requestAttributes[2]);
        changeInstID = Integer.parseInt(requestAttributes[0]);
        requesterId = requestAttributes[1];
        requestStatus = requestAttributes[3];
        populateRequesterTextComponents(requesterId);
        populateRequestTextComponents(changeInstID);
        populateRequestChangInstTextComponents(requesterId);
        populateDecisionHistory(changeInstID);
        makePageReadyForView();
        drlDecision.setDisabled(true);
        lblPrev.setValue("New");
        lblNew.setValue("Previous");
         }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //=========================================================================================================================
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
        if (educationRequestManager.deleteEducationRequest(educationRequestId)) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponents();
            requestListsToBeApproved = ChangeInstituApproveManager.getRequestsToBeProcessed();
        //availableDecisionsToMakeList = ChangeInstituApproveManager.getMyDecisionsOnRequests();
        } else {
            showSuccessOrFailureMessage(false, "CAN NOT DELETE THE REQUEST\n PLEASE TRY AGAIN");
        }
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }

    public String btnPopupCancelDelete_action() {
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }
    //=========================================================================================================================

    private boolean validateAndInitializeAttributes() {
        if (false) {
            showSuccessOrFailureMessage(false, "PLEASE SELECT EMPLOYEE");
            return false;
        } else if (false) {
            return false;
        } else {
            requesterId = txtRequesterId.getValue().toString();
            educationProgramNameNew = txtProgramTypeNew.getValue().toString();
            institutionNameNew = lblInstId.getValue().toString();
            institutionAccreditedNew = txtAccredNEw.getValue().toString();
            institutionAddressNew = txtaInstitutionAddressNew.getValue().toString();
            ethiopianInstitutionNew = txtInsideOutNEw.getValue().toString();
            startDateNew = txtStartDateNEw.getValue().toString();
            endDateNew = txtendDateNew.getValue().toString();
            appliedDateNew = txtAppliedDateNew.getValue().toString();
            educationShiftCategoryNew = txtShiftNew.getValue().toString();
            educationTypeCategoryNew = txtProgramTypeNew.getValue().toString();
            educationLevelCategoryNew = txtLevelNew.getValue().toString();
            costPerCreditHourNew = Double.parseDouble(txtCostPerCreditHourNew.getValue().toString());
            numberOfCreditHoursNew = Integer.parseInt(txtNumberOfCreditHoursNew.getValue().toString());
            totalAdminstrationCostsNew = Double.parseDouble(txtTotalAdminstrativeCostNew.getValue().toString());
            durationInYearNew = Double.parseDouble(txtDurationInYearNEw.getValue().toString());
            reasonDescriptionNew = txtRemarkNEw.getValue().toString();
            documentReferenceNumberNew = txtDocumentReferenceNumberNew.getValue().toString();


            educationProgramName = txtProgramNamePrev.getValue().toString();
            institutionName = lblInstitutionID.getValue().toString();


            startDate = txtStartDatePrev.getValue().toString();
            appliedDate = txtAppliedDatePrev.getValue().toString();
            educationShiftCategory = txtShiftPrev.getValue().toString();
            educationTypeCategory = txtProgramNamePrev.getValue().toString();
            educationLevelCategory = txtLevelPrev.getValue().toString();
            costPerCreditHour = Double.parseDouble(txtCostPerCreditHourPrev.getValue().toString());
            numberOfCreditHours = Integer.parseInt(txtNumberOfCreditHoursPrev.getValue().toString());
            totalAdminstrationCosts = Double.parseDouble(txtTotalAdminsPrev.getValue().toString());
            durationInYear = Double.parseDouble(txtDurationInYearPrev.getValue().toString());
            reasonDescription = txtRemarkPrev.getValue().toString();
            documentReferenceNumber = txtDocumentReferenceNumberPrev.getValue().toString();
            endDate = txtendDate.getValue().toString();
            return true;
        }
    }
    //=========================================================================================================================

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(changeInstituApproveManager.CHANGEINS_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(changeInstituApproveManager.CHANGEINS_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (educationRequestId == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE TERMINATION TO DECIDE");
            return false;
        }
        return true;
    }

    public boolean saveDecision() {
        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
        return ChangeInstituApproveManager.saveDecision(changeInstID, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);
    }

    public boolean isEntryValidForSAve() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.drlDecision.getValue());
        if (!required) {
            ((UIInput) drlDecision).setValid(false);
            error(drlDecision, errorMessage);
            results = false;
        }
        return results;
    }

    public String btnSaveOrUpdate_action() {
        if (isEntryValidForSAve()) {
            if (validateDecision()) {
                if (saveDecision()) {
                    if (validateAndInitializeAttributes()) {
                        if (drlDecision.getValue().toString().equals(changeInstituApproveManager.CHANGEINS_DECISION_APPROVE)) {
                             ChangeInstituApproveManager.UpadtechangeInstitutionRequest(educationRequestId, requesterId, educationProgramNameNew, institutionNameNew, ethiopianInstitutionNew, institutionAccreditedNew, institutionAddressNew, startDateNew, endDateNew,appliedDateNew, educationShiftCategoryNew, educationTypeCategoryNew, educationLevelCategoryNew, costPerCreditHourNew, numberOfCreditHoursNew, totalAdminstrationCostsNew, durationInYearNew, reasonDescriptionNew, documentReferenceNumberNew);
                            changeInstitManager.updatePrevEducationRequest(changeInstID, educationRequestId, requesterId, educationProgramName, institutionName, ethiopianInstitution, institutionAccredited, institutionAddress, startDate, appliedDate, educationShiftCategory, educationLevelCategoryNew, costPerCreditHour, numberOfCreditHours, totalAdminstrationCosts, durationInYear, reasonDescription, documentReferenceNumber, endDate);
                        }
                    }
                    requestListsToBeApproved = ChangeInstituApproveManager.getRequestsToBeProcessed();
                    requestHistoryList = ChangeInstituApproveManager.getMyDecisionsOnRequests();
                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                    clearAllComponents();
                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED");
                }
            }
        }
        return null;
    }

    public String btnReset_action() {
        clearRequesterTextComponents();
        makePageReadyForSave();

        clearAllComponents();

        return null;
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(changeInstID);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

    public String txtCostPerCreditHour_action() {
        //return null means stay on the same page
        return null;
    }

    private boolean populateApproverTextComponents(String approverId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
                txtDeciderId.setDisabled(false);
                return false;
            } else {
                approverId = empInfoHashMap.get("employeeId").toString();
                txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtDeciderFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                txtDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }

        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }

    public void drlInstitutionName_processValueChange(ValueChangeEvent vce) {
//        institutionID = vce.getNewValue().toString();
//        institutionAddress = changeInstitManager.getInstituAdress(institutionID);
//        txtaInstitutionAddress.setValue(institutionAddress);
//        ethiopianInstitution = changeInstitManager.getInsideOutside(institutionID);
//        if (ethiopianInstitution.equalsIgnoreCase("IN")) {
//        txtInsideOut.setValue("Inside Ethiopia");
//        }
//                    if (ethiopianInstitution.equalsIgnoreCase("OUT")) {txtInsideOut.setValue("Outside Ethiopia");
//        }
//
//        institutionAccredited = educationRequestManager.getTypeOFAccredated(institutionID);
//        if (institutionAccredited.equalsIgnoreCase("AC")) {
//        txtAccred.setValue(institutionAccredited);
//        }
//        if (institutionAccredited.equalsIgnoreCase("IN")) {
//            txtAccred.setValue("Not Accredited ");
//        }
    }

    public String btnClosePopupEducationalStatus_action() {
        //return null means stay on the same page
        pnlPopupEduactionaStatus.setRendered(false);
        return null;
    }

    public String btnCaldate_action() {
        //return null means stay on the same page
        calTakenRevokedStartDate.setRendered(true);
        return null;
    }

    public String txtAppliedDate_action() {
        //return null means stay on the same page
        return null;
    }

    public void calTakenRevokedStartDate_processValueChange(ValueChangeEvent vce) {
        takenStartDate = dateFormat.format(calTakenRevokedStartDate.getValue());
        txtdate.setValue(takenStartDate);
        calTakenRevokedStartDate.setRendered(false);
    }

    public String btnResetPop_action() {
        //return null means stay on the same page
        drlEducationRegisStatus.setValue("0");
        txtdate.resetValue();
        return null;
    }

//    public String btnSavePop_action() {
//        //return null means stay on the same page
//        if (validateAndInitializeAttributes()) {
//            //if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
//            educatinalStatus = drlEducationRegisStatus.getValue().toString();
//            dateOfStatusUpdate = txtdate.getValue().toString();
//            educationRequestId = Integer.valueOf(lblEduRequestId.getValue().toString());
//            requesterId = lblRequesterID.getValue().toString();
//            if (educationRequestManager.updateEducationStatus(educationRequestId, requesterId, educatinalStatus, dateOfStatusUpdate)) {
//                showSuccessOrFailureMessage(true, "UPDATING SUCCESSFUL");
//            } else {
//                showSuccessOrFailureMessage(false, "UPDATING FAILED");
//            }
//        }
//        return null;
//    }
    public String txtRequesterPosition_action() {
        //return null means stay on the same page
        return null;
    }

    public void drlInstitutionNameNew_processValueChange(ValueChangeEvent vce) {
        institutionID = vce.getNewValue().toString().split("-")[0];
        institutionAddress =
                educationRequestManager.getInstituAdress(institutionID);
        txtaInstitutionAddressNew.setValue(institutionAddress);
        ethiopianInstitution =
                educationRequestManager.getInsideOutside(institutionID);
        if (ethiopianInstitution.equalsIgnoreCase("IN")) {
            txtInsideOutNEw.setValue("Inside Ethiopia");
        }

        if (ethiopianInstitution.equalsIgnoreCase("OUT")) {
            txtInsideOutNEw.setValue("Outside Ethiopia");
        }

        institutionAccredited = educationRequestManager.getTypeOFAccredated(institutionID);
        if (institutionAccredited.equalsIgnoreCase("AC")) {
            txtAccredNEw.setValue("Accredited ");
        }

        if (institutionAccredited.equalsIgnoreCase("IN")) {
            txtAccredNEw.setValue("Not Accredited ");
        }

    }

//    public void drlEducationTypeCatagoryNEw_processValueChange(ValueChangeEvent vce) {
//        String categoryId = vce.getNewValue().toString().split("-")[0];
//
//        this.setProgramName(educationRequestManager.getprogramName(categoryId));
//    }
    public String btnCalendarAppliedDateNEw_action() {
        //return null means stay on the same page
        calAppliedDateNew.setRendered(true);
        return null;
    }

    public String btnCalendarSatartDateNew_action() {
        //return null means stay on the same page
        calStartDateNEw.setRendered(true);
        return null;
    }

    public void txtStartDate_processValueChange(ValueChangeEvent vce) {
    }

    public void calAppliedDateNew_processValueChange(ValueChangeEvent vce) {
        txtAppliedDateNew.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDateNew.setRendered(false);
    }

    public void calStartDateNEw_processValueChange(ValueChangeEvent vce) {
        txtStartDateNEw.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDateNEw.setRendered(false);
    }

    public void drlProgramNameNew_processValueChange(ValueChangeEvent vce) {
    }

    public void drlEducationTypeCatagoryNEw_validate(FacesContext context, UIComponent component, Object value) {
    }

    public void drlEducationLevelCatagory_processValueChange(ValueChangeEvent vce) {
    }

    public void drlEducationTypeCatagory_processValueChange(ValueChangeEvent vce) {
    }

    public void drlProgramName_processValueChange(ValueChangeEvent vce) {
    }

    public void drlEducationShift_processValueChange(ValueChangeEvent vce) {
    }

    public String txtNumberOfCreditHoursNew_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkGovernmentDeductions_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtStartDate_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtProgramCategoryNew_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtDeciderId_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtDeciderFullName_action() {
        //return null means stay on the same page
        return null;
    }

    public void txtaDeciderComment_processValueChange(ValueChangeEvent vce) {
    }

    public String lnkEducationRequest_action() {
        //return null means stay on the same page
        return "EducationRequest";
    }

    public String lnkEducationPaymentRequest_action() {
        //return null means stay on the same page
        return "EducationPaymentRequest";
    }

    public String lnkEducationApprove_action() {
        //return null means stay on the same page
        return "EducationApprove";
    }

    public String lnkChangeInstApprove_action() {
        //return null means stay on the same page
        return "ChangeInstitutionaPRROVEPage";
    }

    public String lnkChangeInstituRequest_action() {
        // TODO: Replace with your code
        return "ChangeInstitutionPage";
    }

    public String btnClosePopupViewPrevieousDecisions_action() {
        // TODO: Replace with your code
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String lnkInstRegistration_action() {
        // TODO: Replace with your code
        return "InstitutionRegistrationPage";
    }

    public void txtaInstitutionAddressNew_processValueChange(ValueChangeEvent vce) {
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
    }

    public void selectMyRequestLists_validate(FacesContext context, UIComponent component, Object value) {
    }

    public String btnSearchDecider_action() {
        //return null means stay on the same page
        return null;
    }
}
