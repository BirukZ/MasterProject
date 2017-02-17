/*
 * TransportAbsenceDateRegistrationPage.java
 *
 * Created on Dec 14, 2012, 2:51:51 AM
 * Copyright Henok
 */
package fphrms.TransportPayment;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;

import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.TransportAbsenceDatePaymentManager.TransportPaymentsModel;
import manager.TransportAbsenceDatePaymentManager.TransportAbsenceDateRegistrationManager;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.JodanTimeCalender;
import manager.overTimeManager.ShiftTimeRegManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TransportAbsenceDateRegistrationPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    ArrayList<SelectItem> shift = new ArrayList<SelectItem>();
    ArrayList<SelectItem> inOut = new ArrayList<SelectItem>();
    ArrayList<SelectItem> serviceList = new ArrayList<SelectItem>();
    ShiftTimeRegManager shftmgr = new ShiftTimeRegManager();
    TransportAbsenceDateRegistrationManager transportAbsenceDateRegistrationManager = new TransportAbsenceDateRegistrationManager();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean selectedColumnRendered = false;
    List serviceAbsenceDateList = new ArrayList<TransportPaymentsModel>();
    ArrayList<TransportPaymentsModel> updateListOfServiceAbsence = new ArrayList<TransportPaymentsModel>();
    TransportPaymentsModel transportAbsenceDatePaymentModel = new TransportPaymentsModel();
    int buttonIdentifier = 0;
    private int absentCounter = 0;
    private int absentTablesize = 0;
    private int selectedAbsentRow = -1;
    private int absentId = 0;

    private void _init() throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        shift = shftmgr.selectShiftRegistration();
        inOut = transportAbsenceDateRegistrationManager.selectInOut();
        serviceList = transportAbsenceDateRegistrationManager.getServiceList();
        txtStartDate.setDisabled(true);
        txtEndDate.setDisabled(true);
        btnEndDate.setDisabled(true);
        btnStartDate.setDisabled(true);
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public ArrayList<TransportPaymentsModel> getUpdateListOfServiceAbsence() {
        return updateListOfServiceAbsence;
    }

    public void setUpdateListOfServiceAbsence(ArrayList<TransportPaymentsModel> updateListOfServiceAbsence) {
        this.updateListOfServiceAbsence = updateListOfServiceAbsence;
    }

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate calAppliedDate) {
        this.calAppliedDate = calAppliedDate;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate calStartDate) {
        this.calStartDate = calStartDate;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate calEndDate) {
        this.calEndDate = calEndDate;
    }

    public ArrayList<SelectItem> getSel() {
        return shift;
    }

    public void setSel(ArrayList<SelectItem> sel) {
        this.shift = sel;
    }

    public ArrayList<SelectItem> getInOut() {
        return inOut;
    }

    public void setInOut(ArrayList<SelectItem> inOut) {
        this.inOut = inOut;
    }

    public ArrayList<SelectItem> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<SelectItem> serviceList) {
        this.serviceList = serviceList;
    }
    private HtmlDataTable dataTable = new HtmlDataTable();

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable hdt) {
        this.dataTable = hdt;
    }
    private PanelLayout panelLayout3 = new PanelLayout();

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }
    private HtmlInputText txtAbsenceDate = new HtmlInputText();

    public HtmlInputText getTxtAbsenceDate() {
        return txtAbsenceDate;
    }

    public void setTxtAbsenceDate(HtmlInputText hit) {
        this.txtAbsenceDate = hit;
    }
    private HtmlCommandButton btnCalender = new HtmlCommandButton();

    public HtmlCommandButton getbtnCalender() {
        return btnCalender;
    }

    public void setbtnCalender(HtmlCommandButton hcb) {
        this.btnCalender = hcb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

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
    private HtmlSelectOneMenu drlShift = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlShift() {
        return drlShift;
    }

    public void setDrlShift(HtmlSelectOneMenu hsom) {
        this.drlShift = hsom;
    }
    private HtmlSelectOneMenu drlInOut = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlInOut() {
        return drlInOut;
    }

    public void setDrlInOut(HtmlSelectOneMenu drlInOut) {
        this.drlInOut = drlInOut;
    }
    private HtmlSelectOneMenu drlServiceDestination = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlServiceDestination() {
        return drlServiceDestination;
    }

    public void setDrlServiceDestination(HtmlSelectOneMenu hsom) {
        this.drlServiceDestination = hsom;
    }

    public List getServiceAbsenceDateList() {
        return serviceAbsenceDateList;
    }

    public void setServiceAbsenceDateList(ArrayList<TransportPaymentsModel> serviceAbsenceDateList) {
        this.serviceAbsenceDateList = serviceAbsenceDateList;
    }
    private HtmlCommandLink cmdLnkRemove = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkRemove() {
        return cmdLnkRemove;
    }

    public void setCmdLnkRemove(HtmlCommandLink cmdLnkRemove) {
        this.cmdLnkRemove = cmdLnkRemove;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkDaily = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkDaily() {
        return chkDaily;
    }

    public void setChkDaily(HtmlSelectBooleanCheckbox hsbc) {
        this.chkDaily = hsbc;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlCommandButton btnStartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnStartDate() {
        return btnStartDate;
    }

    public void setBtnStartDate(HtmlCommandButton hcb) {
        this.btnStartDate = hcb;
    }
    private HtmlCommandButton btnEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnEndDate() {
        return btnEndDate;
    }

    public void setBtnEndDate(HtmlCommandButton hcb) {
        this.btnEndDate = hcb;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private PanelPopup areuShurePlanPopUpMsg = new PanelPopup();

    public PanelPopup getAreuShurePlanPopUpMsg() {
        return areuShurePlanPopUpMsg;
    }

    public void setAreuShurePlanPopUpMsg(PanelPopup pp) {
        this.areuShurePlanPopUpMsg = pp;
    }
    private HtmlOutputText lblemployeePopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblemployeePopUpMsgMain() {
        return lblemployeePopUpMsgMain;
    }

    public void setLblemployeePopUpMsgMain(HtmlOutputText hot) {
        this.lblemployeePopUpMsgMain = hot;
    }

    public TransportAbsenceDateRegistrationPage() {
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
            log("TransportAbsenceDateRegistrationPage Initialization Failure", e);
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
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
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

    public String btnCalender_action() {
        //return null means stay on the same page
        calAppliedDate.setRendered(true);
        return null;
    }

    public String btnStartDate_action() {
        //return null means stay on the same page
        calStartDate.setRendered(true);
        return null;
    }

    public String btnEndDate_action() {
        //return null means stay on the same page
        calEndDate.setRendered(true);
        return null;
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtAbsenceDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        txtEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calEndDate.setRendered(false);
    }

    public String btnAddToTable_action() {
        //return null means stay on the same page
        if (isValidate()) {
            if (!chkDaily.isSelected()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel(
                        drlServiceDestination.getValue().toString().split("-")[0],
                        drlServiceDestination.getValue().toString().split("-")[1],
                        drlShift.getValue().toString(),
                        drlInOut.getValue().toString(),
                        txtAbsenceDate.getValue().toString(), absentId);
                if (buttonIdentifier == 1 || buttonIdentifier == 2) {
                    this.absentCounter++;
                    this.serviceAbsenceDateList.add(transportAbsenceDatePaymentModel);
                // btnEDDelete.setDisabled(false);
                //  btnEDSave.setDisabled(false);
                // this.btnEDEdit.setDisabled(false);
                } else if (buttonIdentifier == 3) {
                    //btnTrainingUpdate.setDisabled(false);
                    this.serviceAbsenceDateList.add(this.selectedAbsentRow, transportAbsenceDatePaymentModel);
                    this.updateListOfServiceAbsence.add(transportAbsenceDatePaymentModel);
                //  btnTrainingEdit.setDisabled(false);
                // btnTrainingDelete.setDisabled(false);
                //this.disableTrainingComponents();
                }

            } else {
                try {
                    DateFormat formatter;
                    Date startDate;
                    Date endDate;
//        String start = txtStartDate.getValue().toString();
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    startDate = (Date) formatter.parse(txtStartDate.getValue().toString());
                    endDate = (Date) formatter.parse(txtEndDate.getValue().toString());
                    Calendar startCal;
                    Calendar endCal;
                    startCal = Calendar.getInstance();
                    startCal.setTime(startDate);
                    endCal = Calendar.getInstance();
                    endCal.setTime(endDate);

                    endCal.getTime();


                    SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
                    JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();

                    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
                        return null;
                    }

                    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
                        startCal.setTime(endDate);
                        endCal.setTime(startDate);
                    }
                    do {

                        String strDate = dateformatter.format(startCal.getTime());

                        transportAbsenceDatePaymentModel = new TransportPaymentsModel(drlServiceDestination.getValue().toString().split("-")[0], drlServiceDestination.getValue().toString().split("-")[1],
                                drlShift.getValue().toString(), drlInOut.getValue().toString(), strDate, absentId);
                        serviceAbsenceDateList.add(transportAbsenceDatePaymentModel);
                        startCal.add(Calendar.DAY_OF_MONTH, 1);
                    } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            clearComponents();
        }

        return null;
    }

    private void makePageReadyForSave() {
//        overTimeRequestId = -1;
//        enableButtons();
//        enableRequestTextComponents();
//        enableRequestGeneralAttributes();
    }

    private void makePageReadyForUpdate() {
//        newOrEditOrUpdateLabel = "Update";
//        buttonAction = "Update";
//        statusColumnRendered = true;
//        selectedColumnRendered = false;
//        lnkViewPrevieousDecisions.setRendered(false);
//        selectedRequestFromHistoryList.setSelectedObject(null);
//        enableButtons();
//        enableRequestTextComponents();
//        enableParticipantTextComponents();
//        enableRequestGeneralAttributes();
    }

    private void makePageReadyForView() {
//        statusColumnRendered = false;
//        selectedColumnRendered = true;
//        lnkViewPrevieousDecisions.setRendered(true);
//        selectedRequestFromMyRequestList.setSelectedObject(null);
//        disableButtons();
//        disableRequestTextComponents();
//        disableParticipantTextComponents();
//        disableRequestGeneralAttributes();
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

    public String btnReset_action() {
        //return null means stay on the same page
        clearAllComponents();
        makePageReadyForSave();
        return null;
    }

    public void rowSelectorTransportAbsentDate_processMyEvent(RowSelectorEvent rse) {
        selectedAbsentRow = rse.getRow();
    }

    public String cmdLnkRemove_action() {
//        if (!buttonAction.equals("None")) {
//            if (serviceAbsenceDateList.get(selectedRow).getStatus().equals(TransportAbsenceDateRegistrationManager.DATABASE_STATUS_NEW)) {
//                serviceAbsenceDateList.remove(selectedRow);
//            } else if (serviceAbsenceDateList.get(selectedRow).getStatus().equals(TransportAbsenceDateRegistrationManager.DATABASE_STATUS_OLD)) {
//                serviceAbsenceDateList.get(selectedRow).setStatus(TransportAbsenceDateRegistrationManager.DATABASE_STATUS_OLDDELETED);
//            }
//        }
        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    boolean isValidate() {
        boolean result = true;
        int errorValue = 0;
        String errorMessage = "Required";
        if (!HRValidation.validateRequired(this.drlServiceDestination.getValue())) {
            ((UIInput) drlServiceDestination).setValid(false);
            error(drlServiceDestination, errorMessage);
            result = false;
        }
        if (!HRValidation.validateRequired(this.drlShift.getValue())) {
            ((UIInput) drlShift).setValid(false);
            error(drlShift, errorMessage);
            result = false;
        }
        if (!HRValidation.validateRequired(this.drlInOut.getValue())) {
            ((UIInput) drlInOut).setValid(false);
            error(drlInOut, errorMessage);
            result = false;
        }
        if (chkDaily.isSelected()) {
            errorValue = HRValidation.validateData(this.txtStartDate.getValue(), HRValidation.DATE_PATTERN2, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtStartDate).setValid(false);
                    error(txtStartDate, errorMessage);
                } else {
                    ((UIInput) txtStartDate).setValid(false);
                    error(txtStartDate, "Invalid Value");
                }
            }
            errorValue = HRValidation.validateData(this.txtEndDate.getValue(), HRValidation.DATE_PATTERN2, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtEndDate).setValid(false);
                    error(txtEndDate, errorMessage);
                } else {
                    ((UIInput) txtEndDate).setValid(false);
                    error(txtEndDate, "Invalid Value");
                }
            }
        } else {
            errorValue = HRValidation.validateData(this.txtAbsenceDate.getValue(), HRValidation.DATE_PATTERN2, true);

            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtAbsenceDate).setValid(false);
                    error(txtAbsenceDate, errorMessage);
                } else {
                    ((UIInput) txtAbsenceDate).setValid(false);
                    error(txtAbsenceDate, "Invalid Value");
                }
            }


        }






        return result;
    }

    public String btnSave_action() {
        //return null means stay on the same page



//        if (newOrEditOrUpdateLabel.equals("Save")) {

        List listOfAbsenceDate =
                getServiceAbsenceDateList().subList(absentTablesize, absentTablesize + absentCounter);

        if (transportAbsenceDateRegistrationManager.saveTransportAbsenceDate(listOfAbsenceDate)) {
            clearAllComponents();
            showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED: SAVING FAILED");
        }
//        } else {
//            if (transportAbsenceDateRegistrationManager.updateTransportAbsentDates(serviceAbsenceDateList)) {
//                showSuccessOrFailureMessage(true, "ALL CHANGES SAVED SUCCESSFULLY");
//                clearAllComponents();
//            } else {
//                showSuccessOrFailureMessage(false, "EXCEPTION OCCURED: UPDATING DATABASE FAILED");
//            }
//        }
        return null;
    }

    private void clearAllComponents() {
//        overTimeRequestId = -1;

        drlServiceDestination.setValue("");
        drlShift.setValue("");
        txtAbsenceDate.setValue(null);
        txtStartDate.setDisabled(true);
        txtEndDate.setDisabled(true);
        txtStartDate.setValue(null);
        txtEndDate.setValue(null);
        btnEndDate.setDisabled(true);
        btnStartDate.setDisabled(true);
        chkDaily.setSelected(false);
        serviceAbsenceDateList = new ArrayList<TransportPaymentsModel>();
    }

    private void clearComponents() {
//        overTimeRequestId = -1;

        drlServiceDestination.setValue(null);
        drlShift.setValue(null);
        txtAbsenceDate.setValue(null);
        txtStartDate.setDisabled(true);
        txtEndDate.setDisabled(true);
        txtStartDate.setValue(null);
        txtEndDate.setValue(null);
        btnEndDate.setDisabled(true);
        btnStartDate.setDisabled(true);
        chkDaily.setSelected(false);
    }

    private boolean populateTransportAbsenceDateList() {
        serviceAbsenceDateList = transportAbsenceDateRegistrationManager.getTransportAbsenceDates();
        absentTablesize = serviceAbsenceDateList.size();
        return true;
    }

    public String btnShowPrevious_action() {
        //return null means stay on the same page
        makePageReadyForUpdate();
        populateTransportAbsenceDateList();
        return null;
    }

    public void chkDaily_processValueChange(ValueChangeEvent vce) {
        if (chkDaily.isSelected()) {
            txtStartDate.setDisabled(false);
            txtEndDate.setDisabled(false);
            btnEndDate.setDisabled(false);
            btnStartDate.setDisabled(false);
        } else {
            txtStartDate.setDisabled(true);
            txtEndDate.setDisabled(true);
            btnEndDate.setDisabled(true);
            btnStartDate.setDisabled(true);
        }
    }

    public String btnNew_action() {
        this.buttonIdentifier = 1;
        chkDaily.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public String btnEdit_action() {
        this.buttonIdentifier = 3;
        if (this.selectedAbsentRow == -1) {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (this.selectedAbsentRow != -1 && this.getServiceAbsenceDateList().isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {
            TransportPaymentsModel transportPayment = (TransportPaymentsModel) getServiceAbsenceDateList().get(selectedAbsentRow);

            absentId = transportPayment.getAbsenceId();
//            txtTrainingName.setValue(trainingManager.getTrainingName());
//            txtTraStartDate.setValue(trainingManager.getStartDate());
//            drlInstitutionName.setValue(trainingManager.getInstitutionId());
//

            drlServiceDestination.setValue(transportPayment.getServiceId() + "-" + transportPayment.getServiceName());
            txtAbsenceDate.setValue(transportPayment.getAbsenceDate());
            drlShift.setValue(transportPayment.getShift());
            drlInOut.setValue(transportPayment.getInOut());
            getServiceAbsenceDateList().remove(selectedAbsentRow);
            chkDaily.setDisabled(true);
//            drlSponsoredBy.setValue(trainingManager.getSponsoredBy());
//            txtTraEndDate.setValue(trainingManager.getEndDate());
//            txtDuration.setValue(trainingManager.getDuration());
//            btnEDNew.setDisabled(true);
//            btnEDSave.setDisabled(true);
//            btnEDEdit.setDisabled(true);
//            btnEDUpdate.setDisabled(true);
//            btnEDReset.setDisabled(false);
//            btnEDDelete.setDisabled(true);
//            btnAddTraining.setDisabled(false);
//            this.enableTrainingComponents();
        }
        if (selectedAbsentRow >= absentTablesize) {
            //   buttonIdentifierEduc = 2;
            absentCounter--;
        }
        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        if (transportAbsenceDateRegistrationManager.updateTransportAbsentDates(updateListOfServiceAbsence)) {
            showSuccessOrFailureMessage(true, "ALL CHANGES SAVED SUCCESSFULLY");
            clearAllComponents();
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED: UPDATING DATABASE FAILED");
        }
        //return null means stay on the same page
        return null;
    }

   
    public String btnDelete_action() {
        //  disableTrainingComponents();
        //enableTrainingComponents();
        if (serviceAbsenceDateList.isEmpty()) {
            showSuccessOrFailureMessage(false, "The table is empty!!");
        } else if (selectedAbsentRow == -1) {
            showSuccessOrFailureMessage(false, "First select data from the table!!");
        } else {
            if (this.selectedAbsentRow <= absentTablesize) {
                areuShurePlanPopUpMsg.setRendered(true);
                lblemployeePopUpMsgMain.setValue("Are you sure you want to delete  this record ?");

            } else {
                this.absentCounter--;
                this.serviceAbsenceDateList.remove(selectedAbsentRow);
                buttonIdentifier = 2;

            }

        }
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpYes_action() {
        TransportPaymentsModel transportPayment = (TransportPaymentsModel) getServiceAbsenceDateList().get(selectedAbsentRow);
    if (transportAbsenceDateRegistrationManager.deleteAbsence(transportPayment.getAbsenceId())) {
            clearAllComponents();
            areuShurePlanPopUpMsg.setRendered(false);
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
        } else {
        areuShurePlanPopUpMsg.setRendered(false);
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED: DELETE FAILED");
        }
        selectedAbsentRow=-1;

        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpNo_action() {
        areuShurePlanPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }
}

