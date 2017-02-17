/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import javax.faces.event.ValueChangeEvent;
import manager.employeeHistoryManager.EvaluationManager;
import java.util.ResourceBundle;
import manager.departmentManage.DepartmentManage;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EvaluationCriterias extends AbstractPageBean {

    private HtmlCommandButton btnevaCriteriaPopUpPurposeAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpPurposeAdd() {
        return btnevaCriteriaPopUpPurposeAdd;
    }

    public void setBtnevaCriteriaPopUpPurposeAdd(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpPurposeAdd = hcb;
    }
    private HtmlSelectOneMenu drlJob = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJob() {
        return drlJob;
    }

    public void setDrlJob(HtmlSelectOneMenu hsom) {
        this.drlJob = hsom;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    EvaluationManager evaluationManagerObject = new EvaluationManager();
    private HtmlCommandButton buttonNewEC = new HtmlCommandButton();
    int selectedEvaCriteriaRow = -1;
    int selectedEvaCriteriaPurpAdd = -1;
    int buttonIdentifier = 0;
    private Object evaCriteriaPopeffectWindow;
    Option[] category;
    private Option[] categoryFilter;
    int idHolder, idHolder1;
    ResourceBundle messageResource = null;
    FacesContext context = null;
    private List evaCriteriaOPt = new ArrayList<EvaluationManager>();
    private List evaResultOPtAddPurpose = new ArrayList<EvaluationManager>();
    private PanelPopup pnMessage = new PanelPopup();

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

    public List getEvaResultOPtAddPurpose() {
        return evaResultOPtAddPurpose;
    }

    public void setEvaResultOPtAddPurpose(List evaResultOPtAddPurpose) {
        this.evaResultOPtAddPurpose = evaResultOPtAddPurpose;
    }

    public List getEvaCriteriaOPt() {
        return evaCriteriaOPt;
    }

    public void setEvaCriteriaOPt(List evaCriteriaOPt) {
        this.evaCriteriaOPt = evaCriteriaOPt;
    }

    /**
     * @return the category
     */
    public Option[] getCategory() {
        return category;
    }

    public Option[] getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(Option[] categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Option[] category) {
        this.category = category;
    }

    /**
     * @return the evaCriteriaPopeffectWindow
     */
    public Object getEvaCriteriaPopeffectWindow() {
        return evaCriteriaPopeffectWindow;
    }

    /**
     * @param evaCriteriaPopeffectWindow the evaCriteriaPopeffectWindow to set
     */
    public void setEvaCriteriaPopeffectWindow(Object evaCriteriaPopeffectWindow) {
        this.evaCriteriaPopeffectWindow = evaCriteriaPopeffectWindow;
    }

    public HtmlCommandButton getButtonNewEC() {
        return buttonNewEC;
    }

    public void setButtonNewEC(HtmlCommandButton hcb) {
        this.buttonNewEC = hcb;
    }
    private HtmlCommandButton buttonEditEC = new HtmlCommandButton();

    public HtmlCommandButton getButtonEditEC() {
        return buttonEditEC;
    }

    public void setButtonEditEC(HtmlCommandButton hcb) {
        this.buttonEditEC = hcb;
    }
    private HtmlCommandButton buttonUpdateEC = new HtmlCommandButton();

    public HtmlCommandButton getButtonUpdateEC() {
        return buttonUpdateEC;
    }

    public void setButtonUpdateEC(HtmlCommandButton hcb) {
        this.buttonUpdateEC = hcb;
    }
    private HtmlCommandButton buttonDeleteEC = new HtmlCommandButton();

    public HtmlCommandButton getButtonDeleteEC() {
        return buttonDeleteEC;
    }

    public void setButtonDeleteEC(HtmlCommandButton hcb) {
        this.buttonDeleteEC = hcb;
    }
    private HtmlCommandButton buttonResetEC = new HtmlCommandButton();

    public HtmlCommandButton getButtonResetEC() {
        return buttonResetEC;
    }

    public void setButtonResetEC(HtmlCommandButton hcb) {
        this.buttonResetEC = hcb;
    }
    private HtmlCommandLink linkEditEvacrit = new HtmlCommandLink();

    public HtmlCommandLink getLinkEditEvacrit() {
        return linkEditEvacrit;
    }
    private HtmlSelectOneMenu selectOneMenu1PurposeFillter = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1PurposeFillter() {
        return selectOneMenu1PurposeFillter;
    }

    public void setSelectOneMenu1PurposeFillter(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1PurposeFillter = hsom;
    }

    public void setLinkEditEvacrit(HtmlCommandLink hcl) {
        this.linkEditEvacrit = hcl;
    }
    private RowSelector rowSelectorEvaCriteria = new RowSelector();

    public RowSelector getRowSelectorEvaCriteria() {
        return rowSelectorEvaCriteria;
    }

    public void setRowSelectorEvaCriteria(RowSelector rs) {
        this.rowSelectorEvaCriteria = rs;
    }
    private PanelLayout panelLayoutTableController = new PanelLayout();

    public PanelLayout getPanelLayoutTableController() {
        return panelLayoutTableController;
    }

    public void setPanelLayoutTableController(PanelLayout pl) {
        this.panelLayoutTableController = pl;
    }
    private HtmlDataTable dataTableEvaCriteria = new HtmlDataTable();

    public HtmlDataTable getDataTableEvaCriteria() {
        return dataTableEvaCriteria;
    }

    public void setDataTableEvaCriteria(HtmlDataTable hdt) {
        this.dataTableEvaCriteria = hdt;
    }
    private PanelPopup evaCriteriaPopUpMsg = new PanelPopup();

    public PanelPopup getEvaCriteriaPopUpMsg() {
        return evaCriteriaPopUpMsg;
    }

    public void setEvaCriteriaPopUpMsg(PanelPopup pp) {
        this.evaCriteriaPopUpMsg = pp;
    }
    private HtmlCommandButton btnevaCriteriaPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpYes() {
        return btnevaCriteriaPopUpYes;
    }

    public void setBtnevaCriteriaPopUpYes(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpYes = hcb;
    }
    private HtmlCommandButton btnevaCriteriaPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpNo() {
        return btnevaCriteriaPopUpNo;
    }

    public void setBtnevaCriteriaPopUpNo(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpNo = hcb;
    }
    private HtmlOutputText lblevaCriteriaPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblevaCriteriaPopUpMsgMain() {
        return lblevaCriteriaPopUpMsgMain;
    }

    public void setLblevaCriteriaPopUpMsgMain(HtmlOutputText hot) {
        this.lblevaCriteriaPopUpMsgMain = hot;
    }
    private HtmlGraphicImage gimgevaCriteriaPopUpMsg = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgevaCriteriaPopUpMsg() {
        return gimgevaCriteriaPopUpMsg;
    }

    public void setGimgevaCriteriaPopUpMsg(HtmlGraphicImage hgi) {
        this.gimgevaCriteriaPopUpMsg = hgi;
    }
    private PanelLayout pnevaCriteriaMessage = new PanelLayout();

    public PanelLayout getPnevaCriteriaMessage() {
        return pnevaCriteriaMessage;
    }

    public void setPnevaCriteriaMessage(PanelLayout pl) {
        this.pnevaCriteriaMessage = pl;
    }
    private HtmlOutputLabel lblevaCriteriaFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblevaCriteriaFormMessage() {
        return lblevaCriteriaFormMessage;
    }

    public void setLblevaCriteriaFormMessage(HtmlOutputLabel hol) {
        this.lblevaCriteriaFormMessage = hol;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private HtmlSelectOneMenu selectOneMenuevaCCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuevaCCategory() {
        return selectOneMenuevaCCategory;
    }

    public void setSelectOneMenuevaCCategory(HtmlSelectOneMenu hsom) {
        this.selectOneMenuevaCCategory = hsom;
    }
    private UISelectItems selectOneMenu1selectItemsevaCCategory = new UISelectItems();

    public UISelectItems getSelectOneMenu1selectItemsevaCCategory() {
        return selectOneMenu1selectItemsevaCCategory;
    }

    public void setSelectOneMenu1selectItemsevaCCategory(UISelectItems uisi) {
        this.selectOneMenu1selectItemsevaCCategory = uisi;
    }
    private UIColumn columncevaCid = new UIColumn();

    public UIColumn getColumncevaCid() {
        return columncevaCid;
    }

    public void setColumncevaCid(UIColumn uic) {
        this.columncevaCid = uic;
    }
    private HtmlPanelGroup panelGroupevaCriteriaPopUpPurposeMsgBodyButtons = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupevaCriteriaPopUpPurposeMsgBodyButtons() {
        return panelGroupevaCriteriaPopUpPurposeMsgBodyButtons;
    }

    public void setPanelGroupevaCriteriaPopUpPurposeMsgBodyButtons(HtmlPanelGroup hpg) {
        this.panelGroupevaCriteriaPopUpPurposeMsgBodyButtons = hpg;
    }
    private HtmlPanelGroup panelGroupevaCriteriaPopUpPurposeMsgBody1 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupevaCriteriaPopUpPurposeMsgBody1() {
        return panelGroupevaCriteriaPopUpPurposeMsgBody1;
    }

    public void setPanelGroupevaCriteriaPopUpPurposeMsgBody1(HtmlPanelGroup hpg) {
        this.panelGroupevaCriteriaPopUpPurposeMsgBody1 = hpg;
    }
    private HtmlCommandButton button2 = new HtmlCommandButton();

    public HtmlCommandButton getButton2() {
        return button2;
    }

    public void setButton2(HtmlCommandButton hcb) {
        this.button2 = hcb;
    }
    private HtmlCommandButton button1 = new HtmlCommandButton();

    public HtmlCommandButton getButton1() {
        return button1;
    }

    public void setButton1(HtmlCommandButton hcb) {
        this.button1 = hcb;
    }
    private HtmlPanelGroup panelGroupevaCriteriaPopUpPurposeMsgBodyDelete = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupevaCriteriaPopUpPurposeMsgBodyDelete() {
        return panelGroupevaCriteriaPopUpPurposeMsgBodyDelete;
    }

    public void setPanelGroupevaCriteriaPopUpPurposeMsgBodyDelete(HtmlPanelGroup hpg) {
        this.panelGroupevaCriteriaPopUpPurposeMsgBodyDelete = hpg;
    }
    private HtmlPanelGroup panelGroupevaCriteriaPopUpPurposeMsgBody11 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupevaCriteriaPopUpPurposeMsgBody11() {
        return panelGroupevaCriteriaPopUpPurposeMsgBody11;
    }

    public void setPanelGroupevaCriteriaPopUpPurposeMsgBody11(HtmlPanelGroup hpg) {
        this.panelGroupevaCriteriaPopUpPurposeMsgBody11 = hpg;
    }
    private HtmlCommandButton btnevaCriteriaPopUpPurposeEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpPurposeEdit() {
        return btnevaCriteriaPopUpPurposeEdit;
    }

    public void setBtnevaCriteriaPopUpPurposeEdit(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpPurposeEdit = hcb;
    }
    private HtmlCommandButton buttonClose = new HtmlCommandButton();

    public HtmlCommandButton getButtonClose() {
        return buttonClose;
    }

    public void setButtonClose(HtmlCommandButton hcb) {
        this.buttonClose = hcb;
    }
    private HtmlCommandButton btnevaCriteriaPopUpPurposeNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpPurposeNew() {
        return btnevaCriteriaPopUpPurposeNew;
    }

    public void setBtnevaCriteriaPopUpPurposeNew(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpPurposeNew = hcb;
    }
    private HtmlInputText inputTextPopUpPurpose = new HtmlInputText();

    public HtmlInputText getInputTextPopUpPurpose() {
        return inputTextPopUpPurpose;
    }

    public void setInputTextPopUpPurpose(HtmlInputText hit) {
        this.inputTextPopUpPurpose = hit;
    }
    private RowSelector rowSelectorEvaPurposeAdd = new RowSelector();

    public RowSelector getRowSelectorEvaPurposeAdd() {
        return rowSelectorEvaPurposeAdd;
    }

    public void setRowSelectorEvaPurposeAdd(RowSelector rs) {
        this.rowSelectorEvaPurposeAdd = rs;
    }
    private HtmlInputText inputTextPurpAdd = new HtmlInputText();

    public HtmlInputText getInputTextPurpAdd() {
        return inputTextPurpAdd;
    }

    public void setInputTextPurpAdd(HtmlInputText hit) {
        this.inputTextPurpAdd = hit;
    }
    private UIColumn column1 = new UIColumn();

    public UIColumn getColumn1() {
        return column1;
    }

    public void setColumn1(UIColumn uic) {
        this.column1 = uic;
    }
    private UIColumn column2 = new UIColumn();

    public UIColumn getColumn2() {
        return column2;
    }

    public void setColumn2(UIColumn uic) {
        this.column2 = uic;
    }
    private HtmlCommandButton btnevaCriteriaPopUpPurposeCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpPurposeCancel() {
        return btnevaCriteriaPopUpPurposeCancel;
    }

    public void setBtnevaCriteriaPopUpPurposeCancel(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpPurposeCancel = hcb;
    }
    private HtmlCommandButton btnevaCriteriaPopUpPurposeDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpPurposeDelete() {
        return btnevaCriteriaPopUpPurposeDelete;
    }

    public void setBtnevaCriteriaPopUpPurposeDelete(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpPurposeDelete = hcb;
    }
    private HtmlCommandButton btnevaCriteriaPopUpPurposeUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpPurposeUpdate() {
        return btnevaCriteriaPopUpPurposeUpdate;
    }

    public void setBtnevaCriteriaPopUpPurposeUpdate(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpPurposeUpdate = hcb;
    }
    private HtmlCommandButton addNewPurpButton = new HtmlCommandButton();

    public HtmlCommandButton getAddNewPurpButton() {
        return addNewPurpButton;
    }

    public void setAddNewPurpButton(HtmlCommandButton hcb) {
        this.addNewPurpButton = hcb;
    }
    private HtmlDataTable dataTableAddPurpose = new HtmlDataTable();

    public HtmlDataTable getDataTableAddPurpose() {
        return dataTableAddPurpose;
    }

    public void setDataTableAddPurpose(HtmlDataTable hdt) {
        this.dataTableAddPurpose = hdt;
    }
    private PanelPopup evaCriteriaPurposePopUpMsg = new PanelPopup();

    public PanelPopup getEvaCriteriaPurposePopUpMsg() {
        return evaCriteriaPurposePopUpMsg;
    }

    public void setEvaCriteriaPurposePopUpMsg(PanelPopup pp) {
        this.evaCriteriaPurposePopUpMsg = pp;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlOutputText outputTextCriteriaName = new HtmlOutputText();

    public HtmlOutputText getOutputTextCriteriaName() {
        return outputTextCriteriaName;
    }

    public void setOutputTextCriteriaName(HtmlOutputText hot) {
        this.outputTextCriteriaName = hot;
    }
    private HtmlOutputText outputTextdataTableEvaCriteria = new HtmlOutputText();

    public HtmlOutputText getOutputTextdataTableEvaCriteria() {
        return outputTextdataTableEvaCriteria;
    }

    public void setOutputTextdataTableEvaCriteria(HtmlOutputText hot) {
        this.outputTextdataTableEvaCriteria = hot;
    }
    private HtmlOutputText outputTextTextCName = new HtmlOutputText();

    public HtmlOutputText getOutputTextTextCName() {
        return outputTextTextCName;
    }

    public void setOutputTextTextCName(HtmlOutputText hot) {
        this.outputTextTextCName = hot;
    }
    private HtmlOutputText outputTextErorrselectOneMenuevaCCategory = new HtmlOutputText();

    public HtmlOutputText getOutputTextErorrselectOneMenuevaCCategory() {
        return outputTextErorrselectOneMenuevaCCategory;
    }

    public void setOutputTextErorrselectOneMenuevaCCategory(HtmlOutputText hot) {
        this.outputTextErorrselectOneMenuevaCCategory = hot;
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
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlSelectOneRadio rbtnSex = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRbtnSex() {
        return rbtnSex;
    }

    public void setRbtnSex(HtmlSelectOneRadio hsor) {
        this.rbtnSex = hsor;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems5() {
        return selectOneRadio1DefaultItems5;
    }

    public void setSelectOneRadio1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems6() {
        return selectOneRadio1DefaultItems6;
    }

    public void setSelectOneRadio1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems6 = dsia;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
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
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private HtmlInputText inputTextCCode = new HtmlInputText();

    public HtmlInputText getInputTextCCode() {
        return inputTextCCode;
    }

    public void setInputTextCCode(HtmlInputText hit) {
        this.inputTextCCode = hit;
    }
    private HtmlInputText inputTextCName = new HtmlInputText();

    public HtmlInputText getInputTextCName() {
        return inputTextCName;
    }

    public void setInputTextCName(HtmlInputText hit) {
        this.inputTextCName = hit;
    }
    private HtmlInputTextarea inputTextareaCDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getInputTextareaCDescription() {
        return inputTextareaCDescription;
    }

    public void setInputTextareaCDescription(HtmlInputTextarea hit) {
        this.inputTextareaCDescription = hit;
    }
    private HtmlCommandButton btnNewECria = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewECria() {
        return btnNewECria;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }

    public void setBtnNewECria(HtmlCommandButton hcb) {
        this.btnNewECria = hcb;
    }
    private HtmlCommandButton btnResetECria = new HtmlCommandButton();

    public HtmlCommandButton getBtnResetECria() {
        return btnResetECria;
    }

    public void setBtnResetECria(HtmlCommandButton hcb) {
        this.btnResetECria = hcb;
    }
    private HtmlCommandButton buttonSaveEC = new HtmlCommandButton();

    public HtmlCommandButton getButtonSaveEC() {
        return buttonSaveEC;
    }

    public void setButtonSaveEC(HtmlCommandButton hcb) {
        this.buttonSaveEC = hcb;
    }
    // </editor-fold>

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

        this.populateTable();
        category = evaluationManagerObject.readEvaCCategory();
        categoryFilter = evaluationManagerObject.readEvaCCategory();
        buttonIdentifier = 0;

        disableComponents();

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
    @Override
    public void prerender() {
        this.selectOneMenuevaCCategory.setRequired(true);
        this.selectOneMenuevaCCategory.setRequiredMessage("Requred");
        inputTextCName.setRequired(true);
        inputTextCName.setRequiredMessage("Requred");

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

    public void rowSelectorEvaCriteria_processMyEvent(RowSelectorEvent rse) {
        selectedEvaCriteriaRow = rse.getRow();

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

    void disableComponents() {
        this.inputTextCCode.setDisabled(true);
        this.inputTextCName.setDisabled(true);
        this.inputTextareaCDescription.setDisabled(true);
        selectOneMenuevaCCategory.setDisabled(true);

    }

    void disableButtons() {
        this.buttonSaveEC.setDisabled(true);
        this.buttonDeleteEC.setDisabled(true);
        this.buttonEditEC.setDisabled(true);
        this.buttonUpdateEC.setDisabled(true);
        this.btnNewECria.setDisabled(true);
        this.btnResetECria.setDisabled(true);
        this.buttonNewEC.setDisabled(true);
        this.buttonResetEC.setDisabled(true);
    }

    void enableButtons() {
        this.buttonSaveEC.setDisabled(false);
        this.buttonDeleteEC.setDisabled(false);
        this.buttonEditEC.setDisabled(false);
        this.buttonUpdateEC.setDisabled(false);
        this.btnNewECria.setDisabled(false);
        this.btnResetECria.setDisabled(false);
        this.buttonNewEC.setDisabled(false);

    }

    void enableComponents() {
        this.inputTextCCode.setDisabled(false);
        this.inputTextCName.setDisabled(false);
        this.inputTextareaCDescription.setDisabled(false);
        selectOneMenuevaCCategory.setDisabled(false);
    }

    public String btnNewECria_action() {
        String CriteriaCcategory = null;
        String CriteriaName = null;
        String CriteriaDescription = null;
        outputTextdataTableEvaCriteria.setValue("");
//
        if (this.inputTextCName.getValue() != null || !this.inputTextCName.getValue().toString().equals("")) {
            CriteriaName = this.inputTextCName.getValue().toString();
            inputTextCName.setValue("");
        } else {
            outputTextCriteriaName.setRendered(true);
        }
        if (this.inputTextareaCDescription.getValue() != null) {
            CriteriaDescription = this.inputTextareaCDescription.getValue().toString();
        }
        if (!selectOneMenuevaCCategory.getValue().equals("0")) {
            CriteriaCcategory = evaluationManagerObject.readSinglePurpose(Integer.valueOf(this.selectOneMenuevaCCategory.getValue().toString()));
            EvaluationManager addEvaCriteriaToTable = new EvaluationManager(CriteriaCcategory, CriteriaName, CriteriaDescription);
            this.evaCriteriaOPt.add(addEvaCriteriaToTable);

        } else {
            outputTextErorrselectOneMenuevaCCategory.setValue("Requred");
            outputTextErorrselectOneMenuevaCCategory.setRendered(true);

        }

        //return null means stay on the same page
        return null;
    }

    public String buttonSaveEC_action() {
        int chekSave = 0;
        buttonIdentifier = 2;
        if (this.evaCriteriaOPt.isEmpty() == true) {
            outputTextdataTableEvaCriteria.setValue("Requred");
            outputTextdataTableEvaCriteria.setRendered(true);
        } else {
            List evaCriterias = this.evaCriteriaOPt;
            Iterator<EvaluationManager> ittEvaCriteria = evaCriterias.iterator();
            while (ittEvaCriteria.hasNext()) {
                EvaluationManager evaC = ittEvaCriteria.next();
                chekSave = evaluationManagerObject.addEvaCriteria(evaC.getEvaCriteriaDesc(), evaC.getEvaCriteria(), evaC.getEvaCriteriaCategory());
            }
            if (chekSave == 1) {
                this.showSuccessOrFailureMessage(true, "The Evaluation Criteria record is successfully saved!");
                clearComponents();
            } else {
                this.showSuccessOrFailureMessage(false, "Error Occured during saving .Please Try Again?");
                clearComponents();
            }
        }
        //return null means stay on the same page
        return null;
    }

    public String buttonEditEC_action() {
        buttonIdentifier = 3;
        int usedCriteriaIndicator = 0;
        if (selectedEvaCriteriaRow == -1) {
            this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (evaCriteriaOPt.isEmpty() == true && selectedEvaCriteriaRow != -1) {
            this.showSuccessOrFailureMessage(false, "The Table is Empty!");

        } else {

            int rowNumber = selectedEvaCriteriaRow;
            EvaluationManager evaCriteria = (EvaluationManager) evaCriteriaOPt.get(rowNumber);


            EvaluationResultManager evaResultManObject = new EvaluationResultManager();
            usedCriteriaIndicator = evaResultManObject.indicatorOfCreiteriaUsage(evaCriteria.getEvaParaCode());

            if (usedCriteriaIndicator == 0) {
                enableComponents();
                disableButtons();
                this.buttonUpdateEC.setDisabled(false);
                this.buttonResetEC.setDisabled(false);


                evaCriteriaOPt.remove(rowNumber);
                this.inputTextCName.setValue(evaCriteria.getEvaCriteria());
                this.inputTextareaCDescription.setValue(evaCriteria.getEvaCriteriaDesc());
                idHolder = evaCriteria.getEvaParaCode();
            } else {
                this.showSuccessOrFailureMessage(false, "Sorry you can't Edit this Criteria!");
            }
        }

        //return null means stay on the same page
        return null;
    }

    public void populateTable() {
        evaCriteriaOPt.clear();
        int count = evaluationManagerObject.countEvaCriteriaUsing();
        buttonIdentifier = 0;

        try {
            if (count > 0) {
                this.columncevaCid.setRendered(true);
                enableButtons();
                disableComponents();
                this.columncevaCid.setRendered(true);
                this.buttonSaveEC.setDisabled(true);
                this.buttonUpdateEC.setDisabled(true);
                this.btnNewECria.setDisabled(true);
                this.btnResetECria.setDisabled(true);
                this.buttonResetEC.setDisabled(true);
                HashMap[] evaCriteriaList = evaluationManagerObject.readEvaCriteriaEdit();

                for (int i = 0; i < count; i++) {
                    EvaluationManager addToTable = new EvaluationManager(evaCriteriaList[i].get("EVALUATION_PARA_CODE").hashCode(), evaCriteriaList[i].get("CATEGORY").toString(), evaCriteriaList[i].get("NAME").toString(), evaCriteriaList[i].get("DESCRIPTION").toString());
                    this.evaCriteriaOPt.add(addToTable);
                }
            } else {
                disableButtons();
                this.columncevaCid.setRendered(false);
                this.buttonNewEC.setDisabled(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

    }
    DepartmentManage departmentManage = new DepartmentManage();
    public Option[] readJob = departmentManage.readAllJobBYO();

    public void setReadJob(Option[] readJob) {
        this.readJob = readJob;
    }

    public Option[] getReadJob() {
        return readJob;
    }

    public void populatePurposeTable() {
        this.column1.setRendered(true);
        int count = evaluationManagerObject.countEvaCriteriaPurpose();

        try {
            if (count > 0) {

                HashMap[] evaCriteriaList = evaluationManagerObject.readEvaCriteriaPurpose();

                for (int i = 0; i < count; i++) {
                    EvaluationManager addToTable = new EvaluationManager(evaCriteriaList[i].get("PURPOSE_ID").hashCode(), evaCriteriaList[i].get("PURPOSE_NAME").toString());
                    this.evaResultOPtAddPurpose.add(addToTable);
                }
            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

    }

    void clearComponents() {
        this.inputTextCCode.setValue("");
        this.inputTextCName.setValue("");
        this.inputTextareaCDescription.setValue("");
        evaCriteriaOPt.clear();
    }

    public String buttonResetEC_action() {
        outputTextdataTableEvaCriteria.setValue("");
        clearComponents();
        populateTable();


        //return null means stay on the same page
        return null;
    }

    public String btnResetECria_action() {
        this.inputTextCCode.setValue("");
        this.inputTextCName.setValue("");
        this.inputTextareaCDescription.setValue("");
        //return null means stay on the same page
        return null;
    }

    public String buttonNewEC_action() {
        buttonIdentifier = 1;
        clearComponents();
        selectOneMenu1PurposeFillter.resetValue();
        selectOneMenu1PurposeFillter.setValue("0");
        evaCriteriaOPt.clear();
        enableComponents();
        disableButtons();
        this.columncevaCid.setRendered(false);
        this.buttonSaveEC.setDisabled(false);
        this.btnNewECria.setDisabled(false);
        this.btnResetECria.setDisabled(false);
        this.buttonResetEC.setDisabled(false);

        //return null means stay on the same page
        return null;
    }

    public String linkEditEvacrit_action() {
        //return null means stay on the same page
        return null;
    }

    public String buttonUpdateEC_action() {
        int chekUpdate = 0;
        String CriteriaCcategory = null;
        String CriteriaName = null;
        String CriteriaDescription = null;
        if (this.selectOneMenuevaCCategory.getValue() != null) {
            CriteriaCcategory = evaluationManagerObject.readSinglePurpose(Integer.valueOf(this.selectOneMenuevaCCategory.getValue().toString()));
            EvaluationManager addEvaCriteriaToTable = new EvaluationManager(CriteriaCcategory, CriteriaName, CriteriaDescription);
            evaCriteriaOPt.add(addEvaCriteriaToTable);
        }
        if (this.inputTextCName.getValue() != null) {
            CriteriaName = this.inputTextCName.getValue().toString();
        }
        if (this.inputTextareaCDescription.getValue() != null) {
            CriteriaDescription = this.inputTextareaCDescription.getValue().toString();
        }

        EvaluationManager addEvaCriteriaToTable = new EvaluationManager(idHolder, CriteriaCcategory, CriteriaName, CriteriaDescription);
        this.evaCriteriaOPt.add(addEvaCriteriaToTable);

        chekUpdate = evaluationManagerObject.updateEvaCriteria(idHolder, CriteriaCcategory, CriteriaName, CriteriaDescription);






        clearComponents();
        populateTable();
        //return null means stay on the same page
        return null;
    }

    public String buttonDeleteEC_action() {
        int usedCriteriaIndicator = 0;
        if (selectedEvaCriteriaRow == -1) {
            this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (evaCriteriaOPt.isEmpty() == true && selectedEvaCriteriaRow != -1) {
            this.showSuccessOrFailureMessage(false, "The Table is Empty!");

        } else {
            int rowNumber = selectedEvaCriteriaRow;
            EvaluationManager evaCriteria = (EvaluationManager) evaCriteriaOPt.get(rowNumber);


            EvaluationResultManager evaResultManObject = new EvaluationResultManager();
            usedCriteriaIndicator = evaResultManObject.indicatorOfCreiteriaUsage(evaCriteria.getEvaParaCode());

            if (usedCriteriaIndicator == 0) {
                lblevaCriteriaPopUpMsgMain.setValue("Are you shure You want to delete this record?");
                evaCriteriaPopUpMsg.setRendered(true);
                btnevaCriteriaPopUpNo.setRendered(true);
                btnevaCriteriaPopUpYes.setRendered(true);
            } else {
                this.showSuccessOrFailureMessage(false, "Sorry you can't Delete this Criteria!");
            }
        }


        //return null means stay on the same page
        return null;
    }

    public String btnevaCriteriaPopUpYes_action() {
        evaCriteriaPopUpMsg.setRendered(false);
        gimgevaCriteriaPopUpMsg.setVisible(true);
        int chekDelete = 0;
        int rowNumber = selectedEvaCriteriaRow;
        EvaluationManager evaCriteria = (EvaluationManager) evaCriteriaOPt.get(rowNumber);
        evaCriteriaOPt.remove(rowNumber);
        chekDelete = evaluationManagerObject.deleteEvaCriteria(evaCriteria.getEvaParaCode());
        //return null means stay on the same page
        return null;
    }

    public String btnevaCriteriaPopUpNo_action() {
        evaCriteriaPopUpMsg.setRendered(false);
        gimgevaCriteriaPopUpMsg.setVisible(true);
        clearComponents();
        populateTable();
        //return null means stay on the same page
        return null;
    }

    public void selectOneMenuevaCCategory_processValueChange(ValueChangeEvent vce) {
        outputTextErorrselectOneMenuevaCCategory.setValue("");
        outputTextdataTableEvaCriteria.setValue("");
    }

    public void inputTextCName_processValueChange(ValueChangeEvent vce) {
        outputTextCriteriaName.setValue("");

    }

    public String addNewPurpButton_action() {
        evaResultOPtAddPurpose.clear();
        populatePurposeTable();
        this.inputTextPopUpPurpose.setDisabled(true);
        this.btnevaCriteriaPopUpPurposeAdd.setDisabled(true);
        evaCriteriaPurposePopUpMsg.setRendered(true);
        this.btnevaCriteriaPopUpPurposeUpdate.setDisabled(true);


        //return null means stay on the same page
        return null;
    }

    public String btnevaCriteriaPopUpPurposeUpdate_action() {
        String newPurposeAdd = null;


        if (this.inputTextPopUpPurpose.getValue() != null || !this.inputTextPopUpPurpose.getValue().toString().equals("")) {
            newPurposeAdd = this.inputTextPopUpPurpose.getValue().toString();
            inputTextPopUpPurpose.setValue("");
        }
        evaluationManagerObject.updateEvaCriteriaPurp(idHolder1, newPurposeAdd);
        evaResultOPtAddPurpose.clear();
        populatePurposeTable();
        this.btnevaCriteriaPopUpPurposeUpdate.setDisabled(false);
        this.btnevaCriteriaPopUpPurposeEdit.setDisabled(false);
        category = evaluationManagerObject.readEvaCCategory();
        categoryFilter = evaluationManagerObject.readEvaCCategory();
        //return null means stay on the same page
        return null;
    }

    public String btnevaCriteriaPopUpPurposeDelete_action() {
        panelGroupevaCriteriaPopUpPurposeMsgBody11.setRendered(false);
        panelGroupevaCriteriaPopUpPurposeMsgBodyDelete.setRendered(true);
        panelGroupevaCriteriaPopUpPurposeMsgBody1.setRendered(false);
        panelGroupevaCriteriaPopUpPurposeMsgBodyButtons.setRendered(false);
        category = evaluationManagerObject.readEvaCCategory();
        categoryFilter = evaluationManagerObject.readEvaCCategory();
        //return null means stay on the same page
        return null;
    }

    public String btnevaCriteriaPopUpPurposeCancel_action() {
        evaResultOPtAddPurpose.clear();
        populatePurposeTable();
        this.inputTextPopUpPurpose.setValue("");
        this.inputTextPopUpPurpose.setDisabled(true);

        this.btnevaCriteriaPopUpPurposeUpdate.setDisabled(true);
        this.btnevaCriteriaPopUpPurposeDelete.setDisabled(false);
        this.btnevaCriteriaPopUpPurposeEdit.setDisabled(false);
        this.btnevaCriteriaPopUpPurposeAdd.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public void rowSelectorEvaPurposeAdd_processMyEvent(RowSelectorEvent rse) {

        selectedEvaCriteriaPurpAdd = rse.getRow();
    }

    public String btnevaCriteriaPopUpPurposeEdit_action() {
        int rowNumber = selectedEvaCriteriaPurpAdd;
        this.inputTextPopUpPurpose.setDisabled(false);
        EvaluationManager evaCriteriaPurp = (EvaluationManager) evaResultOPtAddPurpose.get(rowNumber);
        evaResultOPtAddPurpose.remove(rowNumber);
        this.inputTextPopUpPurpose.setValue(evaCriteriaPurp.getPurpName());
        idHolder1 = evaCriteriaPurp.getPurpId();
        this.btnevaCriteriaPopUpPurposeUpdate.setDisabled(false);
        this.btnevaCriteriaPopUpPurposeEdit.setDisabled(true);
        btnevaCriteriaPopUpPurposeAdd.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public String btnevaCriteriaPopUpPurposeAdd_action() {
        this.inputTextPopUpPurpose.setDisabled(true);
        this.btnevaCriteriaPopUpPurposeAdd.setDisabled(false);
        String newPurposeAdd = null;

        if (this.inputTextPopUpPurpose.getValue() != null || !this.inputTextPopUpPurpose.getValue().toString().equals("")) {
            newPurposeAdd = this.inputTextPopUpPurpose.getValue().toString() + "--" + drlJob.getValue().toString();
            inputTextPopUpPurpose.setValue("");
        }
//        } else {
//             outputTextCriteriaName.setRendered(true);
//        }

        EvaluationManager addEvaCriteriaToTable = new EvaluationManager(newPurposeAdd);
        this.evaResultOPtAddPurpose.add(addEvaCriteriaToTable);

        List evaCriterias = evaResultOPtAddPurpose;
        Iterator<EvaluationManager> ittEvaCriteria = evaCriterias.iterator();
        while (ittEvaCriteria.hasNext()) {
            EvaluationManager evaC = ittEvaCriteria.next();
            evaluationManagerObject.addEvaCriteriaPurpose(evaC.getPurpName());
        }
        category = evaluationManagerObject.readEvaCCategory();
        categoryFilter = evaluationManagerObject.readEvaCCategory();
        //return null means stay on the same page
        return null;
    }

    public String btnevaCriteriaPopUpPurposeNew_action() {
        this.inputTextPopUpPurpose.setValue("");
        evaResultOPtAddPurpose.clear();
        this.inputTextPopUpPurpose.setDisabled(false);

        this.column1.setRendered(false);
        this.btnevaCriteriaPopUpPurposeUpdate.setDisabled(true);
        this.btnevaCriteriaPopUpPurposeDelete.setDisabled(true);
        this.btnevaCriteriaPopUpPurposeAdd.setDisabled(false);
        this.btnevaCriteriaPopUpPurposeEdit.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public String buttonClose_action() {
        evaCriteriaPurposePopUpMsg.setRendered(false);
        category = evaluationManagerObject.readEvaCCategory();
        //return null means stay on the same page
        return null;
    }

    public String button1_action() {
        panelGroupevaCriteriaPopUpPurposeMsgBody11.setRendered(true);
        panelGroupevaCriteriaPopUpPurposeMsgBodyDelete.setRendered(false);
        panelGroupevaCriteriaPopUpPurposeMsgBody1.setRendered(true);
        panelGroupevaCriteriaPopUpPurposeMsgBodyButtons.setRendered(true);
        int rowNumber = selectedEvaCriteriaPurpAdd;
        EvaluationManager evaCriteriaPurp = (EvaluationManager) evaResultOPtAddPurpose.get(rowNumber);
        evaResultOPtAddPurpose.remove(rowNumber);
        evaluationManagerObject.deleteEvaCriteriaPurp(evaCriteriaPurp.getPurpId());
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {
        panelGroupevaCriteriaPopUpPurposeMsgBody11.setRendered(true);
        panelGroupevaCriteriaPopUpPurposeMsgBodyDelete.setRendered(false);
        panelGroupevaCriteriaPopUpPurposeMsgBody1.setRendered(true);
        panelGroupevaCriteriaPopUpPurposeMsgBodyButtons.setRendered(true);
        evaResultOPtAddPurpose.clear();
        populatePurposeTable();
        //return null means stay on the same page
        return null;
    }

    public String commandLink1_action() {

        //return null means stay on the same page
        return "EvaluationCriterias";
    }

    public String commandLink2_action() {
        //return null means stay on the same page
        return "EvaluationResult";
    }

    public String commandLink3_action() {
        //return null means stay on the same page
        return "EvaluationSession";
    }

    public String commandLink4_action() {
        //return null means stay on the same page
        return "EvaluationResultDisplay";
    }

    public String commandLink5_action() {
        //return null means stay on the same page
        return "EvaluationResultResolveComplain";
    }

    public String commandLink6_action() {
        //return null means stay on the same page
        return "EvaluationNavigation";
    }

    public void selectOneMenu1PurposeFillter_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() == null || vce.getNewValue().toString().equals("0")) {
            populateTable();
        } else {
            this.populateTableFilter(Integer.valueOf(vce.getNewValue().toString()));
        }
    }

    public void populateTableFilter(int purp) {
        this.evaCriteriaOPt.clear();
        int count = evaluationManagerObject.countEvaCriteriaUsing();
        buttonIdentifier = 0;

        try {
            if (count > 0) {
                this.columncevaCid.setRendered(true);
                enableButtons();
                disableComponents();
                this.columncevaCid.setRendered(true);
                this.buttonSaveEC.setDisabled(true);
                this.buttonUpdateEC.setDisabled(true);
                this.btnNewECria.setDisabled(true);
                this.btnResetECria.setDisabled(true);
                this.buttonResetEC.setDisabled(true);
                HashMap[] evaCriteriaList = evaluationManagerObject.readEvaCriteriaEditFilter(purp);

                for (int i = 0; i < count; i++) {
                    EvaluationManager addToTable = new EvaluationManager(evaCriteriaList[i].get("EVALUATION_PARA_CODE").hashCode(), evaCriteriaList[i].get("CATEGORY").toString(), evaCriteriaList[i].get("NAME").toString(), evaCriteriaList[i].get("DESCRIPTION").toString());
                    this.evaCriteriaOPt.add(addToTable);
                }
            } else {
                disableButtons();
                this.columncevaCid.setRendered(false);
                this.buttonNewEC.setDisabled(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public void drlJob_processValueChange(ValueChangeEvent vce) {
    }

    public String btnevaCriteriaPopUpPurposeAdd() {
        //return null means stay on the same page
        return null;
    }
}



