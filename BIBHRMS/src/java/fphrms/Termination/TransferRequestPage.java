/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright 
 */
package fphrms.Termination;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.ColumnGroup;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputHidden;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.outputprogress.OutputProgress;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.RetirementLookUpManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.terminationManager.SearchCriterias;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.Appear;
import com.icesoft.faces.context.effects.Fade;
import com.icesoft.faces.context.effects.JavascriptContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
import javax.faces.component.UIInput;

import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.CommonValidation;
import manager.terminationManager.TransferManager;
import oracle.jdbc.rowset.OracleSerialBlob;
import lookUps.componentLists;
import manager.terminationManager.TransferApproveManager;
import manager.globalUseManager.LookUpManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TransferRequestPage extends AbstractPageBean
{

    AutoCompleteDictionary autoCompleteDictionary = new AutoCompleteDictionary();
    private static String fromDepartment;
    private static String toDepartment;
    private static String departmentId;
    ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    ArrayList<SelectItem> jobRank = new ArrayList<SelectItem>();
   ArrayList<SelectItem> payGradeOpt = new ArrayList<SelectItem>();
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getNewPayGrade() {
        return newPayGrade;
    }

    public void setNewPayGrade(String newPayGrade) {
        this.newPayGrade = newPayGrade;
    }

    public String getNewPoistion() {
        return newPoistion;
    }

    public void setNewPoistion(String newPoistion) {
        this.newPoistion = newPoistion;
    }

    public String getNewRankId() {
        return newRankId;
    }

    public void setNewRankId(String newRankId) {
        this.newRankId = newRankId;
    }

    public String getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(String newSalary) {
        this.newSalary = newSalary;
    }

    public String getSalaryChanaged() {
        return salaryChanaged;
    }

    public void setSalaryChanaged(String salaryChanaged) {
        this.salaryChanaged = salaryChanaged;
    }

    public ArrayList<SelectItem> getPayGradeOpt() {
        return payGradeOpt;
    }

    public void setPayGradeOpt(ArrayList<SelectItem> payGradeOpt) {
        this.payGradeOpt = payGradeOpt;
    }

    public ArrayList<SelectItem> getJobRank() {
        return jobRank;
    }

    public void setJobRank(ArrayList<SelectItem> jobRank) {
        this.jobRank = jobRank;
    }

 
    public ArrayList<SelectItem> getPerofation() {
        return perofation;
    }

    public void setPerofation(ArrayList<SelectItem> perofation) {
        this.perofation = perofation;
    }

    public String getCommentLanguage() {
        return commentLanguage;
    }

    public void setCommentLanguage(String commentLanguage) {
        this.commentLanguage = commentLanguage;
    }

    public ArrayList<SelectItem> getZerf() {
        zerf = departmentManage.getDepartmentName();
        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }

    public ArrayList<SelectItem> getDirectorate() {
        return directorate;
    }

    public void setDirectorate(ArrayList<SelectItem> directorate) {
        this.directorate = directorate;
    }

    public ArrayList<SelectItem> getDivision() {
        return division;
    }

    public void setDivision(ArrayList<SelectItem> division) {
        this.division = division;
    }

    public ArrayList<SelectItem> getMastebaberia() {
        return mastebaberia;
    }

    public void setMastebaberia(ArrayList<SelectItem> mastebaberia) {
        this.mastebaberia = mastebaberia;
    }

    public ArrayList<SelectItem> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<SelectItem> team) {
        this.team = team;
    }

    public byte[] getAttachedDBImg() {
        return attachedDBImg;
    }

    public void setAttachedDBImg(byte[] attachedDBImg) {
        this.attachedDBImg = attachedDBImg;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getSearchTerminationRequestValueTemp() {
        return searchTerminationRequestValueTemp;
    }

    public void setSearchTerminationRequestValueTemp(String searchTerminationRequestValueTemp) {
        this.searchTerminationRequestValueTemp = searchTerminationRequestValueTemp;
    }

    public String getSearchTerminationRequestValue() {
        return searchTerminationRequestValue;
    }

    public void setSearchTerminationRequestValue(String searchTerminationRequestValue) {
        this.searchTerminationRequestValue = searchTerminationRequestValue;
    }

    public String getGroupSettingDB() {
        return groupSettingDB;
    }

    public void setGroupSettingDB(String groupSettingDB) {
        this.groupSettingDB = groupSettingDB;
    }

    public String getGroup_setting_Main() {
        return group_setting_Main;
    }

    public void setGroup_setting_Main(String group_setting_Main) {
        this.group_setting_Main = group_setting_Main;
    }

    public String getGroup_SettingsDB() {
        return group_SettingsDB;
    }

    public void setGroup_SettingsDB(String group_SettingsDB) {
        this.group_SettingsDB = group_SettingsDB;
    }

    public static boolean isBtnNo() {
        return btnNo;
    }

    public static boolean isBtnOk() {
        return btnOk;
    }

    public static boolean isBtnYes() {
        return btnYes;
    }
    EmployeeManage currentEmployee = new EmployeeManage();
  // JobRank = lookUpManager.assignJobRank();
    public EmployeeManage getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(EmployeeManage currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private RetirementLookUpManager retirementLookUpManager = new RetirementLookUpManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private TransferManager transferManager = new TransferManager();
    private DepartmentManage departmentManage = new DepartmentManage();
    private LookUpManager lookUpManager = new LookUpManager();
    private static boolean btnYes = false;
    private static boolean btnNo = false;
    private static boolean btnOk = false;
    private String group_setting_Main;
    private String group_Setting;
    private String group_SettingsDB;
    private String groupSettingDB;
    private String searchTerminationRequestValue;
    private String searchTerminationRequestValueTemp;
    private String resignID = null;
    private String sex;
    public String salaryChanaged="No";
    public String promoted="No";
    public String newPoistion;
    public String newRankId;
    public String newPayGrade;
    public String newSalary;
    public String jobName;
    private static String selectedId;
    private static int messageStatus = 0;
    private static int tableSize = 0;
    private static int rowCounter = 0;
    private byte[] attachedDBImg;
    private ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> directorate = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> division = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> mastebaberia = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> team = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> terminationTypes = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> requestsLists = new ArrayList<SelectItem>();
    private ArrayList<HashMap> deletedAttachedDocuments = new ArrayList<HashMap>();
    private ArrayList<SelectItem> fromDepartmentList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> toDepartmentList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> transferTypes = new ArrayList<SelectItem>();
    private ResourceBundle messageResource = null;
    private ResourceBundle messageTermination = null;
    private FacesContext context = null;
    private String commentLanguage = null;
    private String loggedInUserId = null;
    String currenTDateToSet = "fromDate";
   
    private int requestId = 0;
    private byte[] employeePicture;
    private byte[] attachedDBImg1;




    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception
    {
       
   
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private componentLists male = new componentLists();

    public componentLists getMale() {
        return male;
    }

    public void setMale(componentLists uisi) {
        this.male = uisi;
    }
    private componentLists female = new componentLists();

    public componentLists getFemale() {
        return female;
    }

    public void setFemale(componentLists uisi) {
        this.male = uisi;
    }
    private HtmlSelectOneRadio rbtnSex = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRbtnSex() {
        return rbtnSex;
    }

    public void setRbtnSex(HtmlSelectOneRadio hsor) {
        this.rbtnSex = hsor;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems5() {
        return selectOneRadio1DefaultItems5;
    }

    public void setSelectOneRadio1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems6() {
        return selectOneRadio1DefaultItems6;
    }

    public void setSelectOneRadio1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems6 = dsia;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox1Bean1 = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean1() {
        return selectOneListbox1Bean1;
    }

    public void setSelectOneListbox1Bean1(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean1 = dsd;
    }
    private HtmlCommandButton modalPnlCloseBtn = new HtmlCommandButton();

    public HtmlCommandButton getModalPnlCloseBtn() {
        return modalPnlCloseBtn;
    }

    public void setModalPnlCloseBtn(HtmlCommandButton hcb) {
        this.modalPnlCloseBtn = hcb;
    }
    private PanelPopup pnlPopUpResignTye = new PanelPopup();

    public PanelPopup getPnlPopUpResignTye() {
        return pnlPopUpResignTye;
    }

    public void setPnlPopUpResignTye(PanelPopup pp) {
        this.pnlPopUpResignTye = pp;
    }
    private HtmlInputText txtResignationType = new HtmlInputText();

    public HtmlInputText getTxtResignationType() {
        return txtResignationType;
    }

    public void setTxtResignationType(HtmlInputText hit) {
        this.txtResignationType = hit;
    }
    private HtmlInputTextarea txtResignationTypeDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtResignationTypeDescription() {
        return txtResignationTypeDescription;
    }

    public void setTxtResignationTypeDescription(HtmlInputTextarea hit) {
        this.txtResignationTypeDescription = hit;
    }
    private HtmlInputHidden lblHResignationTypeID = new HtmlInputHidden();

    public HtmlInputHidden getLblHResignationTypeID() {
        return lblHResignationTypeID;
    }

    public void setLblHResignationTypeID(HtmlInputHidden hih) {
        this.lblHResignationTypeID = hih;
    }
    private HtmlCommandButton btnResignNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignNew() {
        return btnResignNew;
    }

    public void setBtnResignNew(HtmlCommandButton hcb) {
        this.btnResignNew = hcb;
    }
    private HtmlCommandButton btnResignEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignEdit() {
        return btnResignEdit;
    }

    public void setBtnResignEdit(HtmlCommandButton hcb) {
        this.btnResignEdit = hcb;
    }
    private HtmlCommandButton btnResignCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignCancel() {
        return btnResignCancel;
    }

    public void setBtnResignCancel(HtmlCommandButton hcb) {
        this.btnResignCancel = hcb;
    }
    private HtmlCommandButton btnResignDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnResignDelete() {
        return btnResignDelete;
    }

    public void setBtnResignDelete(HtmlCommandButton hcb) {
        this.btnResignDelete = hcb;
    }
    private HtmlSelectOneListbox lstResignationTyes = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstResignationTyes() {
        return lstResignationTyes;
    }

    public void setLstResignationTyes(HtmlSelectOneListbox hsol) {
        this.lstResignationTyes = hsol;
    }
    private HtmlSelectOneRadio ckbSex = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getCkbSex() {
        return ckbSex;
    }

    public void setCkbSex(HtmlSelectOneRadio hsor) {
        this.ckbSex = hsor;
    }
    private HtmlSelectOneMenu dplEmployeeID = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDplEmployeeID() {
        return dplEmployeeID;
    }

    public void setDplEmployeeID(HtmlSelectOneMenu hsom) {
        this.dplEmployeeID = hsom;
    }
    private HtmlInputTextarea txtReasonDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtReasonDescription() {
        return txtReasonDescription;
    }

    public void setTxtReasonDescription(HtmlInputTextarea hit) {
        this.txtReasonDescription = hit;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems = dsi;
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
    private HtmlSelectBooleanCheckbox cbMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCbMale() {
        return cbMale;
    }

    public void setCbMale(HtmlSelectBooleanCheckbox hsbc) {
        this.cbMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox cbFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCbFemale() {
        return cbFemale;
    }

    public void setCbFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.cbFemale = hsbc;
    }
    private HtmlCommandButton btnEditRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditRequest() {
        return btnEditRequest;
    }

    public void setBtnEditRequest(HtmlCommandButton hcb) {
        this.btnEditRequest = hcb;
    }
    private HtmlCommandButton btnCancelTerminationRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelTerminationRequest() {
        return btnCancelTerminationRequest;
    }

    public void setBtnCancelTerminationRequest(HtmlCommandButton hcb) {
        this.btnCancelTerminationRequest = hcb;
    }
    private HtmlCommandButton btnUpdateTerminationRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateTerminationRequest() {
        return btnUpdateTerminationRequest;
    }

    public void setBtnUpdateTerminationRequest(HtmlCommandButton hcb) {
        this.btnUpdateTerminationRequest = hcb;
    }
    private HtmlOutputText lblFullNameAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblFullNameAutoComplete() {
        return lblFullNameAutoComplete;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();
    private SelectInputDate calEffectiveFrom = new SelectInputDate();

    public SelectInputDate getCalEffectiveFrom() {
        return calEffectiveFrom;
    }

    public void setCalEffectiveFrom(SelectInputDate calEffectiveFrom) {
        this.calEffectiveFrom = calEffectiveFrom;
    }

    public SelectInputDateBean getSelectInputDateEffectiveFrom() {
        return selectInputDateEffectiveFrom;
    }

    public void setSelectInputDateEffectiveFrom(SelectInputDateBean selectInputDateEffectiveFrom) {
        this.selectInputDateEffectiveFrom = selectInputDateEffectiveFrom;
    }

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate calAppliedDate) {
        this.calAppliedDate = calAppliedDate;
    }
   private SelectInputDateBean selectInputDateAppliedDate = new SelectInputDateBean();

   private SelectInputDateBean selectInputDateEffectiveFrom = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateAppliedDate() {
        return selectInputDateAppliedDate;
    }

    public void setSelectInputDateAppliedDate(SelectInputDateBean selectInputDateAppliedDate) {
        this.selectInputDateAppliedDate = selectInputDateAppliedDate;
    }

    public void setLblFullNameAutoComplete(HtmlOutputText lblFullNameAutoComplete) {
        this.lblFullNameAutoComplete = lblFullNameAutoComplete;
    }
    private HtmlOutputText lblEmployeeIdAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeIdAutoComplete() {
        return lblEmployeeIdAutoComplete;
    }

    public void setLblEmployeeIdAutoComplete(HtmlOutputText lblEmployeeIdAutoComplete) {
        this.lblEmployeeIdAutoComplete = lblEmployeeIdAutoComplete;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    ArrayList<SelectItem> nameOptions = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getNameOptions() {
        return nameOptions;
    }
    ArrayList<SelectItem> autoComplete = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getAutoComplete() {
        return autoComplete;
    }

    public void setAutoComplete(ArrayList<SelectItem> autoComplete) {
        this.autoComplete = autoComplete;
    }

    public void setNameOptions(ArrayList<SelectItem> nameOptions) {
        this.nameOptions = nameOptions;
    }
    private SelectInputText txtEmployeeNameSearch = new SelectInputText();

    public SelectInputText getTxtEmployeeNameSearch() {
        return txtEmployeeNameSearch;
    }

    public void setTxtEmployeeNameSearch(SelectInputText sit) {
        this.txtEmployeeNameSearch = sit;
    }
    private PanelPopup pnlPopUpMsg = new PanelPopup();

    public PanelPopup getPnlPopUpMsg() {
        return pnlPopUpMsg;
    }

    public void setPnlPopUpMsg(PanelPopup pp) {
        this.pnlPopUpMsg = pp;
    }
    private HtmlOutputText lblPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMain() {
        return lblPopUpMsgMain;
    }

    public void setLblPopUpMsgMain(HtmlOutputText hot) {
        this.lblPopUpMsgMain = hot;
    }
    private HtmlOutputText lblStateStatus = new HtmlOutputText();

    public HtmlOutputText getLblStateStatus() {
        return lblStateStatus;
    }

    public void setLblStateStatus(HtmlOutputText hot) {
        this.lblStateStatus = hot;
    }
       public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    // private SelectInputText txtSearByName = new SelectInputText();

//    public SelectInputText getTxtSearByName() {
//        return txtSearByName;
//    }
//
//    public void setTxtSearByName(SelectInputText sit) {
//        this.txtSearByName = sit;
//    }
    //  private HtmlCommandButton btnPopUpYes = new HtmlCommandButton();

//    public HtmlCommandButton getBtnPopUpYes() {
//        return btnPopUpYes;
//    }
//
//    public void setBtnPopUpYes(HtmlCommandButton hcb) {
//        this.btnPopUpYes = hcb;
//    }
    private HtmlCommandButton btnPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpNo() {
        return btnPopUpNo;
    }

    public void setBtnPopUpNo(HtmlCommandButton hcb) {
        this.btnPopUpNo = hcb;
    }
    private HtmlGraphicImage gimgPopUpMsg = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgPopUpMsg() {
        return gimgPopUpMsg;
    }

    public void setGimgPopUpMsg(HtmlGraphicImage hgi) {
        this.gimgPopUpMsg = hgi;
    }
    private HtmlCommandButton btnNewTermination = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewTermination() {
        return btnNewTermination;
    }

    public void setBtnNewTermination(HtmlCommandButton hcb) {
        this.btnNewTermination = hcb;
    }
    private HtmlInputText txtCommentedByFullName = new HtmlInputText();

    public HtmlInputText getTxtCommentedByFullName() {
        return txtCommentedByFullName;
    }

    public void setTxtCommentedByFullName(HtmlInputText hit) {
        this.txtCommentedByFullName = hit;
    }
    private HtmlOutputLabel lblTerminationrequestEmployeeId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTerminationrequestEmployeeId() {
        return lblTerminationrequestEmployeeId;
    }

    public void setLblTerminationrequestEmployeeId(HtmlOutputLabel hol) {
        this.lblTerminationrequestEmployeeId = hol;
    }
    private HtmlInputText txtCommentedByPosition = new HtmlInputText();

    public HtmlInputText getTxtCommentedByPosition() {
        return txtCommentedByPosition;
    }

    public void setTxtCommentedByPosition(HtmlInputText hit) {
        this.txtCommentedByPosition = hit;
    }
    private HtmlInputTextarea txtRequestCommentedDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRequestCommentedDescription() {
        return txtRequestCommentedDescription;
    }

    public void setTxtRequestCommentedDescription(HtmlInputTextarea hit) {
        this.txtRequestCommentedDescription = hit;
    }
    private HtmlInputText txtCommentedByDateCommented = new HtmlInputText();

    public HtmlInputText getTxtCommentedByDateCommented() {
        return txtCommentedByDateCommented;
    }

    public void setTxtCommentedByDateCommented(HtmlInputText hit) {
        this.txtCommentedByDateCommented = hit;
    }
    private PanelPopup pnlPopUpRequestCommented = new PanelPopup();

    public PanelPopup getPnlPopUpRequestCommented() {
        return pnlPopUpRequestCommented;
    }

    public void setPnlPopUpRequestCommented(PanelPopup pp) {
        this.pnlPopUpRequestCommented = pp;
    }
    private HtmlInputText txtCommentedByDateProcessed = new HtmlInputText();

    public HtmlInputText getTxtCommentedByDateProcessed() {
        return txtCommentedByDateProcessed;
    }

    public void setTxtCommentedByDateProcessed(HtmlInputText hit) {
        this.txtCommentedByDateProcessed = hit;
    }
    private PanelPopup pnlPopUpRequestProcessed = new PanelPopup();

    public PanelPopup getPnlPopUpRequestProcessed() {
        return pnlPopUpRequestProcessed;
    }

    public void setPnlPopUpRequestProcessed(PanelPopup pp) {
        this.pnlPopUpRequestProcessed = pp;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectedData defaultSelectedData119 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData119() {
        return defaultSelectedData119;
    }

    public void setDefaultSelectedData119(DefaultSelectedData dsd) {
        this.defaultSelectedData119 = dsd;
    }
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private DefaultSelectedData defaultSelectedData14 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData14() {
        return defaultSelectedData14;
    }

    public void setDefaultSelectedData14(DefaultSelectedData dsd) {
        this.defaultSelectedData14 = dsd;
    }
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
    }
    private DefaultSelectedData defaultSelectedData120 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData120() {
        return defaultSelectedData120;
    }

    public void setDefaultSelectedData120(DefaultSelectedData dsd) {
        this.defaultSelectedData120 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbVoluntary = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbVoluntary() {
        return ckbVoluntary;
    }

    public void setCkbVoluntary(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbVoluntary = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbDismisalInvoluntary = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbDismisalInvoluntary() {
        return ckbDismisalInvoluntary;
    }

    public void setCkbDismisalInvoluntary(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbDismisalInvoluntary = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbLayOff = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbLayOff() {
        return ckbLayOff;
    }

    public void setCkbLayOff(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbLayOff = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbOtherInvoluntary = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbOtherInvoluntary() {
        return ckbOtherInvoluntary;
    }

    public void setCkbOtherInvoluntary(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbOtherInvoluntary = hsbc;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox4Bean() {
        return selectBooleanCheckbox4Bean;
    }

    public void setSelectBooleanCheckbox4Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox4Bean = dsd;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlOutputLabel lblTerminationrequestEmployeeId1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTerminationrequestEmployeeId1() {
        return lblTerminationrequestEmployeeId1;
    }

    public void setLblTerminationrequestEmployeeId1(HtmlOutputLabel hol) {
        this.lblTerminationrequestEmployeeId1 = hol;
    }
    private HtmlInputTextarea txtRequestProcessedDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRequestProcessedDescription() {
        return txtRequestProcessedDescription;
    }

    public void setTxtRequestProcessedDescription(HtmlInputTextarea hit) {
        this.txtRequestProcessedDescription = hit;
    }
    private HtmlInputText txtProcessedByFullName = new HtmlInputText();

    public HtmlInputText getTxtProcessedByFullName() {
        return txtProcessedByFullName;
    }

    public void setTxtProcessedByFullName(HtmlInputText hit) {
        this.txtProcessedByFullName = hit;
    }
    private HtmlInputText txtProcessedByPosition = new HtmlInputText();

    public HtmlInputText getTxtProcessedByPosition() {
        return txtProcessedByPosition;
    }

    public void setTxtProcessedByPosition(HtmlInputText hit) {
        this.txtProcessedByPosition = hit;
    }
    private HtmlInputText txtProcessedByDate = new HtmlInputText();

    public HtmlInputText getTxtProcessedByDate() {
        return txtProcessedByDate;
    }

    public void setTxtProcessedByDate(HtmlInputText hit) {
        this.txtProcessedByDate = hit;
    }
    private PanelPopup pnlPopUpAttachment = new PanelPopup();

    public PanelPopup getPnlPopUpAttachment() {
        return pnlPopUpAttachment;
    }

    public void setPnlPopUpAttachment(PanelPopup pp) {
        this.pnlPopUpAttachment = pp;
    }
    private OutputProgress attachmentProgress = new OutputProgress();

    public OutputProgress getAttachmentProgress() {
        return attachmentProgress;
    }

    public void setAttachmentProgress(OutputProgress op) {
        this.attachmentProgress = op;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlDataTable tblDocumentAttached = new HtmlDataTable();

    public HtmlDataTable getTblDocumentAttached() {
        return tblDocumentAttached;
    }

    public void setTblDocumentAttached(HtmlDataTable hdt) {
        this.tblDocumentAttached = hdt;
    }
    private ColumnGroup columnGroup1 = new ColumnGroup();

    public ColumnGroup getColumnGroup1() {
        return columnGroup1;
    }

    public void setColumnGroup1(ColumnGroup cg) {
        this.columnGroup1 = cg;
    }
    private HtmlCommandLink lnkDocumentAttached = new HtmlCommandLink();

    public HtmlCommandLink getLnkDocumentAttached() {
        return lnkDocumentAttached;
    }

    public void setLnkDocumentAttached(HtmlCommandLink hcl) {
        this.lnkDocumentAttached = hcl;
    }
    private HtmlGraphicImage gimgAttachedDocuments = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgAttachedDocuments() {
        return gimgAttachedDocuments;
    }

    public void setGimgAttachedDocuments(HtmlGraphicImage hgi) {
        this.gimgAttachedDocuments = hgi;
    }
    private HtmlCommandLink linkAction = new HtmlCommandLink();

    public HtmlCommandLink getLinkAction() {
        return linkAction;
    }

    public void setLinkAction(HtmlCommandLink hcl) {
        this.linkAction = hcl;
    }
    private PanelPopup pnlPopUpMsgConf = new PanelPopup();

    public PanelPopup getPnlPopUpMsgConf() {
        return pnlPopUpMsgConf;
    }

    public void setPnlPopUpMsgConf(PanelPopup pp) {
        this.pnlPopUpMsgConf = pp;
    }
    private HtmlOutputText lblPopUpMsgMainConf = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMainConf() {
        return lblPopUpMsgMainConf;
    }

    public void setLblPopUpMsgMainConf(HtmlOutputText hot) {
        this.lblPopUpMsgMainConf = hot;
    }
    private HtmlGraphicImage gimgPopUpMsgConf = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgPopUpMsgConf() {
        return gimgPopUpMsgConf;
    }

    public void setGimgPopUpMsgConf(HtmlGraphicImage hgi) {
        this.gimgPopUpMsgConf = hgi;
    }
    private HtmlCommandButton btnPopUpYesConf = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYesConf() {
        return btnPopUpYesConf;
    }

    public void setBtnPopUpYesConf(HtmlCommandButton hcb) {
        this.btnPopUpYesConf = hcb;
    }
    private HtmlCommandButton btnPopUpOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpOk() {
        return btnPopUpOk;
    }

    public void setBtnPopUpOk(HtmlCommandButton hcb) {
        this.btnPopUpOk = hcb;
    }
    private HtmlInputText txtCurrentDate = new HtmlInputText();

    public HtmlInputText getTxtCurrentDate() {
        return txtCurrentDate;
    }

    public void setTxtCurrentDate(HtmlInputText hit) {
        this.txtCurrentDate = hit;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel lblFormMessage) {
        this.lblFormMessage = lblFormMessage;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }
    private DateTimeConverter dateTimeConverter2 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter2() {
        return dateTimeConverter2;
    }

    public void setDateTimeConverter2(DateTimeConverter dtc) {
        this.dateTimeConverter2 = dtc;
    }
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }
    //End Of Local Variables
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }
    private DefaultSelectedData defaultSelectedData15 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData15() {
        return defaultSelectedData15;
    }

    public void setDefaultSelectedData15(DefaultSelectedData dsd) {
        this.defaultSelectedData15 = dsd;
    }
    private DefaultSelectedData defaultSelectedData16 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData16() {
        return defaultSelectedData16;
    }

    public void setDefaultSelectedData16(DefaultSelectedData dsd) {
        this.defaultSelectedData16 = dsd;
    }
    private DefaultSelectedData defaultSelectedData17 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData17() {
        return defaultSelectedData17;
    }

    public void setDefaultSelectedData17(DefaultSelectedData dsd) {
        this.defaultSelectedData17 = dsd;
    }
    private DefaultSelectedData defaultSelectedData18 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData18() {
        return defaultSelectedData18;
    }

    public void setDefaultSelectedData18(DefaultSelectedData dsd) {
        this.defaultSelectedData18 = dsd;
    }
    private HtmlOutputText lblSelectResignresign = new HtmlOutputText();

    public HtmlOutputText getLblSelectResignresign() {
        return lblSelectResignresign;
    }

    public void setLblSelectResignresign(HtmlOutputText hot) {
        this.lblSelectResignresign = hot;
    }
    private HtmlOutputLabel lblMsgProcessed = new HtmlOutputLabel();

    public HtmlOutputLabel getLblMsgProcessed() {
        return lblMsgProcessed;
    }

    public void setLblMsgProcessed(HtmlOutputLabel hol) {
        this.lblMsgProcessed = hol;
    }
    private HtmlOutputLabel lblMsgProcessed2 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblMsgProcessed2() {
        return lblMsgProcessed2;
    }

    public void setLblMsgProcessed2(HtmlOutputLabel hol) {
        this.lblMsgProcessed2 = hol;
    }
    private HtmlCommandButton btnNewTerminationPost = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewTerminationPost() {
        return btnNewTerminationPost;
    }

    public void setBtnNewTerminationPost(HtmlCommandButton hcb) {
        this.btnNewTerminationPost = hcb;
    }
    private DefaultSelectedData defaultSelectedData19 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData19() {
        return defaultSelectedData19;
    }

    public void setDefaultSelectedData19(DefaultSelectedData dsd) {
        this.defaultSelectedData19 = dsd;
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
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu4DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu4DefaultItems() {
        return selectOneMenu4DefaultItems;
    }

    public void setSelectOneMenu4DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu4DefaultItems = dsi;
    }
    private DefaultSelectedData defaultSelectedData23 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData23() {
        return defaultSelectedData23;
    }

    public void setDefaultSelectedData23(DefaultSelectedData dsd) {
        this.defaultSelectedData23 = dsd;
    }
    private DefaultSelectedData defaultSelectedData24 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData24() {
        return defaultSelectedData24;
    }

    public void setDefaultSelectedData24(DefaultSelectedData dsd) {
        this.defaultSelectedData24 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbDeath = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbDeath() {
        return ckbDeath;
    }

    public void setCkbDeath(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbDeath = hsbc;
    }
    private InputFile fileUploadAttached = new InputFile();

    public InputFile getFileUploadAttached() {
        return fileUploadAttached;
    }

    public void setFileUploadAttached(InputFile if0) {
        this.fileUploadAttached = if0;
    }
    private DefaultSelectedData defaultSelectedData121 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData121() {
        return defaultSelectedData121;
    }

    public void setDefaultSelectedData121(DefaultSelectedData dsd) {
        this.defaultSelectedData121 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private HtmlSelectOneMenu lstTransferType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstTransferType() {
        return lstTransferType;
    }

    public void setLstTransferType(HtmlSelectOneMenu hsom) {
        this.lstTransferType = hsom;
    }
    private DefaultSelectedData defaultSelectedData122 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData122() {
        return defaultSelectedData122;
    }

    public void setDefaultSelectedData122(DefaultSelectedData dsd) {
        this.defaultSelectedData122 = dsd;
    }

    public byte[] getAttachedDBImg1() {
        return attachedDBImg1;
    }

    public void setAttachedDBImg1(byte[] attachedDBImg1) {
        this.attachedDBImg1 = attachedDBImg1;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public ArrayList<SelectItem> getRequestsLists() {
        return requestsLists;
    }

    public void setRequestsLists(ArrayList<SelectItem> requestsLists) {
        this.requestsLists = requestsLists;
    }
    private DefaultSelectedData defaultSelectedData123 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData123() {
        return defaultSelectedData123;
    }

    public void setDefaultSelectedData123(DefaultSelectedData dsd) {
        this.defaultSelectedData123 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlSelectOneListbox lstRequestsList = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstRequestsList() {
        return lstRequestsList;
    }

    public void setLstRequestsList(HtmlSelectOneListbox hsol) {
        this.lstRequestsList = hsol;
    }
    private HtmlCommandButton btnDeleteTerminationRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteTerminationRequest() {
        return btnDeleteTerminationRequest;
    }

    public void setBtnDeleteTerminationRequest(HtmlCommandButton hcb) {
        this.btnDeleteTerminationRequest = hcb;
    }
    private HtmlCommandLink lnkAttachedRemove = new HtmlCommandLink();

    public HtmlCommandLink getLnkAttachedRemove() {
        return lnkAttachedRemove;
    }

    public void setLnkAttachedRemove(HtmlCommandLink hcl) {
        this.lnkAttachedRemove = hcl;
    }

    public ArrayList<HashMap> getDeletedAttachedDocuments() {
        return deletedAttachedDocuments;
    }

    public void setDeletedAttachedDocuments(ArrayList<HashMap> deletedAttachedDocuments) {
        this.deletedAttachedDocuments = deletedAttachedDocuments;
    }
    private DateTimeConverter dateTimeConverter3 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter3() {
        return dateTimeConverter3;
    }

    public void setDateTimeConverter3(DateTimeConverter dtc) {
        this.dateTimeConverter3 = dtc;
    }
    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(HtmlCommandButton hcb) {
        this.btnSearch = hcb;
    }
    private DefaultTableDataModel dataTable1Model2 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model2() {
        return dataTable1Model2;
    }

    public void setDataTable1Model2(DefaultTableDataModel dtdm) {
        this.dataTable1Model2 = dtdm;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlSelectBooleanCheckbox chkContrat = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkContrat() {
        return chkContrat;
    }

    public void setChkContrat(HtmlSelectBooleanCheckbox hsbc) {
        this.chkContrat = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkCivil = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkCivil() {
        return chkCivil;
    }

    public void setChkCivil(HtmlSelectBooleanCheckbox hsbc) {
        this.chkCivil = hsbc;
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
    private HtmlOutputText lblServiceYear = new HtmlOutputText();

    public HtmlOutputText getLblServiceYear() {
        return lblServiceYear;
    }

    public void setLblServiceYear(HtmlOutputText hot) {
        this.lblServiceYear = hot;
    }
    private HtmlOutputText lblRetireNumber = new HtmlOutputText();

    public HtmlOutputText getLblRetireNumber() {
        return lblRetireNumber;
    }

    public void setLblRetireNumber(HtmlOutputText hot) {
        this.lblRetireNumber = hot;
    }
    private HtmlOutputText lblHireDate = new HtmlOutputText();

    public HtmlOutputText getLblHireDate() {
        return lblHireDate;
    }

    public void setLblHireDate(HtmlOutputText hot) {
        this.lblHireDate = hot;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlOutputText lblAge = new HtmlOutputText();

    public HtmlOutputText getLblAge() {
        return lblAge;
    }

    public void setLblAge(HtmlOutputText hot) {
        this.lblAge = hot;
    }
    private HtmlGraphicImage employeePic = new HtmlGraphicImage();

    public HtmlGraphicImage getEmployeePic() {
        return employeePic;
    }

    public void setEmployeePic(HtmlGraphicImage hgi) {
        this.employeePic = hgi;
    }
    private PanelPopup pnlTransionHistory = new PanelPopup();

    public PanelPopup getPnlTransionHistory() {
        return pnlTransionHistory;
    }

    public void setPnlTransionHistory(PanelPopup pp) {
        this.pnlTransionHistory = pp;
    }
    private HtmlCommandButton btnRequesteDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnRequesteDate() {
        return btnRequesteDate;
    }

    public void setBtnRequesteDate(HtmlCommandButton hcb) {
        this.btnRequesteDate = hcb;
    }
    private DefaultSelectedData defaultSelectedData125 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData125() {
        return defaultSelectedData125;
    }

    public void setDefaultSelectedData125(DefaultSelectedData dsd) {
        this.defaultSelectedData125 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems7 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems7 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems9 = dsia;
    }
    private DefaultSelectedData defaultSelectedData126 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData126() {
        return defaultSelectedData126;
    }

    public void setDefaultSelectedData126(DefaultSelectedData dsd) {
        this.defaultSelectedData126 = dsd;
    }
    private HtmlOutputLabel lblFromdepartment = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFromdepartment() {
        return lblFromdepartment;
    }

    public void setLblFromdepartment(HtmlOutputLabel hol) {
        this.lblFromdepartment = hol;
    }
    private HtmlOutputLabel lblToDepartment = new HtmlOutputLabel();

    public HtmlOutputLabel getLblToDepartment() {
        return lblToDepartment;
    }

    public void setLblToDepartment(HtmlOutputLabel hol) {
        this.lblToDepartment = hol;
    }
    private HtmlSelectOneMenu lstFromDepartment = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstFromDepartment() {
        return lstFromDepartment;
    }

    public void setLstFromDepartment(HtmlSelectOneMenu hsom) {
        this.lstFromDepartment = hsom;
    }
    private HtmlSelectOneMenu lstToDepartment = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstToDepartment() {
        return lstToDepartment;
    }

    public void setLstToDepartment(HtmlSelectOneMenu hsom) {
        this.lstToDepartment = hsom;
    }

    public ArrayList<SelectItem> getFromDepartmentList() {
        fromDepartmentList = transferManager.readFromDpartment();
        return fromDepartmentList;
    }

    public void setFromDepartmentList(ArrayList<SelectItem> fromDepartmentList) {
        this.fromDepartmentList = fromDepartmentList;
    }

    public ArrayList<SelectItem> getToDepartmentList() {
        toDepartmentList = transferManager.readToDpartment();
        return toDepartmentList;
    }

    public void setToDepartmentList(ArrayList<SelectItem> toDepartmentList) {
        this.toDepartmentList = toDepartmentList;
    }
    private DefaultSelectedData defaultSelectedData127 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData127() {
        return defaultSelectedData127;
    }

    public void setDefaultSelectedData127(DefaultSelectedData dsd) {
        this.defaultSelectedData127 = dsd;
    }
    private DefaultSelectedData defaultSelectedData128 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData128() {
        return defaultSelectedData128;
    }

    public void setDefaultSelectedData128(DefaultSelectedData dsd) {
        this.defaultSelectedData128 = dsd;
    }
    private DefaultSelectedData defaultSelectedData129 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData129() {
        return defaultSelectedData129;
    }

    public void setDefaultSelectedData129(DefaultSelectedData dsd) {
        this.defaultSelectedData129 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkEnternalCrossDepartment = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkEnternalCrossDepartment() {
        return chkEnternalCrossDepartment;
    }

    public void setChkEnternalCrossDepartment(HtmlSelectBooleanCheckbox hsbc) {
        this.chkEnternalCrossDepartment = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkEnternalSameDepartment = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkEnternalSameDepartment() {
        return chkEnternalSameDepartment;
    }

    public void setChkEnternalSameDepartment(HtmlSelectBooleanCheckbox hsbc) {
        this.chkEnternalSameDepartment = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkExternal = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkExternal() {
        return chkExternal;
    }

    public void setChkExternal(HtmlSelectBooleanCheckbox hsbc) {
        this.chkExternal = hsbc;
    }
    private HtmlInputText txtEffectiveFrom = new HtmlInputText();

    public HtmlInputText getTxtEffectiveFrom() {
        return txtEffectiveFrom;
    }

    public void setTxtEffectiveFrom(HtmlInputText hit) {
        this.txtEffectiveFrom = hit;
    }
    private PanelLayout pnNotification = new PanelLayout();

    public PanelLayout getPnNotification() {
        return pnNotification;
    }

    public void setPnNotification(PanelLayout pl) {
        this.pnNotification = pl;
    }
    private DefaultSelectedData defaultSelectedData130 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData130() {
        return defaultSelectedData130;
    }

    public void setDefaultSelectedData130(DefaultSelectedData dsd) {
        this.defaultSelectedData130 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems10 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems10() {
        return selectOneMenu1DefaultItems10;
    }

    public void setSelectOneMenu1DefaultItems10(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems10 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems11 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems11() {
        return selectOneMenu1DefaultItems11;
    }

    public void setSelectOneMenu1DefaultItems11(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems11 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems12 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems12() {
        return selectOneMenu1DefaultItems12;
    }

    public void setSelectOneMenu1DefaultItems12(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems12 = dsia;
    }
    private DefaultSelectedData defaultSelectedData131 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData131() {
        return defaultSelectedData131;
    }

    public void setDefaultSelectedData131(DefaultSelectedData dsd) {
        this.defaultSelectedData131 = dsd;
    }
    private DefaultSelectedData defaultSelectedData132 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData132() {
        return defaultSelectedData132;
    }

    public void setDefaultSelectedData132(DefaultSelectedData dsd) {
        this.defaultSelectedData132 = dsd;
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
    private DefaultSelectedData defaultSelectedData133 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData133() {
        return defaultSelectedData133;
    }

    public void setDefaultSelectedData133(DefaultSelectedData dsd) {
        this.defaultSelectedData133 = dsd;
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
    private HtmlOutputLabel txtSalaryChage = new HtmlOutputLabel();

    public HtmlOutputLabel getTxtSalaryChage() {
        return txtSalaryChage;
    }

    public void setTxtSalaryChage(HtmlOutputLabel hol) {
        this.txtSalaryChage = hol;
    }
    private HtmlSelectOneMenu drl_profession = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_profession() {
        return drl_profession;
    }

    public void setDrl_profession(HtmlSelectOneMenu hsom) {
        this.drl_profession = hsom;
    }
    private HtmlSelectOneMenu drlPayGrade = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPayGrade() {
        return drlPayGrade;
    }

    public void setDrlPayGrade(HtmlSelectOneMenu hsom) {
        this.drlPayGrade = hsom;
    }
    private HtmlSelectOneMenu drlRankId = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRankId() {
        return drlRankId;
    }

    public void setDrlRankId(HtmlSelectOneMenu hsom) {
        this.drlRankId = hsom;
    }
    private HtmlSelectBooleanCheckbox chkSalaryChanaged = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkSalaryChanaged() {
        return chkSalaryChanaged;
    }

    public void setChkSalaryChanaged(HtmlSelectBooleanCheckbox hsbc) {
        this.chkSalaryChanaged = hsbc;
    }
    private HtmlOutputText out_txt_Position = new HtmlOutputText();

    public HtmlOutputText getOut_txt_Position() {
        return out_txt_Position;
    }

    public void setOut_txt_Position(HtmlOutputText hot) {
        this.out_txt_Position = hot;
    }
    private DefaultSelectedData defaultSelectedData134 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData134() {
        return defaultSelectedData134;
    }

    public void setDefaultSelectedData134(DefaultSelectedData dsd) {
        this.defaultSelectedData134 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkPromoted = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkPromoted() {
        return chkPromoted;
    }

    public void setChkPromoted(HtmlSelectBooleanCheckbox hsbc) {
        this.chkPromoted = hsbc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TransferRequestPage() {
        visible = false;
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


        loggedInUserId = getSessionBean1().getEmployeeId();
        txtCurrentDate.setValue(dateFormat.format(new Date()));
       // txtEffectiveFrom.setValue(dateFormat.format(new Date()));


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
//****************************************for pop up effects*****************
    private Boolean visible;
    private Object effectWindow;

    public Object getEffectWindow() {
        return effectWindow;
    }

    public void setEffectWindow(Object effectWindow) {
        this.effectWindow = effectWindow;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void openPopup() {
        effectWindow = new Appear();
    //    visible = true;
    }

    public void closePopup() {
        effectWindow = new Fade();
    //    visible = false;
    }

//Validation Patterns
    private void validateDateTime(FacesContext context, UIComponent component, Object value) {
        String patternName = "[0-9]\\{4\\}-[0-9]\\{2\\}-[0-9]\\{2\\}";
        boolean matchStringText = Pattern.matches(patternName, (CharSequence) (value.toString()));
        if (matchStringText == false) {
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            ((UIInput) component).setValid(false);
            error(component, messageResource.getString("ETdateVaild"));
        }
    }
    /////////////////
    ///////////////////////////////////////////////////////////////////
    //*************************************Document Attachement Inner Classes and Releted Methods and Variables *****************************************************
    ArrayList<HashMap> myDocuments = new ArrayList<HashMap>();
    private String attachedImage = "/SalaryDelegation/images/attachment.gif";
    private String imageFormat = "/SalaryDelegation/images/image.gif";
    private String fileFormat = "/SalaryDelegation/images/file.gif";
    private String attachedDocumentPath;
    private FileInfo currentFile;
    private int fileProgress;
    private String componentStatus;
    private ArrayList<FileAttachmentModel> readAttachedDocuments = new ArrayList<FileAttachmentModel>();
    public String empdepartmentID;

    public ArrayList<FileAttachmentModel> getReadAttachedDocuments() {
        return readAttachedDocuments;
    }

    public void setReadAttachedDocuments(ArrayList<FileAttachmentModel> readAttachedDocuments) {
        this.readAttachedDocuments = readAttachedDocuments;
    }
    private int selectedRow;

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public String getAttachedDocumentPath() {
        return attachedDocumentPath;
    }

    public void setAttachedDocumentPath(String attachedDocumentPath) {
        this.attachedDocumentPath = attachedDocumentPath;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public String getComponentStatus() {
        return componentStatus;
    }

    public void setComponentStatus(String componentStatus) {
        this.componentStatus = componentStatus;
    }

    public FileInfo getCurrentFile() {
        return currentFile;
    }

    public int getFileProgress() {
        return fileProgress;
    }

    public String getPromoted() {
        return promoted;
    }

    public void setPromoted(String promoted) {
        this.promoted = promoted;
    }
   
    ArrayList<FileAttachmentModel> fileAttachment = new ArrayList<FileAttachmentModel>();

    public ArrayList<FileAttachmentModel> getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(ArrayList<FileAttachmentModel> fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    public static class FileAttachmentModel implements Serializable {

        private String imageId;
        private String imageIcon;
        private String imageName;
        private String imagePath;

        public String getImageIcon() {
            return imageIcon;
        }

        public void setImageIcon(String imageIcon) {
            this.imageIcon = imageIcon;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public FileAttachmentModel(String imageId, String imageIcon, String imageName, String imagePath) {
            this.imageId = imageId;
            this.imageIcon = imageIcon;
            this.imageName = imageName;
            this.imagePath = imagePath;
        }

        public FileAttachmentModel(String imageIcon, String imageName, String imagePath) {
            this.imageIcon = imageIcon;
            this.imageName = imageName;
            this.imagePath = imagePath;
        }
    }

    public void uploadActionListener(ActionEvent actionEvent) {
    }

    /**
     * <p>This method is bound to the inputFile component and is executed
     * multiple times during the file upload process.  Every call allows
     * the user to finds out what percentage of the file has been uploaded.
     * This progress information can then be used with a progressBar component
     * for user feedback on the file upload progress. </p>
     *
     * @param event holds a InputFile object in its source which can be probed
     *              for the file upload percentage complete.
     */
    public void progressListener(EventObject event) {
        InputFile ifile = (InputFile) event.getSource();
        fileProgress = ifile.getFileInfo().getPercent();
    }

    //*************************************End OfDocument Attachement Inner Classes and Releted Methods and Variables *****************************************************
    private Option[] dpResignTypes;

    public Option[] getDpResignTypes() {
        return dpResignTypes;
    }

    public void setDpResignTypes(Option[] dpResignTypes) {
        this.dpResignTypes = dpResignTypes;
    }

    public ArrayList<SelectItem> getTransferTypes() {
        transferTypes = transferManager.readTransferTypeNew();
        return transferTypes;
    }

    public void setTransferTypes(ArrayList<SelectItem> transferTypes) {
        this.transferTypes = transferTypes;
    }
    private SearchCriterias serachIdName = new SearchCriterias();

    public SearchCriterias getSerachIdName() {
        return serachIdName;
    }

    public void setSerachIdName(SearchCriterias dsia) {
        this.serachIdName = dsia;
    }

    private void loadEmployeeProfileDetail(String empId) {
        try {
            lstFromDepartment.resetValue();
            employeeManager.loadEmpoyeeProfile(empId);
            lblFullName.setValue(employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            int age = employeeManager.calculateEmployeeAgeInYears(empId);
            lblAge.setValue(age);
            sex = employeeManager.getSex();
            lblRetireNumber.setValue(employeeManager.getRetirement_no());
            lblPosition.setValue(employeeManager.getJobName());
            int expYear = employeeManager.calculateEmployeeServiceYear(empId);
            lblServiceYear.setValue(String.valueOf(expYear));
            lblHireDate.setValue(employeeManager.getHire_Date());
            lblDepartment.setValue( ":" + "[ " +transferManager.readDepartmentDescrption(empId)+ " ]");
            lblFromdepartment.setValue(":" + "[ " + transferManager.readDepartmentDescrption(empId) + " ]");

            if (sex.equalsIgnoreCase("Male")) {
                cbMale.setSelected(true);
            } else if (sex.equalsIgnoreCase("Female")) {
                cbFemale.setSelected(true);
            } else {
                cbMale.setSelected(false);
                cbFemale.setSelected(false);
            }
            String employeeType = employeeManager.getOfficeOrShift();
            if (employeeType.equalsIgnoreCase("Clerical")) {
                chkCivil.setSelected(true);
            } else {
                chkContrat.setSelected(true);
            }
            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
            try {
                setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
                imgEmployeePicture.setValue(getAttachedDBImg());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
        }
    }

    public void modalPnlCloseBtn_processAction(ActionEvent ae) {
        pnlPopUpResignTye.setRendered(false);
    }

    public void lnkResignationType_processAction(ActionEvent ae) {
    }

    private void loadResignationTypeDetails(String _resignId) {
        ckbVoluntary.setSelected(false);
        ckbDismisalInvoluntary.setSelected(false);
        ckbLayOff.setSelected(false);
        ckbOtherInvoluntary.setSelected(false);
        ckbDeath.setSelected(false);

        HashMap terReq = retirementLookUpManager.readResignationTypeDetails(_resignId);
        txtResignationType.setValue(terReq.get("resignName"));
        txtResignationTypeDescription.setValue(terReq.get("resignDescription"));
        group_SettingsDB = (String) terReq.get("resignGroup");
        if (group_SettingsDB.equals("1")) {
            ckbVoluntary.setSelected(true);
        } else if (group_SettingsDB.equals("2")) {
            ckbDismisalInvoluntary.setSelected(true);
        } else if (group_SettingsDB.equals("3")) {
            ckbLayOff.setSelected(true);
        } else if (group_SettingsDB.equals("4")) {
            ckbOtherInvoluntary.setSelected(true);
        } else if (group_SettingsDB.equals("5")) {
            ckbDeath.setSelected(true);
        }

    }

    public void lstResignationTyes_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            resignID = vce.getNewValue().toString();
            lblHResignationTypeID.setValue(resignID);
            try {
                loadResignationTypeDetails(resignID);
            } catch (Exception ex) {
            }
        }
    }

    public void btnResignNew_processAction(ActionEvent ae) {
    }

    public void btnResignCancel_processAction(ActionEvent ae) {
    }

    public void btnResignSave_processAction(ActionEvent ae) {
    }

    public void btnResignEdit_processAction(ActionEvent ae) {
    }

    public void btnResignUpdate_processAction(ActionEvent ae) {
    }

    public void btnResignDelete_processAction(ActionEvent ae) {
    }

    private int CheckTerminationEmployeeId(String empId) {
        try {
            return transferManager.CheckIDFoundInRequestHistory(empId);
        } catch (Exception ex) {
            return 0;
        }
    }

    private int CheckEmployeeId(String empId) {
        try {
            return transferManager.CheckEmployeeId(empId);
        } catch (Exception ex) {
            return 0;
        }
    }

    public String txtSearByName_action()
    {
        getFileAttachment().clear();//clear the current uploaded file inorder to ignor data repeatition
        fileUploadAttached.setDisabled(true);
        selectedId = getSelectedEmployeeId();
        try {
            getRequestsLists().clear();//
            getFileAttachment().clear();
            lblDepartment.setValue(null);
            lblFullName.setValue(null);
            lblPosition.setValue(null);
            lblServiceYear.setValue(null);
            lblHireDate.setValue(null);
            lblServiceYear.setValue(null);
            lblAge.setValue(null);
            lblRetireNumber.setValue(null);
            cbMale.resetValue();
            cbFemale.resetValue();
            chkCivil.resetValue();
            chkContrat.resetValue();
            cbFemale.setSelected(false);
            cbMale.setSelected(false);
            chkCivil.setSelected(false);
            chkContrat.setSelected(false);
            txtEmployeeId.resetValue();
            imgEmployeePicture.setValue("");


            if (CheckTerminationEmployeeId(selectedId) == 1) {
                ArrayList<SelectItem> requests = transferManager.readRequestsList(selectedId);
                setRequestsLists(requests);
            // showSuccessOrFailureMessage(true, "INFO -" + txtSearByName.getValue().toString() + " made a request before.check the request before made list.");
            } else {
                txtEmployeeId.setValue(selectedId);
                loadEmployeeProfileDetail(selectedId);
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public void btnPopUpOk_processAction(ActionEvent ae) {
        // btnYes = true;
        btnYes = false;
        pnlPopUpMsg.setRendered(false);
    }

    public void btnPopUpYes_processAction(ActionEvent ae) {
        btnYes = true;
        if (btnYes == true) {
            pnlPopUpMsg.setRendered(false);
            this.loadEmployeeProfileDetail(selectedId);
            txtEmployeeId.setValue(selectedId);
            setSearchTerminationRequestValue(txtEmployeeId.getValue().toString());
            setSearchTerminationRequestValueTemp(txtEmployeeId.getValue().toString());
        }
    }

    public void btnPopUpNo_processAction(ActionEvent ae) {
        btnNo = true;
        if (btnNo == true) {
            pnlPopUpMsg.setRendered(false);
            txtEmployeeId.setValue(null);
            lblStateStatus.setValue(null);
            txtReasonDescription.setValue(null);
            //  dpResignationTypes.setValue("--- Select Resign Type ---");
            lblDepartment.setValue(null);
            lblFullName.setValue(null);
            lblPosition.setValue(null);
            lblServiceYear.setValue(null);
            lblHireDate.setValue(null);
            cbMale.setSelected(false);
            cbFemale.setSelected(false);
        }

    }

    public void hlnkRequestCommented_processAction(ActionEvent ae) {
    }

    public void modalPnlCloseBtnRequestCommented_processAction(ActionEvent ae) {
        pnlPopUpRequestCommented.setRendered(false);
    }

    public void modalPnlCloseBtnRequestProcessed_processAction(ActionEvent ae) {
        pnlPopUpRequestProcessed.setRendered(false);
    }

    public void lnkTerminationApprovalComment_processAction(ActionEvent ae) {
    }

    public void txtSearByName_processValueChange(ValueChangeEvent vce) {


        autoCompleteDictionary.init("", "", vce.getNewValue().toString());
        updateList(vce);

    }

    public String lnkTerminationApproval_action() {
        //return null means stay on the same page
        return "TerminationApproval";
    }

    public void ckbVoluntary_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbVoluntary.isSelected()) {
                ckbDismisalInvoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting = "1";
            }
        }
    }

    public void ckbDismisalInvoluntary_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbDismisalInvoluntary.isSelected()) {
                ckbVoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting = "2";
            }
        }
    }

    public void ckbLayOff_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbLayOff.isSelected()) {
                ckbVoluntary.setSelected(false);
                ckbDismisalInvoluntary.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting = "3";
            }
        }
    }

    public void ckbOtherInvoluntary_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbOtherInvoluntary.isSelected()) {
                ckbVoluntary.setSelected(false);
                ckbDismisalInvoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                group_Setting = "4";
            }
        }
    }

    public String btnResignCancel_action() {
        //return null means stay on the same page
        txtResignationType.setDisabled(true);
        txtResignationTypeDescription.setDisabled(true);
        lstResignationTyes.setDisabled(false);
        if (btnResignNew.getValue().equals("Save")) {
            txtResignationType.setValue(null);
            txtResignationTypeDescription.setValue(null);
            ckbVoluntary.setSelected(false);
            ckbDismisalInvoluntary.setSelected(false);
            ckbLayOff.setSelected(false);
            ckbOtherInvoluntary.setSelected(false);
            btnResignNew.setValue("New");
            ckbVoluntary.setDisabled(true);
            ckbDismisalInvoluntary.setDisabled(true);
            ckbLayOff.setDisabled(true);
            ckbOtherInvoluntary.setDisabled(true);
            ckbDeath.setDisabled(true);
            ckbDeath.setSelected(false);
            btnResignDelete.setDisabled(false);
            btnResignEdit.setDisabled(false);
            btnResignNew.setDisabled(false);
            btnResignCancel.setDisabled(true);
        } else if (btnResignEdit.getValue().equals("Update")) {
            btnResignDelete.setDisabled(false);
            btnResignEdit.setDisabled(false);
            btnResignNew.setDisabled(false);

            btnResignCancel.setDisabled(true);

            ckbVoluntary.setDisabled(true);
            ckbDismisalInvoluntary.setDisabled(true);
            ckbLayOff.setDisabled(true);
            ckbOtherInvoluntary.setDisabled(true);
            ckbDeath.setDisabled(true);
            btnResignEdit.setValue("Edit");
        }
        return null;
    }

    public String btnResignNew_action() {
        //return null means stay on the same page
        if (btnResignNew.getValue().equals("New")) {
            txtResignationType.setDisabled(false);
            txtResignationTypeDescription.setDisabled(false);
            lstResignationTyes.setDisabled(true);

            txtResignationType.setValue(null);
            txtResignationTypeDescription.setValue(null);

            btnResignDelete.setDisabled(true);
            btnResignEdit.setDisabled(true);
            btnResignCancel.setDisabled(false);
            ckbVoluntary.setSelected(false);
            ckbDismisalInvoluntary.setSelected(false);
            ckbLayOff.setSelected(false);
            ckbOtherInvoluntary.setSelected(false);
            ckbVoluntary.setDisabled(false);
            ckbDismisalInvoluntary.setDisabled(false);
            ckbLayOff.setDisabled(false);
            ckbOtherInvoluntary.setDisabled(false);
            ckbDeath.setDisabled(false);
            ckbDeath.setSelected(false);
            btnResignNew.setValue("Save");
        } else if (btnResignNew.getValue().equals("Save")) {
            String resignationType = null;
            String Resignationdscription = null;
            if (getTxtResignationType().getValue() != null) {
                resignationType = getTxtResignationType().getValue().toString();
            }
            if (getTxtResignationTypeDescription().getValue() != null) {
                Resignationdscription = getTxtResignationTypeDescription().getValue().toString();
            }
            try {
                if (resignationType != null) {
                    retirementLookUpManager.addNewTerminationType(resignationType,
                            Resignationdscription, group_Setting.toString());

                    txtResignationType.setDisabled(true);
                    txtResignationTypeDescription.setDisabled(true);
                    lstResignationTyes.setDisabled(false);
                    txtResignationType.setValue(null);
                    txtResignationTypeDescription.setValue(null);
                    btnResignDelete.setDisabled(false);
                    btnResignEdit.setDisabled(false);
                    btnResignCancel.setDisabled(true);
                    ckbVoluntary.setSelected(false);
                    ckbDismisalInvoluntary.setSelected(false);
                    ckbLayOff.setSelected(false);
                    ckbOtherInvoluntary.setSelected(false);
                    ckbDeath.setDisabled(true);
                    ckbDeath.setSelected(false);
                    ckbVoluntary.setDisabled(true);
                    ckbDismisalInvoluntary.setDisabled(true);
                    ckbLayOff.setDisabled(true);
                    ckbOtherInvoluntary.setDisabled(true);
                    btnResignNew.setValue("New");
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public void btnAttachDocument_processAction(ActionEvent ae) {
        pnlPopUpAttachment.setRendered(true);

    }

    public String tblDocumentAttached_firstPageAction() {
        {
            return null;
        }
    }

    public String tblDocumentAttached_previousPageAction() {
        {
            return null;
        }
    }

    public String tblDocumentAttached_nextPageAction() {
        {
            return null;
        }
    }

    public String tblDocumentAttached_lastPageAction() {
        {
            return null;
        }
    }

    public void modalPnlCloseBtnAttachment_processAction(ActionEvent ae) {
        pnlPopUpAttachment.setRendered(false);
    }

    public String lnkDocumentAttached_action() {
        selectedRow = tblDocumentAttached.getRowIndex();
        String documentId = String.valueOf(fileAttachment.get(selectedRow).imageId);
        try {
            HashMap terReq = transferManager.readAttachedDocuments(documentId);
            OracleSerialBlob blo = (OracleSerialBlob) terReq.get("docPath");
            setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
            gimgAttachedDocuments.setValue(getAttachedDBImg());
            pnlPopUpAttachment.setRendered(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void btnPopUpYesConf_processAction(ActionEvent ae) {
    }

    public void btnPopUpNoConf_processAction(ActionEvent ae) {
    }

    public String btnPopUpYes_action() {
        //return null means stay on the same page
        return null;
    }

    public static class StateTransitionIC implements Serializable {
    }

    public String btnNewTermination_action()
    {
        if (txtEmployeeId.getValue() != null) {

            if (CheckEmployeeId(txtEmployeeId.getValue().toString()) == 1) {
                loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
                tableSize = 0;
                rowCounter = 0;
                getRequestsLists().clear();//
                String currentDate = StringDateManipulation.toDayInEc();
                lstTransferType.resetValue();
                lstToDepartment.resetValue();
                lstTransferType.setValue("0");
                lstToDepartment.setValue("0");
                chkEnternalSameDepartment.setSelected(false);
                chkEnternalCrossDepartment.setSelected(false);
                chkExternal.setSelected(false);
                chkEnternalSameDepartment.setDisabled(false);
                chkEnternalCrossDepartment.setDisabled(false);
                chkExternal.setDisabled(false);
                txtEffectiveFrom.setValue(null);
                txtReasonDescription.setValue(null);
                lblStateStatus.setValue(null);
                fileUploadAttached.setDisabled(false);
                getFileAttachment().clear();
                btnRequesteDate.setDisabled(false);
                lstTransferType.setDisabled(false);
                lstToDepartment.setDisabled(false);
                txtCurrentDate.setDisabled(true);
                txtReasonDescription.setDisabled(false);
                btnNewTerminationPost.setDisabled(false);
                btnCancelTerminationRequest.setDisabled(false);
                btnNewTermination.setDisabled(true);
                btnEditRequest.setDisabled(true);
                btnUpdateTerminationRequest.setDisabled(true);
                btnDeleteTerminationRequest.setDisabled(true);
            } else {
                showSuccessOrFailureMessage(false, "Employee Id is not registered.Please try again.");
            }
        } else {
                showSuccessOrFailureMessage(false, "Please fill Employee Id first by using the search text field.");
        }

        return null;
    }

    public String btnEditRequest_action() {
        try {
            if (txtEmployeeId.getValue() != null) {

                fileUploadAttached.setDisabled(false);
                lnkAttachedRemove.setDisabled(false);
                btnRequesteDate.setDisabled(false);
                lstTransferType.setDisabled(false);
                txtCurrentDate.setDisabled(true);
                txtReasonDescription.setDisabled(false);

                chkEnternalSameDepartment.setDisabled(false);
                chkEnternalCrossDepartment.setDisabled(false);
                chkExternal.setDisabled(false);

                lstFromDepartment.setDisabled(false);
                lstToDepartment.setDisabled(false);
                txtEffectiveFrom.setDisabled(false);

                btnNewTerminationPost.setDisabled(true);
                btnCancelTerminationRequest.setDisabled(false);
                btnNewTermination.setDisabled(true);
                btnEditRequest.setDisabled(true);
                btnUpdateTerminationRequest.setDisabled(false);
                btnDeleteTerminationRequest.setDisabled(true);

            }
        } catch (Exception ex) {
        }
        return null;
    }

    public String calDateRequet_action() {
        //return null means stay on the same page
        return null;
    }

    public void txtDateRequest_validate(FacesContext context, UIComponent component, Object value) {
        //   validateDateTime(context, component, value);
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setVisible(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void notification(String messageToDisplay) {
        pnNotification.setRendered(true);
        String javaScriptText = "$j(document).ready(function(){" +
                " $j('#demo12').click(function() {" +
                " $j.growlUI('Transfer Notification', '" + messageToDisplay + "');" +
                "});" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    private HashMap RequestInfo()
           {
       
        departmentId = employeeManager.getDepartmentId();
        HashMap requestInfo = new HashMap();
        requestInfo.put("requesterId", txtEmployeeId.getValue().toString());
        requestInfo.put("transferType", lstTransferType.getValue().toString());
        requestInfo.put("dateRequest", txtCurrentDate.getValue().toString());
        requestInfo.put("fromDepartment", departmentId);
        requestInfo.put("effectiveFrom", txtEffectiveFrom.getValue().toString());
        requestInfo.put("status", TransferApproveManager.INITIAL_STATE_TRANSFER);
        if (chkExternal.isSelected())
        {
            requestInfo.put("toDepartment", txtEffectiveFrom.getValue().toString());
        } else {
            requestInfo.put("toDepartment", lstToDepartment.getValue().toString());
        }
        requestInfo.put("description", txtReasonDescription.getValue().toString());
        if (chkEnternalSameDepartment.isSelected()) {
            requestInfo.put("transferProcessType", "0");
        }
        if (chkEnternalCrossDepartment.isSelected()) {
            requestInfo.put("transferProcessType", "1");
        }
        if (chkExternal.isSelected()) {
            requestInfo.put("transferProcessType", "2");
        }
        if(chkPromoted.isSelected()){

         requestInfo.put("Promoted", "YES");


        }
        else{
        requestInfo.put("Promoted", "NO");

        }
        if(chkSalaryChanaged.isSelected())
        {
        requestInfo.put("newPayGrade", drlPayGrade.getValue().toString());
        requestInfo.put("newRankId", drlRankId.getValue().toString());
        requestInfo.put("newPosition", drl_profession.getValue().toString());
        requestInfo.put("newSalary", txtSalaryChage.getValue().toString());
        requestInfo.put("salaryChanged", "Yes");
        }
        else {
                      
        requestInfo.put("newPayGrade", employeeManager.getDrlPayGrade());
        requestInfo.put("newRankId", employeeManager.getRankId());
        requestInfo.put("newPosition",drl_profession.getValue().toString());
        requestInfo.put("newSalary", employeeManager.getSalary());
        requestInfo.put("salaryChanged", "NO");

        }
        return requestInfo;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       private HashMap RequestInfoForUpdate()
           {

        departmentId = employeeManager.getDepartmentId();
        HashMap requestInfo = new HashMap();
        requestInfo.put("transferRequestId", lstRequestsList.getValue().toString());
        requestInfo.put("requesterId", txtEmployeeId.getValue().toString());
        requestInfo.put("transferType", lstTransferType.getValue().toString());
        requestInfo.put("dateRequest", txtCurrentDate.getValue().toString());
        requestInfo.put("fromDepartment", departmentId);
        requestInfo.put("effectiveFrom", txtEffectiveFrom.getValue().toString());
        requestInfo.put("status", TransferApproveManager.INITIAL_STATE_TRANSFER);
        if (chkExternal.isSelected()) {
            requestInfo.put("toDepartment", txtEffectiveFrom.getValue().toString());
        } else {
            requestInfo.put("toDepartment", lstToDepartment.getValue().toString());
        }
        requestInfo.put("description", txtReasonDescription.getValue().toString());
        if (chkEnternalSameDepartment.isSelected()) {
            requestInfo.put("transferProcessType", "0");
        }
        if (chkEnternalCrossDepartment.isSelected()) {
            requestInfo.put("transferProcessType", "1");
        }
        if (chkExternal.isSelected()) {
            requestInfo.put("transferProcessType", "2");
        }
        if(chkSalaryChanaged.isSelected())
        {
        requestInfo.put("newPayGrade", drlPayGrade.getValue().toString());
        requestInfo.put("newRankId", drlRankId.getValue().toString());
        requestInfo.put("newPosition", drl_profession.getValue().toString());
        requestInfo.put("newSalary", txtSalaryChage.getValue().toString());
        requestInfo.put("salaryChanged", "Yes");

        }
        else{

        requestInfo.put("newPayGrade", employeeManager.getDrlPayGrade());
        requestInfo.put("newRankId", employeeManager.getRankId());
        requestInfo.put("newPosition",drl_profession.getValue().toString());
        requestInfo.put("newSalary", employeeManager.getSalary());
        requestInfo.put("salaryChanged", "NO");

        }
        return requestInfo;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private Set<HashMap> SupportiveInfo() {
        Set<HashMap> documentList = new HashSet<HashMap>();
        if (tblDocumentAttached.getRowCount() > 0) {
            for (FileAttachmentModel attached : getFileAttachment().subList(tableSize, tableSize + rowCounter)) {
                HashMap _list = new HashMap();
                _list.put("attachedName", attached.getImageName());
                _list.put("attachedPath", attached.getImagePath());
                documentList.add(_list);
            }

        }
        return documentList;
    }

    public String btnNewTerminationPost_action()

                {
      try             {
              this.RequestInfo();
       if (transferManager.postNewTransferRequest(RequestInfo(), SupportiveInfo()) == 1)
                      {
                RequestInfo().clear();
                lstTransferType.resetValue();
                txtCurrentDate.resetValue();
                txtReasonDescription.resetValue();
                lstResignationTyes.resetValue();
                lstTransferType.setValue("0");
                chkEnternalSameDepartment.setSelected(false);
                chkEnternalCrossDepartment.setSelected(false);
                chkExternal.setSelected(false);
                txtEffectiveFrom.setValue(null);
                chkEnternalSameDepartment.setDisabled(true);
                chkEnternalCrossDepartment.setDisabled(true);
                chkExternal.setDisabled(true);
                txtReasonDescription.setValue(null);
                lblStateStatus.setValue(null);
                fileUploadAttached.setDisabled(false);
                getFileAttachment().clear();
                btnRequesteDate.setDisabled(true);
                lstTransferType.setDisabled(true);
                txtCurrentDate.setDisabled(true);
                txtReasonDescription.setDisabled(true);
                btnNewTerminationPost.setDisabled(true);
                btnCancelTerminationRequest.setDisabled(true);
                btnNewTermination.setDisabled(false);
                btnEditRequest.setDisabled(true);
                btnUpdateTerminationRequest.setDisabled(true);
                btnDeleteTerminationRequest.setDisabled(true);
                showSuccessOrFailureMessage(true, "Employee Transfer request have been successfully posted.And need to be viewed by  authorized group or person.");

            } else {


                showSuccessOrFailureMessage(false, "Error Occured While posting Transfer Request.Please try again.");
            }

        } catch (Exception ex)
        {

        }


        return null;
    }

    public void btnCancelTerminationRequest_processAction(ActionEvent ae) {
    }

    public String btnCancelTerminationRequest_action() {

        txtEmployeeId.resetValue();
        lblFullName.setValue(null);
        lblDepartment.setValue(null);
        lblPosition.setValue(null);
        lblServiceYear.setValue(null);
        lblAge.setValue(null);
        lblRetireNumber.setValue(null);
        lblHireDate.setValue(null);

        lstTransferType.resetValue();
        txtCurrentDate.resetValue();
        txtReasonDescription.resetValue();
        lstResignationTyes.resetValue();

        chkCivil.setSelected(false);
        chkCivil.resetValue();
        chkContrat.setSelected(false);
        chkContrat.resetValue();


        chkEnternalSameDepartment.setDisabled(true);
        chkEnternalCrossDepartment.setDisabled(true);
        chkExternal.setDisabled(true);
        txtEffectiveFrom.setValue(null);

        chkEnternalSameDepartment.setSelected(false);
        chkEnternalCrossDepartment.setSelected(false);
        chkExternal.setSelected(false);

        cbFemale.setSelected(false);
        cbFemale.resetValue();
        cbMale.setSelected(false);
        cbMale.resetValue();
        imgEmployeePicture.setValue("");
        lstTransferType.setValue("0");
        txtReasonDescription.setValue(null);
        lblStateStatus.setValue(null);


        fileUploadAttached.setDisabled(false);
        getFileAttachment().clear();

        btnRequesteDate.setDisabled(true);
        lstTransferType.setDisabled(true);
        txtCurrentDate.setDisabled(true);
        txtReasonDescription.setDisabled(true);




        btnNewTerminationPost.setDisabled(true);
        btnCancelTerminationRequest.setDisabled(true);
        btnNewTermination.setDisabled(false);
        btnEditRequest.setDisabled(true);
        btnUpdateTerminationRequest.setDisabled(true);
        btnDeleteTerminationRequest.setDisabled(true);

        return null;
    }
//
//    public void UpdateTransferRequest()
//    {
//
//     this.RequestInfo();
//
//    int tranResult=transferManager.UpdateTransferRequest(this.RequestInfo());
//
//
//    }

    public String btnUpdateTerminationRequest_action()
    {
        try {
            String processType = "-1";
            String toDepartment = null;
            if (chkEnternalSameDepartment.isSelected()) {
                processType = "0";
                toDepartment = lstToDepartment.getValue().toString();
            }

            if (chkEnternalCrossDepartment.isSelected()) {
                processType = "1";
                toDepartment = lstToDepartment.getValue().toString();
            }

            if (chkExternal.isSelected()) {
                processType = "2";
                if (txtEffectiveFrom.getValue() != null) {
                    //toDepartment = txtEffectiveFrom.getValue().toString();
                }
            }

            if (!processType.equalsIgnoreCase("-1"))
                      {
                if (transferManager.updateTerminationRequest(
                        RequestInfoForUpdate(),
                        SupportiveInfo(),
                        getDeletedAttachedDocuments()) == 1)
                         {
                    showSuccessOrFailureMessage(true, "Your request has been successfully updated.");
                    rowCounter = 0;
                    SupportiveInfo().clear();
                    getDeletedAttachedDocuments().clear();
                    fileUploadAttached.setDisabled(true);
//                    lnkAttachedRemove.setDisabled(true);
                    btnRequesteDate.setDisabled(true);
                    lstTransferType.setDisabled(true);

                    chkEnternalSameDepartment.setDisabled(true);
                    chkEnternalCrossDepartment.setDisabled(true);
                    chkExternal.setDisabled(true);

                    lstFromDepartment.setDisabled(true);
                    lstToDepartment.setDisabled(true);

                    txtCurrentDate.setDisabled(true);
                    txtReasonDescription.setDisabled(true);

                    btnNewTerminationPost.setDisabled(true);
                    btnCancelTerminationRequest.setDisabled(true);
                    btnNewTermination.setDisabled(false);
                    btnEditRequest.setDisabled(true);
                    btnUpdateTerminationRequest.setDisabled(true);
                    btnDeleteTerminationRequest.setDisabled(true);

                }
                else {
                    showSuccessOrFailureMessage(false, "Error occured while updating your request.Sorry try again.");
                }

            } else {
                showSuccessOrFailureMessage(false, "Please select one transfer process type from the check box listed.");
            }

        } catch (Exception ex) {
        }
        return null;
    }

    public void ddRTypes_processValueChange(ValueChangeEvent vce) {
    }
    EmployeeList currentEmployee1 = new EmployeeList("", "0", null);

    public EmployeeList getCurrentEmployee1() {
        return currentEmployee1;
    }
    private String selectedEmployeeId;

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }
    List matchesList = new ArrayList<SelectItem>();

    public List getList() {
        return matchesList;
    }

    public void updateList(ValueChangeEvent event) {
        try {
//        // get a new list of matches.
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

    private void setMatches(ValueChangeEvent event) {
        Object searchWord = event.getNewValue();
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);
        try {
            int insert = Collections.binarySearch(autoCompleteDictionary.dictionary, searchWord, autoCompleteDictionary.LABEL_COMPARATOR);
            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }

            for (int i = 0; i <
                    maxMatches; i++) {
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

    public String lnkResignationType_action() {
        //return null means stay on the same page
        pnlPopUpResignTye.setRendered(true);
        pnlPopUpResignTye.setVisible(true);
        return null;
    }

    public void ckbDeath_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (ckbDeath.isSelected()) {
                ckbDismisalInvoluntary.setSelected(false);
                ckbLayOff.setSelected(false);
                ckbVoluntary.setSelected(false);
                ckbOtherInvoluntary.setSelected(false);
                group_Setting = "5";
            }

        }
    }

    public String btnResignEdit_action() {
        if (btnResignEdit.getValue().equals("Edit") && txtResignationType.getValue() != null) {
            txtResignationType.setDisabled(false);
            group_Setting =
                    group_SettingsDB;
            txtResignationTypeDescription.setDisabled(false);
            lstResignationTyes.setDisabled(true);
            btnResignDelete.setDisabled(true);
            btnResignNew.setDisabled(true);
            btnResignCancel.setDisabled(false);
            ckbVoluntary.setDisabled(false);
            ckbDismisalInvoluntary.setDisabled(false);
            ckbLayOff.setDisabled(false);
            ckbOtherInvoluntary.setDisabled(false);
            ckbDeath.setDisabled(false);

            btnResignEdit.setValue("Update");
        } else if (btnResignEdit.getValue().equals("Update")) {
            try {
                retirementLookUpManager.updateTerminationType(lblHResignationTypeID.getValue().toString(),
                        txtResignationType.getValue().toString(),
                        txtResignationTypeDescription.getValue().toString(), group_Setting.toString());
                txtResignationType.setDisabled(true);
                txtResignationTypeDescription.setDisabled(true);
                lstResignationTyes.setDisabled(false);
                btnResignDelete.setDisabled(false);
                btnResignNew.setDisabled(false);
                btnResignCancel.setDisabled(true);

                ckbVoluntary.setDisabled(true);
                ckbDismisalInvoluntary.setDisabled(true);
                ckbLayOff.setDisabled(true);
                ckbOtherInvoluntary.setDisabled(true);
                ckbDeath.setDisabled(true);

                btnResignEdit.setValue("Edit");
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public String btnResignDelete_action() {
        //return null means stay on the same page
        try {
            retirementLookUpManager.DeleteTerminationType(lblHResignationTypeID.getValue().toString());
            txtResignationType.setValue(null);
            txtResignationTypeDescription.setValue(null);
            ckbVoluntary.setSelected(false);
            ckbDismisalInvoluntary.setSelected(false);
            ckbLayOff.setSelected(false);
            ckbOtherInvoluntary.setSelected(false);
        } catch (Exception ex) {
        }
        return null;
    }

    public void fileUploadAttached_processAction(ActionEvent ae) {
        try {
            String fileIcon = "";
            int memoryReservation = 0;
            while (memoryReservation < 20000) {
                InputFile inputFile = (InputFile) ae.getSource();
                currentFile =inputFile.getFileInfo();
                memoryReservation++;

            }
            File f = new File(currentFile.getPhysicalPath());
            getFileAttachment().add(new FileAttachmentModel(attachedImage, currentFile.getFileName(), currentFile.getPhysicalPath()));
            rowCounter++;

        } catch (Exception ex) {
        }
    }

    public void fileUploadAttached_processMyEvent(EventObject eventObject) {
    }

    public String fileUploadAttached_action() {
        //return null means stay on the same page
        return null;
    }

    public String  PositionName(String jobCode)
    {

     jobName=transferManager.getJobName(jobCode);

     return jobName;
    }

    /**
     * <p>load the request detail</p>.
     * @param vce is the new value of request id.
     */
    public void lstRequestsList_processValueChange(ValueChangeEvent vce) {



        try {
            if (!CommonValidation.isUpdatePhase(vce))
                  {
                if (vce.getNewValue() != null) {//check for request id is defferent from null.
                    rowCounter = 0;//set the row counter to 0 for document attached table.
                    this.requestId = Integer.valueOf(vce.getNewValue().toString());//set the current request id.
                    //reset local components
                    txtEmployeeId.resetValue();
                    lstTransferType.resetValue();
                    lstFromDepartment.resetValue();
                    lstToDepartment.resetValue();
                    txtCurrentDate.resetValue();
                    txtReasonDescription.resetValue();
                    lstResignationTyes.resetValue();
                    chkEnternalSameDepartment.resetValue();
                    chkEnternalCrossDepartment.resetValue();
                    chkExternal.resetValue();
                    chkEnternalSameDepartment.setSelected(false);
                    chkEnternalCrossDepartment.setSelected(false);
                    chkExternal.setSelected(false);
                    txtEffectiveFrom.setValue(null);
                    lstTransferType.setValue("0");
                    lstFromDepartment.setValue("0");
                    lstToDepartment.setValue("0");
                    txtReasonDescription.setValue(null);
                    lblStateStatus.setValue(null);
                    fileUploadAttached.setDisabled(true);
                    getFileAttachment().clear();
                    btnRequesteDate.setDisabled(true);
                    lstTransferType.setDisabled(true);
                    lstFromDepartment.setDisabled(true);
                    lstToDepartment.setDisabled(true);
                    txtCurrentDate.setDisabled(true);
                    txtReasonDescription.setDisabled(true);
                    btnNewTerminationPost.setDisabled(true);
                    btnCancelTerminationRequest.setDisabled(true);
                    btnNewTermination.setDisabled(false);
                    btnEditRequest.setDisabled(true);
                    btnUpdateTerminationRequest.setDisabled(true);
                    btnDeleteTerminationRequest.setDisabled(true);

                    HashMap hm = transferManager.ReadRequestsInfo(String.valueOf(this.requestId));//load the request info from manager.
                    if (hm != null) {//check the returned hash map from manager is not null.
                        lstTransferType.resetValue();
                        txtCurrentDate.resetValue();
                        txtReasonDescription.resetValue();
                        lblStateStatus.setValue(null);

                        if (!hm.get("status").toString().equalsIgnoreCase("50"))
                        {
                            showSuccessOrFailureMessage(false, "INFO - This request is on read only state,Only view is enabled.");
                        } else {
                            //     notification("Your Request Is Not Yet Approved !");
                            btnEditRequest.setDisabled(false);
                            btnDeleteTerminationRequest.setDisabled(false);
                        }
                        txtEmployeeId.setValue(hm.get("requesterId").toString());
                        lstTransferType.setValue(hm.get("requesttypeId").toString());
                        lstFromDepartment.setValue(hm.get("fromDepartment").toString());
                        lblFromdepartment.setValue(departmentManage.traceDepartemnt(hm.get("fromDepartment").toString()));
                        drlPayGrade.setValue(hm.get("newPayGrade").toString());
                        drlRankId.setValue(hm.get("newRank").toString());
                        out_txt_Position.setValue(this.PositionName(hm.get("newPosition").toString()));
                        txtSalaryChage.setValue(hm.get("newSalary").toString());
                      

                        if (hm.get("transferProcessType").toString().equalsIgnoreCase("0"))
                        {
                            chkEnternalSameDepartment.setSelected(true);
                            lstToDepartment.setValue(hm.get("toDepartment").toString());
                            lblToDepartment.setValue(departmentManage.traceDepartemnt(hm.get("toDepartment").toString()));
                            drl_profession.setValue(hm.get("newPosition").toString());
                             txtEffectiveFrom.setValue(hm.get("effectiveFrom").toString());
                        } else if (hm.get("transferProcessType").toString().equalsIgnoreCase("1")) {
                            chkEnternalCrossDepartment.setSelected(true);
                            lstToDepartment.setValue(hm.get("toDepartment").toString());
                            lblToDepartment.setValue(departmentManage.traceDepartemnt(hm.get("toDepartment").toString()));
                            txtEffectiveFrom.setValue(hm.get("effectiveFrom").toString());
                           
                            drl_profession.setValue(Integer.parseInt((hm.get("newPosition").toString())));
                        } else if (hm.get("transferProcessType").toString().equalsIgnoreCase("2"))
                        {
                            chkExternal.setSelected(true);
                            txtEffectiveFrom.setValue(hm.get("toDepartment").toString());
                            drl_profession.setValue(hm.get("newPosition").toString());
                            txtEffectiveFrom.setValue(hm.get("effectiveFrom").toString());
                        }
                        txtCurrentDate.setValue(hm.get("dateRequested").toString());
                        txtReasonDescription.setValue(hm.get("description"));

                       if(hm.get("promoted").toString().equalsIgnoreCase("YES")){

                       chkPromoted.setSelected(true);

                       }
//                       lblStateStatus.setValue(" -[ " + hm.get("stateName").toString() + " ]" + " Owner Group " + "-[ " + hm.get("ownerName").toString() + " ]");

                        //load supportive information attached.this document is attached picture.
                        ArrayList<HashMap> attachedDocumentsList = transferManager.ReadSupportiveInfo(vce.getNewValue().toString());
                        if (attachedDocumentsList != null) {
                            tableSize = 0;//set the table size to 0 inorder to identify new row added during update.
                            for (HashMap hm1 : attachedDocumentsList) {
                                //add the attached image info to the inner class binded as a value to the table
                                getFileAttachment().add(new FileAttachmentModel(hm1.get("docId").toString(), attachedImage, hm1.get("docName").toString(), hm1.get("docPath").toString()));
                                tableSize++;//increament the table size while for each looping by 1.finaly the table size is known.

                            }


                        }
                        lblDepartment.setValue(null);
                        lblFullName.setValue(null);
                        lblPosition.setValue(null);
                        lblServiceYear.setValue(null);
                        lblHireDate.setValue(null);
                        loadEmployeeProfileDetail(hm.get("requesterId").toString());


                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public String lnkAttachedRemove_action() {
        int rowIndex = tblDocumentAttached.getRowIndex();
        String docId = String.valueOf(getFileAttachment().get(rowIndex).imageId);
        try {

            HashMap seleded = new HashMap();
            seleded.put("deleted", docId.toString());
            getDeletedAttachedDocuments().add(seleded);
            getFileAttachment().remove(rowIndex);
            tableSize--;
//  rowCounter--;

        } catch (Exception ex) {
        }
        return null;
    }

    public void lstTransferType_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                //   requestType = Integer.valueOf(vce.getNewValue().toString());
            }
        }
    }

    public String btnSearch_action()
    {
        try {
            if (txtEmployeeId.getValue() != null)
            {
                getRequestsLists().clear();//
                getFileAttachment().clear();
                lblDepartment.setValue(null);
                lblFullName.setValue(null);
                lblPosition.setValue(null);
                lblServiceYear.setValue(null);
                lblHireDate.setValue(null);
                lblServiceYear.setValue(null);
                lblAge.setValue(null);
                lblRetireNumber.setValue(null);
                cbMale.resetValue();
                cbFemale.resetValue();
                chkCivil.resetValue();
                chkContrat.resetValue();
                cbFemale.setSelected(false);
                cbMale.setSelected(false);
                chkCivil.setSelected(false);
                chkContrat.setSelected(false);
                lblFromdepartment.setValue(null);
                lblToDepartment.setValue(null);
                //    imgEmployeePicture.setValue("/Employee/images/blank.gif");

                if (CheckTerminationEmployeeId(txtEmployeeId.getValue().toString()) == 1)
                {
                    ArrayList<SelectItem> requests = transferManager.readRequestsList(txtEmployeeId.getValue().toString());
                    getRequestsLists().clear();//
                    setRequestsLists(requests);
//                    showSuccessOrFailureMessage(true, "INFO -" + txtSearByName.getValue().toString() + " made a request before.check the request before made list.");
                     String deptPath=transferManager.readDepartmentDescrption(txtEmployeeId.getValue().toString());
                      String[] emplDeptID= deptPath.split("--");
                      empdepartmentID=emplDeptID[1];
                    
                    loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
                } else {
                    if (CheckEmployeeId(txtEmployeeId.getValue().toString()) == 1)
                    {
                      String deptPath=transferManager.readDepartmentDescrption(txtEmployeeId.getValue().toString());
                      String[] emplDeptID= deptPath.split("--");
                      empdepartmentID=emplDeptID[1];

                        loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
                    } else {
                        showSuccessOrFailureMessage(false, "Employee Id is not registered.Please try again.");
                    }

                }
            } else {
                showSuccessOrFailureMessage(true, "Please enter employee id ?");
            }

        } catch (Exception ex) {
        }
        return null;
    }

   
    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public String btnTransionHistoryClose_action() {
        //return null means stay on the same page
        pnlTransionHistory.setRendered(false);
        return null;
    }

    public String lnkRequestPeriod_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkResignTypeSetting_action() {
        pnlPopUpResignTye.setRendered(true);
        return null;
    }

    public String lnkResignRequest_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkRetireRequest_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkResignApprove_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkRetireApprove_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkTerminationClearance_action() {
        //return null means stay on the same page
        return "TerminationClearance";
    }

    public String lnkTerminationReports_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkResignApprovePage_action() {
        //return null means stay on the same page
        return "TransferApprove";
    }

    public String lnkClearancePage_action() {
        //return null means stay on the same page
        return "TerminationClearance";
    }

    public void lstFromDepartment_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                String departmentDescription = departmentManage.traceDepartemnt(vce.getNewValue().toString());
                lblFromdepartment.setValue(departmentDescription);
            }

        }
    }

    public void lstToDepartment_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce))
        {
            if (vce.getNewValue() != null)
            {
                
                String departmentDescription = departmentManage.traceDepartemnt(vce.getNewValue().toString());
                lblToDepartment.setValue("[:"+departmentDescription+"]");
                this.setPerofation(departmentManage.readJobCode(vce.getNewValue().toString()));
                this.setJobRank(lookUpManager.assignJobRank());
            }
            else{
            this.setPerofation(departmentManage.onDisplayJob());
            }

        }
    }

    public void chkEnternalSameDepartment_processValueChange(ValueChangeEvent vce)
    {
//        if (!CommonValidation.isUpdatePhase(vce))
//                              {
            if (chkEnternalSameDepartment.isSelected()) 
                          {
                lstToDepartment.setValue(empdepartmentID);
                this.setPerofation(departmentManage.readJobCode(empdepartmentID));
                drl_profession.setValue(this.getPerofation());
                this.setJobRank(lookUpManager.assignJobRank());
                chkEnternalCrossDepartment.setSelected(false);
                chkExternal.setSelected(false);
                txtEffectiveFrom.setDisabled(false);
                //txtEffectiveFrom.setValue(null);
                lstToDepartment.setDisabled(false);
            }

      //  }
    }

    public void chkEnternalCrossDepartment_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (chkEnternalCrossDepartment.isSelected()) {
                chkEnternalSameDepartment.setSelected(false);
                chkExternal.setSelected(false);
                lstToDepartment.setDisabled(false);
            }

        }
    }

    public void chkExternal_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (chkExternal.isSelected()) {
                chkEnternalCrossDepartment.setSelected(false);
                chkEnternalSameDepartment.setSelected(false);
                txtEffectiveFrom.setDisabled(false);
                lstToDepartment.setDisabled(true);
                lstToDepartment.setValue("0");
            }
        }
    }

    public void drlRankId_processValueChange(ValueChangeEvent vce) {
         if (vce.getNewValue() != null) {
          drlPayGrade.setDisabled(false);
          this.setPayGradeOpt(lookUpManager.readPayGrade(drlRankId.getValue().toString()));
        }
    }

    public void drlPayGrade_processValueChange(ValueChangeEvent vce) {
         if (vce.getNewValue() != null) {
           // txtSalary.setDisabled(false);
            txtSalaryChage.setValue(lookUpManager.readSalary(drlRankId.getValue().toString(), drlPayGrade.getValue().toString()));
        }
    }

    public void chkSalaryChanaged_processValueChange(ValueChangeEvent vce) {
        salaryChanaged="Yes";
        drlRankId.setDisabled(false);
        drlPayGrade.setDisabled(false);
        }
        public void calAppliedDate_processValueChange(ValueChangeEvent vce)
              {
           txtEffectiveFrom.setValue(dateFormat.format(calEffectiveFrom.getValue()));
           txtEffectiveFrom.setRendered(false);

             }

    public String button1_action() {
        //return null means stay on the same page
        calEffectiveFrom.setRendered(true);
        return null;
    }

        public void calEffectiveDate_processValueChange(ValueChangeEvent vce) {
        txtEffectiveFrom.setValue(dateFormat.format(calEffectiveFrom.getValue()));
       // dateOfOffence = dateFormat.format(calOffenceDate.getValue());
        calEffectiveFrom.setRendered(false);
    }

    public void chkPromoted_processValueChange(ValueChangeEvent vce)
    {
        promoted="Yes";
        drlRankId.setDisabled(false);
        drlPayGrade.setDisabled(false);
    }


}

