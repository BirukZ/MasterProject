/*
 * RequestForPromotion.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
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
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.event.ValueChangeEvent;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import com.sun.webui.jsf.model.Option;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.recruitmentManager.AdvertisementManager;
import manager.departmentManage.DepartmentManage;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeHistoryManager.PromotionManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.LookUpManager;
import manager.globalUseManager.StringDateManipulation;
import manager.recruitmentManager.RecruitmentManager;
import manager.recruitmentManager.VacancyNoticeListManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PromoteEmployee extends AbstractPageBean {

    VacancyNoticeListManager vacancyNoticeListManager = new VacancyNoticeListManager();
    DepartmentManage departmentManage = new DepartmentManage();
    AdvertisementManager advertisementManager = new AdvertisementManager();
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    PromotionManager promotionManager = new PromotionManager();
    public ArrayList<SelectItem> listOfJobType = new ArrayList<SelectItem>();
    public List vacancyList = new ArrayList<AdvertisementManager>();
    private List requestersForPromotion = new ArrayList<AdvertisementManager>();
    public List vacancyListRequestPromo = new ArrayList<VacancyNoticeListManager>();
    private PanelPopup pnMessage = new PanelPopup();
    private Option[] newPromotionRequests = recruitmentManager.newPromotionRequests();
    private Option[] newPromotionRequestsDates = recruitmentManager.newPromotionRequestsDates();
    private Option[] newPromotionResponsedApprove;
    private Option[] promotedIndividuals;
    EvaluationResultManager evaResultManObject = new EvaluationResultManager();
    private Option[] toFilterResultUsingSession;
    ArrayList<SelectItem> _jobRank = new ArrayList<SelectItem>();
    String SessionID = "";
    LookUpManager lookUpManager = new LookUpManager();
    ArrayList<SelectItem> payGradeOpt = new ArrayList<SelectItem>();
    String currDate = StringDateManipulation.toDayInEc();
    String empINFO = null;
    int advertID = -1;
    int numberOfEmployeesPromoted = -1;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currenTDateToSet = "fromDate";
    private String jobCode = null;
    private EmployeeManage employeeManage = new EmployeeManage();
    private String jobCodeIDFrom = null;
    private String departmentFrom;
    private String departmentTo;
    private String bach_Code = null;
    String rank_id;
    boolean checkFromSelect = false;
    boolean checkPercentage = false;
    private ArrayList<AdvertisementManager> resultListData = new ArrayList<AdvertisementManager>();

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String SessionID) {
        this.SessionID = SessionID;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public int getAdvertID() {
        return advertID;
    }

    public void setAdvertID(int advertID) {
        this.advertID = advertID;
    }

    public AdvertisementManager getAdvertisementManager() {
        return advertisementManager;
    }

    public void setAdvertisementManager(AdvertisementManager advertisementManager) {
        this.advertisementManager = advertisementManager;
    }

    public String getBach_Code() {
        return bach_Code;
    }

    public void setBach_Code(String bach_Code) {
        this.bach_Code = bach_Code;
    }

    public boolean isCheckFromSelect() {
        return checkFromSelect;
    }

    public void setCheckFromSelect(boolean checkFromSelect) {
        this.checkFromSelect = checkFromSelect;
    }

    public boolean isCheckPercentage() {
        return checkPercentage;
    }

    public void setCheckPercentage(boolean checkPercentage) {
        this.checkPercentage = checkPercentage;
    }

    public String getCurrDate() {
        return currDate;
    }

    public void setCurrDate(String currDate) {
        this.currDate = currDate;
    }

    public String getCurrenTDateToSet() {
        return currenTDateToSet;
    }

    public void setCurrenTDateToSet(String currenTDateToSet) {
        this.currenTDateToSet = currenTDateToSet;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDepartmentFrom() {
        return departmentFrom;
    }

    public void setDepartmentFrom(String departmentFrom) {
        this.departmentFrom = departmentFrom;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public String getDepartmentTo() {
        return departmentTo;
    }

    public void setDepartmentTo(String departmentTo) {
        this.departmentTo = departmentTo;
    }

    public String getEmpINFO() {
        return empINFO;
    }

    public void setEmpINFO(String empINFO) {
        this.empINFO = empINFO;
    }

    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }

    public void setEmployeeManage(EmployeeManage employeeManage) {
        this.employeeManage = employeeManage;
    }

    public EvaluationResultManager getEvaResultManObject() {
        return evaResultManObject;
    }

    public void setEvaResultManObject(EvaluationResultManager evaResultManObject) {
        this.evaResultManObject = evaResultManObject;
    }

    public String getJobCodeIDFrom() {
        return jobCodeIDFrom;
    }

    public void setJobCodeIDFrom(String jobCodeIDFrom) {
        this.jobCodeIDFrom = jobCodeIDFrom;
    }

    public LookUpManager getLookUpManager() {
        return lookUpManager;
    }

    public void setLookUpManager(LookUpManager lookUpManager) {
        this.lookUpManager = lookUpManager;
    }

    public int getNumberOfEmployeesPromoted() {
        return numberOfEmployeesPromoted;
    }

    public void setNumberOfEmployeesPromoted(int numberOfEmployeesPromoted) {
        this.numberOfEmployeesPromoted = numberOfEmployeesPromoted;
    }

    public PromotionManager getPromotionManager() {
        return promotionManager;
    }

    public void setPromotionManager(PromotionManager promotionManager) {
        this.promotionManager = promotionManager;
    }

    public String getRank_id() {
        return rank_id;
    }

    public void setRank_id(String rank_id) {
        this.rank_id = rank_id;
    }

    public RecruitmentManager getRecruitmentManager() {
        return recruitmentManager;
    }

    public void setRecruitmentManager(RecruitmentManager recruitmentManager) {
        this.recruitmentManager = recruitmentManager;
    }

    public ArrayList<AdvertisementManager> getResultListData() {
        return resultListData;
    }

    public void setResultListData(ArrayList<AdvertisementManager> resultListData) {
        this.resultListData = resultListData;
    }

    public List getVacancyListRequestPromo() {
        return vacancyListRequestPromo;
    }

    public void setVacancyListRequestPromo(List vacancyListRequestPromo) {
        this.vacancyListRequestPromo = vacancyListRequestPromo;
    }

    public VacancyNoticeListManager getVacancyNoticeListManager() {
        return vacancyNoticeListManager;
    }

    public void setVacancyNoticeListManager(VacancyNoticeListManager vacancyNoticeListManager) {
        this.vacancyNoticeListManager = vacancyNoticeListManager;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Option[] getPromotedIndividuals() {
        return promotedIndividuals;
    }

    public void setPromotedIndividuals(Option[] promotedIndividuals) {
        this.promotedIndividuals = promotedIndividuals;
    }

    public Option[] getNewPromotionResponsedApprove() {
        return newPromotionResponsedApprove;
    }

    public void setNewPromotionResponsedApprove(Option[] newPromotionResponsedApprove) {
        this.newPromotionResponsedApprove = newPromotionResponsedApprove;
    }

    public Option[] getNewPromotionRequestsDates() {
        return newPromotionRequestsDates;
    }

    public void setNewPromotionRequestsDates(Option[] newPromotionRequestsDates) {
        this.newPromotionRequestsDates = newPromotionRequestsDates;
    }

    public ArrayList<SelectItem> getListOfJobType() {
        return departmentManage.readAllJob();
    }

    public void setListOfJobType(ArrayList<SelectItem> listOfJobType) {
        this.listOfJobType = listOfJobType;
    }

    public ArrayList<SelectItem> getPayGradeOpt() {
        return payGradeOpt;
    }

    public void setPayGradeOpt(ArrayList<SelectItem> payGradeOpt) {
        this.payGradeOpt = payGradeOpt;
    }

    public ArrayList<SelectItem> get_jobRank() {
        return _jobRank;
    }

    public void set_jobRank(ArrayList<SelectItem> _jobRank) {
        this._jobRank = _jobRank;
    }

    public Option[] getToFilterResultUsingSession() {
        return toFilterResultUsingSession;
    }

    public void setToFilterResultUsingSession(Option[] toFilterResultUsingSession) {
        this.toFilterResultUsingSession = toFilterResultUsingSession;
    }

    public List getRequestersForPromotion() {
        return requestersForPromotion;
    }

    public void setRequestersForPromotion(List requestersForPromotion) {
        this.requestersForPromotion = requestersForPromotion;
    }

    public Option[] getNewPromotionRequests() {
        return newPromotionRequests;
    }

    public void setNewPromotionRequests(Option[] newPromotionRequests) {
        this.newPromotionRequests = newPromotionRequests;
    }

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

    public List getVacancyList() {
        return vacancyList;
    }

    public void setVacancyList(List vacancyList) {
        this.vacancyList = vacancyList;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }


   

    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlCommandButton button1 = new HtmlCommandButton();

    public HtmlCommandButton getButton1() {
        return button1;
    }

    public void setButton1(HtmlCommandButton hcb) {
        this.button1 = hcb;
    }
    private RowSelector rowSelectorVacancyNoticeList = new RowSelector();

    public RowSelector getRowSelectorVacancyNoticeList() {
        return rowSelectorVacancyNoticeList;
    }

    public void setRowSelectorVacancyNoticeList(RowSelector rs) {
        this.rowSelectorVacancyNoticeList = rs;
    }
    private HtmlInputText txtRequester = new HtmlInputText();

    public HtmlInputText getTxtRequester() {
        return txtRequester;
    }

    public void setTxtRequester(HtmlInputText hit) {
        this.txtRequester = hit;
    }
    private HtmlSelectBooleanCheckbox checkbox1RequestPromotion = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckbox1RequestPromotion() {
        return checkbox1RequestPromotion;
    }

    public void setCheckbox1RequestPromotion(HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1RequestPromotion = hsbc;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlSelectOneListbox selectOneListboxPromotionRequestes = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListboxPromotionRequestes() {
        return selectOneListboxPromotionRequestes;
    }

    public void setSelectOneListboxPromotionRequestes(HtmlSelectOneListbox hsol) {
        this.selectOneListboxPromotionRequestes = hsol;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
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
    private HtmlInputText inputTextAdvertID = new HtmlInputText();

    public HtmlInputText getInputTextAdvertID() {
        return inputTextAdvertID;
    }

    public void setInputTextAdvertID(HtmlInputText hit) {
        this.inputTextAdvertID = hit;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox1TotalService = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox1TotalService() {
        return selectBooleanCheckbox1TotalService;
    }

    public void setSelectBooleanCheckbox1TotalService(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox1TotalService = hsbc;
    }
    private PanelLayout PanelLayOutInsidVacancyListRequester = new PanelLayout();

    public PanelLayout getPanelLayOutInsidVacancyListRequester() {
        return PanelLayOutInsidVacancyListRequester;
    }

    public void setPanelLayOutInsidVacancyListRequester(PanelLayout pl) {
        this.PanelLayOutInsidVacancyListRequester = pl;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox2Performance = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox2Performance() {
        return selectBooleanCheckbox2Performance;
    }

    public void setSelectBooleanCheckbox2Performance(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox2Performance = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox3EducationLevel = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox3EducationLevel() {
        return selectBooleanCheckbox3EducationLevel;
    }

    public void setSelectBooleanCheckbox3EducationLevel(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox3EducationLevel = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox4Training = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox4Training() {
        return selectBooleanCheckbox4Training;
    }

    public void setSelectBooleanCheckbox4Training(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox4Training = hsbc;
    }
    private HtmlDataTable dataTable1 = new HtmlDataTable();

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }
    private PanelPopup evaResultPopUpMsg = new PanelPopup();

    public PanelPopup getEvaResultPopUpMsg() {
        return evaResultPopUpMsg;
    }

    public void setEvaResultPopUpMsg(PanelPopup pp) {
        this.evaResultPopUpMsg = pp;
    }
    private HtmlCommandButton button2Cancel = new HtmlCommandButton();

    public HtmlCommandButton getButton2Cancel() {
        return button2Cancel;
    }

    public void setButton2Cancel(HtmlCommandButton hcb) {
        this.button2Cancel = hcb;
    }
    private HtmlOutputText outputText14evaResultNoteIssueVal = new HtmlOutputText();

    public HtmlOutputText getOutputText14evaResultNoteIssueVal() {
        return outputText14evaResultNoteIssueVal;
    }

    public void setOutputText14evaResultNoteIssueVal(HtmlOutputText hot) {
        this.outputText14evaResultNoteIssueVal = hot;
    }
    private HtmlSelectOneMenu selectOneMenu1evaResultPopUpMsg = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1evaResultPopUpMsg() {
        return selectOneMenu1evaResultPopUpMsg;
    }

    public void setSelectOneMenu1evaResultPopUpMsg(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1evaResultPopUpMsg = hsom;
    }
    private HtmlCommandButton button2Ok = new HtmlCommandButton();

    public HtmlCommandButton getButton2Ok() {
        return button2Ok;
    }

    public void setButton2Ok(HtmlCommandButton hcb) {
        this.button2Ok = hcb;
    }
    private RowSelector rowSelectorPromoteEmployee = new RowSelector();

    public RowSelector getRowSelectorPromoteEmployee() {
        return rowSelectorPromoteEmployee;
    }

    public void setRowSelectorPromoteEmployee(RowSelector rs) {
        this.rowSelectorPromoteEmployee = rs;
    }
    private HtmlOutputText outputTextEmpInfo = new HtmlOutputText();

    public HtmlOutputText getOutputTextEmpInfo() {
        return outputTextEmpInfo;
    }

    public void setOutputTextEmpInfo(HtmlOutputText hot) {
        this.outputTextEmpInfo = hot;
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
    private HtmlInputText inputTextJobCode = new HtmlInputText();

    public HtmlInputText getInputTextJobCode() {
        return inputTextJobCode;
    }

    public void setInputTextJobCode(HtmlInputText hit) {
        this.inputTextJobCode = hit;
    }
    private HtmlInputText inputTextRank = new HtmlInputText();

    public HtmlInputText getInputTextRank() {
        return inputTextRank;
    }

    public void setInputTextRank(HtmlInputText hit) {
        this.inputTextRank = hit;
    }
    private HtmlInputText inputTextPayGrade = new HtmlInputText();

    public HtmlInputText getInputTextPayGrade() {
        return inputTextPayGrade;
    }

    public void setInputTextPayGrade(HtmlInputText hit) {
        this.inputTextPayGrade = hit;
    }
    private HtmlInputText inputTextSalary = new HtmlInputText();

    public HtmlInputText getInputTextSalary() {
        return inputTextSalary;
    }

    public void setInputTextSalary(HtmlInputText hit) {
        this.inputTextSalary = hit;
    }
    private HtmlSelectOneMenu drlToPayGrade = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlToPayGrade() {
        return drlToPayGrade;
    }

    public void setDrlToPayGrade(HtmlSelectOneMenu hsom) {
        this.drlToPayGrade = hsom;
    }
    private HtmlSelectOneMenu drlToRank = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlToRank() {
        return drlToRank;
    }

    public void setDrlToRank(HtmlSelectOneMenu hsom) {
        this.drlToRank = hsom;
    }
    private HtmlInputText txtToSalary = new HtmlInputText();

    public HtmlInputText getTxtToSalary() {
        return txtToSalary;
    }

    public void setTxtToSalary(HtmlInputText hit) {
        this.txtToSalary = hit;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlInputText inputTextDateOfPromotion = new HtmlInputText();

    public HtmlInputText getInputTextDateOfPromotion() {
        return inputTextDateOfPromotion;
    }

    public void setInputTextDateOfPromotion(HtmlInputText hit) {
        this.inputTextDateOfPromotion = hit;
    }
    private HtmlInputText inputTextPromoter = new HtmlInputText();

    public HtmlInputText getInputTextPromoter() {
        return inputTextPromoter;
    }

    public void setInputTextPromoter(HtmlInputText hit) {
        this.inputTextPromoter = hit;
    }
    private HtmlInputText inputTextReferenceDate = new HtmlInputText();

    public HtmlInputText getInputTextReferenceDate() {
        return inputTextReferenceDate;
    }

    public void setInputTextReferenceDate(HtmlInputText hit) {
        this.inputTextReferenceDate = hit;
    }
    private HtmlInputText inputTextReferenceNo = new HtmlInputText();

    public HtmlInputText getInputTextReferenceNo() {
        return inputTextReferenceNo;
    }

    public void setInputTextReferenceNo(HtmlInputText hit) {
        this.inputTextReferenceNo = hit;
    }
    private HtmlSelectOneMenu drlJobCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJobCode() {
        return drlJobCode;
    }

    public void setDrlJobCode(HtmlSelectOneMenu hsom) {
        this.drlJobCode = hsom;
    }
    private HtmlInputText inputTextJobCodeID = new HtmlInputText();

    public HtmlInputText getInputTextJobCodeID() {
        return inputTextJobCodeID;
    }

    public void setInputTextJobCodeID(HtmlInputText hit) {
        this.inputTextJobCodeID = hit;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
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
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
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
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems4() {
        return selectOneListbox1DefaultItems4;
    }

    public void setSelectOneListbox1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1HistoryDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1HistoryDefaultItems() {
        return selectOneListbox1HistoryDefaultItems;
    }

    public void setSelectOneListbox1HistoryDefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1HistoryDefaultItems = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems5() {
        return selectOneListbox1DefaultItems5;
    }

    public void setSelectOneListbox1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems6() {
        return selectOneListbox1DefaultItems6;
    }

    public void setSelectOneListbox1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems6 = dsia;
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
    private HtmlSelectOneListbox selectOneListbox1 = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1() {
        return selectOneListbox1;
    }

    public void setSelectOneListbox1(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1 = hsol;
    }
    private HtmlSelectOneListbox selectOneListbox2RequestForPromo = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox2RequestForPromo() {
        return selectOneListbox2RequestForPromo;
    }

    public void setSelectOneListbox2RequestForPromo(HtmlSelectOneListbox hsol) {
        this.selectOneListbox2RequestForPromo = hsol;
    }
    private HtmlCommandButton buttonViewAll = new HtmlCommandButton();

    public HtmlCommandButton getButtonViewAll() {
        return buttonViewAll;
    }

    public void setButtonViewAll(HtmlCommandButton hcb) {
        this.buttonViewAll = hcb;
    }
    private HtmlSelectOneListbox selectOneListbox1IndividualHistory = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1IndividualHistory() {
        return selectOneListbox1IndividualHistory;
    }

    public void setSelectOneListbox1IndividualHistory(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1IndividualHistory = hsol;
    }
    private HtmlOutputText lblDepartmentTO = new HtmlOutputText();

    public HtmlOutputText getLblDepartmentTO() {
        return lblDepartmentTO;
    }

    public void setLblDepartmentTO(HtmlOutputText hot) {
        this.lblDepartmentTO = hot;
    }
    private HtmlOutputText lblFromDepartment = new HtmlOutputText();

    public HtmlOutputText getLblFromDepartment() {
        return lblFromDepartment;
    }

    public void setLblFromDepartment(HtmlOutputText hot) {
        this.lblFromDepartment = hot;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnPromote = new HtmlCommandButton();

    public HtmlCommandButton getBtnPromote() {
        return btnPromote;
    }

    public void setBtnPromote(HtmlCommandButton hcb) {
        this.btnPromote = hcb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calPromotionDate = new SelectInputDate();

    public SelectInputDate getCalPromotionDate() {
        return calPromotionDate;
    }

    public void setCalPromotionDate(SelectInputDate sid) {
        this.calPromotionDate = sid;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calReferenceDate = new SelectInputDate();

    public SelectInputDate getCalReferenceDate() {
        return calReferenceDate;
    }

    public void setCalReferenceDate(SelectInputDate sid) {
        this.calReferenceDate = sid;
    }
    private HtmlOutputText lblToJobDescription = new HtmlOutputText();

    public HtmlOutputText getLblToJobDescription() {
        return lblToJobDescription;
    }

    public void setLblToJobDescription(HtmlOutputText hot) {
        this.lblToJobDescription = hot;
    }
    private HtmlOutputText lblToRank = new HtmlOutputText();

    public HtmlOutputText getLblToRank() {
        return lblToRank;
    }

    public void setLblToRank(HtmlOutputText hot) {
        this.lblToRank = hot;
    }
    private HtmlOutputText lblPayGrade = new HtmlOutputText();

    public HtmlOutputText getLblPayGrade() {
        return lblPayGrade;
    }

    public void setLblPayGrade(HtmlOutputText hot) {
        this.lblPayGrade = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PromoteEmployee() {
    }

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
        disableEvaluationComponents();
        this.btnUpdate.setDisabled(true);
        this.btnPromote.setDisabled(true);
        this.toFilterResultUsingSession = evaResultManObject.readAllSessionsResultsGivenToPromotion();
        _jobRank = lookUpManager.assignJobRank("");
        inputTextPromoter.setValue(this.getSessionBean1().getEmployeeName() + "--" + this.getSessionBean1().getEmployeeId());
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

    public String cmdRecruitmentRequest_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdrecApproval_action() {
        //return null means stay on the same page
        return "ApprovedRecruitmentList";
    }

    public String cmdvacNotice_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdRegisterCandidate_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }

    public String cmdfilterCandidate_action() {
        //return null means stay on the same page
        return "FilterCandidates";
    }

    /**
     * selam new
     */
    public void enableEvaluationComponents() {
        selectBooleanCheckbox1TotalService.setDisabled(false);
        selectBooleanCheckbox2Performance.setDisabled(false);
        selectBooleanCheckbox3EducationLevel.setDisabled(false);
        selectBooleanCheckbox4Training.setDisabled(false);


    }

    public void disableEvaluationComponents() {
        selectBooleanCheckbox1TotalService.setDisabled(true);
        selectBooleanCheckbox2Performance.setDisabled(true);
        selectBooleanCheckbox3EducationLevel.setDisabled(true);
        selectBooleanCheckbox4Training.setDisabled(true);


    }

    public void clearPromotionComponents() {
        lblFromDepartment.setValue("");
        lblDepartmentTO.setValue("");
        inputTextJobCode.setValue("");
        drlJobCode.resetValue();
        drlJobCode.setValue("0");
        inputTextRank.setValue("");
        drlToRank.resetValue();
        drlToRank.setValue("0");
        inputTextPayGrade.setValue("");
        drlToPayGrade.resetValue();
        drlToPayGrade.setValue("0");
        inputTextSalary.setValue("");
        txtToSalary.setValue("");
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public String[] requestJobCodeChecker(String requesterID) {
        return advertisementManager.readRequesterJobCode(requesterID);
    }

    public void ResetComponents() {
        this.inputTextJobCode.resetValue();
        this.inputTextRank.resetValue();
        this.inputTextPayGrade.resetValue();
        this.inputTextSalary.resetValue();
        this.inputTextDateOfPromotion.resetValue();
        this.drlToPayGrade.resetValue();
        this.txtToSalary.resetValue();

    }

    public HashMap[] requestValidationChecker(String jobCode) {
        HashMap[] list = null;
        try {

            list = advertisementManager.readVacancyForValidation(jobCode);
            if (list.length > 0) {
                for (int i = 0; i < list.length; i++) {

                    list[i].get("JOB_DESCRIPTION").toString();
                    list[i].get("MIN_EXPERIENCE").toString();
                    list[i].get("QUALIFICATION").toString();
                    list[i].get("EDUCATION_LEVEL").toString();
                    list[i].get("JOB_CODE").toString();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;

    }

    public HashMap[] requesterEducHistory(String requesterID) {
        HashMap[] list = null;
        try {
            list = advertisementManager.readPersonEducHist(requesterID);
            if (list.length > 0) {
                for (int i = 0; i < list.length; i++) {

                    list[i].get("EDUC_LEVEL_CODE").toString();
                    list[i].get("EDUCATION_TYPE").toString();
                    list[i].get("STARTING_DATE").toString();
                    list[i].get("COMPLETION_DATE").toString();
                    list[i].get("HIRE_DATE").toString();

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void rowSelectorVacancyNoticeList_processMyEvent(RowSelectorEvent rse) {
    }

    public void selectOneListboxPromotionRequestes_processValueChange(ValueChangeEvent vce) {
        float interviewPercentage = 0.0f;
        float presentationPercentage = 0.0f;
        float writtenPercentage = 0.0f;
        float otherPercentage = 0.0f;
        float disciplineValue = 5.0f;
        float performanceValue = 0.0f;
        float disciplinePercentage = 0.0f;
        float performancePercentage = 0.0f;
        int educLevelId = 0;
        int educLevelresult = 0;
        if (vce.getNewValue() != null) 
        {
            advertID=Integer.parseInt(vce.getNewValue().toString());
            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
            try {
                this.vacancyList.clear();
                HashMap[] list = advertisementManager.readVacancyPromoRequest(vce.getNewValue().toString());
                rank_id = list[0].get("RANK_ID").toString();
                advertisementManager.setRank(Integer.parseInt(rank_id));
                if (list.length > 0) {
                    for (int i = 0; i < list.length; i++) {

                        AdvertisementManager addToTable = new AdvertisementManager(
                                list[i].get("advert_date_from").toString(),
                                list[i].get("advert_date_to").toString(),
                                list[i].get("recruit_batch_code").toString(),
                                list[i].get("JOB_DESCRIPTION").toString(),
                                list[i].get("RECRUIT_REQUEST_ID").toString(),
                                list[i].get("RECRUIT_REQUEST_TYPE").toString(),
                                list[i].get("NUM_OF_EMPS_APPROVED").toString(),
                                list[i].get("MIN_EXPERIENCE").toString(),
                                list[i].get("ADVERT_ID").toString(),
                                list[i].get("QUALIFICATION").toString(),
                                list[i].get("EDUCATION_LEVEL").toString(),
                                list[i].get("JOB_CODE").toString(), 0, 0, list[i].get("RANK_ID").toString());
                        this.vacancyList.add(addToTable);
                    }
                }
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequester(vce.getNewValue().toString());
                requestersForPromotion.clear();
                if (listRequester.length > 0) {
                    enableEvaluationComponents();

                    for (int i = 0; i < listRequester.length; i++) {
                        educLevelId = advertisementManager.readEducLevel(listRequester[i].get("EMP_ID").toString());
                        educLevelresult = advertisementManager.readEducLevelresult(educLevelId, rank_id);
                        if (promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString()) <= 5) {
                            disciplineValue -= (float) promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString());
                        } else {
                            disciplineValue -= 5;
                        }
                        performanceValue = promotionManager.employeePerformanceResult(listRequester[i].get("EMP_ID").toString());

                        AdvertisementManager addToTable = new AdvertisementManager(
                                educLevelresult,
                                listRequester[i].get("EMP_ID").toString(),
                                listRequester[i].get("EXPERIENCE").toString(),
                                listRequester[i].get("FULLNAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("JOB_DESCRIPTION").toString(),
                                listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("ADVERT_ID").toString(),
                                listRequester[i].get("DEPARTMENT_ID").toString(),
                                Float.parseFloat(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("PRESENTATION_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("OTHER_RESULT").toString()),
                                interviewPercentage,
                                writtenPercentage,
                                presentationPercentage,
                                otherPercentage,
                                listRequester[i].get("PROMOTION_REQUEST_ID").toString(),
                                disciplineValue,
                                performanceValue,
                                0,
                                disciplinePercentage,
                                performancePercentage,
                                true);
                        getRequestersForPromotion().add(addToTable);
                        disciplineValue = 5.0f;
                        performanceValue = 0.0f;
                    }

                    promotedIndividuals = promotionManager.readPromotedEmployees(vce.getNewValue().toString());
                    this.btnUpdate.setDisabled(true);
                    this.btnPromote.setDisabled(true);

                }
                checkFromSelect = false;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


    }

    /**
     * display employee on the below part to
     * @param rse
     */
    public void rowSelectorPromoteEmployee_processMyEvent(RowSelectorEvent rse) {
        try {
            if (rse.getRow() < numberOfEmployeesPromoted) {
                clearComponet();
                AdvertisementManager singleEmpInfo = (AdvertisementManager) requestersForPromotion.get(rse.getRow());

                String temp[] = singleEmpInfo.getDepartmentID().split("==");
                if (advertisementManager.checkPromotedEmp(singleEmpInfo.getAdvertID().toString(), singleEmpInfo.getEmpID().toString()) == false) {
                    empINFO = singleEmpInfo.getFullName() + "--->" + singleEmpInfo.getEmpID();
                    this.outputTextEmpInfo.setValue(empINFO);
//                    ResetComponents();
                    this.inputTextDateOfPromotion.setValue(currDate);

                    HashMap list = advertisementManager.readPersonalInfoForPromotion(singleEmpInfo.getEmpID(), temp[0]);
                    if (list != null) {
                        if (list.get("department") != null) {
                            lblFromDepartment.setValue(list.get("department").toString());
                        }
                        inputTextJobCode.setValue(list.get("JOB_NAME").toString());
                        inputTextRank.setValue(list.get("RANK_ID").toString());
                        inputTextPayGrade.setValue(list.get("STEP_NO").toString());
                        inputTextSalary.setValue(list.get("SALARY").toString());
                        this.btnUpdate.setDisabled(true);
                        this.btnPromote.setDisabled(false);
                        jobCodeIDFrom = list.get("JOB_CODE").toString();
                        departmentFrom = singleEmpInfo.getDepartmentID();
                       
                        HashMap readPromotionJobPostion = promotionManager.readPromotionRequestInformation(
                                singleEmpInfo.getPromotionRequestId(),
                                singleEmpInfo.getEmpID());

                        //  lblDepartmentTO.setValue(readPromotionJobPostion.get("DEPARTMENT_ID").toString());
                        //  drlJobCode.setValue(readPromotionJobPostion.get("JOB_CODE").toString());
                        // drlToRank.setValue(readPromotionJobPostion.get("RANK_ID").toString());
                        //drlToPayGrade.setValue(readPromotionJobPostion.get("").toString());

                        if (readPromotionJobPostion.get("RANK_ID") != null)
                        {
                            lblToRank.setRendered(true);
                            drlToRank.setRendered(false);
                            lblToRank.setValue(rank_id);
                            //lblToRank.setValue(readPromotionJobPostion.get("RANK_ID").toString());
                            this.setPayGradeOpt(lookUpManager.readPayGrade(readPromotionJobPostion.get("RANK_ID").toString()));
                           
                            departmentTo = readPromotionJobPostion.get("DEPARTMENT_ID").toString();
                           
                        } else {
                            lblToRank.setRendered(false);
                            drlToRank.setRendered(true);
                        }
                        if (readPromotionJobPostion.get("JOB_NAME") != null) {
                            jobCode = readPromotionJobPostion.get("JOB_CODE").toString();
                            lblToJobDescription.setValue(readPromotionJobPostion.get("JOB_NAME").toString());
                        } else {
                            lblToJobDescription.setValue("");
                        }
                        if (readPromotionJobPostion.get("DEPARTMENT_ID") != null) {
                         // departmentTo=readPromotionJobPostion.get("DEPARTMENT_ID").toString().indexOf("=");
                            int index = readPromotionJobPostion.get("DEPARTMENT_ID").toString().indexOf("=");
                            if (index > 0) {
                                departmentTo=readPromotionJobPostion.get("DEPARTMENT_ID").toString().substring(0, index);

                                lblDepartmentTO.setValue(
                                        employeeManage.departmentDetileDescription(readPromotionJobPostion.get("DEPARTMENT_ID").toString().substring(0, index)));
                            } else {

                                lblDepartmentTO.setValue(
                                        employeeManage.departmentDetileDescription(readPromotionJobPostion.get("DEPARTMENT_ID").toString().substring(0, index)));
                            }
                        } else {
                            lblDepartmentTO.setValue("");
                        }
                        if (readPromotionJobPostion.get("PAYGRADE") != null) {
                            lblPayGrade.setRendered(true);
                            drlToPayGrade.setRendered(false);
                            lblPayGrade.setValue(readPromotionJobPostion.get("PAYGRADE").toString());
                        } else {
                            lblPayGrade.setRendered(false);
                            drlToPayGrade.setRendered(true);
                            lblPayGrade.setValue("");
                        }
                        if (readPromotionJobPostion.get("SALARY") != null) {
                            txtToSalary.setValue(readPromotionJobPostion.get("SALARY").toString());
                        } else {
                            txtToSalary.setValue("");
                        }

                    } else {
                        this.showSuccessOrFailureMessage(false, "Employee Information Not Readable.Please try agin?");
                    }
                } else {
                    this.showSuccessOrFailureMessage(false, singleEmpInfo.getFullName() + " is already Promoted");
                }
            } else {
                this.showSuccessOrFailureMessage(false, "Only " + numberOfEmployeesPromoted + " Employees are needded for the place!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void clearComponet() {
        lblFromDepartment.setValue("");
        inputTextJobCode.setValue("");
        inputTextRank.setValue("");
        inputTextPayGrade.setValue("");
        inputTextSalary.setValue("");
        lblDepartmentTO.setValue("");
        lblToJobDescription.setValue("");
        lblToRank.setValue("");
        lblPayGrade.setValue("");
        txtToSalary.setValue("");
    }

    public void drlToRank_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {


                this.setPayGradeOpt(lookUpManager.readPayGrade(vce.getNewValue().toString()));

            }
        } catch (Exception ex) {
        }
    }

    public void drlToPayGrade_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            this.txtToSalary.resetValue();
            try {
                if (drlToRank.getValue() != null && !drlToRank.getValue().toString().equals("")) {
                    txtToSalary.setValue(lookUpManager.readSalary(drlToRank.getValue().toString(), drlToPayGrade.getValue().toString()));
                } else if (lblToRank.getValue() != null && !lblToRank.getValue().toString().equals("")) {
                    txtToSalary.setValue(lookUpManager.readSalary(lblToRank.getValue().toString(), drlToPayGrade.getValue().toString()));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    private boolean validateDate() {
        boolean result = true;
        if (outputTextEmpInfo.getValue() == null || outputTextEmpInfo.getValue().toString().equals("")) {
            result = false;
        }
        if (inputTextPromoter.getValue() == null || inputTextPromoter.getValue().toString().equals("")) {
            result = false;
        }
        if (inputTextDateOfPromotion.getValue() == null || inputTextDateOfPromotion.getValue().toString().equals("")) {
            result = false;
        }
        if (inputTextRank.getValue() == null || inputTextRank.getValue().toString().equals("")) {
            result = false;
        }
        if (drlToRank.getValue() == null || drlToRank.getValue().toString().equals("")) {
            if (lblToRank.getValue() == null || lblToRank.getValue().toString().equals("")) {
                result = false;
            }
        }
        if (inputTextPayGrade.getValue() == null || inputTextPayGrade.getValue().toString().equals("")) {
            result = false;
        }
        if (drlToPayGrade.getValue() == null || drlToPayGrade.getValue().toString().equals("")) {
            if (lblPayGrade.getValue() == null || lblPayGrade.getValue().toString().equals("")) {
                result = false;
            }
        }
        if (inputTextSalary.getValue() == null || inputTextSalary.getValue().toString().equals("")) {
            result = false;

        }

        if (txtToSalary.getValue() == null || txtToSalary.getValue().toString().equals("")) {
            result = false;

        }
        if (inputTextReferenceNo.getValue() == null || inputTextReferenceNo.getValue().toString().equals("")) {
            result = false;
        }

        if (inputTextReferenceDate.getValue() == null || inputTextReferenceDate.getValue().toString().equals("")) {
            result = false;
        }
        if (drlJobCode.getValue() == null || drlJobCode.getValue().toString().equals("")) {
            if (jobCode == null || jobCode.toString().equals("")) {

                result = false;
            }
        }


        return result;
    }

    public String btnPromote_action()
    {
        String empID = null;
        String promoterID = null;
        String promotionDate = null;
        String adverID = null;
        String rankFrom = null;
        String rankTo = null;
        String stepFrom = null;
        String stepTo = null;
        String salaryFrom = null;
        String salaryTo = null;
        String referenceNo = null;
        String refrenceDate = null;
        String jobCodeFrom = null;
        String jobCodeTo = null;
        // String jobCodeIDFrom = null;
        int checkSave = 0;

        if (validateDate()) {
            if (drlJobCode.getValue() != null) {
                jobCodeTo = drlJobCode.getValue().toString();
            } else {
                jobCodeTo = jobCode;
            }
            if (drlToPayGrade.getValue() != null && !drlToPayGrade.getValue().toString().equals("")) {
                stepTo = drlToPayGrade.getValue().toString();
            } else {
                stepTo = lblPayGrade.getValue().toString();
            }
            if (drlToRank.getValue() != null && !drlToRank.getValue().toString().equals("")) {
                rankTo = drlToRank.getValue().toString();
            } else {
                rankTo = lblToRank.getValue().toString();
            }
            jobCodeFrom = jobCodeIDFrom;
            refrenceDate = inputTextReferenceDate.getValue().toString();
            referenceNo = inputTextReferenceNo.getValue().toString();
            salaryTo = txtToSalary.getValue().toString();
            salaryFrom = inputTextSalary.getValue().toString();
            stepFrom = inputTextPayGrade.getValue().toString();
            rankFrom = inputTextRank.getValue().toString();
            promotionDate = inputTextDateOfPromotion.getValue().toString();
            String temp[] = outputTextEmpInfo.getValue().toString().split("--->");
            empID = temp[1];
            String temp1[] = inputTextPromoter.getValue().toString().split("--");
            promoterID = temp1[1];

            // jobCodeIDFrom = this.inputTextJobCodeID.getValue().toString();
           

            PromotionManager promoMan = new PromotionManager(
                    empID,
                    promoterID,
                    jobCodeIDFrom,
                    jobCodeTo,
                    refrenceDate,
                    referenceNo,
                    salaryFrom,
                    salaryTo,
                    stepFrom,
                    stepTo,
                    rankFrom,
                    rankTo,
                    promotionDate,
                    advertID,
                    departmentFrom,
                    departmentTo);
            checkSave = promotionManager.insertPromotion(promoMan);
            if (checkSave == 1)
            {
                this.showSuccessOrFailureMessage(true, "Employee Promoted !!!");
                promotedIndividuals = promotionManager.readPromotedEmployees(String.valueOf(this.advertID));
                clearPromotionComponents();
            } else {
                this.showSuccessOrFailureMessage(false, "Please try again !!!");
            }
        } else {
            this.showSuccessOrFailureMessage(false, "Please correct input data ? ");
        }

        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {

        String empID = null;
        String promoterID = null;
        String promotionDate = null;
        String promotionType = null;
        String rankFrom = null;
        String rankTo = null;
        String stepFrom = null;
        String stepTo = null;
        String salaryFrom = null;
        String salaryTo = null;
        String referenceNo = null;
        String refrenceDate = null;
        String jobCodeFrom = null;
        String jobCodeTo = null;

        int checkUpdate = 0;
        if (validateDate()) {
            if (drlJobCode.getValue() != null) {
                jobCodeTo = drlJobCode.getValue().toString();
            } else {
                jobCodeTo = jobCode;
            }
            if (drlToPayGrade.getValue() != null && !drlToPayGrade.getValue().toString().equals("")) {
                stepTo = drlToPayGrade.getValue().toString();
            } else {
                stepTo = lblPayGrade.getValue().toString();
            }
            if (drlToRank.getValue() != null && !drlToRank.getValue().toString().equals("")) {
                rankTo = drlToRank.getValue().toString();
            } else {
                rankTo = lblToRank.getValue().toString();
            }





            //     jobCodeFrom = inputTextJobCode.getValue().toString();
            refrenceDate = inputTextReferenceDate.getValue().toString();
            referenceNo = inputTextReferenceNo.getValue().toString();
            salaryTo = txtToSalary.getValue().toString();
            salaryFrom = inputTextSalary.getValue().toString();

            stepFrom = inputTextPayGrade.getValue().toString();

            rankFrom = inputTextRank.getValue().toString();
            promotionDate = inputTextDateOfPromotion.getValue().toString();
            String temp[] = outputTextEmpInfo.getValue().toString().split("--->");
            empID = temp[1];
            String temp1[] = inputTextPromoter.getValue().toString().split("--");
            promoterID = temp1[1];


            PromotionManager promoMan = new PromotionManager(empID, promoterID, jobCodeIDFrom, jobCodeTo,
                    refrenceDate, referenceNo, salaryFrom, salaryTo, stepFrom, stepTo,
                    rankFrom, rankTo, promotionDate, advertID, null, null, null, null,
                    null, Integer.valueOf(temp[2]));
            checkUpdate = promotionManager.updatePromotion(promoMan);

            if (checkUpdate == 1) {
                this.showSuccessOrFailureMessage(true, "Employee Promotion Updated Successes fully !!!");
            } else {
                this.showSuccessOrFailureMessage(false, "Please try again !!!");
            }

        } else {
            this.showSuccessOrFailureMessage(false, "Job information From is empty Please try again !!!");
        }
//return null means stay on the same page
        return null;
    }

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (!vce.getNewValue().toString().equals("00")) {
                this.btnUpdate.setDisabled(true);
                this.btnPromote.setDisabled(true);
                selectOneListboxPromotionRequestes.resetValue();
                String date[] = vce.getNewValue().toString().split("----");
                newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAproveFilterdByDate(date[1].trim(), date[2].trim());
                numberOfEmployeesPromoted = Integer.valueOf(date[0].trim());
            }

        }
    }

    public void selectOneListbox2RequestForPromo_processValueChange(ValueChangeEvent vce) {
        float interviewPercentage = 0.0f;
        float presentationPercentage = 0.0f;
        float writtenPercentage = 0.0f;
        float otherPercentage = 0.0f;
        float disciplineValue = 5.0f;
        float performanceValue = 0.0f;
        float disciplinePercentage = 0.0f;
        float performancePercentage = 0.0f;
        int educLevelId = 0;
        int educLevelresult = 0;
        if (vce.getNewValue() != null)
        {
            advertID=Integer.parseInt(vce.getNewValue().toString());
            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
        
            try {
                this.vacancyList.clear();
                HashMap[] list = advertisementManager.readVacancyPromoRequest(vce.getNewValue().toString());
                rank_id = list[0].get("RANK_ID").toString();
                advertisementManager.setRank(Integer.parseInt(rank_id));
                if (list.length > 0) {
                    for (int i = 0; i < list.length; i++) {

                        AdvertisementManager addToTable = new AdvertisementManager(
                                list[i].get("advert_date_from").toString(),
                                list[i].get("advert_date_to").toString(),
                                list[i].get("recruit_batch_code").toString(),
                                list[i].get("JOB_NAME").toString(),
                                list[i].get("RECRUIT_REQUEST_ID").toString(),
                                list[i].get("RECRUIT_REQUEST_TYPE").toString(),
                                list[i].get("NUM_OF_EMPS_APPROVED").toString(),
                                list[i].get("MIN_EXPERIENCE").toString(),
                                list[i].get("ADVERT_ID").toString(),
                                list[i].get("QUALIFICATION").toString(),
                                list[i].get("EDUCATION_LEVEL").toString(),
                                list[i].get("JOB_CODE").toString(), 0, 0, list[i].get("RANK_ID").toString());
                        this.vacancyList.add(addToTable);
                    }
                }
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterJustFinalForPromotion(vce.getNewValue().toString());
                requestersForPromotion.clear();
                if (listRequester.length > 0) {
                    enableEvaluationComponents();
                    HashMap promotionAssessmentPercentage = promotionManager.selectPromotionAssessmentPrecentage(bach_Code);
                    if (promotionAssessmentPercentage != null && promotionAssessmentPercentage.size() > 0) {
                        interviewPercentage = Float.parseFloat(promotionAssessmentPercentage.get("interviewpercentage").toString());
                        presentationPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("presentationpercentage").toString());
                        writtenPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("writtenpercentage").toString());
                        otherPercentage =
                                Float.parseFloat(promotionAssessmentPercentage.get("otherpercentage").toString());
                        checkPercentage = true;
                    }
                    for (int i = 0; i < listRequester.length; i++) {
                        educLevelId = advertisementManager.readEducLevel(listRequester[i].get("EMP_ID").toString());
                        educLevelresult = advertisementManager.readEducLevelresult(educLevelId, rank_id);
                        if (promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString()) <= 5) {
                            disciplineValue -= (float) promotionManager.countDisciplineCase(listRequester[i].get("EMP_ID").toString());
                        } else {
                            disciplineValue -= 5;
                        }
                        performanceValue = promotionManager.employeePerformanceResult(listRequester[i].get("EMP_ID").toString());
                        AdvertisementManager addToTable = new AdvertisementManager(
                                educLevelresult,
                                listRequester[i].get("EMP_ID").toString(),
                                listRequester[i].get("EXPERIENCE").toString(),
                                listRequester[i].get("FULLNAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("JOB_DESCRIPTION").toString(),
                                listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("ADVERT_ID").toString(),
                                listRequester[i].get("DEPARTMENT_ID").toString(),
                                Float.parseFloat(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("PRESENTATION_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("OTHER_RESULT").toString()),
                                listRequester[i].get("PROMOTION_REQUEST_ID").toString(),
                                disciplineValue,
                                performanceValue);
                        getRequestersForPromotion().add(addToTable);
                        disciplineValue = 5.0f;
                        performanceValue = 0.0f;
                    }

                }
                checkFromSelect = false;



            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public String buttonViewAll_action() {
        newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAprove();
        this.btnUpdate.setDisabled(true);
        this.btnPromote.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1IndividualHistory_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            try {
                int index = vce.getNewValue().toString().indexOf("---");
                if (index > 0) {
                    ResetComponents();
                    String extID[] = vce.getNewValue().toString().split("---");
                    String empID[] = extID[1].split("--");
                    HashMap listRequester = promotionManager.readPromotionIndividualDetail(extID[0]);

                    if (listRequester != null && !listRequester.isEmpty()) {
                        this.btnUpdate.setDisabled(false);
                        this.btnPromote.setDisabled(true);
                        inputTextJobCode.setValue(listRequester.get("JOB_CODE_FROM").toString());
                        inputTextRank.setValue(listRequester.get("RANK_FROM").toString());
                        inputTextPayGrade.setValue(listRequester.get("STEP_FROM").toString());
                        inputTextSalary.setValue(listRequester.get("SALARY_FROM").toString());
                        lblToJobDescription.setValue(listRequester.get("JOB_DESCRIPTION").toString());
                        inputTextJobCodeID.setValue(listRequester.get("JOB_CODE_FROM").toString());
                        lblToRank.setRendered(false);
                        drlToRank.setRendered(true);
                        lblPayGrade.setRendered(false);
                        drlToPayGrade.setRendered(true);
                        drlToRank.setValue(listRequester.get("RANK_TO").toString());
                        this.setPayGradeOpt(lookUpManager.readPayGrade(listRequester.get("RANK_TO").toString()));
                        drlToPayGrade.setValue(listRequester.get("STEP_TO").toString());
                        txtToSalary.setValue(listRequester.get("SALARY_TO").toString());
                        inputTextDateOfPromotion.setValue(listRequester.get("PROMOTION_DATE").toString());
                        inputTextReferenceNo.setValue(listRequester.get("REFERENCE_NO").toString());
                        inputTextReferenceDate.setValue(listRequester.get("REFERENCE_DATE").toString());
                        empINFO = empID[0] + " " + empID[1] + " " + empID[2] + "--->" + empID[3] + "--->" + extID[0];
                        jobCode = listRequester.get("JOB_CODE_TO").toString();
                        this.outputTextEmpInfo.setValue(empINFO);
                        if (listRequester.get("DEPARTMENTTO") != null) {
                            lblDepartmentTO.setValue("" + employeeManage.departmentDetileDescription(listRequester.get("DEPARTMENTTO").toString()));
                        }
                        if (listRequester.get("DEPARTMENTFROM") != null) {
                            lblFromDepartment.setValue("" + employeeManage.departmentDetileDescription(listRequester.get("DEPARTMENTFROM").toString()));
                        }
//                        EmployeeManage employeeManager = new EmployeeManage();
//                        employeeManager.loadEmpoyeeProfile(empID[3]);
//                        lblFromDepartment.setValue(employeeManager.getDepartment());
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public String cmdrecPromotionApproval_action() {

        return "ApproveRequestPromotion";
    }

    public String cmdPromotionRequest_action() {

        return "RequestForPromotion";
    }

    public String cmdrecPromoteEmployee_action() {

        return "PromoteEmployee";
    }

    public String buttonDateOfPromotion_action() {
        calPromotionDate.setRendered(true);
        return null;
    }

    public void calPromotionDate_processValueChange(ValueChangeEvent vce) {
        String selectedDate = dateFormat.format((Date) calPromotionDate.getValue());
        inputTextDateOfPromotion.setValue(dateFormat.format(calPromotionDate.getValue()));
        calPromotionDate.setRendered(false);
    }

    public String buttonCalReferenceDate_action() {
        calReferenceDate.setRendered(true);
        return null;
    }

    public void calReferenceDate_processValueChange(ValueChangeEvent vce) {
        String selectedDate = dateFormat.format((Date) calReferenceDate.getValue());
        inputTextReferenceDate.setValue(dateFormat.format(calReferenceDate.getValue()));
        calReferenceDate.setRendered(false);
    }
}

