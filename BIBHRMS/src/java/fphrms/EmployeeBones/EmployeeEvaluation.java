/*
 * EmployeeEvaluation.java
 *
 * Created on Dec 19, 2012, 11:01:27 AM
 * Copyright Administrator
 */
package fphrms.EmployeeBones;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.swing.tree.DefaultTreeModel;
import manager.employeeBonesManager.EmployeeEvaluationManager;
import manager.globalUseManager.HRValidation;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeEvaluation extends AbstractPageBean {
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
    private ArrayList<EmployeeEvaluationManager> listOfEmployee = new ArrayList<EmployeeEvaluationManager>();
    private int DEPARRTMENT_ID;
    private int selectedEvaluationRow = -1;
    private boolean firstTime = true;
    private EmployeeEvaluationManager employeeEvaluationManager = null;
    private ArrayList<SelectItem> listOfEvaluation = new ArrayList<SelectItem>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<SelectItem> getListOfEvaluation() {
        return listOfEvaluation;
    }

    public void setListOfEvaluation(ArrayList<SelectItem> listOfEvaluation) {
        this.listOfEvaluation = listOfEvaluation;
    }

    public ArrayList<EmployeeEvaluationManager> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(ArrayList<EmployeeEvaluationManager> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private HtmlInputText txtEmployeeID = new HtmlInputText();

    public HtmlInputText getTxtEmployeeID() {
        return txtEmployeeID;
    }

    public void setTxtEmployeeID(HtmlInputText hit) {
        this.txtEmployeeID = hit;
    }
    private HtmlOutputText lblPosition = new HtmlOutputText();

    public HtmlOutputText getLblPosition() {
        return lblPosition;
    }

    public void setLblPosition(HtmlOutputText hot) {
        this.lblPosition = hot;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlOutputText lblFull_Name = new HtmlOutputText();

    public HtmlOutputText getLblFull_Name() {
        return lblFull_Name;
    }

    public void setLblFull_Name(HtmlOutputText hot) {
        this.lblFull_Name = hot;
    }
    private HtmlInputText txtResult = new HtmlInputText();

    public HtmlInputText getTxtResult() {
        return txtResult;
    }

    public void setTxtResult(HtmlInputText hit) {
        this.txtResult = hit;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlOutputText lblDepartmentName = new HtmlOutputText();

    public HtmlOutputText getLblDepartmentName() {
        return lblDepartmentName;
    }

    public void setLblDepartmentName(HtmlOutputText hot) {
        this.lblDepartmentName = hot;
    }
    private PanelLayout panelLayout3 = new PanelLayout();

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
    }
    private DefaultTree tree2Model = new DefaultTree();

    public DefaultTree getTree2Model() {
        return tree2Model;
    }

    public void setTree2Model(DefaultTree dt) {
        this.tree2Model = dt;
    }
    private Tree treeEval = new Tree();

    public Tree getTreeEval() {
        return treeEval;
    }

    public void setTreeEval(Tree t) {
        this.treeEval = t;
    }
    private HtmlInputText txtEvaluationDate = new HtmlInputText();

    public HtmlInputText getTxtEvaluationDate() {
        return txtEvaluationDate;
    }

    public void setTxtEvaluationDate(HtmlInputText hit) {
        this.txtEvaluationDate = hit;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlCommandButton btnAddLeaveRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddLeaveRequest() {
        return btnAddLeaveRequest;
    }

    public void setBtnAddLeaveRequest(HtmlCommandButton hcb) {
        this.btnAddLeaveRequest = hcb;
    }
    private HtmlCommandButton btnCalenderDateFrom1 = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderDateFrom1() {
        return btnCalenderDateFrom1;
    }

    public void setBtnCalenderDateFrom1(HtmlCommandButton hcb) {
        this.btnCalenderDateFrom1 = hcb;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
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
    private PanelPopup employeePlanPopUpMsg = new PanelPopup();

    public PanelPopup getEmployeePlanPopUpMsg() {
        return employeePlanPopUpMsg;
    }

    public void setEmployeePlanPopUpMsg(PanelPopup pp) {
        this.employeePlanPopUpMsg = pp;
    }
    private HtmlOutputText lblemployeePopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblemployeePopUpMsgMain() {
        return lblemployeePopUpMsgMain;
    }

    public void setLblemployeePopUpMsgMain(HtmlOutputText hot) {
        this.lblemployeePopUpMsgMain = hot;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkForUpdate = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkForUpdate() {
        return chkForUpdate;
    }

    public void setChkForUpdate(HtmlSelectBooleanCheckbox hsbc) {
        this.chkForUpdate = hsbc;
    }
    private HtmlCommandButton btnEdite = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdite() {
        return btnEdite;
    }

    public void setBtnEdite(HtmlCommandButton hcb) {
        this.btnEdite = hcb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private SelectInputDateBean selectInputDate3Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate3Bean() {
        return selectInputDate3Bean;
    }

    public void setSelectInputDate3Bean(SelectInputDateBean sidb) {
        this.selectInputDate3Bean = sidb;
    }
    private SelectInputDate calEvaluationTo = new SelectInputDate();

    public SelectInputDate getCalEvaluationTo() {
        return calEvaluationTo;
    }

    public void setCalEvaluationTo(SelectInputDate sid) {
        this.calEvaluationTo = sid;
    }
    private SelectInputDate calEvaluationDate = new SelectInputDate();

    public SelectInputDate getCalEvaluationDate() {
        return calEvaluationDate;
    }

    public void setCalEvaluationDate(SelectInputDate sid) {
        this.calEvaluationDate = sid;
    }
    private SelectInputDate calEvaluationFrom = new SelectInputDate();

    public SelectInputDate getCalEvaluationFrom() {
        return calEvaluationFrom;
    }

    public void setCalEvaluationFrom(SelectInputDate sid) {
        this.calEvaluationFrom = sid;
    }
    private HtmlInputText txtEvaluationTo = new HtmlInputText();

    public HtmlInputText getTxtEvaluationTo() {
        return txtEvaluationTo;
    }

    public void setTxtEvaluationTo(HtmlInputText hit) {
        this.txtEvaluationTo = hit;
    }
    private HtmlInputText txtEvaluationFrom = new HtmlInputText();

    public HtmlInputText getTxtEvaluationFrom() {
        return txtEvaluationFrom;
    }

    public void setTxtEvaluationFrom(HtmlInputText hit) {
        this.txtEvaluationFrom = hit;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeEvaluation() {
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

        if (firstTime) {
            btnNew.setDisabled(false);
            btnSave.setDisabled(true);

            btnUpdate.setDisabled(true);
            btnReset.setDisabled(false);
            btnDelete.setDisabled(true);
            btnEdite.setDisabled(false);
            firstTime = false;
            disableComponets();
            loadInformation();
            txtResult.setDisabled(true);
            txtRemark.setDisabled(true);
            chkForUpdate.setDisabled(true);

        }

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
            log("EmployeeEvaluation Initialization Failure", e);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String btnNew_action() {
        enableComponets();
        clearComponets();
        btnNew.setDisabled(true);
        btnSave.setDisabled(false);
        btnUpdate.setDisabled(true);
        btnReset.setDisabled(false);
        btnDelete.setDisabled(true);

        //return null means stay on the same page
        return null;
    }

    private ArrayList<HashMap> listOfEvaluation() {

        String result = "0";
        String remark = "not remarked";
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        for (EmployeeEvaluationManager obj : getListOfEmployee()) {
            if (obj.getResult() != null) {
                result = obj.getResult().toString();
            } else {
                result = "0";
            }
            if (obj.getRemark() != null) {
                remark = obj.getRemark().toString();
            } else {
                remark = "not remarked";
            }
            HashMap hm = new HashMap();
            hm.put("employeeId", obj.getEmp_id());
            hm.put("result", result);
            hm.put("remark", remark);
            hm.put("evaluaterId", txtEmployeeID.getValue().toString());
            hm.put("evaluationDate", txtEvaluationDate.getValue().toString());
            hm.put("evaluationFrom", txtEvaluationFrom.getValue().toString());
            hm.put("evaluationTO", txtEvaluationTo.getValue().toString());
            list.add(hm);
        }

        return list;

    }

    boolean checkValue() {
        boolean result = true;
        int errorValue = HRValidation.validateData(this.txtEvaluationDate.getValue(), HRValidation.DATE_PATTERN, true);
        String errorMessage = "Required";
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtEvaluationDate).setValid(false);
                error(txtEvaluationDate, errorMessage);
            } else {
                ((UIInput) txtEvaluationDate).setValid(false);
                error(txtEvaluationDate, "Invalid Value");
            }
        }
        if (!HRValidation.validateRequired(this.txtEmployeeID.getValue())) {
            ((UIInput) txtEmployeeID).setValid(false);
            error(txtEmployeeID, errorMessage);
            result = false;
        }

        if (getListOfEmployee().size() <= 0) {
            result = false;


        }
        return result;
    }

    public String btnSave_action() {
        if (checkValue()) {
            createObject();
            if (employeeEvaluationManager.seaveEmployeeEvaluation(listOfEvaluation())) {
                showSuccessOrFailureMessage(true, "Employee  Evaluation successfully saved.");
                btnNew.setDisabled(false);
                btnSave.setDisabled(true);
                btnUpdate.setDisabled(true);
                btnReset.setDisabled(false);
                btnDelete.setDisabled(true);
                clearComponets();
                disableComponets();

            } else {
                showSuccessOrFailureMessage(false, "Error occurred while saving.Please try again.");
            }
        } else {
            showSuccessOrFailureMessage(false, "Please correct you'r data ?");
        }
        //re   turn null means stay on the same page
        return null;
    }

    public String btnEdit_action() {
        btnNew.setDisabled(true);
        btnSave.setDisabled(true);

        btnUpdate.setDisabled(false);
        btnReset.setDisabled(false);
        btnDelete.setDisabled(false);
        enableComponets();
        //return null means stay on the same page
        return null;
    }

    private ArrayList<HashMap> updateList() {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        for (EmployeeEvaluationManager obj : getListOfEmployee()) {
            if (obj.isSelected()) {
                HashMap hm = new HashMap();
                hm.put("result", obj.getResult());
                hm.put("remark", obj.getRemark());
                hm.put("evaid", obj.getEvaId());
                list.add(hm);
            }
        }



        return list;
    }

    public String btnUpdate_action() {

        createObject();
        if (employeeEvaluationManager.updateEmployeeEvaluation(updateList())) {
            selectedEvaluationRow = -1;
            btnNew.setDisabled(false);
            btnSave.setDisabled(true);
            chkForUpdate.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnReset.setDisabled(false);
            btnDelete.setDisabled(true);
            clearComponets();
            disableComponets();
            showSuccessOrFailureMessage(true, "Employee  Evaluation updated successfully .");
        } else {
            showSuccessOrFailureMessage(false, "Error occurred while update evaluation result.Please try again.");
        }

        //return null means stay on the same page
        return null;
    }

    public String btnReset_action() {
        btnNew.setDisabled(false);
        btnSave.setDisabled(true);

        btnUpdate.setDisabled(true);
        btnReset.setDisabled(false);
        btnDelete.setDisabled(true);
        clearComponets();
        disableComponets();
        //return null means stay on the same page
        return null;
    }

    public String btnAddLeaveRequest_action() {
        LoadTree loadTree = new LoadTree();
        this.tree2Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        panelLayout3.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void commandLink_processAction(ActionEvent ae) {
        try {
            String departmentName;
            String department = treeEval.getCurrentNode().toString();//.substring(0, 2);
            String _department[] = department.split("#");
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID = Integer.parseInt(_department[1].trim());
                lblDepartmentName.setValue(departmentName);
                panelLayout3.setRendered(false);
                loadEmployeeList();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void loadEmployeeList() {
        try {
            if (DEPARRTMENT_ID != 0) {
                createObject();
                getListOfEmployee().clear();
                createObject();
                ArrayList<HashMap> employeeList = employeeEvaluationManager.listoFEmployee(
                        Integer.toString(DEPARRTMENT_ID));
                for (HashMap hm : employeeList) {
                    getListOfEmployee().add(new EmployeeEvaluationManager(
                            hm.get("FULL_NAME").toString(),
                            hm.get("EMPLOYEEID").toString(),
                            "not fill",
                            "",
                            ""));
//
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createObject() {
        if (employeeEvaluationManager == null) {
            employeeEvaluationManager = new EmployeeEvaluationManager();
        }
    }

    public void rowSelectorEvaSession_processMyEvent(RowSelectorEvent rse) {
        selectedEvaluationRow = rse.getRow();
    }

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                btnNew.setDisabled(false);
                btnSave.setDisabled(true);
                btnUpdate.setDisabled(false);
                btnReset.setDisabled(false);
                btnDelete.setDisabled(false);
                btnEdite.setDisabled(false);
                createObject();
                boolean accFirstTime = true;
                getListOfEmployee().clear();
                ArrayList<HashMap> employeeList = employeeEvaluationManager.listofEmployeeEvaluation(
                        vce.getNewValue().toString(),
                        txtEmployeeID.getValue().toString());
                if (employeeList.size() > 0) {
                    for (HashMap hm : employeeList) {
                        if (accFirstTime) {
                            accFirstTime = false;
                            txtEvaluationDate.setValue(hm.get("EVALUATIONDATE"));
                            txtEvaluationFrom.setValue(hm.get("EVALUATIONFROM"));
                            txtEvaluationTo.setValue(hm.get("EVALUATIONTO"));
                        }
                        getListOfEmployee().add(new EmployeeEvaluationManager(
                                hm.get("FULL_NAME").toString(),
                                hm.get("EMPLOYEEID").toString(),
                                hm.get("RESULT").toString(),
                                hm.get("REMARK").toString(),
                                hm.get("ID").toString()));
                    }

                    disableComponets();
                }
            }
        } catch (Exception e) {
        }
    }

    public String btnDelete_action() {

        employeePlanPopUpMsg.setRendered(true);
        lblemployeePopUpMsgMain.setValue("Are you sure you want to delete");
//        } else {
//            showSuccessOrFailureMessage(true, "Please select record from table ?");
//        }


        //return null means stay on the same page
        return null;
    }

    private void disableComponets() {
        txtEmployeeID.setDisabled(true);
        txtEvaluationDate.setDisabled(true);
        btnAddLeaveRequest.setDisabled(true);
        btnCalenderDateFrom1.setDisabled(true);
        txtResult.setDisabled(true);
    }

    private void enableComponets() {
        txtEvaluationDate.setDisabled(false);
        btnAddLeaveRequest.setDisabled(false);
        btnCalenderDateFrom1.setDisabled(false);
        txtRemark.setDisabled(false);
        txtResult.setDisabled(false);
    }

    private void clearComponets() {
        getListOfEmployee().clear();
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(); $j('." + val + "').fadeOut(" + fadeTime + ");});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpYes_action() {
        createObject();
        employeePlanPopUpMsg.setRendered(false);
        // EmployeeEvaluationManager obj = getListOfEmployee().get(selectedEvaluationRow);
        if (employeeEvaluationManager.deleteEmployeeEvaluation(updateList())) {
            btnNew.setDisabled(false);
            btnSave.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnReset.setDisabled(false);
            btnDelete.setDisabled(true);
            chkForUpdate.setDisabled(true);
            clearComponets();
            disableComponets();
            showSuccessOrFailureMessage(true, "Record deleted successfully");
        } else {
            showSuccessOrFailureMessage(true, "Record not deleted please try agine?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpNo_action() {
        employeePlanPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    private void loadInformation() {
        createObject();
        ArrayList<SelectItem> list = employeeEvaluationManager.listofEvaluationDate(getSessionBean1().getEmployeeId());
        txtEmployeeID.setValue(getSessionBean1().getEmployeeId());
        lblFull_Name.setValue(getSessionBean1().getEmployeeName());
        lblDepartment.setValue(getSessionBean1().getDepartmentDescrption());
        lblPosition.setValue(getSessionBean1().getDepartmentDescrption());
        txtEvaluationDate.setValue(sdf.format(new Date()));
        if (list.size() > 0) {
            setListOfEvaluation(list);
        }
    }

    public String lnkEvaluationResultPage_action() {
        // TODO: Replace with your code
        return "YearlyBonesRequest";
    }

    public String lnkApproveYearlyBonusPage_action() {
        // TODO: Replace with your code
        return "ApproveBonesRequest";
    }

    public String btnEdite_action() {
        txtResult.setDisabled(false);
        txtRemark.setDisabled(false);
        chkForUpdate.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {
        calEvaluationTo.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnCalenderDateFrom1_action() {
        calEvaluationDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String button1_action() {
        calEvaluationFrom.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calEvaluationTo_processValueChange(ValueChangeEvent vce) {
        txtEvaluationTo.setValue(sdf.format((Date) vce.getNewValue()));
        calEvaluationTo.setRendered(false);


    }

    public void calEvaluationDate_processValueChange(ValueChangeEvent vce) {
        txtEvaluationDate.setValue(sdf.format((Date) vce.getNewValue()));
        calEvaluationDate.setRendered(false);
    }

    public void calEvaluationFrom_processValueChange(ValueChangeEvent vce) {
        txtEvaluationFrom.setValue(sdf.format((Date) vce.getNewValue()));
        calEvaluationFrom.setRendered(false);
    }
}

