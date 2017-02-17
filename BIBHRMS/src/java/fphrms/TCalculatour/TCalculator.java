/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.TCalculatour;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import javax.faces.FacesException;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TCalculator extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlInputText txt_ParOne = new HtmlInputText();

    public HtmlInputText getTxt_ParOne() {
        return txt_ParOne;
    }

    public void setTxt_ParOne(HtmlInputText hit) {
        this.txt_ParOne = hit;
    }
    private HtmlInputText txt_parTwo = new HtmlInputText();

    public HtmlInputText getTxt_parTwo() {
        return txt_parTwo;
    }

    public void setTxt_parTwo(HtmlInputText hit) {
        this.txt_parTwo = hit;
    }
    private HtmlInputText txt_MeanuOne = new HtmlInputText();

    public HtmlInputText getTxt_MeanuOne() {
        return txt_MeanuOne;
    }

    public void setTxt_MeanuOne(HtmlInputText hit) {
        this.txt_MeanuOne = hit;
    }
    private HtmlInputText txt_MeanuTwo = new HtmlInputText();

    public HtmlInputText getTxt_MeanuTwo() {
        return txt_MeanuTwo;
    }

    public void setTxt_MeanuTwo(HtmlInputText hit) {
        this.txt_MeanuTwo = hit;
    }
    private HtmlInputText txt_SDOne = new HtmlInputText();

    public HtmlInputText getTxt_SDOne() {
        return txt_SDOne;
    }

    public void setTxt_SDOne(HtmlInputText hit) {
        this.txt_SDOne = hit;
    }
    private HtmlInputText txt_SDTwo = new HtmlInputText();

    public HtmlInputText getTxt_SDTwo() {
        return txt_SDTwo;
    }

    public void setTxt_SDTwo(HtmlInputText hit) {
        this.txt_SDTwo = hit;
    }
    private HtmlOutputText out_txt_TValue = new HtmlOutputText();

    public HtmlOutputText getOut_txt_TValue() {
        return out_txt_TValue;
    }

    public void setOut_txt_TValue(HtmlOutputText hot) {
        this.out_txt_TValue = hot;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TCalculator() {
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
            log("Page2 Initialization Failure", e);
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

    public void page_display_processMyEvent(DragEvent de) {
    }

   public String button1_action() {
        //return null means stay on the same page
        int participantOne;
        int participantTwo;
        double meanuOne;
        double meanuTwo;
        double sdOne;
        double sdOneSquare;
        double sdtwosquare;
        double sdTwo;
        double meanuDiffrence;
        double sdmultione;
        double sdmultiTwo;
        double partisum;
        double partMulti;
        double partiSub;
        double tValue;
        double sumTotla;
        double diffrenSDPart;
        double differparticipant;
        double squResult;
        double squarLastResult;

        participantOne = Integer.parseInt(txt_ParOne.getValue().toString());
        participantTwo = Integer.parseInt(txt_parTwo.getValue().toString());
        meanuOne = Double.parseDouble(txt_MeanuOne.getValue().toString());
        meanuTwo = Double.parseDouble(txt_MeanuTwo.getValue().toString());
        sdOne = Double.parseDouble(txt_SDOne.getValue().toString());
        sdTwo = Double.parseDouble(txt_SDTwo.getValue().toString());

        meanuDiffrence = (meanuOne - meanuTwo);
        sdOneSquare = sdOne * sdOne;
        sdtwosquare = sdTwo * sdTwo;

        sdmultione = (participantOne - 1) * sdOneSquare;

        sdmultiTwo = (participantTwo - 1) * sdtwosquare;

        partiSub = (participantOne + (participantTwo - 2));

        partisum = (participantOne + participantTwo);

        partMulti = participantOne * participantTwo;

        sumTotla = sdmultione + sdmultiTwo;

        diffrenSDPart = (sumTotla / partiSub);


        differparticipant = (partisum / partMulti);

        squResult = (diffrenSDPart * differparticipant);
        squarLastResult = Math.sqrt(squResult);


        tValue = meanuDiffrence / squarLastResult;

        out_txt_TValue.setValue(tValue);


        return null;
    }

   public String button2_action() {
        txt_MeanuOne.resetValue();
        txt_MeanuTwo.resetValue();
        txt_ParOne.resetValue();
        txt_parTwo.resetValue();
        txt_SDOne.resetValue();
        txt_SDTwo.resetValue();
        out_txt_TValue.setValue(null);
        //return null means stay on the same page
        return null;
    }

}

