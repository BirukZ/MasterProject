/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Questionnaire;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.paneltabset.PanelTabSet;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.questionnaire.AllQuestionsManager;
import manager.questionnaire.DefineQuestionnaireManager;
import manager.questionnaire.QuestionOptionsManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ManageQuestions.java
 * @version Created on Oct 21, 2011, 8:36:53 AM
 * @author Bini
 */
public class ManageQuestions extends AbstractPageBean {

    QuestionOptionsManager optionManager = new QuestionOptionsManager();
    AllQuestionsManager allQuestionsManager = new AllQuestionsManager();
    DefineQuestionnaireManager defQuesMnger = new DefineQuestionnaireManager();
    ArrayList<QuestionOptionsManager> optionManagerList = new ArrayList<QuestionOptionsManager>();
    ArrayList<AllQuestionsManager> allQuestionList = new ArrayList<AllQuestionsManager>();
    ArrayList<AllQuestionsManager> questTblList = new ArrayList<AllQuestionsManager>();
    ArrayList<AllQuestionsManager> questColList = new ArrayList<AllQuestionsManager>();
    ArrayList<SelectItem> questSection = new ArrayList<SelectItem>();
    ArrayList<SelectItem> questType = new ArrayList<SelectItem>();
    ArrayList<SelectItem> columnType = new ArrayList<SelectItem>();
    ArrayList<SelectItem> groupList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> definedQuesList = new ArrayList<SelectItem>();
    private int selectedRowIndexOption = -1;
    private int selectedRowIndexQuestion = -1;
    private int selectedRowIndexTblFormat = -1;
    private int selectedRowIndexColumn = -1;
    private int questionId = 0;
    private static int defQuesId = 0;

    public ArrayList<AllQuestionsManager> getAllQuestionList() {
        return allQuestionsManager.readAllQuestions(defQuesId);
    }

    public void setAllQuestionList(ArrayList<AllQuestionsManager> allQuestionList) {
        this.allQuestionList = allQuestionList;
    }

    public ArrayList<AllQuestionsManager> getQuestColList() {
        return questColList;
    }

    public void setQuestColList(ArrayList<AllQuestionsManager> questColList) {
        this.questColList = questColList;
    }

    public ArrayList<AllQuestionsManager> getQuestTblList() {
        return questTblList;
    }

    public void setQuestTblList(ArrayList<AllQuestionsManager> questTblList) {
        this.questTblList = questTblList;
    }

    public ArrayList<SelectItem> getColumnType() {
        return allQuestionsManager.getColumnTypeList();
    }

    public void setColumnType(ArrayList<SelectItem> columnType) {
        this.columnType = columnType;
    }

    public ArrayList<SelectItem> getQuestSection() {
        return allQuestionsManager.getQuestionSectionList();
    }

    public void setQuestSection(ArrayList<SelectItem> questSection) {
        this.questSection = questSection;
    }

    public ArrayList<SelectItem> getQuestType() {
        return allQuestionsManager.getQuestionTypeList();
    }

    public void setQuestType(ArrayList<SelectItem> questType) {
        this.questType = questType;
    }

    public ArrayList<SelectItem> getGroupList() {
        return optionManager.getOptionsGroup();
    }

    public void setGroupList(ArrayList<SelectItem> groupList) {
        this.groupList = groupList;
    }

    public ArrayList<QuestionOptionsManager> getOptionManagerList() {//
        return optionManagerList;
    }

