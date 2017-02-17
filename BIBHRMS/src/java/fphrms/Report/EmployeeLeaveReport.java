/*
 * EmployeeLeaveReport.java
 *
 * Created on Jul 30, 2012, 11:33:58 PM
 * Copyright PROJECT
 */
package fphrms.Report;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import java.util.HashMap;
import manager.reporterManager.leaveReportManager.LeaveReportManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeLeaveReport extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private TableDataModel tableDataModel = new TableDataModel();
    LeaveReportManager leaveReportManager = new LeaveReportManager();
    private int __placeholder;
    private boolean firstTime = true;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private void loadReport() {


        String organizationHead = "";
        String department = "";
        String team = "";
        String shift = "";
        String office = "";

//                String approveDate) {
        try {
            ArrayList<HashMap> listOfLeaveRequest = leaveReportManager.getEmployeeLeaveRequest();
            getListOfEmployeeLeaveRequest().clear();
            for (HashMap hm : listOfLeaveRequest) {
                if (hm.get("OFFICE_OR_SHIFT").toString().equals("Office")) {
                    office = "√";
                    shift = "";
                } else {
                    shift = "√";
                    office = "";
                }
                getListOfEmployeeLeaveRequest().add(new TableDataModel(
                        hm.get("EMPLOYEEID").toString(),
                        hm.get("FULLNAME").toString(),
                        hm.get("SEX").toString(),
                        "",
                        hm.get("departmentName").toString(),
                        hm.get("jobName").toString(),
                       "",
                       "",
                        hm.get("LEAVETYPE").toString(),
                        hm.get("REQUESTED_DATE").toString(),
                        office,
                        shift,
                         hm.get("REQUESTING_REASON").toString(),
                        organizationHead,
                        department,
                        team,                    
                        hm.get("LEAVE_DAYS").toString(),
                        hm.get("FROMTO").toString(),
                        hm.get("REQUESTING_REASON").toString(),
                        hm.get("REQUESTED_DATE").toString()
                        ));

//                tableDataModel.setEmployeeId();
//                tableDataModel.setEmployeeFullName();
//                tableDataModel.setSex(hm.get("SEX").toString());
//                tableDataModel.setAddressType();
//                tableDataModel.setKebelleName();
//                tableDataModel.setMobile(hm.get("MOBILE").toString());
//                tableDataModel.setTelephoneResidence(hm.get("TELEPHONE_RESIDENCE").toString());
//                tableDataModel.setWoredaSubCity(hm.get("WOREDA_OR_SUBCITY_ID").toString());
                tableDataModel.setLeaveType(hm.get("LEAVETYPE").toString());
                tableDataModel.setRequestDate(hm.get("REQUESTED_DATE").toString());

                tableDataModel.setReason(hm.get("REQUESTING_REASON").toString());
                tableDataModel.setLeaveDays(hm.get("LEAVE_DAYS").toString());
                tableDataModel.setLeaveFromTo(hm.get("FROMTO").toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
    public EmployeeLeaveReport() {
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
        if (firstTime) {
            firstTime = false;
            loadReport();
        }
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
        private String offceOrShift;  //OFFICE_OR_SHIFT
        private String addressType;
        private String kebelleName;
        private String mobile;
        private String telephoneResidence;
        private String woredaSubCity;
        private String leaveType;
        private String requestDate;
        private String office;
        private String shift;
        private String reason;
        private String organizationHead;
        private String department;
        private String team;
        private String leaveYear;
        private String leaveDays;
        private String leaveFromTo;
        private String approveDate;

        public TableDataModel() {
        }

        public TableDataModel(
                String employeeId,
                String employeeFullName,
                String sex,
                String addressType,
                String kebelleName,
                String mobile,
                String telephoneResidence,
                String woredaSubCity,
                String leaveType,
                String requestDate,
                String office,
                String shift,
                String reason,
                String organizationHead,
                String department,
                String team,
                String leaveYear,
                String leaveDays,
                String leaveFromTo,
                String approveDate) {
            this.employeeId = employeeId;
            this.employeeFullName = employeeFullName;
            this.sex = sex;

            this.addressType = addressType;
            this.kebelleName = kebelleName;
            this.mobile = mobile;
            this.telephoneResidence = telephoneResidence;
            this.woredaSubCity = woredaSubCity;
            this.leaveType = leaveType;
            this.requestDate = requestDate;
            this.office = office;
            this.shift = shift;
            this.reason = reason;
            this.organizationHead = organizationHead;
            this.department = department;
            this.team = team;
            this.leaveYear = leaveYear;
            this.leaveDays = leaveDays;
            this.leaveFromTo = leaveFromTo;
            this.approveDate = approveDate;
        }

        public String getApproveDate() {
            return approveDate;
        }

        public void setApproveDate(String approveDate) {
            this.approveDate = approveDate;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getLeaveDays() {
            return leaveDays;
        }

        public void setLeaveDays(String leaveDays) {
            this.leaveDays = leaveDays;
        }

        public String getLeaveFromTo() {
            return leaveFromTo;
        }

        public void setLeaveFromTo(String leaveFromTo) {
            this.leaveFromTo = leaveFromTo;
        }

        public String getLeaveYear() {
            return leaveYear;
        }

        public void setLeaveYear(String leaveYear) {
            this.leaveYear = leaveYear;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public String getOrganizationHead() {
            return organizationHead;
        }

        public void setOrganizationHead(String organizationHead) {
            this.organizationHead = organizationHead;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getRequestDate() {
            return requestDate;
        }

        public void setRequestDate(String requestDate) {
            this.requestDate = requestDate;
        }

        public String getShift() {
            return shift;
        }

        public void setShift(String shift) {
            this.shift = shift;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getAddressType() {
            return addressType;
        }

        public void setAddressType(String addressType) {
            this.addressType = addressType;
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

        public String getKebelleName() {
            return kebelleName;
        }

        public void setKebelleName(String kebelleName) {
            this.kebelleName = kebelleName;
        }

        public String getLeaveType() {
            return leaveType;
        }

        public void setLeaveType(String leaveType) {
            this.leaveType = leaveType;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOffceOrShift() {
            return offceOrShift;
        }

        public void setOffceOrShift(String offceOrShift) {
            this.offceOrShift = offceOrShift;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getTelephoneResidence() {
            return telephoneResidence;
        }

        public void setTelephoneResidence(String telephoneResidence) {
            this.telephoneResidence = telephoneResidence;
        }

        public String getWoredaSubCity() {
            return woredaSubCity;
        }

        public void setWoredaSubCity(String woredaSubCity) {
            this.woredaSubCity = woredaSubCity;
        }
    }

    public ArrayList<TableDataModel> getListOfEmployeeLeaveRequest() {
        return listOfEmployeeLeaveRequest;
    }

    public void setListOfEmployeeLeaveRequest(ArrayList<TableDataModel> listOfEmployeeLeaveRequest) {
        this.listOfEmployeeLeaveRequest = listOfEmployeeLeaveRequest;
    }
}

