/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Training;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectManyListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.educationManager.EducationCostModel;
import manager.educationManager.InstitutionRegistrationManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.trainingManager.ActionPlanManager;
import manager.trainingManager.TrainingLookupManger;
import manager.trainingManager.TrainingNeedAssessementRequestManager;
import manager.trainingManager.TrainingProgressManager;
import manager.trainingManager.TrainingProgressModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TrainingProgressPage extends AbstractPageBean {
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
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }

    public Object[] getSelectedItemsFromNotTrainned() {
        return selectedItemsFromNotTrainned;
    }

    public void setSelectedItemsFromNotTrainned(Object[] selectedItemsFromNotTrainned) {
        this.selectedItemsFromNotTrainned = selectedItemsFromNotTrainned;
    }

    public Object[] getSelectedItemsFromTrainned() {
        return selectedItemsFromTrainned;
    }

    public void setSelectedItemsFromTrainned(Object[] selectedItemsFromTrainned) {
        this.selectedItemsFromTrainned = selectedItemsFromTrainned;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public TrainingProgressManager getTrainingProgressManager() {
        return trainingProgressManager;
    }

    public void setTrainingProgressManager(TrainingProgressManager trainingProgressManager) {
        this.trainingProgressManager = trainingProgressManager;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }

    public TrainingNeedAssessementRequestManager getAssessementRequestManager() {
        return assessementRequestManager;
    }

    public void setAssessementRequestManager(TrainingNeedAssessementRequestManager assessementRequestManager) {
        this.assessementRequestManager = assessementRequestManager;
    }

    public ArrayList<SelectItem> getBudjetYearList() {
        return budjetYearList;
    }

    public void setBudjetYearList(ArrayList<SelectItem> budjetYearList) {
        this.budjetYearList = budjetYearList;
    }

    public ArrayList<SelectItem> getBatchList() {
        return batchList;
    }

    public ArrayList<SelectItem> getProgressList() {
        return progressList;
    }

    public void setProgressList(ArrayList<SelectItem> progressList) {
        this.progressList = progressList;
    }

    public void setBatchList(ArrayList<SelectItem> batchList) {
        this.batchList = batchList;
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

    public InstitutionRegistrationManager getInstitutionRegistrationManager() {
        return institutionRegistrationManager;
    }

    public void setInstitutionRegistrationManager(InstitutionRegistrationManager institutionRegistrationManager) {
        this.institutionRegistrationManager = institutionRegistrationManager;
    }

    public int getInstitutionTrainingId() {
        return institutionTrainingId;
    }

    public void setInstitutionTrainingId(int institutionTrainingId) {
        this.institutionTrainingId = institutionTrainingId;
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
    private HtmlSelectManyListbox selManyNotTrainnedEmployees = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelManyNotTrainnedEmployees() {
        return selManyNotTrainnedEmployees;
    }

    public void setSelManyNotTrainnedEmployees(HtmlSelectManyListbox hsml) {
        this.selManyNotTrainnedEmployees = hsml;
    }
    private HtmlSelectManyListbox selManTrainnedEmployees = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelManTrainnedEmployees() {
        return selManTrainnedEmployees;
    }

    public void setSelManTrainnedEmployees(HtmlSelectManyListbox hsml) {
        this.selManTrainnedEmployees = hsml;
    }
    private HtmlSelectOneMenu drlTrainingBatch = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainingBatch() {
        return drlTrainingBatch;
    }

    public void setDrlTrainingBatch(HtmlSelectOneMenu hsom) {
        this.drlTrainingBatch = hsom;
    }
    private HtmlSelectOneMenu drlBudjetYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBudjetYear() {
        return drlBudjetYear;
    }

    public void setDrlBudjetYear(HtmlSelectOneMenu hsom) {
        this.drlBudjetYear = hsom;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlInputTextarea txtaRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaRemark() {
        return txtaRemark;
    }

    public void setTxtaRemark(HtmlInputTextarea hit) {
        this.txtaRemark = hit;
    }
    private HtmlInputText txtRecieptNumber = new HtmlInputText();

    public HtmlInputText getTxtRecieptNumber() {
        return txtRecieptNumber;
    }

    public void setTxtRecieptNumber(HtmlInputText hit) {
        this.txtRecieptNumber = hit;
    }
    private HtmlInputText txtCostName = new HtmlInputText();

    public HtmlInputText getTxtCostName() {
        return txtCostName;
    }

    public void setTxtCostName(HtmlInputText hit) {
        this.txtCostName = hit;
    }
    private HtmlInputText txtFactor = new HtmlInputText();

    public HtmlInputText getTxtFactor() {
        return txtFactor;
    }

    public void setTxtFactor(HtmlInputText hit) {
        this.txtFactor = hit;
    }
    private HtmlSelectOneMenu drlCostCategories = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCostCategories() {
        return drlCostCategories;
    }

    public void setDrlCostCategories(HtmlSelectOneMenu hsom) {
        this.drlCostCategories = hsom;
    }
    private HtmlInputText txtUnitCost = new HtmlInputText();

    public HtmlInputText getTxtUnitCost() {
        return txtUnitCost;
    }

    public void setTxtUnitCost(HtmlInputText hit) {
        this.txtUnitCost = hit;
    }
    private HtmlInputText txtTotalCost = new HtmlInputText();

    public HtmlInputText getTxtTotalCost() {
        return txtTotalCost;
    }

    public void setTxtTotalCost(HtmlInputText hit) {
        this.txtTotalCost = hit;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlSelectOneMenu drlTrainning = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainning() {
        return drlTrainning;
    }

    public DefaultSelectedData getSelectedRequestFromProgressList() {
        return selectedRequestFromProgressList;
    }

    public void setSelectedRequestFromProgressList(DefaultSelectedData selectedRequestFromProgressList) {
        this.selectedRequestFromProgressList = selectedRequestFromProgressList;
    }

    public void setDrlTrainning(HtmlSelectOneMenu hsom) {
        this.drlTrainning = hsom;
    }
    private HtmlSelectOneMenu drlProgressStatus = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProgressStatus() {
        return drlProgressStatus;
    }

    public void setDrlProgressStatus(HtmlSelectOneMenu hsom) {
        this.drlProgressStatus = hsom;
    }
    private HtmlInputText txtPaymentDate = new HtmlInputText();

    public HtmlInputText getTxtPaymentDate() {
        return txtPaymentDate;
    }

    public void setTxtPaymentDate(HtmlInputText hit) {
        this.txtPaymentDate = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calPaymentDate = new SelectInputDate();

    public SelectInputDate getCalPaymentDate() {
        return calPaymentDate;
    }

    public void setCalPaymentDate(SelectInputDate sid) {
        this.calPaymentDate = sid;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private SelectInputDateBean selectInputDateBean3 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean3() {
        return selectInputDateBean3;
    }

    public void setSelectInputDateBean3(SelectInputDateBean sidb) {
        this.selectInputDateBean3 = sidb;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate sid) {
        this.calEndDate = sid;
    }
    private HtmlCommandButton btnCalStartDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalStartDate() {
        return btnCalStartDate;
    }

    public void setBtnCalStartDate(HtmlCommandButton hcb) {
        this.btnCalStartDate = hcb;
    }
    private HtmlCommandButton btnCalEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalEndDate() {
        return btnCalEndDate;
    }

    public void setBtnCalEndDate(HtmlCommandButton hcb) {
        this.btnCalEndDate = hcb;
    }
    private HtmlInputText txtNoOfDays = new HtmlInputText();

    public HtmlInputText getTxtNoOfDays() {
        return txtNoOfDays;
    }

    public void setTxtNoOfDays(HtmlInputText hit) {
        this.txtNoOfDays = hit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TrainingProgressPage() {
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

    public ArrayList<DisciplineRequestModel> getAllCommittedOffencesOfEmployee() {
        return allCommittedOffencesOfEmployee;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }

    public String getSaveOrUpdateLabel() {
        return saveOrUpdateLabel;
    }

    public void setSaveOrUpdateLabel(String saveOrUpdateLabel) {
        this.saveOrUpdateLabel = saveOrUpdateLabel;
    }

    public ArrayList<EducationCostModel> getTrainingCostList() {
        return trainingCostList;
    }

    public void setTrainingCostList(ArrayList<EducationCostModel> trainingCostList) {
        this.trainingCostList = trainingCostList;
    }

    public ArrayList<SelectItem> getCostCategoryList() {
        return costCategoryList;
    }

    public void setCostCategoryList(ArrayList<SelectItem> costCategoryList) {
        this.costCategoryList = costCategoryList;
    }

    public ArrayList<SelectItem> getPendingRequestList() {
        return pendingRequestList;
    }

    public void setPendingRequestList(ArrayList<SelectItem> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public void setAllCommittedOffencesOfEmployee(ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee) {
        this.allCommittedOffencesOfEmployee = allCommittedOffencesOfEmployee;
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

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public ArrayList<SelectItem> getTrainnedEmployeesList() {
        return trainnedEmployeesList;
    }

    public void setTrainnedEmployeesList(ArrayList<SelectItem> trainnedEmployeesList) {
        this.trainnedEmployeesList = trainnedEmployeesList;
    }

    public ArrayList<SelectItem> getNotTrainedEmployeesList() {
        return notTrainedEmployeesList;
    }

    public void setNotTrainedEmployeesList(ArrayList<SelectItem> notTrainedEmployeesList) {
        this.notTrainedEmployeesList = notTrainedEmployeesList;
    }

    public ArrayList<SelectItem> getNotTrainnedEmployeesForSwap() {
        return notTrainnedEmployeesForSwap;
    }

    public void setNotTrainnedEmployeesForSwap(ArrayList<SelectItem> notTrainnedEmployeesForSwap) {
        this.notTrainnedEmployeesForSwap = notTrainnedEmployeesForSwap;
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

    public DefaultSelectedData getSelectedRequestFromTrainnerTypeList() {
        return selectedRequestFromTrainnerTypeList;
    }

    public void setSelectedRequestFromTrainnerTypeList(DefaultSelectedData selectedRequestFromTrainnerTypeList) {
        this.selectedRequestFromTrainnerTypeList = selectedRequestFromTrainnerTypeList;
    }

    public DefaultSelectedData getSelectedRequestFromBatchList() {
        return selectedRequestFromBatchList;
    }

    public void setSelectedRequestFromBatchList(DefaultSelectedData selectedRequestFromBatchList) {
        this.selectedRequestFromBatchList = selectedRequestFromBatchList;
    }

    public DefaultSelectedData getSelectedRequestFromMyBudjetYearList() {
        return selectedRequestFromMyBudjetYearList;
    }

    public void setSelectedRequestFromMyBudjetYearList(DefaultSelectedData selectedRequestFromMyBudjetYearList) {
        this.selectedRequestFromMyBudjetYearList = selectedRequestFromMyBudjetYearList;
    }

    public TrainingLookupManger getTrainingLookupManger() {
        return trainingLookupManger;
    }

    public void setTrainingLookupManger(TrainingLookupManger trainingLookupManger) {
        this.trainingLookupManger = trainingLookupManger;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public PanelPopup getPnlPopupCostRegistration() {
        return pnlPopupCostRegistration;
    }

    public void setPnlPopupCostRegistration(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupCostRegistration = pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
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

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public EducationCostModel getEducationCostModel() {
        return educationCostModel;
    }

    public void setEducationCostModel(EducationCostModel educationCostModel) {
        this.educationCostModel = educationCostModel;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public int getQuantityOrAmount() {
        return quantityOrAmount;
    }

    public void setQuantityOrAmount(int quantityOrAmount) {
        this.quantityOrAmount = quantityOrAmount;
    }

    public String getRecieptNumber() {
        return recieptNumber;
    }

    public void setRecieptNumber(String recieptNumber) {
        this.recieptNumber = recieptNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public DefaultSelectedData getSelectedEmployeesFromNotTrainnedList() {
        return selectedEmployeesFromNotTrainnedList;
    }

    public void setSelectedEmployeesFromNotTrainnedList(DefaultSelectedData selectedEmployeesFromNotTrainnedList) {
        this.selectedEmployeesFromNotTrainnedList = selectedEmployeesFromNotTrainnedList;
    }

    public DefaultSelectedData getSelectedEmployeesFromTrainnedList() {
        return selectedEmployeesFromTrainnedList;
    }

    public void setSelectedEmployeesFromTrainnedList(DefaultSelectedData selectedEmployeesFromTrainnedList) {
        this.selectedEmployeesFromTrainnedList = selectedEmployeesFromTrainnedList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public TrainingProgressModel getTrainingProgressModel() {
        return trainingProgressModel;
    }

    public void setTrainingProgressModel(TrainingProgressModel trainingProgressModel) {
        this.trainingProgressModel = trainingProgressModel;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<SelectItem> getTrainingsList() {
        return trainingsList;
    }

    public void setTrainingsList(ArrayList<SelectItem> trainingsList) {
        this.trainingsList = trainingsList;
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
    private PanelPopup pnlPopupCostRegistration = new PanelPopup();

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupCostRegistration.setRendered(false);
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
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    private void clearAllComponenets() {
        //  clearRequesterTextComponents();
        notTrainedEmployeesList = new ArrayList<SelectItem>();
        trainnedEmployeesList = new ArrayList<SelectItem>();
    //
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
    EmployeeManage employeeManager = new EmployeeManage();
    int institutionTrainingId;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    TrainingLookupManger trainingLookupManger = new TrainingLookupManger();
    TrainingProgressModel trainingProgressModel = new TrainingProgressModel();
    EducationCostModel educationCostModel = new EducationCostModel();
    TrainingProgressManager trainingProgressManager = new TrainingProgressManager();
    ActionPlanManager actionPlanManager = new ActionPlanManager();
    InstitutionRegistrationManager institutionRegistrationManager = new InstitutionRegistrationManager();
    TrainingNeedAssessementRequestManager assessementRequestManager = new TrainingNeedAssessementRequestManager();
    ArrayList<EducationCostModel> trainingCostList = new ArrayList<EducationCostModel>();
    ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee = new ArrayList<DisciplineRequestModel>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    String saveOrUpdateLabel = "Save";
    //================================================================================================
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromProgressList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromMyBudjetYearList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromBatchList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromTrainnerTypeList = new DefaultSelectedData();
    private DefaultSelectedData selectedEmployeesFromTrainnedList = new DefaultSelectedData();
    private DefaultSelectedData selectedEmployeesFromNotTrainnedList = new DefaultSelectedData();
    Object[] selectedItemsFromNotTrainned;
    Object[] selectedItemsFromTrainned;
    //===============================================================================================
    ArrayList<SelectItem> notTrainnedEmployeesForSwap = new ArrayList<SelectItem>();
    ArrayList<SelectItem> trainnedEmployeesList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> notTrainedEmployeesList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> batchList = trainingProgressManager.getBatchLists();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> progressList = trainingProgressManager.getProgressTypes();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> budjetYearList = trainingLookupManger.getAllBudgetYears();// ArrayList<SelectItem>();
    ArrayList<SelectItem> trainingsList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> costCategoryList = new ArrayList<SelectItem>();

    //===================================================================
    String requesterId;
    int progressId;
    String progressStatus;
    String budjetYear;
    int trainingId;
    String batchCode;
    String startDate;
    String endDate;
    String timeStamp;
    String userName;
    //===================================================================
    String costTypeId;
    String costTypeCategory;
    String costTypeName;
    int quantityOrAmount;
    double unitCost;
    double totalCost;
    String remark;
    String recieptNumber;
    String paymentDate;
    String databaseStatus;
    //===================================================================

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
    }

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
    }

    public void selManyNotTrainnedEmployees_processValueChange(ValueChangeEvent vce) {
    }

    public void RetirementApproval_processMyEvent(DragEvent de) {
    }

    public void drlBudjetYear_processValueChange(ValueChangeEvent vce) {
//        selectedRequestFromTrainnerTypeList.setSelectedObject(null);//reset
//        selectedRequestFromInstitutionList.setSelectedObject(null);//reset drlInstitutionToAssign
        trainnedEmployeesList = new ArrayList<SelectItem>();//clear
//        budjetYear = vce.getNewValue().toString();



        if (!(vce == null || vce.getNewValue().toString().equals("-1"))) {
            budjetYear = vce.getNewValue().toString();
            trainingsList = actionPlanManager.getApprovedTrainingTypes(budjetYear); //actionPlanManager.getApprovedNeedRequests(budjetYear);
        // notTrainedEmployeesList = actionPlanManager.getApprovedButNotAssignedNeedRequests(budjetYear);
        }

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

    public void drlTrainingBatch_processValueChange(ValueChangeEvent vce) {
        if (!(vce == null || vce.getNewValue().toString().equals("-1"))) {
            if (budjetYear == null || budjetYear.equals("-1")) {
                showSuccessOrFailureMessage(false, " SELECT BUDJET YEAR FIRST ");
            } else {
                batchCode = vce.getNewValue().toString();
                progressId = trainingProgressManager.getProgressStatus(budjetYear, trainingId, batchCode);

                if (progressId != -1) {//check if the batch is already registered
                    trainnedEmployeesList = trainingProgressManager.getTrainnedEmployees(budjetYear, trainingId, batchCode);
                    populateBatchAttributes(progressId);
                    makePageReadyForUpdate();
                } else {//no data exist for this batch
                    trainnedEmployeesList = new ArrayList<SelectItem>();
                    makePageReadyForSave();
                }
            }
        }
    }

    public String btnAddToGroup_action() {
        if (!(drlTrainingBatch.getValue() == null || drlTrainingBatch.getValue().toString().equals("-1"))) {
            selectedItemsFromNotTrainned = selManyNotTrainnedEmployees.getSelectedValues();
            Iterator<SelectItem> it = notTrainedEmployeesList.iterator();
            while (it.hasNext()) {
                Object current = it.next();
                for (int counter = 0; counter < selectedItemsFromNotTrainned.length; counter++) {
                    if (((SelectItem) current).getValue().toString().equals(selectedItemsFromNotTrainned[counter].toString())) {
                        trainnedEmployeesList.add(((SelectItem) current));
                        it.remove();
                    }
                }
            }
        }
        return null;
    }

    public String btnRemoveFromGroup_action() {
        selectedItemsFromTrainned = selManTrainnedEmployees.getSelectedValues();
        Iterator<SelectItem> it = trainnedEmployeesList.iterator();
        while (it.hasNext()) {
            Object current = it.next();
            for (int counter = 0; counter < selectedItemsFromTrainned.length; counter++) {
                if (((SelectItem) current).getValue().toString().equals(selectedItemsFromTrainned[counter].toString())) {
                    notTrainedEmployeesList.add(((SelectItem) current));
                    it.remove();
                }
            }
        }
        return null;
    }

    public String btnAddAllToGroup_action() {
        if (notTrainedEmployeesList != null) {
            if (trainnedEmployeesList != null) {
                for (SelectItem current : notTrainedEmployeesList) {
                    trainnedEmployeesList.add(current);
                }
            } else {
                trainnedEmployeesList = new ArrayList<SelectItem>();
                for (SelectItem current : notTrainedEmployeesList) {
                    trainnedEmployeesList.add(current);
                }
            }
            notTrainedEmployeesList.clear();
        }
        return null;
    }

    public String btnRemoveAllFromGroup_action() {
        if (trainnedEmployeesList != null) {
            if (trainnedEmployeesList != null) {
                for (SelectItem current : trainnedEmployeesList) {
                    notTrainedEmployeesList.add(current);
                }
            } else {
                notTrainedEmployeesList = new ArrayList<SelectItem>();//if null initialize
                for (SelectItem current : trainnedEmployeesList) {
                    notTrainedEmployeesList.add(current);
                }
            }
            trainnedEmployeesList.clear();
        }
        return null;
    }

    public String btnResetCost_action() {
        clearAllComponenets();
        return null;
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

    public void panelTabSetAssign_processTabChange(TabChangeEvent tce) {
    }

    public String btnSaveCost_action() {
        if (saveOrUpdateLabel.equals("Save")) {
        } else {// if (saveOrUpdateLabel.equals("Update")) {
        }
        return null;
    }

//    if (vce.getNewValue() != null) {
//            if (vce.getNewValue().toString().indexOf("-") > 0) {
//            trainingId = Integer.parseInt(vce.getNewValue().toString().split("-")[0]);
//            notTrainedEmployeesList = trainingProgressManager.getNotTrainnedEmployees(budjetYear, trainingId);
//            notTrainnedEmployeesForSwap = notTrainedEmployeesList;
//
//          }
//        }

    public void drlTrainning_processValueChange(ValueChangeEvent vce) {
          if (vce.getNewValue() != null) {
            if (vce.getNewValue().toString().indexOf("-") > 0) {
              trainingId = Integer.parseInt(vce.getNewValue().toString().split("-")[0]);
              notTrainedEmployeesList = trainingProgressManager.getNotTrainnedEmployees(budjetYear, trainingId);
              notTrainnedEmployeesForSwap = notTrainedEmployeesList;

          }
        }
//        if (vce != null && !vce.getNewValue().toString().split("-")[0].equals("-1")) {
//            trainingId = Integer.parseInt(vce.getNewValue().toString().split("-")[0]);
//            notTrainedEmployeesList = trainingProgressManager.getNotTrainnedEmployees(budjetYear, trainingId);
//            notTrainnedEmployeesForSwap = notTrainedEmployeesList;
//
//        }
    }

    public String btnAddToTable_action() {
        if (validateAndInitializeCostAttributes()) {
            educationCostModel = new EducationCostModel(costTypeId, costTypeCategory, costTypeName, budjetYear, trainingId, quantityOrAmount, unitCost, totalCost, recieptNumber, paymentDate, "New");
            trainingCostList.add(educationCostModel);
        }
        return null;
    }

    private void makePageReadyForSave() {
        saveOrUpdateLabel = "Save";
        btnCalStartDate.setDisabled(false);
        btnCalEndDate.setDisabled(false);
    }

    private void makePageReadyForUpdate() {
        saveOrUpdateLabel = "Update";
        btnCalStartDate.setDisabled(true);
        btnCalEndDate.setDisabled(true);
    }

    private boolean validateAndInitializeCostAttributes() {
        try {
            costTypeName = txtCostName.getValue().toString();
            quantityOrAmount = Integer.parseInt(txtFactor.getValue().toString());
            recieptNumber = txtRecieptNumber.getValue() == null ? "" : txtRecieptNumber.getValue().toString();
            unitCost = Double.parseDouble(txtUnitCost.getValue().toString());
            costTypeCategory = drlCostCategories.getValue().toString();
            remark = txtaRemark.getValue() == null ? "" : txtaRemark.getValue().toString();
            paymentDate = txtPaymentDate.getValue() == null ? "" : txtPaymentDate.getValue().toString();
            databaseStatus = "New";
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "ALL DIELDS NEED TO FILLED");
            return false;
        } catch (NumberFormatException nfe) {
            showSuccessOrFailureMessage(false, "CHECH MONITARY VALUES");
        }
        return true;
    }

    private boolean validateAndInitializeProgressAttributes() {
        try {
            budjetYear = drlBudjetYear.getValue().toString();
            batchCode = drlTrainingBatch.getValue().toString();
            trainingId = Integer.parseInt(drlTrainning.getValue().toString().split("-")[0]);//Integer.parseInt(vce.getNewValue().toString());
//            startDate = txtStartDate.getValue().toString();
//            endDate = txtEndDate.getValue().toString();
//            progressStatus = drlProgressStatus.getValue().toString();
            if (budjetYear.equals("-1") || batchCode.equals("-1") || progressStatus.equals("-1") || trainingId == -1) {
                showSuccessOrFailureMessage(false, "ALL FIELDS NEED TO FILLED");
                return false;
            }
        } catch (NullPointerException npe) {

//            showSuccessOrFailureMessage(false, "ALL FIELDS NEED TO FILLED");
//            return false;
        }
        return true;
    }

    public boolean validateDate() {

        String filterYear = null;
        int startY = 0;
        int budjetY = 0;
        String startD = txtStartDate.getValue().toString();
            filterYear = startD.substring(0,4);
            startY = Integer.parseInt(filterYear);
            budjetY = Integer.parseInt(budjetYear);
        Date selectedStartDate = (Date) calStartDate.getValue();
        Date selectedendDate = (Date) calEndDate.getValue();//calTerminationDate.getValue();
//        long dateDifference = (selectedTerminationDate.getTime() - selectedAppliedDate.getTime()) / (1000 * 60 * 60 * 24);
//        double Salary = Double.valueOf(txtSalary.getValue().toString());
         if ((!(selectedStartDate.before(selectedendDate))) && (saveOrUpdateLabel.equals("Save"))) {
            showSuccessOrFailureMessage(false, "YOU USED A START DATE AFTER END DATE \n IMPOSSIBLE");
            return false;
        }
         if(startY != budjetY){
            showSuccessOrFailureMessage(false, "YOU USED A START DATE NOT THE SAME AS BUDJET YEAR \n IMPOSSIBLE");
            return false;
         }
            return true;


     }

    public String btnSaveTrainnedEmployees_action() {
        if (validateAndInitializeProgressAttributes()) {
//            if(validateDate()){
            startDate = txtStartDate.getValue().toString();
            endDate = txtEndDate.getValue().toString();
            trainingProgressModel = new TrainingProgressModel(progressId, budjetYear, trainingId, batchCode, progressStatus, startDate, endDate);
            if (saveOrUpdateLabel.equals("Save")) {
                if (trainingProgressManager.saveProgressChanges(trainingProgressModel, trainnedEmployeesList, notTrainedEmployeesList)) {
                    showSuccessOrFailureMessage(true, "SAVED");
                } else {
                    showSuccessOrFailureMessage(false, "FAILED");
                }
            } else {// if (saveOrUpdateLabel.equals("Update")) {
                if (trainingProgressManager.updateProgressChanges(trainingProgressModel, trainnedEmployeesList, notTrainedEmployeesList)) {
                    showSuccessOrFailureMessage(true, "UPDATED");
                } else {
                    showSuccessOrFailureMessage(false, "FAILED");
                }
//            }
          }
        }
        return null;
    }

    public String btnCalPaymentDate_action() {
        calPaymentDate.setRendered(true);
        return null;
    }

    public void calPaymentDate_processValueChange(ValueChangeEvent vce) {
        txtPaymentDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calPaymentDate.setRendered(false);
    }

    public String btnCalStartDate_action() {
        calStartDate.setRendered(true);
        return null;
    }

    public String btnCalEndDate_action() {
        calEndDate.setRendered(true);
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        txtEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calEndDate.setRendered(false);
    }

    public void drlProgressStatus_processValueChange(ValueChangeEvent vce) {
        if (!(vce == null || vce.getNewValue().toString().equals("-1"))) {
            progressStatus = vce.getNewValue().toString();
//            trainingsList = actionPlanManager.getApprovedTrainingTypes(budjetYear); //actionPlanManager.getApprovedNeedRequests(budjetYear);
        // notTrainedEmployeesList = actionPlanManager.getApprovedButNotAssignedNeedRequests(budjetYear);
        }
    }

    
}
