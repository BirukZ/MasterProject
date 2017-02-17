/*
 * CandidatesPage.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.AutoCompleteDictionary;
import fphrms.EmployeeList;
import fphrms.SessionBean1;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import manager.recruitmentManager.CandidateManager;
import manager.recruitmentManager.RecruitmentManager;
import fphrms.RequestBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.LookUpManager;
import manager.recruitmentManager.CandidateExperienceManager.CandidateEducationManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CandidatesPage extends AbstractPageBean {

    AutoCompleteDictionary autoCompleteDictionary = new AutoCompleteDictionary();
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    Option[] gender = recruitmentManager.assignGender();
    Option[] employeeType = recruitmentManager.reedEmployeeType();
    Option[] bachCode = recruitmentManager.readListOfBachCodeForCnd();
    DepartmentManage departmentManage = new DepartmentManage();
    EmployeeList currentEmployee1 = new EmployeeList("", "0", null);
    private ArrayList<SelectItem> zerf_Name = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> directorate_Name = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> division_Name = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> mastebaberia_Name = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> team_Name = new ArrayList<SelectItem>();
    ArrayList<CandidateEducationManager> candidateEducationList = new ArrayList<CandidateEducationManager>();
    public List listOfEducation = new ArrayList<CandidateEducationManager>();
    List matchesList = new ArrayList<SelectItem>();
    String[] requestInfos;
    int tableSize;
    int educationID;
    public String educLevelCode;
    public String status;
    public String educID;
    public String leaveOfEducation;
    private String selectedEmployeeId;
    EmployeeManage employeeManager = new EmployeeManage();
    ArrayList<SelectItem> jobTypeList = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   // ArrayList<SelectItem> educLevelOpt = new ArrayList<SelectItem>();
    ArrayList<Option> educLevelOpt = new ArrayList<Option>();
    LookUpManager lookUpManager = new LookUpManager();

    public String getEducID() {
        return educID;
    }

    public void setEducID(String educID) {
        this.educID = educID;
    }

    public int getEducationID() {
        return educationID;
    }

    public void setEducationID(int educationID) {
        this.educationID = educationID;
    }

    public String getEducLevelCode() {
        return educLevelCode;
    }

    public void setEducLevelCode(String educLevelCode) {
        this.educLevelCode = educLevelCode;
    }

    public List getListOfEducation() {
        return listOfEducation;
    }

    public void setListOfEducation(List listOfEducation) {
        this.listOfEducation = listOfEducation;
    }

    public String getLeaveOfEducation() {
        return leaveOfEducation;
    }

    public void setLeaveOfEducation(String leaveOfEducation) {
        this.leaveOfEducation = leaveOfEducation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<CandidateEducationManager> getCandidateEducationList() {
        return candidateEducationList;
    }

    public void setCandidateEducationList(ArrayList<CandidateEducationManager> candidateEducationList) {
        this.candidateEducationList = candidateEducationList;
    }

    public ArrayList<SelectItem> getJobTypeList() {

        return jobTypeList;
    }

    public void setJobTypeList(ArrayList<SelectItem> jobTypeList) {
        this.jobTypeList = jobTypeList;
    }

    public EmployeeList getCurrentEmployee1() {
        return currentEmployee1;
    }

    public void setCurrentEmployee1(EmployeeList currentEmployee1) {
        this.currentEmployee1 = currentEmployee1;
    }

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public ArrayList<SelectItem> getEducLevelOpt() {
        return lookUpManager.readEducationLevel();
    }

    public void setEducLevelOpt(ArrayList<Option> educLevelOpt) {
        this.educLevelOpt = educLevelOpt;
    }

    public List getList() {
        return matchesList;
    }

    public List getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }

    public ArrayList<SelectItem> getDirectorate_Name() {
        return directorate_Name;
    }

    public void setDirectorate_Name(ArrayList<SelectItem> directorate_Name) {
        this.directorate_Name = directorate_Name;
    }

    public ArrayList<SelectItem> getDivision_Name() {
        return division_Name;
    }

    public void setDivision_Name(ArrayList<SelectItem> division_Name) {
        this.division_Name = division_Name;
    }

    public ArrayList<SelectItem> getMastebaberia_Name() {
        return mastebaberia_Name;
    }

    public void setMastebaberia_Name(ArrayList<SelectItem> mastebaberia_Name) {
        this.mastebaberia_Name = mastebaberia_Name;
    }

    public RecruitmentManager getRecruitmentManager() {
        return recruitmentManager;
    }

    public void setRecruitmentManager(RecruitmentManager recruitmentManager) {
        this.recruitmentManager = recruitmentManager;
    }

    public ArrayList<SelectItem> getTeam_Name() {
        return team_Name;
    }

    public void setTeam_Name(ArrayList<SelectItem> team_Name) {
        this.team_Name = team_Name;
    }

    public ArrayList<SelectItem> getZerf_Name() {
        return zerf_Name;
    }

    public void setZerf_Name(ArrayList<SelectItem> zerf_Name) {
        this.zerf_Name = zerf_Name;
    }

    public Option[] getBachCode() {
        return bachCode;
    }

    public void setBachCode(Option[] bachCode) {
        this.bachCode = bachCode;
    }
    String candidateId = null;
    int educatiobnID;

    public int getEducatiobnID() {
        return educatiobnID;
    }

    public void setEducatiobnID(int educatiobnID) {
        this.educatiobnID = educatiobnID;
    }

    public Option[] getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Option[] employeeType) {
        this.employeeType = employeeType;
    }

    public Option[] getGender() {
        return gender;
    }

    public void setGender(Option[] gender) {
        this.gender = gender;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;


    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        this.DisableEducationButton();
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlInputText txtFirstName = new HtmlInputText();

    public HtmlInputText getTxtFirstName() {
        return txtFirstName;
    }

    public void setTxtFirstName(HtmlInputText hit) {
        this.txtFirstName = hit;
    }
    private HtmlInputText txtMidelName = new HtmlInputText();

    public HtmlInputText getTxtMidelName() {
        return txtMidelName;
    }

    public void setTxtMidelName(HtmlInputText hit) {
        this.txtMidelName = hit;
    }
    private HtmlInputText txtLastName = new HtmlInputText();

    public HtmlInputText getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(HtmlInputText hit) {
        this.txtLastName = hit;
    }
    private HtmlInputText txtDateOfBirth = new HtmlInputText();

    public HtmlInputText getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    public void setTxtDateOfBirth(HtmlInputText hit) {
        this.txtDateOfBirth = hit;
    }
    //  private HtmlInputText txtLevelOfEducation = new HtmlInputText();

//    public HtmlInputText getTxtLevelOfEducation() {
//        return txtLevelOfEducation;
//    }
//
//    public void setTxtLevelOfEducation(HtmlInputText hit) {
//        this.txtLevelOfEducation = hit;
//    }
    private HtmlInputText txtMobile = new HtmlInputText();

    public HtmlInputText getTxtMobile() {
        return txtMobile;
    }

    public void setTxtMobile(HtmlInputText hit) {
        this.txtMobile = hit;
    }
    private HtmlInputText txtEmail = new HtmlInputText();

    public HtmlInputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(HtmlInputText hit) {
        this.txtEmail = hit;
    }
    private HtmlInputText txtwrittenExam = new HtmlInputText();

    public HtmlInputText getTxtwrittenExam() {
        return txtwrittenExam;
    }

    public void setTxtwrittenExam(HtmlInputText hit) {
        this.txtwrittenExam = hit;
    }
    private HtmlInputText txtInterview = new HtmlInputText();

    public HtmlInputText getTxtInterview() {
        return txtInterview;
    }

    public void setTxtInterview(HtmlInputText hit) {
        this.txtInterview = hit;
    }
    private HtmlInputTextarea txtRecommendation = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRecommendation() {
        return txtRecommendation;
    }

    public void setTxtRecommendation(HtmlInputTextarea hit) {
        this.txtRecommendation = hit;
    }
    private HtmlSelectOneMenu drlBatchCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBatchCode() {
        return drlBatchCode;
    }

    public void setDrlBatchCode(HtmlSelectOneMenu hsom) {
        this.drlBatchCode = hsom;
    }
    private HtmlSelectOneMenu drlJobType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJobType() {
        return drlJobType;
    }

    public void setDrlJobType(HtmlSelectOneMenu hsom) {
        this.drlJobType = hsom;
    }
    private HtmlInputText txtNoPage = new HtmlInputText();

    public HtmlInputText getTxtNoPage() {
        return txtNoPage;
    }

    public void setTxtNoPage(HtmlInputText hit) {
        this.txtNoPage = hit;
    }
    private HtmlInputText txtExperience = new HtmlInputText();

    public HtmlInputText getTxtExperience() {
        return txtExperience;
    }

    public void setTxtExperience(HtmlInputText hit) {
        this.txtExperience = hit;
    }
    private HtmlInputText txtOficeTelephone = new HtmlInputText();

    public HtmlInputText getTxtOficeTelephone() {
        return txtOficeTelephone;
    }

    public void setTxtOficeTelephone(HtmlInputText hit) {
        this.txtOficeTelephone = hit;
    }
    private HtmlInputText txtTelResidence = new HtmlInputText();

    public HtmlInputText getTxtTelResidence() {
        return txtTelResidence;
    }

    public void setTxtTelResidence(HtmlInputText hit) {
        this.txtTelResidence = hit;
    }
    private HtmlInputText txtPractical = new HtmlInputText();

    public HtmlInputText getTxtPractical() {
        return txtPractical;
    }

    public void setTxtPractical(HtmlInputText hit) {
        this.txtPractical = hit;
    }
    private HtmlInputText txtOther = new HtmlInputText();

    public HtmlInputText getTxtOther() {
        return txtOther;
    }

    public void setTxtOther(HtmlInputText hit) {
        this.txtOther = hit;
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
    private HtmlSelectOneMenu drlGender = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlGender() {
        return drlGender;
    }

    public void setDrlGender(HtmlSelectOneMenu hsom) {
        this.drlGender = hsom;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
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
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlOutputText lblMesageConfirm = new HtmlOutputText();

    public HtmlOutputText getLblMesageConfirm() {
        return lblMesageConfirm;
    }

    public void setLblMesageConfirm(HtmlOutputText hot) {
        this.lblMesageConfirm = hot;
    }
    private HtmlInputText txtCGPA = new HtmlInputText();

    public HtmlInputText getTxtCGPA() {
        return txtCGPA;
    }

    public void setTxtCGPA(HtmlInputText hit) {
        this.txtCGPA = hit;
    }
    private HtmlOutputText lblErrorMessageForGender = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForGender() {
        return lblErrorMessageForGender;
    }

    public void setLblErrorMessageForGender(HtmlOutputText hot) {
        this.lblErrorMessageForGender = hot;
    }
    private HtmlOutputText lblErrorMessageForBachCode = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForBachCode() {
        return lblErrorMessageForBachCode;
    }

    public void setLblErrorMessageForBachCode(HtmlOutputText hot) {
        this.lblErrorMessageForBachCode = hot;
    }
    private HtmlOutputText lblErrorMessageForCandidate = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForCandidate() {
        return lblErrorMessageForCandidate;
    }

    public void setLblErrorMessageForCandidate(HtmlOutputText hot) {
        this.lblErrorMessageForCandidate = hot;
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
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems2 = dsia;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems6 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems6 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems7 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems1() {
        return selectOneMenu2DefaultItems1;
    }

    public void setSelectOneMenu2DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems2() {
        return selectOneMenu2DefaultItems2;
    }

    public void setSelectOneMenu2DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems3() {
        return selectOneMenu2DefaultItems3;
    }

    public void setSelectOneMenu2DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems3 = dsia;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu5Bean() {
        return selectOneMenu5Bean;
    }

    public void setSelectOneMenu5Bean(DefaultSelectedData dsd) {
        this.selectOneMenu5Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu5DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu5DefaultItems() {
        return selectOneMenu5DefaultItems;
    }

    public void setSelectOneMenu5DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu5DefaultItems = dsi;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlInputText txtResidentialAddress = new HtmlInputText();

    public HtmlInputText getTxtResidentialAddress() {
        return txtResidentialAddress;
    }

    public void setTxtResidentialAddress(HtmlInputText hit) {
        this.txtResidentialAddress = hit;
    }
    private HtmlInputText txtGraduatedby = new HtmlInputText();

    public HtmlInputText getTxtGraduatedby() {
        return txtGraduatedby;
    }

    public void setTxtGraduatedby(HtmlInputText hit) {
        this.txtGraduatedby = hit;
    }
    private HtmlCommandButton btnCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalender() {
        return btnCalender;
    }

    public void setBtnCalender(HtmlCommandButton hcb) {
        this.btnCalender = hcb;
    }
    private PanelLayout message = new PanelLayout();

    public PanelLayout getMessage() {
        return message;
    }

    public void setMessage(PanelLayout pl) {
        this.message = pl;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private PanelPopup panelPopupRecruitRequest = new PanelPopup();

    public PanelPopup getPanelPopupRecruitRequest() {
        return panelPopupRecruitRequest;
    }

    public void setPanelPopupRecruitRequest(PanelPopup pp) {
        this.panelPopupRecruitRequest = pp;
    }
    private HtmlOutputText lblRecruitRequestPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblRecruitRequestPopUpMsgMain() {
        return lblRecruitRequestPopUpMsgMain;
    }

    public void setLblRecruitRequestPopUpMsgMain(HtmlOutputText hot) {
        this.lblRecruitRequestPopUpMsgMain = hot;
    }
    private PanelPopup popupExamDetail = new PanelPopup();

    public PanelPopup getPopupExamDetail() {
        return popupExamDetail;
    }

    public void setPopupExamDetail(PanelPopup pp) {
        this.popupExamDetail = pp;
    }
    private HtmlOutputText lblNameOfCandidateResult = new HtmlOutputText();

    public HtmlOutputText getLblNameOfCandidateResult() {
        return lblNameOfCandidateResult;
    }

    public void setLblNameOfCandidateResult(HtmlOutputText hot) {
        this.lblNameOfCandidateResult = hot;
    }
    private HtmlCommandButton btnSaveExam = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveExam() {
        return btnSaveExam;
    }

    public void setBtnSaveExam(HtmlCommandButton hcb) {
        this.btnSaveExam = hcb;
    }
    private HtmlCommandButton btnEditExam = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditExam() {
        return btnEditExam;
    }

    public void setBtnEditExam(HtmlCommandButton hcb) {
        this.btnEditExam = hcb;
    }
    private HtmlCommandButton btnUpdateExam = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateExam() {
        return btnUpdateExam;
    }

    public void setBtnUpdateExam(HtmlCommandButton hcb) {
        this.btnUpdateExam = hcb;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessageExam = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessageExam() {
        return lblFormMessageExam;
    }

    public void setLblFormMessageExam(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessageExam = hol;
    }
    private PanelLayout pnlMessageBodyExam = new PanelLayout();

    public PanelLayout getPnlMessageBodyExam() {
        return pnlMessageBodyExam;
    }

    public void setPnlMessageBodyExam(PanelLayout pl) {
        this.pnlMessageBodyExam = pl;
    }
    private HtmlPanelGroup panelGroupMessageExam = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessageExam() {
        return panelGroupMessageExam;
    }

    public void setPanelGroupMessageExam(HtmlPanelGroup hpg) {
        this.panelGroupMessageExam = hpg;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
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
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calDateOfBirth = new SelectInputDate();

    public SelectInputDate getCalDateOfBirth() {
        return calDateOfBirth;
    }

    public void setCalDateOfBirth(SelectInputDate sid) {
        this.calDateOfBirth = sid;
    }
    private HtmlInputText txtYearOfGraduation = new HtmlInputText();

    public HtmlInputText getTxtYearOfGraduation() {
        return txtYearOfGraduation;
    }

    public void setTxtYearOfGraduation(HtmlInputText hit) {
        this.txtYearOfGraduation = hit;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDate calDateOfGraduation = new SelectInputDate();

    public SelectInputDate getCalDateOfGraduation() {
        return calDateOfGraduation;
    }

    public void setCalDateOfGraduation(SelectInputDate sid) {
        this.calDateOfGraduation = sid;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private HtmlSelectOneMenu drlLevelOfEducation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLevelOfEducation() {
        return drlLevelOfEducation;
    }

    public void setDrlLevelOfEducation(HtmlSelectOneMenu hsom) {
        this.drlLevelOfEducation = hsom;
    }
    private HtmlCommandButton btnCalenderYearOfGraduation = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderYearOfGraduation() {
        return btnCalenderYearOfGraduation;
    }

    public void setBtnCalenderYearOfGraduation(HtmlCommandButton hcb) {
        this.btnCalenderYearOfGraduation = hcb;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems3 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems3 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems5() {
        return selectOneRadio1DefaultItems5;
    }

    public void setSelectOneRadio1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems5 = dsia;
    }
    private HtmlOutputText outputText3 = new HtmlOutputText();

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setOutputText3(HtmlOutputText hot) {
        this.outputText3 = hot;
    }
    private HtmlInputText txt_Instution = new HtmlInputText();

    public HtmlInputText getTxt_Instution() {
        return txt_Instution;
    }

    public void setTxt_Instution(HtmlInputText hit) {
        this.txt_Instution = hit;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlCommandButton btn_AddEduc = new HtmlCommandButton();

    public HtmlCommandButton getBtn_AddEduc() {
        return btn_AddEduc;
    }

    public void setBtn_AddEduc(HtmlCommandButton hcb) {
        this.btn_AddEduc = hcb;
    }
    private HtmlCommandButton btn_edu_new = new HtmlCommandButton();

    public HtmlCommandButton getBtn_edu_new() {
        return btn_edu_new;
    }

    public void setBtn_edu_new(HtmlCommandButton hcb) {
        this.btn_edu_new = hcb;
    }
    private HtmlCommandButton btn_Educupdate = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Educupdate() {
        return btn_Educupdate;
    }

    public void setBtn_Educupdate(HtmlCommandButton hcb) {
        this.btn_Educupdate = hcb;
    }
    private HtmlCommandButton btn_Educdelete = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Educdelete() {
        return btn_Educdelete;
    }

    public void setBtn_Educdelete(HtmlCommandButton hcb) {
        this.btn_Educdelete = hcb;
    }
    private HtmlCommandButton btn_Educedit = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Educedit() {
        return btn_Educedit;
    }

    public void setBtn_Educedit(HtmlCommandButton hcb) {
        this.btn_Educedit = hcb;
    }
    private HtmlCommandButton btn_SaveEducation = new HtmlCommandButton();

    public HtmlCommandButton getBtn_SaveEducation() {
        return btn_SaveEducation;
    }

    public void setBtn_SaveEducation(HtmlCommandButton hcb) {
        this.btn_SaveEducation = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CandidatesPage() {
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
        disableComponet();
        clareComponet();
        disableExamResult();
        clareExameComponet();
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnReset.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnSave.setDisabled(true);
        btnNew.setDisabled(false);
        btnSaveExam.setDisabled(true);
        btnEditExam.setDisabled(true);
        btnUpdateExam.setDisabled(true);
        this.setZerf_Name(departmentManage.getDepartmentName());

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
        txtFirstName.setRequired(true);
        txtFirstName.setRequiredMessage("Required");
        txtMidelName.setRequired(true);
        txtMidelName.setRequiredMessage("Required");
        txtLastName.setRequired(true);
        txtLastName.setRequiredMessage("Required");
        txtDateOfBirth.setRequired(true);
        txtDateOfBirth.setRequiredMessage("Required");
    //  drlLevelOfEducation.setRequired(true);
    // drlLevelOfEducation.setRequiredMessage("Required");
//        txtLevelOfEducation.setRequired(true);
//        txtLevelOfEducation.setRequiredMessage("Required");
//        txtLevelOfEducation.setRequired(true);
//        txtLevelOfEducation.setRequiredMessage("Required");
        
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

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
//    protected RequestBean1 getRequestBean1() {
//        return (RequestBean1) getBean("RequestBean1");
//    }
//
//    /**
//     * <p>Return a reference to the scoped data bean.</p>
//     *
//     * @return reference to the scoped data bean
//     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }
//
//    /**
//     * <p>Return a reference to the scoped data bean.</p>
//     *
//     * @return reference to the scoped data bean
//     */

    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    int selectedEducatuon = -1;

    void disableComponet() {
//        txtDate.setDisabled(true);
    this.btn_edu_new.setDisabled(false);
        txtMidelName.setDisabled(true);
        txtFirstName.setDisabled(true);
        txtLastName.setDisabled(true);
        txtDateOfBirth.setDisabled(true);
        drlGender.setDisabled(true);
        drlBatchCode.setDisabled(true);
        drlJobType.setDisabled(true);
        txt_Instution.setDisabled(true);
        txtEmail.setDisabled(true);
        txtMobile.setDisabled(true);
        txtOficeTelephone.setDisabled(true);
        txtTelResidence.setDisabled(true);
        txtResidentialAddress.setDisabled(true);
        drlLevelOfEducation.setDisabled(true);
        txtNoPage.setDisabled(true);
        txtCGPA.setDisabled(true);
        txtExperience.setDisabled(true);
        txtGraduatedby.setDisabled(true);
        btnCalender.setDisabled(true);
        btnCalenderYearOfGraduation.setDisabled(true);
    }

    void enableComponet() {
        //   txtDate.setDisabled(false);
        txtMidelName.setDisabled(false);
        txtFirstName.setDisabled(false);
        txtLastName.setDisabled(false);
        txtDateOfBirth.setDisabled(false);
        //  txt_Instution.setDisabled(false);
        drlGender.setDisabled(false);
        btnCalender.setDisabled(false);
        drlBatchCode.setDisabled(false);
        drlJobType.setDisabled(false);
        txtEmail.setDisabled(false);
        txtMobile.setDisabled(false);
        txtOficeTelephone.setDisabled(false);
        txtTelResidence.setDisabled(false);
        txtResidentialAddress.setDisabled(false);
        // drlLevelOfEducation.setDisabled(false);
        txtNoPage.setDisabled(false);
        // txtCGPA.setDisabled(false);
        txtExperience.setDisabled(false);
    //txtGraduatedby.setDisabled(false);
    //btnCalenderYearOfGraduation.setDisabled(false);
    }

    public void rowSelectorCandidateEducation_processMyEvent(RowSelectorEvent rse) {
        selectedEducatuon = rse.getRow();
    }

    public int getSelectedEducatuon() {
        return selectedEducatuon;
    }

    public void setSelectedEducatuon(int selectedEducatuon) {
        this.selectedEducatuon = selectedEducatuon;
    }

    void clareComponet() {
        txtYearOfGraduation.resetValue();
        txtMidelName.resetValue();
        txtFirstName.resetValue();
        txtLastName.resetValue();
        txt_Instution.resetValue();
        txtDateOfBirth.setValue("");
        drlGender.setValue("");

        drlBatchCode.setValue("");
        drlJobType.setValue("");

        txtEmail.setValue("");
        txtMobile.setValue("");
        txtOficeTelephone.setValue("");
        txtTelResidence.setValue("");
        txtResidentialAddress.setValue("");
        txtYearOfGraduation.setValue("");
        //txtLevelOfEducation.setValue("");
        txtNoPage.setValue("");
        txtCGPA.setValue("0");
        txtExperience.setValue("");
        txtGraduatedby.setValue("");
        candidateEducationList.clear();


    }

    void disableExamResult() {
        txtPractical.setDisabled(true);
        txtRecommendation.setDisabled(true);
        txtInterview.setDisabled(true);
        txtOther.setDisabled(true);
        txtwrittenExam.setDisabled(true);
    }

    void clareExameComponet() {
        txtPractical.setValue("");
        txtRecommendation.setValue("");
        txtInterview.setValue("");
        txtOther.setValue("");
        txtwrittenExam.setValue("");

    }

    void enableExameComponet() {
        txtPractical.setDisabled(false);
        txtRecommendation.setDisabled(false);
        txtInterview.setDisabled(false);
        txtOther.setDisabled(false);
        txtwrittenExam.setDisabled(false);
    }
    CandidateManager candidateManager = new CandidateManager();

    private HashMap registerCandidateINfor() {

      //  requestInfos = drlBatchCode.getValue().toString().split("--");
       String requestInfoss = drlBatchCode.getValue().toString();
     

        try {
            HashMap candidateInformation = new HashMap();
            candidateInformation.put("firstName", txtFirstName.getValue().toString());
            candidateInformation.put("midelName", txtMidelName.getValue().toString());
            candidateInformation.put("lastName", txtLastName.getValue());
            candidateInformation.put("dateOfBirth", txtDateOfBirth.getValue().toString());
            candidateInformation.put("gender", drlGender.getValue().toString());
           // candidateInformation.put("bachCode", requestInfos[0]);
             candidateInformation.put("bachCode", requestInfoss);
            candidateInformation.put("jobType", drlJobType.getValue().toString());
            candidateInformation.put("email", txtEmail.getValue().toString());
            candidateInformation.put("mobile", txtMobile.getValue().toString());
            candidateInformation.put("officeTelephone", txtOficeTelephone.getValue().toString());
            candidateInformation.put("telResidence", txtTelResidence.getValue().toString());
            candidateInformation.put("residentialAddress", txtResidentialAddress.getValue().toString());
            candidateInformation.put("noofPage", txtNoPage.getValue().toString());
            candidateInformation.put("experience", txtExperience.getValue().toString());
            candidateInformation.put("candidateID", candidateId);
            return candidateInformation;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }
    void UpdateCandidateInformationNew()
        {
          int checkSave = candidateManager.UpdateCandidateInformation(registerCandidateINfor());
            if (checkSave == 1)
            {
                showSuccessOrFailureMessage(true, "The Candidate Information is updated successfully!");
                getApplicationBean1().init();
                //  showConformationMsg(getMessage().getStyleClass().toString());
                disableComponet();
                btnDelete.setDisabled(false);
                btnEdit.setDisabled(false);
                btnReset.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnSave.setDisabled(true);
                btnNew.setDisabled(false);
            } else {
                showSuccessOrFailureMessage(false, "The Candidate Information is not updated! Please try again?");

            }

    }

    void saveCandidateInformation(int perform)
                       {
        lblMesageConfirm.setVisible(false);
        String gpa = "0";
        if (txtCGPA.getValue().equals(null))
        {
            gpa = txtCGPA.getValue().toString().trim();
        }
        if (perform == 1) {
            int checkSave = candidateManager.saveCandidateInformation(registerCandidateINfor());
            if (checkSave == 1) {
                showSuccessOrFailureMessage(true, "The Candidate Information  Saved Successfully. ");
                getApplicationBean1().init();
                // showConformationMsg(getMessage().getStyleClass().toString());
                disableComponet();
                btnDelete.setDisabled(false);
                btnEdit.setDisabled(false);
                btnReset.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnSave.setDisabled(true);
                btnNew.setDisabled(false);
            } else {

                showSuccessOrFailureMessage(false, "The Candidate Information Not Saved .Please Try Agin.");
            //showConformationMsg(getMessage().getStyleClass().toString());
            }
        }


    }

    public void updateList(ValueChangeEvent event) {
        try {
            // get a new list of matches.
            setMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete1 = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete1.getSelectedItem() != null) {
                    currentEmployee1 = (EmployeeList) autoComplete1.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee1.getEmpIdentification());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempData = getMatch(autoComplete1.getValue().toString());
                    if (tempData != null) {
                        currentEmployee1 = tempData;
                    }

                }
            }
        } catch (Exception ex) {
        }
    }

    void loadCandidateEducation() {
        candidateEducationList.clear();
        HashMap[] list = candidateManager.readEmployeeEducation(candidateId);
        CandidateEducationManager addTotabele = null;
        try {
            tableSize = candidateManager.countExperiance(candidateId);

            if (tableSize > 0) {
                
                for (int i = 0; i < tableSize; i++) {
                    addTotabele = new CandidateEducationManager(list[i].get("STATUS").toString(),
                            list[i].get("CANDIDATE_ID").toString(),
                            list[i].get("INSTUTION").toString(),
                            list[i].get("CGPA").toString(),
                            list[i].get("FILED_OF_STUDY").toString(),
                            list[i].get("CAN_EDUC_ID").toString(),
                            list[i].get("GRADUATION_YEAR").toString(),
                            list[i].get("FILED_OF_CATAGORY").toString(),
                            Integer.parseInt( list[i].get("Education_ID").toString()));
                    this.candidateEducationList.add(addTotabele);
                // this.listOfExperience.add(addTotabele);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String txtSearchCandidate_action() {
        //return null means stay on the same page
        try {
          
            this.btn_Educedit.setDisabled(false);
            lblMesageConfirm.setVisible(false);
            candidateId = getApplicationBean1().getSelectedEmployeeId();
            loadCandidateEducation();
            if (candidateId != null) {

                HashMap candidateList = candidateManager.selectCandidate(getApplicationBean1().getSelectedEmployeeId());

                if (candidateList != null) {

                    txtFirstName.setValue(candidateList.get("CANDIDATE_F_NAME"));
                    txtMidelName.setValue(candidateList.get("CANDIDATE_M_NAME"));
                    txtLastName.setValue(candidateList.get("CANDIDATE_L_NAME"));
                    txtDateOfBirth.setValue(candidateList.get("DATEOFBIRTH"));
                    drlGender.setValue(candidateList.get("GENDER"));

                    drlBatchCode.setValue(candidateList.get("RECRUIT_BATCH_CODE"));
                    setJobTypeList(candidateManager.readJobType(candidateList.get("RECRUIT_BATCH_CODE").toString()));
                    drlJobType.setValue(candidateList.get("JOBTYPE"));
                    txtEmail.setValue(candidateList.get("EMAIL"));
                    txtMobile.setValue(candidateList.get("TELEPHONE_MOBILE"));
                    txtOficeTelephone.setValue(candidateList.get("OFFICETELEPHONE"));
                    txtTelResidence.setValue(candidateList.get("TELEPHONERESIDENCE"));
                    txtResidentialAddress.setValue(candidateList.get("RESIDENTIALADDRESS"));
                    drlLevelOfEducation.setValue(candidateList.get("LEVELOFEDUCATION"));
                    txtNoPage.setValue(candidateList.get("TOTAL_NUMBER_OF_PAGES"));
                    txtCGPA.setValue(candidateList.get("CGPA"));
                    txtExperience.setValue(candidateList.get("EXPERIENCE"));
                    txtGraduatedby.setValue(candidateList.get("GRADUATEDBY"));
                    txtYearOfGraduation.setValue(candidateList.get("YEAROFGRADUATION"));
                  //  educationID=Integer.parseInt(candidateList.get("Education_ID").toString());
                    btnDelete.setDisabled(false);
                    btnEdit.setDisabled(false);
                    btnReset.setDisabled(true);
                    btnUpdate.setDisabled(true);
                    btnSave.setDisabled(true);
                    btnNew.setDisabled(false);
                    btn_edu_new.setDisabled(false);
                    btn_Educdelete.setDisabled(false);
                    disableComponet();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public void drlBatchCode_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            lblErrorMessageForBachCode.setRendered(false);
            requestInfos = vce.getNewValue().toString().split("--");
            setJobTypeList(candidateManager.readJobType(requestInfos[0]));
        }
    }

    public void drlGender_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageForGender.setRendered(false);
        lblMesageConfirm.setVisible(false);
    }

    public void drlJobType_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageForCandidate.setRendered(false);
        lblMesageConfirm.setVisible(false);
    }

    public String cmdRecruitmentRequest_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmCandidateExperience_action() {
        //return null means stay on the same page
        return "CandidateExperience";
    }

    public String cmdvacNotice_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdFilterCandidateForExam_action() {
        //return null means stay on the same page
        return "FilterCandidateForExam";
    }

    private EmployeeList getMatch(String value) {
        EmployeeList result = null;
        if (matchesList != null) {
            SelectItem si;
            Iterator iter = matchesList.iterator();
            while (iter.hasNext()) {
                si = (SelectItem) iter.next();
                if (value.equals(si.getLabel())) {
                    result = (EmployeeList) si.getValue();
                }

            }
        }
        return result;
    }

    private void setMatches(ValueChangeEvent event)
    {
        Object searchWord = event.getNewValue();

        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);
        try {
            int insert = Collections.binarySearch(autoCompleteDictionary.dictionary, searchWord, autoCompleteDictionary.LABEL_COMPARATOR);
            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }
            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= autoCompleteDictionary.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(autoCompleteDictionary.dictionary.get(insert + i));
            }
        } catch (Throwable e) {
        }
        // assign new matchList
        if (this.matchesList != null) {
            this.matchesList.clear();
            this.matchesList = null;
        }

        this.matchesList = matchList;
    }

