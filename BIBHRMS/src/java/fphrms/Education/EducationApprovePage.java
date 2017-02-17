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
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGrid;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectManyListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.ByteArrayResource;
import com.icesoft.faces.context.Resource;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.io.File;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.CommeeteeCommentsGiven;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.employeeManager.EmployeeManage;
import manager.educationManager.EducationApproveManager;
import manager.educationManager.EducationApproveManager.FileUpLoad;
import manager.educationManager.EducationRequestManager;
import manager.educationManager.EducationRequestModel;
import manager.fileManager.ResourceManager;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.HRValidation;
import manager.userManagement.SiteSecurityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EducationApprovePage extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userName = getSessionBean1().getUserName();
        educationRequestManager.setUserName(userName);
        educationApproveManager.setUserName(userName);
        educationApproveManager.setLoggedInEmployeeId(loggedInEmployeeId);
        requestListsToBeApproved = educationApproveManager.getRequestsToBeProcessed();
        requestHistoryList = educationApproveManager.getMyDecisionsOnRequests();
        committeeForwardList = educationApproveManager.getCommeeteforwardListByApprover();
        this.disablecommentspopoUp();


        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        faResource = new ResourceManager(ec, "resourceName");


    }
    private Resource faResource;
    private String mimeType;
    public String fileName = "";
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public ArrayList<EducationRequestModel> getAvailableForwardedList() {
        return availableForwardedList;
    }

    public void setAvailableForwardedList(ArrayList<EducationRequestModel> availableForwardedList) {
        this.availableForwardedList = availableForwardedList;
    }

    public ArrayList<SelectItem> getForwardedList() {
        return forwardedList;
    }

    public void setForwardedList(ArrayList<SelectItem> forwardedList) {
        this.forwardedList = forwardedList;
    }

    public ArrayList<SelectItem> getMinuteAttachedForwardedList() {
        return minuteAttachedForwardedList;
    }

    public void setMinuteAttachedForwardedList(ArrayList<SelectItem> minuteAttachedForwardedList) {
        this.minuteAttachedForwardedList = minuteAttachedForwardedList;
    }

    public Object[] getSelectedForwarededRequest() {
        return selectedForwarededRequest;
    }

    public void setSelectedForwarededRequest(Object[] selectedForwarededRequest) {
        this.selectedForwarededRequest = selectedForwarededRequest;
    }

    public DefaultSelectedData getSelectedforwardedList() {
        return selectedforwardedList;
    }

    public void setSelectedforwardedList(DefaultSelectedData selectedforwardedList) {
        this.selectedforwardedList = selectedforwardedList;
    }

    public int getRequestFile() {
        return requestFile;
    }

    public void setRequestFile(int requestFile) {
        this.requestFile = requestFile;
    }

    public int getSizeOfForwardedRquest() {
        return sizeOfForwardedRquest;
    }

    public void setSizeOfForwardedRquest(int sizeOfForwardedRquest) {
        this.sizeOfForwardedRquest = sizeOfForwardedRquest;
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
    private DefaultSelectItemsArray selectOneMenu1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems = dsia;
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
    private HtmlInputText txtRequesterFullName = new HtmlInputText();

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public HtmlInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(HtmlInputText txtRequesterFullName) {
        this.txtRequesterFullName = txtRequesterFullName;
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

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

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
    private HtmlInputText txtTotalAdminstrativeCost = new HtmlInputText();

    public HtmlInputText getTxtTotalAdminstrativeCost() {
        return txtTotalAdminstrativeCost;
    }

    public void setTxtTotalAdminstrativeCost(HtmlInputText hit) {
        this.txtTotalAdminstrativeCost = hit;
    }
    private HtmlInputText txtDocumentReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocumentReferenceNumber() {
        return txtDocumentReferenceNumber;
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
    private HtmlSelectOneMenu drlEducationTypeCatagory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationTypeCatagory() {
        return drlEducationTypeCatagory;
    }

    public void setDrlEducationTypeCatagory(HtmlSelectOneMenu hsom) {
        this.drlEducationTypeCatagory = hsom;
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
    private HtmlInputText txtEducationProgramName = new HtmlInputText();

    public HtmlInputText getTxtEducationProgramName() {
        return txtEducationProgramName;
    }

    public void setTxtEducationProgramName(HtmlInputText hit) {
        this.txtEducationProgramName = hit;
    }
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
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
    private HtmlInputText txtAccred = new HtmlInputText();

    public HtmlInputText getTxtAccred() {
        return txtAccred;
    }

    public void setTxtAccred(HtmlInputText hit) {
        this.txtAccred = hit;
    }
    private HtmlInputText txtInsideOut = new HtmlInputText();

    public HtmlInputText getTxtInsideOut() {
        return txtInsideOut;
    }

    public void setTxtInsideOut(HtmlInputText hit) {
        this.txtInsideOut = hit;
    }
    private HtmlInputText txtEducationLevel = new HtmlInputText();

    public HtmlInputText getTxtEducationLevel() {
        return txtEducationLevel;
    }

    public void setTxtEducationLevel(HtmlInputText hit) {
        this.txtEducationLevel = hit;
    }
    private HtmlInputText txtEducationShift = new HtmlInputText();

    public HtmlInputText getTxtEducationShift() {
        return txtEducationShift;
    }

    public void setTxtEducationShift(HtmlInputText hit) {
        this.txtEducationShift = hit;
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
    private HtmlInputTextarea txtInstitutionName = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtInstitutionName() {
        return txtInstitutionName;
    }

    public void setTxtInstitutionName(HtmlInputTextarea hit) {
        this.txtInstitutionName = hit;
    }
    private HtmlCommandLink cmdLinkConfirmCommitteeDecisions = new HtmlCommandLink();

    public HtmlCommandLink getCmdLinkConfirmCommitteeDecisions() {
        return cmdLinkConfirmCommitteeDecisions;
    }

    public void setCmdLinkConfirmCommitteeDecisions(HtmlCommandLink hcl) {
        this.cmdLinkConfirmCommitteeDecisions = hcl;
    }
    private HtmlCommandLink cmdview_Committee_Comments = new HtmlCommandLink();

    public HtmlCommandLink getCmdview_Committee_Comments() {
        return cmdview_Committee_Comments;
    }

    public void setCmdview_Committee_Comments(HtmlCommandLink hcl) {
        this.cmdview_Committee_Comments = hcl;
    }
    private HtmlCommandLink cmdLinkViewPreviesDecisions = new HtmlCommandLink();

    public HtmlCommandLink getCmdLinkViewPreviesDecisions() {
        return cmdLinkViewPreviesDecisions;
    }

    public void setCmdLinkViewPreviesDecisions(HtmlCommandLink hcl) {
        this.cmdLinkViewPreviesDecisions = hcl;
    }
    private javax.faces.component.html.HtmlCommandButton loginButton = new javax.faces.component.html.HtmlCommandButton();

    public javax.faces.component.html.HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(javax.faces.component.html.HtmlCommandButton hcb) {
        this.loginButton = hcb;
    }
    private HtmlInputSecret password_secretField = new HtmlInputSecret();

    public HtmlInputSecret getPassword_secretField() {
        return password_secretField;
    }

    public void setPassword_secretField(HtmlInputSecret his) {
        this.password_secretField = his;
    }
    private javax.faces.component.html.HtmlInputTextarea textArea = new javax.faces.component.html.HtmlInputTextarea();

    public javax.faces.component.html.HtmlInputTextarea getTextArea() {
        return textArea;
    }

    public void setTextArea(javax.faces.component.html.HtmlInputTextarea hit) {
        this.textArea = hit;
    }
    private javax.faces.component.html.HtmlInputText employeeName_textField = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getEmployeeName_textField() {
        return employeeName_textField;
    }

    public void setEmployeeName_textField(javax.faces.component.html.HtmlInputText hit) {
        this.employeeName_textField = hit;
    }
    private javax.faces.component.html.HtmlInputText employeeID_textField = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getEmployeeID_textField() {
        return employeeID_textField;
    }

    public void setEmployeeID_textField(javax.faces.component.html.HtmlInputText hit) {
        this.employeeID_textField = hit;
    }
    private HtmlCommandLink cmdLnkClosePopupCommitteeMembers = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkClosePopupCommitteeMembers() {
        return cmdLnkClosePopupCommitteeMembers;
    }

    public void setCmdLnkClosePopupCommitteeMembers(HtmlCommandLink hcl) {
        this.cmdLnkClosePopupCommitteeMembers = hcl;
    }
    private HtmlOutputLabel lblSignInReminder = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSignInReminder() {
        return lblSignInReminder;
    }

    public void setLblSignInReminder(HtmlOutputLabel hol) {
        this.lblSignInReminder = hol;
    }
    private javax.faces.component.html.HtmlOutputText loginConfirmed = new javax.faces.component.html.HtmlOutputText();

    public javax.faces.component.html.HtmlOutputText getLoginConfirmed() {
        return loginConfirmed;
    }

    public void setLoginConfirmed(javax.faces.component.html.HtmlOutputText hot) {
        this.loginConfirmed = hot;
    }
    private HtmlCommandLink btnClosePopupCommitteeMembers = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupCommitteeMembers() {
        return btnClosePopupCommitteeMembers;
    }

    public void setBtnClosePopupCommitteeMembers(HtmlCommandLink hcl) {
        this.btnClosePopupCommitteeMembers = hcl;
    }
    private PanelPopup pnlPopupCommitteeMembers = new PanelPopup();

    public PanelPopup getPnlPopupCommitteeMembers() {
        return pnlPopupCommitteeMembers;
    }

    public void setPnlPopupCommitteeMembers(PanelPopup pp) {
        this.pnlPopupCommitteeMembers = pp;
    }
    private PanelPopup pnlPopupComeeteeComenets = new PanelPopup();

    public PanelPopup getPnlPopupComeeteeComenets() {
        return pnlPopupComeeteeComenets;
    }

    public void setPnlPopupComeeteeComenets(PanelPopup pp) {
        this.pnlPopupComeeteeComenets = pp;
    }
    private HtmlPanelGrid panelGridPopupViewCommiteeCommentes = new HtmlPanelGrid();

    public HtmlPanelGrid getPanelGridPopupViewCommiteeCommentes() {
        return panelGridPopupViewCommiteeCommentes;
    }

    public void setPanelGridPopupViewCommiteeCommentes(HtmlPanelGrid hpg) {
        this.panelGridPopupViewCommiteeCommentes = hpg;
    }
    private HtmlOutputText otxtViewCommeeteCommentesPopupHeader = new HtmlOutputText();

    public HtmlOutputText getOtxtViewCommeeteCommentesPopupHeader() {
        return otxtViewCommeeteCommentesPopupHeader;
    }

    public void setOtxtViewCommeeteCommentesPopupHeader(HtmlOutputText hot) {
        this.otxtViewCommeeteCommentesPopupHeader = hot;
    }
    private PanelLayout pnlLayoutCommeeteComentes = new PanelLayout();

    public PanelLayout getPnlLayoutCommeeteComentes() {
        return pnlLayoutCommeeteComentes;
    }

    public void setPnlLayoutCommeeteComentes(PanelLayout pl) {
        this.pnlLayoutCommeeteComentes = pl;
    }
    private PanelLayout pnlLayoutPopupCommeteeCommentes = new PanelLayout();

    public PanelLayout getPnlLayoutPopupCommeteeCommentes() {
        return pnlLayoutPopupCommeteeCommentes;
    }

    public void setPnlLayoutPopupCommeteeCommentes(PanelLayout pl) {
        this.pnlLayoutPopupCommeteeCommentes = pl;
    }
    private HtmlDataTable dataTableCommetesComentes = new HtmlDataTable();

    public HtmlDataTable getDataTableCommetesComentes() {
        return dataTableCommetesComentes;
    }

    public void setDataTableCommetesComentes(HtmlDataTable hdt) {
        this.dataTableCommetesComentes = hdt;
    }
    private javax.faces.component.html.HtmlInputText userName_textField = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getUserName_textField() {
        return userName_textField;
    }

    public void setUserName_textField(javax.faces.component.html.HtmlInputText hit) {
        this.userName_textField = hit;
    }
    private javax.faces.component.html.HtmlInputTextarea responsiblity_textArea = new javax.faces.component.html.HtmlInputTextarea();

    public javax.faces.component.html.HtmlInputTextarea getResponsiblity_textArea() {
        return responsiblity_textArea;
    }

    public void setResponsiblity_textArea(javax.faces.component.html.HtmlInputTextarea hit) {
        this.responsiblity_textArea = hit;
    }
    private HtmlInputText txtCurrentEdLevl = new HtmlInputText();

    public HtmlInputText getTxtCurrentEdLevl() {
        return txtCurrentEdLevl;
    }

    public void setTxtCurrentEdLevl(HtmlInputText hit) {
        this.txtCurrentEdLevl = hit;
    }
    private HtmlInputText txtField = new HtmlInputText();

    public HtmlInputText getTxtField() {
        return txtField;
    }

    public void setTxtField(HtmlInputText hit) {
        this.txtField = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlSelectOneMenu drlCommittee = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommittee() {
        return drlCommittee;
    }

    public void setDrlCommittee(HtmlSelectOneMenu hsom) {
        this.drlCommittee = hsom;
    }
    private HtmlOutputLabel lblCommitte = new HtmlOutputLabel();

    public HtmlOutputLabel getLblCommitte() {
        return lblCommitte;
    }

    public void setLblCommitte(HtmlOutputLabel hol) {
        this.lblCommitte = hol;
    }
    private HtmlOutputLabel lbDecisio = new HtmlOutputLabel();

    public HtmlOutputLabel getLbDecisio() {
        return lbDecisio;
    }

    public void setLbDecisio(HtmlOutputLabel hol) {
        this.lbDecisio = hol;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbForwardToCommittee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbForwardToCommittee() {
        return ckbForwardToCommittee;
    }

    public void setCkbForwardToCommittee(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbForwardToCommittee = hsbc;
    }
    private HtmlInputTextarea txtaDecisionExplanation = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDecisionExplanation() {
        return txtaDecisionExplanation;
    }

    public void setTxtaDecisionExplanation(HtmlInputTextarea hit) {
        this.txtaDecisionExplanation = hit;
    }
    private PanelLayout pnlLayoutDecisoion = new PanelLayout();

    public PanelLayout getPnlLayoutDecisoion() {
        return pnlLayoutDecisoion;
    }

    public void setPnlLayoutDecisoion(PanelLayout pl) {
        this.pnlLayoutDecisoion = pl;
    }
    private HtmlOutputLabel lblEdurequstStstus1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblEdurequstStstus1() {
        return lblEdurequstStstus1;
    }

    public void setLblEdurequstStstus1(HtmlOutputLabel hol) {
        this.lblEdurequstStstus1 = hol;
    }
    private HtmlOutputLabel lbForwardToCommittee1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLbForwardToCommittee1() {
        return lbForwardToCommittee1;
    }

    public void setLbForwardToCommittee1(HtmlOutputLabel hol) {
        this.lbForwardToCommittee1 = hol;
    }
    private PanelPopup pnlPopupSuccessOrFailure1 = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure1() {
        return pnlPopupSuccessOrFailure1;
    }

    public void setPnlPopupSuccessOrFailure1(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure1 = pp;
    }
    private HtmlPanelGroup pnlgridpnMessage2 = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlgridpnMessage2() {
        return pnlgridpnMessage2;
    }

    public void setPnlgridpnMessage2(HtmlPanelGroup hpg) {
        this.pnlgridpnMessage2 = hpg;
    }
    private HtmlOutputText pnMessageTitle2 = new HtmlOutputText();

    public HtmlOutputText getPnMessageTitle2() {
        return pnMessageTitle2;
    }

    public void setPnMessageTitle2(HtmlOutputText hot) {
        this.pnMessageTitle2 = hot;
    }
    private HtmlCommandLink btnClosePopupSuccessOrFailure2 = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupSuccessOrFailure2() {
        return btnClosePopupSuccessOrFailure2;
    }

    public void setBtnClosePopupSuccessOrFailure2(HtmlCommandLink hcl) {
        this.btnClosePopupSuccessOrFailure2 = hcl;
    }
    private HtmlPanelGroup panelGroupMessage2 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage2() {
        return panelGroupMessage2;
    }

    public void setPanelGroupMessage2(HtmlPanelGroup hpg) {
        this.panelGroupMessage2 = hpg;
    }
    private PanelLayout pnlMessageBody2 = new PanelLayout();

    public PanelLayout getPnlMessageBody2() {
        return pnlMessageBody2;
    }

    public void setPnlMessageBody2(PanelLayout pl) {
        this.pnlMessageBody2 = pl;
    }
    private javax.faces.component.html.HtmlOutputLabel lblSuccessOrErrorMessage2 = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblSuccessOrErrorMessage2() {
        return lblSuccessOrErrorMessage2;
    }

    public void setLblSuccessOrErrorMessage2(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblSuccessOrErrorMessage2 = hol;
    }
    private PanelLayout pnlLayoutRequester = new PanelLayout();

    public PanelLayout getPnlLayoutRequester() {
        return pnlLayoutRequester;
    }

    public void setPnlLayoutRequester(PanelLayout pl) {
        this.pnlLayoutRequester = pl;
    }
    private HtmlOutputText lblInstId = new HtmlOutputText();

    public HtmlOutputText getLblInstId() {
        return lblInstId;
    }

    public void setLblInstId(HtmlOutputText hot) {
        this.lblInstId = hot;
    }
    private InputFile fileUploadAttached = new InputFile();

    public InputFile getFileUploadAttached() {
        return fileUploadAttached;
    }

    public void setFileUploadAttached(InputFile if0) {
        this.fileUploadAttached = if0;
    }
    private HtmlCommandButton btnAttachMinute = new HtmlCommandButton();

    public HtmlCommandButton getBtnAttachMinute() {
        return btnAttachMinute;
    }

    public void setBtnAttachMinute(HtmlCommandButton hcb) {
        this.btnAttachMinute = hcb;
    }
    private PanelLayout lyTableFile1 = new PanelLayout();

    public PanelLayout getLyTableFile1() {
        return lyTableFile1;
    }

    public void setLyTableFile1(PanelLayout pl) {
        this.lyTableFile1 = pl;
    }
    private HtmlCommandLink cmdAccepatnce1 = new HtmlCommandLink();

    public HtmlCommandLink getCmdAccepatnce1() {
        return cmdAccepatnce1;
    }

    public void setCmdAccepatnce1(HtmlCommandLink hcl) {
        this.cmdAccepatnce1 = hcl;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists = hsol;
    }
    private HtmlSelectOneListbox selectCommeete = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectCommeete() {
        return selectCommeete;
    }

    public void setSelectCommeete(HtmlSelectOneListbox hsol) {
        this.selectCommeete = hsol;
    }
    private PanelPopup pnlPopUpForwardedList = new PanelPopup();

    public PanelPopup getPnlPopUpForwardedList() {
        return pnlPopUpForwardedList;
    }

    public void setPnlPopUpForwardedList(PanelPopup pp) {
        this.pnlPopUpForwardedList = pp;
    }
    private HtmlCommandButton modalPnlCloseBtn1 = new HtmlCommandButton();

    public HtmlCommandButton getModalPnlCloseBtn1() {
        return modalPnlCloseBtn1;
    }

    public void setModalPnlCloseBtn1(HtmlCommandButton hcb) {
        this.modalPnlCloseBtn1 = hcb;
    }
    private HtmlOutputLabel lblAccusationAcceptanceValue = new HtmlOutputLabel();

    public HtmlOutputLabel getLblAccusationAcceptanceValue() {
        return lblAccusationAcceptanceValue;
    }

    public void setLblAccusationAcceptanceValue(HtmlOutputLabel hol) {
        this.lblAccusationAcceptanceValue = hol;
    }
    private HtmlSelectManyListbox selecteForwardedRequst = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelecteForwardedRequst() {
        return selecteForwardedRequst;
    }

    public void setSelecteForwardedRequst(HtmlSelectManyListbox hsml) {
        this.selecteForwardedRequst = hsml;
    }
    private DefaultSelectedData selectManyListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectManyListbox1Bean() {
        return selectManyListbox1Bean;
    }

    public void setSelectManyListbox1Bean(DefaultSelectedData dsd) {
        this.selectManyListbox1Bean = dsd;
    }
    private HtmlSelectManyListbox selecetForwardedList = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelecetForwardedList() {
        return selecetForwardedList;
    }

    public void setSelecetForwardedList(HtmlSelectManyListbox hsml) {
        this.selecetForwardedList = hsml;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectManyListbox1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectManyListbox1DefaultItems1() {
        return selectManyListbox1DefaultItems1;
    }

    public void setSelectManyListbox1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectManyListbox1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectManyListbox1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectManyListbox1DefaultItems2() {
        return selectManyListbox1DefaultItems2;
    }

    public void setSelectManyListbox1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectManyListbox1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectManyListbox1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectManyListbox1DefaultItems3() {
        return selectManyListbox1DefaultItems3;
    }

    public void setSelectManyListbox1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectManyListbox1DefaultItems3 = dsia;
    }
    private HtmlSelectManyListbox selectMiniteAttached = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelectMiniteAttached() {
        return selectMiniteAttached;
    }

    public void setSelectMiniteAttached(HtmlSelectManyListbox hsml) {
        this.selectMiniteAttached = hsml;
    }
    private HtmlCommandButton btnAddToGroup = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddToGroup() {
        return btnAddToGroup;
    }

    public void setBtnAddToGroup(HtmlCommandButton hcb) {
        this.btnAddToGroup = hcb;
    }
    private HtmlCommandButton btnRemoveFromGroup = new HtmlCommandButton();

    public HtmlCommandButton getBtnRemoveFromGroup() {
        return btnRemoveFromGroup;
    }

    public void setBtnRemoveFromGroup(HtmlCommandButton hcb) {
        this.btnRemoveFromGroup = hcb;
    }
    private HtmlCommandButton btnAddAllToGroup = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddAllToGroup() {
        return btnAddAllToGroup;
    }

    public void setBtnAddAllToGroup(HtmlCommandButton hcb) {
        this.btnAddAllToGroup = hcb;
    }
    private HtmlCommandButton btnRemoveAllFromGroup = new HtmlCommandButton();

    public HtmlCommandButton getBtnRemoveAllFromGroup() {
        return btnRemoveAllFromGroup;
    }

    public void setBtnRemoveAllFromGroup(HtmlCommandButton hcb) {
        this.btnRemoveAllFromGroup = hcb;
    }
    private HtmlCommandLink cmdviewAttachedDocument = new HtmlCommandLink();

    public HtmlCommandLink getCmdviewAttachedDocument() {
        return cmdviewAttachedDocument;
    }

    public void setCmdviewAttachedDocument(HtmlCommandLink hcl) {
        this.cmdviewAttachedDocument = hcl;
    }
    private HtmlCommandButton btnUpdateMInute = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateMInute() {
        return btnUpdateMInute;
    }

    public void setBtnUpdateMInute(HtmlCommandButton hcb) {
        this.btnUpdateMInute = hcb;
    }
    private PanelLayout lyTableFile2 = new PanelLayout();

    public PanelLayout getLyTableFile2() {
        return lyTableFile2;
    }

    public void setLyTableFile2(PanelLayout pl) {
        this.lyTableFile2 = pl;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkUpdateminute = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkUpdateminute() {
        return chkUpdateminute;
    }

    public void setChkUpdateminute(HtmlSelectBooleanCheckbox hsbc) {
        this.chkUpdateminute = hsbc;
    }
    private PanelLayout pnlDownload1 = new PanelLayout();

    public PanelLayout getPnlDownload1() {
        return pnlDownload1;
    }

    public void setPnlDownload1(PanelLayout pl) {
        this.pnlDownload1 = pl;
    }
    private PanelPopup pnlPopupSuccessOrFailure2 = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure2() {
        return pnlPopupSuccessOrFailure2;
    }

    public void setPnlPopupSuccessOrFailure2(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure2 = pp;
    }
    private HtmlPanelGroup pnlgridpnMessage1 = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlgridpnMessage1() {
        return pnlgridpnMessage1;
    }

    public void setPnlgridpnMessage1(HtmlPanelGroup hpg) {
        this.pnlgridpnMessage1 = hpg;
    }
    private HtmlPanelGroup panelGroupMessage3 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage3() {
        return panelGroupMessage3;
    }

    public void setPanelGroupMessage3(HtmlPanelGroup hpg) {
        this.panelGroupMessage3 = hpg;
    }
    private HtmlOutputText pnMessageTitle1 = new HtmlOutputText();

    public HtmlOutputText getPnMessageTitle1() {
        return pnMessageTitle1;
    }

    public void setPnMessageTitle1(HtmlOutputText hot) {
        this.pnMessageTitle1 = hot;
    }
    private HtmlCommandLink btnClosePopupSuccessOrFailure1 = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupSuccessOrFailure1() {
        return btnClosePopupSuccessOrFailure1;
    }

    public void setBtnClosePopupSuccessOrFailure1(HtmlCommandLink hcl) {
        this.btnClosePopupSuccessOrFailure1 = hcl;
    }
    private PanelLayout pnlMessageBody3 = new PanelLayout();

    public PanelLayout getPnlMessageBody3() {
        return pnlMessageBody3;
    }

    public void setPnlMessageBody3(PanelLayout pl) {
        this.pnlMessageBody3 = pl;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage3() {
        return lblSuccessOrErrorMessage3;
    }

    public void setLblSuccessOrErrorMessage3(HtmlOutputLabel lblSuccessOrErrorMessage3) {
        this.lblSuccessOrErrorMessage3 = lblSuccessOrErrorMessage3;
    }

    public Object[] getSelectedItemsFromMinute() {
        return selectedItemsFromMinute;
    }

    public void setSelectedItemsFromMinute(Object[] selectedItemsFromMinute) {
        this.selectedItemsFromMinute = selectedItemsFromMinute;
    }
    private HtmlOutputLabel lblUpdateMinute = new HtmlOutputLabel();

    public HtmlOutputLabel getLblUpdateMinute() {
        return lblUpdateMinute;
    }

    public void setLblUpdateMinute(HtmlOutputLabel hol) {
        this.lblUpdateMinute = hol;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EducationApprovePage() {
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
        sizeOfForwardedRquest = educationApproveManager.getAllForwardSize();

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
        return pendingRequestList;
    }

    public ArrayList<SelectItem> getEducationLevelCatagoryList() {
        return educationLevelCatagoryList;
    }

    public void setEducationLevelCatagoryList(ArrayList<SelectItem> educationLevelCatagoryList) {
        this.educationLevelCatagoryList = educationLevelCatagoryList;
    }

    public ArrayList<SelectItem> getEducationShiftList() {
        return educationShiftList;
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

    public List getEmployeeFileList() {
        return employeeFileList;
    }

    public void setEmployeeFileList(List employeeFileList) {
        this.employeeFileList = employeeFileList;
    }

    public String getRecieptNumber() {
        return recieptNumber;
    }

    public void setRecieptNumber(String recieptNumber) {
        this.recieptNumber = recieptNumber;
    }

    public byte[] getEmployeeFile() {
        return employeeFile;
    }

    public void setEmployeeFile(byte[] employeeFile) {
        this.employeeFile = employeeFile;
    }

    public String getFileExtenstion() {
        return fileExtenstion;
    }

    public void setFileExtenstion(String fileExtenstion) {
        this.fileExtenstion = fileExtenstion;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Option> getRequestHistoryList() {
        return requestHistoryList;
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<Option> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
    }

    public void setEducationShiftList(ArrayList<SelectItem> educationShiftList) {
        this.educationShiftList = educationShiftList;
    }

    public void setPendingRequestList(ArrayList<SelectItem> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }
    private DefaultSelectedData selectObjectOfDecisionType = new DefaultSelectedData();

    public DefaultSelectedData getSelectObjectOfDecisionType() {
        return selectObjectOfDecisionType;
    }

    public void setSelectObjectOfDecisionType(DefaultSelectedData selectObjectOfDecisionType) {
        this.selectObjectOfDecisionType = selectObjectOfDecisionType;
    }
    private DefaultSelectedData selectObjectOfCommittee = new DefaultSelectedData();

    public DefaultSelectedData getSelectObjectOfCommittee() {
        return selectObjectOfCommittee;
    }

    public void setSelectObjectOfCommittee(DefaultSelectedData selectObjectOfCommittee) {
        this.selectObjectOfCommittee = selectObjectOfCommittee;
    }

    public ArrayList<Option> getAvailableDecisionsToMake() {
        return availableDecisionsToMake;
    }

    public void setAvailableDecisionsToMake(ArrayList<Option> availableDecisionsToMake) {
        this.availableDecisionsToMake = availableDecisionsToMake;
    }

    public void setRequestHistoryList(ArrayList<Option> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
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

    public void setLblSuccessOrErrorMessage2(HtmlOutputLabel lblSuccessOrErrorMessage2) {
        this.lblSuccessOrErrorMessage2 = lblSuccessOrErrorMessage2;
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

    public int getEducProcessId() {
        return educProcessId;
    }

    public void setEducProcessId(int educProcessId) {
        this.educProcessId = educProcessId;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage1() {
        return lblSuccessOrErrorMessage1;
    }

    public void setLblSuccessOrErrorMessage1(HtmlOutputLabel lblSuccessOrErrorMessage1) {
        this.lblSuccessOrErrorMessage1 = lblSuccessOrErrorMessage1;
    }

//    public NullPointerException getNpe() {
//        return npe;
//    }
//
//    public void setNpe(NullPointerException npe) {
//        this.npe = npe;
//    }
    public HtmlPanelGroup getPanelGroupMessage1() {
        return panelGroupMessage1;
    }

    public void setPanelGroupMessage1(HtmlPanelGroup panelGroupMessage1) {
        this.panelGroupMessage1 = panelGroupMessage1;
    }

    public PanelLayout getPnlMessageBody1() {
        return pnlMessageBody1;
    }

    public void setPnlMessageBody1(PanelLayout pnlMessageBody1) {
        this.pnlMessageBody1 = pnlMessageBody1;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public ArrayList<SelectItem> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<SelectItem> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public String getAgreeOnDefaultPenalty() {
        return agreeOnDefaultPenalty;
    }

    public void setAgreeOnDefaultPenalty(String agreeOnDefaultPenalty) {
        this.agreeOnDefaultPenalty = agreeOnDefaultPenalty;
    }

    public ArrayList<Option> getCommitteeForwardList() {
        return committeeForwardList;
    }

    public void setCommitteeForwardList(ArrayList<Option> committeeForwardList) {
        this.committeeForwardList = committeeForwardList;
    }

    public int getDisciplineProblemId() {
        return disciplineProblemId;
    }

    public void setDisciplineProblemId(int disciplineProblemId) {
        this.disciplineProblemId = disciplineProblemId;
    }

    public int getFlage() {
        return flage;
    }

    public void setFlage(int flage) {
        this.flage = flage;
    }

    public String getSavedStatus() {
        return savedStatus;
    }

    public void setSavedStatus(String savedStatus) {
        this.savedStatus = savedStatus;
    }

    public int getSelectedCommitteeCommentesRow() {
        return selectedCommitteeCommentesRow;
    }

    public void setSelectedCommitteeCommentesRow(int selectedCommitteeCommentesRow) {
        this.selectedCommitteeCommentesRow = selectedCommitteeCommentesRow;
    }

    public int getSelectedCommitteeMemberRow() {
        return selectedCommitteeMemberRow;
    }

    public void setSelectedCommitteeMemberRow(int selectedCommitteeMemberRow) {
        this.selectedCommitteeMemberRow = selectedCommitteeMemberRow;
    }

    public SiteSecurityManager getSiteSecurityManager() {
        return siteSecurityManager;
    }

    public void setSiteSecurityManager(SiteSecurityManager siteSecurityManager) {
        this.siteSecurityManager = siteSecurityManager;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public CommitteeMemberRegistrationManager getCommitteeMemberRegistrationManager() {
        return committeeMemberRegistrationManager;
    }

    public void setCommitteeMemberRegistrationManager(CommitteeMemberRegistrationManager committeeMemberRegistrationManager) {
        this.committeeMemberRegistrationManager = committeeMemberRegistrationManager;
    }

    public ArrayList<SelectItem> getCommitteeLists() {
        return committeeLists;
    }

    public void setCommitteeLists(ArrayList<SelectItem> committeeLists) {
        this.committeeLists = committeeLists;
    }

    public ArrayList<CommeeteeCommentsGiven> getComeeteeCommentsGive() {
        return comeeteeCommentsGive;
    }

    public void setComeeteeCommentsGive(ArrayList<CommeeteeCommentsGiven> comeeteeCommentsGive) {
        this.comeeteeCommentsGive = comeeteeCommentsGive;
    }

    public ArrayList<CommitteeMemberModel> getCommitteeMembersList() {
        return committeeMembersList;
    }

    public void setCommitteeMembersList(ArrayList<CommitteeMemberModel> committeeMembersList) {
        this.committeeMembersList = committeeMembersList;
    }

    public int getDeciderCommitteeId() {
        return deciderCommitteeId;
    }

    public void setDeciderCommitteeId(int deciderCommitteeId) {
        this.deciderCommitteeId = deciderCommitteeId;
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

    public Resource getFaResource() {
        return faResource;
    }

    public void setFaResource(Resource faResource) {
        this.faResource = faResource;
    }

    public String getMimeType() {
        return mimeType;
    }

    public boolean isDownloadAvailable() {
        return downloadAvailable;
    }

    public void setDownloadAvailable(boolean downloadAvailable) {
        this.downloadAvailable = downloadAvailable;
    }

    public int getFiletableSize() {
        return filetableSize;
    }

    public void setFiletableSize(int filetableSize) {
        this.filetableSize = filetableSize;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public int getSizeOfCommitee() {
        return sizeOfCommitee;
    }

    public void setSizeOfCommitee(int sizeOfCommitee) {
        this.sizeOfCommitee = sizeOfCommitee;
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtAppliedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    private void disablecommentspopoUp() {
        employeeID_textField.setDisabled(true);
        employeeName_textField.setDisabled(true);
        responsiblity_textArea.setDisabled(true);
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }


    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        return null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
            requesterId = txtRequesterId.getValue().toString();
            if (populateRequesterTextComponents(requesterId)) {
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

//    private boolean populateApproverTextComponents(String approverId) {
//        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
//        if (empInfoHashMap != null) {
//            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
//                approverId = null;
//                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
//                txtDeciderId.setDisabled(false);
//                return false;
//            } else {
//                approverId = empInfoHashMap.get("employeeId").toString();
//                txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
//                txtDeciderFullName.setValue(empInfoHashMap.get("employeeFullName"));
//                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
//                txtDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
//                return true;
//            }
//        } else {
//            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
//            return false;
//        }
//    }
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
                txtCurrentEdLevl.setValue(empEduHashMap.get("levels"));
                txtField.setValue(empEduHashMap.get("description"));
                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateRequestTextComponents(int requestId) {
        getEmployeeFileList().clear();
        educationRequestModel = educationRequestManager.getEducationRequest(requestId);
        if (educationRequestModel != null) {
            if (educationRequestModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {

                txtEducationProgramName.setValue(educationRequestModel.getEducationProgramName());
                txtNumberOfCreditHours.setValue(educationRequestModel.getNumberOfCreditHours());
                txtAppliedDate.setValue(educationRequestModel.getAppliedDate());
                txtCostPerCreditHour.setValue(educationRequestModel.getCostPerCreditHour());
                txtDocumentReferenceNumber.setValue(educationRequestModel.getDocumentReferenceNumber());
                txtDurationInYear.setValue(educationRequestModel.getDurationInYear());
                txtInstitutionName.setValue(educationRequestModel.getInstitutionName());
                lblInstId.setValue(educationRequestModel.getInstitutionName());
                txtRemark.setValue(educationRequestModel.getReasonDescription());
                txtStartDate.setValue(educationRequestModel.getStartDate());
                txtTotalAdminstrativeCost.setValue(educationRequestModel.getTotalAdminstrationCosts());
                // txtaInstitutionAddress.setValue(educationRequestModel.getInstitutionAddress());
                txtEducationLevel.setValue(educationRequestModel.getEducationLevelCategory());
                txtEducationShift.setValue(educationRequestModel.getEducationShiftCategory());
                drlEducationTypeCatagory.setValue(educationRequestModel.getEducationTypeCategory());
                //txtAccred.setValue(educationRequestModel.getInstitutionAccredited());
                //txtInsideOut.setValue(educationRequestModel.getEthiopianInstitution());
                lblEdurequstStstus1.setValue(educationRequestModel.getEducatinalStatus());
                String institutionID = lblInstId.getValue().toString();
                institutionName = educationRequestManager.getTypeOFInstName(institutionID);
                txtInstitutionName.setValue(institutionName);
                institutionAddress = educationRequestManager.getInstituAdress(institutionID);
                txtaInstitutionAddress.setValue(institutionAddress);
                ethiopianInstitution = educationRequestManager.getInsideOutside(institutionID);
                if (ethiopianInstitution.equalsIgnoreCase("IN")) {
                    txtInsideOut.setValue("Inside Ethiopia");
                }

                if (ethiopianInstitution.equalsIgnoreCase("OUT")) {
                    txtInsideOut.setValue("Outside Ethiopia");
                }

                institutionAccredited = educationRequestManager.getTypeOFAccredated(institutionID);
                if (institutionAccredited.equalsIgnoreCase("AC")) {
                    txtAccred.setValue("Accredited ");
                }

                if (institutionAccredited.equalsIgnoreCase("IN")) {
                    txtAccred.setValue("Not Accredited ");
                }

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
        txtCurrentEdLevl.setValue(null);
        txtField.setValue(null);
        lblEdurequstStstus1.setValue(null);
    }

    private void clearAllComponents() {
        clearRequestComponents();
        clearRequesterTextComponents();
        clearDropDownItems();

    }

    private void clearDropDownItems() {
        selectedRequestFromMyRequestList = new DefaultSelectedData();
        selectedRequestFromHistoryList.setSelectedObject(null);
        selectObjectOfEducationTypeCatagory.setSelectedObject(null);
        selectObjectOfEducationLevelCatagory.setSelectedObject(null);
        selectObjectOfEducationShiftCatagory.setSelectedObject(null);
        drlCommittee.setValue(null);
        drlDecision.setValue(null);
    }

    public void enableComponents() {
        txtEducationProgramName.setDisabled(false);
        txtNumberOfCreditHours.setDisabled(false);
        txtAppliedDate.setDisabled(false);
        txtCostPerCreditHour.setDisabled(false);
        txtDocumentReferenceNumber.setDisabled(false);
        txtDurationInYear.setDisabled(false);
        txtaInstitutionName.setDisabled(false);
        txtRemark.setDisabled(false);
        txtStartDate.setDisabled(false);
        txtTotalAdminstrativeCost.setDisabled(false);
        txtaInstitutionAddress.setDisabled(false);
        txtEducationLevel.setDisabled(false);
        txtEducationShift.setDisabled(false);
        drlEducationTypeCatagory.setDisabled(false);
    }

    public void disableComponents() {
        txtEducationProgramName.setDisabled(true);
        txtNumberOfCreditHours.setDisabled(true);
        txtAppliedDate.setDisabled(true);
        txtCostPerCreditHour.setDisabled(true);
        txtDocumentReferenceNumber.setDisabled(true);
        txtDurationInYear.setDisabled(true);
        txtaInstitutionName.setDisabled(true);
        txtRemark.setDisabled(true);
        txtStartDate.setDisabled(true);
        txtTotalAdminstrativeCost.setDisabled(true);
        txtaInstitutionAddress.setDisabled(true);
        txtEducationLevel.setDisabled(true);
        txtEducationShift.setDisabled(true);

    // drlEducationTypeCatagory.setDisabled(true);

    }

    public void clearRequestComponents() {
        txtEducationProgramName.setValue(null);
        txtNumberOfCreditHours.setValue(null);
        txtAppliedDate.setValue(null);
        txtCostPerCreditHour.setValue(null);
        txtDocumentReferenceNumber.setValue(null);
        txtDurationInYear.setValue(null);
        txtaInstitutionName.setValue(null);
        txtRemark.setValue(null);
        txtStartDate.setValue(null);
        txtaInstitutionAddress.setValue(null);
        txtEducationShift.setValue(null);
        txtEducationLevel.setValue(null);
        txtTotalAdminstrativeCost.setValue(null);
        txtInstitutionName.setValue(null);
        txtAccred.setValue(null);
        txtInsideOut.setValue(null);
        txtaInstitutionAddress.setValue(null);
        txtaDecisionExplanation.setValue(null);
        ckbForwardToCommittee.setSelected(false);
    //button1.setDisabled(false);

    }

    private void makePageReadyForSave() {
        btnPostDecision.setRendered(true);
        btnPostDecision.setDisabled(false);
        ckbForwardToCommittee.setDisabled(false);
        drlDecision.setDisabled(false);

        txtaDecisionExplanation.setDisabled(false);
        pnlLayoutDecisoion.setRendered(true);
    }

    public void makePageReadyForDecision() {
        drlCommittee.setRendered(false);
        lblCommitte.setRendered(false);
        drlDecision.setRendered(true);
        lbDecisio.setRendered(true);
//        lnkToAccusedCommentPage.setRendered(false);
//        lnkViewAccusedComment.setRendered(true);
        availableDecisionsToMakeList = educationApproveManager.getAvailableDecisionsToMake(requestStatus);
        makePageReadyForSave();
    }

    private void makePageReadyToForwardToCommitte() {
        drlCommittee.setRendered(true);
        lblCommitte.setRendered(true);
        drlDecision.setRendered(false);
        lbDecisio.setRendered(false);
        cmdLinkConfirmCommitteeDecisions.setRendered(false);
        makePageReadyForSave();
    }

    private void makePageReadyForUpdate() {
        // enableComponents();
        newOrEditOrUpdateLabel = "Update";
        btnPostDecision.setDisabled(false);

    }

    private void populateAllComponents(EducationRequestModel educationRequestModel) {
        populateRequesterTextComponents(educationRequestModel.getRequesterId());
        populateRequestTextComponents(educationRequestModel.getEducationRequestId());
        populateDecisionHistory(educationRequestModel.getEducationRequestId());
        populateComeeteeComeents(educationRequestModel.getEducationRequestId());
    //populateComeeteeComeentstoAttach(educationRequestModel);
    }

    private void makePageReadyForView() {
        disableComponents();
        newOrEditOrUpdateLabel = "Save";
        btnPostDecision.setDisabled(true);

    }

    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlOutputLabel lblSuccessOrErrorMessage1 = new HtmlOutputLabel();
    private HtmlOutputLabel lblSuccessOrErrorMessage3 = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private PanelLayout pnlMessageBody1 = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private HtmlPanelGroup panelGroupMessage1 = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    //private PanelPopup pnlPopupSuccessOrFailure1 = new PanelPopup();

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

    public void showSuccessOrFailureMessage2(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage1.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage1.setValue(messageToDisplay);
        lblSuccessOrErrorMessage1.setVisible(true);
        pnlPopupSuccessOrFailure1.setAutoCentre(true);
        pnlPopupSuccessOrFailure1.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void showSuccessOrFailureMessage3(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage3.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage3.setValue(messageToDisplay);
        lblSuccessOrErrorMessage3.setVisible(true);
        pnlPopupSuccessOrFailure2.setAutoCentre(true);
        pnlPopupSuccessOrFailure2.setRendered(true);
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

    public String btnClosePopupSuccessOrFailure2_action() {
        pnlPopupSuccessOrFailure1.setRendered(false);
        pnlPopupCommitteeMembers.setRendered(true);
        return null;
    }

    private void populateDecisionHistory(int overTimeRequestId) {
        decisionsMadeOnRequestList = educationApproveManager.getRequestHistory(overTimeRequestId);

    }

    // </editor-fold>
    // </editor-fold >
    // </editor-fold >
    EmployeeManage employeeManager = new EmployeeManage();
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationRequestManager educationRequestManager = new EducationRequestManager();
    EducationApproveManager educationApproveManager = new EducationApproveManager();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    ArrayList<CommitteeMemberModel> committeeMembersList = new ArrayList<CommitteeMemberModel>();
    ArrayList<CommeeteeCommentsGiven> comeeteeCommentsGive = new ArrayList<CommeeteeCommentsGiven>();
    private ArrayList<EducationRequestModel> availableForwardedList = new ArrayList<EducationRequestModel>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationLevelCatagoryList = educationRequestManager.getEducationLevels();
    ArrayList<SelectItem> educationShiftList = educationRequestManager.getEducationShift();
    ArrayList<SelectItem> availableDecisionsToMakeList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> forwardedList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> minuteAttachedForwardedList = new ArrayList<SelectItem>();
    ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    ArrayList<Option> requestHistoryList = new ArrayList<Option>();
    ArrayList<Option> availableDecisionsToMake = new ArrayList<Option>();
    ArrayList<Option> committeeForwardList = new ArrayList<Option>();
    ArrayList<SelectItem> committeeLists = educationApproveManager.getActiveDesciplineCommittees();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationTypeCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationLevelCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationShiftCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    private DefaultSelectedData selectedforwardedList = new DefaultSelectedData();
    private List employeeFileList = new ArrayList<EducationRequestModel>();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String loggedInEmployeeId;
    String userName;
    int educationRequestId;
    int requestFile;
    int deciderCommitteeId;
    int disciplineProblemId;
    int sizeOfCommitee;
    int sizeOfForwardedRquest;
    String requesterId;//
    String educationProgramName;
    String institutionName;
    String ethiopianInstitution;//inside or outside ethiopia
    String institutionAccredited;//
    String institutionAddress;
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
    String recieptNumber;
    String requestStatus;
    private String filePath = null;
    private String fileExtenstion = "";
    int educProcessId;
    Object[] selectedForwarededRequest;
    Object[] selectedItemsFromMinute;
    String agreeOnDefaultPenalty = null;
    String timeStamp;
    String educatinalStatus;
    String dateOfStatusUpdate;
    byte[] employeeFile = null;
    private int filetableSize = 0;
    private boolean downloadAvailable;

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            String[] requestAttributes = vce.getNewValue().toString().split("--");
            educationRequestId = Integer.parseInt(requestAttributes[0]);
            comeeteeCommentsGive = educationApproveManager.getCommiteeComentes(educationRequestId);
            requesterId = requestAttributes[1];
            requestStatus = requestAttributes[2];
            educationRequestModel = educationRequestManager.getEducationRequest(educationRequestId);
            populateAllComponents(educationRequestModel);
            availableDecisionsToMakeList = educationApproveManager.getAvailableDecisionsToMake(requestStatus);
            renderPreviosDescisionLink(requestStatus);
            cmdLinkConfirmCommitteeDecisions.setRendered(false);
            chkUpdateminute.setDisabled(false);
            selectMyHistoryLists.setValue(null);
            selectCommeete.setValue(null);

        }

    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        educationRequestId = Integer.parseInt(requestAttributes[0]);
        requesterId = requestAttributes[1];
        requestStatus = requestAttributes[2];
        drlDecision.setValue(requestAttributes[2]);
        educationRequestModel = educationRequestManager.getEducationRequest(educationRequestId);
        populateAllComponents(educationRequestModel);
        drlDecision.setDisabled(true);
        drlCommittee.setRendered(false);
        lblCommitte.setRendered(false);
        lbForwardToCommittee1.setRendered(false);
        ckbForwardToCommittee.setRendered(false);
        txtaDecisionExplanation.setDisabled(true);
        ckbForwardToCommittee.setDisabled(true);
        populateComeeteeComeents(educationRequestId);
        //renderCommitteeLink(educationRequestId, requestStatus);
        cmdLinkConfirmCommitteeDecisions.setRendered(false);
        chkUpdateminute.setDisabled(false);
        makePageReadyForView();
        btnPostDecision.setDisabled(false);
        selectCommeete.setValue(null);
        selectMyRequestLists.setValue(null);
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();

    public String btnDelete_action() {
        // pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
        if (educationRequestManager.deleteEducationRequest(educationRequestId)) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponents();
            requestListsToBeApproved = educationApproveManager.getRequestsToBeProcessed();
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
            requesterId = txtRequesterId.getValue().toString();
            educationProgramName = txtEducationProgramName.getValue().toString();
            institutionName = txtaInstitutionName.getValue().toString();
            ethiopianInstitution = txtInsideOut.getValue().toString();
            institutionAccredited = txtAccred.getValue().toString();
            institutionAddress = txtaInstitutionAddress.getValue().toString();
            startDate = txtStartDate.getValue().toString();
            appliedDate = txtAppliedDate.getValue().toString();
            educationShiftCategory = txtEducationShift.getValue().toString();
            educationTypeCategory = drlEducationTypeCatagory.getValue().toString();
            educationLevelCategory = txtEducationLevel.getValue().toString();
            costPerCreditHour = Double.parseDouble(txtCostPerCreditHour.getValue().toString());
            numberOfCreditHours = Integer.parseInt(txtNumberOfCreditHours.getValue().toString());
            totalAdminstrationCosts = Double.parseDouble(txtTotalAdminstrativeCost.getValue().toString());
            durationInYear = Double.parseDouble(txtDurationInYear.getValue().toString());
            reasonDescription = txtRemark.getValue().toString();
            documentReferenceNumber = txtDocumentReferenceNumber.getValue().toString();
            return true;
        }
    }

    private boolean validateDecision() {
        if (txtaDecisionExplanation.getValue() == null) {
            showSuccessOrFailureMessage(false, "GIVE COMMENT AND/OR SELECT FIRST");
            return false;
        } else if (ckbForwardToCommittee.isSelected() && drlCommittee.getValue().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT COMMITTEE");
            return false;
        } else if ((!ckbForwardToCommittee.isSelected()) && drlDecision.getValue().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT DECISION");
            return false;
        }
        return true;
    }

    public boolean isEntryValidForDecsion() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtaDecisionExplanation.getValue());
        if (!required) {
            ((UIInput) txtaDecisionExplanation).setValid(false);
            error(txtaDecisionExplanation, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.drlDecision.getValue());
        if (!required) {
            ((UIInput) drlDecision).setValid(false);
            error(drlDecision, errorMessage);
            results = false;
        }
        return results;
    }

    public String btnPostDecision_action() {
        if (isEntryValidForDecsion()) {
            String decision = "";

            //String decisionS="";
            if (validateDecision()) {

                if (ckbForwardToCommittee.isSelected()) {
                    decision = drlCommittee.getValue().toString().split("-")[0] + "$$" + requestStatus;

                } else {
                    decision = drlDecision.getValue().toString();

                }
//           
//////////REMEMBER The method "educationApproveManager.isForwardedToCommitee(educationRequestId)==0)" NOT done in Manager and Entity Class still
                if ((educationApproveManager.isForwardedToCommitee(educationRequestId) == 1) && (comeeteeCommentsGive.size() <= sizeOfCommitee) && decision.contains("$$")) {
                    showSuccessOrFailureMessage(false, "You Can not Forward. Because It was Forwarded to committee already");

                } else if ((educationApproveManager.isForwardedToCommitee(educationRequestId) == 1) && (comeeteeCommentsGive.size() < sizeOfCommitee)) {
                    showSuccessOrFailureMessage(false, "You Can not Approve. Because it was Forwarded to committee");

                } else {

                    if (educationApproveManager.saveDecision(educationRequestId, loggedInEmployeeId, txtaDecisionExplanation.getValue().toString(), decision, requestStatus, getEmployeeFile(), fileExtenstion)) {
                        // disciplineApproveManager.clearOnPending(disciplineProblemId);
                        showSuccessOrFailureMessage(true, "DECISION POSTED SUCCESSFULLY");
                        clearAllComponents();
                        btnPostDecision.setDisabled(false);
                        educationApproveManager.deleteApprovedRequest(educProcessId);
                        requestListsToBeApproved = educationApproveManager.getRequestsToBeProcessed();
                        requestHistoryList = educationApproveManager.getMyDecisionsOnRequests();
                        committeeForwardList = educationApproveManager.getCommeeteforwardListByApprover();

                    } else {
                        showSuccessOrFailureMessage(false, "!SORRY POSTING DECISION FAILED");
                    }
                }
            }
        }

        return null;
    }

  

    public String btnReset_action() {
        clearAllComponents();
        makePageReadyForSave();
        return null;
    }

//    public String lnkViewPrevieousDecisions_action() {
//        populateDecisionHistory(educationRequestId);
//        pnlPopupViewPrevieousDecisions.setRendered(true);
//        return null;
//    }
    public String txtCostPerCreditHour_action() {
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

    public String btnSearchDecider1_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkEducationRequest_action() {
        return "EducationRequest";
    }

    public String lnkEducationPaymentRequest_action() {
        return "EducationPaymentRequest";
    }

    public String lnkEducationApprove_action() {
        return "EducationApprove";
    }

    public String lnkEducationPaymentApprove_action() {
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

    public String btnClosePopupViewPrevieousDecisions_action() {
        // TODO: Replace with your code
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public void radioGroupAgreeOnDefaultPenalty_processValueChange(ValueChangeEvent vce) {
    }

    public void ckbForwardToCommittee_processValueChange(ValueChangeEvent vce) {
        if (ckbForwardToCommittee.isSelected()) {
            makePageReadyToForwardToCommitte();
        // button1.setDisabled(true);
        } else {
            //button1.setDisabled(false);
            makePageReadyForDecision();
        }
    }

    public String cmdLinkConfirmCommitteeDecisions_action() {
        //return null means stay on the same page
        committeeMembersList = committeeMemberRegistrationManager.getAllCommitteeMembers(deciderCommitteeId);
        lblSignInReminder.setValue("Sign in using your username");
        pnlPopupCommitteeMembers.setRendered(true);
        return null;
    }

    public String cmdLinkViewPreviesDecisions_action() {
        //return null means stay on the same page
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public String cmdview_Committee_Comments_action() {
        //return null means stay on the same page
        pnlPopupComeeteeComenets.setRendered(true);
        return null;

    }

    public String btnClosePopupCommitteeMembers_action() {
        if (isEnoughCommitteeNumbersSigned()) {
            pnlPopupCommitteeMembers.setRendered(false);
            pnlPopupSuccessOrFailure.setRendered(false);
        }
        return null;
    }

    public String cmdLnkClosePopupCommitteeMembers_action() {
        //return null means stay on the same page
        cmdLnkClosePopupCommitteeMembers.setRendered(false);
        pnlPopupCommitteeMembers.setRendered(false);
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String commentsbtnClosePopupSuccessOrFailure_action() {
        //return null means stay on the same page
        return null;
    }

    private boolean populateDecisionHistoryTable(int eduReqId) {
        decisionsMadeOnRequestList = educationApproveManager.getRequestHistory(eduReqId);
        return true;
    }

    private void renderPreviosDescisionLink(String currentStatus) {

        if (!currentStatus.equals(EducationApproveManager.INITIAL_STATE_EDUCATION)) {
            populateDecisionHistoryTable(educationRequestId);
            cmdLinkViewPreviesDecisions.setRendered(true);
            cmdLinkConfirmCommitteeDecisions.setRendered(true);
        } else {
            cmdLinkViewPreviesDecisions.setRendered(false);
        }
    }

    private void populateComeeteeComeents(int eduRequId) {

        comeeteeCommentsGive = educationApproveManager.getCommiteeComentes(eduRequId);

        if (comeeteeCommentsGive.size() > sizeOfCommitee) {
            cmdview_Committee_Comments.setRendered(true);
            cmdLinkConfirmCommitteeDecisions.setDisabled(true);
        } else {
            cmdview_Committee_Comments.setRendered(false);
            cmdLinkConfirmCommitteeDecisions.setDisabled(false);

        }
    }

//    private boolean getEduIdComeentstoAttach(EducationRequestModel educationRequestModel) {
//        int counterCheck = 0;
//        int totalSize = committeeForwardList.size();
//        for (counterCheck = 0; counterCheck <= totalSize; counterCheck = counterCheck + 1) {
//            educationRequestId = educationRequestModel.getEducationRequestId();
//
//            educationApproveManager.saveFile(educationRequestId, fileExtenstion, getEmployeeFile());
//        }
//        return true;
//    }

//    private void renderCommeeteComentesLink() {
//
//        populateComeeteeComeents(educationRequestId);
//
//    }
    private void renderCommitteeLink(int requestId, String currentStatus) {

        deciderCommitteeId = educationApproveManager.getForwardedToCommittee(requestId, currentStatus);
        sizeOfCommitee = committeeMemberRegistrationManager.getAllEducatonCommiteeSize(deciderCommitteeId);
        if (deciderCommitteeId != -1) {//if forwareded to committee

            chkUpdateminute.setDisabled(false);
            cmdLinkConfirmCommitteeDecisions.setRendered(true);
        } else {

            cmdLinkConfirmCommitteeDecisions.setRendered(false);
        }
    }

    public void btnClosePopupCommeeteComeentes_processAction(ActionEvent ae) {
        pnlPopupComeeteeComenets.setRendered(false);
        drlDecision.setDisabled(false);
    }

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        drlDecision.setDisabled(false);
        return null;
    }
    int selectedCommitteeMemberRow = -1;
    int selectedCommitteeCommentesRow = -1;
    int flage = 0;
    String savedStatus = "Done";

    public void rowSelectorCommitteeMember_processMyEvent(RowSelectorEvent rse) {
        selectedCommitteeMemberRow = rse.getRow();
    }

    public String btnPopupForColumnMemberLogIn_action() {
        try {
            if (selectedCommitteeMemberRow != -1) {
                String memberEmployeeId = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeId();
                String memberUserName = committeeMembersList.get(selectedCommitteeMemberRow).getUserName();
                String memberPassWord = committeeMembersList.get(selectedCommitteeMemberRow).getPassWord();
                String memberComentes = committeeMembersList.get(selectedCommitteeMemberRow).getCommeentesGiven();
                String memberFullName = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeFullName();
                String memberResponsiblity = committeeMembersList.get(selectedCommitteeMemberRow).getMemberResponsibility();
                int educationRequestIds = educationRequestId;
                int counter = committeeMembersList.size();

                String status = "New";

                if (siteSecurityManager.isValidUser(memberUserName, memberPassWord, memberEmployeeId)) {
                    comeeteeCommentsGive = educationApproveManager.getCommiteeComentes(educationRequestId, memberUserName);
                    if (comeeteeCommentsGive.size() == 0) {
                        flage++;
                        educationApproveManager.NewSaveCommitteeComeentes(memberEmployeeId, memberFullName, memberResponsiblity, memberComentes, educationRequestIds, memberUserName, memberPassWord, status, savedStatus);
                        showSuccessOrFailureMessage(true, "YOUR COMMEENTES SAVING SUCCESSFULL");
                        password_secretField.resetValue();
                        userName_textField.resetValue();
                        textArea.resetValue();
                        committeeMembersList.get(selectedCommitteeMemberRow).getUserName().replaceAll(committeeMembersList.get(selectedCommitteeMemberRow).getUserName(), "");

                        committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Confirmed");
                        pnlPopupCommitteeMembers.setRendered(false);
                    } else {
                        showSuccessOrFailureMessage(false, "YOU CONFIRMED ALREADY");
                        pnlPopupCommitteeMembers.setRendered(false);
                    }
                    pnlPopupCommitteeMembers.setRendered(false);
                } else {
                    showSuccessOrFailureMessage(false, "CHECK PASSWORD OR USER NAME");
                    pnlPopupCommitteeMembers.setRendered(false);
                }

            } else {

                showSuccessOrFailureMessage2(false, "ERROR OCCURES WHILE YOU SAVING YOUR COMMENTES");

                committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Invalid");
                pnlPopupCommitteeMembers.setRendered(false);
            }

        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }

    public boolean isEnoughCommitteeNumbersSigned() {
        int counterCheck = 0;
        int totalSize = committeeMembersList.size();
        for (CommitteeMemberModel current : committeeMembersList) {
            if (current.getLogInConfirmed() != null && current.getLogInConfirmed().equals("Confirmed")) {
                counterCheck++;
            }
        }

        if ((counterCheck == 0) || (totalSize / counterCheck >= 2)) {//less than or equal to 50% confirmed
            lblSignInReminder.setValue("Note: It can not be approved now." +
                    " Only " + counterCheck + " out of " + totalSize + " confirmed. ");
            cmdLnkClosePopupCommitteeMembers.setRendered(true);
            return false;
        } else {//if more than 50% confirmed
            lblSignInReminder.setValue("Note: Greater than 50% approved." +
                    " Only " + counterCheck + " out of " + totalSize + " confirmed. ");
            // enableDiscionComponents();
            return true;
        }
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void selectCommeete_processValueChange(ValueChangeEvent vce) {

        if (vce != null) {
            String[] requestAttributes = vce.getNewValue().toString().split("--");
            educationRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            requestStatus = requestAttributes[2];
            educProcessId = Integer.parseInt(requestAttributes[3]);

            educationRequestModel = educationRequestManager.getEducationRequest(educationRequestId);
            populateAllComponents(educationRequestModel);
            ckbForwardToCommittee.setRendered(false);
            lbForwardToCommittee1.setRendered(false);
            renderPreviosDescisionLink(requestStatus);
            disableForWardToCommeeteDiscionComponents();
            renderCommitteeLink(educationRequestId, requestStatus);
            selectMyRequestLists.setValue(null);
            selectMyHistoryLists.setValue(null);
            cmdview_Committee_Comments.setRendered(true);
            chkUpdateminute.setDisabled(false);

        }
    }

    public void disableForWardToCommeeteDiscionComponents() {
        txtaDecisionExplanation.setDisabled(true);
        drlDecision.setDisabled(true);
        ckbForwardToCommittee.setDisabled(true);
        btnPostDecision.setDisabled(false);
        drlCommittee.setDisabled(true);
        ckbForwardToCommittee.setDisabled(true);
        drlCommittee.setRendered(false);
        lblCommitte.setRendered(false);
        lbForwardToCommittee1.setRendered(false);
        ckbForwardToCommittee.setRendered(false);
    }

    public void inputPhoto_processAction(ActionEvent ae) {
    }

    public void fileUploadAttached_processAction(ActionEvent ae) {
        try {
            int index = 0;
            InputFile inpuFile = (InputFile) ae.getSource();
            FileInfo fileInfo = inpuFile.getFileInfo();
            filePath = fileInfo.getPhysicalPath().toString();
            File file = new File(filePath);
            fileExtenstion = file.getName();
            index = fileExtenstion.lastIndexOf(".");
            fileExtenstion = fileExtenstion.substring(index + 1);
            setEmployeeFile(EmployeeManage.extractByteArray(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String fileUploadAttached_action() {
        //return null means stay on the same page
        return null;
    }
    private int selectedRow = -1;

    public void readPdfFiles(int documentId, String _fileName, String extension) {
        try {
            byte[] attachedFile = educationApproveManager.singleSelect(documentId);
            if (attachedFile != null) {
                ResourceManager.fileFromDb = attachedFile;
                StringBuilder builder = new StringBuilder();
                builder.append(_fileName);
                builder.append(".");
                builder.append(extension);
                setFileName(builder.toString());
                setMimeType("application/" + extension);
                faResource = new ByteArrayResource(attachedFile);
                pnlDownload1.setRendered(true);
            } else {
                showSuccessOrFailureMessage(false, "FIRST SELECT A REQUEST OR \n THERE IS NO ATTACHED DOCUMENT");
                pnlDownload1.setRendered(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String cmdAccepatnce_action() {
        //return null means stay on the same page
        FileUpLoad commentFile = new FileUpLoad();
        try {
            requestFile = educationRequestId;
            commentFile = educationApproveManager.setValues(educationRequestId);
            setDownloadAvailable(false);
            readPdfFiles(educationRequestId, commentFile.getFileName(), commentFile.getExtention());
            setDownloadAvailable(true);


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    private String getCommitteeForwardListSave() {
        if (fileExtenstion != null && getEmployeeFile() != null) {
            if (educationApproveManager.saveFile(minuteAttachedForwardedList, fileExtenstion, getEmployeeFile()) == true) {
                showSuccessOrFailureMessage3(true, "SAVED");
            } else {
                showSuccessOrFailureMessage3(false, "FAILED");
            }
        } else {
            showSuccessOrFailureMessage3(true, "FIRST ATTACH A DOCUMNET");
        }
        return null;
    }

    private void populateComeeteeComeentstoAttach(EducationRequestModel educationRequestModel) {
        int counterCheck = 0;
        int totalSize = committeeForwardList.size();
        for (counterCheck = 0; counterCheck <=
                totalSize;) {
            educationRequestId = educationRequestModel.getEducationRequestId();
            comeeteeCommentsGive =
                    educationApproveManager.getCommiteeComentes(educationRequestModel.getEducationRequestId());

            if ((comeeteeCommentsGive.size() >= sizeOfCommitee)) {
                cmdview_Committee_Comments.setRendered(true);
                cmdLinkConfirmCommitteeDecisions.setDisabled(true);
                fileUploadAttached.setDisabled(false);
                btnAttachMinute.setDisabled(false);
                cmdAccepatnce1.setDisabled(false);
                lyTableFile1.setRendered(true);
            } else {
                cmdview_Committee_Comments.setRendered(false);
                cmdLinkConfirmCommitteeDecisions.setDisabled(false);
                fileUploadAttached.setDisabled(true);
                btnAttachMinute.setDisabled(true);
                cmdAccepatnce1.setDisabled(true);
                lyTableFile1.setRendered(false);
                showSuccessOrFailureMessage(false, "YOU CAN NOT ATTACH A DOCUMENT!!");
            }

            counterCheck++;
        }

    }

    private void getCommitteeComentSizeCheck() {
        ArrayList<Option> listOf = educationApproveManager.getCommeeteforwardListByApprover();
        String list[] = new String[listOf.size()];
        int i = 0;

        for (Option op : listOf) {
            list[i] = op.getValue().toString().split("-")[0];
            //educationApproveManager.saveFile(Integer.valueOf(list[i]), fileExtenstion, getEmployeeFile());
            comeeteeCommentsGive =
                    educationApproveManager.getCommiteeComentes(Integer.valueOf(list[i]));

            if ((comeeteeCommentsGive.size() > sizeOfCommitee)) {
                cmdview_Committee_Comments.setRendered(true);
                cmdLinkConfirmCommitteeDecisions.setDisabled(true);
                fileUploadAttached.setDisabled(false);
                btnAttachMinute.setDisabled(false);
                cmdAccepatnce1.setDisabled(false);
                lyTableFile1.setRendered(true);
            } else {
                cmdview_Committee_Comments.setRendered(false);
                cmdLinkConfirmCommitteeDecisions.setDisabled(false);
                fileUploadAttached.setDisabled(true);
                btnAttachMinute.setDisabled(true);
                cmdAccepatnce1.setDisabled(true);
                lyTableFile1.setRendered(false);
                showSuccessOrFailureMessage(false, "YOU CAN NOT ATTACH A DOCUMENT!!");
            }

            i++;

        }

// return list;
    }

    public String btnAttachMinute_action() {
        //getCommitteeForwardListSave();
        if (educationApproveManager.saveFile(minuteAttachedForwardedList, fileExtenstion, getEmployeeFile())) {
            showSuccessOrFailureMessage(true, "FILE ATTACHED SUCCESSFULLY");
        } else {
            showSuccessOrFailureMessage(false, "FILE NOT ATTACHED ");
        }

        return null;
    }

    public void selectMyHistoryLists_validate(FacesContext context, UIComponent component, Object value) {
    }

    public String button1_action() {
        //return null means stay on the same page
        try {
            if (committeeForwardList.size() != 0) {
                getCommitteeComentSizeCheck();
            } else {
                showSuccessOrFailureMessage(false, "THERE IS NO FORWARDED REQUEST");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public String modalPnlCloseBtn1_action() {
        //return null means stay on the same page
        pnlPopUpForwardedList.setRendered(false);
        return null;
    }

    public void rowSelector5_processAction(RowSelectorEvent rse) {
        selectedRow = rse.getRow();

    }

    public void ckboClearing_processValueChange(ValueChangeEvent vce) {
//        selectedRow = tblForwardedList.getRowIndex();
//        int educRequestID = availableForwardedList.get(selectedRow).getEducationRequestId();
//        lblAccusationAcceptanceValue.setRendered(true);
//        fileUploadAttached.setRendered(true);
//        btnAttachMinute.setRendered(true);
    }

    public void cmdview_Committee_Comments1_processAction(ActionEvent ae) {
    }

    public String btnSaveMinute1_action() {
        //return null means stay on the same page
        if (fileExtenstion != null && getEmployeeFile() != null) {
            if (educationApproveManager.saveFile(minuteAttachedForwardedList, fileExtenstion, getEmployeeFile()) == true) {
                showSuccessOrFailureMessage3(true, "SAVED");
            } else {
                showSuccessOrFailureMessage3(false, "FAILED");
            }
        } else {
            showSuccessOrFailureMessage3(true, "FIRST ATTACH A DOCUMNET");
        }
        return null;


    }

    public void selManyNotTrainnedEmployees_processValueChange(ValueChangeEvent vce) {
    }

    public String btnAddToGroup_action() {
        //return null means stay on the same page
        selectedForwarededRequest = selecetForwardedList.getSelectedValues();
        Iterator<SelectItem> it = forwardedList.iterator();
        while (it.hasNext()) {
            Object current = it.next();
            for (int counter = 0; counter < selectedForwarededRequest.length; counter++) {
                if (((SelectItem) current).getValue().toString().equals(selectedForwarededRequest[counter].toString())) {
                    minuteAttachedForwardedList.add(((SelectItem) current));
                    it.remove();
                }
            }
        }
        return null;
    }

    public String btnRemoveFromGroup_action() {
        //return null means stay on the same page
        selectedItemsFromMinute = selectMiniteAttached.getSelectedValues();
        Iterator<SelectItem> it = minuteAttachedForwardedList.iterator();
        while (it.hasNext()) {
            Object current = it.next();
            for (int counter = 0; counter < selectedItemsFromMinute.length; counter++) {
                if (((SelectItem) current).getValue().toString().equals(selectedItemsFromMinute[counter].toString())) {
                    forwardedList.add(((SelectItem) current));
                    it.remove();
                }
            }
        }
        return null;
    }

    public String btnAddAllToGroup_action() {
        //return null means stay on the same page
        if (forwardedList != null) {
            if (minuteAttachedForwardedList != null) {
                for (SelectItem current : forwardedList) {
                    minuteAttachedForwardedList.add(current);
                }
            } else {
                minuteAttachedForwardedList = new ArrayList<SelectItem>();
                for (SelectItem current : forwardedList) {
                    minuteAttachedForwardedList.add(current);
                }
            }
            forwardedList.clear();
        }
        return null;
    }

    public String btnRemoveAllFromGroup_action() {
        //return null means stay on the same page
        if (minuteAttachedForwardedList != null) {
            if (minuteAttachedForwardedList != null) {
                for (SelectItem current : minuteAttachedForwardedList) {
                    forwardedList.add(current);
                }
            } else {
                forwardedList = new ArrayList<SelectItem>();//if null initialize
                for (SelectItem current : minuteAttachedForwardedList) {
                    forwardedList.add(current);
                }
            }
            minuteAttachedForwardedList.clear();
        }
        return null;
    }

    public String cmdviewAttachedDocument_action() {
        //return null means stay on the same page
        try {
            forwardedList = educationApproveManager.getAllForwardedRequest();
            if (forwardedList.isEmpty()) {
                showSuccessOrFailureMessage(false, "THERE IS NO FORWARDED REQUEST OR ALREADY ATTACHED!!");
                pnlPopUpForwardedList.setRendered(false);
            } else {
                pnlPopUpForwardedList.setRendered(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private int CheckRequest(int educationRequestIdd) {
        try {
            return educationApproveManager.CheckIDFoundInRequestHistory(educationRequestIdd);
        } catch (Exception ex) {
            return 0;
        }
    }

    public String btnUpdateMInute_action() {
        //return null means stay on the same page
        if ((CheckRequest(educationRequestId)) == 1) {
            if (fileExtenstion != null && getFileExtenstion() != null) {
                if (educationApproveManager.UpdateFile(educationRequestId, fileExtenstion, getEmployeeFile())) {
                    showSuccessOrFailureMessage(true, "FILE UPDATE SEUCSSESFULLY");
                } else {
                    showSuccessOrFailureMessage(true, "FILE UPDATE FAILD");
                }
            } else {
                showSuccessOrFailureMessage(false, "FIRST ATTACHE A FILE");
            }
        }
        else{
         showSuccessOrFailureMessage(false, "THERE IS NO ATTACHED DOCUMENT!! \n\n YOU CAN'T UPDATE A FILE");
        }
        return null;
    }

    public void chkUpdateminute_processValueChange(ValueChangeEvent vce) {
        if (chkUpdateminute.isSelected()) {
            lyTableFile2.setRendered(true);
            btnUpdateMInute.setRendered(true);
        } else {
            lyTableFile2.setRendered(false);
            btnUpdateMInute.setRendered(false);
        }
    }

    public String btnAttachMinute1_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupSuccessOrFailure1_action() {
        //return null means stay on the same page
        pnlPopupSuccessOrFailure2.setRendered(false);
        return null;
    }
}