/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import java.util.HashMap;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Header.java
 * @version Created on Mar 8, 2010, 1:00:47 AM
 * @author DPClone
 */
public class Header extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HashMap<String, Locale> locales = null;
    private HtmlCommandLink lnkSignOut = new HtmlCommandLink();

    public HtmlCommandLink getLnkSignOut() {
        return lnkSignOut;
    }

    public void setLnkSignOut(HtmlCommandLink hcl) {
        this.lnkSignOut = hcl;
    }
    private HtmlCommandLink lnkAccountSetting = new HtmlCommandLink();

    public HtmlCommandLink getLnkAccountSetting() {
        return lnkAccountSetting;
    }

    public void setLnkAccountSetting(HtmlCommandLink hcl) {
        this.lnkAccountSetting = hcl;
    }
    private HtmlCommandLink lnkHelp = new HtmlCommandLink();

    public HtmlCommandLink getLnkHelp() {
        return lnkHelp;
    }

    public void setLnkHelp(HtmlCommandLink hcl) {
        this.lnkHelp = hcl;
    }
    private HtmlCommandLink cmdEmployee_Profile = new HtmlCommandLink();

    public HtmlCommandLink getCmdEmployee_Profile() {
        return cmdEmployee_Profile;
    }

    public void setCmdEmployee_Profile(HtmlCommandLink hcl) {
        this.cmdEmployee_Profile = hcl;
    }
    private HtmlCommandLink cmdOrganizationStructure = new HtmlCommandLink();

    public HtmlCommandLink getCmdOrganizationStructure() {
        return cmdOrganizationStructure;
    }

    public void setCmdOrganizationStructure(HtmlCommandLink hcl) {
        this.cmdOrganizationStructure = hcl;
    }
    private HtmlOutputText lblLoginUser = new HtmlOutputText();

    public HtmlOutputText getLblLoginUser() {
        return lblLoginUser;
    }

    public void setLblLoginUser(HtmlOutputText hot) {
        this.lblLoginUser = hot;
    }

    public Header() {
        locales = new HashMap<String, Locale>(2);
        locales.put("english", new Locale("en", "US"));
        locales.put("amharic", new Locale("am", "ET"));
    }

    /**
     * <p>Callback method that is called whenever a page containing
     * this page fragment is navigated to, either directly via a URL,
     * or indirectly via page navigation.  Override this method to acquire
     * resources that will be needed for event handlers and lifecycle methods.</p>
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here


        // <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
            try {
                if (getSessionBean1().getEmployeeId().equals(null)) {
                    lblLoginUser.setValue("Welcome Back Guest");
                    lnkSignOut.setValue("LogIn");

                } else {
                    lblLoginUser.setValue("Welcome Back " + getSessionBean1().getEmployeeName());
                    lnkSignOut.setValue("LogOut");
                }
            } catch (Exception ex) {
                lblLoginUser.setValue("Welcome Back Guest");
                lnkSignOut.setValue("LogIn");
            }

        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called.  Override this
     * method to release resources acquired in the <code>init()</code>
     * resources that will be needed for event handlers and lifecycle methods.</p>
     *
     * <p>The default implementation does nothing.</p>
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

    public String lnkHome_action() {
        return "Home";
    }

    public String lnkSignOut_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest httpReq = (HttpServletRequest) context.getExternalContext().getRequest();
        getSessionBean1().destroy();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "Home";
    }

    public String lnkSignIn_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "Login";
    }

    public String hyperlink3_action() {
        Home home = new Home();
        Home.isLoged = false;
        home.getPnlLogin().setRendered(true);
        return "Home";
    }

    public void amharic_processAction(ActionEvent ae) {
        String current = ae.getComponent().getId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale((Locale) locales.get(current));
    }

    public void english_processAction(ActionEvent ae) {
        String current = ae.getComponent().getId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale((Locale) locales.get(current));
    }

    public String lnkTerminationRequest_action() {
        //return null means stay on the same page
        return "Terminationrequest";
    }

    public String lnkAdmin_action() {
        //return null means stay on the same page
        return "Admin";
    }

    public String lnkTransferRequest_action() {
        return "TransferRequest";
    }

    public String lnkPromotion_action() {
        return "RequestForPromotion";
    }

    public String lnkTrainner_action() {
        //return null means stay on the same page
        return "Trainner";
    }

    public String lnkTrainingRequest_action() {
        //return null means stay on the same page
        return "TrainingRequest";
    }

    public String lnkTrainingApproval_action() {
        //return null means stay on the same page
        return "TrainingApprove";
    }

    public String lnkTerminationApproval_action() {
        //return null means stay on the same page
        return "TerminationApproval";
    }

    public String lnkTerminationClearance_action() {
        //return null means stay on the same page
        return "TerminationClearance";
    }

    public String cmdEmployee_Profile_action() {
        //return null means stay on the same page
        return "EmployeeProfile";
    }

    public String cmdOrganizationStructure_action() {
        //return null means stay on the same page
        return "OrganizationStructure";
    }

    public String amharicLa_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdJobType_action() {
        //return null means stay on the same page
        return "JobType";
    }

    public String cmdRecruitmentRequest_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdRecruitmentApproval_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String recruitmentRequestList_action() {
        //return null means stay on the same page
        return "ApprovedRecruitmentList";
    }

    public String cmdMaintainAdvertisement_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdFilterCandidates_action() {
        //return null means stay on the same page
        return "FilterCandidates";
    }

    public String cmdCandidatesPage_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }

    public String lnkSalaryDelegationRequestAndApprove_action() {
        //return null means stay on the same page
        return "SalaryDelegationRequest";
    }

    public String lnkEmployeeAttendance_action() {
        //return null means stay on the same page
        return "Attendance";
    }

    public String lnkLeaveApprove_action() {
        //return null means stay on the same page
        return "LeaveApprove";
    }

    public String lnkLeaveRequest_action() {
        //return null means stay on the same page
        return "LeaveRequest";
    }
}
