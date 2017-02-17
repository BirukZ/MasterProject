/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.ReportCritera;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import manager.ReportCritera.ReportCriteraManager;
import manager.ReportCritera.ReportCriteraManager.ReportPageModle;
import com.sun.webui.jsf.model.Option;
import control.ReportControl;
import fphrms.Discipline.DisciplineReport;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import manager.benefitManager.BenefitRequestManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.HRValidation;
import manager.recruitmentManager.JasperReport;
import manager.reporterManager.employeeProfileReportManager.EmployeeProfileReportManager;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.SimpleFileResolver;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ReportCritera extends AbstractPageBean {

    private EmployeeProfileReportManager employeeProfileReportManager = new EmployeeProfileReportManager();
    private BenefitRequestManager benefitRequestManager = new BenefitRequestManager();
    ReportControl reportControl = new ReportControl();
    //  private BenefitRequestManager benefitRequestManager=null;
    private ImageIcon LOGO;
    private byte[] empImage = null;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    public byte[] getEmpImage() {
        return empImage;
    }

    public void setEmpImage(byte[] empImage) {
        this.empImage = empImage;
    }

    public ImageIcon getLOGO() {
        return LOGO;
    }

    public void setLOGO(ImageIcon LOGO) {
        this.LOGO = LOGO;
    }
    private PanelLayout pnl_Type = new PanelLayout();

    public PanelLayout getPnl_Type() {
        return pnl_Type;
    }

    public void setPnl_Type(PanelLayout pl) {
        this.pnl_Type = pl;
    }
    private PanelLayout pnl_critera = new PanelLayout();

    public PanelLayout getPnl_critera() {
        return pnl_critera;
    }

    public void setPnl_critera(PanelLayout pl) {
        this.pnl_critera = pl;
    }
    private PanelLayout pnl_Other = new PanelLayout();

    public PanelLayout getPnl_Other() {
        return pnl_Other;
    }

    public void setPnl_Other(PanelLayout pl) {
        this.pnl_Other = pl;
    }
    private PanelLayout pnl_Btn = new PanelLayout();

    public PanelLayout getPnl_Btn() {
        return pnl_Btn;
    }

    public void setPnl_Btn(PanelLayout pl) {
        this.pnl_Btn = pl;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drl_type = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_type() {
        return drl_type;
    }

    public void setDrl_type(HtmlSelectOneMenu hsom) {
        this.drl_type = hsom;
    }
    private HtmlSelectOneMenu drl_catagory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_catagory() {
        return drl_catagory;
    }

    public void setDrl_catagory(HtmlSelectOneMenu hsom) {
        this.drl_catagory = hsom;
    }
    private HtmlSelectOneMenu drl_report_Name = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_report_Name() {
        return drl_report_Name;
    }

    public void setDrl_report_Name(HtmlSelectOneMenu hsom) {
        this.drl_report_Name = hsom;
    }
    private HtmlInputText txt_start_day = new HtmlInputText();

    public HtmlInputText getTxt_start_day() {
        return txt_start_day;
    }

    public void setTxt_start_day(HtmlInputText hit) {
        this.txt_start_day = hit;
    }
    private HtmlInputText txt_end_date = new HtmlInputText();

    public HtmlInputText getTxt_end_date() {
        return txt_end_date;
    }

    public void setTxt_end_date(HtmlInputText hit) {
        this.txt_end_date = hit;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneRadio2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio2Bean() {
        return selectOneRadio2Bean;
    }

    public void setSelectOneRadio2Bean(DefaultSelectedData dsd) {
        this.selectOneRadio2Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio2DefaultItems() {
        return selectOneRadio2DefaultItems;
    }

    public void setSelectOneRadio2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio2DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneRadio3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio3Bean() {
        return selectOneRadio3Bean;
    }

    public void setSelectOneRadio3Bean(DefaultSelectedData dsd) {
        this.selectOneRadio3Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio3DefaultItems() {
        return selectOneRadio3DefaultItems;
    }

    public void setSelectOneRadio3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio3DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneRadio4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio4Bean() {
        return selectOneRadio4Bean;
    }

    public void setSelectOneRadio4Bean(DefaultSelectedData dsd) {
        this.selectOneRadio4Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio4DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio4DefaultItems() {
        return selectOneRadio4DefaultItems;
    }

    public void setSelectOneRadio4DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio4DefaultItems = dsi;
    }
    private SelectInputDate calStartDate = new SelectInputDate();
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate calEndDate) {
        this.calEndDate = calEndDate;
    }

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate calStartDate) {
        this.calStartDate = calStartDate;
    }
    private SelectInputDateBean calStartDateBean = new SelectInputDateBean();
    private SelectInputDateBean calEndDateBean = new SelectInputDateBean();

    public SelectInputDateBean getCalEndDateBean() {
        return calEndDateBean;
    }

    public void setCalEndDateBean(SelectInputDateBean calEndDateBean) {
        this.calEndDateBean = calEndDateBean;
    }

    public SelectInputDateBean getCalStartDateBean() {
        return calStartDateBean;
    }

    public void setCalStartDateBean(SelectInputDateBean calStartDateBean) {
        this.calStartDateBean = calStartDateBean;
    }
    private HtmlCommandButton btn_Reset = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Reset() {
        return btn_Reset;
    }

    public void setBtn_Reset(HtmlCommandButton hcb) {
        this.btn_Reset = hcb;
    }
    private HtmlCommandLink cmdReportPageList = new HtmlCommandLink();

    public HtmlCommandLink getCmdReportPageList() {
        return cmdReportPageList;
    }

    public void setCmdReportPageList(HtmlCommandLink hcl) {
        this.cmdReportPageList = hcl;
    }
    private HtmlCommandButton btn_NewGenerate = new HtmlCommandButton();

    public HtmlCommandButton getBtn_NewGenerate() {
        return btn_NewGenerate;
    }

    public void setBtn_NewGenerate(HtmlCommandButton hcb) {
        this.btn_NewGenerate = hcb;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
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
    private HtmlSelectOneMenu drl_Month = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Month() {
        return drl_Month;
    }

    public void setDrl_Month(HtmlSelectOneMenu hsom) {
        this.drl_Month = hsom;
    }
    private HtmlOutputLabel outputLabel_Month = new HtmlOutputLabel();

    public HtmlOutputLabel getOutputLabel_Month() {
        return outputLabel_Month;
    }

    public void setOutputLabel_Month(HtmlOutputLabel hol) {
        this.outputLabel_Month = hol;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlSelectOneMenu drl_querterly = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_querterly() {
        return drl_querterly;
    }

    public void setDrl_querterly(HtmlSelectOneMenu hsom) {
        this.drl_querterly = hsom;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private HtmlSelectOneMenu drl_SemiAnnual = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_SemiAnnual() {
        return drl_SemiAnnual;
    }

    public void setDrl_SemiAnnual(HtmlSelectOneMenu hsom) {
        this.drl_SemiAnnual = hsom;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private HtmlSelectOneMenu drl_annual_Type = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_annual_Type() {
        return drl_annual_Type;
    }

    public void setDrl_annual_Type(HtmlSelectOneMenu hsom) {
        this.drl_annual_Type = hsom;
    }
    private HtmlOutputLabel outputLabel_annuale_type = new HtmlOutputLabel();

    public HtmlOutputLabel getOutputLabel_annuale_type() {
        return outputLabel_annuale_type;
    }

    public void setOutputLabel_annuale_type(HtmlOutputLabel hol) {
        this.outputLabel_annuale_type = hol;
    }
    private HtmlOutputLabel outputLabel_Quarterly = new HtmlOutputLabel();

    public HtmlOutputLabel getOutputLabel_Quarterly() {
        return outputLabel_Quarterly;
    }

    public void setOutputLabel_Quarterly(HtmlOutputLabel hol) {
        this.outputLabel_Quarterly = hol;
    }
    private HtmlOutputLabel outputLabel_Semiannuale = new HtmlOutputLabel();

    public HtmlOutputLabel getOutputLabel_Semiannuale() {
        return outputLabel_Semiannuale;
    }

    public void setOutputLabel_Semiannuale(HtmlOutputLabel hol) {
        this.outputLabel_Semiannuale = hol;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems7 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems7 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems9 = dsia;
    }
    private HtmlSelectOneMenu drl_BudjetYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_BudjetYear() {
        return drl_BudjetYear;
    }

    public void setDrl_BudjetYear(HtmlSelectOneMenu hsom) {
        this.drl_BudjetYear = hsom;
    }
    private HtmlOutputLabel outputLabel_BudjetYear = new HtmlOutputLabel();

    public HtmlOutputLabel getOutputLabel_BudjetYear() {
        return outputLabel_BudjetYear;
    }

    public void setOutputLabel_BudjetYear(HtmlOutputLabel hol) {
        this.outputLabel_BudjetYear = hol;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drl_BujetYear_Simiannual = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_BujetYear_Simiannual() {
        return drl_BujetYear_Simiannual;
    }

    public void setDrl_BujetYear_Simiannual(HtmlSelectOneMenu hsom) {
        this.drl_BujetYear_Simiannual = hsom;
    }
    private HtmlSelectBooleanCheckbox choAllEmployee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoAllEmployee() {
        return choAllEmployee;
    }

    public void setChoAllEmployee(HtmlSelectBooleanCheckbox hsbc) {
        this.choAllEmployee = hsbc;
    }

//    public DefaultSelectedData getDefaultSelectedData7() {
//        return defaultSelectedData7;
//    }
//
//    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
//        this.defaultSelectedData7 = dsd;
//    }
    private HtmlOutputText lblCustomizable = new HtmlOutputText();

    public HtmlOutputText getLblCustomizable() {
        return lblCustomizable;
    }

    public void setLblCustomizable(HtmlOutputText hot) {
        this.lblCustomizable = hot;
    }
    private HtmlSelectBooleanCheckbox choCustomizale1 = new HtmlSelectBooleanCheckbox();
    private HtmlOutputText lblReportType = new HtmlOutputText();

    public HtmlOutputText getLblReportType() {
        return lblReportType;
    }

    public void setLblReportType(HtmlOutputText hot) {
        this.lblReportType = hot;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }
    private javax.faces.component.html.HtmlOutputLabel lblSuccessOrErrorMessage = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblSuccessOrErrorMessage = hol;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private HtmlSelectBooleanCheckbox choCustomizaleReport = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoCustomizaleReport() {
        return choCustomizaleReport;
    }

    public void setChoCustomizaleReport(HtmlSelectBooleanCheckbox hsbc) {
        this.choCustomizaleReport = hsbc;
    }
    private HtmlCommandButton btn_generateJasper = new HtmlCommandButton();

    public HtmlCommandButton getBtn_generateJasper() {
        return btn_generateJasper;
    }

    public void setBtn_generateJasper(HtmlCommandButton hcb) {
        this.btn_generateJasper = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ReportCritera() {
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
        //reportPageTypes = reportManger.getAllReportTypesPageList(moduleName);
        reportTypes = reportManger.getReportTypes();
        reportCatagori = reportManger.getReportCatagori();
        monthList = reportManger.getMonthList();
        quaterList = reportManger.getQuertrlyList();
        simiAnnual = reportManger.getSimiAnnualList();


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
    //budjetYearList =reportManger.getAllBudgetYears();
    DisciplineReport report = new DisciplineReport();
    ReportCriteraManager reportManger = new ReportCriteraManager();
    ArrayList<ReportPageModle> reportPageList = new ArrayList<ReportPageModle>();
    ArrayList<Option> reportPageTypes = new ArrayList<Option>();
    ArrayList<Option> reportTypes = new ArrayList<Option>();
    ArrayList<Option> reportCatagori = new ArrayList<Option>();
    ArrayList<Option> monthList = new ArrayList<Option>();
    ArrayList<Option> quaterList = new ArrayList<Option>();
    ArrayList<Option> simiAnnual = new ArrayList<Option>();
    ArrayList<SelectItem> reportPage = new ArrayList<SelectItem>();
    ArrayList<SelectItem> budjetYear = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ReportCriteraManager criteraManger = new ReportCriteraManager();
    public String MONTHLY = ReportCriteraManager.MONTHLY;
    public String Quarterly = ReportCriteraManager.QUARTERLY;
    public String Semiannually = ReportCriteraManager.SEMIANNUALLY;
    public String Annually = ReportCriteraManager.ANNUALLY;
    ArrayList<SelectItem> budjetYearList = reportManger.getAllBudgetYears();
    ArrayList<SelectItem> newBudjetYearList = ReportCriteraManager.getBudgetYearList();
    JasperReport jasperReport=new JasperReport();
    public ArrayList<SelectItem> getNewBudjetYearList() {
        return newBudjetYearList;
    }

    public void setNewBudjetYearList(ArrayList<SelectItem> newBudjetYearList) {
        this.newBudjetYearList = newBudjetYearList;
    }

    public ArrayList<Option> getSimiAnnual() {
        return simiAnnual;
    }

    public void setSimiAnnual(ArrayList<Option> simiAnnual) {
        this.simiAnnual = simiAnnual;
    }

    public ArrayList<SelectItem> getBudjetYearList() {
        return budjetYearList;
    }

    public void setBudjetYearList(ArrayList<SelectItem> budjetYearList) {
        this.budjetYearList = budjetYearList;
    }
    public String selectionMonthly;
    public String selectionQuarterly;
    public String selectionSeminalannula;
    public String selectionAnnual;
    public String starDate;
    public String endDate;
    public String selectionCondition = "Daily";
    public String selectedCritirea;
    public String selectionType = null;
    public String repName;
    public String reportCagori;
    public String repType;
    public String moduleName;
    public String category;
    public String reportName;
    public String startDate;
    public String end_Date;
    public String employeeID;
    public String selectedMonth = "";
    public String selectedYear;
    public int quarterType;
    public int simiannualType;


    public ArrayList<SelectItem> getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(ArrayList<SelectItem> budjetYear) {
        this.budjetYear = budjetYear;
    }

    public int getSimiannualType() {
        return simiannualType;
    }

    public void setSimiannualType(int simiannualType) {
        this.simiannualType = simiannualType;
    }

    public ArrayList<Option> getQuaterList() {
        return quaterList;
    }

    public void setQuaterList(ArrayList<Option> quaterList) {
        this.quaterList = quaterList;
    }

    public ArrayList<Option> getMonthList() {
        return monthList;
    }

    public void setMonthList(ArrayList<Option> monthList) {
        this.monthList = monthList;
    }

    public ArrayList<SelectItem> getReportPage() {
        return reportPage;
    }

    public void setReportPage(ArrayList<SelectItem> reportPage) {
        this.reportPage = reportPage;
    }

    public int getQuarterType() {
        return quarterType;
    }

    public void setQuarterType(int quarterType) {
        this.quarterType = quarterType;
    }
    // reportPageTypes = reportManger.getAllReportTypesPageList(moduleName);

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSelectedCritirea() {
        return selectedCritirea;
    }

    public void setSelectedCritirea(String selectedCritirea) {
        this.selectedCritirea = selectedCritirea;
    }

    public ArrayList<Option> getReportCatagori() {
        return reportCatagori;
    }

    public void setReportCatagori(ArrayList<Option> reportCatagori) {
        this.reportCatagori = reportCatagori;
    }

    public ArrayList<Option> getReportTypes() {
        return reportTypes;
    }

    public void setReportTypes(ArrayList<Option> reportTypes) {
        this.reportTypes = reportTypes;
    }

    public ArrayList<Option> getReportPageTypes() {
        return reportPageTypes;
    }

    public void setReportPageTypes(ArrayList<Option> reportPageTypes) {
        this.reportPageTypes = reportPageTypes;
    }

    public ArrayList<ReportPageModle> getReportPageList() {
        return reportPageList;
    }

    public void setReportPageList(ArrayList<ReportPageModle> reportPageList) {
        this.reportPageList = reportPageList;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getAnnually() {
        return Annually;
    }

    public void setAnnually(String Annually) {
        this.Annually = Annually;
    }

    public String getMONTHLY() {
        return MONTHLY;
    }

    public void setMONTHLY(String MONTHLY) {
        this.MONTHLY = MONTHLY;
    }

    public String getQuarterly() {
        return Quarterly;
    }

    public void setQuarterly(String Quarterly) {
        this.Quarterly = Quarterly;
    }

    public String getSemiannually() {
        return Semiannually;
    }

    public void setSemiannually(String Semiannually) {
        this.Semiannually = Semiannually;
    }

    public String getSelectionCondition() {
        return selectionCondition;
    }

    public void setSelectionCondition(String selectionCondition) {
        this.selectionCondition = selectionCondition;
    }

    public String btn_StartDay_action() {
        calStartDate.setRendered(true);
        String startDate = dateFormat.format(calStartDate.getValue());
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txt_start_day.setValue(dateFormat.format(calStartDate.getValue()));
        starDate = dateFormat.format(calStartDate.getValue());
        calStartDate.setRendered(false);
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        txt_end_date.setValue(dateFormat.format(calEndDate.getValue()));
        String endDay = dateFormat.format(calEndDate.getValue());
        calEndDate.setRendered(false);
    }

    public String btn_EndDate_action() {
        calEndDate.setRendered(true);
        endDate = dateFormat.format(calEndDate.getValue());
        return null;

    }

    public String button1_action() {
        //return null means stay on the same page
//        repName = drl_report_Name.getValue().toString();
//        reportCagori = drl_catagory.getValue().toString();
//        repType = drl_type.getValue().toString();
//        starDate = txt_start_day.getValue().toString();
//        endDate = txt_end_date.getValue().toString();
//        selectedCritirea = selectionCondition;
        btnfullReport(null);

        return null;
    }

    public void selectOneRadio_Report_Duration_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equalsIgnoreCase(MONTHLY)) {
            selectionCondition = "Monthly";
            this.outputLabel_Month.setRendered(true);
            this.drl_Month.setRendered(true);
            this.drl_BudjetYear.setRendered(true);
            this.outputLabel_BudjetYear.setRendered(true);
            this.outputLabel_Quarterly.setRendered(false);
            this.drl_querterly.setRendered(false);
            this.outputLabel_Semiannuale.setRendered(false);
            this.drl_SemiAnnual.setRendered(false);
            this.outputLabel_annuale_type.setRendered(false);
            this.drl_annual_Type.setRendered(false);
            this.drl_BujetYear_Simiannual.setRendered(false);
        } else if (vce.getNewValue().toString().equalsIgnoreCase(Quarterly)) {
            selectionCondition = "Quarterly";
            this.outputLabel_Quarterly.setRendered(true);
            this.drl_querterly.setRendered(true);
            this.outputLabel_BudjetYear.setRendered(true);
            this.drl_BudjetYear.setRendered(true);
            this.outputLabel_Semiannuale.setRendered(false);
            this.drl_SemiAnnual.setRendered(false);
            this.outputLabel_annuale_type.setRendered(false);
            this.drl_annual_Type.setRendered(false);
            this.outputLabel_Month.setRendered(false);
            this.drl_Month.setRendered(false);
            this.drl_BujetYear_Simiannual.setRendered(false);
        } else if (vce.getNewValue().toString().equalsIgnoreCase(Semiannually)) {
            selectionCondition = "Semiannually";
            this.outputLabel_Semiannuale.setRendered(true);
            this.drl_SemiAnnual.setRendered(true);
            this.outputLabel_BudjetYear.setRendered(true);
            this.drl_BudjetYear.setRendered(true);
            this.outputLabel_Quarterly.setRendered(false);
            this.outputLabel_annuale_type.setRendered(false);
            this.drl_annual_Type.setRendered(false);
            this.drl_BujetYear_Simiannual.setRendered(true);
            this.outputLabel_Month.setRendered(false);
            this.drl_Month.setRendered(false);
            this.outputLabel_Quarterly.setRendered(false);
            this.drl_querterly.setRendered(false);
        } else if (vce.getNewValue().toString().equalsIgnoreCase(Annually)) {
            selectionCondition = "Annually";
            this.outputLabel_BudjetYear.setRendered(true);
            this.drl_BudjetYear.setRendered(true);
            this.outputLabel_Quarterly.setRendered(false);
            this.outputLabel_Month.setRendered(false);
            this.drl_Month.setRendered(false);
            this.outputLabel_Quarterly.setRendered(false);
            this.drl_querterly.setRendered(false);
            this.outputLabel_Semiannuale.setRendered(false);
            this.drl_SemiAnnual.setRendered(false);
            this.drl_BujetYear_Simiannual.setRendered(false);
        }
    }

    public String button2_action() {
        //return null means stay on the same page
        txt_start_day.resetValue();
        txt_end_date.resetValue();
        drl_catagory.resetValue();
        drl_report_Name.resetValue();
        drl_type.resetValue();
        return null;
    }

    public String cmdReportPageList_action() {
        //return null means stay on the same page
        return "ReportPageRegistration";
    }

    public String btn_NewGenerate_action() {

        if (selectionCondition.equalsIgnoreCase("Daily")) {
            selectedMonth = null;
            selectedYear = null;
            category = drl_catagory.getValue().toString();
            reportName = drl_report_Name.getValue().toString();
            startDate = txt_start_day.getValue().toString();
            end_Date = txt_end_date.getValue().toString();
            employeeID = txtEmployeeId.getValue().toString();
            selectionType = selectionCondition;

        } else if (selectionCondition.equalsIgnoreCase("Monthly")) {

            selectedMonth = drl_Month.getValue().toString();
            selectedYear = drl_BudjetYear.getValue().toString();
            category = drl_catagory.getValue().toString();
            reportName = drl_report_Name.getValue().toString();
            employeeID = txtEmployeeId.getValue().toString();
            selectionType = selectionCondition;
        } else if (selectionCondition.equalsIgnoreCase("Quarterly")) {

            selectedYear = drl_BudjetYear.getValue().toString();
            category = drl_catagory.getValue().toString();
            reportName = drl_report_Name.getValue().toString();
            selectionType = selectionCondition;
            quarterType = Integer.parseInt(drl_querterly.getValue().toString());

        } else if (selectionCondition.equalsIgnoreCase("Semiannually")) {

            selectedYear = drl_BujetYear_Simiannual.getValue().toString();
            category = drl_catagory.getValue().toString();
            reportName = drl_report_Name.getValue().toString();
            selectionType = selectionCondition;
            simiannualType = Integer.parseInt(drl_SemiAnnual.getValue().toString());

        } else if (selectionCondition.equalsIgnoreCase("Annually")) {



            selectedYear = drl_BudjetYear.getValue().toString();
            category = drl_catagory.getValue().toString();
            reportName = drl_report_Name.getValue().toString();
            selectionType = selectionCondition;
           // simiannualType=Integer.parseInt(drl_SemiAnnual.getValue().toString());

        }
        reportManger.buildReportParameterListForDays(
                category,
                reportName,
                startDate,
                end_Date,
                employeeID,
                selectionType,
                selectedMonth,
                selectedYear,
                quarterType,
                simiannualType);
        return this.displayPage(category, reportName);
    }

    public void drl_catagory_processValueChange(ValueChangeEvent vce) {
        if (!vce.getNewValue().equals("-1") && vce.getNewValue() != null) {
            moduleName = vce.getNewValue().toString();

            reportPage = reportManger.getAllReportTypesPageList(moduleName);
        // report.MonthlyReport();
        }
    }

    private String displayPage(String category, String reportName) {

        if (category.equalsIgnoreCase("POWER DELEGATION MANAGEMENT") &&
                (reportName.equalsIgnoreCase("powerDelegationRequest"))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }

            return "PowerDelegationRequestFinalReport";

        } else if (category.equalsIgnoreCase("POWER DELEGATION MANAGEMENT") &&
                (reportName.equalsIgnoreCase("powerDelegationApprove"))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }

            return "PowerDelegationApproveReport";
        } else if (category.equalsIgnoreCase("SALARY DELEGATION MANAGEMENT") &&
                (reportName.equalsIgnoreCase("SalaryDelegation"))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "SalaryDelegationRequestReport";
        } else if (category.equalsIgnoreCase("DISCIPLINE MANAGEMENT") &&
                (reportName.equalsIgnoreCase("DisciplineReport")))
        {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }

            return "DisciplineReportPage";
        } else if (category.equalsIgnoreCase("DISCIPLINE MANAGEMENT") &&
                (reportName.equalsIgnoreCase("DisciplineRequestPage"))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "DisciplineRequestReport";

        } else if (category.equalsIgnoreCase("DISCIPLINE MANAGEMENT") &&
                (reportName.equalsIgnoreCase("RejectedDisciplineReport"))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "RejectedDisciplineReport";

        } else if (category.trim().equalsIgnoreCase("DOCUMENT REQUEST MANAGEMENT".trim()) && (reportName.trim().equalsIgnoreCase("DocumentRequest page ".trim()))) {
            // reportManger.buildReportParametersList(selectedMonth, selectedYear);
            return "DocumentRequestReport";
        } else if (category.trim().equalsIgnoreCase("EMPLOYEE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("Employee Familly Report".trim()))) {
         ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            return "EmployeeFamillyReport";
          }
        else if (category.trim().equalsIgnoreCase("EMPLOYEE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("Personal Report".trim()))) {
                   if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }

              return "EmployeePersonalReport";
        //    ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
          
        } else if (category.trim().equalsIgnoreCase("EMPLOYEE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("Employee Under Provision".trim()))) {
            if((choAllEmployee.isSelected())){
            ReportCriteraManager.setAllEmployee(true);
            }
           else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "ProbationEmployee";
         } else if (category.trim().equalsIgnoreCase("EMPLOYEE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("Employee Under Provision For Management".trim()))) {
            if((choAllEmployee.isSelected())){
            ReportCriteraManager.setAllEmployee(true);
            }
           else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "ManagerProbationPeriod";

         } else if (category.trim().equalsIgnoreCase("EMPLOYEE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("ProbationForNonClerical".trim()))) {
            if((choAllEmployee.isSelected())){
            ReportCriteraManager.setAllEmployee(true);
            }
           else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "ProbationForNonClerical";



        } else if (category.trim().equalsIgnoreCase("EMPLOYEE MANAGEMENT".trim()) && (reportName.trim().equalsIgnoreCase("Employee Education Report".trim()))) {
            if (choCustomizaleReport.isSelected()) {
                if (choAllEmployee.isSelected()) {
                    ReportCriteraManager.setAllEmployee(true);
                } else {
                    ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
                }
                return "EmployeeEducationReport";
            } else {
                if (choAllEmployee.isSelected()) {
                    btnfullReport(null);
                } else {
                    btnfullReport(txtEmployeeId.getValue().toString());
                }

            }
        } else if (category.trim().equalsIgnoreCase("LEAVE MANAGEMENT".trim()) && (reportName.trim().equalsIgnoreCase("Employee Leave Balance".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EmployeeLeaveBalance";
        } else if (category.trim().equalsIgnoreCase("LEAVE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("Employee Leave Report".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EmployeeLeaveReport";
        } else if (category.trim().equalsIgnoreCase("LEAVE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("Employee Leave Transfer Report".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EmployeeLeaveTransferReport";
        } else if (category.trim().equalsIgnoreCase("TRAINING MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("TrainingStatisticsReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {

                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "TrainingStatisticsReport";
        } else if (category.trim().equalsIgnoreCase("TRAINING MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("TrainingRequestReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "TrainingRequestReport";
        } else if (category.trim().equalsIgnoreCase("TRAINING MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("TrainingApproveReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "TrainingApproveReport";
        } else if (category.trim().equalsIgnoreCase("TRAINING MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("TrainingCostReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "TrainingCostReport";
        } else if (category.trim().equalsIgnoreCase("TRAINING MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("TrainingPlanComparisonReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "TrainingPlanComparisonReport";
        } else if (category.trim().equalsIgnoreCase("TRAINING MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("TrainingRejectReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "TrainingRejectReport";
        } else if (category.trim().equalsIgnoreCase("OVER TIME MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("OverTimeRequestReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "OverTimeRequestReport";
        } else if (category.trim().equalsIgnoreCase("OVER TIME MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("OverTimeApproveReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "OverTimeApproveReport";
        } else if (category.trim().equalsIgnoreCase("SERVICE PAYMENT MANAGEMENT") &&
                (reportName.trim().equalsIgnoreCase("TransportPaymentRequestReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setAllEmployee(false);
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "TransportPaymentRequestReport";
        } else if (category.trim().equalsIgnoreCase("EDUCATION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("EducationRequestReportPage".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EducationRequestReport";
        } else if (category.trim().equalsIgnoreCase("EDUCATION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("EducationApprovedReportPage".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "ApprocedEducationReportPage";
        } else if (category.trim().equalsIgnoreCase("EDUCATION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("EducationRejectedReportPage".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EducationRejectReport";
        } else if (category.trim().equalsIgnoreCase("EDUCATION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("EducationalCostReportPage".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EducationalCostReport";
        } else if (category.trim().equalsIgnoreCase("EDUCATION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("EducationalPostPAymentReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EducationalPostPAymentReport";
        } else if (category.trim().equalsIgnoreCase("EDUCATION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("EducationalPrePayReport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "EducationalPrePayReport";
        } else if (category.trim().equalsIgnoreCase("TERMINATION  MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("clearanceRepotPage".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "clearanceRepotPage";
        } else if (category.trim().equalsIgnoreCase("TERMINATION  MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("terminationRepotPage".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "terminationRepotPage";
        } else if (category.trim().equalsIgnoreCase("ORAGANIZATION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("OrganizationREport".trim()))) {
            if (choAllEmployee.isSelected()) {
                ReportCriteraManager.setAllEmployee(true);
            } else {
                ReportCriteraManager.setEmployeeId(txtEmployeeId.getValue().toString());
            }
            return "OrganizationREport";
        } else if (category.trim().equalsIgnoreCase("BENEFITE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("benefitReport".trim()))) {
            return "BenefitReport";
        } else if (category.trim().equalsIgnoreCase("BENEFITE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("SubsidyPaymentRequest".trim()))) {
            if (HRValidation.validateRequired(drl_Month) && HRValidation.validateRequired(drl_BudjetYear)) {
                loadSubsidyPaymentForReport();
            } else {
                showSuccessOrFailureMessage(true, "Please Month and Year");
            }
        } else if (category.trim().equalsIgnoreCase("BENEFITE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("MilkPaymentRequest".trim()))) {
            if (HRValidation.validateRequired(drl_Month) && HRValidation.validateRequired(drl_BudjetYear)) {
                loadMIlkPaymentForReport();
            } else {
                showSuccessOrFailureMessage(true, "Please Month and Year");
            }
        } else if (category.trim().equalsIgnoreCase("ORGANIZATIONAL STRUCTURE MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("OrganizationREport".trim()))) {
            return "OrganizationREport";
        } else if (category.trim().equalsIgnoreCase("RECRUITMENT MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("Advertisment".trim()))) {
            return "Advertisment";
        } else if (category.trim().equalsIgnoreCase("RECRUITMENT MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("FilterCandidate".trim()))) {
            return "FilterCandidate";
        } else if (category.trim().equalsIgnoreCase("PROMOTION MANAGEMENT".trim()) &&
                (reportName.trim().equalsIgnoreCase("PromorTransfercandidateReg".trim()))) {
            return "PromorTransfercandidateReg";
        } else if (reportName.trim().equalsIgnoreCase("Promote Employee")) {
            btnfullReport();
        }

        return null;
    }

    public void drl_report_Name_processValueChange(ValueChangeEvent vce) {
    }

    private String btnExprianceReport() {

        String departmentId = "";
        String directorate = "";
        String division = "";
        String employeeGender;
        String cooperative = "";
        String team = "";
        String sortBY = " ORDER BY hr_lu_title.TITLE_LEVEL DESC";
        String employeeType = null;
        String departemntDescription = "";
        HashMap param = new HashMap();
        //E:\\FEDERALREPORTS\\Employee\\PersonalRecord.jasper
        String jasperLocation = "A:\\Employee\\report4.jasper";
        String report_Name = "HumanResourceEmployeeReport";
//        if (choPermanet.isSelected() && cholContract.isSelected()) {
//            employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";
//        } else if (choPermanet.isSelected()) {
//            employeeType = " AND EMPLOYMENTTYPE='Permanent'";
//
//        } else if (cholContract.isSelected()) {
//            employeeType = " AND EMPLOYMENTTYPE='Contract'";
//
//        } else {
//           employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";
//
//        }
//        if (choMale.isSelected() && choFemale.isSelected()) {
//            employeeGender = " AND (SEX='Female' OR SEX='Male')";
//        } else if (choMale.isSelected()) {
//            employeeGender = " AND ( SEX='Male')";
//        } else if (choFemale.isSelected()) {
//            employeeGender = " AND (SEX='Female')";
//        } else {
//            employeeGender = " AND (SEX='Female' OR SEX='Male')";
//
//        }
//        if (drlSortCriteria.getValue() != null) {
//            if (drlSortCriteria.getValue().equals("Salary")) {
//                sortBY = " order by salary DESC";
//            } else if (drlSortCriteria.getValue().equals("Name")) {
//                sortBY = " order by first_name";
//            } else if (drlSortCriteria.getValue().equals("ID")) {
//                sortBY = " ORDER BY EMP_ID ";
//            }
//
//        }
        Collection data = employeeProfileReportManager.loadEmployeeExprianceForReport();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
            // param.put("DEPARTMENT", departemntDescription);
            param.put("LOGO", LOGO.getImage());
            //param.put("PREPARED", getSessionBean1().getEmployeeName());
            reportControl.getReport(jasperLocation, report_Name, servletOutputStream, "html", response, request, param, data);
            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }
        return null;



    //return null means stay on the same page

    }

    public String btnfullReport(String employeeId) {
        String departmentId = "";
        String directorate = "";
        String division = "";
        String employeeGender;
        String cooperative = "";
        String team = "";
        String sortBY = " ORDER BY hr_lu_title.TITLE_LEVEL DESC";
        String employeeType = null;
        String departemntDescription = "";
        HashMap param = new HashMap();
        //E:\\FEDERALREPORTS\\Employee\\PersonalRecord.jasper
        String jasperLocation = "A:\\Employee\\HRGroup.jasper";
        String reportName = "HumanResourceEmployeeReport";
//        if (choPermanet.isSelected() && cholContract.isSelected()) {
//            employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";
//        } else if (choPermanet.isSelected()) {
//            employeeType = " AND EMPLOYMENTTYPE='Permanent'";
//
//        } else if (cholContract.isSelected()) {
//            employeeType = " AND EMPLOYMENTTYPE='Contract'";
//
//        } else {
//           employeeType = " AND (EMPLOYMENTTYPE='Permanent' OR EMPLOYMENTTYPE='Contract')";

//        }
        if (employeeId != null) {
            employeeType = " AND (EP.EMPLOYMENTTYPE='Permanent'" +
                    "  OR EP.EMPLOYMENTTYPE='Contract') " +
                    " AND EP.EMP_ID='" + employeeId + "'";
        } else {
            employeeType = " AND (EP.EMPLOYMENTTYPE='Permanent' OR EP.EMPLOYMENTTYPE='Contract')";
        }
//        if (choMale.isSelected() && choFemale.isSelected()) {
//            employeeGender = " AND (SEX='Female' OR SEX='Male')";
//        } else if (choMale.isSelected()) {
//            employeeGender = " AND ( SEX='Male')";
//        } else if (choFemale.isSelected()) {
//            employeeGender = " AND (SEX='Female')";
//        } else {
//            employeeGender = " AND (SEX='Female' OR SEX='Male')";
//
//        }
        employeeGender = " AND (SEX='Female' OR SEX='Male')";
//        if (drlSortCriteria.getValue() != null) {
//            if (drlSortCriteria.getValue().equals("Salary")) {
//                sortBY = " order by salary DESC";
//            } else if (drlSortCriteria.getValue().equals("Name")) {
//                sortBY = " order by first_name";
//            } else if (drlSortCriteria.getValue().equals("ID")) {
//                sortBY = " ORDER BY EMP_ID ";
//            }
//
//        }
        sortBY = " ORDER BY EMP_ID ";
        Collection data = employeeProfileReportManager.loadEmployeeInformationForReport(
                departmentId,
                employeeType,
                employeeGender,
                sortBY);

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
            param.put("DEPARTMENT", departemntDescription);
            param.put("LOGO", LOGO.getImage());
            param.put("PREPARED", getSessionBean1().getEmployeeName());
            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }
        return null;



    //return null means stay on the same page

    }

    public void employeePersonalReport() {
        //return null means stay on the same page
        try {
//D:\Employee\PersonalRecord.jrxml

            File jasperLocation = new File("A:\\Employee\\PersonalRecord.jasper");
            String reportName = "Employee Record";
            HashMap MASTERDATASOURCE;//master datasource that helps to hold the subreports information.

            JRDataSource myDataSource;

            JRMapCollectionDataSource subReportDataSource1;//data source subreport one.

            JRMapCollectionDataSource subReportDataSource2;

            JRMapCollectionDataSource subReportDataSource3;

            JRMapCollectionDataSource subReportDataSource4;

            JRMapCollectionDataSource subReportDataSource5;
            JRMapCollectionDataSource subReportDataSource6;

            ArrayList<HashMap> hmFamillyDetails = new ArrayList<HashMap>();//variable that holds the information from manager class.
            ArrayList<HashMap> hmEducationDetails = new ArrayList<HashMap>();//loadprivateAndGovernment
            ArrayList<HashMap> hmAddressDetails = new ArrayList<HashMap>();
            ArrayList<HashMap> hmLanguageSkil = new ArrayList<HashMap>();
            ArrayList<HashMap> hmExperiance = new ArrayList<HashMap>();
            ArrayList<HashMap> hmTraining = new ArrayList<HashMap>();

            List subListFamily = new ArrayList();//hold the variable loadAccrualAndPersonal.
            List subListEducation = new ArrayList();
            List subListAddress = new ArrayList();
            List subListLanguageSkill = new ArrayList();
            List subListExperiance = new ArrayList();
            List subListTraining = new ArrayList();

            hmFamillyDetails =
                    employeeProfileReportManager.loadEmployeeFamilyInformationForReport(txtEmployeeId.getValue().toString());
            hmEducationDetails =
                    employeeProfileReportManager.loadEmployeeEducationInformationForReport(txtEmployeeId.getValue().toString());
            hmAddressDetails =
                    employeeProfileReportManager.loadEmployeeAddressInformationForReport(txtEmployeeId.getValue().toString());
            hmLanguageSkil =
                    employeeProfileReportManager.loadEmployeeLanguageInformationForReport(txtEmployeeId.getValue().toString());
            hmExperiance =
                    employeeProfileReportManager.loadEmployeeExperianceInformationForReport(txtEmployeeId.getValue().toString());
            hmTraining =
                    employeeProfileReportManager.loadEmployeeTrainingInformationForReport(txtEmployeeId.getValue().toString());

            for (HashMap hm : hmFamillyDetails) {//
                Map subMap = new HashMap();
                subMap.put("relative", hm.get("relative"));
                subMap.put("fullName", hm.get("fullName"));
                subMap.put("DATE_OF_BIRTH", hm.get("DATE_OF_BIRTH"));
                subMap.put("sex", hm.get("sex"));
                subMap.put("HEIR", hm.get("HEIR"));
                subMap.put("emergencyContact", hm.get("emergencyContact"));
                subListFamily.add(subMap);
            }

            for (int k = 0; k <
                    3; k++) {//
                Map subMap = new HashMap();
                subMap.put("relative", "");
                subMap.put("fullName", "");
                subMap.put("DATE_OF_BIRTH", "");
                subMap.put("sex", "");
                subMap.put("HEIR", "");
                subListFamily.add(subMap);
            }

            for (HashMap hm : hmEducationDetails) {
                Map subMap = new HashMap();
                subMap.put("INSTITUTION", hm.get("INSTITUTION"));
                subMap.put("STARTING_DATE", hm.get("STARTING_DATE"));
                subMap.put("COMPLETION_DATE", hm.get("COMPLETION_DATE"));
                subMap.put("AWARD", hm.get("AWARD"));
                subMap.put("RESULT", hm.get("RESULT"));
                subMap.put("AWARD", hm.get("AWARD"));
                subMap.put("EDUCATION_LEVEL", hm.get("EDUCATION_LEVEL"));
                subMap.put("EDUC_TYPE", hm.get("EDUC_TYPE"));
                subListEducation.add(subMap);
            }

            for (int p = 0; p <
                    4; p++) {
                Map subMap = new HashMap();
                subMap.put("INSTITUTION", "");
                subMap.put("STARTING_DATE", "");
                subMap.put("COMPLETION_DATE", "");
                subMap.put("AWARD", "");
                subMap.put("RESULT", "");
                subMap.put("AWARD", "");
                subMap.put("EDUCATION_LEVEL", "");
                subMap.put("EDUC_TYPE", "");
                subListEducation.add(subMap);
            }

            for (HashMap hm : hmAddressDetails) {
                Map subMap = new HashMap();
                subMap.put("TELEPHONE_RESIDENCE", hm.get("TELEPHONE_RESIDENCE"));
                subMap.put("TELEPHONE_OFFICE", hm.get("TELEPHONE_OFFICE"));
                subMap.put("MOBILE", hm.get("MOBILE"));
                subMap.put("EMAIL", hm.get("EMAIL"));
                subMap.put("ADDRESSTYPE", hm.get("ADDRESSTYPE"));
                subMap.put("HOUSE_NUMBER", hm.get("HOUSE_NUMBER"));
                subMap.put("WOREDA_OR_SUBCITY_NAME", hm.get("WOREDA_OR_SUBCITY_NAME"));
                subMap.put("ZONE_OR_CITY_NAME", hm.get("ZONE_OR_CITY_NAME"));
                subMap.put("KEBELE", hm.get("KEBELE"));
                subMap.put("REGION", hm.get("REGION_ID"));
                subListAddress.add(subMap);
            }

            for (int hm = 0; hm <
                    3; hm++) {
                Map subMap = new HashMap();
                subMap.put("TELEPHONE_RESIDENCE", "");
                subMap.put("TELEPHONE_OFFICE", "");
                subMap.put("MOBILE", "");
                subMap.put("EMAIL", "");
                subMap.put("ADDRESSTYPE", "");
                subMap.put("HOUSE_NUMBER", "");
                subMap.put("WOREDA_OR_SUBCITY_NAME", "");
                subMap.put("ZONE_OR_CITY_NAME", "");
                subMap.put("KEBELE", "");
                subMap.put("REGION", "");
                subListAddress.add(subMap);
            }

            for (int i = 0; i <
                    hmLanguageSkil.size(); i++) {
                HashMap hm = hmLanguageSkil.get(i);
                Map subMap = new HashMap();
                subMap.put("READING", hm.get("READING"));
                subMap.put("WRITING", hm.get("WRITING"));
                subMap.put("SPEAKING", hm.get("SPEAKING"));
                subMap.put("LISTENING", hm.get("LISTENING"));
                subMap.put("LANGUAGE", hm.get("LANGUAGE"));

                subListLanguageSkill.add(subMap);
            }

            for (int j = 0; j <
                    3; j++) {
                Map subMap1 = new HashMap();
                subMap1.put("READING", "");
                subMap1.put("WRITING", "");
                subMap1.put("SPEAKING", "");
                subMap1.put("LISTENING", "");
                subMap1.put("LANGUAGE", "");
                subListLanguageSkill.add(subMap1);
            }


//            for (HashMap hm : hmLanguageSkil) {
//                Map subMap = new HashMap();
//                subMap.put("READING", hm.get("READING"));
//                subMap.put("WRITING", hm.get("WRITING"));
//                subMap.put("SPEAKING", hm.get("SPEAKING"));
//                subMap.put("LISTENING", hm.get("LISTENING"));
//                subMap.put("LANGUAGE", hm.get("LANGUAGE"));
//                subListLanguageSkill.add(subMap);
//            }
            for (HashMap hm : hmExperiance) {
                Map subMap = new HashMap();
                subMap.put("INSTITUION", hm.get("INSTITUION"));
                subMap.put("JOB_TITLE", hm.get("JOB_TITLE"));
                subMap.put("SALARY", hm.get("SALARY"));
                subMap.put("RANK", hm.get("RANK"));
                subMap.put("START_DATE", hm.get("START_DATE"));
                subMap.put("END_DATE", hm.get("END_DATE"));
                subMap.put("REASON_FOR_TERMINATION", hm.get("REASON_FOR_TERMINATION"));
                subListExperiance.add(subMap);
            }

            for (int m = 0; m <
                    1; m++) {
                Map subMap = new HashMap();
                subMap.put("INSTITUION", "");
                subMap.put("JOB_TITLE", "");
                subMap.put("SALARY", "");
                subMap.put("RANK", "");
                subMap.put("START_DATE", "");
                subMap.put("END_DATE", "");
                subMap.put("REASON_FOR_TERMINATION", "");
                subListExperiance.add(subMap);
            }

            for (HashMap hm : hmTraining) {
                Map subMap = new HashMap();
                subMap.put("institution", hm.get("INSTITUTION"));
                subMap.put("trainingName", hm.get("TRAININGORCOURSE_NAME"));
                subMap.put("startDate", hm.get("START_DATE"));
                subMap.put("endDate", hm.get("END_DATE"));
                subMap.put("paymentPayeeby", hm.get("PAYMENT_FOR_TRAINING"));
                subListTraining.add(subMap);
            }
            for (int m = 0; m <
                    2; m++) {
                Map subMap = new HashMap();
                subMap.put("institution", "");
                subMap.put("trainingName", "");
                subMap.put("startDate", "");
                subMap.put("endDate", "");
                subMap.put("paymentPayeeby", "");
                subListTraining.add(subMap);
            }

            subReportDataSource1 = new JRMapCollectionDataSource(subListFamily);
            subReportDataSource2 =
                    new JRMapCollectionDataSource(subListEducation);
            subReportDataSource3 =
                    new JRMapCollectionDataSource(subListAddress);
            subReportDataSource4 =
                    new JRMapCollectionDataSource(subListLanguageSkill);
            subReportDataSource5 =
                    new JRMapCollectionDataSource(subListExperiance);
            subReportDataSource6 =
                    new JRMapCollectionDataSource(subListTraining);
            MASTERDATASOURCE =
                    new HashMap();
            MASTERDATASOURCE.put("subReportDataSource1", subReportDataSource1);
            MASTERDATASOURCE.put("subReportDataSource2", subReportDataSource2);
            MASTERDATASOURCE.put("subReportDataSource3", subReportDataSource3);
            MASTERDATASOURCE.put("subReportDataSource4", subReportDataSource4);
            MASTERDATASOURCE.put("subReportDataSource5", subReportDataSource5);
            MASTERDATASOURCE.put("subReportDataSource6", subReportDataSource6);
            Map masterMap = new HashMap();
            masterMap.put("subReportField1", "subReportDataSource1");
            masterMap.put("subReportField2", "subReportDataSource2");
            masterMap.put("subReportField3", "subReportDataSource3");
            masterMap.put("subReportField4", "subReportDataSource4");
            masterMap.put("subReportField5", "subReportDataSource5");
            masterMap.put("subReportField6", "subReportDataSource6");

            List masterList = new ArrayList();
            masterList.add(masterMap);

            myDataSource = new JRMapCollectionDataSource(masterList);
            Map parameter = new HashMap();
            parameter.put("MASTERDATASOURCE", MASTERDATASOURCE);
            EmployeeManage employeeManager = new EmployeeManage();
            //new EmployeeManage();
            employeeManager.loadEmpoyeeProfile(txtEmployeeId.getValue().toString());

            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());

            try {
                setEmpImage(blo.getBytes(0, (int) blo.length()));

            } catch (Exception ex) {

                ex.printStackTrace();
            }

            loadEmployeePicture(getEmpImage());

            parameter.put("EmployeeId", txtEmployeeId.getValue().toString());
            parameter.put("LOGO", LOGO.getImage());
            parameter.put("Title", employeeManager.getTitleDes());
            parameter.put("FIRST_NAME", employeeManager.getFirst_Name());
            parameter.put("MIDDLE_NAME", employeeManager.getMiddle_Name());
            parameter.put("LAST_NAME", employeeManager.getLast_Name());
            parameter.put("HIRE_DATE", employeeManager.getHire_Date());
            parameter.put("DATE_OF_BIRTH", employeeManager.getDate_Of_Birth());
            parameter.put("SALARY", employeeManager.getSalary());
            parameter.put("SEX", employeeManager.getSex());
            parameter.put("nationalitydescription", employeeManager.getNationality_Description());
            parameter.put("RETIREMENT_NO", employeeManager.getRetirement_no());
            parameter.put("MARITAL_STATUS", employeeManager.getMarital_Status());
            parameter.put("Department", "department");
            parameter.put("JOB_DESCRIPTION", employeeManager.getJobDescription());
            parameter.put("description", employeeManager.getNationality());
            parameter.put("Title", employeeManager.getTitleDes());
            parameter.put("SALARY", employeeManager.getSalary());
            parameter.put("RANK", employeeManager.getDrlPayGrade());
            employeeManager = new EmployeeManage();
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            ServletOutputStream servletOutputStream = null;
            servletOutputStream = response.getOutputStream();
            reportControl.getReportSummary(jasperLocation, reportName, servletOutputStream, "html", response, request, parameter, (JRMapCollectionDataSource) myDataSource);

            servletOutputStream.flush();
            servletOutputStream.close();
            context.responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void LoadLOGO() {
        List data = null;
        EmployeeProfileReportManager manager1 = new EmployeeProfileReportManager();
        data = manager1.loadCompanyLogo();
        ListIterator<EmployeeProfileReportManager> lstmb = data.listIterator();
        try {
            while (lstmb.hasNext()) {
                EmployeeProfileReportManager mag = lstmb.next();
                if (mag.getFPLOGO() != null) {
                    LOGO = new ImageIcon((byte[]) mag.getFPLOGO());
                } else {
                    LOGO = new ImageIcon();
                }
            }
        } catch (Exception ex) {
        }

    }

    public void loadEmployeePicture(byte[] employeePicture) {
        try {
            if (employeePicture != null) {
                LOGO = new ImageIcon((byte[]) employeePicture);
            } else {
                LOGO = new ImageIcon();
            }

        } catch (Exception ex) {
        }

    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setRendered(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String SUBSIDY_action() {
        loadSubsidyPaymentForReport();

        //return null means stay on the same page
        return null;
    }

    void loadSubsidyPaymentForReport() {

        String jasperLocation = "A:\\Report\\SubsidyReport.jasper";
        String reportName = "SubsidyReport";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
            checkObj();
            Collection data = benefitRequestManager.loadSubsidyPaymentForReport();
            if (data != null) {
                HashMap param = new HashMap();
                param.put("LOGO", LOGO.getImage());
                // param.put("PREPARED", getSessionBean1().getEmployeeName());

                reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                servletOutputStream.flush();
                servletOutputStream.close();
                // Stop resend
                FacesContext.getCurrentInstance().responseComplete();

            } else {
                showSuccessOrFailureMessage(false, "There is no Report");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }


    }

    void loadMIlkPaymentForReport() {

        String jasperLocation = "A:\\Report\\MilkReport.jasper";
        String reportName = "MilkReport";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
            checkObj();
            String startDatee = txt_start_day.getValue().toString();
            String endDatee = txt_end_date.getValue().toString();
            Collection data = benefitRequestManager.loadMilkPaymentForReport(startDatee, endDatee);
            if (data != null) {
                HashMap param = new HashMap();
                param.put("LOGO", LOGO.getImage());
                param.put("STARTDATE", startDatee);
                param.put("ENDDATE", endDatee);
                reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                servletOutputStream.flush();
                servletOutputStream.close();
                // Stop resend
                FacesContext.getCurrentInstance().responseComplete();

            } else {
                showSuccessOrFailureMessage(false, "There is no Report");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }


    }

    public void btnfullReport() {
        try {


            HashMap param = new HashMap();
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/Promotion");
            String jasperLocation = reportPath + "\\PromotionReport.jasper";
            File reportsDir = new File(reportPath);
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat("docx");
            getSessionBean1().setRs(employeeProfileReportManager.getPromoteList());
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('ReportPage.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");



        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }




    //return null means stay on the same page

    }

    private void checkObj() {
        if (benefitRequestManager == null) {
            benefitRequestManager = new BenefitRequestManager();



        }
    }

//    public String commandLink1_action()
//         {
////         employeeID=txtEmployeeId.getValue().toString();
////        if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE PROFILE JASPER"))
////        {
////         loadEmployeePersonalInformationForReport(employeeID);
////        }
////        else if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE EDUCATION JASPER"))
////        {
////         loadEmployeeEmployeeEducationInformationForReport(employeeID);
////        }
////        else if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE EXPIRANCE JASPER"))
////        {
////
////         loadEmployeeExpiranceInformationForReport(employeeID);
////        }
////        else if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE TRAINING JASPER"))
////        {
////
////         loadEmployeeTraningInformationForReport(employeeID);
////        }
////
////       return null;
//    }

    private void loadEmployeePersonalInformationForReport(String empId) {
                {
            FacesContext context = FacesContext.getCurrentInstance();
             ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/EmployeeManagement");
            String jasperLocation = reportPath + "\\EmployeePersonalProfileReport.jasper";
         //  String jasperLocation="D:\\DeployedBIBHR\\PersonalReport\\EmployeePersonalProfileReport.jasper";
           // String jasperLocation="D:\\HRREPOT\\Employee Profile Report.jasper";
             String reportName = "EmployeeProfileInformation";
             HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();

           Collection data = jasperReport.loadEmployeeInformationForReport(empId);

           if((data != null))
           {
            HashMap param = new HashMap();
            param.put("LOGO", LOGO.getImage());

             reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);

            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();

            }



            else{
           showSuccessOrFailureMessage(false, "There is no Report");
            }
           //  loadCandidateEducationInformationForReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }

    }
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////
        private void loadEmployeeEmployeeEducationInformationForReport(String empID) {
                {
            FacesContext context = FacesContext.getCurrentInstance();
             ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/EmployeeManagement");
            String jasperLocation = reportPath + "\\EmployeeEducation.jasper";
          // String jasperLocation="D:\\DeployedBIBHR\\PersonalReport\\EmployeeEducation.jasper";
           // String jasperLocation="D:\\HRREPOT\\Employee Profile Report.jasper";
             String reportName = "EmployeeEducationInformation";
             HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();

           Collection data = jasperReport.loadEmployeeEducationInformationForReport(empID);

           if((data != null))
           {
            HashMap param = new HashMap();
            param.put("LOGO", LOGO.getImage());

             reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);

            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();

            }



            else{
           showSuccessOrFailureMessage(false, "There is no Report");
            }
           //  loadCandidateEducationInformationForReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }

    }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////



        private void loadEmployeeExpiranceInformationForReport(String empId) {
                {
            FacesContext context = FacesContext.getCurrentInstance();
             ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/EmployeeManagement");
            String jasperLocation = reportPath + "\\EmployeeExpirance.jasper";
          // String jasperLocation="D:\\DeployedBIBHR\\PersonalReport\\EmployeeExpirance.jasper";
           // String jasperLocation="D:\\HRREPOT\\Employee Profile Report.jasper";
             String reportName = "EmployeeExpirnaceInformation";
             HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();

           Collection data = jasperReport.loadEmployeeExoiranceInforamrionForReport(empId);

           if((data != null))
           {
            HashMap param = new HashMap();
            param.put("LOGO", LOGO.getImage());

             reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);

            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();

            }



            else{
           showSuccessOrFailureMessage(false, "There is no Report");
            }
           //  loadCandidateEducationInformationForReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }

    }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////




     private void loadEmployeeTraningInformationForReport(String empID) {
                {

             

            FacesContext context = FacesContext.getCurrentInstance();
             ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/EmployeeManagement");
            String jasperLocation = reportPath + "\\EmployeeTrainingProfile.jasper";
            //String jasperLocation="D:\\DeployedBIBHR\\PersonalReport\\EmployeeTrainingProfile.jasper";
           // String jasperLocation="D:\\HRREPOT\\Employee Profile Report.jasper";
             String reportName = "EmployeeInformation";
             HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();

           Collection data = jasperReport.loadEmployeeTrainigInforamrionForReport(empID);

           if((data != null))
           {
            HashMap param = new HashMap();
            param.put("LOGO", LOGO.getImage());

             reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);

            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();

            }



            else{
           showSuccessOrFailureMessage(false, "There is no Report");
            }
           //  loadCandidateEducationInformationForReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }

    }
    }

    public String btn_generateJasper_action() {
        employeeID=txtEmployeeId.getValue().toString();
        if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE PROFILE JASPER"))
        {
         loadEmployeePersonalInformationForReport(employeeID);
        }
        else if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE EDUCATION JASPER"))
        {
         loadEmployeeEmployeeEducationInformationForReport(employeeID);
        }
        else if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE EXPIRANCE JASPER"))
        {

         loadEmployeeExpiranceInformationForReport(employeeID);
        }
        else if(drl_report_Name.getValue().toString().equalsIgnoreCase("EMPLOYEE TRAINING JASPER"))
        {

         loadEmployeeTraningInformationForReport(employeeID);
        }

       return null;
    }
}


