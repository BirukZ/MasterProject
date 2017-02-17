/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Termination;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import control.LookUpManger;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;
import manager.terminationManager.TerminationApproveManager;
import manager.terminationManager.TerminationRequestManager;
import manager.terminationManager.TerminationRequestManager.TerminationRequestModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version TerminationRequestPage.java
 * @version Created on Mar 2, 2011, 2:47:55 PM
 * @author user
 */
public class TerminationRequestPage extends AbstractPageBean {

    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromMyRequestList() {
        return selectedRequestFromMyRequestList;
    }

    public void setSelectedRequestFromMyRequestList(DefaultSelectedData selectedRequestFromMyRequestList) {
        this.selectedRequestFromMyRequestList = selectedRequestFromMyRequestList;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private SelectInputText txtEmployeeFullName = new SelectInputText();

    public SelectInputText getTxtEmployeeFullName() {
        return txtEmployeeFullName;
    }

    public void setTxtEmployeeFullName(SelectInputText sit) {
        this.txtEmployeeFullName = sit;
    }
    private HtmlInputText txtEmployeeDepartment1 = new HtmlInputText();

    public HtmlInputText getTxtEmployeeDepartment1() {
        return txtEmployeeDepartment1;
    }

    public void setTxtEmployeeDepartment1(HtmlInputText hit) {
        this.txtEmployeeDepartment1 = hit;
    }
    private HtmlInputText txtEmployeePosition = new HtmlInputText();

    public HtmlInputText getTxtEmployeePosition() {
        return txtEmployeePosition;
    }

    public void setTxtEmployeePosition(HtmlInputText hit) {
        this.txtEmployeePosition = hit;
    }

    public String getANOTHEREMPLOYEE() {
        return ANOTHEREMPLOYEE;
    }

    public void setANOTHEREMPLOYEE(String ANOTHEREMPLOYEE) {
        this.ANOTHEREMPLOYEE = ANOTHEREMPLOYEE;
    }

    public String getIMMEDIATEBOSS() {
        return IMMEDIATEBOSS;
    }

    public void setIMMEDIATEBOSS(String IMMEDIATEBOSS) {
        this.IMMEDIATEBOSS = IMMEDIATEBOSS;
    }

    public String getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(String requesterType) {
        this.requesterType = requesterType;
    }

    public TerminationRequestModel getTerminationRequestModel() {
        return terminationRequestModel;
    }

    public void setTerminationRequestModel(TerminationRequestModel terminationRequestModel) {
        this.terminationRequestModel = terminationRequestModel;
    }

    public String getTerminator() {
        return terminator;
    }

    public void setTerminator(String terminator) {
        this.terminator = terminator;
    }
    private HtmlCommandButton btnSearchOffender1 = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchOffender1() {
        return btnSearchOffender1;
    }

    public void setBtnSearchOffender1(HtmlCommandButton hcb) {
        this.btnSearchOffender1 = hcb;
    }
    private HtmlInputText txtPenality = new HtmlInputText();

    public HtmlInputText gettxtPenality() {
        return txtPenality;
    }

    public void settxtPenality(HtmlInputText hit) {
        this.txtPenality = hit;
    }
    private HtmlInputText txtSalary = new HtmlInputText();

    public HtmlInputText getTxtSalary() {
        return txtSalary;
    }

    public void setTxtSalary(HtmlInputText hit) {
        this.txtSalary = hit;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private HtmlSelectOneRadio radioGroupApplierType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadioGroupApplierType() {
        return radioGroupApplierType;
    }

    public void setRadioGroupApplierType(HtmlSelectOneRadio hsor) {
        this.radioGroupApplierType = hsor;
    }
    private HtmlCommandButton btnCalculatePenality = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalculatePenality() {
        return btnCalculatePenality;
    }

    public void setBtnCalculatePenality(HtmlCommandButton hcb) {
        this.btnCalculatePenality = hcb;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chksuccesisor = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChksuccesisor() {
        return chksuccesisor;
    }

    public void setChksuccesisor(HtmlSelectBooleanCheckbox hsbc) {
        this.chksuccesisor = hsbc;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists = hsol;
    }
    private PanelLayout pnlLayoutRequester = new PanelLayout();

    public PanelLayout getPnlLayoutRequester() {
        return pnlLayoutRequester;
    }

    public void setPnlLayoutRequester(PanelLayout pl) {
        this.pnlLayoutRequester = pl;
    }
    private PanelLayout pnlLayoutEmployee1 = new PanelLayout();

    public PanelLayout getPnlLayoutEmployee1() {
        return pnlLayoutEmployee1;
    }

    public void setPnlLayoutEmployee1(PanelLayout pl) {
        this.pnlLayoutEmployee1 = pl;
    }
    private PanelLayout pnlLayoutRequestInfo = new PanelLayout();

    public PanelLayout getPnlLayoutRequestInfo() {
        return pnlLayoutRequestInfo;
    }

    public void setPnlLayoutRequestInfo(PanelLayout pl) {
        this.pnlLayoutRequestInfo = pl;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TerminationRequestPage() {
    }
    TerminationRequestManager terminationRequestManager = new TerminationRequestManager();
    TerminationRequestModel terminationRequestModel = new TerminationRequestModel();
    EmployeeManage employeeManager = new EmployeeManage();
    LookUpManger lookupnger = new LookUpManger();
  //  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String newOrEditOrUpdateLabel = "Save";
    String today = dateFormat.format(new Date());
    private int terminationRequestId = -1;//@Column(name = "TERMINATION_REQUEST_ID")
    private String requesterId;// @Column(name = "REQUESTER_ID")
    private String terminator;
    private String terminatornBirthDate;
    private int ageOfRetireNew;
    private int terminationCatagory;// @Column(name = "TERMINATION_CATAGORY")
    private int terminationType;// @Column(name = "TERMINATION_TYPE")
    private String requestStatus;// @Column(name = "REQUEST_STATUS")
    private String appliedDate;//@Column(name = "APPLIED_DATE")
    private String terminationDate;//  @Column(name = "TERMINATION_DATE")
    private String description;// @Column(name = "DESCRIPTION")
    private String documentReferenceNumber;//  @Column(name = "IS_DOCUMEENT_ATTACHED")
    private String recordedBy;// @Column(name = "RECORDED_BY")
    private String recorededDateAndTime;// @Column(name = "RECOREDED_DATE_AND_TIME")
    public String IMMEDIATEBOSS = TerminationRequestManager.REQUERSTER_TYPE_IMMEDIATEBOSS;
    public String ANOTHEREMPLOYEE = TerminationRequestManager.REQUERSTER_TYPE_ANOTHEREMPLOYEE;
    ArrayList<Option> terminationCatagories = new ArrayList<Option>();
    //terminationRequestManager.getTerminationCatagories();
    ArrayList<Option> terminationTypes = terminationRequestManager.getTerminationTypes(0);
    ArrayList<SelectItem> pendingRequestLists = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryLists = new ArrayList<SelectItem>();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    String userName;
    Date selectedTerminationDate;
    String loggedInEmployeeId;
    String loggedInDepartmentId;
    String requesterType = IMMEDIATEBOSS;
    double penalityPay;
    String hasSuccesioser;


    //<editor-fold desc="clearComponents(), populateComponents()">
    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);

        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(empInfoHashMap.get("employeeId"));
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));

                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateEmployeeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        HashMap empInfoHashMaps = terminationRequestManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                terminator = empInfoHashMap.get("employeeId").toString();
                txtEmployeeDepartment1.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtEmployeeId.setValue(terminator);
                txtEmployeePosition.setValue(empInfoHashMap.get("employeePosition"));
                txtSalary.setValue(empInfoHashMaps.get("EMPSALARY"));
                terminatornBirthDate=empInfoHashMaps.get("DATE_OF_BIRTH").toString();
                this.populateAllBirtDate(terminatornBirthDate);

                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }
     private int populateAllBirtDate(String dateOfBirth) {
        int ageOfretire = GregorianCalendarManipulation.calaculateYearDifference(dateOfBirth);
        ageOfRetireNew = ageOfretire;
        return ageOfRetireNew;
    }

