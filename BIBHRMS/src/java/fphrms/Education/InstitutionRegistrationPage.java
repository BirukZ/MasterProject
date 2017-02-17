/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Education;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.util.ArrayList;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.educationManager.EducationRequestManager;
import manager.educationManager.InstitutionModel;
import manager.educationManager.InstitutionRegistrationManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class InstitutionRegistrationPage extends AbstractPageBean {
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
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
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
    private HtmlSelectOneListbox selectInstitutionList = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectInstitutionList() {
        return selectInstitutionList;
    }

    public void setSelectInstitutionList(HtmlSelectOneListbox hsol) {
        this.selectInstitutionList = hsol;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drlStatus = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlStatus() {
        return drlStatus;
    }

    public void setDrlStatus(HtmlSelectOneMenu hsom) {
        this.drlStatus = hsom;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private HtmlSelectOneMenu drlLocationCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLocationCategory() {
        return drlLocationCategory;
    }

    public void setDrlLocationCategory(HtmlSelectOneMenu hsom) {
        this.drlLocationCategory = hsom;
    }
    private HtmlInputTextarea txtDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(HtmlInputTextarea hit) {
        this.txtDescription = hit;
    }
    private HtmlSelectOneMenu drlEducationOrTraining = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationOrTraining() {
        return drlEducationOrTraining;
    }

    public void setDrlEducationOrTraining(HtmlSelectOneMenu hsom) {
        this.drlEducationOrTraining = hsom;
    }
    private HtmlSelectOneMenu drlAccreditedOrNot = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAccreditedOrNot() {
        return drlAccreditedOrNot;
    }

    public void setDrlAccreditedOrNot(HtmlSelectOneMenu hsom) {
        this.drlAccreditedOrNot = hsom;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlInputText txtContactPerson = new HtmlInputText();

    public HtmlInputText getTxtContactPerson() {
        return txtContactPerson;
    }

    public void setTxtContactPerson(HtmlInputText hit) {
        this.txtContactPerson = hit;
    }
    private HtmlInputText txtFax = new HtmlInputText();

    public HtmlInputText getTxtFax() {
        return txtFax;
    }

    public void setTxtFax(HtmlInputText hit) {
        this.txtFax = hit;
    }
    private HtmlInputText txtPhoneNo = new HtmlInputText();

    public HtmlInputText getTxtPhoneNo() {
        return txtPhoneNo;
    }

    public void setTxtPhoneNo(HtmlInputText hit) {
        this.txtPhoneNo = hit;
    }
    private HtmlInputText txtWebsite = new HtmlInputText();

    public HtmlInputText getTxtWebsite() {
        return txtWebsite;
    }

    public void setTxtWebsite(HtmlInputText hit) {
        this.txtWebsite = hit;
    }
    private HtmlInputText txtEmail = new HtmlInputText();

    public HtmlInputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(HtmlInputText hit) {
        this.txtEmail = hit;
    }
    private HtmlInputText txtTinNo = new HtmlInputText();

    public HtmlInputText getTxtTinNo() {
        return txtTinNo;
    }

    public void setTxtTinNo(HtmlInputText hit) {
        this.txtTinNo = hit;
    }
    private HtmlInputTextarea txtaLocationDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaLocationDescription() {
        return txtaLocationDescription;
    }

    public void setTxtaLocationDescription(HtmlInputTextarea hit) {
        this.txtaLocationDescription = hit;
    }
    private HtmlInputText txtName = new HtmlInputText();

    public HtmlInputText getTxtName() {
        return txtName;
    }

    public void setTxtName(HtmlInputText hit) {
        this.txtName = hit;
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
    public InstitutionRegistrationPage() {
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

    public InstitutionModel getInstitutionModel() {
        return institutionModel;
    }

    public void setInstitutionModel(InstitutionModel institutionModel) {
        this.institutionModel = institutionModel;
    }

    public String getSaveOrUpdateLabel() {
        return saveOrUpdateLabel;
    }

    public void setSaveOrUpdateLabel(String saveOrUpdateLabel) {
        this.saveOrUpdateLabel = saveOrUpdateLabel;
    }

    public ArrayList<SelectItem> getAccreditionList() {
        return accreditionList;
    }

    public void setAccreditionList(ArrayList<SelectItem> accreditionList) {
        this.accreditionList = accreditionList;
    }

    public ArrayList<SelectItem> getEducationOrTrainingList() {
        return educationOrTrainingList;
    }

    public void setEducationOrTrainingList(ArrayList<SelectItem> educationOrTrainingList) {
        this.educationOrTrainingList = educationOrTrainingList;
    }

    public ArrayList<SelectItem> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(ArrayList<SelectItem> institutionList) {
        this.institutionList = institutionList;
    }

    public ArrayList<SelectItem> getLocationCategoryList() {
        return locationCategoryList;
    }

    public void setLocationCategoryList(ArrayList<SelectItem> locationCategoryList) {
        this.locationCategoryList = locationCategoryList;
    }

    public DefaultSelectedData getSelectedObjectFromAccreditedOrNotList() {
        return selectedObjectFromAccreditedOrNotList;
    }

    public void setSelectedObjectFromAccreditedOrNotList(DefaultSelectedData selectedObjectFromAccreditedOrNotList) {
        this.selectedObjectFromAccreditedOrNotList = selectedObjectFromAccreditedOrNotList;
    }

    public ArrayList<SelectItem> getStatusList() {
        return statusList;
    }

    public void setStatusList(ArrayList<SelectItem> statusList) {
        this.statusList = statusList;
    }

    public DefaultSelectedData getSelectedObjectFromEducationOrTrainingList() {
        return selectedObjectFromEducationOrTrainingList;
    }

    public void setSelectedObjectFromEducationOrTrainingList(DefaultSelectedData selectedObjectFromEducationOrTrainingList) {
        this.selectedObjectFromEducationOrTrainingList = selectedObjectFromEducationOrTrainingList;
    }

    public DefaultSelectedData getSelectedObjectFromInstitutionList() {
        return selectedObjectFromInstitutionList;
    }

    public void setSelectedObjectFromInstitutionList(DefaultSelectedData selectedObjectFromInstitutionList) {
        this.selectedObjectFromInstitutionList = selectedObjectFromInstitutionList;
    }

    public DefaultSelectedData getSelectedObjectFromLocationCategoryList() {
        return selectedObjectFromLocationCategoryList;
    }

    public void setSelectedObjectFromLocationCategoryList(DefaultSelectedData selectedObjectFromLocationCategoryList) {
        this.selectedObjectFromLocationCategoryList = selectedObjectFromLocationCategoryList;
    }

    public DefaultSelectedData getSelectedObjectFromStatusList() {
        return selectedObjectFromStatusList;
    }

    public void setSelectedObjectFromStatusList(DefaultSelectedData selectedObjectFromStatusList) {
        this.selectedObjectFromStatusList = selectedObjectFromStatusList;
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
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btnPopupOkDelete_action() {
         if (institutionRegistrationManager.deleteEducationRequest(institutionId))
         {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponenets();
        institutionList = educationRequestManager.getNAmeOfInstitution();
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

    public void makePageReadyForSave() {
        saveOrUpdateLabel = "Save";
        btnDelete.setDisabled(false);
        institutionId = -1;
    }

    public void makePageReadyForUpdate() {
        saveOrUpdateLabel = "Update";
        btnDelete.setDisabled(false);
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    private void clearAllComponenets() {
        clearInstitutionTextComponents();
        resetInstitutionDropDownComponents();
        makePageReadyForSave();
        selectedObjectFromInstitutionList.setSelectedObject(null);
    }

    private void resetInstitutionDropDownComponents() {
        selectedObjectFromLocationCategoryList.setSelectedObject(null);
        selectedObjectFromStatusList.setSelectedObject(null);
        selectedObjectFromAccreditedOrNotList.setSelectedObject(null);
        selectedObjectFromEducationOrTrainingList.setSelectedObject(null);
    }

    public boolean validateAndInitializeAttributes() {
        try {
            contactPerson = txtContactPerson.getValue() == null ? "" : txtContactPerson.getValue().toString();
            institutionDescription = txtDescription.getValue() == null ? "" : txtDescription.getValue().toString();
            emailAddress = txtEmail.getValue() == null ? "" : txtEmail.getValue().toString();
            faxNumber = txtFax.getValue() == null ? "" : txtFax.getValue().toString();
            institutionName = txtName.getValue().toString();
            phoneNomber = txtPhoneNo.getValue() == null ? "" : txtPhoneNo.getValue().toString();
            remark = txtRemark.getValue() == null ? "" : txtRemark.getValue().toString();
            tinNumber = txtTinNo.getValue() == null ? "" : txtTinNo.getValue().toString();
            webSite = txtWebsite.getValue() == null ? "" : txtWebsite.getValue().toString();
            locationCategory = drlLocationCategory.getValue().toString();
            locationDescription = txtaLocationDescription.getValue() == null ? "" : txtaLocationDescription.getValue().toString();
            accreditedOrNot = drlAccreditedOrNot.getValue().toString();
            educationOrTraining = drlEducationOrTraining.getValue().toString();

            status = drlStatus.getValue().toString();
            return true;
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "SOME FIELDS NOT FILLED");
            return false;
        }
    }
//===================================================

    public boolean isEntryValidForSave() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtTinNo.getValue());
        if (!required) {
            ((UIInput) txtTinNo).setValid(false);
            error(txtTinNo, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtaLocationDescription.getValue());
        if (!required) {
            ((UIInput) txtaLocationDescription).setValid(false);
            error(txtaLocationDescription, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtName.getValue());
        if (!required) {
            ((UIInput) txtName).setValid(false);
            error(txtName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.drlAccreditedOrNot.getValue());
        if (!required) {
            ((UIInput) drlAccreditedOrNot).setValid(false);
            error(drlAccreditedOrNot, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.drlEducationOrTraining.getValue());
        if (!required) {
            ((UIInput) drlEducationOrTraining).setValid(false);
            error(drlEducationOrTraining, errorMessage);
            results = false;
        }
         required = HRValidation.validateRequired(this.drlLocationCategory.getValue());
        if (!required) {
            ((UIInput) drlLocationCategory).setValid(false);
            error(drlLocationCategory, errorMessage);
            results = false;
        }
           required = HRValidation.validateRequired(this.drlStatus.getValue());
        if (!required) {
            ((UIInput) drlStatus).setValid(false);
            error(drlStatus, errorMessage);
            results = false;
        }
        return results;
    }
    //============================================

    private void clearInstitutionTextComponents() {
        txtContactPerson.setValue(null);
        txtDescription.setValue(null);
        txtEmail.setValue(null);
        txtFax.setValue(null);
        txtName.setValue(null);
        txtPhoneNo.setValue(null);
        txtRemark.setValue(null);
        txtTinNo.setValue(null);
        txtWebsite.setValue(null);
        txtaLocationDescription.setValue(null);
    }

    private boolean populateInstitutionComponents(int institutionId) {
        institutionModel = institutionRegistrationManager.getInstitution(institutionId);
        if (institutionModel == null) {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        } else {
            if (institutionModel.getInstitutionId() == -1) {
                showSuccessOrFailureMessage(false, "NO INSTITUTION RECOREDED WITH THIS ID : " + institutionId);
                return false;
            } else {
                txtContactPerson.setValue(institutionModel.getContactPerson());
                txtDescription.setValue(institutionModel.getInstitutionDescription());
                txtEmail.setValue(institutionModel.getEmailAddress());
                txtFax.setValue(institutionModel.getFaxNumber());
                txtName.setValue(institutionModel.getInstitutionName());
                txtaLocationDescription.setValue(institutionModel.getLocationDescription());
                txtPhoneNo.setValue(institutionModel.getPhoneNomber());
                txtRemark.setValue(institutionModel.getRemark());
                txtTinNo.setValue(institutionModel.getTinNumber());
                txtWebsite.setValue(institutionModel.getWebSite());
                drlAccreditedOrNot.setValue(institutionModel.getAccreditedOrNot());
                drlEducationOrTraining.setValue(institutionModel.getEducationOrTraining());
                drlLocationCategory.setValue(institutionModel.getLocationCategory());
                drlStatus.setValue(institutionModel.getStatus());
                txtRemark.setValue(institutionModel.getRemark());
                return true;
            }
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
    String saveOrUpdateLabel = "Save";
    EmployeeManage employeeManager = new EmployeeManage();
    InstitutionModel institutionModel = new InstitutionModel();
    InstitutionRegistrationManager institutionRegistrationManager = new InstitutionRegistrationManager();
   EducationRequestManager educationRequestManager= new EducationRequestManager();
    //======================================================================================
    ArrayList<SelectItem> institutionList = educationRequestManager.getNAmeOfInstitution();// institutionRegistrationManager.getAllInstitutions();// new ArrayList<SelectItem>();;
    ArrayList<SelectItem> locationCategoryList = institutionRegistrationManager.getLocationCategoryList();// new ArrayList<SelectItem>();
    ArrayList<SelectItem> statusList = institutionRegistrationManager.getStatusList();// new ArrayList<SelectItem>();
    ArrayList<SelectItem> accreditionList = institutionRegistrationManager.getAccreditionList();// new ArrayList<SelectItem>();
    ArrayList<SelectItem> educationOrTrainingList = institutionRegistrationManager.getEducationOrTrainingList();// new ArrayList<SelectItem>();
    //======================================================================================
    private DefaultSelectedData selectedObjectFromInstitutionList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectFromLocationCategoryList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectFromStatusList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectFromAccreditedOrNotList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectFromEducationOrTrainingList = new DefaultSelectedData();
    //======================================================================================
    int institutionId;
    String institutionName;
    String institutionDescription;
    String educationOrTraining;
    String accreditedOrNot;
    String tinNumber;
    String locationCategory;
    String locationDescription;
    String contactPerson;
    String phoneNomber;
    String emailAddress;
    String faxNumber;
    String webSite;
    String remark;
    String status;
    String userName;
    String timeStamp;
    //======================================================================================

    public String btnSaveOrUpdate_action() {
        if(isEntryValidForSave()){
        if (validateAndInitializeAttributes()) {
            if (saveOrUpdateLabel.equalsIgnoreCase("Save")) {
                if (institutionRegistrationManager.saveInstitution(institutionName, institutionDescription, educationOrTraining, accreditedOrNot, tinNumber, locationCategory, locationDescription, contactPerson, phoneNomber, emailAddress, faxNumber, webSite, remark, status)) {
                    institutionList = null;//institutionRegistrationManager.getAllInstitutions();
                    clearAllComponenets();
                    makePageReadyForSave();
                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED");
                }
            } else {//if (saveOrUpdateLabel.equalsIgnoreCase("Update")) {
                if (institutionRegistrationManager.updateInstitution(institutionId, institutionName, institutionDescription, educationOrTraining, accreditedOrNot, tinNumber, locationCategory, locationDescription, contactPerson, phoneNomber, emailAddress, faxNumber, webSite, remark, status)) {
                    showSuccessOrFailureMessage(true, "UPDATING SUCCESSFUL");
                } else {
                    showSuccessOrFailureMessage(false, "UPDATING FAILED");
                }
            }
        }
        }
        return null;
    }

    public String btnReset_action() {
        clearAllComponenets();
        return null;
    }

    public void selectInstitutionList_processValueChange(ValueChangeEvent vce) {
        institutionId = Integer.parseInt(vce.getNewValue().toString().split("-")[0]);
        populateInstitutionComponents(institutionId);
        makePageReadyForUpdate();
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void txtaLocationDescription_processValueChange(ValueChangeEvent vce) {
    }

    public String txtContactPerson_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtFax_action() {
        //return null means stay on the same page
        return null;
    }
}
