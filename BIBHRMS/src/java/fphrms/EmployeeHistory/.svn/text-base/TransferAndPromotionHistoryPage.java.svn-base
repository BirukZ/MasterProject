/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.employeeManager.EmployeeManage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.event.ActionEvent;

import javax.swing.tree.DefaultTreeModel;
import manager.employeeHistoryManager.TransferAndPromotionHistoryManager;
import manager.employeeHistoryManager.TransferAndPromotionHistoryModel;
import manager.organizationManager.JobTypeManager;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TransferAndPromotionHistoryPage extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

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

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public ArrayList<SelectItem> getJobPositionList() {
        return jobPositionList;
    }

    public void setJobPositionList(ArrayList<SelectItem> jobPositionList) {
        this.jobPositionList = jobPositionList;
    }

    public ArrayList<SelectItem> getRankList() {
        return rankList;
    }

    public void setRankList(ArrayList<SelectItem> rankList) {
        this.rankList = rankList;
    }

    public ArrayList<SelectItem> getRequesterDepartmentList() {
        return requesterDepartmentList;
    }

    public void setRequesterDepartmentList(ArrayList<SelectItem> requesterDepartmentList) {
        this.requesterDepartmentList = requesterDepartmentList;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
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
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText sit) {
        this.txtRequesterFullName = sit;
    }
    private HtmlInputText txtRequestingDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequestingDepartment() {
        return txtRequestingDepartment;
    }

    public void setTxtRequestingDepartment(HtmlInputText txtRequestingDepartment) {
        this.txtRequestingDepartment = txtRequestingDepartment;
    }
    private HtmlInputText txtRequesterDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment() {
        return txtRequesterDepartment;
    }

    public void setTxtRequesterDepartment(HtmlInputText hit) {
        this.txtRequesterDepartment = hit;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private HtmlInputText txtRequestLetterNumber = new HtmlInputText();

    public HtmlInputText getTxtRequestLetterNumber() {
        return txtRequestLetterNumber;
    }

    public void setTxtRequestLetterNumber(HtmlInputText hit) {
        this.txtRequestLetterNumber = hit;
    }
    private HtmlInputText txtRequestLetterDate = new HtmlInputText();

    public HtmlInputText getTxtRequestLetterDate() {
        return txtRequestLetterDate;
    }

    public void setTxtRequestLetterDate(HtmlInputText hit) {
        this.txtRequestLetterDate = hit;
    }
    private HtmlInputText txtPreviousSalary = new HtmlInputText();

    public HtmlInputText getTxtPreviousSalary() {
        return txtPreviousSalary;
    }

    public void setTxtPreviousSalary(HtmlInputText hit) {
        this.txtPreviousSalary = hit;
    }
    private HtmlInputText txtNewSalary = new HtmlInputText();

    public HtmlInputText getTxtNewSalary() {
        return txtNewSalary;
    }

    public void setTxtNewSalary(HtmlInputText hit) {
        this.txtNewSalary = hit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private HtmlSelectOneMenu drlRequesterDepartment = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRequesterDepartment() {
        return drlRequesterDepartment;
    }

    public void setDrlRequesterDepartment(HtmlSelectOneMenu hsom) {
        this.drlRequesterDepartment = hsom;
    }
    private HtmlSelectOneMenu drlPrevJobType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPrevJobType() {
        return drlPrevJobType;
    }

    public void setDrlPrevJobType(HtmlSelectOneMenu hsom) {
        this.drlPrevJobType = hsom;
    }
    private HtmlSelectOneMenu drlNewJobType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNewJobType() {
        return drlNewJobType;
    }

    public void setDrlNewJobType(HtmlSelectOneMenu hsom) {
        this.drlNewJobType = hsom;
    }
    private HtmlSelectOneMenu drlPromotionType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPromotionType() {
        return drlPromotionType;
    }

    public void setDrlPromotionType(HtmlSelectOneMenu hsom) {
        this.drlPromotionType = hsom;
    }
    private HtmlSelectOneMenu drlPreviousRank = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPreviousRank() {
        return drlPreviousRank;
    }

    public void setDrlPreviousRank(HtmlSelectOneMenu hsom) {
        this.drlPreviousRank = hsom;
    }
    private HtmlSelectOneMenu drlNewRank = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNewRank() {
        return drlNewRank;
    }

    public void setDrlNewRank(HtmlSelectOneMenu hsom) {
        this.drlNewRank = hsom;
    }
    private HtmlInputText txtRequestDate = new HtmlInputText();

    public HtmlInputText getTxtRequestDate() {
        return txtRequestDate;
    }

    public void setTxtRequestDate(HtmlInputText hit) {
        this.txtRequestDate = hit;
    }
    private HtmlInputText txtPromotionDate = new HtmlInputText();

    public HtmlInputText getTxtPromotionDate() {
        return txtPromotionDate;
    }

    public void setTxtPromotionDate(HtmlInputText hit) {
        this.txtPromotionDate = hit;
    }
    private HtmlInputText txtPromotionLetterNumber = new HtmlInputText();

    public HtmlInputText getTxtPromotionLetterNumber() {
        return txtPromotionLetterNumber;
    }

    public void setTxtPromotionLetterNumber(HtmlInputText hit) {
        this.txtPromotionLetterNumber = hit;
    }
    private HtmlInputText txtPrevSalary = new HtmlInputText();

    public HtmlInputText getTxtPrevSalary() {
        return txtPrevSalary;
    }

    public void setTxtPrevSalary(HtmlInputText hit) {
        this.txtPrevSalary = hit;
    }
    private HtmlInputText txtAdvertisnmentNumber = new HtmlInputText();

    public HtmlInputText getTxtAdvertisnmentNumber() {
        return txtAdvertisnmentNumber;
    }

    public void setTxtAdvertisnmentNumber(HtmlInputText hit) {
        this.txtAdvertisnmentNumber = hit;
    }
    private HtmlInputTextarea txtaReason = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaReason() {
        return txtaReason;
    }

    public void setTxtaReason(HtmlInputTextarea hit) {
        this.txtaReason = hit;
    }
    private HtmlInputText txtCompletedDate = new HtmlInputText();

    public HtmlInputText getTxtCompletedDate() {
        return txtCompletedDate;
    }

    public void setTxtCompletedDate(HtmlInputText hit) {
        this.txtCompletedDate = hit;
    }
    private SelectInputDateBean selectInputDateBean3 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean3() {
        return selectInputDateBean3;
    }

    public void setSelectInputDateBean3(SelectInputDateBean sidb) {
        this.selectInputDateBean3 = sidb;
    }
    private SelectInputDate calCompletedDate = new SelectInputDate();

    public SelectInputDate getCalCompletedDate() {
        return calCompletedDate;
    }

    public void setCalCompletedDate(SelectInputDate sid) {
        this.calCompletedDate = sid;
    }
    private SelectInputDate calDateSelector = new SelectInputDate();

    public SelectInputDate getCalDateSelector() {
        return calDateSelector;
    }

    public void setCalDateSelector(SelectInputDate sid) {
        this.calDateSelector = sid;
    }
    // </editor-fold>
    JobTypeManager jobTypeManager = new JobTypeManager();
    private SelectInputDateBean selectInputDateBean4 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean4() {
        return selectInputDateBean4;
    }

    public void setSelectInputDateBean4(SelectInputDateBean sidb) {
        this.selectInputDateBean4 = sidb;
    }
    private SelectInputDateBean selectInputDateBean5 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean5() {
        return selectInputDateBean5;
    }

    public void setSelectInputDateBean5(SelectInputDateBean sidb) {
        this.selectInputDateBean5 = sidb;
    }
    private SelectInputDate calCompletedDates = new SelectInputDate();

    public SelectInputDate getCalCompletedDates() {
        return calCompletedDates;
    }

    public void setCalCompletedDates(SelectInputDate sid) {
        this.calCompletedDates = sid;
    }
    private SelectInputDate calPromotionDate = new SelectInputDate();

    public SelectInputDate getCalPromotionDate() {
        return calPromotionDate;
    }

    public void setCalPromotionDate(SelectInputDate sid) {
        this.calPromotionDate = sid;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TransferAndPromotionHistoryPage() {
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

    public String lnkConfirm_action() {
        return null;
    }

    public String getNewOrEditOrUpdateLabel() {
        return newOrEditOrUpdateLabel;
    }

    public void setNewOrEditOrUpdateLabel(String newOrEditOrUpdateLabel) {
        this.newOrEditOrUpdateLabel = newOrEditOrUpdateLabel;
    }

    public ArrayList<SelectItem> getPendingRequestList() {
        return pendingRequestList;
    }

    public void setPendingRequestList(ArrayList<SelectItem> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public ArrayList<TransferAndPromotionHistoryModel> getTransferAndPromotionHistoryList() {
        return transferAndPromotionHistoryList;
    }

    public void setTransferAndPromotionHistoryList(ArrayList<TransferAndPromotionHistoryModel> transferAndPromotionHistoryList) {
        this.transferAndPromotionHistoryList = transferAndPromotionHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromMyRequestList() {
        return selectedRequestFromMyRequestList;
    }

    public void setSelectedRequestFromMyRequestList(DefaultSelectedData selectedRequestFromMyRequestList) {
        this.selectedRequestFromMyRequestList = selectedRequestFromMyRequestList;
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

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public ArrayList<SelectItem> getPromotionTypeList() {
        return promotionTypeList;
    }

    public void setPromotionTypeList(ArrayList<SelectItem> promotionTypeList) {
        this.promotionTypeList = promotionTypeList;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public String getRequesterId() {
        return employeeId;
    }

    public void setRequesterId(String requesterId) {
        this.employeeId = requesterId;
    }

    public String getAdvertisenmentNumber() {
        return advertisenmentNumber;
    }

    public void setAdvertisenmentNumber(String advertisenmentNumber) {
        this.advertisenmentNumber = advertisenmentNumber;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getNewJobPosition() {
        return newJobPosition;
    }

    public void setNewJobPosition(String newJobPosition) {
        this.newJobPosition = newJobPosition;
    }

    public String getNewRank() {
        return newRank;
    }

    public void setNewRank(String newRank) {
        this.newRank = newRank;
    }

    public String getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(String newSalary) {
        this.newSalary = newSalary;
    }

    public Tree getOrganizationTree() {
        return organizationTree;
    }

    public void setOrganizationTree(Tree organizationTree) {
        this.organizationTree = organizationTree;
    }

    public PanelLayout getPnlLayoutTree() {
        return pnlLayoutTree;
    }

    public void setPnlLayoutTree(PanelLayout pnlLayoutTree) {
        this.pnlLayoutTree = pnlLayoutTree;
    }

    public String getPreviousJobPosition() {
        return previousJobPosition;
    }

    public void setPreviousJobPosition(String previousJobPosition) {
        this.previousJobPosition = previousJobPosition;
    }

    public String getPreviousRank() {
        return previousRank;
    }

    public void setPreviousRank(String previousRank) {
        this.previousRank = previousRank;
    }

    public String getPreviousSalary() {
        return previousSalary;
    }

    public void setPreviousSalary(String previousSalary) {
        this.previousSalary = previousSalary;
    }

    public String getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(String promotionDate) {
        this.promotionDate = promotionDate;
    }

    public String getPromotionLetterNumber() {
        return promotionLetterNumber;
    }

    public void setPromotionLetterNumber(String promotionLetterNumber) {
        this.promotionLetterNumber = promotionLetterNumber;
    }

    public String getPromotionRequestDate() {
        return promotionRequestDate;
    }

    public void setPromotionRequestDate(String promotionRequestDate) {
        this.promotionRequestDate = promotionRequestDate;
    }

    public String getPromotionRequestLetterNumber() {
        return promotionRequestLetterNumber;
    }

    public void setPromotionRequestLetterNumber(String promotionRequestLetterNumber) {
        this.promotionRequestLetterNumber = promotionRequestLetterNumber;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(String requesterDepartment) {
        this.requesterDepartment = requesterDepartment;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public TransferAndPromotionHistoryModel getTransferAndPromotionHistoryModel() {
        return transferAndPromotionHistoryModel;
    }

    public void setTransferAndPromotionHistoryModel(TransferAndPromotionHistoryModel transferAndPromotionHistoryModel) {
        this.transferAndPromotionHistoryModel = transferAndPromotionHistoryModel;
    }

    public TransferAndPromotionHistoryManager getTransferAndpromotionHistoryManager() {
        return transferAndpromotionHistoryManager;
    }

    public void setTransferAndpromotionHistoryManager(TransferAndPromotionHistoryManager transferAndpromotionHistoryManager) {
        this.transferAndpromotionHistoryManager = transferAndpromotionHistoryManager;
    }

    public DefaultSelectedData getSelectedObjectOfNewJobTypeList() {
        return selectedObjectOfNewJobTypeList;
    }

    public void setSelectedObjectOfNewJobTypeList(DefaultSelectedData selectedObjectOfNewJobTypeList) {
        this.selectedObjectOfNewJobTypeList = selectedObjectOfNewJobTypeList;
    }

    public DefaultSelectedData getSelectedObjectOfNewRankList() {
        return selectedObjectOfNewRankList;
    }

    public void setSelectedObjectOfNewRankList(DefaultSelectedData selectedObjectOfNewRankList) {
        this.selectedObjectOfNewRankList = selectedObjectOfNewRankList;
    }

    public DefaultSelectedData getSelectedObjectOfPrevJobTypeList() {
        return selectedObjectOfPrevJobTypeList;
    }

    public void setSelectedObjectOfPrevJobTypeList(DefaultSelectedData selectedObjectOfPrevJobTypeList) {
        this.selectedObjectOfPrevJobTypeList = selectedObjectOfPrevJobTypeList;
    }

    public DefaultSelectedData getSelectedObjectOfPreviousRankList() {
        return selectedObjectOfPreviousRankList;
    }

    public void setSelectedObjectOfPreviousRankList(DefaultSelectedData selectedObjectOfPreviousRankList) {
        this.selectedObjectOfPreviousRankList = selectedObjectOfPreviousRankList;
    }

    public DefaultSelectedData getSelectedObjectOfPromotionTypeList() {
        return selectedObjectOfPromotionTypeList;
    }

    public void setSelectedObjectOfPromotionTypeList(DefaultSelectedData selectedObjectOfPromotionTypeList) {
        this.selectedObjectOfPromotionTypeList = selectedObjectOfPromotionTypeList;
    }

    public DefaultTree getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTree treeModel) {
        this.treeModel = treeModel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public HtmlOutputText getOutputTextConfirmDelete() {
        return outputTextConfirmDelete;
    }

    public void setOutputTextConfirmDelete(HtmlOutputText outputTextConfirmDelete) {
        this.outputTextConfirmDelete = outputTextConfirmDelete;
    }

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pnlPopupConfirmDelete) {
        this.pnlPopupConfirmDelete = pnlPopupConfirmDelete;
    }
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
//         if (requestManager.deleteSalaryDelegationRequest(salaryDelegationRequestId)) {
        if (true) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponenets();
            pendingRequestList = null;// requestManager.getPendingRequests();
        } else {
            showSuccessOrFailureMessage(false, "CAN NOT DELETE THE REQUEST\n PLEASE TRY AGAIN");
        }
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }

    public String btnPopupCancelDelete_action() {
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }

    public String btnCalRequestedDate_action() {
        calDateSelector.setRendered(true);
        return null;
    }

    public void calDateSelector_processValueChange(ValueChangeEvent vce) {
        txtRequestDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calDateSelector.setRendered(false);
    }

    public String btnCalCompletedDate_action() {
        calCompletedDates.setRendered(true);
        return null;
    }

    public String btnCalPromotionDate_action() {
        calPromotionDate.setRendered(true);
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    private void clearAllComponenets() {
        clearRequesterTextComponents();
        clearHistoryAttributes();
        transferAndPromotionHistoryList = new ArrayList<TransferAndPromotionHistoryModel>();
        selectedRow = -1;
        employeeId = null;
        transferAndPromotionId = -1;

    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void clearHistoryAttributes() {

        /*drlPrevJobType.setValue(null);
        drlNewJobType.setValue(null);
        drlPreviousRank.setValue(null);
        drlNewRank.setValue(null);*/
        selectedObjectOfPrevJobTypeList.setSelectedObject(null);
        selectedObjectOfNewJobTypeList.setSelectedObject(null);
        selectedObjectOfPromotionTypeList.setSelectedObject(null);
        selectedObjectOfPreviousRankList.setSelectedObject(null);
        selectedObjectOfNewRankList.setSelectedObject(null);

        txtPrevSalary.setValue(null);
        txtNewSalary.setValue(null);
        txtaReason.setValue(null);
        drlPromotionType.setValue(null);
        txtRequestDate.setValue(null);
        txtPromotionLetterNumber.setValue("00000");
        txtPromotionDate.setValue(null);
        txtCompletedDate.setValue("1900-01-01");
        txtPromotionLetterNumber.setValue("00000");
        txtAdvertisnmentNumber.setValue("00000");
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        employeeId = ApplicationBean1.getSelectedEmployeeId();
        if (populateRequesterTextComponents(employeeId)) {
            transferAndPromotionHistoryList = transferAndpromotionHistoryManager.getTransferAndPromotionHistory(employeeId);
        }
        return null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
            employeeId = txtRequesterId.getValue().toString();
            if (populateRequesterTextComponents(employeeId)) {
                transferAndPromotionHistoryList = transferAndpromotionHistoryManager.getTransferAndPromotionHistory(employeeId);
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtRequesterId.getValue().toString());
                employeeId = null;
            }
        } else {
            employeeId = null;
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
        return null;
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                this.employeeId = null;
                return false;
            } else {
                this.employeeId = employeeId;
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(this.employeeId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            this.employeeId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setAutoCentre(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
    // </editor-fold>
    // </editor-fold >
    private DefaultSelectedData selectedObjectOfPrevJobTypeList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOfNewJobTypeList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOfPromotionTypeList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOfPreviousRankList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOfNewRankList = new DefaultSelectedData();
    // </editor-fold >
    EmployeeManage employeeManager = new EmployeeManage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    TransferAndPromotionHistoryModel transferAndPromotionHistoryModel = new TransferAndPromotionHistoryModel();
    TransferAndPromotionHistoryManager transferAndpromotionHistoryManager = new TransferAndPromotionHistoryManager();
    ArrayList<TransferAndPromotionHistoryModel> transferAndPromotionHistoryList = new ArrayList<TransferAndPromotionHistoryModel>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requesterDepartmentList = transferAndpromotionHistoryManager.getAllDepartments();//  new ArrayList<SelectItem>();
    ArrayList<SelectItem> jobPositionList = transferAndpromotionHistoryManager.getAllJobTypesForPromotion();
    ArrayList<SelectItem> promotionTypeList = transferAndpromotionHistoryManager.getTransferAndPromotionTypes();
    ArrayList<SelectItem> rankList = transferAndpromotionHistoryManager.getAllRanks();
    String newOrEditOrUpdateLabel = "Save";
    int selectedRow = -1;
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    //=================================================================================================
    int transferAndPromotionId;
    String employeeId;
    String requesterDepartment;
    String previousJobPosition;
    String newJobPosition;
    String previousSalary;
    String newSalary;
    String previousRank;
    String newRank;
    String reason;
    String promotionType;
    String promotionRequestDate;
    String promotionRequestLetterNumber;
    String promotionDate;
    String completedDate;
    String promotionLetterNumber;
    String advertisenmentNumber;
    String databaseStatus;
    String timeStamp;
    String userName;
    //=====================================================================================
    private Tree organizationTree = new Tree();
    private DefaultTree treeModel = new DefaultTree();
    private PanelLayout pnlLayoutTree = new PanelLayout();

    public void treeLink_processAction(ActionEvent ae) {

        String departmentName;
        String department = organizationTree.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];
            requesterDepartment = (_department[1].trim());
            txtRequestingDepartment.setValue(departmentName);
            pnlLayoutTree.setRendered(false);
        }
    }

    public String btnTreeRequesterDepartment_action() {
        LoadTree loadTree = new LoadTree();
        this.treeModel.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        pnlLayoutTree.setRendered(true);
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

//===============================================================================================
    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
    }

    public void rowSelector_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }

    public String cmdLnkRemove_action() {
        if (selectedRow != -1) {
            if (transferAndPromotionHistoryList.get(selectedRow).getDatabaseStatus().equals("New")) {
                transferAndPromotionHistoryList.remove(selectedRow);
            } else {//if Edited or Old
                transferAndPromotionHistoryList.get(selectedRow).setDatabaseStatus("Deleted");
            }
        }
        return null;
    }

    public String cmdLnkOk_action() {
        if (selectedRow != -1) {
            if (transferAndPromotionHistoryList.get(selectedRow).getDatabaseStatus().equals("New")) {
            } else {//if Edited or Old
                transferAndPromotionHistoryList.get(selectedRow).setDatabaseStatus("Edited");
            }
        }
        return null;
    }

    public String btnSaveOrUpdate_action() {




        if (transferAndpromotionHistoryManager.saveTransferAndPromotionHistory(transferAndPromotionHistoryList)) {
            showSuccessOrFailureMessage(true, "SAVING SUCCEDDED");
            transferAndPromotionHistoryList = transferAndpromotionHistoryManager.getTransferAndPromotionHistory(employeeId);
        } else {
            showSuccessOrFailureMessage(false, "SAVING FAILED");
        }
        return null;
    }

    public void calPromotionDate_processValueChange(ValueChangeEvent vce) {
        txtPromotionDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calPromotionDate.setRendered(false);
    }

    private boolean validateAndInitializeAttributes() {

        if (employeeId == null || employeeId.equals("-1")) {
            showSuccessOrFailureMessage(false, "FIRST SELECT EMPLOYEE");
            return false;

        } else {
            try {
                // String newJobType[] = drlPrevJobType.getValue().toString().split("--");
                //   String oldJobType[] = drlNewJobType.getValue().toString().split("--");
                previousJobPosition = drlPrevJobType.getValue().toString();
                newJobPosition = drlNewJobType.getValue().toString();
                previousSalary = txtPrevSalary.getValue().toString().trim();
                newSalary = txtNewSalary.getValue().toString().trim();
                previousRank = drlPreviousRank.getValue().toString();
                newRank = drlNewRank.getValue().toString();
                reason = txtaReason.getValue().toString();
                promotionType = drlPromotionType.getValue().toString();
                promotionRequestDate = txtRequestDate.getValue().toString();
                promotionRequestLetterNumber = txtPromotionLetterNumber.getValue().toString();
                promotionDate = txtPromotionDate.getValue().toString();
                completedDate = txtCompletedDate.getValue().toString();
                promotionLetterNumber = txtPromotionLetterNumber.getValue().toString();
                advertisenmentNumber = txtAdvertisnmentNumber.getValue().toString();
                databaseStatus = "New";
                //check if salary is valid, if not valid exception will be thrown
                Double.parseDouble(newSalary);
                Double.parseDouble(newSalary);
                return true;
            } catch (NullPointerException npe) {
                showSuccessOrFailureMessage(false, "All fields should be filled!");
                return false;
            } catch (NumberFormatException nfe) {
                showSuccessOrFailureMessage(false, "CHECK THE VALUE OF SALARY! \nIT SHOULD  CONTAIN ONLY NUMBERS AND/OR DECIMAL");
                return false;
            }
        }
    }

    public String btnAddToTable_action() {
        if (validateAndInitializeAttributes()) {
            transferAndPromotionHistoryModel = new TransferAndPromotionHistoryModel(-1,
                    employeeId,
                    requesterDepartment,
                    previousJobPosition,
                    newJobPosition,
                    previousSalary,
                    newSalary,
                    previousRank,
                    newRank, reason,
                    promotionType,
                    promotionRequestDate,
                    promotionRequestLetterNumber,
                    promotionDate,
                    completedDate,
                    promotionLetterNumber,
                    advertisenmentNumber,
                    databaseStatus);

            transferAndPromotionHistoryList.add(transferAndPromotionHistoryModel);
            clearHistoryAttributes();
        }
        return null;
    }

    public String btnReset_action() {
        clearAllComponenets();
        //   makePageReadyForSave();
        return null;
    }

    public void calCompletedDates_processValueChange(ValueChangeEvent vce) {
        txtCompletedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calCompletedDates.setRendered(false);
    }
}
