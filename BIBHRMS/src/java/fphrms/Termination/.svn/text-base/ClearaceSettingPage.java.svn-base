 /*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Termination;

import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputHidden;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.clearanceManager.ClearanceManager;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.CommonValidation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class ClearaceSettingPage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;
    private ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<HashMap> readAvailableDepartments = new ArrayList<HashMap>();
    private ClearanceManager clearanceManager = new ClearanceManager();
    private int selectedRow;

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
    private HtmlDataTable tblClearingDep = new HtmlDataTable();

    public HtmlDataTable getTblClearingDep() {
        return tblClearingDep;
    }
    private ArrayList<AvilableDepartmentDataModel> availabledepartment = new ArrayList<AvilableDepartmentDataModel>();

    public ArrayList<AvilableDepartmentDataModel> getAvailabledepartment() {
        return availabledepartment;
    }

    public void setAvailabledepartment(ArrayList<AvilableDepartmentDataModel> availabledepartment) {
        this.availabledepartment = availabledepartment;
    }

    public void setTblClearingDep(HtmlDataTable hdt) {
        this.tblClearingDep = hdt;
    }
    private HtmlOutputLabel outputLabel1 = new HtmlOutputLabel();

    public HtmlOutputLabel getOutputLabel1() {
        return outputLabel1;
    }

    public void setOutputLabel1(HtmlOutputLabel hol) {
        this.outputLabel1 = hol;
    }
    private HtmlInputHidden inputHidden1 = new HtmlInputHidden();

    public HtmlInputHidden getInputHidden1() {
        return inputHidden1;
    }

    public void setInputHidden1(HtmlInputHidden hih) {
        this.inputHidden1 = hih;
    }
    private HtmlSelectBooleanCheckbox ckboClearing = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkboClearing() {
        return ckboClearing;
    }

    public void setCkboClearing(HtmlSelectBooleanCheckbox hsbc) {
        this.ckboClearing = hsbc;
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
    private HtmlSelectOneMenu lstMainDepartment = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstMainDepartment() {
        return lstMainDepartment;
    }

    public void setLstMainDepartment(HtmlSelectOneMenu hsom) {
        this.lstMainDepartment = hsom;
    }

    public ArrayList<SelectItem> getZerf() {
        zerf = departmentManage.getDepartmentName();
        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }

    public ArrayList<HashMap> getReadAvailableDepartments() {
        return readAvailableDepartments;
    }

    public void setReadAvailableDepartments(ArrayList<HashMap> readAvailableDepartments) {
        this.readAvailableDepartments = readAvailableDepartments;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ClearaceSettingPage() {
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
        getAvailabledepartment().clear();
        readAvailableDepartments = clearanceManager.readAvailableDpartment();
        for (int i = 0; i < readAvailableDepartments.size(); i++) {
            HashMap mapResourceData = readAvailableDepartments.get(i);
            getAvailabledepartment().add(
                    new AvilableDepartmentDataModel(
                    Integer.valueOf(mapResourceData.get("depID").toString()),
                    mapResourceData.get("description").toString(),
                    Boolean.valueOf(mapResourceData.get("depStatus").toString())));
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

    public static class AvilableDepartmentDataModel implements Serializable {

        private int depID;
        private String description;
        private boolean status;
        private boolean selected;

        public boolean getSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public AvilableDepartmentDataModel() {
        }

        public boolean getStatus() {

            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDepID() {
            return depID;
        }

        public void setDepID(int depID) {
            this.depID = depID;
        }

        public AvilableDepartmentDataModel(int depID, String description, boolean status) {
            this.depID = depID;
            this.description = description;
            this.status = status;
        }
    }

    public void lstMainDepartment_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                getAvailabledepartment().clear();
                readAvailableDepartments = clearanceManager.readAvailableDpartment();
                for (int i = 0; i < readAvailableDepartments.size(); i++) {
                    HashMap mapResourceData = readAvailableDepartments.get(i);
                    getAvailabledepartment().add(
                            new AvilableDepartmentDataModel(
                            Integer.valueOf(mapResourceData.get("depID").toString()),
                            mapResourceData.get("description").toString(),
                            Boolean.valueOf(mapResourceData.get("depStatus").toString())));
                }
            }
        }
    }

    public void rowSelector5_processAction(RowSelectorEvent rse) {
        selectedRow = rse.getRow();

    }

    public void ckboClearing_processValueChange(ValueChangeEvent vce) {
        selectedRow = tblClearingDep.getRowIndex();
        String empId = String.valueOf(availabledepartment.get(selectedRow).getDepID());
        try {
            if (clearanceManager.UpdateClearDepartments(empId, vce.getNewValue().toString()) == 1) {
            } else {
            }
        } catch (Exception ex) {
        }
    }
}
