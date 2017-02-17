/*
 * EmployeeMilkRegistraion.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.MilkBenefit;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.tree.TreeNode;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.tree.Tree;
import com.sun.webui.jsf.model.Option;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.swing.tree.DefaultTreeModel;
import manager.MilkBenefit.EmployeeRegistrationManager;
import manager.MilkBenefit.EmployeeRegistrationManager.EmployeeMilkModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.HRValidation;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeMilkRegistraion extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }
    private HtmlPanelGroup pnlgridpnMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlgridpnMessage() {
        return pnlgridpnMessage;
    }

    public void setPnlgridpnMessage(HtmlPanelGroup hpg) {
        this.pnlgridpnMessage = hpg;
    }
    private HtmlOutputText pnMessageTitle = new HtmlOutputText();

    public HtmlOutputText getPnMessageTitle() {
        return pnMessageTitle;
    }

    public void setPnMessageTitle(HtmlOutputText hot) {
        this.pnMessageTitle = hot;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup hpg) {
        this.panelGroupMessage = hpg;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel hol) {
        this.lblSuccessOrErrorMessage = hol;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private SelectInputText txtEmployeeFullName = new SelectInputText();

    public SelectInputText getTxtEmployeeFullName() {
        return txtEmployeeFullName;
    }

    public void setTxtEmployeeFullName(SelectInputText sit) {
        this.txtEmployeeFullName = sit;
    }
    private HtmlInputText txtEmployeeDepartment = new HtmlInputText();

    public HtmlInputText getTxtEmployeeDepartment() {
        return txtEmployeeDepartment;
    }

    public void setTxtEmployeeDepartment(HtmlInputText hit) {
        this.txtEmployeeDepartment = hit;
    }
    private HtmlInputText txtEmployeePosition = new HtmlInputText();

    public HtmlInputText getTxtEmployeePosition() {
        return txtEmployeePosition;
    }

    public void setTxtEmployeePosition(HtmlInputText hit) {
        this.txtEmployeePosition = hit;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
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
    private HtmlInputText txtDepartment = new HtmlInputText();

    public HtmlInputText getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(HtmlInputText hit) {
        this.txtDepartment = hit;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlCommandButton btnAddtoTable = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddtoTable() {
        return btnAddtoTable;
    }

    public void setBtnAddtoTable(HtmlCommandButton hcb) {
        this.btnAddtoTable = hcb;
    }
    private HtmlCommandLink cmdLnkTree = new HtmlCommandLink();

    public HtmlCommandLink getCmdLnkTree() {
        return cmdLnkTree;
    }

    public void setCmdLnkTree(HtmlCommandLink hcl) {
        this.cmdLnkTree = hcl;
    }
    private Tree tree = new Tree();

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree t) {
        this.tree = t;
    }
    private TreeNode treeNode2 = new TreeNode();

    public TreeNode getTreeNode2() {
        return treeNode2;
    }

    public void setTreeNode2(TreeNode tn) {
        this.treeNode2 = tn;
    }
    private HtmlPanelGroup panelGroup1 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroup1() {
        return panelGroup1;
    }

    public void setPanelGroup1(HtmlPanelGroup hpg) {
        this.panelGroup1 = hpg;
    }
    private HtmlGraphicImage graphicImage2 = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImage2() {
        return graphicImage2;
    }

    public void setGraphicImage2(HtmlGraphicImage hgi) {
        this.graphicImage2 = hgi;
    }
    private HtmlPanelGroup panelGroup2 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroup2() {
        return panelGroup2;
    }

    public void setPanelGroup2(HtmlPanelGroup hpg) {
        this.panelGroup2 = hpg;
    }
    private HtmlOutputText outputText1 = new HtmlOutputText();

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }

    public void setOutputText1(HtmlOutputText hot) {
        this.outputText1 = hot;
    }
    private HtmlCommandButton btnSearchRegistered = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchRegistered() {
        return btnSearchRegistered;
    }

    public void setBtnSearchRegistered(HtmlCommandButton hcb) {
        this.btnSearchRegistered = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeMilkRegistraion() {
    }
    EmployeeManage employeeManager = new EmployeeManage();
    EmployeeRegistrationManager employeeRegistrationManager = new EmployeeRegistrationManager();
    ArrayList<EmployeeMilkModel> employeeList = new ArrayList<EmployeeMilkModel>();
    ArrayList<Option> benefittype = employeeRegistrationManager.getType();
    ArrayList<Option> positionTypesOption = new ArrayList<Option>();
    DepartmentManage departmentManager = new DepartmentManage();
    private String requesterId;
    private String fullName;
    private String requesterFullName;
    private String requesterDepartment;
    private String requesterPostion;
    int selectedBenefitTypeRow = -1;
    private String databaseStatus;
    private String type;
    private int amount;
    private String remark;
    private boolean rendered;
    private int DEPARRTMENT_ID = 0;
    private static String selectedId;

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
            log("Templete Initialization Failure", e);
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    private DefaultTree treeModel = new DefaultTree();
    private DefaultTree defaultTreeModel = new DefaultTree();
    private Tree treeOrgStructure = new Tree();
    private PanelLayout pnlLayoutTree = new PanelLayout();

    public DefaultTree getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public ArrayList<Option> getPositionTypesOption() {
        return positionTypesOption;
    }

    public void setPositionTypesOption(ArrayList<Option> positionTypesOption) {
        this.positionTypesOption = positionTypesOption;
    }

    public int getDEPARRTMENT_ID() {
        return DEPARRTMENT_ID;
    }

    public void setDEPARRTMENT_ID(int DEPARRTMENT_ID) {
        this.DEPARRTMENT_ID = DEPARRTMENT_ID;
    }

    public DepartmentManage getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManage departmentManager) {
        this.departmentManager = departmentManager;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDefaultTreeModel(DefaultTree defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

    public PanelLayout getPnlLayoutTree() {
        return pnlLayoutTree;
    }

    public void setPnlLayoutTree(PanelLayout pnlLayoutTree) {
        this.pnlLayoutTree = pnlLayoutTree;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public DefaultTree getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTree treeModel) {
        this.treeModel = treeModel;
    }

    public Tree getTreeOrgStructure() {
        return treeOrgStructure;
    }

    public void setTreeOrgStructure(Tree treeOrgStructure) {
        this.treeOrgStructure = treeOrgStructure;
    }

    public void updateList(ValueChangeEvent vce) {
    }

    public ArrayList<EmployeeMilkModel> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<EmployeeMilkModel> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public ArrayList<Option> getBenefittype() {
        return benefittype;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBenefittype(ArrayList<Option> benefittype) {
        this.benefittype = benefittype;
    }

    public int getSelectedBenefitTypeRow() {
        return selectedBenefitTypeRow;
    }

    public void setSelectedBenefitTypeRow(int selectedBenefitTypeRow) {
        this.selectedBenefitTypeRow = selectedBenefitTypeRow;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public EmployeeRegistrationManager getEmployeeRegistrationManager() {
        return employeeRegistrationManager;
    }

    public void setEmployeeRegistrationManager(EmployeeRegistrationManager employeeRegistrationManager) {
        this.employeeRegistrationManager = employeeRegistrationManager;
    }

    public String getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(String requesterDepartment) {
        this.requesterDepartment = requesterDepartment;
    }

    public String getRequesterFullName() {
        return requesterFullName;
    }

    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterPostion() {
        return requesterPostion;
    }

    public void setRequesterPostion(String requesterPostion) {
        this.requesterPostion = requesterPostion;
    }

    private void clearEmployeeTextComponents() {
        txtEmployeeDepartment.setValue(null);
        txtEmployeeFullName.setValue(null);
        txtEmployeeId.setValue(null);
        txtEmployeePosition.setValue(null);
        getEmployeeList().clear();
        requesterId = null;
    }

    public void enableComponents() {
        txtEmployeeId.setDisabled(false);
        txtEmployeeFullName.setDisabled(false);
        btnAddtoTable.setDisabled(false);
        txtRemark.setDisabled(false);
    }

    public void disableComponenets() {
        txtEmployeeId.setDisabled(true);
        txtEmployeeFullName.setDisabled(true);
        btnAddtoTable.setDisabled(true);
        txtRemark.setDisabled(true);
    }

    private boolean isEmployeeRegistered(String empId) {
        for (EmployeeMilkModel currentEMpID : employeeList) {
            if (currentEMpID.getEmpId().equals(empId)) {
                return true;
            }
        }
        return false;
    }

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

    public boolean isEntryValidForSearchTerminator() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtEmployeeId.getValue());
        if (!required) {
            ((UIInput) txtEmployeeId).setValid(false);
            error(txtEmployeeId, errorMessage);
            results = false;
        }
        return results;
    }

    private boolean populateEmployeeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtEmployeeDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtEmployeeId.setValue(requesterId);
                txtEmployeePosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    public boolean checkEmployeeStatus() {
//        ArrayList<HashMap> educationPrePaidCheck = new ArrayList<HashMap>();
        String empInfoHashMap = employeeRegistrationManager.getEmployeeStatus(requesterId);
        if (empInfoHashMap != null) {
            if ((empInfoHashMap.equalsIgnoreCase("09")) || (empInfoHashMap.equalsIgnoreCase("05")) || (empInfoHashMap.equalsIgnoreCase("03"))) {
                showSuccessOrFailureMessage(false, "CAN NOT ASSIGN!! THE EMPLOYEE IS TERMINATED");
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public String btnSearch_action() {
        if (isEntryValidForSearchTerminator()) {
            if (txtEmployeeId.getValue() != null && !txtEmployeeId.getValue().toString().equals("")) {
                requesterId = txtEmployeeId.getValue().toString();
                if (!checkEmployeeStatus()) {
                    if ((populateEmployeeTextComponents(requesterId))) {

                        enableComponents();
                    } else {
                        showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtEmployeeId.getValue().toString());
                        requesterId = null;
                        disableComponenets();
                    }
                } else {
                    requesterId = null;
                    showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
                }
            }
        }
        return null;
    }

    public String txtEmployeeFullName_action() {
        //return null means stay on the same page
        clearEmployeeTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        if (!checkEmployeeStatus()) {
            populateEmployeeTextComponents(requesterId);
        }
        return null;
    }

    public String btnNew_action() {
        //return null means stay on the same page
        enableComponents();
        clearEmployeeTextComponents();
        return null;
    }

    public String btnReset_action() {
        //return null means stay on the same page
        clearEmployeeTextComponents();
        return null;
    }

    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
        selectedBenefitTypeRow = selectedRowIndex;
    }

    public String cmdLnkEdit_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdLnkRemove_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdLnkEdit1_action() {
        //return null means stay on the same page
        if (selectedBenefitTypeRow != -1) {
            if (employeeList.get(selectedBenefitTypeRow).getDatabasStatus().equals("Old")) {
                employeeList.get(selectedBenefitTypeRow).setDatabasStatus("Edited");
            }
        }
        return null;
    }

    public String cmdLnkRemove1_action() {
        //return null means stay on the same page
        if (selectedBenefitTypeRow != -1) {
          
            if (employeeList.get(selectedBenefitTypeRow).getDatabasStatus().equals("New")) {
                employeeList.remove(selectedBenefitTypeRow);
            } else if (employeeList.get(selectedBenefitTypeRow).getDatabasStatus().equals("Old") ||
                    employeeList.get(selectedBenefitTypeRow).getDatabasStatus().equals("Edited")) {
                employeeList.get(selectedBenefitTypeRow).setDatabasStatus("Deleted");
            }
        }
        return null;
    }

    public String btnAddtoTable_action() {
        //return null means stay on the same page
        requesterId = txtEmployeeId.getValue().toString();
        if (isEmployeeRegistered(requesterId)) {
            showSuccessOrFailureMessage(false, "ALREADY REGISTERED");
        } else {
            fullName = txtEmployeeFullName.getValue().toString();
            remark = txtRemark.getValue().toString();
            databaseStatus = "New";
            rendered = false;


            employeeList.add(0, new EmployeeMilkModel(requesterId, fullName, rendered, databaseStatus, remark, DEPARRTMENT_ID));

        }
        clearEmployeeTextComponents();
        return null;
    }

    public String btnSave_action() {
        if (employeeRegistrationManager.saveBenefitTypes(employeeList)) {
            showSuccessOrFailureMessage(true, "SUCCESS");
            clearEmployeeTextComponents();
        } else {
            showSuccessOrFailureMessage(false, "FAILED");
        }
        return null;
    }

    public String txtDepartment_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnDepartmentTree1_action() {
        //return null means stay on the same page
        LoadTree loadTree = new LoadTree();
        this.treeModel.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        pnlLayoutTree.setRendered(true);
        return null;
    }

    private void createObject() {
        if (employeeRegistrationManager == null) {
            employeeRegistrationManager = new EmployeeRegistrationManager();
        }
    }

    public String button1_action() {
        //return null means stay on the same page
        try {
            if (DEPARRTMENT_ID != 0) {
                createObject();
                databaseStatus = "New";
                rendered = false;
                remark = "No Remark";
                ArrayList<HashMap> employeeLists = employeeRegistrationManager.listOFEmployee(Integer.toString(DEPARRTMENT_ID));
                for (HashMap hm : employeeLists) {
                    getEmployeeList().add(new EmployeeMilkModel(
                            hm.get("EMPLOYEEID").toString(),
                            hm.get("FULL_NAME").toString(),
                            rendered, databaseStatus, remark, DEPARRTMENT_ID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;

    }

    public void cmdLnkTree_processAction(ActionEvent ae) {
        try {
            String departmentName;
            String department = tree.getCurrentNode().toString();
            String _department[] = department.split("#");
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID = Integer.parseInt(_department[1].trim());
                txtDepartment.setValue(departmentName);
                pnlLayoutTree.setRendered(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String txtSearchByName_action() {
        //return null means stay on the same page
        selectedId = null;
        selectedId = ApplicationBean1.getSelectedEmployeeId();

        if (selectedId != null) {
            getEmployeeList().clear();
            txtRemark.setValue(null);
        // populateAllDutyCOmponent(ApplicationBean1.getSelectedEmployeeId());

        }
        return null;
    }

    public String btnAdd_action() {
        //return null means stay on the same page
        try {
            getEmployeeList().clear();
            if (DEPARRTMENT_ID != 0) {
                createObject();
                databaseStatus = "New";
                rendered = true;
                remark = "No Remark";
                ArrayList<HashMap> employeeLists = employeeRegistrationManager.listOFEmployee(Integer.toString(DEPARRTMENT_ID));
                for (HashMap hm : employeeLists) {
                    getEmployeeList().add(new EmployeeMilkModel(
                            hm.get("EMPLOYEEID").toString(),
                            hm.get("FULL_NAME").toString(),
                            rendered, databaseStatus, remark, DEPARRTMENT_ID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String btnSearchRegistered_action() {
        //return null means stay on the same page
        try {

            if (DEPARRTMENT_ID != 0) {
                getEmployeeList().clear();
                createObject();
                databaseStatus = "Old";
                rendered = false;
                remark = "No Remark";
                ArrayList<HashMap> employeeLists = employeeRegistrationManager.listOFRegisteredEmployee(Integer.toString(DEPARRTMENT_ID));
                if (employeeLists.isEmpty()) {
                    showSuccessOrFailureMessage(false, "THERE IS NO REGISTERED EMPLOYEE!!");
                } else {
                    for (HashMap hm : employeeLists) {
                      
                        getEmployeeList().add(new EmployeeMilkModel(
                                hm.get("EMPLOYEEID").toString(),
                                hm.get("FULL_NAME").toString(),
                                rendered, databaseStatus,   hm.get("remark").toString(), DEPARRTMENT_ID, Integer.valueOf(hm.get("id").toString())));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void txtRemark_processValueChange(ValueChangeEvent vce) {
    }
}

