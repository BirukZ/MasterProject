/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.Attendance;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.faces.event.ValueChangeEvent;
import manager.attendanceManager.AttendanceReportManager;
import manager.globalUseManager.StringDateManipulation;

import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.tree.Tree;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.ReportControl;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultTreeModel;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class AttendanceReportPage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private AttendanceReportManager attendanceReportManager = new AttendanceReportManager();
    private ReportControl reportControl = new ReportControl();
    SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
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
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlInputText txtDateTo = new HtmlInputText();

    public HtmlInputText getTxtDateTo() {
        return txtDateTo;
    }

    public void setTxtDateTo(HtmlInputText hit) {
        this.txtDateTo = hit;
    }
    private SelectInputDate calDateTo = new SelectInputDate();

    public SelectInputDate getCalDateTo() {
        return calDateTo;
    }

    public void setCalDateTo(SelectInputDate sid) {
        this.calDateTo = sid;
    }
    private SelectInputDate calDateFrom = new SelectInputDate();

    public SelectInputDate getCalDateFrom() {
        return calDateFrom;
    }

    public void setCalDateFrom(SelectInputDate sid) {
        this.calDateFrom = sid;
    }
    private DefaultTree tree1Model = new DefaultTree();

    public DefaultTree getTree1Model() {
        return tree1Model;
    }

    public void setTree1Model(DefaultTree dt) {
        this.tree1Model = dt;
    }
    private PanelLayout panTreeHolder = new PanelLayout();

    public PanelLayout getPanTreeHolder() {
        return panTreeHolder;
    }

    public void setPanTreeHolder(PanelLayout pl) {
        this.panTreeHolder = pl;
    }
    private Tree treeDepartment = new Tree();

    public Tree getTreeDepartment() {
        return treeDepartment;
    }

    public void setTreeDepartment(Tree t) {
        this.treeDepartment = t;
    }
    private DefaultTree tree1Model1 = new DefaultTree();

    public DefaultTree getTree1Model1() {
        return tree1Model1;
    }

    public void setTree1Model1(DefaultTree dt) {
        this.tree1Model1 = dt;
    }
    private HtmlOutputText lblDepartmentName = new HtmlOutputText();

    public HtmlOutputText getLblDepartmentName() {
        return lblDepartmentName;
    }

    public void setLblDepartmentName(HtmlOutputText hot) {
        this.lblDepartmentName = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AttendanceReportPage() {
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
        LoadTree loadTree = new LoadTree();
        this.tree1Model1.setModel(new DefaultTreeModel(loadTree.populateNodes()));
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

    public String generateReport() {
        try {
            HashMap param = new HashMap();
            //E:\\FEDERALREPORTS\\Employee\\PersonalRecord.jasper
            String jasperLocation = "D:\\Employee\\LEAVE\\AttendanceReport.jasper";
            String reportName = "HumanResourceEmployeeReport";
            DateFormat formatter;
            Date date;
            Date endDate;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(txtStartDate.getValue().toString());
            endDate = (Date) formatter.parse(txtDateTo.getValue().toString());
            checkobject();
            Collection data = attendanceReportManager.listOfAbsent(date, endDate,DEPARRTMENT_ID);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            ServletOutputStream servletOutputStream = null;
            try {
                String dateString;
                String dayOfWeek;
                servletOutputStream = response.getOutputStream();
                // LoadLOGO();
                Calendar startCal = Calendar.getInstance();
                Calendar endDateCal = Calendar.getInstance();
                startCal.setTime(date);
                endDateCal.setTime(endDate);
                int reportCounter = 1;

                while (!startCal.after(endDateCal)) {
                    dateString = dateformatter.format(startCal.getTime());
                    date = dateformatter.parse(dateString);
                    dayOfWeek = new SimpleDateFormat("EE", Locale.ENGLISH).format(date);
                    param.put("DAYNAME" + reportCounter, dayOfWeek);
                    param.put("DAY" + reportCounter, Integer.toString(StringDateManipulation.getDate(dateString)));
                    startCal.add(Calendar.DAY_OF_MONTH, 1);


                    reportCounter++;
                }
                endDateCal.setTime(endDate);
//                param.put("DAYNAME1", "Sunday");
//                param.put("DAYNAME2", "2003");
//                param.put("DAYNAME3", "2004");
//                param.put("DAYNAME4", "2005");
//                param.put("DAYNAME5", "2005");

//                param.put("DAY01", "01");
//                param.put("DAY02", "02");
//                param.put("DAY03", "03");
//                param.put("DAY04", "04");
//                param.put("DAY05", "05");
                // param.put("TODAY", sdf.format(new Date()));
//            param.put("LOGO", LOGO.getImage());
                param.put("DEPARTEMNT", lblDepartmentName.getValue().toString());
                param.put("RECORDDATE", txtStartDate.getValue().toString() + "  to  " + txtDateTo.getValue().toString());
                reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                servletOutputStream.flush();
                servletOutputStream.close();
                // Stop resend
                FacesContext.getCurrentInstance().responseComplete();
            } catch (Exception ex) {
                ex.printStackTrace();
            //  ErrorLogWriter.writeError(ex);
            }
        } catch (Exception e) {
        }
        return null;



    //return null means stay on the same page

    }

    private void checkobject() {
        if (attendanceReportManager == null) {
            attendanceReportManager = new AttendanceReportManager();
        }
    }

    public String button1_action() {
        generateReport();
        //return null means stay on the same page
        return null;
    }

    public void calDateFrom_processValueChange(ValueChangeEvent vce) {
        try {
            txtStartDate.setValue(dateformatter.format(vce.getNewValue()));
            calDateFrom.setRendered(false);
        } catch (Exception e) {
        }
    }

    public void calDateTo_processValueChange(ValueChangeEvent vce) {
        try {
            txtDateTo.setValue(dateformatter.format(vce.getNewValue()));
            calDateTo.setRendered(false);
        } catch (Exception e) {
        }
    }

    public String button4_action() {
        calDateTo.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String button3_action() {
        calDateFrom.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void cmdTree_processAction(ActionEvent ae) {
        try {
            String departmentName;
            String department = treeDepartment.getCurrentNode().toString();//.substring(0, 2);
            String _department[] = department.split("#");
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID =
                        Integer.parseInt(_department[1].trim());
                lblDepartmentName.setValue(departmentName);
                panTreeHolder.setRendered(false);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public String btnTree_action() {
        panTreeHolder.setRendered(true);
        //return null means stay on the same page
        return null;
    }
}
