/*
 * PowerDeligation.java
 *
 * Created on Feb 20, 2011, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.SalaryDelegation;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
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
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
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
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.organizationManager.LoadTree;
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
public class SalaryDeligationRequestPage extends AbstractPageBean {

    SalaryDelegationRequestManager requestManager = new SalaryDelegationRequestManager();
    SalaryDelegationApproveManager approveManager = new SalaryDelegationApproveManager();
    SalaryDelegationRequestModel delegationRequestModel = new SalaryDelegationRequestModel();
    DepartmentManage departmentManage = new DepartmentManage();
    EmployeeManage employeeManager = new EmployeeManage();
    String loggedInEmployeeId = getSessionBean1().getEmpDeptId();
    String userName;
    private int salaryDelegationRequestId;//     @Column(name = "POW_DEL_REQ_ID")
    private String startDate;//    @Column(name = "START_DATE")
    private String endDate;//    @Column(name = "END_DATE")
    private String deligationStatus;//    @Column(name = "DELIGATION_STATUS")
    private String registeredBy;//    @Column(name = "REGISTERED_BY")
    private String registeredDate;//    @Column(name = "REGISTERED_DATE")
    private String deligationReason;//    @Column(name = "DELIGATION_REASON")
    private String delegatorId;//    @JoinColumn(name = "DELIGATOR_ID", referencedColumnName = "EMP_ID")
    private String delegateeId;//    @JoinColumn(name = "DELEGATEE_ID", referencedColumnName = "EMP_ID")
    private String deligateePrevPosition;//    @Column(name = "DELIGATEE_PREV_POSITION")
    private String deligatorOrdeligatee;
    String appliedDate;//APPLIED_DATE
    String delegaredItems;
    String reason;//REASON
    String docReferenceNumber;//
    String status;//STATUS
    private PanelLayout pnlLayoutTree = new PanelLayout();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String toDay = dateFormat.format(new Date());
    ArrayList<SelectItem> pendingRequestLists = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryLists = new ArrayList<SelectItem>();
    //  ArrayList<SelectItem> powerDeligationStatusList = requestManager.getSalaryDeligationStatusTypes();
    ArrayList<SelectItem> requestsListByDeligatorAndDeligatee = new ArrayList<SelectItem>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
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
    // if(pendingRequestLists .isEmpty()){
        //pendingRequestLists = disciplineRequestManager.getPendingRequests();
        //}else{
    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        userName = getSessionBean1().getUserName();
        requestManager.setUserName(userName);
        requestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
       
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
        if(pendingRequestLists.isEmpty()){
        pendingRequestLists = requestManager.getPendingRequests();
        }else{
        }
        if(requestHistoryLists.isEmpty()){
        requestHistoryLists = requestManager.getMyRequestsHistory();
        }else {
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

    public ArrayList<SelectItem> getRequestHistoryLists() {
        return requestHistoryLists;
    }

    public void setRequestHistoryLists(ArrayList<SelectItem> requestHistoryLists) {
        this.requestHistoryLists = requestHistoryLists;
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

    public String getDeligatorOrdeligatee() {
        return deligatorOrdeligatee;
    }

    public void setDeligatorOrdeligatee(String deligatorOrdeligatee) {
        this.deligatorOrdeligatee = deligatorOrdeligatee;
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
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public int getSalaryDelegationRequestId() {
        return salaryDelegationRequestId;
    }

    public void setSalaryDelegationRequestId(int salaryDelegationRequestId) {
        this.salaryDelegationRequestId = salaryDelegationRequestId;
    }

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
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

    public HtmlInputTextarea getTxtaRemark() {
        return txtaRemark;
    }

    public void setTxtaRemark(HtmlInputTextarea hit) {
        this.txtaRemark = hit;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="displayTree()">
    private DefaultTree defaultTreeModel = new DefaultTree();
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
    private SelectInputDateBean selectInputDateAppliedDate = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateEndDate() {
        return selectInputDateEndDate;
    }

    public void setSelectInputDateEndDate(SelectInputDateBean selectInputDateEndDate) {
        this.selectInputDateEndDate = selectInputDateEndDate;
    }

    public SelectInputDateBean getSelectInputDateSatrtDate() {
        return selectInputDateSatrtDate;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public SalaryDelegationApproveManager getApproveManager() {
        return approveManager;
    }

    public void setApproveManager(SalaryDelegationApproveManager approveManager) {
        this.approveManager = approveManager;
    }

    public String getDelegaredItems() {
        return delegaredItems;
    }

    public void setDelegaredItems(String delegaredItems) {
        this.delegaredItems = delegaredItems;
    }

    public SalaryDelegationRequestModel getDelegationRequestModel() {
        return delegationRequestModel;
    }

    public void setDelegationRequestModel(SalaryDelegationRequestModel delegationRequestModel) {
        this.delegationRequestModel = delegationRequestModel;
    }

    public String getDocReferenceNumber() {
        return docReferenceNumber;
    }

    public void setDocReferenceNumber(String docReferenceNumber) {
        this.docReferenceNumber = docReferenceNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public SalaryDelegationRequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(SalaryDelegationRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public SelectInputDateBean getSelectInputDateAppliedDate() {
        return selectInputDateAppliedDate;
    }

    public void setSelectInputDateAppliedDate(SelectInputDateBean selectInputDateAppliedDate) {
        this.selectInputDateAppliedDate = selectInputDateAppliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate calAppliedDate) {
        this.calAppliedDate = calAppliedDate;
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
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pp) {
        this.pnlPopupConfirmDelete = pp;
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
    private HtmlCommandButton btnSaveOrEditOrUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveOrEditOrUpdate() {
        return btnSaveOrEditOrUpdate;
    }

    public void setBtnSaveOrEditOrUpdate(HtmlCommandButton hcb) {
        this.btnSaveOrEditOrUpdate = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
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
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();

    public String getDeligateePrevPosition() {
        return deligateePrevPosition;
    }

    public void setDeligateePrevPosition(String deligateePrevPosition) {
        this.deligateePrevPosition = deligateePrevPosition;
    }

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
    private HtmlOutputText outTxtCurrentStatus = new HtmlOutputText();

    public HtmlOutputText getOutTxtCurrentStatus() {
        return outTxtCurrentStatus;
    }

    public void setOutTxtCurrentStatus(HtmlOutputText hot) {
        this.outTxtCurrentStatus = hot;
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
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
    }

//</editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SalaryDeligationRequestPage() {
    }

    public String btnDeligatorDeptSearch_action() {
        deligatorOrdeligatee = "Deligator";
        LoadTree loadTree = new LoadTree();
        pnlLayoutTree.setRendered(true);
        return null;
    }

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

    private void populateDeligatorTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                delegatorId = "-1";
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                String deligatorDepartment = empInfoHashMap.get("employeeDepartment").toString();
                delegatorId = employeeId;//empInfoHashMap.get("employeeId").toString();
                // deligatedPosition = empInfoHashMap.get("employeeJobCode").toString();
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
            lnkViewPrevieousDecisions.setRendered(true);
        } else {
            lnkViewPrevieousDecisions.setRendered(false);
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

    public String btnDeligatorIdSearch_action() {
        if (txtDeligatorId.getValue() != null) {
            delegatorId = txtDeligatorId.getValue().toString();
            populateDeligatorTextComponents(delegatorId);
        } else {
            delegatorId = null;
            clearDeligatorTextComponenets();
        }
        return null;
    }

    public String btnDeligateeIdSearch_action() {
        if (txtDeligatorId.getValue() != null) {
            delegateeId = txtDeligateeId.getValue().toString();
            populateDeligateeTextComponents(delegateeId);
        } else {
            delegateeId = null;
            clearDeligateeTextComponenets();
        }
        return null;
    }

    public void enableComponents() {
        txtDeligateeId.setDisabled(false);
        txtDeligatorId.setDisabled(false);
        txtEndDate.setDisabled(false);
        txtStartDate.setDisabled(false);
        txtaRemark.setDisabled(false);
        txtDeligateeId.setDisabled(false);
    }

    private void disableComponents() {
        txtDeligateeId.setDisabled(true);
        txtDeligatorId.setDisabled(true);
    }

    public boolean savePowerDeligationRequest() {
        if (validateAndInitializeAttributes()) {
            try {
                if (requestManager.saveSalaryDelegationRequest(delegatorId, delegateeId, startDate, endDate, appliedDate, delegaredItems, reason, docReferenceNumber)) {
                    showSuccessOrFailureMessage(true, " SAVING OKAY ");
                    pendingRequestLists = requestManager.getPendingRequests();
                    clearAllComponenets();
                } else {
                    showSuccessOrFailureMessage(false, " SAVING FAILED ");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                showSuccessOrFailureMessage(true, " SORRY, EXCEPTION OCCURED ");
            }
        }
        return false;
    }

    public boolean updatePowerDeligationRequest() {


        if (validateAndInitializeAttributes()) {
            try {
                if (requestManager.updateSalaryDelegationRequest(salaryDelegationRequestId, delegatorId, delegateeId, startDate, endDate, appliedDate, delegaredItems, reason, docReferenceNumber)) {
                    showSuccessOrFailureMessage(true, "SAVING FAILED");
                    clearAllComponenets();
                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                showSuccessOrFailureMessage(true, "SORRY, EXCEPTION OCCURED");
            }
        }
        return false;
    }

    boolean validateAndInitializeAttributes() {
        if (delegateeId == null || delegatorId == null || delegateeId.equals("-1") || delegatorId.equals("-1")) {//no enough info to save
            showSuccessOrFailureMessage(false, "SELECT DELIGATOR AND DELIGATEE FIRST");
            return false;
        } else if (txtStartDate.getValue() == null || txtEndDate.getValue() == null || txtAppliedDate.getValue() == null) {
            showSuccessOrFailureMessage(true, "START DATE AND END DATE CAN NOT BE EMPTY");
            return false;
        } else if (ckbDelegateEverything.isSelected() == false && ckbDelegateOnlySalary.isSelected() == false) {
            showSuccessOrFailureMessage(true, "PLEASE SELECT WHAT TO DELEGATE");
            return false;
        } else {
            reason = txtaRemark.getValue() == null ? "" : txtaRemark.getValue().toString();
            delegaredItems = ckbDelegateEverything.isSelected() ? "ALL" : "SAL";
            startDate = txtStartDate.getValue().toString();
            endDate = txtEndDate.getValue().toString();
            appliedDate = txtAppliedDate.getValue().toString();
            deligationReason = txtaRemark.getValue() == null ? "" : txtaRemark.getValue().toString();
            delegaredItems = ckbDelegateEverything.isSelected() ? "ALL" : "SAL";
            return true;
        }
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public String btnSave_action() {

        //return null means stay on the same page
        return null;
    }

    public String btnSaveOrEditOrUpdate_action() {
        if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {//prepared for insert
            savePowerDeligationRequest();
        } else {
            updatePowerDeligationRequest();
        }
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
        ckbDelegateEverything.setSelected(false);
        ckbDelegateOnlySalary.setSelected(false);
    }

    private void clearCheckBoxes() {
        ckbDelegateEverything.setSelected(false);
        ckbDelegateOnlySalary.setSelected(false);
    }

    private void clearAllComponenets() {
        clearDeligatorTextComponenets();
        clearDeligateeTextComponenets();
        clearDeligationTextComponenets();
        resetSelectedObjects();
        clearCheckBoxes();
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
        clearAllComponenets();
        newOrEditOrUpdateLabel = "Save";
        btnSaveOrEditOrUpdate.setDisabled(false);
        btnDelete.setDisabled(true);
    }

    private void makePageReadyForUpdate() {
        enableComponents();
        newOrEditOrUpdateLabel = "Update";
        btnDelete.setDisabled(false);
        btnSaveOrEditOrUpdate.setDisabled(false);
        lnkViewPrevieousDecisions.setRendered(false);
    }

    private void makePageReadyForView() {
        newOrEditOrUpdateLabel = "Save";
        btnDelete.setDisabled(true);
        btnSaveOrEditOrUpdate.setDisabled(true);
        populateDeligationHistory(Integer.toString(salaryDelegationRequestId));
        lnkViewPrevieousDecisions.setRendered(true);
    }

    private void clearTable() {
        decisionsMadeOnRequestList = null;
    }

    public String btnReset_action() {
        clearAllComponenets();
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

    public String btnCalendarSatartDate_action() {
        calStartDate.setRendered(true);
        return null;
    }

    public String btnCalendarEndDate_action() {
        calEndDate.setRendered(true);
        return null;
    }

    public String btnCalendarAppliedDate_action() {
        calAppliedDate.setRendered(true);
        return null;
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        endDate = dateFormat.format(calEndDate.getValue());
        txtEndDate.setValue(endDate);
        calEndDate.setRendered(false);
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        appliedDate = dateFormat.format(calAppliedDate.getValue());
        txtAppliedDate.setValue(appliedDate);
        calAppliedDate.setRendered(false);
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        startDate = dateFormat.format(calStartDate.getValue());
        txtStartDate.setValue(startDate);
        calStartDate.setRendered(false);
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

//    public String btnSearchDeligationInfo_action() {
//        if (txtSearchDeligateeId.getValue() == null && txtSearchDeligatorId.getValue() == null) {
//            showSuccessOrFailureMessage(false, "ENTER DELIGATOR OR DELIGATE");
//        } else {
//            selectedObjectDeligatorDeligatee.setSelectedObject(null);
//            String deligator = txtSearchDeligatorId.getValue() == null ? "" : txtSearchDeligatorId.getValue().toString();
//            String deligatee = txtSearchDeligateeId.getValue() == null ? "" : txtSearchDeligateeId.getValue().toString();
//            requestsListByDeligatorAndDeligatee = requestManager.getPowerDeligationInformation(deligator, deligatee);
//        }
//
//
//        //return null means stay on the same page
//        return null;
//    }
    public void selectRequestLists_processValueChange(ValueChangeEvent vce) {
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        salaryDelegationRequestId = Integer.parseInt(requestAttributes[0]);
        delegatorId = requestAttributes[1];
        delegateeId = requestAttributes[2];
//        requesterId = requestAttributes[3];
        deligationStatus = requestAttributes[3];
        populateDeligateeTextComponents(delegateeId);
        populateDeligatorTextComponents(delegatorId);
        populateDeligationTextComponents(salaryDelegationRequestId);
        makePageReadyForUpdate();
        
    }

    public String btnDeligateeDeptSearch_action() {
        deligatorOrdeligatee = "Deligatee";
        pnlLayoutTree.setRendered(true);
        return null;
    }

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
        if (requestManager.deleteSalaryDelegationRequest(salaryDelegationRequestId)) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponenets();
            pendingRequestLists = requestManager.getPendingRequests();
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
    private SelectInputText txtDeligatorFullName = new SelectInputText();

    public SelectInputText getTxtDeligateeFullName() {
        return txtDeligateeFullName;
    }

    public void setTxtDeligateeFullName(SelectInputText txtDeligateeFullName) {
        this.txtDeligateeFullName = txtDeligateeFullName;
    }
    private SelectInputText txtDeligateeFullName = new SelectInputText();

    public SelectInputText getTxtDeligatorFullName() {
        return txtDeligatorFullName;
    }

    public void setTxtDeligatorFullName(SelectInputText txtDeligatorFullName) {
        this.txtDeligatorFullName = txtDeligatorFullName;
    }

    public String txtDeligatorFullName_action() {
        clearDeligatorTextComponenets();
        delegatorId = ApplicationBean1.getSelectedEmployeeId();
        populateDeligatorTextComponents(delegatorId);
        return null;
    }

    public String txtDeligateeFullName_action() {
        clearDeligateeTextComponenets();
        delegateeId = ApplicationBean1.getSelectedEmployeeId();
        populateDeligateeTextComponents(delegateeId);
        return null;
    }

    public String lnkPowDelApprove_action() {
        return "PowerDeligationApprove";
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
        //     requesterId = requestAttributes[3];
        deligationStatus = requestAttributes[4];
        populateDeligateeTextComponents(delegateeId);
        populateDeligatorTextComponents(delegatorId);
        populateDeligationTextComponents(salaryDelegationRequestId);
        makePageReadyForView();
    }

    public void ckbDelegateOnlySalary_processValueChange(ValueChangeEvent vce) {
        if (ckbDelegateOnlySalary.isSelected()) {
            ckbDelegateEverything.setSelected(false);
        } else {
            ckbDelegateEverything.setSelected(true);
        }
    }

    public void ckbDelegateEverything_processValueChange(ValueChangeEvent vce) {
        if (ckbDelegateEverything.isSelected()) {
            ckbDelegateOnlySalary.setSelected(false);
        } else {
            ckbDelegateOnlySalary.setSelected(true);
        }
    }
}
