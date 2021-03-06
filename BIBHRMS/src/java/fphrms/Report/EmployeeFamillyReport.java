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
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.StringDateManipulation;
import manager.reporterManager.employeeProfileReportManager.EmployeeProfileReportManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeFamillyReport extends AbstractPageBean {

    private ArrayList<EmployeeFamilyReportList> listOfEmployeeEducationDate = new ArrayList<EmployeeFamilyReportList>();
     private ArrayList<EmployeeFamilyReportList> listOfEmployeeFamily = new ArrayList<EmployeeFamilyReportList>();
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
    private DefaultTableDataModel dataTable2Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model1() {
        return dataTable2Model1;
    }

    public void setDataTable2Model1(DefaultTableDataModel dtdm) {
        this.dataTable2Model1 = dtdm;
    }
    private HtmlDataTable dataTable2 = new HtmlDataTable();

    public HtmlDataTable getDataTable2() {
        return dataTable2;
    }

    public void setDataTable2(HtmlDataTable hdt) {
        this.dataTable2 = hdt;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeFamillyReport() {
    }

    public ArrayList<EmployeeFamilyReportList> getListOfEmployeeEducationDate() {
        return listOfEmployeeEducationDate;
    }

    public void setListOfEmployeeEducationDate(ArrayList<EmployeeFamilyReportList> listOfEmployeeEducationDate) {
        this.listOfEmployeeEducationDate = listOfEmployeeEducationDate;
    }

    public class EmployeeFamilyReportList {

        private String employeeId;
        private String employeeName;
        private String familyName;
        private String familyRelation;
        private String familyAge;
        private String familyDateOfBirth;
        private String familyGender;
        private String familyIsAlive;

        public EmployeeFamilyReportList(
                String employeeId,
                String employeeName,
                String familyName,
                String familyRelation,
                String familyAge,
                String familyDateOfBirth,
                String familyGender,
                String familyIsAlive) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.familyName = familyName;
            this.familyRelation = familyRelation;
            this.familyAge = familyAge;
            this.familyDateOfBirth = familyDateOfBirth;
            this.familyGender = familyGender;
            this.familyIsAlive = familyIsAlive;
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

        public String getFamilyDateOfBirth() {
            return familyDateOfBirth;
        }

        public void setFamilyDateOfBirth(String familyDateOfBirth) {
            this.familyDateOfBirth = familyDateOfBirth;
        }

        public String getFamilyIsAlive() {
            return familyIsAlive;
        }

        public void setFamilyIsAlive(String familyIsAlive) {
            this.familyIsAlive = familyIsAlive;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public String getFamilyRelation() {
            return familyRelation;
        }

        public void setFamilyRelation(String familyRelation) {
            this.familyRelation = familyRelation;
        }

        public String getFamilyGender() {
            return familyGender;
        }

        public void setFamilyGender(String familyGender) {
            this.familyGender = familyGender;
        }

        public String getFamilyAge() {
            return familyAge;
        }

        public void setFamilyAge(String familyAge) {
            this.familyAge = familyAge;
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
            String famillyAge = null;
            EmployeeProfileReportManager profileReportManager = new EmployeeProfileReportManager();
            ArrayList<HashMap> listOfEmployeeEduca = profileReportManager.selectEmployeeFamily();
            for (HashMap hm : listOfEmployeeEduca) {
                if (HRValidation.validateData(hm.get("DATE_OF_BIRTH"), HRValidation.DATE_PATTERN, true) == 0) {
                    famillyAge = GregorianCalendarManipulation.getDuration(
                            StringDateManipulation.getMonth(hm.get("DATE_OF_BIRTH").toString()),
                            StringDateManipulation.getDate(hm.get("DATE_OF_BIRTH").toString()),
                            StringDateManipulation.getYear(hm.get("DATE_OF_BIRTH").toString()));
                } else if (HRValidation.validateRequired(hm.get("DATE_OF_BIRTH"))) {
                    famillyAge = hm.get("DATE_OF_BIRTH").toString();
                } else {
                    famillyAge = "unknown";
                }
                EmployeeFamilyReportList employeeReportList = new EmployeeFamilyReportList(
                        hm.get("EMP_ID").toString(),
                        hm.get("FULLNAME").toString(),
                        hm.get("FAMILYFULLNAME").toString(),
                        hm.get("RELATION_TYPE").toString(),
                        famillyAge,
                        hm.get("DATE_OF_BIRTH").toString(),
                        hm.get("SEX").toString(),
                        hm.get("ALIVE_OR_DIED").toString());
                getListOfEmployeeFamily().add(employeeReportList);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<EmployeeFamilyReportList> getListOfEmployeeFamily() {
        return listOfEmployeeFamily;
    }

    public void setListOfEmployeeFamily(ArrayList<EmployeeFamilyReportList> listOfEmployeeFamily) {
        this.listOfEmployeeFamily = listOfEmployeeFamily;
    }


}

