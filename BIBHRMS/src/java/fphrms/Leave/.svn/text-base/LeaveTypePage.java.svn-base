/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Leave;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.ConfirmationPanelBean;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.faces.FacesException;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.HRValidation;
import manager.leaveManager.LeaveTypeManager;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LeaveTypePage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private ArrayList<SelectItem> selectLeaveType = new ArrayList<SelectItem>();
    private ArrayList<LeaveTypeInnerClass> leaveTypeList = new ArrayList<LeaveTypeInnerClass>();
    private ConfirmationPanelBean confirmationPanelBean = new ConfirmationPanelBean();
    private static int tableSize = 0;
    private static int rowCounter = 0;
    private boolean initLoad = true;
    private static int leaveTypeId = 0;
    private LeaveTypeManager leaveTypeManager = new LeaveTypeManager();

    public ArrayList<SelectItem> getSelectLeaveType() {
        return selectLeaveType;
    }

    public void setSelectLeaveType(ArrayList<SelectItem> selectLeaveType) {
        this.selectLeaveType = selectLeaveType;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        setSelectLeaveType(LeaveTypeManager.getLeveTypes());
        disableComponet();
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
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
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems1() {
        return selectOneListbox1DefaultItems1;
    }

    public void setSelectOneListbox1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems2() {
        return selectOneListbox1DefaultItems2;
    }

    public void setSelectOneListbox1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems3() {
        return selectOneListbox1DefaultItems3;
    }

    public void setSelectOneListbox1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems3 = dsia;
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
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlSelectOneMenu lstTrainingCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstTrainingCategory() {
        return lstTrainingCategory;
    }

    public void setLstTrainingCategory(HtmlSelectOneMenu hsom) {
        this.lstTrainingCategory = hsom;
    }
    private HtmlInputText txtLeaveTypeName = new HtmlInputText();

    public HtmlInputText getTxtLeaveTypeName() {
        return txtLeaveTypeName;
    }

    public void setTxtLeaveTypeName(HtmlInputText hit) {
        this.txtLeaveTypeName = hit;
    }
    private HtmlInputText txtMinimumDays = new HtmlInputText();

    public HtmlInputText getTxtMinimumDays() {
        return txtMinimumDays;
    }

    public void setTxtMinimumDays(HtmlInputText hit) {
        this.txtMinimumDays = hit;
    }
    private HtmlInputTextarea txtRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(HtmlInputTextarea hit) {
        this.txtRemark = hit;
    }
    private HtmlCommandButton btnAddLeaveType = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddLeaveType() {
        return btnAddLeaveType;
    }

    public void setBtnAddLeaveType(HtmlCommandButton hcb) {
        this.btnAddLeaveType = hcb;
    }
    private HtmlCommandButton btnNewLeaveType = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewLeaveType() {
        return btnNewLeaveType;
    }

    public void setBtnNewLeaveType(HtmlCommandButton hcb) {
        this.btnNewLeaveType = hcb;
    }
    private HtmlCommandButton btnSaveLeaveType = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveLeaveType() {
        return btnSaveLeaveType;
    }

    public void setBtnSaveLeaveType(HtmlCommandButton hcb) {
        this.btnSaveLeaveType = hcb;
    }
    private HtmlCommandButton btnEditLeaveType = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditLeaveType() {
        return btnEditLeaveType;
    }

    public void setBtnEditLeaveType(HtmlCommandButton hcb) {
        this.btnEditLeaveType = hcb;
    }
    private HtmlCommandButton btnUpdateLeaveType = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateLeaveType() {
        return btnUpdateLeaveType;
    }

    public void setBtnUpdateLeaveType(HtmlCommandButton hcb) {
        this.btnUpdateLeaveType = hcb;
    }
    private HtmlCommandButton btnDeleteLeaveType = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteLeaveType() {
        return btnDeleteLeaveType;
    }

    public void setBtnDeleteLeaveType(HtmlCommandButton hcb) {
        this.btnDeleteLeaveType = hcb;
    }
    private HtmlCommandButton btnCancelLeaveType = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelLeaveType() {
        return btnCancelLeaveType;
    }

    public void setBtnCancelLeaveType(HtmlCommandButton hcb) {
        this.btnCancelLeaveType = hcb;
    }
    private HtmlOutputLabel lblTrainerId = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTrainerId() {
        return lblTrainerId;
    }

    public void setLblTrainerId(HtmlOutputLabel hol) {
        this.lblTrainerId = hol;
    }

    public ArrayList<LeaveTypeInnerClass> getLeaveTypeList() {
        return leaveTypeList;
    }

    public void setLeaveTypeList(ArrayList<LeaveTypeInnerClass> leaveTypeList) {
        this.leaveTypeList = leaveTypeList;
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
    private HtmlDataTable dataTableTrainerInfo = new HtmlDataTable();

    public HtmlDataTable getDataTableTrainerInfo() {
        return dataTableTrainerInfo;
    }

    public void setDataTableTrainerInfo(HtmlDataTable hdt) {
        this.dataTableTrainerInfo = hdt;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox4Bean() {
        return selectBooleanCheckbox4Bean;
    }

    public void setSelectBooleanCheckbox4Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox4Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox5Bean() {
        return selectBooleanCheckbox5Bean;
    }

    public void setSelectBooleanCheckbox5Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox5Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox6Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox6Bean() {
        return selectBooleanCheckbox6Bean;
    }

    public void setSelectBooleanCheckbox6Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox6Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private HtmlInputText txtMaximumDays = new HtmlInputText();

    public HtmlInputText getTxtMaximumDays() {
        return txtMaximumDays;
    }

    public void setTxtMaximumDays(HtmlInputText hit) {
        this.txtMaximumDays = hit;
    }
    private HtmlSelectBooleanCheckbox choFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoFemale() {
        return choFemale;
    }

    public void setChoFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.choFemale = hsbc;
    }
    private HtmlSelectBooleanCheckbox choMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMale() {
        return choMale;
    }

    public void setChoMale(HtmlSelectBooleanCheckbox hsbc) {
        this.choMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox choBoth = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoBoth() {
        return choBoth;
    }

    public void setChoBoth(HtmlSelectBooleanCheckbox hsbc) {
        this.choBoth = hsbc;
    }
    private HtmlSelectBooleanCheckbox choNormal = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoNormal() {
        return choNormal;
    }

    public void setChoNormal(HtmlSelectBooleanCheckbox hsbc) {
        this.choNormal = hsbc;
    }
    private HtmlSelectBooleanCheckbox choTOHigherWorker = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoTOHigherWorker() {
        return choTOHigherWorker;
    }

    public void setChoTOHigherWorker(HtmlSelectBooleanCheckbox hsbc) {
        this.choTOHigherWorker = hsbc;
    }
    private HtmlSelectBooleanCheckbox choBothForPostion = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoBothForPostion() {
        return choBothForPostion;
    }

    public void setChoBothForPostion(HtmlSelectBooleanCheckbox hsbc) {
        this.choBothForPostion = hsbc;
    }
    private HtmlSelectOneMenu drlLeaveType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLeaveType() {
        return drlLeaveType;
    }

    public void setDrlLeaveType(HtmlSelectOneMenu hsom) {
        this.drlLeaveType = hsom;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LeaveTypePage() {
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
        txtLeaveTypeName.setRequired(true);
        txtLeaveTypeName.setRequiredMessage("Required.");
        txtMinimumDays.setRequired(true);
        txtMinimumDays.setRequiredMessage("Required.");
        if (initLoad) {
            initLoad = false;
            ArrayList<HashMap> leaveTypeLists = leaveTypeManager.leaveTypeListInformation();
            if (leaveTypeLists != null) {
                tableSize = 0;
                getLeaveTypeList().clear();
                for (HashMap hm : leaveTypeLists) {
                    getLeaveTypeList().add(new LeaveTypeInnerClass(
                            Integer.valueOf(hm.get("LEAVETYPEID").toString()),
                            String.valueOf(hm.get("LEAVETYPENAME").toString()),
                            String.valueOf(hm.get("LEAVE_TYPE").toString()),
                            String.valueOf(hm.get("MINIUMDAYS").toString()),
                            String.valueOf(hm.get("MAXIMUMDAYS").toString()),
                            String.valueOf(hm.get("FORGENDER").toString()),
                            String.valueOf(hm.get("FOREMPLOYMENTTYPE").toString()),
                            String.valueOf(hm.get("REMARK").toString())));
                    tableSize++;
                }
            }
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
    public static class LeaveTypeInnerClass implements Serializable {

        private int leaveTypeId;
        private String leaveTypeName;
        private String leaveType;
        private String minimumDays;
        private String maximumDays;
        private String forGender;
        private String forEmploymentType;
        private String remark;
        private boolean selected;

        public String getForEmploymentType() {
            return forEmploymentType;
        }

        public void setForEmploymentType(String forEmploymentType) {
            this.forEmploymentType = forEmploymentType;
        }

        public String getForGender() {
            return forGender;
        }

        public void setForGender(String forGender) {
            this.forGender = forGender;
        }

        public String getLeaveType() {
            return leaveType;
        }

        public void setLeaveType(String leaveType) {
            this.leaveType = leaveType;
        }

        public int getLeaveTypeId() {
            return leaveTypeId;
        }

        public void setLeaveTypeId(int leaveTypeId) {
            this.leaveTypeId = leaveTypeId;
        }

        public String getLeaveTypeName() {
            return leaveTypeName;
        }

        public void setLeaveTypeName(String leaveTypeName) {
            this.leaveTypeName = leaveTypeName;
        }

        public String getMaximumDays() {
            return maximumDays;
        }

        public void setMaximumDays(String maximumDays) {
            this.maximumDays = maximumDays;
        }

        public String getMinimumDays() {
            return minimumDays;
        }

        public void setMinimumDays(String minimumDays) {
            this.minimumDays = minimumDays;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public LeaveTypeInnerClass(
                int leaveTypeId,
                String leaveTypeName,
                String leaveType,
                String minimumDays,
                String maximumDays,
                String forGender,
                String forEmploymentType,
                String remark) {
            this.leaveTypeId = leaveTypeId;
            this.leaveTypeName = leaveTypeName;
            this.leaveType = leaveType;
            this.minimumDays = minimumDays;
            this.maximumDays = maximumDays;
            this.forGender = forGender;
            this.forEmploymentType = forEmploymentType;
            this.remark = remark;
        }
    }

    private Set<HashMap> leaveTypeInfo() {
        Set<HashMap> rateList = new HashSet<HashMap>();
        if (getLeaveTypeList().size() > 0) {
            for (LeaveTypeInnerClass lt : getLeaveTypeList().subList(tableSize, tableSize + rowCounter)) {
                HashMap _list = new HashMap();
                _list.put("leaveTypeName", lt.getLeaveTypeName());
                _list.put("leaveType", lt.getLeaveType());
                _list.put("forGender", lt.getForGender());
                _list.put("forPostion", lt.getForEmploymentType());
                _list.put("leaveTypeId", lt.getLeaveTypeId());
                _list.put("maximumDays", lt.getMaximumDays());
                _list.put("minimumDays", lt.getMinimumDays());
                _list.put("remark", lt.getRemark());
                rateList.add(_list);
            }
        }
        return rateList;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setVisible(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(); $j('." + val + "').fadeOut(" + fadeTime + ");});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btnNewTrainingType_action() {
        //return null means stay on the same page



        return null;
    }

    public String btnCancelTrainingType_action() {
        //return null means stay on the same page



        return null;
    }

    public String btnEditTainingType_action() {
        //return null means stay on the same page

        return null;
    }

    public String btnSavetrainingType_action() {
        //return null means stay on the same page
//        String category = null;
//        String description = null;
//        String remark = null;
//        if (getLstTrainingCategory().getValue() != null) {
//            category = getLstTrainingCategory().getValue().toString();
//        }
//        if (getTxtTrainingTypeDesc().getValue() != null) {
//            description = getTxtTrainingTypeDesc().getValue().toString();
//        }
//        if (getTxtAreaTrainingTypeRemark().getValue() != null) {
//            remark = getTxtAreaTrainingTypeRemark().getValue().toString();
//        }
//        trainingControl.saveTrainingType(
//                getLstTrainingCategory().getValue().toString(),
//                getTxtTrainingTypeDesc().getValue().toString(),
//                getTxtAreaTrainingTypeRemark().getValue().toString());
//
//        transactionTrainingType = 0;
//        txtTrainingTypeDesc.setValue(null);
//        txtAreaTrainingTypeRemark.setValue(null);
//        lstTrainingCategory.setValue("0");
//        lstTrainingCategory.setDisabled(true);
//        txtTrainingTypeDesc.setDisabled(true);
//        txtAreaTrainingTypeRemark.setDisabled(true);
//        lstTrainingType.setDisabled(false);
//        btnNewTrainingType.setDisabled(false);
//        btnCancelTrainingType.setDisabled(true);
//        btnSavetrainingType.setDisabled(true);
//        btnDeleteTrainingType.setDisabled(false);
//        btnEditTainingType.setDisabled(false);
//        btnUpdateTrainingType.setDisabled(true);
        return null;
    }

    public String btnUpdateTrainingType_action() {
        //return null means stay on the same page
//        String description = null;
//        String remark = null;
//        String category = null;
//        if (getLstTrainingCategory().getValue() != null) {
//            category = getLstTrainingCategory().getValue().toString();
//        }
//        if (getTxtTrainingTypeDesc().getValue() != null) {
//            description = getTxtTrainingTypeDesc().getValue().toString();
//        }
//        if (getTxtAreaTrainingTypeRemark().getValue() != null) {
//            remark = getTxtAreaTrainingTypeRemark().getValue().toString();
//        }
//        trainingControl.updateTrainingType(lblTrainingTypeId.getValue().toString(), description, remark, category);
//
//        transactionTrainingType = 0;
//        lstTrainingCategory.setDisabled(true);
//        txtTrainingTypeDesc.setDisabled(true);
//        txtAreaTrainingTypeRemark.setDisabled(true);
//        lstTrainingType.setDisabled(false);
//        btnNewTrainingType.setDisabled(false);
//        btnCancelTrainingType.setDisabled(false);
//        btnSavetrainingType.setDisabled(true);
//        btnDeleteTrainingType.setDisabled(false);
//        btnEditTainingType.setDisabled(true);
//        btnUpdateTrainingType.setDisabled(true);

        return null;
    }

    public void drlParentTrainingType_processValueChange(ValueChangeEvent vce) {
    }

    public void lstTrainingType_processValueChange(ValueChangeEvent vce) {
        try {
//            if (!CommonValidation.isUpdatePhase(vce)) {
//                if (vce.getNewValue() != null) {
//                    OracleCachedRowSet rs = trainingControl.searchTrainingTypeList(vce.getNewValue().toString());
//                    if (rs.next()) {
//                        this.lblTrainingTypeId.setValue(rs.getString("training_type_id"));
//                        this.txtTrainingTypeDesc.setValue(rs.getString("description"));
//                        this.txtAreaTrainingTypeRemark.setValue(rs.getString("remark"));
//                        this.lstTrainingCategory.setValue(rs.getString("category"));
//                    }
//                }
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public String btnNewTrainingCategory_action() {
        //return null means stay on the same page       
        txtAreaTrainingCategoryRemark.setValue(null);
        txtAreaTrainingCategoryRemark.setDisabled(false);
        lstTrainingCategoy.setDisabled(true);
        btnCancelTrainingCategory.setDisabled(false);
        btnDeleteTrainingCategory.setDisabled(true);
        btnEditTainingCategory.setDisabled(true);
        btnNewTrainingCategory.setDisabled(true);
        btnSaveLeaveType.setDisabled(false);
        return null;
    }

    public String btnUpdateTrainingCategory_action() {
        //return null means stay on the same page
        String description = null;
        String remark = null;
//        if (getTxtTrainingCategoryName().getValue() != null) {
//            description = getTxtTrainingCategoryName().getValue().toString();
//        }
        if (getTxtAreaTrainingCategoryRemark().getValue() != null) {
            remark = getTxtAreaTrainingCategoryRemark().getValue().toString();
        }
        // trainingControl.updateTrainingCategory(lblCategoryID.getValue().toString(), description, remark);

        //  txtTrainingCategoryName.setDisabled(true);
        txtAreaTrainingCategoryRemark.setDisabled(true);
        lstTrainingCategoy.setDisabled(false);
        btnCancelTrainingCategory.setDisabled(true);
        btnDeleteTrainingCategory.setDisabled(false);
        btnEditTainingCategory.setDisabled(false);
        btnNewTrainingCategory.setDisabled(false);
        btnSaveLeaveType.setDisabled(true);
        btnUpdateLeaveType.setDisabled(true);
        return null;
    }

    public String btnDeleteTrainingCategory_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCancelTrainingCategory_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdLeaveApprove_action() {
        //return null means stay on the same page
        return "LeaveApprove";
    }

    public String btnNewTrainer_action() {
        //return null means stay on the same page
        txtLeaveTypeName.setValue(null);
        txtMinimumDays.setValue(null);
        txtRemark.setValue(null);

        txtLeaveTypeName.setDisabled(false);
        txtMinimumDays.setDisabled(false);
        txtRemark.setDisabled(false);

        btnAddLeaveType.setDisabled(false);
        btnNewLeaveType.setDisabled(true);
        btnSaveLeaveType.setDisabled(false);
        btnEditLeaveType.setDisabled(true);
        btnUpdateLeaveType.setDisabled(true);
        btnCancelLeaveType.setDisabled(false);
        btnDeleteLeaveType.setDisabled(true);
        return null;
    }

    public String cmdTrainer_action() {
        //return null means stay on the same page
        return "Trainner";
    }

    public String cmdLeaveTransferRequest_action() {
        //return null means stay on the same page
        return "LeaveTransferRequest";
    }

    public String cmdLeaveBalance_action() {
        //return null means stay on the same page
        return "LeaveBalance";
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    private void disableComponet() {

        txtLeaveTypeName.setDisabled(true);
        txtMinimumDays.setDisabled(true);
        txtMaximumDays.setDisabled(true);
        txtRemark.setDisabled(true);
        drlLeaveType.setDisabled(true);


        choBoth.setDisabled(true);
        choMale.setDisabled(true);
        choFemale.setDisabled(true);
        choTOHigherWorker.setDisabled(true);
        choNormal.setDisabled(true);
        choBothForPostion.setDisabled(true);
        drlLeaveType.setDisabled(true);
    }

    private void enableComponet() {


        txtLeaveTypeName.setDisabled(false);
        txtMinimumDays.setDisabled(false);
        txtMaximumDays.setDisabled(false);
        txtRemark.setDisabled(false);
        drlLeaveType.setDisabled(false);


        choBoth.setDisabled(false);
        choMale.setDisabled(false);
        choFemale.setDisabled(false);
        choTOHigherWorker.setDisabled(false);
        choNormal.setDisabled(false);
        choBothForPostion.setDisabled(false);
        drlLeaveType.setDisabled(false);
    }

    private void clearComponet() {
        txtLeaveTypeName.setValue(null);
        txtMinimumDays.setValue(null);
        txtMaximumDays.setValue(null);
        txtRemark.setValue(null);
        drlLeaveType.setValue("-1");

        choBoth.setSelected(false);
        choMale.setSelected(false);
        choFemale.setSelected(false);
        choTOHigherWorker.setSelected(false);
        choNormal.setSelected(false);
        choBothForPostion.setSelected(false);


    }

    public void rwSelectorPeriodList_processMyEvent(RowSelectorEvent rse) {
        int row = dataTableTrainerInfo.getRowIndex();
        if (row > -1) {
            clearComponet();
            txtLeaveTypeName.resetValue();
            txtMinimumDays.resetValue();
            txtRemark.resetValue();
            txtLeaveTypeName.resetValue();
            txtMinimumDays.resetValue();
            txtRemark.resetValue();
            txtLeaveTypeName.resetValue();
            txtMaximumDays.resetValue();
            txtRemark.resetValue();
            drlLeaveType.resetValue();
            btnAddLeaveType.setDisabled(true);
            btnNewLeaveType.setDisabled(true);
            btnSaveLeaveType.setDisabled(true);
            btnEditLeaveType.setDisabled(false);
            btnUpdateLeaveType.setDisabled(false);
            btnCancelLeaveType.setDisabled(false);
            btnDeleteLeaveType.setDisabled(false);
            disableComponet();
            leaveTypeId = Integer.valueOf(getLeaveTypeList().get(row).getLeaveTypeId());
            txtLeaveTypeName.setValue(getLeaveTypeList().get(row).getLeaveTypeName());
            txtMinimumDays.setValue(getLeaveTypeList().get(row).getMinimumDays());
            txtMaximumDays.setValue(getLeaveTypeList().get(row).getMaximumDays());
            drlLeaveType.setValue(getLeaveTypeList().get(row).getLeaveType());
            if (getLeaveTypeList().get(row).getForGender().equals("Both")) {
                choMale.setSelected(false);
                choFemale.setSelected(false);
                choBoth.setSelected(true);
            } else if (getLeaveTypeList().get(row).getForGender().equals("Female")) {
                choMale.setSelected(false);
                choFemale.setSelected(true);
                choBoth.setSelected(false);
            } else if (getLeaveTypeList().get(row).getForGender().equals("Male")) {
                choMale.setSelected(true);
                choFemale.setSelected(false);
                choBoth.setSelected(false);
            }
            if (getLeaveTypeList().get(row).getForEmploymentType().equals("Both")) {
                choTOHigherWorker.setSelected(false);
                choNormal.setSelected(false);
                choBothForPostion.setSelected(true);
            } else if (getLeaveTypeList().get(row).getForEmploymentType().equals("Normal")) {
                choTOHigherWorker.setSelected(false);
                choNormal.setSelected(true);
                choBothForPostion.setSelected(false);
            } else if (getLeaveTypeList().get(row).getForEmploymentType().equals("HigherWorker")){
                choTOHigherWorker.setSelected(true);
                choNormal.setSelected(false);
                choBothForPostion.setSelected(false);
            }
            txtRemark.setValue(getLeaveTypeList().get(row).getRemark());
            txtMaximumDays.setValue(getLeaveTypeList().get(row).getMaximumDays());

        }
    }

    public String btnUpdateTrainer_action() {
        //return null means stay on the same page
        String companyName = "";
        String contactAddress = "";
        String remark = "";
        try {
            if (!txtLeaveTypeName.getValue().equals(null)) {
                companyName = txtLeaveTypeName.getValue().toString();
            }
            if (!txtMinimumDays.getValue().equals(null)) {
                contactAddress = txtMinimumDays.getValue().toString();
            }
            if (!txtRemark.getValue().equals(null)) {
                remark = txtRemark.getValue().toString();
            }

        } catch (Exception ex) {
        }
        return null;
    }

    public String btnDeleteTrainer_action() {
        if (leaveTypeManager.deleteLeaveType(leaveTypeId) == 1) {
            initLoad = true;
            showSuccessOrFailureMessage(true, "Company information is/are successfully deleted.");
            txtLeaveTypeName.setValue(null);
            txtMinimumDays.setValue(null);
            txtRemark.setValue(null);

            txtLeaveTypeName.setDisabled(true);
            txtMinimumDays.setDisabled(true);
            txtRemark.setDisabled(true);

            btnAddLeaveType.setDisabled(true);
            btnNewLeaveType.setDisabled(false);
            btnSaveLeaveType.setDisabled(true);
            btnEditLeaveType.setDisabled(true);
            btnUpdateLeaveType.setDisabled(true);
            btnCancelLeaveType.setDisabled(true);
            btnDeleteLeaveType.setDisabled(true);
        } else {
            showSuccessOrFailureMessage(false, "Error occurred while deleting the company information.");
        }
        return null;
    }

    public String btnCancelTrainer_action() {
        //return null means stay on the same page
        initLoad = true;
        txtLeaveTypeName.setValue(null);
        txtMinimumDays.setValue(null);
        txtRemark.setValue(null);

        txtLeaveTypeName.setDisabled(true);
        txtMinimumDays.setDisabled(true);
        txtRemark.setDisabled(true);

        btnAddLeaveType.setDisabled(true);
        btnNewLeaveType.setDisabled(false);
        btnSaveLeaveType.setDisabled(true);
        btnEditLeaveType.setDisabled(true);
        btnUpdateLeaveType.setDisabled(true);
        btnCancelLeaveType.setDisabled(true);
        btnDeleteLeaveType.setDisabled(true);
        return null;
    }

    public void choFemale_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (choFemale.isSelected()) {
                choBoth.setSelected(false);
                choMale.setSelected(false);
            } else {
                choFemale.setSelected(false);
            }

        }
    }

    public void choMale_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (choMale.isSelected()) {
                choBoth.setSelected(false);
                choFemale.setSelected(false);
            } else {
                choMale.setSelected(false);
            }

        }
    }

    public void choBoth_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (choBoth.isSelected()) {
                choMale.setSelected(false);
                choFemale.setSelected(false);
            } else {
                choBoth.setSelected(false);
            }

        }
    }

    public void choNormal_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (choNormal.isSelected()) {
                choBothForPostion.setSelected(false);
                choTOHigherWorker.setSelected(false);
            } else {
                choNormal.setSelected(false);
            }

        }
    }

    public void choTOHigherWorker_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (choTOHigherWorker.isSelected()) {
                choBothForPostion.setSelected(false);
                choNormal.setSelected(false);
            } else {
                choTOHigherWorker.setSelected(false);
            }

        }
    }

    public void choBothForPostion_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (choBothForPostion.isSelected()) {
                choTOHigherWorker.setSelected(false);
                choNormal.setSelected(false);
            } else {
                choBothForPostion.setSelected(false);
            }

        }
    }

    public String btnEditLeaveType_action() {


        enableComponet();
        //  txtTrainingCategoryName.setDisabled(false);
        txtAreaTrainingCategoryRemark.setDisabled(false);
        lstTrainingCategoy.setDisabled(true);
        btnCancelTrainingCategory.setDisabled(false);
        btnDeleteTrainingCategory.setDisabled(true);
        btnEditTainingCategory.setDisabled(true);
        btnNewTrainingCategory.setDisabled(true);
        btnSaveLeaveType.setDisabled(true);
        btnUpdateLeaveType.setDisabled(false);
         btnCancelLeaveType.setDisabled(false);
         btnAddLeaveType.setDisabled(true);



        //return null means stay on the same page
        return null;
    }

    public String btnAddLeaveType_action() {
        //return null means stay on the same page
        String leaveTypeName = "";
        String leaveType = "";
        String minimumDays = "";
        String maximumDays = "";
        String contactAddress = "";
        String forGender = "";
        String remark = "";
        String forPostion = "";
        boolean result = true;
        String errorMessage = "Required";
        int errorValue = 0;
        try {
            if (HRValidation.validateRequired(drlLeaveType.getValue())) {
                remark = txtRemark.getValue().toString();
            } else {
                remark = " ";
            }

            errorValue = HRValidation.validateData(
                    this.txtLeaveTypeName.getValue(),
                    HRValidation.NAME_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtLeaveTypeName).setValid(false);
                    error(txtLeaveTypeName, errorMessage);
                } else {
                    ((UIInput) txtLeaveTypeName).setValid(false);
                    error(txtLeaveTypeName, "Invalid Value");
                }
            } else {
                leaveTypeName = txtLeaveTypeName.getValue().toString();
            }

            errorValue = HRValidation.validateData(
                    this.txtMinimumDays.getValue(),
                    HRValidation.NUMBER_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtMinimumDays).setValid(false);
                    error(txtMinimumDays, errorMessage);
                } else {
                    ((UIInput) txtMinimumDays).setValid(false);
                    error(txtMinimumDays, "Invalid Value");
                }
            } else {
                minimumDays = txtMinimumDays.getValue().toString();
            }
            errorValue = HRValidation.validateData(
                    this.txtMaximumDays.getValue(),
                    HRValidation.NUMBER_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtMaximumDays).setValid(false);
                    error(txtMaximumDays, errorMessage);
                } else {
                    ((UIInput) txtMaximumDays).setValid(false);
                    error(txtMaximumDays, "Invalid Value");
                }
            } else {
                maximumDays = txtMaximumDays.getValue().toString();
            }
            if (!HRValidation.validateRequired(drlLeaveType.getValue())) {
                ((UIInput) drlLeaveType).setValid(false);
                error(drlLeaveType, errorMessage);
                result = false;
            } else {
                leaveType = drlLeaveType.getValue().toString();
            }
            if (!choBoth.isSelected() && !choMale.isSelected() && !choFemale.isSelected()) {
                ((UIInput) choBoth).setValid(false);
                error(choBoth, errorMessage);
                result = false;
            } else {
                if (choBoth.isSelected()) {
                    forGender = "Both";
                } else if (choMale.isSelected()) {
                    forGender = "Male";

                } else if (choFemale.isSelected()) {
                    forGender = "Female";

                }
            }

            if (!choBothForPostion.isSelected() && !choNormal.isSelected() && !choTOHigherWorker.isSelected()) {
                ((UIInput) choBothForPostion).setValid(false);
                error(choBothForPostion, errorMessage);
                result = false;
            } else {
                if (choBothForPostion.isSelected()) {
                    forPostion = "Both";
                } else if (choNormal.isSelected()) {
                    forPostion = "Normal";

                } else if (choTOHigherWorker.isSelected()) {
                    forPostion = "HigherWorker";

                }
            }
            errorValue = HRValidation.validateData(this.txtRemark.getValue(),
                    HRValidation.REMARK_PATTERN, false);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtRemark).setValid(false);
                    error(txtRemark, errorMessage);
                } else {
                    ((UIInput) txtRemark).setValid(false);
                    error(txtRemark, "Invalid Value");
                }
            }
            if (result) {
                getLeaveTypeList().add(new LeaveTypeInnerClass(leaveTypeId,
                        leaveTypeName,
                        leaveType,
                        minimumDays,
                        maximumDays,
                        forGender,
                        forPostion,
                        remark));
                rowCounter++;
            }

