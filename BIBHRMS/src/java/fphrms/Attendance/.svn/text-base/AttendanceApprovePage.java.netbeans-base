/*
 * AttendanceApprovePage.java
 *
 * Created on Dec 14, 2012, 6:42:38 PM
 * Copyright Administrator
 */
package fphrms.Attendance;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
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
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.attendanceManager.AttendanceApproveManager;
import manager.attendanceManager.AttendanceManager;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class AttendanceApprovePage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<AbsenteesModelLoad> attendanceAbsenteesLoad = new ArrayList<AbsenteesModelLoad>();
    private ArrayList<SelectItem> prerviousRequestList = new ArrayList<SelectItem>();
    private ArrayList<Option> listOfDecision = new ArrayList<Option>();
    private AttendanceManager attendanceManager = null;
    private AttendanceApproveManager attendanceApproveManager = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<Option> getListOfDecision() {
        return listOfDecision;
    }

    public void setListOfDecision(ArrayList<Option> listOfDecision) {
        this.listOfDecision = listOfDecision;
    }
    private boolean onlyFirstTime = true;

    public ArrayList<SelectItem> getPrerviousRequestList() {
        return prerviousRequestList;
    }

    public void setPrerviousRequestList(ArrayList<SelectItem> prerviousRequestList) {
        this.prerviousRequestList = prerviousRequestList;
    }

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

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        if (onlyFirstTime) {
            checkAtt();
            onlyFirstTime = false;
            txtfAbsentDate.setValue(sdf.format(new Date()));
            lblDepartmentDescription.setValue(getSessionBean1().getDepartmentDescrption());
            lblEmployeeFullName.setValue(getSessionBean1().getEmployeeName());
            lblDeciderPosition.setValue(getSessionBean1().getJobDescription());
            txtDeciderId.setValue(getSessionBean1().getEmployeeId());
            loadAbsentEmployee();
            setPrerviousRequestList(attendanceManager.getMonthList());

        }
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
    private HtmlOutputText lblEmployeeFullName = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeFullName() {
        return lblEmployeeFullName;
    }

    public void setLblEmployeeFullName(HtmlOutputText hot) {
        this.lblEmployeeFullName = hot;
    }
    private HtmlOutputText lblDeciderPosition = new HtmlOutputText();

    public HtmlOutputText getLblDeciderPosition() {
        return lblDeciderPosition;
    }

    public void setLblDeciderPosition(HtmlOutputText hot) {
        this.lblDeciderPosition = hot;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputText txtfAbsentDate = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDate() {
        return txtfAbsentDate;
    }

    public void setTxtfAbsentDate(HtmlInputText hit) {
        this.txtfAbsentDate = hit;
    }
    private HtmlOutputText lblDepartmentDescription = new HtmlOutputText();

    public HtmlOutputText getLblDepartmentDescription() {
        return lblDepartmentDescription;
    }

    public void setLblDepartmentDescription(HtmlOutputText hot) {
        this.lblDepartmentDescription = hot;
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
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AttendanceApprovePage() {
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
            log("AttendanceApprovePage Initialization Failure", e);
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

    public static class AbsenteesModelLoad implements Serializable {

        private int absenceId;
        private String empId;
        private String empFullName;
        private String absentAmount;
        private String absenttype;
        private String month;
        private boolean selected;
        private boolean selectedEmp;

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

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

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public int getAbsenceId() {
            return absenceId;
        }

        public void setAbsenceId(int absenceId) {
            this.absenceId = absenceId;
        }

        public AbsenteesModelLoad(String empId,
                String empFullName,
                String absentAmount,
                String absenttype, String month, boolean selected) {
            this.empId = empId;
            this.empFullName = empFullName;
            this.absentAmount = absentAmount;
            this.absenttype = absenttype;
            this.selected = selected;
            this.month = month;

        }
    }
//  @Deprecated

    private void loadAbsentEmployee() {
        try {
            check();
            checkAtt();
            ArrayList<HashMap> lsitOfEmployeeAbset = attendanceApproveManager.listOfAbset(
                    getSessionBean1().getEmployeeId());
            getAttendanceAbsenteesLoad().clear();
            if (lsitOfEmployeeAbset != null) {
                setListOfDecision(attendanceApproveManager.getAvailableDecisionsToMake(getSessionBean1().getUserName()));
                onlyFirstTime = true;
                for (HashMap hm : lsitOfEmployeeAbset) {
                    getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(
                            hm.get("emp_id").toString(),
                            hm.get("Full_Name").toString(),
                            hm.get("Absent_Amount").toString(),
                            hm.get("Absenttype").toString(),
                            hm.get("month").toString(),
                            false));

                    if (onlyFirstTime) {
                        onlyFirstTime = false;
                        txtfAbsentDate.setValue(hm.get("month").toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAbsentEmployee(String month) {
        try {
            check();
            checkAtt();
            ArrayList<HashMap> lsitOfEmployeeAbset = attendanceApproveManager.listOfAbset(
                    getSessionBean1().getEmployeeId(), month);
            getAttendanceAbsenteesLoad().clear();
            if (lsitOfEmployeeAbset != null) {
                if (lsitOfEmployeeAbset.size() > 0) {
                    setListOfDecision(attendanceApproveManager.getAvailableDecisionsToMake(getSessionBean1().getUserName()));
                    onlyFirstTime = true;
                    for (HashMap hm : lsitOfEmployeeAbset) {
                        getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(
                                hm.get("emp_id").toString(),
                                hm.get("Full_Name").toString(),
                                hm.get("Absent_Amount").toString(),
                                hm.get("Absenttype").toString(),
                                hm.get("month").toString(),
                                false));
                        if (onlyFirstTime) {
                            onlyFirstTime = false;
                            txtfAbsentDate.setValue(hm.get("month").toString());
                        }
                    }
                } else {
                    showSuccessOrFailureMessage(false, "No attendance information found.");
                }
            } else {
                showSuccessOrFailureMessage(false, "No attendance information found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(); $j('." + val + "').fadeOut(" + fadeTime + ");});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btnSave_action() {
        check();
        if (HRValidation.validateRequired(drlDecision.getValue())) {
            ArrayList<HashMap> list = getListOfDecisionMake();
            if (list != null && list.size() > 0) {
                if (attendanceApproveManager.saveApproveAttendanceRecord(
                        list,
                        txtaDeciderComment.getValue().toString(),
                        txtDeciderId.getValue().toString(),
                        drlDecision.getValue().toString())) {
                    loadAbsentEmployee();
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

    public String lnkApproveAttendance_action() {
        // TODO: Replace with your code
        return null;
    }

    public String lnkCertify_action() {
        // TODO: Replace with your code
        return null;
    }

    private void check() {
        if (attendanceApproveManager == null) {
            attendanceApproveManager = new AttendanceApproveManager();
        }
    }

    private void checkAtt() {
        if (attendanceManager == null) {
            attendanceManager = new AttendanceManager();
        }

    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void llisRequestList_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            setListOfDecision(null);
            txtfAbsentDate.setValue(vce.getNewValue());
            loadAbsentEmployee(vce.getNewValue().toString());
        }
    }
}

