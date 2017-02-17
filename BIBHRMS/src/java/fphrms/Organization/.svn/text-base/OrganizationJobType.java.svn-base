/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.Organization;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.CommonValidation;
import manager.organizationManager.JobTypeManager;
import manager.organizationManager.JobTypeModel;
import manager.organizationManager.JobTypeQualificationManager;
import manager.organizationManager.JobTypeQualificationModel;
import manager.organizationManager.JobTypeRegistrationManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class OrganizationJobType extends AbstractPageBean {
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
    private DefaultSelectedData selectedObjectJobRank = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectJobRank() {
        return selectedObjectJobRank;
    }

    public void setSelectedObjectJobRank(DefaultSelectedData selectedObjectJobRank) {
        this.selectedObjectJobRank = selectedObjectJobRank;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems = dsia;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }
    private DefaultSelectedData selectedObjectOdEducType = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectOdEducType() {
        return selectedObjectOdEducType;
    }

    public void setSelectedObjectOdEducType(DefaultSelectedData selectedObjectOdEducType) {
        this.selectedObjectOdEducType = selectedObjectOdEducType;
    }
    private DefaultSelectedData selectedObjectOfEducationCategory = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectOfEducationCategory() {
        return selectedObjectOfEducationCategory;
    }

    public void setSelectedObjectOfEducationCategory(DefaultSelectedData selectedObjectOfEducationCategory) {
        this.selectedObjectOfEducationCategory = selectedObjectOfEducationCategory;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private HtmlSelectOneMenu drlEducationCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationCategory() {
        return drlEducationCategory;
    }

    public void setDrlEducationCategory(HtmlSelectOneMenu hsom) {
        this.drlEducationCategory = hsom;
    }
    private DefaultSelectedData selectManyMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectManyMenu1Bean() {
        return selectManyMenu1Bean;
    }

    public void setSelectManyMenu1Bean(DefaultSelectedData dsd) {
        this.selectManyMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drlEducationType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationType() {
        return drlEducationType;
    }

    public void setDrlEducationType(HtmlSelectOneMenu drlEducationType) {
        this.drlEducationType = drlEducationType;
    }

    public JobTypeModel getJobTypeModel() {
        return jobTypeModel;
    }

    public void setJobTypeModel(JobTypeModel jobTypeModel) {
        this.jobTypeModel = jobTypeModel;
    }

    public JobTypeQualificationManager getJobTypeQualificationManager() {
        return jobTypeQualificationManager;
    }

    public void setJobTypeQualificationManager(JobTypeQualificationManager jobTypeQualificationManager) {
        this.jobTypeQualificationManager = jobTypeQualificationManager;
    }

    public JobTypeRegistrationManager getJobTypeRegistrationManager() {
        return jobTypeRegistrationManager;
    }

    public void setJobTypeRegistrationManager(JobTypeRegistrationManager jobTypeRegistrationManager) {
        this.jobTypeRegistrationManager = jobTypeRegistrationManager;
    }
    private HtmlInputText txtExperience = new HtmlInputText();

    public HtmlInputText getTxtExperience() {
        return txtExperience;
    }

    public void setTxtExperience(HtmlInputText hit) {
        this.txtExperience = hit;
    }
    private DefaultSelectedData selectedObjectOfEducationLevel = new DefaultSelectedData();

    public int getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(int jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public DefaultSelectedData getSelectedObjectOfEducationLevel() {
        return selectedObjectOfEducationLevel;
    }

    public void setSelectedObjectOfEducationLevel(DefaultSelectedData selectedObjectOfEducationLevel) {
        this.selectedObjectOfEducationLevel = selectedObjectOfEducationLevel;
    }
    private HtmlInputTextarea txtaJobDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaJobDescription() {
        return txtaJobDescription;
    }

    public void setTxtaJobDescription(HtmlInputTextarea hit) {
        this.txtaJobDescription = hit;
    }
    private HtmlInputTextarea txtaJobName = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaJobName() {
        return txtaJobName;
    }

    public void setTxtaJobName(HtmlInputTextarea hit) {
        this.txtaJobName = hit;
    }
    private HtmlInputTextarea txtaJobResponsiblity = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaJobResponsiblity() {
        return txtaJobResponsiblity;
    }

    public void setTxtaJobResponsiblity(HtmlInputTextarea hit) {
        this.txtaJobResponsiblity = hit;
    }
    private HtmlInputText txtJobCode = new HtmlInputText();

    public HtmlInputText getTxtJobCode() {
        return txtJobCode;
    }

    public void setTxtJobCode(HtmlInputText hit) {
        this.txtJobCode = hit;
    }
    private HtmlSelectOneMenu drlRank = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRank() {
        return drlRank;
    }

    public void setDrlRank(HtmlSelectOneMenu hsom) {
        this.drlRank = hsom;
    }
    private HtmlSelectOneMenu drlEducationLevel = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationLevel() {
        return drlEducationLevel;
    }

    public void setDrlEducationLevel(HtmlSelectOneMenu hsom) {
        this.drlEducationLevel = hsom;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public OrganizationJobType() {
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

    public String lnkConfirm_action() {
        return null;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
    }

    public ArrayList<SelectItem> getJobTypesList() {
        return jobTypesList;
    }

    public void setJobTypesList(ArrayList<SelectItem> jobTypesList) {
        this.jobTypesList = jobTypesList;
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

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public ArrayList<SelectItem> getEducationCategotyList() {
        return educationCategotyList;
    }

    public void setEducationCategotyList(ArrayList<SelectItem> educationCategotyList) {
        this.educationCategotyList = educationCategotyList;
    }

    public ArrayList<SelectItem> getEducationTypeList() {
        return educationTypeList;
    }

    public void setEducationTypeList(ArrayList<SelectItem> educationTypeList) {
        this.educationTypeList = educationTypeList;
    }

    public ArrayList<SelectItem> getEducationlevelList() {
        return educationlevelList;
    }

    public void setEducationlevelList(ArrayList<SelectItem> educationlevelList) {
        this.educationlevelList = educationlevelList;
    }

    public double getExperienceNeeded() {
        return experienceNeeded;
    }

    public void setExperienceNeeded(double experienceNeeded) {
        this.experienceNeeded = experienceNeeded;
    }

    public int getJobTypeEducLevelAndExperienceId() {
        return jobTypeEducLevelAndExperienceId;
    }

    public void setJobTypeEducLevelAndExperienceId(int jobTypeEducLevelAndExperienceId) {
        this.jobTypeEducLevelAndExperienceId = jobTypeEducLevelAndExperienceId;
    }

    public JobTypeQualificationModel getJobTypeQualificationModel() {
        return jobTypeQualificationModel;
    }

    public void setJobTypeQualificationModel(JobTypeQualificationModel jobTypeQualificationModel) {
        this.jobTypeQualificationModel = jobTypeQualificationModel;
    }

    public int getJobTypeid() {
        return jobTypeId;
    }

    public void setJobTypeid(int jobTypeid) {
        this.jobTypeId = jobTypeid;
    }

    public int getEducationTypeId() {
        return educationTypeId;
    }

    public void setEducationTypeId(int educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    public String getEducationTypeName() {
        return educationTypeName;
    }

    public void setEducationTypeName(String educationTypeName) {
        this.educationTypeName = educationTypeName;
    }

    public int getJobTypeEducTypeId() {
        return jobTypeEducTypeId;
    }

    public void setJobTypeEducTypeId(int jobTypeEducTypeId) {
        this.jobTypeEducTypeId = jobTypeEducTypeId;
    }

    public int getLevelOfEducationId() {
        return levelOfEducationId;
    }

    public void setLevelOfEducationId(int levelOfEducationId) {
        this.levelOfEducationId = levelOfEducationId;
    }

    public String getLevelOfEducationName() {
        return levelOfEducationName;
    }

    public void setLevelOfEducationName(String levelOfEducationName) {
        this.levelOfEducationName = levelOfEducationName;
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

    public ArrayList<JobTypeQualificationModel> getEducationQualificationTypeList() {
        return educationQualificationTypeList;
    }

    public void setEducationQualificationTypeList(ArrayList<JobTypeQualificationModel> educationQualificationTypeList) {
        this.educationQualificationTypeList = educationQualificationTypeList;
    }

    public ArrayList<JobTypeQualificationModel> getExperienceEducLevelQualificationList() {
        return experienceEducLevelQualificationList;
    }

    public void setExperienceEducLevelQualificationList(ArrayList<JobTypeQualificationModel> experienceEducLevelQualificationList) {
        this.experienceEducLevelQualificationList = experienceEducLevelQualificationList;
    }

    public int getSelectedRowEducLevelExperience() {
        return selectedRowEducLevelExperience;
    }

    public void setSelectedRowEducLevelExperience(int selectedRowEducLevelExperience) {
        this.selectedRowEducLevelExperience = selectedRowEducLevelExperience;
    }

    public int getSelectedRowEducationType() {
        return selectedRowEducationType;
    }

    public void setSelectedRowEducationType(int selectedRowEducationType) {
        this.selectedRowEducationType = selectedRowEducationType;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
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
//         if (requestManager.deleteSalaryDelegationRequest(salaryDelegationRequestId)) {
        if (true) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponenets();
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
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    private boolean clearAllComponenets() {
        clearJobTypeComponents();
        clearEducationTypeQualificationComponents();
        clearEducationLevelQualificationComponents();
        experienceEducLevelQualificationList = new ArrayList<JobTypeQualificationModel>();
        educationQualificationTypeList = new ArrayList<JobTypeQualificationModel>();
        resetAllValues();
        jobTypeId = -1;
        return true;
    }

    private boolean resetAllValues() {
        selectedRowEducLevelExperience = -1;
        selectedRowEducationType = -1;
        selectedRequestFromMyRequestList.setSelectedObject(null);
        return true;
    }

    private void clearEducationTypeQualificationComponents() {
        drlEducationCategory.setValue(null);
        drlEducationType.setValue(null);
        selectedObjectOfEducationCategory.setSelectedObject(null);
        selectedObjectOdEducType.setSelectedObject(null);
    }

    private void clearEducationLevelQualificationComponents() {
        drlEducationType.setValue(null);
        selectedObjectOfEducationLevel.setSelectedObject(null);
        txtExperience.setValue(null);
    }

    private void clearJobTypeComponents() {
        txtaJobDescription.setValue(null);
        txtaJobName.setValue(null);
        txtJobCode.setValue(null);
        drlRank.setValue(null);
        selectedObjectJobRank.setSelectedObject(null);
        txtaJobResponsiblity.setValue(null);
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
    JobTypeRegistrationManager jobTypeRegistrationManager = new JobTypeRegistrationManager();
    JobTypeQualificationManager jobTypeQualificationManager = new JobTypeQualificationManager();
    private JobTypeManager jobTypeManager = new JobTypeManager();
    JobTypeModel jobTypeModel = new JobTypeModel();
    EmployeeManage employeeManager = new EmployeeManage();
    ArrayList<SelectItem> jobTypesList = jobTypeManager.getAllJobTypes();  //new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationCategotyList = jobTypeQualificationManager.getAllEducationCategories();// new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationTypeList = jobTypeQualificationManager.getEducationTypesByCategory("-1");//new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationlevelList = jobTypeQualificationManager.getAllEducationLevels();//new ArrayList<SelectItem>();
    JobTypeQualificationModel jobTypeQualificationModel = new JobTypeQualificationModel();
    ArrayList<JobTypeQualificationModel> experienceEducLevelQualificationList = new ArrayList<JobTypeQualificationModel>();
    ArrayList<JobTypeQualificationModel> educationQualificationTypeList = new ArrayList<JobTypeQualificationModel>();
    String newOrEditOrUpdateLabel = "Save";
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    //===========================================================================================
    int jobTypeEducLevelAndExperienceId;
    int jobTypeEducTypeId;
    int jobTypeId;
    int levelOfEducationId;
    String levelOfEducationName;
    double experienceNeeded;
    String educationTypeName;
    int educationTypeId;
    String databaseStatus;
    ///////////////////////////////////////Search By Name Criteria///////////////////////////////
    List matchesList = new ArrayList<SelectItem>();
    JobList currentJob = new JobList("", "0");
    private String selectedJobId;

    public String getSelectedJobId() {
        return selectedJobId;
    }

    public void setSelectedJobId(String selectedJobId) {
        this.selectedJobId = selectedJobId;
    }

    public List getList() {
        return matchesList;
    }

    public List getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }
    //===========================================================================================
    int selectedRowEducLevelExperience;
    int selectedRowEducationType;

    public String cmdLnkRemoveEducLevelExperience_action() {
        if (selectedRowEducLevelExperience != -1) {
            if (experienceEducLevelQualificationList.get(selectedRowEducLevelExperience).getDatabaseStatus().equals("New")) {
                experienceEducLevelQualificationList.remove(selectedRowEducLevelExperience);
            } else {//if Edited or Old
                experienceEducLevelQualificationList.get(selectedRowEducLevelExperience).setDatabaseStatus("Deleted");
            }
        }
        return null;
    }

    public String cmdLnkRemoveEducationType_action() {
        if (selectedRowEducationType != -1) {
            if (educationQualificationTypeList.get(selectedRowEducationType).getDatabaseStatus().equals("New")) {
                educationQualificationTypeList.remove(selectedRowEducationType);
            } else {//if Edited or Old
                educationQualificationTypeList.get(selectedRowEducationType).setDatabaseStatus("Deleted");
            }
        }
        return null;
    }

    public void rowSelectorEducLevelExperience_processMyEvent(RowSelectorEvent rse) {
        selectedRowEducLevelExperience = rse.getRow();
    }

    public void rowSelectorEducationType_processMyEvent(RowSelectorEvent rse) {
        selectedRowEducationType = rse.getRow();
    }

    private boolean validateAndInitializeEducationType() {
        if (drlEducationType.getValue() != null && !drlEducationType.getValue().toString().equals("-1")) {
            educationTypeId = Integer.parseInt(drlEducationType.getValue().toString().split("--")[0]);
            educationTypeName = (drlEducationType.getValue().toString().split("--")[1]);
            if (!checkAvailablityOfEducType(educationTypeId)) {
                showSuccessOrFailureMessage(false, "Education field is already filled!");
                return false;
            }

            return true;
        } else {
            showSuccessOrFailureMessage(false, "Education type not selected");
            return false;
        }
    }

    private boolean checkAvailablityOfEducLevel(int educationLevelToTest) {
        for (JobTypeQualificationModel test : experienceEducLevelQualificationList) {
            if (educationLevelToTest == test.getLevelOfEducationId()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAvailablityOfEducType(int educationTypeToTest) {
        for (JobTypeQualificationModel test : educationQualificationTypeList) {
            if (educationTypeToTest == test.getEducationTypeId()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateAndInitializeEducationLevelAndExperience() {
        if (!(drlEducationLevel.getValue() == null || drlEducationLevel.getValue().toString().equals("-1") || txtExperience.getValue() == null)) {
            try {
                levelOfEducationId = Integer.parseInt(drlEducationLevel.getValue().toString().split("--")[0]);
                levelOfEducationName = (drlEducationLevel.getValue().toString().split("--")[1]);
                experienceNeeded = Double.parseDouble(txtExperience.getValue().toString().trim());
                if (!checkAvailablityOfEducLevel(levelOfEducationId)) {
                    showSuccessOrFailureMessage(false, "Education level is already filled!");
                    return false;
                }
                return true;
            } catch (NumberFormatException nfe) {
                showSuccessOrFailureMessage(false, "Invalid Experience value");
                return false;
            } catch (NullPointerException npe) {
                showSuccessOrFailureMessage(false, "Experience not filled");
                return false;
            }
        } else {
            showSuccessOrFailureMessage(false, "Education level not selected");
            return false;
        }
    }
    //===========================================================================================

    public String btnAddToTableExperEducLevel_action() {
        if (validateAndInitializeEducationLevelAndExperience()) {
            jobTypeQualificationModel = new JobTypeQualificationModel(jobTypeId, levelOfEducationId, levelOfEducationName, experienceNeeded, "New");
            experienceEducLevelQualificationList.add(jobTypeQualificationModel);
            clearEducationLevelQualificationComponents();
        }
        return null;
    }

    public String btnAddToTableEducType_action() {
        if (validateAndInitializeEducationType()) {
            jobTypeQualificationModel = new JobTypeQualificationModel(jobTypeId, educationTypeId, educationTypeName, "New");
            educationQualificationTypeList.add(jobTypeQualificationModel);
            clearEducationTypeQualificationComponents();
        }
        return null;
    }

    public void drlEducationCategory_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            educationTypeList = jobTypeQualificationManager.getEducationTypesByCategory(vce.getNewValue().toString());
        }
    }

    public String btnSaveOrUpdate_action() {
        try {
            if (jobTypeQualificationManager.saveQualificationsForJob(
                    experienceEducLevelQualificationList,
                    educationQualificationTypeList)) {
                showSuccessOrFailureMessage(true, "SAVING OKAY");

                populateJobTypeAttributes(jobTypeId);
                populateEducationLevelJobTypeTable(jobTypeId);
                populateEducationTypeTable(jobTypeId);
            } else {
                showSuccessOrFailureMessage(false, "SORRY! NOT SAVED");
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void menu_left_processMyEvent(DragEvent de) {
    }

    private boolean populateJobTypeAttributes(int jobTypeId) {
        jobTypeModel = jobTypeRegistrationManager.getJobTypeDetail(jobTypeId);
        if (jobTypeModel != null && jobTypeModel.getJobId() != -1) {
            txtaJobDescription.setValue(jobTypeModel.getJobDescription());
            txtaJobName.setValue(jobTypeModel.getJobName());
            txtJobCode.setValue(jobTypeModel.getJobId());
            drlRank.setValue(jobTypeModel.getRankId());
            txtaJobResponsiblity.setValue(jobTypeModel.getResponsiblity());
        }
        return true;
    }

    private boolean populateEducationLevelJobTypeTable(int jobTypeId) {
        experienceEducLevelQualificationList = null;
        experienceEducLevelQualificationList = jobTypeQualificationManager.getEducationLevelExperience(jobTypeId);
        return true;
    }

    private boolean populateEducationTypeTable(int jobTypeId) {
        educationQualificationTypeList = jobTypeQualificationManager.getEducationType(jobTypeId);
        return true;
    }

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        try {
            if (resetAllValues()) {
                String jobCodeId[] = vce.getNewValue().toString().split("--");
                jobTypeId = Integer.parseInt(jobCodeId[0]);
                populateJobTypeAttributes(jobTypeId);
                populateEducationLevelJobTypeTable(jobTypeId);
                populateEducationTypeTable(jobTypeId);
            }
        } catch (Exception ex) {
            showSuccessOrFailureMessage(false, "SORRY! EXCEPTION ENCOUNTERED");
            clearAllComponenets();
        }
    }

    public String btnReset_action() {
        clearAllComponenets();
        return null;
    }

    public String cmdLnkJobTypes_action() {

        return "JobTypeRegistration";
    }

    public String cmdLnkOrgStructure_action() {
        //return null means stay on the same page
        return "OrganizationStructure";
    }

    public void drlEducationLevel_processValueChange(ValueChangeEvent vce) {
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

    public String txtSearchByName_action() {
        try {
            jobTypeId = Integer.parseInt(getSelectedJobId());
            populateJobTypeAttributes(jobTypeId);
            populateEducationLevelJobTypeTable(jobTypeId);
            populateEducationTypeTable(jobTypeId);
        } catch (Exception e) {
        }
        //return null means stay on the same page
        return null;
    }
}
