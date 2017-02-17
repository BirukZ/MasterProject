/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.pageSecurity;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import javax.faces.FacesException;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import manager.userManagement.SiteSecurityManager;
import fphrms.Report.MainReport;
import fphrms.EmployeeHistory.EvaluationResultPage;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ResetPassword extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private PanelCollapsible panelCollapsible2 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible2() {
        return panelCollapsible2;
    }

    public void setPanelCollapsible2(PanelCollapsible pc) {
        this.panelCollapsible2 = pc;
    }
    private HtmlInputText txtUserName = new HtmlInputText();

    public HtmlInputText getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(HtmlInputText hit) {
        this.txtUserName = hit;
    }
    private HtmlInputText txtAnswerToQuestion = new HtmlInputText();

    public HtmlInputText getTxtAnswerToQuestion() {
        return txtAnswerToQuestion;
    }

    public void setTxtAnswerToQuestion(HtmlInputText hit) {
        this.txtAnswerToQuestion = hit;
    }
    private HtmlOutputText staticSecurityQuestion = new HtmlOutputText();

    public HtmlOutputText getStaticSecurityQuestion() {
        return staticSecurityQuestion;
    }

    public void setStaticSecurityQuestion(HtmlOutputText hot) {
        this.staticSecurityQuestion = hot;
    }
    private HtmlInputSecret txtNewUserPassword = new HtmlInputSecret();

    public HtmlInputSecret getTxtNewUserPassword() {
        return txtNewUserPassword;
    }

    public void setTxtNewUserPassword(HtmlInputSecret his) {
        this.txtNewUserPassword = his;
    }
    private HtmlInputSecret txtRetypedUserPassword = new HtmlInputSecret();

    public HtmlInputSecret getTxtRetypedUserPassword() {
        return txtRetypedUserPassword;
    }

    public void setTxtRetypedUserPassword(HtmlInputSecret his) {
        this.txtRetypedUserPassword = his;
    }
    private HtmlOutputLabel alertPasswordChangeStatus = new HtmlOutputLabel();

    public HtmlOutputLabel getAlertPasswordChangeStatus() {
        return alertPasswordChangeStatus;
    }

    public void setAlertPasswordChangeStatus(HtmlOutputLabel hol) {
        this.alertPasswordChangeStatus = hol;
    }
    private PanelLayout panelLayoutInserUserName = new PanelLayout();

    public PanelLayout getPanelLayoutInserUserName() {
        return panelLayoutInserUserName;
    }

    public void setPanelLayoutInserUserName(PanelLayout pl) {
        this.panelLayoutInserUserName = pl;
    }
    private PanelLayout panelLayoutAnswerSeqQuestion = new PanelLayout();

    public PanelLayout getPanelLayoutAnswerSeqQuestion() {
        return panelLayoutAnswerSeqQuestion;
    }

    public void setPanelLayoutAnswerSeqQuestion(PanelLayout pl) {
        this.panelLayoutAnswerSeqQuestion = pl;
    }
    private PanelLayout panelLayoutINserNewPassWord = new PanelLayout();

    public PanelLayout getPanelLayoutINserNewPassWord() {
        return panelLayoutINserNewPassWord;
    }

    public void setPanelLayoutINserNewPassWord(PanelLayout pl) {
        this.panelLayoutINserNewPassWord = pl;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ResetPassword() {
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
            log("Page1 Initialization Failure", e);
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
    public void prerender() {
        messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
        txtUserName.setRequiredMessage(messageResource.getString("requiredMsg"));
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }
    ResourceBundle messageResource = null;
    FacesContext context = null;

    public void panelBorder1north_processMyEvent(DragEvent de) {
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String btnGetUserQuestion_action() {
        String userName = (String) this.txtUserName.getValue();
        FacesContext _context = FacesContext.getCurrentInstance();
        // gets the user security question
        Map<String, String> userQuestion = SiteSecurityManager.getUserSecurityQuestion(userName);
        // if the user is not valid and user information is not found  i.e.
        // the security question is not found with the provided user name ->
        // show a message
        if (userQuestion.get("userFound").equalsIgnoreCase("false")) {
            FacesMessage userNameNotAvailable = new FacesMessage("User name " +
                    "you provided is not valid. Please enter the user name again");
            _context.addMessage(null, userNameNotAvailable);
            return null;
        } // else ask for the answer of the security question
        else {
            this.panelLayoutInserUserName.setRendered(false);
            this.panelLayoutINserNewPassWord.setRendered(false);
            this.panelLayoutAnswerSeqQuestion.setRendered(true);
//            this.tabSetPasswordWizard.setSelected(this.tabSecurityQuestion.getId());
            this.staticSecurityQuestion.setValue(userQuestion.get("securityQuestion"));
            HttpServletRequest httpReq = (HttpServletRequest) _context.getExternalContext().getRequest();
            httpReq.getSession().setAttribute("userNameForPasswordReset", userName);
            // case name where null will return to the same page.
            return null;
        }
    }

    public String btnCheckUserAnswer_action() {
        FacesContext _context = FacesContext.getCurrentInstance();
        HttpServletRequest httpReq = (HttpServletRequest) _context.getExternalContext().getRequest();
        String userName = (String) httpReq.getSession().getAttribute("userNameForPasswordReset");
        String answerTouestion = (String) this.txtAnswerToQuestion.getValue();
        // check answer provided by the user
        boolean _isUserAnswerCorrect = SiteSecurityManager.isUserAnswerCorrect(userName, answerTouestion);
        // if the answer is not correct -> show message
        if (!_isUserAnswerCorrect) {
            FacesMessage answerNotCorrect = new FacesMessage("The answer you" +
                    " provided is not correct. Please try again");
            _context.addMessage(null, answerNotCorrect);
            // case name where null will return to the same page.
            return null;
        } else {
            this.panelLayoutInserUserName.setRendered(false);
            this.panelLayoutAnswerSeqQuestion.setRendered(false);
            this.panelLayoutINserNewPassWord.setRendered(true);
//            this.tabSetPasswordWizard.setSelected(this.tabResetPassword.getId());
            // case name where null will return to the same page.
            return null;
        }
    }

    public String btnResetUserPassword_action() {
        FacesContext _context = FacesContext.getCurrentInstance();
        HttpServletRequest httpReq = (HttpServletRequest) _context.getExternalContext().getRequest();
        String userName = (String) httpReq.getSession().getAttribute("userNameForPasswordReset");
        String newPassword = (String) this.txtNewUserPassword.getValue();
        String newPasswordRetyped = (String) this.txtRetypedUserPassword.getValue();
        // if the user name is null -> show message
        if (userName == null) {
            // navigation case name where null will return to the same page.
            FacesMessage userNameNotProvided = new FacesMessage("User name " +
                    "not provided correctly. Please try again");
            _context.addMessage(null, userNameNotProvided);
            return null;
        // if the new password and the retyped password(confirmation) are the same
        } else if (newPassword.compareTo(newPasswordRetyped) == 0) {
//            this.tabUserName.setRendered(false);
//            this.tabSecurityQuestion.setRendered(false);
//            this.tabResetPassword.setRendered(false);
//            this.tabSetPasswordWizard.setSelected(this.tabProcessCompleted.getId());
//            this.tabProcessCompleted.setRendered(true);
            // logout the user by invalidating the session
         //   if (httpReq.getSession(false) != null) {
         //       httpReq.getSession(false).invalidate();
          //  }
            // update user information  i.e. change the new password
            if (SiteSecurityManager.updateUser(userName, userName, newPassword)) {
                alertPasswordChangeStatus.setValue("The password was changed for the user name " + userName + " successfully");
//                this.btnExitWizard.setRendered(true);
            } else {
                alertPasswordChangeStatus.setValue("An error occurred while trying to changed the password for user name " + userName);
//                this.btnBackToWizard.setRendered(true);
            }
            // case name where null will return to the same page.
            return "Home";
        }// if the new password and confirmation password are not the same
        else {
            FacesMessage passwordsDontMatch = new FacesMessage("The passwords you" +
                    " provided do not match. Please try again");
            _context.addMessage(null, passwordsDontMatch);
            // case name where null will return to the same page.
            return null;
        }
    }

  
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
    }



}

