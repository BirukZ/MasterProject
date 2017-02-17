/*
 * DisciplineReport.java
 *
 * Created on Jul 12, 2012, 7:07:00 PM
 * Copyright Biruk
 */
package fphrms.Report;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import entity.reporterEntity.employeeProfileReportEntity.EmployeeProfileReportEntity;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import manager.disciplineManager.DisciplineReportModel;
import manager.disciplineManager.DisciplineReportManager;
import manager.reporterManager.EmployeePersonalInfo;
import manager.reporterManager.EmployeePersonalInfo.PersonalReportModel;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeePersonalReport extends AbstractPageBean {
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

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeePersonalReport() {
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
            log("DisciplineReport Initialization Failure", e);
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
      //populateCourseTableComponents();
       
       populatePersonalInfo();
     
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
  // populateDisiciplineTableComponentsByMonth(month);
   DisciplineReportManager reportManager=new DisciplineReportManager();
   ArrayList<PersonalReportModel> personalInfoReport= new ArrayList<PersonalReportModel>();
        String month;
        int counter;
        String empID;
        String empFullName;
        int age;
        String empSex;
        String nation;
        String dataOfBirth;
        String hireDate;
        String eudcationLevel;
        String educationType;
        String religion;
        String maritalStatus;
        String retirimentNumber;
        String tinNumber;
        String insideExpirance;
        String otherExpirance;
        String jobName;
        String jobDescription;
        String rank;
        String department;
        String workPlace;
        String initilaSalary;
        String currentSalary;
       // String approvedDate;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getEmpFullName() {
        return empFullName;
    }

    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEudcationLevel() {
        return eudcationLevel;
    }

    public void setEudcationLevel(String eudcationLevel) {
        this.eudcationLevel = eudcationLevel;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getInitilaSalary() {
        return initilaSalary;
    }

    public void setInitilaSalary(String initilaSalary) {
        this.initilaSalary = initilaSalary;
    }

    public String getInsideExpirance() {
        return insideExpirance;
    }

    public void setInsideExpirance(String insideExpirance) {
        this.insideExpirance = insideExpirance;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public DisciplineReportManager getReportManager() {
        return reportManager;
    }

    public void setReportManager(DisciplineReportManager reportManager) {
        this.reportManager = reportManager;
    }

    public String getRetirimentNumber() {
        return retirimentNumber;
    }

    public void setRetirimentNumber(String retirimentNumber) {
        this.retirimentNumber = retirimentNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public ArrayList<PersonalReportModel> getPersonalInfoReport() {
        return personalInfoReport;
    }

    public void setPersonalInfoReport(ArrayList<PersonalReportModel> personalInfoReport) {
        this.personalInfoReport = personalInfoReport;
    }

  
        
   
    // populateDisiciplineTableComponentsByMonth(month)
    
 EmployeePersonalInfo employeeProfileReportManager = new EmployeePersonalInfo();

       private boolean populatePersonalInfo()
       {
           
         int tableSize;

         ArrayList<HashMap> employeeProfile = employeeProfileReportManager.loadEmployeeInformationForReport();
        if (employeeProfile != null) {
            tableSize = 0;
    
            for (HashMap hmDl : employeeProfile) {
                empID = hmDl.get("EMPLOYEEID").toString();
                empFullName = hmDl.get("FULLNAME").toString();
                age = Integer.parseInt(hmDl.get("AGE").toString());
                empSex = hmDl.get("SEX").toString();
                nation = hmDl.get("NATION").toString();
                dataOfBirth = hmDl.get("DATEOFBIRTH").toString();
                hireDate = hmDl.get("HIREDATE").toString();
                eudcationLevel = hmDl.get("EDUCATIONLEVEL").toString();
                educationType = hmDl.get("EDUCATIONTYPE").toString();
                religion = hmDl.get("RELIGION").toString();
                maritalStatus = hmDl.get("MARITAL_STATUS").toString();
                retirimentNumber = hmDl.get("RETIREMENT_NO").toString();
                tinNumber=hmDl.get("TIN_NUMBER").toString();
                insideExpirance = hmDl.get("EXPRIANCEINBIB").toString();
                otherExpirance = hmDl.get("OTHEREXPRIANCE").toString();
                jobName = hmDl.get("JOB_NAME").toString();
                jobDescription = hmDl.get("JOB_DESCRIPTION").toString();
                rank = hmDl.get("RANK").toString();
                department=hmDl.get("DEPARTMENT").toString();
                workPlace=hmDl.get("WORKPLACE").toString();
                 initilaSalary = hmDl.get("INTIALSALARY").toString();
                  currentSalary = hmDl.get("CURRENTSALARY").toString();
                personalInfoReport.add(new PersonalReportModel(empID, empFullName, age , empSex, nation, dataOfBirth, hireDate,eudcationLevel,educationType,religion,maritalStatus,retirimentNumber, tinNumber, insideExpirance,otherExpirance,jobName, jobDescription,rank,department,workPlace,initilaSalary,currentSalary));
                tableSize++;
                    }
            return true;
        } else {

            return false;
        }
    }

}

