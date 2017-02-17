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
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
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
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import com.sun.webui.jsf.model.Option;
import javax.faces.component.UIInput;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.educationManager.EducationPostPaymentApproveManager;
import manager.educationManager.EducationPaymentModel;
import manager.educationManager.EducationPaymentRequestManager;
import manager.educationManager.EducationPostPaymentRequestManager;
import manager.educationManager.EducationRequestManager;
import manager.educationManager.EducationRequestModel;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EducationPostPaymentApprovePage extends AbstractPageBean {

    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    private int tableSize;
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
        educationOPostPaymentRequestManager.setUserName(userName);
        educationPostPaymentApproveManager.setUserName(userName);
        populateApproverTextComponents(loggedInEmployeeId);
        educationPostPaymentApproveManager.setLoggedInEmployeeId(loggedInEmployeeId);
        requestListsToBeApproved = educationPostPaymentApproveManager.getRequestsToBeProcessed();
        requestHistoryList = educationPostPaymentApproveManager.getMyDecisionsOnRequests();
        availableDecisionsToMakeList = educationPostPaymentApproveManager.getAvailableDecisionsToMake(requestStatus);
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
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
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
    private HtmlInputText txtEducationProgramName = new HtmlInputText();

    public HtmlInputText getTxtEducationProgramName() {
        return txtEducationProgramName;
    }

    public void setTxtEducationProgramName(HtmlInputText hit) {
        this.txtEducationProgramName = hit;
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

    public ArrayList<SelectItem> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<SelectItem> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
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

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
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
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlInputText txtDeciderPosition = new HtmlInputText();

    public HtmlInputText getTxtDeciderPosition() {
        return txtDeciderPosition;
    }

    public void setTxtDeciderPosition(HtmlInputText hit) {
        this.txtDeciderPosition = hit;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputText txtEducationLevel = new HtmlInputText();

    public HtmlInputText getTxtEducationLevel() {
        return txtEducationLevel;
    }

    public void setTxtEducationLevel(HtmlInputText hit) {
        this.txtEducationLevel = hit;
    }

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }
    private HtmlDataTable dataAdminstrativeCost = new HtmlDataTable();

    public HtmlDataTable getDataAdminstrativeCost() {
        return dataAdminstrativeCost;
    }

    public void setDataAdminstrativeCost(HtmlDataTable hdt) {
        this.dataAdminstrativeCost = hdt;
    }
    private HtmlDataTable dataCourse = new HtmlDataTable();

    public HtmlDataTable getDataCourse() {
        return dataCourse;
    }

    public void setDataCourse(HtmlDataTable hdt) {
        this.dataCourse = hdt;
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
    private HtmlInputText txtInstitutionName = new HtmlInputText();

    public HtmlInputText getTxtInstitutionName() {
        return txtInstitutionName;
    }

    public void setTxtInstitutionName(HtmlInputText hit) {
        this.txtInstitutionName = hit;
    }
    private HtmlInputText txtCGPA = new HtmlInputText();

    public HtmlInputText getTxtCGPA() {
        return txtCGPA;
    }

    public void setTxtCGPA(HtmlInputText hit) {
        this.txtCGPA = hit;
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
    private HtmlInputText txtRequesterFullName = new HtmlInputText();

    public HtmlInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(HtmlInputText hit) {
        this.txtRequesterFullName = hit;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox checkbox1 = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1 = hsbc;
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
    private HtmlInputText txtDocreferenceNum = new HtmlInputText();

    public HtmlInputText getTxtDocreferenceNum() {
        return txtDocreferenceNum;
    }

    public void setTxtDocreferenceNum(HtmlInputText hit) {
        this.txtDocreferenceNum = hit;
    }
    private HtmlInputText txtGrade = new HtmlInputText();

    public HtmlInputText getTxtGrade() {
        return txtGrade;
    }

    public void setTxtGrade(HtmlInputText hit) {
        this.txtGrade = hit;
    }
    private HtmlInputText txtScore = new HtmlInputText();

    public HtmlInputText getTxtScore() {
        return txtScore;
    }

    public void setTxtScore(HtmlInputText hit) {
        this.txtScore = hit;
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
    private HtmlOutputLabel lblScore = new HtmlOutputLabel();

    public HtmlOutputLabel getLblScore() {
        return lblScore;
    }

    public void setLblScore(HtmlOutputLabel hol) {
        this.lblScore = hol;
    }
    private HtmlOutputLabel lblInstitPrevId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblInstitPrevId() {
        return lblInstitPrevId;
    }

    public void setLblInstitPrevId(HtmlOutputLabel hol) {
        this.lblInstitPrevId = hol;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EducationPostPaymentApprovePage() {
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
    @Override
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
        validtae();
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

    public void setPendingRequestList(ArrayList<Option> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public ArrayList<SelectItem> getEducationLevelCatagoryList() {
        return educationLevelCatagoryList;
    }

    public ArrayList<EducationPaymentModel> getAdminstrativeCostLists() {
        return adminstrativeCostLists;
    }

    public void setAdminstrativeCostLists(ArrayList<EducationPaymentModel> adminstrativeCostLists) {
        this.adminstrativeCostLists = adminstrativeCostLists;
    }

    public ArrayList<EducationPaymentModel> getCourseTakingList() {
        return courseTakingList;
    }

    public int getAdminstratId() {
        return adminstratId;
    }

    public void setAdminstratId(int adminstratId) {
        this.adminstratId = adminstratId;
    }

    public ArrayList<EducationPaymentModel> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(ArrayList<EducationPaymentModel> availableCourses) {
        this.availableCourses = availableCourses;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCreditHr() {
        return creditHr;
    }

    public void setCreditHr(String creditHr) {
        this.creditHr = creditHr;
    }

    public EducationPostPaymentRequestManager getEducationOPostPaymentRequestManager() {
        return educationOPostPaymentRequestManager;
    }

    public void setEducationOPostPaymentRequestManager(EducationPostPaymentRequestManager educationOPostPaymentRequestManager) {
        this.educationOPostPaymentRequestManager = educationOPostPaymentRequestManager;
    }

    public EducationPostPaymentApproveManager getEducationPostPaymentApproveManager() {
        return educationPostPaymentApproveManager;
    }

    public void setEducationPostPaymentApproveManager(EducationPostPaymentApproveManager educationPostPaymentApproveManager) {
        this.educationPostPaymentApproveManager = educationPostPaymentApproveManager;
    }

    public String getGradept() {
        return gradept;
    }

    public void setGradept(String gradept) {
        this.gradept = gradept;
    }

    public static boolean isSelected() {
        return selected;
    }

    public static void setSelected(boolean selected) {
        EducationPostPaymentApprovePage.selected = selected;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public void setCourseTakingList(ArrayList<EducationPaymentModel> courseTakingList) {
        this.courseTakingList = courseTakingList;
    }

    public void setEducationLevelCatagoryList(ArrayList<SelectItem> educationLevelCatagoryList) {
        this.educationLevelCatagoryList = educationLevelCatagoryList;
    }

//    public ArrayList<SelectItem> getEducationTypeCatagoryList() {
//        return educationTypeCatagoryList;
//    }
//
//    public void setEducationTypeCatagoryList(ArrayList<SelectItem> educationTypeCatagoryList) {
//        this.educationTypeCatagoryList = educationTypeCatagoryList;
//    }
    public ArrayList<SelectItem> getEducationShiftList() {
        return educationShiftList;
    }

    public void setEducationShiftList(ArrayList<SelectItem> educationShiftList) {
        this.educationShiftList = educationShiftList;
    }

    public ArrayList<Option> getPendingRequestList() {
        return pendingRequestList;
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

    public ArrayList<Option> getRequestHistoryList() {
        return requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<Option> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<Option> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
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

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pnlPopupConfirmDelete) {
        this.pnlPopupConfirmDelete = pnlPopupConfirmDelete;
    }

    public String getAdminstrativeCostType() {
        return adminstrativeCostType;
    }

    public void setAdminstrativeCostType(String adminstrativeCostType) {
        this.adminstrativeCostType = adminstrativeCostType;
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

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    //=========================================================================================================================
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
    //==========================================================================================================

    private boolean populateRequesterTableComponents(int educatRequestId, String date) {

        ArrayList<HashMap> empInfoHashMap = educationPostPaymentApproveManager.getTableInfo(educatRequestId, date);

        if (empInfoHashMap != null) {
            tableSize = 0;
            getAdminstrativeCostLists().clear();
            // getCourseTakingList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                educationRequestId = educatRequestId;
                adminstrativeCostType = hmTc.get("AMINSTRATIVE_COST_TYPE").toString();
                unitCost = Double.valueOf(hmTc.get("UNIT_COST").toString());
                totalCost = Double.valueOf(hmTc.get("TOTAL_COST").toString());
                requesterId = hmTc.get("REQUESTER_ID").toString();
                adminstratId = Integer.valueOf(hmTc.get("ID").toString());
                adminstrativeCostLists.add(new EducationPaymentModel(requesterId, unitCost, totalCost, adminstrativeCostType, educationRequestId, adminstratId, selected));
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
    //==============================================================================

    private boolean populateCourseTableComponents(int educatRequestId, String date) {
        // int tableSize;
        ArrayList<HashMap> empInfoHashMap = educationPostPaymentApproveManager.getCourseInfo(educatRequestId, date);
        if (empInfoHashMap != null) {
            tableSize = 0;
            //    getAdminstrativeCostLists().clear();
            getCourseTakingList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                educationRequestId = educatRequestId;
                requesterId = hmTc.get("REQUESTER_ID").toString();
                courseCode = hmTc.get("COURSE_CODE").toString();
                creditHr = hmTc.get("CREDIT_HOUR").toString();
                semesterOrTerm = hmTc.get("SEMISTER").toString();
                cGPA = Float.valueOf(hmTc.get("CGPA").toString());
                courseID = Integer.valueOf(hmTc.get("ID").toString());
                gradept = hmTc.get("GRADE_PT").toString();
                academicYear = hmTc.get("ACADAMIC_YEAR").toString();
                courseTakingList.add(new EducationPaymentModel(requesterId, courseCode, creditHr, semesterOrTerm, cGPA, educationRequestId, gradept, academicYear, courseID));
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
    //==============================================================================================================

    private boolean populatePaymentRequestTextComponents(int requestId) {

        educationPaymentModel = educationOPostPaymentRequestManager.getEducationPaymentRequest(requestId);
        if (educationPaymentModel != null) {
            if (educationPaymentModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {

                //txtCGPA.setValue(educationPaymentModel.getCumlativeGPA());
                txtAppliedDate.setValue(educationPaymentModel.getAppliedDate());
                txtDocumentReferenceNumber.setValue(educationPaymentModel.getDocumentReferenceNumber());
                txtReciptNumber.setValue(educationPaymentModel.getReceiptNumber());
                txtSemesterOrTerm.setValue(educationPaymentModel.getSemesterOrTerm());
                txtAcademicYear.setValue(educationPaymentModel.getAcademicYear());
                txtRemark.setValue(educationPaymentModel.getRemark());
                txtIssueDate.setValue(educationPaymentModel.getIssueDate());

                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    //=========================================================================================================================
    private boolean populateResultComponents(int requestId, String applideDate) {

        educationPaymentModel = educationOPostPaymentRequestManager.getEducationpOSResultRequest(requestId, applideDate);
        if (educationPaymentModel != null) {
            if (educationPaymentModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {

                txtResult.setValue(educationPaymentModel.getResultBasic());
                txtScore.setValue(educationPaymentModel.getScore());
//                txtIssueDate.setValue(educationPaymentModel.getIssueDate());
//                txtDocumentReferenceNumber.setValue(educationPaymentModel.getDocumentReferenceNumber());
//                txtReciptNumber.setValue(educationPaymentModel.getReceiptNumber());
//                txtSemesterOrTerm.setValue(educationPaymentModel.getSemesterOrTerm());
//                txtAcademicYear.setValue(educationPaymentModel.getAcademicYear());
//                txtRemark.setValue(educationPaymentModel.getRemark());
//                //txtCGPA.setValue(educationPaymentModel.getCumlativeGPA());

                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }


    //===============================
    private boolean populateEducationComponents(int requestId) {

        educationRequestModel = educationRequestManager.getEducationRequest(requestId);
        if (educationRequestModel != null) {
            if (educationRequestModel.getEducationRequestId() == -1) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
                return false;
            } else {
                txtEducationProgramName.setValue(educationRequestModel.getEducationProgramName());
                lblInstitPrevId.setValue(educationRequestModel.getInstitutionName());
                String instId = lblInstitPrevId.getValue().toString();
                institutionName = educationRequestManager.getTypeOFInstName(instId);
                txtInstitutionName.setValue(institutionName);
               // txtInstitutionName.setValue(educationRequestModel.getInstitutionName());
                txtEducationLevel.setValue(educationRequestModel.getEducationLevelCategory());
                txtDocreferenceNum.setValue(educationRequestModel.getDocumentReferenceNumber());
                txtGrade.setValue(educationRequestModel.getLevelID());
                if (txtGrade.getValue().toString().equalsIgnoreCase("HIGH")) {
                    //pnlLayoutButtons2.setRendered(true);
                    populateCourseTableComponents(educationRequestId, appliedDate);
                    txtResult.setRendered(false);
                    txtScore.setRendered(false);
                    lblScore.setRendered(false);
                    lblResult.setRendered(false);
                     dataCourse.setRendered(true);
                } else {
                    getCourseTakingList().clear();
                    populateResultComponents(educationRequestId, appliedDate);
                    txtResult.setRendered(true);
                    txtScore.setRendered(true);
                    lblScore.setRendered(true);
                    lblResult.setRendered(true);
                    dataCourse.setRendered(false);
                }
                 if (educationRequestModel.getChangeInstStatus().equals("Yes")) {
                    showSuccessOrFailureMessage(false, "THE EMPLOYEE CHANGES HIS INSTITITUTION TO " + institutionName);
                    lnkViewCourseLists.setRendered(true);
                 }
                 else{
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

    //=========================================================================================================================
    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        txtlblRequesterEdLevel.setValue(null);
        txtlblRequesterProgramName.setValue(null);
    }

    private void clearDecisionTextComponents() {
        drlDecision.setValue(null);
        txtaDeciderComment.setValue(null);
    }

    private void clearAllComponents() {
        clearEducationComponents();
        clearRequestComponents();
        clearRequesterTextComponents();
        clearDecisionTextComponents();
        clearDropDownItems();
        makePageReadyForUpdate();
    }

    private void clearDropDownItems() {
        selectedRequestFromMyRequestList = new DefaultSelectedData();
        selectedRequestFromHistoryList.setSelectedObject(null);
        selectObjectOfEducationTypeCatagory.setSelectedObject(null);
        selectObjectOfEducationLevelCatagory.setSelectedObject(null);

    }

    public void enableComponents() {
//        txtEducationProgramName.setDisabled(false);
//        // txtNumberOfCreditHours.setDisabled(false);
//        txtAppliedDate.setDisabled(false);
////        txtCostPerCreditHour.setDisabled(false);
//        txtDocumentReferenceNumber.setDisabled(false);
//        txtAcademicYear.setDisabled(false);
//        txtaInstitutionName.setDisabled(false);
//        txtRemark.setDisabled(false);
//
//        txtEducationLevel.setDisabled(false);
    //txtEducationProgCategory.setDisabled(false);
    }

    public void disableComponents() {
        txtEducationProgramName.setDisabled(true);

        txtAppliedDate.setDisabled(true);

        txtDocumentReferenceNumber.setDisabled(true);
        txtAcademicYear.setDisabled(true);
        txtaInstitutionName.setDisabled(true);
        txtRemark.setDisabled(true);

        txtEducationLevel.setDisabled(true);
    // txtEducationProgCategory.setDisabled(true);
    }

    public void clearEducationComponents() {
        txtInstitutionName.setValue(null);
        txtEducationProgramName.setValue(null);
        txtEducationLevel.setValue(null);
        txtGrade.setValue(null);
        txtDocreferenceNum.setValue(null);
        txtResult.setValue(null);
        txtScore.setValue(null);

    }

    public void clearRequestComponents() {
        txtIssueDate.setValue(null);
        txtAppliedDate.setValue(null);
        txtReciptNumber.setValue(null);
        txtDocumentReferenceNumber.setValue(null);
        txtAcademicYear.setValue(null);
        txtRemark.setValue(null);
        getAdminstrativeCostLists().clear();
        getCourseTakingList().clear();
    }
    //=========================================================================================================================

    private void makePageReadyForSave() {
        clearDecisionTextComponents();
        newOrEditOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(false);
    }

    public void nonRenderComponenet() {
        txtAcademicYear.setRendered(false);
        txtSemesterOrTerm.setRendered(false);
        lblAcademicYear.setRendered(false);
        lblSemesterOrTerm.setRendered(false);
    }

    public void RenderComponenet() {
        txtAcademicYear.setRendered(true);
        txtSemesterOrTerm.setRendered(true);
        lblAcademicYear.setRendered(true);
        lblSemesterOrTerm.setRendered(true);
    }

    private void makePageReadyForUpdate() {
        enableComponents();
        newOrEditOrUpdateLabel = "Update";
        btnSaveOrUpdate.setDisabled(false);
    }

    private void makePageReadyForView() {
        disableComponents();
        newOrEditOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(true);
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

    private void populateDecisionHistory(int requestId) {
        decisionsMadeOnRequestList = educationPostPaymentApproveManager.getRequestHistory(requestId);

    }
    //=========================================================================================================================

    // </editor-fold>
    // </editor-fold >
    // </editor-fold >
    EmployeeManage employeeManager = new EmployeeManage();
    EducationRequestModel educationRequestModel = new EducationRequestModel();
    EducationPaymentModel educationPaymentModel = new EducationPaymentModel();
    EducationRequestManager educationRequestManager = new EducationRequestManager();
    EducationPaymentRequestManager educationPaymentRequestManager = new EducationPaymentRequestManager();
    EducationPostPaymentRequestManager educationOPostPaymentRequestManager = new EducationPostPaymentRequestManager();
    EducationPostPaymentApproveManager educationPostPaymentApproveManager = new EducationPostPaymentApproveManager();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    ArrayList<SelectItem> availableDecisionsToMakeList = new ArrayList<SelectItem>();
    ArrayList<Option> pendingRequestList = new ArrayList<Option>();
    ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    ArrayList<Option> requestHistoryList = new ArrayList<Option>();
    ArrayList<SelectItem> educationLevelCatagoryList = educationRequestManager.getEducationLevels();
    ArrayList<SelectItem> educationShiftList = educationRequestManager.getEducationShift();
    // ArrayList<SelectItem> availableDecisionsToMakeList = new ArrayList<SelectItem>();
    ArrayList<EducationPaymentModel> adminstrativeCostLists = new ArrayList<EducationPaymentModel>();
    private ArrayList<EducationPaymentModel> availableCourses = new ArrayList<EducationPaymentModel>();
    ArrayList<EducationPaymentModel> courseTakingList = new ArrayList<EducationPaymentModel>();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationTypeCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfEducationLevelCatagory = new DefaultSelectedData();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String loggedInEmployeeId;
    String userName;
    //=====================================================================================
    int educationPaymentRequestId;
    int educationRequestId = 1;
    int numberOfCreditHours;
    int numberOfCourses;
    double costPerCreditHour;
    double adminstrativeCost;
    double totalCost;
    String paymentPreOrPost;
    String academicYear;
    int courseID;
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
    String institutionName;
    String ethiopianInstitution;//inside or outside ethiopia
    String institutionAccredited;//
    String institutionAddress;
    String reasonDescription;
    double unitCost;
    double quantity;
    String adminstrativeCostType;
    double total;
    String courseCode;
    int creditHour;
    String creditHr;
    float cGPA;
    int adminstratId;
    private static boolean selected = true;
    String gradept;
    //=========================================================================================================================

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
        // populateCourseTableComponents(educationRequestId, appliedDate);
        availableDecisionsToMakeList = educationPostPaymentApproveManager.getAvailableDecisionsToMake(requestStatus);
        makePageReadyForSave();
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
        //populateCourseTableComponents(educationRequestId, appliedDate);
        populateDecisionHistory(educationPaymentRequestId);
        makePageReadyForView();
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
        if (educationOPostPaymentRequestManager.deleteEducationRequest(educationRequestId)) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponents();
            requestListsToBeApproved = educationPostPaymentApproveManager.getRequestsToBeProcessed();
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
            /*
            double adminstrativeCost, double totalCost, String paymentPreOrPost,
            String academicYear, String semesterOrTerm, String appliedDate, String issueDate,
            String remark, String documentReferenceNumber, String receiptNumber) {
             */
            try {

                requesterId = txtRequesterId.getValue().toString();
                educationProgramName = txtEducationProgramName.getValue().toString();
                institutionName = txtaInstitutionName.getValue().toString();
                appliedDate = txtAppliedDate.getValue().toString();
                remark = txtRemark.getValue().toString();
                receiptNumber = txtReciptNumber.getValue().toString();
                documentReferenceNumber = txtDocumentReferenceNumber.getValue().toString();
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
    //=========================================================================================================================

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(EducationPostPaymentApproveManager.EDUCATION_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(EducationPostPaymentApproveManager.EDUCATION_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
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
        return educationPostPaymentApproveManager.saveDecision(educationPaymentRequestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);
    }

    private void validtae() {
        checkbox1.isSelected();
    }

    public boolean isEntryValidForSearchTerminator() {
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
        if (isEntryValidForSearchTerminator()) {
            if (validateDecision()) {


                if (saveDecision()) {
                    clearAllComponents();

                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                    requestHistoryList = educationPostPaymentApproveManager.getMyDecisionsOnRequests();
                    requestListsToBeApproved = educationPostPaymentApproveManager.getRequestsToBeProcessed();

                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED");
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

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(educationPaymentRequestId);
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

    public String txttotalCost_action() {
        //return null means stay on the same page
        return null;
    }

    public void selectMyRequestLists_validate(FacesContext context, UIComponent component, Object value) {
    }

    public String lnkChangeiNstitutionReq_action() {
        // TODO: Replace with your code
        return "ChangeInstitutionPage";
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

    public String txtGrade_action() {
        //return null means stay on the same page
        return null;
    }

    public void modalPnlCloseBtn_processAction(ActionEvent ae) {
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

    public String modalPnlCloseBtn1_action() {
        //return null means stay on the same page
        pnlPopUpClearingDepSetting1.setRendered(false);
        return null;
    }
}
