/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
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
import lookUps.componentLists;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.terminationManager.SearchCriterias;
import manager.terminationManager.TerminationManager;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.context.effects.Appear;
import com.icesoft.faces.context.effects.Fade;
import com.icesoft.faces.context.effects.JavascriptContext;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Pattern;
import javax.faces.component.UIInput;
import manager.departmentManage.DepartmentManage;
import oracle.sql.BLOB;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class RetireRequestPage extends AbstractPageBean {

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



    public static boolean isBtnYes() {
        return btnYes;
    }


    EmployeeManage currentEmployee = new EmployeeManage();

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
    private TerminationManager terminationManager = new TerminationManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private DepartmentManage departmentManage = new DepartmentManage();
    private static boolean btnYes = false;
    private static boolean btnNo = false;
    private static boolean btnOk = false;
    private String EmployeeTerminationCommentedTemp = null;
    private String EmployeeTerminationProcessedIdTemp;
    private String group_setting_Main;
    private String group_Setting;
    private String group_SettingsDB;
    private String groupSettingDB;
    private String searchTerminationRequestValue;
    private String searchTerminationRequestValueTemp;
    private String resignID = null;
    private String sex;
    private static String selectedId;
    private static int messageStatus = 0;
    private static int tableSize = 0;
    private static int rowCounter = 0;
    private int stateId = 0;
    private int ownerId = 0;
    private int workflowId = 0;
    private boolean initLoad = true;
    private static int attachedImageID = 0;
    private byte[] attachedDBImg;
    private ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> directorate = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> division = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> mastebaberia = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> team = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> terminationTypes = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> workflowLists = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> requestsLists = new ArrayList<SelectItem>();
    private ArrayList<HashMap> deletedAttachedDocuments = new ArrayList<HashMap>();
    private ResourceBundle messageResource = null;
    private ResourceBundle messageTermination = null;
    private FacesContext context = null;
    private String commentLanguage = null;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateTimeConverter2.setTimeZone(null);
        dateTimeConverter2.setDateStyle("yyyy-mm-dd");
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
    private HtmlInputText txtDateRequest = new HtmlInputText();

    public HtmlInputText getTxtDateRequest() {
        return txtDateRequest;
    }

    public void setTxtDateRequest(HtmlInputText hit) {
        this.txtDateRequest = hit;
    }
    private HtmlInputText txtSalary = new HtmlInputText();

    public HtmlInputText getTxtSalary() {
        return txtSalary;
    }

    public void setTxtSalary(HtmlInputText hit) {
        this.txtSalary = hit;
    }
    private HtmlInputText txtJobPosition = new HtmlInputText();

    public HtmlInputText getTxtJobPosition() {
        return txtJobPosition;
    }

    public void setTxtJobPosition(HtmlInputText hit) {
        this.txtJobPosition = hit;
    }
    private HtmlSelectOneRadio ckbSex = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getCkbSex() {
        return ckbSex;
    }

    public void setCkbSex(HtmlSelectOneRadio hsor) {
        this.ckbSex = hsor;
    }
    private HtmlInputText txtFullName = new HtmlInputText();

    public HtmlInputText getTxtFullName() {
        return txtFullName;
    }

    public void setTxtFullName(HtmlInputText hit) {
        this.txtFullName = hit;
    }
    private HtmlInputText txtAge = new HtmlInputText();

    public HtmlInputText getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(HtmlInputText hit) {
        this.txtAge = hit;
    }
    private HtmlSelectOneMenu dplEmployeeID = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDplEmployeeID() {
        return dplEmployeeID;
    }

    public void setDplEmployeeID(HtmlSelectOneMenu hsom) {
        this.dplEmployeeID = hsom;
    }
    private HtmlInputText txtDirectorate = new HtmlInputText();

    public HtmlInputText getTxtDirectorate() {
        return txtDirectorate;
    }

    public void setTxtDirectorate(HtmlInputText hit) {
        this.txtDirectorate = hit;
    }
    private HtmlInputText txtRank = new HtmlInputText();

    public HtmlInputText getTxtRank() {
        return txtRank;
    }

    public void setTxtRank(HtmlInputText hit) {
        this.txtRank = hit;
    }
    private HtmlInputText txtTotalServiceYear = new HtmlInputText();

    public HtmlInputText getTxtTotalServiceYear() {
        return txtTotalServiceYear;
    }

    public void setTxtTotalServiceYear(HtmlInputText hit) {
        this.txtTotalServiceYear = hit;
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
    private HtmlOutputText txtRetirementNumber = new HtmlOutputText();

    public HtmlOutputText getTxtRetirementNumber() {
        return txtRetirementNumber;
    }

    public void setTxtRetirementNumber(HtmlOutputText hot) {
        this.txtRetirementNumber = hot;
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
    private SelectInputText txtSearByName = new SelectInputText();

    public SelectInputText getTxtSearByName() {
        return txtSearByName;
    }

    public void setTxtSearByName(SelectInputText sit) {
        this.txtSearByName = sit;
    }
    private HtmlCommandButton btnPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYes() {
        return btnPopUpYes;
    }

    public void setBtnPopUpYes(HtmlCommandButton hcb) {
        this.btnPopUpYes = hcb;
    }
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
    private HtmlInputText txtHiredDate = new HtmlInputText();

    public HtmlInputText getTxtHiredDate() {
        return txtHiredDate;
    }

    public void setTxtHiredDate(HtmlInputText hit) {
        this.txtHiredDate = hit;
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
    private HtmlCommandButton calDateRequet = new HtmlCommandButton();

    public HtmlCommandButton getCalDateRequet() {
        return calDateRequet;
    }

    public void setCalDateRequet(HtmlCommandButton hcb) {
        this.calDateRequet = hcb;
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
    private HtmlCommandButton btnDDEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnDDEdit() {
        return btnDDEdit;
    }

    public void setBtnDDEdit(HtmlCommandButton hcb) {
        this.btnDDEdit = hcb;
    }
    private HtmlCommandButton btnDDUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnDDUpdate() {
        return btnDDUpdate;
    }

    public void setBtnDDUpdate(HtmlCommandButton hcb) {
        this.btnDDUpdate = hcb;
    }
    private HtmlInputTextarea txtDDDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDDDescription() {
        return txtDDDescription;
    }

    public void setTxtDDDescription(HtmlInputTextarea hit) {
        this.txtDDDescription = hit;
    }
    private PanelPopup pnlPopUpDateSetting = new PanelPopup();

    public PanelPopup getPnlPopUpDateSetting() {
        return pnlPopUpDateSetting;
    }

    public void setPnlPopUpDateSetting(PanelPopup pp) {
        this.pnlPopUpDateSetting = pp;
    }
    private HtmlInputText txtDateDefference = new HtmlInputText();

    public HtmlInputText getTxtDateDefference() {
        return txtDateDefference;
    }

    public void setTxtDateDefference(HtmlInputText hit) {
        this.txtDateDefference = hit;
    }
    private HtmlOutputLabel lblDDID1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblDDID1() {
        return lblDDID1;
    }

    public void setLblDDID1(HtmlOutputLabel hol) {
        this.lblDDID1 = hol;
    }
    private PanelLayout pnMessage = new PanelLayout();

    public PanelLayout getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelLayout pnMessage) {
        this.pnMessage = pnMessage;
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
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
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
    private HtmlSelectOneMenu lstMainDepartment = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstMainDepartment() {
        return lstMainDepartment;
    }

    public void setLstMainDepartment(HtmlSelectOneMenu hsom) {
        this.lstMainDepartment = hsom;
    }
    private HtmlSelectOneMenu lstDirectorate = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstDirectorate() {
        return lstDirectorate;
    }

    public void setLstDirectorate(HtmlSelectOneMenu hsom) {
        this.lstDirectorate = hsom;
    }
    private HtmlSelectOneMenu lstDivision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstDivision() {
        return lstDivision;
    }

    public void setLstDivision(HtmlSelectOneMenu hsom) {
        this.lstDivision = hsom;
    }
    private HtmlInputText txtDivision = new HtmlInputText();

    public HtmlInputText getTxtDivision() {
        return txtDivision;
    }

    public void setTxtDivision(HtmlInputText hit) {
        this.txtDivision = hit;
    }
    private HtmlInputText txtTeam = new HtmlInputText();

    public HtmlInputText getTxtTeam() {
        return txtTeam;
    }

    public void setTxtTeam(HtmlInputText hit) {
        this.txtTeam = hit;
    }
    private HtmlSelectOneMenu lstMastebaberia = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstMastebaberia() {
        return lstMastebaberia;
    }

    public void setLstMastebaberia(HtmlSelectOneMenu hsom) {
        this.lstMastebaberia = hsom;
    }
    private DefaultSelectedData defaultSelectedData24 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData24() {
        return defaultSelectedData24;
    }

    public void setDefaultSelectedData24(DefaultSelectedData dsd) {
        this.defaultSelectedData24 = dsd;
    }
    private HtmlSelectOneMenu lstTeam = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstTeam() {
        return lstTeam;
    }

    public void setLstTeam(HtmlSelectOneMenu hsom) {
        this.lstTeam = hsom;
    }
    private HtmlInputText txtMastebaberia = new HtmlInputText();

    public HtmlInputText getTxtMastebaberia() {
        return txtMastebaberia;
    }

    public void setTxtMastebaberia(HtmlInputText hit) {
        this.txtMastebaberia = hit;
    }
    private HtmlOutputText lblZerf = new HtmlOutputText();

    public HtmlOutputText getLblZerf() {
        return lblZerf;
    }

    public void setLblZerf(HtmlOutputText hot) {
        this.lblZerf = hot;
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
    private HtmlSelectOneMenu ddlstTerminationType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdlstTerminationType() {
        return ddlstTerminationType;
    }

    public void setDdlstTerminationType(HtmlSelectOneMenu hsom) {
        this.ddlstTerminationType = hsom;
    }

    public ArrayList<SelectItem> getTerminationTypes() {
        terminationTypes = terminationManager.ReadTerminationTypes();
        return terminationTypes;
    }

    public void setTerminationTypes(ArrayList<SelectItem> terminationTypes) {
        this.terminationTypes = terminationTypes;
    }
    private DefaultSelectedData defaultSelectedData122 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData122() {
        return defaultSelectedData122;
    }

    public void setDefaultSelectedData122(DefaultSelectedData dsd) {
        this.defaultSelectedData122 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu ddlstWorkFlow = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdlstWorkFlow() {
        return ddlstWorkFlow;
    }

    public void setDdlstWorkFlow(HtmlSelectOneMenu hsom) {
        this.ddlstWorkFlow = hsom;
    }
    private HtmlInputText txtState = new HtmlInputText();

    public HtmlInputText getTxtState() {
        return txtState;
    }

    public void setTxtState(HtmlInputText hit) {
        this.txtState = hit;
    }

    public ArrayList<SelectItem> getWorkflowLists() {
        workflowLists =null;// workflowOwnersManager.ReadWorkflowLists();
        return workflowLists;
    }

    public void setWorkflowLists(ArrayList<SelectItem> workflowLists) {
        this.workflowLists = workflowLists;
    }
    private HtmlInputText txtGroupOwner = new HtmlInputText();

    public HtmlInputText getTxtGroupOwner() {
        return txtGroupOwner;
    }

    public void setTxtGroupOwner(HtmlInputText hit) {
        this.txtGroupOwner = hit;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RetireRequestPage() {
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
        messageTermination = ResourceBundle.getBundle("Localization.HR_Localization_Termination", context.getCurrentInstance().getViewRoot().getLocale());
        messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
        ddlstWorkFlow.setRequired(true);

        ddlstTerminationType.setRequired(true);
        txtCurrentDate.setRequired(true);
        txtDateRequest.setRequired(true);
        ddlstWorkFlow.setRequiredMessage(messageResource.getString("requiredMsg"));
        ddlstTerminationType.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtCurrentDate.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtDateRequest.setRequiredMessage(messageResource.getString("requiredMsg"));
//        SiteSecurityManager security = new SiteSecurityManager();
//        if (security.canView(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            //   this.displayPageForView();
//        } else if (security.canPrepare(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            //  this.displayPageForInsert();
//        } else if (security.canDelete(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//            //   this.displayPageForDelete();
//        } else if (security.canApprove(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
//        } else if (security.canCertify(getSessionBean1().getRequestedPage(), getSessionBean1().getUserName())) {
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
    private Option[] lstResignTypes;

    public Option[] getLstResignTypes() {
        return lstResignTypes;
    }

    public void setLstResignTypes(Option[] lstResignTypes) {
        this.lstResignTypes = lstResignTypes;
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
            employeeManager.loadEmpoyeeProfile(empId);
            txtFullName.setValue(employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            int age = employeeManager.calculateEmployeeAgeInYears(empId);
            txtAge.setValue(age);
            sex = employeeManager.getSex();
            txtRetirementNumber.setValue(employeeManager.getRetirement_no());

//     
            txtJobPosition.setValue(employeeManager.getJobDescription());
            txtRank.setValue(employeeManager.getRankeDscription());
            txtSalary.setValue(employeeManager.getSalary());
            int expYear = employeeManager.calculateEmployeeServiceYear(empId);
            txtTotalServiceYear.setValue(String.valueOf(expYear));
            txtHiredDate.setValue(employeeManager.getHire_Date());
            if (sex.equalsIgnoreCase("Male")) {
                cbMale.setSelected(true);
            } else if (sex.equalsIgnoreCase("Female")) {
                cbFemale.setSelected(true);
            } else {
                cbMale.setSelected(false);
                cbFemale.setSelected(false);
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
        resignID = vce.getNewValue().toString();
        lblHResignationTypeID.setValue(resignID);
        try {
            loadResignationTypeDetails(resignID);
        } catch (Exception ex) {
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
            return terminationManager.CheckIDFoundInRequestHistory(empId);
        } catch (Exception ex) {
            return 0;
        }
    }

    private int CheckEmployeeId(String empId) {
        try {
            return terminationManager.CheckEmployeeId(empId);
        } catch (Exception ex) {
            return 0;
        }
    }

    public String txtSearByName_action() {
        getFileAttachment().clear();//clear the current uploaded file inorder to ignor data repeatition
        fileUploadAttached.setDisabled(true);
        selectedId = getSelectedEmployeeId();
        try {
            getRequestsLists().clear();//
            getFileAttachment().clear();
            txtAge.resetValue();
            txtDirectorate.resetValue();
            txtFullName.resetValue();
            txtJobPosition.resetValue();
            txtRank.resetValue();
            txtSalary.resetValue();
            txtTotalServiceYear.resetValue();
            txtHiredDate.resetValue();
            txtDirectorate.resetValue();
            txtDivision.resetValue();
            txtMastebaberia.resetValue();
            txtTeam.resetValue();
            cbMale.resetValue();
            cbFemale.resetValue();
            cbFemale.setSelected(false);
            cbMale.setSelected(false);
            lblZerf.setValue(null);
            txtEmployeeId.resetValue();


            if (CheckTerminationEmployeeId(selectedId) == 1) {
                ArrayList<SelectItem> requests = terminationManager.ReadRequestsList(selectedId);
                getRequestsLists().clear();//
                setRequestsLists(requests);
                lblPopUpMsgMain.setValue("INFO -" + txtSearByName.getValue().toString() + " made a request before.check the request before made list.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpOk.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
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

    /**
     * Load employee request history by the current employee searched <code>id</code> if he/she have
     * a request posted before.
     */
    public void LoadCurrentRequest(String employeeID) {
        String terminationType = null;
        int commentStatus = 0;
        int finalCommentStatus = 0;
        txtReasonDescription.setValue(null);
        txtReasonDescription.resetValue();
        txtDateRequest.setValue(null);
        txtDateRequest.resetValue();
        //*********************************Load Termination Request History That Is Posted Before*****************************
        HashMap terReq = terminationManager.readEmployeeTerminationRequestsHistory(getSearchTerminationRequestValue());
        int status = Integer.valueOf(terReq.get("terrequestStatus").toString());
        if (status == 0) {
            lblStateStatus.setValue("PENDING");
        } else if (status == 1) {
            lblStateStatus.setValue("APPROVED");
        } else if (status == 2) {
            lblStateStatus.setValue("POSTPONED");
        } else if (status == 3) {
            lblStateStatus.setValue("REJECTED");
        }
        txtReasonDescription.setValue(terReq.get("terRequestDescription"));
        txtCurrentDate.setValue(terReq.get("terRequestDate"));
        txtDateRequest.setValue(terReq.get("terTerminationDate"));
        EmployeeTerminationCommentedTemp = terReq.get("terRequestId").toString();
        EmployeeTerminationProcessedIdTemp = terReq.get("terRequestId").toString();
        terminationType = terReq.get("terminationTypeSelected").toString();
        groupSettingDB = (String) terReq.get("groupSetting");
        if (terminationType.equals("1")) {
            dpResignTypes = retirementLookUpManager.loadTerminationTypesToDropdownList(groupSettingDB.toString());
            commentStatus = Integer.valueOf(terReq.get("commentStatus").toString());
            finalCommentStatus = Integer.valueOf(terReq.get("finalCommentStatus").toString());
//************************************************End Of Load Termination Request History That Is Posted Before************************************
            //****************************************Load Comment Given If There Is One **************************************************************
            if (commentStatus == 1) {
                //     gimgRequestComment.setUrl("/EmployeeTermination/images/NewMsg.png");
                //  }
            } else {
                //   gimgRequestComment.setUrl("/EmployeeTermination/images/NewMsg_1.png");
            }
//****************************************End Load Comment Given If There Is One **************************************************************
            //****************************************Load Final Comment Given If There Is One **************************************************************
            //    HashMap ProcessedHashManp = terminationManager.ReadEmployeeTerminationRequestProcessed(EmployeeTerminationProcessedIdTemp);
            if (finalCommentStatus == 1) {
                //   gimgRequestProcessed.setUrl("/EmployeeTermination/images/NewMsg.png");
                lblMsgProcessed.setRendered(true);
                lblMsgProcessed2.setRendered(false);
            } else {
                // gimgRequestProcessed.setUrl("/EmployeeTermination/images/NewMsg_1.png");
                lblMsgProcessed.setRendered(false);
                lblMsgProcessed2.setRendered(true);
            }
            //****************************************End Load Final Comment Given If There Is One **************************************************************
            ///////////////////////////////////////////////Document Attached///////////////////////////////
//            myDocuments = terminationManager.readEmployeeTerminationAttachedDocuments(EmployeeTerminationCommentedTemp);
//            String fileIcon = "";
//            for (int i = 0; i < myDocuments.size(); i++) {
//                HashMap mapResourceData1 = myDocuments.get(i);
//                if (mapResourceData1.get("docFormat").toString().startsWith("image/")) {
//                    fileIcon = this.imageFormat;
//                } else {
//                    fileIcon = this.fileFormat;
//                }
//                getFileAttached().add(
//                        new FileAttachedModel(fileIcon, attachedImage, mapResourceData1.get("docId").toString(),
//                        mapResourceData1.get("docFormat").toString(),
//                        mapResourceData1.get("docDate").toString(),
//                        mapResourceData1.get("empId").toString(),
//                        mapResourceData1.get("docName").toString(),
//                        ""));
//            }
            ///////////////////////////////////////////////END Document Attached///////////////////////////////
            btnNewTermination.setDisabled(true);
            btnEditRequest.setDisabled(false);
        }
    }

    public void btnPopUpYes_processAction(ActionEvent ae) {
        btnYes = true;
        if (btnYes == true) {
            pnlPopUpMsg.setRendered(false);
            this.loadEmployeeProfileDetail(selectedId);
            txtEmployeeId.setValue(selectedId);
            setSearchTerminationRequestValue(txtEmployeeId.getValue().toString());
            setSearchTerminationRequestValueTemp(txtEmployeeId.getValue().toString());
            this.LoadCurrentRequest(getSearchTerminationRequestValue());
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
            txtAge.setValue(null);
            txtDateRequest.setValue(null);
            txtDirectorate.setValue(null);
            txtFullName.setValue(null);
            txtJobPosition.setValue(null);
            txtRank.setValue(null);
            txtRetirementNumber.setValue(null);
            txtRetirementNumber.setValue(null);
            txtSalary.setValue(null);
            txtTotalServiceYear.setValue(null);
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
        if (lstMainDepartment.getValue() != null) {

            AutoCompleteDictionary.init();

            updateList(vce);
        }
    }

    public String lnkTerminationApproval_action() {
        //return null means stay on the same page
        return "TerminationApproval";
    }

    public String lnkTerminationClearance_action() {
        //return null means stay on the same page
        return "TerminationClearance";
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
            if (getTxtResignationType().getValue() != "") {
                resignationType = getTxtResignationType().getValue().toString();
            }
            if (getTxtResignationTypeDescription().getValue() != "") {
                Resignationdscription = getTxtResignationTypeDescription().getValue().toString();
            }
            try {
                retirementLookUpManager.addNewTerminationType(txtResignationType.getValue().toString(),
                        txtResignationTypeDescription.getValue().toString(), group_Setting.toString());

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
            HashMap terReq = terminationManager.readAttachedDocuments(documentId);
            BLOB blo = (BLOB) terReq.get("docPath");
            setAttachedDBImg(blo.getBytes(1, (int) blo.length()));
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

    public String btnNewTermination_action() {
        if (txtEmployeeId.getValue() != null) {

            if (CheckEmployeeId(txtEmployeeId.getValue().toString()) == 1) {
                loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
                tableSize = 0;
                rowCounter = 0;
                getRequestsLists().clear();//
                String currentDate = StringDateManipulation.toDayInEc();
                lstResignationTyes.resetValue();
                ddlstTerminationType.setValue("0");
                ddlstWorkFlow.setValue("0");
                txtCurrentDate.setValue(currentDate);
                txtDateRequest.setValue(null);
                txtReasonDescription.setValue(null);
                txtState.setValue(null);
                txtGroupOwner.setValue(null);
                lblStateStatus.setValue(null);
                fileUploadAttached.setDisabled(false);
                getFileAttachment().clear();

                calDateRequet.setDisabled(false);
                ddlstTerminationType.setDisabled(false);
                ddlstWorkFlow.setDisabled(false);
                txtCurrentDate.setDisabled(true);
                txtDateRequest.setDisabled(false);
                txtReasonDescription.setDisabled(false);




                btnNewTerminationPost.setDisabled(false);
                btnCancelTerminationRequest.setDisabled(false);
                btnNewTermination.setDisabled(true);
                btnEditRequest.setDisabled(true);
                btnUpdateTerminationRequest.setDisabled(true);
                btnDeleteTerminationRequest.setDisabled(true);
            } else {
                lblPopUpMsgMain.setValue("Employee Id is not registered.Please try again.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpOk.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
            }
        } else {
            lblPopUpMsgMain.setValue("Please fill Employee Id first by using the search text field.");
            pnlPopUpMsg.setRendered(true);
            btnPopUpOk.setRendered(true);
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
        }

        return null;
    }

    public String btnEditRequest_action() {
        try {
            if (txtEmployeeId.getValue() != null) {

                fileUploadAttached.setDisabled(false);
                lnkAttachedRemove.setDisabled(false);
                calDateRequet.setDisabled(false);
                ddlstTerminationType.setDisabled(false);
                ddlstWorkFlow.setDisabled(true);
                txtCurrentDate.setDisabled(true);
                txtDateRequest.setDisabled(false);
                txtReasonDescription.setDisabled(false);

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

    public void txtDateRequest_processValueChange(ValueChangeEvent vce) {
        txtDateRequest.setRequiredMessage("");
    }

    public String btnDDEdit_action() {
        //return null means stay on the same page
        txtDateDefference.setDisabled(false);
        txtDDDescription.setDisabled(false);
        btnDDEdit.setDisabled(true);
        btnDDUpdate.setDisabled(false);
        return null;
    }

    public String btnDDUpdate_action() {
        //return null means stay on the same page
        try {
            if (lblDDID1.getValue() != null) {
//                if (terminationManager.UpdateDateDefferenceSetting(lblDDID1.getValue().toString(), txtDateDefference.getValue().toString(),
//                        txtDDDescription.getValue().toString()) == 1) {
//                    txtDateDefference.setDisabled(true);
//                    txtDDDescription.setDisabled(true);
//                    btnDDEdit.setDisabled(false);
//                    btnDDUpdate.setDisabled(true);
//                }
            }
        } catch (Exception ex) {
            return null;
        }

        return null;
    }

    public String modalPnlCloseBtnDateSetting_action() {
        //return null means stay on the same page
        pnlPopUpDateSetting.setRendered(false);
        return null;
    }

    public String lnkTerminationPeriod_action() {
        //return null means stay on the same page
        //*********************date difference setting*****************************
        HashMap ddHashManp = terminationManager.ReadTerminationDateSetting();
        if (ddHashManp != null) {
            lblDDID1.setValue(ddHashManp.get("ddID"));
            txtDateDefference.setValue(ddHashManp.get("ddV"));
            txtDDDescription.setValue(ddHashManp.get("ddD"));
            pnlPopUpDateSetting.setRendered(true);

        }
//**************************************************************************

        return null;
    }

    public String hlnkRequestCommented_action() {
        //return null means stay on the same page
        if (txtEmployeeId.getValue() == null) {
            lblPopUpMsgMain.setValue("Please fill Employee Id first by using the search text field.");
            pnlPopUpMsg.setRendered(true);
            btnPopUpOk.setRendered(true);
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
        } else {
            //*******************************Termination Request Comment History**************************************
            if (EmployeeTerminationCommentedTemp != null) {
                HashMap commetHashManp = terminationManager.readEmployeeTerminationRequestComments(EmployeeTerminationCommentedTemp);
                if (commetHashManp != null) {
                    EmployeeManage empMgt = new EmployeeManage();
                    lblTerminationrequestEmployeeId.setValue(txtEmployeeId.getValue().toString());
                    txtCommentedByDateCommented.setValue(commetHashManp.get("commentedDate"));
                    txtRequestCommentedDescription.setValue(commetHashManp.get("commentDescription"));
                    String commentedBy = commetHashManp.get("commentedBy").toString().toUpperCase();
                    empMgt.loadEmpoyeeProfile(commentedBy);
                    txtCommentedByFullName.setValue(empMgt.getFirst_Name() + " " + empMgt.getMiddle_Name() + " " + empMgt.getLast_Name());
                    txtCommentedByPosition.setValue(empMgt.getJobDescription());
                    pnlPopUpRequestCommented.setRendered(true);
                }

            } else {
                lblPopUpMsgMain.setValue("This Employee may not have request.Please try agin.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpOk.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
            }

        }
        return null;
    }

    public String lnkTerminationApprovalComment_action() {
        //return null means stay on the same page
        if (txtEmployeeId.getValue() == null) {
            lblPopUpMsgMain.setValue("Please fill Employee Id first by using the search text field.");
            pnlPopUpMsg.setRendered(true);
            btnPopUpOk.setRendered(true);
            btnPopUpNo.setRendered(false);
            btnPopUpYes.setRendered(false);
        } else {
            //*******************************Termination Request Comment History**************************************
            if (EmployeeTerminationProcessedIdTemp != null) {
                HashMap commetHashManp = terminationManager.ReadEmployeeTerminationRequestProcessed(EmployeeTerminationProcessedIdTemp);
                if (commetHashManp != null) {
                    EmployeeManage empMgt = new EmployeeManage();
                    lblTerminationrequestEmployeeId1.setValue(txtEmployeeId.getValue().toString());
                    txtProcessedByDate.setValue(commetHashManp.get("processedDate"));
                    txtRequestProcessedDescription.setValue(commetHashManp.get("processedDescription"));
                    String ProcessedBy = commetHashManp.get("processedBy").toString().toUpperCase();
                    empMgt.loadEmpoyeeProfile(ProcessedBy);
                    txtProcessedByFullName.setValue(empMgt.getFirst_Name() + " " + empMgt.getMiddle_Name() + " " + empMgt.getLast_Name());
                    txtProcessedByPosition.setValue(empMgt.getJobDescription());
                    pnlPopUpRequestProcessed.setRendered(true);
                }

            } else {
                lblPopUpMsgMain.setValue("This Employee may not have request.Please try agin.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpOk.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
            }

        }
        return null;
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

    private HashMap RequestInfo() {
        HashMap requestInfo = new HashMap();
        requestInfo.put("requesterId", txtEmployeeId.getValue().toString());
        requestInfo.put("terminationtype", ddlstTerminationType.getValue().toString());
        requestInfo.put("dateRequest", txtCurrentDate.getValue().toString());
        requestInfo.put("dateTermination", txtDateRequest.getValue().toString());
        requestInfo.put("description", txtReasonDescription.getValue().toString());
        requestInfo.put("cancelled", 0);
        return requestInfo;
    }

    private HashMap ItemInfo() {
        HashMap itemInfo = new HashMap();
        itemInfo.put("workflowId", workflowId);
        itemInfo.put("currentState", stateId);
        return itemInfo;
    }

    private HashMap ItemOwnerInfo() {
        HashMap itemOwnerInfo = new HashMap();
        itemOwnerInfo.put("workflowGroupId", ownerId);
        return itemOwnerInfo;
    }

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

    public String btnNewTerminationPost_action() {
        try {
            int dateDefference = 0;//local variable for date inistantiating
            //Checking Date Difference for termination request between the current date and date termination
            HashMap ddHashManp = terminationManager.ReadTerminationDateSetting();//read the date setting that is stored in database

            if (ddHashManp != null) {//check if the the returned value is not null
                txtDateDefference.setValue(ddHashManp.get("ddV"));//the value to component

            } else {
                txtDateDefference.setValue("0");//set the value to zero if there is not setting found
            }

            dateDefference = terminationManager.calculateEmpServiceDays(txtCurrentDate.getValue().toString(), txtDateRequest.getValue().toString());

            int dateDefferenceSetting = Integer.valueOf(txtDateDefference.getValue().toString());//

            if (dateDefference <= dateDefferenceSetting) {//comparison date defference
                lblPopUpMsgMain.setValue("Please enter a termination date that is greater than " + dateDefferenceSetting + ".Try again.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpOk.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
            } else {
//                if (terminationManager.postNewTerminationRequest(RequestInfo(), ItemInfo(), ItemOwnerInfo(), SupportiveInfo()) == 1) {
//                    RequestInfo().clear();
//                    ItemInfo().clear();
//                    ItemOwnerInfo().clear();
//                    SupportiveInfo().clear();
//                    ddlstTerminationType.resetValue();
//                    ddlstWorkFlow.resetValue();
//                    txtCurrentDate.resetValue();
//                    txtDateRequest.resetValue();
//                    txtReasonDescription.resetValue();
//                    txtState.resetValue();
//                    txtGroupOwner.resetValue();
//                    lstResignationTyes.resetValue();
//
//                    ddlstTerminationType.setValue("0");
//                    ddlstWorkFlow.setValue("0");
//                    txtCurrentDate.setValue(null);
//                    txtDateRequest.setValue(null);
//                    txtReasonDescription.setValue(null);
//                    txtState.setValue(null);
//                    txtGroupOwner.setValue(null);
//                    lblStateStatus.setValue(null);
//
//
//                    fileUploadAttached.setDisabled(false);
//                    getFileAttachment().clear();
//
//                    calDateRequet.setDisabled(true);
//                    ddlstTerminationType.setDisabled(true);
//                    ddlstWorkFlow.setDisabled(true);
//                    txtCurrentDate.setDisabled(true);
//                    txtDateRequest.setDisabled(true);
//                    txtReasonDescription.setDisabled(true);
//
//
//
//
//                    btnNewTerminationPost.setDisabled(true);
//                    btnCancelTerminationRequest.setDisabled(true);
//                    btnNewTermination.setDisabled(false);
//                    btnEditRequest.setDisabled(true);
//                    btnUpdateTerminationRequest.setDisabled(true);
//                    btnDeleteTerminationRequest.setDisabled(true);
//
//                    lblFormMessage1.setStyleClass("success");
//                    lblFormMessage1.setValue("Employee Termination Request Is Successfully Posted.And Need To Be Viewed By  Authorized Person.");
//                    showConformationMsg(pnMessage.getStyleClass().toString());
//                } else {
//
//                    lblFormMessage1.setStyleClass("error");
//                    lblFormMessage1.setValue("Error Occured While Posting Termination Request.Please Try Again!");
//                    showConformationMsg(pnMessage.getStyleClass().toString());
//                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void btnCancelTerminationRequest_processAction(ActionEvent ae) {
    }

    public String btnCancelTerminationRequest_action() {

        txtEmployeeId.resetValue();
        ddlstTerminationType.resetValue();
        ddlstWorkFlow.resetValue();
        txtCurrentDate.resetValue();
        txtDateRequest.resetValue();
        txtReasonDescription.resetValue();
        txtState.resetValue();
        txtGroupOwner.resetValue();
        lstResignationTyes.resetValue();

        ddlstTerminationType.setValue("0");
        ddlstWorkFlow.setValue("0");
        txtCurrentDate.setValue(null);
        txtDateRequest.setValue(null);
        txtReasonDescription.setValue(null);
        txtState.setValue(null);
        txtGroupOwner.setValue(null);
        lblStateStatus.setValue(null);


        fileUploadAttached.setDisabled(false);
        getFileAttachment().clear();

        calDateRequet.setDisabled(true);
        ddlstTerminationType.setDisabled(true);
        ddlstWorkFlow.setDisabled(true);
        txtCurrentDate.setDisabled(true);
        txtDateRequest.setDisabled(true);
        txtReasonDescription.setDisabled(true);




        btnNewTerminationPost.setDisabled(true);
        btnCancelTerminationRequest.setDisabled(true);
        btnNewTermination.setDisabled(false);
        btnEditRequest.setDisabled(true);
        btnUpdateTerminationRequest.setDisabled(true);
        btnDeleteTerminationRequest.setDisabled(true);

        return null;
    }

    public String btnUpdateTerminationRequest_action() {
        try {
            //check which termination type is selected and set approprate value to send.
            //Checking Date Difference for termination request between the current date and date termination
            HashMap ddHashManp = terminationManager.ReadTerminationDateSetting();
            if (ddHashManp != null) {
                txtDateDefference.setValue(ddHashManp.get("ddV"));
            } else {
                txtDateDefference.setValue("0");
            }

            int dateDefference = 0;
            dateDefference =
                    terminationManager.calculateEmpServiceDays(txtCurrentDate.getValue().toString(), txtDateRequest.getValue().toString());
            int dateDefferenceSetting = Integer.valueOf(txtDateDefference.getValue().toString());
            if (dateDefference <= dateDefferenceSetting) {
                lblPopUpMsgMain.setValue("Please enter a termination date that is greater than " + dateDefferenceSetting + ".Try again.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpOk.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
                return null;
            } else {

                lblFormMessage.setRendered(false);
                if (terminationManager.UpdateTerminationRequest(
                        lstRequestsList.getValue().toString(),
                        ddlstTerminationType.getValue().toString(),
                        txtDateRequest.getValue().toString(),
                        txtReasonDescription.getValue().toString(),
                        SupportiveInfo(),
                        getDeletedAttachedDocuments()) == 1) {

                    lblFormMessage1.setStyleClass("success");
                    lblFormMessage1.setValue("Your request has been successfully updated.");
                    showConformationMsg(pnMessage.getStyleClass().toString());

                    rowCounter = 0;
                    SupportiveInfo().clear();
                    getDeletedAttachedDocuments().clear();
                    fileUploadAttached.setDisabled(true);
                    lnkAttachedRemove.setDisabled(true);
                    calDateRequet.setDisabled(true);
                    ddlstTerminationType.setDisabled(true);
                    ddlstWorkFlow.setDisabled(true);
                    txtCurrentDate.setDisabled(true);
                    txtDateRequest.setDisabled(true);
                    txtReasonDescription.setDisabled(true);

                    btnNewTerminationPost.setDisabled(true);
                    btnCancelTerminationRequest.setDisabled(true);
                    btnNewTermination.setDisabled(false);
                    btnEditRequest.setDisabled(true);
                    btnUpdateTerminationRequest.setDisabled(true);
                    btnDeleteTerminationRequest.setDisabled(true);
                } else {
                    lblFormMessage1.setStyleClass("error");
                    lblFormMessage1.setValue("Error occured while updating your request.Sorry try again.");
                    showConformationMsg(pnMessage.getStyleClass().toString());
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void ddRTypes_processValueChange(ValueChangeEvent vce) {
    }

    public void lstMainDepartment_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            setDirectorate(null);
            setDivision(null);
            setMastebaberia(null);
            setTeam(null);
            AutoCompleteDictionary.componentID = vce.getComponent().getId().toString();
            AutoCompleteDictionary.componentValueID = vce.getNewValue().toString();
            setDirectorate(departmentManage.getZerfName(vce.getNewValue().toString()));
        }

    }

    public void lstDirectorate_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            setDivision(null);
            setMastebaberia(null);
            setTeam(null);
            AutoCompleteDictionary.componentID = vce.getComponent().getId().toString();
            AutoCompleteDictionary.componentValueID = vce.getNewValue().toString();
            setDivision(departmentManage.getZerfName(vce.getNewValue().toString()));
        }

    }

    public void lstDivision_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            setMastebaberia(null);
            setTeam(null);
            AutoCompleteDictionary.componentID = vce.getComponent().getId().toString();
            AutoCompleteDictionary.componentValueID = vce.getNewValue().toString();
            setMastebaberia(departmentManage.getZerfName(vce.getNewValue().toString()));
        }

    }

    public void lstMastebaberia_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            setTeam(null);
            AutoCompleteDictionary.componentID = vce.getComponent().getId().toString();
            AutoCompleteDictionary.componentValueID = vce.getNewValue().toString();
            setTeam(departmentManage.getZerfName(vce.getNewValue().toString()));
        }

    }

    public void lstTeam_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            AutoCompleteDictionary.componentID = vce.getComponent().getId().toString();
            AutoCompleteDictionary.componentValueID = vce.getNewValue().toString();
        }

    }
    //**********************************Auto Complete
    EmployeeList currentEmployee1 = new EmployeeList("", "0",null);

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
            int insert = Collections.binarySearch(AutoCompleteDictionary.dictionary, searchWord, AutoCompleteDictionary.LABEL_COMPARATOR);
            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }

            for (int i = 0; i <
                    maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= AutoCompleteDictionary.dictionary.size() || i >= maxMatches) {
                    break;
                }

                matchList.add(AutoCompleteDictionary.dictionary.get(insert + i));
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
                group_Setting =
                        "5";
            }

        }
    }

    public String btnResignEdit_action() {
        //return null means stay on the same page
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
                currentFile = inputFile.getFileInfo();
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

    public void ddlstWorkFlow_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            txtState.resetValue();
            txtGroupOwner.resetValue();
            HashMap hm = terminationManager.LoadStateAndOwner(vce.getNewValue().toString());
            if (hm != null) {
                workflowId = Integer.valueOf(vce.getNewValue().toString());
                stateId = Integer.valueOf(hm.get("stateId").toString());
                ownerId = Integer.valueOf(hm.get("ownerId").toString());
                txtState.setValue(hm.get("stateId").toString() + "-[ " + hm.get("stateName").toString() + " ]");
                txtGroupOwner.setValue(hm.get("ownerId").toString() + "-[ " + hm.get("ownerName").toString() + " ]");
            }

        }
    }

    public void lstRequestsList_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                rowCounter = 0;
                //   requestId = Integer.valueOf(vce.getNewValue().toString());
                txtEmployeeId.resetValue();
                ddlstTerminationType.resetValue();
                ddlstWorkFlow.resetValue();
                txtCurrentDate.resetValue();
                txtDateRequest.resetValue();
                txtReasonDescription.resetValue();
                txtState.resetValue();
                txtGroupOwner.resetValue();
                lstResignationTyes.resetValue();

                ddlstTerminationType.setValue("0");
                ddlstWorkFlow.setValue("0");
                txtCurrentDate.setValue(null);
                txtDateRequest.setValue(null);
                txtReasonDescription.setValue(null);
                txtState.setValue(null);
                txtGroupOwner.setValue(null);
                lblStateStatus.setValue(null);


                fileUploadAttached.setDisabled(true);
                getFileAttachment().clear();

                calDateRequet.setDisabled(true);
                ddlstTerminationType.setDisabled(true);
                ddlstWorkFlow.setDisabled(true);
                txtCurrentDate.setDisabled(true);
                txtDateRequest.setDisabled(true);
                txtReasonDescription.setDisabled(true);




                btnNewTerminationPost.setDisabled(true);
                btnCancelTerminationRequest.setDisabled(true);
                btnNewTermination.setDisabled(false);
                btnEditRequest.setDisabled(true);
                btnUpdateTerminationRequest.setDisabled(true);
                btnDeleteTerminationRequest.setDisabled(true);



                HashMap hm = terminationManager.ReadRequestsInfo(vce.getNewValue().toString());
                if (hm != null) {
                    ddlstTerminationType.resetValue();
                    ddlstWorkFlow.resetValue();
                    txtCurrentDate.resetValue();
                    txtDateRequest.resetValue();
                    txtReasonDescription.resetValue();
                    txtState.resetValue();
                    txtGroupOwner.resetValue();
                    lblStateStatus.setValue(null);
                    if (hm.get("stateProperty").toString().equalsIgnoreCase("1")) {
                        lblPopUpMsgMain.setValue("INFO - This request is on read only state,Only view is enabled.");
                        pnlPopUpMsg.setRendered(true);
                        btnPopUpOk.setRendered(true);
                        btnPopUpNo.setRendered(false);
                        btnPopUpYes.setRendered(false);
                    } else {
                        btnEditRequest.setDisabled(false);
                        btnDeleteTerminationRequest.setDisabled(false);
                    }

                    txtEmployeeId.setValue(hm.get("requesterId").toString());
                    ddlstTerminationType.setValue(hm.get("requesttypeId").toString());
                    ddlstWorkFlow.setValue(hm.get("workflowId").toString());
                    txtCurrentDate.setValue(hm.get("dateRequested").toString());
                    txtDateRequest.setValue(hm.get("dateTermination").toString());
                    txtReasonDescription.setValue(hm.get("description"));
                    txtState.setValue(hm.get("stateId").toString() + "-[ " + hm.get("stateName").toString() + " ]");
                    txtGroupOwner.setValue(hm.get("ownerId").toString() + "-[ " + hm.get("ownerName").toString() + " ]");
                    lblStateStatus.setValue(" -[ " + hm.get("stateName").toString() + " ]" + " Owner Group " + "-[ " + hm.get("ownerName").toString() + " ]");

                    //load supportive information attached
                    ArrayList<HashMap> attachedDocumentsList = terminationManager.ReadSupportiveInfo(vce.getNewValue().toString());
                    if (attachedDocumentsList != null) {
                        tableSize = 0;
                        for (HashMap hm1 : attachedDocumentsList) {
                            getFileAttachment().add(new FileAttachmentModel(hm1.get("docId").toString(), attachedImage, hm1.get("docName").toString(), hm1.get("docPath").toString()));
                            tableSize++;

                        }
                    }


                    //load the requester detail information

                    txtAge.resetValue();
                    txtDirectorate.resetValue();
                    txtFullName.resetValue();
                    txtJobPosition.resetValue();
                    txtRank.resetValue();
                    txtSalary.resetValue();
                    txtTotalServiceYear.resetValue();
                    txtHiredDate.resetValue();
                    txtDirectorate.resetValue();
                    txtDivision.resetValue();
                    txtMastebaberia.resetValue();
                    txtTeam.resetValue();
                    loadEmployeeProfileDetail(hm.get("requesterId").toString());


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

    public void ddlstTerminationType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            //   requestType = Integer.valueOf(vce.getNewValue().toString());
        }
    }

    public String btnSearch_action() {
        try {

            if (txtEmployeeId.getValue() != null) {

                getRequestsLists().clear();//
                getFileAttachment().clear();
                txtAge.resetValue();
                txtDirectorate.resetValue();
                txtFullName.resetValue();
                txtJobPosition.resetValue();
                txtRank.resetValue();
                txtSalary.resetValue();
                txtTotalServiceYear.resetValue();
                txtHiredDate.resetValue();
                txtDirectorate.resetValue();
                txtDivision.resetValue();
                txtMastebaberia.resetValue();
                txtTeam.resetValue();
                cbMale.resetValue();
                cbFemale.resetValue();
                cbFemale.setSelected(false);
                cbMale.setSelected(false);
                lblZerf.setValue(null);

                if (CheckTerminationEmployeeId(txtEmployeeId.getValue().toString()) == 1) {
                    ArrayList<SelectItem> requests = terminationManager.ReadRequestsList(txtEmployeeId.getValue().toString());
                    getRequestsLists().clear();//
                    setRequestsLists(requests);
                    lblPopUpMsgMain.setValue("INFO -" + txtSearByName.getValue().toString() + " made a request before.check the request before made list.");
                    pnlPopUpMsg.setRendered(true);
                    btnPopUpOk.setRendered(true);
                    btnPopUpNo.setRendered(false);
                    btnPopUpYes.setRendered(false);
                    loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
                } else {
                    if (CheckEmployeeId(txtEmployeeId.getValue().toString()) == 1) {
                        loadEmployeeProfileDetail(txtEmployeeId.getValue().toString());
                    } else {
                        lblPopUpMsgMain.setValue("Employee Id is not registered.Please try again.");
                        pnlPopUpMsg.setRendered(true);
                        btnPopUpOk.setRendered(true);
                        btnPopUpNo.setRendered(false);
                        btnPopUpYes.setRendered(false);
                    }
                }
            } else {
                lblPopUpMsgMain.setValue("Please enter employee id.");
                pnlPopUpMsg.setRendered(true);
                btnPopUpOk.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
            }
        } catch (Exception ex) {
        }
        return null;
    }
}

