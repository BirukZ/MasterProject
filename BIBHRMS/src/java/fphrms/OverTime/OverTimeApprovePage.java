/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.OverTime;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.overTimeManager.OverTimeApproveManager;
import manager.overTimeManager.OverTimeApproveManager.OverTimeDecisionModel;
import manager.overTimeManager.OverTimeRequestManager;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class OverTimeApprovePage extends AbstractPageBean {

    //==========================================================================================================
    DepartmentManage departmentManager = new DepartmentManage();
    OverTimeApproveManager overTimeApproveManager = new OverTimeApproveManager();
    OverTimeRequestManager overTimeRequestManager = new OverTimeRequestManager();
    OverTimeRequestModel overTimeRequestModel = new OverTimeRequestModel();
    OverTimeDecisionModel overTimeDecisionModel = new OverTimeDecisionModel();
    EmployeeManage employeeManager = new EmployeeManage();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    ArrayList<OverTimeRequestModel> requestModelList = new ArrayList<OverTimeRequestModel>();
    ArrayList<SelectItem> requestListByEmployee = new ArrayList<SelectItem>();
    ArrayList<SelectItem> addressCodeList = departmentManager.getAddressCode();
    ArrayList<SelectItem> reasonSummaryList = overTimeRequestManager.getOverTimeReasonsList();
    ArrayList<Option> requestHistoryList = new ArrayList<Option>();
    ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    //==========================================================================================================
    String loggedInEmployeeId;
    String loggedInEmployeeDept;
    String userName;
    int overTimeRequestId = -1;
    String requesterId;
    String requestStatus;
    //==========================================================================================================
    private DefaultSelectedData selectedRequestByEmployee = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromApprovableList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    //==========================================================================================================

    // <editor-fold defaultstate="collapsed" desc="ALL">
    // <editor-fold defaultstate="collapsed" desc="Gettrs and Setters">
    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public OverTimeDecisionModel getOverTimeDecisionModel() {
        return overTimeDecisionModel;
    }

    public void setOverTimeDecisionModel(OverTimeDecisionModel overTimeDecisionModel) {
        this.overTimeDecisionModel = overTimeDecisionModel;
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
    private DefaultSelectedData selectedObjectAddressCode = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectAddressCode() {
        return selectedObjectAddressCode;
    }

    public void setSelectedObjectAddressCode(DefaultSelectedData selectedObjectAddressCode) {
        this.selectedObjectAddressCode = selectedObjectAddressCode;
    }

    public ArrayList<SelectItem> getAddressCodeList() {
        return addressCodeList;
    }

    public void setAddressCodeList(ArrayList<SelectItem> addressCodeList) {
        this.addressCodeList = addressCodeList;
    }

    public DepartmentManage getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManage departmentManager) {
        this.departmentManager = departmentManager;
    }

    public ArrayList<Option> getRequestHistoryList() {
        return requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<Option> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public void setOverTimeRequestModel(OverTimeRequestModel overTimeRequestModel) {
        this.overTimeRequestModel = overTimeRequestModel;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public ArrayList<OverTimeRequestModel> getRequestModelList() {
        return requestModelList;
    }

    public void setRequestModelList(ArrayList<OverTimeRequestModel> requestModelList) {
        this.requestModelList = requestModelList;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
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

    public String getLoggedInEmployeeDept() {
        return loggedInEmployeeDept;
    }

    public void setLoggedInEmployeeDept(String loggedInEmployeeDept) {
        this.loggedInEmployeeDept = loggedInEmployeeDept;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public OverTimeApproveManager getOverTimeApproveManager() {
        return overTimeApproveManager;
    }

    public void setOverTimeApproveManager(OverTimeApproveManager overTimeApproveManager) {
        this.overTimeApproveManager = overTimeApproveManager;
    }

    public int getOverTimeRequestId() {
        return overTimeRequestId;
    }

    public void setOverTimeRequestId(int overTimeRequestId) {
        this.overTimeRequestId = overTimeRequestId;
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

    public ArrayList<SelectItem> getRequestListByEmployee() {
        return requestListByEmployee;
    }

    public void setRequestListByEmployee(ArrayList<SelectItem> requestListByEmployee) {
        this.requestListByEmployee = requestListByEmployee;
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public DefaultSelectedData getSelectedRequestByEmployee() {
        return selectedRequestByEmployee;
    }

    public void setSelectedRequestByEmployee(DefaultSelectedData selectedRequestByEmployee) {
        this.selectedRequestByEmployee = selectedRequestByEmployee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {

        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        userName = getSessionBean1().getUserName();
        populateApproverTextComponents(loggedInEmployeeId);
        overTimeApproveManager.setUserName(userName);
        overTimeRequestManager.setUserName(userName);
        requestListsToBeApproved = overTimeApproveManager.getRequestsToBeProcessed();
        requestHistoryList = overTimeApproveManager.getMyDecisionsOnRequests();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private HtmlInputTextarea txtaDeciderCommen1 = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderCommen1() {
        return txtaDeciderCommen1;
    }

    public void setTxtaDeciderCommen1(HtmlInputTextarea hit) {
        this.txtaDeciderCommen1 = hit;
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

    public DefaultSelectedData getSelectedRequestFromApprovableList() {
        return selectedRequestFromApprovableList;
    }

    public void setSelectedRequestFromApprovableList(DefaultSelectedData selectedRequestFromApprovableList) {
        this.selectedRequestFromApprovableList = selectedRequestFromApprovableList;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox selectMyHistoryLists) {
        this.selectMyHistoryLists = selectMyHistoryLists;
    }
    private HtmlSelectOneListbox selectRequestApprovableRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectRequestApprovableRequestLists() {
        return selectRequestApprovableRequestLists;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    public void setSelectRequestApprovableRequestLists(HtmlSelectOneListbox selectRequestApprovableRequestLists) {
        this.selectRequestApprovableRequestLists = selectRequestApprovableRequestLists;
    }
    private DefaultSelectedData selectBooleanCheckboxSelectedCandidiate = new DefaultSelectedData();

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public DefaultSelectedData getSelectBooleanCheckboxSelectedCandidiate() {
        return selectBooleanCheckboxSelectedCandidiate;
    }

    public void setSelectBooleanCheckboxSelectedCandidiate(DefaultSelectedData selectBooleanCheckboxSelectedCandidiate) {
        this.selectBooleanCheckboxSelectedCandidiate = selectBooleanCheckboxSelectedCandidiate;
    }
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlInputText txtDeciderPosition = new HtmlInputText();

    public HtmlInputText getTxtDeciderPosition() {
        return txtDeciderPosition;
    }

    public void setTxtDeciderPosition(HtmlInputText hit) {
        this.txtDeciderPosition = hit;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
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
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlInputText txtRequesterFullName = new HtmlInputText();

    public HtmlInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(HtmlInputText hit) {
        this.txtRequesterFullName = hit;
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
    private DefaultSelectedData selectObjectOfReasonSummary = new DefaultSelectedData();

    public ArrayList<SelectItem> getReasonSummaryList() {
        return reasonSummaryList;
    }

    public void setReasonSummaryList(ArrayList<SelectItem> reasonSummaryList) {
        this.reasonSummaryList = reasonSummaryList;
    }

    public DefaultSelectedData getSelectObjectOfReasonSummary() {
        return selectObjectOfReasonSummary;
    }

    public void setSelectObjectOfReasonSummary(DefaultSelectedData selectObjectOfReasonSummary) {
        this.selectObjectOfReasonSummary = selectObjectOfReasonSummary;
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
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }
    private HtmlCommandButton btnSearchDecider = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchDecider() {
        return btnSearchDecider;
    }

    public void setBtnSearchDecider(HtmlCommandButton hcb) {
        this.btnSearchDecider = hcb;
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
    private HtmlSelectOneMenu drlReasonSummary = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlReasonSummary() {
        return drlReasonSummary;
    }

    public void setDrlReasonSummary(HtmlSelectOneMenu hsom) {
        this.drlReasonSummary = hsom;
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
    public OverTimeApprovePage() {
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

    // </editor-fold >
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

    private void clearRequesterTextComponents() {
        requesterId = "-1";
        txtRequesterDepartment.setValue(null);
        txtRequesterId.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void clearRequestComponents() {
        overTimeRequestId = -1;
        txtaReason.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtAppliedDate.setValue(null);
        txtReferenceNumber.setValue(null);
        drlAddressCode.resetValue();
    }

    private void clearRequestDataTable() {
        requestModelList = new ArrayList<OverTimeRequestModel>();
    }

    private void clearDecision() {
        drlDecision.resetValue();
        txtaDeciderComment.setValue(null);
    }

    private void clearAllComponents() {
        clearRequesterTextComponents();
        clearRequestComponents();
        clearRequestDataTable();
        populateApproverTextComponents(loggedInEmployeeId);
        clearDecision();
    }

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(OverTimeApproveManager.OVERTIME_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(OverTimeApproveManager.OVERTIME_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (overTimeRequestId == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE TERMINATION TO DECIDE");
            return false;
        }
        return true;
    }

    public boolean saveOverTimeDecision() {
        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
        return overTimeApproveManager.saveOverTimeDecision(overTimeRequestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment, requestModelList);

    }

    public String btnPostDecision_action() {
        if (validateDecision()) {
            if (saveOverTimeDecision()) {
                clearAllComponents();
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                requestListsToBeApproved = overTimeApproveManager.getRequestsToBeProcessed();
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        return null;
    }

    public String txtDeligateeId_action() {
        return null;
    }


    // </editor-fold>
    private void populateRequesterTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                requesterId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(empInfoHashMap.get("employeeId"));
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
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

    public void selectRequestApprovableRequestLists_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        overTimeRequestId = Integer.parseInt(requestInfos[0]);
        requesterId = requestInfos[1];
        requestStatus = requestInfos[2];
        String loginId = overTimeApproveManager.getLoginId(overTimeRequestId);
        populateRequesterTextComponents(requesterId);
        populateLoginTextComponents(loginId);
        populateOverTimeRequestTextComponents(overTimeRequestId);
        populateEmployeesListToTable(overTimeRequestId);
        drlDecision.resetValue();
        availableDecisionsToMakeList = overTimeApproveManager.getAvailableDecisionsToMake(requestStatus);
        makePageReadyForSave();
        // decisionsMadeOnRequest = terminationApproveManager.getRequestHistory(terminationRequestId);
    }
    //==========================================================================================================

    private boolean populateOverTimeRequestTextComponents(int overTimeRequestId) {
        overTimeRequestModel = overTimeRequestManager.getRequestAttributes(overTimeRequestId);
        if (overTimeRequestModel != null) {
            if (overTimeRequestModel.getoverTimeRequestId() != -1) {
                txtaReason.setValue(overTimeRequestModel.getReasonDescription());
                drlAddressCode.setValue(overTimeRequestModel.getAddressCode());
                txtAppliedDate.setValue(overTimeRequestModel.getAppliedDate());
                txtReferenceNumber.setValue(overTimeRequestModel.getDocReferenceNumber());
                drlReasonSummary.setValue(overTimeRequestModel.getReasonSummary());
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

    private boolean populateEmployeesListToTable(int overTimeRequestId) {
        requestModelList = overTimeRequestManager.getEmployeeAndOverTimeList(overTimeRequestId);
        return true;
    }
//==========================================================================================================

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
    //==========================================================================================================
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
//==========================================================================================================

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
//==========================================================================================================

    public String btnReset_action() {
        clearAllComponents();
        return null;
    }
    //==========================================================================================================

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    private void populateDecisionHistory(int overTimeRequestId) {
        decisionsMadeOnRequest = overTimeApproveManager.getRequestHistory(overTimeRequestId);
        if (decisionsMadeOnRequest.size() > 0) {
            lnkViewPrevieousDecisions.setRendered(true);
        } else {
            lnkViewPrevieousDecisions.setRendered(false);
            // makePageReadyForUpdate();
        }
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(overTimeRequestId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }
//==========================================================================================================

//    private void makePageReadyForSave() {
//        overTimeRequestId = -1;
//        enableButtons();
//        enableRequestTextComponents();
//        enableRequestGeneralAttributes();
//    }
//
//    private void makePageReadyForUpdate() {
//        newOrEditOrUpdateLabel = "Update";
//        enableButtons();
//        enableRequestTextComponents();
//        enableRequestGeneralAttributes();
//
//    }
//
    private void makePageReadyForView() {
        btnPostDecision.setDisabled(true);
        drlDecision.setDisabled(true);
    }

    private void makePageReadyForSave() {
        btnPostDecision.setDisabled(false);
        drlDecision.setDisabled(false);
    }
//
//    private void disableButtons() {
//        btnSave.setDisabled(true);
//        btnDelete.setDisabled(true);
//    }
//
//    private void enableButtons() {
//        btnSave.setDisabled(false);
//        btnDelete.setDisabled(false);
//    }
//
//==========================================================================================================

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        overTimeRequestId = Integer.parseInt(requestInfos[0]);
        requesterId = requestInfos[1];
        requestStatus = requestInfos[2];
        String loginId = overTimeRequestManager.getLoginId(overTimeRequestId);
        populateRequesterTextComponents(requesterId);
        populateLoginTextComponents(loginId);
        populateOverTimeRequestTextComponents(overTimeRequestId);
        populateEmployeesListToTable(overTimeRequestId);
        makePageReadyForView();
        // availableDecisionsToMakeList = overTimeApproveManager.getAvailableDecisionsToMake(requestStatus);
    }
//==========================================================================================================

    public String btnSearchDecider_action() {
        if (btnSearchDecider.getValue().toString().equals("Change")) {
            btnSearchDecider.setValue("Search");
            txtDeciderId.setDisabled(false);
        } else {
            if (txtDeciderId.getValue() != null && !txtDeciderId.getValue().toString().equals("")) {
                populateApproverTextComponents(txtDeciderId.getValue().toString());
                btnSearchDecider.setValue("Change");
                txtDeciderId.setDisabled(true);
            }
        }
        return null;
    }

    public void pnlGrpPowerDeligationContent_processMyEvent(DragEvent de) {
    }

    public String lnkRequestPage_action() {
        return "OverTimeRequest";
    }

    public String lnkOverTimeAttendancePage_action() {
        return "OverTimeAttendance";
    }

    public String lnkOverTimeReport_action() {
       return "OverTimeApproveReport";
    }
}
