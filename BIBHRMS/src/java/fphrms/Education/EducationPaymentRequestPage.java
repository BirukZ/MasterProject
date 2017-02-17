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
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
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
import com.icesoft.faces.component.paneltabset.PanelTab;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.LookUpManger;
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.educationManager.EducationPaymentApproveManager;
import manager.educationManager.EducationPaymentModel;
import manager.educationManager.EducationPaymentRequestManager;
import manager.educationManager.EducationRequestManager;
import manager.educationManager.EducationRequestModel;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EducationPaymentRequestPage extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    private String catID;
    private int tableSize;
    private int rank;

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
        educationPaymentRequestManager.setUserName(userName);
        educationPaymentRequestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
        requestHistoryList = educationPaymentRequestManager.getMyRequestsHistory();
        pendingRequestList = educationPaymentRequestManager.getPendingRequests();
        disableComponents();
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
    private HtmlInputText txtDocumentReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocumentReferenceNumber() {
        return txtDocumentReferenceNumber;
    }

    public void setTxtDocumentReferenceNumber(HtmlInputText hit) {
        this.txtDocumentReferenceNumber = hit;
    }
    private HtmlInputText txttotalCost = new HtmlInputText();

    public HtmlInputText getTxttotalCost() {
        return txttotalCost;
    }

    public void setTxttotalCost(HtmlInputText hit) {
        this.txttotalCost = hit;
    }
    private DefaultSelectedData selectObjectOfPrePayment = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfPostPayment = new DefaultSelectedData();

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public DefaultSelectedData getSelectObjectOfPostPayment() {
        return selectObjectOfPostPayment;
    }

    public void setSelectObjectOfPostPayment(DefaultSelectedData selectObjectOfPostPayment) {
        this.selectObjectOfPostPayment = selectObjectOfPostPayment;
    }

    public DefaultSelectedData getSelectObjectOfPrePayment() {
        return selectObjectOfPrePayment;
    }

    public void setSelectObjectOfPrePayment(DefaultSelectedData selectObjectOfPrePayment) {
        this.selectObjectOfPrePayment = selectObjectOfPrePayment;
    }
    private HtmlInputTextarea txtaInstitutionName = new HtmlInputTextarea();
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlInputText txtAcademicYear = new HtmlInputText();

    public HtmlInputText getTxtAcademicYear() {
        return txtAcademicYear;
    }

    public void setTxtAcademicYear(HtmlInputText hit) {
        this.txtAcademicYear = hit;
    }
    private HtmlInputText txtUnitCost = new HtmlInputText();

    public HtmlInputText getTxtUnitCost() {
        return txtUnitCost;
    }

    public void setTxtUnitCost(HtmlInputText hit) {
        this.txtUnitCost = hit;
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

    public ArrayList<EducationPaymentModel> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(ArrayList<EducationPaymentModel> availableCourses) {
        this.availableCourses = availableCourses;
    }

    public LookUpManger getLookupnger() {
        return lookupnger;
    }

    public void setLookupnger(LookUpManger lookupnger) {
        this.lookupnger = lookupnger;
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

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
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
    private HtmlInputText txtSemesterOrTerm = new HtmlInputText();

    public HtmlInputText getTxtSemesterOrTerm() {
        return txtSemesterOrTerm;
    }

    public void setTxtSemesterOrTerm(HtmlInputText hit) {
        this.txtSemesterOrTerm = hit;
    }
    private HtmlInputText txtReciptNumber = new HtmlInputText();

    public HtmlInputText getTxtReciptNumber() {
        return txtReciptNumber;
    }

    public void setTxtReciptNumber(HtmlInputText hit) {
        this.txtReciptNumber = hit;
    }
    private HtmlInputText txtIssueDate = new HtmlInputText();

    public HtmlInputText getTxtIssueDate() {
        return txtIssueDate;
    }

    public void setTxtIssueDate(HtmlInputText hit) {
        this.txtIssueDate = hit;
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
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlDataTable dataAdminstrativeCost = new HtmlDataTable();

    public HtmlDataTable getDataAdminstrativeCost() {
        return dataAdminstrativeCost;
    }

    public void setDataAdminstrativeCost(HtmlDataTable hdt) {
        this.dataAdminstrativeCost = hdt;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
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
    private HtmlSelectOneMenu drlAdminstrativeCost = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAdminstrativeCost() {
        return drlAdminstrativeCost;
    }

    public void setDrlAdminstrativeCost(HtmlSelectOneMenu drlAdminstrativeCost) {
        this.drlAdminstrativeCost = drlAdminstrativeCost;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private UIColumn coTotal = new UIColumn();

    public UIColumn getCoTotal() {
        return coTotal;
    }

    public void setCoTotal(UIColumn uic) {
        this.coTotal = uic;
    }
    private HtmlOutputText optTxtForTotal = new HtmlOutputText();

    public HtmlOutputText getOptTxtForTotal() {
        return optTxtForTotal;
    }

    public void setOptTxtForTotal(HtmlOutputText hot) {
        this.optTxtForTotal = hot;
    }
    private HtmlCommandButton btnAddCourse = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddCourse() {
        return btnAddCourse;
    }

    public void setBtnAddCourse(HtmlCommandButton hcb) {
        this.btnAddCourse = hcb;
    }
    private HtmlDataTable dataCourse = new HtmlDataTable();

    public HtmlDataTable getDataCourse() {
        return dataCourse;
    }

    public void setDataCourse(HtmlDataTable hdt) {
        this.dataCourse = hdt;
    }
    private HtmlInputText txtCourseCode = new HtmlInputText();

    public HtmlInputText getTxtCourseCode() {
        return txtCourseCode;
    }

    public void setTxtCourseCode(HtmlInputText hit) {
        this.txtCourseCode = hit;
    }
    private HtmlInputText txtCreditHour = new HtmlInputText();

    public HtmlInputText getTxtCreditHour() {
        return txtCreditHour;
    }

    public void setTxtCreditHour(HtmlInputText hit) {
        this.txtCreditHour = hit;
    }
    private HtmlCommandButton btnCalculate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalculate() {
        return btnCalculate;
    }

    public void setBtnCalculate(HtmlCommandButton hcb) {
        this.btnCalculate = hcb;
    }
    private HtmlOutputLabel lblTutationFee = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTutationFee() {
        return lblTutationFee;
    }

    public void setLblTutationFee(HtmlOutputLabel hol) {
        this.lblTutationFee = hol;
    }
    private HtmlOutputLabel lblEducreqestID = new HtmlOutputLabel();

    public HtmlOutputLabel getLblEducreqestID() {
        return lblEducreqestID;
    }

    public void setLblEducreqestID(HtmlOutputLabel hol) {
        this.lblEducreqestID = hol;
    }
    private HtmlInputText txtInstitName = new HtmlInputText();

    public HtmlInputText getTxtInstitName() {
        return txtInstitName;
    }

    public void setTxtInstitName(HtmlInputText hit) {
        this.txtInstitName = hit;
    }
    private HtmlInputText txtLevel = new HtmlInputText();

    public HtmlInputText getTxtLevel() {
        return txtLevel;
    }

    public void setTxtLevel(HtmlInputText hit) {
        this.txtLevel = hit;
    }
    private HtmlInputText txtProgName = new HtmlInputText();

    public HtmlInputText getTxtProgName() {
        return txtProgName;
    }

    public void setTxtProgName(HtmlInputText hit) {
        this.txtProgName = hit;
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
    private SelectInputDate calAcadamicYear = new SelectInputDate();

    public SelectInputDate getCalAcadamicYear() {
        return calAcadamicYear;
    }

    public void setCalAcadamicYear(SelectInputDate sid) {
        this.calAcadamicYear = sid;
    }
    private HtmlCommandButton btnAcadamicYear = new HtmlCommandButton();

    public HtmlCommandButton getBtnAcadamicYear() {
        return btnAcadamicYear;
    }

    public void setBtnAcadamicYear(HtmlCommandButton hcb) {
        this.btnAcadamicYear = hcb;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlOutputLabel lblCourseCode = new HtmlOutputLabel();

    public HtmlOutputLabel getLblCourseCode() {
        return lblCourseCode;
    }

    public void setLblCourseCode(HtmlOutputLabel hol) {
        this.lblCourseCode = hol;
    }
    private HtmlOutputLabel lblCreditHour = new HtmlOutputLabel();

    public HtmlOutputLabel getLblCreditHour() {
        return lblCreditHour;
    }

    public void setLblCreditHour(HtmlOutputLabel hol) {
        this.lblCreditHour = hol;
    }
    private HtmlOutputLabel lblUnitCost = new HtmlOutputLabel();

    public HtmlOutputLabel getLblUnitCost() {
        return lblUnitCost;
    }

    public void setLblUnitCost(HtmlOutputLabel hol) {
        this.lblUnitCost = hol;
    }
    private HtmlOutputLabel lblAdminstrativeCost = new HtmlOutputLabel();

    public HtmlOutputLabel getLblAdminstrativeCost() {
        return lblAdminstrativeCost;
    }

    public void setLblAdminstrativeCost(HtmlOutputLabel hol) {
        this.lblAdminstrativeCost = hol;
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
    private HtmlInputText txtDocreferenceNum = new HtmlInputText();

    public HtmlInputText getTxtDocreferenceNum() {
        return txtDocreferenceNum;
    }

    public void setTxtDocreferenceNum(HtmlInputText hit) {
        this.txtDocreferenceNum = hit;
    }
    private PanelLayout lytopPanel = new PanelLayout();

    public PanelLayout getLytopPanel() {
        return lytopPanel;
    }

    public void setLytopPanel(PanelLayout pl) {
        this.lytopPanel = pl;
    }
    private PanelLayout pnlLayoutRequester = new PanelLayout();

    public PanelLayout getPnlLayoutRequester() {
        return pnlLayoutRequester;
    }

    public void setPnlLayoutRequester(PanelLayout pl) {
        this.pnlLayoutRequester = pl;
    }
    private HtmlOutputLabel lblRequester = new HtmlOutputLabel();

    public HtmlOutputLabel getLblRequester() {
        return lblRequester;
    }

    public void setLblRequester(HtmlOutputLabel hol) {
        this.lblRequester = hol;
    }
    private HtmlOutputLabel lblRequesterDepartment = new HtmlOutputLabel();

    public HtmlOutputLabel getLblRequesterDepartment() {
        return lblRequesterDepartment;
    }

    public void setLblRequesterDepartment(HtmlOutputLabel hol) {
        this.lblRequesterDepartment = hol;
    }
    private HtmlOutputLabel lblRequesterId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblRequesterId() {
        return lblRequesterId;
    }

    public void setLblRequesterId(HtmlOutputLabel hol) {
        this.lblRequesterId = hol;
    }
    private HtmlSelectOneListbox selectMyRequestLists1 = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists1() {
        return selectMyRequestLists1;
    }

    public void setSelectMyRequestLists1(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists1 = hsol;
    }
    private HtmlSelectOneListbox selectMyHistoryLists1 = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists1() {
        return selectMyHistoryLists1;
    }

    public void setSelectMyHistoryLists1(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists1 = hsol;
    }
    private PanelTab tabPerpayment = new PanelTab();

    public PanelTab getTabPerpayment() {
        return tabPerpayment;
    }

    public void setTabPerpayment(PanelTab pt) {
        this.tabPerpayment = pt;
    }
    private HtmlOutputLabel lblcourseInfo = new HtmlOutputLabel();

    public HtmlOutputLabel getLblcourseInfo() {
        return lblcourseInfo;
    }

    public void setLblcourseInfo(HtmlOutputLabel hol) {
        this.lblcourseInfo = hol;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox checkbox1 = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1 = hsbc;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
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
    private HtmlOutputLabel lblHighrLevel = new HtmlOutputLabel();

    public HtmlOutputLabel getLblHighrLevel() {
        return lblHighrLevel;
    }

    public void setLblHighrLevel(HtmlOutputLabel hol) {
        this.lblHighrLevel = hol;
    }
    private HtmlSelectBooleanCheckbox chkHigher = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkHigher() {
        return chkHigher;
    }

    public void setChkHigher(HtmlSelectBooleanCheckbox hsbc) {
        this.chkHigher = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkBasicLevel = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkBasicLevel() {
        return chkBasicLevel;
    }

    public void setChkBasicLevel(HtmlSelectBooleanCheckbox hsbc) {
        this.chkBasicLevel = hsbc;
    }
    private HtmlInputText txtGrade = new HtmlInputText();

    public HtmlInputText getTxtGrade() {
        return txtGrade;
    }

    public void setTxtGrade(HtmlInputText hit) {
        this.txtGrade = hit;
    }
    private HtmlOutputLabel lblGrade = new HtmlOutputLabel();

    public HtmlOutputLabel getLblGrade() {
        return lblGrade;
    }

    public void setLblGrade(HtmlOutputLabel hol) {
        this.lblGrade = hol;
    }
    private PanelLayout pnlLayoutButtons2 = new PanelLayout();

    public PanelLayout getPnlLayoutButtons2() {
        return pnlLayoutButtons2;
    }

    public void setPnlLayoutButtons2(PanelLayout pl) {
        this.pnlLayoutButtons2 = pl;
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
    private HtmlSelectOneMenu drlBasicLevel = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBasicLevel() {
        return drlBasicLevel;
    }

    public void setDrlBasicLevel(HtmlSelectOneMenu hsom) {
        this.drlBasicLevel = hsom;
    }
    private HtmlCommandButton btnCalendarSatartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarSatartDate() {
        return btnCalendarSatartDate;
    }

    public void setBtnCalendarSatartDate(HtmlCommandButton hcb) {
        this.btnCalendarSatartDate = hcb;
    }
    private HtmlCommandButton modalPnlCloseBtn1 = new HtmlCommandButton();

    public HtmlCommandButton getModalPnlCloseBtn1() {
        return modalPnlCloseBtn1;
    }

    public void setModalPnlCloseBtn1(HtmlCommandButton hcb) {
        this.modalPnlCloseBtn1 = hcb;
    }
    private PanelPopup pnlPopUpClearingDepSetting1 = new PanelPopup();

    public PanelPopup getPnlPopUpClearingDepSetting1() {
        return pnlPopUpClearingDepSetting1;
    }

    public void setPnlPopUpClearingDepSetting1(PanelPopup pp) {
        this.pnlPopUpClearingDepSetting1 = pp;
    }
    private HtmlCommandLink lnkViewCourseLists = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewCourseLists() {
        return lnkViewCourseLists;
    }

    public void setLnkViewCourseLists(HtmlCommandLink hcl) {
        this.lnkViewCourseLists = hcl;
    }
    private HtmlDataTable tblClearingDep1 = new HtmlDataTable();

    public HtmlDataTable getTblClearingDep1() {
        return tblClearingDep1;
    }

    public void setTblClearingDep1(HtmlDataTable hdt) {
        this.tblClearingDep1 = hdt;
    }
    private HtmlOutputLabel lblInstitPrevId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblInstitPrevId() {
        return lblInstitPrevId;
    }

    public void setLblInstitPrevId(HtmlOutputLabel hol) {
        this.lblInstitPrevId = hol;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists = hsol;
    }
    private HtmlInputText txtResult = new HtmlInputText();

    public HtmlInputText getTxtResult() {
        return txtResult;
    }

    public void setTxtResult(HtmlInputText hit) {
        this.txtResult = hit;
    }
    private HtmlOutputLabel lblResult = new HtmlOutputLabel();

    public HtmlOutputLabel getLblResult() {
        return lblResult;
    }

    public void setLblResult(HtmlOutputLabel hol) {
        this.lblResult = hol;
    }
    private HtmlCommandButton btnSearchRequester = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchRequester() {
        return btnSearchRequester;
    }

    public void setBtnSearchRequester(HtmlCommandButton hcb) {
        this.btnSearchRequester = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EducationPaymentRequestPage() {
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
        //validtae();
        if (adminstrativeCosts.isEmpty() ||
                (lookupnger.getEmpitiedTableList() != null && lookupnger.getEmpitiedTableList().contains("HR_LU_ADMINSTRATIVE_COST"))) {
            adminstrativeCosts = educationPaymentRequestManager.getAdminstrativeCost();
            lookupnger.getEmpitiedTableList().remove("HR_LU_ADMINSTRATIVE_COST");
        } else {
        }
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

    public ArrayList<SelectItem> getEducationTypeCatagoryList() {
        return educationTypeCatagoryList;
    }

    public void setEducationTypeCatagoryList(ArrayList<SelectItem> educationTypeCatagoryList) {
        this.educationTypeCatagoryList = educationTypeCatagoryList;
    }

    public ArrayList<SelectItem> getEducationShiftList() {
        return educationShiftList;
    }

    public ArrayList<SelectItem> getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(ArrayList<SelectItem> educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setEducationShiftList(ArrayList<SelectItem> educationShiftList) {
        this.educationShiftList = educationShiftList;
    }

    public void setPendingRequestList(ArrayList<SelectItem> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public ArrayList<SelectItem> getRequestHistoryList() {
        return requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<SelectItem> requestHistoryList) {
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

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
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

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public double getAdminstrativeCost() {
        return adminstrativeCost;
    }

    public void setAdminstrativeCost(double adminstrativeCost) {
        this.adminstrativeCost = adminstrativeCost;
    }

    public ArrayList<SelectItem> getAdminstrativeCosts() {
        return adminstrativeCosts;
    }

    public void setAdminstrativeCosts(ArrayList<SelectItem> adminstrativeCosts) {
        this.adminstrativeCosts = adminstrativeCosts;
    }

    public EducationPaymentApproveManager getEducationPaymentApproveManager() {
        return educationPaymentApproveManager;
    }

    public void setEducationPaymentApproveManager(EducationPaymentApproveManager educationPaymentApproveManager) {
        this.educationPaymentApproveManager = educationPaymentApproveManager;
    }

    public EducationPaymentModel getEducationPaymentModel() {
        return educationPaymentModel;
    }

    public void setEducationPaymentModel(EducationPaymentModel educationPaymentModel) {
        this.educationPaymentModel = educationPaymentModel;
    }

    public int getEducationPaymentRequestId() {
        return educationPaymentRequestId;
    }

    public void setEducationPaymentRequestId(int educationPaymentRequestId) {
        this.educationPaymentRequestId = educationPaymentRequestId;
    }

    public EducationPaymentRequestManager getEducationPaymentRequestManager() {
        return educationPaymentRequestManager;
    }

    public void setEducationPaymentRequestManager(EducationPaymentRequestManager educationPaymentRequestManager) {
        this.educationPaymentRequestManager = educationPaymentRequestManager;
    }

    public EducationRequestModel getEducationRequestModel() {
        return educationRequestModel;
    }

    public void setEducationRequestModel(EducationRequestModel educationRequestModel) {
        this.educationRequestModel = educationRequestModel;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

//    public ArrayList<SelectItem> getNameOfInstitution() {
//        return nameOfInstitution;
//    }
//
//    public void setNameOfInstitution(ArrayList<SelectItem> nameOfInstitution) {
//        this.nameOfInstitution = nameOfInstitution;
//    }
    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentPreOrPost() {
        return paymentPreOrPost;
    }

    public void setPaymentPreOrPost(String paymentPreOrPost) {
        this.paymentPreOrPost = paymentPreOrPost;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSemesterOrTerm() {
        return semesterOrTerm;
    }

    public void setSemesterOrTerm(String semesterOrTerm) {
        this.semesterOrTerm = semesterOrTerm;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ArrayList<EducationPaymentModel> getAdminstrativeCostLists() {
        return adminstrativeCostLists;
    }

    public void setAdminstrativeCostLists(ArrayList<EducationPaymentModel> adminstrativeCostLists) {
        this.adminstrativeCostLists = adminstrativeCostLists;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTutationFee() {
        return tutationFee;
    }

    public void setTutationFee(double tutationFee) {
        this.tutationFee = tutationFee;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getAdminstrativeCostType() {
        return adminstrativeCostType;
    }

    public float getCGPA() {
        return cGPA;
    }

    public void setCGPA(float cGPA) {
        this.cGPA = cGPA;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCreditHr() {
        return creditHr;
    }

    public void setCreditHr(String creditHr) {
        this.creditHr = creditHr;
    }

    public void setAdminstrativeCostType(String adminstrativeCostType) {
        this.adminstrativeCostType = adminstrativeCostType;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

//    public ArrayList<SelectItem> getProgramName() {
//        return programName;
//    }
    public ArrayList<EducationPaymentModel> getCourseTakingList() {
        return courseTakingList;
    }

    public void setCourseTakingList(ArrayList<EducationPaymentModel> courseTakingList) {
        this.courseTakingList = courseTakingList;
    }

//    public void setProgramName(ArrayList<SelectItem> programName) {
//        this.programName = programName;
//    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getGradeBasic() {
        return gradeBasic;
    }

    public void setGradeBasic(String gradeBasic) {
        this.gradeBasic = gradeBasic;
    }

    public String getGradePt() {
        return gradePt;
    }

    public void setGradePt(String gradePt) {
        this.gradePt = gradePt;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public int getSelectedRowCors() {
        return selectedRowCors;
    }

    public void setSelectedRowCors(int selectedRowCors) {
        this.selectedRowCors = selectedRowCors;
    }

    public SimpleDateFormat getYearFormat() {
        return yearFormat;
    }

    public void setYearFormat(SimpleDateFormat yearFormat) {
        this.yearFormat = yearFormat;
    }

    public String getEducationProgramcategory() {
        return educationProgramcategory;
    }

    public void setEducationProgramcategory(String educationProgramcategory) {
        this.educationProgramcategory = educationProgramcategory;
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

    public String lnkEducationRequest_action() {
        return "EducationRequest";
    }

    public String lnkEducationPaymentRequest_action() {
        return "EducationPaymentRequest";
    }

    public String lnkEducationApprove_action() {
        return "EducationApprove";
    }

    public String lnkChangeiNstitutionReq_action() {
        return "ChangeInstitutionPage";
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
        txtAppliedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
    public boolean checkEducationalStatus() {
        //ArrayList<HashMap> educationPrePaidCheck = new ArrayList<HashMap>();
        String empInfoHashMap = educationRequestManager.getEducationalStatus(requesterId);
        if (empInfoHashMap != null) {
            if ((empInfoHashMap.equalsIgnoreCase("Dismised")) || (empInfoHashMap.equalsIgnoreCase("Withdrwal")) || (empInfoHashMap.equalsIgnoreCase("Re-Admission"))) {
                showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST THE PAYMENT!! \n THE REQUESTER IS :" + empInfoHashMap);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean checkEducChangeInsti() {
        String empInfoHashMap = educationRequestManager.getEducationalChangeInst(requesterId);
        if ((empInfoHashMap.equalsIgnoreCase("Yes"))) {
            showSuccessOrFailureMessage(false, "THE EMPLOYEE CHANGES HIS INSTITITUTION");
            return true;
        } else {
            return false;
        }
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        txtRequesterId.setValue(requesterId);

        if (requesterId != null) {
            if (!checkEducationalStatus()) {
                if (populateRequesterTextComponents(requesterId) && populateRequesterDtaeofBirth(requesterId) && populateEducationdDrlComponents(requesterId)) {

                    if ((populateAgreemnt(requesterId)) == false) {
                        disableComponents();
                        btnSaveOrUpdate.setDisabled(true);
                        showSuccessOrFailureMessage(false, txtRequesterId.getValue().toString() + "IS NOT SIGNED AN AGREEMENT");

                    } else {
                        enableComponents();
                        btnSaveOrUpdate.setDisabled(false);
                    }

                }
            } else {
                showSuccessOrFailureMessage(false, "NO EDUCATION REQUEST  IS FOUND WITH EMPLOYEE ID : " + txtRequesterId.getValue().toString() + "OR THE REQUEST IS NOT APPROVED");
                requesterId = null;
                clearAllComponents();



            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
        return null;
    }

    private boolean populateRequesterDtaeofBirth(String employeeId) {
        String empInfoHashMap = educationRequestManager.getDateOfBirth(employeeId);
        String hireDate = educationRequestManager.getHIREDATE(employeeId);

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

        return true;
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        HashMap empEduHashMap = educationRequestManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("") && empEduHashMap.get("employeeId").toString().equals("")) {//if no resultset found
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

    private boolean populateEducationdDrlComponents(String employeeId) {

        HashMap empInfoHashMap = educationPaymentRequestManager.readEducationInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EDUCATION REQUEST FOUND WITH ID : " + employeeId);
                requesterId = null;
                return false;
            } else {

                requesterId = employeeId;
                lblEducreqestID.setValue(empInfoHashMap.get("educRequestId"));

                txtProgName.setValue(empInfoHashMap.get("educProgramName"));
                txtLevel.setValue(empInfoHashMap.get("educLevelCategort"));
                txtDocreferenceNum.setValue(empInfoHashMap.get("docReference"));
                txtGrade.setValue(empInfoHashMap.get("levelId"));
                if (txtGrade.getValue().toString().equalsIgnoreCase("BASIC")) {
                    lblCourseCode.setRendered(false);
                    lblCreditHour.setRendered(false);
                    txtCourseCode.setRendered(false);
                    txtCreditHour.setRendered(false);
                    pnlLayoutButtons2.setRendered(false);

                }
                if (txtGrade.getValue().toString().equalsIgnoreCase("HIGH")) {
                    lblCourseCode.setRendered(true);
                    lblCreditHour.setRendered(true);
                    txtCourseCode.setRendered(true);
                    txtCreditHour.setRendered(true);

                    pnlLayoutButtons2.setRendered(true);
                }

                if (txtGrade.getValue().toString().equalsIgnoreCase("DRIV")) {

                    pnlLayoutButtons2.setRendered(false);
                    lblCreditHour.setRendered(false);
                    lblCourseCode.setRendered(false);
                    txtCourseCode.setRendered(false);
                    txtCreditHour.setRendered(false);


                }


                lblInstitPrevId.setValue(empInfoHashMap.get("institutionNAme"));
                String instId = lblInstitPrevId.getValue().toString();
                institutionName = educationRequestManager.getTypeOFInstName(instId);
                txtInstitName.setValue(institutionName);
                if (empInfoHashMap.get("CHANGE_INSTITUTION").equals("Yes")) {
                    showSuccessOrFailureMessage(false, "THE EMPLOYEE CHANGES HIS INSTITITUTION TO " + institutionName);
                    lnkViewCourseLists.setRendered(true);
                } else {
                    lnkViewCourseLists.setRendered(false);
                }
                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateAgreemnt(String employeeId) {

        HashMap empInfoHashMap = educationPaymentRequestManager.readAgremment(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("educ_requ_id").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "YOU HAVE TO REGISTER THE AGREEMENT FIRST : " + employeeId);
                requesterId = null;
                disableComponents();
                btnSaveOrUpdate.setDisabled(true);
                return false;
            } else {
                enableComponents();
                btnSaveOrUpdate.setDisabled(false);
            }
            return true;

        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populatePaymentRequestTextComponents(int requestId) {

        educationPaymentModel = educationPaymentRequestManager.getEducationPaymentRequest(requestId);
        if (educationPaymentModel != null) {
            if (educationPaymentModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {
                lblTutationFee.setRendered(true);
                txttotalCost.setRendered(true);
                txttotalCost.setValue(educationPaymentModel.getTotalCost());
                txtAppliedDate.setValue(educationPaymentModel.getAppliedDate());
                txtIssueDate.setValue(educationPaymentModel.getIssueDate());
                txtDocumentReferenceNumber.setValue(educationPaymentModel.getDocumentReferenceNumber());
                txtReciptNumber.setValue(educationPaymentModel.getReceiptNumber());
                txtSemesterOrTerm.setValue(educationPaymentModel.getSemesterOrTerm());
                txtAcademicYear.setValue(educationPaymentModel.getAcademicYear());
                txtRemark.setValue(educationPaymentModel.getRemark());


                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateEducationComponents(int requestId) {

        educationRequestModel = educationRequestManager.getEducationRequest(requestId);
        if (educationRequestModel != null) {
            if (educationRequestModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {
                txtProgName.setValue(educationRequestModel.getEducationProgramName());
                lblInstitPrevId.setValue(educationRequestModel.getInstitutionName());
                String instId = lblInstitPrevId.getValue().toString();
                institutionName = educationRequestManager.getTypeOFInstName(instId);
                txtInstitName.setValue(institutionName);

                txtLevel.setValue(educationRequestModel.getEducationLevelCategory());
                txtDocreferenceNum.setValue(educationRequestModel.getDocumentReferenceNumber());
                txtGrade.setValue(educationRequestModel.getLevelID());
                if (txtGrade.getValue().toString().equalsIgnoreCase("HIGH")) {
                    pnlLayoutButtons2.setRendered(true);
                    populateCourseTableComponents(educationRequestId, appliedDate);
                    lblCreditHour.setRendered(true);
                    lblCreditHour.setRendered(true);
                    txtCourseCode.setRendered(true);
                    txtCreditHour.setRendered(true);
                } else {
                    lblCreditHour.setRendered(false);
                    lblCreditHour.setRendered(false);
                    pnlLayoutButtons2.setRendered(false);
                    txtCourseCode.setRendered(false);
                    txtCreditHour.setRendered(false);
                }
                if (educationRequestModel.getChangeInstStatus().equals("Yes")) {
                    showSuccessOrFailureMessage(false, "THE EMPLOYEE CHANGES HIS INSTITITUTION TO " + institutionName);
                    lnkViewCourseLists.setRendered(true);
                } else {
                    lnkViewCourseLists.setRendered(false);
                }

                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateRequesterTableComponents(int educatRequestId, String date) {
        ArrayList<HashMap> empInfoHashMap = educationPaymentRequestManager.getTableInfo(educatRequestId, date);

        if (empInfoHashMap != null) {
            tableSize = 0;
            getAdminstrativeCostLists().clear();

            for (HashMap hmTc : empInfoHashMap) {
                educationRequestId = educatRequestId;
                adminstrativeCostType = hmTc.get("AMINSTRATIVE_COST_TYPE").toString();
                unitCost = Double.valueOf(hmTc.get("UNIT_COST").toString());

                totalCost = Double.valueOf(hmTc.get("TOTAL_COST").toString());
                requesterId = hmTc.get("REQUESTER_ID").toString();
                adminId = Integer.valueOf(hmTc.get("ID").toString());
                adminstrativeCostLists.add(new EducationPaymentModel(requesterId, unitCost, totalCost, adminstrativeCostType, educationRequestId));
                tableSize++;
                nonRenderComponenet();
            }
            return true;
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateCourseTableComponents(int educatRequestId, String date) {

        ArrayList<HashMap> empInfoHashMap = educationPaymentRequestManager.getCourseInfo(educatRequestId, date);
        if (empInfoHashMap != null) {
            tableSize = 0;

            getCourseTakingList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                educationRequestId = educatRequestId;
                requesterId = hmTc.get("REQUESTER_ID").toString();
                courseCode = hmTc.get("COURSE_CODE").toString();
                creditHr = hmTc.get("CREDIT_HOUR").toString();
                semesterOrTerm = hmTc.get("SEMISTER").toString();
                courseID = Integer.valueOf(hmTc.get("ID").toString());
                academicYear = hmTc.get("ACADAMIC_YEAR").toString();
                courseTakingList.add(new EducationPaymentModel(requesterId, courseCode, creditHr, semesterOrTerm, educationRequestId, academicYear, courseID));
                tableSize++;

            }
            return true;
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void clearRequesterTextComponents() {
        txtRequesterDepartment.setValue(null);
        txtRequesterPosition.setValue(null);
        txtlblRequesterEdLevel.setValue(null);
        txtlblRequesterProgramName.setValue(null);
    }

    public boolean isEntryValidForSearchTerminator() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;

        required = HRValidation.validateRequired(this.txtRequesterId.getValue());
        if (!required) {
            ((UIInput) txtRequesterId).setValid(false);
            error(txtRequesterId, errorMessage);
            results = false;
        }

        return results;
    }

    private void clearAllComponents() {
        clearEducationComponents();
        clearRequestComponents();
        clearRequesterTextComponents();
        clearDropDownItems();
        txtRequesterFullName.setValue(null);
        txtRequesterId.setValue(null);

    }

    private void clearDropDownItems() {
        selectedRequestFromMyRequestList = new DefaultSelectedData();
        selectedRequestFromHistoryList.setSelectedObject(null);
        selectObjectOfEducationTypeCatagory.setSelectedObject(null);
        selectObjectOfEducationLevelCatagory.setSelectedObject(null);
        selectObjectOfEducationShiftCatagory.setSelectedObject(null);
        drlAdminstrativeCost.setValue("0");
    }

    public void enableComponents() {

        txtUnitCost.setDisabled(false);
        txtAppliedDate.setDisabled(false);
        txttotalCost.setDisabled(false);
        txtDocumentReferenceNumber.setDisabled(false);
        txtAcademicYear.setDisabled(false);

        txtRemark.setDisabled(false);
        drlAdminstrativeCost.setDisabled(false);
        txtLevel.setDisabled(false);
        txtIssueDate.setDisabled(false);

        txtSemesterOrTerm.setDisabled(false);

        txtCourseCode.setDisabled(false);
        txtCreditHour.setDisabled(false);
        btnAdd.setDisabled(false);
        btnAddCourse.setDisabled(false);
        btnAcadamicYear.setDisabled(false);
        btnCalendarSatartDate.setDisabled(false);

    }

    public void disableComponents() {

        txtUnitCost.setDisabled(true);
        txtAppliedDate.setDisabled(true);
        txttotalCost.setDisabled(true);
        txtDocumentReferenceNumber.setDisabled(true);
        txtAcademicYear.setDisabled(true);

        txtRemark.setDisabled(true);
        drlAdminstrativeCost.setDisabled(true);

        txtIssueDate.setDisabled(true);
        txtReciptNumber.setDisabled(true);

        txtSemesterOrTerm.setDisabled(true);

        txtCourseCode.setDisabled(true);
        txtCreditHour.setDisabled(true);
        btnAdd.setDisabled(true);
        btnAddCourse.setDisabled(true);
        btnAcadamicYear.setDisabled(true);
        btnCalendarSatartDate.setDisabled(true);
    }

    public void nonRenderComponenet() {
        drlAdminstrativeCost.setRendered(false);
        txtUnitCost.setRendered(false);
        txtCourseCode.setRendered(false);
        txtCreditHour.setRendered(false);
        lblCourseCode.setRendered(false);
        lblCreditHour.setRendered(false);
        lblUnitCost.setRendered(false);
        lblAdminstrativeCost.setRendered(false);

    }

    public void renderComponenet() {
        drlAdminstrativeCost.setRendered(true);
        txtUnitCost.setRendered(true);
        lblUnitCost.setRendered(true);
        lblAdminstrativeCost.setRendered(true);
        lblTutationFee.setRendered(false);
        txttotalCost.setRendered(false);

    }

    public void clearEducationComponents() {
        txtInstitName.setValue(null);
        txtProgName.setValue(null);
        txtLevel.setValue(null);
        txtGrade.setValue(null);
        drlAdminstrativeCost.setValue(null);
    }

    public void clearRequestComponents() {
        txtUnitCost.setValue(null);
        txtAppliedDate.setValue(null);
        txttotalCost.setValue(null);
        txtDocumentReferenceNumber.setValue(null);
        txtAcademicYear.setValue(null);
        txtRemark.setValue(null);
        txtCourseCode.setValue(null);
        txtCreditHour.setValue(null);
        txttotalCost.setValue(null);
        txtIssueDate.setValue(null);
        txtReciptNumber.setValue(null);
        txtLevel.setValue(null);
        txtDocreferenceNum.setValue(null);
        txtSemesterOrTerm.resetValue();

        getAdminstrativeCostLists().clear();
        getCourseTakingList().clear();
    }

    private void makePageReadyForSave() {

        newOrEditOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(false);

    }

    private void makePageReadyForUpdate() {
        enableComponents();
        newOrEditOrUpdateLabel = "Update";
        btnDelete.setDisabled(false);
        btnSaveOrUpdate.setDisabled(true);
        lnkViewPrevieousDecisions.setRendered(false);
    }

    private void makePageReadyForView() {
        disableComponents();
        newOrEditOrUpdateLabel = "Save";
        btnDelete.setDisabled(true);
        btnSaveOrUpdate.setDisabled(true);
        lnkViewPrevieousDecisions.setRendered(true);

    }

    private void renderPreviosDescisionLink(String currentStatus) {
        if (!currentStatus.equals(EducationPaymentApproveManager.INITIAL_STATE_EDUCATION_PAYMENT)) {
            populateDecisionHistory(educationPaymentRequestId);
            lnkViewPrevieousDecisions.setRendered(true);
        } else {
            lnkViewPrevieousDecisions.setRendered(false);
        }
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

    private void populateDecisionHistory(int requestId) {
        decisionsMadeOnRequestList = educationPaymentApproveManager.getRequestHistory(requestId);
//        if (decisionsMadeOnRequestList.size() > 0) {
//            lnkViewPrevieousDecisions.setRendered(true);
//        } else {
//            lnkViewPrevieousDecisions.setRendered(false);
//            makePageReadyForUpdate();
//        }
    }

    // </editor-fold>
    // </editor-fold >
    // </editor-fold >
    EmployeeManage employeeManager = new EmployeeManage();
    LookUpManger lookupnger = new LookUpManger();
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationPaymentModel educationPaymentModel = new EducationPaymentModel();
    EducationRequestManager educationRequestManager = new EducationRequestManager();
    EducationPaymentRequestManager educationPaymentRequestManager = new EducationPaymentRequestManager();
    EducationPaymentApproveManager educationPaymentApproveManager = new EducationPaymentApproveManager();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> adminstrativeCosts = new ArrayList<SelectItem>();
//    ArrayList<SelectItem> nameOfInstitution = educationRequestManager.getNAmeOfInstitution();
    ArrayList<SelectItem> educationTypeCatagoryList = educationRequestManager.getprogramCategory();
    ArrayList<SelectItem> educationLevelCatagoryList = educationRequestManager.getEducationLevels();
    ArrayList<SelectItem> educationShiftList = educationRequestManager.getEducationShift();
    ArrayList<SelectItem> educationLevel = educationRequestManager.readEducationLevel(rank);
    // ArrayList<SelectItem> adminstrativeCosts = educationPaymentRequestManager.getAdminstrativeCost();
    ArrayList<EducationPaymentModel> adminstrativeCostLists = new ArrayList<EducationPaymentModel>();
    ArrayList<EducationPaymentModel> courseTakingList = new ArrayList<EducationPaymentModel>();
    private ArrayList<EducationPaymentModel> availableCourses = new ArrayList<EducationPaymentModel>();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationTypeCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationLevelCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationShiftCatagory = new DefaultSelectedData();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    String loggedInEmployeeId;
    String userName;
    int educationPaymentRequestId;
    int educationRequestId = 1;
    String gradePt;
    int numberOfCreditHours;
    int numberOfCourses;
    double costPerCreditHour;
    double adminstrativeCost;
    double totalCost = 0;
    double tutationFee;
    double unitCost;
    double quantity;
    String paymentPreOrPost;
    String gradeBasic;
    String adminstrativeCostType;
    String academicYear;
    String semesterOrTerm;
    String appliedDate;
    String issueDate;
    String paymentDate;
    String documentReferenceNumber;
    String receiptNumber;
    String remark;
    String status;
    String requestStatus;
    String timeStamp;
    String requesterId;//
    String educationProgramName;
    String educationProgramcategory;
    String institutionName;
    String ethiopianInstitution;//inside or outside ethiopia
    String institutionAccredited;//
    String institutionAddress;
    String reasonDescription;
    String courseCode;
    String creditHr;
    float cGPA;
    int adminId;
    int courseID;

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        selectMyHistoryLists.setValue(null);
        educationPaymentRequestId = Integer.parseInt(requestAttributes[0]);
        educationRequestId = Integer.parseInt(requestAttributes[1]);
        requesterId = requestAttributes[2];
        requestStatus = requestAttributes[3];
        appliedDate = requestAttributes[4];

        populateRequesterTextComponents(requesterId);
        populateEducationComponents(educationRequestId);
        populatePaymentRequestTextComponents(educationPaymentRequestId);
        populateRequesterTableComponents(educationRequestId, appliedDate);
        //populateCourseTableComponents(educationRequestId);

        makePageReadyForUpdate();
        nonRenderComponenet();
        selectMyHistoryLists.setValue(null);
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        selectMyHistoryLists.setValue(null);
        educationPaymentRequestId = Integer.parseInt(requestAttributes[0]);
        educationRequestId = Integer.parseInt(requestAttributes[1]);
        requesterId = requestAttributes[2];
        requestStatus = requestAttributes[3];
        appliedDate = requestAttributes[4];
        populateRequesterTextComponents(requesterId);
        populateEducationComponents(educationRequestId);
        populatePaymentRequestTextComponents(educationPaymentRequestId);
        populateRequesterTableComponents(educationRequestId, appliedDate);
        //populateCourseTableComponents(educationRequestId);
        //populateDecisionHistory(educationPaymentRequestId);
        //renderPreviosDescisionLink(requestStatus);

        makePageReadyForView();
        nonRenderComponenet();
        selectMyRequestLists.setValue(null);
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
        if (educationPaymentRequestManager.deleteEducationRequest(educationPaymentRequestId) && educationPaymentRequestManager.deleteAdminstrativeCostRequest(educationRequestId) && educationPaymentRequestManager.deleteCourseRequest(educationRequestId) && educationPaymentRequestManager.deleteBasicLevelRequest(educationRequestId)) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponents();
            pendingRequestList = educationPaymentRequestManager.getPendingRequests();
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
            /*
            double adminstrativeCost, double totalCost, String paymentPreOrPost,
            String academicYear, String semesterOrTerm, String appliedDate, String issueDate,
            String remark, String documentReferenceNumber, String receiptNumber) {
             */
            try {
                educationRequestId = Integer.parseInt(lblEducreqestID.getValue().toString());
                requesterId = txtRequesterId.getValue().toString();
                educationProgramName = txtProgName.getValue().toString();
                institutionName = txtInstitName.getValue().toString();
                appliedDate = txtAppliedDate.getValue().toString();
                unitCost = Double.parseDouble(txtUnitCost.getValue().toString());
                adminstrativeCostType = drlAdminstrativeCost.getValue().toString().split("-")[1];
                totalCost = Double.parseDouble(txttotalCost.getValue().toString());
                remark = txtRemark.getValue().toString();
                status = "New";
                documentReferenceNumber = txtDocumentReferenceNumber.getValue().toString();
                academicYear = txtAcademicYear.getValue().toString();
                semesterOrTerm = txtSemesterOrTerm.getValue().toString();
                issueDate = txtIssueDate.getValue().toString();
                paymentPreOrPost = "PRE";



                return true;
            } catch (NullPointerException npe) {
                showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
                return false;
            } catch (NumberFormatException nfe) {
                showSuccessOrFailureMessage(false, "INVALID NUMBER! PLEASE CHECK ALL YOUR DATA FOR SAVING. <BR>INSERT <>0<> IF NON VALUE");
                return false;
            }
        }
    }

    public boolean isEntryValidForSave() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;


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
        errorValue = HRValidation.validateData(this.txtAcademicYear.getValue(), HRValidation.YEAR_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtAcademicYear).setValid(false);
                error(txtAcademicYear, errorMessage);
            } else {
                ((UIInput) txtAcademicYear).setValid(false);
                error(txtAcademicYear, "Invalid Value");
            }
        }

        errorValue = HRValidation.validateData(this.txtIssueDate.getValue(), HRValidation.DATE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtIssueDate).setValid(false);
                error(txtIssueDate, errorMessage);
            } else {
                ((UIInput) txtIssueDate).setValid(false);
                error(txtIssueDate, "Invalid Value");
            }
        }
        errorValue = HRValidation.validateData(this.txtSemesterOrTerm.getValue(), HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtSemesterOrTerm).setValid(false);
                error(txtSemesterOrTerm, errorMessage);
            } else {
                ((UIInput) txtSemesterOrTerm).setValid(false);
                error(txtSemesterOrTerm, "Invalid Value");
            }
        }
        required = HRValidation.validateRequired(this.txtDocumentReferenceNumber.getValue());
        if (!required) {
            ((UIInput) txtDocumentReferenceNumber).setValid(false);
            error(txtDocumentReferenceNumber, errorMessage);
            results = false;
        }

        required = HRValidation.validateRequired(this.txtRequesterFullName.getValue());
        if (!required) {
            ((UIInput) txtRequesterFullName).setValid(false);
            error(txtRequesterFullName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtRequesterDepartment.getValue());
        if (!required) {
            ((UIInput) txtRequesterDepartment).setValid(false);
            error(txtRequesterDepartment, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtRequesterPosition.getValue());
        if (!required) {
            ((UIInput) txtRequesterPosition).setValid(false);
            error(txtRequesterPosition, errorMessage);
            results = false;
        }
//        required = HRValidation.validateRequired(this.txtlblRequesterEdLevel.getValue());
//        if (!required) {
//            ((UIInput) txtlblRequesterEdLevel).setValid(false);
//            error(txtlblRequesterEdLevel, errorMessage);
//            results = false;
//        }
//        required = HRValidation.validateRequired(this.txtlblRequesterProgramName.getValue());
//        if (!required) {
//            ((UIInput) txtlblRequesterProgramName).setValid(false);
//            error(txtlblRequesterProgramName, errorMessage);
//            results = false;
//        }
        required = HRValidation.validateRequired(this.txtInstitName.getValue());
        if (!required) {
            ((UIInput) txtInstitName).setValid(false);
            error(txtInstitName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtLevel.getValue());
        if (!required) {
            ((UIInput) txtLevel).setValid(false);
            error(txtLevel, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtProgName.getValue());
        if (!required) {
            ((UIInput) txtProgName).setValid(false);
            error(txtProgName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtDocreferenceNum.getValue());
        if (!required) {
            ((UIInput) txtDocreferenceNum).setValid(false);
            error(txtDocreferenceNum, errorMessage);
            results = false;
        }
        return results;
    }

    public String btnSaveOrUpdate_action() {
        if (isEntryValidForSave()) {
            if (validateAndInitializeAttributes()) {

                if (txtGrade.getValue().toString().equalsIgnoreCase("BASIC")) {
                    gradeBasic = txtGrade.getValue().toString();
                    if ((educationPaymentRequestManager.saveEducationRequest(requesterId, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, requestStatus, totalCost)) && (educationPaymentRequestManager.saveEducationAdinstratice(adminstrativeCostLists, appliedDate)) && (educationPaymentRequestManager.saveCourseTakingBasicLevl(requesterId, educationRequestId, gradeBasic, appliedDate))) {
                        showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                        pendingRequestList = educationPaymentRequestManager.getPendingRequests();
                        clearAllComponents();
                        btnSaveOrUpdate.setDisabled(true);
                    } else {
                        showSuccessOrFailureMessage(false, "SAVING FAILED");
                        btnSaveOrUpdate.setDisabled(false);
                    }
                } else {
                    if ((educationPaymentRequestManager.saveEducationRequest(requesterId, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, requestStatus, totalCost)) && (educationPaymentRequestManager.saveEducationAdinstratice(adminstrativeCostLists, appliedDate)) && (educationPaymentRequestManager.saveCourseTaking(courseTakingList, appliedDate))) {
                        showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                        pendingRequestList = educationPaymentRequestManager.getPendingRequests();
                        clearAllComponents();
                        btnSaveOrUpdate.setDisabled(true);
                    } else {
                        showSuccessOrFailureMessage(false, "SAVING FAILED");
                        btnSaveOrUpdate.setDisabled(false);
                    }
                }

            }
        }

        return null;
    }

    public String btnReset_action() {
        clearAllComponents();
        //makePageReadyForSave();
        return null;
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(educationPaymentRequestId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

    public String txttotalCost_action() {
        //return null means stay on the same page
        return null;
    }

    boolean validateAndInitialize() {
        try {
            educationRequestId = Integer.valueOf(lblEducreqestID.getValue().toString());
            adminstrativeCostType = drlAdminstrativeCost.getValue().toString().split("-")[1];
            unitCost = Double.valueOf(txtUnitCost.getValue().toString());

            requesterId = txtRequesterId.getValue().toString();
            //quantity = Double.valueOf(txtAmount.getValue().toString());
            // requesterId = txtRequesterId.getValue().toString();
            totalCost = unitCost;
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
        }
        return true;
    }

    public boolean isEntryValidForAddCOst() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.drlAdminstrativeCost.getValue());
        if (!required) {
            ((UIInput) drlAdminstrativeCost).setValid(false);
            error(drlAdminstrativeCost, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtRequesterId.getValue());
        if (!required) {
            ((UIInput) txtRequesterId).setValid(false);
            error(txtRequesterId, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtInstitName.getValue());
        if (!required) {
            ((UIInput) txtInstitName).setValid(false);
            error(txtInstitName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtLevel.getValue());
        if (!required) {
            ((UIInput) txtLevel).setValid(false);
            error(txtLevel, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtProgName.getValue());
        if (!required) {
            ((UIInput) txtProgName).setValid(false);
            error(txtProgName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtDocreferenceNum.getValue());
        if (!required) {
            ((UIInput) txtDocreferenceNum).setValid(false);
            error(txtDocreferenceNum, errorMessage);
            results = false;
        }
        errorValue = HRValidation.validateData(this.txtUnitCost.getValue(), HRValidation.DOUBLE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtUnitCost).setValid(false);
                error(txtUnitCost, errorMessage);
            } else {
                ((UIInput) txtUnitCost).setValid(false);
                error(txtUnitCost, "Invalid Value");
            }
        }

        return results;
    }

    private boolean checkAdminList() {// checks whether this participant is already in the list
        String posId = drlAdminstrativeCost.getValue().toString().split("-")[1];
        boolean checkAminLists = false;
        Iterator<EducationPaymentModel> ittkmpList = adminstrativeCostLists.iterator();
        while (ittkmpList.hasNext() && !checkAminLists) {
            EducationPaymentModel singlePosIdVal = ittkmpList.next();
            if ((singlePosIdVal.getAdminstraticeCostType().toString().equals(posId))) {
                checkAminLists = true;

            }
        }
        return checkAminLists;
    }

    public String btnAdd_action() {
        //return null means stay on the same page
        if (isEntryValidForAddCOst()) {
            if (!checkAdminList()) {
                if (validateAndInitialize()) {
                    if (checkEnrolled()) {
                        if (!checkPrePaid()) {
                            educationPaymentModel = new EducationPaymentModel(requesterId, unitCost, totalCost, adminstrativeCostType, educationRequestId);
                            adminstrativeCostLists.add(educationPaymentModel);
                            btnCalculate.setRendered(true);
                            btnCalculate.setDisabled(false);
                        } else {
                            showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST FOR PRE PAYMENT BECAUSE PRE PAYMENT IS ALLOWED ONCE");
                        }
                    } else {
                        showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST FOR PRE PAYMENT BECAUSE YOU ARE NOT ENROLLED");
                    }
                }
            } else {
                showSuccessOrFailureMessage(false, "ALREADY INSERTED INTO TABLE");
            }
        }
        return null;
    }

    public boolean checkPrePaid() {
        ArrayList<HashMap> educationPrePaidCheck = new ArrayList<HashMap>();
        educationPrePaidCheck = educationPaymentRequestManager.checkPrePaid(txtRequesterId.getValue().toString(), txtProgName.getValue().toString());
        if (educationPrePaidCheck.size() != 0) {
            return true;
        } else {
            return false;
        }
//        if(educationPrePaidCheck!= null)
//          return true;
//        else
//          return false;
    }

    public boolean checkEnrolled() {
        String educationEnrolledCheck = null;
        educationEnrolledCheck = educationPaymentRequestManager.checkEnrolled(txtRequesterId.getValue().toString(), txtProgName.getValue().toString());
//        String enrolledOrNot = educationEnrolledCheck.toString();
        if (educationEnrolledCheck.equalsIgnoreCase("Enrolled")) {
            return true;
        } else {
            return false;
        }
//        if(educationPrePaidCheck!= null)
//          return true;
//        else
//          return false;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtIssueDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }

//    public void drlEducationTypeCatagory_processValueChange(ValueChangeEvent vce) {
//        educationProgramcategory = vce.getNewValue().toString().split("-")[0];
//        this.setProgramName(educationPaymentRequestManager.getprogramName(educationProgramcategory));
//    }
    public String btnCalculate_action() {
        //return null means stay on the same page
        totalCost = 0;
        Double eachRow;
        for (int i = 0; i < dataAdminstrativeCost.getRowCount(); i++) {
            eachRow = Double.valueOf(getAdminstrativeCostLists().get(i).getTotalCost());
            totalCost += eachRow;
            txttotalCost.setValue(totalCost);
        }
        txttotalCost.setRendered(true);
        lblTutationFee.setRendered(true);
        return null;
    }

    boolean validateAndInitializeCuorse() {
        try {
            educationRequestId = Integer.valueOf(lblEducreqestID.getValue().toString());
            creditHr = txtCreditHour.getValue().toString();
            requesterId = txtRequesterId.getValue().toString();
            semesterOrTerm = txtSemesterOrTerm.getValue().toString();
            courseCode = txtCourseCode.getValue().toString();
            academicYear = txtAcademicYear.getValue().toString();
            institutionName = txtInstitName.getValue().toString();
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
        }
        return true;
    }

    private boolean populatecourse(String employeeId, String courseCode, String instName) {
        HashMap empInfoHashMap = educationPaymentRequestManager.readEmployeeCourseInfo(employeeId, courseCode, instName);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("courseCode").toString().equals(courseCode)) {//if no resultset found
                showSuccessOrFailureMessage(false, "ALREADY REQUESTED WITH:  " + courseCode + " COURSE CODE");
                //getCourseTakingList().clear();
                return false;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
        return true;
    }

    boolean validateSearchCourse() {
        try {
            // boolean checkcouseLists = false;
            requesterId = txtRequesterId.getValue().toString();
            courseCode = txtCourseCode.getValue().toString();
            institutionName = txtInstitName.getValue().toString();
            populatecourse(requesterId, courseCode, institutionName);
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
        }
        return true;
    }

    public boolean isEntryValidForAddCOusre() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtCourseCode.getValue());
        if (!required) {
            ((UIInput) txtCourseCode).setValid(false);
            error(txtCourseCode, errorMessage);
            results = false;
        }
        errorValue = HRValidation.validateData(this.txtCreditHour.getValue(), HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtCreditHour).setValid(false);
                error(txtCreditHour, errorMessage);
            } else {
                ((UIInput) txtCreditHour).setValid(false);
                error(txtCreditHour, "Invalid Value");
            }
        }
        required = HRValidation.validateRequired(this.txtAcademicYear.getValue());
        if (!required) {
            ((UIInput) txtAcademicYear).setValid(false);
            error(txtAcademicYear, errorMessage);
            results = false;
        }
        errorValue = HRValidation.validateData(this.txtSemesterOrTerm.getValue(), HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtSemesterOrTerm).setValid(false);
                error(txtSemesterOrTerm, errorMessage);
            } else {
                ((UIInput) txtSemesterOrTerm).setValid(false);
                error(txtSemesterOrTerm, "Invalid Value");
            }
        }
        return results;
    }

    private boolean checkCourseList() {// checks whether this participant is already in the list
        String posId = txtCourseCode.getValue().toString();
        //String instName = txtInstitName.getValue().toString();

        boolean checkcouseLists = false;
        Iterator<EducationPaymentModel> ittkmpList = courseTakingList.iterator();
        while (ittkmpList.hasNext() && !checkcouseLists) {
            EducationPaymentModel singlePosIdVal = ittkmpList.next();
            if ((singlePosIdVal.getCourseCode().toString().equals(posId))) {//&& (singlePosIdVal.getInstName().toString().equals(instName))) {
                checkcouseLists = true;

            }
        }
        return checkcouseLists;
    }

    public String btnAddCourse_action() {
        if (isEntryValidForAddCOusre()) {
            if (!checkCourseList()) {
                if (validateSearchCourse()) {
                    if (validateAndInitializeCuorse()) {
                        educationPaymentModel = new EducationPaymentModel(requesterId, courseCode, creditHr, semesterOrTerm, educationRequestId, academicYear, institutionName);
                        courseTakingList.add(educationPaymentModel);
                    }
                }
            } else {
                showSuccessOrFailureMessage(false, "ALREADY INSERTED INTO TABLE");
            }
        }
        return null;
    }

    public void drlAdminstrativeCost_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().equals("For Course")) {
            txtCourseCode.setRendered(true);
            txtCreditHour.setRendered(true);
        }

    }

    public void drlInstitutionName_processValueChange(ValueChangeEvent vce) {
    }

    public void drlProgramName_processValueChange(ValueChangeEvent vce) {
    }
    int selectedRow = -1;
    int selectedRowCors = -1;

    public void rowSelectorAdminCost_processMyEvent(RowSelectorEvent rse) {
        int row = dataAdminstrativeCost.getRowIndex();
        selectedRow = rse.getRow();
        adminstrativeCostType = getAdminstrativeCostLists().get(row).getAdminstraticeCostType();
        unitCost = getAdminstrativeCostLists().get(row).getUnitCost();
        quantity = getAdminstrativeCostLists().get(row).getQuantity();
        totalCost = getAdminstrativeCostLists().get(row).getTotalCost();
        drlAdminstrativeCost.setValue(null);
        txtUnitCost.resetValue();
        //txtAmount.resetValue();
        txttotalCost.resetValue();
        drlAdminstrativeCost.setValue(adminstrativeCostType);
        txtUnitCost.setValue(unitCost);
        //txtAmount.setValue(quantity);
        txttotalCost.setValue(totalCost);


    }

    public void rowSelectorCourse_processMyEvent(RowSelectorEvent rse) {
        int row = dataCourse.getRowIndex();
        selectedRowCors = rse.getRow();
        cGPA = getCourseTakingList().get(row).getCumlativeGPA();
        courseCode = getCourseTakingList().get(row).getCourseCode();
        semesterOrTerm = getCourseTakingList().get(row).getSemesterOrTerm();
        creditHr = getCourseTakingList().get(row).getCreditHr();
        // txtCGPA.resetValue();
        txtCourseCode.resetValue();
        txtSemesterOrTerm.resetValue();
        txtCreditHour.resetValue();
        //xtCGPA.setValue(cGPA);
        txtCourseCode.setValue(courseCode);
        txtSemesterOrTerm.setValue(semesterOrTerm);
        txtCreditHour.setValue(creditHr);
    }

    public String lnkInstRegistration_action() {
        // TODO: Replace with your code
        return "InstitutionRegistrationPage";
    }

    public String lnkEducationPaymentApprove_action() {
        // TODO: Replace with your code
        return "EducationPaymentApprove";
    }

    public String lnkChangeInstApprove_action() {
        // TODO: Replace with your code
        return "ChangeInstitutionaPRROVEPage";
    }

    public String btnClosePopupViewPrevieousDecisions_action() {
        // TODO: Replace with your code
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public void calAcadamicYear_processValueChange(ValueChangeEvent vce) {
        txtAcademicYear.setValue(yearFormat.format((Date) vce.getNewValue()));
        calAcadamicYear.setRendered(false);
    }

    public String btnAcadamicYear_action() {
        //return null means stay on the same page
        calAcadamicYear.setRendered(true);
        return null;
    }

    public String btnNew_action() {
        //return null means stay on the same page

        clearAllComponents();
        enableComponents();
        //makePageReadyForSave();
        return null;
    }

    public void panelTabSet_processTabChange(TabChangeEvent tce) {
    }

    private void validtae() {
        checkbox1.isSelected();
    }

    public void chkHigher_processValueChange(ValueChangeEvent vce) {
        if (chkHigher.isSelected()) {
            txtCourseCode.setRendered(true);
            txtCreditHour.setRendered(true);
            lblCourseCode.setRendered(true);
            lblCreditHour.setRendered(true);
            chkBasicLevel.setSelected(false);
            txtGrade.setRendered(false);
            lblGrade.setRendered(false);
            drlBasicLevel.setRendered(false);
        } else {
            txtCourseCode.setRendered(false);
            txtCreditHour.setRendered(false);
            lblCourseCode.setRendered(false);
            lblCreditHour.setRendered(false);
        }
    }

    public void chkBasicLevel_processValueChange(ValueChangeEvent vce) {
        if (chkBasicLevel.isSelected()) {
            rank = 13;
            this.setEducationLevel(educationRequestManager.readEducationLevel(rank));
            chkHigher.setSelected(false);
            txtGrade.setRendered(true);
            lblGrade.setRendered(true);
            drlBasicLevel.setRendered(true);
            getCourseTakingList().clear();
            txtCourseCode.setRendered(false);
            txtCreditHour.setRendered(false);
            lblCourseCode.setRendered(false);
            lblCreditHour.setRendered(false);
        // pnlLayoutButtons2.
        } else {
            txtGrade.setRendered(false);
            lblGrade.setRendered(false);
            drlBasicLevel.setRendered(false);
            pnlLayoutButtons2.setRendered(true);
        }
    }

    public void modalPnlCloseBtn_processAction(ActionEvent ae) {
        pnlPopUpClearingDepSetting1.setRendered(false);
    }

    public void ckboClearing_processValueChange(ValueChangeEvent vce) {
    }

    public String lnkViewCourseLists_action() {
        //return null means stay on the same page

        availableCourses = educationPaymentRequestManager.getAllCourseList(requesterId);
        if (availableCourses.isEmpty()) {
            showSuccessOrFailureMessage(false, "THERE IS NO REGISTERED COURSE!!");
            pnlPopUpClearingDepSetting1.setRendered(false);
        } else {
            pnlPopUpClearingDepSetting1.setRendered(true);
        }
        return null;
    }

    public String btnSearchRequester_action() {

        if (isEntryValidForSearchTerminator()) {
            if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
                requesterId = txtRequesterId.getValue().toString();
                if (!checkEducationalStatus()) {
                    if ((populateRequesterTextComponents(requesterId)) && (populateRequesterDtaeofBirth(requesterId)) && (populateEducationdDrlComponents(requesterId))) {
                        if ((populateAgreemnt(requesterId)) == false) {
                            disableComponents();
                            btnSaveOrUpdate.setDisabled(true);
                            showSuccessOrFailureMessage(false, txtRequesterId.getValue().toString() + "IS NOT SIGNED AN AGREEMENT");

                        } else {
                            enableComponents();
                            btnSaveOrUpdate.setDisabled(false);
                        }
                    } else {
                        showSuccessOrFailureMessage(false, "NO EDUCATION REQUEST  IS FOUND WITH EMPLOYEE ID : " + txtRequesterId.getValue().toString() + "OR THE REQUEST IS NOT APPROVED");
                        requesterId = null;
                        clearAllComponents();

                    }
                }

            } else {
                requesterId = null;
                showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
            }
        }
        return null;
    }
}