/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.OverTime;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import manager.employeeManager.EmployeeManage;
import manager.overTimeManager.OverTimeAttendanceManager.OverTimeAttendanceModel;
import manager.overTimeManager.OverTimeRequestManager;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;
import javax.faces.model.SelectItem;
import manager.overTimeManager.OverTimeApproveManager;
import manager.overTimeManager.OverTimeAttendanceManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class OverTimeAttendanceApprovePage extends AbstractPageBean {

    OverTimeRequestManager overTimeRequestManager = new OverTimeRequestManager();
    OverTimeApproveManager overTimeApproveManager = new OverTimeApproveManager();
    OverTimeAttendanceManager overTimeAttendanceManager = new OverTimeAttendanceManager();
    OverTimeRequestModel overTimeRequestModel = new OverTimeRequestModel();
    OverTimeAttendanceModel attendanceModel = new OverTimeAttendanceModel();
    String userName;
    String loggedInEmployeeId;
    String loggedInDepartmentId;
    EmployeeManage employeeManager = new EmployeeManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<SelectItem> employeesList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestListByEmployee = new ArrayList<SelectItem>();
    ArrayList<SelectItem> approvedRequestsToTakeAttendance = new ArrayList<SelectItem>();
    ArrayList<SelectItem> attendanceToBetakenDaysList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> takenAttendancesList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> overTimeFactorList = overTimeRequestManager.getOverTimeFactor();
    ArrayList<OverTimeRequestModel> overTimeAttendanceEmployeeLists = new ArrayList<OverTimeRequestModel>();
    ArrayList<HashMap> tableHour = overTimeRequestManager.getTableHour();
    String saveOrUpdateLabel;
    boolean statusColumnRendered;
    String requesterId;
    int overTimeRequestId;
    String employeeId;
    String employeeFullName;
    String attendanceDate;
    String startTime;
    String endTime;
    int overTimeAttendanceId;
    int overTimeApproveId;
    double overTimeFactor;
    String dataBaseStatus;
    String requestStatus;
    String docReferenceNumber;
    String timeStamp;//TIME_STAMP
    // <editor-fold defaultstate="collapsed" desc=" All">
    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public String getSaveOrUpdateLabel() {
        return saveOrUpdateLabel;
    }

    public void setSaveOrUpdateLabel(String saveOrUpdateLabel) {
        this.saveOrUpdateLabel = saveOrUpdateLabel;
    }

    public int getSelectedRow() {
        return selectedRow;
    }
    private HtmlCommandLink cmdLnkRemove = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkRemove() {
        return cmdLnkRemove;
    }

    public void setCmdLnkRemove(HtmlCommandLink cmdLnkRemove) {
        this.cmdLnkRemove = cmdLnkRemove;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public boolean isStatusColumnRendered() {
        return statusColumnRendered;
    }

    public void setStatusColumnRendered(boolean statusColumnRendered) {
        this.statusColumnRendered = statusColumnRendered;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
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

    public String getDataBaseStatus() {
        return dataBaseStatus;
    }

    public void setDataBaseStatus(String dataBaseStatus) {
        this.dataBaseStatus = dataBaseStatus;
    }

    public String getDocReferenceNumber() {
        return docReferenceNumber;
    }

    public void setDocReferenceNumber(String docReferenceNumber) {
        this.docReferenceNumber = docReferenceNumber;
    }

    public int getOverTimeApproveId() {
        return overTimeApproveId;
    }

    public void setOverTimeApproveId(int overTimeApproveId) {
        this.overTimeApproveId = overTimeApproveId;
    }

    public ArrayList<OverTimeRequestModel> getOverTimeAttendanceEmployeeLists() {
        return overTimeAttendanceEmployeeLists;
    }

    public void setOverTimeAttendanceEmployeeLists(ArrayList<OverTimeRequestModel> overTimeAttendanceEmployeeLists) {
        this.overTimeAttendanceEmployeeLists = overTimeAttendanceEmployeeLists;
    }

    public int getOverTimeAttendanceId() {
        return overTimeAttendanceId;
    }

    public void setOverTimeAttendanceId(int overTimeAttendanceId) {
        this.overTimeAttendanceId = overTimeAttendanceId;
    }

    public int getOverTimeRequestId() {
        return overTimeRequestId;
    }

    public void setOverTimeRequestId(int overTimeRequestId) {
        this.overTimeRequestId = overTimeRequestId;
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

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userName = getSessionBean1().getUserName();
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        populateLoggedInEmployeeTextComponents(loggedInEmployeeId);
        overTimeApproveManager.setUserName(userName);
        overTimeAttendanceManager.setUserName(userName);
        overTimeAttendanceManager.setLoggedInEmployeeId(loggedInEmployeeId);
        overTimeRequestManager.setUserName(userName);
        approvedRequestsToTakeAttendance = overTimeAttendanceManager.getAttendanceApprove();
        takenAttendancesList = overTimeAttendanceManager.getAttendanceHistorysApprove();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public ArrayList<SelectItem> getTakenAttendancesList() {
        return takenAttendancesList;
    }

    public void setTakenAttendancesList(ArrayList<SelectItem> takenAttendancesList) {
        this.takenAttendancesList = takenAttendancesList;
    }

    public ArrayList<SelectItem> getAttendanceToBetakenDaysList() {
        return attendanceToBetakenDaysList;
    }

    public void setAttendanceToBetakenDaysList(ArrayList<SelectItem> attendanceToBetakenDaysList) {
        this.attendanceToBetakenDaysList = attendanceToBetakenDaysList;
    }

    public ArrayList<SelectItem> getApprovedRequestsToTakeAttendance() {
        return approvedRequestsToTakeAttendance;
    }

    public void setApprovedRequestsToTakeAttendance(ArrayList<SelectItem> approvedRequestsToTakeAttendance) {
        this.approvedRequestsToTakeAttendance = approvedRequestsToTakeAttendance;
    }

    public ArrayList<SelectItem> getRequestListByEmployee() {
        return requestListByEmployee;
    }

    public void setRequestListByEmployee(ArrayList<SelectItem> requestListByEmployee) {
        this.requestListByEmployee = requestListByEmployee;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }
    private DefaultSelectedData selectedObjectAttendanceToBetakenDaysList = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectAttendanceToBetakenDaysList() {
        return selectedObjectAttendanceToBetakenDaysList;
    }

    public void setSelectedObjectAttendanceToBetakenDaysList(DefaultSelectedData selectedObjectAttendanceToBetakenDaysList) {
        this.selectedObjectAttendanceToBetakenDaysList = selectedObjectAttendanceToBetakenDaysList;
    }
    private DefaultSelectedData selectedRequestFromApprovedList = new DefaultSelectedData();

    public DefaultSelectedData getSelectedRequestFromApprovedList() {
        return selectedRequestFromApprovedList;
    }

    public void setSelectedRequestFromApprovedList(DefaultSelectedData selectedRequestFromApprovedList) {
        this.selectedRequestFromApprovedList = selectedRequestFromApprovedList;
    }
    private HtmlInputText txtDeligateeTItile = new HtmlInputText();

    public HtmlInputText getTxtDeligateeTItile() {
        return txtDeligateeTItile;
    }

    public void setTxtDeligateeTItile(HtmlInputText hit) {
        this.txtDeligateeTItile = hit;
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
    private DefaultSelectedData selectOneMenuOverTimeFactor = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenuOverTimeFactor() {
        return selectOneMenuOverTimeFactor;
    }

    public void setSelectOneMenuOverTimeFactor(DefaultSelectedData selectOneMenuOverTimeFactor) {
        this.selectOneMenuOverTimeFactor = selectOneMenuOverTimeFactor;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public OverTimeAttendanceModel getAttendanceModel() {
        return attendanceModel;
    }

    public void setAttendanceModel(OverTimeAttendanceModel attendanceModel) {
        this.attendanceModel = attendanceModel;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getOverTimeFactor() {
        return overTimeFactor;
    }

    public void setOverTimeFactor(double overTimeFactor) {
        this.overTimeFactor = overTimeFactor;
    }

    public ArrayList<SelectItem> getOverTimeFactorList() {
        return overTimeFactorList;
    }

    public void setOverTimeFactorList(ArrayList<SelectItem> overTimeFactorList) {
        this.overTimeFactorList = overTimeFactorList;
    }

    public OverTimeRequestManager getOverTimeRequestManager() {
        return overTimeRequestManager;
    }

    public void setOverTimeRequestManager(OverTimeRequestManager overTimeRequestManager) {
        this.overTimeRequestManager = overTimeRequestManager;
    }

    public OverTimeRequestModel getOverTimeRequestModel() {
        return overTimeRequestModel;
    }

    public void setOverTimeRequestModel(OverTimeRequestModel overTimeRequestModel) {
        this.overTimeRequestModel = overTimeRequestModel;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public ArrayList<SelectItem> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(ArrayList<SelectItem> employeesList) {
        this.employeesList = employeesList;
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
    private HtmlInputTextarea txtaReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaReason() {
        return txtaReason;
    }

    public void setTxtaReason(HtmlInputTextarea hit) {
        this.txtaReason = hit;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlSelectOneMenu drlAddressCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAddressCode() {
        return drlAddressCode;
    }

    public void setDrlAddressCode(HtmlSelectOneMenu hsom) {
        this.drlAddressCode = hsom;
    }
    private HtmlInputText txtReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtReferenceNumber() {
        return txtReferenceNumber;
    }

    public void setTxtReferenceNumber(HtmlInputText hit) {
        this.txtReferenceNumber = hit;
    }
    private HtmlSelectOneListbox selectRequestApprovedLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectRequestApprovedLists() {
        return selectRequestApprovedLists;
    }

    public void setSelectRequestApprovedLists(HtmlSelectOneListbox hsol) {
        this.selectRequestApprovedLists = hsol;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private DefaultSelectedData defaultSelectedDataChangeDate = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataSetOverTimeFactor = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataChangeAttendanceDate = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataSetStartTime = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataSetEndTime = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataChangeAttendanceDate() {
        return defaultSelectedDataChangeAttendanceDate;
    }

    public void setDefaultSelectedDataChangeAttendanceDate(DefaultSelectedData defaultSelectedDataChangeAttendanceDate) {
        this.defaultSelectedDataChangeAttendanceDate = defaultSelectedDataChangeAttendanceDate;
    }

    public DefaultSelectedData getDefaultSelectedDataSetEndTime() {
        return defaultSelectedDataSetEndTime;
    }

    public void setDefaultSelectedDataSetEndTime(DefaultSelectedData defaultSelectedDataSetEndTime) {
        this.defaultSelectedDataSetEndTime = defaultSelectedDataSetEndTime;
    }

    public DefaultSelectedData getDefaultSelectedDataSetOverTimeFactor() {
        return defaultSelectedDataSetOverTimeFactor;
    }

    public void setDefaultSelectedDataSetOverTimeFactor(DefaultSelectedData defaultSelectedDataSetOverTimeFactor) {
        this.defaultSelectedDataSetOverTimeFactor = defaultSelectedDataSetOverTimeFactor;
    }

    public DefaultSelectedData getDefaultSelectedDataSetStartTime() {
        return defaultSelectedDataSetStartTime;
    }

    public void setDefaultSelectedDataSetStartTime(DefaultSelectedData defaultSelectedDataSetStartTime) {
        this.defaultSelectedDataSetStartTime = defaultSelectedDataSetStartTime;
    }

    public DefaultSelectedData getDefaultSelectedDataChangeDate() {
        return defaultSelectedDataChangeDate;
    }

    public void setDefaultSelectedDataChangeDate(DefaultSelectedData defaultSelectedDataChangeDate) {
        this.defaultSelectedDataChangeDate = defaultSelectedDataChangeDate;
    }

    public OverTimeApproveManager getOverTimeApproveManager() {
        return overTimeApproveManager;
    }

    public void setOverTimeApproveManager(OverTimeApproveManager overTimeApproveManager) {
        this.overTimeApproveManager = overTimeApproveManager;
    }

    public OverTimeAttendanceManager getOverTimeAttendanceManager() {
        return overTimeAttendanceManager;
    }

    public void setOverTimeAttendanceManager(OverTimeAttendanceManager overTimeAttendanceManager) {
        this.overTimeAttendanceManager = overTimeAttendanceManager;
    }
    private HtmlInputText txtRecorderDepartment = new HtmlInputText();

    public HtmlInputText getTxtRecorderDepartment() {
        return txtRecorderDepartment;
    }

    public void setTxtRecorderDepartment(HtmlInputText hit) {
        this.txtRecorderDepartment = hit;
    }
    private HtmlInputText txtRecorderId = new HtmlInputText();

    public HtmlInputText getTxtRecorderId() {
        return txtRecorderId;
    }

    public void setTxtRecorderId(HtmlInputText hit) {
        this.txtRecorderId = hit;
    }
    private HtmlInputText txtRecorderFullName = new HtmlInputText();

    public HtmlInputText getTxtRecorderFullName() {
        return txtRecorderFullName;
    }

    public void setTxtRecorderFullName(HtmlInputText hit) {
        this.txtRecorderFullName = hit;
    }
    private HtmlInputText txtRecorderPosition = new HtmlInputText();

    public HtmlInputText getTxtRecorderPosition() {
        return txtRecorderPosition;
    }

    public void setTxtRecorderPosition(HtmlInputText hit) {
        this.txtRecorderPosition = hit;
    }
    private HtmlCommandButton btnSaveAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveAttendance() {
        return btnSaveAttendance;
    }

    public void setBtnSaveAttendance(HtmlCommandButton hcb) {
        this.btnSaveAttendance = hcb;
    }


    // </editor-fold >
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public OverTimeAttendanceApprovePage() {
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

    public void drlDecision_processValueChange(ValueChangeEvent vce) {
    }

    public String txtDeligateeId_action() {
        //return null means stay on the same page
        return null;
    }

    private void clearRequesterTextComponents() {
        requesterId = "-1";
        txtRequesterDepartment.setValue(null);
        txtRequesterId.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void clearRequestComponents() {
//        overTimeRequestId = -1;
        txtaReason.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtAppliedDate.setValue(null);
        txtReferenceNumber.setValue(null);
        drlAddressCode.resetValue();
    }

    private void clearRequestDataTable() {
        overTimeAttendanceEmployeeLists = new ArrayList<OverTimeRequestModel>();//clear
    }

    private void clearSelectedRequest() {
        selectedRequestFromApprovedList.setSelectedObject(null);
    }

    private void clearAllComponents() {
        clearRequesterTextComponents();
        clearRequestComponents();
        clearRequestDataTable();
        clearSelectedRequest();
    }


    // </editor-fold>
    // </editor-fold>
    public void drlEmployeeFullName_processValueChange(ValueChangeEvent vce) {
    }

    private boolean validateOverTimeAttendance() {
        return true;
    }

    public String btnAddToTable_action() {
//        if (validateOverTimeAttendance()) {
//            attendanceModel = new OverTimeAttendanceModel(employeeId, employeeFullName, attendanceDate, startTime, endTime, overTimeFactor);
//            overTimeAttendanceEmployeeLists.add(attendanceModel);
//        }
        return null;
    }

    public String btnReset_action() {
        clearAllComponents();
        return null;
    }

    private boolean validateAttemdance() {
        return true;
    }

    public String cmdLnkEdit_action() {
        if (selectedRow != -1) {
            overTimeAttendanceEmployeeLists.get(selectedRow).setDatabaseStatus(OverTimeRequestManager.DATABASE_STATUS_OLDDELETED);
        }
        return null;
    }

    public String btnSaveAttendance_action() {
        if (validateAttemdance()) {
            if (saveOrUpdateLabel.equals("Update")) {
                if (overTimeAttendanceManager.updateOverTimeAttendanceApprov(overTimeAttendanceEmployeeLists, overTimeAttendanceId,overTimeRequestId)) {
                    showSuccessOrFailureMessage(true, "UPDATE SUCCESS");
                } else {
                    showSuccessOrFailureMessage(false, "UPDATE FAILED");
                }
            } else {
                if (overTimeAttendanceManager.updateOverTimeAttendanceApprov(overTimeAttendanceEmployeeLists, overTimeAttendanceId,overTimeRequestId)) {

                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED");
                }
            }
        }
        return null;
    }

    private void populateRequesterTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                requesterId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                //  requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(empInfoHashMap.get("employeeId"));
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));

            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void populateLoggedInEmployeeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            txtRecorderDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
            txtRecorderFullName.setValue(empInfoHashMap.get("employeeFullName"));
            txtRecorderId.setValue(empInfoHashMap.get("employeeId"));
            txtRecorderPosition.setValue(empInfoHashMap.get("employeePosition"));
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }
    //==========================================================================================================

    private boolean populateApprovedEmployeesListToTable(int overTimeRequestId) {
        overTimeAttendanceEmployeeLists = new ArrayList<OverTimeRequestModel>();//clear
        overTimeAttendanceEmployeeLists = overTimeApproveManager.getEmployeeAtrendanceOverTimeList(overTimeRequestId);
//         overTimeAttendanceEmployeeLists = overTimeRequestManager.getEmployeeAndOverTimeList(overTimeRequestId);
        return true;
    }

    private boolean populateAttendedEmployeesListToTable(int overTimeAttendanceId) {
        overTimeAttendanceEmployeeLists = new ArrayList<OverTimeRequestModel>();//clear
        overTimeAttendanceEmployeeLists = overTimeAttendanceManager.getAttendedEmployeeForApprove(overTimeAttendanceId);
        return true;
    }

    private boolean populateAttendedEmployeesHistory(int overTimeAttendanceId) {
        overTimeAttendanceEmployeeLists = new ArrayList<OverTimeRequestModel>();//clear
        overTimeAttendanceEmployeeLists = overTimeAttendanceManager.getAttendedEmployeeHistory(overTimeAttendanceId);
        return true;
    }

    private boolean populateOverTimeRequestTextComponents(int overTimeRequestId) {
        overTimeRequestModel = overTimeRequestManager.getRequestAttributes(overTimeRequestId);
        if (overTimeRequestModel != null) {
            if (overTimeRequestModel.getoverTimeRequestId() != -1) {
                txtaReason.setValue(overTimeRequestModel.getReasonDescription());
                drlAddressCode.setValue(overTimeRequestModel.getAddressCode());
                txtAppliedDate.setValue(overTimeRequestModel.getAppliedDate());
                txtReferenceNumber.setValue(overTimeRequestModel.getDocReferenceNumber());
                return true;
            } else {
                showSuccessOrFailureMessage(false, "NO ATTRIBUTE");
                return false;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
        return false;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
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

    private void makePageReadyForSave() {
        saveOrUpdateLabel = "Save";
        statusColumnRendered = false;
        btnSaveAttendance.setDisabled(false);
    }

    private void makePageReadyForUpdate() {
        if (true) {
            saveOrUpdateLabel = "Update";
            statusColumnRendered = true;
            btnSaveAttendance.setDisabled(false);
        } else {
            saveOrUpdateLabel = "Save";
            statusColumnRendered = false;
            btnSaveAttendance.setDisabled(true);
        }
    }

    public void selectRequestApprovedLists_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        overTimeRequestId = Integer.parseInt(requestInfos[0]);
        requesterId = requestInfos[1];
        requestStatus = requestInfos[2];
        attendanceDate = requestInfos[3];
        overTimeAttendanceId = Integer.parseInt(requestInfos[4]);
        populateRequesterTextComponents(requesterId);
        populateOverTimeRequestTextComponents(overTimeRequestId);
        populateAttendedEmployeesHistory(overTimeAttendanceId);
        makePageReadyForSave();
    }

    public ArrayList<HashMap> getTableHour() {
        return tableHour;
    }
    int selectedRow = -1;

    public void rowSelectorOverTime_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }

    public void selectAttendanceHistoryLists_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        overTimeRequestId = Integer.parseInt(requestInfos[0]);
        requesterId = requestInfos[1];
        requestStatus = requestInfos[2];
        attendanceDate = requestInfos[3];
        overTimeAttendanceId = Integer.parseInt(requestInfos[4]);
        populateRequesterTextComponents(requesterId);
        populateOverTimeRequestTextComponents(overTimeRequestId);
        populateAttendedEmployeesListToTable(overTimeAttendanceId);
        makePageReadyForUpdate();
    }

    public String lblOverTimeReuestPage_action() {
        return "OverTimeReuest";
    }

    public String lnkOverTimeApprovePage_action() {
        return "OverTimeApprove";
    }

    public void selectRequestAttendanceToBetakenDaysLis_processValueChange(ValueChangeEvent vce) {
    }
}
