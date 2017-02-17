/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Questionnaire;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import entity.trainingEntity.TrainingRequestEntity;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.questionnaire.DefineQuestionnaireManager;
import manager.trainingManager.TrainingContoller;
import manager.questionnaire.QuestionnaireManager;
import manager.terminationManager.TerminationApproveManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Questionnaire.java
 * @version Created on Oct 24, 2011, 10:05:31 AM
 * @author Bini
 */
public class AssignQuestionnaire extends AbstractPageBean {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    QuestionnaireManager quesManager = new QuestionnaireManager();
    DefineQuestionnaireManager defQuesMnger = new DefineQuestionnaireManager();
    TrainingContoller propTrainingManager = new TrainingContoller();
    TerminationApproveManager terminationApproveManager = new TerminationApproveManager();
    ArrayList<QuestionnaireManager> quesManagerList = new ArrayList<QuestionnaireManager>();
    ArrayList<SelectItem> definedQuesList = new ArrayList<SelectItem>();
    public ArrayList<SelectItem> proposedjob = null;
    int selectedRowIndex = -1;
    private static int defQuesId = 0;
    String loggedInUserId = this.getSessionBean1().getEmployeeId();
    boolean load = false;

    /**
     * @return the definedQuesList
     */
    public ArrayList<SelectItem> getDefinedQuesList() {
        return defQuesMnger.getQuestionnaireTitles();
    }

    /**
     * @param definedQuesList the definedQuesList to set
     */
    public void setDefinedQuesList(ArrayList<SelectItem> definedQuesList) {
        this.definedQuesList = definedQuesList;
    }

    public ArrayList<QuestionnaireManager> getQuesManagerList() {
        return quesManager.selectQuestionnaire();
    }

