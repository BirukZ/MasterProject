/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Report;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlForm;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.event.ActionEvent;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.sun.webui.jsf.model.Option;
import control.ReportControl;
import manager.globalUseManager.ErrorLogWriter;
import javax.faces.context.FacesContext;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.LookUpManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class MainReport extends AbstractPageBean {

    private ArrayList<SelectItem> _job = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> _jobRank = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> _title = new ArrayList<SelectItem>();
    LookUpManager lookUpManager = new LookUpManager();
    DepartmentManage departmentMgr = new DepartmentManage();
//    private Option[] deptIds = departmentMgr.readDpartment();
    private Option[] deptIds = departmentMgr.readDpartmentToListBox();
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    static String reportType;
    //can be 1.Profile Report 2. Routine Reports 3.Recruitment 4.Training 5.Termination
    static String OrgId;
    static String orgName;
    static String empType;
    static String sex;
    static String rank;
    static String jobCategory;
    ReportControl reportCtrl = new ReportControl();
//    private Option[] reportOpt = reportCtrl.loadReports();

    private void _init() throws Exception {
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
    private PanelLayout container = new PanelLayout();

    public PanelLayout getContainer() {
        return container;
    }

    public void setContainer(PanelLayout pl) {
        this.container = pl;
    }
    private HtmlForm form1 = new HtmlForm();

    public HtmlForm getForm1() {
        return form1;
    }

    public void setForm1(HtmlForm hf) {
        this.form1 = hf;
    }
    private HtmlOutputText lblOutputext = new HtmlOutputText();

    public HtmlOutputText getLblOutputext() {
        return lblOutputext;
    }

    public void setLblOutputext(HtmlOutputText hot) {
        this.lblOutputext = hot;
    }
    private HtmlOutputText lblNotAvilabelMessage = new HtmlOutputText();

    public HtmlOutputText getLblNotAvilabelMessage() {
        return lblNotAvilabelMessage;
    }

    public void setLblNotAvilabelMessage(HtmlOutputText hot) {
        this.lblNotAvilabelMessage = hot;
    }
    private PanelLayout pnl_report_criterias = new PanelLayout();

    public PanelLayout getPnl_report_criterias() {
        return pnl_report_criterias;
    }

    public void setPnl_report_criterias(PanelLayout pl) {
        this.pnl_report_criterias = pl;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems = dsi;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneRadio rdbgEmpType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRdbgEmpType() {
        return rdbgEmpType;
    }

    public void setRdbgEmpType(HtmlSelectOneRadio hsor) {
        this.rdbgEmpType = hsor;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
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
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray drlRankDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDrlRankDefaultItems() {
        return drlRankDefaultItems;
    }

    public void setDrlRankDefaultItems(DefaultSelectItemsArray dsia) {
        this.drlRankDefaultItems = dsia;
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
    private HtmlSelectOneMenu drlJobType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJobType() {
        return drlJobType;
    }

    public void setDrlJobType(HtmlSelectOneMenu hsom) {
        this.drlJobType = hsom;
    }
    private HtmlSelectOneMenu drlRank = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRank() {
        return drlRank;
    }

    public void setDrlRank(HtmlSelectOneMenu hsom) {
        this.drlRank = hsom;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems7 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems7 = dsi;
    }
    private DefaultSelectItemsArray drlJobTypeDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDrlJobTypeDefaultItems() {
        return drlJobTypeDefaultItems;
    }

    public void setDrlJobTypeDefaultItems(DefaultSelectItemsArray dsia) {
        this.drlJobTypeDefaultItems = dsia;
    }
    private DefaultSelectItemsArray drlDepartmentDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDrlDepartmentDefaultItems() {
        return drlDepartmentDefaultItems;
    }

    public void setDrlDepartmentDefaultItems(DefaultSelectItemsArray dsia) {
        this.drlDepartmentDefaultItems = dsia;
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
    private HtmlSelectOneRadio rdbgReports = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRdbgReports() {
        return rdbgReports;
    }

    public void setRdbgReports(HtmlSelectOneRadio hsor) {
        this.rdbgReports = hsor;
    }
    private HtmlSelectOneMenu drlSortBy = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSortBy() {
        return drlSortBy;
    }

    public void setDrlSortBy(HtmlSelectOneMenu hsom) {
        this.drlSortBy = hsom;
    }
    private HtmlSelectBooleanCheckbox cboMiltery = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboMiltery() {
        return cboMiltery;
    }

    public void setCboMiltery(HtmlSelectBooleanCheckbox hsbc) {
        this.cboMiltery = hsbc;
    }
    private HtmlSelectBooleanCheckbox cboCivile = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboCivile() {
        return cboCivile;
    }

    public void setCboCivile(HtmlSelectBooleanCheckbox hsbc) {
        this.cboCivile = hsbc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public MainReport() {
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
        setDeptIds(departmentMgr.readDpartmentToListBox());
//        setReportOpt(reportCtrl.loadReports());
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

    public String hlnkRequestCommented_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String lnkTerminationApprovalComment_action() {
        //return null means stay on the same page
        return "ApprovedRecruitmentList";
    }

    public String lnkResignationType_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String commandLink3_action() {
        //return null means stay on the same page
        return "FilterCandidates";
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

    public void page_header_processMyEvent(DragEvent de) {
    }

//    /**
//     * Generates Report by the specified requirements.
//     * @param ae ActionEvent object
//     */
//    public void btnGenerateReport1_processAction(ActionEvent ae) {
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        HttpServletResponse response =
//                (HttpServletResponse) context.getExternalContext().getResponse();
//
//        HttpServletRequest request =
//                (HttpServletRequest) context.getExternalContext().getRequest();
//        ServletOutputStream servletOutputStream = null;
//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        try {
//            servletOutputStream = response.getOutputStream();
//            if (this.rdbgReports.getValue().equals("1") ||
//                    this.rdbgReports.getValue().equals("2") ||
//                    this.rdbgReports.getValue().equals("3") ||
//                    this.rdbgReports.getValue().equals("4") ||
//                    this.rdbgReports.getValue().equals("8") ||
//                    this.rdbgReports.getValue().equals("9") ||
//                    this.rdbgReports.getValue().equals("10") ||
//                    this.rdbgReports.getValue().equals("11") ||
//                    this.rdbgReports.getValue().equals("12") ||
//                    this.rdbgReports.getValue().equals("13") ||
//                    this.rdbgReports.getValue().equals("14")) {
//                reportCtrl.getReport(this.rdbgReports.getValue().toString(),
//                        servletOutputStream, "1",
//                        request, OrgId, orgName, empType, sex, rank, jobCategory);
//            } else {
//                reportCtrl.getReport(this.rdbgReports.getValue().toString(),
//                        servletOutputStream, "1", request, empType,
//                        "1900-02-02", "2003-01-01", OrgId);
//            }
//            servletOutputStream.flush();
//            servletOutputStream.close();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//        }
//
//        // Stop resend
//        FacesContext.getCurrentInstance().responseComplete();
//    }

    public void rbgReportEmpType_processValueChange(ValueChangeEvent vce) {
        reportType = vce.getNewValue().toString();
    }

    public void rdbgEmpType_processValueChange(ValueChangeEvent vce) {
        empType = vce.getNewValue().toString();
        if (this.rdbgEmpType.getValue().equals("1")) {
//            this.rdbgCivilEmpType.setVisible(true);
//            this.getApplicationBean1().rank_Type("1");
        } else if (this.rdbgEmpType.getValue().equals("2")) {
//            this.rdbgCivilEmpType.setVisible(false);
//            this.getApplicationBean1().rank_Type("2");
        }
    }

    public void drlRank_processValueChange(ValueChangeEvent vce) {
        rank = vce.getNewValue().toString();
    }

    public void drlDepartment_processValueChange(ValueChangeEvent vce) {
        OrgId = vce.getNewValue().toString();
    }

    public void drlJobType_processValueChange(ValueChangeEvent vce) {
        jobCategory = vce.getNewValue().toString();
    }

    public void drlSex_processValueChange(ValueChangeEvent vce) {
        sex = vce.getNewValue().toString();
    }
//
//    /**
//     * @return the reportOpt
//     */
//    public Option[] getReportOpt() {
//        return reportOpt;
//    }
//
//    /**
//     * @param reportOpt the reportOpt to set
//     */
//    public void setReportOpt(Option[] reportOpt) {
//        this.reportOpt = reportOpt;
//    }

    /**
     * @return the deptIds
     */
    public Option[] getDeptIds() {
        return deptIds;
    }

    /**
     * @param deptIds the deptIds to set
     */
    public void setDeptIds(Option[] deptIds) {
        this.deptIds = deptIds;
    }

    /**
     * @return the _job
     */
    public ArrayList<SelectItem> getJob() {
        return _job;
    }

    /**
     * @param job the _job to set
     */
    public void setJob(ArrayList<SelectItem> job) {
        this._job = job;
    }

    /**
     * @return the _jobRank
     */
    public ArrayList<SelectItem> get_jobRank() {
        return _jobRank;
    }

    /**
     * @param jobRank the _jobRank to set
     */
    public void set_jobRank(ArrayList<SelectItem> _jobRank) {
        this._jobRank = _jobRank;
    }

    /**
     * @return the _title
     */
    public ArrayList<SelectItem> getTitle() {
        return _title;
    }

    /**
     * @param title the _title to set
     */
    public void setTitle(ArrayList<SelectItem> title) {
        this._title = title;
    }

    public void cboMiltery_processValueChange(ValueChangeEvent vce) {
        try {
            if (cboMiltery.isSelected()) {
                cboCivile.setSelected(false);
//                this.setTitle(lookUpManager.assignTitle("military"));
//                this.set_jobRank(lookUpManager.assignJobRank("Military"));
                drlRank.setDisabled(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cboCivile_processValueChange(ValueChangeEvent vce) {
        try {
            if (cboCivile.isSelected()) {
                cboMiltery.setSelected(false);
                drlRank.setDisabled(false);
//                this.setTitle(lookUpManager.assignTitle("civil"));
//                set_jobRank(lookUpManager.assignJobRank("Civil"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cboMale_processValueChange(ValueChangeEvent vce) {
//        if (cboMale.isSelected()) {
//            cboFemale.setSelected(false);
//        }
        sex = vce.getNewValue().toString();
    }

    public void cboFemale_processValueChange(ValueChangeEvent vce) {
//        if (cboFemale.isSelected()) {
//            cboMale.setSelected(false);
////            lblSexValidation.setRendered(false);
//        }
        sex = vce.getNewValue().toString();
    }
}
