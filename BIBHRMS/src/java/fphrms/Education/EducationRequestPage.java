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
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.educationManager.EducationApproveManager;
import manager.educationManager.EducationRequestManager;
import manager.educationManager.EducationRequestModel;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;
import manager.organizationManager.JobTypeQualificationManager;
import control.LookUpManger;
import manager.terminationManager.TerminationRequestManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EducationRequestPage extends AbstractPageBean {

    private String catID;
    private String takenStartDate;
    private int rank;
    private int deptId;
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userName = getSessionBean1().getUserName();
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        educationRequestManager.setUserName(userName);
        educationRequestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
        requestHistoryList = educationRequestManager.getMyRequestsHistory();
        pendingRequestList = educationRequestManager.getPendingRequests();
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
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText sit) {
        this.txtRequesterFullName = sit;
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
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();
    private SelectInputDate calDate = new SelectInputDate();

    public SelectInputDate getCalDate() {
        return calDate;
    }

    public void setCalDate(SelectInputDate calDate) {
        this.calDate = calDate;
    }

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

//    public ArrayList<SelectItem> getProgramName() {
//        return programName;
//    }
//
//    public void setProgramName(ArrayList<SelectItem> programName) {
//        this.programName = programName;
//    }
    public void setCalAppliedDate(SelectInputDate sid) {
        this.calAppliedDate = sid;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlInputText txtDocumentReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocumentReferenceNumber() {
        return txtDocumentReferenceNumber;
    }

    public JobTypeQualificationManager getJobTypeQualificationManager() {
        return jobTypeQualificationManager;
    }

    public void setJobTypeQualificationManager(JobTypeQualificationManager jobTypeQualificationManager) {
        this.jobTypeQualificationManager = jobTypeQualificationManager;
    }

    public void setTxtDocumentReferenceNumber(HtmlInputText hit) {
        this.txtDocumentReferenceNumber = hit;
    }
    private HtmlInputText txtCostPerCreditHour = new HtmlInputText();

    public HtmlInputText getTxtCostPerCreditHour() {
        return txtCostPerCreditHour;
    }

    public void setTxtCostPerCreditHour(HtmlInputText hit) {
        this.txtCostPerCreditHour = hit;
    }
    private HtmlSelectOneMenu drlEducationShift = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationShift() {
        return drlEducationShift;
    }

    public void setDrlEducationShift(HtmlSelectOneMenu hsom) {
        this.drlEducationShift = hsom;
    }
    private HtmlSelectOneMenu drlEducationLevelCatagory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationLevelCatagory() {
        return drlEducationLevelCatagory;
    }

    public void setDrlEducationLevelCatagory(HtmlSelectOneMenu hsom) {
        this.drlEducationLevelCatagory = hsom;
    }
    private HtmlInputTextarea txtaInstitutionAddress = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaInstitutionAddress() {
        return txtaInstitutionAddress;
    }

    public void setTxtaInstitutionAddress(HtmlInputTextarea hit) {
        this.txtaInstitutionAddress = hit;
    }
    private HtmlInputTextarea txtaInstitutionName = new HtmlInputTextarea();
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlInputText txtDurationInYear = new HtmlInputText();

    public HtmlInputText getTxtDurationInYear() {
        return txtDurationInYear;
    }

    public void setTxtDurationInYear(HtmlInputText hit) {
        this.txtDurationInYear = hit;
    }
    private HtmlInputText txtNumberOfCreditHours = new HtmlInputText();

    public HtmlInputText getTxtNumberOfCreditHours() {
        return txtNumberOfCreditHours;
    }

    public void setTxtNumberOfCreditHours(HtmlInputText hit) {
        this.txtNumberOfCreditHours = hit;
    }
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
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
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
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
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
    private HtmlSelectOneMenu drlInstitutionName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlInstitutionName() {
        return drlInstitutionName;
    }

    public void setDrlInstitutionName(HtmlSelectOneMenu hsom) {
        this.drlInstitutionName = hsom;
    }
    private HtmlInputText txtInsideOut = new HtmlInputText();

    public HtmlInputText getTxtInsideOut() {
        return txtInsideOut;
    }

    public void setTxtInsideOut(HtmlInputText hit) {
        this.txtInsideOut = hit;
    }
    private HtmlInputText txtAccred = new HtmlInputText();

    public HtmlInputText getTxtAccred() {
        return txtAccred;
    }

    public void setTxtAccred(HtmlInputText hit) {
        this.txtAccred = hit;
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
    private HtmlSelectOneMenu drlProgramName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProgramName() {
        return drlProgramName;
    }

    public void setDrlProgramName(HtmlSelectOneMenu hsom) {
        this.drlProgramName = hsom;
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
    private HtmlInputText txtTotalAdminstrativeCost = new HtmlInputText();

    public HtmlInputText getTxtTotalAdminstrativeCost() {
        return txtTotalAdminstrativeCost;
    }

    public void setTxtTotalAdminstrativeCost(HtmlInputText hit) {
        this.txtTotalAdminstrativeCost = hit;
    }
    private HtmlInputText txtBirthDate = new HtmlInputText();

    public HtmlInputText getTxtBirthDate() {
        return txtBirthDate;
    }

    public void setTxtBirthDate(HtmlInputText hit) {
        this.txtBirthDate = hit;
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
    private HtmlSelectBooleanCheckbox chkBAsic = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkBAsic() {
        return chkBAsic;
    }

    public void setChkBAsic(HtmlSelectBooleanCheckbox hsbc) {
        this.chkBAsic = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkHigher = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkHigher() {
        return chkHigher;
    }

    public void setChkHigher(HtmlSelectBooleanCheckbox hsbc) {
        this.chkHigher = hsbc;
    }
    private HtmlOutputLabel lblDeptID = new HtmlOutputLabel();

    public HtmlOutputLabel getLblDeptID() {
        return lblDeptID;
    }

    public void setLblDeptID(HtmlOutputLabel hol) {
        this.lblDeptID = hol;
    }
    private HtmlCommandLink lnkViewsatusOfEducation = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewsatusOfEducation() {
        return lnkViewsatusOfEducation;
    }

    public void setLnkViewsatusOfEducation(HtmlCommandLink hcl) {
        this.lnkViewsatusOfEducation = hcl;
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
    private HtmlCommandLink lnkChangeiNstitutionReq = new HtmlCommandLink();

    public HtmlCommandLink getLnkChangeiNstitutionReq() {
        return lnkChangeiNstitutionReq;
    }

    public void setLnkChangeiNstitutionReq(HtmlCommandLink hcl) {
        this.lnkChangeiNstitutionReq = hcl;
    }
    private HtmlCommandLink lnkChangeInstApprove = new HtmlCommandLink();

    public HtmlCommandLink getLnkChangeInstApprove() {
        return lnkChangeInstApprove;
    }

    public void setLnkChangeInstApprove(HtmlCommandLink hcl) {
        this.lnkChangeInstApprove = hcl;
    }
    private HtmlCommandLink lnkInstRegistration = new HtmlCommandLink();

    public HtmlCommandLink getLnkInstRegistration() {
        return lnkInstRegistration;
    }

    public void setLnkInstRegistration(HtmlCommandLink hcl) {
        this.lnkInstRegistration = hcl;
    }
    private HtmlCommandLink btnCloseEducationalStatus = new HtmlCommandLink();

    public HtmlCommandLink getBtnCloseEducationalStatus() {
        return btnCloseEducationalStatus;
    }

    public void setBtnCloseEducationalStatus(HtmlCommandLink hcl) {
        this.btnCloseEducationalStatus = hcl;
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
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlInputTextarea txtReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtReason() {
        return txtReason;
    }

    public void setTxtReason(HtmlInputTextarea hit) {
        this.txtReason = hit;
    }
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkdrivingSkill = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkdrivingSkill() {
        return chkdrivingSkill;
    }

    public void setChkdrivingSkill(HtmlSelectBooleanCheckbox hsbc) {
        this.chkdrivingSkill = hsbc;
    }
    private HtmlCommandButton btnCalendarSatartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarSatartDate() {
        return btnCalendarSatartDate;
    }

    public void setBtnCalendarSatartDate(HtmlCommandButton hcb) {
        this.btnCalendarSatartDate = hcb;
    }
    private HtmlCommandButton btnEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnEndDate() {
        return btnEndDate;
    }

    public void setBtnEndDate(HtmlCommandButton hcb) {
        this.btnEndDate = hcb;
    }
    private HtmlOutputLabel lblEdurequstStstus = new HtmlOutputLabel();

    public HtmlOutputLabel getLblEdurequstStstus() {
        return lblEdurequstStstus;
    }

    public void setLblEdurequstStstus(HtmlOutputLabel hol) {
        this.lblEdurequstStstus = hol;
    }
    private HtmlOutputLabel lblEdurequstStstusdataB = new HtmlOutputLabel();

    public HtmlOutputLabel getLblEdurequstStstusdataB() {
        return lblEdurequstStstusdataB;
    }

    public void setLblEdurequstStstusdataB(HtmlOutputLabel hol) {
        this.lblEdurequstStstusdataB = hol;
    }
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private DefaultSelectedData defaultSelectedData14 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData14() {
        return defaultSelectedData14;
    }

    public void setDefaultSelectedData14(DefaultSelectedData dsd) {
        this.defaultSelectedData14 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlAllPrograms = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAllPrograms() {
        return drlAllPrograms;
    }

    public void setDrlAllPrograms(HtmlSelectOneMenu hsom) {
        this.drlAllPrograms = hsom;
    }
    private HtmlSelectBooleanCheckbox chkAllEducation = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkAllEducation() {
        return chkAllEducation;
    }

    public void setChkAllEducation(HtmlSelectBooleanCheckbox hsbc) {
        this.chkAllEducation = hsbc;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists = hsol;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EducationRequestPage() {
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
    @Override
    public void prerender() {
        if (educationLevelCatagoryList.isEmpty() ||
                (lookupnger.getEmpitiedTableList() != null && lookupnger.getEmpitiedTableList().contains("hr_lu_educ_level"))) {
            educationRequestManager.readEducationLevel(rank);
            lookupnger.getEmpitiedTableList().remove("hr_lu_educ_level");
        } else {
        }
//        if (nameOfInstitution.isEmpty()) {
//            nameOfInstitution = educationRequestManager.getNAmeOfInstitution();
//        }
//        else {
//        }
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

    public ArrayList<SelectItem> getPendingRequestList() {
        educationRequestManager.getPendingRequests();
        return pendingRequestList;
    }

    public ArrayList<SelectItem> getEducationLevelCatagoryList() {
        return educationLevelCatagoryList;
    }

    public void setEducationLevelCatagoryList(ArrayList<SelectItem> educationLevelCatagoryList) {
        this.educationLevelCatagoryList = educationLevelCatagoryList;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public ArrayList<SelectItem> getEducationTypeCatagoryList() {
        return educationTypeCatagoryList;
    }

    public void setEducationTypeCatagoryList(ArrayList<SelectItem> educationTypeCatagoryList) {
        this.educationTypeCatagoryList = educationTypeCatagoryList;
    }

    public GregorianCalendarManipulation getGregorianCalendarManipulation() {
        return gregorianCalendarManipulation;
    }

    public void setGregorianCalendarManipulation(GregorianCalendarManipulation gregorianCalendarManipulation) {
        this.gregorianCalendarManipulation = gregorianCalendarManipulation;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ArrayList<SelectItem> getEducationShiftList() {
        return educationShiftList;
    }

    public ArrayList<SelectItem> getNameOfInstitution() {
        nameOfInstitution = educationRequestManager.getNAmeOfInstitution();
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

    public void setTakenStartDate(String takenStartDate) {
        this.takenStartDate = takenStartDate;
    }

    public void setPendingRequestList(ArrayList<SelectItem> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public ArrayList<SelectItem> getRequestHistoryList() {
        educationRequestManager.getMyRequestsHistory();
        return requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<SelectItem> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public ArrayList<SelectItem> getAllFieldOfStu() {
        return allFieldOfStu;
    }

    public void setAllFieldOfStu(ArrayList<SelectItem> allFieldOfStu) {
        this.allFieldOfStu = allFieldOfStu;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public LookUpManger getLookupnger() {
        return lookupnger;
    }

    public void setLookupnger(LookUpManger lookupnger) {
        this.lookupnger = lookupnger;
    }

    public String getReasonChange() {
        return reasonChange;
    }

    public String getAllOrSecifyProgram() {
        return allOrSecifyProgram;
    }

    public void setAllOrSecifyProgram(String allOrSecifyProgram) {
        this.allOrSecifyProgram = allOrSecifyProgram;
    }

    public TerminationRequestManager getTerminationRequestManager() {
        return terminationRequestManager;
    }

    public void setTerminationRequestManager(TerminationRequestManager terminationRequestManager) {
        this.terminationRequestManager = terminationRequestManager;
    }

    public void setReasonChange(String reasonChange) {
        this.reasonChange = reasonChange;
    }

    public SimpleDateFormat getYearMonthFormat() {
        return yearMonthFormat;
    }

    public void setYearMonthFormat(SimpleDateFormat yearMonthFormat) {
        this.yearMonthFormat = yearMonthFormat;
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

    public void setEducatinalStatus(String educatinalStatus) {
        this.educatinalStatus = educatinalStatus;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
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

    public ArrayList<SelectItem> getFieldOfStu() {
        return fieldOfStu;
    }

    public void setFieldOfStu(ArrayList<SelectItem> fieldOfStu) {
        this.fieldOfStu = fieldOfStu;
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

    public String btnCalendarAppliedDate_action() {
        calAppliedDate.setRendered(true);
        return null;
    }

    public String btnCalendarSatartDate_action() {
        calStartDate.setRendered(true);
        return null;
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtEndDate.setValue(yearMonthFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        if (!checkEmployeeStatus()) {
            populateRequesterTextComponents(requesterId);
            enableComponents();
            this.setFieldOfStu(educationRequestManager.getEducationTypesByCategory(deptId));
            populateRequesterDtaeofBirth(requesterId);
        }
        return null;
    }

    public boolean checkEmployeeStatus() {
        //ArrayList<HashMap> educationPrePaidCheck = new ArrayList<HashMap>();
        String empInfoHashMap = terminationRequestManager.getEmployeeStatus(requesterId);
        if (empInfoHashMap != null) {
            if ((empInfoHashMap.equalsIgnoreCase("09")) || (empInfoHashMap.equalsIgnoreCase("05")) || (empInfoHashMap.equalsIgnoreCase("03"))) {
                showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST!! BECAUSE THE EMPLOYEE IS ALREADY RESIGN");
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public String btnSearchRequester_action() {
        if (isEntryValidForSearchTerminator()) {
            if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
                requesterId = txtRequesterId.getValue().toString();
                if (!checkEmployeeStatus()) {
                    if ((populateRequesterTextComponents(requesterId)) && populateRequesterDtaeofBirth(requesterId)) {
                        this.setFieldOfStu(educationRequestManager.getEducationTypesByCategory(deptId));
                        enableComponents();
                        educatinalStatus = "Enrolled";
                        lblEdurequstStstusdataB.setValue(educatinalStatus);
                        drlInstitutionName.setDisabled(false);
                    } else {
                        showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtRequesterId.getValue().toString());
                        requesterId = null;
                        disableComponents();
                    }
                } else {
                    requesterId = null;
                    showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
                }
            }

        }
        return null;
    }

    private boolean populateRequesterTextComponents(String employeeId) {
        HashMap empInfoEducHashMap = educationRequestManager.getEducationDuty(employeeId);
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        HashMap empEduHashMap = educationRequestManager.readEmployeeBasicInfo(employeeId);
        int date = 0;
        if (empInfoEducHashMap != null) {
            if (empInfoEducHashMap.get("GRADUATION_DATE").toString().equals("notRegister")) {
                showSuccessOrFailureMessage(false, "THE GRADUATION DATE IS UNKOWN!!");

                if (empInfoHashMap != null) {
                    if (empInfoHashMap.get("employeeId").toString().equals("") && empEduHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                        showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                        requesterId = null;
                        deptId = 0;
                        return false;
                    } else {
                        clearAllComponents();
                        requesterId = employeeId;
                        txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                        txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                        txtRequesterId.setValue(requesterId);
                        txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                        lblDeptID.setValue(empInfoHashMap.get("employeeDepartment"));
                        deptId = Integer.valueOf(lblDeptID.getValue().toString());
                        txtlblRequesterEdLevel.setValue(empEduHashMap.get("levels"));
                        txtlblRequesterProgramName.setValue(empEduHashMap.get("description"));
                        return true;
                    }
                }
                return false;
            } else {
                String graduationDate = empInfoEducHashMap.get("GRADUATION_DATE").toString();
                String approvedOrNot = empInfoEducHashMap.get("APPROVE_DENY").toString();
                String ServiceYr = empInfoEducHashMap.get("DUTY_SERVICE_YR").toString();
                int serviceYr = Integer.valueOf(ServiceYr);
                date = GregorianCalendarManipulation.calaculateYearDifference(graduationDate);

                if ((date <= serviceYr && approvedOrNot.equalsIgnoreCase("deney"))) {//date == serviceYr &&
                    showSuccessOrFailureMessage(false, "YOU CAN'T REQUEST EDUCATION BECAUSE YOU ARE NOT FINISH YOUR DUTY!!");
                    return true;
                } else {
                    if (empInfoHashMap != null) {
                        if (empInfoHashMap.get("employeeId").toString().equals("") && empEduHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                            showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                            requesterId = null;
                            deptId = 0;
                            return false;
                        } else {
                            requesterId = employeeId;
                            txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                            txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                            txtRequesterId.setValue(requesterId);
                            txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                            lblDeptID.setValue(empInfoHashMap.get("employeeDepartment"));
                            deptId = Integer.valueOf(lblDeptID.getValue().toString());
                            txtlblRequesterEdLevel.setValue(empEduHashMap.get("levels"));
                            txtlblRequesterProgramName.setValue(empEduHashMap.get("description"));
                            return true;
                        }
                    } else {
                        requesterId = null;
                        deptId = 0;
                        showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
                        return false;
                    }

                }
            }
        } else {
            if (empInfoHashMap != null) {
                if (empInfoHashMap.get("employeeId").toString().equals("") && empEduHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                    showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                    requesterId = null;
                    deptId = 0;
                    return false;
                } else {
                    requesterId = employeeId;
                    txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                    txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                    txtRequesterId.setValue(requesterId);
                    txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                    lblDeptID.setValue(empInfoHashMap.get("employeeDepartment"));
                    deptId = Integer.valueOf(lblDeptID.getValue().toString());
                    txtlblRequesterEdLevel.setValue(empEduHashMap.get("levels"));
                    txtlblRequesterProgramName.setValue(empEduHashMap.get("description"));
                    return true;
                }
            } else {
                requesterId = null;
                deptId = 0;
                showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
                return false;
            }
        }
    }

    private boolean populateRequesterDtaeofBirth(String employeeId) {

        String empInfoHashMap = educationRequestManager.getDateOfBirth(employeeId);
        String hireDate = educationRequestManager.getHIREDATE(employeeId);
        appliedDate = txtAppliedDate.getValue().toString();
        txtBirthDate.setValue(empInfoHashMap);
        int date = GregorianCalendarManipulation.calaculateYearDifference(empInfoHashMap);
        int expriance = GregorianCalendarManipulation.calaculateYearDifference(hireDate);

        if ((date > 50) || (expriance < 2)) {
            if (date > 50) {//if age is gretertahn 50
                 disableComponents();
                showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST THE EDUCATION BECAUSE YOUR AGE IS:" + date);
               
            }

            if (expriance < 2) {
                 disableComponents();
                showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST THE EDUCATION BECAUSE YOUR EXPRIANCE IS:" + expriance);
            }

            btnSaveOrUpdate.setDisabled(true);
            disableComponents();

        } else {
            btnSaveOrUpdate.setDisabled(false);
            enableComponents();

        }


        return true;
    }

    private void populateDecisionHistory(int overTimeRequestId) {
        decisionsMadeOnRequestList = educationApproveManager.getRequestHistory(overTimeRequestId);

    }

//    public boolean setSelectedDisciplineType(String disciplineType) {
//
//        for (SelectItem lookingFor : nameOfInstitution) {
//            if (lookingFor.getValue().toString().startsWith(disciplineType)) {
//                drlInstitutionName.setValue(lookingFor.getValue().toString());
//                return true;
//            }
//        }
//        return false;
//    }
    private boolean populateRequestTextComponents(int requestId) {

        educationRequestModel = educationRequestManager.getEducationRequest(requestId);
        if (educationRequestModel != null) {
            if (educationRequestModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {
                if (educationRequestModel.getAllOrSecifyProgram().equals("Sepecific")) {
                    drlProgramName.setDisabled(false);
                    drlAllPrograms.setDisabled(true);
                    drlProgramName.setValue(null);
                    drlAllPrograms.setValue(null);
                    drlAllPrograms.setRendered(false);
                    chkAllEducation.setSelected(false);
                    drlProgramName.setValue(educationRequestModel.getEducationProgramName());
                } else {
                    chkAllEducation.setSelected(true);
                    drlProgramName.setDisabled(true);
                    drlAllPrograms.setDisabled(false);
                    drlProgramName.setValue(null);
                    drlAllPrograms.setRendered(true);
                    drlAllPrograms.setValue(null);
                    drlAllPrograms.setValue(educationRequestModel.getEducationProgramName());
                }
                setFieldOfStu(educationRequestManager.getEducationTypesByCategory(Integer.valueOf(lblDeptID.getValue().toString())));
                txtNumberOfCreditHours.setValue(educationRequestModel.getNumberOfCreditHours());
                txtAppliedDate.setValue(educationRequestModel.getAppliedDate());
                txtCostPerCreditHour.setValue(educationRequestModel.getCostPerCreditHour());
                txtDocumentReferenceNumber.setValue(educationRequestModel.getDocumentReferenceNumber());
                txtDurationInYear.setValue(educationRequestModel.getDurationInYear());
                txtaInstitutionName.setValue(educationRequestModel.getInstitutionName());
                txtRemark.setValue(educationRequestModel.getReasonDescription());
                txtStartDate.setValue(educationRequestModel.getStartDate());
                txtTotalAdminstrativeCost.setValue(educationRequestModel.getTotalAdminstrationCosts());
                // txtaInstitutionAddress.setValue(educationRequestModel.getInstitutionAddress());
                drlEducationLevelCatagory.setValue(educationRequestModel.getEducationLevelCategory());
                drlEducationShift.setValue(educationRequestModel.getEducationShiftCategory());
                //txtAccred.setValue(educationRequestModel.getInstitutionAccredited());
                //txtInsideOut.setValue(educationRequestModel.getEthiopianInstitution());
                lblEduRequestId.setValue(educationRequestModel.getEducationRequestId());
                lblRequesterID.setValue(educationRequestModel.getRequesterId());
                drlInstitutionName.setValue(educationRequestModel.getInstitutionName());

                txtEndDate.setValue(educationRequestModel.getEndDate());
                lblEdurequstStstusdataB.setValue(educationRequestModel.getEducatinalStatus());
                drlEducationLevelCatagory.setDisabled(false);
                if (educationRequestModel.getLevelID().equalsIgnoreCase("BASIC")) {
                    chkBAsic.setSelected(true);
                    chkHigher.setSelected(false);
                    chkdrivingSkill.setSelected(false);
                    rank =
                            13;
                    this.setEducationLevelCatagoryList(educationRequestManager.readEducationLevel(rank));
                }

                if (educationRequestModel.getLevelID().equalsIgnoreCase("HIGH")) {
                    chkHigher.setSelected(true);
                    chkBAsic.setSelected(false);
                    chkdrivingSkill.setSelected(false);
                    rank =
                            13;
                    this.setEducationLevelCatagoryList(educationRequestManager.readHigherEducationLevel(rank));

                }

                if (educationRequestModel.getLevelID().equalsIgnoreCase("DRIV")) {
                    chkdrivingSkill.setSelected(true);
                    chkHigher.setSelected(false);
                    chkBAsic.setSelected(false);
                    rank =
                            31;
                    this.setEducationLevelCatagoryList(educationRequestManager.readDrivingSkill(rank));

                }
                institutionID = drlInstitutionName.getValue().toString();
                institutionAddress = educationRequestManager.getInstituAdress(institutionID);
                txtaInstitutionAddress.setValue(institutionAddress);
                ethiopianInstitution = educationRequestManager.getInsideOutside(institutionID);
                if (ethiopianInstitution != null) {
                    if (ethiopianInstitution.equalsIgnoreCase("IN")) {
                        txtInsideOut.setValue("Inside Ethiopia");
                    }

                    if (ethiopianInstitution.equalsIgnoreCase("OUT")) {
                        txtInsideOut.setValue("Outside Ethiopia");
                    }
                } else {
                    txtInsideOut.setValue("-------");
                }
                institutionAccredited = educationRequestManager.getTypeOFAccredated(institutionID);
                if (institutionAccredited != null) {
                    if (institutionAccredited.equalsIgnoreCase("AC")) {
                        txtAccred.setValue("Accredited ");
                    }

                    if (institutionAccredited.equalsIgnoreCase("IN")) {
                        txtAccred.setValue("Not Accredited ");
                    }
                } else {
                    txtAccred.setValue("-----");

                }

                return true;
            }

        } else {
            educationRequestId = -1;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }

    private boolean populateRequestTextChangeInsComponents(String requesterId) {

        educationRequestModel = educationRequestManager.getEducationChangInsRequest(requesterId);
        if (educationRequestModel != null) {
            if (educationRequestModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requesterId);
                return false;
            } else {
                drlProgramName.setValue(educationRequestModel.getEducationProgramName());
                txtNumberOfCreditHours.setValue(educationRequestModel.getNumberOfCreditHours());
                txtAppliedDate.setValue(educationRequestModel.getAppliedDate());
                txtCostPerCreditHour.setValue(educationRequestModel.getCostPerCreditHour());
                txtDocumentReferenceNumber.setValue(educationRequestModel.getDocumentReferenceNumber());
                txtDurationInYear.setValue(educationRequestModel.getDurationInYear());
                txtaInstitutionName.setValue(educationRequestModel.getInstitutionName());
                txtRemark.setValue(educationRequestModel.getReasonDescription());
                txtStartDate.setValue(educationRequestModel.getStartDate());
                txtTotalAdminstrativeCost.setValue(educationRequestModel.getTotalAdminstrationCosts());
                txtaInstitutionAddress.setValue(educationRequestModel.getInstitutionAddress());
                drlEducationLevelCatagory.setValue(educationRequestModel.getEducationLevelCategory());
                drlEducationShift.setValue(educationRequestModel.getEducationShiftCategory());
                //    drlEducationTypeCatagory.setValue(educationRequestModel.getEducationTypeCategory());
                lblEduRequestId.setValue(educationRequestModel.getEducationRequestId());
                lblRequesterID.setValue(educationRequestModel.getRequesterId());
//               
                return true;
            }

        } else {
            educationRequestId = -1;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        txtTotalAdminstrativeCost.setValue(null);
        txtlblRequesterEdLevel.setValue(null);
        txtlblRequesterProgramName.setValue(null);
    }

    private void clearAllComponents() {
        clearRequestComponents();
        clearRequesterTextComponents();

        clearDropDownItems();

        //makePageReadyForUpdate();

    }

    private void clearDropDownItems() {
        selectedRequestFromMyRequestList = new DefaultSelectedData();
        selectedRequestFromHistoryList.setSelectedObject(null);
        selectObjectOfEducationTypeCatagory.setSelectedObject(null);
        selectObjectOfEducationLevelCatagory.setSelectedObject(null);
        selectObjectOfEducationShiftCatagory.setSelectedObject(null);
    }

    public boolean isEntryValidForSearchTerminator() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required =
                HRValidation.validateRequired(this.txtRequesterId.getValue());
        if (!required) {
            ((UIInput) txtRequesterId).setValid(false);
            error(txtRequesterId, errorMessage);
            results =
                    false;
        }

        return results;
    }

    public boolean isEntryValidForTermination() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required =
                HRValidation.validateRequired(this.drlEducationLevelCatagory.getValue());
        if (!required) {
            ((UIInput) drlEducationLevelCatagory).setValid(false);
            error(drlEducationLevelCatagory, errorMessage);
            results =
                    false;
        }

        required = HRValidation.validateRequired(this.drlEducationShift.getValue());
        if (!required) {
            ((UIInput) drlEducationShift).setValid(false);
            error(drlEducationShift, errorMessage);
            results =
                    false;
        }

        required = HRValidation.validateRequired(this.drlInstitutionName.getValue());
        if (!required) {
            ((UIInput) drlInstitutionName).setValid(false);
            error(drlInstitutionName, errorMessage);
            results =
                    false;
        }
//        required = HRValidation.validateRequired(this.drlProgramName.getValue());
//        if (!required) {
//            ((UIInput) drlProgramName).setValid(false);
//            error(drlProgramName, errorMessage);
//            results = false;
//        }

//        required = HRValidation.validateRequired(this.txtAccred.getValue());
//        if (!required) {
//            ((UIInput) txtAccred).setValid(false);
//            error(txtAccred, errorMessage);
//            results =
//                    false;
//        }

        required = HRValidation.validateRequired(this.txtDocumentReferenceNumber.getValue());
        if (!required) {
            ((UIInput) txtDocumentReferenceNumber).setValid(false);
            error(txtDocumentReferenceNumber, errorMessage);
            results =
                    false;
        }

//        required = HRValidation.validateRequired(this.txtInsideOut.getValue());
//        if (!required) {
//            ((UIInput) txtInsideOut).setValid(false);
//            error(txtInsideOut, errorMessage);
//            results =
//                    false;
//        }

//        required = HRValidation.validateRequired(this.txtRequesterDepartment.getValue());
//        if (!required) {
//            ((UIInput) txtRequesterDepartment).setValid(false);
//            error(txtRequesterDepartment, errorMessage);
//            results =
//                    false;
//        }

        required = HRValidation.validateRequired(this.txtRequesterFullName.getValue());
        if (!required) {
            ((UIInput) txtRequesterFullName).setValid(false);
            error(txtRequesterFullName, errorMessage);
            results =
                    false;
        }

        errorValue = HRValidation.validateData(this.txtAppliedDate.getValue(), HRValidation.DATE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtAppliedDate).setValid(false);
                error(txtAppliedDate, errorMessage);
            } else {
                ((UIInput) txtAppliedDate).setValid(false);
                error(txtAppliedDate, "Invalid Value");
            }
        }
        required = HRValidation.validateRequired(this.txtEndDate.getValue());
        if (!required) {
            ((UIInput) txtEndDate).setValid(false);
            error(txtEndDate, errorMessage);
            results =
                    false;
        }

        errorValue = HRValidation.validateData(this.txtDurationInYear.getValue(), HRValidation.DOUBLE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtDurationInYear).setValid(false);
                error(txtDurationInYear, errorMessage);
            } else {
                ((UIInput) txtDurationInYear).setValid(false);
                error(txtDurationInYear, "Invalid Value");
            }

        }
        errorValue = HRValidation.validateData(this.txtCostPerCreditHour.getValue(), HRValidation.FLOAT_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtCostPerCreditHour).setValid(false);
                error(txtCostPerCreditHour, errorMessage);
            } else {
                ((UIInput) txtCostPerCreditHour).setValid(false);
                error(txtCostPerCreditHour, "Invalid Value");
            }

        }
        errorValue = HRValidation.validateData(this.txtNumberOfCreditHours.getValue(), HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtNumberOfCreditHours).setValid(false);
                error(txtNumberOfCreditHours, errorMessage);
            } else {
                ((UIInput) txtNumberOfCreditHours).setValid(false);
                error(txtNumberOfCreditHours, "Invalid Value");
            }

        }
        errorValue = HRValidation.validateData(this.txtStartDate.getValue(), HRValidation.DATE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtStartDate).setValid(false);
                error(txtStartDate, errorMessage);
            } else {
                ((UIInput) txtStartDate).setValid(false);
                error(txtStartDate, "Invalid Value");
            }

        }
        errorValue = HRValidation.validateData(this.txtTotalAdminstrativeCost.getValue(), HRValidation.DOUBLE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtTotalAdminstrativeCost).setValid(false);
                error(txtTotalAdminstrativeCost, errorMessage);
            } else {
                ((UIInput) txtTotalAdminstrativeCost).setValid(false);
                error(txtTotalAdminstrativeCost, "Invalid Value");
            }

        }
        return results;
    }

    public void enableComponents() {
        drlProgramName.setDisabled(false);
        txtNumberOfCreditHours.setDisabled(false);
        txtAppliedDate.setDisabled(false);
        txtCostPerCreditHour.setDisabled(false);
        txtDocumentReferenceNumber.setDisabled(false);
        txtDurationInYear.setDisabled(false);
        txtaInstitutionName.setDisabled(false);
        txtRemark.setDisabled(false);
        txtStartDate.setDisabled(false);
        txtaInstitutionAddress.setDisabled(false);
        // drlEducationLevelCatagory.setDisabled(false);
        drlEducationShift.setDisabled(false);
        txtTotalAdminstrativeCost.setDisabled(false);
        drlInstitutionName.setDisabled(false);
        txtAccred.setDisabled(false);
        txtInsideOut.setDisabled(false);
        txtaInstitutionAddress.setDisabled(false);
        chkBAsic.setDisabled(false);
        chkHigher.setDisabled(false);
        txtEndDate.setDisabled(false);
        chkdrivingSkill.setDisabled(false);
        btnCalendarSatartDate.setDisabled(false);
        btnCloseEducationalStatus.setDisabled(false);
        chkAllEducation.setDisabled(false);
    }

    public void disableComponents() {
        chkAllEducation.setDisabled(true);
        drlProgramName.setDisabled(true);
        txtNumberOfCreditHours.setDisabled(true);
        txtAppliedDate.setDisabled(true);
        txtCostPerCreditHour.setDisabled(true);
        txtDocumentReferenceNumber.setDisabled(true);
        txtDurationInYear.setDisabled(true);
        txtaInstitutionName.setDisabled(true);
        txtRemark.setDisabled(true);
        txtStartDate.setDisabled(true);
        txtaInstitutionAddress.setDisabled(true);
        drlEducationLevelCatagory.setDisabled(true);
        drlEducationShift.setDisabled(true);
        txtTotalAdminstrativeCost.setDisabled(true);
        drlInstitutionName.setDisabled(true);
        txtAccred.setDisabled(true);
        txtInsideOut.setDisabled(true);
        txtaInstitutionAddress.setDisabled(true);
        chkBAsic.setDisabled(true);
        chkHigher.setDisabled(true);
        txtEndDate.setDisabled(true);
        chkdrivingSkill.setDisabled(true);
        btnCalendarSatartDate.setDisabled(true);
        btnCloseEducationalStatus.setDisabled(true);
    }

    public void clearRequestComponents() {
        drlProgramName.setValue(null);
        txtNumberOfCreditHours.setValue(null);
        txtCostPerCreditHour.setValue(null);
        txtDocumentReferenceNumber.setValue(null);
        txtDurationInYear.setValue(null);
        txtaInstitutionName.setValue(null);
        txtRemark.setValue(null);
        txtStartDate.setValue(null);
        txtaInstitutionAddress.setValue(null);
        drlEducationLevelCatagory.setValue(null);
        drlEducationShift.setValue(null);
        txtTotalAdminstrativeCost.setValue(null);
        drlInstitutionName.setValue(null);
        txtAccred.setValue(null);
        txtInsideOut.setValue(null);
        txtaInstitutionAddress.setValue(null);
        chkBAsic.setSelected(false);
        chkHigher.setSelected(false);
        txtEndDate.setValue(null);
        lblEdurequstStstusdataB.setValue(null);
        chkAllEducation.setSelected(false);
        drlAllPrograms.setValue(null);

    }

    private void makePageReadyForSave() {
        clearAllComponents();
        newOrEditOrUpdateLabel =
                "Save";
        btnSaveOrUpdate.setDisabled(false);
    }

    private void makePageReadyForUpdate() {
        enableComponents();
        newOrEditOrUpdateLabel =
                "Update";
        btnDelete.setDisabled(false);
        btnSaveOrUpdate.setDisabled(false);
        lnkViewPrevieousDecisions.setRendered(false);
        lnkViewsatusOfEducation.setRendered(true);
    }

    private void makePageReadyForView() {
        disableComponents();
        newOrEditOrUpdateLabel =
                "Save";
        btnDelete.setDisabled(true);
        btnSaveOrUpdate.setDisabled(true);
        lnkViewPrevieousDecisions.setRendered(true);
        lnkViewsatusOfEducation.setRendered(true);
    }

// <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
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

// </editor-fold>
// </editor-fold >
// </editor-fold >
    EmployeeManage employeeManager = new EmployeeManage();
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationRequestManager educationRequestManager = new EducationRequestManager();
    TerminationRequestManager terminationRequestManager = new TerminationRequestManager();
    EducationApproveManager educationApproveManager = new EducationApproveManager();
    JobTypeQualificationManager jobTypeQualificationManager = new JobTypeQualificationManager();
    LookUpManger lookupnger = new LookUpManger();
    GregorianCalendarManipulation gregorianCalendarManipulation = new GregorianCalendarManipulation();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationTypeCatagoryList = educationRequestManager.getprogramCategory();
    ArrayList<SelectItem> educationLevelCatagoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> nameOfInstitution = new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationShiftList = educationRequestManager.getEducationShift();
    //ArrayList<SelectItem> nameOfInstitution = educationRequestManager.getNAmeOfInstitution();
    // ArrayList<SelectItem> programName = jobTypeQualificationManager.getEducationTypesByCategory("-1");
    ArrayList<SelectItem> fieldOfStu = educationRequestManager.getEducationTypesByCategory(deptId);
    ArrayList<SelectItem> allFieldOfStu = educationRequestManager.getAllEducationTypesByCategory();
    ArrayList<SelectItem> educationalStatus = educationRequestManager.getEducationalStatus();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationTypeCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationLevelCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationShiftCatagory = new DefaultSelectedData();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
    String loggedInEmployeeId;
    String userName;
    int educationRequestId;
    String requesterId;//
    String educationProgramName;
    String allOrSecifyProgram;
    String institutionName;
    String ethiopianInstitution;//inside or outside ethiopia
    String institutionAccredited;//
    String institutionAddress;
    String institutionID;
    String startDate;
    String appliedDate;
    String educationShiftCategory;//
    String educationTypeCategory;//
    String educationLevelCategory;//
    double costPerCreditHour;
    int numberOfCreditHours;
    double totalAdminstrationCosts;
    double durationInYear;
    String reasonDescription;
    String documentReferenceNumber;
    String requestStatus;
    String timeStamp;
    String educatinalStatus;
    String dateOfStatusUpdate;
    String endDate;
    String levelId;
    String reasonChange;

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            selectMyHistoryLists.setValue(null);
            String[] requestAttributes = vce.getNewValue().toString().split("--");
            educationRequestId =
                    Integer.parseInt(requestAttributes[0]);
            requesterId =
                    requestAttributes[1];
            requestStatus =
                    requestAttributes[2];
            populateRequesterTextComponents(requesterId);
            populateRequestTextComponents(educationRequestId);
            populateDecisionHistory(educationRequestId);
            makePageReadyForUpdate();

            lnkViewsatusOfEducation.setRendered(true);
        }

    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            selectMyRequestLists.setValue(null);
            String[] requestAttributes = vce.getNewValue().toString().split("--");
            educationRequestId =
                    Integer.parseInt(requestAttributes[0]);
            requesterId =
                    requestAttributes[1];
            requestStatus =
                    requestAttributes[2];
            populateRequesterTextComponents(requesterId);
            populateRequestTextComponents(educationRequestId);
            populateDecisionHistory(educationRequestId);
            lnkViewsatusOfEducation.setRendered(true);
            makePageReadyForView();

        }


    }
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

            pendingRequestList =
                    educationRequestManager.getPendingRequests();
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

    private boolean validateAndInitializeAttributes() {
        if (false) {
            showSuccessOrFailureMessage(false, "PLEASE SELECT EMPLOYEE");
            return false;
        } else if (false) {
            return false;
        } else {
            deptId = Integer.valueOf(lblDeptID.getValue().toString());
            requesterId =
                    txtRequesterId.getValue().toString();
            if (chkAllEducation.isSelected()) {
                educationProgramName = drlAllPrograms.getValue().toString();
                allOrSecifyProgram = "All";
            } else {
                educationProgramName = drlProgramName.getValue().toString();
                allOrSecifyProgram = "Sepecific";
            }

            institutionName = drlInstitutionName.getValue().toString();
            ethiopianInstitution =
                    txtInsideOut.getValue().toString();
            institutionAccredited =
                    txtAccred.getValue().toString();
            institutionAddress =
                    txtaInstitutionAddress.getValue().toString();
            startDate =
                    txtStartDate.getValue().toString();
            appliedDate =
                    txtAppliedDate.getValue().toString();
            educationShiftCategory =
                    drlEducationShift.getValue().toString();
            //educationTypeCategory = drlEducationTypeCatagory.getValue().toString().split("-")[1];
            educationLevelCategory =
                    drlEducationLevelCatagory.getValue().toString();
            costPerCreditHour =
                    Double.parseDouble(txtCostPerCreditHour.getValue().toString());
            numberOfCreditHours =
                    Integer.parseInt(txtNumberOfCreditHours.getValue().toString());
            totalAdminstrationCosts =
                    Double.parseDouble(txtTotalAdminstrativeCost.getValue().toString());
            durationInYear =
                    Double.parseDouble(txtDurationInYear.getValue().toString());
            reasonDescription =
                    txtRemark.getValue().toString();
            documentReferenceNumber =
                    txtDocumentReferenceNumber.getValue().toString();
            educatinalStatus =
                    "Enrolled";
            dateOfStatusUpdate =
                    txtAppliedDate.getValue().toString();
            endDate =
                    txtEndDate.getValue().toString();
            if (chkBAsic.isSelected()) {
                levelId = "BASIC";
            }

            if (chkHigher.isSelected()) {
                levelId = "HIGH";
            }

            if (chkdrivingSkill.isSelected()) {
                levelId = "DRIV";
            }

            return true;
        }

    }

    public String btnSaveOrUpdate_action() {
        if (isEntryValidForTermination()) {
            if (validateAndInitializeAttributes()) {
                if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
                    if (educationRequestManager.saveEducationRequest(requesterId, 
                            educationProgramName,
                            institutionName,
                            ethiopianInstitution,
                            institutionAccredited,
                            institutionAddress,
                            startDate,
                            appliedDate,
                            educationShiftCategory,
                            educationLevelCategory,
                            costPerCreditHour,
                            numberOfCreditHours,
                            totalAdminstrationCosts,
                            durationInYear,
                            reasonDescription,
                            documentReferenceNumber,
                            requestStatus,
                            dateOfStatusUpdate,
                            educatinalStatus,
                            endDate,
                            levelId,
                            allOrSecifyProgram)) {
                        showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                        pendingRequestList =
                                educationRequestManager.getPendingRequests();
                        clearAllComponents();

                    } else {
                        showSuccessOrFailureMessage(false, "SAVING FAILED");
                    }

                } else {//if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
                    if (educationRequestManager.updateEducationRequest(educationRequestId, requesterId, educationProgramName, institutionName, ethiopianInstitution, institutionAccredited, institutionAddress, startDate, appliedDate, educationShiftCategory, educationLevelCategory, costPerCreditHour, numberOfCreditHours, totalAdminstrationCosts, durationInYear, reasonDescription, documentReferenceNumber, requestStatus, endDate, levelId, allOrSecifyProgram)) {
                        showSuccessOrFailureMessage(true, "UPDATING SUCCESSFUL");
                        clearAllComponents();

                    } else {
                        showSuccessOrFailureMessage(false, "UPDATING FAILED");
                    }

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
        //populateDecisionHistory(educationRequestId);
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

    public void drlInstitutionName_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {

            institutionID = vce.getNewValue().toString();
            institutionAddress = educationRequestManager.getInstituAdress(institutionID);
            txtaInstitutionAddress.setValue(institutionAddress);
            ethiopianInstitution = educationRequestManager.getInsideOutside(institutionID);
            if (ethiopianInstitution != null) {
                if (ethiopianInstitution.equalsIgnoreCase("IN")) {
                    txtInsideOut.setValue("Inside Ethiopia");
                }

                if (ethiopianInstitution.equalsIgnoreCase("OUT")) {
                    txtInsideOut.setValue("Outside Ethiopia");
                }

            } else {
                txtInsideOut.setValue("-------");
            }

            institutionAccredited = educationRequestManager.getTypeOFAccredated(institutionID);
            if (institutionAccredited != null) {
                if (institutionAccredited.equalsIgnoreCase("AC")) {
                    txtAccred.setValue("Accredited ");
                }

                if (institutionAccredited.equalsIgnoreCase("IN")) {
                    txtAccred.setValue("Not Accredited ");
                }
            } else {
                txtAccred.setValue("-----");

            }
        }
    }

    public void drlEducationLevelCatagory_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals("Masters  (Science)") || vce.getNewValue().toString().equals("Masters (Art)")) {
            String empInfoHashMap = educationRequestManager.getDateOfBirth(requesterId);
            String hireDate = educationRequestManager.getHIREDATE(requesterId);
            appliedDate = txtAppliedDate.getValue().toString();
            txtBirthDate.setValue(empInfoHashMap);
            int date = GregorianCalendarManipulation.calaculateYearDifference(empInfoHashMap);
            int expriance = GregorianCalendarManipulation.calaculateYearDifference(hireDate);

            if ((date > 50) || (expriance < 2)) {
                if (date > 50) {//if age is gretertahn 50
                    showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST THE EDUCATION BECAUSE YOUR AGE IS:" + date);

                }

                if (expriance < 2) {
                    showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST THE EDUCATION BECAUSE YOUR EXPRIANCE IS:" + expriance);

                }

                btnSaveOrUpdate.setDisabled(true);
                disableComponents();

            } else {
                btnSaveOrUpdate.setDisabled(false);
                enableComponents();

            }
        } else {
            btnSaveOrUpdate.setDisabled(false);
            enableComponents();
        }
    }

    public String btnCloseViewPreviesDecisions_action() {
        //return null means stay on the same page
        pnlPopupViewPrevieousDecisions.setRendered(false);
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
        txtReason.resetValue();
        return null;
    }

    public String btnSavePop_action() {
        //return null means stay on the same page
        try {
            educatinalStatus = drlEducationRegisStatus.getValue().toString();
            dateOfStatusUpdate =
                    txtdate.getValue().toString();
            educationRequestId =
                    Integer.valueOf(lblEduRequestId.getValue().toString());
            requesterId =
                    lblRequesterID.getValue().toString();
            reasonChange =
                    txtReason.getValue().toString();
            if (educationRequestManager.updateEducationStatus(reasonChange, educationRequestId, requesterId, educatinalStatus, dateOfStatusUpdate, requestStatus)) {
                pnlPopupEduactionaStatus.setRendered(false);
                showSuccessOrFailureMessage(true, "UPDATING SUCCESSFUL");
            } else {
                showSuccessOrFailureMessage(false, "UPDATING FAILED");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return null;
    }

    public void chkBAsic_processValueChange(ValueChangeEvent vce) {
        chkHigher.setSelected(false);
        chkdrivingSkill.setSelected(false);
        drlEducationLevelCatagory.setDisabled(false);
        rank =13;
               
        this.setEducationLevelCatagoryList(educationRequestManager.readEducationLevel(rank));
    }

    public void chkHigher_processValueChange(ValueChangeEvent vce) {
        chkBAsic.setSelected(false);
        chkdrivingSkill.setSelected(false);
        drlEducationLevelCatagory.setDisabled(false);
        rank =
                13;
        this.setEducationLevelCatagoryList(educationRequestManager.readHigherEducationLevel(rank));
    }

    public void btnSaveOrUpdate_processAction(ActionEvent ae) {
    }

    public String lnkEducationRequest_action() {
        // TODO: Replace with your code
        return "EducationRequest";
    }

    public String lnkEducationPaymentRequest_action() {
        // TODO: Replace with your code
        return "EducationPaymentRequest";
    }

    public String lnkEducationApprove_action() {
        // TODO: Replace with your code
        return "EducationApprove";
    }

    public String lnkEducationPaymentApprove_action() {
        // TODO: Replace with your code
        return "EducationPaymentApprove";
    }

    public String lnkChangeiNstitutionReq_action() {
        // TODO: Replace with your code
        return "ChangeInstitutionPage";
    }

    public String lnkChangeInstApprove_action() {
        // TODO: Replace with your code
        return "ChangeInstitutionaPRROVEPage";
    }

    public String lnkInstRegistration_action() {
        // TODO: Replace with your code
        return "InstitutionRegistrationPage";
    }

    public String btnCloseEducationalStatus_action() {
        //return null means stay on the same page
        pnlPopupEduactionaStatus.setRendered(false);
        return null;
    }

    public String btnEndDate_action() {
        //return null means stay on the same page
        calAppliedDate.setRendered(true);
        return null;
    }

    public void chkdrivingSkill_processValueChange(ValueChangeEvent vce) {
        chkBAsic.setSelected(false);
        chkHigher.setSelected(false);
        drlEducationLevelCatagory.setDisabled(false);
        rank =
                31;
        this.setEducationLevelCatagoryList(educationRequestManager.readDrivingSkill(rank));

    }

    public String cmdLinkConfirmCommitteeDecisions_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkViewsatusOfEducation_action() {
        //return null means stay on the same page
        pnlPopupEduactionaStatus.setRendered(true);
        return null;
    }

    public String lnkEducation_action() {
        //return null means stay on the same page
        pnlPopupEduactionaStatus.setRendered(true);
        return null;
    }

    public void txtReason_processValueChange(ValueChangeEvent vce) {
    }

    public void chkAllEducation_processValueChange(ValueChangeEvent vce) {
        drlAllPrograms.setDisabled(false);
        drlAllPrograms.setRendered(true);
    }

    public void drlInstitutionName_validate(FacesContext context, UIComponent component, Object value) {
    }

    public String txtRequesterId_action() {
        //return null means stay on the same page
        return null;
    }
}