    private void populateDecisionHistory(int terminationRequestId) {
        decisionsMadeOnRequest = (new TerminationApproveManager()).getRequestHistory(terminationRequestId);
        if (decisionsMadeOnRequest.size() > 0) {
        } else {
            //  lnkViewPrevieousDecisions.setRendered(false);
            makePageReadyForUpdate();
        }

    }

    public int getAgeOfRetireNew() {
        return ageOfRetireNew;
    }

    public void setAgeOfRetireNew(int ageOfRetireNew) {
        this.ageOfRetireNew = ageOfRetireNew;
    }





    public String getTerminatornBirthDate() {
        return terminatornBirthDate;
    }

    public void setTerminatornBirthDate(String terminatornBirthDate) {
        this.terminatornBirthDate = terminatornBirthDate;
    }

   

    private void makePageReadyForSave() {
        newOrEditOrUpdateLabel = "Save";
        enableButtons();
    }

    private void makePageReadyForUpdate() {
        newOrEditOrUpdateLabel = "Update";
        enableButtons();
    }

    private void makePageReadyForView() {
        newOrEditOrUpdateLabel = "Save";
        disableButtons();
    }

    private void disableButtons() {
        btnSaveOrEditOrUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
    }

    private void enableButtons() {
        btnSaveOrEditOrUpdate.setDisabled(false);
        btnDelete.setDisabled(false);
    }

