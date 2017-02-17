/*
 * TerminationReport.java
 *
 * Created on Jul 16, 2012, 1:08:08 AM
 * Copyright Admin
 */
package fphrms.Termination;

import com.icesoft.faces.component.ext.ColumnGroup;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import java.util.ArrayList;
import java.util.HashMap;
import manager.terminationManager.TermiReportModel;
import manager.terminationManager.terminReportManager;
import fphrms.PowerDeligation.PowerDelegationRequestFinalReport;
import fphrms.PowerDeligation.PowerDelegationApproveReport;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TerminationReport extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private ColumnGroup columnGroup1 = new ColumnGroup();

    public ColumnGroup getColumnGroup1() {
        return columnGroup1;
    }

    public void setColumnGroup1(ColumnGroup cg) {
        this.columnGroup1 = cg;
    }
    private com.icesoft.faces.component.ext.HtmlDataTable dataTable1 = new com.icesoft.faces.component.ext.HtmlDataTable();

    public com.icesoft.faces.component.ext.HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(com.icesoft.faces.component.ext.HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TerminationReport() {
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
            log("TerminationReport Initialization Failure", e);
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

    public ArrayList<TermiReportModel> getTerminationList() {
        return TerminationList;
    }

    public void setTerminationList(ArrayList<TermiReportModel> TerminationList) {
        this.TerminationList = TerminationList;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumeentReferenceNumber() {
        return documeentReferenceNumber;
    }

    public void setDocumeentReferenceNumber(String documeentReferenceNumber) {
        this.documeentReferenceNumber = documeentReferenceNumber;
    }

    public double getPenalityPay() {
        return penalityPay;
    }

    public void setPenalityPay(double penalityPay) {
        this.penalityPay = penalityPay;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getRecorededDateAndTime() {
        return recorededDateAndTime;
    }

    public void setRecorededDateAndTime(String recorededDateAndTime) {
        this.recorededDateAndTime = recorededDateAndTime;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(String requesterType) {
        this.requesterType = requesterType;
    }

    public String getTerminationCatagory() {
        return terminationCatagory;
    }

    public void setTerminationCatagory(String terminationCatagory) {
        this.terminationCatagory = terminationCatagory;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public int getTerminationRequestId() {
        return terminationRequestId;
    }

    public void setTerminationRequestId(int terminationRequestId) {
        this.terminationRequestId = terminationRequestId;
    }

    public String getTerminationType() {
        return terminationType;
    }

    public void setTerminationType(String terminationType) {
        this.terminationType = terminationType;
    }

    public String getTerminatorId() {
        return terminatorId;
    }

    public void setTerminatorId(String terminatorId) {
        this.terminatorId = terminatorId;
    }
    terminReportManager terminationManager = new terminReportManager();
    ArrayList<TermiReportModel> TerminationList = new ArrayList<TermiReportModel>();
    int terminationRequestId;//@Column(name = "TERMINATION_REQUEST_ID")
    String requesterId;// @Column(name = "REQUESTER_ID")
    String terminationCatagory;// @Column(name = "TERMINATION_CATAGORY")
    String terminationType;// @Column(name = "TERMINATION_TYPE")
    String requestStatus;// @Column(name = "REQUEST_STATUS")
    String appliedDate;//@Column(name = "APPLIED_DATE")
    String terminationDate;//  @Column(name = "TERMINATION_DATE")
    String description;// @Column(name = "DESCRIPTION")
    String documeentReferenceNumber;//  @Column(name = "IS_DOCUMEENT_ATTACHED")
    String recordedBy;// @Column(name = "RECORDED_BY")
    String recorededDateAndTime;// @Column(name = "RECOREDED_DATE_AND_TIME")
    String requesterType;
    String terminatorId;
    double penalityPay;
    int tableSize;
    int age;
    String sex;
    String hireDate;
    String jobPostion;
    String dpartement;
    String team;
    String requesterName;
    String location;
    String reqDept;
    String reqJobTile;
    String terminId;
    String terminName;
    String termdept;
    String termJob;
    double salary;
    String terminAppdate;
    String approverId;
    String approverName;
    String approverDept;
    String decion;
    String commentGiven;
    String approvedDate;

    private boolean populateCourseTableComponents() {
        // int tableSize;
        ArrayList<HashMap> empInfoHashMap = terminationManager.getTrmination();
        if (empInfoHashMap != null) {
            tableSize = 0;
            getTerminationList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                //requesterId = educatRequestId;
                requesterId = hmTc.get("ReqID").toString();
                requesterName = hmTc.get("Requester_Name").toString();
                reqDept = hmTc.get("Requester_Department").toString();
                reqJobTile = hmTc.get("Requester_JobTitle").toString();
                appliedDate = hmTc.get("requester_appdate").toString();
                terminId = hmTc.get("TermID").toString();
                terminName = hmTc.get("Terminator_Name").toString();
                termdept = hmTc.get("Terminator_Department").toString();
                termJob = hmTc.get("Terminator_JobTitle").toString();
                age = Integer.valueOf(hmTc.get("AGE").toString());
                sex = hmTc.get("sex").toString();
                hireDate = hmTc.get("hire_date").toString();
                salary = Double.valueOf(hmTc.get("salary").toString());
                terminAppdate = hmTc.get("terminatr_appdate").toString();
                terminationDate = hmTc.get("terminationDate").toString();
                penalityPay = Double.valueOf(hmTc.get("penality_payment").toString());
                terminationCatagory = hmTc.get("termination_catagory").toString();
                terminationType = hmTc.get("termination_type").toString();
                requestStatus = hmTc.get("request_status").toString();
                approverId = hmTc.get("approver_id").toString();
                approverName = hmTc.get("Approver_Last_Name").toString();
                approverDept = hmTc.get("Approver_Department").toString();
                decion = hmTc.get("decision").toString();
                //commentGiven = hmTc.get("comment_given").toString();
                if (hmTc.get("comment_given").toString().isEmpty()==true) {
                    commentGiven = "there is No Commt";
                } else {
                    commentGiven = hmTc.get("comment_given").toString();
                }
                if(requestStatus.equalsIgnoreCase("App-84"))
                    {
                    requestStatus = "Approved";
                } else {
                    requestStatus = "Not Approved";
                }
                approvedDate = hmTc.get("ApprovedDate").toString();
                TerminationList.add(new TermiReportModel(requesterId, requesterName, reqDept, reqJobTile, appliedDate, terminId, terminName, termdept, termJob, age, sex, hireDate, salary, terminAppdate, terminationDate, penalityPay, terminationCatagory, terminationType, requestStatus, approverId, approverName, approverDept, decion, commentGiven, approvedDate));
                tableSize++;
            }
            return true;
        } else {

            return false;
        }
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PowerDelegationRequestFinalReport getPowerDeligation$PowerDelegationRequestFinalReport() {
        return (PowerDelegationRequestFinalReport) getBean("PowerDeligation$PowerDelegationRequestFinalReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PowerDelegationApproveReport getPowerDeligation$PowerDelegationApproveReport() {
        return (PowerDelegationApproveReport) getBean("PowerDeligation$PowerDelegationApproveReport");
    }
}

