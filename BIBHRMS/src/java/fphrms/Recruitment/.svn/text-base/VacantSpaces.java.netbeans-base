/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fphrms.Recruitment;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import javax.faces.FacesException;
import manager.recruitmentManager.InitiateManager;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version VacantSpaces.java
 * @version Created on Feb 4, 2011, 6:50:56 AM
 * @author kibrom
 */
public class VacantSpaces extends AbstractPageBean {

    private InitiateManager initiateManager = new InitiateManager();
    private ArrayList<InitiateManager> initiateManagerlist = new ArrayList<InitiateManager>();
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        if (!isPostBack()) {
            initiateManagerlist = initiateManager.readVacanceSpaces();
        }
        initiateManager = new InitiateManager();
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlDataTable tblInitiateReq = new HtmlDataTable();

    public HtmlDataTable getTblInitiateReq() {
        return tblInitiateReq;
    }

    public void setTblInitiateReq(HtmlDataTable hdt) {
        this.tblInitiateReq = hdt;
    }
    private RowSelector rowSelector = new RowSelector();

    public RowSelector getRowSelector() {
        return rowSelector;
    }

    public void setRowSelector(RowSelector rs) {
        this.rowSelector = rs;
    }
    private HtmlOutputLabel lblDisDepartment = new HtmlOutputLabel();

    public HtmlOutputLabel getLblDisDepartment() {
        return lblDisDepartment;
    }

    public void setLblDisDepartment(HtmlOutputLabel hol) {
        this.lblDisDepartment = hol;
    }
     private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    private HtmlOutputLabel lblDislblJob = new HtmlOutputLabel();

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

    public HtmlOutputLabel getLblDislblJob() {
        return lblDislblJob;
    }

    public void setLblDislblJob(HtmlOutputLabel hol) {
        this.lblDislblJob = hol;
    }
    private HtmlOutputLabel lblDisRequirednum = new HtmlOutputLabel();

    public HtmlOutputLabel getLblDisRequirednum() {
        return lblDisRequirednum;
    }

    public void setLblDisRequirednum(HtmlOutputLabel hol) {
        this.lblDisRequirednum = hol;
    }
    private HtmlOutputLabel lblDisTotalNumOfEmployee = new HtmlOutputLabel();

    public HtmlOutputLabel getLblDisTotalNumOfEmployee() {
        return lblDisTotalNumOfEmployee;
    }

    public void setLblDisTotalNumOfEmployee(HtmlOutputLabel hol) {
        this.lblDisTotalNumOfEmployee = hol;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public VacantSpaces() {
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
        initiateManagerlist = initiateManager.readVacanceSpaces();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page2 Initialization Failure", e);
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    public ArrayList<InitiateManager> getInitiateManagerlist() {
        return initiateManagerlist;
    }

    public void setInitiateManagerlist(ArrayList<InitiateManager> initiateManagerlist) {
        this.initiateManagerlist = initiateManagerlist;
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

    public void page_display_processMyEvent(DragEvent de) {
    }

    /**
     * @return the initiateManager
     */
    public InitiateManager getInitiateManager() {
        return initiateManager;
    }

    /**
     * @param initiateManager the initiateManager to set
     */
    public void setInitiateManager(InitiateManager initiateManager) {
        this.initiateManager = initiateManager;
    }

// </editor-fold>
    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
        lblDisDepartment.setValue(getInitiateManagerlist().get(selectedRowIndex).getDepartmentName());
        lblDislblJob.setValue(getInitiateManagerlist().get(selectedRowIndex).getJobName());
        lblDisTotalNumOfEmployee.setValue(getInitiateManagerlist().get(selectedRowIndex).getNumberOfEmp());
        lblDisRequirednum.setValue(getInitiateManagerlist().get(selectedRowIndex).getRequiredNumber());
        getSessionBean1().setInitiateManager(getInitiateManagerlist().get(selectedRowIndex));
    }

    public String btnInitiateRec1_action() {

        return "RequirementRequest";

    }

    public String cmdRecruitment_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdRecruitmentApproval_action() {
        //return null means stay on the same page
        return "InternalVacancyList";
    }

    public String cmdVacancyNotice_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdFilterCandidates_action() {
        //return null means stay on the same page
        return "FilterCandidates";
    }

    public String cmdRegisterCandidate_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }
      public String cmdVacantSpaces_action() {
      //return null means stay on the same page
      return "RecruitmentApprove";
    }
}