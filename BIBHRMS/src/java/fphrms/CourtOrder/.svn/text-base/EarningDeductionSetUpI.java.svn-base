/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright
 */
package fphrms.CourtOrder;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import manager.courtOrder.FMS_Utility;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.courtOrder.EarningDeductionManager;
import manager.courtOrder.EarningDeductionManager;
import manager.courtOrder.FMS_Utility;
//import manager.courtOrder.PayrollManager;

public class EarningDeductionSetUpI extends AbstractPageBean {
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
    private PanelCollapsible panelCollapsible2 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible2() {
        return panelCollapsible2;
    }

    public void setPanelCollapsible2(PanelCollapsible pc) {
        this.panelCollapsible2 = pc;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private HtmlInputText inputTextCode = new HtmlInputText();

    public HtmlInputText getInputTextCode() {
        return inputTextCode;
    }

    public void setInputTextCode(HtmlInputText hit) {
        this.inputTextCode = hit;
    }
    private HtmlInputText inputTextDescription = new HtmlInputText();

    public HtmlInputText getInputTextDescription() {
        return inputTextDescription;
    }

    public void setInputTextDescription(HtmlInputText hit) {
        this.inputTextDescription = hit;
    }
    private HtmlSelectOneMenu selectOneMenuType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuType() {
        return selectOneMenuType;
    }

    public void setSelectOneMenuType(HtmlSelectOneMenu hsom) {
        this.selectOneMenuType = hsom;
    }
    private HtmlCommandButton buttonAdd = new HtmlCommandButton();

    public HtmlCommandButton getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(HtmlCommandButton hcb) {
        this.buttonAdd = hcb;
    }
    private HtmlCommandButton buttonSaveChanges = new HtmlCommandButton();

    public HtmlCommandButton getButtonSaveChanges() {
        return buttonSaveChanges;
    }

    public void setButtonSaveChanges(HtmlCommandButton hcb) {
        this.buttonSaveChanges = hcb;
    }
    private HtmlCommandButton buttonUpdate = new HtmlCommandButton();

    public HtmlCommandButton getButtonUpdate() {
        return buttonUpdate;
    }

    public void setButtonUpdate(HtmlCommandButton hcb) {
        this.buttonUpdate = hcb;
    }
    private HtmlCommandButton buttonDelete = new HtmlCommandButton();

    public HtmlCommandButton getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(HtmlCommandButton hcb) {
        this.buttonDelete = hcb;
    }
    private HtmlCommandButton buttonSave = new HtmlCommandButton();

    public HtmlCommandButton getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(HtmlCommandButton hcb) {
        this.buttonSave = hcb;
    }
    private HtmlCommandButton buttonAddNew = new HtmlCommandButton();

    public HtmlCommandButton getButtonAddNew() {
        return buttonAddNew;
    }

    public void setButtonAddNew(HtmlCommandButton hcb) {
        this.buttonAddNew = hcb;
    }
    private HtmlDataTable dataTableEarningDeduction = new HtmlDataTable();

    public HtmlDataTable getDataTableEarningDeduction() {
        return dataTableEarningDeduction;
    }

    public void setDataTableEarningDeduction(HtmlDataTable hdt) {
        this.dataTableEarningDeduction = hdt;
    }
    private PanelPopup panelPopupEarningDeduction = new PanelPopup();

    public PanelPopup getPanelPopupEarningDeduction() {
        return panelPopupEarningDeduction;
    }

    public void setPanelPopupEarningDeduction(PanelPopup pp) {
        this.panelPopupEarningDeduction = pp;
    }
    private HtmlCommandButton buttonFinish = new HtmlCommandButton();

    public HtmlCommandButton getButtonFinish() {
        return buttonFinish;
    }

    public void setButtonFinish(HtmlCommandButton hcb) {
        this.buttonFinish = hcb;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectOneMenu selectOneMenuEarningDeductionCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuEarningDeductionCode() {
        return selectOneMenuEarningDeductionCode;
    }

    public void setSelectOneMenuEarningDeductionCode(HtmlSelectOneMenu hsom) {
        this.selectOneMenuEarningDeductionCode = hsom;
    }
    private HtmlCommandButton buttonSearch = new HtmlCommandButton();

    public HtmlCommandButton getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(HtmlCommandButton hcb) {
        this.buttonSearch = hcb;
    }
    private HtmlOutputText outputTextAlertMessage = new HtmlOutputText();

    public HtmlOutputText getOutputTextAlertMessage() {
        return outputTextAlertMessage;
    }

    public void setOutputTextAlertMessage(HtmlOutputText hot) {
        this.outputTextAlertMessage = hot;
    }
    private PanelLayout panelLayoutMessage = new PanelLayout();

    public PanelLayout getPanelLayoutMessage() {
        return panelLayoutMessage;
    }

    public void setPanelLayoutMessage(PanelLayout pl) {
        this.panelLayoutMessage = pl;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems5 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems5 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems7 = dsia;
    }
    private HtmlSelectOneMenu selectOneMenuTaxable = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuTaxable() {
        return selectOneMenuTaxable;
    }

    public void setSelectOneMenuTaxable(HtmlSelectOneMenu hsom) {
        this.selectOneMenuTaxable = hsom;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private HtmlSelectOneMenu selectOneMenuCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuCategory() {
        return selectOneMenuCategory;
    }

    public void setSelectOneMenuCategory(HtmlSelectOneMenu hsom) {
        this.selectOneMenuCategory = hsom;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems8 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems8 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems9 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems10 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems10() {
        return selectOneMenu1DefaultItems10;
    }

    public void setSelectOneMenu1DefaultItems10(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems10 = dsia;
    }
    private PanelLayout panelLayoutSetUpPopUp = new PanelLayout();

    public PanelLayout getPanelLayoutSetUpPopUp() {
        return panelLayoutSetUpPopUp;
    }

    public void setPanelLayoutSetUpPopUp(PanelLayout pl) {
        this.panelLayoutSetUpPopUp = pl;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Variable Declaration">
    private ArrayList<SelectItem> type = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> base = new ArrayList<SelectItem>();
    private ArrayList<EarningDeductionInternal> earningDeductionList = new ArrayList<EarningDeductionInternal>();
    private ArrayList<SelectItem> earningDeductionCodeList = new ArrayList<SelectItem>();
    private boolean earningDeductionPanelPopUpFlag = false;
    private int selectedRow = -1;
    private ArrayList<SelectItem> isTaxableCodeList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> categoryCodeList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> effectType = new ArrayList<SelectItem>();
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Internal Class">

    public final class EarningDeductionInternal {

        private boolean selected;
        private String type;
        private String code;
        private String description;
        private String taxable;
        private int category;
        private String categoryDescription;
        private String taxableDescription;
        int dbStatus;
        int operationStatus;
        String rowStyle;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getDbStatus() {
            return dbStatus;
        }

        public void setDbStatus(int dbStatus) {
            this.dbStatus = dbStatus;
        }

        public int getOperationStatus() {
            return operationStatus;
        }

        public void setOperationStatus(int operationStatus) {
            this.operationStatus = operationStatus;
        }

        public String getRowStyle() {
            return rowStyle;
        }

        public void setRowStyle(String rowStyle) {
            this.rowStyle = rowStyle;
        }

        public String getTaxable() {
            return taxable;
        }

        public void setTaxable(String taxable) {
            this.taxable = taxable;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public String getCategoryDescription() {
            return categoryDescription;
        }

        public void setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        public String getTaxableDescription() {
            return taxableDescription;
        }

        public void setTaxableDescription(String taxableDescription) {
            this.taxableDescription = taxableDescription;
        }
    }


    // </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter & Setter" >
    public ArrayList<SelectItem> getEarningDeductionCodeList() {
        return earningDeductionCodeList = EarningDeductionManager.getEarningDeductionCodeList();
    }

    public void setEarningDeductionCodeList(ArrayList<SelectItem> earningDeductionCodeList) {
        this.earningDeductionCodeList = earningDeductionCodeList;
    }

    public ArrayList<EarningDeductionInternal> getEarningDeductionList() {
        return earningDeductionList;
    }

    public void setEarningDeductionList(ArrayList<EarningDeductionInternal> earningDeductionList) {
        this.earningDeductionList = earningDeductionList;
    }

    public ArrayList<SelectItem> getType() {
        return type = EarningDeductionManager.transactionType();
    }

    public void setType(ArrayList<SelectItem> type) {
        this.type = type;
    }

    public ArrayList<SelectItem> getBase() {
        return base = EarningDeductionManager.basedOn();
    }

    public void setBase(ArrayList<SelectItem> base) {
        this.base = base;
    }

    public boolean isEarningDeductionPanelPopUpFlag() {
        return earningDeductionPanelPopUpFlag;
    }

    public void setEarningDeductionPanelPopUpFlag(boolean earningDeductionPanelPopUpFlag) {
        this.earningDeductionPanelPopUpFlag = earningDeductionPanelPopUpFlag;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public ArrayList<SelectItem> getIsTaxableCodeList() {
        return isTaxableCodeList = EarningDeductionManager.isTaxableCodeList();
    }

    public void setIsTaxableCodeList(ArrayList<SelectItem> isTaxableCodeList) {
        this.isTaxableCodeList = isTaxableCodeList;
    }

    public ArrayList<SelectItem> getCategoryCodeList() {
        return categoryCodeList = EarningDeductionManager.earningDeductionCategory();
    }

    public void setCategoryCodeList(ArrayList<SelectItem> categoryCodeList) {
        this.categoryCodeList = categoryCodeList;
    }

    public ArrayList<SelectItem> getEffectType() {
        return effectType = EarningDeductionManager.effectType();
    }

    public void setEffectType(ArrayList<SelectItem> effectType) {
        this.effectType = effectType;
    }

    // </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Page Links" >
  


    // </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Common Functions">
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
        }

    // </editor-fold>

    }

    public void preprocess() {
    }

    public void prerender() {
        panelPopupEarningDeduction.setRendered(isEarningDeductionPanelPopUpFlag());
    }

    public void destroy() {
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);
    }

    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EarningDeductionSetUpI() {
    }

    public String buttonAddNew_action() {
        buttonAdd.setDisabled(false);
        inputTextCode.setDisabled(false);
        inputTextCode.setValue(null);
        inputTextDescription.setValue(null);
        selectOneMenuType.setValue("");
        selectOneMenuTaxable.setValue("");
        selectOneMenuTaxable.setDisabled(false);
        setEarningDeductionPanelPopUpFlag(true);

        return null;
    }

    public String buttonFinish_action() {
        buttonAdd.setDisabled(true);
        buttonSaveChanges.setDisabled(true);
        inputTextCode.setDisabled(true);
        setEarningDeductionPanelPopUpFlag(false);

        return null;
    }

    public String buttonAdd_action() {
        EarningDeductionSetUpI.EarningDeductionInternal earnDeduct = new EarningDeductionSetUpI.EarningDeductionInternal();
        earnDeduct.setCode(this.inputTextCode.getValue().toString());
        earnDeduct.setDescription(this.inputTextDescription.getValue().toString());
        earnDeduct.setType(this.selectOneMenuType.getValue().toString());
        if (Integer.parseInt(selectOneMenuTaxable.getValue().toString()) == FMS_Utility.YES) {
            earnDeduct.setTaxableDescription("YES");
        } else if (Integer.parseInt(selectOneMenuTaxable.getValue().toString()) == FMS_Utility.NO) {
            earnDeduct.setTaxableDescription("NO");
        } else if (Integer.parseInt(selectOneMenuTaxable.getValue().toString()) == FMS_Utility.NOT_APPLICABLE) {
            earnDeduct.setTaxableDescription("N/A");
        }
        if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_LUMP_SUM) {
            earnDeduct.setCategoryDescription("LUMP_SUM");
        } else if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_PERCENT) {
            earnDeduct.setCategoryDescription("PERCENT");
        } else if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_PER_WORKING_DAYS) {
            earnDeduct.setCategoryDescription("WORKING_DAYS");
        } else if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_QUOTA) {
            earnDeduct.setCategoryDescription("QUOTA");
        }
        earnDeduct.setTaxable(selectOneMenuTaxable.getValue().toString());
        earnDeduct.setCategory(Integer.parseInt(selectOneMenuCategory.getValue().toString()));
        earnDeduct.setDbStatus(FMS_Utility.ROW_NOT_SUBMITED);
        earnDeduct.setOperationStatus(FMS_Utility.ROW_ADDED);
        earnDeduct.setRowStyle(FMS_Utility.ADDED_STYLE);
        getEarningDeductionList().add(earnDeduct);
        inputTextCode.setValue(null);
        inputTextDescription.setValue(null);
        selectOneMenuType.setValue("");
        selectOneMenuTaxable.setValue("");
        selectOneMenuCategory.setValue("");
        return null;
    }

