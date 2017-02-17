/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectManyCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.LookUpManager;
import manager.leaveManager.AnnualLeaveManager;
import manager.leaveManager.LeaveBalanceManager;
import manager.leaveManager.LeaveRequestManager;
import manager.leaveManager.LeaveScheduleManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LeaveEmployeeSchedule extends AbstractPageBean {


    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;
    //  private RetirementLookUpManager retirementLookUpManager = new RetirementLookUpManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private LeaveBalanceManager leaveBalanceManager = new LeaveBalanceManager();
    private ArrayList<SelectItem> pysicalLeaveTypes = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> scheduleLeaveYear = new ArrayList<SelectItem>();
    private DepartmentManage departmentManage = new DepartmentManage();
    private LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
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
    private static String selectedId;
    private static int messageStatus = 0;
    private static int tableSize = 0;
    private static int rowCounter = 0;
    private byte[] attachedDBImg;
    private String commentLanguage = null;
    private String loggedInUserId = null;
    private boolean firstTime = true;
    String currenTDateToSet = "fromDate";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private byte[] employeePicture;
    private byte[] attachedDBImg1;
    private HtmlCommandButton btnPopUpYes = new HtmlCommandButton();
    AutoCompleteDictionary autoCompleteDictionary = new AutoCompleteDictionary();
    LookUpManager lookUpManager = new LookUpManager();
    private AnnualLeaveManager annualLeaveManager = new AnnualLeaveManager();
    EmployeeList currentEmployee1 = new EmployeeList("", "0", null);
    EmployeeManage currentEmployee = new EmployeeManage();
    ArrayList<HashMap> myDocuments = new ArrayList<HashMap>();
    private ArrayList<SelectItem> listofMonth = new ArrayList<SelectItem>();
    private int scheduleId;
    private List<String> selectedMonth = new ArrayList<String>();
    private List vb = new ArrayList<String>();
    JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    LeaveScheduleManager leaveScheduleManager = new LeaveScheduleManager();
    private boolean employeeCanSecadule = true;
    private ArrayList<ScheduleMonth> listOfSchedule = new ArrayList<ScheduleMonth>();
    private int rowSelector = -1;
    private String listOfYear = "";
    private String requesterSelected = "";

    public ArrayList<SelectItem> getScheduleLeaveYear() {
        return scheduleLeaveYear;
    }

    public void setScheduleLeaveYear(ArrayList<SelectItem> scheduleLeaveYear) {
        this.scheduleLeaveYear = scheduleLeaveYear;
    }

    public ArrayList<ScheduleMonth> getListOfSchedule() {
        return listOfSchedule;
    }

    public void setListOfSchedule(ArrayList<ScheduleMonth> listOfSchedule) {
        this.listOfSchedule = listOfSchedule;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        if (firstTime) {
            firstTime = false;
            loggedInUserId = getSessionBean1().getEmployeeId();
            scheduleLeaveYear = leaveBalanceManager.getScheduleLeaveYear();
            setListofMonth(lookUpManager.getListofMonths());
            clearAllComponents();
            disableComponents();
            txtEmployeeId.setValue("");
        }




    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
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
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private HtmlCommandButton btnSaveLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveLeaveBalance() {
        return btnSaveLeaveBalance;
    }

    public void setBtnSaveLeaveBalance(HtmlCommandButton hcb) {
        this.btnSaveLeaveBalance = hcb;
    }
    private HtmlCommandButton btnDeleteLeaveBalance = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteLeaveBalance() {
        return btnDeleteLeaveBalance;
    }

    public void setBtnDeleteLeaveBalance(HtmlCommandButton hcb) {
        this.btnDeleteLeaveBalance = hcb;
    }
    private DefaultSelectedData selectManyCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectManyCheckbox1Bean() {
        return selectManyCheckbox1Bean;
    }

    public void setSelectManyCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectManyCheckbox1Bean = dsd;
    }
    private DefaultSelectionItems selectManyCheckbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectManyCheckbox1DefaultItems() {
        return selectManyCheckbox1DefaultItems;
    }

    public void setSelectManyCheckbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectManyCheckbox1DefaultItems = dsi;
    }
    private HtmlSelectManyCheckbox chkMonths = new HtmlSelectManyCheckbox();

    public HtmlSelectManyCheckbox getChkMonths() {
        return chkMonths;
    }

    public void setChkMonths(HtmlSelectManyCheckbox hsmc) {
        this.chkMonths = hsmc;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlCommandLink modalPnlCloseMesssage = new HtmlCommandLink();

    public HtmlCommandLink getModalPnlCloseMesssage() {
        return modalPnlCloseMesssage;
    }

    public void setModalPnlCloseMesssage(HtmlCommandLink hcl) {
        this.modalPnlCloseMesssage = hcl;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private PanelPopup pnlPopUpMsg = new PanelPopup();

    public PanelPopup getPnlPopUpMsg() {
        return pnlPopUpMsg;
    }

    public void setPnlPopUpMsg(PanelPopup pp) {
        this.pnlPopUpMsg = pp;
    }
    private HtmlInputText txtStrartDate = new HtmlInputText();

    public HtmlInputText getTxtStrartDate() {
        return txtStrartDate;
    }

    public void setTxtStrartDate(HtmlInputText hit) {
        this.txtStrartDate = hit;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private PanelPopup pnlPopUpSchedule = new PanelPopup();

    public PanelPopup getPnlPopUpSchedule() {
        return pnlPopUpSchedule;
    }

    public void setPnlPopUpSchedule(PanelPopup pp) {
        this.pnlPopUpSchedule = pp;
    }
    private HtmlCommandButton btnStartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnStartDate() {
        return btnStartDate;
    }

    public void setBtnStartDate(HtmlCommandButton hcb) {
        this.btnStartDate = hcb;
    }
    private HtmlCommandButton btnEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnEndDate() {
        return btnEndDate;
    }

    public void setBtnEndDate(HtmlCommandButton hcb) {
        this.btnEndDate = hcb;
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
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlOutputText lblJobPosition = new HtmlOutputText();

    public HtmlOutputText getLblJobPosition() {
        return lblJobPosition;
    }

    public void setLblJobPosition(HtmlOutputText hot) {
        this.lblJobPosition = hot;
    }
    private HtmlOutputText lblAvailableAnnualLeave = new HtmlOutputText();

    public HtmlOutputText getLblAvailableAnnualLeave() {
        return lblAvailableAnnualLeave;
    }

    public void setLblAvailableAnnualLeave(HtmlOutputText hot) {
        this.lblAvailableAnnualLeave = hot;
    }
    private HtmlOutputText lblExtendedLeave = new HtmlOutputText();

    public HtmlOutputText getLblExtendedLeave() {
        return lblExtendedLeave;
    }

    public void setLblExtendedLeave(HtmlOutputText hot) {
        this.lblExtendedLeave = hot;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private HtmlSelectOneMenu drlMonths = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlMonths() {
        return drlMonths;
    }

    public void setDrlMonths(HtmlSelectOneMenu hsom) {
        this.drlMonths = hsom;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlSelectBooleanCheckbox cbFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCbFemale() {
        return cbFemale;
    }

    public void setCbFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.cbFemale = hsbc;
    }
    private HtmlInputText txtDays = new HtmlInputText();

    public HtmlInputText getTxtDays() {
        return txtDays;
    }

    public void setTxtDays(HtmlInputText hit) {
        this.txtDays = hit;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
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
    private HtmlSelectOneMenu drlScheduleFor = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlScheduleFor() {
        return drlScheduleFor;
    }

    public void setDrlScheduleFor(HtmlSelectOneMenu hsom) {
        this.drlScheduleFor = hsom;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LeaveEmployeeSchedule() {
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

    public ArrayList<SelectItem> getPysicalLeaveTypes() {
        return pysicalLeaveTypes;
    }

    public void setPysicalLeaveTypes(ArrayList<SelectItem> pysicalLeaveTypes) {
        this.pysicalLeaveTypes = pysicalLeaveTypes;
    }

    public String btnSearch_action() {
        txtEmployeeId.setDisabled(true);
        employeeCanSecadule = false;
        clearAllComponents();
        try {
            if (HRValidation.validateRequired(txtEmployeeId.getValue())) {
                lblDepartment.setValue("");
                lblFullName.setValue("");
                lblJobPosition.setValue("");
                lblServiceYear.setValue("");
                lblHireDate.setValue("");
                lblServiceYear.setValue("");
                cbMale.resetValue();
                cbFemale.resetValue();
                cbFemale.setSelected(false);
                cbMale.setSelected(false);
                btnSaveLeaveBalance.setDisabled(false);
//                btnSaveLeaveBalance.setDisabled(false);
                //   btnSaveLeaveBalance.setDisabled(true);
                btnDeleteLeaveBalance.setDisabled(true);
                loadEmployee_ProfileDetail(txtEmployeeId.getValue().toString());
                loadAnnualLeave(txtEmployeeId.getValue().toString());
                loadTransferedAnnualLeave(txtEmployeeId.getValue().toString());
                loadEmployeeLeaveSChedule(txtEmployeeId.getValue().toString());
                loadPhisicalYear();
                if (employeeCanSecadule) {
                    enableComponents();
                } else {
                    showSuccessOrFailureMessage(false, "You not hava registerd leave days." +
                            "you can not allowed to Schedule. ");
                    disableComponents();

                }
            } else {
                showSuccessOrFailureMessage(true, "Please enter employee id ?");
                ((UIInput) txtEmployeeId).setValid(false);
                error(txtEmployeeId, "Required");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }





        //return null means stay on the same page
        return null;
    }

    private void loadAnnualLeave(String empId) {
        listOfYear = "";
        String anualLeaveDays = leaveScheduleManager.readEmployeeLeaveBalance(empId);
        if (anualLeaveDays != null) {
            anualLeaveDays.trim();
            if (anualLeaveDays.length() > 0) {
                employeeCanSecadule = true;
                listOfYear += "=" + anualLeaveDays;
                lblAvailableAnnualLeave.setValue(anualLeaveDays);
            }
        }
    }

    private void loadTransferedAnnualLeave(String empId) {
        String anualLeaveDays = leaveScheduleManager.getTransferLeaveAmount(empId);
        if (anualLeaveDays != null) {
            employeeCanSecadule = true;
            listOfYear += "=" + anualLeaveDays;
            lblExtendedLeave.setValue(anualLeaveDays);
        //showSuccessOrFailureMessage(false, "You  Id is not registered.Please try again.");
        }
    }

    private void loadEmployeeLeaveSChedule(String empId) {
        ArrayList<HashMap> list = leaveScheduleManager.listOfemployeeLeaveSecadule(empId);
        if (list != null) {
            getListOfSchedule().clear();
            for (HashMap hm : list) {
                getListOfSchedule().add(new ScheduleMonth(
                        hm.get("SCGEDULEYEAR").toString(),
                        hm.get("MONTH").toString(),
                        hm.get("ID").toString(),
                        getStringListofMonths()[Integer.parseInt(hm.get("MONTH").toString())],
                        hm.get("days").toString(),
                        hm.get("LEAVEYEAR").toString()));
                txtRemark.setValue(hm.get("REMARK"));
            }

        }

    }

    private void loadPhisicalYear() {
        try {

            requesterSelected = "";
            if (employeeCanSecadule && listOfYear != null && !listOfYear.equals("")) {
                String newValue[];
                String leaveYear[] = listOfYear.split("=");
                for (String s : leaveYear) {
                    newValue = s.split("]");
                    for (String s2 : newValue) {
                        if (s2.length() > 4) {
                            requesterSelected += "=" + s2.substring(3, 7);
                        }
                    }

                }

            }
            loadRequesterSelectd();
        } catch (Exception e) {
        }
    }

    private void loadRequesterSelectd() {
        String date = jodanTimeCalender.currentDateFinder();
        ArrayList<SelectItem> list_OfYear = new ArrayList<SelectItem>();
        pysicalLeaveTypes.clear();
        try {
            if (requesterSelected != null && !requesterSelected.equals("")) {
                list_OfYear.add(new SelectItem(null, "-- Select Pysical Year --"));
                String requesteNewVlue[] = requesterSelected.split("=");
                for (String s : requesteNewVlue) {
                    if (s.length() > 3) {
                        list_OfYear.add(new SelectItem(s, s));
                    }
                }

            } else {
                list_OfYear.add(new SelectItem(null, "-- Not Available  --"));
            }
            pysicalLeaveTypes = list_OfYear;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void loadEmployee_ProfileDetail(String empId) {
        try {
            if (employeeManager.loadEmpoyeeProfile(empId) == 1) {
                lblFullName.setValue(employeeManager.getTitleDes() + " " +
                        employeeManager.getFirst_Name() + " " +
                        employeeManager.getMiddle_Name() + " " +
                        employeeManager.getLast_Name());
                sex = employeeManager.getSex();
                lblJobPosition.setValue(employeeManager.getJobName());


                lblHireDate.setValue(employeeManager.getHire_Date());
                // lblDepartment.setValue(": " + "[ " + departmentManage.readDepartmentAllDescrption(employeeManager.getDepartmentId()) + " ]");
                if (sex.equalsIgnoreCase("Male")) {
                    cbMale.setSelected(true);
                } else if (sex.equalsIgnoreCase("Female")) {
                    cbFemale.setSelected(true);
                } else {
                    cbMale.setSelected(false);
                    cbFemale.setSelected(false);
                }
                int expYear = employeeManager.calculateEmpServiceYear(
                        jodanTimeCalender.ChangeDateToEthiopic(employeeManager.getHire_Date()));
                lblServiceYear.setValue(String.valueOf(expYear));
                // String employeeType = employeeManager.getOfficeOrShift();
                lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));

                OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
                try {
                    setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
                    imgEmployeePicture.setValue(getAttachedDBImg());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                showSuccessOrFailureMessage(false, "Employee Id is not registered.Please try again.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage.setStyle(success ? "color: green; font-size: 14px; font-weight: " +
                " bold;text-align: center; vertical-align: middle" : "color: red; " +
                " font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage.setValue(messageToDisplay);
        lblFormMessage.setVisible(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }
///////////////////////////////////////////////////variable set and get

    public byte[] getAttachedDBImg() {
        return attachedDBImg;
    }

    public void setAttachedDBImg(byte[] attachedDBImg) {
        this.attachedDBImg = attachedDBImg;
    }

    public ArrayList<SelectItem> getListofMonth() {
        return listofMonth;
    }

    public void setListofMonth(ArrayList<SelectItem> listofMonth) {
        this.listofMonth = listofMonth;
    }

    private ArrayList<HashMap> listOfMonthToSave() {
        ArrayList<HashMap> listOfEmployeeSchedule = new ArrayList<HashMap>();
        String year = null;
        String monthList = "";
        String dayList = "";
        boolean firstTime = true;
        for (ScheduleMonth scheduleMonth : getListOfSchedule()) {
            if (firstTime) {
                year = scheduleMonth.getScheduleYear();
                firstTime = false;
            }
            if (scheduleMonth.getScheduleYear().equals(year)) {
                monthList += "," + scheduleMonth.getScheduleMonth();
                dayList += "," + scheduleMonth.getDays();
            } else {
                HashMap hm = new HashMap();
                hm.put("year", year);
                hm.put("month", monthList.substring(1));
                hm.put("remark", txtRemark.getValue());
                hm.put("employeeId", txtEmployeeId.getValue());
                hm.put("days", dayList);
                hm.put("leaveYear", scheduleMonth.getFromLeaveYear());
                listOfEmployeeSchedule.add(hm);
                monthList = ",";
                dayList = ",";
                dayList += scheduleMonth.getScheduleMonth();
                monthList += scheduleMonth.getDays();
                year = scheduleMonth.getScheduleYear();
            }

        }
        if (getListOfSchedule().size() > 1 || listOfEmployeeSchedule.size() == 0) {
            HashMap hm = new HashMap();
            hm.put("year", year);
            hm.put("month", monthList.substring(1));
            hm.put("remark", txtRemark.getValue());
            hm.put("employeeId", txtEmployeeId.getValue());
            hm.put("days", dayList.substring(1));
            hm.put("leaveYear", jodanTimeCalender.currentYearOnlyFinder());
            listOfEmployeeSchedule.add(hm);
        }
        return listOfEmployeeSchedule;
    }

    public String btnSaveLeaveBalance_action() {
        try {
            ArrayList<HashMap> listOf_Schedule = listOfMonthToSave();
            if (listOfSchedule.size() > 0) {
                if (leaveScheduleManager.saveLeaveSchduleEmployee(listOf_Schedule)) {
                    showSuccessOrFailureMessage(true, " Leave Schedule  successfully Saved.");
                    clearAllComponents();
                    txtEmployeeId.setValue("");
                    disableComponents();
                } else {
                    showSuccessOrFailureMessage(false, "Error Occured While Leave Schedule .Please try again ?");
                }
            } else {
                showSuccessOrFailureMessage(false, " Please Select Schedule Year and Month and try again?");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
//return null means stay on the same page

        return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnPopUpYes_action() {
        pnlPopUpMsg.setRendered(false);
        if (rowSelector != -1) {
            if (leaveScheduleManager.deleteLeaveSchduleEmployee(txtEmployeeId.getValue().toString(),
                    getListOfSchedule().get(rowSelector).getScheduleYear())) {
                loadEmployeeLeaveSChedule(txtEmployeeId.getValue().toString());
                showSuccessOrFailureMessage(true, "Schedule Information Successfully  Deleted !");
            } else {
                showSuccessOrFailureMessage(false, "Error Occur During Deletion. Please try again?");
            }
        } else {
            showSuccessOrFailureMessage(false, " Please Select Schedule Year From the Table and try again?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnPopUpNo_action() {
        pnlPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseBtnDateSetting1_action() {
        pnlPopUpSchedule.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSaveSchedule_action() {
        //return null means stay on the same page
        return null;
    }

    public List<String> getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(List<String> selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    private void clearAllComponents() {
        lblFullName.setValue("");
        cbMale.setSelected(false);
        cbFemale.setSelected(false);
        lblDepartment.setValue("");
        lblJobPosition.setValue("");
        lblServiceYear.setValue("");
        lblHireDate.setValue("");
        imgEmployeePicture.setValue("");
        txtDays.setValue("");
        lblAvailableAnnualLeave.setValue("");
        lblExtendedLeave.setValue("");
        defaultSelectedData3.setSelectedObject(null);
        defaultSelectedData7.setSelectedObject(null);
        defaultSelectedData5.setSelectedObject(null);
        selectedMonth.clear();
        txtRemark.setValue("");
        getListOfSchedule().clear();

    }

    private void disableComponents() {
        chkMonths.setDisabled(true);
        drlScheduleFor.setDisabled(true);
        txtRemark.setDisabled(true);
        txtDays.setDisabled(true);
        drlMonths.setDisabled(true);

        btnAdd.setDisabled(true);
        btnDeleteLeaveBalance.setDisabled(true);
        btnSaveLeaveBalance.setDisabled(true);
    }

    private void enableComponents() {
        chkMonths.setDisabled(false);
        drlScheduleFor.setDisabled(false);
        txtRemark.setDisabled(false);
        txtDays.setDisabled(false);
        drlMonths.setDisabled(false);

        btnAdd.setDisabled(false);

        btnDeleteLeaveBalance.setDisabled(false);
        btnSaveLeaveBalance.setDisabled(false);

    }

    public static class ScheduleMonth implements Serializable {

        private String scheduleYear;
        private String scheduleMonth;
        private String scheduleId;
        private String monthDescription;
        private String fromLeaveYear;
        private String days;
        private boolean selected;

        public String getFromLeaveYear() {
            return fromLeaveYear;
        }

        public void setFromLeaveYear(String fromLeaveYear) {
            this.fromLeaveYear = fromLeaveYear;
        }

        public String getScheduleMonth() {
            return scheduleMonth;
        }

        public void setScheduleMonth(String scheduleMonth) {
            this.scheduleMonth = scheduleMonth;
        }

        public String getScheduleYear() {
            return scheduleYear;
        }

        public void setScheduleYear(String scheduleYear) {
            this.scheduleYear = scheduleYear;
        }

        public String getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getMonthDescription() {
            return monthDescription;
        }

        public void setMonthDescription(String monthDescription) {
            this.monthDescription = monthDescription;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public ScheduleMonth(String scheduleYear,
                String scheduleMonth,
                String scheduleId,
                String monthDescription,
                String days,
                String fromLeaveYear) {
            this.scheduleYear = scheduleYear;
            this.scheduleMonth = scheduleMonth;
            this.scheduleId = scheduleId;
            this.monthDescription = monthDescription;
            this.days = days;
            this.fromLeaveYear = fromLeaveYear;

        }
    }

    public String btnAdd_action() {
        if (validateDate()) {
            try {
                if (isThisAgin()) {
                    if (getListOfSchedule().size() < 2) {
                        getListOfSchedule().add(new ScheduleMonth(
                                drlScheduleFor.getValue().toString(),
                                drlMonths.getValue().toString(),
                                "0",
                                getStringListofMonths()[Integer.parseInt(drlMonths.getValue().toString())],
                                txtDays.getValue().toString(),
                                Integer.toString(jodanTimeCalender.currentYearOnlyFinder())));
                    } else {
                        showSuccessOrFailureMessage(false, "Not allowed to schedule more than two month ");
                    }
                } else {
                    showSuccessOrFailureMessage(false, "Duplicated Value ");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

//
        }
        //return null means stay on the same page
        return null;
    }

    private boolean isThisAgin() {
        for (ScheduleMonth scheduleMonth : getListOfSchedule()) {
            if (scheduleMonth.getScheduleMonth().equals(drlMonths.getValue()) &&
                    scheduleMonth.getScheduleYear().equals(drlScheduleFor.getValue())) {
                return false;
            }

        }
        return true;
    }

    private boolean validateDate() {
        boolean result = true;
        if (!HRValidation.validateRequired(this.drlMonths)) {
            result = false;
        }

        if (!HRValidation.validateRequired(this.drlScheduleFor)) {
            result = false;
        }

        if (!HRValidation.validateRequired(this.txtEmployeeId)) {
            result = false;
        }



        int errorValue = HRValidation.validateData(txtDays.getValue(), HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            result = false;
        }
        return result;
    }

    private String[] getStringListofMonths() {
        String[] listOfMonth = {
            "not selected",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "Augest",
            "September",
            "October",
            "November",
            "December"};

        return listOfMonth;
    }

    public String lnkGovernmentDeductions_action() {
        //return null means stay on the same page
        return "LeaveTransferApprove";
    }

    public String lnkPersonalDeductions_action() {
        //return null means stay on the same page
        return "LeaveTransferRequest";
    }

    public String lnkAccrualEntries_action() {
        //return null means stay on the same page
        return "LeaveBalance";
    }

    public String lnkPayrollSetUp_action() {
        //return null means stay on the same page
        return "LeaveApprove";
    }

    public String lnkPayrollPeriodLists_action() {
        //return null means stay on the same page
        return "LeaveRequest";
    }

    public void rwSelectorLeaveSchedule_processMyEvent(RowSelectorEvent rse) {
        rowSelector = rse.getRow();

    }

    public String btnDeleteLeaveBalance_action() {
        pnlPopUpMsg.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String txtSearchByName_action() {

        txtEmployeeId.setValue(ApplicationBean1.getSelectedEmployeeId());
        txtEmployeeId.setValue(ApplicationBean1.getSelectedEmployeeId());
        btnSearch_action();
//         employeeCanSecadule = false;
//        clearAllComponents();
//        try {
//            String employeeId= ApplicationBean1.getSelectedEmployeeId();
//            if (HRValidation.validateRequired(employeeId)) {
//                lblDepartment.setValue("");
//                lblFullName.setValue("");
//                lblJobPosition.setValue("");
//                lblServiceYear.setValue("");
//                lblHireDate.setValue("");
//                lblServiceYear.setValue("");
//                cbMale.resetValue();
//                cbFemale.resetValue();
//                cbFemale.setSelected(false);
//                cbMale.setSelected(false);
//                btnSaveLeaveBalance.setDisabled(false);
////                btnSaveLeaveBalance.setDisabled(false);
//                //   btnSaveLeaveBalance.setDisabled(true);
//                btnDeleteLeaveBalance.setDisabled(true);
//                loadEmployee_ProfileDetail(employeeId);
//                loadAnnualLeave(employeeId);
//                loadTransferedAnnualLeave(employeeId);
//                loadEmployeeLeaveSChedule(employeeId);
//                loadPhisicalYear();
//                if (employeeCanSecadule) {
//                    enableComponents();
//                } else {
//                    showSuccessOrFailureMessage(false, "You not hava registerd leave days." +
//                            "you can not allowed to Schedule. ");
//                    disableComponents();
//
//                }
//            } else {
//                showSuccessOrFailureMessage(true, "Please enter employee id ?");
//                ((UIInput) txtEmployeeId).setValid(false);
//                error(txtEmployeeId, "Required");
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }





        //return null means stay on the same page
        return null;
    }

    public String button1_action() {
        employeeCanSecadule = false;
        clearAllComponents();
        txtEmployeeId.setDisabled(false);

        //return null means stay on the same page
        return null;
    }
}