    private boolean populateTerminationRequestComponents(int requestId) {

        terminationRequestModel = terminationRequestManager.getTerminationrequestInformation(requestId);
        if (terminationRequestModel != null) {
            if (terminationRequestModel.getTerminationRequestId() == -1) {
                showSuccessOrFailureMessage(false, "NO RECORD  FOUND WITH ID REQUEST ID : ");
                return false;
            } else {
                terminationRequestId = terminationRequestModel.getTerminationRequestId();
                txtAppliedDate.setValue(terminationRequestModel.getAppliedDate());
                txtTerminationDate.setValue(terminationRequestModel.getTerminationDate());
                // calTerminationDate.setValue(terminationRequestModel.getTerminationDate());
                txtaDescription.setValue(terminationRequestModel.getDescription());
                int catego = terminationRequestModel.getTerminationCatagory();
                String cat = String.valueOf(catego);
                drlTerminationCatagory.resetValue();
                drlTerminationCatagory.setValue(cat);
                terminationTypes = terminationRequestManager.getTerminationTypes(catego);
                int types = terminationRequestModel.getTerminationType();
                String type = String.valueOf(types);
              
                drlTerminationType.setValue(type);
                txtDocReferenceNumber.setValue(terminationRequestModel.getDocumeentReferenceNumber());
                txtPenality.setValue(terminationRequestModel.getPenalityPay());
                requesterType = terminationRequestModel.getRequesterType();
                if (requesterType.equals("IB")) {
                    radioGroupApplierType.setValue(IMMEDIATEBOSS);

                } else {
                    radioGroupApplierType.setValue(ANOTHEREMPLOYEE);

                }
                if (((terminationRequestModel.getTerminationType() == 4)) || (terminationRequestModel.getTerminationType() == 5) || (terminationRequestModel.getTerminationType() == 1) || terminationRequestModel.getTerminationType() == 7) {
                    penalityPay = 0;
                    btnCalculatePenality.setDisabled(true);
                    txtPenality.setValue(penalityPay);
                } else {
                    btnCalculatePenality.setDisabled(false);
                    txtPenality.setValue(terminationRequestModel.getPenalityPay());
                }
                if (terminationRequestModel.getHasSuccesioser().equals("Yes")) {
                    btnCalculatePenality.setDisabled(true);
                    chksuccesisor.setSelected(true);
                    penalityPay = 0;
                    txtPenality.setValue(penalityPay);
                    hasSuccesioser = "Yes";
                } else {
                    btnCalculatePenality.setDisabled(false);
                    chksuccesisor.setSelected(false);
                    hasSuccesioser = "No";
                    txtPenality.setValue(terminationRequestModel.getPenalityPay());
                }
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        return null;
    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);

        requesterId = null;
    }

    private void clearTerminatorTextComponents() {
        txtEmployeeDepartment1.setValue(null);
        txtEmployeeFullName.setValue(null);
        txtEmployeeId.setValue(null);
        txtEmployeePosition.setValue(null);
        txtSalary.setValue(null);

        terminator = null;
    }

    private void clearRequestComponents() {
        drlTerminationCatagory.setValue("-1");
        radioGroupApplierType.setValue(null);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
        txtTerminationDate.setValue(null);
        txtaDescription.setValue(null);
        txtDocReferenceNumber.setValue(null);
        txtPenality.setValue(null);
        terminationTypes = terminationRequestManager.getTerminationTypes(0);

    }

    private void clearSelectedObjects() {
        selectedRequestFromHistoryList.setSelectedObject(null);
        selectedRequestFromMyRequestList.setSelectedObject(null);
    }

    private void clearDecisionTable() {
        decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    }

    private void clearAllComponents() {
        clearRequestComponents();
        clearRequesterTextComponents();
        selectMyHistoryLists.setValue(null);
        selectPending.setValue(null);
        makePageReadyForSave();
        clearTerminatorTextComponents();
    }
    //</editor-fold>

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public void lblAttachFile_processMyEvent(DragEvent de) {
    }

    public String lnkDocumentAttached_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String lnkAttachedRemove_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String btnChangeAppliedDate_action() {
        calAppliedDate.setRendered(true);
        return null;
    }

    public void calTerminationDate_processValueChange(ValueChangeEvent vce) {
        txtTerminationDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calTerminationDate.setRendered(false);
    }

    public String btnCalendarTerminationDate_action() {
        calTerminationDate.setRendered(true);
        return null;
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtAppliedDate.setValue(dateFormat.format(calAppliedDate.getValue()));
        calAppliedDate.setRendered(false);
    }

    private void intializeRequestAttributes()
    {
        Date selectedAppliedDate = (Date) calAppliedDate.getValue();
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
//            if (calTerminationDate.isRendered() && txtTerminationDate.getValue().toString().isEmpty()) {
//                selectedTerminationDate = (Date) calTerminationDate.getValue();
//            } else
            if (txtTerminationDate.getValue().toString() != null) {
                date = (Date) formatter.parse(txtTerminationDate.getValue().toString());
                selectedTerminationDate = date;
            }
        } catch (Exception es) {
            es.printStackTrace();

        }
        long dateDifference = (selectedTerminationDate.getTime() - selectedAppliedDate.getTime()) / (1000 * 60 * 60 * 24);
        double Salary = Double.valueOf(txtSalary.getValue().toString());
        requesterId = txtRequesterId.getValue().toString();
        terminationCatagory =
                Integer.valueOf(drlTerminationCatagory.getValue().toString());
        terminationType =
                Integer.valueOf(drlTerminationType.getValue().toString());
        appliedDate =
                txtAppliedDate.getValue().toString();
        terminationDate =
                txtTerminationDate.getValue().toString();
        description =
                txtaDescription.getValue() == null ? "" : txtaDescription.getValue().toString();
        documentReferenceNumber =
                txtDocReferenceNumber.getValue() == null ? "" : txtDocReferenceNumber.getValue().toString();
//        if ((terminationType == 4) || (terminationType == 5) || (terminationType == 1) || (terminationType == 7)) {
//            penalityPay = 0;
//            btnCalendarTerminationDate.setDisabled(true);
//            txtPenality.setValue(penalityPay);
//        } else if (dateDifference <= 0) {
//            txtPenality.setValue(txtSalary.getValue().toString());
//            penalityPay = Double.valueOf(txtPenality.getValue().toString());
//        } else if (dateDifference < 26) {
//            dateDifference = 26 - dateDifference;
//            double penality = (Salary / 26) * dateDifference;
//            txtPenality.setValue(penality);
//            penalityPay = Double.valueOf(txtPenality.getValue().toString());
//        }
//        if (chksuccesisor.isSelected()) {
//
//            btnCalculatePenality.setDisabled(true);
//            penalityPay = 0;
//            txtPenality.setValue(penalityPay);
//            hasSuccesioser="Yes";
//        }

    }

