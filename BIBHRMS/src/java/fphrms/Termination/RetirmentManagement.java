 /*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Termination;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputHidden;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.context.FacesContext;
import com.icesoft.faces.context.effects.JavascriptContext;
import javax.faces.component.UIInput;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;
import manager.terminationManager.RetirmentManager;
import manager.terminationManager.RetirmentManager.AvilableDepartmentDataModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class RetirmentManagement extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;
    private ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    private DepartmentManage departmentManage = new DepartmentManage();
    ArrayList<AvilableDepartmentDataModel> readAvailableDepartments = new ArrayList<AvilableDepartmentDataModel>();
    private RetirmentManager retirmentManager = new RetirmentManager();
    private int selectedRow;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
    int age;
    String date;
    int deptId;
    String departement;
      String postion;
    String calculatedDate;
    String calculatedAllDate;
    String fullName;
    String hireDate;
    String dateOfBirth;
    String retirmentNo;
    int yearsOld;
    int allyearsOld;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        txtDate.setValue(dateFormat.format(new Date()));
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private HtmlDataTable tblClearingDep = new HtmlDataTable();

    public HtmlDataTable getTblClearingDep() {
        return tblClearingDep;
    }
    private ArrayList<AvilableDepartmentDataModel> availabledepartment = new ArrayList<AvilableDepartmentDataModel>();

    public ArrayList<AvilableDepartmentDataModel> getAvailabledepartment() {
        return availabledepartment;
    }

    public void setAvailabledepartment(ArrayList<AvilableDepartmentDataModel> availabledepartment) {
        this.availabledepartment = availabledepartment;
    }

    public void setTblClearingDep(HtmlDataTable hdt) {
        this.tblClearingDep = hdt;
    }
    private HtmlSelectBooleanCheckbox ckboClearing = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkboClearing() {
        return ckboClearing;
    }

    public void setCkboClearing(HtmlSelectBooleanCheckbox hsbc) {
        this.ckboClearing = hsbc;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu lstMainDepartment = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstMainDepartment() {
        return lstMainDepartment;
    }

    public void setLstMainDepartment(HtmlSelectOneMenu hsom) {
        this.lstMainDepartment = hsom;
    }

    public ArrayList<SelectItem> getZerf() {
        zerf = departmentManage.getDepartmentNameForTerm();

        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCalculatedDate() {
        return calculatedDate;
    }

    public void setCalculatedDate(String calculatedDate) {
        this.calculatedDate = calculatedDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public ArrayList<AvilableDepartmentDataModel> getReadAvailableDepartments() {
        return readAvailableDepartments;
    }

    public void setReadAvailableDepartments(ArrayList<AvilableDepartmentDataModel> readAvailableDepartments) {
        this.readAvailableDepartments = readAvailableDepartments;
    }

    public String getRetirmentNo() {
        return retirmentNo;
    }

    public void setRetirmentNo(String retirmentNo) {
        this.retirmentNo = retirmentNo;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }
    private HtmlInputText txtDate = new HtmlInputText();

    public HtmlInputText getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(HtmlInputText hit) {
        this.txtDate = hit;
    }
    private HtmlInputText txtAge = new HtmlInputText();

    public HtmlInputText getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(HtmlInputText hit) {
        this.txtAge = hit;
    }
    private HtmlCommandButton btnFilter = new HtmlCommandButton();

    public HtmlCommandButton getBtnFilter() {
        return btnFilter;
    }

    public void setBtnFilter(HtmlCommandButton hcb) {
        this.btnFilter = hcb;
    }
    private HtmlCommandButton btnCalendarSatartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarSatartDate() {
        return btnCalendarSatartDate;
    }

    public void setBtnCalendarSatartDate(HtmlCommandButton hcb) {
        this.btnCalendarSatartDate = hcb;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private HtmlPanelGroup pnlgridpnMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlgridpnMessage() {
        return pnlgridpnMessage;
    }

    public void setPnlgridpnMessage(HtmlPanelGroup hpg) {
        this.pnlgridpnMessage = hpg;
    }
    private HtmlOutputText pnMessageTitle = new HtmlOutputText();

    public HtmlOutputText getPnMessageTitle() {
        return pnMessageTitle;
    }

    public void setPnMessageTitle(HtmlOutputText hot) {
        this.pnMessageTitle = hot;
    }
    private HtmlCommandLink btnClosePopupSuccessOrFailure = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupSuccessOrFailure() {
        return btnClosePopupSuccessOrFailure;
    }

    public void setBtnClosePopupSuccessOrFailure(HtmlCommandLink hcl) {
        this.btnClosePopupSuccessOrFailure = hcl;
    }
    private HtmlCommandButton btnAll = new HtmlCommandButton();

    public HtmlCommandButton getBtnAll() {
        return btnAll;
    }

    public void setBtnAll(HtmlCommandButton hcb) {
        this.btnAll = hcb;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RetirmentManagement() {
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
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean selectInputDate1Bean) {
        this.selectInputDate1Bean = selectInputDate1Bean;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public RetirmentManager getRetirmentManager() {
        return retirmentManager;
    }

    public void setRetirmentManager(RetirmentManager retirmentManager) {
        this.retirmentManager = retirmentManager;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public SimpleDateFormat getYearMonthFormat() {
        return yearMonthFormat;
    }

    public void setYearMonthFormat(SimpleDateFormat yearMonthFormat) {
        this.yearMonthFormat = yearMonthFormat;
    }

    private boolean populateRequesterDtaeofBirth() {
        // age = 55;
        date = txtDate.getValue().toString();
        age = Integer.valueOf(txtAge.getValue().toString());
        calculatedDate = GregorianCalendarManipulation.subtractGregorianYearandAge(age, date);
        return true;
    }

    private boolean populateAllRequesterDtaeofBirth() {
        //age = 55;
         date = txtDate.getValue().toString();
        age = Integer.valueOf(txtAge.getValue().toString());
        calculatedAllDate = GregorianCalendarManipulation.subtractGregorianYearandAge(age,date);
        return true;
    }

    public void lstMainDepartment_processValueChange(ValueChangeEvent vce) {
    }

    public String txtAge_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCalendarSatartDate_action() {
        //return null means stay on the same page
        calStartDate.setRendered(true);
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

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
    int tableSize;

    private boolean populateAllBirtDate(String dateOfBirth) {
        int ageOfretire = GregorianCalendarManipulation.calaculateYearDifference(dateOfBirth);
        allyearsOld = ageOfretire;
        return true;
    }

    private boolean populateBirtDate(String dateOfBirth) {

        int ageOfretire = GregorianCalendarManipulation.calaculateYearDifference(dateOfBirth);
        yearsOld = ageOfretire;
        return true;
    }

    public boolean isEntryValidForFilter() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.lstMainDepartment.getValue());
        if (!required) {
            ((UIInput) lstMainDepartment).setValid(false);
            error(lstMainDepartment, errorMessage);
            results = false;
        }
         errorValue = HRValidation.validateData(this.txtAge.getValue(), HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtAge).setValid(false);
                error(txtAge, errorMessage);
            } else {
                ((UIInput) txtAge).setValid(false);
                error(txtAge, "Invalid Value");
            }

        }
        return results;
    }

    private boolean populateTableComponents(String date, int depIDD) {

        ArrayList<HashMap> empInfoHashMap = retirmentManager.readAvailableDpartment(date, depIDD);
        if (empInfoHashMap != null) {
            tableSize = 0;
            getReadAvailableDepartments().clear();
            for (HashMap hmTc : empInfoHashMap) {
                fullName = hmTc.get("fullNme").toString();
                hireDate = hmTc.get("hire_date").toString();
                dateOfBirth = hmTc.get("date_of_birth").toString();
                retirmentNo = hmTc.get("retirement_no").toString();
                departement = hmTc.get("department_name").toString();
                postion = hmTc.get("JOB_NAME").toString();
                populateBirtDate(dateOfBirth);
                readAvailableDepartments.add(new AvilableDepartmentDataModel(fullName, hireDate, dateOfBirth, retirmentNo, departement, yearsOld,postion));
                tableSize++;
            }
            return true;
        } else {
            date = null;
            depIDD = 0;
            showSuccessOrFailureMessage(false, "THERE IS NO EMPLOYEE WILL BE RETRED WITH THIS DEPARTEMENT IN THE NEXT FIVE YEAR");
            return false;
        }

    }

    private boolean populateAllretireTableComponents(String calculatedDate) {
        ArrayList<HashMap> empInfoHashMap = retirmentManager.readAllAvailableDpartment(calculatedDate);
        if (empInfoHashMap != null) {
            tableSize = 0;
            getReadAvailableDepartments().clear();
            for (HashMap hmTc : empInfoHashMap) {
                fullName = hmTc.get("fullNme").toString();
                hireDate = hmTc.get("hire_date").toString();
                dateOfBirth = hmTc.get("date_of_birth").toString();
                retirmentNo = hmTc.get("retirement_no").toString();
                departement = hmTc.get("department_name").toString();
                postion= hmTc.get("JOB_NAME").toString();
                populateAllBirtDate(dateOfBirth);
                readAvailableDepartments.add(new AvilableDepartmentDataModel(fullName, hireDate, dateOfBirth, retirmentNo, departement, allyearsOld,postion));
                tableSize++;
            }
            return true;
        } else {
            calculatedDate = null;
            showSuccessOrFailureMessage(false, "THERE IS NO EMPLOYEE WILL BE RETRED WITH THIS DEPARTEMENT IN THE NEXT FIVE YEAR");
            return false;
        }
    }

    public String btnFilter_action() {
        //return null means stay on the same page
        if (isEntryValidForFilter()) {
            deptId = Integer.valueOf(lstMainDepartment.getValue().toString().split("-")[0]);
            departement = lstMainDepartment.getValue().toString().split("-")[1];
            date = txtDate.getValue().toString();
            populateRequesterDtaeofBirth();
            getReadAvailableDepartments().clear();
            populateTableComponents(calculatedDate, deptId);
        }
        return null;
    }
 public boolean isEntryValidForAll() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "First Select the Departement";
        int errorValue = 0;
       
         errorValue = HRValidation.validateData(this.txtAge.getValue(), HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtAge).setValid(false);
                error(txtAge, errorMessage);
            } else {
                ((UIInput) txtAge).setValid(false);
                error(txtAge, "Invalid Value");
            }

        }
        return results;
    }

    public String btnAll_action() {
        //return null means stay on the same page
        try {
            if(isEntryValidForAll()){
            lstMainDepartment.setValue(null);
            lstMainDepartment.setDisabled(true);
            btnFilter.setDisabled(true);
            getReadAvailableDepartments().clear();
            populateAllRequesterDtaeofBirth();
            populateAllretireTableComponents(calculatedAllDate);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String btnReset_action() {
        //return null means stay on the same page
        lstMainDepartment.setValue(null);
        lstMainDepartment.setDisabled(false);
        btnFilter.setDisabled(false);
        calculatedAllDate = null;
        calculatedDate = null;
        getReadAvailableDepartments().clear();
        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        //return null means stay on the same page
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
}
