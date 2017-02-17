/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.DailyWorker;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.dailyWorkerManager.DailyWorkerAttendanceApproveManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ApproveDailyWorkerAttendancePage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<DailyWorkerModelLoad> dailyWorkerAttendanceModelLoad = new ArrayList<DailyWorkerModelLoad>();
    private ArrayList<SelectItem> monthlyAttendanceProcessed = new ArrayList<SelectItem>();
    private ArrayList<Option> listOfDecision = new ArrayList<Option>();
    private DailyWorkerAttendanceApproveManager dailyAttendanceAppManager = null;

    public ArrayList<Option> getListOfDecision() {
        return listOfDecision;
    }

    public void setListOfDecision(ArrayList<Option> listOfDecision) {
        this.listOfDecision = listOfDecision;
    }

    public ArrayList<SelectItem> getMonthlyAttendanceProcessed() {
        return monthlyAttendanceProcessed;
    }

    public void setMonthlyAttendanceProcessed(ArrayList<SelectItem> monthlyAttendanceProcessed) {
        this.monthlyAttendanceProcessed = monthlyAttendanceProcessed;
    }

    public ArrayList<DailyWorkerModelLoad> getDailyWorkerAttendanceModelLoad() {
        return dailyWorkerAttendanceModelLoad;
    }

    public void setDailyWorkerAttendanceModelLoad(ArrayList<DailyWorkerModelLoad> dailyWorkerAttendanceModelLoad) {
        this.dailyWorkerAttendanceModelLoad = dailyWorkerAttendanceModelLoad;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

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
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlOutputText lblDecider_Department = new HtmlOutputText();

    public HtmlOutputText getLblDecider_Department() {
        return lblDecider_Department;
    }

    public void setLblDecider_Department(HtmlOutputText hot) {
        this.lblDecider_Department = hot;
    }
    private HtmlOutputText lblEmployeeFullName = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeFullName() {
        return lblEmployeeFullName;
    }

    public void setLblEmployeeFullName(HtmlOutputText hot) {
        this.lblEmployeeFullName = hot;
    }
    private HtmlOutputText lblDeciderPosition = new HtmlOutputText();

    public HtmlOutputText getLblDeciderPosition() {
        return lblDeciderPosition;
    }

    public void setLblDeciderPosition(HtmlOutputText hot) {
        this.lblDeciderPosition = hot;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
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
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ApproveDailyWorkerAttendancePage() {
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
        checkObject();
        setMonthlyAttendanceProcessed(dailyAttendanceAppManager.getMonthList());
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

    public static class DailyWorkerModelLoad implements Serializable {

        private String dailyWorkerId;
        private String dailyWorkerFullName;
        private String presentAmount;
        private String month;
        private boolean selected;

        public String getDailyWorkerFullName() {
            return dailyWorkerFullName;
        }

        public void setDailyWorkerFullName(String dailyWorkerFullName) {
            this.dailyWorkerFullName = dailyWorkerFullName;
        }

        public String getDailyWorkerId() {
            return dailyWorkerId;
        }

        public void setDailyWorkerId(String dailyWorkerId) {
            this.dailyWorkerId = dailyWorkerId;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getPresentAmount() {
            return presentAmount;
        }

        public void setPresentAmount(String presentAmount) {
            this.presentAmount = presentAmount;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public DailyWorkerModelLoad(String dailyWorkerId, String dailyWorkerFullName, String presentAmount, String month, boolean selected) {
            this.dailyWorkerId = dailyWorkerId;
            this.dailyWorkerFullName = dailyWorkerFullName;
            this.presentAmount = presentAmount;
            this.month = month;
            this.selected = selected;
        }
    }

    private void checkObject() {
        if (dailyAttendanceAppManager == null) {
            dailyAttendanceAppManager = new DailyWorkerAttendanceApproveManager();
        }
    }

    public void lstDestionToMade_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
//                setListOfDecision(null);
                loadAbsentEmployeeByUserSelection(vce.getNewValue().toString());

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadAbsentEmployeeByUserSelection(String month) {
        try {
            checkObject();
            ArrayList<HashMap> lsitOfEmployeeAbset = dailyAttendanceAppManager.getListOfDailyWorkerAttendace(month);
            getDailyWorkerAttendanceModelLoad().clear();
            if (lsitOfEmployeeAbset.size() > 0) {
                setListOfDecision(dailyAttendanceAppManager.getAvailableDecisionsToMake(getSessionBean1().getUserName()));
                for (HashMap hm : lsitOfEmployeeAbset) {
                    getDailyWorkerAttendanceModelLoad().add(new DailyWorkerModelLoad(
                            hm.get("EmployeeId").toString(),
                            hm.get("Full_Name").toString(),
                            hm.get("Absent_Amount").toString(),
                            hm.get("Month").toString(),
                            false));

                }
            } else {
                showSuccessOrFailureMessage(false, "No attendance information found.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {
        //return null means stay on the same page
        return null;
    }
}

