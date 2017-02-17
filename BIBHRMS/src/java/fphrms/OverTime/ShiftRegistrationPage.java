/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.OverTime;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.ColumnGroup;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataProvider;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.swing.tree.DefaultTreeModel;
import manager.departmentManage.DepartmentManage;
import manager.organizationManager.LoadTree;
import manager.overTimeManager.ShiftRegistrationManager;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import javax.faces.component.UIInput;
import manager.globalUseManager.HRValidation;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ShiftRegistrationPage.java
 * @version Created on Mar 20, 2012, 9:46:51 PM
 * @author user
 */
public class ShiftRegistrationPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }
    private PanelLayout panelLayout3 = new PanelLayout();
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public static int getDEPARRTMENT_ID() {
        return DEPARRTMENT_ID;
    }

    public static void setDEPARRTMENT_ID(int DEPARRTMENT_ID) {
        ShiftRegistrationPage.DEPARRTMENT_ID = DEPARRTMENT_ID;
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

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean selectInputDate1Bean) {
        this.selectInputDate1Bean = selectInputDate1Bean;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public ShiftRegistrationManager getShftmgr() {
        return shftmgr;
    }

    public void setShftmgr(ShiftRegistrationManager shftmgr) {
        this.shftmgr = shftmgr;
    }

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
    }
    private Tree tree1 = new Tree();

    public Tree getTree1() {
        return tree1;
    }

    public void setTree1(Tree t) {
        this.tree1 = t;
    }
    private HtmlInputText txtfDepartment = new HtmlInputText();

    public HtmlInputText getTxtfDepartment() {
        return txtfDepartment;
    }

    public void setTxtfDepartment(HtmlInputText hit) {
        this.txtfDepartment = hit;
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    private UIColumn colStartTime = new UIColumn();

    public UIColumn getColStartTime() {
        return colStartTime;
    }

    public void setColStartTime(UIColumn uic) {
        this.colStartTime = uic;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox checkbox1 = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getCheckbox1() {
        return checkbox1;
    }

    public void setCheckbox1(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1 = hsbc;
    }
    private HtmlDataTable dataTable = new HtmlDataTable();

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable hdt) {
        this.dataTable = hdt;
    }
    private ColumnGroup columnGroup1 = new ColumnGroup();

    public ColumnGroup getColumnGroup1() {
        return columnGroup1;
    }

    public void setColumnGroup1(ColumnGroup cg) {
        this.columnGroup1 = cg;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox chkShtow = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getChkShtow() {
        return chkShtow;
    }

    public void setChkShtow(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.chkShtow = hsbc;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox chkShThree = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getChkShThree() {
        return chkShThree;
    }

    public void setChkShThree(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.chkShThree = hsbc;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox chkShone = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getChkShone() {
        return chkShone;
    }

    public void setChkShone(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.chkShone = hsbc;
    }
    private HtmlCommandButton btnCalendarEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarEndDate() {
        return btnCalendarEndDate;
    }

    public void setBtnCalendarEndDate(HtmlCommandButton hcb) {
        this.btnCalendarEndDate = hcb;
    }
    private HtmlCommandButton btnCalendarSatartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarSatartDate() {
        return btnCalendarSatartDate;
    }

    public void setBtnCalendarSatartDate(HtmlCommandButton hcb) {
        this.btnCalendarSatartDate = hcb;
    }
    private HtmlInputText txtFrom = new HtmlInputText();

    public HtmlInputText getTxtFrom() {
        return txtFrom;
    }

    public void setTxtFrom(HtmlInputText hit) {
        this.txtFrom = hit;
    }
    private HtmlInputText txtTo = new HtmlInputText();

    public HtmlInputText getTxtTo() {
        return txtTo;
    }

    public void setTxtTo(HtmlInputText hit) {
        this.txtTo = hit;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox chkShFive = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getChkShFive() {
        return chkShFive;
    }

    public void setChkShFive(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.chkShFive = hsbc;
    }
    private javax.faces.component.html.HtmlSelectBooleanCheckbox chkShFour = new javax.faces.component.html.HtmlSelectBooleanCheckbox();

    public javax.faces.component.html.HtmlSelectBooleanCheckbox getChkShFour() {
        return chkShFour;
    }

    public void setChkShFour(javax.faces.component.html.HtmlSelectBooleanCheckbox hsbc) {
        this.chkShFour = hsbc;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private SelectInputDate calendDate = new SelectInputDate();

    public SelectInputDate getCalendDate() {
        return calendDate;
    }

    public void setCalendDate(SelectInputDate sid) {
        this.calendDate = sid;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public String getButtonAction() {
        return buttonAction;
    }

    public void setButtonAction(String buttonAction) {
        this.buttonAction = buttonAction;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
    }

    public void setCalEndDate(SelectInputDate sid) {
        this.calEndDate = sid;
    }
    boolean selectedColumnRendered = false;
    String newOrEditOrUpdateLabel = "Save";
    String buttonAction = "Save";

    public boolean isSelectedColumnRendered() {
        return selectedColumnRendered;
    }

    public void setSelectedColumnRendered(boolean selectedColumnRendered) {
        this.selectedColumnRendered = selectedColumnRendered;
    }
    private HtmlSelectBooleanCheckbox ckbForColumnSelected = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbForColumnSelected() {
        return ckbForColumnSelected;
    }

    public void setCkbForColumnSelected(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbForColumnSelected = hsbc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ShiftRegistrationPage() {
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
            log("ShiftRegistration Initialization Failure", e);
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
    static int DEPARRTMENT_ID = 0;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DepartmentManage departmentManage = new DepartmentManage();

    public void tree1Model_action(ActionEvent ae) {

        String departmentName;
        String department = tree1.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];
            DEPARRTMENT_ID =
                    Integer.parseInt(_department[1].trim());
            txtfDepartment.setValue(departmentName);
            panelLayout3.setRendered(false);
        }

    }

    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }
    private DefaultTree tree1Model = new DefaultTree();

    public DefaultTree getTree1Model() {
        return tree1Model;
    }

    public void setTree1Model(DefaultTree dt) {
        this.tree1Model = dt;
    }
    ArrayList<EmployeeList> emp = new ArrayList<EmployeeList>();

    public ArrayList<EmployeeList> getEmp() {
        return emp;
    }

    public void setEmp(ArrayList<EmployeeList> emp) {
        this.emp = emp;
    }

    public class EmployeeList {

        public EmployeeList(boolean selected, boolean shift_two, boolean shift_three, boolean shift_one) {
            this.selected = selected;
            this.shift_two = shift_two;
            this.shift_three = shift_three;
            this.shift_one = shift_one;
        }

        public EmployeeList(boolean selected, boolean shift_two, boolean shift_three, boolean shift_one, boolean shift_four, boolean shift_five) {
            this.selected = selected;
            this.shift_two = shift_two;
            this.shift_three = shift_three;
            this.shift_one = shift_one;
            this.shift_four = shift_four;
            this.shift_five = shift_five;
        }

        public EmployeeList(String full_name, String id, String job_position, boolean selected, boolean shift_one, boolean shift_two, boolean shift_three) {
            this.full_name = full_name;
            this.id = id;
            this.job_position = job_position;
            this.selected = selected;
            this.shift_one = shift_one;
            this.shift_two = shift_two;
            this.shift_three = shift_three;
        }
        String full_name, id, job_position,databasStatus,from, to;
        boolean selected, shift_two, shift_three, shift_one, shift_four, shift_five;

        public EmployeeList(String full_name, String id, String job_position, boolean selected, boolean shift_two, boolean shift_three, boolean shift_one, boolean shift_four, boolean shift_five) {
            this.full_name = full_name;
            this.id = id;
            this.job_position = job_position;
            this.selected = selected;
            this.shift_two = shift_two;
            this.shift_three = shift_three;
            this.shift_one = shift_one;
            this.shift_four = shift_four;
            this.shift_five = shift_five;
        }

        private EmployeeList(String full_name, String id, String job_position, boolean shift_two, boolean shift_three, boolean shift_one, boolean shift_four, boolean shift_five) {
            this.full_name = full_name;
            this.id = id;
            this.job_position = job_position;

            this.shift_two = shift_two;
            this.shift_three = shift_three;
            this.shift_one = shift_one;
            this.shift_four = shift_four;
            this.shift_five = shift_five;
        }

        public boolean isShift_one() {
            return shift_one;
        }

        public void setShift_one(boolean shift_one) {
            this.shift_one = shift_one;
        }

        public boolean isShift_five() {
            return shift_five;
        }

        public String getDatabasStatus() {
            return databasStatus;
        }

        public void setDatabasStatus(String databasStatus) {
            this.databasStatus = databasStatus;
        }

        public void setShift_five(boolean shift_five) {
            this.shift_five = shift_five;
        }

        public boolean isShift_four() {
            return shift_four;
        }

        public void setShift_four(boolean shift_four) {
            this.shift_four = shift_four;
        }

        public boolean isShift_two() {
            return shift_two;
        }

        public void setShift_two(boolean shift_two) {
            this.shift_two = shift_two;
        }

        public boolean isShift_three() {
            return shift_three;
        }

        public void setShift_three(boolean shift_three) {
            this.shift_three = shift_three;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJob_position() {
            return job_position;
        }

        public void setJob_position(String job_position) {
            this.job_position = job_position;
        }
    }
    int selectedRow = -1;

    public void rowSelectorOverTime_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }
    ShiftRegistrationManager shftmgr = new ShiftRegistrationManager();

    public void commandLink1_processAction(javax.faces.event.ActionEvent ae) {
        String departmentName;
        String department = tree1.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        try {
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID =
                        Integer.parseInt(_department[1].trim());
                txtfDepartment.setValue(departmentName);
                panelLayout3.setRendered(false);
                getEmp().clear();
                ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
                listOfEmployee = shftmgr.selectShiftRegistration(_department[1].trim());
                String fullName = null;

                for (HashMap hm : listOfEmployee) {
                    fullName = hm.get("FIRST_NAME").toString() + " " + hm.get("MIDDLE_NAME").toString() + " " + hm.get("LAST_NAME").toString();
                    if (hm.get("shift_type").toString().equalsIgnoreCase("SH1")) {
                        getEmp().add(new EmployeeList(fullName, hm.get("EMP_ID").toString(), hm.get("JOB_DESCRIPTION").toString(), true, false, false, false, false));
                    } else if (hm.get("shift_type").toString().equalsIgnoreCase("SH2")) {
                        getEmp().add(new EmployeeList(fullName, hm.get("EMP_ID").toString(), hm.get("JOB_DESCRIPTION").toString(), false, true, false, false, false));
                    } else if (hm.get("shift_type").toString().equalsIgnoreCase("SH3")) {
                        getEmp().add(new EmployeeList(fullName, hm.get("EMP_ID").toString(), hm.get("JOB_DESCRIPTION").toString(), false, false, true, false, false));
                    } else if (hm.get("shift_type").toString().equalsIgnoreCase("SH4")) {
                        getEmp().add(new EmployeeList(fullName, hm.get("EMP_ID").toString(), hm.get("JOB_DESCRIPTION").toString(), false, false, false, true, false));
                    } else if (hm.get("shift_type").toString().equalsIgnoreCase("SH5")) {
                        getEmp().add(new EmployeeList(fullName, hm.get("EMP_ID").toString(), hm.get("JOB_DESCRIPTION").toString(), false, false, false, false, true));
                    } else {
                        getEmp().add(new EmployeeList(fullName, hm.get("EMP_ID").toString(), hm.get("JOB_DESCRIPTION").toString(), false, false, false, false, false));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String commandLink1_action() {

        return null;
    }

    public String tree1_action() {

        //return null means stay on the same page
        return null;
    }

    public String btnTree_action() {
        LoadTree loadTree = new LoadTree();
        this.tree1Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        panelLayout3.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnReset_action() {
        //return null means stay on the same page
       emp.clear();
       txtFrom.setValue(null);
       txtTo.setValue(null);
       txtfDepartment.setValue(null);

        return null;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

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
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public void pnlGrpPowerAllContent_processMyEvent(DragEvent de) {
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }
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

    public boolean isEntryValidForShift() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required =
                HRValidation.validateRequired(this.txtfDepartment.getValue());
        if (!required) {
            ((UIInput) txtfDepartment).setValid(false);
            error(txtfDepartment, errorMessage);
            results =
                    false;
        }

        errorValue = HRValidation.validateData(this.txtFrom.getValue(), HRValidation.DATE_PATTERN2, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtFrom).setValid(false);
                error(txtFrom, errorMessage);
            } else {
                ((UIInput) txtFrom).setValid(false);
                error(txtFrom, "Invalid Value");
            }

        }
        errorValue = HRValidation.validateData(this.txtTo.getValue(), HRValidation.DATE_PATTERN2, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtTo).setValid(false);
                error(txtTo, errorMessage);
            } else {
                ((UIInput) txtTo).setValid(false);
                error(txtTo, "Invalid Value");
            }

        }

        return results;
    }

    public String btnSave_action() {
        //return null means stay on the same page
        if (isEntryValidForShift()) {
            int sucess = 0;
            String startDate = txtFrom.getValue().toString();
            String endDate = txtTo.getValue().toString();
            try {
                for (int i = 0; i < getEmp().size(); i++) {

                    if (getEmp().get(i).isShift_one()) {
                        sucess = shftmgr.update_shift("SH1", getEmp().get(i).getId(), startDate, endDate);
                    } else if (getEmp().get(i).isShift_two()) {
                        sucess = shftmgr.update_shift("SH2", getEmp().get(i).getId(), startDate, endDate);
                    } else if (getEmp().get(i).isShift_three()) {
                        sucess = shftmgr.update_shift("SH3", getEmp().get(i).getId(), startDate, endDate);
                    } else if (getEmp().get(i).isShift_four()) {
                        sucess = shftmgr.update_shift("SH4", getEmp().get(i).getId(), startDate, endDate);
                    } else if (getEmp().get(i).isShift_five()) {
                        sucess = shftmgr.update_shift("SH5", getEmp().get(i).getId(), startDate, endDate);
                    } else {
                        showSuccessOrFailureMessage(false, "FIRST SELECT SHIFT TYPE!!");
                    }
                }
                if (sucess > 0) {
                    showSuccessOrFailureMessage(true, "Shift Registered! ");
                    txtfDepartment.setValue(null);
                    txtFrom.setValue(null);
                    txtTo.setValue(null);
                    emp.clear();
                } else {
                    showSuccessOrFailureMessage(false, "Can't Register! ");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
    }

    public void checkbox1_processValueChange(ValueChangeEvent vce) {

        chkShone.setSelected(false);
        chkShtow.setSelected(false);
        chkShThree.setSelected(false);
    }


    ////at least one check box is selected
    private boolean checkAtleastOneCheckBoxIsSelected() {
        boolean atLeastOneCheckBoxIsSelected = false;

        return atLeastOneCheckBoxIsSelected;
    }

    public void chkShone_processValueChange(ValueChangeEvent vce) {
        chkShtow.setSelected(false);
        chkShThree.setSelected(false);
        chkShFour.setSelected(false);
        chkShFive.setSelected(false);

    }

    public void chkShtow_processValueChange(ValueChangeEvent vce) {
        chkShone.setSelected(false);

        chkShThree.setSelected(false);
        chkShFour.setSelected(false);
        chkShFive.setSelected(false);
    }

    public void chkShThree_processValueChange(ValueChangeEvent vce) {
        chkShone.setSelected(false);
        chkShtow.setSelected(false);
        chkShFour.setSelected(false);
        chkShFive.setSelected(false);
    }

    public String btnCalendarSatartDate_action() {
        //return null means stay on the same page
        calStartDate.setRendered(true);
        return null;
    }

    public String btnCalendarEndDate_action() {
        //return null means stay on the same page
        calendDate.setRendered(true);
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtFrom.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }

    public void calendDate_processValueChange(ValueChangeEvent vce) {
        txtTo.setValue(dateFormat.format((Date) vce.getNewValue()));
        calendDate.setRendered(false);
    }

    public void chkShFive_processValueChange(ValueChangeEvent vce) {
        chkShone.setSelected(false);
        chkShtow.setSelected(false);
        chkShFour.setSelected(false);
        chkShThree.setSelected(false);
    }

    public String cmdLnkEdit1_action() {
        //return null means stay on the same page
       if ( selectedRow  != -1) {
            if (emp.get( selectedRow ).getDatabasStatus().equals("Old")) {
                emp.get( selectedRow ).setDatabasStatus("Edited");
            }
        }
        return null;
    }
}

