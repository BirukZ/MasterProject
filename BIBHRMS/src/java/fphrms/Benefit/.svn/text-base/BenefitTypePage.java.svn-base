/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Benefit;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.AutoAllCompleteDictionaryBenefit;
import fphrms.DeviceList;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.tree.DefaultTreeModel;
import manager.benefitManager.BenefitTypesManager;
import manager.benefitManager.BenefitTypesManager.BenefitTypeModel;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.CommonValidation;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class BenefitTypePage extends AbstractPageBean {

    BenefitTypesManager benefitTypesManager = new BenefitTypesManager();
    DepartmentManage departmentManager = new DepartmentManage();
    BenefitTypeModel benefitTypeModel = new BenefitTypeModel();
    ArrayList<BenefitTypeModel> benefitTypesList = benefitTypesManager.getAllBenefitTypes();
    ArrayList<Option> benefitTypesOption = benefitTypesManager.getAllBenefitTypesOption();
    ArrayList<Option> benefitDurationOption = benefitTypesManager.getBenefitGivenInterval();
    ArrayList<Option> SaftType = benefitTypesManager.getSaftyDeviceNot();
    ArrayList<Option> materials = benefitTypesManager.getAllBenefitTypesOption();
    ArrayList<Option> positionTypesOption = new ArrayList<Option>();
    DeviceList currentBenefit = new DeviceList("", "0");
    private String selectedBenefitId;
    private String selectedBenefitName;
    int benefitId;
    int benefitPositionId;
    String benefitName;
    boolean monetaryOrNonmonetary;
    boolean percentOrNot;
    String benefitType;
    String benefitDescription;
    String benefitTermLength;
    String benefitCatagory;
    String status;
    String dataBaseStatus;
    String selected;
    int positionId;
    String positionName;
    int quantity;
    String remark;
    boolean rendered;
    float moneyValue;
    int percrnt;
    boolean saftyDevice;
    String saftyDevices = "No";
    String deviceCode;
    String deviceName;
    private static String selectedId;

    public String getSelectedBenefitName() {
        return selectedBenefitName;
    }

    public void setSelectedBenefitName(String selectedBenefitName) {
        this.selectedBenefitName = selectedBenefitName;
    }

    public String getSelectedBenefitId() {
        return selectedBenefitId;
    }

    public void setSelectedBenefitId(String selectedBenefitId) {
        this.selectedBenefitId = selectedBenefitId;
    }
    List matchesList = new ArrayList<SelectItem>();

    public List getList() {
        return matchesList;
    }

    public List getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }
    //==============================================================================
    int selectedBenefitTypeRow = -1;
    int selectedBenefitPositionTypeRow = -1;

    public ArrayList<Option> getBenefitDurationOption() {
        return benefitDurationOption;
    }

    public void setBenefitDurationOption(ArrayList<Option> benefitDurationOption) {
        this.benefitDurationOption = benefitDurationOption;
    }

    public BenefitTypeModel getBenefitTypeModel() {
        return benefitTypeModel;
    }

    public float getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(float moneyValue) {
        this.moneyValue = moneyValue;
    }

    public int getPercrnt() {
        return percrnt;
    }

    public void setPercrnt(int percrnt) {
        this.percrnt = percrnt;
    }

    public String getDataBaseStatus() {
        return dataBaseStatus;
    }

    public ArrayList<Option> getSaftType() {
        return SaftType;
    }

    public void setSaftType(ArrayList<Option> SaftType) {
        this.SaftType = SaftType;
    }

    public void setDataBaseStatus(String dataBaseStatus) {
        this.dataBaseStatus = dataBaseStatus;
    }

    public boolean isPercentOrNot() {
        return percentOrNot;
    }

    public void setPercentOrNot(boolean percentOrNot) {
        this.percentOrNot = percentOrNot;
    }

    public void setBenefitTypeModel(BenefitTypeModel benefitTypeModel) {
        this.benefitTypeModel = benefitTypeModel;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public int getSelectedBenefitPositionTypeRow() {
        return selectedBenefitPositionTypeRow;
    }

    public void setSelectedBenefitPositionTypeRow(int selectedBenefitPositionTypeRow) {
        this.selectedBenefitPositionTypeRow = selectedBenefitPositionTypeRow;
    }

    public int getSelectedBenefitTypeRow() {
        return selectedBenefitTypeRow;
    }

    public void setSelectedBenefitTypeRow(int selectedBenefitTypeRow) {
        this.selectedBenefitTypeRow = selectedBenefitTypeRow;
    }

    //==============================================================================
    // <editor-fold defaultstate="collapsed" desc="All Getters And Setters">
    public ArrayList<BenefitTypeModel> getBenefitTypesList() {
        return benefitTypesList;
    }

    public void setBenefitTypesList(ArrayList<BenefitTypeModel> benefitTypesList) {
        this.benefitTypesList = benefitTypesList;
    }

    public BenefitTypesManager getBenefitTypesManager() {
        return benefitTypesManager;
    }

    public void setBenefitTypesManager(BenefitTypesManager benefitTypesManager) {
        this.benefitTypesManager = benefitTypesManager;
    }

    public ArrayList<Option> getBenefitTypesOption() {
        return benefitTypesOption;
    }

    public void setBenefitTypesOption(ArrayList<Option> benefitTypesOption) {
        this.benefitTypesOption = benefitTypesOption;
    }

    public ArrayList<Option> getPositionTypesOption() {
        return positionTypesOption;
    }

    public void setPositionTypesOption(ArrayList<Option> positionTypesOption) {
        this.positionTypesOption = positionTypesOption;
    }

    // </editor-fold >
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
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
    private PanelLayout pnProfile = new PanelLayout();

    public PanelLayout getPnProfile() {
        return pnProfile;
    }

    public void setPnProfile(PanelLayout pl) {
        this.pnProfile = pl;
    }
    private HtmlPanelGroup pnlGrpPowerDeligationContent = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlGrpPowerDeligationContent() {
        return pnlGrpPowerDeligationContent;
    }

    public void setPnlGrpPowerDeligationContent(HtmlPanelGroup hpg) {
        this.pnlGrpPowerDeligationContent = hpg;
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
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultTree treeModel = new DefaultTree();
    private DefaultTree defaultTreeModel = new DefaultTree();
    private Tree treeOrgStructure = new Tree();
    private PanelLayout pnlLayoutTree = new PanelLayout();

    public PanelLayout getPnlLayoutTree() {
        return pnlLayoutTree;
    }

    public void setPnlLayoutTree(PanelLayout pnlLayoutTree) {
        this.pnlLayoutTree = pnlLayoutTree;
    }

    public DefaultTree getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTree treeModel) {
        this.treeModel = treeModel;
    }

    public DefaultTree getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public void setDefaultTreeModel(DefaultTree defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

    public Tree getTreeOrgStructure() {
        return treeOrgStructure;
    }

    public void setTreeOrgStructure(Tree treeOrgStructure) {
        this.treeOrgStructure = treeOrgStructure;
    }
    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    //private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

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

    public String getBenefitCatagory() {
        return benefitCatagory;
    }

    public void setBenefitCatagory(String benefitCatagory) {
        this.benefitCatagory = benefitCatagory;
    }

    public DepartmentManage getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManage departmentManager) {
        this.departmentManager = departmentManager;
    }

    public String getBenefitDescription() {
        return benefitDescription;
    }

    public void setBenefitDescription(String benefitDescription) {
        this.benefitDescription = benefitDescription;
    }

    public int getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(int benefitId) {
        this.benefitId = benefitId;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public int getBenefitPositionId() {
        return benefitPositionId;
    }

    public void setBenefitPositionId(int benefitPositionId) {
        this.benefitPositionId = benefitPositionId;
    }

    public String getBenefitTermLength() {
        return benefitTermLength;
    }

    public void setBenefitTermLength(String benefitTermLength) {
        this.benefitTermLength = benefitTermLength;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
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

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private HtmlSelectOneMenu drlBenefitEdit = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBenefitEdit() {
        return drlBenefitEdit;
    }

    public void setDrlBenefitEdit(HtmlSelectOneMenu drlBenefitEdit) {
        this.drlBenefitEdit = drlBenefitEdit;
    }
    private DefaultSelectedData defaultSelectedDataDisciplineCategory = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataDisciplineCategory() {
        return defaultSelectedDataDisciplineCategory;
    }

    public void setDefaultSelectedDataDisciplineCategory(DefaultSelectedData defaultSelectedDataDisciplineCategory) {
        this.defaultSelectedDataDisciplineCategory = defaultSelectedDataDisciplineCategory;
    }
    private HtmlCommandButton btnAddToTable = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddToTable() {
        return btnAddToTable;
    }

    public void setBtnAddToTable(HtmlCommandButton hcb) {
        this.btnAddToTable = hcb;
    }
    private HtmlInputText txtBenefitName = new HtmlInputText();

    public HtmlInputText getTxtBenefitName() {
        return txtBenefitName;
    }

    public void setTxtBenefitName(HtmlInputText hit) {
        this.txtBenefitName = hit;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
    }
    HtmlOutputText lblMessageOnPopupHeader = new HtmlOutputText();

    public HtmlOutputText getLblMessageOnPopupHeader() {
        return lblMessageOnPopupHeader;
    }

    public void setLblMessageOnPopupHeader(HtmlOutputText lblMessageOnPopupHeader) {
        this.lblMessageOnPopupHeader = lblMessageOnPopupHeader;
    }

    public boolean isMonetaryOrNonmonetary() {
        return monetaryOrNonmonetary;
    }

    public void setMonetaryOrNonmonetary(boolean monetaryOrNonmonetary) {
        this.monetaryOrNonmonetary = monetaryOrNonmonetary;
    }
    private HtmlSelectOneMenu drlTermLength = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTermLength() {
        return drlTermLength;
    }

    public void setDrlTermLength(HtmlSelectOneMenu hsom) {
        this.drlTermLength = hsom;
    }
    private HtmlInputText txBenefitType = new HtmlInputText();

    public HtmlInputText getTxBenefitType() {
        return txBenefitType;
    }

    public void setTxBenefitType(HtmlInputText hit) {
        this.txBenefitType = hit;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlOutputLabel lblPopupbenefitType = new HtmlOutputLabel();

    public HtmlOutputLabel getLblPopupbenefitType() {
        return lblPopupbenefitType;
    }

    public void setLblPopupbenefitType(HtmlOutputLabel hol) {
        this.lblPopupbenefitType = hol;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlInputText txtPercent = new HtmlInputText();

    public HtmlInputText getTxtPercent() {
        return txtPercent;
    }

    public void setTxtPercent(HtmlInputText hit) {
        this.txtPercent = hit;
    }
    private HtmlSelectBooleanCheckbox chkPercnt = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkPercnt() {
        return chkPercnt;
    }

    public void setChkPercnt(HtmlSelectBooleanCheckbox hsbc) {
        this.chkPercnt = hsbc;
    }
    private HtmlOutputLabel lblPercent = new HtmlOutputLabel();

    public HtmlOutputLabel getLblPercent() {
        return lblPercent;
    }

    public void setLblPercent(HtmlOutputLabel hol) {
        this.lblPercent = hol;
    }
    private HtmlOutputLabel lblPercenSymbol = new HtmlOutputLabel();

    public HtmlOutputLabel getLblPercenSymbol() {
        return lblPercenSymbol;
    }

    public void setLblPercenSymbol(HtmlOutputLabel hol) {
        this.lblPercenSymbol = hol;
    }
    private HtmlOutputLabel lblInPercent = new HtmlOutputLabel();

    public HtmlOutputLabel getLblInPercent() {
        return lblInPercent;
    }

    public void setLblInPercent(HtmlOutputLabel hol) {
        this.lblInPercent = hol;
    }
    private HtmlSelectOneMenu drlSafty = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSafty() {
        return drlSafty;
    }

    public void setDrlSafty(HtmlSelectOneMenu hsom) {
        this.drlSafty = hsom;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private HtmlInputText txtDeviceNAme = new HtmlInputText();

    public HtmlInputText getTxtDeviceNAme() {
        return txtDeviceNAme;
    }

    public void setTxtDeviceNAme(HtmlInputText hit) {
        this.txtDeviceNAme = hit;
    }
    private HtmlInputText txtDeviceCode = new HtmlInputText();

    public HtmlInputText getTxtDeviceCode() {
        return txtDeviceCode;
    }

    public void setTxtDeviceCode(HtmlInputText hit) {
        this.txtDeviceCode = hit;
    }
    private SelectInputText txtSearchByDevice = new SelectInputText();

    public SelectInputText getTxtSearchByDevice() {
        return txtSearchByDevice;
    }

    public void setTxtSearchByDevice(SelectInputText sit) {
        this.txtSearchByDevice = sit;
    }
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public BenefitTypePage() {
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

    public boolean validateBenefitType() {
        if (txtBenefitName.getValue() == null || txtBenefitName.getValue().toString().equals("") ||
                txBenefitType.getValue() == null || txBenefitType.getValue().toString().equals("") ||
                txtaDescription.getValue() == null || txtaDescription.getValue().toString().equals("") ||
                drlTermLength.getValue() == null || drlTermLength.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
//        } else if (ckbBenefitMonetary.isSelected()) {
//            try {
//                Double.parseDouble(txBenefitType.getValue().toString());
//            } catch (Exception nfe) {
//                showSuccessOrFailureMessage(false, "INVALID OR EMPTY MONITARY VALUE ");
//                return false;
//            }
        }
        return true;
    }

    private boolean isBenefitRegistered(String benefitName) {
          if(benefitName.equalsIgnoreCase("Safty Device")){
          return false;
          }
          else{
        for (BenefitTypeModel currentBenefitType : benefitTypesList) {
            if (currentBenefitType.getBenefitName().equals(benefitName)) {
                return true;
            }
        }
          }
        return false;
    }

    public String cmdLnkEdit_action() {
        if (selectedBenefitTypeRow != -1) {
            if (benefitTypesList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("Old")) {
                benefitTypesList.get(selectedBenefitTypeRow).setDataBaseStatus("Edited");
            }
        }
        return null;
    }

    public String cmdLnkRemove_action() {
        if (selectedBenefitTypeRow != -1) {
            if (benefitTypesList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("New")) {
                benefitTypesList.remove(selectedBenefitTypeRow);
            } else if (benefitTypesList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("Old") ||
                    benefitTypesList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("Edited")) {
                benefitTypesList.get(selectedBenefitTypeRow).setDataBaseStatus("Deleted");
            }
        }
        return null;
    }

    public void cmdLnkTree_processAction(ActionEvent ae) {
        String departmentName;
        String department = treeOrgStructure.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];
            String departmentId = _department[1].trim();
            // txtDepartment.setValue(departmentName);
            pnlLayoutTree.setRendered(false);
            positionTypesOption = departmentManager.readJobCodeOption(departmentId);
        }
    }

    private void clearBenefitComponebts() {
        txtBenefitName.setValue(null);
        txBenefitType.setValue(null);
        txtaDescription.setValue(null);
        drlTermLength.setValue("-1");
        chkPercnt.setSelected(false);
        txtPercent.setValue(null);
        lblPercenSymbol.setRendered(false);
        txtPercent.setRendered(false);
        lblPercent.setRendered(false);
        txtDeviceCode.resetValue();
        txtDeviceNAme.resetValue();
        txtSearchByDevice.resetValue();
    }

    public String btnDepartmentTree_action() {
        LoadTree loadTree = new LoadTree();
        treeModel.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        pnlLayoutTree.setRendered(true);
        return null;
    }

    public void rowSelectorBenefitType_processMyEvent(RowSelectorEvent rse) {
        selectedBenefitTypeRow = rse.getRow();
    }

    public String btnAddToTable_action() {
        //if (validateBenefitType()) {
        benefitName = txtBenefitName.getValue().toString();
      
        if (isBenefitRegistered(benefitName)) {
            showSuccessOrFailureMessage(false, "ALREADY REGISTERED");
        } else {
            benefitType = txBenefitType.getValue().toString();
            benefitDescription = txtaDescription.getValue().toString();
            benefitTermLength = drlTermLength.getValue().toString();
            benefitType = txBenefitType.getValue().toString();
            benefitCatagory = txBenefitType.getValue().toString();
            dataBaseStatus = "New";
            rendered = false;
            percentOrNot = chkPercnt.isSelected();
            if (chkPercnt.isSelected() == true) {
                percrnt = Integer.valueOf(txtPercent.getValue().toString());
                saftyDevices = "No";
            } else {
                percrnt = 0;

            }
            if ((txtSearchByDevice.getValue() == null) || (txtSearchByDevice.getValue().equals(""))) {

                saftyDevices = "No";
            } else {
                saftyDevices = txtSearchByDevice.getValue().toString();
            }

            benefitTypesList.add(0, new BenefitTypeModel(benefitName, benefitType, benefitDescription, benefitCatagory, benefitTermLength, dataBaseStatus, rendered, percrnt, percentOrNot, saftyDevices));


        }
        clearBenefitComponebts();
        return null;
    }

    public String btnPopupSaveBenefitType_action() {
        if (benefitTypesManager.saveBenefitTypes(benefitTypesList)) {
            showSuccessOrFailureMessage(true, "SUCCESS");
            benefitTypesOption = benefitTypesManager.getAllBenefitTypesOption();
        } else {
            showSuccessOrFailureMessage(true, "FAILED");
        }
        return null;
    }

    public void page_header_processMyEvent(DragEvent de) {
    }

    public String btnPopupSaveDiscipline_action() {
        if (benefitTypesManager.saveBenefitTypes(benefitTypesList)) {
            showSuccessOrFailureMessage(true, "SUCCESS");
            benefitTypesList = benefitTypesManager.getAllBenefitTypes();
        } else {
            showSuccessOrFailureMessage(false, "FAILED");
        }
        return null;
    }

    public String btnPopupResetDiscipline_action() {
        clearBenefitComponebts();
        benefitTypesList = benefitTypesManager.getAllBenefitTypes();
        return null;
    }

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
        selectedBenefitTypeRow = selectedRowIndex;
    }

    public void ckbBenefitMonetary_validate(FacesContext context, UIComponent component, Object value) {
    }

    public String txtAmount_in_Birr_action() {
        //return null means stay on the same page
        return null;
    }

    public void chkPercnt_processValueChange(ValueChangeEvent vce) {
        if (chkPercnt.isSelected()) {
            txtPercent.setRendered(true);
            lblPercenSymbol.setRendered(true);
            lblPercent.setRendered(true);
        } else {
            txtPercent.setRendered(false);
            lblPercenSymbol.setRendered(false);
            lblPercent.setRendered(false);
        }
    }

    public void chkSaftyandBenefit_processValueChange(ValueChangeEvent vce) {
    }

    private boolean populateDeviceList(String deviceCodee) {
        HashMap empInfoHashMapss = benefitTypesManager.readDeviceBasicInfo(deviceCodee);
        if (empInfoHashMapss != null) {
            if (empInfoHashMapss.get("deviceCode").toString().equals("") && empInfoHashMapss.get("deviceCode").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO Device  FOUND WITH MATERIAL CODE : " + deviceCode);
                deviceCode = null;
                return false;
            } else {
                deviceCode = deviceCodee;
                txtDeviceCode.setValue(empInfoHashMapss.get("deviceCode"));
                txtDeviceNAme.setValue(empInfoHashMapss.get("DESCRIPTION"));
                return true;
            }
        } else {
            deviceCode = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    public String txtSearchByDevice_action() {
        //return null means stay on the same page
        selectedId = null;
        selectedId = this.getSelectedBenefitName();
        if (selectedId != null) {
            //clearAllComponents();
            txtDeviceCode.resetValue();
            txtDeviceNAme.resetValue();
            txtBenefitName.resetValue();
            txBenefitType.resetValue();
            txtDeviceCode.setValue(getSelectedBenefitId());
            txtDeviceNAme.setValue(getSelectedBenefitName());
            txtBenefitName.setValue("Safty Device");
            txBenefitType.setValue("Safty Device");

        } else {
            saftyDevices = "No";
        }
        return null;

    }

    public void txtSearchByDevice_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null && !CommonValidation.isUpdatePhase(vce)) {
            AutoAllCompleteDictionaryBenefit.init(vce.getNewValue().toString());
            this.matchesList = AutoAllCompleteDictionaryBenefit.dictionary;
            if (vce.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete1 = (SelectInputText) vce.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete1.getSelectedItem() != null) {
                    currentBenefit = (DeviceList) autoComplete1.getSelectedItem().getValue();
                    setSelectedBenefitId(currentBenefit.getDiviceCode());
                    setSelectedBenefitName(currentBenefit.getDiviceName());
                } //
            }
        } else {
            saftyDevices = "No";
        }
    }
}
