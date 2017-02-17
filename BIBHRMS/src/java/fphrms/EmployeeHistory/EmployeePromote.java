/*
 * RequestForPromotion.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
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
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.event.ValueChangeEvent;
import manager.recruitmentManager.AdvertisementManager;

import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import com.sun.webui.jsf.model.Option;
import control.ReportControl;
import java.io.File;
import java.util.Collection;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import manager.departmentManage.DepartmentManage;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeHistoryManager.PromotionManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.LookUpManager;
import manager.globalUseManager.StringDateManipulation;
import manager.recruitmentManager.RecruitmentManager;
import manager.recruitmentManager.VacancyNoticeListManager;
import net.sf.jasperreports.engine.JRDataSource;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeePromote extends AbstractPageBean {

    VacancyNoticeListManager vacancyNoticeListManager = new VacancyNoticeListManager();
    DepartmentManage departmentManage = new DepartmentManage();
    AdvertisementManager advertisementManager = new AdvertisementManager();
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    PromotionManager promotionManager = new PromotionManager();
    private ArrayList<SelectItem> criteraForMPromotion = new ArrayList<SelectItem>();
    public ArrayList<SelectItem> newPromotionRequestsDates = new ArrayList<SelectItem>();
    private Option[] qualifiedIndividualsBasedOnYear = null;
    private ReportControl reportControl = new ReportControl();
    private String sessionID = "";
    private EmployeeManage employeeManage = new EmployeeManage();
    private String employeeId = null;
    private ImageIcon LOGO;
    private ImageIcon employeePicture;
    private byte[] bytEmployeePicture;

    public byte[] getBytEmployeePicture() {
        return bytEmployeePicture;
    }

    public void setBytEmployeePicture(byte[] bytEmployeePicture) {
        this.bytEmployeePicture = bytEmployeePicture;
    }

    public Option[] getQualifiedIndividualsBasedOnYear() {
        return qualifiedIndividualsBasedOnYear;
    }

    public void setQualifiedIndividualsBasedOnYear(Option[] qualifiedIndividualsBasedOnYear) {
        this.qualifiedIndividualsBasedOnYear = qualifiedIndividualsBasedOnYear;
    }

    public ArrayList<SelectItem> getCriteraForMPromotion() {
        return criteraForMPromotion;
    }

    public void setCriteraForMPromotion(ArrayList<SelectItem> criteraForMPromotion) {
        this.criteraForMPromotion = criteraForMPromotion;
    }

    public ArrayList<SelectItem> getNewPromotionRequestsDates() {
        return newPromotionRequestsDates;
    }

    public void setNewPromotionRequestsDates(ArrayList<SelectItem> newPromotionRequestsDates) {
        this.newPromotionRequestsDates = newPromotionRequestsDates;
    }
    public ArrayList<SelectItem> listOfJobType = new ArrayList<SelectItem>();
    public ArrayList<SelectItem> listPromotingEmployee = new ArrayList<SelectItem>();
    public List vacancyList = new ArrayList<AdvertisementManager>();
    private List requestersForPromotion = new ArrayList<AdvertisementManager>();
    public List vacancyListRequestPromo = new ArrayList<VacancyNoticeListManager>();
    private PanelPopup pnMessage = new PanelPopup();
    private Option[] newPromotionRequests = recruitmentManager.newPromotionRequests();
    private ArrayList<SelectItem> promotionSegestion = new ArrayList<SelectItem>();
    private Option[] newPromotionResponsedApprove;
    public ArrayList<SelectItem> promotedIndividuals = new ArrayList<SelectItem>();
    EvaluationResultManager evaResultManObject = new EvaluationResultManager();
    private Option[] toFilterResultUsingSession;
    private String SessionID = "";
    private LookUpManager lookUpManager = new LookUpManager();
    private String currDate = StringDateManipulation.toDayInEc();
    private String empINFO = null;
    private int advertID = -1;
    private int numberOfEmployeesPromoted = -1;
    private String zerfDescription = "";
    private String directorateDescription = "";
    private String divisionDescription = "";
    private String mastebaberiaDescription = "";
    private String teamDescription = "";
    private byte[] empImage = null;
    private ArrayList<SelectItem> department = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> devision = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> directorate = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> team = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> mastebaberi = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> _title = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> _jobRank = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> payGradeOpt = new ArrayList<SelectItem>();
    private String promotioin_id = null;
    EmployeeManage employeeManager = new EmployeeManage();

    public ArrayList<SelectItem> getPromotionSegestion() {
        return promotionSegestion;
    }

    public void setPromotionSegestion(ArrayList<SelectItem> promotionSegestion) {
        this.promotionSegestion = promotionSegestion;
    }

    public ArrayList<SelectItem> getPromotedIndividuals() {
        return promotedIndividuals;
    }

    public void setPromotedIndividuals(ArrayList<SelectItem> promotedIndividuals) {
        this.promotedIndividuals = promotedIndividuals;
    }

    public String getPromotioin_id() {
        return promotioin_id;
    }

    public void setPromotioin_id(String promotioin_id) {
        this.promotioin_id = promotioin_id;
    }

    public byte[] getEmpImage() {
        return empImage;
    }

    public void setEmpImage(byte[] empImage) {
        this.empImage = empImage;
    }

    public ArrayList<SelectItem> get_title() {
        return _title;
    }

    public void set_title(ArrayList<SelectItem> _title) {
        this._title = _title;
    }

    public ArrayList<SelectItem> getPerofation() {
        return perofation;
    }

    public void setPerofation(ArrayList<SelectItem> perofation) {
        this.perofation = perofation;
    }

    public ArrayList<SelectItem> getMastebaberi() {
        return mastebaberi;
    }

    public void setMastebaberi(ArrayList<SelectItem> mastebaberi) {
        this.mastebaberi = mastebaberi;
    }

    public ArrayList<SelectItem> getDepartment() {
        return department;
    }

    public void setDepartment(ArrayList<SelectItem> department) {
        this.department = department;
    }

    public ArrayList<SelectItem> getDevision() {
        return devision;
    }

    public void setDevision(ArrayList<SelectItem> devision) {
        this.devision = devision;
    }

    public ArrayList<SelectItem> getDirectorate() {
        return directorate;
    }

    public void setDirectorate(ArrayList<SelectItem> directorate) {
        this.directorate = directorate;
    }

    public ArrayList<SelectItem> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<SelectItem> team) {
        this.team = team;
    }

    public ArrayList<SelectItem> getZerf() {
        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }

    public ArrayList<SelectItem> getListPromotingEmployee() {
        return listPromotingEmployee;
    }

    public void setListPromotingEmployee(ArrayList<SelectItem> listPromotingEmployee) {
        this.listPromotingEmployee = listPromotingEmployee;
    }

    public Option[] getNewPromotionResponsedApprove() {
        return newPromotionResponsedApprove;
    }

    public void setNewPromotionResponsedApprove(Option[] newPromotionResponsedApprove) {
        this.newPromotionResponsedApprove = newPromotionResponsedApprove;
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
    private PanelPopup evaResultPopUpMsg = new PanelPopup();

    public PanelPopup getEvaResultPopUpMsg() {
        return evaResultPopUpMsg;
    }

    public void setEvaResultPopUpMsg(PanelPopup pp) {
        this.evaResultPopUpMsg = pp;
    }
    private HtmlCommandButton btnCancel1 = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancel1() {
        return btnCancel1;
    }

    public void setBtnCancel1(HtmlCommandButton hcb) {
        this.btnCancel1 = hcb;
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
    private HtmlCommandButton btnOK = new HtmlCommandButton();

    public HtmlCommandButton getBtnOK() {
        return btnOK;
    }

    public void setBtnOK(HtmlCommandButton hcb) {
        this.btnOK = hcb;
    }
    private RowSelector rowSelectorPromoteEmployee = new RowSelector();

    public RowSelector getRowSelectorPromoteEmployee() {
        return rowSelectorPromoteEmployee;
    }

    public void setRowSelectorPromoteEmployee(RowSelector rs) {
        this.rowSelectorPromoteEmployee = rs;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private HtmlSelectOneListbox selectOneListbox1IndividualHistory = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1IndividualHistory() {
        return selectOneListbox1IndividualHistory;
    }

    public void setSelectOneListbox1IndividualHistory(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1IndividualHistory = hsol;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
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
    private DefaultSelectedData selectOneMenu6Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu6Bean() {
        return selectOneMenu6Bean;
    }

    public void setSelectOneMenu6Bean(DefaultSelectedData dsd) {
        this.selectOneMenu6Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu6DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu6DefaultItems() {
        return selectOneMenu6DefaultItems;
    }

    public void setSelectOneMenu6DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu6DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu7Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu7Bean() {
        return selectOneMenu7Bean;
    }

    public void setSelectOneMenu7Bean(DefaultSelectedData dsd) {
        this.selectOneMenu7Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu7DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu7DefaultItems() {
        return selectOneMenu7DefaultItems;
    }

    public void setSelectOneMenu7DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu7DefaultItems = dsi;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
    }
    private DefaultSelectedData selectOneMenu8Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu8Bean() {
        return selectOneMenu8Bean;
    }

    public void setSelectOneMenu8Bean(DefaultSelectedData dsd) {
        this.selectOneMenu8Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu8DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu8DefaultItems() {
        return selectOneMenu8DefaultItems;
    }

    public void setSelectOneMenu8DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu8DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu9Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu9Bean() {
        return selectOneMenu9Bean;
    }

    public void setSelectOneMenu9Bean(DefaultSelectedData dsd) {
        this.selectOneMenu9Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu9DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu9DefaultItems() {
        return selectOneMenu9DefaultItems;
    }

    public void setSelectOneMenu9DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu9DefaultItems = dsi;
    }
    private HtmlInputText txtEmployeeID = new HtmlInputText();

    public HtmlInputText getTxtEmployeeID() {
        return txtEmployeeID;
    }

    public void setTxtEmployeeID(HtmlInputText hit) {
        this.txtEmployeeID = hit;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox choMale = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChoMale() {
        return choMale;
    }

    public void setChoMale(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.choMale = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox choFemale = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChoFemale() {
        return choFemale;
    }

    public void setChoFemale(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.choFemale = hsbc;
    }
    private HtmlOutputText lblDepartmentDes = new HtmlOutputText();

    public HtmlOutputText getLblDepartmentDes() {
        return lblDepartmentDes;
    }

    public void setLblDepartmentDes(HtmlOutputText hot) {
        this.lblDepartmentDes = hot;
    }
    private HtmlOutputText lblJobPosition = new HtmlOutputText();

    public HtmlOutputText getLblJobPosition() {
        return lblJobPosition;
    }

    public void setLblJobPosition(HtmlOutputText hot) {
        this.lblJobPosition = hot;
    }
    private HtmlOutputText lblHireDate = new HtmlOutputText();

    public HtmlOutputText getLblHireDate() {
        return lblHireDate;
    }

    public void setLblHireDate(HtmlOutputText hot) {
        this.lblHireDate = hot;
    }
    private HtmlOutputText lblTotalServiceYear = new HtmlOutputText();

    public HtmlOutputText getLblTotalServiceYear() {
        return lblTotalServiceYear;
    }

    public void setLblTotalServiceYear(HtmlOutputText hot) {
        this.lblTotalServiceYear = hot;
    }
    private HtmlGraphicImage imgMember = new HtmlGraphicImage();

    public HtmlGraphicImage getImgMember() {
        return imgMember;
    }

    public void setImgMember(HtmlGraphicImage hgi) {
        this.imgMember = hgi;
    }
    private HtmlSelectOneMenu drlZerf = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZerf() {
        return drlZerf;
    }

    public void setDrlZerf(HtmlSelectOneMenu hsom) {
        this.drlZerf = hsom;
    }
    private HtmlSelectOneMenu drlDirectorate = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDirectorate() {
        return drlDirectorate;
    }

    public void setDrlDirectorate(HtmlSelectOneMenu hsom) {
        this.drlDirectorate = hsom;
    }
    private HtmlSelectOneMenu drlMastebaberia = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlMastebaberia() {
        return drlMastebaberia;
    }

    public void setDrlMastebaberia(HtmlSelectOneMenu hsom) {
        this.drlMastebaberia = hsom;
    }
    private HtmlSelectOneMenu drlProfession = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProfession() {
        return drlProfession;
    }

    public void setDrlProfession(HtmlSelectOneMenu hsom) {
        this.drlProfession = hsom;
    }
    private HtmlSelectOneMenu drlTeam = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTeam() {
        return drlTeam;
    }

    public void setDrlTeam(HtmlSelectOneMenu hsom) {
        this.drlTeam = hsom;
    }
    private HtmlSelectOneMenu drlDivision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDivision() {
        return drlDivision;
    }

    public void setDrlDivision(HtmlSelectOneMenu hsom) {
        this.drlDivision = hsom;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox choMilitary = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChoMilitary() {
        return choMilitary;
    }

    public void setChoMilitary(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.choMilitary = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox choCivil = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChoCivil() {
        return choCivil;
    }

    public void setChoCivil(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.choCivil = hsbc;
    }
    private HtmlSelectOneMenu drlTitle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTitle() {
        return drlTitle;
    }

    public void setDrlTitle(HtmlSelectOneMenu hsom) {
        this.drlTitle = hsom;
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
    private HtmlOutputText lblSalary = new HtmlOutputText();

    public HtmlOutputText getLblSalary() {
        return lblSalary;
    }

    public void setLblSalary(HtmlOutputText hot) {
        this.lblSalary = hot;
    }
    private HtmlOutputText lblRankDescr = new HtmlOutputText();

    public HtmlOutputText getLblRankDescr() {
        return lblRankDescr;
    }

    public void setLblRankDescr(HtmlOutputText hot) {
        this.lblRankDescr = hot;
    }
    private HtmlOutputText lblOldSalary = new HtmlOutputText();

    public HtmlOutputText getLblOldSalary() {
        return lblOldSalary;
    }

    public void setLblOldSalary(HtmlOutputText hot) {
        this.lblOldSalary = hot;
    }
    private HtmlOutputText lblPayGrade = new HtmlOutputText();

    public HtmlOutputText getLblPayGrade() {
        return lblPayGrade;
    }

    public void setLblPayGrade(HtmlOutputText hot) {
        this.lblPayGrade = hot;
    }
    private HtmlCommandButton btnPromote = new HtmlCommandButton();

    public HtmlCommandButton getBtnPromote() {
        return btnPromote;
    }

    public void setBtnPromote(HtmlCommandButton hcb) {
        this.btnPromote = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(HtmlCommandButton hcb) {
        this.btnCancel = hcb;
    }
    private DefaultSelectedData defaultSelectedData15 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData15() {
        return defaultSelectedData15;
    }

    public void setDefaultSelectedData15(DefaultSelectedData dsd) {
        this.defaultSelectedData15 = dsd;
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
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
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
    private DefaultSelectedData defaultSelectedData19 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData19() {
        return defaultSelectedData19;
    }

    public void setDefaultSelectedData19(DefaultSelectedData dsd) {
        this.defaultSelectedData19 = dsd;
    }
    private DefaultSelectedData defaultSelectedData20 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData20() {
        return defaultSelectedData20;
    }

    public void setDefaultSelectedData20(DefaultSelectedData dsd) {
        this.defaultSelectedData20 = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox5Bean() {
        return selectBooleanCheckbox5Bean;
    }

    public void setSelectBooleanCheckbox5Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox5Bean = dsd;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox choPerformance = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChoPerformance() {
        return choPerformance;
    }

    public void setChoPerformance(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.choPerformance = hsbc;
    }
    private DefaultSelectedData defaultSelectedData22 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData22() {
        return defaultSelectedData22;
    }

    public void setDefaultSelectedData22(DefaultSelectedData dsd) {
        this.defaultSelectedData22 = dsd;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox1TotalService1 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox1TotalService1() {
        return selectBooleanCheckbox1TotalService1;
    }

    public void setSelectBooleanCheckbox1TotalService1(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox1TotalService1 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckboxIncProWith = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckboxIncProWith() {
        return selectBooleanCheckboxIncProWith;
    }

    public void setSelectBooleanCheckboxIncProWith(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxIncProWith = hsbc;
    }
    private HtmlInputText inputTextPOPTotalS = new HtmlInputText();

    public HtmlInputText getInputTextPOPTotalS() {
        return inputTextPOPTotalS;
    }

    public void setInputTextPOPTotalS(HtmlInputText hit) {
        this.inputTextPOPTotalS = hit;
    }
    private HtmlInputText inputTextPOPIncPromWith = new HtmlInputText();

    public HtmlInputText getInputTextPOPIncPromWith() {
        return inputTextPOPIncPromWith;
    }

    public void setInputTextPOPIncPromWith(HtmlInputText hit) {
        this.inputTextPOPIncPromWith = hit;
    }
    private HtmlInputText inputTextPOPPerformance = new HtmlInputText();

    public HtmlInputText getInputTextPOPPerformance() {
        return inputTextPOPPerformance;
    }

    public void setInputTextPOPPerformance(HtmlInputText hit) {
        this.inputTextPOPPerformance = hit;
    }
    private PanelPopup panelPopup1 = new PanelPopup();

    public PanelPopup getPanelPopup1() {
        return panelPopup1;
    }

    public void setPanelPopup1(PanelPopup pp) {
        this.panelPopup1 = pp;
    }
    private HtmlInputText inputTextPromoteFrequency = new HtmlInputText();

    public HtmlInputText getInputTextPromoteFrequency() {
        return inputTextPromoteFrequency;
    }

    public void setInputTextPromoteFrequency(HtmlInputText hit) {
        this.inputTextPromoteFrequency = hit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private PanelLayout PanelLayOutevaResultInside = new PanelLayout();

    public PanelLayout getPanelLayOutevaResultInside() {
        return PanelLayOutevaResultInside;
    }

    public void setPanelLayOutevaResultInside(PanelLayout pl) {
        this.PanelLayOutevaResultInside = pl;
    }
    private HtmlSelectOneMenu selectOneMenuSelectSessionIn = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuSelectSessionIn() {
        return selectOneMenuSelectSessionIn;
    }

    public void setSelectOneMenuSelectSessionIn(HtmlSelectOneMenu hsom) {
        this.selectOneMenuSelectSessionIn = hsom;
    }
    private HtmlOutputText outputText14evaResultPopUpMsg1 = new HtmlOutputText();

    public HtmlOutputText getOutputText14evaResultPopUpMsg1() {
        return outputText14evaResultPopUpMsg1;
    }

    public void setOutputText14evaResultPopUpMsg1(HtmlOutputText hot) {
        this.outputText14evaResultPopUpMsg1 = hot;
    }
    private HtmlInputText inputTextDicipCri = new HtmlInputText();

    public HtmlInputText getInputTextDicipCri() {
        return inputTextDicipCri;
    }

    public void setInputTextDicipCri(HtmlInputText hit) {
        this.inputTextDicipCri = hit;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckboxDicipCrit = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckboxDicipCrit() {
        return selectBooleanCheckboxDicipCrit;
    }

    public void setSelectBooleanCheckboxDicipCrit(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxDicipCrit = hsbc;
    }
    private HtmlCommandButton buttonDisplayCriteria = new HtmlCommandButton();

    public HtmlCommandButton getButtonDisplayCriteria() {
        return buttonDisplayCriteria;
    }

    public void setButtonDisplayCriteria(HtmlCommandButton hcb) {
        this.buttonDisplayCriteria = hcb;
    }
    private HtmlInputText txtPromotionDate = new HtmlInputText();

    public HtmlInputText getTxtPromotionDate() {
        return txtPromotionDate;
    }

    public void setTxtPromotionDate(HtmlInputText hit) {
        this.txtPromotionDate = hit;
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
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox choDisplayOnPage = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChoDisplayOnPage() {
        return choDisplayOnPage;
    }

    public void setChoDisplayOnPage(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.choDisplayOnPage = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox choPrivewOnReport = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChoPrivewOnReport() {
        return choPrivewOnReport;
    }

    public void setChoPrivewOnReport(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.choPrivewOnReport = hsbc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeePromote() {
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
        criteraForMPromotion = promotionManager.SelectionCriteriaForMPromo();

        this.setZerf(departmentManage.getDepartmentName());
        clearPromotionComponets();
        disabelPromotionComponets();
        // promotionSegestion = promotionManager.listOfPromotionSegestion();
        this.toFilterResultUsingSession = evaResultManObject.readAllSessionsResultsGivenToPromotion();
        _jobRank = lookUpManager.assignJobRank("Military");
        // inputTextPromoter.setValue(this.getSessionBean1().getEmployeeName() + "--" + this.getSessionBean1().getEmployeeId());
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

    public void enableEvaluationComponents() {
        selectBooleanCheckbox1TotalService.setDisabled(false);
        selectBooleanCheckbox2Performance.setDisabled(false);
        selectBooleanCheckbox3EducationLevel.setDisabled(false);
        selectBooleanCheckbox4Training.setDisabled(false);


    }

    public String numberFormatChecker(String inputNumber) {
        String patternNumber = "^?[0-9]+(\\.[0-9]+)?$";
        boolean matchStringText = Pattern.matches(patternNumber, (CharSequence) (inputNumber.toString().subSequence(0, inputNumber.length())));
        if (matchStringText == true) {
            return "match";
        } else {
            return "Invalid number Format";
        }



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
        //this.inputTextRank.resetValue();
        // this.inputTextPayGrade.resetValue();
        // this.inputTextSalary.resetValue();
        //   this.inputTextDateOfPromotion.resetValue();
        //    this.selectOneMenu1PayGrade.resetValue();
//      ..  this.inputTextSalaryActual.resetValue();
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
//
//        if (vce.getNewValue() != null) {
//
//            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
//            try {
//
//                this.requestersForPromotion.clear();
//                HashMap[] listRequester = advertisementManager.readPromotionRequestsForApprovement(vce.getNewValue().toString());
//
//                if (listRequester.length > 0) {
//                    //enableEvaluationComponents();
//
////                    for (int i = 0; i < listRequester.length; i++) {
////
////                        AdvertisementManager addToTable = new AdvertisementManager(listRequester[i].get("EMP_ID").toString(), listRequester[i].get("FIRST_NAME").toString() +
////                                " " + listRequester[i].get("MIDDLE_NAME").toString() +
////                                " " + listRequester[i].get("LAST_NAME").toString(),
////                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
////                                listRequester[i].get("EDUC_TYPE_DISC").toString(), listRequester[i].get("EXPERIENCE").toString(),
////                                listRequester[i].get("EDUC_LEVEL_DISC").toString(),
////                                listRequester[i].get("EDUC_TYPE_DISC").toString(), listRequester[i].get("PERCENT_EX").toString(),
////                                listRequester[i].get("PERCENT_PR").toString(), listRequester[i].get("PERCENT_EL").toString(),
////                                listRequester[i].get("PERCENT_TR").toString(), listRequester[i].get("PROMOTIONTOTAL").toString(),
////                                listRequester[i].get("ADVERT_ID").toString());
////
////                        this.requestersForPromotion.add(addToTable);
////                    }
//
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
    }

    public void selectOneMenu1Rank_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {


                this.setPayGradeOpt(lookUpManager.readPayGrade(vce.getNewValue().toString()));

            }
        } catch (Exception ex) {
        }
    }

    private HashMap promotionInformation() {
        String employeeId = null;
        String employmentType = "";
        String profession = "";
        String title = null;
        String rank = null;
        String payGrade = null;
        String salary = null;

        String currentDate = StringDateManipulation.toDayInEc();
        if (txtEmployeeID.getValue() != null) {
            employeeId = txtEmployeeID.getValue().toString();
        }
        if (drlZerf.getValue() != null) {
            zerfDescription = this.drlZerf.getValue().toString();

            if (this.drlDirectorate.getValue() != null) {
                directorateDescription = this.drlDirectorate.getValue().toString();
                if (this.drlDivision.getValue() != null) {                  //
                    divisionDescription = this.drlDivision.getValue().toString();
                    if (this.drlMastebaberia.getValue() != null) {
                        mastebaberiaDescription = this.drlMastebaberia.getValue().toString();
                        if (drlTeam.getValue() != null) {
                            teamDescription = this.drlTeam.getValue().toString();
//        }
                        }
                    }
                }
            }
        }
        if (drlProfession.getValue() != null) {
            profession = drlProfession.getValue().toString();
        }
        if (choCivil.isSelected()) {
            employmentType = "Civil";
        }
        if (choMilitary.isSelected()) {
            employmentType = "Miltery";
        }
        if (drlTitle.getValue() != null) {
            title = drlTitle.getValue().toString();
        }
        if (drlRankId.getValue() != null) {
            rank = drlRankId.getValue().toString();
        }
        if (drlPayGrade.getValue() != null) {
            payGrade = drlPayGrade.getValue().toString();
        }
        salary = lblSalary.getValue().toString();
        int promotionStatus = promotionManager.readPromotionStatus(employeeId);
        promotionStatus += 1;
        HashMap requestInfo = new HashMap();
        requestInfo.put("employeeId", employeeId);
        requestInfo.put("zerf", zerfDescription);
        requestInfo.put("directorate", directorateDescription);
        requestInfo.put("division", divisionDescription);
        requestInfo.put("mastebaberia", mastebaberiaDescription);
        requestInfo.put("team", teamDescription);
        requestInfo.put("profession", profession);
        requestInfo.put("employmentType", employmentType);
        requestInfo.put("rank", rank);
        requestInfo.put("payGrade", payGrade);
        requestInfo.put("salary", salary);
        requestInfo.put("rankFrom", employeeManager.getRankId());
        requestInfo.put("payGradefrom", employeeManager.getDrlPayGrade());
        requestInfo.put("salaryFrome", employeeManager.getSalary());
        requestInfo.put("professionFrome", employeeManager.getJobCode());
        requestInfo.put("promotionDate", txtPromotionDate.getValue().toString());
        requestInfo.put("title", title);
        requestInfo.put("titleFrome", employeeManager.getEmpTitle());
        requestInfo.put("promotionStatus", promotionStatus);

        return requestInfo;

    }

    private HashMap updatePromotionInformation() {
        String employeeId = null;
        String employmentType = "";
        String profession = "";
        String title = null;
        String rank = null;
        String payGrade = null;
        String salary = null;

        String currentDate = StringDateManipulation.toDayInEc();
        if (txtEmployeeID.getValue() != null) {
            employeeId = txtEmployeeID.getValue().toString();
        }
        if (drlZerf.getValue() != null) {
            zerfDescription = this.drlZerf.getValue().toString();

            if (this.drlDirectorate.getValue() != null) {
                directorateDescription = this.drlDirectorate.getValue().toString();
                if (this.drlDivision.getValue() != null) {                  //
                    divisionDescription = this.drlDivision.getValue().toString();
                    if (this.drlMastebaberia.getValue() != null) {
                        mastebaberiaDescription = this.drlMastebaberia.getValue().toString();
                        if (drlTeam.getValue() != null) {
                            teamDescription = this.drlTeam.getValue().toString();
//        }
                        }
                    }
                }
            }
        }
        if (drlProfession.getValue() != null) {
            profession = drlProfession.getValue().toString();
        }
        if (choCivil.isSelected()) {
            employmentType = "Civil";
        }
        if (choMilitary.isSelected()) {
            employmentType = "Miltery";
        }
        if (drlTitle.getValue() != null) {
            title = drlTitle.getValue().toString();
        }
        if (drlRankId.getValue() != null) {
            rank = drlRankId.getValue().toString();
        }
        if (drlPayGrade.getValue() != null) {
            payGrade = drlPayGrade.getValue().toString();
        }
        salary = lblSalary.getValue().toString();
        HashMap requestInfo = new HashMap();
        requestInfo.put("employeeId", employeeId);
        requestInfo.put("zerf", zerfDescription);
        requestInfo.put("directorate", directorateDescription);
        requestInfo.put("division", divisionDescription);
        requestInfo.put("mastebaberia", mastebaberiaDescription);
        requestInfo.put("team", teamDescription);
        requestInfo.put("profession", profession);
        requestInfo.put("employmentType", employmentType);
        requestInfo.put("rank", rank);
        requestInfo.put("payGrade", payGrade);
        requestInfo.put("salary", salary);
        requestInfo.put("title", title);
        requestInfo.put("promotioin_id", getPromotioin_id());
        return requestInfo;

    }

    public String btnPromote_action() {

        if (promotionManager.saveWithoutAdvertismentPromotion(promotionInformation())) {
            this.showSuccessOrFailureMessage(true, "Employee Promoted Successfully !!!");
            disabelPromotionComponets();
            clearPromotionComponets();
            btnCancel.setDisabled(true);
            btnUpdate.setDisabled(true);

            btnPromote.setDisabled(true);
        } else {
            showSuccessOrFailureMessage(false, "Error Occured While Saving Employee Promote. Please Try Agin?");

        }
        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        if (promotionManager.updateWithoutAdvertismentPromotion(updatePromotionInformation())) {
            this.showSuccessOrFailureMessage(true, "Employee Promotion Updated Successfully !!!");
            disabelPromotionComponets();
            clearPromotionComponets();
            btnCancel.setDisabled(true);
            btnUpdate.setDisabled(true);

            btnPromote.setDisabled(true);
        } else {
            showSuccessOrFailureMessage(false, "Error Occured While Updated Employee promotion. Please Try Agin?");

        }

        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {

            clearPromotionComponets();
            disabelPromotionComponets();

            loadEmployeeProfile(vce.getNewValue().toString());
            txtEmployeeID.setValue(vce.getNewValue().toString());
//            selectOneListboxPromotionRequestes.resetValue();
//            // listPromotingEmployee = promotionManager.employeePromoteList();
//
//
//            String date[] = vce.getNewValue().toString().split("----");
//            newPromotionResponsedApprove = recruitmentManager.newPromotionResponseAproveFilterdByDate(date[1].trim(), date[2].trim());
//            numberOfEmployeesPromoted = Integer.valueOf(date[3].trim());


        }
    }

    public void selectOneListbox1IndividualHistory_processValueChange(ValueChangeEvent vce) {

        if (vce.getNewValue() != null) {
            ResetComponents();
            try {
                HashMap listRequester = promotionManager.readPromotionHistory(vce.getNewValue().toString());
                if (listRequester != null) {
                    drlRankId.setValue(listRequester.get("rank"));
                    drlPayGrade.setValue(listRequester.get("payGrade"));
                    lblSalary.setValue(listRequester.get("salary"));
                    drlTitle.setValue(listRequester.get("title"));//
                    btnCancel.setDisabled(false);
                    btnUpdate.setDisabled(false);
                    txtPromotionDate.setValue(listRequester.get("PROMOTION_DATE"));
                    btnPromote.setDisabled(true);
                    setPromotioin_id(listRequester.get("promotionId").toString());

                }


            //}

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

    public String btnSearch_action() {
        //return null means stay on the same page
        clearPromotionComponets();
        disabelPromotionComponets();
        setQualifiedIndividualsBasedOnYear(null);
        if (choDisplayOnPage.isSelected()) {
            loadEmployeeProfile(txtEmployeeID.getValue().toString());
        }else{
             viewOnReport(txtEmployeeID.getValue().toString());
        }

        return null;
    }

    void viewOnReport(String employeeId) {
        try {
            String departmentDescription = null;
          
            String jasperLocation = "D:\\FEDERALREPORTS\\Promotion\\EmployeePromotionDetail.jasper";
            String reportName = "Employee Promotion";
            List employeePromotion = new ArrayList();
            ArrayList<HashMap> employeePromotionReportData = promotionManager.loadEmployeePromotionForReport(employeeId);
            HashMap param = new HashMap();
            for (HashMap hm : employeePromotionReportData) {//
                Map subMap = new HashMap();
                subMap.put("promotionDate", hm.get("promotion_Date"));
                subMap.put("rank", lookUpManager.readTitle(hm.get("rank_From").toString()));
                subMap.put("newRank", lookUpManager.readTitle(hm.get("rank_To").toString()));
                subMap.put("previousStep", hm.get("step_From"));
                subMap.put("newStep", hm.get("step_To"));
                subMap.put("priviousSalary", hm.get("salary_From"));
                subMap.put("newSalary", hm.get("salary_To"));
                subMap.put("previousTitle", lookUpManager.readTitle(hm.get("titlefrom").toString()));
                subMap.put("NewTitle", lookUpManager.readTitle(hm.get("titleto").toString()));
                employeePromotion.add(subMap);
            }
            employeeManager = new EmployeeManage();
            employeeManager.loadEmpoyeeProfile(employeeId);
            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
            try {
                setEmpImage(blo.getBytes(0, (int) blo.length()));

            } catch (Exception ex) {

                ex.printStackTrace();
            }
            loadEmployeePicture(getEmpImage());
            param.put("FIRST_NAME", "[ " + employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " ]");
            param.put("SEX", employeeManager.getSex());
            param.put("JOB_DESCRIPTION", employeeManager.getJobDescription());
            param.put("AVAILABLERANK", employeeManager.getDrlPayGrade());
            param.put("HIRE_DATE", employeeManager.getHire_Date());
            param.put("SALARY", employeeManager.getSalary());


            departmentDescription = departmentManage.traceDepartemnt(employeeManager.getDepartmentId());
            param.put("Department", departmentDescription);

            param.put("PHOTO", employeePicture.getImage());
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            ServletOutputStream servletOutputStream = null;
            servletOutputStream = response.getOutputStream();
//GenerateReport HttpServletRequest request, Map parameters, JRMapCollectionDataSource data)
            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, employeePromotion);

            servletOutputStream.flush();
            servletOutputStream.close();
            context.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadEmployeeProfile(String employeeId) {

        employeeManager.loadEmpoyeeProfile(employeeId);
        try {

            lblFullName.setValue("[ " + employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + "  " + employeeManager.getMiddle_Name() + "  " + employeeManager.getLast_Name() + " ]");
            lblOldSalary.setValue(employeeManager.getSalary());
            lblHireDate.setValue(employeeManager.getHire_Date());
            drlZerf.setValue(employeeManager.getDepartmentId());
            this.setPerofation(departmentManage.readJobCode(employeeManager.getDepartmentId()));
            String departemnt_ID = null;
            departemnt_ID = employeeManager.getDepartmentId();

                departemnt_ID = employeeManager.getDepartmentId();
                this.setPerofation(departmentManage.readJobCode(employeeManager.getDepartmentId()));

            drlProfession.setValue(employeeManager.getJobCode());
            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());

            try {
                setEmpImage(blo.getBytes(0, (int) blo.length()));
                imgMember.setValue(getEmpImage());

            } catch (Exception ex) {

                ex.printStackTrace();
            }
            lblJobPosition.setValue(employeeManager.getJobDescription());
            lblDepartmentDes.setValue(departmentManage.traceDepartemnt(departemnt_ID));

            this.setPayGradeOpt(lookUpManager.readPayGrade(employeeManager.getRankId()));
            if (employeeManager.getSex().equals("Female")) {
                choFemale.setSelected(true);
            }
            if (employeeManager.getSex().equals("Male")) {
                choMale.setSelected(true);
            }
            if (employeeManager.getOfficeOrshift().equals("Office")) {
                choCivil.setSelected(true);
                this.set_title(lookUpManager.assignTitle("Office"));
                this.set_jobRank(lookUpManager.assignJobRank("Office"));
            }
            if (employeeManager.getOfficeOrshift().equals("Shift")) {
                choMilitary.setSelected(true);
                this.set_title(lookUpManager.assignTitle("Shift"));
                this.set_jobRank(lookUpManager.assignJobRank("Shift"));

            }
            int expYear = employeeManager.calculateEmployeeServiceYear(employeeId);
            lblTotalServiceYear.setValue(String.valueOf(expYear));
            // drlPayGrade.setValue(employeeManager.getDrlPayGrade());
            //drlTitle.setValue(employeeManager.getEmpTitle());
            //drlRankId.setValue(employeeManager.getRankId());
            lblRankDescr.setValue(employeeManager.getRankeDscription());
            lblPayGrade.setValue(employeeManager.getDrlPayGrade());
            // lblSalary.setValue(employeeManager.getSalary());
            enabelPromotionComponets();
            btnPromote.setDisabled(false);
            btnUpdate.setDisabled(true);
            btnCancel.setDisabled(false);
            promotedIndividuals = promotionManager.employeePromoteList(employeeId);

        } catch (Exception ex) {
        }


    }

    void enabelPromotionComponets() {
        choMilitary.setDisabled(false);
        choCivil.setDisabled(false);
        drlTitle.setDisabled(false);
        drlRankId.setDisabled(false);
        drlPayGrade.setDisabled(false);
        lblSalary.setValue("");
        drlZerf.setDisabled(false);
        drlDirectorate.setDisabled(false);
        drlDivision.setDisabled(false);
        drlMastebaberia.setDisabled(false);
        drlTeam.setDisabled(false);
        drlProfession.setDisabled(false);
        txtPromotionDate.setDisabled(false);

    }

    void disabelPromotionComponets() {
        choMilitary.setDisabled(true);
        choCivil.setDisabled(true);
        drlTitle.setDisabled(true);
        drlRankId.setDisabled(true);
        drlPayGrade.setDisabled(true);
        lblSalary.setValue("");
        drlZerf.setDisabled(true);
        drlDirectorate.setDisabled(true);
        drlDivision.setDisabled(true);
        drlMastebaberia.setDisabled(true);
        drlTeam.setDisabled(true);
        drlProfession.setDisabled(true);
        txtPromotionDate.setDisabled(true);
    }

    void clearPromotionComponets() {
        choMilitary.setSelected(false);
        choCivil.setSelected(false);
        drlTitle.resetValue();
        drlRankId.resetValue();
        drlPayGrade.resetValue();
        lblSalary.setValue("");
        drlZerf.resetValue();
        drlDirectorate.resetValue();
        drlDivision.resetValue();
        drlMastebaberia.resetValue();
        drlProfession.resetValue();
        drlTeam.resetValue();

        lblFullName.setValue("");
        choMale.setSelected(false);
        choFemale.setSelected(false);
        lblDepartmentDes.setValue("");
        lblJobPosition.setValue("");
        lblHireDate.setValue("");
        lblTotalServiceYear.setValue("");
        lblRankDescr.setValue("");
        lblPayGrade.setValue("");
        lblOldSalary.setValue("");
        txtPromotionDate.setValue("");
//        imgMembe.
    }

    public void drlZerf_processValueChange(ValueChangeEvent vce) {

        try {
            if (vce.getNewValue() != null) {
//                this.setDirectorate(departmentManage.getZerfName(vce.getNewValue().toString()));
                this.setPerofation(departmentManage.readJobCode(vce.getNewValue().toString()));
//                setDevision(null);
//                setMastebaberi(null);
//                setTeam(null);
            // drlDivision.resetValue();
//                drlMastebaberia.resetValue();
//                drlTeam.resetValue();


            } else {
//                drlDirectorate.resetValue();
//                drlDivision.resetValue();
//                drlMastebaberia.resetValue();
//                drlTeam.resetValue();

                this.setPerofation(departmentManage.onDisplayJob());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void drlDirectorate_processValueChange(ValueChangeEvent vce) {

        try {
            if (vce.getNewValue() != null) {

                this.setPerofation(departmentManage.readJobCode(vce.getNewValue().toString()));
//                this.setDevision(departmentManage.getZerfName(vce.getNewValue().toString()));

//                drlMastebaberia.resetValue();
//                drlTeam.resetValue();

            } else {

//                drlDivision.resetValue();
//                drlMastebaberia.resetValue();
//                drlTeam.resetValue();;
                //this.set_job(departmentManage.onDisplayJob());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void drlDivision_processValueChange(ValueChangeEvent vce) {

        try {
            if (vce.getNewValue() != null) {
                this.setPerofation(departmentManage.readJobCode(vce.getNewValue().toString()));
//                this.setMastebaberi(departmentManage.getZerfName(vce.getNewValue().toString()));


//                drlTeam.resetValue();

            } else {

//                drlMastebaberia.resetValue();
//                drlTeam.resetValue();
                //this.set_job(departmentManage.onDisplayJob());
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    public void drlMastebaberia_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {

                this.setPerofation(departmentManage.readJobCode(vce.getNewValue().toString()));
//                this.setTeam(departmentManage.getZerfName(vce.getNewValue().toString()));


            } else {
//                setMastebaberi(null);
//                setTeam(null);
                //this.set_job(departmentManage.onDisplayJob());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void drlTeam_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {

                this.setPerofation(departmentManage.readJobCode(vce.getNewValue().toString()));
            } else {
                //   this.set_job(departmentManage.onDisplayJob());
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void choMilitary_processValueChange(ValueChangeEvent vce) {
        this.set_title(lookUpManager.assignTitle("military"));
        this.set_jobRank(lookUpManager.assignJobRank("Military"));
        choCivil.setSelected(false);
    }

    public void choCivil_processValueChange(ValueChangeEvent vce) {
        this.set_title(lookUpManager.assignTitle("civil"));
        _jobRank = lookUpManager.assignJobRank("Civil");
        choMilitary.setSelected(false);
    }

    public void drlRankId_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                this.setPayGradeOpt(lookUpManager.readPayGrade(vce.getNewValue().toString()));
            }
        } catch (Exception ex) {
        }
    }

    public void drlPayGrade_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            try {
                lblSalary.setValue(lookUpManager.readSalary(drlRankId.getValue().toString(), drlPayGrade.getValue().toString()));

            } catch (Exception e) {
            }


        }
    }

    public String btnCancel_action() {
        //return null means stay on the same page
        disabelPromotionComponets();
        clearPromotionComponets();
        return null;
    }

    public String btnDemote_action() {
        //return null means stay on the same page
        return null;
    }

    public void choPerformance_processValueChange(ValueChangeEvent vce) {
        if (choPerformance.isSelected() == true) {
//            evaResultPopUpMsg.setRendered(true);
            this.selectOneMenuSelectSessionIn.setDisabled(false);
        } else {
//            evaResultPopUpMsg.setRendered(false);
            this.selectOneMenuSelectSessionIn.setDisabled(true);
        }
    }

    public String btnCancel1_action() {
        evaResultPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnOK_action() {
        //return null means stay on the same page
        evaResultPopUpMsg.setRendered(false);
        evaResultPopUpMsg.setRendered(false);
        SessionID = selectOneMenu1evaResultPopUpMsg.getValue().toString();
        return null;
    }

    public String button3_action() {
        //return null means stay on the same page
        return null;
    }

    public String buttonSelectCSEmp_action() {
        if (this.selectBooleanCheckbox1TotalService1.isSelected() && this.selectBooleanCheckboxIncProWith.isSelected() &&
                !this.choPerformance.isSelected() && !selectBooleanCheckboxDicipCrit.isSelected()) {
            if (!inputTextPOPTotalS.getValue().equals("") && !inputTextPromoteFrequency.getValue().equals("") && !inputTextPOPIncPromWith.getValue().equals("")) {
                if (numberFormatChecker(inputTextPOPTotalS.getValue().toString()).equals("match")) {
                    if (numberFormatChecker(inputTextPromoteFrequency.getValue().toString()).equals("match")) {
                        if (numberFormatChecker(inputTextPOPIncPromWith.getValue().toString()).equals("match")) {
                            this.qualifiedIndividualsBasedOnYear = null;
                            qualifiedIndividualsBasedOnYear = promotionManager.qulifiedIndividualsForPromo(inputTextPOPTotalS.getValue().toString(), inputTextPromoteFrequency.getValue().toString(), inputTextPOPIncPromWith.getValue().toString(), "1");
                            this.panelPopup1.setRendered(false);
                        } else {
                            this.showSuccessOrFailureMessage(false, " Promotion with in year is not valid number.");
                        }
                    } else {
                        this.showSuccessOrFailureMessage(false, " Employees Promoted is not valid number.");
                    }
                } else {
                    this.showSuccessOrFailureMessage(false, " Total Service is not valid number.");
                }

            }
        } else if (!this.selectBooleanCheckbox1TotalService1.isSelected() && this.selectBooleanCheckboxIncProWith.isSelected() &&
                this.choPerformance.isSelected() && !selectBooleanCheckboxDicipCrit.isSelected()) {
            if (!inputTextPOPPerformance.getValue().equals("") && !sessionID.equals("") && !inputTextPOPIncPromWith.getValue().equals("") && !inputTextPromoteFrequency.getValue().equals("")) {
                this.qualifiedIndividualsBasedOnYear = null;
                qualifiedIndividualsBasedOnYear = promotionManager.qulifiedIndividualsForPromo(inputTextPromoteFrequency.getValue().toString(),
                        inputTextPOPIncPromWith.getValue().toString(), inputTextPOPPerformance.getValue().toString(),
                        sessionID, "1");
                this.panelPopup1.setRendered(false);
            }
        } else if (!this.selectBooleanCheckbox1TotalService1.isSelected() && this.selectBooleanCheckboxIncProWith.isSelected() &&
                !this.choPerformance.isSelected() && selectBooleanCheckboxDicipCrit.isSelected()) {
            if (!inputTextPromoteFrequency.getValue().equals("") && !inputTextPOPIncPromWith.getValue().equals("") && !inputTextDicipCri.getValue().equals("")) {
                this.qualifiedIndividualsBasedOnYear = null;
                qualifiedIndividualsBasedOnYear = promotionManager.qulifiedIndividualsForPromo(inputTextPromoteFrequency.getValue().toString(), inputTextPOPIncPromWith.getValue().toString(),
                        inputTextDicipCri.getValue().toString(),
                        "0");
                this.panelPopup1.setRendered(false);
            }
        } else if (this.selectBooleanCheckbox1TotalService1.isSelected() && this.selectBooleanCheckboxIncProWith.isSelected() &&
                this.choPerformance.isSelected() && !selectBooleanCheckboxDicipCrit.isSelected()) {
            if (!inputTextPOPPerformance.getValue().equals("") && !sessionID.equals("") && !inputTextPOPTotalS.getValue().equals("") &&
                    !inputTextPromoteFrequency.getValue().equals("") && !inputTextPOPIncPromWith.getValue().equals("")) {
                this.qualifiedIndividualsBasedOnYear = null;
                qualifiedIndividualsBasedOnYear = promotionManager.qulifiedIndividualsForPromo(inputTextPOPTotalS.getValue().toString(),
                        inputTextPromoteFrequency.getValue().toString(), inputTextPOPIncPromWith.getValue().toString(),
                        inputTextPOPPerformance.getValue().toString(), sessionID,
                        "1");
                this.panelPopup1.setRendered(false);
            }
        } else if (this.selectBooleanCheckbox1TotalService1.isSelected() && this.selectBooleanCheckboxIncProWith.isSelected() &&
                !this.choPerformance.isSelected() && selectBooleanCheckboxDicipCrit.isSelected()) {
            if (!inputTextPOPTotalS.getValue().equals("") &&
                    !inputTextPromoteFrequency.getValue().equals("") && !inputTextPOPIncPromWith.getValue().equals("") && !inputTextDicipCri.getValue().equals("")) {
                this.qualifiedIndividualsBasedOnYear = null;
                qualifiedIndividualsBasedOnYear = promotionManager.qulifiedIndividualsForPromo(inputTextPOPTotalS.getValue().toString(),
                        inputTextPromoteFrequency.getValue().toString(), inputTextPOPIncPromWith.getValue().toString(),
                        inputTextDicipCri.getValue().toString(),
                        "0");
                this.panelPopup1.setRendered(false);
            }
        } else if (!this.selectBooleanCheckbox1TotalService1.isSelected() && this.selectBooleanCheckboxIncProWith.isSelected() &&
                this.choPerformance.isSelected() && selectBooleanCheckboxDicipCrit.isSelected()) {
            if (!inputTextPOPPerformance.getValue().equals("") && !sessionID.equals("") &&
                    !inputTextPromoteFrequency.getValue().equals("") && !inputTextPOPIncPromWith.getValue().equals("") && !inputTextDicipCri.getValue().equals("")) {
                this.qualifiedIndividualsBasedOnYear = null;
                qualifiedIndividualsBasedOnYear = promotionManager.qulifiedIndividualsForPromo(inputTextPromoteFrequency.getValue().toString(),
                        inputTextPOPIncPromWith.getValue().toString(),
                        inputTextPOPPerformance.getValue().toString(), sessionID, inputTextDicipCri.getValue().toString(),
                        "0");
                this.panelPopup1.setRendered(false);
            }
        } else if (this.selectBooleanCheckbox1TotalService1.isSelected() && this.selectBooleanCheckboxIncProWith.isSelected() &&
                this.choPerformance.isSelected() && selectBooleanCheckboxDicipCrit.isSelected()) {
            if (!inputTextPOPPerformance.getValue().equals("") && !sessionID.equals("") && !inputTextPOPTotalS.getValue().equals("") &&
                    !inputTextPromoteFrequency.getValue().equals("") && !inputTextPOPIncPromWith.getValue().equals("") && !inputTextDicipCri.getValue().equals("")) {
                this.qualifiedIndividualsBasedOnYear = null;
                qualifiedIndividualsBasedOnYear = promotionManager.qulifiedIndividualsForPromo(inputTextPOPTotalS.getValue().toString(),
                        inputTextPromoteFrequency.getValue().toString(), inputTextPOPIncPromWith.getValue().toString(),
                        inputTextPOPPerformance.getValue().toString(), sessionID, inputTextDicipCri.getValue().toString(),
                        "1");
                this.panelPopup1.setRendered(false);
            }
        }
        //return null means stay on the same page
        return null;
    }

    public void selectOneMenuSelectSessionIn_processValueChange(ValueChangeEvent vce) {
        sessionID = vce.getNewValue().toString();
    }

    public String buttonDisplayCriteria_action() {
        this.panelPopup1.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnReport_action() {
        if (getPromotioin_id() != null) {
            HashMap param = new HashMap();
            String jasperLocation = "D:\\FEDERALREPORTS\\Employee\\EmployeePromotion.jasper";
            String reportName = "Resign";
            Collection data = promotionManager.promotionReport(getPromotioin_id());
            //null;//terminationManager.resignReport(employeeId);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            ServletOutputStream servletOutputStream = null;
            try {
                servletOutputStream = response.getOutputStream();

                employeeManage = new EmployeeManage();
                employeeManage.loadEmpoyeeProfile(txtEmployeeID.getValue().toString());
                try {
                    OracleSerialBlob blo = (OracleSerialBlob) (employeeManage.getPhotobinary());
                    setBytEmployeePicture(blo.getBytes(0, (int) blo.length()));
                    loadEmployeePicture(getBytEmployeePicture());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                param.put("PHOTO", employeePicture.getImage());
                LoadLOGO();
                param.put("LOGO", LOGO.getImage());
                reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                servletOutputStream.flush();
                servletOutputStream.close();
                // Stop resend
                FacesContext.getCurrentInstance().responseComplete();

            } catch (Exception ex) {
                // ex.printStackTrace();
                //  ErrorLogWriter.writeError(ex);
            }
        }
        //return null means stay on the same page
        return null;
    }

    public void loadEmployeePicture(byte[] employeePicture) {
        try {
            if (employeePicture != null) {
                this.employeePicture = new ImageIcon((byte[]) employeePicture);
            } else {
                this.employeePicture = new ImageIcon();
            }
        } catch (Exception ex) {
        }

    }

    public void LoadLOGO() {
//        List data = null;
//        ReportManager manager1 = new ReportManager();
//        data = manager1.loadCompanyLogo();
//        ListIterator<ReportManager> lstmb = data.listIterator();
//        try {
//            while (lstmb.hasNext()) {
//                ReportManager mag = lstmb.next();
//                if (mag.getFPLOGO() != null) {
//                    LOGO = new ImageIcon((byte[]) mag.getFPLOGO());
//                } else {
//                    LOGO = new ImageIcon();
//                }
//            }
//        } catch (Exception ex) {
//        }

    }

    public void choDisplayOnPage_processValueChange(ValueChangeEvent vce) {
        choPrivewOnReport.setSelected(false);
    }

    public void choPrivewOnReport_processValueChange(ValueChangeEvent vce) {
        choDisplayOnPage.setSelected(false);
    }
}

