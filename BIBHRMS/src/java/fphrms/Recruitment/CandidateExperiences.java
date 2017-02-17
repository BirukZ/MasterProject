/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import control.ReportControl;
import java.text.ParseException;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.Employee.EmployeePage;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import manager.ReportCritera.ReportCriteraManager;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.recruitmentManager.AdvertisementManager;
import manager.recruitmentManager.CandidateExperienceManager;
import manager.recruitmentManager.CandidateManager;
import manager.recruitmentManager.JasperReport;
import manager.reporterManager.employeeProfileReportManager.EmployeeProfileReportManager;
import org.apache.poi.ss.usermodel.DataValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version CandidateEducation.java
 * @version Created on Mar 23, 2012, 11:04:14 AM
 * @author Administrator
 */
public class CandidateExperiences extends AbstractPageBean {

    String experiencePrivateOrGovernmental = "";
    String experienceContractOrPrtmanent = "";
    String experianceId = "0";
    String candidateId = null;
    String job_Discripton = "";
    public String batchCode;
    public int candidateID;
    int equvalentJobCode;
    int counter = 0;
    int tableSize;
    int buttonIdentifier = 0;
    int selectedExperience = -1;
    public List listOfExperience = new ArrayList<CandidateExperienceManager>();
    public List listOfExpUpdate = new ArrayList<CandidateExperienceManager>();
    ArrayList<SelectItem> CandidateNameList = new ArrayList<SelectItem>();
    ArrayList<CandidateExperienceManager> candidateExpiranceList = new ArrayList<CandidateExperienceManager>();
    DepartmentManage departmentManage = new DepartmentManage();
    CandidateManager candidateManager = new CandidateManager();
    CandidateExperienceManager candidateExperienceManager = new CandidateExperienceManager();
     ReportCriteraManager reportManger = new ReportCriteraManager();
     GregorianCalendarManipulation calander=new GregorianCalendarManipulation();
    String dataIsOnEditExperience = "NO";
    private SelectInputDateBean selectInputDateExperienceStart = new SelectInputDateBean();
    ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();
    AdvertisementManager advertisementManager = new AdvertisementManager();
    Option[] recruitmentBatchCodeSearchOpt = null;

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public ArrayList<SelectItem> getCandidateNameList() {
        return CandidateNameList;
    }

