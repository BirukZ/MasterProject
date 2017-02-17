/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.OverTime;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import manager.departmentManage.DepartmentManage;
import manager.overTimeManager.MgrEmployeeShiftViewer;
import manager.overTimeManager.ShiftTimeRegManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ShiftTimeRegistration.java
 * @version Created on Mar 30, 2012, 9:44:57 PM
 * @author user
 */
public class ShiftTimeRegistrationPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private PanelLayout pnlLayoutTimePanel = new PanelLayout();

    public PanelLayout getPnlLayoutTimePanel() {
        return pnlLayoutTimePanel;
    }
    ArrayList<SelectItem> sel = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getSel() {
        return sel;
    }
    ShiftTimeRegManager shftmgr = new ShiftTimeRegManager();

    public void setSel(ArrayList<SelectItem> sel) {
        this.sel = sel;
    }

    public void setPnlLayoutTimePanel(PanelLayout pl) {
        this.pnlLayoutTimePanel = pl;
    }
    private HtmlInputText txtStartTime = new HtmlInputText();

    public HtmlInputText getTxtStartTime() {
        return txtStartTime;
    }

    public void setTxtStartTime(HtmlInputText hit) {
        this.txtStartTime = hit;
    }
    private HtmlInputText txtEndTime = new HtmlInputText();

    public HtmlInputText getTxtEndTime() {
        return txtEndTime;
    }

    public void setTxtEndTime(HtmlInputText hit) {
        this.txtEndTime = hit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drlShiftName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlShiftName() {
        return drlShiftName;
    }

    public void setDrlShiftName(HtmlSelectOneMenu hsom) {
        this.drlShiftName = hsom;
    }
    private HtmlInputText txtRegDate = new HtmlInputText();

    public HtmlInputText getTxtRegDate() {
        return txtRegDate;
    }

    public void setTxtRegDate(HtmlInputText hit) {
        this.txtRegDate = hit;
    }
    private HtmlCommandButton btnCalReg = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalReg() {
        return btnCalReg;
    }

    public void setBtnCalReg(HtmlCommandButton hcb) {
        this.btnCalReg = hcb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calendarRegDate = new SelectInputDate();

    public SelectInputDate getCalendarRegDate() {
        return calendarRegDate;
    }

    public void setCalendarRegDate(SelectInputDate sid) {
        this.calendarRegDate = sid;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private HtmlDataTable dataTable = new HtmlDataTable();

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable hdt) {
        this.dataTable = hdt;
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
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
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
    private HtmlSelectOneMenu drlAddress = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAddress() {
        return drlAddress;
    }

    public void setDrlAddress(HtmlSelectOneMenu hsom) {
        this.drlAddress = hsom;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ShiftTimeRegistrationPage() {
    }
    DepartmentManage departmentManage = new DepartmentManage();
    private static int tableSize = 0;
    private static int rowCounter = 0;
    private boolean initLoad = true;
    ArrayList<SelectItem> addressCodeList = departmentManage.getAddressCode();

    public ArrayList<SelectItem> getAddressCodeList() {
        return addressCodeList;
    }

    public void setAddressCodeList(ArrayList<SelectItem> addressCodeList) {
        this.addressCodeList = addressCodeList;
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
            log("ShiftTimeRegistration Initialization Failure", e);
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
        try {
//
            if (initLoad) {
                initLoad = false;
                sel = shftmgr.selectShiftRegistration();
                ArrayList<HashMap> shifts = shftvwr.selectAllShifts();
                if (shifts.size() > 0) {
                    tableSize = 0;
                    getSfttreg().clear();
                    for (HashMap hm : shifts) {
                        getSfttreg().add(new ICShiftTimeRegistration(hm.get("SHIFT_TIME_REG_ID").toString(), hm.get("START_TIME").toString(), hm.get("END_TIME").toString(), hm.get("SHIFT_CODE").toString(), hm.get("REGISTERED_DATE").toString(), hm.get("ADDRESS_CODE").toString()));
                        tableSize++;
                    }
                }
//            if (getSel().size() != getSfttreg().size()) {
//                btnAdd.setDisabled(false);
//            }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
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

    public String btnStartTime_action() {
        //return null means stay on the same page
        startOrEnd = "Start";
        String style = "border: 5px solid rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 400px; top: 70px; overflow: auto; position: absolute; width: 280px";
        pnlLayoutTimePanel.setStyle(style);
        pnlLayoutTimePanel.setRendered(true);
        return null;
    }
    String startOrEnd = "Start";

    public void optTxtForColumn10_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            if (startOrEnd.equals("Start")) {
                txtStartTime.setValue(displayedTime);
            } else {// if (startOrEnd.equals("End")) {
                txtEndTime.setValue(displayedTime);
            }
            pnlLayoutTimePanel.setRendered(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private PanelLayout pnlMessageBody = new PanelLayout();

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

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
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
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public String btnEndTime_action() {
        //return null means stay on the same page
        startOrEnd = "End";
        String style = "border: 5px solid rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 400px; top: 80px; overflow: auto; position: absolute; width: 280px";
        pnlLayoutTimePanel.setStyle(style);
        pnlLayoutTimePanel.setRendered(true);
        return null;
    }

    public void optTxtForColumn08_processAction(ActionEvent ae) {
        try {
            HtmlCommandLink selectedTime = (HtmlCommandLink) ae.getSource();
            String displayedTime = selectedTime.getValue().toString();
            if (startOrEnd.equals("Start")) {
                txtStartTime.setValue(displayedTime);
            } else {// if (startOrEnd.equals("End")) {
                txtEndTime.setValue(displayedTime);
            }
            pnlLayoutTimePanel.setRendered(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    ArrayList<ICShiftTimeRegistration> sfttreg = new ArrayList<ICShiftTimeRegistration>();

    public ArrayList<ICShiftTimeRegistration> getSfttreg() {
        return sfttreg;
    }

    public void setSfttreg(ArrayList<ICShiftTimeRegistration> sfttreg) {
        this.sfttreg = sfttreg;
    }

    public void pnlGrpPowerAllContent_processMyEvent(DragEvent de) {
    }

    public class ICShiftTimeRegistration {

        public ICShiftTimeRegistration(String start_time, String end_time, String shift_name, String registered_date, String address) {
            this.start_time = start_time;
            this.end_time = end_time;
            this.shift_name = shift_name;
            this.registered_date = registered_date;
            this.address = address;
        }
        public ICShiftTimeRegistration(String shift_time_registration, String start_time, String end_time, String shift_name, String registered_date, String address) {
            this.shift_time_registration = shift_time_registration;
            this.start_time = start_time;
            this.end_time = end_time;
            this.shift_name = shift_name;
            this.registered_date = registered_date;
            this.address = address;
        }
        String start_time, end_time, shift_name, registered_date, address, shift_time_registration;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getRegistered_date() {
            return registered_date;
        }

        public void setRegistered_date(String registered_date) {
            this.registered_date = registered_date;
        }

        public String getShift_name() {
            return shift_name;
        }

        public void setShift_name(String shift_name) {
            this.shift_name = shift_name;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getShift_time_registration() {
            return shift_time_registration;
        }

        public void setShift_time_registration(String shift_time_registration) {
            this.shift_time_registration = shift_time_registration;
        }

        
    }
    ShiftTimeRegManager mgrShft = new ShiftTimeRegManager();

    public String button2_action() {
//        Calendar currentDate = Calendar.getInstance();
//        SimpleDateFormat formatter =
//                new SimpleDateFormat("yyyy-MM-dd");
//        String dateNow = formatter.format(currentDate.getTime());
//        getSfttreg().add(new ICShiftTimeRegistration(txtStartTime.getValue().toString(), txtEndTime.getValue().toString(), drlShiftName.getValue().toString(), dateNow));
        //return null means stay on the same page
        return null;
    }
    MgrEmployeeShiftViewer shftvwr = new MgrEmployeeShiftViewer();

//    public String btnCancel_action() {
//        //return null means stay on the same page
//        btnAdd.setDisabled(false);
//        btnUpdate.setDisabled(true);
//        btnSave.setDisabled(false);
//        txtStartTime.setValue(null);
//        txtEndTime.setValue(null);
//        txtRegDate.setValue(null);
//        drlAddress.resetValue();
//        drlShiftName.resetValue();
//        return null;
//    }

    public ArrayList<HashMap> new_added() {

        ArrayList<HashMap> listAdded = new ArrayList<HashMap>();
        for (ICShiftTimeRegistration reg : getSfttreg().subList(tableSize, rowCounter + tableSize)) {
            HashMap _list = new HashMap();
            _list.put("Start_time", reg.getStart_time());
            _list.put("End_time", reg.getEnd_time());
            _list.put("Shift_name", reg.getShift_name());
            _list.put("Registered_date", reg.getRegistered_date());
            _list.put("Address_code", reg.getAddress());
            listAdded.add(_list);
        }
        return listAdded;
    }

    public String btnCalReg_action() {
        //return null means stay on the same page
        calendarRegDate.setRendered(true);
        return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void calendarRegDate_processValueChange(ValueChangeEvent vce) {
        txtRegDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calendarRegDate.setRendered(false);
    }

    private boolean isEndTimeValid(String startTime, String endTime) {
        float startTimeDbl = Float.parseFloat(startTime.replace(':', '.'));
        float endTimeDbl = Float.parseFloat(endTime.replace(':', '.'));
        return startTimeDbl < endTimeDbl;
    }
    OverTimeRequestPage otPage = new OverTimeRequestPage();

    public String btnAdd_action() {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter =
                new SimpleDateFormat("yyyy-MM-dd");
//        String dateNow = formatter.format(currentDate.getTime());

        boolean flag = false;
        boolean isBetween = false;
        HashMap shifts = new HashMap();

        for (ICShiftTimeRegistration shft : sfttreg) {
            //  int dateDiff = StringDateManipulation.compareDateDifference(shft.getRegistered_date(), txtRegDate.getValue().toString());
            if (shft.getShift_name().equalsIgnoreCase(drlShiftName.getValue().toString()) && shft.getAddress().equalsIgnoreCase(drlAddress.getValue().toString())) {
                flag = true;
            } else if (shft.getStart_time().equalsIgnoreCase(txtStartTime.getValue().toString()) && shft.getAddress().equalsIgnoreCase(drlAddress.getValue().toString())) {
                flag = true;
            } else if (shft.getEnd_time().equalsIgnoreCase(txtEndTime.getValue().toString()) && shft.getAddress().equalsIgnoreCase(drlAddress.getValue().toString())) {
                flag = true;
            }
        }

        if (flag || isEndTimeValid(txtEndTime.getValue().toString(), txtStartTime.getValue().toString())) {
            showSuccessOrFailureMessage(false, "Unable To Add!!Check the start and end time!");
        } else {

            getSfttreg().add(new ICShiftTimeRegistration(txtStartTime.getValue().toString(), txtEndTime.getValue().toString(), drlShiftName.getValue().toString(), txtRegDate.getValue().toString(), drlAddress.getValue().toString()));
            rowCounter++;
        }
        txtStartTime.resetValue();
        txtEndTime.resetValue();
        drlShiftName.resetValue();
        txtRegDate.resetValue();


        //return null means stay on the same page
        //return null means stay on the same page
        return null;
    }
    String shift_time_reg_id = null;
    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
        if (selectedRowIndex > -1) {
//            String shift_time_reg = null;
            txtStartTime.resetValue();
            txtEndTime.resetValue();
            drlShiftName.resetValue();
            txtRegDate.resetValue();
            txtStartTime.setValue(getSfttreg().get(selectedRowIndex).getStart_time());
            txtEndTime.setValue(getSfttreg().get(selectedRowIndex).getEnd_time());
            drlShiftName.setValue(getSfttreg().get(selectedRowIndex).getShift_name());
            txtRegDate.setValue(getSfttreg().get(selectedRowIndex).getRegistered_date());
            drlAddress.resetValue();
            drlAddress.setValue(getSfttreg().get(selectedRowIndex).getAddress());
            shift_time_reg_id = getSfttreg().get(selectedRowIndex).getShift_time_registration();
            btnAdd.setDisabled(true);
            btnUpdate.setDisabled(false);
            btnSave.setDisabled(true);
        }
    }

    public String btnUpdate_action() {
        try {
            int sucess = 0;
            boolean shifts = false;
//            for (ICShiftTimeRegistration rgstr : getSfttreg()) {
//                if (rgstr.getShift_name().equalsIgnoreCase(drlShiftName.getValue().toString())) {
//                    shifts = true;
//                }
//            }
            if (!shifts) {
                sucess = mgrShft.mgr_update_shift_time(shift_time_reg_id, txtStartTime.getValue().toString(), txtEndTime.getValue().toString(), drlShiftName.getValue().toString(), txtRegDate.getValue().toString());
                if (sucess > 0) {
                    initLoad = true;
                    showSuccessOrFailureMessage(true, "Updated Sucessfully!");
                } else {
                    showSuccessOrFailureMessage(false, "Unable to Update!");
                }
            } else {
                showSuccessOrFailureMessage(false, "Cannot update Repeted Values");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {
        try {
            int sucess = 0;
            ArrayList<HashMap> listAdded = new ArrayList<HashMap>();
            listAdded = new_added();
            for (HashMap reg : listAdded) {
                sucess = mgrShft.mgr_insert_shift_time(reg.get("Start_time").toString(), reg.get("End_time").toString(), reg.get("Shift_name").toString(), reg.get("Registered_date").toString(), drlAddress.getValue().toString());
            }
            if (sucess > 0) {
                showSuccessOrFailureMessage(true, "Shift Started!");
                initLoad = true;
                rowCounter = 0;
            } else {
                initLoad = false;
                showSuccessOrFailureMessage(false, "Unable to Start Shift!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnReset_action() {
        btnAdd.setDisabled(false);
        btnUpdate.setDisabled(true);
        btnSave.setDisabled(false);
        txtStartTime.setValue(null);
        txtEndTime.setValue(null);
        txtRegDate.setValue(null);
        drlAddress.resetValue();
        drlShiftName.resetValue();
        return null;
        //return null means stay on the same page
    }
}

