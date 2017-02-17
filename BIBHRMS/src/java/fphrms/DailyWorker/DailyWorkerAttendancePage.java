/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.DailyWorker;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.dailyWorkerManager.DailyWorkerAttendanceManager;
import manager.dailyWorkerManager.DailyWorkerManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DailyWorkerAttendancePage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private DailyWorkerAttendanceManager dailyWorkerAttendanceManager = null;
    private DailyWorkerManager dailyWorkerManager = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<SelectItem> listOfJobs = new ArrayList<SelectItem>();
    private ArrayList<AttendanceModelLoad> attendancedailyWorker = new ArrayList<AttendanceModelLoad>();
    private String attendanceId="0";
    private int tableSize = 0;
    private String attendanceTakeDate;

    public ArrayList<AttendanceModelLoad> getAttendancedailyWorker() {
        return attendancedailyWorker;
    }

    public void setAttendancedailyWorker(ArrayList<AttendanceModelLoad> attendancedailyWorker) {
        this.attendancedailyWorker = attendancedailyWorker;
    }

    public ArrayList<SelectItem> getListOfJobs() {
        return listOfJobs;
    }

    public void setListOfJobs(ArrayList<SelectItem> listOfJobs) {
        this.listOfJobs = listOfJobs;
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
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlInputText txtfAttendaceDate = new HtmlInputText();

    public HtmlInputText getTxtfAttendaceDate() {
        return txtfAttendaceDate;
    }

    public void setTxtfAttendaceDate(HtmlInputText hit) {
        this.txtfAttendaceDate = hit;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandButton btnCancelAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelAttendance() {
        return btnCancelAttendance;
    }

    public void setBtnCancelAttendance(HtmlCommandButton hcb) {
        this.btnCancelAttendance = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnTakeAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnTakeAttendance() {
        return btnTakeAttendance;
    }

    public void setBtnTakeAttendance(HtmlCommandButton hcb) {
        this.btnTakeAttendance = hcb;
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
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkPresent = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkPresent() {
        return chkPresent;
    }

    public void setChkPresent(HtmlSelectBooleanCheckbox hsbc) {
        this.chkPresent = hsbc;
    }
    private HtmlInputText txtDayValue = new HtmlInputText();

    public HtmlInputText getTxtDayValue() {
        return txtDayValue;
    }

    public void setTxtDayValue(HtmlInputText hit) {
        this.txtDayValue = hit;
    }
    private HtmlCommandButton calDateAttendace = new HtmlCommandButton();

    public HtmlCommandButton getCalDateAttendace() {
        return calDateAttendace;
    }

    public void setCalDateAttendace(HtmlCommandButton hcb) {
        this.calDateAttendace = hcb;
    }
    private HtmlSelectOneMenu drlJob = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJob() {
        return drlJob;
    }

    public void setDrlJob(HtmlSelectOneMenu hsom) {
        this.drlJob = hsom;
    }
    private HtmlCommandButton calDateAttendaceSearch = new HtmlCommandButton();

    public HtmlCommandButton getCalDateAttendaceSearch() {
        return calDateAttendaceSearch;
    }

    public void setCalDateAttendaceSearch(HtmlCommandButton hcb) {
        this.calDateAttendaceSearch = hcb;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDate calSearchDate = new SelectInputDate();

    public SelectInputDate getCalSearchDate() {
        return calSearchDate;
    }

    public void setCalSearchDate(SelectInputDate sid) {
        this.calSearchDate = sid;
    }
    private HtmlInputText txtfAbsentDateSearch = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDateSearch() {
        return txtfAbsentDateSearch;
    }

    public void setTxtfAbsentDateSearch(HtmlInputText hit) {
        this.txtfAbsentDateSearch = hit;
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
    private HtmlSelectOneMenu drlSearchJob = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSearchJob() {
        return drlSearchJob;
    }

    public void setDrlSearchJob(HtmlSelectOneMenu hsom) {
        this.drlSearchJob = hsom;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkStatus = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkStatus() {
        return chkStatus;
    }

    public void setChkStatus(HtmlSelectBooleanCheckbox hsbc) {
        this.chkStatus = hsbc;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DailyWorkerAttendancePage() {
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
        checkObject();
        setListOfJobs(dailyWorkerManager.listOfRequriment());
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

    private void checkObject() {
        if (dailyWorkerAttendanceManager == null) {
            dailyWorkerAttendanceManager = new DailyWorkerAttendanceManager();
        }
        if (dailyWorkerManager == null) {
            dailyWorkerManager = new DailyWorkerManager();

        }
    }

    public String btnTakeAttendance_action() {
        enableComponet();
        btnSave.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    private ArrayList<HashMap> lsitOfAttendance() {
        ArrayList<HashMap> listOfAbesnt = new ArrayList<HashMap>();

        for (AttendanceModelLoad absenteesEmp : getAttendancedailyWorker()) {
            if (absenteesEmp.isPresent()) {
                HashMap hm = new HashMap();
                hm.put("dailyWorkerId", absenteesEmp.getDailyWorkerId());
                hm.put("absentAmout", absenteesEmp.getDayValue());
                hm.put("attendaceDate", txtfAttendaceDate.getValue());
                hm.put("emp_id", getSessionBean1().getEmployeeId());

                listOfAbesnt.add(hm);
            }

        }
        return listOfAbesnt;
    }

    public String btnSave_action() {
        if (dailyWorkerAttendanceManager.saveDailyworkerAttendance(lsitOfAttendance())) {
            showSuccessOrFailureMessage(true, "Daily Worker Attendance Successful Saved!");
        } else {
            showSuccessOrFailureMessage(true, "Daily Worker Attendance NOT Saved. Please try Again ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCancelAttendance_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        employeePlanPopUpMsg.setRendered(true);
        lblemployeePopUpMsgMain.setValue("Are you sure you want to delete Daily Worker Information ?");
        //return null means stay on the same page
        return null;
    }

    public void calenderDate_processValueChange(ValueChangeEvent vce) {
        try {
            txtfAttendaceDate.setValue(sdf.format(vce.getNewValue()));
            calenderDate.setRendered(false);
        } catch (Exception ex) {
        }
    }

    public String calDateAttendace_action() {
        calenderDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void drlJob_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                getAttendancedailyWorker().clear();
                ArrayList<HashMap> listOfDailyWorker = dailyWorkerManager.getListODayilyWorkerForAttendance(vce.getNewValue().toString());
             
                for (HashMap hm : listOfDailyWorker) {
                    getAttendancedailyWorker().add(new AttendanceModelLoad(
                            attendanceId,
                            hm.get("ID").toString(),
                            hm.get("FULLNAME").toString(),
                            "8",
                            "new",
                            true,
                            false));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class AttendanceModelLoad implements Serializable {

        private String attendanceId;
        private String dailyWorkerId;
        private String dailyWorkerFullName;
        private String dayValue;
        private String status;
        private boolean present;
        private boolean selected;

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAttendanceId() {
            return attendanceId;
        }

        public void setAttendanceId(String attendanceId) {
            this.attendanceId = attendanceId;
        }

        public String getDailyWorkerFullName() {
            return dailyWorkerFullName;
        }

        public void setDailyWorkerFullName(String dailyWorkerFullName) {
            this.dailyWorkerFullName = dailyWorkerFullName;
        }

        public String getDailyWorkerId() {
            return dailyWorkerId;
        }

        public void setDailyWorkerId(String dailyWorkerId) {
            this.dailyWorkerId = dailyWorkerId;
        }

        public String getDayValue() {
            return dayValue;
        }

        public void setDayValue(String dayValue) {
            this.dayValue = dayValue;
        }

        public boolean isPresent() {
            return present;
        }

        public void setPresent(boolean present) {
            this.present = present;
        }

        public AttendanceModelLoad(String attendanceId,
                String dailyWorkerId,
                String dailyWorkerFullName,
                String dayValue,
                String status,
                boolean present,
                boolean selected) {
            this.attendanceId = attendanceId;
            this.dailyWorkerId = dailyWorkerId;
            this.dailyWorkerFullName = dailyWorkerFullName;
            this.dayValue = dayValue;
            this.present = present;
            this.selected = selected;
        }
    }

    private void enableComponet() {
        txtfAttendaceDate.setDisabled(false);
//        txtSearchByName.setDisabled(false);
//        txtEmployeeId.setDisabled(false);
        drlJob.setDisabled(false);
//        drlAbsentType.setDisabled(false);
//        btnListEmployees.setDisabled(false);
//        btnSearch.setDisabled(false);
        calDateAttendace.setDisabled(false);
//        getAttendanceAbsenteesLoad().clear();
    }

    public String calDateAttendaceSearch_action() {
        calSearchDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnSearchAttendance_action() {
        searchAttendance(drlSearchJob.getValue().toString(),
                txtfAbsentDateSearch.getValue().toString());
        //return null means stay on the same page
        return null;
    }

    private void searchAttendance(String val1, String val2) {
        getAttendancedailyWorker().clear();
        if (val1 != null && val2 != null) {
            try {
                ArrayList<HashMap> loadCandidateList = dailyWorkerAttendanceManager.readDailyWorkerAttendance(
                        val2,
                        val1);//load training candidate lists.
                tableSize = 0;
                if (loadCandidateList.size() > 0) {
                    attendanceTakeDate = val1;
                    for (HashMap hm : loadCandidateList) {
                        getAttendancedailyWorker().add(new AttendanceModelLoad(
                                hm.get("absenceId").toString(),
                                hm.get("Dailyworkerid").toString(),
                                hm.get("FULLNAME").toString(),
                                hm.get("ATTENDANCEAMOUNT").toString(),
                                hm.get("STATUS").toString(),
                                true,
                                false));
                        tableSize++;
                    }
                } else {
                    showSuccessOrFailureMessage(false, "No attendance information found.");

                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            showSuccessOrFailureMessage(false, "Please provide full search criteria to see the search result.");
        }
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

    public void calSearchDate_processValueChange(ValueChangeEvent vce) {
        try {
            txtfAbsentDateSearch.setValue(sdf.format(vce.getNewValue()));
            calSearchDate.setRendered(false);
        } catch (Exception e) {
        }
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpYes_action() {
        if (dailyWorkerAttendanceManager.saveDailyworkerAttendance(lsitOfAttendance())) {
            showSuccessOrFailureMessage(true, "Daily Worker Attendance Successful Saved!");
        } else {
            showSuccessOrFailureMessage(true, "Daily Worker Attendance NOT Saved. Please try Again ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpNo_action() {
        //return null means stay on the same page
        return null;
    }
}

