/*
 * ClearancePage.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Termination;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputHidden;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.ReportControl;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import fphrms.AutoAllCompleteDictionaryBenefit;
import fphrms.DeviceList;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import java.util.Date;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import manager.clearanceManager.ClearanceManager;
import manager.clearanceManager.ClearanceManager.ItemListModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.CommonValidation;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.StringDateManipulation;
import manager.terminationManager.TerminationManager;
import oracle.jdbc.rowset.OracleSerialBlob;
import manager.terminationManager.TerminationRequestManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ClearancePage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    private String photoPath;
    private int selectedRow;
    private String myUrl = null;
    private byte[] attachedDBImg;
    private int clearedClosedStatus = -1;
    private String clearanceType = null;
    private String loggedInUserId = null;
    private String loggedInDeptId = null;
    private String clearingDepartmentId = null;
    private String clearingEmployeeId = null;
    private String clearedEmployeeId = null;
    private boolean initLoad = true;
    private EmployeeManage employeemanage = new EmployeeManage();
    private TerminationManager terminationManager = new TerminationManager();
    TerminationRequestManager terminationrequestManager = new TerminationRequestManager();
    private ClearanceManager clearanceManager = new ClearanceManager();
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<HashMap> readAvailableDepartments = new ArrayList<HashMap>();
    private ArrayList<HashMap> readSelectedDepartments = new ArrayList<HashMap>();
    private ArrayList<SelectItem> readStaticDepartments = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> clearanceRequests = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> clearanceRequestsCleared = new ArrayList<SelectItem>();
    ArrayList<ItemListModel> ItemTypeList = new ArrayList<ItemListModel>();
    private ReportControl reportControl = new ReportControl();
    private ImageIcon LOGO;
    private String itemName;
    private double price;
    private String description;
    private boolean selected;
    private String dataBaseStatus;
    private static String selectedId;
    private String selectedBenefitId;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ImageIcon getLOGO() {
        return LOGO;
    }

    public void setLOGO(ImageIcon LOGO) {
        this.LOGO = LOGO;
    }
    private ImageIcon employeePicture;

    public ImageIcon getEmployeePicture() {
        return employeePicture;
    }

    public String getDataBaseStatus() {
        return dataBaseStatus;
    }

    public void setDataBaseStatus(String dataBaseStatus) {
        this.dataBaseStatus = dataBaseStatus;
    }

    public String getSelectedBenefitId() {
        return selectedBenefitId;
    }

    public void setSelectedBenefitId(String selectedBenefitId) {
        this.selectedBenefitId = selectedBenefitId;
    }

    public static String getSelectedId() {
        return selectedId;
    }

    public static void setSelectedId(String selectedId) {
        ClearancePage.selectedId = selectedId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ArrayList<ItemListModel> getItemTypeList() {
        return ItemTypeList;
    }

    public void setItemTypeList(ArrayList<ItemListModel> ItemTypeList) {
        this.ItemTypeList = ItemTypeList;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public AvilableDepartmentDataModel getAvilableDepartmentDataModel() {
        return avilableDepartmentDataModel;
    }

    public void setAvilableDepartmentDataModel(AvilableDepartmentDataModel avilableDepartmentDataModel) {
        this.avilableDepartmentDataModel = avilableDepartmentDataModel;
    }

    public ClearanceManager getClearanceManager() {
        return clearanceManager;
    }

    public void setClearanceManager(ClearanceManager clearanceManager) {
        this.clearanceManager = clearanceManager;
    }

    public String getClearanceType() {
        return clearanceType;
    }

    public void setClearanceType(String clearanceType) {
        this.clearanceType = clearanceType;
    }

    public int getClearedClosedStatus() {
        return clearedClosedStatus;
    }

    public void setClearedClosedStatus(int clearedClosedStatus) {
        this.clearedClosedStatus = clearedClosedStatus;
    }

    public String getClearedEmployeeId() {
        return clearedEmployeeId;
    }

    public void setClearedEmployeeId(String clearedEmployeeId) {
        this.clearedEmployeeId = clearedEmployeeId;
    }

    public String getClearingDepartmentId() {
        return clearingDepartmentId;
    }

    public void setClearingDepartmentId(String clearingDepartmentId) {
        this.clearingDepartmentId = clearingDepartmentId;
    }

    public String getClearingEmployeeId() {
        return clearingEmployeeId;
    }

    public void setClearingEmployeeId(String clearingEmployeeId) {
        this.clearingEmployeeId = clearingEmployeeId;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public EmployeeManage getEmployeemanage() {
        return employeemanage;
    }

    public void setEmployeemanage(EmployeeManage employeemanage) {
        this.employeemanage = employeemanage;
    }

    public boolean isInitLoad() {
        return initLoad;
    }

    public void setInitLoad(boolean initLoad) {
        this.initLoad = initLoad;
    }

    public String getLoggedInDeptId() {
        return loggedInDeptId;
    }

    public void setLoggedInDeptId(String loggedInDeptId) {
        this.loggedInDeptId = loggedInDeptId;
    }

    public String getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(String loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public ArrayList<HashMap> getReadAvailableDepartments() {
        return readAvailableDepartments;
    }

    public void setReadAvailableDepartments(ArrayList<HashMap> readAvailableDepartments) {
        this.readAvailableDepartments = readAvailableDepartments;
    }

    public ArrayList<HashMap> getReadSelectedDepartments() {
        return readSelectedDepartments;
    }

    public void setReadSelectedDepartments(ArrayList<HashMap> readSelectedDepartments) {
        this.readSelectedDepartments = readSelectedDepartments;
    }

    public ArrayList<SelectItem> getReadStaticDepartments() {
        return readStaticDepartments;
    }

    public void setReadStaticDepartments(ArrayList<SelectItem> readStaticDepartments) {
        this.readStaticDepartments = readStaticDepartments;
    }

    public ReportControl getReportControl() {
        return reportControl;
    }

    public void setReportControl(ReportControl reportControl) {
        this.reportControl = reportControl;
    }

    public TerminationManager getTerminationManager() {
        return terminationManager;
    }

    public void setTerminationManager(TerminationManager terminationManager) {
        this.terminationManager = terminationManager;
    }

    public TerminationRequestManager getTerminationrequestManager() {
        return terminationrequestManager;
    }

    public void setTerminationrequestManager(TerminationRequestManager terminationrequestManager) {
        this.terminationrequestManager = terminationrequestManager;
    }

    public void setEmployeePicture(ImageIcon employeePicture) {
        this.employeePicture = employeePicture;
    }

    public byte[] getAttachedDBImg() {
        return attachedDBImg;
    }

    public void setAttachedDBImg(byte[] attachedDBImg) {
        this.attachedDBImg = attachedDBImg;
    }

    public String getMyUrl() {
        return myUrl;
    }

    public void setMyUrl(String myUrl) {
        this.myUrl = myUrl;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }
    //////////////////////////////Clearnce Management/////////////////////////
    private ArrayList<SelectedDepartmentDataModel> selectedDepartment = new ArrayList<SelectedDepartmentDataModel>();

    public ArrayList<SelectedDepartmentDataModel> getSelectedDepartment() {
        return selectedDepartment;
    }

    public void setSelectedDepartment(ArrayList<SelectedDepartmentDataModel> selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }
    private ArrayList<ClearedDepartmentDetailDataModel> clearedDepartmentDetail = new ArrayList<ClearedDepartmentDetailDataModel>();

    public ArrayList<ClearedDepartmentDetailDataModel> getClearedDepartmentDetail() {
        return clearedDepartmentDetail;
    }

    public void setClearedDepartmentDetail(ArrayList<ClearedDepartmentDetailDataModel> clearedDepartmentDetail) {
        this.clearedDepartmentDetail = clearedDepartmentDetail;
    }
    private ArrayList<AvilableDepartmentDataModel> availabledepartment = new ArrayList<AvilableDepartmentDataModel>();

    public ArrayList<AvilableDepartmentDataModel> getAvailabledepartment() {
        return availabledepartment;
    }

    public void setAvailabledepartment(ArrayList<AvilableDepartmentDataModel> availabledepartment) {
        this.availabledepartment = availabledepartment;
    }
    ///////////////////////
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private DefaultSelectedData defaultSelectedData14 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData14() {
        return defaultSelectedData14;
    }

    public void setDefaultSelectedData14(DefaultSelectedData dsd) {
        this.defaultSelectedData14 = dsd;
    }
    private DefaultSelectedData defaultSelectedData15 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData15() {
        return defaultSelectedData15;
    }

    public void setDefaultSelectedData15(DefaultSelectedData dsd) {
        this.defaultSelectedData15 = dsd;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        // dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }
    private RowSelector rowSelector1 = new RowSelector();

    public RowSelector getRowSelector1() {
        return rowSelector1;
    }

    public void setRowSelector1(RowSelector rs) {
        this.rowSelector1 = rs;
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
    private HtmlSelectOneListbox lstClearancerequest = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstClearancerequest() {
        return lstClearancerequest;
    }

    public void setLstClearancerequest(HtmlSelectOneListbox hsol) {
        this.lstClearancerequest = hsol;
    }
    private HtmlSelectOneListbox lstClearancerequestCleared = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstClearancerequestCleared() {
        return lstClearancerequestCleared;
    }

    public void setLstClearancerequestCleared(HtmlSelectOneListbox hsol) {
        this.lstClearancerequestCleared = hsol;
    }

    public ArrayList<SelectItem> getClearanceRequests() {
        clearanceRequests = clearanceManager.loadClearanceRequests();
        return clearanceRequests;
    }

    public void setClearanceRequests(ArrayList<SelectItem> clearanceRequests) {
        this.clearanceRequests = clearanceRequests;
    }

    public ArrayList<SelectItem> getClearanceRequestsCleared() {
        clearanceRequestsCleared = clearanceManager.loadClearanceRequestsCleared();
        return clearanceRequestsCleared;
    }

    public void setClearanceRequestsCleared(ArrayList<SelectItem> clearanceRequests) {
        this.clearanceRequestsCleared = clearanceRequests;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlDataTable tblClearingDep1 = new HtmlDataTable();

    public HtmlDataTable getTblClearingDep1() {
        return tblClearingDep1;
    }

    public void setTblClearingDep1(HtmlDataTable hdt) {
        this.tblClearingDep1 = hdt;
    }
    private HtmlSelectOneListbox lstDepartmentSelected = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstDepartmentSelected() {
        return lstDepartmentSelected;
    }

    public void setLstDepartmentSelected(HtmlSelectOneListbox hsol) {
        this.lstDepartmentSelected = hsol;
    }
    private HtmlOutputLabel outputLabel1 = new HtmlOutputLabel();

    public HtmlOutputLabel getOutputLabel1() {
        return outputLabel1;
    }

    public void setOutputLabel1(HtmlOutputLabel hol) {
        this.outputLabel1 = hol;
    }
    private HtmlInputHidden inputHidden1 = new HtmlInputHidden();

    public HtmlInputHidden getInputHidden1() {
        return inputHidden1;
    }

    public void setInputHidden1(HtmlInputHidden hih) {
        this.inputHidden1 = hih;
    }
    private HtmlSelectBooleanCheckbox ckboClearing = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkboClearing() {
        return ckboClearing;
    }

    public void setCkboClearing(HtmlSelectBooleanCheckbox hsbc) {
        this.ckboClearing = hsbc;
    }
    private HtmlDataTable tblClearingDep = new HtmlDataTable();

    public HtmlDataTable getTblClearingDep() {
        return tblClearingDep;
    }

    public void setTblClearingDep(HtmlDataTable hdt) {
        this.tblClearingDep = hdt;
    }
    private PanelPopup pnlPopUpClearingDepSetting = new PanelPopup();

    public PanelPopup getPnlPopUpClearingDepSetting() {
        return pnlPopUpClearingDepSetting;
    }

    public void setPnlPopUpClearingDepSetting(PanelPopup pp) {
        this.pnlPopUpClearingDepSetting = pp;
    }
    private HtmlInputText txtClearPosition = new HtmlInputText();

    public HtmlInputText getTxtClearPosition() {
        return txtClearPosition;
    }

    public void setTxtClearPosition(HtmlInputText hit) {
        this.txtClearPosition = hit;
    }
    private HtmlInputText txtClearDueTo = new HtmlInputText();

    public HtmlInputText getTxtClearDueTo() {
        return txtClearDueTo;
    }

    public void setTxtClearDueTo(HtmlInputText hit) {
        this.txtClearDueTo = hit;
    }
    private HtmlInputText txtClearFullName = new HtmlInputText();

    public HtmlInputText getTxtClearFullName() {
        return txtClearFullName;
    }

    public void setTxtClearFullName(HtmlInputText hit) {
        this.txtClearFullName = hit;
    }
    private com.icesoft.faces.component.ext.HtmlCommandLink commandLink1 = new com.icesoft.faces.component.ext.HtmlCommandLink();

    public com.icesoft.faces.component.ext.HtmlCommandLink getCommandLink1() {
        return commandLink1;
    }

    public void setCommandLink1(com.icesoft.faces.component.ext.HtmlCommandLink hcl) {
        this.commandLink1 = hcl;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox4Bean() {
        return selectBooleanCheckbox4Bean;
    }

    public void setSelectBooleanCheckbox4Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox4Bean = dsd;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkResign = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkResign() {
        return chkResign;
    }

    public void setChkResign(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkResign = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkAgeLimit = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkAgeLimit() {
        return chkAgeLimit;
    }

    public void setChkAgeLimit(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkAgeLimit = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkNonAgeLimit = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkNonAgeLimit() {
        return chkNonAgeLimit;
    }

    public void setChkNonAgeLimit(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkNonAgeLimit = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkTransfer = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkTransfer() {
        return chkTransfer;
    }

    public void setChkTransfer(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkTransfer = hsbc;
    }
    private DefaultSelectedData defaultSelectedData16 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData16() {
        return defaultSelectedData16;
    }

    public void setDefaultSelectedData16(DefaultSelectedData dsd) {
        this.defaultSelectedData16 = dsd;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkCleared = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkCleared() {
        return chkCleared;
    }

    public void setChkCleared(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkCleared = hsbc;
    }
    private HtmlCommandButton btnClearEmployee = new HtmlCommandButton();

    public HtmlCommandButton getBtnClearEmployee() {
        return btnClearEmployee;
    }

    public void setBtnClearEmployee(HtmlCommandButton hcb) {
        this.btnClearEmployee = hcb;
    }
    private HtmlCommandButton btnUnclearEmployee = new HtmlCommandButton();

    public HtmlCommandButton getBtnUnclearEmployee() {
        return btnUnclearEmployee;
    }

    public void setBtnUnclearEmployee(HtmlCommandButton hcb) {
        this.btnUnclearEmployee = hcb;
    }
    private HtmlOutputText lblClearingEmployeeId = new HtmlOutputText();

    public HtmlOutputText getLblClearingEmployeeId() {
        return lblClearingEmployeeId;
    }

    public void setLblClearingEmployeeId(HtmlOutputText hot) {
        this.lblClearingEmployeeId = hot;
    }
    private HtmlOutputText lblClearingFullName = new HtmlOutputText();

    public HtmlOutputText getLblClearingFullName() {
        return lblClearingFullName;
    }

    public void setLblClearingFullName(HtmlOutputText hot) {
        this.lblClearingFullName = hot;
    }
    private HtmlOutputText lblClearingDepartment = new HtmlOutputText();

    public HtmlOutputText getLblClearingDepartment() {
        return lblClearingDepartment;
    }

    public void setLblClearingDepartment(HtmlOutputText hot) {
        this.lblClearingDepartment = hot;
    }
    private HtmlOutputText lblClearingJobPosition = new HtmlOutputText();

    public HtmlOutputText getLblClearingJobPosition() {
        return lblClearingJobPosition;
    }

    public void setLblClearingJobPosition(HtmlOutputText hot) {
        this.lblClearingJobPosition = hot;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
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
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlCommandButton btnFinalizeClearance = new HtmlCommandButton();

    public HtmlCommandButton getBtnFinalizeClearance() {
        return btnFinalizeClearance;
    }

    public void setBtnFinalizeClearance(HtmlCommandButton hcb) {
        this.btnFinalizeClearance = hcb;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData18 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData18() {
        return defaultSelectedData18;
    }

    public void setDefaultSelectedData18(DefaultSelectedData dsd) {
        this.defaultSelectedData18 = dsd;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkYes = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkYes() {
        return chkYes;
    }

    public void setChkYes(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkYes = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkNo = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkNo() {
        return chkNo;
    }

    public void setChkNo(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkNo = hsbc;
    }
    private HtmlCommandButton btnFinalReport = new HtmlCommandButton();

    public HtmlCommandButton getBtnFinalReport() {
        return btnFinalReport;
    }

    public void setBtnFinalReport(HtmlCommandButton hcb) {
        this.btnFinalReport = hcb;
    }
    private HtmlCommandButton btnAddToTable1 = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddToTable1() {
        return btnAddToTable1;
    }

    public void setBtnAddToTable1(HtmlCommandButton hcb) {
        this.btnAddToTable1 = hcb;
    }
    private HtmlDataTable dataTableClerace = new HtmlDataTable();

    public HtmlDataTable getDataTableClerace() {
        return dataTableClerace;
    }

    public void setDataTableClerace(HtmlDataTable hdt) {
        this.dataTableClerace = hdt;
    }
    private SelectInputText txtSearchByDevice = new SelectInputText();

    public SelectInputText getTxtSearchByDevice() {
        return txtSearchByDevice;
    }

    public void setTxtSearchByDevice(SelectInputText sit) {
        this.txtSearchByDevice = sit;
    }
    private HtmlInputText txtDeviceNAme = new HtmlInputText();

    public HtmlInputText getTxtDeviceNAme() {
        return txtDeviceNAme;
    }

    public void setTxtDeviceNAme(HtmlInputText hit) {
        this.txtDeviceNAme = hit;
    }
    private DefaultSelectedData defaultSelectedData19 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData19() {
        return defaultSelectedData19;
    }

    public void setDefaultSelectedData19(DefaultSelectedData dsd) {
        this.defaultSelectedData19 = dsd;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkIncash = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkIncash() {
        return chkIncash;
    }

    public void setChkIncash(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkIncash = hsbc;
    }
    private HtmlInputText txtAmountOfBirr = new HtmlInputText();

    public HtmlInputText getTxtAmountOfBirr() {
        return txtAmountOfBirr;
    }

    public void setTxtAmountOfBirr(HtmlInputText hit) {
        this.txtAmountOfBirr = hit;
    }
    private DefaultSelectedData defaultSelectedData20 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData20() {
        return defaultSelectedData20;
    }

    public void setDefaultSelectedData20(DefaultSelectedData dsd) {
        this.defaultSelectedData20 = dsd;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkInKind = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkInKind() {
        return chkInKind;
    }

    public void setChkInKind(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkInKind = hsbc;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ClearancePage() {
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
    AvilableDepartmentDataModel avilableDepartmentDataModel = new AvilableDepartmentDataModel();

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
        loggedInUserId = getSessionBean1().getEmployeeId();
        lblClearingEmployeeId.setValue(getSessionBean1().getEmployeeId().toString());
        lblClearingFullName.setValue(getSessionBean1().getEmployeeName());
       // lblClearingDepartment.setValue(getSessionBean1().getDepartmentDescrption());
        //lblClearingJobPosition.setValue(getSessionBean1().getJobDescription());
        //loggedInDeptId = getSessionBean1().getEmpDeptId();
        populateRequesterTextComponents(loggedInUserId);


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
     private boolean populateRequesterTextComponents(String employeeID) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeID);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeID);
                return false;
            } else {
              //  requesterId = empInfoHashMap.get("employeeId").toString();
                lblClearingDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
               // txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
              //  txtRequesterId.setValue(employeeID);
                lblClearingJobPosition.setValue(empInfoHashMap.get("employeePosition"));
                loggedInDeptId = empInfoHashMap.get("employeeDepartment").toString();
               // loggedInDeptId
              //  requesterJobLevel=empInfoHashMap.get("employeeJobLevel").toString();
                 return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }


    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setVisible(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void panelBorder1north_processMyEvent(DragEvent de) {
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox1BeanCleared = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1BeanCleared() {
        return selectOneListbox1BeanCleared;
    }

    public void setSelectOneListbox1BeanCleared(DefaultSelectedData dsd) {
        this.selectOneListbox1BeanCleared = dsd;
    }
    private DefaultSelectedData selectOneListbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox2Bean() {
        return selectOneListbox2Bean;
    }

    public void setSelectOneListbox2Bean(DefaultSelectedData dsd) {
        this.selectOneListbox2Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox3Bean() {
        return selectOneListbox3Bean;
    }

    public void setSelectOneListbox3Bean(DefaultSelectedData dsd) {
        this.selectOneListbox3Bean = dsd;
    }

    public List getList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
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
  EmployeeManage employeeManager = new EmployeeManage();
    private void loadEmployeeClearance(String employeeId) {
        initLoad = false;
        btnAddToTable1.setDisabled(false);
        clearingEmployeeId = employeeId;
        int departmentId;
        HashMap terReq = clearanceManager.readRequestsDetails(employeeId);
        HashMap terReqq = clearanceManager.readTerminRequestsDetails(clearingEmployeeId);
        int terminCatego = Integer.valueOf(terReqq.get("TERMINATION_TYPE").toString());

        String type = terminationrequestManager.getTypeOFTeminationType(terminCatego);

        String empId = terReqq.get("TREMINATOR_ID").toString();
        int termCateId = Integer.valueOf(terReqq.get("TERMINATION_CATAGORY").toString());
        clearanceType = clearanceManager.getTypeOFTeminationType(termCateId);
        txtClearDueTo.setValue(clearanceType + "  " + "With " + "  " + type);


        clearedClosedStatus = Integer.valueOf(terReq.get("CLEARANCE_STATUS").toString());
        employeemanage = new EmployeeManage();
        employeemanage.loadEmpoyeeProfile(empId);
        txtClearFullName.setValue(employeemanage.getTitleDes().toString() + " " + employeemanage.getFirst_Name().toString() + " " + employeemanage.getMiddle_Name().toString() + " " + employeemanage.getLast_Name().toString());
        txtClearPosition.setValue(employeemanage.getJobName().toString());
        OracleSerialBlob blo = (OracleSerialBlob) (employeemanage.getPhotobinary());
        try {
            setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
            imgEmployeePicture.setValue(getAttachedDBImg());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < getAvailabledepartment().size(); i++) {
            departmentId = Integer.valueOf(getAvailabledepartment().get(i).getDepID());

            HashMap hm = clearanceManager.checkEmployeeClearance(empId, String.valueOf(departmentId));

            if (hm.size() > 0) {
                getAvailabledepartment().get(i).clearedStatusText = "Cleared";
            } else {
                getAvailabledepartment().get(i).clearedStatusText = "Not Cleared Yet";
            }
        }
    }

    private boolean loadEmployeeTermination(String employeeId) {
        initLoad = false;
        clearingEmployeeId = employeeId;
        HashMap terReq = clearanceManager.readTerminRequestsDetails(clearingEmployeeId);
        HashMap requStatuReq = clearanceManager.readRequestsDetails(clearingEmployeeId);
        if (terReq != null) {
            if (terReq.get("TREMINATOR_ID").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "THERE IS NO TERMINATION REQUEST WITH EMPLOYEE  ID : " + clearingEmployeeId);
                return false;
            } else {
                try {
                    txtClearDueTo.setValue(terReq.get("TERMINATION_TYPE"));
                    String empId = terReq.get("TREMINATOR_ID").toString();
                    // txtEmpID.setValue("TREMINATOR_ID");
                    if (terReq.get("TERMINATION_CATAGORY").equals("Resigne")) {
                        clearanceType = "Resigne";
                        chkResign.setSelected(true);
                    } else if (terReq.get("TERMINATION_CATAGORY").equals("Retirement")) {
                        clearanceType = "Retirement";
                        chkAgeLimit.setSelected(true);
                    } else if (terReq.get("TERMINATION_CATAGORY").equals("Resigne")) {
                        clearanceType = "Resigne";
                        chkNonAgeLimit.setSelected(true);
                    } else if (terReq.get("TERMINATION_CATAGORY").equals("Transfer")) {
                        clearanceType = "Transfer";
                        chkTransfer.setSelected(true);
                    }
                    clearedClosedStatus = Integer.valueOf(requStatuReq.get("CLEARANCE_STATUS").toString());
                    employeemanage = new EmployeeManage();
                    employeemanage.loadEmpoyeeProfile(empId);
                    txtClearFullName.setValue(employeemanage.getTitleDes().toString() + " " + employeemanage.getFirst_Name().toString() + " " + employeemanage.getMiddle_Name().toString() + " " + employeemanage.getLast_Name().toString());
                    txtClearPosition.setValue(employeemanage.getJobDescription().toString());
                    OracleSerialBlob blo = (OracleSerialBlob) (employeemanage.getPhotobinary());
                    setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
                    imgEmployeePicture.setValue(getAttachedDBImg());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }

    public void lstClearancerequest_processValueChange(ValueChangeEvent vce) {
        getAvailabledepartment().clear();
        getItemTypeList().clear();
        clearAllTextField();
        readAvailableDepartments = clearanceManager.readAvailableDpartmentRequirecl();
        for (int i = 0; i < readAvailableDepartments.size(); i++) {
            HashMap mapResourceData = readAvailableDepartments.get(i);
            getAvailabledepartment().add(
                    new AvilableDepartmentDataModel(
                    Integer.valueOf(mapResourceData.get("depID").toString()),
                    mapResourceData.get("description").toString(),
                    "The selected employee required for clearance have cleared all property had from this department.", "Not Cleared Yet"));
        }
        imgEmployeePicture.setValue("");
        chkAgeLimit.resetValue();
        chkNonAgeLimit.resetValue();
        chkResign.resetValue();
        chkTransfer.resetValue();
        chkAgeLimit.setSelected(false);
        chkNonAgeLimit.setSelected(false);
        chkResign.setSelected(false);
        chkTransfer.setSelected(false);
        chkCleared.resetValue();
        chkCleared.setSelected(false);
        try {
            if (vce.getNewValue() != null) {
                loadEmployeeClearance(vce.getNewValue().toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //btnClearEmployee.setDisabled(false);
        // btnUnclearEmployee.setDisabled(false);
        //btnFinalizeClearance.setDisabled(false);
        chkYes.setDisabled(false);
        chkNo.setDisabled(false);
        btnFinalReport.setDisabled(true);
       
    }

    public void lstClearancerequestCleared_processValueChange(ValueChangeEvent vce) {

        getAvailabledepartment().clear();
        readAvailableDepartments = clearanceManager.readAvailableDpartmentRequirecl();
        for (int i = 0; i < readAvailableDepartments.size(); i++) {
            HashMap mapResourceData = readAvailableDepartments.get(i);
            getAvailabledepartment().add(
                    new AvilableDepartmentDataModel(
                    Integer.valueOf(mapResourceData.get("depID").toString()),
                    mapResourceData.get("description").toString(),
                    "The selected employee required for clearance have cleared all property had from this department.", "Not Cleared Yet"));
        }

        imgEmployeePicture.setValue("");
        chkAgeLimit.resetValue();
        chkNonAgeLimit.resetValue();
        chkResign.resetValue();
        chkTransfer.resetValue();
        chkAgeLimit.setSelected(false);
        chkNonAgeLimit.setSelected(false);
        chkResign.setSelected(false);
        chkTransfer.setSelected(false);
        chkCleared.resetValue();
        chkCleared.setSelected(false);

        try {
            if (vce.getNewValue() != null) {
                clearedEmployeeId = vce.getNewValue().toString();
                loadEmployeeClearance(vce.getNewValue().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        btnClearEmployee.setDisabled(true);
        btnUnclearEmployee.setDisabled(true);
        btnFinalizeClearance.setDisabled(true);
        chkYes.setDisabled(true);
        chkNo.setDisabled(true);
        txtRemark.setDisabled(true);
        btnFinalReport.setDisabled(false);


    }

    public DeviceList getCurrentBenefit() {
        return currentBenefit;
    }

    public void setCurrentBenefit(DeviceList currentBenefit) {
        this.currentBenefit = currentBenefit;
    }

    public void lstDepartmentSelected_processValueChange(ValueChangeEvent vce) {
    }

    public void lstAvailable_Departments_processValueChange(ValueChangeEvent vce) {
    }

    public static class AvilableDepartmentDataModel implements Serializable {

        private int depID;
        private String description;
        private boolean status;
        private boolean selected;
        private String clearedEmployeeinfo;
        private String clearedStatusText;
        private String returnedDescriptionText;

        public boolean getSelected() {
            return selected;
        }

        public String getReturnedDescriptionText() {
            return returnedDescriptionText;
        }

        public void setReturnedDescriptionText(String returnedDescriptionText) {
            this.returnedDescriptionText = returnedDescriptionText;
        }

        public String getClearedEmployeeinfo() {
            return clearedEmployeeinfo;
        }

        public void setClearedEmployeeinfo(String clearedEmployeeinfo) {
            this.clearedEmployeeinfo = clearedEmployeeinfo;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public boolean isStatus() {
            return status;
        }

        public AvilableDepartmentDataModel() {
        }

        public boolean getStatus() {

            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getClearedStatusText() {
            return clearedStatusText;
        }

        public void setClearedStatusText(String clearedStatusText) {
            this.clearedStatusText = clearedStatusText;
        }

        public int getDepID() {
            return depID;
        }

        public void setDepID(int depID) {
            this.depID = depID;
        }

        public AvilableDepartmentDataModel(int depID, String description, String returnedDescriptionText, String clearedStatusText) {
            this.depID = depID;
            this.description = description;
            this.returnedDescriptionText = returnedDescriptionText;
            this.clearedStatusText = clearedStatusText;
        }

        public AvilableDepartmentDataModel(int depID, String description, boolean status) {
            this.depID = depID;
            this.description = description;
            this.status = status;
        }
    }

    public static class SelectedDepartmentDataModel implements Serializable {

        private int depID;
        private String description;
        private String clearedStatusText;
        private String returnedDescriptionText;
        private boolean selected;

        public String getClearedStatusText() {
            return clearedStatusText;
        }

        public void setClearedStatusText(String clearedStatusText) {
            this.clearedStatusText = clearedStatusText;
        }

        public int getDepID() {
            return depID;
        }

        public void setDepID(int depID) {
            this.depID = depID;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getReturnedDescriptionText() {
            return returnedDescriptionText;
        }

        public void setReturnedDescriptionText(String returnedDescriptionText) {
            this.returnedDescriptionText = returnedDescriptionText;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public SelectedDepartmentDataModel(int depID, String description, String clearedStatusText, String returnedDescriptionText) {
            this.depID = depID;
            this.description = description;
            this.clearedStatusText = clearedStatusText;
            this.returnedDescriptionText = returnedDescriptionText;
        }

        public SelectedDepartmentDataModel(String description, String clearedStatusText, String returnedDescriptionText) {
            this.description = description;
            this.clearedStatusText = clearedStatusText;
            this.returnedDescriptionText = returnedDescriptionText;
        }
    }

    public static class ClearedDepartmentDetailDataModel implements Serializable {

        private String employeeId;
        private String employeeFullName;
        private String clearedDate;

        public String getClearedDate() {
            return clearedDate;
        }

        public void setClearedDate(String clearedDate) {
            this.clearedDate = clearedDate;
        }

        public String getEmployeeFullName() {
            return employeeFullName;
        }

        public void setEmployeeFullName(String employeeFullName) {
            this.employeeFullName = employeeFullName;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public ClearedDepartmentDetailDataModel(String employeeId, String employeeFullName, String clearedDate) {
            this.employeeId = employeeId;
            this.employeeFullName = employeeFullName;
            this.clearedDate = clearedDate;
        }
    }

    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
        selectedBenefitTypeRow = selectedRowIndex;
    }

    public void rowSelector5_processAction(RowSelectorEvent rse) {
        selectedRow = rse.getRow();

    }
    List matchesList = new ArrayList<SelectItem>();
    DeviceList currentBenefit = new DeviceList("", "0");

    public void ckboClearing_processValueChange(ValueChangeEvent vce) {
        selectedRow = tblClearingDep.getRowIndex();
        String empId = String.valueOf(availabledepartment.get(selectedRow).getDepID());
        try {
            if (clearanceManager.UpdateClearDepartments(empId, vce.getNewValue().toString()) == 1) {
            } else {
            }
        } catch (Exception ex) {
        }

    }

    public void btnSaveClearDeps_processAction(ActionEvent ae) {
    }

    public void modalPnlCloseBtn_processAction(ActionEvent ae) {
        pnlPopUpClearingDepSetting.setRendered(false);
    }

    public void commandLink1_processAction(ActionEvent ae) {
        getAvailabledepartment().clear();
        readAvailableDepartments = clearanceManager.readAvailableDpartment();
        for (int i = 0; i < readAvailableDepartments.size(); i++) {
            HashMap mapResourceData = readAvailableDepartments.get(i);
            getAvailabledepartment().add(
                    new AvilableDepartmentDataModel(
                    Integer.valueOf(mapResourceData.get("depID").toString()),
                    mapResourceData.get("description").toString(),
                    Boolean.valueOf(mapResourceData.get("depStatus").toString())));
        }
        pnlPopUpClearingDepSetting.setRendered(true);
    }

    /**
     * open a popup window page.
     *
     * @return void type.
     */
    public void displayReconSummary() {
    }

    /**
     * construct a URL to open popUp windows.
     *
     * @return void type.
     */
    private void navigateURL(String viewId) {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        // This is the proper way to get the view's url
        ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
        String actionUrl = viewHandler.getActionURL(facesContext, viewId);
        // Window pop up
        String javaScriptText = "window.showModalDialog('" + actionUrl + "', 'ClearanceProcess','dialogWidth:1024px;dialogHeight:500px,dependent=yes');";
        // Add the Javascript to the rendered page's header for immediate
        // execution
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);
        JavascriptContext.applicationFocus(facesContext, "true");

    }

    public String lnkCheckIt_action() {
        int i = tblClearingDep1.getRowIndex();
        int selected = Integer.valueOf(getSelectedDepartment().get(i).getDepID());
        switch (selected) {
            case 1:
                navigateURL("http://localhost:8149/HRMS/EmployeeTermination/ClearancePage.jsp");
                break;
            case 2:
                navigateURL("http://localhost:8149/HRMS/EmployeeTermination/TerminationRequestPage.jsp");
                break;
            default:
                navigateURL("");
                break;
        }
        return null;
    }

    public void commandLink4_processAction(ActionEvent ae) {
    }

    public String commandLink2_action() {
        //return null means stay on the same page
        return "Terminationrequest";
    }

    public String commandLink3_action() {
        //return null means stay on the same page
        return "TerminationApproval";
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public void rwSelectorPeriodList_processMyEvent(RowSelectorEvent rse) {
        int row = tblClearingDep1.getRowIndex();
        getClearedDepartmentDetail().clear();
        chkYes.resetValue();
        chkNo.resetValue();
        chkYes.setSelected(false);
        chkNo.setSelected(false);
        txtRemark.setValue(null);
        if (getAvailabledepartment().get(row).isSelected()) {
            int rowSelected = Integer.valueOf(getAvailabledepartment().get(row).getDepID());
            clearingDepartmentId = String.valueOf(rowSelected);
            ItemTypeList = clearanceManager.getAllBenefitTypes(clearingDepartmentId, clearingEmployeeId);
            
            if (loggedInDeptId.equals(clearingDepartmentId)) {
                btnClearEmployee.setDisabled(false);
                btnFinalizeClearance.setDisabled(false);
                btnUnclearEmployee.setDisabled(false);
                if (clearingEmployeeId != null && clearanceType != null) {

                    HashMap hm = clearanceManager.readClearedDepartmentDetail(clearingEmployeeId, clearanceType, rowSelected);
                    if (hm.size() > 0) {
                        employeemanage = new EmployeeManage();
                        employeemanage.loadEmpoyeeProfile(hm.get("CLEARED_BY").toString());
                        int cleardId = Integer.valueOf(hm.get("CLEARED_ID").toString());

                        String fullName = employeemanage.getTitleDes() + " " + employeemanage.getFirst_Name() + " " + employeemanage.getMiddle_Name() + " " + employeemanage.getLast_Name();
                        getClearedDepartmentDetail().add(new ClearedDepartmentDetailDataModel(
                                hm.get("CLEARED_BY").toString(),
                                fullName,
                                hm.get("CLEARED_DATE").toString()));
                        HashMap hmh = clearanceManager.readClearedDepartmentDetailHistory(String.valueOf(cleardId));
                        if (hmh.size() > 0) {
                            if (Integer.valueOf(hmh.get("RETURNED_YES").toString()) == 1) {
                                chkYes.setSelected(true);
                                chkNo.setSelected(false);
                            } else {
                                chkYes.setSelected(false);
                                chkNo.setSelected(true);
                            }
                            if (Integer.valueOf(hmh.get("RETURNED_NO").toString()) == 1) {
                                chkNo.setSelected(true);
                                chkYes.setSelected(false);
                            } else {
                                chkNo.setSelected(false);
                                chkYes.setSelected(true);
                            }
                            if (hmh.get("RETURNED_REMARK").toString() != null) {
                                txtRemark.setValue(hmh.get("RETURNED_REMARK").toString());
                            } else {
                                txtRemark.setValue(null);
                            }
                        }
                    }
                }
            } else {
                btnClearEmployee.setDisabled(true);
                btnFinalizeClearance.setDisabled(true);
                btnUnclearEmployee.setDisabled(true);
            }
        }
    }

    public boolean isEntryValidFoYes() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Write your Remark";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtRemark.getValue());
        if (!required) {
            ((UIInput) txtRemark).setValid(false);
            error(txtRemark, errorMessage);
            results = false;
        }
        return results;
    }

    public void clearAllTextField() {
        txtDeviceNAme.setValue("");
        txtRemark.setValue("");
        txtSearchByDevice.setValue("");
        chkYes.setSelected(false);
        chkNo.setSelected(false);
    }

    public String btnClearEmployee_action() {
        //return null means stay on the same page
        if (clearedClosedStatus == 0) {
            int yes = 0;
            int no = 0;
            String remark = "NO";

            if (chkYes.isSelected()) {
               
//                if (isEntryValidFoYes()) {
                yes = 1;
                no = 0;
                if ((clearanceManager.saveYesmployeeClearance(clearingEmployeeId, loggedInUserId, dateFormat.format(new Date()), clearingDepartmentId, clearanceType, yes, no, remark) != 0) && clearanceManager.saveBenefitTypes(ItemTypeList)) {
                    showSuccessOrFailureMessage(true, "The selected employee successfully cleared. You can unclear if there is a problem related to the employee until the final clearance is closed by the HR Admin.");
                    loadEmployeeClearance(clearingEmployeeId);
                    ItemTypeList = clearanceManager.getAllBenefitTypes(clearingDepartmentId, clearingEmployeeId);
                    clearAllTextField();
                } else {
                    showSuccessOrFailureMessage(false, "Error occureed while clearing the employee.Please check if the clearance already made.");
                }
            } else if (chkNo.isSelected()) {
               
                yes = 0;
                no = 1;
                remark = "NO";
                String clearedDate = dateFormat.format(new Date());
                if (clearanceManager.saveEmployeeClearance(clearingEmployeeId, loggedInUserId, clearedDate, clearingDepartmentId, clearanceType, yes, no, remark) != 0) {
                    showSuccessOrFailureMessage(true, "The selected employee successfully cleared. You can unclear if there is a problem related to the employee until the final clearance is closed by the HR Admin.");
                    loadEmployeeClearance(clearingEmployeeId);
                    clearAllTextField();
                } else {
                    showSuccessOrFailureMessage(false, "Error occureed while clearing the employee.Please check if the clearance already made.");
                }
            } else {
                showSuccessOrFailureMessage(false, "First Select Yes Or No Question \n Or Select Your Department");
            }

        } else {
            showSuccessOrFailureMessage(false, "Please select Yes or No to continue. \n Or Select Your Department");
        }
        return null;
    }

    public String btnUnclearEmployee_action() {
        //return null means stay on the same page
        if (clearedClosedStatus == 0) {
            if ((clearanceManager.deleteEmployeeClearance(clearingEmployeeId, clearanceType, Integer.valueOf(clearingDepartmentId)) == 1) && (clearanceManager.deleteEmployeeClearanceItem(clearingEmployeeId, clearingDepartmentId) == 1)) {

                showSuccessOrFailureMessage(true, "The selected employee successfully uncleared. You can clear if there is no problem related to the employee until the final clearance is closed by the HR Admin.");
                loadEmployeeClearance(clearingEmployeeId);
                ItemTypeList = clearanceManager.getAllBenefitTypes(clearingDepartmentId, clearingEmployeeId);
                clearAllTextField();
            } else {
                showSuccessOrFailureMessage(false, "Error occureed while unclearing the employee.Please try again.");
            }
        } else {
            showSuccessOrFailureMessage(false, "The clearance session is closed, You can not unclear the selected employe.");
        }
        return null;
    }

    public String btnFinalizeClearance_action() {
        //return null means stay on the same page
        int departmentId;
        boolean found = false;
        chkNo.setSelected(false);
        chkYes.setSelected(false);
        txtRemark.setValue(null);
        getClearedDepartmentDetail().clear();
        for (int i = 0; i < getSelectedDepartment().size(); i++) {
            if (!getSelectedDepartment().get(i).clearedStatusText.equalsIgnoreCase("Cleared")) {
                found = true;
                break;
            }
        }
        
        if (found == false) {
            
            if (clearanceManager.finalizeClerance(clearingEmployeeId, clearanceType, loggedInUserId, StringDateManipulation.currentDateInGC()) == 1) {
                showSuccessOrFailureMessage(true, "Final clerance has been made sucessfull.Report is now ready.");
            }
            loadEmployeeClearance(clearingEmployeeId);
        } else {
            showSuccessOrFailureMessage(false, "The selected employee is not finish clearing yet.Please make sure he/she has been cleared all selected departments.");
        }

        return null;
    }

    public void chkYes_processValueChange(ValueChangeEvent vce) {
        if (chkYes.isSelected()) {
            chkNo.setSelected(false);
            chkInKind.setDisabled(false);
            chkIncash.setDisabled(false);
            txtRemark.setDisabled(false);
            btnAddToTable1.setDisabled(false);
            txtSearchByDevice.setDisabled(false);
          //  btnClearEmployee.setDisabled(true);
            btnUpdate.setDisabled(false);
        } else {
            chkNo.setSelected(true);
            chkInKind.setDisabled(true);
            chkIncash.setDisabled(true);
            txtRemark.setDisabled(true);
            btnAddToTable1.setDisabled(true);
            txtSearchByDevice.setDisabled(true);
            btnClearEmployee.setDisabled(false);
            btnUpdate.setDisabled(true);
        }
    }

    public void chkNo_processValueChange(ValueChangeEvent vce) {
        if (chkNo.isSelected()) {
            chkYes.setSelected(false);
            chkInKind.setDisabled(true);
            chkIncash.setDisabled(true);
            txtRemark.setDisabled(true);
            btnAddToTable1.setDisabled(true);
            txtSearchByDevice.setDisabled(true);
            btnClearEmployee.setDisabled(false);
            btnUpdate.setDisabled(true);
        } else {
            chkYes.setSelected(true);
            chkInKind.setDisabled(false);
            chkIncash.setDisabled(false);
            txtRemark.setDisabled(false);
            btnAddToTable1.setDisabled(false);
            txtSearchByDevice.setDisabled(false);
            btnClearEmployee.setDisabled(true);
            btnUpdate.setDisabled(false);
        }
    }

    public void LoadLOGO() {
//        List data = null;
//        ReportManager manager1 = new ReportManager();
//        data = manager1.loadCompanyLogo();
//        ListIterator<ReportManager> lstmb = data.listIterator();
//        try {
//            while (lstmb.hasNext()) {
//                ReportManager mag = lstmb.next();
//                if (mag.getFPLOGO() != null) {
//                    LOGO = new ImageIcon((byte[]) mag.getFPLOGO());
//                } else {
//                    LOGO = new ImageIcon();
//                }
//            }
//        } catch (Exception ex) {
//        }
    }

    public void loadEmployeePicture(byte[] employeePicture) {
        try {
            if (employeePicture != null) {
                this.employeePicture = new ImageIcon((byte[]) employeePicture);
            } else {
                this.employeePicture = new ImageIcon();
            }
        } catch (Exception ex) {
        }

    }

    public String btnGenerateReport_action() {
        //return null means stay on the same page
        if (clearedEmployeeId != null) {
            String forDepartment = "";
            String concatnatedDepartment = null;
            String fromDate = null;
            String toDate = null;
            HashMap param = new HashMap();
            String jasperLocation = "A:\\MUGHERREPORTS\\Clearance\\ClearanceReport.jasper";
            String reportName = "ClearanceReport";
            if (fromDate != null && toDate != null && concatnatedDepartment != null) {
                Collection data = null;//clearanceManager.loadAttendanceReport(fromDate, toDate, concatnatedDepartment);

                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                ServletOutputStream servletOutputStream = null;

                try {
                    servletOutputStream = response.getOutputStream();
                    employeemanage = new EmployeeManage();
                    employeemanage.loadEmpoyeeProfile(clearedEmployeeId);
                    try {
                        OracleSerialBlob blo = (OracleSerialBlob) (employeemanage.getPhotobinary());
                        setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
                        loadEmployeePicture(getAttachedDBImg());

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    LoadLOGO();

                    forDepartment = forDepartment = departmentManage.readDepartmentPath(employeemanage.getDepartment());
                    param.put("EMPLOYEEID", clearedEmployeeId);
                    param.put("FULLNAME", employeemanage.getTitleDes() + " " + employeemanage.getFirst_Name() + " " + employeemanage.getMiddle_Name() + " " + employeemanage.getLast_Name());
                    param.put("PHOTO", this.employeePicture.getImage());
                    param.put("LOGO", this.LOGO.getImage());
                    param.put("DEPARTMENT", forDepartment);
                    param.put("POSITION", employeemanage.getJobDescription());

                    HashMap hm = clearanceManager.readRequestsDetails(clearedEmployeeId);
                    if (hm != null) {
                        if (hm.get("CLEARANCE_TYPE").toString().endsWith("0")) {
                            param.put("REASONTYPE", "ሥራ መ�?ቀቅ");
                        } else if (hm.get("CLEARANCE_TYPE").toString().endsWith("1")) {
                            param.put("REASONTYPE", "የእድሜ ጣሪያ");
                        } else if (hm.get("CLEARANCE_TYPE").toString().endsWith("2")) {
                            param.put("REASONTYPE", "የእድሜ ጣሪያ ሳይደርስ");
                        } else {
                            param.put("REASONTYPE", "");
                        }
                        param.put("REASONDESCRIPTION", hm.get("CLEARANCE_REASON").toString());
                        param.put("TERMINATEDDATE", hm.get("DATE_TERMINATED").toString());
                        param.put("CLEAREDDATE", hm.get("FINAL_CLEARED_DATE").toString());
                        employeemanage = new EmployeeManage();
                        employeemanage.loadEmpoyeeProfile(hm.get("FINAL_CLEARED_BY").toString());
                        param.put("FINALBOSSFULLNAME", employeemanage.getTitleDes() + " " + employeemanage.getFirst_Name() + " " + employeemanage.getMiddle_Name() + " " + employeemanage.getLast_Name());
                        param.put("FINALBOSSID", hm.get("FINAL_CLEARED_BY").toString());
                        param.put("FINALBOSSDATECLEARED", hm.get("FINAL_CLEARED_DATE").toString());
                    } else {
                        param.put("REASONTYPE", "");
                        param.put("REASONDESCRIPTION", "");
                        param.put("TERMINATEDDATE", "");
                        param.put("CLEAREDDATE", "");
                        param.put("FINALBOSSFULLNAME", "");
                        param.put("FINALBOSSID", "");
                        param.put("FINALBOSSDATECLEARED", "");
                    }

                    reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                    servletOutputStream.flush();
                    servletOutputStream.close();
                    // Stop resend
                    FacesContext.getCurrentInstance().responseComplete();

                } catch (Exception ex) {
                    // ex.printStackTrace();
                    //  ErrorLogWriter.writeError(ex);
                }
            }
        }
        return null;
    }

    public String btnFinalReport_action() {
        //return null means stay on the same page
        if (clearedEmployeeId != null) {
            String forDepartment = "";
            HashMap param = new HashMap();
            String jasperLocation = "A:\\FEDERALREPORTS\\Clearance\\ClearanceReport.jasper";
            String reportName = "ClearanceReport";
            Collection data = clearanceManager.loadClearedDepartmentsReport(clearedEmployeeId, clearanceType);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            ServletOutputStream servletOutputStream = null;

            try {
                servletOutputStream = response.getOutputStream();
                employeemanage = new EmployeeManage();
                employeemanage.loadEmpoyeeProfile(clearedEmployeeId);
                try {
                    OracleSerialBlob blo = (OracleSerialBlob) (employeemanage.getPhotobinary());
                    setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
                    loadEmployeePicture(getAttachedDBImg());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                forDepartment = forDepartment = departmentManage.readDepartmentPath(employeemanage.getDepartment());
                param.put("EMPLOYEEID", clearedEmployeeId);
                param.put("FULLNAME", employeemanage.getTitleDes() + " " + employeemanage.getFirst_Name() + " " + employeemanage.getMiddle_Name() + " " + employeemanage.getLast_Name());
                param.put("PHOTO", employeePicture.getImage());
                param.put("DEPARTMENT", forDepartment);
                param.put("POSITION", employeemanage.getJobDescription());

                HashMap hm = clearanceManager.readRequestsDetails(clearedEmployeeId);
                if (hm != null) {
                    if (hm.get("CLEARANCE_TYPE").toString().endsWith("0")) {
                        param.put("REASONTYPE", "ሥራ መ�?ቀቅ");
                    } else if (hm.get("CLEARANCE_TYPE").toString().endsWith("1")) {
                        param.put("REASONTYPE", "የእድሜ ጣሪያ");
                    } else if (hm.get("CLEARANCE_TYPE").toString().endsWith("2")) {
                        param.put("REASONTYPE", "የእድሜ ጣሪያ ሳይደርስ");
                    } else {
                        param.put("REASONTYPE", "");
                    }
                    param.put("REASONDESCRIPTION", hm.get("CLEARANCE_REASON").toString());
                    param.put("TERMINATEDDATE", hm.get("DATE_TERMINATED").toString());
                    param.put("CLEAREDDATE", hm.get("FINAL_CLEARED_DATE").toString());
                    employeemanage = new EmployeeManage();
                    employeemanage.loadEmpoyeeProfile(hm.get("FINAL_CLEARED_BY").toString());
                    param.put("FINALBOSSFULLNAME", employeemanage.getTitleDes() + " " + employeemanage.getFirst_Name() + " " + employeemanage.getMiddle_Name() + " " + employeemanage.getLast_Name());
                    param.put("FINALBOSSID", hm.get("FINAL_CLEARED_BY").toString());
                    param.put("FINALBOSSDATECLEARED", hm.get("FINAL_CLEARED_DATE").toString());
                } else {
                    param.put("REASONTYPE", "");
                    param.put("REASONDESCRIPTION", "");
                    param.put("TERMINATEDDATE", "");
                    param.put("CLEAREDDATE", "");
                    param.put("FINALBOSSFULLNAME", "");
                    param.put("FINALBOSSID", "");
                    param.put("FINALBOSSDATECLEARED", "");
                }

                reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                servletOutputStream.flush();
                servletOutputStream.close();
                // Stop resend
                FacesContext.getCurrentInstance().responseComplete();

            } catch (Exception ex) {
                // ex.printStackTrace();
                //  ErrorLogWriter.writeError(ex);
            }
        }
        return null;
    }

    public String commandLink1_action() {
        //return null means stay on the same page
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
                    setItemName(currentBenefit.getDiviceName());
                } //
            }
        }

    }

    public String cmdLnkEdit_action() {
        //return null means stay on the same page
        if (selectedBenefitTypeRow != -1) {
            if (ItemTypeList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("Old")) {
                ItemTypeList.get(selectedBenefitTypeRow).setDataBaseStatus("Edited");
            }
        }
        return null;
    }
    int selectedBenefitTypeRow = -1;

    public String cmdLnkRemove_action() {
        //return null means stay on the same page
        if (selectedBenefitTypeRow != -1) {
            if (ItemTypeList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("New")) {
                ItemTypeList.remove(selectedBenefitTypeRow);
            } else if (ItemTypeList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("Old") ||
                    ItemTypeList.get(selectedBenefitTypeRow).getDataBaseStatus().equals("Edited")) {
                ItemTypeList.get(selectedBenefitTypeRow).setDataBaseStatus("Deleted");
            }
        }
        return null;
    }

    private boolean isMAterialRegistered(String MAterialName)
                        {
        for (ItemListModel currentBenefitType : ItemTypeList)
        {
            if (currentBenefitType.getItemName().equals(MAterialName)) {
                return true;
            }
        }
        return true;
    }
 public boolean isEntryValidForInkind() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtDeviceNAme.getValue());
        if (!required) {
            ((UIInput) txtDeviceNAme).setValid(false);
            error(txtDeviceNAme, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtRemark.getValue());
        if (!required) {
            ((UIInput) txtRemark).setValid(false);
            error(txtRemark, errorMessage);
            results = false;
        }
        return results;
 }
 public boolean isEntryValidForInCash() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
       errorValue = HRValidation.validateData(this.txtAmountOfBirr.getValue(), HRValidation.DOUBLE_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtAmountOfBirr).setValid(false);
                error(txtAmountOfBirr, errorMessage);
            } else {
                ((UIInput) txtAmountOfBirr).setValid(false);
                error(txtAmountOfBirr, "Invalid Value");
            }
        }
        required = HRValidation.validateRequired(this.txtRemark.getValue());
        if (!required) {
            ((UIInput) txtRemark).setValid(false);
            error(txtRemark, errorMessage);
            results = false;
        }
        return results;
 }
    public String btnAddToTable1_action() {
        //return null means stay on the same page'
        itemName = txtDeviceNAme.getValue().toString();
        if (isMAterialRegistered(itemName)) {
            showSuccessOrFailureMessage(false, "ALREADY REGISTERED");
        } else {
             if( isEntryValidForInCash() || isEntryValidForInkind()){
            if (chkIncash.isSelected() == true) {
                
              
                itemName = "Money";
                price = Double.valueOf(txtAmountOfBirr.getValue().toString());
           
            
            }
            if (chkInKind.isSelected() == true) {
               
                itemName = txtDeviceNAme.getValue().toString();
                price = 0;
                }
           
            description = txtRemark.getValue().toString();
            selected = false;
            dataBaseStatus = "New";
            ItemTypeList.add(0, new ItemListModel(itemName, price, description, selected, dataBaseStatus, clearingDepartmentId, clearingEmployeeId));
             }
        }
        return null;
    }

    public String txtSearchByDevice_action() {
        //return null means stay on the same page
        selectedId = null;
        selectedId = this.getSelectedBenefitId();
        if (selectedId != null) {
            //clearAllComponents();
            txtDeviceNAme.resetValue();

            txtDeviceNAme.setValue(getItemName());
        }
        return null;
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        if (clearanceManager.saveBenefitTypes(ItemTypeList)) {
            showSuccessOrFailureMessage(true, "UPDATING SUCCESFULL");
        } else {
            showSuccessOrFailureMessage(true, "UPDATING FAILED");
        }
        return null;
    }

    public void chkInKind_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().equals(true)) {
            txtSearchByDevice.setDisabled(false);
            txtAmountOfBirr.setDisabled(true);
            chkInKind.setSelected(true);
            chkIncash.setSelected(false);
        } else {
            txtSearchByDevice.setDisabled(true);
            txtAmountOfBirr.setDisabled(false);
            chkInKind.setSelected(false);
            chkIncash.setSelected(true);
        }
    }

    public void chkIncash_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().equals(true)) {
            txtSearchByDevice.setDisabled(true);
            txtAmountOfBirr.setDisabled(false);
            chkInKind.setSelected(false);
            chkIncash.setSelected(true);
        } else {
            txtSearchByDevice.setDisabled(false);
            txtAmountOfBirr.setDisabled(true);
            chkIncash.setSelected(false);
            chkInKind.setSelected(true);
        }
    }

    public void ClearanceManager_processMyEvent(DragEvent de) {
    }
}
