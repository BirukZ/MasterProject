/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.ext.ColumnGroup;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.recruitmentManager.CandidateManager;
import manager.recruitmentManager.CandidateManager.CandidateListForExam;
import manager.recruitmentManager.RecruitmentManager;
import manager.userManagement.SiteSecurityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version FilterCandidateForExam.java
 * @version Created on May 24, 2011, 12:57:26 AM
 * @author 
 */
public class FilterCandidateForExam extends AbstractPageBean {

    DepartmentManage departmentManage = new DepartmentManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean checkCertified = false;
    int noOfCandidates = 0;
    int recruitmentRequestId = -1;
    int committeeId = -1;
    String[] requestInfos;
    public String bachID;
    public String selected;
    public int arrayListSize;
    public String fullName;
    public String batchID;
    public String canID;
    public String userID;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    String sql = "";

    private void _init() throws Exception {
    }
    String batchCodePresentage;
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox choSelCandidate = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoSelCandidate() {
        return choSelCandidate;
    }
  private SelectInputText txtSearchCandidate = new SelectInputText();

    public SelectInputText getTxtSearchCandidate() {
        return txtSearchCandidate;
    }

    public void setTxtSearchCandidate(SelectInputText txtSearchCandidate) {
        this.txtSearchCandidate = txtSearchCandidate;
    }
  
