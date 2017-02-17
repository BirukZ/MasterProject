/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.Attendance;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.jsfcl.app.AbstractPageBean;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import fphrms.EmployeeList;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.attendanceManager.AttendanceManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TakeAttendancePage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private EmployeeList currentEmployee1 = new EmployeeList("", "0", null);
    private AttendanceManager attendanceManager = null;
    private ArrayList<SelectItem> stateLists = new ArrayList<SelectItem>();
    private String employeeId;
    private String employeeName;
    private ArrayList<AbsenteesModelLoad> attendanceAbsenteesLoad = new ArrayList<AbsenteesModelLoad>();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<SelectItem> getStateLists() {
        return stateLists;
    }

    public void setStateLists(ArrayList<SelectItem> stateLists) {
        this.stateLists = stateLists;
    }

    public ArrayList<AbsenteesModelLoad> getAttendanceAbsenteesLoad() {
        return attendanceAbsenteesLoad;
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
        checkObject();
        setStateLists(attendanceManager.stateTypes());
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlInputText txtfAbsentDate = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDate() {
        return txtfAbsentDate;
    }

    public void setTxtfAbsentDate(HtmlInputText hit) {
        this.txtfAbsentDate = hit;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calAbsentDate = new SelectInputDate();

    public SelectInputDate getCalAbsentDate() {
        return calAbsentDate;
    }

    public void setCalAbsentDate(SelectInputDate sid) {
        this.calAbsentDate = sid;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
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
    private HtmlSelectOneMenu drlAbsentValue = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAbsentValue() {
        return drlAbsentValue;
    }

    public void setDrlAbsentValue(HtmlSelectOneMenu hsom) {
        this.drlAbsentValue = hsom;
    }
    private HtmlSelectBooleanCheckbox chkAfternoon = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkAfternoon() {
        return chkAfternoon;
    }

    public void setChkAfternoon(HtmlSelectBooleanCheckbox hsbc) {
        this.chkAfternoon = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkMorning = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMorning() {
        return chkMorning;
    }

    public void setChkMorning(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMorning = hsbc;
    }
    private HtmlOutputText txtEmployeeFullName = new HtmlOutputText();

    public HtmlOutputText getTxtEmployeeFullName() {
        return txtEmployeeFullName;
    }

    public void setTxtEmployeeFullName(HtmlOutputText hot) {
        this.txtEmployeeFullName = hot;
    }
    private SelectInputText txtSearchByName = new SelectInputText();

    public SelectInputText getTxtSearchByName() {
        return txtSearchByName;
    }

    public void setTxtSearchByName(SelectInputText sit) {
        this.txtSearchByName = sit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TakeAttendancePage() {
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
            log("Templete Initialization Failure", e);
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

    public static class AbsenteesModelLoad implements Serializable {

        private int absenceId;
        private String empId;
        private String empFullName;
        private String absentAmout;
        private String requestStatus;
        private String requestDate;
        private String dayDescription;

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

        public AbsenteesModelLoad(int absenceId,
                String empId,
                String empFullName,
                String absentAmout,
                String requestStatus,
                String requestDate,
                String dayDescription) {
            this.absenceId = absenceId;
            this.empId = empId;
            this.empFullName = empFullName;
            this.absentAmout = absentAmout;
            this.requestStatus = requestStatus;
            this.requestDate = requestDate;
            this.dayDescription = dayDescription;
        }
    }

    public String button3_action() {
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
                dayDesc));
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {
        calAbsentDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String txtSearchByName_action() {
//        employeeName=txtSearchByName.
        employeeName = ApplicationBean1.getSelectedEmployeeName();
        txtEmployeeFullName.setValue(employeeName);
        employeeId = ApplicationBean1.getSelectedEmployeeId();
        txtEmployeeId.setValue(employeeId);

        //return null means stay on the same page
        return null;
    }

    public String button1_action() {
        //return null means stay on the same page
        return null;
    }

    /**
     *
     */
    void checkObject() {
        if (attendanceManager == null) {
            attendanceManager = new AttendanceManager();
        }

    }

    /**
     *
     */
    public void afterRenderResponse() {
    }
}