    public boolean saveTerminationRequest() {

        if (terminationRequestManager.saveTerminationRequestInformation(requesterId, terminationCatagory, terminationType, appliedDate, terminationDate, description, documentReferenceNumber, requesterType, terminator)) {
            pendingRequestLists = terminationRequestManager.getPendingTerminationRequests();
            clearAllComponents();

            showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
            makePageReadyForSave();

            return true;
        } else {
            showSuccessOrFailureMessage(false, "! EXCEPTION OCCURED \nAND YOUR RECORD IS NOT SAVED,\n PLEASE TRY AGAIN");
        }

        return false;
    }

    public boolean updateTerminationRequest() {
        if (terminationRequestId == -1) {
            return false;//can not occur unless some unexpected event occurs
        } else {

            if (terminationRequestManager.updateTerminationRequestInformation(terminationRequestId, requesterId, terminationCatagory, terminationType, appliedDate, terminationDate, description, documentReferenceNumber, requesterType, terminator, penalityPay, hasSuccesioser)) {
                showSuccessOrFailureMessage(true, "UPDATIND SUCCESSFULL");
                clearRequesterTextComponents();

                makePageReadyForSave();

                return true;
            } else {
                showSuccessOrFailureMessage(false, "! EXCEPTION OCCURED \nAND YOUR RECORD IS NOT UPDATED,\n PLEASE TRY AGAIN");
                return false;
            }
        }
    }

    public boolean deletePowerDeligation() {
        if (terminationRequestId != -1) {
            if (terminationRequestManager.deletePowerDeligationRequest(terminationRequestId)) {
                pendingRequestLists = terminationRequestManager.getPendingTerminationRequests();
                return true;
            }
        }
        return false;
    }

    public void enableComponents() {
        txtAppliedDate.setDisabled(false);
        txtDocReferenceNumber.setDisabled(false);
        txtRequesterDepartment.setDisabled(false);
        txtRequesterFullName.setDisabled(false);
        txtTerminationDate.setDisabled(false);
        txtaDescription.setDisabled(false);
    }

    public void disableComponenets() {
        txtAppliedDate.setDisabled(true);
        txtDocReferenceNumber.setDisabled(true);
        txtRequesterDepartment.setDisabled(true);
        txtRequesterFullName.setDisabled(true);
        txtTerminationDate.setDisabled(true);
        txtaDescription.setDisabled(true);
    }

    public boolean validateAndInitializeTerminationAttributes() {
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
//            if (calTerminationDate.isRendered() && txtTerminationDate.getValue().toString().isEmpty()) {
//                selectedTerminationDate = (Date) calTerminationDate.getValue();
//            } else
            if (txtTerminationDate.getValue().toString() != null) {
                date = (Date) formatter.parse(txtTerminationDate.getValue().toString());
                selectedTerminationDate = date;
            }
        } catch (Exception es) {
            es.printStackTrace();

        }
        Date selectedAppliedDate = (Date) new Date();

