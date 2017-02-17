/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Attendance;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.attendanceManager.AttendanceManager;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.userManagement.SiteSecurityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Attendance_Page extends AbstractPageBean {
    //<editor-fold  desc="init(), prerender()..">
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    private int transactionState;
    private String searchValue1 = null;
    private String searchValue2 = null;
    ResourceBundle messageResource = null;
    FacesContext context = null;
    Set<HashMap> readEmp = new HashSet<HashMap>();//creating an object form collection class;
    AttendanceManager attendanceManager = new AttendanceManager();
    String[] commonEmployees = new String[0];
    Set<HashMap> commonEmployeesInsert = new HashSet<HashMap>();
    Set<HashMap> commonEmployeesUpdate = new HashSet<HashMap>();
    Set<HashMap> commonEmployeesDelete = new HashSet<HashMap>();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        ckbByName.setDisabled(true);
        ckbByName.setSelected(true);
        drlAttendanceState.setValue("S");
        //stateLists = attendanceManager.StateTypes();
//        dateTimeConverter1.setDateStyle("short");
//        dateTimeConverter1.setPattern("yyyy-mm-dd");

    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }
    private HtmlOutputText lblEmployeeIdAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeIdAutoComplete() {
        return lblEmployeeIdAutoComplete;
    }

    public void setLblEmployeeIdAutoComplete(HtmlOutputText lblEmployeeIdAutoComplete) {
        this.lblEmployeeIdAutoComplete = lblEmployeeIdAutoComplete;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlInputText txtfAbsentDate = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDate() {
        return txtfAbsentDate;
    }

    public void setTxtfAbsentDate(HtmlInputText hit) {
        this.txtfAbsentDate = hit;
    }
    private HtmlOutputLabel txtfAttendanceTakenDate = new HtmlOutputLabel();

    public HtmlOutputLabel getTxtfAttendanceTakenDate() {
        return txtfAttendanceTakenDate;
    }

    public void setTxtfAttendanceTakenDate(HtmlOutputLabel hol) {
        this.txtfAttendanceTakenDate = hol;
    }
    private HtmlOutputLabel stxtDate = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtDate() {
        return stxtDate;
    }

    public void setStxtDate(HtmlOutputLabel hol) {
        this.stxtDate = hol;
    }
    private HtmlInputText stxtJobPosition = new HtmlInputText();

    public HtmlInputText getStxtJobPosition() {
        return stxtJobPosition;
    }

    public void setStxtJobPosition(HtmlInputText hit) {
        this.stxtJobPosition = hit;
    }
    private HtmlInputText txtfReporterName = new HtmlInputText();

    public HtmlInputText getTxtfReporterName() {
        return txtfReporterName;
    }

    public void setTxtfReporterName(HtmlInputText hit) {
        this.txtfReporterName = hit;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
    }
    private HtmlInputText stxtDept = new HtmlInputText();

    public HtmlInputText getStxtDept() {
        return stxtDept;
    }

    public void setStxtDept(HtmlInputText hit) {
        this.stxtDept = hit;
    }
    private HtmlInputText stxtTitle = new HtmlInputText();

    public HtmlInputText getStxtTitle() {
        return stxtTitle;
    }

    public void setStxtTitle(HtmlInputText hit) {
        this.stxtTitle = hit;
    }
    private HtmlCommandButton btnListEmployees = new HtmlCommandButton();

    public HtmlCommandButton getBtnListEmployees() {
        return btnListEmployees;
    }

    public void setBtnListEmployees(HtmlCommandButton hcb) {
        this.btnListEmployees = hcb;
    }
    private HtmlDataTable tblAbsentee = new HtmlDataTable();

    public HtmlDataTable getTblAbsentee() {
        return tblAbsentee;
    }

    public void setTblAbsentee(HtmlDataTable hdt) {
        this.tblAbsentee = hdt;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu1BeanLis = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1BeanLis() {
        return selectOneMenu1BeanLis;
    }

    public void setSelectOneMenu1BeanLis(DefaultSelectedData dsd) {
        this.selectOneMenu1BeanLis = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbByIdentification = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbByIdentification() {
        return ckbByIdentification;
    }

    public void setCkbByIdentification(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbByIdentification = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbByName = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbByName() {
        return ckbByName;
    }

    public void setCkbByName(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbByName = hsbc;
    }
    private HtmlSelectOneMenu drlEmpList = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEmpList() {
        return drlEmpList;
    }

    public void setDrlEmpList(HtmlSelectOneMenu hsom) {
        this.drlEmpList = hsom;
    }
    private HtmlSelectOneMenu drlAttendanceState = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAttendanceState() {
        return drlAttendanceState;
    }

    public void setDrlAttendanceState(HtmlSelectOneMenu hsom) {
        this.drlAttendanceState = hsom;
    }
    private HtmlInputText stxtEmpFirstName = new HtmlInputText();

    public HtmlInputText getStxtEmpFirstName() {
        return stxtEmpFirstName;
    }

    public void setStxtEmpFirstName(HtmlInputText hit) {
        this.stxtEmpFirstName = hit;
    }
    private HtmlInputText stxtEmpMiddleName = new HtmlInputText();

    public HtmlInputText getStxtEmpMiddleName() {
        return stxtEmpMiddleName;
    }

    public void setStxtEmpMiddleName(HtmlInputText hit) {
        this.stxtEmpMiddleName = hit;
    }
    private HtmlInputText stxtEmpLastName = new HtmlInputText();

    public HtmlInputText getStxtEmpLastName() {
        return stxtEmpLastName;
    }

    public void setStxtEmpLastName(HtmlInputText hit) {
        this.stxtEmpLastName = hit;
    }
    private HtmlCommandButton btnAddAbsenteesPOP = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddAbsenteesPOP() {
        return btnAddAbsenteesPOP;
    }

    public void setBtnAddAbsenteesPOP(HtmlCommandButton hcb) {
        this.btnAddAbsenteesPOP = hcb;
    }
    private PanelPopup pnlpopupAbsentee = new PanelPopup();

    public PanelPopup getPnlpopupAbsentee() {
        return pnlpopupAbsentee;
    }

    public void setPnlpopupAbsentee(PanelPopup pp) {
        this.pnlpopupAbsentee = pp;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandLink linkNotify = new HtmlCommandLink();

    public HtmlCommandLink getLinkNotify() {
        return linkNotify;
    }

    public void setLinkNotify(HtmlCommandLink hcl) {
        this.linkNotify = hcl;
    }
    private HtmlCommandButton btnSearchAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchAttendance() {
        return btnSearchAttendance;
    }

    public void setBtnSearchAttendance(HtmlCommandButton hcb) {
        this.btnSearchAttendance = hcb;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkBoxApprove = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkBoxApprove() {
        return chkBoxApprove;
    }

    public void setChkBoxApprove(HtmlSelectBooleanCheckbox hsbc) {
        this.chkBoxApprove = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkBoxCertify = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkBoxCertify() {
        return chkBoxCertify;
    }

    public void setChkBoxCertify(HtmlSelectBooleanCheckbox hsbc) {
        this.chkBoxCertify = hsbc;
    }
    private HtmlOutputLabel stxtAppTitle = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtAppTitle() {
        return stxtAppTitle;
    }

    public void setStxtAppTitle(HtmlOutputLabel hol) {
        this.stxtAppTitle = hol;
    }
    private HtmlOutputLabel stxtAppFullName = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtAppFullName() {
        return stxtAppFullName;
    }

    public void setStxtAppFullName(HtmlOutputLabel hol) {
        this.stxtAppFullName = hol;
    }
    private HtmlOutputLabel stxtAppDept = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtAppDept() {
        return stxtAppDept;
    }

    public void setStxtAppDept(HtmlOutputLabel hol) {
        this.stxtAppDept = hol;
    }
    private HtmlOutputLabel stxtAppJobPosition = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtAppJobPosition() {
        return stxtAppJobPosition;
    }

    public void setStxtAppJobPosition(HtmlOutputLabel hol) {
        this.stxtAppJobPosition = hol;
    }
    private HtmlOutputLabel stxtCertTitle = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtCertTitle() {
        return stxtCertTitle;
    }

    public void setStxtCertTitle(HtmlOutputLabel hol) {
        this.stxtCertTitle = hol;
    }
    private HtmlOutputLabel stxtCertFullName = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtCertFullName() {
        return stxtCertFullName;
    }

    public void setStxtCertFullName(HtmlOutputLabel hol) {
        this.stxtCertFullName = hol;
    }
    private HtmlOutputLabel stxtCertDept = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtCertDept() {
        return stxtCertDept;
    }

    public void setStxtCertDept(HtmlOutputLabel hol) {
        this.stxtCertDept = hol;
    }
    private HtmlOutputLabel stxtCertJobPosition = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtCertJobPosition() {
        return stxtCertJobPosition;
    }

    public void setStxtCertJobPosition(HtmlOutputLabel hol) {
        this.stxtCertJobPosition = hol;
    }
    private HtmlOutputLabel stxtCertDate = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtCertDate() {
        return stxtCertDate;
    }

    public void setStxtCertDate(HtmlOutputLabel hol) {
        this.stxtCertDate = hol;
    }
    private HtmlOutputLabel stxtAppDate = new HtmlOutputLabel();

    public HtmlOutputLabel getStxtAppDate() {
        return stxtAppDate;
    }

    public void setStxtAppDate(HtmlOutputLabel hol) {
        this.stxtAppDate = hol;
    }
    private HtmlOutputLabel drlReportedByEmployeeID = new HtmlOutputLabel();

    public HtmlOutputLabel getDrlReportedByEmployeeID() {
        return drlReportedByEmployeeID;
    }

    public void setDrlReportedByEmployeeID(HtmlOutputLabel hol) {
        this.drlReportedByEmployeeID = hol;
    }
    private HtmlOutputLabel htxtfAppEmpId = new HtmlOutputLabel();

    public HtmlOutputLabel getHtxtfAppEmpId() {
        return htxtfAppEmpId;
    }

    public void setHtxtfAppEmpId(HtmlOutputLabel hol) {
        this.htxtfAppEmpId = hol;
    }
    private HtmlOutputLabel htxtfCertEmpId = new HtmlOutputLabel();

    public HtmlOutputLabel getHtxtfCertEmpId() {
        return htxtfCertEmpId;
    }

    public void setHtxtfCertEmpId(HtmlOutputLabel hol) {
        this.htxtfCertEmpId = hol;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private HtmlCommandButton btnTakeAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnTakeAttendance() {
        return btnTakeAttendance;
    }

    public void setBtnTakeAttendance(HtmlCommandButton hcb) {
        this.btnTakeAttendance = hcb;
    }
    private HtmlCommandButton btnCancelAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelAttendance() {
        return btnCancelAttendance;
    }

    public void setBtnCancelAttendance(HtmlCommandButton hcb) {
        this.btnCancelAttendance = hcb;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private HtmlSelectOneMenu ddlDepartmentLists = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdlDepartmentLists() {
        return ddlDepartmentLists;
    }

    public void setDdlDepartmentLists(HtmlSelectOneMenu hsom) {
        this.ddlDepartmentLists = hsom;
    }
    private RowSelector rowSelectorAbsentee = new RowSelector();

    public RowSelector getRowSelectorAbsentee() {
        return rowSelectorAbsentee;
    }

    public void setRowSelectorAbsentee(RowSelector rs) {
        this.rowSelectorAbsentee = rs;
    }
    private HtmlCommandButton btnEditAbsentee = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditAbsentee() {
        return btnEditAbsentee;
    }

    public void setBtnEditAbsentee(HtmlCommandButton hcb) {
        this.btnEditAbsentee = hcb;
    }
    private HtmlCommandButton btnUpdateAbsenteesPOP = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateAbsenteesPOP() {
        return btnUpdateAbsenteesPOP;
    }

    public void setBtnUpdateAbsenteesPOP(HtmlCommandButton hcb) {
        this.btnUpdateAbsenteesPOP = hcb;
    }
    private HtmlOutputLabel lblAbsenteePopUpMsg = new HtmlOutputLabel();

    public HtmlOutputLabel getLblAbsenteePopUpMsg() {
        return lblAbsenteePopUpMsg;
    }

    public void setLblAbsenteePopUpMsg(HtmlOutputLabel hol) {
        this.lblAbsenteePopUpMsg = hol;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneListbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox2Bean() {
        return selectOneListbox2Bean;
    }

    public void setSelectOneListbox2Bean(DefaultSelectedData dsd) {
        this.selectOneListbox2Bean = dsd;
    }
    private DefaultSelectionItems selectOneListbox2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox2DefaultItems() {
        return selectOneListbox2DefaultItems;
    }

    public void setSelectOneListbox2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox2DefaultItems = dsi;
    }
    private HtmlSelectOneListbox lstAttendanceReport = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstAttendanceReport() {
        return lstAttendanceReport;
    }

    public void setLstAttendanceReport(HtmlSelectOneListbox hsol) {
        this.lstAttendanceReport = hsol;
    }
    private HtmlSelectOneListbox listApprovedAttendance = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListApprovedAttendance() {
        return listApprovedAttendance;
    }

    public void setListApprovedAttendance(HtmlSelectOneListbox hsol) {
        this.listApprovedAttendance = hsol;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu ddlDepartmentListsSearch = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdlDepartmentListsSearch() {
        return ddlDepartmentListsSearch;
    }

    public void setDdlDepartmentListsSearch(HtmlSelectOneMenu hsom) {
        this.ddlDepartmentListsSearch = hsom;
    }
    private HtmlInputText txtfAbsentDateSearch = new HtmlInputText();

    public HtmlInputText getTxtfAbsentDateSearch() {
        return txtfAbsentDateSearch;
    }

    public void setTxtfAbsentDateSearch(HtmlInputText hit) {
        this.txtfAbsentDateSearch = hit;
    }
    private HtmlPanelGroup RetirementApproval = new HtmlPanelGroup();

    public HtmlPanelGroup getRetirementApproval() {
        return RetirementApproval;
    }

    public void setRetirementApproval(HtmlPanelGroup hpg) {
        this.RetirementApproval = hpg;
    }
    private PanelLayout pnMessage = new PanelLayout();

    public PanelLayout getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelLayout pnMessage) {
        this.pnMessage = pnMessage;
    }
    private PanelLayout pnMessage2 = new PanelLayout();

    public PanelLayout getPnMessage2() {
        return pnMessage2;
    }

    public void setPnMessage2(PanelLayout pnMessage2) {
        this.pnMessage2 = pnMessage2;
    }
    private PanelLayout pnProfile = new PanelLayout();

    public PanelLayout getPnProfile() {
        return pnProfile;
    }

    public void setPnProfile(PanelLayout pl) {
        this.pnProfile = pl;
    }
    private HtmlCommandButton btnCalDateAttendace = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalDateAttendace() {
        return btnCalDateAttendace;
    }

    public void setBtnCalDateAttendace(HtmlCommandButton hcb) {
        this.btnCalDateAttendace = hcb;
    }
    private HtmlCommandButton btnApproveAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnApproveAttendance() {
        return btnApproveAttendance;
    }

    public void setBtnApproveAttendance(HtmlCommandButton hcb) {
        this.btnApproveAttendance = hcb;
    }
    private HtmlCommandButton btnCertifyAttendance = new HtmlCommandButton();

    public HtmlCommandButton getBtnCertifyAttendance() {
        return btnCertifyAttendance;
    }

    public void setBtnCertifyAttendance(HtmlCommandButton hcb) {
        this.btnCertifyAttendance = hcb;
    }
    private HtmlOutputText lblAttendanceIdDB = new HtmlOutputText();

    public HtmlOutputText getLblAttendanceIdDB() {
        return lblAttendanceIdDB;
    }

    public void setLblAttendanceIdDB(HtmlOutputText hot) {
        this.lblAttendanceIdDB = hot;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }

    public Set<HashMap> getReadEmp() {
        return readEmp;
    }

    public void setReadEmp(Set<HashMap> readEmp) {
        this.readEmp = readEmp;
    }
    private HtmlSelectBooleanCheckbox chkSelectEmployee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkSelectEmployee() {
        return chkSelectEmployee;
    }

    public void setChkSelectEmployee(HtmlSelectBooleanCheckbox hsbc) {
        this.chkSelectEmployee = hsbc;
    }
    private HtmlSelectOneMenu lstAttendanceState = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstAttendanceState() {
        return lstAttendanceState;
    }

    public void setLstAttendanceState(HtmlSelectOneMenu hsom) {
        this.lstAttendanceState = hsom;
    }
    private HtmlSelectBooleanCheckbox chkReport = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkReport() {
        return chkReport;
    }

    public void setChkReport(HtmlSelectBooleanCheckbox hsbc) {
        this.chkReport = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkCancel = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkCancel() {
        return chkCancel;
    }

    public void setChkCancel(HtmlSelectBooleanCheckbox hsbc) {
        this.chkCancel = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkMeasureTaken = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMeasureTaken() {
        return chkMeasureTaken;
    }

    public void setChkMeasureTaken(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMeasureTaken = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkMeasureRevoked = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMeasureRevoked() {
        return chkMeasureRevoked;
    }

    public void setChkMeasureRevoked(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMeasureRevoked = hsbc;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calAttendanceTakenDate = new SelectInputDate();

    public SelectInputDate getCalAttendanceTakenDate() {
        return calAttendanceTakenDate;
    }

    public void setCalAttendanceTakenDate(SelectInputDate sid) {
        this.calAttendanceTakenDate = sid;
    }
    private HtmlCommandButton btnCalDateAttendaceSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalDateAttendaceSearch() {
        return btnCalDateAttendaceSearch;
    }

    public void setBtnCalDateAttendaceSearch(HtmlCommandButton hcb) {
        this.btnCalDateAttendaceSearch = hcb;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calSearchDate = new SelectInputDate();

    public SelectInputDate getCalSearchDate() {
        return calSearchDate;
    }

    public void setCalSearchDate(SelectInputDate sid) {
        this.calSearchDate = sid;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Attendance_Page() {
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
            log("Page2 Initialization Failure", e);
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
//        htxtfAppEmpId.setValue(getSessionBean1().getEmployeeId());
//        htxtfCertEmpId.setValue(getSessionBean1().getEmployeeId());
//        drlReportedByEmployeeID.setValue(getSessionBean1().getEmployeeId());
//        messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());// get the resource bundle message
//        txtfAbsentDate.setRequiredMessage(messageResource.getString("requiredMsg"));// set the resource bundle variable
//        txtfAbsentDate.setRequiredMessage(messageResource.getString("requiredMsg"));// set the resource bundle variable
//        ddlDepartmentLists.setRequired(true);
//        ddlDepartmentLists.setRequiredMessage(messageResource.getString("requiredMsg"));
//        txtfAbsentDate.setConverterMessage(messageResource.getString("dateFormat"));// set the resource bundle variable
//        stxtDate.setValue(StringDateManipulation.toDayInEc());
//        HashMap hashMap = new HashMap();
//        SiteSecurityManager security = new SiteSecurityManager();
//        if (security.canView(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//
//            hashMap.put("v", "VIEW");
//            this.displayPageForView();
//        }
//        if (security.canRequest(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            hashMap.put("r", "REQUEST");
//
//            this.displaypageForRequest();
//        }
//        if (security.canPrepare(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            hashMap.put("p", "PREPARE");
//            this.displayPageForPrepare();
//        }
//        if (security.canDelete(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            hashMap.put("d", "DELETE");
//            this.displayPageForDelete();
//        }
//        if (security.canApprove(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            hashMap.put("a", "APPROVE");
//            this.displayPageForApproval();
//        }
//        if (security.canCertify(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            hashMap.put("c", "CERTIFY");
//            this.displayPageForCerify();
//        }
//        getPagePermissions().add(hashMap);
//        HashMap per = null;
    //securityManager.getPermission(getSessionBean1().getRequestedPage().toString(), getSessionBean1().getUserName().toString())
//        if (getPagePermissions().size() != 0) {
//            for (int i = 0; i < getPagePermissions().size(); i++) {
//                per = getPagePermissions().get(i);
//            }
//            lblPermissionList.setValue("You have been given the following permission to this page : " + per.values());
//        } else {
//            lblPermissionList.setValue("You have been given the following permission to this page : NONE");
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    //</editor-fold>
    SiteSecurityManager securityManager = new SiteSecurityManager();
    EmployeeManage employeeManage = new EmployeeManage();
    DepartmentManage departmentManage = new DepartmentManage();
    int selectedAbsenteeRow = -1;
    private Option[] dayliyAttendanceProcessed = null;
    ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<SelectItem> getZerf() {
        zerf = departmentManage.getDepartmentName();
        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }

    public Option[] getDayliyAttendanceProcessed() {
        dayliyAttendanceProcessed = attendanceManager.loadAttendanceDayliyProcessed();
        return dayliyAttendanceProcessed;
    }

    public void setDayliyAttendanceProcessed(Option[] dayliyAttendanceProcessed) {
        this.dayliyAttendanceProcessed = dayliyAttendanceProcessed;
    }
    private Option[] dayliyAttendanceIssuesed = null;

    public Option[] getDayliyAttendanceIssuesed() {
        dayliyAttendanceIssuesed = attendanceManager.loadAttendanceDayliyRequests();
        return dayliyAttendanceIssuesed;
    }

    public void setDayliyAttendanceIssuesed(Option[] dayliyAttendanceIssuesed) {
        this.dayliyAttendanceIssuesed = dayliyAttendanceIssuesed;
    }
    private ArrayList<SelectItem> departmentLists = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getDepartmentLists() {
        departmentLists = departmentManage.getDepartmentName();
        return departmentLists;
    }

    public void setDepartmentLists(ArrayList<SelectItem> departmentLists) {
        this.departmentLists = departmentLists;
    }
    private ArrayList<HashMap> attendanceLists = new ArrayList<HashMap>();

    public ArrayList<HashMap> getAttendanceLists() {
        return attendanceLists;
    }

    public void setAttendanceLists(ArrayList<HashMap> attendanceLists) {
        this.attendanceLists = attendanceLists;
    }
    private ArrayList<HashMap> pagePermissions = new ArrayList<HashMap>();

    public ArrayList<HashMap> getPagePermissions() {
        return pagePermissions;
    }

    public void setPagePermissions(ArrayList<HashMap> pagePermissions) {
        this.pagePermissions = pagePermissions;
    }
    ArrayList<AbsenteesModelUpdate> attendanceAbsenteesUpdate = new ArrayList<AbsenteesModelUpdate>();

    public ArrayList<AbsenteesModelUpdate> getAttendanceAbsenteesUpdate() {
        return attendanceAbsenteesUpdate;
    }

    public void setAttendanceAbsenteesUpdate(ArrayList<AbsenteesModelUpdate> attendanceAbsenteesUpdate) {
        this.attendanceAbsenteesUpdate = attendanceAbsenteesUpdate;
    }
    Set<AbsenteesModelLoad> attendanceAbsenteesLoad = new HashSet<AbsenteesModelLoad>();
    Set<AbsenteesModelLoad> attendanceAbUpdate = new HashSet<AbsenteesModelLoad>();

    public Set<AbsenteesModelLoad> getAttendanceAbUpdate() {
        return attendanceAbUpdate;
    }

    public void setAttendanceAbUpdate(Set<AbsenteesModelLoad> attendanceAbUpdate) {
        this.attendanceAbUpdate = attendanceAbUpdate;
    }

    public Set<AbsenteesModelLoad> getAttendanceAbsenteesLoad() {
        return attendanceAbsenteesLoad;
    }

    public void setAttendanceAbsenteesLoad(Set<AbsenteesModelLoad> attendanceAbsenteesLoad) {
        this.attendanceAbsenteesLoad = attendanceAbsenteesLoad;
    }
    Set<AbsenteesModelNew> attendanceAbsentees = new HashSet<AbsenteesModelNew>();

    public Set<AbsenteesModelNew> getAttendanceAbsentees() {
        return attendanceAbsentees;
    }

    public void setAttendanceAbsentees(Set<AbsenteesModelNew> attendanceAbsentees) {
        this.attendanceAbsentees = attendanceAbsentees;
    }

    public Set<HashMap> getCommonEmployeesDelete() {
        return commonEmployeesDelete;
    }

    public void setCommonEmployeesDelete(Set<HashMap> commonEmployeesDelete) {
        this.commonEmployeesDelete = commonEmployeesDelete;
    }

    public Set<HashMap> getCommonEmployeesUpdate() {
        return commonEmployeesUpdate;
    }

    public void setCommonEmployeesUpdate(Set<HashMap> commonEmployeesUpdate) {
        this.commonEmployeesUpdate = commonEmployeesUpdate;
    }

    public Set<HashMap> getCommonEmployeesInsert() {
        return commonEmployeesInsert;
    }

    public void setCommonEmployeesInsert(Set<HashMap> commonEmployeesUpdate) {
        this.commonEmployeesInsert = commonEmployeesUpdate;
    }

    public String[] getCommonEmployees() {
        return commonEmployees;
    }

    public void setCommonEmployees(String[] commonEmployees) {
        this.commonEmployees = commonEmployees;
    }

//inner class for new entry
    public static class AbsenteesModelNew implements Serializable {

        private int type;
        private String empId;
        private String statusName;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public AbsenteesModelNew() {
        }

        public AbsenteesModelNew(int type, String empId, String statusName) {
            this.type = type;
            this.empId = empId;
            this.statusName = statusName;
        }
    }
//inner class for dataloading

    public static class AbsenteesModelLoad implements Serializable {

        private String empId;
        private String empFullName;
        private String empTitle;
        private String empPosition;
        private String empRank;
        private boolean selected;
        private boolean report;
        private boolean cancel;
        private boolean mtaken;
        private boolean mrevoked;

        public boolean isCancel() {
            return cancel;
        }

        public void setCancel(boolean cancel) {
            this.cancel = cancel;
        }

        public String getEmpFullName() {
            return empFullName;
        }

        public void setEmpFullName(String empFullName) {
            this.empFullName = empFullName;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public String getEmpPosition() {
            return empPosition;
        }

        public void setEmpPosition(String empPosition) {
            this.empPosition = empPosition;
        }

        public String getEmpRank() {
            return empRank;
        }

        public void setEmpRank(String empRank) {
            this.empRank = empRank;
        }

        public String getEmpTitle() {
            return empTitle;
        }

        public void setEmpTitle(String empTitle) {
            this.empTitle = empTitle;
        }

        public boolean isMrevoked() {
            return mrevoked;
        }

        public void setMrevoked(boolean mrevoked) {
            this.mrevoked = mrevoked;
        }

        public boolean isMtaken() {
            return mtaken;
        }

        public void setMtaken(boolean mtaken) {
            this.mtaken = mtaken;
        }

        public boolean isReport() {
            return report;
        }

        public void setReport(boolean report) {
            this.report = report;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public AbsenteesModelLoad(String empId, String empFullName, String empTitle, String empPosition, String empRank, boolean selected, boolean report, boolean cancel, boolean mtaken, boolean mrevoked) {
            this.empId = empId;
            this.empFullName = empFullName;
            this.empTitle = empTitle;
            this.empPosition = empPosition;
            this.empRank = empRank;
            this.selected = selected;
            this.report = report;
            this.cancel = cancel;
            this.mtaken = mtaken;
            this.mrevoked = mrevoked;
        }
    }
//inner class for updating

    public static class AbsenteesModelUpdate implements Serializable {

        private int type;
        private String empId;
        private String statusName;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public AbsenteesModelUpdate() {
        }

        public AbsenteesModelUpdate(int type, String empId, String statusName) {
            this.type = type;
            this.empId = empId;
            this.statusName = statusName;
        }
    }
    //inner class for deleting

    public static class AbsenteesModelDeleting implements Serializable {

        private int type;
        private String empId;
        private String statusName;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public AbsenteesModelDeleting() {
        }

        public AbsenteesModelDeleting(int type, String empId, String statusName) {
            this.type = type;
            this.empId = empId;
            this.statusName = statusName;
        }
    }

    private void displayPageForPrepare() {
        btnCertifyAttendance.setRendered(false);
        btnApproveAttendance.setRendered(false);
        btnListEmployees.setRendered(true);
        btnDelete.setRendered(true);
        btnTakeAttendance.setRendered(true);
        btnSave.setRendered(true);
        btnEditAbsentee.setRendered(true);
        btnUpdate.setRendered(true);
        btnCancelAttendance.setRendered(true);
    }

    private void displayPageForDelete() {
        btnDelete.setRendered(true);
    }

    private void displayPageForView() {
        btnCertifyAttendance.setRendered(false);
        btnApproveAttendance.setRendered(false);
        btnListEmployees.setRendered(false);
        btnDelete.setRendered(false);
        btnTakeAttendance.setRendered(false);
        btnSave.setRendered(false);
        btnEditAbsentee.setRendered(false);
        btnUpdate.setRendered(false);
        btnCancelAttendance.setRendered(false);
        chkBoxApprove.setRendered(false);
        chkBoxCertify.setRendered(false);

    }

    private void displayPageForApproval() {
        chkBoxApprove.setRendered(true);
        btnApproveAttendance.setRendered(true);
    }

    private void displayPageForCerify() {
        chkBoxCertify.setRendered(true);
        btnCertifyAttendance.setRendered(true);
    }

    private void displaypageForRequest() {
        btnCertifyAttendance.setRendered(false);
        btnApproveAttendance.setRendered(false);
        btnListEmployees.setRendered(true);
        btnDelete.setRendered(false);
        btnTakeAttendance.setRendered(true);
        btnSave.setRendered(true);
        btnEditAbsentee.setRendered(true);
        btnUpdate.setRendered(true);
        btnCancelAttendance.setRendered(true);
    }

    private void clearDisabledANDEnableComponents() {
        txtfAttendanceTakenDate.setValue(null);
        txtfAbsentDate.setValue(null);
        ddlDepartmentLists.setValue("-1");
        txtaDescription.setDisabled(false);
        chkBoxApprove.setDisabled(true);
        chkBoxCertify.setDisabled(true);
        btnApproveAttendance.setDisabled(true);
        btnCertifyAttendance.setDisabled(true);
        chkBoxApprove.setSelected(false);
        chkBoxCertify.setSelected(false);
        txtaDescription.setValue(null);
        txtfReporterName.setValue(null);
        stxtJobPosition.setValue(null);
        stxtDept.setValue(null);
        stxtTitle.setValue(null);
        stxtAppDate.setValue(null);
        stxtAppFullName.setValue(null);
        stxtAppDept.setValue(null);
        stxtAppJobPosition.setValue(null);
        stxtAppTitle.setValue(null);
        stxtCertDate.setValue(null);
        stxtCertFullName.setValue(null);
        stxtCertDept.setValue(null);
        stxtCertJobPosition.setValue(null);
        stxtCertTitle.setValue(null);
    }

    private void searchAttendance(String val1, String val2) {
        getAttendanceAbsenteesLoad().clear();
        clearDisabledANDEnableComponents();
        getAttendanceAbsenteesLoad().clear();
        searchValue1 = val1;
        searchValue2 = val2;
        boolean found = false;
        int rowSelected = 0;
        String reportedBy = "";
        String approvedBy = "";
        String approvedDate = "";
        String certifiedBy = "";
        String certifiedDate = "";
        if (searchValue1 != null && searchValue2 != null) {
            getAttendanceAbsenteesLoad().clear();
            readEmp.clear();
            try {
                HashMap datum = attendanceManager.SearchAttendance(searchValue1, searchValue2);
                if (datum.size() > 0) {
                    found = true;
                    lblAttendanceIdDB.setValue(datum.get("attendaceID"));
                    employeeManage.loadEmpoyeeProfile(datum.get("absenteeRecordedBY").toString());
                    String fullName = employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name();
                    txtfReporterName.setValue(fullName);
                    txtfAttendanceTakenDate.setValue(datum.get("absenteeDate"));
                    txtfAbsentDate.setValue(datum.get("absenteeDate"));
                    ddlDepartmentLists.setValue(datum.get("absenteeForDepartment"));
                    reportedBy = datum.get("absenteeReportedBY").toString();
                    txtaDescription.setValue(datum.get("absenteeDescription"));
                    if (datum.get("absenteeApprovedBy") != null) {
                        approvedBy = datum.get("absenteeApprovedBy").toString();
                        approvedDate = datum.get("absenteeApprovedDate").toString();
                    }
                    if (datum.get("absenteeCertifyBy") != null) {
                        certifiedBy = datum.get("absenteeCertifyBy").toString();
                        certifiedDate = datum.get("absenteeCertifyDate").toString();
                    }
                    //load reported by information
                    if (!reportedBy.equals("")) {
                        employeeManage.loadEmpoyeeProfile(reportedBy);
                        txtfReporterName.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
                        stxtJobPosition.setValue(employeeManage.getJobDescription());
                        stxtDept.setValue(employeeManage.getDepartmentDescription());
                        stxtTitle.setValue(employeeManage.getEmpTitle());

                    }
                    if (!approvedBy.equals("")) {
                        chkBoxApprove.setSelected(true);
                        chkBoxApprove.setDisabled(true);
                        employeeManage.loadEmpoyeeProfile(approvedBy);
                        stxtAppDate.setValue(approvedDate);
                        stxtAppDept.setValue(employeeManage.getDepartmentDescription());
                        stxtAppFullName.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
                        stxtAppJobPosition.setValue(employeeManage.getJobDescription());
                        stxtAppTitle.setValue(employeeManage.getEmpTitle());
                    } else {
                        stxtAppDate.setValue("Not Approved.");
                        stxtAppFullName.setValue(null);
                        stxtAppDept.setValue(null);
                        stxtAppJobPosition.setValue(null);
                        stxtAppTitle.setValue(null);
                        chkBoxApprove.setDisabled(false);
                        btnApproveAttendance.setDisabled(false);
                    }
                    if (!certifiedBy.equals("")) {
                        chkBoxCertify.setSelected(true);
                        chkBoxCertify.setDisabled(true);
                        employeeManage.loadEmpoyeeProfile(certifiedDate);
                        stxtCertDate.setValue(approvedDate);
                        stxtCertDept.setValue(employeeManage.getDepartmentDescription());
                        stxtCertFullName.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
                        stxtCertJobPosition.setValue(employeeManage.getJobDescription());
                        stxtCertTitle.setValue(employeeManage.getEmpTitle());
                    } else {
                        stxtCertDate.setValue("Not Certify.");
                        stxtCertFullName.setValue(null);
                        stxtCertDept.setValue(null);
                        stxtCertJobPosition.setValue(null);
                        stxtCertTitle.setValue(null);
                        chkBoxCertify.setDisabled(false);
                        btnCertifyAttendance.setDisabled(false);
                    }

                    if (found == true) {
                        Set<HashMap> loadCandidateList = null;//attendanceManager.ReadAbsenceEmployee(datum.get("attendaceID").toString());//load training candidate lists.
                        readEmp = attendanceManager.ReadEmployeeFromDepartment(datum.get("absenteeForDepartment").toString());
                        if (getReadEmp() != null) {

                            for (HashMap data : readEmp) {
                                getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(data.get("employeeID").toString(), data.get("employeeFullName").toString(), data.get("employeeTitle").toString(), data.get("employeeRank").toString(), data.get("employeePosition").toString(), false, false, false, false, false));
                            }
                        }
                        if (loadCandidateList.size() > 0) {

                            for (AbsenteesModelLoad tcm : getAttendanceAbsenteesLoad()) {//loop to select the employee selected before from the request history
                                for (HashMap hm : loadCandidateList) {
                                    if (hm.get("empID").toString().equalsIgnoreCase(tcm.empId.toString())) {
                                        rowSelected += 1;
                                        tcm.setSelected(true);// make the selection true if the employee is selected before.
                                        if (hm.get("attStatus").equals("01")) {
                                            tcm.setReport(true);
                                            tcm.setCancel(false);
                                            tcm.setMtaken(false);
                                            tcm.setMrevoked(false);
                                        } else if (hm.get("attStatus").equals("02")) {
                                            tcm.setCancel(true);
                                            tcm.setReport(false);
                                            tcm.setMtaken(false);
                                            tcm.setMrevoked(false);
                                        } else if (hm.get("attStatus").equals("03")) {
                                            tcm.setMtaken(true);
                                            tcm.setCancel(false);
                                            tcm.setReport(false);
                                            tcm.setMrevoked(false);
                                        } else if (hm.get("attStatus").equals("04")) {
                                            tcm.setMrevoked(true);
                                            tcm.setMtaken(false);
                                            tcm.setCancel(false);
                                            tcm.setReport(false);
                                        }
                                    }

                                }
                            }

                        }
                        lblFormMessage.setStyleClass("success");
                        lblFormMessage.setValue("" + rowSelected + " - " + "Employee(s) found for the current attendance information search.");
                        showConformationMsg(pnMessage.getStyleClass().toString());
                        btnUpdate.setDisabled(false);
                        btnEditAbsentee.setDisabled(false);
                    }

                } else {
                    found = false;
                    clearDisabledANDEnableComponents();
                    lblFormMessage.setStyleClass("error");
                    lblFormMessage.setValue("No attendance information found.");
                    showConformationMsg(pnMessage.getStyleClass().toString());
                }


            } catch (Exception ex) {
            }
        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Please provide full search criteria to see the search result.");
            showConformationMsg(pnMessage.getStyleClass().toString());
        }
    }
    public static String searchType = "2";
    private ArrayList<SelectItem> stateLists = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getStateLists() {
        return stateLists;
    }

    public void setStateLists(ArrayList<SelectItem> stateLists) {
        this.stateLists = stateLists;
    }
    private ArrayList<SelectItem> employeeLists = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getEmployeeLists() throws Exception {
        employeeLists = attendanceManager.readEmployeeResultInList(searchType, getSessionBean1().getEmpDeptId());
        return employeeLists;
    }

    public void setEmployeeLists(ArrayList<SelectItem> employeeLists) {
        this.employeeLists = employeeLists;
    }

    /**
     * Builds an <code>ArrayList</code> of type <code>HashMap</code> from the
     * getOtEmployeeList
     * @return an <code>ArrayList</code> of type <code>HashMap</code>
     */
    private Set<HashMap> buildItemList() {
        Set<HashMap> absenteeList = new HashSet<HashMap>();
        if (tblAbsentee.getRowCount() > 0) {
            String state = "01";
            for (AbsenteesModelLoad emp : getAttendanceAbsenteesLoad()) {
                HashMap _list = new HashMap();
                if (emp.isSelected() == true) {
                    if (emp.isReport() == true) {
                        state = "01";
                    } else if (emp.isCancel() == true) {
                        state = "02";
                    } else if (emp.isMtaken() == true) {
                        state = "03";
                    } else if (emp.isMrevoked() == true) {
                        state = "04";
                    }
                    _list.put("empSelected", emp.empId.toString());
                    _list.put("status", state);
                    absenteeList.add(_list);
                }
            }
        }
        return absenteeList;
    }

    /**
     * Builds an <code>ArrayList</code> of type <code>HashMap</code> from the
     * getOtEmployeeList
     * @return an <code>ArrayList</code> of type <code>HashMap</code>
     */
    private ArrayList<HashMap> buildItemList2() {
        ArrayList<HashMap> absenteeList = new ArrayList<HashMap>();
        String state = "R";
        for (int i = 0; i < getAttendanceAbsenteesUpdate().size(); i++) {
            AbsenteesModelUpdate absentee = (AbsenteesModelUpdate) getAttendanceAbsenteesUpdate().get(i);
            HashMap _list = new HashMap();
            _list.put("empId", absentee.getEmpId());
            if (absentee.getStatusName().equals("Reported")) {
                state = "01";
            } else if (absentee.getStatusName().equals("Cancelled")) {
                state = "02";
            } else if (absentee.getStatusName().equals("Measure Taken")) {
                state = "03";
            } else if (absentee.getStatusName().equals("Measure Revoked")) {
                state = "04";
            }
            _list.put("status", state);

            absenteeList.add(_list);
        }
        return absenteeList;
    }

    /**
     * The method is used to determine the content of the interface components and use
     * them to send to the controller.
     * (Note: if no value is specified <code>null</code> will be used as a value.
     * @param saveAttendance determines the operation
     */
    private int saveAttendance(String saveOrUpdateAttendance) {
        String attendanceReportedBy = getSessionBean1().getEmployeeId();
        String attendanceDate = null;
        String attendanceDescription = null;
        String recordedDate = null;
        String recordedBy = null;
        String approvedBy = null;
        String approvedDate = null;
        String certifiedBy = null;
        String certifiedDate = null;
        String stateApprove = "01";//01 only reported, 02 approve
        String stateCertify = "01";//01 only reported, 02 certify
        int trans = 0;
        if (drlReportedByEmployeeID.getValue() != null) {
            attendanceReportedBy = drlReportedByEmployeeID.getValue().toString();
        }
        if (txtfAbsentDate.getValue() != null) {
            attendanceDate = txtfAbsentDate.getValue().toString();
        }
        if (txtaDescription.getValue() != null) {
            attendanceDescription = txtaDescription.getValue().toString();
        }
        if (stxtDate.getValue() != null) {
            recordedDate = stxtDate.getValue().toString();
        }
        recordedBy = getSessionBean1().getEmployeeId();
        if (saveOrUpdateAttendance.equalsIgnoreCase("Save")) {
            try {
                boolean saved = attendanceManager.saveAttendance(buildItemList(), attendanceReportedBy,
                        attendanceDate, attendanceDescription, recordedBy, recordedDate, approvedBy, approvedDate, certifiedBy, certifiedDate, ddlDepartmentLists.getValue().toString(), stateApprove, stateCertify);
                if (saved) {
                    lblFormMessage.setStyleClass("success");
                    lblFormMessage.setValue("The attendance record is successfully saved!");
                    showConformationMsg(pnMessage.getStyleClass().toString());
                    btnSave.setDisabled(true);
                    trans = 1;
                } else {
                    lblFormMessage.setStyleClass("error");
                    lblFormMessage.setValue("The attendance record is not successfully saved!");
                    showConformationMsg(pnMessage.getStyleClass().toString());
                    trans = 0;
                }
            } catch (Exception ex) {
                return trans;
            }
        }
        return trans;
    }

    public void ckbByIdentification_processValueChange(ValueChangeEvent vce) {
        if (ckbByIdentification.isSelected()) {
            ckbByName.setDisabled(false);
            ckbByIdentification.setDisabled(true);
            searchType = "1";
            ckbByName.setSelected(false);
        }
    }

    public void ckbByName_processValueChange(ValueChangeEvent vce) {
        if (ckbByName.isSelected()) {
            ckbByName.setDisabled(true);
            ckbByIdentification.setDisabled(false);
            searchType = "2";
            ckbByIdentification.setSelected(false);
        }
    }

    public void drlEmpList_processValueChange(ValueChangeEvent vce) throws Exception {
        HashMap datas = attendanceManager.ReadEmployee(vce.getNewValue().toString());
        stxtEmpFirstName.setValue(datas.get("fname"));
        stxtEmpMiddleName.setValue(datas.get("mname"));
        stxtEmpLastName.setValue(datas.get("lname"));
    }

    public String modalPnlCloseBtnRequestProcessed_action() {
        //return null means stay on the same page
        pnlpopupAbsentee.setRendered(false);
        return null;
    }

    public String btnAddAbsentee_action() {


        return null;
    }

    public String btnRemove_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkNotify_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public void btnSearchAttendance_processAction(ActionEvent ae) {
    }

    public String btnSearchAttendance_action() {
        searchAttendance(txtfAbsentDateSearch.getValue().toString(), ddlDepartmentListsSearch.getValue().toString());
        return null;
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public String btnSave_action() throws Exception {
        if (this.saveAttendance("Save") == 1) {
            getAttendanceAbsenteesLoad().clear();
            btnListEmployees.setDisabled(true);
            lstAttendanceState.setDisabled(true);
            chkSelectEmployee.setDisabled(true);
            btnSave.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnDelete.setDisabled(true);
            btnEditAbsentee.setDisabled(true);
            btnTakeAttendance.setDisabled(false);
            btnCancelAttendance.setDisabled(true);
            chkBoxApprove.setDisabled(true);
            chkBoxCertify.setDisabled(true);
            chkBoxApprove.setSelected(false);
            chkBoxCertify.setSelected(false);
            txtaDescription.setDisabled(true);
            txtaDescription.setValue(null);
            txtfReporterName.setValue(null);
            stxtJobPosition.setValue(null);
            stxtDept.setValue(null);
            stxtTitle.setValue(null);
            stxtAppDate.setValue(null);
            stxtAppFullName.setValue(null);
            stxtAppDept.setValue(null);
            stxtAppJobPosition.setValue(null);
            stxtAppTitle.setValue(null);
            stxtCertDate.setValue(null);
            stxtCertFullName.setValue(null);
            stxtCertDept.setValue(null);
            stxtCertJobPosition.setValue(null);
            stxtCertTitle.setValue(null);
            ddlDepartmentLists.setDisabled(false);
            txtfAbsentDate.setDisabled(false);
            btnCalDateAttendace.setDisabled(false);
        }
        return null;
    }

    public void btnSave_processAction(ActionEvent ae) {
    }

    public String btnTakeAttendance_action() {
        boolean found = false;
        ArrayList<HashMap> checkAttendance = attendanceManager.loadAttendanceCheck();
        for (int i = 0; i < checkAttendance.size(); i++) {
            HashMap datum = checkAttendance.get(i);
            if (txtfAbsentDate.getValue().toString().equals(datum.get("attendanceDate")) && ddlDepartmentLists.getValue().toString().equals(datum.get("attendanceDepartment"))) {
                found = true;
            }
        }
        if (found) {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Information found for the enter Date and Department.Use the search engine to update the attendance information.");
            showConformationMsg(pnMessage.getStyleClass().toString());
        } else {
            transactionState = 1;
            getAttendanceAbsenteesLoad().clear();
            ddlDepartmentLists.setDisabled(true);
            txtfAbsentDate.setDisabled(true);
            btnCalDateAttendace.setDisabled(true);
            btnListEmployees.setDisabled(false);
            lstAttendanceState.setDisabled(false);
            chkSelectEmployee.setDisabled(false);
            btnSave.setDisabled(false);
            btnEditAbsentee.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnDelete.setDisabled(true);
            btnCancelAttendance.setDisabled(false);
            btnTakeAttendance.setDisabled(true);
            txtaDescription.setDisabled(false);
            chkBoxApprove.setDisabled(false);
            chkBoxCertify.setDisabled(false);
            txtaDescription.setValue(null);
            txtfReporterName.setValue(null);
            stxtJobPosition.setValue(null);
            stxtDept.setValue(null);
            stxtTitle.setValue(null);
            stxtAppDate.setValue(null);
            stxtAppFullName.setValue(null);
            stxtAppDept.setValue(null);
            stxtAppJobPosition.setValue(null);
            stxtAppTitle.setValue(null);
            stxtCertDate.setValue(null);
            stxtCertFullName.setValue(null);
            stxtCertDept.setValue(null);
            stxtCertJobPosition.setValue(null);
            stxtCertTitle.setValue(null);

            employeeManage.loadEmpoyeeProfile(drlReportedByEmployeeID.getValue().toString());
            txtfReporterName.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
            stxtJobPosition.setValue(employeeManage.getJobDescription());
            stxtDept.setValue(employeeManage.getDepartmentDescription());
            stxtTitle.setValue(employeeManage.getEmpTitle());



        }
        return null;
    }

    public String btnCancelAttendance_action() {
        //return null means stay on the same page
        if (transactionState == 1) {
            getAttendanceAbsenteesLoad().clear();
            ddlDepartmentLists.setDisabled(false);
            txtfAbsentDate.setDisabled(false);
            btnCalDateAttendace.setDisabled(false);
            btnListEmployees.setDisabled(true);
            lstAttendanceState.setDisabled(true);
            chkSelectEmployee.setDisabled(true);
            btnSave.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnDelete.setDisabled(true);
            btnEditAbsentee.setDisabled(true);
            btnTakeAttendance.setDisabled(false);
            btnCancelAttendance.setDisabled(true);
            chkBoxApprove.setDisabled(true);
            chkBoxCertify.setDisabled(true);
            chkBoxApprove.setSelected(false);
            chkBoxCertify.setSelected(false);
            txtaDescription.setDisabled(true);
            txtaDescription.setValue(null);
            txtfReporterName.setValue(null);
            stxtJobPosition.setValue(null);
            stxtDept.setValue(null);
            stxtTitle.setValue(null);
            stxtAppDate.setValue(null);
            stxtAppFullName.setValue(null);
            stxtAppDept.setValue(null);
            stxtAppJobPosition.setValue(null);
            stxtAppTitle.setValue(null);
            stxtCertDate.setValue(null);
            stxtCertFullName.setValue(null);
            stxtCertDept.setValue(null);
            stxtCertJobPosition.setValue(null);
            stxtCertTitle.setValue(null);
        } else if (transactionState == 2) {
            ddlDepartmentLists.setDisabled(true);
            txtfAbsentDate.setDisabled(true);
            btnSave.setDisabled(true);
            btnEditAbsentee.setDisabled(false);
            btnUpdate.setDisabled(true);
            btnDelete.setDisabled(false);
            btnCancelAttendance.setDisabled(true);
            btnTakeAttendance.setDisabled(false);
            txtaDescription.setDisabled(true);
            chkSelectEmployee.setDisabled(true);
            chkReport.setDisabled(true);
            chkCancel.setDisabled(true);
            chkMeasureTaken.setDisabled(true);
            chkMeasureRevoked.setDisabled(true);

        }

        return null;
    }

    public void chkBoxApprove_processValueChange(ValueChangeEvent vce) {
        if (chkBoxApprove.isSelected()) {
            employeeManage.loadEmpoyeeProfile(htxtfAppEmpId.getValue().toString());
            stxtAppDate.setValue(StringDateManipulation.toDayInEc());
            stxtAppFullName.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
            stxtAppDept.setValue(employeeManage.getDepartmentDescription());
            stxtAppJobPosition.setValue(employeeManage.getJobDescription());
            stxtAppTitle.setValue(employeeManage.getEmpTitle());
        } else {
            stxtAppDate.setValue(null);
            stxtAppFullName.setValue(null);
            stxtAppDept.setValue(null);
            stxtAppJobPosition.setValue(null);
            stxtAppTitle.setValue(null);
        }

    }

    public String lnkEditAbsentee_action() {

        return null;
    }
    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */

    public void rowSelectorAbsentee_processAction(RowSelectorEvent rse) {
        selectedAbsenteeRow = rse.getRow();

    }

    public String btnEditAbsentee_action() {
        try {
            transactionState = 2;
            ddlDepartmentLists.setDisabled(true);
            txtfAbsentDate.setDisabled(true);
            btnSave.setDisabled(true);
            btnEditAbsentee.setDisabled(true);
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(true);
            btnCancelAttendance.setDisabled(false);
            btnTakeAttendance.setDisabled(true);
            txtaDescription.setDisabled(false);
            chkSelectEmployee.setDisabled(false);
            chkReport.setDisabled(false);
            chkCancel.setDisabled(false);
            chkMeasureTaken.setDisabled(false);
            chkMeasureRevoked.setDisabled(false);
            getReadEmp().clear();
            getAttendanceAbUpdate().clear();
            readEmp = attendanceManager.ReadEmployeeFromDepartment(searchValue2);
            if (getReadEmp() != null) {
                for (HashMap data : readEmp) {
                    getAttendanceAbUpdate().add(new AbsenteesModelLoad(data.get("employeeID").toString(), data.get("employeeFullName").toString(), data.get("employeeTitle").toString(), data.get("employeeRank").toString(), data.get("employeePosition").toString(), false, false, false, false, false));
                }
            }
            int i = 0;
            commonEmployees = new String[getAttendanceAbUpdate().size()];
            for (AbsenteesModelLoad datahere : getAttendanceAbsenteesLoad()) {
                for (AbsenteesModelLoad data : getAttendanceAbUpdate()) {
                    if (datahere.empId.equals(data.empId) && datahere.isSelected() == true) {
                        String dataList = new String(datahere.empId.toString());
                        commonEmployees[i] = dataList;
                        i++;
                    }
                }
            }

        } catch (Exception ex) {
        }
        return null;
    }

    public void drlAttendanceState_processValueChange(ValueChangeEvent vce) {
    }

    public String btnUpdate_action() {
        try {
            getReadEmp().clear();
            readEmp = attendanceManager.ReadEmployeeFromDepartment(searchValue2);
            if (readEmp != null) {
                String stateUpdate = "01";
                String stateNew = "01";
                Set dataList = new HashSet(Arrays.asList(commonEmployees));//load the common candidate list
                for (AbsenteesModelLoad data : getAttendanceAbsenteesLoad()) {
                    if (dataList.contains(data.empId.toString()) && data.isSelected() == true) {//update the common list
                        HashMap update = new HashMap();
                        if (data.isReport() == true) {
                            stateUpdate = "01";
                        } else if (data.isCancel() == true) {
                            stateUpdate = "02";
                        } else if (data.isMtaken() == true) {
                            stateUpdate = "03";
                        } else if (data.isMrevoked() == true) {
                            stateUpdate = "04";
                        }
                        update.put("commonEmployeeUpdate", data.empId.toString());
                        update.put("status", stateUpdate);
                        commonEmployeesUpdate.add(update);
                    }
                }
                for (AbsenteesModelLoad datahere : getAttendanceAbsenteesLoad()) {
                    if (!dataList.contains(datahere.empId.toString()) && datahere.isSelected() == true) {//check if there is new added to the common list
                        HashMap insert = new HashMap();
                        if (datahere.isReport() == true) {
                            stateNew = "01";
                        } else if (datahere.isCancel() == true) {
                            stateNew = "02";
                        } else if (datahere.isMtaken() == true) {
                            stateNew = "03";
                        } else if (datahere.isMrevoked() == true) {
                            stateNew = "04";
                        }
                        insert.put("commonEmployeeInsert", datahere.empId.toString());
                        insert.put("status", stateNew);
                        commonEmployeesInsert.add(insert);//add if there is new candidate to the candiate list for update
                    } else if (dataList.contains(datahere.empId.toString()) && datahere.isSelected() == false) {//check unchecked candidate from the common list
                        HashMap delete = new HashMap();
                        delete.put("commonEmployeeDelete", datahere.empId.toString());
                        commonEmployeesDelete.add(delete);//delete from the common candidate list also ro delete from candidate list from the database
                    }
                }
            }
            boolean saved = false;//attendanceManager.updateAttendance(commonEmployeesUpdate, commonEmployeesInsert, commonEmployeesDelete, lblAttendanceIdDB.getValue().toString(), txtaDescription.getValue().toString());
            if (saved) {
                commonEmployeesDelete.clear();
                commonEmployeesInsert.clear();
                commonEmployeesUpdate.clear();
                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("The attendance information is successfully updated!");
                showConformationMsg(pnMessage.getStyleClass().toString());
                ddlDepartmentLists.setDisabled(true);
                txtfAbsentDate.setDisabled(true);
                btnSave.setDisabled(true);
                btnEditAbsentee.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnDelete.setDisabled(false);
                btnCancelAttendance.setDisabled(true);
                btnTakeAttendance.setDisabled(false);
                txtaDescription.setDisabled(true);
                chkSelectEmployee.setDisabled(true);
                chkReport.setDisabled(true);
                chkCancel.setDisabled(true);
                chkMeasureTaken.setDisabled(true);
                chkMeasureRevoked.setDisabled(true);
            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("The attendance information is not updated!");
                showConformationMsg(pnMessage.getStyleClass().toString());
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public void status_Group_processMyEvent(DragEvent de) {
    }

    /**
     *
     * @param val-the name of the style sheeet of the panel lay out.
     */
    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    /**
     *
     * @param val-the name of the style sheeet of the panel lay out.
     */
    private void showConformationMsgForPopUps(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    public void ddlDepartmentListsSearch_processValueChange(ValueChangeEvent vce) {
    }

    public String btnApproveAttendance_action() throws Exception {
        //return null means stay on the same page
        String approvedBy = null;
        String approvedDate = null;
        String stateApprove = "01";//01 only reported, 02 approve
        //for approval and certify
        if (chkBoxApprove.isSelected()) {
            stateApprove = "02";
        }

        if (htxtfAppEmpId.getValue() != null && stateApprove.equals("02")) {
            approvedBy = htxtfAppEmpId.getValue().toString();
        }

        if (stxtAppDate.getValue() != null && stateApprove.equals("02")) {
            approvedDate = stxtAppDate.getValue().toString();
        }

        if (chkBoxApprove.isSelected()) {
            if (attendanceManager.approveAttendance(lblAttendanceIdDB.getValue().toString(), approvedBy, approvedDate, stateApprove) == true) {
                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("The attendance information is successfully approved.");
                showConformationMsg(pnMessage.getStyleClass().toString());
                btnApproveAttendance.setDisabled(true);
            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("The attendance information is not approved.");
                showConformationMsg(pnMessage.getStyleClass().toString());
            }

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Please check the approve check box before continue approving.");
            showConformationMsg(pnMessage.getStyleClass().toString());
            btnApproveAttendance.setDisabled(true);
        }

        return null;
    }

    public String btnCertifyAttendance_action() throws Exception {
        //return null means stay on the same page
        String certifiedBy = null;
        String certifiedDate = null;

        String stateCertify = "01";//01 only reported, 02 certify

        if (chkBoxCertify.isSelected()) {
            stateCertify = "02";
        }

        if (htxtfCertEmpId.getValue() != null && stateCertify.equals("02")) {
            certifiedBy = htxtfCertEmpId.getValue().toString();
        }

        if (stxtCertDate.getValue() != null && stateCertify.equals("02")) {
            certifiedDate = stxtCertDate.getValue().toString();
        }

        if (chkBoxApprove.isSelected()) {
            if (attendanceManager.certifyAttendance(lblAttendanceIdDB.getValue().toString(), certifiedBy, certifiedDate, stateCertify) == true) {
                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("The attendance information is successfully certified.");
                showConformationMsg(pnMessage.getStyleClass().toString());
                btnCertifyAttendance.setDisabled(true);
            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("The attendance information is not certified.");
                showConformationMsg(pnMessage.getStyleClass().toString());
            }

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Please check the approve check box before continue certifying.");
            showConformationMsg(pnMessage.getStyleClass().toString());
            btnCertifyAttendance.setDisabled(true);
        }

        return null;
    }

    public String btnUpdateAbsenteesPOP_action() {
        //return null means stay on the same page
//        try {
//
//            if (attendanceManager.UpdateAbsentee(drlEmpList.getValue().toString(), drlAttendanceState.getValue().toString()) == true) {
//                lblAbsenteePopUpMsg.setStyleClass("success1");
//                lblAbsenteePopUpMsg.setValue("Absentee information is successfully  updated");
//                showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                if (searchValue1 != null && searchValue1 != null) {
//                    String state = "";
//                    getAttendanceAbsenteesLoad().clear();
//                    attendanceLists = attendanceManager.SearchAttendance(searchValue1, searchValue2);
//                    for (int i = 0; i < getAttendanceLists().size(); i++) {
//                        HashMap datum = getAttendanceLists().get(i);
//                        String stateDB = datum.get("absenteeState").toString();
//                        if (stateDB.equals("01")) {
//                            state = "Reported";
//                        } else if (stateDB.equals("02")) {
//                            state = "Cancelled";
//                        } else if (stateDB.equals("03")) {
//                            state = "Measure Taken";
//                        } else if (stateDB.equals("04")) {
//                            state = "Measure Revoked";
//                        }
//                        employeeManage.loadEmpoyeeProfile(datum.get("absenteeEmpID").toString());
//                        String fullName = employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name();
//                        this.getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(datum.get("absenteeEmpID").toString(), fullName, state));
//                    }
//                }
//            } else {
//                lblAbsenteePopUpMsg.setStyleClass("error1");
//                lblAbsenteePopUpMsg.setValue("Error occured while updating absentee information");
//                showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//            }
//        } catch (Exception ex) {
//        }
        return null;
    }

    public String btnAddAbsenteesPOP_action() {
//        //return null means stay on the same page
//
//        String statusName = null;
//        if (!this.drlAttendanceState.getValue().equals("0")) {
//            if (this.drlAttendanceState.getValue().equals("01")) {
//                statusName = "Reported";
//            } else if (this.drlAttendanceState.getValue().equals("02")) {
//                statusName = "Cancelled";
//            } else if (this.drlAttendanceState.getValue().equals("03")) {
//                statusName = "Measure Taken";
//            } else if (this.drlAttendanceState.getValue().equals("04")) {
//                statusName = "Measure Revoked";
//            }
//        }
//        if (transactionState == 1) {//for new record
//            boolean newRecord = true;
//            if (this.drlEmpList.getValue() != null) {
//                if (getAttendanceAbsentees().isEmpty()) {
//                    this.getAttendanceAbsentees().add(new AbsenteesModelNew(0, this.getDrlEmpList().getValue().toString(), statusName));
//                    employeeManage.loadEmpoyeeProfile(drlEmpList.getValue().toString());
//                    String fullName = employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name();
//                    this.getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(this.getDrlEmpList().getValue().toString(), fullName, statusName));
//                    lblAbsenteePopUpMsg.setStyleClass("success1");
//                    lblAbsenteePopUpMsg.setValue("Absentee information is successfully  added");
//                    showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                    this.drlEmpList.setValue(null);
//                    this.drlAttendanceState.setValue(null);
//                    this.stxtEmpFirstName.setValue(null);
//                    this.stxtEmpMiddleName.setValue(null);
//                    this.stxtEmpLastName.setValue(null);
//                    return null;
//                } else {
//                    for (int i = 0; i < getAttendanceAbsentees().size(); i++) {
//                        if (getAttendanceAbsentees().get(i).getEmpId().equals(getDrlEmpList().getValue())) {
//                            newRecord = false;
//                            lblAbsenteePopUpMsg.setStyleClass("error1");
//                            lblAbsenteePopUpMsg.setValue("This employee is aready recorded for the current date absence.");
//                            showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                            this.drlEmpList.setValue(null);
//                            this.drlAttendanceState.setValue(null);
//                            this.stxtEmpFirstName.setValue(null);
//                            this.stxtEmpMiddleName.setValue(null);
//                            this.stxtEmpLastName.setValue(null);
//                            return null;
//                        }
//                    }
//                    if (newRecord) {
//                        this.getAttendanceAbsentees().add(new AbsenteesModelNew(0, this.getDrlEmpList().getValue().toString(), statusName));
//                        employeeManage.loadEmpoyeeProfile(drlEmpList.getValue().toString());
//                        String fullName = employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name();
//                        this.getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(this.getDrlEmpList().getValue().toString(), fullName, statusName));
//                        lblAbsenteePopUpMsg.setStyleClass("success1");
//                        lblAbsenteePopUpMsg.setValue("Absentee information is successfully  added");
//                        showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                    }
//
//                }
//            }
//        } else if (transactionState == 2) {//for update
//            boolean found = true;
//            if (this.drlEmpList.getValue() != null) {
//                if (getAttendanceAbsenteesUpdate().isEmpty()) {
//                    if (tblAbsentee.getRowCount() > 0) {
//                        for (int i = 0; i < tblAbsentee.getRowCount(); i++) {
//                            if (getAttendanceAbsenteesLoad().get(i).getEmpId().equals(getDrlEmpList().getValue())) {
//                                found = false;
//                                lblAbsenteePopUpMsg.setStyleClass("error1");
//                                lblAbsenteePopUpMsg.setValue("This employee is aready recorded for the current date absence.");
//                                showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                                return null;
//                            }
//                        }
//                        if (found) {
//                            this.getAttendanceAbsenteesUpdate().add(new AbsenteesModelUpdate(0, this.getDrlEmpList().getValue().toString(), statusName));
//                            employeeManage.loadEmpoyeeProfile(drlEmpList.getValue().toString());
//                            String fullName = employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name();
//                            this.getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(this.getDrlEmpList().getValue().toString(), fullName, statusName));
//                            lblAbsenteePopUpMsg.setStyleClass("success1");
//                            lblAbsenteePopUpMsg.setValue("Absentee information is successfully  added");
//                            showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                            this.drlEmpList.setValue(null);
//                            this.drlAttendanceState.setValue(null);
//                            this.stxtEmpFirstName.setValue(null);
//                            this.stxtEmpMiddleName.setValue(null);
//                            this.stxtEmpLastName.setValue(null);
//                        }
//
//                    }
//                } else {
//                    for (int i = 0; i < tblAbsentee.getRowCount(); i++) {
//                        for (int j = 0; j < getAttendanceAbsenteesUpdate().size(); j++) {
//                            if (getAttendanceAbsenteesLoad().get(i).getEmpId().equals(getDrlEmpList().getValue()) || getAttendanceAbsenteesUpdate().get(j).getEmpId().equals(getDrlEmpList().getValue())) {
//                                found = false;
//                                lblAbsenteePopUpMsg.setStyleClass("error1");
//                                lblAbsenteePopUpMsg.setValue("This employee is aready recorded for the current date absence.");
//                                showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                                return null;
//                            }
//                        }
//                    }
//                    if (found) {
//                        this.getAttendanceAbsenteesUpdate().add(new AbsenteesModelUpdate(0, this.getDrlEmpList().getValue().toString(), statusName));
//                        employeeManage.loadEmpoyeeProfile(drlEmpList.getValue().toString());
//                        String fullName = employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name();
//                        this.getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(this.getDrlEmpList().getValue().toString(), fullName, statusName));
//                        lblAbsenteePopUpMsg.setStyleClass("success1");
//                        lblAbsenteePopUpMsg.setValue("Absentee information is successfully  added");
//                        showConformationMsgForPopUps(pnMessage2.getStyleClass().toString());
//                        this.drlEmpList.setValue(null);
//                        this.drlAttendanceState.setValue(null);
//                        this.stxtEmpFirstName.setValue(null);
//                        this.stxtEmpMiddleName.setValue(null);
//                        this.stxtEmpLastName.setValue(null);
//                    }
//
//                }
//            } else {
//            }
//        }

        return null;
    }

    public void chkBoxCertify_processValueChange(ValueChangeEvent vce) {
        if (chkBoxCertify.isSelected()) {
            employeeManage.loadEmpoyeeProfile(htxtfCertEmpId.getValue().toString());
            stxtCertDate.setValue(StringDateManipulation.toDayInEc());
            stxtCertFullName.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
            stxtCertDept.setValue(employeeManage.getDepartmentDescription());
            stxtCertJobPosition.setValue(employeeManage.getJobDescription());
            stxtCertTitle.setValue(employeeManage.getEmpTitle());
        } else {
            stxtCertDate.setValue(null);
            stxtCertFullName.setValue(null);
            stxtCertDept.setValue(null);
            stxtCertJobPosition.setValue(null);
            stxtCertTitle.setValue(null);
        }

    }

    public void txtfAbsentDate_processValueChange(ValueChangeEvent vce) {
        txtfAbsentDate.setRequiredMessage("");
    }

    public void lstAttendanceReport_processValueChange(ValueChangeEvent vce) {
        String str[] = vce.getNewValue().toString().split(" -- ");
        searchValue1 = str[0];
        searchValue2 = str[1];
        searchAttendance(searchValue1, searchValue2);
    }

    public void listApprovedAttendance_processValueChange(ValueChangeEvent vce) {
        String str[] = vce.getNewValue().toString().split(" -- ");
        searchValue1 =
                str[0];
        searchValue2 =
                str[1];
        searchAttendance(searchValue1, searchValue2);
    }

    public String btnListEmployees_action() {
        //return null means stay on the same page
        ArrayList<SelectItem> val = new ArrayList<SelectItem>();
        val.add(0, new Option(null, "0"));
        try {
            if (transactionState == 1) {
                if (ddlDepartmentLists.getValue() != null) {
                    readEmp.clear();
                    readEmp = attendanceManager.ReadEmployeeFromDepartment(ddlDepartmentLists.getValue().toString());
                    if (getReadEmp() != null) {
                        getAttendanceAbsenteesLoad().clear();
                        for (HashMap data : readEmp) {
                            getAttendanceAbsenteesLoad().add(new AbsenteesModelLoad(data.get("employeeID").toString(), data.get("employeeFullName").toString(), data.get("employeeTitle").toString(), data.get("employeeRank").toString(), data.get("employeePosition").toString(), false, false, false, false, false));
                        }

                    }
                } else {
                    getAttendanceAbsenteesLoad().clear();
                }

            }
        } catch (Exception ex) {
        }
        return null;
    }

    public void chkReport_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (chkReport.isSelected()) {
                chkCancel.setSelected(false);
                chkMeasureTaken.setSelected(false);
                chkMeasureRevoked.setSelected(false);
            }

        }
    }

    public void chkCancel_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (chkCancel.isSelected()) {
                chkReport.setSelected(false);
                chkMeasureTaken.setSelected(false);
                chkMeasureRevoked.setSelected(false);
            }

        }
    }

    public void chkMeasureTaken_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (chkMeasureTaken.isSelected()) {
                chkReport.setSelected(false);
                chkCancel.setSelected(false);
                chkMeasureRevoked.setSelected(false);
            }

        }
    }

    public void chkMeasureRevoked_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (chkMeasureRevoked.isSelected()) {
                chkReport.setSelected(false);
                chkCancel.setSelected(false);
                chkMeasureTaken.setSelected(false);
            }

        }
    }

    public void chkSelectEmployee_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (transactionState == 1) {
                if (chkSelectEmployee.isSelected()) {
                    chkReport.setDisabled(true);
                    chkReport.setSelected(true);
                    chkCancel.setSelected(false);
                    chkMeasureTaken.setSelected(false);
                    chkMeasureRevoked.setSelected(false);
                } else {
                    chkReport.setSelected(false);
                    chkCancel.setSelected(false);
                    chkMeasureTaken.setSelected(false);
                    chkMeasureRevoked.setSelected(false);
                }
            } else if (transactionState == 2) {
                if (chkSelectEmployee.isSelected()) {
                    chkReport.setSelected(false);
                    chkCancel.setSelected(false);
                    chkMeasureTaken.setSelected(false);
                    chkMeasureRevoked.setSelected(false);
                } else {
                    chkReport.setSelected(false);
                    chkCancel.setSelected(false);
                    chkMeasureTaken.setSelected(false);
                    chkMeasureRevoked.setSelected(false);
                }
            }
        }
    }

    private void validateDateTime(FacesContext context, UIComponent component, Object value) {
        String patternName = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        boolean matchStringText = Pattern.matches(patternName, (CharSequence) (value.toString()));
        if (matchStringText == false) {
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            ((UIInput) component).setValid(false);
            error(component, messageResource.getString("ETdateVaild"));
        }
    }

    public void txtfAbsentDate_validate(FacesContext context, UIComponent component, Object value) {
        validateDateTime(context, component, value);
    }

    public String btnCalDateAttendace_action() {
        calAttendanceTakenDate.setRendered(true);
        return null;
    }

    public void calAttendanceTakenDate_processValueChange(ValueChangeEvent vce) {
        txtfAbsentDate.setValue(dateFormat.format(calAttendanceTakenDate.getValue()));
        calAttendanceTakenDate.setRendered(false);
    }

    public String btnCalDateAttendaceSearch_action() {
           calSearchDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calSearchDate_processValueChange(ValueChangeEvent vce) {
        txtfAbsentDateSearch.setValue(dateFormat.format(calAttendanceTakenDate.getValue()));
        calSearchDate.setRendered(false);
    }
}