    public void setOptionManagerList(ArrayList<QuestionOptionsManager> optionManagerList) {
        this.optionManagerList = optionManagerList;
    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu4DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu4DefaultItems() {
        return selectOneMenu4DefaultItems;
    }

    public void setSelectOneMenu4DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu4DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu5Bean() {
        return selectOneMenu5Bean;
    }

    public void setSelectOneMenu5Bean(DefaultSelectedData dsd) {
        this.selectOneMenu5Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu5DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu5DefaultItems() {
        return selectOneMenu5DefaultItems;
    }

    public void setSelectOneMenu5DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu5DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu6Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu6Bean() {
        return selectOneMenu6Bean;
    }

    public void setSelectOneMenu6Bean(DefaultSelectedData dsd) {
        this.selectOneMenu6Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu6DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu6DefaultItems() {
        return selectOneMenu6DefaultItems;
    }

    public void setSelectOneMenu6DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu6DefaultItems = dsi;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    private DefaultTableDataModel dataTable3Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable3Model() {
        return dataTable3Model;
    }

    public void setDataTable3Model(DefaultTableDataModel dtdm) {
        this.dataTable3Model = dtdm;
    }
    private DefaultTableDataModel dataTable4Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable4Model() {
        return dataTable4Model;
    }

    public void setDataTable4Model(DefaultTableDataModel dtdm) {
        this.dataTable4Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray ddnQuestionSectionDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDdnQuestionSectionDefaultItems() {
        return ddnQuestionSectionDefaultItems;
    }

    public void setDdnQuestionSectionDefaultItems(DefaultSelectItemsArray dsia) {
        this.ddnQuestionSectionDefaultItems = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private HtmlCommandButton btnAddOption = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddOption() {
        return btnAddOption;
    }

    public void setBtnAddOption(HtmlCommandButton hcb) {
        this.btnAddOption = hcb;
    }
    private HtmlInputText txtOptionValue = new HtmlInputText();

    public HtmlInputText getTxtOptionValue() {
        return txtOptionValue;
    }

    public void setTxtOptionValue(HtmlInputText hit) {
        this.txtOptionValue = hit;
    }
    private HtmlInputText txtOption = new HtmlInputText();

    public HtmlInputText getTxtOption() {
        return txtOption;
    }

    public void setTxtOption(HtmlInputText hit) {
        this.txtOption = hit;
    }
    private HtmlSelectOneMenu ddnOptionGroup = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnOptionGroup() {
        return ddnOptionGroup;
    }

    public void setDdnOptionGroup(HtmlSelectOneMenu hsom) {
        this.ddnOptionGroup = hsom;
    }
    private HtmlCommandButton btnGroup = new HtmlCommandButton();

    public HtmlCommandButton getBtnGroup() {
        return btnGroup;
    }

    public void setBtnGroup(HtmlCommandButton hcb) {
        this.btnGroup = hcb;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private PanelPopup panelPopup = new PanelPopup();

    public PanelPopup getPanelPopup() {
        return panelPopup;
    }

    public void setPanelPopup(PanelPopup pp) {
        this.panelPopup = pp;
    }
    private PanelPopup pnlPopUpGroup = new PanelPopup();

    public PanelPopup getPnlPopUpGroup() {
        return pnlPopUpGroup;
    }

    public void setPnlPopUpGroup(PanelPopup pp) {
        this.pnlPopUpGroup = pp;
    }
    private HtmlCommandButton btnGroupNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnGroupNew() {
        return btnGroupNew;
    }

    public void setBtnGroupNew(HtmlCommandButton hcb) {
        this.btnGroupNew = hcb;
    }
    private HtmlCommandButton btnGroupUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnGroupUpdate() {
        return btnGroupUpdate;
    }

    public void setBtnGroupUpdate(HtmlCommandButton hcb) {
        this.btnGroupUpdate = hcb;
    }
    private HtmlInputText txtGroupName = new HtmlInputText();

    public HtmlInputText getTxtGroupName() {
        return txtGroupName;
    }

    public void setTxtGroupName(HtmlInputText hit) {
        this.txtGroupName = hit;
    }
    private HtmlCommandButton btnSaveUpdateOpt = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveUpdateOpt() {
        return btnSaveUpdateOpt;
    }

    public void setBtnSaveUpdateOpt(HtmlCommandButton hcb) {
        this.btnSaveUpdateOpt = hcb;
    }
    private HtmlCommandButton btnNewEditOpt = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewEditOpt() {
        return btnNewEditOpt;
    }

    public void setBtnNewEditOpt(HtmlCommandButton hcb) {
        this.btnNewEditOpt = hcb;
    }
    private HtmlCommandButton btnDeleteOption = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteOption() {
        return btnDeleteOption;
    }

    public void setBtnDeleteOption(HtmlCommandButton hcb) {
        this.btnDeleteOption = hcb;
    }
    private HtmlCommandButton btnDeleteGroup = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteGroup() {
        return btnDeleteGroup;
    }

    public void setBtnDeleteGroup(HtmlCommandButton hcb) {
        this.btnDeleteGroup = hcb;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private HtmlInputTextarea txtQuestion = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtQuestion() {
        return txtQuestion;
    }

    public void setTxtQuestion(HtmlInputTextarea hit) {
        this.txtQuestion = hit;
    }
    private HtmlSelectOneMenu ddnQuestSection = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnQuestSection() {
        return ddnQuestSection;
    }

    public void setDdnQuestSection(HtmlSelectOneMenu hsom) {
        this.ddnQuestSection = hsom;
    }
    private HtmlSelectOneMenu ddnQuestType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnQuestType() {
        return ddnQuestType;
    }

    public void setDdnQuestType(HtmlSelectOneMenu hsom) {
        this.ddnQuestType = hsom;
    }
    private HtmlSelectOneMenu ddnGroup = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnGroup() {
        return ddnGroup;
    }

    public void setDdnGroup(HtmlSelectOneMenu hsom) {
        this.ddnGroup = hsom;
    }
    private HtmlInputText txtQuestNo = new HtmlInputText();

    public HtmlInputText getTxtQuestNo() {
        return txtQuestNo;
    }

    public void setTxtQuestNo(HtmlInputText hit) {
        this.txtQuestNo = hit;
    }
    private HtmlSelectOneMenu ddnGroupCol = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnGroupCol() {
        return ddnGroupCol;
    }

    public void setDdnGroupCol(HtmlSelectOneMenu hsom) {
        this.ddnGroupCol = hsom;
    }
    private HtmlSelectOneMenu ddnQuestTypeCol = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnQuestTypeCol() {
        return ddnQuestTypeCol;
    }

    public void setDdnQuestTypeCol(HtmlSelectOneMenu hsom) {
        this.ddnQuestTypeCol = hsom;
    }
    private HtmlSelectOneMenu ddnColType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnColType() {
        return ddnColType;
    }

    public void setDdnColType(HtmlSelectOneMenu hsom) {
        this.ddnColType = hsom;
    }
    private HtmlInputText txtColName = new HtmlInputText();

    public HtmlInputText getTxtColName() {
        return txtColName;
    }

    public void setTxtColName(HtmlInputText hit) {
        this.txtColName = hit;
    }
    private HtmlInputText txtOrderNo = new HtmlInputText();

    public HtmlInputText getTxtOrderNo() {
        return txtOrderNo;
    }

    public void setTxtOrderNo(HtmlInputText hit) {
        this.txtOrderNo = hit;
    }
    private HtmlCommandButton btnAddTbl = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddTbl() {
        return btnAddTbl;
    }

    public void setBtnAddTbl(HtmlCommandButton hcb) {
        this.btnAddTbl = hcb;
    }
    private HtmlInputText txtColQuest = new HtmlInputText();

    public HtmlInputText getTxtColQuest() {
        return txtColQuest;
    }

    public void setTxtColQuest(HtmlInputText hit) {
        this.txtColQuest = hit;
    }
    private HtmlSelectBooleanCheckbox chkTableFormat = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkTableFormat() {
        return chkTableFormat;
    }

    public void setChkTableFormat(HtmlSelectBooleanCheckbox hsbc) {
        this.chkTableFormat = hsbc;
    }
    private PanelLayout pnlTblFormat = new PanelLayout();

    public PanelLayout getPnlTblFormat() {
        return pnlTblFormat;
    }

    public void setPnlTblFormat(PanelLayout pl) {
        this.pnlTblFormat = pl;
    }
    private PanelLayout pnlQuestionColumn = new PanelLayout();

    public PanelLayout getPnlQuestionColumn() {
        return pnlQuestionColumn;
    }

    public void setPnlQuestionColumn(PanelLayout pl) {
        this.pnlQuestionColumn = pl;
    }
    private HtmlCommandButton btnAddCol = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddCol() {
        return btnAddCol;
    }

    public void setBtnAddCol(HtmlCommandButton hcb) {
        this.btnAddCol = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private PanelTabSet panelTabSet = new PanelTabSet();

    public PanelTabSet getPanelTabSet() {
        return panelTabSet;
    }

    public void setPanelTabSet(PanelTabSet pts) {
        this.panelTabSet = pts;
    }
    private UISelectItems selectOneMenu2selectItems = new UISelectItems();

    public UISelectItems getSelectOneMenu2selectItems() {
        return selectOneMenu2selectItems;
    }

    public void setSelectOneMenu2selectItems(UISelectItems uisi) {
        this.selectOneMenu2selectItems = uisi;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu somQuestionnaire = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSomQuestionnaire() {
        return somQuestionnaire;
    }

    public void setSomQuestionnaire(HtmlSelectOneMenu hsom) {
        this.somQuestionnaire = hsom;
    }
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ManageQuestions() {
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
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ManageQuestions Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        setOptionManagerList(optionManager.readQuestionOptions());
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
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String cmdAssignQuestionnaire_action() {
        return "AssignQuestionnaire";
    }

    public String cmdQuestionnaire_action() {
        return "GenerateQuestionnairs";
    }

    public String cmdAnalyzeReGrading_action() {
        return "AnalyzeReGradingRequest";
    }

    public String cmdAnalyzeGrading_action() {
        return "AnalyzeGradingRequest";
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage.setValue(messageToDisplay);
        lblFormMessage.setVisible(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "8000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="   OPTION TAB    ">

    private void clearOptionTab() {
        txtOption.resetValue();
        txtOptionValue.resetValue();
        ddnOptionGroup.setValue("0");
        selectedRowIndexOption = -1;
    }

    private void setDisableOptionTab(boolean result) {
        txtOption.setDisabled(result);
        txtOptionValue.setDisabled(result);
        ddnOptionGroup.setDisabled(result);
        btnAddOption.setDisabled(result);
        btnGroup.setDisabled(result);
    }

    public String btnGroup_action() {
        pnlPopUpGroup.setRendered(true);
        if (ddnOptionGroup.getValue() != null) {
            txtGroupName.setValue(allQuestionsManager.getItemLabel(getGroupList(), ddnOptionGroup.getValue()));
            btnGroupUpdate.setValue("Update");
        } else {
            btnGroupUpdate.setValue("Save");
        }
        return null;
    }

    public String btnNewGroup_action() {
        txtGroupName.setValue(null);
        btnGroupUpdate.setValue("Save");
        return null;
    }

    public String btnGroupUpdate_action() {
        if (btnGroupUpdate.getValue().toString().equalsIgnoreCase("Save")) {
            if (optionManager.saveOptionGroup(txtGroupName.getValue().toString())) {
                showSuccessOrFailureMessage(true, "New option group has been saved successfully");
            } else {
                showSuccessOrFailureMessage(false, "Error occured while saving option group.Please try again later.");
            }
            btnGroupUpdate.setValue("Update");
            pnlPopUpGroup.setRendered(false);
        } else {
            if (optionManager.updateOptionGroup(
                    Integer.valueOf(ddnOptionGroup.getValue().toString()),
                    txtGroupName.getValue().toString())) {
                showSuccessOrFailureMessage(true, "Option group has been updated successfully");
            } else {
                showSuccessOrFailureMessage(false, "Error occured while updateing option group.Please try again later.");
            }
            pnlPopUpGroup.setRendered(false);
        }

        return null;
    }

    public String btnAddOption_action() {
//        QuestionOptionsManager manager = new QuestionOptionsManager(
//                txtOption.getValue().toString(),
//                Integer.valueOf(txtOptionValue.getValue().toString()),
//                Integer.valueOf(ddnOptionGroup.getValue().toString()),
//                allQuestionsManager.getItemLabel(getGroupList(), ddnOptionGroup.getValue()));
        if (selectedRowIndexOption > -1) {
            getOptionManagerList().get(selectedRowIndexOption).setOptionName(txtOption.getValue().toString());
            getOptionManagerList().get(selectedRowIndexOption).setValue(Integer.valueOf(txtOptionValue.getValue().toString()));
            getOptionManagerList().get(selectedRowIndexOption).setGroupId(Integer.valueOf(ddnOptionGroup.getValue().toString()));
            getOptionManagerList().get(selectedRowIndexOption).setGroupDesc(allQuestionsManager.getItemLabel(getGroupList(), ddnOptionGroup.getValue()));
            selectedRowIndexOption = -1;
        } else {
            QuestionOptionsManager manager = new QuestionOptionsManager(-1,
                    txtOption.getValue().toString(),
                    Integer.valueOf(txtOptionValue.getValue().toString()),
                    Integer.valueOf(ddnOptionGroup.getValue().toString()),
                    allQuestionsManager.getItemLabel(getGroupList(), ddnOptionGroup.getValue()));
//            getOptionManagerList().clear();

            getOptionManagerList().add(manager);

        }
        return null;
    }

    public void rowSelectorOption_processMyEvent(RowSelectorEvent rse) {
        if (!rse.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            rse.setPhaseId(PhaseId.INVOKE_APPLICATION);
            rse.queue();
            return;
        }
        selectedRowIndexOption = rse.getRow();
        if (selectedRowIndexOption > -1) {
            txtOption.setValue(getOptionManagerList().get(selectedRowIndexOption).getOptionName());
            txtOptionValue.setValue(getOptionManagerList().get(selectedRowIndexOption).getValue());
            ddnOptionGroup.setValue(getOptionManagerList().get(selectedRowIndexOption).getGroupId());
            btnDeleteGroup.setDisabled(false);
            btnDeleteOption.setDisabled(false);
        }
    }

    public String btnNewEditOpt_action() {
        if (selectedRowIndexOption < 0) {
            clearOptionTab();
        }
        setDisableOptionTab(false);
        btnSaveUpdateOpt.setDisabled(false);
        btnAddOption.setDisabled(false);
        return null;
    }

    public String btnSaveUpdateOpt_action() {
        if (optionManager.saveUpdateQuestionOption(getOptionManagerList())) {
            showSuccessOrFailureMessage(true, "Options list has been updated successfully");
        } else {
            showSuccessOrFailureMessage(false, "Error occured while saving option list.Please try again later.");
        }
        btnSaveUpdateOpt.setDisabled(true);
        return null;
    }

    public String btnDeleteOption_action() {
        if (selectedRowIndexOption > -1) {
            if (getOptionManagerList().get(selectedRowIndexOption).getOptionId() > 0) {
                if (optionManager.deleteQuestionOption(getOptionManagerList().get(selectedRowIndexOption).getOptionId())) {
                    showSuccessOrFailureMessage(true, "Option has been deleted successfully");
                } else {
                    showSuccessOrFailureMessage(false, "Error occured while deleting option.Please try again later.");
                }
            } else {
                getOptionManagerList().remove(selectedRowIndexOption);
            }
            btnDeleteOption.setDisabled(true);
            btnDeleteGroup.setDisabled(true);
            selectedRowIndexOption = -1;
        }
        return null;
    }

    public String btnDeleteGroup_action() {
        if (selectedRowIndexOption > -1) {
            if (getOptionManagerList().get(selectedRowIndexOption).getOptionId() > 0) {
                if (optionManager.deleteOptiongroup(getOptionManagerList().get(selectedRowIndexOption).getGroupId())) {
                    setOptionManagerList(optionManager.readQuestionOptions());
                    showSuccessOrFailureMessage(true, "Option group has been deleted successfully");
                } else {
                    showSuccessOrFailureMessage(false, "Error occured while deleting option group.Please try again later.");
                }
            }
            btnDeleteOption.setDisabled(true);
            btnDeleteGroup.setDisabled(true);
            selectedRowIndexOption = -1;
        }

        return null;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="   Manage Question TAB    ">
    private void disableMainComponent(boolean result) {
        txtQuestion.setDisabled(result);
        ddnGroup.setDisabled(result);
        ddnQuestSection.setDisabled(result);
        ddnQuestType.setDisabled(result);
        txtQuestNo.setDisabled(result);
        somQuestionnaire.setDisabled(result);
        chkTableFormat.setDisabled(result);
    }

    private void disableTableFormat(boolean result) {
        txtColName.setDisabled(result);
        ddnColType.setDisabled(result);
        txtOrderNo.setDisabled(result);
        btnAddTbl.setDisabled(result);
    }

    private void disableColumn(boolean result) {
        txtColQuest.setDisabled(result);
        btnAddCol.setDisabled(result);
    }

    private void clearManageQuestionTab() {
        txtQuestion.resetValue();
        txtQuestNo.resetValue();
        txtColName.resetValue();
        txtOrderNo.resetValue();
        txtColQuest.resetValue();
        chkTableFormat.setValue(false);
        ddnGroup.setValue("0");
        ddnQuestSection.setValue("0");
        ddnQuestType.setValue("0");
        ddnColType.setValue("0");
        ddnQuestTypeCol.setValue("0");
        ddnGroupCol.setValue("0");
        getQuestColList().clear();
        getQuestTblList().clear();
        selectedRowIndexTblFormat = -1;
        selectedRowIndexColumn = -1;
        questionId = 0;
    }

    private void clearTableFromatPnl() {
        txtColName.resetValue();
        txtOrderNo.resetValue();
        ddnColType.setValue("0");
        ddnQuestTypeCol.setValue("0");
        ddnGroupCol.setValue("0");
        ddnQuestTypeCol.setDisabled(true);
        ddnGroupCol.setDisabled(true);
    }

    public void ddnQuestType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            int value = Integer.valueOf(vce.getNewValue().toString());
            if (value == 1 || value == 2) {
                ddnGroup.setDisabled(true);
            } else {
                ddnGroup.setDisabled(false);
            }
        }
    }

    public void chkTableFormat_processValueChange(ValueChangeEvent vce) {
        if (chkTableFormat.isSelected()) {
            ddnGroup.setDisabled(true);
            ddnQuestType.setDisabled(true);
            ddnGroup.setValue(null);
            ddnQuestType.setValue(null);
            disableTableFormat(false);
            disableColumn(false);
        } else {
            ddnGroup.setDisabled(false);
            ddnQuestType.setDisabled(false);
            disableTableFormat(true);
            disableColumn(true);
            if (!getQuestTblList().isEmpty()) {
                panelPopup.setRendered(true);
            }
        }
    }

    public void ddnColType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (Integer.valueOf(vce.getNewValue().toString()) == 0) {
                disableColumn(false);
                ddnGroupCol.setDisabled(true);
                ddnQuestTypeCol.setDisabled(true);
                ddnGroupCol.setValue("0");
                ddnQuestTypeCol.setValue("0");
            } else {
                disableColumn(true);
                ddnGroupCol.setDisabled(false);
                ddnQuestTypeCol.setDisabled(false);
            }
        }
    }

    public void ddnQuestTypeCol_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            int value = Integer.valueOf(vce.getNewValue().toString());
            if (value == 1 || value == 2) {
                ddnGroupCol.setDisabled(true);
                ddnGroupCol.setValue("0");
            } else {
                ddnGroupCol.setDisabled(false);
            }
        }
    }

    public void rowSelectorQuestion_processMyEvent(RowSelectorEvent rse) {
        if (!rse.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            rse.setPhaseId(PhaseId.INVOKE_APPLICATION);
            rse.queue();
            return;
        }
        selectedRowIndexQuestion = rse.getRow();
        if (selectedRowIndexQuestion > -1) {
            getQuestTblList().clear();
            getQuestColList().clear();
            clearManageQuestionTab();
            disableMainComponent(true);
            AllQuestionsManager questionManager = getAllQuestionList().get(selectedRowIndexQuestion);
            questionId = questionManager.getQuestionId();
            txtQuestion.setValue(questionManager.getQuestion());
            ddnQuestSection.setValue(questionManager.getQuestionSection());
            ddnQuestType.setValue(questionManager.getQuestionType());
            chkTableFormat.setValue(questionManager.getTableForm());
            txtQuestNo.setValue(questionManager.getQuestionNo());
            ddnGroup.setValue(questionManager.getOptionGroupId());
            somQuestionnaire.setValue(questionManager.getDefQuesId());
            panelTabSet.setSelectedIndex(1);
            setQuestTblList(allQuestionsManager.readTableFormQuestions(questionId));
            setQuestColList(allQuestionsManager.readColumnQuestions(questionId));
            btnEdit.setDisabled(false);
            btnDelete.setDisabled(false);
        }
    }

    public void rowSelectorTblFormat_processMyEvent(RowSelectorEvent rse) {
        selectedRowIndexTblFormat = rse.getRow();
        if (selectedRowIndexTblFormat > -1) {
            AllQuestionsManager questionManager = getQuestTblList().get(selectedRowIndexTblFormat);
            clearTableFromatPnl();
            txtColName.setValue(questionManager.getColumnName());
            txtOrderNo.setValue(questionManager.getOrderNo());
            ddnColType.setValue(questionManager.getColumnType());
            ddnQuestTypeCol.setValue(questionManager.getQuestionType());
            ddnGroupCol.setValue(questionManager.getOptionGroupId());
        }
    }

    public void rowSelectorQuestionColumn_processMyEvent(RowSelectorEvent rse) {
        selectedRowIndexColumn = rse.getRow();
        if (selectedRowIndexColumn > -1) {
            txtColQuest.resetValue();
            txtColQuest.setDisabled(false);
            txtColQuest.setValue(getQuestColList().get(selectedRowIndexColumn).getQuestion());
        }
    }

    private AllQuestionsManager questionManager() {
        AllQuestionsManager questionManager = new AllQuestionsManager(
                questionId,
                txtQuestion.getValue().toString(),
                Integer.valueOf(ddnQuestSection.getValue().toString()),
                (ddnQuestType.getValue() != null) ? Integer.valueOf(ddnQuestType.getValue().toString()) : 0,
                chkTableFormat.isSelected(),
                Integer.valueOf(txtQuestNo.getValue().toString()),
                (ddnGroup.getValue() != null) ? Integer.valueOf(ddnGroup.getValue().toString()) : 0,
                (somQuestionnaire.getValue() != null) ? Integer.valueOf(somQuestionnaire.getValue().toString()) : 0);
        return questionManager;
    }

    public String btnAddTbl_action() {
        int questionType = (ddnQuestTypeCol.getValue() != null) ? Integer.valueOf(ddnQuestTypeCol.getValue().toString()) : 0;
        int groupCol = (ddnGroupCol.getValue() != null) ? Integer.valueOf(ddnGroupCol.getValue().toString()) : 0;
        AllQuestionsManager questionsManager = new AllQuestionsManager(
                0,
                txtColName.getValue().toString(),
                Integer.valueOf(ddnColType.getValue().toString()),
                allQuestionsManager.getItemLabel(getColumnType(), ddnColType.getValue()),
                questionType,
                (questionType != 0) ? allQuestionsManager.getItemLabel(getQuestType(), ddnQuestTypeCol.getValue()) : null,
                groupCol,
                (groupCol != 0) ? allQuestionsManager.getItemLabel(getGroupList(), ddnGroupCol.getValue()) : null,
                Integer.valueOf(txtOrderNo.getValue().toString()));
        if (selectedRowIndexTblFormat > -1) {
            int questTblId = getQuestTblList().get(selectedRowIndexTblFormat).getQuestTblId();
            questionsManager.setQuestTblId(questTblId);
            getQuestTblList().remove(selectedRowIndexTblFormat);
            getQuestTblList().add(selectedRowIndexTblFormat, questionsManager);
            selectedRowIndexTblFormat = -1;
        } else {
            getQuestTblList().add(questionsManager);
        }
        clearTableFromatPnl();
        return null;
    }

    public String btnAddCol_action() {
        if (selectedRowIndexColumn > -1) {
            getQuestColList().get(selectedRowIndexColumn).setQuestion(txtColQuest.getValue().toString());
        } else if (selectedRowIndexTblFormat > -1) {
            getQuestColList().add(new AllQuestionsManager(
                    0,
                    0,
                    txtColQuest.getValue().toString(),
                    getQuestTblList().get(selectedRowIndexTblFormat).getColumnName()));
        }
        selectedRowIndexColumn = -1;
        txtColQuest.resetValue();
        return null;
    }

    public String btnNew_action() {
        clearManageQuestionTab();
        disableMainComponent(false);
        btnSave.setDisabled(false);
        btnDelete.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnEdit.setDisabled(true);
        return null;
    }

    public String btnSave_action() {
        if (allQuestionsManager.saveAllQuestion(questionManager(), getQuestTblList(), getQuestColList())) {
            showSuccessOrFailureMessage(true, "New question has been saved successfully");
        } else {
            showSuccessOrFailureMessage(false, "Error occured while saving this question.Please try again later.");
        }
        return null;
    }

    public String btnEdit_action() {
        disableMainComponent(false);
        disableTableFormat(false);
        clearTableFromatPnl();
        disableColumn(false);
        btnUpdate.setDisabled(false);
        return null;
    }

    public String btnUpdate_action() {
        if (questionId > 0) {
            if (allQuestionsManager.updateAllQuestion(questionManager(), getQuestTblList(), getQuestColList())) {
                showSuccessOrFailureMessage(true, "New question has been updated successfully");
            } else {
                showSuccessOrFailureMessage(false, "Error occured while updateing this question.Please try again later.");
            }
        }
        return null;
    }

    public String btnDelete_action() {
        if (questionId > 0) {
            if (allQuestionsManager.deleteQuestion(questionId)) {
                showSuccessOrFailureMessage(true, "Selected question has been deleted successfully");
                clearManageQuestionTab();
            } else {
                showSuccessOrFailureMessage(false, "Error occured while deleting selected question.Please try again later.");
            }
        }
        return null;
    }

    public String btnDeleteTbl_action() {
        if (selectedRowIndexTblFormat > -1) {
            int questTblId = getQuestTblList().get(selectedRowIndexTblFormat).getQuestTblId();
            if (questTblId > 0) {
                if (allQuestionsManager.deleteQuestionTable(questTblId)) {
                    showSuccessOrFailureMessage(true, "Selected row has been deleted successfully");
                } else {
                    showSuccessOrFailureMessage(false, "Error occured while deleting selected row.Please try again later.");
                }
            }
            getQuestTblList().remove(selectedRowIndexTblFormat);
            setQuestColList(allQuestionsManager.readColumnQuestions(questionId));
            clearTableFromatPnl();
        }
        return null;
    }

    public String btnDeleteColumn_action() {
        if (selectedRowIndexColumn > -1) {
            int questColId = getQuestColList().get(selectedRowIndexColumn).getQuestColumnId();
            if (questColId > 0) {
                if (allQuestionsManager.deleteQuestionColumn(questColId)) {
                    showSuccessOrFailureMessage(true, "Selected row has been deleted successfully");
                } else {
                    showSuccessOrFailureMessage(false, "Error occured while deleting selected row.Please try again later.");
                }
            }
            getQuestColList().remove(selectedRowIndexColumn);
            txtColQuest.resetValue();
        }
        return null;
    }

    public String bntYES_action() {
        panelPopup.setRendered(false);
        if (questionId > -1) {
            if (allQuestionsManager.deleteQuestionTableByQuestionId(questionId)) {
                showSuccessOrFailureMessage(true, "Selected question has been deleted successfully");
            } else {
                showSuccessOrFailureMessage(false, "Error occured while deleting selected question.Please try again later.");
            }
        }
        return null;
    }

    public String btnNo_action() {
        panelPopup.setRendered(false);
        chkTableFormat.setSelected(true);
        ddnGroup.setDisabled(true);
        ddnQuestType.setDisabled(true);
        ddnGroup.setValue(null);
        ddnQuestType.setValue(null);
        disableTableFormat(false);
        disableColumn(false);
        return null;
    }

    public String cmdCloseDeleete_action() {
        pnlPopUpGroup.setRendered(false);
        return null;
    }

    /**
     * @return the definedQuesList
     */
    public ArrayList<SelectItem> getDefinedQuesList() {
        return defQuesMnger.getQuestionnaireTitles();
    }

    /**
     * @param definedQuesList the definedQuesList to set
     */
    public void setDefinedQuesList(ArrayList<SelectItem> definedQuesList) {
        this.definedQuesList = definedQuesList;
    }

    public void somQuestionnaire1_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            defQuesId = Integer.parseInt(vce.getNewValue().toString());
        } else {
            defQuesId = 0;
        }
        this.getAllQuestionList();
    }
// </editor-fold>
}

