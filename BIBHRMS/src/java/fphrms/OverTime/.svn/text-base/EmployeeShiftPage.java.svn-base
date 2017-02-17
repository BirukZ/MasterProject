/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.OverTime;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.selectinputtext.TextChangeEvent;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.overTimeManager.MgrEmployeeShiftViewer;
import com.sun.webui.jsf.model.Option;
import javax.faces.component.UIInput;
import javax.swing.JOptionPane;
import manager.ReportCritera.ReportCriteraManager;
import manager.globalUseManager.HRValidation;
import manager.overTimeManager.EmployeeShiftManager;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EmployeeShiftPage.java
 * @version Created on Apr 2, 2012, 1:12:34 AM
 * @author user
 */
public class EmployeeShiftPage extends AbstractPageBean {

    private ReportCriteraManager reportCritera;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();
     private SelectInputDateBean selectInputDate1BeanNewStarat = new SelectInputDateBean();
      private SelectInputDateBean selectInputDate1BeanNewEnd = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1BeanNewEnd() {
        return selectInputDate1BeanNewEnd;
    }

    public void setSelectInputDate1BeanNewEnd(SelectInputDateBean selectInputDate1BeanNewEnd) {
        this.selectInputDate1BeanNewEnd = selectInputDate1BeanNewEnd;
    }

    public SelectInputDateBean getSelectInputDate1BeanNewStarat() {
        return selectInputDate1BeanNewStarat;
    }

    public void setSelectInputDate1BeanNewStarat(SelectInputDateBean selectInputDate1BeanNewStarat) {
        this.selectInputDate1BeanNewStarat = selectInputDate1BeanNewStarat;
    }
      

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private HtmlInputText txtStart_Date = new HtmlInputText();

    public HtmlInputText getTxtStart_Date() {
        return txtStart_Date;
    }

    public void setTxtStart_Date(HtmlInputText hit) {
        this.txtStart_Date = hit;
    }
    private HtmlInputText txtEmpId = new HtmlInputText();

    public HtmlInputText getTxtEmpId() {
        return txtEmpId;
    }

    public void setTxtEmpId(HtmlInputText hit) {
        this.txtEmpId = hit;
    }
    private HtmlInputText txtShiftName = new HtmlInputText();

    public HtmlInputText getTxtShiftName() {
        return txtShiftName;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate calAppliedDate) {
        this.calAppliedDate = calAppliedDate;
    }

    public void setTxtShiftName(HtmlInputText hit) {
        this.txtShiftName = hit;
    }
    private SelectInputDate calViewDate = new SelectInputDate();
     private SelectInputDate calNewShiftStratDate = new SelectInputDate();
      private SelectInputDate calNewShiftEndDate = new SelectInputDate();

    public SelectInputDate getCalNewShiftEndDate() {
        return calNewShiftEndDate;
    }

    public void setCalNewShiftEndDate(SelectInputDate calNewShiftEndDate) {
        this.calNewShiftEndDate = calNewShiftEndDate;
    }

    public SelectInputDate getCalNewShiftStratDate() {
        return calNewShiftStratDate;
    }

    public void setCalNewShiftStratDate(SelectInputDate calNewShiftStratDate) {
        this.calNewShiftStratDate = calNewShiftStratDate;
    }

    public SelectInputDate getCalViewDate() {
        return calViewDate;
    }

