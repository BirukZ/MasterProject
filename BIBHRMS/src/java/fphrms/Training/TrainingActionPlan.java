/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Training;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectManyListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.educationManager.InstitutionRegistrationManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.trainingManager.ActionPlanManager;
import manager.trainingManager.InternalTrainnersRegistrationManager;
import manager.trainingManager.TrainingLookupManger;
import manager.trainingManager.TrainingNeedAssessementRequestManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TrainingActionPlan extends AbstractPageBean {
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
    private DefaultSelectedData selectManyListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectManyListbox1Bean() {
        return selectManyListbox1Bean;
    }

    public void setSelectManyListbox1Bean(DefaultSelectedData dsd) {
        this.selectManyListbox1Bean = dsd;
    }
    private DefaultSelectedData selectManyListbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectManyListbox2Bean() {
        return selectManyListbox2Bean;
    }

    public void setSelectManyListbox2Bean(DefaultSelectedData dsd) {
        this.selectManyListbox2Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    private SelectInputDate calTentativeStartDate = new SelectInputDate();

    public SelectInputDate getCalTentativeStartDate() {
        return calTentativeStartDate;
    }

    public void setCalTentativeStartDate(SelectInputDate sid) {
        this.calTentativeStartDate = sid;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }

    public TrainingNeedAssessementRequestManager getAssessementRequestManager() {
        return assessementRequestManager;
    }

    public void setAssessementRequestManager(TrainingNeedAssessementRequestManager assessementRequestManager) {
        this.assessementRequestManager = assessementRequestManager;
    }

    public ArrayList<SelectItem> getTrainerTypeList() {
        return trainerTypeList;
    }

    public void setTrainerTypeList(ArrayList<SelectItem> trainerTypeList) {
        this.trainerTypeList = trainerTypeList;
    }

    public ArrayList<SelectItem> getBudjetYearList() {
        return budjetYearList;
    }

    public void setBudjetYearList(ArrayList<SelectItem> budjetYearList) {
        this.budjetYearList = budjetYearList;
    }

    public ArrayList<SelectItem> getOnOrOffWork() {
        return onOrOffWork;
    }

    public void setOnOrOffWork(ArrayList<SelectItem> onOrOffWork) {
        this.onOrOffWork = onOrOffWork;
    }

    public String getOnOrOff() {
        return onOrOff;
    }

    public void setOnOrOff(String onOrOff) {
        this.onOrOff = onOrOff;
    }

    

    public ArrayList<SelectItem> getInstitutionOrTrainnerList() {
        return institutionOrTrainnerList;
    }

    public void setInstitutionOrTrainnerList(ArrayList<SelectItem> institutionOrTrainnerList) {
        this.institutionOrTrainnerList = institutionOrTrainnerList;
    }

    public ActionPlanManager getActionPlanManager() {
        return actionPlanManager;
    }

    public void setActionPlanManager(ActionPlanManager actionPlanManager) {
        this.actionPlanManager = actionPlanManager;
    }

    public String getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(String budjetYear) {
        this.budjetYear = budjetYear;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public InstitutionRegistrationManager getInstitutionRegistrationManager() {
        return institutionRegistrationManager;
    }

    public void setInstitutionRegistrationManager(InstitutionRegistrationManager institutionRegistrationManager) {
        this.institutionRegistrationManager = institutionRegistrationManager;
    }

    public int getInstitutionTrainingId() {
        return institutionTrainingId;
    }

    public void setInstitutionTrainingId(int institutionTrainingId) {
        this.institutionTrainingId = institutionTrainingId;
    }

    public Object[] getSelectedItemsFromApproved() {
        return selectedItemsFromApproved;
    }

    public void setSelectedItemsFromApproved(Object[] selectedItemsFromApproved) {
        this.selectedItemsFromApproved = selectedItemsFromApproved;
    }

    public Object[] getSelectedItemsFromAssigned() {
        return selectedItemsFromAssigned;
    }

    public void setSelectedItemsFromAssigned(Object[] selectedItemsFromAssigned) {
        this.selectedItemsFromAssigned = selectedItemsFromAssigned;
    }

    public ArrayList<SelectItem> getTrainingsByInstitutionList() {
        return trainingsByInstitutionList;
    }

    public void setTrainingsByInstitutionList(ArrayList<SelectItem> trainingsByInstitutionList) {
        this.trainingsByInstitutionList = trainingsByInstitutionList;
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
    private HtmlSelectManyListbox selManyListNotAssigned = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelManyListNotAssigned() {
        return selManyListNotAssigned;
    }

    public void setSelManyListNotAssigned(HtmlSelectManyListbox hsml) {
        this.selManyListNotAssigned = hsml;
    }
    private HtmlSelectManyListbox selManyListAssigned = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelManyListAssigned() {
        return selManyListAssigned;
    }

    public void setSelManyListAssigned(HtmlSelectManyListbox hsml) {
        this.selManyListAssigned = hsml;
    }
    private HtmlSelectOneMenu drlInstitutionToAssign = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlInstitutionToAssign() {
        return drlInstitutionToAssign;
    }

    public void setDrlInstitutionToAssign(HtmlSelectOneMenu hsom) {
        this.drlInstitutionToAssign = hsom;
    }
    private HtmlSelectOneMenu drlBudjetYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBudjetYear() {
        return drlBudjetYear;
    }

    public void setDrlBudjetYear(HtmlSelectOneMenu hsom) {
        this.drlBudjetYear = hsom;
    }
    private HtmlOutputLabel lblGroupOrInstitute = new HtmlOutputLabel();

    public HtmlOutputLabel getLblGroupOrInstitute() {
        return lblGroupOrInstitute;
    }

    public void setLblGroupOrInstitute(HtmlOutputLabel hol) {
        this.lblGroupOrInstitute = hol;
    }
    private HtmlSelectOneMenu drlTrainingLevel = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainingLevel() {
        return drlTrainingLevel;
    }

    public void setDrlTrainingLevel(HtmlSelectOneMenu hsom) {
        this.drlTrainingLevel = hsom;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private HtmlSelectOneMenu drlOnOff = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlOnOff() {
        return drlOnOff;
    }

    public void setDrlOnOff(HtmlSelectOneMenu hsom) {
        this.drlOnOff = hsom;
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
    private HtmlInputText txtNoOfDays = new HtmlInputText();

    public HtmlInputText getTxtNoOfDays() {
        return txtNoOfDays;
    }

    public void setTxtNoOfDays(HtmlInputText hit) {
        this.txtNoOfDays = hit;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    private SelectInputDate calTentativeEndDate = new SelectInputDate();

    public SelectInputDate getCalTentativeEndDate() {
        return calTentativeEndDate;
    }

    public void setCalTentativeEndDate(SelectInputDate sid) {
        this.calTentativeEndDate = sid;
    }

    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }

    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TrainingActionPlan() {
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

    public ArrayList<DisciplineRequestModel> getAllCommittedOffencesOfEmployee() {
        return allCommittedOffencesOfEmployee;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
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

    public void setAllCommittedOffencesOfEmployee(ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee) {
        this.allCommittedOffencesOfEmployee = allCommittedOffencesOfEmployee;
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

    public ArrayList<SelectItem> getAssignedTrainingNeedsList() {
        return assignedTrainingNeedsList;
    }

    public void setAssignedTrainingNeedsList(ArrayList<SelectItem> assignedTrainingNeedsList) {
        this.assignedTrainingNeedsList = assignedTrainingNeedsList;
    }

    public ArrayList<SelectItem> getNotAssignedTrainingNeedsList() {
        return notAssignedTrainingNeedsList;
    }

    public void setNotAssignedTrainingNeedsList(ArrayList<SelectItem> notAssignedTrainingNeedsList) {
        this.notAssignedTrainingNeedsList = notAssignedTrainingNeedsList;
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

    public DefaultSelectedData getSelectedRequestFromInstitutionList() {
        return selectedRequestFromInstitutionList;
    }

    public DefaultSelectedData getSelectedRequestFromTrainnerTypeList() {
        return selectedRequestFromTrainnerTypeList;
    }

    public void setSelectedRequestFromTrainnerTypeList(DefaultSelectedData selectedRequestFromTrainnerTypeList) {
        this.selectedRequestFromTrainnerTypeList = selectedRequestFromTrainnerTypeList;
    }

    public InternalTrainnersRegistrationManager getInternalTrainnersRegistrationManager() {
        return internalTrainnersRegistrationManager;
    }

    public void setInternalTrainnersRegistrationManager(InternalTrainnersRegistrationManager internalTrainnersRegistrationManager) {
        this.internalTrainnersRegistrationManager = internalTrainnersRegistrationManager;
    }

    public void setSelectedRequestFromInstitutionList(DefaultSelectedData selectedRequestFromInstitutionList) {
        this.selectedRequestFromInstitutionList = selectedRequestFromInstitutionList;
    }

    public DefaultSelectedData getSelectedRequestFromMyBudjetYearList() {
        return selectedRequestFromMyBudjetYearList;
    }

    public void setSelectedRequestFromMyBudjetYearList(DefaultSelectedData selectedRequestFromMyBudjetYearList) {
        this.selectedRequestFromMyBudjetYearList = selectedRequestFromMyBudjetYearList;
    }

    public TrainingLookupManger getTrainingLookupManger() {
        return trainingLookupManger;
    }

    public void setTrainingLookupManger(TrainingLookupManger trainingLookupManger) {
        this.trainingLookupManger = trainingLookupManger;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
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
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
//         if (requestManager.deleteSalaryDelegationRequest(salaryDelegationRequestId)) {
        if (true) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponenets();
            pendingRequestList = null;// requestManager.getPendingRequests();
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

    private void clearAllComponenets() {
        //  clearRequesterTextComponents();
        notAssignedTrainingNeedsList = new ArrayList<SelectItem>();
        assignedTrainingNeedsList = new ArrayList<SelectItem>();
        selectedAssignedTrainingNeedsList = new ArrayList<SelectItem>();
        selectedRequestFromMyBudjetYearList.setSelectedObject(null);
        selectedRequestFromTrainnerTypeList.setSelectedObject(null);
        selectedRequestFromInstitutionList.setSelectedObject(null);
        txtStartDate.setValue(null);
        txtEndDate.setValue(null);
        txtNoOfDays.setValue(null);
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
    String requesterId = "-1";
    int institutionId = -1;
    String budjetYear = "-1";
    String onOrOff = "OFF";
    EmployeeManage employeeManager = new EmployeeManage();
    int institutionTrainingId;
    TrainingLookupManger trainingLookupManger = new TrainingLookupManger();
    ActionPlanManager actionPlanManager = new ActionPlanManager();
    InstitutionRegistrationManager institutionRegistrationManager = new InstitutionRegistrationManager();
    TrainingNeedAssessementRequestManager assessementRequestManager = new TrainingNeedAssessementRequestManager();
    InternalTrainnersRegistrationManager internalTrainnersRegistrationManager = new InternalTrainnersRegistrationManager();
    ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee = new ArrayList<DisciplineRequestModel>();
    String newOrEditOrUpdateLabel = "Save";
    //================================================================================================
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromMyBudjetYearList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromInstitutionList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromTrainnerTypeList = new DefaultSelectedData();
    Object[] selectedItemsFromApproved;
    Object[] selectedItemsFromAssigned;
    //===============================================================================================
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> trainerTypeList = trainingLookupManger.getAllTrainerCategories();//new ArrayList<SelectItem>();
    //===============================================================================================
    // ArrayList<SelectItem> notAssignedTrainingNeedsListForSwap = new ArrayList<SelectItem>();
    ArrayList<SelectItem> assignedTrainingNeedsList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> selectedAssignedTrainingNeedsList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> notAssignedTrainingNeedsList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> institutionOrTrainnerList = institutionRegistrationManager.getAllInstitutionDropDown();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> budjetYearList = trainingLookupManger.getAllBudgetYears();// ArrayList<SelectItem>();
    ArrayList<SelectItem> onOrOffWork = trainingLookupManger.getOnorOffWork();
    ArrayList<SelectItem> trainingsByInstitutionList = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

//    //===================================================================
////    backup
//    public void drlBudjetYear_processValueChange(ValueChangeEvent vce) {
//        try {
////            selectedRequestFromTrainnerTypeList.setSelectedObject(null);//reset
//////            selectedRequestFromInstitutionList.setSelectedObject(null);//reset drlInstitutionToAssign
////
////            if (!(vce == null || vce.getNewValue().toString().equals("-1"))) {
////                budjetYear = vce.getNewValue().toString();
////                notAssignedTrainingNeedsList = actionPlanManager.getApprovedButNotAssignedNeedRequests(budjetYear);
////                notAssignedTrainingNeedsListForSwap = notAssignedTrainingNeedsList;
////            }else{
////            }
////            assignedTrainingNeedsList = new ArrayList<SelectItem>();//clear
////            if (vce.getNewValue().toString().compareTo("-1") != 0) {
////                drlBudjetYear(vce.getNewValue().toString());
////            }else{
////            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    //===================================================================
    //a null exception occured why?
    public void drlBudjetYear_processValueChange(ValueChangeEvent vce) {
        try {
            if (((HtmlSelectOneMenu) vce.getSource()).getId().equals("drlBudjetYear"))
            {//not to be triggered by other sources but by drlBudjetYear
                if (!(vce == null || vce.getNewValue().toString().equals("-1")))
                {
                    budjetYear = vce.getNewValue().toString();
                    //  notAssignedTrainingNeedsListForSwap = actionPlanManager.getApprovedButNotAssignedNeedRequests(budjetYear);
                    if (notAssignedTrainingNeedsList != null) {
                        notAssignedTrainingNeedsList.clear();
                        notAssignedTrainingNeedsList = null;
//                        notAssignedTrainingNeedsList = notAssignedTrainingNeedsListForSwap;
                        notAssignedTrainingNeedsList = actionPlanManager.getApprovedButNotAssignedNeedRequests(budjetYear);
                    } else {//if null directly assigne
//                        notAssignedTrainingNeedsList = notAssignedTrainingNeedsListForSwap;
                        notAssignedTrainingNeedsList = actionPlanManager.getApprovedButNotAssignedNeedRequests(budjetYear);
                    }
                    if (selectedRequestFromTrainnerTypeList.getSelectedObject() != null) {
                        selectedRequestFromTrainnerTypeList.setSelectedObject(null);//reset
                    }
                    if (selectedRequestFromInstitutionList.getSelectedObject() != null) {
                        selectedRequestFromInstitutionList.setSelectedObject(null);//reset drlInstitutionToAssign
                    }
                    if (assignedTrainingNeedsList != null) {
                        assignedTrainingNeedsList.clear();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //===================================================================

//    public void drlInstitutionToAssign_processValueChange(ValueChangeEvent vce) {
//        if (!(vce == null || vce.getNewValue().toString().equals("-1"))) {
//            if (budjetYear == null || budjetYear.equals("-1")) {
//                showSuccessOrFailureMessage(false, "FIRST SELECT BUDJET YEAR");
//            } else {
//                institutionId = Integer.parseInt(vce.getNewValue().toString());
//                notAssignedTrainingNeedsListForSwap = actionPlanManager.getApprovedNeedRequest(budjetYear);
//
//                notAssignedTrainingNeedsList = actionPlanManager.getApprovedButNotAssignedNeedRequests(budjetYear);
//                assignedTrainingNeedsList = actionPlanManager.getApprovedAndAssignedNeedRequest(budjetYear, institutionId);
//                selectedRequestFromInstitutionList.setSelectedObject(null);
//            }
//        }
//    }
    public void drlInstitutionToAssign_processValueChange(ValueChangeEvent vce) {
        try {
            if (((HtmlSelectOneMenu) vce.getSource()).getId().equals("drlInstitutionToAssign")) {//not to be triggered by other sources
                if (!(vce == null || vce.getNewValue().toString().equals("-1"))) {
                    if (budjetYear == null || budjetYear.equals("-1")) {
                        showSuccessOrFailureMessage(false, "FIRST SELECT BUDJET YEAR");
                    } else {
                        institutionId = Integer.parseInt(vce.getNewValue().toString());
                        if (assignedTrainingNeedsList != null) {
                            assignedTrainingNeedsList.clear();
//                            assignedTrainingNeedsList = null;
                            assignedTrainingNeedsList = actionPlanManager.getApprovedAndAssignedNeedRequest(budjetYear, institutionId);
                        } else {
                            assignedTrainingNeedsList = actionPlanManager.getApprovedAndAssignedNeedRequest(budjetYear, institutionId);
                        }
//                       // selectedRequestFromInstitutionList.setSelectedObject(null);
                    }
                }
            } else {//if it is due to other sources
//                 drlInstitutionToAssign.setValue(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String btnAddToGroup_action() {
        if (!(drlInstitutionToAssign.getValue() == null || drlInstitutionToAssign.getValue().toString().equals("-1"))) {
            selectedItemsFromApproved = selManyListNotAssigned.getSelectedValues();
            Iterator<SelectItem> it = notAssignedTrainingNeedsList.iterator();
            while (it.hasNext()) {
                Object current = it.next();
                for (int counter = 0; counter < selectedItemsFromApproved.length; counter++) {
                    if (((SelectItem) current).getValue().toString().equals(selectedItemsFromApproved[counter].toString())) {
                        assignedTrainingNeedsList.add(((SelectItem) current));
                        it.remove();
                    }
                }
            }
        }
        return null;
    }

    public String btnRemoveFromGroup_action() {
        selectedItemsFromAssigned = selManyListAssigned.getSelectedValues();
        Iterator<SelectItem> it = assignedTrainingNeedsList.iterator();
        while (it.hasNext()) {
            Object current = it.next();
            for (int counter = 0; counter < selectedItemsFromAssigned.length; counter++) {
                if (((SelectItem) current).getValue().toString().equals(selectedItemsFromAssigned[counter].toString())) {
                    notAssignedTrainingNeedsList.add(((SelectItem) current));
                    it.remove();
                }
            }
        }
        return null;
    }

    public String btnAddAllToGroup_action() {
        //  assignedTrainingNeedsList = notAssignedTrainingNeedsListForSwap;
        if (assignedTrainingNeedsList != null) {
            for (SelectItem current : notAssignedTrainingNeedsList) {
                assignedTrainingNeedsList.add(current);
            }
        } else {
            assignedTrainingNeedsList = new ArrayList<SelectItem>();
            for (SelectItem current : notAssignedTrainingNeedsList) {
                assignedTrainingNeedsList.add(current);
            }
        }
        notAssignedTrainingNeedsList.clear();
        return null;
    }
    public String btnRemoveAllFromGroup_action() {
        if (notAssignedTrainingNeedsList != null) {
            for (SelectItem current : assignedTrainingNeedsList) {
                notAssignedTrainingNeedsList.add(current);
            }
        } else {
            notAssignedTrainingNeedsList = new ArrayList<SelectItem>();
            for (SelectItem current : assignedTrainingNeedsList) {
                notAssignedTrainingNeedsList.add(current);
            }
        }
        assignedTrainingNeedsList.clear();
        return null;
    }

    public String btnReset_action() {
        clearAllComponenets();
        return null;
    }

    private boolean validateAndInitializeAttributes() {
        if (institutionId == -1) {
            showSuccessOrFailureMessage(false, "INSTITUTION OR TRAINNER WAS NOT SELECTED");
            return false;
        }
        return true;
    }

    public String btnSave_action() {
        if (validateAndInitializeAttributes())
        {
        selectedItemsFromAssigned = selManyListAssigned.getSelectedValues();
        if (selectedItemsFromAssigned.length > 0) {
        assignedTrainingNeedsList.clear();
        Iterator<SelectItem> ti = selectedAssignedTrainingNeedsList.iterator();
        while (ti.hasNext()) {
        Object current = ti.next();
            for (int counter = 0; counter < selectedItemsFromAssigned.length; counter++) {
//                if (((SelectItem) current).getValue().toString().equals(selectedItemsFromAssigned[counter].toString())) {
                    assignedTrainingNeedsList.add(((SelectItem) current));
//                    it.remove();
//                }
            }
         }
        }
//            onOrOffWork = drlOnOff.getValue().toString();
            if (actionPlanManager.saveActionPlanChanges(institutionTrainingId, budjetYear, institutionId, assignedTrainingNeedsList, notAssignedTrainingNeedsList, onOrOff, txtStartDate.getValue().toString(), txtEndDate.getValue().toString())) {
                showSuccessOrFailureMessage(true, "ALL CHANGES SAVED");
            } else {
                showSuccessOrFailureMessage(false, "FAILED");
            }
        }
        return null;
    }

    public void drlTrainnerCategory_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce != null && !vce.getNewValue().toString().equals("-1")) {
                if (vce.getNewValue().toString().equals("BIB")) {//mugher employee
                    if (institutionOrTrainnerList != null) {
                        institutionOrTrainnerList.clear();
                        institutionOrTrainnerList = null;
                        institutionOrTrainnerList = internalTrainnersRegistrationManager.getAllTrrainnerGroups();
                    } else {
                        institutionOrTrainnerList = internalTrainnersRegistrationManager.getAllTrrainnerGroups();
                    }
                    lblGroupOrInstitute.setValue("Departments : ");
                } else if (vce.getNewValue().toString().equals("IN")) {// institution, external
                    if (institutionOrTrainnerList != null) {
                        institutionOrTrainnerList.clear();
                        institutionOrTrainnerList = null;
                        institutionOrTrainnerList = institutionRegistrationManager.getActiveTrainingInstitutions();
                    } else {
                        institutionOrTrainnerList = institutionRegistrationManager.getActiveTrainingInstitutions();
                    }
                    lblGroupOrInstitute.setValue("Institute IN : ");
                } else if (vce.getNewValue().toString().equals("OUT")) {//unknown
//                    institutionOrTrainnerList = new ArrayList<SelectItem>();//trainingNeedAssessementRequestManager.getDefaultInstitutionOrPlace();
                        institutionOrTrainnerList = institutionRegistrationManager.getOutsideTrainingInstitutions();
                        lblGroupOrInstitute.setValue("Institute OUT : ");
                }
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drlOnOff_processValueChange(ValueChangeEvent vce) {
       onOrOff = vce.getNewValue().toString();
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public String btnStartTime_action() {
        calTentativeStartDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calTentativeStartDate_processValueChange(ValueChangeEvent vce) {
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calTentativeStartDate.setRendered(false);
    }

    public void calTentativeEndDate_processValueChange(ValueChangeEvent vce) {
        txtEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calTentativeEndDate.setRendered(false);
    }

    public String button1_action() {
        calTentativeEndDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnNoOfDays_action() {
        int noOfDays =StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString());
        txtNoOfDays.setValue(noOfDays);
        //return null means stay on the same page
        return null;
    }

    public void selManyListAssigned_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            try {
            selectedAssignedTrainingNeedsList.clear();
            selectedItemsFromAssigned = selManyListAssigned.getSelectedValues();
        Iterator<SelectItem> it = assignedTrainingNeedsList.iterator();
        while (it.hasNext()) {
            Object current = it.next();
            for (int counter = 0; counter < selectedItemsFromAssigned.length; counter++) {
                if (((SelectItem) current).getValue().toString().equals(selectedItemsFromAssigned[counter].toString())) {
                    selectedAssignedTrainingNeedsList.add(((SelectItem) current));
//                    it.remove();
                }
            }
        }
        if (selectedItemsFromAssigned.length == 1) {
//            String temp = selectedAssignedTrainingNeedsList.get(1).toString();
            txtStartDate.setValue(actionPlanManager.getStartDate(budjetYear, institutionId, selectedAssignedTrainingNeedsList));
            txtEndDate.setValue(actionPlanManager.getEndDate(budjetYear, institutionId, selectedAssignedTrainingNeedsList));
            int noOfDays =StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString());
            txtNoOfDays.setValue(noOfDays);
        }
            }  catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
}