    public void setQuesManagerList(ArrayList<QuestionnaireManager> quesManagerList) {
        this.quesManagerList = quesManagerList;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private ArrayList<SelectItem> employeeWithProcessedRequests;

    public ArrayList<SelectItem> getEmployeeWithProcessedRequests() {
        if (defQuesId == 1) {
            TrainingRequestEntity termEntity = new TrainingRequestEntity();

            ArrayList<TrainingRequestEntity> approvedTrainingRequests = quesManager.readEmployeeTrainingRequests();
            employeeWithProcessedRequests = new ArrayList<SelectItem>();
            for (int i = 0; i < approvedTrainingRequests.size(); i++) {
                termEntity = approvedTrainingRequests.get(i);
                SelectItem training = new SelectItem(
                        termEntity.getTrainingRequestID(),
                        termEntity.getTrainingRequestName());
                employeeWithProcessedRequests.add(training);
            }
        } else if (defQuesId == 2) {
          //  employeeWithProcessedRequests = terminationApproveManager.getApprovedTermination();
        }
        return employeeWithProcessedRequests;
    }

    public void setProposedjob(ArrayList<SelectItem> proposedjob) {
        this.proposedjob = proposedjob;

    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultSelectedData selectOneListbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox2Bean() {
        return selectOneListbox2Bean;
    }

    public void setSelectOneListbox2Bean(DefaultSelectedData dsd) {
        this.selectOneListbox2Bean = dsd;
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
    private DefaultSelectedData selectOneRadio2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio2Bean() {
        return selectOneRadio2Bean;
    }

    public void setSelectOneRadio2Bean(DefaultSelectedData dsd) {
        this.selectOneRadio2Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio2DefaultItems() {
        return selectOneRadio2DefaultItems;
    }

    public void setSelectOneRadio2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio2DefaultItems = dsi;
    }
    private HtmlOutputText txtPrparedBy = new HtmlOutputText();

    public HtmlOutputText getTxtPrparedBy() {
        return txtPrparedBy;
    }

    public void setTxtPrparedBy(HtmlOutputText hot) {
        this.txtPrparedBy = hot;
    }
    private HtmlInputText txtPrpeparedOn = new HtmlInputText();

    public HtmlInputText getTxtPrpeparedOn() {
        return txtPrpeparedOn;
    }

    public void setTxtPrpeparedOn(HtmlInputText hit) {
        this.txtPrpeparedOn = hit;
    }
    private HtmlCommandButton btnCalPrep = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalPrep() {
        return btnCalPrep;
    }

    public void setBtnCalPrep(HtmlCommandButton hcb) {
        this.btnCalPrep = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlInputText txtFromDate = new HtmlInputText();

    public HtmlInputText getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtFromDate(HtmlInputText hit) {
        this.txtFromDate = hit;
    }
    private HtmlOutputText txtEventDescription = new HtmlOutputText();

    public HtmlOutputText getTxtEventDescription() {
        return txtEventDescription;
    }

    public void setTxtEventDescription(HtmlOutputText hot) {
        this.txtEventDescription = hot;
    }
    private HtmlInputText txtToDate = new HtmlInputText();

    public HtmlInputText getTxtToDate() {
        return txtToDate;
    }

    public void setTxtToDate(HtmlInputText hit) {
        this.txtToDate = hit;
    }
    private HtmlOutputText txtJobCode = new HtmlOutputText();

    public HtmlOutputText getTxtJobCode() {
        return txtJobCode;
    }

    public void setTxtJobCode(HtmlOutputText hot) {
        this.txtJobCode = hot;
    }
    private HtmlCommandButton btnCalTo = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalTo() {
        return btnCalTo;
    }

    public void setBtnCalTo(HtmlCommandButton hcb) {
        this.btnCalTo = hcb;
    }
    private HtmlCommandButton btnCalFrom = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalFrom() {
        return btnCalFrom;
    }

    public void setBtnCalFrom(HtmlCommandButton hcb) {
        this.btnCalFrom = hcb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calFromDate = new SelectInputDate();

    public SelectInputDate getCalFromDate() {
        return calFromDate;
    }

    public void setCalFromDate(SelectInputDate sid) {
        this.calFromDate = sid;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calToDate = new SelectInputDate();

    public SelectInputDate getCalToDate() {
        return calToDate;
    }

    public void setCalToDate(SelectInputDate sid) {
        this.calToDate = sid;
    }
    private SelectInputDateBean selectInputDateBean3 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean3() {
        return selectInputDateBean3;
    }

    public void setSelectInputDateBean3(SelectInputDateBean sidb) {
        this.selectInputDateBean3 = sidb;
    }
    private SelectInputDate calPreparedOn = new SelectInputDate();

    public SelectInputDate getCalPreparedOn() {
        return calPreparedOn;
    }

    public void setCalPreparedOn(SelectInputDate sid) {
        this.calPreparedOn = sid;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private HtmlSelectOneMenu somQuestionnaire1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSomQuestionnaire1() {
        return somQuestionnaire1;
    }

    public void setSomQuestionnaire1(HtmlSelectOneMenu hsom) {
        this.somQuestionnaire1 = hsom;
    }
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AssignQuestionnaire() {
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
        this.txtPrparedBy.setValue(this.getSessionBean1().getEmployeeName());
        this.txtPrpeparedOn.setValue(dateFormat.format(new Date()));
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
            log("Questionnaire Initialization Failure", e);
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
        if (!isPostBack()) {
//            empId = this.getSessionBean1().getEmployeeId();
            txtPrparedBy.setValue(getSessionBean1().getEmployeeName());
        }
        if (!load) {
            setQuesManagerList(quesManager.selectQuestionnaire());
            load = true;
        }
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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

    public String cmdQuestions_action() {
        return "ManageQuestions";
    }

    public String cmdQuestionnaire_action() {
        return "GenerateQuestionnairs";
    }

    public String cmdAnalyzeReGrading_action() {
        return "AnalyzeReGradingRequest";
    }

    public String cmdAnalyzeGrading_action() {
        return "AnalyzeGradingRequest";
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage.setValue(messageToDisplay);
        lblFormMessage.setVisible(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "8000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public String btnCalPrep_action() {
        calPreparedOn.setRendered(true);
        return null;
    }

    public String btnCalTo_action() {
        calToDate.setRendered(true);
        return null;
    }

    public String btnCalFrom_action() {
        calFromDate.setRendered(true);
        return null;
    }

    public void calFromDate_processValueChange(ValueChangeEvent vce) {
        txtFromDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calFromDate.setRendered(false);
    }

    public void calToDate_processValueChange(ValueChangeEvent vce) {
        txtToDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calToDate.setRendered(false);
    }

    public void calPreparedOn_processValueChange(ValueChangeEvent vce) {
        txtPrpeparedOn.setValue(dateFormat.format((Date) vce.getNewValue()));
        calPreparedOn.setRendered(false);
    }

    private void clearComponents() {
        txtJobCode.setValue(":");
        txtEventDescription.setValue(":");
        txtRemark.resetValue();
        txtFromDate.resetValue();
        txtToDate.resetValue();
        txtPrpeparedOn.resetValue();
    }

    private void setDisableComponents(boolean result) {
        txtRemark.setDisabled(result);
        txtFromDate.setDisabled(result);
        txtToDate.setDisabled(result);
        txtPrpeparedOn.setDisabled(result);
        btnCalFrom.setDisabled(result);
        btnCalTo.setDisabled(result);
        btnCalPrep.setDisabled(result);
    }

    private QuestionnaireManager saveQuestionnaire() {
        String questionnairId = null;

        if (somQuestionnaire1.getValue() != null) {
            questionnairId = somQuestionnaire1.getValue().toString();
        } else {
            questionnairId = String.valueOf(getQuesManagerList().get(selectedRowIndex).getQuestionnaireId());
        }
        QuestionnaireManager quesMana = new QuestionnaireManager(
                txtJobCode.getValue().toString(),
                txtRemark.getValue().toString(),
                txtFromDate.getValue().toString(),
                txtToDate.getValue().toString(),
                loggedInUserId,
                txtPrpeparedOn.getValue().toString(),
                questionnairId);
        if (selectedRowIndex > -1) {
            quesMana.setQuestionnaireId(getQuesManagerList().get(selectedRowIndex).getQuestionnaireId());
        }
        return quesMana;
    }

    public void rowSelectorOption_processMyEvent(RowSelectorEvent rse) {
        selectedRowIndex = rse.getRow();

        if (!rse.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            rse.setPhaseId(PhaseId.INVOKE_APPLICATION);
            rse.queue();
            return;
        }
        if (selectedRowIndex > -1) {
            String questionnairId = getQuesManagerList().get(selectedRowIndex).getDefQuesId();
            txtJobCode.setValue(getQuesManagerList().get(selectedRowIndex).getJobCode());
            txtEventDescription.setValue(getQuesManagerList().get(selectedRowIndex).getJobTitle());
            txtRemark.setValue(getQuesManagerList().get(selectedRowIndex).getQuestDescription());
            txtFromDate.setValue(getQuesManagerList().get(selectedRowIndex).getFromDate());
            txtToDate.setValue(getQuesManagerList().get(selectedRowIndex).getToDate());
            somQuestionnaire1.setValue(questionnairId);
            btnEdit.setDisabled(false);
            btnDelete.setDisabled(false);
        }
    }

    public String btnNew_action() {
        clearComponents();
        setDisableComponents(false);
        btnSave.setDisabled(false);
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        return null;
    }

    public String btnSave_action() {

        if (quesManager.saveQuestionnaire(saveQuestionnaire())) {
            showSuccessOrFailureMessage(true, "Event Added to Questionnaire successfully");
            selectedRowIndex = -1;
            btnSave.setDisabled(true);
            load = false;
        } else {
            showSuccessOrFailureMessage(false, "Error occured while adding  this Event.Please try again later.");
        }
        return null;
    }

    public String btnEdit_action() {
        if (selectedRowIndex > -1) {
            setDisableComponents(false);
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(true);
            btnSave.setDisabled(true);
        }
        return null;
    }

    public String btnUpdate_action() {
        if (selectedRowIndex > -1) {
            if (quesManager.updateQuestionnaire(saveQuestionnaire())) {
                showSuccessOrFailureMessage(true, "Event information is updated successfully");
                selectedRowIndex = -1;
                btnUpdate.setDisabled(true);
                btnDelete.setDisabled(true);
                load = false;
            } else {
                showSuccessOrFailureMessage(false, "Error occured while updating  this Event.Please try again later.");
            }
        }
        return null;
    }

    public String btnDelete_action() {
        if (selectedRowIndex > -1) {
            if (quesManager.deleteQuestionnaire(getQuesManagerList().get(selectedRowIndex).getQuestionnaireId())) {
                showSuccessOrFailureMessage(true, "Event information is deleted successfully");
                selectedRowIndex = -1;
                btnUpdate.setDisabled(true);
                btnDelete.setDisabled(true);
                load = false;
            } else {
                showSuccessOrFailureMessage(false, "Error occured while deleting  this Event.Please try again later.");
            }
        }
        return null;
    }

    public void somQuestionnaire1_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            defQuesId = Integer.parseInt(quesManager.getItemDesc(getDefinedQuesList(), vce.getNewValue()));
        } else {
            defQuesId = 0;
        }
        this.getEmployeeWithProcessedRequests();
//        this.getAllQuestionList();
    }

    public void lisDefinedQues_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            clearComponents();
            txtJobCode.setValue(vce.getNewValue().toString());
            txtEventDescription.setValue(quesManager.getItemLabel(getEmployeeWithProcessedRequests(), vce.getNewValue()));
            btnSave.setDisabled(false);
        }
    }

    public void lisPropJob_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            clearComponents();
            String eventDesc = quesManager.getItemLabel(getEmployeeWithProcessedRequests(), vce.getNewValue()).toString();
            txtJobCode.setValue(vce.getNewValue().toString().substring(0,
                    vce.getNewValue().toString().indexOf("--")));

            txtEventDescription.setValue("Approved Training on " + 
                    eventDesc.substring(0, eventDesc.indexOf("--")) +
                    " From " + eventDesc.substring(eventDesc.indexOf("--") + 2, eventDesc.lastIndexOf("--"))+
                    " To " + eventDesc.substring(eventDesc.lastIndexOf("--") + 2, eventDesc.length()));
            btnSave.setDisabled(false);
        }
    }
}