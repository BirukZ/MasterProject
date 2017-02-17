/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Questionnaire;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
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
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import manager.questionnaire.AllQuestionsManager;
import manager.questionnaire.DefineQuestionnaireManager;


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
public class DefineQuestionnaire extends AbstractPageBean {

    DefineQuestionnaireManager optionManager = new DefineQuestionnaireManager();
    AllQuestionsManager allQuestionsManager = new AllQuestionsManager();
    ArrayList<DefineQuestionnaireManager> optionManagerList = new ArrayList<DefineQuestionnaireManager>();
    ArrayList<AllQuestionsManager> allQuestionList = new ArrayList<AllQuestionsManager>();
    ArrayList<AllQuestionsManager> questTblList = new ArrayList<AllQuestionsManager>();
    ArrayList<AllQuestionsManager> questColList = new ArrayList<AllQuestionsManager>();
    ArrayList<SelectItem> questSection = new ArrayList<SelectItem>();
    ArrayList<SelectItem> questType = new ArrayList<SelectItem>();
    ArrayList<SelectItem> columnType = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> questionnairePurposeList = new ArrayList<SelectItem>();
    private int selectedRowIndexOption = -1;
    private int selectedRowIndexQuestion = -1;
    private int selectedRowIndexTblFormat = -1;
    private int selectedRowIndexColumn = -1;
    private int questionId = 0;


    public ArrayList<AllQuestionsManager> getAllQuestionList() {
        return allQuestionsManager.readAllQuestions(0);
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

    public ArrayList<SelectItem> getQuestionnairePurposeList() {
        return  optionManager.getQuestionnairePurpose();//optionManager.getOptionsGroup();
    }

//    public void setQuestionnairePurposeList(ArrayList<SelectItem> questionnairePurposeList) {
//        this.questionnairePurposeList = questionnairePurposeList;
//    }

    public ArrayList<DefineQuestionnaireManager> getOptionManagerList() {//
        return optionManagerList;
    }

    public void setOptionManagerList(ArrayList<DefineQuestionnaireManager> optionManagerList) {
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
    private HtmlInputText txtQuestionnaireTitle = new HtmlInputText();

    public HtmlInputText getTxtQuestionnaireTitle() {
        return txtQuestionnaireTitle;
    }

    public void setTxtQuestionnaireTitle(HtmlInputText hit) {
        this.txtQuestionnaireTitle = hit;
    }
    private HtmlSelectOneMenu ddnQuestionnairePurpose = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnQuestionnairePurpose() {
        return ddnQuestionnairePurpose;
    }

    public void setDdnQuestionnairePurpose(HtmlSelectOneMenu hsom) {
        this.ddnQuestionnairePurpose = hsom;
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
    private PanelTabSet panelTabSet = new PanelTabSet();

    public PanelTabSet getPanelTabSet() {
        return panelTabSet;
    }

    public void setPanelTabSet(PanelTabSet pts) {
        this.panelTabSet = pts;
    }
    private HtmlInputTextarea txtaQuestionnaireDesc = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaQuestionnaireDesc() {
        return txtaQuestionnaireDesc;
    }

    public void setTxtaQuestionnaireDesc(HtmlInputTextarea hit) {
        this.txtaQuestionnaireDesc = hit;
    }
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DefineQuestionnaire() {
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
        setQuestionnairePurposeList(optionManager.getQuestionnairePurpose());
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
        txtQuestionnaireTitle.resetValue();
        txtaQuestionnaireDesc.resetValue();
        ddnQuestionnairePurpose.setValue("0");
        selectedRowIndexOption = -1;
    }

    private void setDisableOptionTab(boolean result) {
        txtQuestionnaireTitle.setDisabled(result);
        txtaQuestionnaireDesc.setDisabled(result);
        ddnQuestionnairePurpose.setDisabled(result);
        btnAddOption.setDisabled(result);
        btnGroup.setDisabled(result);
    }

    public String btnGroup_action() {
        pnlPopUpGroup.setRendered(true);
        if (ddnQuestionnairePurpose.getValue() != null) {
//            txtGroupName.setValue(allQuestionsManager.getItemLabel(getQuestionnairePurposeList(), ddnQuestionnairePurpose.getValue()));
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
                    Integer.valueOf(ddnQuestionnairePurpose.getValue().toString()),
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
//                txtOption.getDefQuesDescription().toString(),
//                Integer.valueOf(txtOptionValue.getDefQuesDescription().toString()),
//                Integer.valueOf(ddnOptionGroup.getDefQuesDescription().toString()),
//                allQuestionsManager.getItemLabel(getQuestionnairePurposeList(), ddnOptionGroup.getDefQuesDescription()));
        if (selectedRowIndexOption > -1) {
            getOptionManagerList().get(selectedRowIndexOption).setDefQuesName(txtQuestionnaireTitle.getValue().toString());
            getOptionManagerList().get(selectedRowIndexOption).setDefQuesDescription(txtaQuestionnaireDesc.getValue().toString());
            getOptionManagerList().get(selectedRowIndexOption).setPurposeId(Integer.valueOf(ddnQuestionnairePurpose.getValue().toString()));
//            getOptionManagerList().get(selectedRowIndexOption).setDefQuesPurposeDesc(allQuestionsManager.getItemLabel(getQuestionnairePurposeList(), ddnQuestionnairePurpose.getValue()));
            selectedRowIndexOption = -1;
        } else {
//            DefineQuestionnaireManager manager = new DefineQuestionnaireManager(-1,
//                    txtQuestionnaireTitle.getValue().toString(),
//                    txtaQuestionnaireDesc.getValue().toString(),
//              //      Integer.valueOf(ddnQuestionnairePurpose.getValue().toString()),
                   // allQuestionsManager.getItemLabel(getQuestionnairePurposeList(), ddnQuestionnairePurpose.getValue()));
//            getOptionManagerList().clear();
            //   getOptionManagerList().add(manager);
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
            txtQuestionnaireTitle.setValue(getOptionManagerList().get(selectedRowIndexOption).getDefQuesName());
            txtaQuestionnaireDesc.setValue(getOptionManagerList().get(selectedRowIndexOption).getDefQuesDescription());
            ddnQuestionnairePurpose.setValue(getOptionManagerList().get(selectedRowIndexOption).getPurposeId());
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
            if (getOptionManagerList().get(selectedRowIndexOption).getQuesId() > 0) {
                if (optionManager.deleteQuestionOption(getOptionManagerList().get(selectedRowIndexOption).getQuesId())) {
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
            if (getOptionManagerList().get(selectedRowIndexOption).getQuesId() > 0) {
                if (optionManager.deleteOptiongroup(getOptionManagerList().get(selectedRowIndexOption).getPurposeId())) {
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

//    /**
//     * @return the questionnairePurposeList
//     */
//    public ArrayList<SelectItem> getQuestionnairePurposeList() {
//        return questionnairePurposeList;
//    }

    /**
     * @param questionnairePurposeList the questionnairePurposeList to set
     */
    public void setQuestionnairePurposeList(ArrayList<SelectItem> questionnairePurposeList) {
        this.questionnairePurposeList = questionnairePurposeList;
    }

// </editor-fold>
}

