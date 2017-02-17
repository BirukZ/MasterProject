/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.PowerDeligation;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import entity.employeeEntity.EmployeeEntityOld;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.swing.JOptionPane;
import manager.authorizationManager.AuthorizationManager.BenefitePakage;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.powerDeligationManager.PowerDeligationApproveManager;
import manager.powerDeligationManager.PowerDeligationRequestManager;
import manager.powerDeligationManager.PowerDeligationRequestManager.PowerDeligationRequestModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PowerDeligationApprovePage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {

        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        approverId = loggedInEmployeeId;
        loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        userName = getSessionBean1().getUserName();
        approveManager.setUserName(userName);
        approveManager.setLoginEmpID(loggedInEmployeeId);
        populateApproverTextComponents(loggedInEmployeeId);

        if (checkRole()){
            
            approvableRequests = approveManager.getApprovableRequests(true);

        } else {
            approvableRequests = approveManager.getApprovableRequests(false);
        }
        requestHistoryLists = approveManager.getAllMyPrevieousDecisions();
        requestManager.setUserName(userName);

    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init(), prerender(), preprocess() ">
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
        if (!isPostBack()) {
        }
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        if (loggedInEmployeeId != null) {
            populateApproverTextComponents(loggedInEmployeeId);
        }

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
    @Override
    public void prerender() {
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        
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

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public PowerDeligationRequestManager getRequestManager() {
        return requestManager;
    }

    public void setRequestManager(PowerDeligationRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getToDay() {
        return toDay;
    }

    public void setToDay(String toDay) {
        this.toDay = toDay;
    }
    // </editor-fold >
    // <editor-fold defaultstate="collapsed" desc="All Getters and Setters">

    public PowerDeligationApproveManager getApproveManager() {
        return approveManager;
    }

    public void setApproveManager(PowerDeligationApproveManager approveManager) {
        this.approveManager = approveManager;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public ArrayList<Option> getRequestsListByStatus() {
        return approvableRequests;
    }

    public void setRequestsListByStatus(ArrayList<Option> approvableRequests) {
        this.approvableRequests = approvableRequests;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public ArrayList<Option> getRequestsListByDeligatorAndDeligatee() {
        return requestsListByDeligatorAndDeligatee;
    }

    public void setRequestsListByDeligatorAndDeligatee(ArrayList<Option> requestsListByDeligatorAndDeligatee) {
        this.requestsListByDeligatorAndDeligatee = requestsListByDeligatorAndDeligatee;
    }
    // </editor-fold>
    PowerDeligationRequestManager requestManager = new PowerDeligationRequestManager();
    PowerDeligationApproveManager approveManager = new PowerDeligationApproveManager();
    EmployeeManage employeeManager = new EmployeeManage();
    ArrayList<Option> approvableRequests = new ArrayList<Option>();//requestManager.getApprovableRequests();
    ArrayList<Option> requestHistoryLists = new ArrayList<Option>();
    ArrayList<Option> requestsListByDeligatorAndDeligatee = new ArrayList<Option>();
    ArrayList<Option> powerDeligationStatusList = requestManager.getPowerDeligationStatusTypes();
    ArrayList<Option> availableDecisionsToMakeList = null;//approveManager.getAvailableDecisions(getDeligationStatus());
    ArrayList<BenefitePakage> benefitePakage=new ArrayList<BenefitePakage>();
    private DefaultSelectedData selectedObjectListboxRequestDeligatorDeligatee = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectListboxRequestByStatus = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOneMenuRequestStatusStates = new DefaultSelectedData();
    //ArrayList<HashMap> decisionsMadeOnRequest = new ArrayList<HashMap>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String toDay = dateFormat.format(new Date());
    String loggedInEmployeeId = "";// getSessionBean1().getEmployeeId();
    String loggedInEmployeeDept = "";
    String userName = "";
    String changeOrSearchDeciderButtonLabel = "change";
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    int powDelReqId = -1;
    String startDate;
    String endDate;
    String deligatedPosition;
    String deligationStatus;
    String registeredBy;
    String registeredDate;
    String deligationReason;
    String deligatorId;
    String delegateeId;
    String requesterId;//
    String approverId = null;
    String newDepartmentName;
    String newDepartmentPosition;
    int delegatedPosition;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //<editor-fold defaultstate="collapsed" desc="All Getters and Setters">
    private PanelPopup pnMessage = new PanelPopup();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelLayout container = new PanelLayout();

    public int getDelegatedPosition() {
        return delegatedPosition;
    }

    public void setDelegatedPosition(int delegatedPosition) {
        this.delegatedPosition = delegatedPosition;
    }

    public ArrayList<BenefitePakage> getBenefitePakage() {
        return benefitePakage;
    }

    public void setBenefitePakage(ArrayList<BenefitePakage> benefitePakage) {
        this.benefitePakage = benefitePakage;
    }

    public String getLoggedInEmployeeDept() {
        return getSessionBean1().getEmpDeptId();
    }

    public void setLoggedInEmployeeDept(String loggedInEmployeeDept) {
        this.loggedInEmployeeDept = loggedInEmployeeDept;
    }

    public String getUserName() {
        return getSessionBean1().getUserName();
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }
    private DefaultSelectedData selectedObjectRequestsByHistory = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectRequestsByHistory() {
        return selectedObjectRequestsByHistory;
    }

    public void setSelectedObjectRequestsByHistory(DefaultSelectedData selectedObjectRequestsByHistory) {
        this.selectedObjectRequestsByHistory = selectedObjectRequestsByHistory;
    }

    public DefaultSelectedData getSelectedObjectListboxRequestByStatus() {
        return selectedObjectListboxRequestByStatus;
    }

    public void setSelectedObjectListboxRequestByStatus(DefaultSelectedData selectedObjectListboxRequestByStatus) {
        this.selectedObjectListboxRequestByStatus = selectedObjectListboxRequestByStatus;
    }

    public DefaultSelectedData getSelectedObjectListboxRequestDeligatorDeligatee() {
        return selectedObjectListboxRequestDeligatorDeligatee;
    }

    public void setSelectedObjectListboxRequestDeligatorDeligatee(DefaultSelectedData selectedObjectListboxRequestDeligatorDeligatee) {
        this.selectedObjectListboxRequestDeligatorDeligatee = selectedObjectListboxRequestDeligatorDeligatee;
    }

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public DefaultSelectedData getSelectedObjectOneMenuRequestStatusStates() {
        return selectedObjectOneMenuRequestStatusStates;
    }

    public void setSelectedObjectOneMenuRequestStatusStates(DefaultSelectedData selectedObjectOneMenuRequestStatusStates) {
        this.selectedObjectOneMenuRequestStatusStates = selectedObjectOneMenuRequestStatusStates;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public ArrayList<Option> getPowerDeligationStatusList() {
        return powerDeligationStatusList;
    }

    public void setPowerDeligationStatusList(ArrayList<Option> powerDeligationStatusList) {
        this.powerDeligationStatusList = powerDeligationStatusList;
    }

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pnMessage) {
        this.pnMessage = pnMessage;
    }

    public PanelLayout getContainer() {
        return container;
    }

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public void setContainer(PanelLayout pl) {
        this.container = pl;
    }
    private HtmlInputText txtDeligateeId = new HtmlInputText();

    public HtmlInputText getTxtDeligateeId() {
        return txtDeligateeId;
    }

    public void setTxtDeligateeId(HtmlInputText hit) {
        this.txtDeligateeId = hit;
    }
    private HtmlInputText txtDeligateeDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeligateeDepartment() {
        return txtDeligateeDepartment;
    }

    public void setTxtDeligateeDepartment(HtmlInputText hit) {
        this.txtDeligateeDepartment = hit;
    }
    private HtmlInputText txtDeligateeFullName = new HtmlInputText();

    public HtmlInputText getTxtDeligateeFullName() {
        return txtDeligateeFullName;
    }

    public void setTxtDeligateeFullName(HtmlInputText hit) {
        this.txtDeligateeFullName = hit;
    }
    private HtmlInputText txtDeligateePosition = new HtmlInputText();

    public HtmlInputText getTxtDeligateePosition() {
        return txtDeligateePosition;
    }

    public void setTxtDeligateePosition(HtmlInputText hit) {
        this.txtDeligateePosition = hit;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlInputTextarea txtaReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaReason() {
        return txtaReason;
    }

    public void setTxtaReason(HtmlInputTextarea hit) {
        this.txtaReason = hit;
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
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
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
    private HtmlInputText txtRequesterFullName = new HtmlInputText();
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
    private HtmlInputText txtDeligatorFullName = new HtmlInputText();

    public HtmlInputText getTxtDeligatorFullName() {
        return txtDeligatorFullName;
    }

    public void setTxtDeligatorFullName(HtmlInputText hit) {
        this.txtDeligatorFullName = hit;
    }
    private HtmlInputText txtDeligatorPosition = new HtmlInputText();

    public HtmlInputText getTxtDeligatorPosition() {
        return txtDeligatorPosition;
    }

    public void setTxtDeligatorPosition(HtmlInputText hit) {
        this.txtDeligatorPosition = hit;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
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
        return deligatorId;
    }

    public void setDeligatorId(String deligatorId) {
        this.deligatorId = deligatorId;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getChangeOrSearchDeciderButtonLabel() {
        return changeOrSearchDeciderButtonLabel;
    }

    public void setChangeOrSearchDeciderButtonLabel(String changeOrSearchDeciderButtonLabel) {
        this.changeOrSearchDeciderButtonLabel = changeOrSearchDeciderButtonLabel;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequestList() {
        return decisionsMadeOnRequestList;
    }

    public void setDecisionsMadeOnRequestList(ArrayList<RequestHistoryModel> decisionsMadeOnRequestList) {
        this.decisionsMadeOnRequestList = decisionsMadeOnRequestList;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private PanelLayout pnlLayoutButtons = new PanelLayout();

    public PanelLayout getPnlLayoutButtons() {
        return pnlLayoutButtons;
    }

    public void setPnlLayoutButtons(PanelLayout pl) {
        this.pnlLayoutButtons = pl;
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

    public HtmlInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(HtmlInputText txtRequesterFullName) {
        this.txtRequesterFullName = txtRequesterFullName;
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

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private HtmlOutputLabel out_wieght = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_wieght() {
        return out_wieght;
    }

    public void setOut_wieght(HtmlOutputLabel hol) {
        this.out_wieght = hol;
    }
    private HtmlInputText txt_DocRefNumber = new HtmlInputText();

    public HtmlInputText getTxt_DocRefNumber() {
        return txt_DocRefNumber;
    }

    public void setTxt_DocRefNumber(HtmlInputText hit) {
        this.txt_DocRefNumber = hit;
    }


    //</editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PowerDeligationApprovePage() {
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

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

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }


    //<editor-fold defaultstate="collapsed" desc="Populate Clear Text Components">
    private void clearDeligatorTextComponenets() {
        txtDeligatorDepartment.setValue(null);
        txtDeligatorFullName.setValue(null);
        txtDeligatorId.setValue(null);
        txtDeligatorPosition.setValue(null);
    }

    private void clearDeligateeTextComponenets() {
        txtDeligateeDepartment.setValue(null);
        txtDeligateeFullName.setValue(null);
        txtDeligateeId.setValue(null);
        txtDeligateePosition.setValue(null);
    }

    private void clearDeciderTextComponenets() {
        txtDeciderDepartment.setValue(null);
        txtDeciderFullName.setValue(null);
        txtDeciderId.setValue(null);
        txtDeciderPosition.setValue(null);
    }

    private void clearDeligationTextComponenets() {
        txtEndDate.setValue(null);
        txtStartDate.setValue(null);
        txtaReason.setValue(null);
        txtDeligatedPosition.setValue(null);
        txt_DocRefNumber.setValue(null);
    }

    private void clearDefaultSelectedItems() {
        selectedObjectListboxRequestByStatus.setSelectedObject(null);
        selectedObjectRequestsByHistory.setSelectedObject(null);
    }

    private void clearAllComponents() {
        clearDeligateeTextComponenets();
        clearDeligatorTextComponenets();
        clearRequesterTextComponenets();
        clearDeligationTextComponenets();
        clearDefaultSelectedItems();
        clearTable();
        powDelReqId = -1;
    }

    private void clearTable() {
        decisionsMadeOnRequestList = new ArrayList<RequestHistoryModel>();
    }
     public String btnCloseViewBenefitePakage_action() {
        pnlPopupViewBenefitePakage.setRendered(false);
        return null;
    }

    private void populateDeligatorTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                String deligatorDepartment = empInfoHashMap.get("employeeDepartment").toString();
                deligatorId = empInfoHashMap.get("employeeId").toString();
                deligatedPosition = empInfoHashMap.get("employeePosition").toString();
                txtDeligatedPosition.setValue(deligatedPosition);
                txtDeligatorDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtDeligatorFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeligatorId.setValue(empInfoHashMap.get("employeeId"));
                txtDeligatorPosition.setValue(empInfoHashMap.get("employeePosition"));
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void populateDeligationHistory(String requestId) {
        decisionsMadeOnRequestList = approveManager.getRequestHistory(powDelReqId);
    }

    private void populateDeligateeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                delegateeId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                delegateeId = empInfoHashMap.get("employeeId").toString();
                txtDeligateeDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtDeligateeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeligateeId.setValue(empInfoHashMap.get("employeeId"));
                txtDeligateePosition.setValue(empInfoHashMap.get("employeePosition"));
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
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
//</editor-fold >

    public String btnReset_action() {
        clearAllComponents();
        return null;
    }
     private void populateBenefitPakage(int positionID)
    {
    benefitePakage = approveManager.getAllBenefitePakage(positionID);
    }

    private void clearRequesterTextComponenets() {
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterId.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void populateDeligationTextComponents(int requestId) {
        PowerDeligationRequestModel deligationRequestModel = requestManager.getPowerDeligationDetail(requestId);
        if (deligationRequestModel != null) {
            if (deligationRequestModel.getPowDelReqId() == -1) {//if no resultset found
                powDelReqId = -1;
                showSuccessOrFailureMessage(false, "NO REQUEST FOUND WITH ID : " + requestId);
            } else {
                txtStartDate.setValue(deligationRequestModel.getStartDate());
                txtEndDate.setValue(deligationRequestModel.getEndDate());
                txtaReason.setValue(deligationRequestModel.getDeligationReason());
                out_wieght.setValue(deligationRequestModel.getDelegationWieght());
                txt_DocRefNumber.setValue(deligationRequestModel.getDocRefeNumber());
            // txtDeligatedPosition.setValue(deligationRequestModel.getDeligatedPosition());
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void populateRequesterTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                requesterId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(employeeId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                delegatedPosition=Integer.parseInt(empInfoHashMap.get("employeeJobCode").toString());
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

      public boolean checkeEmpRank(String requesterID) {

        return requestManager.checkEmpRank(requesterID);
    }

    public void selectAllRequestListsByStatus_processValueChange(ValueChangeEvent vce) {
        int dateDifference = 0;
        
     //   if ((dateDifference > 15) && (requestManager.getDelegatorRank(requesterId)) == 14) {//for employee who is autorized to delegate for more than 15 days
//            showSuccessOrFailureMessage(false, "DELEGATOR IS NOT ALLOWED TO REQUEST FOR MORE THAN 15 DAYS");

        clearAllComponents();
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        powDelReqId = Integer.parseInt(requestAttributes[0]);
        deligatorId = requestAttributes[1];
        delegateeId = requestAttributes[2];
        requesterId = requestAttributes[3];
        deligationStatus = requestAttributes[4];
        newDepartmentName=requestAttributes[5];
        newDepartmentPosition=requestAttributes[6];
        startDate=requestAttributes[7];
        endDate=requestAttributes[8];
      
        dateDifference = StringDateManipulation.compareDateDifference(startDate, endDate);
        if((requestManager.getDelegatorRank(loggedInEmployeeId)<=7))
          {
          showSuccessOrFailureMessage(false, "YOU DON'T HAVE PRIVILAGET TO APPROVE DELEGATION");
        }
//        else if ((dateDifference > 15) && (requestManager.getDelegatorRank(loggedInEmployeeId)) == 14) {
//
//         showSuccessOrFailureMessage(false, "YOU DON'T HAVE PRIVILAGET TO APPROVE MORE THAN 15 DAY DELEGATION");
//        }
        else{

//        if (deligatorId.equalsIgnoreCase("null"))
//        {
            populateDeligateeTextComponents(delegateeId);
            populateRequesterTextComponents(requesterId);
            populateDeligationTextComponents(powDelReqId);
            txtDeligatorDepartment.setValue(newDepartmentName);
            txtDeligatorPosition.setValue(newDepartmentPosition);
            txtDeligatedPosition.setValue(newDepartmentPosition);
            btnPostDecision.setDisabled(false);
            
            availableDecisionsToMakeList = approveManager.getAvailableDecisionsToMake(deligationStatus);

//        }
      //  else{
        
        populateDeligateeTextComponents(delegateeId);
        populateDeligatorTextComponents(deligatorId);
        populateRequesterTextComponents(requesterId);
        populateDeligationTextComponents(powDelReqId);
        btnPostDecision.setDisabled(false);
        availableDecisionsToMakeList = approveManager.getAvailableDecisionsToMake(deligationStatus);
    //}
    }
    }

    public boolean isDecisionPossible(String deligationStatus) {
        if (deligationStatus.startsWith("-") || deligationStatus.startsWith("#") || deligationStatus.equals(PowerDeligationApproveManager.FINAL_STATE_POWER_DELIGATION)) {
            return true;
        } else {
            return false;
        }
    }

    public void selectRequestListsByDeligatorAndDeligatee_processValueChange(ValueChangeEvent vce) {
        clearAllComponents();
        String[] requestInfos = vce.getNewValue().toString().split("--");
        powDelReqId = Integer.parseInt(requestInfos[0]);
        deligationStatus = requestInfos[1];
        deligatorId = requestInfos[2];
        delegateeId = requestInfos[3];
        startDate = requestInfos[4];
        endDate = requestInfos[5];
        deligationReason = requestInfos[6];

        populateDeligateeTextComponents(delegateeId);
        populateDeligatorTextComponents(deligatorId);
        populateApproverTextComponents(loggedInEmployeeId);
        // populateDeligationHistory(Integer.toString(powDelReqId));
        availableDecisionsToMakeList = approveManager.getAvailableDecisionsToMake(deligationStatus);

        if (deligationStatus.startsWith("Rej") || deligationStatus.startsWith("Res") || deligationStatus.equals(PowerDeligationApproveManager.FINAL_STATE_POWER_DELIGATION)) {
            drlDecision.setDisabled(true);
            btnPostDecision.setDisabled(true);
        } else {
            drlDecision.setDisabled(false);
            btnPostDecision.setDisabled(false);
        }
        txtStartDate.setValue(startDate);
        txtEndDate.setValue(endDate);
        txtaReason.setValue(deligationReason);
    }
    String delegatorDept_id, delegateeDept_id;
    EmployeeEntityOld employeeEntity = new EmployeeEntityOld();

    public void getDelgatorDept() {
        HashMap hm = new HashMap();
        try {
            hm = employeeEntity.readEmployeeBasicInfoFromId(txtDeligatorId.getValue().toString());
            delegatorDept_id = hm.get("employeeDepartment").toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getDelgateeDept() {
        HashMap hm = new HashMap();
        try {
            hm = employeeEntity.readEmployeeBasicInfoFromId(txtDeligateeId.getValue().toString());
            delegateeDept_id = hm.get("employeeDepartment").toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkRole() {
        return requestManager.chechRole(getSessionBean1().getUserName());
    }

    private boolean savePowerDeligationDecision() {
        if (powDelReqId != -1) {
            String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
            if (txtDeciderId.getValue() != null) {
                approverId = txtDeciderId.getValue().toString();
            } else {
                approverId = "";
            }

            if (checkRole()) {
                return approveManager.savePowerDeligationDecision(powDelReqId, approverId, drlDecision.getValue().toString(), userName, toDay, comment, deligationStatus, false);
            } else {
                return approveManager.savePowerDeligationDecision(powDelReqId, approverId, drlDecision.getValue().toString(), userName, toDay, comment, deligationStatus, true);
            }

        }

        return false;
    }

//    public String btnSearchDeligationInfo_action() {
//        requestsListByDeligatorAndDeligatee = null;
//        if (txtSearchDeligateeId.getValue() == null && txtSearchDeligatorId.getValue() == null) {
//            showSuccessOrFailureMessage(false, "ENTER DELIGATOR OR DELIGATE");
//        } else {
//            String deligator = txtSearchDeligatorId.getValue() == null ? "" : txtSearchDeligatorId.getValue().toString();
//            String deligatee = txtSearchDeligateeId.getValue() == null ? "" : txtSearchDeligateeId.getValue().toString();
//            requestsListByDeligatorAndDeligatee = requestManager.getPowerDeligationInformation(deligator, deligatee);
//        }
//        //return null means stay on the same page
//        return null;
//    }
    public boolean validateDecision() {
        if (drlDecision.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(PowerDeligationApproveManager.POWER_DELIGATION_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(PowerDeligationApproveManager.POWER_DELIGATION_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            if (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals("")) {
                showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
                return false;
            }
        }
        return true;
    }

    public String btnPostDecision_action() {

        if (validateDecision())
        {
            if (savePowerDeligationDecision()) {
                btnPostDecision.setDisabled(true);
                clearAllComponents();
                if (true) {
                    approvableRequests = approveManager.getApprovableRequests(true);
                } else {
                    approvableRequests = approveManager.getApprovableRequests(false);
                }

                requestHistoryLists = approveManager.getAllMyPrevieousDecisions();
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        return null;
    }

    public void drlDecision_processValueChange(ValueChangeEvent vce) {
        // clearAllComponents();
    }

    public String btnSearchDecider_action() {
        if (changeOrSearchDeciderButtonLabel.equalsIgnoreCase("Change")) {
            clearDeciderTextComponenets();
            txtDeciderId.setDisabled(false);
            changeOrSearchDeciderButtonLabel = "Search";
        } else {//if (changeOrSearchDeciderButtonLabel.equalsIgnoreCase("Search"))
            populateApproverTextComponents(txtDeciderId.getValue().toString());
            txtDeciderId.setDisabled(true);
            changeOrSearchDeciderButtonLabel = "Change";
        }
        return null;
    }

    public String lnkPowerDeligationRequest_action() {
        return "PowerDeligationRequest";
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

    public String getDelegateeId() {
        return delegateeId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public ArrayList<Option> getApprovableRequests() {
        return approvableRequests;
    }

    public void setApprovableRequests(ArrayList<Option> approvableRequests) {
        this.approvableRequests = approvableRequests;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public void selectRequestHistoryLists_processValueChange(ValueChangeEvent vce) {
        clearAllComponents();
        String[] requestAttributes = vce.getNewValue().toString().split("--");
        powDelReqId = Integer.parseInt(requestAttributes[0]);
        deligatorId = requestAttributes[1];
        delegateeId = requestAttributes[2];
        requesterId = requestAttributes[3];
        deligationStatus = requestAttributes[4];
        newDepartmentName=requestAttributes[5];
        newDepartmentPosition=requestAttributes[6];

        if(deligatorId.equalsIgnoreCase("null"))
           {
         populateDeligateeTextComponents(delegateeId);
         populateRequesterTextComponents(requesterId);
         populateDeligationTextComponents(powDelReqId);
         txtDeligatorDepartment.setValue(newDepartmentName);
         txtDeligatorPosition.setValue(newDepartmentPosition);
         txtDeligatedPosition.setValue(newDepartmentPosition);
         btnPostDecision.setDisabled(true);

        }
        else{
        populateDeligateeTextComponents(delegateeId);
        populateDeligatorTextComponents(deligatorId);
        populateRequesterTextComponents(requesterId);
        populateDeligationTextComponents(powDelReqId);
        if (false) {
            //render fileeeeeeeeeeeeeeeeeeeeeeeee
        }
        btnPostDecision.setDisabled(true);
        }
    }

    private void populateDecisionHistory(int requestId) {
        decisionsMadeOnRequestList = approveManager.getRequestHistory(requestId);
        if (decisionsMadeOnRequestList != null) {
            if (decisionsMadeOnRequestList.size() > 0) {
                lnkViewPrevieousDecisions.setRendered(true);
            } else {
                lnkViewPrevieousDecisions.setRendered(false);
            }
        }
    }

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(powDelReqId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public String lnkViewBenefitePackage_action() {
        //return null means stay on the same page
        populateBenefitPakage(delegatedPosition);
        pnlPopupViewBenefitePakage.setRendered(true);
        return null;
    }
}
