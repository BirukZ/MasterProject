/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.JodanTimeCalender;
import manager.leaveManager.ReserveLeaveManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ReserveLeaveApprovePage extends AbstractPageBean {

    private ArrayList<AvilebelLeave> avilebelLeaveList = new ArrayList<AvilebelLeave>();
    private ArrayList<SelectItem> recommendedYear = new ArrayList<SelectItem>();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private EmployeeManage employeeManager = new EmployeeManage();
    private ReserveLeaveManager reserveLeaveManager = new ReserveLeaveManager();
    ArrayList<SelectItem> requestListsToBeApproved = new ArrayList<SelectItem>();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    private ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    private byte[] employeePicture;
    private int reserveLeaveTableSize = 0;
    private int countReserveLeave = 0;
    private String leaveId = null;
    private String loggedInUserId = null;
    String userName = null;
    int leaveReserveId;
    String requesterId;
    String requestStatus;
    String requestedDate;
    private String reserveLeaveId;
    DepartmentManage departmentManage = new DepartmentManage();
    private boolean fistTime = true;

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public ArrayList<SelectItem> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<SelectItem> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
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
        if (fistTime) {
            fistTime = false;
            setRecommendedYear(reserveLeaveManager.recommendedYear());
            clearComponents();
            loggedInUserId = getSessionBean1().getEmployeeId();
//        lblCurrentOwnerGroup.setValue(getSessionBean1().getEmployeeName());
            userName = getSessionBean1().getUserName();
            reserveLeaveManager.setUserName(userName);
            // leaveRequestManager.setUserName(userName);
           // requestListsToBeApproved.clear();
           // requestListsToBeApproved = reserveLeaveManager.getRequestsToBeProcessed();
            loggedInUserId = getSessionBean1().getEmployeeId();

            userName = getSessionBean1().getUserName();

            reserveLeaveManager.setUserName(userName);
            reserveLeaveManager.setLoggedInEmployeeId(loggedInUserId);
            setRequestListsToBeApproved(reserveLeaveManager.getRequestsToBeProcessed());
        }
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
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlOutputText lblDecider_Department = new HtmlOutputText();

    public HtmlOutputText getLblDecider_Department() {
        return lblDecider_Department;
    }

    public void setLblDecider_Department(HtmlOutputText hot) {
        this.lblDecider_Department = hot;
    }
    private HtmlOutputText lblEmployeeFullName = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeFullName() {
        return lblEmployeeFullName;
    }

    public void setLblEmployeeFullName(HtmlOutputText hot) {
        this.lblEmployeeFullName = hot;
    }
    private HtmlOutputText txtDeciderId = new HtmlOutputText();

    public HtmlOutputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlOutputText hot) {
        this.txtDeciderId = hot;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlOutputText lblEmployeeId = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeId() {
        return lblEmployeeId;
    }

    public void setLblEmployeeId(HtmlOutputText hot) {
        this.lblEmployeeId = hot;
    }
    private HtmlOutputText lblDeciderPosition = new HtmlOutputText();

    public HtmlOutputText getLblDeciderPosition() {
        return lblDeciderPosition;
    }

    public void setLblDeciderPosition(HtmlOutputText hot) {
        this.lblDeciderPosition = hot;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
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
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private HtmlOutputText lblDesstionStatus = new HtmlOutputText();

    public HtmlOutputText getLblDesstionStatus() {
        return lblDesstionStatus;
    }

    public void setLblDesstionStatus(HtmlOutputText hot) {
        this.lblDesstionStatus = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ReserveLeaveApprovePage() {
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
        private String startDate;
        private String endDate;
        private String remark;
        private boolean approveLeaveTransfer;

        public boolean isApproveLeaveTransfer() {
            return approveLeaveTransfer;
        }

        public void setApproveLeaveTransfer(boolean approveLeaveTransfer) {
            this.approveLeaveTransfer = approveLeaveTransfer;
        }

        public String getAvilbelLeveDay() {
            return avilbelLeveDay;
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

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public AvilebelLeave(String avilbelLeveDay,
                String employeeId,
                String leaveYear,
                String leaveId, String startDate,
                String endDate,
                String remark) {
            this.avilbelLeveDay = avilbelLeveDay;
            this.employeeId = employeeId;
            this.leaveYear = leaveYear;
            this.leaveId = leaveId;
            this.startDate = startDate;
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

    private void clearComponents() {
        lblFull_Name.setValue("");
        lblDepartment.setValue("");
        lblPosition.setValue("");
        lblServiceYear.setValue("");
        imgEmployeePicture.setValue("");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    /**
     * The method use employeeid and display employee unusedLeave in the table

     */
    private void fillTableData() {
        try {
            ArrayList<HashMap> listOfEmployeeUnusedLeave = null;
            //reserveLeaveManager.readReserveLeave(txtEmployeeID.getValue().toString());

            if (listOfEmployeeUnusedLeave.size() > 0) {
                countReserveLeave = 0;
                getAvilebelLeaveList().clear();
                for (HashMap hm : listOfEmployeeUnusedLeave) {
                    getAvilebelLeaveList().add(new AvilebelLeave(
                            hm.get("AVAILABLELEAVENUMBER").toString(),
                            hm.get("EMP_ID").toString(),
                            hm.get("LEAVEYEAR").toString(),
                            hm.get("ID").toString(),
                            hm.get("ID").toString(),
                            hm.get("ID").toString(),
                            hm.get("ID").toString()));
                    reserveLeaveTableSize++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String btnUpdate_action() {

        //return null means stay on the same page
        return null;
    }

    public String button1_action() {

        return null;
    }

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                clearRequestComponents();
                clearComponts();
                String[] requestInfos = vce.getNewValue().toString().split("--");
                //  leaveReserveId = Integer.parseInt(requestInfos[0]);
                requesterId = requestInfos[0];
                requestStatus = requestInfos[1];
                requestedDate = requestInfos[2];
                reserveLeaveId = requestInfos[3];
                populateRequesterTextComponents(requesterId);
                populateApproverTextComponents(loggedInUserId);

                //   populateOverTimeRequestTextComponents(overTimeRequestId);
                //    populateEmployeesListToTable(overTimeRequestId);
                drlDecision.resetValue();
                availableDecisionsToMakeList = reserveLeaveManager.getAvailableDecisionsToMake(requestStatus);
                loadEmployeeRequestData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    //  makePageReadyForSave();
    }

    private boolean populateRequesterTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInformation(employeeId);
        if (empInfoHashMap != null) {
//            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
//                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
//
//                requesterId = null;
//                return false;
//            } else {
                requesterId = employeeId;
                lblEmployeeId.setValue(empInfoHashMap.get("employeeId").toString());
                lblFull_Name.setValue(empInfoHashMap.get("employeeTitledFullName").toString());
                lblDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath").toString());
                lblPosition.setValue(empInfoHashMap.get("employeePosition").toString());
                if (empInfoHashMap.get("employeeGender").toString().equals("Male")) {
                    choFemale.setSelected(false);
                    choMale.setSelected(true);
                } else {
                    choFemale.setSelected(true);
                    choMale.setSelected(false);
                }
                int expYear = employeeManager.calculateEmployeeServiceYear(employeeId);
                lblServiceYear.setValue(String.valueOf(expYear));
                lblServiceYear.setValue(expYear);
                try {
                    OracleSerialBlob blo = (OracleSerialBlob) employeeManager.readEmployeePhoto(empInfoHashMap.get("employeeId").toString());
                    setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                    imgEmployeePicture.setValue(getEmployeePicture());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                //  lblPosition.setValue(empInfoHashMap.get("employeePosition").toString());
                //  txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                //  txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                //  txtRequesterId.setValue(requesterId);
                //    txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateApproverTextComponents(String approverId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
//            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
//                approverId = null;
//                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
//                //txtDeciderId.setDisabled(false);
//                return false;
//            } else {
                approverId = empInfoHashMap.get("employeeId").toString();
                lblDecider_Department.setValue(empInfoHashMap.get("employeeDepartmentName"));
                lblEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                lblDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
//            }

        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }
//    public boolean saveOverTimeDecision() {
//        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
//        return overTimeApproveManager.saveOverTimeDecision(overTimeRequestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment, requestModelList);
//
//    }
//
//    private boolean validateDecision() {
//        if (drlDecision.getValue().toString().equals(OverTimeApproveManager.OVERTIME_DECISION_NONE)) {
//            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
//            return false;
//        } else if (drlDecision.getValue().toString().equals(OverTimeApproveManager.OVERTIME_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
//            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
//            return false;
//        } else if (1 == -1) {
//            showSuccessOrFailureMessage(false, "FIRST SELECT THE TERMINATION TO DECIDE");
//            return false;
//        }
//        return true;
//    }
//
//    public String btnSaveDecision_action() {
//        if (validateDecision()) {
//            if (saveOverTimeDecision()) {
//                clearAllComponents();
//                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
//                requestListsToBeApproved = overTimeApproveManager.getRequestsToBeProcessed();
//            } else {
//                showSuccessOrFailureMessage(false, "SAVING FAILED");
//            }
//        }
//        return null;
//    }

    void loadEmployeeRequestData() {
        try {
            getAvilebelLeaveList().clear();
            ArrayList<HashMap> listOfRequest = reserveLeaveManager.getEmployeeLeaveTransferRequest(
                    requesterId,
                    requestStatus,
                    requestedDate);
            for (HashMap hm : listOfRequest) {
                getAvilebelLeaveList().add(new AvilebelLeave(
                        hm.get("AVAILABLEAVEDAYS").toString(),
                        hm.get("EMP_ID").toString(),
                        hm.get("LEAVEYEAR").toString(),
                        hm.get("RESERVELAVEID").toString(),
                        hm.get("startDate").toString(),
                        hm.get("ednDate").toString(),
                        hm.get("remark").toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public String btnSaveDecision_action() {
        ArrayList<HashMap> listOfDestionMaked = new ArrayList<HashMap>();
        if (validateDecision()) {
            String comment = txtaDeciderComment.getValue() == null ? " " : txtaDeciderComment.getValue().toString();
            for (AvilebelLeave avilebelLeaveTransferRequest : getAvilebelLeaveList()) {
                if (avilebelLeaveTransferRequest.isApproveLeaveTransfer()) {
                    HashMap hm = new HashMap();
                    hm.put("leaveTransferId", avilebelLeaveTransferRequest.getLeaveId());
                    hm.put("deciderId", txtDeciderId.getValue().toString());
                    hm.put("commentGiven", comment);
                    listOfDestionMaked.add(hm);
                }
            }
            if (reserveLeaveManager.saveleaveLeaveTransferDecision(listOfDestionMaked,
                    drlDecision.getValue().toString(),
                    requestStatus)) {
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                requestListsToBeApproved.clear();
                getAvilebelLeaveList().clear();
                clearComponts();
                requestListsToBeApproved = reserveLeaveManager.getRequestsToBeProcessed();
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }


        }




        //return null means stay on the same page
        return null;
    }

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(ReserveLeaveManager.LEAVE_TRANSFER_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(ReserveLeaveManager.LEAVE_TRANSFER_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        }
        return true;
    }

    void clearRequestComponents() {
        lblEmployeeId.setValue("");
        lblFull_Name.setValue("");
        lblDepartment.setValue("");
        lblPosition.setValue("");
        choFemale.setSelected(false);
        choMale.setSelected(false);
        lblServiceYear.setValue("");
        imgEmployeePicture.setValue("");
        getAvilebelLeaveList().clear();
    }

    public String lnkViewPrevieousDecisions_action() {
        lblDesstionStatus.setRendered(false);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        int leave_request = Integer.parseInt(reserveLeaveId);
        ArrayList<HashMap> leaveRequestHistory =
                reserveLeaveManager.getLeaveRequestHistory(leave_request);
        int counter = 0;
        decisionsMadeOnRequest.clear();
        for (HashMap hm : leaveRequestHistory) {
            counter++;
            decisionsMadeOnRequest.add(new RequestHistoryModel(
                    counter,
                    hm.get("deciderEmployeeId").toString(),
                    hm.get("deciderFullName").toString(),
                    hm.get("givenDecision").toString(),
                    hm.get("timeStamp").toString(),
                    hm.get("commentGiven").toString()));

        }
        if (counter == 0) {
            lblDesstionStatus.setRendered(true);
        }
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupViewPrevieousDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    private void clearComponts() {
        decisionsMadeOnRequest.clear();
        defaultSelectedData2.setSelectedObject(null);
        lblDecider_Department.setValue("");
        lblEmployeeFullName.setValue("");
        txtDeciderId.setValue("");
        lblDeciderPosition.setValue("");
        txtaDeciderComment.setValue("");
        lblEmployeeId.setValue("");
        lblFull_Name.setValue("");
        lblDepartment.setValue("");
        lblPosition.setValue("");
        lblServiceYear.setValue("");
        imgEmployeePicture.setValue("");
        choMale.setSelected(false);
        choFemale.setSelected(false);

    }

    public String lnkLeaveRequest_action() {
        //return null means stay on the same page
        return "LeaveRequest";
    }

    public String lnkPayrollSetUp_action() {
        //return null means stay on the same page
        return "LeaveApprove";
    }

    public String lnkTransferAnnualLeave_action() {
        //return null means stay on the same page
        return "LeaveTransferRequest";
    }
}
