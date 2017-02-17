/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete VS BravoZulu
 */
package fphrms.Discipline;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
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
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import manager.disciplineManager.PenaltyRegistrationManager.PenaltyTypeModel;
import fphrms.Termination.RetireApprovalPage;
import manager.disciplineManager.DisciplinePenaltyRegistrationManager;
import manager.disciplineManager.DisciplineRegistrationManager;
import manager.disciplineManager.DisciplineRegistrationManager.DisciplineTypeModel;
import manager.disciplineManager.PenaltyRegistrationManager;
import manager.disciplineManager.PenaltyRegistrationManager.ManagerPenality;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PenalityTypesRegistrationPage extends AbstractPageBean {

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
    private HtmlInputTextarea txtaPenalty = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaPenalty() {
        return txtaPenalty;
    }
   public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setTxtaPenalty(HtmlInputTextarea hit) {
        this.txtaPenalty = hit;
    }
    private HtmlInputText txtPopupDescplineId = new HtmlInputText();

    public HtmlInputText getTxtPopupDescplineId() {
        return txtPopupDescplineId;
    }

    public void setTxtPopupDescplineId(HtmlInputText hit) {
        this.txtPopupDescplineId = hit;
    }
    private HtmlInputText txtPopupDesciplineName = new HtmlInputText();

    public HtmlInputText getTxtPopupDesciplineName() {
        return txtPopupDesciplineName;
    }

    public void setTxtPopupDesciplineName(HtmlInputText hit) {
        this.txtPopupDesciplineName = hit;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlOutputLabel lblSuccessOrErrorMessagePenalty = new HtmlOutputLabel();
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

    public HtmlOutputLabel getLblSuccessOrErrorMessagePenalty() {
        return lblSuccessOrErrorMessagePenalty;
    }

    public void setLblSuccessOrErrorMessagePenalty(HtmlOutputLabel lblSuccessOrErrorMessagePenalty) {
        this.lblSuccessOrErrorMessagePenalty = lblSuccessOrErrorMessagePenalty;
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
    private HtmlInputTextarea txtaPopupDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaPopupDescription() {
        return txtaPopupDescription;
    }

    public void setTxtaPopupDescription(HtmlInputTextarea hit) {
        this.txtaPopupDescription = hit;
    }
    private HtmlInputText txtPopupPhaseoutTime = new HtmlInputText();

    public HtmlInputText getTxtPopupPhaseoutTime() {
        return txtPopupPhaseoutTime;
    }

    public void setTxtPopupPhaseoutTime(HtmlInputText hit) {
        this.txtPopupPhaseoutTime = hit;
    }
    private HtmlInputText txtPopupDesciplineCode = new HtmlInputText();

    public HtmlInputText getTxtPopupDesciplineCode() {
        return txtPopupDesciplineCode;
    }

    public void setTxtPopupDesciplineCode(HtmlInputText hit) {
        this.txtPopupDesciplineCode = hit;
    }

   
    private HtmlCommandButton btnPopupResetPenalty = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopupResetPenalty() {
        return btnPopupResetPenalty;
    }

    public void setBtnPopupResetPenalty(HtmlCommandButton btnPopupResetPenalty) {
        this.btnPopupResetPenalty = btnPopupResetPenalty;
    }

   
    private HtmlCommandButton btnPopupSavePenalty = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopupSavePenalty() {
        return btnPopupSavePenalty;
    }

    public void setBtnPopupSavePenalty(HtmlCommandButton hcb) {
        this.btnPopupSavePenalty = hcb;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private HtmlInputText txtPenaltyCode = new HtmlInputText();

    public HtmlInputText getTxtPenaltyCode() {
        return txtPenaltyCode;
    }

    public void setTxtPenaltyCode(HtmlInputText hit) {
        this.txtPenaltyCode = hit;
    }
    private HtmlInputText txtPenaltyName = new HtmlInputText();

    public HtmlInputText getTxtPenaltyName() {
        return txtPenaltyName;
    }

    public void setTxtPenaltyName(HtmlInputText hit) {
        this.txtPenaltyName = hit;
    }
    private HtmlInputTextarea txtaPenaltyDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaPenaltyDescription() {
        return txtaPenaltyDescription;
    }

    public void setTxtaPenaltyDescription(HtmlInputTextarea hit) {
        this.txtaPenaltyDescription = hit;
    }
    private HtmlSelectOneMenu drlPenaltyActionTaker = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPenaltyActionTaker() {
        return drlPenaltyActionTaker;
    }

    public void setDrlPenaltyActionTaker(HtmlSelectOneMenu hsom) {
        this.drlPenaltyActionTaker = hsom;
    }
    private DefaultSelectedData defaultSelectedDataDisciplineCategory = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataDisciplineCategory() {
        return defaultSelectedDataDisciplineCategory;
    }

    public void setDefaultSelectedDataDisciplineCategory(DefaultSelectedData defaultSelectedDataDisciplineCategory) {
        this.defaultSelectedDataDisciplineCategory = defaultSelectedDataDisciplineCategory;
    }
    private HtmlSelectOneMenu drlDisciplineCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDisciplineCategory() {
        return drlDisciplineCategory;
    }

    public void setDrlDisciplineCategory(HtmlSelectOneMenu hsom) {
        this.drlDisciplineCategory = hsom;
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
    private HtmlInputText txtNumberOfpenaltyDays = new HtmlInputText();

    public HtmlInputText getTxtNumberOfpenaltyDays() {
        return txtNumberOfpenaltyDays;
    }

    public void setTxtNumberOfpenaltyDays(HtmlInputText hit) {
        this.txtNumberOfpenaltyDays = hit;
    }
    private HtmlSelectBooleanCheckbox ckbPopupPenaltyNumberOfDays = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbPopupPenaltyNumberOfDays() {
        return ckbPopupPenaltyNumberOfDays;
    }

    public void setCkbPopupPenaltyNumberOfDays(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbPopupPenaltyNumberOfDays = hsbc;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private UISelectItems drltableActionTaken = new UISelectItems();
    private UISelectItems drltableActionTakenManager = new UISelectItems();

    public UISelectItems getDrltableActionTakenManager() {
        return drltableActionTakenManager;
    }

    public void setDrltableActionTakenManager(UISelectItems drltableActionTakenManager) {
        this.drltableActionTakenManager = drltableActionTakenManager;
    }

    public UISelectItems getDrltableActionTaken() {
        return drltableActionTaken;
    }

    public void setDrltableActionTaken(UISelectItems uisi) {
        this.drltableActionTaken = uisi;
    }
    private HtmlSelectOneMenu drlPopupForColumnActionTakeen = new HtmlSelectOneMenu();
   private HtmlSelectOneMenu drlPopupForColumnActionTakeenManager = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPopupForColumnActionTakeenManager() {
        return drlPopupForColumnActionTakeenManager;
    }

    public void setDrlPopupForColumnActionTakeenManager(HtmlSelectOneMenu drlPopupForColumnActionTakeenManager) {
        this.drlPopupForColumnActionTakeenManager = drlPopupForColumnActionTakeenManager;
    }

    public HtmlSelectOneMenu getDrlPopupForColumnActionTakeen() {
        return drlPopupForColumnActionTakeen;
    }

    public void setDrlPopupForColumnActionTakeen(HtmlSelectOneMenu hsom) {
        this.drlPopupForColumnActionTakeen = hsom;
    }
    private HtmlSelectOneMenu drlActionTAken = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlActionTAken() {
        return drlActionTAken;
    }

    public void setDrlActionTAken(HtmlSelectOneMenu hsom) {
        this.drlActionTAken = hsom;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private HtmlSelectOneMenu drlPenaltyFor = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPenaltyFor() {
        return drlPenaltyFor;
    }

    public void setDrlPenaltyFor(HtmlSelectOneMenu hsom) {
        this.drlPenaltyFor = hsom;
    }
    private HtmlInputText txt_Deduction_Duration = new HtmlInputText();

    public HtmlInputText getTxt_Deduction_Duration() {
        return txt_Deduction_Duration;
    }

    public void setTxt_Deduction_Duration(HtmlInputText hit) {
        this.txt_Deduction_Duration = hit;
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
    private HtmlDataTable dataTablePenalty = new HtmlDataTable();
     private HtmlDataTable dataTablePenaltyForManager = new HtmlDataTable();

    public HtmlDataTable getDataTablePenaltyForManager() {
        return dataTablePenaltyForManager;
    }

    public void setDataTablePenaltyForManager(HtmlDataTable dataTablePenaltyForManager) {
        this.dataTablePenaltyForManager = dataTablePenaltyForManager;
    }

    public HtmlDataTable getDataTablePenalty() {
        return dataTablePenalty;
    }

    public void setDataTablePenalty(HtmlDataTable hdt) {
        this.dataTablePenalty = hdt;
    }
   
   

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PenalityTypesRegistrationPage() {
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
        txt_Deduction_Duration.setDisabled(true);
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
    PenaltyRegistrationManager penaltyRegistrationManager = new PenaltyRegistrationManager();
    DisciplineRegistrationManager disciplineRegistrationManager = new DisciplineRegistrationManager();
    DisciplinePenaltyRegistrationManager disciplinePenaltyRegistrationManager = new DisciplinePenaltyRegistrationManager();
    ArrayList<Option> disciplineTypes = disciplineRegistrationManager.getAllDesciplineTypesOption();//new ArrayList<Option>();//
    ArrayList<Option> repititionTypes = disciplinePenaltyRegistrationManager.getPossibleRepitions();// new ArrayList<Option>();
    ArrayList<Option> deciderTypes = penaltyRegistrationManager.getDeciderTypes();
    ArrayList<Option> forWhomdecide = penaltyRegistrationManager.getForWhomDecide();
    ArrayList<Option> PenaltyFor=penaltyRegistrationManager.getPenalityFor();
    ArrayList<Option> penaltyTypesListOption = penaltyRegistrationManager.getAllPenaltyTypesOption();//
    ArrayList<Option> disciplineCategoryOption = disciplineRegistrationManager.getDisciplineCategories();//
   public String EMPLOYEE = PenaltyRegistrationManager.EMPLOYEE;
    public String MANAGER = PenaltyRegistrationManager.MANAGER;

    ArrayList<PenaltyTypeModel> penaltyTypesList = penaltyRegistrationManager.getAllPenaltyTypes();

    ArrayList<ManagerPenality> managerPenalityList=penaltyRegistrationManager.getAllManagerPenaltyTypes();
    //ArrayList<>//penaltyTypesList = new ArrayList<PenaltyTypeModel>();//for the popup table
    //  ArrayList<DisciplineTypeModel> disciplinePenaltyList = penaltyRegistrationManager.getAllPenaltyTypesDetail();//new ArrayList<DisciplineTypeModel>();//fpr the main Penalty table
    private DefaultSelectedData selectedDataOfDeciderType = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfDisciplineType = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfRepition = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfPenality = new DefaultSelectedData();

    int counter = 0;
    float deductionamount;
    boolean selected=true;


    private void clearPopupDisciplineTypeTextComponenents() {
        txtPopupDesciplineName.setValue(null);
        txtPopupDesciplineCode.setValue(null);
        txtaPopupDescription.setValue(null);
    }

    private void clearPopupPenaltyTypeTextComponenents() {
        txtPenaltyCode.setValue(null);
        txtPenaltyName.setValue(null);
        txtaPopupDescription.setValue(null);
    }

//<editor-fold defaultstate="collapsed" desc ="All Getters and Setters">
    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<ManagerPenality> getManagerPenalityList() {
        return managerPenalityList;
    }

    public void setManagerPenalityList(ArrayList<ManagerPenality> managerPenalityList) {
        this.managerPenalityList = managerPenalityList;
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

    public ArrayList<Option> getPenaltyFor() {
        return PenaltyFor;
    }

    public void setPenaltyFor(ArrayList<Option> PenaltyFor) {
        this.PenaltyFor = PenaltyFor;
    }

    public ArrayList<Option> getDisciplineTypes() {
        return disciplineTypes;
    }

    public void setDisciplineTypes(ArrayList<Option> disciplineTypes) {
        this.disciplineTypes = disciplineTypes;
    }

    public ArrayList<Option> getRepititionTypes() {
        return repititionTypes;
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

    public ArrayList<Option> getForWhomdecide() {
        return forWhomdecide;
    }

    public void setForWhomdecide(ArrayList<Option> forWhomdecide) {
        this.forWhomdecide = forWhomdecide;
    }

    public int getPenaltyTypeId() {
        return penaltyTypeId;
    }

    public void setPenaltyTypeId(int penaltyTypeId) {
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

    public float getDeductionamount() {
        return deductionamount;
    }

    public void setDeductionamount(float deductionamount) {
        this.deductionamount = deductionamount;
    }

   
    public PenaltyRegistrationManager getPenaltyRegistrationManager() {
        return penaltyRegistrationManager;
    }

    public void setPenaltyRegistrationManager(PenaltyRegistrationManager penaltyRegistrationManager) {
        this.penaltyRegistrationManager = penaltyRegistrationManager;
    }

    public int getSelectedRowDisciplinePenalty() {
        return selectedRowDisciplinePenalty;
    }

    public void setSelectedRowDisciplinePenalty(int selectedRowDisciplinePenalty) {
        this.selectedRowDisciplinePenalty = selectedRowDisciplinePenalty;
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

    private boolean validatePenaltyType() {
        if (txtPenaltyCode.getValue() == null || txtPenaltyCode.getValue().toString().equals("") ||
                txtPenaltyName.getValue() == null || txtPenaltyName.getValue().toString().equals("")) {
            return false;
        }else if(txt_Deduction_Duration.getValue() == null || txt_Deduction_Duration.getValue().toString().equals("")){
             showSuccessOrFailureMessage(false, "DEDUCTION DURATION IS REQUIRED ");
            return false;}
        else if (drlPenaltyActionTaker.getValue() == null || drlPenaltyActionTaker.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "ACTION TAKER IS REQUIRED ");
            return false;
        } else if (ckbPopupPenaltyNumberOfDays.isSelected()&& (txtNumberOfpenaltyDays.getValue() == null || txtNumberOfpenaltyDays.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "NUMBER OF PENALISED DAY REQUIRED");
            return false;
        } else {
//            try {
//                numberOfPenalisedDays = Integer.parseInt(txtNumberOfpenaltyDays.getValue().toString());
//                if (numberOfPenalisedDays > 31 || numberOfPenalisedDays < 0) {
//                    showSuccessOrFailureMessage(false, "NUMBER OF PENALISED DAY REQUIRED");
//                    return false;
//                }
//            } catch (NumberFormatException nfe) {
//                showSuccessOrFailureMessage(false, "!INVALID NUMBER OF DAYS MIN 0 MAX 31");
//                return false;
//            }
            penaltyTypeCode = txtPenaltyCode.getValue().toString();
            penaltyName = txtPenaltyName.getValue().toString();
            for (PenaltyTypeModel checkAvailable : penaltyTypesList) {
                if (checkAvailable.getPenaltyTypeCode().equals(penaltyTypeCode) || checkAvailable.getPenaltyName().equals(penaltyName)) {
                    showSuccessOrFailureMessage(false, "PENALTY ALREADY EXISTS.\n CHECK CODE AND/OR NAME OF PENALTY");
                    return false;
                }
            }
            return true;
        }
    }

    public String btnAddPenaltyToTable_action() {
        if(selectionCondition.equalsIgnoreCase("Employee"))
          {
         
        if (validatePenaltyType())
                {
            penaltyName = txtPenaltyName.getValue().toString();
            penaltyTypeCode = txtPenaltyCode.getValue().toString();
            penaltyDescription = txtaPenaltyDescription.getValue().toString();
            penalityFor=drlPenaltyFor.getValue().toString();
            actionTaker = drlPenaltyActionTaker.getValue().toString();
            actionTaken=drlActionTAken.getValue().toString();
            deductionduration=Integer.parseInt(txt_Deduction_Duration.getValue().toString());
            status = "New";
            deductionamount = Integer.parseInt(txtNumberOfpenaltyDays.getValue().toString());
            counter = penaltyTypesList.size();
            penaltyTypesList.add(0, new PenaltyTypeModel(counter, penaltyTypeCode, penaltyName, deductionamount, penaltyDescription,penalityFor, actionTaker, status, false,actionTaken,deductionduration));
                    }

        }
        else if(selectionCondition.equalsIgnoreCase("Manager"))
        {
            penaltyName = txtPenaltyName.getValue().toString();
            penaltyTypeCode = txtPenaltyCode.getValue().toString();
            penaltyDescription = txtaPenaltyDescription.getValue().toString();
            penalityFor=drlPenaltyFor.getValue().toString();
            actionTaker = drlPenaltyActionTaker.getValue().toString();
            actionTaken=drlActionTAken.getValue().toString();
            deductionduration=Integer.parseInt(txt_Deduction_Duration.getValue().toString());
            status = "New";
            deductionamount = Integer.parseInt(txtNumberOfpenaltyDays.getValue().toString());
            counter = penaltyTypesList.size();
            managerPenalityList.add(0, new ManagerPenality(counter, penaltyTypeCode, penaltyName, deductionamount, penaltyDescription,penalityFor, actionTaker, status, false,actionTaken,deductionduration));

        }

        return null;
    }

    public String btnClosePopupPenalty_action() {

        // pnlPopupInsertPenaltyType.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void drlDeciderType_processValueChange(ValueChangeEvent vce) {
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public String lnkDisciplineType_action() {
        return "DisciplineTypes";
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

    public String lnkDisciplineRequest_action() {
        return "DisciplineIssue";
    }

    public String lnkCommitteeMembers_action() {
        return "CommitteeMembers";
    }

    public String lnkDisciplinePenalty_action() {
        return "DisciplinePenalty";
    }

    public String lnkCommittee_action() {
        return "Committeee";
    }

    public String lnkDisciplineApprove_action() {
        return "DisciplineApprove";
    }

    public String btnAddPenaltyType_action() {
        penaltyTypesList = penaltyRegistrationManager.getAllPenaltyTypes();
        //  pnlPopupInsertPenaltyType.setRendered(true);
        return null;
    }

    public int getSelectedPenaltyTypeRow() {
        return selectedPenaltyTypeRow;
    }

    public void setSelectedPenaltyTypeRow(int selectedPenaltyTypeRow) {
        this.selectedPenaltyTypeRow = selectedPenaltyTypeRow;
    }

    public String btnPopupResetPenalty_action() {
        clearPopupPenaltyTypeTextComponenents();
        penaltyTypesList = penaltyRegistrationManager.getAllPenaltyTypes();
        return null;
    }

    public String btnPopupSavePenalty_action()
           {
   if(selectionCondition.equalsIgnoreCase("Employee"))
         {
    if (penaltyRegistrationManager.savePenaltyType(penaltyTypesList)){
            clearPopupDisciplineTypeTextComponenents();
            penaltyTypesList = penaltyRegistrationManager.getAllPenaltyTypes();
            // disciplinePenaltyList = penaltyRegistrationManager.getAllPenaltyTypesDetail();
            showSuccessOrFailureMessage(true, "   SAVING OKAY");
        } else {
            showSuccessOrFailureMessage(false, "! SORRRY SAVING FAILED");
        }
   }else if(selectionCondition.equalsIgnoreCase("Manager")){
     if (penaltyRegistrationManager.savePenaltyTypeForManager(managerPenalityList)){
            clearPopupDisciplineTypeTextComponenents();
             managerPenalityList = penaltyRegistrationManager.getAllManagerPenaltyTypes();
            // disciplinePenaltyList = penaltyRegistrationManager.getAllPenaltyTypesDetail();
            showSuccessOrFailureMessage(true, "   SAVING OKAY");
        } else {
            showSuccessOrFailureMessage(false, "! SORRRY SAVING FAILED");
        }

   }
        return null;
              }

    public void drlPenalty_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue()!= null) {
            String[] penaltyAttributes = vce.getNewValue().toString().split("--");
            if (penaltyAttributes.length > 2) {
                txtaPenalty.setValue(penaltyAttributes[2]);
            }
        }
    }


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
    //int selectedDisciplineTypeRow = -1;
    int selectedPenaltyTypeRow = -1;
    int selectedManagerPenaltyRow=-1;

    public String btnPopupPenaltyForColumnDelete_action() {
        if (selectedPenaltyTypeRow != -1) {
            if (penaltyTypesList.get(selectedPenaltyTypeRow).getStatus().equalsIgnoreCase("New")) {//new
                penaltyTypesList.remove(selectedPenaltyTypeRow);
            } else {//if it is inserted now remove it
                penaltyTypesList.get(selectedPenaltyTypeRow).setStatus("Deleted");
            }
            selectedPenaltyTypeRow = -1;
        }
        return null;
    }

    int selectedRowDisciplinePenalty = -1;

    public void rowSelectorDisciplinePenalty_processMyEvent(RowSelectorEvent rse) {
        selectedRowDisciplinePenalty = rse.getRow();
    }

    DisciplineTypeModel tempDisciplineType = new DisciplineTypeModel();
    String disciplineTypeCode = tempDisciplineType.getDisciplineTypeCode();
    String disciplineName = tempDisciplineType.getDisciplineName();
    String description = tempDisciplineType.getDescription();
    String phaseoutPeriod = tempDisciplineType.getPhaseoutPeriod();
    int disciplineTypeId;
    int penaltyTypeId;
    String status;
    String penalty;
    int repitition;
    PenaltyTypeModel tempPenaltyType = new PenaltyTypeModel();
    String penaltyTypeCode = tempPenaltyType.getPenaltyTypeCode();
    String penaltyName = tempPenaltyType.getPenaltyName();
    String penaltyDescription = tempPenaltyType.getPenaltyDescription();
    String penalityFor=tempPenaltyType.getPenalityFor();
    String actionTaker = tempPenaltyType.getActionTaker();
    String actionTaken=tempPenaltyType.getActionTaken();
    int deductionduration =tempPenaltyType.getDeductionDuration();
    String selectionCondition;
    //double amountTaken;

    public void populateEditableRowOfPenaltyType(PenaltyTypeModel incomingPenaltyType) {
//        tempPenaltyType = new PenaltyTypeModel();
//        tempPenaltyType = incomingPenaltyType;
//        penaltyTypeCode = tempDisciplineType.getDisciplineTypeCode();
//        penaltyName = tempDisciplineType.getDisciplineName();
//        penaltyDescription = tempDisciplineType.getDescription();
//        actionTaker = tempDisciplineType.getPhaseoutPeriod();
    }
    //=======================================================================================/

    public String btnPopupPenaltyForColumnEdit_action() {
        if (!penaltyTypesList.get(selectedPenaltyTypeRow).getStatus().equalsIgnoreCase("New")) {
            penaltyTypesList.get(selectedPenaltyTypeRow).setStatus("Edited");
        }
        return null;
    }

    public String getSelectionCondition() {
        return selectionCondition;
    }

    public void setSelectionCondition(String selectionCondition) {
        this.selectionCondition = selectionCondition;
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

   

    public void ckbPopupPenaltyNumberOfDays_processValueChange(ValueChangeEvent vce) {
        if (ckbPopupPenaltyNumberOfDays.isSelected()) {
            txtNumberOfpenaltyDays.setDisabled(false);
            txt_Deduction_Duration.setDisabled(false);
            txtNumberOfpenaltyDays.setValue("0");
            txt_Deduction_Duration.setValue("0");
        } else {
            txtNumberOfpenaltyDays.setDisabled(true);
            txt_Deduction_Duration.setDisabled(true);
            txtNumberOfpenaltyDays.setValue("0");
            txt_Deduction_Duration.setValue("0");
        }
    }

    public void drlPenaltyActionTaken_processValueChange(ValueChangeEvent vce) {
    }

    public void drlPenaltyActionTaker_processValueChange(ValueChangeEvent vce) {
    }

    public void drlActionTAken_processValueChange(ValueChangeEvent vce) {
    }

   

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
   

    public void rowSelector1Penalitytype_processMyEvent(RowSelectorEvent rse) {
         if (selectedPenaltyTypeRow != rse.getRow()) {//when new row selected
            selectedPenaltyTypeRow = rse.getRow();
           penaltyTypesList.get(selectedPenaltyTypeRow).setSelected(true);
        } else {//keep it selected
            penaltyTypesList.get(selectedPenaltyTypeRow).setSelected(true);
        }
    }
    //----------------------------ForManager---------------------------------------------------------------------------
    public void rowSelector1PenalitytypeManager_processMyEvent(RowSelectorEvent rse) {
         if (selectedManagerPenaltyRow != rse.getRow()) {//when new row selected
            selectedManagerPenaltyRow = rse.getRow();
           managerPenalityList.get(selectedManagerPenaltyRow).setSelected(true);
        } else {//keep it selected
            managerPenalityList.get(selectedManagerPenaltyRow).setSelected(true);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
    //----------------------------------------ManagerEdite-------------------------------------------------------------
     public String btnPopupForColumnDisciplineEditManager_action() {

          if (selectedManagerPenaltyRow != -1) {
            managerPenalityList.get(selectedManagerPenaltyRow).setSelected(false);
            if (!managerPenalityList.get(selectedManagerPenaltyRow).getStatus().equalsIgnoreCase("New")) {
                managerPenalityList.get(selectedManagerPenaltyRow).setStatus("Edited");
            }
            selectedManagerPenaltyRow = -1;
        }
        return null;

    }
    //-----------------------------------------------------------------------------------------------------------------

    public String btnPopupForColumnDisciplineEdit_action() {

          if (selectedPenaltyTypeRow != -1) {
            penaltyTypesList.get(selectedPenaltyTypeRow).setSelected(false);
            if (!penaltyTypesList.get(selectedPenaltyTypeRow).getStatus().equalsIgnoreCase("New")) {
                penaltyTypesList.get(selectedPenaltyTypeRow).setStatus("Edited");
            }
            selectedPenaltyTypeRow = -1;
        }
        return null;

    }
    //---------------------------------------ManagerPenality----------------------------------------------------
    public String lnkTxtPopupForManagerColumnDelete_action() {
        if (selectedManagerPenaltyRow != -1) {
            if (managerPenalityList.get(selectedManagerPenaltyRow).getStatus().equalsIgnoreCase("New")) {//new
                managerPenalityList.remove(selectedManagerPenaltyRow);
            } else {//if it is inserted now remove it
                managerPenalityList.get(selectedManagerPenaltyRow).setStatus("Deleted");
            }
            selectedManagerPenaltyRow = -1;
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------------------

    public String lnkTxtPopupForColumnDelete_action() {
        if (selectedPenaltyTypeRow != -1) {
            if (penaltyTypesList.get(selectedPenaltyTypeRow).getStatus().equalsIgnoreCase("New")) {//new
                penaltyTypesList.remove(selectedPenaltyTypeRow);
            } else {//if it is inserted now remove it
                penaltyTypesList.get(selectedPenaltyTypeRow).setStatus("Deleted");
            }
            selectedPenaltyTypeRow = -1;
        }
        return null;
    }

    public void selectOneRadio1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue().toString().equals(EMPLOYEE)){

        dataTablePenalty.setRendered(true);
         dataTablePenaltyForManager.setRendered(false);
        selectionCondition="Employee";
        }else if(vce.getNewValue().toString().equals(MANAGER)){
        dataTablePenalty.setRendered(false);
        dataTablePenaltyForManager.setRendered(true);
        selectionCondition="Manager";

        }

    }

    

    

    ////////////////////////////////////////////////////////////////////////////////////////
}
