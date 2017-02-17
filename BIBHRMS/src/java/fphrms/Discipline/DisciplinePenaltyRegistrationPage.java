/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright Mekete VS BravoZulu 
 */
package fphrms.Discipline;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import manager.disciplineManager.DisciplinePenaltyRegistrationManager;
import manager.disciplineManager.DisciplineRegistrationManager.DisciplineTypeModel;
import manager.disciplineManager.PenaltyRegistrationManager.PenaltyTypeModel;
import fphrms.Termination.RetireApprovalPage;
import javax.swing.JOptionPane;
import manager.disciplineManager.DisciplineRegistrationManager;
import manager.disciplineManager.DisciplineRegistrationManager.ManagerDisciplineModel;
import manager.disciplineManager.PenaltyRegistrationManager;
import manager.disciplineManager.PenaltyRegistrationManager.ProcessType;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DisciplinePenaltyRegistrationPage extends AbstractPageBean {

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
    private HtmlPanelGroup panelGroupMessageProcess = new HtmlPanelGroup();
    private PanelLayout pnlMainBody = new PanelLayout();
    private HtmlCommandLink btnClosePopupProcessRergistrion = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupProcessRergistrion() {
        return btnClosePopupProcessRergistrion;
    }

    public void setBtnClosePopupProcessRergistrion(HtmlCommandLink btnClosePopupProcessRergistrion) {
        this.btnClosePopupProcessRergistrion = btnClosePopupProcessRergistrion;
    }

    public PanelLayout getPnlMainBody() {
        return pnlMainBody;
    }

    public void setPnlMainBody(PanelLayout pnlMainBody) {
        this.pnlMainBody = pnlMainBody;
    }

    public HtmlPanelGroup getPanelGroupMessageProcess() {
        return panelGroupMessageProcess;
    }

    public void setPanelGroupMessageProcess(HtmlPanelGroup panelGroupMessageProcess) {
        this.panelGroupMessageProcess = panelGroupMessageProcess;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }

    public DefaultSelectedData getSelectedDataOfDeciderType() {
        return selectedDataOfDeciderType;
    }

    public void setSelectedDataOfDeciderType(DefaultSelectedData selectedDataOfDeciderType) {
        this.selectedDataOfDeciderType = selectedDataOfDeciderType;
    }

    public DefaultSelectedData getSelectedDataOfDisciplineType() {
        return selectedDataOfDisciplineType;
    }

    public void setSelectedDataOfDisciplineType(DefaultSelectedData selectedDataOfDisciplineType) {
        this.selectedDataOfDisciplineType = selectedDataOfDisciplineType;
    }

    public ArrayList<Option> getPenaltyTypesListOption() {
        return penaltyTypesListOption;
    }

    public void setPenaltyTypesListOption(ArrayList<Option> penaltyTypesListOption) {
        this.penaltyTypesListOption = penaltyTypesListOption;
    }

    public DefaultSelectedData getSelectedDataOfPenality() {
        return selectedDataOfPenality;
    }

    public void setSelectedDataOfPenality(DefaultSelectedData selectedDataOfPenality) {
        this.selectedDataOfPenality = selectedDataOfPenality;
    }

    public DefaultSelectedData getSelectedDataOfRepition() {
        return selectedDataOfRepition;
    }

    public void setSelectedDataOfRepition(DefaultSelectedData selectedDataOfRepition) {
        this.selectedDataOfRepition = selectedDataOfRepition;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems2 = dsia;
    }
    private HtmlSelectOneMenu drlDisplineType = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu drlDisplineTypeForManager = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDisplineTypeForManager() {
        return drlDisplineTypeForManager;
    }

    public void setDrlDisplineTypeForManager(HtmlSelectOneMenu drlDisplineTypeForManager) {
        this.drlDisplineTypeForManager = drlDisplineTypeForManager;
    }

    public HtmlSelectOneMenu getDrlDisplineType() {
        return drlDisplineType;
    }

    public void setDrlDisplineType(HtmlSelectOneMenu hsom) {
        this.drlDisplineType = hsom;
    }
    private HtmlSelectOneMenu drlRepitition = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRepitition() {
        return drlRepitition;
    }

    public void setDrlRepitition(HtmlSelectOneMenu hsom) {
        this.drlRepitition = hsom;
    }
    private HtmlInputText txtDisciplineCode = new HtmlInputText();

    public HtmlInputText getTxtDisciplineCode() {
        return txtDisciplineCode;
    }

    public void setTxtDisciplineCode(HtmlInputText hit) {
        this.txtDisciplineCode = hit;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
    }
    private HtmlInputTextarea txtaPenalty = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaPenalty() {
        return txtaPenalty;
    }

    public void setTxtaPenalty(HtmlInputTextarea hit) {
        this.txtaPenalty = hit;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlOutputLabel lblSuccessOrErrorMessageDiscipline = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public HtmlOutputLabel getLblSuccessOrErrorMessageDiscipline() {
        return lblSuccessOrErrorMessageDiscipline;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessageDiscipline(HtmlOutputLabel lblSuccessOrErrorMessageDiscipline) {
        this.lblSuccessOrErrorMessageDiscipline = lblSuccessOrErrorMessageDiscipline;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getSelectedPenaltyTypeRow() {
        return selectedPenaltyTypeRow;
    }

    public void setSelectedPenaltyTypeRow(int selectedPenaltyTypeRow) {
        this.selectedPenaltyTypeRow = selectedPenaltyTypeRow;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private HtmlSelectOneMenu drlPenalty = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu drlPenaltyForManger = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPenaltyForManger() {
        return drlPenaltyForManger;
    }

    public void setDrlPenaltyForManger(HtmlSelectOneMenu drlPenaltyForManger) {
        this.drlPenaltyForManger = drlPenaltyForManger;
    }

    public HtmlSelectOneMenu getDrlPenalty() {
        return drlPenalty;
    }

    public void setDrlPenalty(HtmlSelectOneMenu hsom) {
        this.drlPenalty = hsom;
    }
    private DefaultSelectedData defaultSelectedDataDisciplineCategory = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataDisciplineCategory() {
        return defaultSelectedDataDisciplineCategory;
    }

    public void setDefaultSelectedDataDisciplineCategory(DefaultSelectedData defaultSelectedDataDisciplineCategory) {
        this.defaultSelectedDataDisciplineCategory = defaultSelectedDataDisciplineCategory;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private PanelPopup pan_PopUp_Register_Process = new PanelPopup();

    public PanelPopup getPan_PopUp_Register_Process() {
        return pan_PopUp_Register_Process;
    }

    public void setPan_PopUp_Register_Process(PanelPopup pp) {
        this.pan_PopUp_Register_Process = pp;
    }
    private HtmlInputText txt_ProcessID = new HtmlInputText();

    public HtmlInputText getTxt_ProcessID() {
        return txt_ProcessID;
    }

    public void setTxt_ProcessID(HtmlInputText hit) {
        this.txt_ProcessID = hit;
    }
    private HtmlInputText txt_ProcessName = new HtmlInputText();

    public HtmlInputText getTxt_ProcessName() {
        return txt_ProcessName;
    }

    public void setTxt_ProcessName(HtmlInputText hit) {
        this.txt_ProcessName = hit;
    }
    private HtmlInputTextarea inTxt_ProcessDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getInTxt_ProcessDescription() {
        return inTxt_ProcessDescription;
    }

    public void setInTxt_ProcessDescription(HtmlInputTextarea hit) {
        this.inTxt_ProcessDescription = hit;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlInputText txt_SuspendedDuration = new HtmlInputText();

    public HtmlInputText getTxt_SuspendedDuration() {
        return txt_SuspendedDuration;
    }

    public void setTxt_SuspendedDuration(HtmlInputText hit) {
        this.txt_SuspendedDuration = hit;
    }
    private HtmlCommandButton btn_View_ProcessPopUp = new HtmlCommandButton();

    public HtmlCommandButton getBtn_View_ProcessPopUp() {
        return btn_View_ProcessPopUp;
    }

    public void setBtn_View_ProcessPopUp(HtmlCommandButton hcb) {
        this.btn_View_ProcessPopUp = hcb;
    }
    private HtmlSelectOneMenu drl_processType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_processType() {
        return drl_processType;
    }

    public void setDrl_processType(HtmlSelectOneMenu hsom) {
        this.drl_processType = hsom;
    }
    private javax.faces.component.html.HtmlCommandLink btn_remove = new javax.faces.component.html.HtmlCommandLink();

    public javax.faces.component.html.HtmlCommandLink getBtn_remove() {
        return btn_remove;
    }

    public void setBtn_remove(javax.faces.component.html.HtmlCommandLink btn_remove) {
        this.btn_remove = btn_remove;
    }

  
    private HtmlDataTable dataTable = new HtmlDataTable();

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable hdt) {
        this.dataTable = hdt;
    }
    private HtmlCommandButton btn_New = new HtmlCommandButton();

    public HtmlCommandButton getBtn_New() {
        return btn_New;
    }

    public void setBtn_New(HtmlCommandButton hcb) {
        this.btn_New = hcb;
    }
    private javax.faces.component.html.HtmlInputText txt_PromotionDuration = new javax.faces.component.html.HtmlInputText();
    private javax.faces.component.html.HtmlInputText txt_PromotionDurationForManager = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_PromotionDurationForManager() {
        return txt_PromotionDurationForManager;
    }

    public void setTxt_PromotionDurationForManager(javax.faces.component.html.HtmlInputText txt_PromotionDurationForManager) {
        this.txt_PromotionDurationForManager = txt_PromotionDurationForManager;
    }

    public javax.faces.component.html.HtmlInputText getTxt_PromotionDuration() {
        return txt_PromotionDuration;
    }

    public void setTxt_PromotionDuration(javax.faces.component.html.HtmlInputText hit) {
        this.txt_PromotionDuration = hit;
    }
    private javax.faces.component.html.HtmlSelectOneMenu drl_SuspededeTransfer = new javax.faces.component.html.HtmlSelectOneMenu();
    private javax.faces.component.html.HtmlSelectOneMenu drl_SuspededeTransferForManager = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_SuspededeTransferForManager() {
        return drl_SuspededeTransferForManager;
    }

    public void setDrl_SuspededeTransferForManager(javax.faces.component.html.HtmlSelectOneMenu drl_SuspededeTransferForManager) {
        this.drl_SuspededeTransferForManager = drl_SuspededeTransferForManager;
    }

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_SuspededeTransfer() {
        return drl_SuspededeTransfer;
    }

    public void setDrl_SuspededeTransfer(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.drl_SuspededeTransfer = hsom;
    }
    private javax.faces.component.html.HtmlInputText txt_transferDuration = new javax.faces.component.html.HtmlInputText();
    private javax.faces.component.html.HtmlInputText txt_transferDurationForManager = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_transferDurationForManager() {
        return txt_transferDurationForManager;
    }

    public void setTxt_transferDurationForManager(javax.faces.component.html.HtmlInputText txt_transferDurationForManager) {
        this.txt_transferDurationForManager = txt_transferDurationForManager;
    }

    public javax.faces.component.html.HtmlInputText getTxt_transferDuration() {
        return txt_transferDuration;
    }

    public void setTxt_transferDuration(javax.faces.component.html.HtmlInputText hit) {
        this.txt_transferDuration = hit;
    }
    private javax.faces.component.html.HtmlSelectOneMenu drl_suspendedPromotion = new javax.faces.component.html.HtmlSelectOneMenu();
    private javax.faces.component.html.HtmlSelectOneMenu drl_suspendedPromotionForManager = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_suspendedPromotionForManager() {
        return drl_suspendedPromotionForManager;
    }

    public void setDrl_suspendedPromotionForManager(javax.faces.component.html.HtmlSelectOneMenu drl_suspendedPromotionForManager) {
        this.drl_suspendedPromotionForManager = drl_suspendedPromotionForManager;
    }

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_suspendedPromotion() {
        return drl_suspendedPromotion;
    }

    public void setDrl_suspendedPromotion(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.drl_suspendedPromotion = hsom;
    }
    private HtmlCommandButton btnAddToTable = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddToTable() {
        return btnAddToTable;
    }

    public void setBtnAddToTable(HtmlCommandButton hcb) {
        this.btnAddToTable = hcb;
    }
    private HtmlCommandButton btnSaveDisciplinePenalty = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveDisciplinePenalty() {
        return btnSaveDisciplinePenalty;
    }

    public void setBtnSaveDisciplinePenalty(HtmlCommandButton hcb) {
        this.btnSaveDisciplinePenalty = hcb;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems3 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems3 = dsi;
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
    private HtmlSelectOneMenu drl_view_Reptaion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_view_Reptaion() {
        return drl_view_Reptaion;
    }

    public void setDrl_view_Reptaion(HtmlSelectOneMenu hsom) {
        this.drl_view_Reptaion = hsom;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems = dsi;
    }
    private HtmlDataTable dataTableForManager = new HtmlDataTable();

    public HtmlDataTable getDataTableForManager() {
        return dataTableForManager;
    }

    public void setDataTableForManager(HtmlDataTable hdt) {
        this.dataTableForManager = hdt;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DisciplinePenaltyRegistrationPage() {
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
        this.discibleComeponets();

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
    /////////////////////////////////////////////////////////////////////////////////////////
    DisciplinePenaltyRegistrationManager disciplinePenaltyRegistrationManager = new DisciplinePenaltyRegistrationManager();
    PenaltyRegistrationManager penaltyRegistrationManager = new PenaltyRegistrationManager();
    DisciplineRegistrationManager disciplineRegistrationManager = new DisciplineRegistrationManager();
    //===============================================================================================
    ArrayList<Option> disciplineTypes = disciplineRegistrationManager.getAllDesciplineTypesOption();//new ArrayList<Option>();//
    ArrayList<Option> disciplineTypesForManager = disciplineRegistrationManager.getAllDesciplineTypesOptionForManager();//new ArrayList<Option>();//
    ArrayList<Option> repititionTypes = disciplinePenaltyRegistrationManager.getPossibleRepitions();// new ArrayList<Option>();
    ArrayList<Option> repititionTypesForSerach = disciplinePenaltyRegistrationManager.getPossibleRepitionsForSerach();// new ArrayList<Option>();
    ArrayList<Option> processTypes = disciplinePenaltyRegistrationManager.getAllProcessOption();
    ArrayList<Option> deciderTypes = penaltyRegistrationManager.getDeciderTypes();
    ArrayList<Option> penaltyTypesListOption = penaltyRegistrationManager.getAllPenaltyTypesOption();//
    ArrayList<Option> penaltyTypesListOptionForManager = penaltyRegistrationManager.getAllPenaltyTypesOptionForManager();//
    ArrayList<Option> disciplineCategoryOption = disciplineRegistrationManager.getDisciplineCategories();//
    //===============================================================================================
    ArrayList<DisciplineTypeModel> disciplineTypesList = new ArrayList<DisciplineTypeModel>();//for the popup table
    ArrayList<PenaltyTypeModel> penaltyTypesList = new ArrayList<PenaltyTypeModel>();//for the popup table
    ArrayList<ProcessType> ProcessTypesList = new ArrayList<ProcessType>();//for the popup table
    ArrayList<DisciplineTypeModel> disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetail();//new ArrayList<DisciplineTypeModel>();//fpr the main Penalty table
    ArrayList<ManagerDisciplineModel> disciplinePenaltyListForManager = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailForManager();
    public String EMPLOYEE = PenaltyRegistrationManager.EMPLOYEE;
    public String MANAGER = PenaltyRegistrationManager.MANAGER;
    String selectionCondition;

    //===============================================================================================
    private DefaultSelectedData selectedDataOfDeciderType = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfDisciplineType = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfRepition = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfPenality = new DefaultSelectedData();
    int counter = 0;
    int numberOfPenalisedDays;
    //===============================================================================================

    public String btnAddDisciplineType_action() {
        return "DisciplineTypes";
    }

    private void clearDisciplineComponenets() {
        //    drlDeciderType.resetValue();
        drlDisplineType.resetValue();
        drlRepitition.resetValue();
        txtDisciplineCode.setValue(null);
        txtaDescription.setValue(null);
        txtaPenalty.setValue(null);
    }

    private void clearProcessComponet() {
        txt_ProcessID.resetValue();
        txt_ProcessName.resetValue();
        inTxt_ProcessDescription.resetValue();
    }

    public String btnAddToTable_action() {

        if (selectionCondition.equalsIgnoreCase("Employee")) {


            if (validateDiscipline()) {
                String[] displineTypeAttributes = drlDisplineType.getValue().toString().split("--");
                String[] processTypeAttribute = drl_processType.getValue().toString().split("--");

                if (drl_processType.getValue().toString().equals("Transfer")) {
                    processName = "";
                    duration = "";
                    disciplineTypeId = Integer.parseInt(displineTypeAttributes[0]);
                    disciplineTypeCode = displineTypeAttributes[1];
                    disciplineName = displineTypeAttributes[2];
                    repitition = Integer.parseInt(drlRepitition.getValue().toString());
                    processNameTransfer = drl_processType.getValue().toString();
                    durationTransfer = txt_SuspendedDuration.getValue().toString();
                    String[] penaltyAttributes = drlPenalty.getValue().toString().split("--");
                    penaltyTypeId = (penaltyAttributes[0]);
                    penaltyName = penaltyAttributes[1];
                    actionTaker = penaltyAttributes[3];
                    status = "New";

                } else if (drl_processType.getValue().toString().equals("Promotion")) {
                    counter++;
                    processName = processTypeAttribute[0];
                    disciplineTypeId = Integer.parseInt(displineTypeAttributes[0]);
                    disciplineTypeCode = displineTypeAttributes[1];
                    disciplineName = displineTypeAttributes[2];
                    repitition = Integer.parseInt(drlRepitition.getValue().toString());
                    processNameTransfer = "";
                    durationTransfer = "";
                    //processName=Integer.parseInt(drl_processType.getValue().toString());
                    duration = txt_SuspendedDuration.getValue().toString();
                    String[] penaltyAttributes = drlPenalty.getValue().toString().split("--");
                     penaltyTypeId = (penaltyAttributes[0]);
                    penaltyName = penaltyAttributes[1];
                    actionTaker = penaltyAttributes[3];
                    status = "New";
                    selected = false;
                }
                disciplinePenaltyList.add(0, new DisciplineTypeModel(status, counter, disciplineTypeId,disciplineTypeCode, disciplineName, penaltyTypeId, penaltyName, repitition, status, selected, processName, duration, processNameTransfer, durationTransfer));
                btn_remove.setValue("Remove");
            }
        } else if (selectionCondition.equalsIgnoreCase("Manager")) {
                String[] displineTypeAttributes = drlDisplineType.getValue().toString().split("--");
                String[] processTypeAttribute = drl_processType.getValue().toString().split("--");
                String[] penaltyAttributes = drlPenalty.getValue().toString().split("--");
            if (validateDisciplineForManager()) {
               
                if (drl_processType.getValue().toString().equals("Transfer")) {
                    processName = "";
                    duration = "";
                    disciplineTypeId = Integer.parseInt(displineTypeAttributes[0]);
                    disciplineTypeCode = displineTypeAttributes[1];
                    disciplineName = displineTypeAttributes[2];
                    repitition = Integer.parseInt(drlRepitition.getValue().toString());
                    processNameTransfer = drl_processType.getValue().toString();
                    durationTransfer = txt_SuspendedDuration.getValue().toString();
                    penaltyTypeId = (penaltyAttributes[0]);
                    penaltyName = penaltyAttributes[1];
                    actionTaker = penaltyAttributes[2];
                    status = "New";
           
         
                } else if (drl_processType.getValue().toString().equals("Promotion")) {
                    counter++;
                    processName = processTypeAttribute[0];
                    disciplineTypeId = Integer.parseInt(displineTypeAttributes[0]);
                    disciplineTypeCode = displineTypeAttributes[1];
                    disciplineName = displineTypeAttributes[2];
                    repitition = Integer.parseInt(drlRepitition.getValue().toString());
                    processNameTransfer = "";
                    durationTransfer = "";
                    //processName=Integer.parseInt(drl_processType.getValue().toString());
                    duration = txt_SuspendedDuration.getValue().toString();
                    penaltyTypeId = (penaltyAttributes[0]);
                    penaltyName = penaltyAttributes[1];
                    actionTaker = penaltyAttributes[2];
                    status = "New";
                    selected = false;
                }
                disciplinePenaltyListForManager.add(0, new ManagerDisciplineModel(status, counter, disciplineTypeId,disciplineTypeCode, disciplineName, penaltyTypeId, penaltyName, repitition, status, selected, processName, duration, processNameTransfer, durationTransfer));
            }
        }

        return null;

    }

//<editor-fold defaultstate="collapsed" desc ="All Getters and Setters">
    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<Option> getRepititionTypesForSerach() {
        return repititionTypesForSerach;
    }

    public void setRepititionTypesForSerach(ArrayList<Option> repititionTypesForSerach) {
        this.repititionTypesForSerach = repititionTypesForSerach;
    }

    public ArrayList<Option> getDisciplineTypes() {
        return disciplineTypes;
    }

    public void setDisciplineTypes(ArrayList<Option> disciplineTypes) {
        this.disciplineTypes = disciplineTypes;
    }

    public ArrayList<Option> getPenaltyTypesListOptionForManager() {
        return penaltyTypesListOptionForManager;
    }

    public void setPenaltyTypesListOptionForManager(ArrayList<Option> penaltyTypesListOptionForManager) {
        this.penaltyTypesListOptionForManager = penaltyTypesListOptionForManager;
    }

    public ArrayList<Option> getProcessTypes() {
        return processTypes;
    }

    public void setProcessTypes(ArrayList<Option> processTypes) {
        this.processTypes = processTypes;
    }

    public ArrayList<Option> getRepititionTypes() {
        return repititionTypes;
    }

    public String getSelectionCondition() {
        return selectionCondition;
    }

    public void setSelectionCondition(String selectionCondition) {
        this.selectionCondition = selectionCondition;
    }

    public String getEMPLOYEE() {
        return EMPLOYEE;
    }

    public void setEMPLOYEE(String EMPLOYEE) {
        this.EMPLOYEE = EMPLOYEE;
    }

    public String getMANAGER() {
        return MANAGER;
    }

    public void setMANAGER(String MANAGER) {
        this.MANAGER = MANAGER;
    }

    public void setRepititionTypes(ArrayList<Option> repititionTypes) {
        this.repititionTypes = repititionTypes;
    }

    public ArrayList<Option> getDeciderTypes() {
        return deciderTypes;
    }

    public void setDeciderTypes(ArrayList<Option> deciderTypes) {
        this.deciderTypes = deciderTypes;
    }

    public ArrayList<ManagerDisciplineModel> getDisciplinePenaltyListForManager() {
        return disciplinePenaltyListForManager;
    }

    public void setDisciplinePenaltyListForManager(ArrayList<ManagerDisciplineModel> disciplinePenaltyListForManager) {
        this.disciplinePenaltyListForManager = disciplinePenaltyListForManager;
    }

    public ArrayList<Option> getDisciplineTypesForManager() {
        return disciplineTypesForManager;
    }

    public void setDisciplineTypesForManager(ArrayList<Option> disciplineTypesForManager) {
        this.disciplineTypesForManager = disciplineTypesForManager;
    }

    public ArrayList<DisciplineTypeModel> getDisciplinePenaltyList() {
        return disciplinePenaltyList;
    }

    public void setDisciplinePenaltyList(ArrayList<DisciplineTypeModel> disciplinePenaltyList) {
        this.disciplinePenaltyList = disciplinePenaltyList;
    }

    public String getPenaltyTypeId() {
        return penaltyTypeId;
    }

    public void setPenaltyTypeId(String penaltyTypeId) {
        this.penaltyTypeId = penaltyTypeId;
    }

 

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public DisciplineRegistrationManager getDisciplineRegistrationManager() {
        return disciplineRegistrationManager;
    }

    public void setDisciplineRegistrationManager(DisciplineRegistrationManager disciplineRegistrationManager) {
        this.disciplineRegistrationManager = disciplineRegistrationManager;
    }

    public ArrayList<PenaltyTypeModel> getPenaltyTypesList() {
        return penaltyTypesList;
    }

    public void setPenaltyTypesList(ArrayList<PenaltyTypeModel> penaltyTypesList) {
        this.penaltyTypesList = penaltyTypesList;
    }

    public ArrayList<Option> getDisciplineCategoryOption() {
        return disciplineCategoryOption;
    }

    public void setDisciplineCategoryOption(ArrayList<Option> disciplineCategoryOption) {
        this.disciplineCategoryOption = disciplineCategoryOption;
    }

    public ArrayList<DisciplineTypeModel> getDisciplineTypesList() {
        return disciplineTypesList;
    }

    public void setDisciplineTypesList(ArrayList<DisciplineTypeModel> disciplineTypesList) {
        this.disciplineTypesList = disciplineTypesList;
    }

    private boolean validateDiscipline() {
        if (drlPenalty.getValue() == null || drlPenalty.getValue().toString().equals("-1") ||
                drlRepitition.getValue() == null || drlRepitition.getValue().toString().equals("-1") ||
                drlDisplineType.getValue() == null || drlDisplineType.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT PENALITY AND DISPLINETYPE AND REPUTION");
            return false;
        } else {
            if (disciplinePenaltyList != null) {
                int penaltyListSize = disciplinePenaltyList.size();
                for (int current = 0; current < penaltyListSize; current++) {
                    if (((drlDisplineType.getValue().toString().trim().split("--")[0]).equals(Integer.toString(disciplinePenaltyList.get(current).getDisciplineTypeId()))) && ((drlRepitition.getValue().toString().trim().split("--")[0]).equals(Integer.toString(disciplinePenaltyList.get(current).getRepitition()))) && ((drl_processType.getValue().toString().trim().split("--")[0]).equals((disciplinePenaltyList.get(current).getSuspendedFrom()))) && ((drl_processType.getValue().toString().trim().split("--")[0]).equals((disciplinePenaltyList.get(current).getSuspendedTransfer())))) {
                        showSuccessOrFailureMessage(false, "PENALTY ALREADY ALREADY ASSIGNED ");
                        return false;
                    }
                }
                return true;
            }

        }
        return true;

    }
    //========================================================For The Manager====================================================================

    private boolean validateDisciplineForManager() {
        if (drlPenaltyForManger.getValue() == null || drlPenaltyForManger.getValue().toString().equals("-1") ||
                drlRepitition.getValue() == null || drlRepitition.getValue().toString().equals("-1") ||
                drlDisplineTypeForManager.getValue() == null || drlDisplineTypeForManager.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT PENALITY AND DISPLINETYPE AND REPUTION");
            return false;
        } else {
            if (disciplinePenaltyListForManager != null) {
                int penaltyListSize = disciplinePenaltyListForManager.size();
                for (int current = 0; current < penaltyListSize; current++) {
                    if (((drlDisplineTypeForManager.getValue().toString().trim().split("--")[0]).equals(Integer.toString(disciplinePenaltyListForManager.get(current).getDisciplineTypeId()))) && ((drlRepitition.getValue().toString().trim().split("--")[0]).equals(Integer.toString(disciplinePenaltyListForManager.get(current).getRepitition()))) && ((drl_processType.getValue().toString().trim().split("--")[0]).equals((disciplinePenaltyListForManager.get(current).getSuspendedFrom()))) && ((drl_processType.getValue().toString().trim().split("--")[0]).equals((disciplinePenaltyListForManager.get(current).getSuspendedTransfer())))) {
                        showSuccessOrFailureMessage(false, "PENALTY ALREADY ALREADY ASSIGNED ");
                        return false;
                    }
                }
                return true;
            }

        }
        return true;

    }
    //======================================================================================================================================

    public void drlDeciderType_processValueChange(ValueChangeEvent vce) {
    }

    public String btnResetDisciplinePenalty_action() {
        clearDisciplineComponenets();
        disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetail();
        return null;
    }

    public String btnSaveDisciplinePenalty_action() {
        if (selectionCondition.equalsIgnoreCase("Employee"))
        {

            if (disciplinePenaltyRegistrationManager.saveDisciplinePenalty(disciplinePenaltyList)) {
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
            } else {
                showSuccessOrFailureMessage(false, "! SORRRY SAVING FAILED");
            }

        } else if (selectionCondition.equalsIgnoreCase("Manager")) {
            if (disciplinePenaltyRegistrationManager.saveDisciplinePenaltyForManager(disciplinePenaltyListForManager)) {
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
            } else {
                showSuccessOrFailureMessage(false, "! SORRRY SAVING FAILED");
            }


        }
        return null;
    }

    public String lnkDisciplineType_action() {
        return "DisciplineTypes";
    }

    public String lnkPenaltyType_action() {
        return "PenaltyTypes";
    }

    public void drlDisplineType_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            String[] displineTypeAttributes = vce.getNewValue().toString().split("--");
            if (displineTypeAttributes.length > 3) {
                txtaDescription.setValue(displineTypeAttributes[3]);
                txtDisciplineCode.setValue(displineTypeAttributes[1]);
            }
        }
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btnColsePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);//return null means stay on the same page
        return null;
    }

    public void drlPenalty_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            String[] penaltyAttributes = vce.getNewValue().toString().split("--");
            if (penaltyAttributes.length > 2) {
                txtaPenalty.setValue(penaltyAttributes[2]);
            }
        }
    }
    //====================================ForManager================================

    //==============================================================================
    public void txtaPenalty_processValueChange(ValueChangeEvent vce) {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireApprovalPage getTermination$RetireApprovalPage() {
        return (RetireApprovalPage) getBean("Termination$RetireApprovalPage");
    }
    //</editor-fold >
    /////////////////////////////////////////////////////////////////////////////////
    int selectedDisciplineTypeRow = -1;
    int selectedPenaltyTypeRow = -1;

    public String lnkPopupForColumnDelete_action() {
        if (disciplineTypesList.get(selectedDisciplineTypeRow).getStatus().equalsIgnoreCase("New")) {//new
            disciplineTypesList.remove(selectedDisciplineTypeRow);
        } else {//if it is inserted now remove it
            disciplineTypesList.get(selectedDisciplineTypeRow).setStatus("Deleted");
        }
        selectedDisciplineTypeRow = -1;
        return null;
    }
    //=======================================================================================

    public String btnPopupPenaltyForColumnDelete_action() {
        if (penaltyTypesList.get(selectedPenaltyTypeRow).getStatus().equalsIgnoreCase("New")) {//new
            penaltyTypesList.remove(selectedPenaltyTypeRow);
        } else {//if it is inserted now remove it
            penaltyTypesList.get(selectedPenaltyTypeRow).setStatus("Deleted");
        }
        selectedPenaltyTypeRow = -1;
        return null;
    }
    //=======================================================================================

    public void rowSelectorDisciplineType_processMyEvent(RowSelectorEvent rse) {
        if (selectedDisciplineTypeRow != rse.getRow()) {//when new row selected
            selectedDisciplineTypeRow = rse.getRow();
            populateEditableRowOfDisciplineType(disciplineTypesList.get(selectedDisciplineTypeRow));
        } else {//keep it selected
            disciplineTypesList.get(selectedDisciplineTypeRow).setSelected(true);
        }
    }
    //=========================================================================================
    int selectedRowDisciplinePenalty = -1;

    public void rowSelectorDisciplinePenalty_processMyEvent(RowSelectorEvent rse) {
        if (selectedRowDisciplinePenalty != rse.getRow()) {
            selectedRowDisciplinePenalty = rse.getRow();
        } else {
            disciplinePenaltyList.get(selectedRowDisciplinePenalty).setSelected(true);
        }
    //selectedRowDisciplinePenalty = rse.getRow();
    }
    //=========================================================================================
    //==============================RowSelector================================================

    public void rowSelectorDisciplinePenaltyForManager_processMyEvent(RowSelectorEvent rse) {
        int selectedRowDisciplinePenaltyForManager = -1;
        if (selectedRowDisciplinePenaltyForManager != rse.getRow()) {
            selectedRowDisciplinePenaltyForManager = rse.getRow();
        } else {
            disciplinePenaltyListForManager.get(selectedRowDisciplinePenaltyForManager).setSelected(true);
        }
    //selectedRowDisciplinePenalty = rse.getRow();
    }

    //=========================================================================================
    public String cmdLnkRemoveEntry_action() {
        if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getStatus().equals("New")) {
            disciplinePenaltyList.remove(selectedRowDisciplinePenalty);
        } else {
            disciplinePenaltyList.get(selectedRowDisciplinePenalty).setStatus("Deleted");
        }
        return null;
    }
    //=======================================================================================

    public void rowSelectorPenaltyType_processMyEvent(RowSelectorEvent rse) {
        if (selectedPenaltyTypeRow != rse.getRow()) {//when new row selected
            selectedPenaltyTypeRow = rse.getRow();
            populateEditableRowOfPenaltyType(penaltyTypesList.get(selectedPenaltyTypeRow));
        } else {//keep it selected
            penaltyTypesList.get(selectedPenaltyTypeRow).setSelected(true);
        }
    }

    public String btnClosePopupProcessRergistrion_action() {
        // lnkRegisterEyeWitness.setRendered(false);
        pan_PopUp_Register_Process.setRendered(false);
        return null;
    }
    //=======================================================================================
    DisciplineTypeModel tempDisciplineType = new DisciplineTypeModel();
    String disciplineTypeCode = tempDisciplineType.getDisciplineTypeCode();
    String disciplineName = tempDisciplineType.getDisciplineName();
    String description = tempDisciplineType.getDescription();
    String phaseoutPeriod = tempDisciplineType.getPhaseoutPeriod();
    int disciplineTypeId;
    String penaltyTypeId;
    String status;
    String penalty;
    String penalityTransfer;
    String PenalityslaryIncriment;
    String penlityBouns;
    String processName;
    String processNameTransfer = "";
    String penaltyForTransfer;
    String durationTransfer = "";
    String duration;
    boolean selected;
    int repitition;
    //=======================================================================================
    PenaltyTypeModel tempPenaltyType = new PenaltyTypeModel();
    String penaltyTypeCode = tempPenaltyType.getPenaltyTypeCode();
    String penaltyName = tempPenaltyType.getPenaltyName();
    String penaltyDescription = tempPenaltyType.getPenaltyDescription();
    String actionTaker = tempPenaltyType.getActionTaker();
    //=======================================================================================

    public void populateEditableRowOfDisciplineType(DisciplineTypeModel incomingDisciplineType) {
        tempDisciplineType = new DisciplineTypeModel();
        tempDisciplineType = incomingDisciplineType;
        disciplineTypeCode = tempDisciplineType.getDisciplineTypeCode();
        disciplineName = tempDisciplineType.getDisciplineName();
        description = tempDisciplineType.getDescription();
        phaseoutPeriod = tempDisciplineType.getPhaseoutPeriod();
    }
    //=======================================================================================

    public void populateEditableRowOfPenaltyType(PenaltyTypeModel incomingPenaltyType) {
        tempPenaltyType = new PenaltyTypeModel();
        tempPenaltyType = incomingPenaltyType;
        penaltyTypeCode = tempDisciplineType.getDisciplineTypeCode();
        penaltyName = tempDisciplineType.getDisciplineName();
        penaltyDescription = tempDisciplineType.getDescription();
        actionTaker = tempDisciplineType.getPhaseoutPeriod();
    }
    //=======================================================================================/

    //===============================================================================================
    public String cmd_Save_Process_action() {

        String processID = txt_ProcessID.getValue().toString();
        String processName = txt_ProcessName.getValue().toString();
        String processDescription = inTxt_ProcessDescription.getValue().toString();

        if (disciplinePenaltyRegistrationManager.saveProcessType(processID, processName, processDescription)) {
            showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
            clearProcessComponet();
            ProcessTypesList = disciplinePenaltyRegistrationManager.getAllProcessDetaile();
        } else {
            showSuccessOrFailureMessage(false, "! SORRRY SAVING FAILED");
        }
        return null;

    }

    public ArrayList<ProcessType> getProcessTypesList() {
        return ProcessTypesList;
    }

    public void setProcessTypesList(ArrayList<ProcessType> ProcessTypesList) {
        this.ProcessTypesList = ProcessTypesList;
    }
    //===============================================================================================

    public int getSelectedDisciplineTypeRow() {
        return selectedDisciplineTypeRow;
    }

    public void setSelectedDisciplineTypeRow(int selectedDisciplineTypeRow) {
        this.selectedDisciplineTypeRow = selectedDisciplineTypeRow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionTaker() {
        return actionTaker;
    }

    public void setActionTaker(String actionTaker) {
        this.actionTaker = actionTaker;
    }

    public String getPenaltyDescription() {
        return penaltyDescription;
    }

    public void setPenaltyDescription(String penaltyDescription) {
        this.penaltyDescription = penaltyDescription;
    }

    public String getPenaltyName() {
        return penaltyName;
    }

    public void setPenaltyName(String penaltyName) {
        this.penaltyName = penaltyName;
    }

    public String getPenaltyTypeCode() {
        return penaltyTypeCode;
    }

    public void setPenaltyTypeCode(String penaltyTypeCode) {
        this.penaltyTypeCode = penaltyTypeCode;
    }

    public PenaltyTypeModel getTempPenaltyType() {
        return tempPenaltyType;
    }

    public void setTempPenaltyType(PenaltyTypeModel tempPenaltyType) {
        this.tempPenaltyType = tempPenaltyType;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getDisciplineTypeCode() {
        return disciplineTypeCode;
    }

    public void setDisciplineTypeCode(String disciplineTypeCode) {
        this.disciplineTypeCode = disciplineTypeCode;
    }

    public int getDisciplineTypeId() {
        return disciplineTypeId;
    }

    public void setDisciplineTypeId(int disciplineTypeId) {
        this.disciplineTypeId = disciplineTypeId;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public String getPhaseoutPeriod() {
        return phaseoutPeriod;
    }

    public void setPhaseoutPeriod(String phaseoutPeriod) {
        this.phaseoutPeriod = phaseoutPeriod;
    }

    public int getRepitition() {
        return repitition;
    }

    public void setRepitition(int repitition) {
        this.repitition = repitition;
    }

    public DisciplineTypeModel getTempDisciplineType() {
        return tempDisciplineType;
    }

    public void setTempDisciplineType(DisciplineTypeModel tempDisciplineType) {
        this.tempDisciplineType = tempDisciplineType;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="Links">

    public void panelGroupMessage_processMyEvent(DragEvent de) {
    }

    public void panelGroupMessageProcess_processMyEvent(DragEvent de) {
    }

    public String lnkDisciplineRequest_action() {
        return "DisciplineIssue";
    }

    public String lnkDisciplineApprove_action() {
        return "DisciplineApprove";
    }

    public String lnkAccusedDefence_action() {
        return "AccusedDefence";
    }

    public String lnkEyeWitness_action() {
        return "EyeWitness";
    }

    public String lnkCommitteeMembers_action() {
        return "CommitteeMembers";
    }

    public String lnkDisciplinePenalty_action() {
        return "PenaltyTypes";
    }

    public String lnkCommittee_action() {
        return "Committeee";
    }

    public String btnDisciplinePenalty_action() {
        return "DisciplinePenalty";
    }

    public String btnPenaltyType_action() {
        return "PenaltyTypes";
    }

    public String btnAddPenaltyType_action() {
        //return null means stay on the same page
        return "PenaltyTypes";
    }

    public String btn_View_ProcessPopUp_action() {
        pan_PopUp_Register_Process.setRendered(true);
        return null;
    }

    private void discibleComeponets() {
        drlDisplineType.setDisabled(true);
        drlDisplineTypeForManager.setDisabled(true);
        drlPenalty.setDisabled(true);
        drlPenaltyForManger.setDisabled(true);
        drlRepitition.setDisabled(true);
        drl_processType.setDisabled(true);
        txt_SuspendedDuration.setDisabled(true);
        btnSaveDisciplinePenalty.setDisabled(true);
        btnAddToTable.setDisabled(true);
    }

    private void enableComponets() {
        drlDisplineType.setDisabled(false);
        drlDisplineTypeForManager.setDisabled(false);
        drlPenalty.setDisabled(false);
        drlPenaltyForManger.setDisabled(false);
        drlRepitition.setDisabled(false);
        drl_processType.setDisabled(false);
        txt_SuspendedDuration.setDisabled(false);
        btnSaveDisciplinePenalty.setDisabled(false);
        btnAddToTable.setDisabled(false);
    }
    // public int selectedRowOtherEyeWitness;

    public String btn_remove_action() {

        if (selectedRowDisciplinePenalty != -1) {
            if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getSavedStatus().equalsIgnoreCase("New")) {
                disciplinePenaltyList.remove(selectedRowDisciplinePenalty);
            } else {

                if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getRepitition() == 1) {

                    if (disciplinePenaltyRegistrationManager.DisciplinePenalityDetaile(disciplinePenaltyList)) {
                        showSuccessOrFailureMessage(true, "UPDATING SUCCESSFULL");
                        // clearDisciplineComponenets();
                        disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetail();
                    } else {
                        showSuccessOrFailureMessage(false, "! SORRRY UPDATING FAILED");
                    }

                } else if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getRepitition() == 2) {
                    if (disciplinePenaltyRegistrationManager.DisciplinePenalityDetaile(disciplinePenaltyList)) {
                        showSuccessOrFailureMessage(true, "UPDATING SUCCESSFULL");
                        // clearDisciplineComponenets();
                        disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailSecondReputaion();
                    } else {
                        showSuccessOrFailureMessage(false, "! SORRRY UPDATING FAILED");
                    }

                } else if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getRepitition() == 3) {
                    if (disciplinePenaltyRegistrationManager.DisciplinePenalityDetaile(disciplinePenaltyList)) {
                        showSuccessOrFailureMessage(true, "UPDATING SUCCESSFULL");
                        // clearDisciplineComponenets();
                        disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailThiredReputaion();
                    } else {
                        showSuccessOrFailureMessage(false, "! SORRRY UPDATING FAILED");
                    }

                } else if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getRepitition() == 4) {
                    if (disciplinePenaltyRegistrationManager.DisciplinePenalityDetaile(disciplinePenaltyList)) {
                        showSuccessOrFailureMessage(true, "UPDATING SUCCESSFULL");
                        // clearDisciplineComponenets();
                        disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailForthreputaion();
                    } else {
                        showSuccessOrFailureMessage(false, "! SORRRY UPDATING FAILED");
                    }
                } else if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getRepitition() == 5) {
                    if (disciplinePenaltyRegistrationManager.DisciplinePenalityDetaile(disciplinePenaltyList)) {
                        showSuccessOrFailureMessage(true, "UPDATING SUCCESSFULL");
                        // clearDisciplineComponenets();
                        disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailFives();
                    } else {
                        showSuccessOrFailureMessage(false, "! SORRRY UPDATING FAILED");
                    }

                }
            }



        //  return null;



        }
        return null;

    }

    //============================================================================
    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public int selectedRowIndex;

    public void rowSelector1_processAction(RowSelectorEvent rse) {
        selectedRowIndex = rse.getRow();
    }

    public String btn_UPdate_action() {

        if (disciplinePenaltyRegistrationManager.UpdateDisciplinePenalty(disciplinePenaltyList)) {
            for (int i = 0; i < disciplinePenaltyList.size(); i++) {
            }
            showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
            clearDisciplineComponenets();
            disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetail();
        } else {
            showSuccessOrFailureMessage(false, "! SORRRY SAVING FAILED");
        }
        return null;

    }

    public String btn_New_action() {
        //return null means stay on the same page
        this.enableComponets();
        disciplinePenaltyList.clear();
        disciplinePenaltyListForManager.clear();

        return null;
    }

    public void drl_view_Reptaion_processValueChange(ValueChangeEvent vce) {
        int reputaionCondition = Integer.parseInt(vce.getNewValue().toString());

        if (reputaionCondition == 2) {
            disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailSecondReputaion();
            disciplinePenaltyListForManager = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailSecondReputaionForManager();
        } else if (reputaionCondition == 3) {
            disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailThiredReputaion();
            disciplinePenaltyListForManager = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailThiredReputaionForManager();


        } else if (reputaionCondition == 4) {
            disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailForthreputaion();
            disciplinePenaltyListForManager = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailForthreputaionForManager();
        } else if (reputaionCondition == 5) {
            disciplinePenaltyList = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailFives();
            disciplinePenaltyListForManager = disciplinePenaltyRegistrationManager.getAllPenaltyTypesDetailFivesForManager();
        } else {
        }
    }

    public String lnkTxtPopupForColumnDelete_action() {
        if (selectedRowDisciplinePenalty != -1) {
            if (disciplinePenaltyList.get(selectedRowDisciplinePenalty).getStatus().equalsIgnoreCase("New")) {//new
                disciplinePenaltyList.remove(selectedRowDisciplinePenalty);
            } else {//if it is inserted now remove it
                disciplinePenaltyList.get(selectedRowDisciplinePenalty).setStatus("Deleted");
            }
            selectedRowDisciplinePenalty = -1;
            if (disciplinePenaltyRegistrationManager.DeleteDiscipline(disciplinePenaltyList)) {
                showSuccessOrFailureMessage(true, "DELETING IS SUCCESSFULL");

            } else {

                showSuccessOrFailureMessage(false, "! SORRRY DELETING FAILED");

            }

        }
        return null;
    }

    public void selectOneRadio1_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals(EMPLOYEE)) {
            dataTableForManager.setRendered(false);
            drlDisplineTypeForManager.setRendered(false);
            drlDisplineType.setRendered(true);
            drlPenaltyForManger.setRendered(false);
            drlPenalty.setRendered(true);
            dataTable.setRendered(true);
            selectionCondition = "Employee";
        } else if (vce.getNewValue().toString().equals(MANAGER)) {
            dataTable.setRendered(false);
            drlDisplineType.setRendered(false);
            drlDisplineTypeForManager.setRendered(true);
            drlPenalty.setRendered(false);
            drlPenaltyForManger.setRendered(true);
            dataTableForManager.setRendered(true);
            selectionCondition = "Manager";
        }
    }

    public void drlDisplineTypeForManager_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            String[] displineTypeAttributes = vce.getNewValue().toString().split("--");
            if (displineTypeAttributes.length > 3) {
                txtaDescription.setValue(displineTypeAttributes[3]);
                txtDisciplineCode.setValue(displineTypeAttributes[1]);
            }
        }

    }

    public void drlPenaltyForManger_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            String[] penaltyAttributes = vce.getNewValue().toString().split("--");
            if (penaltyAttributes.length > 2) {
                txtaPenalty.setValue(penaltyAttributes[2]);
            }
        }

    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }
    // </editor-fold >
}
