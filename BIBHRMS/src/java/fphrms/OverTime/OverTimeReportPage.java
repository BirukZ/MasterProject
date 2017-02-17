package fphrms.OverTime;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
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
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.overTimeManager.OverTimeRequestManager;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class OverTimeReportPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="ALL">
    // <editor-fold defaultstate="collapsed" desc="Gettrs and Setters">
    //

    private int __placeholder;

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getDocReferenceNumber() {
        return docReferenceNumber;
    }

    public void setDocReferenceNumber(String docReferenceNumber) {
        this.docReferenceNumber = docReferenceNumber;
    }

    public ArrayList<SelectItem> getOverTimeFactorList() {
        return overTimeFactorList;
    }

    public void setOverTimeFactorList(ArrayList<SelectItem> overTimeFactorList) {
        this.overTimeFactorList = overTimeFactorList;
    }

    public ArrayList<SelectItem> getAddressCodeList() {
        return addressCodeList;
    }

    public void setAddressCodeList(ArrayList<SelectItem> addressCodeList) {
        this.addressCodeList = addressCodeList;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public OverTimeRequestModel getCurrentRequestModel() {
        return currentRequestModel;
    }

    public void setCurrentRequestModel(OverTimeRequestModel currentRequestModel) {
        this.currentRequestModel = currentRequestModel;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentManage getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManage departmentManager) {
        this.departmentManager = departmentManager;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentPath() {
        return departmentPath;
    }

    public void setDepartmentPath(String departmentPath) {
        this.departmentPath = departmentPath;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getEmployeeId() {
        return participantId;
    }

    public void setEmployeeId(String employeeId) {
        this.participantId = employeeId;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public int getOveTimeRequestId() {
        return overTimeRequestId;
    }

    public void setOveTimeRequestId(int overTimeRequestId) {
        this.overTimeRequestId = overTimeRequestId;
    }

    public double getOverTimeFactor() {
        return overTimeFactor;
    }

    public void setOverTimeFactor(double overTimeFactor) {
        this.overTimeFactor = overTimeFactor;
    }

    public OverTimeRequestManager getOverTimeRequestManager() {
        return overTimeRequestManager;
    }

    public void setOverTimeRequestManager(OverTimeRequestManager overTimeRequestManager) {
        this.overTimeRequestManager = overTimeRequestManager;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public OverTimeRequestModel getRequestAttribute() {
        return requestAttribute;
    }

    public void setRequestAttribute(OverTimeRequestModel requestAttribute) {
        this.requestAttribute = requestAttribute;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        userName = getSessionBean1().getUserName();
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInDepartmentId = getSessionBean1().getEmpDeptId();
        overTimeRequestManager.setUserName(userName);
        overTimeRequestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        overTimeRequestManager.setLoggedInDepartmentId(loggedInDepartmentId);
        pendingRequestList = overTimeRequestManager.getPendingRequests();
        requestHistoryList = overTimeRequestManager.getMyRequestsHistory();
        clearAllComponents();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<OverTimeRequestModel> getRequestModelList() {
        return requestModelList;
    }

    public void setRequestModelList(ArrayList<OverTimeRequestModel> requestModelList) {
        this.requestModelList = requestModelList;
    }
    private HtmlCommandButton btnGenerateReport = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchParticipant() {
        return btnSearchParticipant;
    }

    public void setBtnSearchParticipant(HtmlCommandButton btnSearchParticipant) {
        this.btnSearchParticipant = btnSearchParticipant;
    }
    private HtmlCommandButton btnSearchParticipant = new HtmlCommandButton();

    public HtmlCommandButton getBtnGenerateReport() {
        return btnGenerateReport;
    }

    public void setBtnGenerateReport(HtmlCommandButton hcb) {
        this.btnGenerateReport = hcb;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlInputText txtEndTime = new HtmlInputText();

    public HtmlInputText getTxtEndTime() {
        return txtEndTime;
    }

    public void setTxtEndTime(HtmlInputText hit) {
        this.txtEndTime = hit;
    }
    private HtmlInputText txtStartTime = new HtmlInputText();

    public HtmlInputText getTxtStartTime() {
        return txtStartTime;
    }

    public void setTxtStartTime(HtmlInputText hit) {
        this.txtStartTime = hit;
    }
    private HtmlInputText txtParticipantDepartment = new HtmlInputText();
    private HtmlInputText txtParticipantId = new HtmlInputText();
    private SelectInputText txtParticipantFullName = new SelectInputText();

    public SelectInputText getTxtParticipantFullName() {
        return txtParticipantFullName;
    }

    public void setTxtParticipantFullName(SelectInputText txtParticipantFullName) {
        this.txtParticipantFullName = txtParticipantFullName;
    }
    private HtmlInputText txtParticipantPosition = new HtmlInputText();
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
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlSelectOneMenu drlAddressCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAddressCode() {
        return drlAddressCode;
    }

    public void setDrlAddressCode(HtmlSelectOneMenu hsom) {
        this.drlAddressCode = hsom;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate sid) {
        this.calEndDate = sid;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public OverTimeRequestModel getOverTimeRequestModel() {
        return overTimeRequestModel;
    }

    public void setOverTimeRequestModel(OverTimeRequestModel overTimeRequestModel) {
        this.overTimeRequestModel = overTimeRequestModel;
    }

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox selectMyHistoryLists) {
        this.selectMyHistoryLists = selectMyHistoryLists;
    }
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }

    public HtmlInputText getTxtParticipantId() {
        return txtParticipantId;
    }

    public void setTxtParticipantId(HtmlInputText hit) {
        this.txtParticipantId = hit;
    }

    public HtmlInputText getTxtParticipantDepartment() {
        return txtParticipantDepartment;
    }

    public void setTxtParticipantDepartment(HtmlInputText hit) {
        this.txtParticipantDepartment = hit;
    }

    public HtmlInputText getTxtParticipantPosition() {
        return txtParticipantPosition;
    }

    public void setTxtParticipantPosition(HtmlInputText hit) {
        this.txtParticipantPosition = hit;
    }
    private HtmlCommandButton btnCalStartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalStartDate() {
        return btnCalStartDate;
    }

    public void setBtnCalStartDate(HtmlCommandButton hcb) {
        this.btnCalStartDate = hcb;
    }
    private HtmlCommandButton btnCalEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalEndDate() {
        return btnCalEndDate;
    }

    public void setBtnCalEndDate(HtmlCommandButton hcb) {
        this.btnCalEndDate = hcb;
    }
    private HtmlCommandButton btnStartTime = new HtmlCommandButton();

    public HtmlCommandButton getBtnStartTime() {
        return btnStartTime;
    }

    public void setBtnStartTime(HtmlCommandButton hcb) {
        this.btnStartTime = hcb;
    }
    private HtmlCommandButton btnEndTime = new HtmlCommandButton();

    public HtmlCommandButton getBtnEndTime() {
        return btnEndTime;
    }

    public void setBtnEndTime(HtmlCommandButton hcb) {
        this.btnEndTime = hcb;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbAnyRequester = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbAnyRequester() {
        return ckbAnyRequester;
    }

    public void setCkbAnyRequester(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbAnyRequester = hsbc;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbAnyParticipant = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbAnyParticipant() {
        return ckbAnyParticipant;
    }

    public void setCkbAnyParticipant(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbAnyParticipant = hsbc;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbAnyRequestParameter = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbAnyRequestParameter() {
        return ckbAnyRequestParameter;
    }

    public void setCkbAnyRequestParameter(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbAnyRequestParameter = hsbc;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData defaultSelectedData5) {
        this.defaultSelectedData5 = defaultSelectedData5;
    }

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData defaultSelectedData6) {
        this.defaultSelectedData6 = defaultSelectedData6;
    }

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData defaultSelectedData7) {
        this.defaultSelectedData7 = defaultSelectedData7;
    }

    public int getOverTimeRequestId() {
        return overTimeRequestId;
    }

    public void setOverTimeRequestId(int overTimeRequestId) {
        this.overTimeRequestId = overTimeRequestId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getStartOrEnd() {
        return startOrEnd;
    }

    public void setStartOrEnd(String startOrEnd) {
        this.startOrEnd = startOrEnd;
    }

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbStatusAny = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbStatusAny() {
        return ckbStatusAny;
    }

    public void setCkbStatusAny(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbStatusAny = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbStatusOnProgress = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbStatusOnProgress() {
        return ckbStatusOnProgress;
    }

    public void setCkbStatusOnProgress(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbStatusOnProgress = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbStatusApproved = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbStatusApproved() {
        return ckbStatusApproved;
    }

    public void setCkbStatusApproved(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbStatusApproved = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbStatusRejected = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbStatusRejected() {
        return ckbStatusRejected;
    }

    public void setCkbStatusRejected(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbStatusRejected = hsbc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public OverTimeReportPage() {
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

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    //private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

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
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SET UPS">

    private void makePageReadyForSave() {
        overTimeRequestId = -1;
        enableRequestTextComponents();
        enableRequestGeneralAttributes();
    }

    private void makePageReadyForUpdate() {
        enableRequestTextComponents();
        enableRequestGeneralAttributes();

    }

    private void makePageReadyForView() {
        disableRequestGeneralAttributes();
    }

    private void enableRequestTextComponents() {
        txtRequesterId.setDisabled(false);
        txtParticipantId.setDisabled(false);
        txtParticipantFullName.setDisabled(false);
        btnCalStartDate.setDisabled(false);
        btnStartTime.setDisabled(false);
        btnCalEndDate.setDisabled(false);
        btnEndTime.setDisabled(false);
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                clearRequestComponents();
                requesterId = "-1";
                return false;
            } else {
                requesterId = employeeId;
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(requesterId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                ckbAnyRequester.setSelected(false);
                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateParticipantTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                clearParticipantComponents();
                return false;
            } else {
                txtParticipantDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtParticipantFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtParticipantId.setValue(employeeId);
                txtParticipantPosition.setValue(empInfoHashMap.get("employeePosition"));
                ckbAnyParticipant.setSelected(false);
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void clearRequesterTextComponents() {
        requesterId = "-1";
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void clearTableData() {
        requestModelList = new ArrayList<OverTimeRequestModel>();
    }

    private void resetRequestParameters() {
        startDate = "-1";
        endDate = "-1";
        startTime = "-1";
        endTime = "-1";
        addressCode = "-1";
        overTimeFactor = -1;
    }

    private void clearRequestComponents() {
        txtStartDate.setValue(null);
        txtStartTime.setValue(null);
        txtEndDate.setValue(null);
        txtEndTime.setValue(null);
        drlAddressCode.resetValue();
        drlAddressCode.setValue("");
    }

    private void clearParticipantComponents() {
        txtParticipantDepartment.setValue(null);
        txtParticipantId.setValue(null);
        txtParticipantFullName.setValue(null);
        txtParticipantPosition.setValue(null);
        participantId = "-1";
    }

    private void clearSelectedObjects() {
        selectedRequestFromMyRequestList.setSelectedObject(null);
        selectedRequestFromHistoryList.setSelectedObject(null);
    }

    public void resetGeneralCheckBoxes() {
        ckbAnyParticipant.setSelected(true);
        ckbAnyRequestParameter.setSelected(true);
        ckbAnyRequester.setSelected(true);
    }

    public void resetStatusCheckBoxes() {
        ckbStatusAny.setSelected(true);
        ckbStatusApproved.setSelected(true);
        ckbStatusOnProgress.setSelected(true);
        ckbStatusRejected.setSelected(true);
    }

    private void clearAllComponents() {
        overTimeRequestId = -1;
        resetRequestParameters();
        clearRequestComponents();
        clearParticipantComponents();
        clearRequesterTextComponents();
        clearTableData();
        resetGeneralCheckBoxes();
        resetStatusCheckBoxes();
        clearSelectedObjects();
    }
    // </editor-fold>
    OverTimeRequestManager overTimeRequestManager = new OverTimeRequestManager();
    OverTimeRequestModel overTimeRequestModel = new OverTimeRequestModel();
    ArrayList<OverTimeRequestModel> requestModelList = new ArrayList<OverTimeRequestModel>();
    DepartmentManage departmentManager = new DepartmentManage();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> addressCodeList = departmentManager.getAddressCode();
    ArrayList<SelectItem> overTimeFactorList = overTimeRequestManager.getOverTimeFactor();
    OverTimeRequestModel currentRequestModel = new OverTimeRequestModel();
    OverTimeRequestModel requestAttribute = new OverTimeRequestModel();
    String userName;
    String loggedInEmployeeId;
    String loggedInDepartmentId;
    EmployeeManage employeeManager = new EmployeeManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //============================================================================================
    int overTimeRequestId = -1;//       OVER_TIME_REQUEST_ID
    String requesterId;//REQUESTER_ID
    String startDate;//START_DATE
    String startTime;//START_TIME
    String endDate;//END_DATE
    String endTime;//END_TIME
    String appliedDate;//APPLIED_DATE
    String addressCode;//ADDRESS_CODE
    double overTimeFactor;//OVER_TIME_PERIOD
    int numberOfEmployee;//NUMBER_OF_EMPLOYEE
    String reason;//REASON
    String status;//STATUS
    String participantId;//from OVER_TIME_EMPLOYEE table
    String employeeFullName;//
    String departmentId;
    String departmentPath;//
    String departmentName;//
    String docReferenceNumber;
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    /*
     *  String requesterId,String appliedDate,String addressCode,double overTimeFactor, String reason
    
     */
    //============================================================================================

    private boolean chechAvailablityOfEmployee(String employeeIdToTest) {
        for (OverTimeRequestModel chechAvailablity : requestModelList) {
            if (chechAvailablity.getEmployeeId().equals(employeeIdToTest)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEndDateValid(String startDate, String endDate) {
        return isEndDateValid(GregorianCalendarManipulation.convertDateToCalendar(startDate), GregorianCalendarManipulation.convertDateToCalendar(endDate));
    }

    private boolean isEndTimeValid(String startTime, String endTime) {
        float startTimeDbl = Float.parseFloat(startTime.replace(':', '.'));
        float endTimeDbl = Float.parseFloat(endTime.replace(':', '.'));
        return startTimeDbl < endTimeDbl;
    }

    private boolean isEndDateValid(Calendar startDate, Calendar endDate) {
        if (startDate.after(endDate)) {
            return false;
        } else if (startDate.equals(endDate)) {
            return true;//if request is for a single day
        } else if (Calendar.SUNDAY < startDate.get(Calendar.DAY_OF_WEEK) &&
                endDate.get(Calendar.DAY_OF_WEEK) < Calendar.SUNDAY &&
                GregorianCalendarManipulation.calaculateDateDifference(startDate, endDate) < 6) {
            return true;//days between monday and friday, in a single week
        } else {
            return false;
        }
    }

    private void enableRequestGeneralAttributes() {
        drlAddressCode.setDisabled(false);
    }

    private void disableRequestGeneralAttributes() {
        drlAddressCode.setDisabled(true);
    }

    public String getSelectedStatus() {
        String selectedStstus = "";
        if (ckbStatusApproved.isSelected()) {
            selectedStstus += "App--";
        }
        if (ckbStatusOnProgress.isSelected()) {
            selectedStstus += "Onp--";
        }
        if (ckbStatusRejected.isSelected()) {
            selectedStstus += "Rej--";
        }
        return selectedStstus;
    }

    public String btnGenerateReport_action() {
        try {
            status = getSelectedStatus();
            requestModelList = overTimeRequestManager.getOverTimeReport(requesterId, participantId, addressCode, status,
                    startDate, startTime, endDate, endTime, overTimeFactor);
            if (requestModelList.size() == 0) {
                showSuccessOrFailureMessage(false, "NO LIST IS FOUND WHICH SATISFY YOUR CRITERIA.\nADJUST YOUR PARAMETERS TO VIEW RESULTS");
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            showSuccessOrFailureMessage(false, "Participant Not Selected");
        }
        return null;
    }

    public String btnSearchParticipant_action() {
        if (txtParticipantId.getValue() != null && !txtParticipantId.getValue().toString().equals("")) {
            participantId = txtParticipantId.getValue().toString();
            if (populateParticipantTextComponents(participantId)) {
                btnGenerateReport.setDisabled(false);
                ckbAnyParticipant.setSelected(false);
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtParticipantId.getValue().toString());
                btnGenerateReport.setDisabled(true);
                participantId = "-1";
            }
        } else {
            participantId = "-1";
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
            btnGenerateReport.setDisabled(true);
        }
        return null;
    }

    public String btnReset_action() {
        clearAllComponents();
        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
            requesterId = txtRequesterId.getValue().toString();
            if (populateRequesterTextComponents(requesterId)) {
                ckbAnyRequester.setSelected(false);
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtRequesterId.getValue().toString());
                requesterId = "-1";
            }
        } else {
            requesterId = "-1";
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
        return null;
    }

    public String btnCalStartDate_action() {
        calStartDate.setRendered(true);
        ckbAnyRequestParameter.setSelected(false);
        return null;
    }

    public String btnCalEndDate_action() {
        calEndDate.setRendered(true);
        ckbAnyRequestParameter.setSelected(false);
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        startDate = dateFormat.format((Date) vce.getNewValue());
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        endDate = dateFormat.format((Date) vce.getNewValue());
        txtEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calEndDate.setRendered(false);
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getLoggedInDepartmentId() {
        return loggedInDepartmentId;
    }

    public void setLoggedInDepartmentId(String loggedInDepartmentId) {
        this.loggedInDepartmentId = loggedInDepartmentId;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
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
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText txtRequesterFullName) {
        this.txtRequesterFullName = txtRequesterFullName;
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        ckbAnyRequester.setSelected(false);
        return null;
    }

    public String txtParticipantFullName_action() {
        clearParticipantComponents();
        participantId = ApplicationBean1.getSelectedEmployeeId();
        populateParticipantTextComponents(participantId);
        ckbAnyParticipant.setSelected(false);
        return null;
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

    private boolean populateParticipantTable(int overTimeRequestId) {
        requestModelList = overTimeRequestManager.getEmployeeAndOverTimeList(overTimeRequestId);
        return true;
    }

    public String cmdLnkRemove_action() {
        //return null means stay on the same page
        return null;
    }
    //=====================================================================================
    String startOrEnd = "Start";
    private PanelLayout pnlLayoutTimePanel = new PanelLayout();

    public PanelLayout getPnlLayoutTimePanel() {
        return pnlLayoutTimePanel;
    }

    public void setPnlLayoutTimePanel(PanelLayout pnlLayoutTimePanel) {
        this.pnlLayoutTimePanel = pnlLayoutTimePanel;
    }

    public void lnkShowTime_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            if (startOrEnd.equals("Start")) {
                txtStartTime.setValue(displayedTime);
                startTime = displayedTime;
            } else {// if (startOrEnd.equals("End")) {
                endTime = displayedTime;
                txtEndTime.setValue(displayedTime);
            }
            pnlLayoutTimePanel.setRendered(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<HashMap> getTableHour() {
        return overTimeRequestManager.getTableHour();
    }

    public String btnStartTime_action() {
        startOrEnd = "Start";
        pnlLayoutTimePanel.setRendered(true);
        ckbAnyRequestParameter.setSelected(false);
        return null;
    }

    public String btnEndTime_action() {
        startOrEnd = "End";
        pnlLayoutTimePanel.setRendered(true);
        ckbAnyRequestParameter.setSelected(false);
        return null;
    }

    public void pnlGrpPowerDeligationContent_processMyEvent(DragEvent de) {
    }

    public void ckbAnyParticipant_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbAnyParticipant") && vce.getNewValue().toString().equals("true")) {
            //if (ckbAnyParticipant.isSelected()) {
            clearParticipantComponents();
        }
    }

    public void ckbAnyRequester_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbAnyRequester") && vce.getNewValue().toString().equals("true")) {
            //if (ckbAnyRequester.isSelected()) {
            clearRequesterTextComponents();
        }
    }

    public void ckbAnyRequestParameter_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbAnyRequestParameter") && vce.getNewValue().toString().equals("true")) {
            clearRequestComponents();
            resetRequestParameters();
        }
    }

    public void drlOverTimeFactor_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectOneMenu) vce.getSource()).getId().equals("drlOverTimeFactor")) {
            overTimeFactor = Double.parseDouble(vce.getNewValue().toString());
            if (!vce.getNewValue().toString().equals("- 1")) {
                ckbAnyRequestParameter.setSelected(false);
            }
        }
    }

    public void drlAddressCode_processValueChange(ValueChangeEvent vce) {
        addressCode = vce.getNewValue().toString();
        if (!vce.getNewValue().toString().equals("- 1")) {
            ckbAnyRequestParameter.setSelected(false);
        }
    }

    public void ckbStatusAny_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusAny")) {
            if (ckbStatusAny.isSelected()) {
                ckbStatusApproved.setSelected(true);
                ckbStatusOnProgress.setSelected(true);
                ckbStatusRejected.setSelected(true);
            } else {
                ckbStatusApproved.setSelected(false);
                ckbStatusOnProgress.setSelected(false);
                ckbStatusRejected.setSelected(false);
            }
        }
    }

    public void ckbStatusOnProgress_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusOnProgress") && vce.getNewValue().toString().equals("false")) {
            //if (vce.getNewValue().toString().equals("false")) {
            ckbStatusAny.setSelected(false);
        }
    }

    public void ckbStatusApproved_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusApproved") && vce.getNewValue().toString().equals("false")) {
            //if (vce.getNewValue().toString().equals("false")) {
            ckbStatusAny.setSelected(false);
        }
    }

    public void ckbStatusRejected_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusRejected") && vce.getNewValue().toString().equals("false")) {
            //if (vce.getNewValue().toString().equals("false")) {
            ckbStatusAny.setSelected(false);
        }
    }

    public String lnkOverTimeApprove_action() {
        //return null means stay on the same page
        return "OverTimeApprove";
    }

    public String txtRequesterId_action() {
        //return null means stay on the same page
        return null;
    }
}
