/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Organization;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
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
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.event.ActionEvent;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import javax.faces.event.ValueChangeEvent;
import manager.globalUseManager.LookUpManager;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class JobType extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        selectBooleanCheckbox1Choice.setSelected(true);
        this.set_jobRank(lookUpManager.assignJobRank(""));
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private PanelCollapsible panelCollapsible2 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible2() {
        return panelCollapsible2;
    }

    public void setPanelCollapsible2(PanelCollapsible pc) {
        this.panelCollapsible2 = pc;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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
    private HtmlSelectOneMenu drlRank = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRank() {
        return drlRank;
    }

    public void setDrlRank(HtmlSelectOneMenu hsom) {
        this.drlRank = hsom;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlCommandButton btnExperiance = new HtmlCommandButton();

    public HtmlCommandButton getBtnExperiance() {
        return btnExperiance;
    }

    public void setBtnExperiance(HtmlCommandButton hcb) {
        this.btnExperiance = hcb;
    }
    private PanelPopup poupExperience = new PanelPopup();

    public PanelPopup getPoupExperience() {
        return poupExperience;
    }

    public void setPoupExperience(PanelPopup pp) {
        this.poupExperience = pp;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
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
    private HtmlInputText txtJobCode = new HtmlInputText();

    public HtmlInputText getTxtJobCode() {
        return txtJobCode;
    }

    public void setTxtJobCode(HtmlInputText hit) {
        this.txtJobCode = hit;
    }
    private HtmlInputText txtJobName = new HtmlInputText();

    public HtmlInputText getTxtJobName() {
        return txtJobName;
    }

    public void setTxtJobName(HtmlInputText hit) {
        this.txtJobName = hit;
    }
    private HtmlInputTextarea txtaJobResponsiblity = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaJobResponsiblity() {
        return txtaJobResponsiblity;
    }

    public void setTxtaJobResponsiblity(HtmlInputTextarea hit) {
        this.txtaJobResponsiblity = hit;
    }
    private HtmlInputTextarea txtAQualification = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtAQualification() {
        return txtAQualification;
    }

    public void setTxtAQualification(HtmlInputTextarea hit) {
        this.txtAQualification = hit;
    }
    private HtmlInputTextarea txtAAdditionalSkill = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtAAdditionalSkill() {
        return txtAAdditionalSkill;
    }

    public void setTxtAAdditionalSkill(HtmlInputTextarea hit) {
        this.txtAAdditionalSkill = hit;
    }
    private HtmlSelectOneMenu drlNUmberOfYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNUmberOfYear() {
        return drlNUmberOfYear;
    }

    public void setDrlNUmberOfYear(HtmlSelectOneMenu hsom) {
        this.drlNUmberOfYear = hsom;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectOneListbox drlListOfJob = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getDrlListOfJob() {
        return drlListOfJob;
    }

    public void setDrlListOfJob(HtmlSelectOneListbox drlListOfJob) {
        this.drlListOfJob = drlListOfJob;
    }
    private HtmlInputText txtPosition = new HtmlInputText();

    public HtmlInputText getTxtPosition() {
        return txtPosition;
    }

    public void setTxtPosition(HtmlInputText hit) {
        this.txtPosition = hit;
    }
    private HtmlSelectBooleanCheckbox cboAnd = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboAnd() {
        return cboAnd;
    }

    public void setCboAnd(HtmlSelectBooleanCheckbox hsbc) {
        this.cboAnd = hsbc;
    }
    private HtmlSelectBooleanCheckbox cboOr = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboOr() {
        return cboOr;
    }

    public void setCboOr(HtmlSelectBooleanCheckbox hsbc) {
        this.cboOr = hsbc;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private HtmlOutputText lblConfirmation = new HtmlOutputText();

    public HtmlOutputText getLblConfirmation() {
        return lblConfirmation;
    }

    public void setLblConfirmation(HtmlOutputText hot) {
        this.lblConfirmation = hot;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private HtmlSelectBooleanCheckbox choOffice = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoOffice() {
        return choOffice;
    }

    public void setChoOffice(HtmlSelectBooleanCheckbox hsbc) {
        this.choOffice = hsbc;
    }
    private HtmlSelectBooleanCheckbox choShift = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoShift() {
        return choShift;
    }

    public void setChoShift(HtmlSelectBooleanCheckbox hsbc) {
        this.choShift = hsbc;
    }
    private HtmlOutputText lblErrorMessage = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessage() {
        return lblErrorMessage;
    }

    public void setLblErrorMessage(HtmlOutputText hot) {
        this.lblErrorMessage = hot;
    }
    private HtmlInputTextarea txtminmumExperance = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtminmumExperance() {
        return txtminmumExperance;
    }

    public void setTxtminmumExperance(HtmlInputTextarea hit) {
        this.txtminmumExperance = hit;
    }
    private PanelLayout message = new PanelLayout();

    public PanelLayout getMessage() {
        return message;
    }

    public void setMessage(PanelLayout pl) {
        this.message = pl;
    }
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    private HtmlSelectOneMenu drlLevelOfEducation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLevelOfEducation() {
        return drlLevelOfEducation;
    }

    public void setDrlLevelOfEducation(HtmlSelectOneMenu hsom) {
        this.drlLevelOfEducation = hsom;
    }
    private DefaultTableDataModel dataTable2Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model1() {
        return dataTable2Model1;
    }

    public void setDataTable2Model1(DefaultTableDataModel dtdm) {
        this.dataTable2Model1 = dtdm;
    }
    private HtmlCommandButton btnUpdateUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateUpdate() {
        return btnUpdateUpdate;
    }

    public void setBtnUpdateUpdate(HtmlCommandButton hcb) {
        this.btnUpdateUpdate = hcb;
    }
    private RowSelector rowSelectorSpecificEducationLevel = new RowSelector();

    public RowSelector getRowSelectorSpecificEducationLevel() {
        return rowSelectorSpecificEducationLevel;
    }

    public void setRowSelectorSpecificEducationLevel(RowSelector rs) {
        this.rowSelectorSpecificEducationLevel = rs;
    }
    private RowSelector rowSelectorSpecificQualification = new RowSelector();

    public RowSelector getRowSelectorSpecificQualification() {
        return rowSelectorSpecificQualification;
    }

    public void setRowSelectorSpecificQualification(RowSelector rs) {
        this.rowSelectorSpecificQualification = rs;
    }
    private HtmlInputText inputTextEducLevelID = new HtmlInputText();

    public HtmlInputText getInputTextEducLevelID() {
        return inputTextEducLevelID;
    }

    public void setInputTextEducLevelID(HtmlInputText hit) {
        this.inputTextEducLevelID = hit;
    }
    private HtmlInputText inputTextQualificationID = new HtmlInputText();

    public HtmlInputText getInputTextQualificationID() {
        return inputTextQualificationID;
    }

    public void setInputTextQualificationID(HtmlInputText hit) {
        this.inputTextQualificationID = hit;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckbox1Choice = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckbox1Choice() {
        return selectBooleanCheckbox1Choice;
    }

    public void setSelectBooleanCheckbox1Choice(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox1Choice = hsbc;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
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
    private HtmlSelectOneMenu selectOneMenu1Qualification = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1Qualification() {
        return selectOneMenu1Qualification;
    }

    public void setSelectOneMenu1Qualification(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1Qualification = hsom;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private HtmlSelectOneMenu drlEducationCatagory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationCatagory() {
        return drlEducationCatagory;
    }

    public void setDrlEducationCatagory(HtmlSelectOneMenu hsom) {
        this.drlEducationCatagory = hsom;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems1() {
        return selectOneListbox1DefaultItems1;
    }

    public void setSelectOneListbox1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems2() {
        return selectOneListbox1DefaultItems2;
    }

    public void setSelectOneListbox1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems3() {
        return selectOneListbox1DefaultItems3;
    }

    public void setSelectOneListbox1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems3 = dsia;
    }


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public JobType() {
    }
    ResourceBundle messageResource = null;
    FacesContext context = null;
    LookUpManager lookUpManager = new LookUpManager();
    DepartmentManage departmentManage = new DepartmentManage();
    //public Option[] _jobRank;//= lookUpManager.assignJobRank("civile");
    public Option[] jobExperiance = null;//departmentManage.readExperianceJob();
    public Option[] jobMinExperiance = null;// departmentManage.onDisplayJobExperiance();
    public ArrayList<SelectItem> listOfJobType = new ArrayList<SelectItem>();
    ArrayList<SelectItem> educLevelOpt = new ArrayList<SelectItem>();
    ArrayList<SelectItem> rankListOpt = new ArrayList<SelectItem>();
    private ArrayList<DepartmentManage> specificQualification = new ArrayList<DepartmentManage>();
    private ArrayList<DepartmentManage> specificQualificationUpdate = new ArrayList<DepartmentManage>();
    private ArrayList<DepartmentManage> specificEducationLevel = new ArrayList<DepartmentManage>();
    private ArrayList<DepartmentManage> specificEducationLevelUpdate = new ArrayList<DepartmentManage>();
    ArrayList<SelectItem> educTypeOpt = new ArrayList<SelectItem>();
    ArrayList<SelectItem> educCatagoryOpt = new ArrayList<SelectItem>();
    String type = null;
    int rowValueEducLevel = -1;
    int rowValueQualification = -1;

    public void setRankListOpt(ArrayList<SelectItem> rankListOpt) {
        this.rankListOpt = rankListOpt;
    }

    public ArrayList<SelectItem> getRankListOpt() {
        return lookUpManager.assignJobRank();
    }
    int tableIdentif = 0;
    int buttonIndicator = 0;

    public ArrayList<SelectItem> getEducTypeOpt() {
        if (drlEducationCatagory.getValue() == null || drlEducationCatagory.getValue().toString().equals("-1")) {
            educTypeOpt = lookUpManager.readEducationForJob();
        } else {
            educTypeOpt = lookUpManager.readEducationByCategoryForJob(drlEducationCatagory.getValue().toString());
        }
        return educTypeOpt;
    }

    public void setEducTypeOpt(ArrayList<SelectItem> educTypeOpt) {
        this.educTypeOpt = educTypeOpt;
    }

    public ArrayList<DepartmentManage> getSpecificQualificationUpdate() {
        return specificQualificationUpdate;
    }

    public void setSpecificQualificationUpdate(ArrayList<DepartmentManage> specificQualificationUpdate) {
        this.specificQualificationUpdate = specificQualificationUpdate;
    }

    public ArrayList<DepartmentManage> getSpecificEducationLevelUpdate() {
        return specificEducationLevelUpdate;
    }

    public void setSpecificEducationLevelUpdate(ArrayList<DepartmentManage> specificEducationLevelUpdate) {
        this.specificEducationLevelUpdate = specificEducationLevelUpdate;
    }

    public ArrayList<DepartmentManage> getSpecificEducationLevel() {
        return specificEducationLevel;
    }

    public void setSpecificEducationLevel(ArrayList<DepartmentManage> specificEducationLevel) {
        this.specificEducationLevel = specificEducationLevel;
    }

    public ArrayList<DepartmentManage> getSpecificQualification() {
        return specificQualification;
    }

    public void setSpecificQualification(ArrayList<DepartmentManage> specificQualification) {
        this.specificQualification = specificQualification;
    }

    public ArrayList<SelectItem> getListOfJobType() {
        ArrayList<SelectItem> forThisPage = departmentManage.readAllJob();
        if (forThisPage.size() > 0) {
            forThisPage.remove(0);
        }
        return forThisPage;
    }

    public void setListOfJobType(ArrayList<SelectItem> listOfJobType) {
        this.listOfJobType = listOfJobType;
    }
    //departmentManage.readAllJob();
    public ArrayList<SelectItem> _jobRank = lookUpManager.assignJobRank();//_jobRank = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> get_jobRank() {


        return _jobRank;
    }

    public void set_jobRank(ArrayList<SelectItem> _jobRank) {
        this._jobRank = _jobRank;
    }

    public Option[] getJobMinExperiance() {
        return jobMinExperiance;
    }

    public void setJobMinExperiance(Option[] jobMinExperiance) {
        this.jobMinExperiance = jobMinExperiance;
    }

    public Option[] getJobExperiance() {
        return jobExperiance;
    }

    public void setJobExperiance(Option[] jobExperiance) {
        this.jobExperiance = jobExperiance;
    }

    public ArrayList<SelectItem> getEducLevelOpt() {
        return lookUpManager.readEducationLevelMod();
    }

    public ArrayList<SelectItem> getEducCatagoryOpt() {
        return lookUpManager.readAllEducationCatagories();
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public int getButtonIndicator() {
        return buttonIndicator;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public LookUpManager getLookUpManager() {
        return lookUpManager;
    }

    public ResourceBundle getMessageResource() {
        return messageResource;
    }

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public int getRowValueEducLevel() {
        return rowValueEducLevel;
    }

    public int getRowValueQualification() {
        return rowValueQualification;
    }

    public int getTableIdentif() {
        return tableIdentif;
    }

    public String getType() {
        return type;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public void setButtonIndicator(int buttonIndicator) {
        this.buttonIndicator = buttonIndicator;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public void setEducCatagoryOpt(ArrayList<SelectItem> educCatagoryOpt) {
        this.educCatagoryOpt = educCatagoryOpt;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public void setLookUpManager(LookUpManager lookUpManager) {
        this.lookUpManager = lookUpManager;
    }

    public void setMessageResource(ResourceBundle messageResource) {
        this.messageResource = messageResource;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public void setRowValueEducLevel(int rowValueEducLevel) {
        this.rowValueEducLevel = rowValueEducLevel;
    }

    public void setRowValueQualification(int rowValueQualification) {
        this.rowValueQualification = rowValueQualification;
    }

    public void setTableIdentif(int tableIdentif) {
        this.tableIdentif = tableIdentif;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEducLevelOpt(ArrayList<SelectItem> educLevelOpt) {
        this.educLevelOpt = educLevelOpt;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
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
    EmployeeManage employeeManager = new EmployeeManage();

    public void init() {
        // Perform initializations inherited from our superclass
        this.disableComponent();
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


        txtJobName.setRequired(true);
        txtaJobResponsiblity.setRequired(true);
        drlRank.setRequired(true);
        drlRank.setRequiredMessage("Required");
        txtaJobResponsiblity.setRequiredMessage("Required");
//        txtJobCode.setRequiredMessage("Required");
        txtJobName.setRequiredMessage("Required");
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

    public void panelBorder1north_processMyEvent(DragEvent de) {
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public void btnExperiance_processAction(ActionEvent ae) {
        poupExperience.setRendered(false);
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public void saveJobType() {
        int controller = 1;
        int checkSave = 0;
        int saveIndicator = 0;
        int educLevelSize = this.specificEducationLevel.size();
        int qualificationSize = this.specificQualification.size();

        if (choOffice.isSelected()) {
            type = "Office";
        } else {
            type = "Shift";
        }

        DepartmentManage saveJob = new DepartmentManage(
                txtJobName.getValue().toString(),
                txtaJobResponsiblity.getValue().toString(),
                drlRank.getValue().toString(),
                txtAAdditionalSkill.getValue().toString(),
                type);
        Iterator<DepartmentManage> ittElevelValues = this.specificEducationLevel.iterator();
        Iterator<DepartmentManage> ittQualValues = this.specificQualification.iterator();

        if (educLevelSize >= qualificationSize && selectBooleanCheckbox1Choice.isSelected()) {
            while (ittElevelValues.hasNext()) {
                if (controller <= qualificationSize) {
                    DepartmentManage singleQualVal = ittQualValues.next();
                    DepartmentManage saveQualVal = new DepartmentManage(singleQualVal.getQualifcation());
                    DepartmentManage singleEducVal = ittElevelValues.next();
                    DepartmentManage saveEducLevelVal = new DepartmentManage(singleEducVal.getLevelOfEducation(), singleEducVal.getMinimumExperiance());
                    checkSave = departmentManage.saveJobType(saveJob, saveEducLevelVal, saveQualVal, 1, this.txtJobCode.getValue().toString());
                    saveIndicator++;
                } else {
                    DepartmentManage singleEducVal = ittElevelValues.next();
                    DepartmentManage saveEducLevelVal = new DepartmentManage(singleEducVal.getLevelOfEducation(), singleEducVal.getMinimumExperiance());

                    checkSave = departmentManage.saveJobType(saveJob, saveEducLevelVal, null, 1, this.txtJobCode.getValue().toString());
                    saveIndicator++;
                }
                controller++;
            }

        } else if (qualificationSize > educLevelSize && selectBooleanCheckbox1Choice.isSelected()) {
            while (ittQualValues.hasNext()) {
                if (controller <= educLevelSize) {
                    DepartmentManage singleQualVal = ittQualValues.next();
                    DepartmentManage saveQualVal = new DepartmentManage(singleQualVal.getQualifcation());

                    DepartmentManage singleEducVal = ittElevelValues.next();
                    DepartmentManage saveEducLevelVal = new DepartmentManage(singleEducVal.getLevelOfEducation(), singleEducVal.getMinimumExperiance());

                    checkSave = departmentManage.saveJobType(saveJob, saveEducLevelVal, saveQualVal, 1, this.txtJobCode.getValue().toString());
                    saveIndicator++;
                } else {
                    DepartmentManage singleQualVal = ittQualValues.next();
                    DepartmentManage saveQualVal = new DepartmentManage(singleQualVal.getQualifcation());

                    checkSave = departmentManage.saveJobType(saveJob, null, saveQualVal, 1, this.txtJobCode.getValue().toString());
                    saveIndicator++;
                }
                controller++;
            }

        } else if (!selectBooleanCheckbox1Choice.isSelected()) {//only to save requirements to job position
            checkSave = departmentManage.saveJobType(saveJob, null, null, -1, "");
        }


        if (checkSave == 1) {
            showSuccessOrFailureMessage(true, "JOb Information Successfully Registered.  ");
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(false);
            this.specificEducationLevel.clear();
            this.specificQualification.clear();
            disableComponent();

        } else {
            showSuccessOrFailureMessage(true, "Error occured During Saving job information.Please try again ? ");
            this.specificEducationLevel.clear();
            this.specificQualification.clear();
            btnReset.setDisabled(false);
        }

    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void updateJobType() {
        int checkUpdate = 0;
        DepartmentManage saveJob = new DepartmentManage(
                txtJobName.getValue().toString(),
                txtaJobResponsiblity.getValue().toString(),
                drlRank.getValue().toString(),
                selectOneMenu1Qualification.getValue().toString(),
                txtAAdditionalSkill.getValue().toString(),
                txtminmumExperance.getValue().toString(), type);

        Iterator<DepartmentManage> ittElevelValues = this.specificEducationLevelUpdate.iterator();
        while (ittElevelValues.hasNext()) {
            DepartmentManage singleEducVal = ittElevelValues.next();
            DepartmentManage saveEducLevelVal = new DepartmentManage(singleEducVal.getLevelOfEducationID(), singleEducVal.getLevelOfEducation(), singleEducVal.getMinimumExperiance(), 0);

            checkUpdate = departmentManage.updateJobType(saveJob, saveEducLevelVal, null, txtJobCode.getValue().toString());
        }
        if (checkUpdate == 1) {
            showSuccessOrFailureMessage(true, "JOb Information Updated Successfully.  ");
            btnDelete.setDisabled(false);
        } else {
            showSuccessOrFailureMessage(false, "Error occured During Updated Operation.Please try again ?");
        }
        this.specificEducationLevelUpdate.clear();
    }

    public void drlListOfJob_processValueChange(ValueChangeEvent vce) {
        buttonIndicator = 8;
        clearComponents();
        disableComponent();
        lblConfirmation.setRendered(false);
        this.specificEducationLevel.clear();
        this.specificQualification.clear();
        btnUpdate.setDisabled(false);

        try {

            ArrayList<HashMap[]> jobdetil = departmentManage.selectJobdetail1(vce.getNewValue().toString());



            if (jobdetil != null) {
                if (jobdetil.size() == 2) {

                    HashMap[] jobDitailList = jobdetil.get(0);
                    HashMap[] jobDitailList1 = jobdetil.get(1);

                    if (jobDitailList.length >= jobDitailList1.length) {

                        txtJobCode.setValue(jobDitailList[0].get("JOB_CODE"));
                        txtJobName.setValue(jobDitailList[0].get("JOB_DESCRIPTION"));
                        txtaJobResponsiblity.setValue(jobDitailList[0].get("MIN_RESPONSIBILITY"));
                        txtAAdditionalSkill.setValue(jobDitailList[0].get("ADDITIONALSKILL"));
                        if (jobDitailList[0].get("TYPE").equals("Shift")) {
                            choShift.setSelected(true);
                            this.set_jobRank(lookUpManager.assignJobRank("Shift"));
                        } else if (jobDitailList[0].get("TYPE").equals("Office")) {
                            choOffice.setSelected(true);
                            this.set_jobRank(lookUpManager.assignJobRank("Employee"));
                        }
                        drlRank.resetValue();
                        drlRank.setValue(jobDitailList[0].get("RANK_ID"));

                        for (int i = 0; i < jobDitailList.length; i++) {
                            DepartmentManage depManJobDetail = new DepartmentManage(jobDitailList[i].get("JOB_TYPE_EDUC_LEVEL_ID").toString(),
                                    jobDitailList[i].get("EDUCATION_LEVEL").toString(),
                                    jobDitailList[i].get("MIN_EXPERIENCE").toString(), 0, "Old");
                            this.specificEducationLevel.add(depManJobDetail);

                        }

                        for (int i = 0; i < jobDitailList1.length; i++) {
                            DepartmentManage depManJobDetail1 = new DepartmentManage(jobDitailList1[i].get("JOB_TYPE_QUALIFICATION_ID").toString(),
                                    jobDitailList1[i].get("QUALIFICATION").toString(), 0, "Old");
                            this.specificQualification.add(depManJobDetail1);
                        }
                        btnUpdate.setDisabled(false);
                        btnDelete.setDisabled(false);

                    } else if (jobDitailList1.length > jobDitailList.length) {
                        txtJobCode.setValue(jobDitailList1[0].get("JOB_CODE"));
                        txtJobName.setValue(jobDitailList1[0].get("JOB_DESCRIPTION"));
                        txtaJobResponsiblity.setValue(jobDitailList1[0].get("MIN_RESPONSIBILITY"));
                        txtAAdditionalSkill.setValue(jobDitailList1[0].get("ADDITIONALSKILL"));
                        if (jobDitailList1[0].get("TYPE").equals("Shift")) {
                            choShift.setSelected(true);
                            this.set_jobRank(lookUpManager.assignJobRank("Shift"));
                        } else if (jobDitailList1[0].get("TYPE").equals("Office")) {
                            choOffice.setSelected(true);
                            this.set_jobRank(lookUpManager.assignJobRank("Employee"));
                        }
                        drlRank.resetValue();
                        drlRank.setValue(jobDitailList1[0].get("RANK_ID"));

                        for (int i = 0; i < jobDitailList.length; i++) {
                            DepartmentManage depManJobDetail = new DepartmentManage(jobDitailList[i].get("JOB_TYPE_EDUC_LEVEL_ID").toString(),
                                    jobDitailList[i].get("EDUCATION_LEVEL").toString(),
                                    jobDitailList[i].get("MIN_EXPERIENCE").toString(), 0);
                            this.specificEducationLevel.add(depManJobDetail);

                        }

                        for (int i = 0; i < jobDitailList1.length; i++) {
                            DepartmentManage depManJobDetail1 = new DepartmentManage(jobDitailList1[i].get("JOB_TYPE_QUALIFICATION_ID").toString(),
                                    jobDitailList1[i].get("QUALIFICATION").toString(),
                                    0);
                            this.specificQualification.add(depManJobDetail1);
                        }
                        btnUpdate.setDisabled(false);
                        btnDelete.setDisabled(false);
                    }

                } else if (jobdetil.size() == 1) {
                    HashMap[] jobDitailList = jobdetil.get(0);
                    txtJobCode.setValue(jobDitailList[0].get("JOB_CODE"));
                    txtJobName.setValue(jobDitailList[0].get("JOB_DESCRIPTION"));
                    txtaJobResponsiblity.setValue(jobDitailList[0].get("MIN_RESPONSIBILITY"));
                    txtAAdditionalSkill.setValue(jobDitailList[0].get("ADDITIONALSKILL"));
                    if (jobDitailList[0].get("TYPE").equals("Shift")) {
                        choShift.setSelected(true);
                        this.set_jobRank(lookUpManager.assignJobRank("Shift"));
                    } else if (jobDitailList[0].get("TYPE").equals("Office")) {
                        choOffice.setSelected(true);
                        this.set_jobRank(lookUpManager.assignJobRank("Employee"));
                    }
                    drlRank.resetValue();
                    drlRank.setValue(jobDitailList[0].get("RANK_ID"));
                }
            } else {
            }
        } catch (Exception ex) {
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(false);
            ex.printStackTrace();
        }
    }

    private void disableComponent() {
        txtAAdditionalSkill.setDisabled(true);
        selectOneMenu1Qualification.setDisabled(true);
        txtJobName.setDisabled(true);
        txtaJobResponsiblity.setDisabled(true);
        drlRank.setDisabled(true);
        txtminmumExperance.setDisabled(true);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(true);
        btnUpdate.setDisabled(true);
        choOffice.setDisabled(true);
        choShift.setDisabled(true);
        drlLevelOfEducation.setDisabled(true);
    }

    private void enableComponent() {
        txtAAdditionalSkill.setDisabled(false);
        selectOneMenu1Qualification.setDisabled(false);
        txtJobName.setDisabled(false);
        txtaJobResponsiblity.setDisabled(false);
        drlRank.setDisabled(false);
        txtminmumExperance.setDisabled(false);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(false);
        choOffice.setDisabled(false);
        choShift.setDisabled(false);
        drlLevelOfEducation.setDisabled(false);
        drlEducationCatagory.resetValue();
    }

    public void btnReset_processAction(ActionEvent ae) {
        buttonIndicator = 7;
        this.clearComponents();
        lblConfirmation.setRendered(false);
        disableComponent();
    }

    void clearComponents() {
        txtAAdditionalSkill.setValue("");
        selectOneMenu1Qualification.setValue("0");
        txtJobCode.setValue("");
        txtJobName.setValue("");
        txtaJobResponsiblity.setValue("");
        drlRank.setValue("");
        txtminmumExperance.setValue("");
        choOffice.setSelected(false);
        choShift.setSelected(false);

    }

    public void cboAnd_processValueChange(ValueChangeEvent vce) {
    }

    public void btnAdd_processAction(ActionEvent ae) {
        String typeorand = null;
        if (cboAnd.isSelected()) {
            typeorand = "And";
        }
        if (cboOr.isSelected()) {
            typeorand = "Or";
        }
        DepartmentManage minExpriance = new DepartmentManage(txtPosition.getValue().toString(), Integer.parseInt(drlNUmberOfYear.getValue().toString()), typeorand, txtJobCode.getValue().toString());
        this.getSessionBean1().minExperiance.add(minExpriance);
    }

    public void btnSaveExperance_processAction(ActionEvent ae) {
        List minExperiance = this.getSessionBean1().getMinExperiance();
        Iterator<DepartmentManage> iter = minExperiance.iterator();
        int n = 0;
        try {
            while (iter.hasNext()) {
                DepartmentManage minExp = iter.next();
                n = departmentManage.saveMinimumExperience(minExp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (n == 1) {
        }

        poupExperience.setRendered(false);

    }

    public void btnUpdate_processAction(ActionEvent ae) {
        lblConfirmation.setRendered(false);
        if (btnUpdate.getValue().equals("Edit")) {
            btnUpdate.setValue("Update");
            this.enableComponent();
        } else {
            this.updateJobType();
        }
    }

    public void btnDelete_processAction(ActionEvent ae) {
        buttonIndicator = 6;
        int checkDelete = 0;
        if (!this.selectBooleanCheckbox1Choice.isSelected()) {
            try {
                lblConfirmation.setRendered(true);
                checkDelete = departmentManage.deleteJobType(txtJobCode.getValue().toString());
                if (checkDelete == 1) {
                    this.showSuccessOrFailureMessage(true, "JOb Information Successfully Deleted ");
                    clearComponents();
                } else {
                    this.showSuccessOrFailureMessage(false, "Error occured Deleted Saving job information.Please try again ? ");
                }
            } catch (Exception ex) {
            }
        } else if (this.selectBooleanCheckbox1Choice.isSelected()) {

            if (tableIdentif == 1) {
                if (rowValueEducLevel == -1) {
                    this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
                } else if (specificEducationLevel.isEmpty() == true && rowValueEducLevel != -1) {
                    this.showSuccessOrFailureMessage(false, "The Table is Empty!");
                } else {
                    DepartmentManage departmentObj = (DepartmentManage) specificEducationLevel.get(rowValueEducLevel);
                    checkDelete = departmentManage.deleteJobDetail(departmentObj.getLevelOfEducationID(), 1);
                    if (checkDelete == 1) {
                        specificEducationLevel.remove(rowValueEducLevel);
                        this.showSuccessOrFailureMessage(true, "JOb Information Successfully Deleted ");
                        clearComponents();
                    } else {
                        this.showSuccessOrFailureMessage(false, "Error occured Deleted Saving job information.Please try again ? ");
                    }
                }
            } else if (tableIdentif == 2) {
                if (rowValueQualification == -1) {
                    this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
                } else if (specificQualification.isEmpty() == true && rowValueQualification != -1) {
                    this.showSuccessOrFailureMessage(false, "The Table is Empty!");

                } else {
                    DepartmentManage departmentObj = (DepartmentManage) specificQualification.get(rowValueQualification);
                    checkDelete = departmentManage.deleteJobDetail(departmentObj.getJobQualificationID(), 2);
                    if (checkDelete == 1) {
                        specificQualification.remove(rowValueQualification);
                        this.showSuccessOrFailureMessage(true, "JOb Information Successfully Deleted ");
                        clearComponents();
                    } else {
                        this.showSuccessOrFailureMessage(false, "Error occured Deleted Saving job information.Please try again ? ");
                    }
                }
            } else {
                this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
            }
        }
    }

    public String txtJobCode_action() {
        //return null means stay on the same page
        return null;
    }

    public void choOffice_processValueChange(ValueChangeEvent vce) {
        lblErrorMessage.setRendered(false);
        choShift.setSelected(false);
        this.set_jobRank(lookUpManager.assignJobRank("Office"));
    }

    public void choShift_processValueChange(ValueChangeEvent vce) {
        lblErrorMessage.setRendered(false);
        choOffice.setSelected(false);
        this.set_jobRank(lookUpManager.assignJobRank("Shift"));
    }

    public String btnSave_action() {
        buttonIndicator = 1;
        try {
            this.enableComponent();
            drlEducationCatagory.resetValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String cmdOrganizationStructur_action() {
        //return null means stay on the same page
        return "OrganizationStructure";
    }

    public String cmdJobType_action() {
        //return null means stay on the same page
        return "JobType";
    }

    public String btnReset_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnAddToTable_action() {
        int educIndic = 0;
        int qualIndic = 0;
        String educLevel[] = drlLevelOfEducation.getValue().toString().split("--");

        if (buttonIndicator == 1) {

            if (!this.specificQualification.isEmpty() && !this.specificEducationLevel.isEmpty()) {

                Iterator<DepartmentManage> ittElevelValues = this.specificEducationLevel.iterator();
                Iterator<DepartmentManage> ittQualValues = this.specificQualification.iterator();
                while (ittElevelValues.hasNext()) {
                    DepartmentManage singleEducVal = ittElevelValues.next();
                    if (singleEducVal.getLevelOfEducation().toString().equals(educLevel[1])) {
                        educIndic = 1;
                    }
                }
                while (ittQualValues.hasNext()) {
                    DepartmentManage singleQualVal = ittQualValues.next();
                    if (singleQualVal.getQualifcation().toString().equals(this.selectOneMenu1Qualification.getValue().toString())) {
                        qualIndic = 1;
                    }
                }
                if (educIndic == 0 && qualIndic == 0) {
                    DepartmentManage departmentObj = new DepartmentManage(selectOneMenu1Qualification.getValue().toString(), txtminmumExperance.getValue().toString(), educLevel[1]);
                    this.specificQualification.add(departmentObj);
                    this.specificEducationLevel.add(departmentObj);
                } else if (educIndic == 0 && qualIndic == 1) {
                    DepartmentManage departmentObj = new DepartmentManage(selectOneMenu1Qualification.getValue().toString(), txtminmumExperance.getValue().toString(), educLevel[1]);
                    this.specificEducationLevel.add(departmentObj);
                } else if (educIndic == 1 && qualIndic == 0) {
                    DepartmentManage departmentObj = new DepartmentManage(selectOneMenu1Qualification.getValue().toString(), txtminmumExperance.getValue().toString(), educLevel[1]);
                    this.specificQualification.add(departmentObj);
                }
            } else {
                DepartmentManage departmentObj = new DepartmentManage(selectOneMenu1Qualification.getValue().toString(), txtminmumExperance.getValue().toString(), educLevel[1]);
                this.specificQualification.add(departmentObj);
                this.specificEducationLevel.add(departmentObj);
            }
        } else if (buttonIndicator == 4) {
            if (tableIdentif == 1) {
                DepartmentManage departmentObj = new DepartmentManage(this.inputTextEducLevelID.getValue().toString(), educLevel[1], txtminmumExperance.getValue().toString(), 0, "New");
                this.specificEducationLevel.add(this.rowValueEducLevel, departmentObj);
                this.specificEducationLevelUpdate.add(departmentObj);
            }
        }
        return null;
    }

    public String btnSaveSave_action() {
        buttonIndicator = 3;
        if (choOffice.isSelected() || choShift.isSelected()) {
            lblErrorMessage.setRendered(false);
            this.saveJobType();
        } else {
            lblErrorMessage.setRendered(true);
            lblErrorMessage.setValue("Required");
        }
        return null;
    }

    public String btnUpdate_action() {
        buttonIndicator = 4;
        lblConfirmation.setRendered(false);
        this.enableComponent();
        if (tableIdentif == 1) {
            if (rowValueEducLevel == -1) {
                this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
            } else if (specificEducationLevel.isEmpty() == true && rowValueEducLevel != -1) {
                this.showSuccessOrFailureMessage(false, "The Table is Empty!");

            } else {
                DepartmentManage departmentObj = (DepartmentManage) specificEducationLevel.get(rowValueEducLevel);
                specificEducationLevel.remove(rowValueEducLevel);
                this.txtminmumExperance.setValue(departmentObj.getMinimumExperiance());
                this.inputTextEducLevelID.setValue(departmentObj.getLevelOfEducationID());
            }
        } else if (tableIdentif == 2) {
            if (rowValueQualification == -1) {
                this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
            } else if (specificQualification.isEmpty() == true && rowValueQualification != -1) {
                this.showSuccessOrFailureMessage(false, "The Table is Empty!");
            } else {
                DepartmentManage departmentObj = (DepartmentManage) specificQualification.get(rowValueQualification);
                specificQualification.remove(rowValueQualification);
                this.selectOneMenu1Qualification.setValue(departmentObj.getQualifcation());
                this.inputTextQualificationID.setValue(departmentObj.getJobQualificationID());
            }
        } else {
            this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        }
        return null;
    }

    public String btnUpdateUpdate_action() {
        buttonIndicator = 5;
        if (choOffice.isSelected()) {
            type = "Office";
        } else {
            type = "Shift";
        }
        this.updateJobType();
        return null;
    }

    public void rowSelectorSpecificQualification_processMyEvent(RowSelectorEvent rse) {
        rowValueQualification = rse.getRow();
        tableIdentif = 2;
    }

    public void rowSelectorSpecificEducationLevel_processMyEvent(RowSelectorEvent rse) {
        rowValueEducLevel = rse.getRow();
        tableIdentif = 1;
    }

    public void drlEducationCatagory_processValueChange(ValueChangeEvent vce) {
        educTypeOpt = lookUpManager.readEducationByCategoryForJob(vce.getNewValue().toString());
    }

    public void selectOneMenu1Qualification_processValueChange(ValueChangeEvent vce) {
    }

    public String btnDelete_action() {
        //return null means stay on the same page
        return null;
    }

    public void page_display_processMyEvent(DragEvent de) {
    }
}

