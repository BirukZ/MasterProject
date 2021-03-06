/*
 * PowerDeligation.java
 *
 * Created on Feb 20, 2011, 7:48:31 AM
 * Copyright mekete VS BravoZulu
 */
package fphrms.PowerDeligation;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
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
import control.ReportControl;
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
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;
import manager.authorizationManager.AuthorizationManager.BenefitePakage;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.organizationManager.LoadTree;
import manager.powerDeligationManager.PowerDeligationApproveManager;
import manager.powerDeligationManager.PowerDeligationRequestManager;
import manager.powerDeligationManager.PowerDeligationRequestManager.PowerDeligationRequestModel;
import manager.powerDeligationManager.PowerDeligationRequestManager.PowerDeligationTakenModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PowerDeligationRequestPage extends AbstractPageBean {

    PowerDeligationRequestManager requestManager = new PowerDeligationRequestManager();
    PowerDeligationApproveManager approveManager = new PowerDeligationApproveManager();
    PowerDeligationTakenModel deligationTakenModel = new PowerDeligationTakenModel();
    PowerDeligationRequestManager reqman=new PowerDeligationRequestManager();
    DepartmentManage departmentManage = new DepartmentManage();
    EmployeeManage employeeManager = new EmployeeManage();
    String loggedInEmployeeId = getSessionBean1().getEmpDeptId();
    String userName;
    String logedEmpID;
    int delegatedPositionID;
    int delegatorPosition;
    int delegatePostion;
    private boolean expiraDelegation=false;
    private boolean extendDelegation=false;
    private boolean cheakEndDate=false;
    private String revocStartDate;
    private String revocEndDate;
    private int powDelReqId;//     @Column(name = "POW_DEL_REQ_ID")
    private String startDate;//    @Column(name = "START_DATE")
    private String endDate=null;//    @Column(name = "END_DATE")
    private String deligatedPosition;//    @Column(name = "DELIGATED_POSITION")
    private String deligationStatus;//    @Column(name = "DELIGATION_STATUS")
    private String registeredBy;//    @Column(name = "REGISTERED_BY")
    private String registeredDate;//    @Column(name = "REGISTERED_DATE")
    private String deligationReason;//    @Column(name = "DELIGATION_REASON")
    private int delegationwieght;
    private String docRefNumber;
    private String requesterId;//
    private String delegatorId;//    @JoinColumn(name = "DELIGATOR_ID", referencedColumnName = "EMP_ID")
    private String delegateeId;//    @JoinColumn(name = "DELEGATEE_ID", referencedColumnName = "EMP_ID")
    private int takenHistoryId;//     @Column(name = "TAKEN_HISTORY_ID")
    private String takenStartDate;//    @Column(name = "TAKEN_START_DATE")
    private String takenEndDate;//    @Column(name = "TAKEN_END_DATE")
    private String deligateePrevPosition;//    @Column(name = "DELIGATEE_PREV_POSITION")
    private String currentDepartmentId;
    private String currentDepartmentName;
    private String deligatorOrdeligatee;
    private String newDepartmentdelegetorDepartment;
    private String newDepartmentDelegatorPosition;
    private String newdepartmentdelegateStartDay;
    private boolean departmentisNew = false;
    private int delegationWeight;
    private int weightAmount;
    static int departmentId = 0;
    String deligatorDeptId = "0";
    String deligateeDeptId = "0";
    private PanelLayout pnlLayoutTree = new PanelLayout();
    String newOrEditOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String toDay = dateFormat.format(new Date());
    ArrayList<Option> pendingRequestLists = new ArrayList<Option>();
    ArrayList<Option> requestHistoryLists = new ArrayList<Option>();
    ArrayList<Option> powerDeligationStatusList = requestManager.getPowerDeligationStatusTypes();
    ArrayList<Option> requestsListByDeligatorAndDeligatee = new ArrayList<Option>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    ArrayList<BenefitePakage> benefitePakage=new ArrayList<BenefitePakage>();

    public boolean isCheakEndDate() {
        return cheakEndDate;
    }

    public void setCheakEndDate(boolean cheakEndDate) {
        this.cheakEndDate = cheakEndDate;
    }

    public boolean isExpiraDelegation() {
        return expiraDelegation;
    }

    public void setExpiraDelegation(boolean expiraDelegation) {
        this.expiraDelegation = expiraDelegation;
    }

    public boolean isExtendDelegation() {
        return extendDelegation;
    }

    public void setExtendDelegation(boolean extendDelegation) {
        this.extendDelegation = extendDelegation;
    }

    public String getRevocEndDate() {
        return revocEndDate;
    }

    public void setRevocEndDate(String revocEndDate) {
        this.revocEndDate = revocEndDate;
    }

    public String getRevocStartDate() {
        return revocStartDate;
    }

    public void setRevocStartDate(String revocStartDate) {
        this.revocStartDate = revocStartDate;
    }

    public int getDelegatePostion() {
        return delegatePostion;
    }

    public void setDelegatePostion(int delegatePostion) {
        this.delegatePostion = delegatePostion;
    }

    public int getDelegatorPosition() {
        return delegatorPosition;
    }

    public void setDelegatorPosition(int delegatorPosition) {
        this.delegatorPosition = delegatorPosition;
    }

    public String getLogedEmpID() {
        return logedEmpID;
    }

    public void setLogedEmpID(String logedEmpID) {
        this.logedEmpID = logedEmpID;
    }

    public ArrayList<BenefitePakage> getBenefitePakage() {
        return benefitePakage;
    }

    public void setBenefitePakage(ArrayList<BenefitePakage> benefitePakage) {
        this.benefitePakage = benefitePakage;
    }
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
        userName = getSessionBean1().getUserName();
        requestManager.setUserName(userName);
        requestManager.setLogedID(loggedInEmployeeId);
        requestHistoryLists = requestManager.getMyRequests();
        pendingRequestLists = requestManager.getPendingRequests();
        

    }

    public int getDelegatedPositionID() {
        return delegatedPositionID;
    }

    public void setDelegatedPositionID(int delegatedPositionID) {
        this.delegatedPositionID = delegatedPositionID;
    }

    public String getNewDepartmentDelegatorPosition() {
        return newDepartmentDelegatorPosition;
    }

    public void setNewDepartmentDelegatorPosition(String newDepartmentDelegatorPosition) {
        this.newDepartmentDelegatorPosition = newDepartmentDelegatorPosition;
    }

    public String getNewDepartmentdelegetorDepartment() {
        return newDepartmentdelegetorDepartment;
    }

    public void setNewDepartmentdelegetorDepartment(String newDepartmentdelegetorDepartment) {
        this.newDepartmentdelegetorDepartment = newDepartmentdelegetorDepartment;
    }

    public String getNewdepartmentdelegateStartDay() {
        return newdepartmentdelegateStartDay;
    }

    public void setNewdepartmentdelegateStartDay(String newdepartmentdelegateStartDay) {
        this.newdepartmentdelegateStartDay = newdepartmentdelegateStartDay;
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    public String getCurrentDepartmentId() {
        return currentDepartmentId;
    }

    public void setCurrentDepartmentId(String currentDepartmentId) {
        this.currentDepartmentId = currentDepartmentId;
    }

    public String getCurrentDepartmentName() {
        return currentDepartmentName;
    }

    public void setCurrentDepartmentName(String currentDepartmentName) {
        this.currentDepartmentName = currentDepartmentName;
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

        if (relodTable) {
            relodTable = false;
            try {
                LoadTree loadTree = new LoadTree();
                tree1Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
            } catch (Exception ex) {
                ex.printStackTrace();
                tree1.setRendered(false);
            }

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

    public int getDelegationWeight() {
        return delegationWeight;
    }

    public void setDelegationWeight(int delegationWeight) {
        this.delegationWeight = delegationWeight;
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

    public static void setDepartmentId(int departmentId) {
        PowerDeligationRequestPage.departmentId = departmentId;
    }

    public ArrayList<Option> getRequestsListByDeligatorAndDeligatee() {
        return requestsListByDeligatorAndDeligatee;
    }

    public void setRequestsListByDeligatorAndDeligatee(ArrayList<Option> requestsListByDeligatorAndDeligatee) {
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

    public ArrayList<Option> getPowerDeligationStatusList() {
        return powerDeligationStatusList;
    }

    public void setPowerDeligationStatusList(ArrayList<Option> powerDeligationStatusList) {
        this.powerDeligationStatusList = powerDeligationStatusList;
    }

    public ArrayList<Option> getRequestHistoryLists() {
        return requestHistoryLists;
    }

    public void setRequestHistoryLists(ArrayList<Option> requestHistoryLists) {
        this.requestHistoryLists = requestHistoryLists;
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
    HtmlOutputText outputText3 = new HtmlOutputText();

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setOutputText3(HtmlOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public ArrayList<Option> getPendingRequestLists() {
        return pendingRequestLists;
    }

    public void setPendingRequestLists(ArrayList<Option> pendingRequestLists) {
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

    public String getDocRefNumber() {
        return docRefNumber;
    }

    public void setDocRefNumber(String docRefNumber) {
        this.docRefNumber = docRefNumber;
    }

    public int getDelegationwieght() {
        return delegationwieght;
    }

    public void setDelegationwieght(int delegationwieght) {
        this.delegationwieght = delegationwieght;
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

    public int getPowDelReqId() {
        return powDelReqId;
    }

    public void setPowDelReqId(int powDelReqId) {
        this.powDelReqId = powDelReqId;
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

    public PowerDeligationRequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(PowerDeligationRequestManager requestManager) {
        this.requestManager = requestManager;
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
    private HtmlInputTextarea txtaReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaReason() {
        return txtaReason;
    }

    public void setTxtaReason(HtmlInputTextarea hit) {
        this.txtaReason = hit;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="displayTree()">
    private DefaultTree defaultTreeModel = new DefaultTree();
    private Tree treeOrgStructure = new Tree();
    private PanelLayout panelLayout3 = new PanelLayout();
    ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private PanelLayout organzationMessageBody = new PanelLayout();

    public PanelLayout getOrganzationMessageBody() {
        return organzationMessageBody;
    }

    public void setOrganzationMessageBody(PanelLayout organzationMessageBody) {
        this.organzationMessageBody = organzationMessageBody;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private PanelPopup lblOrganazationBody = new PanelPopup();

    public PanelPopup getLblOrganazationBody() {
        return lblOrganazationBody;
    }

    public void setLblOrganazationBody(PanelPopup lblOrganazationBody) {
        this.lblOrganazationBody = lblOrganazationBody;
    }

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
    private HtmlPanelGroup organzationSturcture = new HtmlPanelGroup();

    public HtmlPanelGroup getOrganzationSturcture() {
        return organzationSturcture;
    }

    public void setOrganzationSturcture(HtmlPanelGroup organzationSturcture) {
        this.organzationSturcture = organzationSturcture;
    }
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
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pp) {
        this.pnlPopupConfirmDelete = pp;
    }
    private DefaultSelectedData selectedObjectDeligatorDeligatee = new DefaultSelectedData();

    public PowerDeligationApproveManager getApproveManager() {
        return approveManager;
    }

    public void setApproveManager(PowerDeligationApproveManager approveManager) {
        this.approveManager = approveManager;
    }

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
    private PanelPopup pnlPopupViewBenefitePakage = new PanelPopup();

    public PanelPopup getPnlPopupViewBenefitePakage() {
        return pnlPopupViewBenefitePakage;
    }

    public void setPnlPopupViewBenefitePakage(PanelPopup pnlPopupViewBenefitePakage) {
        this.pnlPopupViewBenefitePakage = pnlPopupViewBenefitePakage;
    }

    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();

    public String getDeligateePrevPosition() {
        return deligateePrevPosition;
    }

    public void setDeligateePrevPosition(String deligateePrevPosition) {
        this.deligateePrevPosition = deligateePrevPosition;
    }

    public PowerDeligationTakenModel getDeligationTakenModel() {
        return deligationTakenModel;
    }

    public void setDeligationTakenModel(PowerDeligationTakenModel deligationTakenModel) {
        this.deligationTakenModel = deligationTakenModel;
    }

    public HtmlOutputText getOutputTextConfirmDelete() {
        return outputTextConfirmDelete;
    }

    public void setOutputTextConfirmDelete(HtmlOutputText outputTextConfirmDelete) {
        this.outputTextConfirmDelete = outputTextConfirmDelete;
    }

    public String getTakenEndDate() {
        return takenEndDate;
    }

    public void setTakenEndDate(String takenEndDate) {
        this.takenEndDate = takenEndDate;
    }

    public int getTakenHistoryId() {
        return takenHistoryId;
    }

    public void setTakenHistoryId(int takenHistoryId) {
        this.takenHistoryId = takenHistoryId;
    }

    public String getTakenStartDate() {
        return takenStartDate;
    }

    public void setTakenStartDate(String takenStartDate) {
        this.takenStartDate = takenStartDate;
    }

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
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
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText sit) {
        this.txtRequesterFullName = sit;
    }
    private HtmlInputText txtDeligatedPosition = new HtmlInputText();

    public HtmlInputText getTxtDeligatedPosition() {
        return txtDeligatedPosition;
    }

    public void setTxtDeligatedPosition(HtmlInputText hit) {
        this.txtDeligatedPosition = hit;
    }
    private HtmlInputText txtTakenRevokedStartDate = new HtmlInputText();

    public HtmlInputText getTxtTakenRevokedStartDate() {
        return txtTakenRevokedStartDate;
    }

    public void setTxtTakenRevokedStartDate(HtmlInputText hit) {
        this.txtTakenRevokedStartDate = hit;
    }
    private HtmlInputText txtTakenRevokedEndDate = new HtmlInputText();

    public HtmlInputText getTxtTakenRevokedEndDate() {
        return txtTakenRevokedEndDate;
    }

    public void setTxtTakenRevokedEndDate(HtmlInputText hit) {
        this.txtTakenRevokedEndDate = hit;
    }
    private HtmlCommandLink lnkRecordTakenAndRevokedDate = new HtmlCommandLink();

    public HtmlCommandLink getLnkRecordTakenAndRevokedDate() {
        return lnkRecordTakenAndRevokedDate;
    }

    public void setLnkRecordTakenAndRevokedDate(HtmlCommandLink hcl) {
        this.lnkRecordTakenAndRevokedDate = hcl;
    }
    private PanelPopup pnlPopupRegisterTakenRevokedDate = new PanelPopup();

    public PanelPopup getPnlPopupRegisterTakenRevokedDate() {
        return pnlPopupRegisterTakenRevokedDate;
    }

    public void setPnlPopupRegisterTakenRevokedDate(PanelPopup pp) {
        this.pnlPopupRegisterTakenRevokedDate = pp;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calTakenRevokedStartDate = new SelectInputDate();

    public SelectInputDate getCalTakenRevokedStartDate() {
        return calTakenRevokedStartDate;
    }

    public void setCalTakenRevokedStartDate(SelectInputDate sid) {
        this.calTakenRevokedStartDate = sid;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calTakenRevokedEndDate = new SelectInputDate();

    public SelectInputDate getCalTakenRevokedEndDate() {
        return calTakenRevokedEndDate;
    }

    public void setCalTakenRevokedEndDate(SelectInputDate sid) {
        this.calTakenRevokedEndDate = sid;
    }
    private HtmlOutputText outTxtCurrentStatus = new HtmlOutputText();

    public HtmlOutputText getOutTxtCurrentStatus() {
        return outTxtCurrentStatus;
    }

    public void setOutTxtCurrentStatus(HtmlOutputText hot) {
        this.outTxtCurrentStatus = hot;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private PopupBean panelPopup1Bean1 = new PopupBean();

    public PopupBean getPanelPopup1Bean1() {
        return panelPopup1Bean1;
    }

    public void setPanelPopup1Bean1(PopupBean pb) {
        this.panelPopup1Bean1 = pb;
    }
    private PanelPopup popup_OrganazationSturctue = new PanelPopup();

    public PanelPopup getPopup_OrganazationSturctue() {
        return popup_OrganazationSturctue;
    }

    public void setPopup_OrganazationSturctue(PanelPopup pp) {
        this.popup_OrganazationSturctue = pp;
    }
    private HtmlSelectBooleanCheckbox checkboxDelegateStatus = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckboxDelegateStatus() {
        return checkboxDelegateStatus;
    }

    public void setCheckboxDelegateStatus(HtmlSelectBooleanCheckbox hsbc) {
        this.checkboxDelegateStatus = hsbc;
    }
    private DefaultTree tree1Model = new DefaultTree();

    public DefaultTree getTree1Model() {
        return tree1Model;
    }

    public void setTree1Model(DefaultTree dt) {
        this.tree1Model = dt;
    }
    private Tree tree1 = new Tree();

    public Tree getTree1() {
        return tree1;
    }

    public void setTree1(Tree t) {
        this.tree1 = t;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drl_Position = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Position() {
        return drl_Position;
    }

    public void setDrl_Position(HtmlSelectOneMenu hsom) {
        this.drl_Position = hsom;
    }
    private HtmlInputText txt_weight = new HtmlInputText();

    public HtmlInputText getTxt_weight() {
        return txt_weight;
    }

    public void setTxt_weight(HtmlInputText hit) {
        this.txt_weight = hit;
    }
    private HtmlOutputText out_txt_wieht = new HtmlOutputText();

    public HtmlOutputText getOut_txt_wieht() {
        return out_txt_wieht;
    }

    public void setOut_txt_wieht(HtmlOutputText hot) {
        this.out_txt_wieht = hot;
    }
    private HtmlInputText txt_DocReferance = new HtmlInputText();

    public HtmlInputText getTxt_DocReferance() {
        return txt_DocReferance;
    }

    public void setTxt_DocReferance(HtmlInputText hit) {
        this.txt_DocReferance = hit;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectBooleanCheckbox chk_ExpireDelegation = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChk_ExpireDelegation() {
        return chk_ExpireDelegation;
    }

    public void setChk_ExpireDelegation(HtmlSelectBooleanCheckbox hsbc) {
        this.chk_ExpireDelegation = hsbc;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private HtmlSelectBooleanCheckbox chk_ExtendDelegation = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChk_ExtendDelegation() {
        return chk_ExtendDelegation;
    }

    public void setChk_ExtendDelegation(HtmlSelectBooleanCheckbox hsbc) {
        this.chk_ExtendDelegation = hsbc;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private HtmlSelectBooleanCheckbox chk_EndDateCheak = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChk_EndDateCheak() {
        return chk_EndDateCheak;
    }

    public void setChk_EndDateCheak(HtmlSelectBooleanCheckbox hsbc) {
        this.chk_EndDateCheak = hsbc;
    }
    private HtmlCommandButton btnCalendarEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarEndDate() {
        return btnCalendarEndDate;
    }

    public void setBtnCalendarEndDate(HtmlCommandButton hcb) {
        this.btnCalendarEndDate = hcb;
    }

//</editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PowerDeligationRequestPage() {
    }
    static int DEPARRTMENT_ID = 0;
    public boolean relodTable = true;

    public String btnDeligatorDeptSearch_action() {
        deligatorOrdeligatee = "Deligator";
        LoadTree loadTree = new LoadTree();
        treeModel.setModel(new DefaultTreeModel(loadTree.populateNodes()));
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
    private void populateBenefitPakage(int positionID)
    {
    benefitePakage = approveManager.getAllBenefitePakage(positionID);
    }

    private void populateTakenRevokedComponents(int powerDeligationRequestId) {
        deligationTakenModel = requestManager.getTakenRevokedHistoryDetail(powerDeligationRequestId);
        if (deligationTakenModel != null) {
            if (deligationTakenModel.getTakenHistoryId() == -1) {//if no resultset found
                takenHistoryId = -1;
                outTxtCurrentStatus.setValue("Select beggning date ");
            } else {
                outTxtCurrentStatus.setValue("Select End date");
                takenHistoryId = deligationTakenModel.getTakenHistoryId();
                txtTakenRevokedStartDate.setValue(deligationTakenModel.getTakenStartDate());
              //  txtTakenRevokedStartDate.setValue(deligationRequestModel.getStartDate());
                txtTakenRevokedEndDate.setValue(deligationTakenModel.getTakenEndDate());
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
                delegationWeight=Integer.parseInt(empInfoHashMap.get("employeeJobCode").toString());
                weightAmount=requestManager.getWieght(delegationWeight);
                delegatorId = employeeId;//empInfoHashMap.get("employeeId").toString();
                deligatedPosition = empInfoHashMap.get("employeeJobCode").toString();
                txtDeligatorDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtDeligatorFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeligatorId.setValue(employeeId);
                txtDeligatorPosition.setValue(empInfoHashMap.get("employeePosition"));
                txtDeligatedPosition.setValue(empInfoHashMap.get("employeePosition"));
                delegatorDept_id = empInfoHashMap.get("employeeDepartment").toString();
                out_txt_wieht.setValue(weightAmount);
                delegatorPosition=Integer.parseInt(empInfoHashMap.get("employeeDepartment").toString());
               
               
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void populateRequesterTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                requesterId = "-1";
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                requesterId = employeeId;//empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(employeeId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
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
                delegateeDept_id = empInfoHashMap.get("employeeDepartment").toString();
                delegatePostion=Integer.parseInt(empInfoHashMap.get("employeeDepartment").toString());
               
               
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

    private void populateDeligationTextComponents(int powerDeligationRequestId) {
        PowerDeligationRequestModel deligationRequestModel = requestManager.getPowerDeligationDetail(powerDeligationRequestId);
        if (deligationRequestModel != null) {
            if (deligationRequestModel.getPowDelReqId() == -1) {//if no resultset found
                powDelReqId = -1;
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + powerDeligationRequestId);
            } else {
                txtStartDate.setValue(deligationRequestModel.getStartDate());
                txtEndDate.setValue(deligationRequestModel.getEndDate());
                txtaReason.setValue(deligationRequestModel.getDeligationReason());
                out_txt_wieht.setValue(deligationRequestModel.getDelegationWieght());
                txt_DocReferance.setValue(deligationRequestModel.getDocRefeNumber());
                revocStartDate=deligationRequestModel.getStartDate();
                revocEndDate=deligationRequestModel.getEndDate();
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    public String btnClosePopupOrganzation_action() {
      weightAmount=requestManager.getWieght(delegationWeight);
        popup_OrganazationSturctue.setRendered(false);

        return null;
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
        txtaReason.setDisabled(false);
        txtDeligateeId.setDisabled(false);
    }

    private void disableComponents() {

        txtDeligateeId.setDisabled(true);
        txtDeligatorId.setDisabled(true);
    }

    private boolean validateAndInitializePowerDeligationAttributes() {
        if (delegateeId == null || delegatorId == null || requesterId == null ||
                delegateeId.equals("-1") || delegatorId.equals("-1") || requesterId.equals("-1")) {//no enough info to save
            showSuccessOrFailureMessage(true, "SELECT REQUESTER, DELIGATOR AND DELIGATEE FIRST");
            return false;
       // } else if (txtEndDate.getValue() == null || txtStartDate == null || txtStartDate.getValue().toString().equals("") || txtEndDate.getValue().toString().equals("")) {
             } else if ( txtStartDate == null || txtStartDate.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(true, "START DATE AND END DATE CAN NOT BE EMPTY");
            return false;
        } else if (txtaReason.getValue() == null || txtaReason.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(true, "REASON NOT FILLED");
            return false;
        } else {
            startDate = txtStartDate.getValue().toString();
            endDate = txtEndDate.getValue().toString();
            deligationReason = txtaReason.getValue().toString();
            delegationwieght = Integer.parseInt(out_txt_wieht.getValue().toString());
            docRefNumber=txt_DocReferance.getValue().toString();
            registeredDate = toDay;
            registeredBy = loggedInEmployeeId;

        }
        return true;
    }

    private boolean validateAndInitializePowerDeligationAttributesNew() {
        if (delegateeId == null || requesterId == null ||
                delegateeId.equals("-1") || requesterId.equals("-1")) {//no enough info to save
            showSuccessOrFailureMessage(true, "SELECT REQUESTER AND DELIGATEE FIRST");
            return false;
        } else if (txtStartDate == null || txtStartDate.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(true, "START DATE  CAN NOT BE EMPTY");
            return false;
        } else if (txtaReason.getValue() == null || txtaReason.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(true, "REASON NOT FILLED");
            return false;
        } else {
            startDate = txtStartDate.getValue().toString();
            endDate = "";
            deligationReason = txtaReason.getValue().toString();
            delegationwieght = Integer.parseInt(out_txt_wieht.getValue().toString());
            docRefNumber=txt_DocReferance.getValue().toString();
            registeredDate = toDay;
            registeredBy = loggedInEmployeeId;

        }
        return true;
    }

    public boolean savePowerDeligationRequest(boolean external) {

        if (validateAndInitializePowerDeligationAttributesNew()) {
            try {
                Date selectedStartDate = (Date) calStartDate.getValue();
                Date selectedEndDate = (Date) calEndDate.getValue();
                // date todayDate=today.
                startDate = dateFormat.format(calStartDate.getValue());
                endDate = dateFormat.format(calEndDate.getValue());
                if (false) {
                    return false;
                } else {
                    return requestManager.savePowerDeligationInformation(startDate, endDate, deligatedPosition, registeredBy, registeredDate, deligationReason, delegatorId, delegateeId, requesterId, external, delegationwieght,docRefNumber);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                showSuccessOrFailureMessage(true, "INSERT START DATE AND END DATE");
            }
        }

        return false;
    }

    public boolean savePowerDeligationRequestNew(boolean external) {


        if (validateAndInitializePowerDeligationAttributesNew()) {
            try {
                Date selectedStartDate = (Date) calStartDate.getValue();
               
                 startDate = dateFormat.format(calStartDate.getValue());
               if(cheakEndDate){
               endDate=null;
               }
               else{
              endDate = dateFormat.format(calEndDate.getValue());
               }
               
//                if (false) {
//                    return false;
//                } else {
                    return requestManager.savePowerDeligationInformationNew(startDate, endDate, deligatedPosition, registeredBy, registeredDate, deligationReason, delegatorId, delegateeId, requesterId, external, newDepartmentdelegetorDepartment, newDepartmentDelegatorPosition, delegationwieght,docRefNumber);
//                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                showSuccessOrFailureMessage(true, "INSERT START DATE AND END DATE");
            }
        }

        return false;
    }

    public boolean updatePowerDeligationRequest() {
        if (delegateeId == null || delegatorId == null) {//no enough info to save
            showSuccessOrFailureMessage(true, "SELECT DELIGATOR AND DELIGATEE FIRST");
        } else if (txtEndDate.getValue() == null || txtStartDate == null) {
            showSuccessOrFailureMessage(true, "START DATE AND END DATE CAN NOT BE EMPTY");
        } else {
            try {
                startDate = txtStartDate.getValue().toString();
                endDate = txtEndDate.getValue().toString();
                deligationReason = txtaReason.getValue().toString();
                docRefNumber=txt_DocReferance.getValue().toString();
                registeredDate = toDay;
                registeredBy = loggedInEmployeeId;
                requestManager.updatePowerDeligationInformation(powDelReqId, startDate, endDate, deligatedPosition, registeredBy, registeredDate, deligationReason, delegatorId, delegateeId, requesterId,docRefNumber);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                showSuccessOrFailureMessage(true, "INSERT START DATE AND END DATE");
            }
        }
        return false;
    }

    public String btnSave_action() {

        //return null means stay on the same page
        return null;
    }

    public boolean checkDept(String dep_id, String delegateeDept) {
        return requestManager.checkDept(dep_id, delegateeDept);
    }

    public boolean checkeEmpRank(String requesterID) {
        return requestManager.checkEmpRank(requesterID);
    }


    public void saveActionNew(boolean external) {
        newDepartmentDelegatorPosition = txtDeligatorPosition.getValue().toString();
        newDepartmentdelegetorDepartment = txtDeligatorDepartment.getValue().toString();
        newdepartmentdelegateStartDay = txtStartDate.getValue().toString();

         if (savePowerDeligationRequestNew(external)) {
            showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
            pendingRequestLists = requestManager.getPendingRequests();
            clearAllComponenets();

        } else {//delegator who is not authorized to request for more than 15 days
            showSuccessOrFailureMessage(false, "SAVING NOT SUCCESSFULL Biruk2 ");
        }

    }
    public int delegatorRank;

    public int employeeRank(int requestID) {
        delegatorRank = requestManager.getDelegatorRank(requesterId);

        return delegatorRank;
    }

    public void saveAction(boolean external) {
        int dateDifference = 0;
       // dateDifference = StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(), txtEndDate.getValue().toString());

//        if ((dateDifference > 15) && (requestManager.getDelegatorRank(requesterId)) == 14) {//for employee who is autorized to delegate for more than 15 days
//            showSuccessOrFailureMessage(false, "DELEGATOR IS NOT ALLOWED TO REQUEST FOR MORE THAN 15 DAYS");
//        } else {
            //  if (requestManager.checkDelegator(delegatorId))
            //             {
      
            if (savePowerDeligationRequestNew(external)) {
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
                pendingRequestLists = requestManager.getPendingRequests();
                clearAllComponenets();
            } else {//delegator who is not authorized to request for more than 15 days
                //  showSuccessOrFailureMessage(false, "DELEGATOR IS NOT ALLOWED TO REQUEST FOR MORE THAN 15 DAYS");
                showSuccessOrFailureMessage(false, "ERROR OCCURED SAVING FAILED");
            }
//                if (savePowerDeligationRequest(external))
//                          {
//
//                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
//                    pendingRequestLists = requestManager.getPendingRequests();
//                    clearAllComponenets();
//                    }
//                else {
//               showSuccessOrFailureMessage(false, "ERROR OCCURED SAVING FAILED");
//                }

       // }
    }


//         else {//for employees who can delegate for less than 15 days
//            if (savePowerDeligationRequest(external)) {
//
//                showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
//                pendingRequestLists = requestManager.getPendingRequests();
//                clearAllComponenets();
//            } else {
//                showSuccessOrFailureMessage(false, "ERROR OCCURED SAVING FAILED");
//            }
//        }
    public boolean CheakDelegationCondition(int delegatorPosition,int delegatePosition){

                    boolean positionCondition;

                       if(delegatorPosition==delegatePosition){

                       positionCondition=false;
                    
                       }else {
                       positionCondition=true;
                    

                       }
             
            return positionCondition;
                  }
    public String btnSaveOrEditOrUpdate_action() {

        if (departmentisNew) {

            if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
                saveActionNew(true);
            } else {
                saveActionNew(false);
            }
            return null;
        } else {

            if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {//prepared for insert
               // delegatorId = txtRequesterId.getValue().toString();
                requesterId=txtRequesterId.getValue().toString();
                delegateeId = txtDeligateeId.getValue().toString();

//                if (checkeEmpRank(requesterId))
//                 {
                   
                    saveAction(CheakDelegationCondition(delegatorPosition, delegatePostion));

//                } else {
//
//                    showSuccessOrFailureMessage(false, "YOU CAN NOT REQUEST DELEGATION B/C YOU DON'T HAVE PRIVELAGE TO DO THAT");
//                }

            } else if (newOrEditOrUpdateLabel.equalsIgnoreCase("Edit")) {
                enableComponents();
                newOrEditOrUpdateLabel = "Update";
            } else {//editOrUpdateLabel.equalsIgnoreCase("Update")){
                if (updatePowerDeligationRequest()) {
                    disableComponents();
                    clearAllComponenets();
                    newOrEditOrUpdateLabel = "Save";
                    showSuccessOrFailureMessage(true, "UPDATING SUCCESSFUL");
                    pendingRequestLists = requestManager.getPendingRequests();
                } else {
                    showSuccessOrFailureMessage(false, "ERROR OCCURED IN UPDATING.\n PLEASE TRY AGAIN BY CORRECT YOUR VALUES");
                }
            }
        }
        return null;
    }

    private void clearRequesterTextComponenets() {
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterId.setValue(null);
        txtRequesterPosition.setValue(null);
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
        txtaReason.setValue(null);
        txtDeligatedPosition.setValue(null);
    }

    private void clearAllComponenets() {
        clearDeligatorTextComponenets();
        clearDeligateeTextComponenets();
        clearRequesterTextComponenets();
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
        powDelReqId = 0;
    }

    private void makePageReadyForSave() {
        clearAllComponenets();
        newOrEditOrUpdateLabel = "Save";
        btnSaveOrEditOrUpdate.setDisabled(false);
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
        populateDeligationHistory(Integer.toString(powDelReqId));
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

    public String btnViewTree_action() {

        LoadTree loadTree = new LoadTree();
        this.tree1Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        organzationMessageBody.setRendered(true);

        return null;
    }

    public void commandLink1_processAction(ActionEvent ae) {

        String departmentName;
        String department = tree1.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];

            DEPARRTMENT_ID = Integer.parseInt(_department[1].trim());

            txtDeligatorDepartment.setValue(departmentName);


            if (DEPARRTMENT_ID != 0) {
                this.setPerofation(departmentManage.readJobCode(String.valueOf(DEPARRTMENT_ID)));
            } else {
                this.setPerofation(departmentManage.onDisplayJob());
            }
        //organzationMessageBody.setRendered(false);

        }

    }

    public void commandLink1_processActionNew(ActionEvent ae) {

        String departmentName;
        String department = tree1.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];

            DEPARRTMENT_ID = Integer.parseInt(_department[1].trim());

            txtDeligatorDepartment.setValue(departmentName);


            if (DEPARRTMENT_ID != 0) {
                this.setPerofation(departmentManage.readJobCodeNew(String.valueOf(DEPARRTMENT_ID)));
            } else {
                this.setPerofation(departmentManage.onDisplayJob());
            }
        //organzationMessageBody.setRendered(false);

        }

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

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        endDate = dateFormat.format(calEndDate.getValue());
        txtEndDate.setValue(endDate);
        calEndDate.setRendered(false);
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        startDate = dateFormat.format(calStartDate.getValue());
        txtStartDate.setValue(startDate);
        calStartDate.setRendered(false);
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
        powDelReqId = Integer.parseInt(requestAttributes[0]);
        delegatorId = requestAttributes[1];
        delegateeId = requestAttributes[2];
        requesterId = requestAttributes[3];
        deligationStatus = requestAttributes[4];
        newDepartmentDelegatorPosition = requestAttributes[6];
        newDepartmentdelegetorDepartment = requestAttributes[5];
        delegatedPositionID=Integer.parseInt( requestAttributes[7]);


        if (delegatorId.equalsIgnoreCase("null")) {
            txtDeligatorDepartment.setValue(newDepartmentdelegetorDepartment);
            txtDeligatorPosition.setValue(newDepartmentDelegatorPosition);
            txtDeligatedPosition.setValue(newDepartmentDelegatorPosition);
            populateDeligateeTextComponents(delegateeId);
            populateRequesterTextComponents(requesterId);
            populateDeligationTextComponents(powDelReqId);
            populateTakenRevokedComponents(powDelReqId);
            populateBenefitPakage(delegatedPositionID);
            makePageReadyForUpdate();

        } else {
            populateDeligateeTextComponents(delegateeId);
            populateDeligatorTextComponents(delegatorId);
            populateRequesterTextComponents(requesterId);
            populateDeligationTextComponents(powDelReqId);
            populateTakenRevokedComponents(powDelReqId);
            populateBenefitPakage(delegatedPositionID);
            makePageReadyForUpdate();
        }
    }

    public String btnDeligateeDeptSearch_action() {
        deligatorOrdeligatee = "Deligatee";
        treeModel.setModel(new DefaultTreeModel((new LoadTree()).populateNodes()));
        pnlLayoutTree.setRendered(true);
        return null;
    }

    public void setDepartmentFromTree() {
        //deligatorOrdeligatee value is set by the button action
        if (deligatorOrdeligatee.equalsIgnoreCase("Deligator")) {
            deligatorDeptId = currentDepartmentId;
            txtDeligatorDepartment.setValue(currentDepartmentName);
        } else {
            deligateeDeptId = currentDepartmentId;
            txtDeligateeDepartment.setValue(currentDepartmentName);
        }
    }

    public void cmdLnkTree_processAction(ActionEvent ae) {
        String departmentName;
        int departmentId;
        String department = treeOrgStructure.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];
            departmentId = Integer.parseInt(_department[1].trim());
            txtDeligateeId.setValue(departmentId + "==" + departmentName);
            if (departmentId != 0) {
                this.setPerofation(departmentManage.readJobCode(String.valueOf(departmentId)));
            } else {
                this.setPerofation(departmentManage.onDisplayJob());
            }
            pnlLayoutTree.setRendered(false);
        }
    }
//
//    public void cmdLnkTree_processAction(ActionEvent ae) {
//        String dept = "";
//        if (treeOrgStructure.getCurrentNode() == null) {
//            dept = "NO DEPT FROM TREE";
//        } else {
//            dept = treeOrgStructure.getCurrentNode().toString();
//
//        }
//
//        String department = treeOrgStructure.getCurrentNode().toString();//.substring(0, 2);
//        String _department[] = department.split("#");
//
//
//        if (_department.length > 1) {
//            currentDepartmentName = _department[0];
//            currentDepartmentId = _department[1];
//            departmentId = Integer.parseInt(_department[1]);
//            if (departmentId != 0) {
//                this.setPerofation(departmentManage.readJobCode(currentDepartmentId));
//            } else {
//                this.setPerofation(departmentManage.onDisplayJob());
//            }
//            setDepartmentFromTree();
//            pnlLayoutTree.setRendered(false);
//        }
//    }

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnPopupOkDelete_action() {
        if (requestManager.deletePowerDeligationRequest(powDelReqId)) {
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
            powDelReqId = Integer.parseInt(requestInfo.split("--")[0]);
            delegatorId = requestInfo.split("--")[1];
            delegateeId = requestInfo.split("--")[2];
            deligationStatus = requestInfo.split("--")[3];
            populateDeligateeTextComponents(delegateeId);
            populateDeligatorTextComponents(delegatorId);
            populateDeligationTextComponents(powDelReqId);

            newOrEditOrUpdateLabel = "Edit";
            //check if the request is updatable
            if (deligationStatus.equals(PowerDeligationApproveManager.INITIAL_STATE_POWER_DELIGATION)) {
                //no history , hence can be updated
                displayDecisionButtons(true);
            } else {
                //process already started canot be updated.So decision tables not displayed
                //but history is displayed
                displayDecisionButtons(false);
                populateDeligationHistory(Integer.toString(powDelReqId));
            }

        }
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(powDelReqId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }
 public String btnCloseViewBenefitePakage_action() {
        pnlPopupViewBenefitePakage.setRendered(false);
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
    String delegatorDept_id, delegateeDept_id;

    public String txtDeligateeFullName_action() {
        clearDeligateeTextComponenets();
        delegateeId = ApplicationBean1.getSelectedEmployeeId();
        populateDeligateeTextComponents(delegateeId);
        return null;
    }

    public String lnkPowDelApprove_action() {
        return "PowerDeligationApprove";
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponenets();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        return null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
            requesterId = txtRequesterId.getValue().toString();
            populateRequesterTextComponents(requesterId);
        }
        return null;
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
        powDelReqId = Integer.parseInt(requestAttributes[0]);
        delegatorId = requestAttributes[1];
        delegateeId = requestAttributes[2];
        requesterId = requestAttributes[3];
        deligationStatus = requestAttributes[4];
        newDepartmentdelegetorDepartment = requestAttributes[5];
        newDepartmentDelegatorPosition = requestAttributes[6];
        delegatedPositionID= Integer.parseInt( requestAttributes[7]);
        if (deligationStatus.equalsIgnoreCase("-Res-63"))
                  {
            if (delegatorId.equalsIgnoreCase("null")) {
                txtDeligatorDepartment.setValue(newDepartmentdelegetorDepartment);
                txtDeligatorPosition.setValue(newDepartmentDelegatorPosition);
                txtDeligatedPosition.setValue(newDepartmentDelegatorPosition);
                populateDeligateeTextComponents(delegateeId);
                populateRequesterTextComponents(requesterId);
                populateDeligationTextComponents(powDelReqId);
                populateBenefitPakage(delegatedPositionID);
                makePageReadyForUpdate();
            } else {
                populateDeligateeTextComponents(delegateeId);
                populateDeligatorTextComponents(delegatorId);
                populateRequesterTextComponents(requesterId);
                populateDeligationTextComponents(powDelReqId);
                populateBenefitPakage(delegatedPositionID);
                makePageReadyForUpdate();
            }
        } else {
            if (delegatorId.equalsIgnoreCase("null")) {
                txtDeligatorDepartment.setValue(newDepartmentdelegetorDepartment);
                txtDeligatorPosition.setValue(newDepartmentDelegatorPosition);
                txtDeligatedPosition.setValue(newDepartmentDelegatorPosition);
                populateDeligateeTextComponents(delegateeId);
                populateRequesterTextComponents(requesterId);
                populateDeligationTextComponents(powDelReqId);
                populateBenefitPakage(delegatedPositionID);
                makePageReadyForView();
            } else {
                populateDeligateeTextComponents(delegateeId);
                populateDeligatorTextComponents(delegatorId);
                populateRequesterTextComponents(requesterId);
                populateDeligationTextComponents(powDelReqId);
                populateBenefitPakage(delegatedPositionID);
                makePageReadyForView();


            }
        }
    }

    public boolean saveTakenRevokedDate() {

//        if (takenHistoryId == -1)
//        {//new entry
//
//            takenStartDate = txtTakenRevokedStartDate.getValue() == null ? "" : txtTakenRevokedStartDate.getValue().toString();
//            //takenStartDate = txtTakenRevokedEndDate.getValue() == null ? "" : txtTakenRevokedEndDate.getValue().toString();
//
//            return requestManager.savePowerDeligationTakenHistory(powDelReqId, takenStartDate, takenEndDate, deligateePrevPosition, "");
//        }
//
//        else {
//            return requestManager.updatePowerDeligationTakenHistory(powDelReqId,takenHistoryId, takenStartDate, takenEndDate, deligateePrevPosition, "");
//        }
          if (expiraDelegation)
        {
              takenStartDate=revocStartDate;
              takenEndDate=revocEndDate;

            return requestManager.savePowerDeligationTakenHistory(powDelReqId, takenStartDate, takenEndDate, deligateePrevPosition, "");
        }

        else if(extendDelegation) {
           
             takenStartDate=txtTakenRevokedStartDate.getValue().toString();
             takenEndDate=txtTakenRevokedEndDate.getValue().toString();
           
        

            return requestManager.updatePowerDeligationTakenHistory(powDelReqId,takenHistoryId, takenStartDate, takenEndDate, deligateePrevPosition, "");
        }
          return true;
    }

    public String btnPopupSaveTakenRevokedDate_action() {

        if (saveTakenRevokedDate())
        {
            outTxtCurrentStatus.setValue("SAVING SUCCESSFUL ");
        //     showSuccessOrFailureMessage(true, "OKAY");
        } else {
            outTxtCurrentStatus.setValue(" SAVING FAILED");
        //showSuccessOrFailureMessage(false, "FAILED");
        }
        return null;
    }

    private void clearPopupTakenHistoryComponents() {
        txtTakenRevokedStartDate.setValue("");
        txtTakenRevokedEndDate.setValue("");
    }

    public String btnReseTakenRevokedDate_action() {
        clearPopupTakenHistoryComponents();
        populateTakenRevokedComponents(powDelReqId);
        return null;
    }

    public String btnTakenRevokedCalendarSatartDate_action() {
        calTakenRevokedStartDate.setRendered(true);
        return null;
    }

    public String cmdLnkClosePopupRegisterTakenRevokedDate_action() {
        pnlPopupRegisterTakenRevokedDate.setRendered(false);
        clearPopupTakenHistoryComponents();
        return null;
    }

    public String btnTakenRevokedCalendarEndDate_action() {
        calTakenRevokedEndDate.setRendered(true);
        return null;
    }

    public String lnkRecordTakenAndRevokedDate_action() {
       // populateTakenRevokedComponents(powDelReqId);
         txtTakenRevokedStartDate.setValue(revocStartDate);
         txtTakenRevokedEndDate.setValue(revocEndDate);
         pnlPopupRegisterTakenRevokedDate.setRendered(true);
        return null;
    }

    public void calTakenRevokedStartDate_processValueChange(ValueChangeEvent vce) {
        takenStartDate = dateFormat.format(calTakenRevokedStartDate.getValue());
        txtTakenRevokedStartDate.setValue(takenStartDate);
        calTakenRevokedStartDate.setRendered(false);
    }

    public void calTakenRevokedEndDate_processValueChange(ValueChangeEvent vce) {
        takenEndDate = dateFormat.format(calTakenRevokedEndDate.getValue());
        txtTakenRevokedEndDate.setValue(takenEndDate);
        calTakenRevokedEndDate.setRendered(false);
    }
    private ReportControl reportCtrl = new ReportControl();

    public void txtDeligatorFullName_processValueChange(ValueChangeEvent vce) {
    }

    public void View_PowerDelegationReport() {
        String jasperLocation = "D:\\Mugher Report\\PowerDelegation.jasper";
        String reportName = "PowerDelegation";
        try {
            HashMap param = new HashMap();
            param.put("DELEGATOR_FULL_NAME", txtDeligatorFullName.getValue().toString());
            param.put("DELEGATOR_DEPARTMENT", txtDeligatorId.getValue().toString());
            param.put("DELEGATOR_POSITION", txtDeligatorDepartment.getValue().toString());
            param.put("DELEGATOR_ID", txtDeligatorPosition.getValue().toString());
            param.put("DELEGATEE_FULL_NAME", txtDeligateeFullName.getValue().toString());
            param.put("DELEGATEE_DEPARTMENT", txtDeligateeId.getValue().toString());
            param.put("DELEGATEE_POSITION", txtDeligateeDepartment.getValue().toString());
            param.put("DELEGATEE_ID", txtDeligateePosition.getValue().toString());
            param.put("START_DATE", txtStartDate.getValue().toString());
            param.put("END_DATE", txtEndDate.getValue().toString());
            param.put("REASON", txtaReason.getValue().toString());
            param.put("POSITION", txtDeligatedPosition.getValue().toString());
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            ServletOutputStream servletOutputStream = null;
            servletOutputStream = response.getOutputStream();
            reportCtrl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, null);
            servletOutputStream.flush();
            servletOutputStream.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }
    }

    public String lnkReport_action() {
        ArrayList<HashMap> delegatedEmployee = new ArrayList<HashMap>();
        String jasperLocation = "D:\\Mugher Report\\PowerDelegation.jasper";
        String reportName = "PowerDelegation";
        try {//
            HashMap param = new HashMap();
            param.put("DELEGATOR_FULL_NAME", txtDeligatorFullName.getValue().toString());
            param.put("DELEGATOR_DEPARTMENT", txtDeligatorDepartment.getValue().toString());
            param.put("DELEGATOR_POSITION", txtDeligatorPosition.getValue().toString());
            param.put("DELEGATOR_ID", txtDeligatorId.getValue().toString());
            param.put("DELEGATEE_FULL_NAME", txtDeligateeFullName.getValue().toString());
            param.put("DELEGATEE_DEPARTMENT", txtDeligateeDepartment.getValue().toString());
            param.put("DELEGATEE_POSITION", txtDeligateePosition.getValue().toString());
            param.put("DELEGATEE_ID", txtDeligateeId.getValue().toString());
            param.put("START_DATE", txtStartDate.getValue().toString());
            param.put("END_DATE", txtEndDate.getValue().toString());
            param.put("REASON", txtaReason.getValue().toString());
            param.put("POSITION", txtDeligatedPosition.getValue().toString());
            delegatedEmployee.add(param);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            ServletOutputStream servletOutputStream = null;
            servletOutputStream = response.getOutputStream();
            reportCtrl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, delegatedEmployee);
            servletOutputStream.flush();
            servletOutputStream.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }
        //return null means stay on the same page
        return null;
    }

    public void checkboxDelegateStatus_processValueChange(ValueChangeEvent vce) {

        if (checkboxDelegateStatus.isSelected()) {
            popup_OrganazationSturctue.setRendered(true);
            txtDeligatorFullName.setDisabled(true);
            txtDeligatorId.setDisabled(true);
            delegatorId = "";
            departmentisNew = true;



        }

    }

    public void drl_Position_processValueChange(ValueChangeEvent vce) {
        String Position = vce.getNewValue().toString();
        String[] positionCode = Position.split("-");
        int code = Integer.parseInt(positionCode[0]);
        String description = positionCode[1];
        txtDeligatorPosition.setValue(description);
        txtDeligatedPosition.setValue(description);
        txtDeligatorFullName.setDisabled(true);
        txtDeligatorId.setDisabled(true);
        weightAmount=requestManager.getWieght(code);
        out_txt_wieht.setValue(weightAmount);

    }

    public String lnkViewBenefitPackage_action() {
        //return null means stay on the same page
       // this.getBenefitePakage(delegationWeight);
        populateBenefitPakage(delegatedPositionID);
        populateBenefitPakage(delegationWeight);
        pnlPopupViewBenefitePakage.setRendered(true);
        return null;
    }

    

    public void chk_ExpireDelegation_processValueChange(ValueChangeEvent vce) {
        if(chk_ExpireDelegation.isSelected()){
        chk_ExtendDelegation.setDisabled(true);
        expiraDelegation=true;
        extendDelegation=false;

        }
    }

    public void chk_ExtendDelegation_processValueChange(ValueChangeEvent vce) {
        if(chk_ExtendDelegation.isSelected())
        {
        chk_ExpireDelegation.setDisabled(true);
        expiraDelegation=false;
        extendDelegation=true;
        }

    }

    public String txtDeligatedPosition_action() {
        //return null means stay on the same page
        return null;
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void chk_EndDateCheak_processValueChange(ValueChangeEvent vce) {
        if(chk_EndDateCheak.isSelected()){

        txtEndDate.setDisabled(true);
        btnCalendarEndDate.setDisabled(true);
        cheakEndDate=true;

        }
    }

   




    
    
}
