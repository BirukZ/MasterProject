/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.component.UISelectItems;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.recruitmentManager.RecruitmentManager;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.committeeManager.CommitteeMemberModel;
import manager.committeeManager.CommitteeMemberRegistrationManager;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.recruitmentManager.RecruitmentApproveManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class RecruitmentApprove extends AbstractPageBean {

    ResourceBundle messageResource = null;
    FacesContext context = null;
    DepartmentManage departmentManage = new DepartmentManage();
    public Option[] readJob = departmentManage.readAllJobBYO();
    public Option[] recritmentType = departmentManage.recuitmentType();
    EmployeeManage employeeManage = new EmployeeManage();
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    Option[] requests = recruitmentManager.selectRecruitmentRequests();
    Option[] approved = recruitmentManager.selectRecruitmentRequests();
    private Option[] response = recruitmentManager.selectRecruitmentResponsesGiven();
    ArrayList<SelectItem> committeeLists = recruitmentManager.getActiveRecruitmentCommittees();// new ArrayList<Option>();
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();
    EmployeeManage employeeManager = new EmployeeManage();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    RecruitmentApproveManager recruitmentApproveManager = new RecruitmentApproveManager();
    private Option[] newresponse = recruitmentManager.selectRecruitmentResponses();
    ArrayList<Option> requestListsToBeApproved = new ArrayList<Option>();
    CommitteeRegistrationManager committeeRegistrationManager = new CommitteeRegistrationManager();
    ArrayList<SelectItem> committeeList = committeeRegistrationManager.getAllActiveCommitteesSelectItem();
    ArrayList<CommitteeMemberModel> committeeMemberLists = new ArrayList<CommitteeMemberModel>();
    CommitteeMemberRegistrationManager committeeMemberRegistrationManager = new CommitteeMemberRegistrationManager();
    ArrayList<SelectItem> committeeType = committeeRegistrationManager.getCommitteeTypes();
    ArrayList<Option> requestHistoryList = new ArrayList<Option>();
    private DefaultSelectedData selectedRequestFromApprovableList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    //    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();?
    String loggedInEmployeeId;
    String loggedInEmployeeDept;
    Option[] recruitmentList;
    String userName;
    String requestStatus;
    Option[] oldRequest;
    static String employeeId;
    int recruitmentRequestId = -1;
    int committeeId;
    public static String requesterId = "";

    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private HtmlInputText txtEmployeeMentType = new HtmlInputText();

    public HtmlInputText getTxtEmployeeMentType() {
        return txtEmployeeMentType;
    }

    public void setTxtEmployeeMentType(HtmlInputText hit) {
        this.txtEmployeeMentType = hit;
    }
    private HtmlInputText txtRequiredJobType = new HtmlInputText();

    public HtmlInputText getTxtRequiredJobType() {
        return txtRequiredJobType;
    }

    public void setTxtRequiredJobType(HtmlInputText hit) {
        this.txtRequiredJobType = hit;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems5 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems5 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems7 = dsia;
    }
    private HtmlSelectOneMenu drlCommittee3 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommittee3() {
        return drlCommittee3;
    }

    public void setDrlCommittee3(HtmlSelectOneMenu hsom) {
        this.drlCommittee3 = hsom;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlInputText txtDeciderPosition = new HtmlInputText();

    public HtmlInputText getTxtDeciderPosition() {
        return txtDeciderPosition;
    }

    public void setTxtDeciderPosition(HtmlInputText hit) {
        this.txtDeciderPosition = hit;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlCommandButton btnSearchDecider = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchDecider() {
        return btnSearchDecider;
    }

    public void setBtnSearchDecider(HtmlCommandButton hcb) {
        this.btnSearchDecider = hcb;
    }
    private UISelectItems selectDecisionAvailable = new UISelectItems();

    public UISelectItems getSelectDecisionAvailable() {
        return selectDecisionAvailable;
    }

    public void setSelectDecisionAvailable(UISelectItems uisi) {
        this.selectDecisionAvailable = uisi;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup hpg) {
        this.panelGroupMessage = hpg;
    }
    private javax.faces.component.html.HtmlOutputLabel lblSuccessOrErrorMessage = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblSuccessOrErrorMessage = hol;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }
    private HtmlSelectOneListbox selectRequestApprovableRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectRequestApprovableRequestLists() {
        return selectRequestApprovableRequestLists;
    }

    public void setSelectRequestApprovableRequestLists(HtmlSelectOneListbox hsol) {
        this.selectRequestApprovableRequestLists = hsol;
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
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }

    public ArrayList<Option> getRequestHistoryList() {
        return requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<Option> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public RecruitmentApproveManager getRecruitmentApproveManager() {
        return recruitmentApproveManager;
    }

    public void setRecruitmentApproveManager(RecruitmentApproveManager recruitmentApproveManager) {
        this.recruitmentApproveManager = recruitmentApproveManager;
    }

    public int getRecruitmentRequestId() {
        return recruitmentRequestId;
    }

    public void setRecruitmentRequestId(int recruitmentRequestId) {
        this.recruitmentRequestId = recruitmentRequestId;
    }

    public ArrayList<Option> getRequestListsToBeApproved() {
        return requestListsToBeApproved;
    }

    public void setRequestListsToBeApproved(ArrayList<Option> requestListsToBeApproved) {
        this.requestListsToBeApproved = requestListsToBeApproved;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public Option[] getApproved() {
        return approved;
    }

    public void setApproved(Option[] approved) {
        this.approved = approved;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public static String getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(String employeeId) {
        RecruitmentApprove.employeeId = employeeId;
    }

    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }

    public void setEmployeeManage(EmployeeManage employeeManage) {
        this.employeeManage = employeeManage;
    }

    public ResourceBundle getMessageResource() {
        return messageResource;
    }

    public void setMessageResource(ResourceBundle messageResource) {
        this.messageResource = messageResource;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public RecruitmentManager getRecruitmentManager() {
        return recruitmentManager;
    }

    public void setRecruitmentManager(RecruitmentManager recruitmentManager) {
        this.recruitmentManager = recruitmentManager;
    }

    public static String getRequesterId() {
        return requesterId;
    }

    public static void setRequesterId(String requesterId) {
        RecruitmentApprove.requesterId = requesterId;
    }

    public Option[] getNewresponse() {
        return newresponse;
    }

    public void setNewresponse(Option[] newresponse) {
        this.newresponse = newresponse;
    }

    public Option[] getResponse() {
        return response;
    }

    public void setResponse(Option[] response) {
        this.response = response;
    }

    public Option[] getOldRequest() {
        return oldRequest;
    }

    public void setOldRequest(Option[] oldRequest) {
        this.oldRequest = oldRequest;
    }

    public Option[] getRecruitmentList() {
        return recruitmentList;
    }

    public void setRecruitmentList(Option[] recruitmentList) {
        this.recruitmentList = recruitmentList;
    }

    public ArrayList<SelectItem> getCommitteeLists() {
        return committeeLists;
    }

    public void setCommitteeLists(ArrayList<SelectItem> committeeLists) {
        this.committeeLists = committeeLists;
    }

    public Option[] getRequests() {
        return requests;
    }

    public void setRequests(Option[] requests) {
        this.requests = requests;
    }

    public Option[] getRecritmentType() {
        return recritmentType;
    }

    public void setRecritmentType(Option[] recritmentType) {
        this.recritmentType = recritmentType;
    }

    public Option[] getReadJob() {
        return readJob;
    }

    public void setReadJob(Option[] readJob) {
        this.readJob = readJob;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    String photoPath;
    String photoName;
    private HtmlSelectOneListbox selectMyHistoryLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyHistoryLists() {
        return selectMyHistoryLists;
    }

    public void setSelectMyHistoryLists(HtmlSelectOneListbox hsol) {
        this.selectMyHistoryLists = hsol;
    }
    private PanelLayout pnlLayoutCommitteeMember = new PanelLayout();

    public PanelLayout getPnlLayoutCommitteeMember() {
        return pnlLayoutCommitteeMember;
    }

    public void setPnlLayoutCommitteeMember(PanelLayout pl) {
        this.pnlLayoutCommitteeMember = pl;
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

    public ArrayList<SelectItem> getCommitteeList() {
        return committeeList;
    }

    public void setCommitteeList(ArrayList<SelectItem> committeeList) {
        this.committeeList = committeeList;
    }

    public CommitteeRegistrationManager getCommitteeRegistrationManager() {
        return committeeRegistrationManager;
    }

    public void setCommitteeRegistrationManager(CommitteeRegistrationManager committeeRegistrationManager) {
        this.committeeRegistrationManager = committeeRegistrationManager;
    }
    private DefaultSelectedData selectedObjectCommitteeType = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommitteeType() {
        return selectedObjectCommitteeType;
    }

    public void setSelectedObjectCommitteeType(DefaultSelectedData selectedObjectCommitteeType) {
        this.selectedObjectCommitteeType = selectedObjectCommitteeType;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private PanelLayout pnlLayoutDecider = new PanelLayout();

    public PanelLayout getPnlLayoutDecider() {
        return pnlLayoutDecider;
    }

    public void setPnlLayoutDecider(PanelLayout pl) {
        this.pnlLayoutDecider = pl;
    }
    private PanelPopup pnlPopupApprove = new PanelPopup();

    public PanelPopup getPnlPopupApprove() {
        return pnlPopupApprove;
    }

    public void setPnlPopupApprove(PanelPopup pp) {
        this.pnlPopupApprove = pp;
    }
    private HtmlCommandButton btnApprove = new HtmlCommandButton();

    public HtmlCommandButton getBtnApprove() {
        return btnApprove;
    }

    public void setBtnApprove(HtmlCommandButton hcb) {
        this.btnApprove = hcb;
    }
    private HtmlSelectOneMenu drlCommittee = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommittee() {
        return drlCommittee;
    }

    public void setDrlCommittee(HtmlSelectOneMenu hsom) {
        this.drlCommittee = hsom;
    }
    private HtmlSelectOneMenu drlCommitteeType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommitteeType() {
        return drlCommitteeType;
    }

    public void setDrlCommitteeType(HtmlSelectOneMenu hsom) {
        this.drlCommitteeType = hsom;
    }
    private HtmlCommandButton btnResetApp = new HtmlCommandButton();

    public HtmlCommandButton getBtnResetApp() {
        return btnResetApp;
    }

    public void setBtnResetApp(HtmlCommandButton hcb) {
        this.btnResetApp = hcb;
    }

    public RecruitmentApprove() {
    }

    public DefaultSelectedData getSelectedRequestFromApprovableList() {
        return selectedRequestFromApprovableList;
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

    public void setSelectedRequestFromApprovableList(DefaultSelectedData selectedRequestFromApprovableList) {
        this.selectedRequestFromApprovableList = selectedRequestFromApprovableList;
    }
    private HtmlInputTextarea txtARemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtARemark() {
        return txtARemark;
    }

    public void setTxtARemark(HtmlInputTextarea hit) {
        this.txtARemark = hit;
    }
    private HtmlInputText txtRequester = new HtmlInputText();

    public HtmlInputText getTxtRequester() {
        return txtRequester;
    }

    public void setTxtRequester(HtmlInputText hit) {
        this.txtRequester = hit;
    }
    private HtmlInputText txtMinQualifcation = new HtmlInputText();

    public HtmlInputText getTxtMinQualifcation() {
        return txtMinQualifcation;
    }

    public void setTxtMinQualifcation(HtmlInputText hit) {
        this.txtMinQualifcation = hit;
    }
    private HtmlInputText txtMinExperiance = new HtmlInputText();

    public HtmlInputText getTxtMinExperiance() {
        return txtMinExperiance;
    }

    public void setTxtMinExperiance(HtmlInputText hit) {
        this.txtMinExperiance = hit;
    }
    private HtmlInputText txtMinResponsiblity = new HtmlInputText();

    public HtmlInputText getTxtMinResponsiblity() {
        return txtMinResponsiblity;
    }

    public void setTxtMinResponsiblity(HtmlInputText hit) {
        this.txtMinResponsiblity = hit;
    }
    private HtmlInputText txtAdditionalskill = new HtmlInputText();

    public HtmlInputText getTxtAdditionalskill() {
        return txtAdditionalskill;
    }

    public void setTxtAdditionalskill(HtmlInputText hit) {
        this.txtAdditionalskill = hit;
    }
    private HtmlInputText txtNumberOfEmployee = new HtmlInputText();

    public HtmlInputText getTxtNumberOfEmployee() {
        return txtNumberOfEmployee;
    }

    public void setTxtNumberOfEmployee(HtmlInputText hit) {
        this.txtNumberOfEmployee = hit;
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
    private HtmlOutputText txtConfirmation = new HtmlOutputText();

    public HtmlOutputText getTxtConfirmation() {
        return txtConfirmation;
    }

    public void setTxtConfirmation(HtmlOutputText hot) {
        this.txtConfirmation = hot;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private HtmlOutputText lblFullNameAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblFullNameAutoComplete() {
        return lblFullNameAutoComplete;
    }

    public void setLblFullNameAutoComplete(HtmlOutputText hot) {
        this.lblFullNameAutoComplete = hot;
    }
    private HtmlOutputText lblEmployeeIdAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeIdAutoComplete() {
        return lblEmployeeIdAutoComplete;
    }

    public void setLblEmployeeIdAutoComplete(HtmlOutputText hot) {
        this.lblEmployeeIdAutoComplete = hot;
    }

    private HtmlInputText txtApprovedNumberofEmployee = new HtmlInputText();

    public HtmlInputText getTxtApprovedNumberofEmployee() {
        return txtApprovedNumberofEmployee;
    }

    public void setTxtApprovedNumberofEmployee(HtmlInputText hit) {
        this.txtApprovedNumberofEmployee = hit;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private HtmlSelectOneMenu drlRecruitmentRequest = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRecruitmentRequest() {
        return drlRecruitmentRequest;
    }

    public void setDrlRecruitmentRequest(HtmlSelectOneMenu hsom) {
        this.drlRecruitmentRequest = hsom;
    }
    private HtmlInputText txtApprovedBy = new HtmlInputText();

    public HtmlInputText getTxtApprovedBy() {
        return txtApprovedBy;
    }

    public void setTxtApprovedBy(HtmlInputText hit) {
        this.txtApprovedBy = hit;
    }
    private HtmlInputText txtBachCode = new HtmlInputText();

    public HtmlInputText getTxtBachCode() {
        return txtBachCode;
    }

    public void setTxtBachCode(HtmlInputText hit) {
        this.txtBachCode = hit;
    }
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }


    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private PanelLayout lyApproved = new PanelLayout();

    public PanelLayout getLyApproved() {
        return lyApproved;
    }

    public void setLyApproved(PanelLayout pl) {
        this.lyApproved = pl;
    }
    private SelectInputText txtSearByName = new SelectInputText();

    public SelectInputText getTxtSearByName() {
        return txtSearByName;
    }

    public void setTxtSearByName(SelectInputText sit) {
        this.txtSearByName = sit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlOutputText lblErrorMessageRequired = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageRequired() {
        return lblErrorMessageRequired;
    }

    public void setLblErrorMessageRequired(HtmlOutputText hot) {
        this.lblErrorMessageRequired = hot;
    }
    private HtmlOutputText lblErrorMessageForEmployeeType = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForEmployeeType() {
        return lblErrorMessageForEmployeeType;
    }

    public void setLblErrorMessageForEmployeeType(HtmlOutputText hot) {
        this.lblErrorMessageForEmployeeType = hot;
    }
    private HtmlSelectOneMenu drlPreviousRequest = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPreviousRequest() {
        return drlPreviousRequest;
    }

    public void setDrlPreviousRequest(HtmlSelectOneMenu hsom) {
        this.drlPreviousRequest = hsom;
    }
    private PanelLayout message = new PanelLayout();

    public PanelLayout getMessage() {
        return message;
    }

    public void setMessage(PanelLayout pl) {
        this.message = pl;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
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
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }

    private HtmlOutputText lblStatusValue = new HtmlOutputText();

    public HtmlOutputText getLblStatusValue() {
        return lblStatusValue;
    }

    public void setLblStatusValue(HtmlOutputText hot) {
        this.lblStatusValue = hot;
    }

    public ArrayList<SelectItem> getCommitteeType() {
        return committeeType;
    }

    public void setCommitteeType(ArrayList<SelectItem> committeeType) {
        this.committeeType = committeeType;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public void txtNumberOfEmployee_validate(FacesContext context, UIComponent component, Object value) {
        this.validateNumber(context, component, value);
    }

    public void txtApprovedNumberofEmployee_validate(FacesContext context, UIComponent component, Object value) {
        this.validateNumber(context, component, value);
    }

    public String cmdRecruitment_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdRecruitmentApproval_action() {
        //return null means stay on the same page
        return "ApprovedRecruitmentList";
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
        return "VacantSpaces";
    }
    // </editor-fold>
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {

        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        userName = getSessionBean1().getUserName();
       
        populateApproverTextComponents(loggedInEmployeeId);
        recruitmentApproveManager.setUserName(userName);
        recruitmentApproveManager.setUserName(userName);
        requestListsToBeApproved = recruitmentApproveManager.getRequestsToBeProcessed();
        requestHistoryList = recruitmentApproveManager.getMyDecisionsOnRequests();

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
        this.componetDisable();
        
        txtConfirmation.setRendered(true);
        txtConfirmation.setValue("To day   " + StringDateManipulation.toDayInEc());
        txtApprovedBy.setValue(getSessionBean1().getEmployeeName());
        btnPostDecision.setRendered(true);
        btnResetApp.setRendered(true);
        super.init();

//        String empId = "001";
//        this.getSessionBean1().setEmployee_id(empId);
//        employeeManage.loadEmpoyeeProfile(empId);
//        String employeeName = employeeManage.getFirst_Name() + "   " + employeeManage.getMiddle_Name() + "   " + employeeManage.getLast_Name();

//        txtRequester.setValue(this.getSessionBean1().getEmployeeName());

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
        this.getRecruitmentList();
        btnResetApp.setDisabled(false);
        txtNumberOfEmployee.setRequired(true);
        txtNumberOfEmployee.setRequiredMessage("Requred");
//        drlEmployeeMentType.setRequired(true);
//        drlEmployeeMentType.setRequiredMessage("Requred");
//        txtConfirmation.setRendered(false);
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
    public void addRecruitmentRequest() {
        String employeeid = this.getSessionBean1().getEmployeeId();
        if (getApplicationBean1().getSelectedEmployeeId() != null) {
            employeeid = getApplicationBean1().getSelectedEmployeeId();
        }
        RecruitmentManager recruitmentRequest = new RecruitmentManager(employeeid, StringDateManipulation.toDayInEc(), txtRequiredJobType.getValue().toString(), txtNumberOfEmployee.getValue().toString(), txtEmployeeMentType.getValue().toString(), txtARemark.getValue().toString());
        if (recruitmentManager.saveRequirementRequest(recruitmentRequest) == 1) {
            lblFormMessage.setStyleClass("success");
            lblFormMessage.setValue("Recruitment  Request Is Successfully Requested.And Need To Be Viewed By  Authorized Person ");
            showConformationMsg(getMessage().getStyleClass().toString());
//            txtConfirmation.setRendered(true);
//            txtConfirmation.setValue("Recruitment  Request Is Successfully Requested.And Need To Be Viewed By  Authorized Person ");
            this.componetDisable();
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(false);
            btnSave.setValue("New");
        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Error Occured While Posting Recruitment Request.Please Try Again?");
            showConformationMsg(getMessage().getStyleClass().toString());


//            txtConfirmation.setRendered(true);
//            txtConfirmation.setValue("Error Occured While Posting Recruitment Request.Please Try Again? ");
        }
    }

    public void btnSave_processAction(ActionEvent ae) {

        txtConfirmation.setRendered(false);
        if (btnSave.getValue().equals("New")) {
            this.cleareComponets();
            btnSave.setValue("Save");
            this.componetEnable();
        } else if (btnSave.getValue().equals("Save")) {
            if (!txtRequiredJobType.getValue().equals("0")) {
                if (!txtEmployeeMentType.getValue().equals("---- Recuitment Type ----")) {
                    this.addRecruitmentRequest();
                } else {
                    lblErrorMessageForEmployeeType.setRendered(true);
                    lblErrorMessageForEmployeeType.setValue("Requred");
                }
            } else {
                lblErrorMessageRequired.setRendered(true);
                lblErrorMessageRequired.setValue("Requred");
            }

        }

    }

    public void inputFile1_processAction(ActionEvent ae) {
    }

    public void txtRequiredJobType_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageRequired.setRendered(false);
        txtConfirmation.setRendered(false);
        ArrayList<String> jobdetil = departmentManage.selectJobdetail(vce.getNewValue().toString());
        if (jobdetil != null) {
            try {
                txtMinQualifcation.setValue(jobdetil.get(2));
                txtMinExperiance.setValue(jobdetil.get(3));
                txtMinResponsiblity.setValue(jobdetil.get(4));
                txtAdditionalskill.setValue(jobdetil.get(5));
            } catch (Exception ex) {
                ex.printStackTrace();
            // //(null, "error on dipsplay jobtype" + ex.getMessage());
            }
        } else {
        }
    }

    private void componetDisable() {
        txtARemark.setDisabled(true);
        txtNumberOfEmployee.setDisabled(true);
        txtRequiredJobType.setDisabled(true);
        txtEmployeeMentType.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(true);
        btnPostDecision.setDisabled(true);
        btnResetApp.setDisabled(true);
        txtApprovedBy.setDisabled(true);
        txtBachCode.setDisabled(true);
        txtApprovedNumberofEmployee.setDisabled(true);


    }

    private void componetEnable() {
        txtARemark.setDisabled(false);
        txtNumberOfEmployee.setDisabled(false);
        txtRequiredJobType.setDisabled(false);
        txtEmployeeMentType.setDisabled(false);
        btnReset.setDisabled(false);

    }

    public void page_display_processMyEvent(DragEvent de) {
    }

//    public void btnPostDecision_processAction(ActionEvent ae) {
//
//        RecruitmentManager approved = new RecruitmentManager(txtBachCode.getValue().toString(), this.getSessionBean1().getEmployeeId(), StringDateManipulation.toDayInEc(), txtNumberOfEmployee.getValue().toString(), requesterId, 1);
//
//        if (recruitmentManager.approvedRecruitmentRequests(approved) == 1) {
//            lblFormMessage.setStyleClass("success");
//            lblFormMessage.setValue("Recruitment  Request Successfully Approved ");
//            showConformationMsg(getMessage().getStyleClass().toString());
//
//            txtBachCode.setDisabled(true);
//            txtApprovedNumberofEmployee.setDisabled(true);
//            btnReject.setDisabled(true);
//            btnPostDecision.setDisabled(true);
//
//        } else {
//            lblFormMessage.setStyleClass("error");
//            lblFormMessage.setValue("Error occured while Approve Recruitment Request. Please try again? ");
//            showConformationMsg(getMessage().getStyleClass().toString());
//        }
//    }


    private void cleareComponets() {

        txtMinQualifcation.setValue("");
        txtAdditionalskill.setValue("");
        txtARemark.setValue("");
        txtMinExperiance.setValue("");
        txtMinResponsiblity.setValue("");
        txtNumberOfEmployee.setValue("");
        txtRequiredJobType.setValue("");
        txtEmployeeMentType.setValue("");
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(true);
        lblStatusValue.setValue("");

    }

    public void btnReset_processAction(ActionEvent ae) {
        txtConfirmation.setRendered(false);
        this.cleareComponets();
        componetDisable();
        btnSave.setValue("New");
        btnUpdate.setValue("Edit");


//        txtRequester.setValue("");
    }

    public void drlRecruitmentRequest_processValueChange(ValueChangeEvent vce) {
        ArrayList<String> unApprovedRequest = recruitmentManager.readRecuitmentRequest(vce.getNewValue().toString());
        if (unApprovedRequest != null) {
            String employeeName = unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7);
            txtRequester.setValue(employeeName);
            txtMinQualifcation.setValue(unApprovedRequest.get(9));
            txtAdditionalskill.setValue(unApprovedRequest.get(12));
            txtARemark.setValue(unApprovedRequest.get(14));
            txtMinExperiance.setValue(unApprovedRequest.get(10));
            txtMinResponsiblity.setValue(unApprovedRequest.get(11));
            txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
            txtEmployeeMentType.setValue(unApprovedRequest.get(2));
            txtRequiredJobType.setValue(unApprovedRequest.get(13));
            txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));


        } else {
            // //(null, "unknown");
        }
    }





    public String btnApproved_action() {
        //return null means stay on the same page
        return null;
    }

    public void drlPreviousRequest_processValueChange(ValueChangeEvent vce) {
        txtConfirmation.setRendered(false);
        try {
            if (!drlPreviousRequest.getValue().equals("Previous")) {
                ArrayList<String> unApprovedRequest = recruitmentManager.readRecruitmentRequest(vce.getNewValue().toString());

                txtRequester.setValue(unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7));
                txtMinQualifcation.setValue(unApprovedRequest.get(9));
                txtAdditionalskill.setValue(unApprovedRequest.get(12));
                txtARemark.setValue(unApprovedRequest.get(14));
                txtMinExperiance.setValue(unApprovedRequest.get(10));
                txtMinResponsiblity.setValue(unApprovedRequest.get(11));
                txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
                txtEmployeeMentType.setValue(unApprovedRequest.get(2));
                txtRequiredJobType.setValue(unApprovedRequest.get(13));
                txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));
                requesterId = unApprovedRequest.get(0);


                txtBachCode.setDisabled(false);
                txtApprovedNumberofEmployee.setDisabled(false);
                btnUpdate.setDisabled(false);
                btnDelete.setDisabled(false);
            } else {
                cleareComponets();
            }
        } catch (Exception ex) {
            txtConfirmation.setRendered(true);
            txtConfirmation.setValue("Error on loade previous request ");


        }
    }


    private void validateNumber(FacesContext context, UIComponent component, Object value) {
        try {
            String patternNumber = "^\\d+$";
            boolean matchStringText = Pattern.matches(patternNumber, (CharSequence) (value.toString()));
            if (matchStringText == false) {
                messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
                ((UIInput) component).setValid(false);
                error(component, messageResource.getString("salaryValidate"));
            }
        } catch (Exception ex) {
        }
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    /**
     *
     * @param vce
     */
    public void selectOneListbox1RGiven_processValueChange(ValueChangeEvent vce) {
        txtConfirmation.setRendered(false);
        cleareComponets();
        btnPostDecision.setDisabled(true);
        btnResetApp.setDisabled(true);
        txtApprovedNumberofEmployee.setDisabled(true);
        ArrayList<String> unApprovedRequest = recruitmentManager.readRecuitmentRequest(vce.getNewValue().toString());
        try {
            if (unApprovedRequest != null) {
                txtRequester.setValue(unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7));
                txtMinQualifcation.setValue(unApprovedRequest.get(9));
                txtAdditionalskill.setValue(unApprovedRequest.get(12));
                txtARemark.setValue(unApprovedRequest.get(14));
                txtMinExperiance.setValue(unApprovedRequest.get(10));
                txtMinResponsiblity.setValue(unApprovedRequest.get(11));
                txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
                txtEmployeeMentType.setValue(unApprovedRequest.get(2));
                txtRequiredJobType.setValue(unApprovedRequest.get(13));
                txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));
                requesterId = unApprovedRequest.get(0);
                this.lblStatusValue.setValue(unApprovedRequest.get(15));
                btnUpdate.setDisabled(true);
                btnUpdate.setDisabled(true);
                txtBachCode.setDisabled(false);
//                txtApprovedNumberofEmployee.setDisabled(false);
            } else {
                //  //(null, "unknown");
            }
        } catch (Exception ex) {
            ////(null, "error on" + ex.getMessage());
        }
    }

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(RecruitmentApproveManager.RECRUITMENT_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(RecruitmentApproveManager.RECRUITMENT_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (requesterId.equals("")) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE REQUEST TO DECIDE");
            return false;
        }
        return true;
    }

    private boolean validateDecisionAprove() {
        if (drlDecision.getValue().toString().equals(RecruitmentApproveManager.RECRUITMENT_DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(RecruitmentApproveManager.RECRUITMENT_DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (requesterId.equals("")) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE REQUEST TO DECIDE");
            return false;
        }
        return true;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
//        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setAutoCentre(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
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
                txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtDeciderFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                txtDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }

        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }

    public String btnSearchDecider_action() {
        if (btnSearchDecider.getValue().toString().equals("Change")) {
            btnSearchDecider.setValue("Search");
            txtDeciderId.setDisabled(false);
        } else {
            if (txtDeciderId.getValue() != null && !txtDeciderId.getValue().toString().equals("")) {
                populateApproverTextComponents(txtDeciderId.getValue().toString());
                btnSearchDecider.setValue("Change");
                txtDeciderId.setDisabled(true);
            }
        }
        return null;
    }

    public void selectRequestApprovableRequestLists_processValueChange(ValueChangeEvent vce) {
        btnResetApp.setDisabled(false);
        String[] requestInfos = vce.getNewValue().toString().split("--");
        recruitmentRequestId = Integer.parseInt(requestInfos[0]);
        String requesterId = requestInfos[0];
        requesterId = requestInfos[0];
        requestStatus = requestInfos[2];
//        populateRequesterTextComponents(requesterId);
        populateRecruitmentRequestTextComponents(requesterId);
//        populateEmployeesListToTable(overTimeRequestId);
        drlDecision.resetValue();
        availableDecisionsToMakeList = recruitmentApproveManager.getAvailableDecisionsToMake(requestStatus);
//        makePageReadyForSave();
//         decisionsMadeOnRequest = terminationApproveManager.getRequestHistory(terminationRequestId);
    }

    private boolean populateRecruitmentRequestTextComponents(String recruitmentRequestId) {

        txtConfirmation.setRendered(false);
        cleareComponets();
        btnPostDecision.setDisabled(false);
        btnResetApp.setDisabled(false);


        ArrayList<String> unApprovedRequest = recruitmentManager.readRecuitmentRequest(recruitmentRequestId);
        try {
            if (unApprovedRequest != null) {


                try {
HashMap recruitRequestList = departmentManage.selectJobDetaille(unApprovedRequest.get(13));
                    txtMinQualifcation.setValue(recruitRequestList.get("MIN_REQUIRED_QUALIFICATION").toString());
                    txtMinExperiance.setValue(recruitRequestList.get("MIN_EXPERIENCE").toString());
                    txtMinResponsiblity.setValue(recruitRequestList.get("MIN_RESPONSIBILITY").toString());
                    txtAdditionalskill.setValue(recruitRequestList.get("ADDITIONALSKILL").toString());
                    txtRequiredJobType.setValue(recruitRequestList.get("JOB_DESCRIPTION").toString());
//                    txtRunk.setValue(recruitRequestList.get("RANK_ID").toString());

                } catch (Exception ex) {
                    ex.printStackTrace();

                }

                txtRequester.setValue(unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7));

                txtARemark.setValue(unApprovedRequest.get(14));
//                txtMinExperiance.setValue(unApprovedRequest.get(10));
//                txtMinResponsiblity.setValue(unApprovedRequest.get(11));
                txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
                txtEmployeeMentType.setValue(unApprovedRequest.get(2));
//                txtRequiredJobType.setValue(unApprovedRequest.get(13)+"  "+unApprovedRequest.get(8));
                txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));
                requesterId = unApprovedRequest.get(0);
                btnUpdate.setDisabled(true);
                btnUpdate.setDisabled(true);
                txtBachCode.setDisabled(false);
                txtApprovedNumberofEmployee.setDisabled(false);
                btnResetApp.setDisabled(false);
                btnPostDecision.setDisabled(false);
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


        return false;
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        String[] requestInfos = vce.getNewValue().toString().split("--");
        String requstid = requestInfos[0];
        recruitmentRequestId = Integer.parseInt(requestInfos[0]);
        requesterId = requestInfos[1];
        requestStatus = requestInfos[2];
        populateRecruitmentRequestTextComponents(requstid);
        makePageReadyForView();



    }

    private void makePageReadyForView() {
        btnPostDecision.setDisabled(true);
        drlDecision.setDisabled(true);
    }

    private void clearDecision() {
        drlDecision.resetValue();
        txtaDeciderComment.setValue(null);
    }

    private void clearAllComponents() {
//        clearRequesterTextComponents();
//        clearRequestComponents();
//        clearRequestDataTable();
        populateApproverTextComponents(loggedInEmployeeId);
        clearDecision();
    }

    public boolean saveRecruitmentDecision() {
        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
        return recruitmentApproveManager.saveRecruitmentDecision(recruitmentRequestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment);
    }

    public String btnPostDecision_action() {
        if (drlDecision.getValue().toString().equals(RecruitmentApproveManager.RECRUITMENT_DECISION_APPROVE)) {
          if (validateDecisionAprove()) {
                pnlPopupApprove.setRendered(true);
            }
        }

        else if (validateDecision()) {
            if (saveRecruitmentDecision()) {
                clearAllComponents();
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                requestListsToBeApproved = recruitmentApproveManager.getRequestsToBeProcessed();
                requestHistoryList = recruitmentApproveManager.getMyDecisionsOnRequests();
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        return null;
    }

    public void drlCommittee_processValueChange(ValueChangeEvent vce) {
        committeeId = Integer.parseInt(vce.getNewValue().toString());

        if (committeeId != -1) {
            committeeMemberLists = committeeMemberRegistrationManager.getAllCommitteeMembers(committeeId);
        } else {
            committeeMemberLists = new ArrayList<CommitteeMemberModel>();
        }
    }

    public String btnAddCommittee_action() {
        return "CommitteeRegistration";
    }

    public void drlCommitteeType_processValueChange(ValueChangeEvent vce) {
        if (!vce.getNewValue().toString().equals("-1")) {
            drlCommittee.setDisabled(false);
            committeeList = committeeRegistrationManager.getAllActiveCommitteesSelectItem();
        } else {
             drlCommittee.setDisabled(true);
        }
    }
    //==========================================================================================================

    public String btnReset_action() {
        clearAllComponents();
        return null;
    }
    //==========================================================================================================

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    private void populateDecisionHistory(int recruitmetRequestId) {
        decisionsMadeOnRequest = recruitmentApproveManager.getRequestHistory(recruitmetRequestId);
        if (decisionsMadeOnRequest.size() > 0) {
            lnkViewPrevieousDecisions.setRendered(true);
        } else {
            lnkViewPrevieousDecisions.setRendered(true);
        // makePageReadyForUpdate();
        }
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(recruitmentRequestId);
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public void drlDecision_processValueChange(ValueChangeEvent vce) {
      if (drlDecision.getValue().toString().equals(RecruitmentApproveManager.RECRUITMENT_DECISION_APPROVE)) {
          pnlLayoutCommitteeMember.setRendered(true);
        }
      else{
          pnlLayoutCommitteeMember.setRendered(false);
      }
    }

    public void btnPostDecision_processAction(ActionEvent ae) {
        
    }

    public String btnApprove_action() {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        RecruitmentManager approved = new RecruitmentManager(txtBachCode.getValue().toString(), this.getSessionBean1().getEmployeeId(),recorededDateAndTime, txtNumberOfEmployee.getValue().toString(), requesterId, committeeId);
         if (recruitmentManager.approvedRecruitmentRequests(approved) == 1) {
             if (saveRecruitmentDecision()) {
                    clearAllComponents();
                    showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                    requestListsToBeApproved = recruitmentApproveManager.getRequestsToBeProcessed();
                } else {
                    showSuccessOrFailureMessage(false, "SAVING FAILED");
                }


        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Error occured while Approve Recruitment Request. Please try again? ");
            showConformationMsg(getMessage().getStyleClass().toString());
        }
        //return null means stay on the same page
        return null;
    }

    public String btnClosePop_action() {
        pnlPopupApprove.setRendered(false);
        return null;
    }



    public String btnResetApp_action() {
        cleareComponets();
        return null;
    }




//==========================================================================================================
}

