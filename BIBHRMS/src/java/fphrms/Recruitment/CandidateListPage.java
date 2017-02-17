/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.regex.Pattern;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HRValidation;
import manager.recruitmentManager.CandidateExperienceManager;
import manager.recruitmentManager.CandidateManager;
import manager.recruitmentManager.RecruitmentManager;
import manager.userManagement.SiteSecurityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CandidateListPage extends AbstractPageBean {

    DepartmentManage departmentManage = new DepartmentManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    boolean checkApproved = false;
    boolean checkCertified = false;
    boolean callMeOnece = true;
    private int totalPersentage = 0;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    String sql = "";

    private void _init() throws Exception
    {
//        if (callMeOnece) {
//            userRole();
//            callMeOnece = false;
//        }

    }
    String batchCodePresentage;
    private UIColumn column2 = new UIColumn();

    public UIColumn getColumn2() {
        return column2;
    }

    public void setColumn2(UIColumn uic) {
        this.column2 = uic;
    }
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

    // </editor-fold>=new
    CandidateManager candidateManager = new CandidateManager();
    public List selectedCandidateList = new ArrayList<CandidateManager>();
    private List recruitRecuestList = new ArrayList<RecruitmentManager>();
    private List recruitCandidateList = new ArrayList<CandidateManager>();
    private ArrayList<CandidateManager> recruitCandidateListBiruk = new ArrayList<CandidateManager>();
    private ArrayList<CandidateManager> lastSelectedCandiate=new ArrayList<CandidateManager>();
    public ArrayList<CandidateManager> candidateIdList=new ArrayList<CandidateManager>();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    ArrayList<CommitteeMemberModel> committeeMembersList = new ArrayList<CommitteeMemberModel>();
    ArrayList<SelectItem> CandidateNameList = new ArrayList<SelectItem>();
    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();
    int recruitmentRequestId = -1;
    int committeeId = -1;

    String[] requestInfos;
    String relationType = null;
    public  String  canID;
    public String  fullName;

    public String getCanID() {
        return canID;
    }

    public ArrayList<CandidateManager> getLastSelectedCandiate() {
        return lastSelectedCandiate;
    }

    public void setLastSelectedCandiate(ArrayList<CandidateManager> lastSelectedCandiate) {
        this.lastSelectedCandiate = lastSelectedCandiate;
    }

    public void setCanID(String canID) {
        this.canID = canID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<SelectItem> getCandidateNameList() {
        return CandidateNameList;
    }

    public void setCandidateNameList(ArrayList<SelectItem> CandidateNameList) {
        this.CandidateNameList = CandidateNameList;
    }

    public ArrayList<CandidateManager> getCandidateIdList() {
        return candidateIdList;
    }

    public void setCandidateIdList(ArrayList<CandidateManager> candidateIdList) {
        this.candidateIdList = candidateIdList;
    }

    public ArrayList<CandidateManager> getRecruitCandidateListBiruk() {
        return recruitCandidateListBiruk;
    }

    public void setRecruitCandidateListBiruk(ArrayList<CandidateManager> recruitCandidateListBiruk) {
        this.recruitCandidateListBiruk = recruitCandidateListBiruk;
    }

     public int candidateID;

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public List getRecruitRecuestList() {
        return recruitRecuestList;
    }

    public void setRecruitRecuestList(List recruitRecuestList) {
        this.recruitRecuestList = recruitRecuestList;
    }
    private PanelPopup pnlPopupCommitteeMembers = new PanelPopup();

    public PanelPopup getPnlPopupCommitteeMembers() {
        return pnlPopupCommitteeMembers;
    }

    public void setPnlPopupCommitteeMembers(PanelPopup pp) {
        this.pnlPopupCommitteeMembers = pp;
    }
    private HtmlCommandLink cmdLnkClosePopupCommitteeMembers = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkClosePopupCommitteeMembers() {
        return cmdLnkClosePopupCommitteeMembers;
    }

    public void setCmdLnkClosePopupCommitteeMembers(HtmlCommandLink hcl) {
        this.cmdLnkClosePopupCommitteeMembers = hcl;
    }

    public ArrayList<CommitteeMemberModel> getCommitteeMembersList() {
        return committeeMembersList;
    }

    public void setCommitteeMembersList(ArrayList<CommitteeMemberModel> committeeMembersList) {
        this.committeeMembersList = committeeMembersList;
    }

    public SiteSecurityManager getSiteSecurityManager() {
        return siteSecurityManager;
    }

    public void setSiteSecurityManager(SiteSecurityManager siteSecurityManager) {
        this.siteSecurityManager = siteSecurityManager;
    }
    private HtmlOutputLabel lblSignInReminder = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSignInReminder() {
        return lblSignInReminder;
    }

    public String btnPopupForColumnMemberLogIn_action() {
        try {
            if (selectedCommitteeMemberRow != -1) {
                String memberEmployeeId = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeId();
                String memberUserName = committeeMembersList.get(selectedCommitteeMemberRow).getUserName();
                String memberPassWord = committeeMembersList.get(selectedCommitteeMemberRow).getPassWord();
                if (siteSecurityManager.isValidUser(memberUserName, memberPassWord, memberEmployeeId)) {
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Confirmed");
                } else {
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Invalid");
                }
            }
        } catch (NullPointerException npe) {
        }
        return null;
    }
      public String btnPopupForColumnMemberLogIn_actionForFinalRecuritment() {
        try {
            if (selectedCommitteeMemberRow != -1) {
                String memberEmployeeId = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeId();
                String memberUserName = committeeMembersList.get(selectedCommitteeMemberRow).getUserName();
                String memberPassWord = committeeMembersList.get(selectedCommitteeMemberRow).getPassWord();
                if (siteSecurityManager.isValidUser(memberUserName, memberPassWord, memberEmployeeId)) {
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Confirmed");
                    recruitmentManager.UpdateCandidate(candidateID);
                } else {
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Invalid");
                }
            }
        } catch (NullPointerException npe) {
        }
        return null;
    }
    int selectedCommitteeMemberRow = -1;
    int selectedlastCandidte=-1;

    public void rowSelectorCommitteeMember_processMyEvent(RowSelectorEvent rse) {
        boolean check=false;
         cboMakeCadidateCertify.setDisabled(false);
         select=true;
         selectedCommitteeMemberRow = rse.getRow();
         candidateManager.setPass(true);
         candidateID= (recruitCandidateListBiruk.get(selectedCommitteeMemberRow).getCandidateID());
         recruitCandidateListBiruk.get(selectedCommitteeMemberRow).setPass(select);

         if(candidateManager.isPass())
         {
         cboMakeCadidateCertify.setSelected(true);
         lastSelectedCandiate.add(new CandidateManager(candidateID,recruitCandidateListBiruk.get(selectedCommitteeMemberRow).getFullName(),recruitCandidateListBiruk.get(selectedCommitteeMemberRow).getTotalResult(),check,recruitCandidateListBiruk.get(selectedCommitteeMemberRow).getBatchCode()));
         }
         

        
    }

        public void rowSelectorLastCandidateSelection_processMyEvent(RowSelectorEvent rse) {
         btnApprove.setDisabled(false);
         selectedlastCandidte = rse.getRow();
         candidateManager.setPass(true);
         candidateID= (lastSelectedCandiate.get(selectedlastCandidte).getCandidateID());

    }

    public List getSelectedCandidateList() {
        return selectedCandidateList;
    }

    public void setSelectedCandidateList(List selectedCandidateList) {
        this.selectedCandidateList = selectedCandidateList;
    }
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    ArrayList<SelectItem> bachCode = new ArrayList<SelectItem>();
    ArrayList<SelectItem> bachCodeBiruk = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getBachCodeBiruk()
    {
          bachCodeBiruk = recruitmentManager.readBachCodeBySelectOld();
        return bachCodeBiruk;
    }

    public void setBachCodeBiruk(ArrayList<SelectItem> bachCodeBiruk) {
        this.bachCodeBiruk = bachCodeBiruk;
    }

    public ArrayList<SelectItem> getBachCode() {
        bachCode = recruitmentManager.readBachCodeBySelect();
        return bachCode;
    }

    public void setBachCode(ArrayList<SelectItem> bachCode) {
        this.bachCode = bachCode;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private HtmlSelectBooleanCheckbox cboMakeEmployee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboMakeEmployee() {
        return cboMakeEmployee;
    }

    public void setCboMakeEmployee(HtmlSelectBooleanCheckbox hsbc) {
        this.cboMakeEmployee = hsbc;
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
    private HtmlCommandButton btnSavePersentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnSavePersentage() {
        return btnSavePersentage;
    }

    public void setBtnSavePersentage(HtmlCommandButton hcb) {
        this.btnSavePersentage = hcb;
    }
    private HtmlCommandButton btnEditPersentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditPersentage() {
        return btnEditPersentage;
    }

    public void setBtnEditPersentage(HtmlCommandButton hcb) {
        this.btnEditPersentage = hcb;
    }
    private HtmlCommandButton btnUpdatePersentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdatePersentage() {
        return btnUpdatePersentage;
    }

    public void setBtnUpdatePersentage(HtmlCommandButton hcb) {
        this.btnUpdatePersentage = hcb;
    }
    private HtmlCommandButton btnDeletePersentage = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeletePersentage() {
        return btnDeletePersentage;
    }

    public void setBtnDeletePersentage(HtmlCommandButton hcb) {
        this.btnDeletePersentage = hcb;
    }
    private HtmlInputText txtInterviewPersentage = new HtmlInputText();

    public HtmlInputText getTxtInterviewPersentage() {
        return txtInterviewPersentage;
    }

    public void setTxtInterviewPersentage(HtmlInputText hit) {
        this.txtInterviewPersentage = hit;
    }
    private HtmlInputText txtPracticalPersentage = new HtmlInputText();

    public HtmlInputText getTxtPracticalPersentage() {
        return txtPracticalPersentage;
    }

    public void setTxtPracticalPersentage(HtmlInputText hit) {
        this.txtPracticalPersentage = hit;
    }
    private HtmlInputText txtOtherPercentage = new HtmlInputText();

    public HtmlInputText getTxtOtherPercentage() {
        return txtOtherPercentage;
    }

    public void setTxtOtherPercentage(HtmlInputText hit) {
        this.txtOtherPercentage = hit;
    }
    private HtmlSelectOneMenu drlPersentageBatchCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPersentageBatchCode() {
        return drlPersentageBatchCode;
    }

    public void setDrlPersentageBatchCode(HtmlSelectOneMenu hsom) {
        this.drlPersentageBatchCode = hsom;
    }
    private HtmlInputText txtWrittenPersentage = new HtmlInputText();

    public HtmlInputText getTxtWrittenPersentage() {
        return txtWrittenPersentage;
    }

    public void setTxtWrittenPersentage(HtmlInputText hit) {
        this.txtWrittenPersentage = hit;
    }
    private PanelPopup pnCriteria = new PanelPopup();

    public PanelPopup getPnCriteria() {
        return pnCriteria;
    }

    public void setPnCriteria(PanelPopup pp) {
        this.pnCriteria = pp;
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
    private HtmlSelectBooleanCheckbox choThewrittenexamtaken = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoThewrittenexamtaken() {
        return choThewrittenexamtaken;
    }

    public void setChoThewrittenexamtaken(HtmlSelectBooleanCheckbox hsbc) {
        this.choThewrittenexamtaken = hsbc;
    }
    private HtmlSelectBooleanCheckbox choTheInterviewexamtaken = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoTheInterviewexamtaken() {
        return choTheInterviewexamtaken;
    }

    public void setChoTheInterviewexamtaken(HtmlSelectBooleanCheckbox hsbc) {
        this.choTheInterviewexamtaken = hsbc;
    }
    private HtmlSelectBooleanCheckbox chotxtPracticaleExameTaken = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChotxtPracticaleExameTaken() {
        return chotxtPracticaleExameTaken;
    }

    public void setChotxtPracticaleExameTaken(HtmlSelectBooleanCheckbox hsbc) {
        this.chotxtPracticaleExameTaken = hsbc;
    }
    private HtmlInputText txtPracticalResultGreaterThan = new HtmlInputText();

    public HtmlInputText getTxtPracticalResultGreaterThan() {
        return txtPracticalResultGreaterThan;
    }

    public void setTxtPracticalResultGreaterThan(HtmlInputText hit) {
        this.txtPracticalResultGreaterThan = hit;
    }
    private HtmlInputText txtWrittenExamResultGreaterThan = new HtmlInputText();

    public HtmlInputText getTxtWrittenExamResultGreaterThan() {
        return txtWrittenExamResultGreaterThan;
    }

    public void setTxtWrittenExamResultGreaterThan(HtmlInputText hit) {
        this.txtWrittenExamResultGreaterThan = hit;
    }
    private HtmlInputText txtInterviewResult = new HtmlInputText();

    public HtmlInputText getTxtInterviewResult() {
        return txtInterviewResult;
    }

    public void setTxtInterviewResult(HtmlInputText hit) {
        this.txtInterviewResult = hit;
    }
    private HtmlInputText txtGPA = new HtmlInputText();

    public HtmlInputText getTxtGPA() {
        return txtGPA;
    }

    public void setTxtGPA(HtmlInputText hit) {
        this.txtGPA = hit;
    }
    private PanelPopup pnDisplayCriteria = new PanelPopup();

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
    private HtmlSelectBooleanCheckbox choExamResult = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoExamResult() {
        return choExamResult;
    }

    public void setChoExamResult(HtmlSelectBooleanCheckbox hsbc) {
        this.choExamResult = hsbc;
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
    private com.icesoft.faces.component.ext.HtmlOutputLabel stxtAppJobPosition = new com.icesoft.faces.component.ext.HtmlOutputLabel();

    public com.icesoft.faces.component.ext.HtmlOutputLabel getStxtAppJobPosition() {
        return stxtAppJobPosition;
    }

    public void setStxtAppJobPosition(com.icesoft.faces.component.ext.HtmlOutputLabel hol) {
        this.stxtAppJobPosition = hol;
    }
    private com.icesoft.faces.component.ext.HtmlOutputLabel stxtCertJobPosition = new com.icesoft.faces.component.ext.HtmlOutputLabel();

    public com.icesoft.faces.component.ext.HtmlOutputLabel getStxtCertJobPosition() {
        return stxtCertJobPosition;
    }

    public void setStxtCertJobPosition(com.icesoft.faces.component.ext.HtmlOutputLabel hol) {
        this.stxtCertJobPosition = hol;
    }
    private HtmlCommandButton btnApprove = new HtmlCommandButton();

    public HtmlCommandButton getBtnApprove() {
        return btnApprove;
    }

    public void setBtnApprove(HtmlCommandButton hcb) {
        this.btnApprove = hcb;
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
    private HtmlSelectBooleanCheckbox choCertified = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoCertified() {
        return choCertified;
    }

    public void setChoCertified(HtmlSelectBooleanCheckbox hsbc) {
        this.choCertified = hsbc;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private HtmlSelectBooleanCheckbox cboMakeCadidateCertify = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboMakeCadidateCertify() {
        return cboMakeCadidateCertify;
    }

    public void setCboMakeCadidateCertify(HtmlSelectBooleanCheckbox hsbc) {
        this.cboMakeCadidateCertify = hsbc;
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
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private HtmlInputText txtAge1 = new HtmlInputText();

    public HtmlInputText getTxtAge1() {
        return txtAge1;
    }

    public void setTxtAge1(HtmlInputText hit) {
        this.txtAge1 = hit;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxMSNM = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxMSNM() {
        return selectBooleanCheckboxMSNM;
    }

    public void setSelectBooleanCheckboxMSNM(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxMSNM = hsbc;
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
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxSex = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxSex() {
        return selectBooleanCheckboxSex;
    }

    public void setSelectBooleanCheckboxSex(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxSex = hsbc;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxAge = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxAge() {
        return selectBooleanCheckboxAge;
    }

    public void setSelectBooleanCheckboxAge(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxAge = hsbc;
    }
    private DefaultSelectedData defaultSelectedData15 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData15() {
        return defaultSelectedData15;
    }

    public void setDefaultSelectedData15(DefaultSelectedData dsd) {
        this.defaultSelectedData15 = dsd;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxMS = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxMS() {
        return selectBooleanCheckboxMS;
    }

    public void setSelectBooleanCheckboxMS(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxMS = hsbc;
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
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxSexM = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxSexM() {
        return selectBooleanCheckboxSexM;
    }

    public void setSelectBooleanCheckboxSexM(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxSexM = hsbc;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxSexMF = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxSexMF() {
        return selectBooleanCheckboxSexMF;
    }

    public void setSelectBooleanCheckboxSexMF(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxSexMF = hsbc;
    }
    private DefaultSelectedData defaultSelectedData18 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData18() {
        return defaultSelectedData18;
    }

    public void setDefaultSelectedData18(DefaultSelectedData dsd) {
        this.defaultSelectedData18 = dsd;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxMSM = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxMSM() {
        return selectBooleanCheckboxMSM;
    }

    public void setSelectBooleanCheckboxMSM(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxMSM = hsbc;
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
    private DefaultSelectedData defaultSelectedData19 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData19() {
        return defaultSelectedData19;
    }

    public void setDefaultSelectedData19(DefaultSelectedData dsd) {
        this.defaultSelectedData19 = dsd;
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
    private HtmlSelectOneRadio rdRelation = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRdRelation() {
        return rdRelation;
    }

    public void setRdRelation(HtmlSelectOneRadio hsor) {
        this.rdRelation = hsor;
    }
    private RowSelector rowSelector1 = new RowSelector();
    private RowSelector rowSelector2 = new RowSelector();

    public RowSelector getRowSelector2() {
        return rowSelector2;
    }

    public void setRowSelector2(RowSelector rowSelector2) {
        this.rowSelector2 = rowSelector2;
    }

    public RowSelector getRowSelector1() {
        return rowSelector1;
    }

    public void setRowSelector1(RowSelector rs) {
        this.rowSelector1 = rs;
    }
    private DefaultSelectedData defaultSelectedData20 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData20() {
        return defaultSelectedData20;
    }

    public void setDefaultSelectedData20(DefaultSelectedData dsd) {
        this.defaultSelectedData20 = dsd;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }

    public CandidateListPage() {
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
        cboMakeEmployee.setDisabled(true);
        cboMakeCadidateCertify.setDisabled(true);
        btnApprove.setDisabled(true);
        btnEditPersentage.setDisabled(true);
        btnSavePersentage.setDisabled(true);
        btnUpdatePersentage.setDisabled(true);
        selectedCandidateList.clear();
        practicalCompClear();
        btnDeletePersentage.setDisabled(true);
        disablePersentageComponet();
       // btnCertify.setDisabled(true);
        selectBooleanCheckboxSexM.setDisabled(true);
        selectBooleanCheckboxSexMF.setDisabled(true);
        txtAge1.setDisabled(true);
        inputTextAgeValue.setDisabled(true);
        selectBooleanCheckboxMSM.setDisabled(true);
        selectBooleanCheckboxMSNM.setDisabled(true);
        txtAgeRightComp.setDisabled(true);
        inputTextAgeValueRight.setDisabled(true);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
      boolean select=false;

    static class TotalResultComparator implements Comparator<CandidateManager> {

        public int compare(CandidateManager p1, CandidateManager p2) {
            float total1 = p1.getTotal();
            float total2 = p2.getAge();

            if (total1 == total2) {
                return 0;
            } else if (total1 > total2) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public void selectOneMenu1_processValueChange(ValueChangeEvent vce)
           {
       
        if (vce.getNewValue() != null)
             {

            String[] request_Infos = vce.getNewValue().toString().split("--");
            Integer.parseInt(request_Infos[1]);
            requestInfos(request_Infos[1]);
            readCandidateList(request_Infos[0]);

        } 
    }

        public void selectOneMenu1Biruk_processValueChange(ValueChangeEvent vce)
           {

        if (vce.getNewValue() != null)
             {

            String[] request_Infos = vce.getNewValue().toString().split("--");
            Integer.parseInt(request_Infos[1]);
            requestInfos(request_Infos[1]);
            readCandidateList(request_Infos[0]);

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

    public String setSelectdValue() {
        //return null means stay on the same page
        sql = "";
        if (choTheInterviewexamtaken.isSelected()) {
            sql += " AND  CA.interview_exam_result<>0  ";
        }
        if (choThewrittenexamtaken.isSelected()) {
            sql += "  AND  CA.written_exam_result<>0 ";
        }
        if (chotxtPracticaleExameTaken.isSelected()) {
            sql += "  AND  CA.practical_exam_result<>0 ";
        }
        if (!txtWrittenExamResultGreaterThan.getValue().equals("")) {
            sql += "  AND  CA.WRITTEN_EXAM_RESULT > " + txtWrittenExamResultGreaterThan.getValue() + "";
        }
        if (!txtPracticalResultGreaterThan.getValue().equals("")) {
            sql += "  AND  CA.PRACTICAL_EXAM_RESULT > " + txtPracticalResultGreaterThan.getValue() + "";
        }
        if (!txtInterviewResult.getValue().equals("")) {
            sql += "  AND  CA.INTERVIEW_EXAM_RESULT > " + txtInterviewResult.getValue() + "";
        }
        if (!txtGPA.getValue().equals("")) {
            sql += "  AND  CA.CGPA > " + txtGPA.getValue() + "";
        }
        if (relationType != null) {
            sql += " AND  CX.EXP_RELATION_TYPE = '" + rdRelation.getValue().toString() + "'";
        }
        if (choApproved.isSelected()) {
            sql += "  AND  APPROVE ='Approved' ";
        }
        if (choCertified.isSelected()) {
            sql += "  AND  CERTIFY='certify' ";
        }
        if (choExamResult.isSelected()) {
            sql += " order by res desc";
        }
        if (choByGpa.isSelected()) {
            sql += " order by CGPA desc";
        }

        if (selectBooleanCheckboxSex.isSelected()) {
            if (selectBooleanCheckboxSexM.isSelected() == true && selectBooleanCheckboxSexMF.isSelected() == true) {
                sql += " order by GENDER desc";
            } else if (selectBooleanCheckboxSexM.isSelected() == true && selectBooleanCheckboxSexMF.isSelected() == false) {
                sql += " AND  GENDER='Male' ";
            } else if (selectBooleanCheckboxSexM.isSelected() == false && selectBooleanCheckboxSexMF.isSelected() == true) {
                sql += " AND  GENDER='Female'";
            } else {
                sql += " order by GENDER desc";
            }
        }

        if (selectBooleanCheckboxMS.isSelected()) {
            if (selectBooleanCheckboxMSM.isSelected() == true && selectBooleanCheckboxMSNM.isSelected() == true) {
                sql += " order by MARITAL_STATUS desc";
            } else if (selectBooleanCheckboxMSM.isSelected() == true && selectBooleanCheckboxMSNM.isSelected() == false) {
                sql += " AND  MARITAL_STATUS='Married' ";
            } else if (selectBooleanCheckboxMSM.isSelected() == false && selectBooleanCheckboxMSNM.isSelected() == true) {
                sql += " AND  MARITAL_STATUS='Single'";
            } else {
                sql += " order by MARITAL_STATUS desc";
            }
        }

        if (selectBooleanCheckboxAge.isSelected() == true) {

            String num = "";
            String todayInEc = dateFormat.format(new Date());
            String val1 = "";
            String val2 = "";
            String val3 = "";
            String val4 = "";
            if (!txtAge1.getValue().toString().equals("") && !inputTextAgeValue.getValue().toString().equals("") && !txtAgeRightComp.getValue().toString().equals("") && !inputTextAgeValueRight.getValue().toString().equals("")) {
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
            } else if (!txtAge1.getValue().toString().equals("") && !inputTextAgeValue.getValue().toString().equals("") && txtAgeRightComp.getValue().toString().equals("") && inputTextAgeValueRight.getValue().toString().equals("")) {
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

            } else {
                this.showSuccessOrFailureMessage(false, " Invalid Creiteria");
            }
        }
        pnDisplayCriteria.setRendered(false);

        return null;
    }

    public void button1_processAction(ActionEvent ae) {
    }

    public String btnMakeEmployee_action() {

        //return null means stay on the same page
        boolean chckSave = false;
        List candidate = this.getSelectedCandidateList();
        Iterator<CandidateManager> it = candidate.iterator();
        while (it.hasNext()) {
            CandidateManager canObj = it.next();
            if (canObj.isSelected()) {
                if (!canObj.getSatus().endsWith("Employee")) {
                    if (candidateManager.grantCandidate(canObj.getCanidateId()) == 1) {
                        chckSave = true;
                    } else {
                    }
                }
            }
        }
        if (chckSave) {
        } else {
        }

        return null;
    }

    public String cmdRecruitmentRequest_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdrecApproval_action() {
        //return null means stay on the same page
        return "RecruitmentApprove";
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

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String batchCode;
    CandidateExperienceManager candidateExperienceManager = new CandidateExperienceManager();
    public void drlPersentageBatchCode_processValueChange(ValueChangeEvent vce)
    {
        try {
             if (!vce.getNewValue().equals("-1") && vce.getNewValue() != null) {
          String [] requestId= vce.getNewValue().toString().split("--");

            batchCode = requestId[0];
          
            CandidateNameList = candidateExperienceManager.getAllCanidateNameListForFinalSelection(requestId[0]);
            
         // report.MonthlyReport();
        }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap percentageDate() {

        HashMap promotionAssessmentPercentage = new HashMap();
        if (HRValidation.validateData(txtWrittenPersentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0)
        {
            promotionAssessmentPercentage.put("writtenpercentage", txtWrittenPersentage.getValue().toString());
            totalPersentage += Integer.parseInt(txtWrittenPersentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("writtenpercentage", "0");
        }

        if (HRValidation.validateData(txtInterviewPersentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0) {
            promotionAssessmentPercentage.put("interviewpercentage", txtInterviewPersentage.getValue().toString());
            totalPersentage +=
                    Integer.parseInt(txtInterviewPersentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("interviewpercentage", "0");
        }

        if (HRValidation.validateData(txtPracticalPersentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0) {
            promotionAssessmentPercentage.put("presentationpercentage", txtPracticalPersentage.getValue().toString());
            totalPersentage += Integer.parseInt(txtPracticalPersentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("presentationpercentage", "0");
        }

        if (HRValidation.validateData(txtOtherPercentage.getValue(), HRValidation.INT_FLOTING_NUMBER, true) == 0) {
            promotionAssessmentPercentage.put("otherpercentage", txtOtherPercentage.getValue().toString());
            totalPersentage += Integer.parseInt(txtOtherPercentage.getValue().toString());
        } else {
            promotionAssessmentPercentage.put("otherpercentage", "0");
        }

        promotionAssessmentPercentage.put("candidateID", canID);
        promotionAssessmentPercentage.put("batchCode", batchCode);
        return promotionAssessmentPercentage;
    }

    public String btnSavePersentage_action() {

        HashMap hmpercentageDate = percentageDate();
        if (totalPersentage < 100)
        {
            if (candidateManager.insertRecrutmentAssessmentPrecentage(hmpercentageDate)) 
            {
                showSuccessOrFailureMessage(true, "Candidate Exam Result Saved Successfuly");
                pnCriteria.setRendered(false);
                disablePersentageComponet();
                pnCriteria.setRendered(false);
                drlPersentageBatchCode.setValue("");
                btnEditPersentage.setDisabled(true);
                btnSavePersentage.setDisabled(true);
                btnUpdatePersentage.setDisabled(true);
                btnDeletePersentage.setDisabled(true);
                clearPersentageComponet();
            } else {
                showSuccessOrFailureMessage(false, "The Degree of Exam Information Not Saved ? Please try agin?");
            }

        } else {
            showSuccessOrFailureMessage(false, "The Degree of Exam Sum  shod be 100.Please correct agin?");
        }
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
                if (candidateManager.approveCandidate(readApprovedCandidateList(), getSessionBean1().getEmpDeptId())) {
                   // btnApprove.setDisabled(true);
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

    public String cmdLnkClosePopupCommitteeMembers_action() {
        cmdLnkClosePopupCommitteeMembers.setRendered(false);
        pnlPopupCommitteeMembers.setRendered(false);
        return null;
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

    public String btnEditPersentage_action() {
        //return null means stay on the same page
        enablePersentageComponet();
        btnEditPersentage.setDisabled(true);
        btnSavePersentage.setDisabled(true);
        btnUpdatePersentage.setDisabled(false);
        btnDeletePersentage.setDisabled(true);
        return null;
    }

    public void disablePersentageComponet() {
        txtOtherPercentage.setDisabled(true);
        txtInterviewPersentage.setDisabled(true);
        txtPracticalPersentage.setDisabled(true);
        txtWrittenPersentage.setDisabled(true);

    }

    public void clearPersentageComponet() {
        txtOtherPercentage.setValue("");
        txtInterviewPersentage.setValue("");
        txtPracticalPersentage.setValue("");
        txtWrittenPersentage.setValue("");
    }

    public void enablePersentageComponet() {
        txtOtherPercentage.setDisabled(false);
        txtInterviewPersentage.setDisabled(false);
        txtPracticalPersentage.setDisabled(false);
        txtWrittenPersentage.setDisabled(false);

    }

    public String btnUpdatePersentage_action() {
        int checkupdate = candidateManager.updateExamPercentage(percentageDate());
        if (checkupdate != 0) {
            pnCriteria.setRendered(false);
            disablePersentageComponet();
            btnEditPersentage.setDisabled(true);
            btnSavePersentage.setDisabled(true);
            btnUpdatePersentage.setDisabled(true);
            btnDeletePersentage.setDisabled(true);
            clearPersentageComponet();
            showSuccessOrFailureMessage(true, "The Degree of Exam Information  Update Successfully!");
        } else {
            showSuccessOrFailureMessage(false, "The Degree of Exam Information  Not Update. Please try agin?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnDeletePersentage_action() {
        disablePersentageComponet();
        int checkUpdate = candidateManager.deleteExamPercentage(batchCodePresentage);
        if (checkUpdate != 0) {
            disablePersentageComponet();
            clearPersentageComponet();
            showSuccessOrFailureMessage(true, "The Degree of Exam Information Delete Successfully!");
            btnEditPersentage.setDisabled(true);
            btnSavePersentage.setDisabled(false);
            btnUpdatePersentage.setDisabled(true);
            btnDeletePersentage.setDisabled(true);
            drlPersentageBatchCode.setValue("");
            pnCriteria.setRendered(true);

        }


        //return null means stay on the same page
        return null;
    }

    void practicalCompClear() {
        txtPracticalResultGreaterThan.setValue("");
        txtWrittenExamResultGreaterThan.setValue("");
        txtInterviewResult.setValue("");
        txtGPA.setValue("");
    }

    public String modalPnlCloseCriteria_action() {
        pnCriteria.setRendered(false);
        txtOtherPercentage.setValue("");
        txtInterviewPersentage.setValue("");
        txtPracticalPersentage.setValue("");
        txtWrittenPersentage.setValue("");
        //return null means stay on the same page
        return null;
    }

    public String cmdexamQuestion_action() {
        txtOtherPercentage.setValue("");
        txtInterviewPersentage.setValue("");
        txtPracticalPersentage.setValue("");
        txtWrittenPersentage.setValue("");
        clearPersentageComponet();
        disablePersentageComponet();
        pnCriteria.setRendered(true);


        //return null means stay on the same page
        return null;
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

    public String btnSet_action() {
        setSelectdValue();
        //return null means stay on the same page
        return null;
    }

    public void choByGpa_processValueChange(ValueChangeEvent vce) {
        choExamResult.setSelected(false);
        selectBooleanCheckboxSex.setSelected(false);
        selectBooleanCheckboxAge.setSelected(false);
        selectBooleanCheckboxMS.setSelected(false);
        selectBooleanCheckboxSexM.setDisabled(true);
        selectBooleanCheckboxSexMF.setDisabled(true);
        txtAge1.setDisabled(true);
        inputTextAgeValue.setDisabled(true);
        selectBooleanCheckboxMSM.setDisabled(true);
        selectBooleanCheckboxMSNM.setDisabled(true);
        txtAgeRightComp.setDisabled(true);
        inputTextAgeValueRight.setDisabled(true);

    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    ArrayList<HashMap> readApprovedCandidate() {
        try {
            ArrayList<HashMap> candidateInfo = new ArrayList<HashMap>();
            List candidate = this.getSelectedCandidateList();
            Iterator<CandidateManager> it = candidate.iterator();
            while (it.hasNext()) {
                CandidateManager canObj = it.next();
                HashMap _list = new HashMap();
                if (canObj.isSelected()) {
                    if (canObj.getApproved().equals("Approved")) {
                        if (!canObj.getCertified().equals("certify")) {
                            _list.put("canidateId", canObj.getCanidateId());
                            candidateInfo.add(_list);

                        }
                    }
                }



            }
            return candidateInfo;
        } catch (Exception e) {

            return null;
        }
    }

    private ArrayList<HashMap> readApprovedCandidateList() {
        try {
            ArrayList<HashMap> candidateInfo = new ArrayList<HashMap>();
            List candidate = this.getSelectedCandidateList();
            Iterator<CandidateManager> it = candidate.iterator();
            while (it.hasNext()) {
                CandidateManager canObj = it.next();
                HashMap _list = new HashMap();
                if (canObj.isSelected()) {
                    if (!canObj.getApproved().equals("Approved")) {
                        _list.put("canidateId", canObj.getCanidateId());
                        candidateInfo.add(_list);
                    }
                }
            }
            return candidateInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String btnApprove_action() {

//        committeeId = recruitmentManager.readCommitteeId(recruitmentRequestId);
//        committeeMembersList = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
//        pnlPopupCommitteeMembers.setRendered(true);

   boolean returnResult= candidateManager.PusheCandidateForEmployement(lastSelectedCandiate);
                if(returnResult){
                showSuccessOrFailureMessage(true, "The Candidate Information Pushed Successfully!");
                }
                else{
                showSuccessOrFailureMessage(false, "The Candidate Information Not Pushed.Please try agin?");
                }
                

        return null;
    }

    public String btnCertify_action() {
        //return null means stay on the same page
        if (candidateManager.certifyCandidate(readApprovedCandidate(), getSessionBean1().getEmpDeptId())) {
            showSuccessOrFailureMessage(true, "The Candidate Information Certified  Successfully!");
        //    btnCertify.setDisabled(true);
        } else {
            showSuccessOrFailureMessage(false, "The Candidate Information Not Certified .Please try agin?");
        }
        return null;
    }

    public String cmdSetDisplayCriteria_action() {
        pnDisplayCriteria.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String cmdPrepare_action() {
        cboMakeEmployee.setDisabled(false);
       // cboMakeCadidateCertify.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public void selectBooleanCheckboxSex_processValueChange(ValueChangeEvent vce) {
        choByGpa.setSelected(false);
        choExamResult.setSelected(false);
        selectBooleanCheckboxAge.setSelected(false);
        selectBooleanCheckboxMS.setSelected(false);
        txtAge1.setDisabled(true);
        inputTextAgeValue.setDisabled(true);
        selectBooleanCheckboxMSM.setDisabled(true);
        selectBooleanCheckboxMSNM.setDisabled(true);
        txtAgeRightComp.setDisabled(true);
        inputTextAgeValueRight.setDisabled(true);
        if (selectBooleanCheckboxSex.isSelected() == true) {
            selectBooleanCheckboxSexM.setDisabled(false);
            selectBooleanCheckboxSexMF.setDisabled(false);
        } else {
            selectBooleanCheckboxSexM.setDisabled(true);
            selectBooleanCheckboxSexMF.setDisabled(true);
        }

    }

    public void selectBooleanCheckboxAge_processValueChange(ValueChangeEvent vce) {
        choByGpa.setSelected(false);
        choExamResult.setSelected(false);
        selectBooleanCheckboxSex.setSelected(false);
        selectBooleanCheckboxMS.setSelected(false);
        selectBooleanCheckboxSexM.setDisabled(true);
        selectBooleanCheckboxSexMF.setDisabled(true);
        selectBooleanCheckboxMSM.setDisabled(true);
        selectBooleanCheckboxMSNM.setDisabled(true);

        if (selectBooleanCheckboxAge.isSelected() == true) {
            txtAge1.setDisabled(false);
            inputTextAgeValue.setDisabled(false);
            txtAgeRightComp.setDisabled(false);
            inputTextAgeValueRight.setDisabled(false);
        } else {
            txtAge1.setDisabled(true);
            inputTextAgeValue.setDisabled(true);
            txtAgeRightComp.setDisabled(true);
            inputTextAgeValueRight.setDisabled(true);
        }
    }

    public void selectBooleanCheckboxMS_processValueChange(ValueChangeEvent vce) {
        choByGpa.setSelected(false);
        choExamResult.setSelected(false);
        selectBooleanCheckboxSex.setSelected(false);
        selectBooleanCheckboxAge.setSelected(false);
        selectBooleanCheckboxSexM.setDisabled(true);
        selectBooleanCheckboxSexMF.setDisabled(true);
        txtAge1.setDisabled(true);
        inputTextAgeValue.setDisabled(true);
        inputTextAgeValue.setDisabled(true);
        txtAgeRightComp.setDisabled(true);
        inputTextAgeValueRight.setDisabled(true);
        if (selectBooleanCheckboxMS.isSelected() == true) {
            selectBooleanCheckboxMSM.setDisabled(false);
            selectBooleanCheckboxMSNM.setDisabled(false);
        } else {
            selectBooleanCheckboxMSM.setDisabled(true);
            selectBooleanCheckboxMSNM.setDisabled(true);
        }
    }

    public void selectBooleanCheckboxSexM1_processValueChange(ValueChangeEvent vce) {
    }

    public void choExamResult_processValueChange(ValueChangeEvent vce) {
        choByGpa.setSelected(false);
        selectBooleanCheckboxSex.setSelected(false);
        selectBooleanCheckboxAge.setSelected(false);
        selectBooleanCheckboxMS.setSelected(false);
        selectBooleanCheckboxSexM.setDisabled(true);
        selectBooleanCheckboxSexMF.setDisabled(true);
        txtAge1.setDisabled(true);
        inputTextAgeValue.setDisabled(true);
        selectBooleanCheckboxMSM.setDisabled(true);
        selectBooleanCheckboxMSNM.setDisabled(true);
        txtAgeRightComp.setDisabled(true);
        inputTextAgeValueRight.setDisabled(true);
    }

    public void selectBooleanCheckboxMSNM_processValueChange(ValueChangeEvent vce) {
//        if(selectBooleanCheckboxMS.isSelected() == true){
//            selectBooleanCheckboxMSM.setSelected(false);
//        }
    }

    public void selectBooleanCheckboxMSM_processValueChange(ValueChangeEvent vce) {
//        if(selectBooleanCheckboxMS.isSelected() == true){
//            selectBooleanCheckboxMSNM.setSelected(false);
//        }
    }

    public void selectBooleanCheckboxSexMF_processValueChange(ValueChangeEvent vce) {
//        if(selectBooleanCheckboxAge.isSelected() == true){
//            selectBooleanCheckboxSexM.setSelected(false);
//        }
    }

    public void selectBooleanCheckboxSexM_processValueChange(ValueChangeEvent vce) {
//        if(selectBooleanCheckboxAge.isSelected() == true){
//            selectBooleanCheckboxSexMF.setSelected(false);
//        }
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




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      private void readCandidateList(String recruitmentRequestId) 
        {

        try {


            HashMap[] candidateList = recruitmentManager.readCandidateList(recruitmentRequestId);

            for (int i = 0; i < candidateList.length; i++)
            {
                CandidateManager addToTable = new CandidateManager(
                        candidateList[i].get("CANDIDATE_FULL_NAME").toString(),
                        candidateList[i].get("CANDIDATE_ID").toString(),
                        candidateList[i].get("GENDER").toString(),
                        candidateList[i].get("WRITTENPERCENTAGE").toString(),
                        candidateList[i].get("INTERVIEWRESULT").toString(),
                        candidateList[i].get("PRACTICALRESULT").toString(),
                        candidateList[i].get("TOTAL").toString(),
                        select,candidateList[i].get("RECRUIT_BATCH_CODE").toString());
                       this.recruitCandidateListBiruk.add(addToTable);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
        public List getRecruitCandidateList() {
        return recruitCandidateList;
    }

    public void setRecruitCandidateList(List recruitCandidateList) {
        this.recruitCandidateList = recruitCandidateList;
    }
    public ArrayList<Option> getRelationTypeList() {
        return relationTypeList;
    }

    /**
     * @param relationTypeList the relationTypeList to set
     */
    public void setRelationTypeList(ArrayList<Option> relationTypeList) {
        this.relationTypeList = relationTypeList;
    }

    private void userRole() {
        HashMap hashMap = new HashMap();
        SiteSecurityManager security = new SiteSecurityManager();
        Set<HashMap> prmitionList = security.readUserPermition(getSessionBean1().getUserName(),
                getSessionBean1().getRequestedPage());
        boolean canView = true;
        boolean canApprove = true;
        boolean canCertify = true;
        for (HashMap s : prmitionList)
        {
            if (s.get("per").equals(SiteSecurityManager.Permission_View)) {
                hashMap.put("v", "VIEW");
                canView = false;
            } else if (s.get("per").equals(SiteSecurityManager.Permission_Approve)) {
                hashMap.put("a", "APPROVE");
                cboMakeEmployee.setDisabled(false);
                checkApproved = true;
           //     stxtAppFullName.setValue(getSessionBean1().getEmployeeName());
               // stxtAppDept.setValue(departmentManage.traceDepartemnt(getSessionBean1().getEmpDeptId()));
                stxtAppJobPosition.setValue(getSessionBean1().getJobDescription());
                canApprove = false;
            } else if (s.get("per").equals(SiteSecurityManager.Permission_Certify)) {
                hashMap.put("c", "CERTIFY");
                checkCertified = true;
               // cboMakeCadidateCertify.setDisabled(false);
             //   stxtCertFullName.setValue(getSessionBean1().getEmployeeName());
              //  stxtCertDept.setValue(departmentManage.traceDepartemnt(getSessionBean1().getEmpDeptId()));
                stxtCertJobPosition.setValue(getSessionBean1().getJobDescription());
                canCertify = false;
            // this.displayPageForCerify();
            }
        }
        if (canApprove) {
            checkApproved = false;
        //    stxtAppFullName.setValue("");
           // stxtAppDept.setValue("");
            stxtAppJobPosition.setValue("");
        }
        if (canApprove) {
            checkApproved = false;
         //   stxtAppFullName.setValue("");
           // stxtAppDept.setValue("");
            stxtAppJobPosition.setValue("");
        }

        if (canCertify) {
            checkCertified = false;
           // stxtCertFullName.setValue("");
          //  stxtCertDept.setValue("");
            stxtCertJobPosition.setValue("");
        }

    }

    public void rdRelation_processValueChange(ValueChangeEvent vce) {
        relationType = vce.getNewValue().toString();

    }

    public void selectOneMenu2_processValueChange(ValueChangeEvent vce) {

           String [] candidateList =vce.getNewValue().toString().split("--");
           fullName=candidateList[0];
           canID=candidateList[1];
             
                    enablePersentageComponet();
                    btnEditPersentage.setDisabled(false);
                    btnSavePersentage.setDisabled(false);
                    btnUpdatePersentage.setDisabled(false);
                    btnDeletePersentage.setDisabled(false);
    }

    public String button1_action() {
        //return null means stay on the same page
          // lastSelectedCandiate.get(selectedlastCandidte);
           lastSelectedCandiate.remove(selectedlastCandidte);
        //lastSelectedCandiate.clear();
        return null;
    }
    ///////////////////////////////////////////////////////////////
}

