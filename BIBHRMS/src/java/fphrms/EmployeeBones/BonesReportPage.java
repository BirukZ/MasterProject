/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.EmployeeBones;

import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ValueChangeEvent;
import manager.attendanceManager.AttendanceReportManager;

import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;

import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.ReportControl;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import lookUps.BonesLookup;
import manager.employeeBonesManager.EmployeeBonesManager;
import manager.globalUseManager.HRValidation;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.util.SimpleFileResolver;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class BonesReportPage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<SelectItem> listOfYear = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> listOfLocation = new ArrayList<SelectItem>();
    private ArrayList<BonesList> bonesList = new ArrayList<BonesList>();
    private ArrayList<SelectItem> holiday_Name = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getHoliday_Name() {
        return holiday_Name;
    }

    public void setHoliday_Name(ArrayList<SelectItem> holiday_Name) {
        this.holiday_Name = holiday_Name;
    }
    private ArrayList<BonesList> yearlyBonesList = new ArrayList<BonesList>();
    private AttendanceReportManager attendanceReportManager = new AttendanceReportManager();
    private ReportControl reportControl = new ReportControl();
    SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
    private String[] bonesType = {"Holiday Bones", "Yearly Bones "};
    ArrayList<SelectItem> listOfBonesType = new ArrayList<SelectItem>();
    private BonesLookup bonesLookup = null;
    private EmployeeBonesManager employeeBonesManager = null;

    public ArrayList<BonesList> getYearlyBonesList() {
        return yearlyBonesList;
    }

    public void setYearlyBonesList(ArrayList<BonesList> yearlyBonesList) {
        this.yearlyBonesList = yearlyBonesList;
    }

    public ArrayList<BonesList> getBonesList() {
        return bonesList;
    }

    public void setBonesList(ArrayList<BonesList> bonesList) {
        this.bonesList = bonesList;
    }

    public ArrayList<SelectItem> getListOfLocation() {
        return listOfLocation;
    }

    public void setListOfLocation(ArrayList<SelectItem> listOfLocation) {
        this.listOfLocation = listOfLocation;
    }

    public ArrayList<SelectItem> getListOfYear() {
        return listOfYear;
    }

    public void setListOfYear(ArrayList<SelectItem> listOfYear) {
        this.listOfYear = listOfYear;
    }

    public ArrayList<SelectItem> getListOfBonesType() {
        return listOfBonesType;
    }

    public void setListOfBonesType(ArrayList<SelectItem> listOfBonesType) {
        this.listOfBonesType = listOfBonesType;
    }

    public String[] getBonesType() {
        return bonesType;
    }

    public void setBonesType(String[] bonesType) {
        this.bonesType = bonesType;
    }
    private int DEPARRTMENT_ID;

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
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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
    private HtmlSelectOneMenu drlBudgetYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBudgetYear() {
        return drlBudgetYear;
    }

    public void setDrlBudgetYear(HtmlSelectOneMenu hsom) {
        this.drlBudgetYear = hsom;
    }
    private HtmlSelectOneMenu drlLocation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLocation() {
        return drlLocation;
    }

    public void setDrlLocation(HtmlSelectOneMenu hsom) {
        this.drlLocation = hsom;
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
    private HtmlSelectOneRadio optBonesType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getOptBonesType() {
        return optBonesType;
    }

    public void setOptBonesType(HtmlSelectOneRadio hsor) {
        this.optBonesType = hsor;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlHolidayName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlHolidayName() {
        return drlHolidayName;
    }

    public void setDrlHolidayName(HtmlSelectOneMenu hsom) {
        this.drlHolidayName = hsom;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlDataTable tblHolidayBones = new HtmlDataTable();

    public HtmlDataTable getTblHolidayBones() {
        return tblHolidayBones;
    }

    public void setTblHolidayBones(HtmlDataTable hdt) {
        this.tblHolidayBones = hdt;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlDataTable tblYearlyBonesList = new HtmlDataTable();

    public HtmlDataTable getTblYearlyBonesList() {
        return tblYearlyBonesList;
    }

    public void setTblYearlyBonesList(HtmlDataTable hdt) {
        this.tblYearlyBonesList = hdt;
    }
    private HtmlOutputText lblHolidayName = new HtmlOutputText();

    public HtmlOutputText getLblHolidayName() {
        return lblHolidayName;
    }

    public void setLblHolidayName(HtmlOutputText hot) {
        this.lblHolidayName = hot;
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
    public BonesReportPage() {
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
        checkobject();
        setListOfBonesType(bonesLookup.listOfBonesType());
        setListOfYear(bonesLookup.listOfBonesYear());
        setListOfLocation(bonesLookup.listOfPlace());
        setHoliday_Name(bonesLookup.listOfBonesHolidayName());
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

    public String generateReport(String format) {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/Bones");
           
            String jasperLocation = reportPath + "\\EmployeeYearlyBones.jasper";
            File reportsDir = new File(reportPath);
            HashMap param = new HashMap();
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
            param.put("BUGETYEAR", drlBudgetYear.getValue().toString());
            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat(format);
            OracleCachedRowSet ocrs = employeeBonesManager.selectEmployeeYearlyBones(
                    drlLocation.getValue().toString(),
                    drlBudgetYear.getValue().toString());
            getSessionBean1().setRs(ocrs);
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('ReportPage.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    //return null means stay on the same page

    }

    public String generateReportHolidayBones(String format) {
        try {
            HashMap param = new HashMap();
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/Bones");
            String jasperLocation = reportPath + "\\EmployeeHolidayBones.jasper";
            File reportsDir = new File(reportPath);
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
            param.put("HOLIDAYNAME", drlHolidayName.getValue().toString());
            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat("html");
            OracleCachedRowSet ocrs = employeeBonesManager.selectEmployeeHolidayBones(
                    drlLocation.getValue().toString(),
                    drlBudgetYear.getValue().toString(),
                    drlHolidayName.getValue().toString());
            getSessionBean1().setRs(ocrs);
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('ReportPage.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");





        } catch (Exception e) {
        }
        return null;



    //return null means stay on the same page

    }

    public void yearlyBones() {
        try {
            getYearlyBonesList().clear();
            ArrayList<HashMap> list = employeeBonesManager.selectEmployeeYearlyBonesList(
                    drlLocation.getValue().toString(),
                    drlBudgetYear.getValue().toString());
            for (HashMap hm : list) {
                getYearlyBonesList().add(new BonesList(
                        hm.get("Employeeid").toString(),
                        hm.get("EMPLOYEEFULLNAME").toString(),
                        hm.get("BONES").toString(),
                        hm.get("JUNESALARY").toString(),
                        hm.get("EXPERIENCE").toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void holidayBones() {
        try {
            getYearlyBonesList().clear();
            ArrayList<HashMap> list = employeeBonesManager.selectEmployeeHolidayBonesList(
                    drlLocation.getValue().toString(),
                    drlBudgetYear.getValue().toString(),
                    drlHolidayName.getValue().toString());
            for (HashMap hm : list) {
                getBonesList().add(new BonesList(
                        hm.get("Employeeid").toString(),
                        hm.get("EMPLOYEEFULLNAME").toString(),
                        hm.get("BONES").toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkobject() {
        if (bonesLookup == null) {
            bonesLookup = new BonesLookup();
        }
        if (employeeBonesManager == null) {
            employeeBonesManager = new EmployeeBonesManager();

        }
    }

    public String button1_action() {



        //return null means stay on the same page
        return null;
    }

    public static class BonesList {

        private String employeeid;
        private String employeeFullName;
        private String bones;
        private String juneSalary;
        private String experience;

        public String getBones() {
            return bones;
        }

        public void setBones(String bones) {
            this.bones = bones;
        }

        public String getEmployeeFullName() {
            return employeeFullName;
        }

        public void setEmployeeFullName(String employeeFullName) {
            this.employeeFullName = employeeFullName;
        }

        public String getEmployeeid() {
            return employeeid;
        }

        public void setEmployeeid(String employeeid) {
            this.employeeid = employeeid;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getJuneSalary() {
            return juneSalary;
        }

        public void setJuneSalary(String juneSalary) {
            this.juneSalary = juneSalary;
        }

        public BonesList(String employeeid, String employeeFullName, String bones, String juneSalary, String experience) {
            this.employeeid = employeeid;
            this.employeeFullName = employeeFullName;
            this.bones = bones;
            this.juneSalary = juneSalary;
            this.experience = experience;
        }

        public BonesList(String employeeid, String employeeFullName, String bones) {
            this.employeeid = employeeid;
            this.employeeFullName = employeeFullName;
            this.bones = bones;
        }
    }

    public String btnHtml_action() {
        if (isValid()) {
            if (optBonesType.getValue().equals("YearlyBones")) {
                generateReport("html");
            } else if (optBonesType.getValue().equals("HolidayBones")) {
                generateReportHolidayBones("html");

            }
        } else {
            showSuccessOrFailureMessage(false, "All filed are required.Please select unselected filed ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnPdf_action() {
        if (isValid()) {
            if (optBonesType.getValue().equals("YearlyBones")) {
                generateReport("pdf");
            } else if (optBonesType.getValue().equals("HolidayBones")) {
                generateReportHolidayBones("pdf");

            }
        } else {
            showSuccessOrFailureMessage(false, "All filed are required.Please select unselected filed ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnExcel_action() {
        if (isValid()) {
            if (optBonesType.getValue().equals("YearlyBones")) {
                generateReport("xlsx");
            } else if (optBonesType.getValue().equals("HolidayBones")) {
                generateReportHolidayBones("xlsx");

            }
        } else {
            showSuccessOrFailureMessage(false, "All filed are required.Please select unselected filed ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnWord_action() {
        if (isValid()) {
            if (optBonesType.getValue().equals("YearlyBones")) {
                generateReport("docx");
            } else if (optBonesType.getValue().equals("HolidayBones")) {
                generateReportHolidayBones("docx");

            }
        } else {
            showSuccessOrFailureMessage(false, "All filed are required.Please select unselected filed ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnDisplay_action() {
        if (isValid()) {
            if (optBonesType.getValue().equals("YearlyBones")) {
                tblYearlyBonesList.setRendered(true);
                tblHolidayBones.setRendered(false);
                yearlyBones();
            } else if (optBonesType.getValue().equals("HolidayBones")) {
                tblYearlyBonesList.setRendered(false);
                tblHolidayBones.setRendered(true);
                holidayBones();

            }
        } else {
            // tblYearlyBonesList.setRendered(true);
            //tblHolidayBones.setRendered(false);
            showSuccessOrFailureMessage(false, "All filed are required.Please select unselected filed ?");


        }

        //return null means stay on the same page
        return null;
    }

    private boolean isValid() {
        boolean result = true;
        if (!HRValidation.validateRequired(drlBudgetYear.getValue())) {
            result = false;
        }
        if (!HRValidation.validateRequired(drlLocation.getValue())) {
            result = false;
        }
        if (HRValidation.validateRequired(optBonesType.getValue())) {
            if (optBonesType.getValue().equals("HolidayBones")) {
                if (!HRValidation.validateRequired(drlHolidayName.getValue())) {
                    result = false;
                }
            }
        } else {
            result = false;
        }

        return result;
    }

    public void optBonesType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (vce.getNewValue().equals("HolidayBones")) {
                lblHolidayName.setRendered(true);
                drlHolidayName.setRendered(true);
            } else {
                lblHolidayName.setRendered(false);
                drlHolidayName.setRendered(false);
            }

        }
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: " +
                " bold;text-align: center; vertical-align: middle" : "color: red; " +
                " font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String lnkReportGenrationCritera_action() {
        //return null means stay on the same page
        return "ReportCritera";
    }

    public String lnkHolydayBonesRequest_action() {
        //return null means stay on the same page
        return "HolydayBonesRequest";
    }

    public String lnkYearlyBonesRequest_action() {
        //return null means stay on the same page
        return "YearlyBonesRequest";
    }
}

