/*
 * EmployeeWillPage.java
 *
 * Created on Nov 7, 2012, 7:14:27 PM
 * Copyright Administrator
 */
package fphrms.Employee;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.LookUpManger;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.LookUpManager;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import manager.employeeManager.EmployeeManage;
import manager.employeeManager.EmployeeWillManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeeWillPage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<SelectItem> region = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> woredaList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> zoneorCityList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> kebeleList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> titleList = new ArrayList<SelectItem>();
    private List employeeWillList = new ArrayList<EmployeeWill>();
    private List employeeWillUpdateList = new ArrayList<EmployeeWill>();
    private LookUpManger lookUpManger = new LookUpManger();
    private LookUpManager lookUpManager = new LookUpManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private EmployeeWillManager employeeWillManager = new EmployeeWillManager();
    private String willId = "";
    int counter = 0;
    int tableSize = 0;
    int selectedRow = -1;

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean panelBorder1Bean) {
        this.panelBorder1Bean = panelBorder1Bean;
    }

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drlTitle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTitle() {
        return drlTitle;
    }

    public void setDrlTitle(HtmlSelectOneMenu hsom) {
        this.drlTitle = hsom;
    }
    private HtmlInputText txtWillSalary = new HtmlInputText();

    public HtmlInputText getTxtWillSalary() {
        return txtWillSalary;
    }

    public void setTxtWillSalary(HtmlInputText hit) {
        this.txtWillSalary = hit;
    }
    private HtmlInputText txtWillFirstName = new HtmlInputText();

    public HtmlInputText getTxtWillFirstName() {
        return txtWillFirstName;
    }

    public void setTxtWillFirstName(HtmlInputText hit) {
        this.txtWillFirstName = hit;
    }
    private HtmlInputText txtWillLastName = new HtmlInputText();

    public HtmlInputText getTxtWillLastName() {
        return txtWillLastName;
    }

    public void setTxtWillLastName(HtmlInputText hit) {
        this.txtWillLastName = hit;
    }
    private HtmlInputText txtWillRegistrationDate = new HtmlInputText();

    public HtmlInputText getTxtWillRegistrationDate() {
        return txtWillRegistrationDate;
    }

    public void setTxtWillRegistrationDate(HtmlInputText hit) {
        this.txtWillRegistrationDate = hit;
    }
    private HtmlInputText txtWillHouseNumber = new HtmlInputText();

    public HtmlInputText getTxtWillHouseNumber() {
        return txtWillHouseNumber;
    }

    public void setTxtWillHouseNumber(HtmlInputText hit) {
        this.txtWillHouseNumber = hit;
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
    private DefaultSelectedData selectOneMenu5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu5Bean() {
        return selectOneMenu5Bean;
    }

    public void setSelectOneMenu5Bean(DefaultSelectedData dsd) {
        this.selectOneMenu5Bean = dsd;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlSelectOneMenu drlZoneCity = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZoneCity() {
        return drlZoneCity;
    }

    public void setDrlZoneCity(HtmlSelectOneMenu hsom) {
        this.drlZoneCity = hsom;
    }
    private HtmlSelectOneMenu drlRegion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRegion() {
        return drlRegion;
    }

    public void setDrlRegion(HtmlSelectOneMenu hsom) {
        this.drlRegion = hsom;
    }
    private HtmlSelectOneMenu drlWoredaSubCity = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlWoredaSubCity() {
        return drlWoredaSubCity;
    }

    public void setDrlWoredaSubCity(HtmlSelectOneMenu hsom) {
        this.drlWoredaSubCity = hsom;
    }
    private HtmlSelectOneMenu drlKebele = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlKebele() {
        return drlKebele;
    }

    public void setDrlKebele(HtmlSelectOneMenu hsom) {
        this.drlKebele = hsom;
    }
    private HtmlInputText txtInternalDocumentNo = new HtmlInputText();

    public HtmlInputText getTxtInternalDocumentNo() {
        return txtInternalDocumentNo;
    }

    public void setTxtInternalDocumentNo(HtmlInputText hit) {
        this.txtInternalDocumentNo = hit;
    }
    private HtmlSelectBooleanCheckbox choInActive = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoInActive() {
        return choInActive;
    }

    public void setChoInActive(HtmlSelectBooleanCheckbox hsbc) {
        this.choInActive = hsbc;
    }
    private HtmlSelectBooleanCheckbox choActive = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoActive() {
        return choActive;
    }

    public void setChoActive(HtmlSelectBooleanCheckbox hsbc) {
        this.choActive = hsbc;
    }
    private HtmlInputText txtExternalDoumentNo = new HtmlInputText();

    public HtmlInputText getTxtExternalDoumentNo() {
        return txtExternalDoumentNo;
    }

    public void setTxtExternalDoumentNo(HtmlInputText hit) {
        this.txtExternalDoumentNo = hit;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private HtmlInputText txtWillMiddelName = new HtmlInputText();

    public HtmlInputText getTxtWillMiddelName() {
        return txtWillMiddelName;
    }

    public void setTxtWillMiddelName(HtmlInputText hit) {
        this.txtWillMiddelName = hit;
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
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlOutputText lblFullName = new HtmlOutputText();

    public HtmlOutputText getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(HtmlOutputText hot) {
        this.lblFullName = hot;
    }
    private HtmlSelectBooleanCheckbox choMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMale() {
        return choMale;
    }

    public void setChoMale(HtmlSelectBooleanCheckbox hsbc) {
        this.choMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox choFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoFemale() {
        return choFemale;
    }

    public void setChoFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.choFemale = hsbc;
    }
    private HtmlOutputText lblDepartment = new HtmlOutputText();

    public HtmlOutputText getLblDepartment() {
        return lblDepartment;
    }

    public void setLblDepartment(HtmlOutputText hot) {
        this.lblDepartment = hot;
    }
    private HtmlOutputText lblPostion = new HtmlOutputText();

    public HtmlOutputText getLblPostion() {
        return lblPostion;
    }

    public void setLblPostion(HtmlOutputText hot) {
        this.lblPostion = hot;
    }
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private PanelPopup willPopUpMsg = new PanelPopup();

    public PanelPopup getWillPopUpMsg() {
        return willPopUpMsg;
    }

    public void setWillPopUpMsg(PanelPopup pp) {
        this.willPopUpMsg = pp;
    }
    private HtmlOutputText lblMessagePopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblMessagePopUpMsgMain() {
        return lblMessagePopUpMsgMain;
    }

    public void setLblMessagePopUpMsgMain(HtmlOutputText hot) {
        this.lblMessagePopUpMsgMain = hot;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeeWillPage() {
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
        if (titleList.isEmpty() || (lookUpManger.getEmpitiedTableList() != null &&
                lookUpManger.getEmpitiedTableList().contains("hr_lu_title"))) {
            this.setTitleList(lookUpManager.assignTitle());
            lookUpManger.getEmpitiedTableList().remove("hr_lu_title");
        }
        if (region.isEmpty() || (lookUpManger.getEmpitiedTableList() != null &&
                lookUpManger.getEmpitiedTableList().contains("hr_lu_region"))) {
            this.setRegion(lookUpManager.readRegion());
            lookUpManger.getEmpitiedTableList().remove("hr_lu_region");
        }
        disableWillComponet();
        clearWillInfoTextComponets();
        clearPersonalInfoTextComponets();
        txtEmployeeId.setValue("");






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
            log("EmployeeWillPage Initialization Failure", e);
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

    public static class EmployeeWill implements Serializable {

        private String employeeId;
        private String willTitle;
        private String willFirstName;
        private String willMiddleName;
        private String willLastName;
        private String willSalary;
        private String registrationDate;
        private String willRegion;
        private String willZoneorCity;
        private String willWoredaorSubCity;
        private String willKebele;
        private String willHouseNumber;
        private String willExternalDoumentNo;
        private String willInternalDocumentNo;
        private String willStatus;
        private String willId;
        private String willFullName;
        private boolean selected;

        public String getWillFullName() {
            return willFullName;
        }

        public void setWillFullName(String willFullName) {
            this.willFullName = willFullName;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

        public String getWillExternalDoumentNo() {
            return willExternalDoumentNo;
        }

        public void setWillExternalDoumentNo(String willExternalDoumentNo) {
            this.willExternalDoumentNo = willExternalDoumentNo;
        }

        public String getWillFirstName() {
            return willFirstName;
        }

        public void setWillFirstName(String willFirstName) {
            this.willFirstName = willFirstName;
        }

        public String getWillHouseNumber() {
            return willHouseNumber;
        }

        public void setWillHouseNumber(String willHouseNumber) {
            this.willHouseNumber = willHouseNumber;
        }

        public String getWillInternalDocumentNo() {
            return willInternalDocumentNo;
        }

        public void setWillInternalDocumentNo(String willInternalDocumentNo) {
            this.willInternalDocumentNo = willInternalDocumentNo;
        }

        public String getWillKebele() {
            return willKebele;
        }

        public void setWillKebele(String willKebele) {
            this.willKebele = willKebele;
        }

        public String getWillLastName() {
            return willLastName;
        }

        public void setWillLastName(String willLastName) {
            this.willLastName = willLastName;
        }

        public String getWillMiddleName() {
            return willMiddleName;
        }

        public void setWillMiddleName(String willMiddleName) {
            this.willMiddleName = willMiddleName;
        }

        public String getWillRegion() {
            return willRegion;
        }

        public void setWillRegion(String willRegion) {
            this.willRegion = willRegion;
        }

        public String getWillSalary() {
            return willSalary;
        }

        public void setWillSalary(String willSalary) {
            this.willSalary = willSalary;
        }

        public String getWillStatus() {
            return willStatus;
        }

        public void setWillStatus(String willStatus) {
            this.willStatus = willStatus;
        }

        public String getWillTitle() {
            return willTitle;
        }

        public void setWillTitle(String willTitle) {
            this.willTitle = willTitle;
        }

        public String getWillWoredaorSubCity() {
            return willWoredaorSubCity;
        }

        public void setWillWoredaorSubCity(String willWoredaorSubCity) {
            this.willWoredaorSubCity = willWoredaorSubCity;
        }

        public String getWillZoneorCity() {
            return willZoneorCity;
        }

        public void setWillZoneorCity(String willZoneorCity) {
            this.willZoneorCity = willZoneorCity;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getWillId() {
            return willId;
        }

        public void setWillId(String willId) {
            this.willId = willId;
        }
        String regionDescrption;
        String zoneDescription;
        String woredaDescription;
        String kebelleDescription;

        public EmployeeWill(String employeeId,
                String willTitle,
                String willFirstName,
                String willMiddleName,
                String willLastName,
                String willSalary,
                String registrationDate,
                String willRegion,
                String willZoneorCity,
                String willWoredaorSubCity,
                String willKebele,
                String willHouseNumber,
                String willExternalDoumentNo,
                String willInternalDocumentNo,
                String willStatus,
                String willId) {
            this.employeeId = employeeId;
            this.willTitle = willTitle;
            this.willFirstName = willFirstName;
            this.willMiddleName = willMiddleName;
            this.willLastName = willLastName;
            this.willSalary = willSalary;
            this.registrationDate = registrationDate;
            this.willRegion = willRegion;
            this.willZoneorCity = willZoneorCity;
            this.willWoredaorSubCity = willWoredaorSubCity;
            this.willKebele = willKebele;
            this.willHouseNumber = willHouseNumber;
            this.willExternalDoumentNo = willExternalDoumentNo;
            this.willInternalDocumentNo = willInternalDocumentNo;
            this.willStatus = willStatus;
            this.willId = willId;
            this.willFullName = willFirstName + ' ' + willMiddleName + ' ' + willLastName;
//            this.regionDescrption = readRegionDescrption(willRegion);
//            String = lookUpManager.readZonenDescrption(drlZone.getValue().toString());
//            String woredaDescription = lookUpManager.readWoredaDescrption(drlWoreda.getValue().toString());
//            String kebelleDescription = lookUpManager.readKebelleDescrption(drlKebele.getValue().toString());
        }
    }

    public ArrayList<SelectItem> getKebeleList() {
        return kebeleList;
    }

    public void setKebeleList(ArrayList<SelectItem> kebeleList) {
        this.kebeleList = kebeleList;
    }

    public String readRegionDescrption(String regionId) {
        return lookUpManager.readRegionDescrption(regionId);
    }

    public ArrayList<SelectItem> getRegion() {
        return region;
    }

    public void setRegion(ArrayList<SelectItem> region) {
        this.region = region;
    }

    public ArrayList<SelectItem> getTitleList() {
        return titleList;
    }

    public void setTitleList(ArrayList<SelectItem> titleList) {
        this.titleList = titleList;
    }

    public ArrayList<SelectItem> getZoneorCityList() {
        return zoneorCityList;
    }

    public void setZoneorCityList(ArrayList<SelectItem> zoneorCityList) {
        this.zoneorCityList = zoneorCityList;
    }

    public ArrayList<SelectItem> getWoredaList() {
        return woredaList;
    }

    public void setWoredaList(ArrayList<SelectItem> woredaList) {
        this.woredaList = woredaList;
    }

    public List getEmployeeWillList() {
        return employeeWillList;
    }

    public void setEmployeeWillList(List employeeWillList) {
        this.employeeWillList = employeeWillList;
    }

    public List getEmployeeWillUpdateList() {
        return employeeWillUpdateList;
    }

    public void setEmployeeWillUpdateList(List employeeWillUpdateList) {
        this.employeeWillUpdateList = employeeWillUpdateList;
    }

    public String btnAdd_action() {
        if (isEntryValidEmployeeProfile()) {
            String willStatus;
            String internalDocumentNo = "";
            String externalDocumentNo = "";
            String houseNumber = "";
            String kebelle = "";
            if (drlKebele.getValue() != null && drlKebele.getValue().toString() != null) {
                kebelle = drlKebele.getValue().toString();
            }
            if (txtWillHouseNumber.getValue() != null && txtWillHouseNumber.getValue().toString() != null) {
                houseNumber = txtWillHouseNumber.getValue().toString();
            }
            if (txtExternalDoumentNo.getValue() != null && txtExternalDoumentNo.getValue().toString() != null) {
                externalDocumentNo = txtExternalDoumentNo.getValue().toString();
            }
            if (txtInternalDocumentNo.getValue() != null && txtInternalDocumentNo.getValue().toString() != null) {
                internalDocumentNo = txtInternalDocumentNo.getValue().toString();
            }

            if (choActive.isSelected()) {
                willStatus = "Active";
            } else {
                willStatus = "In Active";
            }

            EmployeeWill employeeWill = new EmployeeWill(
                    txtEmployeeId.getValue().toString(),
                    drlTitle.getValue().toString(),
                    txtWillFirstName.getValue().toString(),
                    txtWillMiddelName.getValue().toString(),
                    txtWillLastName.getValue().toString(),
                    txtWillSalary.getValue().toString(),
                    txtWillRegistrationDate.getValue().toString(),
                    drlRegion.getValue().toString(),
                    drlZoneCity.getValue().toString(),
                    drlWoredaSubCity.getValue().toString(),
                    kebelle,
                    houseNumber,
                    externalDocumentNo,
                    internalDocumentNo,
                    willStatus,
                    willId);
            counter++;
            this.employeeWillList.add(employeeWill);

            clearWillInfoTextComponets();




        }
        //return null means stay on the same page
        return null;
    }

    public boolean isEntryValidEmployeeProfile() {
        boolean result = true;
        boolean required;
        boolean chechk = false;
        String errorMessage = "Required";
        int errorValue = 0;

        errorValue =
                HRValidation.validateData(this.txtWillFirstName.getValue(), HRValidation.NAME_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtWillFirstName).setValid(false);
                error(txtWillFirstName, errorMessage);
            } else {
                ((UIInput) txtWillFirstName).setValid(false);
                error(txtWillFirstName, "Invalid Value");
            }

        }
        errorValue =
                HRValidation.validateData(this.txtWillMiddelName.getValue(), HRValidation.NAME_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtWillMiddelName).setValid(false);
                error(txtWillMiddelName, errorMessage);
            } else {
                ((UIInput) txtWillMiddelName).setValid(false);
                error(txtWillMiddelName, "Invalid Value");
            }

        }

        errorValue =
                HRValidation.validateData(this.txtWillLastName.getValue(), HRValidation.NAME_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtWillLastName).setValid(false);
                error(txtWillLastName, errorMessage);
            } else {
                ((UIInput) txtWillLastName).setValid(false);
                error(txtWillLastName, "Invalid Value");
            }

        }
        errorValue =
                HRValidation.validateData(this.txtWillRegistrationDate.getValue(), HRValidation.DATE_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtWillRegistrationDate).setValid(false);
                error(txtWillRegistrationDate, errorMessage);
            } else {
                ((UIInput) txtWillRegistrationDate).setValid(false);
                error(txtWillRegistrationDate, "Invalid Value");
            }

        }
        errorValue =
                HRValidation.validateData(this.txtWillSalary.getValue(), HRValidation.FLOAT_PATTERN, false);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtWillRegistrationDate).setValid(false);
            error(txtWillRegistrationDate, "Invalid Value");


        }

        if (!HRValidation.validateRequired(drlTitle.getValue())) {
            result = false;
            ((UIInput) drlTitle).setValid(false);
            error(drlTitle, errorMessage);
        }
        if (!HRValidation.validateRequired(drlRegion.getValue())) {
            result = false;
            ((UIInput) drlRegion).setValid(false);
            error(drlRegion, errorMessage);
        }
        if (!HRValidation.validateRequired(drlZoneCity.getValue())) {
            result = false;
            ((UIInput) drlZoneCity).setValid(false);
            error(drlZoneCity, errorMessage);
        }
        if (!HRValidation.validateRequired(drlWoredaSubCity.getValue())) {
            result = false;
            ((UIInput) drlWoredaSubCity).setValid(false);
            error(drlWoredaSubCity, errorMessage);
        }
        if (!choActive.isSelected() && !choInActive.isSelected()) {
            result = false;
            ((UIInput) choActive).setValid(false);
            error(choActive, errorMessage);
        }
        return result;
    }

    public void drlZoneCity_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                setWoredaList(lookUpManager.readWoredaAndZone(vce.getNewValue().toString()));
            }
        } catch (Exception ex) {
        }
    }

    public void drlRegion_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                setZoneorCityList(lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString()));
            }
            // this.setWoredaList(lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void drlWoredaSubCity_processValueChange(ValueChangeEvent vce) {
        try {
            setKebeleList(lookUpManager.readKebelleInSubCity(vce.getNewValue().toString()));
            //kebeleList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());
        } catch (Exception ex) {
        }
    }

    public String btnSerach_action() {
        loadEmployeeInformation();
        loadEmployeeWill(txtEmployeeId.getValue().toString());
        //return null means stay on the same page
        return null;
    }

    private void loadEmployeeInformation() {
        try {
            if (HRValidation.validateRequired(this.txtEmployeeId.getValue())) {
                getEmployeeWillList().clear();
                clearWillInfoTextComponets();
//                clearPersonalInfoTextComponets();
                if (txtEmployeeId.getValue().toString() != null) {
                    clearWillInfoTextComponets();
                    if (employeeManager.loadEmpoyeeProfile(txtEmployeeId.getValue().toString()) == 1) {
                        btnNew.setDisabled(false);
                        lblFullName.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " +
                                "" + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
                        String sex = employeeManager.getSex();
                        if (sex.equalsIgnoreCase("Male")) {
                            choMale.setSelected(true);
                            choFemale.setSelected(false);
                        } else if (sex.equalsIgnoreCase("Female")) {
                            choFemale.setSelected(true);
                            choMale.setSelected(false);
                        } else {
                            choMale.setSelected(false);
                            choFemale.setSelected(false);
                        }

//                        try {
//                            setEmployeePicture(null);
//                            imgEmployeePicture.setValue("");
//
////                            int expYear = employeeManager.calculateEmpServiceYear(
////                                    jodanTimeCalender.ChangeDateToEthiopic(employeeManager.getHire_Date()));
//
//                            int expYear = employeeManager.calculateEmployeeServiceYearHireDate(
//                                    employeeManager.getHire_Date());
//                            lblServiceYear.setValue(String.valueOf(expYear));
//                            OracleSerialBlob blo = (OracleSerialBlob) employeeManager.getPhotobinary();
//                            setEmployeePicture(blo.getBytes(0, (int) blo.length()));
//                            imgEmployeePicture.setValue(getEmployeePicture());
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
                        lblDepartment.setValue(employeeManager.departmentDetileDescription(employeeManager.getDepartmentId()));
                        lblPostion.setValue(employeeManager.getJobDescription());

                    } else {
                        clearWillInfoTextComponets();
                        showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");
                        clearPersonalInfoTextComponets();
                    }
                } else {
                    showSuccessOrFailureMessage(false, "Please enter employee Id? And try again?");
                }
            } else {
                showSuccessOrFailureMessage(false, "Please enter employee Id? And try again?");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEmployeeWill(String employeeId) {
        try {

            ArrayList<HashMap> employeeWillFromDb = employeeWillManager.getEmployeeWill(employeeId);
            employeeWillList.clear();
            if (employeeWillFromDb != null) {
                btnSave.setDisabled(true);
                btnUpdate.setDisabled(true);
                btnDelete.setDisabled(false);
                for (HashMap hm : employeeWillFromDb) {
                    EmployeeWill employeeWillObj = new EmployeeWill(
                            employeeId,
                            hm.get("TITLE").toString(),
                            hm.get("WILL_FIRST_NAME").toString(),
                            hm.get("WILL_MIDDLE_NAME").toString(),
                            hm.get("WILL_LAST_NAME").toString(),
                            hm.get("WILLSALRY").toString(),
                            hm.get("REGISTRATIONDATE").toString(),
                            hm.get("WILLREGIONID").toString(),
                            hm.get("WILLZONEORCITY").toString(),
                            hm.get("WILLWOREDAORSUBCITY").toString(),
                            hm.get("WILLKEBELLE").toString(),
                            hm.get("WILLHOUSENUMBER").toString(),
                            hm.get("EXTERNALDOUMENTNO").toString(),
                            hm.get("INTERNALDOCUMENTNO").toString(),
                            hm.get("WILLSTATUS").toString(),
                            hm.get("WILL_ID").toString());

                    employeeWillList.add(employeeWillObj);

                    // willZoneList = lookUpManager.readZoneOrCityInARegion(employeeWill.get("WILLREGIONID").toString());

//                String willWoredaList =
//                        lookUpManager.readWoredaAndZone(employeeWill.get("WILLZONEORCITY").toString());
//                willKebeleList =
//                        lookUpManager.readKebelleInSubCity(employeeWill.get("WILLWOREDAORSUBCITY").toString());


                }
                btnDelete.setDisabled(false);
            } else {
                enableWillComponet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage.setValue(messageToDisplay);
        lblFormMessage.setRendered(true);
        pnConfirmationMessage.setAutoCentre(true);
        pnConfirmationMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    private void clearWillInfoTextComponets() {
        selectOneMenu1Bean.setSelectedObject(null);
        txtWillFirstName.setValue("");
        txtWillFirstName.resetValue();
        txtWillMiddelName.resetValue();
        txtWillLastName.resetValue();
        txtWillSalary.resetValue();
        txtWillRegistrationDate.resetValue();
        selectOneMenu2Bean.setSelectedObject(null);
        selectOneMenu4Bean.setSelectedObject(null);
        selectOneMenu3Bean.setSelectedObject(null);
        selectOneMenu5Bean.setSelectedObject(null);
        txtWillHouseNumber.resetValue();
        txtExternalDoumentNo.resetValue();
        txtInternalDocumentNo.resetValue();
        choActive.setSelected(false);
        choInActive.setSelected(false);
    }

    private void clearPersonalInfoTextComponets() {
    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    private ArrayList<HashMap> willListForSave() {
        try {


            ArrayList<HashMap> list = new ArrayList<HashMap>();
            List employeeWillSave = this.getEmployeeWillList().subList((tableSize), (tableSize + counter));
            Iterator<EmployeeWill> iter = employeeWillSave.iterator();
            while (iter.hasNext()) {
                HashMap hm = new HashMap();
                EmployeeWill employeeWill = iter.next();
                hm.put("employeeId", employeeWill.getEmployeeId());
                hm.put("willTitle", employeeWill.getWillTitle());
                hm.put("willFirstName", employeeWill.getWillFirstName());
                hm.put("willLastName", employeeWill.getWillLastName());
                hm.put("willMiddleName", employeeWill.getWillMiddleName());
                hm.put("willSalary", employeeWill.getWillSalary());
                hm.put("willRegion", employeeWill.getWillRegion());
                hm.put("willZoneorCity", employeeWill.getWillZoneorCity());
                hm.put("willWoredaorSubCity", employeeWill.getWillWoredaorSubCity());
                hm.put("willHouseNumber", employeeWill.getWillHouseNumber());
                hm.put("externalDoumentNo", employeeWill.getWillExternalDoumentNo());
                hm.put("internalDocumentNo", employeeWill.getWillInternalDocumentNo());
                hm.put("willStatus", employeeWill.getWillStatus());
                hm.put("willWoredaorSubCity", employeeWill.getWillWoredaorSubCity());
                hm.put("willHouseNumber", employeeWill.getWillHouseNumber());
                hm.put("willKebele", employeeWill.getWillKebele());
                list.add(hm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private HashMap willListForUpdate() {
        HashMap hm = new HashMap();
        if (isEntryValidEmployeeProfile()) {
            String willStatus;
            String internalDocumentNo = "";
            String externalDocumentNo = "";
            String houseNumber = "";
            String kebelle = "";
            if (drlKebele.getValue() != null && drlKebele.getValue().toString() != null) {
                kebelle = drlKebele.getValue().toString();
            }
            if (txtWillHouseNumber.getValue() != null && txtWillHouseNumber.getValue().toString() != null) {
                houseNumber = txtWillHouseNumber.getValue().toString();
            }
            if (txtExternalDoumentNo.getValue() != null && txtExternalDoumentNo.getValue().toString() != null) {
                externalDocumentNo = txtExternalDoumentNo.getValue().toString();
            }
            if (txtInternalDocumentNo.getValue() != null && txtInternalDocumentNo.getValue().toString() != null) {
                internalDocumentNo = txtInternalDocumentNo.getValue().toString();
            }

            if (choActive.isSelected()) {
                willStatus = "Active";
            } else {
                willStatus = "In Active";
            }
            hm.put("employeeId", txtEmployeeId.getValue().toString());
            hm.put("willTitle", drlTitle.getValue().toString());
            hm.put("willFirstName", txtWillFirstName.getValue().toString());
            hm.put("willLastName", txtWillLastName.getValue().toString());
            hm.put("willMiddleName", txtWillMiddelName.getValue().toString());
            hm.put("willSalary", txtWillSalary.getValue().toString());
            hm.put("willRegion", drlRegion.getValue().toString());
            hm.put("willZoneorCity", drlZoneCity.getValue().toString());
            hm.put("willWoredaorSubCity", drlWoredaSubCity.getValue().toString());
            hm.put("willHouseNumber", houseNumber);
            hm.put("externalDoumentNo", externalDocumentNo);
            hm.put("internalDocumentNo", internalDocumentNo);
            hm.put("willStatus", willStatus);
            hm.put("registrationDate", txtWillRegistrationDate.getValue().toString());
            hm.put("kebelle", kebelle);
            hm.put("willId", willId);
        }
        return hm;
    }

    public String btnSave_action() {
        if (employeeWillManager.saveEmployeeWill(willListForSave())) {
            showSuccessOrFailureMessage(true, "Will Information Saved Successfully.");
            clearWillInfoTextComponets();
            disableWillComponet();
        } else {
            showSuccessOrFailureMessage(true, "Error occurs when saving will information. Please try again?  ");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnNew_action() {
        btnSave.setDisabled(false);
        btnAdd.setDisabled(false);
        enableWillComponet();


        //return null means stay on the same page
        return null;
    }

    public void rowSelectorEmployeeWill_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
        if (selectedRow != -1) {
            EmployeeWill employeeWill = (EmployeeWill) employeeWillList.get(selectedRow);
            drlTitle.setValue(employeeWill.getWillTitle());
            txtWillFirstName.setValue(employeeWill.getWillFirstName());
            txtWillMiddelName.setValue(employeeWill.getWillMiddleName());
            txtWillLastName.setValue(employeeWill.getWillLastName());
            txtWillSalary.setValue(employeeWill.getWillSalary());
            txtWillRegistrationDate.setValue(employeeWill.getRegistrationDate());
            drlRegion.setValue(employeeWill.getWillRegion());
            setZoneorCityList(lookUpManager.readZoneOrCityInARegion(employeeWill.getWillRegion()));
            drlZoneCity.setValue(employeeWill.getWillZoneorCity());
//             setWoredaList(lookUpManager.readWoredaAndZone(vce.getNewValue().toString()));
            setWoredaList(lookUpManager.readWoredaAndZone(employeeWill.getWillZoneorCity()));
            drlWoredaSubCity.setValue(employeeWill.getWillWoredaorSubCity());
            setKebeleList(lookUpManager.readKebelleInSubCity(employeeWill.getWillWoredaorSubCity()));
            drlKebele.setValue(employeeWill.getWillKebele());
            txtWillHouseNumber.setValue(employeeWill.getWillHouseNumber());
            txtExternalDoumentNo.setValue(employeeWill.getWillHouseNumber());
            txtInternalDocumentNo.setValue(employeeWill.getWillHouseNumber());
            willId = employeeWill.getWillId();
            if (employeeWill.getWillStatus().equals("Active")) {
                choActive.setSelected(true);
                choInActive.setSelected(false);
            } else {
                choInActive.setSelected(true);
                choActive.setSelected(false);
            }
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(false);
            btnAdd.setDisabled(true);
            enableWillComponet();
        }
    }

    private void disableWillComponet() {
        drlTitle.setDisabled(true);
        txtWillFirstName.setDisabled(true);
        txtWillMiddelName.setDisabled(true);
        txtWillLastName.setDisabled(true);
        txtWillSalary.setDisabled(true);
        drlRegion.setDisabled(true);
        drlZoneCity.setDisabled(true);
        drlWoredaSubCity.setDisabled(true);
        drlKebele.setDisabled(true);
        txtWillHouseNumber.setDisabled(true);
        txtExternalDoumentNo.setDisabled(true);
        txtInternalDocumentNo.setDisabled(true);
        choActive.setDisabled(true);
        choInActive.setDisabled(true);
    }

    private void enableWillComponet() {
        drlTitle.setDisabled(false);
        txtWillFirstName.setDisabled(false);
        txtWillMiddelName.setDisabled(false);
        txtWillLastName.setDisabled(false);
        txtWillSalary.setDisabled(false);
        drlRegion.setDisabled(false);
        drlZoneCity.setDisabled(false);
        drlWoredaSubCity.setDisabled(false);
        drlKebele.setDisabled(false);
        txtWillHouseNumber.setDisabled(false);
        txtExternalDoumentNo.setDisabled(false);
        txtInternalDocumentNo.setDisabled(false);
        choActive.setDisabled(false);
        choInActive.setDisabled(false);
    }

    public String btnUpdate_action() {
        if (employeeWillManager.updateEmployeeWill(willListForUpdate())) {
            showSuccessOrFailureMessage(true, "Employee Will Information Updated Successfully.");
            loadEmployeeWill(txtEmployeeId.getValue().toString());
            clearWillInfoTextComponets();
            disableWillComponet();
        } else {
            showSuccessOrFailureMessage(true, "Employee Will Information Not Updated. Please Try Again ?");
        }
        //return null means stay on the same page
        return null;
    }

    public String bntReset_action() {
        clearWillInfoTextComponets();
        disableWillComponet();
        //return null means stay on the same page

        return null;
    }

    public String btnDelete_action() {
        willPopUpMsg.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnYesPopUp_action() {
        willPopUpMsg.setRendered(false);
        EmployeeWill employeeWill = (EmployeeWill) employeeWillList.get(selectedRow);
        if (employeeWillManager.deleteEmployeeWill(employeeWill.getWillId())) {
            showSuccessOrFailureMessage(true, "Will Information Deleted Successfully.");
        } else {
            showSuccessOrFailureMessage(true, "Error occurs when deleting will information. Please try again? ");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnNoPopUp_action() {
        willPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String lnkPayrollPeriodLists_action() {
        //return null means stay on the same page
        return "EmployeeProfile";
    }

    public String lnkPayrollSetUp_action() {
        //return null means stay on the same page
        return "Transfer";
    }

    public String lnkAccrualEntries_action() {
        //return null means stay on the same page
        return "Transfer";
    }

    public String lnkPersonalDeductions_action() {
        //return null means stay on the same page
        return "TransferAndPromotionHistory";
    }

    public String lnkGovernmentDeductions_action() {
        //return null means stay on the same page
        return "Terminationrequest";
    }

    public void choActive_processValueChange(ValueChangeEvent vce) {
        choInActive.setSelected(false);
    }

    public void choInActive_processValueChange(ValueChangeEvent vce) {
        choActive.setSelected(false);
    }

  

}

