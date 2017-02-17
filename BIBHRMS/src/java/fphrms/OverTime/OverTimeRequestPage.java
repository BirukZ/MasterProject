package fphrms.OverTime;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
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
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.TransportAbsenceDatePaymentManager.TransportAbsenceDateRegistrationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;
import manager.leaveManager.LeaveControl;
import manager.overTimeManager.MgrEmployeeShiftViewer;
import manager.overTimeManager.OverTimeApproveManager;
import manager.overTimeManager.OverTimeRequestManager;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;
import manager.powerDeligationManager.PowerDeligationRequestManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class OverTimeRequestPage extends AbstractPageBean {
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

    public ArrayList<SelectItem> getReasonSummaryList() {
        return reasonSummaryList;
    }

    public void setReasonSummaryList(ArrayList<SelectItem> reasonSummaryList) {
        this.reasonSummaryList = reasonSummaryList;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    public int getReasonSummary() {
        return reasonSummary;
    }

    public void setReasonSummary(int reasonSummary) {
        this.reasonSummary = reasonSummary;
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
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public HtmlOutputLabel getLblSuccessOrErrorMessage1() {
        return lblSuccessOrErrorMessage1;
    }

    public void setLblSuccessOrErrorMessage1(HtmlOutputLabel lblSuccessOrErrorMessage1) {
        this.lblSuccessOrErrorMessage1 = lblSuccessOrErrorMessage1;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
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

    public PowerDeligationRequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(PowerDeligationRequestManager requestManager) {
        this.requestManager = requestManager;
    }


    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public HtmlPanelGroup getPanelGroupMessage1() {
        return panelGroupMessage1;
    }

    public void setPanelGroupMessage1(HtmlPanelGroup panelGroupMessage1) {
        this.panelGroupMessage1 = panelGroupMessage1;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public PanelLayout getPnlMessageBody1() {
        return pnlMessageBody1;
    }

    public void setPnlMessageBody1(PanelLayout pnlMessageBody1) {
        this.pnlMessageBody1 = pnlMessageBody1;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public PanelPopup getPnlPopupSuccessOrFailure1() {
        return pnlPopupSuccessOrFailure1;
    }

    public void setPnlPopupSuccessOrFailure1(PanelPopup pnlPopupSuccessOrFailure1) {
        this.pnlPopupSuccessOrFailure1 = pnlPopupSuccessOrFailure1;
    }

    public String getReason() {
        return reasonDescription;
    }

    public void setReason(String reason) {
        this.reasonDescription = reason;
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
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userName = getSessionBean1().getUserName();
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInDepartmentId = getSessionBean1().getEmpDeptId();
        overTimeRequestManager.setUserName(userName);
        overTimeRequestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        overTimeRequestManager.setLoggedInDepartmentId(loggedInDepartmentId);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
//        pendingRequestList = overTimeRequestManager.getPendingRequests();
//        requestHistoryList = overTimeRequestManager.getMyRequestsHistory();
        populateRequesterTextComponents(loggedInEmployeeId);
        btnCalAppliedDate.setDisabled(true);
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
    private HtmlCommandButton btnAddToTable = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchParticipant() {
        return btnSearchParticipant;
    }

    public void setBtnSearchParticipant(HtmlCommandButton btnSearchParticipant) {
        this.btnSearchParticipant = btnSearchParticipant;
    }
    private HtmlCommandButton btnSearchParticipant = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddToTable() {
        return btnAddToTable;
    }

    public void setBtnAddToTable(HtmlCommandButton hcb) {
        this.btnAddToTable = hcb;
    }
    private HtmlInputTextarea txtaReasonDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaReasonDescription() {
        return txtaReasonDescription;
    }

    public void setTxtaReasonDescription(HtmlInputTextarea hit) {
        this.txtaReasonDescription = hit;
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

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
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
    private DefaultSelectedData selectObjectOfReasonSummary = new DefaultSelectedData();

    public DefaultSelectedData getSelectObjectOfReasonSummary() {
        return selectObjectOfReasonSummary;
    }

    public void setSelectObjectOfReasonSummary(DefaultSelectedData selectObjectOfReasonSummary) {
        this.selectObjectOfReasonSummary = selectObjectOfReasonSummary;
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
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlSelectOneMenu drlOverTimeFactor = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlOverTimeFactor() {
        return drlOverTimeFactor;
    }

    public void setDrlOverTimeFactor(HtmlSelectOneMenu hsom) {
        this.drlOverTimeFactor = hsom;
    }
    private HtmlSelectOneMenu drlAddressCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAddressCode() {
        return drlAddressCode;
    }

    public void setDrlAddressCode(HtmlSelectOneMenu hsom) {
        this.drlAddressCode = hsom;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
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

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public int getOverTimeRequestId() {
        return overTimeRequestId;
    }

    public void setOverTimeRequestId(int overTimeRequestId) {
        this.overTimeRequestId = overTimeRequestId;
    }

    public String getStartOrEnd() {
        return startOrEnd;
    }

    public void setStartOrEnd(String startOrEnd) {
        this.startOrEnd = startOrEnd;
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
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
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
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public String getButtonAction() {
        return buttonAction;
    }

    public void setButtonAction(String buttonAction) {
        this.buttonAction = buttonAction;
    }

    public boolean isSelectedColumnRendered() {
        return selectedColumnRendered;
    }

    public void setSelectedColumnRendered(boolean selectedColumnRendered) {
        this.selectedColumnRendered = selectedColumnRendered;
    }

    public boolean isStatusColumnRendered() {
        return statusColumnRendered;
    }

    public void setStatusColumnRendered(boolean statusColumnRendered) {
        this.statusColumnRendered = statusColumnRendered;
    }

    public void setCalAppliedDate(SelectInputDate sid) {
        this.calAppliedDate = sid;
    }
    private HtmlCommandLink cmdLnkRemove = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkRemove() {
        return cmdLnkRemove;
    }

    public void setCmdLnkRemove(HtmlCommandLink cmdLnkRemove) {
        this.cmdLnkRemove = cmdLnkRemove;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }
    private HtmlCommandLink lnkOverTimeApprove = new HtmlCommandLink();

    public HtmlCommandLink getLnkOverTimeApprove() {
        return lnkOverTimeApprove;
    }

    public void setLnkOverTimeApprove(HtmlCommandLink hcl) {
        this.lnkOverTimeApprove = hcl;
    }
    private HtmlSelectBooleanCheckbox ckbForColumnSelected = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbForColumnSelected() {
        return ckbForColumnSelected;
    }

    public void setCkbForColumnSelected(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbForColumnSelected = hsbc;
    }
    private HtmlSelectOneMenu drlReasonSummary = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlReasonSummary() {
        return drlReasonSummary;
    }

    public void setDrlReasonSummary(HtmlSelectOneMenu hsom) {
        this.drlReasonSummary = hsom;
    }
    private HtmlCommandButton btnCalAppliedDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalAppliedDate() {
        return btnCalAppliedDate;
    }

    public void setBtnCalAppliedDate(HtmlCommandButton hcb) {
        this.btnCalAppliedDate = hcb;
    }
    private HtmlInputText txtLoginId = new HtmlInputText();

    public HtmlInputText getTxtLoginId() {
        return txtLoginId;
    }

    public void setTxtLoginId(HtmlInputText hit) {
        this.txtLoginId = hit;
    }
    private HtmlInputText txtFullName = new HtmlInputText();

    public HtmlInputText getTxtFullName() {
        return txtFullName;
    }

    public void setTxtFullName(HtmlInputText hit) {
        this.txtFullName = hit;
    }
    private HtmlInputText txtDepartment = new HtmlInputText();

    public HtmlInputText getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(HtmlInputText hit) {
        this.txtDepartment = hit;
    }
    private HtmlInputText txtPosition = new HtmlInputText();

    public HtmlInputText getTxtPosition() {
        return txtPosition;
    }

    public void setTxtPosition(HtmlInputText hit) {
        this.txtPosition = hit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public OverTimeRequestPage() {
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
        if(reasonSummaryList .isEmpty()){
           reasonSummaryList = overTimeRequestManager.getOverTimeReasonsList();// new ArrayList<SelectItem>();
        }else{
        }
        if(pendingRequestList .isEmpty()){
           pendingRequestList = overTimeRequestManager.getPendingRequests();// new ArrayList<SelectItem>();
        }else{
        }
        if(requestHistoryList .isEmpty()){
           requestHistoryList = overTimeRequestManager.getMyRequestsHistory();// new ArrayList<SelectItem>();
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

// </editor-fold>pnlPopupSuccessOrFailure
    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlOutputLabel lblSuccessOrErrorMessage1 = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private PanelLayout pnlMessageBody1 = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private HtmlPanelGroup panelGroupMessage1 = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private PanelPopup pnlPopupSuccessOrFailure1 = new PanelPopup();
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
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SET UPS">

    private void makePageReadyForSave() {
        newOrEditOrUpdateLabel = "Save";
        overTimeRequestId = -1;
        enableButtons();
        enableRequestTextComponents();
        enableRequestGeneralAttributes();
    }

    private void makePageReadyForUpdate() {
        newOrEditOrUpdateLabel = "Update";
        buttonAction = "Update";
        statusColumnRendered = true;
        selectedColumnRendered = false;
        lnkViewPrevieousDecisions.setRendered(false);
        selectedRequestFromHistoryList.setSelectedObject(null);
        enableButtons();
        enableRequestTextComponents();
        enableParticipantTextComponents();
        enableRequestGeneralAttributes();

    }

    private void makePageReadyForView() {
        newOrEditOrUpdateLabel = "Save";
        buttonAction = "None";
        statusColumnRendered = false;
        selectedColumnRendered = true;
        lnkViewPrevieousDecisions.setRendered(true);
        selectedRequestFromMyRequestList.setSelectedObject(null);
        disableButtons();
        disableRequestTextComponents();
        disableParticipantTextComponents();
        disableRequestGeneralAttributes();
    }

    private void disableButtons() {
        btnSave.setDisabled(true);
//        btnDelete.setDisabled(true);
        btnAddToTable.setDisabled(true);
    }

    private void enableButtons() {
        btnSave.setDisabled(false);
//        btnDelete.setDisabled(false);
        btnAddToTable.setDisabled(false);
    }

    private void enableRequestTextComponents() {
        txtRequesterId.setDisabled(false);
        txtRequesterDepartment.setDisabled(false);
        txtRequesterFullName.setDisabled(false);
        txtRequesterPosition.setDisabled(false);
    }

    private void enableParticipantTextComponents() {
        txtParticipantId.setDisabled(false);
        txtParticipantDepartment.setDisabled(false);
        txtParticipantFullName.setDisabled(false);
        txtParticipantPosition.setDisabled(false);
    }

    private void disableRequestTextComponents() {
        txtRequesterId.setDisabled(true);
        txtRequesterDepartment.setDisabled(true);
        txtRequesterFullName.setDisabled(true);
        txtRequesterPosition.setDisabled(true);
    }

    private void disableParticipantTextComponents() {
        txtParticipantId.setDisabled(true);
        txtParticipantDepartment.setDisabled(true);
        txtParticipantFullName.setDisabled(true);
        txtParticipantPosition.setDisabled(true);
    }

    private boolean validateAndInitializeRequestAttributes() {
        if (requesterId == null) {
            showSuccessOrFailureMessage(false, "SELECT REQUESTER FIRST");
            return false;
        } else if (txtaReasonDescription.getValue() == null || txtaReasonDescription.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(false, "INSERT REASON FIRST");
            return false;
        } else if (txtAppliedDate.getValue() == null || txtAppliedDate.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(false, "INSERT APPLIED DATE FIRST");
            return false;
        } else if (drlAddressCode.getValue() == null || drlAddressCode.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "WHICH PLACE TO BE DONE?");
            return false;
        } else if (!requesterId.equals(loggedInEmployeeId) && (txtDocReferenceNumber.getValue() == null || txtDocReferenceNumber.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "PLEASE FILL DOCUMENT REFERENCE NUMBER ");
            return false;
        } else if (requestModelList == null || requestModelList.size() == 0) {
            showSuccessOrFailureMessage(false, "SELECT REQUESTER FIRST");
            return false;
        } else {
            reasonSummary = Integer.parseInt(drlReasonSummary.getValue().toString());
            appliedDate = txtAppliedDate.getValue().toString();
            reasonDescription = txtaReasonDescription.getValue().toString();
            addressCode = drlAddressCode.getValue().toString();
            overTimeFactor = -1;//Double.parseDouble(drlOverTimeFactor.getValue().toString());
            docReferenceNumber = txtDocReferenceNumber.getValue() == null ? "" : txtDocReferenceNumber.getValue().toString();
        }
        return true;
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

    private boolean populateLoginTextComponents(String loginId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(loginId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + loginId);
                requesterId = null;
                return false;
            } else {
//                requesterId = employeeId;
                txtDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtLoginId.setValue(loginId);
                txtPosition.setValue(empInfoHashMap.get("employeePosition"));
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
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void clearTableData() {
        requestModelList = new ArrayList<OverTimeRequestModel>();
    }

    private void clearRequestComponents() {
        employeeId = null;
        txtaReasonDescription.setValue(null);
        selectOneMenu1Bean.setSelectedObject(null);
        selectObjectOfReasonSummary.setSelectedObject(null);
//        txtRequesterDepartment.setValue(null);
        txtStartDate.setValue(null);
        txtStartTime.setValue(null);
        txtEndDate.setValue(null);
        txtEndTime.setValue(null);
        drlOverTimeFactor.setValue("");
        drlOverTimeFactor.resetValue();
        drlOverTimeFactor.setValue("");
        drlReasonSummary.resetValue();
    }

    private void clearParticipantComponents() {
        txtParticipantDepartment.setValue(null);
        txtParticipantId.setValue(null);
        txtParticipantFullName.setValue(null);
        txtParticipantPosition.setValue(null);
        employeeId = null;
    }

    private void clearSelectedObjects() {
        selectedRequestFromMyRequestList.setSelectedObject(null);
        selectedRequestFromHistoryList.setSelectedObject(null);
    }

    private void clearAllComponents() {
        overTimeRequestId = -1;
        buttonAction = "Save";
        newOrEditOrUpdateLabel = "Save";
        clearRequestComponents();
        clearParticipantComponents();
//        clearRequesterTextComponents();
        clearTableData();
        clearSelectedObjects();
        btnCalAppliedDate.setDisabled(true);
    }
    // </editor-fold>
    OverTimeRequestManager overTimeRequestManager = new OverTimeRequestManager();
    OverTimeRequestModel overTimeRequestModel = new OverTimeRequestModel();
    PowerDeligationRequestManager requestManager = new PowerDeligationRequestManager();
    ArrayList<OverTimeRequestModel> requestModelList = new ArrayList<OverTimeRequestModel>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    TransportAbsenceDateRegistrationManager transportAbsenceDateRegistrationManager = new TransportAbsenceDateRegistrationManager();
    DepartmentManage departmentManager = new DepartmentManage();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> addressCodeList = departmentManager.getAddressCode();
//    ArrayList<SelectItem> reasonSummaryList = overTimeRequestManager.getOverTimeReasonsList();
    ArrayList<SelectItem> reasonSummaryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> overTimeFactorList = overTimeRequestManager.getOverTimeFactor();
    OverTimeRequestModel currentRequestModel = new OverTimeRequestModel();
    OverTimeRequestModel requestAttribute = new OverTimeRequestModel();
    String newOrEditOrUpdateLabel = "Save";
    String buttonAction = "Save";
    String userName;
    String loggedInEmployeeId;
    String loggedInDepartmentId;
    EmployeeManage employeeManager = new EmployeeManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean statusColumnRendered = false;
    boolean selectedColumnRendered = false;

    int overTimeRequestId = -1;//       OVER_TIME_REQUEST_ID
    String requesterId;//REQUESTER_ID
    String startDate;//START_DATE
    String startTime;//START_TIME
    String endDate;//END_DATE
    String endTime;//END_TIME
    String appliedDate;//APPLIED_DATE
    String addressCode;//ADDRESS_CODE
    double overTimeFactor = -1;//OVER_TIME_PERIOD
    int numberOfEmployee;//NUMBER_OF_EMPLOYEE
    int reasonSummary;//REASON_SUMMARY
    String reasonDescription;//REASON
    String status;//STATUS
    String employeeId;//from OVER_TIME_EMPLOYEE table
    String employeeFullName;//
    String departmentId;
    String departmentPath;//
    String departmentName;//
    String docReferenceNumber;
    String dayType = null;
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    /*
     *  String requesterId,String appliedDate,String addressCode,double overTimeFactor, String reasonDescription

     */

    private boolean chechAvailablityOfEmployee(String employeeIdToTest) {
        for (OverTimeRequestModel chechAvailablity : requestModelList) {
            if (chechAvailablity.getEmployeeId().equals(employeeIdToTest)) {
                String checkStartDate = chechAvailablity.getStartDate();
                String checkEndDate = chechAvailablity.getEndDate();
                if ((GregorianCalendarManipulation.compareDates(startDate, checkStartDate) <= 0 && GregorianCalendarManipulation.compareDates(endDate, checkStartDate) >= 0) ||
                        (GregorianCalendarManipulation.compareDates(startDate, checkEndDate) >= 0 && GregorianCalendarManipulation.compareDates(endDate, checkEndDate) <= 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean chechAvailablityOfEmployee(String employeeIdToTest, String startDate, String endDate) {
        for (OverTimeRequestModel chechAvailablity : requestModelList) {
            if (chechAvailablity.getEmployeeId().equals(employeeIdToTest)) {
                if (true) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEndDateValid(String startDate, String endDate) {
        boolean test = isEndDateValid(GregorianCalendarManipulation.convertDateToCalendar(startDate), GregorianCalendarManipulation.convertDateToCalendar(endDate));

        return test;
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
        } else if (Calendar.SUNDAY < startDate.get(Calendar.DAY_OF_WEEK) &&// public final static int SUNDAY = 1;ist day
                endDate.get(Calendar.DAY_OF_WEEK) < Calendar.SATURDAY &&// public final static int SATURDAY = 7;
                GregorianCalendarManipulation.calaculateDateDifference(startDate, endDate) < 6) {
            return true;//days between monday and friday,inclusive  in a single week
        } else {
            return false;

        }
    }

    private boolean validateAndInitializeDateAndTime() {
        try {
            startDate = txtStartDate.getValue().toString();
            startTime = txtStartTime.getValue().toString();
            endDate = txtEndDate.getValue().toString();
            endTime = txtEndTime.getValue().toString();
            //    overTimeFactor = Double.parseDouble(drlOverTimeFactor.getValue().toString());
            if (((Date) calStartDate.getValue()).after((Date) calEndDate.getValue())) {
                showSuccessOrFailureMessage(false, "INVALID END DATE! \nSTART DATE SHOULD BE BEFORE END DATE");
                return false;
//            } else if (!isEndDateValid(startDate, endDate)) {
//                showSuccessOrFailureMessage(false, "INVALID DATE OR EMPLOYEE \n CHECK IF EMPLOYEE IS ALREADY REGISTERED ");
//                return false;
            } else if (!isEndTimeValid(startTime, endTime)) {
                showSuccessOrFailureMessage(false, "INVALID END TIME\nIT SHOULD BE GREATER THAN START TIME");
                return false;
            }

        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "UNFILLED PARAMETER");
            return false;
        }

        return true;
    }

    private void enableRequestGeneralAttributes() {
        txtaReasonDescription.setDisabled(false);
        txtDocReferenceNumber.setDisabled(false);
        drlAddressCode.setDisabled(false);
        drlReasonSummary.setDisabled(false);
        btnCalStartDate.setDisabled(false);
        btnStartTime.setDisabled(false);
        btnCalEndDate.setDisabled(false);
        btnEndTime.setDisabled(false);
    }

    private void disableRequestGeneralAttributes() {
        txtaReasonDescription.setDisabled(true);
        txtDocReferenceNumber.setDisabled(true);
        drlAddressCode.setDisabled(true);
        drlReasonSummary.setDisabled(true);
        btnCalStartDate.setDisabled(true);
        btnStartTime.setDisabled(true);
        btnCalEndDate.setDisabled(true);
        btnEndTime.setDisabled(true);
    }

    private boolean isEmployeeInRequesterDepartment(String requesterId, String employeeId) {
        return true;
    }

    public String btnAddToTable_action()  {
//        try {
//            if (validateAndInitializeDateAndTime()) {//if time and date is valid check if employee is repeated
//                if (chechAvailablityOfEmployee(employeeId)) {
//                    if (employeeManager.isBossOfEmployee(requesterId, employeeId)) {
//                    } else {
//                        showSuccessOrFailureMessage(false, "EMPLOYEE IS NOT IN YOUR DEPARTMENT");
//                    }
//                    currentRequestModel = new OverTimeRequestModel(
//                            txtParticipantId.getValue().toString(),
//                            txtParticipantFullName.getValue().toString(),
//                            txtParticipantDepartment.getValue().toString(),
//                            startDate,
//                            startTime,
//                            endDate,
//                            endTime,
//                            overTimeFactor,
//                            OverTimeRequestManager.DATABASE_STATUS_NEW);
//                    requestModelList.add(currentRequestModel);
//                    clearParticipantComponents();
//
//
//                } else {
//                    showSuccessOrFailureMessage(false, "EMPLOYEE ALREADY REGISTERED");
//                }
//            } else {
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//            showSuccessOrFailureMessage(false, "Participant Not Selected");
//        }
//        return null;

//        try {
//            if (validateAndInitializeDateAndTime()) {//if time and date is valid check if employee is repeated
//                if (chechAvailablityOfEmployee(employeeId)) {
//                    if (employeeManager.isBossOfEmployee(requesterId, employeeId)) {
//                    HashMap shifts = new HashMap();
//                    boolean isBetween = false;
//                    HashMap shiftName = null;
//                    String sunday = "2012-01-01";
//                    try {
//                        shiftName = shft.selectShiftRegistration(txtParticipantId.getValue().toString());
//                    } catch (Exception ex) {
//                    }
//                    if (shiftName.get("Shift").toString().equalsIgnoreCase("Office")) {
//                        showSuccessOrFailureMessage(true, "You are not shift employee. So over time request accepted!");
//                        currentRequestModel = new OverTimeRequestModel(
//                                txtParticipantId.getValue().toString(),
//                                txtParticipantFullName.getValue().toString(),
//                                txtParticipantDepartment.getValue().toString(),
//                                startDate,
//                                startTime,
//                                endDate,
//                                endTime,
//                                overTimeFactor,
//                                OverTimeRequestManager.DATABASE_STATUS_NEW);
//                        requestModelList.add(currentRequestModel);
//                        clearParticipantComponents();
//                    } else {
//
//                        if (StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString()) > 1) {
//
//                            showSuccessOrFailureMessage(false, "OVER TIME REQUEST IS ALLOWED PER DAY FOR SHIFT EMPLOYEES!");
//                        } else {
//
//                            String appliedDateforTraining = txtAppliedDate.getValue().toString();
//                            if(!checkSunday((appliedDateforTraining))){//if(!isSunday(sunday,txtAppliedDate.getValue().toString())){
//
//                            shifts = calculateShifts(txtAppliedDate.getValue().toString());
//                            for (int i = Integer.valueOf(shifts.get("START_TIME").toString().split(":")[0]); i <= Integer.valueOf(shifts.get("END_TIME").toString().split(":")[0]); i++) {
//                                if (Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == i || Integer.valueOf(txtEndTime.getValue().toString().split(":")[0]) == i) {
//                                    isBetween = true;
//                                }
//                            }
//                            if (isBetween) {
//                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.GO AND CHECK HIS/HER SHIFT TIME!");
//                            } else {
//                                 showSuccessOrFailureMessage(true, "It is NOT your shift now. So over time request accepted!");
//                                currentRequestModel = new OverTimeRequestModel(
//                                        txtParticipantId.getValue().toString(),
//                                        txtParticipantFullName.getValue().toString(),
//                                        txtParticipantDepartment.getValue().toString(),
//                                        startDate,
//                                        startTime,
//                                        endDate,
//                                        endTime,
//                                        overTimeFactor,
//                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
//                                requestModelList.add(currentRequestModel);
//                                clearParticipantComponents();
//                            }
//
//                          }else{
//                                showSuccessOrFailureMessage(true, "It is sunday. So over time request accepted!");
//                               currentRequestModel = new OverTimeRequestModel(
//                                        txtParticipantId.getValue().toString(),
//                                        txtParticipantFullName.getValue().toString(),
//                                        txtParticipantDepartment.getValue().toString(),
//                                        startDate,
//                                        startTime,
//                                        endDate,
//                                        endTime,
//                                        overTimeFactor,
//                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
//                                requestModelList.add(currentRequestModel);
//                                clearParticipantComponents();
//                             }
//                        }
//
//                     }
//
//                   } else {
//                        showSuccessOrFailureMessage(false, "EMPLOYEE IS NOT IN YOUR DEPARTMENT");
//                    }
//                } else {
//                    showSuccessOrFailureMessage(false, "EMPLOYEE ALREADY REGISTERED");
//                }
//            } else {
//                showSuccessOrFailureMessage(false, "TIME or DATE not correct");
//            }
//        } catch (NullPointerException npe) {
//
//            showSuccessOrFailureMessage(false, "Participant Not Registered as shift employee");
//        }
//        return null;
        
        Date selectedAppliedDate = (Date) calStartDate.getValue();
        Date selectedTerminationDate = (Date) calEndDate.getValue();
        long dateDifference = (selectedTerminationDate.getTime() - selectedAppliedDate.getTime()) / (1000 * 60 * 60 * 24);

          try {
            if (validateAndInitializeDateAndTime()) {//if time and date is valid check if employee is repeated
                if (chechAvailablityOfEmployee(employeeId)) {
                    if (employeeManager.employeLevel(employeeId) == 1) {
                        showSuccessOrFailureMessage(false, "You Can’t Request OT for Team Leaders And Above ");
//                        clearParticipantComponents();
                    } else {
                        if (requestManager.delegatedEmployeLevel(employeeId) == 1) {
                        showSuccessOrFailureMessage(false, "You Can’t Request OT for Delegated Team Leaders And Above ");
//                        clearParticipantComponents();
                    } else {

                    if (!(employeeManager.isBossOftheEmployee(txtRequesterId.getValue().toString(), employeeId))) {
//                        } else {
                        showSuccessOrFailureMessage2(false, "EMPLOYEE IS NOT IN YOUR DEPARTMENT");
                        }
                    HashMap shifts = new HashMap();
                    HashMap shiftInfo = null;
                    String shif = "SH";
                    boolean isBetween = false;
                    boolean inside = false;
                    HashMap shiftName = null;
                    String sunday = "2012-01-01";
                    try {
                        shiftName = shft.selectShiftRegistration(txtParticipantId.getValue().toString());
                    } catch (Exception ex) {
                    }
                    if ((shiftName.get("Shift").toString().equalsIgnoreCase("Office"))||(shiftName.get("Shift").toString().equalsIgnoreCase("Shift"))||
                            (shiftName.get("Shift").toString().equalsIgnoreCase("null"))||(shiftName.get("Shift").toString().equalsIgnoreCase("Normal"))) {

                       if (dateDifference >= 1) {//StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString() > 1)

//                            showSuccessOrFailureMessage(false, "OVER TIME REQUEST IS ALLOWED PER DAY FOR NORMAL EMPLOYEES!");
                           showSuccessOrFailureMessage(false, "OVER TIME REQUEST IS ALLOWED ONLY PER DAY!");
                        } else {

                            String startDateforTraining = txtStartDate.getValue().toString();
                          if(!checkHolidayButNotWeekend((startDateforTraining))){
                            if(!checkSunday((startDateforTraining))){//if(!isSunday(sunday,txtAppliedDate.getValue().toString())){
                              if(!checkSaturday((startDateforTraining))){
//                            shifts = calculateShifts(txtAppliedDate.getValue().toString());
                            for (int i = Integer.valueOf("08:00".split(":")[0]); i < Integer.valueOf("16:00".split(":")[0]); i++) {
                                if (Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == i || Integer.valueOf(txtEndTime.getValue().toString().split(":")[0]) == i) {
                                    isBetween = true;
                                }
                            }
                            if (isBetween) {
                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.B/C IT IS YOUR WORK TIME!");
                            } else {
//                                dayType = "NORMAL";
                                 showSuccessOrFailureMessage(true, "It is NOT your work time now. So over time request accepted!");
                                currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.NORMAL,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                            }
                           } else {
                                 for (int i = Integer.valueOf("08:00".split(":")[0]); i < Integer.valueOf("12:30".split(":")[0]); i++) {
                                if (Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == i || Integer.valueOf(txtEndTime.getValue().toString().split(":")[0]) == i) {
                                    isBetween = true;
                                }
                            }
                                  if ((Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == 12)) {
                                      for (int i = 0; i < 30; i++) {
                                          if ((Integer.valueOf(txtStartTime.getValue().toString().split(":")[1]) == i)) {
                                              isBetween = true;
                                          }
                                      }
                                  }

//                            if (isBetween) {
//                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.B/C IT IS YOUR WORK TIME (Saturday Morning)!");
//                            } else {
////                                     dayType = "SATURDAY";
                                 showSuccessOrFailureMessage(true, "It is NOT your work time now. So over time request accepted(Saturday Afternoon)!");
                                currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.SATURDAY,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                           // }
                           }
                             }else{
//                                dayType = "SUNDAY";
                                showSuccessOrFailureMessage(true, "It is sunday. So over time request accepted!");
                               currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.SUNDAY,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                             }
                          }else{
//                                dayType = "HOLIDAY";
                                showSuccessOrFailureMessage(true, "It is Holiday. So over time request accepted!");
                               currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.HOLIDAY,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                             }
                        }

                    } else {

                        if (dateDifference >= 1) {//StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString()) > 1

//                            showSuccessOrFailureMessage(false, "OVER TIME REQUEST IS ALLOWED PER DAY FOR SHIFT EMPLOYEES!");
                            showSuccessOrFailureMessage(false, "OVER TIME REQUEST IS ALLOWED ONLY PER DAY!");
                        } else {

                            String startDateforTraining = txtStartDate.getValue().toString();
                          if(!checkHolidayButNotWeekend((startDateforTraining))){
                            if(!checkSunday((startDateforTraining))){//if(!isSunday(sunday,txtAppliedDate.getValue().toString())){
                              if(!checkSaturday((startDateforTraining))){

                            shifts = calculateShifts(txtStartDate.getValue().toString());
                            for (int i = Integer.valueOf(shifts.get("START_TIME").toString().split(":")[0]); i <= Integer.valueOf(shifts.get("END_TIME").toString().split(":")[0]); i++) {
                                if (Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == i || Integer.valueOf(txtEndTime.getValue().toString().split(":")[0]) == i) {
                                    isBetween = true;
                                }
                            }
                            if (isBetween) {
//                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.GO AND CHECK HIS/HER SHIFT TIME!");

////////////////////////////////////////  New correction to allow to accept over time request to his shift if the shift employee work on other shift by substitution
                            String shiftCode = shifts.get("SHIFT_CODE").toString().split(":")[0];
                            int shiftNumber = Integer.parseInt(shiftCode.substring(2,3));
                            String tempShift = transportAbsenceDateRegistrationManager.getAllWorkWithoutShift(txtParticipantId.getValue().toString(), shiftNumber, txtStartDate.getValue().toString());
                            int tempshiftNumber = Integer.parseInt(tempShift);
                            if ((!(tempShift.equalsIgnoreCase("NO")))&& (tempshiftNumber == shiftNumber)){
//                            shif = shif.concat(Integer.valueOf(tempShift).toString());
//                            shiftInfo = shft.selectShifts(shif,drlAddressCode.getValue().toString());
//                            for (int i = Integer.valueOf(shiftInfo.get("START_TIME").toString().split(":")[0]); i <= Integer.valueOf(shiftInfo.get("END_TIME").toString().split(":")[0]); i++) {
//                                if (Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == i || Integer.valueOf(txtEndTime.getValue().toString().split(":")[0]) == i) {
//                                    isBetween = true;
//                                }
//                            }
//                            if (isBetween) {
//                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.GO AND CHECK HIS/HER SHIFT TIME!");
//                            } else {
//                                dayType = "NORMAL";
                                 showSuccessOrFailureMessage(true, "It is your shift now. But you work on other shift. So over time request accepted!");
                                currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.NORMAL,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
//                            }
                           } else {
                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.GO AND CHECK HIS/HER SHIFT TIME!");
                           }
////////////////////////////////////////

                            } else {
//                                dayType = "NORMAL";
                                 showSuccessOrFailureMessage(true, "It is NOT your shift now. So over time request accepted!");
                                currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.NORMAL,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                            }

                           } else {
                                for (int i = Integer.valueOf("08:00".split(":")[0]); i < Integer.valueOf("16:00".split(":")[0]); i++) {
                                if (Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == i || Integer.valueOf(txtEndTime.getValue().toString().split(":")[0]) == i) {
                                    inside = true;
                                }
                            }

//                                if ((Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == 12)) {
//                                      for (int i = 0; i < 30; i++) {
//                                          if ((Integer.valueOf(txtStartTime.getValue().toString().split(":")[1]) == i)) {
//                                              inside = true;
//                                          }
//                                      }
//                                  }

                            if (!inside) {
//                                dayType = "SATURDAY";
//                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.B/C IT IS YOUR WORK TIME!");
                                showSuccessOrFailureMessage(true, "It is Saturday afternoon. So over time request accepted!");
                                currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.SATURDAY,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                            } else {

                                    shifts = calculateShifts(txtStartDate.getValue().toString());
                            for (int i = Integer.valueOf(shifts.get("START_TIME").toString().split(":")[0]); i <= Integer.valueOf(shifts.get("END_TIME").toString().split(":")[0]); i++) {
                                if (Integer.valueOf(txtStartTime.getValue().toString().split(":")[0]) == i || Integer.valueOf(txtEndTime.getValue().toString().split(":")[0]) == i) {
                                    isBetween = true;
                                }
                            }
                            if (isBetween) {
                                showSuccessOrFailureMessage(false, "YOU CANNOT REQUEST OVERTIME WITHIN THIS GAP.GO AND CHECK HIS/HER SHIFT TIME!");
                            } else {
                                 showSuccessOrFailureMessage(true, "It is NOT your shift now. So over time request accepted!");
                                currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                            }
//                                 showSuccessOrFailureMessage(true, "It is NOT your work time now. So over time request accepted!");
//                                currentRequestModel = new OverTimeRequestModel(
//                                        txtParticipantId.getValue().toString(),
//                                        txtParticipantFullName.getValue().toString(),
//                                        txtParticipantDepartment.getValue().toString(),
//                                        startDate,
//                                        startTime,
//                                        endDate,
//                                        endTime,
//                                        overTimeFactor,
//                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
//                                requestModelList.add(currentRequestModel);
//                                clearParticipantComponents();
                            }
                           }
                          }else{
//                                dayType = "SUNDAY";
                                showSuccessOrFailureMessage(true, "It is sunday. So over time request accepted!");
                               currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.SUNDAY,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                           }
                          }else{
//                                dayType = "HOLIDAY";
                                showSuccessOrFailureMessage(true, "It is Holiday. So over time request accepted!");
                               currentRequestModel = new OverTimeRequestModel(
                                        txtParticipantId.getValue().toString(),
                                        txtParticipantFullName.getValue().toString(),
                                        txtParticipantDepartment.getValue().toString(),
                                        startDate,
                                        startTime,
                                        endDate,
                                        endTime,
                                        overTimeFactor,
                                        OverTimeRequestManager.HOLIDAY,
                                        OverTimeRequestManager.DATABASE_STATUS_NEW);
                                requestModelList.add(currentRequestModel);
                                clearParticipantComponents();
                             }
                        }

                     }
                   }
                 }
                } else {
                    showSuccessOrFailureMessage(false, "EMPLOYEE ALREADY REGISTERED");
                }
            } else {
                showSuccessOrFailureMessage(false, "TIME or DATE not correct");
            }
        } catch (NullPointerException npe) {

            showSuccessOrFailureMessage(false, "Participant Not Registered as shift employee");
        }
        return null;

    }
StringDateManipulation stringDateManipulation = new StringDateManipulation();
     public boolean checkSunday(String appliedDateforTraining) {
//        int dateDiff = 0;
//        dateDiff = StringDateManipulation.compareDateDifference(sunday, appliedDate);
//        if(Integer.valueOf(dateDiff) % 7==0) {return true;}
//        else {return false;}
         return stringDateManipulation.checkSunday(appliedDateforTraining);
    }

    public boolean checkSaturday(String appliedDateforTraining) {
         return stringDateManipulation.checkSaturday(appliedDateforTraining);
    }

    public boolean checkHolidayButNotWeekend(String appliedDateforTraining) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        LeaveControl leaveControl = new LeaveControl();
        return leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(appliedDateforTraining));
    }

    public String btnSearchParticipant_action() {
        if (txtParticipantId.getValue() != null && !txtParticipantId.getValue().toString().equals("")) {
            employeeId = txtParticipantId.getValue().toString();
            if (populateParticipantTextComponents(employeeId)) {
                //construct object
                btnAddToTable.setDisabled(false);
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtParticipantId.getValue().toString());
                btnAddToTable.setDisabled(true);
                employeeId = null;
            }
        } else {
            employeeId = null;
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
            btnAddToTable.setDisabled(true);
        }
        return null;
    }

    public String btnSave_action() {
        if (validateAndInitializeRequestAttributes()) {
            if (newOrEditOrUpdateLabel.equals("Save")) {
                if (overTimeRequestManager.saveOverTimeRequest(requesterId, appliedDate, reasonSummary, reasonDescription, addressCode, overTimeFactor, docReferenceNumber, requestModelList, loggedInEmployeeId)) {
                    pendingRequestList = overTimeRequestManager.getPendingRequests();
                    clearAllComponents();
                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
                } else {
                    showSuccessOrFailureMessage(false, "EXCEPTION OCCURED: SAVING FAILED");
                }
            } else {//if (newOrEditOrUpdateLabel.equals("Update")) {
                if (overTimeRequestManager.updateOverTimeRequest(overTimeRequestId, requesterId, appliedDate, reasonDescription, addressCode, overTimeFactor, docReferenceNumber, requestModelList)) {
                    showSuccessOrFailureMessage(true, "ALL CHANGES SAVED SUCCESSFULLY");
                    clearAllComponents();
                } else {
                    showSuccessOrFailureMessage(false, "EXCEPTION OCCURED: UPDATING DATABASE FAILED");
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

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
    public String btnClosePopupSuccessOrFailure1_action() {
        pnlPopupSuccessOrFailure1.setRendered(false);
        return null;
    }

    MgrEmployeeShiftViewer shft = new MgrEmployeeShiftViewer();
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

    public String btnCalStartDate_action() {
        calStartDate.setRendered(true);
        return null;
    }

    public String btnCalEndDate_action() {
        calEndDate.setRendered(true);
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        Date selectedDate = (Date) vce.getNewValue();
        txtStartDate.setValue(dateFormat.format(selectedDate));
        // txtEndDate.setValue(dateFormat.format(selectedDate));
        calStartDate.setRendered(false);
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
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
        return null;
    }

    public String txtParticipantFullName_action() {
        clearParticipantComponents();
        employeeId = ApplicationBean1.getSelectedEmployeeId();
        if (employeeManager.employeLevel(employeeId) == 1) {
            showSuccessOrFailureMessage(false, "You Can’t Request OT Tor Team Leaders And Above ");
            clearParticipantComponents();
        } else {
        populateParticipantTextComponents(employeeId);
        }
        return null;
    }

    public void setRequestHistoryList(ArrayList<SelectItem> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        try {
            this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    private boolean populateRequestAttributes(int overTimeRequestId) {
        overTimeRequestModel = overTimeRequestManager.getRequestAttributes(overTimeRequestId);
        if (overTimeRequestModel != null) {
            if (overTimeRequestModel.getoverTimeRequestId() != -1) {
                txtaReasonDescription.setValue(overTimeRequestModel.getReasonDescription());
                drlAddressCode.setValue(overTimeRequestModel.getAddressCode());
                drlReasonSummary.setValue(overTimeRequestModel.getReasonSummary());
                txtAppliedDate.setValue(overTimeRequestModel.getAppliedDate());
                txtDocReferenceNumber.setValue(overTimeRequestModel.getDocReferenceNumber());
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

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null && !vce.getNewValue().toString().equals("-1")) {
            clearAllComponents();
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            overTimeRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            status = requestAttributes[2];
            String loginId = overTimeRequestManager.getLoginId(overTimeRequestId);
            populateRequesterTextComponents(requesterId);
            populateLoginTextComponents(loginId);
            populateParticipantTable(overTimeRequestId);
            populateRequestAttributes(overTimeRequestId);
            if(status.contains("Res")) {
            makePageReadyForUpdate();
            }else {
            makePageReadyForView();
            }
//            makePageReadyForView();
        }
    }



    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null && !vce.getNewValue().toString().equals("-1")) {
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            clearAllComponents();
            overTimeRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            status = requestAttributes[2];
            String loginId = overTimeRequestManager.getLoginId(overTimeRequestId);
            populateRequesterTextComponents(requesterId);
            populateLoginTextComponents(loginId);
            populateParticipantTable(overTimeRequestId);
            populateRequestAttributes(overTimeRequestId);
            makePageReadyForUpdate();
        }
    }

    public void selectHistoryLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null && !vce.getNewValue().toString().equals("-1")) {
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            overTimeRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            status = requestAttributes[2];
            String loginId = overTimeRequestManager.getLoginId(overTimeRequestId);
            clearAllComponents();
            populateParticipantTextComponents(requesterId);
            populateLoginTextComponents(loginId);
            populateParticipantTable(overTimeRequestId);
            populateRequestAttributes(overTimeRequestId);
            makePageReadyForView();
        }
    }
    int selectedRow = -1;

    public void rowSelectorOverTime_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }

    public String cmdLnkRemove_action() {
        if (!buttonAction.equals("None")) {
            if (requestModelList.get(selectedRow).getDatabaseStatus().equals(OverTimeRequestManager.DATABASE_STATUS_NEW)) {
                requestModelList.remove(selectedRow);
            } else if (requestModelList.get(selectedRow).getDatabaseStatus().equals(OverTimeRequestManager.DATABASE_STATUS_OLD)) {
                requestModelList.get(selectedRow).setDatabaseStatus(OverTimeRequestManager.DATABASE_STATUS_OLDDELETED);
            }
        }
        return null;
    }
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
            } else {// if (startOrEnd.equals("End")) {
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
        String style = "border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 100px; top: 80px; overflow: auto; position: absolute; width: 280px";
        pnlLayoutTimePanel.setStyle(style);
        pnlLayoutTimePanel.setRendered(true);
        return null;
    }

    public String btnEndTime_action() {
        startOrEnd = "End";
        String style = "border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 400px; top: 80px; overflow: auto; position: absolute; width: 280px";
        pnlLayoutTimePanel.setStyle(style);
        pnlLayoutTimePanel.setRendered(true);
        return null;
    }

    public String btnCalAppliedDate_action() {
        calAppliedDate.setRendered(true);
        return null;
    }

    private void populateDecisionHistory(int overTimeRequestId) {
        OverTimeApproveManager overTimeApproveManager = new OverTimeApproveManager();
        decisionsMadeOnRequest = overTimeApproveManager.getRequestHistory(overTimeRequestId);
//        if (decisionsMadeOnRequest.size() > 0) {
//            lnkViewPrevieousDecisions.setRendered(true);
//        } else {
//            lnkViewPrevieousDecisions.setRendered(false);
//            makePageReadyForUpdate();
//        }
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(overTimeRequestId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtAppliedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    public String lnkOverTimeApprove_action() {
        return "OverTimeApprove";
    }

    public String lnkOverTimeAttendance_action() {
        return "OverTimeAttendance";
    }

    public String lnkOverTimeReport_action() {
        return "OverTimeRequestReport";
    }


    public HashMap calculateShifts(String appliedDate) {
        HashMap shiftName = null;
        HashMap list_shifts = null;
        int dateDiff = 0;
        int shCounter = 0;
        String shCount="";
        int counter = 0;

        int no_of_shifts = 0;
        String shift = "SH";
        try {//drlAddressCode
            shiftName = shft.selectShiftRegistration(txtParticipantId.getValue().toString());

            list_shifts = shft.selectShifts(shiftName.get("Shift").toString(),drlAddressCode.getValue().toString());
            shCount = shiftName.get("Shift").toString().substring(2,3) ;
            shCounter=Integer.parseInt( shCount);
            dateDiff = StringDateManipulation.compareDateDifference(list_shifts.get("REGISTERED_DATE").toString(), appliedDate);
            no_of_shifts = shft.selectAllShifts(drlAddressCode.getValue().toString()).size();

//            float no_of_holidays;
//            no_of_holidays = Integer.valueOf(dateDiff / 7);

//            dateDiff = (int) (dateDiff - no_of_holidays);
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
            shift = shift.concat(Integer.valueOf(shCounter).toString());
            list_shifts = shft.selectShifts(shift,drlAddressCode.getValue().toString());
            return list_shifts;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


}