    public void setCandidateNameList(ArrayList<SelectItem> CandidateNameList) {
        this.CandidateNameList = CandidateNameList;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public ArrayList<CandidateExperienceManager> getCandidateExpiranceList() {
        return candidateExpiranceList;
    }

    public void setCandidateExpiranceList(ArrayList<CandidateExperienceManager> candidateExpiranceList) {
        this.candidateExpiranceList = candidateExpiranceList;
    }

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

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public ArrayList<SelectItem> getPerofation() {
        ArrayList<SelectItem> forThisPage = departmentManage.readAllJob();
        if (forThisPage.size() > 0) {
            forThisPage.remove(0);
        }
        return forThisPage;
    }

    public void setPerofation(ArrayList<SelectItem> perofation)
    {
        this.perofation = perofation;
    }

    public SelectInputDateBean getSelectInputDateExperienceStart() {
        return selectInputDateExperienceStart;
    }

    public void setSelectInputDateExperienceStart(SelectInputDateBean selectInputDateExperienceStart) {
        this.selectInputDateExperienceStart = selectInputDateExperienceStart;
    }

    public int getButtonIdentifier() {
        return buttonIdentifier;
    }

    public void setButtonIdentifier(int buttonIdentifier) {
        this.buttonIdentifier = buttonIdentifier;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public CandidateManager getCandidateManager() {
        return candidateManager;
    }

    public void setCandidateManager(CandidateManager candidateManager) {
        this.candidateManager = candidateManager;
    }

    public CandidateExperienceManager getCandidateExperienceManager() {
        return candidateExperienceManager;
    }

    public void setCandidateExperienceManager(CandidateExperienceManager candidateExperienceManager) {
        this.candidateExperienceManager = candidateExperienceManager;
    }

    public String getDataIsOnEditExperience() {
        return dataIsOnEditExperience;
    }

    public void setDataIsOnEditExperience(String dataIsOnEditExperience) {
        this.dataIsOnEditExperience = dataIsOnEditExperience;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public int getEquvalentJobCode() {
        return equvalentJobCode;
    }

    public void setEquvalentJobCode(int equvalentJobCode) {
        this.equvalentJobCode = equvalentJobCode;
    }

    public String getJob_Discripton() {
        return job_Discripton;
    }

    public void setJob_Discripton(String job_Discripton) {
        this.job_Discripton = job_Discripton;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getExperianceId() {
        return experianceId;
    }

    public void setExperianceId(String experianceId) {
        this.experianceId = experianceId;
    }

    public String getExperienceContractOrPrtmanent() {
        return experienceContractOrPrtmanent;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }

    public void setExperienceContractOrPrtmanent(String experienceContractOrPrtmanent) {
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
    }

    public String getExperiencePrivateOrGovernmental() {
        return experiencePrivateOrGovernmental;
    }

    public void setExperiencePrivateOrGovernmental(String experiencePrivateOrGovernmental) {
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
    }

    public List getListOfExpUpdate() {
        return listOfExpUpdate;
    }

    public void setListOfExpUpdate(List listOfExpUpdate) {
        this.listOfExpUpdate = listOfExpUpdate;
    }

    public int getSelectedExperience() {
        return selectedExperience;
    }

    public void setSelectedExperience(int selectedExperience) {
        this.selectedExperience = selectedExperience;
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    public List getListOfExperience() {
        return listOfExperience;
    }

    public void setListOfExperience(List listOfExperience) {
        this.listOfExperience = listOfExperience;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlInputText txtExperianceInstitution = new HtmlInputText();

    public HtmlInputText getTxtExperianceInstitution() {
        return txtExperianceInstitution;
    }

    public void setTxtExperianceInstitution(HtmlInputText hit) {
        this.txtExperianceInstitution = hit;
    }
    private HtmlInputText txtJobType = new HtmlInputText();

    public HtmlInputText getTxtJobType() {
        return txtJobType;
    }

    public void setTxtJobType(HtmlInputText hit) {
        this.txtJobType = hit;
    }
    private HtmlInputText txtExperanceSalary = new HtmlInputText();

    public HtmlInputText getTxtExperanceSalary() {
        return txtExperanceSalary;
    }

    public void setTxtExperanceSalary(HtmlInputText hit) {
        this.txtExperanceSalary = hit;
    }
    private HtmlInputText txtExRank = new HtmlInputText();

    public HtmlInputText getTxtExRank() {
        return txtExRank;
    }

    public void setTxtExRank(HtmlInputText hit) {
        this.txtExRank = hit;
    }
    private HtmlSelectBooleanCheckbox ckbExperiencePermanent = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperiencePermanent() {
        return ckbExperiencePermanent;
    }

    public void setCkbExperiencePermanent(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperiencePermanent = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbExperienceContract = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperienceContract() {
        return ckbExperienceContract;
    }

    public void setCkbExperienceContract(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperienceContract = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbExperienceGovernmental = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperienceGovernmental() {
        return ckbExperienceGovernmental;
    }

    public void setCkbExperienceGovernmental(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperienceGovernmental = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbExperiencePrivate = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperiencePrivate() {
        return ckbExperiencePrivate;
    }

    public void setCkbExperiencePrivate(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperiencePrivate = hsbc;
    }
    private HtmlInputTextarea txtTerminationReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtTerminationReason() {
        return txtTerminationReason;
    }

    public void setTxtTerminationReason(HtmlInputTextarea hit) {
        this.txtTerminationReason = hit;
    }
    private HtmlCommandButton btnAddExperience = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddExperience() {
        return btnAddExperience;
    }

    public void setBtnAddExperience(HtmlCommandButton hcb) {
        this.btnAddExperience = hcb;
    }
    private HtmlCommandButton btnEXNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXNew() {
        return btnEXNew;
    }

    public void setBtnEXNew(HtmlCommandButton hcb) {
        this.btnEXNew = hcb;
    }
    private HtmlCommandButton btnEXSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXSave() {
        return btnEXSave;
    }

    public void setBtnEXSave(HtmlCommandButton hcb) {
        this.btnEXSave = hcb;
    }
    private HtmlCommandButton btnEXEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXEdit() {
        return btnEXEdit;
    }

    public void setBtnEXEdit(HtmlCommandButton hcb) {
        this.btnEXEdit = hcb;
    }
    private HtmlCommandButton btnEXUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXUpdate() {
        return btnEXUpdate;
    }

    public void setBtnEXUpdate(HtmlCommandButton hcb) {
        this.btnEXUpdate = hcb;
    }
    private HtmlCommandButton btnEXReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXReset() {
        return btnEXReset;
    }

    public void setBtnEXReset(HtmlCommandButton hcb) {
        this.btnEXReset = hcb;
    }
    private HtmlCommandButton btnEXDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXDelete() {
        return btnEXDelete;
    }

    public void setBtnEXDelete(HtmlCommandButton hcb) {
        this.btnEXDelete = hcb;
    }
    private HtmlInputText txtDisplayedExpStartDate = new HtmlInputText();

    public HtmlInputText getTxtDisplayedExpStartDate() {
        return txtDisplayedExpStartDate;
    }

    public void setTxtDisplayedExpStartDate(HtmlInputText hit) {
        this.txtDisplayedExpStartDate = hit;
    }
    private HtmlInputText txtDisplayedExpEndDate = new HtmlInputText();

    public HtmlInputText getTxtDisplayedExpEndDate() {
        return txtDisplayedExpEndDate;
    }

    public void setTxtDisplayedExpEndDate(HtmlInputText hit) {
        this.txtDisplayedExpEndDate = hit;
    }
    private SelectInputDate calExpEndDate = new SelectInputDate();

    public SelectInputDate getCalExpEndDate() {
        return calExpEndDate;
    }

    public void setCalExpEndDate(SelectInputDate sid) {
        this.calExpEndDate = sid;
    }
    private SelectInputDate calExpStartDate = new SelectInputDate();

    public SelectInputDate getCalExpStartDate() {
        return calExpStartDate;
    }

    public void setCalExpStartDate(SelectInputDate sid) {
        this.calExpStartDate = sid;
    }
    private HtmlDataTable tableExperiance = new HtmlDataTable();

    public HtmlDataTable getTableExperiance() {
        return tableExperiance;
    }

    public void setTableExperiance(HtmlDataTable hdt) {
        this.tableExperiance = hdt;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }
    private HtmlPanelGroup pnlgridpnMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlgridpnMessage() {
        return pnlgridpnMessage;
    }
    private HtmlPanelGroup panelGroupMessageExam = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessageExam() {
        return panelGroupMessageExam;
    }

    public void setPanelGroupMessageExam(HtmlPanelGroup hpg) {
        this.panelGroupMessageExam = hpg;
    }
    private PanelLayout pnlMessageBodyExam = new PanelLayout();

    public PanelLayout getPnlMessageBodyExam() {
        return pnlMessageBodyExam;
    }

    public void setPnlMessageBodyExam(PanelLayout pl) {
        this.pnlMessageBodyExam = pl;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessageExam = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessageExam() {
        return lblFormMessageExam;
    }

    public void setLblFormMessageExam(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessageExam = hol;
    }

    public void setPnlgridpnMessage(HtmlPanelGroup hpg) {
        this.pnlgridpnMessage = hpg;
    }
    private HtmlCommandLink btnClosePopupSuccessOrFailure = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupSuccessOrFailure() {
        return btnClosePopupSuccessOrFailure;
    }

    public void setBtnClosePopupSuccessOrFailure(HtmlCommandLink hcl) {
        this.btnClosePopupSuccessOrFailure = hcl;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup hpg) {
        this.panelGroupMessage = hpg;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel hol) {
        this.lblSuccessOrErrorMessage = hol;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbProfassion = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbProfassion() {
        return ckbProfassion;
    }

    public void setCkbProfassion(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbProfassion = hsbc;
    }
    private HtmlSelectOneMenu drlJobCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJobCode() {
        return drlJobCode;
    }

    public void setDrlJobCode(HtmlSelectOneMenu hsom) {
        this.drlJobCode = hsom;
    }
    private SelectInputText txtSearchCandidate = new SelectInputText();

    public SelectInputText getTxtSearchCandidate() {
        return txtSearchCandidate;
    }

    public void setTxtSearchCandidate(SelectInputText sit) {
        this.txtSearchCandidate = sit;
    }
    private HtmlSelectOneRadio rdRelation = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRdRelation() {
        return rdRelation;
    }

    public void setRdRelation(HtmlSelectOneRadio hsor) {
        this.rdRelation = hsor;
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
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drl_BatchCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_BatchCode() {
        return drl_BatchCode;
    }

    public void setDrl_BatchCode(HtmlSelectOneMenu hsom) {
        this.drl_BatchCode = hsom;
    }
    private HtmlSelectOneMenu drl_CandidatName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_CandidatName() {
        return drl_CandidatName;
    }

    public void setDrl_CandidatName(HtmlSelectOneMenu hsom) {
        this.drl_CandidatName = hsom;
    }
    private HtmlOutputText out_date_message = new HtmlOutputText();

    public HtmlOutputText getOut_date_message() {
        return out_date_message;
    }

    public void setOut_date_message(HtmlOutputText hot) {
        this.out_date_message = hot;
    }
    private HtmlOutputText out_txt_candidate_ID = new HtmlOutputText();

    public HtmlOutputText getOut_txt_candidate_ID() {
        return out_txt_candidate_ID;
    }

    public void setOut_txt_candidate_ID(HtmlOutputText hot) {
        this.out_txt_candidate_ID = hot;
    }


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CandidateExperiences() {
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
        getListOfJobType();
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
            log("CandidateEducation Initialization Failure", e);
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

    public String cmdRecruitment_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdRecruitmentApproval_action() {
        //return null means stay on the same page
        return "InternalVacancyList";
    }

    public String cmdVacancyNotice_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdFilterCandidates_action() {
        //return null means stay on the same page
        return "FilterCandidates";
    }

    public String cmdRegisterCandidate_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }

    public String cmdVacantSpaces_action() {
        //return null means stay on the same page
        return "RecruitmentApprove";
    }
    int [] daydiff;
    int [] expriance;
    String [] expTotal;
    String [] totalCandidateExpirance;
    private ImageIcon LOGO;
    JasperReport jasperReport=new JasperReport();
    ReportControl reportControl = new ReportControl();

    public String[] getTotalCandidateExpirance() {
        return totalCandidateExpirance;
    }

    public void setTotalCandidateExpirance(String[] totalCandidateExpirance) {
        this.totalCandidateExpirance = totalCandidateExpirance;
    }

    public void setExpTotal(String[] expTotal) {
        this.expTotal = expTotal;
    }




    public int[] getExpriance() {
        return expriance;
    }

    public void setExpriance(int[] expriance) {
        this.expriance = expriance;
    }

    public int[] getDaydiff() {
        return daydiff;
    }

    public void setDaydiff(int[] daydiff) {
        this.daydiff = daydiff;
    }

    public void ckbExperiencePermanent_processValueChange(ValueChangeEvent vce) {
        if (ckbExperiencePermanent.isSelected()) {
            ckbExperienceContract.setSelected(false);
            experienceContractOrPrtmanent =
                    "Permanent";
        } else {
            experienceContractOrPrtmanent = "";
        }

    }

    public void ckbExperienceContract_processValueChange(ValueChangeEvent vce) {
        if (ckbExperienceContract.isSelected()) {
            ckbExperiencePermanent.setSelected(false);
            experienceContractOrPrtmanent =
                    "Contract";
        } else {
            experienceContractOrPrtmanent = "";
        }

    }

    public void ckbExperiencePrivate_processValueChange(ValueChangeEvent vce) {
        if (ckbExperiencePrivate.isSelected()) {
            ckbExperienceGovernmental.setSelected(false);
            experiencePrivateOrGovernmental =
                    "Private";
        } else {
            experiencePrivateOrGovernmental = "";
        }

    }

    public void ckbExperienceGovernmental_processValueChange(ValueChangeEvent vce) {
        if (ckbExperienceGovernmental.isSelected()) {
            ckbExperiencePrivate.setSelected(false);
            experiencePrivateOrGovernmental =
                    "Gov'tal";
        } else {
            experiencePrivateOrGovernmental = "";
        }

    }

    public void calExpStartDate_processValueChange(ValueChangeEvent vce) {
        txtDisplayedExpStartDate.setDisabled(false);
        txtDisplayedExpStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calExpStartDate.setRendered(false);
    }

    public void calExpEndDate_processValueChange(ValueChangeEvent vce) {
        txtDisplayedExpEndDate.setDisabled(false);
        txtDisplayedExpEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calExpEndDate.setRendered(false);
    }
  public Option[] getRecruitmentBatchCodeSearchOpt() {
        recruitmentBatchCodeSearchOpt = advertisementManager.recruitmentBatchCodeApp();
        return recruitmentBatchCodeSearchOpt;
    }
  public void setRecruitmentBatchCodeSearchOpt(Option[] recruitmentBatchCodeSearchOpt) {
        this.recruitmentBatchCodeSearchOpt = recruitmentBatchCodeSearchOpt;
    }

  ////////////////////////////////////////////////////////////////////



    public void addCandidateExperiance() throws ParseException {
       
        String institution;
        String terminationReason;
        String rank;
        String JobType;
        String startDate;
        String copletionDate;
        String salary;
        String relationType="Unknow";
        String expYear;
        
        try {

            if (ckbExperienceGovernmental.isSelected()) {
                experiencePrivateOrGovernmental = "Gvt";
            } else if (ckbExperiencePrivate.isSelected()) {
                experiencePrivateOrGovernmental = "Pvt";
            } else {
                experiencePrivateOrGovernmental = "";
            }

            if (ckbExperiencePermanent.isSelected()) {
                experienceContractOrPrtmanent = "Perm";
            } else if (ckbExperienceContract.isSelected()) {
                experienceContractOrPrtmanent = "Cont";
            } else {
                experienceContractOrPrtmanent = "";
            }

            salary = txtExperanceSalary.getValue().toString().trim();
           // relationType = rdRelation.getValue().toString().trim();
            if (experiencePrivateOrGovernmental.equals("") ||
                    experienceContractOrPrtmanent.equals("") ||
                    txtDisplayedExpStartDate.getValue() == null || txtDisplayedExpStartDate.getValue().toString().equals("") ||
                    txtDisplayedExpEndDate.getValue() == null || txtDisplayedExpEndDate.getValue().toString().equals("")) {

            } else {
                startDate = txtDisplayedExpStartDate.getValue().toString();
                copletionDate = txtDisplayedExpEndDate.getValue().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-DD");
                  Date stDate = null;
                  Date enDate=null;
                  stDate = dateFormat.parse(startDate);
                  enDate = dateFormat.parse(copletionDate);
                  String totlaExpirance=GregorianCalendarManipulation.calculateYearAndMonthAndDateDifference(startDate,copletionDate);
              
              expTotal=(GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceReturnTypeArrayList(startDate,copletionDate));
             String Dates=(expTotal[0]);
             String  months=(expTotal[1]);
             String  years=(expTotal[2]);
//  
                institution = txtExperianceInstitution.getValue().toString();
                rank = txtExRank.getValue().toString().trim();
                JobType = txtJobType.getValue().toString().trim();
                startDate = txtDisplayedExpStartDate.getValue().toString();
                copletionDate = txtDisplayedExpEndDate.getValue().toString();
                terminationReason = txtTerminationReason.getValue().toString();
               // candidateId = ApplicationBean1.getSelectedEmployeeId();
                 candidateId = out_txt_candidate_ID.getValue().toString();
//              String starDD= txtDisplayedExpStartDate.getValue().toString();
          
            

                CandidateExperienceManager addExperiance = new CandidateExperienceManager(
                        candidateId, salary, institution, rank, JobType,
                        startDate, copletionDate, terminationReason,
                        experiencePrivateOrGovernmental, experienceContractOrPrtmanent,
                        experianceId, job_Discripton, equvalentJobCode, relationType,years,months,Dates);
 
                if (buttonIdentifier == 1 || buttonIdentifier == 2)
                {
                  

                     counter++;
                     candidateExpiranceList.add(0, new CandidateExperienceManager(candidateId, salary, institution, rank, JobType,
                        startDate, copletionDate, terminationReason,
                        experiencePrivateOrGovernmental, experienceContractOrPrtmanent,
                        experianceId, job_Discripton, equvalentJobCode, relationType,years,months,Dates));
                     
                    this.listOfExperience.add(addExperiance);
                    btnEXSave.setDisabled(false);
                    this.btnEXEdit.setDisabled(false);
                    this.btnEXDelete.setDisabled(false);

                } else if (buttonIdentifier == 3) {
                   
                    this.listOfExperience.add(this.selectedExperience, addExperiance);
                    this.listOfExpUpdate.add(addExperiance);
                    this.btnEXEdit.setDisabled(false);
                    this.btnEXUpdate.setDisabled(false);
                    this.disableExperianceComponents();
                }
                dataIsOnEditExperience = "NO";
                this.clearExperianceComponents();
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public void rowSelectorCandidateExperance_processMyEvent(RowSelectorEvent rse) {
        selectedExperience = rse.getRow();
    }

    void disableExperianceComponents() {
//        txtExperianceInstitution.setDisabled(true);
//        txtJobType.setDisabled(true);
//        calExpStartDate.setDisabled(true);
//        txtTermination.setDisabled(true);
//        txtExperanceSalary.setDisabled(true);
//        txtExRank.setDisabled(true);
//        calExpEndDate.setDisabled(true);
    }

    void enableExperianceComponents() {
        txtExperianceInstitution.setDisabled(false);
        txtJobType.setDisabled(false);
        calExpStartDate.setDisabled(false);
        txtTerminationReason.setDisabled(false);
        txtExperanceSalary.setDisabled(false);
        txtExRank.setDisabled(false);
        calExpEndDate.setDisabled(false);
        ckbExperienceContract.setDisabled(false);
        ckbExperienceGovernmental.setDisabled(false);
        ckbExperiencePermanent.setDisabled(false);
        ckbExperiencePrivate.setDisabled(false);
        ckbProfassion.setDisabled(false);
        txtSearchCandidate.setDisabled(false);

    }

    void clearExperianceComponents() {
        dataIsOnEditExperience = "NO";
        txtExperianceInstitution.setValue("");
        txtJobType.setValue("");
        calExpStartDate.resetValue();
        txtTerminationReason.setValue("");
        txtExperanceSalary.setValue("");
        txtExRank.setValue("");
        calExpEndDate.resetValue();
        txtDisplayedExpStartDate.setValue("");
        txtDisplayedExpEndDate.setValue("");
        ckbExperienceContract.setSelected(false);
        ckbExperiencePermanent.setSelected(false);
        ckbExperienceGovernmental.setSelected(false);
        ckbExperiencePrivate.setSelected(false);
        ckbProfassion.setSelected(false);
    }
    public boolean DataValidation(){
        try{
    String startDate=txtDisplayedExpStartDate.getValue().toString();
    String endDate=txtDisplayedExpEndDate.getValue().toString();
    String currentDate=dateFormat.format(new Date());

    //String sysdate
           SimpleDateFormat datediff = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = datediff.parse(startDate);
            Date date2 = datediff.parse(endDate);
            Date date3=datediff.parse(currentDate);

            if(date2.before(date1))
            {
            out_date_message.setValue("End Date Can not be Lesss Than Start Date");
            return false;

            }
            else if(date1.after(date3))
            {
            out_date_message.setValue("Start Date Can not be Grater  Than Current Date");
            return false;
            }
            else if(date2.after(date3))
            {
                 out_date_message.setValue("End Date Can not be Grater Than Current Date");
            return false;
            }

        }catch(ParseException ex){

            return false;
        }
        out_date_message.setValue("");
         return true;
    }

    public String btnAddExperience_action()
    {
        try {
            if(DataValidation())
            {
          
            this.addCandidateExperiance();
            }
            else{

             showSuccessOrFailureMessage(false, "Pls Check Correctness of Start and End Date values  ");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//      void loadCandidateExperiance()
//    {
//        candidateExpiranceList.clear();
//        listOfExperience.clear();
//        HashMap[] list = candidateExperienceManager.readEmployeeExperiance(candidateId);
//        CandidateExperienceManager addTotabele = null;
//        try {
//            tableSize = candidateExperienceManager.countExperiance(candidateId);
//            if (list.length > 0) {
//                btnEXDelete.setDisabled(false);
//                btnEXEdit.setDisabled(false);
//                enableExperianceComponents();
//                for (int i = 0; i < list.length; i++)
//                {
//                    addTotabele = new CandidateExperienceManager(
//                            list[i].get("CANDIDATE_ID").toString(),
//                            list[i].get("SALARY").toString(),
//                            list[i].get("INSTITUION").toString(),
//                            list[i].get("RANK").toString(),
//                            list[i].get("JOB_TITLE").toString(),
//                            list[i].get("START_DATE").toString(),
//                            list[i].get("END_DATE").toString(),
//                            list[i].get("REASON_FOR_TERMINATION").toString(),
//                            list[i].get("PRIVATE_OR_GVTAL").toString(),
//                            list[i].get("PERMANENT_OR_CONTRACT").toString(),
//                            list[i].get("EQUVALENTJOBCODE").toString(),
//                            Integer.parseInt(list[i].get("EQUVALENTJOBCODE").toString()),
//                            list[i].get("EXPERIENCE_ID").toString(),
//                            list[i].get("EXP_RELATION_TYPE").toString(),
//                            list[i].get("EXPDETAIL").toString(),
//                            list[i].get("EXP_MONTH").toString(),
//                            list[i].get("EXP_DAY").toString());
//                            this.candidateExpiranceList.add(addTotabele);
//                   // this.listOfExperience.add(addTotabele);
//                }
//
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }









    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    void loadCandidateExperianceBirukNew()
    {
        candidateExpiranceList.clear();
        listOfExperience.clear();
      //  HashMap[] list = candidateExperienceManager.readEmployeeExperiance(candidateId);
        ArrayList<CandidateExperienceManager> listone =candidateExperienceManager.readEmployeeExperianceNew(candidateId);
        CandidateExperienceManager addTotabele = null;
        try {
            tableSize = candidateExperienceManager.countExperiance(candidateId);
            if (tableSize> 0) {
                btnEXDelete.setDisabled(false);
                btnEXEdit.setDisabled(false);
                enableExperianceComponents();
                for (int i = 0; i < tableSize; i++)
                {
                    
                    addTotabele = new CandidateExperienceManager(
                            listone.get(i).getCandidateId().toString(),
                             listone.get(i).getSalary().toString(),
                             listone.get(i).getInstitution(),
                            listone.get(i).getRank(),
                            listone.get(i).getJob_Code(),
                            listone.get(i).getStartDate(),
                            listone.get(i).getCopletionDate(),
                            listone.get(i).getTerminationReason(),
                            listone.get(i).getExperiencePrivateOrGovernmental(),
                            listone.get(i).getExperienceContractOrPrtmanent(),
                            listone.get(i).getJob_Code(),
                            listone.get(i).getEquvalentJobCode(),
                            listone.get(i).getExpRelationType(),
                            listone.get(i).getId(),
                            listone.get(i).getYears(),
                            listone.get(i).getMonths(),
                            listone.get(i).getDates());
                            this.candidateExpiranceList.add(addTotabele);
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

            candidateId = getApplicationBean1().getSelectedEmployeeId();

           
          //  loadCandidateExperiance();
            loadCandidateExperianceBirukNew();
            btnEXNew.setDisabled(false);
            if (candidateId != null) 
            {
                out_txt_candidate_ID.setValue(candidateId);
                HashMap candidateList = candidateManager.selectCandidate(candidateId);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public String btnCalExpStartDate_action() {

        calExpStartDate.setRendered(true);
        return null;
    }

    public String btnCalExpEndDate_action() {
        calExpEndDate.setRendered(true);

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

    public String btnEXNew_action()
    {
        candidateId=null;
        buttonIdentifier = 1;
        this.clearExperianceComponents();
        this.enableExperianceComponents();
        if (tableExperiance.getRowCount() > 0) {
            listOfExperience.clear();
            btnEXNew.setDisabled(false);
            btnEXSave.setDisabled(false);
            btnEXEdit.setDisabled(false);
            btnEXUpdate.setDisabled(true);
            btnEXReset.setDisabled(false);
            btnEXDelete.setDisabled(false);
            btnAddExperience.setDisabled(false);

        } else {
            btnEXNew.setDisabled(false);
            btnEXSave.setDisabled(false);
            btnEXEdit.setDisabled(true);
            btnEXUpdate.setDisabled(true);
            btnEXReset.setDisabled(false);
            btnEXDelete.setDisabled(true);
            btnAddExperience.setDisabled(false);
        }



        return null;
    }




    public void saveCandidateExperiance(int perform)
    {
         int chkSave = 0;
         String candidaeID=null;
         String birukTotal=null;
         int chk=0;
    
        try {
            if (perform == 1) {//save
                List candidateEcperiance = this.getListOfExperience();
                Iterator<CandidateExperienceManager> iter = candidateEcperiance.iterator();

                while (iter.hasNext())
                {
                    CandidateExperienceManager saveExperiance = iter.next();
                    chkSave = candidateExperienceManager.saveCandidatExperiance(saveExperiance, perform);
                    candidaeID=saveExperiance.getCandidateId().toString();
                }

                if (chkSave == 1)
                {
                    int dataTableSize=candidateExpiranceList.size();
                    int chkSelec=candidateExperienceManager.selectServYeartotale(candidaeID);
                    if(dataTableSize==1)
                    {
                    birukTotal=GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceRecuritmentForOneExpirance(chkSelec);
                    
                    }
                    else if(dataTableSize>=2)
                    {
       
                    birukTotal=GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceRecuritment(chkSelec);
                    
                    }
                    int chkExist=candidateExperienceManager.CheckExistanceOfCandidate(candidateId);
                    if(chkExist==1)
                    {
                    chk= candidateExperienceManager.SaveTotalExpiranceUpdate(birukTotal,candidateId,"SAVED");
                    }

                    else{
                    chk= candidateExperienceManager.SaveTotalExpirance(birukTotal,candidateId,"SAVED");

                    }
                   
                    if(chk==1)
                    {
                    showSuccessOrFailureMessage(true, "The Candidate Experience  Saved Successfully. ");
                    this.clearExperianceComponents();
                    counter = 0;
                    loadCandidateExperianceBirukNew();
                    disableExperianceComponents();
                    this.btnEXSave.setDisabled(true);
                    this.btnEXNew.setDisabled(false);
                    this.btnEXReset.setDisabled(true);
                    btnAddExperience.setDisabled(true);
                    pnlPopupSuccessOrFailure.setRendered(false);
                 } 
                }else {
                    showSuccessOrFailureMessage(false, "Member Experiance not Saved Try again.. ");
                    counter = 0;
                    disableExperianceComponents();

                    this.btnEXSave.setDisabled(false);
                    this.btnEXNew.setDisabled(false);
                    this.btnEXReset.setDisabled(false);
                }


            } else {
                //update
         
                 List candidateExperiance = this.getCandidateExpiranceList();
               // List candidateExperiance = this.getListOfExpUpdate();
                Iterator<CandidateExperienceManager> iter = candidateExperiance.iterator();
                while (iter.hasNext())
                {
                    CandidateExperienceManager saveExperiance = iter.next();
                     chkSave = candidateExperienceManager.saveCandidatExperiance(saveExperiance, perform);
             
                }

                if (chkSave == 1) {
                    int chkExist=candidateExperienceManager.CheckExistanceOfCandidate(candidateId);
                    
                    if(chkExist==1)
                    {
                         int chkSelec=candidateExperienceManager.selectServYeartotale(candidateId);
                         
                         birukTotal=GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceRecuritment(chkSelec);
                         
                    chk= candidateExperienceManager.SaveTotalExpiranceUpdate(birukTotal,candidateId,"SAVED");
                    }

                    else{
                     int chkSelec=candidateExperienceManager.selectServYeartotale(candidateId);
                    birukTotal=GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceRecuritment(chkSelec);
                    chk= candidateExperienceManager.SaveTotalExpirance(birukTotal,candidateId,"SAVED");

                    }

                    showSuccessOrFailureMessage(true, "Member Experiance  Updated Successfuly.");
                    this.listOfExpUpdate.clear();
                    this.btnEXNew.setDisabled(false);
                    this.btnEXUpdate.setDisabled(true);
                    this.btnEXDelete.setDisabled(false);
                    loadCandidateExperianceBirukNew();

                } else {
                    showSuccessOrFailureMessage(false, "Member Experiance not Updated Try again.");
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String btnEXSave_action() {
        
        this.saveCandidateExperiance(1);

        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String modalPnlCloseMesssageExam_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    
    //////////////////////////////////////////////////////////////////////////////////////////

    public String btnEXDelete_action() {
          int chkSave = 0;
          String candidaeID=null;
         String birukTotal=null;
         int chk=0;
        int chekDelete = 0;
        int rowNumber = this.selectedExperience;
        CandidateExperienceManager experienceO = (CandidateExperienceManager) candidateExpiranceList.get(rowNumber);
        chekDelete = experienceO.deleteCandidateExperiance(experienceO.getId());
        if (chekDelete == 1) 
        {
                  // int dataTableSize=candidateExpiranceList.size();
                    int chkSelec=candidateExperienceManager.selectServYeartotale(candidateId);
                    int chkExist=candidateExperienceManager.CheckExistanceOfCandidate(candidateId);
                    if(chkExist==1)
                    {
                    birukTotal=GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceRecuritment(chkSelec);
                    chk= candidateExperienceManager.SaveTotalExpiranceUpdate(birukTotal,candidateId,"SAVED");
                    }

                    else{
                    birukTotal=GregorianCalendarManipulation.calculateYearAndMonthAndDateDifferenceRecuritment(chkSelec);
                    chk= candidateExperienceManager.SaveTotalExpirance(birukTotal,candidateId,"SAVED");

                    }
                      


            candidateExpiranceList.remove(rowNumber);
            showSuccessOrFailureMessage(true, "Record deleted successfully");
            tableSize--;
            this.selectedExperience = -1;

        }
        else {
            showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
        }

        return null;
    }

    public String btnEXEdit_action() 
    {
        
        buttonIdentifier = 3;
        if (this.selectedExperience == -1)
        {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (this.selectedExperience != -1 && this.candidateExpiranceList.isEmpty() == true)
        {
            
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {
            if (dataIsOnEditExperience.equals("YES"))
            {
                showSuccessOrFailureMessage(false, "First finish the data you are editing");
            } else {
                dataIsOnEditExperience = "YES";
                CandidateExperienceManager candidateExperiance = (CandidateExperienceManager) this.candidateExpiranceList.get(this.selectedExperience);
                this.candidateExpiranceList.remove(this.selectedExperience);
                txtExperianceInstitution.setValue(candidateExperiance.getInstitution());
                txtJobType.setValue(candidateExperiance.getJob_Code());
                try {
                    txtDisplayedExpStartDate.setValue(candidateExperiance.getStartDate());
                    txtDisplayedExpEndDate.setValue(candidateExperiance.getCopletionDate());
                } catch (Exception ex) {
                    Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (candidateExperiance.getExperienceContractOrPrtmanent().equals("Cont")) {
                    experienceContractOrPrtmanent = "Cont";
                    ckbExperienceContract.setSelected(true);
                    ckbExperiencePermanent.setSelected(false);
                } else if (candidateExperiance.getExperienceContractOrPrtmanent().equals("Perm")) {
                    experienceContractOrPrtmanent = "Perm";
                    ckbExperienceContract.setSelected(false);
                    ckbExperiencePermanent.setSelected(true);
                }
//prv
                if (candidateExperiance.getExperiencePrivateOrGovernmental().equals("Pvt")) {
                    experiencePrivateOrGovernmental = "Pvt";
                    ckbExperienceGovernmental.setSelected(false);
                    ckbExperiencePrivate.setSelected(true);
                } else if (candidateExperiance.getExperiencePrivateOrGovernmental().equals("Gvt")) {
                    experiencePrivateOrGovernmental = "Gvt";
                    ckbExperienceGovernmental.setSelected(true);
                    ckbExperiencePrivate.setSelected(false);
                }
                rdRelation.setValue(candidateExperiance.getExpRelationType());
                txtTerminationReason.setValue(candidateExperiance.getTerminationReason());
                txtExRank.setValue(candidateExperiance.getRank());
                txtExperanceSalary.setValue(candidateExperiance.getSalary());
                experianceId = candidateExperiance.getId();
                btnEXNew.setDisabled(false);
                btnEXSave.setDisabled(true);
                btnEXUpdate.setDisabled(false);
                btnEXReset.setDisabled(false);
                btnEXDelete.setDisabled(true);
                btnAddExperience.setDisabled(false);
                this.enableExperianceComponents();
                buttonIdentifier = 2;
                if (this.selectedExperience >= tableSize) {
                    buttonIdentifier = 2;
                    this.counter--;
                }

            }
        }
        return null;
    }

    public String btnEXUpdate_action() {

        buttonIdentifier = 4;
        this.saveCandidateExperiance(2);
        return null;
    }

    public void ckbProfassion_processValueChange(ValueChangeEvent vce) {
        if (ckbProfassion.isSelected()) {
            drlJobCode.setDisabled(false);
        } else {
            drlJobCode.setDisabled(true);
        }
    }


    public ArrayList<SelectItem> getListOfJobType() {
        ArrayList<SelectItem> forThisPage = departmentManage.readAllJob();
        if (forThisPage.size() > 0) {
            forThisPage.remove(0);
        }
        return forThisPage;
    }

    public String btnEXReset_action() {
        clearExperianceComponents();
        disableExperianceComponents();
        btnEXNew.setDisabled(false);
        btnEXSave.setDisabled(true);
        btnEXEdit.setDisabled(false);
        btnEXUpdate.setDisabled(true);
        btnEXReset.setDisabled(false);
        btnEXDelete.setDisabled(false);
        btnAddExperience.setDisabled(true);
        txtSearchCandidate.setValue("");
        listOfExperience.clear();
        return null;
    }

    public void drlJobCode_processValueChange(ValueChangeEvent vce) {
        equvalentJobCode = Integer.parseInt(drlJobCode.getValue().toString());
        job_Discripton = drlJobCode.getValue().toString();
    }
    private ArrayList<Option> relationTypeList = defineRelationTypeList();

    private ArrayList<Option> defineRelationTypeList() {
        ArrayList<Option> relTypeList = new ArrayList<Option>();
        relTypeList.add(new Option("Direct", "Direct"));
        relTypeList.add(new Option("Indirect", "Indirect"));
        return relTypeList;
    }

    /**
     * @return the relationTypeList
     */
    public ArrayList<Option> getRelationTypeList() {
        return relationTypeList;
    }

    /**
     * @param relationTypeList the relationTypeList to set
     */
    public void setRelationTypeList(ArrayList<Option> relationTypeList) {
        this.relationTypeList = relationTypeList;
    }

    public String commandLink1_action()
    {
        reportManger.bulidReportParameterListForCandidateReport(batchCode, candidateID);
        loadCandidateInformationForReport();
        //loadCandidateExoiranceInformtionForReport();
        //loadCandidateEducationInformationForReport();
        
        return null;

    }
     public void LoadLOGO() {
        List data = null;
        EmployeeProfileReportManager manager1 = new EmployeeProfileReportManager();
        data = manager1.loadCompanyLogo();
        ListIterator<EmployeeProfileReportManager> lstmb = data.listIterator();
        try {
            while (lstmb.hasNext()) {
                EmployeeProfileReportManager mag = lstmb.next();
                if (mag.getFPLOGO() != null) {
                    LOGO = new ImageIcon((byte[]) mag.getFPLOGO());
                } else {
                    LOGO = new ImageIcon();
                }
            }
        } catch (Exception ex) {
        }

    }

    private void loadCandidateInformationForReport()
    {
        {
            FacesContext context = FacesContext.getCurrentInstance();
             ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            String reportPath = servletContext.getRealPath("//JasperReports/CandidateJasper");
            String jasperLocation = reportPath + "\\CandidateList.jasper";
           // String jasperLocation="F:\\ProjectBackUP\\BunnaAfterPresentationBackUp\\FINALBUNNA\\BIBHRMS\\web\\JasperReports\\CandidateJasper\\CandidateList.jasper";
             String reportName = "CandidateInformation";
             HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
           
           Collection data = jasperReport.loadCandidateInformationForReport();
                  
           if((data != null))
           {
            HashMap param = new HashMap();
            param.put("LOGO", LOGO.getImage());

             reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
           
            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();

            }



            else{
           showSuccessOrFailureMessage(false, "There is no Report");
            }
           //  loadCandidateEducationInformationForReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        //  ErrorLogWriter.writeError(ex);
        }

    }
}

    public void drl_BatchCode_processValueChange(ValueChangeEvent vce)
    {
         if (!vce.getNewValue().equals("-1") && vce.getNewValue() != null) {
            batchCode = vce.getNewValue().toString();
            CandidateNameList = candidateExperienceManager.getAllCanidateNameList(batchCode);

         // report.MonthlyReport();
        }

    }

    public void drl_CandidatName_processValueChange(ValueChangeEvent vce) {
        candidateID= Integer.parseInt(vce.getNewValue().toString().split("-")[1]);
              
    }

}

