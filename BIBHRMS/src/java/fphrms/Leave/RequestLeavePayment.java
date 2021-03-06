/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright dereje(one)
 */
package fphrms.Leave;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
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
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.LookUpManager;
import manager.employeeManager.EmployeeManage;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.Report.MainReport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import javax.faces.component.UIInput;
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
public class RequestLeavePayment extends AbstractPageBean {

    private LookUpManager lookUpManager = new LookUpManager();
    private AnnualLeaveManager annualLeaveManager = new AnnualLeaveManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private LeaveSettlementManager leaveSettlementManager = new LeaveSettlementManager();
    private LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private RequestFromLeaveManager leaveManager = new RequestFromLeaveManager();
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<SelectItem> employeeRequestedReturnFromLeaveList = new ArrayList<SelectItem>();
    private RequestFromLeaveManager requestFromLeaveManager = new RequestFromLeaveManager();
    private ApproveReturnFromLeaveManager approveReturnFromLeaveManager = new ApproveReturnFromLeaveManager();
    private boolean checkReturnFromLeave;
    private int commiteeTableSize = 0;
    private int commMemberTableSize = 0;
    private String commiteID = null;
    private int buttonIdentifier = 0;
    private int countCommittee = 0;
    private int countCommitteeMember = 0;
    private byte[] employeePicture;
    private String requestId = null;
    private boolean checkLoad = false;
    private String leaveRequestId;
    private String returnFromLeaveId;
    private boolean callMeOnece = true;

    public ArrayList<SelectItem> getEmployeeRequestedReturnFromLeaveList() {
        return employeeRequestedReturnFromLeaveList;
    }

