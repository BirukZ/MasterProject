/*
 * ClearedReport.java
 *
 * Created on Jul 17, 2012, 4:39:43 AM
 * Copyright MekaneHiwot Fisseha
 */
package fphrms.SecurtyGurd;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.util.ArrayList;
import java.util.HashMap;
import manager.securityGuardManager.SecurityGurdModel;
import manager.securityGuardManager.terminatedManger;
import fphrms.PowerDeligation.PowerDelegationRequestFinalReport;
import fphrms.PowerDeligation.PowerDelegationApproveReport;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ClearedReport extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ClearedReport() {
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
            log("ClearanceReport Initialization Failure", e);
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
        populateCleranceTableComponents();
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

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<SecurityGurdModel> getCleranceList() {
        return cleranceList;
    }

    public void setCleranceList(ArrayList<SecurityGurdModel> cleranceList) {
        this.cleranceList = cleranceList;
    }

    

    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClearedDate() {
        return clearedDate;
    }

    public void setClearedDate(String clearedDate) {
        this.clearedDate = clearedDate;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getFinishedUnfin() {
        return finishedUnfin;
    }

    public void setFinishedUnfin(String finishedUnfin) {
        this.finishedUnfin = finishedUnfin;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getReasonOfTermination() {
        return reasonOfTermination;
    }

    public void setReasonOfTermination(String reasonOfTermination) {
        this.reasonOfTermination = reasonOfTermination;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getTerminationAcceptan() {
        return terminationAcceptan;
    }

    public void setTerminationAcceptan(String terminationAcceptan) {
        this.terminationAcceptan = terminationAcceptan;
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
    terminatedManger cleranceReportManager = new terminatedManger();
    ArrayList<SecurityGurdModel> cleranceList = new ArrayList<SecurityGurdModel>();
    String reqId;
    String reqName;
    String sex;
    int age;
    double salary;
    String departement;
    String rank;
    String educLevel;
    String postion;
    String reqDate;
    String reasonOfTermination;
    String terminationAcceptan;
    String clearedDate;
    String finishedUnfin;
    int tableSize;

    private boolean populateCleranceTableComponents() {
        // int tableSize;
        ArrayList<HashMap> empInfoHashMap = cleranceReportManager.getcleranceReport();
        if (empInfoHashMap != null) {
            tableSize = 0;
            getCleranceList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                //requesterId = educatRequestId;
                reqId = hmTc.get("emp_id").toString();
                reqName = hmTc.get("ClerName").toString();
                sex = hmTc.get("sex").toString();
                age = Integer.valueOf(hmTc.get("AGE").toString());
                
                departement = hmTc.get("department_name").toString();
                postion = hmTc.get("job_description").toString();
                
                terminationAcceptan = hmTc.get("CLEARED_DATE").toString();///not get
                //clearedDate = hmTc.get("final_cleared_date").toString();
                //finishedUnfin = hmTc.get("clearance_status").toString();
                if(hmTc.get("final_cleared_date").toString().equalsIgnoreCase("0")){
                clearedDate="Not Finilized";

                }
                else{
                clearedDate = hmTc.get("final_cleared_date").toString();
                }
                if(hmTc.get("clearance_status").toString().equalsIgnoreCase("0")){
                finishedUnfin="Not Finilized";

                }
                else{
                finishedUnfin = "Finilized";
                }
                cleranceList.add(new SecurityGurdModel(reqId, reqName, sex, age,  departement, postion, terminationAcceptan,clearedDate, finishedUnfin));
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

