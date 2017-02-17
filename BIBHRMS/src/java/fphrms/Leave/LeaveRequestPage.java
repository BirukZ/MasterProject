package fphrms.Leave;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGrid;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.DOMContext;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.icesoft.faces.renderkit.dom_html_basic.HTML;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.MissingResourceException;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.CommonValidation;
import manager.globalUseManager.StringDateManipulation;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import manager.globalUseManager.ErrorLogWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import fphrms.AutoCompleteDictionary;
import fphrms.EmployeeList;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;


import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.DateConverter;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.LookUpManager;
import manager.leaveManager.LeaveApproveManager;
import manager.leaveManager.LeaveControl;
import manager.leaveManager.LeaveRequestManager;
import manager.leaveManager.LeaveTypeManager;
import manager.overTimeManager.OverTimeRequestManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LeaveRequestPage extends AbstractPageBean {

    AutoCompleteDictionary autoCompleteDictionary = new AutoCompleteDictionary();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private ArrayList<HashMap> listOfFamilyPassedAwaye = new ArrayList<HashMap>();
    private LookUpManager lookUpManager = new LookUpManager();
    private boolean firstTime = true;
    private String employeeId = null;
    private static String selectedId;
    private String selectedEmployeeId;
    private String sex;
    private byte[] employeePicture;
    private String empStatus;
    private int ownerGroupId[];
    private int tempOwnerGroupId = 0;
    private int currentStateId = 0;
    private String employeLeaveTypeAddress = null;
    private String leaveID = null;
    private int requestID = 0;
    private int requestTableSize = 0;
    private int countRequest = 0;
    private String loggedInUserId = null;
    private String leaveFrom = "";
    private String leaveFromId = "";
    private String leaveRequestId = null;
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<SelectItem> division_Name = new ArrayList<SelectItem>();
    private EmployeeManage employeeManager = new EmployeeManage();
    private LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
    private ArrayList<SelectItem> leaveType = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> requestsLists = new ArrayList<SelectItem>();
    private PanelPopup pnlPopUpSuccessOrFailure = new PanelPopup();
    private List matchesList = new ArrayList<SelectItem>();
    private EmployeeList currentEmployee1 = new EmployeeList("", "0", null);
    private HashMap listOfReserveId = new HashMap();
    private ArrayList<LeaveRequestManager> leaveRequestTable = new ArrayList<LeaveRequestManager>();
    private boolean saturdayHalf = false;
    private ArrayList<EmployeeFamilyList> familyList = new ArrayList<EmployeeFamilyList>();
    private ArrayList<EmployeeFamilyList> savePassedAwayFamily = new ArrayList<EmployeeFamilyList>();
    private ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    private ArrayList<SelectItem> regionOpt = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> zoneList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> woredaList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> kebeleList = new ArrayList<SelectItem>();
    private LeaveControl leaveControl = new LeaveControl();
    private ArrayList<HashMap> tableHour = new ArrayList<HashMap>();
    private OverTimeRequestManager overTimeRequestManager = new OverTimeRequestManager();
    private String hours = "";
    private String minite = "";
    private int addHours = 0;
    private String usedYear = "";

    public ArrayList<HashMap> getTableHour() {
        return overTimeRequestManager.getTableHour();
    }

    public void setTableHour(ArrayList<HashMap> tableHour) {
        this.tableHour = tableHour;
    }

    public ArrayList<SelectItem> getKebeleList() {
        return kebeleList;
    }

    public void setKebeleList(ArrayList<SelectItem> kebeleList) {
        this.kebeleList = kebeleList;
    }

    public ArrayList<SelectItem> getWoredaList() {
        return woredaList;
    }

    public void setWoredaList(ArrayList<SelectItem> woredaList) {
        this.woredaList = woredaList;
    }

    public ArrayList<SelectItem> getZoneList() {
        return zoneList;
    }

    public void setZoneList(ArrayList<SelectItem> zoneList) {
        this.zoneList = zoneList;
    }

    public ArrayList<SelectItem> getRegionOpt() {
        return regionOpt;
    }

    public void setRegionOpt(ArrayList<SelectItem> regionOpt) {
        this.regionOpt = regionOpt;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public boolean isSaturdayHalf() {
        return saturdayHalf;
    }

    public void setSaturdayHalf(boolean saturdayHalf) {
        this.saturdayHalf = saturdayHalf;
    }

    public ArrayList<HashMap> getListOfFamilyPassedAwaye() {
        return listOfFamilyPassedAwaye;
    }

    public void setListOfFamilyPassedAwaye(ArrayList<HashMap> listOfFamilyPassedAwaye) {
        this.listOfFamilyPassedAwaye = listOfFamilyPassedAwaye;
    }

    public ArrayList<EmployeeFamilyList> getSavePassedAwayFamily() {
        return savePassedAwayFamily;
    }

    public void setSavePassedAwayFamily(ArrayList<EmployeeFamilyList> savePassedAwayFamily) {
        this.savePassedAwayFamily = savePassedAwayFamily;
    }

    public ArrayList<EmployeeFamilyList> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(ArrayList<EmployeeFamilyList> familyList) {
        this.familyList = familyList;
    }

    public HashMap getListOfReserveId() {
        return listOfReserveId;
    }

    public void setListOfReserveId(HashMap listOfReserveId) {
        this.listOfReserveId = listOfReserveId;
    }

    public ArrayList<LeaveRequestManager> getLeaveRequestTable() {
        return leaveRequestTable;
    }

    public void setLeaveRequestTable(ArrayList<LeaveRequestManager> leaveRequestTable) {
        this.leaveRequestTable = leaveRequestTable;
    }

    public ArrayList<SelectItem> getRequestsLists() {
        return requestsLists;
    }

    public void setRequestsLists(ArrayList<SelectItem> requestsLists) {
        this.requestsLists = requestsLists;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public List getMatchesList() {
        return matchesList;
    }

    public List getList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }

    public ArrayList<SelectItem> getDivision_Name() {
        return division_Name;
    }

    public void setDivision_Name(ArrayList<SelectItem> division_Name) {
        this.division_Name = division_Name;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private SelectInputText txtSearchByName = new SelectInputText();

    public SelectInputText getTxtSearchByName() {
        return txtSearchByName;
    }

    public void setTxtSearchByName(SelectInputText sit) {
        this.txtSearchByName = sit;
    }
    CommonValidation validate = new CommonValidation();
    private int __placeholder;

    public String getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(String leaveID) {
        this.leaveID = leaveID;
    }
    // boolean renderAvailableDays = true;

//    public boolean isRenderAvailableDays() {
//        return renderAvailableDays;
//    }
//
//    public void setRenderAvailableDays(boolean renderAvailableDays) {
//        this.renderAvailableDays = renderAvailableDays;
//    }
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        if (firstTime) {
            firstTime = false;
            setLeaveType(leaveRequestManager.notAvailableLeaveType());
            this.setRegionOpt(lookUpManager.readRegion());
        }
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlInputText txtEmployeeID = new HtmlInputText();

    public HtmlInputText getTxtEmployeeID() {
        return txtEmployeeID;
    }

    public void setTxtEmployeeID(HtmlInputText txtEmployeeID2) {
        this.txtEmployeeID = txtEmployeeID2;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="All getters and setters">
    public PanelPopup getPnlPopUpSuccessOrFailure() {
        return pnlPopUpSuccessOrFailure;
    }

    public void setPnlPopUpSuccessOrFailure(PanelPopup pnlPopUpSuccessOrFailure) {
        this.pnlPopUpSuccessOrFailure = pnlPopUpSuccessOrFailure;
    }
    private HtmlOutputText lblFormMessage = new HtmlOutputText();

    public HtmlOutputText getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputText lblFormMessage) {
        this.lblFormMessage = lblFormMessage;
    }

    public PanelPopup getPanelPopup() {
        return panelPopup;
    }

    public void setPanelPopup(PanelPopup panelPopup) {
        this.panelPopup = panelPopup;
    }
    private PanelLayout message = new PanelLayout();

    public PanelLayout getMessage() {
        return message;
    }

    public void setMessage(PanelLayout message) {
        this.message = message;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public static String getSelectedId() {
        return selectedId;
    }

    public static void setSelectedId(String selectedId) {
        LeaveRequestPage.selectedId = selectedId;
    }

    public CommonValidation getValidate() {
        return validate;
    }

    public void setValidate(CommonValidation validate) {
        this.validate = validate;
    }

    public ArrayList<SelectItem> getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(ArrayList<SelectItem> leaveType) {
        this.leaveType = leaveType;
    }
    /**
     * @return the leaveTypes
     */
    private HtmlInputText txtAvilablDayes = new HtmlInputText();

    public HtmlInputText getTxtAvilablDayes() {
        return txtAvilablDayes;
    }

    public void setTxtAvilablDayes(HtmlInputText hit) {
        this.txtAvilablDayes = hit;
    }
    private HtmlInputText txtLeaveDays = new HtmlInputText();

    public HtmlInputText getTxtLeaveDays() {
        return txtLeaveDays;
    }

    public void setTxtLeaveDays(HtmlInputText hit) {
        this.txtLeaveDays = hit;
    }
    private HtmlInputText txtDateTo = new HtmlInputText();

    public HtmlInputText getTxtDateTo() {
        return txtDateTo;
    }

    public void setTxtDateTo(HtmlInputText hit) {
        this.txtDateTo = hit;
    }
    private HtmlInputText txtDateFrom = new HtmlInputText();

    public HtmlInputText getTxtDateFrom() {
        return txtDateFrom;
    }

    public void setTxtDateFrom(HtmlInputText hit) {
        this.txtDateFrom = hit;
    }
    private HtmlInputTextarea txtReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtReason() {
        return txtReason;
    }

    public void setTxtReason(HtmlInputTextarea hit) {
        this.txtReason = hit;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
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
    private HtmlCommandButton btnCalculateLeave = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalculateLeave() {
        return btnCalculateLeave;
    }

    public void setBtnCalculateLeave(HtmlCommandButton hcb) {
        this.btnCalculateLeave = hcb;
    }
    private HtmlCommandButton btnCalenderDateFrom = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderDateFrom() {
        return btnCalenderDateFrom;
    }

    public void setBtnCalenderDateFrom(HtmlCommandButton hcb) {
        this.btnCalenderDateFrom = hcb;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private PanelCollapsible panelCollapsible2 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible2() {
        return panelCollapsible2;
    }

    public void setPanelCollapsible2(PanelCollapsible panelCollapsible2) {
        this.panelCollapsible2 = panelCollapsible2;
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }
    private PanelPopup popupLeaveMsg = new PanelPopup();

    public PanelPopup getPopupLeaveMsg() {
        return popupLeaveMsg;
    }

    public void setPopupLeaveMsg(PanelPopup pp) {
        this.popupLeaveMsg = pp;
    }
    private PanelPopup pnlpopupAbsentee = new PanelPopup();

    public PanelPopup getPnlpopupAbsentee() {
        return pnlpopupAbsentee;
    }

    public void setPnlpopupAbsentee(PanelPopup pp) {
        this.pnlpopupAbsentee = pp;
    }
    private HtmlOutputText lblAvailableLeaveDays = new HtmlOutputText();

    public HtmlOutputText getLblAvailableLeaveDays() {
        return lblAvailableLeaveDays;
    }

    public void setLblAvailableLeaveDays(HtmlOutputText hot) {
        this.lblAvailableLeaveDays = hot;
    }
    private HtmlSelectOneListbox selectRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectRequestLists() {
        return selectRequestLists;
    }

    public void setSelectRequestLists(HtmlSelectOneListbox hsol) {
        this.selectRequestLists = hsol;
    }
    private HtmlOutputText lblEmploymentStatus = new HtmlOutputText();

    public HtmlOutputText getLblEmploymentStatus() {
        return lblEmploymentStatus;
    }

    public void setLblEmploymentStatus(HtmlOutputText hot) {
        this.lblEmploymentStatus = hot;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
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
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private HtmlOutputText lblFull_Name = new HtmlOutputText();

    public HtmlOutputText getLblFull_Name() {
        return lblFull_Name;
    }

    public void setLblFull_Name(HtmlOutputText hot) {
        this.lblFull_Name = hot;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlOutputText lblPosition = new HtmlOutputText();

    public HtmlOutputText getLblPosition() {
        return lblPosition;
    }

    public void setLblPosition(HtmlOutputText hot) {
        this.lblPosition = hot;
    }
    private HtmlSelectBooleanCheckbox choFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoFemale() {
        return choFemale;
    }

    public void setChoFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.choFemale = hsbc;
    }
    private HtmlSelectBooleanCheckbox choMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMale() {
        return choMale;
    }

    public void setChoMale(HtmlSelectBooleanCheckbox hsbc) {
        this.choMale = hsbc;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlOutputText lblServiceYear = new HtmlOutputText();

    public HtmlOutputText getLblServiceYear() {
        return lblServiceYear;
    }

    public void setLblServiceYear(HtmlOutputText hot) {
        this.lblServiceYear = hot;
    }
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private PanelLayout pnlConfirmationMessageBody = new PanelLayout();

    public PanelLayout getPnlConfirmationMessageBody() {
        return pnlConfirmationMessageBody;
    }

    public void setPnlConfirmationMessageBody(PanelLayout pl) {
        this.pnlConfirmationMessageBody = pl;
    }
    private HtmlOutputLabel lblFormMessage4 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private HtmlCommandButton btnEmplyeeSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnEmplyeeSearch() {
        return btnEmplyeeSearch;
    }

    public void setBtnEmplyeeSearch(HtmlCommandButton hcb) {
        this.btnEmplyeeSearch = hcb;
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
    private DefaultSelectedData selectOneMenu2DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2DataBean() {
        return selectOneMenu2DataBean;
    }

    public void setSelectOneMenu2DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu2DataBean = dsd;
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
    private DefaultSelectItemsArray selectOneMenu2DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems4() {
        return selectOneMenu2DefaultItems4;
    }

    public void setSelectOneMenu2DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems5() {
        return selectOneMenu2DefaultItems5;
    }

    public void setSelectOneMenu2DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems5 = dsia;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private PanelCollapsible colsRequestLisrt = new PanelCollapsible();

    public PanelCollapsible getColsRequestLisrt() {
        return colsRequestLisrt;
    }

    public void setColsRequestLisrt(PanelCollapsible pc) {
        this.colsRequestLisrt = pc;
    }
    private PanelCollapsible colsEmployeeSearchByName = new PanelCollapsible();

    public PanelCollapsible getColsEmployeeSearchByName() {
        return colsEmployeeSearchByName;
    }

    public void setColsEmployeeSearchByName(PanelCollapsible pc) {
        this.colsEmployeeSearchByName = pc;
    }
    private PanelPopup pnConfirmationForDelete = new PanelPopup();

    public PanelPopup getPnConfirmationForDelete() {
        return pnConfirmationForDelete;
    }

    public void setPnConfirmationForDelete(PanelPopup pp) {
        this.pnConfirmationForDelete = pp;
    }
    private HtmlOutputLabel lblFormDeleteMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormDeleteMessage() {
        return lblFormDeleteMessage;
    }

    public void setLblFormDeleteMessage(HtmlOutputLabel hol) {
        this.lblFormDeleteMessage = hol;
    }
    private HtmlSelectOneMenu drlSelectWorkflow = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSelectWorkflow() {
        return drlSelectWorkflow;
    }

    public void setDrlSelectWorkflow(HtmlSelectOneMenu hsom) {
        this.drlSelectWorkflow = hsom;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private PanelPopup pnlFamilyList = new PanelPopup();

    public PanelPopup getPnlFamilyList() {
        return pnlFamilyList;
    }

    public void setPnlFamilyList(PanelPopup pp) {
        this.pnlFamilyList = pp;
    }
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
    }
    private HtmlSelectBooleanCheckbox choRequestbyHours = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoRequestbyHours() {
        return choRequestbyHours;
    }

    public void setChoRequestbyHours(HtmlSelectBooleanCheckbox hsbc) {
        this.choRequestbyHours = hsbc;
    }
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private HtmlSelectOneMenu drlLeaveType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLeaveType() {
        return drlLeaveType;
    }

    public void setDrlLeaveType(HtmlSelectOneMenu hsom) {
        this.drlLeaveType = hsom;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems4 = dsia;
    }
    private HtmlSelectOneRadio radEmployeeType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadEmployeeType() {
        return radEmployeeType;
    }

    public void setRadEmployeeType(HtmlSelectOneRadio hsor) {
        this.radEmployeeType = hsor;
    }
    private DefaultSelectedData selectOneRadio2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio2Bean() {
        return selectOneRadio2Bean;
    }

    public void setSelectOneRadio2Bean(DefaultSelectedData dsd) {
        this.selectOneRadio2Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio2DefaultItems() {
        return selectOneRadio2DefaultItems;
    }

    public void setSelectOneRadio2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio2DefaultItems = dsi;
    }
    private HtmlSelectOneRadio radWorkIn = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadWorkIn() {
        return radWorkIn;
    }

    public void setRadWorkIn(HtmlSelectOneRadio hsor) {
        this.radWorkIn = hsor;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calRequestDate = new SelectInputDate();

    public SelectInputDate getCalRequestDate() {
        return calRequestDate;
    }

    public void setCalRequestDate(SelectInputDate sid) {
        this.calRequestDate = sid;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlSelectBooleanCheckbox cboFamilyStatus = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboFamilyStatus() {
        return cboFamilyStatus;
    }

    public void setCboFamilyStatus(HtmlSelectBooleanCheckbox hsbc) {
        this.cboFamilyStatus = hsbc;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private DefaultSelectedData defaultSelectedData14 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData14() {
        return defaultSelectedData14;
    }

    public void setDefaultSelectedData14(DefaultSelectedData dsd) {
        this.defaultSelectedData14 = dsd;
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
    private DefaultSelectedData defaultSelectedData15 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData15() {
        return defaultSelectedData15;
    }

    public void setDefaultSelectedData15(DefaultSelectedData dsd) {
        this.defaultSelectedData15 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private DefaultSelectedData defaultSelectedData16 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData16() {
        return defaultSelectedData16;
    }

    public void setDefaultSelectedData16(DefaultSelectedData dsd) {
        this.defaultSelectedData16 = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems1() {
        return selectOneMenu3DefaultItems1;
    }

    public void setSelectOneMenu3DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems2() {
        return selectOneMenu3DefaultItems2;
    }

    public void setSelectOneMenu3DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems3() {
        return selectOneMenu3DefaultItems3;
    }

    public void setSelectOneMenu3DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems3 = dsia;
    }
    private DefaultSelectedData defaultSelectedData17 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData17() {
        return defaultSelectedData17;
    }

    public void setDefaultSelectedData17(DefaultSelectedData dsd) {
        this.defaultSelectedData17 = dsd;
    }
    private DefaultSelectionItems selectOneMenu4DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu4DefaultItems1() {
        return selectOneMenu4DefaultItems1;
    }

    public void setSelectOneMenu4DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu4DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu4DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu4DefaultItems2() {
        return selectOneMenu4DefaultItems2;
    }

    public void setSelectOneMenu4DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu4DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu4DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu4DefaultItems3() {
        return selectOneMenu4DefaultItems3;
    }

    public void setSelectOneMenu4DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu4DefaultItems3 = dsia;
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
    private HtmlSelectOneMenu drlZoneOrCity = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZoneOrCity() {
        return drlZoneOrCity;
    }

    public void setDrlZoneOrCity(HtmlSelectOneMenu hsom) {
        this.drlZoneOrCity = hsom;
    }
    private HtmlSelectOneMenu drlKabele = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlKabele() {
        return drlKabele;
    }

    public void setDrlKabele(HtmlSelectOneMenu hsom) {
        this.drlKabele = hsom;
    }
    private HtmlInputText txtHouseNumber = new HtmlInputText();

    public HtmlInputText getTxtHouseNumber() {
        return txtHouseNumber;
    }

    public void setTxtHouseNumber(HtmlInputText hit) {
        this.txtHouseNumber = hit;
    }
    private PanelPopup pnlPopUpAttachment = new PanelPopup();

    public PanelPopup getPnlPopUpAttachment() {
        return pnlPopUpAttachment;
    }

    public void setPnlPopUpAttachment(PanelPopup pp) {
        this.pnlPopUpAttachment = pp;
    }
    private HtmlInputText txtTelephoneMoblie = new HtmlInputText();

    public HtmlInputText getTxtTelephoneMoblie() {
        return txtTelephoneMoblie;
    }

    public void setTxtTelephoneMoblie(HtmlInputText hit) {
        this.txtTelephoneMoblie = hit;
    }
    private HtmlInputText txtlblTelephoneHome = new HtmlInputText();

    public HtmlInputText getTxtlblTelephoneHome() {
        return txtlblTelephoneHome;
    }

    public void setTxtlblTelephoneHome(HtmlInputText hit) {
        this.txtlblTelephoneHome = hit;
    }
    private HtmlOutputText lblErrorMessage = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessage() {
        return lblErrorMessage;
    }

    public void setLblErrorMessage(HtmlOutputText hot) {
        this.lblErrorMessage = hot;
    }
    private DefaultTableDataModel dataTable3Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable3Model() {
        return dataTable3Model;
    }

    public void setDataTable3Model(DefaultTableDataModel dtdm) {
        this.dataTable3Model = dtdm;
    }
    private PanelLayout pnlLayoutTimePanel = new PanelLayout();

    public PanelLayout getPnlLayoutTimePanel() {
        return pnlLayoutTimePanel;
    }

    public void setPnlLayoutTimePanel(PanelLayout pl) {
        this.pnlLayoutTimePanel = pl;
    }
    private HtmlCommandButton btnTime = new HtmlCommandButton();

    public HtmlCommandButton getBtnTime() {
        return btnTime;
    }

    public void setBtnTime(HtmlCommandButton hcb) {
        this.btnTime = hcb;
    }
    private HtmlOutputText lblLeaveDays = new HtmlOutputText();

    public HtmlOutputText getLblLeaveDays() {
        return lblLeaveDays;
    }

    public void setLblLeaveDays(HtmlOutputText hot) {
        this.lblLeaveDays = hot;
    }
    private HtmlOutputText lblCaptionReturnTime = new HtmlOutputText();

    public HtmlOutputText getLblCaptionReturnTime() {
        return lblCaptionReturnTime;
    }

    public void setLblCaptionReturnTime(HtmlOutputText hot) {
        this.lblCaptionReturnTime = hot;
    }
    private HtmlOutputText lblReturnDate = new HtmlOutputText();

    public HtmlOutputText getLblReturnDate() {
        return lblReturnDate;
    }

    public void setLblReturnDate(HtmlOutputText hot) {
        this.lblReturnDate = hot;
    }
    private DefaultSelectedData defaultSelectedData18 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData18() {
        return defaultSelectedData18;
    }

    public void setDefaultSelectedData18(DefaultSelectedData dsd) {
        this.defaultSelectedData18 = dsd;
    }
    private HtmlSelectBooleanCheckbox choHafeDay = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoHafeDay() {
        return choHafeDay;
    }

    public void setChoHafeDay(HtmlSelectBooleanCheckbox hsbc) {
        this.choHafeDay = hsbc;
    }
    private DefaultSelectedData defaultSelectedData19 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData19() {
        return defaultSelectedData19;
    }

    public void setDefaultSelectedData19(DefaultSelectedData dsd) {
        this.defaultSelectedData19 = dsd;
    }
    private DefaultSelectedData defaultSelectedData20 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData20() {
        return defaultSelectedData20;
    }

    public void setDefaultSelectedData20(DefaultSelectedData dsd) {
        this.defaultSelectedData20 = dsd;
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
    private HtmlSelectBooleanCheckbox choOffice = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoOffice() {
        return choOffice;
    }

    public void setChoOffice(HtmlSelectBooleanCheckbox hsbc) {
        this.choOffice = hsbc;
    }
    private HtmlSelectBooleanCheckbox choShift = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoShift() {
        return choShift;
    }

    public void setChoShift(HtmlSelectBooleanCheckbox hsbc) {
        this.choShift = hsbc;
    }
    private HtmlSelectBooleanCheckbox choAddisAbeba = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoAddisAbeba() {
        return choAddisAbeba;
    }

    public void setChoAddisAbeba(HtmlSelectBooleanCheckbox hsbc) {
        this.choAddisAbeba = hsbc;
    }
    private HtmlSelectBooleanCheckbox choMugher = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMugher() {
        return choMugher;
    }

    public void setChoMugher(HtmlSelectBooleanCheckbox hsbc) {
        this.choMugher = hsbc;
    }
    private HtmlOutputText txtExternalServiceYear = new HtmlOutputText();

    public HtmlOutputText getTxtExternalServiceYear() {
        return txtExternalServiceYear;
    }

    public void setTxtExternalServiceYear(HtmlOutputText hot) {
        this.txtExternalServiceYear = hot;
    }
    private HtmlOutputText lblAnualAvailableLeaveDays = new HtmlOutputText();

    public HtmlOutputText getLblAnualAvailableLeaveDays() {
        return lblAnualAvailableLeaveDays;
    }

    public void setLblAnualAvailableLeaveDays(HtmlOutputText hot) {
        this.lblAnualAvailableLeaveDays = hot;
    }
    private HtmlOutputText lblAvailableAnnualLeave = new HtmlOutputText();

    public HtmlOutputText getLblAvailableAnnualLeave() {
        return lblAvailableAnnualLeave;
    }

    public void setLblAvailableAnnualLeave(HtmlOutputText hot) {
        this.lblAvailableAnnualLeave = hot;
    }
    private HtmlOutputText txtReturnDateFromLeave = new HtmlOutputText();

    public HtmlOutputText getTxtReturnDateFromLeave() {
        return txtReturnDateFromLeave;
    }

    public void setTxtReturnDateFromLeave(HtmlOutputText hot) {
        this.txtReturnDateFromLeave = hot;
    }
    private HtmlCommandButton btnAddLeaveRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddLeaveRequest() {
        return btnAddLeaveRequest;
    }

    public void setBtnAddLeaveRequest(HtmlCommandButton hcb) {
        this.btnAddLeaveRequest = hcb;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     *
     */
    public LeaveRequestPage() {
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
    @Override
    public void init() {

        // Perform initializations inherited from our superclass
        clearLeaveInfoTextComponets();
        btnNew.setDisabled(true);
        colsEmployeeSearchByName.setExpanded(true);
        colsRequestLisrt.setExpanded(false);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        disableLeaveInfoTextComponents();
        disableComponets();
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnReset.setDisabled(true);
        btnSave.setDisabled(true);
        btnUpdate.setDisabled(true);
        txtAvilablDayes.setDisabled(true);
        loggedInUserId = getSessionBean1().getEmployeeId();

//
//        if (loggedInUserId != null) {
//            try {
//                String userId = leaveMnger.readUserID(loggedInUserId);
//
//                if (userId != null) {
//                    String ownerLists[] = leaveMnger.ReadOwnerGroupIDByUserID(userId);
//                    ownerGroupId = new int[ownerLists.length];
//                    for (int i = 0; i < ownerLists.length; i++) {
//                        ownerGroupId[i] = Integer.valueOf(ownerLists[i]);
//                    }
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
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

    public void enableLeaveInfoTextComponents() {
        this.txtDateFrom.setDisabled(false);
        //this.txtDateTo.setDisabled(false);
        // this.txtAvilablDayes.setDisabled(false);
        this.txtReason.setDisabled(false);
        this.txtLeaveDays.setDisabled(false);
        this.btnCalenderDateFrom.setDisabled(false);
        this.btnCalculateLeave.setDisabled(false);
        this.drlLeaveType.setDisabled(false);
        drlSelectWorkflow.setDisabled(false);
        txtDateFrom.setDisabled(false);
        btnTime.setRendered(false);
        btnCalenderDateFrom.setDisabled(false);
        btnCalculateLeave.setRendered(true);
        lblCaptionReturnTime.setRendered(false);
        lblReturnDate.setRendered(false);
        btnTime.setRendered(false);

    }

    public void disableLeaveInfoTextComponents() {
        this.txtDateFrom.setDisabled(true);
        // this.txtDateTo.setDisabled(true);
        // this.txtAvilablDayes.setDisabled(true);
        this.txtReason.setDisabled(true);
        this.txtLeaveDays.setDisabled(true);
        this.btnCalenderDateFrom.setDisabled(true);
        this.btnCalculateLeave.setDisabled(true);
        this.drlLeaveType.setDisabled(true);
    }

    public void populateLeaveInfo(String leaveId) {
        try {
            clearLeaveInfoTextComponets();
            HashMap leaveInfo = leaveRequestManager.readLeaveInformation(leaveId);
            this.drlLeaveType.setValue(leaveInfo.get("LEAVE_TYPE"));
            this.txtDateFrom.setValue(leaveInfo.get("REQUESTED_FROM_DATE"));
            this.txtDateTo.setValue(leaveInfo.get("REQUESTED_TO_DATE"));
            this.txtReason.setValue(leaveInfo.get("REQUESTING_REASON"));
            if (leaveInfo.get("LEAVE_TYPE").equals("1")) {//annual
                //txtAvilablDayes.setValue(leaveMnger.availableAnnualLeaveDays(txtEmployeeID.getValue().toString(), true));
            } else {
                HashMap list = new HashMap();
            //   list = leaveMnger.readParametersOfLeaveType(leaveInfo.get("LEAVE_TYPE").toString());
            //   txtAvilablDayes.setValue(list.get("max_Num_Of_Days"));
            }
            String leaveStatus = leaveInfo.get("LEAVE_TYPE").toString();
        // lblEmploymentStatus.setValue(leaveMnger.getLeaveTypeDescription(leaveInfo.get("STATUS").toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public void displayAvailableDays(String selectedEmployeeId, String selectedLeaveType) {

        String leaveTypeInfo[] = selectedLeaveType.split("=");



        if ((leaveTypeInfo[0].equals(LeaveTypeManager.MATERNITY_LEAVE) ||
                leaveTypeInfo[0].equals(LeaveTypeManager.PATERNITY_LEAVE) ||
                selectedLeaveType.equals("4")) && employeeManager.getSex().equalsIgnoreCase("Male")) {
            showSuccessOrFailureMessage(false, "Only women  can take maternity leave, " +
                    " prenatal leave and post natal leave");
            txtAvilablDayes.setValue("");

        } else if (leaveTypeInfo[0].equals(LeaveTypeManager.PATERNITY_LEAVE) &&
                employeeManager.getSex().equalsIgnoreCase("Female")) {
            showSuccessOrFailureMessage(false, "Women can't take paternal leave");
            txtAvilablDayes.setValue("");
        } else if (leaveTypeInfo[0].equals(LeaveTypeManager.ANUAL_LEAVE)) {//annual leave



            String anualLeaveDays = leaveRequestManager.readEmployeeAvailableAnualLeave(
                    txtEmployeeID.getValue().toString());
            if (!anualLeaveDays.equals("0")) {
                txtAvilablDayes.setValue(anualLeaveDays);
                lblAvailableAnnualLeave.setValue(
                        leaveRequestManager.readAnnualLeaveBalance(txtEmployeeID.getValue().toString()));
            } else {
                showSuccessOrFailureMessage(false, "You not hava registerd leave days." +
                        "you can not allowed to request annual leave. ");
            }
        } else if (leaveTypeInfo[0].equals(LeaveTypeManager.SICK_LEAVE)) {
            int usedLeave = leaveRequestManager.checkAvilbelLeaveDayes(txtEmployeeID.getValue().toString());
            int remaingDay = 0;
            if (usedLeave < 270) {
                remaingDay = 270 - usedLeave;
                txtAvilablDayes.setValue(remaingDay);
            } else {
                showSuccessOrFailureMessage(false, "he/she finished his/her sick Leave");
            }
//            Sick Leave
        } else if (leaveTypeInfo[0].equals(
                LeaveTypeManager.DEATH_OF_RELATIVE)) {
            int usedLeave = leaveRequestManager.checkDathOfRelative(
                    txtEmployeeID.getValue().toString());

            int remaingDay = 0;
            if (usedLeave < 7) {
                remaingDay = 7 - usedLeave;

                ArrayList<HashMap> listOfRelative =
                        employeeManager.readEmployeeRelativeForLeave(txtEmployeeID.getValue().toString());
                boolean checkStatus = false;
                boolean firstTimeFamily = false;
                getFamilyList().clear();

                for (HashMap hm : listOfRelative) {
                    checkStatus = (hm.get("ALIVE_OR_DIED").toString().equals("YES")) ? true : false;
                    if (checkStatus) {
                        getFamilyList().add(new EmployeeFamilyList(
                                hm.get("FIRST_NAME").toString() + "  " + hm.get("MIDDLE_NAME").toString() + "  " +
                                hm.get("LAST_NAME").toString(),
                                hm.get("RELATION").toString(),
                                false,
                                hm.get("ID").toString()));
                    }
                    firstTimeFamily = true;
                }
                if (firstTimeFamily) {

                    if (remaingDay > 3) {
                        txtAvilablDayes.setValue(3);
                    } else {
                        txtAvilablDayes.setValue(remaingDay);
                    }

                    pnlFamilyList.setRendered(true);
                } else {
                    showSuccessOrFailureMessage(false, "You have not registered Relative in the system.Please contact  Human Resource Officer ");
                    txtAvilablDayes.setValue("");
                }


            } else {
                showSuccessOrFailureMessage(false, "You are finished your death of relative Leave");
            }
//            Sick Leave
        } else if (leaveTypeInfo[0].equals(
                LeaveTypeManager.DEATH_OF_FAMILY)) {

            ArrayList<HashMap> readListOfFamily =
                    employeeManager.readEmployeeFamilyForLeave(txtEmployeeID.getValue().toString());
            boolean checkStatus = false;
            boolean firstTimeFamily = false;
            getFamilyList().clear();

            for (HashMap hm : readListOfFamily) {
                checkStatus = (hm.get("ALIVE_OR_DIED").toString().equals("YES")) ? true : false;
                if (checkStatus) {
                    getFamilyList().add(new EmployeeFamilyList(
                            hm.get("FIRST_NAME").toString() + "  " + hm.get("MIDDLE_NAME").toString() + "  " +
                            hm.get("LAST_NAME").toString(),
                            hm.get("RELATION").toString(),
                            false,
                            hm.get("ID").toString()));
                }
                firstTimeFamily = true;
            }
            if (firstTimeFamily) {
                txtAvilablDayes.setValue(leaveTypeInfo[1]);
                pnlFamilyList.setRendered(true);
            } else {
                showSuccessOrFailureMessage(false, "You have not registered family in the system.Please contact  Human Resource Officer");
                txtAvilablDayes.setValue("");
            }


        } //Marrage leave type allowed only one time
        else if (leaveTypeInfo[0].equals(LeaveTypeManager.LEAVE_TYPE_MARRIAGE)) {
            boolean cheke = leaveRequestManager.checkLeaveType(txtEmployeeID.getValue().toString(),
                    leaveTypeInfo[0]);
            if (!cheke) {
                txtAvilablDayes.setValue(leaveTypeInfo[1]);
            } else {
                showSuccessOrFailureMessage(false, "You're already taken marriage leave. " +
                        "Not allowed taken again  marriage leave. ");
            }

        } else if (leaveTypeInfo[0].equals(LeaveTypeManager.GETPASS_LEAVE_TYPE)) {
            boolean cheke = leaveRequestManager.checkLeaveGetPass(
                    txtEmployeeID.getValue().toString(),
                    leaveTypeInfo[0]);
            if (!cheke) {
                lblLeaveDays.setValue("Strat Time");
                txtAvilablDayes.setValue("2 Hours");
                txtDateFrom.setValue(jodanTimeCalender.currentForeignersDateFinder());
                txtDateFrom.setDisabled(true);
                btnTime.setRendered(true);
                txtLeaveDays.setDisabled(true);
                txtDateTo.setValue(jodanTimeCalender.currentForeignersDateFinder());
                btnCalenderDateFrom.setDisabled(true);
                btnCalculateLeave.setRendered(false);
                lblCaptionReturnTime.setRendered(true);
                lblReturnDate.setRendered(true);
                btnTime.setRendered(true);
                lblReturnDate.setRendered(true);
            } else {
                showSuccessOrFailureMessage(false, "You're already taken get pass leave by this month. ");
            }
        //other leave Type
        } else {
            txtAvilablDayes.setValue(leaveTypeInfo[1]);//list.get("max_Num_Of_Days"));
        }
    }

    public void drlLeaveType_processValueChange(ValueChangeEvent vce) {
        try {
            if (!CommonValidation.isUpdatePhase(vce)) {
                txtAvilablDayes.resetValue();
                txtDateFrom.resetValue();
                txtDateTo.resetValue();
                txtLeaveDays.resetValue();
                lblLeaveDays.setValue("Leave Days");
                txtReason.resetValue();
                txtReturnDateFromLeave.setValue(":");
                lblAvailableAnnualLeave.setValue(":");
                txtReturnDateFromLeave.setValue(":");
                if (vce.getNewValue() != null) {
                    txtAvilablDayes.resetValue();
                    displayAvailableDays(
                            txtEmployeeID.getValue().toString(),
                            vce.getNewValue().toString());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    boolean checkDataIsValid(boolean checkOnly) {
        boolean result = true;
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        if (!choAddisAbeba.isSelected() && !choMugher.isSelected()) {
            ((UIInput) choAddisAbeba).setValid(false);
            error(choAddisAbeba, errorMessage);
            result = false;
        }
        if (!choOffice.isSelected() && !choShift.isSelected()) {
            ((UIInput) choOffice).setValid(false);
            error(choOffice, errorMessage);
            result = false;
        }

        errorValue = HRValidation.validateData(this.txtAvilablDayes.getValue(), HRValidation.FLOAT_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtAvilablDayes).setValid(false);
                error(txtAvilablDayes, errorMessage);
            } else {
                ((UIInput) txtAvilablDayes).setValid(false);
                error(txtAvilablDayes, "Invalid Value");
            }
        }
        errorValue = HRValidation.validateData(this.txtDateFrom.getValue(), HRValidation.DATE_PATTERN2, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtDateFrom).setValid(false);
                error(txtDateFrom, errorMessage);
            } else {
                ((UIInput) txtDateFrom).setValid(false);
                error(txtDateFrom, "Invalid Value");
            }
        }
        if (!HRValidation.validateRequired(this.drlLeaveType.getValue())) {
            ((UIInput) txtLeaveDays).setValid(false);
            error(txtLeaveDays, errorMessage);
            result = false;
        }

        if (!HRValidation.validateRequired(this.txtEmployeeID.getValue())) {
            ((UIInput) txtEmployeeID).setValid(false);
            error(txtEmployeeID, errorMessage);
            result = false;
        }
        if (checkOnly) {
            errorValue = HRValidation.validateData(this.txtDateTo.getValue(), HRValidation.DATE_PATTERN2, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtDateTo).setValid(false);
                    error(txtDateTo, errorMessage);
                } else {
                    ((UIInput) txtDateTo).setValid(false);
                    error(txtDateTo, "Invalid Value");
                }
            }
            if (!HRValidation.validateRequired(this.txtReason.getValue())) {
                result = false;
                ((UIInput) txtReason).setValid(false);
                error(txtReason, errorMessage);
            }
        }

        return result;
    }

    boolean validateGetPass(boolean checkOnly) {
        boolean result = true;
        boolean required;
        String errorMessage = "Required";
        int errorValue = 0;
        if (!choAddisAbeba.isSelected() && !choMugher.isSelected()) {
            ((UIInput) choAddisAbeba).setValid(false);
            error(choAddisAbeba, errorMessage);
            result = false;
        }
        if (!choOffice.isSelected() && !choShift.isSelected()) {
            ((UIInput) choOffice).setValid(false);
            error(choOffice, errorMessage);
            result = false;
        }

        if (!HRValidation.validateRequired(this.txtAvilablDayes.getValue())) {
            result = false;
            ((UIInput) txtAvilablDayes).setValid(false);
            error(txtAvilablDayes, errorMessage);

        }
        errorValue = HRValidation.validateData(this.txtDateFrom.getValue(), HRValidation.DATE_PATTERN2, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtDateFrom).setValid(false);
                error(txtDateFrom, errorMessage);
            } else {
                ((UIInput) txtDateFrom).setValid(false);
                error(txtDateFrom, "Invalid Value");
            }
        }
        if (!HRValidation.validateRequired(this.drlLeaveType.getValue())) {
            ((UIInput) txtLeaveDays).setValid(false);
            error(txtLeaveDays, errorMessage);
            result = false;
        }

        if (!HRValidation.validateRequired(this.txtEmployeeID.getValue())) {
            ((UIInput) txtEmployeeID).setValid(false);
            error(txtEmployeeID, errorMessage);
            result = false;
        }
        if (checkOnly) {
            errorValue = HRValidation.validateData(this.txtDateTo.getValue(), HRValidation.DATE_PATTERN2, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtDateTo).setValid(false);
                    error(txtDateTo, errorMessage);
                } else {
                    ((UIInput) txtDateTo).setValid(false);
                    error(txtDateTo, "Invalid Value");
                }
            }
            if (!HRValidation.validateRequired(this.txtReason.getValue())) {
                result = false;
                ((UIInput) txtReason).setValid(false);
                error(txtReason, errorMessage);
            }
        }
        return result;
    }

    boolean validatLeaveTypeAnddate() {
        String leveTypeDesc[] = drlLeaveType.getValue().toString().split("=");
        for (LeaveRequestManager leaveRequest_Manager : getLeaveRequestTable()) {
            if (leaveRequest_Manager.getLeaveType().equals(leveTypeDesc[0]) ||
                    leaveRequest_Manager.getFromDate().equals(txtDateFrom.getValue().toString())) {
                return false;
            }
        }
        return true;
    }

    public String btnCalculateLeave_action() throws Exception {
        String location = null;
        String working = null;
        if (choOffice.isSelected()) {
            working = "Office";
        } else if (choShift.isSelected()) {
            working = "Shift";
        }
        if (choAddisAbeba.isSelected()) {
            location = "AddisAbeba";
        } else if (choMugher.isSelected()) {
            location = "Mugher";
        }

        if (!choRequestbyHours.isSelected()) {
            if (txtAvilablDayes.getValue() == null || txtAvilablDayes.getValue().toString().equalsIgnoreCase("")) {
                showSuccessOrFailureMessage(false, "First select the leave type ");
            } else if (txtDateFrom.getValue() == null || txtDateFrom.getValue().toString().equalsIgnoreCase("")) {
                showSuccessOrFailureMessage(false, "Enter start date of leave ");
            } else if (!HRValidation.validateRequired(txtLeaveDays.getValue()) && !choHafeDay.isSelected()) {
                //  txtLeaveDays.getValue() == null || txtLeaveDays.getValue().toString().equalsIgnoreCase("")) {
                showSuccessOrFailureMessage(false, "Enter the number of days to be taken");
                txtDateTo.setValue("");
            } else {//process calculating
                try {
                    if (!choHafeDay.isSelected()) {
                        if (checkDataIsValid(false)) {
                            if (leaveRequestManager.isLeaveDateValid(txtDateFrom.getValue().toString())) {
                                if (!leaveControl.isSundayInGerigorian(txtDateFrom.getValue().toString(), location, working)) {
                                    String leveTypeDesc[] = drlLeaveType.getValue().toString().split("=");
                                    float requestedLeaveAmount = Float.parseFloat(txtLeaveDays.getValue().toString());
                                    if (requestedLeaveAmount <= Float.parseFloat(txtAvilablDayes.getValue().toString())) {
                                        if (!choHafeDay.isSelected()) {
                                            if (leveTypeDesc[0].equals(LeaveTypeManager.ANUAL_LEAVE)) { //   //  drlLeaveType.getValue().equals("1")) {
                                                if (choShift.isSelected()) {
                                                    String endDate = leaveRequestManager.calculatLeaveDateForShifteWorker(
                                                            txtDateFrom.getValue().toString(),
                                                            txtLeaveDays.getValue().toString());
                                                    txtDateTo.setValue(endDate);
                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextShiftWorkingDay(endDate));
                                                } else if (choOffice.isSelected() && choMugher.isSelected()) {
                                                    if (!leaveControl.isSaturdayInGerigorian(txtDateFrom.getValue().toString())) {
                                                        String endDate = leaveRequestManager.calculatLeaveDateForBIBOfficeWorker(
                                                                txtDateFrom.getValue().toString(),
                                                                txtLeaveDays.getValue().toString());
                                                        txtDateTo.setValue(endDate);
                                                        String stare_Date = txtLeaveDays.getValue().toString();
                                                        int index = stare_Date.indexOf(".");
                                                        if (index > 0) {
                                                            txtReturnDateFromLeave.setValue(endDate);
                                                        } else {
                                                            txtReturnDateFromLeave.setValue(leaveRequestManager.nextMugherWorkingDay(endDate));
                                                        }
                                                    } else {
                                                        showSuccessOrFailureMessage(Boolean.FALSE, "Saturday is not working day please request in the working day ?");
                                                    }
                                                } else if (choOffice.isSelected() && choAddisAbeba.isSelected()) {

                                                    String endDate = "";
                                                    int index = txtLeaveDays.getValue().toString().indexOf(".");
                                                    if (index > 0) {
                                                        if (txtLeaveDays.getValue().toString().equals("0.5")) {
                                                            endDate = txtDateFrom.getValue().toString();
                                                        } else {
                                                            endDate = leaveRequestManager.calculatLeaveDateForAddisOfficeWorker(
                                                                    txtDateFrom.getValue().toString(),
                                                                    txtLeaveDays.getValue().toString());
                                                        }
                                                    } else {
                                                        endDate = leaveRequestManager.calculatForAddisOfficeWorker(
                                                                txtDateFrom.getValue().toString(),
                                                                txtLeaveDays.getValue().toString());
                                                        txtDateTo.setValue(endDate);
//
                                                    }

                                                    txtDateTo.setValue(endDate);



                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextAddisWorkingDay(endDate));
                                                }
                                            } else if (leveTypeDesc[0].equals(LeaveTypeManager.SICK_LEAVE)) {

                                                String leaveDay = txtLeaveDays.getValue().toString();
                                                int index = leaveDay.indexOf(".");
                                                if (index > 0) {
                                                    leaveDay = leaveDay.substring(0, index);
                                                }

//                                                String endDate = leaveRequestManager.calculateLeaveExcludeHolidays(
//                                                        txtDateFrom.getValue().toString(),
//                                                        leaveDay);
                                                String endDate = leaveRequestManager.calculateLeaveHolidays(
                                                        txtDateFrom.getValue().toString(),
                                                        leaveDay);




                                                txtDateTo.setValue(endDate);
                                                if (choOffice.isSelected() && choAddisAbeba.isSelected()) {
                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextAddisWorkingDay(endDate));
                                                } else if (choShift.isSelected()) {
                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextShiftWorkingDay(endDate));
                                                } else if (choOffice.isSelected() && choMugher.isSelected()) {
                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextMugherWorkingDay(endDate));
                                                }
                                            } else {
                                                String endDate = leaveRequestManager.calculateLeaveIncludeHolidays(
                                                        txtDateFrom.getValue().toString(),
                                                        txtLeaveDays.getValue().toString());
                                                txtDateTo.setValue(endDate);
                                                if (choOffice.isSelected() && choAddisAbeba.isSelected()) {
                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextAddisWorkingDay(endDate));
                                                } else if (choShift.isSelected()) {
                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextShiftWorkingDay(endDate));
                                                } else if (choOffice.isSelected() && choMugher.isSelected()) {
                                                    txtReturnDateFromLeave.setValue(leaveRequestManager.nextMugherWorkingDay(endDate));
                                                }
                                            }
                                        } else {
                                            txtDateTo.setValue(txtDateFrom.getValue().toString());
                                            if (choOffice.isSelected() && choAddisAbeba.isSelected()) {
                                                txtReturnDateFromLeave.setValue(leaveRequestManager.nextAddisWorkingDay(txtDateFrom.getValue().toString()));
                                            } else if (choShift.isSelected()) {
                                                txtReturnDateFromLeave.setValue(leaveRequestManager.nextShiftWorkingDay(txtDateFrom.getValue().toString()));
                                            } else if (choOffice.isSelected() && choMugher.isSelected()) {
                                                txtReturnDateFromLeave.setValue(leaveRequestManager.nextMugherWorkingDay(txtDateFrom.getValue().toString()));
                                            }
                                        }
                                    } else {
                                        showSuccessOrFailureMessage(Boolean.FALSE, "Too large number.Please less number leave");
                                    }
                                } else {
                                    showSuccessOrFailureMessage(Boolean.FALSE, "SUNDAY is not working day please request in the working day ?");
                                }
                            } else {
                                showSuccessOrFailureMessage(Boolean.FALSE, " Leave start date is less than the current date .Please correct leave start date.");
                            }
                        }
                    } else if (choHafeDay.isSelected() && HRValidation.validateRequired(txtLeaveDays.getValue())) {
                        int leaveDayes = Integer.parseInt(txtLeaveDays.getValue().toString());
                        leaveDayes *= 2;
                        String leveTypeDesc[] = drlLeaveType.getValue().toString().split("=");
                        if (leveTypeDesc[0].equals(LeaveTypeManager.ANUAL_LEAVE)) { //   //  drlLeaveType.getValue().equals("1")) {
                            if (choShift.isSelected()) {
                                String endDate = leaveRequestManager.calculatLeaveDateForShifteWorker(
                                        txtDateFrom.getValue().toString(),
                                        Integer.toString(leaveDayes));
                                txtDateTo.setValue(endDate);
                            } else if (choOffice.isSelected() && choMugher.isSelected()) {

                                if (!leaveControl.isSaturdayInGerigorian(txtDateFrom.getValue().toString())) {
                                    String endDate = leaveRequestManager.calculatLeaveDateForBIBOfficeWorker(
                                            txtDateFrom.getValue().toString(),
                                            Integer.toString(leaveDayes));
                                    txtDateTo.setValue(endDate);
                                } else {
                                    showSuccessOrFailureMessage(Boolean.FALSE, "SATURDAY is not working day please request in the working day ?");
                                }

                            } else if (choOffice.isSelected() && choAddisAbeba.isSelected()) {
                                String endDate = leaveRequestManager.calculatLeaveDateForAddisOfficeWorker(
                                        txtDateFrom.getValue().toString(),
                                        Integer.toString(leaveDayes));
                                txtDateTo.setValue(endDate);
                            }

                        } else {
                            showSuccessOrFailureMessage(Boolean.FALSE, "Leave type not compatable with leave! ");
                        }

                    } else {
                        int leaveDayes = 1;
                        String leveTypeDesc[] = drlLeaveType.getValue().toString().split("=");
                        if (leveTypeDesc[0].equals(LeaveTypeManager.ANUAL_LEAVE)) { //   //  drlLeaveType.getValue().equals("1")) {
                            if (choShift.isSelected()) {
                                String endDate = leaveRequestManager.calculatLeaveDateForShifteWorker(
                                        txtDateFrom.getValue().toString(),
                                        Integer.toString(leaveDayes));
                                txtDateTo.setValue(endDate);
                            } else if (choOffice.isSelected() && choMugher.isSelected()) {

                                if (!leaveControl.isSaturdayInGerigorian(txtDateFrom.getValue().toString())) {
                                    String endDate = leaveRequestManager.calculatLeaveDateForBIBOfficeWorker(
                                            txtDateFrom.getValue().toString(),
                                            Integer.toString(leaveDayes));
                                    txtDateTo.setValue(endDate);
                                } else {
                                    showSuccessOrFailureMessage(Boolean.FALSE, "SATURDAY is not working day please request in the working day ?");
                                }

                            } else if (choOffice.isSelected() && choAddisAbeba.isSelected()) {
                                String endDate = leaveRequestManager.calculatLeaveDateForAddisOfficeWorker(
                                        txtDateFrom.getValue().toString(),
                                        Integer.toString(leaveDayes));
                                txtDateTo.setValue(endDate);
                            }
                        } else {
                            showSuccessOrFailureMessage(Boolean.FALSE, "Leave type not compatable with leave! ");
                        }
                    }

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    ErrorLogWriter.writeError(ex);
                    showSuccessOrFailureMessage(false, "You inserted invalid number or" +
                            " available leave day value displays  <b>N/A</b>  correct your inpurt " + ex.getMessage());
                }
            }
        } else {
            if (choOffice.isSelected() && choMugher.isSelected()) {
                if (!leaveControl.isSaturdayInGerigorian(txtDateFrom.getValue().toString())) {
                    if (Integer.parseInt(txtLeaveDays.getValue().toString()) <= 7 && Integer.parseInt(txtLeaveDays.getValue().toString()) >= 0) {
                        txtDateTo.setValue(txtDateFrom.getValue().toString());
                    } else {
                        showSuccessOrFailureMessage(Boolean.FALSE, "Please Enter Only Working Hour?");
                    }
                } else {
                    showSuccessOrFailureMessage(Boolean.FALSE, "SATURDAY is not working day please request in the working day ?");
                }
            } else {
                if (Integer.parseInt(txtLeaveDays.getValue().toString()) <= 7 && Integer.parseInt(txtLeaveDays.getValue().toString()) >= 0) {
                    txtDateTo.setValue(txtDateFrom.getValue().toString());
                } else {
                    showSuccessOrFailureMessage(Boolean.FALSE, "Please Enter Only Working Hour?");
                }
            }
        }
        return null;
    }

    public String btnNew_action() {
        if (txtEmployeeID == null) {
            showSuccessOrFailureMessage(false, "FIRST SELECT  EMPLOYEE  BY ID OR BY NAME");
        } else {
            try {
                if (leaveRequestManager.oldLeaverequest(txtEmployeeID.getValue().toString())) {
                    leaveID = null;
                    enableLeaveInfoTextComponents();
                    clearLeaveInfoTextComponets();
                    btnDelete.setDisabled(true);
                    btnEdit.setDisabled(true);
                    btnReset.setDisabled(false);
                    btnSave.setDisabled(false);
                    btnUpdate.setDisabled(true);
                    btnEmplyeeSearch.setDisabled(true);
                    btnNew.setDisabled(true);
                    btnAddLeaveRequest.setDisabled(false);
                } else {
                    showSuccessOrFailureMessage(false, "Please wait until your request gets a response!!!");
                }
            } catch (Exception ex) {
                ErrorLogWriter.writeError(ex);
                ex.printStackTrace();
            }
        }
        return null;
    }

    void disableComponets() {
        txtAvilablDayes.setDisabled(true);
        txtDateFrom.setDisabled(true);
        //txtDateTo.setDisabled(true);
        txtLeaveDays.setDisabled(true);
        drlLeaveType.setDisabled(true);
        txtReason.setDisabled(true);
        btnCalculateLeave.setDisabled(true);
        btnCalenderDateFrom.setDisabled(true);
        drlSelectWorkflow.setDisabled(true);

    }

    void clearLeaveInfoTextComponets() {
        txtAvilablDayes.resetValue();
        txtDateFrom.resetValue();
        txtDateTo.resetValue();
        txtLeaveDays.resetValue();
        drlLeaveType.setValue("0");
        lblLeaveDays.setValue("Leave Days");
        txtReason.resetValue();
        txtReturnDateFromLeave.setValue(":");
        lblAvailableAnnualLeave.setValue(":");
        txtReturnDateFromLeave.setValue(":");

    }

    void clearForCancelation() {
        txtEmployeeID.resetValue();
        txtReason.resetValue();
        lblFull_Name.setValue("");
        lblDepartment.setValue("");
        lblPosition.setValue("");
        choMale.setSelected(false);
        choFemale.setSelected(false);
        lblServiceYear.setValue("");
        txtAvilablDayes.setValue("");
        txtDateTo.setValue("");
        txtDateFrom.setValue("");
        txtDateFrom.resetValue();
        txtLeaveDays.setValue("");
        drlLeaveType.setValue("0");
    }

    void clearPersonalInfoTextComponets() {
        txtEmployeeID.resetValue();
        txtEmployeeID.setValue(null);
    }

    public String btnSave_action() {
        if (saveLeaveRequest())
        {
            showSuccessOrFailureMessage(true, "Employee Leave Request Is " +
                    " Successfully Posted. And Need To Be Viewed By  Authorized Person.");
            btnDelete.setDisabled(true);
            btnEdit.setDisabled(false);
            countRequest = 0;
            btnReset.setDisabled(true);
            btnSave.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnEmplyeeSearch.setDisabled(false);
            btnNew.setDisabled(false);
            disableComponets();
            setRequestsLists(leaveRequestManager.selectLeaveRequests(txtEmployeeID.getValue().toString()));
        } else {
            showSuccessOrFailureMessage(false, "Error Occured While Posting Leve Request\n Please Try Again!");
        }
        return null;
    }

    private HashMap leaveRequestInformation() {
        String employeeId = null;
        String leaveType = null;
        String fiscalYear = null;
        String startTime = null;
        String endTime = null;
        String fromDate = null;
        String toDate = null;
        String leaveDays = null;
        String reason = null;
        String requestedLeaveType = null;
        String leaveTypee[] = drlLeaveType.getValue().toString().split("=");
        String currentDate = jodanTimeCalender.currentForeignersDateFinder();
        int kindLeave = 1;
        if (this.txtEmployeeID.getValue() != null) {
            employeeId = this.txtEmployeeID.getValue().toString().trim();
        }
        if (this.drlLeaveType.getValue() != null) {

            leaveType = leaveTypee[0];
        }
        if (this.txtDateFrom.getValue() != null) {
            fromDate = this.txtDateFrom.getValue().toString();
        }
        if (this.txtDateTo.getValue() != null) {
            toDate = this.txtDateTo.getValue().toString();
        }
        if (leaveTypee[0].equals(LeaveRequestManager.LEAVE_TYPE_GETPASS)) {
            if (this.txtLeaveDays.getValue() != null) {
                leaveDays = "2";
            }

            startTime = txtLeaveDays.getValue().toString();
            endTime = lblReturnDate.getValue().toString();

        } else if (choHafeDay.isSelected()) {
            leaveDays = "0.5";
        } else {
            if (this.txtLeaveDays.getValue() != null) {
                leaveDays = this.txtLeaveDays.getValue().toString();
            }
        }


        if (this.txtReason.getValue() != null) {
            reason = this.txtReason.getValue().toString();
        }
        if (choRequestbyHours.isSelected()) {
            kindLeave = 2;
        }

        HashMap requestInfo = new HashMap();
        requestInfo.put("employeeId", employeeId);
        requestInfo.put("leaveType", leaveType);
        requestInfo.put("fromDate", fromDate);
        requestInfo.put("toDate", toDate);
        requestInfo.put("reason", reason);
        requestInfo.put("currentDate", currentDate);
        requestInfo.put("leaveDays", leaveDays);
        requestInfo.put("kindOfLeave", kindLeave);
        requestInfo.put("leaveFromDesc", leaveFrom);
        requestInfo.put("leaveIdDesc", leaveFromId);
        requestInfo.put("LEAVEID", requestID);
        requestInfo.put("startTime", startTime);
        requestInfo.put("endTime", endTime);

        return requestInfo;
    }

    public HashMap checkReserveLeave() {
        HashMap readPhsicalYear = new HashMap();
        readPhsicalYear.clear();
        listOfReserveId.clear();
       // float reserveLeaveQuantity = leaveRequestManager.countReserveLeave(employeeId);
         float reserveLeaveQuantity = 0;
        int leaveCalculation = 0;
        int leaveRequsNumber = 0;
        int lastLeaveUsed = 0;
        int leaveDay = 0;
        if (reserveLeaveQuantity > 0) {
            if (txtLeaveDays.getValue() != null) {
                leaveDay = Integer.parseInt(txtLeaveDays.getValue().toString());
                leaveRequsNumber = leaveDay;
                if (leaveDay <= reserveLeaveQuantity) {
                    for (HashMap hm : leaveRequestManager.readReserveLeave(employeeId)) {
                        leaveDay -= Integer.parseInt(hm.get("availableleavenumber").toString());
                        leaveCalculation += Integer.parseInt(hm.get("availableleavenumber").toString());
                        lastLeaveUsed = Integer.parseInt(hm.get("availableleavenumber").toString());
                        if (leaveDay > 0) {
                            readPhsicalYear.put(hm.get("leaveyear").toString(), hm.get("availableleavenumber").toString());
                            listOfReserveId.put(hm.get("reservelaveid").toString(), "Delete");
                        } else {
                            leaveDay *= -1;
                            lastLeaveUsed -= leaveDay;
                            readPhsicalYear.put(hm.get("leaveyear").toString(), Integer.toString(lastLeaveUsed));
                            listOfReserveId.put(hm.get("reservelaveid").toString(), "Update" + Integer.toString(leaveDay));
//                            listOfReserveId.put(hm.get("reservelaveid").toString(), Integer.toString(leaveDay));
                            return readPhsicalYear;
                        }
                    }
                    boolean first = true;
                    boolean firstTime = false;
                    int phsicalYear = 0;
                    int physicalYearBYHour = 0;
                    int takenHouer = 0;
                    int totalLeavesDaysTakenByHour = 0;
                    int totalLeavesDaysTaken = 0;
                    int calculationHour = 0;
                    int yearOfAllowed = 0;
                    int alowedYear = 0;
                    int diffrenceBntToday = 0;
                    int diffrence = 0;
                    String hireDate = DateConverter.fromGCToEC(employeeManager.readHireDate(txtEmployeeID.getValue().toString()));
                    int year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
                    ArrayList<HashMap> leavesTakenList = leaveRequestManager.selectAnnualLeavesTaken(txtEmployeeID.getValue().toString());
                    ArrayList<HashMap> hourTakenList = leaveRequestManager.selectAnnualLeavesTakenByHour(txtEmployeeID.getValue().toString());
                    for (HashMap hm : leavesTakenList) {
                        phsicalYear = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
                        totalLeavesDaysTaken += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
                    }
                    for (HashMap hm : hourTakenList) {
                        physicalYearBYHour = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
                        totalLeavesDaysTakenByHour += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
                    }
                    if (physicalYearBYHour == phsicalYear) {

                        if (phsicalYear > 0) {
                            diffrenceBntToday = year - phsicalYear;
                            if (diffrenceBntToday >= 3) {
                                phsicalYear = year - 2;
                                diffrenceBntToday = 3;
                                first = false;
                                firstTime = true;
                            } else {
                                diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                                diffrenceBntToday += 1;
                            }
                        } else {
                            phsicalYear = employeeManager.calculateEmpServiceYear(hireDate);
                            if (phsicalYear >= 3) {
                                phsicalYear = year - 2;
                                diffrenceBntToday = 3;
                                first = false;
                                firstTime = true;
                            } else {
                                first = false;
                                firstTime = false;
                                phsicalYear = year - phsicalYear;
                                diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                                diffrenceBntToday += 1;
                            }

                        }
                        diffrence = phsicalYear - StringDateManipulation.getYear(hireDate);
                        // diffrence += 1;
                        String dataDiffrence = Integer.toString(diffrence);
                        String allowedLeve = null;
                        int calculate = 0;
                        if (diffrence <= 17) {
                            for (HashMap hm : leaveRequestManager.allowedLeave()) {
                                allowedLeve = hm.get(dataDiffrence).toString();
                                yearOfAllowed = Integer.parseInt(allowedLeve);
                                break;
                            }
                        } else {
                            yearOfAllowed = 30;
                        }
                        if (first) {
                            calculationHour = totalLeavesDaysTaken % 8;
                            takenHouer = totalLeavesDaysTaken / 8;
                            calculate = yearOfAllowed - (totalLeavesDaysTaken + takenHouer);
                        } else {
                            calculate = yearOfAllowed;
                        }
                        alowedYear = calculate - Integer.parseInt(txtLeaveDays.getValue().toString());
                        int forProduction = -1;
                        int requestDayQuantitu = 0;
                        if (alowedYear < 0) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), calculate);
                            requestDayQuantitu = Integer.parseInt(txtLeaveDays.getValue().toString());
                            requestDayQuantitu -= calculate;
                            calculate = 0;
                            calculate -= requestDayQuantitu;
                            if (diffrence > 3) {
                                diffrence = 3;
                            }
                            year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
                            for (int i = 1; i <= diffrenceBntToday; i++) {
                                if (yearOfAllowed < 30) {
                                    forProduction = -1;
                                    forProduction *= calculate;
                                    phsicalYear += 1;
                                    yearOfAllowed += 1;
                                    if (year < phsicalYear) {
                                        break;
                                    } else if (calculate == 0) {
                                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                                        break;
                                    } else if (calculate > 0) {
                                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                                        break;
                                    } else if (forProduction < yearOfAllowed) {
                                        readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                                        break;
                                    } else {
                                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                                    }
                                    calculate += yearOfAllowed;
                                } else {
                                    if (firstTime) {
                                        calculate = 0;
                                        calculate -= requestDayQuantitu;
                                        firstTime = false;
                                    }
                                    if (calculate <= 0) {
                                        forProduction = -1;
                                        phsicalYear += 1;
                                        forProduction *= calculate;
                                        if (year < phsicalYear) {
                                            break;
                                        } else if (calculate == 0) {
                                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                                            break;
                                        } else if (calculate > 0) {
                                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                                            break;
                                        } else if (forProduction < yearOfAllowed) {
                                            readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                                            break;
                                        } else {
                                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                                        }
                                        calculate += yearOfAllowed;
                                    } else {
                                        calculate -= yearOfAllowed;
                                        phsicalYear += 1;
                                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                                        break;
                                    }
                                }
                            }
                        } else {
                            readPhsicalYear.put(Integer.toString(phsicalYear), Integer.parseInt(txtLeaveDays.getValue().toString()));
                        }
                        return readPhsicalYear;

                    } else if (physicalYearBYHour < phsicalYear) {

                        return null;
                    } else {

                        return null;
                    }
                }
            } else {
                return null;
            }
            return null;
        } else {
            return selectFisicalYearForHour();
        }
    }

    private ArrayList<HashMap> addSaturdayHalfInAnualLeave() {
        String maxEntry = null;
        ArrayList<HashMap> useleve = new ArrayList<HashMap>();
        ArrayList<HashMap> anualLeave = calculateEmployeeAnualLeave();
        for (HashMap hm : anualLeave) {
            if (maxEntry == null || hm.get("year").toString().compareTo(maxEntry) > 0) {
                maxEntry = hm.get("year").toString();
            }
        }
        for (HashMap hm : anualLeave) {
            HashMap list = new HashMap();
            if (hm.get("year").toString().equals(maxEntry)) {
//                list.put("uesedLeave", hm.get("year").toString());
//                list.put("oldLeaveAmount", );
//                list.put("id", hm.get("id").toString());
//                list.put("year", hm.get("year").toString());
//                list.put("leaveFrom", "anualLeave");
            }


        }
        return useleve;
    }

    private ArrayList<HashMap> calculateEmployeeHalfAnualLeave() {
        try {
            float requestLeave = Float.parseFloat("0.5");
            float availeLeave = 0.0f;
            float usedleave = 0.0f;
            float oldAmount = 0.0f;
            float leavereq = requestLeave;
            ArrayList<HashMap> useleve = new ArrayList<HashMap>();
            for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {
                HashMap list = new HashMap();
                availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                usedleave += availeLeave;
                leavereq -= availeLeave;
                if (leavereq >= 0) {
                    requestLeave -= availeLeave;
                    usedleave = availeLeave;
                } else {
                    usedleave = requestLeave;
                    requestLeave -= requestLeave;
                }
                oldAmount = Float.parseFloat(hm.get("usedleave").toString()) + usedleave;
                list.put("uesedLeave", Float.toString(usedleave));
                list.put("oldLeaveAmount", Float.toString(oldAmount));
                list.put("id", hm.get("id").toString());
                list.put("year", hm.get("year").toString());
                list.put("leaveFrom", "anualLeave");
                leaveFrom = leaveFrom + "--anualLeave";
                leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                useleve.add(list);
            }
            return useleve;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    private ArrayList<HashMap> calculateEmployeeAnualLeave()
               {
        try {
            usedYear = "";
            float requestLeave = Float.parseFloat(txtLeaveDays.getValue().toString());
            float availeLeave = 0;
            float usedleave = 0;
            float oldAmount = 0;
            float leavereq = requestLeave;
            ArrayList<HashMap> useleve = new ArrayList<HashMap>();
            float reserveLeaveQuantity = 0;
            // float reserveLeaveQuantity = leaveRequestManager.countReserveLeave(employeeId);
            if (reserveLeaveQuantity == 0 || (reserveLeaveQuantity < 1 && requestLeave > 1))
            {
                for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {

                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Float.parseFloat(hm.get("usedleave").toString()) + usedleave;
                    list.put("uesedLeave", Float.toString(usedleave));
                    list.put("oldLeaveAmount", Float.toString(oldAmount));
                    list.put("id", hm.get("id").toString());
                    list.put("year", hm.get("year").toString());
                    list.put("leaveFrom", "anualLeave");
                    leaveFrom = leaveFrom + "--anualLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                    usedYear += "[" + hm.get("year").toString() + "==>" + usedleave + "]";
                    useleve.add(list);
                }
                return useleve;
            } else if (reserveLeaveQuantity > requestLeave) {
                ArrayList<HashMap> listOfReserve = leaveRequestManager.readReserveLeave(employeeId);
                for (HashMap hm : listOfReserve) {
                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    if (usedleave > 0) {
                        oldAmount = Float.parseFloat(hm.get("USEDLEAVE").toString()) + usedleave;
                        list.put("uesedLeave", Float.toString(usedleave));
                        list.put("oldLeaveAmount", Float.toString(oldAmount));
                        list.put("id", hm.get("reservelaveid").toString());
                        list.put("year", hm.get("leaveyear").toString());
                        list.put("leaveFrom", "reserveLeave");
                        leaveFrom = leaveFrom + "--reserveLeave";
                        leaveFromId = leaveFromId + "--" + hm.get("reservelaveid").toString();
                        usedYear += "[" + hm.get("leaveyear").toString() + "==>" + usedleave + "]";
                        useleve.add(list);

                    } else {
                        if (usedYear == null) {
                            usedYear += "[" + hm.get("leaveyear").toString() + "==>" + usedleave + "]";
                        }
                        return useleve;
                    }

                }
                return useleve;
            } else {
                for (HashMap hm : leaveRequestManager.readReserveLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Float.parseFloat(hm.get("USEDLEAVE").toString()) + usedleave;
                    list.put("uesedLeave", Float.toString(usedleave));
                    list.put("oldLeaveAmount", Float.toString(oldAmount));
                    list.put("id", hm.get("reservelaveid").toString());
                    list.put("year", hm.get("leaveyear").toString());
                    list.put("leaveFrom", "reserveLeave");
                    leaveFrom = leaveFrom + "--reserveLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("reservelaveid").toString();
                    usedYear += "[" + hm.get("leaveyear").toString() + "==>" + usedleave + "]";
                    useleve.add(list);

                }
                for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Float.parseFloat(hm.get("usedleave").toString()) + usedleave;
                    list.put("uesedLeave", Float.toString(usedleave));
                    list.put("oldLeaveAmount", Float.toString(oldAmount));
                    list.put("id", hm.get("id").toString());
                    list.put("year", hm.get("year").toString());
                    list.put("leaveFrom", "anualLeave");
                    leaveFrom = leaveFrom + "--anualLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                    usedYear += "[" + hm.get("year").toString() + "==>" + usedleave + "]";
                    useleve.add(list);

                }
                return useleve;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    private ArrayList<HashMap> updateEmployeeAnualLeave() {
        try {

            ArrayList<HashMap> listOfRegisterLeave = leaveRequestManager.listOfEmployeeRegisterLeave(
                    Integer.toString(requestID));
            int requestLeave = Integer.parseInt(txtLeaveDays.getValue().toString());
            int availeLeave = 0;
            int usedleave = 0;
            int oldAmount = 0;
            int leavereq = requestLeave;
            ArrayList<HashMap> useleve = new ArrayList<HashMap>();
            float reserveLeaveQuantity = leaveRequestManager.countReserveLeave(employeeId);
            if (reserveLeaveQuantity == 0) {
                for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Integer.parseInt(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Integer.parseInt(hm.get("usedleave").toString()) + usedleave;
                    list.put("uesedLeave", Integer.toString(usedleave));
                    list.put("oldLeaveAmount", Integer.toString(oldAmount));
                    list.put("id", hm.get("id").toString());
                    list.put("year", hm.get("year").toString());
                    list.put("leaveFrom", "anualLeave");
                    leaveFrom = leaveFrom + "--anualLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                    useleve.add(list);
                }


                return useleve;

            } else if (reserveLeaveQuantity > requestLeave) {
                ArrayList<HashMap> listOfReserve = leaveRequestManager.readReserveLeave(employeeId);
                for (HashMap hm : listOfReserve) {
                    HashMap list = new HashMap();
                    availeLeave = Integer.parseInt(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }

                    if (usedleave > 0) {
                        oldAmount = Integer.parseInt(hm.get("USEDLEAVE").toString()) + usedleave;
                        list.put("uesedLeave", Integer.toString(usedleave));
                        list.put("oldLeaveAmount", Integer.toString(oldAmount));
                        list.put("id", hm.get("reservelaveid").toString());
                        list.put("year", hm.get("leaveyear").toString());
                        list.put("leaveFrom", "reserveLeave");
                        leaveFrom = leaveFrom + "--reserveLeave";
                        leaveFromId = leaveFromId + "--" + hm.get("reservelaveid").toString();
                        useleve.add(list);
                    } else {
                        return useleve;
                    }

                }
                return useleve;
            } else {
                for (HashMap hm : leaveRequestManager.readReserveLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Integer.parseInt(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Integer.parseInt(hm.get("USEDLEAVE").toString()) + usedleave;
                    list.put("uesedLeave", Integer.toString(usedleave));
                    list.put("oldLeaveAmount", Integer.toString(oldAmount));
                    list.put("id", hm.get("reservelaveid").toString());
                    list.put("year", hm.get("leaveyear").toString());
                    list.put("leaveFrom", "reserveLeave");
                    leaveFrom = leaveFrom + "--reserveLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("reservelaveid").toString();
                    useleve.add(list);
                }
                for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Integer.parseInt(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Integer.parseInt(hm.get("usedleave").toString()) + usedleave;
                    list.put("uesedLeave", Integer.toString(usedleave));
                    list.put("oldLeaveAmount", Integer.toString(oldAmount));
                    list.put("id", hm.get("id").toString());
                    list.put("year", hm.get("year").toString());
                    list.put("leaveFrom", "anualLeave");
                    leaveFrom = leaveFrom + "--anualLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                    useleve.add(list);
                }
                return useleve;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public HashMap selectFisicalYearForHour() {
        boolean first = true;
        boolean firstTime = false;
        HashMap readPhsicalYear = new HashMap();
        readPhsicalYear.clear();
        int phsicalYear = 0;
        int physicalYearBYHour = 0;
        int takenHouer = 0;
        int totalLeavesDaysTakenByHour = 0;
        int totalLeavesDaysTaken = 0;
        int calculationHour = 0;
        int yearOfAllowed = 0;
        int alowedYear = 0;
        int diffrenceBntToday = 0;
        int diffrence = 0;
        String hireDate = DateConverter.fromGCToEC(employeeManager.readHireDate(txtEmployeeID.getValue().toString()));
        int year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
        ArrayList<HashMap> leavesTakenList = leaveRequestManager.selectAnnualLeavesTaken(txtEmployeeID.getValue().toString());
        ArrayList<HashMap> hourTakenList = leaveRequestManager.selectAnnualLeavesTakenByHour(txtEmployeeID.getValue().toString());
        for (HashMap hm : leavesTakenList) {
            phsicalYear = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
            totalLeavesDaysTaken += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
        }
        for (HashMap hm : hourTakenList) {
            physicalYearBYHour = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
            totalLeavesDaysTakenByHour += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
        }
        if (physicalYearBYHour == phsicalYear) {

            if (phsicalYear > 0) {
                diffrenceBntToday = year - phsicalYear;
                if (diffrenceBntToday >= 3) {
                    phsicalYear = year - 2;
                    diffrenceBntToday = 3;
                    first = false;
                    firstTime = true;
                } else {
                    diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                    diffrenceBntToday += 1;
                }
            } else {
                phsicalYear = employeeManager.calculateEmpServiceYear(hireDate);
                if (phsicalYear >= 3) {
                    phsicalYear = year - 2;
                    diffrenceBntToday = 3;
                    first = false;
                    firstTime = true;
                } else {
                    first = false;
                    firstTime = false;
                    phsicalYear = year - phsicalYear;
                    diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                    diffrenceBntToday += 1;
                }

            }
            diffrence = phsicalYear - StringDateManipulation.getYear(hireDate);
            // diffrence += 1;
            String dataDiffrence = Integer.toString(diffrence);
            String allowedLeve = null;
            int calculate = 0;
            if (diffrence <= 17) {
                for (HashMap hm : leaveRequestManager.allowedLeave()) {
                    allowedLeve = hm.get(dataDiffrence).toString();
                    yearOfAllowed = Integer.parseInt(allowedLeve);
                    break;
                }
            } else {
                yearOfAllowed = 30;
            }
            if (first) {
                calculationHour = totalLeavesDaysTaken % 8;
                takenHouer = totalLeavesDaysTaken / 8;
                calculate = yearOfAllowed - (totalLeavesDaysTaken + takenHouer);
            } else {
                calculate = yearOfAllowed;
            }
            alowedYear = calculate - Integer.parseInt(txtLeaveDays.getValue().toString());
            int forProduction = -1;
            int requestDayQuantitu = 0;
            if (alowedYear < 0) {
                readPhsicalYear.put(Integer.toString(phsicalYear), calculate);
                requestDayQuantitu = Integer.parseInt(txtLeaveDays.getValue().toString());
                requestDayQuantitu -= calculate;
                calculate = 0;
                calculate -= requestDayQuantitu;
                if (diffrence > 3) {
                    diffrence = 3;
                }
                year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
                for (int i = 1; i <= diffrenceBntToday; i++) {
                    if (yearOfAllowed < 30) {
                        forProduction = -1;
                        forProduction *= calculate;
                        phsicalYear += 1;
                        yearOfAllowed += 1;
                        if (year < phsicalYear) {
                            break;
                        } else if (calculate == 0) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                            break;
                        } else if (calculate > 0) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                            break;
                        } else if (forProduction < yearOfAllowed) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                            break;
                        } else {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                        }
                        calculate += yearOfAllowed;
                    } else {
                        if (firstTime) {
                            calculate = 0;
                            calculate -= requestDayQuantitu;
                            firstTime = false;
                        }
                        if (calculate <= 0) {
                            forProduction = -1;
                            phsicalYear += 1;
                            forProduction *= calculate;
                            if (year < phsicalYear) {
                                break;
                            } else if (calculate == 0) {
                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                                break;
                            } else if (calculate > 0) {
                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                                break;
                            } else if (forProduction < yearOfAllowed) {
                                readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                                break;
                            } else {
                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                            }
                            calculate += yearOfAllowed;
                        } else {
                            calculate -= yearOfAllowed;
                            phsicalYear += 1;
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                            break;
                        }
                    }
                }
            } else {
                readPhsicalYear.put(Integer.toString(phsicalYear), Integer.parseInt(txtLeaveDays.getValue().toString()));
            }
            return readPhsicalYear;

        } else if (physicalYearBYHour < phsicalYear) {

            return null;
        } else {

            return null;
        }
    }

    public HashMap selectFisicalYearByHour(int from) {
        boolean first = true;
        boolean firstTime = false;
        HashMap readPhsicalYear = new HashMap();
        readPhsicalYear.clear();
        int phsicalYear = 0;
        int totalLeavesDaysTaken = 0;
        int yearOfAllowed = 0;
        int alowedYear = 0;
        int diffrenceBntToday = 0;
        int diffrence = 0;
        String hireDate = employeeManager.readHireDate(txtEmployeeID.getValue().toString());
        int year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
        ArrayList<HashMap> leavesTakenList = leaveRequestManager.selectAnnualLeavesTaken(txtEmployeeID.getValue().toString());
        for (HashMap hm : leavesTakenList) {//
            phsicalYear = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
            totalLeavesDaysTaken += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
        }
        if (phsicalYear > 0) {
            diffrenceBntToday = year - phsicalYear;
            if (diffrenceBntToday >= 3) {
                phsicalYear = year - 2;
                diffrenceBntToday = 3;
                first = false;
                firstTime = true;
            } else {
                diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                diffrenceBntToday += 1;
            }
        } else {
            phsicalYear = employeeManager.calculateEmpServiceYears(selectedId);
            if (phsicalYear >= 3) {
                phsicalYear = year - 2;
                diffrenceBntToday = 3;
                first = false;
                firstTime = true;
            } else {
                first = false;
                firstTime = false;
                phsicalYear = year - phsicalYear;
                diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                diffrenceBntToday += 1;
            }
        }
        diffrence = phsicalYear - StringDateManipulation.getYear(hireDate);
        diffrence += 1;
        String dataDiffrence = Integer.toString(diffrence);
        String allowedLeve = null;
        int calculate = 0;
        if (diffrence <= 11) {
            for (HashMap hm : leaveRequestManager.allowedLeave()) {
                allowedLeve = hm.get(dataDiffrence).toString();
                yearOfAllowed = Integer.parseInt(allowedLeve);
                break;
            }
        } else {
            yearOfAllowed = 30;
        }
        if (first) {
            calculate = yearOfAllowed - totalLeavesDaysTaken;
        } else {
            calculate = yearOfAllowed;
        }
        alowedYear = calculate - Integer.parseInt(txtLeaveDays.getValue().toString());       //    calculate = 0;
        int forProduction = -1;
        int requestDayQuantitu = 0;
        if (alowedYear < 0) {
            readPhsicalYear.put(Integer.toString(phsicalYear), calculate);
            requestDayQuantitu = Integer.parseInt(txtLeaveDays.getValue().toString());
            requestDayQuantitu -= calculate;
            calculate = 0;
            calculate -= requestDayQuantitu;
            if (diffrence > 3) {
                diffrence = 3;
            }
            year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
            for (int i = 1; i <= diffrenceBntToday; i++) {
                if (yearOfAllowed < 30) {
                    forProduction = -1;
                    forProduction *= calculate;
                    phsicalYear += 1;
                    yearOfAllowed += 1;
                    if (year < phsicalYear) {
                        break;
                    } else if (calculate == 0) {
                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                        break;
                    } else if (calculate > 0) {
                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                        break;
                    } else if (forProduction < yearOfAllowed) {
                        readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                        break;
                    } else {
                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                    }
                    calculate += yearOfAllowed;
                } else {
                    if (firstTime) {
                        calculate = 0;
                        calculate -= requestDayQuantitu;
                        firstTime = false;
                    }
                    if (calculate <= 0) {
                        forProduction = -1;
                        phsicalYear += 1;
                        forProduction *= calculate;
                        if (year < phsicalYear) {
                            break;
                        } else if (calculate == 0) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                            break;
                        } else if (calculate > 0) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                            break;
                        } else if (forProduction < yearOfAllowed) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                            break;
                        } else {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                        }
                        calculate += yearOfAllowed;
                    } else {
                        calculate -= yearOfAllowed;
                        phsicalYear += 1;
                        readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                        break;
                    }
                }
            }
        } else {
            readPhsicalYear.put(Integer.toString(phsicalYear), Integer.parseInt(txtLeaveDays.getValue().toString()) + "12345697");
        }
        return readPhsicalYear;
    }

    private boolean saveLeaveRequest()
    {
        boolean flag = false;
        int chkSave = 0;
        try {

            try {
                List employeeLeaveRequest = this.getLeaveRequestTable();
                //.subList((requestTableSize), (requestTableSize + countRequest));
                Iterator<LeaveRequestManager> iter = employeeLeaveRequest.iterator();
                while (iter.hasNext())
                {
                    LeaveRequestManager saveEmployeeLeaveRequest = iter.next();
                    chkSave = leaveRequestManager.saveEmployeeLeaveRequest(saveEmployeeLeaveRequest,getSessionBean1().getEmployeeId());
                }
                if (chkSave > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean updateLeaveRequest() {
        boolean flag = false;
        int chkSave = 0;
        try {
            String leaveTypeId[] = drlLeaveType.getValue().toString().split("=");
            String returnDate = "";
            if (checkDataIsValid(true)) {
                if (leaveRequestManager.updateEmployeeAnualLeave(leaveRequestId)) {
                    employeeId = txtEmployeeID.getValue().toString();
                    String leveTypeDesc[] = drlLeaveType.getValue().toString().split("=");
                    if (leveTypeDesc[0].equals(LeaveRequestManager.LEAVE_TYPE_ANNUALLEAVE)) {
                        pnlPopUpAttachment.setRendered(true);
                        HashMap liveTimeAddress = employeeManager.readEmployeeLeaveTimeAddrss(employeeId);
                        if (liveTimeAddress != null) {
                            drlRegion.setValue(liveTimeAddress.get("REGION_ID").toString());
                            zoneList = lookUpManager.readZoneOrCityInARegion(liveTimeAddress.get("REGION_ID").toString());
                            drlZoneOrCity.setValue(liveTimeAddress.get("WOREDA_OR_SUBCITY_ID").toString());
                            woredaList = lookUpManager.readWoredaAndZone(liveTimeAddress.get("WOREDA_OR_SUBCITY_ID").toString());
                            drlWoreda.setValue(liveTimeAddress.get("WOREDA_OR_SUBCITY").toString());
                            kebeleList = lookUpManager.readKebelleInSubCity(liveTimeAddress.get("WOREDA_OR_SUBCITY").toString());
                            drlKabele.setValue(liveTimeAddress.get("KEBELE").toString());
                            txtHouseNumber.setValue(liveTimeAddress.get("HOUSE_NUMBER").toString());
                            txtlblTelephoneHome.setValue(liveTimeAddress.get("TELEPHONE_RESIDENCE").toString());
                            txtTelephoneMoblie.setValue(liveTimeAddress.get("MOBILE").toString());
                            employeLeaveTypeAddress = liveTimeAddress.get("ID").toString();
                        } else {
                            employeLeaveTypeAddress = null;
                        }
                        if (txtReturnDateFromLeave.getValue() != null) {
                            returnDate = txtReturnDateFromLeave.getValue().toString();
                        } else {
                            returnDate = txtDateTo.getValue().toString();
                        }

                        LeaveRequestManager updateAnnualLeaveRequest = new LeaveRequestManager(
                                txtReason.getValue().toString(),
                                txtAvilablDayes.getValue().toString(),
                                txtDateFrom.getValue().toString(),
                                txtDateTo.getValue().toString(),
                                txtLeaveDays.getValue().toString(),
                                leaveTypeId[0],
                                calculateEmployeeAnualLeave(),
                                leaveRequestInformation(),
                                leaveTypeId[2],
                                usedYear,
                                returnDate);
                        return leaveRequestManager.updateEmployeeAnnualLeaveRequest(updateAnnualLeaveRequest);
                    } else {
                        if (txtReturnDateFromLeave.getValue() != null) {
                            returnDate = txtReturnDateFromLeave.getValue().toString();
                        } else {
                            returnDate = txtDateTo.getValue().toString();
                        }
                        LeaveRequestManager updateLeaveRequest = new LeaveRequestManager(
                                leaveRequestInformation(),
                                getListOfFamilyPassedAwaye(),
                                leaveTypeId[2],
                                returnDate);
                        return leaveRequestManager.updateEmployeeLeaveRequest(updateLeaveRequest);

                    }
                } else {
                    if (txtReturnDateFromLeave.getValue() != null) {
                        returnDate = txtReturnDateFromLeave.getValue().toString();
                    } else {
                        returnDate = txtDateTo.getValue().toString();
                    }
                    LeaveRequestManager updateLeaveRequest = new LeaveRequestManager(
                            leaveRequestInformation(),
                            getListOfFamilyPassedAwaye(),
                            leaveTypeId[2],
                            returnDate);
                    return leaveRequestManager.updateEmployeeLeaveRequest(updateLeaveRequest);
                }

            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void selectRequestLists_processValueChange(ValueChangeEvent vce) {
        btnEdit.setDisabled(false);
        btnSave.setDisabled(true);
        btnNew.setDisabled(true);
        btnEdit.setDisabled(false);
        btnDelete.setDisabled(false);
        if (vce != null) {
            leaveID = vce.getNewValue().toString();
            populateLeaveInfo(leaveID);
        }
    }

    public String btnEdit_action() {
        enableLeaveInfoTextComponents();
        btnUpdate.setDisabled(false);
        btnEdit.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public boolean updateLeaveInfo() {
        return true;
    }

    public String btnUpdate_action() {
        if (txtAvilablDayes.getValue() == null || txtAvilablDayes.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(false, "Error Occured : Please check AvilablDayes and try Again ?");
        } else if (updateLeaveRequest()) {
            showSuccessOrFailureMessage(true, "Employee Leve Request Is Successfully Updated.And Need To Be Viewed By  Authorized Person.");
            disableComponets();
            btnUpdate.setDisabled(true);
            selectOneListbox1Bean.setSelectedObject(null);
        } else {
            showSuccessOrFailureMessage(false, "Error Occured While Updating Request.Please Try Again!");
        }
        setRequestsLists(leaveRequestManager.selectLeaveRequests(txtEmployeeID.getValue().toString()));
        return null;
    }

    public String btnDelete_action() {

        lblFormDeleteMessage.setValue("ARE YOU SURE YOU WANT TO DELETE LEAVE REQUEST OF " + lblFull_Name.getValue().toString() + "");
        pnConfirmationForDelete.setRendered(true);

        //return null means stay on the same page
        return null;
    }

    public void txtDateFrom_validate(FacesContext context, UIComponent component, Object value) {
        if (StringDateManipulation.compareDate(txtDateFrom.getValue().toString(), employeeManager.getHireDate()) == -1) {
            ((UIInput) component).setValid(false);
        }
    }
    PanelPopup panelPopup;

    public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {
        //validateParameters(facesContext, uiComponent, AGSContext.class);
//        if (isStatic(uiComponent)) {
//            return;
//        }
        DOMContext domContext = DOMContext.attachDOMContext(facesContext, uiComponent);
        if (!domContext.isInitialized()) {
            Element container = domContext.createRootElement(HTML.DIV_ELEM);
            if (panelPopup == null) {
                panelPopup = new PanelPopup();
                panelPopup.setParent(uiComponent);
                panelPopup.setDraggable("true");
                panelPopup.setAutoCentre(true);
                panelPopup.setRendered(true);
                panelPopup.setResizable(true);
                panelPopup.setStyle("z-index: 1000;top:269px;left:482px;position: absolute; width: 300px; height: 150px;");
                panelPopup.setTitle("title");
                panelPopup.setVisible(true);
            }
            HtmlOutputText titleComp = new HtmlOutputText();
            titleComp.setStyle("z-index:2000;");
            titleComp.setStyleClass("popupTitle");
            titleComp.setValue("The Title");

            panelPopup.getFacets().put("header", titleComp);

            HtmlPanelGrid bodyPanelGrid = new HtmlPanelGrid();
            bodyPanelGrid.setColumns(1);
            bodyPanelGrid.setStyle("z-index:2002;");
            bodyPanelGrid.setWidth("100%");
            bodyPanelGrid.setStyleClass("popupModalBody");

            HtmlOutputText bodyComp = new HtmlOutputText();
            bodyComp.setStyle("z-index:2001;");
            bodyComp.setValue("The Body");
            bodyPanelGrid.getChildren().add(bodyComp);
            panelPopup.getFacets().put("body", bodyPanelGrid);

            Node lastCursorParent = domContext.getCursorParent();
            domContext.setCursorParent(container);
            try {
                panelPopup.encodeBegin(facesContext);
                panelPopup.encodeChildren(facesContext);
                panelPopup.encodeEnd(facesContext);
            } catch (IOException e) {
                e.printStackTrace();
            }
            domContext.setCursorParent(lastCursorParent);
        }
        domContext.stepOver();
    }

    /**
     * @return a localized String from properties file for the current locale
     * locale can be for example new java.util.Locale("am", "ET")
     * propertyFile is the property file name
     * @param propertyFileName :propertyFileName of <br>"propertyFileName.properties" is <b>Localization.HRLocalization</b>
     * @param message : the variable in demand from the property file
     */
    public String getLocalizedMessage(String message, String propertyFileName) throws Exception {
        try {
            java.util.Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle(propertyFileName, locale);
            return rb.getString(message);
        } catch (MissingResourceException ex) {
            return "??" + message + "??";
        }
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

    public static String getWeekDayName(String date) {
        String[] weekdays = {"????", " ??", "????", "???", "????", "???", "???"};
        java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
        // convert EC to GC for manipulation
        //first create a method which convert EC to GC
        calendar.set(StringDateManipulation.getYear(date), StringDateManipulation.getMonth(date), StringDateManipulation.getDate(date));
        String dateName = weekdays[calendar.get(java.util.Calendar.DAY_OF_WEEK) - 1];
        return dateName;
    }

    public String btnReset_action() {
        disableComponets();
        clearForCancelation();
        selectOneListbox1Bean.setSelectedObject(null);
        txtEmployeeID.setValue("");
        txtEmployeeID.setDisabled(false);
        btnEmplyeeSearch.setDisabled(false);
        enableLeaveInfoTextComponents();
        //return null means stay on the same page
        return null;
    }


    ///////////////////////////////////////////////Serach By Employee name ///////////////////////////////////////////////
    public void updateList(ValueChangeEvent event) {
        try {
            // get a new list of matches.
            setMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete1 = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete1.getSelectedItem() != null) {
                    currentEmployee1 = (EmployeeList) autoComplete1.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee1.getEmpIdentification());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempData = getMatch(autoComplete1.getValue().toString());
                    if (tempData != null) {
                        currentEmployee1 = tempData;
                    }

                }
            }
        } catch (Exception ex) {
        }
    }

    private EmployeeList getMatch(String value) {
        EmployeeList result = null;
        if (matchesList != null) {
            SelectItem si;
            Iterator iter = matchesList.iterator();
            while (iter.hasNext()) {
                si = (SelectItem) iter.next();
                if (value.equals(si.getLabel())) {
                    result = (EmployeeList) si.getValue();
                }

            }
        }
        return result;
    }

    private void setMatches(ValueChangeEvent event) {
        Object searchWord = event.getNewValue();
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);
        try {
            int insert = Collections.binarySearch(AutoCompleteDictionary.dictionary, searchWord, AutoCompleteDictionary.LABEL_COMPARATOR);
            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }
            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= AutoCompleteDictionary.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(AutoCompleteDictionary.dictionary.get(insert + i));
            }
        } catch (Throwable e) {
        }
        // assign new matchList
        if (this.matchesList != null) {
            this.matchesList.clear();
            this.matchesList = null;
        }

        this.matchesList = matchList;
    }

    public void txtSearchByName_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            AutoCompleteDictionary.init();
            updateList(vce);
        }
    //autoCompleteDictionary.init(vce.getNewValue().toString());
    //updateList(vce);
    }

    public String txtSearchByName_action() {
        selectedId = null;
        selectedId = getSelectedEmployeeId();
        choOffice.setSelected(false);
        choMugher.setSelected(false);
        choShift.setSelected(false);
        choAddisAbeba.setSelected(false);
        if (selectedId != null) {
            loadEmployeeInformationForNameSearch(getSelectedEmployeeId());
        }
        //return null means stay on the same page
        return null;
    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnEmplyeeSearch_action() {
        choOffice.setSelected(false);
        choMugher.setSelected(false);
        choShift.setSelected(false);
        choAddisAbeba.setSelected(false);
        loadEmployeeInformation();
        //return null means stay on the same page

        return null;
    }

    private void loadEmployeeInformation() {
        try {

            if (HRValidation.validateRequired(this.txtEmployeeID.getValue())) {
                getRequestsLists().clear();
                getLeaveRequestTable().clear();
                clearLeaveInfoTextComponets();
//                clearPersonalInfoTextComponets();
                employeeId = txtEmployeeID.getValue().toString();
                if (txtEmployeeID.getValue().toString() != null) {
                    btnAddLeaveRequest.setDisabled(true);
                    clearLeaveInfoTextComponets();
                    if (employeeManager.loadEmpoyeeProfile(txtEmployeeID.getValue().toString()) == 1) {
                        colsEmployeeSearchByName.setExpanded(false);
                        colsRequestLisrt.setExpanded(true);
                        btnNew.setDisabled(false);
                        empStatus = employeeManager.getEmp_Status();
                        if (employeeManager.getOfficeOrShift().equals("Shift")) {
                            choShift.setSelected(true);
                            choOffice.setSelected(false);
                        } else if (employeeManager.getOfficeOrShift().equals("Office")) {

                            choShift.setSelected(false);
                            choOffice.setSelected(true);
                        }
                        //   this.txtEmployeeID.setValue(txtEmployeeID.getValue().toString());
                        this.lblFull_Name.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " +
                                "" + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
                        sex = employeeManager.getSex();
                        if (sex.equalsIgnoreCase("Male")) {
                            choMale.setSelected(true);
                            choFemale.setSelected(false);
                        } else if (sex.equalsIgnoreCase("Female")) {
                            choFemale.setSelected(true);
                            choMale.setSelected(false);
                        } else {
                            choMale.setSelected(false);
                            choFemale.setSelected(false);
                        }
                        if (empStatus.equalsIgnoreCase("01")) {
                            lblEmploymentStatus.setValue("ACTIVE");
                        } else {
                            lblEmploymentStatus.setValue("INACTIVE");
                        }
                        try {

                            setEmployeePicture(null);
                            imgEmployeePicture.setValue("");

//                            int expYear = employeeManager.calculateEmpServiceYear(
//                                    jodanTimeCalender.ChangeDateToEthiopic(employeeManager.getHire_Date()));

                            int expYear = employeeManager.calculateEmployeeServiceYearHireDate(
                                    employeeManager.getHire_Date());
                            lblServiceYear.setValue(String.valueOf(expYear));
                            OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                            setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                            imgEmployeePicture.setValue(getEmployeePicture());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));
                        this.lblPosition.setValue(employeeManager.getJobName());
                        requestsLists = leaveRequestManager.selectLeaveRequests(txtEmployeeID.getValue().toString());
                        setLeaveType(leaveRequestManager.loadLeaveTypes(employeeManager.getSex(), employeeManager.getLeaveStartFrom()));

                        if (employeeManager.getLocation() != null) {
                            if (employeeManager.getLocation().equals("Addis Ababa")) {
                                choAddisAbeba.setSelected(true);
                                choMugher.setSelected(false);
                            } else if (employeeManager.getLocation().equals("Mugher")) {
                                choAddisAbeba.setSelected(false);
                                choMugher.setSelected(true);
                            }

                        } else {
                            if (employeeManager.employeeWorkingPlace(
                                    employeeManager.getDepartmentId()).equals("Mugher")) {
                                choAddisAbeba.setSelected(false);
                                choMugher.setSelected(true);
                            } else {
                                choAddisAbeba.setSelected(true);
                                choMugher.setSelected(false);
                            }
                        }
                        txtExternalServiceYear.setValue(employeeManager.calculateEmployeeExperianceServiceYear(txtEmployeeID.getValue().toString()));


                    } else {
                        clearLeaveInfoTextComponets();
                        showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");
                        clearLeaveInfoTextComponets();
                        clearPersonalInfoTextComponets();

                    }
                }
            } else {
                showSuccessOrFailureMessage(false, "Please enter employee Id? And try again?");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEmployeeInformationForNameSearch(String employeeID) {
        try {
            if (employeeID != null) {
                getRequestsLists().clear();
                getLeaveRequestTable().clear();
                clearLeaveInfoTextComponets();
                clearPersonalInfoTextComponets();

                if (employeeID != null) {
                    clearLeaveInfoTextComponets();
                    if (employeeManager.loadEmpoyeeProfile(employeeID) == 1) {
                        colsEmployeeSearchByName.setExpanded(false);
                        colsRequestLisrt.setExpanded(true);
                        btnNew.setDisabled(false);
                        empStatus = employeeManager.getEmp_Status();

                        this.lblFull_Name.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " +
                                "" + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
                        sex = employeeManager.getSex();
                        if (sex.equalsIgnoreCase("Male")) {
                            choMale.setSelected(true);
                            choFemale.setSelected(false);
                        } else if (sex.equalsIgnoreCase("Female")) {
                            choFemale.setSelected(true);
                            choMale.setSelected(false);
                        } else {
                            choMale.setSelected(false);
                            choFemale.setSelected(false);
                        }
                        if (empStatus.equalsIgnoreCase("01")) {
                            lblEmploymentStatus.setValue("ACTIVE");
                        } else {
                            lblEmploymentStatus.setValue("INACTIVE");
                        }

                        if (employeeManager.getOfficeOrShift().equals("Shift")) {
                            choOffice.setSelected(false);
                            choShift.setSelected(true);
                        } else {
                            choOffice.setSelected(true);
                            choShift.setSelected(false);


                        }
                        try {

                            int expYear = employeeManager.calculateEmployeeServiceYearHireDate(
                                    employeeManager.getHire_Date());
//                            int expYear = employeeManager.calculateEmpServiceYear(
//                                    jodanTimeCalender.ChangeDateToEthiopic(employeeManager.getHire_Date()));
                            lblServiceYear.setValue(String.valueOf(expYear));
                            OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                            setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                            imgEmployeePicture.setValue(getEmployeePicture());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));
                        this.lblPosition.setValue(employeeManager.getJobName());
                        requestsLists = leaveRequestManager.selectLeaveRequests(employeeID);
                        setLeaveType(leaveRequestManager.loadLeaveTypes(employeeManager.getSex(), employeeManager.getLeaveStartFrom()));
                        txtEmployeeID.setValue(employeeID);


                        if (employeeManager.getLocation() != null) {
                            if (employeeManager.getLocation().equals("Addis Ababa")) {
                                choAddisAbeba.setSelected(true);
                                choMugher.setSelected(false);
                            } else if (employeeManager.getLocation().equals("Mugher")) {
                                choAddisAbeba.setSelected(false);
                                choMugher.setSelected(true);
                            }

                        } else {
                            if (employeeManager.employeeWorkingPlace(
                                    employeeManager.getDepartmentId()).equals("Mugher")) {
                                choAddisAbeba.setSelected(false);
                                choMugher.setSelected(true);
                            } else {
                                choAddisAbeba.setSelected(true);
                                choMugher.setSelected(false);
                            }
                        }



                        txtExternalServiceYear.setValue(employeeManager.calculateEmployeeExperianceServiceYear(
                                txtEmployeeID.getValue().toString()));
                    } else {
                        clearLeaveInfoTextComponets();
                        showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");
                        clearLeaveInfoTextComponets();
                        clearPersonalInfoTextComponets();

                    }
                }
            } else {
                showSuccessOrFailureMessage(false, "Please enter employee Id? And try again412654?" + employeeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lisLeaveRequestList_processValueChange(ValueChangeEvent vce) {
        try {
            getLeaveRequestTable().clear();
            if (!CommonValidation.isUpdatePhase(vce)) {
                if (vce.getNewValue() != null) {
                    leaveRequestId = vce.getNewValue().toString();
                    requestID = Integer.valueOf(leaveRequestId);
                    disableLeaveInfoTextComponents();
                    disableComponets();
                    clearLeaveInfoTextComponets();
                    HashMap hm = leaveRequestManager.readPreviousRequestsInfo(vce.getNewValue().toString());
                    drlLeaveType.setValue(hm.get("LEAVE_TYPE") + "=" + hm.get("MAX_NUM_OF_DAYS") + "=" + hm.get("DESCRIPTION"));
                    leaveID = hm.get("LEAVE_ID").toString();
                    txtDateFrom.setValue(hm.get("REQUESTED_FROM"));
                    txtDateTo.setValue(hm.get("REQUESTED_TO"));
                    txtLeaveDays.setValue(hm.get("LEAVE_DAYS").toString());
                    displayAvailableDays(txtEmployeeID.getValue().toString(), hm.get("LEAVE_TYPE").toString());
                    txtReason.setValue(hm.get("REQUESTING_REASON"));
                    // setLeaveID(vce.getNewValue().toString());
                    drlSelectWorkflow.setValue(65);
                    int index = hm.get("STATUS").toString().indexOf("-");
                    if (hm.get("STATUS").toString().equals(LeaveApproveManager.INITIAL_STATE_LEAVE) ||
                            hm.get("STATUS").toString().substring(0, index).equals("Res")) {
                        btnEdit.setDisabled(false);
                        btnNew.setDisabled(true);
                        btnDelete.setDisabled(false);
                        btnSave.setDisabled(true);
                        btnUpdate.setDisabled(true);
                        btnAddLeaveRequest.setDisabled(true);
                    } else {
                        showSuccessOrFailureMessage(false, "INFO - This request is on read only state,Only view is enabled.");
                        btnEdit.setDisabled(true);
                        btnNew.setDisabled(false);
                        btnDelete.setDisabled(true);
                        btnSave.setDisabled(true);
                        btnUpdate.setDisabled(true);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String cmdConfirmationCloseDeleete_action() {
        pnConfirmationForDelete.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {
        pnConfirmationForDelete.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String bntYES_action() {
        pnConfirmationForDelete.setRendered(false);
        if (leaveRequestManager.deleteLeaveRequest(leaveID, drlLeaveType.getValue().toString().split("=")[0])) {
            getRequestsLists().clear();
            getLeaveRequestTable().clear();
            clearLeaveInfoTextComponets();
            setRequestsLists(leaveRequestManager.selectLeaveRequests(txtEmployeeID.getValue().toString()));
            showSuccessOrFailureMessage(true, "The Leave Record Deleted Successfully !");
        } else {
            showSuccessOrFailureMessage(false, "Error occurs during deleting the leave request. Please try again ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String cmdClose_action() {
        pnlFamilyList.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnAddLeaveRequest_action()
                    {
        String leveTypeDesc[] = drlLeaveType.getValue().toString().split("=");
        String returnDate = "";
        if (validatLeaveTypeAnddate())
                      {
            if (!leveTypeDesc[0].equals(LeaveRequestManager.LEAVE_TYPE_GETPASS))
                      {
                if (checkDataIsValid(true))
                       {
                    employeeId = txtEmployeeID.getValue().toString();
                    if (leveTypeDesc[0].equals(LeaveRequestManager.ANUAL_LEAVE))
                    {
                        if (HRValidation.validateRequired(txtLeaveDays.getValue()) && !choHafeDay.isSelected())
                        {
                            pnlPopUpAttachment.setRendered(false);
                            HashMap liveTimeAddress = employeeManager.readEmployeeLeaveTimeAddrss(employeeId);
                            if (liveTimeAddress != null)
                            {
                                drlRegion.setValue(liveTimeAddress.get("REGION_ID").toString());
                                zoneList = lookUpManager.readZoneOrCityInARegion(liveTimeAddress.get("REGION_ID").toString());
                                drlZoneOrCity.setValue(liveTimeAddress.get("WOREDA_OR_SUBCITY_ID").toString());
                                woredaList = lookUpManager.readWoredaAndZone(liveTimeAddress.get("WOREDA_OR_SUBCITY_ID").toString());
                                drlWoreda.setValue(liveTimeAddress.get("WOREDA_OR_SUBCITY").toString());
                                kebeleList = lookUpManager.readKebelleInSubCity(liveTimeAddress.get("WOREDA_OR_SUBCITY").toString());
                                drlKabele.setValue(liveTimeAddress.get("KEBELE").toString());
                                txtHouseNumber.setValue(liveTimeAddress.get("HOUSE_NUMBER").toString());
                                txtlblTelephoneHome.setValue(liveTimeAddress.get("TELEPHONE_RESIDENCE").toString());
                                txtTelephoneMoblie.setValue(liveTimeAddress.get("MOBILE").toString());
                                employeLeaveTypeAddress = liveTimeAddress.get("ID").toString();
                            } else {
                                employeLeaveTypeAddress = null;
                            }
                            if (txtReturnDateFromLeave.getValue() != null)
                            {
                                returnDate = txtReturnDateFromLeave.getValue().toString();
                            } else {
                                returnDate = txtDateTo.getValue().toString();
                            }
                            String leaveTypeId[] = drlLeaveType.getValue().toString().split("=");
                            ArrayList<HashMap> list = calculateEmployeeAnualLeave();
                            getLeaveRequestTable().add(new LeaveRequestManager(
                                    txtReason.getValue().toString(),
                                    txtAvilablDayes.getValue().toString(),
                                    txtDateFrom.getValue().toString(),
                                    txtDateTo.getValue().toString(),
                                    txtLeaveDays.getValue().toString(),
                                    leaveTypeId[0],
                                    list,
                                    leaveRequestInformation(),
                                    leaveTypeId[2],
                                    usedYear,
                                    returnDate));

                                      countRequest += 1;

                        }
                        else {
                            if (txtReturnDateFromLeave.getValue() != null) {
                                returnDate = txtReturnDateFromLeave.getValue().toString();
                            } else {
                                returnDate = txtDateTo.getValue().toString();
                            }
                            ArrayList<HashMap> list = calculateEmployeeHalfAnualLeave();
                            String leaveTypeId[] = drlLeaveType.getValue().toString().split("=");
                            getLeaveRequestTable().add(new LeaveRequestManager(
                                    txtReason.getValue().toString(),
                                    txtAvilablDayes.getValue().toString(),
                                    txtDateFrom.getValue().toString(),
                                    txtDateTo.getValue().toString(),
                                    "0.5",
                                    leaveTypeId[0],
                                    list,
                                    leaveRequestInformation(),
                                    leaveTypeId[2],
                                    usedYear,
                                    returnDate));
                                   countRequest += 1;


                        }
                    } else {

                        if (txtReturnDateFromLeave.getValue() != null) {
                            returnDate = txtReturnDateFromLeave.getValue().toString();
                        } else {
                            returnDate = txtDateTo.getValue().toString();
                        }
                        getLeaveRequestTable().add(new LeaveRequestManager(
                                leaveRequestInformation(),
                                getListOfFamilyPassedAwaye(),
                                leveTypeDesc[2],
                                returnDate));
                        countRequest += 1;
                    }
                }
            } else {
                if (validateGetPass(true)) {
                    if (txtReturnDateFromLeave.getValue() != null) {
                        returnDate = txtReturnDateFromLeave.getValue().toString();
                    } else {
                        returnDate = txtDateTo.getValue().toString();
                    }
                    getLeaveRequestTable().add(new LeaveRequestManager(
                            leaveRequestInformation(),
                            getListOfFamilyPassedAwaye(),
                            leveTypeDesc[2],
                            returnDate));
                    countRequest += 1;
                }


            }
        } else {
            showSuccessOrFailureMessage(false, "Not Allowed Request Two Leave " +
                    " By Same Leave Type or By the Same Date .");
        }

        clearLeaveInfoTextComponets();
        enableLeaveInfoTextComponents();
        return null;
    }

    public void page_header_processMyEvent(DragEvent de) {
    }

    public String btnCalenderDateFrom_action() {
        calRequestDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calRequestDate_processValueChange(ValueChangeEvent vce) {
        txtDateFrom.setValue(dateFormat.format((Date) vce.getNewValue()));
        calRequestDate.setRendered(false);

    }

    public static class EmployeeFamilyList implements Serializable {

        private String familyName;
        private String relationType;
        private String id;
        private boolean status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public String getRelationType() {
            return relationType;
        }

        public void setRelationType(String relationType) {
            this.relationType = relationType;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public EmployeeFamilyList() {
        }

        public EmployeeFamilyList(String familyName, String relationType, boolean status,
                String id) {
            this.familyName = familyName;
            this.relationType = relationType;
            this.status = status;
            this.id = id;
        }
    }

    public String btnSaveLIstOfPassAwayeEmployeeFamily_action() {

        for (EmployeeFamilyList employeeFamilyList : getFamilyList()) {
            if (employeeFamilyList.isStatus()) {
                HashMap hm = new HashMap();
                hm.put("ID", employeeFamilyList.getId());
                listOfFamilyPassedAwaye.add(hm);
            }
        }
        pnlFamilyList.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupViewPrevieousDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String commandLink1_action() {
        pnlPopupViewPrevieousDecisions.setRendered(true);
        ArrayList<HashMap> leaveRequestHistory = leaveRequestManager.getLeaveRequestHistory(requestID);
        int counter = 0;
        getDecisionsMadeOnRequest().clear();
        for (HashMap hm : leaveRequestHistory) {
            counter++;
            decisionsMadeOnRequest.add(new RequestHistoryModel(
                    counter,
                    hm.get("deciderEmployeeId").toString(),
                    hm.get("deciderFullName").toString(),
                    hm.get("givenDecision").toString(),
                    hm.get("timeStamp").toString(),
                    hm.get("commentGiven").toString()));

        }

        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseBtnAttachment_action() {
        pnlPopUpAttachment.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void drlRegion_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                zoneList = lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString());
            }
        // this.setWoredaList(lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void drlZoneOrCity_processValueChange(ValueChangeEvent vce) {
        try {
            woredaList = lookUpManager.readWoredaAndZone(vce.getNewValue().toString());
        //kebeleList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());
        } catch (Exception ex) {
        }
    }

    public void drlWoreda_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                kebeleList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    boolean validate() {
        boolean result = false;
        int errorValue = 0;
        try {
            String errorMessage = "Required";
            if (!HRValidation.validateRequired(drlRegion.getValue())) {
                ((UIInput) drlRegion).setValid(false);
                error(drlRegion, errorMessage);
                result = false;
            }
            if (!HRValidation.validateRequired(drlZoneOrCity.getValue())) {
                ((UIInput) drlZoneOrCity).setValid(false);
                error(drlZoneOrCity, errorMessage);
                result = false;
            }
            if (!HRValidation.validateRequired(drlWoreda.getValue())) {
                ((UIInput) drlWoreda).setValid(false);
                error(drlWoreda, errorMessage);
                result = false;
            }
            if (!HRValidation.validateRequired(txtHouseNumber.getValue())) {
                ((UIInput) txtHouseNumber).setValid(false);
                error(txtHouseNumber, errorMessage);
                result = false;
            }
            errorValue = HRValidation.validateData(
                    this.txtTelephoneMoblie.getValue(),
                    HRValidation.PHONE_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtTelephoneMoblie).setValid(false);
                    error(txtTelephoneMoblie, errorMessage);
                } else {
                    ((UIInput) txtTelephoneMoblie).setValid(false);
                    error(txtTelephoneMoblie, "Invalid Value");
                }
            }
            errorValue = HRValidation.validateData(
                    this.txtlblTelephoneHome.getValue(),
                    HRValidation.PHONE_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtlblTelephoneHome).setValid(false);
                    error(txtlblTelephoneHome, errorMessage);
                } else {
                    ((UIInput) txtlblTelephoneHome).setValid(false);
                    error(txtlblTelephoneHome, "Invalid Value");
                }
            }






            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String btnUpdateAddress_action() {
        String kebelle = "Not Registerd";
        String houseNumber = "Not Registerd";
        String telePhoneHome = "Not Registerd";
        String telePhoneMoblie = "Not Registerd";
        if (drlKabele.getValue() != null && !drlKabele.getValue().toString().equals(" ")) {
            kebelle = drlKabele.getValue().toString();
        }
        if (txtHouseNumber.getValue() != null && !txtHouseNumber.getValue().toString().equals(" ")) {
            houseNumber = txtHouseNumber.getValue().toString();
        }
        if (txtlblTelephoneHome.getValue() != null && !txtlblTelephoneHome.getValue().toString().equals(" ")) {
            telePhoneHome = txtlblTelephoneHome.getValue().toString();
        }
        if (txtTelephoneMoblie.getValue() != null && !txtTelephoneMoblie.getValue().toString().equals(" ")) {
            telePhoneMoblie = txtTelephoneMoblie.getValue().toString();
        }
        if (employeeManager.updateLeaveTimeAddress(
                txtEmployeeID.getValue().toString(),
                drlRegion.getValue().toString(),
                drlZoneOrCity.getValue().toString(),
                drlWoreda.getValue().toString(),
                kebelle,
                houseNumber,
                telePhoneHome,
                telePhoneMoblie,
                employeLeaveTypeAddress)) {
            pnlPopUpAttachment.setRendered(false);
            showSuccessOrFailureMessage(true, "Employee Leave Time Address " +
                    " Successfully Updated.");
        } else {
            lblErrorMessage.setValue("Employee Leave Time Address " +
                    " Successfully Updated.");
        }
//        }

        //return null means stay on the same page
        return null;
    }

    public void optTxtForColumn00_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            txtLeaveDays.setValue(displayedTime);
            pnlLayoutTimePanel.setRendered(false);
            hours = displayedTime.substring(0, 2);
            addHours = Integer.parseInt(hours);
            addHours += 2;
            if (addHours < 10) {
                hours = "0" + Integer.toString(addHours);
            } else {
                hours = Integer.toString(addHours);
            }
            minite = displayedTime.substring(3, 5);
            lblReturnDate.setValue(hours + ":" + minite);
        //   txtReturnDateFromLeave.setValue(hours + ":" + minite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void optTxtForColumn02_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            txtLeaveDays.setValue(displayedTime);
            pnlLayoutTimePanel.setRendered(false);
            hours = displayedTime.substring(0, 2);
            addHours = Integer.parseInt(hours);
            addHours += 2;
            hours = "0" + Integer.toString(addHours);
            minite = displayedTime.substring(3, 5);
            lblReturnDate.setValue(hours + ":" + minite);
        //txtReturnDateFromLeave.setValue(hours + ":" + minite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void optTxtForolumn04_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            txtLeaveDays.setValue(displayedTime);
            pnlLayoutTimePanel.setRendered(false);
            hours = displayedTime.substring(0, 2);
            hours = displayedTime.substring(0, 2);
            addHours = Integer.parseInt(hours);
            addHours += 2;
            if (addHours < 10) {
                hours = "0" + Integer.toString(addHours);
            } else {
                hours = Integer.toString(addHours);
            }

            minite = displayedTime.substring(3, 5);
            lblReturnDate.setValue(hours + ":" + minite);
        //  txtReturnDateFromLeave.setValue(hours + ":" + minite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void optTxtForColumn06_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            txtLeaveDays.setValue(displayedTime);
            pnlLayoutTimePanel.setRendered(false);
            hours = displayedTime.substring(0, 2);
            addHours = Integer.parseInt(hours);
            addHours += 2;
            if (addHours < 10) {
                hours = "0" + Integer.toString(addHours);
            } else {
                hours = Integer.toString(addHours);
            }

            minite = displayedTime.substring(3, 5);
            lblReturnDate.setValue(hours + ":" + minite);
        //  txtReturnDateFromLeave.setValue(hours + ":" + minite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void optTxtForColumn08_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            txtLeaveDays.setValue(displayedTime);
            pnlLayoutTimePanel.setRendered(false);
            hours = displayedTime.substring(0, 2);
            addHours = Integer.parseInt(hours);
            addHours += 2;
            if (addHours < 10) {
                hours = "0" + Integer.toString(addHours);
            } else {
                hours = Integer.toString(addHours);
            }

            minite = displayedTime.substring(3, 5);
            lblReturnDate.setValue(hours + ":" + minite);
        //   txtReturnDateFromLeave.setValue(hours + ":" + minite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void optTxtForColumn10_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            txtLeaveDays.setValue(displayedTime);
            pnlLayoutTimePanel.setRendered(false);
            hours = displayedTime.substring(0, 2);
            addHours = Integer.parseInt(hours);
            addHours += 2;
            if (addHours < 10) {
                hours = "0" + Integer.toString(addHours);
            } else {
                hours = Integer.toString(addHours);
            }

            minite = displayedTime.substring(3, 5);
            lblReturnDate.setValue(hours + ":" + minite);
        // txtReturnDateFromLeave.setValue(hours + ":" + minite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String btnTime_action() {
        pnlLayoutTimePanel.setRendered(true);
        String style = "border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 100px; top: 80px; overflow: auto; position: absolute; width: 280px";
        pnlLayoutTimePanel.setStyle(style);
        //return null means stay on the same page
        return null;
    }

    private ArrayList<HashMap> calculateEmployeeHafeAnualLeave() {
        try {
            int requestLeave = Integer.parseInt(txtLeaveDays.getValue().toString());
            int availeLeave = 0;
            int usedleave = 0;
            int oldAmount = 0;
            int leavereq = requestLeave;
            ArrayList<HashMap> useleve = new ArrayList<HashMap>();

            for (HashMap hm : leaveRequestManager.readReserveLeave(employeeId)) {
                HashMap list = new HashMap();
                availeLeave = Integer.parseInt(hm.get("availeLeave").toString());
                usedleave += availeLeave;
                leavereq -= availeLeave;
                if (leavereq >= 0) {
                    requestLeave -= availeLeave;
                    usedleave = availeLeave;
                } else {
                    usedleave = requestLeave;
                    requestLeave -= requestLeave;
                }
                oldAmount = Integer.parseInt(hm.get("USEDLEAVE").toString()) + usedleave;
                list.put("uesedLeave", Integer.toString(usedleave));
                list.put("oldLeaveAmount", Integer.toString(oldAmount));
                list.put("id", hm.get("reservelaveid").toString());
                list.put("year", hm.get("leaveyear").toString());
                list.put("leaveFrom", "reserveLeave");
                leaveFrom = leaveFrom + "--reserveLeave";
                leaveFromId = leaveFromId + "--" + hm.get("reservelaveid").toString();
                useleve.add(list);
            }
            for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {
                HashMap list = new HashMap();
                availeLeave = Integer.parseInt(hm.get("availeLeave").toString());
                usedleave += availeLeave;
                leavereq -= availeLeave;
                if (leavereq >= 0) {
                    requestLeave -= availeLeave;
                    usedleave = availeLeave;
                } else {
                    usedleave = requestLeave;
                    requestLeave -= requestLeave;
                }
                oldAmount = Integer.parseInt(hm.get("usedleave").toString()) + usedleave;
                list.put("uesedLeave", Integer.toString(usedleave));
                list.put("oldLeaveAmount", Integer.toString(oldAmount));
                list.put("id", hm.get("id").toString());
                list.put("year", hm.get("year").toString());
                list.put("leaveFrom", "anualLeave");
                leaveFrom = leaveFrom + "--anualLeave";
                leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                useleve.add(list);
            }
            return useleve;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public void Shift(FacesContext context, UIComponent component, Object value) {
    }

    public void choOffice_processValueChange(ValueChangeEvent vce) {
        choOffice.setSelected(true);
        choShift.setSelected(false);
    }

    public void choAddisAbeba_processValueChange(ValueChangeEvent vce) {
        choMugher.setSelected(false);
        choAddisAbeba.setSelected(true);
    }

    public void choShift_processValueChange(ValueChangeEvent vce) {
        choOffice.setSelected(false);
        choShift.setSelected(true);
    }

    public void choMugher_processValueChange(ValueChangeEvent vce) {
        choMugher.setSelected(true);
        choAddisAbeba.setSelected(false);
    }
}
