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
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;
import javax.faces.component.UIComponent;
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
import manager.educationManager.EducationPostPaymentRequestManager;
import manager.educationManager.EducationRequestManager;
import manager.educationManager.EducationRequestModel;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;
import manager.educationManager.EducationPostPaymentApproveManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EducationPostPaymentRequestPage extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    private String catID;
    private int tableSize;
    private int CourseId;

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
        EducationPostPaymentRequestManager.setUserName(userName);
        EducationPostPaymentRequestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
        requestHistoryList = EducationPostPaymentRequestManager.getMyPossRequestsHistory();
        pendingRequestList = EducationPostPaymentRequestManager.getPendingpOSRequests();
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

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public EducationPostPaymentApproveManager getEducationPostPaymentApproveManager() {
        return educationPostPaymentApproveManager;
    }

    public void setEducationPostPaymentApproveManager(EducationPostPaymentApproveManager educationPostPaymentApproveManager) {
        this.educationPostPaymentApproveManager = educationPostPaymentApproveManager;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getGradeBasic() {
        return gradeBasic;
    }

    public void setGradeBasic(String gradeBasic) {
        this.gradeBasic = gradeBasic;
    }

    public String getResultBaic() {
        return resultBaic;
    }

    public void setResultBaic(String resultBaic) {
        this.resultBaic = resultBaic;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    private HtmlInputText txtCGPA = new HtmlInputText();

    public HtmlInputText getTxtCGPA() {
        return txtCGPA;
    }

    public void setTxtCGPA(HtmlInputText hit) {
        this.txtCGPA = hit;
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
    private HtmlInputText txtgrade = new HtmlInputText();

    public HtmlInputText getTxtgrade() {
        return txtgrade;
    }

    public void setTxtgrade(HtmlInputText hit) {
        this.txtgrade = hit;
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
    private HtmlOutputLabel lblCGPA = new HtmlOutputLabel();

    public HtmlOutputLabel getLblCGPA() {
        return lblCGPA;
    }

    public void setLblCGPA(HtmlOutputLabel hol) {
        this.lblCGPA = hol;
    }
    private HtmlOutputLabel lblGrade = new HtmlOutputLabel();

    public HtmlOutputLabel getLblGrade() {
        return lblGrade;
    }

    public void setLblGrade(HtmlOutputLabel hol) {
        this.lblGrade = hol;
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
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private HtmlCommandLink cmdLnkOk = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkOk() {
        return cmdLnkOk;
    }

    public void setCmdLnkOk(HtmlCommandLink hcl) {
        this.cmdLnkOk = hcl;
    }
    private HtmlCommandLink cmdLnkRemove = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkRemove() {
        return cmdLnkRemove;
    }

    public void setCmdLnkRemove(HtmlCommandLink hcl) {
        this.cmdLnkRemove = hcl;
    }
    private HtmlOutputLabel lblAcademicYear = new HtmlOutputLabel();

    public HtmlOutputLabel getLblAcademicYear() {
        return lblAcademicYear;
    }

    public void setLblAcademicYear(HtmlOutputLabel hol) {
        this.lblAcademicYear = hol;
    }
    private HtmlOutputLabel lblSemesterOrTerm = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSemesterOrTerm() {
        return lblSemesterOrTerm;
    }

    public void setLblSemesterOrTerm(HtmlOutputLabel hol) {
        this.lblSemesterOrTerm = hol;
    }
    private HtmlCommandButton btnClickHere = new HtmlCommandButton();

    public HtmlCommandButton getBtnClickHere() {
        return btnClickHere;
    }

    public void setBtnClickHere(HtmlCommandButton hcb) {
        this.btnClickHere = hcb;
    }
    private HtmlOutputLabel lblOption = new HtmlOutputLabel();

    public HtmlOutputLabel getLblOption() {
        return lblOption;
    }

    public void setLblOption(HtmlOutputLabel hol) {
        this.lblOption = hol;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkPostpay = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkPostpay() {
        return chkPostpay;
    }

    public void setChkPostpay(HtmlSelectBooleanCheckbox hsbc) {
        this.chkPostpay = hsbc;
    }
    private HtmlInputText txtGrade = new HtmlInputText();

    public HtmlInputText getTxtGrade() {
        return txtGrade;
    }

    public void setTxtGrade(HtmlInputText hit) {
        this.txtGrade = hit;
    }
    private PanelLayout pnlLayoutButtons2 = new PanelLayout();

    public PanelLayout getPnlLayoutButtons2() {
        return pnlLayoutButtons2;
    }

    public void setPnlLayoutButtons2(PanelLayout pl) {
        this.pnlLayoutButtons2 = pl;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlResultType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlResultType() {
        return drlResultType;
    }

    public void setDrlResultType(HtmlSelectOneMenu hsom) {
        this.drlResultType = hsom;
    }
    private HtmlOutputLabel lblResult = new HtmlOutputLabel();

    public HtmlOutputLabel getLblResult() {
        return lblResult;
    }

    public void setLblResult(HtmlOutputLabel hol) {
        this.lblResult = hol;
    }
    private HtmlInputText txtScore = new HtmlInputText();

    public HtmlInputText getTxtScore() {
        return txtScore;
    }

    public void setTxtScore(HtmlInputText hit) {
        this.txtScore = hit;
    }
    private HtmlOutputLabel lblScore = new HtmlOutputLabel();

    public HtmlOutputLabel getLblScore() {
        return lblScore;
    }

    public void setLblScore(HtmlOutputLabel hol) {
        this.lblScore = hol;
    }
    private HtmlCommandButton btnCalendarSatartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarSatartDate() {
        return btnCalendarSatartDate;
    }

    public void setBtnCalendarSatartDate(HtmlCommandButton hcb) {
        this.btnCalendarSatartDate = hcb;
    }
    private HtmlOutputLabel lblInstitPrevId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblInstitPrevId() {
        return lblInstitPrevId;
    }

    public void setLblInstitPrevId(HtmlOutputLabel hol) {
        this.lblInstitPrevId = hol;
    }
    private HtmlCommandLink lnkViewCourseLists = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewCourseLists() {
        return lnkViewCourseLists;
    }

    public void setLnkViewCourseLists(HtmlCommandLink hcl) {
        this.lnkViewCourseLists = hcl;
    }
    private PanelPopup pnlPopUpClearingDepSetting1 = new PanelPopup();

    public PanelPopup getPnlPopUpClearingDepSetting1() {
        return pnlPopUpClearingDepSetting1;
    }

    public void setPnlPopUpClearingDepSetting1(PanelPopup pp) {
        this.pnlPopUpClearingDepSetting1 = pp;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EducationPostPaymentRequestPage() {
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

    public EducationPostPaymentRequestManager getEducationPostPaymentRequestManager() {
        return EducationPostPaymentRequestManager;
    }

    public void setEducationPostPaymentRequestManager(EducationPostPaymentRequestManager EducationPostPaymentRequestManager) {
        this.EducationPostPaymentRequestManager = EducationPostPaymentRequestManager;
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

    public String getDataBasestatus() {
        return dataBasestatus;
    }

    public void setDataBasestatus(String dataBasestatus) {
        this.dataBasestatus = dataBasestatus;
    }

    public String getGradePt() {
        return gradePt;
    }

    public void setGradePt(String gradePt) {
        this.gradePt = gradePt;
    }

    public ArrayList<SelectItem> getResultType() {
        return resultType;
    }

    public void setResultType(ArrayList<SelectItem> resultType) {
        this.resultType = resultType;
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

    public ArrayList<EducationPaymentModel> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(ArrayList<EducationPaymentModel> availableCourses) {
        this.availableCourses = availableCourses;
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

    public boolean checkEducationalStatus() {
        //ArrayList<HashMap> educationPrePaidCheck = new ArrayList<HashMap>();
        String empInfoHashMap = educationRequestManager.getEducationalStatus(requesterId);
        if ((empInfoHashMap.equalsIgnoreCase("Dismised")) || (empInfoHashMap.equalsIgnoreCase("Withdrwal")) || (empInfoHashMap.equalsIgnoreCase("Re-Admission"))) {
            showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST THE PAYMENT!! \n THE REQUESTER IS :" + empInfoHashMap);
            return true;
        } else {
            return false;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

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

    public boolean isEntryValidForSearchTerminator() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtRequesterId.getValue());
        if (!required) {
            ((UIInput) txtRequesterId).setValid(false);
            error(txtRequesterId, errorMessage);
            results = false;
        }
        return results;
    }

    public String btnSearchRequester_action() {
        if (isEntryValidForSearchTerminator()) {

            if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
                requesterId = txtRequesterId.getValue().toString();
                if (!checkEducationalStatus()) {
                    if ((populateRequesterTextComponents(requesterId)) && (populateRequesterDtaeofBirth(requesterId)) && (populateEducationdDrlComponents(requesterId))) {
                        if ((populateAgreemnt(requesterId)) == false) {
                            showSuccessOrFailureMessage(false, txtRequesterId.getValue().toString() + "IS NOT SIGNED AN AGREEMENT");
                            disableComponents();
                            btnSaveOrUpdate.setDisabled(true);
                        } else {
                            enableComponents();
                            btnSaveOrUpdate.setDisabled(false);
                        }

                    } else {
                        showSuccessOrFailureMessage(false, "NO EDUCATION REQUEST  IS FOUND WITH EMPLOYEE ID : " + txtRequesterId.getValue().toString() + "OR THE REQUEST IS NOT APPROVED");
                        requesterId = null;
                        clearAllComponents();
                       
                        chkPostpay.setRendered(false);

                    }
                }
            } else {
                requesterId = null;
                showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
            }
        }
        return null;
    }

    private boolean populateRequesterDtaeofBirth(String employeeId) {
        String empInfoHashMap = educationRequestManager.getDateOfBirth(employeeId);
        String hireDate = educationRequestManager.getHIREDATE(employeeId);
             int date = GregorianCalendarManipulation.calaculateYearDifference(empInfoHashMap);
        int expriance = GregorianCalendarManipulation.calaculateYearDifference(hireDate);
        if ((date > 50) || (expriance < 2)) {//if age is gretertahn 50
            showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST THE EDUCATION");
            btnSaveOrUpdate.setDisabled(true);
        } else {
            btnSaveOrUpdate.setDisabled(false);
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

    private boolean populateEducationdDrlComponents(String employeeId) {

        HashMap empInfoHashMap = EducationPostPaymentRequestManager.readEducationInfo(employeeId);
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
                    lblCreditHour.setRendered(false);
                    lblCreditHour.setRendered(false);
                    txtCourseCode.setRendered(false);
                    txtCreditHour.setRendered(false);
                    pnlLayoutButtons2.setRendered(false);
                    txtScore.setRendered(true);
                    lblResult.setRendered(true);
                    drlResultType.setRendered(true);
                    lblScore.setRendered(true);
                    lblCGPA.setRendered(false);
                    txtCGPA.setRendered(false);
                    txtgrade.setRendered(false);
                    lblGrade.setRendered(false);
                    chkPostpay.setRendered(false);
                    lblCourseCode.setRendered(false);
                    chkPostpay.setRendered(false);
                    lblOption.setRendered(false);
                }
                if (txtGrade.getValue().toString().equalsIgnoreCase("HIGH")) {
                    lblCreditHour.setRendered(true);
                    lblCreditHour.setRendered(true);
                    txtCourseCode.setRendered(true);
                    txtCreditHour.setRendered(true);
                    lblCGPA.setRendered(true);
                    txtCGPA.setRendered(true);
                    txtgrade.setRendered(true);
                    lblGrade.setRendered(true);
                    pnlLayoutButtons2.setRendered(true);
                    txtScore.setRendered(false);
                    lblResult.setRendered(false);
                    drlResultType.setRendered(false);
                    lblScore.setRendered(false);
                    chkPostpay.setRendered(true);
                    lblCourseCode.setRendered(true);
                    chkPostpay.setRendered(true);
                    lblOption.setRendered(true);
                    chkPostpay.setDisabled(true);


                }

                if (txtGrade.getValue().toString().equalsIgnoreCase("DRIV")) {
                    lblCreditHour.setRendered(false);
                    pnlLayoutButtons2.setRendered(false);
                    lblCreditHour.setRendered(false);
                    lblCreditHour.setRendered(false);
                    txtCourseCode.setRendered(false);
                    txtCreditHour.setRendered(false);
                    txtScore.setRendered(true);
                    lblResult.setRendered(true);
                    drlResultType.setRendered(true);
                    lblScore.setRendered(true);
                    lblCGPA.setRendered(false);
                    txtCGPA.setRendered(false);
                    txtgrade.setRendered(false);
                    lblGrade.setRendered(false);
                    chkPostpay.setRendered(false);
                    lblCourseCode.setRendered(false);
                    chkPostpay.setRendered(false);
                    lblOption.setRendered(false);
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

    private boolean populatePaymentRequestTextComponents(int requestId) {

        educationPaymentModel = EducationPostPaymentRequestManager.getEducationpOSPaymentRequest(requestId);
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
                txtCGPA.setValue(educationPaymentModel.getCumlativeGPA());

                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateResultComponents(int requestId, String applideDate) {

        educationPaymentModel = EducationPostPaymentRequestManager.getEducationpOSResultRequest(requestId, applideDate);
        if (educationPaymentModel != null) {
            if (educationPaymentModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {

                drlResultType.setValue(educationPaymentModel.getResultBasic());
                txtScore.setValue(educationPaymentModel.getScore());
                txtIssueDate.setValue(educationPaymentModel.getIssueDate());
                txtDocumentReferenceNumber.setValue(educationPaymentModel.getDocumentReferenceNumber());
                txtReciptNumber.setValue(educationPaymentModel.getReceiptNumber());
                txtSemesterOrTerm.setValue(educationPaymentModel.getSemesterOrTerm());
                txtAcademicYear.setValue(educationPaymentModel.getAcademicYear());
                txtRemark.setValue(educationPaymentModel.getRemark());
                txtCGPA.setValue(educationPaymentModel.getCumlativeGPA());

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
                    txtScore.setRendered(false);
                    lblScore.setRendered(false);
                    lblResult.setRendered(false);
                    drlResultType.setRendered(false);
                } else {
                    populateResultComponents(educationRequestId, appliedDate);
                    pnlLayoutButtons2.setRendered(false);
                    txtCourseCode.setRendered(false);
                    txtCreditHour.setRendered(false);
                    txtScore.setRendered(true);
                    lblScore.setRendered(true);
                    lblResult.setRendered(true);
                    drlResultType.setRendered(true);
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

        ArrayList<HashMap> empInfoHashMap = EducationPostPaymentRequestManager.getTableInfo(educatRequestId, date);

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
      
        ArrayList<HashMap> empInfoHashMap = EducationPostPaymentRequestManager.getCourseInfo(educatRequestId, date);
        if (empInfoHashMap != null) {
            tableSize = 0;
            getCourseTakingList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                educationRequestId = educatRequestId;
                requesterId = hmTc.get("REQUESTER_ID").toString();
                courseCode = hmTc.get("COURSE_CODE").toString();
                creditHr = hmTc.get("CREDIT_HOUR").toString();
                semesterOrTerm = hmTc.get("SEMISTER").toString();
                cGPA = Float.valueOf(hmTc.get("CGPA").toString());
                courseID = Integer.valueOf(hmTc.get("ID").toString());
                gradePt = hmTc.get("GRADE_PT").toString();
                academicYear = hmTc.get("ACADAMIC_YEAR").toString();
                status = hmTc.get("STATUS").toString();
                courseTakingList.add(new EducationPaymentModel(requesterId, courseCode, creditHr, semesterOrTerm, cGPA, educationRequestId, gradePt, academicYear, courseID, status));
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

    private boolean populateCourseForPost(String acadamicYear, String semister, String requesterIds) {
      
        ArrayList<HashMap> educationPaymentModell = EducationPostPaymentRequestManager.getAllActiveCommittees(acadamicYear, semister, requesterIds);
        if (educationPaymentModell != null) {
            tableSize = 0;
            getCourseTakingList().clear();
            for (HashMap hmTc : educationPaymentModell) {
                educationRequestId = Integer.valueOf(hmTc.get("EDUC_REQ_ID").toString());
                academicYear = acadamicYear;
                requesterId = requesterIds;
                courseCode = hmTc.get("COURSE_CODE").toString();
                creditHr = hmTc.get("CREDIT_HOUR").toString();
                semesterOrTerm = semister;
                courseID = Integer.valueOf(hmTc.get("ID").toString());
                gradePt = hmTc.get("GRADE_PT").toString();
                cGPA = Float.valueOf(hmTc.get("CGPA").toString());
                dataBasestatus = "OLD";
                institutionName = hmTc.get("INSTITUTION_NAME").toString();
                courseTakingList.add(new EducationPaymentModel(requesterId, courseCode, creditHr, semesterOrTerm, cGPA, educationRequestId, gradePt, academicYear, courseID, dataBasestatus, institutionName));
                tableSize++;
            }
            return true;
        } else {
            showSuccessOrFailureMessage(false, "THERE IS NO COURSE RIGESTERD WITH THIS ACADANICYAER, SEMISTER AND REQUESTER ID");
            requesterId = null;
            academicYear = null;
            semesterOrTerm = null;
            dataBasestatus = "New";
            return false;
        }
    }

    private void clearRequesterTextComponents() {

        txtRequesterDepartment.setValue(null);
        txtRequesterPosition.setValue(null);
        txtlblRequesterEdLevel.setValue(null);
        txtlblRequesterProgramName.setValue(null);
    }

    private void clearAllComponents() {
        clearEducationComponents();
        clearRequestComponents();
        clearRequesterTextComponents();
        clearDropDownItems();
    // makePageReadyForUpdate();
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
        txtReciptNumber.setDisabled(false);
        txtCGPA.setDisabled(false);
        txtSemesterOrTerm.setDisabled(false);
       
        txtCourseCode.setDisabled(false);
        txtCreditHour.setDisabled(false);
        btnAdd.setDisabled(false);
        btnAddCourse.setDisabled(false);
        btnAcadamicYear.setDisabled(false);
        btnCalendarSatartDate.setDisabled(false);
        drlResultType.setDisabled(false);
        txtScore.setDisabled(false);


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
        txtCGPA.setDisabled(true);
        txtSemesterOrTerm.setDisabled(true);
        txtCourseCode.setDisabled(true);
        txtCreditHour.setDisabled(true);
        btnAdd.setDisabled(true);
        btnAddCourse.setDisabled(true);
        btnAcadamicYear.setDisabled(true);
        btnCalendarSatartDate.setDisabled(true);
        drlResultType.setDisabled(true);
        txtScore.setDisabled(true);

    }

    private void clearDropDownItems() {
        selectedRequestFromMyRequestList = new DefaultSelectedData();
        selectedRequestFromHistoryList.setSelectedObject(null);
        selectObjectOfEducationTypeCatagory.setSelectedObject(null);
        selectObjectOfEducationLevelCatagory.setSelectedObject(null);
        selectObjectOfEducationShiftCatagory.setSelectedObject(null);
        drlAdminstrativeCost.setValue("0");
        drlResultType.setValue(null);

    }

    public void nonRenderComponenet() {
        drlAdminstrativeCost.setRendered(false);
       
        txtUnitCost.setRendered(false);
        txtCGPA.setRendered(false);
        txtCourseCode.setRendered(false);
        txtCreditHour.setRendered(false);
        txtgrade.setRendered(false);
        lblCGPA.setRendered(false);
        lblCourseCode.setRendered(false);
        lblCreditHour.setRendered(false);
        lblGrade.setRendered(false);
       
        lblUnitCost.setRendered(false);
        lblAdminstrativeCost.setRendered(false);
        txtAcademicYear.setRendered(false);
        txtSemesterOrTerm.setRendered(false);
        lblAcademicYear.setRendered(false);
        lblSemesterOrTerm.setRendered(false);
       
        btnAcadamicYear.setRendered(false);
        chkPostpay.setRendered(false);

    }

    public void renderComponenet() {
        drlAdminstrativeCost.setRendered(true);
        txtUnitCost.setRendered(true);
        txtCGPA.setRendered(true);
        txtCourseCode.setRendered(true);
        txtCreditHour.setRendered(true);
        txtgrade.setRendered(true);
        lblCGPA.setRendered(true);
        lblCourseCode.setRendered(true);
        lblCreditHour.setRendered(true);
        lblGrade.setRendered(true);
        lblUnitCost.setRendered(true);
        lblAdminstrativeCost.setRendered(true);
        lblTutationFee.setRendered(false);
        txttotalCost.setRendered(false);
        txtAcademicYear.setRendered(true);
        txtSemesterOrTerm.setRendered(true);
        lblAcademicYear.setRendered(true);
        lblSemesterOrTerm.setRendered(true);
        lblOption.setRendered(true);
        btnAcadamicYear.setRendered(true);
        chkPostpay.setRendered(true);
        

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
        txtCGPA.resetValue();
        txtSemesterOrTerm.resetValue();
        getAdminstrativeCostLists().clear();
        getCourseTakingList().clear();
        txtScore.setValue(null);
        drlResultType.setValue(null);
        txtGrade.setValue(null);
        txtDocreferenceNum.setValue(null);
       
        txtgrade.setValue(null);

    }

    private void makePageReadyForSave() {
        clearAllComponents();
        newOrEditOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(false);
    }

    private void makePageReadyForUpdate() {
        enableComponents();
        newOrEditOrUpdateLabel = "Update";
        btnDelete.setDisabled(false);
        btnSaveOrUpdate.setDisabled(false);
   
    }

    private void makePageReadyForView() {
        disableComponents();
        newOrEditOrUpdateLabel = "Save";
        btnDelete.setDisabled(true);
        btnSaveOrUpdate.setDisabled(true);
        lnkViewPrevieousDecisions.setRendered(true);
       
        lblOption.setRendered(false);
        chkPostpay.setRendered(false);
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
        decisionsMadeOnRequestList = educationPostPaymentApproveManager.getRequestHistory(requestId);

    }

    // </editor-fold>
    // </editor-fold >
    // </editor-fold >
    EmployeeManage employeeManager = new EmployeeManage();
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationPaymentModel educationPaymentModel = new EducationPaymentModel();
    EducationRequestManager educationRequestManager = new EducationRequestManager();
    EducationPostPaymentRequestManager EducationPostPaymentRequestManager = new EducationPostPaymentRequestManager();
    EducationPaymentRequestManager educationPaymentRequestManager = new EducationPaymentRequestManager();
    EducationPaymentApproveManager educationPaymentApproveManager = new EducationPaymentApproveManager();
    EducationPostPaymentApproveManager educationPostPaymentApproveManager = new EducationPostPaymentApproveManager();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    //ArrayList<SelectItem> nameOfInstitution = educationRequestManager.getNAmeOfInstitution();
    ArrayList<SelectItem> educationTypeCatagoryList = educationRequestManager.getprogramCategory();
    ArrayList<SelectItem> educationLevelCatagoryList = educationRequestManager.getEducationLevels();
    ArrayList<SelectItem> educationShiftList = educationRequestManager.getEducationShift();
    ArrayList<SelectItem> resultType = EducationPostPaymentRequestManager.getResultType();
    ArrayList<SelectItem> adminstrativeCosts = EducationPostPaymentRequestManager.getAdminstrativeCost();
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
    String dataBasestatus;
    int numberOfCreditHours;
    int numberOfCourses;
    double costPerCreditHour;
    double adminstrativeCost;
    double totalCost = 0;
    double tutationFee;
    double unitCost;
    double quantity;
    String gradeBasic;
    double score;
    String educationalLevel;
    String resultBaic;
    String paymentPreOrPost;
    String adminstrativeCostType;
    String academicYear;
    String semesterOrTerm;
    String appliedDate;
    String issueDate;
    String paymentDate;
    String documentReferenceNumber;
    String receiptNumber;
    String remark;
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
    String status;

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        educationPaymentRequestId = Integer.parseInt(requestAttributes[0]);
        educationRequestId = Integer.parseInt(requestAttributes[1]);
        requesterId = requestAttributes[2];
        requestStatus = requestAttributes[3];
        appliedDate = requestAttributes[4];
        populateRequesterTextComponents(requesterId);
        populateEducationComponents(educationRequestId);
        populatePaymentRequestTextComponents(educationPaymentRequestId);
        populateRequesterTableComponents(educationRequestId, appliedDate);
        populateCourseTableComponents(educationRequestId, appliedDate);
       
        chkPostpay.setRendered(false);
        lblOption.setRendered(false);
        btnClickHere.setRendered(false);
        makePageReadyForUpdate();
        nonRenderComponenet();
        selectMyRequestLists.setValue(null);
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        educationPaymentRequestId = Integer.parseInt(requestAttributes[0]);
        educationRequestId = Integer.parseInt(requestAttributes[1]);
        requesterId = requestAttributes[2];
        requestStatus = requestAttributes[3];
        appliedDate = requestAttributes[4];
        populateRequesterTextComponents(requesterId);
        populateEducationComponents(educationRequestId);
        populatePaymentRequestTextComponents(educationPaymentRequestId);
        populateRequesterTableComponents(educationRequestId, appliedDate);
        populateCourseTableComponents(educationRequestId, appliedDate);
        makePageReadyForView();
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
        if (EducationPostPaymentRequestManager.deleteEducationRequest(educationPaymentRequestId) && EducationPostPaymentRequestManager.deleteAdminstrativeCostRequest(educationRequestId) && EducationPostPaymentRequestManager.deleteCourseRequest(educationRequestId) && EducationPostPaymentRequestManager.deleteBasicLevelRequest(educationRequestId)) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponents();
            pendingRequestList = EducationPostPaymentRequestManager.getPendingRequests();
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
                receiptNumber = txtReciptNumber.getValue().toString();
                documentReferenceNumber = txtDocumentReferenceNumber.getValue().toString();
                academicYear = txtAcademicYear.getValue().toString();
                semesterOrTerm = txtSemesterOrTerm.getValue().toString();
                issueDate = txtIssueDate.getValue().toString();
                paymentPreOrPost = "POST";
                educationalLevel = txtLevel.getValue().toString();
                // cGPA = Float.valueOf(txtCGPA.getValue().toString());
                if (cGPA < 2.0) {
                    showSuccessOrFailureMessage(false, "YOU CAN'T REQUEST PAYMENT BECAUSE YUOR GRADE IS LESS TAHN 2.0");
                }
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
       
        required = HRValidation.validateRequired(this.txtReciptNumber.getValue());
        if (!required) {
            ((UIInput) txtReciptNumber).setValid(false);
            error(txtReciptNumber, errorMessage);
            results = false;
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
        required = HRValidation.validateRequired(this.txtlblRequesterEdLevel.getValue());
        if (!required) {
            ((UIInput) txtlblRequesterEdLevel).setValid(false);
            error(txtlblRequesterEdLevel, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtlblRequesterProgramName.getValue());
        if (!required) {
            ((UIInput) txtlblRequesterProgramName).setValid(false);
            error(txtlblRequesterProgramName, errorMessage);
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
        return results;
    }

    public boolean isEntryValidForResultBAsic() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtScore.getValue());
        if (!required) {
            ((UIInput) txtScore).setValid(false);
            error(txtScore, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.drlResultType.getValue());
        if (!required) {
            ((UIInput) drlResultType).setValid(false);
            error(drlResultType, errorMessage);
            results = false;
        }
        return results;
    }

    public String btnSaveOrUpdate_action() {
        if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
            if (isEntryValidForSave()) {
                if (validateAndInitializeAttributes()) {

                    if (cGPA < 2) {
                        showSuccessOrFailureMessage(false, "YOU CAN'T REQUEST PAYMENT BECAUSE YUOR GRADE IS LESS TAHN 2.0");
                    }
                    if (txtGrade.getValue().toString().equalsIgnoreCase("BASIC")) {
                        if (isEntryValidForResultBAsic()) {
                            gradeBasic = txtGrade.getValue().toString();
                            resultBaic = drlResultType.getValue().toString();
                            score = Double.valueOf(txtScore.getValue().toString());
                            if (((EducationPostPaymentRequestManager.saveEducationPosRequest(requesterId, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, requestStatus, totalCost))) && (EducationPostPaymentRequestManager.saveEducationAdinstratice(adminstrativeCostLists, appliedDate)) && (EducationPostPaymentRequestManager.saveCourseTakingBasicLevl(requesterId, educationRequestId, educationalLevel, resultBaic, score, appliedDate))) {
                                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                                pendingRequestList = EducationPostPaymentRequestManager.getPendingRequests();
                                clearAllComponents();
                                btnSaveOrUpdate.setDisabled(true);
                            } else {
                                showSuccessOrFailureMessage(false, "SAVING FAILED");
                                btnSaveOrUpdate.setDisabled(false);
                            }
                        }
                    } else {
                        if (((EducationPostPaymentRequestManager.saveEducationPosRequest(requesterId, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, requestStatus, totalCost))) && (EducationPostPaymentRequestManager.saveEducationAdinstratice(adminstrativeCostLists, appliedDate)) && (EducationPostPaymentRequestManager.saveCourseTaking(courseTakingList, appliedDate))) {
                            showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                            pendingRequestList = EducationPostPaymentRequestManager.getPendingRequests();
                            clearAllComponents();
                            btnSaveOrUpdate.setDisabled(true);
                        } else {
                            showSuccessOrFailureMessage(false, "SAVING FAILED");
                            btnSaveOrUpdate.setDisabled(false);
                        }
                    }
                }
            }
        } else {
            if ((EducationPostPaymentRequestManager.saveCourseTaking(courseTakingList, appliedDate))) {//(EducationPostPaymentRequestManager.updateEducationPosRequest(educationPaymentRequestId, educationRequestId, paymentPreOrPost, academicYear, semesterOrTerm, appliedDate, issueDate, remark, documentReferenceNumber, receiptNumber, totalCost, cGPA, requestStatus)) && (EducationPostPaymentRequestManager.UpdateEducationAdinstratice(adminstrativeCostLists, adminId)) && (EducationPostPaymentRequestManager.UpdaeteCourseTaking(courseTakingList, courseID))) {
                showSuccessOrFailureMessage(true, "UPDATING SUCCESSFUL");
                clearAllComponents();
                btnSaveOrUpdate.setDisabled(true);
            } else {
                showSuccessOrFailureMessage(false, "UPDATING FAILED");
                btnSaveOrUpdate.setDisabled(false);
            }
        }


        return null;
    }
//

    public String btnReset_action() {
        clearAllComponents();
        makePageReadyForSave();
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
            requesterId = txtRequesterId.getValue().toString();
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
                    if (!checkPrePaid()) {
                        // if (!checkPrePaidReceipt()) {
                        if (!checkPostPaid()) {
                            if (checkEnrolled()) {
                                educationPaymentModel = new EducationPaymentModel(requesterId, unitCost, totalCost, adminstrativeCostType, educationRequestId);
                                adminstrativeCostLists.add(educationPaymentModel);

                                btnCalculate.setRendered(true);
                                btnCalculate.setDisabled(false);
                            } else {
                                showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST FOR POST PAYMENT BECAUSE YOU ARE NOT ENROLLED");
                            }
                        } else {
                            showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST FOR POST PAYMENT BECAUSE YOU HAVE ALREADY TAKEN POST PAYMENT");
                        }
//                        } else {
//                            showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST FOR POST PAYMENT BECAUSE YOU DID NOT BRING RECEIPT FOR PRE PAYMENT");
//                        }
                    } else {
                        showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST FOR POST PAYMENT BECAUSE YOU HAVE ALREADY TAKEN PRE PAYMENT");
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
        educationPrePaidCheck = EducationPostPaymentRequestManager.checkPrePaid(txtAcademicYear.getValue().toString(), txtSemesterOrTerm.getValue().toString(), requesterId);
        if (educationPrePaidCheck.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPostPaid() {
        ArrayList<HashMap> educationPostPaidCheck = new ArrayList<HashMap>();
        educationPostPaidCheck = EducationPostPaymentRequestManager.checkPostPaid(txtAcademicYear.getValue().toString(), txtSemesterOrTerm.getValue().toString(), requesterId);
        if (educationPostPaidCheck.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPrePaidReceipt() {
//        ArrayList<String> educationPrePaidReceiptCheck = new ArrayList<String>();
        String educationPrePaidReceiptCheck = null;
        String educationPrePaidCheck = null;
        educationPrePaidCheck = EducationPostPaymentRequestManager.checkPrePaid(educationRequestId);

        educationPrePaidReceiptCheck = EducationPostPaymentRequestManager.checkPrePaidReceipt(requesterId);

        if (educationPrePaidCheck.isEmpty()) {
            return false;
        } else if (educationPrePaidReceiptCheck.equalsIgnoreCase("null")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEnrolled() {
        String educationEnrolledCheck = null;
        educationEnrolledCheck = EducationPostPaymentRequestManager.checkEnrolled(txtRequesterId.getValue().toString(), txtProgName.getValue().toString());
        String enrolledOrNot = educationEnrolledCheck.toString();
        if (enrolledOrNot.equalsIgnoreCase("Enrolled")) {
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
//        this.setProgramName(EducationPostPaymentRequestManager.getprogramName(educationProgramcategory));
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
            cGPA = Float.valueOf(txtCGPA.getValue().toString());
            gradePt = txtgrade.getValue().toString();
            academicYear = txtAcademicYear.getValue().toString();
            dataBasestatus = "New";
            institutionName = txtInstitName.getValue().toString();
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
        }
        return true;
    }

    private boolean populatecourse(String employeeId, String courseCode) {
        HashMap empInfoHashMap = EducationPostPaymentRequestManager.readEmployeeCourseInfo(employeeId, courseCode);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("courseCode").toString().equals(courseCode)) {
                btnSaveOrUpdate.setDisabled(true);
                showSuccessOrFailureMessage(false, "ALREADY REQUESTED WITH:  " + courseCode + " COURSE CODE");
                // requesterId = null;
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
            requesterId = txtRequesterId.getValue().toString();
            courseCode = txtCourseCode.getValue().toString();

            populatecourse(requesterId, courseCode);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
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
        errorValue = HRValidation.validateData(this.txtgrade.getValue(), HRValidation.GRADE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtgrade).setValid(false);
                error(txtgrade, errorMessage);
            } else {
                ((UIInput) txtgrade).setValid(false);
                error(txtgrade, "Invalid Value");
            }
        }
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
//        required = HRValidation.validateRequired(this.txtgrade.getValue());
//        if (!required) {
//            ((UIInput) txtSemesterOrTerm).setValid(false);
//            error(txtSemesterOrTerm, errorMessage);
//            results = false;
//        }
        return results;
    }

    private boolean checkCourseList() {// checks whether this participant is already in the list
        String posId = txtCourseCode.getValue().toString();
        String instName = txtInstitName.getValue().toString();

        boolean checkcouseLists = false;
        Iterator<EducationPaymentModel> ittkmpList = courseTakingList.iterator();
        while (ittkmpList.hasNext() && !checkcouseLists) {
            EducationPaymentModel singlePosIdVal = ittkmpList.next();
            if ((singlePosIdVal.getCourseCode().toString().equals(posId)) && (singlePosIdVal.getInstName().toString().equals(instName))) {
                checkcouseLists = true;

            }
        }
        return checkcouseLists;
    }

    public String btnAddCourse_action() {

        if (isEntryValidForAddCOusre()) {
            if (!checkCourseList()) {
                if (validateAndInitializeCuorse()) {
                    if (validateSearchCourse()) {
                        if (cGPA < 2) {
                            showSuccessOrFailureMessage(false, "YOU CAN'T REQUEST PAYMENT BECAUSE YUOR GRADE IS LESS TAHN: 2:00 OR YOUR GRADE IS " + cGPA);

                        } else {
                            status = "New";
                            btnSaveOrUpdate.setDisabled(false);
                            educationPaymentModel = new EducationPaymentModel(requesterId, courseCode, creditHr, semesterOrTerm, cGPA, educationRequestId, gradePt, academicYear, courseID, status, institutionName, appliedDate);
                            courseTakingList.add(educationPaymentModel);
                        }
                    }
                }
            }
        }
//            else {
//            showSuccessOrFailureMessage(false, "ALREADY INSERTED INTO TABLE");
//        }

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
//        int row = dataCourse.getRowIndex();
//        selectedRowCors = rse.getRow();
//        cGPA = getCourseTakingList().get(row).getCumlativeGPA();
//        courseCode = getCourseTakingList().get(row).getCourseCode();
//        semesterOrTerm = getCourseTakingList().get(row).getSemesterOrTerm();
//        creditHr = getCourseTakingList().get(row).getCreditHr();
//        gradePt = getCourseTakingList().get(row).getGradept();
//        courseID = getCourseTakingList().get(row).getCourseId();
//        txtCGPA.resetValue();
//        txtCourseCode.resetValue();
//        txtSemesterOrTerm.resetValue();
//        txtCreditHour.resetValue();
//        txtgrade.resetValue();
//        txtCGPA.setValue(cGPA);
//        txtCourseCode.setValue(courseCode);
//        txtSemesterOrTerm.setValue(semesterOrTerm);
//        txtCreditHour.setValue(creditHr);
//        txtgrade.setValue(gradePt);

        if (selectedRowCors != rse.getRow()) {//when new row selected
            selectedRowCors = rse.getRow();
        } else {//keep it selected
            courseTakingList.get(selectedRowCors).setSelected(true);
        }

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
        // renderComponenet();
        clearAllComponents();
        //enableComponents();
        return null;
    }

    public void panelTabSet_processTabChange(TabChangeEvent tce) {
    }

    public void chkCourses_processValueChange(ValueChangeEvent vce) {
        if ((txtAcademicYear.getValue() != null && !txtAcademicYear.getValue().toString().equals("")) && (txtSemesterOrTerm.getValue() != null && !txtSemesterOrTerm.getValue().toString().equals(""))) {
            academicYear = txtRequesterId.getValue().toString();
            semesterOrTerm = txtSemesterOrTerm.getValue().toString();
            requesterId = txtRequesterId.getValue().toString();
            if (populateCourseForPost(academicYear, semesterOrTerm, requesterId)) {
            } else {
                showSuccessOrFailureMessage(false, "NO COURSE LIST IS FOUND WITH THIS ACADAMIC YEAR OR SEMISTER ");
                academicYear = null;
                semesterOrTerm = null;
                clearAllComponents();
            }
        } else {
            academicYear = null;
            semesterOrTerm = null;
            showSuccessOrFailureMessage(false, "ACADAMIC YEAR OR SEMISTER IS NOT FIELD");
        }

    }

    public String btnAddCourse1_action() {
        //return null means stay on the same page
        if ((txtAcademicYear.getValue() != null && !txtAcademicYear.getValue().toString().equals("")) && (txtSemesterOrTerm.getValue() != null && !txtSemesterOrTerm.getValue().toString().equals("")) && (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals(""))) {
            academicYear = txtAcademicYear.getValue().toString();
            semesterOrTerm = txtSemesterOrTerm.getValue().toString();
            requesterId = txtRequesterId.getValue().toString();
            if ((populateCourseForPost(academicYear, semesterOrTerm, requesterId))) {
                txtCGPA.setRendered(false);
                txtCourseCode.setRendered(false);
                txtCreditHour.setRendered(false);
                txtgrade.setRendered(false);
                lblCGPA.setRendered(false);
                lblCourseCode.setRendered(false);
                lblCreditHour.setRendered(false);
                lblGrade.setRendered(false);
                btnAddCourse.setRendered(false);

            } else {
                showSuccessOrFailureMessage(false, "NO COURSE LIST IS FOUND WITH THIS ACADAMIC YEAR OR SEMISTER ");
                academicYear = null;
                semesterOrTerm = null;
                requesterId = null;
                dataBasestatus = "New";
                clearAllComponents();

            }
        } else {
            academicYear = null;
            semesterOrTerm = null;
            requesterId = null;
            showSuccessOrFailureMessage(false, "ACADAMIC YEAR , SEMISTER OR REQUESTER ID IS NOT FIELD");
        }

        return null;
    }

    public String cmdLnkOk_action() {
        if (courseTakingList.get(selectedRowCors).getCumlativeGPA() < 2) {
            showSuccessOrFailureMessage(false, "YOU CAN'T REQUEST BECAUSE YOUR GRADE POINT IS LESS TAHN TWO");
            btnSaveOrUpdate.setDisabled(true);
        } else if (selectedRowCors != -1) {
            courseTakingList.get(selectedRowCors).setSelected(false);
            if (courseTakingList.get(selectedRowCors).getDatabaseStatus().equalsIgnoreCase("New")) {
            } else {
                courseTakingList.get(selectedRowCors).setDatabaseStatus("Edited");
            }
            selectedRowCors = -1;
        }

        return null;
    }

    public String cmdLnkRemove_action() {
        if (selectedRowCors != -1) {
            if (courseTakingList.get(selectedRowCors).getDatabaseStatus().equalsIgnoreCase("New")) {//new
                courseTakingList.remove(selectedRowCors);
            } else {//if it is inserted now remove it
                courseTakingList.get(selectedRowCors).setDatabaseStatus("Deleted");

            }
            selectedRowCors = -1;
        }
        return null;
    }

    public void chkPostpay_validate(FacesContext context, UIComponent component, Object value) {
    }

    public void chkPostpay_processValueChange(ValueChangeEvent vce) {
        if (chkPostpay.isSelected()) {
            btnClickHere.setRendered(true);
        //chkPostpay.setRendered(false);
        //lblOption.setRendered(true);
        } else {
            btnClickHere.setRendered(false);
            chkPostpay.setRendered(true);
        }
    }

   

    public boolean isEntryValidForCkickHer() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
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
        required = HRValidation.validateRequired(this.txtRequesterId.getValue());
        if (!required) {
            ((UIInput) txtRequesterId).setValid(false);
            error(txtRequesterId, errorMessage);
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

    public String btnClickHere_action() {
        //return null means stay on the same page
        if (isEntryValidForCkickHer()) {
            academicYear = txtAcademicYear.getValue().toString();
            semesterOrTerm = txtSemesterOrTerm.getValue().toString();
            requesterId = txtRequesterId.getValue().toString();
            populateCourseForPost(academicYear, semesterOrTerm, requesterId);
        }
        return null;
    }

    public void drlResultType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().equals("FAIL")) {
            btnSaveOrUpdate.setDisabled(true);
            showSuccessOrFailureMessage(false, "YOUR RESULT IS FAIL, SO YOU CAN NOT REQUEST THE PAYMENT!!");
        } else {
            btnSaveOrUpdate.setDisabled(false);
        }
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

    public void modalPnlCloseBtn_processAction(ActionEvent ae) {
    }

    public String modalPnlCloseBtn1_action() {
        //return null means stay on the same page
        pnlPopUpClearingDepSetting1.setRendered(false);
        return null;
    }

    public void btnSearchRequester_processAction(ActionEvent ae) {
    }
}
