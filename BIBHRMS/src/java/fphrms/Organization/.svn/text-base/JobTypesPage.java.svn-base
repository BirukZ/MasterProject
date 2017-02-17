/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Organization;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.AutoAllCompleteDictionaryJOb;
import fphrms.JobList;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.employeeManager.EmployeeManage;
//import manager.globalUseManager.LookUpManager;
import manager.globalUseManager.CommonValidation;
import manager.globalUseManager.LookUpManager;
import manager.organizationManager.JobTypeModel;
import manager.organizationManager.JobTypeManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class JobTypesPage extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

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
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems = dsia;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems2 = dsi;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private HtmlSelectOneListbox selectJobTypesList = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectJobTypesList() {
        return selectJobTypesList;
    }

    public void setSelectJobTypesList(HtmlSelectOneListbox hsol) {
        this.selectJobTypesList = hsol;
    }
    private HtmlInputTextarea txtaJobName = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaJobName() {
        return txtaJobName;
    }

    public void setTxtaJobName(HtmlInputTextarea txtaJobName) {
        this.txtaJobName = txtaJobName;
    }
    private HtmlInputTextarea txtaJobResponsiblity = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaJobResponsiblity() {
        return txtaJobResponsiblity;
    }

    public void setTxtaJobResponsiblity(HtmlInputTextarea hit) {
        this.txtaJobResponsiblity = hit;
    }
    private HtmlSelectOneMenu drlRank = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRank() {
        return drlRank;
    }

    public void setDrlRank(HtmlSelectOneMenu hsom) {
        this.drlRank = hsom;
    }
    private HtmlInputTextarea txtAAdditionalSkill = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtAAdditionalSkill() {
        return txtAAdditionalSkill;
    }

    public void setTxtAAdditionalSkill(HtmlInputTextarea hit) {
        this.txtAAdditionalSkill = hit;
    }
    private HtmlSelectOneMenu drlJobLevel = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJobLevel() {
        return drlJobLevel;
    }

    public void setDrlJobLevel(HtmlSelectOneMenu hsom) {
        this.drlJobLevel = hsom;
    }
    private HtmlInputTextarea txtaJobDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaJobDescription() {
        return txtaJobDescription;
    }

    public void setTxtaJobDescription(HtmlInputTextarea hit) {
        this.txtaJobDescription = hit;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems3 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems3 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems5() {
        return selectOneRadio1DefaultItems5;
    }

    public void setSelectOneRadio1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems5 = dsia;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private HtmlInputText txtJobCode = new HtmlInputText();

    public HtmlInputText getTxtJobCode() {
        return txtJobCode;
    }

    public void setTxtJobCode(HtmlInputText hit) {
        this.txtJobCode = hit;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public JobTypesPage() {
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
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }

    public String lnkConfirm_action() {
        return null;
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

    public void setRequestHistoryList(ArrayList<SelectItem> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromMyRequestList() {
        return selectedRequestFromMyRequestList;
    }

    public void setSelectedRequestFromMyRequestList(DefaultSelectedData selectedRequestFromMyRequestList) {
        this.selectedRequestFromMyRequestList = selectedRequestFromMyRequestList;
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

    public DefaultSelectedData getSelectedObjectNormal() {
        return selectedObjectNormal;
    }

    public void setSelectedObjectNormal(DefaultSelectedData selectedObjectNormal) {
        this.selectedObjectNormal = selectedObjectNormal;
    }

    public DefaultSelectedData getSelectedObjectShift() {
        return selectedObjectShift;
    }

    public void setSelectedObjectShift(DefaultSelectedData selectedObjectShift) {
        this.selectedObjectShift = selectedObjectShift;
    }

    public DefaultSelectedData getSelectedObjectBoth() {
        return selectedObjectBoth;
    }

    public void setSelectedObjectBoth(DefaultSelectedData selectedObjectBoth) {
        this.selectedObjectBoth = selectedObjectBoth;
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

    public String getAdditionalSkillsNeeded() {
        return additionalSkillsNeeded;
    }

    public void setAdditionalSkillsNeeded(String additionalSkillsNeeded) {
        this.additionalSkillsNeeded = additionalSkillsNeeded;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public JobTypeManager getJobTypeManager() {
        return jobTypeManager;
    }

    public void setJobTypeManager(JobTypeManager jobTypeManager) {
        this.jobTypeManager = jobTypeManager;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public ArrayList<SelectItem> getJobLevelList() {
        return jobLevelList;
    }

    public void setJobLevelList(ArrayList<SelectItem> jobLevelList) {
        this.jobLevelList = jobLevelList;
    }

    public ArrayList<SelectItem> getJobRankList() {
        return jobRankList;
    }

    public void setJobRankList(ArrayList<SelectItem> jobRankList) {
        this.jobRankList = jobRankList;
    }

    public JobTypeModel getJobTypeModel() {
        return jobTypeModel;
    }

    public void setJobTypeModel(JobTypeModel jobTypeModel) {
        this.jobTypeModel = jobTypeModel;
    }

    public String getRankId() {
        return rankId;
    }

    public void setRankId(String rankId) {
        this.rankId = rankId;
    }

    public String getResponsiblity() {
        return responsiblity;
    }

    public void setResponsiblity(String responsiblity) {
        this.responsiblity = responsiblity;
    }

    public DefaultSelectedData getSelectedObjectJobLevel() {
        return selectedObjectJobLevel;
    }

    public void setSelectedObjectJobLevel(DefaultSelectedData selectedObjectJobLevel) {
        this.selectedObjectJobLevel = selectedObjectJobLevel;
    }

    public DefaultSelectedData getSelectedObjectJobRank() {
        return selectedObjectJobRank;
    }

    public ArrayList<SelectItem> getJobTypesList() {
        return jobTypesList;
    }

    public void setJobTypesList(ArrayList<SelectItem> jobTypesList) {
        this.jobTypesList = jobTypesList;
    }

    public String getSaveOrUpdateLabel() {
        return saveOrUpdateLabel;
    }

    public void setSaveOrUpdateLabel(String saveOrUpdateLabel) {
        this.saveOrUpdateLabel = saveOrUpdateLabel;
    }

    public void setSelectedObjectJobRank(DefaultSelectedData selectedObjectJobRank) {
        this.selectedObjectJobRank = selectedObjectJobRank;
    }

    public String getShiftOrNormal() {
        return shiftOrNormal;
    }

    public void setShiftOrNormal(String shiftOrNormal) {
        this.shiftOrNormal = shiftOrNormal;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public HtmlOutputText getOutputTextConfirmDelete() {
        return outputTextConfirmDelete;
    }

    public void setOutputTextConfirmDelete(HtmlOutputText outputTextConfirmDelete) {
        this.outputTextConfirmDelete = outputTextConfirmDelete;
    }

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pnlPopupConfirmDelete) {
        this.pnlPopupConfirmDelete = pnlPopupConfirmDelete;
    }
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
        if (employeeManager.isEmployeeHold(jobCode)) {
            if (jobTypeManager.deleteJobType(jobTypeModel)) {
                if (true) {
                    showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
                    clearAllComponenets();
                    jobTypesList = jobTypeManager.getAllJobTypes();
                } else {
                    showSuccessOrFailureMessage(false, "CAN NOT DELETE THE REQUEST\n PLEASE TRY AGAIN");
                }
            }
        } else {
            showSuccessOrFailureMessage(false, "YOU  CAN NOT DELETE THIS JOB INFORMATION!");
        }
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }

    private boolean populateJobTypeAttributes(int jobTypeId) {
        jobTypeModel = jobTypeManager.getJobTypeDetail(jobTypeId);
        if (jobTypeModel != null && jobTypeModel.getJobId() != -1) {
            txtaJobDescription.setValue(jobTypeModel.getJobDescription());
            txtaJobName.setValue(jobTypeModel.getJobName());
            txtJobCode.setValue(jobTypeModel.getJobId());
            drlRank.setValue(jobTypeModel.getRankId());
            drlJobLevel.setValue(jobTypeModel.getLevel());
            txtaJobResponsiblity.setValue(jobTypeModel.getResponsiblity());
            txtAAdditionalSkill.setValue(jobTypeModel.getAdditionalSkillsNeeded());
        }
        return true;
    }

    private void makePageReadyForUpdate() {
        saveOrUpdateLabel = "Update";
        btnDelete.setDisabled(false);
    }

    private void makePageReadyForSave() {
        saveOrUpdateLabel = "Save";
        btnDelete.setDisabled(true);
        jobId = -1;
    }

    public String btnPopupCancelDelete_action() {
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    private void clearJobTypeAttributes() {
        txtAAdditionalSkill.setValue(null);
        txtJobCode.setValue(null);
        txtaJobDescription.setValue(null);
        txtaJobName.setValue(null);
        txtaJobResponsiblity.setValue(null);
        selectedObjectJobRank.setSelectedObject(null);
        selectedObjectJobLevel.setSelectedObject(null);
    }

    private void clearAllComponenets() {
        clearJobTypeAttributes();
    }
    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
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
    // </editor-fold>
    // </editor-fold >
    // </editor-fold >
    String requesterId;
    String saveOrUpdateLabel = "Save";
    EmployeeManage employeeManager = new EmployeeManage();
    JobTypeManager jobTypeManager = new JobTypeManager();
    JobTypeModel jobTypeModel = new JobTypeModel();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> jobLevelList = jobTypeManager.getLevelTypes();// new ArrayList<SelectItem>();
    ArrayList<SelectItem> jobRankList = (new LookUpManager()).assignJobRank();// new ArrayList<SelectItem>();
    ArrayList<SelectItem> jobTypesList = jobTypeManager.getAllJobTypes(); //new ArrayList<SelectItem>();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectShift = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectNormal = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectBoth = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectJobLevel = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectJobRank = new DefaultSelectedData();
    JobList currentJob = new JobList("", "0");
    private String selectedJobId;
    //================================================================================================================
    int jobId;
    String jobName;
    String jobCode;
    String jobDescription;
    String responsiblity;
    String additionalSkillsNeeded;
    String shiftOrNormal;
    String rankId;
    String databaseStatus;
    String level;
    List matchesList = new ArrayList<SelectItem>();

    public String getSelectedJobId() {
        return selectedJobId;
    }

    public void setSelectedJobId(String selectedJobId) {
        this.selectedJobId = selectedJobId;
    }
    //======================================================================================================================

    public List getList() {
        return matchesList;
    }

    public List getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }

    public void selectJobTypesList_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                String jobCodeId[] = vce.getNewValue().toString().split("--");
                jobId = Integer.parseInt(jobCodeId[0]);
                jobCode = jobCodeId[0];
                populateJobTypeAttributes(jobId);
                makePageReadyForUpdate();
            }
        } catch (Exception ex) {
            showSuccessOrFailureMessage(false, "SORRY! EXCEPTION ENCOUNTERED");
            clearAllComponenets();
            ex.printStackTrace();
        }
    }

    public String btnSaveOrUpdate_action() {
        if (validateAndInitializeAttributes()) {
            if (saveOrUpdateLabel.equals("Save")) {
                if (jobTypeManager.saveJobType(jobTypeModel)) {
                    showSuccessOrFailureMessage(true, "SAVING  SUCCESSFUL");
                    clearAllComponenets();
                    makePageReadyForSave();
                } else {
                    showSuccessOrFailureMessage(false, "SAVING  FAILED");
                }
            } else {
                if (jobTypeManager.updateJobType(jobTypeModel)) {
                    showSuccessOrFailureMessage(true, " UPDATING SUCCESSFUL");
                    clearAllComponenets();
                    makePageReadyForSave();
                } else {
                    showSuccessOrFailureMessage(false, " UPDATING FAILED");
                }
            }
        }

        return null;
    }

    public ArrayList<SelectItem> getRankLevelOpt() {
        return jobLevelList;
    }

    public String lnkJobtypeQualification_action() {
        return "JobTypeQualifications";
    }

    public String lnkOrganizationStructure_action() {
        return "OrganizationStructure";
    }

    private boolean validateAndInitializeAttributes() {
        try {
            if (drlRank.getValue() == null || drlRank.getValue().toString().equals("-1") ||
                    drlJobLevel.getValue() == null || drlJobLevel.getValue().toString().equals("-1")) {
                showSuccessOrFailureMessage(false, "Please select both rank and level");
            } else {
                jobId = Integer.parseInt(txtJobCode.getValue().toString());
                jobName = txtaJobName.getValue().toString();
                jobDescription = txtaJobDescription.getValue().toString();
                responsiblity = txtaJobResponsiblity.getValue().toString();
                additionalSkillsNeeded = txtAAdditionalSkill.getValue().toString();
                rankId = drlRank.getValue().toString();
                level = drlJobLevel.getValue().toString();
                shiftOrNormal = "Shif";
                jobTypeModel = new JobTypeModel(jobId, jobName, jobDescription, responsiblity, additionalSkillsNeeded, shiftOrNormal, rankId, level);
            }
            return true;
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "Job ID has to be number, ant it should be unique!");
            return false;
        } catch (NumberFormatException nfe) {
            showSuccessOrFailureMessage(false, "Job ID has to be number, ant it should be unique!");
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
    int selectedRow = -1;

    public void rowSelectorJobType_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }

    public void cmdLnkOfficeOrShif_action() {
        ///
    }

    public String btnReset_action() {
        clearAllComponenets();
        makePageReadyForSave();
        return null;
    }

    public void txtSearchByName_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null && !CommonValidation.isUpdatePhase(vce)) {
            AutoAllCompleteDictionaryJOb.init(vce.getNewValue().toString());
            this.matchesList = AutoAllCompleteDictionaryJOb.dictionary;
            if (vce.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete1 = (SelectInputText) vce.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete1.getSelectedItem() != null) {
                    currentJob = (JobList) autoComplete1.getSelectedItem().getValue();
                    setSelectedJobId(currentJob.getJobId());
                } //
            }
        }
    }

    public String txtSearchByName1_action() {
        try {
            jobId = Integer.parseInt(getSelectedJobId());
            jobCode = getSelectedJobId();
            populateJobTypeAttributes(jobId);
            makePageReadyForUpdate();
        } catch (Exception e) {
        }
        //return null means stay on the same page
        return null;
    }
}
