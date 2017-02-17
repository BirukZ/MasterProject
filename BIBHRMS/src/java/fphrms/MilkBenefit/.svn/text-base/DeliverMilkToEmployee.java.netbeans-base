/*
 * DeliverMilkToEmployee.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.MilkBenefit;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.event.ValueChangeEvent;
import manager.MilkBenefit.EmployeeRegistrationManager;
import manager.MilkBenefit.EmployeeRegistrationManager.EmployeeMilkModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DeliverMilkToEmployee extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlInputText txtCurrentDate = new HtmlInputText();

    public HtmlInputText getTxtCurrentDate() {
        return txtCurrentDate;
    }

    public void setTxtCurrentDate(HtmlInputText hit) {
        this.txtCurrentDate = hit;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkAvailble = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkAvailble() {
        return chkAvailble;
    }

    public void setChkAvailble(HtmlSelectBooleanCheckbox hsbc) {
        this.chkAvailble = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkNotAvailab = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkNotAvailab() {
        return chkNotAvailab;
    }

    public void setChkNotAvailab(HtmlSelectBooleanCheckbox hsbc) {
        this.chkNotAvailab = hsbc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DeliverMilkToEmployee() {
    }
    EmployeeRegistrationManager employeeRegistrationManager = new EmployeeRegistrationManager();
    ArrayList<EmployeeMilkModel> employeeList = employeeRegistrationManager.getAtendedEmployeeList();
     ArrayList<Option> benefittype = employeeRegistrationManager.getType();
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
            log("Templete Initialization Failure", e);
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
          txtCurrentDate.setValue(dateFormat.format(new Date()));
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

    public ArrayList<EmployeeMilkModel> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<Option> getBenefittype() {
        return benefittype;
    }

    public void setBenefittype(ArrayList<Option> benefittype) {
        this.benefittype = benefittype;
    }

    public void setEmployeeList(ArrayList<EmployeeMilkModel> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeRegistrationManager getEmployeeRegistrationManager() {
        return employeeRegistrationManager;
    }

    public void setEmployeeRegistrationManager(EmployeeRegistrationManager employeeRegistrationManager) {
        this.employeeRegistrationManager = employeeRegistrationManager;
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

    public void rowSelector1_processAction(RowSelectorEvent rse) {
    }

    public String cmdLnkEdit1_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdLnkRemove1_action() {
        //return null means stay on the same page
        return null;
    }

    public void chkAvailble_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue().equals(true)){
        chkNotAvailab.setSelected(false);
        }
    }

    public void chkNotAvailab_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue().equals(true)){
            
        chkAvailble.setSelected(false);
        }
    }
}

