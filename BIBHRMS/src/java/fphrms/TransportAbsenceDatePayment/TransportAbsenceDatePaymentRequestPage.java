/*
 * TransportAbsenceDateRegistrationPage.java
 *
 * Created on Dec 14, 2012, 2:51:51 AM
 * Copyright Henok
 */
package fphrms.TransportAbsenceDatePayment;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.Routines.IncrementSalaryReports;
import fphrms.Look_Up.LuRankAndPayGradPage;
import fphrms.TestJsp.Page1;
import fphrms.Leave.ManageEmployeeLeaveStatus;
import fphrms.Routines.FilterCandidate;
import fphrms.Leave.LeaveSettlementPage1;
import fphrms.Recruitment.CandidateExperiences;
import fphrms.pageSecurity.LoginPage;
import fphrms.Routines.Advertisment;
import fphrms.Employee.EmployeeWillPage;
import fphrms.Routines.ApprovedRecruitmentRequest;
import fphrms.Leave.LeaveSettlemen;
import fphrms.ApplicationBean1;
import fphrms.Discipline.Template_1;
import fphrms.Discipline.DisciplineRequestReport;
import fphrms.Routines.PromotionFilterCandidateReport;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import fphrms.Routines.PromorTransfercandidateReg;
import fphrms.Discipline.RejectedDisciplineReport;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.TransportAbsenceDatePaymentManager.TransportPaymentsModel;
import manager.TransportAbsenceDatePaymentManager.TransportPaymentRequestManager;
import manager.TransportAbsenceDatePaymentManager.TransportAbsenceDateRegistrationManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;
import manager.leaveManager.LeaveControl;
import manager.overTimeManager.MgrEmployeeShiftViewer;
import manager.overTimeManager.ShiftTimeRegManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TransportAbsenceDatePaymentRequestPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    ArrayList<SelectItem> sel = new ArrayList<SelectItem>();
    ArrayList<SelectItem> serviceList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<TransportPaymentsModel> requestModelList = new ArrayList<TransportPaymentsModel>();
    ArrayList<TransportPaymentsModel> empLocModelList = new ArrayList<TransportPaymentsModel>();
    ArrayList<TransportPaymentsModel> serviceAbsentModelList = new ArrayList<TransportPaymentsModel>();
    ArrayList<TransportPaymentsModel> serviceInformation = new ArrayList<TransportPaymentsModel>();
    ArrayList<TransportPaymentsModel> totalEmpAbsenceDateList = new ArrayList<TransportPaymentsModel>();
    ArrayList<TransportPaymentsModel> empAbsenceDateList = new ArrayList<TransportPaymentsModel>();
    ShiftTimeRegManager shftmgr = new ShiftTimeRegManager();
    EmployeeManage employeeManager = new EmployeeManage();
    TransportPaymentRequestManager transportAbsenceDatePaymentRequestManager = new TransportPaymentRequestManager();
    TransportAbsenceDateRegistrationManager transportAbsenceDateRegistrationManager = new TransportAbsenceDateRegistrationManager();
    MgrEmployeeShiftViewer shft = new MgrEmployeeShiftViewer();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean selectedColumnRendered = false;
    ArrayList<TransportPaymentsModel> serviceAbsenceDateList = new ArrayList<TransportPaymentsModel>();
    TransportPaymentsModel transportAbsenceDatePaymentModel = new TransportPaymentsModel();
    StringDateManipulation stringDateManipulation = new StringDateManipulation();
    String newOrEditOrUpdateLabel = "Save";
    String requesterId;
    String userName;
    String loggedInEmployeeId;
    int transportPaymentRequestId = -1;
    String status;//STATUS
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();

    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userName = getSessionBean1().getUserName();
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        sel = shftmgr.selectShiftRegistration();
        serviceList = transportAbsenceDateRegistrationManager.getServiceList();
        txtAppliedDate.setValue(dateFormat.format(new Date()));
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate calStartDate) {
        this.calStartDate = calStartDate;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate calEndDate) {
        this.calEndDate = calEndDate;
    }

    public ArrayList<SelectItem> getSel() {
        return sel;
    }

    public void setSel(ArrayList<SelectItem> sel) {
        this.sel = sel;
    }

    public ArrayList<SelectItem> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<SelectItem> serviceList) {
        this.serviceList = serviceList;
    }

    public ArrayList<TransportPaymentsModel> getRequestModelList() {
        return requestModelList;
    }

    public void setRequestModelList(ArrayList<TransportPaymentsModel> requestModelList) {
        this.requestModelList = requestModelList;
    }

    public ArrayList<TransportPaymentsModel> getServiceAbsenceDateList() {
        return serviceAbsenceDateList;
    }

    public void setServiceAbsenceDateList(ArrayList<TransportPaymentsModel> serviceAbsenceDateList) {
        this.serviceAbsenceDateList = serviceAbsenceDateList;
    }
    private HtmlDataTable dataTable = new HtmlDataTable();

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable hdt) {
        this.dataTable = hdt;
    }
    private PanelLayout panelLayout3 = new PanelLayout();

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlCommandButton btnStartDate = new HtmlCommandButton();

    public HtmlCommandButton getbtnCalender() {
        return btnStartDate;
    }

    public void setbtnCalender(HtmlCommandButton hcb) {
        this.btnStartDate = hcb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public boolean isSelectedColumnRendered() {
        return selectedColumnRendered;
    }

    public void setSelectedColumnRendered(boolean selectedColumnRendered) {
        this.selectedColumnRendered = selectedColumnRendered;
    }
    private HtmlSelectBooleanCheckbox ckbForColumnSelected = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbForColumnSelected() {
        return ckbForColumnSelected;
    }

    public void setCkbForColumnSelected(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbForColumnSelected = hsbc;
    }
    private HtmlSelectOneMenu drlShift = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlShift() {
        return drlShift;
    }

    public void setDrlShift(HtmlSelectOneMenu hsom) {
        this.drlShift = hsom;
    }
    private HtmlSelectOneMenu drlServiceDestination = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlServiceDestination() {
        return drlServiceDestination;
    }

    public void setDrlServiceDestination(HtmlSelectOneMenu hsom) {
        this.drlServiceDestination = hsom;
    }

    public TransportPaymentsModel getTransportAbsenceDatePaymentModel() {
        return transportAbsenceDatePaymentModel;
    }

    public void setTransportAbsenceDatePaymentModel(TransportPaymentsModel transportAbsenceDatePaymentModel) {
        this.transportAbsenceDatePaymentModel = transportAbsenceDatePaymentModel;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
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
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText sit) {
        this.txtRequesterFullName = sit;
    }

    public ArrayList<SelectItem> getPendingRequestList() {
        return pendingRequestList;
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
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }

    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox selectMyHistoryLists) {
        this.selectMyHistoryLists = selectMyHistoryLists;
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
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
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
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }


    public TransportAbsenceDatePaymentRequestPage() {
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
    @Override
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
            log("TransportAbsenceDateRegistrationPage Initialization Failure", e);
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
        if(pendingRequestList .isEmpty()){
           pendingRequestList = transportAbsenceDatePaymentRequestManager.getPendingRequests(loggedInEmployeeId);// new ArrayList<SelectItem>();
        }else{
        }
        if(requestHistoryList .isEmpty()){
           requestHistoryList = transportAbsenceDatePaymentRequestManager.getMyRequestsHistory(loggedInEmployeeId);// new ArrayList<SelectItem>();
        }else{
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
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IncrementSalaryReports getRoutines$IncrementSalaryReports() {
        return (IncrementSalaryReports) getBean("Routines$IncrementSalaryReports");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected LuRankAndPayGradPage getLook_Up$LuRankAndPayGradPage() {
        return (LuRankAndPayGradPage) getBean("Look_Up$LuRankAndPayGradPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Page1 getTestJsp$Page1() {
        return (Page1) getBean("TestJsp$Page1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ManageEmployeeLeaveStatus getLeave$ManageEmployeeLeaveStatus() {
        return (ManageEmployeeLeaveStatus) getBean("Leave$ManageEmployeeLeaveStatus");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected FilterCandidate getRoutines$FilterCandidate() {
        return (FilterCandidate) getBean("Routines$FilterCandidate");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected LeaveSettlementPage1 getLeave$LeaveSettlementPage1() {
        return (LeaveSettlementPage1) getBean("Leave$LeaveSettlementPage1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CandidateExperiences getRecruitment$CandidateExperiences() {
        return (CandidateExperiences) getBean("Recruitment$CandidateExperiences");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected LoginPage getpageSecurity$LoginPage() {
        return (LoginPage) getBean("pageSecurity$LoginPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Advertisment getRoutines$Advertisment() {
        return (Advertisment) getBean("Routines$Advertisment");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected EmployeeWillPage getEmployee$EmployeeWillPage() {
        return (EmployeeWillPage) getBean("Employee$EmployeeWillPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApprovedRecruitmentRequest getRoutines$ApprovedRecruitmentRequest() {
        return (ApprovedRecruitmentRequest) getBean("Routines$ApprovedRecruitmentRequest");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected LeaveSettlemen getLeave$LeaveSettlemen() {
        return (LeaveSettlemen) getBean("Leave$LeaveSettlemen");
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
   

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template_1 getDiscipline$Template_1() {
        return (Template_1) getBean("Discipline$Template_1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected DisciplineRequestReport getDiscipline$DisciplineRequestReport() {
        return (DisciplineRequestReport) getBean("Discipline$DisciplineRequestReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PromotionFilterCandidateReport getRoutines$PromotionFilterCandidateReport() {
        return (PromotionFilterCandidateReport) getBean("Routines$PromotionFilterCandidateReport");
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
    protected fphrms.Look_Up.Page1 getLook_Up$Page1() {
        return (fphrms.Look_Up.Page1) getBean("Look_Up$Page1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PromorTransfercandidateReg getRoutines$PromorTransfercandidateReg() {
        return (PromorTransfercandidateReg) getBean("Routines$PromorTransfercandidateReg");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RejectedDisciplineReport getDiscipline$RejectedDisciplineReport() {
        return (RejectedDisciplineReport) getBean("Discipline$RejectedDisciplineReport");
    }

    public String btnStartDate_action() {
        //return null means stay on the same page
        calStartDate.setRendered(true);
        return null;
    }

    public String btnEndDate_action() {
        //return null means stay on the same page
        calEndDate.setRendered(true);
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        txtEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calEndDate.setRendered(false);
    }

//    public String btnAddToTable_action() {
//        //return null means stay on the same page
//        transportAbsenceDatePaymentModel = new TransportAbsenceDatePaymentModel(drlServiceDestination.getValue().toString().split("-")[0], drlServiceDestination.getValue().toString().split("-")[1], drlShift.getValue().toString(), txtStartDate.getValue().toString(), "New");
//        serviceAbsenceDateList.add(transportAbsenceDatePaymentModel);
//        return null;
//    }
    private void makePageReadyForSave() {
        newOrEditOrUpdateLabel = "Save";
//        overTimeRequestId = -1;
//        enableButtons();
//        enableRequestTextComponents();
//        enableRequestGeneralAttributes();
    }

    private void makePageReadyForUpdate() {
        newOrEditOrUpdateLabel = "Update";
        btnSave.setDisabled(false);
//        buttonAction = "Update";
//        statusColumnRendered = true;
//        selectedColumnRendered = false;
//        lnkViewPrevieousDecisions.setRendered(false);
//        selectedRequestFromHistoryList.setSelectedObject(null);
//        enableButtons();
//        enableRequestTextComponents();
//        enableParticipantTextComponents();
//        enableRequestGeneralAttributes();

    }

    private void makePageReadyForView() {
        newOrEditOrUpdateLabel = "Save";
        btnSave.setDisabled(true);
//        buttonAction = "None";
//        statusColumnRendered = false;
//        selectedColumnRendered = true;
//        lnkViewPrevieousDecisions.setRendered(true);
//        selectedRequestFromMyRequestList.setSelectedObject(null);
//        disableButtons();
//        disableRequestTextComponents();
//        disableParticipantTextComponents();
//        disableRequestGeneralAttributes();
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        return null;
    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                clearRequestComponents();
                requesterId = null;
                return false;
            } else {
                requesterId = employeeId;
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(requesterId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
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

    private void clearRequestComponents() {
//        employeeId = null;
//        txtaReasonDescription.setValue(null);
        selectOneMenu1Bean.setSelectedObject(null);
//        selectObjectOfReasonSummary.setSelectedObject(null);
//        txtRequesterDepartment.setValue(null);
        txtStartDate.setValue(null);
//        txtStartTime.setValue(null);
        txtEndDate.setValue(null);
//        txtEndTime.setValue(null);
//        drlOverTimeFactor.setValue("");
//        drlOverTimeFactor.resetValue();
//        drlOverTimeFactor.setValue("");
//        drlReasonSummary.resetValue();
    }

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

    public String btnReset_action() {
        //return null means stay on the same page
        clearAllComponents();
        makePageReadyForSave();
        return null;
    }

    public String btnSave_action() {
        //return null means stay on the same page
        if (transportAbsenceDatePaymentRequestManager.saveTransportPayment(requestModelList, txtRequesterId.getValue().toString(), txtAppliedDate.getValue().toString(), txtStartDate.getValue().toString(), txtEndDate.getValue().toString(), userName)) {
            showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
        }
        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    private void clearAllComponents() {
//        overTimeRequestId = -1;
        drlServiceDestination.setValue("");
        drlShift.setValue("");
        txtStartDate.setValue(null);
        txtEndDate.setValue(null);
        txtAppliedDate.setValue(null);
        requestModelList = new ArrayList<TransportPaymentsModel>();
    }

    private boolean populateTransportAbsenceDateList() {
        serviceAbsenceDateList = transportAbsenceDateRegistrationManager.getTransportAbsenceDates();
        return true;
    }

//    public String btnShowPrevious_action() {
//        //return null means stay on the same page
//        makePageReadyForUpdate();
//        populateTransportAbsenceDateList();
//        return null;
//    }
    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null && !vce.getNewValue().toString().equals("-1")) {
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            clearAllComponents();
            transportPaymentRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            status = requestAttributes[2];
//            String loginId = overTimeRequestManager.getLoginId(overTimeRequestId);
            populateRequesterTextComponents(requesterId);
//            populateLoginTextComponents(loginId);
            populateParticipantTable(transportPaymentRequestId);
            populateRequestAttributes(transportPaymentRequestId);
            makePageReadyForUpdate();
        }
    }

//    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
//        if (vce != null && !vce.getNewValue().toString().equals("-1")) {
//            String requestAttributes[] = vce.getNewValue().toString().split("--");
//            overTimeRequestId = Integer.parseInt(requestAttributes[0]);
//            requesterId = requestAttributes[1];
//            status = requestAttributes[2];
//            String loginId = overTimeRequestManager.getLoginId(overTimeRequestId);
//            clearAllComponents();
//            populateParticipantTextComponents(requesterId);
//            populateLoginTextComponents(loginId);
//            populateParticipantTable(overTimeRequestId);
//            populateRequestAttributes(overTimeRequestId);
//            makePageReadyForView();
//        }
//    }
    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null && !vce.getNewValue().toString().equals("-1")) {
            clearAllComponents();
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            transportPaymentRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            status = requestAttributes[2];
//            String loginId = overTimeRequestManager.getLoginId(overTimeRequestId);
            populateRequesterTextComponents(requesterId);
//            populateLoginTextComponents(loginId);
            populateParticipantTable(transportPaymentRequestId);
            populateRequestAttributes(transportPaymentRequestId);
            if(status.contains("Res")) {
            makePageReadyForUpdate();
            }else {
            makePageReadyForView();
            }
//            makePageReadyForView();
        }
    }

    private boolean populateParticipantTable(int transportPaymentRequestId) {
        requestModelList.clear();
        requestModelList = transportAbsenceDatePaymentRequestManager.getEmployeeAndTransportPaymentList(transportPaymentRequestId);
        return true;
    }

    private boolean populateRequestAttributes(int transportPaymentRequestId) {
        transportAbsenceDatePaymentModel = transportAbsenceDatePaymentRequestManager.getRequestAttributes(transportPaymentRequestId);
        if (transportAbsenceDatePaymentModel != null) {
            if (transportAbsenceDatePaymentModel.getTransportPaymentId() != -1) {
                txtStartDate.setValue(transportAbsenceDatePaymentModel.getStartDate());
                txtEndDate.setValue(transportAbsenceDatePaymentModel.getEndDate());
                txtAppliedDate.setValue(transportAbsenceDatePaymentModel.getRequestDate());
                return true;
            } else {//no exception but no result set from db
                showSuccessOrFailureMessage(false, " NO REQUEST ATTRIBUTE FOUND ");//over time request no
                return false;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
        return false;
    }

    public String btnCalcPayment_action() {
        //return null means stay on the same page
        requestModelList.clear();
        makePageReadyForSave();
        populateTransportAbsenceDateList();
        empLocModelList = transportAbsenceDatePaymentRequestManager.getAllEmployeeLocationList();
        double daysInMonth = 0;
        try {
//        daysInMonth = StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString());
        double paymentForSAbsence = 0.0;
        double paymentForSAbsenceRound = 0.0;
        double paymentForNoTransport = 0.0;
        double paymentForNoTransportRound = 0.0;
        double totalPayment = 0.0;
        double totalPaymentRound = 0.0;
       DecimalFormat df = new DecimalFormat("#.##");
//            Iterator<TransportAbsenceDatePaymentModel> ittNewNo = empLocModelList.iterator();
//            while (ittNewNo.hasNext()) {

//        Iterator<EducationCostModel> ittkmpList = trainingCostList.iterator();
//        while (ittkmpList.hasNext() && !checkAminLists) {
//            EducationCostModel singlePosIdVal = ittkmpList.next();
//            if ((singlePosIdVal.getCostTypeCategory().toString().equals(posId))) {
//                checkAminLists = true;
//
//            }
//        }
        Iterator<TransportPaymentsModel> ittNewNo = empLocModelList.iterator();
        while (ittNewNo.hasNext()){
            daysInMonth = StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString());
//               for(TransportAbsenceDatePaymentModel obj:empLocModelList){
            TransportPaymentsModel singleEmployee = ittNewNo.next();
            DateFormat formatter;
            Date startDate;
            Date endDate;
//        String start = txtStartDate.getValue().toString();
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            startDate = (Date) formatter.parse(txtStartDate.getValue().toString());
            endDate = (Date) formatter.parse(txtEndDate.getValue().toString());
            Calendar startCal;
            Calendar endCal;
            startCal = Calendar.getInstance();
            startCal.setTime(startDate);
            endCal = Calendar.getInstance();
            endCal.setTime(endDate);

            endCal.getTime();


            SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
            JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
//            String x=dateformatter.format(startCal.getTime());
//            String y=dateformatter.format(endCal.getTime());
            //Return 0 if start and end are the same
            if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
                return null;
            }

            if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
                startCal.setTime(endDate);
                endCal.setTime(startDate);
            }
            String shName;
//            Iterator<TransportAbsenceDatePaymentModel> ittNewNo = empLocModelList.iterator();
//            while (ittNewNo.hasNext()) {

//                TransportAbsenceDatePaymentModel transportPaymentModel = ittNewNo.next();
                String empId = singleEmployee.getEmpId();
                String empName = null;
                int locationId = singleEmployee.getLocationId();
                String serviceId = null;
                int id  = 0;
                double extraTarif = 0.0;
                double tarif = 0.0;
                String serviceDestination = null;
                HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(empId);
                empName = empInfoHashMap.get("employeeFullName").toString();
                if(empName.equalsIgnoreCase("")){
                    empName = empId;
                }

                serviceInformation = transportAbsenceDatePaymentRequestManager.getServiceInformation(locationId);

                 for(TransportPaymentsModel serviceIdExtraTarif:serviceInformation){
                serviceId = serviceIdExtraTarif.getServiceId();
                extraTarif = serviceIdExtraTarif.getExtraPaymentPerDay();
                serviceDestination = serviceIdExtraTarif.getActualLocation();
                 }
                 id = Integer.parseInt(serviceId);
                tarif = transportAbsenceDatePaymentRequestManager.getTarif(id);

//                HashMap shiftName = shft.selectShiftRegistration(empId);
//                shName = shiftName.get("Shift").toString();
                 shName = shft.selectShiftRegistrations(empId);
//                shName = shiftName;
                 HashMap shiftName = null;
                double transportAbsenteDate = 0;
                double employeeAbsenteDate = 0;
                double totalEmpAbesntDays = 0;
//                int shCounter = 1;
//                String shCount="";
//                int dateDiff = 0;
//                String address = null;
//                HashMap list_shifts = null;
//                int counter = 0;
//                int no_of_shifts = 0;
//                String shift = "SH";
//                do {
//                    startCal.add(Calendar.DAY_OF_MONTH, 1);
//                    String strDate = dateformatter.format(startCal.getTime());
                    if ((shName.equalsIgnoreCase("Shift")) || (shName.equalsIgnoreCase("Office")) || (shName.equalsIgnoreCase("null"))) {

                        do {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    String strDate = dateformatter.format(startCal.getTime());
                        serviceAbsentModelList.clear();
                        serviceAbsentModelList = transportAbsenceDateRegistrationManager.getAllTransportAbsenteDateList(serviceId, "SH1", strDate);
                        totalEmpAbsenceDateList = transportAbsenceDatePaymentRequestManager.getAllEmployeeAbsenteDateList(empId, strDate);
                        if (serviceAbsentModelList.size() != 0) {
                            empAbsenceDateList.clear();
                            empAbsenceDateList = transportAbsenceDatePaymentRequestManager.getAllEmployeeAbsenteDateList(empId, strDate);
                            for (TransportPaymentsModel x: serviceAbsentModelList) {
                                if (x.getInOut().equalsIgnoreCase("BOTH")){
                            transportAbsenteDate = transportAbsenteDate + 1;
                            if (empAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: empAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       employeeAbsenteDate = employeeAbsenteDate + 1;
                                    } else if(y.getStatus().equalsIgnoreCase("MORNING")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("AFTERNOON")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;

                                }
                               }
                             }
                           } else if (x.getInOut().equalsIgnoreCase("IN")){
                               transportAbsenteDate = transportAbsenteDate + 0.5;
                               if (empAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: empAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("MORNING")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    }

                                }

                             }

                           } else if (x.getInOut().equalsIgnoreCase("OUT")){
                               transportAbsenteDate = transportAbsenteDate + 0.5;
                               if (empAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: empAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("AFTERNOON")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    }

                                }

                             }

                           } else {

                           }



                          }
                        }
                        if (totalEmpAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: totalEmpAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       totalEmpAbesntDays = totalEmpAbesntDays + 1;
                                    } else if(y.getStatus().equalsIgnoreCase("MORNING")){
                                       totalEmpAbesntDays = totalEmpAbesntDays + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("AFTERNOON")){
                                       totalEmpAbesntDays = totalEmpAbesntDays + 0.5;

                                }
                               }
                             }
                        if((checkHolidayButNotWeekend(strDate)) || (checkSunday(strDate))){
                        daysInMonth = daysInMonth -1;
                        }
                        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

                        paymentForSAbsence = (transportAbsenteDate - employeeAbsenteDate)* tarif;
                        paymentForSAbsenceRound = Double.parseDouble(df.format(paymentForSAbsence));
                paymentForNoTransport = (daysInMonth - totalEmpAbesntDays)*extraTarif;
                paymentForNoTransportRound = Double.parseDouble(df.format(paymentForNoTransport));
                totalPayment = paymentForSAbsence + paymentForNoTransport;
                totalPaymentRound = Double.parseDouble(df.format(totalPayment));
                transportAbsenceDatePaymentModel = new TransportPaymentsModel(1,serviceDestination,empId,empName,transportAbsenteDate, employeeAbsenteDate, tarif, paymentForSAbsenceRound, daysInMonth, totalEmpAbesntDays, extraTarif, paymentForNoTransportRound, totalPaymentRound);
              requestModelList.add(transportAbsenceDatePaymentModel);

                    } else {

                    String address = null;
                    HashMap list_shifts = null;
                    String shCount="";
//                    do {
//                        shift = "SH";
//                    startCal.add(Calendar.DAY_OF_MONTH, 1);
//                    String strDate = dateformatter.format(startCal.getTime());

//                        String empDept = transportAbsenceDatePaymentRequestManager.getEmpDept(empId);
                        String empLocation = transportAbsenceDatePaymentRequestManager.getEmpLocation(empId);
//                        empDept = empDept.substring(empDept.indexOf("("), empDept.lastIndexOf(")"));
                        if(empLocation.equalsIgnoreCase("Mugher")){
                            address = "MU";
                        }else if(empLocation.equalsIgnoreCase("Addis Ababa")){
                            address = "AA";
                        } else if(empLocation.equalsIgnoreCase("Derba")){
                            address = "DR";
                        }else if(empLocation.equalsIgnoreCase("Nazareth")){
                            address = "NZ";
                        }else if(empLocation.equalsIgnoreCase("Tatek")){
                            address = "TA";
                        }
//                        list_shifts = shft.selectShifts(shiftName.get("Shift").toString(),address);
//                        String shCount = shiftName.get("Shift").toString().substring(2, 3);
                        list_shifts = shft.selectShifts(shName,address);
                        shCount = shName.substring(2, 3);
                        if ((shCount.equals("1")) || (shCount.equals("2")) || (shCount.equals("3"))) {
                            do {
                                int shCounter = 1;
//                String shCount="";
                                int dateDiff = 0;
//                String address = null;
//                HashMap list_shifts = null;
                                int counter = 0;
                                int no_of_shifts = 0;
                                String shift = "SH";
                                String strDate = dateformatter.format(startCal.getTime());
                        serviceAbsentModelList.clear();
//                        serviceAbsentModelList = transportAbsenceDateRegistrationManager.getAllTransportAbsenteDateList(serviceId, "SH1", strDate);
                        totalEmpAbsenceDateList = transportAbsenceDatePaymentRequestManager.getAllEmployeeAbsenteDateList(empId, strDate);
//                        startCal.add(Calendar.DAY_OF_MONTH, 1);
                            shCounter = Integer.parseInt(shCount);
                            dateDiff = StringDateManipulation.compareDateDifference(list_shifts.get("REGISTERED_DATE").toString(), strDate);
                            no_of_shifts = shft.selectAllShifts(address).size();
//            float no_of_holidays;
//            no_of_holidays = Integer.valueOf(dateDiff / 7);
                            //dateDiff = (int) (dateDiff - no_of_holidays);
                            for (int i = 0; i < dateDiff; i++) {
                                counter++;
                                if (counter == 2) {
                                    if (shCounter == no_of_shifts) {
                                        shCounter = 1;
                                    } else {
                                        shCounter += 1;
                                    }
                                    counter = 0;
                                }
                            }
//            if (insideLoop.equalsIgnoreCase("entered")) {
                            shift = shift.concat(Integer.valueOf(shCounter).toString());
//                get shft on the next date
                            serviceAbsentModelList = transportAbsenceDateRegistrationManager.getAllTransportAbsenteDateList(serviceId, shift, strDate);
                        if (serviceAbsentModelList.size() != 0) {
                            empAbsenceDateList = transportAbsenceDatePaymentRequestManager.getAllEmployeeAbsenteDateList(empId, strDate);
                            for (TransportPaymentsModel x: serviceAbsentModelList) {
                                if (x.getInOut().equalsIgnoreCase("BOTH")){
                            transportAbsenteDate = transportAbsenteDate + 1;
                            if (empAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: empAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       employeeAbsenteDate = employeeAbsenteDate + 1;
                                    } else if(y.getStatus().equalsIgnoreCase("MORNING")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("AFTERNOON")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;

                                }
                               }
                             }
                           } else if (x.getInOut().equalsIgnoreCase("IN")){
                               transportAbsenteDate = transportAbsenteDate + 0.5;
                               if (empAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: empAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("MORNING")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    }

                                }

                             }

                           } else if (x.getInOut().equalsIgnoreCase("OUT")){
                               transportAbsenteDate = transportAbsenteDate + 0.5;
                               if (empAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: empAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("AFTERNOON")){
                                       employeeAbsenteDate = employeeAbsenteDate + 0.5;
                                    }

                                }

                             }

                           } else {

                           }



                          }
                        }
                            if (totalEmpAbsenceDateList.size() != 0) {
                                for (TransportPaymentsModel y: totalEmpAbsenceDateList) {
                                    if(y.getStatus().equalsIgnoreCase("FULLDAY")){
                                       totalEmpAbesntDays = totalEmpAbesntDays + 1;
                                    } else if(y.getStatus().equalsIgnoreCase("MORNING")){
                                       totalEmpAbesntDays = totalEmpAbesntDays + 0.5;
                                    } else if(y.getStatus().equalsIgnoreCase("AFTERNOON")){
                                       totalEmpAbesntDays = totalEmpAbesntDays + 0.5;

                                }
                               }
                             }
                        if((checkHolidayButNotWeekend(strDate))){
                        daysInMonth = daysInMonth -1;
                        }
                            startCal.add(Calendar.DAY_OF_MONTH, 1);
                       } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());


//                    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

                    paymentForSAbsence = (transportAbsenteDate - employeeAbsenteDate)* tarif;
                    paymentForSAbsenceRound = Double.parseDouble(df.format(paymentForSAbsence));
                paymentForNoTransport = (daysInMonth - totalEmpAbesntDays)*extraTarif;
                paymentForNoTransportRound = Double.parseDouble(df.format(paymentForNoTransport));
                totalPayment = paymentForSAbsence + paymentForNoTransport;
                totalPaymentRound = Double.parseDouble(df.format(totalPayment));
                transportAbsenceDatePaymentModel = new TransportPaymentsModel(1,serviceDestination,empId,empName,transportAbsenteDate, employeeAbsenteDate, tarif, paymentForSAbsenceRound, daysInMonth, totalEmpAbesntDays, extraTarif, paymentForNoTransportRound, totalPaymentRound);
              requestModelList.add(transportAbsenceDatePaymentModel);
                }
               }
//                paymentForSAbsence = (transportAbsenteDate - employeeAbsenteDate)* tarif;
//                paymentForNoTransport = (daysInMonth - totalEmpAbesntDays)*extraTarif;
//                totalPayment = paymentForSAbsence + paymentForNoTransport;
//                transportAbsenceDatePaymentModel = new TransportAbsenceDatePaymentModel(1,empId,empName,transportAbsenteDate, employeeAbsenteDate, tarif, paymentForSAbsence, daysInMonth, totalEmpAbesntDays, extraTarif, paymentForNoTransport, totalPayment);
//              requestModelList.add(transportAbsenceDatePaymentModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public boolean checkHolidayButNotWeekend(String appliedDateforTraining) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        LeaveControl leaveControl = new LeaveControl();
        return leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(appliedDateforTraining));
    }

    public boolean checkSunday(String appliedDateforTraining) {
//        int dateDiff = 0;
//        dateDiff = StringDateManipulation.compareDateDifference(sunday, appliedDate);
//        if(Integer.valueOf(dateDiff) % 7==0) {return true;}
//        else {return false;}
         return stringDateManipulation.checkSunday(appliedDateforTraining);
    }
}

