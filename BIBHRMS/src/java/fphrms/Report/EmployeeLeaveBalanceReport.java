/*
 * EmployeeLeaveReport.java
 *
 * Created on Jul 30, 2012, 11:33:58 PM
 * Copyright PROJECT
 */
package fphrms.Report;

import com.sun.codemodel.JOp;
import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.leaveManager.LeaveBalanceManager;
import manager.reporterManager.leaveReportManager.LeaveReportManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeLeaveBalanceReport extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private TableDataModel tableDataModel = new TableDataModel();
    LeaveReportManager leaveReportManager = new LeaveReportManager();
    private boolean firstTime = true;
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        if (firstTime) {
            loadReport();
            firstTime = false;
        }
    }
    private LeaveBalanceManager leaveBalanceManager = new LeaveBalanceManager();
    public String[] expTotal;
    public float result;
    public String TotalAsfoToday;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private void loadReport()
      {
        String employeeID;
        String hireDate=null;
        String currentDate = dateFormat.format(new Date());
        int currentYear = GregorianCalendarManipulation.getYear(currentDate);

        try {

            ArrayList<HashMap> listOfLeaveRequest = leaveReportManager.getEmployeeLeaveBalancee();
            getListOfEmployeeLeaveRequest().clear();

            for (HashMap hm : listOfLeaveRequest)
            {
        hireDate=  hm.get("HIREDATE").toString();
        expTotal = GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceReturnTypeArrayListForLeave(hireDate, currentDate);
        int Dates = Integer.parseInt(expTotal[0]);
        int months = Integer.parseInt(expTotal[1]);
        int years = Integer.parseInt(expTotal[2]);
        int monthToDays = (months * 30);
        int totalDays = (monthToDays + Dates);
        int lastLeaveBalanceYear = (currentYear - 1);
        float lastLeaveAmount = 0;
        float nextyearLeaveAmount=0;
        int commingLeaveAmount;
        float devidend;
        float divisor = 365;
        float totalasofToday = 0;
        String remaing;
            employeeID=  hm.get("EMPLOYEEID").toString();
            lastLeaveAmount = leaveBalanceManager.SelectLastBalanceOFEmployee(employeeID);
            if(years==0){
               
            TotalAsfoToday=String.valueOf(lastLeaveAmount);
            }
            else{
            nextyearLeaveAmount = (lastLeaveAmount + 1);
            
            devidend = (totalDays * nextyearLeaveAmount);
            result = (devidend / divisor);
            remaing = hm.get("TOTALBALANCE").toString();
            Float reme = new Float(remaing);
            totalasofToday = (reme + result);

             TotalAsfoToday=String.valueOf(totalasofToday);
            }
                getListOfEmployeeLeaveRequest().add(new TableDataModel(
                        hm.get("EMPLOYEEID").toString(),
                        hm.get("FULLNAME").toString(),
                        hm.get("SALARY").toString(),
                        hm.get("DEPARTMENTNAME").toString(),
                        hm.get("JOBNAME").toString(),
                        hm.get("USEDLEAVEBALANCE").toString(),
                        TotalAsfoToday,
                        hm.get("HIREDATE").toString(),
                        "Annual",
                        hm.get("TOTALBALANCE").toString()));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (HashMap hm : listOfLeaveRequest) {

//        }


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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeLeaveBalanceReport() {
    }
    private ArrayList<TableDataModel> listOfEmployeeLeaveRequest = new ArrayList<TableDataModel>();

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
            log("EmployeeLeaveReport Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public static class TableDataModel {

        private String employeeId;
        private String employeeFullName;
        private String sex;
        private String leaveType;
        private String phisicalLeaveYearFirst;
        private String phisicalLeaveYearSecond;
        private String organizationHead;
        private String department;
        private String team;
        private String totalAvilabelLeave;
        private String hireDate;
        private String salary;
        private String departmentName;
        private String jobName;
        private String usedLeveBalance;
        private String totalAmountBalance;

        public TableDataModel() {
        }

        public TableDataModel(String employeeId,
                String employeeFullName,
                String salary,
                String departmentt,
                String jobName,
                String usedBalance,
                String TotalBalance,
                String hirDate,
                String team,
                String totalAvilabelLeave) {
            this.employeeId = employeeId;
            this.employeeFullName = employeeFullName;
            this.salary= salary;
            this.departmentName = departmentt;
            this.jobName = jobName;
            this.usedLeveBalance = usedBalance;
            this.totalAmountBalance = TotalBalance;
            this.hireDate = hirDate;
            this.team = team;
            this.totalAvilabelLeave = totalAvilabelLeave;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getTotalAmountBalance() {
            return totalAmountBalance;
        }

        public void setTotalAmountBalance(String totalAmountBalance) {
            this.totalAmountBalance = totalAmountBalance;
        }

        public String getUsedLeveBalance() {
            return usedLeveBalance;
        }

        public void setUsedLeveBalance(String usedLeveBalance) {
            this.usedLeveBalance = usedLeveBalance;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmployeeFullName() {
            return employeeFullName;
        }

        public void setEmployeeFullName(String employeeFullName) {
            this.employeeFullName = employeeFullName;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getLeaveType() {
            return leaveType;
        }

        public void setLeaveType(String leaveType) {
            this.leaveType = leaveType;
        }

        public String getOrganizationHead() {
            return organizationHead;
        }

        public void setOrganizationHead(String organizationHead) {
            this.organizationHead = organizationHead;
        }

        public String getPhisicalLeaveYearFirst() {
            return phisicalLeaveYearFirst;
        }

        public void setPhisicalLeaveYearFirst(String phisicalLeaveYearFirst) {
            this.phisicalLeaveYearFirst = phisicalLeaveYearFirst;
        }

        public String getPhisicalLeaveYearSecond() {
            return phisicalLeaveYearSecond;
        }

        public void setPhisicalLeaveYearSecond(String phisicalLeaveYearSecond) {
            this.phisicalLeaveYearSecond = phisicalLeaveYearSecond;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getTotalAvilabelLeave() {
            return totalAvilabelLeave;
        }

        public void setTotalAvilabelLeave(String totalAvilabelLeave) {
            this.totalAvilabelLeave = totalAvilabelLeave;
        }
    }

    public ArrayList<TableDataModel> getListOfEmployeeLeaveRequest() {
        return listOfEmployeeLeaveRequest;
    }

    public void setListOfEmployeeLeaveRequest(ArrayList<TableDataModel> listOfEmployeeLeaveRequest) {
        this.listOfEmployeeLeaveRequest = listOfEmployeeLeaveRequest;
    }
}

