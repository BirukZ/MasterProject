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
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
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
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeHistoryManager.PromotionManager;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.StringDateManipulation;
import manager.promotionManager.PromotionRequestManager;
import manager.promotionManager.PromotionRequestManager.EmployeeExperienceHistroyModel;
import manager.recruitmentManager.RecruitmentManager;
import manager.recruitmentManager.VacancyNoticeListManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class RequestForPromotion extends AbstractPageBean {

    VacancyNoticeListManager vacancyNoticeListManager = new VacancyNoticeListManager();
    AdvertisementManager advertisementManager = new AdvertisementManager();
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    public List vacancyList = new ArrayList<AdvertisementManager>();
    private ArrayList<AdvertisementManager> requestersForPromotion = new ArrayList<AdvertisementManager>();
    public List vacancyListRequestPromo = new ArrayList<VacancyNoticeListManager>();
    private PanelPopup pnMessage = new PanelPopup();
    private Option[] newPromotionRequestsDates = recruitmentManager.newPromotionRequestsDates();
    PromotionRequestManager promotionRequestManager = new PromotionRequestManager();
    CommitteeRegistrationManager committeeRegistrationManager = new CommitteeRegistrationManager();
    ArrayList<SelectItem> committeeList = committeeRegistrationManager.getAllActiveCommitteesSelectItem();
    ArrayList<SelectItem> committeeType = committeeRegistrationManager.getCommitteeTypes();
    ArrayList<CommitteeMemberModel> committeeMemberLists = new ArrayList<CommitteeMemberModel>();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    private ArrayList<EmployeeExperienceHistroyModel> empExperienceModel = new ArrayList<EmployeeExperienceHistroyModel>();
    int committeeId;
    private Option[] newPromotionRequests;
    private Option[] newPromotionResponse;
    private Option[] newPromotionRequestsFilterdByDate;
    EvaluationResultManager evaResultManObject = new EvaluationResultManager();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Option[] toFilterResultUsingSession;
    private int selectedPromotionRequester = -1;
    private ArrayList<SelectItem> bachCode = new ArrayList<SelectItem>();
    String rank_id;
    String advertId;
    String requester_ID = null;
    String SessionID = "";
    String batchCodePrecentage;
    private int proRequestId = 0;
    private int promotionAssessmentId = 0;
    private PromotionManager promotionManager = new PromotionManager();
    private int totalPersentage = 0;
    private String bach_Code = null;
    boolean checkPercentage = false;
    boolean checkFromSelect = false;
    private ArrayList<AdvertisementManager> resultListData = new ArrayList<AdvertisementManager>();

    public ArrayList<AdvertisementManager> getResultListData() {
        return resultListData;
    }

    public void setResultListData(ArrayList<AdvertisementManager> resultListData) {
        this.resultListData = resultListData;
    }

    public ArrayList<SelectItem> getBachCode() {
        return bachCode;
    }

    public void setBachCode(ArrayList<SelectItem> bachCode) {
        this.bachCode = bachCode;
    }

    public Option[] getNewPromotionResponse() {
        return newPromotionResponse;
    }

    public void setNewPromotionResponse(Option[] newPromotionResponse) {
        this.newPromotionResponse = newPromotionResponse;
    }

    public Option[] getNewPromotionRequestsFilterdByDate() {
        return newPromotionRequestsFilterdByDate;
    }

    public void setNewPromotionRequestsFilterdByDate(Option[] newPromotionRequestsFilterdByDate) {
        this.newPromotionRequestsFilterdByDate = newPromotionRequestsFilterdByDate;
    }

    public Option[] getNewPromotionRequestsDates() {
        return newPromotionRequestsDates;
    }

    public void setNewPromotionRequestsDates(Option[] newPromotionRequestsDates) {
        this.newPromotionRequestsDates = newPromotionRequestsDates;
    }

    public Option[] getToFilterResultUsingSession() {
        return toFilterResultUsingSession;
    }

    public void setToFilterResultUsingSession(Option[] toFilterResultUsingSession) {
        this.toFilterResultUsingSession = toFilterResultUsingSession;
    }

    public ArrayList<AdvertisementManager> getRequestersForPromotion() {
        return requestersForPromotion;
    }

    public void setRequestersForPromotion(ArrayList<AdvertisementManager> requestersForPromotion) {
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
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
//         setBachCode(recruitmentManager.readInsideRecriutmentBachCode());
    }
    private PanelPopup pnlPopupViewEmployees_History = new PanelPopup();

    public PanelPopup getPnlPopupViewEmployees_History() {
        return pnlPopupViewEmployees_History;
    }
    private HtmlSelectBooleanCheckbox cboMakeEmployee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboMakeEmployee() {
        return cboMakeEmployee;
    }

    public void setCboMakeEmployee(HtmlSelectBooleanCheckbox hsbc) {
        this.cboMakeEmployee = hsbc;
    }

    public void setPnlPopupViewEmployees_History(PanelPopup pp) {
        this.pnlPopupViewEmployees_History = pp;
    }
    private PanelLayout pnlLayoutCommitteeMember = new PanelLayout();

    public PanelLayout getPnlLayoutCommitteeMember() {
        return pnlLayoutCommitteeMember;
    }

    public void setPnlLayoutCommitteeMember(PanelLayout pl) {
        this.pnlLayoutCommitteeMember = pl;
    }
    private HtmlSelectOneMenu drlCommittee = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommittee() {
        return drlCommittee;
    }

    public void setDrlCommittee(HtmlSelectOneMenu hsom) {
        this.drlCommittee = hsom;
    }
    private DefaultSelectedData selectedObjectCommittee = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommittee() {
        return selectedObjectCommittee;
    }

    public void setSelectedObjectCommittee(DefaultSelectedData selectedObjectCommittee) {
        this.selectedObjectCommittee = selectedObjectCommittee;
    }

    public ArrayList<SelectItem> getCommitteeList() {
        return committeeList;
    }

    public void setCommitteeList(ArrayList<SelectItem> committeeList) {
        this.committeeList = committeeList;
    }
    private HtmlSelectOneMenu drlCommitteeType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommitteeType() {
        return drlCommitteeType;
    }

    public void setDrlCommitteeType(HtmlSelectOneMenu hsom) {
        this.drlCommitteeType = hsom;
    }
    private DefaultSelectedData selectedObjectCommitteeType = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommitteeType() {
        return selectedObjectCommitteeType;
    }

    public void setSelectedObjectCommitteeType(DefaultSelectedData selectedObjectCommitteeType) {
        this.selectedObjectCommitteeType = selectedObjectCommitteeType;
    }

    public ArrayList<SelectItem> getCommitteeType() {
        return committeeType;
    }

    public void setCommitteeType(ArrayList<SelectItem> committeeType) {
        this.committeeType = committeeType;
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
    private HtmlCommandButton btnRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnRequest() {
        return btnRequest;
    }

    public void setBtnRequest(HtmlCommandButton hcb) {
        this.btnRequest = hcb;
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
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkExameResult = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkExameResult() {
        return chkExameResult;
    }

    public void setChkExameResult(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkExameResult = hsbc;
    }
    private PanelLayout PanelLayOutInsidVacancyListRequester = new PanelLayout();

    public PanelLayout getPanelLayOutInsidVacancyListRequester() {
        return PanelLayOutInsidVacancyListRequester;
    }

    public void setPanelLayOutInsidVacancyListRequester(PanelLayout pl) {
        this.PanelLayOutInsidVacancyListRequester = pl;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkPerformance = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkPerformance() {
        return chkPerformance;
    }

    public void setChkPerformance(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkPerformance = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox chkDiscipline = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getChkDiscipline() {
        return chkDiscipline;
    }

    public void setChkDiscipline(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.chkDiscipline = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox selectBooleanCheckbox4Training = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getSelectBooleanCheckbox4Training() {
        return selectBooleanCheckbox4Training;
    }

    public void setSelectBooleanCheckbox4Training(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox4Training = hsbc;
    }
    private HtmlInputText txtExameResult = new HtmlInputText();

    public HtmlInputText getTxtExameResult() {
        return txtExameResult;
    }

    public void setTxtExameResult(HtmlInputText hit) {
        this.txtExameResult = hit;
    }
    private HtmlInputText txtPerformance = new HtmlInputText();

    public HtmlInputText getTxtPerformance() {
        return txtPerformance;
    }

    public void setTxtPerformance(HtmlInputText hit) {
        this.txtPerformance = hit;
    }
    private HtmlInputText inputText1Training = new HtmlInputText();

    public HtmlInputText getInputText1Training() {
        return inputText1Training;
    }

    public void setInputText1Training(HtmlInputText hit) {
        this.inputText1Training = hit;
    }
    private HtmlInputText txtDiscipline = new HtmlInputText();

    public HtmlInputText getTxtDiscipline() {
        return txtDiscipline;
    }

    public void setTxtDiscipline(HtmlInputText hit) {
        this.txtDiscipline = hit;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
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
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
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
    private HtmlSelectOneListbox selectOneListboxSelectDate1 = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListboxSelectDate1() {
        return selectOneListboxSelectDate1;
    }

    public void setSelectOneListboxSelectDate1(HtmlSelectOneListbox hsol) {
        this.selectOneListboxSelectDate1 = hsol;
    }
    private HtmlCommandButton buttonViewAll = new HtmlCommandButton();

    public HtmlCommandButton getButtonViewAll() {
        return buttonViewAll;
    }

    public void setButtonViewAll(HtmlCommandButton hcb) {
        this.buttonViewAll = hcb;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlCommandButton buttonViewAllR = new HtmlCommandButton();

    public HtmlCommandButton getButtonViewAllR() {
        return buttonViewAllR;
    }

    public void setButtonViewAllR(HtmlCommandButton hcb) {
        this.buttonViewAllR = hcb;
    }
    private HtmlSelectOneListbox selectOneListbox1Response = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1Response() {
        return selectOneListbox1Response;
    }

    public void setSelectOneListbox1Response(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1Response = hsol;
    }
    private HtmlOutputText lblStatusValue = new HtmlOutputText();

    public HtmlOutputText getLblStatusValue() {
        return lblStatusValue;
    }

    public void setLblStatusValue(HtmlOutputText hot) {
        this.lblStatusValue = hot;
    }
    private PanelPopup popupPromotionAssessmentResult = new PanelPopup();

    public PanelPopup getPopupPromotionAssessmentResult() {
        return popupPromotionAssessmentResult;
    }

    public void setPopupPromotionAssessmentResult(PanelPopup pp) {
        this.popupPromotionAssessmentResult = pp;
    }
    private RowSelector rowSelectorPromotionRequester = new RowSelector();

    public RowSelector getRowSelectorPromotionRequester() {
        return rowSelectorPromotionRequester;
    }

    public void setRowSelectorPromotionRequester(RowSelector rs) {
        this.rowSelectorPromotionRequester = rs;
    }
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private PanelPopup pnDegreeOfAss = new PanelPopup();

    public PanelPopup getPnDegreeOfAss() {
        return pnDegreeOfAss;
    }

    public void setPnDegreeOfAss(PanelPopup pp) {
        this.pnDegreeOfAss = pp;
    }
    private HtmlInputText txtWrittenPercentage = new HtmlInputText();

    public HtmlInputText getTxtWrittenPercentage() {
        return txtWrittenPercentage;
    }

    public void setTxtWrittenPercentage(HtmlInputText hit) {
        this.txtWrittenPercentage = hit;
    }
    private HtmlInputText txtInterviewPercentage = new HtmlInputText();

    public HtmlInputText getTxtInterviewPercentage() {
        return txtInterviewPercentage;
    }

    public void setTxtInterviewPercentage(HtmlInputText hit) {
        this.txtInterviewPercentage = hit;
    }
    private HtmlInputText txtPresentaionPercentage = new HtmlInputText();

    public HtmlInputText getTxtPresentaionPercentage() {
        return txtPresentaionPercentage;
    }

    public void setTxtPresentaionPercentage(HtmlInputText hit) {
        this.txtPresentaionPercentage = hit;
    }
    private HtmlInputText txtOtherPercentage = new HtmlInputText();

    public HtmlInputText getTxtOtherPercentage() {
        return txtOtherPercentage;
    }

    public void setTxtOtherPercentage(HtmlInputText hit) {
        this.txtOtherPercentage = hit;
    }
    private HtmlSelectOneMenu ddnBatchCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnBatchCode() {
        return ddnBatchCode;
    }

    public void setDdnBatchCode(HtmlSelectOneMenu hsom) {
        this.ddnBatchCode = hsom;
    }
    private HtmlCommandButton btnSavePercentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnSavePercentage() {
        return btnSavePercentage;
    }

    public void setBtnSavePercentage(HtmlCommandButton hcb) {
        this.btnSavePercentage = hcb;
    }
    private HtmlCommandButton btnEditPercentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditPercentage() {
        return btnEditPercentage;
    }

    public void setBtnEditPercentage(HtmlCommandButton hcb) {
        this.btnEditPercentage = hcb;
    }
    private HtmlCommandButton btnUpdatePercentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdatePercentage() {
        return btnUpdatePercentage;
    }

    public void setBtnUpdatePercentage(HtmlCommandButton hcb) {
        this.btnUpdatePercentage = hcb;
    }
    private HtmlCommandButton btnDeletePercentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeletePercentage() {
        return btnDeletePercentage;
    }

    public void setBtnDeletePercentage(HtmlCommandButton hcb) {
        this.btnDeletePercentage = hcb;
    }
    private HtmlInputText txtInterviewResult = new HtmlInputText();

    public HtmlInputText getTxtInterviewResult() {
        return txtInterviewResult;
    }

    public void setTxtInterviewResult(HtmlInputText hit) {
        this.txtInterviewResult = hit;
    }
    private HtmlInputText txtWrittenResult = new HtmlInputText();

    public HtmlInputText getTxtWrittenResult() {
        return txtWrittenResult;
    }

    public void setTxtWrittenResult(HtmlInputText hit) {
        this.txtWrittenResult = hit;
    }
    private HtmlInputText txtPresentationResult = new HtmlInputText();

    public HtmlInputText getTxtPresentationResult() {
        return txtPresentationResult;
    }

    public void setTxtPresentationResult(HtmlInputText hit) {
        this.txtPresentationResult = hit;
    }
    private HtmlInputText txtOtherResult = new HtmlInputText();

    public HtmlInputText getTxtOtherResult() {
        return txtOtherResult;
    }

    public void setTxtOtherResult(HtmlInputText hit) {
        this.txtOtherResult = hit;
    }
    private HtmlInputTextarea txtRec = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRec() {
        return txtRec;
    }

    public void setTxtRec(HtmlInputTextarea hit) {
        this.txtRec = hit;
    }
    private HtmlInputTextarea txtRem = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRem() {
        return txtRem;
    }

    public void setTxtRem(HtmlInputTextarea hit) {
        this.txtRem = hit;
    }
    private HtmlCommandButton btnSaveAssessmentResult = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveAssessmentResult() {
        return btnSaveAssessmentResult;
    }

    public void setBtnSaveAssessmentResult(HtmlCommandButton hcb) {
        this.btnSaveAssessmentResult = hcb;
    }
    private HtmlCommandButton btnEditAssessmentResult = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditAssessmentResult() {
        return btnEditAssessmentResult;
    }

    public void setBtnEditAssessmentResult(HtmlCommandButton hcb) {
        this.btnEditAssessmentResult = hcb;
    }
    private HtmlCommandButton btnUpdateAssessmentResult = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateAssessmentResult() {
        return btnUpdateAssessmentResult;
    }

    public void setBtnUpdateAssessmentResult(HtmlCommandButton hcb) {
        this.btnUpdateAssessmentResult = hcb;
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
    private PanelPopup pnpExperience = new PanelPopup();

    public PanelPopup getPnpExperience() {
        return pnpExperience;
    }

    public void setPnpExperience(PanelPopup pp) {
        this.pnpExperience = pp;
    }
    private HtmlDataTable dataTableEmpHistory = new HtmlDataTable();

    public HtmlDataTable getDataTableEmpHistory() {
        return dataTableEmpHistory;
    }

    public void setDataTableEmpHistory(HtmlDataTable hdt) {
        this.dataTableEmpHistory = hdt;
    }

    /**
     * @return the empExperienceModel
     */
    public ArrayList<EmployeeExperienceHistroyModel> getEmpExperienceModel() {
        return empExperienceModel;
    }

    /**
     * @param empExperienceModel the empExperienceModel to set
     */
    public void setEmpExperienceModel(ArrayList<EmployeeExperienceHistroyModel> empExperienceModel) {
        this.empExperienceModel = empExperienceModel;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RequestForPromotion() {
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
        this.toFilterResultUsingSession = evaResultManObject.readAllSessionsResultsGivenToPromotion();
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
        chkExameResult.setDisabled(false);
        chkPerformance.setDisabled(false);
        chkDiscipline.setDisabled(false);
        selectBooleanCheckbox4Training.setDisabled(false);
        txtExameResult.setDisabled(false);
        txtPerformance.setDisabled(false);
        txtDiscipline.setDisabled(false);
        inputText1Training.setDisabled(false);

    }

    public void disableEvaluationComponents() {
        chkExameResult.setDisabled(true);
        chkPerformance.setDisabled(true);
        chkDiscipline.setDisabled(true);
        selectBooleanCheckbox4Training.setDisabled(true);
        txtExameResult.setDisabled(true);
        txtPerformance.setDisabled(true);
        txtDiscipline.setDisabled(true);
        inputText1Training.setDisabled(true);

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

    public void showSuccessOrFailureMessageForZindex(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setStyle("border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;z-index:10000;");
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

    private int compareTwoYears(String year) {
        String currDate = dateFormat.format(new Date());
        int dateDiffrence = StringDateManipulation.calculateYearDifferenceBetweenTwoDates(year, currDate);
        return dateDiffrence;
    }

    private boolean checkPercentValidity(String val1, String val2) {
        int value1 = Integer.valueOf(val1);
        int value2 = Integer.valueOf(val2);
        if ((value1 + value2) == 100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPercentValidity(String val1) {
        int value1 = Integer.valueOf(val1);
        if ((value1) == 100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPercentValidity(String val1, String val2, String val3) {
        double value1 = Double.valueOf(val1);
        double value2 = Double.valueOf(val2);
        double value3 = Double.valueOf(val3);
        if ((value1 + value2 + value3) == 100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPercentValidity(String val1, String val2, String val3, String val4) {
        double value1 = Double.valueOf(val1);
        double value2 = Double.valueOf(val2);
        double value3 = Double.valueOf(val3);
        double value4 = Double.valueOf(val4);
        if ((value1 + value2 + value3 + value4) == 100) {
            return true;
        } else {
            return false;
        }
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

    public void populateTableTotalServiceYear() {
        if (inputTextAdvertID.getValue() != null && chkExameResult.isSelected()) {

            try {
                this.requestersForPromotion.clear();
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterTotalServiceYear(inputTextAdvertID.getValue().toString());
                if (listRequester.length > 0) {
                    int largestYear = compareTwoYears(listRequester[0].get("HIRE_DATE").toString());
                    for (int i = 0; i < listRequester.length; i++) {
                        AdvertisementManager addToTable = new AdvertisementManager(
                                listRequester[i].get("EMP_ID").toString(),
                                listRequester[i].get("FIRST_NAME").toString() +
                                " " + listRequester[i].get("MIDDLE_NAME").toString() +
                                " " + listRequester[i].get("LAST_NAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("EDUCATION_TYPE").toString(),
                                listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("EDUC_LEVEL_DISC").toString(),
                                listRequester[i].get("EDUC_TYPE_DISC").toString(),
                                0, largestYear);

                        this.requestersForPromotion.add(addToTable);

                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void populateTableEducationLevel() {
        if (inputTextAdvertID.getValue() != null && chkDiscipline.isSelected()) {

            try {
                this.requestersForPromotion.clear();
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterEducationLevel(inputTextAdvertID.getValue().toString());

                if (listRequester.length > 0) {

                    for (int i = 0; i < listRequester.length; i++) {
                        AdvertisementManager addToTable = new AdvertisementManager(listRequester[i].get("EMP_ID").toString(), listRequester[i].get("FIRST_NAME").toString() +
                                " " + listRequester[i].get("MIDDLE_NAME").toString() +
                                " " + listRequester[i].get("LAST_NAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("EDUCATION_TYPE").toString(), listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("EDUC_LEVEL_DISC").toString(),
                                listRequester[i].get("EDUC_TYPE_DISC").toString(), 0, 0);

                        this.requestersForPromotion.add(addToTable);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void populateTableBasedOnPerformance() {
        HashMap[] evaSessionResultList = null;
        double maxAverage = 0.0;
        double sum = 0.0;
        double average = 0.0;
        double averageC[] = null;

        if (inputTextAdvertID.getValue() != null) {

            try {
                this.requestersForPromotion.clear();
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterBasedOnPerformance(inputTextAdvertID.getValue().toString());


                if (listRequester.length > 0) {
                    averageC = new double[listRequester.length];

                    for (int i = 0; i < listRequester.length; i++) {

                        evaSessionResultList = evaResultManObject.readEvaSessionResultComplainTblSingle(SessionID, listRequester[i].get("EMP_ID").toString());
                        if (evaSessionResultList.length > 0) {

                            sum = 0.0;
                            average = 0.0;
                            for (int j = 0; j < evaSessionResultList.length; j++) {
                                sum = sum + Double.valueOf(evaSessionResultList[j].get("RESULT").toString());
                            }
                            average = (sum / evaSessionResultList.length);
                            averageC[i] = average;
                            if (average > maxAverage) {
                                maxAverage = average;
                            }
                        }
                    }


                    for (int i = 0; i < listRequester.length; i++) {
                        AdvertisementManager addToTable = new AdvertisementManager(listRequester[i].get("EMP_ID").toString(), listRequester[i].get("FIRST_NAME").toString() +
                                " " + listRequester[i].get("MIDDLE_NAME").toString() +
                                " " + listRequester[i].get("LAST_NAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("EDUCATION_TYPE").toString(), listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("EDUC_LEVEL_DISC").toString(),
                                listRequester[i].get("EDUC_TYPE_DISC").toString(),
                                maxAverage, sum, averageC[i], "x");

                        this.requestersForPromotion.add(addToTable);

                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void populateTableEducationLevelExp(double percent1, double percent2) {
        if (inputTextAdvertID.getValue() != null && chkDiscipline.isSelected()) {

            try {
                this.requestersForPromotion.clear();
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterEducationLevel(inputTextAdvertID.getValue().toString());

                if (listRequester.length > 0) {
                    int largestYear = -1;
                    int educLevelRank = 0;

                    for (int i = 0; i < listRequester.length; i++) {
                        int tempYear = compareTwoYears(listRequester[i].get("HIRE_DATE").toString());
                        if (tempYear > largestYear) {
                            largestYear = tempYear;
                        }
                    }

                    for (int i = 0; i < listRequester.length; i++) {
                        educLevelRank = Integer.valueOf(listRequester[0].get("RANK").toString());

                        AdvertisementManager addToTable = new AdvertisementManager(listRequester[i].get("EMP_ID").toString(), listRequester[i].get("FIRST_NAME").toString() +
                                " " + listRequester[i].get("MIDDLE_NAME").toString() +
                                " " + listRequester[i].get("LAST_NAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("EDUCATION_TYPE").toString(), listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("EDUC_LEVEL_DISC").toString(),
                                listRequester[i].get("EDUC_TYPE_DISC").toString(), Integer.valueOf(listRequester[i].get("RANK").toString()),
                                educLevelRank, largestYear, percent1, percent2);

                        this.requestersForPromotion.add(addToTable);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void populateTableBasedOnPerformanceExperience(double percent1, double percent2) {
        HashMap[] evaSessionResultList = null;
        double maxAverage = 0.0;
        double sum = 0.0;
        double average = 0.0;
        double averageC[] = null;

        if (inputTextAdvertID.getValue() != null) {

            try {
                this.requestersForPromotion.clear();
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterTotalServiceYear(inputTextAdvertID.getValue().toString());


                if (listRequester.length > 0) {
                    int largestYear = compareTwoYears(listRequester[0].get("HIRE_DATE").toString());
                    averageC = new double[listRequester.length];
                    for (int i = 0; i < listRequester.length; i++) {

                        evaSessionResultList = evaResultManObject.readEvaSessionResultComplainTblSingle(SessionID, listRequester[i].get("EMP_ID").toString());
                        if (evaSessionResultList.length > 0) {

                            sum = 0.0;
                            average = 0.0;
                            for (int j = 0; j < evaSessionResultList.length; j++) {
                                sum = sum + Double.valueOf(evaSessionResultList[j].get("RESULT").toString());
                            }
                            average = (sum / evaSessionResultList.length);
                            averageC[i] = average;
                            if (average > maxAverage) {
                                maxAverage = average;
                            }
                        }
                    }


                    for (int i = 0; i < listRequester.length; i++) {
                        AdvertisementManager addToTable = new AdvertisementManager(listRequester[i].get("EMP_ID").toString(), listRequester[i].get("FIRST_NAME").toString() +
                                " " + listRequester[i].get("MIDDLE_NAME").toString() +
                                " " + listRequester[i].get("LAST_NAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("EDUCATION_TYPE").toString(), listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("EDUC_LEVEL_DISC").toString(), listRequester[i].get("EDUC_TYPE_DISC").toString(),
                                maxAverage, largestYear, averageC[i], "x", percent1, percent2, 1);

                        this.requestersForPromotion.add(addToTable);

                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void populateTableBasedOnPerformanceEducLevel(double percent1, double percent2) {
        HashMap[] evaSessionResultList = null;
        double maxAverage = 0.0;
        double sum = 0.0;
        double average = 0.0;
        double averageC[] = null;

        if (inputTextAdvertID.getValue() != null) {

            try {
                this.requestersForPromotion.clear();
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterBasedOnPerformance(inputTextAdvertID.getValue().toString());


                if (listRequester.length > 0) {
                    int educLevelRank = 0;
                    averageC = new double[listRequester.length];
                    for (int i = 0; i < listRequester.length; i++) {

                        evaSessionResultList = evaResultManObject.readEvaSessionResultComplainTblSingle(SessionID, listRequester[i].get("EMP_ID").toString());
                        if (evaSessionResultList.length > 0) {

                            sum = 0.0;
                            average = 0.0;
                            for (int j = 0; j < evaSessionResultList.length; j++) {
                                sum = sum + Double.valueOf(evaSessionResultList[j].get("RESULT").toString());
                            }
                            average = Math.round(sum / evaSessionResultList.length);
                            averageC[i] = average;
                            if (average > maxAverage) {
                                maxAverage = average;
                            }
                        }
                    }


                    for (int i = 0; i < listRequester.length; i++) {
                        educLevelRank = Integer.valueOf(listRequester[0].get("RANK").toString());

                        AdvertisementManager addToTable = new AdvertisementManager(listRequester[i].get("EMP_ID").toString(), listRequester[i].get("FIRST_NAME").toString() +
                                " " + listRequester[i].get("MIDDLE_NAME").toString() +
                                " " + listRequester[i].get("LAST_NAME").toString(),
                                listRequester[i].get("EDUC_LEVEL_CODE").toString(),
                                listRequester[i].get("EDUCATION_TYPE").toString(), listRequester[i].get("HIRE_DATE").toString(),
                                listRequester[i].get("EDUC_LEVEL_DISC").toString(), listRequester[i].get("EDUC_TYPE_DISC").toString(),
                                maxAverage, educLevelRank, averageC[i], listRequester[i].get("RANK").toString(),
                                percent1, percent2, 0);

                        this.requestersForPromotion.add(addToTable);

                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void populateTableBasedOnPerformanceExameDiscipline() {
        try {
            boolean ascending = true;
            //List evaluateResult = getRequestersForPromotion();
            //  Iterator<AdvertisementManager> iter = evaluateResult.iterator();
            float disciplineResult = 0.0f;
            float evaluationPersentage = 0.0f;
            for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }
            getRequestersForPromotion().clear();
            //  evaluateResult.clear();
            //evaluateResult = getResultListData();
            //iter = evaluateResult.iterator();
            //     while (iter.hasNext()) {
                for (AdvertisementManager evaluateAdvertisementManager : getResultListData()) {
                //AdvertisementManager evaluateAdvertisementManager = iter.next();
                // evaluationPersentage = ((evaluateAdvertisementManager.getPerformanceValue() * performancePercent) / 100);
//                disciplineResult = ((evaluateAdvertisementManager.getEmployeeDisciplineResult() * disciplinePersentage) / 100);
//                    evaluateAdvertisementManager.
                    AdvertisementManager addToTable = new AdvertisementManager(
                            evaluateAdvertisementManager.getEmpID(),
                            evaluateAdvertisementManager.getFullName(),
                            evaluateAdvertisementManager.getEducLevel(),
                            evaluateAdvertisementManager.getJobDescription(),
                            evaluateAdvertisementManager.getHire_date(),
                            evaluateAdvertisementManager.getAdvertID(),
                            evaluateAdvertisementManager.getEducLevelDesc(),
                            evaluateAdvertisementManager.getInterviewResult(),
                            evaluateAdvertisementManager.getWrittenResult(),
                            evaluateAdvertisementManager.getPresentationResult(),
                            evaluateAdvertisementManager.getOther(),
                            evaluateAdvertisementManager.getInterviewPercentage(),
                            evaluateAdvertisementManager.getWrittenPercentage(),
                            evaluateAdvertisementManager.getPresentationPercentage(),
                            evaluateAdvertisementManager.getOtherPercentage(),
                            evaluateAdvertisementManager.getPromotionRequestId(),
                            evaluateAdvertisementManager.getEmployeeDisciplineResult(),
                            evaluateAdvertisementManager.getPromotionPercentageValue(),
                            25,
                            5,
                            25,
                            checkPercentage,evaluateAdvertisementManager.getRelatExp(),rank_id);
                    getRequestersForPromotion().add(addToTable);
                }
                getResultListData().clear();

                /// now determine which if x > y return 1  x == y return 0  x < y return -1
            //} //reverse the comparison result
                Collections.sort(getRequestersForPromotion(), new Comparator<AdvertisementManager>() {

                    @Override
                    public int compare(AdvertisementManager s1, AdvertisementManager s2) {
                    //return (int) (s1.getPercentTotal() - s2.getPercentTotal());
                        if (s1.getPercentTotal() == s2.getPercentTotal()) {
                            return 0;
                        } else if (s1.getPercentTotal() > s2.getPercentTotal()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });
                Collections.reverse(getRequestersForPromotion());
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void populateTableBasedOnPerformanceAndDiscipline(float disciplinePersentage, float performancePercent) {

        try {
            boolean ascending = true;
            //List evaluateResult = getRequestersForPromotion();
            //  Iterator<AdvertisementManager> iter = evaluateResult.iterator();
            float disciplineResult = 0.0f;
            float evaluationPersentage = 0.0f;

            for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }
            getRequestersForPromotion().clear();
            //  evaluateResult.clear();
            //evaluateResult = getResultListData();
            //iter = evaluateResult.iterator();
            //     while (iter.hasNext()) {
            for (AdvertisementManager evaluateAdvertisementManager : getResultListData()) {
                //AdvertisementManager evaluateAdvertisementManager = iter.next();
                // evaluationPersentage = ((evaluateAdvertisementManager.getPerformanceValue() * performancePercent) / 100);
                ///disciplineResult = ((evaluateAdvertisementManager.getEmployeeDisciplineResult() * disciplinePersentage) / 100);
                AdvertisementManager addToTable = new AdvertisementManager(
                        evaluateAdvertisementManager.getEmpID(),
                        evaluateAdvertisementManager.getFullName(),
                        evaluateAdvertisementManager.getEducLevel(),
                        evaluateAdvertisementManager.getJobDescription(),
                        evaluateAdvertisementManager.getHire_date(),
                        evaluateAdvertisementManager.getAdvertID(),
                        evaluateAdvertisementManager.getEducLevelDesc(),
                        evaluateAdvertisementManager.getInterviewResult(),
                        evaluateAdvertisementManager.getWrittenResult(),
                        evaluateAdvertisementManager.getPresentationResult(),
                        evaluateAdvertisementManager.getOther(),
                        evaluateAdvertisementManager.getInterviewPercentage(),
                        evaluateAdvertisementManager.getWrittenPercentage(),
                        evaluateAdvertisementManager.getPresentationPercentage(),
                        evaluateAdvertisementManager.getOtherPercentage(),
                        evaluateAdvertisementManager.getPromotionRequestId(),
                        evaluateAdvertisementManager.getEmployeeDisciplineResult(),
                        evaluateAdvertisementManager.getPromotionPercentageValue(),
                        0,
                        disciplinePersentage,
                        performancePercent,
                        checkPercentage,evaluateAdvertisementManager.getRelatExp(),rank_id);
                getRequestersForPromotion().add(addToTable);
            }
            getResultListData().clear();

            /// now determine which if x > y return 1  x == y return 0  x < y return -1
            //} //reverse the comparison result
            Collections.sort(getRequestersForPromotion(), new Comparator<AdvertisementManager>() {

                @Override
                public int compare(AdvertisementManager s1, AdvertisementManager s2) {
                    //return (int) (s1.getPercentTotal() - s2.getPercentTotal());
                    if (s1.getPercentTotal() == s2.getPercentTotal()) {
                        return 0;
                    } else if (s1.getPercentTotal() > s2.getPercentTotal()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            Collections.reverse(getRequestersForPromotion());
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    public void populateTableBasedOnDiscipline(float disciplinePersentage) {

        try {
            boolean ascending = true;
            //List evaluateResult = getRequestersForPromotion();
            //  Iterator<AdvertisementManager> iter = evaluateResult.iterator();
            float disciplineResult = 0.0f;
            float evaluationPersentage = 0.0f;

            for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }
            getRequestersForPromotion().clear();
            //  evaluateResult.clear();
            //evaluateResult = getResultListData();
            //iter = evaluateResult.iterator();
            //     while (iter.hasNext()) {
            for (AdvertisementManager evaluateAdvertisementManager : getResultListData()) {
                //AdvertisementManager evaluateAdvertisementManager = iter.next();
                // evaluationPersentage = ((evaluateAdvertisementManager.getPerformanceValue() * performancePercent) / 100);
                ///disciplineResult = ((evaluateAdvertisementManager.getEmployeeDisciplineResult() * disciplinePersentage) / 100);
                AdvertisementManager addToTable = new AdvertisementManager(
                        evaluateAdvertisementManager.getEmpID(),
                        evaluateAdvertisementManager.getFullName(),
                        evaluateAdvertisementManager.getEducLevel(),
                        evaluateAdvertisementManager.getJobDescription(),
                        evaluateAdvertisementManager.getHire_date(),
                        evaluateAdvertisementManager.getAdvertID(),
                        evaluateAdvertisementManager.getEducLevelDesc(),
                        evaluateAdvertisementManager.getInterviewResult(),
                        evaluateAdvertisementManager.getWrittenResult(),
                        evaluateAdvertisementManager.getPresentationResult(),
                        evaluateAdvertisementManager.getOther(),
                        evaluateAdvertisementManager.getInterviewPercentage(),
                        evaluateAdvertisementManager.getWrittenPercentage(),
                        evaluateAdvertisementManager.getPresentationPercentage(),
                        evaluateAdvertisementManager.getOtherPercentage(),
                        evaluateAdvertisementManager.getPromotionRequestId(),
                        evaluateAdvertisementManager.getEmployeeDisciplineResult(),
                        evaluateAdvertisementManager.getPromotionPercentageValue(),
                        0,
                        disciplinePersentage,
                        0,
                        checkPercentage,
                        evaluateAdvertisementManager.getRelatExp(),rank_id);
                getRequestersForPromotion().add(addToTable);
            }
            getResultListData().clear();

            /// now determine which if x > y return 1  x == y return 0  x < y return -1
            //} //reverse the comparison result
            Collections.sort(getRequestersForPromotion(), new Comparator<AdvertisementManager>() {

                @Override
                public int compare(AdvertisementManager s1, AdvertisementManager s2) {
                    //return (int) (s1.getPercentTotal() - s2.getPercentTotal());
                    if (s1.getPercentTotal() == s2.getPercentTotal()) {
                        return 0;
                    } else if (s1.getPercentTotal() > s2.getPercentTotal()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            Collections.reverse(getRequestersForPromotion());
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    public void populateTableBasedOnPerformanceAndExame(
            float examPersentage, float performancePercent) {
        try {
            boolean ascending = true;
            //List evaluateResult = getRequestersForPromotion();
            //  Iterator<AdvertisementManager> iter = evaluateResult.iterator();
            float disciplineResult = 0.0f;
            float evaluationPersentage = 0.0f;

            for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }
            getRequestersForPromotion().clear();
            //  evaluateResult.clear();
            //evaluateResult = getResultListData();
            //iter = evaluateResult.iterator();
            //     while (iter.hasNext()) {
            for (AdvertisementManager evaluateAdvertisementManager : getResultListData()) {
                //AdvertisementManager evaluateAdvertisementManager = iter.next();
                // evaluationPersentage = ((evaluateAdvertisementManager.getPerformanceValue() * performancePercent) / 100);
                ///disciplineResult = ((evaluateAdvertisementManager.getEmployeeDisciplineResult() * disciplinePersentage) / 100);
                AdvertisementManager addToTable = new AdvertisementManager(
                        evaluateAdvertisementManager.getEmpID(),
                        evaluateAdvertisementManager.getFullName(),
                        evaluateAdvertisementManager.getEducLevel(),
                        evaluateAdvertisementManager.getJobDescription(),
                        evaluateAdvertisementManager.getHire_date(),
                        evaluateAdvertisementManager.getAdvertID(),
                        evaluateAdvertisementManager.getEducLevelDesc(),
                        evaluateAdvertisementManager.getInterviewResult(),
                        evaluateAdvertisementManager.getWrittenResult(),
                        evaluateAdvertisementManager.getPresentationResult(),
                        evaluateAdvertisementManager.getOther(),
                        evaluateAdvertisementManager.getInterviewPercentage(),
                        evaluateAdvertisementManager.getWrittenPercentage(),
                        evaluateAdvertisementManager.getPresentationPercentage(),
                        evaluateAdvertisementManager.getOtherPercentage(),
                        evaluateAdvertisementManager.getPromotionRequestId(),
                        evaluateAdvertisementManager.getEmployeeDisciplineResult(),
                        evaluateAdvertisementManager.getPromotionPercentageValue(),
                        examPersentage,
                        0,
                        performancePercent,
                        checkPercentage,
                        evaluateAdvertisementManager.getRelatExp(),rank_id);
                getRequestersForPromotion().add(addToTable);
            }
            getResultListData().clear();

            /// now determine which if x > y return 1  x == y return 0  x < y return -1
            //} //reverse the comparison result
            Collections.sort(getRequestersForPromotion(), new Comparator<AdvertisementManager>() {

                @Override
                public int compare(AdvertisementManager s1, AdvertisementManager s2) {
                    //return (int) (s1.getPercentTotal() - s2.getPercentTotal());
                    if (s1.getPercentTotal() == s2.getPercentTotal()) {
                        return 0;
                    } else if (s1.getPercentTotal() > s2.getPercentTotal()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            Collections.reverse(getRequestersForPromotion());
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void populateTableBasedOnPerformance(
            float performancePercent) {
        try {
            boolean ascending = true;
            //List evaluateResult = getRequestersForPromotion();
            //  Iterator<AdvertisementManager> iter = evaluateResult.iterator();
            float disciplineResult = 0.0f;
            float evaluationPersentage = 0.0f;

            for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }
            getRequestersForPromotion().clear();
            //  evaluateResult.clear();
            //evaluateResult = getResultListData();
            //iter = evaluateResult.iterator();
            //     while (iter.hasNext()) {
            for (AdvertisementManager evaluateAdvertisementManager : getResultListData()) {
                //AdvertisementManager evaluateAdvertisementManager = iter.next();
                // evaluationPersentage = ((evaluateAdvertisementManager.getPerformanceValue() * performancePercent) / 100);
                ///disciplineResult = ((evaluateAdvertisementManager.getEmployeeDisciplineResult() * disciplinePersentage) / 100);
                AdvertisementManager addToTable = new AdvertisementManager(
                        evaluateAdvertisementManager.getEmpID(),
                        evaluateAdvertisementManager.getFullName(),
                        evaluateAdvertisementManager.getEducLevel(),
                        evaluateAdvertisementManager.getJobDescription(),
                        evaluateAdvertisementManager.getHire_date(),
                        evaluateAdvertisementManager.getAdvertID(),
                        evaluateAdvertisementManager.getEducLevelDesc(),
                        evaluateAdvertisementManager.getInterviewResult(),
                        evaluateAdvertisementManager.getWrittenResult(),
                        evaluateAdvertisementManager.getPresentationResult(),
                        evaluateAdvertisementManager.getOther(),
                        evaluateAdvertisementManager.getInterviewPercentage(),
                        evaluateAdvertisementManager.getWrittenPercentage(),
                        evaluateAdvertisementManager.getPresentationPercentage(),
                        evaluateAdvertisementManager.getOtherPercentage(),
                        evaluateAdvertisementManager.getPromotionRequestId(),
                        evaluateAdvertisementManager.getEmployeeDisciplineResult(),
                        evaluateAdvertisementManager.getPromotionPercentageValue(),
                        0,
                        0,
                        performancePercent,
                        checkPercentage,
                        evaluateAdvertisementManager.getRelatExp(),rank_id);
                getRequestersForPromotion().add(addToTable);
            }
            getResultListData().clear();

            /// now determine which if x > y return 1  x == y return 0  x < y return -1
            //} //reverse the comparison result
            Collections.sort(getRequestersForPromotion(), new Comparator<AdvertisementManager>() {

                @Override
                public int compare(AdvertisementManager s1, AdvertisementManager s2) {
                    //return (int) (s1.getPercentTotal() - s2.getPercentTotal());
                    if (s1.getPercentTotal() == s2.getPercentTotal()) {
                        return 0;
                    } else if (s1.getPercentTotal() > s2.getPercentTotal()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            Collections.reverse(getRequestersForPromotion());
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void populateTableBasedOnExameResult(
            float examPersentage) {
        try {
            boolean ascending = true;
            //List evaluateResult = getRequestersForPromotion();
            //  Iterator<AdvertisementManager> iter = evaluateResult.iterator();
            float disciplineResult = 0.0f;
            float evaluationPersentage = 0.0f;

            for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }
            getRequestersForPromotion().clear();
            //  evaluateResult.clear();
            //evaluateResult = getResultListData();
            //iter = evaluateResult.iterator();
            //     while (iter.hasNext()) {
            for (AdvertisementManager evaluateAdvertisementManager : getResultListData()) {
                //AdvertisementManager evaluateAdvertisementManager = iter.next();
                // evaluationPersentage = ((evaluateAdvertisementManager.getPerformanceValue() * performancePercent) / 100);
                ///disciplineResult = ((evaluateAdvertisementManager.getEmployeeDisciplineResult() * disciplinePersentage) / 100);
                AdvertisementManager addToTable = new AdvertisementManager(
                        evaluateAdvertisementManager.getEmpID(),
                        evaluateAdvertisementManager.getFullName(),
                        evaluateAdvertisementManager.getEducLevel(),
                        evaluateAdvertisementManager.getJobDescription(),
                        evaluateAdvertisementManager.getHire_date(),
                        evaluateAdvertisementManager.getAdvertID(),
                        evaluateAdvertisementManager.getEducLevelDesc(),
                        evaluateAdvertisementManager.getInterviewResult(),
                        evaluateAdvertisementManager.getWrittenResult(),
                        evaluateAdvertisementManager.getPresentationResult(),
                        evaluateAdvertisementManager.getOther(),
                        evaluateAdvertisementManager.getInterviewPercentage(),
                        evaluateAdvertisementManager.getWrittenPercentage(),
                        evaluateAdvertisementManager.getPresentationPercentage(),
                        evaluateAdvertisementManager.getOtherPercentage(),
                        evaluateAdvertisementManager.getPromotionRequestId(),
                        evaluateAdvertisementManager.getEmployeeDisciplineResult(),
                        evaluateAdvertisementManager.getPromotionPercentageValue(),
                        examPersentage,
                        0,
                        0,
                        checkPercentage,
                        evaluateAdvertisementManager.getRelatExp(),rank_id);
                getRequestersForPromotion().add(addToTable);
            }
            getResultListData().clear();

            /// now determine which if x > y return 1  x == y return 0  x < y return -1
            //} //reverse the comparison result
            Collections.sort(getRequestersForPromotion(), new Comparator<AdvertisementManager>() {

                @Override
                public int compare(AdvertisementManager s1, AdvertisementManager s2) {
                    //return (int) (s1.getPercentTotal() - s2.getPercentTotal());
                    if (s1.getPercentTotal() == s2.getPercentTotal()) {
                        return 0;
                    } else if (s1.getPercentTotal() > s2.getPercentTotal()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            Collections.reverse(getRequestersForPromotion());
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void rowSelectorVacancyNoticeList_processMyEvent(RowSelectorEvent rse) {
    }

    public String btnRequest_action() {
        populateTableBasedOnPerformanceExameDiscipline();
        return null;
    }

    public String btnClosePopupViewPrevieousDecisions1_action() {
        //return null means stay on the same page
        pnlPopupViewEmployees_History.setRendered(false);
        return null;
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
        btnRequest.setDisabled(false);
        btnSave.setDisabled(false);
        advertId = vce.getNewValue().toString();
        if (vce.getNewValue() != null) {
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
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequesterFirst(vce.getNewValue().toString());
                requestersForPromotion.clear();
                if (listRequester.length > 0) {
                    enableEvaluationComponents();
                    HashMap promotionAssessmentPercentage = promotionManager.selectPromotionAssessmentPrecentage(bach_Code);
                    if (promotionAssessmentPercentage != null && promotionAssessmentPercentage.size() > 0)
                    {
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
                                listRequester[i].get("STATUS").toString(),
                                Float.parseFloat(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("PRESENTATION_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("OTHER_RESULT").toString()),
                                interviewPercentage,
                                writtenPercentage,
                                presentationPercentage,
                                otherPercentage,
                                listRequester[i].get("ID").toString(),
                                disciplineValue,
                                performanceValue,
                                0,
                                disciplinePercentage,
                                performancePercentage,
                                checkPercentage);
                        getRequestersForPromotion().add(addToTable);
                      //  disciplineValue = 5.0f;
                      //  performanceValue = 0.0f;
                    }
                     for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }

                }
                checkFromSelect = false;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    public String button2Ok_action() {
        evaResultPopUpMsg.setRendered(false);
        SessionID =
                selectOneMenu1evaResultPopUpMsg.getValue().toString();
        //return null means stay on the same page
        return null;
    }

    public String button2Cancel_action() {
        evaResultPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    private ArrayList<HashMap> listOfEvaluation() {
        ArrayList<HashMap> listEvaluation = new ArrayList<HashMap>();
        for (AdvertisementManager advertisementManagerEv : getRequestersForPromotion()) {
            HashMap hm = new HashMap();
            hm.put("employeeId", advertisementManagerEv.getEmpID());
            hm.put("promotionRequestId", advertisementManagerEv.getPromotionRequestId());
            if (advertisementManagerEv.getStatus() != null) {
                hm.put("STATUS", advertisementManagerEv.getStatus());
            } else {
                hm.put("STATUS", Integer.toString(AdvertisementManager.INTITAL_PERCENTAGE));
            }
            hm.put("advertID", advertisementManagerEv.getAdvertID());
            hm.put("ToalExamResult", advertisementManagerEv.getToalExamResult());
            hm.put("DisciplineResult", advertisementManagerEv.getEmployeeDisciplineResult());
            hm.put("PerformanceValue", advertisementManagerEv.getPerformanceValue());
            hm.put("EXAMPERCENTAGE", advertisementManagerEv.getExamPercentage());
            hm.put("DisciplinePercentage", advertisementManagerEv.getDisciplinePercentage());
            hm.put("PromotionPercentage", advertisementManagerEv.getPromotionPercentage());
            hm.put("PercentTotal", advertisementManagerEv.getPercentTotal());
            listEvaluation.add(hm);
        }
        return listEvaluation;
    }

    public String btnSave_action() {
        if (advertisementManager.addPromotionRequester(listOfEvaluation(), committeeId)) {
            this.showSuccessOrFailureMessage(true, "Promotion request is successfully saved!");
        } else {
            this.showSuccessOrFailureMessage(false, "Error Occured during saving .Please Try Again?");
        }
        return null;
    }

    public void selectOneListboxSelectDate1_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (!vce.getNewValue().toString().equals("00")) {
                selectOneListboxPromotionRequestes.resetValue();
                String date[] = vce.getNewValue().toString().split("----");
                bach_Code = date[3].trim();
                
                newPromotionRequests = recruitmentManager.newPromotionRequestsFilterdByDate(date[1].trim(), date[2].trim());
                newPromotionResponse = recruitmentManager.newPromotionResponseFilterdByDate(date[1].trim(), date[2].trim());
                if (newPromotionRequests == null) {
                    if (newPromotionResponse == null) {
                        showSuccessOrFailureMessage(false, "Employee not Register for This Advertisement.");
                    }

                }
            }

        }
    }

    public String buttonViewAll_action() {
        newPromotionRequests = recruitmentManager.newPromotionRequests();
        newPromotionResponse = recruitmentManager.newPromotionResponse();
        //return null means stay on the same page
        return null;
    }

    public String buttonViewAllR_action() {
        newPromotionRequests = recruitmentManager.newPromotionRequests();
        newPromotionResponse =
                recruitmentManager.newPromotionResponse();
        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1Response_processValueChange(ValueChangeEvent vce) {

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
        btnRequest.setDisabled(true);
        btnSave.setDisabled(true);
        advertId = vce.getNewValue().toString();
        if (vce.getNewValue() != null) {
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
                HashMap[] listRequester = advertisementManager.readVacancyPromoRequester(vce.getNewValue().toString());

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
                                listRequester[i].get("STATUS").toString(),
                                Float.parseFloat(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("PRESENTATION_EXAM_RESULT").toString()),
                                Float.parseFloat(listRequester[i].get("OTHER_RESULT").toString()),
                                interviewPercentage,
                                writtenPercentage,
                                presentationPercentage,
                                otherPercentage,
                                listRequester[i].get("ID").toString(),
                                disciplineValue,
                                performanceValue,
                                0,
                                disciplinePercentage,
                                performancePercentage,
                                checkPercentage);
                        getRequestersForPromotion().add(addToTable);
                        disciplineValue = 5.0f;
                        performanceValue = 0.0f;
                    }
                     for (AdvertisementManager evaluateAdvertisementManager : getRequestersForPromotion()) {
                getResultListData().add(evaluateAdvertisementManager);
            }

                }
                checkFromSelect = false;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }








//        float examPersentage = 0.0f;
//        float disciplinPercentage = 0.0f;
//        float performacncePercetage = 0.0f;
//        boolean firstTimeCheck = true;
//        btnRequest.setDisabled(true);
//        btnSave.setDisabled(true);
//        advertId = vce.getNewValue().toString();
//        if (vce.getNewValue() != null) {
//            this.inputTextAdvertID.setValue(vce.getNewValue().toString());
//            try {
//                this.vacancyList.clear();
//                int educLevelId = 0;
//                int educLevelresult = 0;
//                HashMap[] list = advertisementManager.readVacancyPromoRequest(vce.getNewValue().toString());
//                rank_id = list[0].get("RANK_ID").toString();
//                if (list.length > 0) {
//                    for (int i = 0; i < list.length; i++) {
//
//                        AdvertisementManager addToTable = new AdvertisementManager(
//                                list[i].get("advert_date_from").toString(),
//                                list[i].get("advert_date_to").toString(),
//                                list[i].get("recruit_batch_code").toString(),
//                                list[i].get("JOB_DESCRIPTION").toString(),
//                                list[i].get("RECRUIT_REQUEST_ID").toString(),
//                                list[i].get("RECRUIT_REQUEST_TYPE").toString(),
//                                list[i].get("NUM_OF_EMPS_APPROVED").toString(),
//                                list[i].get("MIN_EXPERIENCE").toString(),
//                                list[i].get("ADVERT_ID").toString(),
//                                list[i].get("QUALIFICATION").toString(),
//                                list[i].get("EDUCATION_LEVEL").toString(),
//                                list[i].get("JOB_CODE").toString(), 0,
//                                0, list[i].get("RANK_ID").toString());
//                        this.vacancyList.add(addToTable);
//                    }
//
//                }
//                this.requestersForPromotion.clear();
//                HashMap[] listRequester = advertisementManager.readPromotionRequestsList(vce.getNewValue().toString());
//                if (listRequester.length > 0) {
//                    for (int i = 0; i < listRequester.length; i++) {
//                        requester_ID = listRequester[i].get("EMP_ID").toString();
//                        educLevelId = advertisementManager.readEducLevel(listRequester[i].get("EMP_ID").toString());
//                        educLevelresult = advertisementManager.readEducLevelresult(educLevelId, rank_id);
//                        if (firstTimeCheck) {
//                            if (listRequester[i].get("EXAMPERCENTAGE") != null) {
//                                examPersentage = Float.valueOf(listRequester[i].get("EXAMPERCENTAGE").toString());
//                            } else {
//                                examPersentage = 0.0f;
//                            }
//                            if (listRequester[i].get("DISCIPLINEPERCENTAGE") != null) {
//                                disciplinPercentage = Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGE").toString());
//                            }
//                            if (listRequester[i].get("PERFORMANCEPERCENTAGE") != null) {
//                                performacncePercetage = Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGE").toString());
//                            }
//                            firstTimeCheck = false;
//                        }
//                        AdvertisementManager addToTable = new AdvertisementManager(
//                                educLevelresult, listRequester[i].get("EXPERIENCEREL").toString(),
//                                listRequester[i].get("ADVERT_ID").toString(),
//                                listRequester[i].get("EMP_ID").toString(),
//                                listRequester[i].get("FULLNAME").toString(),
//                                listRequester[i].get("JOB_DESCRIPTION").toString(),
//                                Float.valueOf(listRequester[i].get("EXAMPERCENTAGE").toString()),
//                                Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGE").toString()),
//                                Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGE").toString()),
//                                listRequester[i].get("EXPERIENCE").toString(),
//                                Float.valueOf(listRequester[i].get("INTERVIEW_EXAM_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("OTHER_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("WRITTEN_EXAM_RESULT").toString()),
//                                Float.valueOf(listRequester[i].get("EXAMEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("DISCIPLINEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("PERFORMANCEPERCENTAGERESULT").toString()),
//                                Float.valueOf(listRequester[i].get("EMPLOYEETOTALRESULT").toString()),
//                                listRequester[i].get("ID").toString());
//                        this.requestersForPromotion.add(addToTable);
//
//                    }
//                    this.txtDiscipline.setValue(disciplinPercentage);
//                    this.txtPerformance.setValue(performacncePercetage);
//                    this.txtExameResult.setValue(examPersentage);
//
//                }
//                HashMap[] promotionRequestStat = advertisementManager.readPromotionRequestsStat(vce.getNewValue().toString());
//                if (promotionRequestStat.length > 0) {
//                    if (Integer.valueOf(promotionRequestStat[0].get("STATUS").toString()) == 1) {
//                        lblStatusValue.setValue(" Evaluated and wating for approval!!! ");
//                        this.btnRequest.setDisabled(false);
//                        this.btnSave.setDisabled(false);
//                    } else if (Integer.valueOf(promotionRequestStat[0].get("STATUS").toString()) == 2) {
//                        lblStatusValue.setValue(" Approved!!! ");
//                        this.btnRequest.setDisabled(true);
//                        this.btnSave.setDisabled(true);
//                    } else if (Integer.valueOf(promotionRequestStat[0].get("STATUS").toString()) == 3) {
//                        lblStatusValue.setValue(" Rejected!!! ");
//                        this.btnRequest.setDisabled(true);
//                        this.btnSave.setDisabled(true);
//                    } else {
//                        lblStatusValue.setValue(" Promotion Request Status.");
//                    }
//
//                }
//                checkFromSelect = true;
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//        }
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

    public void rowSelectorPromotionRequester_processMyEvent(RowSelectorEvent rse) {
        try {
            requester_ID = null;
            selectedPromotionRequester = rse.getRow();
            if (selectedPromotionRequester > -1) {
                AdvertisementManager employeeExperiance = (AdvertisementManager) this.requestersForPromotion.get(this.selectedPromotionRequester);
                proRequestId = Integer.parseInt(employeeExperiance.getPromotionRequestId());

                clearAssessmentResult();
                HashMap readPromotionAssessmentResult = promotionManager.readPromotionAssessmentResultForUpdate(proRequestId);
                if (readPromotionAssessmentResult != null && readPromotionAssessmentResult.size() > 0) {
                    String recommendation = "";
                    String remark = "";
                    promotionAssessmentId = Integer.valueOf(readPromotionAssessmentResult.get("PROMOTION_ASSESSMENT_ID").toString());
                    txtWrittenResult.setValue(readPromotionAssessmentResult.get("WRITTEN_EXAM_RESULT"));
                    txtInterviewResult.setValue(readPromotionAssessmentResult.get("INTERVIEW_EXAM_RESULT"));
                    txtPresentationResult.setValue(readPromotionAssessmentResult.get("PRESENTATION_EXAM_RESULT"));
                    txtOtherResult.setValue(readPromotionAssessmentResult.get("OTHER_RESULT"));

                    if (readPromotionAssessmentResult.get("RECOMMENDATION") != null) {
                        recommendation = readPromotionAssessmentResult.get("RECOMMENDATION").toString();
                    }

                    if (readPromotionAssessmentResult.get("REMARK") != null) {
                        remark = readPromotionAssessmentResult.get("REMARK").toString();
                    }
                    if (!checkFromSelect) {
                        btnUpdateAssessmentResult.setDisabled(true);
                        btnEditAssessmentResult.setDisabled(false);
                        btnSaveAssessmentResult.setDisabled(true);
                    } else {
                        btnUpdateAssessmentResult.setDisabled(true);
                        btnEditAssessmentResult.setDisabled(true);
                        btnSaveAssessmentResult.setDisabled(true);
                    }

                    txtRec.setValue(recommendation);
                    txtRem.setValue(remark);
                    disableAssessmentResult();

                } else {
                    if (!checkFromSelect) {
                        enableAssessmentResult();
                        btnUpdateAssessmentResult.setDisabled(true);
                        btnEditAssessmentResult.setDisabled(true);
                        btnSaveAssessmentResult.setDisabled(false);
                    } else {
                        disableAssessmentResult();
                        btnUpdateAssessmentResult.setDisabled(true);
                        btnEditAssessmentResult.setDisabled(true);
                        btnSaveAssessmentResult.setDisabled(true);
                    }

                }
                requester_ID = (String) readPromotionAssessmentResult.get("Emp_Id");
                popupPromotionAssessmentResult.setRendered(true);
                selectedPromotionRequester = -1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String modalPnlCloseDisplayAssessmentResult_action() {
        popupPromotionAssessmentResult.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseDegreeOfAss_action() {
        pnDegreeOfAss.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String closeExperience_action() {
        pnpExperience.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String cmdDegreeOfPromoteAssement_action() {
        pnDegreeOfAss.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String cmdExperience_action() {
        pnpExperience.setRendered(true);
        String empId = requester_ID;

        if (empId != null) {
            empExperienceModel = promotionRequestManager.getEmpExperienceHistoryPromotion(empId);
            pnlPopupViewEmployees_History.setRendered(true);
        } else {
        }

        return null;
    }

    private HashMap percentageDate() {

        HashMap promotionAssessmentPercentage = new HashMap();
        if (HRValidation.validateData(txtWrittenPercentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0) {
            promotionAssessmentPercentage.put("writtenpercentage", txtWrittenPercentage.getValue().toString());
            totalPersentage +=
                    Integer.parseInt(txtWrittenPercentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("writtenpercentage", "0");
        }

        if (HRValidation.validateData(txtInterviewPercentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0) {
            promotionAssessmentPercentage.put("interviewpercentage", txtInterviewPercentage.getValue().toString());
            totalPersentage +=
                    Integer.parseInt(txtInterviewPercentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("interviewpercentage", "0");
        }

        if (HRValidation.validateData(txtPresentaionPercentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0) {
            promotionAssessmentPercentage.put("presentationpercentage", txtPresentaionPercentage.getValue().toString());
            totalPersentage +=
                    Integer.parseInt(txtPresentaionPercentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("presentationpercentage", "0");
        }

        if (HRValidation.validateData(txtOtherPercentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0) {
            promotionAssessmentPercentage.put("otherpercentage", txtOtherPercentage.getValue().toString());
            totalPersentage +=
                    Integer.parseInt(txtOtherPercentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("otherpercentage", "0");
        }


        promotionAssessmentPercentage.put("batchCode", ddnBatchCode.getValue().toString());
        return promotionAssessmentPercentage;
    }

    private void clearPercentageComponent() {
        txtWrittenPercentage.resetValue();
        txtInterviewPercentage.resetValue();
        txtPresentaionPercentage.resetValue();
        txtOtherPercentage.resetValue();
    }

    private void disablePercentageComponent() {
        txtWrittenPercentage.setDisabled(true);
        txtInterviewPercentage.setDisabled(true);
        txtPresentaionPercentage.setDisabled(true);
        txtOtherPercentage.setDisabled(true);
    }

    private void enablePercentageComponent() {
        txtWrittenPercentage.setDisabled(false);
        txtInterviewPercentage.setDisabled(false);
        txtPresentaionPercentage.setDisabled(false);
        txtOtherPercentage.setDisabled(false);
    }

    public String btnSavePercentage_action() {

        HashMap hmpercentageDate = percentageDate();

        if (totalPersentage == 100) {
            if (promotionManager.insertPromotionAssessmentPrecentage(hmpercentageDate)) {
//            showSuccessOrFailureMessage(true, "The Degree of Exam Information  Saved Successfully!");
                pnDegreeOfAss.setRendered(false);
                clearPercentageComponent();

                disablePercentageComponent();

                ddnBatchCode.resetValue();
                ddnBatchCode.setValue("0");
                btnSavePercentage.setDisabled(true);
                btnEditPercentage.setDisabled(true);
                btnUpdatePercentage.setDisabled(true);
                btnDeletePercentage.setDisabled(true);
            } else {
                showSuccessOrFailureMessage(false, "The Degree of Exam Information Not Saved ? Please try agin?");
            }

        } else {
            showSuccessOrFailureMessage(false, "The Degree of Exam Sum  shod be 100.Please correct agin?");
        }
//return null means stay on the same page

        return null;
    }

    public String btnEditPercentage_action() {
        enablePercentageComponent();
        btnSavePercentage.setDisabled(true);
        btnEditPercentage.setDisabled(true);
        btnUpdatePercentage.setDisabled(false);
        btnDeletePercentage.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public String btnUpdatePercentage_action() {
        HashMap hmpercentageDate = percentageDate();
        if (totalPersentage == 100) {
            if (promotionManager.updatePromotionAssessmentPrecentage(hmpercentageDate)) {
                pnDegreeOfAss.setRendered(false);
                showSuccessOrFailureMessage(true, "The Degree of Exam Information updated Successfully!");
                pnDegreeOfAss.setRendered(false);
                clearPercentageComponent();

                disablePercentageComponent();

                ddnBatchCode.resetValue();
                ddnBatchCode.setValue("0");
                btnSavePercentage.setDisabled(true);
                btnEditPercentage.setDisabled(true);
                btnUpdatePercentage.setDisabled(true);
                btnDeletePercentage.setDisabled(true);
            } else {
                showSuccessOrFailureMessageForZindex(false, "The degree of exam information not update ? Please try agin?");
            }

        } else {
            showSuccessOrFailureMessageForZindex(false, "The degree of exam sum shoud be 100 ! Please correct it and try agin?");
        }

//return null means stay on the same page
        return null;
    }

    public String btnDeletePercentage_action() {
        if (promotionManager.deletePromotionAssessmentPrecentage(batchCodePrecentage)) {
//            showSuccessOrFailureMessage(true, "The Degree of Exam Information updated Successfully!");
            pnDegreeOfAss.setRendered(false);
            clearPercentageComponent();

            disablePercentageComponent();

            ddnBatchCode.resetValue();
            ddnBatchCode.setValue("0");
            btnSavePercentage.setDisabled(true);
            btnEditPercentage.setDisabled(true);
            btnUpdatePercentage.setDisabled(true);
            btnDeletePercentage.setDisabled(true);
        } else {
//            showSuccessOrFailureMessage(false, "The degree of exam information not update ? Please try agin?");
        }
        //return null means stay on the same page
        return null;
    }

    public void ddnBatchCode_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            clearPercentageComponent();
            HashMap promotionAssessmentPercentage = promotionManager.selectPromotionAssessmentPrecentage(vce.getNewValue().toString());
            if (promotionAssessmentPercentage != null && promotionAssessmentPercentage.size() > 0) {
                txtWrittenPercentage.setValue(promotionAssessmentPercentage.get("writtenpercentage"));
                txtInterviewPercentage.setValue(promotionAssessmentPercentage.get("interviewpercentage"));
                txtPresentaionPercentage.setValue(promotionAssessmentPercentage.get("presentationpercentage"));
                txtOtherPercentage.setValue(promotionAssessmentPercentage.get("otherpercentage"));
                batchCodePrecentage =
                        promotionAssessmentPercentage.get("batchCode").toString();

                btnSavePercentage.setDisabled(true);
                btnEditPercentage.setDisabled(false);
                btnUpdatePercentage.setDisabled(true);
                btnDeletePercentage.setDisabled(false);

            } else {
                enablePercentageComponent();
                clearPercentageComponent();

                btnSavePercentage.setDisabled(false);
                btnEditPercentage.setDisabled(true);
                btnUpdatePercentage.setDisabled(true);
                btnDeletePercentage.setDisabled(true);
            }

        } else {
            enablePercentageComponent();
            clearPercentageComponent();

            btnSavePercentage.setDisabled(true);
            btnEditPercentage.setDisabled(true);
            btnUpdatePercentage.setDisabled(true);
            btnDeletePercentage.setDisabled(true);
        }

    }

    private HashMap assessmentResult() {
        HashMap hm = new HashMap();
        hm.put("interview", txtInterviewResult.getValue());
        hm.put("written", txtWrittenResult.getValue());
        hm.put("presentation", txtPresentationResult.getValue());
        hm.put("other", txtOtherResult.getValue());
        if (txtRec.getValue() != null) {
            hm.put("recommendation", txtRec.getValue().toString());
        }

        if (txtRem.getValue() != null) {
            hm.put("remark", txtRem.getValue().toString());
        }

        return hm;
    }

    public String btnSaveAssessmentResult_action() {
        if (isEntryValid()) {
            if (promotionManager.insertPromotionAssessmentResult(proRequestId, assessmentResult())) {
                popupPromotionAssessmentResult.setRendered(false);
                this.showSuccessOrFailureMessage(true, "Assessment results has been successfully saved!");
                clearAssessmentResult();

            } else {
                this.showSuccessOrFailureMessage(false, "Error occured while trying to save assessment results !");

//                showConformationMsgForPopUps(false, "Error occured while trying to save assessment results");
            }

        }




        //return null means stay on the same page
        return null;
    }

    private void clearAssessmentResult() {
        txtInterviewResult.resetValue();
        txtWrittenResult.resetValue();
        txtPresentationResult.resetValue();
        txtOtherResult.resetValue();
        txtRec.resetValue();
        txtRem.resetValue();
    }

    private void enableAssessmentResult() {
        txtInterviewResult.setDisabled(false);
        txtWrittenResult.setDisabled(false);
        txtPresentationResult.setDisabled(false);
        txtOtherResult.setDisabled(false);
        txtRec.setDisabled(false);
        txtRem.setDisabled(false);
    }

    private void disableAssessmentResult() {
        txtInterviewResult.setDisabled(true);
        txtWrittenResult.setDisabled(true);
        txtPresentationResult.setDisabled(true);
        txtOtherResult.setDisabled(true);
        txtRec.setDisabled(true);
        txtRem.setDisabled(true);
    }

    public boolean isEntryValid() {
        boolean result = true; // set false when error ocurred
        boolean required;
        String errorMessage = "Invalid Value";
        int errorValue = 0;
        errorValue =
                HRValidation.validateData(this.txtInterviewResult.getValue(), HRValidation.INT_FLOTING_NUMBER, false);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtInterviewResult).setValid(false);
            error(txtInterviewResult, errorMessage);
        }

        errorValue = HRValidation.validateData(this.txtWrittenResult.getValue(), HRValidation.INT_FLOTING_NUMBER, false);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtWrittenResult).setValid(false);
            error(txtWrittenResult, errorMessage);
        }

        errorValue = HRValidation.validateData(this.txtPresentationResult.getValue(), HRValidation.INT_FLOTING_NUMBER, false);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtPresentationResult).setValid(false);
            error(txtPresentationResult, errorMessage);
        }

        errorValue = HRValidation.validateData(this.txtOtherResult.getValue(), HRValidation.INT_FLOTING_NUMBER, false);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtOtherResult).setValid(false);
            error(txtOtherResult, errorMessage);
        }

        return result;
    }

    private void populateTableBasedRankSaven(Float education, Float exme, Float evaluation, Float exp,
            Float totalExp, Float displi) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void showConformationMsgForPopUps(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);
    }

    public String btnEditAssessmentResult_action() {
        btnUpdateAssessmentResult.setDisabled(false);
        btnEditAssessmentResult.setDisabled(true);
        btnSaveAssessmentResult.setDisabled(true);
        enableAssessmentResult();
        //return null means stay on the same page
        return null;
    }

    public String btnUpdateAssessmentResult_action() {
        if (promotionManager.updatePromotionAssessmentResult(promotionAssessmentId, assessmentResult())) {
            clearAssessmentResult();
            popupPromotionAssessmentResult.setRendered(false);
            this.showSuccessOrFailureMessage(true, "Assessment results has been successfully updated !");

        } else {
            this.showSuccessOrFailureMessage(false, "Error occured while trying to update assessment results !");
        }
//return null means stay on the same page
        return null;
    }

    public String btnAddCommittee_action() {
        return "CommitteeRegistration";
    }

    public void drlCommitteeType_processValueChange(ValueChangeEvent vce) {
        if (!vce.getNewValue().toString().equals("-1")) {
            drlCommittee.setDisabled(false);
            committeeList = committeeRegistrationManager.getAllCommittees(vce.getNewValue().toString());
        } else {
            drlCommittee.setDisabled(true);
        }
    }

    public void drlCommittee_processValueChange(ValueChangeEvent vce) {
        committeeId = Integer.parseInt(vce.getNewValue().toString());
        if (committeeId != -1) {
            committeeMemberLists = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
        } else {
            committeeMemberLists = new ArrayList<CommitteeMemberModel>();
        }
    }

    public String btnSet_action() {
        boolean ckSet = false;
        String[] id = null;
        int i = 0;
        try {
            ArrayList<HashMap> exper = new ArrayList<HashMap>();
            List candidatExp = this.getEmpExperienceModel();
            Iterator<EmployeeExperienceHistroyModel> it = candidatExp.iterator();
            double date = 0;
            double year = 0;
            int munth = 0;
            while (it.hasNext()) {
                EmployeeExperienceHistroyModel canObj = it.next();
                HashMap _list = new HashMap();
                
                if (canObj.isRelated()) {
                    date += StringDateManipulation.compareDateDifference(canObj.getStartDate(), canObj.getEndDate());
                    _list.put("Ex_Id", canObj.getExpID());
                    _list.put("EMPID", canObj.getEmpId());
                    exper.add(_list);
                    i++;
                }
            }
            munth=(int) ((date % 365) / 30);
            year = (date / 365);
            ckSet = promotionManager.saveExp(exper, year);
            promotionManager.saveExper(requester_ID, proRequestId, year);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

