/*
 * HolydayHonesApprove.java
 *
 * Created on Dec 17, 2012, 12:25:41 AM
 * Copyright kibrom
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
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.HolydayBonesManager.HolydayBonesManager;
import manager.employeeManager.EmployeeManage;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class HolydayHonesApprove extends AbstractPageBean {

    EmployeeManage employeeManager = new EmployeeManage();
    private ArrayList<HolydayBonesManager> holydayBonesManagerList = new ArrayList<HolydayBonesManager>();
    HolydayBonesManager holydayBonesManager = new HolydayBonesManager();
    String religion;
    String addressCode;
    int requestId;

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public ArrayList<HolydayBonesManager> getHolydayBonesManagerList() {
        return holydayBonesManagerList;
    }

    public void setHolydayBonesManagerList(ArrayList<HolydayBonesManager> holydayBonesManagerList) {
        this.holydayBonesManagerList = holydayBonesManagerList;
    }
    private HtmlInputText txtDate = new HtmlInputText();

    public HtmlInputText getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(HtmlInputText hit) {
        this.txtDate = hit;
    }
    private HtmlInputText txtBranch = new HtmlInputText();

    public HtmlInputText getTxtBranch() {
        return txtBranch;
    }

    public void setTxtBranch(HtmlInputText hit) {
        this.txtBranch = hit;
    }
    private HtmlInputText txtReligion = new HtmlInputText();

    public HtmlInputText getTxtReligion() {
        return txtReligion;
    }

    public void setTxtReligion(HtmlInputText hit) {
        this.txtReligion = hit;
    }
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup hpg) {
        this.panelGroupMessage = hpg;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlInputText txtHolydayName = new HtmlInputText();

    public HtmlInputText getTxtHolydayName() {
        return txtHolydayName;
    }
    ArrayList<SelectItem> holyDayBonesRequest = new ArrayList<SelectItem>();

    public HolydayBonesManager getHolydayBonesManager() {
        return holydayBonesManager;
    }

    public void setHolydayBonesManager(HolydayBonesManager holydayBonesManager) {
        this.holydayBonesManager = holydayBonesManager;
    }

    public ArrayList<SelectItem> getHolyDayBonesRequest() {
        return holyDayBonesRequest;
    }

    public void setHolyDayBonesRequest(ArrayList<SelectItem> holyDayBonesRequest) {
        this.holyDayBonesRequest = holyDayBonesRequest;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlInputText txtBonesAmount = new HtmlInputText();

    public HtmlInputText getTxtBonesAmount() {
        return txtBonesAmount;
    }

    public void setTxtBonesAmount(HtmlInputText hit) {
        this.txtBonesAmount = hit;
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
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    /**
     * <p>Construct a new Page bean instance.</p>
     */
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
    private HtmlCommandButton btnevaCriteriaPopUpPurposeAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaCriteriaPopUpPurposeAdd() {
        return btnevaCriteriaPopUpPurposeAdd;
    }

    public void setBtnevaCriteriaPopUpPurposeAdd(HtmlCommandButton hcb) {
        this.btnevaCriteriaPopUpPurposeAdd = hcb;
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


    public void setTxtHolydayName(HtmlInputText hit) {
        this.txtHolydayName = hit;
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
    private DefaultSelectedData selectedRequestFromApprovedList = new DefaultSelectedData();

    public DefaultSelectedData getSelectedRequestFromApprovedList() {
        return selectedRequestFromApprovedList;
    }

    public void setSelectedRequestFromApprovedList(DefaultSelectedData selectedRequestFromApprovedList) {
        this.selectedRequestFromApprovedList = selectedRequestFromApprovedList;
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
        holyDayBonesRequest = holydayBonesManager.getBonseRequst();

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

    public void calEndingDate_processValueChange(ValueChangeEvent vce) {
    }

    public void selectRequestApprovedLists_processValueChange(ValueChangeEvent vce) {

        String requesterId;
        String[] requestInfos = vce.getNewValue().toString().split("--");
        requestId = Integer.parseInt(requestInfos[0]);
        requesterId = requestInfos[1];
        populateRequesterTextComponents(requestId);
    }

    private void populateRequesterTextComponents(int requestId) {
        HashMap empInfoHashMap = holydayBonesManager.readRequestInfo(requestId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("HOLYDAYBONESID").toString().equals("")) {//if no resultset found
            } else {
                religion = empInfoHashMap.get("RELIGION").toString();
                addressCode = empInfoHashMap.get("BRANCH").toString();
                txtBonesAmount.setValue(empInfoHashMap.get("AMOUT"));
                txtBranch.setValue(empInfoHashMap.get("BRANCH"));
                txtReligion.setValue(empInfoHashMap.get("RELIGION"));
                txtDate.setValue(empInfoHashMap.get("REQUESTDATE"));
                txtHolydayName.setValue(empInfoHashMap.get("HOLYDAYNAME"));
                setHolydayBonesManagerList(holydayBonesManager.selectEmpForHolydayBonesManager(religion, addressCode));
                holyDayBonesRequest = holydayBonesManager.getBonseRequst();
            }
        } else {
//            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
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

    public void showSuccessOrFailureMessageForZindex(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setStyle("border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;z-index:10000;");
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btnSave_action() {

        if (holydayBonesManager.aprove(requestId)) {
            this.showSuccessOrFailureMessage(true, "Holyday Bones request is successfully Approved!");
        } else {
            this.showSuccessOrFailureMessage(true, "Holyday Bones is Not successfully Approved!");
        }
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }
}


