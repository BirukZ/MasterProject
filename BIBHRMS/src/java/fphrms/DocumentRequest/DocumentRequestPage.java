/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.DocumentRequest;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
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
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.context.FacesContext;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.documentRequestManager.DocumentApproveManager;
import manager.documentRequestManager.DocumentRequestManager;
import manager.documentRequestManager.DocumentRequestManager.DocumentRequestModel;
import manager.employeeManager.EmployeeManage;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DocumentRequestPage extends AbstractPageBean {

    DocumentRequestManager documentRequestManager = new DocumentRequestManager();
    EmployeeManage employeeManager = new EmployeeManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Option> documentCatagories = documentRequestManager.getDocumentCatagories();
    ArrayList<Option> myPendingDocumentRequests = new ArrayList<Option>();
    ArrayList<Option> myDocumentRequestsHistory = new ArrayList<Option>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    private DefaultSelectedData selectedRequestFromMyRequest = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromMyHistory = new DefaultSelectedData();
    DocumentApproveManager documentApproveManager = new DocumentApproveManager();
    String newOrSaveOrUpdateLabel = "Save";
    String loggedInEmployeeId;
    int documentRequestId;//   DOCUMENT_REQUEST_ID
    String requesterId;//REQUESTER_ID
    String documentCatagory;//DOCUMENT_CATAGORY
    String description;//DESCRIPTION
    String reason;//REASON
    String appliedDate;//APPLIED_DATE
    String issueDate;//ISSUE_DATE
    String docReferenceNumber;//DOC_REFERENCE_NUMBER
    String status;//STATUS
    String userName;//USER_NAME
    String timeStamp;//TIME_STAMP
    String reqType = null;
    String reqOrgId = null;//Id of external organization requesting document
    String reqOrgName = null;//Name of external organization requesting document
    String reqOrgDept = null;//Department of external organization requesting document
    String reqOrgAddress = null;//Address of external organization requesting document
    String reqOrgLetterNo = null;//Address of external organization requesting document
    String reqOrgLetterDate = null;//Address of external organization requesting document

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userName = getSessionBean1().getUserName();
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        documentRequestManager.setUserName(userName);
        documentRequestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        myPendingDocumentRequests = documentRequestManager.geMyPendingDocumentRequests();
        myDocumentRequestsHistory = documentRequestManager.geMyDocumentRequestHistory();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private PanelLayout pnProfile = new PanelLayout();

    public PanelLayout getPnProfile() {
        return pnProfile;
    }

    public ArrayList<Option> getMyDocumentRequestsHistory() {
        return myDocumentRequestsHistory;
    }

    public void setMyDocumentRequestsHistory(ArrayList<Option> myDocumentRequestsHistory) {
        this.myDocumentRequestsHistory = myDocumentRequestsHistory;
    }

    public void setPnProfile(PanelLayout pl) {
        this.pnProfile = pl;
    }
    private HtmlPanelGroup pnlGrpPowerDeligationContent = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlGrpPowerDeligationContent() {
        return pnlGrpPowerDeligationContent;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DocumentApproveManager getDocumentApproveManager() {
        return documentApproveManager;
    }

    public void setDocumentApproveManager(DocumentApproveManager documentApproveManager) {
        this.documentApproveManager = documentApproveManager;
    }

    public ArrayList<Option> getMyPendingDocumentRequests() {
        return myPendingDocumentRequests;
    }

    public void setMyPendingDocumentRequests(ArrayList<Option> myPendingDocumentRequests) {
        this.myPendingDocumentRequests = myPendingDocumentRequests;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocReferenceNumber() {
        return docReferenceNumber;
    }

    public void setDocReferenceNumber(String docReferenceNumber) {
        this.docReferenceNumber = docReferenceNumber;
    }

    public String getDocumentCatagory() {
        return documentCatagory;
    }

    public void setDocumentCatagory(String documentCatagory) {
        this.documentCatagory = documentCatagory;
    }

    public int getDocumentRequestId() {
        return documentRequestId;
    }

    public void setDocumentRequestId(int documentRequestId) {
        this.documentRequestId = documentRequestId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getNewOrSaveOrUpdateLabel() {
        return newOrSaveOrUpdateLabel;
    }

    public void setNewOrSaveOrUpdateLabel(String newOrSaveOrUpdateLabel) {
        this.newOrSaveOrUpdateLabel = newOrSaveOrUpdateLabel;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DefaultSelectedData getSelectedRequestFromMyRequest() {
        return selectedRequestFromMyRequest;
    }

    public DefaultSelectedData getSelectedRequestFromMyHistory() {
        return selectedRequestFromMyHistory;
    }

    public void setSelectedRequestFromMyHistory(DefaultSelectedData selectedRequestFromMyHistory) {
        this.selectedRequestFromMyHistory = selectedRequestFromMyHistory;
    }

    public void setSelectedRequestFromMyRequest(DefaultSelectedData selectedRequestFromMyRequest) {
        this.selectedRequestFromMyRequest = selectedRequestFromMyRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Option> getDocumentCatagories() {
        return documentCatagories;
    }

    public void setDocumentCatagories(ArrayList<Option> documentCatagories) {
        this.documentCatagories = documentCatagories;
    }

    public DocumentRequestManager getDocumentRequestManager() {
        return documentRequestManager;
    }

    public void setDocumentRequestManager(DocumentRequestManager documentRequestManager) {
        this.documentRequestManager = documentRequestManager;
    }

    public void setPnlGrpPowerDeligationContent(HtmlPanelGroup hpg) {
        this.pnlGrpPowerDeligationContent = hpg;
    }
    private HtmlInputText txtSearchById1 = new HtmlInputText();

    public HtmlInputText getTxtSearchById1() {
        return txtSearchById1;
    }

    public void setTxtSearchById1(HtmlInputText hit) {
        this.txtSearchById1 = hit;
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
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText txtRequesterFullName) {
        this.txtRequesterFullName = txtRequesterFullName;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
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

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData selectOneMenu1Bean) {
        this.selectOneMenu1Bean = selectOneMenu1Bean;
    }
    private HtmlCommandButton btnSaveOrUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveOrUpdate() {
        return btnSaveOrUpdate;
    }

    public void setBtnSaveOrUpdate(HtmlCommandButton hcb) {
        this.btnSaveOrUpdate = hcb;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlInputText txtIsueeDate = new HtmlInputText();

    public HtmlInputText getTxtIsueeDate() {
        return txtIsueeDate;
    }

    public void setTxtIsueeDate(HtmlInputText hit) {
        this.txtIsueeDate = hit;
    }
    private HtmlInputTextarea txtaReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaReason() {
        return txtaReason;
    }

    public void setTxtaReason(HtmlInputTextarea hit) {
        this.txtaReason = hit;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate sid) {
        this.calAppliedDate = sid;
    }
    private SelectInputDate calIsueeDate = new SelectInputDate();

    public SelectInputDate getCalIsueeDate() {
        return calIsueeDate;
    }

    public void setCalIsueeDate(SelectInputDate sid) {
        this.calIsueeDate = sid;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private HtmlSelectOneMenu drlDocumentCatagory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDocumentCatagory() {
        return drlDocumentCatagory;
    }

    public void setDrlDocumentCatagory(HtmlSelectOneMenu hsom) {
        this.drlDocumentCatagory = hsom;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private PanelPopup popupConfirmDelete = new PanelPopup();

    public PanelPopup getPopupConfirmDelete() {
        return popupConfirmDelete;
    }

    public void setPopupConfirmDelete(PanelPopup pp) {
        this.popupConfirmDelete = pp;
    }
    private HtmlInputText itxtNo = new HtmlInputText();

    public HtmlInputText getItxtNo() {
        return itxtNo;
    }

    public void setItxtNo(HtmlInputText hit) {
        this.itxtNo = hit;
    }
    private HtmlInputText itxtOrgName = new HtmlInputText();

    public HtmlInputText getItxtOrgName() {
        return itxtOrgName;
    }

    public void setItxtOrgName(HtmlInputText hit) {
        this.itxtOrgName = hit;
    }
    private HtmlInputText itxtPageNo = new HtmlInputText();

    public HtmlInputText getItxtPageNo() {
        return itxtPageNo;
    }

    public void setItxtPageNo(HtmlInputText hit) {
        this.itxtPageNo = hit;
    }
    private PanelPopup popupExtOrganization = new PanelPopup();

    public PanelPopup getPopupExtOrganization() {
        return popupExtOrganization;
    }

    public void setPopupExtOrganization(PanelPopup pp) {
        this.popupExtOrganization = pp;
    }
    private HtmlInputTextarea itxtaPurpose = new HtmlInputTextarea();

    public HtmlInputTextarea getItxtaPurpose() {
        return itxtaPurpose;
    }

    public void setItxtaPurpose(HtmlInputTextarea hit) {
        this.itxtaPurpose = hit;
    }
    private HtmlInputText itxtLetterNo = new HtmlInputText();

    public HtmlInputText getItxtLetterNo() {
        return itxtLetterNo;
    }

    public void setItxtLetterNo(HtmlInputText hit) {
        this.itxtLetterNo = hit;
    }
    private HtmlInputText itxtLetterDate = new HtmlInputText();

    public HtmlInputText getItxtLetterDate() {
        return itxtLetterDate;
    }

    public void setItxtLetterDate(HtmlInputText hit) {
        this.itxtLetterDate = hit;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="......">
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DocumentRequestPage() {
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
    // </editor-fold >

    public void drlDecision_processValueChange(ValueChangeEvent vce) {
    }

    public String btnPostDecision_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtRequesterFullName_action() {
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        txtRequesterId.setValue(requesterId);
        txtRequesterId.setValue(requesterId);
        makePageReadyForSave();
        return null;
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(empInfoHashMap.get("employeeId"));
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            // showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void clearRequesterTextComponents() {
        requesterId = null;
        documentRequestId = -1;
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void clearRequestComponents() {
        drlDocumentCatagory.resetValue();
        txtAppliedDate.setValue(dateFormat.format(new Date()));
        txtIsueeDate.setValue(null);
        txtDocReferenceNumber.setValue(null);
        txtaDescription.setValue(null);
        txtaReason.setValue(null);
        calAppliedDate.resetValue();
        calIsueeDate.resetValue();
    }

    private void populateRequestComponents(int documentRequestId) {
        DocumentRequestModel requestModel = documentRequestManager.getDocumentRequest(documentRequestId);
        if (requestModel != null) {
            if (requestModel.getDocumentRequestId() == -1) {//if no resultset found
                documentRequestId = -1;
                showSuccessOrFailureMessage(false, "NO DATA FOUND FOUND WITH ID : " + documentRequestId);
            } else {
                txtAppliedDate.setValue(requestModel.getAppliedDate());
                txtIsueeDate.setValue(requestModel.getIssueDate());
                drlDocumentCatagory.setValue(requestModel.getDocumentCatagory());
                txtaDescription.setValue(requestModel.getDescription());
                txtaReason.setValue(requestModel.getReason());
                txtDocReferenceNumber.setValue(requestModel.getDocReferenceNumber());
                reqType = requestModel.getReq_type();
                itxtNo.setValue(requestModel.getReqOrgId());
                itxtOrgName.setValue(requestModel.getReqOrgName());
                itxtPageNo.setValue(requestModel.getReqOrgDept());
                itxtaPurpose.setValue(requestModel.getReqOrgAddress());
                itxtLetterNo.setValue(requestModel.getReqOrgLetterNo());
                itxtLetterDate.setValue(requestModel.getReqOrgLetterDate());
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    public void selectPendingRequestLists_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        documentRequestId = Integer.parseInt(requestInfos[0]);//
        requesterId = requestInfos[1];
        status = requestInfos[2];
        populateRequesterTextComponents(requesterId);
        populateRequestComponents(documentRequestId);
        makePageReadyForUpdate();
    }

    private void clearAllComponents() {
        clearRequesterTextComponents();
        clearRequestComponents();
    }

    private void makePageReadyForSave() {
        newOrSaveOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(false);
        btnDelete.setDisabled(true);
        lnkViewPrevieousDecisions.setRendered(false);
    }

    private void makePageReadyForUpdate() {
        newOrSaveOrUpdateLabel = "Update";
        btnSaveOrUpdate.setDisabled(false);
        btnDelete.setDisabled(false);
        lnkViewPrevieousDecisions.setRendered(false);
    }

    private void makePageReadyForView() {
        newOrSaveOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        lnkViewPrevieousDecisions.setRendered(true);
    }

    public String btnRequesterIdSearch_action() {
        if (txtRequesterId.getValue() != null) {
            requesterId = txtRequesterId.getValue().toString();
            makePageReadyForSave();
            populateRequesterTextComponents(requesterId);
            clearRequestComponents();
        } else {
            clearAllComponents();
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
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

    private boolean initializeAttributes() {
        try {
            documentCatagory = drlDocumentCatagory.getValue().toString();
            description = txtaDescription.getValue().toString();
            reason = txtaReason.getValue().toString();
            appliedDate = txtAppliedDate.getValue().toString();
            issueDate = txtIsueeDate.getValue().toString();
            docReferenceNumber = txtDocReferenceNumber.getValue().toString();
            if (itxtNo.getValue() != null) {
                reqOrgId = itxtNo.getValue().toString();
            }
            if (itxtOrgName.getValue() != null) {
                reqOrgName = itxtOrgName.getValue().toString();
            }
            if (itxtPageNo.getValue() != null) {
                reqOrgDept = itxtPageNo.getValue().toString();
            }
            if (itxtaPurpose.getValue() != null) {
                reqOrgAddress = itxtaPurpose.getValue().toString();
            }
            if(itxtLetterNo.getValue() != null) {
                reqOrgLetterNo = itxtLetterNo.getValue().toString();
            }
            if(itxtLetterDate.getValue() != null){
                reqOrgLetterDate = itxtLetterDate.getValue().toString();
            }
            reqType = "0";
            return true;
        } catch (Exception ex) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
        }
    }

    private boolean saveDocumentRequest() {
        if (initializeAttributes()) {
            if (documentRequestManager.saveTerminationRequestInformation(requesterId,
                    documentCatagory, description, reason, appliedDate,
                    issueDate, docReferenceNumber, reqType, reqOrgId, reqOrgName,
                    reqOrgDept, reqOrgAddress, reqOrgLetterNo, reqOrgLetterDate)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    private boolean updateDocumentRequest() {
        initializeAttributes();
        if (documentRequestManager.updateTerminationRequestInformation(documentRequestId,
                requesterId, documentCatagory, description, reason, appliedDate,
                issueDate, docReferenceNumber, "1", reqOrgId, reqOrgName,
                reqOrgDept, reqOrgAddress, reqOrgLetterNo, reqOrgLetterDate)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateDocumentRequest() {
        if (newOrSaveOrUpdateLabel.equals("Save") && requesterId == null) {
            showSuccessOrFailureMessage(false, "SELECT EMPLOYEE FIRST");
        } else if (txtAppliedDate.getValue().toString() == null || txtAppliedDate.getValue().toString() == null) {
            showSuccessOrFailureMessage(false, "SELECT EMPLOYEE FIRST");
        } else if (calAppliedDate.getValue().toString() == null || calAppliedDate.getValue().toString() == null) {
        }
        return true;
    }

    public String btnSaveOrUpdate_action() {
        if (validateDocumentRequest()) {
            if (newOrSaveOrUpdateLabel.equals("Save")) {

                String docType = "0";
                String docReturn = "0";
                String selectedDocType = null;
                String empId = null;


                if (txtRequesterId.getValue() != null) {
                    empId = txtRequesterId.getValue().toString();
                }
                if(drlDocumentCatagory.getValue() != null){
                    selectedDocType = drlDocumentCatagory.getValue().toString();
                }
                String result = documentRequestManager.geEmpDocumentRequestHistory(empId);
                if (result != null) {
                    docType = result.substring(0, result.indexOf("/"));
                    docReturn = result.substring(result.indexOf("/") + 1);
                }
                if (selectedDocType.equals("3") && docType.equalsIgnoreCase("3") && !docReturn.equals("1")) {
                    showSuccessOrFailureMessage(false, "SAVING FAILED! GUARANTEE DOCUMENT ALREADY REQUESTED");
                } else {
                    if (saveDocumentRequest()) {
                        showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                        myPendingDocumentRequests =
                                documentRequestManager.geMyPendingDocumentRequests();
                        clearAllComponents();
                        makePageReadyForSave();

                    } else {
                        showSuccessOrFailureMessage(false, "SAVING FAILED! ERROR OCCURED");
                    }
                }

            } else if (newOrSaveOrUpdateLabel.equals("Update")) {
                if (updateDocumentRequest()) {
                    showSuccessOrFailureMessage(true, "UPDATE SUCCESSFUL");
                    clearAllComponents();

                    makePageReadyForSave();

                } else {
                    showSuccessOrFailureMessage(false, "UPDATE FAILED! ERROR OCCURED");
                }

            }
        }
        return null;
    }

    public String btnReset_action() {
        clearAllComponents();
        selectedRequestFromMyRequest.setSelectedObject(null);
        return null;
    }

    public String btnAppliedDate_action() {
        calAppliedDate.setRendered(true);
        return null;
    }

    public String btnIsueeDate_action() {
        calIsueeDate.setRendered(true);
        return null;
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtAppliedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    public void calIsueeDate_processValueChange(ValueChangeEvent vce) {
        txtIsueeDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calIsueeDate.setRendered(false);
    }

    public String lnkViewPrevieousDecisions_action() {
        decisionsMadeOnRequest = documentApproveManager.getRequestHistory(documentRequestId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public String btnDelete_action() {
        popupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public void selectRequestHistory_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        documentRequestId =
                Integer.parseInt(requestInfos[0]);//
        requesterId =
                requestInfos[1];
        status =
                requestInfos[2];
        populateRequesterTextComponents(requesterId);
        populateRequestComponents(documentRequestId);
        makePageReadyForView();

    }

    public String btnPoppupDeleteAgree_action() {
        popupConfirmDelete.setRendered(false);
        if (documentRequestManager.deleteDocumentrequest(documentRequestId)) {
            myPendingDocumentRequests = documentRequestManager.geMyPendingDocumentRequests();
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFUL");
        } else {
            showSuccessOrFailureMessage(false, "DELETE FAILED");
        }

        return null;
    }

    public String btnPoppupDeleteCancel_action() {
        popupConfirmDelete.setRendered(false);
        return null;
    }

    public String lnkDocumentApproval_action() {
        return "DocumentApprove";
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btnUpdateChenge_action() {
        //return null means stay on the same page
        this.popupExtOrganization.setRendered(false);
        return null;
    }

    public String clnkExtOrg_action() {
        //return null means stay on the same page
        this.popupExtOrganization.setRendered(true);
        this.reqType = "1";
        return null;
    }

    public String btnCancel_action() {
        //return null means stay on the same page
        this.popupExtOrganization.setRendered(false);
        this.reqType = "0";
        return null;
    }
}
