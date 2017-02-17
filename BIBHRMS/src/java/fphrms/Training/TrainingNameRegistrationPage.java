/*
 * TrainingTypesRegistrationPage.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.Training;

import com.icesoft.faces.component.ext.HtmlCommandButton;
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
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
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
public class TrainingNameRegistrationPage extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        setTariningCategoriesList(trainingLookupManger.getAllTrainingCategories());
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
    private HtmlSelectOneListbox selectTrainingList = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectTrainingList() {
        return selectTrainingList;
    }

    public void setSelectTrainingList(HtmlSelectOneListbox hsol) {
        this.selectTrainingList = hsol;
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
    private HtmlInputTextarea txtaExpectedOutcome = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaExpectedOutcome() {
        return txtaExpectedOutcome;
    }

    public void setTxtaExpectedOutcome(HtmlInputTextarea hit) {
        this.txtaExpectedOutcome = hit;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
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
    public TrainingNameRegistrationPage() {
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

    public DefaultSelectedData getSelectedRequestFromTrainingsList() {
        return selectedRequestFromTrainingsList;
    }

    public void setSelectedRequestFromTrainingsList(DefaultSelectedData selectedRequestFromTrainingsList) {
        this.selectedRequestFromTrainingsList = selectedRequestFromTrainingsList;
    }

    public int getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(int trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    public String getEditOrUpdateLabel() {
        return editOrUpdateLabel;
    }

    public void setEditOrUpdateLabel(String editOrUpdateLabel) {
        this.editOrUpdateLabel = editOrUpdateLabel;
    }

    public TrainingTypesModel getTrainingTypeModel() {
        return trainingTypeModel;
    }

    public void setTrainingTypeModel(TrainingTypesModel trainingTypeModel) {
        this.trainingTypeModel = trainingTypeModel;
    }

    public TrainingTypesRegistrationManger getTrainingTypesRegistrationManger() {
        return trainingTypesRegistrationManger;
    }

    public void setTrainingTypesRegistrationManger(TrainingTypesRegistrationManger trainingTypesRegistrationManger) {
        this.trainingTypesRegistrationManger = trainingTypesRegistrationManger;
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

    public ArrayList<SelectItem> getTrainingTypesList() {
        return trainingTypesList;
    }

    public void setTrainingTypesList(ArrayList<SelectItem> trainingTypesList) {
        this.trainingTypesList = trainingTypesList;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pnlPopupConfirmDelete) {
        this.pnlPopupConfirmDelete = pnlPopupConfirmDelete;
    }
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
        if (trainingTypesRegistrationManger.deleteTraining(trainingTypeId)) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponenets();
            trainingTypesList = trainingTypesRegistrationManger.getAllTrainings();
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
        clearTrainingAttributes();
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
    TrainingLookupManger trainingLookupManger = new TrainingLookupManger();
    TrainingTypesRegistrationManger trainingTypesRegistrationManger = new TrainingTypesRegistrationManger();
    TrainingTypesModel trainingTypeModel;
    //====================================================================================================================
    ArrayList<SelectItem> trainingTypesList = trainingTypesRegistrationManger.getAllTrainings();
    ArrayList<SelectItem> tariningCategoriesList = new ArrayList<SelectItem>(); //new ArrayList<SelectItem>();
    ArrayList<SelectItem> tariningDurationsList = trainingLookupManger.getDurationCategoryList();
    //====================================================================================================================
    DefaultSelectedData selectedRequestFromTrainingsList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfDurationsList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfTrainingCategoryList = new DefaultSelectedData();
    //====================================================================================================================
    int trainingTypeId = -1;
    String trainingCategory;
    String durationCategory;
    String trainingName;
    String description;
    String expectedOutput;
    String username;
    String timeStamp;
    String editOrUpdateLabel = "Save";

    public void selectTrainingList_processValueChange(ValueChangeEvent vce) {
        try {


        if(vce.getNewValue()!=null){
        trainingTypeId = Integer.parseInt(vce.getNewValue().toString());
        populateTraininfAttributes(trainingTypeId);
        makePageReadyForUpdate();
        }
         } catch (Exception e) {
             e.printStackTrace();
        }
    }

    public String btnSaveOrUpdate_action() {
        if (validateAndInitializeAttributes()) {
            trainingTypeModel = new TrainingTypesModel(trainingTypeId, trainingCategory, durationCategory, trainingName, description, expectedOutput);
            if (editOrUpdateLabel.equals("Save")) {
                if (trainingTypesRegistrationManger.saveTraining(trainingTypeModel)) {
                    trainingTypesList = trainingTypesRegistrationManger.getAllTrainings();
                    clearAllComponenets();
                    showSuccessOrFailureMessage(true, "SAVING OKAY");
                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED!" + " MAKE SURE IF THE TRAINING IS ALREADY REGISTERED");
                }
            } else {// if (editOrUpdateLabel.equals("Update")) {
                if (trainingTypesRegistrationManger.updateTraining(trainingTypeModel)) {
                    showSuccessOrFailureMessage(true, "UPDATING OKAY");
                } else {
                    showSuccessOrFailureMessage(false, "UPDATING FAILED!" + " MAKE SURE IF THE NAME IS NOT GIVEN FOR THE OTHER TRAINING");
                }
            }
        }
        return null;
    }

    public String btnReset_action() {
        clearTrainingAttributes();
        makePageReadyForSave();
        selectedRequestFromTrainingsList.setSelectedObject(null);
        return null;
    }
//TrainingPlanPerYear
    private void clearTrainingAttributes() {
        txtTrainingName.setValue(null);
        txtaDescription.setValue(null);
        txtaExpectedOutcome.setValue(null);
        selectedObjectOfTrainingCategoryList.setSelectedObject(null);
        selectedObjectOfDurationsList.setSelectedObject(null);
    }

    private void makePageReadyForSave() {
        trainingTypeId = -1;
        editOrUpdateLabel = "Save";
        btnDelete.setDisabled(true);
    }

    private void makePageReadyForUpdate() {
        editOrUpdateLabel = "Update";
        btnDelete.setDisabled(false);
    }

    private void populateTraininfAttributes(int trainingTypeId) {
        trainingTypeModel = trainingTypesRegistrationManger.getTraining(trainingTypeId);
        txtTrainingName.setValue(trainingTypeModel.getTrainingName());
        txtaDescription.setValue(trainingTypeModel.getDescription());
        txtaExpectedOutcome.setValue(trainingTypeModel.getExpectedOutput());
        drlTrainingCategory.setValue(trainingTypeModel.getTrainingCategory());
        drlTrainingDuration.setValue(trainingTypeModel.getDurationCategory());
    }

    private boolean validateAndInitializeAttributes() {
        try {
            trainingCategory = drlTrainingCategory.getValue().toString();
            durationCategory = drlTrainingDuration.getValue().toString();
            trainingName = txtTrainingName.getValue().toString();
            description = txtaDescription.getValue().toString();
            expectedOutput = txtaExpectedOutcome.getValue().toString();
            if (trainingCategory.equals("-1") || durationCategory.equals("-1")) {
                showSuccessOrFailureMessage(false, "DURATION OR CATEGORY NOT SELECTED");
                return false;
            }
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "SOME FIELSD ARE NOT FILLED");
            return false;
        }
        return true;
    }
}
