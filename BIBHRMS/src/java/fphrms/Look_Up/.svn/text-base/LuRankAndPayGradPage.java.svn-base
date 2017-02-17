/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Look_Up;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.ConfirmationPanelBean;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.LookUpManager;
import manager.leaveManager.LeaveTypeManager;
import javax.faces.component.UIInput;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LuRankAndPayGradPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    public ArrayList<SelectItem> payGradeScale = new ArrayList<SelectItem>();
    public ArrayList<SelectItem> rankList = new ArrayList<SelectItem>();
    private ArrayList<PayGradeInnerClass> payGradeTableList = new ArrayList<PayGradeInnerClass>();
    private ArrayList<PayGradeInnerClass> payGradeTableUpdateList = new ArrayList<PayGradeInnerClass>();
    private LookUpManager lookUpManager = new LookUpManager();
    private ConfirmationPanelBean confirmationPanelBean = new ConfirmationPanelBean();
    private static int tableSize = 0;
    private static int rowCounter = 0;
    private boolean initLoad = true;
    private static int leaveTypeId = 0;
    private int selectedPayGrade = -1;
    private String payGradeId = "";
    int buttonIdentifier;
    private int payGradeCounter = 0;
    private String oldRankID;
    private LeaveTypeManager leaveTypeManager = new LeaveTypeManager();
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public ArrayList<PayGradeInnerClass> getPayGradeTableUpdateList() {
        return payGradeTableUpdateList;
    }

    public void setPayGradeTableUpdateList(ArrayList<PayGradeInnerClass> payGradeTableUpdateList) {
        this.payGradeTableUpdateList = payGradeTableUpdateList;
    }

    public ArrayList<SelectItem> getRankList() {
        return rankList;
    }

    public void setRankList(ArrayList<SelectItem> rankList) {
        this.rankList = rankList;
    }

    public ArrayList<PayGradeInnerClass> getPayGradeTableList() {
        return payGradeTableList;
    }

    public void setPayGradeTableList(ArrayList<PayGradeInnerClass> payGradeTableList) {
        this.payGradeTableList = payGradeTableList;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        setPayGradeScale(lookUpManager.stepOfPayGrade());
        disablePayGradeComponet();
        disableRankComponet();
        disablePayGradeComponet();
        disableRankComponet();
        clearPayGradeComponet();
        clearRankComponet();
        btnAddPayGrade.setDisabled(true);
        btnDelete.setDisabled(true);
        btnSave.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnNew.setDisabled(false);
        setRankList(lookUpManager.readRankList());
        choOnlyPayGrade.setSelected(true);
    }
    private HtmlOutputLabel lblTrainingTypeId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTrainingTypeId() {
        return lblTrainingTypeId;
    }

    public void setLblTrainingTypeId(HtmlOutputLabel hol) {
        this.lblTrainingTypeId = hol;
    }
    private HtmlInputTextarea txtAreaTrainingCategoryRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtAreaTrainingCategoryRemark() {
        return txtAreaTrainingCategoryRemark;
    }

    public void setTxtAreaTrainingCategoryRemark(HtmlInputTextarea hit) {
        this.txtAreaTrainingCategoryRemark = hit;
    }
    private HtmlCommandButton btnNewTrainingCategory = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewTrainingCategory() {
        return btnNewTrainingCategory;
    }

    public void setBtnNewTrainingCategory(HtmlCommandButton hcb) {
        this.btnNewTrainingCategory = hcb;
    }
    private HtmlCommandButton btnEditTainingCategory = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditTainingCategory() {
        return btnEditTainingCategory;
    }

    public void setBtnEditTainingCategory(HtmlCommandButton hcb) {
        this.btnEditTainingCategory = hcb;
    }
    private HtmlCommandButton btnDeleteTrainingCategory = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteTrainingCategory() {
        return btnDeleteTrainingCategory;
    }

    public void setBtnDeleteTrainingCategory(HtmlCommandButton hcb) {
        this.btnDeleteTrainingCategory = hcb;
    }
    private HtmlCommandButton btnCancelTrainingCategory = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelTrainingCategory() {
        return btnCancelTrainingCategory;
    }

    public void setBtnCancelTrainingCategory(HtmlCommandButton hcb) {
        this.btnCancelTrainingCategory = hcb;
    }
    private HtmlSelectOneListbox lstTrainingCategoy = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstTrainingCategoy() {
        return lstTrainingCategoy;
    }

    public void setLstTrainingCategoy(HtmlSelectOneListbox hsol) {
        this.lstTrainingCategoy = hsol;
    }
    private HtmlOutputLabel lblCategoryID = new HtmlOutputLabel();

    public HtmlOutputLabel getLblCategoryID() {
        return lblCategoryID;
    }

    public void setLblCategoryID(HtmlOutputLabel hol) {
        this.lblCategoryID = hol;
    }
    private HtmlInputText txtRank = new HtmlInputText();

    public HtmlInputText getTxtRank() {
        return txtRank;
    }

    public void setTxtRank(HtmlInputText hit) {
        this.txtRank = hit;
    }
    private HtmlOutputLabel lblTrainerId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTrainerId() {
        return lblTrainerId;
    }

    public void setLblTrainerId(HtmlOutputLabel hol) {
        this.lblTrainerId = hol;
    }

    public ArrayList<SelectItem> getPayGradeScale() {
        return payGradeScale;
    }

    public void setPayGradeScale(ArrayList<SelectItem> payGradeScale) {
        this.payGradeScale = payGradeScale;
    }
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }

    public ConfirmationPanelBean getConfirmationPanelBean() {
        return confirmationPanelBean;
    }

    public void setConfirmationPanelBean(ConfirmationPanelBean confirmationPanelBean) {
        this.confirmationPanelBean = confirmationPanelBean;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlSelectOneMenu drlStepNo = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlStepNo() {
        return drlStepNo;
    }

    public void setDrlStepNo(HtmlSelectOneMenu hsom) {
        this.drlStepNo = hsom;
    }
    private HtmlInputText txtSarlary = new HtmlInputText();

    public HtmlInputText getTxtSarlary() {
        return txtSarlary;
    }

    public void setTxtSarlary(HtmlInputText hit) {
        this.txtSarlary = hit;
    }
    private HtmlInputText txtBigSalary = new HtmlInputText();

    public HtmlInputText getTxtBigSalary() {
        return txtBigSalary;
    }

    public void setTxtBigSalary(HtmlInputText hit) {
        this.txtBigSalary = hit;
    }
    private HtmlInputText txtMaxSalary = new HtmlInputText();

    public HtmlInputText getTxtMaxSalary() {
        return txtMaxSalary;
    }

    public void setTxtMaxSalary(HtmlInputText hit) {
        this.txtMaxSalary = hit;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox choOnlyPayGrade = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoOnlyPayGrade() {
        return choOnlyPayGrade;
    }

    public void setChoOnlyPayGrade(HtmlSelectBooleanCheckbox hsbc) {
        this.choOnlyPayGrade = hsbc;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlSelectOneListbox selectOneListbox1 = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1() {
        return selectOneListbox1;
    }

    public void setSelectOneListbox1(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1 = hsol;
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
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandButton btnAddPayGrade = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddPayGrade() {
        return btnAddPayGrade;
    }

    public void setBtnAddPayGrade(HtmlCommandButton hcb) {
        this.btnAddPayGrade = hcb;
    }
    private PanelPopup pnlPopUpMsgConf = new PanelPopup();

    public PanelPopup getPnlPopUpMsgConf() {
        return pnlPopUpMsgConf;
    }

    public void setPnlPopUpMsgConf(PanelPopup pp) {
        this.pnlPopUpMsgConf = pp;
    }
    private PanelPopup pnlPopUpSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopUpSuccessOrFailure() {
        return pnlPopUpSuccessOrFailure;
    }

    public void setPnlPopUpSuccessOrFailure(PanelPopup pp) {
        this.pnlPopUpSuccessOrFailure = pp;
    }
    private HtmlOutputText lblFormMessage = new HtmlOutputText();

    public HtmlOutputText getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputText hot) {
        this.lblFormMessage = hot;
    }
    private HtmlPanelGroup RetirementApproval1 = new HtmlPanelGroup();

    public HtmlPanelGroup getRetirementApproval1() {
        return RetirementApproval1;
    }

    public void setRetirementApproval1(HtmlPanelGroup hpg) {
        this.RetirementApproval1 = hpg;
    }
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessage4 = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private HtmlOutputText lblPopUpMsgMainConf = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMainConf() {
        return lblPopUpMsgMainConf;
    }

    public void setLblPopUpMsgMainConf(HtmlOutputText hot) {
        this.lblPopUpMsgMainConf = hot;
    }
    private HtmlCommandButton btnCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(HtmlCommandButton hcb) {
        this.btnCancel = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LuRankAndPayGradPage() {
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

    //**************************************inner class for load
    public static class PayGradeInnerClass implements Serializable {

        private String rank;
        private Double salary;
        private String payGrade;
        private String payGradeId;
        private boolean selected;

        public String getPayGrade() {
            return payGrade;
        }

        public void setPayGrade(String payGrade) {
            this.payGrade = payGrade;
        }

        public String getPayGradeId() {
            return payGradeId;
        }

        public void setPayGradeId(String payGradeId) {
            this.payGradeId = payGradeId;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public PayGradeInnerClass(
                String rank,
                Double salary,
                String payGrade,
                String payGradeId) {
            this.rank = rank;
            this.salary = salary;
            this.payGrade = payGrade;
            this.payGradeId = payGradeId;
        }
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

    public String cmdLeaveApprove_action() {
        //return null means stay on the same page
        return "JobType";
    }

    public String cmdTrainer_action() {
        //return null means stay on the same page
        return "Trainner";
    }

    public String cmdLeaveTransferRequest_action() {
        //return null means stay on the same page
        return "IncrementSalary";
    }

    public String cmdLeaveBalance_action() {
        //return null means stay on the same page
        return "JobTypeQualifications";
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    private void disablePayGradeComponet() {
        drlStepNo.setDisabled(true);
        txtSarlary.setDisabled(true);

    }

    private void enablePayGradeComponet() {
        drlStepNo.setDisabled(false);
        txtSarlary.setDisabled(false);

    }

    private void clearPayGradeComponet() {
        drlStepNo.setValue(null);
        txtSarlary.setValue("");
    }

    private void disableRankComponet() {
        txtBigSalary.setDisabled(true);
        txtMaxSalary.setDisabled(true);
        txtRank.setDisabled(true);
        txtRemark.setDisabled(true);

    }

    private void enableRankComponet() {
        txtBigSalary.setDisabled(false);
        txtMaxSalary.setDisabled(false);
        txtRank.setDisabled(false);
        txtRemark.setDisabled(false);
    }

    private void clearRankComponet() {
        txtBigSalary.setValue("");
        txtMaxSalary.setValue("");
        txtRank.setValue("");
        txtRemark.setValue("");

    }

    public String btnDeleteTrainer_action() {
        if (leaveTypeManager.deleteLeaveType(leaveTypeId) == 1) {
            initLoad = true;
            showSuccessOrFailureMessage(true, "Company information is/are successfully deleted.");

        } else {
            showSuccessOrFailureMessage(false, "Error occurred while deleting the company information.");
        }
        return null;
    }

    private boolean isValide() {
        boolean result = true;
        String errorMessage = "Required";
        int errorValue = 0;
        result = true;
        if (!HRValidation.validateRequired(drlStepNo.getValue())) {

            result = false;
            ((UIInput) drlStepNo).setValid(false);
            error(drlStepNo, errorMessage);
        }
        errorValue = HRValidation.validateData(this.txtSarlary.getValue(),
                HRValidation.FLOAT_PATTERN, true);
        if (errorValue != 0) {

            result = false;
            if (errorValue == 1) {
                ((UIInput) txtSarlary).setValid(false);
                error(txtSarlary, errorMessage);
            } else {
                ((UIInput) txtSarlary).setValid(false);
                error(txtSarlary, "Invalid Value");
            }
        }
        errorValue = HRValidation.validateData(this.txtRank.getValue(),
                HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtRank).setValid(false);
                error(txtRank, errorMessage);
            } else {
                ((UIInput) txtRank).setValid(false);
                error(txtRank, "Invalid Value");
            }
        }

        errorValue = HRValidation.validateData(this.txtBigSalary.getValue(),
                HRValidation.FLOAT_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtBigSalary).setValid(false);
                error(txtBigSalary, errorMessage);
            } else {
                ((UIInput) txtBigSalary).setValid(false);
                error(txtBigSalary, "Invalid Value");
            }
        }

        errorValue = HRValidation.validateData(this.txtMaxSalary.getValue(),
                HRValidation.FLOAT_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtMaxSalary).setValid(false);
                error(txtMaxSalary, errorMessage);
            } else {
                ((UIInput) txtMaxSalary).setValid(false);
                error(txtMaxSalary, "Invalid Value");
            }
        }

        errorValue = HRValidation.validateData(this.txtRemark.getValue(),
                HRValidation.REMARK_PATTERN, false);
        if (errorValue > 0) {
            result = false;
            ((UIInput) txtMaxSalary).setValid(false);
            error(txtMaxSalary, "Invalid Value");
        }




        return result;
    }

    public String btnAddPayGrade_action() {
        if (isValide()) {
            PayGradeInnerClass payGradeInnerClass = new PayGradeInnerClass(
                    txtRank.getValue().toString(),
                    Double.parseDouble(txtSarlary.getValue().toString()),
                    drlStepNo.getValue().toString(),
                    payGradeId);
            if (buttonIdentifier == 1 || buttonIdentifier == 2) {
                this.payGradeCounter++;
                this.getPayGradeTableList().add(payGradeInnerClass);
                btnEdit.setDisabled(false);
                btnSave.setDisabled(false);
            } else if (buttonIdentifier == 3) {
                btnUpdate.setDisabled(false);
                this.getPayGradeTableList().add(
                        this.selectedPayGrade,
                        payGradeInnerClass);
                this.payGradeTableUpdateList.add(payGradeInnerClass);
                btnEdit.setDisabled(false);
                btnDelete.setDisabled(false);
                this.disablePayGradeComponet();
            }

        } else {
            showSuccessOrFailureMessage(false, "Your input is incorect.");
            //error message
        }




        return null;
    }

    public String btnUpdate_action() {
        try {
            if (choOnlyPayGrade.isSelected()) {
                int chackSave = 0;
                for (PayGradeInnerClass payGradeInnerClass : getPayGradeTableUpdateList()) {
                    chackSave = lookUpManager.updatePayGrad(
                            payGradeInnerClass.getRank(),
                            payGradeInnerClass.getPayGrade(),
                            Double.parseDouble(payGradeInnerClass.getSalary().toString()),
                            payGradeInnerClass.getPayGradeId());
                }
                if (chackSave >= 1) {
                    getPayGradeTableUpdateList().clear();
                    showSuccessOrFailureMessage(true, "The Pay Grade Information Updated Successfully.");
                    payGradeCounter = 0;
                    disablePayGradeComponet();
                    disableRankComponet();
                    lodePayGrade(txtRank.getValue().toString());
                    lodeRank(txtRank.getValue().toString());
                } else {
                    showSuccessOrFailureMessage(false, "The Pay Grade Information not Updated. Please try again ?");
                }
            } else {
                int chekUpdate = lookUpManager.updateRank(
                        txtRemark.getValue().toString(),
                        Double.parseDouble(txtBigSalary.getValue().toString()),
                        Double.parseDouble(txtMaxSalary.getValue().toString()),
                        "Office",
                        oldRankID);
                if (chekUpdate > 0) {
                    showSuccessOrFailureMessage(true, "The Rank Information Updated Successfully.");
                    disablePayGradeComponet();
                    disableRankComponet();
                    lodePayGrade(txtRank.getValue().toString());
                    lodeRank(txtRank.getValue().toString());
                } else {
                    showSuccessOrFailureMessage(false, "The Pay Grade Information not Updated. Please try again ?");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    private boolean savePayGrade() {
        int chackSave = 0;
        List<PayGradeInnerClass> listOfSave = getPayGradeTableList().subList((tableSize), (tableSize + payGradeCounter));
        for (PayGradeInnerClass payGradeInnerClass : listOfSave) {
            chackSave = lookUpManager.savePayGrad(
                    payGradeInnerClass.getRank(),
                    payGradeInnerClass.getPayGrade(),
                    payGradeInnerClass.getSalary());
        }
        if (chackSave >= 1) {
            payGradeCounter = 0;
            return true;
        } else {
            return false;
        }
    }

    private boolean saveRank() {
        int chackSave = 0;
        if (isRankInfoValide()) {
            lookUpManager.saveRank(
                    txtRank.getValue().toString(),
                    txtRemark.getValue().toString(),
                    Double.parseDouble(txtBigSalary.getValue().toString()),
                    Double.parseDouble(txtMaxSalary.getValue().toString()),
                    null);
        }else{
              showSuccessOrFailureMessage(false, "Your input is incorect.");
        }
        if (chackSave >= 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isRankInfoValide() {
        boolean result = true;
        String errorMessage = "Required";
        int errorValue = 0;
        result = true;


        errorValue = HRValidation.validateData(this.txtRank.getValue(),
                HRValidation.NUMBER_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtRank).setValid(false);
                error(txtRank, errorMessage);
            } else {
                ((UIInput) txtRank).setValid(false);
                error(txtRank, "Invalid Value");
            }
        }

        errorValue = HRValidation.validateData(this.txtBigSalary.getValue(),
                HRValidation.FLOAT_PATTERN, true);
        if (errorValue != 0) {

            result = false;
            if (errorValue == 1) {
                ((UIInput) txtBigSalary).setValid(false);
                error(txtBigSalary, errorMessage);
            } else {
                ((UIInput) txtBigSalary).setValid(false);
                error(txtBigSalary, "Invalid Value");
            }
        }

        errorValue = HRValidation.validateData(this.txtMaxSalary.getValue(),
                HRValidation.FLOAT_PATTERN, true);
        if (errorValue == 1) {

            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtMaxSalary).setValid(false);
                    error(txtMaxSalary, errorMessage);
                } else {
                    ((UIInput) txtMaxSalary).setValid(false);
                    error(txtMaxSalary, "Invalid Value");
                }
            }
        }
        errorValue = HRValidation.validateData(this.txtRemark.getValue(),
                HRValidation.REMARK_PATTERN, false);
        if (errorValue > 0) {

            result = false;
            ((UIInput) txtRemark).setValid(false);
            error(txtRemark, "Invalid Value");
        }




        return result;
    }

    public String cmdLeaveRequest_action() {
        // TODO: Replace with your code
        return "OrganizationStructure";
    }

    public String cmdLeaveTransferApprove_action() {
        //return null means stay on the same page
        return "LeaveTransferApprove";
    }

    public String btnSave_action() {
        if (choOnlyPayGrade.isSelected()) {
            if (savePayGrade()) {
                disablePayGradeComponet();
                disableRankComponet();
                lodePayGrade(txtRank.getValue().toString());
                showSuccessOrFailureMessage(true, "The Pay Grade Information Saved Successfully.");
            } else {
                showSuccessOrFailureMessage(false, "The Pay Grade Information Not  Saved.Please try again ?");
            }

        } else {
            if (saveRank()) {
                disablePayGradeComponet();
                disableRankComponet();
                lodeRank(txtRank.getValue().toString());
                lodePayGrade(txtRank.getValue().toString());
                showSuccessOrFailureMessage(true, "The Rank Information Saved Successfully.");
            } else {
                showSuccessOrFailureMessage(false, "The Rank Information Not  Saved.Please try again ?");
            }
        }
        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                lodeRank(vce.getNewValue().toString());
                lodePayGrade(vce.getNewValue().toString());
            }
        } catch (Exception e) {
        }
    }

    private void lodePayGrade(String rankValue) {
        getPayGradeTableList().clear();
        ArrayList<HashMap> listpayGrade = null;
        listpayGrade = lookUpManager.readPayGradeList(rankValue);
        if (listpayGrade != null) {
            tableSize = listpayGrade.size();
            for (HashMap hm : listpayGrade) {
                getPayGradeTableList().add(new PayGradeInnerClass(
                        txtRank.getValue().toString(),
                        Double.parseDouble(hm.get("SALARY").toString()),
                        hm.get("STEP_NO").toString(),
                        hm.get("ID_PAY_GRADE").toString()));
            }
        }
    }

    private void lodeRank(String rankValue) {
        try {
            HashMap list = null;
            list = lookUpManager.readRank(rankValue);
            if (list != null) {
                txtRank.setValue(list.get("RANK_ID"));
                txtBigSalary.setValue(list.get("BEGINNING_SALARY"));
                txtMaxSalary.setValue(list.get("MAX_SALARY"));
                txtRemark.setValue(list.get("RANK_DESCRIPTION"));
                oldRankID = list.get("RANK_ID").toString();
                btnEdit.setDisabled(false);
                btnDelete.setDisabled(false);

            }
        } catch (Exception ex) {
        }
    }

    public void rowSelectorEvaSession_processMyEvent(RowSelectorEvent rse) {
        selectedPayGrade = rse.getRow();
    }

    public String btnEdit_action() {
        buttonIdentifier = 3;
        if (choOnlyPayGrade.isSelected()) {
            if (this.selectedPayGrade == -1) {
                showSuccessOrFailureMessage(false, "First You Have To Select a Record From The Table!!!");
            } else if (this.selectedPayGrade != -1 && this.getPayGradeTableList().isEmpty() == true) {
                showSuccessOrFailureMessage(false, "The Table is Empty!");
            } else {
                PayGradeInnerClass payGradeEdite = (PayGradeInnerClass) this.payGradeTableList.get(this.selectedPayGrade);
                getPayGradeTableList().remove(selectedPayGrade);
                drlStepNo.setValue(payGradeEdite.getPayGrade());
                txtSarlary.setValue(payGradeEdite.getSalary());
                payGradeId = payGradeEdite.getPayGradeId();
                enablePayGradeComponet();
                disableRankComponet();
                btnAddPayGrade.setDisabled(false);
            }
        } else {
            enableRankComponet();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        disableRankComponet();
        disablePayGradeComponet();
        btnAddPayGrade.setDisabled(true);
        pnlPopUpMsgConf.setRendered(true);
        lblPopUpMsgMainConf.setValue("Are You Sure You Want to Delete");
        //return null means stay on the same page
        return null;
    }

    public String btnPopUpYesConf_action() {
        pnlPopUpMsgConf.setRendered(false);
        int checkDelete = 0;
        if (choOnlyPayGrade.isSelected()) {
            if (getPayGradeTableList().isEmpty()) {
                showSuccessOrFailureMessage(false, "The table is empty!!");
            } else if (selectedPayGrade == -1) {

                showSuccessOrFailureMessage(false, "First select data from the table!!");
            } else {
                if (this.selectedPayGrade <= tableSize) {

                    PayGradeInnerClass payGradeInnerClass = (PayGradeInnerClass) getPayGradeTableList().get(selectedPayGrade);
                    checkDelete = lookUpManager.deletePayGradWith(payGradeInnerClass.getPayGradeId());
                    if (checkDelete > 0) {

                        lodePayGrade(txtRank.getValue().toString());
                        lodeRank(txtRank.getValue().toString());
                        selectedPayGrade = -1;
                        payGradeCounter = 0;
                        showSuccessOrFailureMessage(true, "The Pay Grade Information Delete Susseccfully.");
                    } else {
                        showSuccessOrFailureMessage(true, "The Pay Grade Information Not Delete . Please Try Again ?");
                    }
                } else {
                    rowCounter--;
                    this.getPayGradeTableList().remove(selectedPayGrade);
                    buttonIdentifier = 2;

                }

            }


        } else {
            if (this.readRank()) {
                oldRankID = txtRank.getValue().toString();
                checkDelete = lookUpManager.deletePayGrad(oldRankID);
                checkDelete = lookUpManager.deleteRank(oldRankID);
                if (checkDelete == 1) {
                    lodePayGrade(txtRank.getValue().toString());
                    lodeRank(txtRank.getValue().toString());
                    showSuccessOrFailureMessage(true, "The Rank Information Delete Susseccfully.");
                    clearPayGradeComponet();
                    clearRankComponet();
                    disablePayGradeComponet();
                    disableRankComponet();
                } else {
                    showSuccessOrFailureMessage(false, "The Rank Information Not Delete . Please try agin");
                }
            } else {
                showSuccessOrFailureMessage(false, "This Rank Information Not Available .");
            }
        }

        //return null means stay on the same page
        return null;
    }

    private boolean readRank() {
        return lookUpManager.chekRank(oldRankID);
    }

    public String btnPopUpNoConf_action() {
        pnlPopUpMsgConf.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        // TODO: Replace with your code
        return null;
    }

    public String btnNew_action() {
        getPayGradeTableUpdateList().clear();
        buttonIdentifier = 1;
        if (choOnlyPayGrade.isSelected()) {
            btnAddPayGrade.setDisabled(false);
            enablePayGradeComponet();
            disableRankComponet();
            clearPayGradeComponet();
            btnAddPayGrade.setDisabled(false);
        } else {
            disablePayGradeComponet();
            enableRankComponet();
            clearRankComponet();
            btnAddPayGrade.setDisabled(true);
        }
        btnSave.setDisabled(false);
        btnDelete.setDisabled(false);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnNew.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public String btnCancel_action() {
        disablePayGradeComponet();
        disableRankComponet();
        clearPayGradeComponet();
        clearRankComponet();
        getPayGradeTableList().clear();
        getPayGradeTableUpdateList().clear();
        btnAddPayGrade.setDisabled(true);
        btnDelete.setDisabled(true);
        btnSave.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnNew.setDisabled(false);
        //return null means stay on the same page
        return null;
    }
}

