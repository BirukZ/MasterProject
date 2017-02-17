/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.ReportCritera;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import manager.ReportCritera.ReportCriteraManager;
import manager.ReportCritera.ReportCriteraManager.ReportPageModle;
import com.sun.webui.jsf.model.Option;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ReportPageRegistration extends AbstractPageBean {
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
    private HtmlCommandButton btn_Save = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Save() {
        return btn_Save;
    }

    public void setBtn_Save(HtmlCommandButton hcb) {
        this.btn_Save = hcb;
    }
    private HtmlCommandButton btn_Reset = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Reset() {
        return btn_Reset;
    }

    public void setBtn_Reset(HtmlCommandButton hcb) {
        this.btn_Reset = hcb;
    }
    private HtmlCommandButton btn_Add_Table = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Add_Table() {
        return btn_Add_Table;
    }

    public void setBtn_Add_Table(HtmlCommandButton hcb) {
        this.btn_Add_Table = hcb;
    }
    private HtmlDataTable dataTable1_Report_Page = new HtmlDataTable();

    public HtmlDataTable getDataTable1_Report_Page() {
        return dataTable1_Report_Page;
    }

    public void setDataTable1_Report_Page(HtmlDataTable hdt) {
        this.dataTable1_Report_Page = hdt;
    }
    private HtmlInputText txt_Report_Id = new HtmlInputText();

    public HtmlInputText getTxt_Report_Id() {
        return txt_Report_Id;
    }

    public void setTxt_Report_Id(HtmlInputText hit) {
        this.txt_Report_Id = hit;
    }
    private HtmlInputText txt_Report_Name = new HtmlInputText();

    public HtmlInputText getTxt_Report_Name() {
        return txt_Report_Name;
    }

    public void setTxt_Report_Name(HtmlInputText hit) {
        this.txt_Report_Name = hit;
    }
    private HtmlInputTextarea txt_Description = new HtmlInputTextarea();

    public HtmlInputTextarea getTxt_Description() {
        return txt_Description;
    }

    public void setTxt_Description(HtmlInputTextarea hit) {
        this.txt_Description = hit;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }
    
    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drl_catagori = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_catagori() {
        return drl_catagori;
    }

    public void setDrl_catagori(HtmlSelectOneMenu hsom) {
        this.drl_catagori = hsom;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ReportPageRegistration() {
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
        reportPageList=reportManger.getAllPenaltyTypes();
       reportCatagori = reportManger.getReportCatagori();
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
    ReportCriteraManager reportManger=new ReportCriteraManager();
    ArrayList<ReportPageModle> reportPageList=new ArrayList<ReportPageModle>();
    ArrayList<Option> reportCatagori = new ArrayList<Option>();//
     public String reportPageID;
     public String reportPageName;
     public String reportpageDescription;
     public String moduleName;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public ArrayList<Option> getReportCatagori() {
        return reportCatagori;
    }

    public void setReportCatagori(ArrayList<Option> reportCatagori) {
        this.reportCatagori = reportCatagori;
    }

    public String getReportPageID() {
        return reportPageID;
    }

    public void setReportPageID(String reportPageID) {
        this.reportPageID = reportPageID;
    }

    public String getReportPageName() {
        return reportPageName;
    }

    public void setReportPageName(String reportPageName) {
        this.reportPageName = reportPageName;
    }

    public String getReportpageDescription() {
        return reportpageDescription;
    }

    public void setReportpageDescription(String reportpageDescription) {
        this.reportpageDescription = reportpageDescription;
    }
     
    public ArrayList<ReportPageModle> getReportPageList() {
        return reportPageList;
    }

    public void setReportPageList(ArrayList<ReportPageModle> reportPageList) {
        this.reportPageList = reportPageList;
    }
     public void clearReportPageComponenents(){
     txt_Report_Id.resetValue();
     txt_Report_Name.resetValue();
     txt_Description.resetValue();
     }

       public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btn_Save_action() {
      if (reportManger.savePenaltyType(reportPageList)){
            clearReportPageComponenents();
            reportPageList = reportManger.getAllPenaltyTypes();
          
           showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
        } else {
            showSuccessOrFailureMessage(false, "! SORRRY SAVING FAILED");
        }
        return null;
    }


     public String btnClosePopupSuccessOrFailure_action(){
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btn_Add_Table_action() {
        
        reportPageID=txt_Report_Id.getValue().toString();
        reportPageName=txt_Report_Name.getValue().toString();
        reportpageDescription=txt_Description.getValue().toString();
        moduleName=drl_catagori.getValue().toString();
        String status="New";
        reportPageList.add(new ReportPageModle(status,moduleName,reportPageID,reportPageName,reportpageDescription));
        return null;
    }

    public String cmdReportCritera_action() {
        //return null means stay on the same page
        return "ReportCritera";
    }

    public String btn_Reset_action() {
        drl_catagori.resetValue();
        txt_Report_Id.resetValue();
        txt_Report_Name.resetValue();
        txt_Description.resetValue();
        return null;
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

}

