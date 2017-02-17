/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Discipline;

//import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.Help.Template;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import manager.disciplineManager.AccusedDefenceManager;
import manager.disciplineManager.DisciplineRegistrationManager;
import manager.disciplineManager.DisciplineRequestManager;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.employeeManager.EmployeeManage;
import fphrms.Attendance.AttendancePage;
import fphrms.EmployeeHistory.ComplaintPage1;
import fphrms.Recruitment.ExamQuestions;
import fphrms.Termination.RetireRequestPage;
import fphrms.Report.MainReport;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.Template_1;
import fphrms.Termination.RetireApprovalPage;
import java.io.File;
import manager.authorizationManager.AuthorizationManager.CommeeteeCommentsGiven;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.disciplineManager.AccusedDefenceManager.AccusedFileUpLoad;
import manager.disciplineManager.AccusedDefenceManager.FileUpLoadForInterset;
import manager.disciplineManager.DisciplineApproveManager;
import manager.disciplineManager.EyeWitnessManager;
import manager.disciplineManager.EyeWitnessManager.EyeWitnessModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class AccusedDefencePage extends AbstractPageBean {
    //<editor-fold  defaultstate="collapsed" desc="default">
    // <editor-fold defaultstate="collapsed" desc="Local Variables">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        userName = getSessionBean1().getUserName();
        disciplineRequestManager.setUserName(userName);
        accusedDefenceManager.setUserName(userName);
        accusedDefenceManager.setLoggedInEmployeeId(loggedInEmployeeId);
        populateEmployeeTextComponents(offenderId);
        pendingRequestLists = disciplineRequestManager.getPendingRequestsByAccused(loggedInEmployeeId);
        historyRequestLists = accusedDefenceManager.getMyCommentedRequests();
        if (disciplineProblemId != -1) {
            //  disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(disciplineProblemId);
            populateAllComponents(disciplineProblemId);
        }
        radioGroupAccusationAcceptance.resetValue();
        radioGroupPenaltyAcceptance.resetValue();
        populateRequesterTextComponents(loggedInEmployeeId);
        txtReportedDate.setValue(dateFormat.format(new Date()));
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private PanelLayout pnProfile = new PanelLayout();

    public PanelLayout getPnProfile() {
        return pnProfile;
    }

    public void setPnProfile(PanelLayout pl) {
        this.pnProfile = pl;
    }
    private HtmlPanelGroup pnlGrpPowerDeligationContent = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlGrpPowerDeligationContent() {
        return pnlGrpPowerDeligationContent;
    }

    public void setPnlGrpPowerDeligationContent(HtmlPanelGroup hpg) {
        this.pnlGrpPowerDeligationContent = hpg;
    }
    private DefaultSelectedData selectedObjectOfPendingList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOfDisciplineType = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectPending = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectHistory = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectPending() {
        return selectedObjectPending;
    }

    public void setSelectedObjectPending(DefaultSelectedData selectedObjectPending) {
        this.selectedObjectPending = selectedObjectPending;
    }

    public DefaultSelectedData getSelectedObjectOfDisciplineType() {
        return selectedObjectOfDisciplineType;
    }

    public void setSelectedObjectOfDisciplineType(DefaultSelectedData selectedObjectOfDisciplineType) {
        this.selectedObjectOfDisciplineType = selectedObjectOfDisciplineType;
    }

    public ArrayList<Option> getHistoryRequestLists() {
        return historyRequestLists;
    }

    public void setHistoryRequestLists(ArrayList<Option> historyRequestLists) {
        this.historyRequestLists = historyRequestLists;
    }

    public DefaultSelectedData getSelectedObjectHistory() {
        return selectedObjectHistory;
    }

    public void setSelectedObjectHistory(DefaultSelectedData selectedObjectHistory) {
        this.selectedObjectHistory = selectedObjectHistory;
    }

    public DefaultSelectedData getSelectedObjectOfPendingList() {
        return selectedObjectOfPendingList;
    }

    public void setSelectedObjectOfPendingList(DefaultSelectedData selectedObjectOfPendingList) {
        this.selectedObjectOfPendingList = selectedObjectOfPendingList;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private HtmlInputText txtRequesterDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment() {
        return txtRequesterDepartment;
    }

    public void setTxtRequesterDepartment(HtmlInputText hit) {
        this.txtRequesterDepartment = hit;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
    }
    private HtmlInputText txtRequesterFullName = new HtmlInputText();

    public HtmlInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(HtmlInputText hit) {
        this.txtRequesterFullName = hit;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlInputText txtEmployeeDepartment = new HtmlInputText();

    public HtmlInputText getTxtEmployeeDepartment() {
        return txtEmployeeDepartment;
    }

    public void setTxtEmployeeDepartment(HtmlInputText hit) {
        this.txtEmployeeDepartment = hit;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private HtmlInputText txtEmployeeFullName = new HtmlInputText();

    public HtmlInputText getTxtEmployeeFullName() {
        return txtEmployeeFullName;
    }

    public void setTxtEmployeeFullName(HtmlInputText hit) {
        this.txtEmployeeFullName = hit;
    }
    private HtmlInputText txtEmployeePosition = new HtmlInputText();

    public HtmlInputText getTxtEmployeePosition() {
        return txtEmployeePosition;
    }

    public void setTxtEmployeePosition(HtmlInputText hit) {
        this.txtEmployeePosition = hit;
    }
    private HtmlInputText txtDisciplineDate = new HtmlInputText();

    public HtmlInputText getTxtDisciplineDate() {
        return txtDisciplineDate;
    }

    public void setTxtDisciplineDate(HtmlInputText hit) {
        this.txtDisciplineDate = hit;
    }
    private HtmlInputText txtReportedDate = new HtmlInputText();

    public HtmlInputText getTxtReportedDate() {
        return txtReportedDate;
    }

    public void setTxtReportedDate(HtmlInputText hit) {
        this.txtReportedDate = hit;
    }
    private HtmlSelectOneMenu drlDisciplineType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDisciplineType() {
        return drlDisciplineType;
    }

    public void setDrlDisciplineType(HtmlSelectOneMenu hsom) {
        this.drlDisciplineType = hsom;
    }

    public ArrayList<Option> getDisciplineTypesListForManager() {
        return disciplineTypesListForManager;
    }

    public void setDisciplineTypesListForManager(ArrayList<Option> disciplineTypesListForManager) {
        this.disciplineTypesListForManager = disciplineTypesListForManager;
    }

    public ArrayList<Option> getDisciplineTypesList() {
        return disciplineTypesList;
    }

    public void setDisciplineTypesList(ArrayList<Option> disciplineTypesList) {
        this.disciplineTypesList = disciplineTypesList;
    }
    private HtmlInputTextarea txtaDisciplineDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDisciplineDescription() {
        return txtaDisciplineDescription;
    }

    public void setTxtaDisciplineDescription(HtmlInputTextarea hit) {
        this.txtaDisciplineDescription = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private HtmlInputText txtDisciplinePreviousOccurance = new HtmlInputText();

    public HtmlInputText getTxtDisciplinePreviousOccurance() {
        return txtDisciplinePreviousOccurance;
    }

    public void setTxtDisciplinePreviousOccurance(HtmlInputText hit) {
        this.txtDisciplinePreviousOccurance = hit;
    }
    private SelectInputDateBean calReportedDateBean = new SelectInputDateBean();

    public SelectInputDateBean getCalReportedDateBean() {
        return calReportedDateBean;
    }

    public void setCalReportedDateBean(SelectInputDateBean calReportedDateBean) {
        this.calReportedDateBean = calReportedDateBean;
    }
    private SelectInputDateBean calOffenceDateBean = new SelectInputDateBean();

    public SelectInputDateBean getCalOffenceDateBean() {
        return calOffenceDateBean;
    }

    public void setCalOffenceDateBean(SelectInputDateBean calOffenceDateBean) {
        this.calOffenceDateBean = calOffenceDateBean;
    }
    private SelectInputDate calOffenceDate = new SelectInputDate();

    public SelectInputDate getCalOffenceDate() {
        return calOffenceDate;
    }

    public void setCalOffenceDate(SelectInputDate sid) {
        this.calOffenceDate = sid;
    }
    private SelectInputDate calReportedDate = new SelectInputDate();

    public SelectInputDate getCalReportedDate() {
        return calReportedDate;
    }

    public void setCalReportedDate(SelectInputDate sid) {
        this.calReportedDate = sid;
    }
    private HtmlInputTextarea txtaDisciplineDecisionTobeTaken = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDisciplineDecisionTobeTaken() {
        return txtaDisciplineDecisionTobeTaken;
    }

    public void setTxtaDisciplineDecisionTobeTaken(HtmlInputTextarea hit) {
        this.txtaDisciplineDecisionTobeTaken = hit;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDateOfOffence() {
        return dateOfOffence;
    }

    public void setDateOfOffence(String dateOfOffence) {
        this.dateOfOffence = dateOfOffence;
    }

    public String getDescriptionOfOffence() {
        return descriptionOfOffence;
    }

    public void setDescriptionOfOffence(String descriptionOfOffence) {
        this.descriptionOfOffence = descriptionOfOffence;
    }

    public int getDisciplineProblemId() {
        return disciplineProblemId;
    }

    public void setDisciplineProblemId(int disciplineProblemId) {
        this.disciplineProblemId = disciplineProblemId;
    }

    public DisciplineRegistrationManager getDisciplineRegistrationManager() {
        return disciplineRegistrationManager;
    }

    public void setDisciplineRegistrationManager(DisciplineRegistrationManager disciplineRegistrationManager) {
        this.disciplineRegistrationManager = disciplineRegistrationManager;
    }

    public String getIsDocumentAttached() {
        return isDocumentAttached;
    }

    public void setIsDocumentAttached(String isDocumentAttached) {
        this.isDocumentAttached = isDocumentAttached;
    }

    public String getEmpoyeeStatus() {
        return empoyeeStatus;
    }

    public void setEmpoyeeStatus(String empoyeeStatus) {
        this.empoyeeStatus = empoyeeStatus;
    }

    public String getOffenceType() {
        return offenceType;
    }

    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }

    public String getOffenderId() {
        return offenderId;
    }

    public void setOffenderId(String offenderId) {
        this.offenderId = offenderId;
    }

    public int getRepititionOfOffence() {
        return repititionOfOffence;
    }

    public void setRepititionOfOffence(int repititionOfOffence) {
        this.repititionOfOffence = repititionOfOffence;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getRequestedMeasureToBeTaken() {
        return requestedMeasureToBeTaken;
    }

    public void setRequestedMeasureToBeTaken(String requestedMeasureToBeTaken) {
        this.requestedMeasureToBeTaken = requestedMeasureToBeTaken;
    }

    public String getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(String requesterType) {
        this.requesterType = requesterType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //<editor-fold  defaultstate="collapsed" desc="Local Variables">
    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public String getDisciplinedEmployeeId() {
        return disciplinedEmployeeId;
    }

    public void setDisciplinedEmployeeId(String disciplinedEmployeeId) {
        this.disciplinedEmployeeId = disciplinedEmployeeId;
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

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
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

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public ArrayList<Option> getPendingRequestLists() {
        return pendingRequestLists;
    }

    public void setPendingRequestLists(ArrayList<Option> pendingRequestLists) {
        this.pendingRequestLists = pendingRequestLists;
    }

    public DisciplineRequestManager getDisciplineRequestManager() {
        return disciplineRequestManager;
    }

    public void setDisciplineRequestManager(DisciplineRequestManager disciplineRequestManager) {
        this.disciplineRequestManager = disciplineRequestManager;
    }

    public String getANOTHEREMPLOYEE() {
        return ANOTHEREMPLOYEE;
    }

    public void setANOTHEREMPLOYEE(String ANOTHEREMPLOYEE) {
        this.ANOTHEREMPLOYEE = ANOTHEREMPLOYEE;
    }

    public String getIMMEDIATEBOSS() {
        return IMMEDIATEBOSS;
    }

    public void setIMMEDIATEBOSS(String IMMEDIATEBOSS) {
        this.IMMEDIATEBOSS = IMMEDIATEBOSS;
    }

    public String getNOTEMPLOYEE() {
        return NOTEMPLOYEE;
    }

    public void setNOTEMPLOYEE(String NOTEMPLOYEE) {
        this.NOTEMPLOYEE = NOTEMPLOYEE;
    }

    public String getSaveOrEditOrUpdateLabel() {
        return saveOrEditOrUpdateLabel;
    }

    public void setSaveOrEditOrUpdateLabel(String saveOrEditOrUpdateLabel) {
        this.saveOrEditOrUpdateLabel = saveOrEditOrUpdateLabel;
    }
    private HtmlSelectOneRadio radioGroupAccusationAcceptance = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadioGroupAccusationAcceptance() {
        return radioGroupAccusationAcceptance;
    }

    public void setRadioGroupAccusationAcceptance(HtmlSelectOneRadio hsor) {
        this.radioGroupAccusationAcceptance = hsor;
    }
    private HtmlSelectOneRadio radioGroupPenaltyAcceptance = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadioGroupPenaltyAcceptance() {
        return radioGroupPenaltyAcceptance;
    }

    public void setRadioGroupPenaltyAcceptance(HtmlSelectOneRadio hsor) {
        this.radioGroupPenaltyAcceptance = hsor;
    }
    private HtmlCommandButton btnSaveOrUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveOrUpdate() {
        return btnSaveOrUpdate;
    }

    public void setBtnSaveOrUpdate(HtmlCommandButton hcb) {
        this.btnSaveOrUpdate = hcb;
    }
    private HtmlInputTextarea txtaAccusationAcceptance = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaAccusationAcceptance() {
        return txtaAccusationAcceptance;
    }

    public void setTxtaAccusationAcceptance(HtmlInputTextarea hit) {
        this.txtaAccusationAcceptance = hit;
    }
    private HtmlInputTextarea txtaPenaltyAcceptance = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaPenaltyAcceptance() {
        return txtaPenaltyAcceptance;
    }

    public void setTxtaPenaltyAcceptance(HtmlInputTextarea hit) {
        this.txtaPenaltyAcceptance = hit;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
    }
    private HtmlInputText txtDisciplineName = new HtmlInputText();

    public HtmlInputText getTxtDisciplineName() {
        return txtDisciplineName;
    }

    public void setTxtDisciplineName(HtmlInputText hit) {
        this.txtDisciplineName = hit;
    }
    private SelectInputText txtWitnessFullName = new SelectInputText();

    public SelectInputText getTxtWitnessFullName() {
        return txtWitnessFullName;
    }

    public void setTxtWitnessFullName(SelectInputText sit) {
        this.txtWitnessFullName = sit;
    }
    private HtmlInputText txtWitnessDepartment = new HtmlInputText();

    public HtmlInputText getTxtWitnessDepartment() {
        return txtWitnessDepartment;
    }

    public void setTxtWitnessDepartment(HtmlInputText hit) {
        this.txtWitnessDepartment = hit;
    }
    private HtmlInputText txtWitnessPosition = new HtmlInputText();

    public HtmlInputText getTxtWitnessPosition() {
        return txtWitnessPosition;
    }

    public void setTxtWitnessPosition(HtmlInputText hit) {
        this.txtWitnessPosition = hit;
    }
    private HtmlInputText txtWitnessId = new HtmlInputText();

    public HtmlInputText getTxtWitnessId() {
        return txtWitnessId;
    }

    public void setTxtWitnessId(HtmlInputText hit) {
        this.txtWitnessId = hit;
    }
    private PanelPopup pnlEyeWitnessesRegistration = new PanelPopup();

    public PanelPopup getPnlEyeWitnessesRegistration() {
        return pnlEyeWitnessesRegistration;
    }

    public void setPnlEyeWitnessesRegistration(PanelPopup pp) {
        this.pnlEyeWitnessesRegistration = pp;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private HtmlCommandButton btnClosePopupViewPrevieousDecisions = new HtmlCommandButton();

    public HtmlCommandButton getBtnClosePopupViewPrevieousDecisions() {
        return btnClosePopupViewPrevieousDecisions;
    }

    public void setBtnClosePopupViewPrevieousDecisions(HtmlCommandButton hcb) {
        this.btnClosePopupViewPrevieousDecisions = hcb;
    }
    private HtmlDataTable dataTableDisciplineType = new HtmlDataTable();

    public HtmlDataTable getDataTableDisciplineType() {
        return dataTableDisciplineType;
    }

    public void setDataTableDisciplineType(HtmlDataTable hdt) {
        this.dataTableDisciplineType = hdt;
    }
    private PanelLayout pnlLayoutViewPrevieousDecisions = new PanelLayout();

    public PanelLayout getPnlLayoutViewPrevieousDecisions() {
        return pnlLayoutViewPrevieousDecisions;
    }

    public void setPnlLayoutViewPrevieousDecisions(PanelLayout pl) {
        this.pnlLayoutViewPrevieousDecisions = pl;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private InputFile inputFile_ForComment = new InputFile();

    public InputFile getInputFile_ForComment() {
        return inputFile_ForComment;
    }

    public void setInputFile_ForComment(InputFile if0) {
        this.inputFile_ForComment = if0;
    }
    private InputFile inputFile_IntersetAttache = new InputFile();

    public InputFile getInputFile_IntersetAttache() {
        return inputFile_IntersetAttache;
    }

    public void setInputFile_IntersetAttache(InputFile if0) {
        this.inputFile_IntersetAttache = if0;
    }
//</editor-fold>
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AccusedDefencePage() {
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CustomValidations getCustomValidations() {
        return (CustomValidations) getBean("CustomValidations");
    }
    //</editor-fold>
/////////////////////////////////////////////////////////////////////////////////////////////
    String loggedInEmployeeId;
    String userName;
    String saveOrEditOrUpdateLabel = "Save";
    String disciplinedEmployeeId;
    AccusedDefenceManager accusedDefenceManager = new AccusedDefenceManager();
    AccusedFileUpLoad fileUpLoad=new AccusedFileUpLoad();
    FileUpLoadForInterset fileUpLoadInterset=new FileUpLoadForInterset();
    EmployeeManage employeeManager = new EmployeeManage();
    DisciplineRequestManager disciplineRequestManager = new DisciplineRequestManager();
    DisciplineApproveManager disciplineApproveManager = new DisciplineApproveManager();
    // DisciplineRequestManager disciplineRequestManager = new DisciplineRequestManager();
    DisciplineRequestManager.DisciplineRequestModel disciplineRequestModel = new DisciplineRequestManager.DisciplineRequestModel();
    DisciplineRegistrationManager disciplineRegistrationManager = new DisciplineRegistrationManager();
    ArrayList<Option> disciplineTypesList = disciplineRequestManager.getDisciplineTypes();
    ArrayList<Option> disciplineTypesListForManager = disciplineRequestManager.getDisciplineTypes();
    ArrayList<CommeeteeCommentsGiven> comeeteeCommentsGive = new ArrayList<CommeeteeCommentsGiven>();
    ArrayList<Option> pendingRequestLists = new ArrayList<Option>();
    ArrayList<Option> historyRequestLists = new ArrayList<Option>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<EyeWitnessModel> eyeWitnessesList = new ArrayList<EyeWitnessModel>();
    EyeWitnessModel eyeWitnessModel = new EyeWitnessModel();
    EyeWitnessManager eyeWitnessManager = new EyeWitnessManager();
    //requester types
    public String IMMEDIATEBOSS = DisciplineRequestManager.REQUERSTER_TYPE_IMMEDIATEBOSS;
    public String ANOTHEREMPLOYEE = DisciplineRequestManager.REQUERSTER_TYPE_ANOTHEREMPLOYEE;
    public String NOTEMPLOYEE = DisciplineRequestManager.REQUERSTER_TYPE_NOTEMPLOYEE;
    int accusedCommentId;//ACCUSED_COMMENT_ID;
    int requestId;//REQUEST_ID;
    byte[] commeentsFile = null;
    byte[] intersetFile = null;
    private String filePath = null;
    private String fileExtenstion = "";
    String acceptAccusation = "";//ACCEPT_ACCUSATION;
    String acceptPenalty = "";//ACCEPT_PENALITY;
    String descriptionOfAccusation = "";//DESCRIPTION_ON_ACCUSATION;
    String descriptionOfPenalty = "";//DESCRIPTION_ON_PENALTY;
    String docReferenceNumber;
    int disciplineProblemId = -1;// DISCIPLINE_PROBLEM_ID
    String requesterType = IMMEDIATEBOSS;//REQUESTER_TYPE the default value of
    String requesterId = null; //REQUESTER_ID
    String offenderId = null;//OFFENDER_ID always employee
    String dateOfOffence = null;//DATE_OF_OFFENCE//when does it happen
    String reportedDate = null;//REPORTED_DATE//reported to the hrms e
    String offenceType = null;// OFFENCE_TYPE,//if it is registerd in the table HR_DISCIPLINE_TYPE, ELSE "Other"
    String empoyeeStatus=null;
    int repititionOfOffence = -1;//REPITITION_OF_OFFENCE//how many times does it occured before the phase out time
    String descriptionOfOffence = null;//DESCRIPTION_OF_OFFENCE//details
    String requestedMeasureToBeTaken = null;//REQUESTED_MEASURE_TO_BE_TAKEN
    String status = null;//STATUS
    String isDocumentAttached = null;//IS_DOCUMENT_ATTACHED

    private boolean populateRequesterTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(employeeId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateEmployeeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtEmployeeDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtEmployeeId.setValue(employeeId);
                txtEmployeePosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateDisciplineTextComponents(DisciplineRequestModel disciplineRequestModel) {
        txtDisciplineDate.setValue(disciplineRequestModel.getDateOfOffence());
        txtReportedDate.setValue(disciplineRequestModel.getReportedDate());//reset date
        txtaDisciplineDescription.setValue(disciplineRequestModel.getDescriptionOfOffence());
        txtaDisciplineDecisionTobeTaken.setValue(disciplineRequestModel.getRequestedMeasureToBeTaken());
        txtDisciplinePreviousOccurance.setValue(disciplineRequestModel.getRepititionOfOffence());
        setSelectedDisciplineType(disciplineRequestModel.getOffenceType());
        return true;
    }

    public boolean setSelectedDisciplineTypeNew(String disciplineType) {
        for (Option lookingFor : disciplineTypesList) {
            if (lookingFor.getValue().toString().startsWith(disciplineType)) {
                drlDisciplineType.setValue(lookingFor.getValue().toString());
                return true;
            }
        }
        return false;
    }
    public boolean setSelectedDisciplineType(String disciplineType) {
        disciplineRegistrationManager = new DisciplineRegistrationManager();
                    
        txtDisciplineName.setValue(disciplineRegistrationManager.getDisciplineName(disciplineType,empoyeeStatus));
                  
        return false;
    }

    public void populateAllComponents(int requestId) {
        // disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(requestId);
        populateRequesterTextComponents(disciplineRequestModel.getRequesterId());
        populateEmployeeTextComponents(disciplineRequestModel.getOffenderId());
        populateDisciplineTextComponents(disciplineRequestModel);
        populateDecisionHistory(disciplineRequestModel.getDisciplineProblemId());
    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        txtRequesterId.setDisabled(true);
        requesterId = null;
    }

    private void clearDisciplineTextComponents() {
        txtDisciplineDate.setValue(null);
        txtaDisciplineDescription.setValue(null);
        txtaDisciplineDecisionTobeTaken.setValue(null);
        txtReportedDate.setValue(dateFormat.format(new Date()));//reset date
        txtDisciplinePreviousOccurance.setValue(null);
        drlDisciplineType.resetValue();
        txtDocReferenceNumber.setValue(null);
        disciplineProblemId = -1;
    }

    private void clearAccusedCommentComponents() {

        radioGroupAccusationAcceptance.resetValue();
        radioGroupPenaltyAcceptance.resetValue();
        txtaAccusationAcceptance.setValue(null);
        txtaPenaltyAcceptance.setValue(null);
        acceptAccusation = "";
        acceptPenalty = "";
    }

    private void clearEmployeeTextComponents() {
        txtEmployeeId.setValue(null);
        txtEmployeeDepartment.setValue(null);
        txtEmployeeFullName.setValue(null);
        txtEmployeePosition.setValue(null);
    }

    private void clearAllComponents() {
        clearAccusedCommentComponents();
        clearDisciplineTextComponents();
        clearRequesterTextComponents();
        // populateRequesterTextComponents(loggedInEmployeeId);
        clearEmployeeTextComponents();
        selectedObjectPending.setSelectedObject(null);
        pendingRequestLists = disciplineRequestManager.getPendingRequestsByAccused(loggedInEmployeeId);
    }

    private void makePageReadyForUpdate() {
        saveOrEditOrUpdateLabel = "Update";
        clearAllComponents();
    }

    public String btnReset_action() {
        clearAllComponents();
        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    private boolean validateAccusedComment() {
        if (acceptAccusation.equals("") || acceptPenalty.equals("") ||
                txtaAccusationAcceptance.getValue() == null || txtaAccusationAcceptance.getValue().toString().equals("") ||
                txtaPenaltyAcceptance.getValue() == null || txtaPenaltyAcceptance.getValue().toString().equals("") ||
                txtDocReferenceNumber.getValue() == null || txtDocReferenceNumber.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(false, "ALL FILEDS REQUIRE TO BE FILLED");
            return false;
        }
        return true;
    }

    public String btnSaveOrUpdate_action() {
        if (saveOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
            if (validateAccusedComment()) {
                descriptionOfAccusation = txtaAccusationAcceptance.getValue().toString();
                descriptionOfPenalty = txtaPenaltyAcceptance.getValue().toString();
                docReferenceNumber = txtDocReferenceNumber.getValue().toString();
                commeentsFile= getCommeentsFile();
                intersetFile=getIntersetFile();
                if (accusedDefenceManager.saveAccusedDefence(disciplineProblemId, acceptAccusation, acceptPenalty, descriptionOfAccusation, descriptionOfPenalty, docReferenceNumber,commeentsFile,intersetFile)) {
                    accusedDefenceManager.saveFile(fileUpLoad,fileUpLoadInterset);
                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                    pendingRequestLists = disciplineRequestManager.getPendingRequestsByAccused(loggedInEmployeeId);
                    historyRequestLists = accusedDefenceManager.getMyCommentedRequests();
                    clearAllComponents();
                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED");
                }
            }
        } else if (saveOrEditOrUpdateLabel.equalsIgnoreCase("Edit")) {
            makePageReadyForUpdate();
        } else {// if(saveOrEditOrUpdateLabel.equalsIgnoreCase("Update")){
            ////update mmethod called here
        }
        return null;
    }

    public void makePageReadyForSave() {
    }

    private void populateDecisionHistory(int disciplineRequestId) {

        decisionsMadeOnRequest = disciplineApproveManager.getRequestHistory(disciplineRequestId);
        if (decisionsMadeOnRequest.size() > 0) {
            lnkViewPrevieousDecisions.setRendered(true);
        } else {
            lnkViewPrevieousDecisions.setRendered(false);
        // makePageReadyForUpdate();
        }
    }

    public void sge(ValueChangeEvent vce) {
        String[] requestInfo = vce.getNewValue().toString().split("--");
        disciplineProblemId = Integer.parseInt(requestInfo[0]);
        requestId = disciplineProblemId;
        requesterId = requestInfo[1];
        status = requestInfo[2];
        offenceType = requestInfo[3];
    //    populateAllComponents(offenceType,disciplineProblemId);
    }

    public void radioGroupAggreeRequesterClaim_processValueChange(ValueChangeEvent vce) {
        requesterType = vce.getNewValue().toString();
        if (vce.getNewValue().toString().equals(IMMEDIATEBOSS)) {

            txtRequesterId.setDisabled(true);
            populateRequesterTextComponents(loggedInEmployeeId);
        } else if (vce.getNewValue().toString().equals(ANOTHEREMPLOYEE)) {
            requesterId = null;
            clearRequesterTextComponents();
            txtRequesterId.setDisabled(false);

        } else {//}else if(vce.getNewValue().toString().equals(NOTEMPLOYEE)) {
        }
    }

    public ArrayList<CommeeteeCommentsGiven> getComeeteeCommentsGive() {
        return comeeteeCommentsGive;
    }

    public void setComeeteeCommentsGive(ArrayList<CommeeteeCommentsGiven> comeeteeCommentsGive) {
        this.comeeteeCommentsGive = comeeteeCommentsGive;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public String lnkDisciplineRegistrationPage_action() {
        return "DisciplineTypes";
    }

    public String lnkGovernmentDeductions_action() {
        return "DisciplineApprove";
    }

    public String getAcceptAccusation() {
        return acceptAccusation;
    }

    public void setAcceptAccusation(String acceptAccusation) {
        this.acceptAccusation = acceptAccusation;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAcceptPenalty() {
        return acceptPenalty;
    }

    public String getFileExtenstion() {
        return fileExtenstion;
    }

    public void setFileExtenstion(String fileExtenstion) {
        this.fileExtenstion = fileExtenstion;
    }

    public byte[] getCommeentsFile() {
        return commeentsFile;
    }

    public void setCommeentsFile(byte[] commeentsFile) {
        this.commeentsFile = commeentsFile;
    }

    public byte[] getIntersetFile() {
        return intersetFile;
    }

    public void setIntersetFile(byte[] intersetFile) {
        this.intersetFile = intersetFile;
    }

    public void setAcceptPenalty(String acceptPenalty) {
        this.acceptPenalty = acceptPenalty;
    }

    public int getAccusedCommentId() {
        return accusedCommentId;
    }

    public void setAccusedCommentId(int accusedCommentId) {
        this.accusedCommentId = accusedCommentId;
    }

    public AccusedDefenceManager getAccusedDefenceManager() {
        return accusedDefenceManager;
    }

    public void setAccusedDefenceManager(AccusedDefenceManager accusedDefenceManager) {
        this.accusedDefenceManager = accusedDefenceManager;
    }

    public String getDescriptionOfAccusation() {
        return descriptionOfAccusation;
    }

    public void setDescriptionOfAccusation(String descriptionOfAccusation) {
        this.descriptionOfAccusation = descriptionOfAccusation;
    }

    public String getDescriptionOfPenalty() {
        return descriptionOfPenalty;
    }

    public void setDescriptionOfPenalty(String descriptionOfPenalty) {
        this.descriptionOfPenalty = descriptionOfPenalty;
    }

    public ArrayList<EyeWitnessModel> getEyeWitnessesList() {
        return eyeWitnessesList;
    }

    public void setEyeWitnessesList(ArrayList<EyeWitnessModel> eyeWitnessesList) {
        this.eyeWitnessesList = eyeWitnessesList;
    }

    public DisciplineRequestModel getDisciplineRequestModel() {
        return disciplineRequestModel;
    }

    public void setDisciplineRequestModel(DisciplineRequestModel disciplineRequestModel) {
        this.disciplineRequestModel = disciplineRequestModel;
    }

    public String getDocReferenceNumber() {
        return docReferenceNumber;
    }

    public void setDocReferenceNumber(String docReferenceNumber) {
        this.docReferenceNumber = docReferenceNumber;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void radioGroupAccusationAcceptance_processValueChange(ValueChangeEvent vce) {
        acceptAccusation = vce.getNewValue().toString();
    }

    public void radioGroupPenaltyAcceptance_processValueChange(ValueChangeEvent vce) {
        acceptPenalty = vce.getNewValue().toString();
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AttendancePage getAttendance$AttendancePage() {
        return (AttendancePage) getBean("Attendance$AttendancePage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ComplaintPage1 getEmployeeHistory$ComplaintPage1() {
        return (ComplaintPage1) getBean("EmployeeHistory$ComplaintPage1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ExamQuestions getRecruitment$ExamQuestions() {
        return (ExamQuestions) getBean("Recruitment$ExamQuestions");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireRequestPage getTermination$RetireRequestPage() {
        return (RetireRequestPage) getBean("Termination$RetireRequestPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template getHelp$Template() {
        return (fphrms.Help.Template) getBean("Help$Template");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected EvaluationResultPage getEmployeeHistory$EvaluationResultPage() {
        return (EvaluationResultPage) getBean("EmployeeHistory$EvaluationResultPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template_1 getTemplate_1() {
        return (Template_1) getBean("Template_1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireApprovalPage getTermination$RetireApprovalPage() {
        return (RetireApprovalPage) getBean("Termination$RetireApprovalPage");
    }

    public String btnClosePopupEyeWitnesses_action() {
        pnlEyeWitnessesRegistration.setRendered(false);
        return null;
    }

    private boolean populateWitnessTextComponents(String employeeID) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeID);
        if (empInfoHashMap != null) {
            if (!empInfoHashMap.get("employeeId").toString().equals("-1")) {
                witnessId = empInfoHashMap.get("employeeId").toString();
                txtWitnessDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtWitnessFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtWitnessId.setValue(employeeID);
                txtWitnessPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
            return false;
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void clearEyeWitnessTextComponents() {
        txtWitnessId.setValue(null);
        txtWitnessDepartment.setValue(null);
        txtWitnessFullName.setValue(null);
        txtWitnessPosition.setValue(null);
        requesterId = null;
    }

    public String btnSearchWitness_action() {
        if (txtWitnessId.getValue() != null) {
            witnessId = txtWitnessId.getValue().toString();
            if (!populateRequesterTextComponents(witnessId)) {
                witnessId = "-1";
            }
        }
        return null;
    }
    int selectedRowEyeWitness = -1;

    public String cmdLnkRemoveEntry_action() {
        if (eyeWitnessesList.get(selectedRowEyeWitness).getDatabaseStatus().equals("New")) {
            eyeWitnessesList.remove(selectedRowEyeWitness);
        } else {
            if (!eyeWitnessesList.get(selectedRowEyeWitness).getPointedByRequester().equalsIgnoreCase("Yes")) {
                eyeWitnessesList.get(selectedRowEyeWitness).setDatabaseStatus("Deleted");
            } else {
                eyeWitnessesList.get(selectedRowEyeWitness).setPointedByAccused("No");
            }
        }
        return null;
    }

    public String btnResetWitnesses_action() {
        clearEyeWitnessTextComponents();
        return null;
    }

    public String btnSaveWitnesses_action() {
        if (eyeWitnessManager.saveEyeWitnesses(eyeWitnessesList, disciplineProblemId, "Employee")) {
            showSuccessOrFailureMessage(true, "SAVING OKAY");
            pnlEyeWitnessesRegistration.setRendered(false);
        } else {
            showSuccessOrFailureMessage(false, "SAVING FAILED");
            pnlEyeWitnessesRegistration.setRendered(false);
        }

        return null;
    }

    private boolean checkAvailablityOfEyeWitness() {
        for (EyeWitnessModel currentWitness : eyeWitnessesList) {
            if (currentWitness.getWitnessId().equals(witnessId)) {
                if (currentWitness.getDatabaseStatus().equals("Old") || currentWitness.getDatabaseStatus().equals("Deleted")) {
                    currentWitness.setDatabaseStatus("Edited");
                    currentWitness.setPointedByAccused("Yes");
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public String btnAddWinessToTable_action() {
        if (!(witnessId == null || witnessId.equals("-1"))) {
            if (checkAvailablityOfEyeWitness()) {
                eyeWitnessModel = new EyeWitnessModel(disciplineProblemId, witnessId, txtWitnessFullName.getValue().toString(), txtWitnessDepartment.getValue().toString(), "New", "Yes", "No", "Employee");
                eyeWitnessesList.add(eyeWitnessModel);
                clearEyeWitnessTextComponents();
            }
        }
        return null;
    }
    String witnessId;

    public String txtWitnessFullName_action() {
        clearEyeWitnessTextComponents();
        witnessId = ApplicationBean1.getSelectedEmployeeId();
        populateWitnessTextComponents(witnessId);
        return null;
    }

    private void renderPreviosDescisionLink(String currentStatus) {

        if (!currentStatus.equals(DisciplineApproveManager.INITIAL_STATE_DISCIPLINE)) {

            populateDecisionHistory(disciplineProblemId);
            lnkViewPrevieousDecisions.setRendered(true);
        } else {
            lnkViewPrevieousDecisions.setRendered(false);
        }
    }

    public String lnkRecordEyeWitnesses_action() {
        eyeWitnessesList = eyeWitnessManager.getEyeWitnessesList(disciplineProblemId);
        pnlEyeWitnessesRegistration.setRendered(true);
        return null;
    }

    public void selectPending_processValueChange(ValueChangeEvent vce) {
        // String info = " disciplineProblemId  " + disciplineProblemId + "\n" + "requesterId  " + requesterId + "\n" + "currentStatus  " + currentStatus;
        String[] requestInfos = vce.getNewValue().toString().split("--");
        disciplineProblemId = Integer.parseInt(requestInfos[0]);//
        requesterId = requestInfos[1];
        status = requestInfos[2];
        offenceType = requestInfos[3];
        empoyeeStatus = requestInfos[4];
        

          if (empoyeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);
                    populateAllComponents(disciplineRequestModel);
                } else if(empoyeeStatus.equalsIgnoreCase("Normal")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
                    populateAllComponents(disciplineRequestModel);
                }

      //  disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
        //populateAllComponents(disciplineRequestModel);

    }

    private void populateAllComponents(DisciplineRequestModel disciplineRequestModel) {

        populateRequesterTextComponents(disciplineRequestModel.getRequesterId());
        populateEmployeeTextComponents(disciplineRequestModel.getOffenderId());
        populateDisciplineTextComponents(disciplineRequestModel);
        populateDecisionHistory(disciplineRequestModel.getDisciplineProblemId());
    }

    public void selectHistory_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        disciplineProblemId = Integer.parseInt(requestInfos[0]);//
        requesterId = requestInfos[1];
        status = requestInfos[2];
        offenceType = requestInfos[3];
        empoyeeStatus = requestInfos[4];
          if (empoyeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);
                    populateAllComponents(disciplineRequestModel);
                } else if(empoyeeStatus.equalsIgnoreCase("Normal")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
                    populateAllComponents(disciplineRequestModel);
                }
        
        
      //  disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
     //populateAllComponents(disciplineRequestModel);




    }

    // <editor-fold defaultstate="collapsed" desc="Links">
    public String lnkDisciplineRequest_action() {
        return "DisciplineIssue";
    }

    public String lnkDisciplineApprove_action() {
        return "DisciplineApprove";
    }

    public String lnkAccusedDefence_action() {
        return "AccusedDefence";
    }

    public String lnkEyeWitness_action() {
        return "EyeWitness";
    }

    public String lnkCommitteeMembers_action() {
        return "CommitteeMembers";
    }

    public String lnkDisciplinePenalty_action() {
        return "PenaltyTypes";
    }

    public String lnkCommittee_action() {
        return "Committeee";
    }

    public String btnDisciplinePenalty_action() {
        return "DisciplinePenalty";
    }

    public String btnPenaltyType_action() {
        return "PenaltyTypes";
    }

    public String btnClosePopupViewPrevieousDecisions_action() {
        //return null means stay on the same page
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String lnkViewPrevieousDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }
   public void setFile(){



   }
    public void inputFile_ForComment_processAction(ActionEvent ae) {

          try {
            int index = 0;
           
            InputFile inpuFile = (InputFile) ae.getSource();
            FileInfo fileInfo = inpuFile.getFileInfo();
            filePath = fileInfo.getPhysicalPath().toString();
            File file = new File(filePath);
            fileExtenstion = file.getName();
            index = fileExtenstion.lastIndexOf(".");
            fileExtenstion = fileExtenstion.substring(index + 1);
            setCommeentsFile(AccusedDefenceManager.extractByteArray(file));
            fileUpLoad.setRequestID(disciplineProblemId);
            fileUpLoad.setFileName("Commentes");
            fileUpLoad.setExtention(fileExtenstion);
            fileUpLoad.setAttachedFile(AccusedDefenceManager.extractByteArray(file));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    public void inputFile_IntersetAttache_processAction(ActionEvent ae) {
        try {
            int index = 0;
            
            InputFile inpuFile = (InputFile) ae.getSource();
            FileInfo fileInfo = inpuFile.getFileInfo();
            filePath = fileInfo.getPhysicalPath().toString();
            File file = new File(filePath);
            fileExtenstion = file.getName();
            index = fileExtenstion.lastIndexOf(".");
            fileExtenstion = fileExtenstion.substring(index + 1);
            setIntersetFile(AccusedDefenceManager.extractByteArrayForInterset(file));
            fileUpLoadInterset.setRequestIDInterset(disciplineProblemId);
            fileUpLoadInterset.setFileNameInterset("IntersetOfAccused");
            fileUpLoadInterset.setExtentionInterset(fileExtenstion);
            fileUpLoadInterset.setAttachedFileInterset(AccusedDefenceManager.extractByteArrayForInterset(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   


   // </editor-fold >
}
