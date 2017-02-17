/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright 
 */
package fphrms.Termination;

import com.icesoft.faces.async.render.OnDemandRenderer;
import com.icesoft.faces.async.render.RenderManager;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.webapp.xmlhttp.PersistentFacesState;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.ByteArrayResource;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.fileManager.ResourceManager;
import manager.terminationManager.TransferApproveManager;
import manager.terminationManager.TransferManager;
import manager.userManagement.SiteSecurityManager;
import oracle.jdbc.rowset.OracleSerialBlob;
import com.icesoft.faces.context.Resource;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import manager.globalUseManager.ErrorLogWriter;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TransferApprovePage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    //for ajax push
    private PersistentFacesState state = null;
    private RenderManager renderManager;
    public static OnDemandRenderer personGroup = null;
    private int __placeholder;
    private String attachedImage = "/SalaryDelegation/images/attachment.gif";
    private String loggedInUserId = null;
    private int ownerGroupId = 0;
    private int nextGroupId = 0;
    private int currentStateId = 0;
    private int resubmitStateId = 0;
    private int approveStateId = 0;
    private int rejectStateId = 0;
//    private int currentWorkflowId = 0;
    public int requestId = 0;
    private String description;
    private String requesterId = null;
    private int itemId = 0;
    String loggedInEmployeeId;
    String loggedInEmployeeDept;
    String userName;
    String changeOrSearchDeciderButtonLabel = "Change";
    EmployeeManage employeeManager = new EmployeeManage();
    TransferApproveManager transferApproveManager = new TransferApproveManager();
    private TransferManager transferManager = new TransferManager();
    private DepartmentManage departmentManage = new DepartmentManage();
    private SiteSecurityManager securityManager = new SiteSecurityManager();
    private ServerPushApplicationBean serverPushApplicationBean = new ServerPushApplicationBean();
    private ServerPushSessionBean serverPushSessionBean = new ServerPushSessionBean();
    private ArrayList<SelectItem> newRequestArraivalsList = new ArrayList<SelectItem>();
    private ArrayList<FileAttachmentModel> readAttachedDocuments = new ArrayList<FileAttachmentModel>();
    private ArrayList<FileAttachmentModel> fileAttachment = new ArrayList<FileAttachmentModel>();
    private ArrayList<SelectItem> stateTransions = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> newRequests = new ArrayList<SelectItem>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    private List transferFileList = new ArrayList<FileAttachmentModel>();
    private byte[] employeePicture;
    private byte[] attachedDBImg;
    private boolean intLoad = true;
    private static int resourceId = 0;
    private static int transferProcessType = -1;
    private int transferRequestId;
    private String requestStatus;
    private boolean downloadAvailable;
    String sex;
    String empType;
    int committeeId;
    int selectedCommitteeMemberRow = -1;
    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();
    CommitteeRegistrationManager committeeRegistrationManager = new CommitteeRegistrationManager();
    ArrayList<SelectItem> committeeList = committeeRegistrationManager.getAllActiveCommitteesSelectItem();
    ArrayList<CommitteeMemberModel> committeeMemberLists = new ArrayList<CommitteeMemberModel>();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    ArrayList<SelectItem> committeeType = committeeRegistrationManager.getAllCommitteesTypeForLu();
    ArrayList<CommitteeMemberModel> committeeMembersList = new ArrayList<CommitteeMemberModel>();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }

    public ArrayList<FileAttachmentModel> getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(ArrayList<FileAttachmentModel> fileAttachment) {
        this.fileAttachment = fileAttachment;
    }
    private HtmlOutputText lblEmployeeId = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeId() {
        return lblEmployeeId;
    }

    public void setLblEmployeeId(HtmlOutputText hot) {
        this.lblEmployeeId = hot;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public String getChangeOrSearchDeciderButtonLabel() {
        return changeOrSearchDeciderButtonLabel;
    }

    public void setChangeOrSearchDeciderButtonLabel(String changeOrSearchDeciderButtonLabel) {
        this.changeOrSearchDeciderButtonLabel = changeOrSearchDeciderButtonLabel;
    }

    public String getLoggedInEmployeeDept() {
        return loggedInEmployeeDept;
    }

    public void setLoggedInEmployeeDept(String loggedInEmployeeDept) {
        this.loggedInEmployeeDept = loggedInEmployeeDept;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    private DefaultSelectedData selectBooleanCheckbox5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox5Bean() {
        return selectBooleanCheckbox5Bean;
    }

    public void setSelectBooleanCheckbox5Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox5Bean = dsd;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlDataTable tblAttachedFile = new HtmlDataTable();

    public HtmlDataTable getTblAttachedFile() {
        return tblAttachedFile;
    }

    public void setTblAttachedFile(HtmlDataTable hdt) {
        this.tblAttachedFile = hdt;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlGraphicImage imgEmployeePicture = new HtmlGraphicImage();

    public HtmlGraphicImage getImgEmployeePicture() {
        return imgEmployeePicture;
    }

    public void setImgEmployeePicture(HtmlGraphicImage hgi) {
        this.imgEmployeePicture = hgi;
    }
    private HtmlSelectBooleanCheckbox chkPermanet = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkPermanet() {
        return chkPermanet;
    }

    public void setChkPermanet(HtmlSelectBooleanCheckbox hsbc) {
        this.chkPermanet = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkContrat = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkContrat() {
        return chkContrat;
    }

    public void setChkContrat(HtmlSelectBooleanCheckbox hsbc) {
        this.chkContrat = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMale() {
        return chkMale;
    }

    public void setChkMale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkFemale() {
        return chkFemale;
    }

    public void setChkFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkFemale = hsbc;
    }
    private HtmlOutputText lblHireDate = new HtmlOutputText();

    public HtmlOutputText getLblHireDate() {
        return lblHireDate;
    }

    public void setLblHireDate(HtmlOutputText hot) {
        this.lblHireDate = hot;
    }
    private HtmlOutputText lblAge = new HtmlOutputText();

    public HtmlOutputText getLblAge() {
        return lblAge;
    }

    public void setLblAge(HtmlOutputText hot) {
        this.lblAge = hot;
    }
    private HtmlOutputText lblServiceYear = new HtmlOutputText();

    public HtmlOutputText getLblServiceYear() {
        return lblServiceYear;
    }

    public void setLblServiceYear(HtmlOutputText hot) {
        this.lblServiceYear = hot;
    }
    private HtmlOutputText lblResignDate = new HtmlOutputText();

    public HtmlOutputText getLblResignDate() {
        return lblResignDate;
    }

    public void setLblResignDate(HtmlOutputText hot) {
        this.lblResignDate = hot;
    }
    private HtmlOutputText lblDateRequested = new HtmlOutputText();

    public HtmlOutputText getLblDateRequested() {
        return lblDateRequested;
    }

    public void setLblDateRequested(HtmlOutputText hot) {
        this.lblDateRequested = hot;
    }
    private HtmlOutputText lblPosition = new HtmlOutputText();

    public HtmlOutputText getLblPosition() {
        return lblPosition;
    }

    public void setLblPosition(HtmlOutputText hot) {
        this.lblPosition = hot;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }

    public ArrayList<SelectItem> getNewRequestArraivalsList() {
        return newRequestArraivalsList;
    }

    public void setNewRequestArraivalsList(ArrayList<SelectItem> newRequestArraivalsList) {
        this.newRequestArraivalsList = newRequestArraivalsList;
    }
    private HtmlSelectOneListbox selectRequestApprovableRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectRequestApprovableRequestLists() {
        return selectRequestApprovableRequestLists;
    }

    public void setSelectRequestApprovableRequestLists(HtmlSelectOneListbox hsol) {
        this.selectRequestApprovableRequestLists = hsol;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public ArrayList<FileAttachmentModel> getReadAttachedDocuments() {
        return readAttachedDocuments;
    }

    public void setReadAttachedDocuments(ArrayList<FileAttachmentModel> readAttachedDocuments) {
        this.readAttachedDocuments = readAttachedDocuments;
    }
    private PanelPopup pnlPopUpAttachment = new PanelPopup();

    public PanelPopup getPnlPopUpAttachment() {
        return pnlPopUpAttachment;
    }

    public void setPnlPopUpAttachment(PanelPopup pp) {
        this.pnlPopUpAttachment = pp;
    }
    private HtmlGraphicImage gimgAttachedDocuments = new HtmlGraphicImage();

    public HtmlGraphicImage getGimgAttachedDocuments() {
        return gimgAttachedDocuments;
    }

    public void setGimgAttachedDocuments(HtmlGraphicImage hgi) {
        this.gimgAttachedDocuments = hgi;
    }

    public byte[] getAttachedDBImg() {
        return attachedDBImg;
    }

    public void setAttachedDBImg(byte[] attachedDBImg) {
        this.attachedDBImg = attachedDBImg;
    }
    private HtmlCommandLink lnkDocumentAttached = new HtmlCommandLink();

    public HtmlCommandLink getLnkDocumentAttached() {
        return lnkDocumentAttached;
    }

    public void setLnkDocumentAttached(HtmlCommandLink hcl) {
        this.lnkDocumentAttached = hcl;
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<Option> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
    }
//    private HtmlOutputText lblWorkflow = new HtmlOutputText();
//
//    public HtmlOutputText getLblWorkflow() {
//        return lblWorkflow;
//    }
//
//    public void setLblWorkflow(HtmlOutputText hot) {
//        this.lblWorkflow = hot;
//    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public TransferApproveManager getTransferApproveManager() {
        return transferApproveManager;
    }

    public void setTransferApproveManager(TransferApproveManager transferApproveManager) {
        this.transferApproveManager = transferApproveManager;
    }

    public int getTransferRequestId() {
        return transferRequestId;
    }

    public void setTransferRequestId(int transferRequestId) {
        this.transferRequestId = transferRequestId;
    }
    private HtmlOutputText lblCurrentState = new HtmlOutputText();

    public HtmlOutputText getLblCurrentState() {
        return lblCurrentState;
    }

    public void setLblCurrentState(HtmlOutputText hot) {
        this.lblCurrentState = hot;
    }
    private HtmlOutputText lblCurrentOwnerGroup = new HtmlOutputText();

    public HtmlOutputText getLblCurrentOwnerGroup() {
        return lblCurrentOwnerGroup;
    }

    public void setLblCurrentOwnerGroup(HtmlOutputText hot) {
        this.lblCurrentOwnerGroup = hot;
    }
    private HtmlOutputText lblWaitingDays = new HtmlOutputText();

    public HtmlOutputText getLblWaitingDays() {
        return lblWaitingDays;
    }

    public void setLblWaitingDays(HtmlOutputText hot) {
        this.lblWaitingDays = hot;
    }
    private HtmlOutputText lblResignReason = new HtmlOutputText();

    public HtmlOutputText getLblResignReason() {
        return lblResignReason;
    }

    public void setLblResignReason(HtmlOutputText hot) {
        this.lblResignReason = hot;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }

    public ArrayList<SelectItem> getStateTransions() {
        return stateTransions;
    }

    public void setStateTransions(ArrayList<SelectItem> stateTransions) {
        this.stateTransions = stateTransions;
    }
    private HtmlSelectOneMenu ddlstStateTransitions = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdlstStateTransitions() {
        return ddlstStateTransitions;
    }

    public void setDdlstStateTransitions(HtmlSelectOneMenu hsom) {
        this.ddlstStateTransitions = hsom;
    }
    private HtmlInputTextarea txtDecisionRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDecisionRemark() {
        return txtDecisionRemark;
    }

    public void setTxtDecisionRemark(HtmlInputTextarea hit) {
        this.txtDecisionRemark = hit;
    }
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }
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
    private HtmlCommandLink lnkTransionHistory = new HtmlCommandLink();

    public HtmlCommandLink getLnkTransionHistory() {
        return lnkTransionHistory;
    }

    public void setLnkTransionHistory(HtmlCommandLink hcl) {
        this.lnkTransionHistory = hcl;
    }
    private PanelPopup pnlTransionHistory = new PanelPopup();

    public PanelPopup getPnlTransionHistory() {
        return pnlTransionHistory;
    }

    public void setPnlTransionHistory(PanelPopup pp) {
        this.pnlTransionHistory = pp;
    }

    public ArrayList<SelectItem> getNewRequests() {

        return newRequests;
    }

    public void setNewRequests(ArrayList<SelectItem> newRequests) {
        this.newRequests = newRequests;
    }
    private HtmlOutputText lblToDepartment = new HtmlOutputText();

    public HtmlOutputText getLblToDepartment() {
        return lblToDepartment;
    }

    public void setLblToDepartment(HtmlOutputText hot) {
        this.lblToDepartment = hot;
    }
    private HtmlOutputText lblTransfertype = new HtmlOutputText();

    public HtmlOutputText getLblTransfertype() {
        return lblTransfertype;
    }

    public void setLblTransfertype(HtmlOutputText hot) {
        this.lblTransfertype = hot;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkEnternalSameDepartment = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkEnternalSameDepartment() {
        return chkEnternalSameDepartment;
    }

    public void setChkEnternalSameDepartment(HtmlSelectBooleanCheckbox hsbc) {
        this.chkEnternalSameDepartment = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkEnternalCrossDepartment = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkEnternalCrossDepartment() {
        return chkEnternalCrossDepartment;
    }

    public void setChkEnternalCrossDepartment(HtmlSelectBooleanCheckbox hsbc) {
        this.chkEnternalCrossDepartment = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkExternal = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkExternal() {
        return chkExternal;
    }

    public void setChkExternal(HtmlSelectBooleanCheckbox hsbc) {
        this.chkExternal = hsbc;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlInputText txtDeciderRank = new HtmlInputText();

    public HtmlInputText getTxtDeciderRank() {
        return txtDeciderRank;
    }

    public void setTxtDeciderRank(HtmlInputText hit) {
        this.txtDeciderRank = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private HtmlInputText txtDeciderPosition = new HtmlInputText();

    public HtmlInputText getTxtDeciderPosition() {
        return txtDeciderPosition;
    }

    public void setTxtDeciderPosition(HtmlInputText hit) {
        this.txtDeciderPosition = hit;
    }
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlCommandButton btnSearchDecider = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchDecider() {
        return btnSearchDecider;
    }

    public void setBtnSearchDecider(HtmlCommandButton hcb) {
        this.btnSearchDecider = hcb;
    }
    private HtmlPanelGroup RetirementApproval = new HtmlPanelGroup();

    public HtmlPanelGroup getRetirementApproval() {
        return RetirementApproval;
    }

    public void setRetirementApproval(HtmlPanelGroup hpg) {
        this.RetirementApproval = hpg;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlInputTextarea txtRemarkReq = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemarkReq() {
        return txtRemarkReq;
    }

    public void setTxtRemarkReq(HtmlInputTextarea hit) {
        this.txtRemarkReq = hit;
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

    public ArrayList<CommitteeMemberModel> getCommitteeMembersList() {
        return committeeMembersList;
    }

    public void setCommitteeMembersList(ArrayList<CommitteeMemberModel> committeeMembersList) {
        this.committeeMembersList = committeeMembersList;
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
    private PanelPopup pnlPopupCommitteeMembers = new PanelPopup();

    public PanelPopup getPnlPopupCommitteeMembers() {
        return pnlPopupCommitteeMembers;
    }

    public void setPnlPopupCommitteeMembers(PanelPopup pp) {
        this.pnlPopupCommitteeMembers = pp;
    }
    private HtmlSelectBooleanCheckbox chkCommittee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkCommittee() {
        return chkCommittee;
    }

    public void setChkCommittee(HtmlSelectBooleanCheckbox hsbc) {
        this.chkCommittee = hsbc;
    }
    private PanelLayout pnlLayoutCommitteeMember = new PanelLayout();

    public PanelLayout getPnlLayoutCommitteeMember() {
        return pnlLayoutCommitteeMember;
    }

    public void setPnlLayoutCommitteeMember(PanelLayout pl) {
        this.pnlLayoutCommitteeMember = pl;
    }
    private HtmlSelectOneMenu drlCommitteeType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommitteeType() {
        return drlCommitteeType;
    }

    public void setDrlCommitteeType(HtmlSelectOneMenu hsom) {
        this.drlCommitteeType = hsom;
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

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public ArrayList<SelectItem> getCommitteeList() {
        return committeeList;
    }

    public void setCommitteeList(ArrayList<SelectItem> committeeList) {
        this.committeeList = committeeList;
    }

    public ArrayList<CommitteeMemberModel> getCommitteeMemberLists() {
        return committeeMemberLists;
    }

    public void setCommitteeMemberLists(ArrayList<CommitteeMemberModel> committeeMemberLists) {
        this.committeeMemberLists = committeeMemberLists;
    }

    public CommitteeMemberRegistrationManager getCommitteeMemberRegistrationManager() {
        return committeeMemberRegistrationManager;
    }

    public void setCommitteeMemberRegistrationManager(CommitteeMemberRegistrationManager committeeMemberRegistrationManager) {
        this.committeeMemberRegistrationManager = committeeMemberRegistrationManager;
    }

    public CommitteeRegistrationManager getCommitteeRegistrationManager() {
        return committeeRegistrationManager;
    }

    public void setCommitteeRegistrationManager(CommitteeRegistrationManager committeeRegistrationManager) {
        this.committeeRegistrationManager = committeeRegistrationManager;
    }

    public ArrayList<SelectItem> getCommitteeType() {
        return committeeType;
    }

    public void setCommitteeType(ArrayList<SelectItem> committeeType) {
        this.committeeType = committeeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    private DefaultSelectedData selectedObjectCommitteeType = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommitteeType() {
        return selectedObjectCommitteeType;
    }

    public void setSelectedObjectCommitteeType(DefaultSelectedData selectedObjectCommitteeType) {
        this.selectedObjectCommitteeType = selectedObjectCommitteeType;
    }

    public boolean isDownloadAvailable() {
        return downloadAvailable;
    }

    public void setDownloadAvailable(boolean downloadAvailable) {
        this.downloadAvailable = downloadAvailable;
    }
    private HtmlOutputText txtToPosition = new HtmlOutputText();

    public HtmlOutputText getTxtToPosition() {
        return txtToPosition;
    }

    public void setTxtToPosition(HtmlOutputText hot) {
        this.txtToPosition = hot;
    }
    private HtmlOutputText txtToSalary = new HtmlOutputText();

    public HtmlOutputText getTxtToSalary() {
        return txtToSalary;
    }

    public void setTxtToSalary(HtmlOutputText hot) {
        this.txtToSalary = hot;
    }
    private HtmlOutputText toPayGrade = new HtmlOutputText();

    public HtmlOutputText getToPayGrade() {
        return toPayGrade;
    }

    public void setToPayGrade(HtmlOutputText hot) {
        this.toPayGrade = hot;
    }
    private HtmlOutputText txtToRank = new HtmlOutputText();

    public HtmlOutputText getTxtToRank() {
        return txtToRank;
    }

    public void setTxtToRank(HtmlOutputText hot) {
        this.txtToRank = hot;
    }
    private HtmlOutputText txtSlaryChanged = new HtmlOutputText();

    public HtmlOutputText getTxtSlaryChanged() {
        return txtSlaryChanged;
    }

    public void setTxtSlaryChanged(HtmlOutputText hot) {
        this.txtSlaryChanged = hot;
    }
    private HtmlOutputText lblPrevSalary = new HtmlOutputText();

    public HtmlOutputText getLblPrevSalary() {
        return lblPrevSalary;
    }

    public void setLblPrevSalary(HtmlOutputText hot) {
        this.lblPrevSalary = hot;
    }
    private HtmlOutputText out_txt_toPositionName = new HtmlOutputText();

    public HtmlOutputText getOut_txt_toPositionName() {
        return out_txt_toPositionName;
    }

    public void setOut_txt_toPositionName(HtmlOutputText hot) {
        this.out_txt_toPositionName = hot;
    }
    private HtmlOutputText txt_promoted = new HtmlOutputText();

    public HtmlOutputText getTxt_promoted() {
        return txt_promoted;
    }

    public void setTxt_promoted(HtmlOutputText hot) {
        this.txt_promoted = hot;
    }
    private HtmlOutputText effectiveFrom = new HtmlOutputText();

    public HtmlOutputText getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(HtmlOutputText hot) {
        this.effectiveFrom = hot;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TransferApprovePage() {
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
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        userName = getSessionBean1().getUserName();
        populateApproverTextComponents(loggedInEmployeeId);
        transferApproveManager.setUserName(userName);
        transferManager.setUserName(userName);
        requestListsToBeApproved = transferApproveManager.getRequestsToBeProcessed();
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

//=============================Workflow State Transition History Innner Class
    public static class FileAttachmentModel implements Serializable {

        private String imageId;
        private String imageIcon;
        private String imageName;
        private String imagePath;

         int fileID;
        String fileName;
        String fileType;
        int requestID;
        byte[] attachedFile;
        String extention;

        public byte[] getAttachedFile() {
            return attachedFile;
        }

        public void setAttachedFile(byte[] attachedFile) {
            this.attachedFile = attachedFile;
        }

        public String getExtention() {
            return extention;
        }

        public void setExtention(String extention) {
            this.extention = extention;
        }

        public int getFileID() {
            return fileID;
        }

        public void setFileID(int fileID) {
            this.fileID = fileID;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public int getRequestID() {
            return requestID;
        }

        public void setRequestID(int requestID) {
            this.requestID = requestID;
        }

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

        public FileAttachmentModel() {
        }

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

    private void ResetLocalComponents() {

        getFileAttachment().clear();
        getStateTransions().clear();
        lblEmployeeId.setValue(null);
        lblFullName.setValue(null);
        lblAge.setValue(null);
        lblDateRequested.setValue(null);
        lblDepartment.setValue(null);
        lblHireDate.setValue(null);
        lblPosition.setValue(null);
        lblResignDate.setValue(null);
        lblServiceYear.setValue(null);
//        lblWorkflow.setValue(null);
        lblCurrentState.setValue(null);
        lblCurrentOwnerGroup.setValue(null);
        lblResignReason.setValue(null);
        lblWaitingDays.setValue(null);
        txtDecisionRemark.setValue(null);
        imgEmployeePicture.setValue("");
        chkPermanet.setSelected(false);
        chkContrat.setSelected(false);
        chkFemale.setSelected(false);
        chkMale.setSelected(false);

    }
  private int selectedRow = -1;
    public String fileName = "";
    private String mimeType;
     private Resource faResource;

    public void selectRequestApprovableRequestLists_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            String[] requestInfos = vce.getNewValue().toString().split("--");
            String request;
            request = (requestInfos[0]);//
            requestId = Integer.valueOf((requestInfos[0]));
            requesterId = requestInfos[1];
            requestStatus = requestInfos[2];
            description = requestInfos[3];
            populateRequesterTextComponents(request);
            availableDecisionsToMakeList = transferApproveManager.getAvailableDecisionsToMake(requestStatus);
            decisionsMadeOnRequest = transferApproveManager.getRequestHistory(requestId);
        }
    }

    public void modalPnlCloseBtnAttachment_processAction(ActionEvent ae) {
        pnlPopUpAttachment.setRendered(false);
    }
    
    
    public void readPdfFiles(int documentId, String _fileName, String extension) {
        try {
            byte[] attachedFile = transferApproveManager.singleSelect(documentId);

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


    public String lnkDocumentAttached_action() {
        // int selectedRow = tblAttachedFile.getRowIndex();
          FileAttachmentModel commentFile = new FileAttachmentModel();
        try {
     
             commentFile = transferManager.setValues(requestId);
            if (commentFile.getFileID()== 0)
            {
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




//
//        try {
//
//            if (selectedRow > -1) {
//
//                FileAttachmentModel manager = (FileAttachmentModel) transferFileList.get(selectedRow);
//                setDownloadAvailable(false);
//                readPdfFiles((manager.getImageId()), manager.getImageName(), manager.getImageIcon());
//                setDownloadAvailable(true);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//        }
//        return null;




//        int selectedRow = tblAttachedFile.getRowIndex();
//        String documentId = String.valueOf(fileAttachment.get(selectedRow).imageId);
//        try {
//            HashMap terReq = transferManager.readAttachedDocuments(documentId);
//            OracleSerialBlob blo = (OracleSerialBlob) terReq.get("docPath");
//            setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
//            gimgAttachedDocuments.setValue(getAttachedDBImg());
//            pnlPopUpAttachment.setRendered(true);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

       // return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public String lnkClearancePage_action() {
        //return null means stay on the same page
        return "TerminationClearance";
    }


    // <editor-fold defaultstate="collapsed" desc="all Getters and Setters">
    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public int getApproveStateId() {
        return approveStateId;
    }

    public void setApproveStateId(int approveStateId) {
        this.approveStateId = approveStateId;
    }

    public String getAttachedImage() {
        return attachedImage;
    }

    public void setAttachedImage(String attachedImage) {
        this.attachedImage = attachedImage;
    }

    public int getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(int currentStateId) {
        this.currentStateId = currentStateId;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public boolean isIntLoad() {
        return intLoad;
    }

    public void setIntLoad(boolean intLoad) {
        this.intLoad = intLoad;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(String loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public int getNextGroupId() {
        return nextGroupId;
    }

    public void setNextGroupId(int nextGroupId) {
        this.nextGroupId = nextGroupId;
    }

    public int getOwnerGroupId() {
        return ownerGroupId;
    }

    public void setOwnerGroupId(int ownerGroupId) {
        this.ownerGroupId = ownerGroupId;
    }

    public static OnDemandRenderer getPersonGroup() {
        return personGroup;
    }

    public static void setPersonGroup(OnDemandRenderer personGroup) {
        TransferApprovePage.personGroup = personGroup;
    }

    public int getRejectStateId() {
        return rejectStateId;
    }

    public void setRejectStateId(int rejectStateId) {
        this.rejectStateId = rejectStateId;
    }

    public RenderManager getRenderManager() {
        return renderManager;
    }

    public void setRenderManager(RenderManager renderManager) {
        this.renderManager = renderManager;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public static int getResourceId() {
        return resourceId;
    }

    public static void setResourceId(int resourceId) {
        TransferApprovePage.resourceId = resourceId;
    }

    public int getResubmitStateId() {
        return resubmitStateId;
    }

    public void setResubmitStateId(int resubmitStateId) {
        this.resubmitStateId = resubmitStateId;
    }

    public SiteSecurityManager getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SiteSecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public ServerPushApplicationBean getServerPushApplicationBean() {
        return serverPushApplicationBean;
    }

    public void setServerPushApplicationBean(ServerPushApplicationBean serverPushApplicationBean) {
        this.serverPushApplicationBean = serverPushApplicationBean;
    }

    public ServerPushSessionBean getServerPushSessionBean() {
        return serverPushSessionBean;
    }

    public void setServerPushSessionBean(ServerPushSessionBean serverPushSessionBean) {
        this.serverPushSessionBean = serverPushSessionBean;
    }

    public PersistentFacesState getState() {
        return state;
    }

    public void setState(PersistentFacesState state) {
        this.state = state;
    }

    public TransferManager getTransferManager() {
        return transferManager;
    }

    public void setTransferManager(TransferManager transferManager) {
        this.transferManager = transferManager;
    }

    public static int getTransferProcessType() {
        return transferProcessType;
    }

    public static void setTransferProcessType(int transferProcessType) {
        TransferApprovePage.transferProcessType = transferProcessType;
    }

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    // </editor-fold>
    private void clearAllComponents() {
        decisionsMadeOnRequest = null;
        transferRequestId = -1;
        drlDecision.resetValue();
    }
    public boolean takeBackUP()
    {
      String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
      String reasonForTransfer = txtRemarkReq.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
     // transferApproveManager.setReasonForTransfer(reasonForTransfer);
      String salaryChanged=txtSlaryChanged.getValue().toString();
      String toPosition=txtToPosition.getValue().toString();
      String toRank=txtToRank.getValue().toString();
      String toSalary=txtToSalary.getValue().toString();
      String requester_id=lblEmployeeId.getValue().toString();
      String payGrade=toPayGrade.getValue().toString();
      String [] deptId=lblToDepartment.getValue().toString().split("--");
      String dpid=deptId[1];
      String []prevDept=lblDepartment.getValue().toString().split("--");
      String prevDeptID=prevDept[1];
      String [] prevPosition=lblPosition.getValue().toString().split("--");
      String prevPos=prevPosition[1];
      int requestID= requestId;
      String requesterID=requester_id;
      String approvedID= txtDeciderId.getValue().toString();
      String prevSalary=lblPrevSalary.getValue().toString();
      String backUpTakenDateAndTime = new Timestamp((new Date()).getTime()).toString();
       boolean bbReturn=transferApproveManager.TakeBackUpOfTransfere(requestID,requesterID,approvedID,backUpTakenDateAndTime,prevPos,toPosition,prevSalary,toSalary,prevDeptID,dpid);
        if(bbReturn)
        {
          
        return true;

        }
        else
        {

        return false;
        }
    //transferApproveManager.TakeBackUpOfTransfere(requestID,requesterID,approvedID,backUpTakenDateAndTime,prevPos,toPosition,prevSalary,toSalary,prevDeptID,dpid);
        }

    public boolean saveTransferDecision()
    {
        boolean emplStat=false;
        boolean finalResult=false;
        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
        String reasonForTransfer = txtRemarkReq.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
        transferApproveManager.setReasonForTransfer(reasonForTransfer);
        String salaryChanged=txtSlaryChanged.getValue().toString();
        String promoted=txt_promoted.getValue().toString();
        String toPosition=txtToPosition.getValue().toString();
        String toRank=txtToRank.getValue().toString();
        String toSalary=txtToSalary.getValue().toString();
        String requester_id=lblEmployeeId.getValue().toString();
        String payGrade=toPayGrade.getValue().toString();
        String [] deptId=lblToDepartment.getValue().toString().split("--");
        String id=deptId[1];
     //   String positionName=transferApproveManager.getPositionName(toPosition);
        String updatedPosition=out_txt_toPositionName.getValue().toString();
        String effectiveDate=effectiveFrom.getValue().toString();
        if((salaryChanged.equalsIgnoreCase("Yes"))&&(promoted.equalsIgnoreCase("NO")))
            {
       
        finalResult=transferApproveManager.saveTransferDecision(requestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);
               
           if(finalResult)
             {
         emplStat  = transferApproveManager.UpdateEmployeeStatus(toPosition,toRank,toSalary,requester_id,payGrade,id,updatedPosition,effectiveDate);
              }

          return emplStat;
            }
        else if((salaryChanged.equalsIgnoreCase("No"))&&(promoted.equalsIgnoreCase("NO")))
        {
          
        emplStat= transferApproveManager.saveTransferDecision(requestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);
        if(emplStat)

        emplStat  = transferApproveManager.UpdateEmployeeStatus(toPosition,toRank,toSalary,requester_id,payGrade,id,updatedPosition,effectiveDate);
        }
        else if((salaryChanged.equalsIgnoreCase("Yes"))&&(promoted.equalsIgnoreCase("YES")))
        {

        emplStat= transferApproveManager.saveTransferDecision(requestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);
        if(emplStat)

        emplStat  = transferApproveManager.UpdateEmployeeStatusNew(toPosition,toRank,toSalary,requester_id,payGrade,id,updatedPosition,effectiveDate);

        }
      return emplStat;

    }

    private boolean validateDecision()
    {

        if (drlDecision.getValue().toString().equals(TransferApproveManager.TRANSFER_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(TransferApproveManager.TRANSFER_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (transferRequestId == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE TRANSFER TO DECIDE");
            return false;
        }
        return true;
    }

    public void drlCommittee_processValueChange(ValueChangeEvent vce) {
        committeeId = Integer.parseInt(vce.getNewValue().toString());

        if (committeeId != -1) {
            committeeMemberLists = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
        } else {
            committeeMemberLists = new ArrayList<CommitteeMemberModel>();
        }
    }
public String jobName;
    public Resource getFaResource() {
        return faResource;
    }

    public void setFaResource(Resource faResource) {
        this.faResource = faResource;
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

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
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
                if (saveTransferDecision()) {
                  transferManager.updateRequest(committeeId,requestId);
                    showSuccessOrFailureMessage(true, "The Transfer Information Approved Successfully!");
                } else {
                    showSuccessOrFailureMessage(false, "The Transfer Information Not Approved.Please try agin?");
                }
                 lblSignInReminder.setValue("Note: Greater than 50% approved." +
                    " Only " + counterCheck + " out of " + totalSize + " confirmed. ");
            } catch (Exception e) {
            }
            return true;
        }
    }

    public String btnClosePopupCommitteeMembers_action() {
        if (isEnoughCommitteeNumbersSigned()) {
            pnlPopupCommitteeMembers.setRendered(false);
//            pnlPopupSuccessOrFailure.setRendered(false);
        }
        return null;
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

    public void rowSelectorCommitteeMember_processMyEvent(RowSelectorEvent rse) {
        selectedCommitteeMemberRow = rse.getRow();
    }

    public String cmdLnkClosePopupCommitteeMembers_action() {
        cmdLnkClosePopupCommitteeMembers.setRendered(false);
        pnlPopupCommitteeMembers.setRendered(false);
//        pnlPopupSuccessOrFailure.setRendered(false);
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

    public String btnPostDecision_action()
                 {
          if (validateDecision())
               {
         if(takeBackUP())
               {
          if (saveTransferDecision())
                   {
                btnPostDecision.setDisabled(true);
                clearAllComponents();
                requestListsToBeApproved = transferApproveManager.getRequestsToBeProcessed();
                showSuccessOrFailureMessage(true, "APPROVAL SUCCESSFUL");
                   }
          else{
                showSuccessOrFailureMessage(false, "APPROVAL NOT SUCCESSFUL");

          }
     
                   }
       
                  
             else
             {
            showSuccessOrFailureMessage(false, "APPROVAL FAILED");
            }
          }
        return null;
    }

    private boolean populateApproverTextComponents(String approverId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
                txtDeciderId.setDisabled(false);
                return false;
            } else {
                approverId = empInfoHashMap.get("employeeId").toString();
                txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtDeciderFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                txtDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                txtDeciderRank.setValue(empInfoHashMap.get("employeeRank"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }
    


     private boolean populateRequesterTextComponentsForTheRequesterOnly(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                lblDepartment.setValue(empInfoHashMap.get("employeeDepartmentName")+"--"+empInfoHashMap.get("employeeDepartment"));
                lblFullName.setValue(empInfoHashMap.get("employeeFullName"));
                lblEmployeeId.setValue(employeeId);
                lblPosition.setValue(empInfoHashMap.get("employeePosition")+"--"+empInfoHashMap.get("employeeJobCode"));
                lblPrevSalary.setValue(empInfoHashMap.get("employeeSalary"));

                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void loadEmployeeProfileDetail(String empId) {
        try {
            this.populateRequesterTextComponentsForTheRequesterOnly(empId);
             employeeManager.loadEmpoyeeProfile(empId);
             int age = employeeManager.calculateEmployeeAgeInYears(empId);
            lblAge.setValue(age);
            sex = employeeManager.getSex();
            empType=employeeManager.getPermanentOrContract();
          
            transferApproveManager.setRequesterId(empId);
            int expYear = employeeManager.calculateEmployeeServiceYear(empId);
            lblServiceYear.setValue(String.valueOf(expYear));
            lblHireDate.setValue(employeeManager.getHire_Date());

            if (sex.equalsIgnoreCase("Male"))
            {
                chkMale.setSelected(true);
            } else if (sex.equalsIgnoreCase("Female")) {
                chkFemale.setSelected(true);
            } else {
                chkMale.setSelected(false);
                chkFemale.setSelected(false);
            }
            if(empType.equalsIgnoreCase("Permanent")){
                chkPermanet.setSelected(true);
                
            }else if(empType.equalsIgnoreCase("Contract")){
                chkContrat.setSelected(true);
                
            }else{
               chkPermanet.setSelected(false);
                chkContrat.setSelected(false);
               
            
            
            }


           OracleSerialBlob blo = null;
            blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
            imgEmployeePicture.setValue(null);
            try {
                setEmployeePicture(null);
                setEmployeePicture(blo.getBytes(0, (int) blo.length()));
                imgEmployeePicture.setValue(this.getEmployeePicture());
            } catch (Exception ex) {
                ex.printStackTrace();
            }



//            OracleSerialBlob blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
//            try {
//                setAttachedDBImg(blo.getBytes(0, (int) blo.length()));
//                imgEmployeePicture.setValue(getAttachedDBImg());
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }

    public String  PositionName(String jobCode)
    {

     jobName=transferManager.getJobName(jobCode);

     return jobName;
    }

    private void populateRequesterTextComponents(String requstId) {
        ResetLocalComponents();
        String department;
        String strRequesterId = transferManager.readEmployeeIDByRequestID(requstId);
        loadEmployeeProfileDetail(strRequesterId);
        if (strRequesterId != null) {

            HashMap hm = transferManager.ReadRequestsInfo(requstId);
            if (hm != null) {

                lblDateRequested.setValue(": " + hm.get("dateRequested").toString());
                txtRemarkReq.setValue(hm.get("description"));
                lblResignReason.setValue(hm.get("requesttypeName").toString());
                lblTransfertype.setValue(": " + hm.get("requesttypeName").toString());
                txtToPosition.setValue(hm.get("newPosition").toString());
                out_txt_toPositionName.setValue(this.PositionName(hm.get("newPosition").toString()));
                txtToRank.setValue(hm.get("newRank").toString());
                toPayGrade.setValue(hm.get("newPayGrade").toString());
                txtToSalary.setValue(hm.get("newSalary").toString());
                txtSlaryChanged.setValue(hm.get("salaryChange").toString());
                txt_promoted.setValue(hm.get("promoted").toString());
                effectiveFrom.setValue(hm.get("effectiveFrom").toString());
                if (hm.get("transferProcessType").toString().equalsIgnoreCase("0"))
                {
                    transferProcessType = 0;
                    transferApproveManager.setTransferProcessType(transferProcessType);
                    chkEnternalSameDepartment.setSelected(true);
                    chkEnternalCrossDepartment.setSelected(false);
                    chkExternal.setSelected(false);
                    
                    lblToDepartment.setValue(": " + departmentManage.traceDepartemnt(hm.get("toDepartment").toString()));
                } else if (hm.get("transferProcessType").toString().equalsIgnoreCase("1"))
                {
                    transferProcessType = 1;
                    transferApproveManager.setTransferProcessType(transferProcessType);
                    chkEnternalSameDepartment.setSelected(false);
                    chkEnternalCrossDepartment.setSelected(true);
                    chkExternal.setSelected(false);
                    
                     lblToDepartment.setValue(": " + departmentManage.readDepartmentNameBiruk(hm.get("toDepartment").toString()));
                     // lblToDepartment.setValue(": " + departmentManage.traceDepartemnt(hm.get("toDepartment").toString()));
                } else if (hm.get("transferProcessType").toString().equalsIgnoreCase("2")) {
                    transferProcessType = 2;
                    transferApproveManager.setTransferProcessType(transferProcessType);
                    chkEnternalSameDepartment.setSelected(false);
                    chkEnternalCrossDepartment.setSelected(false);
                    chkExternal.setSelected(true);
                    lblToDepartment.setValue(": " + hm.get("toDepartment").toString());

                }
            }
            ArrayList<HashMap> attachedDocumentsList = transferManager.ReadSupportiveInfo(requstId);//read if any attached document
            if (attachedDocumentsList != null) {
                for (HashMap hm1 : attachedDocumentsList) {
                    getFileAttachment().add(new FileAttachmentModel(hm1.get("docId").toString(), attachedImage, hm1.get("docName").toString(), hm1.get("docPath").toString()));
                }
            }
        }

    }

    private void clearDeciderTextComponenets() {
        txtDeciderDepartment.setValue(null);
        txtDeciderFullName.setValue(null);
        txtDeciderId.setValue(null);
        txtDeciderPosition.setValue(null);
        txtDeciderRank.setValue(null);
    }

    public String btnSearchDecider_action() {

        if (changeOrSearchDeciderButtonLabel.equalsIgnoreCase("Change")) {
            clearDeciderTextComponenets();
            txtDeciderId.setDisabled(false);
            changeOrSearchDeciderButtonLabel = "Search";
        } else {//if (changeOrSearchDeciderButtonLabel.equalsIgnoreCase("Search"))
            if (txtDeciderId.getValue() == null || txtDeciderId.getValue().toString().equals("")) {
                showSuccessOrFailureMessage(false, "INSERT EMPLOYEE ID ");
            } else {
                String tempEmployeeId = txtDeciderId.getValue().toString();
                //if no employee found, populateApproverTextComponents() resets decider text components
                if (!populateApproverTextComponents(tempEmployeeId)) {
                    populateApproverTextComponents(loggedInEmployeeId);
                    showSuccessOrFailureMessage(false, "NO EMPLOYEE WITH ID : " + tempEmployeeId);
                }
            }
            txtDeciderId.setDisabled(true);
            changeOrSearchDeciderButtonLabel = "Change";
        }
        return null;
    }

    public String lnkResignApprovePage_action() {
        //return null means stay on the same page
        return "TransferRequest";
    }

    public void drlDecision_processValueChange(ValueChangeEvent vce) {
    }

    public void chkCommittee_processValueChange(ValueChangeEvent vce) {
        if (chkCommittee.isSelected())
        {
            pnlLayoutCommitteeMember.setRendered(true);
        } else {
            pnlLayoutCommitteeMember.setRendered(false);
        }
    }
}
