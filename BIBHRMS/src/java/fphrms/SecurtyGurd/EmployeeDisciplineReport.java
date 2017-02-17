/*
 * EmployeeDisciplineReport.java
 *
 * Created on Jul 12, 2012, 7:07:00 PM
 * Copyright Biruk
 */
package fphrms.SecurtyGurd;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.HashMap;
import manager.securityGuardManager.SecurityGurdModel;
import manager.securityGuardManager.DiciplineMnager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeDisciplineReport extends AbstractPageBean {
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
    public EmployeeDisciplineReport() {
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
        //populateCourseTableComponents();

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
    DiciplineMnager reportManager = new DiciplineMnager();
    ArrayList<SecurityGurdModel> disciplineReport = new ArrayList<SecurityGurdModel>();
    String month;
    int counter;
    String requesterID;
    String requesterFullName;
    String requestrDepartment;
    String requesterPosition;
    String offenderID;
    String offenderFullName;
    String offenderDepartment;
    String offenderPosition;
    String disciplineHappenDay;
    String disciplineType;
    String disciplineReportDay;
    String disciplineDescripition;
    String offenderInterset;
    String requesterEyewitnessInside;
    String requesterEyewitnessOutSide;
    String problemSeenBy;
    String commiteeCommentes;
    String requesterInterset;
    String lastApprovedPenality;
    String approvedDeduction;
    String approvedDuration;
    String approvedDate;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRequesterInterset() {
        return requesterInterset;
    }

    public void setRequesterInterset(String requesterInterset) {
        this.requesterInterset = requesterInterset;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<SecurityGurdModel> getDisciplineReport() {
        return disciplineReport;
    }

    public void setDisciplineReport(ArrayList<SecurityGurdModel> disciplineReport) {
        this.disciplineReport = disciplineReport;
    }

    public DiciplineMnager getReportManager() {
        return reportManager;
    }

    public void setReportManager(DiciplineMnager reportManager) {
        this.reportManager = reportManager;
    }

    public String getApprovedDeduction() {
        return approvedDeduction;
    }

    public void setApprovedDeduction(String approvedDeduction) {
        this.approvedDeduction = approvedDeduction;
    }

    public String getApprovedDuration() {
        return approvedDuration;
    }

    public void setApprovedDuration(String approvedDuration) {
        this.approvedDuration = approvedDuration;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getCommiteeCommentes() {
        return commiteeCommentes;
    }

    public void setCommiteeCommentes(String commiteeCommentes) {
        this.commiteeCommentes = commiteeCommentes;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getDisciplineDescripition() {
        return disciplineDescripition;
    }

    public void setDisciplineDescripition(String disciplineDescripition) {
        this.disciplineDescripition = disciplineDescripition;
    }

    public String getDisciplineHappenDay() {
        return disciplineHappenDay;
    }

    public void setDisciplineHappenDay(String disciplineHappenDay) {
        this.disciplineHappenDay = disciplineHappenDay;
    }

    public String getDisciplineReportDay() {
        return disciplineReportDay;
    }

    public void setDisciplineReportDay(String disciplineReportDay) {
        this.disciplineReportDay = disciplineReportDay;
    }

    public String getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(String disciplineType) {
        this.disciplineType = disciplineType;
    }

    public String getLastApprovedPenality() {
        return lastApprovedPenality;
    }

    public void setLastApprovedPenality(String lastApprovedPenality) {
        this.lastApprovedPenality = lastApprovedPenality;
    }

    public String getOffenderDepartment() {
        return offenderDepartment;
    }

    public void setOffenderDepartment(String offenderDepartment) {
        this.offenderDepartment = offenderDepartment;
    }

    public String getOffenderFullName() {
        return offenderFullName;
    }

    public void setOffenderFullName(String offenderFullName) {
        this.offenderFullName = offenderFullName;
    }

    public String getOffenderID() {
        return offenderID;
    }

    public void setOffenderID(String offenderID) {
        this.offenderID = offenderID;
    }

    public String getOffenderInterset() {
        return offenderInterset;
    }

    public void setOffenderInterset(String offenderInterset) {
        this.offenderInterset = offenderInterset;
    }

    public String getOffenderPosition() {
        return offenderPosition;
    }

    public void setOffenderPosition(String offenderPosition) {
        this.offenderPosition = offenderPosition;
    }

    public String getProblemSeenBy() {
        return problemSeenBy;
    }

    public void setProblemSeenBy(String problemSeenBy) {
        this.problemSeenBy = problemSeenBy;
    }

    public String getRequesterEyewitnessInside() {
        return requesterEyewitnessInside;
    }

    public void setRequesterEyewitnessInside(String requesterEyewitnessInside) {
        this.requesterEyewitnessInside = requesterEyewitnessInside;
    }

    public String getRequesterEyewitnessOutSide() {
        return requesterEyewitnessOutSide;
    }

    public void setRequesterEyewitnessOutSide(String requesterEyewitnessOutSide) {
        this.requesterEyewitnessOutSide = requesterEyewitnessOutSide;
    }

    public String getRequesterFullName() {
        return requesterFullName;
    }

    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public String getRequesterPosition() {
        return requesterPosition;
    }

    public void setRequesterPosition(String requesterPosition) {
        this.requesterPosition = requesterPosition;
    }

    public String getRequestrDepartment() {
        return requestrDepartment;
    }

    public void setRequestrDepartment(String requestrDepartment) {
        this.requestrDepartment = requestrDepartment;
    }

    private boolean populateCourseTableComponents() {
        int tableSize;
        ArrayList<HashMap> disciplineHashMap = reportManager.getDisciplineInfo();
        if (disciplineHashMap != null) {
            tableSize = 0;
            // disciplineReport.clear();
            for (HashMap hmDl : disciplineHashMap) {
                offenderID = hmDl.get("Offender_ID").toString();
                offenderFullName = hmDl.get("Offender_First_Name").toString() + "" + hmDl.get("OffenderMiddle_Name").toString() + "" + hmDl.get("OffenderLast_Name").toString();
                offenderPosition = hmDl.get("Offender_JobTitle").toString();
                offenderDepartment = hmDl.get("Offender_Department").toString();
                lastApprovedPenality = hmDl.get("approved_penality").toString();
                approvedDate = hmDl.get("approvedDate").toString();
                disciplineReport.add(new SecurityGurdModel(offenderID, offenderFullName, offenderPosition, offenderDepartment, lastApprovedPenality, approvedDate));
                tableSize++;
            }
            return true;
        } else {

            return false;
        }
    }
}

