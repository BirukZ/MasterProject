
/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright Mekete VS BravoZulu
 */
package fphrms.Discipline;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGrid;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataProvider;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.ByteArrayResource;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.CommeeteeCommentsGiven;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberModel.ChairManCommentes;
import manager.committeeManager.CommitteeMemberModel.RejectedPenalityComeentes;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.disciplineManager.AccusedDefenceManager;
import manager.disciplineManager.AccusedDefenceManager.AccusedDefenceModel;
//import manager.disciplineManager.CommtteeComments;
import manager.disciplineManager.DisciplineRegistrationManager;
import manager.disciplineManager.DisciplineRequestManager;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.disciplineManager.DisciplineApproveManager;
import manager.disciplineManager.EyeWitnessManager;
import manager.disciplineManager.EyeWitnessManager.EyeWitnessModel;
import manager.disciplineManager.EyeWitnessManager.OtherMemberEyeWitnessModel;
import manager.disciplineManager.PenaltyRegistrationManager;
import manager.disciplineManager.PenaltyRegistrationManager.PenaltyTypeModel;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.userManagement.SiteSecurityManager;
import com.icesoft.faces.context.Resource;
import javax.faces.context.ExternalContext;
import manager.disciplineManager.AccusedDefenceManager.AccusedFileUpLoad;
import manager.disciplineManager.AccusedDefenceManager.FileUpLoadForInterset;
import manager.disciplineManager.EyeWitnessManager.FileUpLoad;
import manager.disciplineManager.EyeWitnessManager.OtherEyeWitnessFileUpLoad;
import manager.fileManager.ResourceManager;
import manager.globalUseManager.ErrorLogWriter;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.inputfile.InputFile;
import java.io.File;
import manager.disciplineManager.DisciplineApproveManager.CommitteeMinuteFileUpLoad;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DisciplineApprovePage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        faResource = new ResourceManager(ec, "resourceName");
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        userName = getSessionBean1().getUserName();
        disciplineRequestManager.setUserName(userName);
        disciplineApproveManager.setUserName(userName);
        cmdLinkConfirmCommitteeDecisions.setDisabled(true);
        drlPenaltyForManger1.setDisabled(true);
        drl_disciplineForManager.setDisabled(true);
        this.disablecommentspopoUp();
        txt_DeductAmount.setDisabled(true);
        txt_Duration.setDisabled(true);
        intxt_lastApprover_commeentes.setRendered(false);
        loadPendingRequest();
        populateApproverTextComponents(loggedInEmployeeId);



    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private PanelLayout pnProfile = new PanelLayout();

    public CommitteeMemberRegistrationManager getCommitteeMemberRegistrationManager() {
        return committeeMemberRegistrationManager;
    }

    public void setCommitteeMemberRegistrationManager(CommitteeMemberRegistrationManager committeeMemberRegistrationManager) {
        this.committeeMemberRegistrationManager = committeeMemberRegistrationManager;
    }

    public ArrayList<CommitteeMemberModel> getCommitteeMembersList() {
        return committeeMembersList;
    }

    public void setCommitteeMembersList(ArrayList<CommitteeMemberModel> committeeMembersList) {
        this.committeeMembersList = committeeMembersList;
    }

    public int getDeciderCommitteeId() {
        return deciderCommitteeId;
    }

    public void setDeciderCommitteeId(int deciderCommitteeId) {
        this.deciderCommitteeId = deciderCommitteeId;
    }

    public PenaltyRegistrationManager getPenaltyRegistrationManager() {
        return penaltyRegistrationManager;
    }

    public void setPenaltyRegistrationManager(PenaltyRegistrationManager penaltyRegistrationManager) {
        this.penaltyRegistrationManager = penaltyRegistrationManager;
    }

    public SiteSecurityManager getSiteSecurityManager() {
        return siteSecurityManager;
    }

    public void setSiteSecurityManager(SiteSecurityManager siteSecurityManager) {
        this.siteSecurityManager = siteSecurityManager;
    }

    public int getSelectedCommitteeMemberRow() {
        return selectedCommitteeMemberRow;
    }

    public void setSelectedCommitteeMemberRow(int selectedCommitteeMemberRow) {
        this.selectedCommitteeMemberRow = selectedCommitteeMemberRow;
    }

    public PanelLayout getPnProfile() {
        return pnProfile;
    }

    public void setPnProfile(PanelLayout pl) {
        this.pnProfile = pl;
    }
    private HtmlPanelGroup pnlGrpPowerDeligationContent = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlGrpPowerDeligationContent() {
        return pnlGrpPowerDeligationContent;
    }

    public void setPnlGrpPowerDeligationContent(HtmlPanelGroup hpg) {
        this.pnlGrpPowerDeligationContent = hpg;
    }
    private DefaultSelectedData selectedObjectOfPendingList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOfDisciplineType = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectPending = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectPending() {
        return selectedObjectPending;
    }

    public void setSelectedObjectPending(DefaultSelectedData selectedObjectPending) {
        this.selectedObjectPending = selectedObjectPending;
    }

    public DefaultSelectedData getSelectedObjectOfDisciplineType() {
        return selectedObjectOfDisciplineType;
    }

    public void setSelectedObjectOfDisciplineType(DefaultSelectedData selectedObjectOfDisciplineType) {
        this.selectedObjectOfDisciplineType = selectedObjectOfDisciplineType;
    }

    public DefaultSelectedData getSelectedObjectOfPendingList() {
        return selectedObjectOfPendingList;
    }

    public void setSelectedObjectOfPendingList(DefaultSelectedData selectedObjectOfPendingList) {
        this.selectedObjectOfPendingList = selectedObjectOfPendingList;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private HtmlInputText txtRequesterDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment() {
        return txtRequesterDepartment;
    }

    public void setTxtRequesterDepartment(HtmlInputText hit) {
        this.txtRequesterDepartment = hit;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
    }
    private HtmlInputText txtRequesterFullName = new HtmlInputText();

    public HtmlInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(HtmlInputText hit) {
        this.txtRequesterFullName = hit;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlInputText txtEmployeeDepartment = new HtmlInputText();

    public HtmlInputText getTxtEmployeeDepartment() {
        return txtEmployeeDepartment;
    }

    public void setTxtEmployeeDepartment(HtmlInputText hit) {
        this.txtEmployeeDepartment = hit;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private HtmlInputText txtEmployeeFullName = new HtmlInputText();

    public HtmlInputText getTxtEmployeeFullName() {
        return txtEmployeeFullName;
    }

    public void setTxtEmployeeFullName(HtmlInputText hit) {
        this.txtEmployeeFullName = hit;
    }
    private HtmlInputText txtEmployeePosition = new HtmlInputText();

    public HtmlInputText getTxtEmployeePosition() {
        return txtEmployeePosition;
    }

    public void setTxtEmployeePosition(HtmlInputText hit) {
        this.txtEmployeePosition = hit;
    }
    private HtmlInputText txtDisciplineDate = new HtmlInputText();

    public HtmlInputText getTxtDisciplineDate() {
        return txtDisciplineDate;
    }

    public void setTxtDisciplineDate(HtmlInputText hit) {
        this.txtDisciplineDate = hit;
    }
    private HtmlInputText txtReportedDate = new HtmlInputText();

    public HtmlInputText getTxtReportedDate() {
        return txtReportedDate;
    }

    public void setTxtReportedDate(HtmlInputText hit) {
        this.txtReportedDate = hit;
    }
    private HtmlSelectOneMenu drlDisciplineType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDisciplineType() {
        return drlDisciplineType;
    }

    public void setDrlDisciplineType(HtmlSelectOneMenu hsom) {
        this.drlDisciplineType = hsom;
    }
    private HtmlInputTextarea txtaDisciplineDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDisciplineDescription() {
        return txtaDisciplineDescription;
    }

    public void setTxtaDisciplineDescription(HtmlInputTextarea hit) {
        this.txtaDisciplineDescription = hit;
    }
    private HtmlInputText txtDisciplinePreviousOccurance = new HtmlInputText();

    public HtmlInputText getTxtDisciplinePreviousOccurance() {
        return txtDisciplinePreviousOccurance;
    }

    public void setTxtDisciplinePreviousOccurance(HtmlInputText hit) {
        this.txtDisciplinePreviousOccurance = hit;
    }
    private SelectInputDate calOffenceDate = new SelectInputDate();

    public SelectInputDate getCalOffenceDate() {
        return calOffenceDate;
    }

    public void setCalOffenceDate(SelectInputDate sid) {
        this.calOffenceDate = sid;
    }
    private SelectInputDate calReportedDate = new SelectInputDate();

    public SelectInputDate getCalReportedDate() {
        return calReportedDate;
    }

    public void setCalReportedDate(SelectInputDate sid) {
        this.calReportedDate = sid;
    }
    private HtmlInputTextarea txtaDisciplineDecisionTobeTaken = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDisciplineDecisionTobeTaken() {
        return txtaDisciplineDecisionTobeTaken;
    }

    public void setTxtaDisciplineDecisionTobeTaken(HtmlInputTextarea hit) {
        this.txtaDisciplineDecisionTobeTaken = hit;
    }
    private PanelPopup pnlPopupViewAccusedComment = new PanelPopup();

    public String getExpectedPenalty() {
        return expectedPenalty;
    }

    public void setExpectedPenalty(String expectedPenalty) {
        this.expectedPenalty = expectedPenalty;
    }

    public PanelPopup getPnlPopupViewAccusedComment() {
        return pnlPopupViewAccusedComment;
    }

    public void setPnlPopupViewAccusedComment(PanelPopup pnlPopupViewAccusedComment) {
        this.pnlPopupViewAccusedComment = pnlPopupViewAccusedComment;
    }
    private HtmlCommandButton commentsbtnClosePopupSuccessOrFailure = new HtmlCommandButton();
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlOutputLabel commenteslblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private PanelLayout commentspnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private HtmlOutputText comenetspnMessageTitle = new HtmlOutputText();
    private HtmlPanelGroup commentespanelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private PanelPopup comeentespnlPopupSuccessOrFailure = new PanelPopup();

    public HtmlOutputText getComenetspnMessageTitle() {
        return comenetspnMessageTitle;
    }

    public void setComenetspnMessageTitle(HtmlOutputText comenetspnMessageTitle) {
        this.comenetspnMessageTitle = comenetspnMessageTitle;
    }

    public HtmlCommandButton getCommentsbtnClosePopupSuccessOrFailure() {
        return commentsbtnClosePopupSuccessOrFailure;
    }

    public void setCommentsbtnClosePopupSuccessOrFailure(HtmlCommandButton commentsbtnClosePopupSuccessOrFailure) {
        this.commentsbtnClosePopupSuccessOrFailure = commentsbtnClosePopupSuccessOrFailure;
    }

    public PanelLayout getCommentspnlMessageBody() {
        return commentspnlMessageBody;
    }

    public void setCommentspnlMessageBody(PanelLayout commentspnlMessageBody) {
        this.commentspnlMessageBody = commentspnlMessageBody;
    }

    public HtmlOutputLabel getCommenteslblSuccessOrErrorMessage() {
        return commenteslblSuccessOrErrorMessage;
    }

    public void setCommenteslblSuccessOrErrorMessage(HtmlOutputLabel commenteslblSuccessOrErrorMessage) {
        this.commenteslblSuccessOrErrorMessage = commenteslblSuccessOrErrorMessage;
    }

    public HtmlPanelGroup getCommentespanelGroupMessage() {
        return commentespanelGroupMessage;
    }

    public void setCommentespanelGroupMessage(HtmlPanelGroup commentespanelGroupMessage) {
        this.commentespanelGroupMessage = commentespanelGroupMessage;
    }

    public PanelPopup getComeentespnlPopupSuccessOrFailure() {
        return comeentespnlPopupSuccessOrFailure;
    }

    public void setComeentespnlPopupSuccessOrFailure(PanelPopup comeentespnlPopupSuccessOrFailure) {
        this.comeentespnlPopupSuccessOrFailure = comeentespnlPopupSuccessOrFailure;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupViewAccusedComment.setRendered(false);
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btnClosePopupViewAccusedComment_action() {
        pnlPopupViewAccusedComment.setRendered(false);
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDateOfOffence() {
        return dateOfOffence;
    }

    public void setDateOfOffence(String dateOfOffence) {
        this.dateOfOffence = dateOfOffence;
    }

    public String getDescriptionOfOffence() {
        return descriptionOfOffence;
    }

    public void setDescriptionOfOffence(String descriptionOfOffence) {
        this.descriptionOfOffence = descriptionOfOffence;
    }

    public int getDisciplineProblemId() {
        return disciplineProblemId;
    }

    public void setDisciplineProblemId(int disciplineProblemId) {
        this.disciplineProblemId = disciplineProblemId;
    }

    public DisciplineRegistrationManager getDisciplineRegistrationManager() {
        return disciplineRegistrationManager;
    }

    public void setDisciplineRegistrationManager(DisciplineRegistrationManager disciplineRegistrationManager) {
        this.disciplineRegistrationManager = disciplineRegistrationManager;
    }

    public String getIsDocumentAttached() {
        return isDocumentAttached;
    }

    public void setIsDocumentAttached(String isDocumentAttached) {
        this.isDocumentAttached = isDocumentAttached;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getSubCatagory() {
        return subCatagory;
    }

    public void setSubCatagory(String subCatagory) {
        this.subCatagory = subCatagory;
    }

    public String getOffenceTypeForManager() {
        return offenceTypeForManager;
    }

    public void setOffenceTypeForManager(String offenceTypeForManager) {
        this.offenceTypeForManager = offenceTypeForManager;
    }

    public String getOffenceType() {
        return offenceType;
    }

    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }

    public String getOffenderId() {
        return offenderId;
    }

    public void setOffenderId(String offenderId) {
        this.offenderId = offenderId;
    }

    public int getRepititionOfOffence() {
        return repititionOfOffence;
    }

    public void setRepititionOfOffence(int repititionOfOffence) {
        this.repititionOfOffence = repititionOfOffence;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getRequestedMeasureToBeTaken() {
        return requestedMeasureToBeTaken;
    }

    public void setRequestedMeasureToBeTaken(String requestedMeasureToBeTaken) {
        this.requestedMeasureToBeTaken = requestedMeasureToBeTaken;
    }

    public String getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(String requesterType) {
        this.requesterType = requesterType;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public DisciplineApproveManager getDisciplineApproveManager() {
        return disciplineApproveManager;
    }

    public void setDisciplineApproveManager(DisciplineApproveManager disciplineApproveManager) {
        this.disciplineApproveManager = disciplineApproveManager;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }

    public AccusedDefenceManager getAccusedDefenceManager() {
        return accusedDefenceManager;
    }

    public void setAccusedDefenceManager(AccusedDefenceManager accusedDefenceManager) {
        this.accusedDefenceManager = accusedDefenceManager;
    }

    public ArrayList<DisciplineRequestModel> getAllCommittedOffencesOfEmployee() {
        return allCommittedOffencesOfEmployee;
    }

    public void setAllCommittedOffencesOfEmployee(ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee) {
        this.allCommittedOffencesOfEmployee = allCommittedOffencesOfEmployee;
    }
    private PanelPopup pnlPopupAllCommittedOffences = new PanelPopup();

    public PanelPopup getPnlPopupAllCommittedOffences() {
        return pnlPopupAllCommittedOffences;
    }

    public void setPnlPopupAllCommittedOffences(PanelPopup pp) {
        this.pnlPopupAllCommittedOffences = pp;
    }
    public HtmlCommandButton LoginButton = new HtmlCommandButton();

    public HtmlCommandButton getLoginButton() {
        return LoginButton;
    }

    public void setLoginButton(HtmlCommandButton LoginButton) {
        this.LoginButton = LoginButton;
    }
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }
    private DefaultSelectedData selectObjectOfCommittee = new DefaultSelectedData();

    public DefaultSelectedData getSelectObjectOfCommittee() {
        return selectObjectOfCommittee;
    }

    public void setSelectObjectOfCommittee(DefaultSelectedData selectObjectOfCommittee) {
        this.selectObjectOfCommittee = selectObjectOfCommittee;
    }
    private DefaultSelectedData selectedDataOfPenality = new DefaultSelectedData();

    public DefaultSelectedData getSelectedDataOfPenality() {
        return selectedDataOfPenality;
    }

    public ArrayList<Option> getPenaltyTypesListOption() {
        return penaltyTypesListOption;
    }

    public void setPenaltyTypesListOption(ArrayList<Option> penaltyTypesListOption) {
        this.penaltyTypesListOption = penaltyTypesListOption;
    }

    public void setSelectedDataOfPenality(DefaultSelectedData selectedDataOfPenality) {
        this.selectedDataOfPenality = selectedDataOfPenality;
    }
    private DefaultSelectedData selectObjectOfDecisionType = new DefaultSelectedData();

    public DefaultSelectedData getSelectObjectOfDecisionType() {
        return selectObjectOfDecisionType;
    }

    public void setSelectObjectOfDecisionType(DefaultSelectedData selectObjectOfDecisionType) {
        this.selectObjectOfDecisionType = selectObjectOfDecisionType;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputTextarea txtaDecisionExplanation = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDecisionExplanation() {
        return txtaDecisionExplanation;
    }

    public void setTxtaDecisionExplanation(HtmlInputTextarea hit) {
        this.txtaDecisionExplanation = hit;
    }
    private HtmlInputTextarea txtaPenalityShouldBeGivenForThisOffence = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaPenalityShouldBeGivenForThisOffence() {
        return txtaPenalityShouldBeGivenForThisOffence;
    }

    public void setTxtaPenalityShouldBeGivenForThisOffence(HtmlInputTextarea hit) {
        this.txtaPenalityShouldBeGivenForThisOffence = hit;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlCommandLink lnkToAccusedCommentPage = new HtmlCommandLink();

    public String getAgreeOnDefaultPenalty() {
        return agreeOnDefaultPenalty;
    }

    public void setAgreeOnDefaultPenalty(String agreeOnDefaultPenalty) {
        this.agreeOnDefaultPenalty = agreeOnDefaultPenalty;
    }

    public HtmlCommandLink getLnkToAccusedCommentPage() {
        return lnkToAccusedCommentPage;
    }

    public void setLnkToAccusedCommentPage(HtmlCommandLink btnToAccusedCommentPage) {
        this.lnkToAccusedCommentPage = btnToAccusedCommentPage;
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
    private HtmlSelectOneRadio radioGroupAgreeOnDefaultPenalty = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadioGroupAgreeOnDefaultPenalty() {
        return radioGroupAgreeOnDefaultPenalty;
    }

    public void setRadioGroupAgreeOnDefaultPenalty(HtmlSelectOneRadio hsor) {
        this.radioGroupAgreeOnDefaultPenalty = hsor;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbForwardToCommittee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbForwardToCommittee() {
        return ckbForwardToCommittee;
    }

    public void setCkbForwardToCommittee(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbForwardToCommittee = hsbc;
    }
    private HtmlSelectOneMenu drlCommittee = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommittee() {
        return drlCommittee;
    }

    public void setDrlCommittee(HtmlSelectOneMenu hsom) {
        this.drlCommittee = hsom;
    }
    private PanelLayout pnlLayoutDecisoion = new PanelLayout();

    public PanelLayout getPnlLayoutDecisoion() {
        return pnlLayoutDecisoion;
    }

    public void setPnlLayoutDecisoion(PanelLayout pl) {
        this.pnlLayoutDecisoion = pl;
    }
    private HtmlInputTextarea txtaPenaltyAcceptance = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaPenaltyAcceptance() {
        return txtaPenaltyAcceptance;
    }

    public void setTxtaPenaltyAcceptance(HtmlInputTextarea hit) {
        this.txtaPenaltyAcceptance = hit;
    }
    private HtmlInputTextarea txtaAccusationAcceptance = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaAccusationAcceptance() {
        return txtaAccusationAcceptance;
    }

    public void setTxtaAccusationAcceptance(HtmlInputTextarea hit) {
        this.txtaAccusationAcceptance = hit;
    }
    private HtmlOutputLabel lblAccusationAcceptanceValue = new HtmlOutputLabel();

    public HtmlOutputLabel getLblAccusationAcceptanceValue() {
        return lblAccusationAcceptanceValue;
    }

    public void setLblAccusationAcceptanceValue(HtmlOutputLabel hol) {
        this.lblAccusationAcceptanceValue = hol;
    }
    private HtmlOutputLabel lblPenaltyAcceptanceValue = new HtmlOutputLabel();

    public HtmlOutputLabel getLblPenaltyAcceptanceValue() {
        return lblPenaltyAcceptanceValue;
    }

    public void setLblPenaltyAcceptanceValue(HtmlOutputLabel hol) {
        this.lblPenaltyAcceptanceValue = hol;
    }
    private HtmlCommandLink lnkViewAccusedComment = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewAccusedComment() {
        return lnkViewAccusedComment;
    }

    public void setLnkViewAccusedComment(HtmlCommandLink lnkViewAccusedComment) {
        this.lnkViewAccusedComment = lnkViewAccusedComment;
    }
    private HtmlCommandLink cmdLinkViewPreviesDecisions = new HtmlCommandLink();

    public HtmlCommandLink getCmdLinkViewPreviesDecisions() {
        return cmdLinkViewPreviesDecisions;
    }

    public void setCmdLinkViewPreviesDecisions(HtmlCommandLink hcl) {
        this.cmdLinkViewPreviesDecisions = hcl;
    }
    private HtmlOutputLabel lblCommittee = new HtmlOutputLabel();

    public HtmlOutputLabel getLblCommittee() {
        return lblCommittee;
    }

    public void setLblCommittee(HtmlOutputLabel hol) {
        this.lblCommittee = hol;
    }
    private PanelPopup pnlPopupCommitteeMembers = new PanelPopup();

    public PanelPopup getPnlPopupCommitteeMembers() {
        return pnlPopupCommitteeMembers;
    }

    public void setPnlPopupCommitteeMembers(PanelPopup pp) {
        this.pnlPopupCommitteeMembers = pp;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
    }
    private HtmlOutputLabel lbDecision = new HtmlOutputLabel();

    public HtmlOutputLabel getLbDecision() {
        return lbDecision;
    }

    public void setLbDecision(HtmlOutputLabel hol) {
        this.lbDecision = hol;
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

    public void setLblSignInReminder(HtmlOutputLabel hol) {
        this.lblSignInReminder = hol;
    }
    private HtmlCommandLink lnkViewEyeWitnessComment = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewEyeWitnessComment() {
        return lnkViewEyeWitnessComment;
    }
    private HtmlSelectOneMenu drlSummaryOfWitness = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu drlSummaryOfWitnessOther = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSummaryOfWitnessOther() {
        return drlSummaryOfWitnessOther;
    }

    public void setDrlSummaryOfWitnessOther(HtmlSelectOneMenu drlSummaryOfWitnessOther) {
        this.drlSummaryOfWitnessOther = drlSummaryOfWitnessOther;
    }

    public HtmlSelectOneMenu getDrlSummaryOfWitness() {
        return drlSummaryOfWitness;
    }

    public void setDrlSummaryOfWitness(HtmlSelectOneMenu drlSummaryOfWitness) {
        this.drlSummaryOfWitness = drlSummaryOfWitness;
    }

    public ArrayList<EyeWitnessModel> getEyeWitnessesList() {
        return eyeWitnessesList;
    }

    public void setEyeWitnessesList(ArrayList<EyeWitnessModel> eyeWitnessesList) {
        this.eyeWitnessesList = eyeWitnessesList;
    }

    public void setLnkViewEyeWitnessComment(HtmlCommandLink hcl) {
        this.lnkViewEyeWitnessComment = hcl;
    }
    private HtmlSelectOneMenu drlNewPenalty = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNewPenalty() {
        return drlNewPenalty;
    }

    public EyeWitnessManager getEyeWitnessManager() {
        return eyeWitnessManager;
    }

    public void setEyeWitnessManager(EyeWitnessManager eyeWitnessManager) {
        this.eyeWitnessManager = eyeWitnessManager;
    }

    public ArrayList<Option> getSummaryList() {
        return summaryList;
    }

    public void setSummaryList(ArrayList<Option> summaryList) {
        this.summaryList = summaryList;
    }

    public void setDrlNewPenalty(HtmlSelectOneMenu hsom) {
        this.drlNewPenalty = hsom;
    }
    private PanelPopup pnlEyeWitnessesRegistration = new PanelPopup();
    private PanelPopup pnlEyeWitnessesRegistrationOther = new PanelPopup();

    public PanelPopup getPnlEyeWitnessesRegistrationOther() {
        return pnlEyeWitnessesRegistrationOther;
    }

    public void setPnlEyeWitnessesRegistrationOther(PanelPopup pnlEyeWitnessesRegistrationOther) {
        this.pnlEyeWitnessesRegistrationOther = pnlEyeWitnessesRegistrationOther;
    }

    public PanelPopup getPnlEyeWitnessesRegistration() {
        return pnlEyeWitnessesRegistration;
    }

    public void setPnlEyeWitnessesRegistration(PanelPopup pp) {
        this.pnlEyeWitnessesRegistration = pp;
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    private HtmlOutputText loginConfirmed1 = new HtmlOutputText();

    public HtmlOutputText getLoginConfirmed1() {
        return loginConfirmed1;
    }

    public void setLoginConfirmed1(HtmlOutputText hot) {
        this.loginConfirmed1 = hot;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private PanelPopup panelPopupMessageForCommeteComentes = new PanelPopup();

    public PanelPopup getPanelPopupMessageForCommeteComentes() {
        return panelPopupMessageForCommeteComentes;
    }

    public void setPanelPopupMessageForCommeteComentes(PanelPopup pp) {
        this.panelPopupMessageForCommeteComentes = pp;
    }
    private javax.faces.component.html.HtmlInputText employeeID_textField = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getEmployeeID_textField() {
        return employeeID_textField;
    }

    public void setEmployeeID_textField(javax.faces.component.html.HtmlInputText hit) {
        this.employeeID_textField = hit;
    }
    private javax.faces.component.html.HtmlInputText employeeName_textField = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getEmployeeName_textField() {
        return employeeName_textField;
    }

    public void setEmployeeName_textField(javax.faces.component.html.HtmlInputText hit) {
        this.employeeName_textField = hit;
    }
    private javax.faces.component.html.HtmlInputTextarea responsiblity_textArea = new javax.faces.component.html.HtmlInputTextarea();

    public javax.faces.component.html.HtmlInputTextarea getResponsiblity_textArea() {
        return responsiblity_textArea;
    }

    public void setResponsiblity_textArea(javax.faces.component.html.HtmlInputTextarea hit) {
        this.responsiblity_textArea = hit;
    }
    private HtmlInputSecret password_secretField = new HtmlInputSecret();

    public HtmlInputSecret getPassword_secretField() {
        return password_secretField;
    }

    public void setPassword_secretField(HtmlInputSecret his) {
        this.password_secretField = his;
    }
    private javax.faces.component.html.HtmlInputText userName_textField = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getUserName_textField() {
        return userName_textField;
    }

    public void setUserName_textField(javax.faces.component.html.HtmlInputText hit) {
        this.userName_textField = hit;
    }
    private HtmlCommandLink cmdview_Committee_Comments = new HtmlCommandLink();

    public HtmlCommandLink getCmdview_Committee_Comments() {
        return cmdview_Committee_Comments;
    }

    public void setCmdview_Committee_Comments(HtmlCommandLink hcl) {
        this.cmdview_Committee_Comments = hcl;
    }
    private PanelPopup pnlPopupComeeteeComenets = new PanelPopup();

    public PanelPopup getPnlPopupComeeteeComenets() {
        return pnlPopupComeeteeComenets;
    }

    public void setPnlPopupComeeteeComenets(PanelPopup pp) {
        this.pnlPopupComeeteeComenets = pp;
    }
    private HtmlPanelGrid panelGridPopupViewCommiteeCommentes = new HtmlPanelGrid();

    public HtmlPanelGrid getPanelGridPopupViewCommiteeCommentes() {
        return panelGridPopupViewCommiteeCommentes;
    }

    public void setPanelGridPopupViewCommiteeCommentes(HtmlPanelGrid hpg) {
        this.panelGridPopupViewCommiteeCommentes = hpg;
    }
    private com.icesoft.faces.component.ext.HtmlOutputText otxtViewCommeeteCommentesPopupHeader1 = new com.icesoft.faces.component.ext.HtmlOutputText();

    public com.icesoft.faces.component.ext.HtmlOutputText getOtxtViewCommeeteCommentesPopupHeader1() {
        return otxtViewCommeeteCommentesPopupHeader1;
    }

    public void setOtxtViewCommeeteCommentesPopupHeader1(com.icesoft.faces.component.ext.HtmlOutputText hot) {
        this.otxtViewCommeeteCommentesPopupHeader1 = hot;
    }
    private HtmlCommandButton btnClosePopupCommeeteComeentes = new HtmlCommandButton();

    public HtmlCommandButton getBtnClosePopupCommeeteComeentes() {
        return btnClosePopupCommeeteComeentes;
    }

    public void setBtnClosePopupCommeeteComeentes(HtmlCommandButton hcb) {
        this.btnClosePopupCommeeteComeentes = hcb;
    }
    private PanelLayout pnlLayoutCommeeteComentes = new PanelLayout();

    public PanelLayout getPnlLayoutCommeeteComentes() {
        return pnlLayoutCommeeteComentes;
    }

    public void setPnlLayoutCommeeteComentes(PanelLayout pl) {
        this.pnlLayoutCommeeteComentes = pl;
    }
    private PanelLayout pnlLayoutPopupCommeteeCommentes = new PanelLayout();

    public PanelLayout getPnlLayoutPopupCommeteeCommentes() {
        return pnlLayoutPopupCommeteeCommentes;
    }

    public void setPnlLayoutPopupCommeteeCommentes(PanelLayout pl) {
        this.pnlLayoutPopupCommeteeCommentes = pl;
    }
    private HtmlDataTable dataTableCommetesComentes = new HtmlDataTable();

    public HtmlDataTable getDataTableCommetesComentes() {
        return dataTableCommetesComentes;
    }

    public void setDataTableCommetesComentes(HtmlDataTable hdt) {
        this.dataTableCommetesComentes = hdt;
    }
    private UIColumn colCommeentsGivenDay = new UIColumn();

    public UIColumn getColCommeentsGivenDay() {
        return colCommeentsGivenDay;
    }

    public void setColCommeentsGivenDay(UIColumn uic) {
        this.colCommeentsGivenDay = uic;
    }
    private javax.faces.component.html.HtmlInputText txt_CommeentsGivenDay = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_CommeentsGivenDay() {
        return txt_CommeentsGivenDay;
    }

    public void setTxt_CommeentsGivenDay(javax.faces.component.html.HtmlInputText hit) {
        this.txt_CommeentsGivenDay = hit;
    }
    private HtmlInputText txt_DeductAmount = new HtmlInputText();

    public HtmlInputText getTxt_DeductAmount() {
        return txt_DeductAmount;
    }

    public void setTxt_DeductAmount(HtmlInputText hit) {
        this.txt_DeductAmount = hit;
    }
    private HtmlInputText txt_Duration = new HtmlInputText();

    public HtmlInputText getTxt_Duration() {
        return txt_Duration;
    }

    public void setTxt_Duration(HtmlInputText hit) {
        this.txt_Duration = hit;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private javax.faces.component.html.HtmlSelectOneMenu drl_suggestedPenality = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_suggestedPenality() {
        return drl_suggestedPenality;
    }

    public void setDrl_suggestedPenality(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.drl_suggestedPenality = hsom;
    }
    private PopupBean panelPopup1Bean1 = new PopupBean();

    public PopupBean getPanelPopup1Bean1() {
        return panelPopup1Bean1;
    }

    public void setPanelPopup1Bean1(PopupBean pb) {
        this.panelPopup1Bean1 = pb;
    }
    private PanelPopup panelPopup_CommeeteChairMan = new PanelPopup();
    private PanelPopup panelPopup_revocPenality = new PanelPopup();

    public PanelPopup getPanelPopup_revocPenality() {
        return panelPopup_revocPenality;
    }

    public void setPanelPopup_revocPenality(PanelPopup panelPopup_revocPenality) {
        this.panelPopup_revocPenality = panelPopup_revocPenality;
    }

    public PanelPopup getPanelPopup_CommeeteChairMan() {
        return panelPopup_CommeeteChairMan;
    }

    public void setPanelPopup_CommeeteChairMan(PanelPopup pp) {
        this.panelPopup_CommeeteChairMan = pp;
    }
    private PanelLayout pnlMessageBodyAllChairMan = new PanelLayout();
    private PanelLayout pnlMessageRevocPenality = new PanelLayout();

    public PanelLayout getPnlMessageRevocPenality() {
        return pnlMessageRevocPenality;
    }

    public void setPnlMessageRevocPenality(PanelLayout pnlMessageRevocPenality) {
        this.pnlMessageRevocPenality = pnlMessageRevocPenality;
    }

    public PanelLayout getPnlMessageBodyAllChairMan() {
        return pnlMessageBodyAllChairMan;
    }

    public void setPnlMessageBodyAllChairMan(PanelLayout pl) {
        this.pnlMessageBodyAllChairMan = pl;
    }
    private HtmlInputTextarea txt_ChairMan_Commentes = new HtmlInputTextarea();
    private HtmlInputTextarea txt_Approver_RevocPenality = new HtmlInputTextarea();

    public HtmlInputTextarea getTxt_Approver_RevocPenality() {
        return txt_Approver_RevocPenality;
    }

    public void setTxt_Approver_RevocPenality(HtmlInputTextarea txt_Approver_RevocPenality) {
        this.txt_Approver_RevocPenality = txt_Approver_RevocPenality;
    }

    public HtmlInputTextarea getTxt_ChairMan_Commentes() {
        return txt_ChairMan_Commentes;
    }

    public void setTxt_ChairMan_Commentes(HtmlInputTextarea hit) {
        this.txt_ChairMan_Commentes = hit;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
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
    private HtmlSelectOneMenu drl_ChairMan_suggetedPenality = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_ChairMan_suggetedPenality() {
        return drl_ChairMan_suggetedPenality;
    }

    public void setDrl_ChairMan_suggetedPenality(HtmlSelectOneMenu hsom) {
        this.drl_ChairMan_suggetedPenality = hsom;
    }
    private HtmlInputText txt_ChairMan_deductAmoun = new HtmlInputText();

    public HtmlInputText getTxt_ChairMan_deductAmoun() {
        return txt_ChairMan_deductAmoun;
    }

    public void setTxt_ChairMan_deductAmoun(HtmlInputText hit) {
        this.txt_ChairMan_deductAmoun = hit;
    }
    private HtmlInputText txt_chairMan_Duration = new HtmlInputText();

    public HtmlInputText getTxt_chairMan_Duration() {
        return txt_chairMan_Duration;
    }

    public void setTxt_chairMan_Duration(HtmlInputText hit) {
        this.txt_chairMan_Duration = hit;
    }
    private HtmlCommandLink cmd_Post_chairMan_Commeete = new HtmlCommandLink();

    public HtmlCommandLink getCmd_Post_chairMan_Commeete() {
        return cmd_Post_chairMan_Commeete;
    }

    public void setCmd_Post_chairMan_Commeete(HtmlCommandLink hcl) {
        this.cmd_Post_chairMan_Commeete = hcl;
    }
    private HtmlOutputLabel lbl_commeents_Given_day = new HtmlOutputLabel();
    private HtmlOutputLabel lbl_commeents_Given_dayrevoc = new HtmlOutputLabel();

    public HtmlOutputLabel getLbl_commeents_Given_dayrevoc() {
        return lbl_commeents_Given_dayrevoc;
    }

    public void setLbl_commeents_Given_dayrevoc(HtmlOutputLabel lbl_commeents_Given_dayrevoc) {
        this.lbl_commeents_Given_dayrevoc = lbl_commeents_Given_dayrevoc;
    }

    public HtmlOutputLabel getLbl_commeents_Given_day() {
        return lbl_commeents_Given_day;
    }

    public void setLbl_commeents_Given_day(HtmlOutputLabel hol) {
        this.lbl_commeents_Given_day = hol;
    }
    private HtmlOutputLabel lbl_SuggetedPenalty = new HtmlOutputLabel();

    public HtmlOutputLabel getLbl_SuggetedPenalty() {
        return lbl_SuggetedPenalty;
    }

    public void setLbl_SuggetedPenalty(HtmlOutputLabel hol) {
        this.lbl_SuggetedPenalty = hol;
    }
    private HtmlInputText txt_Suggested_deduct = new HtmlInputText();

    public HtmlInputText getTxt_Suggested_deduct() {
        return txt_Suggested_deduct;
    }

    public void setTxt_Suggested_deduct(HtmlInputText hit) {
        this.txt_Suggested_deduct = hit;
    }
    private HtmlInputText txt_suggetd_duration = new HtmlInputText();

    public HtmlInputText getTxt_suggetd_duration() {
        return txt_suggetd_duration;
    }

    public void setTxt_suggetd_duration(HtmlInputText hit) {
        this.txt_suggetd_duration = hit;
    }
    private HtmlInputText txt_approved_deduction = new HtmlInputText();

    public HtmlInputText getTxt_approved_deduction() {
        return txt_approved_deduction;
    }

    public void setTxt_approved_deduction(HtmlInputText hit) {
        this.txt_approved_deduction = hit;
    }
    private HtmlInputText txt_approved_duration = new HtmlInputText();

    public HtmlInputText getTxt_approved_duration() {
        return txt_approved_duration;
    }

    public void setTxt_approved_duration(HtmlInputText hit) {
        this.txt_approved_duration = hit;
    }
    private HtmlInputTextarea intxt_lastApprover_commeentes = new HtmlInputTextarea();

    public HtmlInputTextarea getIntxt_lastApprover_commeentes() {
        return intxt_lastApprover_commeentes;
    }

    public void setIntxt_lastApprover_commeentes(HtmlInputTextarea hit) {
        this.intxt_lastApprover_commeentes = hit;
    }
    private HtmlOutputLabel lbl_approved_Penalty = new HtmlOutputLabel();

    public HtmlOutputLabel getLbl_approved_Penalty() {
        return lbl_approved_Penalty;
    }

    public void setLbl_approved_Penalty(HtmlOutputLabel hol) {
        this.lbl_approved_Penalty = hol;
    }
    private HtmlOutputLabel lbNewPenalty = new HtmlOutputLabel();

    public HtmlOutputLabel getLbNewPenalty() {
        return lbNewPenalty;
    }

    public void setLbNewPenalty(HtmlOutputLabel hol) {
        this.lbNewPenalty = hol;
    }
    private HtmlOutputLabel lbl_approvedPen = new HtmlOutputLabel();

    public HtmlOutputLabel getLbl_approvedPen() {
        return lbl_approvedPen;
    }

    public void setLbl_approvedPen(HtmlOutputLabel hol) {
        this.lbl_approvedPen = hol;
    }
    private HtmlCommandLink cmd_view_ChairMan_Commeents = new HtmlCommandLink();

    public HtmlCommandLink getCmd_view_ChairMan_Commeents() {
        return cmd_view_ChairMan_Commeents;
    }

    public void setCmd_view_ChairMan_Commeents(HtmlCommandLink hcl) {
        this.cmd_view_ChairMan_Commeents = hcl;
    }
    private HtmlInputText txt_Promotion_Suspend = new HtmlInputText();

    public HtmlInputText getTxt_Promotion_Suspend() {
        return txt_Promotion_Suspend;
    }

    public void setTxt_Promotion_Suspend(HtmlInputText hit) {
        this.txt_Promotion_Suspend = hit;
    }
    private HtmlInputText txt_Promotion_Duraion = new HtmlInputText();

    public HtmlInputText getTxt_Promotion_Duraion() {
        return txt_Promotion_Duraion;
    }

    public void setTxt_Promotion_Duraion(HtmlInputText hit) {
        this.txt_Promotion_Duraion = hit;
    }
    private HtmlInputText txt_SpendedTranfer = new HtmlInputText();

    public HtmlInputText getTxt_SpendedTranfer() {
        return txt_SpendedTranfer;
    }

    public void setTxt_SpendedTranfer(HtmlInputText hit) {
        this.txt_SpendedTranfer = hit;
    }
    private HtmlInputText txt_TransferDuration = new HtmlInputText();

    public HtmlInputText getTxt_TransferDuration() {
        return txt_TransferDuration;
    }

    public void setTxt_TransferDuration(HtmlInputText hit) {
        this.txt_TransferDuration = hit;
    }
    private HtmlInputText txt_Document_Referance = new HtmlInputText();

    public HtmlInputText getTxt_Document_Referance() {
        return txt_Document_Referance;
    }

    public void setTxt_Document_Referance(HtmlInputText hit) {
        this.txt_Document_Referance = hit;
    }
    private HtmlInputTextarea in_txt_area_CourtDecision = new HtmlInputTextarea();

    public HtmlInputTextarea getIn_txt_area_CourtDecision() {
        return in_txt_area_CourtDecision;
    }

    public void setIn_txt_area_CourtDecision(HtmlInputTextarea hit) {
        this.in_txt_area_CourtDecision = hit;
    }
    private HtmlCommandButton btn_Revoce_Post = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Revoce_Post() {
        return btn_Revoce_Post;
    }

    public void setBtn_Revoce_Post(HtmlCommandButton hcb) {
        this.btn_Revoce_Post = hcb;
    }
    private HtmlCommandLink cmd_otherWord = new HtmlCommandLink();

    public HtmlCommandLink getCmd_otherWord() {
        return cmd_otherWord;
    }

    public void setCmd_otherWord(HtmlCommandLink hcl) {
        this.cmd_otherWord = hcl;
    }
    private HtmlCommandLink cmd_OtherWord = new HtmlCommandLink();

    public HtmlCommandLink getCmd_OtherWord() {
        return cmd_OtherWord;
    }

    public void setCmd_OtherWord(HtmlCommandLink hcl) {
        this.cmd_OtherWord = hcl;
    }
    private HtmlOutputLabel out_txt_deciderID = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_txt_deciderID() {
        return out_txt_deciderID;
    }

    public void setOut_txt_deciderID(HtmlOutputLabel hol) {
        this.out_txt_deciderID = hol;
    }
    private HtmlOutputLabel out_txt_deciderName = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_txt_deciderName() {
        return out_txt_deciderName;
    }

    public void setOut_txt_deciderName(HtmlOutputLabel hol) {
        this.out_txt_deciderName = hol;
    }
    private HtmlOutputLabel out_txt_DeciderDepartment = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_txt_DeciderDepartment() {
        return out_txt_DeciderDepartment;
    }

    public void setOut_txt_DeciderDepartment(HtmlOutputLabel hol) {
        this.out_txt_DeciderDepartment = hol;
    }
    private HtmlOutputLabel out_txt_DeciderPosition = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_txt_DeciderPosition() {
        return out_txt_DeciderPosition;
    }

    public void setOut_txt_DeciderPosition(HtmlOutputLabel hol) {
        this.out_txt_DeciderPosition = hol;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlSelectOneMenu drl_disciplineForManager = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_disciplineForManager() {
        return drl_disciplineForManager;
    }

    public void setDrl_disciplineForManager(HtmlSelectOneMenu hsom) {
        this.drl_disciplineForManager = hsom;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
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
//    private HtmlSelectOneMenu drlPenaltyForManger = new HtmlSelectOneMenu();
//
//    public HtmlSelectOneMenu getDrlPenaltyForManger() {
//        return drlPenaltyForManger;
//    }
//
//    public void setDrlPenaltyForManger(HtmlSelectOneMenu hsom) {
//        this.drlPenaltyForManger = hsom;
//    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlPenaltyForManger1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPenaltyForManger1() {
        return drlPenaltyForManger1;
    }

    public void setDrlPenaltyForManger1(HtmlSelectOneMenu hsom) {
        this.drlPenaltyForManger1 = hsom;
    }
    private HtmlCommandLink cmdAccepatnce = new HtmlCommandLink();

    public HtmlCommandLink getCmdAccepatnce() {
        return cmdAccepatnce;
    }

    public void setCmdAccepatnce(HtmlCommandLink hcl) {
        this.cmdAccepatnce = hcl;
    }
    private HtmlCommandLink cmdInterset = new HtmlCommandLink();

    public HtmlCommandLink getCmdInterset() {
        return cmdInterset;
    }

    public void setCmdInterset(HtmlCommandLink hcl) {
        this.cmdInterset = hcl;
    }
    private InputFile inputFile1_CommiteeMinute = new InputFile();

    public InputFile getInputFile1_CommiteeMinute() {
        return inputFile1_CommiteeMinute;
    }

    public void setInputFile1_CommiteeMinute(InputFile if0) {
        this.inputFile1_CommiteeMinute = if0;
    }
    private HtmlCommandLink cmd_downLoad = new HtmlCommandLink();

    public HtmlCommandLink getCmd_downLoad() {
        return cmd_downLoad;
    }

    public void setCmd_downLoad(HtmlCommandLink hcl) {
        this.cmd_downLoad = hcl;
    }


    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DisciplineApprovePage() {
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
        // txt_CommeentsGivenDay.setValue("this is test ");
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
        if (pendingRequestLists.isEmpty()) {
            pendingRequestLists = disciplineApproveManager.getRequestsToBeProcessed();

        } else {
        }
        if (decisionMadeByEmployeeLists.isEmpty()) {
            decisionMadeByEmployeeLists = disciplineApproveManager.getDecisionMadeByEmployee();//new ArrayList<Option>();
        } else {
        }
        if (committeeForwardList.isEmpty()) {
            committeeForwardList = disciplineApproveManager.getCommeeteforwardListByApprover();
        } else {
        }
        sizeOfCommitee = committeeManager.getAllCommiteeSize(disciplineCommiteeId);


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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CustomValidations getCustomValidations() {
        return (CustomValidations) getBean("CustomValidations");
    } // </editor-fold>
/////////////////////////////////////////////////////////////////////////////////////////////
    String loggedInEmployeeId;
    String loggedInEmployeeDept;
    String disciplinedEmployeeId;
    int loggedInEmployeeDeptID;
    String userName;
    CommitteeMinuteFileUpLoad fileUpLoad = new CommitteeMinuteFileUpLoad();
    ArrayList<AccusedFileUpLoad> commeentesFile = new ArrayList<AccusedFileUpLoad>();
    // AccusedFileUpLoad fileUpLoad = new AccusedFileUpLoad();
    EmployeeManage employeeManager = new EmployeeManage();
    EyeWitnessManager eyeWitnessManager = new EyeWitnessManager();
    DisciplineRequestManager disciplineRequestManager = new DisciplineRequestManager();
    DisciplineApproveManager disciplineApproveManager = new DisciplineApproveManager();
    DisciplineRegistrationManager disciplineRegistrationManager = new DisciplineRegistrationManager();
    CommitteeMemberModel newCommentes = new CommitteeMemberModel();
    PenaltyRegistrationManager penaltyRegistrationManager = new PenaltyRegistrationManager();
    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();
    CommitteeMemberRegistrationManager committeeManager = new CommitteeMemberRegistrationManager();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    AccusedDefenceManager accusedDefenceManager = new AccusedDefenceManager();
    DisciplineRequestModel disciplineRequestModel = new DisciplineRequestModel();
    PenaltyTypeModel penalityTypeModel = new PenaltyTypeModel();
    ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee = new ArrayList<DisciplineRequestModel>();
//    ArrayList<HashMap> committeeMembersList = new ArrayList<HashMap>();
    // ArrayList<CommtteeComments> committeeCommentes = new ArrayList<CommtteeComments>();
    ArrayList<CommitteeMemberModel> committeeMembersList = new ArrayList<CommitteeMemberModel>();
    ChairManCommentes chairman = new ChairManCommentes();
    RejectedPenalityComeentes rejectPenality = new RejectedPenalityComeentes();
    ArrayList<EyeWitnessModel> eyeWitnessesList = new ArrayList<EyeWitnessModel>();
    ArrayList<OtherMemberEyeWitnessModel> eyeWitnessesListOther = new ArrayList<OtherMemberEyeWitnessModel>();
    ArrayList<Option> disciplineTypesList = disciplineRequestManager.getDisciplineTypes();
    ArrayList<Option> disciplineTypesListForManager = disciplineRequestManager.getDisciplineTypesForManager();
    ArrayList<Option> availableDecisionsToMake = new ArrayList<Option>();//disciplineApproveManager.getAvailableDecisionToMake();
    //ArrayList<SelectItem> committeeLists = disciplineApproveManager.getActiveDesciplineCommittees();// new ArrayList<Option>();
    ArrayList<SelectItem> committeeLists = disciplineApproveManager.getActiveDesciplineCommittees();// new ArrayList<Option>();
    ArrayList<Option> pendingRequestLists = new ArrayList<Option>();//disciplineRequestManager.getPendingRequests();
    ArrayList<Option> decisionMadeByEmployeeLists = new ArrayList<Option>();
    ArrayList<Option> committeeForwardList = new ArrayList<Option>();
    ArrayList<Option> penaltyTypesListOptionForManager = penaltyRegistrationManager.getAllPenaltyTypesOptionForManager();//
    ArrayList<Option> penaltyTypesListOption = penaltyRegistrationManager.getPenaltyTypesOption();//
    ArrayList<Option> summaryList = new ArrayList<Option>();
    //ArrayList<Option> summaryList = eyeWitnessManager.getEyeWitnessSummaryTypes();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    ArrayList<CommeeteeCommentsGiven> comeeteeCommentsGive = new ArrayList<CommeeteeCommentsGiven>();
    public String IMMEDIATEBOSS = DisciplineRequestManager.REQUERSTER_TYPE_IMMEDIATEBOSS;
    public String ANOTHEREMPLOYEE = DisciplineRequestManager.REQUERSTER_TYPE_ANOTHEREMPLOYEE;
    public String NOTEMPLOYEE = DisciplineRequestManager.REQUERSTER_TYPE_NOTEMPLOYEE;
    public int disciplineProblemId;// DISCIPLINE_PROBLEM_ID
    int disciplineProcessedId;
    public int disciplineCommiteeId = 5;
    public int sizeOfCommitee = 0;
    public double salary;
    public int duration = 0;
    public float penaliyedDays = 0;
    public boolean approveStatus = false;
    String employeeStatus = null;
    String forwareToCommeete = null;
    String newPenalityProposed = null;//This is the penality that the approver propose for the discipline committee
    String requesterType = null;//REQUESTER_TYPE
    String requesterId = null;    //REQUESTER_ID
    String offenderId = null;//OFFENDER_ID always employee
    String dateOfOffence = null;//DATE_OF_OFFENCE//when does it happen
    String reportedDate = null;//REPORTED_DATE//reported to the hrms about the discipline Problem
    String offenceType = null;// OFFENCE_TYPE,//if it is registerd in the table HR_DISCIPLINE_TYPE, ELSE "Other"
    String offenceTypeForManager = null;
    String catagory;
    String penality_deduction;
    String subCatagory;
    public int repititionOfOffence = -1;//REPITITION_OF_OFFENCE//how many times does it occured before the phase out time
    //int reputaionOFDiscipline
    String descriptionOfOffence = null;//DESCRIPTION_OF_OFFENCE//details
    String approverGivenCommeents = null;//This is the Approval given Commeents
    String requestedMeasureToBeTaken = null;//REQUESTED_MEASURE_TO_BE_TAKEN
    String currentStatus = null;//STATUS
    // String reportddate=null;
    String isDocumentAttached = null;//IS_DOCUMENT_ATTACHED
    String agreeOnDefaultPenalty = null;
    String expectedPenalty;
    int deciderCommitteeId = 5;
    public String fileName = "";
    private String mimeType;
    private boolean downloadAvailable;
    private Resource faResource;
    private List pendingRequestListsForTenacity = new ArrayList<DisciplineApproveManager>();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private int disciplineRow = -1;
    byte[] commeentsFile = null;
    byte[] intersetFile = null;
    private String filePath = null;
    private String fileExtenstion = "";

    private boolean populateRequesterTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(employeeId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateEmployeeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtEmployeeDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtEmployeeId.setValue(employeeId);
                txtEmployeePosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void populateApproverTextComponents(String approverId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = loggedInEmployeeId;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
            //  txtDeciderId.setDisabled(false);
            } else {
                try {
                    loggedInEmployeeDeptID = Integer.parseInt(empInfoHashMap.get("employeeDepartment").toString());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }

    private void fillExpectedPenalty(int requestId, String offenceType, int repititionOfOffence, String currentStatus) {

        String penaltyAttributes[] = penaltyRegistrationManager.getPenaltyOfOffence(offenceType, repititionOfOffence).split(":::");
        txtaPenalityShouldBeGivenForThisOffence.setValue(penaltyAttributes[1]);
        if (currentStatus.equals(DisciplineApproveManager.INITIAL_STATE_DISCIPLINE)) {
            drlNewPenalty.setValue(penaltyAttributes[0]);
        } else {
            drlNewPenalty.setValue(disciplineApproveManager.getNewPenaltyProposedOnRequest(1));
        }
    }

    private boolean populateDisciplineTextComponents(DisciplineRequestModel disciplineRequestModel) {
        repititionOfOffence = disciplineRequestModel.getRepititionOfOffence();
        txtDisciplineDate.setValue(disciplineRequestModel.getDateOfOffence());
        txtReportedDate.setValue(disciplineRequestModel.getReportedDate());//reset date
        txtaDisciplineDescription.setValue(disciplineRequestModel.getDescriptionOfOffence());
        txtaDisciplineDecisionTobeTaken.setValue(disciplineRequestModel.getRequestedMeasureToBeTaken());
        txtaPenalityShouldBeGivenForThisOffence.setValue(disciplineRequestModel.getExpectedPenalityToBeGiven());
        txt_DeductAmount.setValue(disciplineRequestModel.getDeductAmount());
        txt_Duration.setValue(disciplineRequestModel.getDeductionDuration());
        txt_Promotion_Suspend.setValue(disciplineRequestModel.getSuspennedPromotion());
        txt_SpendedTranfer.setValue(disciplineRequestModel.getSuspendedTransfer());
        txt_TransferDuration.setValue(disciplineRequestModel.getTransferSupendedDuration());
        txt_Promotion_Duraion.setValue(disciplineRequestModel.getPromotionSuspendedDuration());
        txtDisciplinePreviousOccurance.setValue(repititionOfOffence);
        txtDocReferenceNumber.setValue(disciplineRequestModel.getDocumentReferenceNumber());
        currentStatus = disciplineRequestModel.getStatus();
        offenceType = disciplineRequestModel.getOffenceType();

        if (employeeStatus.equalsIgnoreCase("Manager")) {
            setSelectedDisciplineTypeForManager(offenceType);
        } else {
            setSelectedDisciplineType(offenceType);
        }

        //fillExpectedPenalty(disciplineRequestModel.getDisciplineProblemId(), offenceType, repititionOfOffence, currentStatus);
        return true;
    }

    private boolean populateReporterTextComponents(DisciplineRequestModel disciplineRequestModel) {

        out_txt_deciderID.setValue(disciplineRequestModel.getReporterID());
        out_txt_deciderName.setValue(disciplineRequestModel.getReporterFullName());
        out_txt_DeciderDepartment.setValue(disciplineRequestModel.getReporterDepartment());
        out_txt_DeciderPosition.setValue(disciplineRequestModel.getReporterPosition());
        return true;
    }

    public boolean setSelectedDisciplineType(String disciplineType) {
        for (Option lookingFor : disciplineTypesList) {
            if (lookingFor.getValue().toString().startsWith(disciplineType)) {
                drlDisciplineType.setValue(lookingFor.getValue().toString());
                return true;
            }
        }
        return false;
    }

    public boolean setSelectedDisciplineTypeForManager(String disciplineType) {
        for (Option lookingFor : disciplineTypesListForManager) {
            if (lookingFor.getValue().toString().startsWith(disciplineType)) {
                drlDisciplineType.setRendered(false);
                drl_disciplineForManager.setRendered(true);
                drl_disciplineForManager.setValue(lookingFor.getValue().toString());
                drlNewPenalty.setRendered(false);
                drlPenaltyForManger1.setRendered(true);
                return true;
            }
        }
        return false;
    }

    public boolean setSelectedPenaltyType(String penaltyType)
    {

        for (Option lookingFor : penaltyTypesListOption) {
            if (lookingFor.getValue().toString().startsWith(penaltyType)) {
                drlNewPenalty.setValue(lookingFor.getValue().toString());
                return true;
            }
        }
        return false;
    }

    private void populateDecisionHistory(int requestId) {
        decisionsMadeOnRequest = disciplineApproveManager.getRequestHistory(requestId);

        if (decisionsMadeOnRequest.size() > 0) {
            cmdLinkViewPreviesDecisions.setRendered(true);
        } else {
            cmdLinkViewPreviesDecisions.setRendered(false);
        // makePageReadyForUpdate();
        }
    }

    private void populateComeeteeComeents(int diciplineId) {

        comeeteeCommentsGive = disciplineApproveManager.getCommiteeComentes(diciplineId);

        if (comeeteeCommentsGive.size() >= sizeOfCommitee) {
            cmd_view_ChairMan_Commeents.setRendered(true);
            cmdview_Committee_Comments.setRendered(true);
            cmdLinkConfirmCommitteeDecisions.setDisabled(true);

        //cmdLinkConfirmCommitteeDecisions

        } else {
            cmdLinkConfirmCommitteeDecisions.setDisabled(false);
            cmdview_Committee_Comments.setRendered(true);
        }

    }

    private void disablecommentspopoUp() {
        employeeID_textField.setDisabled(true);
        employeeName_textField.setDisabled(true);
        responsiblity_textArea.setDisabled(true);
        txt_CommeentsGivenDay.setDisabled(true);
        txt_Suggested_deduct.setDisabled(true);
        txt_Promotion_Suspend.setDisabled(true);
        txt_TransferDuration.setDisabled(true);
        txt_SpendedTranfer.setDisabled(true);
        txt_Promotion_Duraion.setDisabled(true);
        txt_suggetd_duration.setDisabled(true);
        txt_approved_deduction.setDisabled(true);
        txt_approved_duration.setDisabled(true);
    }

    private void disableChairManpopUp() {
        txt_ChairMan_Commentes.setDisabled(true);
        txt_ChairMan_deductAmoun.setDisabled(true);
        txt_chairMan_Duration.setDisabled(true);
        drl_ChairMan_suggetedPenality.setDisabled(true);


    }

    private void disableRevocPenalitypopUp() {
        txt_Approver_RevocPenality.setDisabled(true);
        in_txt_area_CourtDecision.setDisabled(true);
        txt_Document_Referance.setDisabled(true);



    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        txtRequesterId.setDisabled(true);
        requesterId = null;
    }

    private void clearDisciplineTextComponents() {
        txtDocReferenceNumber.setValue(null);
        txtDisciplineDate.setValue(null);
        txtaDisciplineDescription.setValue(null);
        txtaDisciplineDecisionTobeTaken.setValue(null);
        txtReportedDate.setValue(dateFormat.format(new Date()));//reset date
        txtDisciplinePreviousOccurance.setValue(null);
        drlDisciplineType.resetValue();
        drl_disciplineForManager.resetValue();
    }

    private void clearDecisionComponents() {
        txtaDecisionExplanation.setValue(null);
        drlDecision.resetValue();
        radioGroupAgreeOnDefaultPenalty.resetValue();
        drlCommittee.resetValue();
        ckbForwardToCommittee.setSelected(false);
    }

    private void clearEmployeeTextComponents() {
        txtEmployeeId.setValue(null);
        txtEmployeeDepartment.setValue(null);
        txtEmployeeFullName.setValue(null);
        txtEmployeePosition.setValue(null);
    }

    private void clearAllComponents() {

        clearDisciplineTextComponents();
        clearRequesterTextComponents();
        clearEmployeeTextComponents();
        selectedObjectPending.setSelectedObject(null);
        pendingRequestLists = disciplineApproveManager.getRequestsToBeProcessed();
        loadPendingRequest();
    //  pendingRequestLists = disciplineRequestManager.getPendingRequests();
    }

    private void disableDiscionComponents() {
//       radioGroupAgreeOnDefaultPenalty.setDisabled(true);
//       txtaDecisionExplanation.setDisabled(true);
//       drlDecision.setDisabled(true);
//       ckbForwardToCommittee.setDisabled(true);
//       btnPostDecision.setDisabled(true);
//       drlCommittee.setDisabled(true);
//       drlNewPenalty.setDisabled(true);
//       ckbForwardToCommittee.setDisabled(true);
    }

    private void disableForWardToCommeeteDiscionComponents() {
        radioGroupAgreeOnDefaultPenalty.setDisabled(true);
        txtaDecisionExplanation.setDisabled(true);
        drlDecision.setDisabled(true);
        ckbForwardToCommittee.setDisabled(true);
        btnPostDecision.setDisabled(true);
        drlCommittee.setDisabled(true);
        drlNewPenalty.setDisabled(true);
        ckbForwardToCommittee.setDisabled(true);
    }

    private void enableDiscionComponents() {
        radioGroupAgreeOnDefaultPenalty.setDisabled(false);
        txtaDecisionExplanation.setDisabled(false);
        drlDecision.setDisabled(false);
        ckbForwardToCommittee.setDisabled(false);
        btnPostDecision.setDisabled(false);
        drlCommittee.setDisabled(false);
        ckbForwardToCommittee.setDisabled(false);
    }

    public String convertPenaltyValueToDescription(String value) {
        String description = "";
        if (value.equals("FAP")) {
            description = "Fully Accepted";
        } else if (value.equals("PAP")) {
            description = "Partially Accepted";
        } else if (value.equals("DAP")) {
            description = "Dont Accepted";
        }
        return description;
    }

    public String convertAccusationValueToDescription(String value) {
        String description = "";
        if (value.equals("FAA")) {
            description = "Fully Accepted";
        } else if (value.equals("PAA")) {
            description = "Partially Accepted";
        } else if (value.equals("DAA")) {
            description = "Dont Accepted";
        }
        return description;
    }

    private void populateAccusedComment(ArrayList<AccusedDefenceModel> accusedDefenceModelList) {
        if (accusedDefenceModelList.size() > 0) {//if comment posted, display it
            AccusedDefenceModel currentComment = accusedDefenceModelList.get(0);
            txtaPenaltyAcceptance.setValue(currentComment.getDescriptionOfAccusation().toString());
            txtaAccusationAcceptance.setValue(currentComment.getDescriptionOfPenalty().toString());
            lblAccusationAcceptanceValue.setValue(convertAccusationValueToDescription(currentComment.getAcceptAccusation().toString()));
            lblPenaltyAcceptanceValue.setValue(convertPenaltyValueToDescription(currentComment.getAcceptPenalty().toString()));
        }
    }

    private void populateAllComponents(DisciplineRequestModel disciplineRequestModel) {
        populateRequesterTextComponents(disciplineRequestModel.getRequesterId());
        populateEmployeeTextComponents(disciplineRequestModel.getOffenderId());
        populateReporterTextComponents(disciplineRequestModel);
        populateDisciplineTextComponents(disciplineRequestModel);
        populateDecisionHistory(disciplineRequestModel.getDisciplineProblemId());
        populateComeeteeComeents(disciplineRequestModel.getDisciplineProblemId());
    }

    private boolean validateDecision() {
        if (txtaDecisionExplanation.getValue() == null) {
            showSuccessOrFailureMessage(false, "GIVE COMMENT AND/OR SELECT FIRST");
            return false;
        } else if (ckbForwardToCommittee.isSelected() && drlCommittee.getValue().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT COMMITTEE");
            return false;
        } else if ((!ckbForwardToCommittee.isSelected()) && drlDecision.getValue().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT DECISION");
            return false;
        }
        //  else if (agreeOnDefaultPenalty == null) {
//            showSuccessOrFailureMessage(false, "SELECT YOUR AGREEMENT ON DEFAULT PENALTY");
//            return false;
//           } else if (drlNewPenalty.getValue().toString().equals("-1")) {
//                showSuccessOrFailureMessage(false, "SELECT NEW PENALTY ");
//                  return false;
//        }

        return true;
    }

    public String btnPostDecision_action() {
        if (validateDecision()) {
            if (employeeStatus.equalsIgnoreCase("Manager")) {
                newPenalityProposed = drlPenaltyForManger1.getValue().toString();

            } else if (employeeStatus.equalsIgnoreCase("Normal")) {
                newPenalityProposed = drlNewPenalty.getValue().toString();
            }
            String decision = "";
            String suggestedPenalityDuration = "";
            double suggestedPenalityDeduct = 0.0;
            double approvedPenltyDeduct = 0.0;
            String approvedPenltyDuration = "0";
            String lastApproverCommentes = "";
            String approverCommentesForFiear = "";
            String suggetedPenality = "";
            String newPenalty = "";
            String approvedPenality = "";
            String promotionSuspended = "";
            String transferSuspende = "";
            String promotionDuration = "";
            String transferDuration = "";

            if (ckbForwardToCommittee.isSelected()) {
                decision = drlCommittee.getValue().toString() + "$$" + currentStatus;
                approvedPenltyDeduct = 0.0;
                approvedPenltyDuration = "0";
                lastApproverCommentes = "";
                approverCommentesForFiear = txtaDecisionExplanation.getValue().toString();
                suggetedPenality = lbl_SuggetedPenalty.getValue().toString();
                suggestedPenalityDeduct = Double.parseDouble(txt_Suggested_deduct.getValue().toString());
                suggestedPenalityDuration = txt_suggetd_duration.getValue().toString();
            } else if (agreeOnDefaultPenalty.equals("Fair")) {

                approvedPenltyDeduct = 0.0;
                approvedPenltyDuration = "0";
                approverCommentesForFiear = txtaDecisionExplanation.getValue().toString();
                suggestedPenalityDuration = "";
                suggestedPenalityDeduct = 0.0;
                suggetedPenality = "";
                forwareToCommeete = "NO";
                decision = drlDecision.getValue().toString();
            } else if (forwareToCommeete.equalsIgnoreCase("Yes")) {

                approverCommentesForFiear = approverGivenCommeents;
                suggetedPenality = lbl_SuggetedPenalty.getValue().toString();
                suggestedPenalityDeduct = Double.parseDouble(txt_Suggested_deduct.getValue().toString());
                suggestedPenalityDuration = txt_suggetd_duration.getValue().toString();
                decision = drlDecision.getValue().toString();
                approvedPenality = drlNewPenalty.getValue().toString();
                approvedPenltyDeduct = Double.parseDouble(txt_approved_deduction.getValue().toString());
                approvedPenltyDuration = txt_approved_duration.getValue().toString();
                lastApproverCommentes = intxt_lastApprover_commeentes.getValue().toString();
                forwareToCommeete = "YES";
            }

            if (disciplineApproveManager.saveDecision(disciplineProblemId, loggedInEmployeeId, approverCommentesForFiear, decision, forwareToCommeete, newPenalityProposed, currentStatus, agreeOnDefaultPenalty, Double.parseDouble(txt_DeductAmount.getValue().toString()), txt_Duration.getValue().toString(), suggetedPenality, suggestedPenalityDeduct, suggestedPenalityDuration, approvedPenality, approvedPenltyDeduct, approvedPenltyDuration, lastApproverCommentes, txt_Promotion_Suspend.getValue().toString(), txt_Promotion_Duraion.getValue().toString(), txt_SpendedTranfer.getValue().toString(), txt_TransferDuration.getValue().toString())) {

                showSuccessOrFailureMessage(true, "DECISION POSTED SUCCESSFULLY");
                clearAllComponents();

                disciplineRequestManager.deleteApprovedRequest(disciplineProcessedId);
                pendingRequestLists = disciplineApproveManager.getRequestsToBeProcessed();

            } else {
                showSuccessOrFailureMessage(false, "!SORRY POSTING DECISION FAILED");
            }
        }
        return null;
    }

    public String txtDeligateeId_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnReset_action() {
        clearAllComponents();
        btnPostDecision.setDisabled(true);
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay, String fadeTime) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        commenteslblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setAutoCentre(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        panelPopupMessageForCommeteComentes.setRendered(true);
        String val = "message";
        //  String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        String fadeTime = (success ? "5000" : "9000");
        showSuccessOrFailureMessage(success, messageToDisplay, fadeTime);
    }

    public byte[] getCommeentsFile() {
        return commeentsFile;
    }

    public void setCommeentsFile(byte[] commeentsFile) {
        this.commeentsFile = commeentsFile;
    }
///////////////////////////////Getter And Setter////////////////////////////////////////////////////////////////

    public ArrayList<Option> getPenaltyTypesListOptionForManager() {
        return penaltyTypesListOptionForManager;
    }

    public void setPenaltyTypesListOptionForManager(ArrayList<Option> penaltyTypesListOptionForManager) {
        this.penaltyTypesListOptionForManager = penaltyTypesListOptionForManager;
    }

    public int getLoggedInEmployeeDeptID() {
        return loggedInEmployeeDeptID;
    }

    public void setLoggedInEmployeeDeptID(int loggedInEmployeeDeptID) {
        this.loggedInEmployeeDeptID = loggedInEmployeeDeptID;
    }

    public String getPenality_deduction() {
        return penality_deduction;
    }

    public void setPenality_deduction(String penality_deduction) {
        this.penality_deduction = penality_deduction;
    }

    public ArrayList<CommeeteeCommentsGiven> getComeeteeCommentsGive() {
        return comeeteeCommentsGive;
    }

    public void setComeeteeCommentsGive(ArrayList<CommeeteeCommentsGiven> comeeteeCommentsGive) {
        this.comeeteeCommentsGive = comeeteeCommentsGive;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<Option> getCommitteeForwardList() {
        return committeeForwardList;
    }

    public void setCommitteeForwardList(ArrayList<Option> committeeForwardList) {
        this.committeeForwardList = committeeForwardList;
    }

    public int getDisciplineProcessedId() {
        return disciplineProcessedId;
    }

    public void setDisciplineProcessedId(int disciplineProcessedId) {
        this.disciplineProcessedId = disciplineProcessedId;
    }

    public String getNewPenalityProposed() {
        return newPenalityProposed;
    }

    public void setNewPenalityProposed(String newPenalityProposed) {
        this.newPenalityProposed = newPenalityProposed;
    }

    public int getSizeOfCommitee() {
        return sizeOfCommitee;
    }

    public void setSizeOfCommitee(int sizeOfCommitee) {
        this.sizeOfCommitee = sizeOfCommitee;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {

        this.fileName = fileName;
    }

    public String getMimeType() {

        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public boolean isDownloadAvailable() {
        return downloadAvailable;
    }

    public void setDownloadAvailable(boolean downloadAvailable) {
        this.downloadAvailable = downloadAvailable;
    }

    public Resource getFaResource() {
        return faResource;
    }

    public void setFaResource(Resource faResource) {
        this.faResource = faResource;
    }

//    public ArrayList<CommtteeComments> getCommitteeCommentes() {
//        return committeeCommentes;
//    }
//
//    public void setCommitteeCommentes(ArrayList<CommtteeComments> CommitteeCommentes) {
//        this.committeeCommentes = CommitteeCommentes;
//    }
    public String getDisciplinedEmployeeId() {
        return disciplinedEmployeeId;
    }

    public void setDisciplinedEmployeeId(String disciplinedEmployeeId) {
        this.disciplinedEmployeeId = disciplinedEmployeeId;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public String getLoggedInEmployeeDept() {
        return loggedInEmployeeDept;
    }

    public void setLoggedInEmployeeDept(String loggedInEmployeeDept) {
        this.loggedInEmployeeDept = loggedInEmployeeDept;
    }

    public ArrayList<OtherMemberEyeWitnessModel> getEyeWitnessesListOther() {
        return eyeWitnessesListOther;
    }

    public void setEyeWitnessesListOther(ArrayList<OtherMemberEyeWitnessModel> eyeWitnessesListOther) {
        this.eyeWitnessesListOther = eyeWitnessesListOther;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private HtmlDataTable dataTable = new HtmlDataTable();

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public String getRequesterId() {
        return requesterId;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public ArrayList<Option> getPendingRequestLists() {
        return pendingRequestLists;
    }

    public void setPendingRequestLists(ArrayList<Option> pendingRequestLists) {
        this.pendingRequestLists = pendingRequestLists;
    }

    public DisciplineRequestManager getDisciplineRequestManager() {
        return disciplineRequestManager;
    }

    public ArrayList<Option> getDecisionMadeByEmployeeLists() {
        return decisionMadeByEmployeeLists;
    }

    public void setDecisionMadeByEmployeeLists(ArrayList<Option> decisionMadeByEmployeeLists) {
        this.decisionMadeByEmployeeLists = decisionMadeByEmployeeLists;
    }

    public void setDisciplineRequestManager(DisciplineRequestManager disciplineRequestManager) {
        this.disciplineRequestManager = disciplineRequestManager;
    }

    public String getApproverGivenCommeents() {
        return approverGivenCommeents;
    }

    public void setApproverGivenCommeents(String approverGivenCommeents) {
        this.approverGivenCommeents = approverGivenCommeents;
    }

    public String getANOTHEREMPLOYEE() {
        return ANOTHEREMPLOYEE;
    }

    public void setANOTHEREMPLOYEE(String ANOTHEREMPLOYEE) {
        this.ANOTHEREMPLOYEE = ANOTHEREMPLOYEE;
    }

    public String getIMMEDIATEBOSS() {
        return IMMEDIATEBOSS;
    }

    public void setIMMEDIATEBOSS(String IMMEDIATEBOSS) {
        this.IMMEDIATEBOSS = IMMEDIATEBOSS;
    }

    public String getNOTEMPLOYEE() {
        return NOTEMPLOYEE;
    }

    public void setNOTEMPLOYEE(String NOTEMPLOYEE) {
        this.NOTEMPLOYEE = NOTEMPLOYEE;
    }

    public ArrayList<SelectItem> getCommitteeLists() {
        return committeeLists;
    }

    public void setCommitteeLists(ArrayList<SelectItem> committeeLists) {
        this.committeeLists = committeeLists;
    }

    public ArrayList<Option> getAvailableDecisionsToMake() {
        return availableDecisionsToMake;
    }

    public void setAvailableDecisionsToMake(ArrayList<Option> availableDecisionsToMake) {
        this.availableDecisionsToMake = availableDecisionsToMake;
    }

    public DisciplineRequestModel getDisciplineRequestModel() {
        return disciplineRequestModel;
    }

    public void setDisciplineRequestModel(DisciplineRequestModel disciplineRequestModel) {
        this.disciplineRequestModel = disciplineRequestModel;
    }

    public ArrayList<Option> getDisciplineTypesListForManager() {
        return disciplineTypesListForManager;
    }

    public void setDisciplineTypesListForManager(ArrayList<Option> disciplineTypesListForManager) {
        this.disciplineTypesListForManager = disciplineTypesListForManager;
    }

    public ArrayList<Option> getDisciplineTypesList() {
        return disciplineTypesList;
    }

    public void setDisciplineTypesList(ArrayList<Option> disciplineTypesList) {
        this.disciplineTypesList = disciplineTypesList;
    }

    public String btnSaveOrUpdate_action() {

        return null;
    }

    public String btnClosePopupAllCommittedOffences_action() {
        pnlPopupAllCommittedOffences.setRendered(false);
        return null;
    }

    public String btnClosePopupChairMan_action() {
        panelPopup_CommeeteChairMan.setRendered(false);
        return null;
    }

    public String btnClosePopupRevocPenality_action() {
        panelPopup_revocPenality.setRendered(false);
        return null;
    }

    public ArrayList<AccusedFileUpLoad> getCommeentesFile() {
        return commeentesFile;
    }

    public void setCommeentesFile(ArrayList<AccusedFileUpLoad> commeentesFile) {
        this.commeentesFile = commeentesFile;
    }

    public void makePageReadyForDecision() {
        drlCommittee.setRendered(false);
        lblCommittee.setRendered(false);
        drlDecision.setRendered(true);
        lbDecision.setRendered(true);
        lnkToAccusedCommentPage.setRendered(false);
        lnkViewAccusedComment.setRendered(true);
        availableDecisionsToMake = disciplineApproveManager.getAvailableDecisionsToMake(getSessionBean1().getUserName());
        makePageReadyForSave();
    }

    private void makePageReadyToForwardToCommitte() {
        drlCommittee.setRendered(true);
        lblCommittee.setRendered(true);
        drlDecision.setRendered(false);
        lbDecision.setRendered(false);
        makePageReadyForSave();
    }

    private void makePageReadyForSave() {
        btnPostDecision.setRendered(true);
        btnPostDecision.setDisabled(false);
        ckbForwardToCommittee.setDisabled(true);
        drlDecision.setDisabled(false);
        radioGroupAgreeOnDefaultPenalty.setDisabled(false);
        txtaDecisionExplanation.setDisabled(true);
        pnlLayoutDecisoion.setRendered(true);
        txtaDecisionExplanation.setDisabled(false);


    }

    private void makePageReadyForNavigationToAccusedComment() {
        disableDiscionComponents();
        lnkToAccusedCommentPage.setRendered(true);
        lnkViewAccusedComment.setRendered(false);
        btnPostDecision.setDisabled(true);
        lblAccusationAcceptanceValue.setValue("");
        lblPenaltyAcceptanceValue.setValue("");
    }

    public void makePageReadyForView() {
        lnkToAccusedCommentPage.setRendered(true);
        lnkViewAccusedComment.setRendered(false);
        btnPostDecision.setRendered(false);
        ckbForwardToCommittee.setDisabled(true);
    }

    private void renderPreviosDescisionLink(String currentStatus) {
        if (!currentStatus.equals(DisciplineApproveManager.INITIAL_STATE_DISCIPLINE)) {
            populateDecisionHistoryTable(disciplineProblemId);
            cmdLinkViewPreviesDecisions.setRendered(true);
        } else {
            cmdLinkViewPreviesDecisions.setRendered(false);
        }
    }

    private void renderCommeeteComentesLink() {

        populateComeeteeComeents(disciplineProblemId);

    }

    private void renderCommitteeLink(int requestId, String currentStatus) {
        deciderCommitteeId = disciplineApproveManager.getForwardedToCommittee(requestId, currentStatus);

        if (deciderCommitteeId != -1) {//if forwareded to committee

            cmdLinkConfirmCommitteeDecisions.setRendered(true);
            cmd_Post_chairMan_Commeete.setRendered(true);
        } else {
            enableDiscionComponents();
            cmdLinkConfirmCommitteeDecisions.setRendered(false);
        }
    }

    private void renderAccusedCommentLink(int disciplineProblemId) {
        ArrayList<AccusedDefenceModel> accusedDefenceModelList = accusedDefenceManager.getDisciplineIssuedFromRequestId(disciplineProblemId);
        if (accusedDefenceModelList == null) {
        } else if (accusedDefenceModelList.size() > 0) {
            populateAccusedComment(accusedDefenceModelList);
            availableDecisionsToMake = disciplineApproveManager.getAvailableDecisionsToMake(disciplineProblemId, currentStatus);
            makePageReadyForSave();
            btnPostDecision.setDisabled(false);
            lnkToAccusedCommentPage.setRendered(false);
            lnkViewAccusedComment.setRendered(true);
        } else {//no comment psoted yet
            makePageReadyForNavigationToAccusedComment();
        }
    }

    public void selectPending_processValueChange(ValueChangeEvent vce) {


        if (vce != null) {
            String[] requestInfos = vce.getNewValue().toString().split("--");
            disciplineProblemId = Integer.parseInt(requestInfos[0]);//
            requesterId = requestInfos[1];
            offenceType = requestInfos[2];
            offenderId = requestInfos[3];
            currentStatus = requestInfos[4];
            reportedDate = requestInfos[6];
            repititionOfOffence = Integer.parseInt(requestInfos[7]);
            offenceTypeForManager = requestInfos[8];
            String currentDay = dateFormat.format(new Date());

            if (repititionOfOffence == 1) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
                catagory = disciplineRequestModel.getCatagory();
                subCatagory = disciplineRequestModel.getSubCatagory();

                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {

                    salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                    //  disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 2) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);
                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {
                    salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaion(offenceType, disciplineProblemId);
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 3) {

                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);
                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {
                    salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaion(offenceType, disciplineProblemId);
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 4) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);
                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {
                    salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaion(offenceType, disciplineProblemId);
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 5) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);
                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {
                    salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaion(offenceType, disciplineProblemId);
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            }

        }


    }

    public void selectHistory_processValueChange(ValueChangeEvent vce) {
        String decisionAttributs[] = vce.getNewValue().toString().split("--");
        disciplineProblemId = Integer.parseInt(decisionAttributs[1]);
        offenceType = decisionAttributs[6];
        offenderId = decisionAttributs[7];
        drlDecision.setValue(decisionAttributs[2]);
        forwareToCommeete = decisionAttributs[16];
        employeeStatus = decisionAttributs[17];
        txtaDecisionExplanation.setDisabled(true);
        repititionOfOffence = Integer.parseInt(decisionAttributs[15]);
        salary = disciplineRequestManager.getEmployeeSalary(offenderId);
        // disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);



        if (repititionOfOffence == 1) {
            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);
            } else {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);

            }

            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            duration = disciplineRequestModel.getDeductionDuration();
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }
        } else if (repititionOfOffence == 2) {
            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaionForManager(offenceType, disciplineProblemId);
            } else {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaion(offenceType, disciplineProblemId);

            }
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            duration = disciplineRequestModel.getDeductionDuration();
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }

        } else if (repititionOfOffence == 3) {
            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaion(offenceType, disciplineProblemId);
            } else {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaionForManager(offenceType, disciplineProblemId);

            }
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }
        } else if (repititionOfOffence == 4) {
            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaion(offenceType, disciplineProblemId);
            } else {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaionForManager(offenceType, disciplineProblemId);

            }
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }

        } else if (repititionOfOffence == 5) {
            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaionForManager(offenceType, disciplineProblemId);
            } else {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaion(offenceType, disciplineProblemId);

            }
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }
        }

        if (forwareToCommeete.equalsIgnoreCase("No")) {
            txtaDecisionExplanation.setValue(decisionAttributs[2]);
            txtaDecisionExplanation.setDisabled(true);
            intxt_lastApprover_commeentes.setRendered(false);
        } else if (forwareToCommeete.equalsIgnoreCase("YES")) {
            intxt_lastApprover_commeentes.setRendered(true);
            intxt_lastApprover_commeentes.setValue(decisionAttributs[14]);
            intxt_lastApprover_commeentes.setDisabled(true);
        }
        // drlNewPenalty.setValue(decisionAttributs[8]);
        lbl_SuggetedPenalty.setValue(decisionAttributs[8]);
        txt_Suggested_deduct.setValue(decisionAttributs[9]);
        txt_suggetd_duration.setValue(decisionAttributs[10]);
        lbl_approved_Penalty.setValue(decisionAttributs[11]);
        lbl_approvedPen.setRendered(true);
        lbl_approved_Penalty.setRendered(true);
        drlNewPenalty.setRendered(false);
        lbNewPenalty.setRendered(false);
        txt_approved_deduction.setValue(decisionAttributs[12]);
        txt_approved_duration.setValue(decisionAttributs[13]);
        ckbForwardToCommittee.setDisabled(true);
        populateAllComponents(disciplineRequestModel);
        drlDecision.setDisabled(true);
        btnPostDecision.setDisabled(true);
        ckbForwardToCommittee.setDisabled(true);
        cmdLinkConfirmCommitteeDecisions.setDisabled(true);
        //  drlNewPenalty.setDisabled(true);
        drlCommittee.setDisabled(true);
        intxt_lastApprover_commeentes.setDisabled(true);
        radioGroupAgreeOnDefaultPenalty.setDisabled(false);
        int displineId = Integer.parseInt(decisionAttributs[0]);//
        int requestId = Integer.parseInt(decisionAttributs[5]);
        String stat = decisionAttributs[4];//
        renderCommitteeLink(requestId, stat);
    }

    public String lnkDisciplineTypesRegistrationPage_action() {
        return "DisciplineTypes";
    }

    public String lnkDisciplineRequestPage_action() {
        return "DisciplineRequest";
    }

    public String lnkToAccusedCommentPage_action() {
        AccusedDefencePage offenderDefencePage = new AccusedDefencePage();
        offenderDefencePage.setUserName(userName);
        offenderDefencePage.setDisciplineProblemId(disciplineProblemId);
        //offenderDefencePage.populateAllComponents(offenceType, disciplineProblemId);
        return "AccusedDefence";
    }

    public String cmdLinkViewAllOffences_action() {
        allCommittedOffencesOfEmployee = disciplineRequestManager.getComittedOffencesOfEmployee(txtEmployeeId.getValue().toString());
        pnlPopupAllCommittedOffences.setRendered(true);
        return null;
    }

    public String cmdLinkViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        drlDecision.setDisabled(false);
        return null;
    }

    private boolean populateDecisionHistoryTable(int leaveRequestId) {
        decisionsMadeOnRequest = disciplineApproveManager.getRequestHistory(leaveRequestId);
        return true;
    }

    private boolean populateComeeteeComentesTable(int DisplineRequestId) {
        comeeteeCommentsGive = disciplineApproveManager.getCommiteeComentes(DisplineRequestId);
        return true;
    }

    public void radioGroupAgreeOnDefaultPenalty_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals("Fair")) {

            drlNewPenalty.setDisabled(true);
            ckbForwardToCommittee.setDisabled(true);
            intxt_lastApprover_commeentes.setRendered(false);
            cmdLinkConfirmCommitteeDecisions.setDisabled(true);
            this.makePageReadyForDecision();

        } else if (vce.getNewValue().toString().equals("Exagurated")) {
            showSuccessOrFailureMessage(false, "SELECT YOUR OTHER PENALITY");
            drlNewPenalty.setDisabled(false);
            drlPenaltyForManger1.setDisabled(false);
            drl_disciplineForManager.setDisabled(false);
            ckbForwardToCommittee.setDisabled(false);
            cmdLinkConfirmCommitteeDecisions.setDisabled(true);
        } else if (vce.getNewValue().toString().equals("TooSmall")) {
            showSuccessOrFailureMessage(false, "SELECT YOUR OTHER PENALITY");
            drlNewPenalty.setDisabled(false);
            drlPenaltyForManger1.setDisabled(false);
            drl_disciplineForManager.setDisabled(false);
            ckbForwardToCommittee.setDisabled(false);
            cmdLinkConfirmCommitteeDecisions.setDisabled(true);
        } else {
            drlNewPenalty.setDisabled(false);
            drl_disciplineForManager.setDisabled(false);
        }

        agreeOnDefaultPenalty = vce.getNewValue().toString();

    }

    public void ckbForwardToCommittee_processValueChange(ValueChangeEvent vce) {
        if (ckbForwardToCommittee.isSelected()) {
            forwareToCommeete = "YES";

            makePageReadyToForwardToCommitte();
        } else {
            makePageReadyForDecision();
        }

    }

    public String cmdLinkConfirmCommitteeDecisions_action() {


        committeeMembersList = committeeMemberRegistrationManager.getAllCommitteeMembers(deciderCommitteeId);

        lblSignInReminder.setValue("Sign in using your username");

        if (employeeStatus.equalsIgnoreCase("Normal")) {

            penaltyTypesListOption = penaltyRegistrationManager.getPenaltyTypesOption();//
        } else if (employeeStatus.equalsIgnoreCase("Manager")) {
            penaltyTypesListOption = penaltyRegistrationManager.getAllPenaltyTypesOptionForManager();//
        }

        pnlPopupCommitteeMembers.setRendered(true);
        return null;
    }
    String savedStatus = "Done";
    int flage = 0;

    public String btnPopupForColumnMemberLogIn_action() {
        try {
            if (selectedCommitteeMemberRow != -1) {
                String memberEmployeeId = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeId();
                String memberUserName = committeeMembersList.get(selectedCommitteeMemberRow).getUserName();
                String memberPassWord = committeeMembersList.get(selectedCommitteeMemberRow).getPassWord();
                String memberComentes = committeeMembersList.get(selectedCommitteeMemberRow).getCommeentesGiven();
                String memberFullName = committeeMembersList.get(selectedCommitteeMemberRow).getEmployeeFullName();
                String memberResponsiblity = committeeMembersList.get(selectedCommitteeMemberRow).getResponsiblity();
                String commentgivenDay = committeeMembersList.get(selectedCommitteeMemberRow).getCommeentGivenDay();

                String suggestedPenality = committeeMembersList.get(selectedCommitteeMemberRow).getSuggestedPenality();
                int diciplineProblemId = disciplineProblemId;
                int counter = committeeMembersList.size();

                String status = "New";


                if (siteSecurityManager.isValidUser(memberUserName, memberPassWord, memberEmployeeId)) {
                    flage++;
                    comeeteeCommentsGive = disciplineApproveManager.getCommiteeComentes(diciplineProblemId, memberUserName);
                    if(comeeteeCommentsGive.size()==0){


                    disciplineApproveManager.NewSaveCommitteeComeentes(memberEmployeeId, memberFullName, memberResponsiblity, memberComentes, diciplineProblemId, memberUserName, memberPassWord, status, savedStatus, commentgivenDay, suggestedPenality);
                    //  disciplineApproveManager.NewSaveCommitteeComeentes(memberEmployeeId, memberFullName, memberResponsiblity, memberComentes,diciplineProblemId, memberUserName, memberPassWord, status,savedStatus);
                    showSuccessOrFailureMessage(true, "YOUR COMMEENTES SAVING SUCCESSFULL");
                    password_secretField.resetValue();
                    userName_textField.resetValue();
                    committeeMembersList.get(selectedCommitteeMemberRow).getUserName().replaceAll(committeeMembersList.get(selectedCommitteeMemberRow).getUserName(), "");
                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Confirmed");

                    } else {
                        showSuccessOrFailureMessage(false, "YOU CONFIRMED ALREADY");
                        pnlPopupCommitteeMembers.setRendered(false);
                    }
                } else {

                    showSuccessOrFailureMessage(false, "CHECK PASSWORD OR USER NAME");

                    committeeMembersList.get(selectedCommitteeMemberRow).setLogInConfirmed("Invalid");

                }

            }


        } catch (NullPointerException npe) {
        }
        return null;
    }

    public String lnkViewAccusedComment_action() {
//        byte[] commeentsFile;
//        boolean commentesAttachFile;
//        boolean interestFillAttach;
//        commentesAttachFile = accusedDefenceManager.FileAttached(disciplineProblemId);
//        interestFillAttach = accusedDefenceManager.interserFileAttached(disciplineProblemId);
//        if (commentesAttachFile) {
//            cmdAccepatnce.setRendered(true);
//        }
//        if (interestFillAttach) {
//            cmdInterset.setRendered(true);
//        }
        pnlPopupViewAccusedComment.setRendered(true);
        return null;
    }

    public String lnkViewEyeWitnessComment_action() {
        if (disciplineProblemId != -1) {
            eyeWitnessesList = eyeWitnessManager.getEyeWitnessesList(disciplineProblemId);
            pnlEyeWitnessesRegistration.setRendered(true);
        }

        return null;
    }

    public String btnClosePopupEyeWitnesses_action() {
        pnlEyeWitnessesRegistration.setRendered(false);
        return null;
    }

    public String btnClosePopupEyeWitnessesOther_action() {
        pnlEyeWitnessesRegistrationOther.setRendered(false);
        return null;
    }
    int selectedCommitteeMemberRow = -1;
    int selectedCommitteeCommentesRow = -1;

    public void rowSelectorCommitteeMember_processMyEvent(RowSelectorEvent rse) {
        selectedCommitteeMemberRow = rse.getRow();
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
            lblSignInReminder.setValue("Note: Greater than 50% approved." +
                    " Only " + counterCheck + " out of " + totalSize + " confirmed. ");
            enableDiscionComponents();

            return true;
        }

    }

    public String btnClosePopupCommitteeMembers_action() {
        if (isEnoughCommitteeNumbersSigned()) {
            pnlPopupCommitteeMembers.setRendered(false);
            pnlPopupSuccessOrFailure.setRendered(false);
        }

        return null;
    }

    public String cmdLnkClosePopupCommitteeMembers_action() {
        cmdLnkClosePopupCommitteeMembers.setRendered(false);
        pnlPopupCommitteeMembers.setRendered(false);
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
// <editor-fold defaultstate="collapsed" desc="Links">

    public String lnkDisciplineRequest_action() {
        return "DisciplineIssue";
    }

    public String lnkDisciplineApprove_action() {
        return "DisciplineApprove";
    }

    public String lnkAccusedDefence_action() {
        return "AccusedDefence";
    }

    public String lnkEyeWitness_action() {
        return "EyeWitness";
    }

    public String lnkCommitteeMembers_action() {
        return "CommitteeMembers";
    }

    public String lnkDisciplinePenalty_action() {
        return "PenaltyTypes";
    }

    public String lnkCommittee_action() {
        return "Committeee";
    }

    public String btnDisciplinePenalty_action() {
        return "DisciplinePenalty";
    }

    public String btnPenaltyType_action() {
        return "PenaltyTypes";
    }

    public boolean isApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(boolean approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getSavedStatus() {
        return savedStatus;
    }

    public void setSavedStatus(String savedStatus) {
        this.savedStatus = savedStatus;
    }

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public int selectedIndex;

    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
        selectedIndex =
                selectedRowIndex;
    }

    public String commentsbtnClosePopupSuccessOrFailure_action() {

        panelPopupMessageForCommeteComentes.setRendered(false);
        return null;
    }

    public String LoginButton_action() {

        return null;
    }

    public void btnClosePopupCommeeteComeentes_processAction(ActionEvent ae) {
        pnlPopupComeeteeComenets.setRendered(false);
    }

    public void cmdview_Committee_Comments_action() {

        pnlPopupComeeteeComenets.setRendered(true);
        setApproveStatus(true);
        txtaDecisionExplanation.setRendered(false);
        intxt_lastApprover_commeentes.setRendered(true);

        if (employeeStatus.equalsIgnoreCase("Normal")) {
            drlNewPenalty.setRendered(true);
            drlPenaltyForManger1.setRendered(false);
            drlNewPenalty.setDisabled(false);
            makePageReadyForDecision();
        } else if (employeeStatus.equalsIgnoreCase("Manager")) {
            drlNewPenalty.setRendered(false);
            drlPenaltyForManger1.setRendered(true);
            drlPenaltyForManger1.setDisabled(false);
            makePageReadyForDecision();
        }

    }

    public void selectCommeete_processValueChange(ValueChangeEvent vce) {

        if (vce != null) {
            String[] requestInfos = vce.getNewValue().toString().split("--");
            disciplineProblemId = Integer.parseInt(requestInfos[0]);//
            requesterId = requestInfos[1];
            offenceType = requestInfos[2];
            offenderId = requestInfos[3];
            currentStatus = requestInfos[4];
            approverGivenCommeents = requestInfos[5];
            disciplineProcessedId = Integer.parseInt(requestInfos[6]);
            newPenalityProposed = requestInfos[7];
            agreeOnDefaultPenalty = requestInfos[8];
            repititionOfOffence = Integer.parseInt(requestInfos[11]);
            employeeStatus = requestInfos[12];
            forwareToCommeete = "Yes";
            salary = disciplineRequestManager.getEmployeeSalary(offenderId);
            String currentDay = dateFormat.format(new Date());
            cmdLinkConfirmCommitteeDecisions.setDisabled(false);
            if (repititionOfOffence == 1) {

                String dbDay = disciplineApproveManager.getCommeentsForWardDay(disciplineProblemId);

                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 20) {

                    if (employeeStatus.equalsIgnoreCase("Normal")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
                    } else if (employeeStatus.equalsIgnoreCase("Manager")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);
                    }
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    txtaDecisionExplanation.setValue(requestInfos[5]);
                    lbl_SuggetedPenalty.setValue(newPenalityProposed);
                    txt_Suggested_deduct.setValue(requestInfos[9]);
                    txt_suggetd_duration.setValue(Integer.parseInt(requestInfos[10]));
                    cmdLinkConfirmCommitteeDecisions.setDisabled(false);
                    populateAllComponents(disciplineRequestModel);
                    disableForWardToCommeeteDiscionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "SORRY THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }


            } else if (repititionOfOffence == 2) {

                String dbDay = disciplineApproveManager.getCommeentsForWardDay(disciplineProblemId);

                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {
                    if (employeeStatus.equalsIgnoreCase("Normal")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaion(offenceType, disciplineProblemId);
                    } else if (employeeStatus.equalsIgnoreCase("Manager")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaionForManager(offenceType, disciplineProblemId);
                    }
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    txtaDecisionExplanation.setValue(requestInfos[5]);
                    lbl_SuggetedPenalty.setValue(newPenalityProposed);
                    txt_Suggested_deduct.setValue(requestInfos[9]);
                    txt_suggetd_duration.setValue(Integer.parseInt(requestInfos[10]));
                    populateAllComponents(disciplineRequestModel);
                    disableForWardToCommeeteDiscionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);
                } else {
                    showSuccessOrFailureMessage(false, "SORRY THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 3) {
                String dbDay = disciplineApproveManager.getCommeentsForWardDay(disciplineProblemId);

                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {

                    if (employeeStatus.equalsIgnoreCase("Normal")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaion(offenceType, disciplineProblemId);
                    } else if (employeeStatus.equalsIgnoreCase("Manager")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaionForManager(offenceType, disciplineProblemId);
                    }
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    txtaDecisionExplanation.setValue(requestInfos[5]);
                    lbl_SuggetedPenalty.setValue(newPenalityProposed);
                    txt_Suggested_deduct.setValue(requestInfos[9]);
                    txt_suggetd_duration.setValue(Integer.parseInt(requestInfos[10]));
                    populateAllComponents(disciplineRequestModel);
                    disableForWardToCommeeteDiscionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);
                } else {

                    showSuccessOrFailureMessage(false, "SORRY THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");

                }

            } else if (repititionOfOffence == 4) {
                String dbDay = disciplineApproveManager.getCommeentsForWardDay(disciplineProblemId);
                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {
                    if (employeeStatus.equalsIgnoreCase("Normal")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaion(offenceType, disciplineProblemId);
                    } else if (employeeStatus.equalsIgnoreCase("Manager")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaionForManager(offenceType, disciplineProblemId);
                    }
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    txtaDecisionExplanation.setValue(requestInfos[5]);
                    lbl_SuggetedPenalty.setValue(newPenalityProposed);
                    txt_Suggested_deduct.setValue(requestInfos[9]);
                    txt_suggetd_duration.setValue(Integer.parseInt(requestInfos[10]));
                    populateAllComponents(disciplineRequestModel);
                    disableForWardToCommeeteDiscionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);
                } else {
                    showSuccessOrFailureMessage(false, "SORRY THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 5) {
                String dbDay = disciplineApproveManager.getCommeentsForWardDay(disciplineProblemId);
                if (GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) {

                    if (employeeStatus.equalsIgnoreCase("Normal")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaion(offenceType, disciplineProblemId);
                    } else if (employeeStatus.equalsIgnoreCase("Manager")) {
                        disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaionForManager(offenceType, disciplineProblemId);
                    }
                    duration = disciplineRequestModel.getDeductionDuration();
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }

                }
                txtaDecisionExplanation.setValue(requestInfos[5]);
                lbl_SuggetedPenalty.setValue(newPenalityProposed);
                txt_Suggested_deduct.setValue(requestInfos[9]);
                txt_suggetd_duration.setValue(Integer.parseInt(requestInfos[10]));
                populateAllComponents(disciplineRequestModel);
                disableForWardToCommeeteDiscionComponents();
                renderPreviosDescisionLink(currentStatus);
                renderCommitteeLink(disciplineProblemId, currentStatus);
                renderAccusedCommentLink(disciplineProblemId);
            } else {
                showSuccessOrFailureMessage(false, "SORRY THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
            }

        }
    }

    public String btn_ChairMan_Post_action() {
        String commentes;
        String savedStaus = null;
        String suggetedPenality;
        String penality = drl_ChairMan_suggetedPenality.getValue().toString().split("-")[1];
        double dedctionAmount;
        String duration;
        String commeentsGivenday;
        commentes = txt_ChairMan_Commentes.getValue().toString();
        suggetedPenality = drl_ChairMan_suggetedPenality.getValue().toString();
        dedctionAmount = Double.parseDouble(txt_ChairMan_deductAmoun.getValue().toString());
        duration = txt_chairMan_Duration.getValue().toString();
        commeentsGivenday = lbl_commeents_Given_day.getValue().toString();


        if (disciplineApproveManager.SaveChairManCommeents(disciplineProblemId, commentes, suggetedPenality, dedctionAmount, duration, savedStaus, commeentsGivenday)) {

            showSuccessOrFailureMessage(true, " YOUR COMMEENTES IS SUCCESSFULY SAVED ");

        } else {
            showSuccessOrFailureMessage(false, " SORRY ERROR OCCUR WHILE YOUR SAVING YOUR COMMEENTES ");
        }

        //return null means stay on the same page
        return null;
    }

    public String btn_Revoce_Post_action() {
        String commentes;
        String savedStaus = null;
        String commeentsGivenday;
        String courtDescition = in_txt_area_CourtDecision.getValue().toString();
        String documentRefrance = txt_Document_Referance.getValue().toString();
        commentes = txt_Approver_RevocPenality.getValue().toString();
        commeentsGivenday = lbl_commeents_Given_dayrevoc.getValue().toString();


        if (disciplineApproveManager.SaveRevocPenality(disciplineProblemId, commentes, courtDescition, commeentsGivenday, documentRefrance, savedStaus)) {

            showSuccessOrFailureMessage(true, " YOUR ARE SUCCESSFULY REJECT THE APPROVED PENALITY ");

        } else {
            showSuccessOrFailureMessage(false, " SORRY ERROR OCCUR WHILE YOUR REJECT THE APPROVED PENALITY ");
        }


        return null;
    }

    public void drl_ChairMan_suggetedPenality_processValueChange(ValueChangeEvent vce) {
        // try {
        ArrayList<PenaltyTypeModel> penalityType = new ArrayList<PenaltyTypeModel>();
        //disciplineProblemId=0;
        //repititionOfOffence=0;

        String penalityName;
        int penalityID;
        String[] PenalityName = null;
        String penality[] = vce.getNewValue().toString().split("-");
        penalityName = penality[0];
        penalityID = Integer.parseInt(penality[1]);
        salary = disciplineRequestManager.getEmployeeSalary(offenderId);





        if (repititionOfOffence == 1) {
            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);
            } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
            }

            // disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
            duration = disciplineRequestModel.getDeductionDuration();
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }

        } else if (repititionOfOffence == 2) {

            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaionForManager(offenceType, disciplineProblemId);
            } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaion(offenceType, disciplineProblemId);
            }

            // disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaion(offenceType, disciplineProblemId);
            duration = disciplineRequestModel.getDeductionDuration();
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }
        } else if (repititionOfOffence == 3) {

            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaionForManager(offenceType, disciplineProblemId);
            } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaion(offenceType, disciplineProblemId);
            }

            // disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaion(offenceType, disciplineProblemId);
            duration = disciplineRequestModel.getDeductionDuration();
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }

        } else if (repititionOfOffence == 4) {

            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaionForManager(offenceType, disciplineProblemId);
            } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaion(offenceType, disciplineProblemId);
            }

            //  disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaion(offenceType, disciplineProblemId);
            duration = disciplineRequestModel.getDeductionDuration();
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }
        } else if (repititionOfOffence == 5) {

            if (employeeStatus.equalsIgnoreCase("Manager")) {
                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaionForManager(offenceType, disciplineProblemId);
            } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaion(offenceType, disciplineProblemId);
            }
            //  disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaion(offenceType, disciplineProblemId);
            duration = disciplineRequestModel.getDeductionDuration();
            penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
            if (penaliyedDays == 0) {
                disciplineRequestModel.setDeductAmount(0.0);
            } else {
                double dalySalary = (salary / 26);
                double deduction = (dalySalary * penaliyedDays);
                double lastDeduction = (deduction / duration);
                disciplineRequestModel.setDeductAmount(lastDeduction);
            }
        }
        txt_ChairMan_deductAmoun.setValue(disciplineRequestModel.getDeductAmount());
        txt_chairMan_Duration.setValue(duration + " " + "Month");

    }

    public void viewChairManCommeentes() {
        chairman = disciplineApproveManager.getChairManCommeentes(disciplineProblemId);
        txt_ChairMan_Commentes.setValue(chairman.getCommentesGiven());
        txt_ChairMan_deductAmoun.setValue(chairman.getDeductionAmount());
        txt_chairMan_Duration.setValue(chairman.getDuration());
        drl_ChairMan_suggetedPenality.setValue(chairman.getSuggetedsPenality());
        lbl_commeents_Given_day.setValue(chairman.getCommentesGivenDay());
    }

    public String cmd_view_ChairMan_Commeents_action() {
        pnlPopupComeeteeComenets.setRendered(false);
        panelPopup_CommeeteChairMan.setRendered(true);
        this.disableChairManpopUp();
        this.viewChairManCommeentes();
        return null;
    }

    public String cmd_Post_chairMan_Commeete_action() {
        if (employeeStatus.equalsIgnoreCase("Normal")) {

            penaltyTypesListOption = penaltyRegistrationManager.getPenaltyTypesOption();//
        } else if (employeeStatus.equalsIgnoreCase("Manager")) {

            penaltyTypesListOption = penaltyRegistrationManager.getAllPenaltyTypesOptionForManager();//
        }
        panelPopup_CommeeteChairMan.setRendered(true);
        pnlPopupComeeteeComenets.setRendered(false);
        lbl_commeents_Given_day.setValue(dateFormat.format(new Date()));
        return null;
    }

    public String commandLink1_action() {

        panelPopup_revocPenality.setRendered(true);
        lbl_commeents_Given_dayrevoc.setValue(dateFormat.format(new Date()));
        String savedStatus = disciplineApproveManager.cheakRejectStatus(disciplineProblemId);

        if (savedStatus.equalsIgnoreCase("Done")) {
            btn_Revoce_Post.setDisabled(true);
            lbl_commeents_Given_dayrevoc.setValue("");
            this.disableRevocPenalitypopUp();
        }

        return null;
    }

    public void viewRejetedPenality() {
        rejectPenality = disciplineApproveManager.getRetectPenality(disciplineProblemId);
        txt_Approver_RevocPenality.setValue(rejectPenality.getCommentesGiven());
        in_txt_area_CourtDecision.setValue(rejectPenality.getCourtDecision());
        txt_Document_Referance.setValue(rejectPenality.getDocumentReferanceDay());
        lbl_commeents_Given_dayrevoc.setValue(rejectPenality.getApprovedDate());
    }

    public String cmd_view_commeentes_action() {
        panelPopup_revocPenality.setRendered(true);
        this.disableRevocPenalitypopUp();
        this.viewRejetedPenality();


        return null;
    }

    private void loadPendingRequest() {
        try {

            String date = jodanTimeCalender.currentForeignersDateFinder();
            boolean checkDiffrence = true;
            int defferance = 0;
            cmdLinkConfirmCommitteeDecisions.setDisabled(true);

            getPendingRequestListsForTenacity().clear();
            ArrayList<HashMap> listOfPending = disciplineApproveManager.getRequestsToBeProcessedHash();


            for (HashMap hm : listOfPending) {
                defferance = GregorianCalendarManipulation.calaculateDateDifference(hm.get("REPORTED_DATE").toString(), date);

                if (defferance >= 20) {
                    checkDiffrence = false;
                }

                DisciplineApproveManager addDisciplineApproveManager = new DisciplineApproveManager(
                        hm.get("DISCIPLINE_PROBLEM_ID").toString(),
                        hm.get("OFFENCE_TYPE").toString(),
                        hm.get("OFFENDER_ID").toString(),
                        hm.get("STATUS").toString(),
                        hm.get("DESCRIPTION_OF_OFFENCE").toString(),
                        hm.get("REPORTED_DATE").toString(),
                        hm.get("REPITITION_OF_OFFENCE").toString(),
                        hm.get("REQUESTER_ID").toString(),
                        hm.get("EMPLOYEE_STATUS").toString(),
                        checkDiffrence);

                defferance = 0;
                checkDiffrence = true;
                getPendingRequestListsForTenacity().add(addDisciplineApproveManager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public List getPendingRequestListsForTenacity() {
        return pendingRequestListsForTenacity;
    }

    public void setPendingRequestListsForTenacity(List pendingRequestListsForTenacity) {
        this.pendingRequestListsForTenacity = pendingRequestListsForTenacity;
    }

    public void rowSelector2_processMyEvent(RowSelectorEvent rse) {
        disciplineRow = rse.getRow();
        displayPendinRequest();
    }

    public void displayPendinRequest() {
        try {


        if (disciplineRow != -1) {
            DisciplineApproveManager disciplineApproveManagersel = (DisciplineApproveManager) pendingRequestListsForTenacity.get(disciplineRow);
            disciplineProblemId = Integer.parseInt(disciplineApproveManagersel.getDiscipline_problem_id());//
            requesterId = disciplineApproveManagersel.getRequester_id();
            offenceType = disciplineApproveManagersel.getOffence_type();
            offenderId = disciplineApproveManagersel.getOffender_id();
            currentStatus = disciplineApproveManagersel.getStatus();
            reportedDate = disciplineApproveManagersel.getReported_date();
            employeeStatus = disciplineApproveManagersel.getEmployeeStatus();
            repititionOfOffence = Integer.parseInt(disciplineApproveManagersel.getRepitition_of_offence());
            String currentDay = dateFormat.format(new Date());

            if (repititionOfOffence == 1) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);
                salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                if (employeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);
                } else if (employeeStatus.equalsIgnoreCase("Normal")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
                }
                penality_deduction = disciplineRequestModel.getPenalizedDays();
                catagory = disciplineRequestModel.getCatagory();
                subCatagory = disciplineRequestModel.getSubCatagory();
                duration = disciplineRequestModel.getDeductionDuration();
                if ((GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) || ((!(catagory.equalsIgnoreCase("High"))))) {

                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    cmdLinkConfirmCommitteeDecisions.setDisabled(true);
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, " THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 2) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);

                salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                if (employeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaionForManager(offenceType, disciplineProblemId);
                } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedSecondReoutaion(offenceType, disciplineProblemId);
                }
                duration = disciplineRequestModel.getDeductionDuration();
                if ((GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) || ((!(catagory.equalsIgnoreCase("High"))))) {
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 3) {

                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);

                salary = disciplineRequestManager.getEmployeeSalary(offenderId);

                if (employeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaionForManager(offenceType, disciplineProblemId);
                } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedThiredReputaion(offenceType, disciplineProblemId);
                }
                duration = disciplineRequestModel.getDeductionDuration();
                if ((GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay)) <= 30 || ((!(catagory.equalsIgnoreCase("High"))))) {
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 4) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);

                salary = disciplineRequestManager.getEmployeeSalary(offenderId);

                if (employeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaionForManager(offenceType, disciplineProblemId);
                } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForthReputaion(offenceType, disciplineProblemId);
                }
                duration = disciplineRequestModel.getDeductionDuration();
                if ((GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) || ((!(catagory.equalsIgnoreCase("High"))))) {
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            } else if (repititionOfOffence == 5) {
                btnPostDecision.setDisabled(false);
                String dbDay = disciplineApproveManager.getCommeentsGivenDay(disciplineProblemId);

                salary = disciplineRequestManager.getEmployeeSalary(offenderId);

                if (employeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaionForManager(offenceType, disciplineProblemId);
                } else if (employeeStatus.equalsIgnoreCase("Normal")) {

                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedFivesReputaion(offenceType, disciplineProblemId);
                }
                duration = disciplineRequestModel.getDeductionDuration();
                if ((GregorianCalendarManipulation.calaculateDateDifference(dbDay, currentDay) <= 30) || ((!(catagory.equalsIgnoreCase("High"))))) {
                    penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());

                    if (penaliyedDays == 0) {
                        disciplineRequestModel.setDeductAmount(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        disciplineRequestModel.setDeductAmount(lastDeduction);
                    }
                    populateAllComponents(disciplineRequestModel);
                    clearDecisionComponents();
                    renderPreviosDescisionLink(currentStatus);
                    renderCommitteeLink(disciplineProblemId, currentStatus);
                    renderAccusedCommentLink(disciplineProblemId);

                } else {
                    showSuccessOrFailureMessage(false, "THE REPORTED DISCIPLINE PROBLEM IS OUT OF 30 DAYS /n YOU CAN’T PROCESS ");
                }
            }
        }
          } catch (Exception e) {
              e.printStackTrace();
        }
    }

    public void main() {

        clearDecisionComponents();
        renderPreviosDescisionLink(currentStatus);
        renderCommitteeLink(disciplineProblemId, currentStatus);
        renderAccusedCommentLink(disciplineProblemId);
    // java test page
    ////////
    }

    public String cmd_OtherWord_action() {
        if (disciplineProblemId != -1) {
            eyeWitnessesListOther = eyeWitnessManager.getOtherEyeWitnessWord(disciplineProblemId);
            pnlEyeWitnessesRegistrationOther.setRendered(true);
        }

        return null;
    }

    public void drlDecision_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            btnPostDecision.setDisabled(false);


        }
    }

    public void pnlGrpEvaluationContent_processMyEvent(DragEvent de) {
    }

    public String btnClosePopupCommitteeChairMan_action() {
        //return null means stay on the same page
        panelPopup_CommeeteChairMan.setRendered(false);
        return null;
    }

    public void drlNewPenalty_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            try {

                ArrayList<PenaltyTypeModel> penalityType = new ArrayList<PenaltyTypeModel>();
                String penalityName;
                int penalityID;
                String[] PenalityName = null;
                String penality[] = vce.getNewValue().toString().split("-");
                penalityName = penality[0];
                penalityID = Integer.parseInt(penality[1]);
                salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                penalityTypeModel = penaltyRegistrationManager.getPenalityType(penalityID);
                duration = penalityTypeModel.getDeductionDuration();
                penaliyedDays = penalityTypeModel.getNumberOfPenalisedDays();

                if ((!approveStatus) && (agreeOnDefaultPenalty.equalsIgnoreCase("Exagurated") || agreeOnDefaultPenalty.equalsIgnoreCase("TooSmall"))) {
                    if (penaliyedDays == 0) {
                        penalityTypeModel.setAmountTaken(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        penalityTypeModel.setAmountTaken(lastDeduction);

                    }
                    txt_Suggested_deduct.setValue(penalityTypeModel.getAmountTaken());
                    txt_suggetd_duration.setValue(duration);
                    lbl_SuggetedPenalty.setValue(drlNewPenalty.getValue().toString());
                    ckbForwardToCommittee.setDisabled(false);

                } else if (approveStatus) {

                    if (penaliyedDays == 0) {
                        penalityTypeModel.setAmountTaken(0.0);
                    } else {
                        double dalySalary = (salary / 26);
                        double deduction = (dalySalary * penaliyedDays);
                        double lastDeduction = (deduction / duration);
                        penalityTypeModel.setAmountTaken(lastDeduction);

                    }
                    txt_approved_deduction.setValue(penalityTypeModel.getAmountTaken());
                    txt_approved_duration.setValue(duration);

                }

            } catch (NullPointerException npe) {
                npe.printStackTrace();

            }

        }

    }

    public void drlPenaltyForManger1_processValueChange(ValueChangeEvent vce) {

        if (vce != null) {

            String penalName = null;
            int penalityID;
            String penality[] = vce.getNewValue().toString().split("-");
            penalName = vce.getNewValue().toString().split("-")[0];
            penalityID = Integer.parseInt(vce.getNewValue().toString().split("-")[1]);

            if ((!approveStatus) && (agreeOnDefaultPenalty.equalsIgnoreCase("Exagurated") || agreeOnDefaultPenalty.equalsIgnoreCase("TooSmall"))) {
                salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                penalityTypeModel = penaltyRegistrationManager.getPenalityTypeForManger(penalityID);
                duration = penalityTypeModel.getDeductionDuration();
                penaliyedDays = penalityTypeModel.getNumberOfPenalisedDays();
                if (penaliyedDays == 0) {

                    penalityTypeModel.setAmountTaken(0.0);
                } else {
                    double dalySalary = (salary / 26);
                    double deduction = (dalySalary * penaliyedDays);
                    double lastDeduction = (deduction / duration);
                    penalityTypeModel.setAmountTaken(lastDeduction);

                }
                txt_Suggested_deduct.setValue(penalityTypeModel.getAmountTaken());
                txt_suggetd_duration.setValue(duration);
                lbl_SuggetedPenalty.setValue(drlPenaltyForManger1.getValue().toString());
                ckbForwardToCommittee.setDisabled(false);

            } else if (approveStatus) {

                salary = disciplineRequestManager.getEmployeeSalary(offenderId);
                penalityTypeModel = penaltyRegistrationManager.getPenalityTypeForManger(penalityID);
                duration = penalityTypeModel.getDeductionDuration();
                penaliyedDays = penalityTypeModel.getNumberOfPenalisedDays();

                if (penaliyedDays == 0) {
                    penalityTypeModel.setAmountTaken(0.0);
                } else {
                    double dalySalary = (salary / 26);
                    double deduction = (dalySalary * penaliyedDays);
                    double lastDeduction = (deduction / duration);
                    penalityTypeModel.setAmountTaken(lastDeduction);

                }

                txt_approved_deduction.setValue(penalityTypeModel.getAmountTaken());
                txt_approved_duration.setValue(duration);

            }

        }

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void readPdfFilesForMiniute(int documentId, String _fileName, String extension) {
        try {
            byte[] attachedFile = disciplineApproveManager.singleSelect(documentId);
            ResourceManager.fileFromDb = attachedFile;
            StringBuilder builder = new StringBuilder();
            builder.append(_fileName);
            builder.append(".");
            builder.append(extension);
            setFileName(builder.toString());
            setMimeType("application/" + extension);
            faResource = new ByteArrayResource(attachedFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void readPdfFiles(int documentId, String _fileName, String extension) {
        try {
            byte[] attachedFile = accusedDefenceManager.singleSelect(documentId);
            ResourceManager.fileFromDb = attachedFile;
            StringBuilder builder = new StringBuilder();
            builder.append(_fileName);
            builder.append(".");
            builder.append(extension);
            setFileName(builder.toString());
            setMimeType("application/" + extension);
            faResource = new ByteArrayResource(attachedFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public void readPdfFilesForEyeWitness(int documentId, String _fileName, String extension) {
        try {

            byte[] attachedFile = eyeWitnessManager.singleSelect(documentId);
            ResourceManager.fileFromDb = attachedFile;
            StringBuilder builder = new StringBuilder();
            builder.append(_fileName);
            builder.append(".");
            builder.append(extension);
            setFileName(builder.toString());
            setMimeType("application/" + extension);
            faResource = new ByteArrayResource(attachedFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public String cmdAccepatnce_action() {
        AccusedFileUpLoad commentFile = new AccusedFileUpLoad();
        try {

            commentFile = accusedDefenceManager.setValues(disciplineProblemId);
            if (commentFile.getFileID() == 0) {
                setDownloadAvailable(false);
            } else {
                readPdfFiles(commentFile.getFileID(), commentFile.getFileName(), commentFile.getExtention());
                setDownloadAvailable(true);
            }



        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;

    }

    public String cmdInterset_action() {
        //return null means stay on the same page
        FileUpLoadForInterset commentFile = new FileUpLoadForInterset();
        try {
            commentFile = accusedDefenceManager.setValuesForInterset(disciplineProblemId);
            if (commentFile.getFileIDInterest() == 0) {
                setDownloadAvailable(false);
            } else {
                readPdfFiles(commentFile.getFileIDInterest(), commentFile.getFileNameInterset(), commentFile.getExtentionInterset());
                setDownloadAvailable(true);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public String lnkFile_action() {
        FileUpLoad commentFile = new FileUpLoad();
        try {

            commentFile = eyeWitnessManager.setValues(disciplineProblemId);
            setDownloadAvailable(false);
            readPdfFilesForEyeWitness(commentFile.getFileID(), commentFile.getFileName(), commentFile.getExtention());
            setDownloadAvailable(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;

    }

    public String lnkFileOther_action() {

        OtherEyeWitnessFileUpLoad commentFile = new OtherEyeWitnessFileUpLoad();
        try {

            commentFile = eyeWitnessManager.setValuesOtherEyeWitness(disciplineProblemId);
            setDownloadAvailable(false);
            readPdfFilesForOtherEyeWitness(commentFile.getFileID(), commentFile.getFileName(), commentFile.getExtention());
            setDownloadAvailable(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;

    }

    public void readPdfFilesForOtherEyeWitness(int documentId, String _fileName, String extension) {
        try {
            byte[] attachedFile = eyeWitnessManager.singleSelectForOther(documentId);
            ResourceManager.fileFromDb = attachedFile;
            StringBuilder builder = new StringBuilder();
            builder.append(_fileName);
            builder.append(".");
            builder.append(extension);
            setFileName(builder.toString());
            setMimeType("application/" + extension);
            faResource = new ByteArrayResource(attachedFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void inputFile1_CommiteeMinute_processAction(ActionEvent ae) {

        try {
            int index = 0;

            InputFile inpuFile = (InputFile) ae.getSource();
            FileInfo fileInfo = inpuFile.getFileInfo();
            filePath = fileInfo.getPhysicalPath().toString();
            File file = new File(filePath);
            fileExtenstion = file.getName();
            index = fileExtenstion.lastIndexOf(".");
            fileExtenstion = fileExtenstion.substring(index + 1);
            setCommeentsFile(AccusedDefenceManager.extractByteArray(file));
            fileUpLoad.setRequestID(disciplineProblemId);
            fileUpLoad.setFileName("Minute");
            fileUpLoad.setExtention(fileExtenstion);
            fileUpLoad.setAttachedFile(DisciplineApproveManager.extractByteArray(file));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String button1_action() {
        if (disciplineApproveManager.saveFile(fileUpLoad)) {

            showSuccessOrFailureMessage(true, "COMMITTEE MINUTE SAVING SUCCESSFULL");

        } else {
            showSuccessOrFailureMessage(false, "ERROR OCURED TO SAVE COMMITTEE MINUTE");

        }
        return null;
    }

    public String cmd_downLoad_action() {
        //  AccusedFileUpLoad commentFile = new AccusedFileUpLoad();
        CommitteeMinuteFileUpLoad miniteFile = new CommitteeMinuteFileUpLoad();
        try {

            miniteFile = disciplineApproveManager.setValues(disciplineProblemId);
            if (miniteFile.getFileID() == 0) {
                setDownloadAvailable(false);
            } else {
                readPdfFilesForMiniute(miniteFile.getFileID(), miniteFile.getFileName(), miniteFile.getExtention());
                setDownloadAvailable(true);
            }



        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;

    }
}







