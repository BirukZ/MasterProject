/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright Dereje
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import manager.employeeManager.EmployeeManage;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import javax.faces.model.SelectItem;
import com.icesoft.faces.component.ext.HtmlCommandLink;
//import javax.swing.JOptionPane;
import manager.employeeHistoryManager.ReturntoJobManager;
import manager.leaveManager.ApproveReturnFromLeaveManager;
import manager.leaveManager.LeaveControl;
import manager.leaveManager.LeaveTypeManager;

import manager.leaveManager.RequestFromLeaveManager;
import manager.overTimeManager.OverTimeRequestManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ManageEmployeeLeaveStatus extends AbstractPageBean {

    private String sex;
    private String empStatus;
    private String employeementType;
    private String workingLocation;
    EmployeeManage employeeManager = new EmployeeManage();
    ReturntoJobManager returntoJobManager = new ReturntoJobManager();
    private LeaveTypeManager leaveTypeManager = new LeaveTypeManager();
    private PanelPopup pnMessage = new PanelPopup();
    private LeaveControl leaveManager = new LeaveControl();
    private ArrayList<SelectItem> employeesOnLeave = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> employeeListRequestedReturnFromLeave = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> employeesNotReturnOnTime = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> employeesOnTwoHoursLeave = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private RequestFromLeaveManager requestFromLeaveManager = new RequestFromLeaveManager();
    private ApproveReturnFromLeaveManager approveReturnFromLeaveManager = new ApproveReturnFromLeaveManager();
    private OverTimeRequestManager overTimeRequestManager = new OverTimeRequestManager();
    private byte[] employeePicture;
    private String leaveType = null;
    private String leaveRequestId = null;
    private String leaveDays = "";
    private String employeeId = null;
    private boolean checkReturnFromLeave = false;
    private boolean isGetLeavePass = false;
    String startOrEnd = "Start";

    public ArrayList<SelectItem> getEmployeesOnTwoHoursLeave() {
        return employeesOnTwoHoursLeave;
    }

    public void setEmployeesOnTwoHoursLeave(ArrayList<SelectItem> employeesOnTwoHoursLeave) {
        this.employeesOnTwoHoursLeave = employeesOnTwoHoursLeave;
    }

    public ArrayList<SelectItem> getEmployeeListRequestedReturnFromLeave() {
        return employeeListRequestedReturnFromLeave;
    }

    public void setEmployeeListRequestedReturnFromLeave(ArrayList<SelectItem> employeeListRequestedReturnFromLeave) {
        this.employeeListRequestedReturnFromLeave = employeeListRequestedReturnFromLeave;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public ArrayList<SelectItem> getEmployeesNotReturnOnTime() {
        return employeesNotReturnOnTime;
    }

    public void setEmployeesNotReturnOnTime(ArrayList<SelectItem> employeesNotReturnOnTime) {
        this.employeesNotReturnOnTime = employeesNotReturnOnTime;
    }

    public ArrayList<SelectItem> getEmployeesOnLeave() {
        return employeesOnLeave;
    }

    public void setEmployeesOnLeave(ArrayList<SelectItem> employeesOnLeave) {
        this.employeesOnLeave = employeesOnLeave;
    }
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        pnl_col_Common_Tasks.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnl_col_Common_Tasks_processAction(ae);
            }
        });
        panelCollapsible1.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                panelCollapsible1_processAction(ae);
            }
        });
        pnl_col_Status.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnl_col_Status_processAction(ae);
            }
        });
        panelTwoHoursLeave.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                panelTwoHoursLeave_processAction(ae);
            }
        });



    }

    public PanelPopup getPnMessage() {
        return pnMessage;
    }
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private HtmlInputText txtEmployeeID = new HtmlInputText();

    public HtmlInputText getTxtEmployeeID() {
        return txtEmployeeID;
    }

    public void setTxtEmployeeID(HtmlInputText hit) {
        this.txtEmployeeID = hit;
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
    private HtmlSelectBooleanCheckbox chkMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMale() {
        return chkMale;
    }

    public void setChkMale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkFemale() {
        return chkFemale;
    }

    public void setChkFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkFemale = hsbc;
    }
    private HtmlOutputText outputText2 = new HtmlOutputText();

    public HtmlOutputText getOutputText2() {
        return outputText2;
    }

    public void setOutputText2(HtmlOutputText hot) {
        this.outputText2 = hot;
    }
    private HtmlOutputText outputText3 = new HtmlOutputText();

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setOutputText3(HtmlOutputText hot) {
        this.outputText3 = hot;
    }
    private HtmlOutputText lblLeaveStartDateDis = new HtmlOutputText();

    public HtmlOutputText getLblLeaveStartDateDis() {
        return lblLeaveStartDateDis;
    }

    public void setLblLeaveStartDateDis(HtmlOutputText hot) {
        this.lblLeaveStartDateDis = hot;
    }
    private HtmlOutputText lblLeaveEndDate = new HtmlOutputText();

    public HtmlOutputText getLblLeaveEndDate() {
        return lblLeaveEndDate;
    }

    public void setLblLeaveEndDate(HtmlOutputText hot) {
        this.lblLeaveEndDate = hot;
    }
    private HtmlInputText inputText1 = new HtmlInputText();

    public HtmlInputText getInputText1() {
        return inputText1;
    }

    public void setInputText1(HtmlInputText hit) {
        this.inputText1 = hit;
    }
    private HtmlCommandButton btnCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalender() {
        return btnCalender;
    }

    public void setBtnCalender(HtmlCommandButton hcb) {
        this.btnCalender = hcb;
    }
    private HtmlInputText txtReturnDate = new HtmlInputText();

    public HtmlInputText getTxtReturnDate() {
        return txtReturnDate;
    }

    public void setTxtReturnDate(HtmlInputText hit) {
        this.txtReturnDate = hit;
    }
    private HtmlOutputText lblEmploymentStatus = new HtmlOutputText();

    public HtmlOutputText getLblEmploymentStatus() {
        return lblEmploymentStatus;
    }

    public void setLblEmploymentStatus(HtmlOutputText hot) {
        this.lblEmploymentStatus = hot;
    }
    private HtmlOutputText lblLeaveStartDate = new HtmlOutputText();

    public HtmlOutputText getLblLeaveStartDate() {
        return lblLeaveStartDate;
    }

    public void setLblLeaveStartDate(HtmlOutputText hot) {
        this.lblLeaveStartDate = hot;
    }
    private HtmlOutputText c = new HtmlOutputText();

    public HtmlOutputText getC() {
        return c;
    }

    public void setC(HtmlOutputText hot) {
        this.c = hot;
    }
    private HtmlOutputText lblReason = new HtmlOutputText();

    public HtmlOutputText getLblReason() {
        return lblReason;
    }

    public void setLblReason(HtmlOutputText hot) {
        this.lblReason = hot;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public ReturntoJobManager getReturntoJobManager() {
        return returntoJobManager;
    }

    public void setReturntoJobManager(ReturntoJobManager returntoJobManager) {
        this.returntoJobManager = returntoJobManager;
    }

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData selectBooleanCheckbox2Bean) {
        this.selectBooleanCheckbox2Bean = selectBooleanCheckbox2Bean;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlSelectOneListbox listemployeeOnLeave = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListemployeeOnLeave() {
        return listemployeeOnLeave;
    }

    public void setListemployeeOnLeave(HtmlSelectOneListbox hsol) {
        this.listemployeeOnLeave = hsol;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems1() {
        return selectOneListbox1DefaultItems1;
    }

    public void setSelectOneListbox1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems2() {
        return selectOneListbox1DefaultItems2;
    }

    public void setSelectOneListbox1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems3() {
        return selectOneListbox1DefaultItems3;
    }

    public void setSelectOneListbox1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems3 = dsia;
    }
    private PanelCollapsible pnl_col_Status = new PanelCollapsible();

    public PanelCollapsible getPnl_col_Status() {
        return pnl_col_Status;
    }

    public void setPnl_col_Status(PanelCollapsible pc) {
        this.pnl_col_Status = pc;
    }
    private PanelCollapsible panelCollapsible1 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible1() {
        return panelCollapsible1;
    }

    public void setPanelCollapsible1(PanelCollapsible pc) {
        this.panelCollapsible1 = pc;
    }
    private SelectInputDate siDCalender = new SelectInputDate();

    public SelectInputDate getSiDCalender() {
        return siDCalender;
    }

    public void setSiDCalender(SelectInputDate sid) {
        this.siDCalender = sid;
    }
    private PanelCollapsible pnl_col_Common_Tasks = new PanelCollapsible();

    public PanelCollapsible getPnl_col_Common_Tasks() {
        return pnl_col_Common_Tasks;
    }

    public void setPnl_col_Common_Tasks(PanelCollapsible pc) {
        this.pnl_col_Common_Tasks = pc;
    }
    private HtmlOutputText lblLeaveTypeDes = new HtmlOutputText();

    public HtmlOutputText getLblLeaveTypeDes() {
        return lblLeaveTypeDes;
    }

    public void setLblLeaveTypeDes(HtmlOutputText hot) {
        this.lblLeaveTypeDes = hot;
    }
    private HtmlSelectOneRadio radEmployeeType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadEmployeeType() {
        return radEmployeeType;
    }

    public void setRadEmployeeType(HtmlSelectOneRadio hsor) {
        this.radEmployeeType = hsor;
    }
    private HtmlSelectOneRadio radWorkIn = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadWorkIn() {
        return radWorkIn;
    }

    public void setRadWorkIn(HtmlSelectOneRadio hsor) {
        this.radWorkIn = hsor;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlOutputText lblRequestedReturnDate = new HtmlOutputText();

    public HtmlOutputText getLblRequestedReturnDate() {
        return lblRequestedReturnDate;
    }

    public void setLblRequestedReturnDate(HtmlOutputText hot) {
        this.lblRequestedReturnDate = hot;
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
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems4() {
        return selectOneListbox1DefaultItems4;
    }

    public void setSelectOneListbox1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems5() {
        return selectOneListbox1DefaultItems5;
    }

    public void setSelectOneListbox1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems6() {
        return selectOneListbox1DefaultItems6;
    }

    public void setSelectOneListbox1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems6 = dsia;
    }
    private PanelCollapsible panelTwoHoursLeave = new PanelCollapsible();

    public PanelCollapsible getPanelTwoHoursLeave() {
        return panelTwoHoursLeave;
    }

    public void setPanelTwoHoursLeave(PanelCollapsible pc) {
        this.panelTwoHoursLeave = pc;
    }
    private PanelPopup pnExtendLeave = new PanelPopup();

    public PanelPopup getPnExtendLeave() {
        return pnExtendLeave;
    }

    public void setPnExtendLeave(PanelPopup pp) {
        this.pnExtendLeave = pp;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private HtmlCommandButton btnExtendLeave = new HtmlCommandButton();

    public HtmlCommandButton getBtnExtendLeave() {
        return btnExtendLeave;
    }

    public void setBtnExtendLeave(HtmlCommandButton hcb) {
        this.btnExtendLeave = hcb;
    }
    private HtmlInputText txtNumberOfDays = new HtmlInputText();

    public HtmlInputText getTxtNumberOfDays() {
        return txtNumberOfDays;
    }

    public void setTxtNumberOfDays(HtmlInputText hit) {
        this.txtNumberOfDays = hit;
    }
    private SelectInputDate calStartFrom = new SelectInputDate();

    public SelectInputDate getCalStartFrom() {
        return calStartFrom;
    }

    public void setCalStartFrom(SelectInputDate sid) {
        this.calStartFrom = sid;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(HtmlCommandButton hcb) {
        this.btnCancel = hcb;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ManageEmployeeLeaveStatus() {
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
        loadListOfNotReturnOntime();
        setEmployeeListRequestedReturnFromLeave(requestFromLeaveManager.readEmployeeRequesteToReturnFromLeave());
        setEmployeesOnTwoHoursLeave(leaveManager.selectEmployeeOnTwoHoursLeave());
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        pnl_col_Status.setExpanded(true);
        panelCollapsible1.setExpanded(false);
        pnl_col_Common_Tasks.setExpanded(false);
        panelTwoHoursLeave.setExpanded(false);
        panelTwoHoursLeave.setExpanded(false);
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

    public String btnExtendLeave_action() {
        try {
            pnExtendLeave.setRendered(true);
        } catch (Exception e) {

            e.printStackTrace();
        }
        //return null means stay on the same page
        return null;
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

    public String btnSearch_action() {
        displayEployee(txtEmployeeID.getValue().toString());
        //return null means stay on the same page
        return null;

    }

    void displayEployee(String leaveId) {
        try {
            if (employeeId != null) {

                if (employeeManager.loadEmpoyeeProfile(employeeId) == 1) {
                    if (!employeeManager.getEmp_Status().equals("01")) {

                        this.lblFull_Name.setValue(employeeManager.getTitleDes() + " " +
                                employeeManager.getFirst_Name() + " " +
                                "" + employeeManager.getMiddle_Name() + " " +
                                employeeManager.getLast_Name());
                        empStatus = employeeManager.getEmp_Status();
                        sex = employeeManager.getSex();
                        try {
                            OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                            setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                            imgEmployeePicture.setValue(getEmployeePicture());
                        } catch (Exception ex) {
                        }
                        if (sex.equalsIgnoreCase("Male")) {
                            chkMale.setSelected(true);
                            chkFemale.setSelected(false);
                        } else if (sex.equalsIgnoreCase("Female")) {
                            chkFemale.setSelected(true);
                            chkMale.setSelected(false);
                        } else {
                            chkMale.setSelected(false);
                            chkFemale.setSelected(false);
                        }
                        if (empStatus.equals("01")) {
                            lblEmploymentStatus.setValue("ACTIVE");
                        } else {
                            lblEmploymentStatus.setValue("INACTIVE");
                        }

                        this.lblPosition.setValue(employeeManager.getJobName());
                        lblDepartment.setValue(employeeManager.departmentDetileDescription(
                                employeeManager.getDepartmentId()));
                        lblRequestedReturnDate.setValue(":");
                        if (empStatus.equals("02")) {
                            HashMap leaveData = returntoJobManager.readEmpLeaveInfo(leaveId);
                            lblLeaveStartDateDis.setValue(leaveData.get("REQUESTED_FROM_DATE"));
                            lblLeaveEndDate.setValue(leaveData.get("REQUESTED_TO_DATE"));
                            leaveDays = leaveData.get("LEAVE_DAYS").toString();
                            lblLeaveTypeDes.setValue(leaveData.get("DESCRIPTION").toString());
                            leaveRequestId = leaveData.get("LEAVE_ID").toString();
                            if (isGetLeavePass) {
                                isGetLeavePass = false;
                                lblRequestedReturnDate.setValue(leaveData.get("STARTTIME").toString() + "-----" + leaveData.get("ENDTIME").toString());
                            }
                        }

                        if (leaveType != null) {
                            String leaveTypeDescription = leaveTypeManager.readLeaveTypeDesc(leaveType);
                            
                            lblLeaveTypeDes.setValue(leaveTypeDescription);
                        }
                        if (employeeManager.getOfficeOrShift().equals("Shift")) {
                            choShift.setSelected(true);
                            choOffice.setSelected(false);
                        } else {
                            choShift.setSelected(false);
                            choOffice.setSelected(true);
                        }

                        if (employeeManager.employeeWorkingPlace(employeeManager.getDepartmentId()).equalsIgnoreCase("Addis Ababa")) {
                            choAddisAbeba.setSelected(false);
                            choMugher.setSelected(true);


                        } else {
                            choAddisAbeba.setSelected(true);
                            choMugher.setSelected(false);

                        }

                    } else {
                        this.showSuccessOrFailureMessage(false, "This employee already active.");
                    }


                } else {
                    this.showSuccessOrFailureMessage(false, "Unable To Find The record");

                }
            } else {
                this.showSuccessOrFailureMessage(false, "Unable To Find The record");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void displayEmployeeReturnFromLeave(String employeeId, String requestStatus, String requestedDate) {
//            approveReturnFromLeaveManager
        try {
            if (employeeId != null) {
                HashMap hm = approveReturnFromLeaveManager.readEmployeeLeaveRequest(
                        employeeId,
                        requestStatus,
                        requestedDate);

                if (hm != null) {

                    this.lblFull_Name.setValue(hm.get("FULLNAME"));
                    sex = hm.get("SEX").toString();
                    employeementType=hm.get("EMPLOYMENTTYPE").toString();
                    workingLocation=hm.get("OFFICE_OR_SHIFT").toString();
                    try {
                        OracleSerialBlob blo = (OracleSerialBlob) hm.get("PHOTO");
                        setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                        imgEmployeePicture.setValue(getEmployeePicture());
                    } catch (Exception ex) {
                    }
                    if (sex.equalsIgnoreCase("Male")) {
                        chkMale.setSelected(true);
                        chkFemale.setSelected(false);
                    } else if (sex.equalsIgnoreCase("Female")) {
                        chkFemale.setSelected(true);
                        chkMale.setSelected(false);
                    } else {
                        chkMale.setSelected(false);
                        chkFemale.setSelected(false);
                    }
                     if (employeementType.equalsIgnoreCase("Shift")) {
                            choShift.setSelected(true);
                            choOffice.setSelected(false);
                        } else {
                            choShift.setSelected(false);
                            choOffice.setSelected(true);
                        }

                        if (workingLocation.equalsIgnoreCase("Addis Ababa")) {
                            choAddisAbeba.setSelected(false);
                            choMugher.setSelected(true);


                        } else {
                            choAddisAbeba.setSelected(true);
                            choMugher.setSelected(false);

                        }


                    if (hm.get("EMP_STATUS").toString().equals("01")) {
                        lblEmploymentStatus.setValue("ACTIVE");
                    } else {
                        lblEmploymentStatus.setValue("INACTIVE");
                    }
                    this.lblPosition.setValue(hm.get("JOB_NAME"));
                    lblDepartment.setValue(hm.get("DEP_DESCRIPTION"));
                    lblLeaveStartDateDis.setValue(hm.get("REQUESTED_FROM_DATE"));
                    lblLeaveEndDate.setValue(hm.get("REQUESTED_TO_DATE"));
                    lblLeaveTypeDes.setValue(hm.get("DESCRIPTION"));
                    lblRequestedReturnDate.setValue(hm.get("RETURN_DATE"));
                  //  leaveRequestId = hm.get("REQUEST_ID").toString();


                } else {
                    this.showSuccessOrFailureMessage(false, "Unable To Find The record");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String btnNew_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {
        String empId = null;
        String returnDate = null;
        empId = txtEmployeeID.getValue().toString();
        returnDate = txtReturnDate.getValue().toString();


        if (returntoJobManager.saveReturnToJobInformation(
                empId,
                returnDate,
                leaveRequestId,
                lblLeaveEndDate.getValue().toString())) {
            this.showSuccessOrFailureMessage(true, "This Employee Leave information updated Successfully .");
            clearReturnToJobTextComponents();
            loadListOfNotReturnOntime();
            btnCalender.setRendered(true);
            btnTime.setRendered(false);
            txtReturnDate.setValue("");
        } else {
            this.showSuccessOrFailureMessage(false, "This Employee Leave information not updated ? please try please try again ?");
        }










//        if (!checkReturnFromLeave) {
//            if (leaveType != null) {
//                if (leaveType.equals(LeaveTypeManager.LEAVE_TYPE_ANNUALLEAVE)) {
//                    String employeeType, workin;
//                    if (choOffice.isSelected()) {
//                        employeeType = "Office";
//                    } else {
//                        employeeType = "Shift";
//                    }
//                    if (choMugher.isSelected()) {
//                        workin = "Mugher";
//                    } else {
//                        workin = "AddisAbeba";
//                    }
//                    if (returntoJobManager.saveReturnToJobAndAnualLeaveInformation(
//                            empId,
//                            returnDate,
//                            leaveRequestId,
//                            lblLeaveEndDate.getValue().toString(),
//                            employeeType,
//                            workin)) {
//                        this.showSuccessOrFailureMessage(true, "This Employee Leave information updated Successfully .");
//                        loadListOfNotReturnOntime();
//                        clearReturnToJobTextComponents();
//                    } else {
//                        this.showSuccessOrFailureMessage(false, "This Employee Leave information not updated ? please try please try again ?");
//                    }
//
//
//                } else {
//                    if (returntoJobManager.saveReturnToJobInformation(
//                            empId,
//                            returnDate,
//                            leaveRequestId,
//                            lblLeaveEndDate.getValue().toString())) {
//                        this.showSuccessOrFailureMessage(true, "This Employee Leave information updated Successfully .");
//                        clearReturnToJobTextComponents();
//                        loadListOfNotReturnOntime();
//                    } else {
//                        this.showSuccessOrFailureMessage(false, "This Employee Leave information not updated ? please try please try again ?");
//                    }
//                }
//            } else {
//                this.showSuccessOrFailureMessage(false, "This Employee Leave information not updated ? please try please try again ?");
//            }
//        } else {
//            if (returntoJobManager.updateEmployeeReturnLeaveInformation(
//                    empId,
//                    returnDate,
//                    leaveRequestId)) {
//                this.showSuccessOrFailureMessage(true, "This Employee Leave information updated Successfully .");
//                clearReturnToJobTextComponents();
//                loadListOfNotReturnOntime();
//            } else {
//                this.showSuccessOrFailureMessage(false, "This Employee Leave information not updated.Please try agine ?" +
//                        "");
//            }
//        }



//        if (returntoJobManager.saveReturnToJobInformation(empId, returnDate, leaveRequestId, leaveType)) {
//            if (leaveManager.updateEmployeeStatus(empId, "01") == 1) {
//                this.showSuccessOrFailureMessage(true, "Employee Return to Job " +
//                        " Information Is Successfully Posted");
//            }
//        } else {
//            this.showSuccessOrFailureMessage(false, "Error Occured While Saving.");
//
//        }
        return null;
    }

    public String btnEdit_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCancel_action() {
        btnCalender.setRendered(true);
        btnTime.setRendered(false);
        txtReturnDate.setValue("");
        //return null means stay on the same page
        return null;
    }

    public void clearReturnToJobTextComponents() {
        txtReturnDate.resetValue();
        lblLeaveEndDate.setValue("");
        lblFull_Name.setValue("");
        lblDepartment.setValue("");
        lblPosition.setValue("");
        chkMale.setSelected(false);
        chkFemale.setSelected(false);
        choOffice.setSelected(false);
        choShift.setSelected(false);
        choAddisAbeba.setSelected(false);
        choMugher.setSelected(false);
        lblLeaveTypeDes.setValue("");
        lblLeaveEndDate.setValue("");
        lblLeaveStartDateDis.setValue("");
        lblRequestedReturnDate.setValue("");
        txtReturnDate.setValue("");
        imgEmployeePicture.setValue("");

    }

    private void loadListOfNotReturnOntime() {
        setEmployeesOnLeave(leaveManager.selectEmployeeOnLeave());
        setEmployeesNotReturnOnTime(leaveManager.selectEmployeeNotReturnOnTimeFromLeave());
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    public void listemployeeOnLeave_processValueChange(ValueChangeEvent vce)
    {
        checkReturnFromLeave = false;
        try {
            if (vce.getNewValue() != null) {
                String listValue[] = vce.getNewValue().toString().split("-");
                txtEmployeeID.setValue(listValue[0]);
                employeeId = listValue[0];
                leaveType = listValue[1];
                leaveRequestId = listValue[2];
                displayEployee(leaveRequestId);
                btnSave.setDisabled(false);
                btnCalender.setRendered(true);
                btnTime.setRendered(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void slctEmployeeOnProvation_processValueChange(ValueChangeEvent vce) {
        try {
            checkReturnFromLeave = false;
            if (vce.getNewValue() != null) {               
                String listValue[] = vce.getNewValue().toString().split("-");
                txtEmployeeID.setValue(listValue[1]);
                employeeId = listValue[1];
                displayEployee(listValue[0]);
                btnSave.setDisabled(false);
                btnCalender.setRendered(true);
                btnTime.setRendered(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void siDCalender_processValueChange(ValueChangeEvent vce) {
        txtReturnDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        siDCalender.setRendered(false);
    }

    public String btnCalenderReturnDate_action() {
        siDCalender.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void pnl_col_Common_Tasks_processAction(ActionEvent ae) {
        pnl_col_Status.setExpanded(false);
        panelCollapsible1.setExpanded(false);
        pnl_col_Common_Tasks.setExpanded(true);
        panelTwoHoursLeave.setExpanded(true);
        panelTwoHoursLeave.setExpanded(false);

    }

    public void listemployeeOnLeavee_processValueChange(ValueChangeEvent vce)
    {
        checkReturnFromLeave = true;
        String employeeId;
        String requestStatus;
        String requestedDate;

        try {
            if (vce.getNewValue() != null)
            {
                String listValue[] = vce.getNewValue().toString().split("=");
                txtEmployeeID.setValue(listValue[0]);
                employeeId = listValue[0];
                requestStatus = listValue[1];
                requestedDate = listValue[2];
                leaveRequestId= listValue[3];
                
                displayEmployeeReturnFromLeave(
                        employeeId,
                        requestStatus,
                        requestedDate);
                btnCalender.setRendered(true);
                btnTime.setRendered(false);
                btnSave.setDisabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void panelCollapsible1_processAction(ActionEvent ae) {
        pnl_col_Status.setExpanded(false);
        panelCollapsible1.setExpanded(true);
        panelTwoHoursLeave.setExpanded(false);
        pnl_col_Common_Tasks.setExpanded(false);
    }

    public void panelTwoHoursLeave_processAction(ActionEvent ae) {
        panelTwoHoursLeave.setExpanded(true);
        pnl_col_Status.setExpanded(false);
        panelCollapsible1.setExpanded(false);
        pnl_col_Common_Tasks.setExpanded(false);


    }

    public void pnl_col_Status_processAction(ActionEvent ae) {
        pnl_col_Status.setExpanded(true);
        panelCollapsible1.setExpanded(false);
        pnl_col_Common_Tasks.setExpanded(false);
        panelTwoHoursLeave.setExpanded(false);

    }

    public void slctTwoHoursLeave_processValueChange(ValueChangeEvent vce) {
        try {

            checkReturnFromLeave = false;
            if (vce.getNewValue() != null) {
                String emp[] = vce.getNewValue().toString().split("#");
                employeeId = emp[0];
                 isGetLeavePass = true;
                txtEmployeeID.setValue(emp[0]);
                displayEployee(emp[2].trim());
                btnSave.setDisabled(false);
                btnCalender.setRendered(false);
                btnTime.setRendered(true);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public String modalPnlCloseExtendLeave_action() {
        pnExtendLeave.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String getEmployeementType() {
        return employeementType;
    }

    public void setEmployeementType(String employeementType) {
        this.employeementType = employeementType;
    }

    public String getWorkingLocation() {
        return workingLocation;
    }

    public void setWorkingLocation(String workingLocation) {
        this.workingLocation = workingLocation;
    }

    private HashMap listOfData() {
        HashMap hm = new HashMap();
        String employeementType = "";
        String workIn = "";
        if (choAddisAbeba.isSelected()) {
            workIn = "AddisAbeba";
        } else if (choMugher.isSelected()) {
            workIn = "Other";
        }
        if (choOffice.isSelected()) {
            employeementType = "Office";
        } else if (choShift.isSelected()) {
            employeementType = "Shift";
        }

        hm.put("workIn", workIn);
        hm.put("employeementType", employeementType);
        hm.put("leaveRequestId", leaveRequestId);
        hm.put("employeeId", txtEmployeeID.getValue());
        hm.put("startFrom", dateFormat.format(calStartFrom.getValue()));
        hm.put("numberOfDays", txtNumberOfDays.getValue().toString());
        hm.put("currentDate", dateFormat.format(new Date()));
        hm.put("anualLeaveStartDate", lblLeaveStartDateDis.getValue());
        hm.put("leaveType", lblLeaveTypeDes.getValue());

        hm.put("leaveDays", leaveDays);






        return hm;
    }

    public String btnModify_action() {


        approveReturnFromLeaveManager.modifyAnualLeave(listOfData());
        //return null means stay on the same page
        return null;
    }

    public ArrayList<HashMap> getTableHour() {
        return overTimeRequestManager.getTableHour();
    }

    public String button1_action() {
        startOrEnd = "Start";
        String style = "border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 100px; top: 80px; overflow: auto; position: absolute; width: 280px";
        pnlLayoutTimePanel.setStyle(style);
        pnlLayoutTimePanel.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void lnkShowTime_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            if (startOrEnd.equals("Start")) {
                txtReturnDate.setValue(displayedTime);
            } else {// if (startOrEnd.equals("End")) {
                txtReturnDate.setValue(displayedTime);
            }
            pnlLayoutTimePanel.setRendered(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
