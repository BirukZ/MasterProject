/*
 * AssignEmployeePage.java
 *
 * Created on Dec 17, 2012, 3:26:02 PM
 * Copyright Administrator
 */
package fphrms.TransportPayment;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.tree.DefaultTreeModel;
import manager.globalUseManager.AssignEmployeeInLocationManager;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class AssignEmployeeInlocationPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        try {
            createObject();
            setListOfLocation(assignEmployeeInLocationManager.locationList());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // </editor-fold>
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<AvilableEmployeeDataModel> availableEmployeeInDataModel = new ArrayList<AvilableEmployeeDataModel>();
    private ArrayList<AvilableEmployeeInGroup> avilableEmployeeInGroup = new ArrayList<AvilableEmployeeInGroup>();
    private ArrayList<SelectItem> listOfLocation = new ArrayList<SelectItem>();
    private AssignEmployeeInLocationManager assignEmployeeInLocationManager = null;
    private int DEPARRTMENT_ID = 0;
    private static int tableSizeForAvilableUser = 0;
    private static int tableSizeForAssignedUser = 0;
    private static int rowCounterForAvilableUser = 0;
    private static int rowCounterForAssignedUser = 0;

    public ArrayList<SelectItem> getListOfLocation() {
        return listOfLocation;
    }

    public void setListOfLocation(ArrayList<SelectItem> listOfLocation) {
        this.listOfLocation = listOfLocation;
    }

    public ArrayList<AvilableEmployeeInGroup> getAvilableEmployeeInGroup() {
        return avilableEmployeeInGroup;
    }

    public void setAvilableEmployeeInGroup(ArrayList<AvilableEmployeeInGroup> avilableEmployeeInGroup) {
        this.avilableEmployeeInGroup = avilableEmployeeInGroup;
    }

    public ArrayList<AvilableEmployeeDataModel> getAvailableEmployeeInDataModel() {
        return availableEmployeeInDataModel;
    }

    public void setAvailableEmployeeInDataModel(ArrayList<AvilableEmployeeDataModel> availableEmployeeInDataModel) {
        this.availableEmployeeInDataModel = availableEmployeeInDataModel;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private HtmlCommandButton btnRemove = new HtmlCommandButton();

    public HtmlCommandButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(HtmlCommandButton hcb) {
        this.btnRemove = hcb;
    }
    private HtmlCommandButton btnAddAll = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddAll() {
        return btnAddAll;
    }

    public void setBtnAddAll(HtmlCommandButton hcb) {
        this.btnAddAll = hcb;
    }
    private HtmlCommandButton btnRemoveAll = new HtmlCommandButton();

    public HtmlCommandButton getBtnRemoveAll() {
        return btnRemoveAll;
    }

    public void setBtnRemoveAll(HtmlCommandButton hcb) {
        this.btnRemoveAll = hcb;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultTree tree1Model = new DefaultTree();

    public DefaultTree getTree1Model() {
        return tree1Model;
    }

    public void setTree1Model(DefaultTree dt) {
        this.tree1Model = dt;
    }
    private Tree tree1 = new Tree();

    public Tree getTree1() {
        return tree1;
    }

    public void setTree1(Tree t) {
        this.tree1 = t;
    }
    private PanelLayout panelLayout3 = new PanelLayout();

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
    }
    private HtmlOutputText lblDepartmentName = new HtmlOutputText();

    public HtmlOutputText getLblDepartmentName() {
        return lblDepartmentName;
    }

    public void setLblDepartmentName(HtmlOutputText hot) {
        this.lblDepartmentName = hot;
    }
    private HtmlSelectOneMenu drlLlocationId = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLlocationId() {
        return drlLlocationId;
    }

    public void setDrlLlocationId(HtmlSelectOneMenu hsom) {
        this.drlLlocationId = hsom;
    }
    private HtmlDataTable tblAssgnedUsers = new HtmlDataTable();

    public HtmlDataTable getTblAssgnedUsers() {
        return tblAssgnedUsers;
    }

    public void setTblAssgnedUsers(HtmlDataTable hdt) {
        this.tblAssgnedUsers = hdt;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AssignEmployeeInlocationPage() {
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
            log("AssignEmployeePage Initialization Failure", e);
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

    public static class AvilableEmployeeDataModel implements Serializable {

        String employeeID;
        String employeeName;
        String groupId;
        private boolean selected;

        public String getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public AvilableEmployeeDataModel(String employeeID, String employeeName, String groupId) {
            this.employeeID = employeeID;
            this.employeeName = employeeName;
            this.groupId = groupId;
        }
    }

    public static class AvilableEmployeeInGroup implements Serializable {
//   hm.get("EMPLOYEEID").toString(),
//                            hm.get("FULL_NAME").toString(),
//                            hm.get("EMPLOCATIONID").toString(),
//                            hm.get("LOCATIONID").toString(),
//                            hm.get("EMP_STATUS").toString()));

        String employeeId;
        String employeeName;
        String employeeLocationId;
        String locationId;
        String supportInfo;

        public String getSupportInfo() {
            return supportInfo;
        }

        public void setSupportInfo(String supportInfo) {
            this.supportInfo = supportInfo;
        }
        private boolean selected;

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeGroupId() {
            return employeeLocationId;
        }

        public void setEmployeeGroupId(String employeeGroupId) {
            this.employeeLocationId = employeeGroupId;
        }

        public String getLocationId() {
            return locationId;
        }

        public void setLocationId(String locationId) {
            this.locationId = locationId;
        }

        public AvilableEmployeeInGroup(String employeeId, String employeeName) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
        }

        public AvilableEmployeeInGroup(String employeeId, String employeeName, String employeeLocationId, String locationId, String employeStatus) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.employeeLocationId = employeeLocationId;
            this.locationId = locationId;
            if (employeStatus.equals("01") || employeStatus.equals("02") || employeStatus.equals("07")) {
                this.supportInfo = "true";
            } else {
                this.supportInfo = "false";
            }
        }
    }

    public String lnkPayrollPeriodLists_action() {
        // TODO: Replace with your code
        return null;
    }

    public String lnkPayrollGroup_action() {
        // TODO: Replace with your code
        return null;
    }

    public String lnkPayrollEmployeeGroup_action() {
        // TODO: Replace with your code
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSaveGroup_action() {
        if (drlLlocationId.getValue() != null) {
            if (assignEmployeeInLocationManager.saveEmployeeInLocation(drlLlocationId.getValue().toString(), employeeGroupForInsert())) {
                showSuccessOrFailureMessage(true, "Employee  assigned Into Location  successfully Done.");
            } else {
                showSuccessOrFailureMessage(false, "Error occurred while assigning Employee into Location.Please try again.");
            }
        }
        //return null means stay on the same page
        return null;
    }

    public String btnAdd_action() {
        for (int i = 0; i < getAvailableEmployeeInDataModel().size(); i++) {
            if (getAvailableEmployeeInDataModel().get(i).isSelected()) {
                getAvilableEmployeeInGroup().add(new AvilableEmployeeInGroup(
                        getAvailableEmployeeInDataModel().get(i).getEmployeeID(),
                        getAvailableEmployeeInDataModel().get(i).getEmployeeName(),
                        drlLlocationId.getValue().toString(), null, "01"));
                getAvailableEmployeeInDataModel().remove(i);
                i--;
                rowCounterForAssignedUser++;
            }
        }
        return null;




    }

    public String btnRemove_action() {
        for (int i = 0; i < getAvilableEmployeeInGroup().size(); i++) {
            if (getAvilableEmployeeInGroup().get(i).isSelected()) {
                getAvailableEmployeeInDataModel().add(new AvilableEmployeeDataModel(
                        getAvilableEmployeeInGroup().get(i).getEmployeeId(),
                        getAvilableEmployeeInGroup().get(i).getEmployeeName(),
                        getAvilableEmployeeInGroup().get(i).getEmployeeGroupId()));
                getAvilableEmployeeInGroup().remove(i);
                i--;
                rowCounterForAssignedUser--;
            }
        }
        //return null means stay on the same page
        return null;
    }

    public String btnAddAll_action() {
        for (int i = 0; i < getAvailableEmployeeInDataModel().size(); i++) {
            getAvilableEmployeeInGroup().add(new AvilableEmployeeInGroup(
                    getAvailableEmployeeInDataModel().get(i).getEmployeeID(),
                    getAvailableEmployeeInDataModel().get(i).getEmployeeName(),
                    null, drlLlocationId.getValue().toString(), "01"));
            getAvailableEmployeeInDataModel().remove(i);
            i--;
            rowCounterForAssignedUser++;
        }
        //return null means stay on the same page
        return null;
    }

    public String btnRemoveAll_action() {
        for (int i = 0; i < getAvilableEmployeeInGroup().size(); i++) {
            getAvailableEmployeeInDataModel().add(new AvilableEmployeeDataModel(
                    getAvilableEmployeeInGroup().get(i).getEmployeeId(),
                    getAvilableEmployeeInGroup().get(i).getEmployeeName(),
                    getAvilableEmployeeInGroup().get(i).getLocationId()));
            getAvilableEmployeeInGroup().remove(i);
            i--;
            rowCounterForAssignedUser--;
        }
        //return null means stay on the same page
        return null;
    }

    public String btnLoadEmployeeList_action() {
        //return null means stay on the same page
        return null;
    }

    public String commandLink1_action() {
        try {
            String departmentName;
            String department = tree1.getCurrentNode().toString();//.substring(0, 2);
            String _department[] = department.split("#");
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID =
                        Integer.parseInt(_department[1].trim());
                lblDepartmentName.setValue(departmentName);
                panelLayout3.setRendered(false);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

//return null means stay on the same page
        return null;
    }

    public String btnTree_action() {

        LoadTree loadTree = new LoadTree();
        this.tree1Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        panelLayout3.setRendered(true);

        //return null means stay on the same page
        return null;
    }

    public String btnAddEmployee_action() {
        try {
            if (DEPARRTMENT_ID != 0) {
                createObject();
                ArrayList<HashMap> employeeList = assignEmployeeInLocationManager.listOFEmployee(Integer.toString(DEPARRTMENT_ID));
                for (HashMap hm : employeeList) {
                    getAvailableEmployeeInDataModel().add(new AvilableEmployeeDataModel(
                            hm.get("EMPLOYEEID").toString(),
                            hm.get("FULL_NAME").toString(),
                            drlLlocationId.getValue().toString()));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }

    private void createObject() {
        if (assignEmployeeInLocationManager == null) {
            assignEmployeeInLocationManager = new AssignEmployeeInLocationManager();
        }
    }

    public void drlLlocationId_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            getAvilableEmployeeInGroup().clear();
            getAvailableEmployeeInDataModel().clear();
            ArrayList<HashMap> employeeLists = assignEmployeeInLocationManager.listOFEmployeeByLoCation(vce.getNewValue().toString());
            for (HashMap hm : employeeLists) {
                getAvilableEmployeeInGroup().add(new AvilableEmployeeInGroup(
                        hm.get("EMPLOYEEID").toString(),
                        hm.get("FULL_NAME").toString(),
                        hm.get("EMPLOCATIONID").toString(),
                        hm.get("LOCATIONID").toString(),
                        hm.get("EMP_STATUS").toString()));
            }
        }
    }

    public void commandLink1_processAction(ActionEvent ae) {
        try {
            String departmentName;
            String department = tree1.getCurrentNode().toString();//.substring(0, 2);
            String _department[] = department.split("#");
            if (_department.length > 1) {
                departmentName = _department[0];
                DEPARRTMENT_ID =
                        Integer.parseInt(_department[1].trim());
                lblDepartmentName.setValue(departmentName);
                panelLayout3.setRendered(false);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private Set<HashMap> employeeGroupForInsert() {
        Set<HashMap> periodList = new HashSet<HashMap>();
        if (tblAssgnedUsers.getRowCount() > 0) {
            for (AvilableEmployeeInGroup employeeInGroup : getAvilableEmployeeInGroup()) {
                HashMap _list = new HashMap();
                _list.put("employeeid", employeeInGroup.getEmployeeId());
                _list.put("locationId", employeeInGroup.getLocationId());
                periodList.add(_list);
            }
        }
        return periodList;
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

    public String button1_action() {
            createObject();
        ArrayList<HashMap> employeeList = assignEmployeeInLocationManager.listOFEmployeeNotAssign();
        for (HashMap hm : employeeList) {
              getAvailableEmployeeInDataModel().add(new AvilableEmployeeDataModel(
                        hm.get("EMPLOYEEID").toString(),
                        hm.get("FULL_NAME").toString(),
                        null
                        ));
        }
//        for (HashMap hm : employeeList) {
//            getAvailableEmployeeInDataModel().add(new AvilableEmployeeDataModel(
//                    hm.get("EMPLOYEEID").toString(),
//                    hm.get("FULL_NAME").toString(),
//                    txtEmployeeId.getValue().toString()));

//        }
        //return null means stay on the same page
        return null;
    }
}

