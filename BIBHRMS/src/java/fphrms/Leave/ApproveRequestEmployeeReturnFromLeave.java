/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright dereje(one)
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.LookUpManager;
import manager.employeeManager.EmployeeManage;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.Report.MainReport;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import com.sun.webui.jsf.model.Option;
import java.util.Set;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.JodanTimeCalender;
import manager.leaveManager.AnnualLeaveManager;
import manager.leaveManager.ApproveReturnFromLeaveManager;
import manager.leaveManager.LeaveRequestManager;
import manager.leaveManager.LeaveSettlementManager;
import manager.leaveManager.RequestFromLeaveManager;
import manager.userManagement.SiteSecurityManager;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ApproveRequestEmployeeReturnFromLeave extends AbstractPageBean {

    private LookUpManager lookUpManager = new LookUpManager();
    private boolean checkLeavePayment = false;
    private ArrayList<SelectItem> employeeOnLeave = new ArrayList<SelectItem>();
    private AnnualLeaveManager annualLeaveManager = new AnnualLeaveManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private LeaveSettlementManager leaveSettlementManager = new LeaveSettlementManager();
    private LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private RequestFromLeaveManager leaveManager = new RequestFromLeaveManager();
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    private ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    private ArrayList<SelectItem> listOfPaymentRequest = new ArrayList<SelectItem>();
    private ApproveReturnFromLeaveManager approveReturnFromLeaveManager = new ApproveReturnFromLeaveManager();
    private EmployeeManage employeeManage = new EmployeeManage();
    private ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    private int commiteeTableSize = 0;
    private int commMemberTableSize = 0;
    private String commiteID = null;
    private int buttonIdentifier = 0;
    private int countCommittee = 0;
    private int countCommitteeMember = 0;
    private byte[] employeePicture;
    private String requestId = null;
    private boolean checkLoad = false;
    private String loggedInUserId = null;
    String userName = null;
    private String requesterId = null;
    private String retuirnRequestId = null;
    private String paymentRequestId = null;
    private String retrunFromLeaveRequestId;
    String requestStatus;
    String requestedDate;
    private boolean callMeOnece = true;

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public ArrayList<SelectItem> getListOfPaymentRequest() {
        return listOfPaymentRequest;
    }

    public void setListOfPaymentRequest(ArrayList<SelectItem> listOfPaymentRequest) {
        this.listOfPaymentRequest = listOfPaymentRequest;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public ArrayList<SelectItem> getEmployeeOnLeave() {
        return employeeOnLeave;
    }

    public void setEmployeeOnLeave(ArrayList<SelectItem> employeeOnLeave) {
        this.employeeOnLeave = employeeOnLeave;
    }
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

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

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems1() {
        return selectOneMenu3DefaultItems1;
    }

    public void setSelectOneMenu3DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems2() {
        return selectOneMenu3DefaultItems2;
    }

    public void setSelectOneMenu3DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems3() {
        return selectOneMenu3DefaultItems3;
    }

    public void setSelectOneMenu3DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems3 = dsia;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems4() {
        return selectOneMenu3DefaultItems4;
    }

    public void setSelectOneMenu3DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems5() {
        return selectOneMenu3DefaultItems5;
    }

    public void setSelectOneMenu3DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems6() {
        return selectOneMenu3DefaultItems6;
    }

    public void setSelectOneMenu3DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems6 = dsia;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectionItems selectOneMenu4DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu4DefaultItems1() {
        return selectOneMenu4DefaultItems1;
    }

    public void setSelectOneMenu4DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu4DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu4DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu4DefaultItems2() {
        return selectOneMenu4DefaultItems2;
    }

    public void setSelectOneMenu4DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu4DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu4DefaultItems3 = new DefaultSelectItemsArray();
    private HtmlSelectOneMenu drlCommitteeType = new HtmlSelectOneMenu();
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    private HtmlCommandButton btnSettleSave = new HtmlCommandButton();
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();
    private HtmlOutputLabel lblFormMessage4 = new HtmlOutputLabel();
    private PanelPopup pnConfirmationForDelete = new PanelPopup();
    private PanelPopup pnConfirmationMessage = new PanelPopup();
    private PanelLayout pnlConfirmationMessageBody = new PanelLayout();
    private HtmlOutputLabel lblFormDeleteMessage = new HtmlOutputLabel();

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public DefaultSelectItemsArray getSelectOneMenu4DefaultItems3() {
        return selectOneMenu4DefaultItems3;
    }

    public void setSelectOneMenu4DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu4DefaultItems3 = dsia;
    }

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }

    public HtmlCommandButton getBtnSettleSave() {
        return btnSettleSave;
    }

    public void setBtnSettleSave(HtmlCommandButton hcb) {
        this.btnSettleSave = hcb;
    }
    private PanelLayout pnMessage = new PanelLayout();

    public PanelLayout getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelLayout pl) {
        this.pnMessage = pl;
    }

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }

    public PanelLayout getPnlConfirmationMessageBody() {
        return pnlConfirmationMessageBody;
    }

    public void setPnlConfirmationMessageBody(PanelLayout pl) {
        this.pnlConfirmationMessageBody = pl;
    }

    public HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }

    public PanelPopup getPnConfirmationForDelete() {
        return pnConfirmationForDelete;
    }

    public void setPnConfirmationForDelete(PanelPopup pp) {
        this.pnConfirmationForDelete = pp;
    }

    public HtmlOutputLabel getLblFormDeleteMessage() {
        return lblFormDeleteMessage;
    }

    public void setLblFormDeleteMessage(HtmlOutputLabel hol) {
        this.lblFormDeleteMessage = hol;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public int getButtonIdentifier() {
        return buttonIdentifier;
    }

    public void setButtonIdentifier(int buttonIdentifier) {
        this.buttonIdentifier = buttonIdentifier;
    }

    public int getCommMemberTableSize() {
        return commMemberTableSize;
    }

    public void setCommMemberTableSize(int commMemberTableSize) {
        this.commMemberTableSize = commMemberTableSize;
    }

    public String getCommiteID() {
        return commiteID;
    }

    public void setCommiteID(String commiteID) {
        this.commiteID = commiteID;
    }

    public int getCommiteeTableSize() {
        return commiteeTableSize;
    }

    public void setCommiteeTableSize(int commiteeTableSize) {
        this.commiteeTableSize = commiteeTableSize;
    }

    public int getCountCommittee() {
        return countCommittee;
    }

    public void setCountCommittee(int countCommittee) {
        this.countCommittee = countCommittee;
    }

    public int getCountCommitteeMember() {
        return countCommitteeMember;
    }

    public void setCountCommitteeMember(int countCommitteeMember) {
        this.countCommitteeMember = countCommitteeMember;
    }

    public LookUpManager getLookUpManager() {
        return lookUpManager;
    }

    public void setLookUpManager(LookUpManager lookUpManager) {
        this.lookUpManager = lookUpManager;
    }

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData selectBooleanCheckbox1Bean) {
        this.selectBooleanCheckbox1Bean = selectBooleanCheckbox1Bean;
    }

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData selectBooleanCheckbox2Bean) {
        this.selectBooleanCheckbox2Bean = selectBooleanCheckbox2Bean;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlOutputText lblEmployeeDepartment = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeDepartment() {
        return lblEmployeeDepartment;
    }

    public void setLblEmployeeDepartment(HtmlOutputText hot) {
        this.lblEmployeeDepartment = hot;
    }
    private HtmlOutputText lblJobPosition = new HtmlOutputText();

    public HtmlOutputText getLblJobPosition() {
        return lblJobPosition;
    }

    public void setLblJobPosition(HtmlOutputText hot) {
        this.lblJobPosition = hot;
    }
    private HtmlSelectBooleanCheckbox choMaleSe = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMaleSe() {
        return choMaleSe;
    }

    public void setChoMaleSe(HtmlSelectBooleanCheckbox hsbc) {
        this.choMaleSe = hsbc;
    }
    private HtmlSelectBooleanCheckbox choFemaleSe = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoFemaleSe() {
        return choFemaleSe;
    }

    public void setChoFemaleSe(HtmlSelectBooleanCheckbox hsbc) {
        this.choFemaleSe = hsbc;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlOutputText lblLeaveType = new HtmlOutputText();

    public HtmlOutputText getLblLeaveType() {
        return lblLeaveType;
    }

    public void setLblLeaveType(HtmlOutputText hot) {
        this.lblLeaveType = hot;
    }
    private HtmlOutputText lblLeaveDays = new HtmlOutputText();

    public HtmlOutputText getLblLeaveDays() {
        return lblLeaveDays;
    }

    public void setLblLeaveDays(HtmlOutputText hot) {
        this.lblLeaveDays = hot;
    }
    private HtmlOutputText lblReason = new HtmlOutputText();

    public HtmlOutputText getLblReason() {
        return lblReason;
    }

    public void setLblReason(HtmlOutputText hot) {
        this.lblReason = hot;
    }
    private HtmlOutputText lblStartDate = new HtmlOutputText();

    public HtmlOutputText getLblStartDate() {
        return lblStartDate;
    }

    public void setLblStartDate(HtmlOutputText hot) {
        this.lblStartDate = hot;
    }
    private HtmlOutputText lblEndDateLevel = new HtmlOutputText();

    public HtmlOutputText getLblEndDateLevel() {
        return lblEndDateLevel;
    }

    public void setLblEndDateLevel(HtmlOutputText hot) {
        this.lblEndDateLevel = hot;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
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
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlOutputText lblDeciderPosition = new HtmlOutputText();

    public HtmlOutputText getLblDeciderPosition() {
        return lblDeciderPosition;
    }

    public void setLblDeciderPosition(HtmlOutputText hot) {
        this.lblDeciderPosition = hot;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private HtmlOutputText lblEmployeeId = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeId() {
        return lblEmployeeId;
    }

    public void setLblEmployeeId(HtmlOutputText hot) {
        this.lblEmployeeId = hot;
    }
    private HtmlOutputText lblRequestedRetrunDate = new HtmlOutputText();

    public HtmlOutputText getLblRequestedRetrunDate() {
        return lblRequestedRetrunDate;
    }

    public void setLblRequestedRetrunDate(HtmlOutputText hot) {
        this.lblRequestedRetrunDate = hot;
    }
    private HtmlOutputText lblReasonReturnFromLeave = new HtmlOutputText();

    public HtmlOutputText getLblReasonReturnFromLeave() {
        return lblReasonReturnFromLeave;
    }

    public void setLblReasonReturnFromLeave(HtmlOutputText hot) {
        this.lblReasonReturnFromLeave = hot;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private HtmlOutputText lblReasonReturnFromLeaveca = new HtmlOutputText();

    public HtmlOutputText getLblReasonReturnFromLeaveca() {
        return lblReasonReturnFromLeaveca;
    }

    public void setLblReasonReturnFromLeaveca(HtmlOutputText hot) {
        this.lblReasonReturnFromLeaveca = hot;
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
    private HtmlOutputText lblPhsicalYear = new HtmlOutputText();

    public HtmlOutputText getLblPhsicalYear() {
        return lblPhsicalYear;
    }

    public void setLblPhsicalYear(HtmlOutputText hot) {
        this.lblPhsicalYear = hot;
    }
    private HtmlOutputText lblRemainingLeaveDays = new HtmlOutputText();

    public HtmlOutputText getLblRemainingLeaveDays() {
        return lblRemainingLeaveDays;
    }

    public void setLblRemainingLeaveDays(HtmlOutputText hot) {
        this.lblRemainingLeaveDays = hot;
    }
    private HtmlSelectOneListbox listLeavePaymetRequest = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListLeavePaymetRequest() {
        return listLeavePaymetRequest;
    }

    public void setListLeavePaymetRequest(HtmlSelectOneListbox hsol) {
        this.listLeavePaymetRequest = hsol;
    }
    private PanelLayout statusContainerPaymentRequest = new PanelLayout();

    public PanelLayout getStatusContainerPaymentRequest() {
        return statusContainerPaymentRequest;
    }

    public void setStatusContainerPaymentRequest(PanelLayout pl) {
        this.statusContainerPaymentRequest = pl;
    }


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ApproveRequestEmployeeReturnFromLeave() {
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
//        if (callMeOnece) {
        userRole();
        callMeOnece = false;
        loggedInUserId = getSessionBean1().getEmployeeId();
//        lblCurrentOwnerGroup.setValue(getSessionBean1().getEmployeeName());
        userName = getSessionBean1().getUserName();
        populateApproverTextComponents(loggedInUserId);
        approveReturnFromLeaveManager.setUserName(userName);
        approveReturnFromLeaveManager.setLoggedInEmployeeId(loggedInUserId);
        leaveRequestManager.setUserName(userName);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        loadRequestList();
        clearComponet();

//        }

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

    private void clearComponet() {
        lblFullName.setValue("");
        lblEmployeeDepartment.setValue("");
        lblJobPosition.setValue("");
        choMaleSe.setValue("");
        choFemaleSe.setValue("");
        lblLeaveType.setValue("");
        lblLeaveDays.setValue("");
        lblStartDate.setValue("");
        lblEndDateLevel.setValue("");
        lblReason.setValue("");
        lblReasonReturnFromLeave.setValue("");
        selectedObjectOneMenuDecisionType.setSelectedObject(null);
        txtaDeciderComment.setValue("");
        lblRequestedRetrunDate.setValue("");
        lblEmployeeId.setValue("");
        imgEmployeePicture.setValue("");
        lblPhsicalYear.setValue("");
        setAvailableDecisionsToMakeList(null);

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

    public String btnCancelCommiteType_action() {
        clearComponet();
        //return null means stay on the same page
        return null;
    }

    public String cmdConfirmationCloseDeleete_action() {
        pnConfirmationForDelete.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {
        pnConfirmationForDelete.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String lnkDisciplineRequest_action() {
        return "LeaveApprove";
    }

    public String lnkCommitteeMembers_action() {
        return "LeaveTransferRequest";
    }

    public String lnkDisciplinePenality_action() {
        return "LeaveBalance";
    }

    public String lnkDisciplineApprove_action() {
        return "LeaveRequest";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected LeaveEmployeeSchedule getHelp$Template() {
        return (LeaveEmployeeSchedule) getBean("Help$Template");
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
    protected EvaluationResultPage getEmployeeHistory$EvaluationResultPage() {
        return (EvaluationResultPage) getBean("EmployeeHistory$EvaluationResultPage");
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
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
    }

    void employeeInformation(String employeeId) {

        HashMap list = leaveManager.readEmployeeLeaveWithProfile(employeeId);
        if (list != null) {


            lblFullName.setValue(list.get("FULLNAME").toString());
            lblJobPosition.setValue(list.get("JOB_DESCRIPTION").toString());
            lblLeaveDays.setValue(list.get("LEAVE_DAYS").toString());
            lblLeaveType.setValue(list.get("DESCRIPTION").toString());
            lblStartDate.setValue(list.get("REQUESTED_FROM_DATE").toString());
            lblEndDateLevel.setValue(list.get("REQUESTED_TO_DATE").toString());
            lblReason.setValue(list.get("REQUESTING_REASON").toString());
            if (list.get("SEX").toString().equals("Female")) {
                choMaleSe.setSelected(false);
                choFemaleSe.setSelected(true);
            } else {
                choMaleSe.setSelected(true);
            }
            btnSettleSave.setDisabled(false);
            checkLoad = true;
        }
    }

    public void slbEmployee_processValueChange(ValueChangeEvent vce) {
        checkLeavePayment = false;
        clearComponet();
        if (HRValidation.validateRequired(vce.getNewValue())) {
            String[] requestInfos = vce.getNewValue().toString().split("--");
            //  leaveReserveId = Integer.parseInt(requestInfos[0]);
            requesterId = requestInfos[0];
            requestStatus = requestInfos[1];
            requestedDate = requestInfos[2];
            retuirnRequestId = requestInfos[3];
            availableDecisionsToMakeList = approveReturnFromLeaveManager.getAvailableDecisionsToMake(requestStatus);
            populateApproverTextComponents(getSessionBean1().getEmployeeId());
            loadEmployeeData();
        }
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<Option> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
    }

    private boolean populateApproverTextComponents(String approverId) {
        HashMap empInfoHashMap = employeeManage.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
                txtDeciderId.setDisabled(false);
                return false;
            } else {
                approverId = empInfoHashMap.get("employeeId").toString();
                lblDecider_Department.setValue(empInfoHashMap.get("employeeDepartmentName"));
                lblEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                lblDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }

        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }

    void loadEmployeeData() {
        boolean firstTimeAccessces = true;
        HashMap hm = approveReturnFromLeaveManager.readEmployeeLeaveRequest(
                requesterId,
                requestStatus,
                requestedDate);
        if (hm != null) {
            if (firstTimeAccessces) {
                lblEmployeeId.setValue(": " + "[ " + hm.get("EMP_ID").toString() + " ]");
                lblFullName.setValue(": " + "[ " + hm.get("FULLNAME") + " ]");
                lblJobPosition.setValue(": " + hm.get("JOB_NAME"));
                lblLeaveType.setValue(": " + hm.get("DESCRIPTION"));
                lblLeaveDays.setValue(": " + hm.get("LEAVE_DAYS"));
                lblStartDate.setValue(": " + hm.get("REQUESTED_FROM_DATE"));
                lblEndDateLevel.setValue(": " + hm.get("REQUESTED_TO_DATE"));
                lblReasonReturnFromLeave.setValue(": " + hm.get("REASONOFRETRUN"));
                lblRequestedRetrunDate.setValue(": " + hm.get("RETURN_DATE"));
                lblEmployeeDepartment.setValue(": " + hm.get("DEP_DESCRIPTION"));
                retrunFromLeaveRequestId = hm.get("REQUEST_ID").toString();
                lblReason.setValue(": " + hm.get("REQUESTING_REASON"));
                lblReasonReturnFromLeaveca.setValue("Reason of Return From Leave");
                lblPhsicalYear.setValue(": " + hm.get("PHYSICALYEAR"));

                if (hm.get("SEX").equals("Male")) {
                    choMaleSe.setSelected(true);
                    choFemaleSe.setSelected(false);
                } else {
                    choMaleSe.setSelected(false);
                    choFemaleSe.setSelected(true);
                }

                try {
                    OracleSerialBlob blo = (OracleSerialBlob) hm.get("PHOTO");
                    setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                    imgEmployeePicture.setValue(getEmployeePicture());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                firstTimeAccessces = false;
            }

            lblRemainingLeaveDays.setValue(": " + leaveRequestManager.readEmployeeAvailableAnualLeave(hm.get("EMP_ID").toString()));


        }
    }

    void loadEmployeePaymentRequestData() {
        boolean firstTimeAccessces = true;
        HashMap hm = approveReturnFromLeaveManager.loadEmployeePaymentRequestData(
                requesterId,
                requestStatus,
                requestedDate);
        if (hm != null) {
            if (firstTimeAccessces) {

                lblEmployeeId.setValue(": " + "[ " + hm.get("EMP_ID").toString() + " ]");
                lblFullName.setValue(": " + "[ " + hm.get("FULLNAME") + " ]");
                lblJobPosition.setValue(": " + hm.get("JOB_DESCRIPTION"));
                lblLeaveType.setValue(": " + hm.get("DESCRIPTION"));
                lblLeaveDays.setValue(": " + hm.get("LEAVE_DAYS"));
                lblStartDate.setValue(": " + hm.get("REQUESTED_FROM_DATE"));
                lblEndDateLevel.setValue(": " + hm.get("REQUESTED_TO_DATE"));
                lblReasonReturnFromLeave.setValue(": " + hm.get("REASONOFRETRUN"));
                lblRequestedRetrunDate.setValue(": " + hm.get("RETURN_DATE"));
                lblEmployeeDepartment.setValue(": " + hm.get("DEP_DESCRIPTION"));
                retrunFromLeaveRequestId = hm.get("REQUEST_ID").toString();
                lblReasonReturnFromLeaveca.setValue("Reason of Leave Payment");
                lblReason.setValue(": " + hm.get("REQUESTING_REASON"));
                lblPhsicalYear.setValue(": " + hm.get("PHYSICALYEAR"));
//                REASONOFRETRUN
                if (hm.get("SEX").equals("Male")) {
                    choMaleSe.setSelected(true);
                    choFemaleSe.setSelected(false);
                } else {
                    choMaleSe.setSelected(false);
                    choFemaleSe.setSelected(true);
                }
                try {
                    OracleSerialBlob blo = (OracleSerialBlob) hm.get("PHOTO");
                    setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                    imgEmployeePicture.setValue(getEmployeePicture());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                firstTimeAccessces = false;
                lblRemainingLeaveDays.setValue(": " + leaveRequestManager.readEmployeeAvailableAnualLeave(hm.get("EMP_ID").toString()));
            }




        }
    }

    public String btnSave_action() {
        availableDecisionsToMakeList = approveReturnFromLeaveManager.getAvailableDecisionsToMake(requestStatus);
        ApproveReturnFromLeaveManager approveReturnFromLeaveInform =
                new ApproveReturnFromLeaveManager(
                null,
                retrunFromLeaveRequestId,
                txtDeciderId.getValue().toString(),
                txtaDeciderComment.getValue().toString(),
                drlDecision.getValue().toString(),
                getSessionBean1().getEmployeeId(),
                requestStatus);
        if (!checkLeavePayment) {
            if (approveReturnFromLeaveManager.saveleaveDecision(approveReturnFromLeaveInform)) {
                showSuccessOrFailureMessage(true, "YOUR DECISION SAVING SUCCESSFUL");
                clearComponet();
                loadRequestList();
            } else {
                showSuccessOrFailureMessage(true, "YOUR DECISION NOT SAVED SUCCESSFUL. PLEASE TRY AGAIN ?");

            }
        } else {
            if (approveReturnFromLeaveManager.saveleavePaymentDecision(approveReturnFromLeaveInform)) {
                showSuccessOrFailureMessage(true, "YOUR DECISION SAVING SUCCESSFUL");
                clearComponet();
                loadRequestList();
            } else {
                showSuccessOrFailureMessage(false, "YOUR DECISION NOT SAVED SUCCESSFUL. PLEASE TRY AGAIN ?");



            }

        }
        //return null means stay on the same page
        return null;
    }

    public void listLeavePaymetRequest_processValueChange(ValueChangeEvent vce) {
        checkLeavePayment = true;
        clearComponet();
        if (HRValidation.validateRequired(vce.getNewValue())) {
            String[] requestInfos = vce.getNewValue().toString().split("--");
            requesterId = requestInfos[0];
            requestStatus = requestInfos[1];
            requestedDate = requestInfos[2];
            paymentRequestId = requestInfos[3];
            availableDecisionsToMakeList = approveReturnFromLeaveManager.getAvailableDecisionsToMake(requestStatus);
            populateApproverTextComponents(getSessionBean1().getEmployeeId());
            loadEmployeePaymentRequestData();
        }
    }

    private void loadRequestList() {
        requestListsToBeApproved = approveReturnFromLeaveManager.getRequestsToBeProcessed();
        setListOfPaymentRequest(approveReturnFromLeaveManager.getToBeProcessedLeavePayment());
    }

    public String lnkViewPrevieousDecisions_action() {
        int leave_request = 0;
        lblDesstionStatus.setRendered(false);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        int counter = 0;
        if (!checkLeavePayment) {
            leave_request = Integer.parseInt(retuirnRequestId);
            decisionsMadeOnRequest.clear();
            ArrayList<HashMap> leaveRequestHistory =
                    approveReturnFromLeaveManager.getLeaveRequestHistory(leave_request);
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
        } else {
            leave_request = Integer.parseInt(paymentRequestId);
            decisionsMadeOnRequest.clear();
            ArrayList<HashMap> leaveRequestHistory =
                    approveReturnFromLeaveManager.getLeavePaymentRequestHistory(leave_request);
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
        }
        // TODO: Replace with your code
        return null;
    }

    public String btnClosePopupViewPrevieousDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    private void userRole() {
        SiteSecurityManager security = new SiteSecurityManager();
        Set<HashMap> prmitionList = security.readUserPermition(getSessionBean1().getUserName(),
                getSessionBean1().getRequestedPage());
        boolean ifCan = true;
        String prmissionId = SiteSecurityManager.Permission_Payment_Approve;
        for (HashMap s : prmitionList) {
            if (s.get("per").equals(prmissionId)) {
                listLeavePaymetRequest.setRendered(true);
                listLeavePaymetRequest.setVisible(true);
                ifCan = false;
            }
        }

        if (ifCan) {
            statusContainerPaymentRequest.setRendered(false);
            listLeavePaymetRequest.setRendered(false);
        }


    }
}
