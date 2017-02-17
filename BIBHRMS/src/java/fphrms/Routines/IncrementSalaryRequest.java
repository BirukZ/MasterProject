/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.Routines;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import manager.globalUseManager.HRValidation;
import manager.promotionManager.IncrementPayGradeManager;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.util.SimpleFileResolver;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class IncrementSalaryRequest extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private IncrementPayGradeManager incrementPayGradeManager = new IncrementPayGradeManager();
    private ArrayList<IncrementPayGradeManager> incrementPayGradeManagerList = new ArrayList<IncrementPayGradeManager>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<HashMap> salaryIncrementList = new ArrayList<HashMap>();

    public ArrayList<HashMap> getSalaryIncrementList() {
        return salaryIncrementList;
    }

    public void setSalaryIncrementList(ArrayList<HashMap> salaryIncrementList) {
        this.salaryIncrementList = salaryIncrementList;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

    public ArrayList<IncrementPayGradeManager> getIncrementPayGradeManagerList() {
        return incrementPayGradeManagerList;
    }

    public void setIncrementPayGradeManagerList(ArrayList<IncrementPayGradeManager> incrementPayGradeManagerList) {
        this.incrementPayGradeManagerList = incrementPayGradeManagerList;
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
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkSelected = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkSelected() {
        return chkSelected;
    }

    public void setChkSelected(HtmlSelectBooleanCheckbox hsbc) {
        this.chkSelected = hsbc;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calIncrementDay = new SelectInputDate();

    public SelectInputDate getCalIncrementDay() {
        return calIncrementDay;
    }

    public void setCalIncrementDay(SelectInputDate sid) {
        this.calIncrementDay = sid;
    }
    private HtmlInputText txtIncremntDay = new HtmlInputText();

    public HtmlInputText getTxtIncremntDay() {
        return txtIncremntDay;
    }

    public void setTxtIncremntDay(HtmlInputText hit) {
        this.txtIncremntDay = hit;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calRequestDate = new SelectInputDate();

    public SelectInputDate getCalRequestDate() {
        return calRequestDate;
    }

    public void setCalRequestDate(SelectInputDate sid) {
        this.calRequestDate = sid;
    }
    private HtmlInputText txtRequestDate = new HtmlInputText();

    public HtmlInputText getTxtRequestDate() {
        return txtRequestDate;
    }

    public void setTxtRequestDate(HtmlInputText hit) {
        this.txtRequestDate = hit;
    }
    private HtmlInputTextarea txtDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(HtmlInputTextarea hit) {
        this.txtDescription = hit;
    }
    private HtmlOutputText lblTotalEmployee = new HtmlOutputText();

    public HtmlOutputText getLblTotalEmployee() {
        return lblTotalEmployee;
    }

    public void setLblTotalEmployee(HtmlOutputText hot) {
        this.lblTotalEmployee = hot;
    }
    private HtmlOutputText lblEmployeeCalculatedSalary = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeCalculatedSalary() {
        return lblEmployeeCalculatedSalary;
    }

    public void setLblEmployeeCalculatedSalary(HtmlOutputText hot) {
        this.lblEmployeeCalculatedSalary = hot;
    }
    private HtmlOutputText lblNotEmployeeNotincremtn = new HtmlOutputText();

    public HtmlOutputText getLblNotEmployeeNotincremtn() {
        return lblNotEmployeeNotincremtn;
    }

    public void setLblNotEmployeeNotincremtn(HtmlOutputText hot) {
        this.lblNotEmployeeNotincremtn = hot;
    }
    private PanelLayout lySalayIncremantButton = new PanelLayout();

    public PanelLayout getLySalayIncremantButton() {
        return lySalayIncremantButton;
    }

    public void setLySalayIncremantButton(PanelLayout pl) {
        this.lySalayIncremantButton = pl;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public IncrementSalaryRequest() {
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

    public String button1_action() {
        try {
            int totalEmployee = 0;
            int notCalculatedIncremnet;
            int calculatedIncremnet;
            boolean result = true;
            int errorValue =
                    HRValidation.validateData(txtIncremntDay.getValue(), HRValidation.DATE_PATTERN2, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtIncremntDay).setValid(false);
                    error(txtIncremntDay, "Required");
                } else {
                    ((UIInput) txtIncremntDay).setValid(false);
                    error(txtIncremntDay, "Invalid Value");
                }

            }


            if (result) {
                setSalaryIncrementList(incrementPayGradeManager.calculateEmployeeIncremant(txtIncremntDay.getValue().toString()));
                getIncrementPayGradeManagerList().clear();
                for (HashMap hm : getSalaryIncrementList()) {
                    getIncrementPayGradeManagerList().add(new IncrementPayGradeManager(
                            hm.get("EMP_ID").toString(),
                            hm.get("FULLNAME").toString(),
                            "depId",
                            "deptDesc",
                            hm.get("HIRE_DATE").toString(),
                            "123",
                            hm.get("currentPayGrade").toString(),
                            hm.get("currentSalary").toString(),
                            hm.get("nextPayGrade").toString(),
                            hm.get("newSalary").toString(),
                            hm.get("persentage").toString() + "%", true));
                }
                totalEmployee = IncrementPayGradeManager.getTotalEmployee();
                calculatedIncremnet = getSalaryIncrementList().size();
                notCalculatedIncremnet = totalEmployee - calculatedIncremnet;
                lblEmployeeCalculatedSalary.setValue(calculatedIncremnet);

                lblTotalEmployee.setValue(totalEmployee);

                lblNotEmployeeNotincremtn.setValue(notCalculatedIncremnet);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void calIncrementDay_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                txtIncremntDay.setValue(sdf.format(vce.getNewValue()));
                calIncrementDay.setRendered(false);
            }
        } catch (Exception e) {
        }
    }

    public String btn_action() {

        //return null means stay on the same page
        return null;
    }

    public void calRequestDate_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                txtRequestDate.setValue(sdf.format(vce.getNewValue()));
                calRequestDate.setRendered(false);

            }
        } catch (Exception e) {
        }
    }

    public String button3_action() {

        //return null means stay on the same page
        return null;
    }

    public String btnIncrementDay_action() {
        calIncrementDay.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnRequestDate_action() {
        calRequestDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnCheckAll_action() {
        try {
            ArrayList<IncrementPayGradeManager> incPayGradeManagerList = getIncrementPayGradeManagerList();
            for (IncrementPayGradeManager incPayGradeManger : incPayGradeManagerList) {
                incPayGradeManger.setSelected(true);
            }
        } catch (Exception e) {
        }
        //return null means stay on the same page
        return null;
    }

    public String bntUnCheckAll_action() {
        try {
            ArrayList<IncrementPayGradeManager> incPayGradeManagerList = getIncrementPayGradeManagerList();

            for (IncrementPayGradeManager incPayGradeManger : incPayGradeManagerList) {
                incPayGradeManger.setSelected(false);
            }
        } catch (Exception e) {
        }
        //return null means stay on the same page
        return null;
    }

    public String btnReport_action() {
        generateReport("html");

        //return null means stay on the same page
        return null;
    }

    public String generateReport(String format) {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/SalaryIncrement");

            String jasperLocation = reportPath + "\\EmployeeSalaryIncrement.jasper";
            File reportsDir = new File(reportPath);
            HashMap param = new HashMap();
            param.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
//            param.put("BUGETYEAR", drlBudgetYear.getValue().toString());
//            getSessionBean1().setParam(param);
            getSessionBean1().setFileName(jasperLocation);
            getSessionBean1().setFormat(format);
//            OracleCachedRowSet ocrs = employeeBonesManager.selectEmployeeYearlyBones(
//                    drlLocation.getValue().toString(),
//                    drlBudgetYear.getValue().toString());
            getSessionBean1().setColl(getSalaryIncrementList());
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open('ReportPage.jsp'," +
                    " 'ReportViewer', ('width='+.75*screen.width+', height='+.75*screen.height+',  top='+.1*screen.height+', left='+.1*screen.width+', dependent=yes, menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=no'));");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    //return null means stay on the same page

    }
}

