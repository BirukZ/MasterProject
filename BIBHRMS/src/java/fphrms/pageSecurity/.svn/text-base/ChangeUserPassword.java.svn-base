/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright Leta
 */
package fphrms.pageSecurity;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlForm;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
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
public class ChangeUserPassword extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest httpReq = (HttpServletRequest) context.getExternalContext().getRequest();

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
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlInputSecret pwdOldpassword = new HtmlInputSecret();

    public HtmlInputSecret getPwdOldpassword() {
        return pwdOldpassword;
    }

    public void setPwdOldpassword(HtmlInputSecret his) {
        this.pwdOldpassword = his;
    }
    private HtmlInputSecret pwdNewPassword = new HtmlInputSecret();

    public HtmlInputSecret getPwdNewPassword() {
        return pwdNewPassword;
    }

    public void setPwdNewPassword(HtmlInputSecret his) {
        this.pwdNewPassword = his;
    }
    private HtmlOutputText staticTextAvalability = new HtmlOutputText();

    public HtmlOutputText getStaticTextAvalability() {
        return staticTextAvalability;
    }

    public void setStaticTextAvalability(HtmlOutputText hot) {
        this.staticTextAvalability = hot;
    }
    private PanelLayout panelNewUser = new PanelLayout();

    public PanelLayout getPanelNewUser() {
        return panelNewUser;
    }

    public void setPanelNewUser(PanelLayout pl) {
        this.panelNewUser = pl;
    }
    private HtmlInputText txtNewUser = new HtmlInputText();

    public HtmlInputText getTxtNewUser() {
        return txtNewUser;
    }

    public void setTxtNewUser(HtmlInputText hit) {
        this.txtNewUser = hit;
    }
    private HtmlForm form1 = new HtmlForm();

    public HtmlForm getForm1() {
        return form1;
    }

    public void setForm1(HtmlForm hf) {
        this.form1 = hf;
    }
    private HtmlInputText txtUserName = new HtmlInputText();

    public HtmlInputText getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(HtmlInputText hit) {
        this.txtUserName = hit;
    }
    private HtmlInputSecret pwdNewPasswordRetyped = new HtmlInputSecret();

    public HtmlInputSecret getPwdNewPasswordRetyped() {
        return pwdNewPasswordRetyped;
    }

    public void setPwdNewPasswordRetyped(HtmlInputSecret his) {
        this.pwdNewPasswordRetyped = his;
    }
    private HtmlSelectOneMenu ddSecurityQuestion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdSecurityQuestion() {
        return ddSecurityQuestion;
    }

    public void setDdSecurityQuestion(HtmlSelectOneMenu hsom) {
        this.ddSecurityQuestion = hsom;
    }
    private HtmlInputText txtAnswerToQuestion = new HtmlInputText();

    public HtmlInputText getTxtAnswerToQuestion() {
        return txtAnswerToQuestion;
    }

    public void setTxtAnswerToQuestion(HtmlInputText hit) {
        this.txtAnswerToQuestion = hit;
    }
    private String userNameCheckcompleteMsg;

    public String getUserNameCheckcompleteMsg() {
        return userNameCheckcompleteMsg;
    }

    public void setUserNameCheckcompleteMsg(String completedMsg) {
        this.userNameCheckcompleteMsg = completedMsg;
    }
    ArrayList<SelectItem> sequrityQuestions = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getSequrityQuestions() {
        return siteSecurityManager.getSecurityQuestionList();
    }

    public void setSequrityQuestions(ArrayList<SelectItem> sequrityQuestions) {
        this.sequrityQuestions = sequrityQuestions;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private HtmlSelectBooleanCheckbox chkChangeUsername = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkChangeUsername() {
        return chkChangeUsername;
    }

    public void setChkChangeUsername(HtmlSelectBooleanCheckbox hsbc) {
        this.chkChangeUsername = hsbc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ChangeUserPassword() {
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
        txtUserName.setValue(httpReq.getSession().getAttribute("userName"));
        txtUserName.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtNewUser.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtAnswerToQuestion.setRequiredMessage(messageResource.getString("requiredMsg"));
        ddSecurityQuestion.setRequiredMessage(messageResource.getString("requiredMsg"));
        pwdOldpassword.setRequiredMessage(messageResource.getString("requiredMsg"));
        pwdNewPassword.setRequiredMessage(messageResource.getString("requiredMsg"));
        pwdNewPasswordRetyped.setRequiredMessage(messageResource.getString("requiredMsg"));
    // dpdEmployee.setRequiredMessage(messageResource.getString("requiredMsg"));
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
//    FacesContext context = null;

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

    public void chkChangeUsername_processValueChange(ValueChangeEvent vce) {
        //set the rendered property according to the state of the checkbox
        this.panelNewUser.setRendered(((Boolean) vce.getNewValue()).booleanValue());
        // and if the checkbox is unchecked then set the value of the newUser
        // textfield to null.
        if (!((Boolean) vce.getNewValue()).booleanValue()) {
//            form1.discardSubmittedValue(txtNewUser);
            txtNewUser.setValue(null);// we dont need the textfield value anymore
        }
    }

    public String btnSavePasswordChange_action() {

        String userName = txtUserName.getValue().toString();
        String password = (String) pwdOldpassword.getValue().toString();
        String newPassword = (String) pwdNewPassword.getValue().toString();
        String newPasswordRetyped = (String) pwdNewPasswordRetyped.getValue();
        String newUserName = null;
        int firstTimeAccess = 1;
        int securityQuestionId = -1;

        String answerToSecurityQuestion = null;
        if ((httpReq.getSession().getAttribute("firstTimeFlag")) != null) {
            firstTimeAccess = (Integer) httpReq.getSession().getAttribute("firstTimeFlag");
        }
        if (this.ddSecurityQuestion.getValue() != null) {
            securityQuestionId = Integer.parseInt(String.valueOf(this.ddSecurityQuestion.getValue()));
            answerToSecurityQuestion = (String) this.txtAnswerToQuestion.getValue();
        }
        //if the old user name and password provided are not valid -> show a faces
        //message
        if (!siteSecurityManager.isValidUser(userName, password)) {
            FacesMessage notValidUserAccount = new FacesMessage("Either the user " +
                    "name or password is not Correct. Please enter a valid account information");
            context.addMessage(null, notValidUserAccount);
            return null;
        }// else if the new password and the confrimation to the new password are
        //not the same -> then show a faces message
        else if (newPassword.compareTo(newPasswordRetyped) != 0) {
            FacesMessage passwordsDontMatch = new FacesMessage("The new passwords you" +
                    " provided do not match. Please try again");
            context.addMessage(null, passwordsDontMatch);
            return null;
        }// user is valid and new password comfirmation is correct
        else {
            if (chkChangeUsername.isSelected()) {
                if (txtNewUser.getValue() != null) {
                    newUserName = (String) txtNewUser.getValue().toString();
                    // if the new username provided is already used by the user ->
                    // show a faces message

                    if (siteSecurityManager.isUserNameUsed(newUserName)) {
                        FacesMessage userNameInUse = new FacesMessage("The new " +
                                "username you provided is already in user by another" +
                                " user. Please select a different username");
                        context.addMessage(null, userNameInUse);
                        return null;
                    }
                }
            } else {
                newUserName = (String) txtUserName.getValue().toString();
            }
            // if the user wants to change the user name and provided the new
            //user name

            // if the above validity checks are ok then update the user information
            boolean updateSuccess = SiteSecurityManager.updateUserInformation(userName, newUserName,
                    newPassword, securityQuestionId, answerToSecurityQuestion, firstTimeAccess);
            if (updateSuccess) {
                //   confirmationMessage.setValue("User information updated successfully");
                lblFormMessage.setStyle("color: #336600; font-weight: bold; left: 380px; top: -30px; position: absolute; width: 584px");
                lblFormMessage.setValue("User information updated successfully");
                //if the user is using the old user name then set the session attribute
                // to the old user name
                if (newUserName.equalsIgnoreCase("")) {
                    httpReq.getSession().setAttribute("userName", userName);
                } //else if the user is changing the user name then set the session
                //attribute to the new user name
                else {
                    httpReq.getSession().setAttribute("userName", newUserName);
                }
                // sets the new password to the session attribute
                httpReq.getSession().setAttribute("password", newPassword);

                return "Home";
            } else {
                //       confirmationMessage.setValue("The update process has encountered a problem. " +
                //     "Please try again");
                lblFormMessage.setStyle("color: red; font-weight: bold; left: 380px; top: -30px; position: absolute; width: 584px");
                lblFormMessage.setValue("The update process has encountered a problem.Please try again");
                return null;
            }

        }
    }

    public String btnCheckUserAvail_action_action() {
        String userName = (String) txtNewUser.getValue();
        checkUserAvailability(userName);
        return null;
    }
    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();

    /**
     * This method checks if the new username provided is already used by
     * another user or not.
     * @param _newUserName the new username provided by the user
     * @return <b>true</b> if the new username is already in use by another user,
     * <b>false</b> otherwise
     */
    boolean checkUserAvailability(String _newUserName) {
        boolean usernameUsed = siteSecurityManager.isUserNameUsed(_newUserName);
        if (usernameUsed) {
            setUserNameCheckcompleteMsg("Sorry the user name " + _newUserName + " is already used");
        } else {
            setUserNameCheckcompleteMsg(_newUserName + " is available");
        }
        return usernameUsed;
    }

    public void ddSecurityQuestion_processValueChange(ValueChangeEvent vce) {
    }

    public void ddSecurityQuestion_validate(FacesContext context, UIComponent component, Object value) {
    }

    public void txtUserName_validate(FacesContext context, UIComponent component, Object value) {
        String pattern = "^[a-zA-Z\\_\\/\\@]+$|^[ሃ-ፖ\\_\\/\\@]";
        boolean matchFound = Pattern.matches(pattern, (CharSequence) (value.toString()));
        if (matchFound == false) {
            ResourceBundle rb = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            String messS = rb.getString("errorUserName");
            error(component, messS);
            ((UIInput) component).setValid(false);
        }
    }

    public void pwdNewPassword_validate(FacesContext context, UIComponent component, Object value) {
        String pattern = "^[a-zA-Z0-9\\_\\/\\@]+$|^[ሃ-ፖ0-9\\_\\/\\@]";
        boolean matchFound = Pattern.matches(pattern, (CharSequence) (value.toString()));
        if (matchFound == false) {
            ResourceBundle rb = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            String messS = rb.getString("errorPassword");
            error(component, messS);
            ((UIInput) component).setValid(false);
        }
    }

    public void pwdNewPasswordRetyped_validate(FacesContext context, UIComponent component, Object value) {
        String pattern = "^[a-zA-Z0-9\\_\\/\\@]+$|^[ሃ-ፖ0-9\\_\\/\\@]";
        boolean matchFound = Pattern.matches(pattern, (CharSequence) (value.toString()));
        if (matchFound == false) {
            ResourceBundle rb = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            String messS = rb.getString("errorPassword");
            error(component, messS);
            ((UIInput) component).setValid(false);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected EvaluationResultPage getEmployeeHistory$EvaluationResultPage() {
        return (EvaluationResultPage) getBean("EmployeeHistory$EvaluationResultPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected fphrms.Help.Template getHelp$Template() {
        return (fphrms.Help.Template) getBean("Help$Template");
    }

 

   
}

