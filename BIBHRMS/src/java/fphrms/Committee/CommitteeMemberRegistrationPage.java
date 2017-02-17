/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.Committee;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.employeeManager.EmployeeManage;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CommitteeMemberRegistrationPage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectedObjectCommitteeType = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommitteeType() {
        return selectedObjectCommitteeType;
    }

    public void setSelectedObjectCommitteeType(DefaultSelectedData selectedObjectCommitteeType) {
        this.selectedObjectCommitteeType = selectedObjectCommitteeType;
    }
    private DefaultSelectedData selectedObjectCommittee = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommittee() {
        return selectedObjectCommittee;
    }

    public void setSelectedObjectCommittee(DefaultSelectedData selectedObjectCommittee) {
        this.selectedObjectCommittee = selectedObjectCommittee;
    }
    private HtmlSelectOneMenu drlCommittee = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommittee() {
        return drlCommittee;
    }

    public void setDrlCommittee(HtmlSelectOneMenu hsom) {
        this.drlCommittee = hsom;
    }
    private DefaultSelectedData selectedObjectCommitteeStatus = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommitteeStatus() {
        return selectedObjectCommitteeStatus;
    }

    public void setSelectedObjectCommitteeStatus(DefaultSelectedData selectedObjectCommitteeStatus) {
        this.selectedObjectCommitteeStatus = selectedObjectCommitteeStatus;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray drlCommitteeTypeDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDrlCommitteeTypeDefaultItems() {
        return drlCommitteeTypeDefaultItems;
    }

    public void setDrlCommitteeTypeDefaultItems(DefaultSelectItemsArray dsia) {
        this.drlCommitteeTypeDefaultItems = dsia;
    }
    private HtmlInputTextarea txtaMemberResponsiblity = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaMemberResponsiblity() {
        return txtaMemberResponsiblity;
    }

    public void setTxtaMemberResponsiblity(HtmlInputTextarea hit) {
        this.txtaMemberResponsiblity = hit;
    }
    private HtmlInputText txtAssignedDate = new HtmlInputText();

    public HtmlInputText getTxtAssignedDate() {
        return txtAssignedDate;
    }

    public void setTxtAssignedDate(HtmlInputText txtEstablishedDate) {
        this.txtAssignedDate = txtEstablishedDate;
    }
    private HtmlSelectOneMenu drlMemberStatus = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlMemberStatus() {
        return drlMemberStatus;
    }

    public void setDrlMemberStatus(HtmlSelectOneMenu hsom) {
        this.drlMemberStatus = hsom;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calAssignedDate = new SelectInputDate();

    public SelectInputDate getCalAssignedDate() {
        return calAssignedDate;
    }

    public void setCalAssignedDate(SelectInputDate sid) {
        this.calAssignedDate = sid;
    }
    private SelectInputText txtMemberFullName = new SelectInputText();

    public SelectInputText getTxtMemberFullName() {
        return txtMemberFullName;
    }

    public void setTxtMemberFullName(SelectInputText sit) {
        this.txtMemberFullName = sit;
    }
    private HtmlInputText txtMemberId = new HtmlInputText();

    public HtmlInputText getTxtMemberId() {
        return txtMemberId;
    }

    public void setTxtMemberId(HtmlInputText hit) {
        this.txtMemberId = hit;
    }
    private HtmlInputText txtMemberDepartment = new HtmlInputText();

    public HtmlInputText getTxtMemberDepartment() {
        return txtMemberDepartment;
    }

    public void setTxtMemberDepartment(HtmlInputText hit) {
        this.txtMemberDepartment = hit;
    }
    private HtmlInputText txtMemberPosition = new HtmlInputText();

    public HtmlInputText getTxtMemberPosition() {
        return txtMemberPosition;
    }

    public void setTxtMemberPosition(HtmlInputText hit) {
        this.txtMemberPosition = hit;
    }
    private HtmlInputTextarea txtaRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaRemark() {
        return txtaRemark;
    }

    public void setTxtaRemark(HtmlInputTextarea hit) {
        this.txtaRemark = hit;
    }
    private HtmlSelectOneMenu drlCommitteeType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommitteeType() {
        return drlCommitteeType;
    }

    public void setDrlCommitteeType(HtmlSelectOneMenu hsom) {
        this.drlCommitteeType = hsom;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlPermanent = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPermanent() {
        return drlPermanent;
    }

    public void setDrlPermanent(HtmlSelectOneMenu hsom) {
        this.drlPermanent = hsom;
    }


    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CommitteeMemberRegistrationPage() {
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
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    public int get__placeholder() {
        return __placeholder;
    }

    public ArrayList<SelectItem> getCommitteeTypesList() {
        return committeeTypesList;
    }

    public void setCommitteeTypesList(ArrayList<SelectItem> committeeTypesList) {
        this.committeeTypesList = committeeTypesList;
    }

    public ArrayList<SelectItem> getMemberPermanentContract() {
        return memberPermanentContract;
    }

    public void setMemberPermanentContract(ArrayList<SelectItem> memberPermanentContract) {
        this.memberPermanentContract = memberPermanentContract;
    }

    public ArrayList<SelectItem> getMemberStatusList() {
        return memberStatusList;
    }

    public void setMemberStatusList(ArrayList<SelectItem> memberStatusList) {
        this.memberStatusList = memberStatusList;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
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

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public CommitteeRegistrationManager getCommitteeRegistrationManager() {
        return committeeRegistrationManager;
    }

    public void setCommitteeRegistrationManager(CommitteeRegistrationManager committeeRegistrationManager) {
        this.committeeRegistrationManager = committeeRegistrationManager;
    }

    public String getCommitteeStatus() {
        return committeeStatus;
    }

    public void setCommitteeStatus(String committeeStatus) {
        this.committeeStatus = committeeStatus;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public ArrayList<SelectItem> getCommitteeType() {
        return committeeType;
    }

    public void setCommitteeType(ArrayList<SelectItem> committeeType) {
        this.committeeType = committeeType;
    }

    public ArrayList<SelectItem> getCommitteeList() {
        return committeeList;
    }

    public void setCommitteeList(ArrayList<SelectItem> committeeList) {
        this.committeeList = committeeList;
    }

    public int getCommitteeMemberId() {
        return committeeMemberId;
    }

    public void setCommitteeMemberId(int committeeMemberId) {
        this.committeeMemberId = committeeMemberId;
    }

    public ArrayList<CommitteeMemberModel> getCommitteeMemberLists() {
        return committeeMemberLists;
    }

    public void setCommitteeMemberLists(ArrayList<CommitteeMemberModel> committeeMemberLists) {
        this.committeeMemberLists = committeeMemberLists;
    }

    public CommitteeMemberModel getCommitteeMemberModel() {
        return committeeMemberModel;
    }

    public void setCommitteeMemberModel(CommitteeMemberModel committeeMemberModel) {
        this.committeeMemberModel = committeeMemberModel;
    }

    public CommitteeMemberRegistrationManager getCommitteeMemberRegistrationManager() {
        return committeeMemberRegistrationManager;
    }

    public void setCommitteeMemberRegistrationManager(CommitteeMemberRegistrationManager committeeMemberRegistrationManager) {
        this.committeeMemberRegistrationManager = committeeMemberRegistrationManager;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
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

    public String getMemberResponsibility() {
        return memberResponsibility;
    }

    public void setMemberResponsibility(String memberResponsibility) {
        this.memberResponsibility = memberResponsibility;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public ArrayList<SelectItem> getCommitteeListFromLu() {
        return committeeListFromLu;
    }

    public void setCommitteeListFromLu(ArrayList<SelectItem> committeeListFromLu) {
        this.committeeListFromLu = committeeListFromLu;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    // </editor-fold>
    CommitteeRegistrationManager committeeRegistrationManager = new CommitteeRegistrationManager();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    ArrayList<CommitteeMemberModel> committeeMemberLists = new ArrayList<CommitteeMemberModel>();
    ArrayList<SelectItem> committeeTypesList = committeeRegistrationManager.getCommitteeTypes();
    ArrayList<SelectItem> memberStatusList = committeeRegistrationManager.getCommitteeStatus();
     ArrayList<SelectItem> memberPermanentContract = committeeRegistrationManager.getMemberPermanentContract();

    ArrayList<SelectItem> committeeList = committeeRegistrationManager.getAllActiveCommitteesSelectItem();
    ArrayList<SelectItem> committeeListFromLu = committeeRegistrationManager.getAllCommitteesTypeForLu();
    ArrayList<SelectItem> committeeType = committeeRegistrationManager.getCommitteeTypes();
    CommitteeMemberModel committeeMemberModel = new CommitteeMemberModel();
    EmployeeManage employeeManager = new EmployeeManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    int committeeId;
    String committeeName;
    String committeeStatus;
    //============================
    int committeeMemberId;
    String employeeId;
    String memberStatus;
    String remark;
    String permanentOrTemporary;
    String assignedDate;
    String memberResponsibility;
    String employeeFullName;
    String databaseStatus;
    //================================

    public String btnReset_action() {
        clearAllComponents();
        return null;
    }

    public String btnSave_action() {
        if (committeeMemberRegistrationManager.saveCommittteeMembers(committeeMemberLists)) {
            showSuccessOrFailureMessage(true, "  SAVING SUCCEDDED  ");
            committeeMemberLists = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
        } else {
            showSuccessOrFailureMessage(false, "  SAVING FAILED  ");
        }
        return null;
    }
    int selectedRow = -1;

    public void rowSelectorOverTime_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

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

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    boolean validateAndInitialize() {
        try {
            memberResponsibility = txtaMemberResponsiblity.getValue().toString();
            committeeId = Integer.parseInt(drlCommittee.getValue().toString());
            memberStatus = drlMemberStatus.getValue().toString();
            assignedDate = txtAssignedDate.getValue().toString();
            permanentOrTemporary=drlPermanent.getValue().toString();
            remark = txtaRemark.getValue().toString();
            databaseStatus = "New";
            if (memberStatus.equals("-1") || committeeId == -1 || employeeId == null || employeeId.equals("-1")||permanentOrTemporary.equals("-1")) {
                showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED <br> MAKE SURE THAT YOU SELECTED COMMITTEE AND MEMBER ");
                return false;
            }
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
        }
        return true;
    }

    boolean clearCommitteeComponents() {
        drlCommittee.setValue(null);
        drlMemberStatus.setValue(null);
        txtAssignedDate.setValue(null);
        txtaRemark.setValue(null);
        txtaMemberResponsiblity.setValue(null);
        databaseStatus = "New";
        return true;
    }

    boolean clearDataTable() {
        committeeMemberLists = new ArrayList<CommitteeMemberModel>();
        return true;
    }

    boolean clearAllComponents() {
        clearCommitteeComponents();
        clearMemberTextComponents();
        clearDataTable();
        return true;
    }

    public String btnAddToTable_action() {
        if (validateAndInitialize()) {
            committeeMemberModel = new CommitteeMemberModel(committeeId, employeeId, employeeFullName, assignedDate, memberResponsibility, remark, memberStatus, permanentOrTemporary,databaseStatus);
            committeeMemberLists.add(committeeMemberModel);
            clearCommitteeComponents();
            clearMemberTextComponents();
        }
        return null;
    }

    public String cmdLnkRemove_action() {
        if (committeeMemberLists.get(selectedRow).getDatabaseStatus().equals("New")) {
            committeeMemberLists.remove(selectedRow);
        } else {//if Edited or Old
            committeeMemberLists.get(selectedRow).setDatabaseStatus("Deleted");
        }
        return null;
    }

    public String cmdLnkOk_action() {
        if (committeeMemberLists.get(selectedRow).getDatabaseStatus().equals("New")) {
        } else {//if Edited or Old
            committeeMemberLists.get(selectedRow).setDatabaseStatus("Edited");
        }
        return null;
    }

    public String btnCalEstablishedDate_action() {
        calAssignedDate.setRendered(true);
        return null;
    }

    public void calAssignedDate_processValueChange(ValueChangeEvent vce) {
        txtAssignedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAssignedDate.setRendered(false);

    }

    private boolean populateMemberTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                this.employeeId = "-1";
                return false;
            } else {
                this.employeeId = employeeId;
                txtMemberDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtMemberFullName.setValue(empInfoHashMap.get("employeeFullName"));
                employeeFullName = empInfoHashMap.get("employeeFullName").toString();
                txtMemberId.setValue(employeeId);
              //  txtMemberPosition.setValue(empInfoHashMap.get("employeePosition"));
                txtMemberPosition.setValue(empInfoHashMap.get("employeePositionName"));
                return true;
            }
        } else {
            this.employeeId = "-1";
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void clearMemberTextComponents() {
        txtMemberId.setValue(null);
        txtMemberPosition.setValue(null);
        txtMemberFullName.setValue(null);
        txtMemberPosition.setValue(null);
    }

    public String btnSearchMember_action() {
        if (txtMemberId.getValue() != null && !txtMemberId.getValue().toString().equals("")) {
            employeeId = txtMemberId.getValue().toString();
            if (populateMemberTextComponents(employeeId)) {
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtMemberId.getValue().toString());
                employeeId = "-1";
            }
        } else {
            employeeId = "-1";
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
        return null;
    }

    public String txtMemberFullName_action() {
        clearMemberTextComponents();
        employeeId = ApplicationBean1.getSelectedEmployeeId();
        populateMemberTextComponents(employeeId);
        return null;
    }

    public String txtAssignedDate_action() {
        //return null means stay on the same page
        return null;
    }

    public void drlCommittee_processValueChange(ValueChangeEvent vce) {
        committeeId = Integer.parseInt(vce.getNewValue().toString());
        if (committeeId != -1) {
            committeeMemberLists = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
        } else {
            committeeMemberLists = new ArrayList<CommitteeMemberModel>();
        }
    }

    public String btnAddCommittee_action() {
        return "CommitteeRegistration";
    }

    public void drlCommitteeType_processValueChange(ValueChangeEvent vce) {
        if (!vce.getNewValue().toString().equals("-1")) {
            committeeList = committeeRegistrationManager.getAllCommittees(vce.getNewValue().toString());
        } else {
        }
    }

    public String lnkCommittee_action() {
        //return null means stay on the same page
        return "Committee";
    }
      
}
