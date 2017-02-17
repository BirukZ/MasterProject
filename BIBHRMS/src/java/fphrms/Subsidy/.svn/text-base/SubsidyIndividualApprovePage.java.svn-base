/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Subsidy;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.SubsidyManager.SubsidyIndividualApproveManager;
import manager.SubsidyManager.SubsidyIndividualRequestManager;
import manager.SubsidyManager.SubsidyIndividualRequestManager.SubSidiyRequestModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class SubsidyIndividualApprovePage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
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
        subsidyIndividualApproveManager.setUserName(userName);
        subsidyIndividualRequestManager.setUserName(userName);
        requestListsToBeApproved = subsidyIndividualApproveManager.getRequestsToBeProcessed();
        requestHistoryLists = subsidyIndividualApproveManager.getMyTerminationDecisionHistory();
    // availableDecisionsToMakeList = subsidyIndividualApproveManager.getAvailableDecisionsToMake(requestStatus);
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private HtmlInputText txtTerminationCatagory = new HtmlInputText();

    public HtmlInputText getTxtTerminationCatagory() {
        return txtTerminationCatagory;
    }

    public void setTxtTerminationCatagory(HtmlInputText hit) {
        this.txtTerminationCatagory = hit;
    }
    private HtmlInputText txtTerminationType = new HtmlInputText();

    public HtmlInputText getTxtTerminationType() {
        return txtTerminationType;
    }

    public void setTxtTerminationType(HtmlInputText hit) {
        this.txtTerminationType = hit;
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
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlInputText txtRequesterRecruitmentDate = new HtmlInputText();

    public HtmlInputText getTxtRequesterRecruitmentDate() {
        return txtRequesterRecruitmentDate;
    }

    public void setTxtRequesterRecruitmentDate(HtmlInputText hit) {
        this.txtRequesterRecruitmentDate = hit;
    }
    private HtmlInputText txtRequesterServiceYear = new HtmlInputText();

    public HtmlInputText getTxtRequesterServiceYear() {
        return txtRequesterServiceYear;
    }

    public void setTxtRequesterServiceYear(HtmlInputText hit) {
        this.txtRequesterServiceYear = hit;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlInputText txtRequesterGender = new HtmlInputText();

    public HtmlInputText getTxtRequesterGender() {
        return txtRequesterGender;
    }

    public void setTxtRequesterGender(HtmlInputText hit) {
        this.txtRequesterGender = hit;
    }
    private PanelLayout pnlLayoutSearchByName = new PanelLayout();

    public PanelLayout getPnlLayoutSearchByName() {
        return pnlLayoutSearchByName;
    }

    public void setPnlLayoutSearchByName(PanelLayout pl) {
        this.pnlLayoutSearchByName = pl;
    }
    private PanelLayout pnlLayoutSearchById = new PanelLayout();

    public PanelLayout getPnlLayoutSearchById() {
        return pnlLayoutSearchById;
    }

    public void setPnlLayoutSearchById(PanelLayout pl) {
        this.pnlLayoutSearchById = pl;
    }
    private HtmlSelectOneListbox selectRequestApprovableRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectRequestApprovableRequestLists() {
        return selectRequestApprovableRequestLists;
    }

    public void setSelectRequestApprovableRequestLists(HtmlSelectOneListbox hsol) {
        this.selectRequestApprovableRequestLists = hsol;
    }

    public DefaultSelectedData getSelectObjectOfTerminationCatagory() {
        return selectObjectOfTerminationCatagory;
    }

    public void setSelectObjectOfTerminationCatagory(DefaultSelectedData selectObjectOfTerminationCatagory) {
        this.selectObjectOfTerminationCatagory = selectObjectOfTerminationCatagory;
    }
    private HtmlInputText txtRequesterFullName1 = new HtmlInputText();

    public HtmlInputText getTxtRequesterFullName1() {
        return txtRequesterFullName1;
    }

    public void setTxtRequesterFullName1(HtmlInputText hit) {
        this.txtRequesterFullName1 = hit;
    }
    private HtmlInputText txtRequesterDepartment1 = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment1() {
        return txtRequesterDepartment1;
    }

    public void setTxtRequesterDepartment1(HtmlInputText hit) {
        this.txtRequesterDepartment1 = hit;
    }
    private HtmlInputText txtRequesterPosition1 = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition1() {
        return txtRequesterPosition1;
    }

    public void setTxtRequesterPosition1(HtmlInputText hit) {
        this.txtRequesterPosition1 = hit;
    }
    private HtmlInputText txtRequesterId1 = new HtmlInputText();

    public HtmlInputText getTxtRequesterId1() {
        return txtRequesterId1;
    }

    public void setTxtRequesterId1(HtmlInputText hit) {
        this.txtRequesterId1 = hit;
    }
    private HtmlInputText txtTotalAmount = new HtmlInputText();

    public HtmlInputText getTxtTotalAmount() {
        return txtTotalAmount;
    }

    public void setTxtTotalAmount(HtmlInputText hit) {
        this.txtTotalAmount = hit;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlInputText txtdocumnet = new HtmlInputText();

    public HtmlInputText getTxtdocumnet() {
        return txtdocumnet;
    }

    public void setTxtdocumnet(HtmlInputText hit) {
        this.txtdocumnet = hit;
    }
    private HtmlSelectOneMenu drlLocation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLocation() {
        return drlLocation;
    }

    public void setDrlLocation(HtmlSelectOneMenu hsom) {
        this.drlLocation = hsom;
    }
    private HtmlInputText txtMonth = new HtmlInputText();

    public HtmlInputText getTxtMonth() {
        return txtMonth;
    }

    public void setTxtMonth(HtmlInputText hit) {
        this.txtMonth = hit;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists = hsol;
    }


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SubsidyIndividualApprovePage() {
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
    @Override
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
    @Override
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
    // </editor-fold>
    /////////////////////////////////////////////////////////////////////////////////
    SubsidyIndividualApproveManager subsidyIndividualApproveManager = new SubsidyIndividualApproveManager();
    SubsidyIndividualRequestManager subsidyIndividualRequestManager = new SubsidyIndividualRequestManager();
    SubSidiyRequestModel subSidiyRequestModel = new SubSidiyRequestModel();
    EmployeeManage employeeManager = new EmployeeManage();
    ArrayList<SelectItem> requestListByEmployee = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryLists = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestListsToBeApproved = new ArrayList<SelectItem>();
    ArrayList<Option> terminationCatagories = new ArrayList<Option>();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    private DefaultSelectedData selectedRequestByEmployee = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromApprovableList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfTerminationCatagory = new DefaultSelectedData();
    String loggedInEmployeeId;
    String loggedInEmployeeDept;
    String userName;
    String changeOrSearchDeciderButtonLabel = "Change";
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private int subSidyId;//@Column(name = "TERMINATION_REQUEST_ID")
    private String requesterId;// @Column(name = "REQUESTER_ID")
    private String requestStatus;// @Column(name = "REQUEST_STATUS")
    private String appliedDate;//@Column(name = "APPLIED_DATE")
    private String description;// @Column(name = "DESCRIPTION")
    Date selectedTerminationDate;
    Date selectedAppliedDate;
    double penalityPay;
    String hasSuccesioser;
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    private void disableButtons() {
        btnPostDecision.setDisabled(true);

    }

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
                txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
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

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(SubsidyIndividualApproveManager.SUBSIDY_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(SubsidyIndividualApproveManager.SUBSIDY_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (subSidyId == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE TERMINATION TO DECIDE");
            return false;
        }
        return true;
    }

    public String btnPostDecision_action() {
        if (validateDecision()) {
            if (saveTerminationDecision()) {
                clearAllComponents();
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                requestListsToBeApproved = subsidyIndividualApproveManager.getRequestsToBeProcessed();
                requestHistoryLists = subsidyIndividualApproveManager.getMyTerminationDecisionHistory();
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        return null;
    }

    public boolean saveTerminationDecision() {
        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
        return subsidyIndividualApproveManager.saveTerminationDecisionint(subSidyId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);

    }

    public void selectRequestListsByRequester_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        subSidyId = Integer.parseInt(requestInfos[0]);
        requesterId = requestInfos[1];
        requestStatus = requestInfos[2];
        appliedDate = requestInfos[3];

        populateRequesterTextComponents(requesterId);
        availableDecisionsToMakeList = subsidyIndividualApproveManager.getAvailableDecisionsToMake(requestStatus);
        decisionsMadeOnRequest = subsidyIndividualApproveManager.getRequestHistory(subSidyId);



    }

    public void selectedRequestFromApprovableList_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            clearAllComponents();
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            subSidyId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            appliedDate = requestAttributes[2];
            requestStatus = requestAttributes[3];
            populateTerminationRequestComponents(subSidyId);
            populateRequesterTextComponents(requesterId);
            availableDecisionsToMakeList = subsidyIndividualApproveManager.getAvailableDecisionsToMake(requestStatus);
            decisionsMadeOnRequest = subsidyIndividualApproveManager.getRequestHistory(subSidyId);

        }
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            clearAllComponents();
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            subSidyId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            appliedDate = requestAttributes[2];
            requestStatus = requestAttributes[3];
            populateTerminationRequestComponents(subSidyId);
            populateRequesterTextComponents(requesterId);
            decisionsMadeOnRequest = subsidyIndividualApproveManager.getRequestHistory(subSidyId);
            disableButtons();
        }
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment1.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName1.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId1.setValue(empInfoHashMap.get("employeeId"));
                txtRequesterPosition1.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateTerminationRequestComponents(int requestId) {
        subSidiyRequestModel = subsidyIndividualRequestManager.getTerminationrequestInformation(requestId);
        if (subSidiyRequestModel != null) {
            if (subSidiyRequestModel.getTerminationRequestId() == -1) {
                showSuccessOrFailureMessage(false, "NO RECORD  FOUND WITH ID REQUEST ID : ");
                return false;
            } else {
                subSidyId = subSidiyRequestModel.getTerminationRequestId();
                txtAppliedDate.setValue(subSidiyRequestModel.getAppliedDate());
                txtMonth.setValue(subSidiyRequestModel.getMonth());
                txtTotalAmount.setValue(subSidiyRequestModel.getTotalAmount());
                txtRemark.setValue(subSidiyRequestModel.getDescription());
                drlLocation.setValue(subSidiyRequestModel.getLocation());
                txtdocumnet.setValue(subSidiyRequestModel.getDocumeentReferenceNumber());
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
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

    private void clearDeciderTextComponenets() {
        txtDeciderDepartment.setValue(null);
        txtDeciderFullName.setValue(null);
        txtDeciderId.setValue(null);
        txtDeciderPosition.setValue(null);
    }

    private void clearRequesterTextComponenets() {
        txtRequesterId1.setValue(null);
        txtRequesterDepartment1.setValue(null);
        txtRequesterFullName1.setValue(null);
        txtRequesterPosition1.setValue(null);

    }

    private void clearEmployeeTextComponenets() {
        txtRequesterDepartment1.setValue(null);
        txtRequesterFullName1.setValue(null);
        txtRequesterId1.setValue(null);
        txtRequesterPosition1.setValue(null);
    }

    private void clearTerminationRequestComponenets() {
        drlLocation.setValue(null);
        txtAppliedDate.setValue(null);
        txtMonth.setValue(null);
        txtRemark.setValue(null);
        txtTotalAmount.setValue(null);
        txtdocumnet.setValue(null);
        selectRequestApprovableRequestLists.resetValue();
        selectMyHistoryLists.resetValue();

    }

    private void clearAllComponents() {
        clearTerminationRequestComponenets();
        clearRequesterTextComponenets();
        decisionsMadeOnRequest = null;
        requestListByEmployee = null;
        subSidyId = -1;
        drlDecision.resetValue();
    }

    public String btnSearchDecider_action() {
        if (changeOrSearchDeciderButtonLabel.equalsIgnoreCase("Change")) {
            clearDeciderTextComponenets();
            txtDeciderId.setDisabled(false);
            changeOrSearchDeciderButtonLabel = "Search";
        } else {//if (changeOrSearchDeciderButtonLabel.equalsIgnoreCase("Search"))
            if (txtDeciderId.getValue() == null || txtDeciderId.getValue().toString().equals("")) {
                showSuccessOrFailureMessage(false, "INSERT EMPLOYEE ID ");
            } else {
                String tempEmployeeId = txtDeciderId.getValue().toString();
                //if no employee found, populateApproverTextComponents() resets decider text components
                if (!populateApproverTextComponents(tempEmployeeId)) {
                    populateApproverTextComponents(loggedInEmployeeId);
                    showSuccessOrFailureMessage(false, "NO EMPLOYEE WITH ID : " + tempEmployeeId);
                }
            }
            txtDeciderId.setDisabled(true);
            changeOrSearchDeciderButtonLabel = "Change";
        }
        return null;
    }
// <editor-fold defaultstate="collapsed" desc="All getters and setters">

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public ArrayList<Option> getTerminationCatagories() {
        return terminationCatagories = subsidyIndividualRequestManager.getTerminationCatagories();
    }

    public void setTerminationCatagories(ArrayList<Option> terminationCatagories) {
        this.terminationCatagories = terminationCatagories;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DefaultSelectedData getSelectedRequestByEmployee() {
        return selectedRequestByEmployee;
    }

    public void setSelectedRequestByEmployee(DefaultSelectedData selectedRequestByEmployee) {
        this.selectedRequestByEmployee = selectedRequestByEmployee;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public String getChangeOrSearchDeciderButtonLabel() {
        return changeOrSearchDeciderButtonLabel;
    }

    public void setChangeOrSearchDeciderButtonLabel(String changeOrSearchDeciderButtonLabel) {
        this.changeOrSearchDeciderButtonLabel = changeOrSearchDeciderButtonLabel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
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

    public int getTerminationRequestId() {
        return subSidyId;
    }

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
    }

    public void setTerminationRequestId(int subSidyId) {
        this.subSidyId = subSidyId;
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

    public ArrayList<SelectItem> getRequestListByEmployee() {
        return requestListByEmployee;
    }

    public void setRequestListByEmployee(ArrayList<SelectItem> requestListByEmployee) {
        this.requestListByEmployee = requestListByEmployee;
    }

    public ArrayList<SelectItem> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<SelectItem> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate calAppliedDate) {
        this.calAppliedDate = calAppliedDate;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public DefaultSelectedData getSelectedRequestFromApprovableList() {
        return selectedRequestFromApprovableList;
    }

    public void setSelectedRequestFromApprovableList(DefaultSelectedData selectedRequestFromApprovableList) {
        this.selectedRequestFromApprovableList = selectedRequestFromApprovableList;
    }

    public String btnReset_action() {
        clearAllComponents();
        //clearDeciderTextComponenets();
        return null;
    }
// </editor-fold >
    // <editor-fold defaultstate="collapsed" desc="Work flow code">
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(subSidyId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    private void populateDecisionHistory(int overTimeRequestId) {
        decisionsMadeOnRequest = subsidyIndividualApproveManager.getRequestHistory(overTimeRequestId);
    }

    public void drlTerminationCatagory_processValueChange(ValueChangeEvent vce) {
    }

    public void btnPostDecision_processAction(ActionEvent ae) {
    }

    public String lnkTerminationRequest_action() {
        // TODO: Replace with your code
        return null;
    }

    public void updateList(ValueChangeEvent vce) {
    }

    public String txtAppliedDate_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtDocReferenceNumber_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCalculatePenality_action() {
        //return null means stay on the same page

        return null;
    }

    public void btnCalendarTerminationDate_processAction(ActionEvent ae) {
    }

    public void chksuccesisor_processValueChange(ValueChangeEvent vce) {
    }
    // </editor-fold >
}
