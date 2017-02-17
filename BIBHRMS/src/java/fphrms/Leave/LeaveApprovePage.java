/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Leave;

import com.icesoft.faces.async.render.OnDemandRenderer;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.JodanTimeCalender;
import manager.leaveManager.LeaveApproveManager;
import manager.leaveManager.LeaveBalanceManager;
import manager.leaveManager.LeaveRequestManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LeaveApprovePage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    //for ajax push
//    private LeaveManager leaveManager = new LeaveManager();
    private EmployeeManage employeeManage = new EmployeeManage();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    LeaveApproveManager leaveApproveManager = new LeaveApproveManager();
    LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
    ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    private ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    private int workflowId = 0;
    private ArrayList<SelectItem> stateTransions = new ArrayList<SelectItem>();
    private LeaveBalanceManager leaveBalanceManager = new LeaveBalanceManager();
    /////////////////////////////////////
    public static OnDemandRenderer personGroup = null;
    private String loggedInUserId = null;
    public String leavWOEmployeeID;
    public String leavWoRequestYear;
    public String leaveWoRequestDate;
    public float leavWoDeducatedAmout;
    public String leavWoRequestId;
    public String leaveWoAmount;
    public float leaveWoUsed;
    public float leaveWodd;
    String userName = null;
    private int currentStateId = 0;
    private int resubmitStateId = 0;
    private int approveStateId = 0;
    private int rejectStateId = 0;
    private int currentWorkflowId = 0;
    private String requesterId = null;
    private String leaveRequesterId = null;
    private String leaveTransferId = null;
    private int itemId = 0;
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<SelectItem> newRequestArraivalsList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> newRequests = new ArrayList<SelectItem>();
    private byte[] employeePicture;
    private byte[] attachedDBImg;
    private boolean intLoad = true;
    private static int resourceId = 0;
    private int rowSelector = -1;
    int leaveRequestId;
    String requestStatus;
    String requestedDate;
    boolean firstTime = true;
    private ArrayList<LeaveRequestInformation> listOfLeaveRequest = new ArrayList<LeaveRequestInformation>();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();

    public float getLeaveWodd() {
        return leaveWodd;
    }

    public void setLeaveWodd(float leaveWodd) {
        this.leaveWodd = leaveWodd;
    }

    public float getLeaveWoUsed() {
        return leaveWoUsed;
    }

    public void setLeaveWoUsed(float leaveWoUsed) {
        this.leaveWoUsed = leaveWoUsed;
    }

    public String getLeaveWoAmount() {
        return leaveWoAmount;
    }

    public void setLeaveWoAmount(String leaveWoAmount) {
        this.leaveWoAmount = leaveWoAmount;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public ArrayList<LeaveRequestInformation> getListOfLeaveRequest() {
        return listOfLeaveRequest;
    }

    public void setListOfLeaveRequest(ArrayList<LeaveRequestInformation> listOfLeaveRequest) {
        this.listOfLeaveRequest = listOfLeaveRequest;
    }

    public String getLeavWOEmployeeID() {
        return leavWOEmployeeID;
    }

    public void setLeavWOEmployeeID(String leavWOEmployeeID) {
        this.leavWOEmployeeID = leavWOEmployeeID;
    }

    public float getLeavWoDeducatedAmout() {
        return leavWoDeducatedAmout;
    }

    public void setLeavWoDeducatedAmout(float leavWoDeducatedAmout) {
        this.leavWoDeducatedAmout = leavWoDeducatedAmout;
    }

    public String getLeavWoRequestId() {
        return leavWoRequestId;
    }

    public void setLeavWoRequestId(String leavWoRequestId) {
        this.leavWoRequestId = leavWoRequestId;
    }

    public String getLeavWoRequestYear() {
        return leavWoRequestYear;
    }

    public void setLeavWoRequestYear(String leavWoRequestYear) {
        this.leavWoRequestYear = leavWoRequestYear;
    }

    public String getLeaveWoRequestDate() {
        return leaveWoRequestDate;
    }

    public void setLeaveWoRequestDate(String leaveWoRequestDate) {
        this.leaveWoRequestDate = leaveWoRequestDate;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        //    setNewRequestArraivalsList(leaveManager.readLeaveRequestsList());
        if (firstTime) {
            firstTime = false;
            loggedInUserId = getSessionBean1().getEmployeeId();
            lblCurrentOwnerGroup.setValue(getSessionBean1().getEmployeeName());
            userName = getSessionBean1().getUserName();
            populateApproverTextComponents(loggedInUserId);
            leaveApproveManager.setUserName(userName);
            leaveApproveManager.setLoggedInEmployeeId(loggedInUserId);
            leaveRequestManager.setUserName(userName);
            loadEmployeeLeaveRequet();
        }
    }

    private void loadEmployeeLeaveRequet() {
        requestListsToBeApproved = leaveApproveManager.getRequestsToBeProcessed(getSessionBean1().getEmployeeId());
    }

    private boolean populateApproverTextComponents(String approverId) {
        HashMap empInfoHashMap = employeeManage.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
                txtDeciderId.setDisabled(false);
                return false;
            } else {
                approverId = empInfoHashMap.get("employeeId").toString();
                lblDecider_Department.setValue(empInfoHashMap.get("employeeDepartmentName"));
                lblEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                //  lblDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                lblDeciderPosition.setValue(empInfoHashMap.get("employeePositionName"));

                return true;
            }

        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private HtmlOutputText lblEmployeeId = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeId() {
        return lblEmployeeId;
    }

    public void setLblEmployeeId(HtmlOutputText hot) {
        this.lblEmployeeId = hot;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public int getApproveStateId() {
        return approveStateId;
    }

    public void setApproveStateId(int approveStateId) {
        this.approveStateId = approveStateId;
    }

    public int getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(int currentStateId) {
        this.currentStateId = currentStateId;
    }

    public int getCurrentWorkflowId() {
        return currentWorkflowId;
    }

    public void setCurrentWorkflowId(int currentWorkflowId) {
        this.currentWorkflowId = currentWorkflowId;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }

    public void setEmployeeManage(EmployeeManage employeeManage) {
        this.employeeManage = employeeManage;
    }

    public boolean isIntLoad() {
        return intLoad;
    }

    public void setIntLoad(boolean intLoad) {
        this.intLoad = intLoad;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public JodanTimeCalender getJodanTimeCalender() {
        return jodanTimeCalender;
    }

    public void setJodanTimeCalender(JodanTimeCalender jodanTimeCalender) {
        this.jodanTimeCalender = jodanTimeCalender;
    }

    public LeaveApproveManager getLeaveApproveManager() {
        return leaveApproveManager;
    }

    public void setLeaveApproveManager(LeaveApproveManager leaveApproveManager) {
        this.leaveApproveManager = leaveApproveManager;
    }

    public int getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public LeaveRequestManager getLeaveRequestManager() {
        return leaveRequestManager;
    }

    public void setLeaveRequestManager(LeaveRequestManager leaveRequestManager) {
        this.leaveRequestManager = leaveRequestManager;
    }

    public String getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(String loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public static OnDemandRenderer getPersonGroup() {
        return personGroup;
    }

    public static void setPersonGroup(OnDemandRenderer personGroup) {
        LeaveApprovePage.personGroup = personGroup;
    }

    public int getRejectStateId() {
        return rejectStateId;
    }

    public void setRejectStateId(int rejectStateId) {
        this.rejectStateId = rejectStateId;
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<Option> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public static int getResourceId() {
        return resourceId;
    }

    public static void setResourceId(int resourceId) {
        LeaveApprovePage.resourceId = resourceId;
    }

    public int getResubmitStateId() {
        return resubmitStateId;
    }

    public void setResubmitStateId(int resubmitStateId) {
        this.resubmitStateId = resubmitStateId;
    }

    public int getRowSelector() {
        return rowSelector;
    }

    public void setRowSelector(int rowSelector) {
        this.rowSelector = rowSelector;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(int workflowId) {
        this.workflowId = workflowId;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox4Bean() {
        return selectBooleanCheckbox4Bean;
    }

    public void setSelectBooleanCheckbox4Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox4Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox5Bean() {
        return selectBooleanCheckbox5Bean;
    }

    public void setSelectBooleanCheckbox5Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox5Bean = dsd;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlSelectBooleanCheckbox chkMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMale() {
        return chkMale;
    }

    public void setChkMale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkFemale() {
        return chkFemale;
    }

    public void setChkFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkFemale = hsbc;
    }
    private HtmlOutputText lblHireDate = new HtmlOutputText();

    public HtmlOutputText getLblHireDate() {
        return lblHireDate;
    }

    public void setLblHireDate(HtmlOutputText hot) {
        this.lblHireDate = hot;
    }
    private HtmlOutputText lblPosition = new HtmlOutputText();

    public HtmlOutputText getLblPosition() {
        return lblPosition;
    }

    public void setLblPosition(HtmlOutputText hot) {
        this.lblPosition = hot;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }

    public ArrayList<SelectItem> getNewRequestArraivalsList() {
        return newRequestArraivalsList;
    }

    public void setNewRequestArraivalsList(ArrayList<SelectItem> newRequestArraivalsList) {
        this.newRequestArraivalsList = newRequestArraivalsList;
    }
    private HtmlSelectOneListbox lstNewRequests = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstNewRequests() {
        return lstNewRequests;
    }

    public void setLstNewRequests(HtmlSelectOneListbox hsol) {
        this.lstNewRequests = hsol;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }
    private PanelPopup pnlPopUpAttachment = new PanelPopup();

    public PanelPopup getPnlPopUpAttachment() {
        return pnlPopUpAttachment;
    }

    public void setPnlPopUpAttachment(PanelPopup pp) {
        this.pnlPopUpAttachment = pp;
    }
    private HtmlGraphicImage gimgAttachedDocuments = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgAttachedDocuments() {
        return gimgAttachedDocuments;
    }

    public void setGimgAttachedDocuments(HtmlGraphicImage hgi) {
        this.gimgAttachedDocuments = hgi;
    }

    public byte[] getAttachedDBImg() {
        return attachedDBImg;
    }

    public void setAttachedDBImg(byte[] attachedDBImg) {
        this.attachedDBImg = attachedDBImg;
    }
    private HtmlOutputText lblCurrentState = new HtmlOutputText();

    public HtmlOutputText getLblCurrentState() {
        return lblCurrentState;
    }

    public void setLblCurrentState(HtmlOutputText hot) {
        this.lblCurrentState = hot;
    }
    private HtmlOutputText lblCurrentOwnerGroup = new HtmlOutputText();

    public HtmlOutputText getLblCurrentOwnerGroup() {
        return lblCurrentOwnerGroup;
    }

    public void setLblCurrentOwnerGroup(HtmlOutputText hot) {
        this.lblCurrentOwnerGroup = hot;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }

    public ArrayList<SelectItem> getStateTransions() {
        return stateTransions;
    }

    public void setStateTransions(ArrayList<SelectItem> stateTransions) {
        this.stateTransions = stateTransions;
    }
    private HtmlSelectOneMenu ddlstStateTransitions = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdlstStateTransitions() {
        return ddlstStateTransitions;
    }

    public void setDdlstStateTransitions(HtmlSelectOneMenu hsom) {
        this.ddlstStateTransitions = hsom;
    }
    private HtmlInputTextarea txtDecisionRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDecisionRemark() {
        return txtDecisionRemark;
    }

    public void setTxtDecisionRemark(HtmlInputTextarea hit) {
        this.txtDecisionRemark = hit;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }
    private HtmlCommandLink lnkTransionHistory = new HtmlCommandLink();

    public HtmlCommandLink getLnkTransionHistory() {
        return lnkTransionHistory;
    }

    public void setLnkTransionHistory(HtmlCommandLink hcl) {
        this.lnkTransionHistory = hcl;
    }
    private PanelPopup pnlTransionHistory = new PanelPopup();

    public PanelPopup getPnlTransionHistory() {
        return pnlTransionHistory;
    }

    public void setPnlTransionHistory(PanelPopup pp) {
        this.pnlTransionHistory = pp;
    }

    public ArrayList<SelectItem> getNewRequests() {

        return newRequests;
    }

    public void setNewRequests(ArrayList<SelectItem> newRequests) {
        this.newRequests = newRequests;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
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
    private HtmlOutputText lblDecider_Department = new HtmlOutputText();

    public HtmlOutputText getLblDecider_Department() {
        return lblDecider_Department;
    }

    public void setLblDecider_Department(HtmlOutputText hot) {
        this.lblDecider_Department = hot;
    }
    private HtmlOutputText lblEmployeeFullName = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeFullName() {
        return lblEmployeeFullName;
    }

    public void setLblEmployeeFullName(HtmlOutputText hot) {
        this.lblEmployeeFullName = hot;
    }
    private HtmlOutputText lblDeciderPosition = new HtmlOutputText();

    public HtmlOutputText getLblDeciderPosition() {
        return lblDeciderPosition;
    }

    public void setLblDeciderPosition(HtmlOutputText hot) {
        this.lblDeciderPosition = hot;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private HtmlCommandLink btnClosePopupViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupViewPrevieousDecisions() {
        return btnClosePopupViewPrevieousDecisions;
    }

    public void setBtnClosePopupViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.btnClosePopupViewPrevieousDecisions = hcl;
    }
    private HtmlOutputText lblDesstionStatus = new HtmlOutputText();

    public HtmlOutputText getLblDesstionStatus() {
        return lblDesstionStatus;
    }

    public void setLblDesstionStatus(HtmlOutputText hot) {
        this.lblDesstionStatus = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LeaveApprovePage() {
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

    private void loadRequestInfo(String requestId) {

        HashMap hm = null;// leaveManager.readRequestsInfo(requestId);//load the request info from manager.
        if (hm != null) {//check the returned hash map from manager is not null.
            currentStateId = Integer.valueOf(hm.get("stateId").toString());
            itemId = Integer.valueOf(hm.get("itemId").toString());
            currentWorkflowId = Integer.valueOf(hm.get("workflowId").toString());
            this.workflowId = Integer.valueOf(hm.get("workflowId").toString());
//            lblWorkflow.setValue(": " + hm.get("workflowName").toString());
            lblCurrentState.setValue(": " + hm.get("stateId").toString() + "-[ " + hm.get("stateName").toString() + " ]");
            lblCurrentOwnerGroup.setValue(": " + hm.get("ownerId").toString() + "-[ " + hm.get("ownerName").toString() + " ]");
        //Read Possible States

        }

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
    private EmployeeManage employeeManager = new EmployeeManage();

//=============================Leave Request information
    public static class LeaveRequestInformation implements Serializable {

        private String leaveId;
        private String leaveDayes;
        private String requestedDateFrom;
        private String requestedDateTo;
        private String requestReason;
        private String leaveType;
        private boolean selected;
        private boolean approveList;
        private String leaveBalance;
        private String physicalYear;
        private String returnDate;

        public String getLeaveBalance() {
            return leaveBalance;
        }

        public void setLeaveBalance(String leaveBalance) {
            this.leaveBalance = leaveBalance;
        }

        public String getPhysicalYear() {
            return physicalYear;
        }

        public void setPhysicalYear(String physicalYear) {
            this.physicalYear = physicalYear;
        }

        public String getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(String returnDate) {
            this.returnDate = returnDate;
        }

        public boolean isApproveList() {
            return approveList;
        }

        public void setApproveList(boolean approveList) {
            this.approveList = approveList;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getLeaveDayes() {
            return leaveDayes;
        }

        public void setLeaveDayes(String leaveDayes) {
            this.leaveDayes = leaveDayes;
        }

        public String getLeaveId() {
            return leaveId;
        }

        public void setLeaveId(String leaveId) {
            this.leaveId = leaveId;
        }

        public String getLeaveType() {
            return leaveType;
        }

        public void setLeaveType(String leaveType) {
            this.leaveType = leaveType;
        }

        public String getRequestReason() {
            return requestReason;
        }

        public void setRequestReason(String requestReason) {
            this.requestReason = requestReason;
        }

        public String getRequestedDateFrom() {
            return requestedDateFrom;
        }

        public void setRequestedDateFrom(String requestedDateFrom) {
            this.requestedDateFrom = requestedDateFrom;
        }

        public String getRequestedDateTo() {
            return requestedDateTo;
        }

        public void setRequestedDateTo(String requestedDateTo) {
            this.requestedDateTo = requestedDateTo;
        }

        public LeaveRequestInformation(String leaveId,
                String leaveDayes,
                String requestedDateFrom,
                String requestedDateTo,
                String requestReason,
                String leaveType,
                String leaveBalance,
                String physicalYear,
                String returnDate) {
            this.leaveId = leaveId;
            this.leaveDayes = leaveDayes;
            this.requestedDateFrom = requestedDateFrom;
            this.requestedDateTo = requestedDateTo;
            this.requestReason = requestReason;
            this.leaveType = leaveType;
            this.leaveBalance = leaveBalance;
            this.physicalYear = physicalYear;
            this.returnDate = returnDate;
        }
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setVisible(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    private void resetLocalComponents() {
        getStateTransions().clear();
        lblEmployeeId.setValue(null);
        lblFullName.setValue(null);
        lblDepartment.setValue(null);
        lblHireDate.setValue(null);
        lblPosition.setValue(null);
        lblCurrentState.setValue(null);
        lblCurrentOwnerGroup.setValue(null);
        txtDecisionRemark.setValue(null);
        imgEmployeePicture.setValue("");
        chkFemale.setSelected(false);
        chkMale.setSelected(false);
        drlDecision.resetValue();
        txtaDeciderComment.resetValue();
        setAvailableDecisionsToMakeList(null);
        getListOfLeaveRequest().clear();
    }

    public void modalPnlCloseBtnAttachment_processAction(ActionEvent ae) {
        pnlPopUpAttachment.setRendered(false);
    }

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(LeaveApproveManager.LEAVE_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(LeaveApproveManager.LEAVE_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (leaveRequestId == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE REQUEST TO DECIDE");
            return false;
        }
        return true;
    }

    private HashMap RegisterLeavWithOutPayInfo() {
        HashMap leaveInfoForWithoutPay = new HashMap();
        leaveInfoForWithoutPay.put("employeeId", leavWOEmployeeID);
        leaveInfoForWithoutPay.put("requestID", leavWoRequestId);
        leaveInfoForWithoutPay.put("leaveAmount", leaveWoAmount);
        leaveInfoForWithoutPay.put("requestDate", leaveWoRequestDate);
        leaveInfoForWithoutPay.put("requestYear", leavWoRequestYear);
        leaveInfoForWithoutPay.put("totalDeductedAmount", leavWoDeducatedAmout);
        leaveInfoForWithoutPay.put("usedLeave", leaveWoUsed);
        leaveInfoForWithoutPay.put("deductAmount", leaveWodd);
        return leaveInfoForWithoutPay;

    }

    public String btnSave_action() {
        try {
            if (validateDecision()) {

                boolean checkSatus = false;
                boolean checkDecition = false;
                String nextState = AuthorizationManager.readNextState(requestStatus,
                        LeaveApproveManager.PROCESS_LEAVE, drlDecision.getValue().toString());
                String comment = txtaDeciderComment.getValue() == null ? " " : txtaDeciderComment.getValue().toString();
                ArrayList<HashMap> listOfDestionMaked = new ArrayList<HashMap>();

                for (LeaveRequestInformation leaveRequestInformation : getListOfLeaveRequest()) {
                    if (leaveRequestInformation.isApproveList()) {
                        HashMap hm = new HashMap();
                        hm.put("leaveRequestId", leaveRequestInformation.getLeaveId());
                        hm.put("deciderId", txtDeciderId.getValue().toString());
                        hm.put("processedBy", txtDeciderId.getValue().toString());
                        hm.put("requesterId", requesterId);
                        listOfDestionMaked.add(hm);
                        checkSatus = true;
                        int index = nextState.indexOf("-");

                        if ((index > 0 && nextState.substring(0, index).equals("App"))) {

                            if (leaveApproveManager.getLeaveType(
                                    leaveRequestInformation.getLeaveId()).equals("14")) {
                                if (leaveApproveManager.updateEmployeeAnualLeaveBalanceForLeaveWithOutPay(RegisterLeavWithOutPayInfo())) {
                                    checkDecition = true;
                                } else {
                                    checkDecition = false;
                                    break;
                                }


                            } else {
                                checkDecition = true;
                            }
                        } else if ((index > 0 && nextState.substring(0, index).equals("Rej")) || index > 0 && nextState.substring(0, index).equals("Res")) {
                            if (leaveApproveManager.getLeaveType(
                                    leaveRequestInformation.getLeaveId()).equals("5")) {
                                if (leaveApproveManager.updateEmployeeAnualLeave(leaveRequestInformation.getLeaveId())) {
                                    checkDecition = true;
                                } else {
                                    checkDecition = false;
                                    break;
                                }
                            } else {
                                checkDecition = true;
                            }
                        } else {
                            checkDecition = true;
                        }
                    }
                }
                if (checkSatus) {
                    checkSatus = false;
                    if (checkDecition) {
                        if (leaveApproveManager.saveleaveDecision(
                                listOfDestionMaked,
                                drlDecision.getValue().toString(),
                                requestStatus,
                                comment)) {
                            resetLocalComponents();
                            loadEmployeeLeaveRequet();
                            showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                        } else {
                            showSuccessOrFailureMessage(false, "SAVING FAILED");
                        }
                    } else {
                        showSuccessOrFailureMessage(false, "SAVING FAILED ");
                    }
                } else {
                    showSuccessOrFailureMessage(false, "Please select from the table for decision ?");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ddlstStateTransitions_processValueChange(ValueChangeEvent vce) {
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public String lnkResignApprovePage_action() {
        //return null means stay on the same page
        return "TerminationRequest";
    }

    public String lnkClearancePage_action() {
        //return null means stay on the same page
        return null;
    }

    public String button1_action() {
        //return null means stay on the same page
        return null;
    }

    public void rwSelectorLeaveApprove_processMyEvent(RowSelectorEvent rse) {
        rowSelector = rse.getRow();
        if (rowSelector != -1) {
            getListOfLeaveRequest().get(rowSelector).getLeaveId();
        }

    }
//
//    public boolean saveLeaveDecision() {
//        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
//        return leaveApproveManager.saveleaveDecision(
//            ArrayList<HashMap> listOfDestionMaked,
//            String decision,
//            String currentState,
//            String commentGiven)
//
//                saveleaveDecision(leaveRequestId,
//                txtDeciderId.getValue().toString(),
//                drlDecision.getValue().toString(),
//                requestStatus,
//                comment);
//    }

    public String btnPostDecision_action() {
        //   if (validateDecision()) {
//        if (saveLeaveDecision()) {
//            // clearAllComponents();
//            showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
//            requestListsToBeApproved = leaveApproveManager.getRequestsToBeProcessed();
//        } else {
//            showSuccessOrFailureMessage(false, "SAVING FAILED");
//        }
        //  }
        return null;
    }

    public void lstNewRequests_processValueChange(ValueChangeEvent vce) {
        try {
            String[] requestInfos = vce.getNewValue().toString().split("--");
            //  leaveReserveId = Integer.parseInt(requestInfos[0]);
            requesterId = requestInfos[0];
            requestStatus = requestInfos[1];
            requestedDate = requestInfos[2];
            leaveRequesterId = requestInfos[3];
//            leaveTransferId = requestInfos[4];
            availableDecisionsToMakeList = leaveApproveManager.getAvailableDecisionsToMake(requestStatus);
            populateApproverTextComponents(getSessionBean1().getEmployeeId());
            loadEmployeeData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadEmployeeData() {
        try {
            float dedidend;
            float devisor;
            float result;

            getListOfLeaveRequest().clear();
            boolean firstTimeAccessces = true;
            String leaveBalnce = "";

            ArrayList<HashMap> leaveRequest = leaveApproveManager.readEmployeeLeaveRequest(
                    requesterId,
                    requestStatus,
                    requestedDate);
            if (leaveRequest != null) {
                for (HashMap hm : leaveRequest) {
                    if (firstTimeAccessces) {
                        lblEmployeeId.setValue(": " + "[ " + hm.get("EMP_ID").toString() + " ]");
                        lblFullName.setValue(": " + "[ " + hm.get("FULLNAME") + " ]");
                        lblPosition.setValue(": " + hm.get("JOB_NAME"));
                        int expYear = employeeManager.calculateServiceYear(hm.get("EMP_ID").toString());
                        lblHireDate.setValue(": " + expYear);
                        lblDepartment.setValue(": " + hm.get("DEP_DESCRIPTION"));
                        if (hm.get("SEX").equals("Male")) {
                            chkMale.setSelected(true);
                        } else {
                            chkFemale.setSelected(true);
                        }

                        try {
                            OracleSerialBlob blo = (OracleSerialBlob) hm.get("PHOTO");
                            setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                            imgEmployeePicture.setValue(getEmployeePicture());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        firstTimeAccessces = false;
                    }
                    if (hm.get("LEAVE_TYPE").toString().equals("1")) {
                        leaveBalnce = leaveRequestManager.readAnnualLeaveBalance(requesterId);
                    }

                    getListOfLeaveRequest().add(new LeaveRequestInformation(
                            hm.get("LEAVE_ID").toString(),
                            hm.get("LEAVE_DAYS").toString(),
                            hm.get("REQUESTED_FROM_DATE").toString(),
                            hm.get("REQUESTED_TO_DATE").toString(),
                            hm.get("REQUESTING_REASON").toString(),
                            hm.get("DESCRIPTION").toString(),
                            leaveBalnce,
                            hm.get("PHYSICALYEAR").toString(),
                            hm.get("RETURNDATE").toString()));
                    leavWOEmployeeID = hm.get("EMP_ID").toString();
                    leavWoRequestYear = hm.get("PHYSICALYEAR").toString();
                    leavWoRequestId = leaveRequesterId;
                    leaveWoAmount = hm.get("LEAVE_DAYS").toString();
                    leaveWoRequestDate = hm.get("REQUESTED_FROM_DATE").toString();
                    String[] llbalance = leaveBalanceManager.SelectLastBalanceOFEmployeeForLeaveWithOutPay(leavWOEmployeeID).split("-");
                    int lastLeaveAmount = Integer.parseInt(llbalance[0]);
                    float used = Float.parseFloat(llbalance[1]);
                    //   int lastLeaveAmount = leaveBalanceManager.SelectLastBalanceOFEmployee(leavWOEmployeeID);
                    dedidend = (lastLeaveAmount * Integer.parseInt(leaveWoAmount));
                    result = (dedidend / 365);
                    leavWoDeducatedAmout = (result + used);
                    leaveWoUsed = used;
                    leaveWodd = result;

                }
            } else {
                showSuccessOrFailureMessage(false, "FAILED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String btnClosePopupViewPrevieousDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        // TODO: Replace with your code
        return null;
    }

    public String lnkViewPrevieousDecisions_action() {
        lblDesstionStatus.setRendered(false);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        int leave_request = Integer.parseInt(leaveRequesterId);
        decisionsMadeOnRequest.clear();
        ArrayList<HashMap> leaveRequestHistory =
                leaveRequestManager.getLeaveRequestHistory(leave_request);
        int counter = 0;
        for (HashMap hm : leaveRequestHistory) {
            counter++;
            decisionsMadeOnRequest.add(new RequestHistoryModel(
                    counter,
                    hm.get("deciderEmployeeId").toString(),
                    hm.get("deciderFullName").toString(),
                    hm.get("givenDecision").toString(),
                    hm.get("timeStamp").toString(),
                    hm.get("commentGiven").toString()));

        }
        if (counter == 0) {
            lblDesstionStatus.setRendered(true);
        }

        // TODO: Replace with your code
        return null;
    }
}