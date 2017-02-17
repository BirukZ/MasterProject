/*
 * AttendancePage.java
 *
 * Created on Dec 12, 2012, 12:12:04 PM
 * Copyright Administrator
 */
package fphrms.Attendance;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.EmployeeList;
import fphrms.RequestBean1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.attendanceManager.AttendanceManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class AttendancePage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private EmployeeList currentEmployee1 = new EmployeeList("", "0", null);
    private EmployeeManage employeeManage = new EmployeeManage();
    private AttendanceManager attendanceManager = new AttendanceManager();
    private ArrayList<SelectItem> stateLists;
    private ArrayList<SelectItem> monthLists = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> leaveType = new ArrayList<SelectItem>();
    private String employeeId;
    private String employeeName;
    private String attendanceTakeDate;
    private int tableSize = 0;
    private int absenceId = 0;
    private boolean firstTime = true;
    private int row = -1;
    private ArrayList<AbsenteesModelLoad> attendanceAbsenteesLoad = new ArrayList<AbsenteesModelLoad>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<SelectItem> getMonthLists() {
        return monthLists;
    }

    public void setMonthLists(ArrayList<SelectItem> monthLists) {
        this.monthLists = monthLists;
    }

    public ArrayList<SelectItem> getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(ArrayList<SelectItem> leaveType) {
        this.leaveType = leaveType;
    }

    public ArrayList<AbsenteesModelLoad> getAttendanceAbsenteesLoad() {
        return attendanceAbsenteesLoad;
    }

    public void setAttendanceAbsenteesLoad(ArrayList<AbsenteesModelLoad> attendanceAbsenteesLoad) {
        this.attendanceAbsenteesLoad = attendanceAbsenteesLoad;
    }

    public AttendanceManager getAttendanceManager() {
        return attendanceManager;
    }

    public void setAttendanceManager(AttendanceManager attendanceManager) {
        this.attendanceManager = attendanceManager;
    }

    public ArrayList<SelectItem> getStateLists() {
        return stateLists;
    }

    public void setStateLists(ArrayList<SelectItem> stateLists) {
        this.stateLists = stateLists;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        if (firstTime) {
            firstTime = false;
            txtfAbsentDate.setValue(sdf.format(new Date()));
            stateLists = attendanceManager.stateTypes();
            lblAfternoon.setRendered(false);
            lblMorning.setRendered(false);
            chkAfternoon.setRendered(false);
            chkMorning.setRendered(false);
            setLeaveType(attendanceManager.getLeveTypes());
            setMonthLists(attendanceManager.getMonthList());
            lblFullName.setValue(getSessionBean1().getEmployeeName());
            stxtDate.setValue(sdf.format(new Date()));
            clearComponet();
            disableComponet();
        }
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drlAbsentValue = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAbsentValue() {
        return drlAbsentValue;
    }

    public void setDrlAbsentValue(HtmlSelectOneMenu hsom) {
        this.drlAbsentValue = hsom;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private SelectInputText txtSearchByName = new SelectInputText();

    public SelectInputText getTxtSearchByName() {
        return txtSearchByName;
    }

    public void setTxtSearchByName(SelectInputText sit) {
        this.txtSearchByName = sit;
    }
    private HtmlInputText txtfAbsentDate = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDate() {
        return txtfAbsentDate;
    }

    public void setTxtfAbsentDate(HtmlInputText hit) {
        this.txtfAbsentDate = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calenderDate = new SelectInputDate();

    public SelectInputDate getCalenderDate() {
        return calenderDate;
    }

    public void setCalenderDate(SelectInputDate sid) {
        this.calenderDate = sid;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
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
    private HtmlOutputText lblMorning = new HtmlOutputText();

    public HtmlOutputText getLblMorning() {
        return lblMorning;
    }

    public void setLblMorning(HtmlOutputText hot) {
        this.lblMorning = hot;
    }
    private HtmlSelectBooleanCheckbox chkMorning = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMorning() {
        return chkMorning;
    }

    public void setChkMorning(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMorning = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkAfternoon = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkAfternoon() {
        return chkAfternoon;
    }

    public void setChkAfternoon(HtmlSelectBooleanCheckbox hsbc) {
        this.chkAfternoon = hsbc;
    }
    private HtmlOutputText lblAfternoon = new HtmlOutputText();

    public HtmlOutputText getLblAfternoon() {
        return lblAfternoon;
    }

    public void setLblAfternoon(HtmlOutputText hot) {
        this.lblAfternoon = hot;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectOneMenu drlAbsentType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAbsentType() {
        return drlAbsentType;
    }

    public void setDrlAbsentType(HtmlSelectOneMenu hsom) {
        this.drlAbsentType = hsom;
    }
    private HtmlCommandButton btnListEmployees = new HtmlCommandButton();

    public HtmlCommandButton getBtnListEmployees() {
        return btnListEmployees;
    }

    public void setBtnListEmployees(HtmlCommandButton hcb) {
        this.btnListEmployees = hcb;
    }
    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(HtmlCommandButton hcb) {
        this.btnSearch = hcb;
    }
    private HtmlCommandButton calDateAttendace = new HtmlCommandButton();

    public HtmlCommandButton getCalDateAttendace() {
        return calDateAttendace;
    }

    public void setCalDateAttendace(HtmlCommandButton hcb) {
        this.calDateAttendace = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
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
    private HtmlInputText txtfAbsentDateSearch = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDateSearch() {
        return txtfAbsentDateSearch;
    }

    public void setTxtfAbsentDateSearch(HtmlInputText hit) {
        this.txtfAbsentDateSearch = hit;
    }
    private HtmlDataTable tblAbsentee = new HtmlDataTable();

    public HtmlDataTable getTblAbsentee() {
        return tblAbsentee;
    }

    public void setTblAbsentee(HtmlDataTable hdt) {
        this.tblAbsentee = hdt;
    }
    private com.icesoft.faces.component.ext.HtmlOutputLabel lblEmployeeFullName = new com.icesoft.faces.component.ext.HtmlOutputLabel();

    public com.icesoft.faces.component.ext.HtmlOutputLabel getLblEmployeeFullName() {
        return lblEmployeeFullName;
    }

    public void setLblEmployeeFullName(com.icesoft.faces.component.ext.HtmlOutputLabel hol) {
        this.lblEmployeeFullName = hol;
    }
    private PanelPopup pnlMonthlyPayRollDay = new PanelPopup();

    public PanelPopup getPnlMonthlyPayRollDay() {
        return pnlMonthlyPayRollDay;
    }

    public void setPnlMonthlyPayRollDay(PanelPopup pp) {
        this.pnlMonthlyPayRollDay = pp;
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
    private HtmlInputText txtAbsentEndDate = new HtmlInputText();

    public HtmlInputText getTxtAbsentEndDate() {
        return txtAbsentEndDate;
    }

    public void setTxtAbsentEndDate(HtmlInputText hit) {
        this.txtAbsentEndDate = hit;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate sid) {
        this.calEndDate = sid;
    }
    private HtmlInputText txtAbsentStartDate = new HtmlInputText();

    public HtmlInputText getTxtAbsentStartDate() {
        return txtAbsentStartDate;
    }

    public void setTxtAbsentStartDate(HtmlInputText hit) {
        this.txtAbsentStartDate = hit;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private HtmlInputText txtAbsentEmployeeFullName = new HtmlInputText();

    public HtmlInputText getTxtAbsentEmployeeFullName() {
        return txtAbsentEmployeeFullName;
    }

    public void setTxtAbsentEmployeeFullName(HtmlInputText hit) {
        this.txtAbsentEmployeeFullName = hit;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private PanelPopup employeePlanPopUpMsg = new PanelPopup();

    public PanelPopup getEmployeePlanPopUpMsg() {
        return employeePlanPopUpMsg;
    }

    public void setEmployeePlanPopUpMsg(PanelPopup pp) {
        this.employeePlanPopUpMsg = pp;
    }
    private HtmlOutputText lblemployeePopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblemployeePopUpMsgMain() {
        return lblemployeePopUpMsgMain;
    }

    public void setLblemployeePopUpMsgMain(HtmlOutputText hot) {
        this.lblemployeePopUpMsgMain = hot;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private com.icesoft.faces.component.ext.HtmlOutputLabel stxtDate = new com.icesoft.faces.component.ext.HtmlOutputLabel();

    public com.icesoft.faces.component.ext.HtmlOutputLabel getStxtDate() {
        return stxtDate;
    }

    public void setStxtDate(com.icesoft.faces.component.ext.HtmlOutputLabel hol) {
        this.stxtDate = hol;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDateBean selectInputDateBean3 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean3() {
        return selectInputDateBean3;
    }

    public void setSelectInputDateBean3(SelectInputDateBean sidb) {
        this.selectInputDateBean3 = sidb;
    }
    private SelectInputDateBean selectInputDate3Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate3Bean() {
        return selectInputDate3Bean;
    }

    public void setSelectInputDate3Bean(SelectInputDateBean sidb) {
        this.selectInputDate3Bean = sidb;
    }
    private HtmlInputText stxtDateFrom = new HtmlInputText();

    public HtmlInputText getStxtDateFrom() {
        return stxtDateFrom;
    }

    public void setStxtDateFrom(HtmlInputText hit) {
        this.stxtDateFrom = hit;
    }
    private HtmlSelectOneMenu drlMonth = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlMonth() {
        return drlMonth;
    }

    public void setDrlMonth(HtmlSelectOneMenu hsom) {
        this.drlMonth = hsom;
    }
    private SelectInputDate calDateFrom = new SelectInputDate();

    public SelectInputDate getCalDateFrom() {
        return calDateFrom;
    }

    public void setCalDateFrom(SelectInputDate sid) {
        this.calDateFrom = sid;
    }
    private PanelPopup pnlpopupAbsentee = new PanelPopup();

    public PanelPopup getPnlpopupAbsentee() {
        return pnlpopupAbsentee;
    }

    public void setPnlpopupAbsentee(PanelPopup pp) {
        this.pnlpopupAbsentee = pp;
    }
    private SelectInputDate calSearchDate = new SelectInputDate();

    public SelectInputDate getCalSearchDate() {
        return calSearchDate;
    }

    public void setCalSearchDate(SelectInputDate sid) {
        this.calSearchDate = sid;
    }
    private HtmlInputText stxtToDate = new HtmlInputText();

    public HtmlInputText getStxtToDate() {
        return stxtToDate;
    }

    public void setStxtToDate(HtmlInputText hit) {
        this.stxtToDate = hit;
    }
    private SelectInputDate calToDate = new SelectInputDate();

    public SelectInputDate getCalToDate() {
        return calToDate;
    }

    public void setCalToDate(SelectInputDate sid) {
        this.calToDate = sid;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AttendancePage() {
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
    @Override
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
            log("AttendancePage Initialization Failure", e);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public static class AbsenteesModelLoad implements Serializable {

        private int absenceId;
        private String empId;
        private String empFullName;
        private String absentAmout;
        private String requestStatus;
        private String requestDate;
        private String dayDescription;
        private String absentType;
        private boolean selectedEmp;

        public boolean isSelectedEmp() {
            return selectedEmp;
        }

        public void setSelectedEmp(boolean selectedEmp) {
            this.selectedEmp = selectedEmp;
        }

        public String getAbsentType() {
            return absentType;
        }

        public void setAbsentType(String absentType) {
            this.absentType = absentType;
        }

        public String getDayDescription() {
            return dayDescription;
        }

        public void setDayDescription(String dayDescription) {
            this.dayDescription = dayDescription;
        }

        public String getAbsentAmout() {
            return absentAmout;
        }

        public void setAbsentAmout(String absentAmout) {
            this.absentAmout = absentAmout;
        }

        public String getRequestDate() {
            return requestDate;
        }

        public void setRequestDate(String requestDate) {
            this.requestDate = requestDate;
        }

        public String getEmpFullName() {
            return empFullName;
        }

        public void setEmpFullName(String empFullName) {
            this.empFullName = empFullName;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public int getAbsenceId() {
            return absenceId;
        }

        public void setAbsenceId(int absenceId) {
            this.absenceId = absenceId;
        }

        public String getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(String requestStatus) {
            this.requestStatus = requestStatus;
        }

        public AbsenteesModelLoad(
                int absenceId,
                String empId,
                String empFullName,
                String absentAmout,
                String requestStatus,
                String requestDate,
                String dayDescription,
                String absentType) {
            this.absenceId = absenceId;
            this.empId = empId;
            this.empFullName = empFullName;
            this.absentAmout = absentAmout;
            this.requestStatus = requestStatus;
            this.requestDate = requestDate;
            this.dayDescription = dayDescription;
            this.absentType = absentType;
        }
    }

    public String btnListEmployees_action() {
        String dayDesc = "FullDay";
        if (drlAbsentValue.getValue().toString().equals("1/2")) {
            if (chkAfternoon.isSelected()) {
                dayDesc = "Afternoon";
            } else if (chkMorning.isSelected()) {
                dayDesc = "Morning";
            }
        }
        getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(0,
                employeeId,
                employeeName,
                drlAbsentValue.getValue().toString(),
                "ok",
                txtfAbsentDate.getValue().toString(),
                dayDesc,
                drlAbsentType.getValue().toString()));
        clearComponet();

        //return null means stay on the same page
        return null;
    }

    public String selectInputText1_action() {
        employeeId = null;
        employeeId = ApplicationBean1.getSelectedEmployeeId();
        employeeName = txtSearchByName.getValue().toString();
        txtAbsentEmployeeFullName.setValue(employeeName);


        //return null means stay on the same page
        return null;
    }

    public void calenderDate_processValueChange(ValueChangeEvent vce) {
        txtfAbsentDate.setValue(sdf.format((Date) vce.getNewValue()));
        calenderDate.setRendered(false);
    }

    public String calDateAttendace_action() {
        calenderDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {

        //return null means stay on the same page
        return null;
    }

    public String txtSearchByName_action() {
        employeeName = ApplicationBean1.getSelectedEmployeeName();
        txtAbsentEmployeeFullName.setValue(employeeName);
        employeeId = ApplicationBean1.getSelectedEmployeeId();
        txtEmployeeId.setValue(employeeId);
        //return null means stay on the same page
        return null;
    }

    public String button1_action() {
        //return null means stay on the same page
        return null;
    }

    public void chkMorning_processValueChange(ValueChangeEvent vce) {
        chkAfternoon.setSelected(false);
    }

    public void chkAfternoon_processValueChange(ValueChangeEvent vce) {
        chkMorning.setSelected(false);
    }

    public void drlAbsentValue_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (vce.getNewValue().equals("1/2")) {
                lblAfternoon.setRendered(true);
                lblMorning.setRendered(true);
                chkAfternoon.setRendered(true);
                chkMorning.setRendered(true);
            } else {
                lblAfternoon.setRendered(false);
                lblMorning.setRendered(false);
                chkAfternoon.setRendered(false);
                chkMorning.setRendered(false);
            }
        }
    }

    private void clearComponet() {
        selectOneMenu1Bean.setSelectedObject(null);
        defaultSelectedData3.setSelectedObject(null);
        txtSearchByName.setValue("");
        txtEmployeeId.setValue("");
        txtAbsentEmployeeFullName.setValue("");
        chkMorning.setSelected(false);
        chkAfternoon.setSelected(false);
        lblMorning.setRendered(false);
        lblAfternoon.setRendered(false);
        chkMorning.setRendered(false);
        chkAfternoon.setRendered(false);

    }

    private void disableComponet() {
        txtfAbsentDate.setDisabled(true);
        txtSearchByName.setDisabled(true);
        txtEmployeeId.setDisabled(true);
        drlAbsentValue.setDisabled(true);
        drlAbsentType.setDisabled(true);
        btnListEmployees.setDisabled(true);
        btnSearch.setDisabled(true);
        calDateAttendace.setDisabled(true);
    }

    private void enableComponet() {
        txtfAbsentDate.setDisabled(false);
        txtSearchByName.setDisabled(false);
        txtEmployeeId.setDisabled(false);
        drlAbsentValue.setDisabled(false);
        drlAbsentType.setDisabled(false);
        btnListEmployees.setDisabled(false);
        btnSearch.setDisabled(false);
        calDateAttendace.setDisabled(false);
        getAttendanceAbsenteesLoad().clear();
    }

    private ArrayList<HashMap> lsitOfEmployee() {
        ArrayList<HashMap> listOfAbesnt = new ArrayList<HashMap>();

        for (AbsenteesModelLoad absenteesEmp : getAttendanceAbsenteesLoad()) {
            HashMap hm = new HashMap();
            hm.put("employeeId", absenteesEmp.getEmpId());
            hm.put("AbsentAmout", absenteesEmp.getAbsentAmout());
            hm.put("AbsentType", absenteesEmp.getAbsentType());
            hm.put("DayDescription", absenteesEmp.getDayDescription());
            hm.put("absentDate", txtfAbsentDate.getValue().toString());


            listOfAbesnt.add(hm);
        }

        return listOfAbesnt;
    }

    private HashMap lsitOfAbsentInf() {

        String dayDesc = "FullDay";
        if (drlAbsentValue.getValue().toString().equals("1/2")) {
            if (chkAfternoon.isSelected()) {
                dayDesc = "Afternoon";
            } else if (chkMorning.isSelected()) {
                dayDesc = "Morning";
            }
        }

        HashMap hm = new HashMap();
        hm.put("employeeId", employeeId);
        hm.put("AbsentAmout", drlAbsentValue.getValue().toString());
        hm.put("AbsentType", drlAbsentType.getValue().toString());
        hm.put("DayDescription", dayDesc);
        hm.put("absentDate", txtfAbsentDate.getValue().toString());
        hm.put("StartDate", txtAbsentStartDate.getValue().toString());
        hm.put("endDate", txtAbsentEndDate.getValue().toString());

        return hm;
    }

    private HashMap updateOfAbsentInf() {

        String dayDesc = "FullDay";
        if (drlAbsentValue.getValue().toString().equals("1/2")) {
            if (chkAfternoon.isSelected()) {
                dayDesc = "Afternoon";
            } else if (chkMorning.isSelected()) {
                dayDesc = "Morning";
            }
        }

        HashMap hm = new HashMap();
        hm.put("employeeId", employeeId);
        hm.put("AbsentAmout", drlAbsentValue.getValue().toString());
        hm.put("AbsentType", drlAbsentType.getValue().toString());
        hm.put("DayDescription", dayDesc);
        hm.put("absentDate", txtfAbsentDate.getValue().toString());
        hm.put("absentId", absenceId);


        return hm;
    }

    public String btnSave_action() {
        if (attendanceManager.saveAttendance(lsitOfEmployee(),
                getSessionBean1().getEmployeeId())) {
            clearComponet();
            disableComponet();
            showSuccessOrFailureMessage(true, "Employee absent Information Saved Successfully Saved !");
        } else {
            showSuccessOrFailureMessage(false, "Employee absent Information not Saved. Please try Again ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnTakeAttendance_action() {
        clearComponet();
        enableComponet();
        btnSave.setDisabled(false);


        //return null means stay on the same page
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
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
        //return null means stay on the same page
        return null;
    }

    public String btnSearchAttendance_action() {
        searchAttendance(txtfAbsentDateSearch.getValue().toString(),
                getSessionBean1().getEmployeeId());

//        searchAttendance(searchDate, departmentIdFromSession);
        //return null means stay on the same page
        return null;
    }

    private void searchAttendance(String val1, String val2) {
        getAttendanceAbsenteesLoad().clear();
        if (val1 != null && val2 != null) {
            try {
                ArrayList<HashMap> loadCandidateList = attendanceManager.readAbsenceEmployee(
                        val1,
                        val2);//load training candidate lists.
//                        tableSize = 0;
                if (loadCandidateList.size() > 0) {
                    for (HashMap hm : loadCandidateList) {
                        getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(
                                Integer.valueOf(hm.get("absenceId").toString()),
                                hm.get("EMP_ID").toString(),
                                hm.get("FULLNAME").toString(),
                                hm.get("ABSENTAMOUNT").toString(),
                                hm.get("STATUS").toString(),
                                hm.get("REGISTERDATE").toString(),
                                hm.get("DAYDESCRIPTION").toString(),
                                hm.get("ABSENTTYPE").toString()));
                        tableSize++;
                        attendanceTakeDate = hm.get("ATTENDANCETAKENDATE").toString();
                    }
                } else {
                    showSuccessOrFailureMessage(false, "No attendance information found.");

                }


            } catch (Exception ex) {
            }
        } else {
            showSuccessOrFailureMessage(false, "Please provide full search criteria to see the search result.");
        }
    }

    public void rwSelectorPeriodList_processMyEvent(RowSelectorEvent rse) {
        try {
            if (tblAbsentee.getRowCount() > 0) {
                row = tblAbsentee.getRowIndex();
                drlAbsentValue.resetValue();
                drlAbsentType.resetValue();
                txtEmployeeId.resetValue();
                txtAbsentEmployeeFullName.resetValue();
//
//                dlstAbsenceType.setDisabled(false);
//                dlstValue.setDisabled(false);
//                txtaDescription.setDisabled(false);
//

                absenceId = Integer.valueOf(getAttendanceAbsenteesLoad().get(row).getAbsenceId());
                drlAbsentValue.setValue(getAttendanceAbsenteesLoad().get(row).getAbsentAmout());
                drlAbsentType.setValue(getAttendanceAbsenteesLoad().get(row).getAbsentType());
                txtEmployeeId.setValue(getAttendanceAbsenteesLoad().get(row).getEmpId());
                txtAbsentEmployeeFullName.setValue(getAttendanceAbsenteesLoad().get(row).getEmpFullName());
                lblFullName.setValue(getAttendanceAbsenteesLoad().get(row).getEmpFullName());
                txtfAbsentDate.setValue(txtfAbsentDateSearch.getValue().toString());
                drlAbsentValue.setDisabled(false);
                drlAbsentType.setDisabled(false);
                btnUpdate.setDisabled(false);
                btnDelete.setDisabled(false);

//                if (getAttendanceAbsenteesLoad().get(row).isSelected025() == true) {
//                    dlstValue.setValue("0.25");
//                } else if (getAttendanceAbsenteesLoad().get(row).isSelected05() == true) {
//                    dlstValue.setValue("0.5");
//                } else if (getAttendanceAbsenteesLoad().get(row).isSelected075() == true) {
//                    dlstValue.setValue("0.75");
//                } else if (getAttendanceAbsenteesLoad().get(row).isSelected10() == true) {
//                    dlstValue.setValue("1.0");
//                }
//                if (getAttendanceAbsenteesLoad().get(row).isReport() == true) {
//                    dlstValue.setValue("01");
//                } else if (getAttendanceAbsenteesLoad().get(row).isCancel() == true) {
//                    dlstValue.setValue("02");
//                } else if (getAttendanceAbsenteesLoad().get(row).isMtaken() == true) {
//                    dlstValue.setValue("03");
//                } else if (getAttendanceAbsenteesLoad().get(row).isMrevoked() == true) {
//                    dlstValue.setValue("04");
//                }
//                txtaDescription.setDisabled(false);
//                dlstEmployeeLists.setValue(getAttendanceAbsenteesLoad().get(row).getEmpId());
//                btnUpdate.setDisabled(false);
//                btnDelete.setDisabled(false);
//                btnTakeAttendance.setDisabled(true);
            }
        } catch (Exception ex) {
        }
    }

    public String linLongAbsent_action() {
        if (employeeId != null) {
            pnlpopupAbsentee.setRendered(true);
            lblEmployeeFullName.setValue(employeeName);
        } else {
            showSuccessOrFailureMessage(false, "Please first Select Employee ?");

        }
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseBtnRequestProcessed_action() {
        pnlMonthlyPayRollDay.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        try {
            txtAbsentEndDate.setValue(sdf.format((Date) vce.getNewValue()));
            calEndDate.setRendered(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String btnEndDate_action() {
        calEndDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnStartDate_action() {
        calStartDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        try {
            txtAbsentStartDate.setValue(sdf.format((Date) vce.getNewValue()));
            calStartDate.setRendered(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String btnAddAbsenteesPOP_action() {

        if (attendanceManager.saveLongAttendanc(lsitOfAbsentInf(),
                getSessionBean1().getEmployeeId())) {
            clearComponet();
            disableComponet();
            pnlpopupAbsentee.setRendered(false);
            showSuccessOrFailureMessage(true, "Employee absent Information Saved Successfully Saved !");
        } else {
            showSuccessOrFailureMessage(false, "Employee absent Information not Saved. Please try Again ?");
        }
        //return null means stay on the same page
        return null;

    }

    public String btnUpdate_action() {
        if (attendanceManager.updateAttendance(updateOfAbsentInf(),
                getSessionBean1().getEmployeeId())) {
            clearComponet();
            disableComponet();
            showSuccessOrFailureMessage(true, "Employee absent Information Updated Successfully  !");
        } else {
            showSuccessOrFailureMessage(false, "Employee absent Information not Updated. Please try Again ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        employeePlanPopUpMsg.setRendered(true);
        lblemployeePopUpMsgMain.setValue("Are you sure you want to delete");
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpYes_action() {
        employeePlanPopUpMsg.setRendered(false);
        if (row != -1) {
            absenceId = Integer.valueOf(getAttendanceAbsenteesLoad().get(row).getAbsenceId());
            if (attendanceManager.deleteAttendance(absenceId)) {
                showSuccessOrFailureMessage(true, "Employee absent Information Deleted Successfully  !");
                clearComponet();
                getAttendanceAbsenteesLoad().clear();

            } else {
                showSuccessOrFailureMessage(false, "Employee absent Information not Deleted. Please try Again ?");
            }
        }
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpNo_action() {
        employeePlanPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String lnkDefineMonthPayrollDay_action() {
        pnlMonthlyPayRollDay.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calDateFrom_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            stxtDateFrom.setValue(sdf.format((Date) vce.getNewValue()));
            calDateFrom.setRendered(false);
        }
    }

    public String btnSavePayrollDate_action() {
        //return null means stay on the same page

        if (attendanceManager.saveMonthlyWorkingDate(drlMonth.getValue().toString(),
                stxtDateFrom.getValue().toString(), stxtToDate.getValue().toString())) {
            pnlMonthlyPayRollDay.setRendered(false);
            showSuccessOrFailureMessage(false, "Monthly Working date  Information Saved Successfully.");
        } else {
            pnlMonthlyPayRollDay.setRendered(false);
            showSuccessOrFailureMessage(false, "Monthly Working date  Information Not Saved . Please try Again ?");
        }
        return null;
    }

    public String CloseBtnRequestProcessedPayRollDay_action() {
        pnlMonthlyPayRollDay.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseBtnRequestProcessed1_action() {
        pnlpopupAbsentee.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void calSearchDate_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            txtfAbsentDateSearch.setValue(sdf.format((Date) vce.getNewValue()));
            calSearchDate.setRendered(false);
        }
    }

    public String calDateAttendaceSearch_action() {
        calSearchDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calToDate_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            stxtToDate.setValue(sdf.format((Date) vce.getNewValue()));
            calToDate.setRendered(false);
        }
    }

    public String bntCalDateFrom_action() {
        calDateFrom.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String bntCalDateTo_action() {
        calToDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnSearch_action() {
        if (HRValidation.validateRequired(txtEmployeeId.getValue())) {
            employeeName = employeeManage.employeeFullName(txtEmployeeId.getValue().toString());
            txtAbsentEmployeeFullName.setValue(employeeName);
            employeeId = txtEmployeeId.getValue().toString();
        } else {
            showSuccessOrFailureMessage(false, "Employee Not Found by this id.Please try Again?");
        }
        //return null means stay on the same page
        return null;
    }
}

