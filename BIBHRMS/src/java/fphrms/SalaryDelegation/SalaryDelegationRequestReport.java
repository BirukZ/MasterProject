/*
 * SalaryDelegationRequestReport.java
 *
 * Created on Jul 18, 2012, 8:53:37 PM
 * Copyright Biruk
 */
package fphrms.SalaryDelegation;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.SalaryDeligationRequestPage;
import javax.faces.FacesException;
import fphrms.Organization.OrganizationTreePage;
import fphrms.Termination.RetireApprovalPage;
import fphrms.Template_1;
import fphrms.ApplicationBean1;
import fphrms.Recruitment.ExamQuestions;
import fphrms.Report.MainReport;
import fphrms.RequestBean1;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.Help.Template;
import fphrms.EmployeeHistory.ComplaintPage1;
import fphrms.SessionBean1;
import fphrms.Termination.RetireRequestPage;
import java.util.ArrayList;
import java.util.HashMap;
import manager.salaryDelegationManager.SalaryDelegationReportManger;
import manager.salaryDelegationManager.SalaryDelegationReportModel;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class SalaryDelegationRequestReport extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SalaryDelegationRequestReport() {
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
            log("SalaryDelegationRequestReport Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
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
        populateSalaryDelegationTableComponents();
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
    protected SalaryDeligationRequestPage getSalaryDeligationRequestPage() {
        return (fphrms.SalaryDeligationRequestPage) getBean("SalaryDeligationRequestPage");
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
    protected RetireApprovalPage getTermination$RetireApprovalPage() {
        return (RetireApprovalPage) getBean("Termination$RetireApprovalPage");
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
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
    protected EvaluationResultPage getEmployeeHistory$EvaluationResultPage() {
        return (EvaluationResultPage) getBean("EmployeeHistory$EvaluationResultPage");
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
    protected fphrms.Discipline.Template_1 getDiscipline$Template_1() {
        return (fphrms.Discipline.Template_1) getBean("Discipline$Template_1");
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
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireRequestPage getTermination$RetireRequestPage() {
        return (RetireRequestPage) getBean("Termination$RetireRequestPage");
    }
    String delegatorId;
    String delegatorFullName;
    String delegatorDepartment;
    String delegateId;
    String delegateFullName;
    String delegateDepartment;
    String delegationStartDate;
    String delegationEndDate;
    String delegationType;
    String delegationReasoun;

 ArrayList<SalaryDelegationReportModel> salaryDelegationRequestModel= new ArrayList<SalaryDelegationReportModel>();
 SalaryDelegationReportManger salarydelegationReport=new SalaryDelegationReportManger();

    public String getDelegateDepartment() {
        return delegateDepartment;
    }

    public void setDelegateDepartment(String delegateDepartment) {
        this.delegateDepartment = delegateDepartment;
    }

    public String getDelegateFullName() {
        return delegateFullName;
    }

    public void setDelegateFullName(String delegateFullName) {
        this.delegateFullName = delegateFullName;
    }

    public String getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(String delegateId) {
        this.delegateId = delegateId;
    }

    public String getDelegationEndDate() {
        return delegationEndDate;
    }

    public void setDelegationEndDate(String delegationEndDate) {
        this.delegationEndDate = delegationEndDate;
    }

    public String getDelegationReasoun() {
        return delegationReasoun;
    }

    public void setDelegationReasoun(String delegationReasoun) {
        this.delegationReasoun = delegationReasoun;
    }

    public String getDelegationStartDate() {
        return delegationStartDate;
    }

    public void setDelegationStartDate(String delegationStartDate) {
        this.delegationStartDate = delegationStartDate;
    }

    public String getDelegationType() {
        return delegationType;
    }

    public void setDelegationType(String delegationType) {
        this.delegationType = delegationType;
    }

    public String getDelegatorDepartment() {
        return delegatorDepartment;
    }

    public void setDelegatorDepartment(String delegatorDepartment) {
        this.delegatorDepartment = delegatorDepartment;
    }

    public String getDelegatorFullName() {
        return delegatorFullName;
    }

    public void setDelegatorFullName(String delegatorFullName) {
        this.delegatorFullName = delegatorFullName;
    }

    public String getDelegatorId() {
        return delegatorId;
    }

    public void setDelegatorId(String delegatorId) {
        this.delegatorId = delegatorId;
    }

    public ArrayList<SalaryDelegationReportModel> getSalaryDelegationRequestModel() {
        return salaryDelegationRequestModel;
    }

    public void setSalaryDelegationRequestModel(ArrayList<SalaryDelegationReportModel> salaryDelegationRequestModel) {
        this.salaryDelegationRequestModel = salaryDelegationRequestModel;
    }

     private boolean populateSalaryDelegationTableComponents()
                {
         int tableSize;
         ArrayList<HashMap> disciplineHashMap = salarydelegationReport.getAllSalaryReportList();
        if (disciplineHashMap != null) {
            tableSize = 0;
         // disciplineReport.clear();
            for (HashMap hmDl : disciplineHashMap) {
                //requesterId = educatRequestId;
                delegatorId = hmDl.get("DelegatorID").toString();
                delegatorFullName = hmDl.get("DelegatorFirst_Name").toString()+""+hmDl.get("Delegator_MiddleName").toString()+""+hmDl.get("Delegator_LastName").toString();
                delegatorDepartment = hmDl.get("Delegator_Department").toString();
                delegateId = hmDl.get("DelegateID").toString();
                delegateDepartment = hmDl.get("Delegate_Department").toString();
                delegateFullName = hmDl.get("Delegate_First_Name").toString()+""+hmDl.get("Delegate_Middle_Name").toString()+""+hmDl.get("Delegate_Last_Name").toString();
                delegationStartDate = hmDl.get("start_date").toString();
                delegationEndDate = hmDl.get("end_date").toString();
                delegationReasoun = hmDl.get("DelegationReaouns").toString();
                delegationType = hmDl.get("delegated_items").toString();

              salaryDelegationRequestModel.add(new SalaryDelegationReportModel(delegatorId,delegatorFullName,delegatorDepartment,delegateId,delegateDepartment,delegateFullName,delegationStartDate,delegationEndDate,delegationReasoun,delegationType));
                tableSize++;
                    }
            return true;
        } else {

            return false;
        }
    }
 
}

