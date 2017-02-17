/*
 * BenefitReport.java
 *
 * Created on Jul 17, 2012, 1:49:15 AM
 * Copyright MekaneHiwot Fisseha
 */
package fphrms.Benefit;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.util.ArrayList;
import java.util.HashMap;
import manager.benefitManager.benefitManager;
import manager.benefitManager.benefitModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class BenefitReport extends AbstractPageBean {
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
    public BenefitReport() {
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
            log("BenefitReport Initialization Failure", e);
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
        populateBenefitTableComponents();
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

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public void setBenefitList(ArrayList<benefitModel> benefitList) {
        this.benefitList = benefitList;
    }

    public void setBenefitManagerr(benefitManager benefitManagerr) {
        this.benefitManagerr = benefitManagerr;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public ArrayList<benefitModel> getBenefitList() {
        return benefitList;
    }

    public benefitManager getBenefitManagerr() {
        return benefitManagerr;
    }

    public String getDescription() {
        return description;
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
    ArrayList<benefitModel> benefitList = new ArrayList<benefitModel>();
    benefitManager benefitManagerr = new benefitManager();
    String benefiName;
    String benefitTyppe;
    String safetyDevice;
    String moneybenefit;
    String description;
    String benefitDuration;
    String department;
    String team;
    String deptType;
    String deptQuantity;
    int tableSize;
    double amountOfMoney;

    private boolean populateBenefitTableComponents() {
        ArrayList<HashMap> empInfoHashMap = benefitManagerr.getBenefit();
        if (empInfoHashMap != null) {
            tableSize = 0;
            getBenefitList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                //requesterId = educatRequestId;
                benefiName = hmTc.get("benefit_name").toString();
                benefitTyppe = hmTc.get("benefit_value").toString();
                 safetyDevice = hmTc.get("saftey_device").toString();
                moneybenefit = hmTc.get("monetary").toString();
                description = hmTc.get("description").toString();
                benefitDuration = hmTc.get("benefit_duration").toString();
                department = hmTc.get("dep_description").toString();
                team = hmTc.get("job_description").toString();
                deptType = hmTc.get("type").toString();
                deptQuantity = hmTc.get("quantity").toString();
                amountOfMoney=Double.valueOf(hmTc.get("amount_of_birr").toString());
                benefitList.add(new benefitModel(benefiName, benefitTyppe, moneybenefit, description, benefitDuration, department, team, deptType, deptQuantity,amountOfMoney,safetyDevice));
                tableSize++;
            }
            return true;
        } else {
            return false;
        }
    }
}