//
    void setEmployeeProfile() {
        //cboMiltery.setSelected(false);
        //cboCivile.setSelected(false);
        //cboContract.setSelected(false);
        //adressTableSize = 0;
        //langTableSize = 0;
        ///educTableSize = 0;
        //tableSize = 0;
        //familyTableSize = 0;
        //counter = 0;
        //lanCounter = 0;
        //educCounter = 0;
        //countAdress = 0;
        //countfamily = 0;
        //this.getEmployeeAddress().clear();
//        this.getEmployeeAdressUpdate().clear();
//        this.getListOfExpUpdate().clear();
//        this.getFamilyInfoUpdate().clear();
//        this.getFamilyInformation().clear();
//        this.getListOfExperience().clear();
//        this.getListOfEducation().clear();
//        this.getListOfEducationUpdate().clear();
//        this.listOfLanguage.clear();
//        this.listOfLanguageUpdate.clear();
        try {

//            btnEdit1.setDisabled(false);
//            btnDelete.setDisabled(false);
//            btnReset.setDisabled(false);
//            btnNew1.setDisabled(false);
//            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
//
//            try {
////                setEmpImage(blo.getBytes(0, (int) blo.length()));
////                imgMember.setValue(getEmpImage());
//
//            } catch (Exception ex) {
//
//                ex.printStackTrace();
//            }
//
//            drlNationality.setValue(employeeManager.getNationality_Code());
//            this.setNation(lookUpManager.assignNation());
//            txtFirstName.setValue(employeeManager.getFirst_Name());
//            txtMidelName.setValue(employeeManager.getMiddle_Name());
//            txtLastName.setValue(employeeManager.getLast_Name());
//            txtDateOfBirth.setValue(employeeManager.getDate_Of_Birth());
//            drlMaritalStatus.setValue(employeeManager.getMarital_Status());
//            txtSalary.setValue(employeeManager.getSalary());
//            //   txtRetirementNo.setValue(employeeManager.getRetirement_no());
//            drlNation.setValue(employeeManager.getNation_Code());
//            txtHireDate.setValue(employeeManager.getHire_Date());
//            drlZerf.setValue(employeeManager.getDepartmentId());
//            this.setPerofation(departmentManage.readJobCode(employeeManager.getDepartmentId()));
//
//            try {
//                drlNationality.setValue(employeeManager.getNationality_Code());
//                this.setNation(lookUpManager.assignNation());
//                txtFirstName.setValue(employeeManager.getFirst_Name());
//                txtMidelName.setValue(employeeManager.getMiddle_Name());
//                txtLastName.setValue(employeeManager.getLast_Name());
//                txtDateOfBirth.setValue(employeeManager.getDate_Of_Birth());
//                drlMaritalStatus.setValue(employeeManager.getMarital_Status());
//                txtSalary.setValue(employeeManager.getSalary());
//                txtRetirementNo.setValue(employeeManager.getRetirement_no());
//                drlNation.setValue(employeeManager.getNation_Code());
//                txtHireDate.setValue(employeeManager.getHire_Date());
//
//                if (employeeManager.getDirectorate() != null) {
//                    this.setDirectorate(departmentManage.getZerfName(employeeManager.getDepartmentId()));
//                    drlDirectorate.setValue(employeeManager.getDirectorate());
//                    if (employeeManager.getDivision() != null) {
//
//                        this.setDevision(departmentManage.getZerfName(employeeManager.getDirectorate()));
//                        drlDivision.setValue(employeeManager.getDivision());
//                        if (employeeManager.getMastebabriya() != null) {
//                            this.setMastebaberi(departmentManage.getZerfName(employeeManager.getDivision()));
//                            drlMastebaberia.setValue(employeeManager.getMastebabriya());
//                            if (employeeManager.getTeam() != null) {
//                                this.setTeam(departmentManage.getZerfName(employeeManager.getMastebabriya()));
//                                drlTeam.setValue(employeeManager.getTeam());
//                                this.setPerofation(departmentManage.readJobCode(employeeManager.getTeam()));
//
//                            } else {
//                                this.setPerofation(departmentManage.readJobCode(employeeManager.getMastebabriya()));
//                            }
//                        } else {
//                            this.setPerofation(departmentManage.readJobCode(employeeManager.getDivision()));
//                        }
//
//
//                    } else {
//                        this.setPerofation(departmentManage.readJobCode(employeeManager.getDirectorate()));
//                    }
//
//                } else {
//                    this.setPerofation(departmentManage.readJobCode(employeeManager.getDepartmentId()));
//                }
//                drlJobCode.setValue(employeeManager.getJobCode());
//
//
//
//                this.setPayGradeOpt(lookUpManager.readPayGrade(employeeManager.getRankId()));
//                if (employeeManager.getSex().equals("Female")) {
//                    cboGenderFemale.setSelected(true);
//                }
//                if (employeeManager.getSex().equals("Male")) {
//                    cboGenderMale.setSelected(true);
//                }
//                if (employeeManager.getCivil_Type().equals("Civil")) {
//                    cboCivile.setSelected(true);
//                    this.set_title(lookUpManager.assignTitle("civil"));
//                    this.set_jobRank(lookUpManager.assignJobRank("Civil"));
//                }
//                if (employeeManager.getCivil_Type().equals("Miltery")) {
//                    cboMiltery.setSelected(true);
//                    this.set_title(lookUpManager.assignTitle("military"));
//                    this.set_jobRank(lookUpManager.assignJobRank("Military"));
//
//                }
//                drlPayGrade.setValue(employeeManager.getDrlPayGrade());
//                drlTitle.setValue(employeeManager.getEmpTitle());
//                drlRankId.setValue(employeeManager.getRankId());
//                if (employeeManager.getEmployementType().equals("02")) {
//                    cboContract.setRendered(true);
//                    lblContract.setRendered(true);
//                    cboContract.setSelected(true);
//                    txtCotractStartDate.setDisabled(true);
//                    txtfContractEndDate.setDisabled(true);
//                    bntCotractStartDate.setDisabled(true);
//                    bntCotractEndDate.setDisabled(true);
//                    btnSaveContract.setDisabled(true);
//                    btnEditContract.setDisabled(false);
//                    btnDelete.setDisabled(false);
//                    btnEdit1.setDisabled(false);
//                    btnSave.setDisabled(true);
//                    btnNew.setDisabled(false);
//                    btnUpdate.setDisabled(true);
//                    btnFamilyNew.setDisabled(false);
//                    String list[] = contratManager.readContractDate(txtFEmployeeId.getValue().toString());
//                    txtCotractStartDate.setValue(list[0]);
//                    txtfContractEndDate.setValue(list[1]);
//                    int countContractDate = StringDateManipulation.compareDateDifference(StringDateManipulation.toDayInEc(), list[1]);
//                    lblRemainingDayes.setValue(countContractDate);
//                    pnlPopUpDateSettingForContractEmployee.setRendered(true);
//                } else {
//                    cboContract.setRendered(false);
//                    lblContract.setRendered(false);
//                    cboContract.setSelected(false);
//                }
        } catch (Exception ex) {
        }
    // } catch (Exception ex) {
    //  }
    }

    public String btnNew_action() {

        this.clareComponet();
        this.enableComponet();
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnReset.setDisabled(false);
        btnUpdate.setDisabled(true);
        btnSave.setDisabled(false);
        btnNew.setDisabled(true);



        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {
        if (!drlGender.getValue().equals("SelcetGender")) {
            if (!drlBatchCode.getValue().equals("BachCode")) {
                if (!drlJobType.getValue().equals("CandidateType")) {
                    this.saveCandidateInformation(1);
                } else {
                    lblErrorMessageForCandidate.setRendered(true);
                    lblErrorMessageForCandidate.setValue("Required");
                }
            } else {
                lblErrorMessageForBachCode.setRendered(true);
                lblErrorMessageForBachCode.setValue("Required");
            }
        } else {
            lblErrorMessageForGender.setRendered(true);
            lblErrorMessageForGender.setValue("Required");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnEdit_action()
    {
        lblMesageConfirm.setVisible(false);
        this.enableComponet();
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnReset.setDisabled(false);
        btnUpdate.setDisabled(false);
        btnSave.setDisabled(true);
        btnNew.setDisabled(true);
        status = "New";
        candidateEducationList.clear();
        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action()
    {
      
        this.UpdateCandidateInformationNew();
       
        return null;
    }

    public String btnReset_action() {

        clareComponet();
        lblMesageConfirm.setVisible(false);
        clareComponet();
        disableComponet();
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnReset.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnSave.setDisabled(true);
        btnNew.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        lblRecruitRequestPopUpMsgMain.setValue("Are you sure you want to delete ?");
        panelPopupRecruitRequest.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnRecruitRequestPopUpYes_action() {
        //        lblMesageConfirm.setVisible(false);
        if (candidateManager.deleteCandidate(candidateId) == 1) {
            showSuccessOrFailureMessage(true, "The Candidate Information is deleted successfully! ");
            getApplicationBean1().init();
            // showConformationMsg(getMessage().getStyleClass().toString());
            btnDelete.setDisabled(true);
            btnEdit.setDisabled(true);
            btnReset.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnSave.setDisabled(true);
            btnNew.setDisabled(false);
            clareComponet();
            disableComponet();
            panelPopupRecruitRequest.setRendered(false);
        } else {

            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("The Candidate Information is not deleted! Please try again. ");
            showConformationMsg(getMessage().getStyleClass().toString());
            panelPopupRecruitRequest.setRendered(false);
        }
        //return null means stay on the same page
        return null;
    }

    public String btnRecruitRequestPopUpNo_action() {
        panelPopupRecruitRequest.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        //return null means stay on the same page
        popupExamDetail.setRendered(false);
        return null;
    }

    public String cmdexamQuestion_action() {
        clareExameComponet();
        disableExamResult();
        try {


            if (candidateId != null) {
                lblNameOfCandidateResult.setValue(txtFirstName.getValue() + " " + txtMidelName.getValue() + " " + txtLastName.getValue() + " Exam Result");
                HashMap readExamResult = candidateManager.readCandidateExamResult(candidateId);
                if ((!readExamResult.get("WRITTEN_EXAM_RESULT").equals("0")) || (!readExamResult.get("INTERVIEW_EXAM_RESULT").equals("0")) || (!readExamResult.get("PRACTICAL_EXAM_RESULT").equals("0")) ||
                        (!readExamResult.get("OTHER").equals("0")) || (!readExamResult.get("RECOMMENDATION").equals("writer u remark Here"))) {
                    btnSaveExam.setDisabled(true);
                    btnEditExam.setDisabled(false);
                    btnUpdateExam.setDisabled(true);

                    txtPractical.setValue(readExamResult.get("PRACTICAL_EXAM_RESULT").toString());
                    txtRecommendation.setValue(readExamResult.get("RECOMMENDATION").toString());
                    txtInterview.setValue(readExamResult.get("INTERVIEW_EXAM_RESULT").toString());
                    txtOther.setValue(readExamResult.get("OTHER").toString());
                    txtwrittenExam.setValue(readExamResult.get("WRITTEN_EXAM_RESULT").toString());


                } else {
                    enableExameComponet();
                    btnSaveExam.setDisabled(false);
                    btnEditExam.setDisabled(true);
                    btnUpdateExam.setDisabled(true);
                }
                popupExamDetail.setRendered(true);

            } else {
                showSuccessOrFailureMessage(false, "First Select the Candidate to register his/ her exam result ? ");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public HashMap readExamResult() {
        HashMap examResult = new HashMap();
        examResult.put("practical", txtPractical.getValue());
        examResult.put("recommendation", txtRecommendation.getValue());
        examResult.put("interview", txtInterview.getValue());
        examResult.put("other", txtOther.getValue());
        examResult.put("writtenExam", txtwrittenExam.getValue());
        examResult.put("candidateId", candidateId);
        return examResult;
    }

    public String btnSaveExam_action() {
        int checkSave = candidateManager.saveCandidateExameResult(readExamResult());
        if (checkSave == 1) {
            btnSaveExam.setDisabled(true);
            btnUpdateExam.setDisabled(true);
            btnEdit.setDisabled(false);
            disableExamResult();
            popupExamDetail.setRendered(false);
            showSuccessOrFailureMessage(true, "The candidate exame result saved  successfully !");

        } else {
            showSuccessOrFailureMessage(false, "The candidate exame result not saved. Please try agin?");

        }
        //return null means stay on the same page
        return null;
    }

    public String btnUpdateExam_action() {
        int checkSave = candidateManager.saveCandidateExameResult(readExamResult());
        if (checkSave == 1) {
            btnSaveExam.setDisabled(true);
            btnUpdateExam.setDisabled(true);
            btnEdit.setDisabled(false);
            disableExamResult();
            popupExamDetail.setRendered(false);
            showSuccessOrFailureMessage(true, "The candidate exame result updated successfully !");

        } else {
            showSuccessOrFailureMessage(false, "The candidate exame result not updated. Please try agin?");

        }
        //return null means stay on the same page
        return null;
    }
    public void DisableEducationButton(){

    this.btn_AddEduc.setDisabled(true);
    this.btn_Educdelete.setDisabled(true);
    this.btn_Educedit.setDisabled(true);
    this.btn_Educupdate.setDisabled(true);
    this.btn_SaveEducation.setDisabled(true);
    this.btn_edu_new.setDisabled(true);




    }

    public String btnEditExam_action() {
        //return null means stay on the same page
        enableExameComponet();
        btnSaveExam.setDisabled(true);
        btnUpdateExam.setDisabled(false);
        btnEditExam.setDisabled(true);
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessageExam.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessageExam.setValue(messageToDisplay);
        lblFormMessageExam.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssageExam_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnCalender_action() {
        calDateOfBirth.setRendered(true);
        return null;
    }

    public void calDateOfBirth_processValueChange(ValueChangeEvent vce) {
        String selectedDate = dateFormat.format((Date) vce.getNewValue());
        int age = GregorianCalendarManipulation.calaculateYearDifference(selectedDate, JodanTimeCalender.foreignersToday());

        if (age > 18) {
            outputText3.setRendered(false);
            txtDateOfBirth.setValue(selectedDate);
            calDateOfBirth.setRendered(false);
        } else {
            outputText3.setRendered(true);
            outputText3.setValue("age must be above 18");
        }
    }

    public String btnCalenderYearOfGraduation_action() {
        calDateOfGraduation.setRendered(true);
        return null;
    }

    public void calDateOfGraduation_processValueChange(ValueChangeEvent vce) {
        txtYearOfGraduation.setValue(dateFormat.format(calDateOfGraduation.getValue()));
        calDateOfGraduation.setRendered(false);

    }

    public String button1_action() {
        //return null means stay on the same page
        String candidateID;
        String recuritmentBatch;
        String instiution;
        String cgpa;
        String filedOfStudy;
        String filedOfCatagory;
        String leaveOfEducation;
        String graduationYear;
        String [] levEduc=drlLevelOfEducation.getValue().toString().split("-");
        String educLevelCode=levEduc[1];
        leaveOfEducation = drlLevelOfEducation.getValue().toString();
        cgpa = txtCGPA.getValue().toString();
        filedOfStudy = txtGraduatedby.getValue().toString();
        graduationYear = txtYearOfGraduation.getValue().toString();
        instiution = txt_Instution.getValue().toString();
        candidateID = candidateId;

        candidateEducationList.add(new CandidateEducationManager(status, educLevelCode, cgpa, filedOfStudy, graduationYear, instiution, candidateID,educatiobnID));

        return null;
    }

    public String btn_SaveEducation_action()
    {
        int size = candidateEducationList.size();

        boolean checkSave = candidateManager.SaveCandidateEducation(candidateEducationList);

        if (checkSave) {

            showSuccessOrFailureMessage(true, "The candidate Education Saved successfully !");
        } else {
            showSuccessOrFailureMessage(false, "ERROR ocured While Saving Education Informaton!");

        }






        return null;
    }

    public String btn_AddEduc_action()
        {
        if(candidateId!=null)
        {
        btn_SaveEducation.setDisabled(false);
        String candidateID;
        String recuritmentBatch;
        String instiution;
        String cgpa;
        String filedOfStudy;
        String filedOfCatagory;
        String leaveOfEduc = null;
        String graduationYear;
        leaveOfEduc = leaveOfEducation;
        cgpa = txtCGPA.getValue().toString();
        filedOfStudy = txtGraduatedby.getValue().toString();
        graduationYear = txtYearOfGraduation.getValue().toString();
        instiution = txt_Instution.getValue().toString();
        candidateID = candidateId;

               CandidateEducationManager addEducation= new CandidateEducationManager(status,
                leaveOfEducation, cgpa, filedOfStudy,
                graduationYear, instiution, candidateID,educationID);
        candidateEducationList.add(0,new CandidateEducationManager(status, leaveOfEducation, cgpa, filedOfStudy, graduationYear, instiution, candidateID,educationID));
        this.listOfEducation.add(addEducation);

        }
        else{

        showSuccessOrFailureMessage(false, "Pls Select Candidate First!");

        }
         return null;
    }

    public void drlLevelOfEducation_processValueChange(ValueChangeEvent vce) {
        String[] leveOfEduc = vce.getNewValue().toString().split("-");
        leaveOfEducation = leveOfEduc[1];
      
    }

    public String btn_edu_new_action()
    {
        //return null means stay on the same page
        status="New";
        drlLevelOfEducation.setDisabled(false);
        txtGraduatedby.setDisabled(false);
        txtCGPA.setDisabled(false);
        txt_Instution.setDisabled(false);
        txtGraduatedby.setDisabled(false);
        txtYearOfGraduation.setDisabled(false);
        btnCalenderYearOfGraduation.setDisabled(false);
        candidateEducationList.clear();
        this.btn_AddEduc.setDisabled(false);
        this.btn_SaveEducation.setDisabled(false);

        return null;
    }
        public boolean setSelectedEducationType(String penaltyType)
    {

        for (Option lookingFor : educLevelOpt) {
            if (lookingFor.getValue().toString().startsWith(penaltyType)) {
                drlLevelOfEducation.setValue(lookingFor.getValue().toString());
                return true;
            }
        }
        return false;
    }

//    public String btn_edit_action()
//        {
//
//    }
//
//    public String btn_update_action()
//                    {
//        //return null means stay on the same page
//
//
//    }

//    public String btn_delete_action()
//    {
//        //return null means stay on the same page
//
//    }

    public String btn_Educedit_action() {
        //return null means stay on the same page
          //return null means stay on the same page
        status = "Update";
        if (this.selectedEducatuon == -1) {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (this.selectedEducatuon != -1 && this.candidateEducationList.isEmpty() == true) {

            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {

            CandidateEducationManager candidateEducation = (CandidateEducationManager) this.candidateEducationList.get(this.selectedEducatuon);
            this.candidateEducationList.remove(this.selectedEducatuon);

            this.setSelectedEducationType(candidateEducation.getLeavelOFEducation());
           // this.drlLevelOfEducation.setValue(candidateEducation.getLeavelOFEducation());
            setEducationID(candidateEducation.getCanEducID());
            txtCGPA.setValue(candidateEducation.getCgpa());
            txt_Instution.setValue(candidateEducation.getInstiution());
            txtGraduatedby.setValue(candidateEducation.getFiledOfStudy());
            txtYearOfGraduation.setValue(candidateEducation.getGraduationYear());
            drlLevelOfEducation.setDisabled(false);
            txtCGPA.setDisabled(false);
            txt_Instution.setDisabled(false);
            txtGraduatedby.setDisabled(false);
            txtYearOfGraduation.setDisabled(false);
            btn_AddEduc.setDisabled(false);
            btn_Educupdate.setDisabled(false);
            btn_Educdelete.setDisabled(false);

        }
        return null;
       
    }

    public String btn_Educupdate_action() {
        //return null means stay on the same page
         List candidateEducation = this.getListOfEducation();
                Iterator<CandidateEducationManager> iter = candidateEducation.iterator();
                boolean checkSave=false;
                while (iter.hasNext())
                {
            CandidateEducationManager saveExperiance = iter.next();
            checkSave  = candidateManager.UpdateCandidateEducation(saveExperiance);
                }
                 if (checkSave)
        {
            showSuccessOrFailureMessage(true, "The candidate Education Update  successfully !");
        } else {
            showSuccessOrFailureMessage(false, "ERROR ocured While Updating Education Informaton!");

        }

        return null;

    }

    public String btn_Educdelete_action() {
        //return null means stay on the same page
              educationID =candidateEducationList.get(selectedEducatuon).getCanEducID();
     boolean checkSave=  candidateManager.deleteCandidateEducation(educationID);
     candidateEducationList.remove(selectedEducatuon);
     if (checkSave)
        {
            showSuccessOrFailureMessage(true, "The candidate Education Deleted  successfully !");
        }
     else {
            showSuccessOrFailureMessage(false, "ERROR ocured While Deleting Education Informaton!");

        }


        return null;
            }
}

