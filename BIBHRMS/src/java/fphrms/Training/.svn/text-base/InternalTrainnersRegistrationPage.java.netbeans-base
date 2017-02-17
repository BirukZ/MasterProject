/*
 * TrainingTypesRegistrationPage.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.Training;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.employeeManager.EmployeeManage;
import fphrms.EmployeeHistory.ComplaintPage1;
import fphrms.Recruitment.ExamQuestions;
import fphrms.Termination.RetireApprovalPage;
import fphrms.Termination.RetireRequestPage;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.Report.MainReport;
import fphrms.Organization.OrganizationTreePage;
import manager.trainingManager.TrainingLookupManger;
import manager.trainingManager.TrainingTypesModel;
import manager.trainingManager.TrainingTypesRegistrationManger;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class InternalTrainnersRegistrationPage extends AbstractPageBean {
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
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }
    private HtmlSelectOneMenu drlTrainnerLevel = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainnerLevel() {
        return drlTrainnerLevel;
    }

    public void setDrlTrainnerLevel(HtmlSelectOneMenu hsom) {
        this.drlTrainnerLevel = hsom;
    }
    private HtmlSelectOneMenu drlTrainingCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainingCategory() {
        return drlTrainingCategory;
    }

    public void setDrlTrainingCategory(HtmlSelectOneMenu hsom) {
        this.drlTrainingCategory = hsom;
    }
    private HtmlSelectOneMenu drlTrainnerCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainnerCategory() {
        return drlTrainnerCategory;
    }

    public void setDrlTrainnerCategory(HtmlSelectOneMenu hsom) {
        this.drlTrainnerCategory = hsom;
    }
    private HtmlSelectOneMenu drlTrainingDuration = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainingDuration() {
        return drlTrainingDuration;
    }

    public void setDrlTrainingDuration(HtmlSelectOneMenu hsom) {
        this.drlTrainingDuration = hsom;
    }
    private HtmlInputText txtTrainingName = new HtmlInputText();

    public HtmlInputText getTxtTrainingName() {
        return txtTrainingName;
    }

    public void setTxtTrainingName(HtmlInputText hit) {
        this.txtTrainingName = hit;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
    }
    private HtmlInputTextarea txtaExpectedOutcome = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaExpectedOutcome() {
        return txtaExpectedOutcome;
    }

    public void setTxtaExpectedOutcome(HtmlInputTextarea hit) {
        this.txtaExpectedOutcome = hit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public InternalTrainnersRegistrationPage() {
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

    public DefaultSelectedData getSelectedObjectOfTrainingCategoryList() {
        return selectedObjectOfTrainingCategoryList;
    }

    public void setSelectedObjectOfTrainingCategoryList(DefaultSelectedData selectedObjectOfTrainingCategoryList) {
        this.selectedObjectOfTrainingCategoryList = selectedObjectOfTrainingCategoryList;
    }

    public DefaultSelectedData getSelectedObjectOfDurationsList() {
        return selectedObjectOfDurationsList;
    }

    public void setSelectedObjectOfDurationsList(DefaultSelectedData selectedObjectOfDurationsList) {
        this.selectedObjectOfDurationsList = selectedObjectOfDurationsList;
    }

    public ArrayList<SelectItem> getTariningCategoriesList() {
        return tariningCategoriesList;
    }

    public void setTariningCategoriesList(ArrayList<SelectItem> tariningCategoriesList) {
        this.tariningCategoriesList = tariningCategoriesList;
    }

    public ArrayList<SelectItem> getTariningDurationsList() {
        return tariningDurationsList;
    }

    public void setTariningDurationsList(ArrayList<SelectItem> tariningDurationsList) {
        this.tariningDurationsList = tariningDurationsList;
    }

    public TrainingLookupManger getTrainingLookupManger() {
        return trainingLookupManger;
    }

    public void setTrainingLookupManger(TrainingLookupManger trainingLookupManger) {
        this.trainingLookupManger = trainingLookupManger;
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

    public ArrayList<TrainingTypesModel> getTrainingTypesList() {
        return trainingTypesList;
    }

    public void setTrainingTypesList(ArrayList<TrainingTypesModel> trainingTypesList) {
        this.trainingTypesList = trainingTypesList;
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
    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public TrainingTypesRegistrationManger getTrainingTypesRegistrationManger() {
        return trainingTypesRegistrationManger;
    }

    public void setTrainingTypesRegistrationManger(TrainingTypesRegistrationManger trainingTypesRegistrationManger) {
        this.trainingTypesRegistrationManger = trainingTypesRegistrationManger;
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
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                requesterId = null;
                return false;
            } else {
                requesterId = employeeId;
                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
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
    EmployeeManage employeeManager = new EmployeeManage();
    TrainingTypesModel internalTrainnersModel = new manager.trainingManager.TrainingTypesModel();
    TrainingLookupManger trainingLookupManger = new TrainingLookupManger();
    TrainingTypesRegistrationManger trainingTypesRegistrationManger = new TrainingTypesRegistrationManger();
    ArrayList<TrainingTypesModel> trainingTypesList = new ArrayList<TrainingTypesModel>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    String newOrEditOrUpdateLabel = "Save";
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    //====================================================================================================================
    ArrayList<SelectItem> tariningCategoriesList = trainingLookupManger.getAllTrainingCategories();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> tariningDurationsList = trainingLookupManger.getAllDurationCategories();
    //====================================================================================================================
    DefaultSelectedData selectedObjectOfDurationsList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfTrainingCategoryList = new DefaultSelectedData();
    //====================================================================================================================
    int selectedRow = -1;

    public String cmdLnkRemove_action() {
        if (selectedRow != -1) {
            if (trainingTypesList.get(selectedRow).getDatabaseStatus().equals("New")) {
                trainingTypesList.remove(selectedRow);
            } else {//if Edited or Old
                trainingTypesList.get(selectedRow).setDatabaseStatus("Deleted");
            }
        }
        return null;
    }

    public String cmdLnkOk_action() {
        if (trainingTypesList.get(selectedRow).getDatabaseStatus().equals("New")) {
        } else {//if Edited or Old
            trainingTypesList.get(selectedRow).setDatabaseStatus("Edited");
        }
        return null;
    }

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
    }

    public String btnSaveOrUpdate_action() {
        if (trainingTypesRegistrationManger.saveTrainings(trainingTypesList)) {
            showSuccessOrFailureMessage(true, "SAVING SUCCEDDED");
            trainingTypesList = trainingTypesRegistrationManger.getAllTrainings22();
        } else {
            showSuccessOrFailureMessage(false, "SAVING FAILES");
        }
        return null;
    }

    public String btnReset_action() {
        //return null means stay on the same page
        return null;
    }
//    public String btnAddToTable_action() {
//        if (participantId != null) {
////            if (!checkAvailablityOfEmployeeTheList(participantId)) {
//            if (true) {
//                trainingParticipantModel = new TrainingParticipantModel(-1, trainingNeedRequestId, participantId, participantFullName, departmentName, jobTitleName, "New");
//                participantLists.add(trainingParticipantModel);
//                clearParticipantTextComponents();
//                numberOfEmployees++;
//            }
//        }
//
//        // participantLists.add(e);
//        return null;
//    }

    public String btnAddToTable_action() {
        internalTrainnersModel = new TrainingTypesModel(1,txtTrainingName.getValue().toString(),txtaDescription.getValue().toString(),drlTrainingCategory.getValue().toString(),drlTrainingDuration.getValue().toString(),txtaExpectedOutcome.getValue().toString(), "New");
        trainingTypesList.add(internalTrainnersModel);
        return null;
    }
}