//
        } catch (Exception ex) {
        }

        //return null means stay on the same page
        return null;
    }

    public String btnUpdateLeaveType_action() {
        try {
            String leaveTypeName = "";
            String leaveType = "";
            String minimumDays = "";
            String maximumDays = "";
            String contactAddress = "";
            String forGender = "";
            String remark = "";
            String forPostion = "";
            boolean result = true;
            String errorMessage = "Required";
            int errorValue = 0;
            errorValue = HRValidation.validateData(this.txtLeaveTypeName.getValue(), HRValidation.NAME_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtLeaveTypeName).setValid(false);
                    error(txtLeaveTypeName, errorMessage);
                } else {
                    ((UIInput) txtLeaveTypeName).setValid(false);
                    error(txtLeaveTypeName, "Invalid Value");
                }
            } else {
                leaveTypeName = txtLeaveTypeName.getValue().toString();
            }

            errorValue = HRValidation.validateData(this.txtMinimumDays.getValue(), HRValidation.NUMBER_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtMinimumDays).setValid(false);
                    error(txtMinimumDays, errorMessage);
                } else {
                    ((UIInput) txtMinimumDays).setValid(false);
                    error(txtMinimumDays, "Invalid Value");
                }
            } else {
                minimumDays = txtMinimumDays.getValue().toString();
            }
            errorValue = HRValidation.validateData(this.txtMaximumDays.getValue(), HRValidation.NUMBER_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtMaximumDays).setValid(false);
                    error(txtMaximumDays, errorMessage);
                } else {
                    ((UIInput) txtMaximumDays).setValid(false);
                    error(txtMaximumDays, "Invalid Value");
                }
            } else {
                maximumDays = txtMaximumDays.getValue().toString();
            }
            if (!HRValidation.validateRequired(drlLeaveType.getValue())) {
                ((UIInput) drlLeaveType).setValid(false);
                error(drlLeaveType, errorMessage);
                result = false;
            } else {
                leaveType = drlLeaveType.getValue().toString();
            }
            if (!choBoth.isSelected() && !choMale.isSelected() && !choFemale.isSelected()) {
                ((UIInput) choBoth).setValid(false);
                error(choBoth, errorMessage);
                result = false;
            } else {
                if (choBoth.isSelected()) {
                    forGender = "Both";
                } else if (choMale.isSelected()) {
                    forGender = "Male";

                } else if (choFemale.isSelected()) {
                    forGender = "Female";

                }
            }

            if (!choBothForPostion.isSelected() && !choNormal.isSelected() && !choTOHigherWorker.isSelected()) {
                ((UIInput) choBothForPostion).setValid(false);
                error(choBothForPostion, errorMessage);
                result = false;
            } else {
                if (choBothForPostion.isSelected()) {
                    forPostion = "Both";
                } else if (choNormal.isSelected()) {
                    forPostion = "Normal";

                } else if (choTOHigherWorker.isSelected()) {
                    forPostion = "HigherWorker";

                }
            }
            errorValue = HRValidation.validateData(this.txtRemark.getValue(), HRValidation.REMARK_PATTERN, false);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) txtRemark).setValid(false);
                    error(txtRemark, errorMessage);
                } else {
                    ((UIInput) txtRemark).setValid(false);
                    error(txtRemark, "Invalid Value");
                }
            } else {
                if (HRValidation.validateRequired(drlLeaveType.getValue())) {
                    remark = txtRemark.getValue().toString();
                } else {
                    remark = " ";
                }
            }

            if (result) {
                if (leaveTypeManager.updateLeaveType(
                        leaveTypeId,
                        leaveTypeName,
                        leaveType,
                        minimumDays,
                        maximumDays,
                        forGender,
                        forPostion,
                        remark) == 1) {
                    initLoad = true;
                    showSuccessOrFailureMessage(true, "LeaveType information is/are successfully updated.");

                    txtLeaveTypeName.setDisabled(true);
                    txtMinimumDays.setDisabled(true);
                    txtRemark.setDisabled(true);
                    btnAddLeaveType.setDisabled(true);
                    btnNewLeaveType.setDisabled(false);
                    btnSaveLeaveType.setDisabled(true);
                    btnEditLeaveType.setDisabled(true);
                    btnUpdateLeaveType.setDisabled(true);
                    btnCancelLeaveType.setDisabled(true);
                    btnDeleteLeaveType.setDisabled(true);
                    disableComponet();
                    clearComponet();
                } else {
                    showSuccessOrFailureMessage(false, "Error occurred while updating the LeaveTyp information.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnNewLeaveType_action() {
        clearComponet();
        enableComponet();
        btnAddLeaveType.setDisabled(false);
        btnSaveLeaveType.setDisabled(false);
        btnNewLeaveType.setDisabled(true);
        btnCancelLeaveType.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSaveLeaveType_action() {
        try {
            if (leaveTypeManager.addLeaveType(leaveTypeInfo()) == 1) {
                showSuccessOrFailureMessage(true, "LeaveType information is/are successfully saved.");
                txtLeaveTypeName.setDisabled(true);
                txtMinimumDays.setDisabled(true);
                txtRemark.setDisabled(true);
                disableComponet();
                clearComponet();
                btnAddLeaveType.setDisabled(true);
                btnNewLeaveType.setDisabled(false);
                btnSaveLeaveType.setDisabled(true);
                btnEditLeaveType.setDisabled(true);
                btnUpdateLeaveType.setDisabled(true);
                btnCancelLeaveType.setDisabled(true);
                btnDeleteLeaveType.setDisabled(true);
            } else {
                showSuccessOrFailureMessage(false, "Error occurred while saving the LeaveType information.");
            }
        } catch (Exception ex) {
        }
        //return null means stay on the same page
        return null;
    }

    public String cmdLeaveRequest_action() {
        // TODO: Replace with your code
        return "LeaveRequest";
    }

    public String cmdLeaveTransferApprove_action() {
        //return null means stay on the same page
        return "LeaveTransferApprove";
    }
}

