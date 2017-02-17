/*
 * PowerDelegationReport.java
 *
 * Created on Jul 16, 2012, 8:54:53 PM
 * Copyright Biruk
 */
package fphrms.PowerDeligation;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import java.util.ArrayList;
import java.util.HashMap;
import manager.powerDeligationManager.PowerDelegationModel;

import manager.powerDeligationManager.PowerDelegationReportManager;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PowerDelegationRequestFinalReport extends AbstractPageBean {
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
    public PowerDelegationRequestFinalReport() {
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
            log("PowerDelegationReport Initialization Failure", e);
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
        populatePowerDelegationRequestTableComponents();
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
     ArrayList<PowerDelegationModel> powerDelegationRequestModel= new ArrayList<PowerDelegationModel>();
    String requesterID;
    String requesterFullName;
    String requesterPosition;
    String requesterDepartment;
    String requesterRank;
    String delegateID;
    String delegateFullName;
    String delegatePosition;
    String delegateDepartment;
    String delegateRank;
    String delegatedPosition;
    String delegatedRank;
    String delegatedSatrtDay;
    String delegateEndDay;
    String delegationReasoun;
    String delegatorId;
    String delegatorFullName;
    String delegatorDepartment;
    String delegatorPosition;
    String delegatorRank;

 PowerDelegationReportManager powerRequestReport=new PowerDelegationReportManager();

    public ArrayList<PowerDelegationModel> getPowerDelegationRequestModel() {
        return powerDelegationRequestModel;
    }

    public void setPowerDelegationRequestModel(ArrayList<PowerDelegationModel> powerDelegationRequestModel) {
        this.powerDelegationRequestModel = powerDelegationRequestModel;
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

    public String getDelegatorPosition() {
        return delegatorPosition;
    }

    public void setDelegatorPosition(String delegatorPosition) {
        this.delegatorPosition = delegatorPosition;
    }

    public String getDelegatorRank() {
        return delegatorRank;
    }

    public void setDelegatorRank(String delegatorRank) {
        this.delegatorRank = delegatorRank;
    }

    public String getDelegateDepartment() {
        return delegateDepartment;
    }

    public void setDelegateDepartment(String delegateDepartment) {
        this.delegateDepartment = delegateDepartment;
    }

    public String getDelegateEndDay() {
        return delegateEndDay;
    }

    public void setDelegateEndDay(String delegateEndDay) {
        this.delegateEndDay = delegateEndDay;
    }

    public String getDelegateFullName() {
        return delegateFullName;
    }

    public void setDelegateFullName(String delegateFullName) {
        this.delegateFullName = delegateFullName;
    }

    public String getDelegateID() {
        return delegateID;
    }

    public void setDelegateID(String delegateID) {
        this.delegateID = delegateID;
    }

    public String getDelegatePosition() {
        return delegatePosition;
    }

    public void setDelegatePosition(String delegatePosition) {
        this.delegatePosition = delegatePosition;
    }

    public String getDelegateRank() {
        return delegateRank;
    }

    public void setDelegateRank(String delegateRank) {
        this.delegateRank = delegateRank;
    }

    public String getDelegatedPosition() {
        return delegatedPosition;
    }

    public void setDelegatedPosition(String delegatedPosition) {
        this.delegatedPosition = delegatedPosition;
    }

    public String getDelegatedRank() {
        return delegatedRank;
    }

    public void setDelegatedRank(String delegatedRank) {
        this.delegatedRank = delegatedRank;
    }

    public String getDelegatedSatrtDay() {
        return delegatedSatrtDay;
    }

    public void setDelegatedSatrtDay(String delegatedSatrtDay) {
        this.delegatedSatrtDay = delegatedSatrtDay;
    }

    public String getDelegationReasoun() {
        return delegationReasoun;
    }

    public void setDelegationReasoun(String delegationReasoun) {
        this.delegationReasoun = delegationReasoun;
    }

    public String getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(String requesterDepartment) {
        this.requesterDepartment = requesterDepartment;
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

    public String getRequesterRank() {
        return requesterRank;
    }

    public void setRequesterRank(String requesterRank) {
        this.requesterRank = requesterRank;
    }

     private boolean populatePowerDelegationRequestTableComponents() {
         int tableSize;
         ArrayList<HashMap> disciplineHashMap = powerRequestReport.getRequestReportList();
        if (disciplineHashMap != null) {
            tableSize = 0;
         // disciplineReport.clear();
            for (HashMap hmDl : disciplineHashMap) {
                //requesterId = educatRequestId;
                requesterID = hmDl.get("requester_ID").toString();
                requesterFullName = hmDl.get("requester_first_name").toString()+""+hmDl.get("requester_midleName").toString()+""+hmDl.get("requester_last_name").toString();
                requesterRank = hmDl.get("requester_rank").toString();
                requesterDepartment = hmDl.get("requester_department_Name").toString();
                requesterPosition = hmDl.get("requester_job").toString();
                delegateFullName = hmDl.get("Delegate_First_Name").toString()+""+hmDl.get("Delegate_Middle_Name").toString()+""+hmDl.get("Delegate_Last_Name").toString();
                delegateID = hmDl.get("delegateID").toString();
                delegatePosition = hmDl.get("delegete_position").toString();
                delegateDepartment = hmDl.get("delegete_Department").toString();
                delegateRank=hmDl.get("delegateRank").toString();
                delegatorId=hmDl.get("DelegatorID").toString();
                delegatorFullName=hmDl.get("DelegatorFirst_Name").toString()+""+hmDl.get("Delegator_Middle_Name").toString()+""+hmDl.get("Delegator_last_Name").toString();
                delegatorDepartment=hmDl.get("Delegator_Department").toString();
                delegatorPosition=hmDl.get("Delegator_JobTitle").toString();
                delegatorRank=hmDl.get("delegatorRank").toString();
               // delegatedSatrtDay=hmDl.get("end_date").toString();
                delegatedSatrtDay = hmDl.get("start_date").toString();
                delegateEndDay = hmDl.get("end_date").toString();
                delegatedPosition = hmDl.get("Delegator_JobTitle").toString();
                delegatedRank=hmDl.get("delegatorRank").toString();
                delegationReasoun = hmDl.get("deligation_reason").toString();
                powerDelegationRequestModel.add(new PowerDelegationModel(requesterID,requesterFullName,requesterDepartment,requesterPosition,requesterRank,delegateFullName,delegateID,delegatePosition,delegateDepartment,delegateRank,delegatedSatrtDay,delegateEndDay,delegatedPosition,delegatedRank,delegationReasoun,delegatorId,delegatorFullName,delegatorDepartment,delegatorPosition,delegatorRank));
                tableSize++;
                    }
            return true;
        } else {

            return false;
        }
    }


}

