/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.pageSecurity;

import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import fphrms.*;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.util.*;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Login extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest httpReq = (HttpServletRequest) context.getExternalContext().getRequest();
        httpReq.getSession().setAttribute("userName", null);
        httpReq.getSession().setAttribute("password", null);
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    private HashMap<String, Locale> locales = null;
    private HtmlInputSecret txtPassword = new HtmlInputSecret();

    public HtmlInputSecret getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(HtmlInputSecret his) {
        this.txtPassword = his;
    }
    private HtmlInputText txtUserName = new HtmlInputText();

    public HtmlInputText getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(HtmlInputText hit) {
        this.txtUserName = hit;
    }
    private HtmlCommandLink hlkForgotYourPassword = new HtmlCommandLink();

    public HtmlCommandLink getHlkForgotYourPassword() {
        return hlkForgotYourPassword;
    }

    public void setHlkForgotYourPassword(HtmlCommandLink hcl) {
        this.hlkForgotYourPassword = hcl;
    }
    private HtmlCommandLink hlkHelp = new HtmlCommandLink();

    public HtmlCommandLink getHlkHelp() {
        return hlkHelp;
    }

    public void setHlkHelp(HtmlCommandLink hcl) {
        this.hlkHelp = hcl;
    }
    private HtmlCommandLink hlkHome = new HtmlCommandLink();

    public HtmlCommandLink getHlkHome() {
        return hlkHome;
    }

    public void setHlkHome(HtmlCommandLink hcl) {
        this.hlkHome = hcl;
    }

    public Login() {
        locales = new HashMap<String, Locale>(2);
        locales.put("english", new Locale("en", "US"));
        locales.put("amharic", new Locale("am", "ET"));

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
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest httpReq = (HttpServletRequest) context.getExternalContext().getRequest();
        httpReq.getSession().setAttribute("userName", null);
        httpReq.getSession().setAttribute("password", null);
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
        messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
        txtUserName.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtPassword.setRequiredMessage(messageResource.getString("requiredMsg"));
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

    public String am_action() {
        // TODO: Replace with your code
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        viewRoot.setLocale(new Locale("am"));
        return "chooseLocale";
    }

    public String lnkEn_action() {
        //return null means stay on the same page

        return null;
    }

    public void amharic_processAction(javax.faces.event.ActionEvent ae) {
        String current = ae.getComponent().getId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale((Locale) locales.get(current));
    }

    public String amharic_action() {
        //return null means stay on the same page
//          UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
//        viewRoot.setLocale(new Locale("am"));
        return null;
    }

    public void english_processAction(javax.faces.event.ActionEvent ae) {
        String current = ae.getComponent().getId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale((Locale) locales.get(current));
    }

    public String btnLogin_action() throws Exception{

        getSessionBean1().setUserName(getTxtUserName().getValue().toString());
        getSessionBean1().setPassword(getTxtPassword().getValue().toString());

        FacesContext context = FacesContext.getCurrentInstance();

        HttpServletRequest httpReq = (HttpServletRequest) context.getExternalContext().getRequest();
        httpReq.getSession().setAttribute("userName", getTxtUserName().getValue().toString());
        httpReq.getSession().setAttribute("password", getTxtPassword().getValue().toString());

        return "login";

    }

    public void txtUserName_validate(FacesContext context, UIComponent component, Object value) {
        String pattern = "^[a-zA-Z0-9\\_\\/\\@]+$|^[ሃ-ፖ0-9\\_\\/\\@]";
        boolean matchFound = Pattern.matches(pattern, (CharSequence) (value.toString()));
        if (matchFound == false) {
            ResourceBundle rb = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            String messS = rb.getString("errorUserName");
            error(component, messS);
            ((UIInput) component).setValid(false);
        }
    }

    public void txtPassword_validate(FacesContext context, UIComponent component, Object value) {
        String pattern = "^[a-zA-Z0-9\\_\\/\\@]+$|^[ሃ-ፖ0-9\\_\\/\\@]";
        boolean matchFound = Pattern.matches(pattern, (CharSequence) (value.toString()));
        if (matchFound == false) {
            ResourceBundle rb = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            String messS = rb.getString("errorPassword");
            error(component, messS);
            ((UIInput) component).setValid(false);
        }
    }

    public String hlkForgotYourPassword_action() {
        //return null means stay on the same page
        return "Admin";
    }

    public String hlkHome_action() {
        //return null means stay on the same page
        return "Home";
    }
      public String hlkForgotyourpassword_action() {
        //return null means stay on the same page
        return "resetPassword";
    }


}

