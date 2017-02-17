/*
 * EmployeeYearBones.java
 *
 * Created on Dec 18, 2012, 2:26:45 PM
 * Copyright Administrator
 */
package fphrms.EmployeeBones;

import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.employeeBonesManager.ApproveYearlyBonesManager;
import manager.globalUseManager.HRValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ApproveYearlyBones extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<ApproveYearlyBonesManager> listOfEmployee = new ArrayList<ApproveYearlyBonesManager>();
    private ArrayList<SelectItem> prerviousRequestList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> decisionList = new ArrayList<SelectItem>();
    private ApproveYearlyBonesManager approveYearlyBonesManager = null;
    private String approverId;
    private String bonessId;

    public ArrayList<SelectItem> getDecisionList() {
        return decisionList;
    }

    public void setDecisionList(ArrayList<SelectItem> decisionList) {
        this.decisionList = decisionList;
    }

    public ArrayList<SelectItem> getPrerviousRequestList() {
        return prerviousRequestList;
    }

    public void setPrerviousRequestList(ArrayList<SelectItem> prerviousRequestList) {
        this.prerviousRequestList = prerviousRequestList;
    }

    public ArrayList<ApproveYearlyBonesManager> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(ArrayList<ApproveYearlyBonesManager> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private HtmlOutputText txtEmployeeNumber = new HtmlOutputText();

    public HtmlOutputText getTxtEmployeeNumber() {
        return txtEmployeeNumber;
    }

    public void setTxtEmployeeNumber(HtmlOutputText hot) {
        this.txtEmployeeNumber = hot;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
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
    private HtmlOutputText txtPrepareIn = new HtmlOutputText();

    public HtmlOutputText getTxtPrepareIn() {
        return txtPrepareIn;
    }

    public void setTxtPrepareIn(HtmlOutputText hot) {
        this.txtPrepareIn = hot;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlOutputText txtBegetYearEndDate = new HtmlOutputText();

    public HtmlOutputText getTxtBegetYearEndDate() {
        return txtBegetYearEndDate;
    }

    public void setTxtBegetYearEndDate(HtmlOutputText hot) {
        this.txtBegetYearEndDate = hot;
    }
    private HtmlOutputText txtRequester = new HtmlOutputText();

    public HtmlOutputText getTxtRequester() {
        return txtRequester;
    }

    public void setTxtRequester(HtmlOutputText hot) {
        this.txtRequester = hot;
    }
    private HtmlOutputText txtEmployeeEvaluationYear = new HtmlOutputText();

    public HtmlOutputText getTxtEmployeeEvaluationYear() {
        return txtEmployeeEvaluationYear;
    }

    public void setTxtEmployeeEvaluationYear(HtmlOutputText hot) {
        this.txtEmployeeEvaluationYear = hot;
    }
    private HtmlOutputText txtBegetYear = new HtmlOutputText();

    public HtmlOutputText getTxtBegetYear() {
        return txtBegetYear;
    }

    public void setTxtBegetYear(HtmlOutputText hot) {
        this.txtBegetYear = hot;
    }
    private HtmlOutputText txtApproveBonesAmount = new HtmlOutputText();

    public HtmlOutputText getTxtApproveBonesAmount() {
        return txtApproveBonesAmount;
    }

    public void setTxtApproveBonesAmount(HtmlOutputText hot) {
        this.txtApproveBonesAmount = hot;
    }
    private HtmlSelectBooleanCheckbox chkMakeApproveHere = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMakeApproveHere() {
        return chkMakeApproveHere;
    }

    public void setChkMakeApproveHere(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMakeApproveHere = hsbc;
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

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ApproveYearlyBones() {
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
        checkObject();

//        ResponseStateManager rsm = FacesContext.getCurrentInstance().getRenderKit().getResponseStateManager();
//        if (rsm.isPostback(FacesContext.getCurrentInstance())) {
        loadPreviousRequest();
        setDecisionList(approveYearlyBonesManager.getListOfDecision());
        approverId = getSessionBean1().getEmployeeId();
//        }
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
            log("EmployeeYearBones Initialization Failure", e);
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

    private void checkObject() {
        if (approveYearlyBonesManager == null) {
            approveYearlyBonesManager = new ApproveYearlyBonesManager();
        }
    }

    public String btnRequest_action() {
        checkObject();

        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnRemove_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnMakeitSelectable_action() {
        chkMakeApproveHere.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public String lnkEvaluationResultPage_action() {
        // TODO: Replace with your code
        return null;
    }

    public String lnkApproveYearlyBonusPage_action() {
        // TODO: Replace with your code
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        // TODO: Replace with your code
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void chkPerviousRequestList_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            loadRequesterInformainon(vce.getNewValue().toString());
            loadRequestedInformainon(vce.getNewValue().toString());
            chkMakeApproveHere.setDisabled(true);
        }
    }

    void loadRequesterInformainon(String requesId) {
        clearComponet();
        HashMap requesterInfo = approveYearlyBonesManager.getReqfuesterInformation(requesId);
        txtPrepareIn.setValue(requesterInfo.get("PREPAREFOR"));
        txtBegetYearEndDate.setValue(requesterInfo.get("EFFECTIVEDATE"));
        txtEmployeeEvaluationYear.setValue(requesterInfo.get("REQUSTDATE"));
        txtRequester.setValue(requesterInfo.get("FULLNAME"));
        txtBegetYear.setValue(requesterInfo.get("YEAR"));
        txtApproveBonesAmount.setValue(requesterInfo.get("GRANTBONUS") + "Month");
        bonessId = requesterInfo.get("BONESID").toString();


    }

    void clearComponet() {
        txtPrepareIn.setValue("");
        txtBegetYearEndDate.setValue("");
        txtEmployeeEvaluationYear.setValue("");
        txtRequester.setValue("");
        txtBegetYear.setValue("");
        txtEmployeeNumber.setValue("");
        txtApproveBonesAmount.setValue("");
        txtaDeciderComment.setValue("");

    }

    void loadRequestedInformainon(String requesId) {
        try {


            ArrayList<HashMap> requestedInfo = approveYearlyBonesManager.getReqfuestedInformation(requesId);
            if (requestedInfo.size() > 0) {
                txtEmployeeNumber.setValue(requestedInfo.size());
                getListOfEmployee().clear();
                for (HashMap hm : requestedInfo) {
                    getListOfEmployee().add(new ApproveYearlyBonesManager(
                            hm.get("EMP_ID").toString(),
                            hm.get("FULLNAME").toString(),
                            hm.get("EVALUATIONRESULT").toString(),
                            hm.get("ACQUIREPERCENTAGE").toString(),
                            hm.get("AMOUNTINBIRR").toString(),
                            hm.get("EXPRIANCE").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("EVALUATIONRESULT").toString(),
                            hm.get("ID").toString(),
                            true));
                }

            }
        } catch (Exception e) {
        }
    }

    private ArrayList<HashMap> approvedList() {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        list.clear();
        for (ApproveYearlyBonesManager obj : getListOfEmployee()) {
            if (obj.isSelected()) {
                HashMap hm = new HashMap();
                hm.put("empId", obj.getEmployeeId());
                hm.put("bonesId", obj.getBonesId());
                list.add(hm);
            }
        }
        return list;
    }

    public String btnSave_action() {
        checkObject();
        String remark = "not remarkde";
        if (HRValidation.validateRequired(drlDecision.getValue())) {
            if (HRValidation.validateRequired(txtaDeciderComment.getValue())) {
                remark = txtaDeciderComment.getValue().toString();
            }
            if (approveYearlyBonesManager.saveeBonesRequestDecision(approvedList(),
                    approverId,
                    bonessId,
                    drlDecision.getValue().toString(),
                    remark)) {
                loadPreviousRequest();
                getListOfEmployee().clear();
                clearComponet();
                showSuccessOrFailureMessage(true, "Your Decision Successfully Saved!");
            } else {
                showSuccessOrFailureMessage(true, "Your Decision Not Saved. Please try Again ?");
            }
        } else {
            showSuccessOrFailureMessage(false, "Please Select Your decision!!");
        }
        //return null means stay on the same page
        return null;

    }

    private void loadPreviousRequest() {
        setPrerviousRequestList(approveYearlyBonesManager.getListOfRequest());
    }
}


