/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.employeeHistoryManager.ReturntoJobManager;
import manager.employeeManager.EmployeeManage;
import manager.leaveManager.ExtendLeaveManager;
import manager.leaveManager.LeaveControl;
import manager.leaveManager.LeaveRequestManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ExtendLeavePage extends AbstractPageBean {

    private LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<SelectItem> listOfEmployeeLeave = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String employeeId = null;
    private String leaveRequestId = null;
    private byte[] employeePicture;
    private EmployeeManage employeeManager = new EmployeeManage();
    ReturntoJobManager returntoJobManager = new ReturntoJobManager();
    private LeaveControl leaveManager = new LeaveControl();
    private ExtendLeaveManager extendLeaveManager = new ExtendLeaveManager();
     String returnDate = null;

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public ArrayList<SelectItem> getListOfEmployeeLeave() {
        return listOfEmployeeLeave;
    }

    public void setListOfEmployeeLeave(ArrayList<SelectItem> listOfEmployeeLeave) {
        this.listOfEmployeeLeave = listOfEmployeeLeave;
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
    private HtmlSelectOneListbox lstEmployeeOnLeave = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstEmployeeOnLeave() {
        return lstEmployeeOnLeave;
    }

    public void setLstEmployeeOnLeave(HtmlSelectOneListbox hsol) {
        this.lstEmployeeOnLeave = hsol;
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
    private HtmlOutputText lblFull_Name = new HtmlOutputText();

    public HtmlOutputText getLblFull_Name() {
        return lblFull_Name;
    }

    public void setLblFull_Name(HtmlOutputText hot) {
        this.lblFull_Name = hot;
    }
    private HtmlInputText txtEmployeeID = new HtmlInputText();

    public HtmlInputText getTxtEmployeeID() {
        return txtEmployeeID;
    }

    public void setTxtEmployeeID(HtmlInputText hit) {
        this.txtEmployeeID = hit;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlSelectBooleanCheckbox chkMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMale() {
        return chkMale;
    }

    public void setChkMale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkFemale() {
        return chkFemale;
    }

    public void setChkFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkFemale = hsbc;
    }
    private HtmlSelectBooleanCheckbox choOffice = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoOffice() {
        return choOffice;
    }

    public void setChoOffice(HtmlSelectBooleanCheckbox hsbc) {
        this.choOffice = hsbc;
    }
    private HtmlSelectBooleanCheckbox choShift = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoShift() {
        return choShift;
    }

    public void setChoShift(HtmlSelectBooleanCheckbox hsbc) {
        this.choShift = hsbc;
    }
    private HtmlSelectBooleanCheckbox choAddisAbeba = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoAddisAbeba() {
        return choAddisAbeba;
    }

    public void setChoAddisAbeba(HtmlSelectBooleanCheckbox hsbc) {
        this.choAddisAbeba = hsbc;
    }
    private HtmlSelectBooleanCheckbox choMugher = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMugher() {
        return choMugher;
    }

    public void setChoMugher(HtmlSelectBooleanCheckbox hsbc) {
        this.choMugher = hsbc;
    }
    private HtmlOutputText lblLeaveTypeDes = new HtmlOutputText();

    public HtmlOutputText getLblLeaveTypeDes() {
        return lblLeaveTypeDes;
    }

    public void setLblLeaveTypeDes(HtmlOutputText hot) {
        this.lblLeaveTypeDes = hot;
    }
    private HtmlOutputText lblLeaveEndDate = new HtmlOutputText();

    public HtmlOutputText getLblLeaveEndDate() {
        return lblLeaveEndDate;
    }

    public void setLblLeaveEndDate(HtmlOutputText hot) {
        this.lblLeaveEndDate = hot;
    }
    private HtmlInputText txtDateFrom = new HtmlInputText();

    public HtmlInputText getTxtDateFrom() {
        return txtDateFrom;
    }

    public void setTxtDateFrom(HtmlInputText hit) {
        this.txtDateFrom = hit;
    }
    private HtmlCommandButton btnCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalender() {
        return btnCalender;
    }

    public void setBtnCalender(HtmlCommandButton hcb) {
        this.btnCalender = hcb;
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
    private HtmlOutputText lblLeaveStartDateDis = new HtmlOutputText();

    public HtmlOutputText getLblLeaveStartDateDis() {
        return lblLeaveStartDateDis;
    }

    public void setLblLeaveStartDateDis(HtmlOutputText hot) {
        this.lblLeaveStartDateDis = hot;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calLeaveStartDate = new SelectInputDate();

    public SelectInputDate getCalLeaveStartDate() {
        return calLeaveStartDate;
    }

    public void setCalLeaveStartDate(SelectInputDate sid) {
        this.calLeaveStartDate = sid;
    }
    private HtmlInputText txtLeaveDays = new HtmlInputText();

    public HtmlInputText getTxtLeaveDays() {
        return txtLeaveDays;
    }

    public void setTxtLeaveDays(HtmlInputText hit) {
        this.txtLeaveDays = hit;
    }
    private HtmlInputText txtDateTo = new HtmlInputText();

    public HtmlInputText getTxtDateTo() {
        return txtDateTo;
    }

    public void setTxtDateTo(HtmlInputText hit) {
        this.txtDateTo = hit;
    }
    private HtmlOutputText txtReturnDateFromLeave = new HtmlOutputText();

    public HtmlOutputText getTxtReturnDateFromLeave() {
        return txtReturnDateFromLeave;
    }

    public void setTxtReturnDateFromLeave(HtmlOutputText hot) {
        this.txtReturnDateFromLeave = hot;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ExtendLeavePage() {
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
        loadListEmployeeOnLeave();
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

    private void loadListEmployeeOnLeave() {
        try {
               setListOfEmployeeLeave(leaveManager.getEmployeeOnAnnualLeave());
        } catch (Exception e) {
        }
    

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

    public String lnkResignApprovePage_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkClearancePage_action() {
        //return null means stay on the same page
        return null;
    }

    public void clearReturnToJobTextComponents() {
        txtDateFrom.resetValue();
        lblLeaveEndDate.setValue("");
        lblFull_Name.setValue("");
        lblDepartment.setValue("");
        lblPosition.setValue("");
        chkMale.setSelected(false);
        chkFemale.setSelected(false);
        choOffice.setSelected(false);
        choShift.setSelected(false);
        choAddisAbeba.setSelected(false);
        choMugher.setSelected(false);
        lblLeaveTypeDes.setValue("");
        lblLeaveEndDate.setValue("");

        txtDateFrom.setValue("");
        imgEmployeePicture.setValue("");

    }

    public void lstEmployeeOnLeave_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                String listValue[] = vce.getNewValue().toString().split("-");
                txtEmployeeID.setValue(listValue[0]);
                employeeId = listValue[0];
//                leaveType = listValue[1];
                leaveRequestId = listValue[2];
                displayEployee(leaveRequestId);
//                btnSave.setDisabled(true);
//                btnCalender.setRendered(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void displayEployee(String leaveId) {
        try {
            String sex = "";
            String empStatus = "";
            String leaveDays = "";
            if (employeeId != null) {

                if (employeeManager.loadEmpoyeeProfile(employeeId) == 1) {
                    if (!employeeManager.getEmp_Status().equals("01")) {

                        this.lblFull_Name.setValue(employeeManager.getTitleDes() + " " +
                                employeeManager.getFirst_Name() + " " +
                                "" + employeeManager.getMiddle_Name() + " " +
                                employeeManager.getLast_Name());
                        empStatus = employeeManager.getEmp_Status();
                        sex = employeeManager.getSex();
                        try {
                            OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                            setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                            imgEmployeePicture.setValue(getEmployeePicture());
                        } catch (Exception ex) {
                        }
                        if (sex.equalsIgnoreCase("Male")) {
                            chkMale.setSelected(true);
                            chkFemale.setSelected(false);
                        } else if (sex.equalsIgnoreCase("Female")) {
                            chkFemale.setSelected(true);
                            chkMale.setSelected(false);
                        } else {
                            chkMale.setSelected(false);
                            chkFemale.setSelected(false);
                        }


                        this.lblPosition.setValue(employeeManager.getJobName());
                        lblDepartment.setValue(employeeManager.departmentDetileDescription(
                                employeeManager.getDepartmentId()));

                        if (empStatus.equals("02")) {
                            HashMap leaveData = returntoJobManager.readEmpLeaveInfo(leaveId);
                            lblLeaveStartDateDis.setValue(leaveData.get("REQUESTED_FROM_DATE"));
                            lblLeaveEndDate.setValue(leaveData.get("REQUESTED_TO_DATE"));
                            leaveDays = leaveData.get("LEAVE_DAYS").toString();
                            lblLeaveTypeDes.setValue(leaveData.get("DESCRIPTION").toString());
                            leaveRequestId = leaveData.get("LEAVE_ID").toString();

                        }


                        if (employeeManager.getOfficeOrShift().equals("Shift")) {
                            choShift.setSelected(true);
                            choOffice.setSelected(false);
                        } else {
                            choShift.setSelected(false);
                            choOffice.setSelected(true);
                        }

                        if (employeeManager.employeeWorkingPlace(employeeManager.getDepartmentId()).equals("Mugher")) {
                            choAddisAbeba.setSelected(false);
                            choMugher.setSelected(true);


                        } else {
                            choAddisAbeba.setSelected(true);
                            choMugher.setSelected(false);

                        }

                    } else {
                        this.showSuccessOrFailureMessage(false, "This employee already active.");
                    }


                } else {
                    this.showSuccessOrFailureMessage(false, "Unable To Find The record");

                }
            } else {
                this.showSuccessOrFailureMessage(false, "Unable To Find The record");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
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

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnCalculateLeave_action() {
       

        String endDate = leaveRequestManager.calculateLeaveHolidays(
                txtDateFrom.getValue().toString(),
                txtLeaveDays.getValue().toString());




        txtDateTo.setValue(endDate);
        if (choOffice.isSelected() && choAddisAbeba.isSelected()) {
            returnDate = leaveRequestManager.nextAddisWorkingDay(lblLeaveEndDate.getValue().toString());
        } else if (choShift.isSelected()) {
            returnDate = leaveRequestManager.nextShiftWorkingDay(lblLeaveEndDate.getValue().toString());
        } else if (choOffice.isSelected() && choMugher.isSelected()) {
            returnDate = leaveRequestManager.nextMugherWorkingDay(lblLeaveEndDate.getValue().toString());
        }

        if (choShift.isSelected()) {
            endDate = leaveRequestManager.calculatLeaveDateForShifteWorker(
                    returnDate,
                    txtLeaveDays.getValue().toString());
            // txtDateTo.setValue(endDate);
            txtReturnDateFromLeave.setValue(leaveRequestManager.nextShiftWorkingDay(endDate));
        } else if (choOffice.isSelected() && choMugher.isSelected()) {
            endDate = leaveRequestManager.calculatLeaveDateForBIBOfficeWorker(
                    returnDate,
                    txtLeaveDays.getValue().toString());
            txtDateTo.setValue(endDate);
            String stare_Date = txtDateFrom.getValue().toString();
            int index = stare_Date.indexOf(".");
            if (index > 0) {
                txtReturnDateFromLeave.setValue(endDate);
            } else {
                txtReturnDateFromLeave.setValue(leaveRequestManager.nextMugherWorkingDay(endDate));
            }

        } else if (choOffice.isSelected() && choAddisAbeba.isSelected()) {

            endDate = "";
            int index = txtLeaveDays.getValue().toString().indexOf(".");
            if (index > 0) {
                if (txtLeaveDays.getValue().toString().equals("0.5")) {
                    endDate = txtDateFrom.getValue().toString();
                } else {
                    endDate = leaveRequestManager.calculatLeaveDateForAddisOfficeWorker(
                            returnDate,
                            txtLeaveDays.getValue().toString());
                }
            } else {
                endDate = leaveRequestManager.calculatForAddisOfficeWorker(
                        returnDate,
                        txtLeaveDays.getValue().toString());
                txtDateTo.setValue(endDate);
//
            }
            if (choOffice.isSelected() && choAddisAbeba.isSelected()) {
                returnDate = leaveRequestManager.nextAddisWorkingDay(endDate);
            } else if (choShift.isSelected()) {
                returnDate = leaveRequestManager.nextShiftWorkingDay(endDate);
            } else if (choOffice.isSelected() && choMugher.isSelected()) {
                returnDate = leaveRequestManager.nextMugherWorkingDay(endDate);
            }

            txtDateTo.setValue(endDate);



            txtReturnDateFromLeave.setValue(leaveRequestManager.nextAddisWorkingDay(endDate));
        }
        //return null means stay on the same page
        return null;
    }

    public String btnCalender_action() {
        calLeaveStartDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calLeaveStartDate_processValueChange(ValueChangeEvent vce) {

        txtDateFrom.setValue(dateFormat.format((Date) vce.getNewValue()));
        calLeaveStartDate.setRendered(false);

    }

    private HashMap listOfSikeLeave() {
        HashMap requestInfo = new HashMap();
        requestInfo.put("employeeId", employeeId);
        requestInfo.put("leaveType", "10");
        requestInfo.put("fromDate", txtDateFrom.getValue());
        requestInfo.put("toDate", txtDateTo.getValue());
        requestInfo.put("reason", txtRemark);
        requestInfo.put("leaveDays", txtLeaveDays.getValue());
        return requestInfo;
    }

    private HashMap listOfAnnualLeave() {
        HashMap requestInfo = new HashMap();
        requestInfo.put("leaveId", leaveRequestId);
        requestInfo.put("toDate", txtReturnDateFromLeave.getValue());
        requestInfo.put("returnDate", returnDate);
        return requestInfo;
    }

    public String btnSave_action() {
        if (extendLeaveManager.extendAnnualLeave(listOfSikeLeave(), listOfAnnualLeave())) {
           showSuccessOrFailureMessage(true, "Extend Leave Successfully Saved");
        } else {
            showSuccessOrFailureMessage(false, "Error Occuer during Extend Leave .Please try agin ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnCancel_action() {
        clearReturnToJobTextComponents();
        //return null means stay on the same page
        return null;
    }

}

