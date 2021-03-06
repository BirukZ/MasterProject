/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Training;

import com.icesoft.faces.component.dragdrop.DragEvent;
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
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import manager.educationManager.EducationCostModel;
import manager.educationManager.InstitutionRegistrationManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.trainingManager.ActionPlanManager;
import manager.trainingManager.TrainingLookupManger;
import manager.trainingManager.TrainingNeedAssessementRequestManager;
import manager.trainingManager.TrainingParticipantModel;
import manager.trainingManager.TrainingProgressCostManger;
import manager.trainingManager.TrainingProgressManager;
import manager.trainingManager.TrainingProgressModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TrainingProgressCost extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        trainingCostList.clear();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public TrainingProgressCostManger getTrainingProgressCostManger() {
        return trainingProgressCostManger;
    }

    public void setTrainingProgressCostManger(TrainingProgressCostManger trainingProgressCostManger) {
        this.trainingProgressCostManger = trainingProgressCostManger;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
    private DefaultSelectItemsArray selectOneRadio1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems = dsia;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems2 = dsi;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems3 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems3 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectedData selectOneMenu11Bean = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataBudjetYear = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu11Bean() {
        return selectOneMenu11Bean;
    }

    public void setSelectOneMenu11Bean(DefaultSelectedData selectOneMenu11Bean) {
        this.selectOneMenu11Bean = selectOneMenu11Bean;
    }

    public DefaultSelectedData getDefaultSelectedDataBudjetYear() {
        return defaultSelectedDataBudjetYear;
    }

    public void setDefaultSelectedDataBudjetYear(DefaultSelectedData defaultSelectedDataBudjetYear) {
        this.defaultSelectedDataBudjetYear = defaultSelectedDataBudjetYear;
    }
    private DefaultSelectedData defaultSelectedDataBatch = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataBatch() {
        return defaultSelectedDataBatch;
    }

    public void setDefaultSelectedDataBatch(DefaultSelectedData defaultSelectedDataBatch) {
        this.defaultSelectedDataBatch = defaultSelectedDataBatch;
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
    private HtmlSelectOneMenu drlBatch = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBatch() {
        return drlBatch;
    }

    public void setDrlBatch(HtmlSelectOneMenu hsom) {
        this.drlBatch = hsom;
    }
    private HtmlInputText txtFactor = new HtmlInputText();

    public HtmlInputText getTxtFactor() {
        return txtFactor;
    }

    public void setTxtFactor(HtmlInputText hit) {
        this.txtFactor = hit;
    }
    private HtmlInputText txtCostName = new HtmlInputText();

    public HtmlInputText getTxtCostName() {
        return txtCostName;
    }

    public void setTxtCostName(HtmlInputText hit) {
        this.txtCostName = hit;
    }
    private HtmlInputText txtUnitCost = new HtmlInputText();

    public HtmlInputText getTxtUnitCost() {
        return txtUnitCost;
    }

    public void setTxtUnitCost(HtmlInputText hit) {
        this.txtUnitCost = hit;
    }
    private DefaultSelectedData defaultSelectedDataCostCategories = new DefaultSelectedData();

    public String getAdminstraticeCostName() {
        return adminstraticeCostName;
    }

    public void setAdminstraticeCostName(String adminstraticeCostName) {
        this.adminstraticeCostName = adminstraticeCostName;
    }

    public String getAdminstraticeCostType() {
        return adminstraticeCostType;
    }

    public void setAdminstraticeCostType(String adminstraticeCostType) {
        this.adminstraticeCostType = adminstraticeCostType;
    }

    public DefaultSelectedData getDefaultSelectedDataCostCategories() {
        return defaultSelectedDataCostCategories;
    }

    public void setDefaultSelectedDataCostCategories(DefaultSelectedData defaultSelectedDataCostCategories) {
        this.defaultSelectedDataCostCategories = defaultSelectedDataCostCategories;
    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public String getCostTypeCategory() {
        return costTypeCategory;
    }

    public void setCostTypeCategory(String costTypeCategory) {
        this.costTypeCategory = costTypeCategory;
    }

    public String getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(String costTypeId) {
        this.costTypeId = costTypeId;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }

    public int getQuantityOrAmount() {
        return quantityOrAmount;
    }

    public void setQuantityOrAmount(int quantityOrAmount) {
        this.quantityOrAmount = quantityOrAmount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems6 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems6 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems7 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private HtmlSelectOneMenu drlCostCategories = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCostCategories() {
        return drlCostCategories;
    }

    public void setDrlCostCategories(HtmlSelectOneMenu hsom) {
        this.drlCostCategories = hsom;
    }
    private HtmlInputTextarea txtaRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaRemark() {
        return txtaRemark;
    }

    public void setTxtaRemark(HtmlInputTextarea hit) {
        this.txtaRemark = hit;
    }
    private HtmlInputText txtReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtReferenceNumber() {
        return txtReferenceNumber;
    }

    public void setTxtReferenceNumber(HtmlInputText hit) {
        this.txtReferenceNumber = hit;
    }
    private HtmlInputText txtTotalCost = new HtmlInputText();

    public HtmlInputText getTxtTotalCost() {
        return txtTotalCost;
    }

    public void setTxtTotalCost(HtmlInputText hit) {
        this.txtTotalCost = hit;
    }
    private HtmlSelectOneMenu drlTrainings = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainings() {
        return drlTrainings;
    }

    public void setDrlTrainings(HtmlSelectOneMenu hsom) {
        this.drlTrainings = hsom;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlSelectOneMenu drlProgressStatus = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProgressStatus() {
        return drlProgressStatus;
    }

    public void setDrlProgressStatus(HtmlSelectOneMenu hsom) {
        this.drlProgressStatus = hsom;
    }
    private HtmlSelectOneMenu drlBudjetYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBudjetYear() {
        return drlBudjetYear;
    }

    public void setDrlBudjetYear(HtmlSelectOneMenu hsom) {
        this.drlBudjetYear = hsom;
    }
    private HtmlInputText txtNoOfDays = new HtmlInputText();

    public HtmlInputText getTxtNoOfDays() {
        return txtNoOfDays;
    }

    public void setTxtNoOfDays(HtmlInputText hit) {
        this.txtNoOfDays = hit;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }

    private HtmlSelectBooleanCheckbox chkDaily = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkDaily() {
        return chkDaily;
    }

    public void setChkDaily(HtmlSelectBooleanCheckbox hsbc) {
        this.chkDaily = hsbc;
    }

    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TrainingProgressCost() {
    }

    public TrainingProgressCost(String costType, double cost) {
        this.costType = costType;
        this.cost = cost;
    }

    public TrainingProgressCost(double cost) {
        this.cost = cost;
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

    public ArrayList<SelectItem> getProgressList() {
        return progressList;
    }

    public void setProgressList(ArrayList<SelectItem> progressList) {
        this.progressList = progressList;
    }

    public void setPendingRequestList(ArrayList<SelectItem> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public DefaultSelectedData getSelectedObjectFromBudjetYearList() {
        return selectedObjectFromBudjetYearList;
    }

    public void setSelectedObjectFromBudjetYearList(DefaultSelectedData selectedObjectFromBudjetYearList) {
        this.selectedObjectFromBudjetYearList = selectedObjectFromBudjetYearList;
    }

    public DefaultSelectedData getSelectedObjectFromInstitutionList() {
        return selectedObjectFromInstitutionList;
    }

    public void setSelectedObjectFromInstitutionList(DefaultSelectedData selectedObjectFromInstitutionList) {
        this.selectedObjectFromInstitutionList = selectedObjectFromInstitutionList;
    }

    public DefaultSelectedData getSelectedObjectFromTrainingsList() {
        return selectedObjectFromTrainingsList;
    }

    public void setSelectedObjectFromTrainingsList(DefaultSelectedData selectedObjectFromTrainingsList) {
        this.selectedObjectFromTrainingsList = selectedObjectFromTrainingsList;
    }

    public DefaultSelectedData getSelectedRequestFromMyRequestList() {
        return selectedRequestFromMyRequestList;
    }

    public void setSelectedRequestFromMyRequestList(DefaultSelectedData selectedRequestFromMyRequestList) {
        this.selectedRequestFromMyRequestList = selectedRequestFromMyRequestList;
    }

    public ArrayList<SelectItem> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(ArrayList<SelectItem> institutionList) {
        this.institutionList = institutionList;
    }

    public ArrayList<SelectItem> getBudjetYearList() {
        return budjetYearList;
    }

    public void setBudjetYearList(ArrayList<SelectItem> budjetYearList) {
        this.budjetYearList = budjetYearList;
    }

    public ArrayList<SelectItem> getTrainingsList() {
        return trainingsList;
    }

    public void setTrainingsList(ArrayList<SelectItem> trainingsList) {
        this.trainingsList = trainingsList;
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

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public ArrayList<TrainingParticipantModel> getTrainingParticipantsList() {
        return trainingParticipantsList;
    }

    public void setTrainingParticipantsList(ArrayList<TrainingParticipantModel> trainingParticipantsList) {
        this.trainingParticipantsList = trainingParticipantsList;
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
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public HtmlOutputText getOutputTextConfirmDelete() {
        return outputTextConfirmDelete;
    }

    public ActionPlanManager getActionPlanManager() {
        return actionPlanManager;
    }

    public void setActionPlanManager(ActionPlanManager actionPlanManager) {
        this.actionPlanManager = actionPlanManager;
    }

    public String getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(String budjetYear) {
        this.budjetYear = budjetYear;
    }

    public ArrayList<SelectItem> getCostCategoryList() {
        return costCategoryList;
    }

    public void setCostCategoryList(ArrayList<SelectItem> costCategoryList) {
        this.costCategoryList = costCategoryList;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAssignedInstitutionId() {
        return assignedInstitutionId;
    }

    public void setAssignedInstitutionId(String assignedInstitutionId) {
        this.assignedInstitutionId = assignedInstitutionId;
    }


    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }



    public String getJobTitleName() {
        return jobTitleName;
    }

    public void setJobTitleName(String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }

    public String getReferencingTableId() {
        return referencingTableId;
    }

    public void setReferencingTableId(String referencingTableId) {
        this.referencingTableId = referencingTableId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public InstitutionRegistrationManager getInstitutionRegistrationManager() {
        return institutionRegistrationManager;
    }

    public void setInstitutionRegistrationManager(InstitutionRegistrationManager institutionRegistrationManager) {
        this.institutionRegistrationManager = institutionRegistrationManager;
    }

    public ArrayList<EducationCostModel> getTrainingCostList() {
        return trainingCostList;
    }

    public void setTrainingCostList(ArrayList<EducationCostModel> trainingCostList) {
        this.trainingCostList = trainingCostList;
    }

    public ArrayList<EducationCostModel> getStationaryCostList() {
        return stationaryCostList;
    }

    public void setStationaryCostList(ArrayList<EducationCostModel> stationaryCostList) {
        this.stationaryCostList = stationaryCostList;
    }

    public ArrayList<EducationCostModel> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(ArrayList<EducationCostModel> salaryList) {
        this.salaryList = salaryList;
    }


    public TrainingLookupManger getTrainingLookupManger() {
        return trainingLookupManger;
    }

    public void setTrainingLookupManger(TrainingLookupManger trainingLookupManger) {
        this.trainingLookupManger = trainingLookupManger;
    }

    public TrainingNeedAssessementRequestManager getTrainingNeedAssessementRequestManager() {
        return trainingNeedAssessementRequestManager;
    }

    public void setTrainingNeedAssessementRequestManager(TrainingNeedAssessementRequestManager trainingNeedAssessementRequestManager) {
        this.trainingNeedAssessementRequestManager = trainingNeedAssessementRequestManager;
    }

    public int getTrainingNeedRequestId() {
        return trainingNeedRequestId;
    }

    public void setTrainingNeedRequestId(int trainingNeedRequestId) {
        this.trainingNeedRequestId = trainingNeedRequestId;
    }

    public int getTrainingParticipantId() {
        return trainingParticipantId;
    }

    public void setTrainingParticipantId(int trainingParticipantId) {
        this.trainingParticipantId = trainingParticipantId;
    }

    public int getTrainingTypeId() {
        return trainingTypeId;
    }

    public ArrayList<SelectItem> getBatchList() {
        return batchList;
    }

    public void setBatchList(ArrayList<SelectItem> batchList) {
        this.batchList = batchList;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public TrainingProgressManager getTrainingProgressManager() {
        return trainingProgressManager;
    }

    public void setTrainingProgressManager(TrainingProgressManager trainingProgressManager) {
        this.trainingProgressManager = trainingProgressManager;
    }

    public void setTrainingTypeId(int trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public PanelPopup getPnlPopupStationaryCost() {
        return pnlPopupStationaryCost;
    }

    public void setPnlPopupStationaryCost(PanelPopup pnlPopupStationaryCost) {
        this.pnlPopupStationaryCost = pnlPopupStationaryCost;
    }

    public PanelPopup getPnlPopupSalary() {
        return pnlPopupSalary;
    }

    public void setPnlPopupSalary(PanelPopup pnlPopupSalary) {
        this.pnlPopupSalary = pnlPopupSalary;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public int getSelectedRowsss() {
        return selectedRowsss;
    }

    public void setSelectedRowsss(int selectedRowsss) {
        this.selectedRowsss = selectedRowsss;
    }

    public int getSelectedRowsss2() {
        return selectedRowsss2;
    }

    public void setSelectedRowsss2(int selectedRowsss2) {
        this.selectedRowsss2 = selectedRowsss2;
    }


    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();
    private PanelPopup pnlPopupStationaryCost = new PanelPopup();
    private PanelPopup pnlPopupSalary = new PanelPopup();
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

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(2);//requestId
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public void rowSelector1_processMyEvent(RowSelectorEvent rse) {
        selectedRowsss = rse.getRow();
    }

    public void rowSelector2_processMyEvent(RowSelectorEvent rse) {
        selectedRowsss2 = rse.getRow();
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
    // </editor-fold >
    String requesterId;
    EmployeeManage employeeManager = new EmployeeManage();
    ActionPlanManager actionPlanManager = new ActionPlanManager();
    TrainingProgressCostManger trainingProgressCostManger = new TrainingProgressCostManger();
    TrainingProgressModel trainingProgressModel = new TrainingProgressModel();
    TrainingLookupManger trainingLookupManger = new TrainingLookupManger();
    TrainingNeedAssessementRequestManager trainingNeedAssessementRequestManager = new TrainingNeedAssessementRequestManager();
    InstitutionRegistrationManager institutionRegistrationManager = new InstitutionRegistrationManager();
    ArrayList<TrainingParticipantModel> trainingParticipantsList = new ArrayList<TrainingParticipantModel>();
    ArrayList<EducationCostModel> trainingCostList = new ArrayList<EducationCostModel>();
    ArrayList<EducationCostModel> stationaryCostList = new ArrayList<EducationCostModel>();
    ArrayList<EducationCostModel> salaryList = new ArrayList<EducationCostModel>();
    TrainingProgressManager trainingProgressManager = new TrainingProgressManager();
    ArrayList<SelectItem> progressList = trainingProgressManager.getProgressTypes();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> batchList = trainingProgressManager.getBatchLists();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> costCategoryList = trainingLookupManger.getAllCostTypes();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> budjetYearList = trainingLookupManger.getAllBudgetYears();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> trainingsList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> institutionList = institutionRegistrationManager.getActiveTrainingInstitutions();
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectFromBudjetYearList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectFromTrainingsList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectFromInstitutionList = new DefaultSelectedData();
    int trainingParticipantId;
    int trainingNeedRequestId;
    String employeeId;
    String fullName;
    String referencingTableId;
    String departmentName;
    String jobTitleName;
    String databaseStatus;
    boolean selected;
    String batchCode;
    String status;
    String userName;
    String timeStamp;
    String costTypeId;
    String costTypeCategory;
    String costTypeName;
    String budjetYear;
    //  int trainingId;
    int quantityOrAmount;
    double unitCost;
    double totalCost;
    String documentReferenceNumber;
    String adminstraticeCostType;
    String adminstraticeCostName;
    String newOrEditOrUpdateLabel = "Save";
    int institutionId;
    String assignedInstitutionId;
    int trainingTypeId;
    String costType = null;
    double cost = 0.0;
    int selectedRowsss = -1;
    int selectedRowsss2 = -1;
//    String institutionId = null;

    private void populateDecisionHistory(int overTimeRequestId) {
//        OverTimeApproveManager overTimeApproveManager = new OverTimeApproveManager();
//        decisionsMadeOnRequest = overTimeApproveManager.getRequestHistory(overTimeRequestId);
//        if (decisionsMadeOnRequest.size() > 0) {
//            lnkViewPrevieousDecisions.setRendered(true);
//        } else {
//            lnkViewPrevieousDecisions.setRendered(false);
//            makePageReadyForUpdate();
//        }
    }

    boolean validateAndInitialize() {
        return true;
    }
    ArrayList<TrainingProgressModel> checkSavedBeforeORNot = new ArrayList<TrainingProgressModel>();
    ArrayList<TrainingProgressCostManger> checkDetailCostSavedBeforeORNot = new ArrayList<TrainingProgressCostManger>();

    public String btnSaveOrUpdate_action() {
//        if (validateAndInitialize()) {
//            if (trainingProgressCostManger.saveTrainingCosts(trainingCostList)) {
//                trainingCostList = trainingProgressCostManger.getTrainingCosts(budjetYear, trainingTypeId, batchCode);
//                showSuccessOrFailureMessage(true, "SAVING OKAY");
//            } else {
//                showSuccessOrFailureMessage(false, "SAVING FAILED");
//            }
//        }
//        if (drlProgressStatus.getValue().toString().equalsIgnoreCase("CT")) {
//            ArrayList<String> participant = new ArrayList<String>();
//            int noOfParticipants = trainingParticipantsList.size();
//            double costPerPerson = 0.0;
//            double cost = 0.0;
//            double total = 0.0;
//
//            for (EducationCostModel trainingCost : trainingCostList) {
//
//                cost = trainingCost.getTotalCost();
//                total = total + cost;
//            }
//            String trainingType = drlTrainings.getValue().toString().split("-")[1];
//            String startDate = txtStartDate.getValue().toString();
//            String endDate = txtEndDate.getValue().toString();
//            costPerPerson = total / noOfParticipants;
//            checkSavedBeforeORNot = trainingProgressCostManger.checkSaved(trainingType, startDate, endDate);
//            if (checkSavedBeforeORNot.size() > 0) {
////          for(TrainingParticipantModel participantList:trainingParticipantsList ){
////              String participantid = participantList.getEmployeeId();
////              participant.add(participantid);
////          }
//
//                if (trainingProgressCostManger.updateTrainingCostPerPerson(checkSavedBeforeORNot, trainingType, startDate, endDate, costPerPerson)) {
//                    showSuccessOrFailureMessage(true, "The Training information updated successfully");
//                } else {
//                    showSuccessOrFailureMessage(false, "The Training information NOT updated successfully");
//                }
//
//
//
//            } else {
//
//                if (trainingProgressCostManger.saveTrainingCostPerPerson(trainingParticipantsList, trainingType, startDate, endDate, costPerPerson)) {
//                    showSuccessOrFailureMessage(true, "The Training information saved successfully");
//                } else {
//                    showSuccessOrFailureMessage(false, "The Training information NOT saved successfully");
//                }
//            }
//        }


        if (validateAndInitialize()) {
            if (trainingProgressCostManger.saveTrainingCosts(trainingCostList)) {
                trainingCostList = trainingProgressCostManger.getTrainingCosts(budjetYear, trainingTypeId, batchCode);
                showSuccessOrFailureMessage(true, "SAVING OKAY");
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        if (drlProgressStatus.getValue().toString().equalsIgnoreCase("CT")) {
            ArrayList<String> participant = new ArrayList<String>();
            int noOfParticipants = trainingParticipantsList.size();
            double costPerPerson = 0.0;
            double costs = 0.0;
            double total = 0.0;
            double[] detailCos;
            double[] detailCosForEach;

            detailCos = new double[7];
            detailCosForEach = new double[7];
//            String costType = "null";
            ArrayList<TrainingProgressCost> costDetail = new ArrayList<TrainingProgressCost>();
//            for (EducationCostModel trainingCost : trainingCostList) {
//                int costId = Integer.parseInt(trainingCost.getCostTypeCategory());
//                if (costId==1||costId==2||costId==3||costId==4||costId==5||costId==6||costId==7||costId==8){
////                costType = trainingCost.getCostTypeName();
//                costs = trainingCost.getTotalCost();
//                total = total + costs;
//                } else{
//                costs = 0.0;
//                }
//                costDetail.add(new TrainingProgressCost(costs));
//
            for (int i = 0; i < 7; i++) {
                double eachCost = 0.0;
                for (EducationCostModel trainingCost : trainingCostList) {
                    int costId = Integer.parseInt(trainingCost.getCostTypeCategory());
                    if (costId == i + 1) {
//                costType = trainingCost.getCostTypeName();
                        costs = trainingCost.getTotalCost();

                    } else {
                        costs = 0.0;
                    }
                    eachCost = eachCost + costs;

//               costDetail.add(new TrainingProgressCost(eachCost));
                }
                detailCos[i] = eachCost;
                total = total + eachCost;
            }
            for (int i = 0; i < 7; i++) {
                detailCosForEach[i] = detailCos[i] / noOfParticipants;
            }

            double trainingFee = 0.0;
            double intertainmentFee = 0.0;
            double transportFee = 0.0;
            double feeForTrainer = 0.0;
            double allowanceFee = 0.0;
            double stationaryFee = 0.0;
            double otherFee = 0.0;
//            int startMonth = null;
            String filterMonth = null;
            String filterYear = null;
            trainingFee = detailCosForEach[0];
            intertainmentFee = detailCosForEach[1];
            transportFee = detailCosForEach[2];
            feeForTrainer = detailCosForEach[3];
            allowanceFee = detailCosForEach[4];
            stationaryFee = detailCosForEach[5];
            otherFee = detailCosForEach[6];

            String trainingType = drlTrainings.getValue().toString().split("-")[1];
            String startDate = txtStartDate.getValue().toString();
            filterMonth = startDate.substring(5, 7);
            filterYear = startDate.substring(0, 4);
//            startMonth=Integer.parseInt( startDate);
            String endDate = txtEndDate.getValue().toString();
            costPerPerson = total / noOfParticipants;
//            ArrayList<TrainingProgressCost> costDetailPerPerson = new ArrayList<TrainingProgressCost>();
//            for (TrainingProgressCost cos : costDetail){
//                double costDetailForPerson = cos.getCost()/noOfParticipants;
//                costDetailPerPerson.add(new TrainingProgressCost(costDetailForPerson));
//            }
            checkSavedBeforeORNot = trainingProgressCostManger.checkSaved(trainingType, startDate, endDate);
            checkDetailCostSavedBeforeORNot = trainingProgressCostManger.checkDetailCostSaved(trainingType, startDate, endDate);
            if (checkSavedBeforeORNot.size() > 0) {
//          for(TrainingParticipantModel participantList:trainingParticipantsList ){
//              String participantid = participantList.getEmployeeId();
//              participant.add(participantid);
//          }
                trainingProgressCostManger.updateDetailTrainingCostPerPerson(checkDetailCostSavedBeforeORNot, trainingType, trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, stationaryFee, otherFee, costPerPerson, startDate, endDate, budjetYear);
                if (trainingProgressCostManger.updateTrainingCostPerPerson(checkSavedBeforeORNot, trainingType, startDate, endDate, costPerPerson, filterMonth, filterYear)) {
                    showSuccessOrFailureMessage(true, "The Training information updated successfully");
                } else {
                    showSuccessOrFailureMessage(false, "The Training information NOT updated successfully");
                }



            } else {
                trainingProgressCostManger.saveDetailTrainingCostPerPerson(trainingParticipantsList, trainingType, trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, stationaryFee, otherFee, costPerPerson, startDate, endDate, budjetYear);
                if (trainingProgressCostManger.saveTrainingCostPerPerson(trainingParticipantsList, trainingType, startDate, endDate, costPerPerson, filterMonth, filterYear, assignedInstitutionId)) {
                    showSuccessOrFailureMessage(true, "The Training information saved successfully");
                } else {
                    showSuccessOrFailureMessage(false, "The Training information NOT saved successfully");
                }
            }
        }



        return null;




    }

    
//selectedObjectOfBudjetYearList.setSelectedObject(null);
    public String btnReset_action() {
        //return null means stay on the same page
            drlCostCategories.resetValue();
            txtCostName.setValue(null);
            txtUnitCost.setValue(null);
            txtFactor.setValue(null);
            txtTotalCost.setValue(null);
            txtReferenceNumber.setValue(null);
            trainingCostList.clear();
            trainingParticipantsList.clear();
            drlBudjetYear.resetValue();
            drlTrainings.resetValue();
            drlProgressStatus.resetValue();
            drlBatch.resetValue();
            txtStartDate.setValue(null);
            txtEndDate.setValue(null);
            txtNoOfDays.setValue(null);
//            selectedObjectFromBudjetYearList.setSelectedObject(null);
//            selectedObjectFromInstitutionList.setSelectedObject(null);
            selectOneMenu11Bean.setSelectedObject(null);
            selectOneMenu2Bean.setSelectedObject(null);
            defaultSelectedDataBatch.setSelectedObject(null);
        return null;
    }

    public String btnCalStartDate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCalEndDate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnAddToTable_action() {
        if (validateAndInitializeAttributes()) {
           // if (!checkAdminList()) {
                trainingCostList.add(new EducationCostModel("-1", costTypeCategory, costTypeName, budjetYear, trainingTypeId, batchCode, quantityOrAmount, unitCost, totalCost, documentReferenceNumber, "New"));
//            } else {
//                showSuccessOrFailureMessage(false, "ALREADY INSERTED INTO TABLE");
//            }
            drlCostCategories.resetValue();
            txtCostName.setValue(null);
            txtUnitCost.setValue(null);
            txtFactor.setValue(null);
            txtTotalCost.setValue(null);
            txtReferenceNumber.setValue(null);

        }
        return null;
    }

    private boolean checkAdminList() {// checks whether this participant is already in the list
        String posId = drlCostCategories.getValue().toString();
//        String costTypeCategoryName = trainingProgressCostManger.gettrainingCategoryName(posId);
        boolean checkAminLists = false;
        Iterator<EducationCostModel> ittkmpList = trainingCostList.iterator();
        while (ittkmpList.hasNext() && !checkAminLists) {
            EducationCostModel singlePosIdVal = ittkmpList.next();
            if ((singlePosIdVal.getCostTypeCategory().toString().equals(posId))) {
                checkAminLists = true;

            }
        }
        return checkAminLists;

    }

    private boolean validateAndInitializeAttributes() {
        try {

            unitCost = Double.parseDouble(txtUnitCost.getValue().toString());
            quantityOrAmount = Integer.parseInt(txtFactor.getValue().toString());
            costTypeCategory = drlCostCategories.getValue().toString();
            costTypeName = txtCostName.getValue().toString();

            if (chkDaily.isSelected()) {
                int noOfDays = Integer.parseInt(txtNoOfDays.getValue().toString());
                totalCost = (unitCost * quantityOrAmount)*noOfDays;
            } else {
            totalCost = unitCost * quantityOrAmount;// Double.parseDouble(txtTotalCost.getValue().toString());
            }
            documentReferenceNumber = txtReferenceNumber.getValue() == null ? "" : txtReferenceNumber.getValue().toString();
            databaseStatus = "New";
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "SOME FIELDS ARE NOT FILLED");
            return false;
        } catch (NumberFormatException nfe) {
            showSuccessOrFailureMessage(false, "PLEASE CHECK COST AND/QUANTITY FIELDS");
            return false;
        }
        return true;
    }

    private boolean populateBatchAttributes(String budjetYear, int trainingTypeId, String batchCode) {
        //(budjetYear, trainingTypeId, batchCode)
        return true;
    }

    public String txtUnitCost_action() {
        //return null means stay on the same page
        return null;
    }

    public void status_Group_processMyEvent(DragEvent de) {
    }

    public String txtReferenceNumber_action() {
        //return null means stay on the same page
        return null;
    }

    boolean populateBatchAttributes(int progressId) {
        trainingProgressModel = trainingProgressManager.getProgressDetail(progressId);
        if (trainingProgressModel.getProgressId() != -1) {
            txtEndDate.setValue(trainingProgressModel.getEndDate());
            txtStartDate.setValue(trainingProgressModel.getStartDate());
            int noOfDays =StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(),txtEndDate.getValue().toString());
            txtNoOfDays.setValue(noOfDays);
            drlProgressStatus.setValue(trainingProgressModel.getProgressStatus());
        } else {
            txtEndDate.setValue("");
            txtStartDate.setValue("");
            drlProgressStatus.setValue("");
        }
        return true;
    }

    public void drlBatch_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            trainingCostList.clear();
            trainingParticipantsList.clear();
            batchCode = vce.getNewValue().toString();
            if (trainingParticipantsList != null) {
                trainingParticipantsList.clear();
                trainingParticipantsList = null;
                trainingParticipantsList = trainingNeedAssessementRequestManager.getApprovedParticipantsOfTraining(budjetYear, trainingTypeId, batchCode);
                assignedInstitutionId = trainingNeedAssessementRequestManager.getAssignedInstitutionId(budjetYear, trainingTypeId);
            } else {
                trainingParticipantsList = trainingNeedAssessementRequestManager.getApprovedParticipantsOfTraining(budjetYear, trainingTypeId, batchCode);
                assignedInstitutionId = trainingNeedAssessementRequestManager.getAssignedInstitutionId(budjetYear, trainingTypeId);
            }
            if (trainingCostList != null) {
                trainingCostList.clear();
                trainingCostList = null;
                trainingCostList = trainingProgressCostManger.getTrainingCosts(budjetYear, trainingTypeId, batchCode);
            } else {
                trainingCostList.clear();
                trainingCostList = null;
                trainingCostList = trainingProgressCostManger.getTrainingCosts(budjetYear, trainingTypeId, batchCode);
            }
            int progressId = trainingProgressManager.getProgressStatus(budjetYear, trainingTypeId, batchCode);
            if (progressId != -1) {
                populateBatchAttributes(progressId);
            }
        }
    }

    public void drlBudjetYear_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            budjetYear = vce.getNewValue().toString();
            trainingsList = actionPlanManager.getApprovedTrainingTypes(budjetYear); //actionPlanManager.getApprovedNeedRequests(budjetYear);
        }
    }
    int selectedRow = -1;

    public String cmdLnkRemove_action() {
        if (selectedRow != -1) {
            if (trainingCostList.get(selectedRow).getDatabaseStatus().equals("New")) {
                trainingCostList.remove(selectedRow);
            } else {//if Edited or Old
                trainingCostList.get(selectedRow).setDatabaseStatus("Deleted");
            }
        }
//        trainingCostList.get(selectedRow).setTotalCost(trainingCostList.get(selectedRow).getUnitCost() * trainingCostList.get(selectedRow).getQuantityOrAmount());
        return null;
    }

    public void rowSelector_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }

    public String cmdLnkOk_action() {
        if (selectedRow != -1) {
            if (trainingCostList.get(selectedRow).getDatabaseStatus().equals("New")) {
            } else {//if Edited or Old
                trainingCostList.get(selectedRow).setDatabaseStatus("Edited");
            }
            trainingCostList.get(selectedRow).setTotalCost(trainingCostList.get(selectedRow).getUnitCost() * trainingCostList.get(selectedRow).getQuantityOrAmount());
        }
        return null;
    }

    public void drlTrainings_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (vce.getNewValue().toString().indexOf("-") > 0) {
                trainingTypeId = Integer.parseInt(vce.getNewValue().toString().split("-")[0]);
                 defaultSelectedDataBatch.setSelectedObject(null);
            }
        //
        }
    }

    public void drlCostCategories_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue()!= null) {
            if (vce.getNewValue().toString().equalsIgnoreCase("6"))
            {
          //  pnlPopupStationaryCost.setRendered(true);
            stationaryCostList = trainingProgressCostManger.getStationaryCosts();
             } else if (vce.getNewValue().toString().equalsIgnoreCase("5")){
            pnlPopupSalary.setRendered(true);
            salaryList = trainingProgressCostManger.getAllowance(trainingParticipantsList);
             }
            }
    }

    public String btnCloseStationaryCost_action() {
        pnlPopupStationaryCost.setRendered(false);
        stationaryCostList.clear();
        //return null means stay on the same page
        return null;
    }

    public String btnCloseSalary_action() {
        pnlPopupSalary.setRendered(false);
        salaryList.clear();
        //return null means stay on the same page
        return null;
    }

    public String button1_action() {
        double unitcosts = Double.parseDouble(txtUnitCost.getValue().toString());
        int quantity = Integer.parseInt(txtFactor.getValue().toString());
        try {
        if (chkDaily.isSelected()) {            
            int noOfDays = Integer.parseInt(txtNoOfDays.getValue().toString());
            txtTotalCost.setValue((unitcosts * quantity)*noOfDays);
        } else {
            txtTotalCost.setValue(unitcosts * quantity);// Double.parseDouble(txtTotalCost.getValue().toString());
        }
//        txtTotalCost.setValue(unitcosts * quantity);
        //return null means stay on the same page
        return null;
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "NUMBER OF DAYS IS NOT FILLED");
            return null;
        }
    }

    public String linkAction1_action() {
        if (selectedRowsss != -1) {
          txtCostName.setValue(stationaryCostList.get(selectedRowsss).getStationaryName());
          txtUnitCost.setValue(stationaryCostList.get(selectedRowsss).getPrice());
        }
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkAction2_action() {
        if (selectedRowsss2 != -1) {
//          txtCostName.setValue(salaryList.get(selectedRowsss2).getStationaryName());
            int rankId = Integer.parseInt(salaryList.get(selectedRowsss2).getStationaryName());
//          txtCostName.setValue("allowance");
            if ((rankId == 14) || (rankId == 15) || (rankId == 16) || (rankId == 17)) {
          txtUnitCost.setValue(trainingProgressCostManger.getRateByRank(salaryList.get(selectedRowsss2).getStationaryName()));
            } else {
          txtUnitCost.setValue(trainingProgressCostManger.getRate(salaryList.get(selectedRowsss2).getPrice()));
            }
//          txtUnitCost.setValue(salaryList.get(selectedRowsss2).getPrice());
        }
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public void chkDaily_processValueChange(ValueChangeEvent vce) {
//        chkBAsic.setSelected(false);
//        chkdrivingSkill.setSelected(false);
//        drlEducationLevelCatagory.setDisabled(false);
//        rank =
//                13;
//        this.setEducationLevelCatagoryList(educationRequestManager.readHigherEducationLevel(rank));
    }

}
