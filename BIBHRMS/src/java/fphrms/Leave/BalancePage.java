/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright BravoZulu
 */
package fphrms.Leave;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.ColumnGroup;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputHidden;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.outputprogress.OutputProgress;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.text.ParseException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.RetirementLookUpManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.terminationManager.SearchCriterias;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.context.effects.Appear;
import com.icesoft.faces.context.effects.Fade;
import com.icesoft.faces.context.effects.JavascriptContext;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.component.UIInput;
import javax.swing.JOptionPane;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.CommonValidation;
import manager.terminationManager.TransferManager;
import oracle.jdbc.rowset.OracleSerialBlob;
import lookUps.componentLists;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;
import manager.leaveManager.AnnualLeaveManager;
import manager.leaveManager.LeaveBalanceManager;
import manager.leaveManager.LeaveBalanceManager.EmployeeLeaveMaster;
import manager.leaveManager.LeaveRequestManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class BalancePage extends AbstractPageBean {

    AutoCompleteDictionary autoCompleteDictionary = new AutoCompleteDictionary();
    private ArrayList<LeaveBalance> employeeLeaveBalace = new ArrayList<LeaveBalance>();
    private ArrayList<LeaveBalance> employeeLeaveBalaceBackUp = new ArrayList<LeaveBalance>();
    public ArrayList<LeaveBalance> employeeLeaveBalaceUpdate = new ArrayList<LeaveBalance>();
    public ArrayList<EmoloyeeList> employeeList = new ArrayList<EmoloyeeList>();
    public ArrayList<EmoloyeeList> employeeListExpiranceLessThanOne = new ArrayList<EmoloyeeList>();
    private LeaveBalanceManager leaveBalanceManager = new LeaveBalanceManager();
    private AnnualLeaveManager annualLeaveManager = new AnnualLeaveManager();
    private String leaveBalanceId;
    private int serviceYear;
    private int buttonIdentifierLeaveBalance = 0;
    public int year;
    public float leaveAmount =  16;
    public int totalLeaveAmount = 0;
    EmployeeList currentEmployee1 = new EmployeeList("", "0", null);
    EmployeeManage currentEmployee = new EmployeeManage();
    private Boolean visible;
    private Object effectWindow;
    private boolean fromReserveLeave = false;
    public String[] expTotal;
    public float result;
    // LeaveBalance balance=new LeaveBalance();
    /////////////////
    ///////////////////////////////////////////////////////////////////
    //*************************************Document Attachement Inner Classes and Releted Methods and Variables *****************************************************
    ArrayList<HashMap> myDocuments = new ArrayList<HashMap>();
    private String attachedImage = "/SalaryDelegation/images/attachment.gif";
    private String imageFormat = "/SalaryDelegation/images/image.gif";
    private String fileFormat = "/SalaryDelegation/images/file.gif";
    private String attachedDocumentPath;
    private FileInfo currentFile;
    private int fileProgress;
    private String componentStatus;

    public String[] getExpTotal() {
        return expTotal;
    }

    public void setExpTotal(String[] expTotal) {
        this.expTotal = expTotal;
    }

    public float getLeaveAmount() {
        return leaveAmount;
    }

    public void setLeaveAmount(float leaveAmount) {
        this.leaveAmount = leaveAmount;
    }

  

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(int serviceYear) {
        this.serviceYear = serviceYear;
    }

    public ArrayList<EmoloyeeList> getEmployeeListExpiranceLessThanOne() {
        return employeeListExpiranceLessThanOne;
    }

    public void setEmployeeListExpiranceLessThanOne(ArrayList<EmoloyeeList> employeeListExpiranceLessThanOne) {
        this.employeeListExpiranceLessThanOne = employeeListExpiranceLessThanOne;
    }

    public ArrayList<LeaveBalance> getEmployeeLeaveBalaceBackUp() {
        return employeeLeaveBalaceBackUp;
    }

    public void setEmployeeLeaveBalaceBackUp(ArrayList<LeaveBalance> employeeLeaveBalaceBackUp) {
        this.employeeLeaveBalaceBackUp = employeeLeaveBalaceBackUp;
    }

    public boolean isFromReserveLeave() {
        return fromReserveLeave;
    }

    public void setFromReserveLeave(boolean fromReserveLeave) {
        this.fromReserveLeave = fromReserveLeave;
    }

    public ArrayList<LeaveBalance> getEmployeeLeaveBalaceUpdate() {
        return employeeLeaveBalaceUpdate;
    }

    public void setEmployeeLeaveBalaceUpdate(ArrayList<LeaveBalance> employeeLeaveBalaceUpdate) {
        this.employeeLeaveBalaceUpdate = employeeLeaveBalaceUpdate;
    }

    public String getCommentLanguage() {
        return commentLanguage;
    }

    public void setCommentLanguage(String commentLanguage) {
        this.commentLanguage = commentLanguage;
    }

    public byte[] getAttachedDBImg() {
        return attachedDBImg;
    }

    public void setAttachedDBImg(byte[] attachedDBImg) {
        this.attachedDBImg = attachedDBImg;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getSearchTerminationRequestValueTemp() {
        return searchTerminationRequestValueTemp;
    }

    public void setSearchTerminationRequestValueTemp(String searchTerminationRequestValueTemp) {
        this.searchTerminationRequestValueTemp = searchTerminationRequestValueTemp;
    }

    public String getSearchTerminationRequestValue() {
        return searchTerminationRequestValue;
    }

    public void setSearchTerminationRequestValue(String searchTerminationRequestValue) {
        this.searchTerminationRequestValue = searchTerminationRequestValue;
    }

    public String getGroupSettingDB() {
        return groupSettingDB;
    }

    public void setGroupSettingDB(String groupSettingDB) {
        this.groupSettingDB = groupSettingDB;
    }

    public String getGroup_setting_Main() {
        return group_setting_Main;
    }

    public void setGroup_setting_Main(String group_setting_Main) {
        this.group_setting_Main = group_setting_Main;
    }

    public String getGroup_SettingsDB() {
        return group_SettingsDB;
    }

    public void setGroup_SettingsDB(String group_SettingsDB) {
        this.group_SettingsDB = group_SettingsDB;
    }

    public static boolean isBtnNo() {
        return btnNo;
    }

    public static boolean isBtnOk() {
        return btnOk;
    }

    public static boolean isBtnYes() {
        return btnYes;
    }

    public EmployeeManage getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(EmployeeManage currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private RetirementLookUpManager retirementLookUpManager = new RetirementLookUpManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private TransferManager transferManager = new TransferManager();
    private DepartmentManage departmentManage = new DepartmentManage();
    private static boolean btnYes = false;
    private static boolean btnNo = false;
    private static boolean btnOk = false;
    private String group_setting_Main;
    private String group_Setting;
    private String group_SettingsDB;
    private String groupSettingDB;
    private String searchTerminationRequestValue;
    private String searchTerminationRequestValueTemp;
    private String resignID = null;
    private String sex;
    private String hireDate;
    private String currentDate;
    private static String selectedId;
    private static int messageStatus = 0;
    private static int tableSize = 0;
    private static int rowCounter = 0;
    private int selecteLeaveBalanceRow = -1;
    private int selecteLeaveBalanceasOFTodayRow = 0;
    private byte[] attachedDBImg;
    private ArrayList<SelectItem> terminationTypes = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> pysicalLeaveTypes = new ArrayList<SelectItem>();
    private ResourceBundle messageResource = null;
    private ResourceBundle messageTermination = null;
    private FacesContext context = null;
    private String commentLanguage = null;
    private String loggedInUserId = null;
    String currenTDateToSet = "fromDate";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int requestId = 0;
    private byte[] employeePicture;
    private byte[] attachedDBImg1;
    private HtmlCommandButton btnPopUpYes = new HtmlCommandButton();
    private boolean firstTime = true;
    public ArrayList<EmployeeLeaveMaster> employeeLeaveMaster=new ArrayList<EmployeeLeaveMaster>();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception
    {
        txtCurrentDate.setValue(dateFormat.format(new Date()));
        pysicalLeaveTypes = leaveBalanceManager.pysicalLeaveYear();
        btnEditLeaveBalance.setDisabled(true);
        btnUpdateLeaveBalance.setDisabled(true);
        btnDeleteLeaveBalance.setDisabled(true);
        currentDate = dateFormat.format(new Date());
//        if (firstTime) {
//            firstTime = false;
    //     loadEmployeeLeaveBalance();
//        }
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    //  state = PersistentFacesState.getInstance();
    }

    @Deprecated
    private void loadEmployeeLeaveBalance()
    {
//        try {
//            LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
//            employeeLeaveBalace.clear();
//            ArrayList<HashMap> listOfEmployeeLeaveBalance = leaveBalanceManager.listOfEmployeeLeaveBalance();
//
//            String employeeId = "";
//            boolean first_Time = true;
//            String anualLeaveDays = "0";
//            if (listOfEmployeeLeaveBalance.size() > 0)
//            {
//                btnEditLeaveBalance.setDisabled(false);
//                btnDeleteLeaveBalance.setDisabled(false);
//            }
//            for (HashMap hm : listOfEmployeeLeaveBalance) {
//                if (first_Time)
//                {
//                    employeeId = hm.get("employeeId").toString();
//                    anualLeaveDays = leaveRequestManager.readEmployeeAvailableAnualLeave(
//                            employeeId);
//                    first_Time = false;
//                } else if (!employeeId.equals(hm.get("employeeId").toString())) {
//                    employeeId = hm.get("employeeId").toString();
//                    anualLeaveDays = leaveRequestManager.readEmployeeAvailableAnualLeave(
//                            employeeId);
//                }
//
//                LeaveBalance leaveBalanceInfo = new LeaveBalance(
//                        hm.get("leaveBlanceId").toString(),
//                        hm.get("employeeId").toString(),
//                        hm.get("physicalYear").toString(),
//                        hm.get("leaveAmount").toString(),
//                        hm.get("FULLNAAME").toString(),
//                        hm.get("USEDLEAVE").toString(),
//                        anualLeaveDays, false);
//                employeeLeaveBalace.add(leaveBalanceInfo);
//            }
//            listOfEmployeeLeaveBalance = leaveBalanceManager.listOfEmployeeFromReserveLeave();
//
//            if (listOfEmployeeLeaveBalance.size() > 0) {
//                btnEditLeaveBalance.setDisabled(false);
//                btnDeleteLeaveBalance.setDisabled(false);
//            }
//            first_Time = true;
//            for (HashMap hm : listOfEmployeeLeaveBalance) {
//                if (first_Time) {
//                    employeeId = hm.get("employeeId").toString();
//                    anualLeaveDays = leaveRequestManager.readEmployeeAvailableAnualLeave(
//                            employeeId);
//                    first_Time = false;
//                } else if (!employeeId.equals(hm.get("employeeId").toString())) {
//                    employeeId = hm.get("employeeId").toString();
//                    anualLeaveDays = leaveRequestManager.readEmployeeAvailableAnualLeave(
//                            employeeId);
//                }
//                LeaveBalance leaveBalanceInfo = new LeaveBalance(
//                        hm.get("leaveBlanceId").toString(),
//                        hm.get("employeeId").toString(),
//                        hm.get("physicalYear").toString(),
//                        hm.get("leaveAmount").toString(),
//                        hm.get("FULLNAAME").toString(),
//                        hm.get("USEDLEAVE").toString(),
//                        anualLeaveDays,
//                        true);
//                employeeLeaveBalace.add(leaveBalanceInfo);
//            }
//
//            Collections.sort(employeeLeaveBalace, new Comparator() {
//
//                public int compare(Object o1, Object o2) {
//                    LeaveBalance p1 = (LeaveBalance) o1;
//                    LeaveBalance p2 = (LeaveBalance) o2;
//                    return p1.getEmployeeId().compareToIgnoreCase(p2.getEmployeeId());
//                }
//            });
//
//
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void loadEmployeeLeaveBalance(String employeeId)
    {
        try {
            LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
            employeeLeaveBalace.clear();
            ArrayList<HashMap> listOfEmployeeLeaveBalance = leaveBalanceManager.listOfEmployeeLeaveBalance(employeeId);

            if (listOfEmployeeLeaveBalance.size() > 0)
            {
                btnEditLeaveBalance.setDisabled(false);
                btnDeleteLeaveBalance.setDisabled(false);
            }
            boolean first_Time = true;
            String anualLeaveDays = "";
            for (HashMap hm : listOfEmployeeLeaveBalance)
               {
                if (first_Time)
                {
                    employeeId = hm.get("employeeId").toString();
                    anualLeaveDays = leaveRequestManager.readAnualLeave(
                            employeeId);
                    first_Time = false;
                }


                LeaveBalance leaveBalanceInfo = new LeaveBalance(
                        hm.get("leaveBlanceId").toString(),
                        hm.get("employeeId").toString(),
                        Integer.parseInt(hm.get("physicalYear").toString()),
                        Float.parseFloat(hm.get("leaveAmount").toString()),
                        hm.get("FULLNAAME").toString(),
                        hm.get("USEDLEAVE").toString(),
                        anualLeaveDays,
                        false);
                employeeLeaveBalace.add(leaveBalanceInfo);
            }
//            listOfEmployeeLeaveBalance = leaveBalanceManager.listOfEmployeeFromReserveLeave(employeeId);
//
//            if (listOfEmployeeLeaveBalance.size() > 0) {
//                btnEditLeaveBalance.setDisabled(false);
//                btnDeleteLeaveBalance.setDisabled(false);
//            }
//            for (HashMap hm : listOfEmployeeLeaveBalance) {
//                LeaveBalance leaveBalanceInfo = new LeaveBalance(
//                        hm.get("leaveBlanceId").toString(),
//                        hm.get("employeeId").toString(),
//                        hm.get("physicalYear").toString(),
//                        hm.get("leaveAmount").toString(),
//                        hm.get("FULLNAAME").toString(),
//                        hm.get("USEDLEAVE").toString(),
//                        anualLeaveDays,
//                        true);
//                employeeLeaveBalace.add(leaveBalanceInfo);
//            }

            Collections.sort(employeeLeaveBalace, new Comparator() {

                public int compare(Object o1, Object o2) {
                    LeaveBalance p1 = (LeaveBalance) o1;
                    LeaveBalance p2 = (LeaveBalance) o2;
                    return p1.getEmployeeId().compareToIgnoreCase(p2.getEmployeeId());
                }
            });





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private PanelPopup pnlPopupViewLeaveBalalceAsOFToDay = new PanelPopup();
    private PanelPopup pnlPopupViewLeaveBalalceAsOFToDayForZeroYear = new PanelPopup();

    public PanelPopup getPnlPopupViewLeaveBalalceAsOFToDayForZeroYear() {
        return pnlPopupViewLeaveBalalceAsOFToDayForZeroYear;
    }

    public void setPnlPopupViewLeaveBalalceAsOFToDayForZeroYear(PanelPopup pnlPopupViewLeaveBalalceAsOFToDayForZeroYear) {
        this.pnlPopupViewLeaveBalalceAsOFToDayForZeroYear = pnlPopupViewLeaveBalalceAsOFToDayForZeroYear;
    }

    public PanelPopup getPnlPopupViewLeaveBalalceAsOFToDay() {
        return pnlPopupViewLeaveBalalceAsOFToDay;
    }

    public void setPnlPopupViewLeaveBalalceAsOFToDay(PanelPopup pnlPopupViewLeaveBalalceAsOFToDay) {
        this.pnlPopupViewLeaveBalalceAsOFToDay = pnlPopupViewLeaveBalalceAsOFToDay;
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
    private componentLists male = new componentLists();

    public componentLists getMale() {
        return male;
    }

    public void setMale(componentLists uisi) {
        this.male = uisi;
    }
    private componentLists female = new componentLists();

    public componentLists getFemale() {
        return female;
    }

    public void setFemale(componentLists uisi) {
        this.male = uisi;
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
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox1Bean1 = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean1() {
        return selectOneListbox1Bean1;
    }

    public void setSelectOneListbox1Bean1(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean1 = dsd;
    }
    private HtmlCommandButton modalPnlCloseBtn = new HtmlCommandButton();

    public HtmlCommandButton getModalPnlCloseBtn() {
        return modalPnlCloseBtn;
    }

    public void setModalPnlCloseBtn(HtmlCommandButton hcb) {
        this.modalPnlCloseBtn = hcb;
    }
    private PanelPopup pnlPopUpResignTye = new PanelPopup();

    public PanelPopup getPnlPopUpResignTye() {
        return pnlPopUpResignTye;
    }

    public void setPnlPopUpResignTye(PanelPopup pp) {
        this.pnlPopUpResignTye = pp;
    }
    private HtmlInputText txtResignationType = new HtmlInputText();

    public HtmlInputText getTxtResignationType() {
        return txtResignationType;
    }

    public void setTxtResignationType(HtmlInputText hit) {
        this.txtResignationType = hit;
    }
    private HtmlInputTextarea txtResignationTypeDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtResignationTypeDescription() {
        return txtResignationTypeDescription;
    }

    public void setTxtResignationTypeDescription(HtmlInputTextarea hit) {
        this.txtResignationTypeDescription = hit;
    }
    private HtmlInputHidden lblHResignationTypeID = new HtmlInputHidden();

    public HtmlInputHidden getLblHResignationTypeID() {
        return lblHResignationTypeID;
    }

    public void setLblHResignationTypeID(HtmlInputHidden hih) {
        this.lblHResignationTypeID = hih;
    }
    private HtmlCommandButton btnResignNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignNew() {
        return btnResignNew;
    }

    public void setBtnResignNew(HtmlCommandButton hcb) {
        this.btnResignNew = hcb;
    }
    private HtmlCommandButton btnResignEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignEdit() {
        return btnResignEdit;
    }

    public void setBtnResignEdit(HtmlCommandButton hcb) {
        this.btnResignEdit = hcb;
    }
    private HtmlCommandButton btnResignCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignCancel() {
        return btnResignCancel;
    }

    public void setBtnResignCancel(HtmlCommandButton hcb) {
        this.btnResignCancel = hcb;
    }
    private HtmlCommandButton btnResignDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignDelete() {
        return btnResignDelete;
    }

    public void setBtnResignDelete(HtmlCommandButton hcb) {
        this.btnResignDelete = hcb;
    }
    private HtmlSelectOneListbox lstResignationTyes = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstResignationTyes() {
        return lstResignationTyes;
    }

    public void setLstResignationTyes(HtmlSelectOneListbox hsol) {
        this.lstResignationTyes = hsol;
    }
    private HtmlSelectOneRadio ckbSex = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getCkbSex() {
        return ckbSex;
    }

    public void setCkbSex(HtmlSelectOneRadio hsor) {
        this.ckbSex = hsor;
    }
    private HtmlSelectOneMenu dplEmployeeID = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDplEmployeeID() {
        return dplEmployeeID;
    }

    public void setDplEmployeeID(HtmlSelectOneMenu hsom) {
        this.dplEmployeeID = hsom;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems = dsi;
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
    private HtmlSelectBooleanCheckbox cbMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCbMale() {
        return cbMale;
    }

    public void setCbMale(HtmlSelectBooleanCheckbox hsbc) {
        this.cbMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox cbFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCbFemale() {
        return cbFemale;
    }

    public void setCbFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.cbFemale = hsbc;
    }
    private HtmlCommandButton btnEditLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditLeaveBalance() {
        return btnEditLeaveBalance;
    }

    public void setBtnEditLeaveBalance(HtmlCommandButton hcb) {
        this.btnEditLeaveBalance = hcb;
    }
    private HtmlCommandButton btnCancelLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelLeaveBalance() {
        return btnCancelLeaveBalance;
    }

    public void setBtnCancelLeaveBalance(HtmlCommandButton hcb) {
        this.btnCancelLeaveBalance = hcb;
    }
    private HtmlCommandButton btnUpdateLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateLeaveBalance() {
        return btnUpdateLeaveBalance;
    }

    public void setBtnUpdateLeaveBalance(HtmlCommandButton hcb) {
        this.btnUpdateLeaveBalance = hcb;
    }
    private HtmlOutputText lblFullNameAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblFullNameAutoComplete() {
        return lblFullNameAutoComplete;
    }

    public void setLblFullNameAutoComplete(HtmlOutputText lblFullNameAutoComplete) {
        this.lblFullNameAutoComplete = lblFullNameAutoComplete;
    }
    private HtmlOutputText lblEmployeeIdAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeIdAutoComplete() {
        return lblEmployeeIdAutoComplete;
    }

    public void setLblEmployeeIdAutoComplete(HtmlOutputText lblEmployeeIdAutoComplete) {
        this.lblEmployeeIdAutoComplete = lblEmployeeIdAutoComplete;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    ArrayList<SelectItem> nameOptions = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getNameOptions() {
        return nameOptions;
    }
    ArrayList<SelectItem> autoComplete = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getAutoComplete() {
        return autoComplete;
    }

    public void setAutoComplete(ArrayList<SelectItem> autoComplete) {
        this.autoComplete = autoComplete;
    }

    public void setNameOptions(ArrayList<SelectItem> nameOptions) {
        this.nameOptions = nameOptions;
    }
    private SelectInputText txtEmployeeNameSearch = new SelectInputText();

    public SelectInputText getTxtEmployeeNameSearch() {
        return txtEmployeeNameSearch;
    }

    public void setTxtEmployeeNameSearch(SelectInputText sit) {
        this.txtEmployeeNameSearch = sit;
    }
    private PanelPopup pnlPopUpMsg = new PanelPopup();

    public PanelPopup getPnlPopUpMsg() {
        return pnlPopUpMsg;
    }

    public void setPnlPopUpMsg(PanelPopup pp) {
        this.pnlPopUpMsg = pp;
    }
    private HtmlOutputText lblPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMain() {
        return lblPopUpMsgMain;
    }

    public void setLblPopUpMsgMain(HtmlOutputText hot) {
        this.lblPopUpMsgMain = hot;
    }

    public HtmlCommandButton getBtnPopUpYes() {
        return btnPopUpYes;
    }

    public void setBtnPopUpYes(HtmlCommandButton hcb) {
        this.btnPopUpYes = hcb;
    }
    private HtmlCommandButton btnNewLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewLeaveBalance() {
        return btnNewLeaveBalance;
    }

    public void setBtnNewLeaveBalance(HtmlCommandButton hcb) {
        this.btnNewLeaveBalance = hcb;
    }
    private HtmlInputText txtCommentedByFullName = new HtmlInputText();

    public HtmlInputText getTxtCommentedByFullName() {
        return txtCommentedByFullName;
    }

    public void setTxtCommentedByFullName(HtmlInputText hit) {
        this.txtCommentedByFullName = hit;
    }
    private HtmlOutputLabel lblTerminationrequestEmployeeId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTerminationrequestEmployeeId() {
        return lblTerminationrequestEmployeeId;
    }

    public void setLblTerminationrequestEmployeeId(HtmlOutputLabel hol) {
        this.lblTerminationrequestEmployeeId = hol;
    }
    private HtmlInputText txtCommentedByPosition = new HtmlInputText();

    public HtmlInputText getTxtCommentedByPosition() {
        return txtCommentedByPosition;
    }

    public void setTxtCommentedByPosition(HtmlInputText hit) {
        this.txtCommentedByPosition = hit;
    }
    private HtmlInputTextarea txtRequestCommentedDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRequestCommentedDescription() {
        return txtRequestCommentedDescription;
    }

    public void setTxtRequestCommentedDescription(HtmlInputTextarea hit) {
        this.txtRequestCommentedDescription = hit;
    }
    private HtmlInputText txtCommentedByDateCommented = new HtmlInputText();

    public HtmlInputText getTxtCommentedByDateCommented() {
        return txtCommentedByDateCommented;
    }

    public void setTxtCommentedByDateCommented(HtmlInputText hit) {
        this.txtCommentedByDateCommented = hit;
    }
    private PanelPopup pnlPopUpRequestCommented = new PanelPopup();

    public PanelPopup getPnlPopUpRequestCommented() {
        return pnlPopUpRequestCommented;
    }

    public void setPnlPopUpRequestCommented(PanelPopup pp) {
        this.pnlPopUpRequestCommented = pp;
    }
    private HtmlInputText txtCommentedByDateProcessed = new HtmlInputText();

    public HtmlInputText getTxtCommentedByDateProcessed() {
        return txtCommentedByDateProcessed;
    }

    public void setTxtCommentedByDateProcessed(HtmlInputText hit) {
        this.txtCommentedByDateProcessed = hit;
    }
    private PanelPopup pnlPopUpRequestProcessed = new PanelPopup();

    public PanelPopup getPnlPopUpRequestProcessed() {
        return pnlPopUpRequestProcessed;
    }

    public void setPnlPopUpRequestProcessed(PanelPopup pp) {
        this.pnlPopUpRequestProcessed = pp;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectedData defaultSelectedData119 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData119() {
        return defaultSelectedData119;
    }

    public void setDefaultSelectedData119(DefaultSelectedData dsd) {
        this.defaultSelectedData119 = dsd;
    }
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
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
    }
    private DefaultSelectedData defaultSelectedData120 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData120() {
        return defaultSelectedData120;
    }

    public void setDefaultSelectedData120(DefaultSelectedData dsd) {
        this.defaultSelectedData120 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbVoluntary = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbVoluntary() {
        return ckbVoluntary;
    }

    public void setCkbVoluntary(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbVoluntary = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbDismisalInvoluntary = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbDismisalInvoluntary() {
        return ckbDismisalInvoluntary;
    }

    public void setCkbDismisalInvoluntary(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbDismisalInvoluntary = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbLayOff = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbLayOff() {
        return ckbLayOff;
    }

    public void setCkbLayOff(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbLayOff = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbOtherInvoluntary = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbOtherInvoluntary() {
        return ckbOtherInvoluntary;
    }

    public void setCkbOtherInvoluntary(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbOtherInvoluntary = hsbc;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlOutputLabel lblTerminationrequestEmployeeId1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTerminationrequestEmployeeId1() {
        return lblTerminationrequestEmployeeId1;
    }

    public void setLblTerminationrequestEmployeeId1(HtmlOutputLabel hol) {
        this.lblTerminationrequestEmployeeId1 = hol;
    }
    private HtmlInputTextarea txtRequestProcessedDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRequestProcessedDescription() {
        return txtRequestProcessedDescription;
    }

    public void setTxtRequestProcessedDescription(HtmlInputTextarea hit) {
        this.txtRequestProcessedDescription = hit;
    }
    private HtmlInputText txtProcessedByFullName = new HtmlInputText();

    public HtmlInputText getTxtProcessedByFullName() {
        return txtProcessedByFullName;
    }

    public void setTxtProcessedByFullName(HtmlInputText hit) {
        this.txtProcessedByFullName = hit;
    }
    private HtmlInputText txtProcessedByPosition = new HtmlInputText();

    public HtmlInputText getTxtProcessedByPosition() {
        return txtProcessedByPosition;
    }

    public void setTxtProcessedByPosition(HtmlInputText hit) {
        this.txtProcessedByPosition = hit;
    }
    private HtmlInputText txtProcessedByDate = new HtmlInputText();

    public HtmlInputText getTxtProcessedByDate() {
        return txtProcessedByDate;
    }

    public void setTxtProcessedByDate(HtmlInputText hit) {
        this.txtProcessedByDate = hit;
    }
    private PanelPopup pnlPopUpAttachment = new PanelPopup();

    public PanelPopup getPnlPopUpAttachment() {
        return pnlPopUpAttachment;
    }

    public void setPnlPopUpAttachment(PanelPopup pp) {
        this.pnlPopUpAttachment = pp;
    }
    private OutputProgress attachmentProgress = new OutputProgress();

    public OutputProgress getAttachmentProgress() {
        return attachmentProgress;
    }

    public void setAttachmentProgress(OutputProgress op) {
        this.attachmentProgress = op;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlDataTable tblLeaveBalance = new HtmlDataTable();
    private HtmlDataTable tblLeaveBalanceForViewBalance = new HtmlDataTable();
    private HtmlDataTable tblLeaveBalanceAsofToDay = new HtmlDataTable();

    public HtmlDataTable getTblLeaveBalanceAsofToDay() {
        return tblLeaveBalanceAsofToDay;
    }

    public void setTblLeaveBalanceAsofToDay(HtmlDataTable tblLeaveBalanceAsofToDay) {
        this.tblLeaveBalanceAsofToDay = tblLeaveBalanceAsofToDay;
    }

    public HtmlDataTable getTblLeaveBalanceForViewBalance() {
        return tblLeaveBalanceForViewBalance;
    }

    public void setTblLeaveBalanceForViewBalance(HtmlDataTable tblLeaveBalanceForViewBalance) {
        this.tblLeaveBalanceForViewBalance = tblLeaveBalanceForViewBalance;
    }

    public HtmlDataTable getTblLeaveBalance() {
        return tblLeaveBalance;
    }

    public void setTblLeaveBalance(HtmlDataTable hdt) {
        this.tblLeaveBalance = hdt;
    }
    private ColumnGroup columnGroup1 = new ColumnGroup();

    public ColumnGroup getColumnGroup1() {
        return columnGroup1;
    }

    public void setColumnGroup1(ColumnGroup cg) {
        this.columnGroup1 = cg;
    }
    private HtmlGraphicImage gimgAttachedDocuments = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgAttachedDocuments() {
        return gimgAttachedDocuments;
    }

    public void setGimgAttachedDocuments(HtmlGraphicImage hgi) {
        this.gimgAttachedDocuments = hgi;
    }
    private HtmlCommandLink linkAction = new HtmlCommandLink();

    public HtmlCommandLink getLinkAction() {
        return linkAction;
    }

    public void setLinkAction(HtmlCommandLink hcl) {
        this.linkAction = hcl;
    }
    private PanelPopup pnlPopUpMsgConf = new PanelPopup();

    public PanelPopup getPnlPopUpMsgConf() {
        return pnlPopUpMsgConf;
    }

    public void setPnlPopUpMsgConf(PanelPopup pp) {
        this.pnlPopUpMsgConf = pp;
    }
    private HtmlOutputText lblPopUpMsgMainConf = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMainConf() {
        return lblPopUpMsgMainConf;
    }

    public void setLblPopUpMsgMainConf(HtmlOutputText hot) {
        this.lblPopUpMsgMainConf = hot;
    }
    private HtmlGraphicImage gimgPopUpMsgConf = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgPopUpMsgConf() {
        return gimgPopUpMsgConf;
    }

    public void setGimgPopUpMsgConf(HtmlGraphicImage hgi) {
        this.gimgPopUpMsgConf = hgi;
    }
    private HtmlCommandButton btnPopUpYesConf = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYesConf() {
        return btnPopUpYesConf;
    }

    public void setBtnPopUpYesConf(HtmlCommandButton hcb) {
        this.btnPopUpYesConf = hcb;
    }
    private HtmlCommandButton btnPopUpOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpOk() {
        return btnPopUpOk;
    }

    public void setBtnPopUpOk(HtmlCommandButton hcb) {
        this.btnPopUpOk = hcb;
    }
    private HtmlInputText txtCurrentDate = new HtmlInputText();

    public HtmlInputText getTxtCurrentDate() {
        return txtCurrentDate;
    }

    public void setTxtCurrentDate(HtmlInputText hit) {
        this.txtCurrentDate = hit;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel lblFormMessage) {
        this.lblFormMessage = lblFormMessage;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }
    private DateTimeConverter dateTimeConverter2 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter2() {
        return dateTimeConverter2;
    }

    public void setDateTimeConverter2(DateTimeConverter dtc) {
        this.dateTimeConverter2 = dtc;
    }
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }
    //End Of Local Variables
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
    private DefaultSelectedData defaultSelectedData15 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData15() {
        return defaultSelectedData15;
    }

    public void setDefaultSelectedData15(DefaultSelectedData dsd) {
        this.defaultSelectedData15 = dsd;
    }
    private DefaultSelectedData defaultSelectedData16 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData16() {
        return defaultSelectedData16;
    }

    public void setDefaultSelectedData16(DefaultSelectedData dsd) {
        this.defaultSelectedData16 = dsd;
    }
    private DefaultSelectedData defaultSelectedData17 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData17() {
        return defaultSelectedData17;
    }

    public void setDefaultSelectedData17(DefaultSelectedData dsd) {
        this.defaultSelectedData17 = dsd;
    }
    private DefaultSelectedData defaultSelectedData18 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData18() {
        return defaultSelectedData18;
    }

    public void setDefaultSelectedData18(DefaultSelectedData dsd) {
        this.defaultSelectedData18 = dsd;
    }
    private HtmlOutputText lblSelectResignresign = new HtmlOutputText();

    public HtmlOutputText getLblSelectResignresign() {
        return lblSelectResignresign;
    }

    public void setLblSelectResignresign(HtmlOutputText hot) {
        this.lblSelectResignresign = hot;
    }
    private HtmlOutputLabel lblMsgProcessed = new HtmlOutputLabel();

    public HtmlOutputLabel getLblMsgProcessed() {
        return lblMsgProcessed;
    }

    public void setLblMsgProcessed(HtmlOutputLabel hol) {
        this.lblMsgProcessed = hol;
    }
    private HtmlOutputLabel lblMsgProcessed2 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblMsgProcessed2() {
        return lblMsgProcessed2;
    }

    public void setLblMsgProcessed2(HtmlOutputLabel hol) {
        this.lblMsgProcessed2 = hol;
    }
    private HtmlCommandButton btnSaveLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveLeaveBalance() {
        return btnSaveLeaveBalance;
    }

    public void setBtnSaveLeaveBalance(HtmlCommandButton hcb) {
        this.btnSaveLeaveBalance = hcb;
    }
    private DefaultSelectedData defaultSelectedData19 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData19() {
        return defaultSelectedData19;
    }

    public void setDefaultSelectedData19(DefaultSelectedData dsd) {
        this.defaultSelectedData19 = dsd;
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
    private DefaultSelectedData defaultSelectedData23 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData23() {
        return defaultSelectedData23;
    }

    public void setDefaultSelectedData23(DefaultSelectedData dsd) {
        this.defaultSelectedData23 = dsd;
    }
    private DefaultSelectedData defaultSelectedData24 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData24() {
        return defaultSelectedData24;
    }

    public void setDefaultSelectedData24(DefaultSelectedData dsd) {
        this.defaultSelectedData24 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbDeath = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbDeath() {
        return ckbDeath;
    }

    public void setCkbDeath(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbDeath = hsbc;
    }
    private DefaultSelectedData defaultSelectedData121 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData121() {
        return defaultSelectedData121;
    }

    public void setDefaultSelectedData121(DefaultSelectedData dsd) {
        this.defaultSelectedData121 = dsd;
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
    private HtmlSelectOneMenu lstPhysicalYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstPhysicalYear() {
        return lstPhysicalYear;
    }

    public void setLstPhysicalYear(HtmlSelectOneMenu hsom) {
        this.lstPhysicalYear = hsom;
    }
    private DefaultSelectedData defaultSelectedData122 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData122() {
        return defaultSelectedData122;
    }

    public void setDefaultSelectedData122(DefaultSelectedData dsd) {
        this.defaultSelectedData122 = dsd;
    }

    public byte[] getAttachedDBImg1() {
        return attachedDBImg1;
    }

    public void setAttachedDBImg1(byte[] attachedDBImg1) {
        this.attachedDBImg1 = attachedDBImg1;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }
    private DefaultSelectedData defaultSelectedData123 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData123() {
        return defaultSelectedData123;
    }

    public void setDefaultSelectedData123(DefaultSelectedData dsd) {
        this.defaultSelectedData123 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlCommandButton btnDeleteLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteLeaveBalance() {
        return btnDeleteLeaveBalance;
    }

    public void setBtnDeleteLeaveBalance(HtmlCommandButton hcb) {
        this.btnDeleteLeaveBalance = hcb;
    }
    private DateTimeConverter dateTimeConverter3 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter3() {
        return dateTimeConverter3;
    }

    public void setDateTimeConverter3(DateTimeConverter dtc) {
        this.dateTimeConverter3 = dtc;
    }
    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(HtmlCommandButton hcb) {
        this.btnSearch = hcb;
    }
    private DefaultTableDataModel dataTable1Model2 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model2() {
        return dataTable1Model2;
    }

    public void setDataTable1Model2(DefaultTableDataModel dtdm) {
        this.dataTable1Model2 = dtdm;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlSelectBooleanCheckbox chkContrat = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkContrat() {
        return chkContrat;
    }

    public void setChkContrat(HtmlSelectBooleanCheckbox hsbc) {
        this.chkContrat = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkCivil = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkCivil() {
        return chkCivil;
    }

    public void setChkCivil(HtmlSelectBooleanCheckbox hsbc) {
        this.chkCivil = hsbc;
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
    private HtmlOutputText lblServiceYear = new HtmlOutputText();

    public HtmlOutputText getLblServiceYear() {
        return lblServiceYear;
    }

    public void setLblServiceYear(HtmlOutputText hot) {
        this.lblServiceYear = hot;
    }
    private HtmlOutputText lblHireDate = new HtmlOutputText();

    public HtmlOutputText getLblHireDate() {
        return lblHireDate;
    }

    public void setLblHireDate(HtmlOutputText hot) {
        this.lblHireDate = hot;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlGraphicImage employeePic = new HtmlGraphicImage();

    public HtmlGraphicImage getEmployeePic() {
        return employeePic;
    }

    public void setEmployeePic(HtmlGraphicImage hgi) {
        this.employeePic = hgi;
    }
    private PanelPopup pnlTransionHistory = new PanelPopup();

    public PanelPopup getPnlTransionHistory() {
        return pnlTransionHistory;
    }

    public void setPnlTransionHistory(PanelPopup pp) {
        this.pnlTransionHistory = pp;
    }
    private HtmlCommandButton btnRequesteDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnRequesteDate() {
        return btnRequesteDate;
    }

    public void setBtnRequesteDate(HtmlCommandButton hcb) {
        this.btnRequesteDate = hcb;
    }
    private DefaultSelectedData defaultSelectedData125 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData125() {
        return defaultSelectedData125;
    }

    public void setDefaultSelectedData125(DefaultSelectedData dsd) {
        this.defaultSelectedData125 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems7 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems7 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems9 = dsia;
    }
    private DefaultSelectedData defaultSelectedData126 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData126() {
        return defaultSelectedData126;
    }

    public void setDefaultSelectedData126(DefaultSelectedData dsd) {
        this.defaultSelectedData126 = dsd;
    }
    private DefaultSelectedData defaultSelectedData127 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData127() {
        return defaultSelectedData127;
    }

    public void setDefaultSelectedData127(DefaultSelectedData dsd) {
        this.defaultSelectedData127 = dsd;
    }
    private DefaultSelectedData defaultSelectedData128 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData128() {
        return defaultSelectedData128;
    }

    public void setDefaultSelectedData128(DefaultSelectedData dsd) {
        this.defaultSelectedData128 = dsd;
    }
    private DefaultSelectedData defaultSelectedData129 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData129() {
        return defaultSelectedData129;
    }

    public void setDefaultSelectedData129(DefaultSelectedData dsd) {
        this.defaultSelectedData129 = dsd;
    }
    private PanelLayout pnNotification = new PanelLayout();

    public PanelLayout getPnNotification() {
        return pnNotification;
    }

    public void setPnNotification(PanelLayout pl) {
        this.pnNotification = pl;
    }
    private HtmlInputText txtUsedLeaveAmount = new HtmlInputText();

    public HtmlInputText getTxtUsedLeaveAmount() {
        return txtUsedLeaveAmount;
    }

    public void setTxtUsedLeaveAmount(HtmlInputText hit) {
        this.txtUsedLeaveAmount = hit;
    }
    private DefaultSelectedData defaultSelectedData130 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData130() {
        return defaultSelectedData130;
    }

    public void setDefaultSelectedData130(DefaultSelectedData dsd) {
        this.defaultSelectedData130 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems10 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems10() {
        return selectOneMenu1DefaultItems10;
    }

    public void setSelectOneMenu1DefaultItems10(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems10 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems11 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems11() {
        return selectOneMenu1DefaultItems11;
    }

    public void setSelectOneMenu1DefaultItems11(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems11 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems12 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems12() {
        return selectOneMenu1DefaultItems12;
    }

    public void setSelectOneMenu1DefaultItems12(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems12 = dsia;
    }
    private DefaultSelectedData defaultSelectedData131 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData131() {
        return defaultSelectedData131;
    }

    public void setDefaultSelectedData131(DefaultSelectedData dsd) {
        this.defaultSelectedData131 = dsd;
    }
    private HtmlSelectOneMenu drlPhsicalYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPhsicalYear() {
        return drlPhsicalYear;
    }

    public void setDrlPhsicalYear(HtmlSelectOneMenu hsom) {
        this.drlPhsicalYear = hsom;
    }
    private DefaultSelectedData defaultSelectedData132 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData132() {
        return defaultSelectedData132;
    }

    public void setDefaultSelectedData132(DefaultSelectedData dsd) {
        this.defaultSelectedData132 = dsd;
    }
    private HtmlOutputText lblTotalAmount = new HtmlOutputText();

    public HtmlOutputText getLblTotalAmount() {
        return lblTotalAmount;
    }

    public void setLblTotalAmount(HtmlOutputText hot) {
        this.lblTotalAmount = hot;
    }
    private HtmlOutputText outTxt_LeaveAmount = new HtmlOutputText();

    public HtmlOutputText getOutTxt_LeaveAmount() {
        return outTxt_LeaveAmount;
    }

    public void setOutTxt_LeaveAmount(HtmlOutputText hot) {
        this.outTxt_LeaveAmount = hot;
    }
    private HtmlCommandButton btn_as_toDay = new HtmlCommandButton();

    public HtmlCommandButton getBtn_as_toDay() {
        return btn_as_toDay;
    }

    public void setBtn_as_toDay(HtmlCommandButton hcb) {
        this.btn_as_toDay = hcb;
    }
    private HtmlCommandButton btnPrepare = new HtmlCommandButton();

    public HtmlCommandButton getBtnPrepare() {
        return btnPrepare;
    }

    public void setBtnPrepare(HtmlCommandButton hcb) {
        this.btnPrepare = hcb;
    }
    private DefaultSelectedData defaultSelectedData133 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData133() {
        return defaultSelectedData133;
    }

    public void setDefaultSelectedData133(DefaultSelectedData dsd) {
        this.defaultSelectedData133 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkMakeReady = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMakeReady() {
        return chkMakeReady;
    }

    public void setChkMakeReady(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMakeReady = hsbc;
    }
    private HtmlCommandButton btnAddToTable = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddToTable() {
        return btnAddToTable;
    }

    public void setBtnAddToTable(HtmlCommandButton hcb) {
        this.btnAddToTable = hcb;
    }

     private PanelPopup pnMessageForEmployeeStatus = new PanelPopup();
      private javax.faces.component.html.HtmlOutputLabel lblFormMessage1EmployeeStatus = new javax.faces.component.html.HtmlOutputLabel();

    public PanelPopup getPnMessageForEmployeeStatus() {
        return pnMessageForEmployeeStatus;
    }

    public void setPnMessageForEmployeeStatus(PanelPopup pnMessageForEmployeeStatus) {
        this.pnMessageForEmployeeStatus = pnMessageForEmployeeStatus;
    }

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessage1EmployeeStatus() {
        return lblFormMessage1EmployeeStatus;
    }

    public void setLblFormMessage1EmployeeStatus(javax.faces.component.html.HtmlOutputLabel lblFormMessage1EmployeeStatus) {
        this.lblFormMessage1EmployeeStatus = lblFormMessage1EmployeeStatus;
    }



    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public BalancePage()
    {
        visible = false;
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
    public void prerender()
                {

        loggedInUserId = getSessionBean1().getEmployeeId();
        employeeListExpiranceLessThanOne= leaveBalanceManager.selectAllEmployeeExpiranceLessThanOneYear();
        employeeListSizeExplessOne=employeeListExpiranceLessThanOne.size();
        
        for(int couter=0;couter<employeeListSizeExplessOne;couter++)
           {
        employeeIDExpLessOne=employeeListExpiranceLessThanOne.get(couter).getEmpIDLessThatnOneYear();
        employeeHireDateForExpLessOne=employeeListExpiranceLessThanOne.get(couter).getHirDateLessThnaOneYear();
        String hireDate1 = employeeHireDateForExpLessOne;
        currentYear = GregorianCalendarManipulation.getYear(currentDate);
        expTotal = GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceReturnTypeArrayListForLeave(hireDate1, currentDate);
        boolean newFlag=leaveBalanceManager.EmployeeLeaveRegister(employeeIDExpLessOne);
        int Dates = Integer.parseInt(expTotal[0]);
        int months = Integer.parseInt(expTotal[1]);
        int years = Integer.parseInt(expTotal[2]);
        int monthToDays = (months * 30);
        int totalDays = (monthToDays + Dates);
        int lastLeaveBalanceYear = (currentYear - 1);
        int lastLeaveAmount = 0;
        int nextyearLeaveAmount;
        int commingLeaveAmount;
        float devidend;
        float divisor = 360;
        String remaing;
        int flag=1;
        if (years == 0)
           {
            remaing = "0.0";
            nextyearLeaveAmount = 16;
            devidend = (totalDays * nextyearLeaveAmount);
            result = (devidend / divisor);
            Float reme = new Float(remaing);
           // totalasofToday = (reme + result);
            totalasofToday = (this.roundTo(result));
                 
          if(newFlag)
          {
           leaveBalanceManager.UPDateEmployeeLeaveBalanceLessOneYearExp(employeeIDExpLessOne,currentYear,totalasofToday,flag);
          }
          else{
            leaveBalanceManager.SaveEmployeeLeaveBalanceLessOneYearExp(employeeIDExpLessOne,currentYear,totalasofToday,flag);
          }
        }
       
        }
        employeeList= leaveBalanceManager.selectAllEmployee();
        employeeListSize=employeeList.size();
        
       for(int counter=0; counter<employeeListSize;counter++)
          {
       employeeIDFromList=employeeList.get(counter).getEmployeeID();
       employeeHireDateForList=employeeList.get(counter).getHireDate();
       this.UpdateEmployeeLeveBalanceForNewYearBalance(employeeIDFromList);
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
    int employeeListSize;
    int employeeListSizeExplessOne;
    String employeeIDFromList;
    String employeeIDExpLessOne;
    String employeeHireDateForList;
    String employeeHireDateForExpLessOne;
    String status;
    public  float totalasofToday;
    public int currentYear;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public float getTotalasofToday() {
        return totalasofToday;
    }

    public void setTotalasofToday(float totalasofToday) {
        this.totalasofToday = totalasofToday;
    }

    public String getEmployeeHireDateForExpLessOne() {
        return employeeHireDateForExpLessOne;
    }

    public void setEmployeeHireDateForExpLessOne(String employeeHireDateForExpLessOne) {
        this.employeeHireDateForExpLessOne = employeeHireDateForExpLessOne;
    }

    public String getEmployeeIDExpLessOne() {
        return employeeIDExpLessOne;
    }

    public void setEmployeeIDExpLessOne(String employeeIDExpLessOne) {
        this.employeeIDExpLessOne = employeeIDExpLessOne;
    }

    public int getEmployeeListSizeExplessOne() {
        return employeeListSizeExplessOne;
    }

    public void setEmployeeListSizeExplessOne(int employeeListSizeExplessOne) {
        this.employeeListSizeExplessOne = employeeListSizeExplessOne;
    }

    public String getEmployeeHireDateForList() {
        return employeeHireDateForList;
    }

    public void setEmployeeHireDateForList(String employeeHireDateForList) {
        this.employeeHireDateForList = employeeHireDateForList;
    }

    public String getEmployeeIDFromList() {
        return employeeIDFromList;
    }

    public void setEmployeeIDFromList(String employeeIDFromList) {
        this.employeeIDFromList = employeeIDFromList;
    }

    public int getEmployeeListSize() {
        return employeeListSize;
    }

    public void setEmployeeListSize(int employeeListSize) {
        this.employeeListSize = employeeListSize;
    }
    
//****************************************for pop up effects*****************

    public Object getEffectWindow() {
        return effectWindow;
    }

    public void setEffectWindow(Object effectWindow) {
        this.effectWindow = effectWindow;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void openPopup() {
        effectWindow = new Appear();
    //    visible = true;
    }

    public void closePopup() {
        effectWindow = new Fade();
    //    visible = false;
    }

//Validation Patterns
    private void validateDateTime(FacesContext context, UIComponent component, Object value)
    {
        String patternName = "[0-9]\\{4\\}-[0-9]\\{2\\}-[0-9]\\{2\\}";
        boolean matchStringText = Pattern.matches(patternName, (CharSequence) (value.toString()));
        if (matchStringText == false) {
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            ((UIInput) component).setValid(false);
            error(component, messageResource.getString("ETdateVaild"));
        }
    }
      public float roundTo(float number) {
        int decimalPlaces = 1;
        BigDecimal roundNo = new BigDecimal(number);
        roundNo = roundNo.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        return roundNo.floatValue();
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    private int selectedRow;

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public String getAttachedDocumentPath() {
        return attachedDocumentPath;
    }

    public void setAttachedDocumentPath(String attachedDocumentPath) {
        this.attachedDocumentPath = attachedDocumentPath;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public String getComponentStatus() {
        return componentStatus;
    }

    public void setComponentStatus(String componentStatus) {
        this.componentStatus = componentStatus;
    }

    public FileInfo getCurrentFile() {
        return currentFile;
    }

    public int getFileProgress() {
        return fileProgress;
    }

    public ArrayList<LeaveBalance> getEmployeeLeaveBalace() {
        return employeeLeaveBalace;
    }

    public void setEmployeeLeaveBalace(ArrayList<LeaveBalance> employeeLeaveBalace) {
        this.employeeLeaveBalace = employeeLeaveBalace;
    }
    public static class EmoloyeeList {
        String employeeID;
        String hireDate;
        String empIDLessThatnOneYear;
        String hirDateLessThnaOneYear;
        String expirance;
        String flag;

        public EmoloyeeList(String employeeID, String hireDate) {
            this.employeeID=employeeID;
            this.hireDate=hireDate;
        }

        public EmoloyeeList(String employeeId, String hireDate, String expirance) {
            this.empIDLessThatnOneYear=employeeId;
            this.hirDateLessThnaOneYear=hireDate;
            this.expirance=expirance;
           
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getExpirance() {
            return expirance;
        }

        public void setExpirance(String expirance) {
            this.expirance = expirance;
        }

        public String getEmpIDLessThatnOneYear() {
            return empIDLessThatnOneYear;
        }

        public void setEmpIDLessThatnOneYear(String empIDLessThatnOneYear) {
            this.empIDLessThatnOneYear = empIDLessThatnOneYear;
        }

        public String getHirDateLessThnaOneYear() {
            return hirDateLessThnaOneYear;
        }

        public void setHirDateLessThnaOneYear(String hirDateLessThnaOneYear) {
            this.hirDateLessThnaOneYear = hirDateLessThnaOneYear;
        }

        public String getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }


    }

    public static class LeaveBalance implements Serializable {

        private String leaveBalaceId;
        private String employeeId;
        private String physicalYear;
        private int year;
        private int amount;
        private float amountt;
        private String leaveAmount;
        private String usedLeaveAmount;
        private String employeeFullName;
        private String reminingLeaveAmout;
        private float leaveAsofToDay;
        private boolean fromReserveLeave;
        private boolean selected;

        public float getAmountt() {
            return amountt;
        }

        public void setAmountt(float amountt) {
            this.amountt = amountt;
        }

        public float getLeaveAsofToDay() {
            return leaveAsofToDay;
        }

        public void setLeaveAsofToDay(float leaveAsofToDay) {
            this.leaveAsofToDay = leaveAsofToDay;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getReminingLeaveAmout() {
            return reminingLeaveAmout;
        }

        public void setReminingLeaveAmout(String reminingLeaveAmout) {
            this.reminingLeaveAmout = reminingLeaveAmout;
        }

        public boolean isFromReserveLeave() {
            return fromReserveLeave;
        }

        public void setFromReserveLeave(boolean fromReserveLeave) {
            this.fromReserveLeave = fromReserveLeave;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getUsedLeaveAmount() {
            return usedLeaveAmount;
        }

        public void setUsedLeaveAmount(String usedLeaveAmount) {
            this.usedLeaveAmount = usedLeaveAmount;
        }

        public String getPhysicalYear() {
            return physicalYear;
        }

        public void setPhysicalYear(String PhysicalYear) {
            this.physicalYear = PhysicalYear;
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

        public String getLeaveAmount() {
            return leaveAmount;
        }

        public void setLeaveAmount(String leaveAmount) {
            this.leaveAmount = leaveAmount;
        }

        public String getLeaveBalaceId() {
            return leaveBalaceId;
        }

        public void setLeaveBalaceId(String leaveBalaceId) {
            this.leaveBalaceId = leaveBalaceId;
        }

        public LeaveBalance(String leaveBalaceId,
                String employeeId,
                String PhysicalYear,
                String leaveAmount,
                String employeeFullName,
                String usedLeaveAmount,
                String reminingLeaveAmout,
                boolean fromReserveLeave) {
            this.leaveBalaceId = leaveBalaceId;
            this.employeeId = employeeId;
            this.physicalYear = PhysicalYear;
            this.leaveAmount = leaveAmount;
            this.employeeFullName = employeeFullName;
            this.usedLeaveAmount = usedLeaveAmount;
            this.reminingLeaveAmout = reminingLeaveAmout;
            this.fromReserveLeave = fromReserveLeave;
        }

        public LeaveBalance(String leaveBalaceId,
                String employeeId,
                int PhysicalYear,
                int leaveAmount,
                String employeeFullName,
                String usedLeaveAmount,
                String reminingLeaveAmout,
                boolean fromReserveLeave) {
            this.leaveBalaceId = leaveBalaceId;
            this.employeeId = employeeId;
            this.year = PhysicalYear;
            this.amount = leaveAmount;
            this.employeeFullName = employeeFullName;
            this.usedLeaveAmount = usedLeaveAmount;
            this.reminingLeaveAmout = reminingLeaveAmout;
            this.fromReserveLeave = fromReserveLeave;
        }
         public LeaveBalance(String leaveBalaceId,
                String employeeId,
                int PhysicalYear,
                float leaveAmount,
                String employeeFullName,
                String usedLeaveAmount,
                String reminingLeaveAmout,
                boolean fromReserveLeave) {
            this.leaveBalaceId = leaveBalaceId;
            this.employeeId = employeeId;
            this.year = PhysicalYear;
            this.amountt = leaveAmount;
            this.employeeFullName = employeeFullName;
            this.usedLeaveAmount = usedLeaveAmount;
            this.reminingLeaveAmout = reminingLeaveAmout;
            this.fromReserveLeave = fromReserveLeave;
        }
    }

    public void uploadActionListener(ActionEvent actionEvent) {
    }

    /**
     * <p>This method is bound to the inputFile component and is executed
     * multiple times during the file upload process.  Every call allows
     * the user to finds out what percentage of the file has been uploaded.
     * This progress information can then be used with a progressBar component
     * for user feedback on the file upload progress. </p>
     *
     * @param event holds a InputFile object in its source which can be probed
     *              for the file upload percentage complete.
     */
    public void progressListener(EventObject event) {
        InputFile ifile = (InputFile) event.getSource();
        fileProgress = ifile.getFileInfo().getPercent();
    }

    //*************************************End OfDocument Attachement Inner Classes and Releted Methods and Variables *****************************************************
    private Option[] dpResignTypes;

    public Option[] getDpResignTypes() {
        return dpResignTypes;
    }

    public void setDpResignTypes(Option[] dpResignTypes) {
        this.dpResignTypes = dpResignTypes;
    }

    public ArrayList<SelectItem> getPysicalLeaveTypes() {
        return pysicalLeaveTypes;
    }

    public void setPysicalLeaveTypes(ArrayList<SelectItem> pysicalLeaveTypes) {
        this.pysicalLeaveTypes = pysicalLeaveTypes;
    }
    private SearchCriterias serachIdName = new SearchCriterias();

    public SearchCriterias getSerachIdName() {
        return serachIdName;
    }

    public void setSerachIdName(SearchCriterias dsia) {
        this.serachIdName = dsia;
    }

    private void loadEmployeeProfileDetail(String empId) {
        try {
            employeeManager.loadEmpoyeeProfile(empId);
            lblFullName.setValue(employeeManager.getFirst_Name() + " " +
            employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            sex = employeeManager.getSex();
            lblPosition.setValue(employeeManager.getJobName());
            int expYear = employeeManager.calculateServiceYear(empId);
            lblServiceYear.setValue(String.valueOf(expYear));
            lblHireDate.setValue(employeeManager.getHire_Date());
            lblDepartment.setValue(employeeManager.departmentDetileDescription(
                    employeeManager.getDepartmentId()) + " ]");
            if (sex.equalsIgnoreCase("Male")) {
                cbMale.setSelected(true);
            } else if (sex.equalsIgnoreCase("Female")) {
                cbFemale.setSelected(true);
            } else {
                cbMale.setSelected(false);
                cbFemale.setSelected(false);
            }
            String employeeType = employeeManager.getOfficeOrShift();
            if (!HRValidation.validateRequired(txtEmployeeId.getValue())) {
                txtEmployeeId.setValue(empId);
            }

            if (employeeType.equalsIgnoreCase("Office")) {
                chkCivil.setSelected(true);
            } else {
                chkContrat.setSelected(true);
            }

            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
            loadEmployeeLeaveBalance(txtEmployeeId.getValue().toString());
            try {
                setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
                imgEmployeePicture.setValue(getAttachedDBImg());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
        }
    }

    private void loadEmployeeProfile(String empId) {
        try {
            txtEmployeeId.resetValue();
            employeeManager.loadEmpoyeeProfile(empId);
            lblFullName.setValue(employeeManager.getFirst_Name() + " " +
            employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            sex = employeeManager.getSex();
            lblPosition.setValue(employeeManager.getJobName());
            int expYear = employeeManager.calculateServiceYear(empId);
            lblServiceYear.setValue(String.valueOf(expYear));
            lblHireDate.setValue(employeeManager.getHire_Date());
            lblDepartment.setValue(employeeManager.departmentDetileDescription(
             employeeManager.getDepartmentId()) + " ]");

            if (sex.equalsIgnoreCase("Male")) {
                cbMale.setSelected(true);
            } else if (sex.equalsIgnoreCase("Female")) {
                cbFemale.setSelected(true);
            } else {
                cbMale.setSelected(false);
                cbFemale.setSelected(false);
            }
            String employeeType = employeeManager.getOfficeOrShift();
            if (!HRValidation.validateRequired(txtEmployeeId.getValue())) {
                txtEmployeeId.setValue(empId);
            }

            if (employeeType.equalsIgnoreCase("Office")) {
                chkCivil.setSelected(true);
            } else {
                chkContrat.setSelected(true);
            }
            hireDate = employeeManager.getHire_Date();
            currentDate = dateFormat.format(new Date());

            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
          //  UpdateEmployeeLeveBalanceForNewYearBalance(empId);
            loadEmployeeLeaveBalance(txtEmployeeId.getValue().toString());
            txtEmployeeId.setValue(empId);
            try {
                setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
                imgEmployeePicture.setValue(getAttachedDBImg());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
        }
    }

    public void UpdateEmployeeLeveBalanceForNewYearBalance(String empID)
        {
        String[] hire = employeeHireDateForList.split("-");
        //String[] hire = hireDate.split("-");
        String[] current = currentDate.split("-");
        int yearHire = Integer.parseInt(hire[0]);
        int monhtHire = Integer.parseInt(hire[1]);
        int dateHire = Integer.parseInt(hire[2]);
        int currentYear = Integer.parseInt(current[0]);
        int currentmonth = Integer.parseInt(current[1]);
        int currentdate = Integer.parseInt(current[2]);
        String[] llbalance = leaveBalanceManager.SelectLastBalanceOFEmployeeForLeaveWithOutPay(empID).split("-");
        float lastLeaveAmount = Float.parseFloat(llbalance[0]);
       // float used = Float.parseFloat(llbalance[1]);
        int lastyearLeave = Integer.parseInt(llbalance[2]);
        float newLeaAmount = (lastLeaveAmount + 1);
        int yearshoudbe = (lastyearLeave + 1);

        if ((currentmonth >= monhtHire) && (currentdate>=dateHire) && (yearshoudbe == currentYear))
        {
              leaveBalanceManager.SaveNewYearLeaveForEmployee(empID, newLeaAmount, yearshoudbe);

        }

    }

    public void modalPnlCloseBtn_processAction(ActionEvent ae) {
        pnlPopUpResignTye.setRendered(false);
    }

    public void lnkResignationType_processAction(ActionEvent ae) {
    }

    private void loadResignationTypeDetails(String _resignId) {
        ckbVoluntary.setSelected(false);
        ckbDismisalInvoluntary.setSelected(false);
        ckbLayOff.setSelected(false);
        ckbOtherInvoluntary.setSelected(false);
        ckbDeath.setSelected(false);
        HashMap terReq = retirementLookUpManager.readResignationTypeDetails(_resignId);
        txtResignationType.setValue(terReq.get("resignName"));
        txtResignationTypeDescription.setValue(terReq.get("resignDescription"));
        group_SettingsDB = (String) terReq.get("resignGroup");
        if (group_SettingsDB.equals("1")) {
            ckbVoluntary.setSelected(true);
        } else if (group_SettingsDB.equals("2")) {
            ckbDismisalInvoluntary.setSelected(true);
        } else if (group_SettingsDB.equals("3")) {
            ckbLayOff.setSelected(true);
        } else if (group_SettingsDB.equals("4")) {
            ckbOtherInvoluntary.setSelected(true);
        } else if (group_SettingsDB.equals("5")) {
            ckbDeath.setSelected(true);
        }

    }

    public void lstResignationTyes_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            resignID = vce.getNewValue().toString();
            lblHResignationTypeID.setValue(resignID);
            try {
                loadResignationTypeDetails(resignID);
            } catch (Exception ex) {
            }
        }
    }

    public void btnResignNew_processAction(ActionEvent ae) {
    }

    public void btnResignCancel_processAction(ActionEvent ae) {
    }

    public void btnResignSave_processAction(ActionEvent ae) {
    }

    public void btnResignEdit_processAction(ActionEvent ae) {
    }

    public void btnResignUpdate_processAction(ActionEvent ae) {
    }

    public void btnResignDelete_processAction(ActionEvent ae) {
    }

    private int CheckEmployeeId(String empId) {
        try {
            return transferManager.CheckEmployeeId(empId);
        } catch (Exception ex) {
            return 0;
        }
    }

    public String txtSearByName_action()
    {
        getEmployeeLeaveBalace().clear();//clear the current uploaded file inorder to ignor data repeatition
        selectedId = getSelectedEmployeeId();
        try {
            getEmployeeLeaveBalace().clear();
            lblDepartment.setValue(null);
            lblFullName.setValue(null);
            lblPosition.setValue(null);
            lblServiceYear.setValue(null);
            lblHireDate.setValue(null);
            lblServiceYear.setValue(null);
            cbMale.resetValue();
            cbFemale.resetValue();
            chkCivil.resetValue();
            chkContrat.resetValue();
            cbFemale.setSelected(false);
            cbMale.setSelected(false);
            chkCivil.setSelected(false);
            chkContrat.setSelected(false);
            txtEmployeeId.resetValue();
            imgEmployeePicture.setValue("");



        } catch (Exception ex) {
        }
        return null;
    }

    public void btnPopUpOk_processAction(ActionEvent ae) {
        // btnYes = true;
        btnYes = false;
        pnlPopUpMsg.setRendered(false);
    }

    public void btnPopUpYes_processAction(ActionEvent ae) {
        btnYes = true;
        if (btnYes == true) {
            pnlPopUpMsg.setRendered(false);
            this.loadEmployeeProfileDetail(selectedId);
            txtEmployeeId.setValue(selectedId);
            setSearchTerminationRequestValue(txtEmployeeId.getValue().toString());
            setSearchTerminationRequestValueTemp(txtEmployeeId.getValue().toString());
        }
    }

    public void btnPopUpNo_processAction(ActionEvent ae) {
        btnNo = true;
        if (btnNo == true) {
            pnlPopUpMsg.setRendered(false);
            txtEmployeeId.setValue(null);
            //  dpResignationTypes.setValue("--- Select Resign Type ---");
            lblDepartment.setValue(null);
            lblFullName.setValue(null);
            lblPosition.setValue(null);
            lblServiceYear.setValue(null);
            lblHireDate.setValue(null);
            cbMale.setSelected(false);
            cbFemale.setSelected(false);
        }

    }

    public void hlnkRequestCommented_processAction(ActionEvent ae) {
    }

    public void modalPnlCloseBtnRequestCommented_processAction(ActionEvent ae) {
        pnlPopUpRequestCommented.setRendered(false);
    }

    public void modalPnlCloseBtnRequestProcessed_processAction(ActionEvent ae) {
        pnlPopUpRequestProcessed.setRendered(false);
    }

    public void lnkTerminationApprovalComment_processAction(ActionEvent ae) {
    }

    public void txtSearByName_processValueChange(ValueChangeEvent vce) {
//        autoCompleteDictionary.init(vce.getNewValue().toString());
    }

    public String lnkTerminationApproval_action() {
        //return null means stay on the same page
        return "TerminationApproval";
    }

    public void ckbVoluntary_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbVoluntary.isSelected()) {
                ckbDismisalInvoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting = "1";
            }
        }
    }

    public void ckbDismisalInvoluntary_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbDismisalInvoluntary.isSelected()) {
                ckbVoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting = "2";
            }
        }
    }

    public void ckbLayOff_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbLayOff.isSelected()) {
                ckbVoluntary.setSelected(false);
                ckbDismisalInvoluntary.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting = "3";
            }
        }
    }

    public void ckbOtherInvoluntary_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbOtherInvoluntary.isSelected()) {
                ckbVoluntary.setSelected(false);
                ckbDismisalInvoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                group_Setting = "4";
            }
        }
    }

    public String btnResignCancel_action() {
        //return null means stay on the same page
        txtResignationType.setDisabled(true);
        txtResignationTypeDescription.setDisabled(true);
        lstResignationTyes.setDisabled(false);
        if (btnResignNew.getValue().equals("Save")) {
            txtResignationType.setValue(null);
            txtResignationTypeDescription.setValue(null);
            ckbVoluntary.setSelected(false);
            ckbDismisalInvoluntary.setSelected(false);
            ckbLayOff.setSelected(false);
            ckbOtherInvoluntary.setSelected(false);
            btnResignNew.setValue("New");
            ckbVoluntary.setDisabled(true);
            ckbDismisalInvoluntary.setDisabled(true);
            ckbLayOff.setDisabled(true);
            ckbOtherInvoluntary.setDisabled(true);
            ckbDeath.setDisabled(true);
            ckbDeath.setSelected(false);
            btnResignDelete.setDisabled(false);
            btnResignEdit.setDisabled(false);
            btnResignNew.setDisabled(false);
            btnResignCancel.setDisabled(true);
        } else if (btnResignEdit.getValue().equals("Update")) {
            btnResignDelete.setDisabled(false);
            btnResignEdit.setDisabled(false);
            btnResignNew.setDisabled(false);

            btnResignCancel.setDisabled(true);

            ckbVoluntary.setDisabled(true);
            ckbDismisalInvoluntary.setDisabled(true);
            ckbLayOff.setDisabled(true);
            ckbOtherInvoluntary.setDisabled(true);
            ckbDeath.setDisabled(true);
            btnResignEdit.setValue("Edit");
        }
        return null;
    }

    public void btnAttachDocument_processAction(ActionEvent ae) {
        pnlPopUpAttachment.setRendered(true);

    }

    public String tblDocumentAttached_firstPageAction() {
        {
            return null;
        }
    }

    public String tblDocumentAttached_previousPageAction() {
        {
            return null;
        }
    }

    public String tblDocumentAttached_nextPageAction() {
        {
            return null;
        }
    }

    public String tblDocumentAttached_lastPageAction() {
        {
            return null;
        }
    }

    public void modalPnlCloseBtnAttachment_processAction(ActionEvent ae) {
        pnlPopUpAttachment.setRendered(false);
    }

    public String lnkDocumentAttached_action() {
        selectedRow = tblLeaveBalance.getRowIndex();
        String documentId = String.valueOf(employeeLeaveBalace.get(selectedRow).leaveBalaceId);
        try {
            HashMap terReq = transferManager.readAttachedDocuments(documentId);
            OracleSerialBlob blo = (OracleSerialBlob) terReq.get("docPath");
            setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
            gimgAttachedDocuments.setValue(getAttachedDBImg());
            pnlPopUpAttachment.setRendered(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void btnPopUpYesConf_processAction(ActionEvent ae) {
    }

    public void btnPopUpNoConf_processAction(ActionEvent ae) {
    }

    public String btnPopUpYes_action() {
        pnlPopUpMsg.setRendered(false);
        if (selecteLeaveBalanceRow != -1) {
            LeaveBalance leaveBalanceInfo = getEmployeeLeaveBalace().get(selecteLeaveBalanceRow);
            if (!leaveBalanceInfo.isFromReserveLeave()) {
                if (leaveBalanceManager.deleteEmployeeLeaveBalance(leaveBalanceInfo.getLeaveBalaceId())) {
                    getEmployeeLeaveBalace().remove(selecteLeaveBalanceRow);
                    selecteLeaveBalanceRow = -1;
                    clearLaveBalnceComponents();
                    disableLaveBalnceComponents();
                    loadEmployeeLeaveBalance(txtEmployeeId.getValue().toString());
                    showSuccessOrFailureMessage(true, "Employee Leave Balance information Deleted successfully.");
                } else {
                    showSuccessOrFailureMessage(false, "Employee Leave Balance information Not Deleted .Please try again ?");
                }
            } else {
                showSuccessOrFailureMessage(false, "You Can't Delete This Employee Leave  information.");
            }
        } else {
        }
        //return null means stay on the same page
        return null;
    }

    public static class StateTransitionIC implements Serializable {
    }

    public String calDateRequet_action() {
        //return null means stay on the same page
        return null;
    }

//    public void txtDateRequest_validate(FacesContext context, UIComponent component, Object value)
//    {
//        //   validateDateTime(context, component, value);
//    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: " +
                " bold;text-align: center; vertical-align: middle" : "color: red; " +
                " font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
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

    public void notification(String messageToDisplay) {
        pnNotification.setRendered(true);
        String javaScriptText = "$j(document).ready(function(){" +
                " $j('#demo12').click(function() {" +
                " $j.growlUI('Transfer Notification', '" + messageToDisplay + "');" +
                "});" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    private ArrayList<HashMap> leaveBalanceInformation() {
        ArrayList<HashMap> balanceList = new ArrayList<HashMap>();
        if (tblLeaveBalance.getRowCount() > 0) {
            for (LeaveBalance employeeLeave : getEmployeeLeaveBalace().subList(tableSize, tableSize + rowCounter)) {
                HashMap _list = new HashMap();
                _list.put("employeeId", employeeLeave.getEmployeeId());
                _list.put("leaveAmount", employeeLeave.getLeaveAmount());
                _list.put("usedLeaveAmount", employeeLeave.getUsedLeaveAmount());
                _list.put("physicalYear", employeeLeave.getPhysicalYear());
                balanceList.add(_list);
            }

        }
        return balanceList;
    }

    private ArrayList<HashMap> leaveBalanceInformationNew() {
        ArrayList<HashMap> balanceList = new ArrayList<HashMap>();
        if (tblLeaveBalance.getRowCount() > 0) {
            for (LeaveBalance employeeLeave : getEmployeeLeaveBalace().subList(tableSize, tableSize + rowCounter)) {
                HashMap _list = new HashMap();
                _list.put("employeeId", employeeLeave.getEmployeeId());
                _list.put("leaveAmount", employeeLeave.getAmountt());
                _list.put("usedLeaveAmount", employeeLeave.getUsedLeaveAmount());
                _list.put("physicalYear", employeeLeave.getYear());
                balanceList.add(_list);
            }

        }
        return balanceList;
    }

    private ArrayList<HashMap> updatableleaveBalanceInformation() {
        ArrayList<HashMap> balanceList = new ArrayList<HashMap>();
        if (tblLeaveBalance.getRowCount() > 0) {
            for (LeaveBalance employeeLeave : getEmployeeLeaveBalaceUpdate()) {
                HashMap _list = new HashMap();
                _list.put("employeeId", employeeLeave.getEmployeeId());
                _list.put("leaveAmount", employeeLeave.getAmount());
                _list.put("balanceId", employeeLeave.getLeaveBalaceId());
                _list.put("physicalYear", employeeLeave.getYear());
                _list.put("usedLeaveAmount", employeeLeave.getUsedLeaveAmount());
                if (employeeLeave.isFromReserveLeave()) {
                    _list.put("isFromReserveLeave", "YES");
                } else {
                    _list.put("isFromReserveLeave", "NO");
                }


                balanceList.add(_list);
            }

        }
        return balanceList;
    }

    public void btnCancelTerminationRequest_processAction(ActionEvent ae) {
    }

    public String btnCancelTerminationRequest_action() {
        txtEmployeeId.resetValue();
        lblFullName.setValue(null);
        lblDepartment.setValue(null);
        lblPosition.setValue(null);
        lblServiceYear.setValue(null);
        lblHireDate.setValue(null);
        lstPhysicalYear.resetValue();
        txtCurrentDate.resetValue();
        lstResignationTyes.resetValue();
        chkCivil.setSelected(false);
        chkCivil.resetValue();
        chkContrat.setSelected(false);
        chkContrat.resetValue();
        cbFemale.setSelected(false);
        cbFemale.resetValue();
        cbMale.setSelected(false);
        cbMale.resetValue();
        imgEmployeePicture.setValue("");
        lstPhysicalYear.setValue("0");
        getEmployeeLeaveBalace().clear();
        btnRequesteDate.setDisabled(true);
        lstPhysicalYear.setDisabled(true);
        txtCurrentDate.setDisabled(true);
        btnSaveLeaveBalance.setDisabled(true);
        btnCancelLeaveBalance.setDisabled(true);
        btnNewLeaveBalance.setDisabled(false);
        btnEditLeaveBalance.setDisabled(true);
        btnUpdateLeaveBalance.setDisabled(true);
        btnDeleteLeaveBalance.setDisabled(true);
        return null;
    }

    public void ddRTypes_processValueChange(ValueChangeEvent vce) {
    }

    public EmployeeList getCurrentEmployee1() {
        return currentEmployee1;
    }
    private String selectedEmployeeId;

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public String lnkResignationType_action() {
        //return null means stay on the same page
        pnlPopUpResignTye.setRendered(true);
        pnlPopUpResignTye.setVisible(true);
        return null;
    }

    public void ckbDeath_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbDeath.isSelected()) {
                ckbDismisalInvoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                ckbVoluntary.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting =
                        "5";
            }

        }
    }

    public String btnResignEdit_action() {
        return null;
    }

    public String btnResignDelete_action() {
        //return null means stay on the same page
        try {
            retirementLookUpManager.DeleteTerminationType(lblHResignationTypeID.getValue().toString());
            txtResignationType.setValue(null);
            txtResignationTypeDescription.setValue(null);
            ckbVoluntary.setSelected(false);
            ckbDismisalInvoluntary.setSelected(false);
            ckbLayOff.setSelected(false);
            ckbOtherInvoluntary.setSelected(false);
        } catch (Exception ex) {
        }
        return null;
    }

    public String btnSearch_action() {
        try {
            if (HRValidation.validateRequired(txtEmployeeId.getValue())) {
                getEmployeeLeaveBalace().clear();
                lblDepartment.setValue(null);
                lblFullName.setValue(null);
                lblPosition.setValue(null);
                lblServiceYear.setValue(null);
                lblHireDate.setValue(null);
                lblServiceYear.setValue(null);
                cbMale.resetValue();
                cbFemale.resetValue();
                chkCivil.resetValue();
                chkContrat.resetValue();
                cbFemale.setSelected(false);
                cbMale.setSelected(false);
                chkCivil.setSelected(false);
                chkContrat.setSelected(false);
                loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
            } else {
                showSuccessOrFailureMessage(true, "Please enter employee id ?");
                ((UIInput) txtEmployeeId).setValid(false);
                error(txtEmployeeId, "Required");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public String btnTransionHistoryClose_action() {
        //return null means stay on the same page
        pnlTransionHistory.setRendered(false);
        return null;
    }

    public String lnkRequestPeriod_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkResignTypeSetting_action() {
        pnlPopUpResignTye.setRendered(true);
        return null;
    }

    public String lnkResignRequest_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkRetireRequest_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkResignApprove_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkRetireApprove_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkTerminationClearance_action() {
        //return null means stay on the same page
        return "TerminationClearance";
    }

    public String lnkTerminationReports_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkResignApprovePage_action() {
        //return null means stay on the same page
        return "LeaveRequest";
    }

    public String lnkClearancePage_action() {
        //return null means stay on the same page
        return "LeaveApprove";
    }

    boolean isNotduplicated() {


        for (LeaveBalance leaveBalance : employeeLeaveBalace) {
            if (leaveBalance.getPhysicalYear().equals(lstPhysicalYear.getValue().toString())) {
                return false;
            }
        }
        return true;
    }


    ////////////////////////////////////////////////////NewBirukAddButton/////////////////////////////////////////////
    public String btnAddToTableNew_action()
    {
        String[] hireDate = lblHireDate.getValue().toString().split("-");
        year = Integer.parseInt(hireDate[0]);
        serviceYear = Integer.parseInt(lblServiceYear.getValue().toString());
        leaveAmount= 16;
        for (int counter = 0; counter <= serviceYear; counter++)
                  {
          
            if (isNotduplicated())
            {

                LeaveBalance leaveBalance = new LeaveBalance(
                        leaveBalanceId,
                        txtEmployeeId.getValue().toString(),
                        year,
                        leaveAmount,
                        lblFullName.getValue().toString(),
                        "0",
                        "0",
                        isFromReserveLeave());
                year++;
                leaveAmount++;
                if (this.buttonIdentifierLeaveBalance == 1 || buttonIdentifierLeaveBalance == 2)
                {
                    rowCounter++;
                    employeeLeaveBalace.add(leaveBalance);

                }
                else if (buttonIdentifierLeaveBalance == 3)
                {
                    this.employeeLeaveBalace.add(this.selecteLeaveBalanceRow, leaveBalance);
                    this.employeeLeaveBalaceUpdate.add(leaveBalance);
                    btnUpdateLeaveBalance.setDisabled(false);
                    disableLaveBalnceComponents();
                }
                setFromReserveLeave(false);
            } else {
                showSuccessOrFailureMessage(false, "This year leave information already registered. Not allowed to register again !! ");

            }
      
        }

//return null means stay on the same page
        return null;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void clearLaveBalnceComponents() {
        lstPhysicalYear.setValue(null);
       // txtLeaveAmount.setValue("");
    }

    void disableLaveBalnceComponents() {
        lstPhysicalYear.setDisabled(true);
       // txtLeaveAmount.setDisabled(true);
    }

    void enableleLaveBalnceComponents() {
        lstPhysicalYear.setDisabled(false);
        btnAddToTable.setDisabled(false);
       // txtLeaveAmount.setDisabled(false);
    }

    public void rowSelectorEvaSession_processMyEvent(RowSelectorEvent rse) {
        selecteLeaveBalanceRow = rse.getRow();
    }

    public String btnNewLeaveBalance_action()
    {
        if (txtEmployeeId.getValue() != null)
            {
            enableleLaveBalnceComponents();
            clearLaveBalnceComponents();
            loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
            tableSize = 0;
            rowCounter = 0;
            String currentDate = StringDateManipulation.toDayInEc();
            lstPhysicalYear.resetValue();
            lstPhysicalYear.setValue("0");
            getEmployeeLeaveBalace().clear();
            btnRequesteDate.setDisabled(false);
            lstPhysicalYear.setDisabled(false);
            txtCurrentDate.setDisabled(true);
            btnSaveLeaveBalance.setDisabled(false);
            btnCancelLeaveBalance.setDisabled(false);
            btnNewLeaveBalance.setDisabled(true);
            btnEditLeaveBalance.setDisabled(true);
            btnUpdateLeaveBalance.setDisabled(true);
            btnDeleteLeaveBalance.setDisabled(true);
            buttonIdentifierLeaveBalance = 1;
        } else {
            showSuccessOrFailureMessage(false, "Please fill Employee Id first by using the search text field.");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnSaveLeaveBalance_action() {
        try {
            if (leaveBalanceManager.saveLeaveBalanceINBank(leaveBalanceInformationNew())) {
                lstPhysicalYear.resetValue();
                txtCurrentDate.resetValue();
                lstResignationTyes.resetValue();
                lstPhysicalYear.setValue("0");
                btnRequesteDate.setDisabled(true);
                lstPhysicalYear.setDisabled(true);
                txtCurrentDate.setDisabled(true);
                btnSaveLeaveBalance.setDisabled(true);
                btnCancelLeaveBalance.setDisabled(true);
                btnNewLeaveBalance.setDisabled(false);
                btnEditLeaveBalance.setDisabled(true);
                btnUpdateLeaveBalance.setDisabled(true);
                btnDeleteLeaveBalance.setDisabled(true);
              //  loadEmployeeLeaveBalance(txtEmployeeId.getValue().toString());
                showSuccessOrFailureMessage(true, "Employee Leave Balance  successfully Saved.");
            } else {
                showSuccessOrFailureMessage(false, "Error Occured While Leave Balance .Please try again ?");
            }

//
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnEditLeaveBalance_action() {
        LeaveBalance leaveBalanceInfo = getEmployeeLeaveBalace().get(selecteLeaveBalanceRow);
        loadEmployeeProfileDetail(leaveBalanceInfo.getEmployeeId());
        lstPhysicalYear.setValue(leaveBalanceInfo.getYear());
        lblTotalAmount.setValue(leaveBalanceInfo.getAmount());
        txtUsedLeaveAmount.setValue(leaveBalanceInfo.getUsedLeaveAmount());
        leaveBalanceId = leaveBalanceInfo.getLeaveBalaceId();
        getEmployeeLeaveBalace().remove(selecteLeaveBalanceRow);
        lstPhysicalYear.setDisabled(false);
        //lblTotalAmount.setDisabled(false);
        setFromReserveLeave(leaveBalanceInfo.isFromReserveLeave());
        buttonIdentifierLeaveBalance = 3;
        btnUpdateLeaveBalance.setDisabled(false);

        //return null means stay on the same page
        return null;
    }

    public String btnUpdateLeaveBalance_action() {
        try {

            if (leaveBalanceManager.updateLeaveBalance(updatableleaveBalanceInformation())) {
                lstPhysicalYear.resetValue();
                txtCurrentDate.resetValue();
                lstResignationTyes.resetValue();
                lstPhysicalYear.setValue("0");
                btnRequesteDate.setDisabled(true);
                lstPhysicalYear.setDisabled(true);
                txtCurrentDate.setDisabled(true);
                btnSaveLeaveBalance.setDisabled(true);
                btnCancelLeaveBalance.setDisabled(true);
                btnNewLeaveBalance.setDisabled(false);
                btnEditLeaveBalance.setDisabled(true);
                btnUpdateLeaveBalance.setDisabled(true);
                btnDeleteLeaveBalance.setDisabled(true);
                loadEmployeeLeaveBalance(txtEmployeeId.getValue().toString());
                showSuccessOrFailureMessage(true, "Employee Leave Balance  successfully updated.");
            } else {
                showSuccessOrFailureMessage(false, "Error Occured While Leave Balance .Please try again ?");
            }
//
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnDeleteLeaveBalance_action() {
        if (selecteLeaveBalanceRow != -1) {
            pnlPopUpMsg.setRendered(true);
        }
        //return null means stay on the same page
        return null;
    }

    public String lnkLeaveBalance_action() {



        //return null means stay on the same page
        return "LeaveBalance";
    }

    public String btnPopUpNo_action() {
        pnlPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void lblDDID_processMyEvent(DragEvent de) {
    }


    public String btnSatusDisplayYse_action()
    {
        pnMessageForEmployeeStatus.setRendered(false);
          if (selectedId != null)
                  {
            getEmployeeLeaveBalace().clear();
            lblDepartment.setValue(null);
            lblFullName.setValue(null);
            lblPosition.setValue(null);
            lblServiceYear.setValue(null);
            lblHireDate.setValue(null);
            lblServiceYear.setValue(null);
            cbMale.resetValue();
            cbFemale.resetValue();
            chkCivil.resetValue();
            chkContrat.resetValue();
            cbFemale.setSelected(false);
            cbMale.setSelected(false);
            chkCivil.setSelected(false);
            chkContrat.setSelected(false);

            loadEmployeeProfile(ApplicationBean1.getSelectedEmployeeId());
          }

        //return null means stay on the same page
        return null;
    }

        public String btnSatusDisplayNo_action() {
        pnMessageForEmployeeStatus.setRendered(false);
        //return null means stay on the same page
        return null;
    }


   

    public String txtSearchByName_action()
    {
        selectedId = null;
        selectedId = ApplicationBean1.getSelectedEmployeeId();

        String emp_status=leaveBalanceManager.getEmployeeStatus(selectedId);
        if(emp_status.equalsIgnoreCase("03"))
        {
       lblFormMessage1EmployeeStatus.setValue("This Employee is Terminated.Do you wnat to display employee Leave Data?");
        pnMessageForEmployeeStatus.setRendered(true);

        } else
        {

        if (selectedId != null)
                  {
            getEmployeeLeaveBalace().clear();
            lblDepartment.setValue(null);
            lblFullName.setValue(null);
            lblPosition.setValue(null);
            lblServiceYear.setValue(null);
            lblHireDate.setValue(null);
            lblServiceYear.setValue(null);
            cbMale.resetValue();
            cbFemale.resetValue();
            chkCivil.resetValue();
            chkContrat.resetValue();
            cbFemale.setSelected(false);
            cbMale.setSelected(false);
            chkCivil.setSelected(false);
            chkContrat.setSelected(false);

            loadEmployeeProfile(ApplicationBean1.getSelectedEmployeeId());

        }

         //  loadEmployeeInformationForNameSearch();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupViewLeaveBalnce_action() {
        pnlPopupViewLeaveBalalceAsOFToDay.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupViewLeaveBalnceForZeroYear_action() {
        pnlPopupViewLeaveBalalceAsOFToDayForZeroYear.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    
    public boolean isEmployeeMoreThatOneYear()
    {
         serviceYear = Integer.parseInt(lblServiceYear.getValue().toString());
        if (serviceYear != 0)
        {
            return true;

        } else {
            showSuccessOrFailureMessage(false, "This Employee has less than One year Expirance. Not allowed to register leave Balance But You Can See The Leave Amount As Of To Day!! ");
            return false;
        }

    }

    public String btnAddToTable_action()
    {
        if (this.isEmployeeMoreThatOneYear())
        {

            String[] hireDate = lblHireDate.getValue().toString().split("-");
            year = (Integer.parseInt(hireDate[0])) + 1;
            serviceYear = Integer.parseInt(lblServiceYear.getValue().toString());
            if (this.buttonIdentifierLeaveBalance == 1 || buttonIdentifierLeaveBalance == 2) 
            {
               
                if (isNotduplicated())
                {

                    for (int counter = 0; counter < serviceYear; counter++)
                    {
                        LeaveBalance leaveBalance = new LeaveBalance(
                                leaveBalanceId,
                                txtEmployeeId.getValue().toString(),
                                year,
                                leaveAmount,
                                lblFullName.getValue().toString(),
                                "0",
                                "0",
                                isFromReserveLeave());
                        year++;
                        totalLeaveAmount += leaveAmount;
                        leaveAmount++;
                        rowCounter++;
                        employeeLeaveBalace.add(leaveBalance);
                        lblTotalAmount.setValue(totalLeaveAmount);
                    }


                } else {
                    showSuccessOrFailureMessage(false, "This year leave information already registered. Not allowed to register again !! ");

                }

            } else if (buttonIdentifierLeaveBalance == 3)
            {
                LeaveBalance leaveBalance = new LeaveBalance(
                        leaveBalanceId,
                        txtEmployeeId.getValue().toString(),
                        Integer.parseInt(lstPhysicalYear.getValue().toString()),
                        Integer.parseInt(lblTotalAmount.getValue().toString()),
                        lblFullName.getValue().toString(),
                        txtUsedLeaveAmount.getValue().toString(),
                        "0",
                        isFromReserveLeave());

                this.employeeLeaveBalace.add(this.selecteLeaveBalanceRow, leaveBalance);
                this.employeeLeaveBalaceUpdate.add(leaveBalance);
                btnUpdateLeaveBalance.setDisabled(false);
                disableLaveBalnceComponents();
            }
            setFromReserveLeave(false);



        }
        return null;
    }

    public String button2_action() throws ParseException
              {
        String hireDate = lblHireDate.getValue().toString();
        String currentDate = dateFormat.format(new Date());
        int currentYear = GregorianCalendarManipulation.getYear(currentDate);
        expTotal = GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceReturnTypeArrayListForLeave(hireDate, currentDate);
        int Dates = Integer.parseInt(expTotal[0]);
        int months = Integer.parseInt(expTotal[1]);
        int years = Integer.parseInt(expTotal[2]);
        int monthToDays = (months * 30);
        int totalDays = (monthToDays + Dates);
        int lastLeaveBalanceYear = (currentYear - 1);
        float lastLeaveAmount = 0;
        float nextyearLeaveAmount;
        int commingLeaveAmount;
        float devidend;
        float divisor = 360;
        float totalasofToday = 0;
        String remaing;
        if (years == 0)
        {

            remaing = "0.0";
            nextyearLeaveAmount = 16;
            devidend = (totalDays * nextyearLeaveAmount);
            result = (devidend / divisor);
            Float reme = new Float(remaing);
            totalasofToday = (this.roundTo(result));
            outTxt_LeaveAmount.setValue(totalasofToday);
            pnlPopupViewLeaveBalalceAsOFToDayForZeroYear.setRendered(true);
        } else if ((Dates != 0) || (months != 0))
        {

            lastLeaveAmount = leaveBalanceManager.SelectLastBalanceOFEmployee(selectedId);
            nextyearLeaveAmount = (lastLeaveAmount + 1);
            devidend = (totalDays * nextyearLeaveAmount);
            result = (devidend / divisor);
            remaing = (employeeLeaveBalace.get(selecteLeaveBalanceRow).getReminingLeaveAmout());
            Float reme = new Float(remaing);
            totalasofToday = (reme + result);
            employeeLeaveBalace.get(selecteLeaveBalanceRow).setLeaveAsofToDay(totalasofToday);
            pnlPopupViewLeaveBalalceAsOFToDay.setRendered(true);
        }
       

        return null;
    }

     public void chkMakeReady_processValueChange(ValueChangeEvent vce) 
    {
        if(chkMakeReady.isSelected())
        {
        btnPrepare.setDisabled(false);
        boolean  deleteResult=leaveBalanceManager.ClearAsOfToDayTable();
        }
        

    }

    public String btnPrepare_action() {
        if(prepareEmployeeMoreThanOneYearExpirance())
           {

        if(PrepareForLessThanOneYearExpirance()){

        showSuccessOrFailureMessage(true, "AS OF TO DAY LEAVE AMOUNT PREPARATION IS DONE!! ");

        }

        else{
        showSuccessOrFailureMessage(false, "Error Ocured During PREPARATION pls try Agien!! ");

        }



        }
        return null;

    }

  public boolean prepareEmployeeMoreThanOneYearExpirance()
                  {
        employeeLeaveMaster =leaveBalanceManager.EmployeeHireDate();
         int size=employeeLeaveMaster.size();
         boolean  returnResult=false;
    for(int counter=0 ;counter < size; counter++)
                   {
          String empID=employeeLeaveMaster.get(counter).getEmployeeID();
         String hireDatee = employeeLeaveMaster.get(counter).getHireDate();
        //String hireDate = lblHireDate.getValue().toString();
        String currentDatee = dateFormat.format(new Date());
        int currentYeare = GregorianCalendarManipulation.getYear(currentDatee);
        expTotal = GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceReturnTypeArrayListForLeave(hireDatee, currentDatee);
        int Dates = Integer.parseInt(expTotal[0]);
        int months = Integer.parseInt(expTotal[1]);
        int years = Integer.parseInt(expTotal[2]);
        int monthToDays = (months * 30);
        int totalDays = (monthToDays + Dates);
        int lastLeaveBalanceYear = (currentYeare - 1);
        float lastLeaveAmount = 0;
        float nextyearLeaveAmount;
        int commingLeaveAmount;
        float devidend;
        float divisor = 360;
        float totalBalanceasofToday = 0;
        float entitlement=0;
        float asOfEntitlement=0;
        String remaing;
        String entil;

               if((Dates != 0) || (months != 0))
                   {

            lastLeaveAmount = leaveBalanceManager.SelectLastBalanceOFEmployee(empID);
            nextyearLeaveAmount = (lastLeaveAmount + 1);
            devidend = (totalDays * nextyearLeaveAmount);
            result = (devidend / divisor);
            remaing = (employeeLeaveMaster.get(counter).getLastBalance());
            Float reme = new Float(remaing);
            totalBalanceasofToday = (reme + result);
            entil=(employeeLeaveMaster.get(counter).getTotalEntitlment());
            Float ent=new Float(entil);
            asOfEntitlement=ent+result;
                  }
            
            returnResult= leaveBalanceManager.PrepareLeaveForAsOfToday(empID,totalBalanceasofToday,asOfEntitlement);

                   }
              return returnResult;
 
                    }

  public boolean PrepareForLessThanOneYearExpirance()
      {


         employeeLeaveMaster =leaveBalanceManager.EmployeeHireDateForLessThanOneYear();
         int size=employeeLeaveMaster.size();
          boolean returnResult=false;
          boolean prepareResult=false;
       for(int counter=0 ;counter < size; counter++)
          {
          String empID=employeeLeaveMaster.get(counter).getEmployeeID();
         String hireDate = employeeLeaveMaster.get(counter).getHireDate();
        //String hireDate = lblHireDate.getValue().toString();
        String currentDate = dateFormat.format(new Date());
        int currentYear = GregorianCalendarManipulation.getYear(currentDate);
        expTotal = GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceReturnTypeArrayListForLeave(hireDate, currentDate);
        int Dates = Integer.parseInt(expTotal[0]);
        int months = Integer.parseInt(expTotal[1]);
        int years = Integer.parseInt(expTotal[2]);
        int monthToDays = (months * 30);
        int totalDays = (monthToDays + Dates);
        int lastLeaveBalanceYear = (currentYear - 1);
        float lastLeaveAmount = 0;
        float nextyearLeaveAmount;
        int commingLeaveAmount;
        float devidend;
        float divisor = 360;
        float totalBalanceasofToday = 0;
        float asOfEntitlement=0;
        String entil;
        String remaing;
           if (years == 0)
                {
            remaing = "0.0";
            nextyearLeaveAmount = 16;
            devidend = (totalDays * nextyearLeaveAmount);
            result = (devidend / divisor);
            Float reme = new Float(remaing);
            totalBalanceasofToday = (this.roundTo(result));
            entil=(employeeLeaveMaster.get(counter).getTotalEntitlment());
            Float ent=new Float(entil);
            asOfEntitlement=ent+result;
            returnResult= leaveBalanceManager.PrepareLeaveForAsOfToday(empID,totalBalanceasofToday,asOfEntitlement);
                  }
          
            if(returnResult)
            {
          prepareResult= true;
            }
            else{

            prepareResult=false;
            }

  }

     return prepareResult;

  }


}