    public void setCalViewDate(SelectInputDate sid) {
        this.calViewDate = sid;
    }
    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(HtmlCommandButton hcb) {
        this.btnSearch = hcb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drl_shiftType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_shiftType() {
        return drl_shiftType;
    }

    public void setDrl_shiftType(HtmlSelectOneMenu hsom) {
        this.drl_shiftType = hsom;
    }
    private SelectInputText txtEmployeeFullName = new SelectInputText();

    public SelectInputText getTxtEmployeeFullName() {
        return txtEmployeeFullName;
    }

    public void setTxtEmployeeFullName(SelectInputText sit) {
        this.txtEmployeeFullName = sit;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chk_change_shift = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChk_change_shift() {
        return chk_change_shift;
    }

    public void setChk_change_shift(HtmlSelectBooleanCheckbox hsbc) {
        this.chk_change_shift = hsbc;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlSelectOneMenu drl_Month = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Month() {
        return drl_Month;
    }

    public void setDrl_Month(HtmlSelectOneMenu hsom) {
        this.drl_Month = hsom;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private HtmlInputText txt_changedDate = new HtmlInputText();

    public HtmlInputText getTxt_changedDate() {
        return txt_changedDate;
    }

    public void setTxt_changedDate(HtmlInputText hit) {
        this.txt_changedDate = hit;
    }
    private HtmlSelectOneMenu drl_select_Year = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_select_Year() {
        return drl_select_Year;
    }

    public void setDrl_select_Year(HtmlSelectOneMenu hsom) {
        this.drl_select_Year = hsom;
    }
    private HtmlInputText txt_EndDate = new HtmlInputText();

    public HtmlInputText getTxt_EndDate() {
        return txt_EndDate;
    }

    public void setTxt_EndDate(HtmlInputText hit) {
        this.txt_EndDate = hit;
    }
    private HtmlCommandButton btn_calander = new HtmlCommandButton();

    public HtmlCommandButton getBtn_calander() {
        return btn_calander;
    }

    public void setBtn_calander(HtmlCommandButton hcb) {
        this.btn_calander = hcb;
    }
    private HtmlInputText txt_NewShiftStart_Date = new HtmlInputText();

    public HtmlInputText getTxt_NewShiftStart_Date() {
        return txt_NewShiftStart_Date;
    }

    public void setTxt_NewShiftStart_Date(HtmlInputText hit) {
        this.txt_NewShiftStart_Date = hit;
    }
    private HtmlInputText txt_NewShift_EndDate = new HtmlInputText();

    public HtmlInputText getTxt_NewShift_EndDate() {
        return txt_NewShift_EndDate;
    }

    public void setTxt_NewShift_EndDate(HtmlInputText hit) {
        this.txt_NewShift_EndDate = hit;
    }
    private HtmlCommandButton btncalNewStart = new HtmlCommandButton();

    public HtmlCommandButton getBtncalNewStart() {
        return btncalNewStart;
    }

    public void setBtncalNewStart(HtmlCommandButton hcb) {
        this.btncalNewStart = hcb;
    }
    private HtmlCommandButton cal_NewShiftEndDate = new HtmlCommandButton();

    public HtmlCommandButton getCal_NewShiftEndDate() {
        return cal_NewShiftEndDate;
    }

    public void setCal_NewShiftEndDate(HtmlCommandButton hcb) {
        this.cal_NewShiftEndDate = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeShiftPage() {
    }
    DepartmentManage departmentManage = new DepartmentManage();
    ReportCriteraManager report = new ReportCriteraManager();
    EmployeeManage employeeManager = new EmployeeManage();
    EmployeeShiftManager empShiftManger = new EmployeeShiftManager();
    ArrayList<SelectItem> addressCodeList = departmentManage.getAddressCode();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    ArrayList<Option> shiftList = new ArrayList<Option>();
    ArrayList<Option> monthList = new ArrayList<Option>();
    ArrayList<SelectItem> newBudjetYearList = ReportCriteraManager.getBudgetYearList();
    ArrayList<SelectItem> budjetYearList = ReportCriteraManager.getBudgetYearList();
    String empID;
    String preShiftStartDate;
    String preShiftEndDate;
    String newShiftStartDate;
    String newShiftEndDate;
    String preShiftName;
    String shiftChanagedDate;
    String changedShiftName;
    String selectYear;
    String selectMonth;

    public ArrayList<SelectItem> getBudjetYearList() {
        return budjetYearList;
    }

    public void setBudjetYearList(ArrayList<SelectItem> budjetYearList) {
        this.budjetYearList = budjetYearList;
    }

    public String getSelectMonth() {
        return selectMonth;
    }

    public void setSelectMonth(String selectMonth) {
        this.selectMonth = selectMonth;
    }

    public String getSelectYear() {
        return selectYear;
    }

    public void setSelectYear(String selectYear) {
        this.selectYear = selectYear;
    }

    public String getChangedShiftName() {
        return changedShiftName;
    }

    public void setChangedShiftName(String changedShiftName) {
        this.changedShiftName = changedShiftName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getPreShiftEndDate() {
        return preShiftEndDate;
    }

    public void setPreShiftEndDate(String preShiftEndDate) {
        this.preShiftEndDate = preShiftEndDate;
    }

    public String getPreShiftName() {
        return preShiftName;
    }

    public void setPreShiftName(String preShiftName) {
        this.preShiftName = preShiftName;
    }

    public String getPreShiftStartDate() {
        return preShiftStartDate;
    }

    public void setPreShiftStartDate(String preShiftStartDate) {
        this.preShiftStartDate = preShiftStartDate;
    }

    public String getShiftChanagedDate() {
        return shiftChanagedDate;
    }

    public void setShiftChanagedDate(String shiftChanagedDate) {
        this.shiftChanagedDate = shiftChanagedDate;
    }

    public ArrayList<SelectItem> getNewBudjetYearList() {
        return newBudjetYearList;
    }

    public void setNewBudjetYearList(ArrayList<SelectItem> newBudjetYearList) {
        this.newBudjetYearList = newBudjetYearList;
    }

    public ArrayList<Option> getMonthList() {
        return monthList;
    }

    public void setMonthList(ArrayList<Option> monthList) {
        this.monthList = monthList;
    }

    public ArrayList<Option> getShiftList() {
        return shiftList;
    }

    public void setShiftList(ArrayList<Option> shiftList) {
        this.shiftList = shiftList;
    }
    String employeeId = null;

    public ArrayList<SelectItem> getAddressCodeList() {
        return addressCodeList;
    }

    public void setAddressCodeList(ArrayList<SelectItem> addressCodeList) {
        this.addressCodeList = addressCodeList;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

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

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public String getNewShiftEndDate() {
        return newShiftEndDate;
    }

    public void setNewShiftEndDate(String newShiftEndDate) {
        this.newShiftEndDate = newShiftEndDate;
    }

    public String getNewShiftStartDate() {
        return newShiftStartDate;
    }

    public void setNewShiftStartDate(String newShiftStartDate) {
        this.newShiftStartDate = newShiftStartDate;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setAutoCentre(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
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
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        shiftList = empShiftManger.getShiftList();
        monthList = empShiftManger.getMonthList();

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
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void calViewDate_processValueChange(ValueChangeEvent vce) {
        txt_changedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calViewDate.setRendered(false);
    }
      public void calNewShiftStartDate_processValueChange(ValueChangeEvent vce) {
        txt_NewShiftStart_Date.setValue(dateFormat.format((Date) vce.getNewValue()));
        calNewShiftStratDate.setRendered(false);
    }
       public void calNewShiftEndDate_processValueChange(ValueChangeEvent vce) {
        txt_NewShift_EndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calNewShiftEndDate.setRendered(false);
    }

    public void shift() {
        String date1 = "2004-02-05";
        String date2 = "2004-04-05";
        int counter = 0;
        int diff = 0;
        int shCounter = 0;
        //  String shifft = "sh";
        for (int i = 0; i < diff; i++) {
            counter++;
            if (counter == 2) {
                if (shCounter == 3) {
                    shCounter = 1;
                } else {
                    shCounter += 1;
                }
                counter = 0;
            }
        }

    }
    //  shifft.concat(Integer.toString(shCounter));

    public String button2_action() {
        calViewDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }
    MgrEmployeeShiftViewer shft = new MgrEmployeeShiftViewer();

    public boolean button1_action() {

        selectMonth = drl_Month.getValue().toString();
        selectYear = drl_select_Year.getValue().toString();
        empID = txtEmpId.getValue().toString();
        String year[] = selectYear.split("_");
        String selectedYear = year[0];
        HashMap empShift = empShiftManger.readEmployeeShift(selectMonth, selectedYear, empID);
        if (populateEmployeeName(txtEmpId.getValue().toString())) {

            if (empShift != null) {
                if (empShift.isEmpty()) {//if no resultset found
                    showSuccessOrFailureMessage(false, "NO SHIFT REGISTERD FOR THIS EMPLOYEE : " + employeeId);
                    //  clearEmployeeId();
                    return false;
                } else {
                    txtStart_Date.setValue(empShift.get("startDate"));
                    txt_EndDate.setValue(empShift.get("startDate"));
                    txtShiftName.setValue(empShift.get("shifetType"));
                    return true;
                }
            } else {
                showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
                return false;
            }
        } else {
            showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtEmpId.getValue().toString());
            txtEmpId = null;
            return false;
        }



    }

//    public String btnSearch_action() {
//        //return null means stay on the same page
//        HashMap shiftName = null;
//        HashMap list_shifts = null;
//        int dateDiff = 0;
//        int shCounter =1;
//        int counter = 0;
//        int no_of_shifts = 0;
//        String shift = "SH";
//        try {
//            shiftName = shft.selectShiftRegistration(txtEmpId.getValue().toString());
//
//            list_shifts = shft.selectShifts(shiftName.get("Shift").toString(),drlAddress.getValue().toString());
//
//            dateDiff = StringDateManipulation.compareDateDifference(list_shifts.get("REGISTERED_DATE").toString(), txtDate.getValue().toString());
//            no_of_shifts = shft.selectAllShifts(drlAddress.getValue().toString()).size();
//            float no_of_holidays;
//            no_of_holidays = Integer.valueOf(dateDiff / 7);
//            dateDiff = (int) (dateDiff - no_of_holidays);
//            for (int i = 0; i<dateDiff; i++) {
//                counter++;
//                if (counter == 2) {
//
//                    if (shCounter == no_of_shifts) {
//                        shCounter = 1;
//                    } else {
//                        shCounter += 1;
//                    }
//                    counter = 0;
//                }
//            }
//            shift = shift.concat(Integer.valueOf(shCounter).toString());
//            list_shifts = shft.selectShifts(shift,drlAddress.getValue().toString());
//            txtStartTime.setValue(list_shifts.get("START_TIME").toString());
//            txtEndTime.setValue(list_shifts.get("END_TIME").toString());
//            txtShiftName.setValue(list_shifts.get("SHIFT_CODE").toString());
//            txtRegistereddate.setValue(list_shifts.get("REGISTERED_DATE").toString());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//}
    public boolean isEntryValidForShift() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.drl_Month.getValue());

        if (!required) {
            ((UIInput) drl_Month).setValid(false);
            error(drl_Month, errorMessage);
            results =
                    false;
        }

        required = HRValidation.validateRequired(this.drl_select_Year.getValue());

        if (!required) {
            ((UIInput) drl_select_Year).setValid(false);
            error(drl_select_Year, errorMessage);
            results = false;

        }
        required = HRValidation.validateRequired(this.txtEmpId.getValue());

        if (!required) {
            ((UIInput) txtEmpId).setValid(false);
            error(txtEmpId, errorMessage);
            results =
                    false;
        }

        return results;
    }

    public boolean btnSearch_action() {
        //return null means stay on the same page
        if (isEntryValidForShift()) {
            try {

                selectMonth = drl_Month.getValue().toString();
                selectYear = drl_select_Year.getValue().toString();
                empID = txtEmpId.getValue().toString();
                String year[] = selectYear.split("_");
                String selectedYear = year[0];
                HashMap empShift = empShiftManger.readEmployeeShift(selectMonth, selectedYear, empID);
                if (populateEmployeeName(txtEmpId.getValue().toString())) {

                    if (empShift != null) {
                        if (empShift.isEmpty()) {//if no resultset found
                            showSuccessOrFailureMessage(false, "NO SHIFT REGISTERD FOR THIS EMPLOYEE : " + employeeId);
                            //  clearEmployeeId();
                            return false;
                        } else {
                            txtStart_Date.setValue(empShift.get("startDate"));
                            txt_EndDate.setValue(empShift.get("startDate"));
                            txtShiftName.setValue(empShift.get("shifetType"));
                            return true;
                        }
                    } else {
                        showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
                        return false;
                    }
                } else {
                    showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtEmpId.getValue().toString());
                    txtEmpId = null;
                    return false;
                }


            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private void clearEmployeeId() {
        txtEmployeeFullName.setValue(null);
        txtEmpId.setValue(null);
        employeeId = null;
    }

    public String txtEmployeeFullName_action() {
        //return null means stay on the same page
        clearEmployeeId();
        employeeId = ApplicationBean1.getSelectedEmployeeId();
        populateEmployeeName(employeeId);
        return null;
    }

    private boolean populateEmployeeName(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                clearEmployeeId();
                return false;
            } else {
                txtEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtEmpId.setValue(employeeId);
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    public void txtEmployeeFullName_processMyEvent(TextChangeEvent tce) {
    }

    public String txtStart_Date_action() {
        //return null means stay on the same page
        return null;
    }

    public void chk_change_shift_processValueChange(ValueChangeEvent vce) {
        drl_shiftType.setDisabled(false);
        btn_calander.setDisabled(false);
    }

    public String btn_calander_action() {
        //return null means stay on the same page
        //btn_calander
        calViewDate.setRendered(true);
        return null;
    }

    public String txt_EndDate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btn_Save_action() {
        //return null means stay on the same page
        empID=txtEmpId.getValue().toString();
        preShiftStartDate=txtStart_Date.getValue().toString();
        preShiftEndDate=txt_EndDate.getValue().toString();
        preShiftName=txtShiftName.getValue().toString();
        changedShiftName=drl_shiftType.getValue().toString();
        shiftChanagedDate=txt_changedDate.getValue().toString();
        newShiftStartDate=txt_NewShiftStart_Date.getValue().toString();
        newShiftEndDate=txt_NewShift_EndDate.getValue().toString();
       
      if( empShiftManger.SaveUPdatedShift(empID,preShiftStartDate,preShiftEndDate,preShiftName,changedShiftName,shiftChanagedDate,newShiftStartDate,newShiftEndDate)){

       showSuccessOrFailureMessage(true, "Saving is Successfule:");

      }
      else{
       showSuccessOrFailureMessage(false, "Saving is NOT Good:");

      }


        return null;
    }

    public String btncalNewStart_action() {
        //return null means stay on the same page
        calNewShiftStratDate.setRendered(true);
        return null;
    }

    public String cal_NewShiftEndDate_action() {
        //return null means stay on the same page
        calNewShiftEndDate.setRendered(true);
        return null;
    }

   

  
}

