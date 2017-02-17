/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlForm;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGrid;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panelborder.PanelBorder;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ComplaintPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        pnlColByEmployee.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnlColByEmployee_processAction(ae);
            }
        });
        pnl_col_byImmediateBoss.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnl_col_byImmediateBoss_processAction(ae);
            }
        });
        pnl_col_byHR.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnl_col_byHR_processAction(ae);
            }
        });
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }

    private HtmlSelectOneRadio rbtnSex = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRbtnSex() {
        return rbtnSex;
    }

    public void setRbtnSex(HtmlSelectOneRadio hsor) {
        this.rbtnSex = hsor;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems5() {
        return selectOneRadio1DefaultItems5;
    }

    public void setSelectOneRadio1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems6() {
        return selectOneRadio1DefaultItems6;
    }

    public void setSelectOneRadio1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems6 = dsia;
    }
    private HtmlPanelGroup commonTasksGroup_header2 = new HtmlPanelGroup();

    public HtmlPanelGroup getCommonTasksGroup_header2() {
        return commonTasksGroup_header2;
    }

    public void setCommonTasksGroup_header2(HtmlPanelGroup hpg) {
        this.commonTasksGroup_header2 = hpg;
    }
    private PanelCollapsible pnl_col_Common_Tasks3 = new PanelCollapsible();

    public PanelCollapsible getPnl_col_Common_Tasks3() {
        return pnl_col_Common_Tasks3;
    }

    public void setPnl_col_Common_Tasks3(PanelCollapsible pc) {
        this.pnl_col_Common_Tasks3 = pc;
    }
    private HtmlPanelGroup leaveRequest2 = new HtmlPanelGroup();

    public HtmlPanelGroup getLeaveRequest2() {
        return leaveRequest2;
    }

    public void setLeaveRequest2(HtmlPanelGroup hpg) {
        this.leaveRequest2 = hpg;
    }
    private HtmlOutputText otxtHeader2 = new HtmlOutputText();

    public HtmlOutputText getOtxtHeader2() {
        return otxtHeader2;
    }

    public void setOtxtHeader2(HtmlOutputText hot) {
        this.otxtHeader2 = hot;
    }
    private PanelCollapsible pnlColByEmployee = new PanelCollapsible();

    public PanelCollapsible getPnlColByEmployee() {
        return pnlColByEmployee;
    }

    public void setPnlColByEmployee(PanelCollapsible pc) {
        this.pnlColByEmployee = pc;
    }
    private PanelCollapsible pnl_col_byImmediateBoss = new PanelCollapsible();

    public PanelCollapsible getPnl_col_byImmediateBoss() {
        return pnl_col_byImmediateBoss;
    }

    public void setPnl_col_byImmediateBoss(PanelCollapsible pc) {
        this.pnl_col_byImmediateBoss = pc;
    }
    private PanelCollapsible pnl_col_byHR = new PanelCollapsible();

    public PanelCollapsible getPnl_col_byHR() {
        return pnl_col_byHR;
    }

    public void setPnl_col_byHR(PanelCollapsible pc) {
        this.pnl_col_byHR = pc;
    }
    private HtmlPanelGroup pgByEmpHeader = new HtmlPanelGroup();

    public HtmlPanelGroup getPgByEmpHeader() {
        return pgByEmpHeader;
    }

    public void setPgByEmpHeader(HtmlPanelGroup hpg) {
        this.pgByEmpHeader = hpg;
    }
    private HtmlPanelGrid pgByEmp = new HtmlPanelGrid();

    public HtmlPanelGrid getPgByEmp() {
        return pgByEmp;
    }

    public void setPgByEmp(HtmlPanelGrid hpg) {
        this.pgByEmp = hpg;
    }
    private HtmlPanelGroup pgByIBossHeader = new HtmlPanelGroup();

    public HtmlPanelGroup getPgByIBossHeader() {
        return pgByIBossHeader;
    }

    public void setPgByIBossHeader(HtmlPanelGroup hpg) {
        this.pgByIBossHeader = hpg;
    }
    private HtmlPanelGrid pgByIBoss = new HtmlPanelGrid();

    public HtmlPanelGrid getPgByIBoss() {
        return pgByIBoss;
    }

    public void setPgByIBoss(HtmlPanelGrid hpg) {
        this.pgByIBoss = hpg;
    }
    private HtmlPanelGroup pgByHrHeader = new HtmlPanelGroup();

    public HtmlPanelGroup getPgByHrHeader() {
        return pgByHrHeader;
    }

    public void setPgByHrHeader(HtmlPanelGroup hpg) {
        this.pgByHrHeader = hpg;
    }
    private HtmlPanelGrid pgByHr = new HtmlPanelGrid();

    public HtmlPanelGrid getPgByHr() {
        return pgByHr;
    }

    public void setPgByHr(HtmlPanelGrid hpg) {
        this.pgByHr = hpg;
    }
    private HtmlForm form1 = new HtmlForm();

    public HtmlForm getForm1() {
        return form1;
    }

    public void setForm1(HtmlForm hf) {
        this.form1 = hf;
    }
    private UISelectItems somiEmpId = new UISelectItems();

    public UISelectItems getSomiEmpId() {
        return somiEmpId;
    }

    public void setSomiEmpId(UISelectItems uisi) {
        this.somiEmpId = uisi;
    }
    private UISelectItems selectOneMenu1selectItems1 = new UISelectItems();

    public UISelectItems getSelectOneMenu1selectItems1() {
        return selectOneMenu1selectItems1;
    }

    public void setSelectOneMenu1selectItems1(UISelectItems uisi) {
        this.selectOneMenu1selectItems1 = uisi;
    }
    private UISelectItems soim = new UISelectItems();

    public UISelectItems getSoim() {
        return soim;
    }

    public void setSoim(UISelectItems uisi) {
        this.soim = uisi;
    }
    private UISelectItems somiTeamMembId = new UISelectItems();

    public UISelectItems getSomiTeamMembId() {
        return somiTeamMembId;
    }

    public void setSomiTeamMembId(UISelectItems uisi) {
        this.somiTeamMembId = uisi;
    }
    private UISelectItems somiTeamMember2Id = new UISelectItems();

    public UISelectItems getSomiTeamMember2Id() {
        return somiTeamMember2Id;
    }

    public void setSomiTeamMember2Id(UISelectItems uisi) {
        this.somiTeamMember2Id = uisi;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems = dsia;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ComplaintPage() {
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

    public void pnlColByEmployee_processAction(ActionEvent ae) {
        this.pnl_col_byImmediateBoss.setExpanded(false);
        this.pnl_col_byHR.setExpanded(false);
    }

    public void pnl_col_byImmediateBoss_processAction(ActionEvent ae) {
        this.pnlColByEmployee.setExpanded(false);
        this.pnl_col_byHR.setExpanded(false);
    }

    public void pnl_col_byHR_processAction(ActionEvent ae) {
        this.pnlColByEmployee.setExpanded(false);
        this.pnl_col_byImmediateBoss.setExpanded(false);
    }
}