    public void setEmployeeRequestedReturnFromLeaveList(ArrayList<SelectItem> employeeRequestedReturnFromLeaveList) {
        this.employeeRequestedReturnFromLeaveList = employeeRequestedReturnFromLeaveList;
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
        colReturnFromListEmployee.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                colReturnFromListEmployee_processAction(ae);
            }
        });
        pnl_col_Status.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnl_col_Status_processAction(ae);
            }
        });
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
    private HtmlInputText txtEmployeeIDentification = new HtmlInputText();
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();
    private HtmlInputTextarea txtLeaveSettleDescription = new HtmlInputTextarea();
    private HtmlCommandButton btnSettleSave = new HtmlCommandButton();
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();
    private HtmlOutputLabel lblFormMessage4 = new HtmlOutputLabel();
    private PanelPopup pnConfirmationForDelete = new PanelPopup();
    private PanelPopup pnConfirmationMessage = new PanelPopup();
    private PanelLayout pnlConfirmationMessageBody = new PanelLayout();
    private HtmlOutputLabel lblFormDeleteMessage = new HtmlOutputLabel();

    public DefaultSelectItemsArray getSelectOneMenu4DefaultItems3() {
        return selectOneMenu4DefaultItems3;
    }

    public void setSelectOneMenu4DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu4DefaultItems3 = dsia;
    }

    public HtmlInputText getTxtEmployeeIDentification() {
        return txtEmployeeIDentification;
    }

    public void setTxtEmployeeIDentification(HtmlInputText hit) {
        this.txtEmployeeIDentification = hit;
    }

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }

    public HtmlInputTextarea getTxtLeaveSettleDescription() {
        return txtLeaveSettleDescription;
    }

    public void setTxtLeaveSettleDescription(HtmlInputTextarea hit) {
        this.txtLeaveSettleDescription = hit;
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
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
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
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private HtmlOutputText lblLeaveType = new HtmlOutputText();

    public HtmlOutputText getLblLeaveType() {
        return lblLeaveType;
    }

    public void setLblLeaveType(HtmlOutputText hot) {
        this.lblLeaveType = hot;
    }
    private HtmlOutputText leaveDays = new HtmlOutputText();

    public HtmlOutputText getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(HtmlOutputText hot) {
        this.leaveDays = hot;
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
    private HtmlInputText txtReturnDate = new HtmlInputText();

    public HtmlInputText getTxtReturnDate() {
        return txtReturnDate;
    }

    public void setTxtReturnDate(HtmlInputText hit) {
        this.txtReturnDate = hit;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
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
    private HtmlCommandButton btnCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalender() {
        return btnCalender;
    }

    public void setBtnCalender(HtmlCommandButton hcb) {
        this.btnCalender = hcb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private SelectInputDate strReturnDate = new SelectInputDate();

    public SelectInputDate getStrReturnDate() {
        return strReturnDate;
    }

    public void setStrReturnDate(SelectInputDate sid) {
        this.strReturnDate = sid;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private HtmlPanelGroup status_Group_Header = new HtmlPanelGroup();

    public HtmlPanelGroup getStatus_Group_Header() {
        return status_Group_Header;
    }

    public void setStatus_Group_Header(HtmlPanelGroup hpg) {
        this.status_Group_Header = hpg;
    }
    private PanelCollapsible pnl_col_Status = new PanelCollapsible();

    public PanelCollapsible getPnl_col_Status() {
        return pnl_col_Status;
    }

    public void setPnl_col_Status(PanelCollapsible pc) {
        this.pnl_col_Status = pc;
    }
    private PanelCollapsible colReturnFromListEmployee = new PanelCollapsible();

    public PanelCollapsible getColReturnFromListEmployee() {
        return colReturnFromListEmployee;
    }

    public void setColReturnFromListEmployee(PanelCollapsible pc) {
        this.colReturnFromListEmployee = pc;
    }
    private HtmlSelectOneListbox lstEmployeeReturnFromAnualLeave = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstEmployeeReturnFromAnualLeave() {
        return lstEmployeeReturnFromAnualLeave;
    }

    public void setLstEmployeeReturnFromAnualLeave(HtmlSelectOneListbox hsol) {
        this.lstEmployeeReturnFromAnualLeave = hsol;
    }
    private HtmlOutputText lblPhsicalYear = new HtmlOutputText();

    public HtmlOutputText getLblPhsicalYear() {
        return lblPhsicalYear;
    }

    public void setLblPhsicalYear(HtmlOutputText hot) {
        this.lblPhsicalYear = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RequestLeavePayment() {
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
        if (callMeOnece) {

            userRole();
            callMeOnece = false;

            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

            loadEmployeeRequest();
            btnNew.setDisabled(true);
            clearComponet();
            disabledComponet();


        }

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

    private void loadEmployeeRequest() {
        setEmployeeRequestedReturnFromLeaveList(
                requestFromLeaveManager.readRequesteToReturnFromLeaveEmployeeAndReturn());
    }

    private void clearComponet() {
        lblFullName.setValue("");
        lblEmployeeDepartment.setValue("");
        lblJobPosition.setValue("");
        choMaleSe.setValue("");
        choFemaleSe.setValue("");
        lblLeaveType.setValue("");
        leaveDays.setValue("");
        lblStartDate.setValue("");
        lblEndDateLevel.setValue("");
        lblReason.setValue("");
        txtReturnDate.setValue("");
        txtLeaveSettleDescription.setValue("");

    }

    private void disabledComponet() {
        btnCalender.setDisabled(false);
        txtLeaveSettleDescription.setDisabled(true);
        txtReturnDate.setDisabled(true);
        btnSettleSave.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnCalender.setDisabled(true);
    }

    private void enableComponet() {

        txtEmployeeIDentification.setDisabled(false);
        txtLeaveSettleDescription.setDisabled(false);
        btnCalender.setDisabled(false);
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
        disabledComponet();
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

    void disableInfoTextComponets() {
        btnNew.setDisabled(false);
        btnSave.setDisabled(true);
        btnReset.setDisabled(true);
//        txtEmployeeID.setDisabled(true);

    }

    void enableComponets() {
        btnNew.setDisabled(false);
        btnSave.setDisabled(false);
        btnReset.setDisabled(false);

    }

    public String btnSave_action() {
        try {
            if (validateRequestInformation()) {
                if (leaveSettlementManager.checkRequestStatus(leaveRequestId)) {

                    RequestFromLeaveManager paymentRequest = new RequestFromLeaveManager(
                            txtEmployeeIDentification.getValue().toString(),
                            txtReturnDate.getValue().toString(),
                            txtLeaveSettleDescription.getValue().toString(),
                            getSessionBean1().getEmployeeId(),
                            returnFromLeaveId,
                            false);
                    if (leaveManager.saveRequestPaymentInformation(paymentRequest)) {
                        clearComponet();
                        loadEmployeeRequest();
                        showSuccessOrFailureMessage(true, "Your request successfully saved!!");
                    } else {
                        showSuccessOrFailureMessage(false, "Your request not saved.Please try again ?");
                    }



                } else {
                    showSuccessOrFailureMessage(false, "This request already requested .please wait until your request get decision ?");
                }

            } else {
                showSuccessOrFailureMessage(false, "Your Data is not validate ?");
            }


//            int avilebelDay = 0;
//            int diffrence = 0;//StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),
//            //    txtEndDate.getValue().toString());
//
//            String avilableDayes = null;
//
//            if (avilebelDay >= diffrence) {
//
//
//
//                if (true) {
//
//                    showSuccessOrFailureMessage(true, "Employee Leave type " +
//                            " information  successfully changed!!");
//
//                    btnSave.setDisabled(true);
//                    btnReset.setDisabled(false);
//
//                } else {
//                    showSuccessOrFailureMessage(false, "Employee Leave " +
//                            " type information not changed. Please try again ?");
//                }
//            } else {
//                //AnualLeaveSave
//                HashMap hm = new HashMap();
//
//
//
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }





        //return null means stay on the same page
        return null;
    }

    public String lnkDisciplineRequest_action() {
        return "DisciplineIssue";
    }

    public String lnkCommitteeMembers_action() {
        return "CommitteeMembers";
    }

    public String lnkDisciplinePenality_action() {
        return "PenalityTypes";
    }

    public String lnkDisciplineApprove_action() {
        return "DisciplineApprove";
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
        checkReturnFromLeave = false;
        HashMap list = leaveManager.readEmployeeLeaveWithProfile(employeeId);
        if (list != null) {
            btnNew.setDisabled(false);
            lblEmployeeDepartment.setValue(list.get("DEPARTMENT_ID").toString());
            txtLeaveSettleDescription.setDisabled(false);
            txtEmployeeIDentification.setValue(employeeId);
            lblFullName.setValue(list.get("FULLNAME").toString());
            lblJobPosition.setValue(list.get("JOB_DESCRIPTION").toString());
            leaveDays.setValue(list.get("LEAVE_DAYS").toString());
            lblLeaveType.setValue(list.get("DESCRIPTION").toString());
            lblStartDate.setValue(list.get("REQUESTED_FROM_DATE").toString());
            lblEndDateLevel.setValue(list.get("REQUESTED_TO_DATE").toString());
            lblReason.setValue(list.get("REQUESTING_REASON").toString());
            leaveRequestId = list.get("LEAVE_ID").toString();
            lblPhsicalYear.setValue(list.get("PHYSICALYEAR").toString());
            try {
                OracleSerialBlob blo = (OracleSerialBlob) list.get("PHOTO");
                setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                imgEmployeePicture.setValue(getEmployeePicture());
            } catch (Exception ex) {
                ex.printStackTrace();
            }


            if (list.get("SEX").toString().equals("Female")) {
                choMaleSe.setSelected(false);
                choFemaleSe.setSelected(true);
            } else {
                choMaleSe.setSelected(true);
            }
            btnSettleSave.setDisabled(false);
            checkLoad = true;
            btnNew.setDisabled(false);
        }
    }

    public String btnSearchEmployeeLeave_action() {
        employeeInformation(txtEmployeeIDentification.getValue().toString());
        //  txtEmployeeID.setValue(txtEmployeeIDentification.getValue().toString());
        //return null means stay on the same page
        return null;
    }

    public String btnCalender_action() {
        strReturnDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    boolean validateRequestInformation() {
        boolean result = true;
        int errorValue = 0;
        errorValue = HRValidation.validateData(this.txtReturnDate.getValue(), HRValidation.DATE_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtReturnDate).setValid(false);
                error(txtReturnDate, "Required");
            } else {
                ((UIInput) txtReturnDate).setValid(false);
                error(txtReturnDate, "Invalid Value");
            }
        }
        errorValue = HRValidation.validateData(this.txtLeaveSettleDescription.getValue(), HRValidation.REMARK_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtLeaveSettleDescription).setValid(false);
                error(txtLeaveSettleDescription, "Required");
            } else {
                ((UIInput) txtLeaveSettleDescription).setValid(false);
                error(txtLeaveSettleDescription, "Invalid Value");
            }
            if (!HRValidation.validateRequired(txtEmployeeIDentification.getValue())) {
                result = false;
            }
            if (!checkLoad) {
                result = false;
            }
        }
        return result;
    }

    public String btnNew_action() {
        enableComponet();
        if (checkReturnFromLeave) {
            txtLeaveSettleDescription.setValue("");
            btnSave.setDisabled(false);
        } else {
            txtReturnDate.setValue("");
            txtLeaveSettleDescription.setValue("");
            btnSave.setDisabled(false);
        }
        btnNew.setDisabled(true);

        //return null means stay on the same page
        return null;
    }

    public void strReturnDate_processValueChange(ValueChangeEvent vce) {
        txtReturnDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        strReturnDate.setRendered(false);
    }

    public void colReturnFromListEmployee_processAction(ActionEvent ae) {
        colReturnFromListEmployee.setExpanded(true);
        pnl_col_Status.setExpanded(false);
    }

    public void pnl_col_Status_processAction(ActionEvent ae) {
        colReturnFromListEmployee.setExpanded(false);
        pnl_col_Status.setExpanded(true);
    }

    public void lstEmployeeReturnFromAnualLeave_processValueChange(ValueChangeEvent vce) {
        checkReturnFromLeave = true;
        String employeeId;
        String requestStatus;
        String requestedDate;
        String paymnetStatus;
        btnNew.setDisabled(false);
        try {
            if (vce.getNewValue() != null) {
                String listValue[] = vce.getNewValue().toString().split("=");
                //txtEmployeeID.setValue(listValue[0]);
                employeeId = listValue[0];
                requestStatus = listValue[1];
                requestedDate = listValue[2];
                paymnetStatus = listValue[3];
                returnFromLeaveId = listValue[4];
                if (!paymnetStatus.equals("waiting")) {
                    displayEmployeeReturnFromLeave(
                            employeeId,
                            requestStatus,
                            requestedDate);
                } else {
                    showSuccessOrFailureMessage(false, "The employee not return back from leave. please waite untile he/she retuen back from leave ?");
                }
//           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void displayEmployeeReturnFromLeave(String employeeId, String requestStatus, String requestedDate) {
//            approveReturnFromLeaveManager

        try {
            if (employeeId != null) {
                HashMap hm =
                        approveReturnFromLeaveManager.readEmployeeLeaveRequest(
                        employeeId,
                        requestStatus,
                        requestedDate);
//
                if (hm != null) {
                    txtEmployeeIDentification.setValue(hm.get("EMP_ID"));
                    lblFullName.setValue(hm.get("FULLNAME"));
                    String sex = hm.get("SEX").toString();
                    try {
                        OracleSerialBlob blo = (OracleSerialBlob) hm.get("PHOTO");
                        setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                        imgEmployeePicture.setValue(getEmployeePicture());
                    } catch (Exception ex) {
                    }
                    if (sex.equalsIgnoreCase("Male")) {
                        choMaleSe.setSelected(true);
                        choFemaleSe.setSelected(false);
                    } else if (sex.equalsIgnoreCase("Female")) {
                        choFemaleSe.setSelected(true);
                        choMaleSe.setSelected(false);
                    } else {
                        choMaleSe.setSelected(false);
                        choFemaleSe.setSelected(false);
                    }
//                    if (hm.get("EMP_STATUS").toString().equals("01")) {
//                        lblEmploymentStatus.setValue("ACTIVE");
//                    } else {
//                        lblEmploymentStatus.setValue("INACTIVE");
//                    }
                    lblJobPosition.setValue(hm.get("JOB_DESCRIPTION"));
                    lblEmployeeDepartment.setValue(hm.get("DEP_DESCRIPTION"));
                    txtReturnDate.setValue(hm.get("RETURN_DATE"));

                    lblLeaveType.setValue(hm.get("DESCRIPTION"));
                    leaveDays.setValue(hm.get("LEAVE_DAYS"));
                    lblStartDate.setValue(hm.get("REQUESTED_FROM_DATE"));
                    lblEndDateLevel.setValue(hm.get("REQUESTED_TO_DATE"));
                    lblReason.setValue(hm.get("REASONOFRETRUN"));
                    btnNew.setDisabled(false);
//                    lblLeaveStartDateDis.setValue(hm.get("JOB_DESCRIPTION"));
//                    lblLeaveEndDate.setValue(hm.get("JOB_DESCRIPTION"));
//                    lblLeaveTypeDes.setValue(hm.get("DESCRIPTION"));
//                    lblRequestedReturnDate.setValue(hm.get("RETURN_DATE"));
//                    leaveRequestId = hm.get("REQUEST_ID").toString();
//
                } else {
                    this.showSuccessOrFailureMessage(false, "Unable To Find The ecord");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void userRole() {
        SiteSecurityManager security = new SiteSecurityManager();
        Set<HashMap> prmitionList = security.readUserPermition(getSessionBean1().getUserName(),
                getSessionBean1().getRequestedPage());
        for (HashMap s : prmitionList) {
            if (s.get("per").equals(SiteSecurityManager.Permission_Payment_Requester)) {
                lstEmployeeReturnFromAnualLeave.setRendered(true);
                break;
            }

        }


    }

    public void page_display_processMyEvent(DragEvent de) {
    }
}