    public String buttonSave_action() {
        boolean success = false;
        EarningDeductionManager earnDeductMgr = new EarningDeductionManager();
        for (int i = 0; i < getEarningDeductionList().size(); i++) {
            if (getEarningDeductionList().get(i).getOperationStatus() == FMS_Utility.NO_OPERATION) {
                success = true;
            } else if (getEarningDeductionList().get(i).getDbStatus() == FMS_Utility.ROW_NOT_SUBMITED) {
                if (getEarningDeductionList().get(i).getOperationStatus() == FMS_Utility.ROW_ADDED) {
                    success = earnDeductMgr.saveEarningDeduction(getEarningDeductionList().get(i).getCode(),
                            getEarningDeductionList().get(i).getDescription(), getEarningDeductionList().get(i).getType(), getEarningDeductionList().get(i).getTaxable(), getEarningDeductionList().get(i).getCategory());
                } else if (getEarningDeductionList().get(i).getOperationStatus() == FMS_Utility.ROW_UPDATED) {
                    success = earnDeductMgr.saveEarningDeduction(getEarningDeductionList().get(i).getCode(),
                            getEarningDeductionList().get(i).getDescription(), getEarningDeductionList().get(i).getType(), getEarningDeductionList().get(i).getTaxable(), getEarningDeductionList().get(i).getCategory());

                } else if (getEarningDeductionList().get(i).getOperationStatus() == FMS_Utility.ROW_DELETED) {
                    success = true;
                }

            } else {
                if (getEarningDeductionList().get(i).getOperationStatus() == FMS_Utility.ROW_UPDATED) {
                    success = earnDeductMgr.updateEarningDeduction(getEarningDeductionList().get(i).getCode(),
                            getEarningDeductionList().get(i).getDescription(), getEarningDeductionList().get(i).getType(), getEarningDeductionList().get(i).getTaxable(), getEarningDeductionList().get(i).getCategory());
                } else if (getEarningDeductionList().get(i).getOperationStatus() == FMS_Utility.ROW_DELETED) {
                    success = earnDeductMgr.deleteEarningDeduction(getEarningDeductionList().get(i).getCode());
                }
            }

        }
        if (success) {
            outputTextAlertMessage.setValue("Your Task Successfully Committed!");
            outputTextAlertMessage.setStyleClass("success");
            showConformationMsg(panelLayoutMessage.getStyleClass().toString());

        } else {
            outputTextAlertMessage.setStyleClass("error");
            this.outputTextAlertMessage.setValue("Error while saving some of your tasks...!");
            showConformationMsg(panelLayoutMessage.getStyleClass().toString());

        }
        return null;
    }

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
        if (getSelectedRow() == selectedRowIndex) {
            setSelectedRow(-1);
        } else {
            setSelectedRow(selectedRowIndex);
        }

    }

    public String buttonSaveChanges_action() {
        if (getSelectedRow() != -1) {
            getEarningDeductionList().get(getSelectedRow()).
                    setCode(inputTextCode.getValue().toString());
            getEarningDeductionList().get(getSelectedRow()).setDescription(this.inputTextDescription.getValue().toString());
            getEarningDeductionList().get(getSelectedRow()).setType(selectOneMenuType.getValue().toString());
            getEarningDeductionList().get(getSelectedRow()).setTaxable(selectOneMenuTaxable.getValue().toString());
            getEarningDeductionList().get(getSelectedRow()).setCategory(Integer.parseInt(selectOneMenuCategory.getValue().toString()));
            if (Integer.parseInt(selectOneMenuTaxable.getValue().toString()) == FMS_Utility.YES) {
                getEarningDeductionList().get(getSelectedRow()).setTaxableDescription("YES");
            } else if (Integer.parseInt(selectOneMenuTaxable.getValue().toString()) == FMS_Utility.NO) {
                getEarningDeductionList().get(getSelectedRow()).setTaxableDescription("NO");
            } else if (Integer.parseInt(selectOneMenuTaxable.getValue().toString()) == FMS_Utility.NOT_APPLICABLE) {
                getEarningDeductionList().get(getSelectedRow()).setTaxableDescription("N/A");
            }
            if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_LUMP_SUM) {
                getEarningDeductionList().get(getSelectedRow()).setCategoryDescription("LUMP_SUM");
            } else if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_PERCENT) {
                getEarningDeductionList().get(getSelectedRow()).setCategoryDescription("PERCENT");
            } else if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_PER_WORKING_DAYS) {
                getEarningDeductionList().get(getSelectedRow()).setCategoryDescription("WORKING_DAYS");
            } else if (Integer.parseInt(selectOneMenuCategory.getValue().toString()) == EarningDeductionManager.BASED_ON_QUOTA) {
                getEarningDeductionList().get(getSelectedRow()).setCategoryDescription("QUOTA");
            }
            getEarningDeductionList().get(getSelectedRow()).setOperationStatus(FMS_Utility.ROW_UPDATED);
            getEarningDeductionList().get(getSelectedRow()).setRowStyle(FMS_Utility.UPDATED_STYLE);
            buttonAdd.setDisabled(true);
            buttonSaveChanges.setDisabled(true);
            setEarningDeductionPanelPopUpFlag(false);
        }

        return null;
    }

    public String buttonUpdate_action() {

        if (getSelectedRow() != -1) {
            buttonSaveChanges.setDisabled(false);
            this.selectOneMenuCategory.setValue(getEarningDeductionList().get(getSelectedRow()).getCategory());
            this.inputTextCode.setValue(getEarningDeductionList().get(getSelectedRow()).getCode());
            this.inputTextDescription.setValue(getEarningDeductionList().get(getSelectedRow()).getDescription());
            this.selectOneMenuType.setValue(getEarningDeductionList().get(getSelectedRow()).getType());
            buttonAdd.setDisabled(true);
            setEarningDeductionPanelPopUpFlag(true);
        } else {
            outputTextAlertMessage.setValue("Please Select Row First");
            outputTextAlertMessage.setStyleClass("error");
            showConformationMsg(panelLayoutMessage.getStyleClass().toString());

        }

        return null;
    }

    public void selectOneMenuEarningDeductionCode_processValueChange(ValueChangeEvent vce) {
    }

    public String buttonSearch_action() {
        if (selectOneMenuEarningDeductionCode.getValue() != null) {
            ArrayList<HashMap> searchResult;
            EarningDeductionManager earnDedMgr = new EarningDeductionManager();
            searchResult = earnDedMgr.searchEarningDeduction(selectOneMenuEarningDeductionCode.getValue().toString().split("_")[0]);
            getEarningDeductionList().clear();
            for (int i = 0; i < searchResult.size(); i++) {
                EarningDeductionInternal internal = new EarningDeductionInternal();
                internal.setCode(searchResult.get(i).get("CODE").toString());
                internal.setDescription(searchResult.get(i).get("DESCRIPTION").toString());
                internal.setType(searchResult.get(i).get("TYPE").toString());
                internal.setTaxable(searchResult.get(i).get("TAXABLE").toString());
                if (Integer.parseInt(searchResult.get(i).get("TAXABLE").toString()) == FMS_Utility.YES) {
                    internal.setTaxableDescription("YES");
                } else if (Integer.parseInt(searchResult.get(i).get("TAXABLE").toString()) == FMS_Utility.NO) {
                    internal.setTaxableDescription("NO");
                } else if (Integer.parseInt(searchResult.get(i).get("TAXABLE").toString()) == FMS_Utility.NOT_APPLICABLE) {
                    internal.setTaxableDescription("N/A");
                }
                if (Integer.parseInt(searchResult.get(i).get("CATEGORY").toString()) == EarningDeductionManager.BASED_ON_LUMP_SUM) {
                    internal.setCategoryDescription("LUMP_SUM");
                } else if (Integer.parseInt(searchResult.get(i).get("CATEGORY").toString()) == EarningDeductionManager.BASED_ON_PERCENT) {
                    internal.setCategoryDescription("PERCENT");
                } else if (Integer.parseInt(searchResult.get(i).get("CATEGORY").toString()) == EarningDeductionManager.BASED_ON_PER_WORKING_DAYS) {
                    internal.setCategoryDescription("WORKING_DAYS");
                } else if (Integer.parseInt(searchResult.get(i).get("CATEGORY").toString()) == EarningDeductionManager.BASED_ON_QUOTA) {
                    internal.setCategoryDescription("QUOTA");
                }
                internal.setCategory(Integer.parseInt(searchResult.get(i).get("CATEGORY").toString()));
                internal.setOperationStatus(FMS_Utility.NO_OPERATION);
                internal.setDbStatus(FMS_Utility.ROW_SUBMITED);
                internal.setRowStyle(FMS_Utility.NORMAL_STYLE);
                getEarningDeductionList().add(internal);
            }
        } else {
            outputTextAlertMessage.setValue("Please Select Code First");
            outputTextAlertMessage.setStyleClass("error");
            showConformationMsg(panelLayoutMessage.getStyleClass().toString());
        }

        return null;
    }

    public String buttonDelete_action() {
        if (getSelectedRow() != -1) {
            getEarningDeductionList().get(getSelectedRow()).setOperationStatus(FMS_Utility.ROW_DELETED);
            getEarningDeductionList().get(getSelectedRow()).setRowStyle(FMS_Utility.DELETED_STYLE);

        } else {
            outputTextAlertMessage.setValue("Please Select Row First");
            outputTextAlertMessage.setStyleClass("error");
            showConformationMsg(panelLayoutMessage.getStyleClass().toString());


        }

        return null;
    }

    public void selectOneMenuType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals("Deduction")) {
            selectOneMenuTaxable.setDisabled(true);
            selectOneMenuTaxable.setValue(FMS_Utility.NOT_APPLICABLE);
        } else {
            selectOneMenuTaxable.setDisabled(false);
        }
    }

    
}



