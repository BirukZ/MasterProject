/*
 * PowerDeligation.java
 *
 * Created on Feb 20, 2011, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.SalaryDelegation;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.convert.CharacterConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.disciplineManager.DisciplineApproveManager;
import manager.employeeManager.EmployeeManage;
import manager.salaryDelegationManager.SalaryDelegationApproveManager;
import manager.salaryDelegationManager.SalaryDelegationRequestManager;
import manager.salaryDelegationManager.SalaryDelegationRequestManager.SalaryDelegationRequestModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class SalaryDeligationApprovePage extends AbstractPageBean {

    SalaryDelegationRequestManager requestManager = new SalaryDelegationRequestManager();
    SalaryDelegationApproveManager approveManager = new SalaryDelegationApproveManager();
    DepartmentManage departmentManage = new DepartmentManage();
    EmployeeManage employeeManager = new EmployeeManage();
    String loggedInEmployeeId = getSessionBean1().getEmpDeptId();
    String userName;
    private int salaryDelegationRequestId;//     @Column(name = "POW_DEL_REQ_ID")
    private String startDate;//    @Column(name = "START_DATE")
    private String endDate;//    @Column(name = "END_DATE")
    private String deligatedPosition;//    @Column(name = "DELIGATED_POSITION")
    private String deligationStatus;//    @Column(name = "DELIGATION_STATUS")
    private String registeredBy;//    @Column(name = "REGISTERED_BY")
    private String registeredDate;//    @Column(name = "REGISTERED_DATE")
    private String deligationReason;//    @Column(name = "DELIGATION_REASON")
    private String delegatorId;//    @JoinColumn(name = "DELIGATOR_ID", referencedColumnName = "EMP_ID")
    private String delegateeId;//    @JoinColumn(name = "DELEGATEE_ID", referencedColumnName = "EMP_ID")
    private String approverCommentesGiven;
    static int departmentId = 0;
    String deligatorDeptId = "0";
    String deligateeDeptId = "0";
    private PanelLayout pnlLayoutTree = new PanelLayout();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String toDay = dateFormat.format(new Date());
    ArrayList<SelectItem> pendingRequestLists = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryLists = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestsListByDeligatorAndDeligatee = new ArrayList<SelectItem>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    ArrayList<SelectItem> requestListsToBeApproved = new ArrayList<SelectItem>();
    //ArrayList<HashMap> decisionsMadeOnRequest = new ArrayList<HashMap>();//for the dataTable

    public String getNewOrEditOrUpdateLabel() {
        // return MessageLocalizer.getLocalizedMessage(newOrEditOrUpdateLabel, "Localization.HRLocalization");
        return newOrEditOrUpdateLabel;
    }

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        txtDeciderId.setValue(getSessionBean1().getEmployeeId());
         userName = getSessionBean1().getUserName();
        requestManager.setUserName(userName);
        approveManager.setUserName(userName);
        requestHistoryLists = approveManager.getDecisionMadeByEmployee();
        pendingRequestLists = approveManager.getPendingRequests();
        if (loggedInEmployeeId != null) {
            populateApproverTextComponents(loggedInEmployeeId);
        }
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    public String getDeligateeDeptId() {
        return deligateeDeptId;
    }

    public void setDeligateeDeptId(String deligateeDeptId) {
        this.deligateeDeptId = deligateeDeptId;
    }

    public String getDeligatorDeptId() {
        return deligatorDeptId;
    }

    public void setDeligatorDeptId(String deligatorDeptId) {
        this.deligatorDeptId = deligatorDeptId;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init(), prerendder()....">
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

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="All Getters and Setters">
    private DefaultTree treeModel = new DefaultTree();

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequestList() {
        return decisionsMadeOnRequestList;
    }

    public void setDecisionsMadeOnRequestList(ArrayList<RequestHistoryModel> decisionsMadeOnRequestList) {
        this.decisionsMadeOnRequestList = decisionsMadeOnRequestList;
    }

    public String getDelegatorId() {
        return delegatorId;
    }

    public void setDelegatorId(String delegatorId) {
        this.delegatorId = delegatorId;
    }

    public static int getDepartmentId() {
        return departmentId;
    }

    public SalaryDelegationApproveManager getApproveManager() {
        return approveManager;
    }

    public void setApproveManager(SalaryDelegationApproveManager approveManager) {
        this.approveManager = approveManager;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public ArrayList<SelectItem> getRequestHistoryLists() {
        return requestHistoryLists;
    }

    public void setRequestHistoryLists(ArrayList<SelectItem> requestHistoryLists) {
        this.requestHistoryLists = requestHistoryLists;
    }

    public SalaryDelegationRequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(SalaryDelegationRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public ArrayList<SelectItem> getRequestsListByDeligatorAndDeligatee() {
        return requestsListByDeligatorAndDeligatee;
    }

    public void setRequestsListByDeligatorAndDeligatee(ArrayList<SelectItem> requestsListByDeligatorAndDeligatee) {
        this.requestsListByDeligatorAndDeligatee = requestsListByDeligatorAndDeligatee;
    }

    public String getToDay() {
        return toDay;
    }

    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    public DefaultTree getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTree treeModel) {
        this.treeModel = treeModel;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    HtmlOutputText outputText3 = new HtmlOutputText();

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setOutputText3(HtmlOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public ArrayList<SelectItem> getPendingRequestLists() {
        return pendingRequestLists;
    }

    public void setPendingRequestLists(ArrayList<SelectItem> pendingRequestLists) {
        this.pendingRequestLists = pendingRequestLists;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public String getDelegateeId() {
        return delegateeId;
    }

    public void setDelegateeId(String delegateeId) {
        this.delegateeId = delegateeId;
    }

    public String getDeligatedPosition() {
        return deligatedPosition;
    }

    public void setDeligatedPosition(String deligatedPosition) {
        this.deligatedPosition = deligatedPosition;
    }

    public String getDeligationReason() {
        return deligationReason;
    }

    public void setDeligationReason(String deligationReason) {
        this.deligationReason = deligationReason;
    }

    public String getDeligationStatus() {
        return deligationStatus;
    }

    public void setDeligationStatus(String deligationStatus) {
        this.deligationStatus = deligationStatus;
    }

    public String getDeligatorId() {
        return delegatorId;
    }

    public void setDeligatorId(String deligatorId) {
        this.delegatorId = deligatorId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout panelLayout3) {
        this.panelLayout3 = panelLayout3;
    }

    public Tree getTreeOrgStructure() {
        return treeOrgStructure;
    }

    public void setTreeOrgStructure(Tree treeOrgStructure) {
        this.treeOrgStructure = treeOrgStructure;
    }

    public DefaultTree getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public void setDefaultTreeModel(DefaultTree defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

    public ArrayList<SelectItem> getPerofation() {
        return perofation;
    }

    public void setPerofation(ArrayList<SelectItem> perofation) {
        this.perofation = perofation;
    }

    public PanelLayout getPnlLayoutTree() {
        return pnlLayoutTree;
    }

    public void setPnlLayoutTree(PanelLayout pl) {
        this.pnlLayoutTree = pl;
    }
    private HtmlInputText txtDeligatorDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeligatorDepartment() {
        return txtDeligatorDepartment;
    }

    public void setTxtDeligatorDepartment(HtmlInputText hit) {
        this.txtDeligatorDepartment = hit;
    }
    private HtmlInputText txtDeligatorId = new HtmlInputText();

    public HtmlInputText getTxtDeligatorId() {
        return txtDeligatorId;
    }

    public void setTxtDeligatorId(HtmlInputText hit) {
        this.txtDeligatorId = hit;
    }
    private HtmlInputText txtDeligatorPosition = new HtmlInputText();

    public HtmlInputText getTxtDeligatorPosition() {
        return txtDeligatorPosition;
    }

    public void setTxtDeligatorPosition(HtmlInputText hit) {
        this.txtDeligatorPosition = hit;
    }
    private HtmlInputText txtDeligateeDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeligateeDepartment() {
        return txtDeligateeDepartment;
    }

    public void setTxtDeligateeDepartment(HtmlInputText hit) {
        this.txtDeligateeDepartment = hit;
    }
    private HtmlInputText txtDeligateeId = new HtmlInputText();

    public HtmlInputText getTxtDeligateeId() {
        return txtDeligateeId;
    }

    public void setTxtDeligateeId(HtmlInputText hit) {
        this.txtDeligateeId = hit;
    }
    private HtmlInputText txtDeligateePosition = new HtmlInputText();

    public HtmlInputText getTxtDeligateePosition() {
        return txtDeligateePosition;
    }

    public void setTxtDeligateePosition(HtmlInputText hit) {
        this.txtDeligateePosition = hit;
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
    private HtmlInputTextarea txtaRemark = new HtmlInputTextarea();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="displayTree()">
    private DefaultTree defaultTreeModel = new DefaultTree();
    private Tree treeOrgStructure = new Tree();
    private PanelLayout panelLayout3 = new PanelLayout();
    ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup hpg) {
        this.panelGroupMessage = hpg;
    }
    private SelectInputDateBean selectInputDateSatrtDate = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateEndDate = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateEndDate() {
        return selectInputDateEndDate;
    }

    public void setSelectInputDateEndDate(SelectInputDateBean selectInputDateEndDate) {
        this.selectInputDateEndDate = selectInputDateEndDate;
    }

    public SelectInputDateBean getSelectInputDateSatrtDate() {
        return selectInputDateSatrtDate;
    }

    public void setSelectInputDateSatrtDate(SelectInputDateBean selectInputDateSatrtDate) {
        this.selectInputDateSatrtDate = selectInputDateSatrtDate;
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
    private CharacterConverter characterConverter1 = new CharacterConverter();

    public CharacterConverter getCharacterConverter1() {
        return characterConverter1;
    }

    public void setCharacterConverter1(CharacterConverter cc) {
        this.characterConverter1 = cc;
    }
    private DefaultSelectedData selectedObjectRequestsByHistory = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectRequestsByHistory() {
        return selectedObjectRequestsByHistory;
    }

    public void setSelectedObjectRequestsByHistory(DefaultSelectedData selectedObjectRequestsByHistory) {
        this.selectedObjectRequestsByHistory = selectedObjectRequestsByHistory;
    }
    private DefaultSelectedData selectedObjectRequestsByStatus = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectRequestsByStatus() {
        return selectedObjectRequestsByStatus;
    }

    public void setSelectedObjectRequestsByStatus(DefaultSelectedData selectedObjectRequestsByStatus) {
        this.selectedObjectRequestsByStatus = selectedObjectRequestsByStatus;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private DefaultSelectedData selectedObjectDeligatorDeligatee = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectDeligatorDeligatee() {
        return selectedObjectDeligatorDeligatee;
    }

    public void setSelectedObjectDeligatorDeligatee(DefaultSelectedData selectedObjectDeligatorDeligatee) {
        this.selectedObjectDeligatorDeligatee = selectedObjectDeligatorDeligatee;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }
    private PanelLayout pnlLayoutDeligationHistory = new PanelLayout();

    public PanelLayout getPnlLayoutDeligationHistory() {
        return pnlLayoutDeligationHistory;
    }

    public void setPnlLayoutDeligationHistory(PanelLayout pl) {
        this.pnlLayoutDeligationHistory = pl;
    }
    private PanelLayout pnlLayoutButtons = new PanelLayout();

    public PanelLayout getPnlLayoutButtons() {
        return pnlLayoutButtons;
    }

    public void setPnlLayoutButtons(PanelLayout pl) {
        this.pnlLayoutButtons = pl;
    }
    private HtmlCommandButton btnResetHistory = new HtmlCommandButton();

    public HtmlCommandButton getBtnResetHistory() {
        return btnResetHistory;
    }

    public void setBtnResetHistory(HtmlCommandButton hcb) {
        this.btnResetHistory = hcb;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();

    public HtmlOutputText getOutputTextConfirmDelete() {
        return outputTextConfirmDelete;
    }

    public void setOutputTextConfirmDelete(HtmlOutputText outputTextConfirmDelete) {
        this.outputTextConfirmDelete = outputTextConfirmDelete;
    }

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
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

    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlSelectBooleanCheckbox ckbDelegateOnlySalary = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbDelegateOnlySalary() {
        return ckbDelegateOnlySalary;
    }

    public void setCkbDelegateOnlySalary(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbDelegateOnlySalary = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbDelegateEverything = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbDelegateEverything() {
        return ckbDelegateEverything;
    }

    public void setCkbDelegateEverything(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbDelegateEverything = hsbc;
    }

    public HtmlInputTextarea getTxtaRemark() {
        return txtaRemark;
    }

    public void setTxtaRemark(HtmlInputTextarea hit) {
        this.txtaRemark = hit;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }

//</editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SalaryDeligationApprovePage() {

    }

    DisciplineApproveManager disciplineApproveManager=new DisciplineApproveManager();

    private void displayDecisionButtons(boolean display) {
        if (display) {
            btnResetHistory.setRendered(false);
            pnlLayoutButtons.setRendered(true);
            pnlLayoutDeligationHistory.setRendered(false);
        } else {
            btnResetHistory.setRendered(true);
            pnlLayoutButtons.setRendered(false);
            pnlLayoutDeligationHistory.setRendered(true);
        }
    }

    private void populateDeligationHistory(String requestId) {
        decisionsMadeOnRequestList = approveManager.getRequestHistory(Integer.parseInt(requestId));
    }

     private void populateApproverTextComponents(String approverId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = loggedInEmployeeId;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
                txtDeciderId.setDisabled(false);
            } else {
                try {

                    approverId = empInfoHashMap.get("employeeId").toString();
                    txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                    txtDeciderFullName.setValue(empInfoHashMap.get("employeeFullName"));
                    txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                    txtDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void populateDeligatorTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                delegatorId = "-1";
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                String deligatorDepartment = empInfoHashMap.get("employeeDepartment").toString();
                delegatorId = employeeId;//empInfoHashMap.get("employeeId").toString();
                deligatedPosition = empInfoHashMap.get("employeeJobCode").toString();
                txtDeligatorDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtDeligatorFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeligatorId.setValue(employeeId);
                txtDeligatorPosition.setValue(empInfoHashMap.get("employeePosition"));
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void populateDeligateeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                delegateeId = "-1";
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                delegateeId = employeeId;//empInfoHashMap.get("employeeId").toString();
                txtDeligateeDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtDeligateeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeligateeId.setValue(employeeId);
                txtDeligateePosition.setValue(empInfoHashMap.get("employeePosition"));
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void populateDecisionHistory(int overTimeRequestId) {
        decisionsMadeOnRequestList = approveManager.getRequestHistory(overTimeRequestId);
        if (decisionsMadeOnRequestList.size() > 0) {
//            lnkViewPrevieousDecisions.setRendered(true);
        } else {
//            lnkViewPrevieousDecisions.setRendered(false);
        }
    }

    private void populateDeligationTextComponents(int salaryDeligationRequestId) {
        SalaryDelegationRequestModel deligationRequestModel = requestManager.getRequestParameters(salaryDeligationRequestId);
        if (deligationRequestModel != null) {
            if (deligationRequestModel.getSalaryDelegationRequestId() == -1) {//if no resultset found
                salaryDelegationRequestId = -1;
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + salaryDeligationRequestId);
            } else {
                txtStartDate.setValue(deligationRequestModel.getStartDate());
                txtEndDate.setValue(deligationRequestModel.getEndDate());
                txtaRemark.setValue(deligationRequestModel.getReason());
                txtAppliedDate.setValue(deligationRequestModel.getAppliedDate());
                txtDocReferenceNumber.setValue(deligationRequestModel.getDocReferenceNumber());
                txtaRemark.setDisabled(true);
                if (deligationRequestModel.getDelegaredItems().equals("ALL")) {
                    ckbDelegateEverything.setSelected(true);
                    ckbDelegateOnlySalary.setSelected(false);
                } else {
                    ckbDelegateEverything.setSelected(false);
                    ckbDelegateOnlySalary.setSelected(true);
                }
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public String btnSave_action() {

        //return null means stay on the same page
        return null;
    }

    private void clearDeligatorTextComponenets() {
        delegatorId = "-1";
        txtDeligatorDepartment.setValue(null);
        txtDeligatorFullName.setValue(null);
        txtDeligatorId.setValue(null);
        txtDeligatorPosition.setValue(null);
    }

    private void clearDeligateeTextComponenets() {
        delegateeId = "-1";
        txtDeligateeDepartment.setValue(null);
        txtDeligateeFullName.setValue(null);
        txtDeligateeId.setValue(null);
        txtDeligateePosition.setValue(null);
    }

    private void clearDeligationTextComponenets() {
        txtEndDate.setValue(null);
        txtStartDate.setValue(null);
        txtaRemark.setValue(null);
    }

    private void clearAllComponenets2() {
        clearDeligatorTextComponenets();
        clearDeligateeTextComponenets();
        clearDeligationTextComponenets();
        resetSelectedObjects();

        resetRequestAttributes();
    }

    private void resetSelectedObjects() {
        selectedObjectRequestsByStatus.setSelectedObject(null);
        selectedObjectDeligatorDeligatee.setSelectedObject(null);
        selectedObjectDeligatorDeligatee.setSelectedObject(null);
    }

    private void resetRequestAttributes() {
        delegatorId = null;
        delegateeId = null;
        salaryDelegationRequestId = 0;
    }

    private void makePageReadyForSave() {
        // clearAllComponenets();
        newOrEditOrUpdateLabel = "Save";
        btnPostDecision.setDisabled(false);

    }

    private void makePageReadyForUpdate() {
        newOrEditOrUpdateLabel = "Update";
        btnPostDecision.setDisabled(false);
//        lnkViewPrevieousDecisions.setRendered(false);
    }

    private void makePageReadyForView() {
        newOrEditOrUpdateLabel = "Save";
        btnPostDecision.setDisabled(true);
        populateDeligationHistory(Integer.toString(salaryDelegationRequestId));
//        lnkViewPrevieousDecisions.setRendered(true);
    }

    private void clearTable() {
        decisionsMadeOnRequestList = null;
    }

    public String btnReset_action() {
        //   clearAllComponenets();
        makePageReadyForSave();
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
        pnlPopupSuccessOrFailure.setAutoCentre(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }
    public void makePageReadyForDecision() {

        availableDecisionsToMakeList = disciplineApproveManager.getAvailableDecisionsToMake(deligationStatus);
      
    }
    

    public void selectRequestLists_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                String[] requestAttributes = vce.getNewValue().toString().split("--");
                salaryDelegationRequestId = Integer.parseInt(requestAttributes[0]);
                delegatorId = requestAttributes[1];
                delegateeId = requestAttributes[2];
                deligationStatus = requestAttributes[3];
               
                populateDeligateeTextComponents(delegateeId);
                populateDeligatorTextComponents(delegatorId);
                populateDeligationTextComponents(salaryDelegationRequestId);
                makePageReadyForDecision();
                makePageReadyForSave();
//                requestHistoryLists
         availableDecisionsToMakeList = approveManager.getAvailableDecisionsToMake(deligationStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDeligatorDeligatee_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            String requestInfo = vce.getNewValue().toString();
            salaryDelegationRequestId = Integer.parseInt(requestInfo.split("--")[0]);
            delegatorId = requestInfo.split("--")[1];
            delegateeId = requestInfo.split("--")[2];
            deligationStatus = requestInfo.split("--")[3];
            populateDeligateeTextComponents(delegateeId);
            populateDeligatorTextComponents(delegatorId);
            populateDeligationTextComponents(salaryDelegationRequestId);

            newOrEditOrUpdateLabel = "Edit";
            //check if the request is updatable
            if (deligationStatus.equals(SalaryDelegationApproveManager.INITIAL_STATE_SALARY_DELEGATION)) {
                //no history , hence can be updated
                displayDecisionButtons(true);
            } else {
                //process already started canot be updated.So decision tables not displayed
                //but history is displayed
                displayDecisionButtons(false);
                populateDeligationHistory(Integer.toString(salaryDelegationRequestId));
            }

        }
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(salaryDelegationRequestId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String btnResetHistory_action() {
        clearDeligateeTextComponenets();
        clearDeligationTextComponenets();
        clearDeligatorTextComponenets();
        displayDecisionButtons(true);
        clearTable();
        return null;
    }
    private HtmlInputText txtDeligatorFullName = new HtmlInputText();

    public HtmlInputText getTxtDeligateeFullName() {
        return txtDeligateeFullName;
    }

    public void setTxtDeligateeFullName(HtmlInputText txtDeligateeFullName) {
        this.txtDeligateeFullName = txtDeligateeFullName;
    }

    public void setTxtDeligateeFullName(SelectInputText txtDeligateeFullName) {
        this.txtDeligateeFullName = txtDeligateeFullName;
    }
    private HtmlInputText txtDeligateeFullName = new HtmlInputText();

    public int getSalaryDelegationRequestId() {
        return salaryDelegationRequestId;
    }

    public void setSalaryDelegationRequestId(int salaryDelegationRequestId) {
        this.salaryDelegationRequestId = salaryDelegationRequestId;
    }

    public HtmlInputText getTxtDeligatorFullName() {
        return txtDeligatorFullName;
    }

    public void setTxtDeligatorFullName(HtmlInputText txtDeligatorFullName) {
        this.txtDeligatorFullName = txtDeligatorFullName;
    }

    public void setTxtDeligatorFullName(SelectInputText txtDeligatorFullName) {
        this.txtDeligatorFullName = txtDeligatorFullName;
    }

    public String txtDeligatorFullName_action() {
        //  clearDeligatorTextComponenets();
        delegatorId = ApplicationBean1.getSelectedEmployeeId();
        populateDeligatorTextComponents(delegatorId);
        return null;
    }

    public String txtDeligateeFullName_action() {
        //   clearDeligateeTextComponenets();
        delegateeId = ApplicationBean1.getSelectedEmployeeId();
        populateDeligateeTextComponents(delegateeId);
        return null;
    }

    public String lnkPowDelApprove_action() {
        return "SalaryDeligationRequest";
    }

    public String btnSearchDeligator_action() {
        if (txtDeligatorId.getValue() != null && !txtDeligatorId.getValue().toString().equals("")) {
            delegatorId = txtDeligatorId.getValue().toString();
            populateDeligatorTextComponents(delegatorId);
        }
        return null;
    }

    public String btnSearchDeligatee_action() {
        if (txtDeligateeId.getValue() != null && !txtDeligateeId.getValue().toString().equals("")) {
            //   clearDeligateeTextComponenets();
            delegateeId = txtDeligateeId.getValue().toString();
            populateDeligateeTextComponents(delegateeId);
        }
        return null;
    }

    public void selectRequestHistoryLists_processValueChange(ValueChangeEvent vce) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        salaryDelegationRequestId = Integer.parseInt(requestAttributes[0]);
        delegatorId = requestAttributes[1];
        delegateeId = requestAttributes[2];
        deligationStatus = requestAttributes[3];
        populateDeligateeTextComponents(delegateeId);
        populateDeligatorTextComponents(delegatorId);
        populateDeligationTextComponents(salaryDelegationRequestId);
        makePageReadyForView();
    }

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(SalaryDelegationApproveManager.SALARY_DELEGATION_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(SalaryDelegationApproveManager.SALARY_DELEGATION_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (salaryDelegationRequestId == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE DELIGATION REQUEST TO DECIDE");
            return false;
        }
        return true;
    }

    public boolean saveOverTimeDecision() {
        
       // String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
        approverCommentesGiven = txtaDeciderComment.getValue().toString();
        return approveManager.saveDecision(salaryDelegationRequestId,userName, drlDecision.getValue().toString(),deligationStatus,approverCommentesGiven);
            }

    public String btnPostDecision_action() {
        if (validateDecision()) {
            if (saveOverTimeDecision()) {
                //  clearAllComponenets();
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                requestListsToBeApproved = approveManager.getRequestsToBeProcessed();
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        return null;
    }
}