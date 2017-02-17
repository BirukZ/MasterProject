/*
 * EducationRequestReportPage.java
 *
 * Created on Jul 11, 2012, 12:11:08 AM
 * Copyright Admin
 */
package fphrms.Education;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.html.HtmlDataTable;

import manager.educationManager.ApprovedEducReportMnager;
import manager.educationManager.ReportModel;
import manager.educationManager.ReportManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ApprocedEducationReportPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        //populateCourseTableComponents();
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlDataTable dtbEducationRequestReport = new HtmlDataTable();

    public HtmlDataTable getDtbEducationRequestReport() {
        return dtbEducationRequestReport;
    }

    public void setDtbEducationRequestReport(HtmlDataTable hdt) {
        this.dtbEducationRequestReport = hdt;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ApprocedEducationReportPage() {
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
            log("EducationRequestReportPage Initialization Failure", e);
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
        populateCourseTableComponents();
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
    ApprovedEducReportMnager reportManager = new ApprovedEducReportMnager();
    ArrayList<ReportModel> educationRequsetList = new ArrayList<ReportModel>();
    int tableSize;
    String hireDate;
    String result;
    String requesterName;
    int age;
    String sex;
    String jobPostion;
    String dpartement;
    String team;
    String location;
    String currentEducation;
    String currentEducationrank;
    String requestedEducation;
    String requestedEuctionrank;
    String institutionName;
    String ethiopianInstitution;//inside or outside ethiopia
    String institutionAccredited;//
    String institutionAddress;
    String educationShiftCategory;
    String appliedDate;
    String requesterId;
    String acadamicYear;
    String startDate;
    String endDate;
    double totalCost;
    String documentReqNum;
    double totalCostAll;

    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getCurrentEducation() {
        return currentEducation;
    }

    public void setCurrentEducation(String currentEducation) {
        this.currentEducation = currentEducation;
    }

    public String getCurrentEducationrank() {
        return currentEducationrank;
    }

    public void setCurrentEducationrank(String currentEducationrank) {
        this.currentEducationrank = currentEducationrank;
    }

    public String getDpartement() {
        return dpartement;
    }

    public void setDpartement(String dpartement) {
        this.dpartement = dpartement;
    }

    public String getEducationShiftCategory() {
        return educationShiftCategory;
    }

    public void setEducationShiftCategory(String educationShiftCategory) {
        this.educationShiftCategory = educationShiftCategory;
    }

    public String getEthiopianInstitution() {
        return ethiopianInstitution;
    }

    public void setEthiopianInstitution(String ethiopianInstitution) {
        this.ethiopianInstitution = ethiopianInstitution;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getInstitutionAccredited() {
        return institutionAccredited;
    }

    public void setInstitutionAccredited(String institutionAccredited) {
        this.institutionAccredited = institutionAccredited;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getJobPostion() {
        return jobPostion;
    }

    public void setJobPostion(String jobPostion) {
        this.jobPostion = jobPostion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    

    public String getRequestedEducation() {
        return requestedEducation;
    }

    public void setRequestedEducation(String requestedEducation) {
        this.requestedEducation = requestedEducation;
    }

    public String getRequestedEuctionrank() {
        return requestedEuctionrank;
    }

    public void setRequestedEuctionrank(String requestedEuctionrank) {
        this.requestedEuctionrank = requestedEuctionrank;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<ReportModel> getEducationRequsetList() {
        return educationRequsetList;
    }

    public void setEducationRequsetList(ArrayList<ReportModel> educationRequsetList) {
        this.educationRequsetList = educationRequsetList;
    }

    private boolean populateCourseTableComponents() {
        // int tableSize;
        ArrayList<HashMap> empInfoHashMap = reportManager.getApprovedEduc();
        if (empInfoHashMap != null) {
            tableSize = 0;
            boolean firstTime = true;
            double total = 0;
            getEducationRequsetList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                if (firstTime) {
                    total = Double.valueOf(hmTc.get("Total_amount").toString());
                    if (total > 0) {
                        firstTime = false;
                    }
                }
                requesterId = hmTc.get("emp_id").toString();
                requesterName = hmTc.get("FullName").toString();
                age = Integer.valueOf(hmTc.get("AGE").toString());
                sex = hmTc.get("sex").toString();
                hireDate = hmTc.get("hire_date").toString();
                jobPostion = hmTc.get("job_description").toString();
                dpartement = hmTc.get("department_path").toString();
                team = hmTc.get("EducationProgram").toString();
                location = hmTc.get("description").toString();
                currentEducation = hmTc.get("EducationProgram").toString();
                currentEducationrank = hmTc.get("description").toString();
               // result = hmTc.get("result").toString();
                requestedEducation = hmTc.get("education_program_name").toString();
                requestedEuctionrank = hmTc.get("education_level_category").toString();
                institutionName = hmTc.get("institution_name").toString();
                appliedDate = hmTc.get("applied_date").toString();
                institutionAccredited = hmTc.get("accredited_or_not").toString();
                educationShiftCategory = hmTc.get("EDUCATION_SHIFT_CATEGORY").toString();
                acadamicYear = hmTc.get("applied_date").toString();
                startDate = hmTc.get("start_date").toString();
                endDate = hmTc.get("end_date").toString();
                totalCost = Double.valueOf(hmTc.get("total_admin_costs").toString());
                documentReqNum = hmTc.get("document_reference_number").toString();
                // totalCostAll=Double.valueOf(hmTc.get("Total_amount").toString());
                educationRequsetList.add(new ReportModel(requesterId, requesterName, age, sex, hireDate, jobPostion, dpartement, team, location, currentEducation, currentEducationrank, result, requestedEducation, requestedEuctionrank, institutionName, appliedDate, institutionAccredited, educationShiftCategory, acadamicYear, startDate, endDate, totalCost, documentReqNum));
                tableSize++;
            }
              educationRequsetList.add(new ReportModel("", "", 0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "totalcost", "", "", "", total, ""));
            return true;
        } else {
            return false;
        }
    }
}

