/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Organization;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import fphrms.*;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.tree.IceUserObject;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.LookUpManager;
import manager.organizationManager.LoadTree;
import manager.organizationManager.OrganizationManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class OrganizationPage extends AbstractPageBean {

    DepartmentManage departmentManage = new DepartmentManage();
    OrganizationManager organizationManager = new OrganizationManager();
    LookUpManager lookUpManager = new LookUpManager();
    // public Option[] religon;//=
    //  public Option[] zoneCityType = null;
    public Option[] woreda = null;
    public Option[] optKebele = null;
    ArrayList<SelectItem> religon = new ArrayList<SelectItem>();
    ArrayList<SelectItem> zoneCityType = new ArrayList<SelectItem>();
    ArrayList<SelectItem> addressCodeList = departmentManage.getAddressCode();
    public List departmentList = new ArrayList<DepartmentManage>();
    public List departmentUpdateList = new ArrayList<DepartmentManage>();
    int selectedNoAttenRow = -1;
    int buttonIdentifier = 0;
    int jobTableSize = 0;
    int countJob = 0;
    String createNewDepartmentID;
    public boolean relodTable = true;
    String departmentName;
    String departmentIDFromDes;
    int avilabelOnDb = 0;

    public List getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List departmentList) {
        this.departmentList = departmentList;
    }

    public List getDepartmentUpdateList() {
        return departmentUpdateList;
    }

    public void setDepartmentUpdateList(List departmentUpdateList) {
        this.departmentUpdateList = departmentUpdateList;
    }

    public int getAvilabelOnDb() {
        return avilabelOnDb;
    }

    public void setAvilabelOnDb(int avilabelOnDb) {
        this.avilabelOnDb = avilabelOnDb;
    }

    public String getDepartmentIDFromDes() {
        return departmentIDFromDes;
    }

    public void setDepartmentIDFromDes(String departmentIDFromDes) {
        this.departmentIDFromDes = departmentIDFromDes;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
    long departmentId = 0;

    public String getCreateNewDepartmentID() {
        return createNewDepartmentID;
    }

    public void setCreateNewDepartmentID(String createNewDepartmentID) {
        this.createNewDepartmentID = createNewDepartmentID;
    }

    public ArrayList<SelectItem> getZoneCityType() {
        return zoneCityType;
    }

    public void setZoneCityType(ArrayList<SelectItem> zoneCityType) {
        this.zoneCityType = zoneCityType;
    }

    public ArrayList<SelectItem> getReligon() {
        return lookUpManager.readRegion();
    }

    public void setReligon(ArrayList<SelectItem> religon) {
        this.religon = religon;
    }
    public double newDepartmentID = 0;

    public double getNewDepartmentID() {
        return newDepartmentID;
    }

    public void setNewDepartmentID(double newDepartmentID) {
        this.newDepartmentID = newDepartmentID;
    }

    public Option[] getOptKebele() {
        return optKebele;
    }

    public void setOptKebele(Option[] optKebele) {
        this.optKebele = optKebele;
    }

    public Option[] getWoreda() {
        return woreda;
    }

    public void setWoreda(Option[] woreda) {
        this.woreda = woreda;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
        choSaveJob.setSelected(true);
        disableComponets();
        disableDepartemntComponets();
        choSaveJob.setSelected(true);
        clearComponents();
        btnEdit.setDisabled(true);
        btnDelete.setDisabled(true);
        btnSave.setDisabled(true);

    //fires node function
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
    private DefaultTree tree1Model = new DefaultTree();

    public DefaultTree getTree1Model() {
        return tree1Model;
    }

    public void setTree1Model(DefaultTree dt) {
        this.tree1Model = dt;
    }
    private Tree tree1 = new Tree();

    public Tree getTree1() {
        return tree1;
    }

    public void setTree1(Tree t) {
        this.tree1 = t;
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
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlSelectOneMenu drlJobType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJobType() {
        return drlJobType;
    }

    public void setDrlJobType(HtmlSelectOneMenu hsom) {
        this.drlJobType = hsom;
    }
    private HtmlInputText txtJobCode = new HtmlInputText();

    public HtmlInputText getTxtJobCode() {
        return txtJobCode;
    }

    public void setTxtJobCode(HtmlInputText hit) {
        this.txtJobCode = hit;
    }
    private HtmlOutputText outputText10 = new HtmlOutputText();
    private HtmlOutputText outputTextNumberOfEmployee = new HtmlOutputText();

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public int getButtonIdentifier() {
        return buttonIdentifier;
    }

    public void setButtonIdentifier(int buttonIdentifier) {
        this.buttonIdentifier = buttonIdentifier;
    }

    public int getCountJob() {
        return countJob;
    }

    public void setCountJob(int countJob) {
        this.countJob = countJob;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getJobTableSize() {
        return jobTableSize;
    }

    public void setJobTableSize(int jobTableSize) {
        this.jobTableSize = jobTableSize;
    }

    public LookUpManager getLookUpManager() {
        return lookUpManager;
    }

    public void setLookUpManager(LookUpManager lookUpManager) {
        this.lookUpManager = lookUpManager;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public OrganizationManager getOrganizationManager() {
        return organizationManager;
    }

    public void setOrganizationManager(OrganizationManager organizationManager) {
        this.organizationManager = organizationManager;
    }

    public HtmlOutputText getOutputTextNumberOfEmployee() {
        return outputTextNumberOfEmployee;
    }

    public void setOutputTextNumberOfEmployee(HtmlOutputText outputTextNumberOfEmployee) {
        this.outputTextNumberOfEmployee = outputTextNumberOfEmployee;
    }

    public static int getParentIndex() {
        return parentIndex;
    }

    public static void setParentIndex(int parentIndex) {
        OrganizationPage.parentIndex = parentIndex;
    }

    public boolean isRelodTable() {
        return relodTable;
    }

    public void setRelodTable(boolean relodTable) {
        this.relodTable = relodTable;
    }

    public int getSelectedNoAttenRow() {
        return selectedNoAttenRow;
    }

    public void setSelectedNoAttenRow(int selectedNoAttenRow) {
        this.selectedNoAttenRow = selectedNoAttenRow;
    }

    public HtmlOutputText getOutputText10() {
        return outputText10;
    }

    public void setOutputText10(HtmlOutputText hot) {
        this.outputText10 = hot;
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
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlInputText txtUnitname = new HtmlInputText();

    public HtmlInputText getTxtUnitname() {
        return txtUnitname;
    }

    public void setTxtUnitname(HtmlInputText hit) {
        this.txtUnitname = hit;
    }
    private HtmlInputText txtEstablishedDate = new HtmlInputText();

    public HtmlInputText getTxtEstablishedDate() {
        return txtEstablishedDate;
    }

    public void setTxtEstablishedDate(HtmlInputText hit) {
        this.txtEstablishedDate = hit;
    }
    private HtmlInputTextarea txtMission = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtMission() {
        return txtMission;
    }

    public void setTxtMission(HtmlInputTextarea hit) {
        this.txtMission = hit;
    }
    private HtmlInputTextarea txtVision = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtVision() {
        return txtVision;
    }

    public void setTxtVision(HtmlInputTextarea hit) {
        this.txtVision = hit;
    }
    private PanelPopup pnlPopUpMsg = new PanelPopup();

    public PanelPopup getPnlPopUpMsg() {
        return pnlPopUpMsg;
    }

    public void setPnlPopUpMsg(PanelPopup pp) {
        this.pnlPopUpMsg = pp;
    }
    private HtmlCommandButton btnPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYes() {
        return btnPopUpYes;
    }

    public void setBtnPopUpYes(HtmlCommandButton hcb) {
        this.btnPopUpYes = hcb;
    }
    private HtmlCommandButton btnPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpNo() {
        return btnPopUpNo;
    }

    public void setBtnPopUpNo(HtmlCommandButton hcb) {
        this.btnPopUpNo = hcb;
    }
    private HtmlOutputText lblPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMain() {
        return lblPopUpMsgMain;
    }

    public void setLblPopUpMsgMain(HtmlOutputText hot) {
        this.lblPopUpMsgMain = hot;
    }
    private HtmlCommandButton btnPopUpOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpOk() {
        return btnPopUpOk;
    }

    public void setBtnPopUpOk(HtmlCommandButton hcb) {
        this.btnPopUpOk = hcb;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
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
    private DefaultSelectionItems selectOneMenu2DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems1() {
        return selectOneMenu2DefaultItems1;
    }

    public void setSelectOneMenu2DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems2() {
        return selectOneMenu2DefaultItems2;
    }

    public void setSelectOneMenu2DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems3() {
        return selectOneMenu2DefaultItems3;
    }

    public void setSelectOneMenu2DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems3 = dsia;
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
    private HtmlCommandButton btnSaveAd = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveAd() {
        return btnSaveAd;
    }

    public void setBtnSaveAd(HtmlCommandButton hcb) {
        this.btnSaveAd = hcb;
    }
    private HtmlCommandButton btnUpdateAd = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateAd() {
        return btnUpdateAd;
    }

    public void setBtnUpdateAd(HtmlCommandButton hcb) {
        this.btnUpdateAd = hcb;
    }
    private HtmlCommandButton btnResetAd = new HtmlCommandButton();

    public HtmlCommandButton getBtnResetAd() {
        return btnResetAd;
    }

    public void setBtnResetAd(HtmlCommandButton hcb) {
        this.btnResetAd = hcb;
    }
    private HtmlCommandButton btnDeleteAd = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteAd() {
        return btnDeleteAd;
    }

    public void setBtnDeleteAd(HtmlCommandButton hcb) {
        this.btnDeleteAd = hcb;
    }
    private HtmlSelectOneMenu drlRegion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRegion() {
        return drlRegion;
    }

    public void setDrlRegion(HtmlSelectOneMenu hsom) {
        this.drlRegion = hsom;
    }
    private HtmlSelectOneMenu drlWoreda = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlWoreda() {
        return drlWoreda;
    }

    public void setDrlWoreda(HtmlSelectOneMenu hsom) {
        this.drlWoreda = hsom;
    }
    private HtmlSelectOneMenu drlKebelle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlKebelle() {
        return drlKebelle;
    }

    public void setDrlKebelle(HtmlSelectOneMenu hsom) {
        this.drlKebelle = hsom;
    }
    private HtmlInputText txtBlockNo = new HtmlInputText();

    public HtmlInputText getTxtBlockNo() {
        return txtBlockNo;
    }

    public void setTxtBlockNo(HtmlInputText hit) {
        this.txtBlockNo = hit;
    }
    private HtmlInputText txtFloor = new HtmlInputText();

    public HtmlInputText getTxtFloor() {
        return txtFloor;
    }

    public void setTxtFloor(HtmlInputText hit) {
        this.txtFloor = hit;
    }
    private HtmlInputText txtTelOffice = new HtmlInputText();

    public HtmlInputText getTxtTelOffice() {
        return txtTelOffice;
    }

    public void setTxtTelOffice(HtmlInputText hit) {
        this.txtTelOffice = hit;
    }
    private HtmlInputText txtTelExtension = new HtmlInputText();

    public HtmlInputText getTxtTelExtension() {
        return txtTelExtension;
    }

    public void setTxtTelExtension(HtmlInputText hit) {
        this.txtTelExtension = hit;
    }
    private HtmlInputText txtMobile = new HtmlInputText();

    public HtmlInputText getTxtMobile() {
        return txtMobile;
    }

    public void setTxtMobile(HtmlInputText hit) {
        this.txtMobile = hit;
    }
    private HtmlInputText txtOfficeNumber = new HtmlInputText();

    public HtmlInputText getTxtOfficeNumber() {
        return txtOfficeNumber;
    }

    public void setTxtOfficeNumber(HtmlInputText hit) {
        this.txtOfficeNumber = hit;
    }
    private HtmlInputText txtEmail = new HtmlInputText();

    public HtmlInputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(HtmlInputText hit) {
        this.txtEmail = hit;
    }
    private HtmlSelectOneMenu drlZoneCity = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZoneCity() {
        return drlZoneCity;
    }

    public void setDrlZoneCity(HtmlSelectOneMenu hsom) {
        this.drlZoneCity = hsom;
    }
    private HtmlCommandButton btnPopUpYesAd = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYesAd() {
        return btnPopUpYesAd;
    }

    public void setBtnPopUpYesAd(HtmlCommandButton hcb) {
        this.btnPopUpYesAd = hcb;
    }
    private HtmlCommandLink linkEdit = new HtmlCommandLink();

    public HtmlCommandLink getLinkEdit() {
        return linkEdit;
    }

    public void setLinkEdit(HtmlCommandLink hcl) {
        this.linkEdit = hcl;
    }
    private HtmlDataTable tblJob = new HtmlDataTable();

    public HtmlDataTable getTblJob() {
        return tblJob;
    }

    public void setTblJob(HtmlDataTable hdt) {
        this.tblJob = hdt;
    }
    private HtmlCommandLink linkDelete = new HtmlCommandLink();

    public HtmlCommandLink getLinkDelete() {
        return linkDelete;
    }

    public void setLinkDelete(HtmlCommandLink hcl) {
        this.linkDelete = hcl;
    }
    private PanelLayout message = new PanelLayout();

    public PanelLayout getMessage() {
        return message;
    }

    public void setMessage(PanelLayout pl) {
        this.message = pl;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        //defaultSelectedData3.setSelectedBoolean(true);
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectBooleanCheckbox choSaveJob = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoSaveJob() {
        return choSaveJob;
    }

    public void setChoSaveJob(HtmlSelectBooleanCheckbox hsbc) {
        this.choSaveJob = hsbc;
    }
    private RowSelector rowSelectorZoneOrCity = new RowSelector();

    public RowSelector getRowSelectorZoneOrCity() {
        return rowSelectorZoneOrCity;
    }

    public void setRowSelectorZoneOrCity(RowSelector rs) {
        this.rowSelectorZoneOrCity = rs;
    }
    private PanelLayout pnlConfirmationMessageBody = new PanelLayout();

    public PanelLayout getPnlConfirmationMessageBody() {
        return pnlConfirmationMessageBody;
    }

    public void setPnlConfirmationMessageBody(PanelLayout pl) {
        this.pnlConfirmationMessageBody = pl;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessage4 = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private HtmlOutputText lblErrorMessage = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessage() {
        return lblErrorMessage;
    }

    public void setLblErrorMessage(HtmlOutputText hot) {
        this.lblErrorMessage = hot;
    }
    private HtmlInputText txtEmployeeQuantity = new HtmlInputText();

    public HtmlInputText getTxtEmployeeQuantity() {
        return txtEmployeeQuantity;
    }

    public void setTxtEmployeeQuantity(HtmlInputText hit) {
        this.txtEmployeeQuantity = hit;
    }
    private DefaultSelectedData defaultSelectedDataAddressCode = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataAddressCode() {
        return defaultSelectedDataAddressCode;
    }

    public void setDefaultSelectedDataAddressCode(DefaultSelectedData defaultSelectedDataAddressCode) {
        this.defaultSelectedDataAddressCode = defaultSelectedDataAddressCode;
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

    public ArrayList<SelectItem> getAddressCodeList() {
        return addressCodeList;
    }

    public void setAddressCodeList(ArrayList<SelectItem> addressCodeList) {
        this.addressCodeList = addressCodeList;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private HtmlSelectOneMenu drlAddressCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAddressCode() {
        return drlAddressCode;
    }

    public void setDrlAddressCode(HtmlSelectOneMenu hsom) {
        this.drlAddressCode = hsom;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calEstablishedDate = new SelectInputDate();

    public SelectInputDate getCalEstablishedDate() {
        return calEstablishedDate;
    }

    public void setCalEstablishedDate(SelectInputDate sid) {
        this.calEstablishedDate = sid;
    }


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public OrganizationPage() {
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
        departmentList.clear();
        clearComponents();
        clearDepartmentComponents();
        disableDepartemntComponets();
        disableComponets();
        disableComponentsAd();
        clearComponentsAd();
        btnSave.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(true);

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
            log("Page2 Initialization Failure", e);
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
        txtMission.setRequired(true);
        txtEstablishedDate.setRequired(true);
        txtUnitname.setRequired(true);
        txtUnitname.setRequiredMessage("Required");
        txtEstablishedDate.setRequiredMessage("Required");
        txtMission.setRequiredMessage("Required");
        if (relodTable) {
            relodTable = false;
            try {
                LoadTree loadTree = new LoadTree();
                tree1Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
            } catch (Exception ex) {
                ex.printStackTrace();
                tree1.setRendered(false);
            }

        }
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    private DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent,
            String title, String DPlan) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        IceUserObject userObject = new IceUserObject(node);
        userObject.setLeafIcon("../xmlhttp/css/rime/css-images/tree_document.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_folder_close.gif");
        userObject.setBranchExpandedIcon("../xmlhttp/css/rime/css-images/tree_folder_open.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_nav_bottom_close.gif");
        userObject.setExpanded(false);

        node.setUserObject(userObject);
        //userObject.setTreeNode(employee);
        //branch
        if (title != null) {
            userObject.setText(title);
            userObject.setLeaf(false);
            userObject.setExpanded(false);
            node.setAllowsChildren(true);
        } // leaf node
        else {
            userObject.setText(DPlan);
            userObject.setLeaf(true);
            node.setAllowsChildren(false);
        }
        // finally add the node to the parent.
        if (parent != null) {
            parent.add(node);
        }

        return node;
    }

    /**
     * On click the tree display unit information and the address
     * @param ae
     */
/////////////////////////////On click the tree display unit information
    public void cmdLookDetaile_processAction(ActionEvent ae) {
        departmentList.clear();
        departmentUpdateList.clear();
        btnSaveAd.setValue("New");
        btnUpdateAd.setValue("Edit");
        String checkID = "000000";
        int pos = 0;
        clearComponents();
        clearComponentsAd();
        disableComponets();
        disableDepartemntComponets();
        disableComponentsAd();
        // tr = tree1.getCurrentNode().getLevel();
        departmentName = tree1.getCurrentNode().toString();//.substring(0, 2);
        lblDepartment.setValue(departmentName);
        pos = departmentName.lastIndexOf("#");
//        // departmentIDFromDes = departmentName.substring(pos + 1);
        this.setDepartmentIDFromDes(departmentName.substring(pos + 1));
        try {
            choSaveJob.setSelected(true);
            departmentId = Long.parseLong(this.getDepartmentIDFromDes().trim());
            HashMap depList = departmentManage.readDepartmentId(this.getDepartmentIDFromDes().trim());
            String stringId = null;
            if (depList != null) {
                btnEdit.setDisabled(false);
                btnDelete.setDisabled(false);
                stringId = depList.get("DEPT_ID").toString();
                btnNew.setDisabled(false);
                btnReset.setDisabled(false);
                departmentId = Long.parseLong(stringId);
                txtEstablishedDate.setValue(depList.get("EST_DATE"));
                txtMission.setValue(depList.get("MISSION"));
                txtUnitname.setValue(depList.get("DEP_DESCRIPTION"));
                txtVision.setValue(depList.get("VISION"));
                drlAddressCode.resetValue();
                drlAddressCode.setValue(depList.get("ADDRESS_CODE"));
            }
//            countJob = 0;
            // HashMap departmentAddress = departmentManage.readDepartmentAddress(departmentId);
            HashMap[] readJobInDepartmenrt = departmentManage.readDepartmentJob(departmentId);
            if (readJobInDepartmenrt != null) {
                jobTableSize = readJobInDepartmenrt.length;//departmentManage.countDepartmentJob(departmentId);
                for (int i = 0; i < jobTableSize; i++) {
                    //  DepartmentManage allowedJobs = new DepartmentManage(jobId, jobCode, jobName, departmentId,this.getAvilabelOnDb());
                    DepartmentManage allowedJobs = new DepartmentManage(readJobInDepartmenrt[i].get("job_code").toString(),
                            readJobInDepartmenrt[i].get("job_code").toString(),
                            readJobInDepartmenrt[i].get("JOB_NAME").toString(), departmentId, 1, Integer.parseInt(readJobInDepartmenrt[i].get("NUMBER_OF_EMPLOYEE").toString()), "Old");
                    departmentList.add(allowedJobs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////DepartmentNew///////////////////////////////////////////////////////////////////
     public void cmdLookDetaileNew_processAction(ActionEvent ae) {
        departmentList.clear();
        departmentUpdateList.clear();
        btnSaveAd.setValue("New");
        btnUpdateAd.setValue("Edit");
        String checkID = "000000";
        int pos = 0;
        clearComponents();
        clearComponentsAd();
        disableComponets();
        disableDepartemntComponets();
        disableComponentsAd();
        // tr = tree1.getCurrentNode().getLevel();
        departmentName = tree1.getCurrentNode().toString();//.substring(0, 2);
        lblDepartment.setValue(departmentName);
        pos = departmentName.lastIndexOf("#");
//        // departmentIDFromDes = departmentName.substring(pos + 1);
        this.setDepartmentIDFromDes(departmentName.substring(pos + 1));
        try {
            choSaveJob.setSelected(true);
            departmentId = Long.parseLong(this.getDepartmentIDFromDes().trim());
            HashMap depList = departmentManage.readDepartmentIdNew(this.getDepartmentIDFromDes().trim());
            String stringId = null;
            if (depList != null) {
                btnEdit.setDisabled(false);
                btnDelete.setDisabled(false);
                stringId = depList.get("DEPT_ID").toString();
                btnNew.setDisabled(false);
                btnReset.setDisabled(false);
                departmentId = Long.parseLong(stringId);
                txtEstablishedDate.setValue(depList.get("EST_DATE"));
                txtMission.setValue(depList.get("MISSION"));
                txtUnitname.setValue(depList.get("DEP_DESCRIPTION"));
                txtVision.setValue(depList.get("VISION"));
                drlAddressCode.resetValue();
                drlAddressCode.setValue(depList.get("ADDRESS_CODE"));
            }
//            countJob = 0;
            // HashMap departmentAddress = departmentManage.readDepartmentAddress(departmentId);
            HashMap[] readJobInDepartmenrt = departmentManage.readDepartmentJobNew(departmentId);
            if (readJobInDepartmenrt != null) {
                jobTableSize = readJobInDepartmenrt.length;//departmentManage.countDepartmentJob(departmentId);
                for (int i = 0; i < jobTableSize; i++) {
                    //  DepartmentManage allowedJobs = new DepartmentManage(jobId, jobCode, jobName, departmentId,this.getAvilabelOnDb());
                    DepartmentManage allowedJobs = new DepartmentManage(readJobInDepartmenrt[i].get("job_code").toString(),
                            readJobInDepartmenrt[i].get("job_code").toString(),
                            readJobInDepartmenrt[i].get("JOB_NAME").toString(), departmentId, 1, Integer.parseInt(readJobInDepartmenrt[i].get("NUMBER_OF_EMPLOYEE").toString()), "Old");
                    departmentList.add(allowedJobs);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ArrayList<SelectItem> jobOpt = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getJobOpt() {
        return departmentManage.readAllJob();
    }

    public void setJobOpt(ArrayList<SelectItem> jobOpt) {
        this.jobOpt = jobOpt;
    }
    private ArrayList<SelectItem> jobOptBY = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getJobOptBY() {
        return departmentManage.readAllJobBY();
    }

    public void setJobOptBY(ArrayList<SelectItem> jobOptBY) {
        this.jobOptBY = jobOptBY;
    }

    public String btnAdd_action() {
        //return null means stay on the same page
        if (buttonIdentifier == 1) {

            boolean checkAvilabe = true;
            try {
                if (!drlJobType.getValue().equals("0")) {
                    lblErrorMessage.setRendered(false);
                    if (tblJob.getRowCount() > 0) {
                        try {
                            List jobLists = this.getDepartmentList();
                            Iterator<DepartmentManage> it = jobLists.iterator();
                            while (it.hasNext()) {
                                DepartmentManage jobFromList = it.next();
                                if (jobFromList.getAllowedJobCOde().equals(drlJobType.getValue())) {
                                    checkAvilabe = false;
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (checkAvilabe) {
                        String jobId = null;
                        String jobCode = null;
                        String jobName = null;
                        String job_name[] = drlJobType.getValue().toString().split("-");
                        int numberOfEmployee = 0;
//                        Option[] readJobOpt = this.getJobOptBY();
//                        int selectedRow = readJobOpt.length;
//                        if (this.drlJobType.getValue() != null) {
//                            jobId = this.drlJobType.getValue().toString();
//                            for (int i = 0; i < readJobOpt.length; i++) {
//                                if (this.drlJobType.getValue().toString().equalsIgnoreCase(readJobOpt[i].getValue().toString())) {
//                                    selectedRow = i;
//                                }
//                            }
//                            jobName = readJobOpt[selectedRow].getLabel();
//                        }
                        jobName = job_name[1];

                        if (txtJobCode.getValue() != null) {
                            jobCode = txtJobCode.getValue().toString();
                        }
                        if (txtEmployeeQuantity.getValue() != null) {
                            try {
                                numberOfEmployee = Integer.parseInt(txtEmployeeQuantity.getValue().toString());
                                countJob++;
                                DepartmentManage allowedJobs = new DepartmentManage(jobCode, jobCode, jobName, departmentId, this.getAvilabelOnDb(), numberOfEmployee, "New");
                                departmentList.add(allowedJobs);
                                txtEmployeeQuantity.setValue(null);
                            } catch (NumberFormatException nfe) {
                                showSuccessOrFailureMessage(false, "INVALID NUMBER : " + txtEmployeeQuantity.getValue().toString());
                            }
                        } else {
                            showSuccessOrFailureMessage(false, "Fill Employee Quanity");
                        }
                    } else {
                        showSuccessOrFailureMessage(false, "This job record already available in the table ");
                    }
                } else {
                    //errormessage
                    lblErrorMessage.setRendered(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
        return null;
    }

    public void drlJobType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            String job_name[] = vce.getNewValue().toString().split("-");
            txtJobCode.setValue(job_name[0]);
            lblErrorMessage.setRendered(false);
        }

    }

    public void panelTabSet1_processTabChange(TabChangeEvent tce) {
    }

    public String btnSave_action() {
        //return null means stay on the same page
        saveDepartmentInformation();
        return null;
    }

    public void saveDepartmentInformation() {
        try {
            if (!choSaveJob.isSelected()) {//to save department
                String organizationId = null;
                String vision = null;
                String mission = null;
                String organizationName = null;
                String estDate = null;
                String addressCode = null;
                if (departmentId != 0) {
                    organizationId = Long.toString(departmentId);
                }
                if (txtVision.getValue() != null) {
                    vision = txtVision.getValue().toString();
                }
                if (txtMission.getValue() != null) {
                    mission = txtMission.getValue().toString();
                }
                if (txtUnitname.getValue() != null) {
                    organizationName = txtUnitname.getValue().toString();
                }
                if (txtEstablishedDate.getValue() != null) {
                    estDate = txtEstablishedDate.getValue().toString();
                }
                if (drlAddressCode.getValue() != null) {
                    if (!drlAddressCode.getValue().toString().equals("-1")) {
                        addressCode = drlAddressCode.getValue().toString();
                    }
                }

                if (addDept(this.getCreateNewDepartmentID(), organizationName, mission, vision, estDate, organizationId, "")) {
//                    pnlPopUpMsg.setRendered(true);
                    relodTable = true;
                    showSuccessOrFailureMessage(true, "The Organization information is successfully saved!");
                    countJob = 0;//
                    disableComponets();
                    disableDepartemntComponets();
                    disableComponentsAd();
                    btnNew.setDisabled(false);
                    btnSave.setDisabled(true);
                    btnEdit.setDisabled(false);
                    btnUpdate.setDisabled(true);
                    btnReset.setDisabled(false);
                    btnDelete.setDisabled(false);
                } else {
                    showSuccessOrFailureMessage(false, "The Organization information is not saved Please Try Again ?");

                }
            } else {// to save a job for department 
                try {
                    int checkSave = 0;
                    String organizationId;
                    organizationId = Long.toString(departmentId);
                    List jobList = this.getDepartmentList().subList((jobTableSize), (jobTableSize + countJob));
                    Iterator<DepartmentManage> iter = jobList.iterator();
                    // int checkDelete = departmentManage.deleteJobType(organizationId);
                    while (iter.hasNext()) {
                        try {
                            DepartmentManage depManager = iter.next();
                            if (depManager.getDataBaseStatus() != null && depManager.getDataBaseStatus().equalsIgnoreCase("New")) {
                                checkSave = departmentManage.addDeptJob(
                                        organizationId,
                                        depManager.getAllowedJobCOde(),
                                        depManager.getNumberOfEmployee());
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (checkSave == 1) {
                        showSuccessOrFailureMessage(true, "The Department  Job Information Successfully Saved.");
                        disableComponets();
                        countJob = 0;
                        disableDepartemntComponets();
                        disableComponentsAd();
                        btnNew.setDisabled(false);
                        btnSave.setDisabled(true);
                        btnEdit.setDisabled(false);
                        btnUpdate.setDisabled(true);
                        btnReset.setDisabled(false);
                        btnDelete.setDisabled(true);
                    } else {
                        showSuccessOrFailureMessage(false, "The Department  Job Information not saved.");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean addDept(String departmentID, String deptName, String mission, String vision, String est_Date, String branch_head, String addressCode) {

        int checkSave = 0;
        boolean jobIndepartment = false;
        if (departmentManage.addDept(departmentID, deptName, mission, vision, est_Date, branch_head, addressCode) != 0) {

            if (tblJob.getRowCount() > 0) {
                try {
                    List jobLists = this.getDepartmentList();
                    Iterator<DepartmentManage> it = jobLists.iterator();
                    while (it.hasNext()) {
                        DepartmentManage jobFromList = it.next();
                        checkSave = departmentManage.addDeptJob(departmentID, jobFromList.getAllowedJobCOde(), jobFromList.getNumberOfEmployee());
                        jobIndepartment = true;
                        if (checkSave == 0) {
                            break;
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    ErrorLogWriter.writeError(ex);
                    return false;
                }
            }
            if (checkSave == 1 && jobIndepartment) {

                return true;
            } else if (!jobIndepartment) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    private boolean readOrg(String organizationId) {
        if (departmentManage.readDept(organizationId) == 1) {
            return true;
        } else {
            return false;
        }

    }

    public String btnPopUpOk_action() {
        //return null means stay on the same page
        pnlPopUpMsg.setRendered(false);
        return null;
    }

    void clearDepartmentComponents() {
        txtEstablishedDate.setValue("");
        txtMission.setValue("");
        txtUnitname.setValue("");
        txtVision.setValue("");
    }

    void clearComponents() {
        drlJobType.setValue("");
        txtJobCode.setValue("");


    }

    void disableDepartemntComponets() {
        txtEstablishedDate.setDisabled(true);
        txtJobCode.setDisabled(true);
        txtMission.setDisabled(true);
        txtUnitname.setDisabled(true);
        txtVision.setDisabled(true);

    }

    void disableComponets() {
        drlJobType.setDisabled(true);
        btnAdd.setDisabled(true);

    }

    void enableDepartemntComponents() {
        txtEstablishedDate.setDisabled(false);
        txtJobCode.setDisabled(false);
        txtMission.setDisabled(false);
        txtUnitname.setDisabled(false);
        txtVision.setDisabled(false);
    }

    void enableComponents() {
        drlJobType.setDisabled(false);
        btnAdd.setDisabled(false);
    }

    void clearComponentsAd() {
        drlKebelle.setValue("");
        drlRegion.setValue("");
        drlWoreda.setValue("");
        drlZoneCity.setValue("");
        txtFloor.setValue("");
        txtBlockNo.setValue("");
        txtOfficeNumber.setValue("");
        txtTelExtension.setValue("");
        txtTelOffice.setValue("");
        txtEmail.setValue("");
        txtMobile.setValue("");
    }

    void disableComponentsAd() {

        drlKebelle.setDisabled(true);
        drlRegion.setDisabled(true);
        drlWoreda.setDisabled(true);
        drlZoneCity.setDisabled(true);
        txtFloor.setDisabled(true);
        txtBlockNo.setDisabled(true);
        txtOfficeNumber.setDisabled(true);
        txtTelExtension.setDisabled(true);
        txtTelOffice.setDisabled(true);
        txtEmail.setDisabled(true);
        txtMobile.setDisabled(true);
    }

    void enableComponentsAd() {
        drlKebelle.setDisabled(false);
        drlRegion.setDisabled(false);
        drlWoreda.setDisabled(false);
        drlZoneCity.setDisabled(false);
        txtFloor.setDisabled(false);
        txtBlockNo.setDisabled(false);
        txtOfficeNumber.setDisabled(false);
        txtTelExtension.setDisabled(false);
        txtTelOffice.setDisabled(false);
        txtEmail.setDisabled(false);
        txtMobile.setDisabled(false);
    }

    public String btnReset_action() {
        //return null means stay on the same page

        btnNew.setDisabled(true);
        btnSave.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnReset.setDisabled(true);
        btnDelete.setDisabled(true);
        clearComponents();
        disableComponets();
        clearDepartmentComponents();
        disableDepartemntComponets();

        return null;
    }
    int num = 1111111111;

    public String btnDelete_action() {
        //return null means stay on the same page
        if (choSaveJob.isSelected()) {
            if (selectedNoAttenRow == -1) {
                showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
            } else if (this.departmentList.isEmpty()) {
                showSuccessOrFailureMessage(false, "The Table is Empty!");
            } else {
                buttonIdentifier = 4;
                pnlPopUpMsg.setRendered(true);
                lblPopUpMsgMain.setValue("Are you sure you want to delete job avilebel in this departemnt?");
                btnPopUpNo.setRendered(true);
                btnPopUpYes.setRendered(true);
                btnPopUpOk.setRendered(false);
            }
        } else {
            buttonIdentifier = 5;
            pnlPopUpMsg.setRendered(true);
            lblPopUpMsgMain.setValue("Are you sure you want to delete departemnt and job?");
            btnPopUpNo.setRendered(true);
            btnPopUpYes.setRendered(true);
            btnPopUpOk.setRendered(false);
        }
        return null;
    }

    public String btnPopUpYes_action() {

        //return null means stay on the same page
        if (buttonIdentifier == 5) {
            pnlPopUpMsg.setRendered(false);
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
            btnPopUpOk.setRendered(false);
            btnPopUpYesAd.setRendered(false);
            if (departmentManage.deleteDept(departmentId) == 1) {
                //   pnlPopUpMsg.setRendered(false);
                showSuccessOrFailureMessage(true, "The Department Information Successfully Deleted.");
                countJob = 0;
                relodTable = true;
                btnSave.setDisabled(true);
                btnEdit.setDisabled(true);
                btnUpdate.setDisabled(true);
                btnReset.setDisabled(true);
                btnDelete.setDisabled(true);

                clearComponents();
                disableComponets();
                clearDepartmentComponents();
                disableDepartemntComponets();

            } else {
                showSuccessOrFailureMessage(false, "Error occur while Deleting Department. Please Try Again?");
            }
        } else if (buttonIdentifier == 4) {

            DepartmentManage employeeEducation = (DepartmentManage) getDepartmentList().get(selectedNoAttenRow);
            pnlPopUpMsg.setRendered(false);
            if (jobTableSize < selectedNoAttenRow) {
                countJob = 0;
                getDepartmentList().remove(selectedNoAttenRow);
                relodTable = true;
                showSuccessOrFailureMessage(true, "The Department Information Successfully Deleted.");
            } else if (jobTableSize > selectedNoAttenRow) {
                if (departmentManage.deleteDeptJob(Long.toString(departmentId), employeeEducation.getAllowedJobCOde()) != 0) {
                    getDepartmentList().remove(selectedNoAttenRow);
                    showSuccessOrFailureMessage(true, "The Department Information Successfully Deleted.");
                    relodTable = true;
                    countJob = 0;
                    if (jobTableSize == 0) {
                        jobTableSize = 0;
                    } else {
                        jobTableSize--;

                    }

                } else {
                    showSuccessOrFailureMessage(false, "Error occur while Deleting Department. Please Try Again?");
                }
            } else {
                showSuccessOrFailureMessage(false, "Error occur while Deleting Department. Please Try Again?");
            }


        }
        selectedNoAttenRow = -1;
        return null;
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        int checkSave = 0;
        boolean checkUpdate = false;

        String organizationId = null;
        String vision = null;
        String mission = null;
        String organizationName = null;
        String estDate = null;
        String addressCode = null;
        if (departmentId != 0) {
            organizationId = Long.toString(departmentId);
        }
        if (txtVision.getValue() != null) {
            vision = txtVision.getValue().toString();
        }
        if (txtMission.getValue() != null) {
            mission = txtMission.getValue().toString();
        }
        if (txtUnitname.getValue() != null) {
            organizationName = txtUnitname.getValue().toString();
        }
        if (txtEstablishedDate.getValue() != null) {
            estDate = txtEstablishedDate.getValue().toString();
        }
        if (drlAddressCode.getValue() != null) {
            if (!drlAddressCode.getValue().toString().equals("-1")) {
                addressCode = drlAddressCode.getValue().toString();
            }
        }
        // here it is          updateDept(organizationId, mission, organizationName,vision,estDate);
        if (departmentManage.updateDepartment(organizationId, organizationName, mission, vision, estDate, addressCode) == 1) {
            // lblFormMessage.setStyleClass("Success");
            showSuccessOrFailureMessage(true, "The Department Information Successfully Updated.");
            btnNew.setDisabled(false);
            btnSave.setDisabled(true);
            btnEdit.setDisabled(false);
            btnUpdate.setDisabled(true);
            btnReset.setDisabled(true);
            btnDelete.setDisabled(false);
            // showConformationMsg(getMessage().getStyleClass().toString());
            disableComponets();
            disableDepartemntComponets();

        } else {
            showSuccessOrFailureMessage(false, "Error occur on Updating Department. Please Try Again?");
        }
        return null;
    }

    public boolean updateDept(String deptId, String deptName, String mission, String vission, String est_Date, String addressCode) {
        if (departmentManage.updateDepartment(deptId, deptName, mission, vission, est_Date, addressCode) == 1) {
            showSuccessOrFailureMessage(true, "The Department Information Successfully Updated.");
            return true;
        } else {
            showSuccessOrFailureMessage(false, "Error occur on Updating Department. Please Try Again?");
            return false;
        }
    }

    public String btnSaveAd_action() {
        //return null means stay on the same page
        if (btnSaveAd.getValue().equals("New")) {
            enableComponentsAd();
            clearComponentsAd();

            btnSaveAd.setValue("Save");
        } else {

            maintainDeptAddressInfo(1);
        }

        return null;
    }

    public void maintainDeptAddressInfo(int type) {
        String region = null;
        String zone = null;
        String woreda = null;
        String kebelle = null;
        String block = null;
        String floor = null;
        String telOffice = null;
        String telOfficeExt = null;
        String telMobile = null;
        String officeNumber = null;
        String email = null;
        if (drlRegion.getValue() != null) {
            region = drlRegion.getValue().toString();
        }

        if (drlWoreda.getValue() != null) {
            woreda = drlWoreda.getValue().toString();
        }

        if (drlZoneCity.getValue() != null) {
            zone = drlZoneCity.getValue().toString();
        }

        if (drlKebelle.getValue() != null) {
            kebelle = drlKebelle.getValue().toString();
        }

        if (txtBlockNo.getValue() != null) {
            block = txtBlockNo.getValue().toString();
        }

        if (this.txtFloor.getValue() != null) {
            floor = this.txtFloor.getValue().toString();
        }

        if (this.txtOfficeNumber.getValue() != null) {
            officeNumber = txtOfficeNumber.getValue().toString();
        }

        if (txtTelExtension.getValue() != null) {
            telOfficeExt = txtTelExtension.getValue().toString();
        }

        if (this.txtMobile.getValue() != null) {
            telMobile = txtMobile.getValue().toString();
        }

        if (this.txtTelOffice.getValue() != null) {
            telOffice = this.txtTelOffice.getValue().toString();
        }

        if (this.txtEmail.getValue() != null) {
            email = this.txtEmail.getValue().toString();
        }

        if (type == 1) {
            if (departmentManage.maintainDepartmentAddress(type, Double.toString(departmentId), region, zone, woreda, kebelle,
                    floor, block, officeNumber, telMobile, telOffice, telOfficeExt, email) == 1) {
                lblPopUpMsgMain.setValue("The Department Address Successfully Saved.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
                btnPopUpOk.setRendered(true);
                btnPopUpYesAd.setRendered(false);
                btnSaveAd.setValue("New");

                disableComponets();

                disableDepartemntComponets();

                disableComponentsAd();

            } else {
                lblPopUpMsgMain.setValue("Error occur on saving Department address. Please Try Again?");
                pnlPopUpMsg.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
                btnPopUpOk.setRendered(true);
                btnPopUpYesAd.setRendered(false);
            }

        } else {
            if (departmentManage.maintainDepartmentAddress(type, Double.toString(departmentId), region, zone, woreda, kebelle,
                    floor, block, officeNumber, telMobile, telOffice, telOfficeExt, email) == 1) {
                lblPopUpMsgMain.setValue("The Department Address Successfully Updated.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
                btnPopUpOk.setRendered(true);
                btnPopUpYesAd.setRendered(false);
                btnSaveAd.setValue("Edit");

                disableComponets();

                disableDepartemntComponets();

                disableComponentsAd();

            } else {
                lblPopUpMsgMain.setValue("Error occur on updating  Department address. Please Try Again?.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
                btnPopUpOk.setRendered(true);
                btnPopUpYesAd.setRendered(false);

            }

        }
    }

    public void drlRegion_processValueChange(ValueChangeEvent vce) {

        try {
            this.setZoneCityType(lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString()));
        } catch (Exception ex) {
        }

    }

    public void drlZoneCity_processValueChange(ValueChangeEvent vce) {
        try {
            woreda = lookUpManager.readKebelleInAWoredaOrSubCity(vce.getNewValue().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void drlWoreda_processValueChange(ValueChangeEvent vce) {
        try {
            optKebele = lookUpManager.readKebelleInSubCity2(vce.getNewValue().toString());
        } catch (Exception ex) {
        }
    }

    public String btnUpdateAd_action() {
        //return null means stay on the same page
        if (btnUpdateAd.getValue().equals("Edit")) {
            enableComponentsAd();
            btnUpdateAd.setValue("Update");

        } else {

            maintainDeptAddressInfo(2);
        }

        return null;
    }

    public String btnResetAd_action() {
        //return null means stay on the same page
        clearComponentsAd();
        return null;
    }

    public String btnDeleteAd_action() {
        //return null means stay on the same page
        if (departmentManage.deleteAddressDept(Double.toString(departmentId))) {
            showSuccessOrFailureMessage(true, "Department Address Delete successful");

        } else {
            showSuccessOrFailureMessage(false, "Department Address  not deleted.plase try agin? ");

        }

        return null;
    }

    public String button1_action() {
        //return null means stay on the same page
        if (departmentManage.deleteAddressDept(Double.toString(departmentId))) {
            pnlPopUpMsg.setRendered(false);
            lblPopUpMsgMain.setValue("The Department Address Deleted Successfully");
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
            btnPopUpOk.setRendered(true);
            btnPopUpYesAd.setRendered(false);
        } else {
            pnlPopUpMsg.setRendered(false);
            lblPopUpMsgMain.setValue("Error occur while Deleting Department Address. Please Try Again?");
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
            btnPopUpOk.setRendered(true);
            btnPopUpYesAd.setRendered(false);

        }

//        this.txtfBlockNo.resetValue();
//        this.txtfEmail.resetValue();
//        this.txtfFloor.resetValue();
//        this.txtfOfficeNumber.resetValue();
//        this.txtfTeleMobile.resetValue();
//        this.txtfTeleOffice.resetValue();
//        lpDeleteConfirmation.setVisible(false);
//        lpDeleteDeptAddressConfirmation_pop.setVisible(false);
        return null;
    }

    public String btnPopUpNo_action() {
        //return null means stay on the same page
        pnlPopUpMsg.setRendered(false);
        return null;
    }

    public String linkEdit_action() {
        //return null means stay on the same page
        int rowNumber = tblJob.getRowIndex();
        DepartmentManage employeeEducation = (DepartmentManage) getDepartmentList().get(rowNumber);
        getDepartmentList().remove(rowNumber);
        drlJobType.setValue(employeeEducation.getAllowedJobCOde());
        txtJobCode.setValue(employeeEducation.getAllowedJobCOde());
        return null;
    }

    public String linkDelete_action() {
        //return null means stay on the same page
        int rowNumber = tblJob.getRowIndex();
        DepartmentManage employeeEducation = (DepartmentManage) getDepartmentList().get(rowNumber);
        if (departmentManage.deleteDeptUsingID(Long.toString(employeeEducation.getRowType()), employeeEducation.getAllowedJobCOde()) == 1) {
            getDepartmentList().remove(rowNumber);
            pnlPopUpMsg.setRendered(true);
            lblPopUpMsgMain.setValue("The Job In Department Deleted Successfully");
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
            btnPopUpOk.setRendered(true);
            btnPopUpYesAd.setRendered(false);
        } else {
            pnlPopUpMsg.setRendered(true);
            lblPopUpMsgMain.setValue("Error occur while Deleting The Job In Department. Please Try Again?");
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
            btnPopUpOk.setRendered(true);
            btnPopUpYesAd.setRendered(false);
        }

        return null;
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

    public void btnSaveAd_processAction(ActionEvent ae) {
    }

    public String cmdJobType_action() {
        //return null means stay on the same page
        return "JobType";
    }

    public String btnNew_action() {
        //return null means stay on the same page
        try {
            if (departmentId != 0) {
                // this.setCreateNewDepartmentID(departmentManage.generateNewDepartmentId(departmentId));
                //if (getCreateNewDepartmentID() != null) {
                if (!choSaveJob.isSelected()) {
                    clearDepartmentComponents();
                    enableDepartemntComponents();
                    disableComponets();
                    clearComponents();
                    departmentList.clear();
                    departmentUpdateList.clear();
                    btnNew.setDisabled(true);
                    btnSave.setDisabled(false);
                    btnEdit.setDisabled(true);
                    btnUpdate.setDisabled(true);
                    btnReset.setDisabled(false);
                    btnDelete.setDisabled(true);
                } else {
                    buttonIdentifier = 1;
                    clearComponents();
                    enableComponents();
                    btnNew.setDisabled(true);
                    btnSave.setDisabled(false);
                    btnEdit.setDisabled(true);
                    btnUpdate.setDisabled(true);
                    btnReset.setDisabled(false);
                    btnDelete.setDisabled(true);

                }

            } else {
                showSuccessOrFailureMessage(false, "Befor add new department Pleas select department postion");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public String btnEdit_action() {

        if (choSaveJob.isSelected()) {
            showSuccessOrFailureMessage(false, "The table record is not editable .Delete this record and adds another record ");
        } else {
            btnSave.setDisabled(true);
            btnEdit.setDisabled(true);
            btnUpdate.setDisabled(false);
            btnReset.setDisabled(false);
            btnDelete.setDisabled(true);
            enableDepartemntComponents();


        }
        return null;
    }

    public void rowSelectorZoneOrCity_processMyEvent(RowSelectorEvent rse) {
        selectedNoAttenRow = rse.getRow();
    }

    public String cmdConfirmationCloseMesssage_action() {
        //return null means stay on the same page
        pnConfirmationMessage.setRendered(false);
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage4.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage4.setValue(messageToDisplay);
        lblFormMessage4.setRendered(true);
        pnConfirmationMessage.setAutoCentre(true);
        pnConfirmationMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }
    static int parentIndex = 0;
    //  OrganizationManager organizationManager = new OrganizationManager();

    public DefaultMutableTreeNode populateNodes() {
        ArrayList<OrganizationManager> allDepartmentsList = organizationManager.readAllDepartments();
        ArrayList<DefaultMutableTreeNode> allNodesList = new ArrayList<DefaultMutableTreeNode>();
        int sizeOfDeptList = allDepartmentsList.size();
        //create and add to allNodesList corresponding node for each department of allDepartmentsList
        String info = "index     code    level   ";
        for (int i = 0; i < sizeOfDeptList; i++) {
            allNodesList.add(createNodeFromDepartment(allDepartmentsList.get(i)));
            if (i < 30) {
                info = info + "\n" + i + "       " + allDepartmentsList.get(i).getDeptCode() + "        " + allDepartmentsList.get(i).getLevel();
            }
        }


        for (int i = 1; i < sizeOfDeptList; i++) {
            OrganizationManager currentDepartment = allDepartmentsList.get(i);
            OrganizationManager prevDepartment = allDepartmentsList.get(i - 1);
            DefaultMutableTreeNode currentNode = allNodesList.get(i);
            if (currentDepartment.getLevel() > prevDepartment.getLevel()) {
                parentIndex = i - 1;//parent is the previeous
            } else if (currentDepartment.getLevel() == prevDepartment.getLevel()) {
                //parentIndex=parentIndex;//not changed, keep the prevous
            } else if (currentDepartment.getLevel() < prevDepartment.getLevel()) {
                int backCounter;
                for (backCounter = i; backCounter >= 0; backCounter--) {
                    if (currentDepartment.getBranchID().equals(allDepartmentsList.get(backCounter).getDeptCode())) {
                        parentIndex = backCounter;
                        break;
                    }
                }

            }
//                    "  parentIndex    : " + parentIndex + "      "+"parent level  " + allDepartmentsList.get(parentIndex).getLevel() + "      "+"parentId   :     " + allDepartmentsList.get(parentIndex).getDeptCode() +
//                    "\ncurrentInnex  : " + i + "      "+"current level  " + prevDepartment.getLevel() + "      "+"currentId :     " + currentDepartment.getDeptCode() +
//                    "\nprevieoIndex    " + (i - 1) + "      "+"previes level  " + prevDepartment.getLevel() + "      "+"previesId :     " + prevDepartment.getDeptCode());
            allNodesList.get(parentIndex).add(currentNode);
        }
        return allNodesList.get(0);//rootnode
    }

    private DefaultMutableTreeNode createNodeFromDepartment(OrganizationManager department) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        IceUserObject userObject = new IceUserObject(node);
        userObject.setLeafIcon("../xmlhttp/css/rime/css-images/tree_document.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_folder_close.gif");
        userObject.setBranchExpandedIcon("../xmlhttp/css/rime/css-images/tree_folder_open.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_nav_bottom_close.gif");
        userObject.setExpanded(false);
        node.setUserObject(userObject);
        //userObject.setTreeNode(employee);
        //branch
        //   String nameOfDept = Integer.toString(department.getLevel()) + " === " + department.getDeptDescription();
        String nameOfDept = department.getDeptDescription();
        String deptCode = department.getDeptCode();
        // String deptLevel = Integer.toString(department.getLevel())+" === ";
        if (nameOfDept != null) {
            userObject.setText(nameOfDept + "  => " + deptCode);
            userObject.setLeaf(false);
            userObject.setExpanded(false);
            node.setAllowsChildren(true);
        } // leaf node
        else {
            userObject.setText(deptCode);
            userObject.setLeaf(true);
            node.setAllowsChildren(false);
        }
        return node;
    }

    public String btnCalender_action() {
        calEstablishedDate.setRendered(true);//return null means stay on the same page
        return null;
    }

    public void calEstablishedDate_processValueChange(ValueChangeEvent vce) {
        txtEstablishedDate.setValue((new SimpleDateFormat("yyyy-MM-dd")).format(((Date) vce.getNewValue())));
        calEstablishedDate.setRendered(false);
    }

    public void choSaveJob_processValueChange(ValueChangeEvent vce) {
        if (choSaveJob.isSelected()) {
            btnDelete.setDisabled(true);
        } else {
            btnDelete.setDisabled(false);
        }
    }
}
