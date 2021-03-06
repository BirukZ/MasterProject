/*
 * EmployeeReport.java
 *
 * Created on Jul 11, 2012, 9:15:09 PM
 * Copyright PROJECT
 */
package fphrms.Report;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.html.HtmlDataTable;
import manager.reporterManager.employeeProfileReportManager.EmployeeProfileReportManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeProfileEducationReport extends AbstractPageBean {

    private ArrayList<EmployeeEducationReportList> listOfEmployeeEducationDate = new ArrayList<EmployeeEducationReportList>();
    private boolean firstTime = true;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeProfileEducationReport() {
    }

    public ArrayList<EmployeeEducationReportList> getListOfEmployeeEducationDate() {
        return listOfEmployeeEducationDate;
    }

    public void setListOfEmployeeEducationDate(ArrayList<EmployeeEducationReportList> listOfEmployeeEducationDate) {
        this.listOfEmployeeEducationDate = listOfEmployeeEducationDate;
    }

    public class EmployeeReportList {

        private String employeeId;
        private String employeeName;
        private String religion;
        private String hireDate;
        private String dateOfBirth;
        private String salary;
        private String nationCode;
        private String maritalStatus;
        private String sex;
        private String rankId;
        private String payGrade;
        private String jobCode;
        private String retirementNumber;
        private String nationality;
        private String employeeStatus;
        private String departmentID;
        private String tinNumber;
        private String officeOrShift;
        private String employementType;
        private String jobDescription;
        private String departmentDescription;
        private String languageDescription;
        private String age;

        public EmployeeReportList(String employeeId,
                String employeeName,
                String religion,
                String hireDate,
                String dateOfBirth,
                String salary,
                String nationCode,
                String maritalStatus,
                String sex,
                String rankId,
                String payGrade,
                String jobCode,
                String retirementNumber,
                String nationality,
                String employeeStatus,
                String departmentID,
                String tinNumber,
                String officeOrShift,
                String employementType,
                String jobDescription,
                String departmentDescription,
                String languageDescription,
                String age) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.religion = religion;
            this.hireDate = hireDate;
            this.dateOfBirth = dateOfBirth;
            this.salary = salary;
            this.nationCode = nationCode;
            this.maritalStatus = maritalStatus;
            this.sex = sex;
            this.rankId = rankId;
            this.payGrade = payGrade;
            this.jobCode = jobCode;
            this.retirementNumber = retirementNumber;
            this.nationality = nationality;
            this.employeeStatus = employeeStatus;
            this.departmentID = departmentID;
            this.tinNumber = tinNumber;
            this.officeOrShift = officeOrShift;
            this.employementType = employementType;
            this.jobDescription = jobDescription;
            this.departmentDescription = departmentDescription;
            this.languageDescription = languageDescription;
            this.age = age;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getDepartmentDescription() {
            return departmentDescription;
        }

        public void setDepartmentDescription(String departmentDescription) {
            this.departmentDescription = departmentDescription;
        }

        public String getDepartmentID() {
            return departmentID;
        }

        public void setDepartmentID(String departmentID) {
            this.departmentID = departmentID;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeStatus() {
            return employeeStatus;
        }

        public void setEmployeeStatus(String employeeStatus) {
            this.employeeStatus = employeeStatus;
        }

        public String getEmployementType() {
            return employementType;
        }

        public void setEmployementType(String employementType) {
            this.employementType = employementType;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }

        public String getJobCode() {
            return jobCode;
        }

        public void setJobCode(String jobCode) {
            this.jobCode = jobCode;
        }

        public String getJobDescription() {
            return jobDescription;
        }

        public void setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getNationCode() {
            return nationCode;
        }

        public void setNationCode(String nationCode) {
            this.nationCode = nationCode;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getOfficeOrShift() {
            return officeOrShift;
        }

        public void setOfficeOrShift(String officeOrShift) {
            this.officeOrShift = officeOrShift;
        }

        public String getPayGrade() {
            return payGrade;
        }

        public void setPayGrade(String payGrade) {
            this.payGrade = payGrade;
        }

        public String getRankId() {
            return rankId;
        }

        public void setRankId(String rankId) {
            this.rankId = rankId;
        }

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public String getRetirementNumber() {
            return retirementNumber;
        }

        public void setRetirementNumber(String retirementNumber) {
            this.retirementNumber = retirementNumber;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTinNumber() {
            return tinNumber;
        }

        public void setTinNumber(String tinNumber) {
            this.tinNumber = tinNumber;
        }

        public String getLanguageDescription() {
            return languageDescription;
        }

        public void setLanguageDescription(String languageDescription) {
            this.languageDescription = languageDescription;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    public class EmployeeEducationReportList {

        private String employeeId;
        private String employeeName;
        private String religion;
        private String hireDate;
        private String dateOfBirth;
        private String salary;
        private String nationCode;
        private String maritalStatus;
        private String sex;
        private String rankId;
        private String payGrade;
        private String jobCode;
        private String retirementNumber;
        private String nationality;
        private String employeeStatus;
        private String departmentID;
        private String tinNumber;
        private String officeOrShift;
        private String employementType;
        private String jobDescription;
        private String departmentDescription;
        private String educationType;
        private String educationGrade;
        private String age;

        public EmployeeEducationReportList(String employeeId,
                String employeeName,
                String religion,
                String hireDate,
                String dateOfBirth,
                String salary,
                String nationCode,
                String maritalStatus,
                String sex,
                String rankId,
                String payGrade,
                String jobCode,
                String retirementNumber,
                String nationality,
                String employeeStatus,
                String departmentID,
                String tinNumber,
                String officeOrShift,
                String employementType,
                String jobDescription,
                String departmentDescription,
                String educationType,
                String educationGrade,
                String age) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.religion = religion;
            this.hireDate = hireDate;
            this.dateOfBirth = dateOfBirth;
            this.salary = salary;
            this.nationCode = nationCode;
            this.maritalStatus = maritalStatus;
            this.sex = sex;
            this.rankId = rankId;
            this.payGrade = payGrade;
            this.jobCode = jobCode;
            this.retirementNumber = retirementNumber;
            this.nationality = nationality;
            this.employeeStatus = employeeStatus;
            this.departmentID = departmentID;
            this.tinNumber = tinNumber;
            this.officeOrShift = officeOrShift;
            this.employementType = employementType;
            this.jobDescription = jobDescription;
            this.departmentDescription = departmentDescription;
            this.educationType = educationType;
            this.educationGrade = educationGrade;
            this.age = age;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getDepartmentDescription() {
            return departmentDescription;
        }

        public void setDepartmentDescription(String departmentDescription) {
            this.departmentDescription = departmentDescription;
        }

        public String getDepartmentID() {
            return departmentID;
        }

        public void setDepartmentID(String departmentID) {
            this.departmentID = departmentID;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeStatus() {
            return employeeStatus;
        }

        public void setEmployeeStatus(String employeeStatus) {
            this.employeeStatus = employeeStatus;
        }

        public String getEmployementType() {
            return employementType;
        }

        public void setEmployementType(String employementType) {
            this.employementType = employementType;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }

        public String getJobCode() {
            return jobCode;
        }

        public void setJobCode(String jobCode) {
            this.jobCode = jobCode;
        }

        public String getJobDescription() {
            return jobDescription;
        }

        public void setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getNationCode() {
            return nationCode;
        }

        public void setNationCode(String nationCode) {
            this.nationCode = nationCode;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getOfficeOrShift() {
            return officeOrShift;
        }

        public void setOfficeOrShift(String officeOrShift) {
            this.officeOrShift = officeOrShift;
        }

        public String getPayGrade() {
            return payGrade;
        }

        public void setPayGrade(String payGrade) {
            this.payGrade = payGrade;
        }

        public String getRankId() {
            return rankId;
        }

        public void setRankId(String rankId) {
            this.rankId = rankId;
        }

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public String getRetirementNumber() {
            return retirementNumber;
        }

        public void setRetirementNumber(String retirementNumber) {
            this.retirementNumber = retirementNumber;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTinNumber() {
            return tinNumber;
        }

        public void setTinNumber(String tinNumber) {
            this.tinNumber = tinNumber;
        }

        public String getEducationGrade() {
            return educationGrade;
        }

        public void setEducationGrade(String educationGrade) {
            this.educationGrade = educationGrade;
        }

        public String getEducationType() {
            return educationType;
        }

        public void setEducationType(String educationType) {
            this.educationType = educationType;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
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
        if (firstTime) {
            firstTime = false;
            loadTableDate();
        }
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

    private void loadTableDate() {
        try {
            EmployeeProfileReportManager profileReportManager = new EmployeeProfileReportManager();
            ArrayList<HashMap> listOfEmployeeEduca = profileReportManager.selectEmployeeEducationList();
            for (HashMap hm : listOfEmployeeEduca) {
                EmployeeEducationReportList employeeReportList = new EmployeeEducationReportList(
                        hm.get("EMP_ID").toString(),
                        hm.get("FULLNAME").toString(),
                        hm.get("RELIGION").toString(),
                        hm.get("HIRE_DATE").toString(),
                        hm.get("DATE_OF_BIRTH").toString(),
                        hm.get("SALARY").toString(),
                        hm.get("NATION_CODE").toString(),
                        hm.get("MARITAL_STATUS").toString(),
                        hm.get("SEX").toString(),
                        hm.get("RANK_ID").toString(),
                        hm.get("PAY_GRADE").toString(),
                        hm.get("JOB_CODE").toString(),
                        hm.get("RETIREMENT_NO").toString(),
                        hm.get("NATIONALITY").toString(),
                        hm.get("EMP_STATUS").toString(),
                        hm.get("DEPARTMENT_ID").toString(),
                        hm.get("TIN_NUMBER").toString(),
                        hm.get("OFFICE_OR_SHIFT").toString(),
                        hm.get("EMPLOYMENTTYPE").toString(),
                        hm.get("JOB_DESCRIPTION").toString(),
                        hm.get("DEP_DESCRIPTION").toString(),
                        hm.get("EDUCATIONTYPE").toString(),
                        hm.get("EDUCATIONLEAVE").toString(),
                        hm.get("AGE").toString());
                getListOfEmployeeEducationDate().add(employeeReportList);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

