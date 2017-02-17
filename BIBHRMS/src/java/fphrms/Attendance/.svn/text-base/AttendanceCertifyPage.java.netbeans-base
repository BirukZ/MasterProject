/*
 * AttendanceCertifyPage.java
 *
 * Created on Dec 17, 2012, 10:59:21 AM
 * Copyright Administrator
 */
package fphrms.Attendance;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import manager.attendanceManager.AttendanceCertifyManager;
import manager.attendanceManager.AttendanceManager;
import javax.faces.model.SelectItem;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class AttendanceCertifyPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<Option> listOfDecision = new ArrayList<Option>();
    private ArrayList<SelectItem> monthlyAttendanceProcessed = new ArrayList<SelectItem>();
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private AttendanceCertifyManager attendanceCertifyManager = null;
    private ArrayList<AbsenteesModelLoad> attendanceAbsenteesLoad = new ArrayList<AbsenteesModelLoad>();
    private AttendanceManager attendanceManager = null;
    private boolean fistTime = true;
    private int __placeholder;

    public ArrayList<SelectItem> getMonthlyAttendanceProcessed() {
        return monthlyAttendanceProcessed;
    }

    public void setMonthlyAttendanceProcessed(ArrayList<SelectItem> monthlyAttendanceProcessed) {
        this.monthlyAttendanceProcessed = monthlyAttendanceProcessed;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        if (fistTime) {
            try {
                fistTime = false;
                stxtDate.setValue(sdf.format(new Date()));
                loadAbsentEmployee();
                checkAttenManObject();
                setMonthlyAttendanceProcessed(attendanceManager.getMonthList());
                lblFullName.setValue(getSessionBean1().getEmployeeName());
                lblPosition.setValue(getSessionBean1().getProfetion());
                lblEmployeeId.setValue(getSessionBean1().getEmployeeId());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Option> getListOfDecision() {
        return listOfDecision;
    }

    public void setListOfDecision(ArrayList<Option> listOfDecision) {
        this.listOfDecision = listOfDecision;
    }

    // </editor-fold>
    public ArrayList<AbsenteesModelLoad> getAttendanceAbsenteesLoad() {
        return attendanceAbsenteesLoad;
    }

    public void setAttendanceAbsenteesLoad(ArrayList<AbsenteesModelLoad> attendanceAbsenteesLoad) {
        this.attendanceAbsenteesLoad = attendanceAbsenteesLoad;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkDecision = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkDecision() {
        return chkDecision;
    }

    public void setChkDecision(HtmlSelectBooleanCheckbox hsbc) {
        this.chkDecision = hsbc;
    }
    private HtmlOutputLabel stxtDate = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtDate() {
        return stxtDate;
    }

    public void setStxtDate(HtmlOutputLabel hol) {
        this.stxtDate = hol;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlOutputText lblPosition = new HtmlOutputText();

    public HtmlOutputText getLblPosition() {
        return lblPosition;
    }

    public void setLblPosition(HtmlOutputText hot) {
        this.lblPosition = hot;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlOutputText lblEmployeeId = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeId() {
        return lblEmployeeId;
    }

    public void setLblEmployeeId(HtmlOutputText hot) {
        this.lblEmployeeId = hot;
    }
    private HtmlSelectOneListbox lisMonth = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLisMonth() {
        return lisMonth;
    }

    public void setLisMonth(HtmlSelectOneListbox hsol) {
        this.lisMonth = hsol;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessage1 = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }
    private HtmlInputText txtfAbsentDate = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDate() {
        return txtfAbsentDate;
    }

    public void setTxtfAbsentDate(HtmlInputText hit) {
        this.txtfAbsentDate = hit;
    }
    private HtmlCommandButton btnCertifyAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnCertifyAttendance() {
        return btnCertifyAttendance;
    }

    public void setBtnCertifyAttendance(HtmlCommandButton hcb) {
        this.btnCertifyAttendance = hcb;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AttendanceCertifyPage() {
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
            log("AttendanceCertifyPage Initialization Failure", e);
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

    public String btnSearchAttendance_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkTakeAttendance_action() {
        //return null means stay on the same page
        return "AttendancePage";
    }

    public String lnkCertify_action() {
        //return null means stay on the same page
        return "AttendanceCertifyPage";
    }

    public String lnkApproveAttendance_action() {
        //return null means stay on the same page
        return "AttendanceApprovePage";
    }

    private void loadAbsentEmployee() {
        try {
             btnCertifyAttendance.setDisabled(false);
            check();
            ArrayList<HashMap> lsitOfEmployeeAbset = attendanceCertifyManager.listOfApproveAbsent();
            getAttendanceAbsenteesLoad().clear();
            if (lsitOfEmployeeAbset.size() > 0) {
               
                fistTime = true;
                setListOfDecision(attendanceCertifyManager.getAvailableDecisionsToMake(getSessionBean1().getUserName()));
                for (HashMap hm : lsitOfEmployeeAbset) {
                    getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(
                            hm.get("EmployeeId").toString(),
                            hm.get("Full_Name").toString(),
                            hm.get("Absent_Amount").toString(),
                            hm.get("Absenttype").toString(),
                            hm.get("Month").toString(),
                            false));
                    if (fistTime) {
                        fistTime = false;
                        txtfAbsentDate.setValue(hm.get("Month").toString());
                    }

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadAbsentEmployeeByUserSelection(String month) {
        try {
            check();
            ArrayList<HashMap> lsitOfEmployeeAbset = attendanceCertifyManager.listOfApproveAbsent(month);
            getAttendanceAbsenteesLoad().clear();
            if (lsitOfEmployeeAbset.size() > 0) {
                setListOfDecision(attendanceCertifyManager.getAvailableDecisionsToMake(getSessionBean1().getUserName()));
                for (HashMap hm : lsitOfEmployeeAbset) {
                    getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(
                            hm.get("EmployeeId").toString(),
                            hm.get("Full_Name").toString(),
                            hm.get("Absent_Amount").toString(),
                            hm.get("Absenttype").toString(),
                            hm.get("Month").toString(),
                            false));

                }
            } else {
                showSuccessOrFailureMessage(false, "No attendance information found.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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

    private void check() {
        if (attendanceCertifyManager == null) {
            attendanceCertifyManager = new AttendanceCertifyManager();

        }
    }

    public static class AbsenteesModelLoad implements Serializable {

        private String empId;
        private String empFullName;
        private String absentAmount;
        private String absenttype;
        private String month;
        private boolean selected;
        private boolean selectedEmp;

        public boolean isSelectedEmp() {
            return selectedEmp;
        }

        public void setSelectedEmp(boolean selectedEmp) {
            this.selectedEmp = selectedEmp;
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

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getAbsentAmount() {
            return absentAmount;
        }

        public void setAbsentAmount(String absentAmount) {
            this.absentAmount = absentAmount;
        }

        public String getAbsenttype() {
            return absenttype;
        }

        public void setAbsenttype(String absenttype) {
            this.absenttype = absenttype;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public AbsenteesModelLoad(
                String empId,
                String empFullName,
                String absentAmount,
                String absenttype,
                String month,
                boolean selected) {

            this.empId = empId;
            this.empFullName = empFullName;
            this.absentAmount = absentAmount;
            this.absenttype = absenttype;
            this.month = month;
            this.selected = selected;
        }
    }

    private ArrayList<HashMap> getListOfDecisionMake() {
        ArrayList<HashMap> listOfDecisionMak = new ArrayList<HashMap>();
        for (AbsenteesModelLoad absenteesModelLoad : getAttendanceAbsenteesLoad()) {
            if (absenteesModelLoad.isSelected()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", absenteesModelLoad.getEmpId());
                hm.put("month", absenteesModelLoad.getMonth());
                listOfDecisionMak.add(hm);
            }
        }
        if (listOfDecisionMak.size() > 0) {
            return listOfDecisionMak;
        } else {
            return null;
        }
    }

    public String btnCertifyAttendance_action() {
        check();
        if (HRValidation.validateRequired(drlDecision.getValue())) {
            ArrayList<HashMap> list = getListOfDecisionMake();
            if (list != null && list.size() > 0) {
                if (attendanceCertifyManager.saveCertifyAttendanceRecord(
                        list,
                        txtRemark.getValue().toString(),
                        lblEmployeeId.getValue().toString(),
                        drlDecision.getValue().toString(),
                        txtfAbsentDate.getValue().toString())) {
                    loadAbsentEmployee();
                    selectOneMenu1Bean.setSelectedObject(null);
                    showSuccessOrFailureMessage(true, "Your Decision Saved Successfully !");
                } else {
                    showSuccessOrFailureMessage(false, "Your Decision Not Saved .Please try agine ?");
                }
            } else {
                showSuccessOrFailureMessage(false, "Please Selsect Record from the table ?");
            }
        } else {
            showSuccessOrFailureMessage(true, "Please Selsect Your Decision ?");
        }
        //return null means stay on the same page
        return null;
    }

    private void checkAttenManObject() {
        if (attendanceManager == null) {
            attendanceManager = new AttendanceManager();
        }
    }

    public void lisMonth_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            txtfAbsentDate.setValue(vce.getNewValue());
            setListOfDecision(null);
            loadAbsentEmployeeByUserSelection(vce.getNewValue().toString());

        }
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        // TODO: Replace with your code
        return null;
    }
}

