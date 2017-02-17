/*
 * Templete.java
 *
 * Created on Dec 26, 2012, 10:33:41 AM
 * Copyright Administrator
 */
package fphrms.DailyWorker;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.LookUpManger;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.tree.DefaultTreeModel;
import manager.dailyWorkerManager.DailyWorkerManager;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.ComponentValidator;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.LookUpManager;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DailyWorkerRegistrationPage extends AbstractPageBean {

    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<DailyWorker> listOfDailyWorker = new ArrayList<DailyWorker>();
    private ArrayList<SelectItem> region = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> woredaList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> zoneorCityList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> kebeleList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> titleList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> listOfJobs = new ArrayList<SelectItem>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    DepartmentManage departmentManage = new DepartmentManage();
    private int selectedDilyWorkerRow = -1;
    private LookUpManger lookUpManger = null;
    private LookUpManager lookUpManager = null;
    static int departmentId = 0;
    static String jobCode = null;
    private String jobId;
    private String dailyWorkId;
    private String departemntId;
    private DailyWorkerManager dailyWorkerManager = null;
    boolean relodTable = true;

    public ArrayList<SelectItem> getPerofation() {
        return perofation;
    }

    public void setPerofation(ArrayList<SelectItem> perofation) {
        this.perofation = perofation;
    }

    public ArrayList<SelectItem> getListOfJobs() {
        return listOfJobs;
    }

    public void setListOfJobs(ArrayList<SelectItem> listOfJobs) {
        this.listOfJobs = listOfJobs;
    }

    public ArrayList<SelectItem> getKebeleList() {
        return kebeleList;
    }

    public void setKebeleList(ArrayList<SelectItem> kebeleList) {
        this.kebeleList = kebeleList;
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

    public ArrayList<SelectItem> getWoredaList() {
        return woredaList;
    }

    public void setWoredaList(ArrayList<SelectItem> woredaList) {
        this.woredaList = woredaList;
    }

    public ArrayList<SelectItem> getZoneorCityList() {
        return zoneorCityList;
    }

    public void setZoneorCityList(ArrayList<SelectItem> zoneorCityList) {
        this.zoneorCityList = zoneorCityList;
    }

    public ArrayList<DailyWorker> getListOfDailyWorker() {
        return listOfDailyWorker;
    }

    public void setListOfDailyWorker(ArrayList<DailyWorker> listOfDailyWorker) {
        this.listOfDailyWorker = listOfDailyWorker;
    }

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
        if (relodTable) {
            relodTable = false;
            try {
                LoadTree loadTree = new LoadTree();
                tree1Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
            } catch (Exception ex) {
                ex.printStackTrace();
                tree1.setRendered(false);
            }

        }
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu4DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu4DefaultItems() {
        return selectOneMenu4DefaultItems;
    }

    public void setSelectOneMenu4DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu4DefaultItems = dsi;
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
    private HtmlSelectOneMenu drlJob = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJob() {
        return drlJob;
    }

    public void setDrlJob(HtmlSelectOneMenu hsom) {
        this.drlJob = hsom;
    }
    private HtmlSelectOneMenu drlTitle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTitle() {
        return drlTitle;
    }

    public void setDrlTitle(HtmlSelectOneMenu hsom) {
        this.drlTitle = hsom;
    }
    private HtmlInputText txtWillMiddelName = new HtmlInputText();

    public HtmlInputText getTxtWillMiddelName() {
        return txtWillMiddelName;
    }

    public void setTxtWillMiddelName(HtmlInputText hit) {
        this.txtWillMiddelName = hit;
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
    private HtmlInputText txtWillHouseNumber = new HtmlInputText();

    public HtmlInputText getTxtWillHouseNumber() {
        return txtWillHouseNumber;
    }

    public void setTxtWillHouseNumber(HtmlInputText hit) {
        this.txtWillHouseNumber = hit;
    }
    private HtmlSelectOneMenu drlZoneCity = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZoneCity() {
        return drlZoneCity;
    }

    public void setDrlZoneCity(HtmlSelectOneMenu hsom) {
        this.drlZoneCity = hsom;
    }
    private HtmlSelectOneMenu drlKebele = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlKebele() {
        return drlKebele;
    }

    public void setDrlKebele(HtmlSelectOneMenu hsom) {
        this.drlKebele = hsom;
    }
    private HtmlInputText txtRegistrationDate = new HtmlInputText();

    public HtmlInputText getTxtRegistrationDate() {
        return txtRegistrationDate;
    }

    public void setTxtRegistrationDate(HtmlInputText hit) {
        this.txtRegistrationDate = hit;
    }
    private HtmlInputText txtWillLastName = new HtmlInputText();

    public HtmlInputText getTxtWillLastName() {
        return txtWillLastName;
    }

    public void setTxtWillLastName(HtmlInputText hit) {
        this.txtWillLastName = hit;
    }
    private HtmlInputText txtWillFirstName = new HtmlInputText();

    public HtmlInputText getTxtWillFirstName() {
        return txtWillFirstName;
    }

    public void setTxtWillFirstName(HtmlInputText hit) {
        this.txtWillFirstName = hit;
    }
    private HtmlSelectBooleanCheckbox chkMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMale() {
        return chkMale;
    }

    public void setChkMale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMale = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkFemale() {
        return chkFemale;
    }

    public void setChkFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkFemale = hsbc;
    }
    private PanelPopup pnlPopUpRecruitmentType = new PanelPopup();

    public PanelPopup getPnlPopUpRecruitmentType() {
        return pnlPopUpRecruitmentType;
    }

    public void setPnlPopUpRecruitmentType(PanelPopup pp) {
        this.pnlPopUpRecruitmentType = pp;
    }
    private HtmlInputText txtDepartemnt = new HtmlInputText();

    public HtmlInputText getTxtDepartemnt() {
        return txtDepartemnt;
    }

    public void setTxtDepartemnt(HtmlInputText hit) {
        this.txtDepartemnt = hit;
    }
    private HtmlInputText txtPostion = new HtmlInputText();

    public HtmlInputText getTxtPostion() {
        return txtPostion;
    }

    public void setTxtPostion(HtmlInputText hit) {
        this.txtPostion = hit;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlInputText txtEndDate = new HtmlInputText();

    public HtmlInputText getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(HtmlInputText hit) {
        this.txtEndDate = hit;
    }
    private HtmlInputText txtDailyPayment = new HtmlInputText();

    public HtmlInputText getTxtDailyPayment() {
        return txtDailyPayment;
    }

    public void setTxtDailyPayment(HtmlInputText hit) {
        this.txtDailyPayment = hit;
    }
    private HtmlInputTextarea txtDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(HtmlInputTextarea hit) {
        this.txtDescription = hit;
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
    private SelectInputDate calStartDate = new SelectInputDate();

    public SelectInputDate getCalStartDate() {
        return calStartDate;
    }

    public void setCalStartDate(SelectInputDate sid) {
        this.calStartDate = sid;
    }
    private SelectInputDate calEndDate = new SelectInputDate();

    public SelectInputDate getCalEndDate() {
        return calEndDate;
    }

    public void setCalEndDate(SelectInputDate sid) {
        this.calEndDate = sid;
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
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage4 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private PanelPopup porganazationSturctue = new PanelPopup();

    public PanelPopup getPorganazationSturctue() {
        return porganazationSturctue;
    }

    public void setPorganazationSturctue(PanelPopup pp) {
        this.porganazationSturctue = pp;
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
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
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
    private HtmlSelectOneMenu drl_Position = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Position() {
        return drl_Position;
    }

    public void setDrl_Position(HtmlSelectOneMenu hsom) {
        this.drl_Position = hsom;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDate calRegisterDate = new SelectInputDate();

    public SelectInputDate getCalRegisterDate() {
        return calRegisterDate;
    }

    public void setCalRegisterDate(SelectInputDate sid) {
        this.calRegisterDate = sid;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DailyWorkerRegistrationPage() {
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
        try {


            checkObject();
            clearConmponmt();
            disableConmponmt();
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
            setListOfJobs(dailyWorkerManager.listOfRequriment());
        } catch (Exception e) {
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

    public void drlRegion1_processValueChange(ValueChangeEvent vce) {
    }

    public void drlZoneCity1_processValueChange(ValueChangeEvent vce) {
    }

    public void drlWoredaSubCity1_processValueChange(ValueChangeEvent vce) {
    }

    public static class DailyWorker implements Serializable {

        private String firstName;
        private String middleName;
        private String lastName;
        private String fullName;
        private String job;
        private String registrationDate;
        private String region;
        private String zoneorCity;
        private String woredaorSubCity;
        private String kebele;
        private String zoneorCityName;
        private String woredaorSubCityName;
        private String kebeleName;
        private String houseNumber;
        private String dailyWorkId;
        private String internalDocumentNo;
        private String jobId;
        private String gender;
        private boolean selected;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDailyWorkId() {
            return dailyWorkId;
        }

        public void setDailyWorkId(String dailyWorkId) {
            this.dailyWorkId = dailyWorkId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public String getInternalDocumentNo() {
            return internalDocumentNo;
        }

        public void setInternalDocumentNo(String internalDocumentNo) {
            this.internalDocumentNo = internalDocumentNo;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }

        public String getKebele() {
            return kebele;
        }

        public void setKebele(String kebele) {
            this.kebele = kebele;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getWoredaorSubCity() {
            return woredaorSubCity;
        }

        public void setWoredaorSubCity(String woredaorSubCity) {
            this.woredaorSubCity = woredaorSubCity;
        }

        public String getZoneorCity() {
            return zoneorCity;
        }

        public void setZoneorCity(String zoneorCity) {
            this.zoneorCity = zoneorCity;
        }

        public String getKebeleName() {
            return kebeleName;
        }

        public void setKebeleName(String kebeleName) {
            this.kebeleName = kebeleName;
        }

        public String getWoredaorSubCityName() {
            return woredaorSubCityName;
        }

        public void setWoredaorSubCityName(String woredaorSubCityName) {
            this.woredaorSubCityName = woredaorSubCityName;
        }

        public String getZoneorCityName() {
            return zoneorCityName;
        }

        public void setZoneorCityName(String zoneorCityName) {
            this.zoneorCityName = zoneorCityName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public DailyWorker(
                String firstName,
                String middleName,
                String lastName,
                String fullName,
                String job,
                String jobId,
                String gender,
                String registrationDate,
                String region,
                String zoneorCity,
                String woredaorSubCity,
                String zoneorCityName,
                String woredaorSubCityName,
                String kebeleName,
                String kebele,
                String houseNumber,
                String dailyWorkId) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.fullName = fullName;
            this.job = job;
            this.registrationDate = registrationDate;
            this.region = region;
            this.zoneorCity = zoneorCity;
            this.woredaorSubCity = woredaorSubCity;
            this.zoneorCityName = zoneorCityName;
            this.woredaorSubCityName = woredaorSubCityName;
            this.kebeleName = kebeleName;
            this.houseNumber = houseNumber;
            this.kebele = kebele;
            this.dailyWorkId = dailyWorkId;
            this.jobId = jobId;
            this.gender = gender;

        }
    }

    private void checkObject() {
        if (lookUpManger == null) {
            lookUpManger = new LookUpManger();
        }
        if (lookUpManager == null) {
            lookUpManager = new LookUpManager();
        }
        if (dailyWorkerManager == null) {
            dailyWorkerManager = new DailyWorkerManager();
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

    public void drlZoneCity_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                setWoredaList(lookUpManager.readWoredaAndZone(vce.getNewValue().toString()));
            }
        } catch (Exception ex) {
        }
    }

    public void drlWoredaSubCity_processValueChange(ValueChangeEvent vce) {
        try {
            setKebeleList(lookUpManager.readKebelleInSubCity(vce.getNewValue().toString()));
        //kebeleList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());
        } catch (Exception ex) {
        }
    }

    public String btnAddToTable_action() {
        if (isEntryValid()) {
            String gender = "";
            if (chkFemale.isSelected()) {
                gender = "Female";
            } else if (chkMale.isSelected()) {
                gender = "Male";
            }
            getListOfDailyWorker().add(new DailyWorker(
                    txtWillFirstName.getValue().toString(),
                    txtWillMiddelName.getValue().toString(),
                    txtWillLastName.getValue().toString(),
                    txtWillFirstName.getValue().toString() + " " +
                    txtWillMiddelName.getValue().toString() + " " +
                    txtWillLastName.getValue().toString(),
                    drlJob.getValue().toString(),
                    jobId,
                    gender,
                    txtRegistrationDate.getValue().toString(),
                    drlRegion.getValue().toString(),
                    drlZoneCity.getValue().toString(),
                    drlWoredaSubCity.getValue().toString(),
                    "",
                    "",
                    "",
                    drlKebele.getValue().toString(),
                    txtWillHouseNumber.getValue().toString(),
                    dailyWorkId));
            clearConmponmt();
        }

        //return null means stay on the same page
        return null;
    }

    public boolean isEntryValid() {
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
                HRValidation.validateData(this.txtRegistrationDate.getValue(), HRValidation.DATE_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            if (errorValue == 1) {
                ((UIInput) txtRegistrationDate).setValid(false);
                error(txtRegistrationDate, errorMessage);
            } else {
                ((UIInput) txtRegistrationDate).setValid(false);
                error(txtRegistrationDate, "Invalid Value");
            }

        }


        if (!HRValidation.validateRequired(drlTitle.getValue())) {
            result = false;
            ((UIInput) drlTitle).setValid(false);
            error(drlTitle, errorMessage);
        }



        if (!chkFemale.isSelected() && !chkFemale.isSelected()) {
            result = false;
            ((UIInput) chkFemale).setValid(false);
            error(chkFemale, errorMessage);
        }
        return result;
    }

    public void chkFemale_processValueChange(ValueChangeEvent vce) {
        chkMale.setSelected(false);
    }

    public void chkMale_processValueChange(ValueChangeEvent vce) {
        chkFemale.setSelected(false);
    }

    public String lnkJob_action() {
        pnlPopUpRecruitmentType.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    private HashMap listOfRequrementType() {
        HashMap hm = new HashMap();
        hm.put("departemnt",departmentId);
        hm.put("job", jobCode);
        hm.put("startDate", txtStartDate.getValue().toString());
        hm.put("endDate", txtEndDate.getValue().toString());
        hm.put("dailyPayment", txtDailyPayment.getValue().toString());
        hm.put("description", txtDescription.getValue().toString());
        return hm;

    }

    private ArrayList<HashMap> listOfDailyWorkerInfo() {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        for (DailyWorker dailyWorker : getListOfDailyWorker()) {
            HashMap hm = new HashMap();
            hm.put("firstName", dailyWorker.getFirstName());
            hm.put("middleName", dailyWorker.getMiddleName());
            hm.put("lastName", dailyWorker.getLastName());
            hm.put("gender", dailyWorker.getGender());
            hm.put("region", dailyWorker.getRegion());
            hm.put("zoneorCity", dailyWorker.getZoneorCity());
            hm.put("woredaorSubCity", dailyWorker.getWoredaorSubCity());
            hm.put("kebele", dailyWorker.getKebele());
            hm.put("houseNumber", dailyWorker.getHouseNumber());
            hm.put("registrationDate", dailyWorker.getRegistrationDate());
            hm.put("jobId", dailyWorker.getJob());
            list.add(hm);
        }


        return list;

    }

    private boolean isDataEntryValid() {

        ComponentValidator validator = new ComponentValidator();        
        validator.addComponent(txtStartDate, ComponentValidator.GC_DATE, true);
        validator.addComponent(txtEndDate, ComponentValidator.GC_DATE, true);
        validator.addComponent(txtDailyPayment, ComponentValidator.FLOAT_NUMBER, true);
//        validator.addComponent(txtDescription, ComponentValidator.REMARK_COMMENT, false);
//        List<Object> itemList = new ArrayList<Object>();
//        itemList.add("INSA");
//        itemList.add("Software");
//        itemList.add("Project");

        return validator.isAllComponenetValid();
    }

    public String btnSaveType_action() {
        if (isDataEntryValid()) {
            if (dailyWorkerManager.saveRequritementType(listOfRequrementType())) {
                showSuccessOrFailureMessage(true, "Requirement Type Information Saved Successfully.");
                pnlPopUpRecruitmentType.setRendered(false);
            } else {
                showSuccessOrFailureMessage(false, "Requirement Type not Saved.Please try Again");
            }
        } else {
            showSuccessOrFailureMessage(false, "Your Input Is Not Valid .Please Correct Input Value and try Again");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnUpdateType_action() {
        if (dailyWorkerManager.updateRequritementType(listOfRequrementType())) {
        }
        //return null means stay on the same page
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                txtStartDate.setValue(sdf.format(vce.getNewValue()));
                calStartDate.setRendered(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                txtEndDate.setValue(sdf.format(vce.getNewValue()));
                calEndDate.setRendered(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String btnStartDate_action() {
        calStartDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnEndDate_action() {
        calEndDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseRetireType_action() {
        pnlPopUpRecruitmentType.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {

        if (dailyWorkerManager.saveDailyWorkerInformation(listOfDailyWorkerInfo())) {
            showSuccessOrFailureMessage(true, "Daily Worker Employee Information Saved " +
                    " Successfully .");
        } else {
            showSuccessOrFailureMessage(true, "Daily Worker Employee Information Not Saved.Please Try Again!");
        }

        //return null means stay on the same page
        return null;
    }

    public void drlJob_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                ArrayList<HashMap> list = dailyWorkerManager.getListODayilyWorker(vce.getNewValue().toString());

                for (HashMap hm : list) {
                    getListOfDailyWorker().add(new DailyWorker(
                            hm.get("FIRSTNAME").toString(),
                            hm.get("Middelname").toString(),
                            hm.get("LASTNAME").toString(),
                            hm.get("FULLNAME").toString(),
                            vce.getNewValue().toString(),
                            jobId,
                            hm.get("GENDER").toString(),
                            hm.get("REGISTRATIONDATE").toString(),
                            hm.get("Region").toString(),
                            hm.get("Zoneorcity").toString(),
                            hm.get("Woreda").toString(),
                            hm.get("Zone_Or_City_Name").toString(),
                            hm.get("Woreda_Or_Subcity_Name").toString(),
                            hm.get("Kebele").toString(),
                            hm.get("KEBELLE_NAME").toString(),
                            hm.get("Housenumber").toString(),
                            hm.get("ID").toString()));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rowSelectorEmployeeWill_processMyEvent(RowSelectorEvent rse) {
        try {
            txtWillFirstName.resetValue();
            txtWillMiddelName.resetValue();
            txtWillLastName.resetValue();
            txtRegistrationDate.resetValue();
            selectedDilyWorkerRow = rse.getRow();
            DailyWorker dailyWorkerObj = (DailyWorker) this.getListOfDailyWorker().get(selectedDilyWorkerRow);
            txtWillFirstName.setValue(dailyWorkerObj.getFirstName());
            txtWillMiddelName.setValue(dailyWorkerObj.getMiddleName());
            txtWillLastName.setValue(dailyWorkerObj.getLastName());
            txtRegistrationDate.setValue(dailyWorkerObj.getRegistrationDate());
            if (dailyWorkerObj.getGender().equals("Female")) {
                chkFemale.setSelected(true);
            } else if (dailyWorkerObj.getGender().equals("Male")) {
                chkMale.setSelected(true);
            }
            drlRegion.setValue(dailyWorkerObj.getRegion());
            if (!dailyWorkerObj.getRegion().equals("Not Register")) {
                setZoneorCityList(lookUpManager.readZoneOrCityInARegion(dailyWorkerObj.getRegion()));
                if (!dailyWorkerObj.getZoneorCity().equals("Not Register")) {
                    drlZoneCity.setValue(dailyWorkerObj.getZoneorCity());
                    setWoredaList(lookUpManager.readWoredaAndZone(dailyWorkerObj.getZoneorCity()));
                    if (!dailyWorkerObj.getWoredaorSubCity().equals("Not Register")) {
                        setKebeleList(lookUpManager.readKebelleInSubCity(dailyWorkerObj.getWoredaorSubCity()));
                        if (dailyWorkerObj.getKebele().equals("Not Register")) {
                            drlKebele.setValue(dailyWorkerObj.getKebele());
                        }
                    }
                }
            }
            txtWillHouseNumber.setValue(dailyWorkerObj.getHouseNumber());
            dailyWorkId = dailyWorkerObj.getDailyWorkId();
            enableConmponmt();
        } catch (Exception e) {
        }

    }

    private void enableConmponmt() {
        txtWillFirstName.setDisabled(false);
        txtWillMiddelName.setDisabled(false);
        txtWillLastName.setDisabled(false);
        txtWillFirstName.setDisabled(false);
        txtWillMiddelName.setDisabled(false);
        txtWillLastName.setDisabled(false);
        drlJob.setDisabled(false);
        chkMale.setDisabled(false);
        chkFemale.setDisabled(false);
        txtRegistrationDate.setDisabled(false);
        drlRegion.setDisabled(false);
        drlZoneCity.setDisabled(false);
        drlWoredaSubCity.setDisabled(false);
        drlKebele.setDisabled(false);
        txtWillHouseNumber.setDisabled(false);
        drlTitle.setDisabled(false);
    }

    private void disableConmponmt() {
        txtWillFirstName.setDisabled(true);
        txtWillMiddelName.setDisabled(true);
        txtWillLastName.setDisabled(true);
        txtWillFirstName.setDisabled(true);
        txtWillMiddelName.setDisabled(true);
        txtWillLastName.setDisabled(true);
        drlTitle.setDisabled(true);
        chkMale.setDisabled(true);
        chkFemale.setDisabled(true);
        txtRegistrationDate.setDisabled(true);
        drlRegion.setDisabled(true);
        drlZoneCity.setDisabled(true);
        drlWoredaSubCity.setDisabled(true);
        drlKebele.setDisabled(true);
        txtWillHouseNumber.setDisabled(true);
    }

    private void clearConmponmt() {
        txtWillFirstName.setValue("");
        txtWillMiddelName.setValue("");
        txtWillLastName.setValue("");
        txtWillFirstName.setValue("");
        txtWillMiddelName.setValue("");
        txtWillLastName.setValue("");
        drlJob.setValue("");
        chkMale.setSelected(false);
        chkFemale.setSelected(false);
        txtRegistrationDate.setValue("");
        drlRegion.setValue("");
        drlZoneCity.setValue("");
        drlWoredaSubCity.setValue("");
        drlKebele.setValue("");
        selectOneMenu1Bean.setSelectedObject(null);
        selectOneMenu4Bean.setSelectedObject(null);
        selectOneMenu3Bean.setSelectedObject(null);
        selectOneMenu2Bean.setSelectedObject(null);
        defaultSelectedData3.setSelectedObject(null);
        txtWillHouseNumber.setValue("");
    }

    private HashMap updateListOfDailyWorkerInfo() {

        HashMap hm = new HashMap();
        hm.put("firstName", txtWillFirstName.getValue().toString());
        hm.put("middleName", txtWillMiddelName.getValue().toString());
        hm.put("lastName", txtWillLastName.getValue().toString());
        if (chkFemale.isSelected()) {
            hm.put("gender", "Female");
        } else {
            hm.put("gender", "Male");
        }

        hm.put("region", drlRegion.getValue().toString());
        hm.put("zoneorCity", drlZoneCity.getValue().toString());
        hm.put("woredaorSubCity", drlWoredaSubCity.getValue().toString());
        hm.put("kebele", drlKebele.getValue().toString());
        hm.put("houseNumber", txtWillHouseNumber.getValue().toString());
        hm.put("registrationDate", txtRegistrationDate.getValue().toString());
        hm.put("jobId", drlJob.getValue().toString());
        hm.put("titleId", drlTitle.getValue().toString());

        hm.put("dilyWorkerId", dailyWorkId);




        return hm;

    }

    public String btnUpdate_action() {
        if (dailyWorkerManager.updateDailyWorkerInformation(updateListOfDailyWorkerInfo())) {
            showSuccessOrFailureMessage(true, "Daily Worker Employee Information Updated " +
                    " Successfully .");
        } else {
            showSuccessOrFailureMessage(false, "Error Occured During Updating Daily Worker Information.Please try Again");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        employeePlanPopUpMsg.setRendered(true);
        lblemployeePopUpMsgMain.setValue("Are you sure you want to delete Daily Worker Information ?");
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpNo_action() {
        employeePlanPopUpMsg.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btntemployeePopUpYes_action() {
        if (dailyWorkerManager.deleteDailyWorkerInformation(dailyWorkId)) {
            showSuccessOrFailureMessage(true, "Daily Worker Information Deleted " +
                    " Successfully .");
        } else {
            showSuccessOrFailureMessage(false, "Daily Worker Information Not Deleted. " +
                    " Please try Again ?");
        }
        //return null means stay on the same page
        return null;
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

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnNew_action() {
        enableConmponmt();
        clearConmponmt();
        //return null means stay on the same page
        return null;
    }

    public String btnTree_action() {
         porganazationSturctue.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupOrganazation_action() {
        porganazationSturctue.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void commandLink1_processAction(ActionEvent ae) {
        String departmentName;
        String department = tree1.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];

            departmentId = Integer.parseInt(_department[1].trim());

            txtDepartemnt.setValue(departmentName);


            if (departmentId != 0) {
                this.setPerofation(departmentManage.readJobCodeNew(String.valueOf(departmentId)));
            } else {
                this.setPerofation(departmentManage.onDisplayJob());
            }


        }
    }

    public void drl_Position_processValueChange(ValueChangeEvent vce) {
        String Position = vce.getNewValue().toString();
        String[] positionCode = Position.split("-");
        jobCode = positionCode[0];
        String description = positionCode[1];
        txtPostion.setValue(description);
        porganazationSturctue.setRendered(false);
    }

    public String bntWillSave_action() {
           calRegisterDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void calRegisterDate_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()!=null){
            txtRegistrationDate.setValue(sdf.format(vce.getNewValue()));
             calRegisterDate.setRendered(false);
             
        }
    }
}

