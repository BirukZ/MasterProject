/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.ReportControl;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeModel;
import manager.leaveManager.LeaveReportManager;
import manager.organizationManager.LoadTree;
import manager.reporterManager.employeeProfileReportManager.EmployeeProfileReportManager;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.util.SimpleFileResolver;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LeaveReportPage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ImageIcon LOGO;
    private String reportFormat;
    private ReportControl reportControl = new ReportControl();
    private LeaveReportManager leaveReportManager = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<SelectItem> listOfRepoetType = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getListOfRepoetType() {
        return listOfRepoetType;
    }

    public void setListOfRepoetType(ArrayList<SelectItem> listOfRepoetType) {
        this.listOfRepoetType = listOfRepoetType;
    }
    private int DEPARRTMENT_ID = 0;

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
        LoadTree loadTree = new LoadTree();
        this.tree2Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        checkobject();
        setListOfRepoetType(leaveReportManager.getReportType());
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultTree tree2Model = new DefaultTree();

    public DefaultTree getTree2Model() {
        return tree2Model;
    }

    public void setTree2Model(DefaultTree dt) {
        this.tree2Model = dt;
    }
    private PanelLayout panTreeHolder = new PanelLayout();

    public PanelLayout getPanTreeHolder() {
        return panTreeHolder;
    }

    public void setPanTreeHolder(PanelLayout pl) {
        this.panTreeHolder = pl;
    }
    private Tree treeLeaveReport = new Tree();

    public Tree getTreeLeaveReport() {
        return treeLeaveReport;
    }

    public void setTreeLeaveReport(Tree t) {
        this.treeLeaveReport = t;
    }
    private HtmlOutputText lblDepartmentName = new HtmlOutputText();

    public HtmlOutputText getLblDepartmentName() {
        return lblDepartmentName;
    }

    public void setLblDepartmentName(HtmlOutputText hot) {
        this.lblDepartmentName = hot;
    }
    private HtmlSelectOneMenu drlReportType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlReportType() {
        return drlReportType;
    }

    public void setDrlReportType(HtmlSelectOneMenu hsom) {
        this.drlReportType = hsom;
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
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkHtml = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkHtml() {
        return chkHtml;
    }

    public void setChkHtml(HtmlSelectBooleanCheckbox hsbc) {
        this.chkHtml = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkExcel = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkExcel() {
        return chkExcel;
    }

    public void setChkExcel(HtmlSelectBooleanCheckbox hsbc) {
        this.chkExcel = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkWord = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkWord() {
        return chkWord;
    }

    public void setChkWord(HtmlSelectBooleanCheckbox hsbc) {
        this.chkWord = hsbc;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private SelectInputDate txtEndDate = new SelectInputDate();

    public SelectInputDate getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(SelectInputDate sid) {
        this.txtEndDate = sid;
    }
    private HtmlOutputText lblTo = new HtmlOutputText();

    public HtmlOutputText getLblTo() {
        return lblTo;
    }

    public void setLblTo(HtmlOutputText hot) {
        this.lblTo = hot;
    }
    private SelectInputDate txtStartDate = new SelectInputDate();

    public SelectInputDate getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(SelectInputDate sid) {
        this.txtStartDate = sid;
    }
    private HtmlOutputText lblStartDate = new HtmlOutputText();

    public HtmlOutputText getLblStartDate() {
        return lblStartDate;
    }

    public void setLblStartDate(HtmlOutputText hot) {
        this.lblStartDate = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LeaveReportPage() {
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

    public String btnDisplay_action() {
        if (chkExcel.isSelected() || chkHtml.isSelected() || chkWord.isSelected()) {
            if (drlReportType.getValue() != null) {
                if (drlReportType.getValue().toString().equals("AVAILABLEANNUALLEAVE")) {
                    generateLeaveReport(reportFormat);//     generateReport();
                } else if (drlReportType.getValue().toString().equals("LEAVESTASTIC")) {
                    generateStaticLeaveReport(reportFormat);
                } else if (drlReportType.getValue().toString().equals("LEAVESCHEDDULE")) {
                    generateLeaveScatuleReport(reportFormat);
                } else {
                }
            }
        }

        //return null means stay on the same page
        return null;
    }

    public void generateLeaveRequest(String format) {
        
    }

    public String generateReport() {
        String departmentName = lblDepartmentName.getValue().toString();
        String directorate = "";
        String division = "";
        String employeeGender;
        String cooperative = "";
        String team = "";
        String sortBY = " ORDER BY hr_lu_title.TITLE_LEVEL DESC";
        String employeeType = null;
        String departemntDescription = "";
        HashMap param = new HashMap();
        String jasperLocation = "A:\\Employee\\LEAVE\\RemainingAnualLeave.jasper";
        String reportName = "HumanResourceEmployeeReport";
        employeeGender = " AND (SEX='Female' OR SEX='Male')";
        sortBY = " ORDER BY EMP_ID ";
        checkobject();
        Collection data = leaveReportManager.getEmployeeRemainingLeave(Integer.toString(DEPARRTMENT_ID));
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        //ServletOutputStream servletOutputStream = null;
        try {
            // servletOutputStream = response.getOutputStream();
            LoadLOGO();

            param.put("DEPARTMENT", departmentName);
            param.put("FIRST", "2003");
            param.put("SECOND", "2004");
            param.put("LAST", "2005");
            param.put("TODAY", sdf.format(new Date()));
            reportControl.generateReport(response, request, "html", jasperLocation, param, data);
            FacesContext.getCurrentInstance().responseComplete();
//            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
//            servletOutputStream.flush();
//            servletOutputStream.close();
//            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }
        return null;



    //return null means stay on the same page

    }

    public void generateLeaveReport(String format) {
        try {
            String departmentName = lblDepartmentName.getValue().toString();
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/Leave");
            String jasperLocation = reportPath + "\\RemainingAnualLeave.jasper";
            File reportsDir = new File(reportPath);
            HashMap param = new HashMap();
            param.put("DEPARTMENT", departmentName);
            param.put("FIRST", "2003");
            param.put("SECOND", "2004");
            param.put("LAST", "2005");
            param.put("TODAY", sdf.format(new Date()));
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat(format);
            //OracleCachedRowSet ocrs = ;
            getSessionBean1().setRs(leaveReportManager.getEmployeeRemainingLeaveList(Integer.toString(DEPARRTMENT_ID)));
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('ReportPage.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");
        } catch (Exception e) {
        }
    //return null means stay on the same page

    }

    public void generateStaticLeaveReport(String format) {
        try {
            String departmentName = lblDepartmentName.getValue().toString();
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/Leave");
            String jasperLocation = reportPath + "\\LeaveStastaicReport.jasper";
            File reportsDir = new File(reportPath);
            HashMap param = new HashMap();
            param.put("DEPARTMENT", departmentName);
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat(format);
            //OracleCachedRowSet ocrs = ;
            getSessionBean1().setRs(leaveReportManager.getLeaveStatsticReportSum());
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('ReportPage.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");
        } catch (Exception e) {
        }
    //return null means stay on the same page

    }

    public void generateLeaveScatuleReport(String format) {
        try {
            String departmentName = lblDepartmentName.getValue().toString();
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/Leave");
            String jasperLocation = reportPath + "\\LeaveSecadulel.jasper";
            File reportsDir = new File(reportPath);
            HashMap param = new HashMap();
            param.put("DATEANDDEPARTMENT", departmentName);
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat(format);
            //OracleCachedRowSet ocrs = ;
            getSessionBean1().setColl(leaveReportManager.getLeaveSecadule(Integer.toString(DEPARRTMENT_ID)));
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('LeaveScheduleReport.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    //return null means stay on the same page

    }

    public String generateStasticReport() {
        String departmentName = lblDepartmentName.getValue().toString();
        String sortBY = " ORDER BY hr_lu_title.TITLE_LEVEL DESC";

        HashMap param = new HashMap();
        String jasperLocation = "A:\\Employee\\LEAVE\\LeaveStastaicReport.jasper";
        //String reportName = "HumanResourceEmployeeReport";

        checkobject();
//        Collection data = leaveReportManager.getLeaveStatsticReport();

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        // ServletOutputStream servletOutputStream = null;
        try {
            //servletOutputStream = response.getOutputStream();
//            LoadLOGO();

            param.put("DEPARTMENT", departmentName);
//            param.put("FIRST", "2003");
//            param.put("SECOND", "2004");
//            param.put("LAST", "2005");
//            param.put("TODAY", sdf.format(new Date()));
//            param.put("LOGO", LOGO.getImage());
//            param.put("PREPARED", getSessionBean1().getEmployeeName());
            reportControl.generateReport(response,
                    request,
                    "html",
                    jasperLocation,
                    param,
                    leaveReportManager.getLeaveStatsticReportSum());
            FacesContext.getCurrentInstance().responseComplete();

//            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
//            servletOutputStream.flush();
//            servletOutputStream.close();
        // Stop resend
//            FacesContext.getCurrentInstance().responseComplete();
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }
        return null;



    //return null means stay on the same page

    }

    public void LoadLOGO() {
        List data = null;
        EmployeeProfileReportManager manager1 = new EmployeeProfileReportManager();
        data = manager1.loadCompanyLogo();
        ListIterator<EmployeeProfileReportManager> lstmb = data.listIterator();
        try {
            while (lstmb.hasNext()) {
                EmployeeProfileReportManager mag = lstmb.next();
                if (mag.getFPLOGO() != null) {
                    LOGO = new ImageIcon((byte[]) mag.getFPLOGO());
                } else {
                    LOGO = new ImageIcon();
                }
            }
        } catch (Exception ex) {
        }

    }

    private void checkobject() {
        if (leaveReportManager == null) {
            leaveReportManager = new LeaveReportManager();
        }
    }

    public String btnTreeDisplay_action() {
        panTreeHolder.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void cmdTree_processAction(ActionEvent ae) {
        try {
            String departmentName;
            String department = treeLeaveReport.getCurrentNode().toString();//.substring(0, 2);
            String _department[] = department.split("#");
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID =
                        Integer.parseInt(_department[1].trim());
                lblDepartmentName.setValue(departmentName);
                panTreeHolder.setRendered(false);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public String generateLeaveScheduleReport() {
        String departmentName = lblDepartmentName.getValue().toString();
        String directorate = "";
        String division = "";
        String employeeGender;
        String cooperative = "";
        String team = "";
        String sortBY = " ORDER BY hr_lu_title.TITLE_LEVEL DESC";
        String employeeType = null;
        String departemntDescription = "";
        HashMap param = new HashMap();
        String jasperLocation = "A:\\Employee\\LEAVE\\Leave.jasper";
        String reportName = "HumanResourceEmployeeReport";
        employeeGender = " AND (SEX='Female' OR SEX='Male')";
        sortBY = " ORDER BY EMP_ID ";
        checkobject();


        try {

            LoadLOGO();
            param.put("DATEANDDEPARTMENT", departmentName);
//            param.put("LOGO", "2003");
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request =
                    (HttpServletRequest) context.getExternalContext().getRequest();
            ReportControl reportCtrl = new ReportControl();
            HttpServletResponse response =
                    (HttpServletResponse) context.getExternalContext().getResponse();
            reportCtrl.generateReport(response, request, "xlsx",
                    jasperLocation, param,
                    leaveReportManager.getLeaveSecadule(Integer.toString(DEPARRTMENT_ID)));
            //   getSessionBean1().clearSessionParameter();
            FacesContext.getCurrentInstance().responseComplete();

//            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
//            servletOutputStream.flush();
//            servletOutputStream.close();
//            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }
        return null;



    //return null means stay on the same page

    }

    private void generateLeave(String format) {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/Leave");
            String jasperLocation = reportPath + "\\EmployeeName.jasper";
            File reportsDir = new File(reportPath);
            HashMap param = new HashMap();
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat(format);
            OracleCachedRowSet ocrs = leaveReportManager.getFullName();
            getSessionBean1().setRs(ocrs);
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('ReportPage.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chkWord_processValueChange(ValueChangeEvent vce) {
        reportFormat = "docx";
        chkHtml.setSelected(false);
        chkExcel.setSelected(false);
    }

    public void chkExcel_processValueChange(ValueChangeEvent vce) {
        reportFormat = "xlsx";
        chkHtml.setSelected(false);
        chkWord.setSelected(false);
    }

    public void chkHtml_processValueChange(ValueChangeEvent vce) {
        reportFormat = "html";
        chkExcel.setSelected(false);
        chkWord.setSelected(false);
    }
}