    public void setChoSelCandidate(HtmlSelectBooleanCheckbox hsbc) {
        this.choSelCandidate = hsbc;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
     private RowSelector rowSelectorCommitteeMember = new RowSelector();

      private RowSelector rowSelectorCandidateForExam = new RowSelector();
      
      private RowSelector rowEducationBackGraund = new RowSelector();

    public RowSelector getRowEducationBackGraund() {
        return rowEducationBackGraund;
    }

    public void setRowEducationBackGraund(RowSelector rowEducationBackGraund) {
        this.rowEducationBackGraund = rowEducationBackGraund;
    }


    public RowSelector getRowSelectorCandidateForExam() {
        return rowSelectorCandidateForExam;
    }

    public void setRowSelectorCandidateForExam(RowSelector rowSelectorCandidateForExam) {
        this.rowSelectorCandidateForExam = rowSelectorCandidateForExam;
    }


    public RowSelector getRowSelectorCommitteeMember() {
        return rowSelectorCommitteeMember;
    }

    public void setRowSelectorCommitteeMember(RowSelector rowSelectorCommitteeMember) {
        this.rowSelectorCommitteeMember = rowSelectorCommitteeMember;
    }

    // </editor-fold>=new
    CandidateManager candidateManager = new CandidateManager();
     public List selectedCandidateList = new ArrayList<CandidateManager>();
     public ArrayList<CandidateManager> candidateIdList=new ArrayList<CandidateManager>();
     public ArrayList<CandidateListForExam>candidateListForExam=new ArrayList<CandidateListForExam>();
     public ArrayList<CandidateListForExam>canEducationBackGround=new ArrayList<CandidateListForExam>();
     public ArrayList<CandidateListForExam>canExpirancebackGround=new ArrayList<CandidateListForExam>();
     public ArrayList<CandidateListForExam>finalSelectedCandidate=new ArrayList<CandidateListForExam>();


    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();
    private List recruitRecuestList = new ArrayList<RecruitmentManager>();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    ArrayList<CommitteeMemberModel> committeeMembersList = new ArrayList<CommitteeMemberModel>();
    CandidateListForExam canForExam=new CandidateListForExam();
     int candidateID;
     int newCandidateID;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getBachID() {
        return bachID;
    }

    public void setBachID(String bachID) {
        this.bachID = bachID;
    }

    public ArrayList<CandidateListForExam> getFinalSelectedCandidate() {
        return finalSelectedCandidate;
    }

    public void setFinalSelectedCandidate(ArrayList<CandidateListForExam> finalSelectedCandidate) {
        this.finalSelectedCandidate = finalSelectedCandidate;
    }

    public ArrayList<CandidateListForExam> getCanExpirancebackGround() {
        return canExpirancebackGround;
    }

    public void setCanExpirancebackGround(ArrayList<CandidateListForExam> canExpirancebackGround) {
        this.canExpirancebackGround = canExpirancebackGround;
    }

    public ArrayList<CandidateListForExam> getCanEducationBackGround() {
        return canEducationBackGround;
    }

    public void setCanEducationBackGround(ArrayList<CandidateListForExam> canEducationBackGround) {
        this.canEducationBackGround = canEducationBackGround;
    }

    public ArrayList<CandidateListForExam> getCandidateListForExam() {
        return candidateListForExam;
    }

    public void setCandidateListForExam(ArrayList<CandidateListForExam> candidateListForExam) {
        this.candidateListForExam = candidateListForExam;
    }

    public ArrayList<CandidateManager> getCandidateIdList() {
        return candidateIdList;
    }

    public void setCandidateIdList(ArrayList<CandidateManager> candidateIdList) {
        this.candidateIdList = candidateIdList;
    }

    public int getDeciderCommitteeId() {
        return deciderCommitteeId;
    }

    public void setDeciderCommitteeId(int deciderCommitteeId) {
        this.deciderCommitteeId = deciderCommitteeId;
    }

    public List getRecruitRecuestList() {
        return recruitRecuestList;
    }

    public void setRecruitRecuestList(List recruitRecuestList) {
        this.recruitRecuestList = recruitRecuestList;
    }

    public String[] getRequestInfos() {
        return requestInfos;
    }

    public void setRequestInfos(String[] requestInfos) {
        this.requestInfos = requestInfos;
    }

    public List getSelectedCandidateList() {
        return selectedCandidateList;
    }

    public void setSelectedCandidateList(List selectedCandidateList) {
        this.selectedCandidateList = selectedCandidateList;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public CommitteeMemberRegistrationManager getCommitteeMemberRegistrationManager() {
        return committeeMemberRegistrationManager;
    }

    public void setCommitteeMemberRegistrationManager(CommitteeMemberRegistrationManager committeeMemberRegistrationManager) {
        this.committeeMemberRegistrationManager = committeeMemberRegistrationManager;
    }

    public int getRecruitmentRequestId() {
        return recruitmentRequestId;
    }

    public void setRecruitmentRequestId(int recruitmentRequestId) {
        this.recruitmentRequestId = recruitmentRequestId;
    }

    public SiteSecurityManager getSiteSecurityManager() {
        return siteSecurityManager;
    }

    public int getSelectedCandidateMemberRow() {
        return selectedCandidateMemberRow;
    }

    public void setSelectedCandidateMemberRow(int selectedCandidateMemberRow) {
        this.selectedCandidateMemberRow = selectedCandidateMemberRow;
    }

    public void setSiteSecurityManager(SiteSecurityManager siteSecurityManager) {
        this.siteSecurityManager = siteSecurityManager;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getCanID() {
        return canID;
    }

    public void setCanID(String canID) {
        this.canID = canID;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    int selectedCommitteeMemberRow = -1;
    int selectedCandidateMemberRow=-1;
    int selectedCanMemberRow=-1;
    int selecredEducbackRow=-1;


    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public void rowSelectorCommitteeMember_processMyEvent(RowSelectorEvent rse) {
          selectedCommitteeMemberRow = rse.getRow();
       
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public String getBatchCodePresentage() {
        return batchCodePresentage;
    }

    public void setBatchCodePresentage(String batchCodePresentage) {
        this.batchCodePresentage = batchCodePresentage;
    }

    public CandidateManager getCandidateManager() {
        return candidateManager;
    }

    public void setCandidateManager(CandidateManager candidateManager) {
        this.candidateManager = candidateManager;
    }

    public boolean isCheckCertified() {
        return checkCertified;
    }

    public void setCheckCertified(boolean checkCertified) {
        this.checkCertified = checkCertified;
    }

    public ArrayList<CommitteeMemberModel> getCommitteeMembersList() {
        return committeeMembersList;
    }

    public void setCommitteeMembersList(ArrayList<CommitteeMemberModel> committeeMembersList) {
        this.committeeMembersList = committeeMembersList;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public int getNoOfCandidates() {
        return noOfCandidates;
    }

    public void setNoOfCandidates(int noOfCandidates) {
        this.noOfCandidates = noOfCandidates;
    }

    public RecruitmentManager getRecruitmentManager() {
        return recruitmentManager;
    }

    public void setRecruitmentManager(RecruitmentManager recruitmentManager) {
        this.recruitmentManager = recruitmentManager;
    }

    public int getSelectedCommitteeMemberRow() {
        return selectedCommitteeMemberRow;
    }

    public void setSelectedCommitteeMemberRow(int selectedCommitteeMemberRow) {
        this.selectedCommitteeMemberRow = selectedCommitteeMemberRow;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    private HtmlCommandLink cmdLinkConfirmCommitteeDecisions = new HtmlCommandLink();

    public HtmlCommandLink getCmdLinkConfirmCommitteeDecisions() {
        return cmdLinkConfirmCommitteeDecisions;
    }

    public void setCmdLinkConfirmCommitteeDecisions(HtmlCommandLink hcl) {
        this.cmdLinkConfirmCommitteeDecisions = hcl;
    }
    private HtmlCommandLink cmdLnkClosePopupCommitteeMembers = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkClosePopupCommitteeMembers() {
        return cmdLnkClosePopupCommitteeMembers;
    }

    public void setCmdLnkClosePopupCommitteeMembers(HtmlCommandLink hcl) {
        this.cmdLnkClosePopupCommitteeMembers = hcl;
    }
    private HtmlOutputLabel lblSignInReminder = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSignInReminder() {
        return lblSignInReminder;
    }
    private PanelPopup pnlPopupCommitteeMembers = new PanelPopup();

    public PanelPopup getPnlPopupCommitteeMembers() {
        return pnlPopupCommitteeMembers;
    }

    public void setPnlPopupCommitteeMembers(PanelPopup pp) {
        this.pnlPopupCommitteeMembers = pp;
    }

    public String cmdLnkClosePopupCommitteeMembers_action() {
        cmdLnkClosePopupCommitteeMembers.setRendered(false);
        pnlPopupCommitteeMembers.setRendered(false);
        return null;
    }
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    ArrayList<SelectItem> bachCode = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getBachCode() {
        bachCode = recruitmentManager.readBachCodeBy();
        return bachCode;
    }

    public void setBachCode(ArrayList<SelectItem> bachCode) {
        this.bachCode = bachCode;
    }
//    Option[] bachCode =
//
//    public Option[] getBachCode() {
//        return bachCode;
//    }
//
//    public void setBachCode(Option[] bachCode) {
//        this.bachCode = bachCode;
//    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private HtmlDataTable tblCandidate = new HtmlDataTable();

    public HtmlDataTable getTblCandidate() {
        return tblCandidate;
    }

    public void setTblCandidate(HtmlDataTable hdt) {
        this.tblCandidate = hdt;
    }
    private HtmlCommandButton btnMakeEmployee = new HtmlCommandButton();

    public HtmlCommandButton getBtnMakeEmployee() {
        return btnMakeEmployee;
    }

    public void setBtnMakeEmployee(HtmlCommandButton hcb) {
        this.btnMakeEmployee = hcb;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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
    private HtmlInputText txtWorkExperiance = new HtmlInputText();

    public HtmlInputText getTxtWorkExperiance() {
        return txtWorkExperiance;
    }

    public void setTxtWorkExperiance(HtmlInputText hit) {
        this.txtWorkExperiance = hit;
    }
    private HtmlInputText txtGPA = new HtmlInputText();

    public HtmlInputText getTxtGPA() {
        return txtGPA;
    }

    public void setTxtGPA(HtmlInputText hit) {
        this.txtGPA = hit;
    }
    private PanelPopup pnDisplayCriteria = new PanelPopup();
    private PanelPopup pnDisplayEducationBackGround = new PanelPopup();
    private PanelPopup pnSelectCandidateForExam = new PanelPopup();
    private PanelPopup pnDisplayExpiranceBackGround = new PanelPopup();

    public PanelPopup getPnSelectCandidateForExam() {
        return pnSelectCandidateForExam;
    }

    public void setPnSelectCandidateForExam(PanelPopup pnSelectCandidateForExam) {
        this.pnSelectCandidateForExam = pnSelectCandidateForExam;
    }

    public PanelPopup getPnDisplayExpiranceBackGround() {
        return pnDisplayExpiranceBackGround;
    }

    public void setPnDisplayExpiranceBackGround(PanelPopup pnDisplayExpiranceBackGround) {
        this.pnDisplayExpiranceBackGround = pnDisplayExpiranceBackGround;
    }

    public PanelPopup getPnDisplayEducationBackGround() {
        return pnDisplayEducationBackGround;
    }

    public void setPnDisplayEducationBackGround(PanelPopup pnDisplayEducationBackGround) {
        this.pnDisplayEducationBackGround = pnDisplayEducationBackGround;
    }

    public PanelPopup getPnDisplayCriteria() {
        return pnDisplayCriteria;
    }

    public void setPnDisplayCriteria(PanelPopup pp) {
        this.pnDisplayCriteria = pp;
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
    private HtmlSelectBooleanCheckbox choWorkExperiance = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoWorkExperiance() {
        return choWorkExperiance;
    }

    public void setChoWorkExperiance(HtmlSelectBooleanCheckbox hsbc) {
        this.choWorkExperiance = hsbc;
    }
    private HtmlSelectBooleanCheckbox choByGpa = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoByGpa() {
        return choByGpa;
    }

    public void setChoByGpa(HtmlSelectBooleanCheckbox hsbc) {
        this.choByGpa = hsbc;
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
    private HtmlPanelGroup pnlConfirmationMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlConfirmationMessage() {
        return pnlConfirmationMessage;
    }

    public void setPnlConfirmationMessage(HtmlPanelGroup hpg) {
        this.pnlConfirmationMessage = hpg;
    }
    private HtmlOutputLabel lblFormMessage4 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlSelectBooleanCheckbox choApproved = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoApproved() {
        return choApproved;
    }

    public void setChoApproved(HtmlSelectBooleanCheckbox hsbc) {
        this.choApproved = hsbc;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();
     private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData defaultSelectedData9) {
        this.defaultSelectedData9 = defaultSelectedData9;
    }

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlGender = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlGender() {
        return drlGender;
    }

    public void setDrlGender(HtmlSelectOneMenu hsom) {
        this.drlGender = hsom;
    }
    private HtmlInputText txtGender = new HtmlInputText();

    public HtmlInputText getTxtGender() {
        return txtGender;
    }

    public void setTxtGender(HtmlInputText hit) {
        this.txtGender = hit;
    }
    private HtmlInputText txtAge1 = new HtmlInputText();

    public HtmlInputText getTxtAge1() {
        return txtAge1;
    }

    public void setTxtAge1(HtmlInputText hit) {
        this.txtAge1 = hit;
    }
    private HtmlInputText inputTextAgeValue = new HtmlInputText();

    public HtmlInputText getInputTextAgeValue() {
        return inputTextAgeValue;
    }

    public void setInputTextAgeValue(HtmlInputText hit) {
        this.inputTextAgeValue = hit;
    }
    private HtmlInputText txtAgeRightComp = new HtmlInputText();

    public HtmlInputText getTxtAgeRightComp() {
        return txtAgeRightComp;
    }

    public void setTxtAgeRightComp(HtmlInputText hit) {
        this.txtAgeRightComp = hit;
    }
    private HtmlInputText inputTextAgeValueRight = new HtmlInputText();

    public HtmlInputText getInputTextAgeValueRight() {
        return inputTextAgeValueRight;
    }

    public void setInputTextAgeValueRight(HtmlInputText hit) {
        this.inputTextAgeValueRight = hit;
    }
    private HtmlInputText inputTextNeededNumber = new HtmlInputText();

    public HtmlInputText getInputTextNeededNumber() {
        return inputTextNeededNumber;
    }

    public void setInputTextNeededNumber(HtmlInputText hit) {
        this.inputTextNeededNumber = hit;
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
    private ColumnGroup columnGroup1 = new ColumnGroup();

    public ColumnGroup getColumnGroup1() {
        return columnGroup1;
    }

    public void setColumnGroup1(ColumnGroup cg) {
        this.columnGroup1 = cg;
    }
    private HtmlSelectBooleanCheckbox cboMakeCadidateCertify = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboMakeCadidateCertify() {
        return cboMakeCadidateCertify;
    }

    public void setCboMakeCadidateCertify(HtmlSelectBooleanCheckbox hsbc) {
        this.cboMakeCadidateCertify = hsbc;
    }
    int deciderCommitteeId;

    public String cmdLinkConfirmCommitteeDecisions_action() {
        committeeMembersList = committeeMemberRegistrationManager.getAllCommitteeMembers(deciderCommitteeId);
        lblSignInReminder.setValue("Signin using your username");
        pnlPopupCommitteeMembers.setRendered(true);
        return null;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems = dsi;
    }
    private HtmlSelectOneRadio rdRelation = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRdRelation() {
        return rdRelation;
    }

    public void setRdRelation(HtmlSelectOneRadio hsor) {
        this.rdRelation = hsor;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private DefaultTableDataModel dataTable1Model2 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model2() {
        return dataTable1Model2;
    }

    public void setDataTable1Model2(DefaultTableDataModel dtdm) {
        this.dataTable1Model2 = dtdm;
    }
    private DefaultTableDataModel dataTable1Model3 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model3() {
        return dataTable1Model3;
    }

    public void setDataTable1Model3(DefaultTableDataModel dtdm) {
        this.dataTable1Model3 = dtdm;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkboxCandidate = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkboxCandidate() {
        return chkboxCandidate;
    }

    public void setChkboxCandidate(HtmlSelectBooleanCheckbox hsbc) {
        this.chkboxCandidate = hsbc;
    }
    private HtmlOutputText out_txt_status = new HtmlOutputText();

    public HtmlOutputText getOut_txt_status() {
        return out_txt_status;
    }

    public void setOut_txt_status(HtmlOutputText hot) {
        this.out_txt_status = hot;
    }
    private DefaultTableDataModel dataTable1Model4 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model4() {
        return dataTable1Model4;
    }

    public void setDataTable1Model4(DefaultTableDataModel dtdm) {
        this.dataTable1Model4 = dtdm;
    }
    private HtmlOutputText out_txt_fullName = new HtmlOutputText();

    public HtmlOutputText getOut_txt_fullName() {
        return out_txt_fullName;
    }

    public void setOut_txt_fullName(HtmlOutputText hot) {
        this.out_txt_fullName = hot;
    }
    private HtmlOutputText out_txt_batchCode = new HtmlOutputText();

    public HtmlOutputText getOut_txt_batchCode() {
        return out_txt_batchCode;
    }

    public void setOut_txt_batchCode(HtmlOutputText hot) {
        this.out_txt_batchCode = hot;
    }
    private HtmlCommandButton btn_canForExam = new HtmlCommandButton();

    public HtmlCommandButton getBtn_canForExam() {
        return btn_canForExam;
    }

    public void setBtn_canForExam(HtmlCommandButton hcb) {
        this.btn_canForExam = hcb;
    }

    public FilterCandidateForExam() {
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




        selectedCandidateList.clear();

        noOfCandidates = 0;
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
    CandidateListForExam listforexam =new CandidateListForExam();
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    public void SetCanEducationBackGround(){
   

  

      canEducationBackGround=candidateManager.getAllEducationBack(newCandidateID);

     int size=canEducationBackGround.size();

     if(canEducationBackGround.size()>0)
            {
            canEducationBackGround=candidateManager.getAllEducationBack(newCandidateID);
            pnDisplayEducationBackGround.setRendered(true);
            } else {

            this.showSuccessOrFailureMessage(false, "Education Not Registered");

            }

            }

CandidateListForExam candidateList= new CandidateListForExam();

public void CalculateServiceYear(){
  int year=0;
  int month;
  int day;
  int totalYear=0;

  year=Integer.parseInt(candidateList.getExpYear().toString());
   
  

}
    public void SetCanExpirancebackGround()
        {
       
    canExpirancebackGround =candidateManager.getAllExpiranceBack(newCandidateID);
    arrayListSize=canExpirancebackGround.size();
    if(arrayListSize>0)
           {
        
     canExpirancebackGround=candidateManager.getAllExpiranceBack(newCandidateID);
       
     
     pnDisplayExpiranceBackGround.setRendered(true);
            }

    else {

         this.showSuccessOrFailureMessage(false, "Expirance Not Registered");

         }

            }




    public void selectOneMenu1_processValueChange(ValueChangeEvent vce) {
        this.selectedCandidateList.clear();
        btn_canForExam.setDisabled(false);
        if (vce.getNewValue() != null) {
            int numberofCan = 0;
            int count = 0;
            float cgpa = 1;
            boolean certify = true;
            float practicalCgpa = 1;
            requestInfos = vce.getNewValue().toString().split("--");
            Integer.parseInt(requestInfos[1]);
            recruitmentRequestId = Integer.parseInt(requestInfos[1]);
            bachID=requestInfos[0];
            requestInfos(requestInfos[1]);
        
            candidateListForExam=candidateManager.getAllCandidateForExam(bachID);

             int size=candidateListForExam.size();
            
             if(candidateListForExam.size()>0)
            {
            candidateListForExam=candidateManager.getAllCandidateForExam(bachID);
         
            } else {

            this.showSuccessOrFailureMessage(false, "Candidate Not Registerd For This Post" );


            }
        

        
    }
    }

    public String numberFormatChecker(String inputNumber) {//ሠ/10
        String patternNumber = "^?[0-9]+(\\.[0-9]+)?$";
        boolean matchStringText = Pattern.matches(patternNumber, (CharSequence) (inputNumber.toString().subSequence(0, inputNumber.length())));
        if (matchStringText == true) {
            return "match";
        } else {
            return "Invalid number Format";
        }



    }

    public String setCriteria(){

    //String batchID;
    String cgpa = "";
    String gender="";
    String workExp="";
    String NeededNo="";
    String ageMin="";
    String ageMax="";
    String orderBy="";
    int  candidateNo;

     if (inputTextNeededNumber.getValue() != null && !inputTextNeededNumber.getValue().toString().equals("")) {
            NeededNo = numberFormatChecker(inputTextNeededNumber.getValue().toString());
            if (NeededNo.equals("match"))
            {
                noOfCandidates = Integer.valueOf(inputTextNeededNumber.getValue().toString());
            } else {
                    this.showSuccessOrFailureMessage(false, "Please Inter Valid Number Under Required Filed" );
                }
        }
            if (!txtGender.getValue().toString().equals("") &&
                !txtWorkExperiance.getValue().toString().equals("") &&
                !txtGPA.getValue().toString().equals("") &&
                !inputTextAgeValue.getValue().toString().equals("")&&
                !inputTextAgeValueRight.getValue().toString().equals(""))
        {
            gender = txtGender.getValue().toString();
            workExp = txtWorkExperiance.getValue().toString();
            cgpa = txtGPA.getValue().toString();
            ageMin = inputTextAgeValue.getValue().toString();
            ageMax=inputTextAgeValueRight.getValue().toString();
            //batchID
            }
    if(choWorkExperiance.isSelected()){

    orderBy="1";


    }else if(choByGpa.isSelected()){

    orderBy="2";

    }
                 else {
                    this.showSuccessOrFailureMessage(false,  " Please Enter The Value");
                }


        int result=  candidateManager.SetCriteraOfSelection(bachID,cgpa,gender,workExp,noOfCandidates,ageMin,ageMax,orderBy);

if(result==1){

this.showSuccessOrFailureMessage(true,  " Critera Set");


}else{

this.showSuccessOrFailureMessage(false,  " Pls Try Agien Critera is Not Set");
}
      return null;

    }

    public String setSelectdValue() {
        //return null means stay on the same page
        String num = "";
        String todayInEc = dateFormat.format(new Date());
        String val1 = "";
        String val2 = "";
        String val3 = "";
        String val4 = "";
        sql = "";
        noOfCandidates = 0;
        if (inputTextNeededNumber.getValue() != null && !inputTextNeededNumber.getValue().toString().equals("")) {
            num = numberFormatChecker(inputTextNeededNumber.getValue().toString());
            if (num.equals("match")) {

                noOfCandidates = Integer.valueOf(inputTextNeededNumber.getValue().toString());
            } else {
//                    this.showSuccessOrFailureMessage(false, num );
                }
        }
        if (!txtWorkExperiance.getValue().equals("")) {
            sql += "  AND  CA.EXPERIENCE > " + txtWorkExperiance.getValue().toString() + "";
        }

        if (!txtGender.getValue().equals("")) {
            sql += "  AND  CA.GENDER = '" + txtGender.getValue().toString() + "'";
        }
        if (!txtGPA.getValue().equals("")) {
            sql += "  AND  CA.CGPA > " + txtGPA.getValue() + "";
        }
        if (rdRelation.getValue() != null) {
            sql += " AND  CX.EXP_RELATION_TYPE = '" + rdRelation.getValue().toString() + "'";
        }
        if (!txtAge1.getValue().toString().equals("") &&
                !inputTextAgeValue.getValue().toString().equals("") &&
                !txtAgeRightComp.getValue().toString().equals("") &&
                !inputTextAgeValueRight.getValue().toString().equals(""))
        {
            val1 = txtAge1.getValue().toString();
            val2 = inputTextAgeValue.getValue().toString();
            val3 = txtAgeRightComp.getValue().toString();
            val4 = inputTextAgeValueRight.getValue().toString();
            if (txtAge1.getValue().equals("<") || txtAge1.getValue().equals(">") || txtAge1.getValue().equals("=")) {
                num = numberFormatChecker(inputTextAgeValue.getValue().toString());
                if (num.equals("match")) {
                    if (txtAgeRightComp.getValue().equals("<") || txtAgeRightComp.getValue().equals(">") || txtAgeRightComp.getValue().equals("=")) {
                        num = numberFormatChecker(inputTextAgeValueRight.getValue().toString());
                        if (num.equals("match")) {
                            sql += " AND  ((TO_NUMBER(SUBSTR(('" + todayInEc + "'),1,4)) - TO_NUMBER(SUBSTR(DATEOFBIRTH, 1,4)) " + val1 + " '" + val2 + "' )) " +
                                    " AND ((TO_NUMBER(SUBSTR(('" + todayInEc + "'),1,4)) - TO_NUMBER(SUBSTR(DATEOFBIRTH, 1,4)) " + val3 + " '" + val4 + "' )) ";
                        } else {
                            this.showSuccessOrFailureMessage(false, num + " on the fourth text box.");
                        }
                    } else {
                        this.showSuccessOrFailureMessage(false, "Invalid comparison on the third text box.");
                    }
                } else {
                    this.showSuccessOrFailureMessage(false, num + " on the second text box.");
                }
            } else {
                this.showSuccessOrFailureMessage(false, "Invalid comparison on the first text box.");
            }
        }

        else if (!txtAge1.getValue().toString().equals("") && !inputTextAgeValue.getValue().toString().equals("") && txtAgeRightComp.getValue().toString().equals("") && inputTextAgeValueRight.getValue().toString().equals("")) {
            val1 = txtAge1.getValue().toString();
            val2 = inputTextAgeValue.getValue().toString();
            if (txtAge1.getValue().equals("<") || txtAge1.getValue().equals(">") || txtAge1.getValue().equals("=")) {
                num = numberFormatChecker(inputTextAgeValue.getValue().toString());
                if (num.equals("match")) {
                    sql += " AND  ((TO_NUMBER(SUBSTR(('" + todayInEc + "'),1,4)) - TO_NUMBER(SUBSTR(DATEOFBIRTH, 1,4)) " + val1 + " '" + val2 + "' )) ";
                } else {
                    this.showSuccessOrFailureMessage(false, num + " on the second text box.");
                }
            } else {
                this.showSuccessOrFailureMessage(false, "Invalid comparison on the first text box.");
            }
        } else if (txtAge1.getValue().toString().equals("") && inputTextAgeValue.getValue().toString().equals("") && !txtAgeRightComp.getValue().toString().equals("") && !inputTextAgeValueRight.getValue().toString().equals("")) {
            val3 = txtAgeRightComp.getValue().toString();
            val4 = inputTextAgeValueRight.getValue().toString();
            if (txtAgeRightComp.getValue().equals("<") || txtAgeRightComp.getValue().equals(">") || txtAgeRightComp.getValue().equals("=")) {
                num = numberFormatChecker(inputTextAgeValueRight.getValue().toString());
                if (num.equals("match")) {
                    sql += " AND ((TO_NUMBER(SUBSTR(('" + todayInEc + "'),1,4)) - TO_NUMBER(SUBSTR(DATEOFBIRTH, 1,4)) " + val3 + " '" + val4 + "' )) ";

                } else {
                    this.showSuccessOrFailureMessage(false, num + " on the fourth text box.");
                }
            } else {
                this.showSuccessOrFailureMessage(false, "Invalid comparison on the third text box.");
            }

        } else if (txtAge1.getValue().toString().equals("") && inputTextAgeValue.getValue().toString().equals("") && txtAgeRightComp.getValue().toString().equals("") && !inputTextAgeValueRight.getValue().toString().equals("")) {
            this.showSuccessOrFailureMessage(false, " Invalid Creiteria");

        } else if (txtAge1.getValue().toString().equals("") && inputTextAgeValue.getValue().toString().equals("") && !txtAgeRightComp.getValue().toString().equals("") && inputTextAgeValueRight.getValue().toString().equals("")) {
            this.showSuccessOrFailureMessage(false, " Invalid Creiteria");

        } else {
        }
        if (choWorkExperiance.isSelected()) {
            sql += " order by EXPERIENCE desc";
        }
        if (choByGpa.isSelected()) {
            sql += " order by CGPA desc";
        }
        pnDisplayCriteria.setRendered(false);

        return null;
    }

    public void button1_processAction(ActionEvent ae) {
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

    public String btnSortCriteria_action() {
        //return null means stay on the same page

        return null;
    }

    public String modalPnlCloseDisplayCriteria_action() {
        pnDisplayCriteria.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseEducationBackGround_action() {
        pnDisplayEducationBackGround.setRendered(false);
        //return null means stay on the same page
        return null;
    }
     public String modalPnlCloseCandidateForExam_action() {
        pnSelectCandidateForExam.setRendered(false);
        //return null means stay on the same page
        return null;
    }

     public String modalPnlCloseExpiranceBackGround_action() {
        pnDisplayExpiranceBackGround.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSet_action() {
       // setSelectdValue();
          setCriteria();

        //return null means stay on the same page
        return null;
    }

    public void choWorkExperiance_processValueChange(ValueChangeEvent vce) {
        choByGpa.setSelected(false);
    }

    public void choByGpa_processValueChange(ValueChangeEvent vce) {
        choWorkExperiance.setSelected(false);

    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String cmdSetDisplayCriteria_action() {
        pnDisplayCriteria.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String cmdPrepare_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupCommitteeMembers_action() {
        if (isEnoughCommitteeNumbersSigned()) {
            pnlPopupCommitteeMembers.setRendered(false);
//            pnlPopupSuccessOrFailure.setRendered(false);
        }
        return null;
    }

    public boolean isEnoughCommitteeNumbersSigned() {
        int counterCheck = 0;
        int totalSize = committeeMembersList.size();
        for (CommitteeMemberModel current : committeeMembersList) {
            if (current.getLogInConfirmed() != null && current.getLogInConfirmed().equals("Confirmed")) {
                counterCheck++;
            }
        }
        if ((counterCheck == 0) || (totalSize / counterCheck >= 2)) {//less than or equal to 50% confirmed
            lblSignInReminder.setValue("Note: It can not be approved now." +
                    " Only " + counterCheck + " out of " + totalSize + " confirmed. ");
            cmdLnkClosePopupCommitteeMembers.setRendered(true);
            return false;
        } else {//if more than 50% confirmed

//            enableDiscionComponents();
            try {
                if (candidateManager.selectCandidate(readApprovedCandidateList(), getSessionBean1().getEmpDeptId(), recruitmentRequestId)) {
                    btnSave.setDisabled(true);
                    showSuccessOrFailureMessage(true, "The Candidate Information Approved Successfully!");
                } else {
                    showSuccessOrFailureMessage(false, "The Candidate Information Not Approved.Please try agin?");
                }
                lblSignInReminder.setValue("Note: Greater than 50% approved." +
                        " Only " + counterCheck + " out of " + totalSize + " confirmed. ");
            } catch (Exception e) {
            }
            return true;
        }
    }

//    public String btnPopupForColumnMemberLogIn_action() {
//        try {
//            if (selectedCommitteeMemberRow != -1)
//            {
//                String memberEmployeeId = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeId();
//                String memberUserName = committeeMembersList.get(selectedCommitteeMemberRow).getUserName();
//                String memberPassWord = committeeMembersList.get(selectedCommitteeMemberRow).getPassWord();
//                if (siteSecurityManager.isValidUser(memberUserName, memberPassWord, memberEmployeeId)) {
//                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Confirmed");
//                } else {
//                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Invalid");
//                }
//            }
//        } catch (NullPointerException npe) {
//        }
//        return null;
//    }
     public String btnPopupForColumnMemberLogIn_actionForFinalRecuritment() {
        try {
            if (selectedCommitteeMemberRow != -1)
            {
                String memberEmployeeId = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeId();
                String memberUserName = committeeMembersList.get(selectedCommitteeMemberRow).getUserName();
                String memberPassWord = committeeMembersList.get(selectedCommitteeMemberRow).getPassWord();
                if (siteSecurityManager.isValidUser(memberUserName, memberPassWord, memberEmployeeId)) {
                   
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Confirmed");
                    recruitmentManager.UpdateCandidateBeforExam(candidateID);
                } else {
                   
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Invalid");
                }
            }
        } catch (NullPointerException npe) {
        }
        return null;
    }

     private ArrayList<CandidateListForExam> readSelectedCandidateForExamList()
     {

      try {
          int size= candidateListForExam.size();
         ArrayList<CandidateListForExam> candidateforExam = new ArrayList<CandidateListForExam>();
            for(int counter=0;counter<size;counter++)
              {
          if(candidateListForExam.get(counter).getStatus().equalsIgnoreCase("Selected"))
                    {
                String canID=candidateListForExam.get(selecredEducbackRow).getCandidateID().toString();
                String candidateName=candidateListForExam.get(selecredEducbackRow).getCandidateName().toString();
                String candidateSex=candidateListForExam.get(selecredEducbackRow).getSex().toString();
                String batch=bachID;
                String status="Selected";
                candidateforExam.add(new CandidateListForExam(canID,candidateName,candidateSex,batch,status));
                    }

                }

            return candidateforExam;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



     }

    private ArrayList<HashMap> readApprovedCandidateList()
    {
        try {
         ArrayList<HashMap> candidateInfo = new ArrayList<HashMap>();

            if(selected.equalsIgnoreCase("Yes"))
             {
              HashMap _list = new HashMap();
             _list.put("CandidateID", candidateListForExam.get(selecredEducbackRow).getCandidateID());
             _list.put("CandidateName", candidateListForExam.get(selecredEducbackRow).getCandidateName());
             _list.put("Gender", candidateListForExam.get(selecredEducbackRow).getSex());
             _list.put("Batch", bachID);
              candidateInfo.add(_list);
              }
     
            return candidateInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String btnSave_action() {

        committeeId = recruitmentManager.readCommitteeId(recruitmentRequestId);
        committeeMembersList = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
       //  pnlPopupCommitteeMembers.setRendered(true);
       readSelectedCandidateForExamList();
       int size =candidateListForExam.size();
       if(size >0)
       {

       boolean savedStatus=candidateManager.SaveCandidateForExam(candidateListForExam);
       if(savedStatus)
       {

        showSuccessOrFailureMessage(true, "The Candidate Status Updated Successfully!");

       }else
       {

       showSuccessOrFailureMessage(false, "Sorry  Candidate Selection Failed Pls Try Agien ");

       }
       }else{
       showSuccessOrFailureMessage(false, "Pls Select Candidate For Exam  ");

       }
       
       return null;
    }

     public String cmdViewExpiranceBackGround_action() {
        //return null means stay on the same page
         this.SetCanExpirancebackGround();

            return null;
    }

      public String cmdViewEnducationBackGround_action() {
        //return null means stay on the same page
          this.SetCanEducationBackGround();
          
        return null;
    }
    public String btnReset_action() {
        //return null means stay on the same page
        return null;
    }

    private void requestInfos(String recruitmentRequestId) {
        try {

            HashMap[] recruitRequestList = recruitmentManager.readSingleRecRequest(recruitmentRequestId);
             
            for (int i = 0; i < recruitRequestList.length; i++)
            {
               RecruitmentManager addToTable = new RecruitmentManager(recruitRequestList[i].get("REQUESTER_ID").toString(),
                        recruitRequestList[i].get("RECRUIT_REQUEST_REF_DATE").toString(),
                        recruitRequestList[i].get("JOB_NAME").toString(),
                        recruitRequestList[i].get("NUM_OF_EMPS").toString(),
                        recruitRequestList[i].get("RECRUIT_REQUEST_TYPE").toString(),
                        recruitRequestList[i].get("REMARK").toString(),
                        recruitRequestList[i].get("QUALIFICATION").toString(),
                        recruitRequestList[i].get("EDUCATION_LEVEL").toString(),
                        recruitRequestList[i].get("MIN_EXPERIENCE").toString(),
                        recruitRequestList[i].get("MIN_RESPONSIBILITY").toString(),
                        recruitRequestList[i].get("ADDITIONALSKILL").toString(),
                        recruitRequestList[i].get("JOB_CODE").toString(),
                        recruitRequestList[i].get("RECRUIT_REQUEST_ID").toString(),
                        recruitRequestList[i].get("DEPARTMENT_ID").toString(), "", "");
                this.recruitRecuestList.add(addToTable);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
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

    public void rowSelectorExamMember_processMyEvent(RowSelectorEvent rse)
    {
        selectedCandidateMemberRow=rse.getRow();
        candidateID=Integer.parseInt(candidateIdList.get(selectedCandidateMemberRow).getCanidateId());
       
    }

     public void rowSelectorCandidateMember_processMyEvent(RowSelectorEvent rse)
    {

        selecredEducbackRow=rse.getRow();
        newCandidateID=Integer.parseInt(candidateListForExam.get(selecredEducbackRow).getCandidateID());

    }


     String candidateId;

    public String txtSearchCandidate_action() {
        //return null means stay on the same page
        try {


            candidateId = ApplicationBean1.getSelectedEmployeeId();

            if (candidateId != null) {

                HashMap candidateListName = candidateManager.selectCandidate(ApplicationBean1.getSelectedEmployeeId());

                if (candidateListName != null) {

                    out_txt_fullName.setValue(candidateListName.get("CANDIDATE_F_NAME")+" "+candidateListName.get("CANDIDATE_M_NAME")+" "+candidateListName.get("CANDIDATE_L_NAME"));
                    out_txt_batchCode.setValue(bachID);


                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public String cmd_Select_candidate_action() {
        //return null means stay on the same page
       String cribatchId;
       String cricgpa;
       String criworkexp;
       String crigender;
       String crineededNo;
       String criageMin;
       String criageMax;
       String criorderBY;
       HashMap selectCritireaParm=candidateManager.SelectFiliterCritirea(bachID);
       cribatchId=selectCritireaParm.get("bachID").toString();
       cricgpa=selectCritireaParm.get("cgpa").toString();
       criworkexp=selectCritireaParm.get("workexp").toString();
       crigender=selectCritireaParm.get("gender").toString();
       crineededNo=selectCritireaParm.get("needNO").toString();
       criageMin=selectCritireaParm.get("agemin").toString();
       criageMax=selectCritireaParm.get("criageMax").toString();
       criorderBY=selectCritireaParm.get("orderBy").toString();

      HashMap selectFinalCandidate=candidateManager.SelectFinalCandidate(cribatchId,cricgpa,criworkexp,crigender,crineededNo,criageMin,criageMax,criorderBY);
       
        return null;
    }

    public String btn_canForExam_action() {
        //return null means stay on the same page
        pnSelectCandidateForExam.setRendered(true);
        return null;
    }

    public String button2_action() {
        //return null means stay on the same page

       fullName=out_txt_fullName.getValue().toString();
        batchID=out_txt_batchCode.getValue().toString();
        canID=candidateId;
        userID=candidateId;

        finalSelectedCandidate.add(new CandidateListForExam(fullName,canID,batchID,candidateId));

        return null;
    }

    public String button3_action() {
        //return null means stay on the same page
    boolean result= candidateManager.PusheCandidateForExam(finalSelectedCandidate);
    if(result){

    showSuccessOrFailureMessage(true, "The Candidate Pushe to Exam  Successfully!");

    }else{

    showSuccessOrFailureMessage(false, "The Candidate Pushe to Exam Not Successfully Pls Try Agien!");
    }
        return null;
    }

  

  

   
}

