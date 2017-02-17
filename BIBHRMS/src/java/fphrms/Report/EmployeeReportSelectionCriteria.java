/*
 * EmployeeReport.java
 *
 * Created on Jul 11, 2012, 9:15:09 PM
 * Copyright PROJECT
 */
package fphrms.Report;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.ReportControl;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.html.HtmlDataTable;
import manager.reporterManager.employeeProfileReportManager.EmployeeProfileReportManager;
import fphrms.Termination.RetireRequestPage;
import fphrms.Recruitment.ExamQuestions;
import fphrms.EmployeeHistory.ComplaintPage1;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.SalaryDeligationRequestPage;
import fphrms.Template_1;
import fphrms.Organization.OrganizationTreePage;
import fphrms.Help.Template;
import fphrms.Termination.RetireApprovalPage;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeReportSelectionCriteria extends AbstractPageBean {

   

    private ImageIcon LOGO;
    ArrayList<SelectItem> reportSortCriteria = new ArrayList<SelectItem>();
    EmployeeProfileReportManager employeeProfileReportManager = new EmployeeProfileReportManager();
    private ReportControl reportControl = new ReportControl();
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        setReportSortCriteria(employeeProfileReportManager.employeeRepartSortCriteria());
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlDataTable dataTable1 = new HtmlDataTable();

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }
    private com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel dataTable2Model = new com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel();

    public com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
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
    private DefaultSelectedData selectBooleanCheckbox4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox4Bean() {
        return selectBooleanCheckbox4Bean;
    }

    public void setSelectBooleanCheckbox4Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox4Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox choPermanet = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoPermanet() {
        return choPermanet;
    }

    public void setChoPermanet(HtmlSelectBooleanCheckbox hsbc) {
        this.choPermanet = hsbc;
    }
    private HtmlCommandButton btnGeneratefullReport = new HtmlCommandButton();

    public HtmlCommandButton getBtnGeneratefullReport() {
        return btnGeneratefullReport;
    }

    public void setBtnGeneratefullReport(HtmlCommandButton hcb) {
        this.btnGeneratefullReport = hcb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectBooleanCheckbox choFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoFemale() {
        return choFemale;
    }

    public void setChoFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.choFemale = hsbc;
    }
    private HtmlSelectBooleanCheckbox choMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMale() {
        return choMale;
    }

    public void setChoMale(HtmlSelectBooleanCheckbox hsbc) {
        this.choMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox cholContract = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCholContract() {
        return cholContract;
    }

    public void setCholContract(HtmlSelectBooleanCheckbox hsbc) {
        this.cholContract = hsbc;
    }
    private HtmlSelectOneMenu drlSortCriteria = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSortCriteria() {
        return drlSortCriteria;
    }

    public void setDrlSortCriteria(HtmlSelectOneMenu hsom) {
        this.drlSortCriteria = hsom;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeReportSelectionCriteria() {
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
            log("EmployeeReport Initialization Failure", e);
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



    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireRequestPage getTermination$RetireRequestPage() {
        return (RetireRequestPage) getBean("Termination$RetireRequestPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ExamQuestions getRecruitment$ExamQuestions() {
        return (ExamQuestions) getBean("Recruitment$ExamQuestions");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ComplaintPage1 getEmployeeHistory$ComplaintPage1() {
        return (ComplaintPage1) getBean("EmployeeHistory$ComplaintPage1");
    }

 
    

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected EvaluationResultPage getEmployeeHistory$EvaluationResultPage() {
        return (EvaluationResultPage) getBean("EmployeeHistory$EvaluationResultPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SalaryDeligationRequestPage getSalaryDeligationRequestPage() {
        return (SalaryDeligationRequestPage) getBean("SalaryDeligationRequestPage");
    }

 

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template_1 getTemplate_1() {
        return (Template_1) getBean("Template_1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
   

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected OrganizationTreePage getOrganization$OrganizationTreePage() {
        return (OrganizationTreePage) getBean("Organization$OrganizationTreePage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template getHelp$Template() {
        return (Template) getBean("Help$Template");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireApprovalPage getTermination$RetireApprovalPage() {
        return (RetireApprovalPage) getBean("Termination$RetireApprovalPage");
    }

    public ArrayList<SelectItem> getReportSortCriteria() {
        return reportSortCriteria;
    }

    public void setReportSortCriteria(ArrayList<SelectItem> reportSortCriteria) {
        this.reportSortCriteria = reportSortCriteria;
    }

    public String btnGeneratefullReport_action() {
        btnfullReport();
        //return null means stay on the same page
        return null;
    }

    public String btnfullReport() {

        String departmentId = "";
        String directorate = "";
        String division = "";
        String employeeGender;
        String cooperative = "";
        String team = "";
        String sortBY = " ORDER BY hr_lu_title.TITLE_LEVEL DESC";
        String employeeType = null;
        String departemntDescription = "";
        HashMap param = new HashMap();
        //E:\\FEDERALREPORTS\\Employee\\PersonalRecord.jasper
        String jasperLocation = "A:\\Employee\\HRGroup.jasper";
        String reportName = "HumanResourceEmployeeReport";
        if (choPermanet.isSelected() && cholContract.isSelected()) {
            employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";
        } else if (choPermanet.isSelected()) {
            employeeType = " AND EMPLOYMENTTYPE='Permanent'";

        } else if (cholContract.isSelected()) {
            employeeType = " AND EMPLOYMENTTYPE='Contract'";

        } else {
           employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";

        }
        if (choMale.isSelected() && choFemale.isSelected()) {
            employeeGender = " AND (SEX='Female' OR SEX='Male')";
        } else if (choMale.isSelected()) {
            employeeGender = " AND ( SEX='Male')";
        } else if (choFemale.isSelected()) {
            employeeGender = " AND (SEX='Female')";
        } else {
            employeeGender = " AND (SEX='Female' OR SEX='Male')";

        }
        if (drlSortCriteria.getValue() != null) {
            if (drlSortCriteria.getValue().equals("Salary")) {
                sortBY = " order by salary DESC";
            } else if (drlSortCriteria.getValue().equals("Name")) {
                sortBY = " order by first_name";
            } else if (drlSortCriteria.getValue().equals("ID")) {
                sortBY = " ORDER BY EMP_ID ";
            }

        }
        Collection data = employeeProfileReportManager.loadEmployeeInformationForReport(
                departmentId,
                employeeType,
                employeeGender,
                sortBY);

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
            param.put("DEPARTMENT", departemntDescription);
            param.put("LOGO", LOGO.getImage());
            param.put("PREPARED", getSessionBean1().getEmployeeName());
            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
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

    public String btnExpriance_action() {
        btnExprianceReport();
        //return null means stay on the same page
        return null;
    }
     public String btnExprianceReport() {

        String departmentId = "";
        String directorate = "";
        String division = "";
        String employeeGender;
        String cooperative = "";
        String team = "";
        String sortBY = " ORDER BY hr_lu_title.TITLE_LEVEL DESC";
        String employeeType = null;
        String departemntDescription = "";
        HashMap param = new HashMap();
        //E:\\FEDERALREPORTS\\Employee\\PersonalRecord.jasper
        String jasperLocation = "A:\\Employee\\report4.jasper";
        String reportName = "HumanResourceEmployeeReport";
//        if (choPermanet.isSelected() && cholContract.isSelected()) {
//            employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";
//        } else if (choPermanet.isSelected()) {
//            employeeType = " AND EMPLOYMENTTYPE='Permanent'";
//
//        } else if (cholContract.isSelected()) {
//            employeeType = " AND EMPLOYMENTTYPE='Contract'";
//
//        } else {
//           employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";
//
//        }
//        if (choMale.isSelected() && choFemale.isSelected()) {
//            employeeGender = " AND (SEX='Female' OR SEX='Male')";
//        } else if (choMale.isSelected()) {
//            employeeGender = " AND ( SEX='Male')";
//        } else if (choFemale.isSelected()) {
//            employeeGender = " AND (SEX='Female')";
//        } else {
//            employeeGender = " AND (SEX='Female' OR SEX='Male')";
//
//        }
//        if (drlSortCriteria.getValue() != null) {
//            if (drlSortCriteria.getValue().equals("Salary")) {
//                sortBY = " order by salary DESC";
//            } else if (drlSortCriteria.getValue().equals("Name")) {
//                sortBY = " order by first_name";
//            } else if (drlSortCriteria.getValue().equals("ID")) {
//                sortBY = " ORDER BY EMP_ID ";
//            }
//
//        }
        Collection data = employeeProfileReportManager.loadEmployeeExprianceForReport();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
           // param.put("DEPARTMENT", departemntDescription);
            param.put("LOGO", LOGO.getImage());
            //param.put("PREPARED", getSessionBean1().getEmployeeName());
            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
             ex.printStackTrace();
            //  ErrorLogWriter.writeError(ex);
        }
        return null;



    //return null means stay on the same page

    }
}

