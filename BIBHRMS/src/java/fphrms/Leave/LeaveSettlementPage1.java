/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright dereje(one)
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.LookUpManager;
import manager.employeeManager.EmployeeManage;
import oracle.jdbc.rowset.OracleSerialBlob;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.Report.MainReport;
import manager.globalUseManager.CommonValidation;
import manager.globalUseManager.DateConverter;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;
import manager.leaveManager.AnnualLeaveManager;
import manager.leaveManager.LeaveRequestManager;
import manager.leaveManager.LeaveSettlementManager;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LeaveSettlementPage1 extends AbstractPageBean {

    private LookUpManager lookUpManager = new LookUpManager();
    private ArrayList<SelectItem> employeeOnLeave = new ArrayList<SelectItem>();
    private AnnualLeaveManager annualLeaveManager=new AnnualLeaveManager();
    private ArrayList<SelectItem> readCommitteStatus = new ArrayList<SelectItem>();
    private ArrayList<EmployeeLeaveList> commiteTable = new ArrayList<EmployeeLeaveList>();
    private ArrayList<EmployeeLeaveList> employeeLeaveList = new ArrayList<EmployeeLeaveList>();
    private ArrayList<SelectItem> readCommitteeType = new ArrayList<SelectItem>();
    private EmployeeManage employeeManager = new EmployeeManage();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();   
    private LeaveSettlementManager leaveSettlementManager=new LeaveSettlementManager();
  private  LeaveRequestManager leaveRequestManager =new LeaveRequestManager();
    private int commiteeTableSize =  0;
    private int commMemberTableSize = 0;
    private String commiteID = null;
    private int buttonIdentifier = 0;
    private int countCommittee = 0;
    private int countCommitteeMember = 0;
    private byte[] employeePicture;
    private String committeeMemberID;
    private String gender = null;
    private String leaveType = null;
    private String startDate = null;
    private String endDate = null;
    private String leaveDay = null;
    private String leaveId = null;
    private String requestDate = null;
    int changeUsedLeaveRow = -1;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCommitteeMemberID() {
        return committeeMemberID;
    }

    public void setCommitteeMemberID(String committeeMemberID) {
        this.committeeMemberID = committeeMemberID;
    }

    public ArrayList<EmployeeLeaveList> getEmployeeLeaveList() {
        return employeeLeaveList;
    }

    public void setEmployeeLeaveList(ArrayList<EmployeeLeaveList> employeeLeaveList) {
        this.employeeLeaveList = employeeLeaveList;
    }

    public ArrayList<SelectItem> getReadCommitteStatus() {
        return readCommitteStatus;
    }

    public void setReadCommitteStatus(ArrayList<SelectItem> readCommitteStatus) {
        this.readCommitteStatus = readCommitteStatus;
    }

    public ArrayList<SelectItem> getReadCommitteeType() {
        return readCommitteeType;
    }

    public void setReadCommitteeType(ArrayList<SelectItem> readCommitteeType) {
        this.readCommitteeType = readCommitteeType;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public ArrayList<EmployeeLeaveList> getCommiteTable() {
        return commiteTable;
    }

    public void setCommiteTable(ArrayList<EmployeeLeaveList> commiteTable) {
        this.commiteTable = commiteTable;
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
    private HtmlSelectOneMenu drlEmployeeID = new HtmlSelectOneMenu();
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

    public HtmlSelectOneMenu getDrlEmployeeID() {
        return drlEmployeeID;
    }

    public void setDrlEmployeeID(HtmlSelectOneMenu hsom) {
        this.drlEmployeeID = hsom;
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
    private HtmlSelectBooleanCheckbox choMale = new HtmlSelectBooleanCheckbox();
    private HtmlSelectBooleanCheckbox choFemale = new HtmlSelectBooleanCheckbox();
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
    private HtmlInputText txtEmployeeID = new HtmlInputText();

    public HtmlInputText getTxtEmployeeID() {
        return txtEmployeeID;
    }

    public void setTxtEmployeeID(HtmlInputText hit) {
        this.txtEmployeeID = hit;
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

    public HtmlSelectBooleanCheckbox getChoMale() {
        return choMale;
    }

    public void setChoMale(HtmlSelectBooleanCheckbox hsbc) {
        this.choMale = hsbc;
    }

    public HtmlSelectBooleanCheckbox getChoFemale() {
        return choFemale;
    }

    public void setChoFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.choFemale = hsbc;
    }
    private HtmlOutputText lblServiceYear = new HtmlOutputText();

    public HtmlOutputText getLblServiceYear() {
        return lblServiceYear;
    }

    public void setLblServiceYear(HtmlOutputText hot) {
        this.lblServiceYear = hot;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlSelectOneMenu drlLeaveTypeFrom = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLeaveTypeFrom() {
        return drlLeaveTypeFrom;
    }

    public void setDrlLeaveTypeFrom(HtmlSelectOneMenu hsom) {
        this.drlLeaveTypeFrom = hsom;
    }
    private HtmlSelectOneMenu drlLeaveTypeTo = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLeaveTypeTo() {
        return drlLeaveTypeTo;
    }

    public void setDrlLeaveTypeTo(HtmlSelectOneMenu hsom) {
        this.drlLeaveTypeTo = hsom;
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
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
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
    private HtmlDataTable tblCommitteeMamber = new HtmlDataTable();

    public HtmlDataTable getTblCommitteeMamber() {
        return tblCommitteeMamber;
    }

    public void setTblCommitteeMamber(HtmlDataTable hdt) {
        this.tblCommitteeMamber = hdt;
    }
    private HtmlCommandButton btnEmplyeeSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnEmplyeeSearch() {
        return btnEmplyeeSearch;
    }

    public void setBtnEmplyeeSearch(HtmlCommandButton hcb) {
        this.btnEmplyeeSearch = hcb;
    }
    private HtmlCommandButton btnCalenderDateFrom = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderDateFrom() {
        return btnCalenderDateFrom;
    }

    public void setBtnCalenderDateFrom(HtmlCommandButton hcb) {
        this.btnCalenderDateFrom = hcb;
    }
    private HtmlInputText txtAvilablDayes = new HtmlInputText();

    public HtmlInputText getTxtAvilablDayes() {
        return txtAvilablDayes;
    }

    public void setTxtAvilablDayes(HtmlInputText hit) {
        this.txtAvilablDayes = hit;
    }
    private HtmlInputText txtLeaveDays = new HtmlInputText();

    public HtmlInputText getTxtLeaveDays() {
        return txtLeaveDays;
    }

    public void setTxtLeaveDays(HtmlInputText hit) {
        this.txtLeaveDays = hit;
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
    private HtmlOutputText lblJobPosition1 = new HtmlOutputText();

    public HtmlOutputText getLblJobPosition1() {
        return lblJobPosition1;
    }

    public void setLblJobPosition1(HtmlOutputText hot) {
        this.lblJobPosition1 = hot;
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
    private HtmlGraphicImage graphicImage1 = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImage1() {
        return graphicImage1;
    }

    public void setGraphicImage1(HtmlGraphicImage hgi) {
        this.graphicImage1 = hgi;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LeaveSettlementPage1() {
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

        setEmployeeOnLeave(leaveSettlementManager.employessOnLeave());
        setReadCommitteStatus(leaveRequestManager.loadLeaveTypes());
        setReadCommitteeType(leaveRequestManager.loadLeaveTypes());
        disableComponet();
        clearComponet();
        disabledComponet();

        btnNew.setDisabled(true);

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
        drlEmployeeID.setValue("");
        txtEmployeeIDentification.setValue("");
        txtLeaveSettleDescription.setValue("");
    }

    private void disabledComponet() {
        drlEmployeeID.setDisabled(false);
        txtEmployeeIDentification.setDisabled(false);
        txtLeaveSettleDescription.setDisabled(true);
        btnSettleSave.setDisabled(true);
    }

    private void enableComponet() {
        drlEmployeeID.setDisabled(false);
        txtEmployeeIDentification.setDisabled(false);
        txtLeaveSettleDescription.setDisabled(false);
    }

    public static class EmployeeLeaveList implements Serializable {

        private String leaveTypeId;
        private String leaveTypeDescription;
        private String leaveId;
        private String leaveDay;
        private String startDate;
        private String endDate;
        private String leaveRequestResone;

        public EmployeeLeaveList() {
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getLeaveDay() {
            return leaveDay;
        }

        public void setLeaveDay(String leaveDay) {
            this.leaveDay = leaveDay;
        }

        public String getLeaveId() {
            return leaveId;
        }

        public void setLeaveId(String leaveId) {
            this.leaveId = leaveId;
        }

        public String getLeaveRequestResone() {
            return leaveRequestResone;
        }

        public void setLeaveRequestResone(String leaveRequestResone) {
            this.leaveRequestResone = leaveRequestResone;
        }

        public String getLeaveTypeDescription() {
            return leaveTypeDescription;
        }

        public void setLeaveTypeDescription(String leaveTypeDescription) {
            this.leaveTypeDescription = leaveTypeDescription;
        }

        public String getLeaveTypeId() {
            return leaveTypeId;
        }

        public void setLeaveTypeId(String leaveTypeId) {
            this.leaveTypeId = leaveTypeId;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }
        private boolean selected;

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public EmployeeLeaveList(String leaveTypeId, String leaveTypeDescription,
                String leaveId, String leaveDay, String startDate, String endDate,
                String leaveRequestResone) {
            this.leaveTypeId = leaveTypeId;
            this.leaveTypeDescription = leaveTypeDescription;
            this.leaveId = leaveId;
            this.leaveDay = leaveDay;
            this.startDate = startDate;
            this.endDate = endDate;
            this.leaveRequestResone = leaveRequestResone;
        }
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

    public String btnSaveCommiteType_action() {
        try {
            //getRequestsLists().clear();
            if (txtEmployeeID.getValue().toString() != null) {
                clearInfoTextComponets();
                EmployeeManage employeeManager = new EmployeeManage();
                if (employeeManager.loadEmpoyeeProfile(txtEmployeeID.getValue().toString()) == 1) {
                    String sex = null;
                    lblFull_Name.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " +
                            "" + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
                    sex = employeeManager.getSex();
                    if (sex.equalsIgnoreCase("Male")) {
                        setGender("Male");
                        choMale.setSelected(true);
                        choFemale.setSelected(false);
                    } else if (sex.equalsIgnoreCase("Female")) {
                        choFemale.setSelected(true);
                        setGender("Female");
                        choMale.setSelected(false);
                    } else {
                        choMale.setSelected(false);
                        choFemale.setSelected(false);
                        setGender(null);
                    }

                    try {
                        int expYear = employeeManager.calculateEmpServiceYears(txtEmployeeID.getValue().toString());
                        lblServiceYear.setValue(String.valueOf(expYear));
                        OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                        setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                        imgEmployeePicture.setValue(getEmployeePicture());
                        ArrayList<HashMap> listOfEmployeeLeave = leaveSettlementManager.readUsedEmployeeLeave(txtEmployeeID.getValue().toString());
                        getEmployeeLeaveList().clear();
                        if (listOfEmployeeLeave.size() > 0) {
                            for (HashMap hm : listOfEmployeeLeave) {
                                getEmployeeLeaveList().add(new EmployeeLeaveList(hm.get("leaveType").toString(),
                                        hm.get("leaveTypeDescription").toString(),
                                        hm.get("leaveId").toString(), hm.get("leaveDays").toString(),
                                        hm.get("fromDate").toString(), hm.get("toDate").toString(),
                                        hm.get("requestReason").toString()));
                            }
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));
                    this.lblPosition.setValue(employeeManager.getJobDescription());
                } else {
                    clearInfoTextComponets();
                    showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");


//
                }
            }
        } catch (Exception e) {
        }
        //return null means stay on the same page




        //return null means stay on the same page
        return null;
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



    public String btnEmplyeeSearch_action() {
        try {
            //getRequestsLists().clear();
            if (txtEmployeeID.getValue().toString() != null) {
                clearInfoTextComponets();
                EmployeeManage employeeManager = new EmployeeManage();
                if (employeeManager.loadEmpoyeeProfile(txtEmployeeID.getValue().toString()) == 1) {
                    String sex = null;
                    lblFull_Name.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " +
                            "" + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
                    sex = employeeManager.getSex();
                    if (sex.equalsIgnoreCase("Male")) {
                        setGender("Male");
                        choMale.setSelected(true);
                        choFemale.setSelected(false);
                    } else if (sex.equalsIgnoreCase("Female")) {
                        choFemale.setSelected(true);
                        setGender("Female");
                        choMale.setSelected(false);
                    } else {
                        choMale.setSelected(false);
                        choFemale.setSelected(false);
                        setGender(null);
                    }

                    try {
                        int expYear = employeeManager.calculateEmpServiceYears(txtEmployeeID.getValue().toString());
                        lblServiceYear.setValue(String.valueOf(expYear));
                        OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
                        setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                        imgEmployeePicture.setValue(getEmployeePicture());
                        ArrayList<HashMap> listOfEmployeeLeave = leaveSettlementManager.readUsedEmployeeLeave(txtEmployeeID.getValue().toString());
                        getEmployeeLeaveList().clear();
                        if (listOfEmployeeLeave.size() > 0) {
                            for (HashMap hm : listOfEmployeeLeave) {
                                getEmployeeLeaveList().add(new EmployeeLeaveList(hm.get("leaveType").toString(),
                                        hm.get("leaveTypeDescription").toString(),
                                        hm.get("leaveId").toString(), hm.get("leaveDays").toString(),
                                        hm.get("fromDate").toString(), hm.get("toDate").toString(),
                                        hm.get("requestReason").toString()));
                            }
                        }
                        btnNew.setDisabled(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));
                    this.lblPosition.setValue(employeeManager.getJobDescription());
                } else {
                    clearInfoTextComponets();
                    showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");


//
                }
            }
        } catch (Exception e) {
        }
        //return null means stay on the same page
        return null;
    }

    void clearInfoTextComponets() {

        lblFull_Name.setValue("");
        lblPosition.setValue("");
        lblDepartment.setValue("");
        choFemale.setSelected(false);
        choMale.setSelected(false);
        lblServiceYear.setValue("");
        drlLeaveTypeFrom.setValue("");
        drlLeaveTypeTo.setValue("");
        txtStartDate.setValue("");
        txtEndDate.setValue("");
        txtRemark.setValue("");
        choFemale.setValue("");
        choMale.setValue("");
        txtLeaveDays.setValue("");

    }

    void disableInfoTextComponets() {
        choFemale.setDisabled(true);
        choMale.setDisabled(true);
        drlLeaveTypeFrom.setDisabled(true);
        drlLeaveTypeTo.setDisabled(true);
        txtStartDate.setDisabled(true);
        txtEndDate.setDisabled(true);
        txtRemark.setDisabled(true);
        btnNew.setDisabled(false);
        btnSave.setDisabled(true);
        btnReset.setDisabled(true);
//        txtEmployeeID.setDisabled(true);

    }

    void enableInfoTextComponets() {
        choFemale.setDisabled(true);
        choMale.setDisabled(true);
        btnSave.setDisabled(true);
        btnReset.setDisabled(false);
        txtEmployeeID.setDisabled(false);
        txtLeaveDays.setDisabled(false);
    }

    void enableComponets() {
        choFemale.setDisabled(false);
        choMale.setDisabled(false);
        drlLeaveTypeFrom.setDisabled(false);
        drlLeaveTypeTo.setDisabled(false);
        txtStartDate.setDisabled(false);
        txtEndDate.setDisabled(false);
        txtRemark.setDisabled(false);
        btnNew.setDisabled(false);
        btnSave.setDisabled(false);
        btnReset.setDisabled(false);
        txtEmployeeID.setDisabled(false);


    }

    public String btnNew_action() {
        //return null means stay on the same page
        enableInfoTextComponets();
        clearInfoTextComponets();
        btnNew.setDisabled(true);
        btnEmplyeeSearch.setDisabled(false);

        return null;
    }

    public void displayAvailableDays(String selectedEmployeeId, String selectedLeaveType) {
        try {
//employeeManager.lo
            if (selectedLeaveType != null) {
                if (!selectedLeaveType.equals("")) {
                    if (!selectedLeaveType.equals(null)) {
                        if ((selectedLeaveType.equals("2") || selectedLeaveType.equals("3") || selectedLeaveType.equals("4")) && getGender().equalsIgnoreCase("Male")) {
                            showSuccessOrFailureMessage(false, "Only women  can take maternity leave, " +
                                    " prenatal leave and post natal leave." +
                                    " Please select other type of leave type ?");
                            btnSave.setDisabled(true);
                        } else if (selectedLeaveType.equals("5") && getGender().equalsIgnoreCase("Female")) {
                            showSuccessOrFailureMessage(false, "Women can't take paternal leave");
                            btnSave.setDisabled(true);
                        } else if (selectedLeaveType.equals("1")) {//annual
                            int serviceYear = employeeManager.calculateEmpServiceYears(selectedEmployeeId);
                            if (serviceYear >= 1) {
                                //txtAvilablDayes.setValue(leave_Manager.subtractAnualTakeHour(txtEmployeeID.getValue().toString()));
                                btnSave.setDisabled(false);
                            //   txtAvilablDayes.setValue(leaveManager.availableAnnualLeaveDays(txtEmployeeID.getValue().toString(), isExpiredDateAllowed));
                            } else {
                                showSuccessOrFailureMessage(false, "You must work one year to get this leave type. Please select another leave type?");
                                btnSave.setDisabled(true);
                            }
                        } else if (selectedLeaveType.equals("6")) {
                            int usedLeave =0;// leave_Manager.checkAvilbelLeaveDayes(txtEmployeeID.getValue().toString());
                            int remaingDay = 0;
                            if (usedLeave < 270) {
                                remaingDay = 270 - usedLeave;
                                txtAvilablDayes.setValue(remaingDay);
                                btnSave.setDisabled(false);
                            } else {
                                showSuccessOrFailureMessage(false, "he/she finished his/her sick Leave");
                                btnSave.setDisabled(true);
                            }
                        } else {
                            HashMap hm = new HashMap();
                            hm = leaveRequestManager.readParametersOfLeaveType(selectedLeaveType);
                            txtAvilablDayes.setValue(hm.get("max_Num_Of_Days"));
                            btnSave.setDisabled(false);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap readLeaveInfomation() {
        try {
            HashMap hm = new HashMap();
            hm.put("leaveId", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId());
            hm.put("requestDate", getEmployeeLeaveList().get(changeUsedLeaveRow).getStartDate());
            hm.put("employeeId", txtEmployeeID.getValue().toString());
            hm.put("LeaveType", drlLeaveTypeTo.getValue().toString());
            hm.put("leaveDay", txtLeaveDays.getValue().toString());
            hm.put("startDate", txtStartDate.getValue().toString());
            hm.put("endDate", txtEndDate.getValue().toString());
            hm.put("reason", txtRemark.getValue().toString());
            return hm;
        } catch (Exception e) {
            return null;
        }
    }

    private HashMap readFirstLeaveInfomation() {
        try {
            HashMap hm = new HashMap();
            hm.put("leaveId", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId());
            hm.put("requestDate", getEmployeeLeaveList().get(changeUsedLeaveRow).getStartDate());
            hm.put("employeeId", txtEmployeeID.getValue().toString());
            hm.put("LeaveType", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveTypeId());
            int oldLeaveDayes = Integer.parseInt(getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveDay());
            int leaveDayes = Integer.parseInt(txtLeaveDays.getValue().toString());
            leaveDayes = oldLeaveDayes - leaveDayes;
            hm.put("leaveDay", Integer.toString(leaveDayes));
            String startDate = StringDateManipulation.nextDayInEC(txtEndDate.getValue().toString());
            String endDate =null;// leaveManager.calculateLeaveEnddate(startDate, Integer.toString(leaveDayes));
            hm.put("startDate", startDate);
            hm.put("endDate", endDate);
            hm.put("reason", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveRequestResone());
            return hm;
        } catch (Exception e) {
            return null;
        }
    }

    private HashMap readAnualLeaveInfomation() {
        try {
            HashMap hm = new HashMap();
            hm.put("leaveId", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId());
            hm.put("requestDate", getEmployeeLeaveList().get(changeUsedLeaveRow).getStartDate());
            hm.put("employeeId", txtEmployeeID.getValue().toString());
            hm.put("LeaveType", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveTypeId());
            int oldLeaveDayes = Integer.parseInt(getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveDay());
            int leaveDayes = Integer.parseInt(txtLeaveDays.getValue().toString());
            leaveDayes = oldLeaveDayes - leaveDayes;
            hm.put("leaveDay", Integer.toString(leaveDayes));
            String startDate = StringDateManipulation.nextDayInEC(txtEndDate.getValue().toString());
            String endDate = null;//leaveManager.calculatLeaveDate(startDate, Integer.toString(leaveDayes));
            hm.put("startDate", startDate);
            hm.put("endDate", endDate);
            hm.put("reason", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveRequestResone());
            return hm;
        } catch (Exception e) {
            return null;
        }
    }

    private HashMap readSecondLeaveInfomation() {
        try {
            HashMap hm = new HashMap();
            hm.put("leaveId", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId());
            hm.put("requestDate", getEmployeeLeaveList().get(changeUsedLeaveRow).getStartDate());
            hm.put("employeeId", txtEmployeeID.getValue().toString());
            hm.put("LeaveType", drlLeaveTypeTo.getValue().toString());
            hm.put("leaveDay", txtLeaveDays.getValue().toString());
            hm.put("startDate", txtStartDate.getValue().toString());
            hm.put("endDate", txtEndDate.getValue().toString());
            hm.put("reason", txtRemark.getValue().toString());
            return hm;
        } catch (Exception e) {
            return null;
        }
    }

    public HashMap selectFisicalYearForHour(String requestedDate, String leaveId) {

        boolean first = true;
        boolean firstTime = false;
        HashMap readPhsicalYear = new HashMap();
        readPhsicalYear.clear();
        int phsicalYear = 0;
        int physicalYearBYHour = 0;
        int takenHouer = 0;
        int totalLeavesDaysTakenByHour = 0;
        int totalLeavesDaysTaken = 0;
        int calculationHour = 0;
        int yearOfAllowed = 0;
        int alowedYear = 0;
        int diffrenceBntToday = 0;
        int diffrence = 0;
        txtLeaveDays.getValue().toString();
        String hireDate = DateConverter.fromGCToEC(employeeManager.readHireDate(
                txtEmployeeID.getValue().toString()));
        int year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
        ArrayList<HashMap> leavesTakenList =null;// leave_Manager.selectAnnualLeavesTaken(
            //    txtEmployeeID.getValue().toString(), leaveId);
        ArrayList<HashMap> hourTakenList =null;// leave_Manager.selectAnnualLeavesTakenByHour(
                //txtEmployeeID.getValue().toString(), leaveId);
        for (HashMap hm : leavesTakenList) {
            phsicalYear = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
            totalLeavesDaysTaken += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
        }
        for (HashMap hm : hourTakenList) {
            physicalYearBYHour = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
            totalLeavesDaysTakenByHour += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
        }
        if (physicalYearBYHour == phsicalYear) {

            if (phsicalYear > 0) {
                diffrenceBntToday = year - phsicalYear;
                if (diffrenceBntToday >= 3) {
                    phsicalYear = year - 2;
                    diffrenceBntToday = 3;
                    first = false;
                    firstTime = true;
                } else {
                    diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                    diffrenceBntToday += 1;
                }
            } else {
                phsicalYear = employeeManager.calculateEmpServiceYear(hireDate);
                if (phsicalYear >= 3) {
                    phsicalYear = year - 2;
                    diffrenceBntToday = 3;
                    first = false;
                    firstTime = true;
                } else {
                    first = false;
                    firstTime = false;
                    phsicalYear = year - phsicalYear;
                    diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
                    diffrenceBntToday += 1;
                }

            }
            diffrence = phsicalYear - StringDateManipulation.getYear(hireDate);
            //   diffrence += 1;
            String dataDiffrence = Integer.toString(diffrence);
            String allowedLeve = null;
            int calculate = 0;
            if (diffrence <= 17) {
                for (HashMap hm : annualLeaveManager.allowedLeave()) {
                    allowedLeve = hm.get(dataDiffrence).toString();
                    yearOfAllowed = Integer.parseInt(allowedLeve);
                    break;
                }
            } else {
                yearOfAllowed = 30;
            }
            if (first) {
                calculationHour = totalLeavesDaysTaken % 8;
                takenHouer = totalLeavesDaysTaken / 8;
                calculate = yearOfAllowed - (totalLeavesDaysTaken + takenHouer);
            } else {
                calculate = yearOfAllowed;
            }

            //    alowedYear = calculate - Integer.parseInt(requestedDate);
            alowedYear = calculate - Integer.parseInt(requestedDate);
            int forProduction = -1;
            int requestDayQuantitu = 0;
            if (alowedYear < 0) {
                readPhsicalYear.put(Integer.toString(phsicalYear), calculate);
                // requestDayQuantitu = StringDateManipulation.getYear(requestedDate);
                requestDayQuantitu = Integer.parseInt(requestedDate);
                requestDayQuantitu -= calculate;
                calculate = 0;
                calculate -= requestDayQuantitu;
                if (diffrence > 3) {
                    diffrence = 3;
                }
                year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
                for (int i = 1; i <= diffrenceBntToday; i++) {
                    if (yearOfAllowed < 30) {
                        forProduction = -1;
                        forProduction *= calculate;
                        phsicalYear += 1;
                        yearOfAllowed += 1;
                        if (year < phsicalYear) {
                            break;
                        } else if (calculate == 0) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                            break;
                        } else if (calculate > 0) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                            break;
                        } else if (forProduction < yearOfAllowed) {
                            readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                            break;
                        } else {
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                        }
                        calculate += yearOfAllowed;
                    } else {
                        if (firstTime) {
                            calculate = 0;
                            calculate -= requestDayQuantitu;
                            firstTime = false;
                        }
                        if (calculate <= 0) {
                            forProduction = -1;
                            phsicalYear += 1;
                            forProduction *= calculate;
                            if (year < phsicalYear) {
                                break;
                            } else if (calculate == 0) {
                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                                break;
                            } else if (calculate > 0) {
                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
                                break;
                            } else if (forProduction < yearOfAllowed) {
                                readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
                                break;
                            } else {
                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                            }
                            calculate += yearOfAllowed;
                        } else {
                            calculate -= yearOfAllowed;
                            phsicalYear += 1;
                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
                            break;
                        }
                    }
                }
            } else {
                readPhsicalYear.put(Integer.toString(phsicalYear), Integer.parseInt(requestedDate));
            }
            return readPhsicalYear;

        } else if (physicalYearBYHour < phsicalYear) {

            return null;
        } else {

            return null;
        }
//
//        if (phsicalYear > 0) {
//            //gone
//        } else {
//            phsicalYear = employeeManager.calculateEmpServiceYears(selectedId);
//
////            }
//        }
//
//        return readPhsicalYear;
    }
//
//        public HashMap selectFisicalYearForHour(String requestedDate, String leaveId) {
//        boolean first = true;
//        boolean firstTime = false;
//        HashMap readPhsicalYear = new HashMap();
//        readPhsicalYear.clear();
//        int phsicalYear = 0;
//        int physicalYearBYHour = 0;
//        int takenHouer = 0;
//        int totalLeavesDaysTakenByHour = 0;
//        int totalLeavesDaysTaken = 0;
//        int calculationHour = 0;
//        int yearOfAllowed = 0;
//        int alowedYear = 0;
//        int diffrenceBntToday = 0;
//        int diffrence = 0;
//        String hireDate = DateConverter.fromGCToEC(employeeManager.readHireDate(
//                txtEmployeeID.getValue().toString()));
//        int year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
//        ArrayList<HashMap> leavesTakenList = leave_Manager.selectAnnualLeavesTaken(
//                txtEmployeeID.getValue().toString(), leaveId);
//        ArrayList<HashMap> hourTakenList = leave_Manager.selectAnnualLeavesTakenByHour(
//                txtEmployeeID.getValue().toString(), leaveId);
//        for (HashMap hm : leavesTakenList) {
//            phsicalYear = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
//            totalLeavesDaysTaken += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
//        }
//        for (HashMap hm : hourTakenList) {
//            physicalYearBYHour = Integer.parseInt(hm.get("PHYSICAL_YEAR").toString());
//            totalLeavesDaysTakenByHour += Integer.parseInt(hm.get("LEAVE_DAYS").toString());
//        }
//        if (physicalYearBYHour == phsicalYear) {
//
//            if (phsicalYear > 0) {
//                diffrenceBntToday = year - phsicalYear;
//                if (diffrenceBntToday >= 3) {
//                    phsicalYear = year - 2;
//                    diffrenceBntToday = 3;
//                    first = false;
//                    firstTime = true;
//                } else {
//                    diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
//                    diffrenceBntToday += 1;
//                }
//            } else {
//                phsicalYear = employeeManager.calculateEmpServiceYear(hireDate);
//                if (phsicalYear >= 3) {
//                    phsicalYear = year - 2;
//                    diffrenceBntToday = 3;
//                    first = false;
//                    firstTime = true;
//                } else {
//                    first = false;
//                    firstTime = false;
//                    phsicalYear = year - phsicalYear;
//                    diffrenceBntToday = phsicalYear - StringDateManipulation.getYear(hireDate);
//                    diffrenceBntToday += 1;
//                }
//
//            }
//            diffrence = phsicalYear - StringDateManipulation.getYear(hireDate);
//            // diffrence += 1;
//            String dataDiffrence = Integer.toString(diffrence);
//            String allowedLeve = null;
//            int calculate = 0;
//            if (diffrence <= 17) {
//                for (HashMap hm : leaveManager.allowedLeave()) {
//                    allowedLeve = hm.get(dataDiffrence).toString();
//                    yearOfAllowed = Integer.parseInt(allowedLeve);
//                    break;
//                }
//            } else {
//                yearOfAllowed = 30;
//            }
//            if (first) {
//                calculationHour = totalLeavesDaysTaken % 8;
//                takenHouer = totalLeavesDaysTaken / 8;
//                calculate = yearOfAllowed - (totalLeavesDaysTaken + takenHouer);
//            } else {
//                calculate = yearOfAllowed;
//            }
//            alowedYear = calculate - Integer.parseInt(txtLeaveDays.getValue().toString());
//            int forProduction = -1;
//            int requestDayQuantitu = 0;
//            if (alowedYear < 0) {
//                readPhsicalYear.put(Integer.toString(phsicalYear), calculate);
//                requestDayQuantitu = Integer.parseInt(txtLeaveDays.getValue().toString());
//                requestDayQuantitu -= calculate;
//                calculate = 0;
//                calculate -= requestDayQuantitu;
//                if (diffrence > 3) {
//                    diffrence = 3;
//                }
//                year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
//                for (int i = 1; i <= diffrenceBntToday; i++) {
//                    if (yearOfAllowed < 30) {
//                        forProduction = -1;
//                        forProduction *= calculate;
//                        phsicalYear += 1;
//                        yearOfAllowed += 1;
//                        if (year < phsicalYear) {
//                            break;
//                        } else if (calculate == 0) {
//                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
//                            break;
//                        } else if (calculate > 0) {
//                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
//                            break;
//                        } else if (forProduction < yearOfAllowed) {
//                            readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
//                            break;
//                        } else {
//                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
//                        }
//                        calculate += yearOfAllowed;
//                    } else {
//                        if (firstTime) {
//                            calculate = 0;
//                            calculate -= requestDayQuantitu;
//                            firstTime = false;
//                        }
//                        if (calculate <= 0) {
//                            forProduction = -1;
//                            phsicalYear += 1;
//                            forProduction *= calculate;
//                            if (year < phsicalYear) {
//                                break;
//                            } else if (calculate == 0) {
//                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
//                                break;
//                            } else if (calculate > 0) {
//                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed - calculate);
//                                break;
//                            } else if (forProduction < yearOfAllowed) {
//                                readPhsicalYear.put(Integer.toString(phsicalYear), forProduction);
//                                break;
//                            } else {
//                                readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
//                            }
//                            calculate += yearOfAllowed;
//                        } else {
//                            calculate -= yearOfAllowed;
//                            phsicalYear += 1;
//                            readPhsicalYear.put(Integer.toString(phsicalYear), yearOfAllowed);
//                            break;
//                        }
//                    }
//                }
//            } else {
//                readPhsicalYear.put(Integer.toString(phsicalYear), Integer.parseInt(txtLeaveDays.getValue().toString()));
//            }
//            return readPhsicalYear;
//
//        } else if (physicalYearBYHour < phsicalYear) {
//
//            return null;
//        } else {
//
//            return null;
//        }
//    }

    public String btnSave_action() {
        try {
            int avilebelDay = 0;
            int diffrence = StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),
                    txtEndDate.getValue().toString());
            int length = txtAvilablDayes.getValue().toString().indexOf("d");
            String avilableDayes = null;
            if (length > 0) {
                avilebelDay = Integer.parseInt(txtAvilablDayes.getValue().toString().substring(0,
                        txtAvilablDayes.getValue().toString().indexOf(" ")));
            } else {
                avilebelDay = Integer.parseInt(txtAvilablDayes.getValue().toString());
            }
            if (avilebelDay >= diffrence) {
                if (Integer.parseInt(txtLeaveDays.getValue().toString()) ==
                        Integer.parseInt(getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveDay())) {

                    if (!drlLeaveTypeTo.getValue().toString().equals("1")) {
                        if (leaveSettlementManager.chengeLeaveType(readLeaveInfomation())) {
                            showSuccessOrFailureMessage(true, "Employee Leave type " +
                                    " information  successfully changed!!");
                            drlLeaveTypeFrom.resetValue();
                            drlLeaveTypeTo.resetValue();
                            txtStartDate.resetValue();
                            txtEndDate.resetValue();
                            txtRemark.resetValue();
                            txtLeaveDays.resetValue();
                            txtAvilablDayes.resetValue();
                            drlLeaveTypeFrom.setValue(null);
                            drlLeaveTypeTo.setValue("");
                            txtStartDate.setValue("");
                            txtEndDate.setValue("");
                            txtRemark.setValue("");
                            txtAvilablDayes.setValue("");
                            txtLeaveDays.setDisabled(true);
                            drlLeaveTypeTo.setDisabled(true);
                            txtStartDate.setDisabled(true);
                            txtEndDate.setDisabled(true);
                            txtRemark.setDisabled(true);
                            txtLeaveDays.setDisabled(true);
                            txtAvilablDayes.setDisabled(true);
                            btnSave.setDisabled(true);
                            btnReset.setDisabled(false);
                            btnEmplyeeSearch_action();
                        } else {
                            showSuccessOrFailureMessage(false, "Employee Leave " +
                                    " type information not changed. Please try again ?");
                        }
                    } else {
                        //AnualLeaveSave
                        HashMap hm = new HashMap();
                        hm.put("leaveId", getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId());
                        hm.put("requestDate", getEmployeeLeaveList().get(changeUsedLeaveRow).getStartDate());
                        hm.put("employeeId", txtEmployeeID.getValue().toString());
                        LeaveSettlementManager saveLeaveSettlementManager = new LeaveSettlementManager(readLeaveInfomation(),
                                selectFisicalYearForHour(txtLeaveDays.getValue().toString(),
                                getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId()));
                        if (leaveSettlementManager.chengeLeaveType(saveLeaveSettlementManager)) {
                            showSuccessOrFailureMessage(true, "Employee Leave type information  successfully changed!!");
                            drlLeaveTypeFrom.resetValue();
                            drlLeaveTypeTo.resetValue();
                            txtStartDate.resetValue();
                            txtEndDate.resetValue();
                            txtRemark.resetValue();
                            txtLeaveDays.resetValue();
                            txtAvilablDayes.resetValue();
                            drlLeaveTypeFrom.setValue(null);
                            drlLeaveTypeTo.setValue("");
                            txtStartDate.setValue("");
                            txtEndDate.setValue("");
                            txtRemark.setValue("");
                            txtAvilablDayes.setValue("");
                            txtLeaveDays.setDisabled(true);
                            drlLeaveTypeTo.setDisabled(true);
                            txtStartDate.setDisabled(true);
                            txtEndDate.setDisabled(true);
                            txtRemark.setDisabled(true);
                            txtLeaveDays.setDisabled(true);
                            txtAvilablDayes.setDisabled(true);
                            btnEmplyeeSearch_action();
                            btnSave.setDisabled(true);
                            btnNew.setDisabled(true);
                            btnReset.setDisabled(false);
                        } else {
                            showSuccessOrFailureMessage(false, " Employee Leave" +
                                    " type information not changed. Please try again ?");
                        }
                    }
                } else {
                    if (!getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveTypeId().equals("1")) {
                        if (!drlLeaveTypeTo.getValue().equals("1")) {
                            if (leaveSettlementManager.changeUsedLeaveType(readFirstLeaveInfomation(), readSecondLeaveInfomation())) {
                                showSuccessOrFailureMessage(true, "Employee Leave type " +
                                        " information  successfully changed!!");
                                drlLeaveTypeFrom.resetValue();
                                drlLeaveTypeTo.resetValue();
                                txtStartDate.resetValue();
                                txtEndDate.resetValue();
                                txtRemark.resetValue();
                                txtLeaveDays.resetValue();
                                txtAvilablDayes.resetValue();
                                drlLeaveTypeFrom.setValue(null);
                                drlLeaveTypeTo.setValue("");
                                txtStartDate.setValue("");
                                txtEndDate.setValue("");
                                txtRemark.setValue("");
                                txtAvilablDayes.setValue("");
                                txtLeaveDays.setDisabled(true);
                                drlLeaveTypeTo.setDisabled(true);
                                txtStartDate.setDisabled(true);
                                txtEndDate.setDisabled(true);
                                txtRemark.setDisabled(true);
                                txtLeaveDays.setDisabled(true);
                                txtAvilablDayes.setDisabled(true);
                                btnSave.setDisabled(true);
                                btnNew.setDisabled(true);
                                btnReset.setDisabled(false);
                                btnEmplyeeSearch_action();
                            } else {
                                showSuccessOrFailureMessage(false, " Employee Leave" +
                                        " type information not changed. Please try again ?");
                            }
                        } else {
                            ///Anuale Leave
                            LeaveSettlementManager saveLeave = new LeaveSettlementManager(
                                    readFirstLeaveInfomation(),
                                    readSecondLeaveInfomation(),
                                    selectFisicalYearForHour(txtLeaveDays.getValue().toString(),
                                    getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId()));
                            if (leaveSettlementManager.changeUsedLeaveType(saveLeave)) {
                                showSuccessOrFailureMessage(true, "Employee Leave type " +
                                        " information  successfully changed!!");
                                drlLeaveTypeFrom.resetValue();
                                drlLeaveTypeTo.resetValue();
                                txtStartDate.resetValue();
                                txtEndDate.resetValue();
                                txtRemark.resetValue();
                                txtLeaveDays.resetValue();
                                txtAvilablDayes.resetValue();
                                drlLeaveTypeFrom.setValue(null);
                                drlLeaveTypeTo.setValue("");
                                txtStartDate.setValue("");
                                txtEndDate.setValue("");
                                txtRemark.setValue("");
                                txtAvilablDayes.setValue("");
                                txtLeaveDays.setDisabled(true);
                                drlLeaveTypeTo.setDisabled(true);
                                txtStartDate.setDisabled(true);
                                txtEndDate.setDisabled(true);
                                txtRemark.setDisabled(true);
                                txtLeaveDays.setDisabled(true);
                                txtAvilablDayes.setDisabled(true);
                                btnSave.setDisabled(true);
                                btnNew.setDisabled(true);
                                btnReset.setDisabled(false);
                                btnEmplyeeSearch_action();
                            } else {
                                showSuccessOrFailureMessage(false, " Employee Leave" +
                                        " type information not changed. Please try again ?");
                            }

                        }
                    } else {
                        ///Anuale Leave
                        int oldLeaveDayes = Integer.parseInt(getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveDay());
                        int leaveDayes = Integer.parseInt(txtLeaveDays.getValue().toString());
                        leaveDayes = oldLeaveDayes - leaveDayes;
                        LeaveSettlementManager saveLeave = new LeaveSettlementManager(readSecondLeaveInfomation(),
                                readAnualLeaveInfomation(),
                                selectFisicalYearForHour(Integer.toString(leaveDayes),
                                getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveId()));
                        if (leaveSettlementManager.changeUsedLeaveType(saveLeave)) {
                            showSuccessOrFailureMessage(true, "Employee Leave type " +
                                    " information  successfully changed!!");
                            drlLeaveTypeFrom.resetValue();
                            drlLeaveTypeTo.resetValue();
                            txtStartDate.resetValue();
                            txtEndDate.resetValue();
                            txtRemark.resetValue();
                            txtLeaveDays.resetValue();
                            txtAvilablDayes.resetValue();
                            drlLeaveTypeFrom.setValue(null);
                            drlLeaveTypeTo.setValue("");
                            txtStartDate.setValue("");
                            txtEndDate.setValue("");
                            txtRemark.setValue("");
                            txtAvilablDayes.setValue("");
                            txtLeaveDays.setDisabled(true);
                            drlLeaveTypeTo.setDisabled(true);
                            txtStartDate.setDisabled(true);
                            txtEndDate.setDisabled(true);
                            txtRemark.setDisabled(true);
                            txtLeaveDays.setDisabled(true);
                            txtAvilablDayes.setDisabled(true);
                            btnEmplyeeSearch_action();
                        } else {
                            showSuccessOrFailureMessage(false, " Employee Leave" +
                                    " type information not changed. Please try again ?");
                        }
                    }
                }
            } else {
                showSuccessOrFailureMessage(false, "The two date difference is larger than the available leave day ." +
                        "Please reduce leave day?");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showSuccessOrFailureMessage(false, "Employee Leave type information not changed. Please try again ?");
        }



        //return null means stay on the same page
        return null;
    }

    public void rwSelectorCommitteMember_processMyEvent(RowSelectorEvent rse) {
        try {
            int row = tblCommitteeMamber.getRowIndex();
//
//            if (row > -1) {
//                clearInfoTextComponets();
//                committeeMemberID = getEmployeeLeaveList().get(row).getCommitteeMemberID();
//
//
//
//
//
//                drlLeaveTypeFrom.setValue(getEmployeeLeaveList().get(row).getCommitte_ID());
//                drlLeaveTypeTo.setValue(getEmployeeLeaveList().get(row).getCommitteStatus());
//                txtStartDate.setValue(getEmployeeLeaveList().get(row).getAssignedDate());
//                txtEndDate.setValue(getEmployeeLeaveList().get(row).getReponsibility());
//                txtRemark.setValue(getEmployeeLeaveList().get(row).getCommitteDescription());
//                txtEmployeeID.setValue(getEmployeeLeaveList().get(row).getEmpID());

//                if (employeeManager.loadEmpoyeeProfile(getEmployeeLeaveList().get(row).getEmpID().trim()) == 1) {
//
//                    String sex = null;
//                    lblFull_Name.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " +
//                            "" + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
//                    sex = employeeManager.getSex();
//                    if (sex.equalsIgnoreCase("Male")) {
//                        choMale.setSelected(true);
//                        choFemale.setSelected(false);
//                    } else if (sex.equalsIgnoreCase("Female")) {
//                        choFemale.setSelected(true);
//                        choMale.setSelected(false);
//                    } else {
//                        choMale.setSelected(false);
//                        choFemale.setSelected(false);
//                    }
//
//
//                    int expYear = employeeManager.calculateEmpServiceYears(txtEmployeeID.getValue().toString());
//                    lblServiceYear.setValue(String.valueOf(expYear));
//                    OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
//                    setEmployeePicture(blo.getBytes(0, (int) blo.length()));
//                    imgEmployeePicture.setValue(getEmployeePicture());
//
//                    lblDepartment.setValue(employeeManager.employeeDepartmentTraced(employeeManager));
//                    this.lblPosition.setValue(employeeManager.getJobDescription());
//                }
//
//                enableInfoTextComponets();
//
//
//                btnSave.setDisabled(true);
//                btnNew.setDisabled(true);
//                btnReset.setDisabled(false);
//            //  enableInfoTextComponets();
//
//            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
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

    public String btnCalenderDateFrom_action() {
        //return null means stay on the same page
        return null;
    }

    public void txtStartDate_processValueChange(ValueChangeEvent vce) {
    }

    public void drlLeaveTypeFrom_processValueChange(ValueChangeEvent vce) {
    }

    public void drlLeaveTypeTo_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                txtAvilablDayes.setValue(" ");
                if (!drlLeaveTypeFrom.getValue().equals(vce.getNewValue().toString())) {
                    displayAvailableDays(txtEmployeeID.getValue().toString(), vce.getNewValue().toString());
                } else {
                    showSuccessOrFailureMessage(false, "Not allowed to change into the same leave type." +
                            " Please select other type of leave type ?");

                }
            }
        }

    }

    public void choMale_processValueChange(ValueChangeEvent vce) {
    }

    public void rwSelectorLeaveType_processMyEvent(RowSelectorEvent rse) {
        try {
            changeUsedLeaveRow = rse.getRow();
            if (changeUsedLeaveRow > -1) {
                drlLeaveTypeFrom.resetValue();
                drlLeaveTypeTo.resetValue();
                txtStartDate.resetValue();
                txtEndDate.resetValue();
                txtRemark.resetValue();
                txtLeaveDays.resetValue();
                drlLeaveTypeFrom.setValue(getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveTypeId());
                txtStartDate.setValue(getEmployeeLeaveList().get(changeUsedLeaveRow).getStartDate());
                txtEndDate.setValue(getEmployeeLeaveList().get(changeUsedLeaveRow).getEndDate());
                txtLeaveDays.setValue(getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveDay());
                txtRemark.setValue(getEmployeeLeaveList().get(changeUsedLeaveRow).getLeaveRequestResone());
                drlLeaveTypeFrom.setDisabled(true);
                drlLeaveTypeTo.setDisabled(false);
                txtStartDate.setDisabled(false);
                txtEndDate.setDisabled(false);
                txtRemark.setDisabled(false);
                txtLeaveDays.setDisabled(false);
                drlLeaveTypeTo.setValue(null);
                btnSave.setDisabled(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void disableComponet() {
        drlLeaveTypeFrom.setDisabled(true);
        drlLeaveTypeTo.setDisabled(true);
        txtRemark.setDisabled(true);
        txtEndDate.setDisabled(true);
        txtStartDate.setDisabled(true);
        btnCalenderDateFrom.setDisabled(true);
        txtAvilablDayes.setDisabled(true);
        txtLeaveDays.setDisabled(true);
    }

    public String button1_action() {


        if (txtAvilablDayes.getValue() == null || txtAvilablDayes.getValue().toString().equalsIgnoreCase("")) {
            showSuccessOrFailureMessage(false, "First select the leave type ");
        } else if (txtStartDate.getValue() == null || txtStartDate.getValue().toString().equalsIgnoreCase("")) {
            showSuccessOrFailureMessage(false, "Enter start date of leave ");
        } else if (txtLeaveDays.getValue() == null || txtLeaveDays.getValue().toString().equalsIgnoreCase("")) {
            showSuccessOrFailureMessage(false, "Enter the number of days to be taken");
            txtEndDate.setValue("");
        } else {//process calculating
            try {
                int requestedLeaveAmount = Integer.parseInt(txtLeaveDays.getValue().toString());
                int index = txtAvilablDayes.getValue().toString().indexOf(" ");
                int lengthOfString = txtAvilablDayes.getValue().toString().length();
                int length = txtAvilablDayes.getValue().toString().indexOf("d");
                String avilableDayes = null;
                if (length > 0) {
                    avilableDayes = txtAvilablDayes.getValue().toString().substring(0,
                            txtAvilablDayes.getValue().toString().indexOf(" "));
                } else {
                    avilableDayes = txtAvilablDayes.getValue().toString();
                }
                if (requestedLeaveAmount <= Integer.parseInt(avilableDayes)) {
//                        String endDate = leaveMnger.calculateLeaveToDate(txtDateFrom.getValue().toString(), txtLeaveDays.getValue().toString());
                    if (drlLeaveTypeTo.getValue().equals("1")) {
                      //  txtEndDate.setValue(leaveMnger.calculatLeaveDate(txtStartDate.getValue().toString(), txtLeaveDays.getValue().toString()));
                    } else {
                       // txtEndDate.setValue(leaveMnger.calculateLeaveEnddate(txtStartDate.getValue().toString(), txtLeaveDays.getValue().toString()));
                    }

                } else {
                    showSuccessOrFailureMessage(Boolean.FALSE, "Too large number.Please less number leave");
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                showSuccessOrFailureMessage(false, "you inserted Invalid Number Or<br> Available Leave Day value displays  <b>N/A</b> <br> correct your inpurt or <br>contact your database adminstrator<br>" + ex.getMessage());
            }
        }



        //return null means stay on the same page
        return null;
    }

    void employeeInformation(String employeeId) {
        HashMap list = null;//leave_Manager.readEmployeeLeaveWithProfile(employeeId);
        if (list != null) {
            txtLeaveSettleDescription.setDisabled(false);
            txtEmployeeIDentification.setValue(employeeId);
            lblFullName.setValue(list.get("fullName").toString());
            lblEmployeeDepartment.setValue(list.get("dep_description").toString());
            lblJobPosition1.setValue(list.get("job_description").toString());
            lblLeaveType.setValue(list.get("job_description").toString());
            leaveDays.setValue(list.get("leave_days").toString());
            lblReason.setValue(list.get("requesting_reason").toString());
            leaveType = list.get("leave_type").toString();
            lblStartDate.setValue(list.get("requested_from_date").toString());
            lblEndDateLevel.setValue(list.get("requested_to_date").toString());
            startDate = list.get("requested_from_date").toString();
            endDate = list.get("requested_to_date").toString();
            leaveDay = list.get("leave_days").toString();
            leaveId = list.get("leave_id").toString();
            requestDate = list.get("requested_date").toString();
            if (list.get("job_description").toString().equals("Female")) {
                choMaleSe.setSelected(false);
                choFemale.setSelected(true);
            } else {
                choMaleSe.setSelected(true);
                choFemale.setSelected(false);
            }
            btnSettleSave.setDisabled(false);
        }
    }

    public String btnSearchEmployeeLeave_action() {
        employeeInformation(txtEmployeeIDentification.getValue().toString());
        txtEmployeeID.setValue(txtEmployeeIDentification.getValue().toString());
        //return null means stay on the same page
        return null;
    }

    public String btnCalender_action() {
        //return null means stay on the same page
        return null;
    }

    public void drlEmployeeID_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            employeeInformation(vce.getNewValue().toString());
        }

    }

    private HashMap leaveRequestInformation() {
        try {
            String employeeId = null;
            String leave_Type = null;
            String fiscalYear = null;
            String fromDate = null;
            String toDate = null;
            String leaveDays = null;
            String reason = null;
            String requestedLeaveType = null;
            String currentDate = StringDateManipulation.toDayInEc();
            int kindLeave = 1;
            if (txtEmployeeIDentification.getValue() != null) {
                employeeId = txtEmployeeIDentification.getValue().toString().trim();
            }
            if (leaveType != null) {
                leave_Type = leaveType;
            }
            if (txtReturnDate.getValue() != null) {
                toDate = jodanTimeCalender.ChangeDateToEthiopic(txtReturnDate.getValue().toString());
//                        DateConverter.fromGCToEC(txtReturnDate.getValue().toString())
            }
//        if (this.txtDateFrom.getValue() != null) {
//            fromDate = this.txtDateFrom.getValue().toString();
//        }
//        if (this.txtDateTo.getValue() != null) {
//            toDate = this.txtDateTo.getValue().toString();
//        }
//        if (this.txtLeaveDays.getValue() != null) {
//            leaveDays = this.txtLeaveDays.getValue().toString();
//        }
//
            if (txtLeaveSettleDescription.getValue() != null) {
                reason = txtLeaveSettleDescription.getValue().toString();
            }

            HashMap requestInfo = new HashMap();
            requestInfo.put("employeeId", employeeId);
            requestInfo.put("leaveType", leaveType);
            requestInfo.put("startDate", startDate);
            requestInfo.put("endDate", toDate);
            requestInfo.put("reason", reason);
            requestInfo.put("leaveId", leaveId);
            requestInfo.put("requestDate", requestDate);
            requestInfo.put("leaveDay", Integer.toString(getCalculateAnualLeaveDay(
                    lblStartDate.getValue().toString(), toDate)));

            requestInfo.put("LeaveType", leave_Type);
            return requestInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    int getCalculateAnualLeaveDay(String startDate, String endDate) {
        try {
            LeaveSettlementManager leav = new LeaveSettlementManager();
            return leav.calculatAnualLeaveDate(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public String btnSettleSave_action() {
        //  leaveRequestInformation();

        LeaveSettlementManager settle = new LeaveSettlementManager(
                leaveRequestInformation(),
                selectFisicalYearForHour(lblStartDate.getValue().toString(),
                leaveId));// selectFisicalYear(2)));
        if (leaveSettlementManager.settlementLeaveInformation(settle)) {
            showSuccessOrFailureMessage(true, "Leave information settled successfully!");
        } else {
            showSuccessOrFailureMessage(false, "Leave information not settled " +
                    "successfully.Please try again ?");
            txtReturnDate.setDisabled(true);
            txtLeaveSettleDescription.setDisabled(true);
        }
        //return null means stay on the same page
        return null;
    }

    public void panelTabSet1_processTabChange(TabChangeEvent tce) {
    }

   
}