/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import entity.leaveEntity.ReserveLeave;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.JodanTimeCalender;
import manager.leaveManager.LeaveBalanceManager;
import manager.leaveManager.ReserveLeaveManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ReserveLeaveRequestPage extends AbstractPageBean {

    private ArrayList<AvilebelLeave> avilebelLeaveList = new ArrayList<AvilebelLeave>();
    private ArrayList<SelectItem> recommendedYear = new ArrayList<SelectItem>();
    private EmployeeManage employeeManager = new EmployeeManage();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private ReserveLeaveManager reserveLeaveManager = new ReserveLeaveManager();
    private LeaveBalanceManager leaveBalanceManager = new LeaveBalanceManager();
    private ReserveLeave reserveLeave = new ReserveLeave();
    private ArrayList<SelectItem> listOfRequestLeaveTransfer = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private byte[] employeePicture;
    private int reserveLeaveTableSize = 0;
    private int countReserveLeave = 0;
    private String leaveId = null;
    private String transferRequestSatus = null;
    private String leaveStatus = null;
    private static String selectedId;

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public ArrayList<SelectItem> getListOfRequestLeaveTransfer() {
        return listOfRequestLeaveTransfer;
    }

    public void setListOfRequestLeaveTransfer(ArrayList<SelectItem> listOfRequestLeaveTransfer) {
        this.listOfRequestLeaveTransfer = listOfRequestLeaveTransfer;
    }

    public ArrayList<SelectItem> getRecommendedYear() {
        return recommendedYear;
    }

    public void setRecommendedYear(ArrayList<SelectItem> recommendedYear) {
        this.recommendedYear = recommendedYear;
    }

    public ArrayList<AvilebelLeave> getAvilebelLeaveList() {
        return avilebelLeaveList;
    }

    public void setAvilebelLeaveList(ArrayList<AvilebelLeave> avilebelLeaveList) {
        this.avilebelLeaveList = avilebelLeaveList;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        setRecommendedYear(reserveLeaveManager.recommendedYear());
        clearComponents();
        disableComponents();
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        txtRequestDate.setDisabled(true);
        calRequestDate.setRendered(false);
        choFemale.setDisabled(true);
        choMale.setDisabled(true);
        txtRequestDate.setValue(dateFormat.format(new Date()));

    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlInputText txtEmployeeID = new HtmlInputText();

    public HtmlInputText getTxtEmployeeID() {
        return txtEmployeeID;
    }

    public void setTxtEmployeeID(HtmlInputText hit) {
        this.txtEmployeeID = hit;
    }
    private HtmlOutputText lblFull_Name = new HtmlOutputText();

    public HtmlOutputText getLblFull_Name() {
        return lblFull_Name;
    }

    public void setLblFull_Name(HtmlOutputText hot) {
        this.lblFull_Name = hot;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlOutputText lblPosition = new HtmlOutputText();

    public HtmlOutputText getLblPosition() {
        return lblPosition;
    }

    public void setLblPosition(HtmlOutputText hot) {
        this.lblPosition = hot;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private HtmlCommandButton btnEmplyeeSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnEmplyeeSearch() {
        return btnEmplyeeSearch;
    }

    public void setBtnEmplyeeSearch(HtmlCommandButton hcb) {
        this.btnEmplyeeSearch = hcb;
    }
    private PanelLayout pnlConfirmationMessageBody = new PanelLayout();

    public PanelLayout getPnlConfirmationMessageBody() {
        return pnlConfirmationMessageBody;
    }

    public void setPnlConfirmationMessageBody(PanelLayout pl) {
        this.pnlConfirmationMessageBody = pl;
    }
    private HtmlPanelGroup panelConfirmationGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelConfirmationGroupMessage() {
        return panelConfirmationGroupMessage;
    }

    public void setPanelConfirmationGroupMessage(HtmlPanelGroup hpg) {
        this.panelConfirmationGroupMessage = hpg;
    }
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage4 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private HtmlOutputText lblServiceYear = new HtmlOutputText();

    public HtmlOutputText getLblServiceYear() {
        return lblServiceYear;
    }

    public void setLblServiceYear(HtmlOutputText hot) {
        this.lblServiceYear = hot;
    }
    private HtmlSelectOneMenu drlLeaveYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLeaveYear() {
        return drlLeaveYear;
    }

    public void setDrlLeaveYear(HtmlSelectOneMenu hsom) {
        this.drlLeaveYear = hsom;
    }
    private HtmlInputText txtAvailableLeaveYear = new HtmlInputText();

    public HtmlInputText getTxtAvailableLeaveYear() {
        return txtAvailableLeaveYear;
    }

    public void setTxtAvailableLeaveYear(HtmlInputText hit) {
        this.txtAvailableLeaveYear = hit;
    }
    private HtmlDataTable dataTable1 = new HtmlDataTable();

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlInputText txtRequestDate = new HtmlInputText();

    public HtmlInputText getTxtRequestDate() {
        return txtRequestDate;
    }

    public void setTxtRequestDate(HtmlInputText hit) {
        this.txtRequestDate = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calRequestDate = new SelectInputDate();

    public SelectInputDate getCalRequestDate() {
        return calRequestDate;
    }

    public void setCalRequestDate(SelectInputDate sid) {
        this.calRequestDate = sid;
    }
    private HtmlSelectOneListbox listOfLeaveTransferRequest = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListOfLeaveTransferRequest() {
        return listOfLeaveTransferRequest;
    }

    public void setListOfLeaveTransferRequest(HtmlSelectOneListbox hsol) {
        this.listOfLeaveTransferRequest = hsol;
    }
    private RowSelector rwSelectorReservedLeave = new RowSelector();

    public RowSelector getRwSelectorReservedLeave() {
        return rwSelectorReservedLeave;
    }

    public void setRwSelectorReservedLeave(RowSelector rs) {
        this.rwSelectorReservedLeave = rs;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox choMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMale() {
        return choMale;
    }

    public void setChoMale(HtmlSelectBooleanCheckbox hsbc) {
        this.choMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox choFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoFemale() {
        return choFemale;
    }

    public void setChoFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.choFemale = hsbc;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate sid) {
        this.calEndDate = sid;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ReserveLeaveRequestPage() {
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

    public static class AvilebelLeave implements Serializable {

        private String avilbelLeveDay;
        private String employeeId;
        private String leaveYear;
        private String leaveId;
        private String requestStatus;
        private boolean selected;
        private String requestDate;
        private String starttDate;
        private String endDate;
        private String remark;

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStarttDate() {
            return starttDate;
        }

        public void setStarttDate(String starttDate) {
            this.starttDate = starttDate;
        }

        public String getRequestDate() {
            return requestDate;
        }

        public void setRequestDate(String requestDate) {
            this.requestDate = requestDate;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getAvilbelLeveDay() {
            return avilbelLeveDay;
        }

        public String getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(String requestStatus) {
            this.requestStatus = requestStatus;
        }

        public void setAvilbelLeveDay(String avilbelLeveDay) {
            this.avilbelLeveDay = avilbelLeveDay;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getLeaveYear() {
            return leaveYear;
        }

        public void setLeaveYear(String leaveYear) {
            this.leaveYear = leaveYear;
        }

        public String getLeaveId() {
            return leaveId;
        }

        public void setLeaveId(String leaveId) {
            this.leaveId = leaveId;
        }

        public AvilebelLeave(
                String avilbelLeveDay,
                String employeeId,
                String leaveYear, String leaveId,
                String transferRequestSatus,
                String requestDate,
                String starttDate,
                String endDate,
                String remark) {
            this.avilbelLeveDay = avilbelLeveDay;
            this.employeeId = employeeId;
            this.leaveYear = leaveYear;
            this.leaveId = leaveId;
            this.requestStatus = transferRequestSatus;
            this.requestDate = requestDate;
            this.starttDate = starttDate;
            this.endDate = endDate;
            this.remark = remark;
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

    public String btnEmplyeeSearch_action() {
        //return null means stay on the same page    
        loadEmployeData(txtEmployeeID.getValue().toString());
        return null;
    }

    void loadEmployeData(String employeeId) {
        clearComponents();
        disableComponents();
        try {
            getAvilebelLeaveList().clear();
            if (txtEmployeeID.getValue().toString() != null) {
                // enableComponets();
                if (employeeManager.loadEmpoyeeProfile(employeeId) == 1) {
//                    requestsLists = leaveMnger.selectLeaveRequests(txtEmployeeID.getValue().toString());
                    btnNew.setDisabled(false);
                    String empStatus = employeeManager.getEmp_Status();
                    this.lblFull_Name.setValue(employeeManager.getTitleDes() + " " +
                            employeeManager.getFirst_Name() + " " +
                            "" + employeeManager.getMiddle_Name() + " " +
                            employeeManager.getLast_Name());
                    String sex = employeeManager.getSex();
                    if (sex.equalsIgnoreCase("Male")) {
                        choFemale.setSelected(false);
                        choMale.setSelected(true);
                    } else if (sex.equalsIgnoreCase("Female")) {
                        choFemale.setSelected(true);
                        choMale.setSelected(false);
                    } else {
                        choFemale.setSelected(false);
                        choMale.setSelected(false);
                    }

                    try {
                        int expYear = employeeManager.calculateEmployeeServiceYearHireDate(
                                employeeManager.getHire_Date());
                        lblServiceYear.setValue(String.valueOf(expYear));
                        lblServiceYear.setValue(String.valueOf(expYear));
                        OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                        setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                        imgEmployeePicture.setValue(getEmployeePicture());
                    } catch (Exception ex) {
                    }
                    lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));
                    this.lblPosition.setValue(employeeManager.getJobDescription());

                    fillTableData();
//
                } else {
//                    clearLeaveInfoTextComponets();
//                    showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");
//                    clearLeaveInfoTextComponets();
//                    clearPersonalInfoTextComponets();
//
                }
            }
        } catch (Exception e) {
        }
    }

    private void requestEmployeeByName(String employeeId) {
        clearComponents();
        disableComponents();
        try {
            getAvilebelLeaveList().clear();
            if (employeeId != null) {
                // enableComponets();
                if (employeeManager.loadEmpoyeeProfile(employeeId) == 1) {
//                    requestsLists = leaveMnger.selectLeaveRequests(txtEmployeeID.getValue().toString());
                    btnNew.setDisabled(false);
                    String empStatus = employeeManager.getEmp_Status();
                    this.lblFull_Name.setValue(employeeManager.getTitleDes() + " " +
                            employeeManager.getFirst_Name() + " " +
                            "" + employeeManager.getMiddle_Name() + " " +
                            employeeManager.getLast_Name());
                    String sex = employeeManager.getSex();
                    if (sex.equalsIgnoreCase("Male")) {
                        choFemale.setSelected(false);
                        choMale.setSelected(true);
                    } else if (sex.equalsIgnoreCase("Female")) {
                        choFemale.setSelected(true);
                        choMale.setSelected(false);
                    } else {
                        choFemale.setSelected(false);
                        choMale.setSelected(false);
                    }

                    try {
                        int expYear = employeeManager.calculateEmployeeServiceYearHireDate(
                                employeeManager.getHire_Date());
                        lblServiceYear.setValue(String.valueOf(expYear));
                        lblServiceYear.setValue(String.valueOf(expYear));
                        OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                        setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                        imgEmployeePicture.setValue(getEmployeePicture());
                    } catch (Exception ex) {
                    }
                    lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));
                    this.lblPosition.setValue(employeeManager.getJobName());
                    fillTableData();
                    txtEmployeeID.setValue(selectedId);
                    txtEmployeeID.setValue(employeeId);
                    loademployeeId();

//
                } else {
//                    clearLeaveInfoTextComponets();
//                    showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");
//                    clearLeaveInfoTextComponets();
//                    clearPersonalInfoTextComponets();
//
                }
            }
        } catch (Exception e) {
        }
    }

    void loademployeeId() {
        txtEmployeeID.setValue(selectedId);

    }

    private void clearComponents() {
        lblFull_Name.setValue("");
        lblDepartment.setValue("");
        lblPosition.setValue("");
        lblServiceYear.setValue("");
        txtAvailableLeaveYear.setValue("");
        imgEmployeePicture.setValue("");
        choFemale.setSelected(false);
        choMale.setSelected(false);
        txtRequestDate.setValue("");
        selectOneMenu1Bean.setSelectedObject(null);
        txtAvailableLeaveYear.setValue("");
        //  calStartDate.resetValue();

        calEndDate.resetValue();
        txtRemark.setValue("");
    }

    private void enableComponets() {
        btnNew.setDisabled(false);
        btnReset.setDisabled(false);
        txtRequestDate.setDisabled(false);
        drlLeaveYear.setDisabled(false);
        txtAvailableLeaveYear.setDisabled(false);
        //  calStartDate.setDisabled(false);
        calEndDate.setDisabled(false);
        txtRemark.setDisabled(false);
    }

    private void disableComponents() {
        txtAvailableLeaveYear.setDisabled(true);
        drlLeaveYear.setDisabled(true);
        btnNew.setDisabled(true);
        btnSave.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(true);
        btnAdd.setDisabled(true);
        txtRequestDate.setDisabled(true);
//        calStartDate.setDisabled(true);
        calEndDate.setDisabled(true);
        txtRemark.setDisabled(true);
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage4.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage4.setValue(messageToDisplay);
        lblFormMessage4.setRendered(true);
        pnConfirmationMessage.setAutoCentre(true);
        pnConfirmationMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnAdd_action() {
        try {
            String startDate;
            String endDate;
            if (validateInputData()) {
                if (istDuplicated()) {
                    if (Float.parseFloat(txtAvailableLeaveYear.getValue().toString()) > 0) {
                        if (txtAvailableLeaveYear.getValue() != null && drlLeaveYear.getValue() != null) {
                            if (transferRequestSatus == null) {
                                transferRequestSatus = "[Wating]";
                            }
                            startDate = dateFormat.format(calStartDate.getValue());
                            endDate = dateFormat.format(calEndDate.getValue());

                            getAvilebelLeaveList().add(new AvilebelLeave(
                                    txtAvailableLeaveYear.getValue().toString(),
                                    txtEmployeeID.getValue().toString(),
                                    drlLeaveYear.getValue().toString(),
                                    leaveId,
                                    transferRequestSatus,
                                    txtRequestDate.getValue().toString(),
                                    startDate,
                                    endDate,
                                    txtRemark.getValue().toString()));
                            leaveId = "";
                            countReserveLeave++;
                            transferRequestSatus = null;
                        }
                    } else {
                        showSuccessOrFailureMessage(false, "Not allowed Request 0 value !");
                    }
                } else {
                    showSuccessOrFailureMessage(false, "Not allowed Request two leave transfer by the same year!");
                }
            } else {
                showSuccessOrFailureMessage(false, "Your input date is invalid. Please correct the input data and try again ?");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    boolean istDuplicated() {
        try {
            for (AvilebelLeave avilebelLeave : getAvilebelLeaveList()) {
                if (avilebelLeave.getLeaveYear().equals(drlLeaveYear.getValue().toString())) {
                    return false;
                }
            }
            return reserveLeaveManager.isRquestBythis(txtEmployeeID.getValue().toString(),
                    drlLeaveYear.getValue().toString());
        } catch (Exception e) {
            e.printStackTrace();

        }
        return true;
    }

    boolean validateInputData() {
        boolean result = true;

        int errorValue = 0;
        String errorMessage = "Required";
        errorValue = HRValidation.validateData(this.txtRequestDate.getValue(), HRValidation.DATE_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtRequestDate).setValid(false);
                error(txtRequestDate, errorMessage);
            } else {
                ((UIInput) txtRequestDate).setValid(false);
                error(txtRequestDate, "Invalid Value");
            }
        }
        errorValue = HRValidation.validateData(this.txtAvailableLeaveYear.getValue(), HRValidation.FLOAT_PATTERN, true);
        if (errorValue != 0) {

            result = false;
            if (errorValue == 1) {
                ((UIInput) txtAvailableLeaveYear).setValid(false);
                error(txtAvailableLeaveYear, errorMessage);
            } else {
                ((UIInput) txtAvailableLeaveYear).setValid(false);
                error(txtAvailableLeaveYear, "Invalid Value");
            }
        }
        errorValue = HRValidation.validateData(this.txtRemark.getValue(), HRValidation.REMARK_PATTERN, false);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtRemark).setValid(false);
            error(txtRemark, "Invalid Value");

        }




        if (!HRValidation.validateRequired(this.drlLeaveYear.getValue())) {
            result = false;
            ((UIInput) drlLeaveYear).setValid(false);
            error(drlLeaveYear, errorMessage);
        }

        Date satrtDate = (Date) calStartDate.getValue();
        Date endDate = (Date) calEndDate.getValue();
        if (endDate.before(satrtDate)) {
            result = false;
        }


        return result;
    }

    public String btnNew_action() {
        if (HRValidation.validateRequired(txtEmployeeID.getValue())) {
            if (reserveLeaveManager.checkLeaveTransferStatus(txtEmployeeID.getValue().toString())) {
                btnAdd.setDisabled(false);
                btnSave.setDisabled(false);
                //  drlLeaveYear.setDisabled(false);
                txtAvailableLeaveYear.setDisabled(false);
                //   drlLeaveYear.setValue("0");
                txtAvailableLeaveYear.setValue("");
                enableComponets();
                btnNew.setDisabled(true);
            } else {
                showSuccessOrFailureMessage(false, "Please wait until your request gets a response!!!");
            }
        } else {
            showSuccessOrFailureMessage(false, "Please Select  EMPLOYEE first?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {
        if (validateLeaveTransferData()) {
            ArrayList<HashMap> researveList = new ArrayList<HashMap>();
            if (dataTable1.getRowCount() > 0) {
                for (AvilebelLeave avilebeLeave : getAvilebelLeaveList().subList(
                        (reserveLeaveTableSize), (reserveLeaveTableSize + countReserveLeave))) {
                    HashMap _list = new HashMap();
                    _list.put("employeeId", avilebeLeave.getEmployeeId());
                    _list.put("avilbelLeveDay", avilebeLeave.getAvilbelLeveDay());
                    _list.put("leaveYear", avilebeLeave.getLeaveYear());
                    _list.put("startDate", avilebeLeave.getStarttDate());
                    _list.put("ednDate", avilebeLeave.getEndDate());
                    _list.put("remark", avilebeLeave.getRemark());
                    researveList.add(_list);
                    countReserveLeave = 0;
                }
                if (researveList.size() > 0) {
                    if (reserveLeaveManager.saveReserveLeave(researveList, txtRequestDate.getValue().toString())) {
                        showSuccessOrFailureMessage(true, "THE RESERVED LEAVE INFORMATION SUCCESSFULLY SAVED.");
                        disableComponents();
                        btnNew.setDisabled(false);

                    } else {
                        showSuccessOrFailureMessage(false, "THE RESERVED LEAVE INFORMATION NOT SAVED. PLEASE TRY AGAIN ?");
                    }
                } else {
                    showSuccessOrFailureMessage(false, "RESERVED LEAVE TABLE IS EMPTY." +
                            " Please Insert Reserved Leave Information In To the Table?");
                }
            }
        }
        //return null means stay on the same page
        return null;

    }

    boolean validateLeaveTransferData() {
        boolean result = true;
        if (!HRValidation.validateRequired(txtRequestDate.getValue())) {
            ((UIInput) txtRequestDate).setValid(false);
            error(txtRequestDate, "Required");
            result = false;
        }
        return result;
    }

    /**
     * The method use employeeid and display employee unusedLeave in the table
    
     */
    private void fillTableData() {
        try {
            ArrayList<HashMap> listOfEmployeeUnusedLeave =
                    reserveLeaveManager.readReserveLeave(txtEmployeeID.getValue().toString());

            if (listOfEmployeeUnusedLeave.size() > 0) {
                countReserveLeave = 0;
                getAvilebelLeaveList().clear();
                for (HashMap hm : listOfEmployeeUnusedLeave) {
                    getAvilebelLeaveList().add(new AvilebelLeave(
                            hm.get("AVAILABLELEAVENUMBER").toString(),
                            hm.get("EMP_ID").toString(),
                            hm.get("LEAVEYEAR").toString(),
                            hm.get("ID").toString(),
                            transferRequestSatus,
                            hm.get("REQUEST_DATE").toString(),
                            hm.get("ID").toString(),
                            hm.get("ID").toString(),
                            hm.get("ID").toString()));
                    reserveLeaveTableSize++;
                }
            }
            setListOfRequestLeaveTransfer(reserveLeaveManager.selectLeaveTransferRequests(txtEmployeeID.getValue().toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rwSelectorReservedLeave_processMyEvent(RowSelectorEvent rse) {
        try {
            int row = dataTable1.getRowIndex();
            if (row > -1) {
                leaveStatus = getAvilebelLeaveList().get(row).getRequestStatus();
                if (leaveStatus != null) {
                    //leaveStatus = leaveStatus.substring(0, 3);
                    selectOneMenu1Bean.setSelectedObject(null);
                    if (!leaveStatus.equals("Approved") || !leaveStatus.equals("Rejected")) {

                        txtAvailableLeaveYear.resetValue();
                        txtRemark.resetValue();
                        drlLeaveYear.setValue(getAvilebelLeaveList().get(row).getLeaveYear());
                        txtAvailableLeaveYear.setValue(getAvilebelLeaveList().
                                get(row).getAvilbelLeveDay());
                        leaveId = getAvilebelLeaveList().get(row).getLeaveId();
                        txtRequestDate.setValue(getAvilebelLeaveList().
                                get(row).getRequestDate());
                        leaveStatus = getAvilebelLeaveList().get(row).getRequestStatus();
                        txtRemark.setValue(getAvilebelLeaveList().get(row).getRemark());
                        calEndDate.setValue(dateFormat.parse(getAvilebelLeaveList().get(row).getEndDate()));
                        calStartDate.setValue(dateFormat.parse(getAvilebelLeaveList().get(row).getStarttDate()));



//                
                        btnSave.setDisabled(true);
                        btnDelete.setDisabled(false);
                        btnUpdate.setDisabled(false);
                        btnReset.setDisabled(false);
                        btnAdd.setDisabled(true);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String btnUpdate_action() {
        if (validateInputData()) {

            String startDate = dateFormat.format(calStartDate.getValue());
            String endDate = dateFormat.format(calEndDate.getValue());
            String remark = "not register";
            if (HRValidation.validateRequired(txtRemark.getValue())) {
                remark = txtRemark.getValue().toString();
            }
            if (reserveLeaveManager.updatReserveLeave(
                    drlLeaveYear.getValue().toString(),
                    txtAvailableLeaveYear.getValue().toString(),
                    txtEmployeeID.getValue().toString(),
                    leaveId,
                    leaveStatus,
                    startDate,
                    endDate,
                    remark)) {
                showSuccessOrFailureMessage(true, "THE RESERVED LEAVE INFORMATION UPDATED SUCCESSFULLY.");
                fillTableData();
                btnAdd.setDisabled(true);
                btnNew.setDisabled(false);
                btnSave.setDisabled(true);
                btnDelete.setDisabled(true);
                btnUpdate.setDisabled(true);
                btnReset.setDisabled(false);
                drlLeaveYear.setDisabled(true);
                txtAvailableLeaveYear.setDisabled(true);
                drlLeaveYear.setValue("0");
                txtAvailableLeaveYear.setValue("");
                getAvilebelLeaveList().clear();


            } else {
                //duplicated
                showSuccessOrFailureMessage(false, "Not allowed Request two leave transfer by the same year!");
            }

        } else {
            //input error
            showSuccessOrFailureMessage(false, "Your input date is invalid. Please correct the input data and try again ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnReset_action() {
        btnAdd.setDisabled(true);
        btnNew.setDisabled(false);
        btnSave.setDisabled(true);
        btnDelete.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnReset.setDisabled(true);
        drlLeaveYear.setDisabled(true);
        txtAvailableLeaveYear.setDisabled(true);
        drlLeaveYear.setValue("0");
        txtAvailableLeaveYear.setValue("");
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        if (reserveLeaveManager.deleteReserveLeave(txtEmployeeID.getValue().toString(), leaveId)) {
            showSuccessOrFailureMessage(true, "THE RESERVED LEAVE INFORMATION DELETED SUCCESSFULLY.");
            btnAdd.setDisabled(true);
            btnNew.setDisabled(false);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnReset.setDisabled(true);
            drlLeaveYear.setDisabled(true);
            txtAvailableLeaveYear.setDisabled(true);
            drlLeaveYear.setValue("0");
            txtAvailableLeaveYear.setValue("");

            fillTableData();

            reserveLeaveTableSize--;

        } else {
            showSuccessOrFailureMessage(false, "THE RESERVED LEAVE INFORMATION NOT DELETED .PLEASE TRY AGAIN ?");
        }
//return null means stay on the same page

        return null;
    }

    public void drlLeaveYear_processValueChange(ValueChangeEvent vce) {
        try {


            if (vce.getNewValue() != null) {

                txtAvailableLeaveYear.setValue(Float.toString(leaveBalanceManager.readEmployeeLeaveBalance(
                        txtEmployeeID.getValue().toString(),
                        vce.getNewValue().toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String btnCalender_action() {
        calRequestDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calRequestDate_processValueChange(ValueChangeEvent vce) {
        txtRequestDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calRequestDate.setRendered(false);
    }

    public void listOfLeaveTransferRequest_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                btnNew.setDisabled(true);
                getAvilebelLeaveList().clear();
                String listOfRequest[] = vce.getNewValue().toString().split("=");
                loadEmployeeLeaveTransferRequest(listOfRequest);
//            ArrayList<HashMap> listOfRequestData = reserveLeave.readEmployeeLeaveTransferRequest(
//                    listOfRequest[2],
//                    listOfRequest[1],
//                    listOfRequest[0]);
//            for (HashMap hm : listOfRequestData) {
//                getAvilebelLeaveList().add(new AvilebelLeave(
//                        hm.get("AVAILABLEAVEDAYS").toString(),
//                        hm.get("EMP_ID").toString(),
//                        hm.get("LEAVEYEAR").toString(),
//                        hm.get("RESERVELAVEID").toString(),
//                        hm.get("STATUS").toString(),
//                        hm.get("REQUEST_DATE").toString()));
//            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadEmployeeLeaveTransferRequest(String listOfRequest[]) {
        try {
            if (listOfRequest != null) {

                getAvilebelLeaveList().clear();
                ArrayList<HashMap> listOfRequestData = reserveLeave.readEmployeeLeaveTransferRequest(
                        listOfRequest[2],
                        listOfRequest[1],
                        listOfRequest[0]);
                int error = 0;
                int index = 0;
                String status = "";
                for (HashMap hm : listOfRequestData) {
                    error = HRValidation.validateData(hm.get("STATUS"), HRValidation.NUMBER_PATTERN, true);
                    if (error == 0) {
                        status = "Waiting";
                        btnNew.setDisabled(true);
                    } else {
                        index = hm.get("STATUS").toString().indexOf("-");
                        if (index > 0) {
                            if (hm.get("STATUS").toString().substring(0, index).equals("App")) {
                                status = "Approved";
                                rwSelectorReservedLeave.setRendered(false);
                            } else if (hm.get("STATUS").toString().substring(0, index).equals("Rej")) {
                                status = "Rejected";
                                rwSelectorReservedLeave.setRendered(false);
                            } else if (hm.get("STATUS").toString().substring(0, index).equals("Res")) {
                                status = "Resubmit";
                            }

                        }else{
                             status = "Waiting";
                        }
                    }
                   
                    getAvilebelLeaveList().add(new AvilebelLeave(
                            hm.get("AVAILABLEAVEDAYS").toString(),
                            hm.get("EMP_ID").toString(),
                            hm.get("LEAVEYEAR").toString(),
                            hm.get("RESERVELAVEID").toString(),
                            status,
                            hm.get("REQUEST_DATE").toString(),
                            hm.get("startDate").toString(),
                            hm.get("ednDate").toString(),
                            hm.get("remark").toString()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String txtSearchByName_action() {

        selectedId = null;
        selectedId = ApplicationBean1.getSelectedEmployeeId();
        if (selectedId != null) {
            txtEmployeeID.resetValue();
            requestEmployeeByName(ApplicationBean1.getSelectedEmployeeId());
        }
//         txtEmployeeID.setDisabled(false);
//return null means stay on the same page

        return null;
    }

    public String btnEdit_action() {
        enableComponets();
        btnUpdate.setDisabled(false);
        btnAdd.setDisabled(true);
        btnDelete.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public String lnkLeaveRequest_action() {
        //return null means stay on the same page
        return "LeaveRequest";
    }

    public String lnkPayrollSetUp_action() {
        //return null means stay on the same page
        return "LeaveApprove";
    }

    public String lnkAccrualEntries_action() {
        //return null means stay on the same page
        return "LeaveTransferRequest";
    }

    public String lnkGovernmentDeductions_action() {
        //return null means stay on the same page
        return null;
    }
}