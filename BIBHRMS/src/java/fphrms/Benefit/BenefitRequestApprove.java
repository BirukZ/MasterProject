/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Benefit;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.component.tree.TreeNode;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import control.LookUpManger;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
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
import javax.swing.tree.DefaultTreeModel;
import manager.MilkBenefit.EmployeeRegistrationManager.EmployeeMilkModel;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.HRValidation;
import manager.benefitManager.BenefitREquestApproveManager;
import manager.benefitManager.BenefitRequestManager;
import manager.leaveManager.LeaveControl;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version BenefitRequestPage.java
 * @version Created on Mar 2, 2011, 2:47:55 PM
 * @author user
 */
public class BenefitRequestApprove extends AbstractPageBean {

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

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

   

    public EmployeeMilkModel getEmployeeMilkModel() {
        return employeeMilkModel;
    }

    public void setEmployeeMilkModel(EmployeeMilkModel employeeMilkModel) {
        this.employeeMilkModel = employeeMilkModel;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
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

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public LeaveControl getLeaveControl() {
        return leaveControl;
    }

    public void setLeaveControl(LeaveControl leaveControl) {
        this.leaveControl = leaveControl;
    }

    public String getMilkAvailablity() {
        return milkAvailablity;
    }

    public void setMilkAvailablity(String milkAvailablity) {
        this.milkAvailablity = milkAvailablity;
    }

    public String getNumOfDate() {
        return numOfDate;
    }

    public void setNumOfDate(String numOfDate) {
        this.numOfDate = numOfDate;
    }

    public int getRegistredID() {
        return registredID;
    }

    public void setRegistredID(int registredID) {
        this.registredID = registredID;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }
    private HtmlInputText txtPenality = new HtmlInputText();

    public HtmlInputText gettxtPenality() {
        return txtPenality;
    }

    public void settxtPenality(HtmlInputText hit) {
        this.txtPenality = hit;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
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
    private HtmlInputText txtendDate = new HtmlInputText();

    public HtmlInputText getTxtendDate() {
        return txtendDate;
    }

    public void setTxtendDate(HtmlInputText hit) {
        this.txtendDate = hit;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists = hsol;
    }
    private HtmlInputText txtDepartment = new HtmlInputText();

    public HtmlInputText getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(HtmlInputText hit) {
        this.txtDepartment = hit;
    }
    private Tree tree = new Tree();

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree t) {
        this.tree = t;
    }
    private TreeNode treeNode2 = new TreeNode();

    public TreeNode getTreeNode2() {
        return treeNode2;
    }

    public void setTreeNode2(TreeNode tn) {
        this.treeNode2 = tn;
    }
    private HtmlPanelGroup panelGroup1 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroup1() {
        return panelGroup1;
    }

    public void setPanelGroup1(HtmlPanelGroup hpg) {
        this.panelGroup1 = hpg;
    }
    private HtmlGraphicImage graphicImage2 = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImage2() {
        return graphicImage2;
    }

    public void setGraphicImage2(HtmlGraphicImage hgi) {
        this.graphicImage2 = hgi;
    }
    private HtmlPanelGroup panelGroup2 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroup2() {
        return panelGroup2;
    }

    public void setPanelGroup2(HtmlPanelGroup hpg) {
        this.panelGroup2 = hpg;
    }
    private HtmlCommandLink cmdLnkTree = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkTree() {
        return cmdLnkTree;
    }

    public void setCmdLnkTree(HtmlCommandLink hcl) {
        this.cmdLnkTree = hcl;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

   

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStratDate() {
        return stratDate;
    }

    public void setStratDate(String stratDate) {
        this.stratDate = stratDate;
    }

    public float getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(float totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    public SimpleDateFormat getYearMonthFormat() {
        return yearMonthFormat;
    }

    public void setYearMonthFormat(SimpleDateFormat yearMonthFormat) {
        this.yearMonthFormat = yearMonthFormat;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlInputText txtDeciderPosition = new HtmlInputText();

    public HtmlInputText getTxtDeciderPosition() {
        return txtDeciderPosition;
    }

    public void setTxtDeciderPosition(HtmlInputText hit) {
        this.txtDeciderPosition = hit;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public BenefitRequestApprove() {
    }
    BenefitRequestManager beniftRequestManager = new BenefitRequestManager();
    BenefitREquestApproveManager subsidyIndividualApproveManager = new BenefitREquestApproveManager();
    EmployeeMilkModel employeeMilkModel = new EmployeeMilkModel();
    ArrayList<EmployeeMilkModel> employeeList = new ArrayList<EmployeeMilkModel>();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    EmployeeManage employeeManager = new EmployeeManage();
    LookUpManger lookupnger = new LookUpManger();
    LeaveControl leaveControl = new LeaveControl();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM").format(dateFormat);
    String newOrEditOrUpdateLabel = "Save";
    String today = dateFormat.format(new Date());
    private int terminationRequestId = -1;//@Column(name = "TERMINATION_REQUEST_ID")
    private String requesterId;
    private int requestID;// @Column(name = "REQUESTER_ID")
    private String requestStatus;// @Column(name = "REQUEST_STATUS")
    private String appliedDate;//@Column(name = "APPLIED_DATE")
    private String description;// @Column(name = "DESCRIPTION")
    private String documentReferenceNumber;//  @Column(name = "IS_DOCUMEENT_ATTACHED")
    private String recordedBy;// @Column(name = "RECORDED_BY")
    private String recorededDateAndTime;// @Column(name = "RECOREDED_DATE_AND_TIME")
    private String Location;
    private String month;
    private String requestType;
    private String numOfDate;
    private int subSidyID;
    private double totalAmount;
    ArrayList<Option> subsidyLocation = beniftRequestManager.getTerminationCatagories();
    ArrayList<SelectItem> pendingRequestLists = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryLists = new ArrayList<SelectItem>();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    String userName;
    Date selectedTerminationDate;
    String loggedInEmployeeId;
    String loggedInDepartmentId;
    double penalityPay;
    String hasSuccesioser;
    private int DEPARRTMENT_ID;
    private String databaseStatus;
    private boolean rendered;
    private String remark;
    private float rate;
    private int attendance;
    private float totalAmounts;
    private String empID;
    private String empName;
    private int registredID;
    private String stratDate;
    private String milkAvailablity;
    private String endDate;
    private int workingDay;
    private String recordTime;
    private int listId;
    SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
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

    private void populateDecisionHistory(int terminationRequestId) {
        decisionsMadeOnRequest = subsidyIndividualApproveManager.getRequestHistory(terminationRequestId);
//        if (decisionsMadeOnRequest.size() > 0) {
//        } else {
//            lnkViewPrevieousDecisions.setRendered(false);
//            makePageReadyForUpdate();
//        }

    }

    private void makePageReadyForSave() {
        newOrEditOrUpdateLabel = "Save";
        enableButtons();
    }

    private void makePageReadyForUpdate() {
        newOrEditOrUpdateLabel = "Update";
        enableButtons();
        enableComponenets();
    }

    private void makePageReadyForView() {
        newOrEditOrUpdateLabel = "Save";
        disableButtons();
        disableComponenets();
    }

    private void disableButtons() {
        btnSave.setDisabled(true);

    }

    private void enableButtons() {
        btnSave.setDisabled(false);

    }

    private void enableComponenets() {
        txtRemark.setDisabled(false);

        drlRequestType.setDisabled(false);
        txtRequesterId.setDisabled(false);

    }

    private void disableComponenets() {
        txtRemark.setDisabled(true);


        drlRequestType.setDisabled(true);
        txtRequesterId.setDisabled(true);

    }

    private boolean populateTerminationRequestComponents(int requestId) {

        employeeMilkModel = beniftRequestManager.getTerminationrequestInformation(requestId);
        if (employeeMilkModel != null) {
            if (employeeMilkModel.getRequestId() == -1) {
                showSuccessOrFailureMessage(false, "NO RECORD  FOUND WITH ID REQUEST ID : ");
                return false;
            } else {
                subSidyID = requestId;
                txtStartDate.setValue(employeeMilkModel.getStartDate());
                txtRemark.setValue(employeeMilkModel.getRemark());
                int catego = Integer.valueOf(employeeMilkModel.getRequestType());
                String cat = String.valueOf(catego);
                drlRequestType.resetValue();
                drlRequestType.setValue(cat);
                txtendDate.setValue(employeeMilkModel.getEndDate());
                txtAppliedDate.setValue(employeeMilkModel.getAppliedDate());

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

    private void clearRequestComponents() {
        drlRequestType.setValue(null);
        txtAppliedDate.setValue(dateFormat.format(new Date()));
        txtStartDate.setValue(null);
        txtRemark.setValue(null);
        getEmployeeList().clear();
        txtPenality.setValue(null);
        txtendDate.setValue(null);
        txtDepartment.setValue(null);
        selectPending.resetValue();
        selectMyHistoryLists.resetValue();

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
        drlDecision.setValue(null);
        txtaDeciderComment.setValue(null);
        makePageReadyForSave();

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
        String monthFormat = new SimpleDateFormat("MMMM").format(calTerminationDate.getValue());
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calTerminationDate.setRendered(false);
    }

    public String btnCalendarTerminationDate_action() {
        calTerminationDate.setRendered(true);
        return null;
    }

    private void intializeRequestAttributes() {
        requesterId = txtRequesterId.getValue().toString();
        requestType = drlRequestType.getValue().toString();
        stratDate = txtStartDate.getValue().toString();
        endDate = txtendDate.getValue().toString();
        description = txtRemark.getValue() == null ? "" : txtRemark.getValue().toString();
        appliedDate = txtAppliedDate.getValue().toString();


    }

    public boolean saveTerminationRequest() {

        if (beniftRequestManager.saveTerminationRequestInformation(empID, empName, rendered, databaseStatus, remark, DEPARRTMENT_ID, attendance, rate, registredID, totalAmounts, stratDate, endDate, appliedDate, milkAvailablity, requestType, requesterId, description)) {

            clearAllComponents();
            showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
//            pendingRequestLists = beniftRequestManager.getPendingTerminationRequests();
//            requestHistoryLists = beniftRequestManager.getHistorryTerminationRequests();
            makePageReadyForSave();

            return true;
        } else {
            showSuccessOrFailureMessage(false, "! EXCEPTION OCCURED \nAND YOUR RECORD IS NOT SAVED,\n PLEASE TRY AGAIN");
        }

        return false;
    }

    public boolean updateTerminationRequest() {
        if (subSidyID == -1) {
            return false;//can not occur unless some unexpected event occurs
        } else {

//            if (beniftRequestManager.updateTerminationRequestInformation(subSidyID, requesterId, Location, month, description, documentReferenceNumber, totalAmount, appliedDate)) {
//                showSuccessOrFailureMessage(true, "UPDATIND SUCCESSFULL");
//                clearRequesterTextComponents();
//
//                makePageReadyForSave();
//                pendingRequestLists = beniftRequestManager.getPendingTerminationRequests();
//                requestHistoryLists = beniftRequestManager.getHistorryTerminationRequests();
//                return true;
//            } else {
//                showSuccessOrFailureMessage(false, "! EXCEPTION OCCURED \nAND YOUR RECORD IS NOT UPDATED,\n PLEASE TRY AGAIN");
//                return false;
//            }
            return false;
        }
    }

    public void enableComponents() {
        //txtAppliedDate.setDisabled(false);

        txtRequesterDepartment.setDisabled(false);
        txtRequesterFullName.setDisabled(false);

        txtRemark.setDisabled(false);
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
        required = HRValidation.validateRequired(this.drlRequestType.getValue());
        if (!required) {
            ((UIInput) drlRequestType).setValid(false);
            error(drlRequestType, errorMessage);
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


        required = HRValidation.validateRequired(this.txtStartDate.getValue());
        if (!required) {
            ((UIInput) txtStartDate).setValid(false);
            error(txtStartDate, errorMessage);
            results = false;
        }

        return results;
    }

    public String btnSaveOrEditOrUpdate_action() {
        //first check validity of values
        if (isEntryValidForTermination()) {
            intializeRequestAttributes();
            if (newOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
                btnSave.setDisabled(false);//if ready to save

                saveTerminationRequest();
                clearAllComponents();

            } else { //if (newOrEditOrUpdateLabel.equalsIgnoreCase("Upadte"))
                //if ready to update

                updateTerminationRequest();
                clearAllComponents();

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
        if (subSidyID != -1) {
            return beniftRequestManager.deletePowerDeligationRequest(subSidyID);
        } else {
            return false;
        }

    }

    public String btnPopupOkDelete_action() {
        if (deleteTerminationRequest()) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFUL");
            clearAllComponents();
//            pendingRequestLists = beniftRequestManager.getPendingTerminationRequests();
//            requestHistoryLists = beniftRequestManager.getHistorryTerminationRequests();

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
                terminationRequestId = beniftRequestManager.getEmplyeeLatestTerminationRequestId(requesterId);
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

    public int getTerminationRequestId() {
        return terminationRequestId;
    }

    public void setTerminationRequestId(int terminationRequestId) {
        this.terminationRequestId = terminationRequestId;
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

    public ArrayList<SelectItem> getPendingRequestLists() {
        return pendingRequestLists;
    }

    public void setPendingRequestLists(ArrayList<SelectItem> pendingRequestLists) {
        this.pendingRequestLists = pendingRequestLists;
    }

    public ArrayList<SelectItem> getRequestHistoryLists() {
        return requestHistoryLists;
    }

    public void setRequestHistoryLists(ArrayList<SelectItem> requestHistoryLists) {
        this.requestHistoryLists = requestHistoryLists;
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
            clearAllComponents();
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            requestID = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            appliedDate = requestAttributes[2];
            requestStatus = requestAttributes[3];
            recordTime = requestAttributes[4];
            DEPARRTMENT_ID = Integer.parseInt(requestAttributes[5]);
            populateTerminationRequestComponents(requestID);
            populateRequesterTextComponents(requesterId);
            populateRequesteTableComponents(DEPARRTMENT_ID, recordTime);
            populateDepartementName(DEPARRTMENT_ID);
            availableDecisionsToMakeList = subsidyIndividualApproveManager.getAvailableDecisionsToMake(requestStatus);
            decisionsMadeOnRequest = subsidyIndividualApproveManager.getRequestHistory(terminationRequestId);
            //makePageReadyForUpdate();
        }
    }

    private boolean populateRequesterName(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);

        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                empName = empInfoHashMap.get("employeeFullName").toString();



                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private String populateDepartementName(int deptId) {

        String deptName = beniftRequestManager.getselectDeptName(deptId);

        if (deptName != null) {
            if (deptName.toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO Departemnt FOUND WITH ID : " + deptId);
                return null;
            } else {
                txtDepartment.setValue(deptName);
                return null;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return null;
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
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        beniftRequestManager.setUserName(userName);
        subsidyIndividualApproveManager.setUserName(userName);
        subsidyIndividualApproveManager.setLoggedInEmployeeId(loggedInEmployeeId);
        populateApproverTextComponents(loggedInEmployeeId);
        loggedInDepartmentId = getSessionBean1().getEmpDeptId();
        beniftRequestManager.setDepartment(loggedInDepartmentId);
        // txtAppliedDate.setValue(dateFormat.format(new Date()));
        pendingRequestLists = subsidyIndividualApproveManager.getRequestsToBeProcessed();
        requestHistoryLists = subsidyIndividualApproveManager.getMyTerminationDecisionHistory();
       // availableDecisionsToMakeList = subsidyIndividualApproveManager.getAvailableDecisionsToMake(requestStatus);
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
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate sid) {
        this.calAppliedDate = sid;
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
//        if (subsidyLocation.isEmpty() || (lookupnger.getEmpitiedTableList() != null && lookupnger.getEmpitiedTableList().contains("HR_LU_SUBSIDY_LOCATION"))) {
//            subsidyLocation = beniftRequestManager.getTerminationCatagories();
//
//            lookupnger.getEmpitiedTableList().remove("HR_LU_SUBSIDY_LOCATION");
//        }
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
    private DefaultTree treeModel = new DefaultTree();
    private DefaultTree defaultTreeModel = new DefaultTree();
    private Tree treeOrgStructure = new Tree();
    private PanelLayout pnlLayoutTree = new PanelLayout();

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
    private HtmlSelectOneMenu drlRequestType = new HtmlSelectOneMenu();

    public DefaultTree getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public void setDefaultTreeModel(DefaultTree defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

    public PanelLayout getPnlLayoutTree() {
        return pnlLayoutTree;
    }

    public void setPnlLayoutTree(PanelLayout pnlLayoutTree) {
        this.pnlLayoutTree = pnlLayoutTree;
    }

    public DefaultTree getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTree treeModel) {
        this.treeModel = treeModel;
    }

    public Tree getTreeOrgStructure() {
        return treeOrgStructure;
    }

    public void setTreeOrgStructure(Tree treeOrgStructure) {
        this.treeOrgStructure = treeOrgStructure;
    }

    public HtmlSelectOneMenu getDrlRequestType() {
        return drlRequestType;
    }

    public void setDrlRequestType(HtmlSelectOneMenu hsom) {
        this.drlRequestType = hsom;
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getHasSuccesioser() {
        return hasSuccesioser;
    }

    public void setHasSuccesioser(String hasSuccesioser) {
        this.hasSuccesioser = hasSuccesioser;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getSelectedTerminationDate() {
        return selectedTerminationDate;
    }

    public void setSelectedTerminationDate(Date selectedTerminationDate) {
        this.selectedTerminationDate = selectedTerminationDate;
    }

    public int getSubSidyID() {
        return subSidyID;
    }

    public void setSubSidyID(int subSidyID) {
        this.subSidyID = subSidyID;
    }

    public ArrayList<Option> getSubsidyLocation() {
        return subsidyLocation;
    }

    public void setSubsidyLocation(ArrayList<Option> subsidyLocation) {
        this.subsidyLocation = subsidyLocation;
    }

    public int getDEPARRTMENT_ID() {
        return DEPARRTMENT_ID;
    }

    public void setDEPARRTMENT_ID(int DEPARRTMENT_ID) {
        this.DEPARRTMENT_ID = DEPARRTMENT_ID;
    }

    public BenefitRequestManager getBeniftRequestManager() {
        return beniftRequestManager;
    }

    public void setBeniftRequestManager(BenefitRequestManager beniftRequestManager) {
        this.beniftRequestManager = beniftRequestManager;
    }

    public BenefitREquestApproveManager getSubsidyIndividualApproveManager() {
        return subsidyIndividualApproveManager;
    }

    public void setSubsidyIndividualApproveManager(BenefitREquestApproveManager subsidyIndividualApproveManager) {
        this.subsidyIndividualApproveManager = subsidyIndividualApproveManager;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public HtmlInputText getTxtPenality() {
        return txtPenality;
    }

    public void setTxtPenality(HtmlInputText txtPenality) {
        this.txtPenality = txtPenality;
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
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }

    public ArrayList<EmployeeMilkModel> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<EmployeeMilkModel> employeeList) {
        this.employeeList = employeeList;
    }

    public void selectMyRequests_processValueChange(ValueChangeEvent vce) {
    }

    private boolean populateApproverTextComponents(String approverId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
                txtDeciderId.setDisabled(false);
                return false;
            } else {
                approverId = empInfoHashMap.get("employeeId").toString();
                txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtDeciderFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                txtDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    public String lnkViewPrevieousDecisions_action() {

        populateDecisionHistory(subSidyID);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }
    int tableSize;

    private boolean populateRequesteTableComponents(int departmentID, String date) {
        ArrayList<HashMap> empInfoHashMap = beniftRequestManager.getTableInfo(departmentID, date);

        if (empInfoHashMap != null) {
            tableSize = 0;
            getEmployeeList().clear();
            for (HashMap hmTc : empInfoHashMap) {
                databaseStatus = "Old";
                rendered = false;
                DEPARRTMENT_ID = departmentID;
                empID = hmTc.get("EMP_ID").toString();
                populateRequesterName(empID);
                attendance = Integer.valueOf(hmTc.get("ATTENDANCE").toString());
                rate = Float.valueOf(hmTc.get("RATE").toString());
                totalAmounts = Float.valueOf(hmTc.get("TOTAL_AMOUNT").toString());
                listId = Integer.valueOf(hmTc.get("LIST_ID").toString());
                employeeList.add(new EmployeeMilkModel(empID, empName, attendance, rate, totalAmounts, DEPARRTMENT_ID, rendered, databaseStatus, listId));
                tableSize++;

            }
            return true;
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {

        if (vce != null) {
            clearAllComponents();
            String requestAttributes[] = vce.getNewValue().toString().split("--");
            requestID = Integer.parseInt(requestAttributes[0]);
            requesterId = requestAttributes[1];
            appliedDate = requestAttributes[2];
            requestStatus = requestAttributes[3];
            recordTime = requestAttributes[4];
            DEPARRTMENT_ID = Integer.parseInt(requestAttributes[5]);
            populateTerminationRequestComponents(requestID);
            populateRequesterTextComponents(requesterId);
            populateRequesteTableComponents(DEPARRTMENT_ID, recordTime);
            populateDepartementName(DEPARRTMENT_ID);
            decisionsMadeOnRequest = subsidyIndividualApproveManager.getRequestHistory(terminationRequestId);
            makePageReadyForView();
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

    public void selectPending_validate(FacesContext context, UIComponent component, Object value) {
    }

    public void drlTerminationType_processValueChange(ValueChangeEvent vce) {
        if ((vce.getNewValue().toString().equals("4")) || (vce.getNewValue().toString().equals("5")) || (vce.getNewValue().toString().equals("1")) || (vce.getNewValue().toString().equals("7"))) {
            penalityPay = 0;
            btnCalculatePenality.setDisabled(true);

            txtPenality.setValue(penalityPay);
        } else {
            btnCalculatePenality.setDisabled(false);
            txtPenality.setValue(null);
        }
    }

    public String btnCalendarAppliedDate_action() {
        //return null means stay on the same page
        calAppliedDate.setRendered(true);
        return null;
    }

    public void btnCalendarTerminationDate_processAction(ActionEvent ae) {
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtendDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    public String btnNew_action() {
        //return null means stay on the same page
        enableComponenets();
        enableButtons();
        return null;
    }

    public void rowSelector1_processAction(RowSelectorEvent rse) {
    }

    public String cmdLnkEdit1_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdLnkRemove1_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtDepartment_action() {
        //return null means stay on the same page
        return null;
    }

    public void cmdLnkTree_processAction(ActionEvent ae) {
        try {
            String departmentName;
            String department = tree.getCurrentNode().toString();
            String _department[] = department.split("#");
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID = Integer.parseInt(_department[1].trim());
                txtDepartment.setValue(departmentName);
                pnlLayoutTree.setRendered(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drlRequestType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().equals("1")) {
        } else if (vce.getNewValue().equals("2")) {
        } else {
        }
    }

    private void createObject() {
        if (beniftRequestManager == null) {
            beniftRequestManager = new BenefitRequestManager();
        }
    }

    public String btnDepartmentTree_action() {
        //return null means stay on the same page
        LoadTree loadTree = new LoadTree();
        this.treeModel.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        pnlLayoutTree.setRendered(true);
        return null;
    }

    public String btnCalendarEndDate_action() {
        //return null means stay on the same page
        calAppliedDate.setRendered(true);
        return null;
    }

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(BenefitREquestApproveManager.MILK_SUBSIDY_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(BenefitREquestApproveManager.MILK_SUBSIDY_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (requestID == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE REQUEST TO DECIDE");
            return false;
        }
        return true;
    }

    public boolean saveTerminationDecision() {
        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();

        return subsidyIndividualApproveManager.saveTerminationDecisionint(requestID, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);
    }

    public String btnSave_action() {
        if (validateDecision()) {
            if (saveTerminationDecision()) {
                clearAllComponents();
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                pendingRequestLists = subsidyIndividualApproveManager.getRequestsToBeProcessed();
                requestHistoryLists = subsidyIndividualApproveManager.getMyTerminationDecisionHistory();
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        return null;
    }
}