        long dateDifference = (selectedTerminationDate.getTime() - selectedAppliedDate.getTime()) / (1000 * 60 * 60 * 24);
        double Salary = Double.valueOf(txtSalary.getValue().toString());
        if (txtRequesterId.getValue() == null || txtRequesterId.getValue().toString().equals("")) {
            showSuccessOrFailureMessage(false, "SELECT EMPLOYEE WHO REQUEST TERMINATION FIRST");
            return false;
        } else if (drlTerminationType.getValue() == null || drlTerminationType.getValue().toString().equals(null)) {
            showSuccessOrFailureMessage(false, "SELECT CORRECT TERMINATION REQUEST CATAGORY AND TYPE");
            return false;
        } ///888888888888888888888888888888888888888888888
        //        else if ((selectedAppliedDate.after(selectedTerminationDate) && selectedTerminationDate.before(selectedAppliedDate))) {
        //            showSuccessOrFailureMessage(false, "YOU USED A PAST APPLIED DATE OF A PAST TERMINATION DATE\n IMPOSSIBLE");
        //            return false;
        //        }
        else if (!loggedInEmployeeId.equals(txtRequesterId.getValue().toString()) && (txtDocReferenceNumber.getValue() == null || txtDocReferenceNumber.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "PLEASE INSERT DOCUMENT REFERENCE NUMBER");
            return false;
        } else {
            intializeRequestAttributes();
            return true;
        }

    }

    public boolean isEntryValidForSearch() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtRequesterId.getValue());
        if (!required) {
            ((UIInput) txtRequesterId).setValid(false);
            error(txtRequesterId, errorMessage);
            results = false;
        }
        return results;
    }

    public boolean isEntryValidForTermination() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.drlTerminationCatagory.getValue());
        if (!required) {
            ((UIInput) drlTerminationCatagory).setValid(false);
            error(drlTerminationCatagory, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtRequesterDepartment.getValue());
        if (!required) {
            ((UIInput) txtRequesterDepartment).setValid(false);
            error(txtRequesterDepartment, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtRequesterFullName.getValue());
        if (!required) {
            ((UIInput) txtRequesterFullName).setValid(false);
            error(txtRequesterFullName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtRequesterPosition.getValue());
        if (!required) {
            ((UIInput) txtRequesterPosition).setValid(false);
            error(txtRequesterPosition, errorMessage);
            results = false;
        }

        required = HRValidation.validateRequired(this.txtEmployeeDepartment1.getValue());
        if (!required) {
            ((UIInput) txtEmployeeDepartment1).setValid(false);
            error(txtEmployeeDepartment1, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtEmployeeFullName.getValue());
        if (!required) {
            ((UIInput) txtEmployeeFullName).setValid(false);
            error(txtEmployeeFullName, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtEmployeePosition.getValue());
        if (!required) {
            ((UIInput) txtEmployeePosition).setValid(false);
            error(txtEmployeePosition, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.drlTerminationType.getValue());
        if (!required) {
            ((UIInput) drlTerminationType).setValid(false);
            error(drlTerminationType, errorMessage);
            results = false;
        }
        required = HRValidation.validateRequired(this.txtDocReferenceNumber.getValue());
        if (!required) {
            ((UIInput) txtDocReferenceNumber).setValid(false);
            error(txtDocReferenceNumber, errorMessage);
            results = false;
        }

        required = HRValidation.validateRequired(this.txtAppliedDate.getValue());
        if (!required) {
            ((UIInput) txtAppliedDate).setValid(false);
            error(txtAppliedDate, errorMessage);
            results = false;
        }
        errorValue = HRValidation.validateData(this.txtTerminationDate.getValue(), HRValidation.DATE_PATTERN2, true);
        if (errorValue != 0) {
            results = false;
            if (errorValue == 1) {
                ((UIInput) txtTerminationDate).setValid(false);
                error(txtTerminationDate, errorMessage);
            } else {
                ((UIInput) txtTerminationDate).setValid(false);
                error(txtTerminationDate, "Invalid Value");
            }
        }
        return results;
    }

    public String btnSaveOrEditOrUpdate_action() {

        if (isEntryValidForTermination())
        {
            if (validateAndInitializeTerminationAttributes()) {


                if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
                    btnSaveOrEditOrUpdate.setDisabled(false);//if ready to save
                    saveTerminationRequest();
                    clearAllComponents();
                  //  return "GenerateQuestionnairs";
                } else {

                    updateTerminationRequest();
                    clearAllComponents();
                   // return "GenerateQuestionnairs";
                }




            }
        }
        return null;
    }

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public void btnRequesterIdSearch_processAction(ActionEvent ae) {
    }

    public boolean deleteTerminationRequest() {
        if (terminationRequestId != -1) {
            return terminationRequestManager.deletePowerDeligationRequest(terminationRequestId);
        } else {
            return false;
        }

    }

    public String btnPopupOkDelete_action() {
        if (deleteTerminationRequest()) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFUL");
            clearAllComponents();

        } else {
            showSuccessOrFailureMessage(false, "SORRY DELETE NOT SUCCESSFUL\n PLEASE TRY AGAIN");
        }

        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }

    public String btnPopupCancelDelete_action() {
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }

    public String btnReset_action() {
        clearAllComponents();

        //txtAppliedDate.resetValue();
        return null;
    }

    public String btnRequesterIdSearch_action() {
        if (txtRequesterId.getValue() != null) {
            requesterId = txtRequesterId.getValue().toString();

            if (populateRequesterTextComponents(requesterId)) {
                //if employee exists employeeserviceyear
                //populate other parameters, and photo
                //check if the employee has a request
                terminationRequestId = terminationRequestManager.getEmplyeeLatestTerminationRequestId(requesterId);
                if (terminationRequestId != -1) {
                    pnlPopupConfirmViewRequest.setRendered(true);
                } else {
                    makePageReadyForSave();
                }

            } else {
                requesterId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + requesterId);
            }

        } else {
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }

        return null;
    }

    public String btnPopupConfirmViewRequestYes_action() {
        pnlPopupConfirmViewRequest.setRendered(false);
        populateTerminationRequestComponents(terminationRequestId);
        makePageReadyForUpdate();

        return null;
    }

    public String btnPopupConfirmViewRequestNo_action() {
        pnlPopupConfirmViewRequest.setRendered(false);
        clearAllComponents();

        return null;
    }

    public void pnlGroupAll_processMyEvent(DragEvent de) {
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
//<editor-fold desc="All Getters and Setters">

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public String getIsDocumeentAttached() {
        return documentReferenceNumber;
    }

    public void setIsDocumeentAttached(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getRecorededDateAndTime() {
        return recorededDateAndTime;
    }

    public void setRecorededDateAndTime(String recorededDateAndTime) {
        this.recorededDateAndTime = recorededDateAndTime;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public ArrayList<Option> getTerminationCatagories() {
        return terminationCatagories;
    }

    public void setTerminationCatagories(ArrayList<Option> terminationCatagories) {
        this.terminationCatagories = terminationCatagories;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public int getTerminationRequestId() {
        return terminationRequestId;
    }

    public void setTerminationRequestId(int terminationRequestId) {
        this.terminationRequestId = terminationRequestId;
    }

    public TerminationRequestManager getTerminationRequestManager() {
        return terminationRequestManager;
    }

    public void setTerminationRequestManager(TerminationRequestManager terminationRequestManager) {
        this.terminationRequestManager = terminationRequestManager;
    }

    public LookUpManger getLookupnger() {
        return lookupnger;
    }

    public void setLookupnger(LookUpManger lookupnger) {
        this.lookupnger = lookupnger;
    }

    public double getPenalityPay() {
        return penalityPay;
    }

    public void setPenalityPay(double penalityPay) {
        this.penalityPay = penalityPay;
    }

    public int getTerminationCatagory() {
        return terminationCatagory;
    }

    public void setTerminationCatagory(int terminationCatagory) {
        this.terminationCatagory = terminationCatagory;
    }

    public int getTerminationType() {
        return terminationType;
    }

    public void setTerminationType(int terminationType) {
        this.terminationType = terminationType;
    }

    public ArrayList<Option> getTerminationTypes() {
        return terminationTypes;
    }

    public void setTerminationTypes(ArrayList<Option> terminationTypes) {
        this.terminationTypes = terminationTypes;
    }

    public void drlTerminationCatagory_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {

                terminationCatagory = Integer.valueOf(vce.getNewValue().toString().split("-")[0]);

                terminationTypes = terminationRequestManager.getTerminationTypes(terminationCatagory);
            }
        } catch (Exception e) {
        }
    }

    public String getLoggedInDepartmentId() {
        return loggedInDepartmentId;
    }

    public void setLoggedInDepartmentId(String loggedInDepartmentId) {
        this.loggedInDepartmentId = loggedInDepartmentId;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public String getToday() {
        return today;
    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public ArrayList<SelectItem> getRequestHistoryLists() {
        return requestHistoryLists;
    }

    public void setRequestHistoryLists(ArrayList<SelectItem> requestHistoryLists) {
        this.requestHistoryLists = requestHistoryLists;
    }

    public ArrayList<SelectItem> getPendingRequestLists() {
        return pendingRequestLists;
    }

    public void setPendingRequestLists(ArrayList<SelectItem> pendingRequestLists) {
        this.pendingRequestLists = pendingRequestLists;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String btnTreeDepartment_action() {
        //return null means stay on the same page
        return null;
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

    public String lnkTerminationApprove_action() {
        return "TerminationApprove";
    }

    public String lnkAuthorization_action() {
        return "Authorization";
    }

    public void selectPending_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {

            String requestAttributes[] = vce.getNewValue().toString().split("--");
            terminationRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            appliedDate = requestAttributes[2];
            requestStatus = requestAttributes[3];
            terminator = requestAttributes[4];
            populateTerminationRequestComponents(terminationRequestId);
            populateRequesterTextComponents(requesterId);
            populateEmployeeTextComponents(terminator);
            makePageReadyForUpdate();
            selectMyHistoryLists.setValue(null);
        }
    }

    ////////////////////////
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        userName = getSessionBean1().getUserName();
        terminationRequestManager.setUserName(userName);
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInDepartmentId = getSessionBean1().getEmpDeptId();
        terminationRequestManager.setDepartment(loggedInDepartmentId);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
        pendingRequestLists = terminationRequestManager.getPendingTerminationRequests();
        requestHistoryLists = terminationRequestManager.getHistorryTerminationRequests();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private DefaultSelectedData selectObjectOfTerminationCatagory = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfTerminationType = new DefaultSelectedData();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
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

    public DefaultSelectedData getSelectObjectOfTerminationCatagory() {
        return selectObjectOfTerminationCatagory;
    }

    public void setSelectObjectOfTerminationCatagory(DefaultSelectedData selectObjectOfTerminationCatagory) {
        this.selectObjectOfTerminationCatagory = selectObjectOfTerminationCatagory;
    }

    public DefaultSelectedData getSelectObjectOfTerminationType() {
        return selectObjectOfTerminationType;
    }

    public void setSelectObjectOfTerminationType(DefaultSelectedData selectObjectOfTerminationType) {
        this.selectObjectOfTerminationType = selectObjectOfTerminationType;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calTerminationDate = new SelectInputDate();

    public SelectInputDate getCalTerminationDate() {
        return calTerminationDate;
    }

    public void setCalTerminationDate(SelectInputDate sid) {
        this.calTerminationDate = sid;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
    }
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText txtRequesterFullName) {
        this.txtRequesterFullName = txtRequesterFullName;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlSelectOneMenu drlTerminationCatagory1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTerminationCatagory1() {
        return drlTerminationCatagory1;
    }

    public void setDrlTerminationCatagory1(HtmlSelectOneMenu hsom) {
        this.drlTerminationCatagory1 = hsom;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
    }
    private HtmlInputText txtTerminationDate = new HtmlInputText();

    public HtmlInputText getTxtTerminationDate() {
        return txtTerminationDate;
    }

    public void setTxtTerminationDate(HtmlInputText hit) {
        this.txtTerminationDate = hit;
    }
    private HtmlCommandButton btnCalendarTerminationDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalendarTerminationDate() {
        return btnCalendarTerminationDate;
    }

    public void setBtnCalendarTerminationDate(HtmlCommandButton hcb) {
        this.btnCalendarTerminationDate = hcb;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate sid) {
        this.calAppliedDate = sid;
    }
    private HtmlCommandButton btnSearchRequester = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchRequester() {
        return btnSearchRequester;
    }

    public void setBtnSearchRequester(HtmlCommandButton hcb) {
        this.btnSearchRequester = hcb;
    }

// </editor-fold>
//<editor-fold defaultstate="collapsed" desc="init(), prerender()...">
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
            log("TerminationRequestPage Initialization Failure", e);
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
        if (terminationCatagories.isEmpty() || (lookupnger.getEmpitiedTableList() != null && lookupnger.getEmpitiedTableList().contains("HR_LU_TERMINATION_CATEGORY"))) {
            terminationCatagories = terminationRequestManager.getTerminationCatagories();

            lookupnger.getEmpitiedTableList().remove("HR_LU_TERMINATION_CATEGORY");
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
    private HtmlInputText txtRequesterDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment() {
        return txtRequesterDepartment;
    }

    public void setTxtRequesterDepartment(HtmlInputText hit) {
        this.txtRequesterDepartment = hit;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlTerminationType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTerminationType() {
        return drlTerminationType;
    }

    public void setDrlTerminationType(HtmlSelectOneMenu hsom) {
        this.drlTerminationType = hsom;
    }
    private HtmlSelectOneMenu drlTerminationCatagory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTerminationCatagory() {
        return drlTerminationCatagory;
    }

    public void setDrlTerminationCatagory(HtmlSelectOneMenu hsom) {
        this.drlTerminationCatagory = hsom;
    }
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pp) {
        this.pnlPopupConfirmDelete = pp;
    }
    private HtmlCommandButton btnPopupOkDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopupOkDelete() {
        return btnPopupOkDelete;
    }

    public void setBtnPopupOkDelete(HtmlCommandButton hcb) {
        this.btnPopupOkDelete = hcb;
    }
    private HtmlCommandButton btnPopupCancelDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopupCancelDelete() {
        return btnPopupCancelDelete;
    }

    public void setBtnPopupCancelDelete(HtmlCommandButton hcb) {
        this.btnPopupCancelDelete = hcb;
    }
    private HtmlOutputText outputText3 = new HtmlOutputText();

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setOutputText3(HtmlOutputText hot) {
        this.outputText3 = hot;
    }
    private PanelPopup pnlPopupConfirmViewRequest = new PanelPopup();

    public PanelPopup getPnlPopupConfirmViewRequest() {
        return pnlPopupConfirmViewRequest;
    }

    public void setPnlPopupConfirmViewRequest(PanelPopup pp) {
        this.pnlPopupConfirmViewRequest = pp;
    }
    private DefaultSelectedData selectObjectOfPendingBean = new DefaultSelectedData();
    private DefaultSelectedData selectObjectOfMyRequestsBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectObjectOfMyRequestsBean() {
        return selectObjectOfMyRequestsBean;
    }

    public void setSelectObjectOfMyRequestsBean(DefaultSelectedData selectObjectOfMyRequestsBean) {
        this.selectObjectOfMyRequestsBean = selectObjectOfMyRequestsBean;
    }

    public DefaultSelectedData getSelectObjectOfPendingBean() {
        return selectObjectOfPendingBean;
    }

    public void setSelectObjectOfPendingBean(DefaultSelectedData selectObjectOfPendingBean) {
        this.selectObjectOfPendingBean = selectObjectOfPendingBean;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }
    private HtmlSelectOneListbox selectPending = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectPending() {
        return selectPending;
    }

    public void setSelectPending(HtmlSelectOneListbox hsol) {
        this.selectPending = hsol;
    }
    private HtmlCommandButton btnSaveOrEditOrUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveOrEditOrUpdate() {
        return btnSaveOrEditOrUpdate;
    }

    public void setBtnSaveOrEditOrUpdate(HtmlCommandButton hcb) {
        this.btnSaveOrEditOrUpdate = hcb;
    }

    public void selectMyRequests_processValueChange(ValueChangeEvent vce) {
    }

    public String lnkViewPrevieousDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {

        if (vce != null) {

            String requestAttributes[] = vce.getNewValue().toString().split("--");
            terminationRequestId = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            appliedDate = requestAttributes[2];
            requestStatus = requestAttributes[3];
            terminator = requestAttributes[4];
            populateTerminationRequestComponents(terminationRequestId);
            populateRequesterTextComponents(requesterId);
            populateEmployeeTextComponents(terminator);
            makePageReadyForView();
            selectPending.setValue(null);
        }

    }

    public String btnSearchRequester_action() {
        //return null means stay on the same page
        if (isEntryValidForSearch()) {
            if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
                requesterId = txtRequesterId.getValue().toString();
                if ((populateRequesterTextComponents(requesterId))) {

                    enableComponents();
                } else {
                    showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtRequesterId.getValue().toString());
                    requesterId = null;
                    disableComponenets();
                }
            } else {
                requesterId = null;
                showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
            }
        }
        return null;
    }

    public void updateList(ValueChangeEvent vce) {
    }

    public void radioGroupApplierType_processValueChange(ValueChangeEvent vce) {
        requesterType = vce.getNewValue().toString();
        if (vce.getNewValue().toString().equals(IMMEDIATEBOSS)) {
            btnSearchRequester.setRendered(false);
            txtRequesterId.setDisabled(true);
            txtRequesterFullName.setDisabled(false);
            populateRequesterTextComponents(loggedInEmployeeId);
            btnSearchRequester.setDisabled(false);
            txtEmployeeFullName.setDisabled(false);
            btnSaveOrEditOrUpdate.setDisabled(false);
        } else if (vce.getNewValue().toString().equals(ANOTHEREMPLOYEE)) {
            requesterId = null;
            clearRequesterTextComponents();
            txtRequesterId.setDisabled(false);
            btnSearchRequester.setRendered(true);
            btnSearchRequester.setDisabled(false);
            txtRequesterFullName.setDisabled(false);
            txtEmployeeFullName.setDisabled(false);
            btnSaveOrEditOrUpdate.setDisabled(false);
        } else {
            //}else if(vce.getNewValue().toString().equals(NOTEMPLOYEE)) {
            btnSearchRequester.setDisabled(true);
            txtRequesterFullName.setDisabled(true);
            txtEmployeeFullName.setDisabled(true);
            txtRequesterId.setDisabled(true);
            btnSaveOrEditOrUpdate.setDisabled(true);
        }
    }

    public boolean isEntryValidForSearchTerminator() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtEmployeeId.getValue());
        if (!required) {
            ((UIInput) txtEmployeeId).setValid(false);
            error(txtEmployeeId, errorMessage);
            results = false;
        }
        return results;
    }

    public boolean checkEmployeeStatus() {
        //ArrayList<HashMap> educationPrePaidCheck = new ArrayList<HashMap>();
        String empInfoHashMap = terminationRequestManager.getEmployeeStatus(terminator);
        if (empInfoHashMap != null) {
            if ((empInfoHashMap.equalsIgnoreCase("09")) || (empInfoHashMap.equalsIgnoreCase("05")) || (empInfoHashMap.equalsIgnoreCase("03"))) {
                showSuccessOrFailureMessage(false, "CAN NOT REQUEST TERMINATION!!BECAUSE YOUR REQUEST IS ALREADY APPROVED");
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public String btnSearchOffender1_action() {
        //return null means stay on the same page
        if (isEntryValidForSearchTerminator()) {
            if (txtEmployeeId.getValue() != null && !txtEmployeeId.getValue().toString().equals("")) {
                terminator = txtEmployeeId.getValue().toString();
                if (!checkEmployeeStatus()) {
                    if ((populateEmployeeTextComponents(terminator))) {

                        enableComponents();
                    } else {
                        showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtEmployeeId.getValue().toString());
                        terminator = null;
                        disableComponenets();
                    }
                } else {
                    terminator = null;
                    showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
                }
            }
        }
        return null;
    }

    public String txtEmployeeFullName_action() {
        //return null means stay on the same page

        clearTerminatorTextComponents();
        terminator = ApplicationBean1.getSelectedEmployeeId();
        if (!checkEmployeeStatus()) {
            populateEmployeeTextComponents(terminator);
        }
        return null;
    }

    public String button1_action() {
        //return null means stay on the same page
        validateAndInitializeTerminationAttributes();
        return null;
    }

    public void selectPending_validate(FacesContext context, UIComponent component, Object value) {
    }
//     int age;
//    String date;
//    String  calculatedDate;
//     private boolean populateRequesterDtaeofBirth() {
//         age = 55;
//      //  date = txtTerminationDate.getValue().toString();
//     //   age = Integer.valueOf(txtAge.getValue().toString());
//     //   calculatedDate = GregorianCalendarManipulation.subtractGregorianYearandAge(age, date);
//        return true;
//    }


    public void drlTerminationType_processValueChange(ValueChangeEvent vce) {
       


        if(vce.getNewValue().toString().equals("1")) {

            populateAllBirtDate(terminatornBirthDate);
           
          if( populateAllBirtDate(terminatornBirthDate)<65)
          {
           showSuccessOrFailureMessage(false, " REQUESTED EMPLOYEE AGE IS LESS THAN 65 YOU CAN'T REQUEST BY THIS TYPE");

          } else{


       
        if ((vce.getNewValue().toString().equals("4")) || (vce.getNewValue().toString().equals("5")) || (vce.getNewValue().toString().equals("1")) || (vce.getNewValue().toString().equals("7"))) {
              penalityPay = 0;
            btnCalculatePenality.setDisabled(true);
            txtPenality.setValue(penalityPay);
        } else {
            btnCalculatePenality.setDisabled(false);
            txtPenality.setValue(null);
        }
    }
        }
    }


    public String btnCalculatePenality_action() {
        //return null means stay on the same page
        validateAndInitializeTerminationAttributes();
        return null;
    }

    public void chksuccesisor_processValueChange(ValueChangeEvent vce) {
//        if (chksuccesisor.isSelected()) {
//            btnCalculatePenality.setDisabled(true);
//            penalityPay = 0;
//            txtPenality.setValue(penalityPay);
//            hasSuccesioser = "Yes";
//        } else {
//            btnCalculatePenality.setDisabled(false);
//            hasSuccesioser = "No";
//        }
    }
    //</editor-fold>
///////////////////////////////////////
}

