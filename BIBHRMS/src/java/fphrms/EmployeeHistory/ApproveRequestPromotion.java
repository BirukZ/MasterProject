/*
 * RequestForPromotion.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.event.ValueChangeEvent;
import manager.recruitmentManager.AdvertisementManager;

import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import com.sun.webui.jsf.model.Option;
import java.util.Iterator;
//import javax.swing.JOptionPane;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.disciplineManager.DisciplineRequestManager;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeHistoryManager.PromotionManager;
import manager.globalUseManager.StringDateManipulation;
import manager.recruitmentManager.RecruitmentManager;
import manager.recruitmentManager.VacancyNoticeListManager;
import manager.userManagement.SiteSecurityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ApproveRequestPromotion extends AbstractPageBean {

    VacancyNoticeListManager vacancyNoticeListManager = new VacancyNoticeListManager();
    AdvertisementManager advertisementManager = new AdvertisementManager();
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    public List vacancyList = new ArrayList<AdvertisementManager>();
    private List requestersForPromotion = new ArrayList<AdvertisementManager>();
    ArrayList<AdvertisementManager> requesterForPromotionNew=new ArrayList<AdvertisementManager>();
    public List vacancyListRequestPromo = new ArrayList<VacancyNoticeListManager>();
    private PanelPopup pnMessage = new PanelPopup();
    private Option[] newPromotionRequests = recruitmentManager.newPromotionResponse();
    private Option[] newPromotionRequestsDates = recruitmentManager.newPromotionRequestsDates();
    private Option[] newPromotionRequestApprove;
    private Option[] newPromotionResponsedApprove;
    EvaluationResultManager evaResultManObject = new EvaluationResultManager();
    private Option[] toFilterResultUsingSession;
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    ArrayList<CommitteeMemberModel> committeeMembersList = new ArrayList<CommitteeMemberModel>();
    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();
    int committeeId = -1;
    int repuest_id = -1;
    String dateR1 = "";
    String dateR2 = "";
    String SessionID = "";
    int buttonIndicator = 0;
    String rank_id;
    private String bach_Code = null;
    boolean checkPercentage = false;
    boolean checkFromSelect = false;
    private PromotionManager promotionManager = new PromotionManager();

    public ArrayList<AdvertisementManager> getRequesterForPromotionNew() {
        return requesterForPromotionNew;
    }

    public void setRequesterForPromotionNew(ArrayList<AdvertisementManager> requesterForPromotionNew) {
        this.requesterForPromotionNew = requesterForPromotionNew;
    }

    public SiteSecurityManager getSiteSecurityManager() {
        return siteSecurityManager;
    }

    public void setSiteSecurityManager(SiteSecurityManager siteSecurityManager) {
        this.siteSecurityManager = siteSecurityManager;
    }

    public CommitteeMemberRegistrationManager getCommitteeMemberRegistrationManager() {
        return committeeMemberRegistrationManager;
    }

    public void setCommitteeMemberRegistrationManager(CommitteeMemberRegistrationManager committeeMemberRegistrationManager) {
        this.committeeMemberRegistrationManager = committeeMemberRegistrationManager;
    }

    public ArrayList<CommitteeMemberModel> getCommitteeMembersList() {
        return committeeMembersList;
    }

    public void setCommitteeMembersList(ArrayList<CommitteeMemberModel> committeeMembersList) {
        this.committeeMembersList = committeeMembersList;
    }

    public Option[] getNewPromotionRequestApprove() {
        return newPromotionRequestApprove;
    }

    public void setNewPromotionRequestApprove(Option[] newPromotionRequestApprove) {
        this.newPromotionRequestApprove = newPromotionRequestApprove;
    }

    public Option[] getNewPromotionResponsedApprove() {
        return newPromotionResponsedApprove;
    }

    public void setNewPromotionResponsedApprove(Option[] newPromotionResponsedApprove) {
        this.newPromotionResponsedApprove = newPromotionResponsedApprove;
    }

    public Option[] getNewPromotionRequestsDates() {
        return newPromotionRequestsDates;
    }

    public void setNewPromotionRequestsDates(Option[] newPromotionRequestsDates) {
        this.newPromotionRequestsDates = newPromotionRequestsDates;
    }

    public Option[] getToFilterResultUsingSession() {
        return toFilterResultUsingSession;
    }

    public void setToFilterResultUsingSession(Option[] toFilterResultUsingSession) {
        this.toFilterResultUsingSession = toFilterResultUsingSession;
    }

    public List getRequestersForPromotion() {
        return requestersForPromotion;
    }

    public void setRequestersForPromotion(List requestersForPromotion) {
        this.requestersForPromotion = requestersForPromotion;
    }

    public Option[] getNewPromotionRequests() {
        return newPromotionRequests;
    }

    public void setNewPromotionRequests(Option[] newPromotionRequests) {
        this.newPromotionRequests = newPromotionRequests;
    }

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

    public List getVacancyList() {
        return vacancyList;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }

    public void setVacancyList(List vacancyList) {
        this.vacancyList = vacancyList;
    }
    private HtmlOutputLabel lblSignInReminder = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSignInReminder() {
        return lblSignInReminder;
    }
    private PanelPopup pnlPopupCommitteeMembers = new PanelPopup();

    public PanelPopup getPnlPopupCommitteeMembers() {
        return pnlPopupCommitteeMembers;
    }

    public void setPnlPopupCommitteeMembers(PanelPopup pp) {
        this.pnlPopupCommitteeMembers = pp;
    }
    private HtmlCommandLink cmdLnkClosePopupCommitteeMembers = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkClosePopupCommitteeMembers() {
        return cmdLnkClosePopupCommitteeMembers;
    }

    public void setCmdLnkClosePopupCommitteeMembers(HtmlCommandLink hcl) {
        this.cmdLnkClosePopupCommitteeMembers = hcl;
    }
    int selectedCommitteeMemberRow = -1;
     int selectedForApprovalMemberRow = -1;

    public void rowSelectorCommitteeMember_processMyEvent(RowSelectorEvent rse) {
        selectedCommitteeMemberRow = rse.getRow();

    }

     public void rowSelectorForApprovalMember_processMyEvent(RowSelectorEvent rse) {
        selectedForApprovalMemberRow = rse.getRow();
        requesterIDforDiscipline=requesterForPromotionNew.get(selectedForApprovalMemberRow).getEmpID();
       
    }


      private PanelPopup pnlPopupAllCommittedOffences = new PanelPopup();
       private PanelPopup pnlPopupAllPerformanceValue = new PanelPopup();

    public PanelPopup getPnlPopupAllPerformanceValue() {
        return pnlPopupAllPerformanceValue;
    }

    public void setPnlPopupAllPerformanceValue(PanelPopup pnlPopupAllPerformanceValue) {
        this.pnlPopupAllPerformanceValue = pnlPopupAllPerformanceValue;
    }

    public PanelPopup getPnlPopupAllCommittedOffences() {
        return pnlPopupAllCommittedOffences;
    }

    public void setPnlPopupAllCommittedOffences(PanelPopup pnlPopupAllCommittedOffences) {
        this.pnlPopupAllCommittedOffences = pnlPopupAllCommittedOffences;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlCommandButton button1 = new HtmlCommandButton();

    public HtmlCommandButton getButton1() {
        return button1;
    }

    public void setButton1(HtmlCommandButton hcb) {
        this.button1 = hcb;
    }
    private RowSelector rowSelectorVacancyNoticeList = new RowSelector();

    public RowSelector getRowSelectorVacancyNoticeList() {
        return rowSelectorVacancyNoticeList;
    }

    public void setRowSelectorVacancyNoticeList(RowSelector rs) {
        this.rowSelectorVacancyNoticeList = rs;
    }
    private HtmlInputText txtRequester = new HtmlInputText();

    public HtmlInputText getTxtRequester() {
        return txtRequester;
    }

    public void setTxtRequester(HtmlInputText hit) {
        this.txtRequester = hit;
    }
    private HtmlSelectBooleanCheckbox checkbox1RequestPromotion = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckbox1RequestPromotion() {
        return checkbox1RequestPromotion;
    }

    public void setCheckbox1RequestPromotion(HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1RequestPromotion = hsbc;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlSelectOneListbox selectOneListboxPromotionRequestes = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListboxPromotionRequestes() {
        return selectOneListboxPromotionRequestes;
    }

    public void setSelectOneListboxPromotionRequestes(HtmlSelectOneListbox hsol) {
        this.selectOneListboxPromotionRequestes = hsol;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
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
    private HtmlInputText inputTextAdvertID = new HtmlInputText();

    public HtmlInputText getInputTextAdvertID() {
        return inputTextAdvertID;
    }

    public void setInputTextAdvertID(HtmlInputText hit) {
        this.inputTextAdvertID = hit;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox1TotalService = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox1TotalService() {
        return selectBooleanCheckbox1TotalService;
    }

    public void setSelectBooleanCheckbox1TotalService(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox1TotalService = hsbc;
    }
    private PanelLayout PanelLayOutInsidVacancyListRequester = new PanelLayout();

    public PanelLayout getPanelLayOutInsidVacancyListRequester() {
        return PanelLayOutInsidVacancyListRequester;
    }

    public void setPanelLayOutInsidVacancyListRequester(PanelLayout pl) {
        this.PanelLayOutInsidVacancyListRequester = pl;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox2Performance = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox2Performance() {
        return selectBooleanCheckbox2Performance;
    }

    public void setSelectBooleanCheckbox2Performance(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox2Performance = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox3EducationLevel = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox3EducationLevel() {
        return selectBooleanCheckbox3EducationLevel;
    }

    public void setSelectBooleanCheckbox3EducationLevel(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox3EducationLevel = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox4Training = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox4Training() {
        return selectBooleanCheckbox4Training;
    }

    public void setSelectBooleanCheckbox4Training(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox4Training = hsbc;
    }
    private HtmlInputText txtExameResult = new HtmlInputText();

    public HtmlInputText getTxtExameResult() {
        return txtExameResult;
    }

    public void setTxtExameResult(HtmlInputText hit) {
        this.txtExameResult = hit;
    }
    private HtmlInputText txtPerformance = new HtmlInputText();

    public HtmlInputText getTxtPerformance() {
        return txtPerformance;
    }

    public void setTxtPerformance(HtmlInputText hit) {
        this.txtPerformance = hit;
    }
    private HtmlInputText txtDiscipline = new HtmlInputText();

    public HtmlInputText getTxtDiscipline() {
        return txtDiscipline;
    }

    public void setTxtDiscipline(HtmlInputText hit) {
        this.txtDiscipline = hit;
    }
    private HtmlDataTable dataTable1 = new HtmlDataTable();

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }
    private PanelPopup evaResultPopUpMsg = new PanelPopup();

    public PanelPopup getEvaResultPopUpMsg() {
        return evaResultPopUpMsg;
    }

    public void setEvaResultPopUpMsg(PanelPopup pp) {
        this.evaResultPopUpMsg = pp;
    }
    private HtmlCommandButton button2Cancel = new HtmlCommandButton();

    public HtmlCommandButton getButton2Cancel() {
        return button2Cancel;
    }

    public void setButton2Cancel(HtmlCommandButton hcb) {
        this.button2Cancel = hcb;
    }
    private HtmlOutputText outputText14evaResultNoteIssueVal = new HtmlOutputText();

    public HtmlOutputText getOutputText14evaResultNoteIssueVal() {
        return outputText14evaResultNoteIssueVal;
    }

    public void setOutputText14evaResultNoteIssueVal(HtmlOutputText hot) {
        this.outputText14evaResultNoteIssueVal = hot;
    }
    private HtmlSelectOneMenu selectOneMenu1evaResultPopUpMsg = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1evaResultPopUpMsg() {
        return selectOneMenu1evaResultPopUpMsg;
    }

    public void setSelectOneMenu1evaResultPopUpMsg(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1evaResultPopUpMsg = hsom;
    }
    private HtmlCommandButton button2Ok = new HtmlCommandButton();

    public HtmlCommandButton getButton2Ok() {
        return button2Ok;
    }

    public void setButton2Ok(HtmlCommandButton hcb) {
        this.button2Ok = hcb;
    }
    private HtmlCommandButton btnReject = new HtmlCommandButton();

    public HtmlCommandButton getBtnReject() {
        return btnReject;
    }

    public void setBtnReject(HtmlCommandButton hcb) {
        this.btnReject = hcb;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems1() {
        return selectOneListbox1DefaultItems1;
    }

    public void setSelectOneListbox1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems2() {
        return selectOneListbox1DefaultItems2;
    }

    public void setSelectOneListbox1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems3() {
        return selectOneListbox1DefaultItems3;
    }

    public void setSelectOneListbox1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems3 = dsia;
    }
    private HtmlSelectOneListbox selectOneListbox1Date = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1Date() {
        return selectOneListbox1Date;
    }

    public void setSelectOneListbox1Date(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1Date = hsol;
    }
    private HtmlCommandButton buttonViewAllR = new HtmlCommandButton();

    public HtmlCommandButton getButtonViewAllR() {
        return buttonViewAllR;
    }

    public void setButtonViewAllR(HtmlCommandButton hcb) {
        this.buttonViewAllR = hcb;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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
    private HtmlSelectOneListbox selectOneListbox1 = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1() {
        return selectOneListbox1;
    }

    public void setSelectOneListbox1(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1 = hsol;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ApproveRequestPromotion() {
    }

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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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
        disableEvaluationComponents();
        this.toFilterResultUsingSession = evaResultManObject.readAllSessionsResultsGivenToPromotion();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page2 Initialization Failure", e);
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
     ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee = new ArrayList<DisciplineRequestModel>();
     ArrayList<AdvertisementManager> allPerforamceResult = new ArrayList<AdvertisementManager>();

    public String cmdRecruitmentRequest_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdrecApproval_action() {
        //return null means stay on the same page
        return "ApprovedRecruitmentList";
    }

    public String cmdvacNotice_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdRegisterCandidate_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }

    public String cmdfilterCandidate_action() {
        //return null means stay on the same page
        return "FilterCandidates";
    }

    public void enableEvaluationComponents() {
        selectBooleanCheckbox1TotalService.setDisabled(false);
        selectBooleanCheckbox2Performance.setDisabled(false);
        selectBooleanCheckbox3EducationLevel.setDisabled(false);
        selectBooleanCheckbox4Training.setDisabled(false);
        txtExameResult.setDisabled(false);
        txtPerformance.setDisabled(false);
        txtDiscipline.setDisabled(false);


    }

    public void disableEvaluationComponents() {
        selectBooleanCheckbox1TotalService.setDisabled(true);
        selectBooleanCheckbox2Performance.setDisabled(true);
        selectBooleanCheckbox3EducationLevel.setDisabled(true);
        selectBooleanCheckbox4Training.setDisabled(true);
        txtExameResult.setDisabled(true);
        txtPerformance.setDisabled(true);
        txtDiscipline.setDisabled(true);


    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public String[] requestJobCodeChecker(String requesterID) {
        return advertisementManager.readRequesterJobCode(requesterID);
    }

    private int compareTwoYears(String year) {
        String currDate = StringDateManipulation.toDayInEc();
        int dateDiffrence = StringDateManipulation.calculateYearDifferenceBetweenTwoDates(year, currDate);

        return dateDiffrence;
    }

    private boolean checkPercentValidity(String val1, String val2) {
        int value1 = Integer.valueOf(val1);
        int value2 = Integer.valueOf(val2);
        if ((value1 + value2) == 100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPercentValidity(String val1, String val2, String val3) {
        double value1 = Double.valueOf(val1);
        double value2 = Double.valueOf(val2);
        double value3 = Double.valueOf(val3);
        if ((value1 + value2 + value3) == 100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPercentValidity(String val1, String val2, String val3, String val4) {
        double value1 = Double.valueOf(val1);
        double value2 = Double.valueOf(val2);
        double value3 = Double.valueOf(val3);
        double value4 = Double.valueOf(val4);
        if ((value1 + value2 + value3 + value4) == 100) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap[] requestValidationChecker(String jobCode) {
        HashMap[] list = null;
        try {

            list = advertisementManager.readVacancyForValidation(jobCode);
            if (list.length > 0) {
                for (int i = 0; i < list.length; i++) {

                    list[i].get("JOB_DESCRIPTION").toString();
                    list[i].get("MIN_EXPERIENCE").toString();
                    list[i].get("QUALIFICATION").toString();
                    list[i].get("EDUCATION_LEVEL").toString();
                    list[i].get("JOB_CODE").toString();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;

    }

    public HashMap[] requesterEducHistory(String requesterID) {
        HashMap[] list = null;
        try {
            list = advertisementManager.readPersonEducHist(requesterID);
            if (list.length > 0) {
                for (int i = 0; i < list.length; i++) {

                    list[i].get("EDUC_LEVEL_CODE").toString();
                    list[i].get("EDUCATION_TYPE").toString();
                    list[i].get("STARTING_DATE").toString();
                    list[i].get("COMPLETION_DATE").toString();
                    list[i].get("HIRE_DATE").toString();

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    String advertId;
    String requester_ID;
    String requesterIDforDiscipline;

    public void selectOneListboxPromotionRequestes_processValueChange(ValueChangeEvent vce) {

        float interviewPercentage = 0.0f;
        float presentationPercentage = 0.0f;
        float writtenPercentage = 0.0f;
        float otherPercentage = 0.0f;
        float disciplineValue = 5.0f;
        float performanceValue = 0.0f;
        float disciplinePercentage = 0.0f;
        float performancePercentage = 0.0f;
        int educLevelId = 0;
        int educLevelresult = 0;

       
        advertId = vce.getNewValue().toString();
             requesterIDforDiscipline=advertisementManager.selectRequesterID(advertId);
        if (vce.getNewValue() != null) {
            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
            try {
                this.vacancyList.clear();
                HashMap[] list = advertisementManager.readVacancyPromoRequest(vce.getNewValue().toString());
                rank_id = list[0].get("RANK_ID").toString();
                advertisementManager.setRank(Integer.parseInt(rank_id));
                if (list.length > 0) {
                    for (int i = 0; i < list.length; i++) {

                        AdvertisementManager addToTable = new AdvertisementManager(
                                list[i].get("advert_date_from").toString(),
                                list[i].get("advert_date_to").toString(),
                                list[i].get("recruit_batch_code").toString(),
                                list[i].get("JOB_NAME").toString(),
                                list[i].get("RECRUIT_REQUEST_ID").toString(),
                                list[i].get("RECRUIT_REQUEST_TYPE").toString(),
                                list[i].get("NUM_OF_EMPS_APPROVED").toString(),
                                list[i].get("MIN_EXPERIENCE").toString(),
                                list[i].get("ADVERT_ID").toString(),
                                list[i].get("QUALIFICATION").toString(),
                                list[i].get("EDUCATION_LEVEL").toString(),
                                list[i].get("JOB_CODE").toString(), 0, 0, list[i].get("RANK_ID").toString());
                        this.vacancyList.add(addToTable);
                    }
                }
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequester(vce.getNewValue().toString());

                requestersForPromotion.clear();
                if (listRequester.length > 0) {

                    enableEvaluationComponents();
                    HashMap promotionAssessmentPercentage = promotionManager.selectPromotionAssessmentPrecentage(bach_Code);
                    if (promotionAssessmentPercentage != null && promotionAssessmentPercentage.size() > 0) {
                        interviewPercentage = Float.parseFloat(promotionAssessmentPercentage.get("interviewpercentage").toString());
                        presentationPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("presentationpercentage").toString());
                        writtenPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("writtenpercentage").toString());
                        otherPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("otherpercentage").toString());
                        checkPercentage = true;
                    }
                    for (int i = 0; i < listRequester.length; i++) {

                        educLevelId = advertisementManager.readEducLevel(listRequester[i].get("EMP_ID").toString());
                        educLevelresult = advertisementManager.readEducLevelresult(educLevelId, rank_id);
                        if (promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString()) <= 5) {
                            disciplineValue -= (float) promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString());
                        } else {
                            disciplineValue -= 5;
                        }
                        performanceValue = promotionManager.employeePerformanceResult(listRequester[i].get("EMP_ID").toString());
                        
                        AdvertisementManager addToTable = new AdvertisementManager(
                                educLevelresult,
                                listRequester[i].get("EMP_ID").toString(),
                                listRequester[i].get("EXPERIENCE").toString(),
                                listRequester[i].get("FULLNAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("JOB_DESCRIPTION").toString(),
                                listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("ADVERT_ID").toString(),
                                listRequester[i].get("STATUS").toString(),
                                Float.parseFloat(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("PRESENTATION_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("OTHER_RESULT").toString()),
                                interviewPercentage,
                                writtenPercentage,
                                presentationPercentage,
                                otherPercentage,
                                listRequester[i].get("ID").toString(),
                                disciplineValue,
                                performanceValue,
                                0,
                                disciplinePercentage,
                                performancePercentage,
                                checkPercentage);
                        requesterForPromotionNew.add(new AdvertisementManager(
                                educLevelresult,
                                listRequester[i].get("EMP_ID").toString(),
                                listRequester[i].get("EXPERIENCE").toString(),
                                listRequester[i].get("FULLNAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("JOB_DESCRIPTION").toString(),
                                listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("ADVERT_ID").toString(),
                                listRequester[i].get("STATUS").toString(),
                                Float.parseFloat(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("PRESENTATION_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("OTHER_RESULT").toString()),
                                interviewPercentage,
                                writtenPercentage,
                                presentationPercentage,
                                otherPercentage,
                                listRequester[i].get("ID").toString(),
                                disciplineValue,
                                performanceValue,
                                0,
                                disciplinePercentage,
                                performancePercentage,
                                checkPercentage));
                        getRequestersForPromotion().add(addToTable);
                        disciplineValue = 5.0f;
                        performanceValue = 0.0f;
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


//
//        float examPersentage = 0.0f;
//        float disciplinPercentage = 0.0f;
//        float performacncePercetage = 0.0f;
//        boolean firstTimeCheck = true;
//        advertId = vce.getNewValue().toString();
//        if (vce.getNewValue() != null) {
//            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
//            try {
//                this.vacancyList.clear();
//                int educLevelId = 0;
//                int educLevelresult = 0;
//                HashMap[] list = advertisementManager.readVacancyPromoRequest(vce.getNewValue().toString());
//                rank_id = list[0].get("RANK_ID").toString();
//                if (list.length > 0) {
//                    for (int i = 0; i < list.length; i++) {
//
//                        AdvertisementManager addToTable = new AdvertisementManager(
//                                list[i].get("advert_date_from").toString(),
//                                list[i].get("advert_date_to").toString(),
//                                list[i].get("recruit_batch_code").toString(),
//                                list[i].get("JOB_DESCRIPTION").toString(),
//                                list[i].get("RECRUIT_REQUEST_ID").toString(),
//                                list[i].get("RECRUIT_REQUEST_TYPE").toString(),
//                                list[i].get("NUM_OF_EMPS_APPROVED").toString(),
//                                list[i].get("MIN_EXPERIENCE").toString(),
//                                list[i].get("ADVERT_ID").toString(),
//                                list[i].get("QUALIFICATION").toString(),
//                                list[i].get("EDUCATION_LEVEL").toString(),
//                                list[i].get("JOB_CODE").toString(), 0,
//                                0, list[i].get("RANK_ID").toString());
//                        this.vacancyList.add(addToTable);
//                    }
//
//                }
//                this.requestersForPromotion.clear();
//                HashMap[] listRequester = advertisementManager.readPromotionRequestsList(vce.getNewValue().toString());
//                if (listRequester.length > 0) {
//                    for (int i = 0; i < listRequester.length; i++) {
//                        requester_ID = listRequester[i].get("EMP_ID").toString();
//                        educLevelId = advertisementManager.readEducLevel(listRequester[i].get("EMP_ID").toString());
//                        educLevelresult = advertisementManager.readEducLevelresult(educLevelId, rank_id);
//                        if (firstTimeCheck) {
//                            if (listRequester[i].get("EXAMPERCENTAGE") != null) {
//                                examPersentage = Float.valueOf(listRequester[i].get("EXAMPERCENTAGE").toString());
//                            } else {
//                                examPersentage = 0.0f;
//                            }
//                            if (listRequester[i].get("DISCIPLINEPERCENTAGE") != null) {
//                                disciplinPercentage = Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGE").toString());
//                            }
//                            if (listRequester[i].get("PERFORMANCEPERCENTAGE") != null) {
//                                performacncePercetage = Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGE").toString());
//                            }
//                            firstTimeCheck = false;
//                        }
//                        AdvertisementManager addToTable = new AdvertisementManager(
//                                educLevelresult, listRequester[i].get("EXPERIENCEREL").toString(),
//                                listRequester[i].get("ADVERT_ID").toString(),
//                                listRequester[i].get("EMP_ID").toString(),
//                                listRequester[i].get("FULLNAME").toString(),
//                                listRequester[i].get("JOB_DESCRIPTION").toString(),
//                                Float.valueOf(listRequester[i].get("EXAMPERCENTAGE").toString()),
//                                Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGE").toString()),
//                                Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGE").toString()),
//                                listRequester[i].get("EXPERIENCE").toString(),
//                                Float.valueOf(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("OTHER_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("EXAMEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("EMPLOYEETOTALRESULT").toString()),
//                                listRequester[i].get("ID").toString());
//                        this.requestersForPromotion.add(addToTable);
//
//                    }
//                    this.txtDiscipline.setValue(disciplinPercentage);
//                    this.txtPerformance.setValue(performacncePercetage);
//                    this.txtExameResult.setValue(examPersentage);
//
//                }
//                HashMap[] promotionRequestStat = advertisementManager.readPromotionRequestsStat(vce.getNewValue().toString());
//
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//        }

    }
       DisciplineRequestManager disciplineRequestManager = new DisciplineRequestManager();

    public String button2Ok_action() {
        evaResultPopUpMsg.setRendered(false);
        SessionID =
                selectOneMenu1evaResultPopUpMsg.getValue().toString();
        //return null means stay on the same page
        return null;
    }

    public String button2Cancel_action() {
        evaResultPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void selectBooleanCheckbox2Performance_processValueChange(ValueChangeEvent vce) {
        if (selectBooleanCheckbox2Performance.isSelected() == true) {
            evaResultPopUpMsg.setRendered(true);
        } else {
            evaResultPopUpMsg.setRendered(false);
        }

    }

    public String btnApprove_action() {
          
        committeeId = recruitmentManager.promotionCommitteeId(advertId);
        
        committeeMembersList = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
        pnlPopupCommitteeMembers.setRendered(true);

//        int chekSave = 0;
//        List promotionRequest = this.requestersForPromotion;
//        Iterator<AdvertisementManager> ittPromotionRequest = promotionRequest.iterator();
//
//        while (ittPromotionRequest.hasNext()) {
//            AdvertisementManager promotionC = ittPromotionRequest.next();
//            chekSave = advertisementManager.approvePromotionRequest(
//                    selectOneListboxPromotionRequestes.getValue().toString(),
//                    promotionC.getEmpID());
//        }
//
//        if (chekSave == 1) {
//            this.showSuccessOrFailureMessage(true, "Promotion request is successfully Approved!");
//            if (buttonIndicator == 4) {
//                newPromotionRequestApprove = recruitmentManager.newPromotionRequestApprove();
//                newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAprove();
//            } else if (buttonIndicator == 1) {
//                newPromotionRequestApprove = recruitmentManager.newPromotionRequestApproveFilterdByDate(dateR1, dateR2);
//                newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAproveFilterdByDate(dateR1, dateR2);
//            }
//
//        } else {
//            this.showSuccessOrFailureMessage(false, "Error Occured during approving .Please Try Again?");
//
//        }

        //return null means stay on the same page
        return null;
    }

    public String btnReject_action() {
        int chekSave = 0;
        List promotionRequest = this.requestersForPromotion;
        Iterator<AdvertisementManager> ittPromotionRequest = promotionRequest.iterator();
        while (ittPromotionRequest.hasNext()) {
            AdvertisementManager promotionC = ittPromotionRequest.next();

            chekSave = advertisementManager.rejectPromotionRequest(selectOneListboxPromotionRequestes.getValue().toString(), promotionC.getEmpID());
        }

        if (chekSave == 1) {
            this.showSuccessOrFailureMessage(true, "Promotion request is successfully Rejected!");

        } else {
            this.showSuccessOrFailureMessage(false, "Error Occured performing this action .Please Try Again?");

        }

        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1Date_processValueChange(ValueChangeEvent vce) {
        buttonIndicator = 1;
        if (vce.getNewValue() != null) {
            if (!vce.getNewValue().toString().equals("00")) {
                selectOneListboxPromotionRequestes.resetValue();
                String date[] = vce.getNewValue().toString().split("----");
                dateR1 = date[1].trim();
                dateR2 = date[2].trim();
                newPromotionRequestApprove = recruitmentManager.newPromotionRequestApproveFilterdByDate(date[1].trim(), date[2].trim());
                newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAproveFilterdByDate(date[1].trim(), date[2].trim());
            }

        }
    }

    public String buttonViewAll_action() {
        buttonIndicator = 4;
        newPromotionRequestApprove = recruitmentManager.newPromotionRequestApprove();
        newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAprove();
        //return null means stay on the same page
        return null;
    }

    public String buttonViewAllR_action() {
        buttonIndicator = 5;
        newPromotionRequestApprove = recruitmentManager.newPromotionRequestApprove();
        newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAprove();
        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {

        float interviewPercentage = 0.0f;
        float presentationPercentage = 0.0f;
        float writtenPercentage = 0.0f;
        float otherPercentage = 0.0f;
        float disciplineValue = 5.0f;
        float performanceValue = 0.0f;
        float disciplinePercentage = 0.0f;
        float performancePercentage = 0.0f;
        int educLevelId = 0;
        int educLevelresult = 0;
        advertId = vce.getNewValue().toString();
        if (vce.getNewValue() != null) {
            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
            try {
                this.vacancyList.clear();
                HashMap[] list = advertisementManager.readVacancyPromoRequest(vce.getNewValue().toString());
                rank_id = list[0].get("RANK_ID").toString();
                advertisementManager.setRank(Integer.parseInt(rank_id));
                if (list.length > 0) {
                    for (int i = 0; i < list.length; i++) {

                        AdvertisementManager addToTable = new AdvertisementManager(
                                list[i].get("advert_date_from").toString(),
                                list[i].get("advert_date_to").toString(),
                                list[i].get("recruit_batch_code").toString(),
                                list[i].get("JOB_DESCRIPTION").toString(),
                                list[i].get("RECRUIT_REQUEST_ID").toString(),
                                list[i].get("RECRUIT_REQUEST_TYPE").toString(),
                                list[i].get("NUM_OF_EMPS_APPROVED").toString(),
                                list[i].get("MIN_EXPERIENCE").toString(),
                                list[i].get("ADVERT_ID").toString(),
                                list[i].get("QUALIFICATION").toString(),
                                list[i].get("EDUCATION_LEVEL").toString(),
                                list[i].get("JOB_CODE").toString(), 0, 0, list[i].get("RANK_ID").toString());
                        this.vacancyList.add(addToTable);
                    }
                }
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequester(vce.getNewValue().toString());
                requestersForPromotion.clear();
                if (listRequester.length > 0) {
                    enableEvaluationComponents();
                    HashMap promotionAssessmentPercentage = promotionManager.selectPromotionAssessmentPrecentage(bach_Code);
                    if (promotionAssessmentPercentage != null && promotionAssessmentPercentage.size() > 0) {
                        interviewPercentage = Float.parseFloat(promotionAssessmentPercentage.get("interviewpercentage").toString());
                        presentationPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("presentationpercentage").toString());
                        writtenPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("writtenpercentage").toString());
                        otherPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("otherpercentage").toString());
                        checkPercentage = true;
                    }
                    for (int i = 0; i < listRequester.length; i++) {
                        educLevelId = advertisementManager.readEducLevel(listRequester[i].get("EMP_ID").toString());
                        educLevelresult = advertisementManager.readEducLevelresult(educLevelId, rank_id);
                        if (promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString()) <= 5) {
                            disciplineValue -= (float) promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString());
                        } else {
                            disciplineValue -= 5;
                        }
                        performanceValue = promotionManager.employeePerformanceResult(listRequester[i].get("EMP_ID").toString());
                 
                        AdvertisementManager addToTable = new AdvertisementManager(
                                educLevelresult,
                                listRequester[i].get("EMP_ID").toString(),
                                listRequester[i].get("EXPERIENCE").toString(),
                                listRequester[i].get("FULLNAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("JOB_DESCRIPTION").toString(),
                                listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("ADVERT_ID").toString(),
                                listRequester[i].get("STATUS").toString(),
                                Float.parseFloat(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("PRESENTATION_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("OTHER_RESULT").toString()),
                                interviewPercentage,
                                writtenPercentage,
                                presentationPercentage,
                                otherPercentage,
                                listRequester[i].get("ID").toString(),
                                disciplineValue,
                                performanceValue,
                                0,
                                disciplinePercentage,
                                performancePercentage,
                                checkPercentage);
                        
                     // requesterForPromotionNew.add(addToTable);
                        getRequestersForPromotion().add(addToTable);
                       
                        disciplineValue = 5.0f;
                        performanceValue = 0.0f;
                    }



                }
                checkFromSelect = false;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

//
//        float examPersentage = 0.0f;
//        float disciplinPercentage = 0.0f;
//        float totalResult = 0.0f;
//        float performacncePercetage = 0.0f;
//        int educLevelId = 0;
//        int educLevelresult = 0;
//        boolean firstTimeCheck = true;
//        if (vce.getNewValue() != null) {
//
//            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
//            try {
//                this.vacancyList.clear();
//                 HashMap[] list = advertisementManager.readVacancyPromoRequest(vce.getNewValue().toString());
//                rank_id = list[0].get("RANK_ID").toString();
//                advertisementManager.setRank(Integer.parseInt(rank_id));
//                if (list.length > 0) {
//
//
//                    for (int i = 0; i < list.length; i++) {
//                        AdvertisementManager addToTable = new AdvertisementManager(list[i].get("advert_date_from").toString(),
//                                list[i].get("advert_date_to").toString(),
//                                list[i].get("recruit_batch_code").toString(),
//                                list[i].get("JOB_DESCRIPTION").toString(), list[i].get("RECRUIT_REQUEST_ID").toString(),
//                                list[i].get("RECRUIT_REQUEST_TYPE").toString(), list[i].get("NUM_OF_EMPS_APPROVED").toString(),
//                                list[i].get("MIN_EXPERIENCE").toString(), list[i].get("ADVERT_ID").toString(),
//                                list[i].get("QUALIFICATION").toString(), list[i].get("EDUCATION_LEVEL").toString(),
//                                list[i].get("JOB_CODE").toString(), 0, 0, list[i].get("RANK_ID").toString());
//                        this.vacancyList.add(addToTable);
//                    }
//                }
//                this.requestersForPromotion.clear();
//                HashMap[] listRequester = advertisementManager.readPromotionRequestsForApprovement(vce.getNewValue().toString());
//                if (listRequester.length > 0) {
////                    //enableEvaluationComponents();
//                    for (int i = 0; i < listRequester.length; i++) {
//                        educLevelId = advertisementManager.readEducLevel(listRequester[i].get("EMP_ID").toString());
//                        educLevelresult = advertisementManager.readEducLevelresult(educLevelId, rank_id);
//                        if (firstTimeCheck) {
//                            if (listRequester[i].get("EXAMPERCENTAGE") != null) {
//                                examPersentage = Float.valueOf(listRequester[i].get("EXAMPERCENTAGE").toString());
//                            } else {
//                                examPersentage = 0.0f;
//                            }
//                            if (listRequester[i].get("DISCIPLINEPERCENTAGE") != null) {
//                                disciplinPercentage = Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGE").toString());
//                            }
//                            if (listRequester[i].get("PERFORMANCEPERCENTAGE") != null) {
//                                performacncePercetage = Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGE").toString());
//                            }
////                            if (Double.valueOf(listRequester[i].get("PERCENT_TR").toString()) > maxTRA) {
////                                maxTRA = Double.valueOf(listRequester[i].get("PERCENT_TR").toString());
////                            }
//                            firstTimeCheck = false;
//                        }
//                        AdvertisementManager addToTable = new AdvertisementManager(
//                                educLevelresult,
//                                listRequester[i].get("ADVERT_ID").toString(),
//                                listRequester[i].get("EMP_ID").toString(),
//                                listRequester[i].get("FULLNAME").toString(),
//                                listRequester[i].get("JOB_DESCRIPTION").toString(),
//                                Float.valueOf(listRequester[i].get("EXAMPERCENTAGE").toString()),
//                                Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGE").toString()),
//                                Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGE").toString()),
//                                listRequester[i].get("EXPERIENCE").toString(),
//                                Float.valueOf(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("OTHER_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("EXAMEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("EMPLOYEETOTALRESULT").toString()),
//                                listRequester[i].get("ID").toString());
//                        this.requestersForPromotion.add(addToTable);
//                    }
//                    this.txtDiscipline.setValue(disciplinPercentage);
//                    this.txtPerformance.setValue(performacncePercetage);
//                    this.txtExameResult.setValue(examPersentage);
//
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }

    }

    public String cmdLnkClosePopupCommitteeMembers_action() {
        cmdLnkClosePopupCommitteeMembers.setRendered(false);
        pnlPopupCommitteeMembers.setRendered(false);
        return null;
    }

    public String btnClosePopupCommitteeMembers_action() {
        if (isEnoughCommitteeNumbersSigned()) {
            pnlPopupCommitteeMembers.setRendered(false);
//            pnlPopupSuccessOrFailure.setRendered(false);
        } else {
            pnlPopupCommitteeMembers.setRendered(false);
        }
        return null;
    }

    public boolean isEnoughCommitteeNumbersSigned() {
        int counterCheck = 0;
        int chekSave = 0;
        int totalSize = committeeMembersList.size();
        for (CommitteeMemberModel current : committeeMembersList) {
            if (current.getLogInConfirmed() != null && current.getLogInConfirmed().equals("Confirmed")) {
                counterCheck++;
            }
        }
        if ((counterCheck == 0) || (totalSize / counterCheck >= 2)) {//less than or equal to 50% confirmed
            lblSignInReminder.setValue("Note: It can not be approved now." +
                    " Only " + counterCheck + " out of " + totalSize + " confirmed. ");
            cmdLnkClosePopupCommitteeMembers.setRendered(true);
            return false;
        } else {//if more than 50% confirmed
            try {
                List promotionRequest = this.requestersForPromotion;
                Iterator<AdvertisementManager> ittPromotionRequest = promotionRequest.iterator();

                while (ittPromotionRequest.hasNext()) {
                    AdvertisementManager promotionC = ittPromotionRequest.next();
                    chekSave = advertisementManager.approvePromotionRequest(
                            selectOneListboxPromotionRequestes.getValue().toString(),
                            promotionC.getEmpID());
                }

                if (chekSave == 1) {
                    this.showSuccessOrFailureMessage(true, "Promotion request is successfully Approved!");
                    if (buttonIndicator == 4) {
                        newPromotionRequestApprove = recruitmentManager.newPromotionRequestApprove();
                        newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAprove();
                    } else if (buttonIndicator == 1) {
                        newPromotionRequestApprove = recruitmentManager.newPromotionRequestApproveFilterdByDate(dateR1, dateR2);
                        newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAproveFilterdByDate(dateR1, dateR2);
                    }

                } else {
                    this.showSuccessOrFailureMessage(false, "Error Occured during approving .Please Try Again?");

                }

            } catch (Exception e) {
            }
            return true;
        }
    }

    public String btnPopupForColumnMemberLogIn_action() {
        try {
            if (selectedCommitteeMemberRow != -1) {
                String memberEmployeeId = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeId();
                String memberUserName = committeeMembersList.get(selectedCommitteeMemberRow).getUserName();
                String memberPassWord = committeeMembersList.get(selectedCommitteeMemberRow).getPassWord();
                if (siteSecurityManager.isValidUser(memberUserName, memberPassWord, memberEmployeeId)) {
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Confirmed");
                   
                   promotionManager.UPdatePromotedEmployeeStatus(requesterIDforDiscipline);
                } else {
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Invalid");
                }
            }
        } catch (NullPointerException npe) {
        }
        return null;
    }

    public ArrayList<AdvertisementManager> getAllPerforamceResult() {
        return allPerforamceResult;
    }

    public void setAllPerforamceResult(ArrayList<AdvertisementManager> allPerforamceResult) {
        this.allPerforamceResult = allPerforamceResult;
    }

    public ArrayList<DisciplineRequestModel> getAllCommittedOffencesOfEmployee() {
        return allCommittedOffencesOfEmployee;
    }

    public void setAllCommittedOffencesOfEmployee(ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee) {
        this.allCommittedOffencesOfEmployee = allCommittedOffencesOfEmployee;
    }
    

    public String cmdrecPromotionApproval_action() {

        return "ApproveRequestPromotion";
    }

    public String cmdPromotionRequest_action() {

        return "RequestForPromotion";
    }

    public String cmdrecPromoteEmployee_action() {

        return "PromoteEmployee";
    }
     public String btnClosePopupAllCommittedOffences_action() {
        pnlPopupAllCommittedOffences.setRendered(false);
        return null;
    }
       public String btnClosePopupAllPerformanceClosed_action() {
        pnlPopupAllPerformanceValue.setRendered(false);
        return null;
    }

    public String cmd_view_Discipline_action() {

           
        allCommittedOffencesOfEmployee = disciplineRequestManager.getComittedOffencesOfEmployee(requesterIDforDiscipline);
        pnlPopupAllCommittedOffences.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String cmd_view_performance_action() {
        //return null means stay on the same page
        allPerforamceResult=advertisementManager.getAllOerformanceResult(requesterIDforDiscipline);
        pnlPopupAllPerformanceValue.setRendered(true);
        return null;
    }
}

